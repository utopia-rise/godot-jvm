import org.jetbrains.kotlin.konan.target.HostManager
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.concurrent.TimeUnit

plugins {
    id("com.utopia-rise.godot-jvm")
}

repositories {
    mavenCentral()
}

// Godot reports failures as error lines on stdout; the run itself keeps going, so the task has to read them. Only
// lines printed before the result marker count: Godot's own shutdown prints RID and ObjectDB leaks of its servers.
val failurePatterns = listOf(
    Regex("^ERROR: "), Regex("^SCRIPT ERROR: "), Regex("^USER ERROR: "), Regex("Error calling JVM"),
)
val resultMarker = "STRESS_RESULT:"

fun editorExecutable(): File = System.getenv("GODOT_EDITOR")
    ?.let(::File)
    ?.takeIf(File::isFile)
    ?: error("GODOT_EDITOR must point at a Godot editor executable")

fun gitCommit(): String {
    val process = ProcessBuilder("git", "rev-parse", "--short", "HEAD").redirectErrorStream(true).start()
    val output = process.inputStream.bufferedReader().readText().trim()
    return if (process.waitFor() == 0 && output.isNotEmpty()) output else "unknown"
}

fun exportPreset(): String = when {
    HostManager.hostIsLinux -> "stress_linux"
    HostManager.hostIsMac -> "stress_macos"
    HostManager.hostIsMingw -> "stress_windows"
    else -> error("Unsupported OS for exporting")
}

tasks {
    // A plain copy rather than a Sync task: the registration tasks scan the project directory, and a declared output
    // inside it would make Gradle demand a dependency between them.
    val syncAddon = register("syncAddon") {
        group = "verification"
        description = "Copies the GDExtension addon built into harness/tests, so the native library is built once."
        val source = projectDir.resolve("../tests/addons/jvm").toPath()
        val target = projectDir.resolve("addons/jvm").toPath()
        doLast {
            target.toFile().deleteRecursively()
            Files.walk(source).forEach { path ->
                val destination = target.resolve(source.relativize(path))
                if (Files.isDirectory(path)) Files.createDirectories(destination)
                else Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING)
            }
        }
    }

    register("importResources") {
        group = "verification"
        description = "Imports the Godot project after rebuilding the JVM registrations."
        dependsOn(build, syncAddon)

        val javaHome = System.getProperty("java.home")
        val workingDirectory = projectDir

        doLast {
            val logFile = layout.buildDirectory.file("import-resources.log").get().asFile
            logFile.parentFile.mkdirs()
            val process = ProcessBuilder(editorExecutable().absolutePath, "--headless", "--import")
                .directory(workingDirectory)
                .redirectErrorStream(true)
                .redirectOutput(logFile)
                .apply { environment()["JAVA_HOME"] = javaHome }
                .start()
            // Godot sometimes never exits once the import is done; the imported files are already on disk by then.
            if (!process.waitFor(5, TimeUnit.MINUTES)) {
                process.destroyForcibly()
                process.waitFor(1, TimeUnit.MINUTES)
            }
            println(logFile.readText())
            check(workingDirectory.resolve(".godot/global_script_class_cache.cfg").isFile) {
                "Godot did not finish importing the project."
            }
        }
    }

    register("runStressTests") {
        group = "verification"
        description = "Runs the stress suite in the editor binary. Requires importResources first. Pass -Pstress.args=\"--quick --filter=memory\" for runner options."
        dependsOn(syncAddon)

        val javaHome = System.getProperty("java.home")
        val workingDirectory = projectDir
        val extraArgs = (findProperty("stress.args") as String?)?.split(" ")?.filter(String::isNotBlank).orEmpty()

        doLast {
            val command = listOf(
                editorExecutable().absolutePath, "--headless", "--path", workingDirectory.absolutePath,
                "-s", "res://runner/StressRunner.gd", "--", "--commit=${gitCommit()}",
            ) + extraArgs
            println(command.joinToString(" "))

            val process = ProcessBuilder(command)
                .directory(workingDirectory)
                .redirectErrorStream(true)
                .apply { environment()["JAVA_HOME"] = javaHome }
                .start()
            val logFile = layout.buildDirectory.file("stress-tests.log").get().asFile
            logFile.parentFile.mkdirs()
            val offending = mutableListOf<String>()
            var running = true
            logFile.bufferedWriter().use { log ->
                process.inputStream.bufferedReader().forEachLine { line ->
                    println(line)
                    log.write(line)
                    log.newLine()
                    log.flush()
                    if (running && failurePatterns.any { it.containsMatchIn(line) }) { offending.add(line) }
                    if (line.startsWith(resultMarker)) { running = false }
                }
            }
            val exitCode = process.waitFor()
            check(offending.isEmpty()) {
                "Godot reported ${offending.size} error line(s) during the run:\n" + offending.joinToString("\n")
            }
            check(exitCode == 0) { "The stress runner exited with code $exitCode, see the summary above." }
        }
    }

    register<Exec>("exportStressTests") {
        group = "verification"
        description = "Exports the suite for the current host OS in debug mode, so the template libraries can be stressed too."
        dependsOn(syncAddon)
        environment("JAVA_HOME", System.getProperty("java.home"))
        workingDir = projectDir
        doFirst {
            projectDir.resolve("export").apply { deleteRecursively(); mkdirs() }
            commandLine(editorExecutable().absolutePath, "--headless", "--export-debug", exportPreset())
        }
    }
}
