// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Abstract base class for scrollbars, typically used to navigate through content that extends
 * beyond the visible area of a control. Scrollbars are [Range]-based controls.
 */
@GodotBaseType
public open class ScrollBar internal constructor() : Range() {
  /**
   * Emitted when the scrollbar is being scrolled.
   */
  public val scrolling: Signal0 by Signal0

  /**
   * Overrides the step used when clicking increment and decrement buttons or when using arrow keys
   * when the [ScrollBar] is focused.
   */
  public final inline var customStep: Float
    @JvmName("customStepProperty")
    get() = getCustomStep()
    @JvmName("customStepProperty")
    set(`value`) {
      setCustomStep(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(647, scriptPtr)
  }

  public final fun setCustomStep(step: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setCustomStepPtr, step.toDouble())
  }

  public final fun getCustomStep(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCustomStepPtr).toFloat()

  public companion object {
    @JvmField
    public val setCustomStepName: MethodStringName1<ScrollBar, Unit, Float> =
        MethodStringName1<ScrollBar, Unit, Float>("set_custom_step")

    @JvmField
    public val getCustomStepName: MethodStringName0<ScrollBar, Float> =
        MethodStringName0<ScrollBar, Float>("get_custom_step")
  }

  public object MethodBindings {
    internal val setCustomStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollBar", "set_custom_step", 373806689)

    internal val getCustomStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollBar", "get_custom_step", 1740695150)
  }
}
