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
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * StreamPeer is an abstract base class mostly used for stream-based protocols (such as TCP). It
 * provides an API for sending and receiving data through streams as raw data or strings.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class StreamPeer internal constructor() : RefCounted() {
  /**
   * If `true`, this [StreamPeer] will using big-endian format for encoding and decoding.
   */
  public final inline var bigEndian: Boolean
    @JvmName("bigEndianProperty")
    get() = isBigEndianEnabled()
    @JvmName("bigEndianProperty")
    set(`value`) {
      setBigEndian(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(707, scriptPtr)
  }

  /**
   * Sends a chunk of data through the connection, blocking if necessary until the data is done
   * sending. This function returns an [Error] code.
   */
  public final fun putData(`data`: PackedByteArray): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.putDataPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sends a chunk of data through the connection. If all the data could not be sent at once, only
   * part of it will. This function returns two values, an [Error] code and an integer, describing how
   * much data was actually sent.
   */
  public final fun putPartialData(`data`: PackedByteArray): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.putPartialDataPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns a chunk data with the received bytes, as an [VariantArray] containing two elements: an
   * [Error] constant and a [PackedByteArray]. [bytes] is the number of bytes to be received. If not
   * enough bytes are available, the function will block until the desired amount is received.
   */
  public final fun getData(bytes: Int): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bytes.toLong())
    TransferContext.callMethod(MethodBindings.getDataPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns a chunk data with the received bytes, as an [VariantArray] containing two elements: an
   * [Error] constant and a [PackedByteArray]. [bytes] is the number of bytes to be received. If not
   * enough bytes are available, the function will return how many were actually received.
   */
  public final fun getPartialData(bytes: Int): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bytes.toLong())
    TransferContext.callMethod(MethodBindings.getPartialDataPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns the number of bytes this [StreamPeer] has available.
   */
  public final fun getAvailableBytes(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAvailableBytesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setBigEndian(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setBigEndianPtr)
  }

  public final fun isBigEndianEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBigEndianEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Puts a signed byte into the stream.
   */
  public final fun put8(`value`: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.put8Ptr)
  }

  /**
   * Puts an unsigned byte into the stream.
   */
  public final fun putU8(`value`: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.putU8Ptr)
  }

  /**
   * Puts a signed 16-bit value into the stream.
   */
  public final fun put16(`value`: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.put16Ptr)
  }

  /**
   * Puts an unsigned 16-bit value into the stream.
   */
  public final fun putU16(`value`: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.putU16Ptr)
  }

  /**
   * Puts a signed 32-bit value into the stream.
   */
  public final fun put32(`value`: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.put32Ptr)
  }

  /**
   * Puts an unsigned 32-bit value into the stream.
   */
  public final fun putU32(`value`: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value)
    TransferContext.callMethod(MethodBindings.putU32Ptr)
  }

  /**
   * Puts a signed 64-bit value into the stream.
   */
  public final fun put64(`value`: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value)
    TransferContext.callMethod(MethodBindings.put64Ptr)
  }

  /**
   * Puts an unsigned 64-bit value into the stream.
   */
  public final fun putU64(`value`: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value)
    TransferContext.callMethod(MethodBindings.putU64Ptr)
  }

  /**
   * Puts a half-precision float into the stream.
   */
  public final fun putHalf(`value`: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.putHalfPtr)
  }

  /**
   * Puts a single-precision float into the stream.
   */
  public final fun putFloat(`value`: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.putFloatPtr)
  }

  /**
   * Puts a double-precision float into the stream.
   */
  public final fun putDouble(`value`: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value)
    TransferContext.callMethod(MethodBindings.putDoublePtr)
  }

  /**
   * Puts a zero-terminated ASCII string into the stream prepended by a 32-bit unsigned integer
   * representing its size.
   *
   * **Note:** To put an ASCII string without prepending its size, you can use [putData]:
   *
   * ```gdscript
   * //gdscript
   * put_data("Hello world".to_ascii_buffer())
   * ```
   *
   * ```csharp
   * //csharp
   * PutData("Hello World".ToAsciiBuffer());
   * ```
   */
  public final fun putString(`value`: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to value)
    TransferContext.callMethod(MethodBindings.putStringPtr)
  }

  /**
   * Puts a zero-terminated UTF-8 string into the stream prepended by a 32 bits unsigned integer
   * representing its size.
   *
   * **Note:** To put a UTF-8 string without prepending its size, you can use [putData]:
   *
   * ```gdscript
   * //gdscript
   * put_data("Hello world".to_utf8_buffer())
   * ```
   *
   * ```csharp
   * //csharp
   * PutData("Hello World".ToUtf8Buffer());
   * ```
   */
  public final fun putUtf8String(`value`: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to value)
    TransferContext.callMethod(MethodBindings.putUtf8StringPtr)
  }

  /**
   * Puts a Variant into the stream. If [fullObjects] is `true` encoding objects is allowed (and can
   * potentially include code).
   *
   * Internally, this uses the same encoding mechanism as the [@GlobalScope.varToBytes] method.
   */
  @JvmOverloads
  public final fun putVar(`value`: Any?, fullObjects: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to value, BOOL to fullObjects)
    TransferContext.callMethod(MethodBindings.putVarPtr)
  }

  /**
   * Gets a signed byte from the stream.
   */
  public final fun get8(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.get8Ptr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets an unsigned byte from the stream.
   */
  public final fun getU8(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getU8Ptr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets a signed 16-bit value from the stream.
   */
  public final fun get16(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.get16Ptr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets an unsigned 16-bit value from the stream.
   */
  public final fun getU16(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getU16Ptr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets a signed 32-bit value from the stream.
   */
  public final fun get32(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.get32Ptr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets an unsigned 32-bit value from the stream.
   */
  public final fun getU32(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getU32Ptr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Gets a signed 64-bit value from the stream.
   */
  public final fun get64(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.get64Ptr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Gets an unsigned 64-bit value from the stream.
   */
  public final fun getU64(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getU64Ptr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Gets a half-precision float from the stream.
   */
  public final fun getHalf(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHalfPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Gets a single-precision float from the stream.
   */
  public final fun getFloat(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFloatPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Gets a double-precision float from the stream.
   */
  public final fun getDouble(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDoublePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Gets an ASCII string with byte-length [bytes] from the stream. If [bytes] is negative (default)
   * the length will be read from the stream using the reverse process of [putString].
   */
  @JvmOverloads
  public final fun getString(bytes: Int = -1): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bytes.toLong())
    TransferContext.callMethod(MethodBindings.getStringPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Gets a UTF-8 string with byte-length [bytes] from the stream (this decodes the string sent as
   * UTF-8). If [bytes] is negative (default) the length will be read from the stream using the reverse
   * process of [putUtf8String].
   */
  @JvmOverloads
  public final fun getUtf8String(bytes: Int = -1): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bytes.toLong())
    TransferContext.callMethod(MethodBindings.getUtf8StringPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Gets a Variant from the stream. If [allowObjects] is `true`, decoding objects is allowed.
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

  public companion object {
    @JvmField
    public val putDataName: MethodStringName1<StreamPeer, Error, PackedByteArray> =
        MethodStringName1<StreamPeer, Error, PackedByteArray>("put_data")

    @JvmField
    public val putPartialDataName:
        MethodStringName1<StreamPeer, VariantArray<Any?>, PackedByteArray> =
        MethodStringName1<StreamPeer, VariantArray<Any?>, PackedByteArray>("put_partial_data")

    @JvmField
    public val getDataName: MethodStringName1<StreamPeer, VariantArray<Any?>, Int> =
        MethodStringName1<StreamPeer, VariantArray<Any?>, Int>("get_data")

    @JvmField
    public val getPartialDataName: MethodStringName1<StreamPeer, VariantArray<Any?>, Int> =
        MethodStringName1<StreamPeer, VariantArray<Any?>, Int>("get_partial_data")

    @JvmField
    public val getAvailableBytesName: MethodStringName0<StreamPeer, Int> =
        MethodStringName0<StreamPeer, Int>("get_available_bytes")

    @JvmField
    public val setBigEndianName: MethodStringName1<StreamPeer, Unit, Boolean> =
        MethodStringName1<StreamPeer, Unit, Boolean>("set_big_endian")

    @JvmField
    public val isBigEndianEnabledName: MethodStringName0<StreamPeer, Boolean> =
        MethodStringName0<StreamPeer, Boolean>("is_big_endian_enabled")

    @JvmField
    public val put8Name: MethodStringName1<StreamPeer, Unit, Int> =
        MethodStringName1<StreamPeer, Unit, Int>("put_8")

    @JvmField
    public val putU8Name: MethodStringName1<StreamPeer, Unit, Int> =
        MethodStringName1<StreamPeer, Unit, Int>("put_u8")

    @JvmField
    public val put16Name: MethodStringName1<StreamPeer, Unit, Int> =
        MethodStringName1<StreamPeer, Unit, Int>("put_16")

    @JvmField
    public val putU16Name: MethodStringName1<StreamPeer, Unit, Int> =
        MethodStringName1<StreamPeer, Unit, Int>("put_u16")

    @JvmField
    public val put32Name: MethodStringName1<StreamPeer, Unit, Int> =
        MethodStringName1<StreamPeer, Unit, Int>("put_32")

    @JvmField
    public val putU32Name: MethodStringName1<StreamPeer, Unit, Long> =
        MethodStringName1<StreamPeer, Unit, Long>("put_u32")

    @JvmField
    public val put64Name: MethodStringName1<StreamPeer, Unit, Long> =
        MethodStringName1<StreamPeer, Unit, Long>("put_64")

    @JvmField
    public val putU64Name: MethodStringName1<StreamPeer, Unit, Long> =
        MethodStringName1<StreamPeer, Unit, Long>("put_u64")

    @JvmField
    public val putHalfName: MethodStringName1<StreamPeer, Unit, Float> =
        MethodStringName1<StreamPeer, Unit, Float>("put_half")

    @JvmField
    public val putFloatName: MethodStringName1<StreamPeer, Unit, Float> =
        MethodStringName1<StreamPeer, Unit, Float>("put_float")

    @JvmField
    public val putDoubleName: MethodStringName1<StreamPeer, Unit, Double> =
        MethodStringName1<StreamPeer, Unit, Double>("put_double")

    @JvmField
    public val putStringName: MethodStringName1<StreamPeer, Unit, String> =
        MethodStringName1<StreamPeer, Unit, String>("put_string")

    @JvmField
    public val putUtf8StringName: MethodStringName1<StreamPeer, Unit, String> =
        MethodStringName1<StreamPeer, Unit, String>("put_utf8_string")

    @JvmField
    public val putVarName: MethodStringName2<StreamPeer, Unit, Any?, Boolean> =
        MethodStringName2<StreamPeer, Unit, Any?, Boolean>("put_var")

    @JvmField
    public val get8Name: MethodStringName0<StreamPeer, Int> =
        MethodStringName0<StreamPeer, Int>("get_8")

    @JvmField
    public val getU8Name: MethodStringName0<StreamPeer, Int> =
        MethodStringName0<StreamPeer, Int>("get_u8")

    @JvmField
    public val get16Name: MethodStringName0<StreamPeer, Int> =
        MethodStringName0<StreamPeer, Int>("get_16")

    @JvmField
    public val getU16Name: MethodStringName0<StreamPeer, Int> =
        MethodStringName0<StreamPeer, Int>("get_u16")

    @JvmField
    public val get32Name: MethodStringName0<StreamPeer, Int> =
        MethodStringName0<StreamPeer, Int>("get_32")

    @JvmField
    public val getU32Name: MethodStringName0<StreamPeer, Long> =
        MethodStringName0<StreamPeer, Long>("get_u32")

    @JvmField
    public val get64Name: MethodStringName0<StreamPeer, Long> =
        MethodStringName0<StreamPeer, Long>("get_64")

    @JvmField
    public val getU64Name: MethodStringName0<StreamPeer, Long> =
        MethodStringName0<StreamPeer, Long>("get_u64")

    @JvmField
    public val getHalfName: MethodStringName0<StreamPeer, Float> =
        MethodStringName0<StreamPeer, Float>("get_half")

    @JvmField
    public val getFloatName: MethodStringName0<StreamPeer, Float> =
        MethodStringName0<StreamPeer, Float>("get_float")

    @JvmField
    public val getDoubleName: MethodStringName0<StreamPeer, Double> =
        MethodStringName0<StreamPeer, Double>("get_double")

    @JvmField
    public val getStringName: MethodStringName1<StreamPeer, String, Int> =
        MethodStringName1<StreamPeer, String, Int>("get_string")

    @JvmField
    public val getUtf8StringName: MethodStringName1<StreamPeer, String, Int> =
        MethodStringName1<StreamPeer, String, Int>("get_utf8_string")

    @JvmField
    public val getVarName: MethodStringName1<StreamPeer, Any?, Boolean> =
        MethodStringName1<StreamPeer, Any?, Boolean>("get_var")
  }

  public object MethodBindings {
    internal val putDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_data", 680677267)

    internal val putPartialDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_partial_data", 2934048347)

    internal val getDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_data", 1171824711)

    internal val getPartialDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_partial_data", 1171824711)

    internal val getAvailableBytesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_available_bytes", 3905245786)

    internal val setBigEndianPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "set_big_endian", 2586408642)

    internal val isBigEndianEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "is_big_endian_enabled", 36873697)

    internal val put8Ptr: VoidPtr = TypeManager.getMethodBindPtr("StreamPeer", "put_8", 1286410249)

    internal val putU8Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_u8", 1286410249)

    internal val put16Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_16", 1286410249)

    internal val putU16Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_u16", 1286410249)

    internal val put32Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_32", 1286410249)

    internal val putU32Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_u32", 1286410249)

    internal val put64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_64", 1286410249)

    internal val putU64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_u64", 1286410249)

    internal val putHalfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_half", 373806689)

    internal val putFloatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_float", 373806689)

    internal val putDoublePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_double", 373806689)

    internal val putStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_string", 83702148)

    internal val putUtf8StringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_utf8_string", 83702148)

    internal val putVarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "put_var", 738511890)

    internal val get8Ptr: VoidPtr = TypeManager.getMethodBindPtr("StreamPeer", "get_8", 2455072627)

    internal val getU8Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_u8", 2455072627)

    internal val get16Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_16", 2455072627)

    internal val getU16Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_u16", 2455072627)

    internal val get32Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_32", 2455072627)

    internal val getU32Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_u32", 2455072627)

    internal val get64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_64", 2455072627)

    internal val getU64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_u64", 2455072627)

    internal val getHalfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_half", 191475506)

    internal val getFloatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_float", 191475506)

    internal val getDoublePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_double", 191475506)

    internal val getStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_string", 2309358862)

    internal val getUtf8StringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_utf8_string", 2309358862)

    internal val getVarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeer", "get_var", 3442865206)
  }
}
