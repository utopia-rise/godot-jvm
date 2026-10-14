import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import versioninfo.buildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    id("com.utopia-rise.versioninfo")
    id("com.utopia-rise.release-flavor")
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
    sourceSets.all {
        languageSettings.enableLanguageFeature("ContextParameters")
    }
}

dependencies {
    api("com.utopia-rise:common:${buildVersion.value}")
    implementation(project(":godot-internal-library"))

    testImplementation("junit", "junit", "4.12")
    testImplementation("com.utopia-rise:common:${buildVersion.value}")
}

tasks {
    withType<KotlinCompile> {
        dependsOn(":generateAPI")
    }
}
