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
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A dialog used for confirmation of actions. This window is similar to [AcceptDialog], but pressing
 * its Cancel button can have a different outcome from pressing the OK button. The order of the two
 * buttons varies depending on the host OS.
 *
 * To get cancel action, you can use:
 *
 * ```gdscript
 * //gdscript
 * get_cancel_button().pressed.connect(_on_canceled)
 * ```
 *
 * ```csharp
 * //csharp
 * GetCancelButton().Pressed += OnCanceled;
 * ```
 *
 * **Note:** [AcceptDialog] is invisible by default. To make it visible, call one of the `popup_*`
 * methods from [Window] on the node, such as [Window.popupCenteredClamped].
 */
@GodotBaseType
public open class ConfirmationDialog : AcceptDialog() {
  /**
   * The text displayed by the cancel button (see [getCancelButton]).
   */
  public final inline var cancelButtonText: String
    @JvmName("cancelButtonTextProperty")
    get() = getCancelButtonText()
    @JvmName("cancelButtonTextProperty")
    set(`value`) {
      setCancelButtonText(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(183, scriptPtr)
  }

  /**
   * Returns the cancel button.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getCancelButton(): Button? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCancelButtonPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as Button?)
  }

  public final fun setCancelButtonText(text: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, text)
    TransferContext.callMethod(MethodBindings.setCancelButtonTextPtr)
  }

  public final fun getCancelButtonText(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCancelButtonTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val getCancelButtonName: MethodStringName0<ConfirmationDialog, Button?> =
        MethodStringName0<ConfirmationDialog, Button?>("get_cancel_button")

    @JvmField
    public val setCancelButtonTextName: MethodStringName1<ConfirmationDialog, Unit, String> =
        MethodStringName1<ConfirmationDialog, Unit, String>("set_cancel_button_text")

    @JvmField
    public val getCancelButtonTextName: MethodStringName0<ConfirmationDialog, String> =
        MethodStringName0<ConfirmationDialog, String>("get_cancel_button_text")
  }

  public object MethodBindings {
    internal val getCancelButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfirmationDialog", "get_cancel_button", 1856205918)

    internal val setCancelButtonTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfirmationDialog", "set_cancel_button_text", 83702148)

    internal val getCancelButtonTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfirmationDialog", "get_cancel_button_text", 201670096)
  }
}
