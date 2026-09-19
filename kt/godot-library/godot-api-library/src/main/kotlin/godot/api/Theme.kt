// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_LONG_STRING_NAME_STRING_NAME_ANY
import godot.callMethod_LONG_STRING_NAME_STRING_NAME_ret_ANY
import godot.callMethod_LONG_STRING_ret_PACKED_STRING_ARRAY
import godot.callMethod_STRING_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_STRING_NAME_STRING_NAME
import godot.callPtrMethod_LONG_STRING_NAME_STRING_NAME_STRING_NAME
import godot.callPtrMethod_LONG_STRING_NAME_STRING_NAME_ret_BOOL
import godot.callPtrMethod_LONG_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_STRING_NAME
import godot.callPtrMethod_STRING_NAME_STRING_NAME
import godot.callPtrMethod_STRING_NAME_STRING_NAME_COLOR
import godot.callPtrMethod_STRING_NAME_STRING_NAME_LONG
import godot.callPtrMethod_STRING_NAME_STRING_NAME_OBJECT
import godot.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME
import godot.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL
import godot.callPtrMethod_STRING_NAME_STRING_NAME_ret_COLOR
import godot.callPtrMethod_STRING_NAME_STRING_NAME_ret_LONG
import godot.callPtrMethod_STRING_NAME_STRING_NAME_ret_OBJECT_REF
import godot.callPtrMethod_STRING_NAME_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod_STRING_NAME_ret_STRING_NAME
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A resource used for styling/skinning [Control] and [Window] nodes. While individual controls can
 * be styled using their local theme overrides (see [Control.addThemeColorOverride]), theme resources
 * allow you to store and apply the same settings across all controls sharing the same type (e.g. style
 * all [Button]s the same). One theme resource can be used for the entire project, but you can also set
 * a separate theme resource to a branch of control nodes. A theme resource assigned to a control
 * applies to the control itself, as well as all of its direct and indirect children (as long as a
 * chain of controls is uninterrupted).
 *
 * Use [ProjectSettings.gui/theme/custom] to set up a project-scope theme that will be available to
 * every control in your project.
 *
 * Use [Control.theme] of any control node to set up a theme that will be available to that control
 * and all of its direct and indirect children.
 */
@GodotBaseType
public open class Theme : Resource() {
  /**
   * The default base scale factor of this theme resource. Used by some controls to scale their
   * visual properties based on the global scale factor. If this value is set to `0.0`, the global
   * scale factor is used (see [ThemeDB.fallbackBaseScale]).
   *
   * Use [hasDefaultBaseScale] to check if this value is valid.
   */
  public final inline var defaultBaseScale: Float
    @JvmName("defaultBaseScaleProperty")
    get() = getDefaultBaseScale()
    @JvmName("defaultBaseScaleProperty")
    set(`value`) {
      setDefaultBaseScale(value)
    }

  /**
   * The default font of this theme resource. Used as the default value when trying to fetch a font
   * resource that doesn't exist in this theme or is in invalid state. If the default font is also
   * missing or invalid, the engine fallback value is used (see [ThemeDB.fallbackFont]).
   *
   * Use [hasDefaultFont] to check if this value is valid.
   */
  public final inline var defaultFont: Font?
    @JvmName("defaultFontProperty")
    get() = getDefaultFont()
    @JvmName("defaultFontProperty")
    set(`value`) {
      setDefaultFont(value)
    }

  /**
   * The default font size of this theme resource. Used as the default value when trying to fetch a
   * font size value that doesn't exist in this theme or is in invalid state. If the default font size
   * is also missing or invalid, the engine fallback value is used (see [ThemeDB.fallbackFontSize]).
   *
   * Values below `1` are invalid and can be used to unset the property. Use [hasDefaultFontSize] to
   * check if this value is valid.
   */
  public final inline var defaultFontSize: Int
    @JvmName("defaultFontSizeProperty")
    get() = getDefaultFontSize()
    @JvmName("defaultFontSizeProperty")
    set(`value`) {
      setDefaultFontSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(753, scriptPtr)
  }

  /**
   * Creates or changes the value of the icon property defined by [name] and [themeType]. Use
   * [clearIcon] to remove the property.
   */
  public final fun setIcon(
    name: StringName,
    themeType: StringName,
    texture: Texture2D?,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_OBJECT(ptr, objectID.id, MethodBindings.setIconPtr, name, themeType, texture)
  }

  /**
   * Returns the icon property defined by [name] and [themeType], if it exists.
   *
   * Returns the engine fallback icon value if the property doesn't exist (see
   * [ThemeDB.fallbackIcon]). Use [hasIcon] to check for existence.
   */
  public final fun getIcon(name: StringName, themeType: StringName): Texture2D? =
      (TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getIconPtr, name, themeType) as Texture2D?)

  /**
   * Returns `true` if the icon property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setIcon] to define it.
   */
  public final fun hasIcon(name: StringName, themeType: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasIconPtr, name, themeType)

  /**
   * Renames the icon property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasIcon] to check for existence, and [clearIcon] to remove the existing property.
   */
  public final fun renameIcon(
    oldName: StringName,
    name: StringName,
    themeType: StringName,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameIconPtr, oldName, name, themeType)
  }

  /**
   * Removes the icon property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasIcon] to check for existence.
   */
  public final fun clearIcon(name: StringName, themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.clearIconPtr, name, themeType)
  }

  /**
   * Returns a list of names for icon properties defined with [themeType]. Use [getIconTypeList] to
   * get a list of possible theme type names.
   */
  public final fun getIconList(themeType: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getIconListPtr, themeType)

  /**
   * Returns a list of all unique theme type names for icon properties. Use [getTypeList] to get a
   * list of all unique theme types.
   */
  public final fun getIconTypeList(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getIconTypeListPtr)

  /**
   * Creates or changes the value of the [StyleBox] property defined by [name] and [themeType]. Use
   * [clearStylebox] to remove the property.
   */
  public final fun setStylebox(
    name: StringName,
    themeType: StringName,
    texture: StyleBox?,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_OBJECT(ptr, objectID.id, MethodBindings.setStyleboxPtr, name, themeType, texture)
  }

  /**
   * Returns the [StyleBox] property defined by [name] and [themeType], if it exists.
   *
   * Returns the engine fallback stylebox value if the property doesn't exist (see
   * [ThemeDB.fallbackStylebox]). Use [hasStylebox] to check for existence.
   */
  public final fun getStylebox(name: StringName, themeType: StringName): StyleBox? =
      (TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getStyleboxPtr, name, themeType) as StyleBox?)

  /**
   * Returns `true` if the [StyleBox] property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setStylebox] to define it.
   */
  public final fun hasStylebox(name: StringName, themeType: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasStyleboxPtr, name, themeType)

  /**
   * Renames the [StyleBox] property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasStylebox] to check for existence, and [clearStylebox] to remove the existing property.
   */
  public final fun renameStylebox(
    oldName: StringName,
    name: StringName,
    themeType: StringName,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameStyleboxPtr, oldName, name, themeType)
  }

  /**
   * Removes the [StyleBox] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasStylebox] to check for existence.
   */
  public final fun clearStylebox(name: StringName, themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.clearStyleboxPtr, name, themeType)
  }

  /**
   * Returns a list of names for [StyleBox] properties defined with [themeType]. Use
   * [getStyleboxTypeList] to get a list of possible theme type names.
   */
  public final fun getStyleboxList(themeType: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getStyleboxListPtr, themeType)

  /**
   * Returns a list of all unique theme type names for [StyleBox] properties. Use [getTypeList] to
   * get a list of all unique theme types.
   */
  public final fun getStyleboxTypeList(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getStyleboxTypeListPtr)

  /**
   * Creates or changes the value of the [Font] property defined by [name] and [themeType]. Use
   * [clearFont] to remove the property.
   */
  public final fun setFont(
    name: StringName,
    themeType: StringName,
    font: Font?,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_OBJECT(ptr, objectID.id, MethodBindings.setFontPtr, name, themeType, font)
  }

  /**
   * Returns the [Font] property defined by [name] and [themeType], if it exists.
   *
   * Returns the default theme font if the property doesn't exist and the default theme font is set
   * up (see [defaultFont]). Use [hasFont] to check for existence of the property and [hasDefaultFont]
   * to check for existence of the default theme font.
   *
   * Returns the engine fallback font value, if neither exist (see [ThemeDB.fallbackFont]).
   */
  public final fun getFont(name: StringName, themeType: StringName): Font? =
      (TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getFontPtr, name, themeType) as Font?)

  /**
   * Returns `true` if the [Font] property defined by [name] and [themeType] exists, or if the
   * default theme font is set up (see [hasDefaultFont]).
   *
   * Returns `false` if neither exist. Use [setFont] to define the property.
   */
  public final fun hasFont(name: StringName, themeType: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasFontPtr, name, themeType)

  /**
   * Renames the [Font] property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasFont] to check for existence, and [clearFont] to remove the existing property.
   */
  public final fun renameFont(
    oldName: StringName,
    name: StringName,
    themeType: StringName,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameFontPtr, oldName, name, themeType)
  }

  /**
   * Removes the [Font] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasFont] to check for existence.
   */
  public final fun clearFont(name: StringName, themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.clearFontPtr, name, themeType)
  }

  /**
   * Returns a list of names for [Font] properties defined with [themeType]. Use [getFontTypeList]
   * to get a list of possible theme type names.
   */
  public final fun getFontList(themeType: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getFontListPtr, themeType)

  /**
   * Returns a list of all unique theme type names for [Font] properties. Use [getTypeList] to get a
   * list of all unique theme types.
   */
  public final fun getFontTypeList(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getFontTypeListPtr)

  /**
   * Creates or changes the value of the font size property defined by [name] and [themeType]. Use
   * [clearFontSize] to remove the property.
   */
  public final fun setFontSize(
    name: StringName,
    themeType: StringName,
    fontSize: Int,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_LONG(ptr, objectID.id, MethodBindings.setFontSizePtr, name, themeType, fontSize.toLong())
  }

  /**
   * Returns the font size property defined by [name] and [themeType], if it exists.
   *
   * Returns the default theme font size if the property doesn't exist and the default theme font
   * size is set up (see [defaultFontSize]). Use [hasFontSize] to check for existence of the property
   * and [hasDefaultFontSize] to check for existence of the default theme font.
   *
   * Returns the engine fallback font size value, if neither exist (see [ThemeDB.fallbackFontSize]).
   */
  public final fun getFontSize(name: StringName, themeType: StringName): Int =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_LONG(ptr, objectID.id, MethodBindings.getFontSizePtr, name, themeType).toInt()

  /**
   * Returns `true` if the font size property defined by [name] and [themeType] exists, or if the
   * default theme font size is set up (see [hasDefaultFontSize]).
   *
   * Returns `false` if neither exist. Use [setFontSize] to define the property.
   */
  public final fun hasFontSize(name: StringName, themeType: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasFontSizePtr, name, themeType)

  /**
   * Renames the font size property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasFontSize] to check for existence, and [clearFontSize] to remove the existing property.
   */
  public final fun renameFontSize(
    oldName: StringName,
    name: StringName,
    themeType: StringName,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameFontSizePtr, oldName, name, themeType)
  }

  /**
   * Removes the font size property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasFontSize] to check for existence.
   */
  public final fun clearFontSize(name: StringName, themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.clearFontSizePtr, name, themeType)
  }

  /**
   * Returns a list of names for font size properties defined with [themeType]. Use
   * [getFontSizeTypeList] to get a list of possible theme type names.
   */
  public final fun getFontSizeList(themeType: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getFontSizeListPtr, themeType)

  /**
   * Returns a list of all unique theme type names for font size properties. Use [getTypeList] to
   * get a list of all unique theme types.
   */
  public final fun getFontSizeTypeList(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getFontSizeTypeListPtr)

  /**
   * Creates or changes the value of the [Color] property defined by [name] and [themeType]. Use
   * [clearColor] to remove the property.
   */
  public final fun setColor(
    name: StringName,
    themeType: StringName,
    color: Color,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_COLOR(ptr, objectID.id, MethodBindings.setColorPtr, name, themeType, color)
  }

  /**
   * Returns the [Color] property defined by [name] and [themeType], if it exists.
   *
   * Returns the default color value if the property doesn't exist. Use [hasColor] to check for
   * existence.
   */
  public final fun getColor(name: StringName, themeType: StringName): Color =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_COLOR(ptr, objectID.id, MethodBindings.getColorPtr, name, themeType)

  /**
   * Returns `true` if the [Color] property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setColor] to define it.
   */
  public final fun hasColor(name: StringName, themeType: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasColorPtr, name, themeType)

  /**
   * Renames the [Color] property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasColor] to check for existence, and [clearColor] to remove the existing property.
   */
  public final fun renameColor(
    oldName: StringName,
    name: StringName,
    themeType: StringName,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameColorPtr, oldName, name, themeType)
  }

  /**
   * Removes the [Color] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasColor] to check for existence.
   */
  public final fun clearColor(name: StringName, themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.clearColorPtr, name, themeType)
  }

  /**
   * Returns a list of names for [Color] properties defined with [themeType]. Use [getColorTypeList]
   * to get a list of possible theme type names.
   */
  public final fun getColorList(themeType: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getColorListPtr, themeType)

  /**
   * Returns a list of all unique theme type names for [Color] properties. Use [getTypeList] to get
   * a list of all unique theme types.
   */
  public final fun getColorTypeList(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getColorTypeListPtr)

  /**
   * Creates or changes the value of the constant property defined by [name] and [themeType]. Use
   * [clearConstant] to remove the property.
   */
  public final fun setConstant(
    name: StringName,
    themeType: StringName,
    constant: Int,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_LONG(ptr, objectID.id, MethodBindings.setConstantPtr, name, themeType, constant.toLong())
  }

  /**
   * Returns the constant property defined by [name] and [themeType], if it exists.
   *
   * Returns `0` if the property doesn't exist. Use [hasConstant] to check for existence.
   */
  public final fun getConstant(name: StringName, themeType: StringName): Int =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_LONG(ptr, objectID.id, MethodBindings.getConstantPtr, name, themeType).toInt()

  /**
   * Returns `true` if the constant property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setConstant] to define it.
   */
  public final fun hasConstant(name: StringName, themeType: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasConstantPtr, name, themeType)

  /**
   * Renames the constant property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasConstant] to check for existence, and [clearConstant] to remove the existing property.
   */
  public final fun renameConstant(
    oldName: StringName,
    name: StringName,
    themeType: StringName,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameConstantPtr, oldName, name, themeType)
  }

  /**
   * Removes the constant property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasConstant] to check for existence.
   */
  public final fun clearConstant(name: StringName, themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.clearConstantPtr, name, themeType)
  }

  /**
   * Returns a list of names for constant properties defined with [themeType]. Use
   * [getConstantTypeList] to get a list of possible theme type names.
   */
  public final fun getConstantList(themeType: String): PackedStringArray =
      TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getConstantListPtr, themeType)

  /**
   * Returns a list of all unique theme type names for constant properties. Use [getTypeList] to get
   * a list of all unique theme types.
   */
  public final fun getConstantTypeList(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getConstantTypeListPtr)

  public final fun setDefaultBaseScale(baseScale: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDefaultBaseScalePtr, baseScale.toDouble())
  }

  public final fun getDefaultBaseScale(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDefaultBaseScalePtr).toFloat()

  /**
   * Returns `true` if [defaultBaseScale] has a valid value.
   *
   * Returns `false` if it doesn't. The value must be greater than `0.0` to be considered valid.
   */
  public final fun hasDefaultBaseScale(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.hasDefaultBaseScalePtr)

  public final fun setDefaultFont(font: Font?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setDefaultFontPtr, font)
  }

  public final fun getDefaultFont(): Font? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getDefaultFontPtr) as Font?)

  /**
   * Returns `true` if [defaultFont] has a valid value.
   *
   * Returns `false` if it doesn't.
   */
  public final fun hasDefaultFont(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.hasDefaultFontPtr)

  public final fun setDefaultFontSize(fontSize: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setDefaultFontSizePtr, fontSize.toLong())
  }

  public final fun getDefaultFontSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDefaultFontSizePtr).toInt()

  /**
   * Returns `true` if [defaultFontSize] has a valid value.
   *
   * Returns `false` if it doesn't. The value must be greater than `0` to be considered valid.
   */
  public final fun hasDefaultFontSize(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.hasDefaultFontSizePtr)

  /**
   * Creates or changes the value of the theme property of [dataType] defined by [name] and
   * [themeType]. Use [clearThemeItem] to remove the property.
   *
   * Fails if the [value] type is not accepted by [dataType].
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun setThemeItem(
    dataType: DataType,
    name: StringName,
    themeType: StringName,
    `value`: Any?,
  ): Unit {
    TransferContext.callMethod_LONG_STRING_NAME_STRING_NAME_ANY(ptr, objectID.id, MethodBindings.setThemeItemPtr, dataType.value, name, themeType, value)
  }

  /**
   * Returns the theme property of [dataType] defined by [name] and [themeType], if it exists.
   *
   * Returns the engine fallback value if the property doesn't exist (see [ThemeDB]). Use
   * [hasThemeItem] to check for existence.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun getThemeItem(
    dataType: DataType,
    name: StringName,
    themeType: StringName,
  ): Any? =
      TransferContext.callMethod_LONG_STRING_NAME_STRING_NAME_ret_ANY(ptr, objectID.id, MethodBindings.getThemeItemPtr, dataType.value, name, themeType)

  /**
   * Returns `true` if the theme property of [dataType] defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setThemeItem] to define it.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun hasThemeItem(
    dataType: DataType,
    name: StringName,
    themeType: StringName,
  ): Boolean =
      TransferContext.callPtrMethod_LONG_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasThemeItemPtr, dataType.value, name, themeType)

  /**
   * Renames the theme property of [dataType] defined by [oldName] and [themeType] to [name], if it
   * exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasThemeItem] to check for existence, and [clearThemeItem] to remove the existing property.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun renameThemeItem(
    dataType: DataType,
    oldName: StringName,
    name: StringName,
    themeType: StringName,
  ): Unit {
    TransferContext.callPtrMethod_LONG_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameThemeItemPtr, dataType.value, oldName, name, themeType)
  }

  /**
   * Removes the theme property of [dataType] defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasThemeItem] to check for existence.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun clearThemeItem(
    dataType: DataType,
    name: StringName,
    themeType: StringName,
  ): Unit {
    TransferContext.callPtrMethod_LONG_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.clearThemeItemPtr, dataType.value, name, themeType)
  }

  /**
   * Returns a list of names for properties of [dataType] defined with [themeType]. Use
   * [getThemeItemTypeList] to get a list of possible theme type names.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun getThemeItemList(dataType: DataType, themeType: String): PackedStringArray =
      TransferContext.callMethod_LONG_STRING_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getThemeItemListPtr, dataType.value, themeType)

  /**
   * Returns a list of all unique theme type names for [dataType] properties. Use [getTypeList] to
   * get a list of all unique theme types.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun getThemeItemTypeList(dataType: DataType): PackedStringArray =
      TransferContext.callPtrMethod_LONG_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getThemeItemTypeListPtr, dataType.value)

  /**
   * Marks [themeType] as a variation of [baseType].
   *
   * This adds [themeType] as a suggested option for [Control.themeTypeVariation] on a [Control]
   * that is of the [baseType] class.
   *
   * Variations can also be nested, i.e. [baseType] can be another variation. If a chain of
   * variations ends with a [baseType] matching the class of the [Control], the whole chain is going to
   * be suggested as options.
   *
   * **Note:** Suggestions only show up if this theme resource is set as the project default theme.
   * See [ProjectSettings.gui/theme/custom].
   */
  public final fun setTypeVariation(themeType: StringName, baseType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.setTypeVariationPtr, themeType, baseType)
  }

  /**
   * Returns `true` if [themeType] is marked as a variation of [baseType].
   */
  public final fun isTypeVariation(themeType: StringName, baseType: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.isTypeVariationPtr, themeType, baseType)

  /**
   * Unmarks [themeType] as being a variation of another theme type. See [setTypeVariation].
   */
  public final fun clearTypeVariation(themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME(ptr, objectID.id, MethodBindings.clearTypeVariationPtr, themeType)
  }

  /**
   * Returns the name of the base theme type if [themeType] is a valid variation type. Returns an
   * empty string otherwise.
   */
  public final fun getTypeVariationBase(themeType: StringName): StringName =
      TransferContext.callPtrMethod_STRING_NAME_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getTypeVariationBasePtr, themeType)

  /**
   * Returns a list of all type variations for the given [baseType].
   */
  public final fun getTypeVariationList(baseType: StringName): PackedStringArray =
      TransferContext.callPtrMethod_STRING_NAME_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getTypeVariationListPtr, baseType)

  /**
   * Adds an empty theme type for every valid data type.
   *
   * **Note:** Empty types are not saved with the theme. This method only exists to perform
   * in-memory changes to the resource. Use available `set_*` methods to add theme items.
   */
  public final fun addType(themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME(ptr, objectID.id, MethodBindings.addTypePtr, themeType)
  }

  /**
   * Removes the theme type, gracefully discarding defined theme items. If the type is a variation,
   * this information is also erased. If the type is a base for type variations, those variations lose
   * their base.
   */
  public final fun removeType(themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME(ptr, objectID.id, MethodBindings.removeTypePtr, themeType)
  }

  /**
   * Renames the theme type [oldThemeType] to [themeType], if the old type exists and the new one
   * doesn't exist.
   *
   * **Note:** Renaming a theme type to an empty name or a variation to a type associated with a
   * built-in class removes type variation connections in a way that cannot be undone by reversing the
   * rename alone.
   */
  public final fun renameType(oldThemeType: StringName, themeType: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameTypePtr, oldThemeType, themeType)
  }

  /**
   * Returns a list of all unique theme type names. Use the appropriate `get_*_type_list` method to
   * get a list of unique theme types for a single data type.
   */
  public final fun getTypeList(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getTypeListPtr)

  /**
   * Adds missing and overrides existing definitions with values from the [other] theme resource.
   *
   * **Note:** This modifies the current theme. If you want to merge two themes together without
   * modifying either one, create a new empty theme and merge the other two into it one after another.
   */
  public final fun mergeWith(other: Theme?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.mergeWithPtr, other)
  }

  /**
   * Removes all the theme properties defined on the theme resource.
   */
  public final fun clear(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPtr)
  }

  /**
   * Creates or changes the value of the icon property defined by [name] and [themeType]. Use
   * [clearIcon] to remove the property.
   */
  public final fun setIcon(
    name: String,
    themeType: String,
    texture: Texture2D?,
  ) = setIcon(name.asCachedStringName(), themeType.asCachedStringName(), texture)

  /**
   * Returns the icon property defined by [name] and [themeType], if it exists.
   *
   * Returns the engine fallback icon value if the property doesn't exist (see
   * [ThemeDB.fallbackIcon]). Use [hasIcon] to check for existence.
   */
  public final fun getIcon(name: String, themeType: String): Texture2D? =
      getIcon(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if the icon property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setIcon] to define it.
   */
  public final fun hasIcon(name: String, themeType: String): Boolean =
      hasIcon(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Renames the icon property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasIcon] to check for existence, and [clearIcon] to remove the existing property.
   */
  public final fun renameIcon(
    oldName: String,
    name: String,
    themeType: String,
  ) =
      renameIcon(oldName.asCachedStringName(), name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Removes the icon property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasIcon] to check for existence.
   */
  public final fun clearIcon(name: String, themeType: String) =
      clearIcon(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Creates or changes the value of the [StyleBox] property defined by [name] and [themeType]. Use
   * [clearStylebox] to remove the property.
   */
  public final fun setStylebox(
    name: String,
    themeType: String,
    texture: StyleBox?,
  ) = setStylebox(name.asCachedStringName(), themeType.asCachedStringName(), texture)

  /**
   * Returns the [StyleBox] property defined by [name] and [themeType], if it exists.
   *
   * Returns the engine fallback stylebox value if the property doesn't exist (see
   * [ThemeDB.fallbackStylebox]). Use [hasStylebox] to check for existence.
   */
  public final fun getStylebox(name: String, themeType: String): StyleBox? =
      getStylebox(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if the [StyleBox] property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setStylebox] to define it.
   */
  public final fun hasStylebox(name: String, themeType: String): Boolean =
      hasStylebox(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Renames the [StyleBox] property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasStylebox] to check for existence, and [clearStylebox] to remove the existing property.
   */
  public final fun renameStylebox(
    oldName: String,
    name: String,
    themeType: String,
  ) =
      renameStylebox(oldName.asCachedStringName(), name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Removes the [StyleBox] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasStylebox] to check for existence.
   */
  public final fun clearStylebox(name: String, themeType: String) =
      clearStylebox(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Creates or changes the value of the [Font] property defined by [name] and [themeType]. Use
   * [clearFont] to remove the property.
   */
  public final fun setFont(
    name: String,
    themeType: String,
    font: Font?,
  ) = setFont(name.asCachedStringName(), themeType.asCachedStringName(), font)

  /**
   * Returns the [Font] property defined by [name] and [themeType], if it exists.
   *
   * Returns the default theme font if the property doesn't exist and the default theme font is set
   * up (see [defaultFont]). Use [hasFont] to check for existence of the property and [hasDefaultFont]
   * to check for existence of the default theme font.
   *
   * Returns the engine fallback font value, if neither exist (see [ThemeDB.fallbackFont]).
   */
  public final fun getFont(name: String, themeType: String): Font? =
      getFont(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if the [Font] property defined by [name] and [themeType] exists, or if the
   * default theme font is set up (see [hasDefaultFont]).
   *
   * Returns `false` if neither exist. Use [setFont] to define the property.
   */
  public final fun hasFont(name: String, themeType: String): Boolean =
      hasFont(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Renames the [Font] property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasFont] to check for existence, and [clearFont] to remove the existing property.
   */
  public final fun renameFont(
    oldName: String,
    name: String,
    themeType: String,
  ) =
      renameFont(oldName.asCachedStringName(), name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Removes the [Font] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasFont] to check for existence.
   */
  public final fun clearFont(name: String, themeType: String) =
      clearFont(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Creates or changes the value of the font size property defined by [name] and [themeType]. Use
   * [clearFontSize] to remove the property.
   */
  public final fun setFontSize(
    name: String,
    themeType: String,
    fontSize: Int,
  ) = setFontSize(name.asCachedStringName(), themeType.asCachedStringName(), fontSize)

  /**
   * Returns the font size property defined by [name] and [themeType], if it exists.
   *
   * Returns the default theme font size if the property doesn't exist and the default theme font
   * size is set up (see [defaultFontSize]). Use [hasFontSize] to check for existence of the property
   * and [hasDefaultFontSize] to check for existence of the default theme font.
   *
   * Returns the engine fallback font size value, if neither exist (see [ThemeDB.fallbackFontSize]).
   */
  public final fun getFontSize(name: String, themeType: String): Int =
      getFontSize(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if the font size property defined by [name] and [themeType] exists, or if the
   * default theme font size is set up (see [hasDefaultFontSize]).
   *
   * Returns `false` if neither exist. Use [setFontSize] to define the property.
   */
  public final fun hasFontSize(name: String, themeType: String): Boolean =
      hasFontSize(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Renames the font size property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasFontSize] to check for existence, and [clearFontSize] to remove the existing property.
   */
  public final fun renameFontSize(
    oldName: String,
    name: String,
    themeType: String,
  ) =
      renameFontSize(oldName.asCachedStringName(), name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Removes the font size property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasFontSize] to check for existence.
   */
  public final fun clearFontSize(name: String, themeType: String) =
      clearFontSize(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Creates or changes the value of the [Color] property defined by [name] and [themeType]. Use
   * [clearColor] to remove the property.
   */
  public final fun setColor(
    name: String,
    themeType: String,
    color: Color,
  ) = setColor(name.asCachedStringName(), themeType.asCachedStringName(), color)

  /**
   * Returns the [Color] property defined by [name] and [themeType], if it exists.
   *
   * Returns the default color value if the property doesn't exist. Use [hasColor] to check for
   * existence.
   */
  public final fun getColor(name: String, themeType: String): Color =
      getColor(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if the [Color] property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setColor] to define it.
   */
  public final fun hasColor(name: String, themeType: String): Boolean =
      hasColor(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Renames the [Color] property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasColor] to check for existence, and [clearColor] to remove the existing property.
   */
  public final fun renameColor(
    oldName: String,
    name: String,
    themeType: String,
  ) =
      renameColor(oldName.asCachedStringName(), name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Removes the [Color] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasColor] to check for existence.
   */
  public final fun clearColor(name: String, themeType: String) =
      clearColor(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Creates or changes the value of the constant property defined by [name] and [themeType]. Use
   * [clearConstant] to remove the property.
   */
  public final fun setConstant(
    name: String,
    themeType: String,
    constant: Int,
  ) = setConstant(name.asCachedStringName(), themeType.asCachedStringName(), constant)

  /**
   * Returns the constant property defined by [name] and [themeType], if it exists.
   *
   * Returns `0` if the property doesn't exist. Use [hasConstant] to check for existence.
   */
  public final fun getConstant(name: String, themeType: String): Int =
      getConstant(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if the constant property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setConstant] to define it.
   */
  public final fun hasConstant(name: String, themeType: String): Boolean =
      hasConstant(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Renames the constant property defined by [oldName] and [themeType] to [name], if it exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasConstant] to check for existence, and [clearConstant] to remove the existing property.
   */
  public final fun renameConstant(
    oldName: String,
    name: String,
    themeType: String,
  ) =
      renameConstant(oldName.asCachedStringName(), name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Removes the constant property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasConstant] to check for existence.
   */
  public final fun clearConstant(name: String, themeType: String) =
      clearConstant(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Creates or changes the value of the theme property of [dataType] defined by [name] and
   * [themeType]. Use [clearThemeItem] to remove the property.
   *
   * Fails if the [value] type is not accepted by [dataType].
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun setThemeItem(
    dataType: DataType,
    name: String,
    themeType: String,
    `value`: Any?,
  ) = setThemeItem(dataType, name.asCachedStringName(), themeType.asCachedStringName(), value)

  /**
   * Returns the theme property of [dataType] defined by [name] and [themeType], if it exists.
   *
   * Returns the engine fallback value if the property doesn't exist (see [ThemeDB]). Use
   * [hasThemeItem] to check for existence.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun getThemeItem(
    dataType: DataType,
    name: String,
    themeType: String,
  ): Any? = getThemeItem(dataType, name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if the theme property of [dataType] defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setThemeItem] to define it.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun hasThemeItem(
    dataType: DataType,
    name: String,
    themeType: String,
  ): Boolean = hasThemeItem(dataType, name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Renames the theme property of [dataType] defined by [oldName] and [themeType] to [name], if it
   * exists.
   *
   * Fails if it doesn't exist, or if a similar property with the new name already exists. Use
   * [hasThemeItem] to check for existence, and [clearThemeItem] to remove the existing property.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun renameThemeItem(
    dataType: DataType,
    oldName: String,
    name: String,
    themeType: String,
  ) =
      renameThemeItem(dataType, oldName.asCachedStringName(), name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Removes the theme property of [dataType] defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasThemeItem] to check for existence.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun clearThemeItem(
    dataType: DataType,
    name: String,
    themeType: String,
  ) = clearThemeItem(dataType, name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Marks [themeType] as a variation of [baseType].
   *
   * This adds [themeType] as a suggested option for [Control.themeTypeVariation] on a [Control]
   * that is of the [baseType] class.
   *
   * Variations can also be nested, i.e. [baseType] can be another variation. If a chain of
   * variations ends with a [baseType] matching the class of the [Control], the whole chain is going to
   * be suggested as options.
   *
   * **Note:** Suggestions only show up if this theme resource is set as the project default theme.
   * See [ProjectSettings.gui/theme/custom].
   */
  public final fun setTypeVariation(themeType: String, baseType: String) =
      setTypeVariation(themeType.asCachedStringName(), baseType.asCachedStringName())

  /**
   * Returns `true` if [themeType] is marked as a variation of [baseType].
   */
  public final fun isTypeVariation(themeType: String, baseType: String): Boolean =
      isTypeVariation(themeType.asCachedStringName(), baseType.asCachedStringName())

  /**
   * Unmarks [themeType] as being a variation of another theme type. See [setTypeVariation].
   */
  public final fun clearTypeVariation(themeType: String) =
      clearTypeVariation(themeType.asCachedStringName())

  /**
   * Returns the name of the base theme type if [themeType] is a valid variation type. Returns an
   * empty string otherwise.
   */
  public final fun getTypeVariationBase(themeType: String): StringName =
      getTypeVariationBase(themeType.asCachedStringName())

  /**
   * Returns a list of all type variations for the given [baseType].
   */
  public final fun getTypeVariationList(baseType: String): PackedStringArray =
      getTypeVariationList(baseType.asCachedStringName())

  /**
   * Adds an empty theme type for every valid data type.
   *
   * **Note:** Empty types are not saved with the theme. This method only exists to perform
   * in-memory changes to the resource. Use available `set_*` methods to add theme items.
   */
  public final fun addType(themeType: String) = addType(themeType.asCachedStringName())

  /**
   * Removes the theme type, gracefully discarding defined theme items. If the type is a variation,
   * this information is also erased. If the type is a base for type variations, those variations lose
   * their base.
   */
  public final fun removeType(themeType: String) = removeType(themeType.asCachedStringName())

  /**
   * Renames the theme type [oldThemeType] to [themeType], if the old type exists and the new one
   * doesn't exist.
   *
   * **Note:** Renaming a theme type to an empty name or a variation to a type associated with a
   * built-in class removes type variation connections in a way that cannot be undone by reversing the
   * rename alone.
   */
  public final fun renameType(oldThemeType: String, themeType: String) =
      renameType(oldThemeType.asCachedStringName(), themeType.asCachedStringName())

  public enum class DataType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Theme's [Color] item type.
     */
    COLOR(0),
    /**
     * Theme's constant item type.
     */
    CONSTANT(1),
    /**
     * Theme's [Font] item type.
     */
    FONT(2),
    /**
     * Theme's font size item type.
     */
    FONT_SIZE(3),
    /**
     * Theme's icon [Texture2D] item type.
     */
    ICON(4),
    /**
     * Theme's [StyleBox] item type.
     */
    STYLEBOX(5),
    /**
     * Maximum value for the DataType enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): DataType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setIconName: MethodStringName3<Theme, Unit, StringName, StringName, Texture2D?> =
        MethodStringName3<Theme, Unit, StringName, StringName, Texture2D?>("set_icon")

    @JvmField
    public val getIconName: MethodStringName2<Theme, Texture2D?, StringName, StringName> =
        MethodStringName2<Theme, Texture2D?, StringName, StringName>("get_icon")

    @JvmField
    public val hasIconName: MethodStringName2<Theme, Boolean, StringName, StringName> =
        MethodStringName2<Theme, Boolean, StringName, StringName>("has_icon")

    @JvmField
    public val renameIconName: MethodStringName3<Theme, Unit, StringName, StringName, StringName> =
        MethodStringName3<Theme, Unit, StringName, StringName, StringName>("rename_icon")

    @JvmField
    public val clearIconName: MethodStringName2<Theme, Unit, StringName, StringName> =
        MethodStringName2<Theme, Unit, StringName, StringName>("clear_icon")

    @JvmField
    public val getIconListName: MethodStringName1<Theme, PackedStringArray, String> =
        MethodStringName1<Theme, PackedStringArray, String>("get_icon_list")

    @JvmField
    public val getIconTypeListName: MethodStringName0<Theme, PackedStringArray> =
        MethodStringName0<Theme, PackedStringArray>("get_icon_type_list")

    @JvmField
    public val setStyleboxName: MethodStringName3<Theme, Unit, StringName, StringName, StyleBox?> =
        MethodStringName3<Theme, Unit, StringName, StringName, StyleBox?>("set_stylebox")

    @JvmField
    public val getStyleboxName: MethodStringName2<Theme, StyleBox?, StringName, StringName> =
        MethodStringName2<Theme, StyleBox?, StringName, StringName>("get_stylebox")

    @JvmField
    public val hasStyleboxName: MethodStringName2<Theme, Boolean, StringName, StringName> =
        MethodStringName2<Theme, Boolean, StringName, StringName>("has_stylebox")

    @JvmField
    public val renameStyleboxName:
        MethodStringName3<Theme, Unit, StringName, StringName, StringName> =
        MethodStringName3<Theme, Unit, StringName, StringName, StringName>("rename_stylebox")

    @JvmField
    public val clearStyleboxName: MethodStringName2<Theme, Unit, StringName, StringName> =
        MethodStringName2<Theme, Unit, StringName, StringName>("clear_stylebox")

    @JvmField
    public val getStyleboxListName: MethodStringName1<Theme, PackedStringArray, String> =
        MethodStringName1<Theme, PackedStringArray, String>("get_stylebox_list")

    @JvmField
    public val getStyleboxTypeListName: MethodStringName0<Theme, PackedStringArray> =
        MethodStringName0<Theme, PackedStringArray>("get_stylebox_type_list")

    @JvmField
    public val setFontName: MethodStringName3<Theme, Unit, StringName, StringName, Font?> =
        MethodStringName3<Theme, Unit, StringName, StringName, Font?>("set_font")

    @JvmField
    public val getFontName: MethodStringName2<Theme, Font?, StringName, StringName> =
        MethodStringName2<Theme, Font?, StringName, StringName>("get_font")

    @JvmField
    public val hasFontName: MethodStringName2<Theme, Boolean, StringName, StringName> =
        MethodStringName2<Theme, Boolean, StringName, StringName>("has_font")

    @JvmField
    public val renameFontName: MethodStringName3<Theme, Unit, StringName, StringName, StringName> =
        MethodStringName3<Theme, Unit, StringName, StringName, StringName>("rename_font")

    @JvmField
    public val clearFontName: MethodStringName2<Theme, Unit, StringName, StringName> =
        MethodStringName2<Theme, Unit, StringName, StringName>("clear_font")

    @JvmField
    public val getFontListName: MethodStringName1<Theme, PackedStringArray, String> =
        MethodStringName1<Theme, PackedStringArray, String>("get_font_list")

    @JvmField
    public val getFontTypeListName: MethodStringName0<Theme, PackedStringArray> =
        MethodStringName0<Theme, PackedStringArray>("get_font_type_list")

    @JvmField
    public val setFontSizeName: MethodStringName3<Theme, Unit, StringName, StringName, Int> =
        MethodStringName3<Theme, Unit, StringName, StringName, Int>("set_font_size")

    @JvmField
    public val getFontSizeName: MethodStringName2<Theme, Int, StringName, StringName> =
        MethodStringName2<Theme, Int, StringName, StringName>("get_font_size")

    @JvmField
    public val hasFontSizeName: MethodStringName2<Theme, Boolean, StringName, StringName> =
        MethodStringName2<Theme, Boolean, StringName, StringName>("has_font_size")

    @JvmField
    public val renameFontSizeName:
        MethodStringName3<Theme, Unit, StringName, StringName, StringName> =
        MethodStringName3<Theme, Unit, StringName, StringName, StringName>("rename_font_size")

    @JvmField
    public val clearFontSizeName: MethodStringName2<Theme, Unit, StringName, StringName> =
        MethodStringName2<Theme, Unit, StringName, StringName>("clear_font_size")

    @JvmField
    public val getFontSizeListName: MethodStringName1<Theme, PackedStringArray, String> =
        MethodStringName1<Theme, PackedStringArray, String>("get_font_size_list")

    @JvmField
    public val getFontSizeTypeListName: MethodStringName0<Theme, PackedStringArray> =
        MethodStringName0<Theme, PackedStringArray>("get_font_size_type_list")

    @JvmField
    public val setColorName: MethodStringName3<Theme, Unit, StringName, StringName, Color> =
        MethodStringName3<Theme, Unit, StringName, StringName, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName2<Theme, Color, StringName, StringName> =
        MethodStringName2<Theme, Color, StringName, StringName>("get_color")

    @JvmField
    public val hasColorName: MethodStringName2<Theme, Boolean, StringName, StringName> =
        MethodStringName2<Theme, Boolean, StringName, StringName>("has_color")

    @JvmField
    public val renameColorName: MethodStringName3<Theme, Unit, StringName, StringName, StringName> =
        MethodStringName3<Theme, Unit, StringName, StringName, StringName>("rename_color")

    @JvmField
    public val clearColorName: MethodStringName2<Theme, Unit, StringName, StringName> =
        MethodStringName2<Theme, Unit, StringName, StringName>("clear_color")

    @JvmField
    public val getColorListName: MethodStringName1<Theme, PackedStringArray, String> =
        MethodStringName1<Theme, PackedStringArray, String>("get_color_list")

    @JvmField
    public val getColorTypeListName: MethodStringName0<Theme, PackedStringArray> =
        MethodStringName0<Theme, PackedStringArray>("get_color_type_list")

    @JvmField
    public val setConstantName: MethodStringName3<Theme, Unit, StringName, StringName, Int> =
        MethodStringName3<Theme, Unit, StringName, StringName, Int>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName2<Theme, Int, StringName, StringName> =
        MethodStringName2<Theme, Int, StringName, StringName>("get_constant")

    @JvmField
    public val hasConstantName: MethodStringName2<Theme, Boolean, StringName, StringName> =
        MethodStringName2<Theme, Boolean, StringName, StringName>("has_constant")

    @JvmField
    public val renameConstantName:
        MethodStringName3<Theme, Unit, StringName, StringName, StringName> =
        MethodStringName3<Theme, Unit, StringName, StringName, StringName>("rename_constant")

    @JvmField
    public val clearConstantName: MethodStringName2<Theme, Unit, StringName, StringName> =
        MethodStringName2<Theme, Unit, StringName, StringName>("clear_constant")

    @JvmField
    public val getConstantListName: MethodStringName1<Theme, PackedStringArray, String> =
        MethodStringName1<Theme, PackedStringArray, String>("get_constant_list")

    @JvmField
    public val getConstantTypeListName: MethodStringName0<Theme, PackedStringArray> =
        MethodStringName0<Theme, PackedStringArray>("get_constant_type_list")

    @JvmField
    public val setDefaultBaseScaleName: MethodStringName1<Theme, Unit, Float> =
        MethodStringName1<Theme, Unit, Float>("set_default_base_scale")

    @JvmField
    public val getDefaultBaseScaleName: MethodStringName0<Theme, Float> =
        MethodStringName0<Theme, Float>("get_default_base_scale")

    @JvmField
    public val hasDefaultBaseScaleName: MethodStringName0<Theme, Boolean> =
        MethodStringName0<Theme, Boolean>("has_default_base_scale")

    @JvmField
    public val setDefaultFontName: MethodStringName1<Theme, Unit, Font?> =
        MethodStringName1<Theme, Unit, Font?>("set_default_font")

    @JvmField
    public val getDefaultFontName: MethodStringName0<Theme, Font?> =
        MethodStringName0<Theme, Font?>("get_default_font")

    @JvmField
    public val hasDefaultFontName: MethodStringName0<Theme, Boolean> =
        MethodStringName0<Theme, Boolean>("has_default_font")

    @JvmField
    public val setDefaultFontSizeName: MethodStringName1<Theme, Unit, Int> =
        MethodStringName1<Theme, Unit, Int>("set_default_font_size")

    @JvmField
    public val getDefaultFontSizeName: MethodStringName0<Theme, Int> =
        MethodStringName0<Theme, Int>("get_default_font_size")

    @JvmField
    public val hasDefaultFontSizeName: MethodStringName0<Theme, Boolean> =
        MethodStringName0<Theme, Boolean>("has_default_font_size")

    @JvmField
    public val setThemeItemName:
        MethodStringName4<Theme, Unit, DataType, StringName, StringName, Any?> =
        MethodStringName4<Theme, Unit, DataType, StringName, StringName, Any?>("set_theme_item")

    @JvmField
    public val getThemeItemName: MethodStringName3<Theme, Any?, DataType, StringName, StringName> =
        MethodStringName3<Theme, Any?, DataType, StringName, StringName>("get_theme_item")

    @JvmField
    public val hasThemeItemName: MethodStringName3<Theme, Boolean, DataType, StringName, StringName>
        = MethodStringName3<Theme, Boolean, DataType, StringName, StringName>("has_theme_item")

    @JvmField
    public val renameThemeItemName:
        MethodStringName4<Theme, Unit, DataType, StringName, StringName, StringName> =
        MethodStringName4<Theme, Unit, DataType, StringName, StringName, StringName>("rename_theme_item")

    @JvmField
    public val clearThemeItemName: MethodStringName3<Theme, Unit, DataType, StringName, StringName>
        = MethodStringName3<Theme, Unit, DataType, StringName, StringName>("clear_theme_item")

    @JvmField
    public val getThemeItemListName: MethodStringName2<Theme, PackedStringArray, DataType, String> =
        MethodStringName2<Theme, PackedStringArray, DataType, String>("get_theme_item_list")

    @JvmField
    public val getThemeItemTypeListName: MethodStringName1<Theme, PackedStringArray, DataType> =
        MethodStringName1<Theme, PackedStringArray, DataType>("get_theme_item_type_list")

    @JvmField
    public val setTypeVariationName: MethodStringName2<Theme, Unit, StringName, StringName> =
        MethodStringName2<Theme, Unit, StringName, StringName>("set_type_variation")

    @JvmField
    public val isTypeVariationName: MethodStringName2<Theme, Boolean, StringName, StringName> =
        MethodStringName2<Theme, Boolean, StringName, StringName>("is_type_variation")

    @JvmField
    public val clearTypeVariationName: MethodStringName1<Theme, Unit, StringName> =
        MethodStringName1<Theme, Unit, StringName>("clear_type_variation")

    @JvmField
    public val getTypeVariationBaseName: MethodStringName1<Theme, StringName, StringName> =
        MethodStringName1<Theme, StringName, StringName>("get_type_variation_base")

    @JvmField
    public val getTypeVariationListName: MethodStringName1<Theme, PackedStringArray, StringName> =
        MethodStringName1<Theme, PackedStringArray, StringName>("get_type_variation_list")

    @JvmField
    public val addTypeName: MethodStringName1<Theme, Unit, StringName> =
        MethodStringName1<Theme, Unit, StringName>("add_type")

    @JvmField
    public val removeTypeName: MethodStringName1<Theme, Unit, StringName> =
        MethodStringName1<Theme, Unit, StringName>("remove_type")

    @JvmField
    public val renameTypeName: MethodStringName2<Theme, Unit, StringName, StringName> =
        MethodStringName2<Theme, Unit, StringName, StringName>("rename_type")

    @JvmField
    public val getTypeListName: MethodStringName0<Theme, PackedStringArray> =
        MethodStringName0<Theme, PackedStringArray>("get_type_list")

    @JvmField
    public val mergeWithName: MethodStringName1<Theme, Unit, Theme?> =
        MethodStringName1<Theme, Unit, Theme?>("merge_with")

    @JvmField
    public val clearName: MethodStringName0<Theme, Unit> = MethodStringName0<Theme, Unit>("clear")
  }

  public object MethodBindings {
    internal val setIconPtr: VoidPtr = TypeManager.getMethodBindPtr("Theme", "set_icon", 2188371082)

    internal val getIconPtr: VoidPtr = TypeManager.getMethodBindPtr("Theme", "get_icon", 934555193)

    internal val hasIconPtr: VoidPtr = TypeManager.getMethodBindPtr("Theme", "has_icon", 471820014)

    internal val renameIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "rename_icon", 642128662)

    internal val clearIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "clear_icon", 3740211285)

    internal val getIconListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_icon_list", 4291131558)

    internal val getIconTypeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_icon_type_list", 1139954409)

    internal val setStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_stylebox", 2075907568)

    internal val getStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_stylebox", 3405608165)

    internal val hasStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "has_stylebox", 471820014)

    internal val renameStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "rename_stylebox", 642128662)

    internal val clearStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "clear_stylebox", 3740211285)

    internal val getStyleboxListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_stylebox_list", 4291131558)

    internal val getStyleboxTypeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_stylebox_type_list", 1139954409)

    internal val setFontPtr: VoidPtr = TypeManager.getMethodBindPtr("Theme", "set_font", 177292320)

    internal val getFontPtr: VoidPtr = TypeManager.getMethodBindPtr("Theme", "get_font", 3445063586)

    internal val hasFontPtr: VoidPtr = TypeManager.getMethodBindPtr("Theme", "has_font", 471820014)

    internal val renameFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "rename_font", 642128662)

    internal val clearFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "clear_font", 3740211285)

    internal val getFontListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_font_list", 4291131558)

    internal val getFontTypeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_font_type_list", 1139954409)

    internal val setFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_font_size", 281601298)

    internal val getFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_font_size", 2419549490)

    internal val hasFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "has_font_size", 471820014)

    internal val renameFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "rename_font_size", 642128662)

    internal val clearFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "clear_font_size", 3740211285)

    internal val getFontSizeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_font_size_list", 4291131558)

    internal val getFontSizeTypeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_font_size_type_list", 1139954409)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_color", 4111215154)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_color", 2015923404)

    internal val hasColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "has_color", 471820014)

    internal val renameColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "rename_color", 642128662)

    internal val clearColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "clear_color", 3740211285)

    internal val getColorListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_color_list", 4291131558)

    internal val getColorTypeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_color_type_list", 1139954409)

    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_constant", 281601298)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_constant", 2419549490)

    internal val hasConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "has_constant", 471820014)

    internal val renameConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "rename_constant", 642128662)

    internal val clearConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "clear_constant", 3740211285)

    internal val getConstantListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_constant_list", 4291131558)

    internal val getConstantTypeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_constant_type_list", 1139954409)

    internal val setDefaultBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_default_base_scale", 373806689)

    internal val getDefaultBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_default_base_scale", 1740695150)

    internal val hasDefaultBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "has_default_base_scale", 36873697)

    internal val setDefaultFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_default_font", 1262170328)

    internal val getDefaultFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_default_font", 3229501585)

    internal val hasDefaultFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "has_default_font", 36873697)

    internal val setDefaultFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_default_font_size", 1286410249)

    internal val getDefaultFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_default_font_size", 3905245786)

    internal val hasDefaultFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "has_default_font_size", 36873697)

    internal val setThemeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_theme_item", 2492983623)

    internal val getThemeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_theme_item", 2191024021)

    internal val hasThemeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "has_theme_item", 1739311056)

    internal val renameThemeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "rename_theme_item", 3900867553)

    internal val clearThemeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "clear_theme_item", 2965505587)

    internal val getThemeItemListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_theme_item_list", 3726716710)

    internal val getThemeItemTypeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_theme_item_type_list", 1316004935)

    internal val setTypeVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "set_type_variation", 3740211285)

    internal val isTypeVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "is_type_variation", 471820014)

    internal val clearTypeVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "clear_type_variation", 3304788590)

    internal val getTypeVariationBasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_type_variation_base", 1965194235)

    internal val getTypeVariationListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_type_variation_list", 1761182771)

    internal val addTypePtr: VoidPtr = TypeManager.getMethodBindPtr("Theme", "add_type", 3304788590)

    internal val removeTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "remove_type", 3304788590)

    internal val renameTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "rename_type", 3740211285)

    internal val getTypeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "get_type_list", 1139954409)

    internal val mergeWithPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Theme", "merge_with", 2326690814)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("Theme", "clear", 3218959716)
  }
}
