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
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedVector2Array
import godot.core.RID
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser._RID
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An obstacle needs a navigation map and outline [vertices] defined to work correctly. The outlines
 * can not cross or overlap.
 *
 * Obstacles can be included in the navigation mesh baking process when [affectNavigationMesh] is
 * enabled. They do not add walkable geometry, instead their role is to discard other source geometry
 * inside the shape. This can be used to prevent navigation mesh from appearing in unwanted places. If
 * [carveNavigationMesh] is enabled the baked shape will not be affected by offsets of the navigation
 * mesh baking, e.g. the agent radius.
 *
 * With [avoidanceEnabled] the obstacle can constrain the avoidance velocities of avoidance using
 * agents. If the obstacle's vertices are wound in clockwise order, avoidance agents will be pushed in
 * by the obstacle, otherwise, avoidance agents will be pushed out. Obstacles using vertices and
 * avoidance can warp to a new position but should not be moved every single frame as each change
 * requires a rebuild of the avoidance map.
 */
@GodotBaseType
public open class NavigationObstacle2D : Node2D() {
  /**
   * Sets the avoidance radius for the obstacle.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * The outline vertices of the obstacle. If the vertices are winded in clockwise order agents will
   * be pushed in by the obstacle, else they will be pushed out. Outlines can not be crossed or
   * overlap. Should the vertices using obstacle be warped to a new position agent's can not predict
   * this movement and may get trapped inside the obstacle.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var vertices: PackedVector2Array
    @JvmName("verticesProperty")
    get() = getVertices()
    @JvmName("verticesProperty")
    set(`value`) {
      setVertices(value)
    }

  /**
   * If enabled and parsed in a navigation mesh baking process the obstacle will discard source
   * geometry inside its [vertices] defined shape.
   */
  public final inline var affectNavigationMesh: Boolean
    @JvmName("affectNavigationMeshProperty")
    get() = getAffectNavigationMesh()
    @JvmName("affectNavigationMeshProperty")
    set(`value`) {
      setAffectNavigationMesh(value)
    }

  /**
   * If enabled the obstacle vertices will carve into the baked navigation mesh with the shape
   * unaffected by additional offsets (e.g. agent radius).
   *
   * It will still be affected by further postprocessing of the baking process, like edge and
   * polygon simplification.
   *
   * Requires [affectNavigationMesh] to be enabled.
   */
  public final inline var carveNavigationMesh: Boolean
    @JvmName("carveNavigationMeshProperty")
    get() = getCarveNavigationMesh()
    @JvmName("carveNavigationMeshProperty")
    set(`value`) {
      setCarveNavigationMesh(value)
    }

  /**
   * If `true` the obstacle affects avoidance using agents.
   */
  public final inline var avoidanceEnabled: Boolean
    @JvmName("avoidanceEnabledProperty")
    get() = getAvoidanceEnabled()
    @JvmName("avoidanceEnabledProperty")
    set(`value`) {
      setAvoidanceEnabled(value)
    }

  /**
   * Sets the wanted velocity for the obstacle so other agent's can better predict the obstacle if
   * it is moved with a velocity regularly (every frame) instead of warped to a new position. Does only
   * affect avoidance for the obstacles [radius]. Does nothing for the obstacles static vertices.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var velocity: Vector2
    @JvmName("velocityProperty")
    get() = getVelocity()
    @JvmName("velocityProperty")
    set(`value`) {
      setVelocity(value)
    }

  /**
   * A bitfield determining the avoidance layers for this obstacle. Agents with a matching bit on
   * the their avoidance mask will avoid this obstacle.
   */
  public final inline var avoidanceLayers: Long
    @JvmName("avoidanceLayersProperty")
    get() = getAvoidanceLayers()
    @JvmName("avoidanceLayersProperty")
    set(`value`) {
      setAvoidanceLayers(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(407, scriptPtr)
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationobstacle2d.vertices
   * //Your changes
   * navigationobstacle2d.vertices = myCoreType
   * ``````
   *
   * The outline vertices of the obstacle. If the vertices are winded in clockwise order agents will
   * be pushed in by the obstacle, else they will be pushed out. Outlines can not be crossed or
   * overlap. Should the vertices using obstacle be warped to a new position agent's can not predict
   * this movement and may get trapped inside the obstacle.
   */
  @CoreTypeHelper
  public final fun verticesMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
      vertices.apply {
     block(this)
     vertices = this
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The outline vertices of the obstacle. If the vertices are winded in clockwise order agents will
   * be pushed in by the obstacle, else they will be pushed out. Outlines can not be crossed or
   * overlap. Should the vertices using obstacle be warped to a new position agent's can not predict
   * this movement and may get trapped inside the obstacle.
   */
  @CoreTypeHelper
  public final fun verticesMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = vertices.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     vertices = this
  }

  /**
   * This is a helper function for [velocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationobstacle2d.velocity
   * //Your changes
   * navigationobstacle2d.velocity = myCoreType
   * ``````
   *
   * Sets the wanted velocity for the obstacle so other agent's can better predict the obstacle if
   * it is moved with a velocity regularly (every frame) instead of warped to a new position. Does only
   * affect avoidance for the obstacles [radius]. Does nothing for the obstacles static vertices.
   */
  @CoreTypeHelper
  public final fun velocityMutate(block: Vector2.() -> Unit): Vector2 = velocity.apply {
     block(this)
     velocity = this
  }

  /**
   * Returns the [RID] of this obstacle on the [NavigationServer2D].
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setAvoidanceEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAvoidanceEnabledPtr)
  }

  public final fun getAvoidanceEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAvoidanceEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the [RID] of the navigation map this NavigationObstacle node should use and also updates
   * the `obstacle` on the NavigationServer.
   */
  public final fun setNavigationMap(navigationMap: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to navigationMap)
    TransferContext.callMethod(MethodBindings.setNavigationMapPtr)
  }

  /**
   * Returns the [RID] of the navigation map for this NavigationObstacle node. This function returns
   * always the map set on the NavigationObstacle node and not the map of the abstract obstacle on the
   * NavigationServer. If the obstacle map is changed directly with the NavigationServer API the
   * NavigationObstacle node will not be aware of the map change. Use [setNavigationMap] to change the
   * navigation map for the NavigationObstacle and also update the obstacle on the NavigationServer.
   */
  public final fun getNavigationMap(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationMapPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setRadiusPtr)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVelocity(velocity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to velocity)
    TransferContext.callMethod(MethodBindings.setVelocityPtr)
  }

  public final fun getVelocity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setVertices(vertices: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to vertices)
    TransferContext.callMethod(MethodBindings.setVerticesPtr)
  }

  public final fun getVertices(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVerticesPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  public final fun setAvoidanceLayers(layers: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layers)
    TransferContext.callMethod(MethodBindings.setAvoidanceLayersPtr)
  }

  public final fun getAvoidanceLayers(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAvoidanceLayersPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Based on [value], enables or disables the specified layer in the [avoidanceLayers] bitmask,
   * given a [layerNumber] between 1 and 32.
   */
  public final fun setAvoidanceLayerValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setAvoidanceLayerValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [avoidanceLayers] bitmask is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getAvoidanceLayerValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getAvoidanceLayerValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAffectNavigationMesh(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAffectNavigationMeshPtr)
  }

  public final fun getAffectNavigationMesh(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAffectNavigationMeshPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCarveNavigationMesh(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCarveNavigationMeshPtr)
  }

  public final fun getCarveNavigationMesh(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCarveNavigationMeshPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val getRidName: MethodStringName0<NavigationObstacle2D, RID> =
        MethodStringName0<NavigationObstacle2D, RID>("get_rid")

    @JvmField
    public val setAvoidanceEnabledName: MethodStringName1<NavigationObstacle2D, Unit, Boolean> =
        MethodStringName1<NavigationObstacle2D, Unit, Boolean>("set_avoidance_enabled")

    @JvmField
    public val getAvoidanceEnabledName: MethodStringName0<NavigationObstacle2D, Boolean> =
        MethodStringName0<NavigationObstacle2D, Boolean>("get_avoidance_enabled")

    @JvmField
    public val setNavigationMapName: MethodStringName1<NavigationObstacle2D, Unit, RID> =
        MethodStringName1<NavigationObstacle2D, Unit, RID>("set_navigation_map")

    @JvmField
    public val getNavigationMapName: MethodStringName0<NavigationObstacle2D, RID> =
        MethodStringName0<NavigationObstacle2D, RID>("get_navigation_map")

    @JvmField
    public val setRadiusName: MethodStringName1<NavigationObstacle2D, Unit, Float> =
        MethodStringName1<NavigationObstacle2D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<NavigationObstacle2D, Float> =
        MethodStringName0<NavigationObstacle2D, Float>("get_radius")

    @JvmField
    public val setVelocityName: MethodStringName1<NavigationObstacle2D, Unit, Vector2> =
        MethodStringName1<NavigationObstacle2D, Unit, Vector2>("set_velocity")

    @JvmField
    public val getVelocityName: MethodStringName0<NavigationObstacle2D, Vector2> =
        MethodStringName0<NavigationObstacle2D, Vector2>("get_velocity")

    @JvmField
    public val setVerticesName: MethodStringName1<NavigationObstacle2D, Unit, PackedVector2Array> =
        MethodStringName1<NavigationObstacle2D, Unit, PackedVector2Array>("set_vertices")

    @JvmField
    public val getVerticesName: MethodStringName0<NavigationObstacle2D, PackedVector2Array> =
        MethodStringName0<NavigationObstacle2D, PackedVector2Array>("get_vertices")

    @JvmField
    public val setAvoidanceLayersName: MethodStringName1<NavigationObstacle2D, Unit, Long> =
        MethodStringName1<NavigationObstacle2D, Unit, Long>("set_avoidance_layers")

    @JvmField
    public val getAvoidanceLayersName: MethodStringName0<NavigationObstacle2D, Long> =
        MethodStringName0<NavigationObstacle2D, Long>("get_avoidance_layers")

    @JvmField
    public val setAvoidanceLayerValueName:
        MethodStringName2<NavigationObstacle2D, Unit, Int, Boolean> =
        MethodStringName2<NavigationObstacle2D, Unit, Int, Boolean>("set_avoidance_layer_value")

    @JvmField
    public val getAvoidanceLayerValueName: MethodStringName1<NavigationObstacle2D, Boolean, Int> =
        MethodStringName1<NavigationObstacle2D, Boolean, Int>("get_avoidance_layer_value")

    @JvmField
    public val setAffectNavigationMeshName: MethodStringName1<NavigationObstacle2D, Unit, Boolean> =
        MethodStringName1<NavigationObstacle2D, Unit, Boolean>("set_affect_navigation_mesh")

    @JvmField
    public val getAffectNavigationMeshName: MethodStringName0<NavigationObstacle2D, Boolean> =
        MethodStringName0<NavigationObstacle2D, Boolean>("get_affect_navigation_mesh")

    @JvmField
    public val setCarveNavigationMeshName: MethodStringName1<NavigationObstacle2D, Unit, Boolean> =
        MethodStringName1<NavigationObstacle2D, Unit, Boolean>("set_carve_navigation_mesh")

    @JvmField
    public val getCarveNavigationMeshName: MethodStringName0<NavigationObstacle2D, Boolean> =
        MethodStringName0<NavigationObstacle2D, Boolean>("get_carve_navigation_mesh")
  }

  public object MethodBindings {
    internal val getRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_rid", 2944877500)

    internal val setAvoidanceEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_avoidance_enabled", 2586408642)

    internal val getAvoidanceEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_avoidance_enabled", 36873697)

    internal val setNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_navigation_map", 2722037293)

    internal val getNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_navigation_map", 2944877500)

    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_radius", 1740695150)

    internal val setVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_velocity", 743155724)

    internal val getVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_velocity", 3341600327)

    internal val setVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_vertices", 1509147220)

    internal val getVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_vertices", 2961356807)

    internal val setAvoidanceLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_avoidance_layers", 1286410249)

    internal val getAvoidanceLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_avoidance_layers", 3905245786)

    internal val setAvoidanceLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_avoidance_layer_value", 300928843)

    internal val getAvoidanceLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_avoidance_layer_value", 1116898809)

    internal val setAffectNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_affect_navigation_mesh", 2586408642)

    internal val getAffectNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_affect_navigation_mesh", 36873697)

    internal val setCarveNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "set_carve_navigation_mesh", 2586408642)

    internal val getCarveNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationObstacle2D", "get_carve_navigation_mesh", 36873697)
  }
}
