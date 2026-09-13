package godot.registrar.generator.generator

import com.squareup.kotlinpoet.FunSpec
import godot.registrar.generator.GeneratorContext
import godot.registrar.generator.ext.effectiveSignals
import godot.registrar.generator.ext.toGodotClassName
import godot.registrar.generator.ext.toKtVariantConverter
import godot.registration.model.RegisteredSignal
import godot.registration.model.types.ScriptClass
import godot.registration.model.types.Type

fun FunSpec.Builder.addSignalRegistrations(
    registeredClass: ScriptClass,
    context: GeneratorContext,
) {
    registeredClass.effectiveSignals(context).forEach { registeredSignal ->
        addStatement(
            getSignalTemplate(registeredSignal),
            *getSignalTemplateArguments(registeredSignal, context)
        )
    }
}

private fun getSignalTemplate(registeredSignal: RegisteredSignal): String = buildString {
    append("signal(%S")
    repeat(maxOf(registeredSignal.parameterTypes.size, registeredSignal.parameterNames.size)) {
        append(", argument(%L, %S, %S)")
    }
    append(")")
}

private fun getSignalTemplateArguments(
    registeredSignal: RegisteredSignal,
    context: GeneratorContext,
): Array<Any> = buildList {
    add(registeredSignal.name)

    if (registeredSignal.parameterTypes.size >= registeredSignal.parameterNames.size) {
        registeredSignal.parameterTypes.forEachIndexed { index, argumentType ->
            val argumentName = registeredSignal.parameterNames.getOrNull(index) ?: "p$index"
            add(argumentType.toKtVariantConverter())
            add(argumentType.toGodotClassName(context))
            add(argumentName)
        }
    } else {
        registeredSignal.parameterNames.forEachIndexed { index, argumentName ->
            val argumentType = registeredSignal.parameterTypes.getOrNull(index)
            add((argumentType ?: Type.anyType).toKtVariantConverter())
            add(argumentType?.toGodotClassName(context) ?: "")
            add(argumentName)
        }
    }
}.toTypedArray()
