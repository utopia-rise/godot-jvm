package godot.registrar.generator.generator

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName.Companion.member
import godot.annotation.RpcMode
import godot.annotation.Sync
import godot.annotation.TransferMode
import godot.registrar.generator.GeneratorContext
import godot.registrar.generator.ext.asEnumName
import godot.registrar.generator.ext.effectiveFunctions
import godot.registrar.generator.ext.flattenedHierarchy
import godot.registrar.generator.ext.toGodotClassName
import godot.registrar.generator.ext.toKtVariantMemberName
import godot.registration.model.RegisteredFunction
import godot.registration.model.ext.isEnum
import godot.registration.model.types.ScriptClass
import godot.registration.model.types.Type

fun FunSpec.Builder.addNotificationRegistrations(
    registeredClass: ScriptClass,
    context: GeneratorContext,
) {
    val notificationFunctions = registeredClass.functions
        .filter { registeredFunction -> registeredFunction.notification != null }
        .map { registeredClass to it } +
        registeredClass.flattenedHierarchy(context)
            .filterIsInstance<ScriptClass>()
            .flatMap { registeredSuperClass ->
                registeredSuperClass.functions
                    .filter { registeredSuperClassFunction -> registeredSuperClassFunction.notification != null }
                    .map { registeredSuperClass to it }
            }

    notificationFunctions.forEach { (notificationClass, registeredFunction) ->
        addStatement(
            "notification(%L, %L)",
            registeredFunction.notification!!,
            getFunctionReference(
                registeredFunction,
                ClassName(notificationClass.containingPackage, notificationClass.name),
            ),
        )
    }
}

fun FunSpec.Builder.addFunctionRegistrations(
    registeredClass: ScriptClass,
    context: GeneratorContext,
    className: ClassName,
) {
    registeredClass.effectiveFunctions(context)
        .filter { registeredFunction -> registeredFunction.notification == null }
        .forEach { registeredFunction ->
            addStatement(
                getFunctionTemplateString(registeredFunction),
                *getTemplateArgs(registeredFunction, context, className).toTypedArray()
            )
        }
}

private fun getFunctionTemplateString(registeredFunction: RegisteredFunction) = buildString {
    val variantType = if (registeredFunction.returnType.isEnum()) {
        "%M(%T.entries.toTypedArray())"
    } else {
        "%M"
    }

    append("function(%L, rpc(%M, %L, %M, %L), returns($variantType, %S)")

    registeredFunction.parameters.forEach { valueParameter ->
        if (valueParameter.type.isEnum()) {
            append(", argument(%M(%T.entries.toTypedArray()), %S, %S)")
        } else {
            append(", argument(%M, %S, %S)")
        }
    }

    append(")")
}

private fun getTemplateArgs(
    registeredFunction: RegisteredFunction,
    context: GeneratorContext,
    className: ClassName,
): List<Any> {
    val returnType = registeredFunction.returnType.toGodotClassName(context)
    val typeClassName = if (registeredFunction.returnType.isEnum()) {
        registeredFunction.returnType.toEnumClassName()
    } else {
        null
    }

    return buildList {
        add(getFunctionReference(registeredFunction, className))
        add(getRpcModeEnum(registeredFunction))
        add(getRpcCallLocal(registeredFunction))
        add(getRpcTransferModeEnum(registeredFunction))
        add(getRpcChannel(registeredFunction))

        if (registeredFunction.returnType.isEnum()) {
            add(registeredFunction.returnType.toKtVariantMemberName())
            typeClassName?.let { add(it) }
        } else {
            add(registeredFunction.returnType.toKtVariantMemberName())
        }

        add(returnType)

        registeredFunction.parameters.forEach { valueParameter ->
            add(valueParameter.type.toKtVariantMemberName())
            if (valueParameter.type.isEnum()) {
                add(valueParameter.type.toEnumClassName())
            }
            add(valueParameter.type.toGodotClassName(context))
            add(valueParameter.name)
        }
    }
}

private fun getFunctionReference(registeredFunction: RegisteredFunction, className: ClassName): CodeBlock {
    return className.member(registeredFunction.name).reference()
}

private fun getRpcModeEnum(registeredFunction: RegisteredFunction) =
    registeredFunction.rpcConfig?.rpcMode?.asEnumName() ?: RpcMode.DISABLED.asEnumName()

private fun getRpcTransferModeEnum(registeredFunction: RegisteredFunction) =
    registeredFunction.rpcConfig?.transferMode?.asEnumName() ?: TransferMode.RELIABLE.asEnumName()

private fun getRpcCallLocal(registeredFunction: RegisteredFunction): Boolean =
    when (registeredFunction.rpcConfig?.sync) {
        Sync.SYNC -> true
        Sync.NO_SYNC -> false
        null -> false
    }

private fun getRpcChannel(registeredFunction: RegisteredFunction): Int =
    registeredFunction.rpcConfig?.transferChannel ?: 0

private fun Type.toEnumClassName() = ClassName(
    fqName.substringBeforeLast("."),
    fqName.substringAfterLast("."),
)
