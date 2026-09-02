package godot.gradle.tasks.graal.ios

import godot.tools.common.IOS_GRAAL_NATIVE_IMAGE_VERSION
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import java.io.File
import java.net.URL
import java.security.MessageDigest
import java.util.zip.ZipFile

private const val CAP_CACHE_ENTRY_PREFIX = "caps/"
private const val CHECKSUM_ENTRY = "SHA256SUMS"

private val STATIC_LIBRARY_ENTRIES = listOf("libjava-release.a", "libjvm-release.a")

/**
 * Downloads the iOS toolchain bundle published by
 * [ios-graal-native-image](https://github.com/utopia-rise/ios-graal-native-image) and unpacks it.
 *
 * The bundle replaces the two separate downloads Godot-JVM used for JDK 21, where the static
 * libraries came from a per JDK repository and the CAP cache from another one. A single archive
 * guarantees that the libraries and the CAP cache come from the same build.
 */
abstract class DownloadIOSGraalToolchainTask : DefaultTask() {
    @get:OutputDirectory
    abstract val iosJdkDirectory: DirectoryProperty

    @get:OutputDirectory
    abstract val capCacheDirectory: DirectoryProperty

    @get:Input
    abstract val bundleUrl: Property<String>

    @TaskAction
    fun downloadIOSGraalToolchain() {
        val jdkDirectory = iosJdkDirectory.get().asFile
        val capDirectory = capCacheDirectory.get().asFile
        val bundle = temporaryDir.resolve("ios-graal-toolchain.zip")

        if (!bundle.exists()) {
            val url = bundleUrl.get()
            logger.lifecycle("Downloading iOS GraalVM toolchain from $url")
            bundle.parentFile.mkdirs()
            URL(url).openStream().use { input ->
                bundle.outputStream().use(input::copyTo)
            }
        }

        jdkDirectory.mkdirs()
        capDirectory.mkdirs()

        ZipFile(bundle).use { archive ->
            val checksums = archive.getEntry(CHECKSUM_ENTRY)
                ?.let { entry -> archive.getInputStream(entry).bufferedReader().readLines() }
                ?.mapNotNull { line ->
                    val (checksum, name) = line.trim().split(Regex("\\s+"), limit = 2)
                        .takeIf { it.size == 2 } ?: return@mapNotNull null
                    name.removePrefix("*") to checksum
                }
                ?.toMap()
                ?: error("$CHECKSUM_ENTRY is missing from ${bundleUrl.get()}")

            val extracted = mutableListOf<String>()

            archive.entries().asSequence()
                .filter { entry -> !entry.isDirectory }
                .forEach { entry ->
                    val target = when {
                        entry.name in STATIC_LIBRARY_ENTRIES -> jdkDirectory.resolve(entry.name)
                        entry.name.startsWith(CAP_CACHE_ENTRY_PREFIX) && entry.name.endsWith(".cap") ->
                            capDirectory.resolve(entry.name.removePrefix(CAP_CACHE_ENTRY_PREFIX))

                        else -> return@forEach
                    }

                    archive.getInputStream(entry).use { input ->
                        target.outputStream().use(input::copyTo)
                    }

                    val expected = checksums[entry.name]
                        ?: error("${entry.name} is not listed in $CHECKSUM_ENTRY")
                    val actual = target.sha256()
                    check(actual == expected) {
                        "${entry.name} does not match its checksum in $CHECKSUM_ENTRY: expected $expected, got $actual"
                    }

                    extracted += entry.name
                }

            STATIC_LIBRARY_ENTRIES.forEach { name ->
                check(name in extracted) { "$name is missing from ${bundleUrl.get()}" }
            }
            check(extracted.any { it.startsWith(CAP_CACHE_ENTRY_PREFIX) }) {
                "the CAP cache is missing from ${bundleUrl.get()}"
            }
        }
    }

    private fun File.sha256(): String {
        val digest = MessageDigest.getInstance("SHA-256")
        inputStream().use { input ->
            val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
            while (true) {
                val read = input.read(buffer)
                if (read <= 0) break
                digest.update(buffer, 0, read)
            }
        }
        return digest.digest().joinToString("") { byte -> "%02x".format(byte) }
    }
}

fun Project.downloadIOSGraalToolchain(): TaskProvider<out DownloadIOSGraalToolchainTask> {
    val bundleUrl = "https://github.com/utopia-rise/ios-graal-native-image/releases/download/" +
        "$IOS_GRAAL_NATIVE_IMAGE_VERSION/ios-graal-$IOS_GRAAL_NATIVE_IMAGE_VERSION.zip"

    return tasks.register("downloadIOSGraalToolchain", DownloadIOSGraalToolchainTask::class.java) { task ->
        with(task) {
            group = "godot-jvm-internal"
            description =
                "INTERNAL TASK ! Downloads the iOS static JDK libraries and the CAP cache needed by GraalVM native-image."

            iosJdkDirectory.set(layout.buildDirectory.dir("libs/ios/ios-jdk"))
            capCacheDirectory.set(
                layout.buildDirectory.dir("graal/ios/capcache/$IOS_GRAAL_NATIVE_IMAGE_VERSION")
            )
            this.bundleUrl.set(bundleUrl)
        }
    }
}
