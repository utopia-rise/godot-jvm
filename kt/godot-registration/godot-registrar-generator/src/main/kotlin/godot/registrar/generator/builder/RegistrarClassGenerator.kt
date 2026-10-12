package godot.registrar.generator.builder

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import godot.registrar.generator.GeneratorContext
import godot.registrar.generator.ext.baseGodotClassName
import godot.registrar.generator.ext.getRegisteredName
import godot.registrar.generator.ext.registeredSupertypes
import godot.registrar.generator.generator.addFunctionRegistrations
import godot.registrar.generator.generator.addNotificationRegistrations
import godot.registrar.generator.generator.addPropertyRegistrations
import godot.registrar.generator.generator.addSignalRegistrations
import godot.registration.ClassRegistrar
import godot.registration.KtClass
import godot.registration.model.types.ScriptClass
import godot.tools.common.constants.GENERATED_COMMENT
import godot.tools.common.constants.godotRegistrarBasePackage
import java.io.File

class RegistrarClassGenerator(
    private val context: GeneratorContext,
    private val sourceOutputDir: File,
) {
    fun generate(registeredClasses: List<ScriptClass>) {
        registeredClasses.forEach { registeredClass ->
            buildRegistrarFile(registeredClass).writeTo(sourceOutputDir)
        }
    }

    private fun buildRegistrarFile(registeredClass: ScriptClass): FileSpec {
        val registeredClassName = registeredClass.getRegisteredName(context.settings)
        return FileSpec
            .builder(godotRegistrarBasePackage, "${registeredClassName}Registrar")
            .addFileComment(GENERATED_COMMENT)
            .addAnnotation(AnnotationSpec.builder(Suppress::class).addMember("%S", "UNCHECKED_CAST").build())
            .addType(buildRegistrarType(registeredClass, registeredClassName))
            .build()
    }

    private fun buildRegistrarType(
        registeredClass: ScriptClass,
        registeredClassName: String,
    ): TypeSpec {
        val classRegistrarBuilder = TypeSpec
            .classBuilder("${registeredClassName}Registrar")
            .addModifiers(KModifier.OPEN)
            .addSuperinterface(ClassRegistrar::class)

        if (registeredClass.isAbstract) {
            classRegistrarBuilder.addKdoc(
                "Registrar for abstract class. Does not register any members as it's only used for default value providing if any properties with default values are provided in the abstract class. Members of this abstract class are registered by the inheriting registrars"
            )
        }

        classRegistrarBuilder.addFunction(buildRegister(registeredClass, registeredClassName))
        return classRegistrarBuilder.build()
    }

    private fun buildRegister(
        registeredClass: ScriptClass,
        registeredClassName: String,
    ): FunSpec {
        val className = ClassName(registeredClass.containingPackage, registeredClass.name)
        val registerFunctionBuilder = FunSpec
            .builder("register")
            .addModifiers(KModifier.OVERRIDE)
            .returns(KtClass::class.asClassName().parameterizedBy(STAR))

        registerFunctionBuilder.addCode(buildRegisterHeader(registeredClass, registeredClassName, className))

        if (!registeredClass.isAbstract) {
            if (registeredClass.constructors.any { it.parameterTypes.isEmpty() }) {
                registerFunctionBuilder.addStatement("constructor { %T() }", className)
            }
            registerFunctionBuilder.addSignalRegistrations(registeredClass, context)
            registerFunctionBuilder.addPropertyRegistrations(registeredClass, context, className)
            registerFunctionBuilder.addNotificationRegistrations(registeredClass, context)
            registerFunctionBuilder.addFunctionRegistrations(registeredClass, context, className)
        }

        registerFunctionBuilder.addCode(CodeBlock.builder().unindent().add("}\n").build())
        return registerFunctionBuilder.build()
    }

    private fun buildRegisterHeader(
        registeredClass: ScriptClass,
        registeredClassName: String,
        className: ClassName,
    ): CodeBlock {
        val registeredSupertypes = registeredClass.registeredSupertypes()
            .joinToString(",") { supertype -> "\"${supertype.getRegisteredName(context.settings)}\"" }

        return CodeBlock.builder()
            .add("return register(\n")
            .indent()
            .add("%S,\n", registeredClassName)
            .add("%S,\n", registeredClass.sourceFileName)
            .add("listOf($registeredSupertypes),\n")
            .add("%S,\n", registeredClass.baseGodotClassName())
            .add("%L,\n", registeredClass.isAbstract)
            .add("%T::class\n", className)
            .unindent()
            .add(") {\n")
            .indent()
            .build()
    }
}
