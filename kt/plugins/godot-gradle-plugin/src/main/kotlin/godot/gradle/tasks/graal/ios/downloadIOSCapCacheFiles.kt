package godot.gradle.tasks.graal.ios

import godot.tools.common.IOS_CAP_CACHE_VERSION
import godot.tools.common.IOS_JDK_VERSION
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import java.net.URL

abstract class DownloadIOSCapCacheFilesTask : DefaultTask() {
    @get:OutputDirectory
    abstract val capCacheDirectory: DirectoryProperty

    @get:Input
    abstract val releaseBaseLink: Property<String>

    @get:Input
    abstract val fileNames: ListProperty<String>

    @TaskAction
    fun downloadIOSCapCacheFiles() {
        val outputDirectory = capCacheDirectory.get().asFile
        outputDirectory.mkdirs()

        fileNames.get().forEach { fileName ->
            val capFile = outputDirectory.resolve(fileName)
            if (!capFile.exists()) {
                capFile.createNewFile()
                URL("${releaseBaseLink.get()}/$fileName").openStream().copyTo(capFile.outputStream())
            }
        }
    }
}

fun Project.downloadIOSCapCacheFiles(): TaskProvider<out Task> {
    val fileNames = listOf(
        "AArch64LibCHelperDirectives.cap",
        "AMD64LibCHelperDirectives.cap",
        "BuiltinDirectives.cap",
        "JNIHeaderDirectives.cap",
        "JNIHeaderDirectivesJDK19OrLater.cap",
        "JNIHeaderDirectivesJDK20OrLater.cap",
        "JNIHeaderDirectivesJDK21OrLater.cap",
        "PosixDirectives.cap",
        "RISCV64LibCHelperDirectives.cap"
    )
    val releaseBaseLink = "https://github.com/utopia-rise/cap-cache-generator/releases/download/$IOS_CAP_CACHE_VERSION-$IOS_JDK_VERSION"

    return tasks.register("downloadIOSCapCacheFiles", DownloadIOSCapCacheFilesTask::class.java) { task ->
        with(task) {
            group = "godot-jvm-internal"
            description = "INTERNAL TASK ! Downloads CAP cache needed for iOS compilation using GraalVM native-image."

            capCacheDirectory.set(
                layout.buildDirectory.dir("graal/ios/capcache/$IOS_CAP_CACHE_VERSION-$IOS_JDK_VERSION")
            )
            this.releaseBaseLink.set(releaseBaseLink)
            this.fileNames.set(fileNames)
        }
    }
}
