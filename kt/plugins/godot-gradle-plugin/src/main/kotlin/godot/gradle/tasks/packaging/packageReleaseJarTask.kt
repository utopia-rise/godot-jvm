package godot.gradle.tasks

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.GODOT_SPLIT_RUNTIME_CLASSPATH_CONFIGURATION
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
    val splitDependencies = configurations.getByName(GODOT_SPLIT_RUNTIME_CLASSPATH_CONFIGURATION)

    return tasks.register("packageReleaseJar", ShadowJar::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Merges the bootstrap and user code jars into the single release jar."

            archiveBaseName.set(ArtifactNames.Release.JAR.removeSuffix(".jar"))
            archiveVersion.set("")
            archiveClassifier.set("")
            destinationDirectory.set(variantLibsDirectory())
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            // EXCLUDE drops a duplicate before mergeServiceFiles sees it.
            filesMatching("META-INF/services/**") { service -> service.duplicatesStrategy = DuplicatesStrategy.INCLUDE }

            dependsOn(packageBootstrapJarTask, packageUserCodeJarTask)
            configurations.clear()
            from(zipTree(packageBootstrapJarTask.flatMap(ShadowJar::getArchiveFile))) { copySpec ->
                copySpec.exclude("META-INF/MANIFEST.MF")
            }
            from(zipTree(packageUserCodeJarTask.flatMap(ShadowJar::getArchiveFile))) { copySpec ->
                copySpec.exclude("META-INF/MANIFEST.MF")
            }

            // Split dependency jars stay intact next to the release jar, so the class path entry follows it.
            manifest.attributes[
                "Class-Path"
            ] = provider {
                splitDependencies.files
                    .filter { file -> file.extension == "jar" }
                    .sortedBy { file -> file.name }
                    .joinToString(" ") { file -> "${Paths.DEPENDENCIES_DIR}/${file.name}" }
            }
            // Shadow copies the META-INF/versions entries of merged multi-release jars but not their manifest flag.
            manifest.attributes["Multi-Release"] = "true"

            mergeServiceFiles()
        }
    }
}
