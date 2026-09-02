// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedStringArray
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_STRING_ARRAY
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [SystemFont] loads a font from a system font with the first matching name from [fontNames].
 *
 * It will attempt to match font style, but it's not guaranteed.
 *
 * The returned font might be part of a font collection or be a variable font with OpenType
 * "weight", "width" and/or "italic" features set.
 *
 * You can create [FontVariation] of the system font for precise control over its features.
 *
 * **Note:** This class is implemented on iOS, Linux, macOS and Windows, on other platforms it will
 * fallback to default theme font.
 */
@GodotBaseType
public open class SystemFont : Font() {
  /**
   * Array of font family names to search, first matching font found is used.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var fontNames: PackedStringArray
    @JvmName("fontNamesProperty")
    get() = getFontNames()
    @JvmName("fontNamesProperty")
    set(`value`) {
      setFontNames(value)
    }

  /**
   * If set to `true`, italic or oblique font is preferred.
   */
  public final inline var fontItalic: Boolean
    @JvmName("fontItalicProperty")
    get() = getFontItalic()
    @JvmName("fontItalicProperty")
    set(`value`) {
      setFontItalic(value)
    }

  /**
   * Preferred weight (boldness) of the font. A value in the `100...999` range, normal font weight
   * is `400`, bold font weight is `700`.
   */
  public final inline var fontWeight: Int
    @JvmName("fontWeightProperty")
    get() = getFontWeight()
    @JvmName("fontWeightProperty")
    set(`value`) {
      setFontWeight(value)
    }

  /**
   * Preferred font stretch amount, compared to a normal width. A percentage value between `50&#37;`
   * and `200&#37;`.
   */
  public final inline var fontStretch: Int
    @JvmName("fontStretchProperty")
    get() = getFontStretch()
    @JvmName("fontStretchProperty")
    set(`value`) {
      setFontStretch(value)
    }

  /**
   * Font anti-aliasing mode.
   */
  public final inline var antialiasing: TextServer.FontAntialiasing
    @JvmName("antialiasingProperty")
    get() = getAntialiasing()
    @JvmName("antialiasingProperty")
    set(`value`) {
      setAntialiasing(value)
    }

  /**
   * If set to `true`, generate mipmaps for the font textures.
   */
  public final inline var generateMipmaps: Boolean
    @JvmName("generateMipmapsProperty")
    get() = getGenerateMipmaps()
    @JvmName("generateMipmapsProperty")
    set(`value`) {
      setGenerateMipmaps(value)
    }

  /**
   * If set to `true`, embedded font bitmap loading is disabled (bitmap-only and color fonts ignore
   * this property).
   */
  public final inline var disableEmbeddedBitmaps: Boolean
    @JvmName("disableEmbeddedBitmapsProperty")
    get() = getDisableEmbeddedBitmaps()
    @JvmName("disableEmbeddedBitmapsProperty")
    set(`value`) {
      setDisableEmbeddedBitmaps(value)
    }

  /**
   * If set to `true`, system fonts can be automatically used as fallbacks.
   */
  public final inline var allowSystemFallback: Boolean
    @JvmName("allowSystemFallbackProperty")
    get() = isAllowSystemFallback()
    @JvmName("allowSystemFallbackProperty")
    set(`value`) {
      setAllowSystemFallback(value)
    }

  /**
   * If set to `true`, auto-hinting is supported and preferred over font built-in hinting.
   */
  public final inline var forceAutohinter: Boolean
    @JvmName("forceAutohinterProperty")
    get() = isForceAutohinter()
    @JvmName("forceAutohinterProperty")
    set(`value`) {
      setForceAutohinter(value)
    }

  /**
   * If set to `true`, color modulation is applied when drawing colored glyphs, otherwise it's
   * applied to the monochrome glyphs only.
   */
  public final inline var modulateColorGlyphs: Boolean
    @JvmName("modulateColorGlyphsProperty")
    get() = isModulateColorGlyphs()
    @JvmName("modulateColorGlyphsProperty")
    set(`value`) {
      setModulateColorGlyphs(value)
    }

  /**
   * Font hinting mode.
   */
  public final inline var hinting: TextServer.Hinting
    @JvmName("hintingProperty")
    get() = getHinting()
    @JvmName("hintingProperty")
    set(`value`) {
      setHinting(value)
    }

  /**
   * Font glyph subpixel positioning mode. Subpixel positioning provides shaper text and better
   * kerning for smaller font sizes, at the cost of memory usage and font rasterization speed. Use
   * [TextServer.SUBPIXEL_POSITIONING_AUTO] to automatically enable it based on the font size.
   */
  public final inline var subpixelPositioning: TextServer.SubpixelPositioning
    @JvmName("subpixelPositioningProperty")
    get() = getSubpixelPositioning()
    @JvmName("subpixelPositioningProperty")
    set(`value`) {
      setSubpixelPositioning(value)
    }

  /**
   * If set to `true`, when aligning glyphs to the pixel boundaries rounding remainders are
   * accumulated to ensure more uniform glyph distribution. This setting has no effect if subpixel
   * positioning is enabled.
   */
  public final inline var keepRoundingRemainders: Boolean
    @JvmName("keepRoundingRemaindersProperty")
    get() = getKeepRoundingRemainders()
    @JvmName("keepRoundingRemaindersProperty")
    set(`value`) {
      setKeepRoundingRemainders(value)
    }

  /**
   * If set to `true`, glyphs of all sizes are rendered using single multichannel signed distance
   * field generated from the dynamic font vector data.
   */
  public final inline var multichannelSignedDistanceField: Boolean
    @JvmName("multichannelSignedDistanceFieldProperty")
    get() = isMultichannelSignedDistanceField()
    @JvmName("multichannelSignedDistanceFieldProperty")
    set(`value`) {
      setMultichannelSignedDistanceField(value)
    }

  /**
   * The width of the range around the shape between the minimum and maximum representable signed
   * distance. If using font outlines, [msdfPixelRange] must be set to at least *twice* the size of the
   * largest font outline. The default [msdfPixelRange] value of `16` allows outline sizes up to `8` to
   * look correct.
   */
  public final inline var msdfPixelRange: Int
    @JvmName("msdfPixelRangeProperty")
    get() = getMsdfPixelRange()
    @JvmName("msdfPixelRangeProperty")
    set(`value`) {
      setMsdfPixelRange(value)
    }

  /**
   * Source font size used to generate MSDF textures. Higher values allow for more precision, but
   * are slower to render and require more memory. Only increase this value if you notice a visible
   * lack of precision in glyph rendering.
   */
  public final inline var msdfSize: Int
    @JvmName("msdfSizeProperty")
    get() = getMsdfSize()
    @JvmName("msdfSizeProperty")
    set(`value`) {
      setMsdfSize(value)
    }

  /**
   * If set to a positive value, overrides the oversampling factor of the viewport this font is used
   * in. See [Viewport.oversampling]. This value doesn't override the [code
   * skip-lint]oversampling[/code] parameter of [code skip-lint]draw_*[/code] methods.
   */
  public final inline var oversampling: Float
    @JvmName("oversamplingProperty")
    get() = getOversampling()
    @JvmName("oversamplingProperty")
    set(`value`) {
      setOversampling(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(725, scriptPtr)
  }

  /**
   * This is a helper function for [fontNames] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = systemfont.fontNames
   * //Your changes
   * systemfont.fontNames = myCoreType
   * ``````
   *
   * Array of font family names to search, first matching font found is used.
   */
  @CoreTypeHelper
  public final fun fontNamesMutate(block: PackedStringArray.() -> Unit): PackedStringArray =
      fontNames.apply {
     block(this)
     fontNames = this
  }

  /**
   * This is a helper function for [fontNames] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Array of font family names to search, first matching font found is used.
   */
  @CoreTypeHelper
  public final fun fontNamesMutateEach(block: (index: Int, `value`: String) -> Unit):
      PackedStringArray = fontNames.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     fontNames = this
  }

  public final fun setAntialiasing(antialiasing: TextServer.FontAntialiasing): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to antialiasing.value)
    TransferContext.callMethod(MethodBindings.setAntialiasingPtr)
  }

  public final fun getAntialiasing(): TextServer.FontAntialiasing {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAntialiasingPtr)
    return TextServer.FontAntialiasing.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDisableEmbeddedBitmaps(disableEmbeddedBitmaps: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disableEmbeddedBitmaps)
    TransferContext.callMethod(MethodBindings.setDisableEmbeddedBitmapsPtr)
  }

  public final fun getDisableEmbeddedBitmaps(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDisableEmbeddedBitmapsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setGenerateMipmaps(generateMipmaps: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to generateMipmaps)
    TransferContext.callMethod(MethodBindings.setGenerateMipmapsPtr)
  }

  public final fun getGenerateMipmaps(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGenerateMipmapsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAllowSystemFallback(allowSystemFallback: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to allowSystemFallback)
    TransferContext.callMethod(MethodBindings.setAllowSystemFallbackPtr)
  }

  public final fun isAllowSystemFallback(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAllowSystemFallbackPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setForceAutohinter(forceAutohinter: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to forceAutohinter)
    TransferContext.callMethod(MethodBindings.setForceAutohinterPtr)
  }

  public final fun isForceAutohinter(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isForceAutohinterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setModulateColorGlyphs(modulate: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to modulate)
    TransferContext.callMethod(MethodBindings.setModulateColorGlyphsPtr)
  }

  public final fun isModulateColorGlyphs(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isModulateColorGlyphsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHinting(hinting: TextServer.Hinting): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to hinting.value)
    TransferContext.callMethod(MethodBindings.setHintingPtr)
  }

  public final fun getHinting(): TextServer.Hinting {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHintingPtr)
    return TextServer.Hinting.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSubpixelPositioning(subpixelPositioning: TextServer.SubpixelPositioning):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to subpixelPositioning.value)
    TransferContext.callMethod(MethodBindings.setSubpixelPositioningPtr)
  }

  public final fun getSubpixelPositioning(): TextServer.SubpixelPositioning {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubpixelPositioningPtr)
    return TextServer.SubpixelPositioning.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setKeepRoundingRemainders(keepRoundingRemainders: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to keepRoundingRemainders)
    TransferContext.callMethod(MethodBindings.setKeepRoundingRemaindersPtr)
  }

  public final fun getKeepRoundingRemainders(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getKeepRoundingRemaindersPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMultichannelSignedDistanceField(msdf: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to msdf)
    TransferContext.callMethod(MethodBindings.setMultichannelSignedDistanceFieldPtr)
  }

  public final fun isMultichannelSignedDistanceField(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMultichannelSignedDistanceFieldPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMsdfPixelRange(msdfPixelRange: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to msdfPixelRange.toLong())
    TransferContext.callMethod(MethodBindings.setMsdfPixelRangePtr)
  }

  public final fun getMsdfPixelRange(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMsdfPixelRangePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMsdfSize(msdfSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to msdfSize.toLong())
    TransferContext.callMethod(MethodBindings.setMsdfSizePtr)
  }

  public final fun getMsdfSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMsdfSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setOversampling(oversampling: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.setOversamplingPtr)
  }

  public final fun getOversampling(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOversamplingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getFontNames(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontNamesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  public final fun setFontNames(names: PackedStringArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_STRING_ARRAY to names)
    TransferContext.callMethod(MethodBindings.setFontNamesPtr)
  }

  public final fun getFontItalic(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontItalicPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFontItalic(italic: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to italic)
    TransferContext.callMethod(MethodBindings.setFontItalicPtr)
  }

  public final fun setFontWeight(weight: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to weight.toLong())
    TransferContext.callMethod(MethodBindings.setFontWeightPtr)
  }

  public final fun setFontStretch(stretch: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stretch.toLong())
    TransferContext.callMethod(MethodBindings.setFontStretchPtr)
  }

  public companion object {
    @JvmField
    public val setAntialiasingName: MethodStringName1<SystemFont, Unit, TextServer.FontAntialiasing>
        = MethodStringName1<SystemFont, Unit, TextServer.FontAntialiasing>("set_antialiasing")

    @JvmField
    public val getAntialiasingName: MethodStringName0<SystemFont, TextServer.FontAntialiasing> =
        MethodStringName0<SystemFont, TextServer.FontAntialiasing>("get_antialiasing")

    @JvmField
    public val setDisableEmbeddedBitmapsName: MethodStringName1<SystemFont, Unit, Boolean> =
        MethodStringName1<SystemFont, Unit, Boolean>("set_disable_embedded_bitmaps")

    @JvmField
    public val getDisableEmbeddedBitmapsName: MethodStringName0<SystemFont, Boolean> =
        MethodStringName0<SystemFont, Boolean>("get_disable_embedded_bitmaps")

    @JvmField
    public val setGenerateMipmapsName: MethodStringName1<SystemFont, Unit, Boolean> =
        MethodStringName1<SystemFont, Unit, Boolean>("set_generate_mipmaps")

    @JvmField
    public val getGenerateMipmapsName: MethodStringName0<SystemFont, Boolean> =
        MethodStringName0<SystemFont, Boolean>("get_generate_mipmaps")

    @JvmField
    public val setAllowSystemFallbackName: MethodStringName1<SystemFont, Unit, Boolean> =
        MethodStringName1<SystemFont, Unit, Boolean>("set_allow_system_fallback")

    @JvmField
    public val isAllowSystemFallbackName: MethodStringName0<SystemFont, Boolean> =
        MethodStringName0<SystemFont, Boolean>("is_allow_system_fallback")

    @JvmField
    public val setForceAutohinterName: MethodStringName1<SystemFont, Unit, Boolean> =
        MethodStringName1<SystemFont, Unit, Boolean>("set_force_autohinter")

    @JvmField
    public val isForceAutohinterName: MethodStringName0<SystemFont, Boolean> =
        MethodStringName0<SystemFont, Boolean>("is_force_autohinter")

    @JvmField
    public val setModulateColorGlyphsName: MethodStringName1<SystemFont, Unit, Boolean> =
        MethodStringName1<SystemFont, Unit, Boolean>("set_modulate_color_glyphs")

    @JvmField
    public val isModulateColorGlyphsName: MethodStringName0<SystemFont, Boolean> =
        MethodStringName0<SystemFont, Boolean>("is_modulate_color_glyphs")

    @JvmField
    public val setHintingName: MethodStringName1<SystemFont, Unit, TextServer.Hinting> =
        MethodStringName1<SystemFont, Unit, TextServer.Hinting>("set_hinting")

    @JvmField
    public val getHintingName: MethodStringName0<SystemFont, TextServer.Hinting> =
        MethodStringName0<SystemFont, TextServer.Hinting>("get_hinting")

    @JvmField
    public val setSubpixelPositioningName:
        MethodStringName1<SystemFont, Unit, TextServer.SubpixelPositioning> =
        MethodStringName1<SystemFont, Unit, TextServer.SubpixelPositioning>("set_subpixel_positioning")

    @JvmField
    public val getSubpixelPositioningName:
        MethodStringName0<SystemFont, TextServer.SubpixelPositioning> =
        MethodStringName0<SystemFont, TextServer.SubpixelPositioning>("get_subpixel_positioning")

    @JvmField
    public val setKeepRoundingRemaindersName: MethodStringName1<SystemFont, Unit, Boolean> =
        MethodStringName1<SystemFont, Unit, Boolean>("set_keep_rounding_remainders")

    @JvmField
    public val getKeepRoundingRemaindersName: MethodStringName0<SystemFont, Boolean> =
        MethodStringName0<SystemFont, Boolean>("get_keep_rounding_remainders")

    @JvmField
    public val setMultichannelSignedDistanceFieldName: MethodStringName1<SystemFont, Unit, Boolean>
        = MethodStringName1<SystemFont, Unit, Boolean>("set_multichannel_signed_distance_field")

    @JvmField
    public val isMultichannelSignedDistanceFieldName: MethodStringName0<SystemFont, Boolean> =
        MethodStringName0<SystemFont, Boolean>("is_multichannel_signed_distance_field")

    @JvmField
    public val setMsdfPixelRangeName: MethodStringName1<SystemFont, Unit, Int> =
        MethodStringName1<SystemFont, Unit, Int>("set_msdf_pixel_range")

    @JvmField
    public val getMsdfPixelRangeName: MethodStringName0<SystemFont, Int> =
        MethodStringName0<SystemFont, Int>("get_msdf_pixel_range")

    @JvmField
    public val setMsdfSizeName: MethodStringName1<SystemFont, Unit, Int> =
        MethodStringName1<SystemFont, Unit, Int>("set_msdf_size")

    @JvmField
    public val getMsdfSizeName: MethodStringName0<SystemFont, Int> =
        MethodStringName0<SystemFont, Int>("get_msdf_size")

    @JvmField
    public val setOversamplingName: MethodStringName1<SystemFont, Unit, Float> =
        MethodStringName1<SystemFont, Unit, Float>("set_oversampling")

    @JvmField
    public val getOversamplingName: MethodStringName0<SystemFont, Float> =
        MethodStringName0<SystemFont, Float>("get_oversampling")

    @JvmField
    public val getFontNamesName: MethodStringName0<SystemFont, PackedStringArray> =
        MethodStringName0<SystemFont, PackedStringArray>("get_font_names")

    @JvmField
    public val setFontNamesName: MethodStringName1<SystemFont, Unit, PackedStringArray> =
        MethodStringName1<SystemFont, Unit, PackedStringArray>("set_font_names")

    @JvmField
    public val getFontItalicName: MethodStringName0<SystemFont, Boolean> =
        MethodStringName0<SystemFont, Boolean>("get_font_italic")

    @JvmField
    public val setFontItalicName: MethodStringName1<SystemFont, Unit, Boolean> =
        MethodStringName1<SystemFont, Unit, Boolean>("set_font_italic")

    @JvmField
    public val setFontWeightName: MethodStringName1<SystemFont, Unit, Int> =
        MethodStringName1<SystemFont, Unit, Int>("set_font_weight")

    @JvmField
    public val setFontStretchName: MethodStringName1<SystemFont, Unit, Int> =
        MethodStringName1<SystemFont, Unit, Int>("set_font_stretch")
  }

  public object MethodBindings {
    internal val setAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_antialiasing", 1669900)

    internal val getAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_antialiasing", 4262718649)

    internal val setDisableEmbeddedBitmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_disable_embedded_bitmaps", 2586408642)

    internal val getDisableEmbeddedBitmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_disable_embedded_bitmaps", 36873697)

    internal val setGenerateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_generate_mipmaps", 2586408642)

    internal val getGenerateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_generate_mipmaps", 36873697)

    internal val setAllowSystemFallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_allow_system_fallback", 2586408642)

    internal val isAllowSystemFallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "is_allow_system_fallback", 36873697)

    internal val setForceAutohinterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_force_autohinter", 2586408642)

    internal val isForceAutohinterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "is_force_autohinter", 36873697)

    internal val setModulateColorGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_modulate_color_glyphs", 2586408642)

    internal val isModulateColorGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "is_modulate_color_glyphs", 36873697)

    internal val setHintingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_hinting", 1827459492)

    internal val getHintingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_hinting", 3683214614)

    internal val setSubpixelPositioningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_subpixel_positioning", 4225742182)

    internal val getSubpixelPositioningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_subpixel_positioning", 1069238588)

    internal val setKeepRoundingRemaindersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_keep_rounding_remainders", 2586408642)

    internal val getKeepRoundingRemaindersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_keep_rounding_remainders", 36873697)

    internal val setMultichannelSignedDistanceFieldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_multichannel_signed_distance_field", 2586408642)

    internal val isMultichannelSignedDistanceFieldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "is_multichannel_signed_distance_field", 36873697)

    internal val setMsdfPixelRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_msdf_pixel_range", 1286410249)

    internal val getMsdfPixelRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_msdf_pixel_range", 3905245786)

    internal val setMsdfSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_msdf_size", 1286410249)

    internal val getMsdfSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_msdf_size", 3905245786)

    internal val setOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_oversampling", 373806689)

    internal val getOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_oversampling", 1740695150)

    internal val getFontNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_font_names", 1139954409)

    internal val setFontNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_font_names", 4015028928)

    internal val getFontItalicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "get_font_italic", 36873697)

    internal val setFontItalicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_font_italic", 2586408642)

    internal val setFontWeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_font_weight", 1286410249)

    internal val setFontStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SystemFont", "set_font_stretch", 1286410249)
  }
}
