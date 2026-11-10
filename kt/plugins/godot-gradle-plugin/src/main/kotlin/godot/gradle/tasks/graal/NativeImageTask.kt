package godot.gradle.tasks.graal

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.process.ExecOperations
import javax.inject.Inject

abstract class NativeImageTask : DefaultTask() {
    @get:Classpath
    abstract val gameJars: ConfigurableFileCollection

    @get:Classpath
    abstract val splitDependencyJars: ConfigurableFileCollection

    @get:InputFile
    @get:PathSensitive(PathSensitivity.NONE)
    abstract val defaultJniConfig: RegularFileProperty

    @get:Internal
    abstract val workingDirectory: DirectoryProperty

    @get:Input
    abstract val nativeImageExecutable: Property<String>

    @get:Input
    abstract val verbose: Property<Boolean>

    @get:Input
    abstract val strictImageHeap: Property<Boolean>

    @get:Input
    abstract val optimizationLevel: Property<String>

    @get:Input
    abstract val additionalJniConfigurationFiles: Property<String>

    @get:Input
    abstract val additionalReflectionConfigurationFiles: Property<String>

    @get:Input
    abstract val additionalResourceConfigurationFiles: Property<String>

    @get:Inject
    abstract val execOperations: ExecOperations

    protected fun execute(command: List<String>) {
        logger.lifecycle(command.joinToString(" "))
        execOperations.exec { spec ->
            spec.workingDir = workingDirectory.get().asFile
            spec.commandLine(command)
        }
    }
}
