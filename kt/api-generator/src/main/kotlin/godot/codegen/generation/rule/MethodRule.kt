package godot.codegen.generation.rule

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.UNIT
import godot.codegen.constants.API
import godot.codegen.constants.Core
import godot.codegen.constants.Internal
import godot.codegen.constants.TypeIdentifier
import godot.codegen.constants.Utils
import godot.codegen.constants.VariantConverter
import godot.codegen.generation.GenerationContext
import godot.codegen.generation.TransferSignature
import godot.codegen.generation.task.EnrichedClassTask
import godot.codegen.generation.task.EnrichedMethodTask
import godot.codegen.models.enriched.EnrichedArgument
import godot.codegen.models.enriched.EnrichedClass
import godot.codegen.models.enriched.EnrichedMethod
import godot.codegen.models.traits.addKdoc
import godot.tools.common.constants.godotPackage

interface BaseMethodeRule {
    fun FunSpec.Builder.configureMethod(method: EnrichedMethod, clazz: EnrichedClass, context: GenerationContext) {
        if (method.name == "toString") {
            addModifiers(KModifier.OVERRIDE)
        }

        val methodTypeName = method.getCastedType()
        val shouldReturn = method.getTypeName() != UNIT
        if (shouldReturn) {
            returns(methodTypeName)
        }

        generateParameters(method, context)

        if (method.isOverride) {
            addModifiers(KModifier.OVERRIDE)
            addStatement(
                "%L·%T(%S)",
                "throw",
                NotImplementedError::class,
                "${clazz.identifier}::${method.name} can't be called from the JVM."
            )
            addKdoc("Virtual method inherited from base class implemented in non-JVM code. Don't call it.")
        } else if (method.isAbstract) {
            addModifiers(KModifier.ABSTRACT)
            addKdoc(method)
        } else if (method.isVirtual) {
            addModifiers(KModifier.OPEN)
            addStatement(
                "%L·%T(%S)",
                "throw",
                NotImplementedError::class,
                "${clazz.identifier}::${method.name} is not implemented."
            )
            addKdoc(method)
        } else {
            addModifiers(KModifier.FINAL)
            writeCode(method, clazz, context)
            addKdoc(method)
        }
    }

    fun FunSpec.Builder.generateParameters(method: EnrichedMethod, context: GenerationContext)
    fun FunSpec.Builder.writeCode(method: EnrichedMethod, clazz: EnrichedClass, context: GenerationContext)

    fun ParameterSpec.Builder.applyDefault(argument: EnrichedArgument, context: GenerationContext): ParameterSpec.Builder {
        val defaultValueKotlinCode = argument.getDefaultValue()
        val appliedDefault = if ((argument.type.isEnum() || argument.type.isBitField()) && defaultValueKotlinCode != null) {
            context.generateEnumDefaultValue(argument.type, defaultValueKotlinCode.first.toLong())
        } else {
            defaultValueKotlinCode?.first
        }
        if (appliedDefault != null) {
            defaultValue(appliedDefault, *defaultValueKotlinCode!!.second)
        }
        return this
    }
}

class MethodRule : GodotApiRule<EnrichedMethodTask>(), BaseMethodeRule {
    override fun apply(task: EnrichedMethodTask, context: GenerationContext) = with(task.builder) {
        configureMethod(task.method, task.owner, context)
        if (task.owner.identifier == API.`object`.simpleName && task.method.originalName in API.godotObjectMethods) {
            addModifiers(KModifier.OVERRIDE)
            // Kotlin forbids default values on overrides; GodotObject declares them instead.
            val withoutDefaults = parameters.map { it.toBuilder().defaultValue(null).build() }
            parameters.clear()
            parameters.addAll(withoutDefaults)
        }
    }

    override fun FunSpec.Builder.generateParameters(method: EnrichedMethod, context: GenerationContext) {
        method.arguments.withIndex().forEach {
            val index = it.index
            val argument = it.value

            val parameterBuilder = ParameterSpec.builder(
                method.arguments[index].name,
                argument.getCastedType()
            )

            addParameter(
                parameterBuilder
                    .applyDefault(argument, context)
                    .build()
            )
        }

        if (method.isVararg) {
            addParameter("args", ANY.copy(nullable = true), KModifier.VARARG)
        }
    }

    override fun FunSpec.Builder.writeCode(method: EnrichedMethod, clazz: EnrichedClass, context: GenerationContext) {
        generateWriteArgument(method, clazz, context)
        generateMethodCall(method, clazz)
        if (method.type.getVariantConverter() != VariantConverter.NIL) {
            generateReturn(method, clazz, context)
        }
    }

    private fun FunSpec.Builder.generateWriteArgument(method: EnrichedMethod, clazz: EnrichedClass, context: GenerationContext) {
        val signature = TransferSignature(method.arguments.map { it.type.getVariantConverter() }, method.isVararg)
        context.methodSignatures.add(signature)

        val arguments = buildString {
            append(if (method.isStatic) "0L,·0L" else "ptr,·objectID.id")
            for (argument in method.arguments) {
                append(",·").append(argument.name).append(argument.getToBufferCastingMethod())
                if (argument.type.isEnum()) append(".value")
                if (argument.type.isBitField()) append(".flag")
            }
            if (method.isVararg) append(",·args")
        }
        addStatement("%T.%M($arguments)", Internal.transferContext, MemberName(godotPackage, signature.writerName))
    }

    private fun FunSpec.Builder.generateMethodCall(method: EnrichedMethod, clazz: EnrichedClass) {
        addStatement(
            "%T.callMethod(%T.%M)",
            Internal.transferContext,
            clazz.className.nestedClass(API.methodBindingsInnerClassName),
            MemberName(API.`object`.packageName, "${method.name}Ptr")
        )
    }

    private fun FunSpec.Builder.generateReturn(method: EnrichedMethod, clazz: EnrichedClass, context: GenerationContext) {
        val converter = method.type.getVariantConverter()
        context.returnConverters.add(converter)
        val reader = MemberName(godotPackage, TransferSignature.readerName(converter))

        if (method.type.isEnum()) {
            addStatement("return·%T.from(%T.%M())", method.getBufferClass(), Internal.transferContext, reader)
        } else if (method.type.isBitField()) {
            addStatement("return·%T(%T.%M())", method.getBufferClass(), Internal.transferContext, reader)
        } else if (method.getTypeName() == VariantConverter.bufferType(converter)) {
            addStatement("return·%T.%M()${method.getFromBufferCastingMethod()}", Internal.transferContext, reader)
        } else {
            addStatement(
                "return·(%T.%M()·as·%T)${method.getFromBufferCastingMethod()}",
                Internal.transferContext,
                reader,
                method.getTypeName()
            )
        }
    }
}

class StringOnlyRule : GodotApiRule<EnrichedClassTask>(), BaseMethodeRule {
    override fun apply(task: EnrichedClassTask, context: GenerationContext) {
        for (method in task.enrichedMethods.toList()) {
            val methodTask = createStringOnlyMethod(method.method, task.clazz, context) ?: continue
            task.enrichedMethods.add(methodTask)
        }
        for (method in task.enrichedStaticMethods.toList()) {
            val methodTask = createStringOnlyMethod(method.method, task.clazz, context) ?: continue
            task.enrichedStaticMethods.add(methodTask)
        }
    }

    private fun createStringOnlyMethod(method: EnrichedMethod, clazz: EnrichedClass, context: GenerationContext): EnrichedMethodTask? {
        if (method.isVirtual || method.isOverride) {
            return null
        }
        if (method.arguments.none { it.type.identifier == TypeIdentifier.STRING_NAME.name || it.type.identifier == Core.nodePath.simpleName }) {
            return null
        }

        val methodTask = EnrichedMethodTask(method, clazz)
        methodTask.builder.configureMethod(method, clazz, context)
        return methodTask
    }

    override fun FunSpec.Builder.generateParameters(method: EnrichedMethod, context: GenerationContext) {
        method.arguments.withIndex().forEach {
            val index = it.index
            val parameterBuilder =
                if (it.value.type.identifier == TypeIdentifier.STRING_NAME.name || it.value.type.identifier == TypeIdentifier.NODE_PATH.name) {
                    ParameterSpec.builder(method.arguments[index].name, STRING)
                } else {
                    val argument = it.value
                    ParameterSpec.builder(method.arguments[index].name, argument.getCastedType()).applyDefault(argument, context)
                }
            addParameter(parameterBuilder.build())
        }

        if (method.isVararg) {
            addParameter("args", ANY.copy(nullable = true), KModifier.VARARG)
        }
    }

    override fun FunSpec.Builder.writeCode(method: EnrichedMethod, clazz: EnrichedClass, context: GenerationContext) {
        val arguments = buildString {
            method.arguments.withIndex().forEach {
                val index = it.index
                val argument = it.value

                if (index != 0) append(",·")
                append(method.arguments[index].name)

                if (argument.type.identifier == TypeIdentifier.STRING_NAME.name) {
                    clazz.additionalImports.add(Utils.asCachedStringName)
                    append(".asCachedStringName()")
                } else if (argument.type.identifier == TypeIdentifier.NODE_PATH.name) {
                    clazz.additionalImports.add(Utils.asCachedNodePath)
                    append(".asCachedNodePath()")
                }
            }
            if (method.isVararg && isNotEmpty()) append(",·*args")
        }

        addStatement("return·${method.name}($arguments)")
    }
}

class OverLoadRule : GodotApiRule<EnrichedMethodTask>() {
    override fun apply(task: EnrichedMethodTask, context: GenerationContext) = with(task.builder) {
        if (task.method.arguments.none { it.defaultValue != null && it.type.identifier != TypeIdentifier.STRING_NAME.name && it.type.identifier != Core.nodePath.simpleName }) {
            return@with
        }
        // Object's GodotObject overrides carry no defaults of their own; the interface declares them.
        if (parameters.none { it.defaultValue != null }) {
            return@with
        }
        val jvmOverloadAnnotationSpec = AnnotationSpec.builder(JvmOverloads::class).build()
        if (!annotations.contains(jvmOverloadAnnotationSpec)) {
            addAnnotation(jvmOverloadAnnotationSpec)
        }
    }
}
