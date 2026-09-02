package godot.gradle.tasks.android

import godot.gradle.GodotPlugin
import godot.gradle.projectExt.godotJvmExtension
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

abstract class CreateMainDexFileTask : DefaultTask() {
    @get:InputFile
    abstract val mainJar: RegularFileProperty

    @get:InputFile
    abstract val bootstrapJar: RegularFileProperty

    @get:OutputFile
    abstract val mainDexRulesFile: RegularFileProperty

    @get:OutputFile
    abstract val mainDexFile: RegularFileProperty

    @get:Input
    @get:Optional
    abstract val d8ToolPath: Property<String>

    @get:Input
    @get:Optional
    abstract val androidJarPath: Property<String>

    @get:Input
    abstract val androidMinApiLevel: Property<Int>

    @TaskAction
    fun createMainDexFile() {
        val libsDir = mainJar.get().asFile.parentFile
        val mainDexRules = writeMainDexRules(mainDexRulesFile.get().asFile)
        val d8Arguments = listOf(
            File(d8ToolPath.get()).absolutePath,
            mainJar.get().asFile.absolutePath,
            "--lib",
            androidJarPath.get(),
            "--classpath",
            bootstrapJar.get().asFile.absolutePath,
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
            .directory(libsDir)
            .redirectErrorStream(true)
            .start()
        val output = process.inputStream.bufferedReader().readText()
        val exitCode = process.waitFor()

        require(exitCode == 0) {
            "Failed to create the main dex file (exit code $exitCode). Command: ${command.joinToString(" ")}\n$output"
        }
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

fun Project.createMainDexFileTask(
    checkAndroidJarAccessibleTask: TaskProvider<out Task>,
    checkD8ToolAccessibleTask: TaskProvider<out Task>,
    createBootstrapDexJarTask: TaskProvider<out Task>,
    packageMainJarTask: TaskProvider<out Task>
): TaskProvider<out Task> {
    val libsDirectory = layout.buildDirectory.dir("libs")
    val d8ToolPath = godotJvmExtension.android.d8ToolPath
    val androidCompileSdkDirectory = godotJvmExtension.android.compileSdkDirectory
    val androidMinApiLevel = godotJvmExtension.android.minApiLevel

    return tasks.register("createMainDexFile", CreateMainDexFileTask::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Converts the main.jar to an android dex file. Needed for android builds only"

            dependsOn(
                checkD8ToolAccessibleTask,
                checkAndroidJarAccessibleTask,
                createBootstrapDexJarTask,
                packageMainJarTask,
            )

            this.mainJar.set(libsDirectory.map { directory -> directory.file("main.jar") })
            this.bootstrapJar.set(libsDirectory.map { directory -> directory.file("godot-bootstrap.jar") })
            this.mainDexRulesFile.set(layout.buildDirectory.file("main-dex-rules.proguard"))
            this.mainDexFile.set(libsDirectory.map { directory -> directory.file("classes.dex") })
            this.d8ToolPath.set(d8ToolPath)
            this.androidJarPath.set(androidCompileSdkDirectory.map { compileSdkDirectory ->
                File(compileSdkDirectory).resolve("android.jar").absolutePath
            })
            this.androidMinApiLevel.set(androidMinApiLevel)
        }
    }
}
