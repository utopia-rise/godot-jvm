plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
    alias(libs.plugins.gradlePublish)
    id("com.utopia-rise.versioninfo")
    id("com.utopia-rise.maven-central")
}

description = "Automatically configures Godot-JVM projects"

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
            description = project.description

            tags.set(listOf("kotlin", "godot", "gamedev"))
        }
    }
}

dependencies {
    implementation(kotlin("gradle-plugin", version = libs.versions.kotlin.get()))
    implementation(libs.shadowJar)

    // used for idea sync gradle task integration (ex. generateGdIgnoreFilesTask)
    implementation(libs.ideaSync)

    for (module in listOf("tools-common", "api-generator", "class-graph-symbol-processor", "registration-model", "registrar-generator")) {
        implementation(project(":")) {
            capabilities { requireCapability("com.utopia-rise:godot-library-$module") }
        }
    }
}

tasks {
    build {
        finalizedBy(publishToMavenLocal)
    }
}
