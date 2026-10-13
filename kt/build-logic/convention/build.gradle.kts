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
        register("mavenCentral") {
            id = "com.utopia-rise.maven-central"
            implementationClass = "publish.MavenCentralPlugin"
        }
        register("releaseFlavor") {
            id = "com.utopia-rise.release-flavor"
            implementationClass = "flavor.ReleaseFlavorPlugin"
        }
    }
}
