import com.utopiarise.kotlin.preprocessors.codegen.generateDefinitions
import versioninfo.fullBuildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    id("com.utopia-rise.versioninfo")
    id("com.utopia-rise.release-flavor")
    alias(libs.plugins.kotlinPreProcessors)
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

kotlinDefinitions {
    definitionsObjectName.set("GodotJvmBuildConfig")
    define("DEBUG", true)
}

val generateReleaseKotlinDefinitions = tasks.register("generateReleaseKotlinDefinitions") {
    val outputDir = layout.buildDirectory.dir("releaseDefinitions")
    outputs.dir(outputDir)
    doLast {
        outputDir.get().asFile.generateDefinitions(mapOf("DEBUG" to false), "GodotJvmBuildConfig")
    }
}

kotlin.sourceSets["release"].kotlin.srcDir(generateReleaseKotlinDefinitions)

dependencies {
    // added here as a transitive dependency so the user can use reflection
    // we need to add it here so reflection is available where the code is loaded (Bootstrap.kt) otherwise it will not work
    api("com.utopia-rise:common:$fullBuildVersion")
    testImplementation("junit", "junit", "4.12")
}
