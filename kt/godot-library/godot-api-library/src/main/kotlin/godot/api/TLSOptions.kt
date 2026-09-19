// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_OBJECT_STRING_ret_OBJECT_REF
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_OBJECT_OBJECT_ret_OBJECT_REF
import godot.callPtrMethod_OBJECT_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * TLSOptions abstracts the configuration options for the [StreamPeerTLS] and [PacketPeerDTLS]
 * classes.
 *
 * Objects of this class cannot be instantiated directly, and one of the static methods [client],
 * [clientUnsafe], or [server] should be used instead.
 *
 * ```gdscript
 * //gdscript
 * # Create a TLS client configuration which uses our custom trusted CA chain.
 * var client_trusted_cas = load("res://my_trusted_cas.crt")
 * var client_tls_options = TLSOptions.client(client_trusted_cas)
 *
 * # Create a TLS server configuration.
 * var server_certs = load("res://my_server_cas.crt")
 * var server_key = load("res://my_server_key.key")
 * var server_tls_options = TLSOptions.server(server_key, server_certs)
 * ```
 */
@GodotBaseType
public open class TLSOptions internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(727, scriptPtr)
  }

  /**
   * Returns `true` if created with [TLSOptions.server], `false` otherwise.
   */
  public final fun isServer(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isServerPtr)

  /**
   * Returns `true` if created with [TLSOptions.clientUnsafe], `false` otherwise.
   */
  public final fun isUnsafeClient(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isUnsafeClientPtr)

  /**
   * Returns the common name (domain name) override specified when creating with
   * [TLSOptions.client].
   */
  public final fun getCommonNameOverride(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getCommonNameOverridePtr)

  /**
   * Returns the CA [X509Certificate] chain specified when creating with [TLSOptions.client] or
   * [TLSOptions.clientUnsafe].
   */
  public final fun getTrustedCaChain(): X509Certificate? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getTrustedCaChainPtr) as X509Certificate?)

  /**
   * Returns the [CryptoKey] specified when creating with [TLSOptions.server].
   */
  public final fun getPrivateKey(): CryptoKey? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getPrivateKeyPtr) as CryptoKey?)

  /**
   * Returns the [X509Certificate] specified when creating with [TLSOptions.server].
   */
  public final fun getOwnCertificate(): X509Certificate? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getOwnCertificatePtr) as X509Certificate?)

  public companion object {
    @JvmField
    public val clientName: MethodStringName2<TLSOptions, TLSOptions?, X509Certificate?, String> =
        MethodStringName2<TLSOptions, TLSOptions?, X509Certificate?, String>("client")

    @JvmField
    public val clientUnsafeName: MethodStringName1<TLSOptions, TLSOptions?, X509Certificate?> =
        MethodStringName1<TLSOptions, TLSOptions?, X509Certificate?>("client_unsafe")

    @JvmField
    public val serverName: MethodStringName2<TLSOptions, TLSOptions?, CryptoKey?, X509Certificate?>
        = MethodStringName2<TLSOptions, TLSOptions?, CryptoKey?, X509Certificate?>("server")

    @JvmField
    public val isServerName: MethodStringName0<TLSOptions, Boolean> =
        MethodStringName0<TLSOptions, Boolean>("is_server")

    @JvmField
    public val isUnsafeClientName: MethodStringName0<TLSOptions, Boolean> =
        MethodStringName0<TLSOptions, Boolean>("is_unsafe_client")

    @JvmField
    public val getCommonNameOverrideName: MethodStringName0<TLSOptions, String> =
        MethodStringName0<TLSOptions, String>("get_common_name_override")

    @JvmField
    public val getTrustedCaChainName: MethodStringName0<TLSOptions, X509Certificate?> =
        MethodStringName0<TLSOptions, X509Certificate?>("get_trusted_ca_chain")

    @JvmField
    public val getPrivateKeyName: MethodStringName0<TLSOptions, CryptoKey?> =
        MethodStringName0<TLSOptions, CryptoKey?>("get_private_key")

    @JvmField
    public val getOwnCertificateName: MethodStringName0<TLSOptions, X509Certificate?> =
        MethodStringName0<TLSOptions, X509Certificate?>("get_own_certificate")

    /**
     * Creates a TLS client configuration which validates certificates and their common names (fully
     * qualified domain names).
     *
     * You can specify a custom [trustedChain] of certification authorities (the default CA list
     * will be used if `null`), and optionally provide a [commonNameOverride] if you expect the
     * certificate to have a common name other than the server FQDN.
     *
     * **Note:** On the Web platform, TLS verification is always enforced against the CA list of the
     * web browser. This is considered a security feature.
     */
    @JvmOverloads
    @JvmStatic
    public final fun client(trustedChain: X509Certificate? = null, commonNameOverride: String = ""):
        TLSOptions? =
        (TransferContext.callMethod_OBJECT_STRING_ret_OBJECT_REF(0L, 0L, MethodBindings.clientPtr, trustedChain, commonNameOverride) as TLSOptions?)

    /**
     * Creates an **unsafe** TLS client configuration where certificate validation is optional. You
     * can optionally provide a valid [trustedChain], but the common name of the certificates will
     * never be checked. Using this configuration for purposes other than testing **is not
     * recommended**.
     *
     * **Note:** On the Web platform, TLS verification is always enforced against the CA list of the
     * web browser. This is considered a security feature.
     */
    @JvmOverloads
    @JvmStatic
    public final fun clientUnsafe(trustedChain: X509Certificate? = null): TLSOptions? =
        (TransferContext.callPtrMethod_OBJECT_ret_OBJECT_REF(0L, 0L, MethodBindings.clientUnsafePtr, trustedChain) as TLSOptions?)

    /**
     * Creates a TLS server configuration using the provided [key] and [certificate].
     *
     * **Note:** The [certificate] should include the full certificate chain up to the signing CA
     * (certificates file can be concatenated using a general purpose text editor).
     */
    @JvmStatic
    public final fun server(key: CryptoKey?, certificate: X509Certificate?): TLSOptions? =
        (TransferContext.callPtrMethod_OBJECT_OBJECT_ret_OBJECT_REF(0L, 0L, MethodBindings.serverPtr, key, certificate) as TLSOptions?)
  }

  public object MethodBindings {
    internal val clientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TLSOptions", "client", 3565000357)

    internal val clientUnsafePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TLSOptions", "client_unsafe", 2090251749)

    internal val serverPtr: VoidPtr = TypeManager.getMethodBindPtr("TLSOptions", "server", 36969539)

    internal val isServerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TLSOptions", "is_server", 36873697)

    internal val isUnsafeClientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TLSOptions", "is_unsafe_client", 36873697)

    internal val getCommonNameOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TLSOptions", "get_common_name_override", 201670096)

    internal val getTrustedCaChainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TLSOptions", "get_trusted_ca_chain", 1120709175)

    internal val getPrivateKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TLSOptions", "get_private_key", 2119971811)

    internal val getOwnCertificatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TLSOptions", "get_own_certificate", 1120709175)
  }
}
