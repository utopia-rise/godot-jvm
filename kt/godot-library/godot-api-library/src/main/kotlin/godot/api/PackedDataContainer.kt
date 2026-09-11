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
import godot.core.Dictionary
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.LONG
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [PackedDataContainer] can be used to efficiently store data from untyped containers. The data is
 * packed into raw bytes and can be saved to file. Only [VariantArray] and [Dictionary] can be stored
 * this way.
 *
 * You can retrieve the data by iterating on the container, which will work as if iterating on the
 * packed data itself. If the packed container is a [Dictionary], the data can be retrieved by key
 * names ([String]/[StringName] only).
 *
 * ```
 * var data = { "key": "value", "another_key": 123, "lock": Vector2() }
 * var packed = PackedDataContainer.new()
 * packed.pack(data)
 * ResourceSaver.save(packed, "packed_data.res")
 * ```
 *
 * ```
 * var container = load("packed_data.res")
 * for key in container:
 * 	prints(key, container[key])
 * ```
 *
 * Prints:
 *
 * [codeblock lang=text]
 *
 * key value
 *
 * lock (0, 0)
 *
 * another_key 123
 *
 * ```
 *
 * Nested containers will be packed recursively. While iterating, they will be returned as
 * [PackedDataContainerRef].
 */
@GodotBaseType
public open class PackedDataContainer : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(500, scriptPtr)
  }

  /**
   * Packs the given container into a binary representation. The [value] must be either
   * [VariantArray] or [Dictionary], any other type will result in invalid data error.
   *
   * **Note:** Subsequent calls to this method will overwrite the existing data.
   */
  public final fun pack(`value`: Any?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to value)
    TransferContext.callMethod(MethodBindings.packPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the size of the packed container (see [Array.size] and [Dictionary.size]).
   */
  public final fun size(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.sizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public companion object {
    @JvmField
    public val packName: MethodStringName1<PackedDataContainer, Error, Any?> =
        MethodStringName1<PackedDataContainer, Error, Any?>("pack")

    @JvmField
    public val sizeName: MethodStringName0<PackedDataContainer, Int> =
        MethodStringName0<PackedDataContainer, Int>("size")
  }

  public object MethodBindings {
    internal val packPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PackedDataContainer", "pack", 966674026)

    internal val sizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PackedDataContainer", "size", 3905245786)
  }
}
