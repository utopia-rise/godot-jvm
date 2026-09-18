// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Suppress
import kotlin.Unit

/**
 * LightmapperRD ("RD" stands for [RenderingDevice]) is the built-in GPU-based lightmapper for use
 * with [LightmapGI]. On most dedicated GPUs, it can bake lightmaps much faster than most CPU-based
 * lightmappers. LightmapperRD uses compute shaders to bake lightmaps, so it does not require CUDA or
 * OpenCL libraries to be installed to be usable.
 *
 * **Note:** This lightmapper requires the GPU to support the [RenderingDevice] backend (Forward+
 * and Mobile renderers). When using the Compatibility renderer, baking will use a temporary
 * [RenderingDevice]. Support for [RenderingDevice] is not required to *render* lightmaps that were
 * already baked beforehand.
 */
@GodotBaseType
public open class LightmapperRD : Lightmapper() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(358, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
