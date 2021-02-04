import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

dependencies {
    api(project(":godot-runtime"))
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("godot-bootstrap")
    archiveVersion.set("")
    archiveClassifier.set("")
}
