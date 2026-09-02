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
import godot.core.Dictionary
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedByteArray
import godot.core.PackedInt32Array
import godot.core.PackedStringArray
import godot.core.Rect2
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2
import godot.core.Vector2i
import kotlin.Any
import kotlin.Boolean
import kotlin.Byte
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
 * [FontFile] contains a set of glyphs to represent Unicode characters imported from a font file, as
 * well as a cache of rasterized glyphs, and a set of fallback [Font]s to use.
 *
 * Use [FontVariation] to access specific OpenType variation of the font, create simulated bold /
 * slanted version, and draw lines of text.
 *
 * For more complex text processing, use [FontVariation] in conjunction with [TextLine] or
 * [TextParagraph].
 *
 * Supported font formats:
 *
 * - Dynamic font importer: TrueType (.ttf), TrueType collection (.ttc), OpenType (.otf), OpenType
 * collection (.otc), WOFF (.woff), WOFF2 (.woff2), Type 1 (.pfb, .pfm).
 *
 * - Bitmap font importer: AngelCode BMFont (.fnt, .font), text and binary (version 3) format
 * variants.
 *
 * - Monospace image font importer: All supported image formats.
 *
 * **Note:** A character is a symbol that represents an item (letter, digit etc.) in an abstract
 * way.
 *
 * **Note:** A glyph is a bitmap or a shape used to draw one or more characters in a
 * context-dependent manner. Glyph indices are bound to the specific font data source.
 *
 * **Note:** If none of the font data sources contain glyphs for a character used in a string, the
 * character in question will be replaced with a box displaying its hexadecimal code.
 *
 * ```gdscript
 * //gdscript
 * var f = load("res://BarlowCondensed-Bold.ttf")
 * $Label.add_theme_font_override("font", f)
 * $Label.add_theme_font_size_override("font_size", 64)
 * ```
 *
 * ```csharp
 * //csharp
 * var f = ResourceLoader.Load<FontFile>("res://BarlowCondensed-Bold.ttf");
 * GetNode("Label").AddThemeFontOverride("font", f);
 * GetNode("Label").AddThemeFontSizeOverride("font_size", 64);
 * ```
 */
@GodotBaseType
public open class FontFile : Font() {
  /**
   * Contents of the dynamic font source file.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var `data`: PackedByteArray
    @JvmName("dataProperty")
    get() = getData()
    @JvmName("dataProperty")
    set(`value`) {
      setData(value)
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
   * Font family name.
   */
  public final inline var fontName: String
    @JvmName("fontNameProperty")
    get() = getFontName()
    @JvmName("fontNameProperty")
    set(`value`) {
      setFontName(value)
    }

  /**
   * Font style name.
   */
  public final inline var styleName: String
    @JvmName("styleNameProperty")
    get() = getFontStyleName()
    @JvmName("styleNameProperty")
    set(`value`) {
      setFontStyleName(value)
    }

  /**
   * Font style flags.
   */
  public final inline var fontStyle: TextServer.FontStyle
    @JvmName("fontStyleProperty")
    get() = getFontStyle()
    @JvmName("fontStyleProperty")
    set(`value`) {
      setFontStyle(value)
    }

  /**
   * Weight (boldness) of the font. A value in the `100...999` range, normal font weight is `400`,
   * bold font weight is `700`.
   */
  public final inline var fontWeight: Int
    @JvmName("fontWeightProperty")
    get() = getFontWeight()
    @JvmName("fontWeightProperty")
    set(`value`) {
      setFontWeight(value)
    }

  /**
   * Font stretch amount, compared to a normal width. A percentage value between `50&#37;` and
   * `200&#37;`.
   */
  public final inline var fontStretch: Int
    @JvmName("fontStretchProperty")
    get() = getFontStretch()
    @JvmName("fontStretchProperty")
    set(`value`) {
      setFontStretch(value)
    }

  /**
   * Font glyph subpixel positioning mode. Subpixel positioning provides shaper text and better
   * kerning for smaller font sizes, at the cost of higher memory usage and lower font rasterization
   * speed. Use [TextServer.SUBPIXEL_POSITIONING_AUTO] to automatically enable it based on the font
   * size.
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
   * field (MSDF) generated from the dynamic font vector data. Since this approach does not rely on
   * rasterizing the font every time its size changes, this allows for resizing the font in real-time
   * without any performance penalty. Text will also not look grainy for [Control]s that are scaled
   * down (or for [Label3D]s viewed from a long distance). As a downside, font hinting is not available
   * with MSDF. The lack of font hinting may result in less crisp and less readable fonts at small
   * sizes.
   *
   * **Note:** If using font outlines, [msdfPixelRange] must be set to at least *twice* the size of
   * the largest font outline.
   *
   * **Note:** MSDF font rendering does not render glyphs with overlapping shapes correctly.
   * Overlapping shapes are not valid per the OpenType standard, but are still commonly found in many
   * font files, especially those converted by Google Fonts. To avoid issues with overlapping glyphs,
   * consider downloading the font file directly from the type foundry instead of relying on Google
   * Fonts.
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
   * If set to `true`, auto-hinting is supported and preferred over font built-in hinting. Used by
   * dynamic fonts only (MSDF fonts don't support hinting).
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
   * Font hinting mode. Used by dynamic fonts only.
   */
  public final inline var hinting: TextServer.Hinting
    @JvmName("hintingProperty")
    get() = getHinting()
    @JvmName("hintingProperty")
    set(`value`) {
      setHinting(value)
    }

  /**
   * Font size, used only for the bitmap fonts.
   */
  public final inline var fixedSize: Int
    @JvmName("fixedSizeProperty")
    get() = getFixedSize()
    @JvmName("fixedSizeProperty")
    set(`value`) {
      setFixedSize(value)
    }

  /**
   * Scaling mode, used only for the bitmap fonts with [fixedSize] greater than zero.
   */
  public final inline var fixedSizeScaleMode: TextServer.FixedSizeScaleMode
    @JvmName("fixedSizeScaleModeProperty")
    get() = getFixedSizeScaleMode()
    @JvmName("fixedSizeScaleModeProperty")
    set(`value`) {
      setFixedSizeScaleMode(value)
    }

  /**
   * Font OpenType feature set override.
   */
  public final inline var opentypeFeatureOverrides: Dictionary<Any?, Any?>
    @JvmName("opentypeFeatureOverridesProperty")
    get() = getOpentypeFeatureOverrides()
    @JvmName("opentypeFeatureOverridesProperty")
    set(`value`) {
      setOpentypeFeatureOverrides(value)
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
    createNativeObject(234, scriptPtr)
  }

  /**
   * This is a helper function for [data] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = fontfile.data
   * //Your changes
   * fontfile.data = myCoreType
   * ``````
   *
   * Contents of the dynamic font source file.
   */
  @CoreTypeHelper
  public final fun dataMutate(block: PackedByteArray.() -> Unit): PackedByteArray = data.apply {
     block(this)
     data = this
  }

  /**
   * This is a helper function for [data] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Contents of the dynamic font source file.
   */
  @CoreTypeHelper
  public final fun dataMutateEach(block: (index: Int, `value`: Byte) -> Unit): PackedByteArray =
      data.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     data = this
  }

  /**
   * Loads an AngelCode BMFont (.fnt, .font) bitmap font from file [path].
   *
   * **Warning:** This method should only be used in the editor or in cases when you need to load
   * external fonts at run-time, such as fonts located at the `user://` directory.
   */
  public final fun loadBitmapFont(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.loadBitmapFontPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Loads a TrueType (.ttf), OpenType (.otf), WOFF (.woff), WOFF2 (.woff2) or Type 1 (.pfb, .pfm)
   * dynamic font from file [path].
   *
   * **Warning:** This method should only be used in the editor or in cases when you need to load
   * external fonts at run-time, such as fonts located at the `user://` directory.
   */
  public final fun loadDynamicFont(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.loadDynamicFontPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setData(`data`: PackedByteArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.setDataPtr)
  }

  public final fun getData(): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDataPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  public final fun setFontName(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.setFontNamePtr)
  }

  public final fun setFontStyleName(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.setFontStyleNamePtr)
  }

  public final fun setFontStyle(style: TextServer.FontStyle): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to style.flag)
    TransferContext.callMethod(MethodBindings.setFontStylePtr)
  }

  public final fun setFontWeight(weight: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to weight.toLong())
    TransferContext.callMethod(MethodBindings.setFontWeightPtr)
  }

  public final fun setFontStretch(stretch: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stretch.toLong())
    TransferContext.callMethod(MethodBindings.setFontStretchPtr)
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

  public final fun setFixedSize(fixedSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fixedSize.toLong())
    TransferContext.callMethod(MethodBindings.setFixedSizePtr)
  }

  public final fun getFixedSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFixedSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setFixedSizeScaleMode(fixedSizeScaleMode: TextServer.FixedSizeScaleMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fixedSizeScaleMode.value)
    TransferContext.callMethod(MethodBindings.setFixedSizeScaleModePtr)
  }

  public final fun getFixedSizeScaleMode(): TextServer.FixedSizeScaleMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFixedSizeScaleModePtr)
    return TextServer.FixedSizeScaleMode.from(TransferContext.readReturnValue(LONG) as Long)
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

  public final fun setOversampling(oversampling: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.setOversamplingPtr)
  }

  public final fun getOversampling(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOversamplingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns number of the font cache entries.
   */
  public final fun getCacheCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCacheCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes all font cache entries.
   */
  public final fun clearCache(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearCachePtr)
  }

  /**
   * Removes specified font cache entry.
   */
  public final fun removeCache(cacheIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong())
    TransferContext.callMethod(MethodBindings.removeCachePtr)
  }

  /**
   * Returns list of the font sizes in the cache. Each size is [Vector2i] with font size and outline
   * size.
   */
  public final fun getSizeCacheList(cacheIndex: Int): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSizeCacheListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  /**
   * Removes all font sizes from the cache entry.
   */
  public final fun clearSizeCache(cacheIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong())
    TransferContext.callMethod(MethodBindings.clearSizeCachePtr)
  }

  /**
   * Removes specified font size from the cache entry.
   */
  public final fun removeSizeCache(cacheIndex: Int, size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.removeSizeCachePtr)
  }

  /**
   * Sets variation coordinates for the specified font cache entry. See
   * [Font.getSupportedVariationList] for more info.
   */
  public final fun setVariationCoordinates(cacheIndex: Int,
      variationCoordinates: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), DICTIONARY to variationCoordinates)
    TransferContext.callMethod(MethodBindings.setVariationCoordinatesPtr)
  }

  /**
   * Returns variation coordinates for the specified font cache entry. See
   * [Font.getSupportedVariationList] for more info.
   */
  public final fun getVariationCoordinates(cacheIndex: Int): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong())
    TransferContext.callMethod(MethodBindings.getVariationCoordinatesPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Sets embolden strength, if is not equal to zero, emboldens the font outlines. Negative values
   * reduce the outline thickness.
   */
  public final fun setEmbolden(cacheIndex: Int, strength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), DOUBLE to strength.toDouble())
    TransferContext.callMethod(MethodBindings.setEmboldenPtr)
  }

  /**
   * Returns embolden strength, if is not equal to zero, emboldens the font outlines. Negative
   * values reduce the outline thickness.
   */
  public final fun getEmbolden(cacheIndex: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong())
    TransferContext.callMethod(MethodBindings.getEmboldenPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets 2D transform, applied to the font outlines, can be used for slanting, flipping, and
   * rotating glyphs.
   */
  public final fun setTransform(cacheIndex: Int, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.setTransformPtr)
  }

  /**
   * Returns 2D transform, applied to the font outlines, can be used for slanting, flipping and
   * rotating glyphs.
   */
  public final fun getTransform(cacheIndex: Int): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong())
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Sets the spacing for [spacing] to [value] in pixels (not relative to the font size).
   */
  public final fun setExtraSpacing(
    cacheIndex: Int,
    spacing: TextServer.SpacingType,
    `value`: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to spacing.value, LONG to value)
    TransferContext.callMethod(MethodBindings.setExtraSpacingPtr)
  }

  /**
   * Returns spacing for [spacing] in pixels (not relative to the font size).
   */
  public final fun getExtraSpacing(cacheIndex: Int, spacing: TextServer.SpacingType): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to spacing.value)
    TransferContext.callMethod(MethodBindings.getExtraSpacingPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets extra baseline offset (as a fraction of font height).
   */
  public final fun setExtraBaselineOffset(cacheIndex: Int, baselineOffset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), DOUBLE to baselineOffset.toDouble())
    TransferContext.callMethod(MethodBindings.setExtraBaselineOffsetPtr)
  }

  /**
   * Returns extra baseline offset (as a fraction of font height).
   */
  public final fun getExtraBaselineOffset(cacheIndex: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong())
    TransferContext.callMethod(MethodBindings.getExtraBaselineOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets an active face index in the TrueType / OpenType collection.
   */
  public final fun setFaceIndex(cacheIndex: Int, faceIndex: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to faceIndex)
    TransferContext.callMethod(MethodBindings.setFaceIndexPtr)
  }

  /**
   * Returns an active face index in the TrueType / OpenType collection.
   */
  public final fun getFaceIndex(cacheIndex: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong())
    TransferContext.callMethod(MethodBindings.getFaceIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the font ascent (number of pixels above the baseline).
   */
  public final fun setCacheAscent(
    cacheIndex: Int,
    size: Int,
    ascent: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), DOUBLE to ascent.toDouble())
    TransferContext.callMethod(MethodBindings.setCacheAscentPtr)
  }

  /**
   * Returns the font ascent (number of pixels above the baseline).
   */
  public final fun getCacheAscent(cacheIndex: Int, size: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.getCacheAscentPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the font descent (number of pixels below the baseline).
   */
  public final fun setCacheDescent(
    cacheIndex: Int,
    size: Int,
    descent: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), DOUBLE to descent.toDouble())
    TransferContext.callMethod(MethodBindings.setCacheDescentPtr)
  }

  /**
   * Returns the font descent (number of pixels below the baseline).
   */
  public final fun getCacheDescent(cacheIndex: Int, size: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.getCacheDescentPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets pixel offset of the underline below the baseline.
   */
  public final fun setCacheUnderlinePosition(
    cacheIndex: Int,
    size: Int,
    underlinePosition: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), DOUBLE to underlinePosition.toDouble())
    TransferContext.callMethod(MethodBindings.setCacheUnderlinePositionPtr)
  }

  /**
   * Returns pixel offset of the underline below the baseline.
   */
  public final fun getCacheUnderlinePosition(cacheIndex: Int, size: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.getCacheUnderlinePositionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets thickness of the underline in pixels.
   */
  public final fun setCacheUnderlineThickness(
    cacheIndex: Int,
    size: Int,
    underlineThickness: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), DOUBLE to underlineThickness.toDouble())
    TransferContext.callMethod(MethodBindings.setCacheUnderlineThicknessPtr)
  }

  /**
   * Returns thickness of the underline in pixels.
   */
  public final fun getCacheUnderlineThickness(cacheIndex: Int, size: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.getCacheUnderlineThicknessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets scaling factor of the color bitmap font.
   */
  public final fun setCacheScale(
    cacheIndex: Int,
    size: Int,
    scale: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setCacheScalePtr)
  }

  /**
   * Returns scaling factor of the color bitmap font.
   */
  public final fun getCacheScale(cacheIndex: Int, size: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.getCacheScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns number of textures used by font cache entry.
   */
  public final fun getTextureCount(cacheIndex: Int, size: Vector2i): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.getTextureCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes all textures from font cache entry.
   *
   * **Note:** This function will not remove glyphs associated with the texture, use [removeGlyph]
   * to remove them manually.
   */
  public final fun clearTextures(cacheIndex: Int, size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.clearTexturesPtr)
  }

  /**
   * Removes specified texture from the cache entry.
   *
   * **Note:** This function will not remove glyphs associated with the texture. Remove them
   * manually using [removeGlyph].
   */
  public final fun removeTexture(
    cacheIndex: Int,
    size: Vector2i,
    textureIndex: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to textureIndex.toLong())
    TransferContext.callMethod(MethodBindings.removeTexturePtr)
  }

  /**
   * Sets font cache texture image.
   */
  public final fun setTextureImage(
    cacheIndex: Int,
    size: Vector2i,
    textureIndex: Int,
    image: Image?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to textureIndex.toLong(), OBJECT to image)
    TransferContext.callMethod(MethodBindings.setTextureImagePtr)
  }

  /**
   * Returns a copy of the font cache texture image.
   */
  public final fun getTextureImage(
    cacheIndex: Int,
    size: Vector2i,
    textureIndex: Int,
  ): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to textureIndex.toLong())
    TransferContext.callMethod(MethodBindings.getTextureImagePtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Sets array containing glyph packing data.
   */
  public final fun setTextureOffsets(
    cacheIndex: Int,
    size: Vector2i,
    textureIndex: Int,
    offset: PackedInt32Array,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to textureIndex.toLong(), PACKED_INT_32_ARRAY to offset)
    TransferContext.callMethod(MethodBindings.setTextureOffsetsPtr)
  }

  /**
   * Returns a copy of the array containing glyph packing data.
   */
  public final fun getTextureOffsets(
    cacheIndex: Int,
    size: Vector2i,
    textureIndex: Int,
  ): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to textureIndex.toLong())
    TransferContext.callMethod(MethodBindings.getTextureOffsetsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns list of rendered glyphs in the cache entry.
   */
  public final fun getGlyphList(cacheIndex: Int, size: Vector2i): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.getGlyphListPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Removes all rendered glyph information from the cache entry.
   *
   * **Note:** This function will not remove textures associated with the glyphs, use
   * [removeTexture] to remove them manually.
   */
  public final fun clearGlyphs(cacheIndex: Int, size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.clearGlyphsPtr)
  }

  /**
   * Removes specified rendered glyph information from the cache entry.
   *
   * **Note:** This function will not remove textures associated with the glyphs, use
   * [removeTexture] to remove them manually.
   */
  public final fun removeGlyph(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong())
    TransferContext.callMethod(MethodBindings.removeGlyphPtr)
  }

  /**
   * Sets glyph advance (offset of the next glyph).
   *
   * **Note:** Advance for glyphs outlines is the same as the base glyph advance and is not saved.
   */
  public final fun setGlyphAdvance(
    cacheIndex: Int,
    size: Int,
    glyph: Int,
    advance: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), LONG to glyph.toLong(), VECTOR2 to advance)
    TransferContext.callMethod(MethodBindings.setGlyphAdvancePtr)
  }

  /**
   * Returns glyph advance (offset of the next glyph).
   *
   * **Note:** Advance for glyphs outlines is the same as the base glyph advance and is not saved.
   */
  public final fun getGlyphAdvance(
    cacheIndex: Int,
    size: Int,
    glyph: Int,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), LONG to glyph.toLong())
    TransferContext.callMethod(MethodBindings.getGlyphAdvancePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets glyph offset from the baseline.
   */
  public final fun setGlyphOffset(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
    offset: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong(), VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setGlyphOffsetPtr)
  }

  /**
   * Returns glyph offset from the baseline.
   */
  public final fun getGlyphOffset(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong())
    TransferContext.callMethod(MethodBindings.getGlyphOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets glyph size.
   */
  public final fun setGlyphSize(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
    glSize: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong(), VECTOR2 to glSize)
    TransferContext.callMethod(MethodBindings.setGlyphSizePtr)
  }

  /**
   * Returns glyph size.
   */
  public final fun getGlyphSize(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong())
    TransferContext.callMethod(MethodBindings.getGlyphSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets rectangle in the cache texture containing the glyph.
   */
  public final fun setGlyphUvRect(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
    uvRect: Rect2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong(), RECT2 to uvRect)
    TransferContext.callMethod(MethodBindings.setGlyphUvRectPtr)
  }

  /**
   * Returns rectangle in the cache texture containing the glyph.
   */
  public final fun getGlyphUvRect(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
  ): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong())
    TransferContext.callMethod(MethodBindings.getGlyphUvRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Sets index of the cache texture containing the glyph.
   */
  public final fun setGlyphTextureIdx(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
    textureIdx: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong(), LONG to textureIdx.toLong())
    TransferContext.callMethod(MethodBindings.setGlyphTextureIdxPtr)
  }

  /**
   * Returns index of the cache texture containing the glyph.
   */
  public final fun getGlyphTextureIdx(
    cacheIndex: Int,
    size: Vector2i,
    glyph: Int,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to glyph.toLong())
    TransferContext.callMethod(MethodBindings.getGlyphTextureIdxPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns list of the kerning overrides.
   */
  public final fun getKerningList(cacheIndex: Int, size: Int): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.getKerningListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  /**
   * Removes all kerning overrides.
   */
  public final fun clearKerningMap(cacheIndex: Int, size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.clearKerningMapPtr)
  }

  /**
   * Removes kerning override for the pair of glyphs.
   */
  public final fun removeKerning(
    cacheIndex: Int,
    size: Int,
    glyphPair: Vector2i,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), VECTOR2I to glyphPair)
    TransferContext.callMethod(MethodBindings.removeKerningPtr)
  }

  /**
   * Sets kerning for the pair of glyphs.
   */
  public final fun setKerning(
    cacheIndex: Int,
    size: Int,
    glyphPair: Vector2i,
    kerning: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), VECTOR2I to glyphPair, VECTOR2 to kerning)
    TransferContext.callMethod(MethodBindings.setKerningPtr)
  }

  /**
   * Returns kerning for the pair of glyphs.
   */
  public final fun getKerning(
    cacheIndex: Int,
    size: Int,
    glyphPair: Vector2i,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), LONG to size.toLong(), VECTOR2I to glyphPair)
    TransferContext.callMethod(MethodBindings.getKerningPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Renders the range of characters to the font cache texture.
   */
  public final fun renderRange(
    cacheIndex: Int,
    size: Vector2i,
    start: Long,
    end: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to start, LONG to end)
    TransferContext.callMethod(MethodBindings.renderRangePtr)
  }

  /**
   * Renders specified glyph to the font cache texture.
   */
  public final fun renderGlyph(
    cacheIndex: Int,
    size: Vector2i,
    index: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to cacheIndex.toLong(), VECTOR2I to size, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.renderGlyphPtr)
  }

  /**
   * Adds override for [Font.isLanguageSupported].
   */
  public final fun setLanguageSupportOverride(language: String, supported: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to language, BOOL to supported)
    TransferContext.callMethod(MethodBindings.setLanguageSupportOverridePtr)
  }

  /**
   * Returns `true` if support override is enabled for the [language].
   */
  public final fun getLanguageSupportOverride(language: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to language)
    TransferContext.callMethod(MethodBindings.getLanguageSupportOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Remove language support override.
   */
  public final fun removeLanguageSupportOverride(language: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to language)
    TransferContext.callMethod(MethodBindings.removeLanguageSupportOverridePtr)
  }

  /**
   * Returns list of language support overrides.
   */
  public final fun getLanguageSupportOverrides(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguageSupportOverridesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Adds override for [Font.isScriptSupported].
   */
  public final fun setScriptSupportOverride(script: String, supported: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to script, BOOL to supported)
    TransferContext.callMethod(MethodBindings.setScriptSupportOverridePtr)
  }

  /**
   * Returns `true` if support override is enabled for the [script].
   */
  public final fun getScriptSupportOverride(script: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to script)
    TransferContext.callMethod(MethodBindings.getScriptSupportOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes script support override.
   */
  public final fun removeScriptSupportOverride(script: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to script)
    TransferContext.callMethod(MethodBindings.removeScriptSupportOverridePtr)
  }

  /**
   * Returns list of script support overrides.
   */
  public final fun getScriptSupportOverrides(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScriptSupportOverridesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  public final fun setOpentypeFeatureOverrides(overrides: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to overrides)
    TransferContext.callMethod(MethodBindings.setOpentypeFeatureOverridesPtr)
  }

  public final fun getOpentypeFeatureOverrides(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOpentypeFeatureOverridesPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns the glyph index of a [char], optionally modified by the [variationSelector].
   */
  public final fun getGlyphIndex(
    size: Int,
    char: Long,
    variationSelector: Long,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong(), LONG to char, LONG to variationSelector)
    TransferContext.callMethod(MethodBindings.getGlyphIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns character code associated with [glyphIndex], or `0` if [glyphIndex] is invalid. See
   * [getGlyphIndex].
   */
  public final fun getCharFromGlyphIndex(size: Int, glyphIndex: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong(), LONG to glyphIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCharFromGlyphIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public companion object {
    @JvmField
    public val loadBitmapFontName: MethodStringName1<FontFile, Error, String> =
        MethodStringName1<FontFile, Error, String>("load_bitmap_font")

    @JvmField
    public val loadDynamicFontName: MethodStringName1<FontFile, Error, String> =
        MethodStringName1<FontFile, Error, String>("load_dynamic_font")

    @JvmField
    public val setDataName: MethodStringName1<FontFile, Unit, PackedByteArray> =
        MethodStringName1<FontFile, Unit, PackedByteArray>("set_data")

    @JvmField
    public val getDataName: MethodStringName0<FontFile, PackedByteArray> =
        MethodStringName0<FontFile, PackedByteArray>("get_data")

    @JvmField
    public val setFontNameName: MethodStringName1<FontFile, Unit, String> =
        MethodStringName1<FontFile, Unit, String>("set_font_name")

    @JvmField
    public val setFontStyleNameName: MethodStringName1<FontFile, Unit, String> =
        MethodStringName1<FontFile, Unit, String>("set_font_style_name")

    @JvmField
    public val setFontStyleName: MethodStringName1<FontFile, Unit, TextServer.FontStyle> =
        MethodStringName1<FontFile, Unit, TextServer.FontStyle>("set_font_style")

    @JvmField
    public val setFontWeightName: MethodStringName1<FontFile, Unit, Int> =
        MethodStringName1<FontFile, Unit, Int>("set_font_weight")

    @JvmField
    public val setFontStretchName: MethodStringName1<FontFile, Unit, Int> =
        MethodStringName1<FontFile, Unit, Int>("set_font_stretch")

    @JvmField
    public val setAntialiasingName: MethodStringName1<FontFile, Unit, TextServer.FontAntialiasing> =
        MethodStringName1<FontFile, Unit, TextServer.FontAntialiasing>("set_antialiasing")

    @JvmField
    public val getAntialiasingName: MethodStringName0<FontFile, TextServer.FontAntialiasing> =
        MethodStringName0<FontFile, TextServer.FontAntialiasing>("get_antialiasing")

    @JvmField
    public val setDisableEmbeddedBitmapsName: MethodStringName1<FontFile, Unit, Boolean> =
        MethodStringName1<FontFile, Unit, Boolean>("set_disable_embedded_bitmaps")

    @JvmField
    public val getDisableEmbeddedBitmapsName: MethodStringName0<FontFile, Boolean> =
        MethodStringName0<FontFile, Boolean>("get_disable_embedded_bitmaps")

    @JvmField
    public val setGenerateMipmapsName: MethodStringName1<FontFile, Unit, Boolean> =
        MethodStringName1<FontFile, Unit, Boolean>("set_generate_mipmaps")

    @JvmField
    public val getGenerateMipmapsName: MethodStringName0<FontFile, Boolean> =
        MethodStringName0<FontFile, Boolean>("get_generate_mipmaps")

    @JvmField
    public val setMultichannelSignedDistanceFieldName: MethodStringName1<FontFile, Unit, Boolean> =
        MethodStringName1<FontFile, Unit, Boolean>("set_multichannel_signed_distance_field")

    @JvmField
    public val isMultichannelSignedDistanceFieldName: MethodStringName0<FontFile, Boolean> =
        MethodStringName0<FontFile, Boolean>("is_multichannel_signed_distance_field")

    @JvmField
    public val setMsdfPixelRangeName: MethodStringName1<FontFile, Unit, Int> =
        MethodStringName1<FontFile, Unit, Int>("set_msdf_pixel_range")

    @JvmField
    public val getMsdfPixelRangeName: MethodStringName0<FontFile, Int> =
        MethodStringName0<FontFile, Int>("get_msdf_pixel_range")

    @JvmField
    public val setMsdfSizeName: MethodStringName1<FontFile, Unit, Int> =
        MethodStringName1<FontFile, Unit, Int>("set_msdf_size")

    @JvmField
    public val getMsdfSizeName: MethodStringName0<FontFile, Int> =
        MethodStringName0<FontFile, Int>("get_msdf_size")

    @JvmField
    public val setFixedSizeName: MethodStringName1<FontFile, Unit, Int> =
        MethodStringName1<FontFile, Unit, Int>("set_fixed_size")

    @JvmField
    public val getFixedSizeName: MethodStringName0<FontFile, Int> =
        MethodStringName0<FontFile, Int>("get_fixed_size")

    @JvmField
    public val setFixedSizeScaleModeName:
        MethodStringName1<FontFile, Unit, TextServer.FixedSizeScaleMode> =
        MethodStringName1<FontFile, Unit, TextServer.FixedSizeScaleMode>("set_fixed_size_scale_mode")

    @JvmField
    public val getFixedSizeScaleModeName: MethodStringName0<FontFile, TextServer.FixedSizeScaleMode>
        = MethodStringName0<FontFile, TextServer.FixedSizeScaleMode>("get_fixed_size_scale_mode")

    @JvmField
    public val setAllowSystemFallbackName: MethodStringName1<FontFile, Unit, Boolean> =
        MethodStringName1<FontFile, Unit, Boolean>("set_allow_system_fallback")

    @JvmField
    public val isAllowSystemFallbackName: MethodStringName0<FontFile, Boolean> =
        MethodStringName0<FontFile, Boolean>("is_allow_system_fallback")

    @JvmField
    public val setForceAutohinterName: MethodStringName1<FontFile, Unit, Boolean> =
        MethodStringName1<FontFile, Unit, Boolean>("set_force_autohinter")

    @JvmField
    public val isForceAutohinterName: MethodStringName0<FontFile, Boolean> =
        MethodStringName0<FontFile, Boolean>("is_force_autohinter")

    @JvmField
    public val setModulateColorGlyphsName: MethodStringName1<FontFile, Unit, Boolean> =
        MethodStringName1<FontFile, Unit, Boolean>("set_modulate_color_glyphs")

    @JvmField
    public val isModulateColorGlyphsName: MethodStringName0<FontFile, Boolean> =
        MethodStringName0<FontFile, Boolean>("is_modulate_color_glyphs")

    @JvmField
    public val setHintingName: MethodStringName1<FontFile, Unit, TextServer.Hinting> =
        MethodStringName1<FontFile, Unit, TextServer.Hinting>("set_hinting")

    @JvmField
    public val getHintingName: MethodStringName0<FontFile, TextServer.Hinting> =
        MethodStringName0<FontFile, TextServer.Hinting>("get_hinting")

    @JvmField
    public val setSubpixelPositioningName:
        MethodStringName1<FontFile, Unit, TextServer.SubpixelPositioning> =
        MethodStringName1<FontFile, Unit, TextServer.SubpixelPositioning>("set_subpixel_positioning")

    @JvmField
    public val getSubpixelPositioningName:
        MethodStringName0<FontFile, TextServer.SubpixelPositioning> =
        MethodStringName0<FontFile, TextServer.SubpixelPositioning>("get_subpixel_positioning")

    @JvmField
    public val setKeepRoundingRemaindersName: MethodStringName1<FontFile, Unit, Boolean> =
        MethodStringName1<FontFile, Unit, Boolean>("set_keep_rounding_remainders")

    @JvmField
    public val getKeepRoundingRemaindersName: MethodStringName0<FontFile, Boolean> =
        MethodStringName0<FontFile, Boolean>("get_keep_rounding_remainders")

    @JvmField
    public val setOversamplingName: MethodStringName1<FontFile, Unit, Float> =
        MethodStringName1<FontFile, Unit, Float>("set_oversampling")

    @JvmField
    public val getOversamplingName: MethodStringName0<FontFile, Float> =
        MethodStringName0<FontFile, Float>("get_oversampling")

    @JvmField
    public val getCacheCountName: MethodStringName0<FontFile, Int> =
        MethodStringName0<FontFile, Int>("get_cache_count")

    @JvmField
    public val clearCacheName: MethodStringName0<FontFile, Unit> =
        MethodStringName0<FontFile, Unit>("clear_cache")

    @JvmField
    public val removeCacheName: MethodStringName1<FontFile, Unit, Int> =
        MethodStringName1<FontFile, Unit, Int>("remove_cache")

    @JvmField
    public val getSizeCacheListName: MethodStringName1<FontFile, VariantArray<Vector2i>, Int> =
        MethodStringName1<FontFile, VariantArray<Vector2i>, Int>("get_size_cache_list")

    @JvmField
    public val clearSizeCacheName: MethodStringName1<FontFile, Unit, Int> =
        MethodStringName1<FontFile, Unit, Int>("clear_size_cache")

    @JvmField
    public val removeSizeCacheName: MethodStringName2<FontFile, Unit, Int, Vector2i> =
        MethodStringName2<FontFile, Unit, Int, Vector2i>("remove_size_cache")

    @JvmField
    public val setVariationCoordinatesName:
        MethodStringName2<FontFile, Unit, Int, Dictionary<Any?, Any?>> =
        MethodStringName2<FontFile, Unit, Int, Dictionary<Any?, Any?>>("set_variation_coordinates")

    @JvmField
    public val getVariationCoordinatesName: MethodStringName1<FontFile, Dictionary<Any?, Any?>, Int>
        = MethodStringName1<FontFile, Dictionary<Any?, Any?>, Int>("get_variation_coordinates")

    @JvmField
    public val setEmboldenName: MethodStringName2<FontFile, Unit, Int, Float> =
        MethodStringName2<FontFile, Unit, Int, Float>("set_embolden")

    @JvmField
    public val getEmboldenName: MethodStringName1<FontFile, Float, Int> =
        MethodStringName1<FontFile, Float, Int>("get_embolden")

    @JvmField
    public val setTransformName: MethodStringName2<FontFile, Unit, Int, Transform2D> =
        MethodStringName2<FontFile, Unit, Int, Transform2D>("set_transform")

    @JvmField
    public val getTransformName: MethodStringName1<FontFile, Transform2D, Int> =
        MethodStringName1<FontFile, Transform2D, Int>("get_transform")

    @JvmField
    public val setExtraSpacingName:
        MethodStringName3<FontFile, Unit, Int, TextServer.SpacingType, Long> =
        MethodStringName3<FontFile, Unit, Int, TextServer.SpacingType, Long>("set_extra_spacing")

    @JvmField
    public val getExtraSpacingName: MethodStringName2<FontFile, Long, Int, TextServer.SpacingType> =
        MethodStringName2<FontFile, Long, Int, TextServer.SpacingType>("get_extra_spacing")

    @JvmField
    public val setExtraBaselineOffsetName: MethodStringName2<FontFile, Unit, Int, Float> =
        MethodStringName2<FontFile, Unit, Int, Float>("set_extra_baseline_offset")

    @JvmField
    public val getExtraBaselineOffsetName: MethodStringName1<FontFile, Float, Int> =
        MethodStringName1<FontFile, Float, Int>("get_extra_baseline_offset")

    @JvmField
    public val setFaceIndexName: MethodStringName2<FontFile, Unit, Int, Long> =
        MethodStringName2<FontFile, Unit, Int, Long>("set_face_index")

    @JvmField
    public val getFaceIndexName: MethodStringName1<FontFile, Long, Int> =
        MethodStringName1<FontFile, Long, Int>("get_face_index")

    @JvmField
    public val setCacheAscentName: MethodStringName3<FontFile, Unit, Int, Int, Float> =
        MethodStringName3<FontFile, Unit, Int, Int, Float>("set_cache_ascent")

    @JvmField
    public val getCacheAscentName: MethodStringName2<FontFile, Float, Int, Int> =
        MethodStringName2<FontFile, Float, Int, Int>("get_cache_ascent")

    @JvmField
    public val setCacheDescentName: MethodStringName3<FontFile, Unit, Int, Int, Float> =
        MethodStringName3<FontFile, Unit, Int, Int, Float>("set_cache_descent")

    @JvmField
    public val getCacheDescentName: MethodStringName2<FontFile, Float, Int, Int> =
        MethodStringName2<FontFile, Float, Int, Int>("get_cache_descent")

    @JvmField
    public val setCacheUnderlinePositionName: MethodStringName3<FontFile, Unit, Int, Int, Float> =
        MethodStringName3<FontFile, Unit, Int, Int, Float>("set_cache_underline_position")

    @JvmField
    public val getCacheUnderlinePositionName: MethodStringName2<FontFile, Float, Int, Int> =
        MethodStringName2<FontFile, Float, Int, Int>("get_cache_underline_position")

    @JvmField
    public val setCacheUnderlineThicknessName: MethodStringName3<FontFile, Unit, Int, Int, Float> =
        MethodStringName3<FontFile, Unit, Int, Int, Float>("set_cache_underline_thickness")

    @JvmField
    public val getCacheUnderlineThicknessName: MethodStringName2<FontFile, Float, Int, Int> =
        MethodStringName2<FontFile, Float, Int, Int>("get_cache_underline_thickness")

    @JvmField
    public val setCacheScaleName: MethodStringName3<FontFile, Unit, Int, Int, Float> =
        MethodStringName3<FontFile, Unit, Int, Int, Float>("set_cache_scale")

    @JvmField
    public val getCacheScaleName: MethodStringName2<FontFile, Float, Int, Int> =
        MethodStringName2<FontFile, Float, Int, Int>("get_cache_scale")

    @JvmField
    public val getTextureCountName: MethodStringName2<FontFile, Int, Int, Vector2i> =
        MethodStringName2<FontFile, Int, Int, Vector2i>("get_texture_count")

    @JvmField
    public val clearTexturesName: MethodStringName2<FontFile, Unit, Int, Vector2i> =
        MethodStringName2<FontFile, Unit, Int, Vector2i>("clear_textures")

    @JvmField
    public val removeTextureName: MethodStringName3<FontFile, Unit, Int, Vector2i, Int> =
        MethodStringName3<FontFile, Unit, Int, Vector2i, Int>("remove_texture")

    @JvmField
    public val setTextureImageName: MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Image?> =
        MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Image?>("set_texture_image")

    @JvmField
    public val getTextureImageName: MethodStringName3<FontFile, Image?, Int, Vector2i, Int> =
        MethodStringName3<FontFile, Image?, Int, Vector2i, Int>("get_texture_image")

    @JvmField
    public val setTextureOffsetsName:
        MethodStringName4<FontFile, Unit, Int, Vector2i, Int, PackedInt32Array> =
        MethodStringName4<FontFile, Unit, Int, Vector2i, Int, PackedInt32Array>("set_texture_offsets")

    @JvmField
    public val getTextureOffsetsName:
        MethodStringName3<FontFile, PackedInt32Array, Int, Vector2i, Int> =
        MethodStringName3<FontFile, PackedInt32Array, Int, Vector2i, Int>("get_texture_offsets")

    @JvmField
    public val getGlyphListName: MethodStringName2<FontFile, PackedInt32Array, Int, Vector2i> =
        MethodStringName2<FontFile, PackedInt32Array, Int, Vector2i>("get_glyph_list")

    @JvmField
    public val clearGlyphsName: MethodStringName2<FontFile, Unit, Int, Vector2i> =
        MethodStringName2<FontFile, Unit, Int, Vector2i>("clear_glyphs")

    @JvmField
    public val removeGlyphName: MethodStringName3<FontFile, Unit, Int, Vector2i, Int> =
        MethodStringName3<FontFile, Unit, Int, Vector2i, Int>("remove_glyph")

    @JvmField
    public val setGlyphAdvanceName: MethodStringName4<FontFile, Unit, Int, Int, Int, Vector2> =
        MethodStringName4<FontFile, Unit, Int, Int, Int, Vector2>("set_glyph_advance")

    @JvmField
    public val getGlyphAdvanceName: MethodStringName3<FontFile, Vector2, Int, Int, Int> =
        MethodStringName3<FontFile, Vector2, Int, Int, Int>("get_glyph_advance")

    @JvmField
    public val setGlyphOffsetName: MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Vector2> =
        MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Vector2>("set_glyph_offset")

    @JvmField
    public val getGlyphOffsetName: MethodStringName3<FontFile, Vector2, Int, Vector2i, Int> =
        MethodStringName3<FontFile, Vector2, Int, Vector2i, Int>("get_glyph_offset")

    @JvmField
    public val setGlyphSizeName: MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Vector2> =
        MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Vector2>("set_glyph_size")

    @JvmField
    public val getGlyphSizeName: MethodStringName3<FontFile, Vector2, Int, Vector2i, Int> =
        MethodStringName3<FontFile, Vector2, Int, Vector2i, Int>("get_glyph_size")

    @JvmField
    public val setGlyphUvRectName: MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Rect2> =
        MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Rect2>("set_glyph_uv_rect")

    @JvmField
    public val getGlyphUvRectName: MethodStringName3<FontFile, Rect2, Int, Vector2i, Int> =
        MethodStringName3<FontFile, Rect2, Int, Vector2i, Int>("get_glyph_uv_rect")

    @JvmField
    public val setGlyphTextureIdxName: MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Int> =
        MethodStringName4<FontFile, Unit, Int, Vector2i, Int, Int>("set_glyph_texture_idx")

    @JvmField
    public val getGlyphTextureIdxName: MethodStringName3<FontFile, Int, Int, Vector2i, Int> =
        MethodStringName3<FontFile, Int, Int, Vector2i, Int>("get_glyph_texture_idx")

    @JvmField
    public val getKerningListName: MethodStringName2<FontFile, VariantArray<Vector2i>, Int, Int> =
        MethodStringName2<FontFile, VariantArray<Vector2i>, Int, Int>("get_kerning_list")

    @JvmField
    public val clearKerningMapName: MethodStringName2<FontFile, Unit, Int, Int> =
        MethodStringName2<FontFile, Unit, Int, Int>("clear_kerning_map")

    @JvmField
    public val removeKerningName: MethodStringName3<FontFile, Unit, Int, Int, Vector2i> =
        MethodStringName3<FontFile, Unit, Int, Int, Vector2i>("remove_kerning")

    @JvmField
    public val setKerningName: MethodStringName4<FontFile, Unit, Int, Int, Vector2i, Vector2> =
        MethodStringName4<FontFile, Unit, Int, Int, Vector2i, Vector2>("set_kerning")

    @JvmField
    public val getKerningName: MethodStringName3<FontFile, Vector2, Int, Int, Vector2i> =
        MethodStringName3<FontFile, Vector2, Int, Int, Vector2i>("get_kerning")

    @JvmField
    public val renderRangeName: MethodStringName4<FontFile, Unit, Int, Vector2i, Long, Long> =
        MethodStringName4<FontFile, Unit, Int, Vector2i, Long, Long>("render_range")

    @JvmField
    public val renderGlyphName: MethodStringName3<FontFile, Unit, Int, Vector2i, Int> =
        MethodStringName3<FontFile, Unit, Int, Vector2i, Int>("render_glyph")

    @JvmField
    public val setLanguageSupportOverrideName: MethodStringName2<FontFile, Unit, String, Boolean> =
        MethodStringName2<FontFile, Unit, String, Boolean>("set_language_support_override")

    @JvmField
    public val getLanguageSupportOverrideName: MethodStringName1<FontFile, Boolean, String> =
        MethodStringName1<FontFile, Boolean, String>("get_language_support_override")

    @JvmField
    public val removeLanguageSupportOverrideName: MethodStringName1<FontFile, Unit, String> =
        MethodStringName1<FontFile, Unit, String>("remove_language_support_override")

    @JvmField
    public val getLanguageSupportOverridesName: MethodStringName0<FontFile, PackedStringArray> =
        MethodStringName0<FontFile, PackedStringArray>("get_language_support_overrides")

    @JvmField
    public val setScriptSupportOverrideName: MethodStringName2<FontFile, Unit, String, Boolean> =
        MethodStringName2<FontFile, Unit, String, Boolean>("set_script_support_override")

    @JvmField
    public val getScriptSupportOverrideName: MethodStringName1<FontFile, Boolean, String> =
        MethodStringName1<FontFile, Boolean, String>("get_script_support_override")

    @JvmField
    public val removeScriptSupportOverrideName: MethodStringName1<FontFile, Unit, String> =
        MethodStringName1<FontFile, Unit, String>("remove_script_support_override")

    @JvmField
    public val getScriptSupportOverridesName: MethodStringName0<FontFile, PackedStringArray> =
        MethodStringName0<FontFile, PackedStringArray>("get_script_support_overrides")

    @JvmField
    public val setOpentypeFeatureOverridesName:
        MethodStringName1<FontFile, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<FontFile, Unit, Dictionary<Any?, Any?>>("set_opentype_feature_overrides")

    @JvmField
    public val getOpentypeFeatureOverridesName: MethodStringName0<FontFile, Dictionary<Any?, Any?>>
        = MethodStringName0<FontFile, Dictionary<Any?, Any?>>("get_opentype_feature_overrides")

    @JvmField
    public val getGlyphIndexName: MethodStringName3<FontFile, Int, Int, Long, Long> =
        MethodStringName3<FontFile, Int, Int, Long, Long>("get_glyph_index")

    @JvmField
    public val getCharFromGlyphIndexName: MethodStringName2<FontFile, Long, Int, Int> =
        MethodStringName2<FontFile, Long, Int, Int>("get_char_from_glyph_index")
  }

  public object MethodBindings {
    internal val loadBitmapFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "load_bitmap_font", 166001499)

    internal val loadDynamicFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "load_dynamic_font", 166001499)

    internal val setDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_data", 2971499966)

    internal val getDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_data", 2362200018)

    internal val setFontNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_font_name", 83702148)

    internal val setFontStyleNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_font_style_name", 83702148)

    internal val setFontStylePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_font_style", 918070724)

    internal val setFontWeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_font_weight", 1286410249)

    internal val setFontStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_font_stretch", 1286410249)

    internal val setAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_antialiasing", 1669900)

    internal val getAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_antialiasing", 4262718649)

    internal val setDisableEmbeddedBitmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_disable_embedded_bitmaps", 2586408642)

    internal val getDisableEmbeddedBitmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_disable_embedded_bitmaps", 36873697)

    internal val setGenerateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_generate_mipmaps", 2586408642)

    internal val getGenerateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_generate_mipmaps", 36873697)

    internal val setMultichannelSignedDistanceFieldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_multichannel_signed_distance_field", 2586408642)

    internal val isMultichannelSignedDistanceFieldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "is_multichannel_signed_distance_field", 36873697)

    internal val setMsdfPixelRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_msdf_pixel_range", 1286410249)

    internal val getMsdfPixelRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_msdf_pixel_range", 3905245786)

    internal val setMsdfSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_msdf_size", 1286410249)

    internal val getMsdfSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_msdf_size", 3905245786)

    internal val setFixedSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_fixed_size", 1286410249)

    internal val getFixedSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_fixed_size", 3905245786)

    internal val setFixedSizeScaleModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_fixed_size_scale_mode", 1660989956)

    internal val getFixedSizeScaleModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_fixed_size_scale_mode", 753873478)

    internal val setAllowSystemFallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_allow_system_fallback", 2586408642)

    internal val isAllowSystemFallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "is_allow_system_fallback", 36873697)

    internal val setForceAutohinterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_force_autohinter", 2586408642)

    internal val isForceAutohinterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "is_force_autohinter", 36873697)

    internal val setModulateColorGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_modulate_color_glyphs", 2586408642)

    internal val isModulateColorGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "is_modulate_color_glyphs", 36873697)

    internal val setHintingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_hinting", 1827459492)

    internal val getHintingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_hinting", 3683214614)

    internal val setSubpixelPositioningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_subpixel_positioning", 4225742182)

    internal val getSubpixelPositioningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_subpixel_positioning", 1069238588)

    internal val setKeepRoundingRemaindersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_keep_rounding_remainders", 2586408642)

    internal val getKeepRoundingRemaindersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_keep_rounding_remainders", 36873697)

    internal val setOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_oversampling", 373806689)

    internal val getOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_oversampling", 1740695150)

    internal val getCacheCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_cache_count", 3905245786)

    internal val clearCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "clear_cache", 3218959716)

    internal val removeCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "remove_cache", 1286410249)

    internal val getSizeCacheListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_size_cache_list", 663333327)

    internal val clearSizeCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "clear_size_cache", 1286410249)

    internal val removeSizeCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "remove_size_cache", 2311374912)

    internal val setVariationCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_variation_coordinates", 64545446)

    internal val getVariationCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_variation_coordinates", 3485342025)

    internal val setEmboldenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_embolden", 1602489585)

    internal val getEmboldenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_embolden", 2339986948)

    internal val setTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_transform", 30160968)

    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_transform", 3836996910)

    internal val setExtraSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_extra_spacing", 62942285)

    internal val getExtraSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_extra_spacing", 1924257185)

    internal val setExtraBaselineOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_extra_baseline_offset", 1602489585)

    internal val getExtraBaselineOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_extra_baseline_offset", 2339986948)

    internal val setFaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_face_index", 3937882851)

    internal val getFaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_face_index", 923996154)

    internal val setCacheAscentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_cache_ascent", 3506521499)

    internal val getCacheAscentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_cache_ascent", 3085491603)

    internal val setCacheDescentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_cache_descent", 3506521499)

    internal val getCacheDescentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_cache_descent", 3085491603)

    internal val setCacheUnderlinePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_cache_underline_position", 3506521499)

    internal val getCacheUnderlinePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_cache_underline_position", 3085491603)

    internal val setCacheUnderlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_cache_underline_thickness", 3506521499)

    internal val getCacheUnderlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_cache_underline_thickness", 3085491603)

    internal val setCacheScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_cache_scale", 3506521499)

    internal val getCacheScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_cache_scale", 3085491603)

    internal val getTextureCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_texture_count", 1987661582)

    internal val clearTexturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "clear_textures", 2311374912)

    internal val removeTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "remove_texture", 2328951467)

    internal val setTextureImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_texture_image", 4157974066)

    internal val getTextureImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_texture_image", 3878418953)

    internal val setTextureOffsetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_texture_offsets", 2849993437)

    internal val getTextureOffsetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_texture_offsets", 3703444828)

    internal val getGlyphListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_glyph_list", 681709689)

    internal val clearGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "clear_glyphs", 2311374912)

    internal val removeGlyphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "remove_glyph", 2328951467)

    internal val setGlyphAdvancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_glyph_advance", 947991729)

    internal val getGlyphAdvancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_glyph_advance", 1601573536)

    internal val setGlyphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_glyph_offset", 921719850)

    internal val getGlyphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_glyph_offset", 3205412300)

    internal val setGlyphSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_glyph_size", 921719850)

    internal val getGlyphSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_glyph_size", 3205412300)

    internal val setGlyphUvRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_glyph_uv_rect", 3821620992)

    internal val getGlyphUvRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_glyph_uv_rect", 3927917900)

    internal val setGlyphTextureIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_glyph_texture_idx", 355564111)

    internal val getGlyphTextureIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_glyph_texture_idx", 1629411054)

    internal val getKerningListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_kerning_list", 2345056839)

    internal val clearKerningMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "clear_kerning_map", 3937882851)

    internal val removeKerningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "remove_kerning", 3930204747)

    internal val setKerningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_kerning", 3182200918)

    internal val getKerningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_kerning", 1611912865)

    internal val renderRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "render_range", 355564111)

    internal val renderGlyphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "render_glyph", 2328951467)

    internal val setLanguageSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_language_support_override", 2678287736)

    internal val getLanguageSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_language_support_override", 3927539163)

    internal val removeLanguageSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "remove_language_support_override", 83702148)

    internal val getLanguageSupportOverridesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_language_support_overrides", 1139954409)

    internal val setScriptSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_script_support_override", 2678287736)

    internal val getScriptSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_script_support_override", 3927539163)

    internal val removeScriptSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "remove_script_support_override", 83702148)

    internal val getScriptSupportOverridesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_script_support_overrides", 1139954409)

    internal val setOpentypeFeatureOverridesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "set_opentype_feature_overrides", 4155329257)

    internal val getOpentypeFeatureOverridesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_opentype_feature_overrides", 3102165223)

    internal val getGlyphIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_glyph_index", 864943070)

    internal val getCharFromGlyphIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontFile", "get_char_from_glyph_index", 3175239445)
  }
}
