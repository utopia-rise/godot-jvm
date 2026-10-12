package godot.registrar.generator.generator

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import godot.common.extensions.convertToSnakeCase
import godot.core.PropertyUsageFlags
import godot.core.VariantCaster
import godot.registrar.generator.GeneratorContext
import godot.registrar.generator.ext.effectiveProperties
import godot.registrar.generator.ext.toGodotClassName
import godot.registrar.generator.ext.toKtVariantConverter
import godot.registrar.generator.ext.toTypeName
import godot.registrar.generator.generator.hint.PropertyHintProvider
import godot.registration.model.PropertyExposure
import godot.registration.model.RegisteredProperty
import godot.registration.model.RegisteredPropertyBindingKind
import godot.registration.model.PropertyGroupKind
import godot.registration.model.ext.isEnum
import godot.registration.model.hint.property.EnumListHintStringHint
import godot.registration.model.types.ScriptClass

fun FunSpec.Builder.addPropertyRegistrations(
    registeredClass: ScriptClass,
    context: GeneratorContext,
    className: ClassName,
) {
    registeredClass.effectiveProperties(context).forEach { registeredProperty ->
        registeredProperty.groups.forEach { group ->
            when (group.kind) {
                PropertyGroupKind.CATEGORY -> addStatement("category(%S)", group.name)
                PropertyGroupKind.GROUP -> addStatement("group(%S, %S)", group.name, group.prefix)
                PropertyGroupKind.SUBGROUP -> addStatement("subgroup(%S, %S)", group.name, group.prefix)
            }
        }

        registerProperty(registeredProperty, context, className)
    }
}

private fun FunSpec.Builder.registerProperty(
    registeredProperty: RegisteredProperty,
    context: GeneratorContext,
    className: ClassName,
) {
    val propertyHint = PropertyHintProvider.provide(registeredProperty, context).generate()
    val typeGodotName = if (registeredProperty.type.isEnum()) "int" else registeredProperty.type.toGodotClassName(context)
    val variantConverter = registeredProperty.variantConverter()

    if (registeredProperty.bindingKind == RegisteredPropertyBindingKind.ACCESSOR_METHODS) {
        val getterFqName = registeredProperty.getterFqName
        val setterFqName = registeredProperty.setterFqName
        requireNotNull(getterFqName) {
            "Property ${registeredProperty.name} should have a getter when using accessor binding"
        }
        addStatement(
            "property(%S, {·it.%L()·}, %L, %L, %S, %M, %L, %L)",
            registeredProperty.name.convertToSnakeCase(),
            memberName(registeredProperty.getterName!!),
            registeredProperty.setterName?.let { CodeBlock.of("{·obj,·value·->·obj.%L(value)·}", memberName(it)) } ?: "null",
            variantConverter,
            typeGodotName,
            propertyHint.typeHint,
            propertyHint.hintString,
            getPropertyUsage(registeredProperty),
        )
        return
    }

    val member = memberName(registeredProperty.name)
    addStatement(
        "property(%S, {·it.%L·}, %L, %L, %S, %M, %L, %L)",
        registeredProperty.name.convertToSnakeCase(),
        member,
        if (registeredProperty.isMutable) CodeBlock.of("{·obj,·value·->·obj.%L·=·value·}", member) else "null",
        variantConverter,
        typeGodotName,
        propertyHint.typeHint,
        propertyHint.hintString,
        getPropertyUsage(registeredProperty),
    )
}

private fun RegisteredProperty.variantConverter(): CodeBlock {
    val enumListHint = hints.filterIsInstance<EnumListHintStringHint>().firstOrNull() ?: return type.toKtVariantConverter()
    return CodeBlock.of("%T.ENUM_LIST(%T.entries.toTypedArray())", VariantCaster::class, enumListHint.enumType.toTypeName())
}

fun memberName(memberName: String): String =
    if (memberName.isPlainKotlinIdentifier()) memberName else "`$memberName`"

private fun getPropertyUsage(registeredProperty: RegisteredProperty): CodeBlock {
    val flags = PropertyUsageFlags::class
    return when (registeredProperty.exposure) {
        PropertyExposure.VISIBLE -> CodeBlock.of("%T.SCRIPT_VARIABLE", flags)
        PropertyExposure.STORAGE -> CodeBlock.of("%T.SCRIPT_VARIABLE or %T.STORAGE", flags, flags)
        PropertyExposure.EXPORT -> CodeBlock.of("%T.SCRIPT_VARIABLE or %T.STORAGE or %T.EDITOR", flags, flags, flags)
    }
}

private fun String.isPlainKotlinIdentifier(): Boolean {
    if (isEmpty()) {
        return false
    }
    if (!(first() == '_' || first().isLetter())) {
        return false
    }
    return drop(1).all { char -> char == '_' || char.isLetterOrDigit() }
}
