rootProject.name = "third-party-library"

includeBuild("../../kt/api-generator") {
    dependencySubstitution {
        substitute(module("com.utopia-rise:api-generator")).using(project(":"))
    }
}
includeBuild("../../kt") {
    dependencySubstitution {
        substitute(module("com.utopia-rise:godot-gradle-plugin")).using(project(":godot-gradle-plugin"))
        substitute(module("com.utopia-rise:godot-core-library-debug")).using(project(":godot-core-library"))
        substitute(module("com.utopia-rise:godot-core-library-release")).using(project(":godot-core-library"))
        substitute(module("com.utopia-rise:godot-api-library-debug")).using(project(":godot-api-library"))
        substitute(module("com.utopia-rise:godot-api-library-release")).using(project(":godot-api-library"))
        substitute(module("com.utopia-rise:godot-extension-library-debug")).using(project(":godot-extension-library"))
        substitute(module("com.utopia-rise:godot-extension-library-release")).using(project(":godot-extension-library"))
        substitute(module("com.utopia-rise:godot-coroutine-library-debug")).using(project(":godot-coroutine-library"))
        substitute(module("com.utopia-rise:godot-coroutine-library-release")).using(project(":godot-coroutine-library"))
        substitute(module("com.utopia-rise:godot-registration")).using(project(":godot-registration"))
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
