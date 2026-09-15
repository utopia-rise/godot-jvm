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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A container that arranges its child controls horizontally or vertically and wraps them around at
 * the borders. This is similar to how text in a book wraps around when no more words can fit on a
 * line.
 */
@GodotBaseType
public open class FlowContainer : Container() {
  /**
   * The alignment of the container's children (must be one of [ALIGNMENT_BEGIN],
   * [ALIGNMENT_CENTER], or [ALIGNMENT_END]).
   */
  public final inline var alignment: AlignmentMode
    @JvmName("alignmentProperty")
    get() = getAlignment()
    @JvmName("alignmentProperty")
    set(`value`) {
      setAlignment(value)
    }

  /**
   * The wrap behavior of the last, partially filled row or column (must be one of
   * [LAST_WRAP_ALIGNMENT_INHERIT], [LAST_WRAP_ALIGNMENT_BEGIN], [LAST_WRAP_ALIGNMENT_CENTER], or
   * [LAST_WRAP_ALIGNMENT_END]).
   */
  public final inline var lastWrapAlignment: LastWrapAlignmentMode
    @JvmName("lastWrapAlignmentProperty")
    get() = getLastWrapAlignment()
    @JvmName("lastWrapAlignmentProperty")
    set(`value`) {
      setLastWrapAlignment(value)
    }

  /**
   * If `true`, the [FlowContainer] will arrange its children vertically, rather than horizontally.
   *
   * Can't be changed when using [HFlowContainer] and [VFlowContainer].
   */
  public final inline var vertical: Boolean
    @JvmName("verticalProperty")
    get() = isVertical()
    @JvmName("verticalProperty")
    set(`value`) {
      setVertical(value)
    }

  /**
   * If `true`, reverses fill direction. Horizontal [FlowContainer]s will fill rows bottom to top,
   * vertical [FlowContainer]s will fill columns right to left.
   *
   * When using a vertical [FlowContainer] with a right to left [Control.layoutDirection], columns
   * will fill left to right instead.
   */
  public final inline var reverseFill: Boolean
    @JvmName("reverseFillProperty")
    get() = isReverseFill()
    @JvmName("reverseFillProperty")
    set(`value`) {
      setReverseFill(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(226, scriptPtr)
  }

  /**
   * Returns the current line count.
   */
  public final fun getLineCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setAlignment(alignment: AlignmentMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to alignment.value)
    TransferContext.callMethod(MethodBindings.setAlignmentPtr)
  }

  public final fun getAlignment(): AlignmentMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlignmentPtr)
    return AlignmentMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLastWrapAlignment(lastWrapAlignment: LastWrapAlignmentMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to lastWrapAlignment.value)
    TransferContext.callMethod(MethodBindings.setLastWrapAlignmentPtr)
  }

  public final fun getLastWrapAlignment(): LastWrapAlignmentMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLastWrapAlignmentPtr)
    return LastWrapAlignmentMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVertical(vertical: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to vertical)
    TransferContext.callMethod(MethodBindings.setVerticalPtr)
  }

  public final fun isVertical(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVerticalPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setReverseFill(reverseFill: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to reverseFill)
    TransferContext.callMethod(MethodBindings.setReverseFillPtr)
  }

  public final fun isReverseFill(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isReverseFillPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class AlignmentMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The child controls will be arranged at the beginning of the container, i.e. top if
     * orientation is vertical, left if orientation is horizontal (right for RTL layout).
     */
    BEGIN(0),
    /**
     * The child controls will be centered in the container.
     */
    CENTER(1),
    /**
     * The child controls will be arranged at the end of the container, i.e. bottom if orientation
     * is vertical, right if orientation is horizontal (left for RTL layout).
     */
    END(2),
    ;

    public companion object {
      public fun from(`value`: Long): AlignmentMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LastWrapAlignmentMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The last partially filled row or column will wrap aligned to the previous row or column in
     * accordance with [alignment].
     */
    INHERIT(0),
    /**
     * The last partially filled row or column will wrap aligned to the beginning of the previous
     * row or column.
     */
    BEGIN(1),
    /**
     * The last partially filled row or column will wrap aligned to the center of the previous row
     * or column.
     */
    CENTER(2),
    /**
     * The last partially filled row or column will wrap aligned to the end of the previous row or
     * column.
     */
    END(3),
    ;

    public companion object {
      public fun from(`value`: Long): LastWrapAlignmentMode =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getLineCountName: MethodStringName0<FlowContainer, Int> =
        MethodStringName0<FlowContainer, Int>("get_line_count")

    @JvmField
    public val setAlignmentName: MethodStringName1<FlowContainer, Unit, AlignmentMode> =
        MethodStringName1<FlowContainer, Unit, AlignmentMode>("set_alignment")

    @JvmField
    public val getAlignmentName: MethodStringName0<FlowContainer, AlignmentMode> =
        MethodStringName0<FlowContainer, AlignmentMode>("get_alignment")

    @JvmField
    public val setLastWrapAlignmentName:
        MethodStringName1<FlowContainer, Unit, LastWrapAlignmentMode> =
        MethodStringName1<FlowContainer, Unit, LastWrapAlignmentMode>("set_last_wrap_alignment")

    @JvmField
    public val getLastWrapAlignmentName: MethodStringName0<FlowContainer, LastWrapAlignmentMode> =
        MethodStringName0<FlowContainer, LastWrapAlignmentMode>("get_last_wrap_alignment")

    @JvmField
    public val setVerticalName: MethodStringName1<FlowContainer, Unit, Boolean> =
        MethodStringName1<FlowContainer, Unit, Boolean>("set_vertical")

    @JvmField
    public val isVerticalName: MethodStringName0<FlowContainer, Boolean> =
        MethodStringName0<FlowContainer, Boolean>("is_vertical")

    @JvmField
    public val setReverseFillName: MethodStringName1<FlowContainer, Unit, Boolean> =
        MethodStringName1<FlowContainer, Unit, Boolean>("set_reverse_fill")

    @JvmField
    public val isReverseFillName: MethodStringName0<FlowContainer, Boolean> =
        MethodStringName0<FlowContainer, Boolean>("is_reverse_fill")
  }

  public object MethodBindings {
    internal val getLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "get_line_count", 3905245786)

    internal val setAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "set_alignment", 575250951)

    internal val getAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "get_alignment", 3749743559)

    internal val setLastWrapAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "set_last_wrap_alignment", 2899697495)

    internal val getLastWrapAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "get_last_wrap_alignment", 3743456014)

    internal val setVerticalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "set_vertical", 2586408642)

    internal val isVerticalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "is_vertical", 36873697)

    internal val setReverseFillPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "set_reverse_fill", 2586408642)

    internal val isReverseFillPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FlowContainer", "is_reverse_fill", 36873697)
  }
}
