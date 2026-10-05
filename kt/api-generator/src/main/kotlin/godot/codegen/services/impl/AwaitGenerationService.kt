package godot.codegen.services.impl

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.UNIT
import godot.codegen.constants.Core
import godot.codegen.constants.Coroutines
import godot.codegen.services.IAwaitGenerationService
import godot.common.constants.Constraints
import godot.tools.common.constants.godotCoroutinePackage
import java.io.File

object AwaitGenerationService : IAwaitGenerationService {
    override fun generate(output: File) {
        val awaitFile = FileSpec.builder(godotCoroutinePackage, Coroutines.await.simpleName)

        val allParameters = Array(Constraints.MAX_ARGUMENT_COUNT) { index ->
            TypeVariableName("P$index")
        }.toList()

        for (argCount in 0..Constraints.MAX_ARGUMENT_COUNT) {
            val parameters = allParameters.take(argCount)

            val baseReceiver = Core.signal(argCount)
            val receiver = if (argCount != 0) {
                baseReceiver.parameterizedBy(parameters)
            } else {
                baseReceiver
            }

            val returnType: TypeName = when (argCount) {
                0 -> UNIT
                1 -> parameters[0]
                else -> Core.signalArguments(argCount).parameterizedBy(parameters)
            }

            // Create a tuple for the signal arguments
            if (argCount >= 2) {
                val signalArguments = Core.signalArguments(argCount)
                awaitFile.addType(
                    TypeSpec.classBuilder(signalArguments.simpleName)
                        .addModifiers(KModifier.DATA)
                        .primaryConstructor(
                            FunSpec
                                .constructorBuilder()
                                .apply {
                                    parameters.forEachIndexed { index, parameter ->
                                        addParameter("p$index", parameter)
                                    }
                                }
                                .build()
                        )
                        .addProperties(
                            parameters.mapIndexed { index, parameter ->
                                PropertySpec
                                    .builder("p$index", parameter)
                                    .initializer("p$index")
                                    .build()
                            }
                        )
                        .addTypeVariables(parameters)
                        .build()
                )
            }

            awaitFile.addFunction(
                FunSpec.builder(Coroutines.awaitMethodName)
                    .addModifiers(KModifier.SUSPEND, KModifier.INLINE)
                    .receiver(receiver)
                    .apply {
                        if (argCount != 0) {
                            addTypeVariables(parameters.map { it.copy(reified = true) })
                        }
                    }
                    .generateBody(argCount, returnType)
                    .returns(returnType)
                    .build()
            )
        }

        awaitFile
            .addAnnotation(
                AnnotationSpec.builder(Suppress::class)
                    .addMember("\"PackageDirectoryMismatch\", \"unused\"")
                    .build()
            )
            .indent("    ")
            .build()
            .writeTo(output)
    }


    private fun FunSpec.Builder.generateBody(argCount: Int, returnType: TypeName): FunSpec.Builder {
        // Build `p0, p1, ..., px`
        val lambdaParameters = buildString {
            for (i in 0 until argCount) {
                if (i != 0) {
                    append(",·")
                }
                append("p$i")
            }
        }

        // Build what is inserted into the `resume()` method : `Unit`, `po`, `SignalArgumentsX(p0, p1, p2, ...).`
        val resumeParameters = when (argCount) {
            0 -> "Unit"
            1 -> lambdaParameters
            else -> "${Core.signalArguments(argCount).simpleName}($lambdaParameters)"
        }
        val lambdaParametersWithType = buildString {
            for (i in 0 until argCount) {
                if (i != 0) {
                    append(",·")
                }
                append("p$i:·P$i")
            }
        }

        return this
            .beginControlFlow("return·%M", Coroutines.suspendCancellableCoroutine)
            .addStatement("cont:·%T<%T>·->", Coroutines.cancellableContinuation, returnType)
            .addStatement("%M(", Coroutines.promise)
            .addStatement("{·$lambdaParametersWithType·->·cont.%M($resumeParameters)·},", Coroutines.resume)
            .addStatement("{·cont.%L()·},", Coroutines.cancel)
            .addStatement(")")
            .endControlFlow()
    }
}

