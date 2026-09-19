// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_RID_LONG_ARRAY_ret_RID
import godot.common.interop.VoidPtr
import godot.core.MethodStringName3
import godot.core.RID
import godot.core.VariantArray
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * Uniform set cache manager for [RenderingDevice]-based renderers. Provides a way to create a
 * uniform set and reuse it in subsequent calls for as long as the uniform set exists. Uniform set will
 * automatically be cleaned up when dependent objects are freed.
 */
@GodotBaseType
public open class UniformSetCacheRD : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(783, scriptPtr)
  }

  public companion object {
    @JvmField
    public val getCacheName:
        MethodStringName3<UniformSetCacheRD, RID, RID, Long, VariantArray<RDUniform>> =
        MethodStringName3<UniformSetCacheRD, RID, RID, Long, VariantArray<RDUniform>>("get_cache")

    /**
     * Creates/returns a cached uniform set based on the provided uniforms for a given shader.
     */
    @JvmStatic
    public final fun getCache(
      shader: RID,
      `set`: Long,
      uniforms: VariantArray<RDUniform>,
    ): RID =
        TransferContext.callPtrMethod_RID_LONG_ARRAY_ret_RID(0L, 0L, MethodBindings.getCachePtr, shader, set, uniforms)
  }

  public object MethodBindings {
    internal val getCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UniformSetCacheRD", "get_cache", 658571723)
  }
}
