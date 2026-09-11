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
import godot.core.PackedInt32Array
import godot.core.RID
import godot.core.Signal0
import godot.core.Signal5
import godot.core.Transform3D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser._RID
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Abstract base class for 3D physics objects. [CollisionObject3D] can hold any number of [Shape3D]s
 * for collision. Each shape must be assigned to a *shape owner*. Shape owners are not nodes and do not
 * appear in the editor, but are accessible through code using the `shape_owner_*` methods.
 *
 * **Warning:** With a non-uniform scale, this node will likely not behave as expected. It is
 * advised to keep its scale the same on all axes and adjust its collision shape(s) instead.
 */
@GodotBaseType
public open class CollisionObject3D internal constructor() : Node3D() {
  /**
   * Emitted when the object receives an unhandled [InputEvent]. [eventPosition] is the location in
   * world space of the mouse pointer on the surface of the shape with index [shapeIdx] and [normal] is
   * the normal vector of the surface at that point.
   */
  public val inputEvent: Signal5<Node, InputEvent, Vector3, Vector3, Long> by Signal5

  /**
   * Emitted when the mouse pointer enters any of this object's shapes. Requires [inputRayPickable]
   * to be `true` and at least one [collisionLayer] bit to be set.
   *
   * **Note:** Due to the lack of continuous collision detection, this signal may not be emitted in
   * the expected order if the mouse moves fast enough and the [CollisionObject3D]'s area is small.
   * This signal may also not be emitted if another [CollisionObject3D] is overlapping the
   * [CollisionObject3D] in question.
   */
  public val mouseEntered: Signal0 by Signal0

  /**
   * Emitted when the mouse pointer exits all this object's shapes. Requires [inputRayPickable] to
   * be `true` and at least one [collisionLayer] bit to be set.
   *
   * **Note:** Due to the lack of continuous collision detection, this signal may not be emitted in
   * the expected order if the mouse moves fast enough and the [CollisionObject3D]'s area is small.
   * This signal may also not be emitted if another [CollisionObject3D] is overlapping the
   * [CollisionObject3D] in question.
   */
  public val mouseExited: Signal0 by Signal0

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

  /**
   * The physics layers this CollisionObject3D **is in**. Collision objects can exist in one or more
   * of 32 different layers. See also [collisionMask].
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
   * The physics layers this CollisionObject3D **scans**. Collision objects can scan one or more of
   * 32 different layers. See also [collisionLayer].
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
   * The priority used to solve colliding when occurring penetration. The higher the priority is,
   * the lower the penetration into the object will be. This can for example be used to prevent the
   * player from breaking through the boundaries of a level.
   */
  public final inline var collisionPriority: Float
    @JvmName("collisionPriorityProperty")
    get() = getCollisionPriority()
    @JvmName("collisionPriorityProperty")
    set(`value`) {
      setCollisionPriority(value)
    }

  /**
   * If `true`, this object is pickable. A pickable object can detect the mouse pointer
   * entering/leaving, and if the mouse is inside it, report input events. Requires at least one
   * [collisionLayer] bit to be set.
   */
  public final inline var inputRayPickable: Boolean
    @JvmName("inputRayPickableProperty")
    get() = isRayPickable()
    @JvmName("inputRayPickableProperty")
    set(`value`) {
      setRayPickable(value)
    }

  /**
   * If `true`, the [CollisionObject3D] will continue to receive input events as the mouse is
   * dragged across its shapes.
   */
  public final inline var inputCaptureOnDrag: Boolean
    @JvmName("inputCaptureOnDragProperty")
    get() = getCaptureInputOnDrag()
    @JvmName("inputCaptureOnDragProperty")
    set(`value`) {
      setCaptureInputOnDrag(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(164, scriptPtr)
  }

  /**
   * Receives unhandled [InputEvent]s. [eventPosition] is the location in world space of the mouse
   * pointer on the surface of the shape with index [shapeIdx] and [normal] is the normal vector of the
   * surface at that point. Connect to the [signal input_event] signal to easily pick up these events.
   *
   * **Note:** [_inputEvent] requires [inputRayPickable] to be `true` and at least one
   * [collisionLayer] bit to be set.
   */
  public open fun _inputEvent(
    camera: Camera3D,
    event: InputEvent,
    eventPosition: Vector3,
    normal: Vector3,
    shapeIdx: Int,
  ): Unit {
    throw NotImplementedError("CollisionObject3D::_inputEvent is not implemented.")
  }

  /**
   * Called when the mouse pointer enters any of this object's shapes. Requires [inputRayPickable]
   * to be `true` and at least one [collisionLayer] bit to be set. Note that moving between different
   * shapes within a single [CollisionObject3D] won't cause this function to be called.
   */
  public open fun _mouseEnter(): Unit {
    throw NotImplementedError("CollisionObject3D::_mouseEnter is not implemented.")
  }

  /**
   * Called when the mouse pointer exits all this object's shapes. Requires [inputRayPickable] to be
   * `true` and at least one [collisionLayer] bit to be set. Note that moving between different shapes
   * within a single [CollisionObject3D] won't cause this function to be called.
   */
  public open fun _mouseExit(): Unit {
    throw NotImplementedError("CollisionObject3D::_mouseExit is not implemented.")
  }

  public final fun setCollisionLayer(layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer)
    TransferContext.callMethod(MethodBindings.setCollisionLayerPtr)
  }

  public final fun getCollisionLayer(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCollisionMask(mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask)
    TransferContext.callMethod(MethodBindings.setCollisionMaskPtr)
  }

  public final fun getCollisionMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Based on [value], enables or disables the specified layer in the [collisionLayer], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionLayerValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setCollisionLayerValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [collisionLayer] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionLayerValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionLayerValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Based on [value], enables or disables the specified layer in the [collisionMask], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setCollisionMaskValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [collisionMask] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionMaskValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCollisionPriority(priority: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to priority.toDouble())
    TransferContext.callMethod(MethodBindings.setCollisionPriorityPtr)
  }

  public final fun getCollisionPriority(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionPriorityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDisableMode(mode: DisableMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setDisableModePtr)
  }

  public final fun getDisableMode(): DisableMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDisableModePtr)
    return DisableMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setRayPickable(rayPickable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to rayPickable)
    TransferContext.callMethod(MethodBindings.setRayPickablePtr)
  }

  public final fun isRayPickable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRayPickablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCaptureInputOnDrag(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setCaptureInputOnDragPtr)
  }

  public final fun getCaptureInputOnDrag(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCaptureInputOnDragPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the object's [RID].
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new shape owner for the given object. Returns `owner_id` of the new owner for future
   * reference.
   */
  public final fun createShapeOwner(owner: Object?): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to owner)
    TransferContext.callMethod(MethodBindings.createShapeOwnerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Removes the given shape owner.
   */
  public final fun removeShapeOwner(ownerId: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId)
    TransferContext.callMethod(MethodBindings.removeShapeOwnerPtr)
  }

  /**
   * Returns an [VariantArray] of `owner_id` identifiers. You can use these ids in other methods
   * that take `owner_id` as an argument.
   */
  public final fun getShapeOwners(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShapeOwnersPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Sets the [Transform3D] of the given shape owner.
   */
  public final fun shapeOwnerSetTransform(ownerId: Long, transform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId, TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.shapeOwnerSetTransformPtr)
  }

  /**
   * Returns the shape owner's [Transform3D].
   */
  public final fun shapeOwnerGetTransform(ownerId: Long): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId)
    TransferContext.callMethod(MethodBindings.shapeOwnerGetTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Returns the parent object of the given shape owner.
   */
  public final fun shapeOwnerGetOwner(ownerId: Long): Object? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId)
    TransferContext.callMethod(MethodBindings.shapeOwnerGetOwnerPtr)
    return (TransferContext.readReturnValue(OBJECT) as Object?)
  }

  /**
   * If `true`, disables the given shape owner.
   */
  public final fun shapeOwnerSetDisabled(ownerId: Long, disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.shapeOwnerSetDisabledPtr)
  }

  /**
   * If `true`, the shape owner and its shapes are disabled.
   */
  public final fun isShapeOwnerDisabled(ownerId: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId)
    TransferContext.callMethod(MethodBindings.isShapeOwnerDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds a [Shape3D] to the shape owner.
   */
  public final fun shapeOwnerAddShape(ownerId: Long, shape: Shape3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId, OBJECT to shape)
    TransferContext.callMethod(MethodBindings.shapeOwnerAddShapePtr)
  }

  /**
   * Returns the number of shapes the given shape owner contains.
   */
  public final fun shapeOwnerGetShapeCount(ownerId: Long): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId)
    TransferContext.callMethod(MethodBindings.shapeOwnerGetShapeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [Shape3D] with the given ID from the given shape owner.
   */
  public final fun shapeOwnerGetShape(ownerId: Long, shapeId: Int): Shape3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId, LONG to shapeId.toLong())
    TransferContext.callMethod(MethodBindings.shapeOwnerGetShapePtr)
    return (TransferContext.readReturnValue(OBJECT) as Shape3D?)
  }

  /**
   * Returns the child index of the [Shape3D] with the given ID from the given shape owner.
   */
  public final fun shapeOwnerGetShapeIndex(ownerId: Long, shapeId: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId, LONG to shapeId.toLong())
    TransferContext.callMethod(MethodBindings.shapeOwnerGetShapeIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes a shape from the given shape owner.
   */
  public final fun shapeOwnerRemoveShape(ownerId: Long, shapeId: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId, LONG to shapeId.toLong())
    TransferContext.callMethod(MethodBindings.shapeOwnerRemoveShapePtr)
  }

  /**
   * Removes all shapes from the shape owner.
   */
  public final fun shapeOwnerClearShapes(ownerId: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ownerId)
    TransferContext.callMethod(MethodBindings.shapeOwnerClearShapesPtr)
  }

  /**
   * Returns the `owner_id` of the given shape.
   */
  public final fun shapeFindOwner(shapeIndex: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shapeIndex.toLong())
    TransferContext.callMethod(MethodBindings.shapeFindOwnerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class DisableMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * When [Node.processMode] is set to [Node.PROCESS_MODE_DISABLED], remove from the physics
     * simulation to stop all physics interactions with this [CollisionObject3D].
     *
     * Automatically re-added to the physics simulation when the [Node] is processed again.
     */
    REMOVE(0),
    /**
     * When [Node.processMode] is set to [Node.PROCESS_MODE_DISABLED], make the body static. Doesn't
     * affect [Area3D]. [PhysicsBody3D] can't be affected by forces or other bodies while static.
     *
     * Automatically set [PhysicsBody3D] back to its original mode when the [Node] is processed
     * again.
     */
    MAKE_STATIC(1),
    /**
     * When [Node.processMode] is set to [Node.PROCESS_MODE_DISABLED], do not affect the physics
     * simulation.
     */
    KEEP_ACTIVE(2),
    ;

    public companion object {
      public fun from(`value`: Long): DisableMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setCollisionLayerName: MethodStringName1<CollisionObject3D, Unit, Long> =
        MethodStringName1<CollisionObject3D, Unit, Long>("set_collision_layer")

    @JvmField
    public val getCollisionLayerName: MethodStringName0<CollisionObject3D, Long> =
        MethodStringName0<CollisionObject3D, Long>("get_collision_layer")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<CollisionObject3D, Unit, Long> =
        MethodStringName1<CollisionObject3D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<CollisionObject3D, Long> =
        MethodStringName0<CollisionObject3D, Long>("get_collision_mask")

    @JvmField
    public val setCollisionLayerValueName: MethodStringName2<CollisionObject3D, Unit, Int, Boolean>
        = MethodStringName2<CollisionObject3D, Unit, Int, Boolean>("set_collision_layer_value")

    @JvmField
    public val getCollisionLayerValueName: MethodStringName1<CollisionObject3D, Boolean, Int> =
        MethodStringName1<CollisionObject3D, Boolean, Int>("get_collision_layer_value")

    @JvmField
    public val setCollisionMaskValueName: MethodStringName2<CollisionObject3D, Unit, Int, Boolean> =
        MethodStringName2<CollisionObject3D, Unit, Int, Boolean>("set_collision_mask_value")

    @JvmField
    public val getCollisionMaskValueName: MethodStringName1<CollisionObject3D, Boolean, Int> =
        MethodStringName1<CollisionObject3D, Boolean, Int>("get_collision_mask_value")

    @JvmField
    public val setCollisionPriorityName: MethodStringName1<CollisionObject3D, Unit, Float> =
        MethodStringName1<CollisionObject3D, Unit, Float>("set_collision_priority")

    @JvmField
    public val getCollisionPriorityName: MethodStringName0<CollisionObject3D, Float> =
        MethodStringName0<CollisionObject3D, Float>("get_collision_priority")

    @JvmField
    public val setDisableModeName: MethodStringName1<CollisionObject3D, Unit, DisableMode> =
        MethodStringName1<CollisionObject3D, Unit, DisableMode>("set_disable_mode")

    @JvmField
    public val getDisableModeName: MethodStringName0<CollisionObject3D, DisableMode> =
        MethodStringName0<CollisionObject3D, DisableMode>("get_disable_mode")

    @JvmField
    public val setRayPickableName: MethodStringName1<CollisionObject3D, Unit, Boolean> =
        MethodStringName1<CollisionObject3D, Unit, Boolean>("set_ray_pickable")

    @JvmField
    public val isRayPickableName: MethodStringName0<CollisionObject3D, Boolean> =
        MethodStringName0<CollisionObject3D, Boolean>("is_ray_pickable")

    @JvmField
    public val setCaptureInputOnDragName: MethodStringName1<CollisionObject3D, Unit, Boolean> =
        MethodStringName1<CollisionObject3D, Unit, Boolean>("set_capture_input_on_drag")

    @JvmField
    public val getCaptureInputOnDragName: MethodStringName0<CollisionObject3D, Boolean> =
        MethodStringName0<CollisionObject3D, Boolean>("get_capture_input_on_drag")

    @JvmField
    public val getRidName: MethodStringName0<CollisionObject3D, RID> =
        MethodStringName0<CollisionObject3D, RID>("get_rid")

    @JvmField
    public val createShapeOwnerName: MethodStringName1<CollisionObject3D, Long, Object?> =
        MethodStringName1<CollisionObject3D, Long, Object?>("create_shape_owner")

    @JvmField
    public val removeShapeOwnerName: MethodStringName1<CollisionObject3D, Unit, Long> =
        MethodStringName1<CollisionObject3D, Unit, Long>("remove_shape_owner")

    @JvmField
    public val getShapeOwnersName: MethodStringName0<CollisionObject3D, PackedInt32Array> =
        MethodStringName0<CollisionObject3D, PackedInt32Array>("get_shape_owners")

    @JvmField
    public val shapeOwnerSetTransformName:
        MethodStringName2<CollisionObject3D, Unit, Long, Transform3D> =
        MethodStringName2<CollisionObject3D, Unit, Long, Transform3D>("shape_owner_set_transform")

    @JvmField
    public val shapeOwnerGetTransformName: MethodStringName1<CollisionObject3D, Transform3D, Long> =
        MethodStringName1<CollisionObject3D, Transform3D, Long>("shape_owner_get_transform")

    @JvmField
    public val shapeOwnerGetOwnerName: MethodStringName1<CollisionObject3D, Object?, Long> =
        MethodStringName1<CollisionObject3D, Object?, Long>("shape_owner_get_owner")

    @JvmField
    public val shapeOwnerSetDisabledName: MethodStringName2<CollisionObject3D, Unit, Long, Boolean>
        = MethodStringName2<CollisionObject3D, Unit, Long, Boolean>("shape_owner_set_disabled")

    @JvmField
    public val isShapeOwnerDisabledName: MethodStringName1<CollisionObject3D, Boolean, Long> =
        MethodStringName1<CollisionObject3D, Boolean, Long>("is_shape_owner_disabled")

    @JvmField
    public val shapeOwnerAddShapeName: MethodStringName2<CollisionObject3D, Unit, Long, Shape3D> =
        MethodStringName2<CollisionObject3D, Unit, Long, Shape3D>("shape_owner_add_shape")

    @JvmField
    public val shapeOwnerGetShapeCountName: MethodStringName1<CollisionObject3D, Int, Long> =
        MethodStringName1<CollisionObject3D, Int, Long>("shape_owner_get_shape_count")

    @JvmField
    public val shapeOwnerGetShapeName: MethodStringName2<CollisionObject3D, Shape3D?, Long, Int> =
        MethodStringName2<CollisionObject3D, Shape3D?, Long, Int>("shape_owner_get_shape")

    @JvmField
    public val shapeOwnerGetShapeIndexName: MethodStringName2<CollisionObject3D, Int, Long, Int> =
        MethodStringName2<CollisionObject3D, Int, Long, Int>("shape_owner_get_shape_index")

    @JvmField
    public val shapeOwnerRemoveShapeName: MethodStringName2<CollisionObject3D, Unit, Long, Int> =
        MethodStringName2<CollisionObject3D, Unit, Long, Int>("shape_owner_remove_shape")

    @JvmField
    public val shapeOwnerClearShapesName: MethodStringName1<CollisionObject3D, Unit, Long> =
        MethodStringName1<CollisionObject3D, Unit, Long>("shape_owner_clear_shapes")

    @JvmField
    public val shapeFindOwnerName: MethodStringName1<CollisionObject3D, Long, Int> =
        MethodStringName1<CollisionObject3D, Long, Int>("shape_find_owner")
  }

  public object MethodBindings {
    internal val setCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "set_collision_layer", 1286410249)

    internal val getCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_collision_layer", 3905245786)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_collision_mask", 3905245786)

    internal val setCollisionLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "set_collision_layer_value", 300928843)

    internal val getCollisionLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_collision_layer_value", 1116898809)

    internal val setCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "set_collision_mask_value", 300928843)

    internal val getCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_collision_mask_value", 1116898809)

    internal val setCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "set_collision_priority", 373806689)

    internal val getCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_collision_priority", 1740695150)

    internal val setDisableModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "set_disable_mode", 1623620376)

    internal val getDisableModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_disable_mode", 410164780)

    internal val setRayPickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "set_ray_pickable", 2586408642)

    internal val isRayPickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "is_ray_pickable", 36873697)

    internal val setCaptureInputOnDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "set_capture_input_on_drag", 2586408642)

    internal val getCaptureInputOnDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_capture_input_on_drag", 36873697)

    internal val getRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_rid", 2944877500)

    internal val createShapeOwnerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "create_shape_owner", 3429307534)

    internal val removeShapeOwnerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "remove_shape_owner", 1286410249)

    internal val getShapeOwnersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "get_shape_owners", 969006518)

    internal val shapeOwnerSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_set_transform", 3616898986)

    internal val shapeOwnerGetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_get_transform", 1965739696)

    internal val shapeOwnerGetOwnerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_get_owner", 3332903315)

    internal val shapeOwnerSetDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_set_disabled", 300928843)

    internal val isShapeOwnerDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "is_shape_owner_disabled", 1116898809)

    internal val shapeOwnerAddShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_add_shape", 2566676345)

    internal val shapeOwnerGetShapeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_get_shape_count", 923996154)

    internal val shapeOwnerGetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_get_shape", 4015519174)

    internal val shapeOwnerGetShapeIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_get_shape_index", 3175239445)

    internal val shapeOwnerRemoveShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_remove_shape", 3937882851)

    internal val shapeOwnerClearShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_owner_clear_shapes", 1286410249)

    internal val shapeFindOwnerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionObject3D", "shape_find_owner", 923996154)
  }
}
