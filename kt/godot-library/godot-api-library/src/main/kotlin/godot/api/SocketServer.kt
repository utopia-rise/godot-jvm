// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * A socket server.
 */
@GodotBaseType
public open class SocketServer internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(684, scriptPtr)
  }

  /**
   * Returns `true` if a connection is available for taking.
   */
  public final fun isConnectionAvailable(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isConnectionAvailablePtr)

  /**
   * Returns `true` if the server is currently listening for connections.
   */
  public final fun isListening(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isListeningPtr)

  /**
   * Stops listening.
   */
  public final fun stop(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.stopPtr)
  }

  /**
   * If a connection is available, returns a StreamPeerSocket with the connection.
   */
  public final fun takeSocketConnection(): StreamPeerSocket? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.takeSocketConnectionPtr) as StreamPeerSocket?)

  public companion object {
    @JvmField
    public val isConnectionAvailableName: MethodStringName0<SocketServer, Boolean> =
        MethodStringName0<SocketServer, Boolean>("is_connection_available")

    @JvmField
    public val isListeningName: MethodStringName0<SocketServer, Boolean> =
        MethodStringName0<SocketServer, Boolean>("is_listening")

    @JvmField
    public val stopName: MethodStringName0<SocketServer, Unit> =
        MethodStringName0<SocketServer, Unit>("stop")

    @JvmField
    public val takeSocketConnectionName: MethodStringName0<SocketServer, StreamPeerSocket?> =
        MethodStringName0<SocketServer, StreamPeerSocket?>("take_socket_connection")
  }

  public object MethodBindings {
    internal val isConnectionAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SocketServer", "is_connection_available", 36873697)

    internal val isListeningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SocketServer", "is_listening", 36873697)

    internal val stopPtr: VoidPtr = TypeManager.getMethodBindPtr("SocketServer", "stop", 3218959716)

    internal val takeSocketConnectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SocketServer", "take_socket_connection", 1883962599)
  }
}
