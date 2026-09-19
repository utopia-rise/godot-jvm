// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Abstract scene buffers object, created for each viewport for which 3D rendering is done. It
 * manages any additional buffers used during rendering and will discard buffers when the viewport is
 * resized. See also [RenderSceneBuffersRD].
 *
 * **Note:** This is an internal rendering server object. Do not instantiate this class from a
 * script.
 */
@GodotBaseType
public open class RenderSceneBuffers internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(612, scriptPtr)
  }

  /**
   * This method is called by the rendering server when the associated viewport's configuration is
   * changed. It will discard the old buffers and recreate the internal buffers used.
   */
  public final fun configure(config: RenderSceneBuffersConfiguration?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.configurePtr, config)
  }

  public companion object {
    @JvmField
    public val configureName:
        MethodStringName1<RenderSceneBuffers, Unit, RenderSceneBuffersConfiguration?> =
        MethodStringName1<RenderSceneBuffers, Unit, RenderSceneBuffersConfiguration?>("configure")
  }

  public object MethodBindings {
    internal val configurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffers", "configure", 3072623270)
  }
}
