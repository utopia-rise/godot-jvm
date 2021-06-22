// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.BOOL
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import godot.core.VariantType.STRING
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public open class UPNP : Reference() {
  public open var discoverIpv6: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_GET_DISCOVER_IPV6, BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_SET_DISCOVER_IPV6, NIL)
    }

  public open var discoverLocalPort: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_GET_DISCOVER_LOCAL_PORT,
          LONG)
      return TransferContext.readReturnValue(LONG, false) as Long
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_SET_DISCOVER_LOCAL_PORT, NIL)
    }

  public open var discoverMulticastIf: String
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_GET_DISCOVER_MULTICAST_IF,
          STRING)
      return TransferContext.readReturnValue(STRING, false) as String
    }
    set(`value`) {
      TransferContext.writeArguments(STRING to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_SET_DISCOVER_MULTICAST_IF,
          NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_UPNP)
  }

  public open fun addDevice(device: UPNPDevice): Unit {
    TransferContext.writeArguments(OBJECT to device)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_ADD_DEVICE, NIL)
  }

  public open fun addPortMapping(
    port: Long,
    portInternal: Long = 0,
    desc: String = "",
    proto: String = "UDP",
    duration: Long = 0
  ): Long {
    TransferContext.writeArguments(LONG to port, LONG to portInternal, STRING to desc, STRING to
        proto, LONG to duration)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_ADD_PORT_MAPPING, LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }

  public open fun clearDevices(): Unit {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_CLEAR_DEVICES, NIL)
  }

  public open fun deletePortMapping(port: Long, proto: String = "UDP"): Long {
    TransferContext.writeArguments(LONG to port, STRING to proto)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_DELETE_PORT_MAPPING, LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }

  public open fun discover(
    timeout: Long = 2000,
    ttl: Long = 2,
    deviceFilter: String = "InternetGatewayDevice"
  ): Long {
    TransferContext.writeArguments(LONG to timeout, LONG to ttl, STRING to deviceFilter)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_DISCOVER, LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }

  public open fun getDevice(index: Long): UPNPDevice? {
    TransferContext.writeArguments(LONG to index)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_GET_DEVICE, OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as UPNPDevice?
  }

  public open fun getDeviceCount(): Long {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_GET_DEVICE_COUNT, LONG)
    return TransferContext.readReturnValue(LONG, false) as Long
  }

  public open fun getGateway(): UPNPDevice? {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_GET_GATEWAY, OBJECT)
    return TransferContext.readReturnValue(OBJECT, true) as UPNPDevice?
  }

  public open fun queryExternalAddress(): String {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_QUERY_EXTERNAL_ADDRESS, STRING)
    return TransferContext.readReturnValue(STRING, false) as String
  }

  public open fun removeDevice(index: Long): Unit {
    TransferContext.writeArguments(LONG to index)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_REMOVE_DEVICE, NIL)
  }

  public open fun setDevice(index: Long, device: UPNPDevice): Unit {
    TransferContext.writeArguments(LONG to index, OBJECT to device)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_UPNP_SET_DEVICE, NIL)
  }

  public enum class UPNPResult(
    id: Long
  ) {
    UPNP_RESULT_SUCCESS(0),
    UPNP_RESULT_NOT_AUTHORIZED(1),
    UPNP_RESULT_PORT_MAPPING_NOT_FOUND(2),
    UPNP_RESULT_INCONSISTENT_PARAMETERS(3),
    UPNP_RESULT_NO_SUCH_ENTRY_IN_ARRAY(4),
    UPNP_RESULT_ACTION_FAILED(5),
    UPNP_RESULT_SRC_IP_WILDCARD_NOT_PERMITTED(6),
    UPNP_RESULT_EXT_PORT_WILDCARD_NOT_PERMITTED(7),
    UPNP_RESULT_INT_PORT_WILDCARD_NOT_PERMITTED(8),
    UPNP_RESULT_REMOTE_HOST_MUST_BE_WILDCARD(9),
    UPNP_RESULT_EXT_PORT_MUST_BE_WILDCARD(10),
    UPNP_RESULT_NO_PORT_MAPS_AVAILABLE(11),
    UPNP_RESULT_CONFLICT_WITH_OTHER_MECHANISM(12),
    UPNP_RESULT_CONFLICT_WITH_OTHER_MAPPING(13),
    UPNP_RESULT_SAME_PORT_VALUES_REQUIRED(14),
    UPNP_RESULT_ONLY_PERMANENT_LEASE_SUPPORTED(15),
    UPNP_RESULT_INVALID_GATEWAY(16),
    UPNP_RESULT_INVALID_PORT(17),
    UPNP_RESULT_INVALID_PROTOCOL(18),
    UPNP_RESULT_INVALID_DURATION(19),
    UPNP_RESULT_INVALID_ARGS(20),
    UPNP_RESULT_INVALID_RESPONSE(21),
    UPNP_RESULT_INVALID_PARAM(22),
    UPNP_RESULT_HTTP_ERROR(23),
    UPNP_RESULT_SOCKET_ERROR(24),
    UPNP_RESULT_MEM_ALLOC_ERROR(25),
    UPNP_RESULT_NO_GATEWAY(26),
    UPNP_RESULT_NO_DEVICES(27),
    UPNP_RESULT_UNKNOWN_ERROR(28),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public companion object {
    public final const val UPNP_RESULT_ACTION_FAILED: Long = 5

    public final const val UPNP_RESULT_CONFLICT_WITH_OTHER_MAPPING: Long = 13

    public final const val UPNP_RESULT_CONFLICT_WITH_OTHER_MECHANISM: Long = 12

    public final const val UPNP_RESULT_EXT_PORT_MUST_BE_WILDCARD: Long = 10

    public final const val UPNP_RESULT_EXT_PORT_WILDCARD_NOT_PERMITTED: Long = 7

    public final const val UPNP_RESULT_HTTP_ERROR: Long = 23

    public final const val UPNP_RESULT_INCONSISTENT_PARAMETERS: Long = 3

    public final const val UPNP_RESULT_INT_PORT_WILDCARD_NOT_PERMITTED: Long = 8

    public final const val UPNP_RESULT_INVALID_ARGS: Long = 20

    public final const val UPNP_RESULT_INVALID_DURATION: Long = 19

    public final const val UPNP_RESULT_INVALID_GATEWAY: Long = 16

    public final const val UPNP_RESULT_INVALID_PARAM: Long = 22

    public final const val UPNP_RESULT_INVALID_PORT: Long = 17

    public final const val UPNP_RESULT_INVALID_PROTOCOL: Long = 18

    public final const val UPNP_RESULT_INVALID_RESPONSE: Long = 21

    public final const val UPNP_RESULT_MEM_ALLOC_ERROR: Long = 25

    public final const val UPNP_RESULT_NOT_AUTHORIZED: Long = 1

    public final const val UPNP_RESULT_NO_DEVICES: Long = 27

    public final const val UPNP_RESULT_NO_GATEWAY: Long = 26

    public final const val UPNP_RESULT_NO_PORT_MAPS_AVAILABLE: Long = 11

    public final const val UPNP_RESULT_NO_SUCH_ENTRY_IN_ARRAY: Long = 4

    public final const val UPNP_RESULT_ONLY_PERMANENT_LEASE_SUPPORTED: Long = 15

    public final const val UPNP_RESULT_PORT_MAPPING_NOT_FOUND: Long = 2

    public final const val UPNP_RESULT_REMOTE_HOST_MUST_BE_WILDCARD: Long = 9

    public final const val UPNP_RESULT_SAME_PORT_VALUES_REQUIRED: Long = 14

    public final const val UPNP_RESULT_SOCKET_ERROR: Long = 24

    public final const val UPNP_RESULT_SRC_IP_WILDCARD_NOT_PERMITTED: Long = 6

    public final const val UPNP_RESULT_SUCCESS: Long = 0

    public final const val UPNP_RESULT_UNKNOWN_ERROR: Long = 28
  }
}
