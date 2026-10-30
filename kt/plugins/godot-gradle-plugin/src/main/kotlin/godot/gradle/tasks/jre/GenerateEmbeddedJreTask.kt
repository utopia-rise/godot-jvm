package godot.gradle.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import java.io.File
import java.util.*
import javax.inject.Inject

abstract class GenerateEmbeddedJreTask @Inject constructor(
    private val execOperations: ExecOperations,
    @get:Input val targetArch: String,
) : DefaultTask() {

    @Input
    var modules: Array<String> = arrayOf(
        "java.base",
        "java.logging",
    )

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @Input
    var arguments: Array<String> = arrayOf(
        "--strip-debug",
        "--no-header-files",
        "--no-man-pages"
    )

    @get:Input
    abstract val javaHome: Property<String>

    @get:Internal
    abstract val gradleUserHome: Property<File>

    @TaskAction
    fun createJre() {
        val javaHome = javaHome.get()
        val outputDir = outputDir.get().asFile
        val jlink = File(javaHome, "bin/jlink${if (hostOs() == "windows") ".exe" else ""}")
        require(jlink.isFile) {
            "Cannot find 'jlink' at '${jlink.absolutePath}'. " +
                "The java home ('$javaHome') must point to a JDK (not a JRE). It is the project's Java toolchain unless " +
                "set explicitly via 'tasks.withType<GenerateEmbeddedJreTask> { javaHome = \"/path/to/jdk\" }'."
        }

        val modulePathArguments = if (targetArch == (jdkArch(File(javaHome)) ?: hostArch())) {
            emptyArray()
        } else {
            try {
                arrayOf("--module-path", File(findInstalledJdk(), "jmods").absolutePath)
            } catch (e: IllegalArgumentException) {
                outputDir.takeIf { directory -> directory.list()?.isEmpty() == true }?.delete()
                throw e
            }
        }

        outputDir.deleteRecursively()

        execOperations.exec { spec ->
            spec.commandLine(
                jlink.absolutePath,
                *modulePathArguments,
                "--add-modules", modules.joinToString(","),
                "--output", outputDir.absolutePath,
                *arguments,
            )
        }

        logger.lifecycle(
            "Custom $targetArch JRE created in $outputDir using modules: '${modules.joinToString(",")}', " +
                "arguments: '${arguments.joinToString(" ")}' and java home: $javaHome"
        )
    }

    private fun findInstalledJdk(): File {
        val hostJdk = File(javaHome.get())
        val majorVersion = jdkMajorVersion(hostJdk)
        val searchDirectories = jdkSearchDirectories()
        val candidates = searchDirectories
            .flatMap { directory -> directory.listFiles()?.toList() ?: emptyList() }
            .mapNotNull(::jdkHome)
            .filter { home -> File(home, "jmods").isDirectory && jdkArch(home) == targetArch && jdkMajorVersion(home) == majorVersion }
        require(candidates.isNotEmpty()) {
            "No $targetArch JDK $majorVersion found. Searched: ${searchDirectories.joinToString(", ")}. " +
                "Download the $targetArch JDK $majorVersion of your vendor and unpack it into one of these " +
                "directories; jlink only reads it, so it does not need to run on this machine. The JDK running jlink is " +
                "'${javaHome.get()}'."
        }
        val sameRelease = candidates.filter { home ->
            releaseProperty(home, "IMPLEMENTOR") == releaseProperty(hostJdk, "IMPLEMENTOR") &&
                releaseProperty(home, "JAVA_VERSION") == releaseProperty(hostJdk, "JAVA_VERSION")
        }
        val jdk = (sameRelease.ifEmpty { candidates }).minBy(File::getPath)
        logger.lifecycle("Using the $targetArch JDK at ${jdk.absolutePath}")
        return jdk
    }

    /**
     * The JDK home inside an installation directory: the directory itself, its macOS bundle layout, or the same one level
     * down, where Gradle's provisioned JDKs keep their archive's root directory.
     */
    private fun jdkHome(installation: File): File? {
        return (listOf(installation) + (installation.listFiles(File::isDirectory)?.sorted() ?: emptyList()))
            .flatMap { directory ->
                listOf(directory, File(directory, "Contents/Home"), File(directory, "libexec/openjdk.jdk/Contents/Home"))
            }
            .firstOrNull { home -> File(home, "release").isFile }
    }

    private fun jdkSearchDirectories(): List<File> {
        val userHome = File(System.getProperty("user.home"))
        val hostInstallation = File(javaHome.get()).let { home ->
            when {
                home.name == "Home" && home.parentFile?.name == "Contents" -> home.parentFile.parentFile
                else -> home
            }
        }
        val platformDirectories = when (hostOs()) {
            "macos" -> listOf(
                File("/Library/Java/JavaVirtualMachines"),
                File(userHome, "Library/Java/JavaVirtualMachines"),
                File("/opt/homebrew/opt"),
                File("/usr/local/opt"),
            )
            "linux" -> listOf(
                File("/usr/lib/jvm"),
                File("/usr/java"),
                File("/opt"),
            )
            else -> listOfNotNull(
                System.getenv("ProgramFiles")?.let { programFiles -> File(programFiles, "Java") },
                System.getenv("ProgramFiles")?.let { programFiles -> File(programFiles, "Eclipse Adoptium") },
                System.getenv("ProgramFiles")?.let { programFiles -> File(programFiles, "Microsoft") },
                System.getenv("ProgramFiles")?.let { programFiles -> File(programFiles, "Zulu") },
            )
        }
        return (listOf(hostInstallation.parentFile, gradleUserHome.get().resolve("jdks"), File(userHome, ".sdkman/candidates/java")) + platformDirectories)
            .filterNotNull()
            .filter(File::isDirectory)
            .distinct()
    }

    private fun jdkMajorVersion(jdk: File): String? {
        return releaseProperty(jdk, "JAVA_VERSION")?.substringBefore('.')
    }

    private fun jdkArch(jdk: File): String? {
        return when (releaseProperty(jdk, "OS_ARCH")) {
            "aarch64", "arm64" -> "arm64"
            "x86_64", "amd64" -> "amd64"
            else -> null
        }
    }

    private fun releaseProperty(jdk: File, key: String): String? {
        val release = File(jdk, "release")
        if (!release.isFile) {
            return null
        }
        return release.readLines()
            .firstOrNull { line -> line.startsWith("$key=") }
            ?.substringAfter('=')
            ?.trim('"')
    }

    companion object {
        fun hostArch(): String {
            return when (val arch = System.getProperty("os.arch")) {
                "aarch64", "arm64" -> "arm64"
                "x86_64", "amd64" -> "amd64"
                else -> throw IllegalArgumentException("Unsupported host architecture: $arch")
            }
        }

        fun hostOs(): String {
            val os = System.getProperty("os.name").lowercase(Locale.US)
            return when {
                os.contains("mac", true) -> "macos"
                os.contains("nix", true) || os.contains("nux", true) || os.contains("aix", true) -> "linux"
                os.contains("win", true) -> "windows"
                else -> throw IllegalArgumentException("Unsupported host operating system: $os")
            }
        }
    }
}
