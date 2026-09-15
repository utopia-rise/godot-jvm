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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedByteArray
import godot.readReturnValue_BOOL
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_OBJECT
import godot.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_OBJECT
import godot.writeMethodArguments_OBJECT_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_OBJECT_STRING_STRING_STRING
import godot.writeMethodArguments_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * The Crypto class provides access to advanced cryptographic functionalities.
 *
 * Currently, this includes asymmetric key encryption/decryption, signing/verification, and
 * generating cryptographically secure random bytes, RSA keys, HMAC digests, and self-signed
 * [X509Certificate]s.
 *
 * ```gdscript
 * //gdscript
 * var crypto = Crypto.new()
 *
 * # Generate new RSA key.
 * var key = crypto.generate_rsa(4096)
 *
 * # Generate new self-signed certificate with the given key.
 * var cert = crypto.generate_self_signed_certificate(key, "CN=mydomain.com,O=My Game Company,C=IT")
 *
 * # Save key and certificate in the user folder.
 * key.save("user://generated.key")
 * cert.save("user://generated.crt")
 *
 * # Encryption
 * var data = "Some data"
 * var encrypted = crypto.encrypt(key, data.to_utf8_buffer())
 *
 * # Decryption
 * var decrypted = crypto.decrypt(key, encrypted)
 *
 * # Signing
 * var signature = crypto.sign(HashingContext.HASH_SHA256, data.sha256_buffer(), key)
 *
 * # Verifying
 * var verified = crypto.verify(HashingContext.HASH_SHA256, data.sha256_buffer(), signature, key)
 *
 * # Checks
 * assert(verified)
 * assert(data.to_utf8_buffer() == decrypted)
 * ```
 *
 * ```csharp
 * //csharp
 * using Godot;
 * using System.Diagnostics;
 *
 * Crypto crypto = new Crypto();
 *
 * // Generate new RSA key.
 * CryptoKey key = crypto.GenerateRsa(4096);
 *
 * // Generate new self-signed certificate with the given key.
 * X509Certificate cert = crypto.GenerateSelfSignedCertificate(key, "CN=mydomain.com,O=My Game
 * Company,C=IT");
 *
 * // Save key and certificate in the user folder.
 * key.Save("user://generated.key");
 * cert.Save("user://generated.crt");
 *
 * // Encryption
 * string data = "Some data";
 * byte[] encrypted = crypto.Encrypt(key, data.ToUtf8Buffer());
 *
 * // Decryption
 * byte[] decrypted = crypto.Decrypt(key, encrypted);
 *
 * // Signing
 * byte[] signature = crypto.Sign(HashingContext.HashType.Sha256, Data.Sha256Buffer(), key);
 *
 * // Verifying
 * bool verified = crypto.Verify(HashingContext.HashType.Sha256, Data.Sha256Buffer(), signature,
 * key);
 *
 * // Checks
 * Debug.Assert(verified);
 * Debug.Assert(data.ToUtf8Buffer() == decrypted);
 * ```
 */
@GodotBaseType
public open class Crypto : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(190, scriptPtr)
  }

  /**
   * Generates a [PackedByteArray] of cryptographically secure random bytes with given [size].
   */
  public final fun generateRandomBytes(size: Int): PackedByteArray {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, size.toLong())
    TransferContext.callMethod(MethodBindings.generateRandomBytesPtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Generates an RSA [CryptoKey] that can be used for creating self-signed certificates and passed
   * to [StreamPeerTLS.acceptStream].
   */
  public final fun generateRsa(size: Int): CryptoKey? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, size.toLong())
    TransferContext.callMethod(MethodBindings.generateRsaPtr)
    return (TransferContext.readReturnValue_OBJECT() as CryptoKey?)
  }

  /**
   * Generates a self-signed [X509Certificate] from the given [CryptoKey] and [issuerName]. The
   * certificate validity will be defined by [notBefore] and [notAfter] (first valid date and last
   * valid date). The [issuerName] must contain at least "CN=" (common name, i.e. the domain name),
   * "O=" (organization, i.e. your company name), "C=" (country, i.e. 2 lettered ISO-3166 code of the
   * country the organization is based in).
   *
   * A small example to generate an RSA key and an X509 self-signed certificate.
   *
   * ```gdscript
   * //gdscript
   * var crypto = Crypto.new()
   * # Generate 4096 bits RSA key.
   * var key = crypto.generate_rsa(4096)
   * # Generate self-signed certificate using the given key.
   * var cert = crypto.generate_self_signed_certificate(key, "CN=example.com,O=A Game Company,C=IT")
   * ```
   *
   * ```csharp
   * //csharp
   * var crypto = new Crypto();
   * // Generate 4096 bits RSA key.
   * CryptoKey key = crypto.GenerateRsa(4096);
   * // Generate self-signed certificate using the given key.
   * X509Certificate cert = crypto.GenerateSelfSignedCertificate(key, "CN=mydomain.com,O=My Game
   * Company,C=IT");
   * ```
   */
  @JvmOverloads
  public final fun generateSelfSignedCertificate(
    key: CryptoKey?,
    issuerName: String = "CN=myserver,O=myorganisation,C=IT",
    notBefore: String = "20140101000000",
    notAfter: String = "20340101000000",
  ): X509Certificate? {
    TransferContext.writeMethodArguments_OBJECT_STRING_STRING_STRING(ptr, objectID.id, key, issuerName, notBefore, notAfter)
    TransferContext.callMethod(MethodBindings.generateSelfSignedCertificatePtr)
    return (TransferContext.readReturnValue_OBJECT() as X509Certificate?)
  }

  /**
   * Sign a given [hash] of type [hashType] with the provided private [key].
   */
  public final fun sign(
    hashType: HashingContext.HashType,
    hash: PackedByteArray,
    key: CryptoKey?,
  ): PackedByteArray {
    TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_OBJECT(ptr, objectID.id, hashType.value, hash, key)
    TransferContext.callMethod(MethodBindings.signPtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Verify that a given [signature] for [hash] of type [hashType] against the provided public
   * [key].
   */
  public final fun verify(
    hashType: HashingContext.HashType,
    hash: PackedByteArray,
    signature: PackedByteArray,
    key: CryptoKey?,
  ): Boolean {
    TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_OBJECT(ptr, objectID.id, hashType.value, hash, signature, key)
    TransferContext.callMethod(MethodBindings.verifyPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Encrypt the given [plaintext] with the provided public [key].
   *
   * **Note:** The maximum size of accepted plaintext is limited by the key size.
   */
  public final fun encrypt(key: CryptoKey?, plaintext: PackedByteArray): PackedByteArray {
    TransferContext.writeMethodArguments_OBJECT_PACKED_BYTE_ARRAY(ptr, objectID.id, key, plaintext)
    TransferContext.callMethod(MethodBindings.encryptPtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Decrypt the given [ciphertext] with the provided private [key].
   *
   * **Note:** The maximum size of accepted ciphertext is limited by the key size.
   */
  public final fun decrypt(key: CryptoKey?, ciphertext: PackedByteArray): PackedByteArray {
    TransferContext.writeMethodArguments_OBJECT_PACKED_BYTE_ARRAY(ptr, objectID.id, key, ciphertext)
    TransferContext.callMethod(MethodBindings.decryptPtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Generates an [url=https://en.wikipedia.org/wiki/HMAC]HMAC[/url] digest of [msg] using [key].
   * The [hashType] parameter is the hashing algorithm that is used for the inner and outer hashes.
   *
   * Currently, only [HashingContext.HASH_SHA256] and [HashingContext.HASH_SHA1] are supported.
   */
  public final fun hmacDigest(
    hashType: HashingContext.HashType,
    key: PackedByteArray,
    msg: PackedByteArray,
  ): PackedByteArray {
    TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY(ptr, objectID.id, hashType.value, key, msg)
    TransferContext.callMethod(MethodBindings.hmacDigestPtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Compares two [PackedByteArray]s for equality without leaking timing information in order to
   * prevent timing attacks.
   *
   * See
   * [url=https://paragonie.com/blog/2015/11/preventing-timing-attacks-on-string-comparison-with-double-hmac-strategy]this
   * blog post[/url] for more information.
   */
  public final fun constantTimeCompare(trusted: PackedByteArray, received: PackedByteArray):
      Boolean {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY(ptr, objectID.id, trusted, received)
    TransferContext.callMethod(MethodBindings.constantTimeComparePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val generateRandomBytesName: MethodStringName1<Crypto, PackedByteArray, Int> =
        MethodStringName1<Crypto, PackedByteArray, Int>("generate_random_bytes")

    @JvmField
    public val generateRsaName: MethodStringName1<Crypto, CryptoKey?, Int> =
        MethodStringName1<Crypto, CryptoKey?, Int>("generate_rsa")

    @JvmField
    public val generateSelfSignedCertificateName:
        MethodStringName4<Crypto, X509Certificate?, CryptoKey?, String, String, String> =
        MethodStringName4<Crypto, X509Certificate?, CryptoKey?, String, String, String>("generate_self_signed_certificate")

    @JvmField
    public val signName:
        MethodStringName3<Crypto, PackedByteArray, HashingContext.HashType, PackedByteArray, CryptoKey?>
        =
        MethodStringName3<Crypto, PackedByteArray, HashingContext.HashType, PackedByteArray, CryptoKey?>("sign")

    @JvmField
    public val verifyName:
        MethodStringName4<Crypto, Boolean, HashingContext.HashType, PackedByteArray, PackedByteArray, CryptoKey?>
        =
        MethodStringName4<Crypto, Boolean, HashingContext.HashType, PackedByteArray, PackedByteArray, CryptoKey?>("verify")

    @JvmField
    public val encryptName: MethodStringName2<Crypto, PackedByteArray, CryptoKey?, PackedByteArray>
        = MethodStringName2<Crypto, PackedByteArray, CryptoKey?, PackedByteArray>("encrypt")

    @JvmField
    public val decryptName: MethodStringName2<Crypto, PackedByteArray, CryptoKey?, PackedByteArray>
        = MethodStringName2<Crypto, PackedByteArray, CryptoKey?, PackedByteArray>("decrypt")

    @JvmField
    public val hmacDigestName:
        MethodStringName3<Crypto, PackedByteArray, HashingContext.HashType, PackedByteArray, PackedByteArray>
        =
        MethodStringName3<Crypto, PackedByteArray, HashingContext.HashType, PackedByteArray, PackedByteArray>("hmac_digest")

    @JvmField
    public val constantTimeCompareName:
        MethodStringName2<Crypto, Boolean, PackedByteArray, PackedByteArray> =
        MethodStringName2<Crypto, Boolean, PackedByteArray, PackedByteArray>("constant_time_compare")
  }

  public object MethodBindings {
    internal val generateRandomBytesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Crypto", "generate_random_bytes", 47165747)

    internal val generateRsaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Crypto", "generate_rsa", 1237515462)

    internal val generateSelfSignedCertificatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Crypto", "generate_self_signed_certificate", 492266173)

    internal val signPtr: VoidPtr = TypeManager.getMethodBindPtr("Crypto", "sign", 1673662703)

    internal val verifyPtr: VoidPtr = TypeManager.getMethodBindPtr("Crypto", "verify", 2805902225)

    internal val encryptPtr: VoidPtr = TypeManager.getMethodBindPtr("Crypto", "encrypt", 2361793670)

    internal val decryptPtr: VoidPtr = TypeManager.getMethodBindPtr("Crypto", "decrypt", 2361793670)

    internal val hmacDigestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Crypto", "hmac_digest", 2368951203)

    internal val constantTimeComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Crypto", "constant_time_compare", 1024142237)
  }
}
