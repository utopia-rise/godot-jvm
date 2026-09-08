@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.common.interop.VoidPtr
import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PackedByteArray : PackedArray<PackedByteArray, Byte> {

    override val bridge = Bridge

    enum class CompressionMode {
        /**
         * Uses the FastLZ compression method.
         */
        COMPRESSION_FASTLZ,

        /**
         * Uses the DEFLATE compression method.
         */
        COMPRESSION_DEFLATE,

        /**
         * Uses the Zstandard compression method.
         */
        COMPRESSION_ZSTD,

        /**
         * Uses the gzip compression method.
         */
        COMPRESSION_GZIP
    }

    //INTERNALS
    internal constructor(handle: VoidPtr) {
        this.ptr = handle
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_BYTE_ARRAY)
    }

    //CONSTRUCTOR
    /**
     * Constructs an empty PackedByteArray.
     */
    constructor() {
        ptr = Bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_BYTE_ARRAY)
    }

    /**
     * Constructs a PackedByteArray as a copy of the given PackedByteArray.
     */
    constructor(from: PackedByteArray) {
        TransferContext.writeArguments(VariantParser.PACKED_BYTE_ARRAY to from)
        ptr = Bridge.engine_call_constructor_packed_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_BYTE_ARRAY)
    }

    /**
     * Constructs a new PackedByteArray by converting a `VariantArray<Byte>`.
     */
    constructor(from: VariantArray<Byte>) {
        TransferContext.writeArguments(VariantParser.ARRAY to from)
        ptr = Bridge.engine_call_constructor_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_BYTE_ARRAY)
    }

    /**
     * Constructs a new [PackedByteArray] from an existing Kotlin [ByteArray] or Java byte[].
     */
    constructor(from: ByteArray) {
        ptr = Bridge.engine_convert_to_godot(from)
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_BYTE_ARRAY)
    }

    /**
     * Constructs a new [PackedByteArray] from an existing Kotlin [Array<Byte>].
     */
    constructor(from: Array<Byte>) : this(from.toByteArray())

    /**
     * Constructs a new [PackedByteArray] from an existing Kotlin [Collection<Byte>].
     */
    constructor(from: Collection<Byte>) : this(from.toByteArray())

    //PACKED BYTE ARRAY API
    /**
     * Returns a new PoolByteArray with the data compressed.
     * Set the compression mode using one of [CompressionMode]'s constants.
     */
    @JvmOverloads
    fun compress(compressionMode: CompressionMode = CompressionMode.COMPRESSION_FASTLZ): PackedByteArray {
        TransferContext.writeArguments(VariantCaster.INT to compressionMode.ordinal)
        Bridge.engine_call_compress(ptr)
        return TransferContext.readReturnValue(VariantParser.PACKED_BYTE_ARRAY) as PackedByteArray
    }

    /**
     * Decodes a 64-bit floating point number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0.0 if a valid number can't be decoded.
     */
    fun decodeDouble(byteOffset: Int): Double {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_double(ptr)
        return TransferContext.readReturnValue(VariantParser.DOUBLE) as Double
    }

    /**
     * Decodes a 32-bit floating point number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0.0 if a valid number can't be decoded.
     */
    fun decodeFloat(byteOffset: Int): Float {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_float(ptr)
        return TransferContext.readReturnValue(VariantCaster.FLOAT) as Float
    }

    /**
     * Decodes a 16-bit floating point number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0.0 if a valid number can't be decoded.
     */
    fun decodeHalf(byteOffset: Int): Float {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_half(ptr)
        return TransferContext.readReturnValue(VariantCaster.FLOAT) as Float
    }

    /**
     * Decodes a 16-bit signed integer number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0 if a valid number can't be decoded.
     */
    fun decodeS16(byteOffset: Int): Int {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_s16(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Decodes a 32-bit signed integer number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0 if a valid number can't be decoded.
     */
    fun decodeS32(byteOffset: Int): Int {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_s32(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Decodes a 64-bit signed integer number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0 if a valid number can't be decoded.
     */
    fun decodeS64(byteOffset: Int): Long {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_s64(ptr)
        return TransferContext.readReturnValue(VariantParser.LONG) as Long
    }

    /**
     * Decodes an 8-bit signed integer number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0 if a valid number can't be decoded.
     */
    fun decodeS8(byteOffset: Int): Int {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_s8(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Decodes a 16-bit unsigned integer number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0 if a valid number can't be decoded.
     */
    fun decodeU16(byteOffset: Int): Int {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_u16(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Decodes a 32-bit unsigned integer number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0 if a valid number can't be decoded.
     */
    fun decodeU32(byteOffset: Int): Int {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_u32(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Decodes a 64-bit unsigned integer number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0 if a valid number can't be decoded.
     */
    fun decodeU64(byteOffset: Int): Long {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_u64(ptr)
        return TransferContext.readReturnValue(VariantParser.LONG) as Long
    }

    /**
     * Decodes an 8-bit unsigned integer number from the bytes starting at byte_offset. Fails if the byte count is
     * insufficient. Returns 0 if a valid number can't be decoded.
     */
    fun decodeU8(byteOffset: Int): Int {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset)
        Bridge.engine_call_decode_u8(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Decodes a Variant from the bytes starting at byte_offset. Returns null if a valid variant can't be decoded or the
     * value is Object-derived and allow_objects is false.
     */
    fun decodeVar(byteOffset: Int, allowObjects: Boolean = false): Any {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantParser.BOOL to allowObjects)
        Bridge.engine_call_decode_var(ptr)
        return TransferContext.readReturnValue(VariantCaster.ANY) as Any
    }

    /**
     * Decodes a size of a Variant from the bytes starting at byte_offset. Requires at least 4 bytes of data starting at
     * the offset, otherwise fails.
     */
    fun decodeVarSize(byteOffset: Int, allowObjects: Boolean = false): Int {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantParser.BOOL to allowObjects)
        Bridge.engine_call_decode_var_size(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Returns a new PoolByteArray with the data decompressed.
     * Set buffer_size to the size of the uncompressed data.
     * Set the compression mode using one of CompressionMode's constants.
     */
    @JvmOverloads
    fun decompress(
        bufferSize: Int,
        compressionMode: CompressionMode = CompressionMode.COMPRESSION_FASTLZ
    ): PackedByteArray {
        TransferContext.writeArguments(
            VariantCaster.INT to bufferSize,
            VariantCaster.INT to compressionMode.ordinal
        )
        Bridge.engine_call_decompress(ptr)
        return TransferContext.readReturnValue(VariantParser.PACKED_BYTE_ARRAY) as PackedByteArray
    }

    /**
     * Returns a new PackedByteArray with the data decompressed. Set the compression mode using one of CompressionMode's constants. This method only accepts gzip and deflate compression modes.
     *
     * This method is potentially slower than decompress, as it may have to re-allocate its output buffer multiple times while decompressing, whereas decompress knows it's output buffer size from the beginning.
     *
     * GZIP has a maximal compression ratio of 1032:1, meaning it's very possible for a small compressed payload to decompress to a potentially very large output. To guard against this, you may provide a maximum size this function is allowed to allocate in bytes via max_output_size. Passing -1 will allow for unbounded output. If any positive value is passed, and the decompression exceeds that amount in bytes, then an error will be returned.
     */
    fun decompressDynamic(
        maxOutputSize: Int,
        compressionMode: CompressionMode = CompressionMode.COMPRESSION_FASTLZ
    ): PackedByteArray {
        TransferContext.writeArguments(
            VariantCaster.INT to maxOutputSize,
            VariantCaster.INT to compressionMode.ordinal
        )
        Bridge.engine_call_decompress_dynamic(ptr)
        return TransferContext.readReturnValue(VariantParser.PACKED_BYTE_ARRAY) as PackedByteArray
    }

    /**
     * Encodes a 64-bit floating point number as bytes at the index of byte_offset bytes. The array must have at least 8
     * bytes of allocated space, starting at the offset.
     */
    fun encodeDouble(byteOffset: Int, value: Double) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantParser.DOUBLE to value)
        Bridge.engine_call_encode_double(ptr)
    }

    /**
     * Encodes a 32-bit floating point number as bytes at the index of byte_offset bytes. The array must have at least 4
     * bytes of space, starting at the offset.
     */
    fun encodeFloat(byteOffset: Int, value: Float) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantCaster.FLOAT to value)
        Bridge.engine_call_encode_float(ptr)
    }

    /**
     * Encodes a 16-bit floating point number as bytes at the index of byte_offset bytes. The array must have at least 2
     * bytes of space, starting at the offset.
     */
    fun encodeHalf(byteOffset: Int, value: Float) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantCaster.FLOAT to value)
        Bridge.engine_call_encode_half(ptr)
    }

    /**
     * Encodes a 16-bit signed integer number as bytes at the index of byte_offset bytes. The array must have at least 2
     * bytes of space, starting at the offset.
     */
    fun encodeS16(byteOffset: Int, value: Int) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantCaster.INT to value)
        Bridge.engine_call_encode_s16(ptr)
    }

    /**
     * Encodes a 32-bit signed integer number as bytes at the index of byte_offset bytes. The array must have at least 4
     * bytes of space, starting at the offset.
     */
    fun encodeS32(byteOffset: Int, value: Int) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantCaster.INT to value)
        Bridge.engine_call_encode_s32(ptr)
    }

    /**
     * Encodes a 64-bit signed integer number as bytes at the index of byte_offset bytes. The array must have at least 8
     * bytes of space, starting at the offset.
     */
    fun encodeS64(byteOffset: Int, value: Long) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantParser.LONG to value)
        Bridge.engine_call_encode_s64(ptr)
    }

    /**
     * Encodes an 8-bit signed integer number (signed byte) at the index of byte_offset bytes. The array must have at
     * least 1 byte of space, starting at the offset.
     */
    fun encodeS8(byteOffset: Int, value: Int) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantCaster.INT to value)
        Bridge.engine_call_encode_s8(ptr)
    }

    /**
     * Encodes a 16-bit unsigned integer number as bytes at the index of byte_offset bytes. The array must have at least
     * 2 bytes of space, starting at the offset.
     */
    fun encodeU16(byteOffset: Int, value: Int) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantCaster.INT to value)
        Bridge.engine_call_encode_u16(ptr)
    }

    /**
     * Encodes a 32-bit unsigned integer number as bytes at the index of byte_offset bytes. The array must have at least
     * 4 bytes of space, starting at the offset.
     */
    fun encodeU32(byteOffset: Int, value: Int) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantCaster.INT to value)
        Bridge.engine_call_encode_u32(ptr)
    }

    /**
     * Encodes a 64-bit unsigned integer number as bytes at the index of byte_offset bytes. The array must have at least
     * 8 bytes of space, starting at the offset.
     */
    fun encodeU64(byteOffset: Int, value: Long) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantParser.LONG to value)
        Bridge.engine_call_encode_u64(ptr)
    }

    /**
     * Encodes an 8-bit unsigned integer number (byte) at the index of byte_offset bytes. The array must have at least 1
     * byte of space, starting at the offset.
     */
    fun encodeU8(byteOffset: Int, value: Int) {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantCaster.INT to value)
        Bridge.engine_call_encode_u8(ptr)
    }

    /**
     * Encodes a Variant at the index of byte_offset bytes. A sufficient space must be allocated, depending on the
     * encoded variant's size. If allow_objects is false, Object-derived values are not permitted and will instead be
     * serialized as ID-only.
     */
    fun encodeVar(byteOffset: Int, value: Any, allowObjects: Boolean = false) {
        TransferContext.writeArguments(
            VariantCaster.INT to byteOffset,
            VariantCaster.ANY to value,
            VariantParser.BOOL to allowObjects
        )
        Bridge.engine_call_encode_var(ptr)
    }

    /**
     * Returns a copy of the array's contents as String.
     * Fast alternative to get_string_from_utf8 if the content is ASCII-only.
     * Unlike the UTF-8 function this function maps every byte to a character in the array.
     * Multibyte sequences will not be interpreted correctly.
     * For parsing user input always use get_string_from_utf8.
     */
    fun getStringFromAscii(): String {
        Bridge.engine_call_get_string_from_ascii(ptr)
        return TransferContext.readReturnValue(VariantParser.STRING) as String
    }

    /**
     * Converts UTF-16 encoded array to [String]. If the BOM is missing, system endianness is assumed. Returns empty
     * string if source array is not valid UTF-16 string.
     */
    fun getStringFromUtf16(): String {
        Bridge.engine_call_get_string_from_utf16(ptr)
        return TransferContext.readReturnValue(VariantParser.STRING) as String
    }

    /**
     * Converts UTF-32 encoded array to [String]. System endianness is assumed. Returns empty string if source array is
     * not valid UTF-32 string.
     */
    fun getStringFromUtf32(): String {
        Bridge.engine_call_get_string_from_utf32(ptr)
        return TransferContext.readReturnValue(VariantParser.STRING) as String
    }

    /**
     * Converts wide character (wchar_t, UTF-16 on Windows, UTF-32 on other platforms) encoded array to String.
     * Returns empty string if source array is not valid wide string.
     */
    fun getStringFromWchar(): String {
        Bridge.engine_call_get_string_from_wchar(ptr)
        return TransferContext.readReturnValue(VariantParser.STRING) as String
    }

    /**
     * Returns a copy of the array's contents as String.
     * Slower than get_string_from_ascii but supports UTF-8 encoded data.
     * Use this function if you are unsure about the source of the data.
     * For user input this function should always be preferred.
     */
    fun getStringFromUtf8(): String {
        Bridge.engine_call_get_string_from_utf8(ptr)
        return TransferContext.readReturnValue(VariantParser.STRING) as String
    }

    fun hasEncodedVar(byteOffset: Int, allowObjects: Boolean = false): Boolean {
        TransferContext.writeArguments(VariantCaster.INT to byteOffset, VariantParser.BOOL to allowObjects)
        Bridge.engine_call_has_encoded_var(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Returns a hexadecimal representation of this array as a String.
     */
    fun hexEncode(): String {
        Bridge.engine_call_hex_encode(ptr)
        return TransferContext.readReturnValue(VariantParser.STRING) as String
    }

    fun toPackedFloat32Array(): PackedFloat32Array {
        Bridge.engine_call_to_float32_array(ptr)
        return TransferContext.readReturnValue(VariantParser.PACKED_FLOAT_32_ARRAY) as PackedFloat32Array
    }
    fun toPackedFloat64Array(): PackedFloat64Array {
        Bridge.engine_call_to_float64_array(ptr)
        return TransferContext.readReturnValue(VariantParser.PACKED_FLOAT_64_ARRAY) as PackedFloat64Array
    }
    fun toPackedInt32Array(): PackedInt32Array {
        Bridge.engine_call_to_int32_array(ptr)
        return TransferContext.readReturnValue(VariantParser.PACKED_INT_32_ARRAY) as PackedInt32Array
    }
    fun toPackedInt64Array(): PackedInt64Array {
        Bridge.engine_call_to_int64_array(ptr)
        return TransferContext.readReturnValue(VariantParser.PACKED_INT_64_ARRAY) as PackedInt64Array
    }

    //UTILITIES
    override fun toString(): String {
        return "PackedByteArray(${size})"
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PackedByteArray) {
            val list1 = this.toList()
            val list2 = other.toList()
            list1 == list2
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return ptr.hashCode()
    }

    fun toByteArray(): ByteArray = Bridge.engine_convert_to_jvm(ptr)

    @Suppress("FunctionName", "LocalVariableName")
    internal object Bridge : PackedArrayBridge {
        override val packedArrayVariantType = VariantParser.PACKED_BYTE_ARRAY
        override val elementVariantType = VariantCaster.BYTE

        external override fun engine_call_constructor(): VoidPtr
        external override fun engine_call_constructor_packed_array(): VoidPtr
        external override fun engine_call_constructor_array(): VoidPtr

        external override fun engine_call_append(_handle: VoidPtr)
        external override fun engine_call_appendArray(_handle: VoidPtr)
        external override fun engine_call_bsearch(_handle: VoidPtr)
        external override fun engine_call_clear(_handle: VoidPtr)
        external fun engine_call_compress(_handle: VoidPtr)
        external override fun engine_call_count(_handle: VoidPtr)
        external fun engine_call_decode_double(_handle: VoidPtr)
        external fun engine_call_decode_float(_handle: VoidPtr)
        external fun engine_call_decode_half(_handle: VoidPtr)
        external fun engine_call_decode_s16(_handle: VoidPtr)
        external fun engine_call_decode_s32(_handle: VoidPtr)
        external fun engine_call_decode_s64(_handle: VoidPtr)
        external fun engine_call_decode_s8(_handle: VoidPtr)
        external fun engine_call_decode_u16(_handle: VoidPtr)
        external fun engine_call_decode_u32(_handle: VoidPtr)
        external fun engine_call_decode_u64(_handle: VoidPtr)
        external fun engine_call_decode_u8(_handle: VoidPtr)
        external fun engine_call_decode_var(_handle: VoidPtr)
        external fun engine_call_decode_var_size(_handle: VoidPtr)
        external fun engine_call_decompress(_handle: VoidPtr)
        external fun engine_call_decompress_dynamic(_handle: VoidPtr)
        external override fun engine_call_duplicate(_handle: VoidPtr)
        external fun engine_call_encode_double(_handle: VoidPtr)
        external fun engine_call_encode_float(_handle: VoidPtr)
        external fun engine_call_encode_half(_handle: VoidPtr)
        external fun engine_call_encode_s16(_handle: VoidPtr)
        external fun engine_call_encode_s32(_handle: VoidPtr)
        external fun engine_call_encode_s64(_handle: VoidPtr)
        external fun engine_call_encode_s8(_handle: VoidPtr)
        external fun engine_call_encode_u16(_handle: VoidPtr)
        external fun engine_call_encode_u32(_handle: VoidPtr)
        external fun engine_call_encode_u64(_handle: VoidPtr)
        external fun engine_call_encode_u8(_handle: VoidPtr)
        external fun engine_call_encode_var(_handle: VoidPtr)
        external override fun engine_call_fill(_handle: VoidPtr)
        external override fun engine_call_find(_handle: VoidPtr)
        external fun engine_call_get_string_from_ascii(_handle: VoidPtr)
        external fun engine_call_get_string_from_utf16(_handle: VoidPtr)
        external fun engine_call_get_string_from_utf32(_handle: VoidPtr)
        external fun engine_call_get_string_from_wchar(_handle: VoidPtr)
        external fun engine_call_get_string_from_utf8(_handle: VoidPtr)
        external override fun engine_call_has(_handle: VoidPtr)
        external fun engine_call_has_encoded_var(_handle: VoidPtr)
        external fun engine_call_hex_encode(_handle: VoidPtr)
        external override fun engine_call_get(_handle: VoidPtr)
        external override fun engine_call_insert(_handle: VoidPtr)
        external override fun engine_call_is_empty(_handle: VoidPtr)
        external override fun engine_call_reverse(_handle: VoidPtr)
        external override fun engine_call_rfind(_handle: VoidPtr)
        external override fun engine_call_pushback(_handle: VoidPtr)
        external override fun engine_call_remove_at(_handle: VoidPtr)
        external override fun engine_call_resize(_handle: VoidPtr)
        external override fun engine_call_set(_handle: VoidPtr)
        external override fun engine_call_size(_handle: VoidPtr)
        external override fun engine_call_slice(_handle: VoidPtr)
        external override fun engine_call_sort(_handle: VoidPtr)
        external override fun engine_call_to_byte_array(_handle: VoidPtr)
        external fun engine_call_to_float32_array(_handle: VoidPtr)
        external fun engine_call_to_float64_array(_handle: VoidPtr)
        external fun engine_call_to_int32_array(_handle: VoidPtr)
        external fun engine_call_to_int64_array(_handle: VoidPtr)

        external fun engine_convert_to_godot(array: ByteArray): VoidPtr
        external fun engine_convert_to_jvm(_handle: VoidPtr): ByteArray
    }
}

/**
 * Convert a [ByteArray] into a Godot [PackedByteArray], this call is optimised for a large amount of data.
 */
fun ByteArray.toPackedByteArray() = PackedByteArray(this)

/**
 * Convert a [Array<Byte>] into a Godot [PackedByteArray], this call is optimised for a large amount of data.
 */
fun Array<Byte>.toPackedByteArray() = PackedByteArray(this)


/**
 * Convert a [Collection<Byte>] into a Godot [PackedByteArray], this call is optimised for a large amount of data.
 */
fun Collection<Byte>.toPackedByteArray() = PackedByteArray(this)

private fun Array<Byte>.toByteArray(): ByteArray =
    ByteArray(size).also { byteArray ->
        forEachIndexed { index, byte ->
            byteArray[index] = byte
        }
    }

private fun Collection<Byte>.toByteArray(): ByteArray =
    ByteArray(size).also { byteArray ->
        forEachIndexed { index, byte ->
            byteArray[index] = byte
        }
    }
