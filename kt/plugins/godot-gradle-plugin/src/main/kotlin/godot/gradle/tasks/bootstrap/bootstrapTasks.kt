package godot.gradle.tasks.bootstrap

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.BOOTSTRAP_CONFIGURATION
import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.godotJvmDirectory
import godot.gradle.projectExt.registerGodotJar
import godot.gradle.projectExt.sourceSet
import godot.gradle.tasks.copy.CopyIntoGodotProjectTask
import godot.gradle.tasks.copy.registerCopyIntoGodotProject
import godot.gradle.tasks.dependencies.splitDependencyClassPath
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.Project
import org.gradle.api.tasks.TaskProvider

class BootstrapTasks(
    val bootstrapJar: TaskProvider<ShadowJar>,
    val copyBootstrapJar: TaskProvider<CopyIntoGodotProjectTask>?,
)

fun Project.registerBootstrapTasks(buildType: BuildType): BootstrapTasks {
    val bootstrapConfiguration = configurations.getByName(buildType.named(BOOTSTRAP_CONFIGURATION))
    val runtimeClasspath = configurations.getByName(sourceSet(buildType).runtimeClasspathConfigurationName)
    val classPath = splitDependencyClassPath()

    val bootstrapJar = registerGodotJar(
        name = buildType.named("packageBootstrapJar"),
        description = "Creates a fat jar containing everything needed to load and run the usercode.jar",
        fileName = ArtifactNames.Debug.BOOTSTRAP_JAR,
        buildType = buildType,
    ) { task ->
        task.configurations.add(bootstrapConfiguration)
        task.configurations.add(runtimeClasspath)
        task.manifest.attributes["Class-Path"] = classPath
    }

    val copyBootstrapJar = if (buildType == BuildType.DEBUG) {
        registerCopyIntoGodotProject(
            name = "copyBootstrapJar",
            description = "Copies the debug bootstrap jar into the Godot project.",
            bootstrapJar.flatMap(ShadowJar::getArchiveFile) to
                godotJvmDirectory().resolve(buildType.id).resolve(ArtifactNames.Debug.BOOTSTRAP_JAR),
        )
    } else {
        null
    }
    return BootstrapTasks(bootstrapJar, copyBootstrapJar)
}
