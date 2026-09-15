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
import godot.core.MethodStringName2
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_STRING_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A stream peer that handles TCP connections. This object can be used to connect to TCP servers, or
 * also is returned by a TCP server.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class StreamPeerTCP : StreamPeerSocket() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(712, scriptPtr)
  }

  /**
   * Opens the TCP socket, and binds it to the specified local address.
   *
   * This method is generally not needed, and only used to force the subsequent call to
   * [connectToHost] to use the specified [host] and [port] as source address. This can be desired in
   * some NAT punchthrough techniques, or when forcing the source network interface.
   */
  @JvmOverloads
  public final fun bind(port: Int, host: String = "*"): Error {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, port.toLong(), host)
    TransferContext.callMethod(MethodBindings.bindPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Connects to the specified `host:port` pair. A hostname will be resolved if valid. Returns [OK]
   * on success.
   */
  public final fun connectToHost(host: String, port: Int): Error {
    TransferContext.writeMethodArguments_STRING_LONG(ptr, objectID.id, host, port.toLong())
    TransferContext.callMethod(MethodBindings.connectToHostPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the IP of this peer.
   */
  public final fun getConnectedHost(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectedHostPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the port of this peer.
   */
  public final fun getConnectedPort(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectedPortPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the local port to which this peer is bound.
   */
  public final fun getLocalPort(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalPortPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * If [enabled] is `true`, packets will be sent immediately. If [enabled] is `false` (the
   * default), packet transfers will be delayed and combined using
   * [url=https://en.wikipedia.org/wiki/Nagle&#37;27s_algorithm]Nagle's algorithm[/url].
   *
   * **Note:** It's recommended to leave this disabled for applications that send large packets or
   * need to transfer a lot of data, as enabling this can decrease the total available bandwidth.
   */
  public final fun setNoDelay(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setNoDelayPtr)
  }

  public companion object {
    @JvmField
    public val bindName: MethodStringName2<StreamPeerTCP, Error, Int, String> =
        MethodStringName2<StreamPeerTCP, Error, Int, String>("bind")

    @JvmField
    public val connectToHostName: MethodStringName2<StreamPeerTCP, Error, String, Int> =
        MethodStringName2<StreamPeerTCP, Error, String, Int>("connect_to_host")

    @JvmField
    public val getConnectedHostName: MethodStringName0<StreamPeerTCP, String> =
        MethodStringName0<StreamPeerTCP, String>("get_connected_host")

    @JvmField
    public val getConnectedPortName: MethodStringName0<StreamPeerTCP, Int> =
        MethodStringName0<StreamPeerTCP, Int>("get_connected_port")

    @JvmField
    public val getLocalPortName: MethodStringName0<StreamPeerTCP, Int> =
        MethodStringName0<StreamPeerTCP, Int>("get_local_port")

    @JvmField
    public val setNoDelayName: MethodStringName1<StreamPeerTCP, Unit, Boolean> =
        MethodStringName1<StreamPeerTCP, Unit, Boolean>("set_no_delay")
  }

  public object MethodBindings {
    internal val bindPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTCP", "bind", 3167955072)

    internal val connectToHostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTCP", "connect_to_host", 993915709)

    internal val getConnectedHostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTCP", "get_connected_host", 201670096)

    internal val getConnectedPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTCP", "get_connected_port", 3905245786)

    internal val getLocalPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTCP", "get_local_port", 3905245786)

    internal val setNoDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTCP", "set_no_delay", 2586408642)
  }
}
