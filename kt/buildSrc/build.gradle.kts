plugins {
    `kotlin-dsl`
}

buildscript {
    repositories {
        mavenLocal()
        jcenter()
        gradlePluginPortal()
    }
}
repositories {
    mavenLocal()
    jcenter()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("gradle-plugin", version = "1.4.10"))
    implementation("com.squareup:kotlinpoet:1.5.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")
}
