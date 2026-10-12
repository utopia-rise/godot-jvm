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
import godot.tools.common.constants.godotRegistrarBasePackage
import godot.tools.common.constants.godotRegistrationPackage
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import java.io.File

private const val registrarServiceName = "$godotRegistrationPackage.ClassRegistrar"

@CacheableTask
abstract class ClassGraphGenerateRegistrarFilesTask : DefaultTask() {
    @get:Classpath
    abstract val userCodeClassPathRoots: ConfigurableFileCollection

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
    abstract val annotationProcessingMode: Property<AnnotationProcessingMode>

    @get:OutputDirectory
    abstract val generatedSourceRootDir: DirectoryProperty

    @get:OutputDirectory
    abstract val generatedRegistrationFilesRootDir: DirectoryProperty

    @TaskAction
    fun generate() {
        val outputRoot = generatedSourceRootDir.get().asFile
        val generatedRegistrationRoot = generatedRegistrationFilesRootDir.get().asFile
        val settings = Settings(
            registeredNameMode = registeredNameMode.get(),
            projectName = projectName.get(),
            registrationFileLayoutMode = registrationFileLayoutMode.get(),
            registrationFileIndentation = registrationFileIndentation.get(),
        )
        val processorSettings = ProcessorSettings(
            projectName = projectName.get(),
            userCodeClassPathRoots = userCodeClassPathRoots.files.map { it.canonicalFile }.toSet(),
            annotationProcessingMode = annotationProcessingMode.get(),
        )
        val modelLogger = LoggerWrapper(logger)

        outputRoot.deleteRecursively()
        outputRoot.mkdirs()
        if (!disableGdj.get()) {
            generatedRegistrationRoot.mkdirs()
        }

        val scriptClasses = ClassGraphProcessor.process(
            runtimeClassPathFiles = runtimeClassPathFiles.files.map { it.canonicalFile }.toSet(),
            settings = processorSettings,
        )
        val registeredClasses = scriptClasses.filter { scriptClass -> scriptClass.isRegistered }
        validateRegisteredClasses(registeredClasses, settings, modelLogger)

        RegistrarGenerator.generateClassArtifacts(
            settings = settings,
            logger = modelLogger,
            scriptClasses = scriptClasses,
            sourceOutputDir = outputRoot.resolve("main").resolve("kotlin"),
            registrationOutputDir = generatedRegistrationRoot.takeUnless { disableGdj.get() },
        )
        writeRegistrarServiceFile(outputRoot, registeredClasses, settings)
    }

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

    private fun writeRegistrarServiceFile(outputRoot: File, registeredClasses: List<ScriptClass>, settings: Settings) {
        val serviceFile = outputRoot
            .resolve("resources")
            .resolve("META-INF")
            .resolve("services")
            .resolve(registrarServiceName)
        serviceFile.parentFile.mkdirs()
        serviceFile.writeText(
            registeredClasses
                .map { scriptClass -> "$godotRegistrarBasePackage.${scriptClass.getRegisteredName(settings)}Registrar" }
                .sorted()
                .joinToString(separator = "\n")
        )
    }
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
        task.runtimeClassPathFiles.from(mainSourceSet.compileClasspath)
        task.runtimeClassPathFiles.from(mainSourceSet.output.classesDirs)
        task.registeredNameMode.convention(godotJvmExtension.registration.nameMode)
        task.projectName.convention(
            providers.provider { project.name.replace(" ", "_") }
        )
        task.registrationFileLayoutMode.convention(godotJvmExtension.registration.gdjFilesLayoutMode)
        task.registrationFileIndentation.convention(godotJvmExtension.registration.gdjFilesIndentation)
        task.disableGdj.convention(godotJvmExtension.registration.disableGdj)
        task.annotationProcessingMode.convention(godotJvmExtension.registration.annotationProcessingMode)
        task.generatedSourceRootDir.convention(generatedSourceRootDir)
        task.generatedRegistrationFilesRootDir.convention(generatedRegistrationRootDir)
    }
}
