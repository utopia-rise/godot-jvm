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
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_STRING_BOOL
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
  public final fun save(path: String, publicOnly: Boolean = false): Error {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, path, publicOnly)
    TransferContext.callMethod(MethodBindings.savePtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads a key from [path]. If [publicOnly] is `true`, only the public key will be loaded.
   *
   * **Note:** [path] should be a "*.pub" file if [publicOnly] is `true`, a "*.key" file otherwise.
   */
  @JvmOverloads
  public final fun load(path: String, publicOnly: Boolean = false): Error {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, path, publicOnly)
    TransferContext.callMethod(MethodBindings.loadPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns `true` if this CryptoKey only has the public part, and not the private one.
   */
  public final fun isPublicOnly(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPublicOnlyPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a string containing the key in PEM format. If [publicOnly] is `true`, only the public
   * key will be included.
   */
  @JvmOverloads
  public final fun saveToString(publicOnly: Boolean = false): String {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, publicOnly)
    TransferContext.callMethod(MethodBindings.saveToStringPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Loads a key from the given [stringKey]. If [publicOnly] is `true`, only the public key will be
   * loaded.
   */
  @JvmOverloads
  public final fun loadFromString(stringKey: String, publicOnly: Boolean = false): Error {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, stringKey, publicOnly)
    TransferContext.callMethod(MethodBindings.loadFromStringPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

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
