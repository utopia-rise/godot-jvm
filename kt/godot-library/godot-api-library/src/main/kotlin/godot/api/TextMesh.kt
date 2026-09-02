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
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.VerticalAlignment
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
import kotlin.jvm.JvmName

/**
 * Generate a [PrimitiveMesh] from the text.
 *
 * TextMesh can be generated only when using dynamic fonts with vector glyph contours. Bitmap fonts
 * (including bitmap data in the TrueType/OpenType containers, like color emoji fonts) are not
 * supported.
 *
 * The UV layout is arranged in 4 horizontal strips, top to bottom: 40&#37; of the height for the
 * front face, 40&#37; for the back face, 10&#37; for the outer edges and 10&#37; for the inner edges.
 */
@GodotBaseType
public open class TextMesh : PrimitiveMesh() {
  /**
   * The text to generate mesh from.
   *
   * **Note:** Due to being a [Resource], it doesn't follow the rules of [Node.autoTranslateMode].
   * If disabling translation is desired, it should be done manually with
   * [Object.setMessageTranslation].
   */
  public final inline var text: String
    @JvmName("textProperty")
    get() = getText()
    @JvmName("textProperty")
    set(`value`) {
      setText(value)
    }

  /**
   * Font configuration used to display text.
   */
  public final inline var font: Font?
    @JvmName("fontProperty")
    get() = getFont()
    @JvmName("fontProperty")
    set(`value`) {
      setFont(value)
    }

  /**
   * Font size of the [TextMesh]'s text. This property works in tandem with [pixelSize]. Higher
   * values will result in a more detailed font, regardless of [curveStep] and [pixelSize]. Consider
   * keeping this value below 63 (inclusive) for good performance, and adjust [pixelSize] as needed to
   * enlarge text.
   *
   * **Note:** Changing this property will regenerate the mesh, which is a slow operation,
   * especially with large font sizes and long texts. To change the text's size in real-time
   * efficiently, change the node's [Node3D.scale] instead.
   */
  public final inline var fontSize: Int
    @JvmName("fontSizeProperty")
    get() = getFontSize()
    @JvmName("fontSizeProperty")
    set(`value`) {
      setFontSize(value)
    }

  /**
   * Controls the text's horizontal alignment. Supports left, center, right, and fill (also known as
   * justify).
   */
  public final inline var horizontalAlignment: HorizontalAlignment
    @JvmName("horizontalAlignmentProperty")
    get() = getHorizontalAlignment()
    @JvmName("horizontalAlignmentProperty")
    set(`value`) {
      setHorizontalAlignment(value)
    }

  /**
   * Controls the text's vertical alignment. Supports top, center, and bottom.
   */
  public final inline var verticalAlignment: VerticalAlignment
    @JvmName("verticalAlignmentProperty")
    get() = getVerticalAlignment()
    @JvmName("verticalAlignmentProperty")
    set(`value`) {
      setVerticalAlignment(value)
    }

  /**
   * If `true`, all the text displays as UPPERCASE.
   */
  public final inline var uppercase: Boolean
    @JvmName("uppercaseProperty")
    get() = isUppercase()
    @JvmName("uppercaseProperty")
    set(`value`) {
      setUppercase(value)
    }

  /**
   * Additional vertical spacing between lines (in pixels), spacing is added to line descent. This
   * value can be negative.
   */
  public final inline var lineSpacing: Float
    @JvmName("lineSpacingProperty")
    get() = getLineSpacing()
    @JvmName("lineSpacingProperty")
    set(`value`) {
      setLineSpacing(value)
    }

  /**
   * If set to something other than [TextServer.AUTOWRAP_OFF], the text gets wrapped inside the
   * node's bounding rectangle. If you resize the node, it will change its height automatically to show
   * all the text.
   */
  public final inline var autowrapMode: TextServer.AutowrapMode
    @JvmName("autowrapModeProperty")
    get() = getAutowrapMode()
    @JvmName("autowrapModeProperty")
    set(`value`) {
      setAutowrapMode(value)
    }

  /**
   * Line fill alignment rules.
   */
  public final inline var justificationFlags: TextServer.JustificationFlag
    @JvmName("justificationFlagsProperty")
    get() = getJustificationFlags()
    @JvmName("justificationFlagsProperty")
    set(`value`) {
      setJustificationFlags(value)
    }

  /**
   * The size of one pixel's width on the text to scale it in 3D. This property works in tandem with
   * [fontSize].
   *
   * **Note:** Changing this property will regenerate the mesh, which is a slow operation,
   * especially with large font sizes and long texts. To change the text's size in real-time
   * efficiently, change the node's [Node3D.scale] instead.
   */
  public final inline var pixelSize: Float
    @JvmName("pixelSizeProperty")
    get() = getPixelSize()
    @JvmName("pixelSizeProperty")
    set(`value`) {
      setPixelSize(value)
    }

  /**
   * Step (in pixels) used to approximate Bézier curves. Lower values result in smoother curves, but
   * is slower to generate and render. Consider adjusting this according to the font size and the
   * typical viewing distance.
   *
   * **Note:** Changing this property will regenerate the mesh, which is a slow operation,
   * especially with large font sizes and long texts.
   */
  public final inline var curveStep: Float
    @JvmName("curveStepProperty")
    get() = getCurveStep()
    @JvmName("curveStepProperty")
    set(`value`) {
      setCurveStep(value)
    }

  /**
   * Depths of the mesh, if set to `0.0` only front surface, is generated, and UV layout is changed
   * to use full texture for the front face only.
   */
  public final inline var depth: Float
    @JvmName("depthProperty")
    get() = getDepth()
    @JvmName("depthProperty")
    set(`value`) {
      setDepth(value)
    }

  /**
   * Text width (in pixels), used for fill alignment.
   */
  public final inline var width: Float
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * The text drawing offset (in pixels).
   *
   * **Note:** Changing this property will regenerate the mesh, which is a slow operation. To change
   * the text's position in real-time efficiently, change the node's [Node3D.position] instead.
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
   * Base text writing direction.
   */
  public final inline var textDirection: TextServer.Direction
    @JvmName("textDirectionProperty")
    get() = getTextDirection()
    @JvmName("textDirectionProperty")
    set(`value`) {
      setTextDirection(value)
    }

  /**
   * Language code used for line-breaking and text shaping algorithms. If left empty, the current
   * locale is used instead.
   */
  public final inline var language: String
    @JvmName("languageProperty")
    get() = getLanguage()
    @JvmName("languageProperty")
    set(`value`) {
      setLanguage(value)
    }

  /**
   * Set BiDi algorithm override for the structured text.
   */
  public final inline var structuredTextBidiOverride: TextServer.StructuredTextParser
    @JvmName("structuredTextBidiOverrideProperty")
    get() = getStructuredTextBidiOverride()
    @JvmName("structuredTextBidiOverrideProperty")
    set(`value`) {
      setStructuredTextBidiOverride(value)
    }

  /**
   * Set additional options for BiDi override.
   */
  public final inline var structuredTextBidiOverrideOptions: VariantArray<Any?>
    @JvmName("structuredTextBidiOverrideOptionsProperty")
    get() = getStructuredTextBidiOverrideOptions()
    @JvmName("structuredTextBidiOverrideOptionsProperty")
    set(`value`) {
      setStructuredTextBidiOverrideOptions(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(732, scriptPtr)
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = textmesh.offset
   * //Your changes
   * textmesh.offset = myCoreType
   * ``````
   *
   * The text drawing offset (in pixels).
   *
   * **Note:** Changing this property will regenerate the mesh, which is a slow operation. To change
   * the text's position in real-time efficiently, change the node's [Node3D.position] instead.
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  public final fun setHorizontalAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to alignment.value)
    TransferContext.callMethod(MethodBindings.setHorizontalAlignmentPtr)
  }

  public final fun getHorizontalAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHorizontalAlignmentPtr)
    return HorizontalAlignment.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVerticalAlignment(alignment: VerticalAlignment): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to alignment.value)
    TransferContext.callMethod(MethodBindings.setVerticalAlignmentPtr)
  }

  public final fun getVerticalAlignment(): VerticalAlignment {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVerticalAlignmentPtr)
    return VerticalAlignment.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setText(text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text)
    TransferContext.callMethod(MethodBindings.setTextPtr)
  }

  public final fun getText(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setFont(font: Font?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font)
    TransferContext.callMethod(MethodBindings.setFontPtr)
  }

  public final fun getFont(): Font? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontPtr)
    return (TransferContext.readReturnValue(OBJECT) as Font?)
  }

  public final fun setFontSize(fontSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fontSize.toLong())
    TransferContext.callMethod(MethodBindings.setFontSizePtr)
  }

  public final fun getFontSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFontSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setLineSpacing(lineSpacing: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to lineSpacing.toDouble())
    TransferContext.callMethod(MethodBindings.setLineSpacingPtr)
  }

  public final fun getLineSpacing(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineSpacingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAutowrapMode(autowrapMode: TextServer.AutowrapMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to autowrapMode.value)
    TransferContext.callMethod(MethodBindings.setAutowrapModePtr)
  }

  public final fun getAutowrapMode(): TextServer.AutowrapMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutowrapModePtr)
    return TextServer.AutowrapMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setJustificationFlags(justificationFlags: TextServer.JustificationFlag): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to justificationFlags.flag)
    TransferContext.callMethod(MethodBindings.setJustificationFlagsPtr)
  }

  public final fun getJustificationFlags(): TextServer.JustificationFlag {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJustificationFlagsPtr)
    return TextServer.JustificationFlag(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDepth(depth: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to depth.toDouble())
    TransferContext.callMethod(MethodBindings.setDepthPtr)
  }

  public final fun getDepth(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDepthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setWidth(width: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to width.toDouble())
    TransferContext.callMethod(MethodBindings.setWidthPtr)
  }

  public final fun getWidth(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWidthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPixelSize(pixelSize: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pixelSize.toDouble())
    TransferContext.callMethod(MethodBindings.setPixelSizePtr)
  }

  public final fun getPixelSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPixelSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setOffsetPtr)
  }

  public final fun getOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setCurveStep(curveStep: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to curveStep.toDouble())
    TransferContext.callMethod(MethodBindings.setCurveStepPtr)
  }

  public final fun getCurveStep(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurveStepPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTextDirection(direction: TextServer.Direction): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setTextDirectionPtr)
  }

  public final fun getTextDirection(): TextServer.Direction {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextDirectionPtr)
    return TextServer.Direction.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLanguage(language: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to language)
    TransferContext.callMethod(MethodBindings.setLanguagePtr)
  }

  public final fun getLanguage(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setStructuredTextBidiOverride(parser: TextServer.StructuredTextParser): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to parser.value)
    TransferContext.callMethod(MethodBindings.setStructuredTextBidiOverridePtr)
  }

  public final fun getStructuredTextBidiOverride(): TextServer.StructuredTextParser {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStructuredTextBidiOverridePtr)
    return TextServer.StructuredTextParser.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setStructuredTextBidiOverrideOptions(args: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to args)
    TransferContext.callMethod(MethodBindings.setStructuredTextBidiOverrideOptionsPtr)
  }

  public final fun getStructuredTextBidiOverrideOptions(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStructuredTextBidiOverrideOptionsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  public final fun setUppercase(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUppercasePtr)
  }

  public final fun isUppercase(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUppercasePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setHorizontalAlignmentName: MethodStringName1<TextMesh, Unit, HorizontalAlignment> =
        MethodStringName1<TextMesh, Unit, HorizontalAlignment>("set_horizontal_alignment")

    @JvmField
    public val getHorizontalAlignmentName: MethodStringName0<TextMesh, HorizontalAlignment> =
        MethodStringName0<TextMesh, HorizontalAlignment>("get_horizontal_alignment")

    @JvmField
    public val setVerticalAlignmentName: MethodStringName1<TextMesh, Unit, VerticalAlignment> =
        MethodStringName1<TextMesh, Unit, VerticalAlignment>("set_vertical_alignment")

    @JvmField
    public val getVerticalAlignmentName: MethodStringName0<TextMesh, VerticalAlignment> =
        MethodStringName0<TextMesh, VerticalAlignment>("get_vertical_alignment")

    @JvmField
    public val setTextName: MethodStringName1<TextMesh, Unit, String> =
        MethodStringName1<TextMesh, Unit, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName0<TextMesh, String> =
        MethodStringName0<TextMesh, String>("get_text")

    @JvmField
    public val setFontName: MethodStringName1<TextMesh, Unit, Font?> =
        MethodStringName1<TextMesh, Unit, Font?>("set_font")

    @JvmField
    public val getFontName: MethodStringName0<TextMesh, Font?> =
        MethodStringName0<TextMesh, Font?>("get_font")

    @JvmField
    public val setFontSizeName: MethodStringName1<TextMesh, Unit, Int> =
        MethodStringName1<TextMesh, Unit, Int>("set_font_size")

    @JvmField
    public val getFontSizeName: MethodStringName0<TextMesh, Int> =
        MethodStringName0<TextMesh, Int>("get_font_size")

    @JvmField
    public val setLineSpacingName: MethodStringName1<TextMesh, Unit, Float> =
        MethodStringName1<TextMesh, Unit, Float>("set_line_spacing")

    @JvmField
    public val getLineSpacingName: MethodStringName0<TextMesh, Float> =
        MethodStringName0<TextMesh, Float>("get_line_spacing")

    @JvmField
    public val setAutowrapModeName: MethodStringName1<TextMesh, Unit, TextServer.AutowrapMode> =
        MethodStringName1<TextMesh, Unit, TextServer.AutowrapMode>("set_autowrap_mode")

    @JvmField
    public val getAutowrapModeName: MethodStringName0<TextMesh, TextServer.AutowrapMode> =
        MethodStringName0<TextMesh, TextServer.AutowrapMode>("get_autowrap_mode")

    @JvmField
    public val setJustificationFlagsName:
        MethodStringName1<TextMesh, Unit, TextServer.JustificationFlag> =
        MethodStringName1<TextMesh, Unit, TextServer.JustificationFlag>("set_justification_flags")

    @JvmField
    public val getJustificationFlagsName: MethodStringName0<TextMesh, TextServer.JustificationFlag>
        = MethodStringName0<TextMesh, TextServer.JustificationFlag>("get_justification_flags")

    @JvmField
    public val setDepthName: MethodStringName1<TextMesh, Unit, Float> =
        MethodStringName1<TextMesh, Unit, Float>("set_depth")

    @JvmField
    public val getDepthName: MethodStringName0<TextMesh, Float> =
        MethodStringName0<TextMesh, Float>("get_depth")

    @JvmField
    public val setWidthName: MethodStringName1<TextMesh, Unit, Float> =
        MethodStringName1<TextMesh, Unit, Float>("set_width")

    @JvmField
    public val getWidthName: MethodStringName0<TextMesh, Float> =
        MethodStringName0<TextMesh, Float>("get_width")

    @JvmField
    public val setPixelSizeName: MethodStringName1<TextMesh, Unit, Float> =
        MethodStringName1<TextMesh, Unit, Float>("set_pixel_size")

    @JvmField
    public val getPixelSizeName: MethodStringName0<TextMesh, Float> =
        MethodStringName0<TextMesh, Float>("get_pixel_size")

    @JvmField
    public val setOffsetName: MethodStringName1<TextMesh, Unit, Vector2> =
        MethodStringName1<TextMesh, Unit, Vector2>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<TextMesh, Vector2> =
        MethodStringName0<TextMesh, Vector2>("get_offset")

    @JvmField
    public val setCurveStepName: MethodStringName1<TextMesh, Unit, Float> =
        MethodStringName1<TextMesh, Unit, Float>("set_curve_step")

    @JvmField
    public val getCurveStepName: MethodStringName0<TextMesh, Float> =
        MethodStringName0<TextMesh, Float>("get_curve_step")

    @JvmField
    public val setTextDirectionName: MethodStringName1<TextMesh, Unit, TextServer.Direction> =
        MethodStringName1<TextMesh, Unit, TextServer.Direction>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<TextMesh, TextServer.Direction> =
        MethodStringName0<TextMesh, TextServer.Direction>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<TextMesh, Unit, String> =
        MethodStringName1<TextMesh, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<TextMesh, String> =
        MethodStringName0<TextMesh, String>("get_language")

    @JvmField
    public val setStructuredTextBidiOverrideName:
        MethodStringName1<TextMesh, Unit, TextServer.StructuredTextParser> =
        MethodStringName1<TextMesh, Unit, TextServer.StructuredTextParser>("set_structured_text_bidi_override")

    @JvmField
    public val getStructuredTextBidiOverrideName:
        MethodStringName0<TextMesh, TextServer.StructuredTextParser> =
        MethodStringName0<TextMesh, TextServer.StructuredTextParser>("get_structured_text_bidi_override")

    @JvmField
    public val setStructuredTextBidiOverrideOptionsName:
        MethodStringName1<TextMesh, Unit, VariantArray<Any?>> =
        MethodStringName1<TextMesh, Unit, VariantArray<Any?>>("set_structured_text_bidi_override_options")

    @JvmField
    public val getStructuredTextBidiOverrideOptionsName:
        MethodStringName0<TextMesh, VariantArray<Any?>> =
        MethodStringName0<TextMesh, VariantArray<Any?>>("get_structured_text_bidi_override_options")

    @JvmField
    public val setUppercaseName: MethodStringName1<TextMesh, Unit, Boolean> =
        MethodStringName1<TextMesh, Unit, Boolean>("set_uppercase")

    @JvmField
    public val isUppercaseName: MethodStringName0<TextMesh, Boolean> =
        MethodStringName0<TextMesh, Boolean>("is_uppercase")
  }

  public object MethodBindings {
    internal val setHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_horizontal_alignment", 2312603777)

    internal val getHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_horizontal_alignment", 341400642)

    internal val setVerticalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_vertical_alignment", 1796458609)

    internal val getVerticalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_vertical_alignment", 3274884059)

    internal val setTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_text", 83702148)

    internal val getTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_text", 201670096)

    internal val setFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_font", 1262170328)

    internal val getFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_font", 3229501585)

    internal val setFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_font_size", 1286410249)

    internal val getFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_font_size", 3905245786)

    internal val setLineSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_line_spacing", 373806689)

    internal val getLineSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_line_spacing", 1740695150)

    internal val setAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_autowrap_mode", 3289138044)

    internal val getAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_autowrap_mode", 1549071663)

    internal val setJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_justification_flags", 2877345813)

    internal val getJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_justification_flags", 1583363614)

    internal val setDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_depth", 373806689)

    internal val getDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_depth", 1740695150)

    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_width", 373806689)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_width", 1740695150)

    internal val setPixelSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_pixel_size", 373806689)

    internal val getPixelSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_pixel_size", 1740695150)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_offset", 743155724)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_offset", 3341600327)

    internal val setCurveStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_curve_step", 373806689)

    internal val getCurveStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_curve_step", 1740695150)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_text_direction", 1418190634)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_text_direction", 2516697328)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_language", 201670096)

    internal val setStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_structured_text_bidi_override", 55961453)

    internal val getStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_structured_text_bidi_override", 3385126229)

    internal val setStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_structured_text_bidi_override_options", 381264803)

    internal val getStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "get_structured_text_bidi_override_options", 3995934104)

    internal val setUppercasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "set_uppercase", 2586408642)

    internal val isUppercasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextMesh", "is_uppercase", 36873697)
  }
}
