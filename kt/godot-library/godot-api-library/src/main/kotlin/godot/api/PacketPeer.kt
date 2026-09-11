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
import godot.core.PackedByteArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * PacketPeer is an abstraction and base class for packet-based protocols (such as UDP). It provides
 * an API for sending and receiving packets both as raw data or variables. This makes it easy to
 * transfer data over a protocol, without having to encode data as low-level bytes or having to worry
 * about network ordering.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class PacketPeer internal constructor() : RefCounted() {
  /**
   * Maximum buffer size allowed when encoding [Any]s. Raise this value to support heavier memory
   * allocations.
   *
   * The [putVar] method allocates memory on the stack, and the buffer used will grow automatically
   * to the closest power of two to match the size of the [Any]. If the [Any] is bigger than
   * [encodeBufferMaxSize], the method will error out with [ERR_OUT_OF_MEMORY].
   */
  public final inline var encodeBufferMaxSize: Int
    @JvmName("encodeBufferMaxSizeProperty")
    get() = getEncodeBufferMaxSize()
    @JvmName("encodeBufferMaxSizeProperty")
    set(`value`) {
      setEncodeBufferMaxSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(503, scriptPtr)
  }

  /**
   * Gets a Variant. If [allowObjects] is `true`, decoding objects is allowed.
   *
   * Internally, this uses the same decoding mechanism as the [@GlobalScope.bytesToVar] method.
   *
   * **Warning:** Deserialized objects can contain code which gets executed. Do not use this option
   * if the serialized object comes from untrusted sources to avoid potential security threats such as
   * remote code execution.
   */
  @JvmOverloads
  public final fun getVar(allowObjects: Boolean = false): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to allowObjects)
    TransferContext.callMethod(MethodBindings.getVarPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sends a [Any] as a packet. If [fullObjects] is `true`, encoding objects is allowed (and can
   * potentially include code).
   *
   * Internally, this uses the same encoding mechanism as the [@GlobalScope.varToBytes] method.
   */
  @JvmOverloads
  public final fun putVar(`var`: Any?, fullObjects: Boolean = false): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to `var`, BOOL to fullObjects)
    TransferContext.callMethod(MethodBindings.putVarPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Gets a raw packet.
   */
  public final fun getPacket(): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPacketPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Sends a raw packet.
   */
  public final fun putPacket(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to buffer)
    TransferContext.callMethod(MethodBindings.putPacketPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the error state of the last packet received (via [getPacket] and [getVar]).
   */
  public final fun getPacketError(): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPacketErrorPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the number of packets currently available in the ring-buffer.
   */
  public final fun getAvailablePacketCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAvailablePacketCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun getEncodeBufferMaxSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEncodeBufferMaxSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setEncodeBufferMaxSize(maxSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxSize.toLong())
    TransferContext.callMethod(MethodBindings.setEncodeBufferMaxSizePtr)
  }

  public companion object {
    @JvmField
    public val getVarName: MethodStringName1<PacketPeer, Any?, Boolean> =
        MethodStringName1<PacketPeer, Any?, Boolean>("get_var")

    @JvmField
    public val putVarName: MethodStringName2<PacketPeer, Error, Any?, Boolean> =
        MethodStringName2<PacketPeer, Error, Any?, Boolean>("put_var")

    @JvmField
    public val getPacketName: MethodStringName0<PacketPeer, PackedByteArray> =
        MethodStringName0<PacketPeer, PackedByteArray>("get_packet")

    @JvmField
    public val putPacketName: MethodStringName1<PacketPeer, Error, PackedByteArray> =
        MethodStringName1<PacketPeer, Error, PackedByteArray>("put_packet")

    @JvmField
    public val getPacketErrorName: MethodStringName0<PacketPeer, Error> =
        MethodStringName0<PacketPeer, Error>("get_packet_error")

    @JvmField
    public val getAvailablePacketCountName: MethodStringName0<PacketPeer, Int> =
        MethodStringName0<PacketPeer, Int>("get_available_packet_count")

    @JvmField
    public val getEncodeBufferMaxSizeName: MethodStringName0<PacketPeer, Int> =
        MethodStringName0<PacketPeer, Int>("get_encode_buffer_max_size")

    @JvmField
    public val setEncodeBufferMaxSizeName: MethodStringName1<PacketPeer, Unit, Int> =
        MethodStringName1<PacketPeer, Unit, Int>("set_encode_buffer_max_size")
  }

  public object MethodBindings {
    internal val getVarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeer", "get_var", 3442865206)

    internal val putVarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeer", "put_var", 2436251611)

    internal val getPacketPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeer", "get_packet", 2115431945)

    internal val putPacketPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeer", "put_packet", 680677267)

    internal val getPacketErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeer", "get_packet_error", 3185525595)

    internal val getAvailablePacketCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeer", "get_available_packet_count", 3905245786)

    internal val getEncodeBufferMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeer", "get_encode_buffer_max_size", 3905245786)

    internal val setEncodeBufferMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeer", "set_encode_buffer_max_size", 1286410249)
  }
}
