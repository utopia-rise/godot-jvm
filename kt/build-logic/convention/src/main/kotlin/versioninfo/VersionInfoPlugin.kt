package versioninfo

import godot.tools.common.version.BuildVersion
import org.ajoberstar.grgit.Grgit
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
import org.gradle.api.tasks.bundling.AbstractArchiveTask
import java.io.File

private lateinit var grgit: Grgit
private lateinit var godotJvmVersion: String
private lateinit var godotVersion: String
private lateinit var kotlinVersion: String
private lateinit var iosGraalNativeImageVersion: String
private var reproducibleVersion = false

class VersionInfoPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply(GrgitPlugin::class.java)
        grgit = target.extensions.getByType(Grgit::class.java)
        val libs = target.extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
        godotJvmVersion = libs.findVersion("godotJvm").get().requiredVersion
        godotVersion = libs.findVersion("godot").get().requiredVersion
        kotlinVersion = libs.findVersion("kotlin").get().requiredVersion
        iosGraalNativeImageVersion = libs.findVersion("iosGraalNativeImage").get().requiredVersion
        // CI sets this (ORG_GRADLE_PROJECT_reproducibleVersion) so two commits with identical sources produce
        // identical jars and Gradle can reuse cached outputs. Local builds and every publish keep the per-commit
        // snapshot version.
        reproducibleVersion = target.providers.gradleProperty("reproducibleVersion").isPresent
        // Set before any plugin applied after this one: vanniktech's publishToMavenCentral reads the version eagerly
        // to decide whether the Central repository gets credentials, which only the snapshot repository needs.
        target.version = buildVersion.value
        target.group = "com.utopia-rise"

        target.tasks.withType(AbstractArchiveTask::class.java).configureEach { task ->
            task.isPreserveFileTimestamps = false
            task.isReproducibleFileOrder = true
        }

        target.extensions.create("versionInfo", VersionInfoExtension::class.java, target)
    }
}

// A getter, not a lazy value: the Gradle daemon keeps this class loaded between builds, so a cached value would
// survive a checkout of another commit and report the previous commit's hash.
val buildVersion: BuildVersion
    get() {
        val head = grgit.head()
        val tags = grgit.tag.list()
            .filter { tag -> tag.commit.id == head.id && tag.name.matches(BuildVersion.VERSION_TAG) }
            .map { tag -> tag.name }
        check(tags.size <= 1) { "The commit carries several version tags: ${tags.joinToString()}." }
        val tag = tags.singleOrNull()
        // A release must report the version the native library is built with, which mirrors the catalog.
        check(tag == null || tag == godotJvmVersion) {
            "The commit is tagged $tag, but the Godot-JVM version in the version catalog is $godotJvmVersion."
        }
        return BuildVersion(tag, head.abbreviatedId.takeUnless { reproducibleVersion })
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

                const val GODOT_VERSION = "$godotVersion"
                const val GODOT_JVM_VERSION = "$godotJvmVersion"
            """.trimIndent() + "\n",
        )
    }

    fun generateToolsCommonVersionKt() {
        val build = buildVersion
        registerVersionFileTask(
            taskName = "generateToolsCommonVersionKt",
            packageName = "godot.tools.common",
            content = """
                package godot.tools.common

                import godot.tools.common.version.BuildVersion

                val BUILD_VERSION = BuildVersion(
                    tag = ${build.tag?.let { "\"$it\"" }},
                    commitHash = ${build.commitHash?.let { "\"$it\"" }},
                )

                const val KOTLIN_VERSION = "$kotlinVersion"

                const val IOS_GRAAL_NATIVE_IMAGE_VERSION = "$iosGraalNativeImageVersion"
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
