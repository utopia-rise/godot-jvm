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
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.core.PackedVector2Array
import godot.core.RID
import godot.core.Rect2
import godot.core.Transform2D
import godot.core.Vector2
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_PACKED_VECTOR2_ARRAY
import godot.readReturnValue_RECT2
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_RID_COLOR
import godot.writeMethodArguments_TRANSFORM2D_OBJECT_TRANSFORM2D
import godot.writeMethodArguments_TRANSFORM2D_VECTOR2_OBJECT_TRANSFORM2D_VECTOR2
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Abstract base class for all 2D shapes, intended for use in physics.
 *
 * **Performance:** Primitive shapes, especially [CircleShape2D], are fast to check collisions
 * against. [ConvexPolygonShape2D] is slower, and [ConcavePolygonShape2D] is the slowest.
 */
@GodotBaseType
public open class Shape2D internal constructor() : Resource() {
  /**
   * The shape's custom solver bias. Defines how much bodies react to enforce contact separation
   * when this shape is involved.
   *
   * When set to `0`, the default value from [ProjectSettings.physics/2d/solver/defaultContactBias]
   * is used.
   */
  public final inline var customSolverBias: Float
    @JvmName("customSolverBiasProperty")
    get() = getCustomSolverBias()
    @JvmName("customSolverBiasProperty")
    set(`value`) {
      setCustomSolverBias(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(659, scriptPtr)
  }

  public final fun setCustomSolverBias(bias: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, bias.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCustomSolverBiasPtr, 0)
  }

  public final fun getCustomSolverBias(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCustomSolverBiasPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns `true` if this shape is colliding with another.
   *
   * This method needs the transformation matrix for this shape ([localXform]), the shape to check
   * collisions with ([withShape]), and the transformation matrix of that shape ([shapeXform]).
   */
  public final fun collide(
    localXform: Transform2D,
    withShape: Shape2D,
    shapeXform: Transform2D,
  ): Boolean {
    TransferContext.writeMethodArguments_TRANSFORM2D_OBJECT_TRANSFORM2D(ptr, objectID.id, localXform, withShape, shapeXform)
    TransferContext.callPtrMethod(MethodBindings.collidePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns whether this shape would collide with another, if a given movement was applied.
   *
   * This method needs the transformation matrix for this shape ([localXform]), the movement to test
   * on this shape ([localMotion]), the shape to check collisions with ([withShape]), the
   * transformation matrix of that shape ([shapeXform]), and the movement to test onto the other object
   * ([shapeMotion]).
   */
  public final fun collideWithMotion(
    localXform: Transform2D,
    localMotion: Vector2,
    withShape: Shape2D,
    shapeXform: Transform2D,
    shapeMotion: Vector2,
  ): Boolean {
    TransferContext.writeMethodArguments_TRANSFORM2D_VECTOR2_OBJECT_TRANSFORM2D_VECTOR2(ptr, objectID.id, localXform, localMotion, withShape, shapeXform, shapeMotion)
    TransferContext.callPtrMethod(MethodBindings.collideWithMotionPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a list of contact point pairs where this shape touches another.
   *
   * If there are no collisions, the returned list is empty. Otherwise, the returned list contains
   * contact points arranged in pairs, with entries alternating between points on the boundary of this
   * shape and points on the boundary of [withShape].
   *
   * A collision pair A, B can be used to calculate the collision normal with `(B -
   * A).normalized()`, and the collision depth with `(B - A).length()`. This information is typically
   * used to separate shapes, particularly in collision solvers.
   *
   * This method needs the transformation matrix for this shape ([localXform]), the shape to check
   * collisions with ([withShape]), and the transformation matrix of that shape ([shapeXform]).
   */
  public final fun collideAndGetContacts(
    localXform: Transform2D,
    withShape: Shape2D,
    shapeXform: Transform2D,
  ): PackedVector2Array {
    TransferContext.writeMethodArguments_TRANSFORM2D_OBJECT_TRANSFORM2D(ptr, objectID.id, localXform, withShape, shapeXform)
    TransferContext.callMethod(MethodBindings.collideAndGetContactsPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR2_ARRAY()
  }

  /**
   * Returns a list of contact point pairs where this shape would touch another, if a given movement
   * was applied.
   *
   * If there would be no collisions, the returned list is empty. Otherwise, the returned list
   * contains contact points arranged in pairs, with entries alternating between points on the boundary
   * of this shape and points on the boundary of [withShape].
   *
   * A collision pair A, B can be used to calculate the collision normal with `(B -
   * A).normalized()`, and the collision depth with `(B - A).length()`. This information is typically
   * used to separate shapes, particularly in collision solvers.
   *
   * This method needs the transformation matrix for this shape ([localXform]), the movement to test
   * on this shape ([localMotion]), the shape to check collisions with ([withShape]), the
   * transformation matrix of that shape ([shapeXform]), and the movement to test onto the other object
   * ([shapeMotion]).
   */
  public final fun collideWithMotionAndGetContacts(
    localXform: Transform2D,
    localMotion: Vector2,
    withShape: Shape2D,
    shapeXform: Transform2D,
    shapeMotion: Vector2,
  ): PackedVector2Array {
    TransferContext.writeMethodArguments_TRANSFORM2D_VECTOR2_OBJECT_TRANSFORM2D_VECTOR2(ptr, objectID.id, localXform, localMotion, withShape, shapeXform, shapeMotion)
    TransferContext.callMethod(MethodBindings.collideWithMotionAndGetContactsPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR2_ARRAY()
  }

  /**
   * Draws a solid shape onto a [CanvasItem] with the [RenderingServer] API filled with the
   * specified [color]. The exact drawing method is specific for each shape and cannot be configured.
   */
  public final fun draw(canvasItem: RID, color: Color): Unit {
    TransferContext.writeMethodArguments_RID_COLOR(ptr, objectID.id, canvasItem, color)
    TransferContext.callPtrMethod(MethodBindings.drawPtr, 0)
  }

  /**
   * Returns a [Rect2] representing the shapes boundary.
   */
  public final fun getRect(): Rect2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRectPtr, 7)
    return TransferContext.readReturnValue_RECT2()
  }

  public companion object {
    @JvmField
    public val setCustomSolverBiasName: MethodStringName1<Shape2D, Unit, Float> =
        MethodStringName1<Shape2D, Unit, Float>("set_custom_solver_bias")

    @JvmField
    public val getCustomSolverBiasName: MethodStringName0<Shape2D, Float> =
        MethodStringName0<Shape2D, Float>("get_custom_solver_bias")

    @JvmField
    public val collideName: MethodStringName3<Shape2D, Boolean, Transform2D, Shape2D, Transform2D> =
        MethodStringName3<Shape2D, Boolean, Transform2D, Shape2D, Transform2D>("collide")

    @JvmField
    public val collideWithMotionName:
        MethodStringName5<Shape2D, Boolean, Transform2D, Vector2, Shape2D, Transform2D, Vector2> =
        MethodStringName5<Shape2D, Boolean, Transform2D, Vector2, Shape2D, Transform2D, Vector2>("collide_with_motion")

    @JvmField
    public val collideAndGetContactsName:
        MethodStringName3<Shape2D, PackedVector2Array, Transform2D, Shape2D, Transform2D> =
        MethodStringName3<Shape2D, PackedVector2Array, Transform2D, Shape2D, Transform2D>("collide_and_get_contacts")

    @JvmField
    public val collideWithMotionAndGetContactsName:
        MethodStringName5<Shape2D, PackedVector2Array, Transform2D, Vector2, Shape2D, Transform2D, Vector2>
        =
        MethodStringName5<Shape2D, PackedVector2Array, Transform2D, Vector2, Shape2D, Transform2D, Vector2>("collide_with_motion_and_get_contacts")

    @JvmField
    public val drawName: MethodStringName2<Shape2D, Unit, RID, Color> =
        MethodStringName2<Shape2D, Unit, RID, Color>("draw")

    @JvmField
    public val getRectName: MethodStringName0<Shape2D, Rect2> =
        MethodStringName0<Shape2D, Rect2>("get_rect")
  }

  public object MethodBindings {
    internal val setCustomSolverBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shape2D", "set_custom_solver_bias", 373806689)

    internal val getCustomSolverBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shape2D", "get_custom_solver_bias", 1740695150)

    internal val collidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shape2D", "collide", 3709843132)

    internal val collideWithMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shape2D", "collide_with_motion", 2869556801)

    internal val collideAndGetContactsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shape2D", "collide_and_get_contacts", 3056932662)

    internal val collideWithMotionAndGetContactsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shape2D", "collide_with_motion_and_get_contacts", 3620351573)

    internal val drawPtr: VoidPtr = TypeManager.getMethodBindPtr("Shape2D", "draw", 2948539648)

    internal val getRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shape2D", "get_rect", 1639390495)
  }
}
