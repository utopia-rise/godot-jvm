package versioninfo

import org.ajoberstar.grgit.Grgit
import org.ajoberstar.grgit.Commit
import org.ajoberstar.grgit.gradle.GrgitPlugin
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.plugins.JavaPluginExtension
import java.io.File

private lateinit var grgit: Grgit
private lateinit var godotJvmVersion: String
private lateinit var godotVersion: String
private lateinit var kotlinVersion: String
private lateinit var kotlinCoroutineVersion: String
private lateinit var iosJdkVersion: String
private lateinit var iosGraalJdkBuildVersion: String
private lateinit var iosCapCacheVersion: String

class VersionInfoPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply(GrgitPlugin::class.java)
        grgit = target.extensions.getByType(Grgit::class.java)
        val libs = target.extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
        godotJvmVersion = libs.findVersion("godotJvm").get().requiredVersion
        godotVersion = libs.findVersion("godot").get().requiredVersion
        kotlinVersion = libs.findVersion("kotlin").get().requiredVersion
        kotlinCoroutineVersion = libs.findVersion("kotlinCoroutine").get().requiredVersion
        iosJdkVersion = libs.findVersion("iosJdk").get().requiredVersion
        iosGraalJdkBuildVersion = libs.findVersion("iosGraalJdkBuild").get().requiredVersion
        iosCapCacheVersion = libs.findVersion("iosCapCache").get().requiredVersion

        target.extensions.create("versionInfo", VersionInfoExtension::class.java, target)
    }
}

// Dev builds (x.y.z-devN) and release candidates (x.y.z-rcN) are pre-releases: they publish under their tag name.
private val preReleaseTagRegex: Regex by lazy { Regex("${Regex.escape(godotJvmVersion)}-(dev|rc)[1-9]\\d*") }

val fullBuildVersion: String by lazy {
    val currentCommit: Commit = grgit.head()
    // check if the current commit is tagged
    val tagOnCurrentCommit = grgit.tag.list().firstOrNull { tag -> tag.commit.id == currentCommit.id }
    val releaseMode = tagOnCurrentCommit != null

    val isPreRelease = tagOnCurrentCommit?.name?.matches(preReleaseTagRegex) == true

    if (!releaseMode) {
        "$godotJvmVersion-${currentCommit.abbreviatedId}-SNAPSHOT"
    } else {
        if (isPreRelease) tagOnCurrentCommit.name else godotJvmVersion
    }
}

val isSnapshot: Boolean by lazy {
    val currentCommit: Commit = grgit.head()
    // check if the current commit is tagged
    val tagOnCurrentCommit = grgit.tag.list().firstOrNull { tag -> tag.commit.id == currentCommit.id }
    val releaseMode = tagOnCurrentCommit != null

    !releaseMode || tagOnCurrentCommit.name.matches(preReleaseTagRegex)
}

abstract class GenerateVersionFileTask : DefaultTask() {
    @get:Input
    abstract val packageName: Property<String>

    @get:Input
    abstract val content: Property<String>

    @get:OutputDirectory
    abstract val outputDirectory: DirectoryProperty

    @TaskAction
    fun generate() {
        val packagePath = packageName.get().replace('.', File.separatorChar)
        val targetDir = outputDirectory.get().asFile.resolve(packagePath)
        targetDir.mkdirs()
        targetDir.resolve("Version.kt").writeText(content.get())
    }
}

open class VersionInfoExtension(private val project: Project) {
    fun generateCommonVersionKt() {
        registerVersionFileTask(
            taskName = "generateCommonVersionKt",
            packageName = "godot.common",
            content = """
                package godot.common

                const val GODOT_MODULE_VERSION = "$godotJvmVersion"
                const val GODOT_VERSION = "$godotVersion"
                const val GODOT_JVM_VERSION = "$godotJvmVersion"
            """.trimIndent() + "\n",
        )
    }

    fun generateToolsCommonVersionKt() {
        registerVersionFileTask(
            taskName = "generateToolsCommonVersionKt",
            packageName = "godot.tools.common",
            content = """
                package godot.tools.common

                const val BUILD_VERSION = "$fullBuildVersion"
                const val KOTLIN_VERSION = "$kotlinVersion"
                const val KOTLIN_COROUTINE_VERSION = "$kotlinCoroutineVersion"

                const val IOS_JDK_VERSION = "$iosJdkVersion"
                const val IOS_GRAAL_JDK_BUILD_VERSION = "$iosGraalJdkBuildVersion"
                const val IOS_CAP_CACHE_VERSION = "$iosCapCacheVersion"
            """.trimIndent() + "\n",
        )
    }

    private fun registerVersionFileTask(taskName: String, packageName: String, content: String) {
        val taskProvider = project.tasks.register(taskName, GenerateVersionFileTask::class.java) { task ->
            task.packageName.set(packageName)
            task.content.set(content)
            task.outputDirectory.set(project.layout.buildDirectory.dir("generated/source/versioninfo/main/kotlin"))
        }

        project.extensions.getByType(JavaPluginExtension::class.java).sourceSets.named("main") { sourceSet ->
            sourceSet.java.srcDir(taskProvider.map { it.outputDirectory })
        }
    }
}
