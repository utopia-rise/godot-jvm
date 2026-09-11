package godot.gradle.tasks.android

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.GodotPlugin
import godot.gradle.projectExt.GODOT_SINGLE_CONFIGURATION
import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.projectExt.variantLibsDirectory
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFile
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

/**
 * Dexes one program jar and repacks its non-class entries next to the produced dex files, because ART
 * cannot load a plain jar.
 */
abstract class CreateDexJarTask : DefaultTask() {
    @get:InputFile
    abstract val inputJar: RegularFileProperty

    // ART cannot load plain jars, so godotSingle dependencies are dexed together with the program jar.
    @get:InputFiles
    abstract val additionalInputJars: ConfigurableFileCollection

    @get:OutputFile
    abstract val mainDexRulesFile: RegularFileProperty

    @get:OutputFile
    abstract val dexJar: RegularFileProperty

    @get:Input
    @get:Optional
    abstract val d8ToolPath: Property<String>

    @get:Input
    @get:Optional
    abstract val androidJarPath: Property<String>

    @get:Input
    abstract val androidMinApiLevel: Property<Int>

    @TaskAction
    fun createDexJar() {
        val inputJarFile = inputJar.get().asFile
        val workingDirectory = inputJarFile.parentFile
        val dexOutputJar = dexJar.get().asFile
        val dexOutputDirectory = workingDirectory.resolve(dexOutputJar.nameWithoutExtension)
        val mainDexRules = writeMainDexRules(mainDexRulesFile.get().asFile)

        dexOutputDirectory.deleteRecursively()
        dexOutputDirectory.mkdirs()

        val inputJars = listOf(inputJarFile) + additionalInputJars.files.sortedBy(File::getName)
        val d8Arguments = listOf(File(d8ToolPath.get()).absolutePath) +
            inputJars.map(File::getAbsolutePath) +
            listOf(
                "--output",
                dexOutputDirectory.absolutePath,
                "--lib",
                androidJarPath.get(),
                "--min-api",
                androidMinApiLevel.get().toString(),
                "--main-dex-rules",
                mainDexRules.absolutePath,
            )
        val command = if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
            listOf("cmd.exe", "/c", "\"${d8Arguments.joinToString(" ") { "\"$it\"" }}\"")
        } else {
            d8Arguments
        }

        val process = ProcessBuilder(command)
            .directory(workingDirectory)
            .redirectErrorStream(true)
            .start()
        val output = process.inputStream.bufferedReader().readText()
        val exitCode = process.waitFor()

        require(exitCode == 0) {
            "Failed to create ${dexOutputJar.name} (exit code $exitCode). Command: ${command.joinToString(" ")}\n$output"
        }

        dexOutputJar.delete()
        ZipOutputStream(FileOutputStream(dexOutputJar)).use { zipOutput ->
            dexOutputDirectory.walkTopDown()
                .filter(File::isFile)
                .forEach { file ->
                    val entryName = file.relativeTo(dexOutputDirectory).invariantSeparatorsPath
                    zipOutput.putNextEntry(ZipEntry(entryName))
                    file.inputStream().use { it.copyTo(zipOutput) }
                    zipOutput.closeEntry()
                }

            val writtenEntries = mutableSetOf<String>()
            inputJars.forEach { inputJar ->
                ZipFile(inputJar).use { input ->
                    input.entries().asSequence()
                        .filter { entry ->
                            !entry.isDirectory &&
                                !entry.name.endsWith(".class") &&
                                entry.name != "META-INF/MANIFEST.MF" &&
                                writtenEntries.add(entry.name)
                        }
                        .forEach { entry ->
                            zipOutput.putNextEntry(ZipEntry(entry.name))
                            input.getInputStream(entry).use { it.copyTo(zipOutput) }
                            zipOutput.closeEntry()
                        }
                }
            }
        }
        dexOutputDirectory.deleteRecursively()
    }
}

private fun writeMainDexRules(targetFile: File): File {
    targetFile.parentFile.mkdirs()
    targetFile.outputStream().use { outputStream ->
        requireNotNull(GodotPlugin::class.java.getResourceAsStream("android/main-dex-rules.proguard"))
            .copyTo(outputStream)
    }
    return targetFile
}

fun Project.createBootstrapDexJarTask(
    checkAndroidJarAccessibleTask: TaskProvider<out Task>,
    checkD8ToolAccessibleTask: TaskProvider<out Task>,
    packageBootstrapJarTask: TaskProvider<ShadowJar>,
): TaskProvider<CreateDexJarTask> = registerDexJarTask(
    name = "createBootstrapDexJar",
    description = "Converts the godot-bootstrap.jar to an android compatible version. Needed for android builds only",
    dependsOnTasks = listOf(checkD8ToolAccessibleTask, checkAndroidJarAccessibleTask),
    inputJar = packageBootstrapJarTask.flatMap(ShadowJar::getArchiveFile),
    dexJarName = ArtifactNames.Debug.BOOTSTRAP_DEX_JAR,
    mainDexRulesFileName = "main-dex-rules.proguard",
    includeGodotSingleJars = false,
)

fun Project.createReleaseDexJarTask(
    checkAndroidJarAccessibleTask: TaskProvider<out Task>,
    checkD8ToolAccessibleTask: TaskProvider<out Task>,
    packageReleaseJarTask: TaskProvider<ShadowJar>,
): TaskProvider<CreateDexJarTask> = registerDexJarTask(
    name = "createReleaseDexJar",
    description = "Converts the release ${ArtifactNames.Release.JAR} to an android compatible version. Needed for android builds only",
    dependsOnTasks = listOf(checkD8ToolAccessibleTask, checkAndroidJarAccessibleTask),
    inputJar = packageReleaseJarTask.flatMap(ShadowJar::getArchiveFile),
    dexJarName = ArtifactNames.Release.DEX_JAR,
    mainDexRulesFileName = "main-dex-rules.proguard",
    includeGodotSingleJars = true,
)

private fun Project.registerDexJarTask(
    name: String,
    description: String,
    dependsOnTasks: List<TaskProvider<out Task>>,
    inputJar: Provider<RegularFile>,
    dexJarName: String,
    mainDexRulesFileName: String,
    includeGodotSingleJars: Boolean,
): TaskProvider<CreateDexJarTask> {
    val libsDirectory = variantLibsDirectory()
    val d8ToolPath = godotJvmExtension.android.d8ToolPath
    val androidCompileSdkDirectory = godotJvmExtension.android.compileSdkDirectory
    val androidMinApiLevel = godotJvmExtension.android.minApiLevel

    return tasks.register(name, CreateDexJarTask::class.java) {
        with(it) {
            group = "godot-jvm"
            this.description = description

            dependsOn(dependsOnTasks)

            this.inputJar.set(inputJar)
            if (includeGodotSingleJars) {
                additionalInputJars.from(
                    configurations.getByName(GODOT_SINGLE_CONFIGURATION).filter { file -> file.extension == "jar" }
                )
            }
            mainDexRulesFile.set(layout.buildDirectory.file(mainDexRulesFileName))
            dexJar.set(libsDirectory.map { directory -> directory.file(dexJarName) })
            this.d8ToolPath.set(d8ToolPath)
            this.androidJarPath.set(androidCompileSdkDirectory.map { compileSdkDirectory ->
                File(compileSdkDirectory).resolve("android.jar").absolutePath
            })
            this.androidMinApiLevel.set(androidMinApiLevel)
        }
    }
}
