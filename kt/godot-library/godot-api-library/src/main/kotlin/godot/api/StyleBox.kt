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
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.Rect2
import godot.core.Side
import godot.core.Vector2
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_OBJECT
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_RID_RECT2
import godot.writeMethodArguments_VECTOR2_RECT2
import kotlin.Boolean
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [StyleBox] is an abstract base class for drawing stylized boxes for UI elements. It is used for
 * panels, buttons, [LineEdit] backgrounds, [Tree] backgrounds, etc. and also for testing a
 * transparency mask for pointer signals. If mask test fails on a [StyleBox] assigned as mask to a
 * control, clicks and motion signals will go through it to the one below.
 *
 * **Note:** For control nodes that have *Theme Properties*, the `focus` [StyleBox] is displayed
 * over the `normal`, `hover` or `pressed` [StyleBox]. This makes the `focus` [StyleBox] more reusable
 * across different nodes.
 */
@GodotBaseType
public abstract class StyleBox : Resource() {
  /**
   * The left margin for the contents of this style box. Increasing this value reduces the space
   * available to the contents from the left.
   *
   * Refer to [contentMarginBottom] for extra considerations.
   */
  public final inline var contentMarginLeft: Float
    @JvmName("contentMarginLeftProperty")
    get() = getContentMargin(Side.LEFT)
    @JvmName("contentMarginLeftProperty")
    set(`value`) {
      setContentMargin(Side.LEFT, value)
    }

  /**
   * The top margin for the contents of this style box. Increasing this value reduces the space
   * available to the contents from the top.
   *
   * Refer to [contentMarginBottom] for extra considerations.
   */
  public final inline var contentMarginTop: Float
    @JvmName("contentMarginTopProperty")
    get() = getContentMargin(Side.TOP)
    @JvmName("contentMarginTopProperty")
    set(`value`) {
      setContentMargin(Side.TOP, value)
    }

  /**
   * The right margin for the contents of this style box. Increasing this value reduces the space
   * available to the contents from the right.
   *
   * Refer to [contentMarginBottom] for extra considerations.
   */
  public final inline var contentMarginRight: Float
    @JvmName("contentMarginRightProperty")
    get() = getContentMargin(Side.RIGHT)
    @JvmName("contentMarginRightProperty")
    set(`value`) {
      setContentMargin(Side.RIGHT, value)
    }

  /**
   * The bottom margin for the contents of this style box. Increasing this value reduces the space
   * available to the contents from the bottom.
   *
   * If this value is negative, it is ignored and a child-specific margin is used instead. For
   * example, for [StyleBoxFlat], the border thickness (if any) is used instead.
   *
   * It is up to the code using this style box to decide what these contents are: for example, a
   * [Button] respects this content margin for the textual contents of the button.
   *
   * [getMargin] should be used to fetch this value as consumer instead of reading these properties
   * directly. This is because it correctly respects negative values and the fallback mentioned above.
   */
  public final inline var contentMarginBottom: Float
    @JvmName("contentMarginBottomProperty")
    get() = getContentMargin(Side.BOTTOM)
    @JvmName("contentMarginBottomProperty")
    set(`value`) {
      setContentMargin(Side.BOTTOM, value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(715, scriptPtr)
  }

  public abstract fun _draw(toCanvasItem: RID, rect: Rect2): Unit

  public open fun _getDrawRect(rect: Rect2): Rect2 {
    throw NotImplementedError("StyleBox::_getDrawRect is not implemented.")
  }

  /**
   * Virtual method to be implemented by the user. Returns a custom minimum size that the stylebox
   * must respect when drawing. By default [getMinimumSize] only takes content margins into account.
   * This method can be overridden to add another size restriction. A combination of the default
   * behavior and the output of this method will be used, to account for both sizes.
   */
  public open fun _getMinimumSize(): Vector2 {
    throw NotImplementedError("StyleBox::_getMinimumSize is not implemented.")
  }

  public open fun _testMask(point: Vector2, rect: Rect2): Boolean {
    throw NotImplementedError("StyleBox::_testMask is not implemented.")
  }

  /**
   * Returns the minimum size that this stylebox can be shrunk to.
   */
  public final fun getMinimumSize(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinimumSizePtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Sets the default value of the specified [Side] to [offset] pixels.
   */
  public final fun setContentMargin(margin: Side, offset: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, margin.value, offset.toDouble())
    TransferContext.callMethod(MethodBindings.setContentMarginPtr)
  }

  /**
   * Sets the default margin to [offset] pixels for all sides.
   */
  public final fun setContentMarginAll(offset: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, offset.toDouble())
    TransferContext.callMethod(MethodBindings.setContentMarginAllPtr)
  }

  /**
   * Returns the default margin of the specified [Side].
   */
  public final fun getContentMargin(margin: Side): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, margin.value)
    TransferContext.callMethod(MethodBindings.getContentMarginPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the content margin offset for the specified [Side].
   *
   * Positive values reduce size inwards, unlike [Control]'s margin values.
   */
  public final fun getMargin(margin: Side): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, margin.value)
    TransferContext.callMethod(MethodBindings.getMarginPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the "offset" of a stylebox. This helper function returns a value equivalent to
   * `Vector2(style.get_margin(MARGIN_LEFT), style.get_margin(MARGIN_TOP))`.
   */
  public final fun getOffset(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetPtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Draws this stylebox using a canvas item identified by the given [RID].
   *
   * The [RID] value can either be the result of [CanvasItem.getCanvasItem] called on an existing
   * [CanvasItem]-derived node, or directly from creating a canvas item in the [RenderingServer] with
   * [RenderingServer.canvasItemCreate].
   */
  public final fun draw(canvasItem: RID, rect: Rect2): Unit {
    TransferContext.writeMethodArguments_RID_RECT2(ptr, objectID.id, canvasItem, rect)
    TransferContext.callMethod(MethodBindings.drawPtr)
  }

  /**
   * Returns the [CanvasItem] that handles its [CanvasItem.NOTIFICATION_DRAW] or [CanvasItem.Draw]
   * callback at this moment.
   */
  public final fun getCurrentItemDrawn(): CanvasItem? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentItemDrawnPtr)
    return (TransferContext.readReturnValue_OBJECT() as CanvasItem?)
  }

  /**
   * Test a position in a rectangle, return whether it passes the mask test.
   */
  public final fun testMask(point: Vector2, rect: Rect2): Boolean {
    TransferContext.writeMethodArguments_VECTOR2_RECT2(ptr, objectID.id, point, rect)
    TransferContext.callMethod(MethodBindings.testMaskPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val getMinimumSizeName: MethodStringName0<StyleBox, Vector2> =
        MethodStringName0<StyleBox, Vector2>("get_minimum_size")

    @JvmField
    public val setContentMarginName: MethodStringName2<StyleBox, Unit, Side, Float> =
        MethodStringName2<StyleBox, Unit, Side, Float>("set_content_margin")

    @JvmField
    public val setContentMarginAllName: MethodStringName1<StyleBox, Unit, Float> =
        MethodStringName1<StyleBox, Unit, Float>("set_content_margin_all")

    @JvmField
    public val getContentMarginName: MethodStringName1<StyleBox, Float, Side> =
        MethodStringName1<StyleBox, Float, Side>("get_content_margin")

    @JvmField
    public val getMarginName: MethodStringName1<StyleBox, Float, Side> =
        MethodStringName1<StyleBox, Float, Side>("get_margin")

    @JvmField
    public val getOffsetName: MethodStringName0<StyleBox, Vector2> =
        MethodStringName0<StyleBox, Vector2>("get_offset")

    @JvmField
    public val drawName: MethodStringName2<StyleBox, Unit, RID, Rect2> =
        MethodStringName2<StyleBox, Unit, RID, Rect2>("draw")

    @JvmField
    public val getCurrentItemDrawnName: MethodStringName0<StyleBox, CanvasItem?> =
        MethodStringName0<StyleBox, CanvasItem?>("get_current_item_drawn")

    @JvmField
    public val testMaskName: MethodStringName2<StyleBox, Boolean, Vector2, Rect2> =
        MethodStringName2<StyleBox, Boolean, Vector2, Rect2>("test_mask")
  }

  public object MethodBindings {
    internal val getMinimumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBox", "get_minimum_size", 3341600327)

    internal val setContentMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBox", "set_content_margin", 4290182280)

    internal val setContentMarginAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBox", "set_content_margin_all", 373806689)

    internal val getContentMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBox", "get_content_margin", 2869120046)

    internal val getMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBox", "get_margin", 2869120046)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBox", "get_offset", 3341600327)

    internal val drawPtr: VoidPtr = TypeManager.getMethodBindPtr("StyleBox", "draw", 2275962004)

    internal val getCurrentItemDrawnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBox", "get_current_item_drawn", 3213695180)

    internal val testMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StyleBox", "test_mask", 3735564539)
  }
}

internal class StyleBoxDummy : StyleBox() {
  public override fun _draw(toCanvasItem: RID, rect: Rect2): Unit {
    throw NotImplementedError("StyleBox::_draw is only implemented by non-JVM code.")
  }
}
