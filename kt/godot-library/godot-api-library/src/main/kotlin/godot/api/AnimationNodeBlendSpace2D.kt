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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.Signal0
import godot.core.StringName
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Double
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
 * [AnimationNodeBlendSpace2D] represents a virtual 2D space on which [AnimationRootNode]s are
 * placed. Outputs the linear blend of the three adjacent animations using a [Vector2] weight. Adjacent
 * in this context means the three [AnimationRootNode]s making up the triangle that contains the
 * current value.
 *
 * You can add vertices to the blend space with [addBlendPoint] and automatically triangulate it by
 * setting [autoTriangles] to `true`. Otherwise, use [addTriangle] and [removeTriangle] to triangulate
 * the blend space by hand.
 */
@GodotBaseType
public open class AnimationNodeBlendSpace2D : AnimationRootNode() {
  /**
   * Emitted every time the blend space's triangles are created, removed, or when one of their
   * vertices changes position.
   */
  public val trianglesUpdated: Signal0 by Signal0

  /**
   * If `true`, the blend space is triangulated automatically. The mesh updates every time you add
   * or remove points with [addBlendPoint] and [removeBlendPoint].
   */
  public final inline var autoTriangles: Boolean
    @JvmName("autoTrianglesProperty")
    get() = getAutoTriangles()
    @JvmName("autoTrianglesProperty")
    set(`value`) {
      setAutoTriangles(value)
    }

  /**
   * The blend space's X and Y axes' lower limit for the points' position. See [addBlendPoint].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var minSpace: Vector2
    @JvmName("minSpaceProperty")
    get() = getMinSpace()
    @JvmName("minSpaceProperty")
    set(`value`) {
      setMinSpace(value)
    }

  /**
   * The blend space's X and Y axes' upper limit for the points' position. See [addBlendPoint].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var maxSpace: Vector2
    @JvmName("maxSpaceProperty")
    get() = getMaxSpace()
    @JvmName("maxSpaceProperty")
    set(`value`) {
      setMaxSpace(value)
    }

  /**
   * Position increment to snap to when moving a point.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var snap: Vector2
    @JvmName("snapProperty")
    get() = getSnap()
    @JvmName("snapProperty")
    set(`value`) {
      setSnap(value)
    }

  /**
   * Name of the blend space's X axis.
   */
  public final inline var xLabel: String
    @JvmName("xLabelProperty")
    get() = getXLabel()
    @JvmName("xLabelProperty")
    set(`value`) {
      setXLabel(value)
    }

  /**
   * Name of the blend space's Y axis.
   */
  public final inline var yLabel: String
    @JvmName("yLabelProperty")
    get() = getYLabel()
    @JvmName("yLabelProperty")
    set(`value`) {
      setYLabel(value)
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
    createNativeObject(24, scriptPtr)
  }

  /**
   * This is a helper function for [minSpace] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = animationnodeblendspace2d.minSpace
   * //Your changes
   * animationnodeblendspace2d.minSpace = myCoreType
   * ``````
   *
   * The blend space's X and Y axes' lower limit for the points' position. See [addBlendPoint].
   */
  @CoreTypeHelper
  public final fun minSpaceMutate(block: Vector2.() -> Unit): Vector2 = minSpace.apply {
     block(this)
     minSpace = this
  }

  /**
   * This is a helper function for [maxSpace] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = animationnodeblendspace2d.maxSpace
   * //Your changes
   * animationnodeblendspace2d.maxSpace = myCoreType
   * ``````
   *
   * The blend space's X and Y axes' upper limit for the points' position. See [addBlendPoint].
   */
  @CoreTypeHelper
  public final fun maxSpaceMutate(block: Vector2.() -> Unit): Vector2 = maxSpace.apply {
     block(this)
     maxSpace = this
  }

  /**
   * This is a helper function for [snap] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = animationnodeblendspace2d.snap
   * //Your changes
   * animationnodeblendspace2d.snap = myCoreType
   * ``````
   *
   * Position increment to snap to when moving a point.
   */
  @CoreTypeHelper
  public final fun snapMutate(block: Vector2.() -> Unit): Vector2 = snap.apply {
     block(this)
     snap = this
  }

  /**
   * Adds a new point with [name] that represents a [node] at the position set by [pos]. You can
   * insert it at a specific index using the [atIndex] argument. If you use the default value for
   * [atIndex], the point is inserted at the end of the blend points array.
   *
   * **Note:** If no name is provided, safe index is used as reference. In the future, empty names
   * will be deprecated, so explicitly passing a name is recommended.
   */
  @JvmOverloads
  public final fun addBlendPoint(
    node: AnimationRootNode?,
    pos: Vector2,
    atIndex: Int = -1,
    name: StringName = StringName(""),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to node, VECTOR2 to pos, LONG to atIndex.toLong(), STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.addBlendPointPtr)
  }

  /**
   * Updates the position of the point at index [point] in the blend space.
   */
  public final fun setBlendPointPosition(point: Int, pos: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to point.toLong(), VECTOR2 to pos)
    TransferContext.callMethod(MethodBindings.setBlendPointPositionPtr)
  }

  /**
   * Returns the position of the point at index [point].
   */
  public final fun getBlendPointPosition(point: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to point.toLong())
    TransferContext.callMethod(MethodBindings.getBlendPointPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Changes the [AnimationNode] referenced by the point at index [point].
   */
  public final fun setBlendPointNode(point: Int, node: AnimationRootNode?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to point.toLong(), OBJECT to node)
    TransferContext.callMethod(MethodBindings.setBlendPointNodePtr)
  }

  /**
   * Returns the [AnimationRootNode] referenced by the point at index [point].
   */
  public final fun getBlendPointNode(point: Int): AnimationRootNode? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to point.toLong())
    TransferContext.callMethod(MethodBindings.getBlendPointNodePtr)
    return (TransferContext.readReturnValue(OBJECT) as AnimationRootNode?)
  }

  /**
   * Sets the name of the blend point at index [point]. If the name conflicts with an existing
   * point, a unique name will be generated automatically.
   */
  public final fun setBlendPointName(point: Int, name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to point.toLong(), STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.setBlendPointNamePtr)
  }

  /**
   * Returns the name of the blend point at index [point].
   */
  public final fun getBlendPointName(point: Int): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to point.toLong())
    TransferContext.callMethod(MethodBindings.getBlendPointNamePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Returns the index of the blend point with the given [name]. Returns `-1` if no blend point with
   * that name is found.
   */
  public final fun findBlendPointByName(name: StringName): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.findBlendPointByNamePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes the point at index [point] from the blend space.
   */
  public final fun removeBlendPoint(point: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to point.toLong())
    TransferContext.callMethod(MethodBindings.removeBlendPointPtr)
  }

  /**
   * Returns the number of points in the blend space.
   */
  public final fun getBlendPointCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendPointCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Swaps the blend points at indices [fromIndex] and [toIndex], exchanging their positions and
   * properties.
   */
  public final fun reorderBlendPoint(fromIndex: Int, toIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromIndex.toLong(), LONG to toIndex.toLong())
    TransferContext.callMethod(MethodBindings.reorderBlendPointPtr)
  }

  /**
   * Creates a new triangle using three points [x], [y], and [z]. Triangles can overlap. You can
   * insert the triangle at a specific index using the [atIndex] argument. If you use the default value
   * for [atIndex], the point is inserted at the end of the blend points array.
   */
  @JvmOverloads
  public final fun addTriangle(
    x: Int,
    y: Int,
    z: Int,
    atIndex: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to x.toLong(), LONG to y.toLong(), LONG to z.toLong(), LONG to atIndex.toLong())
    TransferContext.callMethod(MethodBindings.addTrianglePtr)
  }

  /**
   * Returns the position of the point at index [point] in the triangle of index [triangle].
   */
  public final fun getTrianglePoint(triangle: Int, point: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to triangle.toLong(), LONG to point.toLong())
    TransferContext.callMethod(MethodBindings.getTrianglePointPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes the triangle at index [triangle] from the blend space.
   */
  public final fun removeTriangle(triangle: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to triangle.toLong())
    TransferContext.callMethod(MethodBindings.removeTrianglePtr)
  }

  /**
   * Returns the number of triangles in the blend space.
   */
  public final fun getTriangleCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTriangleCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMinSpace(minSpace: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to minSpace)
    TransferContext.callMethod(MethodBindings.setMinSpacePtr)
  }

  public final fun getMinSpace(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinSpacePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setMaxSpace(maxSpace: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to maxSpace)
    TransferContext.callMethod(MethodBindings.setMaxSpacePtr)
  }

  public final fun getMaxSpace(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxSpacePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setSnap(snap: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to snap)
    TransferContext.callMethod(MethodBindings.setSnapPtr)
  }

  public final fun getSnap(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSnapPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setXLabel(text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text)
    TransferContext.callMethod(MethodBindings.setXLabelPtr)
  }

  public final fun getXLabel(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getXLabelPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setYLabel(text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text)
    TransferContext.callMethod(MethodBindings.setYLabelPtr)
  }

  public final fun getYLabel(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getYLabelPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setAutoTriangles(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAutoTrianglesPtr)
  }

  public final fun getAutoTriangles(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutoTrianglesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setBlendMode(mode: BlendMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setBlendModePtr)
  }

  public final fun getBlendMode(): BlendMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendModePtr)
    return BlendMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setUseSync(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseSyncPtr)
  }

  public final fun isUsingSync(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingSyncPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSyncMode(syncMode: SyncMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to syncMode.value)
    TransferContext.callMethod(MethodBindings.setSyncModePtr)
  }

  public final fun getSyncMode(): SyncMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSyncModePtr)
    return SyncMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCyclicLength(length: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to length)
    TransferContext.callMethod(MethodBindings.setCyclicLengthPtr)
  }

  public final fun getCyclicLength(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCyclicLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Adds a new point with [name] that represents a [node] at the position set by [pos]. You can
   * insert it at a specific index using the [atIndex] argument. If you use the default value for
   * [atIndex], the point is inserted at the end of the blend points array.
   *
   * **Note:** If no name is provided, safe index is used as reference. In the future, empty names
   * will be deprecated, so explicitly passing a name is recommended.
   */
  @JvmOverloads
  public final fun addBlendPoint(
    node: AnimationRootNode?,
    pos: Vector2,
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
        MethodStringName4<AnimationNodeBlendSpace2D, Unit, AnimationRootNode?, Vector2, Int, StringName>
        =
        MethodStringName4<AnimationNodeBlendSpace2D, Unit, AnimationRootNode?, Vector2, Int, StringName>("add_blend_point")

    @JvmField
    public val setBlendPointPositionName:
        MethodStringName2<AnimationNodeBlendSpace2D, Unit, Int, Vector2> =
        MethodStringName2<AnimationNodeBlendSpace2D, Unit, Int, Vector2>("set_blend_point_position")

    @JvmField
    public val getBlendPointPositionName: MethodStringName1<AnimationNodeBlendSpace2D, Vector2, Int>
        = MethodStringName1<AnimationNodeBlendSpace2D, Vector2, Int>("get_blend_point_position")

    @JvmField
    public val setBlendPointNodeName:
        MethodStringName2<AnimationNodeBlendSpace2D, Unit, Int, AnimationRootNode?> =
        MethodStringName2<AnimationNodeBlendSpace2D, Unit, Int, AnimationRootNode?>("set_blend_point_node")

    @JvmField
    public val getBlendPointNodeName:
        MethodStringName1<AnimationNodeBlendSpace2D, AnimationRootNode?, Int> =
        MethodStringName1<AnimationNodeBlendSpace2D, AnimationRootNode?, Int>("get_blend_point_node")

    @JvmField
    public val setBlendPointNameName:
        MethodStringName2<AnimationNodeBlendSpace2D, Unit, Int, StringName> =
        MethodStringName2<AnimationNodeBlendSpace2D, Unit, Int, StringName>("set_blend_point_name")

    @JvmField
    public val getBlendPointNameName: MethodStringName1<AnimationNodeBlendSpace2D, StringName, Int>
        = MethodStringName1<AnimationNodeBlendSpace2D, StringName, Int>("get_blend_point_name")

    @JvmField
    public val findBlendPointByNameName:
        MethodStringName1<AnimationNodeBlendSpace2D, Int, StringName> =
        MethodStringName1<AnimationNodeBlendSpace2D, Int, StringName>("find_blend_point_by_name")

    @JvmField
    public val removeBlendPointName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, Int> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, Int>("remove_blend_point")

    @JvmField
    public val getBlendPointCountName: MethodStringName0<AnimationNodeBlendSpace2D, Int> =
        MethodStringName0<AnimationNodeBlendSpace2D, Int>("get_blend_point_count")

    @JvmField
    public val reorderBlendPointName: MethodStringName2<AnimationNodeBlendSpace2D, Unit, Int, Int> =
        MethodStringName2<AnimationNodeBlendSpace2D, Unit, Int, Int>("reorder_blend_point")

    @JvmField
    public val addTriangleName:
        MethodStringName4<AnimationNodeBlendSpace2D, Unit, Int, Int, Int, Int> =
        MethodStringName4<AnimationNodeBlendSpace2D, Unit, Int, Int, Int, Int>("add_triangle")

    @JvmField
    public val getTrianglePointName: MethodStringName2<AnimationNodeBlendSpace2D, Int, Int, Int> =
        MethodStringName2<AnimationNodeBlendSpace2D, Int, Int, Int>("get_triangle_point")

    @JvmField
    public val removeTriangleName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, Int> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, Int>("remove_triangle")

    @JvmField
    public val getTriangleCountName: MethodStringName0<AnimationNodeBlendSpace2D, Int> =
        MethodStringName0<AnimationNodeBlendSpace2D, Int>("get_triangle_count")

    @JvmField
    public val setMinSpaceName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, Vector2> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, Vector2>("set_min_space")

    @JvmField
    public val getMinSpaceName: MethodStringName0<AnimationNodeBlendSpace2D, Vector2> =
        MethodStringName0<AnimationNodeBlendSpace2D, Vector2>("get_min_space")

    @JvmField
    public val setMaxSpaceName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, Vector2> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, Vector2>("set_max_space")

    @JvmField
    public val getMaxSpaceName: MethodStringName0<AnimationNodeBlendSpace2D, Vector2> =
        MethodStringName0<AnimationNodeBlendSpace2D, Vector2>("get_max_space")

    @JvmField
    public val setSnapName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, Vector2> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, Vector2>("set_snap")

    @JvmField
    public val getSnapName: MethodStringName0<AnimationNodeBlendSpace2D, Vector2> =
        MethodStringName0<AnimationNodeBlendSpace2D, Vector2>("get_snap")

    @JvmField
    public val setXLabelName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, String> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, String>("set_x_label")

    @JvmField
    public val getXLabelName: MethodStringName0<AnimationNodeBlendSpace2D, String> =
        MethodStringName0<AnimationNodeBlendSpace2D, String>("get_x_label")

    @JvmField
    public val setYLabelName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, String> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, String>("set_y_label")

    @JvmField
    public val getYLabelName: MethodStringName0<AnimationNodeBlendSpace2D, String> =
        MethodStringName0<AnimationNodeBlendSpace2D, String>("get_y_label")

    @JvmField
    public val setAutoTrianglesName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, Boolean> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, Boolean>("set_auto_triangles")

    @JvmField
    public val getAutoTrianglesName: MethodStringName0<AnimationNodeBlendSpace2D, Boolean> =
        MethodStringName0<AnimationNodeBlendSpace2D, Boolean>("get_auto_triangles")

    @JvmField
    public val setBlendModeName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, BlendMode> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, BlendMode>("set_blend_mode")

    @JvmField
    public val getBlendModeName: MethodStringName0<AnimationNodeBlendSpace2D, BlendMode> =
        MethodStringName0<AnimationNodeBlendSpace2D, BlendMode>("get_blend_mode")

    @JvmField
    public val setUseSyncName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, Boolean> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, Boolean>("set_use_sync")

    @JvmField
    public val isUsingSyncName: MethodStringName0<AnimationNodeBlendSpace2D, Boolean> =
        MethodStringName0<AnimationNodeBlendSpace2D, Boolean>("is_using_sync")

    @JvmField
    public val setSyncModeName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, SyncMode> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, SyncMode>("set_sync_mode")

    @JvmField
    public val getSyncModeName: MethodStringName0<AnimationNodeBlendSpace2D, SyncMode> =
        MethodStringName0<AnimationNodeBlendSpace2D, SyncMode>("get_sync_mode")

    @JvmField
    public val setCyclicLengthName: MethodStringName1<AnimationNodeBlendSpace2D, Unit, Double> =
        MethodStringName1<AnimationNodeBlendSpace2D, Unit, Double>("set_cyclic_length")

    @JvmField
    public val getCyclicLengthName: MethodStringName0<AnimationNodeBlendSpace2D, Double> =
        MethodStringName0<AnimationNodeBlendSpace2D, Double>("get_cyclic_length")
  }

  public object MethodBindings {
    internal val addBlendPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "add_blend_point", 768750458)

    internal val setBlendPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_blend_point_position", 163021252)

    internal val getBlendPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_blend_point_position", 2299179447)

    internal val setBlendPointNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_blend_point_node", 4240341528)

    internal val getBlendPointNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_blend_point_node", 665599029)

    internal val setBlendPointNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_blend_point_name", 3780747571)

    internal val getBlendPointNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_blend_point_name", 659327637)

    internal val findBlendPointByNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "find_blend_point_by_name", 2458036349)

    internal val removeBlendPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "remove_blend_point", 1286410249)

    internal val getBlendPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_blend_point_count", 3905245786)

    internal val reorderBlendPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "reorder_blend_point", 3937882851)

    internal val addTrianglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "add_triangle", 753017335)

    internal val getTrianglePointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_triangle_point", 50157827)

    internal val removeTrianglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "remove_triangle", 1286410249)

    internal val getTriangleCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_triangle_count", 3905245786)

    internal val setMinSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_min_space", 743155724)

    internal val getMinSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_min_space", 3341600327)

    internal val setMaxSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_max_space", 743155724)

    internal val getMaxSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_max_space", 3341600327)

    internal val setSnapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_snap", 743155724)

    internal val getSnapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_snap", 3341600327)

    internal val setXLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_x_label", 83702148)

    internal val getXLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_x_label", 201670096)

    internal val setYLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_y_label", 83702148)

    internal val getYLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_y_label", 201670096)

    internal val setAutoTrianglesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_auto_triangles", 2586408642)

    internal val getAutoTrianglesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_auto_triangles", 36873697)

    internal val setBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_blend_mode", 81193520)

    internal val getBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_blend_mode", 1398433632)

    internal val setUseSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_use_sync", 2586408642)

    internal val isUsingSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "is_using_sync", 36873697)

    internal val setSyncModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_sync_mode", 2615784488)

    internal val getSyncModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_sync_mode", 242032665)

    internal val setCyclicLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "set_cyclic_length", 373806689)

    internal val getCyclicLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendSpace2D", "get_cyclic_length", 1740695150)
  }
}
