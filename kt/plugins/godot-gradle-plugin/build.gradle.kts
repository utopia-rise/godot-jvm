import versioninfo.fullBuildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
    alias(libs.plugins.gradlePublish)
    id("com.utopia-rise.godot-publish")
    id("com.utopia-rise.versioninfo")
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

gradlePlugin {
    website.set("https://github.com/utopia-rise/godot-jvm")
    vcsUrl.set("https://github.com/utopia-rise/godot-jvm.git")

    plugins {
        create("godotPlugin") {
            id = "com.utopia-rise.godot-jvm"
            displayName = "Gradle plugin for Godot-JVM"
            implementationClass = "godot.gradle.GodotPlugin"
            description = "Automatically configures Godot-JVM projects"

            tags.set(listOf("kotlin", "godot", "gamedev"))
        }
    }
}

dependencies {
    implementation(kotlin("gradle-plugin", version = libs.versions.kotlin.get()))
    implementation(libs.shadowJar)

    // used for idea sync gradle task integration (ex. generateGdIgnoreFilesTask)
    implementation(libs.ideaSync)

    implementation(project(":godot-registration"))
    implementation("com.utopia-rise:tools-common:$fullBuildVersion")
}

tasks {
    build {
        finalizedBy(publishToMavenLocal)
    }
}
