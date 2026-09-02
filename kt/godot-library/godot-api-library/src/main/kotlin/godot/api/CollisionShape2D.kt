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
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A node that provides a [Shape2D] to a [CollisionObject2D] parent and allows it to be edited. This
 * can give a detection shape to an [Area2D] or turn a [PhysicsBody2D] into a solid object.
 */
@GodotBaseType
public open class CollisionShape2D : Node2D() {
  /**
   * The actual shape owned by this collision shape.
   */
  public final inline var shape: Shape2D?
    @JvmName("shapeProperty")
    get() = getShape()
    @JvmName("shapeProperty")
    set(`value`) {
      setShape(value)
    }

  /**
   * A disabled collision shape has no effect in the world. This property should be changed with
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
   * Sets whether this collision shape should only detect collision on one side (top or bottom).
   *
   * **Note:** This property has no effect if this [CollisionShape2D] is a child of an [Area2D]
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
   * and work better for colliders that enter the shape at a high velocity.
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

  /**
   * The collision shape color that is displayed in the editor, or in the running project if **Debug
   * > Visible Collision Shapes** is checked at the top of the editor.
   *
   * **Note:** The default value is [ProjectSettings.debug/shapes/collision/shapeColor]. The
   * `Color(0, 0, 0, 0)` value documented here is a placeholder, and not the actual default debug
   * color.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var debugColor: Color
    @JvmName("debugColorProperty")
    get() = getDebugColor()
    @JvmName("debugColorProperty")
    set(`value`) {
      setDebugColor(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(167, scriptPtr)
  }

  /**
   * This is a helper function for [oneWayCollisionDirection] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = collisionshape2d.oneWayCollisionDirection
   * //Your changes
   * collisionshape2d.oneWayCollisionDirection = myCoreType
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

  /**
   * This is a helper function for [debugColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = collisionshape2d.debugColor
   * //Your changes
   * collisionshape2d.debugColor = myCoreType
   * ``````
   *
   * The collision shape color that is displayed in the editor, or in the running project if **Debug
   * > Visible Collision Shapes** is checked at the top of the editor.
   *
   * **Note:** The default value is [ProjectSettings.debug/shapes/collision/shapeColor]. The
   * `Color(0, 0, 0, 0)` value documented here is a placeholder, and not the actual default debug
   * color.
   */
  @CoreTypeHelper
  public final fun debugColorMutate(block: Color.() -> Unit): Color = debugColor.apply {
     block(this)
     debugColor = this
  }

  public final fun setShape(shape: Shape2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to shape)
    TransferContext.callMethod(MethodBindings.setShapePtr)
  }

  public final fun getShape(): Shape2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShapePtr)
    return (TransferContext.readReturnValue(OBJECT) as Shape2D?)
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

  public final fun setDebugColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setDebugColorPtr)
  }

  public final fun getDebugColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDebugColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public companion object {
    @JvmField
    public val setShapeName: MethodStringName1<CollisionShape2D, Unit, Shape2D?> =
        MethodStringName1<CollisionShape2D, Unit, Shape2D?>("set_shape")

    @JvmField
    public val getShapeName: MethodStringName0<CollisionShape2D, Shape2D?> =
        MethodStringName0<CollisionShape2D, Shape2D?>("get_shape")

    @JvmField
    public val setDisabledName: MethodStringName1<CollisionShape2D, Unit, Boolean> =
        MethodStringName1<CollisionShape2D, Unit, Boolean>("set_disabled")

    @JvmField
    public val isDisabledName: MethodStringName0<CollisionShape2D, Boolean> =
        MethodStringName0<CollisionShape2D, Boolean>("is_disabled")

    @JvmField
    public val setOneWayCollisionName: MethodStringName1<CollisionShape2D, Unit, Boolean> =
        MethodStringName1<CollisionShape2D, Unit, Boolean>("set_one_way_collision")

    @JvmField
    public val isOneWayCollisionEnabledName: MethodStringName0<CollisionShape2D, Boolean> =
        MethodStringName0<CollisionShape2D, Boolean>("is_one_way_collision_enabled")

    @JvmField
    public val setOneWayCollisionMarginName: MethodStringName1<CollisionShape2D, Unit, Float> =
        MethodStringName1<CollisionShape2D, Unit, Float>("set_one_way_collision_margin")

    @JvmField
    public val getOneWayCollisionMarginName: MethodStringName0<CollisionShape2D, Float> =
        MethodStringName0<CollisionShape2D, Float>("get_one_way_collision_margin")

    @JvmField
    public val setOneWayCollisionDirectionName: MethodStringName1<CollisionShape2D, Unit, Vector2> =
        MethodStringName1<CollisionShape2D, Unit, Vector2>("set_one_way_collision_direction")

    @JvmField
    public val getOneWayCollisionDirectionName: MethodStringName0<CollisionShape2D, Vector2> =
        MethodStringName0<CollisionShape2D, Vector2>("get_one_way_collision_direction")

    @JvmField
    public val setDebugColorName: MethodStringName1<CollisionShape2D, Unit, Color> =
        MethodStringName1<CollisionShape2D, Unit, Color>("set_debug_color")

    @JvmField
    public val getDebugColorName: MethodStringName0<CollisionShape2D, Color> =
        MethodStringName0<CollisionShape2D, Color>("get_debug_color")
  }

  public object MethodBindings {
    internal val setShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "set_shape", 771364740)

    internal val getShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "get_shape", 522005891)

    internal val setDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "set_disabled", 2586408642)

    internal val isDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "is_disabled", 36873697)

    internal val setOneWayCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "set_one_way_collision", 2586408642)

    internal val isOneWayCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "is_one_way_collision_enabled", 36873697)

    internal val setOneWayCollisionMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "set_one_way_collision_margin", 373806689)

    internal val getOneWayCollisionMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "get_one_way_collision_margin", 1740695150)

    internal val setOneWayCollisionDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "set_one_way_collision_direction", 743155724)

    internal val getOneWayCollisionDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "get_one_way_collision_direction", 3341600327)

    internal val setDebugColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "set_debug_color", 2920490490)

    internal val getDebugColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionShape2D", "get_debug_color", 3444240500)
  }
}
