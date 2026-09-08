package godot.tests.core

import godot.api.Node
import godot.annotation.Script
import godot.annotation.Register
import godot.core.Color
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import godot.core.PackedFloat64Array
import godot.core.PackedInt32Array
import godot.core.PackedInt64Array
import godot.core.PackedVector2Array
import godot.core.PackedVector3Array
import godot.core.PackedVector4Array
import godot.core.PackedStringArray
import godot.core.Vector2
import godot.core.Vector3
import godot.core.Vector4
import godot.core.toPackedByteArray
import godot.core.toPackedColorArray
import godot.core.toPackedFloat32Array
import godot.core.toPackedFloat64Array
import godot.core.toPackedInt32Array
import godot.core.toPackedInt64Array
import godot.core.toPackedVector2Array
import godot.core.toPackedVector3Array
import godot.core.toPackedVector4Array
import godot.core.variantArrayOf

@Script
class PackedArrayTest : Node() {

    @Register
    fun convertByteArray(): PackedByteArray {
        val arr = byteArrayOf(0, 1, 2, 4, 8, 16, 32, 64, 127)
        return arr.toPackedByteArray();
    }

    @Register
    fun convertIntArray(): PackedInt32Array {
        val arr = intArrayOf(0, 1, 2, 4, 8, 16, 32, 64, 127)
        return arr.toPackedInt32Array();
    }

    @Register
    fun convertLongArray(): PackedInt64Array {
        val arr = longArrayOf(0L, 1L, 2L, 4L, 8L, 16L, 32L, 64L, 127L)
        return arr.toPackedInt64Array();
    }

    @Register
    fun convertFloatArray(): PackedFloat32Array {
        val arr = floatArrayOf(0f, 1f, 2f, 4f, 8f, 16f, 32f, 64f, 127f)
        return arr.toPackedFloat32Array();
    }

    @Register
    fun convertDoubleArray(): PackedFloat64Array {
        val arr = doubleArrayOf(0.0, 1.0, 2.0, 4.0, 8.0, 16.0, 32.0, 64.0, 127.0)
        return arr.toPackedFloat64Array();
    }

    @Register
    fun convertColorArray(): PackedColorArray {
        val arr = listOf(Color(0.0, 1.0, 2.0, 3.0), Color(4.0, 5.0, 6.0, 7.0), Color(8.0, 9.0, 10.0, 11.0), Color(1024.0, 2048.0, 4096.0, 8092.0))
        return arr.toPackedColorArray();
    }

    @Register
    fun convertVector2Array(): PackedVector2Array {
        val arr = arrayOf(Vector2(0.0, 1.0), Vector2(2.0, 3.0), Vector2(4.0, 5.0), Vector2(1024.0, 2048.0))
        return arr.toPackedVector2Array();
    }

    @Register
    fun convertVector2VariantArray(): PackedVector2Array {
        return PackedVector2Array(variantArrayOf<Vector2>(Vector2(0.0, 1.0), Vector2(2.0, 3.0)))
    }

    @Register
    fun convertVector3Array(): PackedVector3Array {
        val arr = arrayOf(Vector3(0.0, 1.0, 2.0), Vector3(3.0, 4.0, 5.0), Vector3(6.0, 7.0, 8.0), Vector3(1024.0, 2048.0, 4096.0))
        return arr.toPackedVector3Array();
    }

    @Register
    fun convertVector3VariantArray(): PackedVector3Array {
        return PackedVector3Array(variantArrayOf(Vector3(0.0, 1.0, 2.0), Vector3(3.0, 4.0, 5.0)))
    }

    @Register
    fun convertVector4Array(): PackedVector4Array {
        val arr = arrayOf(Vector4(0.0, 1.0, 2.0, 3.0), Vector4(4.0, 5.0, 6.0, 7.0), Vector4(8.0, 9.0, 10.0, 11.0), Vector4(1024.0, 2048.0, 4096.0, 8092.0))
        return arr.toPackedVector4Array();
    }

    @Register
    fun convertLargeStringArray(): PackedStringArray {
        val arr = listOf(
            "This is the first long packed string payload",
            "This is the second long packed string payload",
            "This is the third long packed string payload",
            "This is the fourth long packed string payload",
        )
        return PackedStringArray(variantArrayOf(*arr.toTypedArray()))
    }

    @Register
    fun getByteArrayValue(arr: PackedByteArray, index: Int): Byte {
        val kotlinArr = arr.toByteArray()
        return kotlinArr[index];
    }

    @Register
    fun getIntArrayValue(arr: PackedInt32Array, index: Int): Int {
        val kotlinArr = arr.toIntArray()
        return kotlinArr[index];
    }

    @Register
    fun getLongArrayValue(arr: PackedInt64Array, index: Int): Long {
        val kotlinArr = arr.toLongArray()
        return kotlinArr[index];
    }

    @Register
    fun getFloatArrayValue(arr: PackedFloat32Array, index: Int): Float {
        val kotlinArr = arr.toFloatArray()
        return kotlinArr[index];
    }

    @Register
    fun getDoubleArrayValue(arr: PackedFloat64Array, index: Int): Double {
        val kotlinArr = arr.toDoubleArray()
        return kotlinArr[index];
    }

    @Register
    fun getColorArrayValue(arr: PackedColorArray, index: Int): Color {
        val kotlinArr = arr.toColorArray()
        return kotlinArr[index];
    }

    @Register
    fun getVector2ArrayValue(arr: PackedVector2Array, index: Int): Vector2 {
        val kotlinArr = arr.toVector2Array()
        return kotlinArr[index];
    }

    @Register
    fun getVector3ArrayValue(arr: PackedVector3Array, index: Int): Vector3 {
        val kotlinArr = arr.toVector3Array()
        return kotlinArr[index];
    }

    @Register
    fun getVector4ArrayValue(arr: PackedVector4Array, index: Int): Vector4 {
        val kotlinArr = arr.toVector4Array()
        return kotlinArr[index];
    }

    @Register
    fun encodeSignedIntegers(): PackedByteArray {
        val bytes = PackedByteArray(ByteArray(15))
        bytes.encodeS8(0, -7)
        bytes.encodeS16(1, -1234)
        bytes.encodeS32(3, -123456)
        bytes.encodeS64(7, -1234567890123L)
        return bytes
    }

    @Register
    fun encodeUnsignedIntegers(): PackedByteArray {
        val bytes = PackedByteArray(ByteArray(15))
        bytes.encodeU8(0, 250)
        bytes.encodeU16(1, 65000)
        bytes.encodeU32(3, 2000000000)
        bytes.encodeU64(7, 1234567890123L)
        return bytes
    }

    @Register
    fun encodeFloatingPointNumbers(): PackedByteArray {
        val bytes = PackedByteArray(ByteArray(14))
        bytes.encodeHalf(0, 1.5f)
        bytes.encodeFloat(2, 3.25f)
        bytes.encodeDouble(6, 6.125)
        return bytes
    }

    @Register
    fun encodeVariant(value: String): PackedByteArray {
        val bytes = PackedByteArray(ByteArray(64))
        bytes.encodeVar(0, value)
        return bytes
    }

    @Register
    fun decodeVariantSize(bytes: PackedByteArray): Int = bytes.decodeVarSize(0)
}
