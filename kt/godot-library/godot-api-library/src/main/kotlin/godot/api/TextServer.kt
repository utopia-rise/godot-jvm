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
import godot.core.BitFieldBase
import godot.core.Color
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.InlineAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.MethodStringName8
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import godot.core.PackedInt32Array
import godot.core.PackedStringArray
import godot.core.PackedVector2Array
import godot.core.PackedVector3Array
import godot.core.RID
import godot.core.Rect2
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantParser._RID
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3i
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

public infix fun Long.or(other: TextServer.JustificationFlag): Long = this.or(other.flag)

public infix fun Long.xor(other: TextServer.JustificationFlag): Long = this.xor(other.flag)

public infix fun Long.and(other: TextServer.JustificationFlag): Long = this.and(other.flag)

public infix fun Long.or(other: TextServer.LineBreakFlag): Long = this.or(other.flag)

public infix fun Long.xor(other: TextServer.LineBreakFlag): Long = this.xor(other.flag)

public infix fun Long.and(other: TextServer.LineBreakFlag): Long = this.and(other.flag)

public infix fun Long.or(other: TextServer.TextOverrunFlag): Long = this.or(other.flag)

public infix fun Long.xor(other: TextServer.TextOverrunFlag): Long = this.xor(other.flag)

public infix fun Long.and(other: TextServer.TextOverrunFlag): Long = this.and(other.flag)

public infix fun Long.or(other: TextServer.GraphemeFlag): Long = this.or(other.flag)

public infix fun Long.xor(other: TextServer.GraphemeFlag): Long = this.xor(other.flag)

public infix fun Long.and(other: TextServer.GraphemeFlag): Long = this.and(other.flag)

public infix fun Long.or(other: TextServer.FontStyle): Long = this.or(other.flag)

public infix fun Long.xor(other: TextServer.FontStyle): Long = this.xor(other.flag)

public infix fun Long.and(other: TextServer.FontStyle): Long = this.and(other.flag)

/**
 * [TextServer] is the API backend for managing fonts and rendering text.
 *
 * **Note:** This is a low-level API, consider using [TextLine], [TextParagraph], and [Font] classes
 * instead.
 *
 * This is an abstract class, so to get the currently active [TextServer] instance, use the
 * following code:
 *
 * ```gdscript
 * //gdscript
 * var ts = TextServerManager.get_primary_interface()
 * ```
 *
 * ```csharp
 * //csharp
 * var ts = TextServerManager.GetPrimaryInterface();
 * ```
 */
@GodotBaseType
public open class TextServer internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(734, scriptPtr)
  }

  /**
   * Returns `true` if the server supports a feature.
   */
  public final fun hasFeature(feature: Feature): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to feature.value)
    TransferContext.callMethod(MethodBindings.hasFeaturePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the name of the server interface.
   */
  public final fun getName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns text server features, see [Feature].
   */
  public final fun getFeatures(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFeaturesPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Loads optional TextServer database (e.g. ICU break iterators and dictionaries).
   *
   * **Note:** This function should be called before any other TextServer functions used, otherwise
   * it won't have any effect.
   */
  public final fun loadSupportData(filename: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to filename)
    TransferContext.callMethod(MethodBindings.loadSupportDataPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns default TextServer database (e.g. ICU break iterators and dictionaries) filename.
   */
  public final fun getSupportDataFilename(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportDataFilenamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns TextServer database (e.g. ICU break iterators and dictionaries) description.
   */
  public final fun getSupportDataInfo(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportDataInfoPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Saves optional TextServer database (e.g. ICU break iterators and dictionaries) to the file.
   *
   * **Note:** This function is used by during project export, to include TextServer database.
   */
  public final fun saveSupportData(filename: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to filename)
    TransferContext.callMethod(MethodBindings.saveSupportDataPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns default TextServer database (e.g. ICU break iterators and dictionaries).
   */
  public final fun getSupportData(): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportDataPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Returns `true` if the locale requires text server support data for line/word breaking.
   */
  public final fun isLocaleUsingSupportData(locale: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to locale)
    TransferContext.callMethod(MethodBindings.isLocaleUsingSupportDataPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if locale is right-to-left.
   */
  public final fun isLocaleRightToLeft(locale: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to locale)
    TransferContext.callMethod(MethodBindings.isLocaleRightToLeftPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Converts the given readable name of a feature, variation, script, or language to an OpenType
   * tag.
   */
  public final fun nameToTag(name: String): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.nameToTagPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Converts the given OpenType tag to the readable name of a feature, variation, script, or
   * language.
   */
  public final fun tagToName(tag: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to tag)
    TransferContext.callMethod(MethodBindings.tagToNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if [rid] is valid resource owned by this text server.
   */
  public final fun has(rid: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.hasPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Frees an object created by this [TextServer].
   */
  public final fun freeRid(rid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.freeRidPtr)
  }

  /**
   * Creates a new, empty font cache entry resource. To free the resulting resource, use the
   * [freeRid] method.
   */
  public final fun createFont(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createFontPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new variation existing font which is reusing the same glyph cache and font data. To
   * free the resulting resource, use the [freeRid] method.
   */
  public final fun createFontLinkedVariation(fontRid: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.createFontLinkedVariationPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets font source data, e.g contents of the dynamic font source file.
   */
  public final fun fontSetData(fontRid: RID, `data`: PackedByteArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.fontSetDataPtr)
  }

  /**
   * Sets an active face index in the TrueType / OpenType collection.
   */
  public final fun fontSetFaceIndex(fontRid: RID, faceIndex: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to faceIndex)
    TransferContext.callMethod(MethodBindings.fontSetFaceIndexPtr)
  }

  /**
   * Returns an active face index in the TrueType / OpenType collection.
   */
  public final fun fontGetFaceIndex(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetFaceIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns number of faces in the TrueType / OpenType collection.
   */
  public final fun fontGetFaceCount(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetFaceCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the font style flags.
   *
   * **Note:** This value is used for font matching only and will not affect font rendering. Use
   * [fontSetFaceIndex], [fontSetVariationCoordinates], [fontSetEmbolden], or [fontSetTransform]
   * instead.
   */
  public final fun fontSetStyle(fontRid: RID, style: FontStyle): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to style.flag)
    TransferContext.callMethod(MethodBindings.fontSetStylePtr)
  }

  /**
   * Returns font style flags.
   */
  public final fun fontGetStyle(fontRid: RID): FontStyle {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetStylePtr)
    return FontStyle(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the font family name.
   */
  public final fun fontSetName(fontRid: RID, name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to name)
    TransferContext.callMethod(MethodBindings.fontSetNamePtr)
  }

  /**
   * Returns font family name.
   */
  public final fun fontGetName(fontRid: RID): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns [Dictionary] with OpenType font name strings (localized font names, version,
   * description, license information, sample text, etc.).
   */
  public final fun fontGetOtNameStrings(fontRid: RID): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetOtNameStringsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Sets the font style name.
   */
  public final fun fontSetStyleName(fontRid: RID, name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to name)
    TransferContext.callMethod(MethodBindings.fontSetStyleNamePtr)
  }

  /**
   * Returns font style name.
   */
  public final fun fontGetStyleName(fontRid: RID): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetStyleNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets weight (boldness) of the font. A value in the `100...999` range, normal font weight is
   * `400`, bold font weight is `700`.
   *
   * **Note:** This value is used for font matching only and will not affect font rendering. Use
   * [fontSetFaceIndex], [fontSetVariationCoordinates], or [fontSetEmbolden] instead.
   */
  public final fun fontSetWeight(fontRid: RID, weight: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to weight)
    TransferContext.callMethod(MethodBindings.fontSetWeightPtr)
  }

  /**
   * Returns weight (boldness) of the font. A value in the `100...999` range, normal font weight is
   * `400`, bold font weight is `700`.
   */
  public final fun fontGetWeight(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetWeightPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets font stretch amount, compared to a normal width. A percentage value between `50&#37;` and
   * `200&#37;`.
   *
   * **Note:** This value is used for font matching only and will not affect font rendering. Use
   * [fontSetFaceIndex], [fontSetVariationCoordinates], or [fontSetTransform] instead.
   */
  public final fun fontSetStretch(fontRid: RID, weight: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to weight)
    TransferContext.callMethod(MethodBindings.fontSetStretchPtr)
  }

  /**
   * Returns font stretch amount, compared to a normal width. A percentage value between `50&#37;`
   * and `200&#37;`.
   */
  public final fun fontGetStretch(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetStretchPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets font anti-aliasing mode.
   */
  public final fun fontSetAntialiasing(fontRid: RID, antialiasing: FontAntialiasing): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to antialiasing.value)
    TransferContext.callMethod(MethodBindings.fontSetAntialiasingPtr)
  }

  /**
   * Returns font anti-aliasing mode.
   */
  public final fun fontGetAntialiasing(fontRid: RID): FontAntialiasing {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetAntialiasingPtr)
    return FontAntialiasing.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If set to `true`, embedded font bitmap loading is disabled (bitmap-only and color fonts ignore
   * this property).
   */
  public final fun fontSetDisableEmbeddedBitmaps(fontRid: RID, disableEmbeddedBitmaps: Boolean):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, BOOL to disableEmbeddedBitmaps)
    TransferContext.callMethod(MethodBindings.fontSetDisableEmbeddedBitmapsPtr)
  }

  /**
   * Returns whether the font's embedded bitmap loading is disabled.
   */
  public final fun fontGetDisableEmbeddedBitmaps(fontRid: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetDisableEmbeddedBitmapsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If set to `true` font texture mipmap generation is enabled.
   */
  public final fun fontSetGenerateMipmaps(fontRid: RID, generateMipmaps: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, BOOL to generateMipmaps)
    TransferContext.callMethod(MethodBindings.fontSetGenerateMipmapsPtr)
  }

  /**
   * Returns `true` if font texture mipmap generation is enabled.
   */
  public final fun fontGetGenerateMipmaps(fontRid: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetGenerateMipmapsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If set to `true`, glyphs of all sizes are rendered using single multichannel signed distance
   * field generated from the dynamic font vector data. MSDF rendering allows displaying the font at
   * any scaling factor without blurriness, and without incurring a CPU cost when the font size changes
   * (since the font no longer needs to be rasterized on the CPU). As a downside, font hinting is not
   * available with MSDF. The lack of font hinting may result in less crisp and less readable fonts at
   * small sizes.
   *
   * **Note:** MSDF font rendering does not render glyphs with overlapping shapes correctly.
   * Overlapping shapes are not valid per the OpenType standard, but are still commonly found in many
   * font files, especially those converted by Google Fonts. To avoid issues with overlapping glyphs,
   * consider downloading the font file directly from the type foundry instead of relying on Google
   * Fonts.
   */
  public final fun fontSetMultichannelSignedDistanceField(fontRid: RID, msdf: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, BOOL to msdf)
    TransferContext.callMethod(MethodBindings.fontSetMultichannelSignedDistanceFieldPtr)
  }

  /**
   * Returns `true` if glyphs of all sizes are rendered using single multichannel signed distance
   * field generated from the dynamic font vector data.
   */
  public final fun fontIsMultichannelSignedDistanceField(fontRid: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontIsMultichannelSignedDistanceFieldPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the width of the range around the shape between the minimum and maximum representable
   * signed distance.
   */
  public final fun fontSetMsdfPixelRange(fontRid: RID, msdfPixelRange: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to msdfPixelRange)
    TransferContext.callMethod(MethodBindings.fontSetMsdfPixelRangePtr)
  }

  /**
   * Returns the width of the range around the shape between the minimum and maximum representable
   * signed distance.
   */
  public final fun fontGetMsdfPixelRange(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetMsdfPixelRangePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets source font size used to generate MSDF textures.
   */
  public final fun fontSetMsdfSize(fontRid: RID, msdfSize: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to msdfSize)
    TransferContext.callMethod(MethodBindings.fontSetMsdfSizePtr)
  }

  /**
   * Returns source font size used to generate MSDF textures.
   */
  public final fun fontGetMsdfSize(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetMsdfSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets bitmap font fixed size. If set to value greater than zero, same cache entry will be used
   * for all font sizes.
   */
  public final fun fontSetFixedSize(fontRid: RID, fixedSize: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to fixedSize)
    TransferContext.callMethod(MethodBindings.fontSetFixedSizePtr)
  }

  /**
   * Returns bitmap font fixed size.
   */
  public final fun fontGetFixedSize(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetFixedSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets bitmap font scaling mode. This property is used only if `fixed_size` is greater than zero.
   */
  public final fun fontSetFixedSizeScaleMode(fontRid: RID, fixedSizeScaleMode: FixedSizeScaleMode):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to fixedSizeScaleMode.value)
    TransferContext.callMethod(MethodBindings.fontSetFixedSizeScaleModePtr)
  }

  /**
   * Returns bitmap font scaling mode.
   */
  public final fun fontGetFixedSizeScaleMode(fontRid: RID): FixedSizeScaleMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetFixedSizeScaleModePtr)
    return FixedSizeScaleMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If set to `true`, system fonts can be automatically used as fallbacks.
   */
  public final fun fontSetAllowSystemFallback(fontRid: RID, allowSystemFallback: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, BOOL to allowSystemFallback)
    TransferContext.callMethod(MethodBindings.fontSetAllowSystemFallbackPtr)
  }

  /**
   * Returns `true` if system fonts can be automatically used as fallbacks.
   */
  public final fun fontIsAllowSystemFallback(fontRid: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontIsAllowSystemFallbackPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Frees all automatically loaded system fonts.
   */
  public final fun fontClearSystemFallbackCache(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.fontClearSystemFallbackCachePtr)
  }

  /**
   * If set to `true` auto-hinting is preferred over font built-in hinting.
   */
  public final fun fontSetForceAutohinter(fontRid: RID, forceAutohinter: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, BOOL to forceAutohinter)
    TransferContext.callMethod(MethodBindings.fontSetForceAutohinterPtr)
  }

  /**
   * Returns `true` if auto-hinting is supported and preferred over font built-in hinting. Used by
   * dynamic fonts only.
   */
  public final fun fontIsForceAutohinter(fontRid: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontIsForceAutohinterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If set to `true`, color modulation is applied when drawing colored glyphs, otherwise it's
   * applied to the monochrome glyphs only.
   */
  public final fun fontSetModulateColorGlyphs(fontRid: RID, modulate: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, BOOL to modulate)
    TransferContext.callMethod(MethodBindings.fontSetModulateColorGlyphsPtr)
  }

  /**
   * Returns `true` if color modulation is applied when drawing the font's colored glyphs.
   */
  public final fun fontIsModulateColorGlyphs(fontRid: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontIsModulateColorGlyphsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the number of predefined color palettes. Palette contains all colors used to render
   * font glyphs. Each palette has the same number of colors.
   */
  public final fun fontGetPaletteCount(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetPaletteCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the name of the predefined color palette at [index]. Palette contains all colors used
   * to render font glyphs. Each palette has the same number of colors.
   */
  public final fun fontGetPaletteName(fontRid: RID, index: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to index)
    TransferContext.callMethod(MethodBindings.fontGetPaletteNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the array in the predefined color palette at [index]. Palette contains all colors used
   * to render font glyphs. Each palette has the same number of colors. Colors can be overridden using
   * [fontSetPaletteCustomColors].
   */
  public final fun fontGetPaletteColors(fontRid: RID, index: Long): PackedColorArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to index)
    TransferContext.callMethod(MethodBindings.fontGetPaletteColorsPtr)
    return (TransferContext.readReturnValue(PACKED_COLOR_ARRAY) as PackedColorArray)
  }

  /**
   * Sets array of custom colors to override predefined palette. Set to empty array to reset
   * overrides. Use `Color(0, 0, 0, 0)`, to keep predefined palette color at specific position.
   */
  public final fun fontSetPaletteCustomColors(fontRid: RID, colors: PackedColorArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, PACKED_COLOR_ARRAY to colors)
    TransferContext.callMethod(MethodBindings.fontSetPaletteCustomColorsPtr)
  }

  /**
   * Returns array of custom colors to override predefined palette.
   */
  public final fun fontGetPaletteCustomColors(fontRid: RID): PackedColorArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetPaletteCustomColorsPtr)
    return (TransferContext.readReturnValue(PACKED_COLOR_ARRAY) as PackedColorArray)
  }

  /**
   * Returns used palette index.
   */
  public final fun fontGetUsedPalette(fontRid: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetUsedPalettePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets used palette index.
   */
  public final fun fontSetUsedPalette(fontRid: RID, index: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to index)
    TransferContext.callMethod(MethodBindings.fontSetUsedPalettePtr)
  }

  /**
   * Sets font hinting mode. Used by dynamic fonts only.
   */
  public final fun fontSetHinting(fontRid: RID, hinting: Hinting): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to hinting.value)
    TransferContext.callMethod(MethodBindings.fontSetHintingPtr)
  }

  /**
   * Returns the font hinting mode. Used by dynamic fonts only.
   */
  public final fun fontGetHinting(fontRid: RID): Hinting {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetHintingPtr)
    return Hinting.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets font subpixel glyph positioning mode.
   */
  public final fun fontSetSubpixelPositioning(fontRid: RID,
      subpixelPositioning: SubpixelPositioning): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to subpixelPositioning.value)
    TransferContext.callMethod(MethodBindings.fontSetSubpixelPositioningPtr)
  }

  /**
   * Returns font subpixel glyph positioning mode.
   */
  public final fun fontGetSubpixelPositioning(fontRid: RID): SubpixelPositioning {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetSubpixelPositioningPtr)
    return SubpixelPositioning.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets glyph position rounding behavior. If set to `true`, when aligning glyphs to the pixel
   * boundaries rounding remainders are accumulated to ensure more uniform glyph distribution. This
   * setting has no effect if subpixel positioning is enabled.
   */
  public final fun fontSetKeepRoundingRemainders(fontRid: RID, keepRoundingRemainders: Boolean):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, BOOL to keepRoundingRemainders)
    TransferContext.callMethod(MethodBindings.fontSetKeepRoundingRemaindersPtr)
  }

  /**
   * Returns glyph position rounding behavior. If set to `true`, when aligning glyphs to the pixel
   * boundaries rounding remainders are accumulated to ensure more uniform glyph distribution. This
   * setting has no effect if subpixel positioning is enabled.
   */
  public final fun fontGetKeepRoundingRemainders(fontRid: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetKeepRoundingRemaindersPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets font embolden strength. If [strength] is not equal to zero, emboldens the font outlines.
   * Negative values reduce the outline thickness.
   */
  public final fun fontSetEmbolden(fontRid: RID, strength: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, DOUBLE to strength)
    TransferContext.callMethod(MethodBindings.fontSetEmboldenPtr)
  }

  /**
   * Returns font embolden strength.
   */
  public final fun fontGetEmbolden(fontRid: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetEmboldenPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets the spacing for [spacing] to [value] in pixels (not relative to the font size).
   */
  public final fun fontSetSpacing(
    fontRid: RID,
    spacing: SpacingType,
    `value`: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to spacing.value, LONG to value)
    TransferContext.callMethod(MethodBindings.fontSetSpacingPtr)
  }

  /**
   * Returns the spacing for [spacing] in pixels (not relative to the font size).
   */
  public final fun fontGetSpacing(fontRid: RID, spacing: SpacingType): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to spacing.value)
    TransferContext.callMethod(MethodBindings.fontGetSpacingPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets extra baseline offset (as a fraction of font height).
   */
  public final fun fontSetBaselineOffset(fontRid: RID, baselineOffset: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, DOUBLE to baselineOffset)
    TransferContext.callMethod(MethodBindings.fontSetBaselineOffsetPtr)
  }

  /**
   * Returns extra baseline offset (as a fraction of font height).
   */
  public final fun fontGetBaselineOffset(fontRid: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetBaselineOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets 2D transform, applied to the font outlines, can be used for slanting, flipping, and
   * rotating glyphs.
   *
   * For example, to simulate italic typeface by slanting, apply the following transform
   * `Transform2D(1.0, slant, 0.0, 1.0, 0.0, 0.0)`.
   */
  public final fun fontSetTransform(fontRid: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.fontSetTransformPtr)
  }

  /**
   * Returns 2D transform applied to the font outlines.
   */
  public final fun fontGetTransform(fontRid: RID): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Sets variation coordinates for the specified font cache entry. See [fontSupportedVariationList]
   * for more info.
   */
  public final fun fontSetVariationCoordinates(fontRid: RID,
      variationCoordinates: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, DICTIONARY to variationCoordinates)
    TransferContext.callMethod(MethodBindings.fontSetVariationCoordinatesPtr)
  }

  /**
   * Returns variation coordinates for the specified font cache entry. See
   * [fontSupportedVariationList] for more info.
   */
  public final fun fontGetVariationCoordinates(fontRid: RID): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetVariationCoordinatesPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * If set to a positive value, overrides the oversampling factor of the viewport this font is used
   * in. See [Viewport.oversampling]. This value doesn't override the [code
   * skip-lint]oversampling[/code] parameter of [code skip-lint]draw_*[/code] methods. Used by dynamic
   * fonts only.
   */
  public final fun fontSetOversampling(fontRid: RID, oversampling: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, DOUBLE to oversampling)
    TransferContext.callMethod(MethodBindings.fontSetOversamplingPtr)
  }

  /**
   * Returns oversampling factor override. If set to a positive value, overrides the oversampling
   * factor of the viewport this font is used in. See [Viewport.oversampling]. This value doesn't
   * override the [code skip-lint]oversampling[/code] parameter of [code skip-lint]draw_*[/code]
   * methods. Used by dynamic fonts only.
   */
  public final fun fontGetOversampling(fontRid: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetOversamplingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns list of the font sizes in the cache. Each size is [Vector2i] with font size and outline
   * size.
   */
  public final fun fontGetSizeCacheList(fontRid: RID): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetSizeCacheListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  /**
   * Removes all font sizes from the cache entry.
   */
  public final fun fontClearSizeCache(fontRid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontClearSizeCachePtr)
  }

  /**
   * Removes specified font size from the cache entry.
   */
  public final fun fontRemoveSizeCache(fontRid: RID, size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.fontRemoveSizeCachePtr)
  }

  /**
   * Returns font cache information, each entry contains the following fields: `Vector2i size_px` -
   * font size in pixels, `float viewport_oversampling` - viewport oversampling factor, `int glyphs` -
   * number of rendered glyphs, `int textures` - number of used textures, `int textures_size` - size of
   * texture data in bytes.
   */
  public final fun fontGetSizeCacheInfo(fontRid: RID): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetSizeCacheInfoPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Sets the font ascent (number of pixels above the baseline).
   */
  public final fun fontSetAscent(
    fontRid: RID,
    size: Long,
    ascent: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, DOUBLE to ascent)
    TransferContext.callMethod(MethodBindings.fontSetAscentPtr)
  }

  /**
   * Returns the font ascent (number of pixels above the baseline).
   */
  public final fun fontGetAscent(fontRid: RID, size: Long): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size)
    TransferContext.callMethod(MethodBindings.fontGetAscentPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets the font descent (number of pixels below the baseline).
   */
  public final fun fontSetDescent(
    fontRid: RID,
    size: Long,
    descent: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, DOUBLE to descent)
    TransferContext.callMethod(MethodBindings.fontSetDescentPtr)
  }

  /**
   * Returns the font descent (number of pixels below the baseline).
   */
  public final fun fontGetDescent(fontRid: RID, size: Long): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size)
    TransferContext.callMethod(MethodBindings.fontGetDescentPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets pixel offset of the underline below the baseline.
   */
  public final fun fontSetUnderlinePosition(
    fontRid: RID,
    size: Long,
    underlinePosition: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, DOUBLE to underlinePosition)
    TransferContext.callMethod(MethodBindings.fontSetUnderlinePositionPtr)
  }

  /**
   * Returns pixel offset of the underline below the baseline.
   */
  public final fun fontGetUnderlinePosition(fontRid: RID, size: Long): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size)
    TransferContext.callMethod(MethodBindings.fontGetUnderlinePositionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets thickness of the underline in pixels.
   */
  public final fun fontSetUnderlineThickness(
    fontRid: RID,
    size: Long,
    underlineThickness: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, DOUBLE to underlineThickness)
    TransferContext.callMethod(MethodBindings.fontSetUnderlineThicknessPtr)
  }

  /**
   * Returns thickness of the underline in pixels.
   */
  public final fun fontGetUnderlineThickness(fontRid: RID, size: Long): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size)
    TransferContext.callMethod(MethodBindings.fontGetUnderlineThicknessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets scaling factor of the color bitmap font.
   */
  public final fun fontSetScale(
    fontRid: RID,
    size: Long,
    scale: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, DOUBLE to scale)
    TransferContext.callMethod(MethodBindings.fontSetScalePtr)
  }

  /**
   * Returns scaling factor of the color bitmap font.
   */
  public final fun fontGetScale(fontRid: RID, size: Long): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size)
    TransferContext.callMethod(MethodBindings.fontGetScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns number of textures used by font cache entry.
   */
  public final fun fontGetTextureCount(fontRid: RID, size: Vector2i): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.fontGetTextureCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Removes all textures from font cache entry.
   *
   * **Note:** This function will not remove glyphs associated with the texture, use
   * [fontRemoveGlyph] to remove them manually.
   */
  public final fun fontClearTextures(fontRid: RID, size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.fontClearTexturesPtr)
  }

  /**
   * Removes specified texture from the cache entry.
   *
   * **Note:** This function will not remove glyphs associated with the texture, remove them
   * manually, using [fontRemoveGlyph].
   */
  public final fun fontRemoveTexture(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to textureIndex)
    TransferContext.callMethod(MethodBindings.fontRemoveTexturePtr)
  }

  /**
   * Sets font cache texture image data.
   */
  public final fun fontSetTextureImage(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
    image: Image?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to textureIndex, OBJECT to image)
    TransferContext.callMethod(MethodBindings.fontSetTextureImagePtr)
  }

  /**
   * Returns font cache texture image data.
   */
  public final fun fontGetTextureImage(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
  ): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to textureIndex)
    TransferContext.callMethod(MethodBindings.fontGetTextureImagePtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Sets array containing glyph packing data.
   */
  public final fun fontSetTextureOffsets(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
    offset: PackedInt32Array,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to textureIndex, PACKED_INT_32_ARRAY to offset)
    TransferContext.callMethod(MethodBindings.fontSetTextureOffsetsPtr)
  }

  /**
   * Returns array containing glyph packing data.
   */
  public final fun fontGetTextureOffsets(
    fontRid: RID,
    size: Vector2i,
    textureIndex: Long,
  ): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to textureIndex)
    TransferContext.callMethod(MethodBindings.fontGetTextureOffsetsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns list of rendered glyphs in the cache entry.
   */
  public final fun fontGetGlyphList(fontRid: RID, size: Vector2i): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.fontGetGlyphListPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Removes all rendered glyph information from the cache entry.
   *
   * **Note:** This function will not remove textures associated with the glyphs, use
   * [fontRemoveTexture] to remove them manually.
   */
  public final fun fontClearGlyphs(fontRid: RID, size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.fontClearGlyphsPtr)
  }

  /**
   * Removes specified rendered glyph information from the cache entry.
   *
   * **Note:** This function will not remove textures associated with the glyphs, use
   * [fontRemoveTexture] to remove them manually.
   */
  public final fun fontRemoveGlyph(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph)
    TransferContext.callMethod(MethodBindings.fontRemoveGlyphPtr)
  }

  /**
   * Returns glyph advance (offset of the next glyph).
   *
   * **Note:** Advance for glyphs outlines is the same as the base glyph advance and is not saved.
   */
  public final fun fontGetGlyphAdvance(
    fontRid: RID,
    size: Long,
    glyph: Long,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, LONG to glyph)
    TransferContext.callMethod(MethodBindings.fontGetGlyphAdvancePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets glyph advance (offset of the next glyph).
   *
   * **Note:** Advance for glyphs outlines is the same as the base glyph advance and is not saved.
   */
  public final fun fontSetGlyphAdvance(
    fontRid: RID,
    size: Long,
    glyph: Long,
    advance: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, LONG to glyph, VECTOR2 to advance)
    TransferContext.callMethod(MethodBindings.fontSetGlyphAdvancePtr)
  }

  /**
   * Returns glyph offset from the baseline.
   */
  public final fun fontGetGlyphOffset(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph)
    TransferContext.callMethod(MethodBindings.fontGetGlyphOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets glyph offset from the baseline.
   */
  public final fun fontSetGlyphOffset(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    offset: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.fontSetGlyphOffsetPtr)
  }

  /**
   * Returns size of the glyph.
   */
  public final fun fontGetGlyphSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph)
    TransferContext.callMethod(MethodBindings.fontGetGlyphSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets size of the glyph.
   */
  public final fun fontSetGlyphSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    glSize: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph, VECTOR2 to glSize)
    TransferContext.callMethod(MethodBindings.fontSetGlyphSizePtr)
  }

  /**
   * Returns rectangle in the cache texture containing the glyph.
   */
  public final fun fontGetGlyphUvRect(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph)
    TransferContext.callMethod(MethodBindings.fontGetGlyphUvRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Sets rectangle in the cache texture containing the glyph.
   */
  public final fun fontSetGlyphUvRect(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    uvRect: Rect2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph, RECT2 to uvRect)
    TransferContext.callMethod(MethodBindings.fontSetGlyphUvRectPtr)
  }

  /**
   * Returns index of the cache texture containing the glyph.
   */
  public final fun fontGetGlyphTextureIdx(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph)
    TransferContext.callMethod(MethodBindings.fontGetGlyphTextureIdxPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets index of the cache texture containing the glyph.
   */
  public final fun fontSetGlyphTextureIdx(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
    textureIdx: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph, LONG to textureIdx)
    TransferContext.callMethod(MethodBindings.fontSetGlyphTextureIdxPtr)
  }

  /**
   * Returns resource ID of the cache texture containing the glyph.
   *
   * **Note:** If there are pending glyphs to render, calling this function might trigger the
   * texture cache update.
   */
  public final fun fontGetGlyphTextureRid(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph)
    TransferContext.callMethod(MethodBindings.fontGetGlyphTextureRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns size of the cache texture containing the glyph.
   *
   * **Note:** If there are pending glyphs to render, calling this function might trigger the
   * texture cache update.
   */
  public final fun fontGetGlyphTextureSize(
    fontRid: RID,
    size: Vector2i,
    glyph: Long,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to glyph)
    TransferContext.callMethod(MethodBindings.fontGetGlyphTextureSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns outline contours of the glyph as a [Dictionary] with the following contents:
   *
   * `points`         - [PackedVector3Array], containing outline points. `x` and `y` are point
   * coordinates. `z` is the type of the point, using the [ContourPointTag] values.
   *
   * `contours`       - [PackedInt32Array], containing indices the end points of each contour.
   *
   * `orientation`    - [Boolean], contour orientation. If `true`, clockwise contours must be
   * filled.
   *
   * - Two successive [CONTOUR_CURVE_TAG_ON] points indicate a line segment.
   *
   * - One [CONTOUR_CURVE_TAG_OFF_CONIC] point between two [CONTOUR_CURVE_TAG_ON] points indicates a
   * single conic (quadratic) Bézier arc.
   *
   * - Two [CONTOUR_CURVE_TAG_OFF_CUBIC] points between two [CONTOUR_CURVE_TAG_ON] points indicate a
   * single cubic Bézier arc.
   *
   * - Two successive [CONTOUR_CURVE_TAG_OFF_CONIC] points indicate two successive conic (quadratic)
   * Bézier arcs with a virtual [CONTOUR_CURVE_TAG_ON] point at their middle.
   *
   * - Each contour is closed. The last point of a contour uses the first point of a contour as its
   * next point, and vice versa. The first point can be [CONTOUR_CURVE_TAG_OFF_CONIC] point.
   */
  public final fun fontGetGlyphContours(
    font: RID,
    size: Long,
    index: Long,
  ): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to font, LONG to size, LONG to index)
    TransferContext.callMethod(MethodBindings.fontGetGlyphContoursPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns list of the kerning overrides.
   */
  public final fun fontGetKerningList(fontRid: RID, size: Long): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size)
    TransferContext.callMethod(MethodBindings.fontGetKerningListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  /**
   * Removes all kerning overrides.
   */
  public final fun fontClearKerningMap(fontRid: RID, size: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size)
    TransferContext.callMethod(MethodBindings.fontClearKerningMapPtr)
  }

  /**
   * Removes kerning override for the pair of glyphs.
   */
  public final fun fontRemoveKerning(
    fontRid: RID,
    size: Long,
    glyphPair: Vector2i,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, VECTOR2I to glyphPair)
    TransferContext.callMethod(MethodBindings.fontRemoveKerningPtr)
  }

  /**
   * Sets kerning for the pair of glyphs.
   */
  public final fun fontSetKerning(
    fontRid: RID,
    size: Long,
    glyphPair: Vector2i,
    kerning: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, VECTOR2I to glyphPair, VECTOR2 to kerning)
    TransferContext.callMethod(MethodBindings.fontSetKerningPtr)
  }

  /**
   * Returns kerning for the pair of glyphs.
   */
  public final fun fontGetKerning(
    fontRid: RID,
    size: Long,
    glyphPair: Vector2i,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, VECTOR2I to glyphPair)
    TransferContext.callMethod(MethodBindings.fontGetKerningPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the glyph index of a [char], optionally modified by the [variationSelector]. See
   * [fontGetCharFromGlyphIndex].
   */
  public final fun fontGetGlyphIndex(
    fontRid: RID,
    size: Long,
    char: Long,
    variationSelector: Long,
  ): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, LONG to char, LONG to variationSelector)
    TransferContext.callMethod(MethodBindings.fontGetGlyphIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns character code associated with [glyphIndex], or `0` if [glyphIndex] is invalid. See
   * [fontGetGlyphIndex].
   */
  public final fun fontGetCharFromGlyphIndex(
    fontRid: RID,
    size: Long,
    glyphIndex: Long,
  ): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to size, LONG to glyphIndex)
    TransferContext.callMethod(MethodBindings.fontGetCharFromGlyphIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if a Unicode [char] is available in the font.
   */
  public final fun fontHasChar(fontRid: RID, char: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, LONG to char)
    TransferContext.callMethod(MethodBindings.fontHasCharPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a string containing all the characters available in the font.
   */
  public final fun fontGetSupportedChars(fontRid: RID): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetSupportedCharsPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns an array containing all glyph indices in the font.
   */
  public final fun fontGetSupportedGlyphs(fontRid: RID): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetSupportedGlyphsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Renders the range of characters to the font cache texture.
   */
  public final fun fontRenderRange(
    fontRid: RID,
    size: Vector2i,
    start: Long,
    end: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to start, LONG to end)
    TransferContext.callMethod(MethodBindings.fontRenderRangePtr)
  }

  /**
   * Renders specified glyph to the font cache texture.
   */
  public final fun fontRenderGlyph(
    fontRid: RID,
    size: Vector2i,
    index: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, VECTOR2I to size, LONG to index)
    TransferContext.callMethod(MethodBindings.fontRenderGlyphPtr)
  }

  /**
   * Draws single glyph into a canvas item at the position, using [fontRid] at the size [size]. If
   * [oversampling] is greater than zero, it is used as font oversampling factor, otherwise viewport
   * oversampling settings are used.
   *
   * **Note:** Glyph index is specific to the font, use glyphs indices returned by
   * [shapedTextGetGlyphs] or [fontGetGlyphIndex].
   *
   * **Note:** If there are pending glyphs to render, calling this function might trigger the
   * texture cache update.
   */
  @JvmOverloads
  public final fun fontDrawGlyph(
    fontRid: RID,
    canvas: RID,
    size: Long,
    pos: Vector2,
    index: Long,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, _RID to canvas, LONG to size, VECTOR2 to pos, LONG to index, COLOR to color, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.fontDrawGlyphPtr)
  }

  /**
   * Draws single glyph outline of size [outlineSize] into a canvas item at the position, using
   * [fontRid] at the size [size]. If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   *
   * **Note:** Glyph index is specific to the font, use glyphs indices returned by
   * [shapedTextGetGlyphs] or [fontGetGlyphIndex].
   *
   * **Note:** If there are pending glyphs to render, calling this function might trigger the
   * texture cache update.
   */
  @JvmOverloads
  public final fun fontDrawGlyphOutline(
    fontRid: RID,
    canvas: RID,
    size: Long,
    outlineSize: Long,
    pos: Vector2,
    index: Long,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, _RID to canvas, LONG to size, LONG to outlineSize, VECTOR2 to pos, LONG to index, COLOR to color, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.fontDrawGlyphOutlinePtr)
  }

  /**
   * Returns `true` if the font supports the given language (as a
   * [url=https://en.wikipedia.org/wiki/ISO_639-1]ISO 639[/url] code).
   */
  public final fun fontIsLanguageSupported(fontRid: RID, language: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to language)
    TransferContext.callMethod(MethodBindings.fontIsLanguageSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds override for [fontIsLanguageSupported].
   */
  public final fun fontSetLanguageSupportOverride(
    fontRid: RID,
    language: String,
    supported: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to language, BOOL to supported)
    TransferContext.callMethod(MethodBindings.fontSetLanguageSupportOverridePtr)
  }

  /**
   * Returns `true` if support override is enabled for the [language].
   */
  public final fun fontGetLanguageSupportOverride(fontRid: RID, language: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to language)
    TransferContext.callMethod(MethodBindings.fontGetLanguageSupportOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Remove language support override.
   */
  public final fun fontRemoveLanguageSupportOverride(fontRid: RID, language: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to language)
    TransferContext.callMethod(MethodBindings.fontRemoveLanguageSupportOverridePtr)
  }

  /**
   * Returns list of language support overrides.
   */
  public final fun fontGetLanguageSupportOverrides(fontRid: RID): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetLanguageSupportOverridesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns `true` if the font supports the given script (as a
   * [url=https://en.wikipedia.org/wiki/ISO_15924]ISO 15924[/url] code).
   */
  public final fun fontIsScriptSupported(fontRid: RID, script: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to script)
    TransferContext.callMethod(MethodBindings.fontIsScriptSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds override for [fontIsScriptSupported].
   */
  public final fun fontSetScriptSupportOverride(
    fontRid: RID,
    script: String,
    supported: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to script, BOOL to supported)
    TransferContext.callMethod(MethodBindings.fontSetScriptSupportOverridePtr)
  }

  /**
   * Returns `true` if support override is enabled for the [script].
   */
  public final fun fontGetScriptSupportOverride(fontRid: RID, script: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to script)
    TransferContext.callMethod(MethodBindings.fontGetScriptSupportOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes script support override.
   */
  public final fun fontRemoveScriptSupportOverride(fontRid: RID, script: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, STRING to script)
    TransferContext.callMethod(MethodBindings.fontRemoveScriptSupportOverridePtr)
  }

  /**
   * Returns list of script support overrides.
   */
  public final fun fontGetScriptSupportOverrides(fontRid: RID): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetScriptSupportOverridesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Sets font OpenType feature set override.
   */
  public final fun fontSetOpentypeFeatureOverrides(fontRid: RID, overrides: Dictionary<Any?, Any?>):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid, DICTIONARY to overrides)
    TransferContext.callMethod(MethodBindings.fontSetOpentypeFeatureOverridesPtr)
  }

  /**
   * Returns font OpenType feature set override.
   */
  public final fun fontGetOpentypeFeatureOverrides(fontRid: RID): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontGetOpentypeFeatureOverridesPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns the dictionary of the supported OpenType features.
   */
  public final fun fontSupportedFeatureList(fontRid: RID): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontSupportedFeatureListPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns the dictionary of the supported OpenType variation coordinates.
   */
  public final fun fontSupportedVariationList(fontRid: RID): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fontRid)
    TransferContext.callMethod(MethodBindings.fontSupportedVariationListPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * This method does nothing and always returns `1.0`.
   */
  public final fun fontGetGlobalOversampling(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.fontGetGlobalOversamplingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * This method does nothing.
   */
  public final fun fontSetGlobalOversampling(oversampling: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to oversampling)
    TransferContext.callMethod(MethodBindings.fontSetGlobalOversamplingPtr)
  }

  /**
   * Returns size of the replacement character (box with character hexadecimal code that is drawn in
   * place of invalid characters).
   */
  public final fun getHexCodeBoxSize(size: Long, index: Long): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size, LONG to index)
    TransferContext.callMethod(MethodBindings.getHexCodeBoxSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Draws box displaying character hexadecimal code. Used for replacing missing characters.
   */
  public final fun drawHexCodeBox(
    canvas: RID,
    size: Long,
    pos: Vector2,
    index: Long,
    color: Color,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to canvas, LONG to size, VECTOR2 to pos, LONG to index, COLOR to color)
    TransferContext.callMethod(MethodBindings.drawHexCodeBoxPtr)
  }

  /**
   * Creates a new buffer for complex text layout, with the given [direction] and [orientation]. To
   * free the resulting buffer, use [freeRid] method.
   *
   * **Note:** Direction is ignored if server does not support [FEATURE_BIDI_LAYOUT] feature
   * (supported by [TextServerAdvanced]).
   *
   * **Note:** Orientation is ignored if server does not support [FEATURE_VERTICAL_LAYOUT] feature
   * (supported by [TextServerAdvanced]).
   */
  @JvmOverloads
  public final fun createShapedText(direction: Direction = TextServer.Direction.AUTO,
      orientation: Orientation = TextServer.Orientation.HORIZONTAL): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to direction.value, LONG to orientation.value)
    TransferContext.callMethod(MethodBindings.createShapedTextPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Clears text buffer (removes text and inline objects).
   */
  public final fun shapedTextClear(rid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.shapedTextClearPtr)
  }

  /**
   * Duplicates shaped text buffer.
   */
  public final fun shapedTextDuplicate(rid: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.shapedTextDuplicatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets desired text direction. If set to [DIRECTION_AUTO], direction will be detected based on
   * the buffer contents and current locale.
   *
   * **Note:** Direction is ignored if server does not support [FEATURE_BIDI_LAYOUT] feature
   * (supported by [TextServerAdvanced]).
   */
  @JvmOverloads
  public final fun shapedTextSetDirection(shaped: RID, direction: Direction =
      TextServer.Direction.AUTO): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to direction.value)
    TransferContext.callMethod(MethodBindings.shapedTextSetDirectionPtr)
  }

  /**
   * Returns direction of the text.
   */
  public final fun shapedTextGetDirection(shaped: RID): Direction {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetDirectionPtr)
    return Direction.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns direction of the text, inferred by the BiDi algorithm.
   */
  public final fun shapedTextGetInferredDirection(shaped: RID): Direction {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetInferredDirectionPtr)
    return Direction.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Overrides BiDi for the structured text.
   *
   * Override ranges should cover full source text without overlaps. BiDi algorithm will be used on
   * each range separately.
   */
  public final fun shapedTextSetBidiOverride(shaped: RID, `override`: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, ARRAY to override)
    TransferContext.callMethod(MethodBindings.shapedTextSetBidiOverridePtr)
  }

  /**
   * Sets custom punctuation character list, used for word breaking. If set to empty string, server
   * defaults are used.
   */
  public final fun shapedTextSetCustomPunctuation(shaped: RID, punct: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, STRING to punct)
    TransferContext.callMethod(MethodBindings.shapedTextSetCustomPunctuationPtr)
  }

  /**
   * Returns custom punctuation character list, used for word breaking. If set to empty string,
   * server defaults are used.
   */
  public final fun shapedTextGetCustomPunctuation(shaped: RID): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetCustomPunctuationPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets ellipsis character used for text clipping.
   */
  public final fun shapedTextSetCustomEllipsis(shaped: RID, char: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to char)
    TransferContext.callMethod(MethodBindings.shapedTextSetCustomEllipsisPtr)
  }

  /**
   * Returns ellipsis character used for text clipping.
   */
  public final fun shapedTextGetCustomEllipsis(shaped: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetCustomEllipsisPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets desired text orientation.
   *
   * **Note:** Orientation is ignored if server does not support [FEATURE_VERTICAL_LAYOUT] feature
   * (supported by [TextServerAdvanced]).
   */
  @JvmOverloads
  public final fun shapedTextSetOrientation(shaped: RID, orientation: Orientation =
      TextServer.Orientation.HORIZONTAL): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to orientation.value)
    TransferContext.callMethod(MethodBindings.shapedTextSetOrientationPtr)
  }

  /**
   * Returns text orientation.
   */
  public final fun shapedTextGetOrientation(shaped: RID): Orientation {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetOrientationPtr)
    return Orientation.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If set to `true` text buffer will display invalid characters as hexadecimal codes, otherwise
   * nothing is displayed.
   */
  public final fun shapedTextSetPreserveInvalid(shaped: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.shapedTextSetPreserveInvalidPtr)
  }

  /**
   * Returns `true` if text buffer is configured to display hexadecimal codes in place of invalid
   * characters.
   *
   * **Note:** If set to `false`, nothing is displayed in place of invalid characters.
   */
  public final fun shapedTextGetPreserveInvalid(shaped: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetPreserveInvalidPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If set to `true` text buffer will display control characters.
   */
  public final fun shapedTextSetPreserveControl(shaped: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.shapedTextSetPreserveControlPtr)
  }

  /**
   * Returns `true` if text buffer is configured to display control characters.
   */
  public final fun shapedTextGetPreserveControl(shaped: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetPreserveControlPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets extra spacing added between glyphs or lines in pixels.
   */
  public final fun shapedTextSetSpacing(
    shaped: RID,
    spacing: SpacingType,
    `value`: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to spacing.value, LONG to value)
    TransferContext.callMethod(MethodBindings.shapedTextSetSpacingPtr)
  }

  /**
   * Returns extra spacing added between glyphs or lines in pixels.
   */
  public final fun shapedTextGetSpacing(shaped: RID, spacing: SpacingType): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to spacing.value)
    TransferContext.callMethod(MethodBindings.shapedTextGetSpacingPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Adds text span and font to draw it to the text buffer.
   */
  @JvmOverloads
  public final fun shapedTextAddString(
    shaped: RID,
    text: String,
    fonts: VariantArray<RID>,
    size: Long,
    opentypeFeatures: Dictionary<Any?, Any?> = Dictionary(),
    language: String = "",
    meta: Any? = null,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, STRING to text, ARRAY to fonts, LONG to size, DICTIONARY to opentypeFeatures, STRING to language, ANY to meta)
    TransferContext.callMethod(MethodBindings.shapedTextAddStringPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds inline object to the text buffer, [key] must be unique. In the text, object is represented
   * as [length] object replacement characters.
   */
  @JvmOverloads
  public final fun shapedTextAddObject(
    shaped: RID,
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment = InlineAlignment.CENTER,
    length: Long = 1,
    baseline: Double = 0.0,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, ANY to key, VECTOR2 to size, LONG to inlineAlign.value, LONG to length, DOUBLE to baseline)
    TransferContext.callMethod(MethodBindings.shapedTextAddObjectPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets new size and alignment of embedded object.
   */
  @JvmOverloads
  public final fun shapedTextResizeObject(
    shaped: RID,
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment = InlineAlignment.CENTER,
    baseline: Double = 0.0,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, ANY to key, VECTOR2 to size, LONG to inlineAlign.value, DOUBLE to baseline)
    TransferContext.callMethod(MethodBindings.shapedTextResizeObjectPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if an object with [key] is embedded in this shaped text buffer.
   */
  public final fun shapedTextHasObject(shaped: RID, key: Any?): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, ANY to key)
    TransferContext.callMethod(MethodBindings.shapedTextHasObjectPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the text buffer source text, including object replacement characters.
   */
  public final fun shapedGetText(shaped: RID): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedGetTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns number of text spans added using [shapedTextAddString] or [shapedTextAddObject].
   */
  public final fun shapedGetSpanCount(shaped: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedGetSpanCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns text span metadata.
   */
  public final fun shapedGetSpanMeta(shaped: RID, index: Long): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetSpanMetaPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns text embedded object key.
   */
  public final fun shapedGetSpanEmbeddedObject(shaped: RID, index: Long): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetSpanEmbeddedObjectPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the text span source text.
   */
  public final fun shapedGetSpanText(shaped: RID, index: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetSpanTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the text span embedded object key.
   */
  public final fun shapedGetSpanObject(shaped: RID, index: Long): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetSpanObjectPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Changes text span font, font size, and OpenType features, without changing the text.
   */
  @JvmOverloads
  public final fun shapedSetSpanUpdateFont(
    shaped: RID,
    index: Long,
    fonts: VariantArray<RID>,
    size: Long,
    opentypeFeatures: Dictionary<Any?, Any?> = Dictionary(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index, ARRAY to fonts, LONG to size, DICTIONARY to opentypeFeatures)
    TransferContext.callMethod(MethodBindings.shapedSetSpanUpdateFontPtr)
  }

  /**
   * Returns the number of uniform text runs in the buffer.
   */
  public final fun shapedGetRunCount(shaped: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedGetRunCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the source text of the [index] text run (in visual order).
   */
  public final fun shapedGetRunText(shaped: RID, index: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetRunTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the source text range of the [index] text run (in visual order).
   */
  public final fun shapedGetRunRange(shaped: RID, index: Long): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetRunRangePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the glyph range of the [index] text run (in visual order).
   */
  public final fun shapedGetRunGlyphRange(shaped: RID, index: Long): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetRunGlyphRangePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the font RID of the [index] text run (in visual order).
   */
  public final fun shapedGetRunFontRid(shaped: RID, index: Long): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetRunFontRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the font size of the [index] text run (in visual order).
   */
  public final fun shapedGetRunFontSize(shaped: RID, index: Long): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetRunFontSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the language of the [index] text run (in visual order).
   */
  public final fun shapedGetRunLanguage(shaped: RID, index: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetRunLanguagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the direction of the [index] text run (in visual order).
   */
  public final fun shapedGetRunDirection(shaped: RID, index: Long): Direction {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetRunDirectionPtr)
    return Direction.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the embedded object of the [index] text run (in visual order).
   */
  public final fun shapedGetRunObject(shaped: RID, index: Long): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to index)
    TransferContext.callMethod(MethodBindings.shapedGetRunObjectPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns text buffer for the substring of the text in the [shaped] text buffer (including inline
   * objects).
   */
  public final fun shapedTextSubstr(
    shaped: RID,
    start: Long,
    length: Long,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to start, LONG to length)
    TransferContext.callMethod(MethodBindings.shapedTextSubstrPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the parent buffer from which the substring originates.
   */
  public final fun shapedTextGetParent(shaped: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetParentPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Adjusts text width to fit to specified width, returns new text width.
   */
  @JvmOverloads
  public final fun shapedTextFitToWidth(
    shaped: RID,
    width: Double,
    justificationFlags: JustificationFlag = TextServer.JustificationFlag(3),
  ): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, DOUBLE to width, LONG to justificationFlags.flag)
    TransferContext.callMethod(MethodBindings.shapedTextFitToWidthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Aligns shaped text to the given tab-stops.
   */
  public final fun shapedTextTabAlign(shaped: RID, tabStops: PackedFloat32Array): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, PACKED_FLOAT_32_ARRAY to tabStops)
    TransferContext.callMethod(MethodBindings.shapedTextTabAlignPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Shapes buffer if it's not shaped. Returns `true` if the string is shaped successfully.
   *
   * **Note:** It is not necessary to call this function manually, buffer will be shaped
   * automatically as soon as any of its output data is requested.
   */
  public final fun shapedTextShape(shaped: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextShapePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if buffer is successfully shaped.
   */
  public final fun shapedTextIsReady(shaped: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextIsReadyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if text buffer contains any visible characters.
   */
  public final fun shapedTextHasVisibleChars(shaped: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextHasVisibleCharsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns an array of glyphs in the visual order.
   */
  public final fun shapedTextGetGlyphs(shaped: RID): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetGlyphsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns text glyphs in the logical order.
   */
  public final fun shapedTextSortLogical(shaped: RID): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextSortLogicalPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns number of glyphs in the buffer.
   */
  public final fun shapedTextGetGlyphCount(shaped: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetGlyphCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns substring buffer character range in the parent buffer.
   */
  public final fun shapedTextGetRange(shaped: RID): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetRangePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Breaks text to the lines and columns. Returns character ranges for each segment.
   */
  @JvmOverloads
  public final fun shapedTextGetLineBreaksAdv(
    shaped: RID,
    width: PackedFloat32Array,
    start: Long = 0,
    once: Boolean = true,
    breakFlags: LineBreakFlag = TextServer.LineBreakFlag(3),
  ): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, PACKED_FLOAT_32_ARRAY to width, LONG to start, BOOL to once, LONG to breakFlags.flag)
    TransferContext.callMethod(MethodBindings.shapedTextGetLineBreaksAdvPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Breaks text to the lines and returns character ranges for each line.
   */
  @JvmOverloads
  public final fun shapedTextGetLineBreaks(
    shaped: RID,
    width: Double,
    start: Long = 0,
    breakFlags: LineBreakFlag = TextServer.LineBreakFlag(3),
  ): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, DOUBLE to width, LONG to start, LONG to breakFlags.flag)
    TransferContext.callMethod(MethodBindings.shapedTextGetLineBreaksPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Breaks text into words and returns array of character ranges. Use [graphemeFlags] to set what
   * characters are used for breaking.
   */
  @JvmOverloads
  public final fun shapedTextGetWordBreaks(
    shaped: RID,
    graphemeFlags: GraphemeFlag = TextServer.GraphemeFlag(264),
    skipGraphemeFlags: GraphemeFlag = TextServer.GraphemeFlag.IS_VIRTUAL,
  ): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to graphemeFlags.flag, LONG to skipGraphemeFlags.flag)
    TransferContext.callMethod(MethodBindings.shapedTextGetWordBreaksPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns the position of the overrun trim.
   */
  public final fun shapedTextGetTrimPos(shaped: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetTrimPosPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns position of the ellipsis.
   */
  public final fun shapedTextGetEllipsisPos(shaped: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetEllipsisPosPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns array of the glyphs in the ellipsis.
   */
  public final fun shapedTextGetEllipsisGlyphs(shaped: RID): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetEllipsisGlyphsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns number of glyphs in the ellipsis.
   */
  public final fun shapedTextGetEllipsisGlyphCount(shaped: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetEllipsisGlyphCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Trims text if it exceeds the given width.
   */
  @JvmOverloads
  public final fun shapedTextOverrunTrimToWidth(
    shaped: RID,
    width: Double = 0.0,
    overrunTrimFlags: TextOverrunFlag = TextServer.TextOverrunFlag.OVERRUN_NO_TRIM,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, DOUBLE to width, LONG to overrunTrimFlags.flag)
    TransferContext.callMethod(MethodBindings.shapedTextOverrunTrimToWidthPtr)
  }

  /**
   * Returns array of inline objects.
   */
  public final fun shapedTextGetObjects(shaped: RID): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetObjectsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns bounding rectangle of the inline object.
   */
  public final fun shapedTextGetObjectRect(shaped: RID, key: Any?): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, ANY to key)
    TransferContext.callMethod(MethodBindings.shapedTextGetObjectRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Returns the character range of the inline object.
   */
  public final fun shapedTextGetObjectRange(shaped: RID, key: Any?): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, ANY to key)
    TransferContext.callMethod(MethodBindings.shapedTextGetObjectRangePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the glyph index of the inline object.
   */
  public final fun shapedTextGetObjectGlyph(shaped: RID, key: Any?): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, ANY to key)
    TransferContext.callMethod(MethodBindings.shapedTextGetObjectGlyphPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns size of the text.
   */
  public final fun shapedTextGetSize(shaped: RID): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the text ascent (number of pixels above the baseline for horizontal layout or to the
   * left of baseline for vertical).
   *
   * **Note:** Overall ascent can be higher than font ascent, if some glyphs are displaced from the
   * baseline.
   */
  public final fun shapedTextGetAscent(shaped: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetAscentPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns the text descent (number of pixels below the baseline for horizontal layout or to the
   * right of baseline for vertical).
   *
   * **Note:** Overall descent can be higher than font descent, if some glyphs are displaced from
   * the baseline.
   */
  public final fun shapedTextGetDescent(shaped: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetDescentPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns width (for horizontal layout) or height (for vertical) of the text.
   */
  public final fun shapedTextGetWidth(shaped: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetWidthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns pixel offset of the underline below the baseline.
   */
  public final fun shapedTextGetUnderlinePosition(shaped: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetUnderlinePositionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns thickness of the underline.
   */
  public final fun shapedTextGetUnderlineThickness(shaped: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetUnderlineThicknessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns shapes of the carets corresponding to the character offset [position] in the text.
   * Returned caret shape is 1 pixel wide rectangle.
   */
  public final fun shapedTextGetCarets(shaped: RID, position: Long): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to position)
    TransferContext.callMethod(MethodBindings.shapedTextGetCaretsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns selection rectangles for the specified character range.
   */
  public final fun shapedTextGetSelection(
    shaped: RID,
    start: Long,
    end: Long,
  ): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to start, LONG to end)
    TransferContext.callMethod(MethodBindings.shapedTextGetSelectionPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Returns grapheme index at the specified pixel offset at the baseline, or `-1` if none is found.
   */
  public final fun shapedTextHitTestGrapheme(shaped: RID, coords: Double): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, DOUBLE to coords)
    TransferContext.callMethod(MethodBindings.shapedTextHitTestGraphemePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns caret character offset at the specified pixel offset at the baseline. This function
   * always returns a valid position.
   */
  public final fun shapedTextHitTestPosition(shaped: RID, coords: Double): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, DOUBLE to coords)
    TransferContext.callMethod(MethodBindings.shapedTextHitTestPositionPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns composite character's bounds as offsets from the start of the line.
   */
  public final fun shapedTextGetGraphemeBounds(shaped: RID, pos: Long): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to pos)
    TransferContext.callMethod(MethodBindings.shapedTextGetGraphemeBoundsPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns grapheme end position closest to the [pos].
   */
  public final fun shapedTextNextGraphemePos(shaped: RID, pos: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to pos)
    TransferContext.callMethod(MethodBindings.shapedTextNextGraphemePosPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns grapheme start position closest to the [pos].
   */
  public final fun shapedTextPrevGraphemePos(shaped: RID, pos: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to pos)
    TransferContext.callMethod(MethodBindings.shapedTextPrevGraphemePosPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns array of the composite character boundaries.
   */
  public final fun shapedTextGetCharacterBreaks(shaped: RID): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped)
    TransferContext.callMethod(MethodBindings.shapedTextGetCharacterBreaksPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns composite character end position closest to the [pos].
   */
  public final fun shapedTextNextCharacterPos(shaped: RID, pos: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to pos)
    TransferContext.callMethod(MethodBindings.shapedTextNextCharacterPosPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns composite character start position closest to the [pos].
   */
  public final fun shapedTextPrevCharacterPos(shaped: RID, pos: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to pos)
    TransferContext.callMethod(MethodBindings.shapedTextPrevCharacterPosPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns composite character position closest to the [pos].
   */
  public final fun shapedTextClosestCharacterPos(shaped: RID, pos: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to pos)
    TransferContext.callMethod(MethodBindings.shapedTextClosestCharacterPosPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Draw shaped text into a canvas item at a given position, with [color]. [pos] specifies the
   * leftmost point of the baseline (for horizontal layout) or topmost point of the baseline (for
   * vertical layout). If [oversampling] is greater than zero, it is used as font oversampling factor,
   * otherwise viewport oversampling settings are used.
   *
   * [clipL] and [clipR] are offsets relative to [pos], going to the right in horizontal layout and
   * downward in vertical layout. If [clipL] is not negative, glyphs starting before the offset are
   * clipped. If [clipR] is not negative, glyphs ending after the offset are clipped.
   */
  @JvmOverloads
  public final fun shapedTextDraw(
    shaped: RID,
    canvas: RID,
    pos: Vector2,
    clipL: Double = -1.0,
    clipR: Double = -1.0,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, _RID to canvas, VECTOR2 to pos, DOUBLE to clipL, DOUBLE to clipR, COLOR to color, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.shapedTextDrawPtr)
  }

  /**
   * Draw the outline of the shaped text into a canvas item at a given position, with [color]. [pos]
   * specifies the leftmost point of the baseline (for horizontal layout) or topmost point of the
   * baseline (for vertical layout). If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   *
   * [clipL] and [clipR] are offsets relative to [pos], going to the right in horizontal layout and
   * downward in vertical layout. If [clipL] is not negative, glyphs starting before the offset are
   * clipped. If [clipR] is not negative, glyphs ending after the offset are clipped.
   */
  @JvmOverloads
  public final fun shapedTextDrawOutline(
    shaped: RID,
    canvas: RID,
    pos: Vector2,
    clipL: Double = -1.0,
    clipR: Double = -1.0,
    outlineSize: Long = 1,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, _RID to canvas, VECTOR2 to pos, DOUBLE to clipL, DOUBLE to clipR, LONG to outlineSize, COLOR to color, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.shapedTextDrawOutlinePtr)
  }

  /**
   * Returns dominant direction of in the range of text.
   */
  public final fun shapedTextGetDominantDirectionInRange(
    shaped: RID,
    start: Long,
    end: Long,
  ): Direction {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaped, LONG to start, LONG to end)
    TransferContext.callMethod(MethodBindings.shapedTextGetDominantDirectionInRangePtr)
    return Direction.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Converts a number from Western Arabic (0..9) to the numeral system used in the given
   * [language].
   *
   * If [language] is an empty string, the active locale will be used.
   */
  @JvmOverloads
  public final fun formatNumber(number: String, language: String = ""): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to number, STRING to language)
    TransferContext.callMethod(MethodBindings.formatNumberPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Converts [number] from the numeral system used in the given [language] to Western Arabic
   * (0..9).
   *
   * If [language] is an empty string, the active locale will be used.
   */
  @JvmOverloads
  public final fun parseNumber(number: String, language: String = ""): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to number, STRING to language)
    TransferContext.callMethod(MethodBindings.parseNumberPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the percent sign used in the given [language].
   *
   * If [language] is an empty string, the active locale will be used.
   */
  @JvmOverloads
  public final fun percentSign(language: String = ""): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to language)
    TransferContext.callMethod(MethodBindings.percentSignPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns an array of the word break boundaries. Elements in the returned array are the offsets
   * of the start and end of words. Therefore the length of the array is always even.
   *
   * When [charsPerLine] is greater than zero, line break boundaries are returned instead.
   *
   * ```
   * var ts = TextServerManager.get_primary_interface()
   * # Corresponds to the substrings "The", "Godot", "Engine", and "4".
   * print(ts.string_get_word_breaks("The Godot Engine, 4")) # Prints [0, 3, 4, 9, 10, 16, 18, 19]
   * # Corresponds to the substrings "The", "Godot", "Engin", and "e, 4".
   * print(ts.string_get_word_breaks("The Godot Engine, 4", "en", 5)) # Prints [0, 3, 4, 9, 10, 15,
   * 15, 19]
   * # Corresponds to the substrings "The Godot" and "Engine, 4".
   * print(ts.string_get_word_breaks("The Godot Engine, 4", "en", 10)) # Prints [0, 9, 10, 19]
   * ```
   */
  @JvmOverloads
  public final fun stringGetWordBreaks(
    string: String,
    language: String = "",
    charsPerLine: Long = 0,
  ): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string, STRING to language, LONG to charsPerLine)
    TransferContext.callMethod(MethodBindings.stringGetWordBreaksPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns array of the composite character boundaries.
   *
   * ```
   * var ts = TextServerManager.get_primary_interface()
   * print(ts.string_get_character_breaks("Test ❤️‍🔥 Test")) # Prints [1, 2, 3, 4, 5, 9, 10, 11,
   * 12, 13, 14]
   * ```
   */
  @JvmOverloads
  public final fun stringGetCharacterBreaks(string: String, language: String = ""):
      PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string, STRING to language)
    TransferContext.callMethod(MethodBindings.stringGetCharacterBreaksPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns index of the first string in [dict] which is visually confusable with the [string], or
   * `-1` if none is found.
   *
   * **Note:** This method doesn't detect invisible characters, for spoof detection use it in
   * combination with [spoofCheck].
   *
   * **Note:** Always returns `-1` if the server does not support the [FEATURE_UNICODE_SECURITY]
   * feature.
   */
  public final fun isConfusable(string: String, dict: PackedStringArray): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string, PACKED_STRING_ARRAY to dict)
    TransferContext.callMethod(MethodBindings.isConfusablePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if [string] is likely to be an attempt at confusing the reader.
   *
   * **Note:** Always returns `false` if the server does not support the [FEATURE_UNICODE_SECURITY]
   * feature.
   */
  public final fun spoofCheck(string: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string)
    TransferContext.callMethod(MethodBindings.spoofCheckPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Strips diacritics from the string.
   *
   * **Note:** The result may be longer or shorter than the original.
   */
  public final fun stripDiacritics(string: String): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string)
    TransferContext.callMethod(MethodBindings.stripDiacriticsPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if [string] is a valid identifier.
   *
   * If the text server supports the [FEATURE_UNICODE_IDENTIFIERS] feature, a valid identifier must:
   *
   * - Conform to normalization form C.
   *
   * - Begin with a Unicode character of class XID_Start or `"_"`.
   *
   * - May contain Unicode characters of class XID_Continue in the other positions.
   *
   * - Use UAX #31 recommended scripts only (mixed scripts are allowed).
   *
   * If the [FEATURE_UNICODE_IDENTIFIERS] feature is not supported, a valid identifier must:
   *
   * - Begin with a Unicode character of class XID_Start or `"_"`.
   *
   * - May contain Unicode characters of class XID_Continue in the other positions.
   */
  public final fun isValidIdentifier(string: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string)
    TransferContext.callMethod(MethodBindings.isValidIdentifierPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the given code point is a valid letter, i.e. it belongs to the Unicode
   * category "L".
   */
  public final fun isValidLetter(unicode: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to unicode)
    TransferContext.callMethod(MethodBindings.isValidLetterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the string converted to `UPPERCASE`.
   *
   * **Note:** Casing is locale dependent and context sensitive if server support
   * [FEATURE_CONTEXT_SENSITIVE_CASE_CONVERSION] feature (supported by [TextServerAdvanced]).
   *
   * **Note:** The result may be longer or shorter than the original.
   */
  @JvmOverloads
  public final fun stringToUpper(string: String, language: String = ""): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string, STRING to language)
    TransferContext.callMethod(MethodBindings.stringToUpperPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the string converted to `lowercase`.
   *
   * **Note:** Casing is locale dependent and context sensitive if server support
   * [FEATURE_CONTEXT_SENSITIVE_CASE_CONVERSION] feature (supported by [TextServerAdvanced]).
   *
   * **Note:** The result may be longer or shorter than the original.
   */
  @JvmOverloads
  public final fun stringToLower(string: String, language: String = ""): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string, STRING to language)
    TransferContext.callMethod(MethodBindings.stringToLowerPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the string converted to `Title Case`.
   *
   * **Note:** Casing is locale dependent and context sensitive if server support
   * [FEATURE_CONTEXT_SENSITIVE_CASE_CONVERSION] feature (supported by [TextServerAdvanced]).
   *
   * **Note:** The result may be longer or shorter than the original.
   */
  @JvmOverloads
  public final fun stringToTitle(string: String, language: String = ""): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string, STRING to language)
    TransferContext.callMethod(MethodBindings.stringToTitlePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Default implementation of the BiDi algorithm override function.
   */
  public final fun parseStructuredText(
    parserType: StructuredTextParser,
    args: VariantArray<Any?>,
    text: String,
  ): VariantArray<Vector3i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to parserType.value, ARRAY to args, STRING to text)
    TransferContext.callMethod(MethodBindings.parseStructuredTextPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector3i>)
  }

  public enum class FontAntialiasing(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Font glyphs are rasterized as 1-bit bitmaps.
     */
    NONE(0),
    /**
     * Font glyphs are rasterized as 8-bit grayscale anti-aliased bitmaps.
     */
    GRAY(1),
    /**
     * Font glyphs are rasterized for LCD screens.
     *
     * LCD subpixel layout is determined by the value of the
     * [ProjectSettings.gui/theme/lcdSubpixelLayout] setting.
     *
     * LCD subpixel anti-aliasing mode is suitable only for rendering horizontal, unscaled text in
     * 2D.
     */
    LCD(2),
    ;

    public companion object {
      public fun from(`value`: Long): FontAntialiasing = entries.single { it.`value` == `value` }
    }
  }

  public enum class FontLCDSubpixelLayout(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Unknown or unsupported subpixel layout, LCD subpixel antialiasing is disabled.
     */
    NONE(0),
    /**
     * Horizontal RGB subpixel layout.
     */
    HRGB(1),
    /**
     * Horizontal BGR subpixel layout.
     */
    HBGR(2),
    /**
     * Vertical RGB subpixel layout.
     */
    VRGB(3),
    /**
     * Vertical BGR subpixel layout.
     */
    VBGR(4),
    /**
     * Represents the size of the [FontLCDSubpixelLayout] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): FontLCDSubpixelLayout =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class Direction(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Text direction is determined based on contents and current locale.
     */
    AUTO(0),
    /**
     * Text is written from left to right.
     */
    LTR(1),
    /**
     * Text is written from right to left.
     */
    RTL(2),
    /**
     * Text writing direction is the same as base string writing direction. Used for BiDi override
     * only.
     */
    INHERITED(3),
    ;

    public companion object {
      public fun from(`value`: Long): Direction = entries.single { it.`value` == `value` }
    }
  }

  public enum class Orientation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Text is written horizontally.
     */
    HORIZONTAL(0),
    /**
     * Left to right text is written vertically from top to bottom.
     *
     * Right to left text is written vertically from bottom to top.
     */
    VERTICAL(1),
    ;

    public companion object {
      public fun from(`value`: Long): Orientation = entries.single { it.`value` == `value` }
    }
  }

  public class JustificationFlag(
    flag: Long,
  ) : BitFieldBase<JustificationFlag>(flag) {
    protected override fun wrap(flag: Long): JustificationFlag = JustificationFlag(flag)

    public companion object {
      /**
       * Do not justify text.
       */
      @JvmField
      public val NONE: JustificationFlag = JustificationFlag(0)

      /**
       * Justify text by adding and removing kashidas.
       */
      @JvmField
      public val KASHIDA: JustificationFlag = JustificationFlag(1)

      /**
       * Justify text by changing width of the spaces between the words.
       */
      @JvmField
      public val WORD_BOUND: JustificationFlag = JustificationFlag(2)

      /**
       * Remove trailing and leading spaces from the justified text.
       */
      @JvmField
      public val TRIM_EDGE_SPACES: JustificationFlag = JustificationFlag(4)

      /**
       * Only apply justification to the part of the text after the last tab.
       */
      @JvmField
      public val AFTER_LAST_TAB: JustificationFlag = JustificationFlag(8)

      /**
       * Apply justification to the trimmed line with ellipsis.
       */
      @JvmField
      public val CONSTRAIN_ELLIPSIS: JustificationFlag = JustificationFlag(16)

      /**
       * Do not apply justification to the last line of the paragraph.
       */
      @JvmField
      public val SKIP_LAST_LINE: JustificationFlag = JustificationFlag(32)

      /**
       * Do not apply justification to the last line of the paragraph with visible characters (takes
       * precedence over [JUSTIFICATION_SKIP_LAST_LINE]).
       */
      @JvmField
      public val SKIP_LAST_LINE_WITH_VISIBLE_CHARS: JustificationFlag = JustificationFlag(64)

      /**
       * Always apply justification to the paragraphs with a single line
       * ([JUSTIFICATION_SKIP_LAST_LINE] and [JUSTIFICATION_SKIP_LAST_LINE_WITH_VISIBLE_CHARS] are
       * ignored).
       */
      @JvmField
      public val DO_NOT_SKIP_SINGLE_LINE: JustificationFlag = JustificationFlag(128)
    }
  }

  public enum class AutowrapMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Autowrap is disabled.
     */
    OFF(0),
    /**
     * Wraps the text inside the node's bounding rectangle by allowing to break lines at arbitrary
     * positions, which is useful when very limited space is available.
     */
    ARBITRARY(1),
    /**
     * Wraps the text inside the node's bounding rectangle by soft-breaking between words.
     */
    WORD(2),
    /**
     * Behaves similarly to [AUTOWRAP_WORD], but force-breaks a word if that single word does not
     * fit in one line.
     */
    WORD_SMART(3),
    ;

    public companion object {
      public fun from(`value`: Long): AutowrapMode = entries.single { it.`value` == `value` }
    }
  }

  public class LineBreakFlag(
    flag: Long,
  ) : BitFieldBase<LineBreakFlag>(flag) {
    protected override fun wrap(flag: Long): LineBreakFlag = LineBreakFlag(flag)

    public companion object {
      /**
       * Do not break the line.
       */
      @JvmField
      public val BREAK_NONE: LineBreakFlag = LineBreakFlag(0)

      /**
       * Break the line at the line mandatory break characters (e.g. `"\n"`).
       */
      @JvmField
      public val BREAK_MANDATORY: LineBreakFlag = LineBreakFlag(1)

      /**
       * Break the line between the words.
       */
      @JvmField
      public val BREAK_WORD_BOUND: LineBreakFlag = LineBreakFlag(2)

      /**
       * Break the line between any unconnected graphemes.
       */
      @JvmField
      public val BREAK_GRAPHEME_BOUND: LineBreakFlag = LineBreakFlag(4)

      /**
       * Should be used only in conjunction with [BREAK_WORD_BOUND], break the line between any
       * unconnected graphemes, if it's impossible to break it between the words.
       */
      @JvmField
      public val BREAK_ADAPTIVE: LineBreakFlag = LineBreakFlag(8)

      /**
       * Remove edge spaces from the broken line segments.
       */
      @JvmField
      public val BREAK_TRIM_EDGE_SPACES: LineBreakFlag = LineBreakFlag(16)

      /**
       * Subtract first line indentation width from all lines after the first one.
       */
      @JvmField
      public val BREAK_TRIM_INDENT: LineBreakFlag = LineBreakFlag(32)

      /**
       * Remove spaces and line break characters from the start of broken line segments.
       *
       * E.g, after line breaking, the second segment of the following text `test  \n  next`, is
       * `next` if the flag is set, and `  next` if it is not.
       */
      @JvmField
      public val BREAK_TRIM_START_EDGE_SPACES: LineBreakFlag = LineBreakFlag(64)

      /**
       * Remove spaces and line break characters from the end of broken line segments.
       *
       * E.g, after line breaking, the first segment of the following text `test  \n  next`, is
       * `test` if the flag is set, and `test  \n` if it is not.
       */
      @JvmField
      public val BREAK_TRIM_END_EDGE_SPACES: LineBreakFlag = LineBreakFlag(128)
    }
  }

  public enum class VisibleCharactersBehavior(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Trims text before the shaping. e.g, increasing [Label.visibleCharacters] or
     * [RichTextLabel.visibleCharacters] value is visually identical to typing the text.
     *
     * **Note:** In this mode, trimmed text is not processed at all. It is not accounted for in line
     * breaking and size calculations.
     */
    VC_CHARS_BEFORE_SHAPING(0),
    /**
     * Displays glyphs that are mapped to the first [Label.visibleCharacters] or
     * [RichTextLabel.visibleCharacters] characters from the beginning of the text.
     */
    VC_CHARS_AFTER_SHAPING(1),
    /**
     * Displays [Label.visibleRatio] or [RichTextLabel.visibleRatio] glyphs, starting from the left
     * or from the right, depending on [Control.layoutDirection] value.
     */
    VC_GLYPHS_AUTO(2),
    /**
     * Displays [Label.visibleRatio] or [RichTextLabel.visibleRatio] glyphs, starting from the left.
     */
    VC_GLYPHS_LTR(3),
    /**
     * Displays [Label.visibleRatio] or [RichTextLabel.visibleRatio] glyphs, starting from the
     * right.
     */
    VC_GLYPHS_RTL(4),
    ;

    public companion object {
      public fun from(`value`: Long): VisibleCharactersBehavior =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class OverrunBehavior(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No text trimming is performed.
     */
    NO_TRIMMING(0),
    /**
     * Trims the text per character.
     */
    TRIM_CHAR(1),
    /**
     * Trims the text per word.
     */
    TRIM_WORD(2),
    /**
     * Trims the text per character and adds an ellipsis to indicate that parts are hidden if
     * trimmed text is 6 characters or longer.
     */
    TRIM_ELLIPSIS(3),
    /**
     * Trims the text per word and adds an ellipsis to indicate that parts are hidden if trimmed
     * text is 6 characters or longer.
     */
    TRIM_WORD_ELLIPSIS(4),
    /**
     * Trims the text per character and adds an ellipsis to indicate that parts are hidden
     * regardless of trimmed text length.
     */
    TRIM_ELLIPSIS_FORCE(5),
    /**
     * Trims the text per word and adds an ellipsis to indicate that parts are hidden regardless of
     * trimmed text length.
     */
    TRIM_WORD_ELLIPSIS_FORCE(6),
    ;

    public companion object {
      public fun from(`value`: Long): OverrunBehavior = entries.single { it.`value` == `value` }
    }
  }

  public class TextOverrunFlag(
    flag: Long,
  ) : BitFieldBase<TextOverrunFlag>(flag) {
    protected override fun wrap(flag: Long): TextOverrunFlag = TextOverrunFlag(flag)

    public companion object {
      /**
       * No trimming is performed.
       */
      @JvmField
      public val OVERRUN_NO_TRIM: TextOverrunFlag = TextOverrunFlag(0)

      /**
       * Trims the text when it exceeds the given width.
       */
      @JvmField
      public val OVERRUN_TRIM: TextOverrunFlag = TextOverrunFlag(1)

      /**
       * Trims the text per word instead of per grapheme.
       */
      @JvmField
      public val OVERRUN_TRIM_WORD_ONLY: TextOverrunFlag = TextOverrunFlag(2)

      /**
       * Determines whether an ellipsis should be added at the end of the text.
       */
      @JvmField
      public val OVERRUN_ADD_ELLIPSIS: TextOverrunFlag = TextOverrunFlag(4)

      /**
       * Determines whether the ellipsis at the end of the text is enforced and may not be hidden.
       */
      @JvmField
      public val OVERRUN_ENFORCE_ELLIPSIS: TextOverrunFlag = TextOverrunFlag(8)

      /**
       * Accounts for the text being justified before attempting to trim it (see
       * [JustificationFlag]).
       */
      @JvmField
      public val OVERRUN_JUSTIFICATION_AWARE: TextOverrunFlag = TextOverrunFlag(16)

      /**
       * Determines whether the ellipsis should be added regardless of the string length, otherwise
       * it is added only if the string is 6 characters or longer.
       */
      @JvmField
      public val OVERRUN_SHORT_STRING_ELLIPSIS: TextOverrunFlag = TextOverrunFlag(32)
    }
  }

  public class GraphemeFlag(
    flag: Long,
  ) : BitFieldBase<GraphemeFlag>(flag) {
    protected override fun wrap(flag: Long): GraphemeFlag = GraphemeFlag(flag)

    public companion object {
      /**
       * Grapheme is supported by the font, and can be drawn.
       */
      @JvmField
      public val IS_VALID: GraphemeFlag = GraphemeFlag(1)

      /**
       * Grapheme is part of right-to-left or bottom-to-top run.
       */
      @JvmField
      public val IS_RTL: GraphemeFlag = GraphemeFlag(2)

      /**
       * Grapheme is not part of source text, it was added by justification process.
       */
      @JvmField
      public val IS_VIRTUAL: GraphemeFlag = GraphemeFlag(4)

      /**
       * Grapheme is whitespace.
       */
      @JvmField
      public val IS_SPACE: GraphemeFlag = GraphemeFlag(8)

      /**
       * Grapheme is mandatory break point (e.g. `"\n"`).
       */
      @JvmField
      public val IS_BREAK_HARD: GraphemeFlag = GraphemeFlag(16)

      /**
       * Grapheme is optional break point (e.g. space).
       */
      @JvmField
      public val IS_BREAK_SOFT: GraphemeFlag = GraphemeFlag(32)

      /**
       * Grapheme is the tabulation character.
       */
      @JvmField
      public val IS_TAB: GraphemeFlag = GraphemeFlag(64)

      /**
       * Grapheme is kashida.
       */
      @JvmField
      public val IS_ELONGATION: GraphemeFlag = GraphemeFlag(128)

      /**
       * Grapheme is punctuation character.
       */
      @JvmField
      public val IS_PUNCTUATION: GraphemeFlag = GraphemeFlag(256)

      /**
       * Grapheme is underscore character.
       */
      @JvmField
      public val IS_UNDERSCORE: GraphemeFlag = GraphemeFlag(512)

      /**
       * Grapheme is connected to the previous grapheme. Breaking line before this grapheme is not
       * safe.
       */
      @JvmField
      public val IS_CONNECTED: GraphemeFlag = GraphemeFlag(1024)

      /**
       * It is safe to insert a U+0640 before this grapheme for elongation.
       */
      @JvmField
      public val IS_SAFE_TO_INSERT_TATWEEL: GraphemeFlag = GraphemeFlag(2048)

      /**
       * Grapheme is an object replacement character for the embedded object.
       */
      @JvmField
      public val IS_EMBEDDED_OBJECT: GraphemeFlag = GraphemeFlag(4096)

      /**
       * Grapheme is a soft hyphen.
       */
      @JvmField
      public val IS_SOFT_HYPHEN: GraphemeFlag = GraphemeFlag(8192)
    }
  }

  public enum class Hinting(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables font hinting (smoother but less crisp).
     */
    NONE(0),
    /**
     * Use the light font hinting mode.
     */
    LIGHT(1),
    /**
     * Use the default font hinting mode (crisper but less smooth).
     *
     * **Note:** This hinting mode changes both horizontal and vertical glyph metrics. If applied to
     * monospace font, some glyphs might have different width.
     */
    NORMAL(2),
    ;

    public companion object {
      public fun from(`value`: Long): Hinting = entries.single { it.`value` == `value` }
    }
  }

  public enum class SubpixelPositioning(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Glyph horizontal position is rounded to the whole pixel size, each glyph is rasterized once.
     */
    DISABLED(0),
    /**
     * Glyph horizontal position is rounded based on font size.
     *
     * - To one quarter of the pixel size if font size is smaller or equal to
     * [SUBPIXEL_POSITIONING_ONE_QUARTER_MAX_SIZE].
     *
     * - To one half of the pixel size if font size is smaller or equal to
     * [SUBPIXEL_POSITIONING_ONE_HALF_MAX_SIZE].
     *
     * - To the whole pixel size for larger fonts.
     */
    AUTO(1),
    /**
     * Glyph horizontal position is rounded to one half of the pixel size, each glyph is rasterized
     * up to two times.
     */
    ONE_HALF(2),
    /**
     * Glyph horizontal position is rounded to one quarter of the pixel size, each glyph is
     * rasterized up to four times.
     */
    ONE_QUARTER(3),
    /**
     * Maximum font size which will use "one half of the pixel" subpixel positioning in
     * [SUBPIXEL_POSITIONING_AUTO] mode.
     */
    ONE_HALF_MAX_SIZE(20),
    /**
     * Maximum font size which will use "one quarter of the pixel" subpixel positioning in
     * [SUBPIXEL_POSITIONING_AUTO] mode.
     */
    ONE_QUARTER_MAX_SIZE(16),
    ;

    public companion object {
      public fun from(`value`: Long): SubpixelPositioning = entries.single { it.`value` == `value` }
    }
  }

  public enum class Feature(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * TextServer supports simple text layouts.
     */
    SIMPLE_LAYOUT(1),
    /**
     * TextServer supports bidirectional text layouts.
     */
    BIDI_LAYOUT(2),
    /**
     * TextServer supports vertical layouts.
     */
    VERTICAL_LAYOUT(4),
    /**
     * TextServer supports complex text shaping.
     */
    SHAPING(8),
    /**
     * TextServer supports justification using kashidas.
     */
    KASHIDA_JUSTIFICATION(16),
    /**
     * TextServer supports complex line/word breaking rules (e.g. dictionary based).
     */
    BREAK_ITERATORS(32),
    /**
     * TextServer supports loading bitmap fonts.
     */
    FONT_BITMAP(64),
    /**
     * TextServer supports loading dynamic (TrueType, OpeType, etc.) fonts.
     */
    FONT_DYNAMIC(128),
    /**
     * TextServer supports multichannel signed distance field dynamic font rendering.
     */
    FONT_MSDF(256),
    /**
     * TextServer supports loading system fonts.
     */
    FONT_SYSTEM(512),
    /**
     * TextServer supports variable fonts.
     */
    FONT_VARIABLE(1024),
    /**
     * TextServer supports locale dependent and context sensitive case conversion.
     */
    CONTEXT_SENSITIVE_CASE_CONVERSION(2048),
    /**
     * TextServer require external data file for some features, see [loadSupportData].
     */
    USE_SUPPORT_DATA(4096),
    /**
     * TextServer supports UAX #31 identifier validation, see [isValidIdentifier].
     */
    UNICODE_IDENTIFIERS(8192),
    /**
     * TextServer supports [url=https://unicode.org/reports/tr36/]Unicode Technical Report #36[/url]
     * and [url=https://unicode.org/reports/tr39/]Unicode Technical Standard #39[/url] based spoof
     * detection features.
     */
    UNICODE_SECURITY(16384),
    ;

    public companion object {
      public fun from(`value`: Long): Feature = entries.single { it.`value` == `value` }
    }
  }

  public enum class ContourPointTag(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Contour point is on the curve.
     */
    CURVE_TAG_ON(1),
    /**
     * Contour point isn't on the curve, but serves as a control point for a conic (quadratic)
     * Bézier arc.
     */
    CURVE_TAG_OFF_CONIC(0),
    /**
     * Contour point isn't on the curve, but serves as a control point for a cubic Bézier arc.
     */
    CURVE_TAG_OFF_CUBIC(2),
    ;

    public companion object {
      public fun from(`value`: Long): ContourPointTag = entries.single { it.`value` == `value` }
    }
  }

  public enum class SpacingType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Spacing for each glyph.
     */
    GLYPH(0),
    /**
     * Spacing for the space character.
     */
    SPACE(1),
    /**
     * Spacing at the top of the line.
     */
    TOP(2),
    /**
     * Spacing at the bottom of the line.
     */
    BOTTOM(3),
    /**
     * Represents the size of the [SpacingType] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): SpacingType = entries.single { it.`value` == `value` }
    }
  }

  public class FontStyle(
    flag: Long,
  ) : BitFieldBase<FontStyle>(flag) {
    protected override fun wrap(flag: Long): FontStyle = FontStyle(flag)

    public companion object {
      /**
       * Font is bold.
       */
      @JvmField
      public val BOLD: FontStyle = FontStyle(1)

      /**
       * Font is italic or oblique.
       */
      @JvmField
      public val ITALIC: FontStyle = FontStyle(2)

      /**
       * Font has fixed-width characters (also known as monospace).
       */
      @JvmField
      public val FIXED_WIDTH: FontStyle = FontStyle(4)
    }
  }

  public enum class StructuredTextParser(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use default Unicode BiDi algorithm.
     */
    DEFAULT(0),
    /**
     * BiDi override for URI.
     */
    URI(1),
    /**
     * BiDi override for file path.
     */
    FILE(2),
    /**
     * BiDi override for email.
     */
    EMAIL(3),
    /**
     * BiDi override for lists. Structured text options: list separator [String].
     */
    LIST(4),
    /**
     * BiDi override for GDScript.
     */
    GDSCRIPT(5),
    /**
     * User defined structured text BiDi override function.
     */
    CUSTOM(6),
    ;

    public companion object {
      public fun from(`value`: Long): StructuredTextParser =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class FixedSizeScaleMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Bitmap font is not scaled.
     */
    DISABLE(0),
    /**
     * Bitmap font is scaled to the closest integer multiple of the font's fixed size. This is the
     * recommended option for pixel art fonts.
     */
    INTEGER_ONLY(1),
    /**
     * Bitmap font is scaled to an arbitrary (fractional) size. This is the recommended option for
     * non-pixel art fonts.
     */
    ENABLED(2),
    ;

    public companion object {
      public fun from(`value`: Long): FixedSizeScaleMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val hasFeatureName: MethodStringName1<TextServer, Boolean, Feature> =
        MethodStringName1<TextServer, Boolean, Feature>("has_feature")

    @JvmField
    public val getNameName: MethodStringName0<TextServer, String> =
        MethodStringName0<TextServer, String>("get_name")

    @JvmField
    public val getFeaturesName: MethodStringName0<TextServer, Long> =
        MethodStringName0<TextServer, Long>("get_features")

    @JvmField
    public val loadSupportDataName: MethodStringName1<TextServer, Boolean, String> =
        MethodStringName1<TextServer, Boolean, String>("load_support_data")

    @JvmField
    public val getSupportDataFilenameName: MethodStringName0<TextServer, String> =
        MethodStringName0<TextServer, String>("get_support_data_filename")

    @JvmField
    public val getSupportDataInfoName: MethodStringName0<TextServer, String> =
        MethodStringName0<TextServer, String>("get_support_data_info")

    @JvmField
    public val saveSupportDataName: MethodStringName1<TextServer, Boolean, String> =
        MethodStringName1<TextServer, Boolean, String>("save_support_data")

    @JvmField
    public val getSupportDataName: MethodStringName0<TextServer, PackedByteArray> =
        MethodStringName0<TextServer, PackedByteArray>("get_support_data")

    @JvmField
    public val isLocaleUsingSupportDataName: MethodStringName1<TextServer, Boolean, String> =
        MethodStringName1<TextServer, Boolean, String>("is_locale_using_support_data")

    @JvmField
    public val isLocaleRightToLeftName: MethodStringName1<TextServer, Boolean, String> =
        MethodStringName1<TextServer, Boolean, String>("is_locale_right_to_left")

    @JvmField
    public val nameToTagName: MethodStringName1<TextServer, Long, String> =
        MethodStringName1<TextServer, Long, String>("name_to_tag")

    @JvmField
    public val tagToNameName: MethodStringName1<TextServer, String, Long> =
        MethodStringName1<TextServer, String, Long>("tag_to_name")

    @JvmField
    public val hasName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("has")

    @JvmField
    public val freeRidName: MethodStringName1<TextServer, Unit, RID> =
        MethodStringName1<TextServer, Unit, RID>("free_rid")

    @JvmField
    public val createFontName: MethodStringName0<TextServer, RID> =
        MethodStringName0<TextServer, RID>("create_font")

    @JvmField
    public val createFontLinkedVariationName: MethodStringName1<TextServer, RID, RID> =
        MethodStringName1<TextServer, RID, RID>("create_font_linked_variation")

    @JvmField
    public val fontSetDataName: MethodStringName2<TextServer, Unit, RID, PackedByteArray> =
        MethodStringName2<TextServer, Unit, RID, PackedByteArray>("font_set_data")

    @JvmField
    public val fontSetFaceIndexName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("font_set_face_index")

    @JvmField
    public val fontGetFaceIndexName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_face_index")

    @JvmField
    public val fontGetFaceCountName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_face_count")

    @JvmField
    public val fontSetStyleName: MethodStringName2<TextServer, Unit, RID, FontStyle> =
        MethodStringName2<TextServer, Unit, RID, FontStyle>("font_set_style")

    @JvmField
    public val fontGetStyleName: MethodStringName1<TextServer, FontStyle, RID> =
        MethodStringName1<TextServer, FontStyle, RID>("font_get_style")

    @JvmField
    public val fontSetNameName: MethodStringName2<TextServer, Unit, RID, String> =
        MethodStringName2<TextServer, Unit, RID, String>("font_set_name")

    @JvmField
    public val fontGetNameName: MethodStringName1<TextServer, String, RID> =
        MethodStringName1<TextServer, String, RID>("font_get_name")

    @JvmField
    public val fontGetOtNameStringsName: MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID>
        = MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID>("font_get_ot_name_strings")

    @JvmField
    public val fontSetStyleNameName: MethodStringName2<TextServer, Unit, RID, String> =
        MethodStringName2<TextServer, Unit, RID, String>("font_set_style_name")

    @JvmField
    public val fontGetStyleNameName: MethodStringName1<TextServer, String, RID> =
        MethodStringName1<TextServer, String, RID>("font_get_style_name")

    @JvmField
    public val fontSetWeightName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("font_set_weight")

    @JvmField
    public val fontGetWeightName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_weight")

    @JvmField
    public val fontSetStretchName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("font_set_stretch")

    @JvmField
    public val fontGetStretchName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_stretch")

    @JvmField
    public val fontSetAntialiasingName: MethodStringName2<TextServer, Unit, RID, FontAntialiasing> =
        MethodStringName2<TextServer, Unit, RID, FontAntialiasing>("font_set_antialiasing")

    @JvmField
    public val fontGetAntialiasingName: MethodStringName1<TextServer, FontAntialiasing, RID> =
        MethodStringName1<TextServer, FontAntialiasing, RID>("font_get_antialiasing")

    @JvmField
    public val fontSetDisableEmbeddedBitmapsName: MethodStringName2<TextServer, Unit, RID, Boolean>
        = MethodStringName2<TextServer, Unit, RID, Boolean>("font_set_disable_embedded_bitmaps")

    @JvmField
    public val fontGetDisableEmbeddedBitmapsName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("font_get_disable_embedded_bitmaps")

    @JvmField
    public val fontSetGenerateMipmapsName: MethodStringName2<TextServer, Unit, RID, Boolean> =
        MethodStringName2<TextServer, Unit, RID, Boolean>("font_set_generate_mipmaps")

    @JvmField
    public val fontGetGenerateMipmapsName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("font_get_generate_mipmaps")

    @JvmField
    public val fontSetMultichannelSignedDistanceFieldName:
        MethodStringName2<TextServer, Unit, RID, Boolean> =
        MethodStringName2<TextServer, Unit, RID, Boolean>("font_set_multichannel_signed_distance_field")

    @JvmField
    public val fontIsMultichannelSignedDistanceFieldName:
        MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("font_is_multichannel_signed_distance_field")

    @JvmField
    public val fontSetMsdfPixelRangeName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("font_set_msdf_pixel_range")

    @JvmField
    public val fontGetMsdfPixelRangeName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_msdf_pixel_range")

    @JvmField
    public val fontSetMsdfSizeName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("font_set_msdf_size")

    @JvmField
    public val fontGetMsdfSizeName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_msdf_size")

    @JvmField
    public val fontSetFixedSizeName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("font_set_fixed_size")

    @JvmField
    public val fontGetFixedSizeName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_fixed_size")

    @JvmField
    public val fontSetFixedSizeScaleModeName:
        MethodStringName2<TextServer, Unit, RID, FixedSizeScaleMode> =
        MethodStringName2<TextServer, Unit, RID, FixedSizeScaleMode>("font_set_fixed_size_scale_mode")

    @JvmField
    public val fontGetFixedSizeScaleModeName: MethodStringName1<TextServer, FixedSizeScaleMode, RID>
        = MethodStringName1<TextServer, FixedSizeScaleMode, RID>("font_get_fixed_size_scale_mode")

    @JvmField
    public val fontSetAllowSystemFallbackName: MethodStringName2<TextServer, Unit, RID, Boolean> =
        MethodStringName2<TextServer, Unit, RID, Boolean>("font_set_allow_system_fallback")

    @JvmField
    public val fontIsAllowSystemFallbackName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("font_is_allow_system_fallback")

    @JvmField
    public val fontClearSystemFallbackCacheName: MethodStringName0<TextServer, Unit> =
        MethodStringName0<TextServer, Unit>("font_clear_system_fallback_cache")

    @JvmField
    public val fontSetForceAutohinterName: MethodStringName2<TextServer, Unit, RID, Boolean> =
        MethodStringName2<TextServer, Unit, RID, Boolean>("font_set_force_autohinter")

    @JvmField
    public val fontIsForceAutohinterName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("font_is_force_autohinter")

    @JvmField
    public val fontSetModulateColorGlyphsName: MethodStringName2<TextServer, Unit, RID, Boolean> =
        MethodStringName2<TextServer, Unit, RID, Boolean>("font_set_modulate_color_glyphs")

    @JvmField
    public val fontIsModulateColorGlyphsName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("font_is_modulate_color_glyphs")

    @JvmField
    public val fontGetPaletteCountName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_palette_count")

    @JvmField
    public val fontGetPaletteNameName: MethodStringName2<TextServer, String, RID, Long> =
        MethodStringName2<TextServer, String, RID, Long>("font_get_palette_name")

    @JvmField
    public val fontGetPaletteColorsName: MethodStringName2<TextServer, PackedColorArray, RID, Long>
        = MethodStringName2<TextServer, PackedColorArray, RID, Long>("font_get_palette_colors")

    @JvmField
    public val fontSetPaletteCustomColorsName:
        MethodStringName2<TextServer, Unit, RID, PackedColorArray> =
        MethodStringName2<TextServer, Unit, RID, PackedColorArray>("font_set_palette_custom_colors")

    @JvmField
    public val fontGetPaletteCustomColorsName: MethodStringName1<TextServer, PackedColorArray, RID>
        = MethodStringName1<TextServer, PackedColorArray, RID>("font_get_palette_custom_colors")

    @JvmField
    public val fontGetUsedPaletteName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("font_get_used_palette")

    @JvmField
    public val fontSetUsedPaletteName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("font_set_used_palette")

    @JvmField
    public val fontSetHintingName: MethodStringName2<TextServer, Unit, RID, Hinting> =
        MethodStringName2<TextServer, Unit, RID, Hinting>("font_set_hinting")

    @JvmField
    public val fontGetHintingName: MethodStringName1<TextServer, Hinting, RID> =
        MethodStringName1<TextServer, Hinting, RID>("font_get_hinting")

    @JvmField
    public val fontSetSubpixelPositioningName:
        MethodStringName2<TextServer, Unit, RID, SubpixelPositioning> =
        MethodStringName2<TextServer, Unit, RID, SubpixelPositioning>("font_set_subpixel_positioning")

    @JvmField
    public val fontGetSubpixelPositioningName:
        MethodStringName1<TextServer, SubpixelPositioning, RID> =
        MethodStringName1<TextServer, SubpixelPositioning, RID>("font_get_subpixel_positioning")

    @JvmField
    public val fontSetKeepRoundingRemaindersName: MethodStringName2<TextServer, Unit, RID, Boolean>
        = MethodStringName2<TextServer, Unit, RID, Boolean>("font_set_keep_rounding_remainders")

    @JvmField
    public val fontGetKeepRoundingRemaindersName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("font_get_keep_rounding_remainders")

    @JvmField
    public val fontSetEmboldenName: MethodStringName2<TextServer, Unit, RID, Double> =
        MethodStringName2<TextServer, Unit, RID, Double>("font_set_embolden")

    @JvmField
    public val fontGetEmboldenName: MethodStringName1<TextServer, Double, RID> =
        MethodStringName1<TextServer, Double, RID>("font_get_embolden")

    @JvmField
    public val fontSetSpacingName: MethodStringName3<TextServer, Unit, RID, SpacingType, Long> =
        MethodStringName3<TextServer, Unit, RID, SpacingType, Long>("font_set_spacing")

    @JvmField
    public val fontGetSpacingName: MethodStringName2<TextServer, Long, RID, SpacingType> =
        MethodStringName2<TextServer, Long, RID, SpacingType>("font_get_spacing")

    @JvmField
    public val fontSetBaselineOffsetName: MethodStringName2<TextServer, Unit, RID, Double> =
        MethodStringName2<TextServer, Unit, RID, Double>("font_set_baseline_offset")

    @JvmField
    public val fontGetBaselineOffsetName: MethodStringName1<TextServer, Double, RID> =
        MethodStringName1<TextServer, Double, RID>("font_get_baseline_offset")

    @JvmField
    public val fontSetTransformName: MethodStringName2<TextServer, Unit, RID, Transform2D> =
        MethodStringName2<TextServer, Unit, RID, Transform2D>("font_set_transform")

    @JvmField
    public val fontGetTransformName: MethodStringName1<TextServer, Transform2D, RID> =
        MethodStringName1<TextServer, Transform2D, RID>("font_get_transform")

    @JvmField
    public val fontSetVariationCoordinatesName:
        MethodStringName2<TextServer, Unit, RID, Dictionary<Any?, Any?>> =
        MethodStringName2<TextServer, Unit, RID, Dictionary<Any?, Any?>>("font_set_variation_coordinates")

    @JvmField
    public val fontGetVariationCoordinatesName:
        MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID> =
        MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID>("font_get_variation_coordinates")

    @JvmField
    public val fontSetOversamplingName: MethodStringName2<TextServer, Unit, RID, Double> =
        MethodStringName2<TextServer, Unit, RID, Double>("font_set_oversampling")

    @JvmField
    public val fontGetOversamplingName: MethodStringName1<TextServer, Double, RID> =
        MethodStringName1<TextServer, Double, RID>("font_get_oversampling")

    @JvmField
    public val fontGetSizeCacheListName: MethodStringName1<TextServer, VariantArray<Vector2i>, RID>
        = MethodStringName1<TextServer, VariantArray<Vector2i>, RID>("font_get_size_cache_list")

    @JvmField
    public val fontClearSizeCacheName: MethodStringName1<TextServer, Unit, RID> =
        MethodStringName1<TextServer, Unit, RID>("font_clear_size_cache")

    @JvmField
    public val fontRemoveSizeCacheName: MethodStringName2<TextServer, Unit, RID, Vector2i> =
        MethodStringName2<TextServer, Unit, RID, Vector2i>("font_remove_size_cache")

    @JvmField
    public val fontGetSizeCacheInfoName:
        MethodStringName1<TextServer, VariantArray<Dictionary<Any?, Any?>>, RID> =
        MethodStringName1<TextServer, VariantArray<Dictionary<Any?, Any?>>, RID>("font_get_size_cache_info")

    @JvmField
    public val fontSetAscentName: MethodStringName3<TextServer, Unit, RID, Long, Double> =
        MethodStringName3<TextServer, Unit, RID, Long, Double>("font_set_ascent")

    @JvmField
    public val fontGetAscentName: MethodStringName2<TextServer, Double, RID, Long> =
        MethodStringName2<TextServer, Double, RID, Long>("font_get_ascent")

    @JvmField
    public val fontSetDescentName: MethodStringName3<TextServer, Unit, RID, Long, Double> =
        MethodStringName3<TextServer, Unit, RID, Long, Double>("font_set_descent")

    @JvmField
    public val fontGetDescentName: MethodStringName2<TextServer, Double, RID, Long> =
        MethodStringName2<TextServer, Double, RID, Long>("font_get_descent")

    @JvmField
    public val fontSetUnderlinePositionName: MethodStringName3<TextServer, Unit, RID, Long, Double>
        = MethodStringName3<TextServer, Unit, RID, Long, Double>("font_set_underline_position")

    @JvmField
    public val fontGetUnderlinePositionName: MethodStringName2<TextServer, Double, RID, Long> =
        MethodStringName2<TextServer, Double, RID, Long>("font_get_underline_position")

    @JvmField
    public val fontSetUnderlineThicknessName: MethodStringName3<TextServer, Unit, RID, Long, Double>
        = MethodStringName3<TextServer, Unit, RID, Long, Double>("font_set_underline_thickness")

    @JvmField
    public val fontGetUnderlineThicknessName: MethodStringName2<TextServer, Double, RID, Long> =
        MethodStringName2<TextServer, Double, RID, Long>("font_get_underline_thickness")

    @JvmField
    public val fontSetScaleName: MethodStringName3<TextServer, Unit, RID, Long, Double> =
        MethodStringName3<TextServer, Unit, RID, Long, Double>("font_set_scale")

    @JvmField
    public val fontGetScaleName: MethodStringName2<TextServer, Double, RID, Long> =
        MethodStringName2<TextServer, Double, RID, Long>("font_get_scale")

    @JvmField
    public val fontGetTextureCountName: MethodStringName2<TextServer, Long, RID, Vector2i> =
        MethodStringName2<TextServer, Long, RID, Vector2i>("font_get_texture_count")

    @JvmField
    public val fontClearTexturesName: MethodStringName2<TextServer, Unit, RID, Vector2i> =
        MethodStringName2<TextServer, Unit, RID, Vector2i>("font_clear_textures")

    @JvmField
    public val fontRemoveTextureName: MethodStringName3<TextServer, Unit, RID, Vector2i, Long> =
        MethodStringName3<TextServer, Unit, RID, Vector2i, Long>("font_remove_texture")

    @JvmField
    public val fontSetTextureImageName:
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Image?> =
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Image?>("font_set_texture_image")

    @JvmField
    public val fontGetTextureImageName: MethodStringName3<TextServer, Image?, RID, Vector2i, Long> =
        MethodStringName3<TextServer, Image?, RID, Vector2i, Long>("font_get_texture_image")

    @JvmField
    public val fontSetTextureOffsetsName:
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, PackedInt32Array> =
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, PackedInt32Array>("font_set_texture_offsets")

    @JvmField
    public val fontGetTextureOffsetsName:
        MethodStringName3<TextServer, PackedInt32Array, RID, Vector2i, Long> =
        MethodStringName3<TextServer, PackedInt32Array, RID, Vector2i, Long>("font_get_texture_offsets")

    @JvmField
    public val fontGetGlyphListName: MethodStringName2<TextServer, PackedInt32Array, RID, Vector2i>
        = MethodStringName2<TextServer, PackedInt32Array, RID, Vector2i>("font_get_glyph_list")

    @JvmField
    public val fontClearGlyphsName: MethodStringName2<TextServer, Unit, RID, Vector2i> =
        MethodStringName2<TextServer, Unit, RID, Vector2i>("font_clear_glyphs")

    @JvmField
    public val fontRemoveGlyphName: MethodStringName3<TextServer, Unit, RID, Vector2i, Long> =
        MethodStringName3<TextServer, Unit, RID, Vector2i, Long>("font_remove_glyph")

    @JvmField
    public val fontGetGlyphAdvanceName: MethodStringName3<TextServer, Vector2, RID, Long, Long> =
        MethodStringName3<TextServer, Vector2, RID, Long, Long>("font_get_glyph_advance")

    @JvmField
    public val fontSetGlyphAdvanceName:
        MethodStringName4<TextServer, Unit, RID, Long, Long, Vector2> =
        MethodStringName4<TextServer, Unit, RID, Long, Long, Vector2>("font_set_glyph_advance")

    @JvmField
    public val fontGetGlyphOffsetName: MethodStringName3<TextServer, Vector2, RID, Vector2i, Long> =
        MethodStringName3<TextServer, Vector2, RID, Vector2i, Long>("font_get_glyph_offset")

    @JvmField
    public val fontSetGlyphOffsetName:
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Vector2> =
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Vector2>("font_set_glyph_offset")

    @JvmField
    public val fontGetGlyphSizeName: MethodStringName3<TextServer, Vector2, RID, Vector2i, Long> =
        MethodStringName3<TextServer, Vector2, RID, Vector2i, Long>("font_get_glyph_size")

    @JvmField
    public val fontSetGlyphSizeName:
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Vector2> =
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Vector2>("font_set_glyph_size")

    @JvmField
    public val fontGetGlyphUvRectName: MethodStringName3<TextServer, Rect2, RID, Vector2i, Long> =
        MethodStringName3<TextServer, Rect2, RID, Vector2i, Long>("font_get_glyph_uv_rect")

    @JvmField
    public val fontSetGlyphUvRectName:
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Rect2> =
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Rect2>("font_set_glyph_uv_rect")

    @JvmField
    public val fontGetGlyphTextureIdxName: MethodStringName3<TextServer, Long, RID, Vector2i, Long>
        = MethodStringName3<TextServer, Long, RID, Vector2i, Long>("font_get_glyph_texture_idx")

    @JvmField
    public val fontSetGlyphTextureIdxName:
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Long> =
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Long>("font_set_glyph_texture_idx")

    @JvmField
    public val fontGetGlyphTextureRidName: MethodStringName3<TextServer, RID, RID, Vector2i, Long> =
        MethodStringName3<TextServer, RID, RID, Vector2i, Long>("font_get_glyph_texture_rid")

    @JvmField
    public val fontGetGlyphTextureSizeName:
        MethodStringName3<TextServer, Vector2, RID, Vector2i, Long> =
        MethodStringName3<TextServer, Vector2, RID, Vector2i, Long>("font_get_glyph_texture_size")

    @JvmField
    public val fontGetGlyphContoursName:
        MethodStringName3<TextServer, Dictionary<Any?, Any?>, RID, Long, Long> =
        MethodStringName3<TextServer, Dictionary<Any?, Any?>, RID, Long, Long>("font_get_glyph_contours")

    @JvmField
    public val fontGetKerningListName:
        MethodStringName2<TextServer, VariantArray<Vector2i>, RID, Long> =
        MethodStringName2<TextServer, VariantArray<Vector2i>, RID, Long>("font_get_kerning_list")

    @JvmField
    public val fontClearKerningMapName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("font_clear_kerning_map")

    @JvmField
    public val fontRemoveKerningName: MethodStringName3<TextServer, Unit, RID, Long, Vector2i> =
        MethodStringName3<TextServer, Unit, RID, Long, Vector2i>("font_remove_kerning")

    @JvmField
    public val fontSetKerningName: MethodStringName4<TextServer, Unit, RID, Long, Vector2i, Vector2>
        = MethodStringName4<TextServer, Unit, RID, Long, Vector2i, Vector2>("font_set_kerning")

    @JvmField
    public val fontGetKerningName: MethodStringName3<TextServer, Vector2, RID, Long, Vector2i> =
        MethodStringName3<TextServer, Vector2, RID, Long, Vector2i>("font_get_kerning")

    @JvmField
    public val fontGetGlyphIndexName: MethodStringName4<TextServer, Long, RID, Long, Long, Long> =
        MethodStringName4<TextServer, Long, RID, Long, Long, Long>("font_get_glyph_index")

    @JvmField
    public val fontGetCharFromGlyphIndexName: MethodStringName3<TextServer, Long, RID, Long, Long> =
        MethodStringName3<TextServer, Long, RID, Long, Long>("font_get_char_from_glyph_index")

    @JvmField
    public val fontHasCharName: MethodStringName2<TextServer, Boolean, RID, Long> =
        MethodStringName2<TextServer, Boolean, RID, Long>("font_has_char")

    @JvmField
    public val fontGetSupportedCharsName: MethodStringName1<TextServer, String, RID> =
        MethodStringName1<TextServer, String, RID>("font_get_supported_chars")

    @JvmField
    public val fontGetSupportedGlyphsName: MethodStringName1<TextServer, PackedInt32Array, RID> =
        MethodStringName1<TextServer, PackedInt32Array, RID>("font_get_supported_glyphs")

    @JvmField
    public val fontRenderRangeName: MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Long> =
        MethodStringName4<TextServer, Unit, RID, Vector2i, Long, Long>("font_render_range")

    @JvmField
    public val fontRenderGlyphName: MethodStringName3<TextServer, Unit, RID, Vector2i, Long> =
        MethodStringName3<TextServer, Unit, RID, Vector2i, Long>("font_render_glyph")

    @JvmField
    public val fontDrawGlyphName:
        MethodStringName7<TextServer, Unit, RID, RID, Long, Vector2, Long, Color, Float> =
        MethodStringName7<TextServer, Unit, RID, RID, Long, Vector2, Long, Color, Float>("font_draw_glyph")

    @JvmField
    public val fontDrawGlyphOutlineName:
        MethodStringName8<TextServer, Unit, RID, RID, Long, Long, Vector2, Long, Color, Float> =
        MethodStringName8<TextServer, Unit, RID, RID, Long, Long, Vector2, Long, Color, Float>("font_draw_glyph_outline")

    @JvmField
    public val fontIsLanguageSupportedName: MethodStringName2<TextServer, Boolean, RID, String> =
        MethodStringName2<TextServer, Boolean, RID, String>("font_is_language_supported")

    @JvmField
    public val fontSetLanguageSupportOverrideName:
        MethodStringName3<TextServer, Unit, RID, String, Boolean> =
        MethodStringName3<TextServer, Unit, RID, String, Boolean>("font_set_language_support_override")

    @JvmField
    public val fontGetLanguageSupportOverrideName:
        MethodStringName2<TextServer, Boolean, RID, String> =
        MethodStringName2<TextServer, Boolean, RID, String>("font_get_language_support_override")

    @JvmField
    public val fontRemoveLanguageSupportOverrideName:
        MethodStringName2<TextServer, Unit, RID, String> =
        MethodStringName2<TextServer, Unit, RID, String>("font_remove_language_support_override")

    @JvmField
    public val fontGetLanguageSupportOverridesName:
        MethodStringName1<TextServer, PackedStringArray, RID> =
        MethodStringName1<TextServer, PackedStringArray, RID>("font_get_language_support_overrides")

    @JvmField
    public val fontIsScriptSupportedName: MethodStringName2<TextServer, Boolean, RID, String> =
        MethodStringName2<TextServer, Boolean, RID, String>("font_is_script_supported")

    @JvmField
    public val fontSetScriptSupportOverrideName:
        MethodStringName3<TextServer, Unit, RID, String, Boolean> =
        MethodStringName3<TextServer, Unit, RID, String, Boolean>("font_set_script_support_override")

    @JvmField
    public val fontGetScriptSupportOverrideName: MethodStringName2<TextServer, Boolean, RID, String>
        = MethodStringName2<TextServer, Boolean, RID, String>("font_get_script_support_override")

    @JvmField
    public val fontRemoveScriptSupportOverrideName: MethodStringName2<TextServer, Unit, RID, String>
        = MethodStringName2<TextServer, Unit, RID, String>("font_remove_script_support_override")

    @JvmField
    public val fontGetScriptSupportOverridesName:
        MethodStringName1<TextServer, PackedStringArray, RID> =
        MethodStringName1<TextServer, PackedStringArray, RID>("font_get_script_support_overrides")

    @JvmField
    public val fontSetOpentypeFeatureOverridesName:
        MethodStringName2<TextServer, Unit, RID, Dictionary<Any?, Any?>> =
        MethodStringName2<TextServer, Unit, RID, Dictionary<Any?, Any?>>("font_set_opentype_feature_overrides")

    @JvmField
    public val fontGetOpentypeFeatureOverridesName:
        MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID> =
        MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID>("font_get_opentype_feature_overrides")

    @JvmField
    public val fontSupportedFeatureListName:
        MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID> =
        MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID>("font_supported_feature_list")

    @JvmField
    public val fontSupportedVariationListName:
        MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID> =
        MethodStringName1<TextServer, Dictionary<Any?, Any?>, RID>("font_supported_variation_list")

    @JvmField
    public val fontGetGlobalOversamplingName: MethodStringName0<TextServer, Double> =
        MethodStringName0<TextServer, Double>("font_get_global_oversampling")

    @JvmField
    public val fontSetGlobalOversamplingName: MethodStringName1<TextServer, Unit, Double> =
        MethodStringName1<TextServer, Unit, Double>("font_set_global_oversampling")

    @JvmField
    public val getHexCodeBoxSizeName: MethodStringName2<TextServer, Vector2, Long, Long> =
        MethodStringName2<TextServer, Vector2, Long, Long>("get_hex_code_box_size")

    @JvmField
    public val drawHexCodeBoxName:
        MethodStringName5<TextServer, Unit, RID, Long, Vector2, Long, Color> =
        MethodStringName5<TextServer, Unit, RID, Long, Vector2, Long, Color>("draw_hex_code_box")

    @JvmField
    public val createShapedTextName: MethodStringName2<TextServer, RID, Direction, Orientation> =
        MethodStringName2<TextServer, RID, Direction, Orientation>("create_shaped_text")

    @JvmField
    public val shapedTextClearName: MethodStringName1<TextServer, Unit, RID> =
        MethodStringName1<TextServer, Unit, RID>("shaped_text_clear")

    @JvmField
    public val shapedTextDuplicateName: MethodStringName1<TextServer, RID, RID> =
        MethodStringName1<TextServer, RID, RID>("shaped_text_duplicate")

    @JvmField
    public val shapedTextSetDirectionName: MethodStringName2<TextServer, Unit, RID, Direction> =
        MethodStringName2<TextServer, Unit, RID, Direction>("shaped_text_set_direction")

    @JvmField
    public val shapedTextGetDirectionName: MethodStringName1<TextServer, Direction, RID> =
        MethodStringName1<TextServer, Direction, RID>("shaped_text_get_direction")

    @JvmField
    public val shapedTextGetInferredDirectionName: MethodStringName1<TextServer, Direction, RID> =
        MethodStringName1<TextServer, Direction, RID>("shaped_text_get_inferred_direction")

    @JvmField
    public val shapedTextSetBidiOverrideName:
        MethodStringName2<TextServer, Unit, RID, VariantArray<Any?>> =
        MethodStringName2<TextServer, Unit, RID, VariantArray<Any?>>("shaped_text_set_bidi_override")

    @JvmField
    public val shapedTextSetCustomPunctuationName: MethodStringName2<TextServer, Unit, RID, String>
        = MethodStringName2<TextServer, Unit, RID, String>("shaped_text_set_custom_punctuation")

    @JvmField
    public val shapedTextGetCustomPunctuationName: MethodStringName1<TextServer, String, RID> =
        MethodStringName1<TextServer, String, RID>("shaped_text_get_custom_punctuation")

    @JvmField
    public val shapedTextSetCustomEllipsisName: MethodStringName2<TextServer, Unit, RID, Long> =
        MethodStringName2<TextServer, Unit, RID, Long>("shaped_text_set_custom_ellipsis")

    @JvmField
    public val shapedTextGetCustomEllipsisName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("shaped_text_get_custom_ellipsis")

    @JvmField
    public val shapedTextSetOrientationName: MethodStringName2<TextServer, Unit, RID, Orientation> =
        MethodStringName2<TextServer, Unit, RID, Orientation>("shaped_text_set_orientation")

    @JvmField
    public val shapedTextGetOrientationName: MethodStringName1<TextServer, Orientation, RID> =
        MethodStringName1<TextServer, Orientation, RID>("shaped_text_get_orientation")

    @JvmField
    public val shapedTextSetPreserveInvalidName: MethodStringName2<TextServer, Unit, RID, Boolean> =
        MethodStringName2<TextServer, Unit, RID, Boolean>("shaped_text_set_preserve_invalid")

    @JvmField
    public val shapedTextGetPreserveInvalidName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("shaped_text_get_preserve_invalid")

    @JvmField
    public val shapedTextSetPreserveControlName: MethodStringName2<TextServer, Unit, RID, Boolean> =
        MethodStringName2<TextServer, Unit, RID, Boolean>("shaped_text_set_preserve_control")

    @JvmField
    public val shapedTextGetPreserveControlName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("shaped_text_get_preserve_control")

    @JvmField
    public val shapedTextSetSpacingName: MethodStringName3<TextServer, Unit, RID, SpacingType, Long>
        = MethodStringName3<TextServer, Unit, RID, SpacingType, Long>("shaped_text_set_spacing")

    @JvmField
    public val shapedTextGetSpacingName: MethodStringName2<TextServer, Long, RID, SpacingType> =
        MethodStringName2<TextServer, Long, RID, SpacingType>("shaped_text_get_spacing")

    @JvmField
    public val shapedTextAddStringName:
        MethodStringName7<TextServer, Boolean, RID, String, VariantArray<RID>, Long, Dictionary<Any?, Any?>, String, Any?>
        =
        MethodStringName7<TextServer, Boolean, RID, String, VariantArray<RID>, Long, Dictionary<Any?, Any?>, String, Any?>("shaped_text_add_string")

    @JvmField
    public val shapedTextAddObjectName:
        MethodStringName6<TextServer, Boolean, RID, Any?, Vector2, InlineAlignment, Long, Double> =
        MethodStringName6<TextServer, Boolean, RID, Any?, Vector2, InlineAlignment, Long, Double>("shaped_text_add_object")

    @JvmField
    public val shapedTextResizeObjectName:
        MethodStringName5<TextServer, Boolean, RID, Any?, Vector2, InlineAlignment, Double> =
        MethodStringName5<TextServer, Boolean, RID, Any?, Vector2, InlineAlignment, Double>("shaped_text_resize_object")

    @JvmField
    public val shapedTextHasObjectName: MethodStringName2<TextServer, Boolean, RID, Any?> =
        MethodStringName2<TextServer, Boolean, RID, Any?>("shaped_text_has_object")

    @JvmField
    public val shapedGetTextName: MethodStringName1<TextServer, String, RID> =
        MethodStringName1<TextServer, String, RID>("shaped_get_text")

    @JvmField
    public val shapedGetSpanCountName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("shaped_get_span_count")

    @JvmField
    public val shapedGetSpanMetaName: MethodStringName2<TextServer, Any?, RID, Long> =
        MethodStringName2<TextServer, Any?, RID, Long>("shaped_get_span_meta")

    @JvmField
    public val shapedGetSpanEmbeddedObjectName: MethodStringName2<TextServer, Any?, RID, Long> =
        MethodStringName2<TextServer, Any?, RID, Long>("shaped_get_span_embedded_object")

    @JvmField
    public val shapedGetSpanTextName: MethodStringName2<TextServer, String, RID, Long> =
        MethodStringName2<TextServer, String, RID, Long>("shaped_get_span_text")

    @JvmField
    public val shapedGetSpanObjectName: MethodStringName2<TextServer, Any?, RID, Long> =
        MethodStringName2<TextServer, Any?, RID, Long>("shaped_get_span_object")

    @JvmField
    public val shapedSetSpanUpdateFontName:
        MethodStringName5<TextServer, Unit, RID, Long, VariantArray<RID>, Long, Dictionary<Any?, Any?>>
        =
        MethodStringName5<TextServer, Unit, RID, Long, VariantArray<RID>, Long, Dictionary<Any?, Any?>>("shaped_set_span_update_font")

    @JvmField
    public val shapedGetRunCountName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("shaped_get_run_count")

    @JvmField
    public val shapedGetRunTextName: MethodStringName2<TextServer, String, RID, Long> =
        MethodStringName2<TextServer, String, RID, Long>("shaped_get_run_text")

    @JvmField
    public val shapedGetRunRangeName: MethodStringName2<TextServer, Vector2i, RID, Long> =
        MethodStringName2<TextServer, Vector2i, RID, Long>("shaped_get_run_range")

    @JvmField
    public val shapedGetRunGlyphRangeName: MethodStringName2<TextServer, Vector2i, RID, Long> =
        MethodStringName2<TextServer, Vector2i, RID, Long>("shaped_get_run_glyph_range")

    @JvmField
    public val shapedGetRunFontRidName: MethodStringName2<TextServer, RID, RID, Long> =
        MethodStringName2<TextServer, RID, RID, Long>("shaped_get_run_font_rid")

    @JvmField
    public val shapedGetRunFontSizeName: MethodStringName2<TextServer, Int, RID, Long> =
        MethodStringName2<TextServer, Int, RID, Long>("shaped_get_run_font_size")

    @JvmField
    public val shapedGetRunLanguageName: MethodStringName2<TextServer, String, RID, Long> =
        MethodStringName2<TextServer, String, RID, Long>("shaped_get_run_language")

    @JvmField
    public val shapedGetRunDirectionName: MethodStringName2<TextServer, Direction, RID, Long> =
        MethodStringName2<TextServer, Direction, RID, Long>("shaped_get_run_direction")

    @JvmField
    public val shapedGetRunObjectName: MethodStringName2<TextServer, Any?, RID, Long> =
        MethodStringName2<TextServer, Any?, RID, Long>("shaped_get_run_object")

    @JvmField
    public val shapedTextSubstrName: MethodStringName3<TextServer, RID, RID, Long, Long> =
        MethodStringName3<TextServer, RID, RID, Long, Long>("shaped_text_substr")

    @JvmField
    public val shapedTextGetParentName: MethodStringName1<TextServer, RID, RID> =
        MethodStringName1<TextServer, RID, RID>("shaped_text_get_parent")

    @JvmField
    public val shapedTextFitToWidthName:
        MethodStringName3<TextServer, Double, RID, Double, JustificationFlag> =
        MethodStringName3<TextServer, Double, RID, Double, JustificationFlag>("shaped_text_fit_to_width")

    @JvmField
    public val shapedTextTabAlignName:
        MethodStringName2<TextServer, Double, RID, PackedFloat32Array> =
        MethodStringName2<TextServer, Double, RID, PackedFloat32Array>("shaped_text_tab_align")

    @JvmField
    public val shapedTextShapeName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("shaped_text_shape")

    @JvmField
    public val shapedTextIsReadyName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("shaped_text_is_ready")

    @JvmField
    public val shapedTextHasVisibleCharsName: MethodStringName1<TextServer, Boolean, RID> =
        MethodStringName1<TextServer, Boolean, RID>("shaped_text_has_visible_chars")

    @JvmField
    public val shapedTextGetGlyphsName:
        MethodStringName1<TextServer, VariantArray<Dictionary<Any?, Any?>>, RID> =
        MethodStringName1<TextServer, VariantArray<Dictionary<Any?, Any?>>, RID>("shaped_text_get_glyphs")

    @JvmField
    public val shapedTextSortLogicalName:
        MethodStringName1<TextServer, VariantArray<Dictionary<Any?, Any?>>, RID> =
        MethodStringName1<TextServer, VariantArray<Dictionary<Any?, Any?>>, RID>("shaped_text_sort_logical")

    @JvmField
    public val shapedTextGetGlyphCountName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("shaped_text_get_glyph_count")

    @JvmField
    public val shapedTextGetRangeName: MethodStringName1<TextServer, Vector2i, RID> =
        MethodStringName1<TextServer, Vector2i, RID>("shaped_text_get_range")

    @JvmField
    public val shapedTextGetLineBreaksAdvName:
        MethodStringName5<TextServer, PackedInt32Array, RID, PackedFloat32Array, Long, Boolean, LineBreakFlag>
        =
        MethodStringName5<TextServer, PackedInt32Array, RID, PackedFloat32Array, Long, Boolean, LineBreakFlag>("shaped_text_get_line_breaks_adv")

    @JvmField
    public val shapedTextGetLineBreaksName:
        MethodStringName4<TextServer, PackedInt32Array, RID, Double, Long, LineBreakFlag> =
        MethodStringName4<TextServer, PackedInt32Array, RID, Double, Long, LineBreakFlag>("shaped_text_get_line_breaks")

    @JvmField
    public val shapedTextGetWordBreaksName:
        MethodStringName3<TextServer, PackedInt32Array, RID, GraphemeFlag, GraphemeFlag> =
        MethodStringName3<TextServer, PackedInt32Array, RID, GraphemeFlag, GraphemeFlag>("shaped_text_get_word_breaks")

    @JvmField
    public val shapedTextGetTrimPosName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("shaped_text_get_trim_pos")

    @JvmField
    public val shapedTextGetEllipsisPosName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("shaped_text_get_ellipsis_pos")

    @JvmField
    public val shapedTextGetEllipsisGlyphsName:
        MethodStringName1<TextServer, VariantArray<Dictionary<Any?, Any?>>, RID> =
        MethodStringName1<TextServer, VariantArray<Dictionary<Any?, Any?>>, RID>("shaped_text_get_ellipsis_glyphs")

    @JvmField
    public val shapedTextGetEllipsisGlyphCountName: MethodStringName1<TextServer, Long, RID> =
        MethodStringName1<TextServer, Long, RID>("shaped_text_get_ellipsis_glyph_count")

    @JvmField
    public val shapedTextOverrunTrimToWidthName:
        MethodStringName3<TextServer, Unit, RID, Double, TextOverrunFlag> =
        MethodStringName3<TextServer, Unit, RID, Double, TextOverrunFlag>("shaped_text_overrun_trim_to_width")

    @JvmField
    public val shapedTextGetObjectsName: MethodStringName1<TextServer, VariantArray<Any?>, RID> =
        MethodStringName1<TextServer, VariantArray<Any?>, RID>("shaped_text_get_objects")

    @JvmField
    public val shapedTextGetObjectRectName: MethodStringName2<TextServer, Rect2, RID, Any?> =
        MethodStringName2<TextServer, Rect2, RID, Any?>("shaped_text_get_object_rect")

    @JvmField
    public val shapedTextGetObjectRangeName: MethodStringName2<TextServer, Vector2i, RID, Any?> =
        MethodStringName2<TextServer, Vector2i, RID, Any?>("shaped_text_get_object_range")

    @JvmField
    public val shapedTextGetObjectGlyphName: MethodStringName2<TextServer, Long, RID, Any?> =
        MethodStringName2<TextServer, Long, RID, Any?>("shaped_text_get_object_glyph")

    @JvmField
    public val shapedTextGetSizeName: MethodStringName1<TextServer, Vector2, RID> =
        MethodStringName1<TextServer, Vector2, RID>("shaped_text_get_size")

    @JvmField
    public val shapedTextGetAscentName: MethodStringName1<TextServer, Double, RID> =
        MethodStringName1<TextServer, Double, RID>("shaped_text_get_ascent")

    @JvmField
    public val shapedTextGetDescentName: MethodStringName1<TextServer, Double, RID> =
        MethodStringName1<TextServer, Double, RID>("shaped_text_get_descent")

    @JvmField
    public val shapedTextGetWidthName: MethodStringName1<TextServer, Double, RID> =
        MethodStringName1<TextServer, Double, RID>("shaped_text_get_width")

    @JvmField
    public val shapedTextGetUnderlinePositionName: MethodStringName1<TextServer, Double, RID> =
        MethodStringName1<TextServer, Double, RID>("shaped_text_get_underline_position")

    @JvmField
    public val shapedTextGetUnderlineThicknessName: MethodStringName1<TextServer, Double, RID> =
        MethodStringName1<TextServer, Double, RID>("shaped_text_get_underline_thickness")

    @JvmField
    public val shapedTextGetCaretsName:
        MethodStringName2<TextServer, Dictionary<Any?, Any?>, RID, Long> =
        MethodStringName2<TextServer, Dictionary<Any?, Any?>, RID, Long>("shaped_text_get_carets")

    @JvmField
    public val shapedTextGetSelectionName:
        MethodStringName3<TextServer, PackedVector2Array, RID, Long, Long> =
        MethodStringName3<TextServer, PackedVector2Array, RID, Long, Long>("shaped_text_get_selection")

    @JvmField
    public val shapedTextHitTestGraphemeName: MethodStringName2<TextServer, Long, RID, Double> =
        MethodStringName2<TextServer, Long, RID, Double>("shaped_text_hit_test_grapheme")

    @JvmField
    public val shapedTextHitTestPositionName: MethodStringName2<TextServer, Long, RID, Double> =
        MethodStringName2<TextServer, Long, RID, Double>("shaped_text_hit_test_position")

    @JvmField
    public val shapedTextGetGraphemeBoundsName: MethodStringName2<TextServer, Vector2, RID, Long> =
        MethodStringName2<TextServer, Vector2, RID, Long>("shaped_text_get_grapheme_bounds")

    @JvmField
    public val shapedTextNextGraphemePosName: MethodStringName2<TextServer, Long, RID, Long> =
        MethodStringName2<TextServer, Long, RID, Long>("shaped_text_next_grapheme_pos")

    @JvmField
    public val shapedTextPrevGraphemePosName: MethodStringName2<TextServer, Long, RID, Long> =
        MethodStringName2<TextServer, Long, RID, Long>("shaped_text_prev_grapheme_pos")

    @JvmField
    public val shapedTextGetCharacterBreaksName:
        MethodStringName1<TextServer, PackedInt32Array, RID> =
        MethodStringName1<TextServer, PackedInt32Array, RID>("shaped_text_get_character_breaks")

    @JvmField
    public val shapedTextNextCharacterPosName: MethodStringName2<TextServer, Long, RID, Long> =
        MethodStringName2<TextServer, Long, RID, Long>("shaped_text_next_character_pos")

    @JvmField
    public val shapedTextPrevCharacterPosName: MethodStringName2<TextServer, Long, RID, Long> =
        MethodStringName2<TextServer, Long, RID, Long>("shaped_text_prev_character_pos")

    @JvmField
    public val shapedTextClosestCharacterPosName: MethodStringName2<TextServer, Long, RID, Long> =
        MethodStringName2<TextServer, Long, RID, Long>("shaped_text_closest_character_pos")

    @JvmField
    public val shapedTextDrawName:
        MethodStringName7<TextServer, Unit, RID, RID, Vector2, Double, Double, Color, Float> =
        MethodStringName7<TextServer, Unit, RID, RID, Vector2, Double, Double, Color, Float>("shaped_text_draw")

    @JvmField
    public val shapedTextDrawOutlineName:
        MethodStringName8<TextServer, Unit, RID, RID, Vector2, Double, Double, Long, Color, Float> =
        MethodStringName8<TextServer, Unit, RID, RID, Vector2, Double, Double, Long, Color, Float>("shaped_text_draw_outline")

    @JvmField
    public val shapedTextGetDominantDirectionInRangeName:
        MethodStringName3<TextServer, Direction, RID, Long, Long> =
        MethodStringName3<TextServer, Direction, RID, Long, Long>("shaped_text_get_dominant_direction_in_range")

    @JvmField
    public val formatNumberName: MethodStringName2<TextServer, String, String, String> =
        MethodStringName2<TextServer, String, String, String>("format_number")

    @JvmField
    public val parseNumberName: MethodStringName2<TextServer, String, String, String> =
        MethodStringName2<TextServer, String, String, String>("parse_number")

    @JvmField
    public val percentSignName: MethodStringName1<TextServer, String, String> =
        MethodStringName1<TextServer, String, String>("percent_sign")

    @JvmField
    public val stringGetWordBreaksName:
        MethodStringName3<TextServer, PackedInt32Array, String, String, Long> =
        MethodStringName3<TextServer, PackedInt32Array, String, String, Long>("string_get_word_breaks")

    @JvmField
    public val stringGetCharacterBreaksName:
        MethodStringName2<TextServer, PackedInt32Array, String, String> =
        MethodStringName2<TextServer, PackedInt32Array, String, String>("string_get_character_breaks")

    @JvmField
    public val isConfusableName: MethodStringName2<TextServer, Long, String, PackedStringArray> =
        MethodStringName2<TextServer, Long, String, PackedStringArray>("is_confusable")

    @JvmField
    public val spoofCheckName: MethodStringName1<TextServer, Boolean, String> =
        MethodStringName1<TextServer, Boolean, String>("spoof_check")

    @JvmField
    public val stripDiacriticsName: MethodStringName1<TextServer, String, String> =
        MethodStringName1<TextServer, String, String>("strip_diacritics")

    @JvmField
    public val isValidIdentifierName: MethodStringName1<TextServer, Boolean, String> =
        MethodStringName1<TextServer, Boolean, String>("is_valid_identifier")

    @JvmField
    public val isValidLetterName: MethodStringName1<TextServer, Boolean, Long> =
        MethodStringName1<TextServer, Boolean, Long>("is_valid_letter")

    @JvmField
    public val stringToUpperName: MethodStringName2<TextServer, String, String, String> =
        MethodStringName2<TextServer, String, String, String>("string_to_upper")

    @JvmField
    public val stringToLowerName: MethodStringName2<TextServer, String, String, String> =
        MethodStringName2<TextServer, String, String, String>("string_to_lower")

    @JvmField
    public val stringToTitleName: MethodStringName2<TextServer, String, String, String> =
        MethodStringName2<TextServer, String, String, String>("string_to_title")

    @JvmField
    public val parseStructuredTextName:
        MethodStringName3<TextServer, VariantArray<Vector3i>, StructuredTextParser, VariantArray<Any?>, String>
        =
        MethodStringName3<TextServer, VariantArray<Vector3i>, StructuredTextParser, VariantArray<Any?>, String>("parse_structured_text")
  }

  public object MethodBindings {
    internal val hasFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "has_feature", 3967367083)

    internal val getNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "get_name", 201670096)

    internal val getFeaturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "get_features", 3905245786)

    internal val loadSupportDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "load_support_data", 2323990056)

    internal val getSupportDataFilenamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "get_support_data_filename", 201670096)

    internal val getSupportDataInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "get_support_data_info", 201670096)

    internal val saveSupportDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "save_support_data", 3927539163)

    internal val getSupportDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "get_support_data", 2362200018)

    internal val isLocaleUsingSupportDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "is_locale_using_support_data", 3927539163)

    internal val isLocaleRightToLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "is_locale_right_to_left", 3927539163)

    internal val nameToTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "name_to_tag", 1321353865)

    internal val tagToNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "tag_to_name", 844755477)

    internal val hasPtr: VoidPtr = TypeManager.getMethodBindPtr("TextServer", "has", 3521089500)

    internal val freeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "free_rid", 2722037293)

    internal val createFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "create_font", 529393457)

    internal val createFontLinkedVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "create_font_linked_variation", 41030802)

    internal val fontSetDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_data", 1355495400)

    internal val fontSetFaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_face_index", 3411492887)

    internal val fontGetFaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_face_index", 2198884583)

    internal val fontGetFaceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_face_count", 2198884583)

    internal val fontSetStylePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_style", 898466325)

    internal val fontGetStylePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_style", 3082502592)

    internal val fontSetNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_name", 2726140452)

    internal val fontGetNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_name", 642473191)

    internal val fontGetOtNameStringsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_ot_name_strings", 1882737106)

    internal val fontSetStyleNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_style_name", 2726140452)

    internal val fontGetStyleNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_style_name", 642473191)

    internal val fontSetWeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_weight", 3411492887)

    internal val fontGetWeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_weight", 2198884583)

    internal val fontSetStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_stretch", 3411492887)

    internal val fontGetStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_stretch", 2198884583)

    internal val fontSetAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_antialiasing", 958337235)

    internal val fontGetAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_antialiasing", 3389420495)

    internal val fontSetDisableEmbeddedBitmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_disable_embedded_bitmaps", 1265174801)

    internal val fontGetDisableEmbeddedBitmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_disable_embedded_bitmaps", 4155700596)

    internal val fontSetGenerateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_generate_mipmaps", 1265174801)

    internal val fontGetGenerateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_generate_mipmaps", 4155700596)

    internal val fontSetMultichannelSignedDistanceFieldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_multichannel_signed_distance_field", 1265174801)

    internal val fontIsMultichannelSignedDistanceFieldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_is_multichannel_signed_distance_field", 4155700596)

    internal val fontSetMsdfPixelRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_msdf_pixel_range", 3411492887)

    internal val fontGetMsdfPixelRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_msdf_pixel_range", 2198884583)

    internal val fontSetMsdfSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_msdf_size", 3411492887)

    internal val fontGetMsdfSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_msdf_size", 2198884583)

    internal val fontSetFixedSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_fixed_size", 3411492887)

    internal val fontGetFixedSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_fixed_size", 2198884583)

    internal val fontSetFixedSizeScaleModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_fixed_size_scale_mode", 1029390307)

    internal val fontGetFixedSizeScaleModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_fixed_size_scale_mode", 4113120379)

    internal val fontSetAllowSystemFallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_allow_system_fallback", 1265174801)

    internal val fontIsAllowSystemFallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_is_allow_system_fallback", 4155700596)

    internal val fontClearSystemFallbackCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_clear_system_fallback_cache", 3218959716)

    internal val fontSetForceAutohinterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_force_autohinter", 1265174801)

    internal val fontIsForceAutohinterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_is_force_autohinter", 4155700596)

    internal val fontSetModulateColorGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_modulate_color_glyphs", 1265174801)

    internal val fontIsModulateColorGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_is_modulate_color_glyphs", 4155700596)

    internal val fontGetPaletteCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_palette_count", 2198884583)

    internal val fontGetPaletteNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_palette_name", 1464764419)

    internal val fontGetPaletteColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_palette_colors", 1595517857)

    internal val fontSetPaletteCustomColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_palette_custom_colors", 4037098590)

    internal val fontGetPaletteCustomColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_palette_custom_colors", 1569415609)

    internal val fontGetUsedPalettePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_used_palette", 2198884583)

    internal val fontSetUsedPalettePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_used_palette", 3411492887)

    internal val fontSetHintingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_hinting", 1520010864)

    internal val fontGetHintingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_hinting", 3971592737)

    internal val fontSetSubpixelPositioningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_subpixel_positioning", 3830459669)

    internal val fontGetSubpixelPositioningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_subpixel_positioning", 2752233671)

    internal val fontSetKeepRoundingRemaindersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_keep_rounding_remainders", 1265174801)

    internal val fontGetKeepRoundingRemaindersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_keep_rounding_remainders", 4155700596)

    internal val fontSetEmboldenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_embolden", 1794382983)

    internal val fontGetEmboldenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_embolden", 866169185)

    internal val fontSetSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_spacing", 1307259930)

    internal val fontGetSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_spacing", 1213653558)

    internal val fontSetBaselineOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_baseline_offset", 1794382983)

    internal val fontGetBaselineOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_baseline_offset", 866169185)

    internal val fontSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_transform", 1246044741)

    internal val fontGetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_transform", 213527486)

    internal val fontSetVariationCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_variation_coordinates", 1217542888)

    internal val fontGetVariationCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_variation_coordinates", 1882737106)

    internal val fontSetOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_oversampling", 1794382983)

    internal val fontGetOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_oversampling", 866169185)

    internal val fontGetSizeCacheListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_size_cache_list", 2684255073)

    internal val fontClearSizeCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_clear_size_cache", 2722037293)

    internal val fontRemoveSizeCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_remove_size_cache", 2450610377)

    internal val fontGetSizeCacheInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_size_cache_info", 2684255073)

    internal val fontSetAscentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_ascent", 1892459533)

    internal val fontGetAscentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_ascent", 755457166)

    internal val fontSetDescentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_descent", 1892459533)

    internal val fontGetDescentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_descent", 755457166)

    internal val fontSetUnderlinePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_underline_position", 1892459533)

    internal val fontGetUnderlinePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_underline_position", 755457166)

    internal val fontSetUnderlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_underline_thickness", 1892459533)

    internal val fontGetUnderlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_underline_thickness", 755457166)

    internal val fontSetScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_scale", 1892459533)

    internal val fontGetScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_scale", 755457166)

    internal val fontGetTextureCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_texture_count", 1311001310)

    internal val fontClearTexturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_clear_textures", 2450610377)

    internal val fontRemoveTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_remove_texture", 3810512262)

    internal val fontSetTextureImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_texture_image", 2354485091)

    internal val fontGetTextureImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_texture_image", 2451761155)

    internal val fontSetTextureOffsetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_texture_offsets", 3005398047)

    internal val fontGetTextureOffsetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_texture_offsets", 3420028887)

    internal val fontGetGlyphListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_list", 46086620)

    internal val fontClearGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_clear_glyphs", 2450610377)

    internal val fontRemoveGlyphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_remove_glyph", 3810512262)

    internal val fontGetGlyphAdvancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_advance", 2555689501)

    internal val fontSetGlyphAdvancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_glyph_advance", 3219397315)

    internal val fontGetGlyphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_offset", 513728628)

    internal val fontSetGlyphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_glyph_offset", 1812632090)

    internal val fontGetGlyphSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_size", 513728628)

    internal val fontSetGlyphSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_glyph_size", 1812632090)

    internal val fontGetGlyphUvRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_uv_rect", 2274268786)

    internal val fontSetGlyphUvRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_glyph_uv_rect", 1973324081)

    internal val fontGetGlyphTextureIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_texture_idx", 4292800474)

    internal val fontSetGlyphTextureIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_glyph_texture_idx", 4254580980)

    internal val fontGetGlyphTextureRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_texture_rid", 1451696141)

    internal val fontGetGlyphTextureSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_texture_size", 513728628)

    internal val fontGetGlyphContoursPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_contours", 2903964473)

    internal val fontGetKerningListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_kerning_list", 1778388067)

    internal val fontClearKerningMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_clear_kerning_map", 3411492887)

    internal val fontRemoveKerningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_remove_kerning", 2141860016)

    internal val fontSetKerningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_kerning", 3630965883)

    internal val fontGetKerningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_kerning", 1019980169)

    internal val fontGetGlyphIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_glyph_index", 1765635060)

    internal val fontGetCharFromGlyphIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_char_from_glyph_index", 2156738276)

    internal val fontHasCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_has_char", 3120086654)

    internal val fontGetSupportedCharsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_supported_chars", 642473191)

    internal val fontGetSupportedGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_supported_glyphs", 788230395)

    internal val fontRenderRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_render_range", 4254580980)

    internal val fontRenderGlyphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_render_glyph", 3810512262)

    internal val fontDrawGlyphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_draw_glyph", 3103234926)

    internal val fontDrawGlyphOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_draw_glyph_outline", 1976041553)

    internal val fontIsLanguageSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_is_language_supported", 3199320846)

    internal val fontSetLanguageSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_language_support_override", 2313957094)

    internal val fontGetLanguageSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_language_support_override", 2829184646)

    internal val fontRemoveLanguageSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_remove_language_support_override", 2726140452)

    internal val fontGetLanguageSupportOverridesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_language_support_overrides", 2801473409)

    internal val fontIsScriptSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_is_script_supported", 3199320846)

    internal val fontSetScriptSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_script_support_override", 2313957094)

    internal val fontGetScriptSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_script_support_override", 2829184646)

    internal val fontRemoveScriptSupportOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_remove_script_support_override", 2726140452)

    internal val fontGetScriptSupportOverridesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_script_support_overrides", 2801473409)

    internal val fontSetOpentypeFeatureOverridesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_opentype_feature_overrides", 1217542888)

    internal val fontGetOpentypeFeatureOverridesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_opentype_feature_overrides", 1882737106)

    internal val fontSupportedFeatureListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_supported_feature_list", 1882737106)

    internal val fontSupportedVariationListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_supported_variation_list", 1882737106)

    internal val fontGetGlobalOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_get_global_oversampling", 1740695150)

    internal val fontSetGlobalOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "font_set_global_oversampling", 373806689)

    internal val getHexCodeBoxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "get_hex_code_box_size", 3016396712)

    internal val drawHexCodeBoxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "draw_hex_code_box", 1602046441)

    internal val createShapedTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "create_shaped_text", 1231398698)

    internal val shapedTextClearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_clear", 2722037293)

    internal val shapedTextDuplicatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_duplicate", 41030802)

    internal val shapedTextSetDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_set_direction", 1551430183)

    internal val shapedTextGetDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_direction", 3065904362)

    internal val shapedTextGetInferredDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_inferred_direction", 3065904362)

    internal val shapedTextSetBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_set_bidi_override", 684822712)

    internal val shapedTextSetCustomPunctuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_set_custom_punctuation", 2726140452)

    internal val shapedTextGetCustomPunctuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_custom_punctuation", 642473191)

    internal val shapedTextSetCustomEllipsisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_set_custom_ellipsis", 3411492887)

    internal val shapedTextGetCustomEllipsisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_custom_ellipsis", 2198884583)

    internal val shapedTextSetOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_set_orientation", 3019609126)

    internal val shapedTextGetOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_orientation", 3142708106)

    internal val shapedTextSetPreserveInvalidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_set_preserve_invalid", 1265174801)

    internal val shapedTextGetPreserveInvalidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_preserve_invalid", 4155700596)

    internal val shapedTextSetPreserveControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_set_preserve_control", 1265174801)

    internal val shapedTextGetPreserveControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_preserve_control", 4155700596)

    internal val shapedTextSetSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_set_spacing", 1307259930)

    internal val shapedTextGetSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_spacing", 1213653558)

    internal val shapedTextAddStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_add_string", 623473029)

    internal val shapedTextAddObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_add_object", 3664424789)

    internal val shapedTextResizeObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_resize_object", 790361552)

    internal val shapedTextHasObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_has_object", 2360964694)

    internal val shapedGetTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_text", 642473191)

    internal val shapedGetSpanCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_span_count", 2198884583)

    internal val shapedGetSpanMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_span_meta", 4069510997)

    internal val shapedGetSpanEmbeddedObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_span_embedded_object", 4069510997)

    internal val shapedGetSpanTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_span_text", 1464764419)

    internal val shapedGetSpanObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_span_object", 4069510997)

    internal val shapedSetSpanUpdateFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_set_span_update_font", 2022725822)

    internal val shapedGetRunCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_count", 2198884583)

    internal val shapedGetRunTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_text", 1464764419)

    internal val shapedGetRunRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_range", 4069534484)

    internal val shapedGetRunGlyphRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_glyph_range", 4069534484)

    internal val shapedGetRunFontRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_font_rid", 1066463050)

    internal val shapedGetRunFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_font_size", 1120910005)

    internal val shapedGetRunLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_language", 1464764419)

    internal val shapedGetRunDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_direction", 2413896864)

    internal val shapedGetRunObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_get_run_object", 4069510997)

    internal val shapedTextSubstrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_substr", 1937682086)

    internal val shapedTextGetParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_parent", 3814569979)

    internal val shapedTextFitToWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_fit_to_width", 530670926)

    internal val shapedTextTabAlignPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_tab_align", 1283669550)

    internal val shapedTextShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_shape", 3521089500)

    internal val shapedTextIsReadyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_is_ready", 4155700596)

    internal val shapedTextHasVisibleCharsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_has_visible_chars", 4155700596)

    internal val shapedTextGetGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_glyphs", 2684255073)

    internal val shapedTextSortLogicalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_sort_logical", 2670461153)

    internal val shapedTextGetGlyphCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_glyph_count", 2198884583)

    internal val shapedTextGetRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_range", 733700038)

    internal val shapedTextGetLineBreaksAdvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_line_breaks_adv", 2376991424)

    internal val shapedTextGetLineBreaksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_line_breaks", 2651359741)

    internal val shapedTextGetWordBreaksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_word_breaks", 4099476853)

    internal val shapedTextGetTrimPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_trim_pos", 2198884583)

    internal val shapedTextGetEllipsisPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_ellipsis_pos", 2198884583)

    internal val shapedTextGetEllipsisGlyphsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_ellipsis_glyphs", 2684255073)

    internal val shapedTextGetEllipsisGlyphCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_ellipsis_glyph_count", 2198884583)

    internal val shapedTextOverrunTrimToWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_overrun_trim_to_width", 2723146520)

    internal val shapedTextGetObjectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_objects", 2684255073)

    internal val shapedTextGetObjectRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_object_rect", 447978354)

    internal val shapedTextGetObjectRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_object_range", 2524675647)

    internal val shapedTextGetObjectGlyphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_object_glyph", 1260085030)

    internal val shapedTextGetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_size", 2440833711)

    internal val shapedTextGetAscentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_ascent", 866169185)

    internal val shapedTextGetDescentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_descent", 866169185)

    internal val shapedTextGetWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_width", 866169185)

    internal val shapedTextGetUnderlinePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_underline_position", 866169185)

    internal val shapedTextGetUnderlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_underline_thickness", 866169185)

    internal val shapedTextGetCaretsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_carets", 1574219346)

    internal val shapedTextGetSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_selection", 3714187733)

    internal val shapedTextHitTestGraphemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_hit_test_grapheme", 3149310417)

    internal val shapedTextHitTestPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_hit_test_position", 3149310417)

    internal val shapedTextGetGraphemeBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_grapheme_bounds", 2546185844)

    internal val shapedTextNextGraphemePosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_next_grapheme_pos", 1120910005)

    internal val shapedTextPrevGraphemePosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_prev_grapheme_pos", 1120910005)

    internal val shapedTextGetCharacterBreaksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_character_breaks", 788230395)

    internal val shapedTextNextCharacterPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_next_character_pos", 1120910005)

    internal val shapedTextPrevCharacterPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_prev_character_pos", 1120910005)

    internal val shapedTextClosestCharacterPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_closest_character_pos", 1120910005)

    internal val shapedTextDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_draw", 1647687596)

    internal val shapedTextDrawOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_draw_outline", 1217146601)

    internal val shapedTextGetDominantDirectionInRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "shaped_text_get_dominant_direction_in_range", 3326907668)

    internal val formatNumberPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "format_number", 2664628024)

    internal val parseNumberPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "parse_number", 2664628024)

    internal val percentSignPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "percent_sign", 993269549)

    internal val stringGetWordBreaksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "string_get_word_breaks", 581857818)

    internal val stringGetCharacterBreaksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "string_get_character_breaks", 2333794773)

    internal val isConfusablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "is_confusable", 1433197768)

    internal val spoofCheckPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "spoof_check", 3927539163)

    internal val stripDiacriticsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "strip_diacritics", 3135753539)

    internal val isValidIdentifierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "is_valid_identifier", 3927539163)

    internal val isValidLetterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "is_valid_letter", 1116898809)

    internal val stringToUpperPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "string_to_upper", 2664628024)

    internal val stringToLowerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "string_to_lower", 2664628024)

    internal val stringToTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "string_to_title", 2664628024)

    internal val parseStructuredTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServer", "parse_structured_text", 3310685015)
  }
}
