// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
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
import godot.readReturnValue_ANY
import godot.readReturnValue_BOOL
import godot.readReturnValue_COLOR
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_LONG_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_LONG_STRING_NAME_STRING_NAME_ANY
import godot.writeMethodArguments_LONG_STRING_NAME_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_COLOR
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_LONG
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_OBJECT
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME
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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_OBJECT(ptr, objectID.id, name, themeType, texture)
    TransferContext.callPtrMethod(MethodBindings.setIconPtr, 0)
  }

  /**
   * Returns the icon property defined by [name] and [themeType], if it exists.
   *
   * Returns the engine fallback icon value if the property doesn't exist (see
   * [ThemeDB.fallbackIcon]). Use [hasIcon] to check for existence.
   */
  public final fun getIcon(name: StringName, themeType: StringName): Texture2D? {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.getIconPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  /**
   * Returns `true` if the icon property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setIcon] to define it.
   */
  public final fun hasIcon(name: StringName, themeType: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.hasIconPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, oldName, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.renameIconPtr, 0)
  }

  /**
   * Removes the icon property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasIcon] to check for existence.
   */
  public final fun clearIcon(name: StringName, themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.clearIconPtr, 0)
  }

  /**
   * Returns a list of names for icon properties defined with [themeType]. Use [getIconTypeList] to
   * get a list of possible theme type names.
   */
  public final fun getIconList(themeType: String): PackedStringArray {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, themeType)
    TransferContext.callMethod(MethodBindings.getIconListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a list of all unique theme type names for icon properties. Use [getTypeList] to get a
   * list of all unique theme types.
   */
  public final fun getIconTypeList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIconTypeListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Creates or changes the value of the [StyleBox] property defined by [name] and [themeType]. Use
   * [clearStylebox] to remove the property.
   */
  public final fun setStylebox(
    name: StringName,
    themeType: StringName,
    texture: StyleBox?,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_OBJECT(ptr, objectID.id, name, themeType, texture)
    TransferContext.callPtrMethod(MethodBindings.setStyleboxPtr, 0)
  }

  /**
   * Returns the [StyleBox] property defined by [name] and [themeType], if it exists.
   *
   * Returns the engine fallback stylebox value if the property doesn't exist (see
   * [ThemeDB.fallbackStylebox]). Use [hasStylebox] to check for existence.
   */
  public final fun getStylebox(name: StringName, themeType: StringName): StyleBox? {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.getStyleboxPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as StyleBox?)
  }

  /**
   * Returns `true` if the [StyleBox] property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setStylebox] to define it.
   */
  public final fun hasStylebox(name: StringName, themeType: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.hasStyleboxPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, oldName, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.renameStyleboxPtr, 0)
  }

  /**
   * Removes the [StyleBox] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasStylebox] to check for existence.
   */
  public final fun clearStylebox(name: StringName, themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.clearStyleboxPtr, 0)
  }

  /**
   * Returns a list of names for [StyleBox] properties defined with [themeType]. Use
   * [getStyleboxTypeList] to get a list of possible theme type names.
   */
  public final fun getStyleboxList(themeType: String): PackedStringArray {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, themeType)
    TransferContext.callMethod(MethodBindings.getStyleboxListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a list of all unique theme type names for [StyleBox] properties. Use [getTypeList] to
   * get a list of all unique theme types.
   */
  public final fun getStyleboxTypeList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStyleboxTypeListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Creates or changes the value of the [Font] property defined by [name] and [themeType]. Use
   * [clearFont] to remove the property.
   */
  public final fun setFont(
    name: StringName,
    themeType: StringName,
    font: Font?,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_OBJECT(ptr, objectID.id, name, themeType, font)
    TransferContext.callPtrMethod(MethodBindings.setFontPtr, 0)
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
  public final fun getFont(name: StringName, themeType: StringName): Font? {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.getFontPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Font?)
  }

  /**
   * Returns `true` if the [Font] property defined by [name] and [themeType] exists, or if the
   * default theme font is set up (see [hasDefaultFont]).
   *
   * Returns `false` if neither exist. Use [setFont] to define the property.
   */
  public final fun hasFont(name: StringName, themeType: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.hasFontPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, oldName, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.renameFontPtr, 0)
  }

  /**
   * Removes the [Font] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasFont] to check for existence.
   */
  public final fun clearFont(name: StringName, themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.clearFontPtr, 0)
  }

  /**
   * Returns a list of names for [Font] properties defined with [themeType]. Use [getFontTypeList]
   * to get a list of possible theme type names.
   */
  public final fun getFontList(themeType: String): PackedStringArray {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, themeType)
    TransferContext.callMethod(MethodBindings.getFontListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a list of all unique theme type names for [Font] properties. Use [getTypeList] to get a
   * list of all unique theme types.
   */
  public final fun getFontTypeList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFontTypeListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Creates or changes the value of the font size property defined by [name] and [themeType]. Use
   * [clearFontSize] to remove the property.
   */
  public final fun setFontSize(
    name: StringName,
    themeType: StringName,
    fontSize: Int,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG(ptr, objectID.id, name, themeType, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.setFontSizePtr, 0)
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
  public final fun getFontSize(name: StringName, themeType: StringName): Int {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.getFontSizePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the font size property defined by [name] and [themeType] exists, or if the
   * default theme font size is set up (see [hasDefaultFontSize]).
   *
   * Returns `false` if neither exist. Use [setFontSize] to define the property.
   */
  public final fun hasFontSize(name: StringName, themeType: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.hasFontSizePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, oldName, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.renameFontSizePtr, 0)
  }

  /**
   * Removes the font size property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasFontSize] to check for existence.
   */
  public final fun clearFontSize(name: StringName, themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.clearFontSizePtr, 0)
  }

  /**
   * Returns a list of names for font size properties defined with [themeType]. Use
   * [getFontSizeTypeList] to get a list of possible theme type names.
   */
  public final fun getFontSizeList(themeType: String): PackedStringArray {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, themeType)
    TransferContext.callMethod(MethodBindings.getFontSizeListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a list of all unique theme type names for font size properties. Use [getTypeList] to
   * get a list of all unique theme types.
   */
  public final fun getFontSizeTypeList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFontSizeTypeListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Creates or changes the value of the [Color] property defined by [name] and [themeType]. Use
   * [clearColor] to remove the property.
   */
  public final fun setColor(
    name: StringName,
    themeType: StringName,
    color: Color,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_COLOR(ptr, objectID.id, name, themeType, color)
    TransferContext.callPtrMethod(MethodBindings.setColorPtr, 0)
  }

  /**
   * Returns the [Color] property defined by [name] and [themeType], if it exists.
   *
   * Returns the default color value if the property doesn't exist. Use [hasColor] to check for
   * existence.
   */
  public final fun getColor(name: StringName, themeType: StringName): Color {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.getColorPtr, 20)
    return TransferContext.readReturnValue_COLOR()
  }

  /**
   * Returns `true` if the [Color] property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setColor] to define it.
   */
  public final fun hasColor(name: StringName, themeType: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.hasColorPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, oldName, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.renameColorPtr, 0)
  }

  /**
   * Removes the [Color] property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasColor] to check for existence.
   */
  public final fun clearColor(name: StringName, themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.clearColorPtr, 0)
  }

  /**
   * Returns a list of names for [Color] properties defined with [themeType]. Use [getColorTypeList]
   * to get a list of possible theme type names.
   */
  public final fun getColorList(themeType: String): PackedStringArray {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, themeType)
    TransferContext.callMethod(MethodBindings.getColorListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a list of all unique theme type names for [Color] properties. Use [getTypeList] to get
   * a list of all unique theme types.
   */
  public final fun getColorTypeList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColorTypeListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Creates or changes the value of the constant property defined by [name] and [themeType]. Use
   * [clearConstant] to remove the property.
   */
  public final fun setConstant(
    name: StringName,
    themeType: StringName,
    constant: Int,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG(ptr, objectID.id, name, themeType, constant.toLong())
    TransferContext.callPtrMethod(MethodBindings.setConstantPtr, 0)
  }

  /**
   * Returns the constant property defined by [name] and [themeType], if it exists.
   *
   * Returns `0` if the property doesn't exist. Use [hasConstant] to check for existence.
   */
  public final fun getConstant(name: StringName, themeType: StringName): Int {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.getConstantPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the constant property defined by [name] and [themeType] exists.
   *
   * Returns `false` if it doesn't exist. Use [setConstant] to define it.
   */
  public final fun hasConstant(name: StringName, themeType: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.hasConstantPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, oldName, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.renameConstantPtr, 0)
  }

  /**
   * Removes the constant property defined by [name] and [themeType], if it exists.
   *
   * Fails if it doesn't exist. Use [hasConstant] to check for existence.
   */
  public final fun clearConstant(name: StringName, themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.clearConstantPtr, 0)
  }

  /**
   * Returns a list of names for constant properties defined with [themeType]. Use
   * [getConstantTypeList] to get a list of possible theme type names.
   */
  public final fun getConstantList(themeType: String): PackedStringArray {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, themeType)
    TransferContext.callMethod(MethodBindings.getConstantListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a list of all unique theme type names for constant properties. Use [getTypeList] to get
   * a list of all unique theme types.
   */
  public final fun getConstantTypeList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getConstantTypeListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  public final fun setDefaultBaseScale(baseScale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, baseScale.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setDefaultBaseScalePtr, 0)
  }

  public final fun getDefaultBaseScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDefaultBaseScalePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns `true` if [defaultBaseScale] has a valid value.
   *
   * Returns `false` if it doesn't. The value must be greater than `0.0` to be considered valid.
   */
  public final fun hasDefaultBaseScale(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasDefaultBaseScalePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDefaultFont(font: Font?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, font)
    TransferContext.callPtrMethod(MethodBindings.setDefaultFontPtr, 0)
  }

  public final fun getDefaultFont(): Font? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDefaultFontPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Font?)
  }

  /**
   * Returns `true` if [defaultFont] has a valid value.
   *
   * Returns `false` if it doesn't.
   */
  public final fun hasDefaultFont(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasDefaultFontPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDefaultFontSize(fontSize: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.setDefaultFontSizePtr, 0)
  }

  public final fun getDefaultFontSize(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDefaultFontSizePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if [defaultFontSize] has a valid value.
   *
   * Returns `false` if it doesn't. The value must be greater than `0` to be considered valid.
   */
  public final fun hasDefaultFontSize(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasDefaultFontSizePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

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
    TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME_ANY(ptr, objectID.id, dataType.value, name, themeType, value)
    TransferContext.callMethod(MethodBindings.setThemeItemPtr)
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
  ): Any? {
    TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME(ptr, objectID.id, dataType.value, name, themeType)
    TransferContext.callMethod(MethodBindings.getThemeItemPtr)
    return TransferContext.readReturnValue_ANY()
  }

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
  ): Boolean {
    TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME(ptr, objectID.id, dataType.value, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.hasThemeItemPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

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
    TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, dataType.value, oldName, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.renameThemeItemPtr, 0)
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
    TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME(ptr, objectID.id, dataType.value, name, themeType)
    TransferContext.callPtrMethod(MethodBindings.clearThemeItemPtr, 0)
  }

  /**
   * Returns a list of names for properties of [dataType] defined with [themeType]. Use
   * [getThemeItemTypeList] to get a list of possible theme type names.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun getThemeItemList(dataType: DataType, themeType: String): PackedStringArray {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, dataType.value, themeType)
    TransferContext.callMethod(MethodBindings.getThemeItemListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a list of all unique theme type names for [dataType] properties. Use [getTypeList] to
   * get a list of all unique theme types.
   *
   * **Note:** This method is analogous to calling the corresponding data type specific method, but
   * can be used for more generalized logic.
   */
  public final fun getThemeItemTypeList(dataType: DataType): PackedStringArray {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, dataType.value)
    TransferContext.callPtrMethod(MethodBindings.getThemeItemTypeListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, themeType, baseType)
    TransferContext.callPtrMethod(MethodBindings.setTypeVariationPtr, 0)
  }

  /**
   * Returns `true` if [themeType] is marked as a variation of [baseType].
   */
  public final fun isTypeVariation(themeType: StringName, baseType: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, themeType, baseType)
    TransferContext.callPtrMethod(MethodBindings.isTypeVariationPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Unmarks [themeType] as being a variation of another theme type. See [setTypeVariation].
   */
  public final fun clearTypeVariation(themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, themeType)
    TransferContext.callPtrMethod(MethodBindings.clearTypeVariationPtr, 0)
  }

  /**
   * Returns the name of the base theme type if [themeType] is a valid variation type. Returns an
   * empty string otherwise.
   */
  public final fun getTypeVariationBase(themeType: StringName): StringName {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, themeType)
    TransferContext.callPtrMethod(MethodBindings.getTypeVariationBasePtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns a list of all type variations for the given [baseType].
   */
  public final fun getTypeVariationList(baseType: StringName): PackedStringArray {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, baseType)
    TransferContext.callPtrMethod(MethodBindings.getTypeVariationListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Adds an empty theme type for every valid data type.
   *
   * **Note:** Empty types are not saved with the theme. This method only exists to perform
   * in-memory changes to the resource. Use available `set_*` methods to add theme items.
   */
  public final fun addType(themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, themeType)
    TransferContext.callPtrMethod(MethodBindings.addTypePtr, 0)
  }

  /**
   * Removes the theme type, gracefully discarding defined theme items. If the type is a variation,
   * this information is also erased. If the type is a base for type variations, those variations lose
   * their base.
   */
  public final fun removeType(themeType: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, themeType)
    TransferContext.callPtrMethod(MethodBindings.removeTypePtr, 0)
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
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, oldThemeType, themeType)
    TransferContext.callPtrMethod(MethodBindings.renameTypePtr, 0)
  }

  /**
   * Returns a list of all unique theme type names. Use the appropriate `get_*_type_list` method to
   * get a list of unique theme types for a single data type.
   */
  public final fun getTypeList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTypeListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Adds missing and overrides existing definitions with values from the [other] theme resource.
   *
   * **Note:** This modifies the current theme. If you want to merge two themes together without
   * modifying either one, create a new empty theme and merge the other two into it one after another.
   */
  public final fun mergeWith(other: Theme?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, other)
    TransferContext.callPtrMethod(MethodBindings.mergeWithPtr, 0)
  }

  /**
   * Removes all the theme properties defined on the theme resource.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearPtr, 0)
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
