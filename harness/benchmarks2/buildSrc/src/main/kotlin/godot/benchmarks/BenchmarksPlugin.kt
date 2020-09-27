package godot.benchmarks

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.os.OperatingSystem
import java.io.File

class BenchmarksPlugin : Plugin<Project> {
    lateinit var project: Project
    override fun apply(project: Project) {
        this.project = project
        project.extensions.create("godotBenchmarks", BenchmarksExtension::class.java, project.objects, ::findExecutable)
    }

    private fun findExecutable(language: String): File {
        val os = currentOs()
        val property = project.property("godot.benchmarks.$language.${os.name.toLowerCase()}.exec") as String
        return project.file(property)
    }

    private fun currentOs(): Os {
        val os = OperatingSystem.current()
        return when {
            os.isLinux -> Os.LINUX
            os.isWindows -> Os.WINDOWS
            os.isMacOsX -> Os.MACOS
            else -> throw AssertionError("Unsupported os: $os")
        }
    }
}
