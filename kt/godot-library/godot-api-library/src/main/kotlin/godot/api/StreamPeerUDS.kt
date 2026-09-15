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
 * A stream peer that handles UNIX Domain Socket (UDS) connections. This object can be used to
 * connect to UDS servers, or also is returned by a UDS server. Unix Domain Sockets provide
 * inter-process communication on the same machine using the filesystem namespace.
 *
 * **Note:** UNIX Domain Sockets are only available on UNIX-like systems (Linux, macOS, etc.) and
 * are not supported on Windows.
 */
@GodotBaseType
public open class StreamPeerUDS : StreamPeerSocket() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(714, scriptPtr)
  }

  /**
   * Opens the UDS socket, and binds it to the specified socket path.
   *
   * This method is generally not needed, and only used to force the subsequent call to
   * [connectToHost] to use the specified [path] as the source address.
   */
  public final fun bind(path: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.bindPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Connects to the specified UNIX Domain Socket path. Returns [OK] on success.
   */
  public final fun connectToHost(path: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, path)
    TransferContext.callMethod(MethodBindings.connectToHostPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the socket path of this peer.
   */
  public final fun getConnectedPath(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectedPathPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val bindName: MethodStringName1<StreamPeerUDS, Error, String> =
        MethodStringName1<StreamPeerUDS, Error, String>("bind")

    @JvmField
    public val connectToHostName: MethodStringName1<StreamPeerUDS, Error, String> =
        MethodStringName1<StreamPeerUDS, Error, String>("connect_to_host")

    @JvmField
    public val getConnectedPathName: MethodStringName0<StreamPeerUDS, String> =
        MethodStringName0<StreamPeerUDS, String>("get_connected_path")
  }

  public object MethodBindings {
    internal val bindPtr: VoidPtr = TypeManager.getMethodBindPtr("StreamPeerUDS", "bind", 166001499)

    internal val connectToHostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerUDS", "connect_to_host", 166001499)

    internal val getConnectedPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerUDS", "get_connected_path", 201670096)
  }
}
