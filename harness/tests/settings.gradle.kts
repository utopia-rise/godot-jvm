rootProject.name = "godot-jvm-tests"

apply(from = "../godot-jvm-builds.settings.gradle.kts")

includeBuild("../../harness/third-party-library") {
    dependencySubstitution {
        substitute(module("com.godot.tests:third-party-library")).using(project(":"))
    }
}
