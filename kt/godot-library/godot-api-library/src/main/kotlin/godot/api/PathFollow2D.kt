// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node takes its parent [Path2D], and returns the coordinates of a point within it, given a
 * distance from the first vertex.
 *
 * It is useful for making other nodes follow a path, without coding the movement pattern. For that,
 * the nodes must be children of this node. The descendant nodes will then move accordingly when
 * setting the [progress] in this node.
 */
@GodotBaseType
public open class PathFollow2D : Node2D() {
  /**
   * The distance along the path, in pixels. Changing this value sets this node's position to a
   * point within the path.
   */
  public final inline var progress: Float
    @JvmName("progressProperty")
    get() = getProgress()
    @JvmName("progressProperty")
    set(`value`) {
      setProgress(value)
    }

  /**
   * The distance along the path as a number in the range 0.0 (for the first vertex) to 1.0 (for the
   * last). This is just another way of expressing the progress within the path, as the offset supplied
   * is multiplied internally by the path's length.
   *
   * It can be set or get only if the [PathFollow2D] is the child of a [Path2D] which is part of the
   * scene tree, and that this [Path2D] has a [Curve2D] with a non-zero length. Otherwise, trying to
   * set this field will print an error, and getting this field will return `0.0`.
   */
  public final inline var progressRatio: Float
    @JvmName("progressRatioProperty")
    get() = getProgressRatio()
    @JvmName("progressRatioProperty")
    set(`value`) {
      setProgressRatio(value)
    }

  /**
   * The node's offset along the curve.
   */
  public final inline var hOffset: Float
    @JvmName("hOffsetProperty")
    get() = getHOffset()
    @JvmName("hOffsetProperty")
    set(`value`) {
      setHOffset(value)
    }

  /**
   * The node's offset perpendicular to the curve.
   */
  public final inline var vOffset: Float
    @JvmName("vOffsetProperty")
    get() = getVOffset()
    @JvmName("vOffsetProperty")
    set(`value`) {
      setVOffset(value)
    }

  /**
   * If `true`, this node rotates to follow the path, with the +X direction facing forward on the
   * path.
   */
  public final inline var rotates: Boolean
    @JvmName("rotatesProperty")
    get() = isRotating()
    @JvmName("rotatesProperty")
    set(`value`) {
      setRotates(value)
    }

  /**
   * If `true`, the position between two cached points is interpolated cubically, and linearly
   * otherwise.
   *
   * The points along the [Curve2D] of the [Path2D] are precomputed before use, for faster
   * calculations. The point at the requested offset is then calculated interpolating between two
   * adjacent cached points. This may present a problem if the curve makes sharp turns, as the cached
   * points may not follow the curve closely enough.
   *
   * There are two answers to this problem: either increase the number of cached points and increase
   * memory consumption, or make a cubic interpolation between two points at the cost of (slightly)
   * slower calculations.
   */
  public final inline var cubicInterp: Boolean
    @JvmName("cubicInterpProperty")
    get() = getCubicInterpolation()
    @JvmName("cubicInterpProperty")
    set(`value`) {
      setCubicInterpolation(value)
    }

  /**
   * If `true`, any offset outside the path's length will wrap around, instead of stopping at the
   * ends. Use it for cyclic paths.
   */
  public final inline var loop: Boolean
    @JvmName("loopProperty")
    get() = hasLoop()
    @JvmName("loopProperty")
    set(`value`) {
      setLoop(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(516, scriptPtr)
  }

  public final fun setProgress(progress: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setProgressPtr, progress.toDouble())
  }

  public final fun getProgress(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getProgressPtr).toFloat()

  public final fun setHOffset(hOffset: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setHOffsetPtr, hOffset.toDouble())
  }

  public final fun getHOffset(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getHOffsetPtr).toFloat()

  public final fun setVOffset(vOffset: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setVOffsetPtr, vOffset.toDouble())
  }

  public final fun getVOffset(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getVOffsetPtr).toFloat()

  public final fun setProgressRatio(ratio: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setProgressRatioPtr, ratio.toDouble())
  }

  public final fun getProgressRatio(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getProgressRatioPtr).toFloat()

  public final fun setRotates(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setRotatesPtr, enabled)
  }

  public final fun isRotating(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isRotatingPtr)

  public final fun setCubicInterpolation(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setCubicInterpolationPtr, enabled)
  }

  public final fun getCubicInterpolation(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getCubicInterpolationPtr)

  public final fun setLoop(loop: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setLoopPtr, loop)
  }

  public final fun hasLoop(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.hasLoopPtr)

  public companion object {
    @JvmField
    public val setProgressName: MethodStringName1<PathFollow2D, Unit, Float> =
        MethodStringName1<PathFollow2D, Unit, Float>("set_progress")

    @JvmField
    public val getProgressName: MethodStringName0<PathFollow2D, Float> =
        MethodStringName0<PathFollow2D, Float>("get_progress")

    @JvmField
    public val setHOffsetName: MethodStringName1<PathFollow2D, Unit, Float> =
        MethodStringName1<PathFollow2D, Unit, Float>("set_h_offset")

    @JvmField
    public val getHOffsetName: MethodStringName0<PathFollow2D, Float> =
        MethodStringName0<PathFollow2D, Float>("get_h_offset")

    @JvmField
    public val setVOffsetName: MethodStringName1<PathFollow2D, Unit, Float> =
        MethodStringName1<PathFollow2D, Unit, Float>("set_v_offset")

    @JvmField
    public val getVOffsetName: MethodStringName0<PathFollow2D, Float> =
        MethodStringName0<PathFollow2D, Float>("get_v_offset")

    @JvmField
    public val setProgressRatioName: MethodStringName1<PathFollow2D, Unit, Float> =
        MethodStringName1<PathFollow2D, Unit, Float>("set_progress_ratio")

    @JvmField
    public val getProgressRatioName: MethodStringName0<PathFollow2D, Float> =
        MethodStringName0<PathFollow2D, Float>("get_progress_ratio")

    @JvmField
    public val setRotatesName: MethodStringName1<PathFollow2D, Unit, Boolean> =
        MethodStringName1<PathFollow2D, Unit, Boolean>("set_rotates")

    @JvmField
    public val isRotatingName: MethodStringName0<PathFollow2D, Boolean> =
        MethodStringName0<PathFollow2D, Boolean>("is_rotating")

    @JvmField
    public val setCubicInterpolationName: MethodStringName1<PathFollow2D, Unit, Boolean> =
        MethodStringName1<PathFollow2D, Unit, Boolean>("set_cubic_interpolation")

    @JvmField
    public val getCubicInterpolationName: MethodStringName0<PathFollow2D, Boolean> =
        MethodStringName0<PathFollow2D, Boolean>("get_cubic_interpolation")

    @JvmField
    public val setLoopName: MethodStringName1<PathFollow2D, Unit, Boolean> =
        MethodStringName1<PathFollow2D, Unit, Boolean>("set_loop")

    @JvmField
    public val hasLoopName: MethodStringName0<PathFollow2D, Boolean> =
        MethodStringName0<PathFollow2D, Boolean>("has_loop")
  }

  public object MethodBindings {
    internal val setProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "set_progress", 373806689)

    internal val getProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "get_progress", 1740695150)

    internal val setHOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "set_h_offset", 373806689)

    internal val getHOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "get_h_offset", 1740695150)

    internal val setVOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "set_v_offset", 373806689)

    internal val getVOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "get_v_offset", 1740695150)

    internal val setProgressRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "set_progress_ratio", 373806689)

    internal val getProgressRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "get_progress_ratio", 1740695150)

    internal val setRotatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "set_rotates", 2586408642)

    internal val isRotatingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "is_rotating", 36873697)

    internal val setCubicInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "set_cubic_interpolation", 2586408642)

    internal val getCubicInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "get_cubic_interpolation", 36873697)

    internal val setLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "set_loop", 2586408642)

    internal val hasLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow2D", "has_loop", 36873697)
  }
}
