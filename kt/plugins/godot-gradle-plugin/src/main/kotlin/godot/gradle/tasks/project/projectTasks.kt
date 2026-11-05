package godot.gradle.tasks.project

import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.godotJvmDirectory
import godot.gradle.projectExt.kotlinJvmExtension
import godot.gradle.projectExt.requireConfiguredGodotProjectDirectory
import godot.gradle.projectExt.sourceSet
import org.gradle.api.Project
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.TaskProvider
import java.io.File

class ProjectTasks(
    val generateGdIgnoreFiles: TaskProvider<GenerateGdIgnoreFilesTask>,
    val checkIgnoredScriptSources: TaskProvider<CheckIgnoredScriptSourcesTask>,
)

fun Project.scriptSourceRoots(): List<File> =
    (sourceSet(BuildType.DEBUG).allJava.srcDirs + kotlinJvmExtension.sourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME).kotlin.srcDirs)
        .distinct()

fun Project.registerProjectTasks(): ProjectTasks {
    val godotJvmDirectory = godotJvmDirectory()
    val generateGdIgnoreFiles = tasks.register("generateGdIgnoreFiles", GenerateGdIgnoreFilesTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Generates .gdignore files to hide Gradle files, build output, embedded JREs and editor metadata from Godot."
        task.buildDirectory.set(layout.buildDirectory)
        task.gradleDirectory.set(layout.projectDirectory.dir("gradle"))
        task.godotJvmDirectory.set(godotJvmDirectory)
    }
    val checkIgnoredScriptSources = tasks.register("checkIgnoredScriptSources", CheckIgnoredScriptSourcesTask::class.java) { task ->
        task.group = "verification"
        task.description = "Warns when .gdignore hides a JVM script source root from Godot."
        task.godotProjectDirPath.set(requireConfiguredGodotProjectDirectory().absolutePath)
        task.sourceRootPaths.set(scriptSourceRoots().map(File::getAbsolutePath))
    }
    return ProjectTasks(generateGdIgnoreFiles, checkIgnoredScriptSources)
}
