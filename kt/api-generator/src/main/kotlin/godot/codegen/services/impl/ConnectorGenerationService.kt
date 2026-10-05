package godot.codegen.services.impl

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.buildCodeBlock
import godot.codegen.constants.API
import godot.codegen.constants.Core
import godot.codegen.constants.Generator
import godot.codegen.constants.Utils
import godot.codegen.constants.VariantConverter
import godot.codegen.poet.GenericClassNameInfo
import godot.codegen.services.IConnectorGenerationService
import godot.common.constants.Constraints
import godot.tools.common.constants.godotExtensionPackage
import java.io.File
import kotlin.reflect.KCallable

object ConnectorGenerationService : IConnectorGenerationService {
    private val godotObjectBoundTypeVariable = TypeVariableName("T", API.`object`)
    private val javaClassClassName = Class::class.asClassName()
    private val returnTypeParameter = TypeVariableName("R", ANY.copy(nullable = true))

    private fun javaOnlyLambdaHelperName(argCount: Int) = "_connectLambda${argCount}Java"

    private fun javaOnlyMethodHelperName(argCount: Int) = "_connectMethod${argCount}Java"

    override fun generate(extensionDir: File) {
        val connectorFileSpec = FileSpec.builder(godotExtensionPackage, Core.signalConnectorsFileName)

        for (argCount in 0..Constraints.MAX_FUNCTION_ARG_COUNT) {
            val signalClassName = Core.signal(argCount)
            val lambdaCallableClassName = Core.lambdaCallable(argCount)
            val jvmActionClassName = Core.jvmAction(argCount)
            val methodCallableClassName = Core.methodCallable(argCount)
            val methodStringClassName = Core.methodStringName(argCount)
            val genericClassNameInfo = GenericClassNameInfo(signalClassName, argCount)
            val genericParameters = genericClassNameInfo.genericTypes
            val genericJvmAction = if (genericParameters.isEmpty()) {
                jvmActionClassName
            } else {
                jvmActionClassName.parameterizedBy(genericParameters)
            }

            val flagsParameter = ParameterSpec.builder(Generator.flagsParameterName, Core.connectFlags)
                .defaultValue("%T.%L", Core.connectFlags, "DEFAULT")
                .build()

            connectorFileSpec.addFunction(
                genericClassNameInfo
                    .toReifiedExtensionFunSpecBuilder(Core.connectLambdaMethodName)
                    .addParameters(
                        listOf(
                            flagsParameter,
                            ParameterSpec
                                .builder(
                                    Generator.methodParameterName,
                                    LambdaTypeName.get(
                                        parameters = genericClassNameInfo.toParameterSpecList(),
                                        returnType = UNIT
                                    )
                                )
                                .addModifiers(KModifier.NOINLINE)
                                .build()
                        )
                    )
                    .addCode(
                        CodeBlock.of(
                            """
                                val connector = %T.createUnsafe(
                                    this, 
                                    ${Generator.methodParameterName}.%M()
                                )
                                connector.connect(${Generator.flagsParameterName})
                                return connector
                            """.trimIndent(),
                            Core.signalConnector,
                            Utils.asCallable
                        )
                    )
                    .returns(Core.signalConnector)
                    .build()
            )

            connectorFileSpec.addFunction(
                genericClassNameInfo
                    .toExtensionFunSpecBuilder(javaOnlyLambdaHelperName(argCount))
                    .addParameters(
                        buildList {
                            add(flagsParameter)
                            addAll(
                                genericParameters.mapIndexed { index, typeVariableName ->
                                    ParameterSpec.builder("p${index}Type", javaClassClassName.parameterizedBy(typeVariableName)).build()
                                }
                            )
                            add(ParameterSpec.builder("action", genericJvmAction).build())
                        }
                    )
                    .returns(Core.signalConnector)
                    .addAnnotation(JvmOverloads::class)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("%S", Core.connectLambdaMethodName + argCount)
                            .build()
                    )
                    .addCode(
                        buildCodeBlock {
                            add("val connector = %T.createUnsafe(\n", Core.signalConnector)
                            indent()
                            add("this,\n")
                            add("%T._createJava(", lambdaCallableClassName)
                            genericParameters.forEachIndexed { index, _ ->
                                if (index != 0) add(",·")
                                add("p${index}Type")
                            }
                            if (genericParameters.isNotEmpty()) add(",·")
                            add("action)\n")
                            unindent()
                            add(")\n")
                            add("connector.connect(${Generator.flagsParameterName})\n")
                            add("return connector\n")
                        }
                    )
                    .build()
            )

            val lambdaTypeName = genericClassNameInfo.toLambdaTypeName(UNIT, godotObjectBoundTypeVariable)

            connectorFileSpec.addFunction(
                genericClassNameInfo
                    .toExtensionFunSpecBuilder(Core.connectMethodMethodName, listOf(godotObjectBoundTypeVariable))
                    .addParameters(
                        listOf(
                            ParameterSpec.builder(Generator.targetArgumentName, godotObjectBoundTypeVariable).build(),
                            ParameterSpec.builder(Generator.methodParameterName, lambdaTypeName).build(),
                            flagsParameter
                        )
                    )
                    .returns(Core.signalConnector)
                    .addCode(
                        CodeBlock.of(
                            """
                                val connector = %T.createUnsafe(
                                    this, 
                                    %T(${Generator.targetArgumentName},·(${Generator.methodParameterName}·as·%T<*>).name.%M())
                                )
                                connector.connect(${Generator.flagsParameterName})
                                return connector
                            """.trimIndent(),
                            Core.signalConnector,
                            Core.methodCallable,
                            KCallable::class,
                            Utils.toGodotName,
                        )
                    )
                    .addAnnotation(JvmSynthetic::class)
                    .build()
            )

            connectorFileSpec.addFunction(
                genericClassNameInfo
                    .toExtensionFunSpecBuilder(javaOnlyMethodHelperName(argCount), listOf(godotObjectBoundTypeVariable, returnTypeParameter))
                    .addParameters(
                        listOf(
                            ParameterSpec.builder(Generator.targetArgumentName, godotObjectBoundTypeVariable).build(),
                            ParameterSpec
                                .builder(
                                    Generator.methodParameterName,
                                    methodStringClassName.parameterizedBy(listOf(godotObjectBoundTypeVariable, returnTypeParameter) + genericParameters)
                                )
                                .build(),
                            flagsParameter
                        )
                    )
                    .returns(Core.signalConnector)
                    .addAnnotation(JvmOverloads::class)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("%S", Core.connectMethodMethodName + argCount)
                            .build()
                    )
                    .addCode(
                        CodeBlock.of(
                            """
                                val connector = %T.createUnsafe(
                                    this,
                                    %T._createJava(${Generator.targetArgumentName}, ${Generator.methodParameterName})
                                )
                                connector.connect(${Generator.flagsParameterName})
                                return connector
                            """.trimIndent(),
                            Core.signalConnector,
                            methodCallableClassName,
                        )
                    )
                    .build()
            )

            val containerInfo = GenericClassNameInfo(Core.lambdaContainer(argCount), argCount)
            connectorFileSpec.addFunction(
                genericClassNameInfo
                    .toReifiedExtensionFunSpecBuilder(Utils.promise.simpleName)
                    .addParameters(
                        listOf(
                            ParameterSpec
                                .builder(
                                    Generator.methodParameterName,
                                    LambdaTypeName.get(
                                        parameters = genericClassNameInfo.toParameterSpecList(),
                                        returnType = UNIT
                                    )
                                )
                                .addModifiers(KModifier.NOINLINE)
                                .build(),
                            ParameterSpec
                                .builder(
                                    Generator.cancelParameterName,
                                    LambdaTypeName.get(returnType = UNIT)
                                )
                                .addModifiers(KModifier.NOINLINE)
                                .build()
                        )
                    )
                    .addCode(
                        CodeBlock.of(
                            buildString {
                                append("%T(%M,·arrayOf(")
                                genericParameters.forEachIndexed { index, _ ->
                                    if (index != 0) append(",·")
                                    append("%M(%T::class)!!")
                                }
                                append("),·${Generator.methodParameterName}).setAsCancellable(this,·${Generator.cancelParameterName})")
                            },
                            containerInfo.className.parameterizedBy(listOf(UNIT) + containerInfo.genericTypes),
                            VariantConverter.NIL,
                            *genericParameters
                                .flatMap {
                                    listOf(Utils.getVariantConverter, it)
                                }
                                .toTypedArray()
                        )
                    )
                    .build()
            )
        }

        connectorFileSpec
            .addAnnotation(
                AnnotationSpec.builder(JvmName::class)
                    .useSiteTarget(AnnotationSpec.UseSiteTarget.FILE)
                    .addMember("%S", Core.signalConnectorsFileName)
                    .build()
            )
            .addAnnotation(
                AnnotationSpec
                    .builder(Suppress::class)
                    .addMember("\"PackageDirectoryMismatch\", \"UNCHECKED_CAST\"")
                    .addMember("\"unused\"")
                    .addMember("\"NOTHING_TO_INLINE\"")
                    .build()
            )
            .build()
            .writeTo(extensionDir)
    }
}
