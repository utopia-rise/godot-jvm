import versioninfo.VersionInfoExtension
import versioninfo.fullBuildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.grgit)
    id("com.utopia-rise.versioninfo")
}

// the version is not inherited from the root build.gradle.kts as this here is a separate gradle project. Hence, we set it
// through the godot-dependencies plugin
version = fullBuildVersion
group = "com.utopia-rise"

configure<VersionInfoExtension> {
    generateToolsCommonVersionKt()
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

dependencies {
    api("com.utopia-rise:common:$fullBuildVersion")
}
