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
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A container that displays the contents of underlying [SubViewport] child nodes. It uses the
 * combined size of the [SubViewport]s as minimum size, unless [stretch] is enabled.
 *
 * **Note:** Changing a [SubViewportContainer]'s [Control.scale] will cause its contents to appear
 * distorted. To change its visual size without causing distortion, adjust the node's margins instead
 * (if it's not already in a container).
 *
 * **Note:** The [SubViewportContainer] forwards mouse-enter and mouse-exit notifications to its
 * sub-viewports.
 */
@GodotBaseType
public open class SubViewportContainer : Container() {
  /**
   * If `true`, the sub-viewport will be automatically resized to the control's size.
   *
   * **Note:** If `true`, this will prohibit changing [SubViewport.size] of its children manually.
   */
  public final inline var stretch: Boolean
    @JvmName("stretchProperty")
    get() = isStretchEnabled()
    @JvmName("stretchProperty")
    set(`value`) {
      setStretch(value)
    }

  /**
   * Divides the sub-viewport's effective resolution by this value while preserving its scale. This
   * can be used to speed up rendering.
   *
   * For example, a 1280×720 sub-viewport with [stretchShrink] set to `2` will be rendered at
   * 640×360 while occupying the same size in the container.
   *
   * **Note:** [stretch] must be `true` for this property to work.
   */
  public final inline var stretchShrink: Int
    @JvmName("stretchShrinkProperty")
    get() = getStretchShrink()
    @JvmName("stretchShrinkProperty")
    set(`value`) {
      setStretchShrink(value)
    }

  /**
   * Configure, if either the [SubViewportContainer] or alternatively the [Control] nodes of its
   * [SubViewport] children should be available as targets of mouse-related functionalities, like
   * identifying the drop target in drag-and-drop operations or cursor shape of hovered [Control] node.
   *
   * If `false`, the [Control] nodes inside its [SubViewport] children are considered as targets.
   *
   * If `true`, the [SubViewportContainer] itself will be considered as a target.
   */
  public final inline var mouseTarget: Boolean
    @JvmName("mouseTargetProperty")
    get() = isMouseTargetEnabled()
    @JvmName("mouseTargetProperty")
    set(`value`) {
      setMouseTarget(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(721, scriptPtr)
  }

  /**
   * Virtual method to be implemented by the user. If it returns `true`, the [event] is propagated
   * to [SubViewport] children. Propagation doesn't happen if it returns `false`. If the function is
   * not implemented, all events are propagated to SubViewports.
   */
  public open fun _propagateInputEvent(event: InputEvent): Boolean {
    throw NotImplementedError("SubViewportContainer::_propagateInputEvent is not implemented.")
  }

  public final fun setStretch(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setStretchPtr, enable)
  }

  public final fun isStretchEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isStretchEnabledPtr)

  public final fun setStretchShrink(amount: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setStretchShrinkPtr, amount.toLong())
  }

  public final fun getStretchShrink(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getStretchShrinkPtr).toInt()

  public final fun setMouseTarget(amount: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setMouseTargetPtr, amount)
  }

  public final fun isMouseTargetEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isMouseTargetEnabledPtr)

  public companion object {
    @JvmField
    public val setStretchName: MethodStringName1<SubViewportContainer, Unit, Boolean> =
        MethodStringName1<SubViewportContainer, Unit, Boolean>("set_stretch")

    @JvmField
    public val isStretchEnabledName: MethodStringName0<SubViewportContainer, Boolean> =
        MethodStringName0<SubViewportContainer, Boolean>("is_stretch_enabled")

    @JvmField
    public val setStretchShrinkName: MethodStringName1<SubViewportContainer, Unit, Int> =
        MethodStringName1<SubViewportContainer, Unit, Int>("set_stretch_shrink")

    @JvmField
    public val getStretchShrinkName: MethodStringName0<SubViewportContainer, Int> =
        MethodStringName0<SubViewportContainer, Int>("get_stretch_shrink")

    @JvmField
    public val setMouseTargetName: MethodStringName1<SubViewportContainer, Unit, Boolean> =
        MethodStringName1<SubViewportContainer, Unit, Boolean>("set_mouse_target")

    @JvmField
    public val isMouseTargetEnabledName: MethodStringName0<SubViewportContainer, Boolean> =
        MethodStringName0<SubViewportContainer, Boolean>("is_mouse_target_enabled")
  }

  public object MethodBindings {
    internal val setStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SubViewportContainer", "set_stretch", 2586408642)

    internal val isStretchEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SubViewportContainer", "is_stretch_enabled", 36873697)

    internal val setStretchShrinkPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SubViewportContainer", "set_stretch_shrink", 1286410249)

    internal val getStretchShrinkPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SubViewportContainer", "get_stretch_shrink", 3905245786)

    internal val setMouseTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SubViewportContainer", "set_mouse_target", 2586408642)

    internal val isMouseTargetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SubViewportContainer", "is_mouse_target_enabled", 2240911060)
  }
}
