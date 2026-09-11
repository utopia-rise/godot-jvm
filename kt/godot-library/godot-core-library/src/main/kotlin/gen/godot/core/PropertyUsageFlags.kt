// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress
import kotlin.jvm.JvmField

public infix fun Long.or(other: PropertyUsageFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: PropertyUsageFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: PropertyUsageFlags): Long = this.and(other.flag)

public class PropertyUsageFlags(
  flag: Long,
) : BitFieldBase<PropertyUsageFlags>(flag) {
  protected override fun wrap(flag: Long): PropertyUsageFlags = PropertyUsageFlags(flag)

  public companion object {
    /**
     * The property is not stored, and does not display in the editor. This is the default for
     * non-exported properties.
     */
    @JvmField
    public val NONE: PropertyUsageFlags = PropertyUsageFlags(0)

    /**
     * The property is serialized and saved in the scene file (default for exported properties).
     */
    @JvmField
    public val STORAGE: PropertyUsageFlags = PropertyUsageFlags(2)

    /**
     * The property is shown in the [EditorInspector] (default for exported properties).
     */
    @JvmField
    public val EDITOR: PropertyUsageFlags = PropertyUsageFlags(4)

    /**
     * The property is excluded from the class reference.
     */
    @JvmField
    public val INTERNAL: PropertyUsageFlags = PropertyUsageFlags(8)

    /**
     * The property can be checked in the [EditorInspector].
     */
    @JvmField
    public val CHECKABLE: PropertyUsageFlags = PropertyUsageFlags(16)

    /**
     * The property is checked in the [EditorInspector].
     */
    @JvmField
    public val CHECKED: PropertyUsageFlags = PropertyUsageFlags(32)

    /**
     * Used to group properties together in the editor. See [EditorInspector].
     */
    @JvmField
    public val GROUP: PropertyUsageFlags = PropertyUsageFlags(64)

    /**
     * Used to categorize properties together in the editor.
     */
    @JvmField
    public val CATEGORY: PropertyUsageFlags = PropertyUsageFlags(128)

    /**
     * Used to group properties together in the editor in a subgroup (under a group). See
     * [EditorInspector].
     */
    @JvmField
    public val SUBGROUP: PropertyUsageFlags = PropertyUsageFlags(256)

    /**
     * The property is a bitfield, i.e. it contains multiple flags represented as bits.
     */
    @JvmField
    public val CLASS_IS_BITFIELD: PropertyUsageFlags = PropertyUsageFlags(512)

    /**
     * The property does not save its state in [PackedScene].
     */
    @JvmField
    public val NO_INSTANCE_STATE: PropertyUsageFlags = PropertyUsageFlags(1024)

    /**
     * Editing the property prompts the user for restarting the editor.
     */
    @JvmField
    public val RESTART_IF_CHANGED: PropertyUsageFlags = PropertyUsageFlags(2048)

    /**
     * The property is a script variable. [PROPERTY_USAGE_SCRIPT_VARIABLE] can be used to
     * distinguish between exported script variables from built-in variables (which don't have this
     * usage flag). By default, [PROPERTY_USAGE_SCRIPT_VARIABLE] is **not** applied to variables that
     * are created by overriding [Object.GetPropertyList] in a script.
     */
    @JvmField
    public val SCRIPT_VARIABLE: PropertyUsageFlags = PropertyUsageFlags(4096)

    /**
     * The property value of type [Object] will be stored even if its value is `null`.
     */
    @JvmField
    public val STORE_IF_NULL: PropertyUsageFlags = PropertyUsageFlags(8192)

    /**
     * If this property is modified, all inspector fields will be refreshed.
     */
    @JvmField
    public val UPDATE_ALL_IF_MODIFIED: PropertyUsageFlags = PropertyUsageFlags(16384)

    @JvmField
    public val SCRIPT_DEFAULT_VALUE: PropertyUsageFlags = PropertyUsageFlags(32768)

    /**
     * The property is a variable of enum type, i.e. it only takes named integer constants from its
     * associated enumeration.
     */
    @JvmField
    public val CLASS_IS_ENUM: PropertyUsageFlags = PropertyUsageFlags(65536)

    /**
     * If property has `nil` as default value, its type will be [Any].
     */
    @JvmField
    public val NIL_IS_VARIANT: PropertyUsageFlags = PropertyUsageFlags(131072)

    /**
     * The property is the element count of a property array, i.e. a list of groups of related
     * properties. Properties defined with this usage also need a specific `class_name` field in the
     * form of `label,prefix`. The field may also include additional comma-separated options:
     *
     * - `page_size=N`: Overrides
     * [EditorSettings.interface/inspector/maxArrayDictionaryItemsPerPage] for this array.
     *
     * - `add_button_text=text`: The text displayed by the "Add Element" button.
     *
     * - `static`: The elements can't be re-arranged.
     *
     * - `const`: New elements can't be added.
     *
     * - `numbered`: An index will appear next to each element.
     *
     * - `unfoldable`: The array can't be folded.
     *
     * - `swap_method=method_name`: The method that will be called when two elements switch places.
     * The method should take 2 [Long] parameters, which will be indices of the elements being swapped.
     *
     * Note that making a full-fledged property array requires boilerplate code involving
     * [Object.GetPropertyList].
     */
    @JvmField
    public val ARRAY: PropertyUsageFlags = PropertyUsageFlags(262144)

    /**
     * When duplicating a resource with [Resource.duplicate], and this flag is set on a property of
     * that resource, the property should always be duplicated, regardless of the `subresources` bool
     * parameter.
     */
    @JvmField
    public val ALWAYS_DUPLICATE: PropertyUsageFlags = PropertyUsageFlags(524288)

    /**
     * When duplicating a resource with [Resource.duplicate], and this flag is set on a property of
     * that resource, the property should never be duplicated, regardless of the `subresources` bool
     * parameter.
     */
    @JvmField
    public val NEVER_DUPLICATE: PropertyUsageFlags = PropertyUsageFlags(1048576)

    /**
     * The property is only shown in the editor if modern renderers are supported (the Compatibility
     * rendering method is excluded).
     */
    @JvmField
    public val HIGH_END_GFX: PropertyUsageFlags = PropertyUsageFlags(2097152)

    /**
     * The [NodePath] property will always be relative to the scene's root. Mostly useful for local
     * resources.
     */
    @JvmField
    public val NODE_PATH_FROM_SCENE_ROOT: PropertyUsageFlags = PropertyUsageFlags(4194304)

    /**
     * Use when a resource is created on the fly, i.e. the getter will always return a different
     * instance. [ResourceSaver] needs this information to properly save such resources.
     */
    @JvmField
    public val RESOURCE_NOT_PERSISTENT: PropertyUsageFlags = PropertyUsageFlags(8388608)

    /**
     * Inserting an animation key frame of this property will automatically increment the value,
     * allowing to easily keyframe multiple values in a row.
     */
    @JvmField
    public val KEYING_INCREMENTS: PropertyUsageFlags = PropertyUsageFlags(16777216)

    @JvmField
    public val DEFERRED_SET_RESOURCE: PropertyUsageFlags = PropertyUsageFlags(33554432)

    /**
     * When this property is a [Resource] and base object is a [Node], a resource instance will be
     * automatically created whenever the node is created in the editor.
     */
    @JvmField
    public val EDITOR_INSTANTIATE_OBJECT: PropertyUsageFlags = PropertyUsageFlags(67108864)

    /**
     * The property is considered a basic setting and will appear even when advanced mode is
     * disabled. Used for project settings.
     */
    @JvmField
    public val EDITOR_BASIC_SETTING: PropertyUsageFlags = PropertyUsageFlags(134217728)

    /**
     * The property is read-only in the [EditorInspector].
     */
    @JvmField
    public val READ_ONLY: PropertyUsageFlags = PropertyUsageFlags(268435456)

    /**
     * An export preset property with this flag contains confidential information and is stored
     * separately from the rest of the export preset configuration.
     */
    @JvmField
    public val SECRET: PropertyUsageFlags = PropertyUsageFlags(536870912)

    /**
     * Default usage (storage and editor).
     */
    @JvmField
    public val DEFAULT: PropertyUsageFlags = PropertyUsageFlags(6)

    /**
     * Default usage but without showing the property in the editor (storage).
     */
    @JvmField
    public val NO_EDITOR: PropertyUsageFlags = PropertyUsageFlags(2)
  }
}
