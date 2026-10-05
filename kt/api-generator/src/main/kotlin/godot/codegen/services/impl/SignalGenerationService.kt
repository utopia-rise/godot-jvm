package godot.codegen.services.impl

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.UNIT
import godot.codegen.constants.API
import godot.codegen.constants.Core
import godot.codegen.constants.Generator
import godot.codegen.constants.Kotlin
import godot.codegen.constants.Utils
import godot.codegen.poet.GenericClassNameInfo
import godot.codegen.services.ISignalGenerationService
import godot.common.constants.Constraints
import java.io.File

object SignalGenerationService : ISignalGenerationService {
    private fun kotlinJavaHelperName(baseName: String) = "_${baseName}Java"

    override fun generate(outputDir: File) {
        val signalFileSpec = FileSpec.builder(Core.signal.packageName, Core.signalsFileName)

        for (argCount in 0..Constraints.MAX_FUNCTION_ARG_COUNT) {
            val signalClassName = Core.signal(argCount)
            val genericClassNameInfo = GenericClassNameInfo(signalClassName, argCount)

            signalFileSpec.addType(generateSignalClass(argCount, genericClassNameInfo))
            signalFileSpec.addFunction(generateFakeSignalConstructor(argCount, genericClassNameInfo))
            signalFileSpec.addFunction(generateSignalDelegate(argCount, genericClassNameInfo))
        }

        signalFileSpec
            .addAnnotation(
                AnnotationSpec
                    .builder(Suppress::class)
                    .addMember("\"PackageDirectoryMismatch\"")
                    .addMember("\"NOTHING_TO_INLINE\"")
                    .addMember("\"UNUSED_PARAMETER\"")
                    .addMember("\"unused\"")
                    .build()
            )
            .indent("    ")
            .build()
            .writeTo(outputDir)
    }

    private fun generateSignalClass(argCount: Int, genericClassNameInfo: GenericClassNameInfo): TypeSpec {
        val callableClassName = Core.callable(argCount)

        return genericClassNameInfo
            .toTypeSpecBuilder()
            .superclass(Core.signal)
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .addModifiers(KModifier.INTERNAL)
                    .addParameters(
                        listOf(
                            ParameterSpec.builder(Generator.instanceParameterName, Core.godotObject).build(),
                            ParameterSpec.builder(Generator.nameParameterName, Core.stringName).build()
                        )
                    )
                    .addAnnotation(PublishedApi::class)
                    .build()
            )
            .addSuperclassConstructorParameter(Generator.instanceParameterName)
            .addSuperclassConstructorParameter(Generator.nameParameterName)
            .addFunctions(
                listOf(
                    FunSpec.builder(Core.emitMethodName)
                        .returns(UNIT)
                        .addParameters(genericClassNameInfo.toParameterSpecList())
                        .addCode(
                            CodeBlock.of(
                                buildString {
                                    append("${Core.emitMethodName}${Core.unsafeSuffix}(")
                                    for (i in 0..<argCount) {
                                        if (i != 0) append(",·")
                                        append("p$i")
                                    }
                                    append(')')
                                }
                            )
                        )
                        .build(),
                    FunSpec.builder(Core.connectMethodName)
                        .returns(UNIT)
                        .addAnnotation(JvmOverloads::class)
                        .addParameters(
                            listOf(
                                ParameterSpec.builder(
                                    Generator.callableParameterName,
                                    callableClassName.parameterizedBy(listOf(STAR) + genericClassNameInfo.genericTypes)
                                ).build(),
                                ParameterSpec.builder(Generator.flagsParameterName, Core.connectFlags)
                                    .defaultValue("%T.%L", Core.connectFlags, "DEFAULT")
                                    .build()
                            )
                        )
                        .addCode(CodeBlock.of("connectUnsafe(${Generator.callableParameterName},·${Generator.flagsParameterName})"))
                        .build(),
                    FunSpec.builder(Core.disconnectMethodName)
                        .returns(UNIT)
                        .addParameters(
                            listOf(
                                ParameterSpec.builder(
                                    Generator.callableParameterName,
                                    callableClassName.parameterizedBy(listOf(STAR) + genericClassNameInfo.genericTypes)
                                ).build()
                            )
                        )
                        .addCode(CodeBlock.of("disconnectUnsafe(${Generator.callableParameterName})"))
                        .build(),
                )
            )
            .addType(generateSignalCompanion(argCount, genericClassNameInfo))
            .build()
    }

    private fun generateSignalCompanion(argCount: Int, genericClassNameInfo: GenericClassNameInfo): TypeSpec {
        val erasedReadOnlyPropertyClassName =
            Kotlin.readOnlyProperty.parameterizedBy(Core.godotObject, genericClassNameInfo.erasedGenericClassName)

        return TypeSpec.companionObjectBuilder()
            .addProperty(
                PropertySpec
                    .builder(Core.delegatePropertyName, erasedReadOnlyPropertyClassName, KModifier.INTERNAL)
                    .addAnnotation(PublishedApi::class)
                    .initializer(
                        "%T·{·${Generator.thisRefParameterName},·${Generator.propertyParameterName}·->·${Core.getValueMethodName}(${Generator.thisRefParameterName},·${Generator.propertyParameterName})·}",
                        Kotlin.readOnlyProperty
                    )
                    .build()
            )
            .addFunction(
                genericClassNameInfo
                    .toFunSpecBuilder(Core.getValueMethodName)
                    .addModifiers(KModifier.OPERATOR, KModifier.INLINE)
                    .addParameters(
                        listOf(
                            ParameterSpec.builder(Generator.thisRefParameterName, Core.godotObject).build(),
                            ParameterSpec.builder(Generator.propertyParameterName, Kotlin.kProperty.parameterizedBy(STAR)).build(),
                        )
                    )
                    .returns(genericClassNameInfo.genericClassName)
                    .addCode(
                        CodeBlock.of(
                            "return·%T(thisRef,·property.%M())",
                            genericClassNameInfo.className,
                            Utils.toGodotName
                        )
                    )
                    .build()
            )
            .addFunction(
                genericClassNameInfo
                    .toFunSpecBuilder(kotlinJavaHelperName(Core.createMethodName))
                    .addParameter(ParameterSpec.builder("godotObject", Core.godotObject).build())
                    .addParameter(ParameterSpec.builder("signalName", STRING).build())
                    .returns(genericClassNameInfo.genericClassName)
                    .addCode(
                        "return·%T(godotObject,·signalName.%M())",
                        genericClassNameInfo.className,
                        Utils.toGodotName
                    )
                    .addAnnotation(JvmStatic::class)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("%S", Core.createMethodName)
                            .build()
                    )
                    .build()
            )
            .build()
    }

    private fun generateFakeSignalConstructor(argCount: Int, genericClassNameInfo: GenericClassNameInfo): FunSpec {
        return FunSpec
            .builder(Core.signal(argCount).simpleName)
            .receiver(Core.godotObject)
            .addModifiers(KModifier.INLINE)
            .addTypeVariables(genericClassNameInfo.genericTypes)
            .addParameter(ParameterSpec.builder("signalName", STRING).build())
            .addCode(
                CodeBlock.of(
                    "return·%T(this,·signalName.%M())",
                    genericClassNameInfo.genericClassName,
                    Utils.toGodotName
                )
            )
            .addAnnotation(
                AnnotationSpec
                    .builder(Suppress::class)
                    .addMember("\"FUNCTION_NAME\"")
                    .build()
            )
            .build()
    }

    private fun generateSignalDelegate(argCount: Int, genericClassNameInfo: GenericClassNameInfo): FunSpec {
        val genericReadOnlyPropertyClassName =
            Kotlin.readOnlyProperty.parameterizedBy(Core.godotObject, genericClassNameInfo.genericClassName)

        return genericClassNameInfo
            .toFunSpecBuilder(Core.signalMethodName + argCount)
            .addModifiers(KModifier.INLINE)
            .receiver(Core.godotObject)
            .addCode(
                if (argCount == 0) {
                    CodeBlock.of("return·%T.${Core.delegatePropertyName}", genericClassNameInfo.className)
                } else {
                    CodeBlock.of(
                        "return·%T.${Core.delegatePropertyName}·as·%T",
                        genericClassNameInfo.className,
                        genericReadOnlyPropertyClassName
                    )
                }
            )
            .apply {
                if (argCount != 0) {
                    addAnnotation(
                        AnnotationSpec
                            .builder(Suppress::class)
                            .addMember("\"UNCHECKED_CAST\"")
                            .build()
                    )
                }
            }
            .build()
    }
}
