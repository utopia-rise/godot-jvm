package godot.codegen.generation.rule

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.ARRAY
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.MemberName
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
        val writers = transferTask("MethodArgumentWriters")
        for (signature in context.methodSignatures) {
            writers.builder.addFunction(writer(signature))
        }
        val readers = transferTask("ReturnValueReaders")
        for (converter in context.returnConverters) {
            readers.builder.addFunction(reader(converter))
        }
        task.transferFiles.add(writers)
        task.transferFiles.add(readers)
    }

    private fun transferTask(fileName: String) = TransferTask(fileName).also {
        it.builder.addFileComment(GENERATED_COMMENT)
        it.builder.addAnnotation(
            AnnotationSpec.builder(Suppress::class)
                .addMember("\"unused\", \"FunctionName\", \"RedundantVisibilityModifier\", \"RedundantUnitReturnType\"")
                .build()
        )
    }

    private fun writer(signature: TransferSignature): FunSpec {
        val builder = FunSpec.builder(signature.writerName)
            .addModifiers(KModifier.INTERNAL)
            .receiver(Internal.transferContext)
            .addParameter("callerPtr", Internal.voidPtr)
            .addParameter("callerId", LONG)
        signature.converters.forEachIndexed { index, converter ->
            builder.addParameter("p$index", VariantConverter.bufferType(converter))
        }
        val fixedCount = signature.converters.size
        if (!signature.isVararg) {
            if (fixedCount == 0) {
                return builder.addStatement("beginMethodCall(callerPtr,·callerId,·0)").build()
            }
            builder.addStatement("val·buffer·=·beginMethodCall(callerPtr,·callerId,·$fixedCount)")
        } else {
            builder.addParameter("args", ARRAY.parameterizedBy(WildcardTypeName.producerOf(ANY.copy(nullable = true))))
            val count = if (fixedCount == 0) "args.size" else "$fixedCount·+·args.size"
            builder.addStatement("val·buffer·=·beginMethodCall(callerPtr,·callerId,·$count)")
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
        return builder.build()
    }

    private fun reader(converter: MemberName): FunSpec {
        val readMethod = if (converter in VariantConverter.primitives) "read" else "toKotlin"
        return FunSpec.builder(TransferSignature.readerName(converter))
            .addModifiers(KModifier.INTERNAL)
            .receiver(Internal.transferContext)
            .returns(VariantConverter.bufferType(converter))
            .addStatement("return·%M.$readMethod(beginReturnValueRead())", converter)
            .build()
    }
}
