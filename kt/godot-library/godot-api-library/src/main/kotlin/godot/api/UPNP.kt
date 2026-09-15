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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG_STRING
import godot.writeMethodArguments_LONG_LONG_STRING_STRING_LONG
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This class can be used to discover compatible [UPNPDevice]s on the local network and execute
 * commands on them, like managing port mappings (for port forwarding/NAT traversal) and querying the
 * local and remote network IP address. Note that methods on this class are synchronous and block the
 * calling thread.
 *
 * To forward a specific port (here `7777`, note both [discover] and [addPortMapping] can return
 * errors that should be checked):
 *
 * ```
 * var upnp = UPNP.new()
 * upnp.discover()
 * upnp.add_port_mapping(7777)
 * ```
 *
 * To close a specific port (e.g. after you have finished using it):
 *
 * ```
 * upnp.delete_port_mapping(port)
 * ```
 *
 * **Note:** UPnP discovery blocks the current thread. To perform discovery without blocking the
 * main thread, use [Thread]s like this:
 *
 * ```
 * # Emitted when UPnP port mapping setup is completed (regardless of success or failure).
 * signal upnp_completed(error)
 *
 * # Replace this with your own server port number between 1024 and 65535.
 * const SERVER_PORT = 3928
 * var thread = null
 *
 * func _upnp_setup(server_port):
 * 	# UPNP queries take some time.
 * 	var upnp = UPNP.new()
 * 	var err = upnp.discover()
 *
 * 	if err != UPNP.UPNP_RESULT_SUCCESS:
 * 		push_error(str(err))
 * 		upnp_completed.emit(err)
 * 		return
 *
 * 	if upnp.get_gateway() and upnp.get_gateway().is_valid_gateway():
 * 		upnp.add_port_mapping(server_port, server_port,
 * ProjectSettings.get_setting("application/config/name"), "UDP")
 * 		upnp.add_port_mapping(server_port, server_port,
 * ProjectSettings.get_setting("application/config/name"), "TCP")
 * 		upnp_completed.emit(UPNP.UPNP_RESULT_SUCCESS)
 *
 * func _ready():
 * 	thread = Thread.new()
 * 	thread.start(_upnp_setup.bind(SERVER_PORT))
 *
 * func _exit_tree():
 * 	# Wait for thread finish here to handle game exit while the thread is running.
 * 	thread.wait_to_finish()
 * ```
 *
 * **Terminology:** In the context of UPnP networking, "gateway" (or "internet gateway device",
 * short IGD) refers to network devices that allow computers in the local network to access the
 * internet ("wide area network", WAN). These gateways are often also called "routers".
 *
 * **Pitfalls:**
 *
 * - As explained above, these calls are blocking and shouldn't be run on the main thread,
 * especially as they can block for multiple seconds at a time. Use threading!
 *
 * - Networking is physical and messy. Packets get lost in transit or get filtered, addresses, free
 * ports and assigned mappings change, and devices may leave or join the network at any time. Be
 * mindful of this, be diligent when checking and handling errors, and handle these gracefully if you
 * can: add clear error UI, timeouts and re-try handling.
 *
 * - Port mappings may change (and be removed) at any time, and the remote/external IP address of
 * the gateway can change likewise. You should consider re-querying the external IP and try to
 * update/refresh the port mapping periodically (for example, every 5 minutes and on networking
 * failures).
 *
 * - Not all devices support UPnP, and some users disable UPnP support. You need to handle this
 * (e.g. documenting and requiring the user to manually forward ports, or adding alternative methods of
 * NAT traversal, like a relay/mirror server, or NAT hole punching, STUN/TURN, etc.).
 *
 * - Consider what happens on mapping conflicts. Maybe multiple users on the same network would like
 * to play your game at the same time, or maybe another application uses the same port. Make the port
 * configurable, and optimally choose a port automatically (re-trying with a different port on
 * failure).
 *
 * **Further reading:** If you want to know more about UPnP (and the Internet Gateway Device (IGD)
 * and Port Control Protocol (PCP) specifically),
 * [url=https://en.wikipedia.org/wiki/Universal_Plug_and_Play]Wikipedia[/url] is a good first stop, the
 * specification can be found at the
 * [url=https://openconnectivity.org/developer/specifications/upnp-resources/upnp/]Open Connectivity
 * Foundation[/url] and Godot's implementation is based on the
 * [url=https://github.com/miniupnp/miniupnp]MiniUPnP client[/url].
 */
@GodotBaseType
public open class UPNP : RefCounted() {
  /**
   * Multicast interface to use for discovery. Uses the default multicast interface if empty.
   */
  public final inline var discoverMulticastIf: String
    @JvmName("discoverMulticastIfProperty")
    get() = getDiscoverMulticastIf()
    @JvmName("discoverMulticastIfProperty")
    set(`value`) {
      setDiscoverMulticastIf(value)
    }

  /**
   * If `0`, the local port to use for discovery is chosen automatically by the system. If `1`,
   * discovery will be done from the source port 1900 (same as destination port). Otherwise, the value
   * will be used as the port.
   */
  public final inline var discoverLocalPort: Int
    @JvmName("discoverLocalPortProperty")
    get() = getDiscoverLocalPort()
    @JvmName("discoverLocalPortProperty")
    set(`value`) {
      setDiscoverLocalPort(value)
    }

  /**
   * If `true`, IPv6 is used for [UPNPDevice] discovery.
   */
  public final inline var discoverIpv6: Boolean
    @JvmName("discoverIpv6Property")
    get() = isDiscoverIpv6()
    @JvmName("discoverIpv6Property")
    set(`value`) {
      setDiscoverIpv6(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(780, scriptPtr)
  }

  /**
   * Returns the number of discovered [UPNPDevice]s.
   */
  public final fun getDeviceCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDeviceCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the [UPNPDevice] at the given [index].
   */
  public final fun getDevice(index: Int): UPNPDevice? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getDevicePtr)
    return (TransferContext.readReturnValue_OBJECT() as UPNPDevice?)
  }

  /**
   * Adds the given [UPNPDevice] to the list of discovered devices.
   */
  public final fun addDevice(device: UPNPDevice?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, device)
    TransferContext.callMethod(MethodBindings.addDevicePtr)
  }

  /**
   * Sets the device at [index] from the list of discovered devices to [device].
   */
  public final fun setDevice(index: Int, device: UPNPDevice?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, index.toLong(), device)
    TransferContext.callMethod(MethodBindings.setDevicePtr)
  }

  /**
   * Removes the device at [index] from the list of discovered devices.
   */
  public final fun removeDevice(index: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.removeDevicePtr)
  }

  /**
   * Clears the list of discovered devices.
   */
  public final fun clearDevices(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearDevicesPtr)
  }

  /**
   * Returns the default gateway. That is the first discovered [UPNPDevice] that is also a valid IGD
   * (InternetGatewayDevice).
   */
  public final fun getGateway(): UPNPDevice? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGatewayPtr)
    return (TransferContext.readReturnValue_OBJECT() as UPNPDevice?)
  }

  /**
   * Discovers local [UPNPDevice]s. Clears the list of previously discovered devices.
   *
   * Filters for IGD (InternetGatewayDevice) type devices by default, as those manage port
   * forwarding. [timeout] is the time to wait for responses in milliseconds. [ttl] is the
   * time-to-live; only touch this if you know what you're doing.
   *
   * See [UPNPResult] for possible return values.
   */
  @JvmOverloads
  public final fun discover(
    timeout: Int = 2000,
    ttl: Int = 2,
    deviceFilter: String = "InternetGatewayDevice",
  ): Int {
    TransferContext.writeMethodArguments_LONG_LONG_STRING(ptr, objectID.id, timeout.toLong(), ttl.toLong(), deviceFilter)
    TransferContext.callMethod(MethodBindings.discoverPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the external [IP] address of the default gateway (see [getGateway]) as string. Returns
   * an empty string on error.
   */
  public final fun queryExternalAddress(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.queryExternalAddressPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Adds a mapping to forward the external [port] (between 1 and 65535, although recommended to use
   * port 1024 or above) on the default gateway (see [getGateway]) to the [portInternal] on the local
   * machine for the given protocol [proto] (either `"TCP"` or `"UDP"`, with UDP being the default). If
   * a port mapping for the given port and protocol combination already exists on that gateway device,
   * this method tries to overwrite it. If that is not desired, you can retrieve the gateway manually
   * with [getGateway] and call [addPortMapping] on it, if any. Note that forwarding a well-known port
   * (below 1024) with UPnP may fail depending on the device.
   *
   * Depending on the gateway device, if a mapping for that port already exists, it will either be
   * updated or it will refuse this command due to that conflict, especially if the existing mapping
   * for that port wasn't created via UPnP or points to a different network address (or device) than
   * this one.
   *
   * If [portInternal] is `0` (the default), the same port number is used for both the external and
   * the internal port (the [port] value).
   *
   * The description ([desc]) is shown in some routers management UIs and can be used to point out
   * which application added the mapping.
   *
   * The mapping's lease [duration] can be limited by specifying a duration in seconds. The default
   * of `0` means no duration, i.e. a permanent lease and notably some devices only support these
   * permanent leases. Note that whether permanent or not, this is only a request and the gateway may
   * still decide at any point to remove the mapping (which usually happens on a reboot of the gateway,
   * when its external IP address changes, or on some models when it detects a port mapping has become
   * inactive, i.e. had no traffic for multiple minutes). If not `0` (permanent), the allowed range
   * according to spec is between `120` (2 minutes) and `86400` seconds (24 hours).
   *
   * See [UPNPResult] for possible return values.
   */
  @JvmOverloads
  public final fun addPortMapping(
    port: Int,
    portInternal: Int = 0,
    desc: String = "",
    proto: String = "UDP",
    duration: Int = 0,
  ): Int {
    TransferContext.writeMethodArguments_LONG_LONG_STRING_STRING_LONG(ptr, objectID.id, port.toLong(), portInternal.toLong(), desc, proto, duration.toLong())
    TransferContext.callMethod(MethodBindings.addPortMappingPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Deletes the port mapping for the given port and protocol combination on the default gateway
   * (see [getGateway]) if one exists. [port] must be a valid port between 1 and 65535, [proto] can be
   * either `"TCP"` or `"UDP"`. May be refused for mappings pointing to addresses other than this one,
   * for well-known ports (below 1024), or for mappings not added via UPnP. See [UPNPResult] for
   * possible return values.
   */
  @JvmOverloads
  public final fun deletePortMapping(port: Int, proto: String = "UDP"): Int {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, port.toLong(), proto)
    TransferContext.callMethod(MethodBindings.deletePortMappingPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setDiscoverMulticastIf(mIf: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, mIf)
    TransferContext.callMethod(MethodBindings.setDiscoverMulticastIfPtr)
  }

  public final fun getDiscoverMulticastIf(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDiscoverMulticastIfPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setDiscoverLocalPort(port: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, port.toLong())
    TransferContext.callMethod(MethodBindings.setDiscoverLocalPortPtr)
  }

  public final fun getDiscoverLocalPort(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDiscoverLocalPortPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setDiscoverIpv6(ipv6: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, ipv6)
    TransferContext.callMethod(MethodBindings.setDiscoverIpv6Ptr)
  }

  public final fun isDiscoverIpv6(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDiscoverIpv6Ptr)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class UPNPResult(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * UPNP command or discovery was successful.
     */
    SUCCESS(0),
    /**
     * Not authorized to use the command on the [UPNPDevice]. May be returned when the user disabled
     * UPNP on their router.
     */
    NOT_AUTHORIZED(1),
    /**
     * No port mapping was found for the given port, protocol combination on the given [UPNPDevice].
     */
    PORT_MAPPING_NOT_FOUND(2),
    /**
     * Inconsistent parameters.
     */
    INCONSISTENT_PARAMETERS(3),
    /**
     * No such entry in array. May be returned if a given port, protocol combination is not found on
     * a [UPNPDevice].
     */
    NO_SUCH_ENTRY_IN_ARRAY(4),
    /**
     * The action failed.
     */
    ACTION_FAILED(5),
    /**
     * The [UPNPDevice] does not allow wildcard values for the source IP address.
     */
    SRC_IP_WILDCARD_NOT_PERMITTED(6),
    /**
     * The [UPNPDevice] does not allow wildcard values for the external port.
     */
    EXT_PORT_WILDCARD_NOT_PERMITTED(7),
    /**
     * The [UPNPDevice] does not allow wildcard values for the internal port.
     */
    INT_PORT_WILDCARD_NOT_PERMITTED(8),
    /**
     * The remote host value must be a wildcard.
     */
    REMOTE_HOST_MUST_BE_WILDCARD(9),
    /**
     * The external port value must be a wildcard.
     */
    EXT_PORT_MUST_BE_WILDCARD(10),
    /**
     * No port maps are available. May also be returned if port mapping functionality is not
     * available.
     */
    NO_PORT_MAPS_AVAILABLE(11),
    /**
     * Conflict with other mechanism. May be returned instead of
     * [UPNP_RESULT_CONFLICT_WITH_OTHER_MAPPING] if a port mapping conflicts with an existing one.
     */
    CONFLICT_WITH_OTHER_MECHANISM(12),
    /**
     * Conflict with an existing port mapping.
     */
    CONFLICT_WITH_OTHER_MAPPING(13),
    /**
     * External and internal port values must be the same.
     */
    SAME_PORT_VALUES_REQUIRED(14),
    /**
     * Only permanent leases are supported. Do not use the `duration` parameter when adding port
     * mappings.
     */
    ONLY_PERMANENT_LEASE_SUPPORTED(15),
    /**
     * Invalid gateway.
     */
    INVALID_GATEWAY(16),
    /**
     * Invalid port.
     */
    INVALID_PORT(17),
    /**
     * Invalid protocol.
     */
    INVALID_PROTOCOL(18),
    /**
     * Invalid duration.
     */
    INVALID_DURATION(19),
    /**
     * Invalid arguments.
     */
    INVALID_ARGS(20),
    /**
     * Invalid response.
     */
    INVALID_RESPONSE(21),
    /**
     * Invalid parameter.
     */
    INVALID_PARAM(22),
    /**
     * HTTP error.
     */
    HTTP_ERROR(23),
    /**
     * Socket error.
     */
    SOCKET_ERROR(24),
    /**
     * Error allocating memory.
     */
    MEM_ALLOC_ERROR(25),
    /**
     * No gateway available. You may need to call [discover] first, or discovery didn't detect any
     * valid IGDs (InternetGatewayDevices).
     */
    NO_GATEWAY(26),
    /**
     * No devices available. You may need to call [discover] first, or discovery didn't detect any
     * valid [UPNPDevice]s.
     */
    NO_DEVICES(27),
    /**
     * Unknown error.
     */
    UNKNOWN_ERROR(28),
    ;

    public companion object {
      public fun from(`value`: Long): UPNPResult = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getDeviceCountName: MethodStringName0<UPNP, Int> =
        MethodStringName0<UPNP, Int>("get_device_count")

    @JvmField
    public val getDeviceName: MethodStringName1<UPNP, UPNPDevice?, Int> =
        MethodStringName1<UPNP, UPNPDevice?, Int>("get_device")

    @JvmField
    public val addDeviceName: MethodStringName1<UPNP, Unit, UPNPDevice?> =
        MethodStringName1<UPNP, Unit, UPNPDevice?>("add_device")

    @JvmField
    public val setDeviceName: MethodStringName2<UPNP, Unit, Int, UPNPDevice?> =
        MethodStringName2<UPNP, Unit, Int, UPNPDevice?>("set_device")

    @JvmField
    public val removeDeviceName: MethodStringName1<UPNP, Unit, Int> =
        MethodStringName1<UPNP, Unit, Int>("remove_device")

    @JvmField
    public val clearDevicesName: MethodStringName0<UPNP, Unit> =
        MethodStringName0<UPNP, Unit>("clear_devices")

    @JvmField
    public val getGatewayName: MethodStringName0<UPNP, UPNPDevice?> =
        MethodStringName0<UPNP, UPNPDevice?>("get_gateway")

    @JvmField
    public val discoverName: MethodStringName3<UPNP, Int, Int, Int, String> =
        MethodStringName3<UPNP, Int, Int, Int, String>("discover")

    @JvmField
    public val queryExternalAddressName: MethodStringName0<UPNP, String> =
        MethodStringName0<UPNP, String>("query_external_address")

    @JvmField
    public val addPortMappingName: MethodStringName5<UPNP, Int, Int, Int, String, String, Int> =
        MethodStringName5<UPNP, Int, Int, Int, String, String, Int>("add_port_mapping")

    @JvmField
    public val deletePortMappingName: MethodStringName2<UPNP, Int, Int, String> =
        MethodStringName2<UPNP, Int, Int, String>("delete_port_mapping")

    @JvmField
    public val setDiscoverMulticastIfName: MethodStringName1<UPNP, Unit, String> =
        MethodStringName1<UPNP, Unit, String>("set_discover_multicast_if")

    @JvmField
    public val getDiscoverMulticastIfName: MethodStringName0<UPNP, String> =
        MethodStringName0<UPNP, String>("get_discover_multicast_if")

    @JvmField
    public val setDiscoverLocalPortName: MethodStringName1<UPNP, Unit, Int> =
        MethodStringName1<UPNP, Unit, Int>("set_discover_local_port")

    @JvmField
    public val getDiscoverLocalPortName: MethodStringName0<UPNP, Int> =
        MethodStringName0<UPNP, Int>("get_discover_local_port")

    @JvmField
    public val setDiscoverIpv6Name: MethodStringName1<UPNP, Unit, Boolean> =
        MethodStringName1<UPNP, Unit, Boolean>("set_discover_ipv6")

    @JvmField
    public val isDiscoverIpv6Name: MethodStringName0<UPNP, Boolean> =
        MethodStringName0<UPNP, Boolean>("is_discover_ipv6")
  }

  public object MethodBindings {
    internal val getDeviceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "get_device_count", 3905245786)

    internal val getDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "get_device", 2193290270)

    internal val addDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "add_device", 986715920)

    internal val setDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "set_device", 3015133723)

    internal val removeDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "remove_device", 1286410249)

    internal val clearDevicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "clear_devices", 3218959716)

    internal val getGatewayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "get_gateway", 2276800779)

    internal val discoverPtr: VoidPtr = TypeManager.getMethodBindPtr("UPNP", "discover", 1575334765)

    internal val queryExternalAddressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "query_external_address", 201670096)

    internal val addPortMappingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "add_port_mapping", 818314583)

    internal val deletePortMappingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "delete_port_mapping", 3444187325)

    internal val setDiscoverMulticastIfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "set_discover_multicast_if", 83702148)

    internal val getDiscoverMulticastIfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "get_discover_multicast_if", 201670096)

    internal val setDiscoverLocalPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "set_discover_local_port", 1286410249)

    internal val getDiscoverLocalPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "get_discover_local_port", 3905245786)

    internal val setDiscoverIpv6Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "set_discover_ipv6", 2586408642)

    internal val isDiscoverIpv6Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNP", "is_discover_ipv6", 36873697)
  }
}
