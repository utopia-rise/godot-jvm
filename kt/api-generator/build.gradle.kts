import versioninfo.fullBuildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
    id("com.utopia-rise.godot-publish")
    id("com.utopia-rise.versioninfo")
}

version = fullBuildVersion

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
    implementation("com.utopia-rise:common:$fullBuildVersion")
    implementation("com.utopia-rise:tools-common:$fullBuildVersion")
    implementation(libs.kotlinPoet)
    implementation(libs.jacksonDataBind)
    implementation(libs.jacksonDataFormatXml)
}
