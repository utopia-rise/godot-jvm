// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantArray
import godot.core.VariantType.ANY
import godot.core.VariantType.ARRAY
import godot.core.VariantType.BOOL
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import godot.core.VariantType.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public open class GDNative : Reference() {
  public open var library: GDNativeLibrary?
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_GDNATIVE_GET_LIBRARY, OBJECT)
      return TransferContext.readReturnValue(OBJECT, true) as GDNativeLibrary?
    }
    set(`value`) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_GDNATIVE_SET_LIBRARY, NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_GDNATIVE)
  }

  public open fun callNative(
    callingType: String,
    procedureName: String,
    arguments: VariantArray<Any?>
  ): Any? {
    TransferContext.writeArguments(STRING to callingType, STRING to procedureName, ARRAY to
        arguments)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_GDNATIVE_CALL_NATIVE, ANY)
    return TransferContext.readReturnValue(ANY, true) as Any?
  }

  public open fun initialize(): Boolean {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_GDNATIVE_INITIALIZE, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  public open fun terminate(): Boolean {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_GDNATIVE_TERMINATE, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }
}
