// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Defines a hit group for use with [RenderingDevice.raytracingPipelineCreate].
 *
 * A hit group combines shaders that are executed when a ray intersects geometry. It may include a
 * closest-hit shader, any-hit shader, and intersection shader.
 *
 * Hit groups are referenced by index when populating hit shader binding tables using
 * [RenderingDevice.hitSbtRangeUpdate].
 */
@GodotBaseType
public open class RDHitGroup : RefCounted() {
  /**
   * Closest-hit shader for this hit group. Executed for the closest intersection. Can be `null`.
   */
  public final inline var closestHitShader: RDPipelineShader?
    @JvmName("closestHitShaderProperty")
    get() = getClosestHitShader()
    @JvmName("closestHitShaderProperty")
    set(`value`) {
      setClosestHitShader(value)
    }

  /**
   * Any-hit shader for this hit group. Executed for each potential intersection. Can be `null`.
   */
  public final inline var anyHitShader: RDPipelineShader?
    @JvmName("anyHitShaderProperty")
    get() = getAnyHitShader()
    @JvmName("anyHitShaderProperty")
    set(`value`) {
      setAnyHitShader(value)
    }

  /**
   * Intersection shader for this hit group. Required for non-triangle geometry. Must be `null` when
   * using for triangle geometry.
   */
  public final inline var intersectionShader: RDPipelineShader?
    @JvmName("intersectionShaderProperty")
    get() = getIntersectionShader()
    @JvmName("intersectionShaderProperty")
    set(`value`) {
      setIntersectionShader(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(581, scriptPtr)
  }

  public final fun setClosestHitShader(pMember: RDPipelineShader?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setClosestHitShaderPtr, pMember)
  }

  public final fun getClosestHitShader(): RDPipelineShader? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getClosestHitShaderPtr) as RDPipelineShader?)

  public final fun setAnyHitShader(pMember: RDPipelineShader?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setAnyHitShaderPtr, pMember)
  }

  public final fun getAnyHitShader(): RDPipelineShader? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getAnyHitShaderPtr) as RDPipelineShader?)

  public final fun setIntersectionShader(pMember: RDPipelineShader?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setIntersectionShaderPtr, pMember)
  }

  public final fun getIntersectionShader(): RDPipelineShader? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getIntersectionShaderPtr) as RDPipelineShader?)

  public companion object {
    @JvmField
    public val setClosestHitShaderName: MethodStringName1<RDHitGroup, Unit, RDPipelineShader?> =
        MethodStringName1<RDHitGroup, Unit, RDPipelineShader?>("set_closest_hit_shader")

    @JvmField
    public val getClosestHitShaderName: MethodStringName0<RDHitGroup, RDPipelineShader?> =
        MethodStringName0<RDHitGroup, RDPipelineShader?>("get_closest_hit_shader")

    @JvmField
    public val setAnyHitShaderName: MethodStringName1<RDHitGroup, Unit, RDPipelineShader?> =
        MethodStringName1<RDHitGroup, Unit, RDPipelineShader?>("set_any_hit_shader")

    @JvmField
    public val getAnyHitShaderName: MethodStringName0<RDHitGroup, RDPipelineShader?> =
        MethodStringName0<RDHitGroup, RDPipelineShader?>("get_any_hit_shader")

    @JvmField
    public val setIntersectionShaderName: MethodStringName1<RDHitGroup, Unit, RDPipelineShader?> =
        MethodStringName1<RDHitGroup, Unit, RDPipelineShader?>("set_intersection_shader")

    @JvmField
    public val getIntersectionShaderName: MethodStringName0<RDHitGroup, RDPipelineShader?> =
        MethodStringName0<RDHitGroup, RDPipelineShader?>("get_intersection_shader")
  }

  public object MethodBindings {
    internal val setClosestHitShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDHitGroup", "set_closest_hit_shader", 2556777288)

    internal val getClosestHitShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDHitGroup", "get_closest_hit_shader", 2937716847)

    internal val setAnyHitShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDHitGroup", "set_any_hit_shader", 2556777288)

    internal val getAnyHitShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDHitGroup", "get_any_hit_shader", 2937716847)

    internal val setIntersectionShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDHitGroup", "set_intersection_shader", 2556777288)

    internal val getIntersectionShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDHitGroup", "get_intersection_shader", 2937716847)
  }
}
