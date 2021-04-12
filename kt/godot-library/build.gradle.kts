import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    id("com.utopia-rise.api-generator")
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.utopia-rise.godot-publish")
}

apiGenerator {
    outputDir.set(project.file("$rootDir/godot-library/src/main/kotlin/godot/gen"))
    sourceJson.set(project.file("$rootDir/api-generator/src/main/resources/api.json"))
    isNative.set(false)
    docsDir.set(project.file("$projectDir/../../../../doc/classes"))
}

dependencies {
    api(project(":godot-runtime"))
}

tasks {
    build.get().finalizedBy(shadowJar)

    val copyBootstrapJar by creating(Copy::class.java) {
        group = "godot-jvm"
        from(shadowJar)
        destinationDir = File("${projectDir.absolutePath}/../../../../bin/")
        dependsOn(shadowJar)
    }

    withType<ShadowJar> {
        archiveBaseName.set("godot-bootstrap")
        archiveVersion.set("")
        archiveClassifier.set("")
        dependencies {
            exclude(dependency("org.jetbrains.kotlin:.*"))
        }
        exclude("**/module-info.class") //for android support: excludes java 9+ module info which cannot be parsed by the dx tool
        finalizedBy(copyBootstrapJar)
    }

    compileKotlin {
        dependsOn(generateAPI)
    }
}

publishing {
    publications {
        val godotLibraryPublication by creating(MavenPublication::class) {
            pom {
                name.set(project.name)
                description.set("Contains godot api as kotlin classes and jvm cpp interaction code.")
            }
            artifactId = "godot-library"
            description = "Contains godot api as kotlin classes and jvm cpp interaction code."
            shadow.component(this)
        }
    }
}
