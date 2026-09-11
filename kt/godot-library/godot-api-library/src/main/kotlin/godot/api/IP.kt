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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedStringArray
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * IP contains support functions for the Internet Protocol (IP). TCP/IP support is in different
 * classes (see [StreamPeerTCP] and [TCPServer]). IP provides DNS hostname resolution support, both
 * blocking and threaded.
 */
@GodotBaseType
public object IP : Object() {
  @JvmField
  public val resolveHostnameName: MethodStringName2<IP, String, String, Type> =
      MethodStringName2<IP, String, String, Type>("resolve_hostname")

  @JvmField
  public val resolveHostnameAddressesName: MethodStringName2<IP, PackedStringArray, String, Type> =
      MethodStringName2<IP, PackedStringArray, String, Type>("resolve_hostname_addresses")

  @JvmField
  public val resolveHostnameQueueItemName: MethodStringName2<IP, Int, String, Type> =
      MethodStringName2<IP, Int, String, Type>("resolve_hostname_queue_item")

  @JvmField
  public val getResolveItemStatusName: MethodStringName1<IP, ResolverStatus, Int> =
      MethodStringName1<IP, ResolverStatus, Int>("get_resolve_item_status")

  @JvmField
  public val getResolveItemAddressName: MethodStringName1<IP, String, Int> =
      MethodStringName1<IP, String, Int>("get_resolve_item_address")

  @JvmField
  public val getResolveItemAddressesName: MethodStringName1<IP, VariantArray<Any?>, Int> =
      MethodStringName1<IP, VariantArray<Any?>, Int>("get_resolve_item_addresses")

  @JvmField
  public val eraseResolveItemName: MethodStringName1<IP, Unit, Int> =
      MethodStringName1<IP, Unit, Int>("erase_resolve_item")

  @JvmField
  public val getLocalAddressesName: MethodStringName0<IP, PackedStringArray> =
      MethodStringName0<IP, PackedStringArray>("get_local_addresses")

  @JvmField
  public val getLocalInterfacesName: MethodStringName0<IP, VariantArray<Dictionary<Any?, Any?>>> =
      MethodStringName0<IP, VariantArray<Dictionary<Any?, Any?>>>("get_local_interfaces")

  @JvmField
  public val clearCacheName: MethodStringName1<IP, Unit, String> =
      MethodStringName1<IP, Unit, String>("clear_cache")

  /**
   * Maximum number of concurrent DNS resolver queries allowed, [RESOLVER_INVALID_ID] is returned if
   * exceeded.
   */
  public final const val RESOLVER_MAX_QUERIES: Long = 256

  /**
   * Invalid ID constant. Returned if [RESOLVER_MAX_QUERIES] is exceeded.
   */
  public final const val RESOLVER_INVALID_ID: Long = -1

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(10)
  }

  /**
   * Returns a given hostname's IPv4 or IPv6 address when resolved (blocking-type method). The
   * address type returned depends on the [Type] constant given as [ipType].
   */
  @JvmOverloads
  @JvmStatic
  public final fun resolveHostname(host: String, ipType: Type = IP.Type.ANY): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to host, LONG to ipType.value)
    TransferContext.callMethod(MethodBindings.resolveHostnamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Resolves a given hostname in a blocking way. Addresses are returned as an [VariantArray] of
   * IPv4 or IPv6 addresses depending on [ipType].
   */
  @JvmOverloads
  @JvmStatic
  public final fun resolveHostnameAddresses(host: String, ipType: Type = IP.Type.ANY):
      PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to host, LONG to ipType.value)
    TransferContext.callMethod(MethodBindings.resolveHostnameAddressesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Creates a queue item to resolve a hostname to an IPv4 or IPv6 address depending on the [Type]
   * constant given as [ipType]. Returns the queue ID if successful, or [RESOLVER_INVALID_ID] on error.
   */
  @JvmOverloads
  @JvmStatic
  public final fun resolveHostnameQueueItem(host: String, ipType: Type = IP.Type.ANY): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to host, LONG to ipType.value)
    TransferContext.callMethod(MethodBindings.resolveHostnameQueueItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns a queued hostname's status as a [ResolverStatus] constant, given its queue [id].
   */
  @JvmStatic
  public final fun getResolveItemStatus(id: Int): ResolverStatus {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getResolveItemStatusPtr)
    return ResolverStatus.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns a queued hostname's IP address, given its queue [id]. Returns an empty string on error
   * or if resolution hasn't happened yet (see [getResolveItemStatus]).
   */
  @JvmStatic
  public final fun getResolveItemAddress(id: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getResolveItemAddressPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns resolved addresses, or an empty array if an error happened or resolution didn't happen
   * yet (see [getResolveItemStatus]).
   */
  @JvmStatic
  public final fun getResolveItemAddresses(id: Int): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getResolveItemAddressesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Removes a given item [id] from the queue. This should be used to free a queue after it has
   * completed to enable more queries to happen.
   */
  @JvmStatic
  public final fun eraseResolveItem(id: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.eraseResolveItemPtr)
  }

  /**
   * Returns all the user's current IPv4 and IPv6 addresses as an array.
   */
  @JvmStatic
  public final fun getLocalAddresses(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalAddressesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns all network adapters as an array.
   *
   * Each adapter is a dictionary of the form:
   *
   * ```
   * {
   * 	"index": "1", # Interface index.
   * 	"name": "eth0", # Interface name.
   * 	"friendly": "Ethernet One", # A friendly name (might be empty).
   * 	"addresses": ["192.168.1.101"], # An array of IP addresses associated to this interface.
   * }
   * ```
   */
  @JvmStatic
  public final fun getLocalInterfaces(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalInterfacesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Removes all of a [hostname]'s cached references. If no [hostname] is given, all cached IP
   * addresses are removed.
   */
  @JvmOverloads
  @JvmStatic
  public final fun clearCache(hostname: String = ""): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to hostname)
    TransferContext.callMethod(MethodBindings.clearCachePtr)
  }

  public enum class ResolverStatus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * DNS hostname resolver status: No status.
     */
    NONE(0),
    /**
     * DNS hostname resolver status: Waiting.
     */
    WAITING(1),
    /**
     * DNS hostname resolver status: Done.
     */
    DONE(2),
    /**
     * DNS hostname resolver status: Error.
     */
    ERROR(3),
    ;

    public companion object {
      public fun from(`value`: Long): ResolverStatus = entries.single { it.`value` == `value` }
    }
  }

  public enum class Type(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Address type: None.
     */
    NONE(0),
    /**
     * Address type: Internet protocol version 4 (IPv4).
     */
    IPV4(1),
    /**
     * Address type: Internet protocol version 6 (IPv6).
     */
    IPV6(2),
    /**
     * Address type: Any.
     */
    ANY(3),
    ;

    public companion object {
      public fun from(`value`: Long): Type = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val resolveHostnamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "resolve_hostname", 4283295457)

    internal val resolveHostnameAddressesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "resolve_hostname_addresses", 773767525)

    internal val resolveHostnameQueueItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "resolve_hostname_queue_item", 1749894742)

    internal val getResolveItemStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "get_resolve_item_status", 3812250196)

    internal val getResolveItemAddressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "get_resolve_item_address", 844755477)

    internal val getResolveItemAddressesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "get_resolve_item_addresses", 663333327)

    internal val eraseResolveItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "erase_resolve_item", 1286410249)

    internal val getLocalAddressesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "get_local_addresses", 1139954409)

    internal val getLocalInterfacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "get_local_interfaces", 3995934104)

    internal val clearCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("IP", "clear_cache", 3005725572)
  }
}
