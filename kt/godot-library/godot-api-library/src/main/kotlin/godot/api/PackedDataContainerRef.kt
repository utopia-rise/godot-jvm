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
import godot.core.MethodStringName0
import godot.core.VariantArray
import godot.core.VariantParser.LONG
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * When packing nested containers using [PackedDataContainer], they are recursively packed into
 * [PackedDataContainerRef] (only applies to [VariantArray] and [Dictionary]). Their data can be
 * retrieved the same way as from [PackedDataContainer].
 *
 * ```
 * var packed = PackedDataContainer.new()
 * packed.pack([1, 2, 3, ["nested1", "nested2"], 4, 5, 6])
 *
 * for element in packed:
 * 	if element is PackedDataContainerRef:
 * 		for subelement in element:
 * 			print("::", subelement)
 * 	else:
 * 		print(element)
 * ```
 *
 * Prints:
 *
 * [codeblock lang=text]
 *
 * 1
 *
 * 2
 *
 * 3
 *
 * ::nested1
 *
 * ::nested2
 *
 * 4
 *
 * 5
 *
 * 6
 *
 * ```
 */
@GodotBaseType
public open class PackedDataContainerRef internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(501, scriptPtr)
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
    public val sizeName: MethodStringName0<PackedDataContainerRef, Int> =
        MethodStringName0<PackedDataContainerRef, Int>("size")
  }

  public object MethodBindings {
    internal val sizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PackedDataContainerRef", "size", 3905245786)
  }
}
