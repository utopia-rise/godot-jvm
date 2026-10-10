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
            "property(%S, %L, %L, %L, %S, %M, %L, %L)",
            registeredProperty.name.convertToSnakeCase(),
            getGetterReference(registeredProperty, className),
            setterFqName?.let { getSetterReference(registeredProperty, className) } ?: "null",
            variantConverter,
            typeGodotName,
            propertyHint.typeHint,
            propertyHint.hintString,
            getPropertyUsage(registeredProperty),
        )
        return
    }

    addStatement(
        "property(%L, %L, %S, %M, %L, %L)",
        getPropertyReference(registeredProperty, className),
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

private fun getPropertyReference(registeredProperty: RegisteredProperty, className: ClassName): CodeBlock {
    return memberReference(className, registeredProperty.name)
}

private fun getGetterReference(registeredProperty: RegisteredProperty, className: ClassName): CodeBlock {
    val getterName = requireNotNull(registeredProperty.getterName) {
        "Property ${registeredProperty.fqName} does not have a getter."
    }
    return memberReference(className, getterName)
}

private fun getSetterReference(registeredProperty: RegisteredProperty, className: ClassName): CodeBlock {
    val setterName = requireNotNull(registeredProperty.setterName) {
        "Property ${registeredProperty.fqName} does not have a setter."
    }
    return memberReference(className, setterName)
}

private fun memberReference(className: ClassName, memberName: String): CodeBlock =
    if (memberName.isPlainKotlinIdentifier()) {
        CodeBlock.of("%T::%L", className, memberName)
    } else {
        CodeBlock.builder()
            .add("%T::", className)
            .add("`")
            .add(memberName)
            .add("`")
            .build()
    }

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
