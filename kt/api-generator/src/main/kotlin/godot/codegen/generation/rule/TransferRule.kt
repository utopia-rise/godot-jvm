package godot.codegen.generation.rule

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.ARRAY
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.WildcardTypeName
import godot.codegen.constants.API
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
            .addParameter("methodPtr", Internal.voidPtr)
        if (!signature.isStatic) {
            builder.receiver(API.ktObject)
        }
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
        val caller = if (signature.isStatic) "0L,·0L" else "ptr,·objectID.id"

        // Three shapes of ptrcall are specialised, and a signature is enough to tell them apart. Each drops what its
        // shape cannot need: no argument count on the wire, no type tag on a value both sides already know, and no
        // return record for a call that returns nothing.
        if (!signature.isVariantCall && !signature.isVararg) {
            when {
                fixedCount == 0 && !signature.returnsValue -> {
                    simpleCall(builder, caller)
                    return builder.build()
                }

                fixedCount == 0 -> {
                    getterCall(builder, caller, signature, context)
                    return builder.build()
                }

                fixedCount == 1 && !signature.returnsValue -> {
                    setterCall(builder, caller, signature)
                    return builder.build()
                }
            }
        }
        val needsBuffer = fixedCount > 0 || signature.isVararg || signature.returnsValue
        if (signature.isVariantCall) {
            val prefix = if (needsBuffer) "val·buffer·=·" else ""
            builder.addStatement("$prefix%T.transfer.open($caller,·$argumentCount)", Internal.variantBuffer)
        } else {
            builder.addStatement("val·frame·=·%T.stack", Internal.valueBuffer)
            builder.addStatement("val·base·=·frame.open($caller,·$argumentCount)")
            if (fixedCount > 0) {
                builder.addStatement("val·buffer·=·frame.buffer")
            }
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

        // A checked return carries a type tag, because the engine chose the type and only the tag says which it is.
        // An unchecked one does not: the generator asked for a type it took from Godot's own API description and
        // hardcoded the read, so there is nothing to discover and nothing to validate.
        val readMethod = if (signature.isVariantCall) {
            if (signature.returnConverter in VariantConverter.primitives) "read" else "toKotlin"
        } else {
            unsafeReadMethod(signature.returnConverter)
        }
        if (signature.isVariantCall) {
            builder.addStatement("%T.icall(methodPtr)", API.ktObject)
            if (signature.returnsValue) {
                builder.addStatement("return·%M.$readMethod(buffer.rewind())", signature.returnConverter)
            }
        } else {
            builder.addStatement("val·ret·=·frame.seal()")
            builder.addStatement(
                "%T.icallPtr(methodPtr,·frame.address,·${returnOrdinal(signature, context)},·base)",
                API.ktObject
            )
            if (signature.returnsValue) {
                builder.addStatement(
                    "return·%M.$readMethod(frame.close(base,·ret))",
                    signature.returnConverter
                )
            } else {
                builder.addStatement("frame.close(base,·ret)")
            }
        }
        return builder.build()
    }

    /** No arguments and no return: the frame is only the caller record. */
    private fun simpleCall(builder: FunSpec.Builder, caller: String) {
        builder.addStatement("val·frame·=·%T.stack", Internal.valueBuffer)
        builder.addStatement("val·base·=·frame.openSimple($caller)")
        builder.addStatement("%T.icallPtrSimple(methodPtr,·frame.address,·base)", API.ktObject)
        builder.addStatement("frame.closeVoid(base)")
    }

    /** One argument and no return: the argument is written with no type tag, which the call carries instead. */
    private fun setterCall(builder: FunSpec.Builder, caller: String, signature: TransferSignature) {
        val converter = signature.converters.first()
        val writeMethod = if (converter in VariantConverter.primitives) "writeUnsafe" else "toUnsafeGodot"
        builder.addStatement("val·frame·=·%T.stack", Internal.valueBuffer)
        builder.addStatement("val·base·=·frame.openSetter($caller)")
        builder.addStatement("%M.$writeMethod(frame.buffer,·p0)", converter)
        builder.addStatement("frame.sealSetter()")
        builder.addStatement(
            "%T.icallPtrSetter(methodPtr,·frame.address,·base,·${VariantConverter.variantOrdinal(converter)})",
            API.ktObject
        )
        builder.addStatement("frame.closeVoid(base)")
    }

    // A primitive names its own untagged reader so the value comes back as a primitive; going through the generic
    // one would erase it to Any? and box.
    private fun unsafeReadMethod(converter: MemberName): String =
        if (converter in VariantConverter.primitives) "readUnsafe" else "toUnsafeKotlin"

    /** No arguments and one return: the engine writes the value untagged where the arguments would have gone. */
    private fun getterCall(
        builder: FunSpec.Builder,
        caller: String,
        signature: TransferSignature,
        context: GenerationContext,
    ) {
        builder.addStatement("val·frame·=·%T.stack", Internal.valueBuffer)
        builder.addStatement("val·base·=·frame.openGetter($caller)")
        builder.addStatement(
            "%T.icallPtrGetter(methodPtr,·frame.address,·base,·${returnOrdinal(signature, context)})",
            API.ktObject
        )
        builder.addStatement(
            "return·%M.${unsafeReadMethod(signature.returnConverter)}(frame.closeGetter(base))",
            signature.returnConverter
        )
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
