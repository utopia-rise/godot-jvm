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
import godot.core.PackedVector2Array
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A node that provides a thickened polygon shape (a prism) to a [CollisionObject3D] parent and
 * allows it to be edited. The polygon can be concave or convex. This can give a detection shape to an
 * [Area3D] or turn a [PhysicsBody3D] into a solid object.
 *
 * **Warning:** A non-uniformly scaled [CollisionShape3D] will likely not behave as expected. Make
 * sure to keep its scale the same on all axes and adjust its shape resource instead.
 */
@GodotBaseType
public open class CollisionPolygon3D : Node3D() {
  /**
   * Length that the resulting collision extends in either direction perpendicular to its 2D
   * polygon.
   */
  public final inline var depth: Float
    @JvmName("depthProperty")
    get() = getDepth()
    @JvmName("depthProperty")
    set(`value`) {
      setDepth(value)
    }

  /**
   * If `true`, no collision will be produced. This property should be changed with
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
   * Array of vertices which define the 2D polygon in the local XY plane.
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
   * The collision margin for the generated [Shape3D]. See [Shape3D.margin] for more details.
   */
  public final inline var margin: Float
    @JvmName("marginProperty")
    get() = getMargin()
    @JvmName("marginProperty")
    set(`value`) {
      setMargin(value)
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

  /**
   * If `true`, when the shape is displayed, it will show a solid fill color in addition to its
   * wireframe.
   */
  public final inline var debugFill: Boolean
    @JvmName("debugFillProperty")
    get() = getEnableDebugFill()
    @JvmName("debugFillProperty")
    set(`value`) {
      setEnableDebugFill(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(166, scriptPtr)
  }

  /**
   * This is a helper function for [polygon] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = collisionpolygon3d.polygon
   * //Your changes
   * collisionpolygon3d.polygon = myCoreType
   * ``````
   *
   * Array of vertices which define the 2D polygon in the local XY plane.
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
   * Array of vertices which define the 2D polygon in the local XY plane.
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
   * This is a helper function for [debugColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = collisionpolygon3d.debugColor
   * //Your changes
   * collisionpolygon3d.debugColor = myCoreType
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

  public final fun setDepth(depth: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to depth.toDouble())
    TransferContext.callMethod(MethodBindings.setDepthPtr)
  }

  public final fun getDepth(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDepthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
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

  public final fun setDisabled(disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setDisabledPtr)
  }

  public final fun isDisabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
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

  public final fun setEnableDebugFill(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setEnableDebugFillPtr)
  }

  public final fun getEnableDebugFill(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnableDebugFillPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to margin.toDouble())
    TransferContext.callMethod(MethodBindings.setMarginPtr)
  }

  public final fun getMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public companion object {
    @JvmField
    public val setDepthName: MethodStringName1<CollisionPolygon3D, Unit, Float> =
        MethodStringName1<CollisionPolygon3D, Unit, Float>("set_depth")

    @JvmField
    public val getDepthName: MethodStringName0<CollisionPolygon3D, Float> =
        MethodStringName0<CollisionPolygon3D, Float>("get_depth")

    @JvmField
    public val setPolygonName: MethodStringName1<CollisionPolygon3D, Unit, PackedVector2Array> =
        MethodStringName1<CollisionPolygon3D, Unit, PackedVector2Array>("set_polygon")

    @JvmField
    public val getPolygonName: MethodStringName0<CollisionPolygon3D, PackedVector2Array> =
        MethodStringName0<CollisionPolygon3D, PackedVector2Array>("get_polygon")

    @JvmField
    public val setDisabledName: MethodStringName1<CollisionPolygon3D, Unit, Boolean> =
        MethodStringName1<CollisionPolygon3D, Unit, Boolean>("set_disabled")

    @JvmField
    public val isDisabledName: MethodStringName0<CollisionPolygon3D, Boolean> =
        MethodStringName0<CollisionPolygon3D, Boolean>("is_disabled")

    @JvmField
    public val setDebugColorName: MethodStringName1<CollisionPolygon3D, Unit, Color> =
        MethodStringName1<CollisionPolygon3D, Unit, Color>("set_debug_color")

    @JvmField
    public val getDebugColorName: MethodStringName0<CollisionPolygon3D, Color> =
        MethodStringName0<CollisionPolygon3D, Color>("get_debug_color")

    @JvmField
    public val setEnableDebugFillName: MethodStringName1<CollisionPolygon3D, Unit, Boolean> =
        MethodStringName1<CollisionPolygon3D, Unit, Boolean>("set_enable_debug_fill")

    @JvmField
    public val getEnableDebugFillName: MethodStringName0<CollisionPolygon3D, Boolean> =
        MethodStringName0<CollisionPolygon3D, Boolean>("get_enable_debug_fill")

    @JvmField
    public val setMarginName: MethodStringName1<CollisionPolygon3D, Unit, Float> =
        MethodStringName1<CollisionPolygon3D, Unit, Float>("set_margin")

    @JvmField
    public val getMarginName: MethodStringName0<CollisionPolygon3D, Float> =
        MethodStringName0<CollisionPolygon3D, Float>("get_margin")
  }

  public object MethodBindings {
    internal val setDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "set_depth", 373806689)

    internal val getDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "get_depth", 1740695150)

    internal val setPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "set_polygon", 1509147220)

    internal val getPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "get_polygon", 2961356807)

    internal val setDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "set_disabled", 2586408642)

    internal val isDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "is_disabled", 36873697)

    internal val setDebugColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "set_debug_color", 2920490490)

    internal val getDebugColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "get_debug_color", 3444240500)

    internal val setEnableDebugFillPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "set_enable_debug_fill", 2586408642)

    internal val getEnableDebugFillPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "get_enable_debug_fill", 36873697)

    internal val setMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "set_margin", 373806689)

    internal val getMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CollisionPolygon3D", "get_margin", 1740695150)
  }
}
