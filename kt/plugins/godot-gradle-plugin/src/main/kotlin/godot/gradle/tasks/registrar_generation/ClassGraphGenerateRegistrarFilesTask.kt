package godot.gradle.tasks

import godot.annotation.processor.classgraph.AnnotationProcessingMode
import godot.annotation.processor.classgraph.ClassGraphProcessor
import godot.annotation.processor.classgraph.ProcessorSettings
import godot.gradle.projectExt.godotJvmExtension
import godot.registration.model.ModelCheck
import godot.registration.model.checks.ChecksFailedException
import godot.registration.model.logging.LoggerWrapper
import godot.registration.model.types.ScriptClass
import godot.registrar.generator.RegisteredNameMode
import godot.registrar.generator.RegistrarGenerator
import godot.registrar.generator.RegistrationFileIndentation
import godot.registrar.generator.RegistrationFileLayoutMode
import godot.registrar.generator.Settings
import godot.registrar.generator.ext.getRegisteredName
import godot.tools.common.constants.godotRegistrationPackage
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileType
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.gradle.work.Incremental
import org.gradle.work.InputChanges
import java.io.File

private const val registrarServiceName = "$godotRegistrationPackage.ClassRegistrar"

@CacheableTask
abstract class ClassGraphGenerateRegistrarFilesTask : DefaultTask() {
    @get:Classpath
    abstract val userCodeClassPathRoots: ConfigurableFileCollection

    @get:Incremental
    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val userCompiledClasses: ConfigurableFileCollection

    @get:Classpath
    abstract val runtimeClassPathFiles: ConfigurableFileCollection

    @get:Input
    abstract val registeredNameMode: Property<RegisteredNameMode>

    @get:Input
    abstract val projectName: Property<String>

    @get:Input
    abstract val registrationFileLayoutMode: Property<RegistrationFileLayoutMode>

    @get:Input
    abstract val registrationFileIndentation: Property<RegistrationFileIndentation>

    @get:Input
    abstract val disableGdj: Property<Boolean>

    @get:Input
    abstract val fullRebuildThreshold: Property<Int>

    @get:Input
    abstract val annotationProcessingMode: Property<AnnotationProcessingMode>

    @get:OutputDirectory
    abstract val generatedSourceRootDir: DirectoryProperty

    @get:OutputDirectory
    abstract val generatedRegistrationFilesRootDir: DirectoryProperty

    @get:OutputFile
    abstract val generatedRegistrarManifestFile: RegularFileProperty

    @get:OutputFile
    abstract val runtimeClasspathSnapshotFile: RegularFileProperty

    @TaskAction
    fun generate(inputChanges: InputChanges) {
        val outputRoot = generatedSourceRootDir.get().asFile
        val generatedRegistrationRoot = generatedRegistrationFilesRootDir.get().asFile
        val manifestFile = generatedRegistrarManifestFile.get().asFile
        val runtimeClasspathSnapshotFile = runtimeClasspathSnapshotFile.get().asFile
        val previousManifest = readGeneratedRegistrarManifest(manifestFile)
        val settings = buildGeneratorSettings()
        val processorSettings = buildProcessorSettings()
        val runtimeClassPath = runtimeClassPathFiles.files.map { it.canonicalFile }.toSet()
        val currentRuntimeClasspathSnapshot = runtimeClassPath.toRuntimeClasspathSnapshot()
        val previousRuntimeClasspathSnapshot = readRuntimeClasspathSnapshot(runtimeClasspathSnapshotFile)
        val modelLogger = LoggerWrapper(logger)

        val changedFiles = if (inputChanges.isIncremental) {
            inputChanges.getFileChanges(userCompiledClasses).toList()
        } else {
            emptyList()
        }
        val changedClassNames = changedFiles
            .asSequence()
            .filter { change -> change.fileType == FileType.FILE }
            .mapNotNull { change -> classNameForClassFile(change.file) }
            .toSet()

        val shouldRunFullGeneration = !inputChanges.isIncremental ||
            !manifestFile.isFile ||
            !hasCompletePreviousOutputs(previousManifest, outputRoot, generatedRegistrationRoot) ||
            previousRuntimeClasspathSnapshot != currentRuntimeClasspathSnapshot ||
            changedClassNames.isEmpty() ||
            changedClassNames.size > fullRebuildThreshold.get()

        if (shouldRunFullGeneration) {
            runFullGeneration(
                outputRoot = outputRoot,
                generatedRegistrationRoot = generatedRegistrationRoot,
                manifestFile = manifestFile,
                runtimeClasspathSnapshotFile = runtimeClasspathSnapshotFile,
                runtimeClassPath = runtimeClassPath,
                currentRuntimeClasspathSnapshot = currentRuntimeClasspathSnapshot,
                processorSettings = processorSettings,
                settings = settings,
                modelLogger = modelLogger,
            )
        } else {
            runIncrementalGeneration(
                outputRoot = outputRoot,
                generatedRegistrationRoot = generatedRegistrationRoot,
                previousManifest = previousManifest,
                manifestFile = manifestFile,
                runtimeClasspathSnapshotFile = runtimeClasspathSnapshotFile,
                runtimeClassPath = runtimeClassPath,
                currentRuntimeClasspathSnapshot = currentRuntimeClasspathSnapshot,
                changedClassNames = changedClassNames,
                processorSettings = processorSettings,
                settings = settings,
                modelLogger = modelLogger,
            )
        }
    }

    private fun runFullGeneration(
        outputRoot: File,
        generatedRegistrationRoot: File,
        manifestFile: File,
        runtimeClasspathSnapshotFile: File,
        runtimeClassPath: Set<File>,
        currentRuntimeClasspathSnapshot: List<RuntimeClasspathSnapshotEntry>,
        processorSettings: ProcessorSettings,
        settings: Settings,
        modelLogger: LoggerWrapper,
    ) {
        outputRoot.deleteRecursively()
        outputRoot.mkdirs()
        if (!disableGdj.get()) {
            generatedRegistrationRoot.mkdirs()
        }

        val serviceFile = registrarServiceFile(outputRoot)
        val scriptClasses = ClassGraphProcessor.process(
            runtimeClassPathFiles = runtimeClassPath,
            settings = processorSettings,
        )
        val allRegisteredClasses = scriptClasses.filter { scriptClass -> scriptClass.isRegistered }

        validateRegisteredClasses(allRegisteredClasses, settings, modelLogger)

        RegistrarGenerator.generateClassArtifacts(
            settings = settings,
            logger = modelLogger,
            scriptClasses = scriptClasses,
            sourceOutputDir = outputRoot.resolve("main").resolve("kotlin"),
            registrationOutputDir = generatedRegistrationRoot.takeUnless { disableGdj.get() },
        )

        val manifestEntries = allRegisteredClasses.map { scriptClass ->
            scriptClass.toGeneratedRegistrarManifestEntry(
                settings = settings,
                includeRegistrationFile = !disableGdj.get(),
            )
        }
        writeRegistrarServiceFile(serviceFile, manifestEntries)
        writeGeneratedRegistrarManifest(manifestFile, manifestEntries)
        writeRuntimeClasspathSnapshot(runtimeClasspathSnapshotFile, currentRuntimeClasspathSnapshot)
    }

    private fun runIncrementalGeneration(
        outputRoot: File,
        generatedRegistrationRoot: File,
        previousManifest: Map<String, GeneratedRegistrarManifestEntry>,
        manifestFile: File,
        runtimeClasspathSnapshotFile: File,
        runtimeClassPath: Set<File>,
        currentRuntimeClasspathSnapshot: List<RuntimeClasspathSnapshotEntry>,
        changedClassNames: Set<String>,
        processorSettings: ProcessorSettings,
        settings: Settings,
        modelLogger: LoggerWrapper,
    ) {
        val serviceFile = registrarServiceFile(outputRoot)
        val incrementalResult = ClassGraphProcessor.processIncrementally(
            runtimeClassPathFiles = runtimeClassPath,
            settings = processorSettings,
            seedClassNames = changedClassNames,
        )

        val dirtyClassNames = incrementalResult.dirtyClassNames + changedClassNames
        val registeredClasses = incrementalResult.scriptClasses
            .filter { scriptClass -> scriptClass.isRegistered && scriptClass.fqName in dirtyClassNames }
        validateRegisteredClasses(registeredClasses, settings, modelLogger)

        val newEntriesBySourceFqName = registeredClasses
            .associate { scriptClass ->
                scriptClass.fqName to scriptClass.toGeneratedRegistrarManifestEntry(
                    settings = settings,
                    includeRegistrationFile = !disableGdj.get(),
                )
            }

        val remainingManifestEntries = previousManifest
            .filterKeys { sourceFqName -> sourceFqName !in dirtyClassNames }
        val nextManifestEntries = remainingManifestEntries + newEntriesBySourceFqName

        validateRegisteredNames(nextManifestEntries.values, settings)
        deleteDirtyArtifacts(previousManifest, dirtyClassNames, outputRoot, generatedRegistrationRoot)

        RegistrarGenerator.generateClassArtifacts(
            settings = settings,
            logger = modelLogger,
            scriptClasses = incrementalResult.scriptClasses,
            sourceOutputDir = outputRoot.resolve("main").resolve("kotlin"),
            registrationOutputDir = generatedRegistrationRoot.takeUnless { disableGdj.get() },
            generatedClassFqNames = dirtyClassNames,
        )

        writeRegistrarServiceFile(serviceFile, nextManifestEntries.values)
        writeGeneratedRegistrarManifest(manifestFile, nextManifestEntries.values)
        writeRuntimeClasspathSnapshot(runtimeClasspathSnapshotFile, currentRuntimeClasspathSnapshot)
    }

    private fun buildGeneratorSettings() = Settings(
        registeredNameMode = registeredNameMode.get(),
        projectName = projectName.get(),
        registrationFileLayoutMode = registrationFileLayoutMode.get(),
        registrationFileIndentation = registrationFileIndentation.get(),
    )

    private fun buildProcessorSettings() = ProcessorSettings(
        projectName = projectName.get(),
        userCodeClassPathRoots = userCodeClassPathRoots.files.map { it.canonicalFile }.toSet(),
        annotationProcessingMode = annotationProcessingMode.get(),
    )

    private fun registrarServiceFile(outputRoot: File): File = outputRoot
        .resolve("resources")
        .resolve("META-INF")
        .resolve("services")
        .resolve(registrarServiceName)

    private fun validateRegisteredClasses(
        registeredClasses: List<ScriptClass>,
        settings: Settings,
        modelLogger: LoggerWrapper,
    ) {
        val registeredNameProvider = if (settings.registeredNameMode == RegisteredNameMode.SIMPLE_NAME) {
            { registeredClass: ScriptClass -> registeredClass.getRegisteredName(settings) }
        } else {
            null
        }

        if (!ModelCheck.check(registeredClasses, modelLogger, registeredNameProvider)) {
            throw ChecksFailedException()
        }
    }

    private fun validateRegisteredNames(
        manifestEntries: Collection<GeneratedRegistrarManifestEntry>,
        settings: Settings,
    ) {
        if (settings.registeredNameMode != RegisteredNameMode.SIMPLE_NAME) {
            return
        }

        val duplicatesByRegisteredName = manifestEntries
            .groupBy(GeneratedRegistrarManifestEntry::registeredName)
            .filterValues { entries -> entries.size > 1 }

        if (duplicatesByRegisteredName.isEmpty()) {
            return
        }

        duplicatesByRegisteredName.forEach { (registeredName, entries) ->
            logger.error(
                "Multiple registered classes resolve to registered name '$registeredName': " +
                    entries.joinToString(", ") { entry -> entry.sourceFqName }
            )
        }
        throw ChecksFailedException()
    }

    private fun hasCompletePreviousOutputs(
        previousManifest: Map<String, GeneratedRegistrarManifestEntry>,
        outputRoot: File,
        generatedRegistrationRoot: File,
    ): Boolean {
        return previousManifest.values.all { entry ->
            outputRoot.resolve(entry.registrarSourceRelativePath).isFile &&
                (entry.registrationFileRelativePath == null || generatedRegistrationRoot.resolve(entry.registrationFileRelativePath).isFile)
        }
    }

    private fun deleteDirtyArtifacts(
        previousManifest: Map<String, GeneratedRegistrarManifestEntry>,
        dirtyClassNames: Set<String>,
        outputRoot: File,
        generatedRegistrationRoot: File,
    ) {
        dirtyClassNames.forEach { sourceFqName ->
            val previousEntry = previousManifest[sourceFqName] ?: return@forEach
            deleteRelativeFile(outputRoot, previousEntry.registrarSourceRelativePath)
            previousEntry.registrationFileRelativePath?.let { relativePath ->
                deleteRelativeFile(generatedRegistrationRoot, relativePath)
            }
        }
    }

    private fun deleteRelativeFile(rootDir: File, relativePath: String) {
        val targetFile = rootDir.resolve(relativePath)
        if (!targetFile.exists()) {
            return
        }

        if (!targetFile.delete()) {
            logger.warn("Could not delete stale generated file: ${targetFile.absolutePath}")
            return
        }

        cleanupEmptyParents(targetFile.parentFile, rootDir)
    }

    private fun cleanupEmptyParents(currentDir: File?, stopAt: File) {
        var directory = currentDir
        while (directory != null && directory != stopAt) {
            if (!directory.exists() || !directory.isDirectory || directory.listFiles()?.isNotEmpty() == true) {
                return
            }
            if (!directory.delete()) {
                logger.warn("Could not delete empty generated directory: ${directory.absolutePath}")
                return
            }
            directory = directory.parentFile
        }
    }

    private fun writeRegistrarServiceFile(
        serviceFile: File,
        manifestEntries: Collection<GeneratedRegistrarManifestEntry>,
    ) {
        serviceFile.parentFile.mkdirs()
        serviceFile.writeText(
            manifestEntries
                .sortedBy(GeneratedRegistrarManifestEntry::sourceFqName)
                .joinToString(separator = "\n") { entry -> entry.registrarServiceName }
        )
    }

    private fun classNameForClassFile(classFile: File): String? {
        if (!classFile.name.endsWith(".class")) {
            return null
        }

        val classFilePath = classFile.toPath().toAbsolutePath()
        val relativeClassPath = userCodeClassPathRoots.files
            .asSequence()
            .map { rootDir -> rootDir.toPath().toAbsolutePath() }
            .sortedByDescending { rootPath -> rootPath.toString().length }
            .firstNotNullOfOrNull { rootPath ->
                if (classFilePath.startsWith(rootPath)) {
                    rootPath.relativize(classFilePath).toString().replace(File.separatorChar, '/')
                } else {
                    null
                }
            }
            ?: return null

        val binaryClassName = relativeClassPath
            .removeSuffix(".class")
            .replace('/', '.')
            .substringBefore('$')

        return binaryClassName.takeUnless { className ->
            className.isBlank() ||
                className == "module-info" ||
                className == "package-info" ||
                className.endsWith(".package-info")
        }
    }
}

private data class RuntimeClasspathSnapshotEntry(
    val relativePath: String,
    val signature: String,
)

private fun Set<File>.toRuntimeClasspathSnapshot(): List<RuntimeClasspathSnapshotEntry> = asSequence()
    .filter(File::exists)
    .map { classpathEntry ->
        RuntimeClasspathSnapshotEntry(
            relativePath = classpathEntry.canonicalPath,
            signature = classpathEntry.snapshotSignature(),
        )
    }
    .sortedBy(RuntimeClasspathSnapshotEntry::relativePath)
    .toList()

private fun File.snapshotSignature(): String {
    if (isFile) {
        return "file:${length()}:${lastModified()}"
    }

    if (!isDirectory) {
        return "missing"
    }

    val entries = walkTopDown()
        .filter { entry -> entry.isFile }
        .map { entry ->
            val relativePath = entry.relativeTo(this).invariantSeparatorsPath
            "$relativePath:${entry.length()}:${entry.lastModified()}"
        }
        .sorted()
        .toList()

    return "dir:${entries.joinToString("|")}"
}

private fun readRuntimeClasspathSnapshot(snapshotFile: File): List<RuntimeClasspathSnapshotEntry> {
    if (!snapshotFile.isFile) {
        return emptyList()
    }

    return snapshotFile.readLines()
        .asSequence()
        .filter(String::isNotBlank)
        .mapNotNull { line ->
            val separatorIndex = line.indexOf('\t')
            if (separatorIndex <= 0 || separatorIndex == line.lastIndex) {
                null
            } else {
                RuntimeClasspathSnapshotEntry(
                    relativePath = line.substring(0, separatorIndex),
                    signature = line.substring(separatorIndex + 1),
                )
            }
        }
        .toList()
}

private fun writeRuntimeClasspathSnapshot(
    snapshotFile: File,
    snapshotEntries: List<RuntimeClasspathSnapshotEntry>,
) {
    snapshotFile.parentFile.mkdirs()
    snapshotFile.writeText(
        snapshotEntries.joinToString(separator = "\n", postfix = if (snapshotEntries.isNotEmpty()) "\n" else "") { entry ->
            "${entry.relativePath}\t${entry.signature}"
        }
    )
}

fun Project.registrarGenerationGenerateFilesTask(
    classesTask: TaskProvider<out Task>,
): TaskProvider<ClassGraphGenerateRegistrarFilesTask> {
    val mainSourceSet = extensions
        .getByType(SourceSetContainer::class.java)
        .getByName("main")
    val generatedSourceRootDir = layout.buildDirectory.dir("generated/registrar-generation")
    val generatedRegistrationRootDir = layout.buildDirectory.dir("generated/registrar-generation/registration")

    return tasks.register(
        "registrarGenerationGenerateFiles",
        ClassGraphGenerateRegistrarFilesTask::class.java
    ) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Generates registrar sources/resources plus staged .gdj files from compiled user code."
        task.dependsOn(classesTask)
        task.userCodeClassPathRoots.from(mainSourceSet.output.classesDirs)
        task.userCompiledClasses.from(mainSourceSet.output.classesDirs.asFileTree.matching { patternFilterable ->
            patternFilterable.include("**/*.class")
        })
        task.runtimeClassPathFiles.from(mainSourceSet.compileClasspath)
        task.runtimeClassPathFiles.from(mainSourceSet.output.classesDirs)
        task.registeredNameMode.convention(godotJvmExtension.registration.nameMode)
        task.projectName.convention(
            providers.provider { project.name.replace(" ", "_") }
        )
        task.registrationFileLayoutMode.convention(godotJvmExtension.registration.gdjFilesLayoutMode)
        task.registrationFileIndentation.convention(godotJvmExtension.registration.gdjFilesIndentation)
        task.disableGdj.convention(godotJvmExtension.registration.disableGdj)
        task.fullRebuildThreshold.convention(godotJvmExtension.registration.incrementalFullBuildThreshold)
        task.annotationProcessingMode.convention(godotJvmExtension.registration.annotationProcessingMode)
        task.generatedSourceRootDir.convention(generatedSourceRootDir)
        task.generatedRegistrationFilesRootDir.convention(generatedRegistrationRootDir)
        task.generatedRegistrarManifestFile.convention(
            layout.buildDirectory.file("intermediates/registrar-generation/generated-artifacts.idx")
        )
        task.runtimeClasspathSnapshotFile.convention(
            layout.buildDirectory.file("intermediates/registrar-generation/runtime-classpath.idx")
        )
    }
}
