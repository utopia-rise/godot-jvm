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
import godot.callMethod_STRING_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * The X509Certificate class represents an X509 certificate. Certificates can be loaded and saved
 * like any other [Resource].
 *
 * They can be used as the server certificate in [StreamPeerTLS.acceptStream] (along with the proper
 * [CryptoKey]), and to specify the only certificate that should be accepted when connecting to a TLS
 * server via [StreamPeerTLS.connectToStream].
 */
@GodotBaseType
public open class X509Certificate : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(934, scriptPtr)
  }

  /**
   * Saves a certificate to the given [path] (should be a "*.crt" file).
   */
  public final fun save(path: String): Error =
      Error.from(TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.savePtr, path))

  /**
   * Loads a certificate from [path] ("*.crt" file).
   */
  public final fun load(path: String): Error =
      Error.from(TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.loadPtr, path))

  /**
   * Returns a string representation of the certificate, or an empty string if the certificate is
   * invalid.
   */
  public final fun saveToString(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.saveToStringPtr)

  /**
   * Loads a certificate from the given [string].
   */
  public final fun loadFromString(string: String): Error =
      Error.from(TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.loadFromStringPtr, string))

  public companion object {
    @JvmField
    public val saveName: MethodStringName1<X509Certificate, Error, String> =
        MethodStringName1<X509Certificate, Error, String>("save")

    @JvmField
    public val loadName: MethodStringName1<X509Certificate, Error, String> =
        MethodStringName1<X509Certificate, Error, String>("load")

    @JvmField
    public val saveToStringName: MethodStringName0<X509Certificate, String> =
        MethodStringName0<X509Certificate, String>("save_to_string")

    @JvmField
    public val loadFromStringName: MethodStringName1<X509Certificate, Error, String> =
        MethodStringName1<X509Certificate, Error, String>("load_from_string")
  }

  public object MethodBindings {
    internal val savePtr: VoidPtr =
        TypeManager.getMethodBindPtr("X509Certificate", "save", 166001499)

    internal val loadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("X509Certificate", "load", 166001499)

    internal val saveToStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("X509Certificate", "save_to_string", 2841200299)

    internal val loadFromStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("X509Certificate", "load_from_string", 166001499)
  }
}
