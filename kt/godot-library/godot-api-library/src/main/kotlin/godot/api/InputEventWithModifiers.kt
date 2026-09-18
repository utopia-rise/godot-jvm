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
import godot.core.KeyModifierMask
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Stores information about mouse, keyboard, and touch gesture input events. This includes
 * information about which modifier keys are pressed, such as [kbd]Shift[/kbd] or [kbd]Alt[/kbd]. See
 * [Node.Input].
 *
 * **Note:** Modifier keys are considered modifiers only when used in combination with another key.
 * As a result, their corresponding member variables, such as [ctrlPressed], will return `false` if the
 * key is pressed on its own.
 */
@GodotBaseType
public open class InputEventWithModifiers internal constructor() : InputEventFromWindow() {
  /**
   * Automatically use [kbd]Meta[/kbd] ([kbd]Cmd[/kbd]) on macOS and [kbd]Ctrl[/kbd] on other
   * platforms. If `true`, [ctrlPressed] and [metaPressed] cannot be set.
   */
  public final inline var commandOrControlAutoremap: Boolean
    @JvmName("commandOrControlAutoremapProperty")
    get() = isCommandOrControlAutoremap()
    @JvmName("commandOrControlAutoremapProperty")
    set(`value`) {
      setCommandOrControlAutoremap(value)
    }

  /**
   * State of the [kbd]Alt[/kbd] modifier.
   */
  public final inline var altPressed: Boolean
    @JvmName("altPressedProperty")
    get() = isAltPressed()
    @JvmName("altPressedProperty")
    set(`value`) {
      setAltPressed(value)
    }

  /**
   * State of the [kbd]Shift[/kbd] modifier.
   */
  public final inline var shiftPressed: Boolean
    @JvmName("shiftPressedProperty")
    get() = isShiftPressed()
    @JvmName("shiftPressedProperty")
    set(`value`) {
      setShiftPressed(value)
    }

  /**
   * State of the [kbd]Ctrl[/kbd] modifier.
   */
  public final inline var ctrlPressed: Boolean
    @JvmName("ctrlPressedProperty")
    get() = isCtrlPressed()
    @JvmName("ctrlPressedProperty")
    set(`value`) {
      setCtrlPressed(value)
    }

  /**
   * State of the [kbd]Meta[/kbd] modifier. On Windows and Linux, this represents the Windows key
   * (sometimes called "meta" or "super" on Linux). On macOS, this represents the Command key.
   */
  public final inline var metaPressed: Boolean
    @JvmName("metaPressedProperty")
    get() = isMetaPressed()
    @JvmName("metaPressedProperty")
    set(`value`) {
      setMetaPressed(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(324, scriptPtr)
  }

  public final fun setCommandOrControlAutoremap(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setCommandOrControlAutoremapPtr, 0)
  }

  public final fun isCommandOrControlAutoremap(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCommandOrControlAutoremapPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * On macOS, returns `true` if [kbd]Meta[/kbd] ([kbd]Cmd[/kbd]) is pressed.
   *
   * On other platforms, returns `true` if [kbd]Ctrl[/kbd] is pressed.
   */
  public final fun isCommandOrControlPressed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCommandOrControlPressedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAltPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pressed)
    TransferContext.callPtrMethod(MethodBindings.setAltPressedPtr, 0)
  }

  public final fun isAltPressed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAltPressedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setShiftPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pressed)
    TransferContext.callPtrMethod(MethodBindings.setShiftPressedPtr, 0)
  }

  public final fun isShiftPressed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isShiftPressedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCtrlPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pressed)
    TransferContext.callPtrMethod(MethodBindings.setCtrlPressedPtr, 0)
  }

  public final fun isCtrlPressed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCtrlPressedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setMetaPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pressed)
    TransferContext.callPtrMethod(MethodBindings.setMetaPressedPtr, 0)
  }

  public final fun isMetaPressed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isMetaPressedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the keycode combination of modifier keys.
   */
  public final fun getModifiersMask(): KeyModifierMask {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getModifiersMaskPtr, 2)
    return KeyModifierMask(TransferContext.readReturnValue_LONG())
  }

  public companion object {
    @JvmField
    public val setCommandOrControlAutoremapName:
        MethodStringName1<InputEventWithModifiers, Unit, Boolean> =
        MethodStringName1<InputEventWithModifiers, Unit, Boolean>("set_command_or_control_autoremap")

    @JvmField
    public val isCommandOrControlAutoremapName: MethodStringName0<InputEventWithModifiers, Boolean>
        = MethodStringName0<InputEventWithModifiers, Boolean>("is_command_or_control_autoremap")

    @JvmField
    public val isCommandOrControlPressedName: MethodStringName0<InputEventWithModifiers, Boolean> =
        MethodStringName0<InputEventWithModifiers, Boolean>("is_command_or_control_pressed")

    @JvmField
    public val setAltPressedName: MethodStringName1<InputEventWithModifiers, Unit, Boolean> =
        MethodStringName1<InputEventWithModifiers, Unit, Boolean>("set_alt_pressed")

    @JvmField
    public val isAltPressedName: MethodStringName0<InputEventWithModifiers, Boolean> =
        MethodStringName0<InputEventWithModifiers, Boolean>("is_alt_pressed")

    @JvmField
    public val setShiftPressedName: MethodStringName1<InputEventWithModifiers, Unit, Boolean> =
        MethodStringName1<InputEventWithModifiers, Unit, Boolean>("set_shift_pressed")

    @JvmField
    public val isShiftPressedName: MethodStringName0<InputEventWithModifiers, Boolean> =
        MethodStringName0<InputEventWithModifiers, Boolean>("is_shift_pressed")

    @JvmField
    public val setCtrlPressedName: MethodStringName1<InputEventWithModifiers, Unit, Boolean> =
        MethodStringName1<InputEventWithModifiers, Unit, Boolean>("set_ctrl_pressed")

    @JvmField
    public val isCtrlPressedName: MethodStringName0<InputEventWithModifiers, Boolean> =
        MethodStringName0<InputEventWithModifiers, Boolean>("is_ctrl_pressed")

    @JvmField
    public val setMetaPressedName: MethodStringName1<InputEventWithModifiers, Unit, Boolean> =
        MethodStringName1<InputEventWithModifiers, Unit, Boolean>("set_meta_pressed")

    @JvmField
    public val isMetaPressedName: MethodStringName0<InputEventWithModifiers, Boolean> =
        MethodStringName0<InputEventWithModifiers, Boolean>("is_meta_pressed")

    @JvmField
    public val getModifiersMaskName: MethodStringName0<InputEventWithModifiers, KeyModifierMask> =
        MethodStringName0<InputEventWithModifiers, KeyModifierMask>("get_modifiers_mask")
  }

  public object MethodBindings {
    internal val setCommandOrControlAutoremapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "set_command_or_control_autoremap", 2586408642)

    internal val isCommandOrControlAutoremapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "is_command_or_control_autoremap", 36873697)

    internal val isCommandOrControlPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "is_command_or_control_pressed", 36873697)

    internal val setAltPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "set_alt_pressed", 2586408642)

    internal val isAltPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "is_alt_pressed", 36873697)

    internal val setShiftPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "set_shift_pressed", 2586408642)

    internal val isShiftPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "is_shift_pressed", 36873697)

    internal val setCtrlPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "set_ctrl_pressed", 2586408642)

    internal val isCtrlPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "is_ctrl_pressed", 36873697)

    internal val setMetaPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "set_meta_pressed", 2586408642)

    internal val isMetaPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "is_meta_pressed", 36873697)

    internal val getModifiersMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventWithModifiers", "get_modifiers_mask", 1258259499)
  }
}
