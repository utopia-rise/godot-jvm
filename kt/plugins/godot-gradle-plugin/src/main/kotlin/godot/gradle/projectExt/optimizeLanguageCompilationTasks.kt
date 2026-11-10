package godot.gradle.projectExt

import godot.gradle.GodotLanguage
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.scala.ScalaCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.optimizeLanguageCompilationTasks() {
    val kotlinEnabled = godotJvmExtension.languages.map { languages ->
        languages.contains(GodotLanguage.KOTLIN)
    }
    val javaEnabled = godotJvmExtension.languages.map { languages ->
        languages.contains(GodotLanguage.JAVA)
    }
    val scalaEnabled = godotJvmExtension.languages.map { languages ->
        languages.contains(GodotLanguage.SCALA)
    }

    tasks.withType(KotlinCompile::class.java).configureEach { kotlinCompile ->
        kotlinCompile.onlyIf("Skip Kotlin compilation when the language is disabled or the source tree is empty") {
            kotlinCompile.name == "compileRegistrarsKotlin" ||
                (kotlinEnabled.get() && !kotlinCompile.sources.isEmpty)
        }
    }

    tasks.withType(JavaCompile::class.java).configureEach { javaCompile ->
        javaCompile.onlyIf("Skip Java compilation when the language is disabled or the source tree is empty") {
            javaEnabled.get() && !javaCompile.source.isEmpty
        }
    }

    tasks.withType(ScalaCompile::class.java).configureEach { scalaCompile ->
        scalaCompile.onlyIf("Skip Scala compilation when the language is disabled or the source tree is empty") {
            scalaEnabled.get() && !scalaCompile.source.isEmpty
        }
    }
}
