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
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_COLOR
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_VECTOR2
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_COLOR
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_BOOL
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_VECTOR2
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.VerticalAlignment
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
 * A node for displaying plain text in 3D space. By adjusting various properties of this node, you
 * can configure things such as the text's appearance and whether it always faces the camera.
 */
@GodotBaseType
public open class Label3D : GeometryInstance3D() {
  /**
   * The size of one pixel's width on the label to scale it in 3D. To make the font look more
   * detailed when up close, increase [fontSize] while decreasing [pixelSize] at the same time.
   */
  public final inline var pixelSize: Float
    @JvmName("pixelSizeProperty")
    get() = getPixelSize()
    @JvmName("pixelSizeProperty")
    set(`value`) {
      setPixelSize(value)
    }

  /**
   * The text drawing offset (in pixels).
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
   * The billboard mode to use for the label.
   */
  public final inline var billboard: BaseMaterial3D.BillboardMode
    @JvmName("billboardProperty")
    get() = getBillboardMode()
    @JvmName("billboardProperty")
    set(`value`) {
      setBillboardMode(value)
    }

  /**
   * If `true`, the [Light3D] in the [Environment] has effects on the label.
   */
  public final inline var shaded: Boolean
    @JvmName("shadedProperty")
    get() = getDrawFlag(Label3D.DrawFlags.FLAG_SHADED)
    @JvmName("shadedProperty")
    set(`value`) {
      setDrawFlag(Label3D.DrawFlags.FLAG_SHADED, value)
    }

  /**
   * If `true`, text can be seen from the back as well, if `false`, it is invisible when looking at
   * it from behind.
   */
  public final inline var doubleSided: Boolean
    @JvmName("doubleSidedProperty")
    get() = getDrawFlag(Label3D.DrawFlags.FLAG_DOUBLE_SIDED)
    @JvmName("doubleSidedProperty")
    set(`value`) {
      setDrawFlag(Label3D.DrawFlags.FLAG_DOUBLE_SIDED, value)
    }

  /**
   * If `true`, depth testing is disabled and the object will be drawn in render order.
   */
  public final inline var noDepthTest: Boolean
    @JvmName("noDepthTestProperty")
    get() = getDrawFlag(Label3D.DrawFlags.FLAG_DISABLE_DEPTH_TEST)
    @JvmName("noDepthTestProperty")
    set(`value`) {
      setDrawFlag(Label3D.DrawFlags.FLAG_DISABLE_DEPTH_TEST, value)
    }

  /**
   * If `true`, the label is rendered at the same size regardless of distance. The label's size on
   * screen is the same as if the camera was `1.0` units away from the label's origin, regardless of
   * the actual distance from the camera. The [Camera3D]'s field of view (or [Camera3D.size] when in
   * orthogonal/frustum mode) still affects the size the label is drawn at.
   */
  public final inline var fixedSize: Boolean
    @JvmName("fixedSizeProperty")
    get() = getDrawFlag(Label3D.DrawFlags.FLAG_FIXED_SIZE)
    @JvmName("fixedSizeProperty")
    set(`value`) {
      setDrawFlag(Label3D.DrawFlags.FLAG_FIXED_SIZE, value)
    }

  /**
   * The alpha cutting mode to use for the sprite.
   */
  public final inline var alphaCut: AlphaCutMode
    @JvmName("alphaCutProperty")
    get() = getAlphaCutMode()
    @JvmName("alphaCutProperty")
    set(`value`) {
      setAlphaCutMode(value)
    }

  /**
   * Threshold at which the alpha scissor will discard values.
   */
  public final inline var alphaScissorThreshold: Float
    @JvmName("alphaScissorThresholdProperty")
    get() = getAlphaScissorThreshold()
    @JvmName("alphaScissorThresholdProperty")
    set(`value`) {
      setAlphaScissorThreshold(value)
    }

  /**
   * The hashing scale for Alpha Hash. Recommended values between `0` and `2`.
   */
  public final inline var alphaHashScale: Float
    @JvmName("alphaHashScaleProperty")
    get() = getAlphaHashScale()
    @JvmName("alphaHashScaleProperty")
    set(`value`) {
      setAlphaHashScale(value)
    }

  /**
   * The type of alpha antialiasing to apply.
   */
  public final inline var alphaAntialiasingMode: BaseMaterial3D.AlphaAntiAliasing
    @JvmName("alphaAntialiasingModeProperty")
    get() = getAlphaAntialiasing()
    @JvmName("alphaAntialiasingModeProperty")
    set(`value`) {
      setAlphaAntialiasing(value)
    }

  /**
   * Threshold at which antialiasing will be applied on the alpha channel.
   */
  public final inline var alphaAntialiasingEdge: Float
    @JvmName("alphaAntialiasingEdgeProperty")
    get() = getAlphaAntialiasingEdge()
    @JvmName("alphaAntialiasingEdgeProperty")
    set(`value`) {
      setAlphaAntialiasingEdge(value)
    }

  /**
   * Filter flags for the texture.
   */
  public final inline var textureFilter: BaseMaterial3D.TextureFilter
    @JvmName("textureFilterProperty")
    get() = getTextureFilter()
    @JvmName("textureFilterProperty")
    set(`value`) {
      setTextureFilter(value)
    }

  /**
   * Sets the render priority for the text. Higher priority objects will be sorted in front of lower
   * priority objects.
   *
   * **Note:** This only applies if [alphaCut] is set to [ALPHA_CUT_DISABLED] (default value).
   *
   * **Note:** This only applies to sorting of transparent objects. This will not impact how
   * transparent objects are sorted relative to opaque objects. This is because opaque objects are not
   * sorted, while transparent objects are sorted from back to front (subject to priority).
   */
  public final inline var renderPriority: Int
    @JvmName("renderPriorityProperty")
    get() = getRenderPriority()
    @JvmName("renderPriorityProperty")
    set(`value`) {
      setRenderPriority(value)
    }

  /**
   * Sets the render priority for the text outline. Higher priority objects will be sorted in front
   * of lower priority objects.
   *
   * **Note:** This only applies if [alphaCut] is set to [ALPHA_CUT_DISABLED] (default value).
   *
   * **Note:** This only applies to sorting of transparent objects. This will not impact how
   * transparent objects are sorted relative to opaque objects. This is because opaque objects are not
   * sorted, while transparent objects are sorted from back to front (subject to priority).
   */
  public final inline var outlineRenderPriority: Int
    @JvmName("outlineRenderPriorityProperty")
    get() = getOutlineRenderPriority()
    @JvmName("outlineRenderPriorityProperty")
    set(`value`) {
      setOutlineRenderPriority(value)
    }

  /**
   * Text [Color] of the [Label3D].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var modulate: Color
    @JvmName("modulateProperty")
    get() = getModulate()
    @JvmName("modulateProperty")
    set(`value`) {
      setModulate(value)
    }

  /**
   * The tint of text outline.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var outlineModulate: Color
    @JvmName("outlineModulateProperty")
    get() = getOutlineModulate()
    @JvmName("outlineModulateProperty")
    set(`value`) {
      setOutlineModulate(value)
    }

  /**
   * The text to display on screen.
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
   * Font size of the [Label3D]'s text. To make the font look more detailed when up close, increase
   * [fontSize] while decreasing [pixelSize] at the same time.
   *
   * Higher font sizes require more time to render new characters, which can cause stuttering during
   * gameplay.
   */
  public final inline var fontSize: Int
    @JvmName("fontSizeProperty")
    get() = getFontSize()
    @JvmName("fontSizeProperty")
    set(`value`) {
      setFontSize(value)
    }

  /**
   * Text outline size.
   */
  public final inline var outlineSize: Int
    @JvmName("outlineSizeProperty")
    get() = getOutlineSize()
    @JvmName("outlineSizeProperty")
    set(`value`) {
      setOutlineSize(value)
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
   * Autowrap space trimming flags. See [TextServer.BREAK_TRIM_START_EDGE_SPACES] and
   * [TextServer.BREAK_TRIM_END_EDGE_SPACES] for more info.
   */
  public final inline var autowrapTrimFlags: TextServer.LineBreakFlag
    @JvmName("autowrapTrimFlagsProperty")
    get() = getAutowrapTrimFlags()
    @JvmName("autowrapTrimFlagsProperty")
    set(`value`) {
      setAutowrapTrimFlags(value)
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
   * Text width (in pixels), used for autowrap and fill alignment.
   */
  public final inline var width: Float
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
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
    createNativeObject(349, scriptPtr)
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = label3d.offset
   * //Your changes
   * label3d.offset = myCoreType
   * ``````
   *
   * The text drawing offset (in pixels).
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  /**
   * This is a helper function for [modulate] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = label3d.modulate
   * //Your changes
   * label3d.modulate = myCoreType
   * ``````
   *
   * Text [Color] of the [Label3D].
   */
  @CoreTypeHelper
  public final fun modulateMutate(block: Color.() -> Unit): Color = modulate.apply {
     block(this)
     modulate = this
  }

  /**
   * This is a helper function for [outlineModulate] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = label3d.outlineModulate
   * //Your changes
   * label3d.outlineModulate = myCoreType
   * ``````
   *
   * The tint of text outline.
   */
  @CoreTypeHelper
  public final fun outlineModulateMutate(block: Color.() -> Unit): Color = outlineModulate.apply {
     block(this)
     outlineModulate = this
  }

  public final fun setHorizontalAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setHorizontalAlignmentPtr, alignment.value)
  }

  public final fun getHorizontalAlignment(): HorizontalAlignment =
      HorizontalAlignment.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getHorizontalAlignmentPtr))

  public final fun setVerticalAlignment(alignment: VerticalAlignment): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVerticalAlignmentPtr, alignment.value)
  }

  public final fun getVerticalAlignment(): VerticalAlignment =
      VerticalAlignment.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVerticalAlignmentPtr))

  public final fun setModulate(modulate: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.setModulatePtr, modulate)
  }

  public final fun getModulate(): Color =
      TransferContext.callPtrMethod0_ret_COLOR(ptr, objectID.id, MethodBindings.getModulatePtr)

  public final fun setOutlineModulate(modulate: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.setOutlineModulatePtr, modulate)
  }

  public final fun getOutlineModulate(): Color =
      TransferContext.callPtrMethod0_ret_COLOR(ptr, objectID.id, MethodBindings.getOutlineModulatePtr)

  public final fun setText(text: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setTextPtr, text)
  }

  public final fun getText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getTextPtr)

  public final fun setTextDirection(direction: TextServer.Direction): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTextDirectionPtr, direction.value)
  }

  public final fun getTextDirection(): TextServer.Direction =
      TextServer.Direction.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTextDirectionPtr))

  public final fun setLanguage(language: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setLanguagePtr, language)
  }

  public final fun getLanguage(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getLanguagePtr)

  public final fun setStructuredTextBidiOverride(parser: TextServer.StructuredTextParser): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setStructuredTextBidiOverridePtr, parser.value)
  }

  public final fun getStructuredTextBidiOverride(): TextServer.StructuredTextParser =
      TextServer.StructuredTextParser.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getStructuredTextBidiOverridePtr))

  public final fun setStructuredTextBidiOverrideOptions(args: VariantArray<Any?>): Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.setStructuredTextBidiOverrideOptionsPtr, args)
  }

  public final fun getStructuredTextBidiOverrideOptions(): VariantArray<Any?> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getStructuredTextBidiOverrideOptionsPtr) as VariantArray<Any?>)

  public final fun setUppercase(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setUppercasePtr, enable)
  }

  public final fun isUppercase(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isUppercasePtr)

  public final fun setRenderPriority(priority: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setRenderPriorityPtr, priority.toLong())
  }

  public final fun getRenderPriority(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getRenderPriorityPtr).toInt()

  public final fun setOutlineRenderPriority(priority: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOutlineRenderPriorityPtr, priority.toLong())
  }

  public final fun getOutlineRenderPriority(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOutlineRenderPriorityPtr).toInt()

  public final fun setFont(font: Font?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setFontPtr, font)
  }

  public final fun getFont(): Font? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getFontPtr) as Font?)

  public final fun setFontSize(size: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFontSizePtr, size.toLong())
  }

  public final fun getFontSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFontSizePtr).toInt()

  public final fun setOutlineSize(outlineSize: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOutlineSizePtr, outlineSize.toLong())
  }

  public final fun getOutlineSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOutlineSizePtr).toInt()

  public final fun setLineSpacing(lineSpacing: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setLineSpacingPtr, lineSpacing.toDouble())
  }

  public final fun getLineSpacing(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLineSpacingPtr).toFloat()

  public final fun setAutowrapMode(autowrapMode: TextServer.AutowrapMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAutowrapModePtr, autowrapMode.value)
  }

  public final fun getAutowrapMode(): TextServer.AutowrapMode =
      TextServer.AutowrapMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAutowrapModePtr))

  public final fun setAutowrapTrimFlags(autowrapTrimFlags: TextServer.LineBreakFlag): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAutowrapTrimFlagsPtr, autowrapTrimFlags.flag)
  }

  public final fun getAutowrapTrimFlags(): TextServer.LineBreakFlag =
      TextServer.LineBreakFlag(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAutowrapTrimFlagsPtr))

  public final fun setJustificationFlags(justificationFlags: TextServer.JustificationFlag): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setJustificationFlagsPtr, justificationFlags.flag)
  }

  public final fun getJustificationFlags(): TextServer.JustificationFlag =
      TextServer.JustificationFlag(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getJustificationFlagsPtr))

  public final fun setWidth(width: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setWidthPtr, width.toDouble())
  }

  public final fun getWidth(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getWidthPtr).toFloat()

  public final fun setPixelSize(pixelSize: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setPixelSizePtr, pixelSize.toDouble())
  }

  public final fun getPixelSize(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getPixelSizePtr).toFloat()

  public final fun setOffset(offset: Vector2): Unit {
    TransferContext.callPtrMethod_VECTOR2(ptr, objectID.id, MethodBindings.setOffsetPtr, offset)
  }

  public final fun getOffset(): Vector2 =
      TransferContext.callPtrMethod0_ret_VECTOR2(ptr, objectID.id, MethodBindings.getOffsetPtr)

  /**
   * If `true`, the specified [flag] will be enabled.
   */
  public final fun setDrawFlag(flag: DrawFlags, enabled: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setDrawFlagPtr, flag.value, enabled)
  }

  /**
   * Returns the value of the specified flag.
   */
  public final fun getDrawFlag(flag: DrawFlags): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.getDrawFlagPtr, flag.value)

  public final fun setBillboardMode(mode: BaseMaterial3D.BillboardMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBillboardModePtr, mode.value)
  }

  public final fun getBillboardMode(): BaseMaterial3D.BillboardMode =
      BaseMaterial3D.BillboardMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBillboardModePtr))

  public final fun setAlphaCutMode(mode: AlphaCutMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAlphaCutModePtr, mode.value)
  }

  public final fun getAlphaCutMode(): AlphaCutMode =
      AlphaCutMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAlphaCutModePtr))

  public final fun setAlphaScissorThreshold(threshold: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAlphaScissorThresholdPtr, threshold.toDouble())
  }

  public final fun getAlphaScissorThreshold(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAlphaScissorThresholdPtr).toFloat()

  public final fun setAlphaHashScale(threshold: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAlphaHashScalePtr, threshold.toDouble())
  }

  public final fun getAlphaHashScale(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAlphaHashScalePtr).toFloat()

  public final fun setAlphaAntialiasing(alphaAa: BaseMaterial3D.AlphaAntiAliasing): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAlphaAntialiasingPtr, alphaAa.value)
  }

  public final fun getAlphaAntialiasing(): BaseMaterial3D.AlphaAntiAliasing =
      BaseMaterial3D.AlphaAntiAliasing.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAlphaAntialiasingPtr))

  public final fun setAlphaAntialiasingEdge(edge: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAlphaAntialiasingEdgePtr, edge.toDouble())
  }

  public final fun getAlphaAntialiasingEdge(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAlphaAntialiasingEdgePtr).toFloat()

  public final fun setTextureFilter(mode: BaseMaterial3D.TextureFilter): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTextureFilterPtr, mode.value)
  }

  public final fun getTextureFilter(): BaseMaterial3D.TextureFilter =
      BaseMaterial3D.TextureFilter.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTextureFilterPtr))

  /**
   * Returns a [TriangleMesh] with the label's vertices following its current configuration (such as
   * its [pixelSize]).
   */
  public final fun generateTriangleMesh(): TriangleMesh? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.generateTriangleMeshPtr) as TriangleMesh?)

  public enum class DrawFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If set, lights in the environment affect the label.
     */
    FLAG_SHADED(0),
    /**
     * If set, text can be seen from the back as well. If not, the text is invisible when looking at
     * it from behind.
     */
    FLAG_DOUBLE_SIDED(1),
    /**
     * Disables the depth test, so this object is drawn on top of all others. However, objects drawn
     * after it in the draw order may cover it.
     */
    FLAG_DISABLE_DEPTH_TEST(2),
    /**
     * Label is scaled by depth so that it always appears the same size on screen.
     */
    FLAG_FIXED_SIZE(3),
    /**
     * Represents the size of the [DrawFlags] enum.
     */
    FLAG_MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): DrawFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class AlphaCutMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This mode performs standard alpha blending. It can display translucent areas, but
     * transparency sorting issues may be visible when multiple transparent materials are overlapping.
     * [GeometryInstance3D.castShadow] has no effect when this transparency mode is used; the [Label3D]
     * will never cast shadows.
     */
    DISABLED(0),
    /**
     * This mode only allows fully transparent or fully opaque pixels. Harsh edges will be visible
     * unless some form of screen-space antialiasing is enabled (see
     * [ProjectSettings.rendering/antiAliasing/quality/screenSpaceAa]). This mode is also known as
     * *alpha testing* or *1-bit transparency*.
     *
     * **Note:** This mode might have issues with anti-aliased fonts and outlines, try adjusting
     * [alphaScissorThreshold] or using MSDF font.
     *
     * **Note:** When using text with overlapping glyphs (e.g., cursive scripts), this mode might
     * have transparency sorting issues between the main text and the outline.
     */
    DISCARD(1),
    /**
     * This mode draws fully opaque pixels in the depth prepass. This is slower than
     * [ALPHA_CUT_DISABLED] or [ALPHA_CUT_DISCARD], but it allows displaying translucent areas and
     * smooth edges while using proper sorting.
     *
     * **Note:** When using text with overlapping glyphs (e.g., cursive scripts), this mode might
     * have transparency sorting issues between the main text and the outline.
     */
    OPAQUE_PREPASS(2),
    /**
     * This mode draws cuts off all values below a spatially-deterministic threshold, the rest will
     * remain opaque.
     */
    HASH(3),
    ;

    public companion object {
      public fun from(`value`: Long): AlphaCutMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setHorizontalAlignmentName: MethodStringName1<Label3D, Unit, HorizontalAlignment> =
        MethodStringName1<Label3D, Unit, HorizontalAlignment>("set_horizontal_alignment")

    @JvmField
    public val getHorizontalAlignmentName: MethodStringName0<Label3D, HorizontalAlignment> =
        MethodStringName0<Label3D, HorizontalAlignment>("get_horizontal_alignment")

    @JvmField
    public val setVerticalAlignmentName: MethodStringName1<Label3D, Unit, VerticalAlignment> =
        MethodStringName1<Label3D, Unit, VerticalAlignment>("set_vertical_alignment")

    @JvmField
    public val getVerticalAlignmentName: MethodStringName0<Label3D, VerticalAlignment> =
        MethodStringName0<Label3D, VerticalAlignment>("get_vertical_alignment")

    @JvmField
    public val setModulateName: MethodStringName1<Label3D, Unit, Color> =
        MethodStringName1<Label3D, Unit, Color>("set_modulate")

    @JvmField
    public val getModulateName: MethodStringName0<Label3D, Color> =
        MethodStringName0<Label3D, Color>("get_modulate")

    @JvmField
    public val setOutlineModulateName: MethodStringName1<Label3D, Unit, Color> =
        MethodStringName1<Label3D, Unit, Color>("set_outline_modulate")

    @JvmField
    public val getOutlineModulateName: MethodStringName0<Label3D, Color> =
        MethodStringName0<Label3D, Color>("get_outline_modulate")

    @JvmField
    public val setTextName: MethodStringName1<Label3D, Unit, String> =
        MethodStringName1<Label3D, Unit, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName0<Label3D, String> =
        MethodStringName0<Label3D, String>("get_text")

    @JvmField
    public val setTextDirectionName: MethodStringName1<Label3D, Unit, TextServer.Direction> =
        MethodStringName1<Label3D, Unit, TextServer.Direction>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<Label3D, TextServer.Direction> =
        MethodStringName0<Label3D, TextServer.Direction>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<Label3D, Unit, String> =
        MethodStringName1<Label3D, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<Label3D, String> =
        MethodStringName0<Label3D, String>("get_language")

    @JvmField
    public val setStructuredTextBidiOverrideName:
        MethodStringName1<Label3D, Unit, TextServer.StructuredTextParser> =
        MethodStringName1<Label3D, Unit, TextServer.StructuredTextParser>("set_structured_text_bidi_override")

    @JvmField
    public val getStructuredTextBidiOverrideName:
        MethodStringName0<Label3D, TextServer.StructuredTextParser> =
        MethodStringName0<Label3D, TextServer.StructuredTextParser>("get_structured_text_bidi_override")

    @JvmField
    public val setStructuredTextBidiOverrideOptionsName:
        MethodStringName1<Label3D, Unit, VariantArray<Any?>> =
        MethodStringName1<Label3D, Unit, VariantArray<Any?>>("set_structured_text_bidi_override_options")

    @JvmField
    public val getStructuredTextBidiOverrideOptionsName:
        MethodStringName0<Label3D, VariantArray<Any?>> =
        MethodStringName0<Label3D, VariantArray<Any?>>("get_structured_text_bidi_override_options")

    @JvmField
    public val setUppercaseName: MethodStringName1<Label3D, Unit, Boolean> =
        MethodStringName1<Label3D, Unit, Boolean>("set_uppercase")

    @JvmField
    public val isUppercaseName: MethodStringName0<Label3D, Boolean> =
        MethodStringName0<Label3D, Boolean>("is_uppercase")

    @JvmField
    public val setRenderPriorityName: MethodStringName1<Label3D, Unit, Int> =
        MethodStringName1<Label3D, Unit, Int>("set_render_priority")

    @JvmField
    public val getRenderPriorityName: MethodStringName0<Label3D, Int> =
        MethodStringName0<Label3D, Int>("get_render_priority")

    @JvmField
    public val setOutlineRenderPriorityName: MethodStringName1<Label3D, Unit, Int> =
        MethodStringName1<Label3D, Unit, Int>("set_outline_render_priority")

    @JvmField
    public val getOutlineRenderPriorityName: MethodStringName0<Label3D, Int> =
        MethodStringName0<Label3D, Int>("get_outline_render_priority")

    @JvmField
    public val setFontName: MethodStringName1<Label3D, Unit, Font?> =
        MethodStringName1<Label3D, Unit, Font?>("set_font")

    @JvmField
    public val getFontName: MethodStringName0<Label3D, Font?> =
        MethodStringName0<Label3D, Font?>("get_font")

    @JvmField
    public val setFontSizeName: MethodStringName1<Label3D, Unit, Int> =
        MethodStringName1<Label3D, Unit, Int>("set_font_size")

    @JvmField
    public val getFontSizeName: MethodStringName0<Label3D, Int> =
        MethodStringName0<Label3D, Int>("get_font_size")

    @JvmField
    public val setOutlineSizeName: MethodStringName1<Label3D, Unit, Int> =
        MethodStringName1<Label3D, Unit, Int>("set_outline_size")

    @JvmField
    public val getOutlineSizeName: MethodStringName0<Label3D, Int> =
        MethodStringName0<Label3D, Int>("get_outline_size")

    @JvmField
    public val setLineSpacingName: MethodStringName1<Label3D, Unit, Float> =
        MethodStringName1<Label3D, Unit, Float>("set_line_spacing")

    @JvmField
    public val getLineSpacingName: MethodStringName0<Label3D, Float> =
        MethodStringName0<Label3D, Float>("get_line_spacing")

    @JvmField
    public val setAutowrapModeName: MethodStringName1<Label3D, Unit, TextServer.AutowrapMode> =
        MethodStringName1<Label3D, Unit, TextServer.AutowrapMode>("set_autowrap_mode")

    @JvmField
    public val getAutowrapModeName: MethodStringName0<Label3D, TextServer.AutowrapMode> =
        MethodStringName0<Label3D, TextServer.AutowrapMode>("get_autowrap_mode")

    @JvmField
    public val setAutowrapTrimFlagsName: MethodStringName1<Label3D, Unit, TextServer.LineBreakFlag>
        = MethodStringName1<Label3D, Unit, TextServer.LineBreakFlag>("set_autowrap_trim_flags")

    @JvmField
    public val getAutowrapTrimFlagsName: MethodStringName0<Label3D, TextServer.LineBreakFlag> =
        MethodStringName0<Label3D, TextServer.LineBreakFlag>("get_autowrap_trim_flags")

    @JvmField
    public val setJustificationFlagsName:
        MethodStringName1<Label3D, Unit, TextServer.JustificationFlag> =
        MethodStringName1<Label3D, Unit, TextServer.JustificationFlag>("set_justification_flags")

    @JvmField
    public val getJustificationFlagsName: MethodStringName0<Label3D, TextServer.JustificationFlag> =
        MethodStringName0<Label3D, TextServer.JustificationFlag>("get_justification_flags")

    @JvmField
    public val setWidthName: MethodStringName1<Label3D, Unit, Float> =
        MethodStringName1<Label3D, Unit, Float>("set_width")

    @JvmField
    public val getWidthName: MethodStringName0<Label3D, Float> =
        MethodStringName0<Label3D, Float>("get_width")

    @JvmField
    public val setPixelSizeName: MethodStringName1<Label3D, Unit, Float> =
        MethodStringName1<Label3D, Unit, Float>("set_pixel_size")

    @JvmField
    public val getPixelSizeName: MethodStringName0<Label3D, Float> =
        MethodStringName0<Label3D, Float>("get_pixel_size")

    @JvmField
    public val setOffsetName: MethodStringName1<Label3D, Unit, Vector2> =
        MethodStringName1<Label3D, Unit, Vector2>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<Label3D, Vector2> =
        MethodStringName0<Label3D, Vector2>("get_offset")

    @JvmField
    public val setDrawFlagName: MethodStringName2<Label3D, Unit, DrawFlags, Boolean> =
        MethodStringName2<Label3D, Unit, DrawFlags, Boolean>("set_draw_flag")

    @JvmField
    public val getDrawFlagName: MethodStringName1<Label3D, Boolean, DrawFlags> =
        MethodStringName1<Label3D, Boolean, DrawFlags>("get_draw_flag")

    @JvmField
    public val setBillboardModeName: MethodStringName1<Label3D, Unit, BaseMaterial3D.BillboardMode>
        = MethodStringName1<Label3D, Unit, BaseMaterial3D.BillboardMode>("set_billboard_mode")

    @JvmField
    public val getBillboardModeName: MethodStringName0<Label3D, BaseMaterial3D.BillboardMode> =
        MethodStringName0<Label3D, BaseMaterial3D.BillboardMode>("get_billboard_mode")

    @JvmField
    public val setAlphaCutModeName: MethodStringName1<Label3D, Unit, AlphaCutMode> =
        MethodStringName1<Label3D, Unit, AlphaCutMode>("set_alpha_cut_mode")

    @JvmField
    public val getAlphaCutModeName: MethodStringName0<Label3D, AlphaCutMode> =
        MethodStringName0<Label3D, AlphaCutMode>("get_alpha_cut_mode")

    @JvmField
    public val setAlphaScissorThresholdName: MethodStringName1<Label3D, Unit, Float> =
        MethodStringName1<Label3D, Unit, Float>("set_alpha_scissor_threshold")

    @JvmField
    public val getAlphaScissorThresholdName: MethodStringName0<Label3D, Float> =
        MethodStringName0<Label3D, Float>("get_alpha_scissor_threshold")

    @JvmField
    public val setAlphaHashScaleName: MethodStringName1<Label3D, Unit, Float> =
        MethodStringName1<Label3D, Unit, Float>("set_alpha_hash_scale")

    @JvmField
    public val getAlphaHashScaleName: MethodStringName0<Label3D, Float> =
        MethodStringName0<Label3D, Float>("get_alpha_hash_scale")

    @JvmField
    public val setAlphaAntialiasingName:
        MethodStringName1<Label3D, Unit, BaseMaterial3D.AlphaAntiAliasing> =
        MethodStringName1<Label3D, Unit, BaseMaterial3D.AlphaAntiAliasing>("set_alpha_antialiasing")

    @JvmField
    public val getAlphaAntialiasingName:
        MethodStringName0<Label3D, BaseMaterial3D.AlphaAntiAliasing> =
        MethodStringName0<Label3D, BaseMaterial3D.AlphaAntiAliasing>("get_alpha_antialiasing")

    @JvmField
    public val setAlphaAntialiasingEdgeName: MethodStringName1<Label3D, Unit, Float> =
        MethodStringName1<Label3D, Unit, Float>("set_alpha_antialiasing_edge")

    @JvmField
    public val getAlphaAntialiasingEdgeName: MethodStringName0<Label3D, Float> =
        MethodStringName0<Label3D, Float>("get_alpha_antialiasing_edge")

    @JvmField
    public val setTextureFilterName: MethodStringName1<Label3D, Unit, BaseMaterial3D.TextureFilter>
        = MethodStringName1<Label3D, Unit, BaseMaterial3D.TextureFilter>("set_texture_filter")

    @JvmField
    public val getTextureFilterName: MethodStringName0<Label3D, BaseMaterial3D.TextureFilter> =
        MethodStringName0<Label3D, BaseMaterial3D.TextureFilter>("get_texture_filter")

    @JvmField
    public val generateTriangleMeshName: MethodStringName0<Label3D, TriangleMesh?> =
        MethodStringName0<Label3D, TriangleMesh?>("generate_triangle_mesh")
  }

  public object MethodBindings {
    internal val setHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_horizontal_alignment", 2312603777)

    internal val getHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_horizontal_alignment", 341400642)

    internal val setVerticalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_vertical_alignment", 1796458609)

    internal val getVerticalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_vertical_alignment", 3274884059)

    internal val setModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_modulate", 2920490490)

    internal val getModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_modulate", 3444240500)

    internal val setOutlineModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_outline_modulate", 2920490490)

    internal val getOutlineModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_outline_modulate", 3444240500)

    internal val setTextPtr: VoidPtr = TypeManager.getMethodBindPtr("Label3D", "set_text", 83702148)

    internal val getTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_text", 201670096)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_text_direction", 1418190634)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_text_direction", 2516697328)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_language", 201670096)

    internal val setStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_structured_text_bidi_override", 55961453)

    internal val getStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_structured_text_bidi_override", 3385126229)

    internal val setStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_structured_text_bidi_override_options", 381264803)

    internal val getStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_structured_text_bidi_override_options", 3995934104)

    internal val setUppercasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_uppercase", 2586408642)

    internal val isUppercasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "is_uppercase", 36873697)

    internal val setRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_render_priority", 1286410249)

    internal val getRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_render_priority", 3905245786)

    internal val setOutlineRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_outline_render_priority", 1286410249)

    internal val getOutlineRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_outline_render_priority", 3905245786)

    internal val setFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_font", 1262170328)

    internal val getFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_font", 3229501585)

    internal val setFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_font_size", 1286410249)

    internal val getFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_font_size", 3905245786)

    internal val setOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_outline_size", 1286410249)

    internal val getOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_outline_size", 3905245786)

    internal val setLineSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_line_spacing", 373806689)

    internal val getLineSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_line_spacing", 1740695150)

    internal val setAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_autowrap_mode", 3289138044)

    internal val getAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_autowrap_mode", 1549071663)

    internal val setAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_autowrap_trim_flags", 2809697122)

    internal val getAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_autowrap_trim_flags", 2340632602)

    internal val setJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_justification_flags", 2877345813)

    internal val getJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_justification_flags", 1583363614)

    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_width", 373806689)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_width", 1740695150)

    internal val setPixelSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_pixel_size", 373806689)

    internal val getPixelSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_pixel_size", 1740695150)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_offset", 743155724)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_offset", 3341600327)

    internal val setDrawFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_draw_flag", 1285833066)

    internal val getDrawFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_draw_flag", 259226453)

    internal val setBillboardModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_billboard_mode", 4202036497)

    internal val getBillboardModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_billboard_mode", 1283840139)

    internal val setAlphaCutModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_alpha_cut_mode", 2549142916)

    internal val getAlphaCutModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_alpha_cut_mode", 219468601)

    internal val setAlphaScissorThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_alpha_scissor_threshold", 373806689)

    internal val getAlphaScissorThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_alpha_scissor_threshold", 1740695150)

    internal val setAlphaHashScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_alpha_hash_scale", 373806689)

    internal val getAlphaHashScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_alpha_hash_scale", 1740695150)

    internal val setAlphaAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_alpha_antialiasing", 3212649852)

    internal val getAlphaAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_alpha_antialiasing", 2889939400)

    internal val setAlphaAntialiasingEdgePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_alpha_antialiasing_edge", 373806689)

    internal val getAlphaAntialiasingEdgePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_alpha_antialiasing_edge", 1740695150)

    internal val setTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "set_texture_filter", 22904437)

    internal val getTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "get_texture_filter", 3289213076)

    internal val generateTriangleMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label3D", "generate_triangle_mesh", 3476533166)
  }
}
