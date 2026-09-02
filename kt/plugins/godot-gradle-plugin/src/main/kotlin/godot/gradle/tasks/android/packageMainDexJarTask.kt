package godot.gradle.tasks.android

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider

fun Project.packageMainDexJarTask(
    createMainDexFileTask: TaskProvider<out Task>
): TaskProvider<out Task> {
    return tasks.register("packageMainDexJar", ShadowJar::class.java) {
        with(it) {
            group = "godot-jvm"
            description =
                "Packs the android dex file of main, together with the needed registrar service file into a jar. Needed for android builds only"

            archiveBaseName.set("main-dex")

            // add all dex files (converted class files)
            from("${project.layout.buildDirectory.asFile.get().absolutePath}/libs/").include("*.dex")

            from(zipTree(project.layout.buildDirectory.asFile.get().resolve("libs/main.jar"))) { copySpec ->
                // copy everything from the main.jar
                copySpec.include("**/*")

                // except class files as these are contained in converted form in the dex files
                copySpec.exclude("**/*.class")
            }

            dependsOn(createMainDexFileTask)
        }
    }
}
