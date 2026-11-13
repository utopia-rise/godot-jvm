package godot.gradle.tasks.registration

import godot.annotation.processor.classgraph.AnnotationProcessingMode
import godot.annotation.processor.classgraph.ClassGraphProcessor
import godot.annotation.processor.classgraph.ProcessorSettings
import godot.registration.model.ModelCheck
import godot.registration.model.checks.ChecksFailedException
import godot.registration.model.logging.LoggerWrapper
import godot.registration.model.types.ScriptClass
import godot.registrar.generator.RegisteredNameMode
import godot.registrar.generator.RegistrarGenerator
import godot.registrar.generator.RegistrationFileIndentation
import godot.registrar.generator.RegistrationFileLayoutMode
import godot.registrar.generator.Settings
import godot.registrar.generator.ext.getRegisteredName
import godot.tools.common.constants.godotRegistrarBasePackage
import godot.tools.common.constants.godotRegistrationPackage
import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

private const val registrarServiceName = "$godotRegistrationPackage.ClassRegistrar"

@CacheableTask
abstract class GenerateRegistrarsTask : DefaultTask() {
    @get:Classpath
    abstract val userCodeClassPathRoots: ConfigurableFileCollection

    @get:Classpath
    abstract val runtimeClassPathFiles: ConfigurableFileCollection

    @get:Input
    abstract val registeredNameMode: Property<RegisteredNameMode>

    @get:Input
    abstract val projectName: Property<String>

    @get:Input
    abstract val registrationFileLayoutMode: Property<RegistrationFileLayoutMode>

    @get:Input
    abstract val registrationFileIndentation: Property<RegistrationFileIndentation>

    @get:Input
    abstract val disableGdj: Property<Boolean>

    @get:Input
    abstract val annotationProcessingMode: Property<AnnotationProcessingMode>

    @get:OutputDirectory
    abstract val generatedSourceRootDir: DirectoryProperty

    @get:OutputDirectory
    abstract val generatedRegistrationFilesRootDir: DirectoryProperty

    @TaskAction
    fun generate() {
        val outputRoot = generatedSourceRootDir.get().asFile
        val generatedRegistrationRoot = generatedRegistrationFilesRootDir.get().asFile
        val settings = Settings(
            registeredNameMode = registeredNameMode.get(),
            projectName = projectName.get(),
            registrationFileLayoutMode = registrationFileLayoutMode.get(),
            registrationFileIndentation = registrationFileIndentation.get(),
        )
        val processorSettings = ProcessorSettings(
            projectName = projectName.get(),
            userCodeClassPathRoots = userCodeClassPathRoots.files.map { it.canonicalFile }.toSet(),
            annotationProcessingMode = annotationProcessingMode.get(),
        )
        val modelLogger = LoggerWrapper(logger)

        outputRoot.deleteRecursively()
        outputRoot.mkdirs()
        if (!disableGdj.get()) {
            generatedRegistrationRoot.mkdirs()
        }

        val scriptClasses = ClassGraphProcessor.process(
            runtimeClassPathFiles = runtimeClassPathFiles.files.map { it.canonicalFile }.toSet(),
            settings = processorSettings,
        )
        val registeredClasses = scriptClasses.filter { scriptClass -> scriptClass.isRegistered }
        val registeredNameProvider = { scriptClass: ScriptClass -> scriptClass.getRegisteredName(settings) }
            .takeIf { settings.registeredNameMode == RegisteredNameMode.SIMPLE_NAME }
        if (!ModelCheck.check(registeredClasses, modelLogger, registeredNameProvider)) throw ChecksFailedException()

        RegistrarGenerator.generateClassArtifacts(
            settings = settings,
            logger = modelLogger,
            scriptClasses = scriptClasses,
            sourceOutputDir = outputRoot.resolve("main").resolve("kotlin"),
            registrationOutputDir = generatedRegistrationRoot.takeUnless { disableGdj.get() },
        )
        writeRegistrarServiceFile(outputRoot, registeredClasses, settings)
    }

    private fun writeRegistrarServiceFile(outputRoot: File, registeredClasses: List<ScriptClass>, settings: Settings) {
        val serviceFile = outputRoot
            .resolve("resources")
            .resolve("META-INF")
            .resolve("services")
            .resolve(registrarServiceName)
        serviceFile.parentFile.mkdirs()
        serviceFile.writeText(
            registeredClasses
                .map { scriptClass -> "$godotRegistrarBasePackage.${scriptClass.getRegisteredName(settings)}Registrar" }
                .sorted()
                .joinToString(separator = "\n")
        )
    }
}
