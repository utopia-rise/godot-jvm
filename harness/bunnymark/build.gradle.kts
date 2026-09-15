import godot.registrar.generator.RegistrationFileLayoutMode
import java.nio.file.Files
import java.nio.file.StandardCopyOption

plugins {
    id("com.utopia-rise.godot-jvm")
}

repositories {
    mavenCentral()
}

tasks {
    register("syncAddon") {
        group = "verification"
        description = "Copies the GDExtension addon built into harness/tests, so the native library is built once."
        val source = projectDir.resolve("../tests/addons/jvm").toPath()
        val target = projectDir.resolve("addons/jvm").toPath()
        doLast {
            target.toFile().deleteRecursively()
            Files.walk(source).forEach { path ->
                val destination = target.resolve(source.relativize(path))
                if (Files.isDirectory(path)) Files.createDirectories(destination)
                else Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING)
            }
        }
    }

    named("build") { finalizedBy("syncAddon") }
}

godot {
    registration {
        gdjFilesDirectory.set(projectDir.resolve("scripts"))
        gdjFilesLayoutMode.set(RegistrationFileLayoutMode.HIERARCHICAL)
    }
}
