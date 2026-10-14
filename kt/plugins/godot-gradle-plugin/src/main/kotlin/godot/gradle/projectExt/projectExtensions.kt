package godot.gradle.projectExt

import godot.gradle.GodotExtension
import godot.gradle.GodotLanguage
import godot.tools.common.BUILD_VERSION
import godot.tools.common.constants.Paths
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.attributes.Attribute
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

val Project.godotJvmExtension: GodotExtension
    get() = extensions.getByType(GodotExtension::class.java)

fun Project.isLanguageEnabled(language: GodotLanguage): Boolean = godotJvmExtension.languages.get().contains(language)

val Project.kotlinJvmExtension: KotlinJvmProjectExtension
    get() = extensions
        .findByType(KotlinJvmProjectExtension::class.java)
        ?: rootProject.extensions.getByType(KotlinJvmProjectExtension::class.java)

val Project.isRelease: Boolean
    get() = hasProperty("release") || generateSequence(gradle) { build -> build.parent }.last().startParameter.taskNames
        .asSequence()
        .map { taskPath -> taskPath.substringAfterLast(':') }
        .any { taskName ->
            taskName in setOf(
                "buildRelease",
                "buildAndroidRelease",
                "buildGraalNativeImageRelease",
                "buildIOSRelease",
            )
        }

val GODOT_BUILD_TYPE_ATTRIBUTE: Attribute<String> = Attribute.of("com.utopia-rise.godot.build-type", String::class.java)

fun Project.godotJvmDependency(module: String): Dependency =
    (dependencies.create("com.utopia-rise:godot-jvm:${BUILD_VERSION.value}") as ExternalModuleDependency).also { dependency ->
        dependency.capabilities { it.requireCapability("com.utopia-rise:godot-jvm-$module") }
    }

// Debug and release artifacts never share a directory, so one cannot be mistaken for the other.
val Project.variantDirectoryName: String
    get() = if (isRelease) Paths.RELEASE_VARIANT_DIR else Paths.DEBUG_VARIANT_DIR

fun Project.variantLibsDirectory(): Provider<Directory> = layout.buildDirectory.dir("libs/$variantDirectoryName")
