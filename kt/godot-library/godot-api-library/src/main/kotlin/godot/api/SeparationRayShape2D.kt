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
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 2D ray shape, intended for use in physics. Usually used to provide a shape for a
 * [CollisionShape2D]. When a [SeparationRayShape2D] collides with an object, it tries to separate
 * itself from it by moving its endpoint to the collision point. For example, a [SeparationRayShape2D]
 * next to a character can allow it to instantly move up when touching stairs.
 */
@GodotBaseType
public open class SeparationRayShape2D : Shape2D() {
  /**
   * The ray's length.
   */
  public final inline var length: Float
    @JvmName("lengthProperty")
    get() = getLength()
    @JvmName("lengthProperty")
    set(`value`) {
      setLength(value)
    }

  /**
   * If `false` (default), the shape always separates and returns a normal along its own direction.
   *
   * If `true`, the shape can return the correct normal and separate in any direction, allowing
   * sliding motion on slopes.
   */
  public final inline var slideOnSlope: Boolean
    @JvmName("slideOnSlopeProperty")
    get() = getSlideOnSlope()
    @JvmName("slideOnSlopeProperty")
    set(`value`) {
      setSlideOnSlope(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(651, scriptPtr)
  }

  public final fun setLength(length: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, length.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setLengthPtr, 0)
  }

  public final fun getLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLengthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSlideOnSlope(active: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, active)
    TransferContext.callPtrMethod(MethodBindings.setSlideOnSlopePtr, 0)
  }

  public final fun getSlideOnSlope(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSlideOnSlopePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setLengthName: MethodStringName1<SeparationRayShape2D, Unit, Float> =
        MethodStringName1<SeparationRayShape2D, Unit, Float>("set_length")

    @JvmField
    public val getLengthName: MethodStringName0<SeparationRayShape2D, Float> =
        MethodStringName0<SeparationRayShape2D, Float>("get_length")

    @JvmField
    public val setSlideOnSlopeName: MethodStringName1<SeparationRayShape2D, Unit, Boolean> =
        MethodStringName1<SeparationRayShape2D, Unit, Boolean>("set_slide_on_slope")

    @JvmField
    public val getSlideOnSlopeName: MethodStringName0<SeparationRayShape2D, Boolean> =
        MethodStringName0<SeparationRayShape2D, Boolean>("get_slide_on_slope")
  }

  public object MethodBindings {
    internal val setLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SeparationRayShape2D", "set_length", 373806689)

    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SeparationRayShape2D", "get_length", 1740695150)

    internal val setSlideOnSlopePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SeparationRayShape2D", "set_slide_on_slope", 2586408642)

    internal val getSlideOnSlopePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SeparationRayShape2D", "get_slide_on_slope", 36873697)
  }
}
