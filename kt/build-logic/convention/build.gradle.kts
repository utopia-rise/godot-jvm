plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
    sourceSets.main {
        kotlin.srcDir("../../tools-common/src/version/kotlin")
    }
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
        register("mavenCentral") {
            id = "com.utopia-rise.maven-central"
            implementationClass = "publish.MavenCentralPlugin"
        }
        register("godotJvmPublication") {
            id = "com.utopia-rise.godot-jvm-publication"
            implementationClass = "publish.GodotJvmPublicationPlugin"
        }
        register("individualJarsPublication") {
            id = "com.utopia-rise.individual-jars-publication"
            implementationClass = "publish.IndividualJarsPublicationPlugin"
        }
        register("releaseFlavor") {
            id = "com.utopia-rise.release-flavor"
            implementationClass = "flavor.ReleaseFlavorPlugin"
        }
    }
}
