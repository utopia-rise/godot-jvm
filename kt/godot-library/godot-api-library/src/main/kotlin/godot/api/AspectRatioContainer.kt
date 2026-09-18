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
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A container type that arranges its child controls in a way that preserves their proportions
 * automatically when the container is resized. Useful when a container has a dynamic size and the
 * child nodes must adjust their sizes accordingly without losing their aspect ratios.
 */
@GodotBaseType
public open class AspectRatioContainer : Container() {
  /**
   * The aspect ratio to enforce on child controls. This is the width divided by the height. The
   * ratio depends on the [stretchMode].
   */
  public final inline var ratio: Float
    @JvmName("ratioProperty")
    get() = getRatio()
    @JvmName("ratioProperty")
    set(`value`) {
      setRatio(value)
    }

  /**
   * The stretch mode used to align child controls.
   */
  public final inline var stretchMode: StretchMode
    @JvmName("stretchModeProperty")
    get() = getStretchMode()
    @JvmName("stretchModeProperty")
    set(`value`) {
      setStretchMode(value)
    }

  /**
   * Specifies the horizontal relative position of child controls.
   */
  public final inline var alignmentHorizontal: AlignmentMode
    @JvmName("alignmentHorizontalProperty")
    get() = getAlignmentHorizontal()
    @JvmName("alignmentHorizontalProperty")
    set(`value`) {
      setAlignmentHorizontal(value)
    }

  /**
   * Specifies the vertical relative position of child controls.
   */
  public final inline var alignmentVertical: AlignmentMode
    @JvmName("alignmentVerticalProperty")
    get() = getAlignmentVertical()
    @JvmName("alignmentVerticalProperty")
    set(`value`) {
      setAlignmentVertical(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(43, scriptPtr)
  }

  public final fun setRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, ratio.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRatioPtr, 0)
  }

  public final fun getRatio(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRatioPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setStretchMode(stretchMode: StretchMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, stretchMode.value)
    TransferContext.callPtrMethod(MethodBindings.setStretchModePtr, 0)
  }

  public final fun getStretchMode(): StretchMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStretchModePtr, 2)
    return StretchMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAlignmentHorizontal(alignmentHorizontal: AlignmentMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignmentHorizontal.value)
    TransferContext.callPtrMethod(MethodBindings.setAlignmentHorizontalPtr, 0)
  }

  public final fun getAlignmentHorizontal(): AlignmentMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAlignmentHorizontalPtr, 2)
    return AlignmentMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAlignmentVertical(alignmentVertical: AlignmentMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignmentVertical.value)
    TransferContext.callPtrMethod(MethodBindings.setAlignmentVerticalPtr, 0)
  }

  public final fun getAlignmentVertical(): AlignmentMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAlignmentVerticalPtr, 2)
    return AlignmentMode.from(TransferContext.readReturnValue_LONG())
  }

  public enum class StretchMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The height of child controls is automatically adjusted based on the width of the container.
     */
    WIDTH_CONTROLS_HEIGHT(0),
    /**
     * The width of child controls is automatically adjusted based on the height of the container.
     */
    HEIGHT_CONTROLS_WIDTH(1),
    /**
     * The bounding rectangle of child controls is automatically adjusted to fit inside the
     * container while keeping the aspect ratio.
     */
    FIT(2),
    /**
     * The width and height of child controls is automatically adjusted to make their bounding
     * rectangle cover the entire area of the container while keeping the aspect ratio.
     *
     * When the bounding rectangle of child controls exceed the container's size and
     * [Control.clipContents] is enabled, this allows to show only the container's area restricted by
     * its own bounding rectangle.
     */
    COVER(3),
    ;

    public companion object {
      public fun from(`value`: Long): StretchMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class AlignmentMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Aligns child controls with the beginning (left or top) of the container.
     */
    BEGIN(0),
    /**
     * Aligns child controls with the center of the container.
     */
    CENTER(1),
    /**
     * Aligns child controls with the end (right or bottom) of the container.
     */
    END(2),
    ;

    public companion object {
      public fun from(`value`: Long): AlignmentMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setRatioName: MethodStringName1<AspectRatioContainer, Unit, Float> =
        MethodStringName1<AspectRatioContainer, Unit, Float>("set_ratio")

    @JvmField
    public val getRatioName: MethodStringName0<AspectRatioContainer, Float> =
        MethodStringName0<AspectRatioContainer, Float>("get_ratio")

    @JvmField
    public val setStretchModeName: MethodStringName1<AspectRatioContainer, Unit, StretchMode> =
        MethodStringName1<AspectRatioContainer, Unit, StretchMode>("set_stretch_mode")

    @JvmField
    public val getStretchModeName: MethodStringName0<AspectRatioContainer, StretchMode> =
        MethodStringName0<AspectRatioContainer, StretchMode>("get_stretch_mode")

    @JvmField
    public val setAlignmentHorizontalName:
        MethodStringName1<AspectRatioContainer, Unit, AlignmentMode> =
        MethodStringName1<AspectRatioContainer, Unit, AlignmentMode>("set_alignment_horizontal")

    @JvmField
    public val getAlignmentHorizontalName: MethodStringName0<AspectRatioContainer, AlignmentMode> =
        MethodStringName0<AspectRatioContainer, AlignmentMode>("get_alignment_horizontal")

    @JvmField
    public val setAlignmentVerticalName:
        MethodStringName1<AspectRatioContainer, Unit, AlignmentMode> =
        MethodStringName1<AspectRatioContainer, Unit, AlignmentMode>("set_alignment_vertical")

    @JvmField
    public val getAlignmentVerticalName: MethodStringName0<AspectRatioContainer, AlignmentMode> =
        MethodStringName0<AspectRatioContainer, AlignmentMode>("get_alignment_vertical")
  }

  public object MethodBindings {
    internal val setRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AspectRatioContainer", "set_ratio", 373806689)

    internal val getRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AspectRatioContainer", "get_ratio", 1740695150)

    internal val setStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AspectRatioContainer", "set_stretch_mode", 1876743467)

    internal val getStretchModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AspectRatioContainer", "get_stretch_mode", 3416449033)

    internal val setAlignmentHorizontalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AspectRatioContainer", "set_alignment_horizontal", 2147829016)

    internal val getAlignmentHorizontalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AspectRatioContainer", "get_alignment_horizontal", 3838875429)

    internal val setAlignmentVerticalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AspectRatioContainer", "set_alignment_vertical", 2147829016)

    internal val getAlignmentVerticalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AspectRatioContainer", "get_alignment_vertical", 3838875429)
  }
}
