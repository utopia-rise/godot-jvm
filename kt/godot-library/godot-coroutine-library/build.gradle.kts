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
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${libs.versions.kotlinCoroutine.get()}")
    api("com.utopia-rise:common:$fullBuildVersion")
    implementation(project(":godot-internal-library"))
    api(project(":godot-core-library"))
    api(project(":godot-api-library"))
    api(project(":godot-extension-library"))
}

tasks {
    withType<KotlinCompile> {
        dependsOn(":generateAPI")
    }
}
