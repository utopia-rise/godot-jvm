// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_STRING_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * A Unix Domain Socket (UDS) server. Listens to connections on a socket path and returns a
 * [StreamPeerUDS] when it gets an incoming connection. Unix Domain Sockets provide inter-process
 * communication on the same machine using the filesystem namespace.
 *
 * **Note:** Unix Domain Sockets are only available on Unix-like systems (Linux, macOS, etc.) and
 * are not supported on Windows.
 */
@GodotBaseType
public open class UDSServer : SocketServer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(779, scriptPtr)
  }

  /**
   * Listens on the socket at [path]. The socket file will be created at the specified path.
   *
   * **Note:** The socket file must not already exist at the specified path. You may need to remove
   * any existing socket file before calling this method.
   */
  public final fun listen(path: String): Error =
      Error.from(TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.listenPtr, path))

  /**
   * If a connection is available, returns a StreamPeerUDS with the connection.
   */
  public final fun takeConnection(): StreamPeerUDS? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.takeConnectionPtr) as StreamPeerUDS?)

  public companion object {
    @JvmField
    public val listenName: MethodStringName1<UDSServer, Error, String> =
        MethodStringName1<UDSServer, Error, String>("listen")

    @JvmField
    public val takeConnectionName: MethodStringName0<UDSServer, StreamPeerUDS?> =
        MethodStringName0<UDSServer, StreamPeerUDS?>("take_connection")
  }

  public object MethodBindings {
    internal val listenPtr: VoidPtr = TypeManager.getMethodBindPtr("UDSServer", "listen", 166001499)

    internal val takeConnectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UDSServer", "take_connection", 1623851112)
  }
}
