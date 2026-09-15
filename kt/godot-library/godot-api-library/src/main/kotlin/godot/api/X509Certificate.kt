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
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
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
  public final fun save(path: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.savePtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Loads a certificate from [path] ("*.crt" file).
   */
  public final fun load(path: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.loadPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns a string representation of the certificate, or an empty string if the certificate is
   * invalid.
   */
  public final fun saveToString(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.saveToStringPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Loads a certificate from the given [string].
   */
  public final fun loadFromString(string: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, string)
    TransferContext.callMethod(MethodBindings.loadFromStringPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

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
