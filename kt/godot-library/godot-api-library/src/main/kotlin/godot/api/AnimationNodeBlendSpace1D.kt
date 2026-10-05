// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_DOUBLE
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_OBJECT
import godot.callPtrMethod_LONG_STRING_NAME
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_LONG_ret_OBJECT_REF
import godot.callPtrMethod_LONG_ret_STRING_NAME
import godot.callPtrMethod_OBJECT_DOUBLE_LONG_STRING_NAME
import godot.callPtrMethod_STRING_NAME_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.StringName
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Double
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
 * A resource used by [AnimationNodeBlendTree].
 *
 * [AnimationNodeBlendSpace1D] represents a virtual axis on which any type of [AnimationRootNode]s
 * can be added using [addBlendPoint]. Outputs the linear blend of the two [AnimationRootNode]s
 * adjacent to the current value.
 *
 * You can set the extents of the axis with [minSpace] and [maxSpace].
 */
@GodotBaseType
public open class AnimationNodeBlendSpace1D : AnimationRootNode() {
  /**
   * The blend space's axis's lower limit for the points' position. See [addBlendPoint].
   */
  public final inline var minSpace: Float
    @JvmName("minSpaceProperty")
    get() = getMinSpace()
    @JvmName("minSpaceProperty")
    set(`value`) {
      setMinSpace(value)
    }

  /**
   * The blend space's axis's upper limit for the points' position. See [addBlendPoint].
   */
  public final inline var maxSpace: Float
    @JvmName("maxSpaceProperty")
    get() = getMaxSpace()
    @JvmName("maxSpaceProperty")
    set(`value`) {
      setMaxSpace(value)
    }

  /**
   * Position increment to snap to when moving a point on the axis.
   */
  public final inline var snap: Float
    @JvmName("snapProperty")
    get() = getSnap()
    @JvmName("snapProperty")
    set(`value`) {
      setSnap(value)
    }

  /**
   * Label of the virtual axis of the blend space.
   */
  public final inline var valueLabel: String
    @JvmName("valueLabelProperty")
    get() = getValueLabel()
    @JvmName("valueLabelProperty")
    set(`value`) {
      setValueLabel(value)
    }

  /**
   * Controls the interpolation between animations.
   */
  public final inline var blendMode: BlendMode
    @JvmName("blendModeProperty")
    get() = getBlendMode()
    @JvmName("blendModeProperty")
    set(`value`) {
      setBlendMode(value)
    }

  /**
   * If `true`, sync mode is enabled (equivalent to [SYNC_MODE_INDEPENDENT]). This property is kept
   * for backward compatibility.
   */
  public final inline var sync: Boolean
    @JvmName("syncProperty")
    get() = isUsingSync()
    @JvmName("syncProperty")
    set(`value`) {
      setUseSync(value)
    }

  /**
   * Controls how animations are synced when blended. See [SyncMode] for available options.
   */
  public final inline var syncMode: SyncMode
    @JvmName("syncModeProperty")
    get() = getSyncMode()
    @JvmName("syncModeProperty")
    set(`value`) {
      setSyncMode(value)
    }

  /**
   * The cycle length in seconds used by [SYNC_MODE_CYCLIC_CONSTANT]. All animations are time-scaled
   * so they complete one full cycle in this duration. Must be greater than `0` for cyclic sync to take
   * effect.
   */
  public final inline var cyclicLength: Double
    @JvmName("cyclicLengthProperty")
    get() = getCyclicLength()
    @JvmName("cyclicLengthProperty")
    set(`value`) {
      setCyclicLength(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(21, scriptPtr)
  }

  /**
   * Adds a new point with [name] that represents a [node] on the virtual axis at a given position
   * set by [pos]. You can insert it at a specific index using the [atIndex] argument. If you use the
   * default value for [atIndex], the point is inserted at the end of the blend points array.
   *
   * **Note:** If no name is provided, safe index is used as reference. In the future, empty names
   * will be deprecated, so explicitly passing a name is recommended.
   */
  @JvmOverloads
  public final fun addBlendPoint(
    node: AnimationRootNode?,
    pos: Float,
    atIndex: Int = -1,
    name: StringName = StringName(""),
  ): Unit {
    TransferContext.callPtrMethod_OBJECT_DOUBLE_LONG_STRING_NAME(ptr, objectID.id, MethodBindings.addBlendPointPtr, node, pos.toDouble(), atIndex.toLong(), name)
  }

  /**
   * Updates the position of the point at index [point] on the blend axis.
   */
  public final fun setBlendPointPosition(point: Int, pos: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setBlendPointPositionPtr, point.toLong(), pos.toDouble())
  }

  /**
   * Returns the position of the point at index [point].
   */
  public final fun getBlendPointPosition(point: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getBlendPointPositionPtr, point.toLong()).toFloat()

  /**
   * Changes the [AnimationNode] referenced by the point at index [point].
   */
  public final fun setBlendPointNode(point: Int, node: AnimationRootNode?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setBlendPointNodePtr, point.toLong(), node)
  }

  /**
   * Returns the [AnimationNode] referenced by the point at index [point].
   */
  public final fun getBlendPointNode(point: Int): AnimationRootNode? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getBlendPointNodePtr, point.toLong()) as AnimationRootNode?)

  /**
   * Sets the name of the blend point at index [point]. If the name conflicts with an existing
   * point, a unique name will be generated automatically.
   */
  public final fun setBlendPointName(point: Int, name: StringName): Unit {
    TransferContext.callPtrMethod_LONG_STRING_NAME(ptr, objectID.id, MethodBindings.setBlendPointNamePtr, point.toLong(), name)
  }

  /**
   * Returns the name of the blend point at index [point].
   */
  public final fun getBlendPointName(point: Int): StringName =
      TransferContext.callPtrMethod_LONG_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getBlendPointNamePtr, point.toLong())

  /**
   * Returns the index of the blend point with the given [name]. Returns `-1` if no blend point with
   * that name is found.
   */
  public final fun findBlendPointByName(name: StringName): Int =
      TransferContext.callPtrMethod_STRING_NAME_ret_LONG(ptr, objectID.id, MethodBindings.findBlendPointByNamePtr, name).toInt()

  /**
   * Removes the point at index [point] from the blend axis.
   */
  public final fun removeBlendPoint(point: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.removeBlendPointPtr, point.toLong())
  }

  /**
   * Returns the number of points on the blend axis.
   */
  public final fun getBlendPointCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBlendPointCountPtr).toInt()

  /**
   * Swaps the blend points at indices [fromIndex] and [toIndex], exchanging their positions and
   * properties.
   */
  public final fun reorderBlendPoint(fromIndex: Int, toIndex: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.reorderBlendPointPtr, fromIndex.toLong(), toIndex.toLong())
  }

  public final fun setMinSpace(minSpace: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setMinSpacePtr, minSpace.toDouble())
  }

  public final fun getMinSpace(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getMinSpacePtr).toFloat()

  public final fun setMaxSpace(maxSpace: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setMaxSpacePtr, maxSpace.toDouble())
  }

  public final fun getMaxSpace(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getMaxSpacePtr).toFloat()

  public final fun setSnap(snap: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setSnapPtr, snap.toDouble())
  }

  public final fun getSnap(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getSnapPtr).toFloat()

  public final fun setValueLabel(text: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setValueLabelPtr, text)
  }

  public final fun getValueLabel(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getValueLabelPtr)

  public final fun setBlendMode(mode: BlendMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBlendModePtr, mode.value)
  }

  public final fun getBlendMode(): BlendMode =
      BlendMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBlendModePtr))

  public final fun setUseSync(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setUseSyncPtr, enable)
  }

  public final fun isUsingSync(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isUsingSyncPtr)

  public final fun setSyncMode(syncMode: SyncMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSyncModePtr, syncMode.value)
  }

  public final fun getSyncMode(): SyncMode =
      SyncMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSyncModePtr))

  public final fun setCyclicLength(length: Double): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setCyclicLengthPtr, length)
  }

  public final fun getCyclicLength(): Double =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCyclicLengthPtr)

  /**
   * Adds a new point with [name] that represents a [node] on the virtual axis at a given position
   * set by [pos]. You can insert it at a specific index using the [atIndex] argument. If you use the
   * default value for [atIndex], the point is inserted at the end of the blend points array.
   *
   * **Note:** If no name is provided, safe index is used as reference. In the future, empty names
   * will be deprecated, so explicitly passing a name is recommended.
   */
  @JvmOverloads
  public final fun addBlendPoint(
    node: AnimationRootNode?,
    pos: Float,
    atIndex: Int = -1,
    name: String,
  ) = addBlendPoint(node, pos, atIndex, name.asCachedStringName())

  /**
   * Sets the name of the blend point at index [point]. If the name conflicts with an existing
   * point, a unique name will be generated automatically.
   */
  public final fun setBlendPointName(point: Int, name: String) =
      setBlendPointName(point, name.asCachedStringName())

  /**
   * Returns the index of the blend point with the given [name]. Returns `-1` if no blend point with
   * that name is found.
   */
  public final fun findBlendPointByName(name: String): Int =
      findBlendPointByName(name.asCachedStringName())

  public enum class BlendMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The interpolation between animations is linear.
     */
    INTERPOLATED(0),
    /**
     * The blend space plays the animation of the animation node which blending position is closest
     * to. Useful for frame-by-frame 2D animations.
     */
    DISCRETE(1),
    /**
     * Similar to [BLEND_MODE_DISCRETE], but starts the new animation at the last animation's
     * playback position.
     */
    DISCRETE_CARRY(2),
    ;

    public companion object {
      public fun from(`value`: Long): BlendMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class SyncMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Inactive animations are frozen and do not advance.
     */
    NONE(0),
    /**
     * Inactive animations advance with a weight of `0`. This is equivalent to the previous `sync =
     * true` behavior.
     */
    INDEPENDENT(1),
    /**
     * All animations are time-scaled so they stay in sync, with the cycle length dynamically
     * computed from active blend weights. This is self-normalizing: a solo animation plays at normal
     * speed.
     *
     * **Note:** If you apply [AnimationNodeTimeSeek] to the result when handling animations of
     * different lengths, synchronization will be broken. In such cases, it is recommended to use
     * [AnimationNodeAnimation.useCustomTimeline] to align the animation lengths.
     */
    CYCLIC_MUTABLE(2),
    /**
     * All animations are time-scaled so they complete one cycle in [cyclicLength] seconds, keeping
     * them in sync regardless of their individual lengths.
     *
     * **Note:** If you apply [AnimationNodeTimeSeek] to the result when handling animations of
     * different lengths, synchronization will be broken. In such cases, it is recommended to use
     * [AnimationNodeAnimation.useCustomTimeline] to align the animation lengths.
     */
    CYCLIC_CONSTANT(3),
    ;

    public companion object {
      public fun from(`value`: Long): SyncMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addBlendPointName:
        MethodStringName4<AnimationNodeBlendSpace1D, Unit, AnimationRootNode?, Float, Int, StringName>
        =
        MethodStringName4<AnimationNodeBlendSpace1D, Unit, AnimationRootNode?, Float, Int, StringName>("add_blend_point")

    @JvmField
    public val setBlendPointPositionName:
        MethodStringName2<AnimationNodeBlendSpace1D, Unit, Int, Float> =
        MethodStringName2<AnimationNodeBlendSpace1D, Unit, Int, Float>("set_blend_point_position")

    @JvmField
    public val getBlendPointPositionName: MethodStringName1<AnimationNodeBlendSpace1D, Float, Int> =
        MethodStringName1<AnimationNodeBlendSpace1D, Float, Int>("get_blend_point_position")

    @JvmField
    public val setBlendPointNodeName:
        MethodStringName2<AnimationNodeBlendSpace1D, Unit, Int, AnimationRootNode?> =
        MethodStringName2<AnimationNodeBlendSpace1D, Unit, Int, AnimationRootNode?>("set_blend_point_node")

    @JvmField
    public val getBlendPointNodeName:
        MethodStringName1<AnimationNodeBlendSpace1D, AnimationRootNode?, Int> =
        MethodStringName1<AnimationNodeBlendSpace1D, AnimationRootNode?, Int>("get_blend_point_node")

    @JvmField
    public val setBlendPointNameName:
        MethodStringName2<AnimationNodeBlendSpace1D, Unit, Int, StringName> =
        MethodStringName2<AnimationNodeBlendSpace1D, Unit, Int, StringName>("set_blend_point_name")

    @JvmField
    public val getBlendPointNameName: MethodStringName1<AnimationNodeBlendSpace1D, StringName, Int>
        = MethodStringName1<AnimationNodeBlendSpace1D, StringName, Int>("get_blend_point_name")

    @JvmField
    public val findBlendPointByNameName:
        MethodStringName1<AnimationNodeBlendSpace1D, Int, StringName> =
        MethodStringName1<AnimationNodeBlendSpace1D, Int, StringName>("find_blend_point_by_name")

    @JvmField
    public val removeBlendPointName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, Int> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, Int>("remove_blend_point")

    @JvmField
    public val getBlendPointCountName: MethodStringName0<AnimationNodeBlendSpace1D, Int> =
        MethodStringName0<AnimationNodeBlendSpace1D, Int>("get_blend_point_count")

    @JvmField
    public val reorderBlendPointName: MethodStringName2<AnimationNodeBlendSpace1D, Unit, Int, Int> =
        MethodStringName2<AnimationNodeBlendSpace1D, Unit, Int, Int>("reorder_blend_point")

    @JvmField
    public val setMinSpaceName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, Float> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, Float>("set_min_space")

    @JvmField
    public val getMinSpaceName: MethodStringName0<AnimationNodeBlendSpace1D, Float> =
        MethodStringName0<AnimationNodeBlendSpace1D, Float>("get_min_space")

    @JvmField
    public val setMaxSpaceName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, Float> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, Float>("set_max_space")

    @JvmField
    public val getMaxSpaceName: MethodStringName0<AnimationNodeBlendSpace1D, Float> =
        MethodStringName0<AnimationNodeBlendSpace1D, Float>("get_max_space")

    @JvmField
    public val setSnapName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, Float> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, Float>("set_snap")

    @JvmField
    public val getSnapName: MethodStringName0<AnimationNodeBlendSpace1D, Float> =
        MethodStringName0<AnimationNodeBlendSpace1D, Float>("get_snap")

    @JvmField
    public val setValueLabelName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, String> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, String>("set_value_label")

    @JvmField
    public val getValueLabelName: MethodStringName0<AnimationNodeBlendSpace1D, String> =
        MethodStringName0<AnimationNodeBlendSpace1D, String>("get_value_label")

    @JvmField
    public val setBlendModeName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, BlendMode> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, BlendMode>("set_blend_mode")

    @JvmField
    public val getBlendModeName: MethodStringName0<AnimationNodeBlendSpace1D, BlendMode> =
        MethodStringName0<AnimationNodeBlendSpace1D, BlendMode>("get_blend_mode")

    @JvmField
    public val setUseSyncName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, Boolean> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, Boolean>("set_use_sync")

    @JvmField
    public val isUsingSyncName: MethodStringName0<AnimationNodeBlendSpace1D, Boolean> =
        MethodStringName0<AnimationNodeBlendSpace1D, Boolean>("is_using_sync")

    @JvmField
    public val setSyncModeName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, SyncMode> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, SyncMode>("set_sync_mode")

    @JvmField
    public val getSyncModeName: MethodStringName0<AnimationNodeBlendSpace1D, SyncMode> =
        MethodStringName0<AnimationNodeBlendSpace1D, SyncMode>("get_sync_mode")

    @JvmField
    public val setCyclicLengthName: MethodStringName1<AnimationNodeBlendSpace1D, Unit, Double> =
        MethodStringName1<AnimationNodeBlendSpace1D, Unit, Double>("set_cyclic_length")

    @JvmField
    public val getCyclicLengthName: MethodStringName0<AnimationNodeBlendSpace1D, Double> =
        MethodStringName0<AnimationNodeBlendSpace1D, Double>("get_cyclic_length")
  }

  public object MethodBindings {
    internal val addBlendPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "add_blend_point", 398361042)

    internal val setBlendPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_blend_point_position", 1602489585)

    internal val getBlendPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_blend_point_position", 2339986948)

    internal val setBlendPointNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_blend_point_node", 4240341528)

    internal val getBlendPointNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_blend_point_node", 665599029)

    internal val setBlendPointNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_blend_point_name", 3780747571)

    internal val getBlendPointNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_blend_point_name", 659327637)

    internal val findBlendPointByNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "find_blend_point_by_name", 2458036349)

    internal val removeBlendPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "remove_blend_point", 1286410249)

    internal val getBlendPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_blend_point_count", 3905245786)

    internal val reorderBlendPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "reorder_blend_point", 3937882851)

    internal val setMinSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_min_space", 373806689)

    internal val getMinSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_min_space", 1740695150)

    internal val setMaxSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_max_space", 373806689)

    internal val getMaxSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_max_space", 1740695150)

    internal val setSnapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_snap", 373806689)

    internal val getSnapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_snap", 1740695150)

    internal val setValueLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_value_label", 83702148)

    internal val getValueLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_value_label", 201670096)

    internal val setBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_blend_mode", 2600869457)

    internal val getBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_blend_mode", 1547667849)

    internal val setUseSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_use_sync", 2586408642)

    internal val isUsingSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "is_using_sync", 36873697)

    internal val setSyncModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_sync_mode", 1065895142)

    internal val getSyncModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_sync_mode", 132474921)

    internal val setCyclicLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "set_cyclic_length", 373806689)

    internal val getCyclicLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace1D", "get_cyclic_length", 1740695150)
  }
}
