plugins {
    id("com.utopia-rise.godot-jvm")
}

repositories {
    mavenCentral()
}

group = "com.godot.tests"

godot {
    isLibrary.set(true)
}

