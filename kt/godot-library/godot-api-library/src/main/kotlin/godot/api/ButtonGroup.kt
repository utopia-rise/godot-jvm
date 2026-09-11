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
import godot.core.Signal1
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A group of [BaseButton]-derived buttons. The buttons in a [ButtonGroup] are treated like radio
 * buttons: No more than one button can be pressed at a time. Some types of buttons (such as
 * [CheckBox]) may have a special appearance in this state.
 *
 * Every member of a [ButtonGroup] should have [BaseButton.toggleMode] set to `true`.
 */
@GodotBaseType
public open class ButtonGroup : Resource() {
  /**
   * Emitted when one of the buttons of the group is pressed.
   */
  public val pressed: Signal1<BaseButton> by Signal1

  /**
   * If `true`, it is possible to unpress all buttons in this [ButtonGroup].
   */
  public final inline var allowUnpress: Boolean
    @JvmName("allowUnpressProperty")
    get() = isAllowUnpress()
    @JvmName("allowUnpressProperty")
    set(`value`) {
      setAllowUnpress(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(121, scriptPtr)
  }

  /**
   * Returns the current pressed button.
   */
  public final fun getPressedButton(): BaseButton? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPressedButtonPtr)
    return (TransferContext.readReturnValue(OBJECT) as BaseButton?)
  }

  /**
   * Returns an [VariantArray] of [Button]s who have this as their [ButtonGroup] (see
   * [BaseButton.buttonGroup]).
   */
  public final fun getButtons(): VariantArray<BaseButton> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getButtonsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<BaseButton>)
  }

  public final fun setAllowUnpress(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAllowUnpressPtr)
  }

  public final fun isAllowUnpress(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAllowUnpressPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val getPressedButtonName: MethodStringName0<ButtonGroup, BaseButton?> =
        MethodStringName0<ButtonGroup, BaseButton?>("get_pressed_button")

    @JvmField
    public val getButtonsName: MethodStringName0<ButtonGroup, VariantArray<BaseButton>> =
        MethodStringName0<ButtonGroup, VariantArray<BaseButton>>("get_buttons")

    @JvmField
    public val setAllowUnpressName: MethodStringName1<ButtonGroup, Unit, Boolean> =
        MethodStringName1<ButtonGroup, Unit, Boolean>("set_allow_unpress")

    @JvmField
    public val isAllowUnpressName: MethodStringName0<ButtonGroup, Boolean> =
        MethodStringName0<ButtonGroup, Boolean>("is_allow_unpress")
  }

  public object MethodBindings {
    internal val getPressedButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ButtonGroup", "get_pressed_button", 3886434893)

    internal val getButtonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ButtonGroup", "get_buttons", 2915620761)

    internal val setAllowUnpressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ButtonGroup", "set_allow_unpress", 2586408642)

    internal val isAllowUnpressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ButtonGroup", "is_allow_unpress", 2240911060)
  }
}
