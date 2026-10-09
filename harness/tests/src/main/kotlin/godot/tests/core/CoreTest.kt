package godot.tests.core

import godot.annotation.Script
import godot.annotation.Register
import godot.api.Node
import godot.core.AABB
import godot.core.Basis
import godot.core.Color
import godot.core.NodePath
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import godot.core.PackedFloat64Array
import godot.core.PackedInt32Array
import godot.core.PackedInt64Array
import godot.core.PackedStringArray
import godot.core.PackedVector2Array
import godot.core.PackedVector3Array
import godot.core.Plane
import godot.core.Projection
import godot.core.Quaternion
import godot.core.RID
import godot.core.Rect2
import godot.core.Rect2i
import godot.core.StringName
import godot.core.Transform2D
import godot.core.Transform3D
import godot.core.Dictionary
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3
import godot.core.Vector3i
import godot.core.Vector4
import godot.core.Vector4i
import godot.core.variantArrayOf

@Script
class CoreTest : Node() {
    private val shortStringValue = "short core string"
    private val longStringValue =
        "This is a deliberately long core string used for transport verification. " +
            "It includes enough text to cross the tiny-value case and make sure the buffer " +
            "still preserves longer payloads without trimming, reordering, or accidental reuse."
    private val vector2Value = Vector2(1.25, 2.5)
    private val vector2iValue = Vector2i(11, 22)
    private val rect2Value = Rect2(1.5, 2.5, 3.5, 4.5)
    private val rect2iValue = Rect2i(3, 4, 5, 6)
    private val vector3Value = Vector3(1.25, 2.5, 3.75)
    private val vector3iValue = Vector3i(7, 8, 9)
    private val transform2DValue = Transform2D(1, 2, 3, 4, 5, 6)
    private val vector4Value = Vector4(1.25, 2.5, 3.75, 4.125)
    private val vector4iValue = Vector4i(10, 11, 12, 13)
    private val planeValue = Plane(1.5, 2.5, 3.5, 4.5)
    private val quaternionValue = Quaternion(0.5, 1.5, 2.5, 3.5)
    private val aabbValue = AABB(Vector3(1, 2, 3), Vector3(4, 5, 6))
    private val basisValue = Basis(Vector3(1, 2, 3), Vector3(4, 5, 6), Vector3(7, 8, 9))
    private val transform3DValue =
        Transform3D(Vector3(1, 2, 3), Vector3(4, 5, 6), Vector3(7, 8, 9), Vector3(10, 11, 12))
    private val projectionValue = Projection.createPerspective(75.0, 1.6, 0.2, 250.0)
    private val colorValue = Color(0.11, 0.22, 0.33, 0.44)
    private val stringNameValue = StringName("core_test_string_name")
    private val nodePathValue = NodePath("Root/Branch:leaf")
    private val ridValue = RID()
    private val packedByteArrayValue = PackedByteArray(byteArrayOf(1, 3, 5, 7))
    private val packedInt32ArrayValue = PackedInt32Array(intArrayOf(11, 22, 33))
    private val packedInt64ArrayValue = PackedInt64Array(longArrayOf(101L, 202L, 303L))
    private val packedFloat32ArrayValue = PackedFloat32Array(floatArrayOf(1.25f, 2.5f, 3.75f))
    private val packedFloat64ArrayValue = PackedFloat64Array(doubleArrayOf(1.125, 2.25, 3.375))
    private val packedStringArrayValue = PackedStringArray(variantArrayOf("alpha", "beta", "gamma"))
    private val packedVector2ArrayValue = PackedVector2Array(listOf(Vector2(1, 2), Vector2(3, 4)))
    private val packedVector3ArrayValue = PackedVector3Array(listOf(Vector3(1, 2, 3), Vector3(4, 5, 6)))
    private val packedColorArrayValue = PackedColorArray(listOf(Color(0.1, 0.2, 0.3, 0.4), Color(0.5, 0.6, 0.7, 0.8)))
    private val nestedVariantArrayValue = variantArrayOf<Any?>(
        variantArrayOf(1, 2, 3),
        "tail",
        null,
    )
    private val mixedDictionaryValue = Dictionary<String, Any?>().apply {
        this["text"] = "alpha"
        this["count"] = 2
        this["path"] = NodePath("Root/Branch:leaf")
        this["nullable"] = null
    }

    @Register
    fun readShort(): Short = 7

    @Register
    fun echoShort(value: Short) = value

    @Register
    fun readChar() = 'A'

    @Register
    fun echoChar(value: Char) = value

    @Register
    fun readVector2() = vector2Value

    @Register
    fun echoVector2(value: Vector2) = value

    @Register
    fun readShortString() = shortStringValue

    @Register
    fun echoShortString(value: String) = value

    @Register
    fun readLongString() = longStringValue

    @Register
    fun echoLongString(value: String) = value

    @Register
    fun readVector2i() = vector2iValue

    @Register
    fun echoVector2i(value: Vector2i) = value

    @Register
    fun readRect2() = rect2Value

    @Register
    fun echoRect2(value: Rect2) = value

    @Register
    fun readRect2i() = rect2iValue

    @Register
    fun echoRect2i(value: Rect2i) = value

    @Register
    fun readVector3() = vector3Value

    @Register
    fun echoVector3(value: Vector3) = value

    @Register
    fun readVector3i() = vector3iValue

    @Register
    fun echoVector3i(value: Vector3i) = value

    @Register
    fun readTransform2D() = transform2DValue

    @Register
    fun echoTransform2D(value: Transform2D) = value

    @Register
    fun readVector4() = vector4Value

    @Register
    fun echoVector4(value: Vector4) = value

    @Register
    fun readVector4i() = vector4iValue

    @Register
    fun echoVector4i(value: Vector4i) = value

    @Register
    fun readPlane() = planeValue

    @Register
    fun echoPlane(value: Plane) = value

    @Register
    fun readQuaternion() = quaternionValue

    @Register
    fun echoQuaternion(value: Quaternion) = value

    @Register
    fun readAabb() = aabbValue

    @Register
    fun echoAabb(value: AABB) = value

    @Register
    fun readBasis() = basisValue

    @Register
    fun echoBasis(value: Basis) = value

    @Register
    fun readTransform3D() = transform3DValue

    @Register
    fun echoTransform3D(value: Transform3D) = value

    @Register
    fun readProjection() = projectionValue

    @Register
    fun echoProjection(value: Projection) = value

    @Register
    fun readColor() = colorValue

    @Register
    fun echoColor(value: Color) = value

    @Register
    fun readStringName() = stringNameValue

    @Register
    fun echoStringName(value: StringName) = value

    @Register
    fun readNodePath() = nodePathValue

    @Register
    fun echoNodePath(value: NodePath) = value

    @Register
    fun readRid() = ridValue

    @Register
    fun echoRid(value: RID) = value

    @Register
    fun readPackedByteArray() = packedByteArrayValue

    @Register
    fun echoPackedByteArray(value: PackedByteArray) = value

    @Register
    fun readPackedInt32Array() = packedInt32ArrayValue

    @Register
    fun echoPackedInt32Array(value: PackedInt32Array) = value

    @Register
    fun readPackedInt64Array() = packedInt64ArrayValue

    @Register
    fun echoPackedInt64Array(value: PackedInt64Array) = value

    @Register
    fun readPackedFloat32Array() = packedFloat32ArrayValue

    @Register
    fun echoPackedFloat32Array(value: PackedFloat32Array) = value

    @Register
    fun readPackedFloat64Array() = packedFloat64ArrayValue

    @Register
    fun echoPackedFloat64Array(value: PackedFloat64Array) = value

    @Register
    fun readPackedStringArray() = packedStringArrayValue

    @Register
    fun echoPackedStringArray(value: PackedStringArray) = value

    @Register
    fun readPackedVector2Array() = packedVector2ArrayValue

    @Register
    fun echoPackedVector2Array(value: PackedVector2Array) = value

    @Register
    fun readPackedVector3Array() = packedVector3ArrayValue

    @Register
    fun echoPackedVector3Array(value: PackedVector3Array) = value

    // PackedVector4Array is not covered yet here because this harness currently rejects it elsewhere and
    // I want this suite to stay build-stable until we confirm round-trip support separately.

    @Register
    fun readPackedColorArray() = packedColorArrayValue

    @Register
    fun echoPackedColorArray(value: PackedColorArray) = value

    @Register
    fun readNestedVariantArray() = nestedVariantArrayValue

    @Register
    fun echoNestedVariantArray(value: VariantArray<Any?>) = value

    @Register
    fun appendToVariantArray(value: VariantArray<Any?>): VariantArray<Any?> {
        value.append("from-kotlin")
        return value
    }

    @Register
    fun readMixedDictionary() = mixedDictionaryValue

    @Register
    fun echoMixedDictionary(value: Dictionary<String, Any?>) = value

    @Register
    fun writeDictionaryFlag(value: Dictionary<String, Any?>): Dictionary<String, Any?> {
        value["from_kotlin"] = true
        return value
    }
}

