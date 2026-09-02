plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

dependencies {
    compileOnly(kotlin("gradle-plugin", version = libs.versions.kotlin.get()))
    implementation(libs.grgit)
    implementation(libs.maven.publish)
}

gradlePlugin {
    plugins {
        register("versioninfo") {
            id = "com.utopia-rise.versioninfo"
            implementationClass = "versioninfo.VersionInfoPlugin"
        }
    }
    plugins {
        create("godotPublishPlugin") {
            id = "com.utopia-rise.godot-publish"
            displayName = "Gradle plugin for publishing Godot-JVM to Maven Central"
            implementationClass = "publish.PublishToMavenCentralPlugin"
        }
    }
}
