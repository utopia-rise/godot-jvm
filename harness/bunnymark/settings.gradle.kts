rootProject.name = "godot-jvm-bunnymark"

includeBuild("../../kt/api-generator") {
    dependencySubstitution {
        substitute(module("com.utopia-rise:api-generator")).using(project(":"))
    }
}
includeBuild("../../kt") {
    dependencySubstitution {
        substitute(module("com.utopia-rise:godot-gradle-plugin")).using(project(":godot-gradle-plugin"))
        substitute(module("com.utopia-rise:godot-library-debug")).using(project(":godot-library"))
        substitute(module("com.utopia-rise:godot-library-release")).using(project(":godot-library"))
        substitute(module("com.utopia-rise:godot-registration")).using(project(":godot-registration"))
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
