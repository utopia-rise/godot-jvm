import versioninfo.fullBuildVersion

// Not published on its own: bundled into the `godot-registration` fat jar (see ../godot-registration).
plugins {
    alias(libs.plugins.kotlin.jvm)
    id("com.utopia-rise.versioninfo")
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

// Exposed via `api` so consumers of the model (the registrar generator and the symbol processor)
// get the godot types, KotlinPoet and common utilities the model/checks/ext reference, transitively.
dependencies {
    api("com.utopia-rise:tools-common:$fullBuildVersion")
    api(project(":godot-bootstrap-library"))
    api(project(":godot-core-library"))
    api(libs.slf4jApi)
}
