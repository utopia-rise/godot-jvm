import versioninfo.VersionInfoExtension
import org.gradle.kotlin.dsl.configure

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.grgit)
    id("com.utopia-rise.versioninfo")
}

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
