package godot.gradle.projectExt

import godot.gradle.GodotExtension
import godot.gradle.GodotLanguage
import godot.tools.common.constants.Paths
import org.gradle.api.Project
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
    get() = hasProperty("release") || gradle.startParameter.taskNames
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

val Project.godotInternalArtifactName: String
    get() = "godot-internal-library-${if (isRelease) "release" else "debug"}"

val Project.godotCoreArtifactName: String
    get() = "godot-core-library-${if (isRelease) "release" else "debug"}"

val Project.godotApiArtifactName: String
    get() = "godot-api-library-${if (isRelease) "release" else "debug"}"

val Project.godotBootstrapArtifactName: String
    get() = "godot-bootstrap-library-${if (isRelease) "release" else "debug"}"

val Project.godotExtensionArtifactName: String
    get() = "godot-extension-library-${if (isRelease) "release" else "debug"}"

val Project.godotCoroutineLibraryArtifactName: String
    get() = "godot-coroutine-library-${if (isRelease) "release" else "debug"}"

// Debug and release artifacts never share a directory, so one cannot be mistaken for the other.
val Project.variantDirectoryName: String
    get() = if (isRelease) Paths.RELEASE_VARIANT_DIR else Paths.DEBUG_VARIANT_DIR

fun Project.variantLibsDirectory(): Provider<Directory> = layout.buildDirectory.dir("libs/$variantDirectoryName")
