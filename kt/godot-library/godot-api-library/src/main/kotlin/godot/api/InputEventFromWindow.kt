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
import godot.core.VariantParser.LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * InputEventFromWindow represents events specifically received by windows. This includes mouse
 * events, keyboard events in focused windows or touch screen actions.
 */
@GodotBaseType
public open class InputEventFromWindow internal constructor() : InputEvent() {
  /**
   * The ID of a [Window] that received this event.
   */
  public final inline var windowId: Long
    @JvmName("windowIdProperty")
    get() = getWindowId()
    @JvmName("windowIdProperty")
    set(`value`) {
      setWindowId(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(310, scriptPtr)
  }

  public final fun setWindowId(id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id)
    TransferContext.callMethod(MethodBindings.setWindowIdPtr)
  }

  public final fun getWindowId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWindowIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public companion object {
    @JvmField
    public val setWindowIdName: MethodStringName1<InputEventFromWindow, Unit, Long> =
        MethodStringName1<InputEventFromWindow, Unit, Long>("set_window_id")

    @JvmField
    public val getWindowIdName: MethodStringName0<InputEventFromWindow, Long> =
        MethodStringName0<InputEventFromWindow, Long>("get_window_id")
  }

  public object MethodBindings {
    internal val setWindowIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventFromWindow", "set_window_id", 1286410249)

    internal val getWindowIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventFromWindow", "get_window_id", 3905245786)
  }
}
