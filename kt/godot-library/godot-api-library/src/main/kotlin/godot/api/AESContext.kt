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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName3
import godot.core.PackedByteArray
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_BYTE_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_PACKED_BYTE_ARRAY
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This class holds the context information required for encryption and decryption operations with
 * AES (Advanced Encryption Standard). Both AES-ECB and AES-CBC modes are supported.
 *
 * ```gdscript
 * //gdscript
 * extends Node
 *
 * var aes = AESContext.new()
 *
 * func _ready():
 * 	var key = "My secret key!!!" # Key must be either 16 or 32 bytes.
 * 	var data = "My secret text!!" # Data size must be multiple of 16 bytes, apply padding if needed.
 * 	# Encrypt ECB
 * 	aes.start(AESContext.MODE_ECB_ENCRYPT, key.to_utf8_buffer())
 * 	var encrypted = aes.update(data.to_utf8_buffer())
 * 	aes.finish()
 * 	# Decrypt ECB
 * 	aes.start(AESContext.MODE_ECB_DECRYPT, key.to_utf8_buffer())
 * 	var decrypted = aes.update(encrypted)
 * 	aes.finish()
 * 	# Check ECB
 * 	assert(decrypted == data.to_utf8_buffer())
 *
 * 	var iv = "My secret iv!!!!" # IV must be of exactly 16 bytes.
 * 	# Encrypt CBC
 * 	aes.start(AESContext.MODE_CBC_ENCRYPT, key.to_utf8_buffer(), iv.to_utf8_buffer())
 * 	encrypted = aes.update(data.to_utf8_buffer())
 * 	aes.finish()
 * 	# Decrypt CBC
 * 	aes.start(AESContext.MODE_CBC_DECRYPT, key.to_utf8_buffer(), iv.to_utf8_buffer())
 * 	decrypted = aes.update(encrypted)
 * 	aes.finish()
 * 	# Check CBC
 * 	assert(decrypted == data.to_utf8_buffer())
 * ```
 *
 * ```csharp
 * //csharp
 * using Godot;
 * using System.Diagnostics;
 *
 * public partial class MyNode : Node
 * {
 * 	private AesContext _aes = new AesContext();
 *
 * 	public override void _Ready()
 * 	{
 * 		string key = "My secret key!!!"; // Key must be either 16 or 32 bytes.
 * 		string data = "My secret text!!"; // Data size must be multiple of 16 bytes, apply padding if
 * needed.
 * 		// Encrypt ECB
 * 		_aes.Start(AesContext.Mode.EcbEncrypt, key.ToUtf8Buffer());
 * 		byte[] encrypted = _aes.Update(data.ToUtf8Buffer());
 * 		_aes.Finish();
 * 		// Decrypt ECB
 * 		_aes.Start(AesContext.Mode.EcbDecrypt, key.ToUtf8Buffer());
 * 		byte[] decrypted = _aes.Update(encrypted);
 * 		_aes.Finish();
 * 		// Check ECB
 * 		Debug.Assert(decrypted == data.ToUtf8Buffer());
 *
 * 		string iv = "My secret iv!!!!"; // IV must be of exactly 16 bytes.
 * 		// Encrypt CBC
 * 		_aes.Start(AesContext.Mode.EcbEncrypt, key.ToUtf8Buffer(), iv.ToUtf8Buffer());
 * 		encrypted = _aes.Update(data.ToUtf8Buffer());
 * 		_aes.Finish();
 * 		// Decrypt CBC
 * 		_aes.Start(AesContext.Mode.EcbDecrypt, key.ToUtf8Buffer(), iv.ToUtf8Buffer());
 * 		decrypted = _aes.Update(encrypted);
 * 		_aes.Finish();
 * 		// Check CBC
 * 		Debug.Assert(decrypted == data.ToUtf8Buffer());
 * 	}
 * }
 * ```
 */
@GodotBaseType
public open class AESContext : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(0, scriptPtr)
  }

  /**
   * Start the AES context in the given [mode]. A [key] of either 16 or 32 bytes must always be
   * provided, while an [iv] (initialization vector) of exactly 16 bytes, is only needed when [mode] is
   * either [MODE_CBC_ENCRYPT] or [MODE_CBC_DECRYPT].
   */
  @JvmOverloads
  public final fun start(
    mode: Mode,
    key: PackedByteArray,
    iv: PackedByteArray = PackedByteArray(),
  ): Error {
    TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY(ptr, objectID.id, mode.value, key, iv)
    TransferContext.callPtrMethod(MethodBindings.startPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Run the desired operation for this AES context. Will return a [PackedByteArray] containing the
   * result of encrypting (or decrypting) the given [src]. See [start] for mode of operation.
   *
   * **Note:** The size of [src] must be a multiple of 16. Apply some padding if needed.
   */
  public final fun update(src: PackedByteArray): PackedByteArray {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, src)
    TransferContext.callMethod(MethodBindings.updatePtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Get the current IV state for this context (IV gets updated when calling [update]). You normally
   * don't need this function.
   *
   * **Note:** This function only makes sense when the context is started with [MODE_CBC_ENCRYPT] or
   * [MODE_CBC_DECRYPT].
   */
  public final fun getIvState(): PackedByteArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIvStatePtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Close this AES context so it can be started again. See [start].
   */
  public final fun finish(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.finishPtr, 0)
  }

  public enum class Mode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * AES electronic codebook encryption mode.
     */
    ECB_ENCRYPT(0),
    /**
     * AES electronic codebook decryption mode.
     */
    ECB_DECRYPT(1),
    /**
     * AES cipher block chaining encryption mode.
     */
    CBC_ENCRYPT(2),
    /**
     * AES cipher block chaining decryption mode.
     */
    CBC_DECRYPT(3),
    /**
     * Maximum value for the mode enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): Mode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val startName:
        MethodStringName3<AESContext, Error, Mode, PackedByteArray, PackedByteArray> =
        MethodStringName3<AESContext, Error, Mode, PackedByteArray, PackedByteArray>("start")

    @JvmField
    public val updateName: MethodStringName1<AESContext, PackedByteArray, PackedByteArray> =
        MethodStringName1<AESContext, PackedByteArray, PackedByteArray>("update")

    @JvmField
    public val getIvStateName: MethodStringName0<AESContext, PackedByteArray> =
        MethodStringName0<AESContext, PackedByteArray>("get_iv_state")

    @JvmField
    public val finishName: MethodStringName0<AESContext, Unit> =
        MethodStringName0<AESContext, Unit>("finish")
  }

  public object MethodBindings {
    internal val startPtr: VoidPtr = TypeManager.getMethodBindPtr("AESContext", "start", 3122411423)

    internal val updatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AESContext", "update", 527836100)

    internal val getIvStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AESContext", "get_iv_state", 2115431945)

    internal val finishPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AESContext", "finish", 3218959716)
  }
}
