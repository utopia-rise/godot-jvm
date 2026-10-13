import versioninfo.fullBuildVersion
import versioninfo.VersionInfoExtension
import org.gradle.kotlin.dsl.configure

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
    generateCommonVersionKt()
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
