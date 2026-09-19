// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Occludes light cast by a Light2D, casting shadows. The LightOccluder2D must be provided with an
 * [OccluderPolygon2D] in order for the shadow to be computed.
 */
@GodotBaseType
public open class LightOccluder2D : Node2D() {
  /**
   * The [OccluderPolygon2D] used to compute the shadow.
   */
  public final inline var occluder: OccluderPolygon2D?
    @JvmName("occluderProperty")
    get() = getOccluderPolygon()
    @JvmName("occluderProperty")
    set(`value`) {
      setOccluderPolygon(value)
    }

  /**
   * If enabled, the occluder will be part of a real-time generated signed distance field that can
   * be used in custom shaders.
   */
  public final inline var sdfCollision: Boolean
    @JvmName("sdfCollisionProperty")
    get() = isSetAsSdfCollision()
    @JvmName("sdfCollisionProperty")
    set(`value`) {
      setAsSdfCollision(value)
    }

  /**
   * The LightOccluder2D's occluder light mask. The LightOccluder2D will cast shadows only from
   * Light2D(s) that have the same light mask(s).
   */
  public final inline var occluderLightMask: Int
    @JvmName("occluderLightMaskProperty")
    get() = getOccluderLightMask()
    @JvmName("occluderLightMaskProperty")
    set(`value`) {
      setOccluderLightMask(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(353, scriptPtr)
  }

  public final fun setOccluderPolygon(polygon: OccluderPolygon2D?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setOccluderPolygonPtr, polygon)
  }

  public final fun getOccluderPolygon(): OccluderPolygon2D? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getOccluderPolygonPtr) as OccluderPolygon2D?)

  public final fun setOccluderLightMask(mask: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOccluderLightMaskPtr, mask.toLong())
  }

  public final fun getOccluderLightMask(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOccluderLightMaskPtr).toInt()

  public final fun setAsSdfCollision(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAsSdfCollisionPtr, enable)
  }

  public final fun isSetAsSdfCollision(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isSetAsSdfCollisionPtr)

  public companion object {
    @JvmField
    public val setOccluderPolygonName: MethodStringName1<LightOccluder2D, Unit, OccluderPolygon2D?>
        = MethodStringName1<LightOccluder2D, Unit, OccluderPolygon2D?>("set_occluder_polygon")

    @JvmField
    public val getOccluderPolygonName: MethodStringName0<LightOccluder2D, OccluderPolygon2D?> =
        MethodStringName0<LightOccluder2D, OccluderPolygon2D?>("get_occluder_polygon")

    @JvmField
    public val setOccluderLightMaskName: MethodStringName1<LightOccluder2D, Unit, Int> =
        MethodStringName1<LightOccluder2D, Unit, Int>("set_occluder_light_mask")

    @JvmField
    public val getOccluderLightMaskName: MethodStringName0<LightOccluder2D, Int> =
        MethodStringName0<LightOccluder2D, Int>("get_occluder_light_mask")

    @JvmField
    public val setAsSdfCollisionName: MethodStringName1<LightOccluder2D, Unit, Boolean> =
        MethodStringName1<LightOccluder2D, Unit, Boolean>("set_as_sdf_collision")

    @JvmField
    public val isSetAsSdfCollisionName: MethodStringName0<LightOccluder2D, Boolean> =
        MethodStringName0<LightOccluder2D, Boolean>("is_set_as_sdf_collision")
  }

  public object MethodBindings {
    internal val setOccluderPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LightOccluder2D", "set_occluder_polygon", 3258315893)

    internal val getOccluderPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LightOccluder2D", "get_occluder_polygon", 3962317075)

    internal val setOccluderLightMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LightOccluder2D", "set_occluder_light_mask", 1286410249)

    internal val getOccluderLightMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LightOccluder2D", "get_occluder_light_mask", 3905245786)

    internal val setAsSdfCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LightOccluder2D", "set_as_sdf_collision", 2586408642)

    internal val isSetAsSdfCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LightOccluder2D", "is_set_as_sdf_collision", 36873697)
  }
}
