import versioninfo.buildVersion

plugins {
    // prevents the kotlin plugin being applied multiple times (once per subproject) as this is not supported. Done as suggested by the kotlin plugin
    alias(libs.plugins.kotlin.jvm) apply false
    base
    `jvm-ecosystem`
    id("com.utopia-rise.versioninfo")
    id("com.utopia-rise.godot-jvm-publication")
    id("com.utopia-rise.individual-jars-publication")
    id("com.utopia-rise.maven-central")
    id("com.utopia-rise.api-generator")
    alias(libs.plugins.gradleIntelliJPlugin) apply false
    alias(libs.plugins.ideaSync) apply false
}

subprojects {
    if (path != ":godot-intellij-plugin") {
        pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
            dependencies.add("implementation", dependencies.kotlin("stdlib"))
        }
    }
}

apiGenerator {
    sourceJson.set(project.file("$rootDir/api-generator/src/main/resources/api.json"))
    coreOutputDir.set(project.file("$rootDir/godot-library/godot-core-library/src/main/kotlin/gen"))
    apiOutputDir.set(project.file("$rootDir/godot-library/godot-api-library/src/main/kotlin/"))
    extensionOutputDir.set(project.file("$rootDir/godot-library/godot-extension-library/src/main/kotlin/gen"))
    coroutineOutputDir.set(project.file("$rootDir/godot-library/godot-coroutine-library/src/main/kotlin/gen"))
}

godotJvm {
    shared("common", "common")
    flavored("internal", ":godot-internal-library")
    flavored("core", ":godot-core-library")
    flavored("api", ":godot-api-library", omitFromDependents = true)
    shared("extension", ":godot-extension-library")
    shared("bootstrap", ":godot-bootstrap-library")
    shared("coroutine", ":godot-coroutine-library")
    tool("tools-common", "tools-common")
    tool("api-generator", "api-generator")
    tool("class-graph-symbol-processor", ":godot-class-graph-symbol-processor")
    tool("registration-model", ":godot-registration-model")
    tool("registrar-generator", ":godot-registrar-generator")
}

tasks {
    named("godotJvmSourcesJar") {
        dependsOn(generateAPI)
    }

    register("publishLocal") {
        group = "publishing"
        description = "Publishes godot-jvm and the Gradle plugin to the local Maven repository."
        dependsOn("publishGodotJvmPublicationToMavenLocal", ":godot-gradle-plugin:publishToMavenLocal")
    }

    register("publishCentral") {
        group = "publishing"
        description = "Publishes godot-jvm and the Gradle plugin to Maven Central, snapshots included, and plugin releases to the Gradle Plugin Portal."
        dependsOn("publishGodotJvmPublicationToMavenCentralRepository", ":godot-gradle-plugin:publishAllPublicationsToMavenCentralRepository")
        if (!buildVersion.isSnapshot) {
            dependsOn(":godot-gradle-plugin:publishPlugins")
        }
    }

    register("publishJitpack") {
        group = "publishing"
        description = "Publishes every godot-jvm jar as its own artifact to the local Maven repository, where JitPack collects them."
        dependsOn("publishIndividualJarsToMavenLocal")
    }
}
