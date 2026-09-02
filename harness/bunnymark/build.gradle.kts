import godot.registrar.generator.RegistrationFileLayoutMode

plugins {
    id("com.utopia-rise.godot-jvm")
}

repositories {
    mavenCentral()
}

godot {
    registration {
        gdjFilesDirectory.set(projectDir.resolve("scripts"))
        gdjFilesLayoutMode.set(RegistrationFileLayoutMode.HIERARCHICAL)
    }
}
