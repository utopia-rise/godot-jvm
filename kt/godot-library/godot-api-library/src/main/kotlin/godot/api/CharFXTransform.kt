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
import godot.core.Color
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.Transform2D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantParser._RID
import godot.core.Vector2
import godot.core.Vector2i
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * By setting various properties on this object, you can control how individual characters will be
 * displayed in a [RichTextEffect].
 */
@GodotBaseType
public open class CharFXTransform : RefCounted() {
  /**
   * The current transform of the current glyph. It can be overridden (for example, by driving the
   * position and rotation from a curve). You can also alter the existing value to apply transforms on
   * top of other effects.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var transform: Transform2D
    @JvmName("transformProperty")
    get() = getTransform()
    @JvmName("transformProperty")
    set(`value`) {
      setTransform(value)
    }

  /**
   * Absolute character range in the string, corresponding to the glyph.
   *
   * **Note:** Read-only. Setting this property won't affect drawing.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var range: Vector2i
    @JvmName("rangeProperty")
    get() = getRange()
    @JvmName("rangeProperty")
    set(`value`) {
      setRange(value)
    }

  /**
   * The time elapsed since the [RichTextLabel] was added to the scene tree (in seconds). Time stops
   * when the [RichTextLabel] is paused (see [Node.processMode]). Resets when the text in the
   * [RichTextLabel] is changed.
   *
   * **Note:** Time still passes while the [RichTextLabel] is hidden.
   */
  public final inline var elapsedTime: Double
    @JvmName("elapsedTimeProperty")
    get() = getElapsedTime()
    @JvmName("elapsedTimeProperty")
    set(`value`) {
      setElapsedTime(value)
    }

  /**
   * If `true`, the character will be drawn. If `false`, the character will be hidden. Characters
   * around hidden characters will reflow to take the space of hidden characters. If this is not
   * desired, set their [color] to `Color(1, 1, 1, 0)` instead.
   */
  public final inline var visible: Boolean
    @JvmName("visibleProperty")
    get() = isVisible()
    @JvmName("visibleProperty")
    set(`value`) {
      setVisibility(value)
    }

  /**
   * If `true`, FX transform is called for outline drawing.
   *
   * **Note:** Read-only. Setting this property won't affect drawing.
   */
  public final inline var outline: Boolean
    @JvmName("outlineProperty")
    get() = isOutline()
    @JvmName("outlineProperty")
    set(`value`) {
      setOutline(value)
    }

  /**
   * The position offset the character will be drawn with (in pixels).
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offset: Vector2
    @JvmName("offsetProperty")
    get() = getOffset()
    @JvmName("offsetProperty")
    set(`value`) {
      setOffset(value)
    }

  /**
   * The color the character will be drawn with.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var color: Color
    @JvmName("colorProperty")
    get() = getColor()
    @JvmName("colorProperty")
    set(`value`) {
      setColor(value)
    }

  /**
   * Contains the arguments passed in the opening BBCode tag. By default, arguments are strings; if
   * their contents match a type such as [bool], [int] or [float], they will be converted
   * automatically. Color codes in the form `#rrggbb` or `#rgb` will be converted to an opaque [Color].
   * String arguments may not contain spaces, even if they're quoted. If present, quotes will also be
   * present in the final string.
   *
   * For example, the opening BBCode tag `[example foo=hello bar=true baz=42 color=#ffffff]` will
   * map to the following [Dictionary]:
   *
   * ```
   * {"foo": "hello", "bar": true, "baz": 42, "color": Color(1, 1, 1, 1)}
   * ```
   */
  public final inline var env: Dictionary<Any?, Any?>
    @JvmName("envProperty")
    get() = getEnvironment()
    @JvmName("envProperty")
    set(`value`) {
      setEnvironment(value)
    }

  /**
   * Glyph index specific to the [font]. If you want to replace this glyph, use
   * [TextServer.fontGetGlyphIndex] with [font] to get a new glyph index for a single character.
   */
  public final inline var glyphIndex: Long
    @JvmName("glyphIndexProperty")
    get() = getGlyphIndex()
    @JvmName("glyphIndexProperty")
    set(`value`) {
      setGlyphIndex(value)
    }

  /**
   * Number of glyphs in the grapheme cluster. This value is set in the first glyph of a cluster.
   *
   * **Note:** Read-only. Setting this property won't affect drawing.
   */
  public final inline var glyphCount: Int
    @JvmName("glyphCountProperty")
    get() = getGlyphCount()
    @JvmName("glyphCountProperty")
    set(`value`) {
      setGlyphCount(value)
    }

  /**
   * Glyph flags. See [TextServer.GraphemeFlag] for more info.
   *
   * **Note:** Read-only. Setting this property won't affect drawing.
   */
  public final inline var glyphFlags: Int
    @JvmName("glyphFlagsProperty")
    get() = getGlyphFlags()
    @JvmName("glyphFlagsProperty")
    set(`value`) {
      setGlyphFlags(value)
    }

  /**
   * The character offset of the glyph, relative to the current [RichTextEffect] custom block.
   *
   * **Note:** Read-only. Setting this property won't affect drawing.
   */
  public final inline var relativeIndex: Int
    @JvmName("relativeIndexProperty")
    get() = getRelativeIndex()
    @JvmName("relativeIndexProperty")
    set(`value`) {
      setRelativeIndex(value)
    }

  /**
   * [TextServer] RID of the font used to render glyph, this value can be used with
   * `TextServer.font_*` methods to retrieve font information.
   *
   * **Note:** Read-only. Setting this property won't affect drawing.
   */
  public final inline var font: RID
    @JvmName("fontProperty")
    get() = getFont()
    @JvmName("fontProperty")
    set(`value`) {
      setFont(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(154, scriptPtr)
  }

  /**
   * This is a helper function for [transform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = charfxtransform.transform
   * //Your changes
   * charfxtransform.transform = myCoreType
   * ``````
   *
   * The current transform of the current glyph. It can be overridden (for example, by driving the
   * position and rotation from a curve). You can also alter the existing value to apply transforms on
   * top of other effects.
   */
  @CoreTypeHelper
  public final fun transformMutate(block: Transform2D.() -> Unit): Transform2D = transform.apply {
     block(this)
     transform = this
  }

  /**
   * This is a helper function for [range] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = charfxtransform.range
   * //Your changes
   * charfxtransform.range = myCoreType
   * ``````
   *
   * Absolute character range in the string, corresponding to the glyph.
   *
   * **Note:** Read-only. Setting this property won't affect drawing.
   */
  @CoreTypeHelper
  public final fun rangeMutate(block: Vector2i.() -> Unit): Vector2i = range.apply {
     block(this)
     range = this
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = charfxtransform.offset
   * //Your changes
   * charfxtransform.offset = myCoreType
   * ``````
   *
   * The position offset the character will be drawn with (in pixels).
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = charfxtransform.color
   * //Your changes
   * charfxtransform.color = myCoreType
   * ``````
   *
   * The color the character will be drawn with.
   */
  @CoreTypeHelper
  public final fun colorMutate(block: Color.() -> Unit): Color = color.apply {
     block(this)
     color = this
  }

  public final fun getTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  public final fun setTransform(transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.setTransformPtr)
  }

  public final fun getRange(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRangePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setRange(range: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to range)
    TransferContext.callMethod(MethodBindings.setRangePtr)
  }

  public final fun getElapsedTime(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getElapsedTimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setElapsedTime(time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.setElapsedTimePtr)
  }

  public final fun isVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setVisibility(visibility: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visibility)
    TransferContext.callMethod(MethodBindings.setVisibilityPtr)
  }

  public final fun isOutline(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOutlinePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setOutline(outline: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to outline)
    TransferContext.callMethod(MethodBindings.setOutlinePtr)
  }

  public final fun getOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setOffsetPtr)
  }

  public final fun getColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setColorPtr)
  }

  public final fun getEnvironment(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnvironmentPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun setEnvironment(environment: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to environment)
    TransferContext.callMethod(MethodBindings.setEnvironmentPtr)
  }

  public final fun getGlyphIndex(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlyphIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setGlyphIndex(glyphIndex: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to glyphIndex)
    TransferContext.callMethod(MethodBindings.setGlyphIndexPtr)
  }

  public final fun getRelativeIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRelativeIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setRelativeIndex(relativeIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to relativeIndex.toLong())
    TransferContext.callMethod(MethodBindings.setRelativeIndexPtr)
  }

  public final fun getGlyphCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlyphCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setGlyphCount(glyphCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to glyphCount.toLong())
    TransferContext.callMethod(MethodBindings.setGlyphCountPtr)
  }

  public final fun getGlyphFlags(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlyphFlagsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setGlyphFlags(glyphFlags: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to glyphFlags.toLong())
    TransferContext.callMethod(MethodBindings.setGlyphFlagsPtr)
  }

  public final fun getFont(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setFont(font: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to font)
    TransferContext.callMethod(MethodBindings.setFontPtr)
  }

  public companion object {
    @JvmField
    public val getTransformName: MethodStringName0<CharFXTransform, Transform2D> =
        MethodStringName0<CharFXTransform, Transform2D>("get_transform")

    @JvmField
    public val setTransformName: MethodStringName1<CharFXTransform, Unit, Transform2D> =
        MethodStringName1<CharFXTransform, Unit, Transform2D>("set_transform")

    @JvmField
    public val getRangeName: MethodStringName0<CharFXTransform, Vector2i> =
        MethodStringName0<CharFXTransform, Vector2i>("get_range")

    @JvmField
    public val setRangeName: MethodStringName1<CharFXTransform, Unit, Vector2i> =
        MethodStringName1<CharFXTransform, Unit, Vector2i>("set_range")

    @JvmField
    public val getElapsedTimeName: MethodStringName0<CharFXTransform, Double> =
        MethodStringName0<CharFXTransform, Double>("get_elapsed_time")

    @JvmField
    public val setElapsedTimeName: MethodStringName1<CharFXTransform, Unit, Double> =
        MethodStringName1<CharFXTransform, Unit, Double>("set_elapsed_time")

    @JvmField
    public val isVisibleName: MethodStringName0<CharFXTransform, Boolean> =
        MethodStringName0<CharFXTransform, Boolean>("is_visible")

    @JvmField
    public val setVisibilityName: MethodStringName1<CharFXTransform, Unit, Boolean> =
        MethodStringName1<CharFXTransform, Unit, Boolean>("set_visibility")

    @JvmField
    public val isOutlineName: MethodStringName0<CharFXTransform, Boolean> =
        MethodStringName0<CharFXTransform, Boolean>("is_outline")

    @JvmField
    public val setOutlineName: MethodStringName1<CharFXTransform, Unit, Boolean> =
        MethodStringName1<CharFXTransform, Unit, Boolean>("set_outline")

    @JvmField
    public val getOffsetName: MethodStringName0<CharFXTransform, Vector2> =
        MethodStringName0<CharFXTransform, Vector2>("get_offset")

    @JvmField
    public val setOffsetName: MethodStringName1<CharFXTransform, Unit, Vector2> =
        MethodStringName1<CharFXTransform, Unit, Vector2>("set_offset")

    @JvmField
    public val getColorName: MethodStringName0<CharFXTransform, Color> =
        MethodStringName0<CharFXTransform, Color>("get_color")

    @JvmField
    public val setColorName: MethodStringName1<CharFXTransform, Unit, Color> =
        MethodStringName1<CharFXTransform, Unit, Color>("set_color")

    @JvmField
    public val getEnvironmentName: MethodStringName0<CharFXTransform, Dictionary<Any?, Any?>> =
        MethodStringName0<CharFXTransform, Dictionary<Any?, Any?>>("get_environment")

    @JvmField
    public val setEnvironmentName: MethodStringName1<CharFXTransform, Unit, Dictionary<Any?, Any?>>
        = MethodStringName1<CharFXTransform, Unit, Dictionary<Any?, Any?>>("set_environment")

    @JvmField
    public val getGlyphIndexName: MethodStringName0<CharFXTransform, Long> =
        MethodStringName0<CharFXTransform, Long>("get_glyph_index")

    @JvmField
    public val setGlyphIndexName: MethodStringName1<CharFXTransform, Unit, Long> =
        MethodStringName1<CharFXTransform, Unit, Long>("set_glyph_index")

    @JvmField
    public val getRelativeIndexName: MethodStringName0<CharFXTransform, Int> =
        MethodStringName0<CharFXTransform, Int>("get_relative_index")

    @JvmField
    public val setRelativeIndexName: MethodStringName1<CharFXTransform, Unit, Int> =
        MethodStringName1<CharFXTransform, Unit, Int>("set_relative_index")

    @JvmField
    public val getGlyphCountName: MethodStringName0<CharFXTransform, Int> =
        MethodStringName0<CharFXTransform, Int>("get_glyph_count")

    @JvmField
    public val setGlyphCountName: MethodStringName1<CharFXTransform, Unit, Int> =
        MethodStringName1<CharFXTransform, Unit, Int>("set_glyph_count")

    @JvmField
    public val getGlyphFlagsName: MethodStringName0<CharFXTransform, Int> =
        MethodStringName0<CharFXTransform, Int>("get_glyph_flags")

    @JvmField
    public val setGlyphFlagsName: MethodStringName1<CharFXTransform, Unit, Int> =
        MethodStringName1<CharFXTransform, Unit, Int>("set_glyph_flags")

    @JvmField
    public val getFontName: MethodStringName0<CharFXTransform, RID> =
        MethodStringName0<CharFXTransform, RID>("get_font")

    @JvmField
    public val setFontName: MethodStringName1<CharFXTransform, Unit, RID> =
        MethodStringName1<CharFXTransform, Unit, RID>("set_font")
  }

  public object MethodBindings {
    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_transform", 3761352769)

    internal val setTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_transform", 2761652528)

    internal val getRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_range", 2741790807)

    internal val setRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_range", 1130785943)

    internal val getElapsedTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_elapsed_time", 191475506)

    internal val setElapsedTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_elapsed_time", 373806689)

    internal val isVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "is_visible", 2240911060)

    internal val setVisibilityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_visibility", 2586408642)

    internal val isOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "is_outline", 2240911060)

    internal val setOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_outline", 2586408642)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_offset", 1497962370)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_offset", 743155724)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_color", 3200896285)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_color", 2920490490)

    internal val getEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_environment", 2382534195)

    internal val setEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_environment", 4155329257)

    internal val getGlyphIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_glyph_index", 3905245786)

    internal val setGlyphIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_glyph_index", 1286410249)

    internal val getRelativeIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_relative_index", 3905245786)

    internal val setRelativeIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_relative_index", 1286410249)

    internal val getGlyphCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_glyph_count", 3905245786)

    internal val setGlyphCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_glyph_count", 1286410249)

    internal val getGlyphFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_glyph_flags", 3905245786)

    internal val setGlyphFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_glyph_flags", 1286410249)

    internal val getFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "get_font", 2944877500)

    internal val setFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharFXTransform", "set_font", 2722037293)
  }
}
