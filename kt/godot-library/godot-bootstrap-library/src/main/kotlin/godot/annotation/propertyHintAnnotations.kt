package godot.annotation

/*
All type checks will happen at the registrar generator at the moment.
We should move that to the idea plugin at some point in time to provide IDE help and not just compilation errors.

The following annotations are implemented based on https://github.com/godotengine/godot/blob/3.2/core/object.h
 */

/**
 * Can only be used on integer properties: Byte, Short, Int and Long.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class IntRange(
    val min: Int,
    val max: Int,
    val step: Int = -1,
    val or: Range = Range.NONE,
    val hideSlider: Boolean = false,
    val isRadians: Boolean = false,
    val isDegrees: Boolean = false,
    val isExp: Boolean = false,
    val suffix: String = "<none>",
)

/**
 * Can only be used on Float and Double properties.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class FloatRange(
    val min: Float,
    val max: Float,
    val step: Float = -1f,
    val or: Range = Range.NONE,
    val hideSlider: Boolean = false,
    val isRadians: Boolean = false,
    val isDegrees: Boolean = false,
    val isExp: Boolean = false,
    val suffix: String = "<none>",
)

/**
 * Can only be used on Float and Double properties!
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class ExpEasing(val attenuation: Boolean = false, val isPositiveOnly: Boolean = true)

/**
 * Can only be used on Float and Double properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class Lenght(val lenght: Int = -1)

/**
 * Flag Property hint supporting Int's
 *
 * Can only be used on Int properties!
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class IntFlag(vararg val names: String)

/**
 * Can only be used on Int properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class Layers2DRender

/**
 * Can only be used on Int properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class Layers2DPhysics

/**
 * Can only be used on Int properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class Layers3DRender

/**
 * Can only be used on Int properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class Layers3DPhysics

/**
 * Can only be used on String properties!
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class File(vararg val extensions: String = [], val global: Boolean = false)

/**
 * Can only be used on String properties!
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class Dir(val global: Boolean = false)

/**
 * Can only be used on String properties!
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class MultilineText

/**
 * Can only be used on String properties!
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class PlaceHolderText

/**
 * Can only be used on Color properties!
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class ColorNoAlpha

/**
 * Uses the given string as Godot's property hint string.
 *
 * The string must use the format expected by the property's Godot hint type.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class HintString(val value: String)

/**
 * Can only be used on Image properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class ImageCompressLossy

/**
 * Can only be used on Image properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class ImageCompressLossLess

/**
 * Can only be used on Int properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class ObjectId

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class TypeString(val baseTypeAsString: String)

/**
 * Can only be used on NodePath properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class NodePathToEditedNode

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class MethodOfVariantType

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class MethodOfBaseType

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class MethodOfInstance

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class MethodOfScript

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class PropertyOfVariantType

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class PropertyOfBaseType

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class PropertyOfInstance

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class PropertyOfScript

//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class ObjectTooBig

/**
 * Can only be used on NodePath properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class NodePathValidTypes

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class SaveFile(vararg val extensions: String = [])

/**
 * Can only be used on Int properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class IntIsObjectId

/**
 * Can only be used on String properties!
 */
//@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class Max

