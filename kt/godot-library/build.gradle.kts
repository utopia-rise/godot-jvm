import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "6.1.0"
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
        finalizedBy(copyBootstrapJar)
    }
}
