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
import godot.core.PackedVector2Array
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.VECTOR2
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
 * A node that provides a polygon shape to a [CollisionObject2D] parent and allows it to be edited.
 * The polygon can be concave or convex. This can give a detection shape to an [Area2D], turn a
 * [PhysicsBody2D] into a solid object, or give a hollow shape to a [StaticBody2D].
 *
 * **Warning:** A non-uniformly scaled [CollisionPolygon2D] will likely not behave as expected. Make
 * sure to keep its scale the same on all axes and adjust its polygon instead.
 */
@GodotBaseType
public open class CollisionPolygon2D : Node2D() {
  /**
   * Collision build mode.
   */
  public final inline var buildMode: BuildMode
    @JvmName("buildModeProperty")
    get() = getBuildMode()
    @JvmName("buildModeProperty")
    set(`value`) {
      setBuildMode(value)
    }

  /**
   * The polygon's list of vertices. Each point will be connected to the next, and the final point
   * will be connected to the first.
   *
   * **Note:** The returned vertices are in the local coordinate space of the given
   * [CollisionPolygon2D].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var polygon: PackedVector2Array
    @JvmName("polygonProperty")
    get() = getPolygon()
    @JvmName("polygonProperty")
    set(`value`) {
      setPolygon(value)
    }

  /**
   * If `true`, no collisions will be detected. This property should be changed with
   * [Object.setDeferred].
   */
  public final inline var disabled: Boolean
    @JvmName("disabledProperty")
    get() = isDisabled()
    @JvmName("disabledProperty")
    set(`value`) {
      setDisabled(value)
    }

  /**
   * If `true`, only edges that face up, relative to [CollisionPolygon2D]'s rotation, will collide
   * with other objects.
   *
   * **Note:** This property has no effect if this [CollisionPolygon2D] is a child of an [Area2D]
   * node.
   *
   * **Note:** The one way collision direction can be configured by setting
   * [oneWayCollisionDirection].
   */
  public final inline var oneWayCollision: Boolean
    @JvmName("oneWayCollisionProperty")
    get() = isOneWayCollisionEnabled()
    @JvmName("oneWayCollisionProperty")
    set(`value`) {
      setOneWayCollision(value)
    }

  /**
   * The margin used for one-way collision (in pixels). Higher values will make the shape thicker,
   * and work better for colliders that enter the polygon at a high velocity.
   */
  public final inline var oneWayCollisionMargin: Float
    @JvmName("oneWayCollisionMarginProperty")
    get() = getOneWayCollisionMargin()
    @JvmName("oneWayCollisionMarginProperty")
    set(`value`) {
      setOneWayCollisionMargin(value)
    }

  /**
   * The direction used for one-way collision.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var oneWayCollisionDirection: Vector2
    @JvmName("oneWayCollisionDirectionProperty")
    get() = getOneWayCollisionDirection()
    @JvmName("oneWayCollisionDirectionProperty")
    set(`value`) {
      setOneWayCollisionDirection(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(165, scriptPtr)
  }

  /**
   * This is a helper function for [polygon] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = collisionpolygon2d.polygon
   * //Your changes
   * collisionpolygon2d.polygon = myCoreType
   * ``````
   *
   * The polygon's list of vertices. Each point will be connected to the next, and the final point
   * will be connected to the first.
   *
   * **Note:** The returned vertices are in the local coordinate space of the given
   * [CollisionPolygon2D].
   */
  @CoreTypeHelper
  public final fun polygonMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
      polygon.apply {
     block(this)
     polygon = this
  }

  /**
   * This is a helper function for [polygon] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The polygon's list of vertices. Each point will be connected to the next, and the final point
   * will be connected to the first.
   *
   * **Note:** The returned vertices are in the local coordinate space of the given
   * [CollisionPolygon2D].
   */
  @CoreTypeHelper
  public final fun polygonMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = polygon.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     polygon = this
  }

  /**
   * This is a helper function for [oneWayCollisionDirection] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = collisionpolygon2d.oneWayCollisionDirection
   * //Your changes
   * collisionpolygon2d.oneWayCollisionDirection = myCoreType
   * ``````
   *
   * The direction used for one-way collision.
   */
  @CoreTypeHelper
  public final fun oneWayCollisionDirectionMutate(block: Vector2.() -> Unit): Vector2 =
      oneWayCollisionDirection.apply {
     block(this)
     oneWayCollisionDirection = this
  }

  public final fun setPolygon(polygon: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.setPolygonPtr)
  }

  public final fun getPolygon(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPolygonPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  public final fun setBuildMode(buildMode: BuildMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to buildMode.value)
    TransferContext.callMethod(MethodBindings.setBuildModePtr)
  }

  public final fun getBuildMode(): BuildMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBuildModePtr)
    return BuildMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDisabled(disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setDisabledPtr)
  }

  public final fun isDisabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setOneWayCollision(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setOneWayCollisionPtr)
  }

  public final fun isOneWayCollisionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOneWayCollisionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setOneWayCollisionMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to margin.toDouble())
    TransferContext.callMethod(MethodBindings.setOneWayCollisionMarginPtr)
  }

  public final fun getOneWayCollisionMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOneWayCollisionMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setOneWayCollisionDirection(direction: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to direction)
    TransferContext.callMethod(MethodBindings.setOneWayCollisionDirectionPtr)
  }

  public final fun getOneWayCollisionDirection(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOneWayCollisionDirectionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public enum class BuildMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Collisions will include the polygon and its contained area. In this mode the node has the
     * same effect as several [ConvexPolygonShape2D] nodes, one for each convex shape in the convex
     * decomposition of the polygon (but without the overhead of multiple nodes).
     */
    SOLIDS(0),
    /**
     * Collisions will only include the polygon edges. In this mode the node has the same effect as
     * a single [ConcavePolygonShape2D] made of segments, with the restriction that each segment (after
     * the first one) starts where the previous one ends, and the last one ends where the first one
     * starts (forming a closed but hollow polygon).
     */
    SEGMENTS(1),
    ;

    public companion object {
      public fun from(`value`: Long): BuildMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setPolygonName: MethodStringName1<CollisionPolygon2D, Unit, PackedVector2Array> =
        MethodStringName1<CollisionPolygon2D, Unit, PackedVector2Array>("set_polygon")

    @JvmField
    public val getPolygonName: MethodStringName0<CollisionPolygon2D, PackedVector2Array> =
        MethodStringName0<CollisionPolygon2D, PackedVector2Array>("get_polygon")

    @JvmField
    public val setBuildModeName: MethodStringName1<CollisionPolygon2D, Unit, BuildMode> =
        MethodStringName1<CollisionPolygon2D, Unit, BuildMode>("set_build_mode")

    @JvmField
    public val getBuildModeName: MethodStringName0<CollisionPolygon2D, BuildMode> =
        MethodStringName0<CollisionPolygon2D, BuildMode>("get_build_mode")

    @JvmField
    public val setDisabledName: MethodStringName1<CollisionPolygon2D, Unit, Boolean> =
        MethodStringName1<CollisionPolygon2D, Unit, Boolean>("set_disabled")

    @JvmField
    public val isDisabledName: MethodStringName0<CollisionPolygon2D, Boolean> =
        MethodStringName0<CollisionPolygon2D, Boolean>("is_disabled")

    @JvmField
    public val setOneWayCollisionName: MethodStringName1<CollisionPolygon2D, Unit, Boolean> =
        MethodStringName1<CollisionPolygon2D, Unit, Boolean>("set_one_way_collision")

    @JvmField
    public val isOneWayCollisionEnabledName: MethodStringName0<CollisionPolygon2D, Boolean> =
        MethodStringName0<CollisionPolygon2D, Boolean>("is_one_way_collision_enabled")

    @JvmField
    public val setOneWayCollisionMarginName: MethodStringName1<CollisionPolygon2D, Unit, Float> =
        MethodStringName1<CollisionPolygon2D, Unit, Float>("set_one_way_collision_margin")

    @JvmField
    public val getOneWayCollisionMarginName: MethodStringName0<CollisionPolygon2D, Float> =
        MethodStringName0<CollisionPolygon2D, Float>("get_one_way_collision_margin")

    @JvmField
    public val setOneWayCollisionDirectionName: MethodStringName1<CollisionPolygon2D, Unit, Vector2>
        = MethodStringName1<CollisionPolygon2D, Unit, Vector2>("set_one_way_collision_direction")

    @JvmField
    public val getOneWayCollisionDirectionName: MethodStringName0<CollisionPolygon2D, Vector2> =
        MethodStringName0<CollisionPolygon2D, Vector2>("get_one_way_collision_direction")
  }

  public object MethodBindings {
    internal val setPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "set_polygon", 1509147220)

    internal val getPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "get_polygon", 2961356807)

    internal val setBuildModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "set_build_mode", 2780803135)

    internal val getBuildModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "get_build_mode", 3044948800)

    internal val setDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "set_disabled", 2586408642)

    internal val isDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "is_disabled", 36873697)

    internal val setOneWayCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "set_one_way_collision", 2586408642)

    internal val isOneWayCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "is_one_way_collision_enabled", 36873697)

    internal val setOneWayCollisionMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "set_one_way_collision_margin", 373806689)

    internal val getOneWayCollisionMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "get_one_way_collision_margin", 1740695150)

    internal val setOneWayCollisionDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "set_one_way_collision_direction", 743155724)

    internal val getOneWayCollisionDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon2D", "get_one_way_collision_direction", 3341600327)
  }
}
