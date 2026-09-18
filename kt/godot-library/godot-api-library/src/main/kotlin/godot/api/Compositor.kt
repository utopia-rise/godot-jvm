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
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * The compositor resource stores attributes used to customize how a [Viewport] is rendered.
 */
@GodotBaseType
public open class Compositor : Resource() {
  /**
   * The custom [CompositorEffect]s that are applied during rendering of viewports using this
   * compositor.
   */
  public final inline var compositorEffects: VariantArray<CompositorEffect>
    @JvmName("compositorEffectsProperty")
    get() = getCompositorEffects()
    @JvmName("compositorEffectsProperty")
    set(`value`) {
      setCompositorEffects(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(171, scriptPtr)
  }

  public final fun setCompositorEffects(compositorEffects: VariantArray<CompositorEffect>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, compositorEffects)
    TransferContext.callPtrMethod(MethodBindings.setCompositorEffectsPtr, 0)
  }

  public final fun getCompositorEffects(): VariantArray<CompositorEffect> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCompositorEffectsPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<CompositorEffect>)
  }

  public companion object {
    @JvmField
    public val setCompositorEffectsName:
        MethodStringName1<Compositor, Unit, VariantArray<CompositorEffect>> =
        MethodStringName1<Compositor, Unit, VariantArray<CompositorEffect>>("set_compositor_effects")

    @JvmField
    public val getCompositorEffectsName:
        MethodStringName0<Compositor, VariantArray<CompositorEffect>> =
        MethodStringName0<Compositor, VariantArray<CompositorEffect>>("get_compositor_effects")
  }

  public object MethodBindings {
    internal val setCompositorEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Compositor", "set_compositor_effects", 381264803)

    internal val getCompositorEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Compositor", "get_compositor_effects", 3995934104)
  }
}
