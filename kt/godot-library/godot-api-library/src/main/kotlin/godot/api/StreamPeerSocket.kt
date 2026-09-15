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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * StreamPeerSocket is an abstract base class that defines common behavior for socket-based streams.
 */
@GodotBaseType
public open class StreamPeerSocket internal constructor() : StreamPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(711, scriptPtr)
  }

  /**
   * Polls the socket, updating its state. See [getStatus].
   */
  public final fun poll(): Error {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.pollPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the status of the connection.
   */
  public final fun getStatus(): Status {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStatusPtr, 2)
    return Status.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Disconnects from host.
   */
  public final fun disconnectFromHost(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.disconnectFromHostPtr, 0)
  }

  public enum class Status(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The initial status of the [StreamPeerSocket]. This is also the status after disconnecting.
     */
    NONE(0),
    /**
     * A status representing a [StreamPeerSocket] that is connecting to a host.
     */
    CONNECTING(1),
    /**
     * A status representing a [StreamPeerSocket] that is connected to a host.
     */
    CONNECTED(2),
    /**
     * A status representing a [StreamPeerSocket] in error state.
     */
    ERROR(3),
    ;

    public companion object {
      public fun from(`value`: Long): Status = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val pollName: MethodStringName0<StreamPeerSocket, Error> =
        MethodStringName0<StreamPeerSocket, Error>("poll")

    @JvmField
    public val getStatusName: MethodStringName0<StreamPeerSocket, Status> =
        MethodStringName0<StreamPeerSocket, Status>("get_status")

    @JvmField
    public val disconnectFromHostName: MethodStringName0<StreamPeerSocket, Unit> =
        MethodStringName0<StreamPeerSocket, Unit>("disconnect_from_host")
  }

  public object MethodBindings {
    internal val pollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerSocket", "poll", 166280745)

    internal val getStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerSocket", "get_status", 1156122502)

    internal val disconnectFromHostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerSocket", "disconnect_from_host", 3218959716)
  }
}
