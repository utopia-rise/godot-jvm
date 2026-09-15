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
import godot.core.AABB
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.Signal0
import godot.readReturnValue_AABB
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_RID
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A traversable 3D region based on a [NavigationMesh] that [NavigationAgent3D]s can use for
 * pathfinding.
 *
 * Two regions can be connected to each other if they share a similar edge. You can set the minimum
 * distance between two vertices required to connect two edges by using
 * [NavigationServer3D.mapSetEdgeConnectionMargin].
 *
 * **Note:** Overlapping two regions' navigation meshes is not enough for connecting two regions.
 * They must share a similar edge.
 *
 * The cost of entering this region from another region can be controlled with the [enterCost]
 * value.
 *
 * **Note:** This value is not added to the path cost when the start position is already inside this
 * region.
 *
 * The cost of traveling distances inside this region can be controlled with the [travelCost]
 * multiplier.
 *
 * **Note:** This node caches changes to its properties, so if you make changes to the underlying
 * region [RID] in [NavigationServer3D], they will not be reflected in this node's properties.
 */
@GodotBaseType
public open class NavigationRegion3D : Node3D() {
  /**
   * Notifies when the [NavigationMesh] has changed.
   */
  public val navigationMeshChanged: Signal0 by Signal0

  /**
   * Notifies when the navigation mesh bake operation is completed.
   */
  public val bakeFinished: Signal0 by Signal0

  /**
   * The [NavigationMesh] resource to use.
   */
  public final inline var navigationMesh: NavigationMesh?
    @JvmName("navigationMeshProperty")
    get() = getNavigationMesh()
    @JvmName("navigationMeshProperty")
    set(`value`) {
      setNavigationMesh(value)
    }

  /**
   * Determines if the [NavigationRegion3D] is enabled or disabled.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = isEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * If enabled the navigation region will use edge connections to connect with other navigation
   * regions within proximity of the navigation map edge connection margin.
   */
  public final inline var useEdgeConnections: Boolean
    @JvmName("useEdgeConnectionsProperty")
    get() = getUseEdgeConnections()
    @JvmName("useEdgeConnectionsProperty")
    set(`value`) {
      setUseEdgeConnections(value)
    }

  /**
   * A bitfield determining all navigation layers the region belongs to. These navigation layers can
   * be checked upon when requesting a path with [NavigationServer3D.mapGetPath].
   */
  public final inline var navigationLayers: Long
    @JvmName("navigationLayersProperty")
    get() = getNavigationLayers()
    @JvmName("navigationLayersProperty")
    set(`value`) {
      setNavigationLayers(value)
    }

  /**
   * When pathfinding enters this region's navigation mesh from another regions navigation mesh the
   * [enterCost] value is added to the path distance for determining the shortest path.
   */
  public final inline var enterCost: Float
    @JvmName("enterCostProperty")
    get() = getEnterCost()
    @JvmName("enterCostProperty")
    set(`value`) {
      setEnterCost(value)
    }

  /**
   * When pathfinding moves inside this region's navigation mesh the traveled distances are
   * multiplied with [travelCost] for determining the shortest path.
   */
  public final inline var travelCost: Float
    @JvmName("travelCostProperty")
    get() = getTravelCost()
    @JvmName("travelCostProperty")
    set(`value`) {
      setTravelCost(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(413, scriptPtr)
  }

  /**
   * Returns the [RID] of this region on the [NavigationServer3D]. Combined with
   * [NavigationServer3D.mapGetClosestPointOwner] can be used to identify the [NavigationRegion3D]
   * closest to a point on the merged navigation map.
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRidPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setNavigationMesh(navigationMesh: NavigationMesh?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, navigationMesh)
    TransferContext.callMethod(MethodBindings.setNavigationMeshPtr)
  }

  public final fun getNavigationMesh(): NavigationMesh? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationMeshPtr)
    return (TransferContext.readReturnValue_OBJECT() as NavigationMesh?)
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setEnabledPtr)
  }

  public final fun isEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the [RID] of the navigation map this region should use. By default the region will
   * automatically join the [World3D] default navigation map so this function is only required to
   * override the default map.
   */
  public final fun setNavigationMap(navigationMap: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, navigationMap)
    TransferContext.callMethod(MethodBindings.setNavigationMapPtr)
  }

  /**
   * Returns the current navigation map [RID] used by this region.
   */
  public final fun getNavigationMap(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationMapPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setUseEdgeConnections(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setUseEdgeConnectionsPtr)
  }

  public final fun getUseEdgeConnections(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseEdgeConnectionsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setNavigationLayers(navigationLayers: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, navigationLayers)
    TransferContext.callMethod(MethodBindings.setNavigationLayersPtr)
  }

  public final fun getNavigationLayers(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationLayersPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Based on [value], enables or disables the specified layer in the [navigationLayers] bitmask,
   * given a [layerNumber] between 1 and 32.
   */
  public final fun setNavigationLayerValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layerNumber.toLong(), value)
    TransferContext.callMethod(MethodBindings.setNavigationLayerValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [navigationLayers] bitmask is enabled, given
   * a [layerNumber] between 1 and 32.
   */
  public final fun getNavigationLayerValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getNavigationLayerValuePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the [RID] of this region on the [NavigationServer3D].
   */
  public final fun getRegionRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRegionRidPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setEnterCost(enterCost: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, enterCost.toDouble())
    TransferContext.callMethod(MethodBindings.setEnterCostPtr)
  }

  public final fun getEnterCost(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnterCostPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setTravelCost(travelCost: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, travelCost.toDouble())
    TransferContext.callMethod(MethodBindings.setTravelCostPtr)
  }

  public final fun getTravelCost(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTravelCostPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Bakes the [NavigationMesh]. If [onThread] is set to `true` (default), the baking is done on a
   * separate thread. Baking on separate thread is useful because navigation baking is not a cheap
   * operation. When it is completed, it automatically sets the new [NavigationMesh]. Please note that
   * baking on separate thread may be very slow if geometry is parsed from meshes as async access to
   * each mesh involves heavy synchronization. Also, please note that baking on a separate thread is
   * automatically disabled on operating systems that cannot use threads (such as Web with threads
   * disabled).
   */
  @JvmOverloads
  public final fun bakeNavigationMesh(onThread: Boolean = true): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, onThread)
    TransferContext.callMethod(MethodBindings.bakeNavigationMeshPtr)
  }

  /**
   * Returns `true` when the [NavigationMesh] is being baked on a background thread.
   */
  public final fun isBaking(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBakingPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the axis-aligned bounding box for the region's transformed navigation mesh.
   */
  public final fun getBounds(): AABB {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoundsPtr)
    return TransferContext.readReturnValue_AABB()
  }

  public companion object {
    @JvmField
    public val getRidName: MethodStringName0<NavigationRegion3D, RID> =
        MethodStringName0<NavigationRegion3D, RID>("get_rid")

    @JvmField
    public val setNavigationMeshName: MethodStringName1<NavigationRegion3D, Unit, NavigationMesh?> =
        MethodStringName1<NavigationRegion3D, Unit, NavigationMesh?>("set_navigation_mesh")

    @JvmField
    public val getNavigationMeshName: MethodStringName0<NavigationRegion3D, NavigationMesh?> =
        MethodStringName0<NavigationRegion3D, NavigationMesh?>("get_navigation_mesh")

    @JvmField
    public val setEnabledName: MethodStringName1<NavigationRegion3D, Unit, Boolean> =
        MethodStringName1<NavigationRegion3D, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<NavigationRegion3D, Boolean> =
        MethodStringName0<NavigationRegion3D, Boolean>("is_enabled")

    @JvmField
    public val setNavigationMapName: MethodStringName1<NavigationRegion3D, Unit, RID> =
        MethodStringName1<NavigationRegion3D, Unit, RID>("set_navigation_map")

    @JvmField
    public val getNavigationMapName: MethodStringName0<NavigationRegion3D, RID> =
        MethodStringName0<NavigationRegion3D, RID>("get_navigation_map")

    @JvmField
    public val setUseEdgeConnectionsName: MethodStringName1<NavigationRegion3D, Unit, Boolean> =
        MethodStringName1<NavigationRegion3D, Unit, Boolean>("set_use_edge_connections")

    @JvmField
    public val getUseEdgeConnectionsName: MethodStringName0<NavigationRegion3D, Boolean> =
        MethodStringName0<NavigationRegion3D, Boolean>("get_use_edge_connections")

    @JvmField
    public val setNavigationLayersName: MethodStringName1<NavigationRegion3D, Unit, Long> =
        MethodStringName1<NavigationRegion3D, Unit, Long>("set_navigation_layers")

    @JvmField
    public val getNavigationLayersName: MethodStringName0<NavigationRegion3D, Long> =
        MethodStringName0<NavigationRegion3D, Long>("get_navigation_layers")

    @JvmField
    public val setNavigationLayerValueName:
        MethodStringName2<NavigationRegion3D, Unit, Int, Boolean> =
        MethodStringName2<NavigationRegion3D, Unit, Int, Boolean>("set_navigation_layer_value")

    @JvmField
    public val getNavigationLayerValueName: MethodStringName1<NavigationRegion3D, Boolean, Int> =
        MethodStringName1<NavigationRegion3D, Boolean, Int>("get_navigation_layer_value")

    @JvmField
    public val getRegionRidName: MethodStringName0<NavigationRegion3D, RID> =
        MethodStringName0<NavigationRegion3D, RID>("get_region_rid")

    @JvmField
    public val setEnterCostName: MethodStringName1<NavigationRegion3D, Unit, Float> =
        MethodStringName1<NavigationRegion3D, Unit, Float>("set_enter_cost")

    @JvmField
    public val getEnterCostName: MethodStringName0<NavigationRegion3D, Float> =
        MethodStringName0<NavigationRegion3D, Float>("get_enter_cost")

    @JvmField
    public val setTravelCostName: MethodStringName1<NavigationRegion3D, Unit, Float> =
        MethodStringName1<NavigationRegion3D, Unit, Float>("set_travel_cost")

    @JvmField
    public val getTravelCostName: MethodStringName0<NavigationRegion3D, Float> =
        MethodStringName0<NavigationRegion3D, Float>("get_travel_cost")

    @JvmField
    public val bakeNavigationMeshName: MethodStringName1<NavigationRegion3D, Unit, Boolean> =
        MethodStringName1<NavigationRegion3D, Unit, Boolean>("bake_navigation_mesh")

    @JvmField
    public val isBakingName: MethodStringName0<NavigationRegion3D, Boolean> =
        MethodStringName0<NavigationRegion3D, Boolean>("is_baking")

    @JvmField
    public val getBoundsName: MethodStringName0<NavigationRegion3D, AABB> =
        MethodStringName0<NavigationRegion3D, AABB>("get_bounds")
  }

  public object MethodBindings {
    internal val getRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_rid", 2944877500)

    internal val setNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "set_navigation_mesh", 2923361153)

    internal val getNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_navigation_mesh", 1468720886)

    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "is_enabled", 36873697)

    internal val setNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "set_navigation_map", 2722037293)

    internal val getNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_navigation_map", 2944877500)

    internal val setUseEdgeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "set_use_edge_connections", 2586408642)

    internal val getUseEdgeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_use_edge_connections", 36873697)

    internal val setNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "set_navigation_layers", 1286410249)

    internal val getNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_navigation_layers", 3905245786)

    internal val setNavigationLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "set_navigation_layer_value", 300928843)

    internal val getNavigationLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_navigation_layer_value", 1116898809)

    internal val getRegionRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_region_rid", 2944877500)

    internal val setEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "set_enter_cost", 373806689)

    internal val getEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_enter_cost", 1740695150)

    internal val setTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "set_travel_cost", 373806689)

    internal val getTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_travel_cost", 1740695150)

    internal val bakeNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "bake_navigation_mesh", 3216645846)

    internal val isBakingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "is_baking", 36873697)

    internal val getBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion3D", "get_bounds", 1068685055)
  }
}
