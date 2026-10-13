import versioninfo.fullBuildVersion

// Not published on its own: bundled into the `godot-registration` fat jar (see ../godot-registration).
plugins {
    alias(libs.plugins.kotlin.jvm)
    id("com.utopia-rise.versioninfo")
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

dependencies {
    implementation("com.utopia-rise:tools-common:$fullBuildVersion")
    implementation(project(":godot-bootstrap-library"))
    // Front-end now depends only on the shared model (not the generator) — produces model instances.
    implementation(project(":godot-registration-model"))

    implementation(libs.classGraph)
}
