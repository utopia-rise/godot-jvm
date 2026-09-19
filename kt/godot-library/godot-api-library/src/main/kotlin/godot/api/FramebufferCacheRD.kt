// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_ARRAY_ARRAY_LONG_ret_RID
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
 * Framebuffer cache manager for [RenderingDevice]-based renderers. Provides a way to create a
 * framebuffer and reuse it in subsequent calls for as long as the used textures exists. Framebuffers
 * will automatically be cleaned up when dependent objects are freed.
 */
@GodotBaseType
public open class FramebufferCacheRD : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(234, scriptPtr)
  }

  public companion object {
    @JvmField
    public val getCacheMultipassName:
        MethodStringName3<FramebufferCacheRD, RID, VariantArray<RID>, VariantArray<RDFramebufferPass>, Long>
        =
        MethodStringName3<FramebufferCacheRD, RID, VariantArray<RID>, VariantArray<RDFramebufferPass>, Long>("get_cache_multipass")

    /**
     * Creates, or obtains a cached, framebuffer. [textures] lists textures accessed. [passes]
     * defines the subpasses and texture allocation, if left empty a single pass is created and
     * textures are allocated depending on their usage flags. [views] defines the number of views used
     * when rendering.
     */
    @JvmStatic
    public final fun getCacheMultipass(
      textures: VariantArray<RID>,
      passes: VariantArray<RDFramebufferPass>,
      views: Long,
    ): RID =
        TransferContext.callPtrMethod_ARRAY_ARRAY_LONG_ret_RID(0L, 0L, MethodBindings.getCacheMultipassPtr, textures, passes, views)
  }

  public object MethodBindings {
    internal val getCacheMultipassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FramebufferCacheRD", "get_cache_multipass", 3437881813)
  }
}
