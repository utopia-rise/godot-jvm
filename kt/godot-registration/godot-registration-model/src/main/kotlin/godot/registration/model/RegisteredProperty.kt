package godot.registration.model

import godot.registration.model.hint.property.PropertyHint
import godot.registration.model.types.Type

enum class RegisteredPropertyBindingKind {
    PROPERTY_REFERENCE,
    ACCESSOR_METHODS,
}

data class RegisteredProperty(
    val fqName: String,
    val type: Type,
    val bindingKind: RegisteredPropertyBindingKind = RegisteredPropertyBindingKind.PROPERTY_REFERENCE,
    val getterFqName: String? = null,
    val setterFqName: String? = null,
    val getterName: String? = getterFqName?.substringAfterLast("."),
    val setterName: String? = setterFqName?.substringAfterLast("."),
    val isMutable: Boolean = true,
    val isLateinit: Boolean = false,
    val isOverridee: Boolean = false,
    val isExported: Boolean = false,
    val hints: List<PropertyHint> = emptyList(),
    val groups: List<PropertyGroup> = emptyList(),
) {
    val name: String = fqName.substringAfterLast(".")
}
