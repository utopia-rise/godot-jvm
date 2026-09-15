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
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A directional light is a type of [Light2D] node that models an infinite number of parallel rays
 * covering the entire scene. It is used for lights with strong intensity that are located far away
 * from the scene (for example: to model sunlight or moonlight).
 *
 * Light is emitted in the +Y direction of the node's global basis. For an unrotated light, this
 * means that the light is emitted downwards. The position of the node is ignored; only the basis is
 * used to determine light direction.
 *
 * **Note:** [DirectionalLight2D] does not support light cull masks (but it supports shadow cull
 * masks). It will always light up 2D nodes, regardless of the 2D node's [CanvasItem.lightMask].
 */
@GodotBaseType
public open class DirectionalLight2D : Light2D() {
  /**
   * The height of the light. Used with 2D normal mapping. Ranges from 0 (parallel to the plane) to
   * 1 (perpendicular to the plane).
   */
  public final inline var height: Float
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * The maximum distance from the camera center objects can be before their shadows are culled (in
   * pixels). Decreasing this value can prevent objects located outside the camera from casting shadows
   * (while also improving performance). [Camera2D.zoom] is not taken into account by [maxDistance],
   * which means that at higher zoom values, shadows will appear to fade out sooner when zooming onto a
   * given point.
   */
  public final inline var maxDistance: Float
    @JvmName("maxDistanceProperty")
    get() = getMaxDistance()
    @JvmName("maxDistanceProperty")
    set(`value`) {
      setMaxDistance(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(206, scriptPtr)
  }

  public final fun setMaxDistance(pixels: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, pixels.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMaxDistancePtr, 0)
  }

  public final fun getMaxDistance(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxDistancePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setMaxDistanceName: MethodStringName1<DirectionalLight2D, Unit, Float> =
        MethodStringName1<DirectionalLight2D, Unit, Float>("set_max_distance")

    @JvmField
    public val getMaxDistanceName: MethodStringName0<DirectionalLight2D, Float> =
        MethodStringName0<DirectionalLight2D, Float>("get_max_distance")
  }

  public object MethodBindings {
    internal val setMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirectionalLight2D", "set_max_distance", 373806689)

    internal val getMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirectionalLight2D", "get_max_distance", 1740695150)
  }
}
