import godot.registrar.generator.RegistrationFileLayoutMode

plugins {
    id("com.utopia-rise.godot-jvm")
}

repositories {
    mavenCentral()
}

godot {
    registrationFilesDirectory.set(projectDir.resolve("scripts"))
    registrationFilesLayoutMode.set(RegistrationFileLayoutMode.HIERARCHICAL)
}
