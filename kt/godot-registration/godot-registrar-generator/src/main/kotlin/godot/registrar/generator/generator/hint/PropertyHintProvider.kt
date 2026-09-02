package godot.registrar.generator.generator.hint

import godot.registrar.generator.GeneratorContext
import godot.registrar.generator.ext.asEnumName
import godot.registrar.generator.ext.baseGodotType
import godot.registrar.generator.ext.getAsVariantTypeOrdinal
import godot.registrar.generator.ext.getGodotCoreTypeName
import godot.registrar.generator.ext.getRegisteredName
import godot.registrar.generator.ext.isCompatibleList
import godot.registrar.generator.ext.isDictionary
import godot.registration.model.RegisteredProperty
import godot.registration.model.ext.isCoreType
import godot.registration.model.ext.isGodotPrimitive
import godot.registration.model.ext.isNodeType
import godot.registration.model.ext.isResource
import godot.registration.model.hint.property.ColorNoAlphaHint
import godot.registration.model.hint.property.EnumHint
import godot.registration.model.hint.property.ExpEasingHint
import godot.registration.model.hint.property.FileHint
import godot.registration.model.hint.property.HintStringHint
import godot.registration.model.hint.property.IntFlagHint
import godot.registration.model.hint.property.MultilineTextHint
import godot.registration.model.hint.property.PlaceHolderTextHint
import godot.registration.model.hint.property.PropertyHint
import godot.registration.model.hint.property.RangeHint
import godot.registration.model.types.ScriptClass
import godot.registration.model.types.TYPE_BOOLEAN
import godot.registration.model.types.TYPE_DOUBLE
import godot.registration.model.types.TYPE_FLOAT
import godot.registration.model.types.TYPE_INT
import godot.registration.model.types.TYPE_LONG
import godot.registration.model.types.Type
import godot.registration.model.types.TypeKind
import godot.core.PropertyHint as GodotPropertyHint

object PropertyHintProvider {
    // TODO: implement GodotPropertyHint.ENUM_SUGGESTION
    // TODO: implement GodotPropertyHint.LINK
    // TODO: implement GodotPropertyHint.LAYERS_2D_RENDER
    // TODO: implement GodotPropertyHint.LAYERS_2D_PHYSICS
    // TODO: implement GodotPropertyHint.LAYERS_2D_NAVIGATION
    // TODO: implement GodotPropertyHint.LAYERS_3D_RENDER
    // TODO: implement GodotPropertyHint.LAYERS_3D_PHYSICS
    // TODO: implement GodotPropertyHint.LAYERS_3D_NAVIGATION
    // TODO: implement GodotPropertyHint.LAYERS_AVOIDANCE
    // TODO: implement GodotPropertyHint.EXPRESSION
    // TODO: implement GodotPropertyHint.OBJECT_ID
    // TODO: implement GodotPropertyHint.NODE_PATH_TO_EDITED_NODE
    // TODO: implement GodotPropertyHint.OBJECT_TOO_BIG
    // TODO: implement GodotPropertyHint.NODE_PATH_VALID_TYPES
    // TODO: implement GodotPropertyHint.SAVE_FILE
    // TODO: implement GodotPropertyHint.GLOBAL_SAVE_FILE
    // TODO: implement GodotPropertyHint.INT_IS_OBJECTID
    // TODO: implement GodotPropertyHint.INT_IS_POINTER
    // TODO: implement GodotPropertyHint.ARRAY_TYPE
    // TODO: implement GodotPropertyHint.DICTIONARY_TYPE
    // TODO: implement GodotPropertyHint.LOCALE_ID
    // TODO: implement GodotPropertyHint.LOCALIZABLE_STRING
    // TODO: implement GodotPropertyHint.HIDE_QUATERNION_EDIT
    // TODO: implement GodotPropertyHint.PASSWORD
    // TODO: implement GodotPropertyHint.TOOL_BUTTON
    // TODO: implement GodotPropertyHint.ONESHOT
    // TODO: implement GodotPropertyHint.GROUP_ENABLE
    // TODO: implement GodotPropertyHint.INPUT_NAME
    // TODO: implement GodotPropertyHint.FILE_PATH

    internal fun provide(
        registeredProperty: RegisteredProperty,
        context: GeneratorContext,
    ): HintGenerator {
        val propertyHint = registeredProperty.propertyHint()

        val generatedHint = when {
            registeredProperty.type.isCompatibleList() -> ArrayHintStringGenerator(
                registeredProperty = registeredProperty,
                elementHintString = registeredProperty.type.genericArguments
                    .firstOrNull()
                    ?.toContainerElementHintString(context),
            )

            registeredProperty.type.isDictionary() -> DictionaryHintStringGenerator(
                registeredProperty = registeredProperty,
                keyHintString = registeredProperty.type.genericArguments.getOrNull(0)?.toContainerElementHintString(context),
                valueHintString = registeredProperty.type.genericArguments.getOrNull(1)?.toContainerElementHintString(context),
            )

            registeredProperty.type.isNodeType() -> NodeTypeHintStringGenerator(registeredProperty, context)
            registeredProperty.type.isResource() -> ResourceHintStringGenerator(registeredProperty, context)
            registeredProperty.type.fqName == TYPE_INT && propertyHint is IntFlagHint -> IntFlagHintStringGenerator(registeredProperty, context)
            registeredProperty.type.kind == TypeKind.ENUM || registeredProperty.type.kind == TypeKind.BITFIELD || propertyHint is EnumHint ->
                EnumHintStringGenerator(registeredProperty, context)

            registeredProperty.type.isCoreType() && !registeredProperty.type.isCompatibleList() && !registeredProperty.type.isDictionary() ->
                coreTypeHintGenerator(registeredProperty, context, propertyHint)

            registeredProperty.type.fqName == TYPE_INT ||
                registeredProperty.type.fqName == TYPE_LONG ||
                registeredProperty.type.fqName == TYPE_FLOAT ||
                registeredProperty.type.fqName == TYPE_DOUBLE ||
                registeredProperty.type.fqName == TYPE_BOOLEAN ||
                registeredProperty.type.fqName == String::class.qualifiedName ->
                primitiveHintGenerator(registeredProperty, context, propertyHint)

            registeredProperty.type.fqName.matches(Regex("^kotlin\\.collections\\..*Set$")) ->
                StaticHintGenerator(GodotPropertyHint.RESOURCE_TYPE, "")

            else -> StaticHintGenerator(GodotPropertyHint.NONE, "")
        }

        if (propertyHint is HintStringHint) {
            return HintStringOverride(generatedHint, propertyHint.value)
        }
        return generatedHint
    }

    internal fun provide(
        type: Type,
        context: GeneratorContext,
    ): HintGenerator = when {
        type.isCompatibleList() -> ArrayHintStringGenerator(
            elementHintString = type.genericArguments.firstOrNull()?.toContainerElementHintString(context),
            prefix = type.nestedArrayPrefix(),
            isUntyped = type.firstGenericArgumentIsAny(),
        )

        type.isDictionary() -> DictionaryHintStringGenerator(
            keyHintString = type.genericArguments.getOrNull(0)?.toContainerElementHintString(context),
            valueHintString = type.genericArguments.getOrNull(1)?.toContainerElementHintString(context),
            isUntyped = type.firstGenericArgumentIsAny(),
        )

        type.kind == TypeKind.ENUM -> StaticHintGenerator(GodotPropertyHint.ENUM, "")
        type.kind == TypeKind.BITFIELD -> StaticHintGenerator(GodotPropertyHint.FLAGS, "")

        type.isGodotPrimitive() || type.isCoreType() -> StaticHintGenerator(GodotPropertyHint.NONE, type.getGodotCoreTypeName())
        type.isNodeType() -> StaticHintGenerator(GodotPropertyHint.NODE_TYPE, objectHintString(type, context, useBaseTypeName = true))
        type.isResource() -> StaticHintGenerator(GodotPropertyHint.RESOURCE_TYPE, objectHintString(type, context, useBaseTypeName = false))
        else -> StaticHintGenerator(GodotPropertyHint.NONE, "")
    }

    private fun primitiveHintGenerator(
        registeredProperty: RegisteredProperty,
        context: GeneratorContext,
        propertyHint: PropertyHint?,
    ): HintGenerator = when (propertyHint) {
        is RangeHint<*> -> RangeHintStringGenerator(registeredProperty, context)
        is ExpEasingHint -> ExpEasingHintStringGenerator(registeredProperty, context)
        is FileHint -> FileHintStringGenerator(registeredProperty, context)
        is godot.registration.model.hint.property.DirHint -> DirHintStringGenerator(registeredProperty, context)
        is MultilineTextHint -> MultilineTextHintStringGenerator(registeredProperty, context)
        is PlaceHolderTextHint -> PlaceHolderTextHintStringGenerator(registeredProperty, context)
        else -> StaticHintGenerator(GodotPropertyHint.NONE, "")
    }

    private fun coreTypeHintGenerator(
        registeredProperty: RegisteredProperty,
        context: GeneratorContext,
        propertyHint: PropertyHint?,
    ): HintGenerator = when (propertyHint) {
        is ColorNoAlphaHint -> ColorNoAlphaHintStringGenerator(registeredProperty, context)
        else -> StaticHintGenerator(GodotPropertyHint.NONE, "")
    }

    private fun Type.toContainerElementHintString(context: GeneratorContext): String =
        provide(this, context)
            .generate()
            .toContainerElementHintString(getAsVariantTypeOrdinal())
            .replace("?", "")

    private fun GeneratedPropertyHint.toContainerElementHintString(variantTypeOrdinal: Int): String =
        if (typeHint == GodotPropertyHint.NONE.asEnumName()) {
            "$variantTypeOrdinal:${hintString.toLiteralString()}"
        } else {
            "$variantTypeOrdinal/${GodotPropertyHint.valueOf(typeHint.simpleName).value}:${hintString.toLiteralString()}"
        }

    private fun com.squareup.kotlinpoet.CodeBlock.toLiteralString(): String =
        toString().removePrefix("\"").removeSuffix("\"")

    private fun Type.nestedArrayPrefix(): String {
        val elementType = genericArguments.firstOrNull()
        if (elementType != null) {
            return ""
        }

        val compatibleListType = getAsVariantTypeOrdinal()
        return if (compatibleListType != godot.core.VariantParser.ARRAY.id) ":$compatibleListType" else ""
    }

    private fun Type.firstGenericArgumentIsAny(): Boolean =
        genericArguments.firstOrNull()?.fqName == Any::class.qualifiedName

    private fun RegisteredProperty.propertyHint(): PropertyHint? = hints.filterIsInstance<PropertyHint>().singleOrNull()

    private fun objectHintString(
        type: Type,
        context: GeneratorContext,
        useBaseTypeName: Boolean,
    ): String =
        (type as? ScriptClass)
            ?.takeIf { scriptClass -> scriptClass.isRegistered }
            ?.getRegisteredName(context.settings)
            ?: context.registeredClassesByFqName[type.fqName]?.getRegisteredName(context.settings)
            ?: if (useBaseTypeName) {
                type.baseGodotType()?.fqName?.substringAfterLast(".") ?: ""
            } else {
                type.fqName.substringAfterLast(".")
            }
}
