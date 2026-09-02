package godot.gradle.tasks

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.isRelease
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskProvider

fun Project.packageBootstrapJarTask(): TaskProvider<out Task> {
    val mainSourceSet = extensions
        .getByType(SourceSetContainer::class.java)
        .getByName("main")

    return tasks.register("packageBootstrapJar", ShadowJar::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Creates a fat jar containing everything needed to load and run the main.jar"

            archiveBaseName.set("godot-bootstrap")
            configurations.clear()
            configurations.add(this@packageBootstrapJarTask.configurations.getByName("bootstrap"))
            configurations.add(this@packageBootstrapJarTask.configurations.getByName(mainSourceSet.runtimeClasspathConfigurationName))
            archiveVersion.set("") // otherwise the version is appended to the name and our export plugin cannot find it anymore

            // Bootstrap is loaded reflectively by the native Godot runtime, so Shadow's
            // release minimization incorrectly removes godot.runtime.Bootstrap.
        }
    }
}
