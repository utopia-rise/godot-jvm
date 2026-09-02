package godot.codegen.services.impl

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.UNIT
import godot.codegen.constants.Core
import godot.codegen.constants.Coroutines
import godot.codegen.services.IFlowGenerationService
import godot.common.constants.Constraints
import godot.tools.common.constants.godotCoroutinePackage
import java.io.File

object FlowGenerationService : IFlowGenerationService {
    override fun generate(output: File) {
        val flowFile = FileSpec.builder(godotCoroutinePackage, Coroutines.flow.simpleName)
        val allParameters = Array(Constraints.MAX_FUNCTION_ARG_COUNT) { index ->
            TypeVariableName("P$index")
        }.toList()

        for (argCount in 0..Constraints.MAX_FUNCTION_ARG_COUNT) {
            val parameters = allParameters.take(argCount)
            val receiver = Core.signal(argCount).let { signal ->
                if (argCount == 0) signal else signal.parameterizedBy(parameters)
            }
            val valueType: TypeName = when (argCount) {
                0 -> UNIT
                1 -> parameters[0]
                else -> Core.signalArguments(argCount).parameterizedBy(parameters)
            }

            flowFile.addFunction(
                FunSpec.builder(Coroutines.asFlowMethodName)
                    .addModifiers(KModifier.INLINE)
                    .receiver(receiver)
                    .apply {
                        if (argCount != 0) {
                            addTypeVariables(parameters.map { it.copy(reified = true) })
                        }
                    }
                    .returns(Coroutines.flowType.parameterizedBy(valueType))
                    .addCode(generateBody(argCount))
                    .build()
            )
        }

        flowFile
            .addAnnotation(
                AnnotationSpec.builder(Suppress::class)
                    .addMember("\"PackageDirectoryMismatch\", \"unused\"")
                    .build()
            )
            .indent("    ")
            .build()
            .writeTo(output)
    }

    private fun generateBody(argCount: Int) = CodeBlock.builder()
        .beginControlFlow("return %M", Coroutines.callbackFlow)
        .addStatement("val callable = { %L -> trySend(%L); Unit }.%M()", lambdaParameters(argCount), value(argCount), Core.asCallable)
        .addStatement("connectUnsafe(callable)")
        .addStatement("%M { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }", Coroutines.awaitClose)
        .endControlFlow()
        .build()

    private fun lambdaParameters(argCount: Int): String = buildString {
        for (index in 0 until argCount) {
            if (index != 0) append(", ")
            append("p$index: P$index")
        }
    }

    private fun value(argCount: Int): String = when (argCount) {
        0 -> "Unit"
        1 -> "p0"
        else -> "SignalArguments$argCount(${(0 until argCount).joinToString { "p$it" }})"
    }
}
