// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.GodotError
import godot.core.PoolByteArray
import godot.core.TransferContext
import godot.core.VariantArray
import godot.core.VariantType.ANY
import godot.core.VariantType.JVM_INT
import godot.core.VariantType.LONG
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

/**
 *
 */
@GodotBaseType
public open class PackedDataContainer : Resource() {
  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_PACKEDDATACONTAINER)
  }

  public open fun _getData(): PoolByteArray {
    throw NotImplementedError("_get_data is not implemented for PackedDataContainer")
  }

  public open fun _iterGet(arg0: Any?): Any? {
    throw NotImplementedError("_iter_get is not implemented for PackedDataContainer")
  }

  public open fun _iterInit(arg0: VariantArray<Any?>): Any? {
    throw NotImplementedError("_iter_init is not implemented for PackedDataContainer")
  }

  public open fun _iterNext(arg0: VariantArray<Any?>): Any? {
    throw NotImplementedError("_iter_next is not implemented for PackedDataContainer")
  }

  public open fun _setData(arg0: PoolByteArray): Unit {
  }

  /**
   *
   */
  public open fun pack(`value`: Any?): GodotError {
    TransferContext.writeArguments(ANY to value)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_PACKEDDATACONTAINER_PACK, LONG)
    return GodotError.values()[TransferContext.readReturnValue(JVM_INT) as Int]
  }

  /**
   *
   */
  public open fun size(): Long {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_PACKEDDATACONTAINER_SIZE, LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }
}
