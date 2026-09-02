package godot.gradle.tasks

import godot.tools.common.constants.Paths
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import java.io.File
import java.util.*
import javax.inject.Inject

open class GenerateEmbeddedJreTask @Inject constructor(
    private val execOperations: ExecOperations,
) : DefaultTask() {

    @Input
    var modules: Array<String> = arrayOf(
        "java.base",
        "java.logging",
    )

    @Input
    var outputDir: String = "${Paths.GODOT_JVM_DIR}/jre-${getArch()}-${getOs()}"

    @OutputDirectory
    fun getJreOutputDirectory(): File = File(outputDir)

    @Input
    var arguments: Array<String> = arrayOf(
        "--strip-debug",
        "--no-header-files",
        "--no-man-pages"
    )

    @Input
    var javaHome: String = System.getenv("JAVA_HOME") ?: System.getProperty("java.home")

    @TaskAction
    fun createJre() {
        File(outputDir).deleteRecursively()

        val jlink = File(javaHome, "bin/jlink${if (getOs() == "windows") ".exe" else ""}")
        require(jlink.isFile) {
            "Cannot find 'jlink' at '${jlink.absolutePath}'. " +
                "The configured java home ('$javaHome') must point to a JDK (not a JRE). " +
                "Set it explicitly via 'tasks.withType<GenerateEmbeddedJreTask> { javaHome = \"/path/to/jdk\" }' " +
                "or make sure JAVA_HOME points to a JDK."
        }

        execOperations.exec { spec ->
            spec.commandLine(
                jlink.absolutePath,
                "--add-modules", modules.joinToString(","),
                "--output", outputDir,
                *arguments,
            )
        }

        logger.lifecycle(
            "Custom JRE created in $outputDir using modules: '${modules.joinToString(",")}', arguments: '${
                arguments.joinToString(" ")
            }' and java home: $javaHome"
        )
    }

    private fun getArch(): String {
        return when (val arch = System.getProperty("os.arch")) {
            "aarch64", "arm64" -> "arm64"
            "x86_64", "amd64" -> "amd64"
            else -> throw IllegalArgumentException("Unsupported host architecture: $arch")
        }
    }

    private fun getOs(): String {
        val os = System.getProperty("os.name").lowercase(Locale.US)
        return when {
            os.contains("mac", true) -> "macos"
            os.contains("nix", true) || os.contains("nux", true) || os.contains("aix", true) -> "linux"
            os.contains("win", true) -> "windows"
            else -> throw IllegalArgumentException("Unsupported host operating system: $os")
        }
    }
}
