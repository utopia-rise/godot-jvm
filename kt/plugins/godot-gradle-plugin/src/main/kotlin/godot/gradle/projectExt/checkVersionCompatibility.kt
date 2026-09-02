package godot.gradle.projectExt

import godot.tools.common.KOTLIN_VERSION
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

private const val MINIMUM_JDK_VERSION = 17
private const val MINIMUM_SCALA_VERSION = "3.0.0"

fun Project.checkJdkVersionCompatibility() {
    afterEvaluate {
        val configuredJdkVersion = godotJvmExtension.toolchain.javaVersion.get()

        require(configuredJdkVersion >= MINIMUM_JDK_VERSION) {
            "godot.toolchain.javaVersion is set to $configuredJdkVersion, but Godot-JVM requires at least JDK $MINIMUM_JDK_VERSION."
        }

        extensions.configure(JavaPluginExtension::class.java) { javaExtension ->
            javaExtension.toolchain.languageVersion.set(JavaLanguageVersion.of(configuredJdkVersion))
        }

        kotlinJvmExtension.jvmToolchain(configuredJdkVersion)
    }
}

fun Project.checkKotlinVersionCompatibility() {
    val kotlinPlugin = plugins.findPlugin(KotlinPluginWrapper::class.java)
    val kotlinPluginVersion = detectedKotlinPluginVersion()

    logger.info("Kotlin plugin already applied: ${kotlinPlugin != null}; detected version: ${kotlinPluginVersion ?: "none"}")

    when {
        kotlinPluginVersion != null && isVersionLowerThan(kotlinPluginVersion, KOTLIN_VERSION) -> throw IllegalArgumentException(
            "Detected Kotlin Gradle plugin version $kotlinPluginVersion, but Godot-JVM requires at least Kotlin $KOTLIN_VERSION."
        )

        kotlinPlugin == null && kotlinPluginVersion == null -> {
            pluginManager.apply(KotlinPluginWrapper::class.java)
        }
    }

    afterEvaluate {
        val configuredKotlinVersion = godotJvmExtension.toolchain.kotlinVersion.get()
        val resolvedKotlinVersion = resolvedKotlinBuildVersion()

        require(!isVersionLowerThan(configuredKotlinVersion, KOTLIN_VERSION)) {
            "godot.toolchain.kotlinVersion is set to $configuredKotlinVersion, but Godot-JVM requires at least Kotlin $KOTLIN_VERSION."
        }

        if (configuredKotlinVersion != KOTLIN_VERSION && configuredKotlinVersion != resolvedKotlinVersion) {
            throw IllegalArgumentException(
                "godot.toolchain.kotlinVersion is set to $configuredKotlinVersion, but the applied Kotlin Gradle plugin version is $resolvedKotlinVersion. " +
                    "To use a custom Kotlin version, apply `org.jetbrains.kotlin.jvm` explicitly with version $configuredKotlinVersion before `com.utopia-rise.godot-jvm`."
            )
        }
    }
}

fun Project.checkScalaVersionCompatibility() {
    afterEvaluate {
        val configuredScalaVersion = godotJvmExtension.toolchain.scalaVersion.get()

        require(!isVersionLowerThan(configuredScalaVersion, MINIMUM_SCALA_VERSION)) {
            "godot.toolchain.scalaVersion is set to $configuredScalaVersion, but Godot-JVM requires at least Scala $MINIMUM_SCALA_VERSION."
        }
    }
}

fun Project.detectedKotlinPluginVersion(): String? = buildscript
    .configurations
    .firstOrNull { it.name == "classpath" }
    ?.dependencies
    ?.firstOrNull { it.name == "org.jetbrains.kotlin.jvm.gradle.plugin" }
    ?.version

fun Project.resolvedKotlinBuildVersion(): String = detectedKotlinPluginVersion() ?: KOTLIN_VERSION
