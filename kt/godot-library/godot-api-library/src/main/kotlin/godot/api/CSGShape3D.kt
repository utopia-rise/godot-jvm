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
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This is the CSG base class that provides CSG operation support to the various CSG nodes in Godot.
 *
 * **Performance:** CSG nodes are only intended for prototyping as they have a significant CPU
 * performance cost. Consider baking final CSG operation results into static geometry that replaces the
 * CSG nodes.
 *
 * Individual CSG root node results can be baked to nodes with static resources with the editor menu
 * that appears when a CSG root node is selected.
 *
 * Individual CSG root nodes can also be baked to static resources with scripts by calling
 * [bakeStaticMesh] for the visual mesh or [bakeCollisionShape] for the physics collision.
 *
 * Entire scenes of CSG nodes can be baked to static geometry and exported with the editor glTF
 * scene exporter: **Scene > Export As... > glTF 2.0 Scene...**
 */
@GodotBaseType
public open class CSGShape3D internal constructor() : GeometryInstance3D() {
  /**
   * Enables automatic smoothing. This overrides any smoothing on the CSG node and instead uses
   * [smoothingAngle] to calculate normals based on the angle between faces.
   *
   * Children of a [CSGCombiner3D] node will be treated as a single mesh.
   */
  public final inline var autosmooth: Boolean
    @JvmName("autosmoothProperty")
    get() = isAutosmooth()
    @JvmName("autosmoothProperty")
    set(`value`) {
      setAutosmooth(value)
    }

  /**
   * When autosmooth is enabled, faces with an angle between them greater than this will be
   * smoothed, while faces with a smaller angle will remain sharp.
   *
   * Note: An angle lower than 0.1 will cause all smoothing to be disabled, this can be used to
   * increase performance.
   */
  public final inline var smoothingAngle: Float
    @JvmName("smoothingAngleProperty")
    get() = getSmoothingAngle()
    @JvmName("smoothingAngleProperty")
    set(`value`) {
      setSmoothingAngle(value)
    }

  /**
   * The operation that is performed on this shape. This is ignored for the first CSG child node as
   * the operation is between this node and the previous child of this nodes parent.
   */
  public final inline var operation: Operation
    @JvmName("operationProperty")
    get() = getOperation()
    @JvmName("operationProperty")
    set(`value`) {
      setOperation(value)
    }

  /**
   * This property does nothing.
   */
  public final inline var snap: Float
    @JvmName("snapProperty")
    get() = getSnap()
    @JvmName("snapProperty")
    set(`value`) {
      setSnap(value)
    }

  /**
   * Calculate tangents for the CSG shape which allows the use of normal and height maps. This is
   * only applied on the root shape, this setting is ignored on any child. Setting this to `false` can
   * speed up shape generation slightly.
   */
  public final inline var calculateTangents: Boolean
    @JvmName("calculateTangentsProperty")
    get() = isCalculatingTangents()
    @JvmName("calculateTangentsProperty")
    set(`value`) {
      setCalculateTangents(value)
    }

  /**
   * Adds a collision shape to the physics engine for our CSG shape. This will always act like a
   * static body. Note that the collision shape is still active even if the CSG shape itself is hidden.
   * See also [collisionMask] and [collisionPriority].
   */
  public final inline var useCollision: Boolean
    @JvmName("useCollisionProperty")
    get() = isUsingCollision()
    @JvmName("useCollisionProperty")
    set(`value`) {
      setUseCollision(value)
    }

  /**
   * The physics layers this area is in.
   *
   * Collidable objects can exist in any of 32 different layers. These layers work like a tagging
   * system, and are not visual. A collidable can use these layers to select with which objects it can
   * collide, using the collision_mask property.
   *
   * A contact is detected if object A is in any of the layers that object B scans, or object B is
   * in any layer scanned by object A. See
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
   * The physics layers this CSG shape scans for collisions. Only effective if [useCollision] is
   * `true`. See
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
   * The priority used to solve colliding when occurring penetration. Only effective if
   * [useCollision] is `true`. The higher the priority is, the lower the penetration into the object
   * will be. This can for example be used to prevent the player from breaking through the boundaries
   * of a level.
   */
  public final inline var collisionPriority: Float
    @JvmName("collisionPriorityProperty")
    get() = getCollisionPriority()
    @JvmName("collisionPriorityProperty")
    set(`value`) {
      setCollisionPriority(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(129, scriptPtr)
  }

  /**
   * Returns `true` if this is a root shape and is thus the object that is rendered.
   */
  public final fun isRootShape(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isRootShapePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setOperation(operation: Operation): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, operation.value)
    TransferContext.callPtrMethod(MethodBindings.setOperationPtr, 0)
  }

  public final fun getOperation(): Operation {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOperationPtr, 2)
    return Operation.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSnap(snap: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, snap.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSnapPtr, 0)
  }

  public final fun getSnap(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSnapPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setUseCollision(operation: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, operation)
    TransferContext.callPtrMethod(MethodBindings.setUseCollisionPtr, 0)
  }

  public final fun isUsingCollision(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isUsingCollisionPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCollisionLayer(layer: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layer)
    TransferContext.callPtrMethod(MethodBindings.setCollisionLayerPtr, 0)
  }

  public final fun getCollisionLayer(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionLayerPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setCollisionMask(mask: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mask)
    TransferContext.callPtrMethod(MethodBindings.setCollisionMaskPtr, 0)
  }

  public final fun getCollisionMask(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionMaskPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Based on [value], enables or disables the specified layer in the [collisionMask], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layerNumber.toLong(), value)
    TransferContext.callPtrMethod(MethodBindings.setCollisionMaskValuePtr, 0)
  }

  /**
   * Returns whether or not the specified layer of the [collisionMask] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layerNumber.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCollisionMaskValuePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Based on [value], enables or disables the specified layer in the [collisionLayer], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionLayerValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layerNumber.toLong(), value)
    TransferContext.callPtrMethod(MethodBindings.setCollisionLayerValuePtr, 0)
  }

  /**
   * Returns whether or not the specified layer of the [collisionLayer] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionLayerValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layerNumber.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCollisionLayerValuePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCollisionPriority(priority: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, priority.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCollisionPriorityPtr, 0)
  }

  public final fun getCollisionPriority(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCollisionPriorityPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns a baked physics [ConcavePolygonShape3D] of this node's CSG operation result. Returns an
   * empty shape if the node is not a CSG root node or has no valid geometry.
   *
   * **Performance:** If the CSG operation results in a very detailed geometry with many faces
   * physics performance will be very slow. Concave shapes should in general only be used for static
   * level geometry and not with dynamic objects that are moving.
   *
   * **Note:** CSG mesh data updates are deferred, which means they are updated with a delay of one
   * rendered frame. To avoid getting an empty shape or outdated mesh data, make sure to call `await
   * get_tree().process_frame` before using [bakeCollisionShape] in [Node.Ready] or after changing
   * properties on the [CSGShape3D].
   */
  public final fun bakeCollisionShape(): ConcavePolygonShape3D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.bakeCollisionShapePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as ConcavePolygonShape3D?)
  }

  public final fun setCalculateTangents(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setCalculateTangentsPtr, 0)
  }

  public final fun isCalculatingTangents(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCalculatingTangentsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns an [VariantArray] with two elements, the first is the [Transform3D] of this node and
   * the second is the root [Mesh] of this node. Only works when this node is the root shape.
   *
   * **Note:** CSG mesh data updates are deferred, which means they are updated with a delay of one
   * rendered frame. To avoid getting an empty shape or outdated mesh data, make sure to call `await
   * get_tree().process_frame` before using [getMeshes] in [Node.Ready] or after changing properties on
   * the [CSGShape3D].
   */
  public final fun getMeshes(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * Returns a baked static [ArrayMesh] of this node's CSG operation result. Materials from involved
   * CSG nodes are added as extra mesh surfaces. Returns an empty mesh if the node is not a CSG root
   * node or has no valid geometry.
   *
   * **Note:** CSG mesh data updates are deferred, which means they are updated with a delay of one
   * rendered frame. To avoid getting an empty mesh or outdated mesh data, make sure to call `await
   * get_tree().process_frame` before using [bakeStaticMesh] in [Node.Ready] or after changing
   * properties on the [CSGShape3D].
   */
  public final fun bakeStaticMesh(): ArrayMesh? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.bakeStaticMeshPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as ArrayMesh?)
  }

  public final fun setAutosmooth(autosmooth: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, autosmooth)
    TransferContext.callPtrMethod(MethodBindings.setAutosmoothPtr, 0)
  }

  public final fun isAutosmooth(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAutosmoothPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSmoothingAngle(smoothingAngle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, smoothingAngle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSmoothingAnglePtr, 0)
  }

  public final fun getSmoothingAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSmoothingAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public enum class Operation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Geometry of both primitives is merged, intersecting geometry is removed.
     */
    UNION(0),
    /**
     * Only intersecting geometry remains, the rest is removed.
     */
    INTERSECTION(1),
    /**
     * The second shape is subtracted from the first, leaving a dent with its shape.
     */
    SUBTRACTION(2),
    ;

    public companion object {
      public fun from(`value`: Long): Operation = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val isRootShapeName: MethodStringName0<CSGShape3D, Boolean> =
        MethodStringName0<CSGShape3D, Boolean>("is_root_shape")

    @JvmField
    public val setOperationName: MethodStringName1<CSGShape3D, Unit, Operation> =
        MethodStringName1<CSGShape3D, Unit, Operation>("set_operation")

    @JvmField
    public val getOperationName: MethodStringName0<CSGShape3D, Operation> =
        MethodStringName0<CSGShape3D, Operation>("get_operation")

    @JvmField
    public val setSnapName: MethodStringName1<CSGShape3D, Unit, Float> =
        MethodStringName1<CSGShape3D, Unit, Float>("set_snap")

    @JvmField
    public val getSnapName: MethodStringName0<CSGShape3D, Float> =
        MethodStringName0<CSGShape3D, Float>("get_snap")

    @JvmField
    public val setUseCollisionName: MethodStringName1<CSGShape3D, Unit, Boolean> =
        MethodStringName1<CSGShape3D, Unit, Boolean>("set_use_collision")

    @JvmField
    public val isUsingCollisionName: MethodStringName0<CSGShape3D, Boolean> =
        MethodStringName0<CSGShape3D, Boolean>("is_using_collision")

    @JvmField
    public val setCollisionLayerName: MethodStringName1<CSGShape3D, Unit, Long> =
        MethodStringName1<CSGShape3D, Unit, Long>("set_collision_layer")

    @JvmField
    public val getCollisionLayerName: MethodStringName0<CSGShape3D, Long> =
        MethodStringName0<CSGShape3D, Long>("get_collision_layer")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<CSGShape3D, Unit, Long> =
        MethodStringName1<CSGShape3D, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<CSGShape3D, Long> =
        MethodStringName0<CSGShape3D, Long>("get_collision_mask")

    @JvmField
    public val setCollisionMaskValueName: MethodStringName2<CSGShape3D, Unit, Int, Boolean> =
        MethodStringName2<CSGShape3D, Unit, Int, Boolean>("set_collision_mask_value")

    @JvmField
    public val getCollisionMaskValueName: MethodStringName1<CSGShape3D, Boolean, Int> =
        MethodStringName1<CSGShape3D, Boolean, Int>("get_collision_mask_value")

    @JvmField
    public val setCollisionLayerValueName: MethodStringName2<CSGShape3D, Unit, Int, Boolean> =
        MethodStringName2<CSGShape3D, Unit, Int, Boolean>("set_collision_layer_value")

    @JvmField
    public val getCollisionLayerValueName: MethodStringName1<CSGShape3D, Boolean, Int> =
        MethodStringName1<CSGShape3D, Boolean, Int>("get_collision_layer_value")

    @JvmField
    public val setCollisionPriorityName: MethodStringName1<CSGShape3D, Unit, Float> =
        MethodStringName1<CSGShape3D, Unit, Float>("set_collision_priority")

    @JvmField
    public val getCollisionPriorityName: MethodStringName0<CSGShape3D, Float> =
        MethodStringName0<CSGShape3D, Float>("get_collision_priority")

    @JvmField
    public val bakeCollisionShapeName: MethodStringName0<CSGShape3D, ConcavePolygonShape3D?> =
        MethodStringName0<CSGShape3D, ConcavePolygonShape3D?>("bake_collision_shape")

    @JvmField
    public val setCalculateTangentsName: MethodStringName1<CSGShape3D, Unit, Boolean> =
        MethodStringName1<CSGShape3D, Unit, Boolean>("set_calculate_tangents")

    @JvmField
    public val isCalculatingTangentsName: MethodStringName0<CSGShape3D, Boolean> =
        MethodStringName0<CSGShape3D, Boolean>("is_calculating_tangents")

    @JvmField
    public val getMeshesName: MethodStringName0<CSGShape3D, VariantArray<Any?>> =
        MethodStringName0<CSGShape3D, VariantArray<Any?>>("get_meshes")

    @JvmField
    public val bakeStaticMeshName: MethodStringName0<CSGShape3D, ArrayMesh?> =
        MethodStringName0<CSGShape3D, ArrayMesh?>("bake_static_mesh")

    @JvmField
    public val setAutosmoothName: MethodStringName1<CSGShape3D, Unit, Boolean> =
        MethodStringName1<CSGShape3D, Unit, Boolean>("set_autosmooth")

    @JvmField
    public val isAutosmoothName: MethodStringName0<CSGShape3D, Boolean> =
        MethodStringName0<CSGShape3D, Boolean>("is_autosmooth")

    @JvmField
    public val setSmoothingAngleName: MethodStringName1<CSGShape3D, Unit, Float> =
        MethodStringName1<CSGShape3D, Unit, Float>("set_smoothing_angle")

    @JvmField
    public val getSmoothingAngleName: MethodStringName0<CSGShape3D, Float> =
        MethodStringName0<CSGShape3D, Float>("get_smoothing_angle")
  }

  public object MethodBindings {
    internal val isRootShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "is_root_shape", 36873697)

    internal val setOperationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_operation", 811425055)

    internal val getOperationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_operation", 2662425879)

    internal val setSnapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_snap", 373806689)

    internal val getSnapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_snap", 1740695150)

    internal val setUseCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_use_collision", 2586408642)

    internal val isUsingCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "is_using_collision", 36873697)

    internal val setCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_collision_layer", 1286410249)

    internal val getCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_collision_layer", 3905245786)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_collision_mask", 3905245786)

    internal val setCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_collision_mask_value", 300928843)

    internal val getCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_collision_mask_value", 1116898809)

    internal val setCollisionLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_collision_layer_value", 300928843)

    internal val getCollisionLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_collision_layer_value", 1116898809)

    internal val setCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_collision_priority", 373806689)

    internal val getCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_collision_priority", 1740695150)

    internal val bakeCollisionShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "bake_collision_shape", 36102322)

    internal val setCalculateTangentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_calculate_tangents", 2586408642)

    internal val isCalculatingTangentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "is_calculating_tangents", 36873697)

    internal val getMeshesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_meshes", 3995934104)

    internal val bakeStaticMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "bake_static_mesh", 1605880883)

    internal val setAutosmoothPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_autosmooth", 2586408642)

    internal val isAutosmoothPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "is_autosmooth", 36873697)

    internal val setSmoothingAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "set_smoothing_angle", 373806689)

    internal val getSmoothingAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGShape3D", "get_smoothing_angle", 1740695150)
  }
}
