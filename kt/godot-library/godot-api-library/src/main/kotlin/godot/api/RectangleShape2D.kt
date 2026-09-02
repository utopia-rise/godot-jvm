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
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 2D rectangle shape, intended for use in physics. Usually used to provide a shape for a
 * [CollisionShape2D].
 *
 * **Performance:** [RectangleShape2D] is fast to check collisions against. It is faster than
 * [CapsuleShape2D], but slower than [CircleShape2D].
 */
@GodotBaseType
public open class RectangleShape2D : Shape2D() {
  /**
   * The rectangle's width and height.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector2
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(602, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rectangleshape2d.size
   * //Your changes
   * rectangleshape2d.size = myCoreType
   * ``````
   *
   * The rectangle's width and height.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector2.() -> Unit): Vector2 = size.apply {
     block(this)
     size = this
  }

  public final fun setSize(size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<RectangleShape2D, Unit, Vector2> =
        MethodStringName1<RectangleShape2D, Unit, Vector2>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<RectangleShape2D, Vector2> =
        MethodStringName0<RectangleShape2D, Vector2>("get_size")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RectangleShape2D", "set_size", 743155724)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RectangleShape2D", "get_size", 3341600327)
  }
}
