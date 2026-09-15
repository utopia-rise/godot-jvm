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
import godot.core.Signal0
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [SkeletonModifier3D] retrieves a target [Skeleton3D] by having a [Skeleton3D] parent.
 *
 * If there is an [AnimationMixer], a modification always performs after playback process of the
 * [AnimationMixer].
 *
 * This node should be used to implement custom IK solvers, constraints, or skeleton physics.
 */
@GodotBaseType
public open class SkeletonModifier3D : Node3D() {
  /**
   * Notifies when the modification have been finished.
   *
   * **Note:** If you want to get the modified bone pose by the modifier, you must use
   * [Skeleton3D.getBonePose] or [Skeleton3D.getBoneGlobalPose] at the moment this signal is fired.
   */
  public val modificationProcessed: Signal0 by Signal0

  /**
   * If `true`, the [SkeletonModifier3D] will be processing.
   */
  public final inline var active: Boolean
    @JvmName("activeProperty")
    get() = isActive()
    @JvmName("activeProperty")
    set(`value`) {
      setActive(value)
    }

  /**
   * Sets the influence of the modification.
   *
   * **Note:** This value is used by [Skeleton3D] to blend, so the [SkeletonModifier3D] should
   * always apply only 100&#37; of the result without interpolation.
   */
  public final inline var influence: Float
    @JvmName("influenceProperty")
    get() = getInfluence()
    @JvmName("influenceProperty")
    set(`value`) {
      setInfluence(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(676, scriptPtr)
  }

  /**
   * Override this virtual method to implement a custom skeleton modifier. You should do things like
   * get the [Skeleton3D]'s current pose and apply the pose here.
   *
   * [_processModificationWithDelta] must not apply [influence] to bone poses because the
   * [Skeleton3D] automatically applies influence to all bone poses set by the modifier.
   *
   * [delta] is passed from parent [Skeleton3D]. See also [Skeleton3D.advance].
   *
   * **Note:** This method may be called outside [Node.Process] and [Node.PhysicsProcess] with
   * [delta] is `0.0`, since the modification should be processed immediately after initialization of
   * the [Skeleton3D].
   */
  public open fun _processModificationWithDelta(delta: Double): Unit {
    throw NotImplementedError("SkeletonModifier3D::_processModificationWithDelta is not implemented.")
  }

  /**
   * Override this virtual method to implement a custom skeleton modifier. You should do things like
   * get the [Skeleton3D]'s current pose and apply the pose here.
   *
   * [_processModification] must not apply [influence] to bone poses because the [Skeleton3D]
   * automatically applies influence to all bone poses set by the modifier.
   */
  public open fun _processModification(): Unit {
    throw NotImplementedError("SkeletonModifier3D::_processModification is not implemented.")
  }

  /**
   * Called when the skeleton is changed.
   */
  public open fun _skeletonChanged(oldSkeleton: Skeleton3D?, newSkeleton: Skeleton3D?): Unit {
    throw NotImplementedError("SkeletonModifier3D::_skeletonChanged is not implemented.")
  }

  /**
   * Called when bone names and indices need to be validated, such as when entering the scene tree
   * or changing skeleton.
   */
  public open fun _validateBoneNames(): Unit {
    throw NotImplementedError("SkeletonModifier3D::_validateBoneNames is not implemented.")
  }

  /**
   * Returns the parent [Skeleton3D] node if it exists. Otherwise, returns `null`.
   */
  public final fun getSkeleton(): Skeleton3D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSkeletonPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as Skeleton3D?)
  }

  public final fun setActive(active: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, active)
    TransferContext.callPtrMethod(MethodBindings.setActivePtr, 0)
  }

  public final fun isActive(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isActivePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setInfluence(influence: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, influence.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setInfluencePtr, 0)
  }

  public final fun getInfluence(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInfluencePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public enum class BoneAxis(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Enumerated value for the +X axis.
     */
    PLUS_X(0),
    /**
     * Enumerated value for the -X axis.
     */
    MINUS_X(1),
    /**
     * Enumerated value for the +Y axis.
     */
    PLUS_Y(2),
    /**
     * Enumerated value for the -Y axis.
     */
    MINUS_Y(3),
    /**
     * Enumerated value for the +Z axis.
     */
    PLUS_Z(4),
    /**
     * Enumerated value for the -Z axis.
     */
    MINUS_Z(5),
    ;

    public companion object {
      public fun from(`value`: Long): BoneAxis = entries.single { it.`value` == `value` }
    }
  }

  public enum class BoneDirection(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Enumerated value for the +X axis.
     */
    PLUS_X(0),
    /**
     * Enumerated value for the -X axis.
     */
    MINUS_X(1),
    /**
     * Enumerated value for the +Y axis.
     */
    PLUS_Y(2),
    /**
     * Enumerated value for the -Y axis.
     */
    MINUS_Y(3),
    /**
     * Enumerated value for the +Z axis.
     */
    PLUS_Z(4),
    /**
     * Enumerated value for the -Z axis.
     */
    MINUS_Z(5),
    /**
     * Enumerated value for the axis from a parent bone to the child bone.
     */
    FROM_PARENT(6),
    ;

    public companion object {
      public fun from(`value`: Long): BoneDirection = entries.single { it.`value` == `value` }
    }
  }

  public enum class SecondaryDirection(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Enumerated value for the case when the axis is undefined.
     */
    NONE(0),
    /**
     * Enumerated value for the +X axis.
     */
    PLUS_X(1),
    /**
     * Enumerated value for the -X axis.
     */
    MINUS_X(2),
    /**
     * Enumerated value for the +Y axis.
     */
    PLUS_Y(3),
    /**
     * Enumerated value for the -Y axis.
     */
    MINUS_Y(4),
    /**
     * Enumerated value for the +Z axis.
     */
    PLUS_Z(5),
    /**
     * Enumerated value for the -Z axis.
     */
    MINUS_Z(6),
    /**
     * Enumerated value for an optional axis.
     */
    CUSTOM(7),
    ;

    public companion object {
      public fun from(`value`: Long): SecondaryDirection = entries.single { it.`value` == `value` }
    }
  }

  public enum class RotationAxis(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Enumerated value for the rotation of the X axis.
     */
    X(0),
    /**
     * Enumerated value for the rotation of the Y axis.
     */
    Y(1),
    /**
     * Enumerated value for the rotation of the Z axis.
     */
    Z(2),
    /**
     * Enumerated value for the unconstrained rotation.
     */
    ALL(3),
    /**
     * Enumerated value for an optional rotation axis.
     */
    CUSTOM(4),
    ;

    public companion object {
      public fun from(`value`: Long): RotationAxis = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getSkeletonName: MethodStringName0<SkeletonModifier3D, Skeleton3D?> =
        MethodStringName0<SkeletonModifier3D, Skeleton3D?>("get_skeleton")

    @JvmField
    public val setActiveName: MethodStringName1<SkeletonModifier3D, Unit, Boolean> =
        MethodStringName1<SkeletonModifier3D, Unit, Boolean>("set_active")

    @JvmField
    public val isActiveName: MethodStringName0<SkeletonModifier3D, Boolean> =
        MethodStringName0<SkeletonModifier3D, Boolean>("is_active")

    @JvmField
    public val setInfluenceName: MethodStringName1<SkeletonModifier3D, Unit, Float> =
        MethodStringName1<SkeletonModifier3D, Unit, Float>("set_influence")

    @JvmField
    public val getInfluenceName: MethodStringName0<SkeletonModifier3D, Float> =
        MethodStringName0<SkeletonModifier3D, Float>("get_influence")
  }

  public object MethodBindings {
    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModifier3D", "get_skeleton", 1488626673)

    internal val setActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModifier3D", "set_active", 2586408642)

    internal val isActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModifier3D", "is_active", 36873697)

    internal val setInfluencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModifier3D", "set_influence", 373806689)

    internal val getInfluencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModifier3D", "get_influence", 1740695150)
  }
}
