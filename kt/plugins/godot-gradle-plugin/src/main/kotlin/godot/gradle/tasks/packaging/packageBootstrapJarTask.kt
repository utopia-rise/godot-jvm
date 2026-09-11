package godot.gradle.tasks

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.variantLibsDirectory
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.bundling.Jar

fun Project.packageBootstrapJarTask(customApiJarTask: TaskProvider<Jar>? = null): TaskProvider<ShadowJar> {
    val mainSourceSet = extensions
        .getByType(SourceSetContainer::class.java)
        .getByName("main")

    return tasks.register("packageBootstrapJar", ShadowJar::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Creates a fat jar containing everything needed to load and run the usercode.jar"

            archiveBaseName.set(ArtifactNames.Debug.BOOTSTRAP_JAR.removeSuffix(".jar"))
            destinationDirectory.set(variantLibsDirectory())
            if (customApiJarTask != null) {
                dependsOn(customApiJarTask)
                duplicatesStrategy = DuplicatesStrategy.EXCLUDE
                from(zipTree(customApiJarTask.flatMap(Jar::getArchiveFile)))
                dependencies { filter ->
                    filter.exclude(filter.dependency("com.utopia-rise:godot-api-library(-.*)?:.*"))
                }
            }
            configurations.clear()
            configurations.add(this@packageBootstrapJarTask.configurations.getByName("bootstrap"))
            configurations.add(this@packageBootstrapJarTask.configurations.getByName(mainSourceSet.runtimeClasspathConfigurationName))
            archiveVersion.set("") // otherwise the version is appended to the name and our export plugin cannot find it anymore

            // Bootstrap is loaded reflectively by the native Godot runtime, so Shadow's
            // release minimization incorrectly removes godot.runtime.Bootstrap.
        }
    }
}
