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
import godot.core.Dictionary
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName11
import godot.core.MethodStringName12
import godot.core.MethodStringName13
import godot.core.MethodStringName14
import godot.core.MethodStringName2
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.MethodStringName9
import godot.core.PackedColorArray
import godot.core.RID
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.Vector2
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_COLOR_ARRAY
import godot.readReturnValue_RID
import godot.readReturnValue_STRING
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_DICTIONARY_LONG_DOUBLE_TRANSFORM2D_LONG_LONG_LONG_LONG_DOUBLE_LONG_PACKED_COLOR_ARRAY
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_RID_VECTOR2_LONG_LONG_COLOR_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_LONG_LONG_LONG_COLOR_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_COLOR_LONG_LONG_LONG_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_LONG_DOUBLE_LONG_LONG_LONG_LONG
import godot.writeMethodArguments_STRING_LONG_DOUBLE_LONG_LONG_LONG_LONG_LONG_LONG
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
import kotlin.jvm.JvmOverloads

/**
 * Abstract base class for different font types. It has methods for drawing text and font character
 * introspection.
 */
@GodotBaseType
public open class Font internal constructor() : Resource() {
  /**
   * Array of fallback [Font]s to use as a substitute if a glyph is not found in this current
   * [Font].
   *
   * If this array is empty in a [FontVariation], the [FontVariation.baseFont]'s fallbacks are used
   * instead.
   */
  public final inline var fallbacks: VariantArray<Font>
    @JvmName("fallbacksProperty")
    get() = getFallbacks()
    @JvmName("fallbacksProperty")
    set(`value`) {
      setFallbacks(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(231, scriptPtr)
  }

  public final fun setFallbacks(fallbacks: VariantArray<Font>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, fallbacks)
    TransferContext.callPtrMethod(MethodBindings.setFallbacksPtr, 0)
  }

  public final fun getFallbacks(): VariantArray<Font> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFallbacksPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Font>)
  }

  /**
   * Returns [TextServer] RID of the font cache for specific variation.
   */
  @JvmOverloads
  public final fun findVariation(
    variationCoordinates: Dictionary<Any?, Any?>,
    faceIndex: Int = 0,
    strength: Float = 0.0f,
    transform: Transform2D = Transform2D(),
    spacingTop: Int = 0,
    spacingBottom: Int = 0,
    spacingSpace: Int = 0,
    spacingGlyph: Int = 0,
    baselineOffset: Float = 0.0f,
    paletteIndex: Long = 0,
    customColors: PackedColorArray = PackedColorArray(),
  ): RID {
    TransferContext.writeMethodArguments_DICTIONARY_LONG_DOUBLE_TRANSFORM2D_LONG_LONG_LONG_LONG_DOUBLE_LONG_PACKED_COLOR_ARRAY(ptr, objectID.id, variationCoordinates, faceIndex.toLong(), strength.toDouble(), transform, spacingTop.toLong(), spacingBottom.toLong(), spacingSpace.toLong(), spacingGlyph.toLong(), baselineOffset.toDouble(), paletteIndex, customColors)
    TransferContext.callPtrMethod(MethodBindings.findVariationPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns [VariantArray] of valid [Font] [RID]s, which can be passed to the [TextServer] methods.
   */
  public final fun getRids(): VariantArray<RID> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRidsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RID>)
  }

  /**
   * Returns the total average font height (ascent plus descent) in pixels.
   *
   * **Note:** Real height of the string is context-dependent and can be significantly different
   * from the value returned by this function. Use it only as rough estimate (e.g. as the height of
   * empty line).
   */
  @JvmOverloads
  public final fun getHeight(fontSize: Int = 16): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.getHeightPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the maximum font ascent (number of pixels above the baseline) of this font and all
   * fallback fonts.
   *
   * **Note:** Real ascent of the string is context-dependent and can be significantly different
   * from the value returned by this function. Use it only as rough estimate (e.g. as the ascent of
   * empty line).
   */
  @JvmOverloads
  public final fun getAscent(fontSize: Int = 16): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.getAscentPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the maximum font descent (number of pixels below the baseline) of this font and all
   * fallback fonts.
   *
   * **Note:** Real descent of the string is context-dependent and can be significantly different
   * from the value returned by this function. Use it only as rough estimate (e.g. as the descent of
   * empty line).
   */
  @JvmOverloads
  public final fun getDescent(fontSize: Int = 16): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.getDescentPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns average pixel offset of the underline below the baseline.
   *
   * **Note:** Real underline position of the string is context-dependent and can be significantly
   * different from the value returned by this function. Use it only as rough estimate.
   */
  @JvmOverloads
  public final fun getUnderlinePosition(fontSize: Int = 16): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.getUnderlinePositionPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns average thickness of the underline.
   *
   * **Note:** Real underline thickness of the string is context-dependent and can be significantly
   * different from the value returned by this function. Use it only as rough estimate.
   */
  @JvmOverloads
  public final fun getUnderlineThickness(fontSize: Int = 16): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.getUnderlineThicknessPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns font family name.
   */
  public final fun getFontName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns font style name.
   */
  public final fun getFontStyleName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontStyleNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns [Dictionary] with OpenType font name strings (localized font names, version,
   * description, license information, sample text, etc.).
   */
  public final fun getOtNameStrings(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOtNameStringsPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Returns font style flags.
   */
  public final fun getFontStyle(): TextServer.FontStyle {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFontStylePtr, 2)
    return TextServer.FontStyle(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns weight (boldness) of the font. A value in the `100...999` range, normal font weight is
   * `400`, bold font weight is `700`.
   */
  public final fun getFontWeight(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFontWeightPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns font stretch amount, compared to a normal width. A percentage value between `50&#37;`
   * and `200&#37;`.
   */
  public final fun getFontStretch(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFontStretchPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the number of predefined color palettes. Palette contains all colors used to render
   * font glyphs. Each palette has the same number of colors.
   */
  public final fun getPaletteCount(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPaletteCountPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns the name of the predefined color palette at [index]. Palette contains all colors used
   * to render font glyphs. Each palette has the same number of colors.
   */
  public final fun getPaletteName(index: Long): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.getPaletteNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the array in the predefined color palette at [index]. Palette contains all colors used
   * to render font glyphs. Each palette has the same number of colors. Colors can be overridden using
   * [FontVariation].
   */
  public final fun getPaletteColors(index: Long): PackedColorArray {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.getPaletteColorsPtr)
    return TransferContext.readReturnValue_PACKED_COLOR_ARRAY()
  }

  /**
   * Returns the amount of spacing for the given [spacing] type.
   */
  public final fun getSpacing(spacing: TextServer.SpacingType): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, spacing.value)
    TransferContext.callPtrMethod(MethodBindings.getSpacingPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns a set of OpenType feature tags. More info:
   * [url=https://docs.microsoft.com/en-us/typography/opentype/spec/featuretags]OpenType feature
   * tags[/url].
   */
  public final fun getOpentypeFeatures(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOpentypeFeaturesPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Sets LRU cache capacity for `draw_*` methods.
   */
  public final fun setCacheCapacity(singleLine: Int, multiLine: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, singleLine.toLong(), multiLine.toLong())
    TransferContext.callPtrMethod(MethodBindings.setCacheCapacityPtr, 0)
  }

  /**
   * Returns the size of a bounding box of a single-line string, taking kerning, advance and
   * subpixel positioning into account. See also [getMultilineStringSize] and [drawString].
   *
   * For example, to get the string size as displayed by a single-line Label, use:
   *
   * ```gdscript
   * //gdscript
   * var string_size = $Label.get_theme_font("font").get_string_size($Label.text,
   * HORIZONTAL_ALIGNMENT_LEFT, -1, $Label.get_theme_font_size("font_size"))
   * ```
   *
   * ```csharp
   * //csharp
   * Label label = GetNode<Label>("Label");
   * Vector2 stringSize = label.GetThemeFont("font").GetStringSize(label.Text,
   * HorizontalAlignment.Left, -1, label.GetThemeFontSize("font_size"));
   * ```
   *
   * **Note:** Since kerning, advance and subpixel positioning are taken into account by
   * [getStringSize], using separate [getStringSize] calls on substrings of a string then adding the
   * results together will return a different result compared to using a single [getStringSize] call on
   * the full string.
   *
   * **Note:** Real height of the string is context-dependent and can be significantly different
   * from the value returned by [getHeight].
   */
  @JvmOverloads
  public final fun getStringSize(
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
  ): Vector2 {
    TransferContext.writeMethodArguments_STRING_LONG_DOUBLE_LONG_LONG_LONG_LONG(ptr, objectID.id, text, alignment.value, width.toDouble(), fontSize.toLong(), justificationFlags.flag, direction.value, orientation.value)
    TransferContext.callMethod(MethodBindings.getStringSizePtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the size of a bounding box of a string broken into the lines, taking kerning and
   * advance into account.
   *
   * See also [drawMultilineString].
   */
  @JvmOverloads
  public final fun getMultilineStringSize(
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    maxLines: Int = -1,
    brkFlags: TextServer.LineBreakFlag = TextServer.LineBreakFlag(3),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
  ): Vector2 {
    TransferContext.writeMethodArguments_STRING_LONG_DOUBLE_LONG_LONG_LONG_LONG_LONG_LONG(ptr, objectID.id, text, alignment.value, width.toDouble(), fontSize.toLong(), maxLines.toLong(), brkFlags.flag, justificationFlags.flag, direction.value, orientation.value)
    TransferContext.callMethod(MethodBindings.getMultilineStringSizePtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Draw [text] into a canvas item using the font, at a given position, with [modulate] color,
   * optionally clipping the width and aligning horizontally. [pos] specifies the baseline, not the
   * top. To draw from the top, *ascent* must be added to the Y axis. If [oversampling] is greater than
   * zero, it is used as font oversampling factor, otherwise viewport oversampling settings are used.
   *
   * See also [CanvasItem.drawString].
   */
  @JvmOverloads
  public final fun drawString(
    canvasItem: RID,
    pos: Vector2,
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_COLOR_LONG_LONG_LONG_DOUBLE(ptr, objectID.id, canvasItem, pos, text, alignment.value, width.toDouble(), fontSize.toLong(), modulate, justificationFlags.flag, direction.value, orientation.value, oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawStringPtr)
  }

  /**
   * Breaks [text] into lines using rules specified by [brkFlags] and draws it into a canvas item
   * using the font, at a given position, with [modulate] color, optionally clipping the width and
   * aligning horizontally. [pos] specifies the baseline of the first line, not the top. To draw from
   * the top, *ascent* must be added to the Y axis. If [oversampling] is greater than zero, it is used
   * as font oversampling factor, otherwise viewport oversampling settings are used.
   *
   * See also [CanvasItem.drawMultilineString].
   */
  @JvmOverloads
  public final fun drawMultilineString(
    canvasItem: RID,
    pos: Vector2,
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    maxLines: Int = -1,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    brkFlags: TextServer.LineBreakFlag = TextServer.LineBreakFlag(3),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(ptr, objectID.id, canvasItem, pos, text, alignment.value, width.toDouble(), fontSize.toLong(), maxLines.toLong(), modulate, brkFlags.flag, justificationFlags.flag, direction.value, orientation.value, oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawMultilineStringPtr)
  }

  /**
   * Draw [text] outline into a canvas item using the font, at a given position, with [modulate]
   * color and [size] outline size, optionally clipping the width and aligning horizontally. [pos]
   * specifies the baseline, not the top. To draw from the top, *ascent* must be added to the Y axis.
   * If [oversampling] is greater than zero, it is used as font oversampling factor, otherwise viewport
   * oversampling settings are used.
   *
   * See also [CanvasItem.drawStringOutline].
   */
  @JvmOverloads
  public final fun drawStringOutline(
    canvasItem: RID,
    pos: Vector2,
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    size: Int = 1,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_DOUBLE(ptr, objectID.id, canvasItem, pos, text, alignment.value, width.toDouble(), fontSize.toLong(), size.toLong(), modulate, justificationFlags.flag, direction.value, orientation.value, oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawStringOutlinePtr)
  }

  /**
   * Breaks [text] to the lines using rules specified by [brkFlags] and draws text outline into a
   * canvas item using the font, at a given position, with [modulate] color and [size] outline size,
   * optionally clipping the width and aligning horizontally. [pos] specifies the baseline of the first
   * line, not the top. To draw from the top, *ascent* must be added to the Y axis. If [oversampling]
   * is greater than zero, it is used as font oversampling factor, otherwise viewport oversampling
   * settings are used.
   *
   * See also [CanvasItem.drawMultilineStringOutline].
   */
  @JvmOverloads
  public final fun drawMultilineStringOutline(
    canvasItem: RID,
    pos: Vector2,
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    maxLines: Int = -1,
    size: Int = 1,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    brkFlags: TextServer.LineBreakFlag = TextServer.LineBreakFlag(3),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(ptr, objectID.id, canvasItem, pos, text, alignment.value, width.toDouble(), fontSize.toLong(), maxLines.toLong(), size.toLong(), modulate, brkFlags.flag, justificationFlags.flag, direction.value, orientation.value, oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawMultilineStringOutlinePtr)
  }

  /**
   * Returns the size of a character. Does not take kerning into account.
   *
   * **Note:** Do not use this function to calculate width of the string character by character, use
   * [getStringSize] or [TextLine] instead. The height returned is the font height (see also
   * [getHeight]) and has no relation to the glyph height.
   */
  public final fun getCharSize(char: Long, fontSize: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, char, fontSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCharSizePtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Draw a single Unicode character [char] into a canvas item using the font, at a given position,
   * with [modulate] color. [pos] specifies the baseline, not the top. To draw from the top, *ascent*
   * must be added to the Y axis. If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   *
   * **Note:** Do not use this function to draw strings character by character, use [drawString] or
   * [TextLine] instead.
   */
  @JvmOverloads
  public final fun drawChar(
    canvasItem: RID,
    pos: Vector2,
    char: Long,
    fontSize: Int,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Float {
    TransferContext.writeMethodArguments_RID_VECTOR2_LONG_LONG_COLOR_DOUBLE(ptr, objectID.id, canvasItem, pos, char, fontSize.toLong(), modulate, oversampling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.drawCharPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Draw a single Unicode character [char] outline into a canvas item using the font, at a given
   * position, with [modulate] color and [size] outline size. [pos] specifies the baseline, not the
   * top. To draw from the top, *ascent* must be added to the Y axis. If [oversampling] is greater than
   * zero, it is used as font oversampling factor, otherwise viewport oversampling settings are used.
   *
   * **Note:** Do not use this function to draw strings character by character, use [drawString] or
   * [TextLine] instead.
   */
  @JvmOverloads
  public final fun drawCharOutline(
    canvasItem: RID,
    pos: Vector2,
    char: Long,
    fontSize: Int,
    size: Int = -1,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Float {
    TransferContext.writeMethodArguments_RID_VECTOR2_LONG_LONG_LONG_COLOR_DOUBLE(ptr, objectID.id, canvasItem, pos, char, fontSize.toLong(), size.toLong(), modulate, oversampling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.drawCharOutlinePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns `true` if a Unicode [char] is available in the font.
   */
  public final fun hasChar(char: Long): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, char)
    TransferContext.callPtrMethod(MethodBindings.hasCharPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a string containing all the characters available in the font.
   *
   * If a given character is included in more than one font data source, it appears only once in the
   * returned string.
   */
  public final fun getSupportedChars(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportedCharsPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if the font supports the given language (as a
   * [url=https://en.wikipedia.org/wiki/ISO_639-1]ISO 639[/url] code).
   */
  public final fun isLanguageSupported(language: String): Boolean {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, language)
    TransferContext.callMethod(MethodBindings.isLanguageSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the font supports the given script (as a
   * [url=https://en.wikipedia.org/wiki/ISO_15924]ISO 15924[/url] code).
   */
  public final fun isScriptSupported(script: String): Boolean {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, script)
    TransferContext.callMethod(MethodBindings.isScriptSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns list of OpenType features supported by font.
   */
  public final fun getSupportedFeatureList(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportedFeatureListPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Returns list of supported
   * [url=https://docs.microsoft.com/en-us/typography/opentype/spec/dvaraxisreg]variation
   * coordinates[/url], each coordinate is returned as `tag:
   * Vector3i(min_value,max_value,default_value)`.
   *
   * Font variations allow for continuous change of glyph characteristics along some given design
   * axis, such as weight, width or slant.
   *
   * To print available variation axes of a variable font:
   *
   * ```
   * var fv = FontVariation.new()
   * fv.base_font = load("res://RobotoFlex.ttf")
   * var variation_list = fv.get_supported_variation_list()
   * for tag in variation_list:
   * 	var name = TextServerManager.get_primary_interface().tag_to_name(tag)
   * 	var values = variation_list[tag]
   * 	print("variation axis: &#37;s (&#37;d)\n\tmin, max, default: &#37;s" &#37; [name, tag,
   * values])
   * ```
   *
   * **Note:** To set and get variation coordinates of a [FontVariation], use
   * [FontVariation.variationOpentype].
   */
  public final fun getSupportedVariationList(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportedVariationListPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Returns number of faces in the TrueType / OpenType collection.
   */
  public final fun getFaceCount(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFaceCountPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public companion object {
    @JvmField
    public val setFallbacksName: MethodStringName1<Font, Unit, VariantArray<Font>> =
        MethodStringName1<Font, Unit, VariantArray<Font>>("set_fallbacks")

    @JvmField
    public val getFallbacksName: MethodStringName0<Font, VariantArray<Font>> =
        MethodStringName0<Font, VariantArray<Font>>("get_fallbacks")

    @JvmField
    public val findVariationName:
        MethodStringName11<Font, RID, Dictionary<Any?, Any?>, Int, Float, Transform2D, Int, Int, Int, Int, Float, Long, PackedColorArray>
        =
        MethodStringName11<Font, RID, Dictionary<Any?, Any?>, Int, Float, Transform2D, Int, Int, Int, Int, Float, Long, PackedColorArray>("find_variation")

    @JvmField
    public val getRidsName: MethodStringName0<Font, VariantArray<RID>> =
        MethodStringName0<Font, VariantArray<RID>>("get_rids")

    @JvmField
    public val getHeightName: MethodStringName1<Font, Float, Int> =
        MethodStringName1<Font, Float, Int>("get_height")

    @JvmField
    public val getAscentName: MethodStringName1<Font, Float, Int> =
        MethodStringName1<Font, Float, Int>("get_ascent")

    @JvmField
    public val getDescentName: MethodStringName1<Font, Float, Int> =
        MethodStringName1<Font, Float, Int>("get_descent")

    @JvmField
    public val getUnderlinePositionName: MethodStringName1<Font, Float, Int> =
        MethodStringName1<Font, Float, Int>("get_underline_position")

    @JvmField
    public val getUnderlineThicknessName: MethodStringName1<Font, Float, Int> =
        MethodStringName1<Font, Float, Int>("get_underline_thickness")

    @JvmField
    public val getFontNameName: MethodStringName0<Font, String> =
        MethodStringName0<Font, String>("get_font_name")

    @JvmField
    public val getFontStyleNameName: MethodStringName0<Font, String> =
        MethodStringName0<Font, String>("get_font_style_name")

    @JvmField
    public val getOtNameStringsName: MethodStringName0<Font, Dictionary<Any?, Any?>> =
        MethodStringName0<Font, Dictionary<Any?, Any?>>("get_ot_name_strings")

    @JvmField
    public val getFontStyleName: MethodStringName0<Font, TextServer.FontStyle> =
        MethodStringName0<Font, TextServer.FontStyle>("get_font_style")

    @JvmField
    public val getFontWeightName: MethodStringName0<Font, Int> =
        MethodStringName0<Font, Int>("get_font_weight")

    @JvmField
    public val getFontStretchName: MethodStringName0<Font, Int> =
        MethodStringName0<Font, Int>("get_font_stretch")

    @JvmField
    public val getPaletteCountName: MethodStringName0<Font, Long> =
        MethodStringName0<Font, Long>("get_palette_count")

    @JvmField
    public val getPaletteNameName: MethodStringName1<Font, String, Long> =
        MethodStringName1<Font, String, Long>("get_palette_name")

    @JvmField
    public val getPaletteColorsName: MethodStringName1<Font, PackedColorArray, Long> =
        MethodStringName1<Font, PackedColorArray, Long>("get_palette_colors")

    @JvmField
    public val getSpacingName: MethodStringName1<Font, Int, TextServer.SpacingType> =
        MethodStringName1<Font, Int, TextServer.SpacingType>("get_spacing")

    @JvmField
    public val getOpentypeFeaturesName: MethodStringName0<Font, Dictionary<Any?, Any?>> =
        MethodStringName0<Font, Dictionary<Any?, Any?>>("get_opentype_features")

    @JvmField
    public val setCacheCapacityName: MethodStringName2<Font, Unit, Int, Int> =
        MethodStringName2<Font, Unit, Int, Int>("set_cache_capacity")

    @JvmField
    public val getStringSizeName:
        MethodStringName7<Font, Vector2, String, HorizontalAlignment, Float, Int, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation>
        =
        MethodStringName7<Font, Vector2, String, HorizontalAlignment, Float, Int, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation>("get_string_size")

    @JvmField
    public val getMultilineStringSizeName:
        MethodStringName9<Font, Vector2, String, HorizontalAlignment, Float, Int, Int, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation>
        =
        MethodStringName9<Font, Vector2, String, HorizontalAlignment, Float, Int, Int, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation>("get_multiline_string_size")

    @JvmField
    public val drawStringName:
        MethodStringName11<Font, Unit, RID, Vector2, String, HorizontalAlignment, Float, Int, Color, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>
        =
        MethodStringName11<Font, Unit, RID, Vector2, String, HorizontalAlignment, Float, Int, Color, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>("draw_string")

    @JvmField
    public val drawMultilineStringName:
        MethodStringName13<Font, Unit, RID, Vector2, String, HorizontalAlignment, Float, Int, Int, Color, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>
        =
        MethodStringName13<Font, Unit, RID, Vector2, String, HorizontalAlignment, Float, Int, Int, Color, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>("draw_multiline_string")

    @JvmField
    public val drawStringOutlineName:
        MethodStringName12<Font, Unit, RID, Vector2, String, HorizontalAlignment, Float, Int, Int, Color, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>
        =
        MethodStringName12<Font, Unit, RID, Vector2, String, HorizontalAlignment, Float, Int, Int, Color, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>("draw_string_outline")

    @JvmField
    public val drawMultilineStringOutlineName:
        MethodStringName14<Font, Unit, RID, Vector2, String, HorizontalAlignment, Float, Int, Int, Int, Color, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>
        =
        MethodStringName14<Font, Unit, RID, Vector2, String, HorizontalAlignment, Float, Int, Int, Int, Color, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>("draw_multiline_string_outline")

    @JvmField
    public val getCharSizeName: MethodStringName2<Font, Vector2, Long, Int> =
        MethodStringName2<Font, Vector2, Long, Int>("get_char_size")

    @JvmField
    public val drawCharName: MethodStringName6<Font, Float, RID, Vector2, Long, Int, Color, Float> =
        MethodStringName6<Font, Float, RID, Vector2, Long, Int, Color, Float>("draw_char")

    @JvmField
    public val drawCharOutlineName:
        MethodStringName7<Font, Float, RID, Vector2, Long, Int, Int, Color, Float> =
        MethodStringName7<Font, Float, RID, Vector2, Long, Int, Int, Color, Float>("draw_char_outline")

    @JvmField
    public val hasCharName: MethodStringName1<Font, Boolean, Long> =
        MethodStringName1<Font, Boolean, Long>("has_char")

    @JvmField
    public val getSupportedCharsName: MethodStringName0<Font, String> =
        MethodStringName0<Font, String>("get_supported_chars")

    @JvmField
    public val isLanguageSupportedName: MethodStringName1<Font, Boolean, String> =
        MethodStringName1<Font, Boolean, String>("is_language_supported")

    @JvmField
    public val isScriptSupportedName: MethodStringName1<Font, Boolean, String> =
        MethodStringName1<Font, Boolean, String>("is_script_supported")

    @JvmField
    public val getSupportedFeatureListName: MethodStringName0<Font, Dictionary<Any?, Any?>> =
        MethodStringName0<Font, Dictionary<Any?, Any?>>("get_supported_feature_list")

    @JvmField
    public val getSupportedVariationListName: MethodStringName0<Font, Dictionary<Any?, Any?>> =
        MethodStringName0<Font, Dictionary<Any?, Any?>>("get_supported_variation_list")

    @JvmField
    public val getFaceCountName: MethodStringName0<Font, Long> =
        MethodStringName0<Font, Long>("get_face_count")
  }

  public object MethodBindings {
    internal val setFallbacksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "set_fallbacks", 381264803)

    internal val getFallbacksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_fallbacks", 3995934104)

    internal val findVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "find_variation", 3275867622)

    internal val getRidsPtr: VoidPtr = TypeManager.getMethodBindPtr("Font", "get_rids", 3995934104)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_height", 378113874)

    internal val getAscentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_ascent", 378113874)

    internal val getDescentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_descent", 378113874)

    internal val getUnderlinePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_underline_position", 378113874)

    internal val getUnderlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_underline_thickness", 378113874)

    internal val getFontNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_font_name", 201670096)

    internal val getFontStyleNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_font_style_name", 201670096)

    internal val getOtNameStringsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_ot_name_strings", 3102165223)

    internal val getFontStylePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_font_style", 2520224254)

    internal val getFontWeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_font_weight", 3905245786)

    internal val getFontStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_font_stretch", 3905245786)

    internal val getPaletteCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_palette_count", 3905245786)

    internal val getPaletteNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_palette_name", 844755477)

    internal val getPaletteColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_palette_colors", 2552048864)

    internal val getSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_spacing", 1310880908)

    internal val getOpentypeFeaturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_opentype_features", 3102165223)

    internal val setCacheCapacityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "set_cache_capacity", 3937882851)

    internal val getStringSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_string_size", 1868866121)

    internal val getMultilineStringSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_multiline_string_size", 519636710)

    internal val drawStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "draw_string", 1976686372)

    internal val drawMultilineStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "draw_multiline_string", 2686601589)

    internal val drawStringOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "draw_string_outline", 701417663)

    internal val drawMultilineStringOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "draw_multiline_string_outline", 4147839237)

    internal val getCharSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_char_size", 3016396712)

    internal val drawCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "draw_char", 3500170256)

    internal val drawCharOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "draw_char_outline", 1684114874)

    internal val hasCharPtr: VoidPtr = TypeManager.getMethodBindPtr("Font", "has_char", 1116898809)

    internal val getSupportedCharsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_supported_chars", 201670096)

    internal val isLanguageSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "is_language_supported", 3927539163)

    internal val isScriptSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "is_script_supported", 3927539163)

    internal val getSupportedFeatureListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_supported_feature_list", 3102165223)

    internal val getSupportedVariationListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_supported_variation_list", 3102165223)

    internal val getFaceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Font", "get_face_count", 3905245786)
  }
}
