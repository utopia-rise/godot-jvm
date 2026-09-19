// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_LONG_STRING_ret_LONG
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName2
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A TCP server. Listens to connections on a port and returns a [StreamPeerTCP] when it gets an
 * incoming connection.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class TCPServer : SocketServer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(726, scriptPtr)
  }

  /**
   * Listen on the [port] binding to [bindAddress].
   *
   * If [bindAddress] is set as `"*"` (default), the server will listen on all available addresses
   * (both IPv4 and IPv6).
   *
   * If [bindAddress] is set as `"0.0.0.0"` (for IPv4) or `"::"` (for IPv6), the server will listen
   * on all available addresses matching that IP type.
   *
   * If [bindAddress] is set to any valid address (e.g. `"192.168.1.101"`, `"::1"`, etc.), the
   * server will only listen on the interface with that address (or fail if no interface with the given
   * address exists).
   */
  @JvmOverloads
  public final fun listen(port: Int, bindAddress: String = "*"): Error =
      Error.from(TransferContext.callMethod_LONG_STRING_ret_LONG(ptr, objectID.id, MethodBindings.listenPtr, port.toLong(), bindAddress))

  /**
   * Returns the local port this server is listening to.
   */
  public final fun getLocalPort(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getLocalPortPtr).toInt()

  /**
   * If a connection is available, returns a StreamPeerTCP with the connection.
   */
  public final fun takeConnection(): StreamPeerTCP? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.takeConnectionPtr) as StreamPeerTCP?)

  public companion object {
    @JvmField
    public val listenName: MethodStringName2<TCPServer, Error, Int, String> =
        MethodStringName2<TCPServer, Error, Int, String>("listen")

    @JvmField
    public val getLocalPortName: MethodStringName0<TCPServer, Int> =
        MethodStringName0<TCPServer, Int>("get_local_port")

    @JvmField
    public val takeConnectionName: MethodStringName0<TCPServer, StreamPeerTCP?> =
        MethodStringName0<TCPServer, StreamPeerTCP?>("take_connection")
  }

  public object MethodBindings {
    internal val listenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TCPServer", "listen", 3167955072)

    internal val getLocalPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TCPServer", "get_local_port", 3905245786)

    internal val takeConnectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TCPServer", "take_connection", 30545006)
  }
}
