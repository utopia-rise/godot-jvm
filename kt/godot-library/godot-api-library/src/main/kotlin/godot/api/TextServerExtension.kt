// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.Dictionary
import godot.core.InlineAlignment
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import godot.core.PackedInt32Array
import godot.core.PackedStringArray
import godot.core.PackedVector2Array
import godot.core.RID
import godot.core.Rect2
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3i
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

/**
 * External [TextServer] implementations should inherit from this class.
 */
@GodotBaseType
public abstract class TextServerExtension : TextServer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(737, scriptPtr)
  }

  /**
   * Returns `true` if the server supports a feature.
   */
  public abstract fun _hasFeature(feature: TextServer.Feature): Boolean

  /**
   * Returns the name of the server interface.
   */
  public abstract fun _getName(): String

  /**
   * Returns text server features, see [TextServer.Feature].
   */
  public abstract fun _getFeatures(): Long

  /**
   * Frees an object created by this [TextServer].
   */
  public abstract fun _freeRid(rid: RID): Unit

  /**
   * Returns `true` if [rid] is valid resource owned by this text server.
   */
  public abstract fun _has(rid: RID): Boolean

  /**
   * Loads optional TextServer database (e.g. ICU break iterators and dictionaries).
   */
  public open fun _loadSupportData(filename: String): Boolean {
    throw NotImplementedError("TextServerExtension::_loadSupportData is not implemented.")
  }

  /**
   * Returns default TextServer database (e.g. ICU break iterators and dictionaries) filename.
   */
  public open fun _getSupportDataFilename(): String {
    throw NotImplementedError("TextServerExtension::_getSupportDataFilename is not implemented.")
  }

  /**
   * Returns TextServer database (e.g. ICU break iterators and dictionaries) description.
   */
  public open fun _getSupportDataInfo(): String {
    throw NotImplementedError("TextServerExtension::_getSupportDataInfo is not implemented.")
  }

  /**
   * Saves optional TextServer database (e.g. ICU break iterators and dictionaries) to the file.
   */
  public open fun _saveSupportData(filename: String): Boolean {
    throw NotImplementedError("TextServerExtension::_saveSupportData is not implemented.")
  }

  /**
   * Returns default TextServer database (e.g. ICU break iterators and dictionaries).
   */
  public open fun _getSupportData(): PackedByteArray {
    throw NotImplementedError("TextServerExtension::_getSupportData is not implemented.")
  }

  /**
   * Returns `true` if the locale requires text server support data for line/word breaking.
   */
  public open fun _isLocaleUsingSupportData(locale: String): Boolean {
    throw NotImplementedError("TextServerExtension::_isLocaleUsingSupportData is not implemented.")
  }

  /**
   * Returns `true` if locale is right-to-left.
   */
  public open fun _isLocaleRightToLeft(locale: String): Boolean {
    throw NotImplementedError("TextServerExtension::_isLocaleRightToLeft is not implemented.")
  }

  /**
   * Converts the given readable name of a feature, variation, script, or language to an OpenType
   * tag.
   */
  public open fun _nameToTag(name: String): Long {
    throw NotImplementedError("TextServerExtension::_nameToTag is not implemented.")
  }

  /**
   * Converts the given OpenType tag to the readable name of a feature, variation, script, or
   * language.
   */
  public open fun _tagToName(tag: Long): String {
    throw NotImplementedError("TextServerExtension::_tagToName is not implemented.")
  }

  /**
   * Creates a new, empty font cache entry resource.
   */
  public abstract fun _createFont(): RID

  /**
   * Optional, implement if font supports extra spacing or baseline offset.
   *
   * Creates a new variation existing font which is reusing the same glyph cache and font data.
   */
  public open fun _createFontLinkedVariation(fontRid: RID): RID {
    throw NotImplementedError("TextServerExtension::_createFontLinkedVariation is not implemented.")
  }

  /**
   * Sets font source data, e.g contents of the dynamic font source file.
   */
  public open fun _fontSetData(fontRid: RID, `data`: PackedByteArray): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetData is not implemented.")
  }

  /**
   * Sets an active face index in the TrueType / OpenType collection.
   */
  public open fun _fontSetFaceIndex(fontRid: RID, faceIndex: Long): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetFaceIndex is not implemented.")
  }

  /**
   * Returns an active face index in the TrueType / OpenType collection.
   */
  public open fun _fontGetFaceIndex(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetFaceIndex is not implemented.")
  }

  /**
   * Returns number of faces in the TrueType / OpenType collection.
   */
  public open fun _fontGetFaceCount(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetFaceCount is not implemented.")
  }

  /**
   * Sets the font style flags.
   */
  public open fun _fontSetStyle(fontRid: RID, style: TextServer.FontStyle): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetStyle is not implemented.")
  }

  /**
   * Returns font style flags.
   */
  public open fun _fontGetStyle(fontRid: RID): TextServer.FontStyle {
    throw NotImplementedError("TextServerExtension::_fontGetStyle is not implemented.")
  }

  /**
   * Sets the font family name.
   */
  public open fun _fontSetName(fontRid: RID, name: String): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetName is not implemented.")
  }

  /**
   * Returns font family name.
   */
  public open fun _fontGetName(fontRid: RID): String {
    throw NotImplementedError("TextServerExtension::_fontGetName is not implemented.")
  }

  /**
   * Returns [Dictionary] with OpenType font name strings (localized font names, version,
   * description, license information, sample text, etc.).
   */
  public open fun _fontGetOtNameStrings(fontRid: RID): Dictionary<Any?, Any?> {
    throw NotImplementedError("TextServerExtension::_fontGetOtNameStrings is not implemented.")
  }

  /**
   * Sets the font style name.
   */
  public open fun _fontSetStyleName(fontRid: RID, nameStyle: String): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetStyleName is not implemented.")
  }

  /**
   * Returns font style name.
   */
  public open fun _fontGetStyleName(fontRid: RID): String {
    throw NotImplementedError("TextServerExtension::_fontGetStyleName is not implemented.")
  }

  /**
   * Sets weight (boldness) of the font. A value in the `100...999` range, normal font weight is
   * `400`, bold font weight is `700`.
   */
  public open fun _fontSetWeight(fontRid: RID, weight: Long): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetWeight is not implemented.")
  }

  /**
   * Returns weight (boldness) of the font. A value in the `100...999` range, normal font weight is
   * `400`, bold font weight is `700`.
   */
  public open fun _fontGetWeight(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetWeight is not implemented.")
  }

  /**
   * Sets font stretch amount, compared to a normal width. A percentage value between `50&#37;` and
   * `200&#37;`.
   */
  public open fun _fontSetStretch(fontRid: RID, stretch: Long): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetStretch is not implemented.")
  }

  /**
   * Returns font stretch amount, compared to a normal width. A percentage value between `50&#37;`
   * and `200&#37;`.
   */
  public open fun _fontGetStretch(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetStretch is not implemented.")
  }

  /**
   * Sets font anti-aliasing mode.
   */
  public open fun _fontSetAntialiasing(fontRid: RID, antialiasing: TextServer.FontAntialiasing):
      Unit {
    throw NotImplementedError("TextServerExtension::_fontSetAntialiasing is not implemented.")
  }

  /**
   * Returns font anti-aliasing mode.
   */
  public open fun _fontGetAntialiasing(fontRid: RID): TextServer.FontAntialiasing {
    throw NotImplementedError("TextServerExtension::_fontGetAntialiasing is not implemented.")
  }

  /**
   * If set to `true`, embedded font bitmap loading is disabled.
   */
  public open fun _fontSetDisableEmbeddedBitmaps(fontRid: RID, disableEmbeddedBitmaps: Boolean):
      Unit {
    throw NotImplementedError("TextServerExtension::_fontSetDisableEmbeddedBitmaps is not implemented.")
  }

  /**
   * Returns whether the font's embedded bitmap loading is disabled.
   */
  public open fun _fontGetDisableEmbeddedBitmaps(fontRid: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_fontGetDisableEmbeddedBitmaps is not implemented.")
  }

  /**
   * If set to `true` font texture mipmap generation is enabled.
   */
  public open fun _fontSetGenerateMipmaps(fontRid: RID, generateMipmaps: Boolean): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetGenerateMipmaps is not implemented.")
  }

  /**
   * Returns `true` if font texture mipmap generation is enabled.
   */
  public open fun _fontGetGenerateMipmaps(fontRid: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_fontGetGenerateMipmaps is not implemented.")
  }

  /**
   * If set to `true`, glyphs of all sizes are rendered using single multichannel signed distance
   * field generated from the dynamic font vector data. MSDF rendering allows displaying the font at
   * any scaling factor without blurriness, and without incurring a CPU cost when the font size changes
   * (since the font no longer needs to be rasterized on the CPU). As a downside, font hinting is not
   * available with MSDF. The lack of font hinting may result in less crisp and less readable fonts at
   * small sizes.
   */
  public open fun _fontSetMultichannelSignedDistanceField(fontRid: RID, msdf: Boolean): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetMultichannelSignedDistanceField is not implemented.")
  }

  /**
   * Returns `true` if glyphs of all sizes are rendered using single multichannel signed distance
   * field generated from the dynamic font vector data.
   */
  public open fun _fontIsMultichannelSignedDistanceField(fontRid: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_fontIsMultichannelSignedDistanceField is not implemented.")
  }

  /**
   * Sets the width of the range around the shape between the minimum and maximum representable
   * signed distance.
   */
  public open fun _fontSetMsdfPixelRange(fontRid: RID, msdfPixelRange: Long): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetMsdfPixelRange is not implemented.")
  }

  /**
   * Returns the width of the range around the shape between the minimum and maximum representable
   * signed distance.
   */
  public open fun _fontGetMsdfPixelRange(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetMsdfPixelRange is not implemented.")
  }

  /**
   * Sets source font size used to generate MSDF textures.
   */
  public open fun _fontSetMsdfSize(fontRid: RID, msdfSize: Long): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetMsdfSize is not implemented.")
  }

  /**
   * Returns source font size used to generate MSDF textures.
   */
  public open fun _fontGetMsdfSize(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetMsdfSize is not implemented.")
  }

  /**
   * Sets bitmap font fixed size. If set to value greater than zero, same cache entry will be used
   * for all font sizes.
   */
  public abstract fun _fontSetFixedSize(fontRid: RID, fixedSize: Long): Unit

  /**
   * Returns bitmap font fixed size.
   */
  public abstract fun _fontGetFixedSize(fontRid: RID): Long

  /**
   * Sets bitmap font scaling mode. This property is used only if `fixed_size` is greater than zero.
   */
  public abstract fun _fontSetFixedSizeScaleMode(fontRid: RID,
      fixedSizeScaleMode: TextServer.FixedSizeScaleMode): Unit

  /**
   * Returns bitmap font scaling mode.
   */
  public abstract fun _fontGetFixedSizeScaleMode(fontRid: RID): TextServer.FixedSizeScaleMode

  /**
   * If set to `true`, system fonts can be automatically used as fallbacks.
   */
  public open fun _fontSetAllowSystemFallback(fontRid: RID, allowSystemFallback: Boolean): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetAllowSystemFallback is not implemented.")
  }

  /**
   * Returns `true` if system fonts can be automatically used as fallbacks.
   */
  public open fun _fontIsAllowSystemFallback(fontRid: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_fontIsAllowSystemFallback is not implemented.")
  }

  /**
   * Frees all automatically loaded system fonts.
   */
  public open fun _fontClearSystemFallbackCache(): Unit {
    throw NotImplementedError("TextServerExtension::_fontClearSystemFallbackCache is not implemented.")
  }

  /**
   * If set to `true` auto-hinting is preferred over font built-in hinting.
   */
  public open fun _fontSetForceAutohinter(fontRid: RID, forceAutohinter: Boolean): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetForceAutohinter is not implemented.")
  }

  /**
   * Returns `true` if auto-hinting is supported and preferred over font built-in hinting.
   */
  public open fun _fontIsForceAutohinter(fontRid: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_fontIsForceAutohinter is not implemented.")
  }

  /**
   * If set to `true`, color modulation is applied when drawing colored glyphs, otherwise it's
   * applied to the monochrome glyphs only.
   */
  public open fun _fontSetModulateColorGlyphs(fontRid: RID, modulate: Boolean): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetModulateColorGlyphs is not implemented.")
  }

  /**
   * Returns `true` if color modulation is applied when drawing the font's colored glyphs.
   */
  public open fun _fontIsModulateColorGlyphs(fontRid: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_fontIsModulateColorGlyphs is not implemented.")
  }

  /**
   * Returns the number of predefined color palettes. Palette contains all colors used to render
   * font glyphs. Each palette has the same number of colors.
   */
  public open fun _fontGetPaletteCount(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetPaletteCount is not implemented.")
  }

  /**
   * Returns the name of the predefined color palette at [index]. Palette contains all colors used
   * to render font glyphs. Each palette has the same number of colors.
   */
  public open fun _fontGetPaletteName(fontRid: RID, index: Long): String {
    throw NotImplementedError("TextServerExtension::_fontGetPaletteName is not implemented.")
  }

  /**
   * Returns the array in the predefined color palette at [index]. Palette contains all colors used
   * to render font glyphs. Each palette has the same number of colors. Colors can be overridden using
   * [_fontSetPaletteCustomColors].
   */
  public open fun _fontGetPaletteColors(fontRid: RID, index: Long): PackedColorArray {
    throw NotImplementedError("TextServerExtension::_fontGetPaletteColors is not implemented.")
  }

  /**
   * Sets array of custom colors to override predefined palette. Set to empty array to reset
   * overrides. Use `Color(0, 0, 0, 0)`, to keep predefined palette color at specific position.
   */
  public open fun _fontSetPaletteCustomColors(fontRid: RID, colors: PackedColorArray): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetPaletteCustomColors is not implemented.")
  }

  /**
   * Returns array of custom colors to override predefined palette.
   */
  public open fun _fontGetPaletteCustomColors(fontRid: RID): PackedColorArray {
    throw NotImplementedError("TextServerExtension::_fontGetPaletteCustomColors is not implemented.")
  }

  /**
   * Returns used palette index.
   */
  public open fun _fontGetUsedPalette(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetUsedPalette is not implemented.")
  }

  /**
   * Sets used palette index.
   */
  public open fun _fontSetUsedPalette(fontRid: RID, index: Long): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetUsedPalette is not implemented.")
  }

  /**
   * Sets font hinting mode. Used by dynamic fonts only.
   */
  public open fun _fontSetHinting(fontRid: RID, hinting: TextServer.Hinting): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetHinting is not implemented.")
  }

  /**
   * Returns the font hinting mode. Used by dynamic fonts only.
   */
  public open fun _fontGetHinting(fontRid: RID): TextServer.Hinting {
    throw NotImplementedError("TextServerExtension::_fontGetHinting is not implemented.")
  }

  /**
   * Sets font subpixel glyph positioning mode.
   */
  public open fun _fontSetSubpixelPositioning(fontRid: RID,
      subpixelPositioning: TextServer.SubpixelPositioning): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetSubpixelPositioning is not implemented.")
  }

  /**
   * Returns font subpixel glyph positioning mode.
   */
  public open fun _fontGetSubpixelPositioning(fontRid: RID): TextServer.SubpixelPositioning {
    throw NotImplementedError("TextServerExtension::_fontGetSubpixelPositioning is not implemented.")
  }

  /**
   * Sets glyph position rounding behavior. If set to `true`, when aligning glyphs to the pixel
   * boundaries rounding remainders are accumulated to ensure more uniform glyph distribution. This
   * setting has no effect if subpixel positioning is enabled.
   */
  public open fun _fontSetKeepRoundingRemainders(fontRid: RID, keepRoundingRemainders: Boolean):
      Unit {
    throw NotImplementedError("TextServerExtension::_fontSetKeepRoundingRemainders is not implemented.")
  }

  /**
   * Returns glyph position rounding behavior. If set to `true`, when aligning glyphs to the pixel
   * boundaries rounding remainders are accumulated to ensure more uniform glyph distribution. This
   * setting has no effect if subpixel positioning is enabled.
   */
  public open fun _fontGetKeepRoundingRemainders(fontRid: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_fontGetKeepRoundingRemainders is not implemented.")
  }

  /**
   * Sets font embolden strength. If [strength] is not equal to zero, emboldens the font outlines.
   * Negative values reduce the outline thickness.
   */
  public open fun _fontSetEmbolden(fontRid: RID, strength: Double): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetEmbolden is not implemented.")
  }

  /**
   * Returns font embolden strength.
   */
  public open fun _fontGetEmbolden(fontRid: RID): Double {
    throw NotImplementedError("TextServerExtension::_fontGetEmbolden is not implemented.")
  }

  /**
   * Sets the spacing for [spacing] to [value] in pixels (not relative to the font size).
   */
  public open fun _fontSetSpacing(
    fontRid: RID,
    spacing: TextServer.SpacingType,
    `value`: Long,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetSpacing is not implemented.")
  }

  /**
   * Returns the spacing for [spacing] in pixels (not relative to the font size).
   */
  public open fun _fontGetSpacing(fontRid: RID, spacing: TextServer.SpacingType): Long {
    throw NotImplementedError("TextServerExtension::_fontGetSpacing is not implemented.")
  }

  /**
   * Sets extra baseline offset (as a fraction of font height).
   */
  public open fun _fontSetBaselineOffset(fontRid: RID, baselineOffset: Double): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetBaselineOffset is not implemented.")
  }

  /**
   * Returns extra baseline offset (as a fraction of font height).
   */
  public open fun _fontGetBaselineOffset(fontRid: RID): Double {
    throw NotImplementedError("TextServerExtension::_fontGetBaselineOffset is not implemented.")
  }

  /**
   * Sets 2D transform, applied to the font outlines, can be used for slanting, flipping, and
   * rotating glyphs.
   */
  public open fun _fontSetTransform(fontRid: RID, transform: Transform2D): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetTransform is not implemented.")
  }

  /**
   * Returns 2D transform applied to the font outlines.
   */
  public open fun _fontGetTransform(fontRid: RID): Transform2D {
    throw NotImplementedError("TextServerExtension::_fontGetTransform is not implemented.")
  }

  /**
   * Sets variation coordinates for the specified font cache entry.
   */
  public open fun _fontSetVariationCoordinates(fontRid: RID,
      variationCoordinates: Dictionary<Any?, Any?>): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetVariationCoordinates is not implemented.")
  }

  /**
   * Returns variation coordinates for the specified font cache entry.
   */
  public open fun _fontGetVariationCoordinates(fontRid: RID): Dictionary<Any?, Any?> {
    throw NotImplementedError("TextServerExtension::_fontGetVariationCoordinates is not implemented.")
  }

  /**
   * If set to a positive value, overrides the oversampling factor of the viewport this font is used
   * in. See [Viewport.oversampling]. This value doesn't override the [code
   * skip-lint]oversampling[/code] parameter of [code skip-lint]draw_*[/code] methods. Used by dynamic
   * fonts only.
   */
  public open fun _fontSetOversampling(fontRid: RID, oversampling: Double): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetOversampling is not implemented.")
  }

  /**
   * Returns oversampling factor override. If set to a positive value, overrides the oversampling
   * factor of the viewport this font is used in. See [Viewport.oversampling]. This value doesn't
   * override the [code skip-lint]oversampling[/code] parameter of [code skip-lint]draw_*[/code]
   * methods. Used by dynamic fonts only.
   */
  public open fun _fontGetOversampling(fontRid: RID): Double {
    throw NotImplementedError("TextServerExtension::_fontGetOversampling is not implemented.")
  }

  /**
   * Returns list of the font sizes in the cache. Each size is [Vector2i] with font size and outline
   * size.
   */
  public abstract fun _fontGetSizeCacheList(fontRid: RID): VariantArray<Vector2i>

  /**
   * Removes all font sizes from the cache entry.
   */
  public abstract fun _fontClearSizeCache(fontRid: RID): Unit

  /**
   * Removes specified font size from the cache entry.
   */
  public abstract fun _fontRemoveSizeCache(fontRid: RID, size: Vector2i): Unit

  /**
   * Returns font cache information, each entry contains the following fields: `Vector2i size_px` -
   * font size in pixels, `float viewport_oversampling` - viewport oversampling factor, `int glyphs` -
   * number of rendered glyphs, `int textures` - number of used textures, `int textures_size` - size of
   * texture data in bytes.
   */
  public open fun _fontGetSizeCacheInfo(fontRid: RID): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("TextServerExtension::_fontGetSizeCacheInfo is not implemented.")
  }

  /**
   * Sets the font ascent (number of pixels above the baseline).
   */
  public abstract fun _fontSetAscent(
    fontRid: RID,
    size: Long,
    ascent: Double,
  ): Unit

  /**
   * Returns the font ascent (number of pixels above the baseline).
   */
  public abstract fun _fontGetAscent(fontRid: RID, size: Long): Double

  /**
   * Sets the font descent (number of pixels below the baseline).
   */
  public abstract fun _fontSetDescent(
    fontRid: RID,
    size: Long,
    descent: Double,
  ): Unit

  /**
   * Returns the font descent (number of pixels below the baseline).
   */
  public abstract fun _fontGetDescent(fontRid: RID, size: Long): Double

  /**
   * Sets pixel offset of the underline below the baseline.
   */
  public abstract fun _fontSetUnderlinePosition(
    fontRid: RID,
    size: Long,
    underlinePosition: Double,
  ): Unit

  /**
   * Returns pixel offset of the underline below the baseline.
   */
  public abstract fun _fontGetUnderlinePosition(fontRid: RID, size: Long): Double

  /**
   * Sets thickness of the underline in pixels.
   */
  public abstract fun _fontSetUnderlineThickness(
    fontRid: RID,
    size: Long,
    underlineThickness: Double,
  ): Unit

  /**
   * Returns thickness of the underline in pixels.
   */
  public abstract fun _fontGetUnderlineThickness(fontRid: RID, size: Long): Double

  /**
   * Sets scaling factor of the color bitmap font.
   */
  public abstract fun _fontSetScale(
    fontRid: RID,
    size: Long,
    scale: Double,
  ): Unit

  /**
   * Returns scaling factor of the color bitmap font.
   */
  public abstract fun _fontGetScale(fontRid: RID, size: Long): Double

  /**
   * Returns number of textures used by font cache entry.
   */
  public abstract fun _fontGetTextureCount(fontRid: RID, size: Vector2i): Long

  /**
   * Removes all textures from font cache entry.
   */
  public abstract fun _fontClearTextures(fontRid: RID, size: Vector2i): Unit

  /**
   * Removes specified texture from the cache entry.
   */
  public abstract fun _fontRemoveTexture(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
  ): Unit

  /**
   * Sets font cache texture image data.
   */
  public abstract fun _fontSetTextureImage(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
    image: Image?,
  ): Unit

  /**
   * Returns font cache texture image data.
   */
  public abstract fun _fontGetTextureImage(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
  ): Image?

  /**
   * Sets array containing glyph packing data.
   */
  public open fun _fontSetTextureOffsets(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
    offset: PackedInt32Array,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetTextureOffsets is not implemented.")
  }

  /**
   * Returns array containing glyph packing data.
   */
  public open fun _fontGetTextureOffsets(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
  ): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_fontGetTextureOffsets is not implemented.")
  }

  /**
   * Returns list of rendered glyphs in the cache entry.
   */
  public abstract fun _fontGetGlyphList(fontRid: RID, size: Vector2i): PackedInt32Array

  /**
   * Removes all rendered glyph information from the cache entry.
   */
  public abstract fun _fontClearGlyphs(fontRid: RID, size: Vector2i): Unit

  /**
   * Removes specified rendered glyph information from the cache entry.
   */
  public abstract fun _fontRemoveGlyph(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Unit

  /**
   * Returns glyph advance (offset of the next glyph).
   */
  public abstract fun _fontGetGlyphAdvance(
    fontRid: RID,
    size: Long,
    glyph: Long,
  ): Vector2

  /**
   * Sets glyph advance (offset of the next glyph).
   */
  public abstract fun _fontSetGlyphAdvance(
    fontRid: RID,
    size: Long,
    glyph: Long,
    advance: Vector2,
  ): Unit

  /**
   * Returns glyph offset from the baseline.
   */
  public abstract fun _fontGetGlyphOffset(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2

  /**
   * Sets glyph offset from the baseline.
   */
  public abstract fun _fontSetGlyphOffset(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    offset: Vector2,
  ): Unit

  /**
   * Returns size of the glyph.
   */
  public abstract fun _fontGetGlyphSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2

  /**
   * Sets size of the glyph.
   */
  public abstract fun _fontSetGlyphSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    glSize: Vector2,
  ): Unit

  /**
   * Returns rectangle in the cache texture containing the glyph.
   */
  public abstract fun _fontGetGlyphUvRect(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Rect2

  /**
   * Sets rectangle in the cache texture containing the glyph.
   */
  public abstract fun _fontSetGlyphUvRect(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    uvRect: Rect2,
  ): Unit

  /**
   * Returns index of the cache texture containing the glyph.
   */
  public abstract fun _fontGetGlyphTextureIdx(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Long

  /**
   * Sets index of the cache texture containing the glyph.
   */
  public abstract fun _fontSetGlyphTextureIdx(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    textureIdx: Long,
  ): Unit

  /**
   * Returns resource ID of the cache texture containing the glyph.
   */
  public abstract fun _fontGetGlyphTextureRid(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): RID

  /**
   * Returns size of the cache texture containing the glyph.
   */
  public abstract fun _fontGetGlyphTextureSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2

  /**
   * Returns outline contours of the glyph.
   */
  public open fun _fontGetGlyphContours(
    fontRid: RID,
    size: Long,
    index: Long,
  ): Dictionary<Any?, Any?> {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphContours is not implemented.")
  }

  /**
   * Returns list of the kerning overrides.
   */
  public open fun _fontGetKerningList(fontRid: RID, size: Long): VariantArray<Vector2i> {
    throw NotImplementedError("TextServerExtension::_fontGetKerningList is not implemented.")
  }

  /**
   * Removes all kerning overrides.
   */
  public open fun _fontClearKerningMap(fontRid: RID, size: Long): Unit {
    throw NotImplementedError("TextServerExtension::_fontClearKerningMap is not implemented.")
  }

  /**
   * Removes kerning override for the pair of glyphs.
   */
  public open fun _fontRemoveKerning(
    fontRid: RID,
    size: Long,
    glyphPair: Vector2i,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontRemoveKerning is not implemented.")
  }

  /**
   * Sets kerning for the pair of glyphs.
   */
  public open fun _fontSetKerning(
    fontRid: RID,
    size: Long,
    glyphPair: Vector2i,
    kerning: Vector2,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetKerning is not implemented.")
  }

  /**
   * Returns kerning for the pair of glyphs.
   */
  public open fun _fontGetKerning(
    fontRid: RID,
    size: Long,
    glyphPair: Vector2i,
  ): Vector2 {
    throw NotImplementedError("TextServerExtension::_fontGetKerning is not implemented.")
  }

  /**
   * Returns the glyph index of a [char], optionally modified by the [variationSelector].
   */
  public abstract fun _fontGetGlyphIndex(
    fontRid: RID,
    size: Long,
    char: Long,
    variationSelector: Long,
  ): Long

  /**
   * Returns character code associated with [glyphIndex], or `0` if [glyphIndex] is invalid.
   */
  public abstract fun _fontGetCharFromGlyphIndex(
    fontRid: RID,
    size: Long,
    glyphIndex: Long,
  ): Long

  /**
   * Returns `true` if a Unicode [char] is available in the font.
   */
  public abstract fun _fontHasChar(fontRid: RID, char: Long): Boolean

  /**
   * Returns a string containing all the characters available in the font.
   */
  public abstract fun _fontGetSupportedChars(fontRid: RID): String

  /**
   * Returns an array containing all glyph indices in the font.
   */
  public abstract fun _fontGetSupportedGlyphs(fontRid: RID): PackedInt32Array

  /**
   * Renders the range of characters to the font cache texture.
   */
  public open fun _fontRenderRange(
    fontRid: RID,
    size: Vector2i,
    start: Long,
    end: Long,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontRenderRange is not implemented.")
  }

  /**
   * Renders specified glyph to the font cache texture.
   */
  public open fun _fontRenderGlyph(
    fontRid: RID,
    size: Vector2i,
    index: Long,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontRenderGlyph is not implemented.")
  }

  /**
   * Draws single glyph into a canvas item at the position, using [fontRid] at the size [size]. If
   * [oversampling] is greater than zero, it is used as font oversampling factor, otherwise viewport
   * oversampling settings are used.
   */
  public abstract fun _fontDrawGlyph(
    fontRid: RID,
    canvas: RID,
    size: Long,
    pos: Vector2,
    index: Long,
    color: Color,
    oversampling: Float,
  ): Unit

  /**
   * Draws single glyph outline of size [outlineSize] into a canvas item at the position, using
   * [fontRid] at the size [size]. If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   */
  public abstract fun _fontDrawGlyphOutline(
    fontRid: RID,
    canvas: RID,
    size: Long,
    outlineSize: Long,
    pos: Vector2,
    index: Long,
    color: Color,
    oversampling: Float,
  ): Unit

  /**
   * Returns `true` if the font supports the given language (as a
   * [url=https://en.wikipedia.org/wiki/ISO_639-1]ISO 639[/url] code).
   */
  public open fun _fontIsLanguageSupported(fontRid: RID, language: String): Boolean {
    throw NotImplementedError("TextServerExtension::_fontIsLanguageSupported is not implemented.")
  }

  /**
   * Adds override for [_fontIsLanguageSupported].
   */
  public open fun _fontSetLanguageSupportOverride(
    fontRid: RID,
    language: String,
    supported: Boolean,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetLanguageSupportOverride is not implemented.")
  }

  /**
   * Returns `true` if support override is enabled for the [language].
   */
  public open fun _fontGetLanguageSupportOverride(fontRid: RID, language: String): Boolean {
    throw NotImplementedError("TextServerExtension::_fontGetLanguageSupportOverride is not implemented.")
  }

  /**
   * Remove language support override.
   */
  public open fun _fontRemoveLanguageSupportOverride(fontRid: RID, language: String): Unit {
    throw NotImplementedError("TextServerExtension::_fontRemoveLanguageSupportOverride is not implemented.")
  }

  /**
   * Returns list of language support overrides.
   */
  public open fun _fontGetLanguageSupportOverrides(fontRid: RID): PackedStringArray {
    throw NotImplementedError("TextServerExtension::_fontGetLanguageSupportOverrides is not implemented.")
  }

  /**
   * Returns `true` if the font supports the given script (as a
   * [url=https://en.wikipedia.org/wiki/ISO_15924]ISO 15924[/url] code).
   */
  public open fun _fontIsScriptSupported(fontRid: RID, script: String): Boolean {
    throw NotImplementedError("TextServerExtension::_fontIsScriptSupported is not implemented.")
  }

  /**
   * Adds override for [_fontIsScriptSupported].
   */
  public open fun _fontSetScriptSupportOverride(
    fontRid: RID,
    script: String,
    supported: Boolean,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetScriptSupportOverride is not implemented.")
  }

  /**
   * Returns `true` if support override is enabled for the [script].
   */
  public open fun _fontGetScriptSupportOverride(fontRid: RID, script: String): Boolean {
    throw NotImplementedError("TextServerExtension::_fontGetScriptSupportOverride is not implemented.")
  }

  /**
   * Removes script support override.
   */
  public open fun _fontRemoveScriptSupportOverride(fontRid: RID, script: String): Unit {
    throw NotImplementedError("TextServerExtension::_fontRemoveScriptSupportOverride is not implemented.")
  }

  /**
   * Returns list of script support overrides.
   */
  public open fun _fontGetScriptSupportOverrides(fontRid: RID): PackedStringArray {
    throw NotImplementedError("TextServerExtension::_fontGetScriptSupportOverrides is not implemented.")
  }

  /**
   * Sets font OpenType feature set override.
   */
  public open fun _fontSetOpentypeFeatureOverrides(fontRid: RID, overrides: Dictionary<Any?, Any?>):
      Unit {
    throw NotImplementedError("TextServerExtension::_fontSetOpentypeFeatureOverrides is not implemented.")
  }

  /**
   * Returns font OpenType feature set override.
   */
  public open fun _fontGetOpentypeFeatureOverrides(fontRid: RID): Dictionary<Any?, Any?> {
    throw NotImplementedError("TextServerExtension::_fontGetOpentypeFeatureOverrides is not implemented.")
  }

  /**
   * Returns the dictionary of the supported OpenType features.
   */
  public open fun _fontSupportedFeatureList(fontRid: RID): Dictionary<Any?, Any?> {
    throw NotImplementedError("TextServerExtension::_fontSupportedFeatureList is not implemented.")
  }

  /**
   * Returns the dictionary of the supported OpenType variation coordinates.
   */
  public open fun _fontSupportedVariationList(fontRid: RID): Dictionary<Any?, Any?> {
    throw NotImplementedError("TextServerExtension::_fontSupportedVariationList is not implemented.")
  }

  /**
   * Returns the font oversampling factor, shared by all fonts in the TextServer.
   */
  public open fun _fontGetGlobalOversampling(): Double {
    throw NotImplementedError("TextServerExtension::_fontGetGlobalOversampling is not implemented.")
  }

  /**
   * Sets oversampling factor, shared by all font in the TextServer.
   */
  public open fun _fontSetGlobalOversampling(oversampling: Double): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetGlobalOversampling is not implemented.")
  }

  /**
   * Increases the reference count of the specified oversampling level. This method is called by
   * [Viewport], and should not be used directly.
   */
  public open fun _referenceOversamplingLevel(oversampling: Double): Unit {
    throw NotImplementedError("TextServerExtension::_referenceOversamplingLevel is not implemented.")
  }

  /**
   * Decreases the reference count of the specified oversampling level, and frees the font cache for
   * oversampling level when the reference count reaches zero. This method is called by [Viewport], and
   * should not be used directly.
   */
  public open fun _unreferenceOversamplingLevel(oversampling: Double): Unit {
    throw NotImplementedError("TextServerExtension::_unreferenceOversamplingLevel is not implemented.")
  }

  /**
   * Returns size of the replacement character (box with character hexadecimal code that is drawn in
   * place of invalid characters).
   */
  public open fun _getHexCodeBoxSize(size: Long, index: Long): Vector2 {
    throw NotImplementedError("TextServerExtension::_getHexCodeBoxSize is not implemented.")
  }

  /**
   * Draws box displaying character hexadecimal code.
   */
  public open fun _drawHexCodeBox(
    canvas: RID,
    size: Long,
    pos: Vector2,
    index: Long,
    color: Color,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_drawHexCodeBox is not implemented.")
  }

  /**
   * Creates a new buffer for complex text layout, with the given [direction] and [orientation].
   */
  public abstract fun _createShapedText(direction: TextServer.Direction,
      orientation: TextServer.Orientation): RID

  /**
   * Clears text buffer (removes text and inline objects).
   */
  public abstract fun _shapedTextClear(shaped: RID): Unit

  /**
   * Duplicates shaped text buffer.
   */
  public abstract fun _shapedTextDuplicate(shaped: RID): RID

  /**
   * Sets desired text direction. If set to [TextServer.DIRECTION_AUTO], direction will be detected
   * based on the buffer contents and current locale.
   */
  public open fun _shapedTextSetDirection(shaped: RID, direction: TextServer.Direction): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextSetDirection is not implemented.")
  }

  /**
   * Returns direction of the text.
   */
  public open fun _shapedTextGetDirection(shaped: RID): TextServer.Direction {
    throw NotImplementedError("TextServerExtension::_shapedTextGetDirection is not implemented.")
  }

  /**
   * Returns direction of the text, inferred by the BiDi algorithm.
   */
  public open fun _shapedTextGetInferredDirection(shaped: RID): TextServer.Direction {
    throw NotImplementedError("TextServerExtension::_shapedTextGetInferredDirection is not implemented.")
  }

  /**
   * Overrides BiDi for the structured text.
   */
  public open fun _shapedTextSetBidiOverride(shaped: RID, `override`: VariantArray<Any?>): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextSetBidiOverride is not implemented.")
  }

  /**
   * Sets custom punctuation character list, used for word breaking. If set to empty string, server
   * defaults are used.
   */
  public open fun _shapedTextSetCustomPunctuation(shaped: RID, punct: String): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextSetCustomPunctuation is not implemented.")
  }

  /**
   * Returns custom punctuation character list, used for word breaking. If set to empty string,
   * server defaults are used.
   */
  public open fun _shapedTextGetCustomPunctuation(shaped: RID): String {
    throw NotImplementedError("TextServerExtension::_shapedTextGetCustomPunctuation is not implemented.")
  }

  /**
   * Sets ellipsis character used for text clipping.
   */
  public open fun _shapedTextSetCustomEllipsis(shaped: RID, char: Long): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextSetCustomEllipsis is not implemented.")
  }

  /**
   * Returns ellipsis character used for text clipping.
   */
  public open fun _shapedTextGetCustomEllipsis(shaped: RID): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextGetCustomEllipsis is not implemented.")
  }

  /**
   * Sets desired text orientation.
   */
  public open fun _shapedTextSetOrientation(shaped: RID, orientation: TextServer.Orientation):
      Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextSetOrientation is not implemented.")
  }

  /**
   * Returns text orientation.
   */
  public open fun _shapedTextGetOrientation(shaped: RID): TextServer.Orientation {
    throw NotImplementedError("TextServerExtension::_shapedTextGetOrientation is not implemented.")
  }

  /**
   * If set to `true` text buffer will display invalid characters as hexadecimal codes, otherwise
   * nothing is displayed.
   */
  public open fun _shapedTextSetPreserveInvalid(shaped: RID, enabled: Boolean): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextSetPreserveInvalid is not implemented.")
  }

  /**
   * Returns `true` if text buffer is configured to display hexadecimal codes in place of invalid
   * characters.
   */
  public open fun _shapedTextGetPreserveInvalid(shaped: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextGetPreserveInvalid is not implemented.")
  }

  /**
   * If set to `true` text buffer will display control characters.
   */
  public open fun _shapedTextSetPreserveControl(shaped: RID, enabled: Boolean): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextSetPreserveControl is not implemented.")
  }

  /**
   * Returns `true` if text buffer is configured to display control characters.
   */
  public open fun _shapedTextGetPreserveControl(shaped: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextGetPreserveControl is not implemented.")
  }

  /**
   * Sets extra spacing added between glyphs or lines in pixels.
   */
  public open fun _shapedTextSetSpacing(
    shaped: RID,
    spacing: TextServer.SpacingType,
    `value`: Long,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextSetSpacing is not implemented.")
  }

  /**
   * Returns extra spacing added between glyphs or lines in pixels.
   */
  public open fun _shapedTextGetSpacing(shaped: RID, spacing: TextServer.SpacingType): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextGetSpacing is not implemented.")
  }

  /**
   * Adds text span and font to draw it to the text buffer.
   */
  public abstract fun _shapedTextAddString(
    shaped: RID,
    text: String,
    fonts: VariantArray<RID>,
    size: Long,
    opentypeFeatures: Dictionary<Any?, Any?>,
    language: String,
    meta: Any?,
  ): Boolean

  /**
   * Adds inline object to the text buffer, [key] must be unique. In the text, object is represented
   * as [length] object replacement characters.
   */
  public abstract fun _shapedTextAddObject(
    shaped: RID,
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment,
    length: Long,
    baseline: Double,
  ): Boolean

  /**
   * Sets new size and alignment of embedded object.
   */
  public abstract fun _shapedTextResizeObject(
    shaped: RID,
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment,
    baseline: Double,
  ): Boolean

  /**
   * Returns `true` if an object with [key] is embedded in this shaped text buffer.
   */
  public abstract fun _shapedTextHasObject(shaped: RID, key: Any?): Boolean

  /**
   * Returns the text buffer source text, including object replacement characters.
   */
  public abstract fun _shapedGetText(shaped: RID): String

  /**
   * Returns number of text spans added using [_shapedTextAddString] or [_shapedTextAddObject].
   */
  public abstract fun _shapedGetSpanCount(shaped: RID): Long

  /**
   * Returns text span metadata.
   */
  public abstract fun _shapedGetSpanMeta(shaped: RID, index: Long): Any?

  /**
   * Returns text embedded object key.
   */
  public abstract fun _shapedGetSpanEmbeddedObject(shaped: RID, index: Long): Any?

  /**
   * Returns the text span source text.
   */
  public abstract fun _shapedGetSpanText(shaped: RID, index: Long): String

  /**
   * Returns the text span embedded object key.
   */
  public abstract fun _shapedGetSpanObject(shaped: RID, index: Long): Any?

  /**
   * Changes text span font, font size, and OpenType features, without changing the text.
   */
  public abstract fun _shapedSetSpanUpdateFont(
    shaped: RID,
    index: Long,
    fonts: VariantArray<RID>,
    size: Long,
    opentypeFeatures: Dictionary<Any?, Any?>,
  ): Unit

  /**
   * Returns the number of uniform text runs in the buffer.
   */
  public open fun _shapedGetRunCount(shaped: RID): Long {
    throw NotImplementedError("TextServerExtension::_shapedGetRunCount is not implemented.")
  }

  /**
   * Returns the source text of the [index] text run (in visual order).
   */
  public open fun _shapedGetRunText(shaped: RID, index: Long): String {
    throw NotImplementedError("TextServerExtension::_shapedGetRunText is not implemented.")
  }

  /**
   * Returns the source text range of the [index] text run (in visual order).
   */
  public open fun _shapedGetRunRange(shaped: RID, index: Long): Vector2i {
    throw NotImplementedError("TextServerExtension::_shapedGetRunRange is not implemented.")
  }

  /**
   * Returns the glyph range of the [index] text run (in visual order).
   */
  public open fun _shapedGetRunGlyphRange(shaped: RID, index: Long): Vector2i {
    throw NotImplementedError("TextServerExtension::_shapedGetRunGlyphRange is not implemented.")
  }

  /**
   * Returns the font RID of the [index] text run (in visual order).
   */
  public open fun _shapedGetRunFontRid(shaped: RID, index: Long): RID {
    throw NotImplementedError("TextServerExtension::_shapedGetRunFontRid is not implemented.")
  }

  /**
   * Returns the font size of the [index] text run (in visual order).
   */
  public open fun _shapedGetRunFontSize(shaped: RID, index: Long): Int {
    throw NotImplementedError("TextServerExtension::_shapedGetRunFontSize is not implemented.")
  }

  /**
   * Returns the language of the [index] text run (in visual order).
   */
  public open fun _shapedGetRunLanguage(shaped: RID, index: Long): String {
    throw NotImplementedError("TextServerExtension::_shapedGetRunLanguage is not implemented.")
  }

  /**
   * Returns the direction of the [index] text run (in visual order).
   */
  public open fun _shapedGetRunDirection(shaped: RID, index: Long): TextServer.Direction {
    throw NotImplementedError("TextServerExtension::_shapedGetRunDirection is not implemented.")
  }

  /**
   * Returns the embedded object of the [index] text run (in visual order).
   */
  public open fun _shapedGetRunObject(shaped: RID, index: Long): Any? {
    throw NotImplementedError("TextServerExtension::_shapedGetRunObject is not implemented.")
  }

  /**
   * Returns text buffer for the substring of the text in the [shaped] text buffer (including inline
   * objects).
   */
  public abstract fun _shapedTextSubstr(
    shaped: RID,
    start: Long,
    length: Long,
  ): RID

  /**
   * Returns the parent buffer from which the substring originates.
   */
  public abstract fun _shapedTextGetParent(shaped: RID): RID

  /**
   * Adjusts text width to fit to specified width, returns new text width.
   */
  public open fun _shapedTextFitToWidth(
    shaped: RID,
    width: Double,
    justificationFlags: TextServer.JustificationFlag,
  ): Double {
    throw NotImplementedError("TextServerExtension::_shapedTextFitToWidth is not implemented.")
  }

  /**
   * Aligns shaped text to the given tab-stops.
   */
  public open fun _shapedTextTabAlign(shaped: RID, tabStops: PackedFloat32Array): Double {
    throw NotImplementedError("TextServerExtension::_shapedTextTabAlign is not implemented.")
  }

  /**
   * Shapes buffer if it's not shaped. Returns `true` if the string is shaped successfully.
   */
  public abstract fun _shapedTextShape(shaped: RID): Boolean

  /**
   * Updates break points in the shaped text. This method is called by default implementation of
   * text breaking functions.
   */
  public open fun _shapedTextUpdateBreaks(shaped: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextUpdateBreaks is not implemented.")
  }

  /**
   * Updates justification points in the shaped text. This method is called by default
   * implementation of text justification functions.
   */
  public open fun _shapedTextUpdateJustificationOps(shaped: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextUpdateJustificationOps is not implemented.")
  }

  /**
   * Returns `true` if buffer is successfully shaped.
   */
  public abstract fun _shapedTextIsReady(shaped: RID): Boolean

  /**
   * Returns number of glyphs in the buffer.
   */
  public abstract fun _shapedTextGetGlyphCount(shaped: RID): Long

  /**
   * Returns substring buffer character range in the parent buffer.
   */
  public abstract fun _shapedTextGetRange(shaped: RID): Vector2i

  /**
   * Breaks text to the lines and columns. Returns character ranges for each segment.
   */
  public open fun _shapedTextGetLineBreaksAdv(
    shaped: RID,
    width: PackedFloat32Array,
    start: Long,
    once: Boolean,
    breakFlags: TextServer.LineBreakFlag,
  ): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_shapedTextGetLineBreaksAdv is not implemented.")
  }

  /**
   * Breaks text to the lines and returns character ranges for each line.
   */
  public open fun _shapedTextGetLineBreaks(
    shaped: RID,
    width: Double,
    start: Long,
    breakFlags: TextServer.LineBreakFlag,
  ): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_shapedTextGetLineBreaks is not implemented.")
  }

  /**
   * Breaks text into words and returns array of character ranges. Use [graphemeFlags] to set what
   * characters are used for breaking.
   */
  public open fun _shapedTextGetWordBreaks(
    shaped: RID,
    graphemeFlags: TextServer.GraphemeFlag,
    skipGraphemeFlags: TextServer.GraphemeFlag,
  ): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_shapedTextGetWordBreaks is not implemented.")
  }

  /**
   * Returns the position of the overrun trim.
   */
  public abstract fun _shapedTextGetTrimPos(shaped: RID): Long

  /**
   * Returns position of the ellipsis.
   */
  public abstract fun _shapedTextGetEllipsisPos(shaped: RID): Long

  /**
   * Returns number of glyphs in the ellipsis.
   */
  public abstract fun _shapedTextGetEllipsisGlyphCount(shaped: RID): Long

  /**
   * Trims text if it exceeds the given width.
   */
  public open fun _shapedTextOverrunTrimToWidth(
    shaped: RID,
    width: Double,
    trimFlags: TextServer.TextOverrunFlag,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextOverrunTrimToWidth is not implemented.")
  }

  /**
   * Returns array of inline objects.
   */
  public abstract fun _shapedTextGetObjects(shaped: RID): VariantArray<Any?>

  /**
   * Returns bounding rectangle of the inline object.
   */
  public abstract fun _shapedTextGetObjectRect(shaped: RID, key: Any?): Rect2

  /**
   * Returns the character range of the inline object.
   */
  public abstract fun _shapedTextGetObjectRange(shaped: RID, key: Any?): Vector2i

  /**
   * Returns the glyph index of the inline object.
   */
  public abstract fun _shapedTextGetObjectGlyph(shaped: RID, key: Any?): Long

  /**
   * Returns size of the text.
   */
  public abstract fun _shapedTextGetSize(shaped: RID): Vector2

  /**
   * Returns the text ascent (number of pixels above the baseline for horizontal layout or to the
   * left of baseline for vertical).
   */
  public abstract fun _shapedTextGetAscent(shaped: RID): Double

  /**
   * Returns the text descent (number of pixels below the baseline for horizontal layout or to the
   * right of baseline for vertical).
   */
  public abstract fun _shapedTextGetDescent(shaped: RID): Double

  /**
   * Returns width (for horizontal layout) or height (for vertical) of the text.
   */
  public abstract fun _shapedTextGetWidth(shaped: RID): Double

  /**
   * Returns pixel offset of the underline below the baseline.
   */
  public abstract fun _shapedTextGetUnderlinePosition(shaped: RID): Double

  /**
   * Returns thickness of the underline.
   */
  public abstract fun _shapedTextGetUnderlineThickness(shaped: RID): Double

  /**
   * Returns dominant direction of in the range of text.
   */
  public open fun _shapedTextGetDominantDirectionInRange(
    shaped: RID,
    start: Long,
    end: Long,
  ): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextGetDominantDirectionInRange is not implemented.")
  }

  /**
   * Returns selection rectangles for the specified character range.
   */
  public open fun _shapedTextGetSelection(
    shaped: RID,
    start: Long,
    end: Long,
  ): PackedVector2Array {
    throw NotImplementedError("TextServerExtension::_shapedTextGetSelection is not implemented.")
  }

  /**
   * Returns grapheme index at the specified pixel offset at the baseline, or `-1` if none is found.
   */
  public open fun _shapedTextHitTestGrapheme(shaped: RID, coord: Double): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextHitTestGrapheme is not implemented.")
  }

  /**
   * Returns caret character offset at the specified pixel offset at the baseline. This function
   * always returns a valid position.
   */
  public open fun _shapedTextHitTestPosition(shaped: RID, coord: Double): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextHitTestPosition is not implemented.")
  }

  /**
   * Draw shaped text into a canvas item at a given position, with [color]. [pos] specifies the
   * leftmost point of the baseline (for horizontal layout) or topmost point of the baseline (for
   * vertical layout). If [oversampling] is greater than zero, it is used as font oversampling factor,
   * otherwise viewport oversampling settings are used.
   */
  public open fun _shapedTextDraw(
    shaped: RID,
    canvas: RID,
    pos: Vector2,
    clipL: Double,
    clipR: Double,
    color: Color,
    oversampling: Float,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextDraw is not implemented.")
  }

  /**
   * Draw the outline of the shaped text into a canvas item at a given position, with [color]. [pos]
   * specifies the leftmost point of the baseline (for horizontal layout) or topmost point of the
   * baseline (for vertical layout). If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   */
  public open fun _shapedTextDrawOutline(
    shaped: RID,
    canvas: RID,
    pos: Vector2,
    clipL: Double,
    clipR: Double,
    outlineSize: Long,
    color: Color,
    oversampling: Float,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextDrawOutline is not implemented.")
  }

  /**
   * Returns composite character's bounds as offsets from the start of the line.
   */
  public open fun _shapedTextGetGraphemeBounds(shaped: RID, pos: Long): Vector2 {
    throw NotImplementedError("TextServerExtension::_shapedTextGetGraphemeBounds is not implemented.")
  }

  /**
   * Returns grapheme end position closest to the [pos].
   */
  public open fun _shapedTextNextGraphemePos(shaped: RID, pos: Long): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextNextGraphemePos is not implemented.")
  }

  /**
   * Returns grapheme start position closest to the [pos].
   */
  public open fun _shapedTextPrevGraphemePos(shaped: RID, pos: Long): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextPrevGraphemePos is not implemented.")
  }

  /**
   * Returns array of the composite character boundaries.
   */
  public open fun _shapedTextGetCharacterBreaks(shaped: RID): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_shapedTextGetCharacterBreaks is not implemented.")
  }

  /**
   * Returns composite character end position closest to the [pos].
   */
  public open fun _shapedTextNextCharacterPos(shaped: RID, pos: Long): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextNextCharacterPos is not implemented.")
  }

  /**
   * Returns composite character start position closest to the [pos].
   */
  public open fun _shapedTextPrevCharacterPos(shaped: RID, pos: Long): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextPrevCharacterPos is not implemented.")
  }

  /**
   * Returns composite character position closest to the [pos].
   */
  public open fun _shapedTextClosestCharacterPos(shaped: RID, pos: Long): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextClosestCharacterPos is not implemented.")
  }

  /**
   * Converts a number from Western Arabic (0..9) to the numeral system used in the given
   * [language].
   *
   * If [language] is an empty string, the active locale will be used.
   */
  public open fun _formatNumber(number: String, language: String): String {
    throw NotImplementedError("TextServerExtension::_formatNumber is not implemented.")
  }

  /**
   * Converts [number] from the numeral system used in the given [language] to Western Arabic
   * (0..9).
   *
   * If [language] is an empty string, the active locale will be used.
   */
  public open fun _parseNumber(number: String, language: String): String {
    throw NotImplementedError("TextServerExtension::_parseNumber is not implemented.")
  }

  /**
   * Returns percent sign used in the given [language].
   */
  public open fun _percentSign(language: String): String {
    throw NotImplementedError("TextServerExtension::_percentSign is not implemented.")
  }

  /**
   * Strips diacritics from the string.
   */
  public open fun _stripDiacritics(string: String): String {
    throw NotImplementedError("TextServerExtension::_stripDiacritics is not implemented.")
  }

  /**
   * Returns `true` if [string] is a valid identifier.
   */
  public open fun _isValidIdentifier(string: String): Boolean {
    throw NotImplementedError("TextServerExtension::_isValidIdentifier is not implemented.")
  }

  public open fun _isValidLetter(unicode: Long): Boolean {
    throw NotImplementedError("TextServerExtension::_isValidLetter is not implemented.")
  }

  /**
   * Returns an array of the word break boundaries. Elements in the returned array are the offsets
   * of the start and end of words. Therefore the length of the array is always even.
   */
  public open fun _stringGetWordBreaks(
    string: String,
    language: String,
    charsPerLine: Long,
  ): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_stringGetWordBreaks is not implemented.")
  }

  /**
   * Returns array of the composite character boundaries.
   */
  public open fun _stringGetCharacterBreaks(string: String, language: String): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_stringGetCharacterBreaks is not implemented.")
  }

  /**
   * Returns index of the first string in [dict] which is visually confusable with the [string], or
   * `-1` if none is found.
   */
  public open fun _isConfusable(string: String, dict: PackedStringArray): Long {
    throw NotImplementedError("TextServerExtension::_isConfusable is not implemented.")
  }

  /**
   * Returns `true` if [string] is likely to be an attempt at confusing the reader.
   */
  public open fun _spoofCheck(string: String): Boolean {
    throw NotImplementedError("TextServerExtension::_spoofCheck is not implemented.")
  }

  /**
   * Returns the string converted to `UPPERCASE`.
   */
  public open fun _stringToUpper(string: String, language: String): String {
    throw NotImplementedError("TextServerExtension::_stringToUpper is not implemented.")
  }

  /**
   * Returns the string converted to `lowercase`.
   */
  public open fun _stringToLower(string: String, language: String): String {
    throw NotImplementedError("TextServerExtension::_stringToLower is not implemented.")
  }

  /**
   * Returns the string converted to `Title Case`.
   */
  public open fun _stringToTitle(string: String, language: String): String {
    throw NotImplementedError("TextServerExtension::_stringToTitle is not implemented.")
  }

  /**
   * Default implementation of the BiDi algorithm override function.
   */
  public open fun _parseStructuredText(
    parserType: TextServer.StructuredTextParser,
    args: VariantArray<Any?>,
    text: String,
  ): VariantArray<Vector3i> {
    throw NotImplementedError("TextServerExtension::_parseStructuredText is not implemented.")
  }

  /**
   * This method is called before text server is unregistered.
   */
  public open fun _cleanup(): Unit {
    throw NotImplementedError("TextServerExtension::_cleanup is not implemented.")
  }

  public companion object

  public object MethodBindings
}

@GodotBaseType
internal class TextServerExtensionDummy : TextServerExtension() {
  public override fun _hasFeature(feature: TextServer.Feature): Boolean {
    throw NotImplementedError("TextServerExtension::_hasFeature is only implemented by non-JVM code.")
  }

  public override fun _getName(): String {
    throw NotImplementedError("TextServerExtension::_getName is only implemented by non-JVM code.")
  }

  public override fun _getFeatures(): Long {
    throw NotImplementedError("TextServerExtension::_getFeatures is only implemented by non-JVM code.")
  }

  public override fun _freeRid(rid: RID): Unit {
    throw NotImplementedError("TextServerExtension::_freeRid is only implemented by non-JVM code.")
  }

  public override fun _has(rid: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_has is only implemented by non-JVM code.")
  }

  public override fun _createFont(): RID {
    throw NotImplementedError("TextServerExtension::_createFont is only implemented by non-JVM code.")
  }

  public override fun _fontSetFixedSize(fontRid: RID, fixedSize: Long): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetFixedSize is only implemented by non-JVM code.")
  }

  public override fun _fontGetFixedSize(fontRid: RID): Long {
    throw NotImplementedError("TextServerExtension::_fontGetFixedSize is only implemented by non-JVM code.")
  }

  public override fun _fontSetFixedSizeScaleMode(fontRid: RID,
      fixedSizeScaleMode: TextServer.FixedSizeScaleMode): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetFixedSizeScaleMode is only implemented by non-JVM code.")
  }

  public override fun _fontGetFixedSizeScaleMode(fontRid: RID): TextServer.FixedSizeScaleMode {
    throw NotImplementedError("TextServerExtension::_fontGetFixedSizeScaleMode is only implemented by non-JVM code.")
  }

  public override fun _fontGetSizeCacheList(fontRid: RID): VariantArray<Vector2i> {
    throw NotImplementedError("TextServerExtension::_fontGetSizeCacheList is only implemented by non-JVM code.")
  }

  public override fun _fontClearSizeCache(fontRid: RID): Unit {
    throw NotImplementedError("TextServerExtension::_fontClearSizeCache is only implemented by non-JVM code.")
  }

  public override fun _fontRemoveSizeCache(fontRid: RID, size: Vector2i): Unit {
    throw NotImplementedError("TextServerExtension::_fontRemoveSizeCache is only implemented by non-JVM code.")
  }

  public override fun _fontSetAscent(
    fontRid: RID,
    size: Long,
    ascent: Double,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetAscent is only implemented by non-JVM code.")
  }

  public override fun _fontGetAscent(fontRid: RID, size: Long): Double {
    throw NotImplementedError("TextServerExtension::_fontGetAscent is only implemented by non-JVM code.")
  }

  public override fun _fontSetDescent(
    fontRid: RID,
    size: Long,
    descent: Double,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetDescent is only implemented by non-JVM code.")
  }

  public override fun _fontGetDescent(fontRid: RID, size: Long): Double {
    throw NotImplementedError("TextServerExtension::_fontGetDescent is only implemented by non-JVM code.")
  }

  public override fun _fontSetUnderlinePosition(
    fontRid: RID,
    size: Long,
    underlinePosition: Double,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetUnderlinePosition is only implemented by non-JVM code.")
  }

  public override fun _fontGetUnderlinePosition(fontRid: RID, size: Long): Double {
    throw NotImplementedError("TextServerExtension::_fontGetUnderlinePosition is only implemented by non-JVM code.")
  }

  public override fun _fontSetUnderlineThickness(
    fontRid: RID,
    size: Long,
    underlineThickness: Double,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetUnderlineThickness is only implemented by non-JVM code.")
  }

  public override fun _fontGetUnderlineThickness(fontRid: RID, size: Long): Double {
    throw NotImplementedError("TextServerExtension::_fontGetUnderlineThickness is only implemented by non-JVM code.")
  }

  public override fun _fontSetScale(
    fontRid: RID,
    size: Long,
    scale: Double,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetScale is only implemented by non-JVM code.")
  }

  public override fun _fontGetScale(fontRid: RID, size: Long): Double {
    throw NotImplementedError("TextServerExtension::_fontGetScale is only implemented by non-JVM code.")
  }

  public override fun _fontGetTextureCount(fontRid: RID, size: Vector2i): Long {
    throw NotImplementedError("TextServerExtension::_fontGetTextureCount is only implemented by non-JVM code.")
  }

  public override fun _fontClearTextures(fontRid: RID, size: Vector2i): Unit {
    throw NotImplementedError("TextServerExtension::_fontClearTextures is only implemented by non-JVM code.")
  }

  public override fun _fontRemoveTexture(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontRemoveTexture is only implemented by non-JVM code.")
  }

  public override fun _fontSetTextureImage(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
    image: Image?,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetTextureImage is only implemented by non-JVM code.")
  }

  public override fun _fontGetTextureImage(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
  ): Image? {
    throw NotImplementedError("TextServerExtension::_fontGetTextureImage is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphList(fontRid: RID, size: Vector2i): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphList is only implemented by non-JVM code.")
  }

  public override fun _fontClearGlyphs(fontRid: RID, size: Vector2i): Unit {
    throw NotImplementedError("TextServerExtension::_fontClearGlyphs is only implemented by non-JVM code.")
  }

  public override fun _fontRemoveGlyph(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontRemoveGlyph is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphAdvance(
    fontRid: RID,
    size: Long,
    glyph: Long,
  ): Vector2 {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphAdvance is only implemented by non-JVM code.")
  }

  public override fun _fontSetGlyphAdvance(
    fontRid: RID,
    size: Long,
    glyph: Long,
    advance: Vector2,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetGlyphAdvance is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphOffset(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2 {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphOffset is only implemented by non-JVM code.")
  }

  public override fun _fontSetGlyphOffset(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    offset: Vector2,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetGlyphOffset is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2 {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphSize is only implemented by non-JVM code.")
  }

  public override fun _fontSetGlyphSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    glSize: Vector2,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetGlyphSize is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphUvRect(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Rect2 {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphUvRect is only implemented by non-JVM code.")
  }

  public override fun _fontSetGlyphUvRect(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    uvRect: Rect2,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetGlyphUvRect is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphTextureIdx(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Long {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphTextureIdx is only implemented by non-JVM code.")
  }

  public override fun _fontSetGlyphTextureIdx(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    textureIdx: Long,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontSetGlyphTextureIdx is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphTextureRid(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): RID {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphTextureRid is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphTextureSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2 {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphTextureSize is only implemented by non-JVM code.")
  }

  public override fun _fontGetGlyphIndex(
    fontRid: RID,
    size: Long,
    char: Long,
    variationSelector: Long,
  ): Long {
    throw NotImplementedError("TextServerExtension::_fontGetGlyphIndex is only implemented by non-JVM code.")
  }

  public override fun _fontGetCharFromGlyphIndex(
    fontRid: RID,
    size: Long,
    glyphIndex: Long,
  ): Long {
    throw NotImplementedError("TextServerExtension::_fontGetCharFromGlyphIndex is only implemented by non-JVM code.")
  }

  public override fun _fontHasChar(fontRid: RID, char: Long): Boolean {
    throw NotImplementedError("TextServerExtension::_fontHasChar is only implemented by non-JVM code.")
  }

  public override fun _fontGetSupportedChars(fontRid: RID): String {
    throw NotImplementedError("TextServerExtension::_fontGetSupportedChars is only implemented by non-JVM code.")
  }

  public override fun _fontGetSupportedGlyphs(fontRid: RID): PackedInt32Array {
    throw NotImplementedError("TextServerExtension::_fontGetSupportedGlyphs is only implemented by non-JVM code.")
  }

  public override fun _fontDrawGlyph(
    fontRid: RID,
    canvas: RID,
    size: Long,
    pos: Vector2,
    index: Long,
    color: Color,
    oversampling: Float,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontDrawGlyph is only implemented by non-JVM code.")
  }

  public override fun _fontDrawGlyphOutline(
    fontRid: RID,
    canvas: RID,
    size: Long,
    outlineSize: Long,
    pos: Vector2,
    index: Long,
    color: Color,
    oversampling: Float,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_fontDrawGlyphOutline is only implemented by non-JVM code.")
  }

  public override fun _createShapedText(direction: TextServer.Direction,
      orientation: TextServer.Orientation): RID {
    throw NotImplementedError("TextServerExtension::_createShapedText is only implemented by non-JVM code.")
  }

  public override fun _shapedTextClear(shaped: RID): Unit {
    throw NotImplementedError("TextServerExtension::_shapedTextClear is only implemented by non-JVM code.")
  }

  public override fun _shapedTextDuplicate(shaped: RID): RID {
    throw NotImplementedError("TextServerExtension::_shapedTextDuplicate is only implemented by non-JVM code.")
  }

  public override fun _shapedTextAddString(
    shaped: RID,
    text: String,
    fonts: VariantArray<RID>,
    size: Long,
    opentypeFeatures: Dictionary<Any?, Any?>,
    language: String,
    meta: Any?,
  ): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextAddString is only implemented by non-JVM code.")
  }

  public override fun _shapedTextAddObject(
    shaped: RID,
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment,
    length: Long,
    baseline: Double,
  ): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextAddObject is only implemented by non-JVM code.")
  }

  public override fun _shapedTextResizeObject(
    shaped: RID,
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment,
    baseline: Double,
  ): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextResizeObject is only implemented by non-JVM code.")
  }

  public override fun _shapedTextHasObject(shaped: RID, key: Any?): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextHasObject is only implemented by non-JVM code.")
  }

  public override fun _shapedGetText(shaped: RID): String {
    throw NotImplementedError("TextServerExtension::_shapedGetText is only implemented by non-JVM code.")
  }

  public override fun _shapedGetSpanCount(shaped: RID): Long {
    throw NotImplementedError("TextServerExtension::_shapedGetSpanCount is only implemented by non-JVM code.")
  }

  public override fun _shapedGetSpanMeta(shaped: RID, index: Long): Any? {
    throw NotImplementedError("TextServerExtension::_shapedGetSpanMeta is only implemented by non-JVM code.")
  }

  public override fun _shapedGetSpanEmbeddedObject(shaped: RID, index: Long): Any? {
    throw NotImplementedError("TextServerExtension::_shapedGetSpanEmbeddedObject is only implemented by non-JVM code.")
  }

  public override fun _shapedGetSpanText(shaped: RID, index: Long): String {
    throw NotImplementedError("TextServerExtension::_shapedGetSpanText is only implemented by non-JVM code.")
  }

  public override fun _shapedGetSpanObject(shaped: RID, index: Long): Any? {
    throw NotImplementedError("TextServerExtension::_shapedGetSpanObject is only implemented by non-JVM code.")
  }

  public override fun _shapedSetSpanUpdateFont(
    shaped: RID,
    index: Long,
    fonts: VariantArray<RID>,
    size: Long,
    opentypeFeatures: Dictionary<Any?, Any?>,
  ): Unit {
    throw NotImplementedError("TextServerExtension::_shapedSetSpanUpdateFont is only implemented by non-JVM code.")
  }

  public override fun _shapedTextSubstr(
    shaped: RID,
    start: Long,
    length: Long,
  ): RID {
    throw NotImplementedError("TextServerExtension::_shapedTextSubstr is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetParent(shaped: RID): RID {
    throw NotImplementedError("TextServerExtension::_shapedTextGetParent is only implemented by non-JVM code.")
  }

  public override fun _shapedTextShape(shaped: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextShape is only implemented by non-JVM code.")
  }

  public override fun _shapedTextIsReady(shaped: RID): Boolean {
    throw NotImplementedError("TextServerExtension::_shapedTextIsReady is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetGlyphCount(shaped: RID): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextGetGlyphCount is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetRange(shaped: RID): Vector2i {
    throw NotImplementedError("TextServerExtension::_shapedTextGetRange is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetTrimPos(shaped: RID): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextGetTrimPos is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetEllipsisPos(shaped: RID): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextGetEllipsisPos is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetEllipsisGlyphCount(shaped: RID): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextGetEllipsisGlyphCount is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetObjects(shaped: RID): VariantArray<Any?> {
    throw NotImplementedError("TextServerExtension::_shapedTextGetObjects is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetObjectRect(shaped: RID, key: Any?): Rect2 {
    throw NotImplementedError("TextServerExtension::_shapedTextGetObjectRect is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetObjectRange(shaped: RID, key: Any?): Vector2i {
    throw NotImplementedError("TextServerExtension::_shapedTextGetObjectRange is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetObjectGlyph(shaped: RID, key: Any?): Long {
    throw NotImplementedError("TextServerExtension::_shapedTextGetObjectGlyph is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetSize(shaped: RID): Vector2 {
    throw NotImplementedError("TextServerExtension::_shapedTextGetSize is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetAscent(shaped: RID): Double {
    throw NotImplementedError("TextServerExtension::_shapedTextGetAscent is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetDescent(shaped: RID): Double {
    throw NotImplementedError("TextServerExtension::_shapedTextGetDescent is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetWidth(shaped: RID): Double {
    throw NotImplementedError("TextServerExtension::_shapedTextGetWidth is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetUnderlinePosition(shaped: RID): Double {
    throw NotImplementedError("TextServerExtension::_shapedTextGetUnderlinePosition is only implemented by non-JVM code.")
  }

  public override fun _shapedTextGetUnderlineThickness(shaped: RID): Double {
    throw NotImplementedError("TextServerExtension::_shapedTextGetUnderlineThickness is only implemented by non-JVM code.")
  }
}
