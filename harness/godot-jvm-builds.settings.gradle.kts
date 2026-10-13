// Shared by every harness project: include the Godot-JVM builds from this repository and
// redirect the published com.utopia-rise artifacts to them, so each harness project builds
// against the local sources instead of a published release.
//
// Apply from a project's settings.gradle.kts with:
//     apply(from = "../godot-jvm-builds.settings.gradle.kts")
// Paths are resolved against the applying project's directory, so every harness project is
// expected to sit directly under harness/.

includeBuild("../../kt/api-generator") {
    dependencySubstitution {
        substitute(module("com.utopia-rise:api-generator")).using(project(":"))
    }
}

includeBuild("../../kt") {
    dependencySubstitution {
        substitute(module("com.utopia-rise:godot-gradle-plugin")).using(project(":godot-gradle-plugin"))
        substitute(module("com.utopia-rise:godot-library")).using(project(":"))
    }
}

includeBuild("../../kt/common") {
    dependencySubstitution {
        substitute(module("com.utopia-rise:common")).using(project(":"))
    }
}

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    resolutionStrategy.eachPlugin {
        if (requested.id.id == "com.utopia-rise.godot-jvm") {
            useModule("com.utopia-rise:godot-gradle-plugin:${requested.version}")
        }
        if (requested.id.id == "com.utopia-rise.api-generator") {
            useModule("com.utopia-rise:api-generator:${requested.version}")
        }
    }
}
