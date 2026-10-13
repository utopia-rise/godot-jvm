import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import versioninfo.fullBuildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    id("com.utopia-rise.versioninfo")
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

dependencies {
    api("com.utopia-rise:common:${fullBuildVersion}")
    api(project(":godot-api-library"))
    implementation(project(":godot-internal-library"))
}

tasks {
    withType<KotlinCompile> {
        dependsOn(":generateAPI")
    }
}
