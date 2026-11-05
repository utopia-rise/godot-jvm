package godot.gradle.projectExt

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.GodotExtension
import godot.gradle.GodotLanguage
import godot.tools.common.BUILD_VERSION
import godot.tools.common.constants.Paths
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.attributes.Attribute
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskProvider
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import java.io.File

val Project.godotJvmExtension: GodotExtension
    get() = extensions.getByType(GodotExtension::class.java)

fun Project.isLanguageEnabled(language: GodotLanguage): Boolean = godotJvmExtension.languages.get().contains(language)

val Project.kotlinJvmExtension: KotlinJvmProjectExtension
    get() = extensions
        .findByType(KotlinJvmProjectExtension::class.java)
        ?: rootProject.extensions.getByType(KotlinJvmProjectExtension::class.java)

enum class BuildType(val id: String, private val taskSuffix: String) {
    DEBUG(Paths.DEBUG_VARIANT_DIR, ""),
    RELEASE(Paths.RELEASE_VARIANT_DIR, "Release");

    val sourceSetName: String
        get() = if (this == DEBUG) SourceSet.MAIN_SOURCE_SET_NAME else id

    fun named(baseName: String): String = baseName + taskSuffix
}

fun Project.sourceSet(buildType: BuildType): SourceSet =
    extensions.getByType(SourceSetContainer::class.java).getByName(buildType.sourceSetName)

val Project.buildTypes: List<BuildType>
    get() = if (providers.systemProperty("idea.sync.active").orNull == "true") listOf(BuildType.DEBUG) else BuildType.entries

val GODOT_BUILD_TYPE_ATTRIBUTE: Attribute<String> = Attribute.of("com.utopia-rise.godot.build-type", String::class.java)

fun Project.godotJvmDependency(module: String): Dependency =
    (dependencies.create("com.utopia-rise:godot-jvm:${BUILD_VERSION.value}") as ExternalModuleDependency).also { dependency ->
        dependency.capabilities { it.requireCapability("com.utopia-rise:godot-jvm-$module") }
    }

fun Project.libsDirectory(buildType: BuildType): Provider<Directory> = layout.buildDirectory.dir("libs/${buildType.id}")

fun Project.requireConfiguredGodotProjectDirectory(): File {
    val configuredDir = godotJvmExtension.godotProjectDirectory.orNull?.asFile ?: projectDir
    if (!configuredDir.resolve("project.godot").isFile) {
        throw GradleException(
            "No project.godot file was found in the configured Godot project directory: ${configuredDir.absolutePath}. " +
                "Set godot.godotProjectDirectory to the directory that contains project.godot."
        )
    }
    return configuredDir
}

fun Project.godotJvmDirectory(): File = requireConfiguredGodotProjectDirectory().resolve(Paths.GODOT_JVM_DIR)

fun Project.registerGodotJar(
    name: String,
    description: String,
    fileName: String,
    buildType: BuildType,
    configure: (ShadowJar) -> Unit,
): TaskProvider<ShadowJar> = tasks.register(name, ShadowJar::class.java) { task ->
    task.group = "godot-jvm"
    task.description = description
    task.archiveFileName.set(fileName)
    task.destinationDirectory.set(libsDirectory(buildType))
    task.configurations.clear()
    configure(task)
    task.manifest.attributes["Multi-Release"] = "true"
    task.mergeServiceFiles()
}
