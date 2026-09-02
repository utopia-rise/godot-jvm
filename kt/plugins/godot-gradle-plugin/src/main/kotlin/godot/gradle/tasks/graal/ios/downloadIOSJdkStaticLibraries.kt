package godot.gradle.tasks.graal.ios

import godot.tools.common.IOS_GRAAL_JDK_BUILD_VERSION
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
import org.jetbrains.kotlin.gradle.internal.ensureParentDirsCreated
import java.net.URL

abstract class DownloadIOSJdkStaticLibrariesTask : DefaultTask() {
    @get:OutputDirectory
    abstract val iosJdkDirectory: DirectoryProperty

    @get:Input
    abstract val releaseBaseLink: Property<String>

    @get:Input
    abstract val fileNames: ListProperty<String>

    @TaskAction
    fun downloadIOSJdkStaticLibraries() {
        val outputDirectory = iosJdkDirectory.get().asFile

        fileNames.get().forEach { fileName ->
            val outputFile = outputDirectory.resolve(fileName)
            if (!outputFile.exists()) {
                outputFile.ensureParentDirsCreated()
                outputFile.createNewFile()
                URL("${releaseBaseLink.get()}/$fileName").openStream().copyTo(outputFile.outputStream())
            }
        }
    }
}

fun Project.downloadIOSJdkStaticLibraries(): TaskProvider<out Task> {
    val releaseBaseLink = "https://github.com/utopia-rise/ios-graal-jdk-$IOS_JDK_VERSION/releases/download/$IOS_GRAAL_JDK_BUILD_VERSION"
    val fileNames = listOf("libjava-release.a", "libjvm-release.a")

    return tasks.register("downloadIOSJdkStaticLibraries", DownloadIOSJdkStaticLibrariesTask::class.java) {
        with(it) {
            group = "godot-jvm-internal"
            description = "INTERNAL TASK ! Downloads ios static JDK libraries."

            iosJdkDirectory.set(layout.buildDirectory.dir("libs/ios/ios-jdk/$IOS_JDK_VERSION"))
            this.releaseBaseLink.set(releaseBaseLink)
            this.fileNames.set(fileNames)
        }
    }
}
