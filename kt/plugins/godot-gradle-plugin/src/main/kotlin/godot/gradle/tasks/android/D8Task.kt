package godot.gradle.tasks.android

import godot.gradle.GodotPlugin
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

abstract class D8Task : DefaultTask() {
    @get:Input
    @get:Optional
    abstract val d8ToolPath: Property<String>

    @get:Input
    @get:Optional
    abstract val androidJarPath: Property<String>

    @get:Input
    abstract val androidMinApiLevel: Property<Int>

    protected fun runD8(inputArguments: List<String>, outputDirectory: File, mainDexRules: File, workingDirectory: File, artifact: String) {
        mainDexRules.parentFile.mkdirs()
        mainDexRules.outputStream().use { output ->
            requireNotNull(GodotPlugin::class.java.getResourceAsStream("android/main-dex-rules.proguard")).copyTo(output)
        }
        val d8Arguments = listOf(File(d8ToolPath.get()).absolutePath) + inputArguments + listOf(
            "--output",
            outputDirectory.absolutePath,
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
            "Failed to create $artifact (exit code $exitCode). Command: ${command.joinToString(" ")}\n$output"
        }
    }
}
