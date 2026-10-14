import versioninfo.buildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
    id("com.utopia-rise.versioninfo")
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

gradlePlugin {
    plugins {
        create("apiGeneratorPlugin") {
            id = "com.utopia-rise.api-generator"
            implementationClass = "godot.gradle.ApiGeneratorPlugin"
        }
    }
}

dependencies {
    implementation("com.utopia-rise:common:${buildVersion.value}")
    implementation("com.utopia-rise:tools-common:${buildVersion.value}")
    implementation(libs.kotlinPoet)
    implementation(libs.jacksonDataBind)
    implementation(libs.jacksonDataFormatXml)
}
