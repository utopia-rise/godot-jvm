import versioninfo.VersionInfoExtension
import versioninfo.buildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.grgit)
    id("com.utopia-rise.versioninfo")
}

configure<VersionInfoExtension> {
    generateToolsCommonVersionKt()
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
    sourceSets.main {
        kotlin.srcDir("src/version/kotlin")
    }
}

dependencies {
    api("com.utopia-rise:common:${buildVersion.value}")
}
