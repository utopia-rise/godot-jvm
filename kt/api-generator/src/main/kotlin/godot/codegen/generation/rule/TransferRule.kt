package godot.codegen.generation.rule

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.ARRAY
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.WildcardTypeName
import godot.codegen.constants.Internal
import godot.codegen.constants.VariantConverter
import godot.codegen.generation.GenerationContext
import godot.codegen.generation.TransferSignature
import godot.codegen.generation.task.ApiTask
import godot.codegen.generation.task.TransferTask
import godot.tools.common.constants.GENERATED_COMMENT

class TransferRule : GodotApiRule<ApiTask>() {
    override fun apply(task: ApiTask, context: GenerationContext) {
        val calls = TransferTask("MethodCalls").also {
            it.builder.addFileComment(GENERATED_COMMENT)
            it.builder.addAnnotation(
                AnnotationSpec.builder(Suppress::class)
                    .addMember("\"unused\", \"FunctionName\", \"RedundantVisibilityModifier\", \"RedundantUnitReturnType\"")
                    .build()
            )
        }
        for (signature in context.methodSignatures) {
            calls.builder.addFunction(call(signature, context))
        }
        task.transferFiles.add(calls)
    }

    private fun call(signature: TransferSignature, context: GenerationContext): FunSpec {
        val builder = FunSpec.builder(signature.name)
            .addModifiers(KModifier.INTERNAL)
            .receiver(Internal.transferContext)
            .addParameter("callerPtr", Internal.voidPtr)
            .addParameter("callerId", LONG)
            .addParameter("methodPtr", Internal.voidPtr)
        signature.converters.forEachIndexed { index, converter ->
            builder.addParameter("p$index", VariantConverter.bufferType(converter))
        }
        if (signature.isVararg) {
            builder.addParameter("args", ARRAY.parameterizedBy(WildcardTypeName.producerOf(ANY.copy(nullable = true))))
        }
        if (signature.returnsValue) {
            builder.returns(VariantConverter.bufferType(signature.returnConverter))
        }

        val fixedCount = signature.converters.size
        val argumentCount = when {
            !signature.isVararg -> "$fixedCount"
            fixedCount == 0 -> "args.size"
            else -> "$fixedCount·+·args.size"
        }
        val needsBuffer = fixedCount > 0 || signature.isVararg || signature.returnsValue
        if (needsBuffer) {
            builder.addStatement("val·buffer·=·beginMethodCall(callerPtr,·callerId,·$argumentCount)")
        } else {
            builder.addStatement("beginMethodCall(callerPtr,·callerId,·$argumentCount)")
        }

        signature.converters.forEachIndexed { index, converter ->
            val writeMethod = if (converter in VariantConverter.primitives) "write" else "toGodot"
            builder.addStatement("%M.$writeMethod(buffer,·p$index)", converter)
        }
        if (signature.isVararg) {
            builder.beginControlFlow("for·(arg·in·args)")
                .addStatement("%M.toGodot(buffer,·arg)", VariantConverter.ANY)
                .endControlFlow()
        }

        if (signature.isVariantCall) {
            builder.addStatement("callMethod(methodPtr)")
        } else {
            builder.addStatement("callPtrMethod(methodPtr,·${returnOrdinal(signature, context)})")
        }

        if (signature.returnsValue) {
            val readMethod = if (signature.returnConverter in VariantConverter.primitives) "read" else "toKotlin"
            // The same buffer the arguments went into: the engine wrote the result over it.
            builder.addStatement("return·%M.$readMethod(buffer.rewind())", signature.returnConverter)
        }
        return builder.build()
    }

    // A method whose declared return class is a RefCounted returns a Ref<T> in the engine, and a ptrcall encodes that
    // as an owned reference the native side must release. The pointer bytes cannot show that, so Variant::TYPE_MAX is
    // sent in place of the OBJECT ordinal to say so.
    private fun returnOrdinal(signature: TransferSignature, context: GenerationContext): Int =
        if (signature.isRefCountedReturn) {
            context.refCountedReturnType
        } else {
            VariantConverter.variantOrdinal(signature.returnConverter)
        }
}
