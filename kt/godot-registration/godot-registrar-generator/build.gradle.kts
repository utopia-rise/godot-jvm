import versioninfo.buildVersion

// Not published on its own: bundled into the `godot-registration` fat jar (see ../godot-registration).
plugins {
    alias(libs.plugins.kotlin.jvm)
    id("com.utopia-rise.versioninfo")
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

dependencies {
    implementation("com.utopia-rise:tools-common:${buildVersion.value}")
    implementation(project(":godot-bootstrap-library"))
    implementation(project(":godot-core-library"))
    implementation(project(":godot-registration-model"))
    implementation(libs.kotlinPoet)
}
