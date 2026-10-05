import versioninfo.fullBuildVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    id("com.utopia-rise.godot-publish")
    id("com.utopia-rise.versioninfo")
    alias(libs.plugins.kotlinPreProcessors)
}

val isRelease = project.hasProperty("release")

kotlinDefinitions {
    definitionsObjectName.set("GodotJvmBuildConfig")
    define("DEBUG", !isRelease)
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
    sourceSets.all {
        languageSettings.enableLanguageFeature("ContextParameters")
    }
}

dependencies {
    api("com.utopia-rise:common:$fullBuildVersion")
    implementation(project(":godot-internal-library"))

    testImplementation("junit", "junit", "4.12")
    testImplementation("com.utopia-rise:common:$fullBuildVersion")
}

tasks {
    compileKotlin {
        dependsOn(":godot-library:generateAPI")
    }

    // here so the sourcesJar task has an explicit dependency on the generateApi task. Needed since gradle 8
    withType<Jar> {
        dependsOn(":godot-library:generateAPI")
    }
}


val targetSuffix = if (isRelease) "release" else "debug"

publishing {
    publications {
        @Suppress("UNUSED_VARIABLE", "unused")
        val godotCoreLibraryPublication by creating(MavenPublication::class) {
            pom {
                name.set("${project.name}-$targetSuffix")
                description.set("Contains godot api as kotlin classes and jvm cpp interaction code.")
            }
            artifactId = "godot-core-library-$targetSuffix"
            description = "Contains godot api as kotlin classes and jvm cpp interaction code."

            from(components["java"])
        }
    }
}
