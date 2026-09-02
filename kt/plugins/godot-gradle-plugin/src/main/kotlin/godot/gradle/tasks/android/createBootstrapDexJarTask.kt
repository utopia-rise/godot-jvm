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
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

abstract class CreateBootstrapDexJarTask : DefaultTask() {
    @get:InputFile
    abstract val bootstrapJar: RegularFileProperty

    @get:OutputFile
    abstract val mainDexRulesFile: RegularFileProperty

    @get:OutputFile
    abstract val bootstrapDexJar: RegularFileProperty

    @get:Input
    @get:Optional
    abstract val d8ToolPath: Property<String>

    @get:Input
    @get:Optional
    abstract val androidJarPath: Property<String>

    @get:Input
    abstract val androidMinApiLevel: Property<Int>

    @TaskAction
    fun createBootstrapDexJar() {
        val libsDir = bootstrapJar.get().asFile.parentFile
        val dexOutputDirectory = libsDir.resolve("godot-bootstrap-dex")
        val dexOutputJar = bootstrapDexJar.get().asFile
        val mainDexRules = writeMainDexRules(mainDexRulesFile.get().asFile)
        dexOutputDirectory.deleteRecursively()
        dexOutputDirectory.mkdirs()
        val d8Arguments = listOf(
            File(d8ToolPath.get()).absolutePath,
            bootstrapJar.get().asFile.absolutePath,
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
            .directory(libsDir)
            .redirectErrorStream(true)
            .start()
        val output = process.inputStream.bufferedReader().readText()
        val exitCode = process.waitFor()

        require(exitCode == 0) {
            "Failed to create the bootstrap dex jar (exit code $exitCode). Command: ${command.joinToString(" ")}\n$output"
        }

        dexOutputJar.delete()
        ZipOutputStream(FileOutputStream(dexOutputJar)).use { output ->
            dexOutputDirectory.walkTopDown()
                .filter(File::isFile)
                .forEach { file ->
                    val entryName = file.relativeTo(dexOutputDirectory).invariantSeparatorsPath
                    output.putNextEntry(ZipEntry(entryName))
                    file.inputStream().use { it.copyTo(output) }
                    output.closeEntry()
                }

            ZipFile(bootstrapJar.get().asFile).use { input ->
                input.entries().asSequence()
                    .filter { !it.isDirectory && !it.name.endsWith(".class") && it.name != "META-INF/MANIFEST.MF" }
                    .forEach { entry ->
                        output.putNextEntry(ZipEntry(entry.name))
                        input.getInputStream(entry).use { it.copyTo(output) }
                        output.closeEntry()
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
    packageBootstrapJarTask: TaskProvider<out Task>
): TaskProvider<out Task> {
    val libsDirectory = layout.buildDirectory.dir("libs")
    val d8ToolPath = godotJvmExtension.d8ToolPath
    val androidCompileSdkDirectory = godotJvmExtension.androidCompileSdkDirectory
    val androidMinApiLevel = godotJvmExtension.androidMinApiLevel

    return tasks.register("createBootstrapDexJar", CreateBootstrapDexJarTask::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Converts the godot-bootstrap.jar to an android compatible version. Needed for android builds only"

            dependsOn(checkD8ToolAccessibleTask, checkAndroidJarAccessibleTask, packageBootstrapJarTask)

            this.bootstrapJar.set(libsDirectory.map { directory -> directory.file("godot-bootstrap.jar") })
            this.mainDexRulesFile.set(layout.buildDirectory.file("main-dex-rules.proguard"))
            this.bootstrapDexJar.set(libsDirectory.map { directory -> directory.file("godot-bootstrap-dex.jar") })
            this.d8ToolPath.set(d8ToolPath)
            this.androidJarPath.set(androidCompileSdkDirectory.map { compileSdkDirectory ->
                File(compileSdkDirectory).resolve("android.jar").absolutePath
            })
            this.androidMinApiLevel.set(androidMinApiLevel)
        }
    }
}
