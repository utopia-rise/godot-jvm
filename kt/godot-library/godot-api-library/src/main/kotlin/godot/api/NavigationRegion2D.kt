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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.Rect2
import godot.core.Signal0
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RECT2
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
 * A traversable 2D region based on a [NavigationPolygon] that [NavigationAgent2D]s can use for
 * pathfinding.
 *
 * Two regions can be connected to each other if they share a similar edge. You can set the minimum
 * distance between two vertices required to connect two edges by using
 * [NavigationServer2D.mapSetEdgeConnectionMargin].
 *
 * **Note:** Overlapping two regions' navigation polygons is not enough for connecting two regions.
 * They must share a similar edge.
 *
 * The pathfinding cost of entering a region from another region can be controlled with the
 * [enterCost] value.
 *
 * **Note:** This value is not added to the path cost when the start position is already inside this
 * region.
 *
 * The pathfinding cost of traveling distances inside this region can be controlled with the
 * [travelCost] multiplier.
 *
 * **Note:** This node caches changes to its properties, so if you make changes to the underlying
 * region [RID] in [NavigationServer2D], they will not be reflected in this node's properties.
 */
@GodotBaseType
public open class NavigationRegion2D : Node2D() {
  /**
   * Emitted when the used navigation polygon is replaced or changes to the internals of the current
   * navigation polygon are committed.
   */
  public val navigationPolygonChanged: Signal0 by Signal0

  /**
   * Emitted when a navigation polygon bake operation is completed.
   */
  public val bakeFinished: Signal0 by Signal0

  /**
   * The [NavigationPolygon] resource to use.
   */
  public final inline var navigationPolygon: NavigationPolygon?
    @JvmName("navigationPolygonProperty")
    get() = getNavigationPolygon()
    @JvmName("navigationPolygonProperty")
    set(`value`) {
      setNavigationPolygon(value)
    }

  /**
   * Determines if the [NavigationRegion2D] is enabled or disabled.
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
   * be checked upon when requesting a path with [NavigationServer2D.mapGetPath].
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
    createNativeObject(412, scriptPtr)
  }

  /**
   * Returns the [RID] of this region on the [NavigationServer2D]. Combined with
   * [NavigationServer2D.mapGetClosestPointOwner] can be used to identify the [NavigationRegion2D]
   * closest to a point on the merged navigation map.
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRidPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setNavigationPolygon(navigationPolygon: NavigationPolygon?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, navigationPolygon)
    TransferContext.callMethod(MethodBindings.setNavigationPolygonPtr)
  }

  public final fun getNavigationPolygon(): NavigationPolygon? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationPolygonPtr)
    return (TransferContext.readReturnValue_OBJECT() as NavigationPolygon?)
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
   * automatically join the [World2D] default navigation map so this function is only required to
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
   * Returns the [RID] of this region on the [NavigationServer2D].
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
   * Bakes the [NavigationPolygon]. If [onThread] is set to `true` (default), the baking is done on
   * a separate thread.
   */
  @JvmOverloads
  public final fun bakeNavigationPolygon(onThread: Boolean = true): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, onThread)
    TransferContext.callMethod(MethodBindings.bakeNavigationPolygonPtr)
  }

  /**
   * Returns `true` when the [NavigationPolygon] is being baked on a background thread.
   */
  public final fun isBaking(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBakingPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the axis-aligned rectangle for the region's transformed navigation mesh.
   */
  public final fun getBounds(): Rect2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoundsPtr)
    return TransferContext.readReturnValue_RECT2()
  }

  public companion object {
    @JvmField
    public val getRidName: MethodStringName0<NavigationRegion2D, RID> =
        MethodStringName0<NavigationRegion2D, RID>("get_rid")

    @JvmField
    public val setNavigationPolygonName:
        MethodStringName1<NavigationRegion2D, Unit, NavigationPolygon?> =
        MethodStringName1<NavigationRegion2D, Unit, NavigationPolygon?>("set_navigation_polygon")

    @JvmField
    public val getNavigationPolygonName: MethodStringName0<NavigationRegion2D, NavigationPolygon?> =
        MethodStringName0<NavigationRegion2D, NavigationPolygon?>("get_navigation_polygon")

    @JvmField
    public val setEnabledName: MethodStringName1<NavigationRegion2D, Unit, Boolean> =
        MethodStringName1<NavigationRegion2D, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<NavigationRegion2D, Boolean> =
        MethodStringName0<NavigationRegion2D, Boolean>("is_enabled")

    @JvmField
    public val setNavigationMapName: MethodStringName1<NavigationRegion2D, Unit, RID> =
        MethodStringName1<NavigationRegion2D, Unit, RID>("set_navigation_map")

    @JvmField
    public val getNavigationMapName: MethodStringName0<NavigationRegion2D, RID> =
        MethodStringName0<NavigationRegion2D, RID>("get_navigation_map")

    @JvmField
    public val setUseEdgeConnectionsName: MethodStringName1<NavigationRegion2D, Unit, Boolean> =
        MethodStringName1<NavigationRegion2D, Unit, Boolean>("set_use_edge_connections")

    @JvmField
    public val getUseEdgeConnectionsName: MethodStringName0<NavigationRegion2D, Boolean> =
        MethodStringName0<NavigationRegion2D, Boolean>("get_use_edge_connections")

    @JvmField
    public val setNavigationLayersName: MethodStringName1<NavigationRegion2D, Unit, Long> =
        MethodStringName1<NavigationRegion2D, Unit, Long>("set_navigation_layers")

    @JvmField
    public val getNavigationLayersName: MethodStringName0<NavigationRegion2D, Long> =
        MethodStringName0<NavigationRegion2D, Long>("get_navigation_layers")

    @JvmField
    public val setNavigationLayerValueName:
        MethodStringName2<NavigationRegion2D, Unit, Int, Boolean> =
        MethodStringName2<NavigationRegion2D, Unit, Int, Boolean>("set_navigation_layer_value")

    @JvmField
    public val getNavigationLayerValueName: MethodStringName1<NavigationRegion2D, Boolean, Int> =
        MethodStringName1<NavigationRegion2D, Boolean, Int>("get_navigation_layer_value")

    @JvmField
    public val getRegionRidName: MethodStringName0<NavigationRegion2D, RID> =
        MethodStringName0<NavigationRegion2D, RID>("get_region_rid")

    @JvmField
    public val setEnterCostName: MethodStringName1<NavigationRegion2D, Unit, Float> =
        MethodStringName1<NavigationRegion2D, Unit, Float>("set_enter_cost")

    @JvmField
    public val getEnterCostName: MethodStringName0<NavigationRegion2D, Float> =
        MethodStringName0<NavigationRegion2D, Float>("get_enter_cost")

    @JvmField
    public val setTravelCostName: MethodStringName1<NavigationRegion2D, Unit, Float> =
        MethodStringName1<NavigationRegion2D, Unit, Float>("set_travel_cost")

    @JvmField
    public val getTravelCostName: MethodStringName0<NavigationRegion2D, Float> =
        MethodStringName0<NavigationRegion2D, Float>("get_travel_cost")

    @JvmField
    public val bakeNavigationPolygonName: MethodStringName1<NavigationRegion2D, Unit, Boolean> =
        MethodStringName1<NavigationRegion2D, Unit, Boolean>("bake_navigation_polygon")

    @JvmField
    public val isBakingName: MethodStringName0<NavigationRegion2D, Boolean> =
        MethodStringName0<NavigationRegion2D, Boolean>("is_baking")

    @JvmField
    public val getBoundsName: MethodStringName0<NavigationRegion2D, Rect2> =
        MethodStringName0<NavigationRegion2D, Rect2>("get_bounds")
  }

  public object MethodBindings {
    internal val getRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_rid", 2944877500)

    internal val setNavigationPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "set_navigation_polygon", 1515040758)

    internal val getNavigationPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_navigation_polygon", 1046532237)

    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "is_enabled", 36873697)

    internal val setNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "set_navigation_map", 2722037293)

    internal val getNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_navigation_map", 2944877500)

    internal val setUseEdgeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "set_use_edge_connections", 2586408642)

    internal val getUseEdgeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_use_edge_connections", 36873697)

    internal val setNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "set_navigation_layers", 1286410249)

    internal val getNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_navigation_layers", 3905245786)

    internal val setNavigationLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "set_navigation_layer_value", 300928843)

    internal val getNavigationLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_navigation_layer_value", 1116898809)

    internal val getRegionRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_region_rid", 2944877500)

    internal val setEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "set_enter_cost", 373806689)

    internal val getEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_enter_cost", 1740695150)

    internal val setTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "set_travel_cost", 373806689)

    internal val getTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_travel_cost", 1740695150)

    internal val bakeNavigationPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "bake_navigation_polygon", 3216645846)

    internal val isBakingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "is_baking", 36873697)

    internal val getBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationRegion2D", "get_bounds", 1639390495)
  }
}
