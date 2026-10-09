package godot.codegen.generation.rule

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import godot.codegen.constants.Core
import godot.codegen.generation.GenerationContext
import godot.codegen.generation.task.EnrichedEnumTask
import godot.codegen.generation.task.FileTask
import godot.codegen.models.enriched.EnrichedEnum
import godot.codegen.models.traits.addKdoc

private const val BIT_FLAG_VALUE_MEMBER = "flag"
private const val ENUM_VALUE_PARAMETER = "value"
private const val ENUM_VALUE_PROPERTY = "value"

class EnumRule : GodotApiRule<EnrichedEnumTask>() {

    override fun apply(task: EnrichedEnumTask, context: GenerationContext) = with(task.builder) {
        val enum = task.enum
        if (enum.isBitField()) {
            generateBitfield(enum)
        } else {
            generateEnum(enum)
        }
    }

    fun TypeSpec.Builder.generateEnum(enum: EnrichedEnum) {
        addSuperinterface(Core.godotEnum)

        primaryConstructor(
            FunSpec.constructorBuilder()
                .addParameter(ENUM_VALUE_PARAMETER, Long::class)
                .build()
        )
        addProperty(
            PropertySpec.builder(ENUM_VALUE_PROPERTY, Long::class, KModifier.OVERRIDE)
                .initializer(ENUM_VALUE_PARAMETER)
                .build()
        )

        for (value in enum.values) {
            addEnumConstant(
                value.name,
                TypeSpec.anonymousClassBuilder()
                    .addSuperclassConstructorParameter("%L", value.value)
                    .also { it.addKdoc(value) }
                    .build()
            )
        }

        addType(
            TypeSpec.companionObjectBuilder()
                .addFunction(
                    FunSpec.builder("from")
                        .returns(enum.className)
                        .addParameter("value", Long::class)
                        .addStatement("return·entries.first·{·it.%N·==·%N·}", "value", "value")
                        .build()
                )
                .build()
        )
    }

    fun TypeSpec.Builder.generateBitfield(enum: EnrichedEnum) {
        val className = enum.className
        superclass(Core.bitFieldBase.parameterizedBy(className))

        primaryConstructor(
            FunSpec.constructorBuilder()
                .addParameter(ParameterSpec.builder(BIT_FLAG_VALUE_MEMBER, LONG).build())
                .build()
        )
        addSuperclassConstructorParameter(BIT_FLAG_VALUE_MEMBER)
        addFunction(
            FunSpec.builder("wrap")
                .addModifiers(KModifier.OVERRIDE, KModifier.PROTECTED)
                .addParameter(BIT_FLAG_VALUE_MEMBER, LONG)
                .returns(className)
                .addCode(CodeBlock.of("return·%T(%N)", className, BIT_FLAG_VALUE_MEMBER))
                .build()
        )

        val companion = TypeSpec.companionObjectBuilder()
        for (value in enum.values) {
            companion.addProperty(
                PropertySpec.builder(value.name, className)
                    .addAnnotation(JvmField::class)
                    .initializer(CodeBlock.of("%T(%L)", className, value.value))
                    .addKdoc(value)
                    .build()
            )
        }

        addType(companion.build())
    }
}

class BitfieldExtensionRule : GodotApiRule<FileTask>() {
    override fun apply(task: FileTask, context: GenerationContext) = with(task.builder) {
        val enums = task.classes.flatMap { it.enums } + task.enums

        enums.filter { it.enum.isBitField() }
            .forEach { enum ->
                val logicalOperations = arrayOf("or", "xor", "and")
                generateBitFieldExtensionsOperators(logicalOperations, enum.enum).forEach {
                    addFunction(it)
                }
            }
    }

    fun generateBitFieldExtensionsOperators(
        bitOperations: Array<String>,
        enum: EnrichedEnum,
    ): List<FunSpec> {
        return bitOperations.map { operation ->
            FunSpec.builder(operation)
                .addModifiers(KModifier.INFIX)
                .receiver(LONG)
                .addParameter(ParameterSpec.builder("other", enum.className).build())
                .returns(LONG)
                .addCode(CodeBlock.of("return·this.%L(other.%L)", operation, BIT_FLAG_VALUE_MEMBER))
                .build()
        }
    }
}
