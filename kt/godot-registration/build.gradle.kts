plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.shadowJar)
    id("com.utopia-rise.godot-publish")
    id("com.utopia-rise.versioninfo")
}

kotlin {
    jvmToolchain(libs.versions.toolchain.jvm.get().toInt())
}

// Single, self-contained registration tool jar: bundles the symbol processor (front-end),
// the registration model (validated IR) and the registrar generator (back-end) together with
// their runtime dependencies. Consumed both as a standalone tool and by the gradle plugin.
dependencies {
    api(project(":godot-class-graph-symbol-processor"))
    api(project(":godot-registration-model"))
    api(project(":godot-registrar-generator"))
}

// Push the thin jar out of the way so the shadow jar becomes the primary artifact.
tasks.jar {
    archiveClassifier.set("thin")
}

tasks.shadowJar {
    archiveClassifier.set("")
    mergeServiceFiles()
}

// Ensure `build`/`assemble` produces the fat jar, and composite builds resolve to it.
tasks.assemble {
    dependsOn(tasks.shadowJar)
}

publishing {
    publications {
        @Suppress("UNUSED_VARIABLE")
        val godotRegistration by creating(MavenPublication::class) {
            pom {
                name.set(project.name)
                description.set("Godot-JVM registration tooling — bundles the symbol processor, registration model and registrar generator into a single jar.")
            }
            artifactId = project.name
            description =
                "Godot-JVM registration tooling — bundles the symbol processor, registration model and registrar generator into a single jar."
            // Fat jar is self-contained: publish it as the main artifact with no POM dependencies.
            artifact(tasks.shadowJar)
            artifact(tasks.named("sourcesJar"))
            artifact(tasks.named("javadocJar"))
        }
    }
}
