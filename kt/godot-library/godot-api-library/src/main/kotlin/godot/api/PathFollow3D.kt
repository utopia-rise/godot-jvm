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
import godot.core.MethodStringName2
import godot.core.Transform3D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.TRANSFORM3D
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * This node takes its parent [Path3D], and returns the coordinates of a point within it, given a
 * distance from the first vertex.
 *
 * It is useful for making other nodes follow a path, without coding the movement pattern. For that,
 * the nodes must be children of this node. The descendant nodes will then move accordingly when
 * setting the [progress] in this node.
 */
@GodotBaseType
public open class PathFollow3D : Node3D() {
  /**
   * The distance from the first vertex, measured in 3D units along the path. Changing this value
   * sets this node's position to a point within the path.
   */
  public final inline var progress: Float
    @JvmName("progressProperty")
    get() = getProgress()
    @JvmName("progressProperty")
    set(`value`) {
      setProgress(value)
    }

  /**
   * The distance from the first vertex, considering 0.0 as the first vertex and 1.0 as the last.
   * This is just another way of expressing the progress within the path, as the progress supplied is
   * multiplied internally by the path's length.
   *
   * It can be set or get only if the [PathFollow3D] is the child of a [Path3D] which is part of the
   * scene tree, and that this [Path3D] has a [Curve3D] with a non-zero length. Otherwise, trying to
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
   * Allows or forbids rotation on one or more axes, depending on the [RotationMode] constants being
   * used.
   */
  public final inline var rotationMode: RotationMode
    @JvmName("rotationModeProperty")
    get() = getRotationMode()
    @JvmName("rotationModeProperty")
    set(`value`) {
      setRotationMode(value)
    }

  /**
   * If `true`, the node moves on the travel path with orienting the +Z axis as forward. See also
   * [Vector3.FORWARD] and [Vector3.MODEL_FRONT].
   */
  public final inline var useModelFront: Boolean
    @JvmName("useModelFrontProperty")
    get() = isUsingModelFront()
    @JvmName("useModelFrontProperty")
    set(`value`) {
      setUseModelFront(value)
    }

  /**
   * If `true`, the position between two cached points is interpolated cubically, and linearly
   * otherwise.
   *
   * The points along the [Curve3D] of the [Path3D] are precomputed before use, for faster
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

  /**
   * If `true`, the tilt property of [Curve3D] takes effect.
   */
  public final inline var tiltEnabled: Boolean
    @JvmName("tiltEnabledProperty")
    get() = isTiltEnabled()
    @JvmName("tiltEnabledProperty")
    set(`value`) {
      setTiltEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(518, scriptPtr)
  }

  public final fun setProgress(progress: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to progress.toDouble())
    TransferContext.callMethod(MethodBindings.setProgressPtr)
  }

  public final fun getProgress(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProgressPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setHOffset(hOffset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to hOffset.toDouble())
    TransferContext.callMethod(MethodBindings.setHOffsetPtr)
  }

  public final fun getHOffset(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVOffset(vOffset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to vOffset.toDouble())
    TransferContext.callMethod(MethodBindings.setVOffsetPtr)
  }

  public final fun getVOffset(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setProgressRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setProgressRatioPtr)
  }

  public final fun getProgressRatio(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProgressRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRotationMode(rotationMode: RotationMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to rotationMode.value)
    TransferContext.callMethod(MethodBindings.setRotationModePtr)
  }

  public final fun getRotationMode(): RotationMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationModePtr)
    return RotationMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCubicInterpolation(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCubicInterpolationPtr)
  }

  public final fun getCubicInterpolation(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCubicInterpolationPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseModelFront(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setUseModelFrontPtr)
  }

  public final fun isUsingModelFront(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingModelFrontPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLoop(loop: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to loop)
    TransferContext.callMethod(MethodBindings.setLoopPtr)
  }

  public final fun hasLoop(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasLoopPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTiltEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setTiltEnabledPtr)
  }

  public final fun isTiltEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isTiltEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class RotationMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Forbids the PathFollow3D to rotate.
     */
    NONE(0),
    /**
     * Allows the PathFollow3D to rotate in the Y axis only.
     */
    Y(1),
    /**
     * Allows the PathFollow3D to rotate in both the X, and Y axes.
     */
    XY(2),
    /**
     * Allows the PathFollow3D to rotate in any axis.
     */
    XYZ(3),
    /**
     * Uses the up vector information in a [Curve3D] to enforce orientation. This rotation mode
     * requires the [Path3D]'s [Curve3D.upVectorEnabled] property to be set to `true`.
     */
    ORIENTED(4),
    ;

    public companion object {
      public fun from(`value`: Long): RotationMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setProgressName: MethodStringName1<PathFollow3D, Unit, Float> =
        MethodStringName1<PathFollow3D, Unit, Float>("set_progress")

    @JvmField
    public val getProgressName: MethodStringName0<PathFollow3D, Float> =
        MethodStringName0<PathFollow3D, Float>("get_progress")

    @JvmField
    public val setHOffsetName: MethodStringName1<PathFollow3D, Unit, Float> =
        MethodStringName1<PathFollow3D, Unit, Float>("set_h_offset")

    @JvmField
    public val getHOffsetName: MethodStringName0<PathFollow3D, Float> =
        MethodStringName0<PathFollow3D, Float>("get_h_offset")

    @JvmField
    public val setVOffsetName: MethodStringName1<PathFollow3D, Unit, Float> =
        MethodStringName1<PathFollow3D, Unit, Float>("set_v_offset")

    @JvmField
    public val getVOffsetName: MethodStringName0<PathFollow3D, Float> =
        MethodStringName0<PathFollow3D, Float>("get_v_offset")

    @JvmField
    public val setProgressRatioName: MethodStringName1<PathFollow3D, Unit, Float> =
        MethodStringName1<PathFollow3D, Unit, Float>("set_progress_ratio")

    @JvmField
    public val getProgressRatioName: MethodStringName0<PathFollow3D, Float> =
        MethodStringName0<PathFollow3D, Float>("get_progress_ratio")

    @JvmField
    public val setRotationModeName: MethodStringName1<PathFollow3D, Unit, RotationMode> =
        MethodStringName1<PathFollow3D, Unit, RotationMode>("set_rotation_mode")

    @JvmField
    public val getRotationModeName: MethodStringName0<PathFollow3D, RotationMode> =
        MethodStringName0<PathFollow3D, RotationMode>("get_rotation_mode")

    @JvmField
    public val setCubicInterpolationName: MethodStringName1<PathFollow3D, Unit, Boolean> =
        MethodStringName1<PathFollow3D, Unit, Boolean>("set_cubic_interpolation")

    @JvmField
    public val getCubicInterpolationName: MethodStringName0<PathFollow3D, Boolean> =
        MethodStringName0<PathFollow3D, Boolean>("get_cubic_interpolation")

    @JvmField
    public val setUseModelFrontName: MethodStringName1<PathFollow3D, Unit, Boolean> =
        MethodStringName1<PathFollow3D, Unit, Boolean>("set_use_model_front")

    @JvmField
    public val isUsingModelFrontName: MethodStringName0<PathFollow3D, Boolean> =
        MethodStringName0<PathFollow3D, Boolean>("is_using_model_front")

    @JvmField
    public val setLoopName: MethodStringName1<PathFollow3D, Unit, Boolean> =
        MethodStringName1<PathFollow3D, Unit, Boolean>("set_loop")

    @JvmField
    public val hasLoopName: MethodStringName0<PathFollow3D, Boolean> =
        MethodStringName0<PathFollow3D, Boolean>("has_loop")

    @JvmField
    public val setTiltEnabledName: MethodStringName1<PathFollow3D, Unit, Boolean> =
        MethodStringName1<PathFollow3D, Unit, Boolean>("set_tilt_enabled")

    @JvmField
    public val isTiltEnabledName: MethodStringName0<PathFollow3D, Boolean> =
        MethodStringName0<PathFollow3D, Boolean>("is_tilt_enabled")

    @JvmField
    public val correctPostureName:
        MethodStringName2<PathFollow3D, Transform3D, Transform3D, RotationMode> =
        MethodStringName2<PathFollow3D, Transform3D, Transform3D, RotationMode>("correct_posture")

    /**
     * Correct the [transform]. [rotationMode] implicitly specifies how posture (forward, up and
     * sideway direction) is calculated.
     */
    @JvmStatic
    public final fun correctPosture(transform: Transform3D, rotationMode: RotationMode):
        Transform3D {
      TransferContext.writeMethodArguments(0L, 0L, TRANSFORM3D to transform, LONG to rotationMode.value)
      TransferContext.callMethod(MethodBindings.correctPosturePtr)
      return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
    }
  }

  public object MethodBindings {
    internal val setProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_progress", 373806689)

    internal val getProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "get_progress", 1740695150)

    internal val setHOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_h_offset", 373806689)

    internal val getHOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "get_h_offset", 1740695150)

    internal val setVOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_v_offset", 373806689)

    internal val getVOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "get_v_offset", 1740695150)

    internal val setProgressRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_progress_ratio", 373806689)

    internal val getProgressRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "get_progress_ratio", 1740695150)

    internal val setRotationModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_rotation_mode", 1640311967)

    internal val getRotationModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "get_rotation_mode", 3814010545)

    internal val setCubicInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_cubic_interpolation", 2586408642)

    internal val getCubicInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "get_cubic_interpolation", 36873697)

    internal val setUseModelFrontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_use_model_front", 2586408642)

    internal val isUsingModelFrontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "is_using_model_front", 36873697)

    internal val setLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_loop", 2586408642)

    internal val hasLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "has_loop", 36873697)

    internal val setTiltEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "set_tilt_enabled", 2586408642)

    internal val isTiltEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "is_tilt_enabled", 36873697)

    internal val correctPosturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PathFollow3D", "correct_posture", 2686588690)
  }
}
