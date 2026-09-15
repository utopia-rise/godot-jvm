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
import godot.core.RID
import godot.core.Vector2
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_RID
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_VECTOR2
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A link between two positions on [NavigationRegion2D]s that agents can be routed through. These
 * positions can be on the same [NavigationRegion2D] or on two different ones. Links are useful to
 * express navigation methods other than traveling along the surface of the navigation polygon, such as
 * ziplines, teleporters, or gaps that can be jumped across.
 */
@GodotBaseType
public open class NavigationLink2D : Node2D() {
  /**
   * Whether this link is currently active. If `false`, [NavigationServer2D.mapGetPath] will ignore
   * this link.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = isEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * Whether this link can be traveled in both directions or only from [startPosition] to
   * [endPosition].
   */
  public final inline var bidirectional: Boolean
    @JvmName("bidirectionalProperty")
    get() = isBidirectional()
    @JvmName("bidirectionalProperty")
    set(`value`) {
      setBidirectional(value)
    }

  /**
   * A bitfield determining all navigation layers the link belongs to. These navigation layers will
   * be checked when requesting a path with [NavigationServer2D.mapGetPath].
   */
  public final inline var navigationLayers: Long
    @JvmName("navigationLayersProperty")
    get() = getNavigationLayers()
    @JvmName("navigationLayersProperty")
    set(`value`) {
      setNavigationLayers(value)
    }

  /**
   * Starting position of the link.
   *
   * This position will search out the nearest polygon in the navigation mesh to attach to.
   *
   * The distance the link will search is controlled by
   * [NavigationServer2D.mapSetLinkConnectionRadius].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var startPosition: Vector2
    @JvmName("startPositionProperty")
    get() = getStartPosition()
    @JvmName("startPositionProperty")
    set(`value`) {
      setStartPosition(value)
    }

  /**
   * Ending position of the link.
   *
   * This position will search out the nearest polygon in the navigation mesh to attach to.
   *
   * The distance the link will search is controlled by
   * [NavigationServer2D.mapSetLinkConnectionRadius].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var endPosition: Vector2
    @JvmName("endPositionProperty")
    get() = getEndPosition()
    @JvmName("endPositionProperty")
    set(`value`) {
      setEndPosition(value)
    }

  /**
   * When pathfinding enters this link from another regions navigation mesh the [enterCost] value is
   * added to the path distance for determining the shortest path.
   */
  public final inline var enterCost: Float
    @JvmName("enterCostProperty")
    get() = getEnterCost()
    @JvmName("enterCostProperty")
    set(`value`) {
      setEnterCost(value)
    }

  /**
   * When pathfinding moves along the link the traveled distance is multiplied with [travelCost] for
   * determining the shortest path.
   */
  public final inline var travelCost: Float
    @JvmName("travelCostProperty")
    get() = getTravelCost()
    @JvmName("travelCostProperty")
    set(`value`) {
      setTravelCost(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(399, scriptPtr)
  }

  /**
   * This is a helper function for [startPosition] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationlink2d.startPosition
   * //Your changes
   * navigationlink2d.startPosition = myCoreType
   * ``````
   *
   * Starting position of the link.
   *
   * This position will search out the nearest polygon in the navigation mesh to attach to.
   *
   * The distance the link will search is controlled by
   * [NavigationServer2D.mapSetLinkConnectionRadius].
   */
  @CoreTypeHelper
  public final fun startPositionMutate(block: Vector2.() -> Unit): Vector2 = startPosition.apply {
     block(this)
     startPosition = this
  }

  /**
   * This is a helper function for [endPosition] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationlink2d.endPosition
   * //Your changes
   * navigationlink2d.endPosition = myCoreType
   * ``````
   *
   * Ending position of the link.
   *
   * This position will search out the nearest polygon in the navigation mesh to attach to.
   *
   * The distance the link will search is controlled by
   * [NavigationServer2D.mapSetLinkConnectionRadius].
   */
  @CoreTypeHelper
  public final fun endPositionMutate(block: Vector2.() -> Unit): Vector2 = endPosition.apply {
     block(this)
     endPosition = this
  }

  /**
   * Returns the [RID] of this link on the [NavigationServer2D].
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setEnabledPtr, 0)
  }

  public final fun isEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the [RID] of the navigation map this link should use. By default the link will
   * automatically join the [World2D] default navigation map so this function is only required to
   * override the default map.
   */
  public final fun setNavigationMap(navigationMap: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, navigationMap)
    TransferContext.callPtrMethod(MethodBindings.setNavigationMapPtr, 0)
  }

  /**
   * Returns the current navigation map [RID] used by this link.
   */
  public final fun getNavigationMap(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNavigationMapPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setBidirectional(bidirectional: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, bidirectional)
    TransferContext.callPtrMethod(MethodBindings.setBidirectionalPtr, 0)
  }

  public final fun isBidirectional(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isBidirectionalPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setNavigationLayers(navigationLayers: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, navigationLayers)
    TransferContext.callPtrMethod(MethodBindings.setNavigationLayersPtr, 0)
  }

  public final fun getNavigationLayers(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNavigationLayersPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Based on [value], enables or disables the specified layer in the [navigationLayers] bitmask,
   * given a [layerNumber] between 1 and 32.
   */
  public final fun setNavigationLayerValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layerNumber.toLong(), value)
    TransferContext.callPtrMethod(MethodBindings.setNavigationLayerValuePtr, 0)
  }

  /**
   * Returns whether or not the specified layer of the [navigationLayers] bitmask is enabled, given
   * a [layerNumber] between 1 and 32.
   */
  public final fun getNavigationLayerValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layerNumber.toLong())
    TransferContext.callPtrMethod(MethodBindings.getNavigationLayerValuePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setStartPosition(position: Vector2): Unit {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, position)
    TransferContext.callPtrMethod(MethodBindings.setStartPositionPtr, 0)
  }

  public final fun getStartPosition(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStartPositionPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  public final fun setEndPosition(position: Vector2): Unit {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, position)
    TransferContext.callPtrMethod(MethodBindings.setEndPositionPtr, 0)
  }

  public final fun getEndPosition(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEndPositionPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Sets the [startPosition] that is relative to the link from a global [position].
   */
  public final fun setGlobalStartPosition(position: Vector2): Unit {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, position)
    TransferContext.callPtrMethod(MethodBindings.setGlobalStartPositionPtr, 0)
  }

  /**
   * Returns the [startPosition] that is relative to the link as a global position.
   */
  public final fun getGlobalStartPosition(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGlobalStartPositionPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Sets the [endPosition] that is relative to the link from a global [position].
   */
  public final fun setGlobalEndPosition(position: Vector2): Unit {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, position)
    TransferContext.callPtrMethod(MethodBindings.setGlobalEndPositionPtr, 0)
  }

  /**
   * Returns the [endPosition] that is relative to the link as a global position.
   */
  public final fun getGlobalEndPosition(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGlobalEndPositionPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  public final fun setEnterCost(enterCost: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, enterCost.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setEnterCostPtr, 0)
  }

  public final fun getEnterCost(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEnterCostPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setTravelCost(travelCost: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, travelCost.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setTravelCostPtr, 0)
  }

  public final fun getTravelCost(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTravelCostPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val getRidName: MethodStringName0<NavigationLink2D, RID> =
        MethodStringName0<NavigationLink2D, RID>("get_rid")

    @JvmField
    public val setEnabledName: MethodStringName1<NavigationLink2D, Unit, Boolean> =
        MethodStringName1<NavigationLink2D, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<NavigationLink2D, Boolean> =
        MethodStringName0<NavigationLink2D, Boolean>("is_enabled")

    @JvmField
    public val setNavigationMapName: MethodStringName1<NavigationLink2D, Unit, RID> =
        MethodStringName1<NavigationLink2D, Unit, RID>("set_navigation_map")

    @JvmField
    public val getNavigationMapName: MethodStringName0<NavigationLink2D, RID> =
        MethodStringName0<NavigationLink2D, RID>("get_navigation_map")

    @JvmField
    public val setBidirectionalName: MethodStringName1<NavigationLink2D, Unit, Boolean> =
        MethodStringName1<NavigationLink2D, Unit, Boolean>("set_bidirectional")

    @JvmField
    public val isBidirectionalName: MethodStringName0<NavigationLink2D, Boolean> =
        MethodStringName0<NavigationLink2D, Boolean>("is_bidirectional")

    @JvmField
    public val setNavigationLayersName: MethodStringName1<NavigationLink2D, Unit, Long> =
        MethodStringName1<NavigationLink2D, Unit, Long>("set_navigation_layers")

    @JvmField
    public val getNavigationLayersName: MethodStringName0<NavigationLink2D, Long> =
        MethodStringName0<NavigationLink2D, Long>("get_navigation_layers")

    @JvmField
    public val setNavigationLayerValueName: MethodStringName2<NavigationLink2D, Unit, Int, Boolean>
        = MethodStringName2<NavigationLink2D, Unit, Int, Boolean>("set_navigation_layer_value")

    @JvmField
    public val getNavigationLayerValueName: MethodStringName1<NavigationLink2D, Boolean, Int> =
        MethodStringName1<NavigationLink2D, Boolean, Int>("get_navigation_layer_value")

    @JvmField
    public val setStartPositionName: MethodStringName1<NavigationLink2D, Unit, Vector2> =
        MethodStringName1<NavigationLink2D, Unit, Vector2>("set_start_position")

    @JvmField
    public val getStartPositionName: MethodStringName0<NavigationLink2D, Vector2> =
        MethodStringName0<NavigationLink2D, Vector2>("get_start_position")

    @JvmField
    public val setEndPositionName: MethodStringName1<NavigationLink2D, Unit, Vector2> =
        MethodStringName1<NavigationLink2D, Unit, Vector2>("set_end_position")

    @JvmField
    public val getEndPositionName: MethodStringName0<NavigationLink2D, Vector2> =
        MethodStringName0<NavigationLink2D, Vector2>("get_end_position")

    @JvmField
    public val setGlobalStartPositionName: MethodStringName1<NavigationLink2D, Unit, Vector2> =
        MethodStringName1<NavigationLink2D, Unit, Vector2>("set_global_start_position")

    @JvmField
    public val getGlobalStartPositionName: MethodStringName0<NavigationLink2D, Vector2> =
        MethodStringName0<NavigationLink2D, Vector2>("get_global_start_position")

    @JvmField
    public val setGlobalEndPositionName: MethodStringName1<NavigationLink2D, Unit, Vector2> =
        MethodStringName1<NavigationLink2D, Unit, Vector2>("set_global_end_position")

    @JvmField
    public val getGlobalEndPositionName: MethodStringName0<NavigationLink2D, Vector2> =
        MethodStringName0<NavigationLink2D, Vector2>("get_global_end_position")

    @JvmField
    public val setEnterCostName: MethodStringName1<NavigationLink2D, Unit, Float> =
        MethodStringName1<NavigationLink2D, Unit, Float>("set_enter_cost")

    @JvmField
    public val getEnterCostName: MethodStringName0<NavigationLink2D, Float> =
        MethodStringName0<NavigationLink2D, Float>("get_enter_cost")

    @JvmField
    public val setTravelCostName: MethodStringName1<NavigationLink2D, Unit, Float> =
        MethodStringName1<NavigationLink2D, Unit, Float>("set_travel_cost")

    @JvmField
    public val getTravelCostName: MethodStringName0<NavigationLink2D, Float> =
        MethodStringName0<NavigationLink2D, Float>("get_travel_cost")
  }

  public object MethodBindings {
    internal val getRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_rid", 2944877500)

    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "is_enabled", 36873697)

    internal val setNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_navigation_map", 2722037293)

    internal val getNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_navigation_map", 2944877500)

    internal val setBidirectionalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_bidirectional", 2586408642)

    internal val isBidirectionalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "is_bidirectional", 36873697)

    internal val setNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_navigation_layers", 1286410249)

    internal val getNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_navigation_layers", 3905245786)

    internal val setNavigationLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_navigation_layer_value", 300928843)

    internal val getNavigationLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_navigation_layer_value", 1116898809)

    internal val setStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_start_position", 743155724)

    internal val getStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_start_position", 3341600327)

    internal val setEndPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_end_position", 743155724)

    internal val getEndPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_end_position", 3341600327)

    internal val setGlobalStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_global_start_position", 743155724)

    internal val getGlobalStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_global_start_position", 3341600327)

    internal val setGlobalEndPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_global_end_position", 743155724)

    internal val getGlobalEndPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_global_end_position", 3341600327)

    internal val setEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_enter_cost", 373806689)

    internal val getEnterCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_enter_cost", 1740695150)

    internal val setTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "set_travel_cost", 373806689)

    internal val getTravelCostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationLink2D", "get_travel_cost", 1740695150)
  }
}
