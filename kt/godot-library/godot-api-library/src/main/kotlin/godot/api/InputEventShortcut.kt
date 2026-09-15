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
import godot.core.VariantParser.OBJECT
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * InputEventShortcut is a special event that can be received in [Node.Input], [Node.ShortcutInput],
 * and [Node.UnhandledInput]. It is typically sent by the editor's Command Palette to trigger actions,
 * but can also be sent manually using [Viewport.pushInput].
 */
@GodotBaseType
public open class InputEventShortcut : InputEvent() {
  /**
   * The [Shortcut] represented by this event. Its [Shortcut.matchesEvent] method will always return
   * `true` for this event.
   */
  public final inline var shortcut: Shortcut?
    @JvmName("shortcutProperty")
    get() = getShortcut()
    @JvmName("shortcutProperty")
    set(`value`) {
      setShortcut(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(323, scriptPtr)
  }

  public final fun setShortcut(shortcut: Shortcut?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to shortcut)
    TransferContext.callMethod(MethodBindings.setShortcutPtr)
  }

  public final fun getShortcut(): Shortcut? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShortcutPtr)
    return (TransferContext.readReturnValue(OBJECT) as Shortcut?)
  }

  public companion object {
    @JvmField
    public val setShortcutName: MethodStringName1<InputEventShortcut, Unit, Shortcut?> =
        MethodStringName1<InputEventShortcut, Unit, Shortcut?>("set_shortcut")

    @JvmField
    public val getShortcutName: MethodStringName0<InputEventShortcut, Shortcut?> =
        MethodStringName0<InputEventShortcut, Shortcut?>("get_shortcut")
  }

  public object MethodBindings {
    internal val setShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventShortcut", "set_shortcut", 857163497)

    internal val getShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventShortcut", "get_shortcut", 3766804753)
  }
}
