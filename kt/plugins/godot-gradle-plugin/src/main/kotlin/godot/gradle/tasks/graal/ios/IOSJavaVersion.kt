package godot.gradle.tasks.graal.ios

import godot.gradle.projectExt.godotJvmExtension
import org.gradle.api.Project
import java.io.File

enum class IOSJavaVersion {
    JVM_11,
    JVM_17;

    companion object {
        operator fun invoke(project: Project): IOSJavaVersion {
            val javaCPath = File(project.godotJvmExtension.graal.homeDirectory.get())
                .resolve("bin")
                .resolve("javac")
                .absolutePath
            val javaVersionProcess = ProcessBuilder(
                javaCPath,
                "-version"
            ).start()

            require(javaVersionProcess.waitFor() == 0) {
                buildString {
                    appendLine("Can't find graalvm home, please set your graalvm home to")
                    appendLine(javaVersionProcess.errorStream.readAllBytes().decodeToString())
                }
            }

            return if (javaVersionProcess.inputStream.readAllBytes().decodeToString().startsWith("javac 17")) {
                JVM_17
            } else {
                JVM_11
            }
        }
    }
}
