// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit

/**
 * Holds a reference to an [godot.Object]'s instance ID.
 *
 * Utility class which holds a reference to the internal identifier of an [godot.Object] instance, as given by [godot.Object.getInstanceId]. This ID can then be used to retrieve the object instance with [@GDScript.instanceFromId].
 *
 * This class is used internally by the editor inspector and script debugger, but can also be used in plugins to pass and display objects as their IDs.
 */
@GodotBaseType
public open class EncodedObjectAsID : Reference() {
  /**
   * The [godot.Object] identifier stored in this [godot.EncodedObjectAsID] instance. The object instance can be retrieved with [@GDScript.instanceFromId].
   */
  public open var objectId: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ENCODEDOBJECTASID_GET_OBJECT_ID,
          LONG)
      return TransferContext.readReturnValue(LONG, false) as Long
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_ENCODEDOBJECTASID_SET_OBJECT_ID,
          NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_ENCODEDOBJECTASID)
  }
}
