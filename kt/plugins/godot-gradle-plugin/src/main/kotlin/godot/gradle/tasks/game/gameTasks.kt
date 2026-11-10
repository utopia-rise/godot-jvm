package godot.gradle.tasks.game

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.godotJvmDirectory
import godot.gradle.projectExt.registerGodotJar
import godot.gradle.tasks.copy.CopyIntoGodotProjectTask
import godot.gradle.tasks.copy.registerCopyIntoGodotProject
import godot.gradle.tasks.dependencies.splitDependencyClassPath
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.tasks.TaskProvider

class GameTasks(
    val gameJar: TaskProvider<ShadowJar>,
    val copyGameJar: TaskProvider<CopyIntoGodotProjectTask>,
)

fun Project.registerGameTasks(bootstrapJar: TaskProvider<ShadowJar>, userCodeJar: TaskProvider<ShadowJar>): GameTasks {
    val classPath = splitDependencyClassPath()
    val gameJar = registerGodotJar(
        name = "packageGameJar",
        description = "Merges the release bootstrap and user code jars into the single release jar.",
        fileName = ArtifactNames.Release.JAR,
        buildType = BuildType.RELEASE,
    ) { task ->
        task.duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        task.filesMatching("META-INF/services/**") { service -> service.duplicatesStrategy = DuplicatesStrategy.INCLUDE }
        for (jar in listOf(bootstrapJar, userCodeJar)) {
            task.from(zipTree(jar.flatMap(ShadowJar::getArchiveFile))) { spec -> spec.exclude("META-INF/MANIFEST.MF") }
        }
        task.dependsOn(bootstrapJar, userCodeJar)
        task.manifest.attributes["Class-Path"] = classPath
    }
    val copyGameJar = registerCopyIntoGodotProject(
        name = "copyGameJar",
        description = "Copies the release jar into the Godot project.",
        gameJar.flatMap(ShadowJar::getArchiveFile) to
            godotJvmDirectory().resolve(BuildType.RELEASE.id).resolve(ArtifactNames.Release.JAR),
    )
    return GameTasks(gameJar, copyGameJar)
}
