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
import godot.core.MethodStringName4
import godot.core.NodePath
import godot.core.RID
import godot.core.VariantArray
import godot.core.Vector3
import godot.core.asCachedNodePath
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_RID
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_BOOL_NODE_PATH_LONG
import godot.writeMethodArguments_LONG_VECTOR3
import godot.writeMethodArguments_NODE_PATH
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_VECTOR3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A deformable 3D physics mesh. Used to create elastic or deformable objects such as cloth, rubber,
 * or other flexible materials.
 *
 * Additionally, [SoftBody3D] is subject to wind forces defined in [Area3D] (see
 * [Area3D.windSourcePath], [Area3D.windForceMagnitude], and [Area3D.windAttenuationFactor]).
 *
 * **Note:** It's recommended to use Jolt Physics when using [SoftBody3D] instead of the default
 * GodotPhysics3D, as Jolt Physics' soft body implementation is faster and more reliable. You can
 * switch the physics engine using the [ProjectSettings.physics/3d/physicsEngine] project setting.
 */
@GodotBaseType
public open class SoftBody3D : MeshInstance3D() {
  /**
   * The physics layers this SoftBody3D **is in**. Collision objects can exist in one or more of 32
   * different layers. See also [collisionMask].
   *
   * **Note:** Object A can detect a contact with object B only if object B is in any of the layers
   * that object A scans. See
   * [url=$DOCS_URL/tutorials/physics/physics_introduction.html#collision-layers-and-masks]Collision
   * layers and masks[/url] in the documentation for more information.
   */
  public final inline var collisionLayer: Long
    @JvmName("collisionLayerProperty")
    get() = getCollisionLayer()
    @JvmName("collisionLayerProperty")
    set(`value`) {
      setCollisionLayer(value)
    }

  /**
   * The physics layers this SoftBody3D **scans**. Collision objects can scan one or more of 32
   * different layers. See also [collisionLayer].
   *
   * **Note:** Object A can detect a contact with object B only if object B is in any of the layers
   * that object A scans. See
   * [url=$DOCS_URL/tutorials/physics/physics_introduction.html#collision-layers-and-masks]Collision
   * layers and masks[/url] in the documentation for more information.
   */
  public final inline var collisionMask: Long
    @JvmName("collisionMaskProperty")
    get() = getCollisionMask()
    @JvmName("collisionMaskProperty")
    set(`value`) {
      setCollisionMask(value)
    }

  /**
   * [NodePath] to a [CollisionObject3D] this SoftBody3D should avoid clipping.
   */
  public final inline var parentCollisionIgnore: NodePath
    @JvmName("parentCollisionIgnoreProperty")
    get() = getParentCollisionIgnore()
    @JvmName("parentCollisionIgnoreProperty")
    set(`value`) {
      setParentCollisionIgnore(value)
    }

  /**
   * Increasing this value will improve the resulting simulation, but can affect performance. Use
   * with care.
   */
  public final inline var simulationPrecision: Int
    @JvmName("simulationPrecisionProperty")
    get() = getSimulationPrecision()
    @JvmName("simulationPrecisionProperty")
    set(`value`) {
      setSimulationPrecision(value)
    }

  /**
   * The SoftBody3D's mass.
   */
  public final inline var totalMass: Float
    @JvmName("totalMassProperty")
    get() = getTotalMass()
    @JvmName("totalMassProperty")
    set(`value`) {
      setTotalMass(value)
    }

  /**
   * Higher values will result in a stiffer body, while lower values will increase the body's
   * ability to bend. The value can be between `0.0` and `1.0` (inclusive).
   */
  public final inline var linearStiffness: Float
    @JvmName("linearStiffnessProperty")
    get() = getLinearStiffness()
    @JvmName("linearStiffnessProperty")
    set(`value`) {
      setLinearStiffness(value)
    }

  /**
   * Scales the rest lengths of [SoftBody3D]'s edge constraints. Positive values shrink the mesh,
   * while negative values expand it. For example, a value of `0.1` shortens the edges of the mesh by
   * 10&#37;, while `-0.1` expands the edges by 10&#37;.
   *
   * **Note:** [shrinkingFactor] is best used on surface meshes with pinned points.
   */
  public final inline var shrinkingFactor: Float
    @JvmName("shrinkingFactorProperty")
    get() = getShrinkingFactor()
    @JvmName("shrinkingFactorProperty")
    set(`value`) {
      setShrinkingFactor(value)
    }

  /**
   * The pressure coefficient of this soft body. Simulate pressure build-up from inside this body.
   * Higher values increase the strength of this effect.
   */
  public final inline var pressureCoefficient: Float
    @JvmName("pressureCoefficientProperty")
    get() = getPressureCoefficient()
    @JvmName("pressureCoefficientProperty")
    set(`value`) {
      setPressureCoefficient(value)
    }

  /**
   * The body's damping coefficient. Higher values will slow down the body more noticeably when
   * forces are applied.
   */
  public final inline var dampingCoefficient: Float
    @JvmName("dampingCoefficientProperty")
    get() = getDampingCoefficient()
    @JvmName("dampingCoefficientProperty")
    set(`value`) {
      setDampingCoefficient(value)
    }

  /**
   * The body's drag coefficient. Higher values increase this body's air resistance.
   *
   * **Note:** This value is currently unused by Godot's default physics implementation.
   */
  public final inline var dragCoefficient: Float
    @JvmName("dragCoefficientProperty")
    get() = getDragCoefficient()
    @JvmName("dragCoefficientProperty")
    set(`value`) {
      setDragCoefficient(value)
    }

  /**
   * If `true`, the [SoftBody3D] will respond to [RayCast3D]s.
   */
  public final inline var rayPickable: Boolean
    @JvmName("rayPickableProperty")
    get() = isRayPickable()
    @JvmName("rayPickableProperty")
    set(`value`) {
      setRayPickable(value)
    }

  /**
   * Defines the behavior in physics when [Node.processMode] is set to [Node.PROCESS_MODE_DISABLED].
   */
  public final inline var disableMode: DisableMode
    @JvmName("disableModeProperty")
    get() = getDisableMode()
    @JvmName("disableModeProperty")
    set(`value`) {
      setDisableMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(685, scriptPtr)
  }

  /**
   * Returns the internal [RID] used by the [PhysicsServer3D] for this body.
   */
  public final fun getPhysicsRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsRidPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setCollisionMask(collisionMask: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, collisionMask)
    TransferContext.callMethod(MethodBindings.setCollisionMaskPtr)
  }

  public final fun getCollisionMask(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionMaskPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setCollisionLayer(collisionLayer: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, collisionLayer)
    TransferContext.callMethod(MethodBindings.setCollisionLayerPtr)
  }

  public final fun getCollisionLayer(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionLayerPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Based on [value], enables or disables the specified layer in the [collisionMask], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layerNumber.toLong(), value)
    TransferContext.callMethod(MethodBindings.setCollisionMaskValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [collisionMask] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionMaskValuePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Based on [value], enables or disables the specified layer in the [collisionLayer], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionLayerValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layerNumber.toLong(), value)
    TransferContext.callMethod(MethodBindings.setCollisionLayerValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [collisionLayer] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionLayerValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionLayerValuePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setParentCollisionIgnore(parentCollisionIgnore: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, parentCollisionIgnore)
    TransferContext.callMethod(MethodBindings.setParentCollisionIgnorePtr)
  }

  public final fun getParentCollisionIgnore(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParentCollisionIgnorePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setDisableMode(mode: DisableMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setDisableModePtr)
  }

  public final fun getDisableMode(): DisableMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDisableModePtr)
    return DisableMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns an array of nodes that were added as collision exceptions for this body.
   */
  public final fun getCollisionExceptions(): VariantArray<PhysicsBody3D> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionExceptionsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<PhysicsBody3D>)
  }

  /**
   * Adds a body to the list of bodies that this body can't collide with.
   */
  public final fun addCollisionExceptionWith(body: Node): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, body)
    TransferContext.callMethod(MethodBindings.addCollisionExceptionWithPtr)
  }

  /**
   * Removes a body from the list of bodies that this body can't collide with.
   */
  public final fun removeCollisionExceptionWith(body: Node): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, body)
    TransferContext.callMethod(MethodBindings.removeCollisionExceptionWithPtr)
  }

  public final fun setSimulationPrecision(simulationPrecision: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, simulationPrecision.toLong())
    TransferContext.callMethod(MethodBindings.setSimulationPrecisionPtr)
  }

  public final fun getSimulationPrecision(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSimulationPrecisionPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setTotalMass(mass: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, mass.toDouble())
    TransferContext.callMethod(MethodBindings.setTotalMassPtr)
  }

  public final fun getTotalMass(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTotalMassPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setLinearStiffness(linearStiffness: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, linearStiffness.toDouble())
    TransferContext.callMethod(MethodBindings.setLinearStiffnessPtr)
  }

  public final fun getLinearStiffness(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinearStiffnessPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setShrinkingFactor(shrinkingFactor: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, shrinkingFactor.toDouble())
    TransferContext.callMethod(MethodBindings.setShrinkingFactorPtr)
  }

  public final fun getShrinkingFactor(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShrinkingFactorPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPressureCoefficient(pressureCoefficient: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, pressureCoefficient.toDouble())
    TransferContext.callMethod(MethodBindings.setPressureCoefficientPtr)
  }

  public final fun getPressureCoefficient(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPressureCoefficientPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDampingCoefficient(dampingCoefficient: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, dampingCoefficient.toDouble())
    TransferContext.callMethod(MethodBindings.setDampingCoefficientPtr)
  }

  public final fun getDampingCoefficient(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDampingCoefficientPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDragCoefficient(dragCoefficient: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, dragCoefficient.toDouble())
    TransferContext.callMethod(MethodBindings.setDragCoefficientPtr)
  }

  public final fun getDragCoefficient(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDragCoefficientPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns local translation of a vertex in the surface array.
   */
  public final fun getPointTransform(pointIndex: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pointIndex.toLong())
    TransferContext.callMethod(MethodBindings.getPointTransformPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Applies an impulse to a point.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   */
  public final fun applyImpulse(pointIndex: Int, impulse: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, pointIndex.toLong(), impulse)
    TransferContext.callMethod(MethodBindings.applyImpulsePtr)
  }

  /**
   * Applies a force to a point. A force is time dependent and meant to be applied every physics
   * update.
   */
  public final fun applyForce(pointIndex: Int, force: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, pointIndex.toLong(), force)
    TransferContext.callMethod(MethodBindings.applyForcePtr)
  }

  /**
   * Distributes and applies an impulse to all points.
   *
   * An impulse is time-independent! Applying an impulse every frame would result in a
   * framerate-dependent force. For this reason, it should only be used when simulating one-time
   * impacts (use the "_force" functions otherwise).
   */
  public final fun applyCentralImpulse(impulse: Vector3): Unit {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, impulse)
    TransferContext.callMethod(MethodBindings.applyCentralImpulsePtr)
  }

  /**
   * Distributes and applies a force to all points. A force is time dependent and meant to be
   * applied every physics update.
   */
  public final fun applyCentralForce(force: Vector3): Unit {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, force)
    TransferContext.callMethod(MethodBindings.applyCentralForcePtr)
  }

  /**
   * Sets the pinned state of a surface vertex. When set to `true`, the optional [attachmentPath]
   * can define a [Node3D] the pinned vertex will be attached to.
   */
  @JvmOverloads
  public final fun setPointPinned(
    pointIndex: Int,
    pinned: Boolean,
    attachmentPath: NodePath = NodePath(""),
    insertAt: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL_NODE_PATH_LONG(ptr, objectID.id, pointIndex.toLong(), pinned, attachmentPath, insertAt.toLong())
    TransferContext.callMethod(MethodBindings.setPointPinnedPtr)
  }

  /**
   * Returns `true` if vertex is set to pinned.
   */
  public final fun isPointPinned(pointIndex: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pointIndex.toLong())
    TransferContext.callMethod(MethodBindings.isPointPinnedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setRayPickable(rayPickable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, rayPickable)
    TransferContext.callMethod(MethodBindings.setRayPickablePtr)
  }

  public final fun isRayPickable(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRayPickablePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setParentCollisionIgnore(parentCollisionIgnore: String) =
      setParentCollisionIgnore(parentCollisionIgnore.asCachedNodePath())

  /**
   * Sets the pinned state of a surface vertex. When set to `true`, the optional [attachmentPath]
   * can define a [Node3D] the pinned vertex will be attached to.
   */
  @JvmOverloads
  public final fun setPointPinned(
    pointIndex: Int,
    pinned: Boolean,
    attachmentPath: String,
    insertAt: Int = -1,
  ) = setPointPinned(pointIndex, pinned, attachmentPath.asCachedNodePath(), insertAt)

  public enum class DisableMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * When [Node.processMode] is set to [Node.PROCESS_MODE_DISABLED], remove from the physics
     * simulation to stop all physics interactions with this [SoftBody3D].
     *
     * Automatically re-added to the physics simulation when the [Node] is processed again.
     */
    REMOVE(0),
    /**
     * When [Node.processMode] is set to [Node.PROCESS_MODE_DISABLED], do not affect the physics
     * simulation.
     */
    KEEP_ACTIVE(1),
    ;

    public companion object {
      public fun from(`value`: Long): DisableMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getPhysicsRidName: MethodStringName0<SoftBody3D, RID> =
        MethodStringName0<SoftBody3D, RID>("get_physics_rid")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<SoftBody3D, Unit, Long> =
        MethodStringName1<SoftBody3D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<SoftBody3D, Long> =
        MethodStringName0<SoftBody3D, Long>("get_collision_mask")

    @JvmField
    public val setCollisionLayerName: MethodStringName1<SoftBody3D, Unit, Long> =
        MethodStringName1<SoftBody3D, Unit, Long>("set_collision_layer")

    @JvmField
    public val getCollisionLayerName: MethodStringName0<SoftBody3D, Long> =
        MethodStringName0<SoftBody3D, Long>("get_collision_layer")

    @JvmField
    public val setCollisionMaskValueName: MethodStringName2<SoftBody3D, Unit, Int, Boolean> =
        MethodStringName2<SoftBody3D, Unit, Int, Boolean>("set_collision_mask_value")

    @JvmField
    public val getCollisionMaskValueName: MethodStringName1<SoftBody3D, Boolean, Int> =
        MethodStringName1<SoftBody3D, Boolean, Int>("get_collision_mask_value")

    @JvmField
    public val setCollisionLayerValueName: MethodStringName2<SoftBody3D, Unit, Int, Boolean> =
        MethodStringName2<SoftBody3D, Unit, Int, Boolean>("set_collision_layer_value")

    @JvmField
    public val getCollisionLayerValueName: MethodStringName1<SoftBody3D, Boolean, Int> =
        MethodStringName1<SoftBody3D, Boolean, Int>("get_collision_layer_value")

    @JvmField
    public val setParentCollisionIgnoreName: MethodStringName1<SoftBody3D, Unit, NodePath> =
        MethodStringName1<SoftBody3D, Unit, NodePath>("set_parent_collision_ignore")

    @JvmField
    public val getParentCollisionIgnoreName: MethodStringName0<SoftBody3D, NodePath> =
        MethodStringName0<SoftBody3D, NodePath>("get_parent_collision_ignore")

    @JvmField
    public val setDisableModeName: MethodStringName1<SoftBody3D, Unit, DisableMode> =
        MethodStringName1<SoftBody3D, Unit, DisableMode>("set_disable_mode")

    @JvmField
    public val getDisableModeName: MethodStringName0<SoftBody3D, DisableMode> =
        MethodStringName0<SoftBody3D, DisableMode>("get_disable_mode")

    @JvmField
    public val getCollisionExceptionsName:
        MethodStringName0<SoftBody3D, VariantArray<PhysicsBody3D>> =
        MethodStringName0<SoftBody3D, VariantArray<PhysicsBody3D>>("get_collision_exceptions")

    @JvmField
    public val addCollisionExceptionWithName: MethodStringName1<SoftBody3D, Unit, Node> =
        MethodStringName1<SoftBody3D, Unit, Node>("add_collision_exception_with")

    @JvmField
    public val removeCollisionExceptionWithName: MethodStringName1<SoftBody3D, Unit, Node> =
        MethodStringName1<SoftBody3D, Unit, Node>("remove_collision_exception_with")

    @JvmField
    public val setSimulationPrecisionName: MethodStringName1<SoftBody3D, Unit, Int> =
        MethodStringName1<SoftBody3D, Unit, Int>("set_simulation_precision")

    @JvmField
    public val getSimulationPrecisionName: MethodStringName0<SoftBody3D, Int> =
        MethodStringName0<SoftBody3D, Int>("get_simulation_precision")

    @JvmField
    public val setTotalMassName: MethodStringName1<SoftBody3D, Unit, Float> =
        MethodStringName1<SoftBody3D, Unit, Float>("set_total_mass")

    @JvmField
    public val getTotalMassName: MethodStringName0<SoftBody3D, Float> =
        MethodStringName0<SoftBody3D, Float>("get_total_mass")

    @JvmField
    public val setLinearStiffnessName: MethodStringName1<SoftBody3D, Unit, Float> =
        MethodStringName1<SoftBody3D, Unit, Float>("set_linear_stiffness")

    @JvmField
    public val getLinearStiffnessName: MethodStringName0<SoftBody3D, Float> =
        MethodStringName0<SoftBody3D, Float>("get_linear_stiffness")

    @JvmField
    public val setShrinkingFactorName: MethodStringName1<SoftBody3D, Unit, Float> =
        MethodStringName1<SoftBody3D, Unit, Float>("set_shrinking_factor")

    @JvmField
    public val getShrinkingFactorName: MethodStringName0<SoftBody3D, Float> =
        MethodStringName0<SoftBody3D, Float>("get_shrinking_factor")

    @JvmField
    public val setPressureCoefficientName: MethodStringName1<SoftBody3D, Unit, Float> =
        MethodStringName1<SoftBody3D, Unit, Float>("set_pressure_coefficient")

    @JvmField
    public val getPressureCoefficientName: MethodStringName0<SoftBody3D, Float> =
        MethodStringName0<SoftBody3D, Float>("get_pressure_coefficient")

    @JvmField
    public val setDampingCoefficientName: MethodStringName1<SoftBody3D, Unit, Float> =
        MethodStringName1<SoftBody3D, Unit, Float>("set_damping_coefficient")

    @JvmField
    public val getDampingCoefficientName: MethodStringName0<SoftBody3D, Float> =
        MethodStringName0<SoftBody3D, Float>("get_damping_coefficient")

    @JvmField
    public val setDragCoefficientName: MethodStringName1<SoftBody3D, Unit, Float> =
        MethodStringName1<SoftBody3D, Unit, Float>("set_drag_coefficient")

    @JvmField
    public val getDragCoefficientName: MethodStringName0<SoftBody3D, Float> =
        MethodStringName0<SoftBody3D, Float>("get_drag_coefficient")

    @JvmField
    public val getPointTransformName: MethodStringName1<SoftBody3D, Vector3, Int> =
        MethodStringName1<SoftBody3D, Vector3, Int>("get_point_transform")

    @JvmField
    public val applyImpulseName: MethodStringName2<SoftBody3D, Unit, Int, Vector3> =
        MethodStringName2<SoftBody3D, Unit, Int, Vector3>("apply_impulse")

    @JvmField
    public val applyForceName: MethodStringName2<SoftBody3D, Unit, Int, Vector3> =
        MethodStringName2<SoftBody3D, Unit, Int, Vector3>("apply_force")

    @JvmField
    public val applyCentralImpulseName: MethodStringName1<SoftBody3D, Unit, Vector3> =
        MethodStringName1<SoftBody3D, Unit, Vector3>("apply_central_impulse")

    @JvmField
    public val applyCentralForceName: MethodStringName1<SoftBody3D, Unit, Vector3> =
        MethodStringName1<SoftBody3D, Unit, Vector3>("apply_central_force")

    @JvmField
    public val setPointPinnedName: MethodStringName4<SoftBody3D, Unit, Int, Boolean, NodePath, Int>
        = MethodStringName4<SoftBody3D, Unit, Int, Boolean, NodePath, Int>("set_point_pinned")

    @JvmField
    public val isPointPinnedName: MethodStringName1<SoftBody3D, Boolean, Int> =
        MethodStringName1<SoftBody3D, Boolean, Int>("is_point_pinned")

    @JvmField
    public val setRayPickableName: MethodStringName1<SoftBody3D, Unit, Boolean> =
        MethodStringName1<SoftBody3D, Unit, Boolean>("set_ray_pickable")

    @JvmField
    public val isRayPickableName: MethodStringName0<SoftBody3D, Boolean> =
        MethodStringName0<SoftBody3D, Boolean>("is_ray_pickable")
  }

  public object MethodBindings {
    internal val getPhysicsRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_physics_rid", 2944877500)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_collision_mask", 3905245786)

    internal val setCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_collision_layer", 1286410249)

    internal val getCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_collision_layer", 3905245786)

    internal val setCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_collision_mask_value", 300928843)

    internal val getCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_collision_mask_value", 1116898809)

    internal val setCollisionLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_collision_layer_value", 300928843)

    internal val getCollisionLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_collision_layer_value", 1116898809)

    internal val setParentCollisionIgnorePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_parent_collision_ignore", 1348162250)

    internal val getParentCollisionIgnorePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_parent_collision_ignore", 4075236667)

    internal val setDisableModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_disable_mode", 1104158384)

    internal val getDisableModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_disable_mode", 4135042476)

    internal val getCollisionExceptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_collision_exceptions", 2915620761)

    internal val addCollisionExceptionWithPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "add_collision_exception_with", 1078189570)

    internal val removeCollisionExceptionWithPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "remove_collision_exception_with", 1078189570)

    internal val setSimulationPrecisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_simulation_precision", 1286410249)

    internal val getSimulationPrecisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_simulation_precision", 2455072627)

    internal val setTotalMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_total_mass", 373806689)

    internal val getTotalMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_total_mass", 191475506)

    internal val setLinearStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_linear_stiffness", 373806689)

    internal val getLinearStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_linear_stiffness", 191475506)

    internal val setShrinkingFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_shrinking_factor", 373806689)

    internal val getShrinkingFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_shrinking_factor", 191475506)

    internal val setPressureCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_pressure_coefficient", 373806689)

    internal val getPressureCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_pressure_coefficient", 191475506)

    internal val setDampingCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_damping_coefficient", 373806689)

    internal val getDampingCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_damping_coefficient", 191475506)

    internal val setDragCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_drag_coefficient", 373806689)

    internal val getDragCoefficientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_drag_coefficient", 191475506)

    internal val getPointTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "get_point_transform", 871989493)

    internal val applyImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "apply_impulse", 1530502735)

    internal val applyForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "apply_force", 1530502735)

    internal val applyCentralImpulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "apply_central_impulse", 3460891852)

    internal val applyCentralForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "apply_central_force", 3460891852)

    internal val setPointPinnedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_point_pinned", 528784402)

    internal val isPointPinnedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "is_point_pinned", 1116898809)

    internal val setRayPickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "set_ray_pickable", 2586408642)

    internal val isRayPickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SoftBody3D", "is_ray_pickable", 36873697)
  }
}
