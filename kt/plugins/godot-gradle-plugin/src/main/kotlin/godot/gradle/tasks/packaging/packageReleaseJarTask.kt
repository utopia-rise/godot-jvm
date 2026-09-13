package godot.gradle.tasks

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.GODOT_SPLIT_IMPLEMENTATION_CONFIGURATION
import godot.gradle.projectExt.variantLibsDirectory
import godot.tools.common.constants.ArtifactNames
import godot.tools.common.constants.Paths
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.tasks.TaskProvider

/**
 * Release builds ship a single archive, so there is no second class loader and no script reloading. Shadow does the
 * merge because it merges `META-INF/services` entries and resolves duplicate resources.
 */
fun Project.packageReleaseJarTask(
    packageBootstrapJarTask: TaskProvider<ShadowJar>,
    packageUserCodeJarTask: TaskProvider<ShadowJar>,
): TaskProvider<ShadowJar> {
    val godotSplitImplementation = configurations.getByName(GODOT_SPLIT_IMPLEMENTATION_CONFIGURATION)

    return tasks.register("packageReleaseJar", ShadowJar::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Merges the bootstrap and user code jars into the single release jar."

            archiveBaseName.set(ArtifactNames.Release.JAR.removeSuffix(".jar"))
            archiveVersion.set("")
            archiveClassifier.set("")
            destinationDirectory.set(variantLibsDirectory())
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE

            dependsOn(packageBootstrapJarTask, packageUserCodeJarTask)
            configurations.clear()
            from(zipTree(packageBootstrapJarTask.flatMap(ShadowJar::getArchiveFile))) { copySpec ->
                copySpec.exclude("META-INF/MANIFEST.MF")
            }
            from(zipTree(packageUserCodeJarTask.flatMap(ShadowJar::getArchiveFile))) { copySpec ->
                copySpec.exclude("META-INF/MANIFEST.MF")
            }

            // godotSplitImplementation jars stay intact next to the release jar, so the class path entry follows it.
            manifest.attributes[
                "Class-Path"
            ] = provider {
                godotSplitImplementation.files
                    .filter { file -> file.extension == "jar" }
                    .sortedBy { file -> file.name }
                    .joinToString(" ") { file -> "${Paths.DEPENDENCIES_DIR}/${file.name}" }
            }

            mergeServiceFiles()
        }
    }
}
