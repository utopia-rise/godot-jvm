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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedColorArray
import godot.core.Transform2D
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import godot.core.VariantParser.TRANSFORM2D
import kotlin.Any
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Provides OpenType variations, simulated bold / slant, and additional font settings like OpenType
 * features and extra spacing.
 *
 * To use simulated bold font variant:
 *
 * ```gdscript
 * //gdscript
 * var fv = FontVariation.new()
 * fv.base_font = load("res://BarlowCondensed-Regular.ttf")
 * fv.variation_embolden = 1.2
 * $Label.add_theme_font_override("font", fv)
 * $Label.add_theme_font_size_override("font_size", 64)
 * ```
 *
 * ```csharp
 * //csharp
 * var fv = new FontVariation();
 * fv.SetBaseFont(ResourceLoader.Load<FontFile>("res://BarlowCondensed-Regular.ttf"));
 * fv.SetVariationEmbolden(1.2);
 * GetNode("Label").AddThemeFontOverride("font", fv);
 * GetNode("Label").AddThemeFontSizeOverride("font_size", 64);
 * ```
 *
 * To set the coordinate of multiple variation axes:
 *
 * ```
 * var fv = FontVariation.new();
 * var ts = TextServerManager.get_primary_interface()
 * fv.base_font = load("res://BarlowCondensed-Regular.ttf")
 * fv.variation_opentype = { ts.name_to_tag("wght"): 900, ts.name_to_tag("custom_hght"): 900 }
 * ```
 */
@GodotBaseType
public open class FontVariation : Font() {
  /**
   * Base font used to create a variation. If not set, default [Theme] font is used.
   */
  public final inline var baseFont: Font?
    @JvmName("baseFontProperty")
    get() = getBaseFont()
    @JvmName("baseFontProperty")
    set(`value`) {
      setBaseFont(value)
    }

  /**
   * Font OpenType variation coordinates. More info:
   * [url=https://docs.microsoft.com/en-us/typography/opentype/spec/dvaraxisreg]OpenType variation
   * tags[/url].
   *
   * **Note:** This [Dictionary] uses OpenType tags as keys. Variation axes can be identified both
   * by tags ([int], e.g. `0x77678674`) and names ([String], e.g. `wght`). Some axes might be
   * accessible by multiple names. For example, `wght` refers to the same axis as `weight`. Tags on the
   * other hand are unique. To convert between names and tags, use [TextServer.nameToTag] and
   * [TextServer.tagToName].
   *
   * **Note:** To get available variation axes of a font, use [Font.getSupportedVariationList].
   */
  public final inline var variationOpentype: Dictionary<Any?, Any?>
    @JvmName("variationOpentypeProperty")
    get() = getVariationOpentype()
    @JvmName("variationOpentypeProperty")
    set(`value`) {
      setVariationOpentype(value)
    }

  /**
   * Active face index in the TrueType / OpenType collection file.
   */
  public final inline var variationFaceIndex: Int
    @JvmName("variationFaceIndexProperty")
    get() = getVariationFaceIndex()
    @JvmName("variationFaceIndexProperty")
    set(`value`) {
      setVariationFaceIndex(value)
    }

  /**
   * If is not equal to zero, emboldens the font outlines. Negative values reduce the outline
   * thickness.
   *
   * **Note:** Emboldened fonts might have self-intersecting outlines, which will prevent MSDF fonts
   * and [TextMesh] from working correctly.
   */
  public final inline var variationEmbolden: Float
    @JvmName("variationEmboldenProperty")
    get() = getVariationEmbolden()
    @JvmName("variationEmboldenProperty")
    set(`value`) {
      setVariationEmbolden(value)
    }

  /**
   * 2D transform, applied to the font outlines, can be used for slanting, flipping and rotating
   * glyphs.
   *
   * For example, to simulate italic typeface by slanting, apply the following transform
   * `Transform2D(1.0, slant, 0.0, 1.0, 0.0, 0.0)`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var variationTransform: Transform2D
    @JvmName("variationTransformProperty")
    get() = getVariationTransform()
    @JvmName("variationTransformProperty")
    set(`value`) {
      setVariationTransform(value)
    }

  /**
   * A set of OpenType feature tags. More info:
   * [url=https://docs.microsoft.com/en-us/typography/opentype/spec/featuretags]OpenType feature
   * tags[/url].
   */
  public final inline var opentypeFeatures: Dictionary<Any?, Any?>
    @JvmName("opentypeFeaturesProperty")
    get() = getOpentypeFeatures()
    @JvmName("opentypeFeaturesProperty")
    set(`value`) {
      setOpentypeFeatures(value)
    }

  /**
   * Extra spacing between graphical glyphs.
   */
  public final inline var spacingGlyph: Int
    @JvmName("spacingGlyphProperty")
    get() = getSpacing(TextServer.SpacingType.GLYPH)
    @JvmName("spacingGlyphProperty")
    set(`value`) {
      setSpacing(TextServer.SpacingType.GLYPH, value)
    }

  /**
   * Extra width of the space glyphs.
   */
  public final inline var spacingSpace: Int
    @JvmName("spacingSpaceProperty")
    get() = getSpacing(TextServer.SpacingType.SPACE)
    @JvmName("spacingSpaceProperty")
    set(`value`) {
      setSpacing(TextServer.SpacingType.SPACE, value)
    }

  /**
   * Extra spacing at the top of the line in pixels.
   */
  public final inline var spacingTop: Int
    @JvmName("spacingTopProperty")
    get() = getSpacing(TextServer.SpacingType.TOP)
    @JvmName("spacingTopProperty")
    set(`value`) {
      setSpacing(TextServer.SpacingType.TOP, value)
    }

  /**
   * Extra spacing at the bottom of the line in pixels.
   */
  public final inline var spacingBottom: Int
    @JvmName("spacingBottomProperty")
    get() = getSpacing(TextServer.SpacingType.BOTTOM)
    @JvmName("spacingBottomProperty")
    set(`value`) {
      setSpacing(TextServer.SpacingType.BOTTOM, value)
    }

  /**
   * Extra baseline offset (as a fraction of font height).
   */
  public final inline var baselineOffset: Float
    @JvmName("baselineOffsetProperty")
    get() = getBaselineOffset()
    @JvmName("baselineOffsetProperty")
    set(`value`) {
      setBaselineOffset(value)
    }

  /**
   * A palette index.
   */
  public final inline var paletteIndex: Long
    @JvmName("paletteIndexProperty")
    get() = getPaletteIndex()
    @JvmName("paletteIndexProperty")
    set(`value`) {
      setPaletteIndex(value)
    }

  /**
   * An array of colors to override predefined palette. Use `Color(0, 0, 0, 0)`, to keep predefined
   * palette color at specific position.
   */
  public final inline var paletteCustomColors: PackedColorArray
    @JvmName("paletteCustomColorsProperty")
    get() = getPaletteCustomColors()
    @JvmName("paletteCustomColorsProperty")
    set(`value`) {
      setPaletteCustomColors(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(235, scriptPtr)
  }

  /**
   * This is a helper function for [variationTransform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = fontvariation.variationTransform
   * //Your changes
   * fontvariation.variationTransform = myCoreType
   * ``````
   *
   * 2D transform, applied to the font outlines, can be used for slanting, flipping and rotating
   * glyphs.
   *
   * For example, to simulate italic typeface by slanting, apply the following transform
   * `Transform2D(1.0, slant, 0.0, 1.0, 0.0, 0.0)`.
   */
  @CoreTypeHelper
  public final fun variationTransformMutate(block: Transform2D.() -> Unit): Transform2D =
      variationTransform.apply {
     block(this)
     variationTransform = this
  }

  public final fun setBaseFont(font: Font?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font)
    TransferContext.callMethod(MethodBindings.setBaseFontPtr)
  }

  public final fun getBaseFont(): Font? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBaseFontPtr)
    return (TransferContext.readReturnValue(OBJECT) as Font?)
  }

  public final fun setVariationOpentype(coords: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to coords)
    TransferContext.callMethod(MethodBindings.setVariationOpentypePtr)
  }

  public final fun getVariationOpentype(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVariationOpentypePtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun setVariationEmbolden(strength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to strength.toDouble())
    TransferContext.callMethod(MethodBindings.setVariationEmboldenPtr)
  }

  public final fun getVariationEmbolden(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVariationEmboldenPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVariationFaceIndex(faceIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to faceIndex.toLong())
    TransferContext.callMethod(MethodBindings.setVariationFaceIndexPtr)
  }

  public final fun getVariationFaceIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVariationFaceIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setVariationTransform(transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.setVariationTransformPtr)
  }

  public final fun getVariationTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVariationTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  public final fun setOpentypeFeatures(features: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to features)
    TransferContext.callMethod(MethodBindings.setOpentypeFeaturesPtr)
  }

  /**
   * Sets the spacing for [spacing] to [value] in pixels (not relative to the font size).
   */
  public final fun setSpacing(spacing: TextServer.SpacingType, `value`: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to spacing.value, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.setSpacingPtr)
  }

  public final fun setBaselineOffset(baselineOffset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to baselineOffset.toDouble())
    TransferContext.callMethod(MethodBindings.setBaselineOffsetPtr)
  }

  public final fun getBaselineOffset(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBaselineOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getPaletteIndex(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPaletteIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setPaletteIndex(paletteIndex: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to paletteIndex)
    TransferContext.callMethod(MethodBindings.setPaletteIndexPtr)
  }

  public final fun getPaletteCustomColors(): PackedColorArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPaletteCustomColorsPtr)
    return (TransferContext.readReturnValue(PACKED_COLOR_ARRAY) as PackedColorArray)
  }

  public final fun setPaletteCustomColors(colors: PackedColorArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_COLOR_ARRAY to colors)
    TransferContext.callMethod(MethodBindings.setPaletteCustomColorsPtr)
  }

  public companion object {
    @JvmField
    public val setBaseFontName: MethodStringName1<FontVariation, Unit, Font?> =
        MethodStringName1<FontVariation, Unit, Font?>("set_base_font")

    @JvmField
    public val getBaseFontName: MethodStringName0<FontVariation, Font?> =
        MethodStringName0<FontVariation, Font?>("get_base_font")

    @JvmField
    public val setVariationOpentypeName:
        MethodStringName1<FontVariation, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<FontVariation, Unit, Dictionary<Any?, Any?>>("set_variation_opentype")

    @JvmField
    public val getVariationOpentypeName: MethodStringName0<FontVariation, Dictionary<Any?, Any?>> =
        MethodStringName0<FontVariation, Dictionary<Any?, Any?>>("get_variation_opentype")

    @JvmField
    public val setVariationEmboldenName: MethodStringName1<FontVariation, Unit, Float> =
        MethodStringName1<FontVariation, Unit, Float>("set_variation_embolden")

    @JvmField
    public val getVariationEmboldenName: MethodStringName0<FontVariation, Float> =
        MethodStringName0<FontVariation, Float>("get_variation_embolden")

    @JvmField
    public val setVariationFaceIndexName: MethodStringName1<FontVariation, Unit, Int> =
        MethodStringName1<FontVariation, Unit, Int>("set_variation_face_index")

    @JvmField
    public val getVariationFaceIndexName: MethodStringName0<FontVariation, Int> =
        MethodStringName0<FontVariation, Int>("get_variation_face_index")

    @JvmField
    public val setVariationTransformName: MethodStringName1<FontVariation, Unit, Transform2D> =
        MethodStringName1<FontVariation, Unit, Transform2D>("set_variation_transform")

    @JvmField
    public val getVariationTransformName: MethodStringName0<FontVariation, Transform2D> =
        MethodStringName0<FontVariation, Transform2D>("get_variation_transform")

    @JvmField
    public val setOpentypeFeaturesName:
        MethodStringName1<FontVariation, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<FontVariation, Unit, Dictionary<Any?, Any?>>("set_opentype_features")

    @JvmField
    public val setSpacingName: MethodStringName2<FontVariation, Unit, TextServer.SpacingType, Int> =
        MethodStringName2<FontVariation, Unit, TextServer.SpacingType, Int>("set_spacing")

    @JvmField
    public val setBaselineOffsetName: MethodStringName1<FontVariation, Unit, Float> =
        MethodStringName1<FontVariation, Unit, Float>("set_baseline_offset")

    @JvmField
    public val getBaselineOffsetName: MethodStringName0<FontVariation, Float> =
        MethodStringName0<FontVariation, Float>("get_baseline_offset")

    @JvmField
    public val getPaletteIndexName: MethodStringName0<FontVariation, Long> =
        MethodStringName0<FontVariation, Long>("get_palette_index")

    @JvmField
    public val setPaletteIndexName: MethodStringName1<FontVariation, Unit, Long> =
        MethodStringName1<FontVariation, Unit, Long>("set_palette_index")

    @JvmField
    public val getPaletteCustomColorsName: MethodStringName0<FontVariation, PackedColorArray> =
        MethodStringName0<FontVariation, PackedColorArray>("get_palette_custom_colors")

    @JvmField
    public val setPaletteCustomColorsName: MethodStringName1<FontVariation, Unit, PackedColorArray>
        = MethodStringName1<FontVariation, Unit, PackedColorArray>("set_palette_custom_colors")
  }

  public object MethodBindings {
    internal val setBaseFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_base_font", 1262170328)

    internal val getBaseFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "get_base_font", 3229501585)

    internal val setVariationOpentypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_variation_opentype", 4155329257)

    internal val getVariationOpentypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "get_variation_opentype", 3102165223)

    internal val setVariationEmboldenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_variation_embolden", 373806689)

    internal val getVariationEmboldenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "get_variation_embolden", 1740695150)

    internal val setVariationFaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_variation_face_index", 1286410249)

    internal val getVariationFaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "get_variation_face_index", 3905245786)

    internal val setVariationTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_variation_transform", 2761652528)

    internal val getVariationTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "get_variation_transform", 3814499831)

    internal val setOpentypeFeaturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_opentype_features", 4155329257)

    internal val setSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_spacing", 3122339690)

    internal val setBaselineOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_baseline_offset", 373806689)

    internal val getBaselineOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "get_baseline_offset", 1740695150)

    internal val getPaletteIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "get_palette_index", 3905245786)

    internal val setPaletteIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_palette_index", 1286410249)

    internal val getPaletteCustomColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "get_palette_custom_colors", 1392750486)

    internal val setPaletteCustomColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FontVariation", "set_palette_custom_colors", 3546319833)
  }
}
