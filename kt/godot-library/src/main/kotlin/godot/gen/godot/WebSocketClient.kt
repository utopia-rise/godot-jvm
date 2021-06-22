// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.GodotError
import godot.core.PoolStringArray
import godot.core.TransferContext
import godot.core.VariantType.BOOL
import godot.core.VariantType.JVM_INT
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import godot.core.VariantType.POOL_STRING_ARRAY
import godot.core.VariantType.STRING
import godot.signals.Signal0
import godot.signals.Signal1
import godot.signals.Signal2
import godot.signals.signal
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public open class WebSocketClient : WebSocketMultiplayerPeer() {
  public val connectionClosed: Signal1<Boolean> by signal("was_clean_close")

  public val connectionError: Signal0 by signal()

  public val connectionEstablished: Signal1<String> by signal("protocol")

  public val dataReceived: Signal0 by signal()

  public val serverCloseRequest: Signal2<Long, String> by signal("code", "reason")

  public open var trustedSslCertificate: X509Certificate?
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_WEBSOCKETCLIENT_GET_TRUSTED_SSL_CERTIFICATE, OBJECT)
      return TransferContext.readReturnValue(OBJECT, true) as X509Certificate?
    }
    set(`value`) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_WEBSOCKETCLIENT_SET_TRUSTED_SSL_CERTIFICATE, NIL)
    }

  public open var verifySsl: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_WEBSOCKETCLIENT_GET_VERIFY_SSL,
          BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_WEBSOCKETCLIENT_SET_VERIFY_SSL,
          NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_WEBSOCKETCLIENT)
  }

  public open fun connectToUrl(
    url: String,
    protocols: PoolStringArray = PoolStringArray(),
    gdMpApi: Boolean = false,
    customHeaders: PoolStringArray = PoolStringArray()
  ): GodotError {
    TransferContext.writeArguments(STRING to url, POOL_STRING_ARRAY to protocols, BOOL to gdMpApi,
        POOL_STRING_ARRAY to customHeaders)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_WEBSOCKETCLIENT_CONNECT_TO_URL,
        LONG)
    return GodotError.values()[TransferContext.readReturnValue(JVM_INT) as Int]
  }

  public open fun disconnectFromHost(code: Long = 1000, reason: String = ""): Unit {
    TransferContext.writeArguments(LONG to code, STRING to reason)
    TransferContext.callMethod(rawPtr,
        ENGINEMETHOD_ENGINECLASS_WEBSOCKETCLIENT_DISCONNECT_FROM_HOST, NIL)
  }

  public open fun getConnectedHost(): String {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_WEBSOCKETCLIENT_GET_CONNECTED_HOST,
        STRING)
    return TransferContext.readReturnValue(STRING, false) as String
  }

  public open fun getConnectedPort(): Long {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_WEBSOCKETCLIENT_GET_CONNECTED_PORT,
        LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }
}
