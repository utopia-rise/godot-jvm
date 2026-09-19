// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_BOOL_ret_STRING
import godot.callMethod_STRING_BOOL_ret_LONG
import godot.callPtrMethod0_ret_BOOL
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * The CryptoKey class represents a cryptographic key. Keys can be loaded and saved like any other
 * [Resource].
 *
 * They can be used to generate a self-signed [X509Certificate] via
 * [Crypto.generateSelfSignedCertificate] and as private key in [StreamPeerTLS.acceptStream] along with
 * the appropriate certificate.
 */
@GodotBaseType
public open class CryptoKey : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(191, scriptPtr)
  }

  /**
   * Saves a key to the given [path]. If [publicOnly] is `true`, only the public key will be saved.
   *
   * **Note:** [path] should be a "*.pub" file if [publicOnly] is `true`, a "*.key" file otherwise.
   */
  @JvmOverloads
  public final fun save(path: String, publicOnly: Boolean = false): Error =
      Error.from(TransferContext.callMethod_STRING_BOOL_ret_LONG(ptr, objectID.id, MethodBindings.savePtr, path, publicOnly))

  /**
   * Loads a key from [path]. If [publicOnly] is `true`, only the public key will be loaded.
   *
   * **Note:** [path] should be a "*.pub" file if [publicOnly] is `true`, a "*.key" file otherwise.
   */
  @JvmOverloads
  public final fun load(path: String, publicOnly: Boolean = false): Error =
      Error.from(TransferContext.callMethod_STRING_BOOL_ret_LONG(ptr, objectID.id, MethodBindings.loadPtr, path, publicOnly))

  /**
   * Returns `true` if this CryptoKey only has the public part, and not the private one.
   */
  public final fun isPublicOnly(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isPublicOnlyPtr)

  /**
   * Returns a string containing the key in PEM format. If [publicOnly] is `true`, only the public
   * key will be included.
   */
  @JvmOverloads
  public final fun saveToString(publicOnly: Boolean = false): String =
      TransferContext.callMethod_BOOL_ret_STRING(ptr, objectID.id, MethodBindings.saveToStringPtr, publicOnly)

  /**
   * Loads a key from the given [stringKey]. If [publicOnly] is `true`, only the public key will be
   * loaded.
   */
  @JvmOverloads
  public final fun loadFromString(stringKey: String, publicOnly: Boolean = false): Error =
      Error.from(TransferContext.callMethod_STRING_BOOL_ret_LONG(ptr, objectID.id, MethodBindings.loadFromStringPtr, stringKey, publicOnly))

  public companion object {
    @JvmField
    public val saveName: MethodStringName2<CryptoKey, Error, String, Boolean> =
        MethodStringName2<CryptoKey, Error, String, Boolean>("save")

    @JvmField
    public val loadName: MethodStringName2<CryptoKey, Error, String, Boolean> =
        MethodStringName2<CryptoKey, Error, String, Boolean>("load")

    @JvmField
    public val isPublicOnlyName: MethodStringName0<CryptoKey, Boolean> =
        MethodStringName0<CryptoKey, Boolean>("is_public_only")

    @JvmField
    public val saveToStringName: MethodStringName1<CryptoKey, String, Boolean> =
        MethodStringName1<CryptoKey, String, Boolean>("save_to_string")

    @JvmField
    public val loadFromStringName: MethodStringName2<CryptoKey, Error, String, Boolean> =
        MethodStringName2<CryptoKey, Error, String, Boolean>("load_from_string")
  }

  public object MethodBindings {
    internal val savePtr: VoidPtr = TypeManager.getMethodBindPtr("CryptoKey", "save", 885841341)

    internal val loadPtr: VoidPtr = TypeManager.getMethodBindPtr("CryptoKey", "load", 885841341)

    internal val isPublicOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CryptoKey", "is_public_only", 36873697)

    internal val saveToStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CryptoKey", "save_to_string", 32795936)

    internal val loadFromStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CryptoKey", "load_from_string", 885841341)
  }
}
