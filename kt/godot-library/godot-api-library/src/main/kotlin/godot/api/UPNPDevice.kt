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
import godot.core.MethodStringName5
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG_STRING_STRING_LONG
import godot.writeMethodArguments_LONG_STRING
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
 * Universal Plug and Play (UPnP) device. See [UPNP] for UPnP discovery and utility functions.
 * Provides low-level access to UPNP control commands. Allows to manage port mappings (port forwarding)
 * and to query network information of the device (like local and external IP address and status). Note
 * that methods on this class are synchronous and block the calling thread.
 */
@GodotBaseType
public open class UPNPDevice : RefCounted() {
  /**
   * URL to the device description.
   */
  public final inline var descriptionUrl: String
    @JvmName("descriptionUrlProperty")
    get() = getDescriptionUrl()
    @JvmName("descriptionUrlProperty")
    set(`value`) {
      setDescriptionUrl(value)
    }

  /**
   * Service type.
   */
  public final inline var serviceType: String
    @JvmName("serviceTypeProperty")
    get() = getServiceType()
    @JvmName("serviceTypeProperty")
    set(`value`) {
      setServiceType(value)
    }

  /**
   * IDG control URL.
   */
  public final inline var igdControlUrl: String
    @JvmName("igdControlUrlProperty")
    get() = getIgdControlUrl()
    @JvmName("igdControlUrlProperty")
    set(`value`) {
      setIgdControlUrl(value)
    }

  /**
   * IGD service type.
   */
  public final inline var igdServiceType: String
    @JvmName("igdServiceTypeProperty")
    get() = getIgdServiceType()
    @JvmName("igdServiceTypeProperty")
    set(`value`) {
      setIgdServiceType(value)
    }

  /**
   * Address of the local machine in the network connecting it to this [UPNPDevice].
   */
  public final inline var igdOurAddr: String
    @JvmName("igdOurAddrProperty")
    get() = getIgdOurAddr()
    @JvmName("igdOurAddrProperty")
    set(`value`) {
      setIgdOurAddr(value)
    }

  /**
   * IGD status.
   */
  public final inline var igdStatus: IGDStatus
    @JvmName("igdStatusProperty")
    get() = getIgdStatus()
    @JvmName("igdStatusProperty")
    set(`value`) {
      setIgdStatus(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(781, scriptPtr)
  }

  /**
   * Returns `true` if this is a valid IGD (InternetGatewayDevice) which potentially supports port
   * forwarding.
   */
  public final fun isValidGateway(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isValidGatewayPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the external IP address of this [UPNPDevice] or an empty string.
   */
  public final fun queryExternalAddress(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.queryExternalAddressPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Adds a port mapping to forward the given external port on this [UPNPDevice] for the given
   * protocol to the local machine. See [UPNP.addPortMapping].
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
   * Deletes the port mapping identified by the given port and protocol combination on this device.
   * See [UPNP.deletePortMapping].
   */
  @JvmOverloads
  public final fun deletePortMapping(port: Int, proto: String = "UDP"): Int {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, port.toLong(), proto)
    TransferContext.callMethod(MethodBindings.deletePortMappingPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setDescriptionUrl(url: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, url)
    TransferContext.callMethod(MethodBindings.setDescriptionUrlPtr)
  }

  public final fun getDescriptionUrl(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDescriptionUrlPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setServiceType(type: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, type)
    TransferContext.callMethod(MethodBindings.setServiceTypePtr)
  }

  public final fun getServiceType(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getServiceTypePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setIgdControlUrl(url: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, url)
    TransferContext.callMethod(MethodBindings.setIgdControlUrlPtr)
  }

  public final fun getIgdControlUrl(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIgdControlUrlPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setIgdServiceType(type: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, type)
    TransferContext.callMethod(MethodBindings.setIgdServiceTypePtr)
  }

  public final fun getIgdServiceType(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIgdServiceTypePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setIgdOurAddr(addr: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, addr)
    TransferContext.callMethod(MethodBindings.setIgdOurAddrPtr)
  }

  public final fun getIgdOurAddr(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIgdOurAddrPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setIgdStatus(status: IGDStatus): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, status.value)
    TransferContext.callPtrMethod(MethodBindings.setIgdStatusPtr, 0)
  }

  public final fun getIgdStatus(): IGDStatus {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIgdStatusPtr, 2)
    return IGDStatus.from(TransferContext.readReturnValue_LONG())
  }

  public enum class IGDStatus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * OK.
     */
    OK(0),
    /**
     * HTTP error.
     */
    HTTP_ERROR(1),
    /**
     * Empty HTTP response.
     */
    HTTP_EMPTY(2),
    /**
     * Returned response contained no URLs.
     */
    NO_URLS(3),
    /**
     * Not a valid IGD.
     */
    NO_IGD(4),
    /**
     * Disconnected.
     */
    DISCONNECTED(5),
    /**
     * Unknown device.
     */
    UNKNOWN_DEVICE(6),
    /**
     * Invalid control.
     */
    INVALID_CONTROL(7),
    /**
     * Memory allocation error.
     */
    MALLOC_ERROR(8),
    /**
     * Unknown error.
     */
    UNKNOWN_ERROR(9),
    ;

    public companion object {
      public fun from(`value`: Long): IGDStatus = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val isValidGatewayName: MethodStringName0<UPNPDevice, Boolean> =
        MethodStringName0<UPNPDevice, Boolean>("is_valid_gateway")

    @JvmField
    public val queryExternalAddressName: MethodStringName0<UPNPDevice, String> =
        MethodStringName0<UPNPDevice, String>("query_external_address")

    @JvmField
    public val addPortMappingName: MethodStringName5<UPNPDevice, Int, Int, Int, String, String, Int>
        = MethodStringName5<UPNPDevice, Int, Int, Int, String, String, Int>("add_port_mapping")

    @JvmField
    public val deletePortMappingName: MethodStringName2<UPNPDevice, Int, Int, String> =
        MethodStringName2<UPNPDevice, Int, Int, String>("delete_port_mapping")

    @JvmField
    public val setDescriptionUrlName: MethodStringName1<UPNPDevice, Unit, String> =
        MethodStringName1<UPNPDevice, Unit, String>("set_description_url")

    @JvmField
    public val getDescriptionUrlName: MethodStringName0<UPNPDevice, String> =
        MethodStringName0<UPNPDevice, String>("get_description_url")

    @JvmField
    public val setServiceTypeName: MethodStringName1<UPNPDevice, Unit, String> =
        MethodStringName1<UPNPDevice, Unit, String>("set_service_type")

    @JvmField
    public val getServiceTypeName: MethodStringName0<UPNPDevice, String> =
        MethodStringName0<UPNPDevice, String>("get_service_type")

    @JvmField
    public val setIgdControlUrlName: MethodStringName1<UPNPDevice, Unit, String> =
        MethodStringName1<UPNPDevice, Unit, String>("set_igd_control_url")

    @JvmField
    public val getIgdControlUrlName: MethodStringName0<UPNPDevice, String> =
        MethodStringName0<UPNPDevice, String>("get_igd_control_url")

    @JvmField
    public val setIgdServiceTypeName: MethodStringName1<UPNPDevice, Unit, String> =
        MethodStringName1<UPNPDevice, Unit, String>("set_igd_service_type")

    @JvmField
    public val getIgdServiceTypeName: MethodStringName0<UPNPDevice, String> =
        MethodStringName0<UPNPDevice, String>("get_igd_service_type")

    @JvmField
    public val setIgdOurAddrName: MethodStringName1<UPNPDevice, Unit, String> =
        MethodStringName1<UPNPDevice, Unit, String>("set_igd_our_addr")

    @JvmField
    public val getIgdOurAddrName: MethodStringName0<UPNPDevice, String> =
        MethodStringName0<UPNPDevice, String>("get_igd_our_addr")

    @JvmField
    public val setIgdStatusName: MethodStringName1<UPNPDevice, Unit, IGDStatus> =
        MethodStringName1<UPNPDevice, Unit, IGDStatus>("set_igd_status")

    @JvmField
    public val getIgdStatusName: MethodStringName0<UPNPDevice, IGDStatus> =
        MethodStringName0<UPNPDevice, IGDStatus>("get_igd_status")
  }

  public object MethodBindings {
    internal val isValidGatewayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "is_valid_gateway", 36873697)

    internal val queryExternalAddressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "query_external_address", 201670096)

    internal val addPortMappingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "add_port_mapping", 818314583)

    internal val deletePortMappingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "delete_port_mapping", 3444187325)

    internal val setDescriptionUrlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "set_description_url", 83702148)

    internal val getDescriptionUrlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "get_description_url", 201670096)

    internal val setServiceTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "set_service_type", 83702148)

    internal val getServiceTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "get_service_type", 201670096)

    internal val setIgdControlUrlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "set_igd_control_url", 83702148)

    internal val getIgdControlUrlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "get_igd_control_url", 201670096)

    internal val setIgdServiceTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "set_igd_service_type", 83702148)

    internal val getIgdServiceTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "get_igd_service_type", 201670096)

    internal val setIgdOurAddrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "set_igd_our_addr", 83702148)

    internal val getIgdOurAddrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "get_igd_our_addr", 201670096)

    internal val setIgdStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "set_igd_status", 519504122)

    internal val getIgdStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("UPNPDevice", "get_igd_status", 180887011)
  }
}
