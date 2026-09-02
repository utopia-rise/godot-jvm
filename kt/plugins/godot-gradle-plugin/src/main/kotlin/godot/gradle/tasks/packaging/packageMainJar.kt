package godot.gradle.tasks

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.bundling.Jar

fun Project.packageMainJarTask(
    generatedRegistrarJarTask: TaskProvider<Jar>,
    updateRegistrationFilesTask: TaskProvider<out Task>,
    userClassesTask: TaskProvider<out Task>,
): TaskProvider<out Task> {
    return tasks.named("shadowJar", ShadowJar::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Creates a fat jar containing game code and all dependencies of it"

            archiveBaseName.set("main")
            archiveVersion.set("")
            archiveClassifier.set("")
            configurations.clear()

            dependsOn(userClassesTask)
            dependsOn(generatedRegistrarJarTask)
            dependsOn(updateRegistrationFilesTask)

            if (isFastBuildRequested()) {
                from(provider {
                    val generatedJar = generatedRegistrarJarTask.get().archiveFile.get().asFile
                    if (!generatedJar.isFile) {
                        throw GradleException(
                            "registrarGenerationJar output is missing. Run a full build first before using fastBuild. " +
                                "Expected file: ${generatedJar.absolutePath}"
                        )
                    }
                    zipTree(generatedJar)
                }) {
                    exclude("META-INF/MANIFEST.MF")
                }
            } else {
                from(generatedRegistrarJarTask.map { generatedJar ->
                    zipTree(generatedJar.archiveFile)
                }) {
                    exclude("META-INF/MANIFEST.MF")
                }
            }

            // merges all service files from all dependencies into on
            // needed so we can loop over and load all registrar files from within Bootstrap.kt
            mergeServiceFiles()
        }
    }
}

private fun Project.isFastBuildRequested(): Boolean =
    gradle.startParameter.taskNames.any { taskName ->
        taskName == "fastBuild" || taskName.endsWith(":fastBuild")
    }
