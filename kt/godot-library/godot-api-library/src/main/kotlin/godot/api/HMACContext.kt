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
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedByteArray
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_BYTE_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_PACKED_BYTE_ARRAY
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * The HMACContext class is useful for advanced HMAC use cases, such as streaming the message as it
 * supports creating the message over time rather than providing it all at once.
 *
 * ```gdscript
 * //gdscript
 * extends Node
 * var ctx = HMACContext.new()
 *
 * func _ready():
 * 	var key = "supersecret".to_utf8_buffer()
 * 	var err = ctx.start(HashingContext.HASH_SHA256, key)
 * 	assert(err == OK)
 * 	var msg1 = "this is ".to_utf8_buffer()
 * 	var msg2 = "super duper secret".to_utf8_buffer()
 * 	err = ctx.update(msg1)
 * 	assert(err == OK)
 * 	err = ctx.update(msg2)
 * 	assert(err == OK)
 * 	var hmac = ctx.finish()
 * 	print(hmac.hex_encode())
 *
 * ```
 *
 * ```csharp
 * //csharp
 * using Godot;
 * using System.Diagnostics;
 *
 * public partial class MyNode : Node
 * {
 * 	private HmacContext _ctx = new HmacContext();
 *
 * 	public override void _Ready()
 * 	{
 * 		byte[] key = "supersecret".ToUtf8Buffer();
 * 		Error err = _ctx.Start(HashingContext.HashType.Sha256, key);
 * 		Debug.Assert(err == Error.Ok);
 * 		byte[] msg1 = "this is ".ToUtf8Buffer();
 * 		byte[] msg2 = "super duper secret".ToUtf8Buffer();
 * 		err = _ctx.Update(msg1);
 * 		Debug.Assert(err == Error.Ok);
 * 		err = _ctx.Update(msg2);
 * 		Debug.Assert(err == Error.Ok);
 * 		byte[] hmac = _ctx.Finish();
 * 		GD.Print(hmac.HexEncode());
 * 	}
 * }
 * ```
 */
@GodotBaseType
public open class HMACContext : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(286, scriptPtr)
  }

  /**
   * Initializes the HMACContext. This method cannot be called again on the same HMACContext until
   * [finish] has been called.
   */
  public final fun start(hashType: HashingContext.HashType, key: PackedByteArray): Error {
    TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY(ptr, objectID.id, hashType.value, key)
    TransferContext.callPtrMethod(MethodBindings.startPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Updates the message to be HMACed. This can be called multiple times before [finish] is called
   * to append [data] to the message, but cannot be called until [start] has been called.
   */
  public final fun update(`data`: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, data)
    TransferContext.callPtrMethod(MethodBindings.updatePtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the resulting HMAC. If the HMAC failed, an empty [PackedByteArray] is returned.
   */
  public final fun finish(): PackedByteArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.finishPtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  public companion object {
    @JvmField
    public val startName:
        MethodStringName2<HMACContext, Error, HashingContext.HashType, PackedByteArray> =
        MethodStringName2<HMACContext, Error, HashingContext.HashType, PackedByteArray>("start")

    @JvmField
    public val updateName: MethodStringName1<HMACContext, Error, PackedByteArray> =
        MethodStringName1<HMACContext, Error, PackedByteArray>("update")

    @JvmField
    public val finishName: MethodStringName0<HMACContext, PackedByteArray> =
        MethodStringName0<HMACContext, PackedByteArray>("finish")
  }

  public object MethodBindings {
    internal val startPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HMACContext", "start", 3537364598)

    internal val updatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("HMACContext", "update", 680677267)

    internal val finishPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HMACContext", "finish", 2115431945)
  }
}
