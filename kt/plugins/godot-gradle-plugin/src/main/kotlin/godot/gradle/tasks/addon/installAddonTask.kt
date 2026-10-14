package godot.gradle.tasks.addon

import godot.gradle.projectExt.godotJvmDependency
import godot.gradle.projectExt.godotJvmExtension
import godot.tools.common.BUILD_VERSION
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.attributes.Category
import org.gradle.api.file.ArchiveOperations
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileSystemOperations
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import javax.inject.Inject

/** Category of the `godot-jvm` variant that carries the addon zip, so library resolution never selects it. */
const val GODOT_ADDON_CATEGORY = "godot-addon"

private const val PREVIOUS_ADDON_PREFIX = ".jvm-previous-"

/**
 * Installs the addon published in `godot-jvm` at the plugin's own version in the project's `addons/jvm`, replacing the
 * current one if any, so the native library always matches the jars the plugin builds against.
 */
abstract class InstallAddonTask : DefaultTask() {
    @get:InputFiles
    abstract val addonArchive: ConfigurableFileCollection

    @get:Internal
    abstract val addonDirectory: DirectoryProperty

    @get:Input
    abstract val version: Property<String>

    @get:Internal
    abstract val resolutionFailures: ListProperty<String>

    @get:Inject
    abstract val archiveOperations: ArchiveOperations

    @get:Inject
    abstract val fileSystemOperations: FileSystemOperations

    @TaskAction
    fun install() {
        val archive = addonArchive.files.singleOrNull() ?: throw GradleException(
            "Could not get the Godot-JVM ${version.get()} addon. A Godot-JVM built from source or taken from JitPack has " +
                "none; otherwise, check that the project's repositories include the one this plugin comes from. Cause:\n" +
                resolutionFailures.get().joinToString("\n")
        )
        val target = addonDirectory.get().asFile

        val staging = temporaryDir.resolve("addon")
        fileSystemOperations.delete { it.delete(staging) }
        fileSystemOperations.copy { spec ->
            spec.from(archiveOperations.zipTree(archive))
            spec.into(staging)
        }
        val extracted = staging.resolve("addons/jvm")
        if (!extracted.resolve("jvm.gdextension").isFile) {
            throw GradleException("$archive does not contain addons/jvm/jvm.gdextension.")
        }

        // A running Godot editor keeps the native library open. Windows still lets the directory holding it be renamed,
        // never deleted, so the current addon is moved aside rather than deleted in place, which would leave it half
        // removed. Its name starts with a dot so Godot never imports it, and it is unique because an editor may still
        // hold the one a previous run moved aside.
        val addons = target.parentFile
        addons.listFiles { file -> file.name.startsWith(PREVIOUS_ADDON_PREFIX) }?.forEach { it.deleteRecursively() }
        val previous = addons.resolve("$PREVIOUS_ADDON_PREFIX${System.currentTimeMillis()}")
        if (target.exists() && !target.renameTo(previous)) {
            throw GradleException("Could not move $target aside. Close the programs using it and run the task again.")
        }
        fileSystemOperations.copy { spec ->
            spec.from(extracted)
            spec.into(target)
        }
        fileSystemOperations.delete { it.delete(staging) }

        logger.lifecycle("Replaced $target with the Godot-JVM ${version.get()} addon.")
        if (previous.exists() && !previous.deleteRecursively()) {
            logger.warn(
                "The previous addon is still in use, most likely by a running Godot editor: restart it to load the new one. " +
                    "${previous.name} is removed by the next run of this task."
            )
        }
    }
}

fun Project.installAddonTask(): TaskProvider<InstallAddonTask> {
    val addon = configurations.create("godotJvmAddon") { configuration ->
        configuration.isCanBeConsumed = false
        configuration.isTransitive = false
        configuration.attributes.attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category::class.java, GODOT_ADDON_CATEGORY))
        configuration.dependencies.add(godotJvmDependency("addon"))
    }

    return tasks.register("installAddon", InstallAddonTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Installs the Godot-JVM addon matching this plugin's version in addons/jvm, replacing the current one. A running Godot editor needs a restart to load it."
        // Lenient, so a missing addon reaches the task's own explanation, which Gradle's variant mismatch lacks, along
        // with Gradle's actual failure.
        val artifacts = addon.incoming.artifactView { view -> view.isLenient = true }.artifacts
        task.addonArchive.from(artifacts.artifactFiles)
        task.resolutionFailures.set(provider { artifacts.failures.map { failure -> failure.message ?: failure.toString() } })
        task.addonDirectory.set(godotJvmExtension.godotProjectDirectory.dir("addons/jvm"))
        task.version.set(BUILD_VERSION.value)
    }
}
