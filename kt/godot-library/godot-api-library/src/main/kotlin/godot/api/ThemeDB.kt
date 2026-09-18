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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * This singleton provides access to static information about [Theme] resources used by the engine
 * and by your projects. You can fetch the default engine theme, as well as your project configured
 * theme.
 *
 * [ThemeDB] also contains fallback values for theme properties.
 */
@GodotBaseType
public object ThemeDB : Object() {
  @JvmField
  public val getDefaultThemeName: MethodStringName0<ThemeDB, Theme?> =
      MethodStringName0<ThemeDB, Theme?>("get_default_theme")

  @JvmField
  public val getProjectThemeName: MethodStringName0<ThemeDB, Theme?> =
      MethodStringName0<ThemeDB, Theme?>("get_project_theme")

  @JvmField
  public val setFallbackBaseScaleName: MethodStringName1<ThemeDB, Unit, Float> =
      MethodStringName1<ThemeDB, Unit, Float>("set_fallback_base_scale")

  @JvmField
  public val getFallbackBaseScaleName: MethodStringName0<ThemeDB, Float> =
      MethodStringName0<ThemeDB, Float>("get_fallback_base_scale")

  @JvmField
  public val setFallbackFontName: MethodStringName1<ThemeDB, Unit, Font?> =
      MethodStringName1<ThemeDB, Unit, Font?>("set_fallback_font")

  @JvmField
  public val getFallbackFontName: MethodStringName0<ThemeDB, Font?> =
      MethodStringName0<ThemeDB, Font?>("get_fallback_font")

  @JvmField
  public val setFallbackFontSizeName: MethodStringName1<ThemeDB, Unit, Int> =
      MethodStringName1<ThemeDB, Unit, Int>("set_fallback_font_size")

  @JvmField
  public val getFallbackFontSizeName: MethodStringName0<ThemeDB, Int> =
      MethodStringName0<ThemeDB, Int>("get_fallback_font_size")

  @JvmField
  public val setFallbackIconName: MethodStringName1<ThemeDB, Unit, Texture2D?> =
      MethodStringName1<ThemeDB, Unit, Texture2D?>("set_fallback_icon")

  @JvmField
  public val getFallbackIconName: MethodStringName0<ThemeDB, Texture2D?> =
      MethodStringName0<ThemeDB, Texture2D?>("get_fallback_icon")

  @JvmField
  public val setFallbackStyleboxName: MethodStringName1<ThemeDB, Unit, StyleBox?> =
      MethodStringName1<ThemeDB, Unit, StyleBox?>("set_fallback_stylebox")

  @JvmField
  public val getFallbackStyleboxName: MethodStringName0<ThemeDB, StyleBox?> =
      MethodStringName0<ThemeDB, StyleBox?>("get_fallback_stylebox")

  /**
   * Emitted when one of the fallback values had been changed. Use it to refresh the look of
   * controls that may rely on the fallback theme items.
   */
  @JvmStatic
  public val fallbackChanged: Signal0 by Signal0

  /**
   * The fallback base scale factor of every [Control] node and [Theme] resource. Used when no other
   * value is available to the control.
   *
   * See also [Theme.defaultBaseScale].
   */
  @JvmStatic
  public final inline var fallbackBaseScale: Float
    @JvmName("fallbackBaseScaleProperty")
    get() = getFallbackBaseScale()
    @JvmName("fallbackBaseScaleProperty")
    set(`value`) {
      setFallbackBaseScale(value)
    }

  /**
   * The fallback font of every [Control] node and [Theme] resource. Used when no other value is
   * available to the control.
   *
   * See also [Theme.defaultFont].
   */
  @JvmStatic
  public final inline var fallbackFont: Font?
    @JvmName("fallbackFontProperty")
    get() = getFallbackFont()
    @JvmName("fallbackFontProperty")
    set(`value`) {
      setFallbackFont(value)
    }

  /**
   * The fallback font size of every [Control] node and [Theme] resource. Used when no other value
   * is available to the control.
   *
   * See also [Theme.defaultFontSize].
   */
  @JvmStatic
  public final inline var fallbackFontSize: Int
    @JvmName("fallbackFontSizeProperty")
    get() = getFallbackFontSize()
    @JvmName("fallbackFontSizeProperty")
    set(`value`) {
      setFallbackFontSize(value)
    }

  /**
   * The fallback icon of every [Control] node and [Theme] resource. Used when no other value is
   * available to the control.
   */
  @JvmStatic
  public final inline var fallbackIcon: Texture2D?
    @JvmName("fallbackIconProperty")
    get() = getFallbackIcon()
    @JvmName("fallbackIconProperty")
    set(`value`) {
      setFallbackIcon(value)
    }

  /**
   * The fallback stylebox of every [Control] node and [Theme] resource. Used when no other value is
   * available to the control.
   */
  @JvmStatic
  public final inline var fallbackStylebox: StyleBox?
    @JvmName("fallbackStyleboxProperty")
    get() = getFallbackStylebox()
    @JvmName("fallbackStyleboxProperty")
    set(`value`) {
      setFallbackStylebox(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(34)
  }

  /**
   * Returns a reference to the default engine [Theme]. This theme resource is responsible for the
   * out-of-the-box look of [Control] nodes and cannot be overridden.
   */
  @JvmStatic
  public final fun getDefaultTheme(): Theme? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDefaultThemePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Theme?)
  }

  /**
   * Returns a reference to the custom project [Theme]. This theme resources allows to override the
   * default engine theme for every control node in the project.
   *
   * To set the project theme, see [ProjectSettings.gui/theme/custom].
   */
  @JvmStatic
  public final fun getProjectTheme(): Theme? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getProjectThemePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Theme?)
  }

  @JvmStatic
  public final fun setFallbackBaseScale(baseScale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, baseScale.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setFallbackBaseScalePtr, 0)
  }

  @JvmStatic
  public final fun getFallbackBaseScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFallbackBaseScalePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  @JvmStatic
  public final fun setFallbackFont(font: Font?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, font)
    TransferContext.callPtrMethod(MethodBindings.setFallbackFontPtr, 0)
  }

  @JvmStatic
  public final fun getFallbackFont(): Font? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFallbackFontPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Font?)
  }

  @JvmStatic
  public final fun setFallbackFontSize(fontSize: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.setFallbackFontSizePtr, 0)
  }

  @JvmStatic
  public final fun getFallbackFontSize(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFallbackFontSizePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  @JvmStatic
  public final fun setFallbackIcon(icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, icon)
    TransferContext.callPtrMethod(MethodBindings.setFallbackIconPtr, 0)
  }

  @JvmStatic
  public final fun getFallbackIcon(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFallbackIconPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  @JvmStatic
  public final fun setFallbackStylebox(stylebox: StyleBox?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, stylebox)
    TransferContext.callPtrMethod(MethodBindings.setFallbackStyleboxPtr, 0)
  }

  @JvmStatic
  public final fun getFallbackStylebox(): StyleBox? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFallbackStyleboxPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as StyleBox?)
  }

  public object MethodBindings {
    internal val getDefaultThemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "get_default_theme", 754276358)

    internal val getProjectThemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "get_project_theme", 754276358)

    internal val setFallbackBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "set_fallback_base_scale", 373806689)

    internal val getFallbackBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "get_fallback_base_scale", 191475506)

    internal val setFallbackFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "set_fallback_font", 1262170328)

    internal val getFallbackFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "get_fallback_font", 3656929885)

    internal val setFallbackFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "set_fallback_font_size", 1286410249)

    internal val getFallbackFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "get_fallback_font_size", 2455072627)

    internal val setFallbackIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "set_fallback_icon", 4051416890)

    internal val getFallbackIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "get_fallback_icon", 255860311)

    internal val setFallbackStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "set_fallback_stylebox", 2797200388)

    internal val getFallbackStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ThemeDB", "get_fallback_stylebox", 496040854)
  }
}
