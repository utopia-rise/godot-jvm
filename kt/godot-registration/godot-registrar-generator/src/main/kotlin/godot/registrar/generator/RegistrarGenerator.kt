package godot.registrar.generator

import godot.registrar.generator.builder.RegistrarClassGenerator
import godot.registrar.generator.builder.RegistrationFileBuilder
import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass
import java.io.File

object RegistrarGenerator {
    fun generateClassArtifacts(
        settings: Settings,
        logger: Logger,
        scriptClasses: List<ScriptClass>,
        sourceOutputDir: File,
        registrationOutputDir: File? = null,
    ) {
        val registeredClasses = scriptClasses.filter { scriptClass -> scriptClass.isRegistered }
        val context = GeneratorContext(
            settings = settings,
            logger = logger,
            registeredClassesByFqName = registeredClasses.associateBy { scriptClass -> scriptClass.fqName },
        )
        RegistrarClassGenerator(context, sourceOutputDir).generate(registeredClasses)
        registrationOutputDir?.let { outputDir ->
            RegistrationFileBuilder(context, settings, outputDir).generate(registeredClasses)
        }
    }
}
