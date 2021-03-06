// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import godot.core.VariantType.STRING
import godot.signals.Signal0
import godot.signals.signal
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public object VisualScriptEditor : Object() {
  public val customNodesUpdated: Signal0 by signal()

  public override fun __new(): Unit {
    rawPtr = TransferContext.getSingleton(ENGINESINGLETON_VISUALSCRIPTEDITOR)
  }

  public override fun ____DO_NOT_TOUCH_THIS_isSingleton____() = true

  public fun addCustomNode(
    name: String,
    category: String,
    script: Script
  ): Unit {
    TransferContext.writeArguments(STRING to name, STRING to category, OBJECT to script)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS__VISUALSCRIPTEDITOR_ADD_CUSTOM_NODE,
        NIL)
  }

  public fun removeCustomNode(name: String, category: String): Unit {
    TransferContext.writeArguments(STRING to name, STRING to category)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS__VISUALSCRIPTEDITOR_REMOVE_CUSTOM_NODE, NIL)
  }
}
