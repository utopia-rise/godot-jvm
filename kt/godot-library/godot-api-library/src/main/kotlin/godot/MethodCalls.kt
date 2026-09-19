// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("unused", "FunctionName", "RedundantVisibilityModifier", "RedundantUnitReturnType")

package godot

import godot.`internal`.memory.TransferContext
import godot.common.interop.VoidPtr
import godot.core.AABB
import godot.core.Basis
import godot.core.Callable
import godot.core.Color
import godot.core.Dictionary
import godot.core.GodotObject
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
import godot.core.Signal
import godot.core.StringName
import godot.core.Transform2D
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BASIS
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import godot.core.VariantParser.PACKED_FLOAT_64_ARRAY
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.VariantParser.PLANE
import godot.core.VariantParser.PROJECTION
import godot.core.VariantParser.QUATERNION
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.RECT2I
import godot.core.VariantParser.SIGNAL
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantParser.VECTOR3
import godot.core.VariantParser.VECTOR3I
import godot.core.VariantParser.VECTOR4
import godot.core.VariantParser._RID
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3
import godot.core.Vector3i
import godot.core.Vector4
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
  p2: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Unit {
  beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): PackedInt64Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 31)
  return PACKED_INT_64_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedInt64Array {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 31)
  return PACKED_INT_64_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_ret_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
): PackedInt64Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 31)
  return PACKED_INT_64_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR3_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector3,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR3_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  RECT2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Rect2i {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 8)
  return RECT2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RECT2I_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  RECT2I.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RECT2I_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  RECT2I.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RECT2I_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  RECT2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_VECTOR2I_BOOL_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Vector2i,
  p2: Boolean,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_VECTOR2I_BOOL_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Vector2i,
  p2: Boolean,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_STRING_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
  p2: String,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod0_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_RID_DOUBLE_LONG_BOOL_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Double,
  p3: Long,
  p4: Boolean,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_RID_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_RECT2_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Rect2,
  p2: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  RECT2.toGodot(buffer, p1)
  RECT2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  TRANSFORM2D.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_LONG_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_RID_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_BOOL_BOOL_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Boolean,
  p3: Boolean,
  p4: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  COLOR.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_LONG_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Long,
  p3: RID,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  _RID.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Double,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): NodePath {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 22)
  return NODE_PATH.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: NodePath,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  NODE_PATH.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_NODE_PATH_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_VECTOR3_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Vector3,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_QUATERNION_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Quaternion,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  QUATERNION.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_BOOL_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Boolean,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_BOOL_ret_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Boolean,
): Quaternion {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 15)
  return QUATERNION.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_BOOL_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Boolean,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_DOUBLE_ANY_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Any?,
  p3: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  ANY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_LONG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_LONG_BOOL_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Long,
  p3: Boolean,
  p4: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_DOUBLE_BOOL_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Boolean,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_DOUBLE_VECTOR2_VECTOR2_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Double,
  p3: Vector2,
  p4: Vector2,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  VECTOR2.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_VECTOR2_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Vector2,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_OBJECT_DOUBLE_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: GodotObject?,
  p3: Double,
  p4: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_STRING_NAME_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: StringName,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 34)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 20)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_OBJECT_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: GodotObject?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  NODE_PATH.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): NodePath {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 22)
  return NODE_PATH.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Quaternion {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 15)
  return QUATERNION.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_DOUBLE_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Double,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_NODE_PATH_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_NODE_PATH_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  NODE_PATH.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_DOUBLE_DOUBLE_BOOL_BOOL_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Double,
  p2: Double,
  p3: Boolean,
  p4: Boolean,
  p5: Double,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  LONG.write(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_STRING_NAME_OBJECT_DOUBLE_BOOL_BOOL_DOUBLE_LONG_BOOL_BOOL_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: GodotObject?,
  p2: Double,
  p3: Boolean,
  p4: Boolean,
  p5: Double,
  p6: Long,
  p7: Boolean,
  p8: Boolean,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 9)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  LONG.write(buffer, p6)
  BOOL.write(buffer, p7)
  BOOL.write(buffer, p8)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_BOOL_BOOL_DOUBLE_LONG_BOOL_BOOL_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Boolean,
  p3: Boolean,
  p4: Double,
  p5: Long,
  p6: Boolean,
  p7: Boolean,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  BOOL.write(buffer, p6)
  BOOL.write(buffer, p7)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_NAME_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_DOUBLE_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Double,
  p2: Long,
  p3: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_VECTOR2_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2,
  p2: Long,
  p3: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_OBJECT_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: GodotObject?,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedFloat32Array,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY_BOOL_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedFloat32Array,
  p1: Boolean,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Double,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: StringName,
  p3: Double,
  p4: Double,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Double,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: StringName,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Double,
  p2: Double,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_BOOL_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Boolean,
  p5: Long,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Boolean,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ARRAY_ARRAY_DICTIONARY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: VariantArray<*>,
  p2: VariantArray<*>,
  p3: Dictionary<*, *>,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  DICTIONARY.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_TRANSFORM3D_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform3D,
  p1: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  TRANSFORM3D.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_AABB(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: AABB,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  godot.core.VariantParser.AABB.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_AABB(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): AABB {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 16)
  return godot.core.VariantParser.AABB.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
  p1: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_INT_32_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  RECT2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 7)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Transform3D {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 18)
  return TRANSFORM3D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_LONG_DOUBLE_BOOL_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Double,
  p6: Boolean,
  p7: Long,
  p8: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 9)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  BOOL.write(buffer, p6)
  LONG.write(buffer, p7)
  BOOL.write(buffer, p8)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DICTIONARY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_LONG_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Long,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_DOUBLE_DOUBLE_DOUBLE_LONG_STRING_NAME_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Long,
  p5: StringName,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  LONG.write(buffer, p4)
  STRING_NAME.toGodot(buffer, p5)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_OBJECT_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_DICTIONARY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: Dictionary<*, *>,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_DICTIONARY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Dictionary<*, *>,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  COLOR.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 20)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Rect2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  RECT2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RECT2I_DOUBLE_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
  p1: Double,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  RECT2I.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  TRANSFORM2D.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Transform2D {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 11)
  return TRANSFORM2D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Quaternion,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  QUATERNION.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Quaternion {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 15)
  return QUATERNION.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_LONG_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedColorArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_COLOR_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedColorArray {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 37)
  return PACKED_COLOR_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_DOUBLE_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Double,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_VECTOR2_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Vector2,
  p2: Double,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  DOUBLE.write(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_PROJECTION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Projection {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 19)
  return PROJECTION.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_DICTIONARY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Dictionary<*, *>,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Color,
  p3: Double,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_COLOR_DOUBLE_DOUBLE_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Color,
  p3: Double,
  p4: Double,
  p5: Boolean,
  p6: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  BOOL.write(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: Color,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: PackedColorArray,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  PACKED_COLOR_ARRAY.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_VECTOR2_DOUBLE_DOUBLE_DOUBLE_DOUBLE_LONG_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Double,
  p5: Long,
  p6: Color,
  p7: Double,
  p8: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 9)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  COLOR.toGodot(buffer, p6)
  DOUBLE.write(buffer, p7)
  BOOL.write(buffer, p8)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_DOUBLE_DOUBLE_DOUBLE_LONG_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Long,
  p5: Color,
  p6: Double,
  p7: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  LONG.write(buffer, p4)
  COLOR.toGodot(buffer, p5)
  DOUBLE.write(buffer, p6)
  BOOL.write(buffer, p7)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RECT2_COLOR_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2,
  p1: Color,
  p2: Boolean,
  p3: Double,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  RECT2.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_DOUBLE_COLOR_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Double,
  p2: Color,
  p3: Boolean,
  p4: Double,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  COLOR.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_DOUBLE_DOUBLE_COLOR_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Double,
  p2: Double,
  p3: Color,
  p4: Boolean,
  p5: Double,
  p6: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  BOOL.write(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_VECTOR2_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2,
  p2: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_RECT2_BOOL_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Rect2,
  p2: Boolean,
  p3: Color,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  OBJECT.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_RECT2_RECT2_COLOR_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Rect2,
  p2: Rect2,
  p3: Color,
  p4: Boolean,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  OBJECT.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  RECT2.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_RECT2_RECT2_COLOR_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Rect2,
  p2: Rect2,
  p3: Color,
  p4: Double,
  p5: Double,
  p6: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  OBJECT.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  RECT2.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  DOUBLE.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  DOUBLE.write(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_RECT2_RECT2_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Rect2,
  p2: Rect2,
  p3: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  RECT2.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_PACKED_VECTOR2_ARRAY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: PackedColorArray,
  p2: PackedVector2Array,
  p3: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  PACKED_COLOR_ARRAY.toGodot(buffer, p1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_COLOR_PACKED_VECTOR2_ARRAY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: Color,
  p2: PackedVector2Array,
  p3: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callMethod_OBJECT_VECTOR2_STRING_LONG_DOUBLE_LONG_COLOR_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Double,
  p5: Long,
  p6: Color,
  p7: Long,
  p8: Long,
  p9: Long,
  p10: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 11)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  COLOR.toGodot(buffer, p6)
  LONG.write(buffer, p7)
  LONG.write(buffer, p8)
  LONG.write(buffer, p9)
  DOUBLE.write(buffer, p10)
  callMethod(methodPtr)
}

internal
    fun TransferContext.callMethod_OBJECT_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Double,
  p5: Long,
  p6: Long,
  p7: Color,
  p8: Long,
  p9: Long,
  p10: Long,
  p11: Long,
  p12: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 13)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  COLOR.toGodot(buffer, p7)
  LONG.write(buffer, p8)
  LONG.write(buffer, p9)
  LONG.write(buffer, p10)
  LONG.write(buffer, p11)
  DOUBLE.write(buffer, p12)
  callMethod(methodPtr)
}

internal
    fun TransferContext.callMethod_OBJECT_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Double,
  p5: Long,
  p6: Long,
  p7: Color,
  p8: Long,
  p9: Long,
  p10: Long,
  p11: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 12)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  COLOR.toGodot(buffer, p7)
  LONG.write(buffer, p8)
  LONG.write(buffer, p9)
  LONG.write(buffer, p10)
  DOUBLE.write(buffer, p11)
  callMethod(methodPtr)
}

internal
    fun TransferContext.callMethod_OBJECT_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Double,
  p5: Long,
  p6: Long,
  p7: Long,
  p8: Color,
  p9: Long,
  p10: Long,
  p11: Long,
  p12: Long,
  p13: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 14)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  COLOR.toGodot(buffer, p8)
  LONG.write(buffer, p9)
  LONG.write(buffer, p10)
  LONG.write(buffer, p11)
  LONG.write(buffer, p12)
  DOUBLE.write(buffer, p13)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_OBJECT_VECTOR2_STRING_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Color,
  p5: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  COLOR.toGodot(buffer, p4)
  DOUBLE.write(buffer, p5)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_OBJECT_VECTOR2_STRING_LONG_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Long,
  p5: Color,
  p6: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  COLOR.toGodot(buffer, p5)
  DOUBLE.write(buffer, p6)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT_TRANSFORM2D_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: Transform2D,
  p3: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_DOUBLE_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Double,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: Double,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 34)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_BOOL_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Boolean,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_NAME_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: StringName,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_NAME_ANY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: StringName,
  p2: Any?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_STRING_NAME_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_STRING_NAME_VARARG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  args: Array<*>,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2 + args.size)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_BOOL_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Boolean,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 34)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_BOOL_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Boolean,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 34)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_BOOL_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Boolean,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_LONG_STRING_STRING_COLOR_OBJECT_ANY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
  p2: String,
  p3: Color,
  p4: GodotObject?,
  p5: Any?,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  OBJECT.toGodot(buffer, p4)
  ANY.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Color,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  TRANSFORM2D.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Transform2D {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 11)
  return TRANSFORM2D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Transform3D {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 18)
  return TRANSFORM3D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_STRING_ANY_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Any?,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 20)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_VECTOR2_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_CALLABLE_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
  p1: Callable,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  CALLABLE.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_STRING_STRING_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
  p2: String,
  p3: String,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_OBJECT_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
  p2: GodotObject?,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_OBJECT_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
  p2: PackedByteArray,
  p3: GodotObject?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_PACKED_BYTE_ARRAY_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: PackedByteArray,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
  p2: PackedByteArray,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: PackedByteArray,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_BOOL_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_DOUBLE_DOUBLE_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Double,
  p2: Double,
  p3: Long,
  p4: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_VECTOR2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_BOOL_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Boolean,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_BOOL_ret_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Boolean,
): Transform2D {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 11)
  return TRANSFORM2D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_VECTOR3_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_BOOL_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Boolean,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_BOOL_BOOL_ret_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Boolean,
  p2: Boolean,
): Transform3D {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 18)
  return TRANSFORM3D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedFloat32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 32)
  return PACKED_FLOAT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_DOUBLE_DOUBLE_DICTIONARY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Double,
  p2: Double,
  p3: Dictionary<*, *>,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DICTIONARY.toGodot(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  CALLABLE.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Callable,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_STRING_STRING_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: String,
  p3: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Callable,
  p3: Callable,
  p4: Any?,
  p5: Long,
  p6: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  ANY.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callMethod_STRING_OBJECT_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
  p2: String,
  p3: Callable,
  p4: Callable,
  p5: Any?,
  p6: Long,
  p7: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
  ANY.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callMethod_STRING_STRING_LONG_LONG_CALLABLE_CALLABLE_ANY_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Long,
  p3: Long,
  p4: Callable,
  p5: Callable,
  p6: Any?,
  p7: Long,
  p8: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 9)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
  CALLABLE.toGodot(buffer, p5)
  ANY.toGodot(buffer, p6)
  LONG.write(buffer, p7)
  LONG.write(buffer, p8)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ANY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Any?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_ret_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): Callable {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return CALLABLE.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_STRING_LONG_DOUBLE_DOUBLE_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Long,
  p3: Double,
  p4: Double,
  p5: Long,
  p6: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  BOOL.write(buffer, p6)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_LONG_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  CALLABLE.toGodot(buffer, p0)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RECT2_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  RECT2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Rect2i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 8)
  return RECT2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 20)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RECT2I_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  RECT2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_CALLABLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  CALLABLE.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_VECTOR3I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Vector3i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 10)
  return VECTOR3I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_RECT2_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Rect2,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_STRING_PACKED_STRING_ARRAY_CALLABLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: PackedStringArray,
  p3: Callable,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  PACKED_STRING_ARRAY.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_STRING_CALLABLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: String,
  p3: Callable,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callMethod_STRING_STRING_STRING_BOOL_LONG_PACKED_STRING_ARRAY_CALLABLE_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: String,
  p3: Boolean,
  p4: Long,
  p5: PackedStringArray,
  p6: Callable,
  p7: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
  PACKED_STRING_ARRAY.toGodot(buffer, p5)
  CALLABLE.toGodot(buffer, p6)
  LONG.write(buffer, p7)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callMethod_STRING_STRING_STRING_STRING_BOOL_LONG_PACKED_STRING_ARRAY_ARRAY_CALLABLE_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: String,
  p3: String,
  p4: Boolean,
  p5: Long,
  p6: PackedStringArray,
  p7: VariantArray<*>,
  p8: Callable,
  p9: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 10)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  LONG.write(buffer, p5)
  PACKED_STRING_ARRAY.toGodot(buffer, p6)
  ARRAY.toGodot(buffer, p7)
  CALLABLE.toGodot(buffer, p8)
  LONG.write(buffer, p9)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_CALLABLE_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  CALLABLE.toGodot(buffer, p0)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_CALLABLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
  p2: Callable,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  _RID.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 7)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Color,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RECT2I_OBJECT_COLOR_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
  p1: GodotObject?,
  p2: Color,
  p3: Long,
  p4: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  RECT2I.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  OBJECT.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RECT2I_ARRAY_ARRAY_COLOR_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
  p1: VariantArray<*>,
  p2: VariantArray<*>,
  p3: Color,
  p4: Long,
  p5: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  RECT2I.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  OBJECT.toGodot(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_OBJECT_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_OBJECT_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_BOOL_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Boolean,
  p2: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_NAME_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Boolean,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_STRING_NAME_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedStringArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ARRAY_OBJECT_BOOL_BOOL_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: GodotObject?,
  p2: Boolean,
  p3: Boolean,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ARRAY.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_BOOL_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_PACKED_STRING_ARRAY_STRING_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedStringArray,
  p1: String,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_STRING_ARRAY.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal
    fun TransferContext.callMethod_STRING_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: PackedByteArray,
  p3: PackedByteArray,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_STRING_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: String,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_STRING_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
  p2: String,
  p3: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_STRING_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 34)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedStringArray,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
}

internal
    fun TransferContext.callPtrMethod_DICTIONARY_LONG_DOUBLE_TRANSFORM2D_LONG_LONG_LONG_LONG_DOUBLE_LONG_PACKED_COLOR_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Dictionary<*, *>,
  p1: Long,
  p2: Double,
  p3: Transform2D,
  p4: Long,
  p5: Long,
  p6: Long,
  p7: Long,
  p8: Double,
  p9: Long,
  p10: PackedColorArray,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 11)
  DICTIONARY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  TRANSFORM2D.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  DOUBLE.write(buffer, p8)
  LONG.write(buffer, p9)
  PACKED_COLOR_ARRAY.toGodot(buffer, p10)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): PackedColorArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 37)
  return PACKED_COLOR_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_DOUBLE_LONG_LONG_LONG_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Double,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  callMethod(methodPtr)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callMethod_STRING_LONG_DOUBLE_LONG_LONG_LONG_LONG_LONG_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Double,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
  p7: Long,
  p8: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 9)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  LONG.write(buffer, p8)
  callMethod(methodPtr)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callMethod_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_COLOR_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Double,
  p5: Long,
  p6: Color,
  p7: Long,
  p8: Long,
  p9: Long,
  p10: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 11)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  COLOR.toGodot(buffer, p6)
  LONG.write(buffer, p7)
  LONG.write(buffer, p8)
  LONG.write(buffer, p9)
  DOUBLE.write(buffer, p10)
  callMethod(methodPtr)
}

internal
    fun TransferContext.callMethod_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Double,
  p5: Long,
  p6: Long,
  p7: Color,
  p8: Long,
  p9: Long,
  p10: Long,
  p11: Long,
  p12: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 13)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  COLOR.toGodot(buffer, p7)
  LONG.write(buffer, p8)
  LONG.write(buffer, p9)
  LONG.write(buffer, p10)
  LONG.write(buffer, p11)
  DOUBLE.write(buffer, p12)
  callMethod(methodPtr)
}

internal
    fun TransferContext.callMethod_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Double,
  p5: Long,
  p6: Long,
  p7: Color,
  p8: Long,
  p9: Long,
  p10: Long,
  p11: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 12)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  COLOR.toGodot(buffer, p7)
  LONG.write(buffer, p8)
  LONG.write(buffer, p9)
  LONG.write(buffer, p10)
  DOUBLE.write(buffer, p11)
  callMethod(methodPtr)
}

internal
    fun TransferContext.callMethod_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: String,
  p3: Long,
  p4: Double,
  p5: Long,
  p6: Long,
  p7: Long,
  p8: Color,
  p9: Long,
  p10: Long,
  p11: Long,
  p12: Long,
  p13: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 14)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  COLOR.toGodot(buffer, p8)
  LONG.write(buffer, p9)
  LONG.write(buffer, p10)
  LONG.write(buffer, p11)
  LONG.write(buffer, p12)
  DOUBLE.write(buffer, p13)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_LONG_LONG_COLOR_DOUBLE_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Long,
  p3: Long,
  p4: Color,
  p5: Double,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  COLOR.toGodot(buffer, p4)
  DOUBLE.write(buffer, p5)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_LONG_LONG_LONG_COLOR_DOUBLE_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Color,
  p6: Double,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  COLOR.toGodot(buffer, p5)
  DOUBLE.write(buffer, p6)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
  p3: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
  p3: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  PACKED_INT_32_ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
  p3: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
  p3: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  RECT2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 7)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_VECTOR2I_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Vector2i,
  p3: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_VECTOR2I_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Vector2i,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_ARRAY_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_VARARG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  args: Array<*>,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, args.size)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_PACKED_FLOAT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): PackedFloat64Array {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 33)
  return PACKED_FLOAT_64_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_FLOAT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedFloat64Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_FLOAT_64_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DICTIONARY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Dictionary<*, *>,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DICTIONARY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_OBJECT_LONG_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
  p2: Long,
  p3: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING.toGodot(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_PACKED_BYTE_ARRAY_STRING_OBJECT_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: String,
  p2: GodotObject?,
  p3: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_DOUBLE_BOOL_BOOL_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Double,
  p2: Boolean,
  p3: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_NODE_PATH_OBJECT_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: NodePath,
  p2: GodotObject?,
  p3: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  NODE_PATH.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  TRANSFORM3D.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Quaternion,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  QUATERNION.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_BOOL_ret_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Boolean,
): NodePath {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 22)
  return NODE_PATH.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_NODE_PATH_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_BASIS(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Basis {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 17)
  return BASIS.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BASIS(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Basis,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BASIS.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM2D_VECTOR2_COLOR_COLOR_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform2D,
  p1: Vector2,
  p2: Color,
  p3: Color,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  TRANSFORM2D.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_TRANSFORM3D_VECTOR3_COLOR_COLOR_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform3D,
  p1: Vector3,
  p2: Color,
  p3: Color,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  TRANSFORM3D.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_DOUBLE_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Double,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_VECTOR2_DOUBLE_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
  p3: Double,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callMethod_VECTOR2_VECTOR2_VECTOR2_VECTOR2_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
  p3: Vector2,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_VECTOR2_VECTOR2_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
  p3: Vector2,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_VECTOR2_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_VECTOR2_VECTOR2_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
  p3: Vector2,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_PACKED_VECTOR2_ARRAY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: PackedVector2Array,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_PACKED_VECTOR2_ARRAY_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: PackedVector2Array,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_DOUBLE_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: Double,
  p2: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_DOUBLE_LONG_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: Double,
  p2: Long,
  p3: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_VECTOR2I_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Vector2i,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_LONG_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: Long,
  p3: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_LONG_LONG_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: Long,
  p3: Long,
  p4: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_VECTOR3_VECTOR3_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Vector3,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  VECTOR3.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_VECTOR3_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_VECTOR3_VECTOR3_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Vector3,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  VECTOR3.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_VECTOR3_VECTOR3_VECTOR3_VECTOR3_VECTOR3_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Vector3,
  p4: Vector3,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  VECTOR3.toGodot(buffer, p3)
  VECTOR3.toGodot(buffer, p4)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_VECTOR3_DOUBLE_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Double,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_DOUBLE_DOUBLE_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Double,
  p3: Double,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_ARRAY_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: VariantArray<*>,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY_PLANE_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
  p1: Plane,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  PLANE.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 20)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 20)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_STRING_NAME_LONG_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
  p2: StringName,
  p3: Long,
  p4: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_STRING_NAME_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
  p2: StringName,
  p3: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
  p2: StringName,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_STRING_NAME_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
  p2: StringName,
  p3: Long,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_DOUBLE_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Double,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RECT2_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  RECT2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_LONG_COLOR_BOOL_LONG_COLOR_OBJECT_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: Long,
  p3: Color,
  p4: Boolean,
  p5: Long,
  p6: Color,
  p7: GodotObject?,
  p8: GodotObject?,
  p9: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 10)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  LONG.write(buffer, p5)
  COLOR.toGodot(buffer, p6)
  OBJECT.toGodot(buffer, p7)
  OBJECT.toGodot(buffer, p8)
  BOOL.write(buffer, p9)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_LONG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3I_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3i,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR3I_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3i,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3I_ret_BASIS(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3i,
): Basis {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 17)
  return BASIS.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_BASIS(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Basis {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 17)
  return BASIS.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BASIS_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Basis,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BASIS.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_ret_VECTOR3I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
): Vector3i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 10)
  return VECTOR3I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3I_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3i,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3I_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3i,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3I_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3i,
  p1: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_AABB_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: AABB,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  godot.core.VariantParser.AABB.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3I_ret_VECTOR3I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3i,
): Vector3i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 10)
  return VECTOR3I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_OBJECT_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: GodotObject?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_PACKED_STRING_ARRAY_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
  p2: PackedStringArray,
  p3: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  PACKED_STRING_ARRAY.toGodot(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_PACKED_STRING_ARRAY_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
  p2: PackedStringArray,
  p3: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  PACKED_STRING_ARRAY.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_DICTIONARY_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Dictionary<*, *>,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DICTIONARY.toGodot(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_LONG_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedStringArray,
  p2: Long,
  p3: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING.toGodot(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_LONG_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedStringArray,
  p2: Long,
  p3: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_LONG_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Long,
  p4: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
  PACKED_BYTE_ARRAY.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_BOOL_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
  p2: Boolean,
  p3: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_BOOL_DOUBLE_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Boolean,
  p2: Double,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  BOOL.write(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
  p2: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_DOUBLE_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Double,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_BOOL_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Boolean,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_RECT2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Rect2i,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  RECT2I.toGodot(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT_RECT2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: Rect2i,
  p3: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  RECT2I.toGodot(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RECT2I_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Rect2i,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  RECT2I.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 20)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  COLOR.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_LONG_PACKED_BYTE_ARRAY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Long,
  p4: PackedByteArray,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
  PACKED_BYTE_ARRAY.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_BOOL_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Boolean,
  p5: VariantArray<*>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
  ARRAY.toGodot(buffer, p5)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PLANE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Plane,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PLANE.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_ARRAY_ARRAY_DICTIONARY_OBJECT_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: VariantArray<*>,
  p2: VariantArray<*>,
  p3: Dictionary<*, *>,
  p4: GodotObject?,
  p5: String,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  DICTIONARY.toGodot(buffer, p3)
  OBJECT.toGodot(buffer, p4)
  STRING.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_ARRAY_ARRAY_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_OBJECT_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: GodotObject?,
  p2: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_BOOL_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Boolean,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: StringName,
  p3: StringName,
  p4: Double,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
  DOUBLE.write(buffer, p4)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Double,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_BOOL_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Boolean,
  p2: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM2D_VECTOR2_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform2D,
  p1: Vector2,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  TRANSFORM2D.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_OBJECT_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: GodotObject?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_STRING_NAME_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: StringName,
  p2: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_OBJECT_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: GodotObject?,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_OBJECT_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
  p2: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  RECT2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 7)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Quaternion,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  QUATERNION.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Quaternion {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 15)
  return QUATERNION.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod0_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ANY.toGodot(buffer, p0)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_ANY_STRING_BOOL_BOOL_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: String,
  p2: Boolean,
  p3: Boolean,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ANY.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_BOOL_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Boolean,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_ANY_ANY_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Any?,
  p2: Any?,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_ANY_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Any?,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ANY_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Any?,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_ANY_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
  p2: Any?,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_CALLABLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Callable,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_PACKED_STRING_ARRAY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: PackedStringArray,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_CALLABLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  CALLABLE.toGodot(buffer, p0)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_VARARG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  args: Array<*>,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 1 + args.size)
  STRING.toGodot(buffer, p0)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_PACKED_BYTE_ARRAY_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: String,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR3_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector3,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_NODE_PATH_RECT2_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
  p1: Rect2,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  NODE_PATH.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_ANY_BOOL_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Boolean,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_PACKED_BYTE_ARRAY_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PLANE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Plane,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PLANE.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_PLANE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Plane {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 14)
  return PLANE.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ret_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): PackedFloat32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 32)
  return PACKED_FLOAT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedFloat32Array,
  p1: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_OBJECT_STRING_NAME_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
  p2: StringName,
  p3: VariantArray<*>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_ANY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Any?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ANY.toGodot(buffer, p0)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod0_ret_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Callable {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callMethod(methodPtr)
  return CALLABLE.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_RID_ret_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Callable {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callMethod(methodPtr)
  return CALLABLE.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_STRING_RID_ANY_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: String,
  p2: RID,
  p3: Any?,
  p4: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  ANY.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: String,
  p2: Callable,
  p3: Callable,
  p4: Any?,
  p5: Long,
  p6: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  ANY.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_OBJECT_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: GodotObject?,
  p2: String,
  p3: Callable,
  p4: Callable,
  p5: Any?,
  p6: Long,
  p7: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  _RID.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
  ANY.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callMethod_RID_STRING_LONG_LONG_CALLABLE_CALLABLE_ANY_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: String,
  p2: Long,
  p3: Long,
  p4: Callable,
  p5: Callable,
  p6: Any?,
  p7: Long,
  p8: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 9)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
  CALLABLE.toGodot(buffer, p5)
  ANY.toGodot(buffer, p6)
  LONG.write(buffer, p7)
  LONG.write(buffer, p8)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_ANY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Any?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_RID_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_LONG_ret_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Callable {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return CALLABLE.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_LONG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_LONG_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_LONG_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  _RID.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_OBJECT_OBJECT_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: GodotObject?,
  p3: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_OBJECT_OBJECT_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedFloat32Array,
  p1: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_ARRAY_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ARRAY.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
  p1: Double,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedInt64Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_INT_64_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_VECTOR2_BOOL_LONG_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Vector2,
  p3: Boolean,
  p4: Long,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_BOOL_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Boolean,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Transform2D {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 11)
  return TRANSFORM2D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 7)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_DOUBLE_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: Double,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR3_VECTOR3_BOOL_LONG_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector3,
  p2: Vector3,
  p3: Boolean,
  p4: Long,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR3_VECTOR3_BOOL_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector3,
  p2: Vector3,
  p3: Boolean,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR3_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector3,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR3_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector3,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_BOOL_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Boolean,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR3_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector3,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Transform3D {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 18)
  return TRANSFORM3D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Vector3 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 9)
  return VECTOR3.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_AABB(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): AABB {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 16)
  return godot.core.VariantParser.AABB.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedVector3Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY_DOUBLE_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
  p1: Double,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Boolean,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_NODE_PATH_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  NODE_PATH.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_BOOL_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
  p2: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_BOOL_BOOL_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Boolean,
  p3: Boolean,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callMethod(methodPtr)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_NODE_PATH_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  NODE_PATH.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: VariantArray<*>,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_STRING_NAME_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: StringName,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_NAME_LONG_STRING_NAME_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: StringName,
  p2: Long,
  p3: StringName,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_VARARG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  args: Array<*>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1 + args.size)
  STRING_NAME.toGodot(buffer, p0)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_NAME_VARARG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  args: Array<*>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2 + args.size)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_VARARG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  args: Array<*>,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 1 + args.size)
  STRING_NAME.toGodot(buffer, p0)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): Transform2D {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 11)
  return TRANSFORM2D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
  p2: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  TRANSFORM3D.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR3_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_VECTOR3_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_DOUBLE_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: Double,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_BOOL_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Boolean,
  p4: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_BOOL_DOUBLE_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Boolean,
  p4: Double,
  p5: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_BOOL_BOOL_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Boolean,
  p4: Boolean,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_BOOL_DOUBLE_BOOL_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Boolean,
  p4: Double,
  p5: Boolean,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_BOOL_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Boolean,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callMethod_STRING_STRING_STRING_STRING_LONG_LONG_BOOL_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: String,
  p3: String,
  p4: Long,
  p5: Long,
  p6: Boolean,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  BOOL.write(buffer, p6)
  callMethod(methodPtr)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_ARRAY_BOOL_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedStringArray,
  p2: VariantArray<*>,
  p3: Boolean,
  p4: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_BOOL_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedStringArray,
  p2: Boolean,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedStringArray,
  p2: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_STRING_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedStringArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_STRING_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_BOOL_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_NODE_PATH_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_NODE_PATH_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  NODE_PATH.toGodot(buffer, p0)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_ANY_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Any?,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_ARRAY_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: VariantArray<*>,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_CALLABLE_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Callable,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_CALLABLE_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Callable,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_STRING_NAME_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_STRING_NAME_LONG_STRING_NAME_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Long,
  p3: StringName,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_ARRAY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
  p2: VariantArray<*>,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_RID_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: RID,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  callMethod(methodPtr)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_CALLABLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Callable,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_STRING_STRING_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: String,
  p3: String,
  p4: String,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
  STRING.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_TRANSFORM3D_PACKED_VECTOR2_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform3D,
  p1: PackedVector2Array,
  p2: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  TRANSFORM3D.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  PACKED_INT_32_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 34)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Transform3D {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 18)
  return TRANSFORM3D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM3D_RID_OBJECT_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform3D,
  p1: RID,
  p2: GodotObject?,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  TRANSFORM3D.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_RID_CALLABLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: RID,
  p2: Callable,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_ARRAY_OBJECT_OBJECT_CALLABLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
  p2: GodotObject?,
  p3: GodotObject?,
  p4: Callable,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ARRAY_OBJECT_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
  p2: GodotObject?,
  p3: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: GodotObject?,
  p2: Callable,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
  p2: GodotObject?,
  p3: Callable,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_PACKED_INT_64_ARRAY_OBJECT_CALLABLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedInt64Array,
  p2: GodotObject?,
  p3: Callable,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  PACKED_INT_64_ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ARRAY_PACKED_INT_64_ARRAY_OBJECT_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
  p2: PackedInt64Array,
  p3: GodotObject?,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  PACKED_INT_64_ARRAY.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ARRAY_OBJECT_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
  p2: GodotObject?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): PackedFloat32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 32)
  return PACKED_FLOAT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): PackedVector3Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 36)
  return PACKED_VECTOR3_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG_STRING_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: String,
  p3: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_PACKED_BYTE_ARRAY_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: PackedByteArray,
  p2: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ANY.toGodot(buffer, p0)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_OBJECT_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
  p2: GodotObject?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM3D_LONG_ret_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform3D,
  p1: Long,
): Transform3D {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  TRANSFORM3D.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 18)
  return TRANSFORM3D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_CALLABLE_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Callable,
  p2: VariantArray<*>,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_BOOL_DOUBLE_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Boolean,
  p2: Double,
  p3: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM2D_VECTOR2_OBJECT_DOUBLE_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform2D,
  p1: Vector2,
  p2: GodotObject?,
  p3: Double,
  p4: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  TRANSFORM2D.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_BOOL_DOUBLE_BOOL_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Boolean,
  p2: Double,
  p3: Boolean,
  p4: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  VECTOR3.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM3D_VECTOR3_OBJECT_DOUBLE_BOOL_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform3D,
  p1: Vector3,
  p2: GodotObject?,
  p3: Double,
  p4: Boolean,
  p5: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  TRANSFORM3D.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): PackedFloat32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 32)
  return PACKED_FLOAT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_VECTOR2_LONG_ARRAY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Vector2,
  p2: Long,
  p3: VariantArray<*>,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_LONG_ARRAY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: Long,
  p3: VariantArray<*>,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_RID_TRANSFORM2D_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Transform2D,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Transform2D {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 11)
  return TRANSFORM2D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_BOOL_DOUBLE_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Boolean,
  p3: Double,
  p4: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  VECTOR2.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_CALLABLE_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Callable,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_OBJECT_OBJECT_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: GodotObject?,
  p2: GodotObject?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: RID,
  p3: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  _RID.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_VECTOR2_VECTOR2_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Vector2,
  p3: Vector2,
  p4: RID,
  p5: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  _RID.toGodot(buffer, p4)
  _RID.toGodot(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_VECTOR2_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Vector2,
  p3: RID,
  p4: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  _RID.toGodot(buffer, p3)
  _RID.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_TRANSFORM3D_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Transform3D,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  TRANSFORM3D.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  TRANSFORM3D.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR3_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector3,
  p2: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_VECTOR3_RID_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Vector3,
  p3: RID,
  p4: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  _RID.toGodot(buffer, p3)
  VECTOR3.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_TRANSFORM3D_RID_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Transform3D,
  p3: RID,
  p4: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  TRANSFORM3D.toGodot(buffer, p2)
  _RID.toGodot(buffer, p3)
  TRANSFORM3D.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_VECTOR3I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Vector3i {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 10)
  return VECTOR3I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_NODE_PATH_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
  p1: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR2_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector2Array,
  p1: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_OBJECT_STRING_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: Long,
  p3: Boolean,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: Long,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
  p2: Boolean,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_ANY_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Any?,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_NAME_PACKED_STRING_ARRAY_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: PackedStringArray,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
  p2: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ANY.toGodot(buffer, p0)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedFloat32Array,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_BOOL_LONG_LONG_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Boolean,
  p3: Long,
  p4: Long,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ANY.toGodot(buffer, p0)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_LONG_LONG_LONG_VECTOR2I_LONG_LONG_BOOL_BOOL_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Vector2i,
  p6: Long,
  p7: Long,
  p8: Boolean,
  p9: Boolean,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 10)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  VECTOR2I.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  BOOL.write(buffer, p8)
  BOOL.write(buffer, p9)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_OBJECT_OBJECT_BOOL_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: GodotObject?,
  p3: GodotObject?,
  p4: Boolean,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME_OBJECT_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: StringName,
  p3: GodotObject?,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_LONG_LONG_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_LONG_LONG_LONG_LONG_OBJECT_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: GodotObject?,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  OBJECT.toGodot(buffer, p6)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_LONG_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Long,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ret_PROJECTION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Projection {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callPtrMethod(methodPtr, 19)
  return PROJECTION.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: VariantArray<*>,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_RID_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: RID,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_RID_LONG_LONG_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: RID,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  OBJECT.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_LONG_LONG_LONG_LONG_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
  p7: Long,
  p8: Long,
  p9: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 10)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  LONG.write(buffer, p8)
  LONG.write(buffer, p9)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_LONG_CALLABLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Callable,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_RID_RID_VECTOR3_VECTOR3_VECTOR3_LONG_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Vector3,
  p3: Vector3,
  p4: Vector3,
  p5: Long,
  p6: Long,
  p7: Long,
  p8: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 9)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  VECTOR3.toGodot(buffer, p3)
  VECTOR3.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  LONG.write(buffer, p8)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_COLOR_LONG_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Color,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_ARRAY_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: Long,
  p2: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_ARRAY_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: Long,
  p3: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
  p2: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
  p2: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ARRAY_PACKED_INT_64_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: VariantArray<*>,
  p3: PackedInt64Array,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  PACKED_INT_64_ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_PACKED_BYTE_ARRAY_BOOL_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: PackedByteArray,
  p3: Boolean,
  p4: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_RID_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: RID,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedByteArray,
  p2: Long,
  p3: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_PACKED_BYTE_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: PackedByteArray,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_RID_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: RID,
  p2: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_RID_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Long,
  p3: Long,
  p4: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_PACKED_BYTE_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: PackedByteArray,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_CALLABLE_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Callable,
  p2: Long,
  p3: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_RID_LONG_LONG_LONG_OBJECT_OBJECT_OBJECT_OBJECT_LONG_LONG_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: GodotObject?,
  p5: GodotObject?,
  p6: GodotObject?,
  p7: GodotObject?,
  p8: Long,
  p9: Long,
  p10: VariantArray<*>,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 11)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  OBJECT.toGodot(buffer, p4)
  OBJECT.toGodot(buffer, p5)
  OBJECT.toGodot(buffer, p6)
  OBJECT.toGodot(buffer, p7)
  LONG.write(buffer, p8)
  LONG.write(buffer, p9)
  ARRAY.toGodot(buffer, p10)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_ARRAY_ARRAY_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: VariantArray<*>,
  p3: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_PACKED_INT_32_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: PackedInt32Array,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  PACKED_INT_32_ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_COLOR_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Color,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_RID_LONG_PACKED_COLOR_ARRAY_DOUBLE_LONG_RECT2_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: PackedColorArray,
  p3: Double,
  p4: Long,
  p5: Rect2,
  p6: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_COLOR_ARRAY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  LONG.write(buffer, p4)
  RECT2.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_RID_LONG_LONG_LONG_LONG_LONG_PACKED_COLOR_ARRAY_DOUBLE_LONG_RECT2_ARRAY_ret_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: PackedColorArray,
  p7: Double,
  p8: Long,
  p9: Rect2,
  p10: VariantArray<*>,
): PackedInt64Array {
  val buffer = beginMethodCall(callerPtr, callerId, 11)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  PACKED_COLOR_ARRAY.toGodot(buffer, p6)
  DOUBLE.write(buffer, p7)
  LONG.write(buffer, p8)
  RECT2.toGodot(buffer, p9)
  ARRAY.toGodot(buffer, p10)
  callPtrMethod(methodPtr, 31)
  return PACKED_INT_64_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: RID,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_ARRAY_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: VariantArray<*>,
  p4: PackedInt64Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  ARRAY.toGodot(buffer, p3)
  PACKED_INT_64_ARRAY.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_RID_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: RID,
  p3: Long,
  p4: Long,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  _RID.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_RID_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: RID,
  p3: Long,
  p4: Long,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  _RID.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_RID_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: RID,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_BOOL_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Boolean,
  p5: VariantArray<*>,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
  ARRAY.toGodot(buffer, p5)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_LONG_LONG_LONG_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
  p7: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_COLOR_BOOL_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Color,
  p4: Boolean,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_ARRAY_RECT2I_RID_COLOR_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: Rect2i,
  p2: RID,
  p3: Color,
  p4: VariantArray<*>,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  ARRAY.toGodot(buffer, p0)
  RECT2I.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  ARRAY.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_STRING_NAME_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: StringName,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_STRING_NAME_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: StringName,
  p2: RID,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_STRING_NAME_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: StringName,
  p2: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: StringName,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ARRAY_ARRAY_DICTIONARY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: VariantArray<*>,
  p3: VariantArray<*>,
  p4: Dictionary<*, *>,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  ARRAY.toGodot(buffer, p3)
  DICTIONARY.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_AABB(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: AABB,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  godot.core.VariantParser.AABB.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_BOOL_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: Boolean,
  p4: Boolean,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  COLOR.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Color {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 20)
  return COLOR.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): PackedFloat32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 32)
  return PACKED_FLOAT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_PACKED_FLOAT_32_ARRAY_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedFloat32Array,
  p2: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Double,
  p3: Double,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Double,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_TRANSFORM3D_AABB_VECTOR3I_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Transform3D,
  p2: AABB,
  p3: Vector3i,
  p4: PackedByteArray,
  p5: PackedByteArray,
  p6: PackedByteArray,
  p7: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  _RID.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  godot.core.VariantParser.AABB.toGodot(buffer, p2)
  VECTOR3I.toGodot(buffer, p3)
  PACKED_BYTE_ARRAY.toGodot(buffer, p4)
  PACKED_BYTE_ARRAY.toGodot(buffer, p5)
  PACKED_BYTE_ARRAY.toGodot(buffer, p6)
  PACKED_INT_32_ARRAY.toGodot(buffer, p7)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_VECTOR3I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Vector3i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 10)
  return VECTOR3I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 29)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_RID_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_PACKED_VECTOR3_ARRAY_PACKED_COLOR_ARRAY_PACKED_INT_32_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedVector3Array,
  p2: PackedColorArray,
  p3: PackedInt32Array,
  p4: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p1)
  PACKED_COLOR_ARRAY.toGodot(buffer, p2)
  PACKED_INT_32_ARRAY.toGodot(buffer, p3)
  PACKED_INT_32_ARRAY.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): PackedColorArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 37)
  return PACKED_COLOR_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_TRANSFORM3D_VECTOR3_COLOR_COLOR_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Transform3D,
  p2: Vector3,
  p3: Color,
  p4: Color,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  COLOR.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Callable,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_PACKED_VECTOR3_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedVector3Array,
  p2: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p1)
  PACKED_INT_32_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Double,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_VECTOR2_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Vector2,
  p3: Double,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_BOOL_VECTOR2I_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Boolean,
  p3: Vector2i,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_BASIS(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Basis,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  BASIS.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_COLOR_LONG_DOUBLE_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Color,
  p2: Long,
  p3: Double,
  p4: Double,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_BOOL_PACKED_FLOAT_32_ARRAY_DOUBLE_DOUBLE_DOUBLE_DOUBLE_LONG_DOUBLE_DOUBLE_DOUBLE_DOUBLE_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: PackedFloat32Array,
  p3: Double,
  p4: Double,
  p5: Double,
  p6: Double,
  p7: Long,
  p8: Double,
  p9: Double,
  p10: Double,
  p11: Double,
  p12: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 13)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  DOUBLE.write(buffer, p6)
  LONG.write(buffer, p7)
  DOUBLE.write(buffer, p8)
  DOUBLE.write(buffer, p9)
  DOUBLE.write(buffer, p10)
  DOUBLE.write(buffer, p11)
  _RID.toGodot(buffer, p12)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Double,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_DOUBLE_DOUBLE_DOUBLE_BOOL_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Double,
  p3: Double,
  p4: Double,
  p5: Boolean,
  p6: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  _RID.toGodot(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_LONG_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Long,
  p3: Double,
  p4: Double,
  p5: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_BOOL_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Double,
  p3: Double,
  p4: Double,
  p5: Double,
  p6: Double,
  p7: Double,
  p8: Double,
  p9: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 10)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  DOUBLE.write(buffer, p6)
  DOUBLE.write(buffer, p7)
  DOUBLE.write(buffer, p8)
  DOUBLE.write(buffer, p9)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_BOOL_COLOR_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Color,
  p3: Double,
  p4: Double,
  p5: Double,
  p6: Double,
  p7: Double,
  p8: Double,
  p9: Double,
  p10: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 11)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  COLOR.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  DOUBLE.write(buffer, p6)
  DOUBLE.write(buffer, p7)
  DOUBLE.write(buffer, p8)
  DOUBLE.write(buffer, p9)
  LONG.write(buffer, p10)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_BOOL_LONG_DOUBLE_LONG_BOOL_DOUBLE_BOOL_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Long,
  p3: Double,
  p4: Long,
  p5: Boolean,
  p6: Double,
  p7: Boolean,
  p8: Double,
  p9: Double,
  p10: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 11)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  LONG.write(buffer, p4)
  BOOL.write(buffer, p5)
  DOUBLE.write(buffer, p6)
  BOOL.write(buffer, p7)
  DOUBLE.write(buffer, p8)
  DOUBLE.write(buffer, p9)
  DOUBLE.write(buffer, p10)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_BOOL_DOUBLE_COLOR_COLOR_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_BOOL_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Double,
  p3: Color,
  p4: Color,
  p5: Double,
  p6: Double,
  p7: Double,
  p8: Double,
  p9: Double,
  p10: Boolean,
  p11: Double,
  p12: Double,
  p13: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 14)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  COLOR.toGodot(buffer, p4)
  DOUBLE.write(buffer, p5)
  DOUBLE.write(buffer, p6)
  DOUBLE.write(buffer, p7)
  DOUBLE.write(buffer, p8)
  DOUBLE.write(buffer, p9)
  BOOL.write(buffer, p10)
  DOUBLE.write(buffer, p11)
  DOUBLE.write(buffer, p12)
  DOUBLE.write(buffer, p13)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_DOUBLE_LONG_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: Double,
  p3: Long,
  p4: Double,
  p5: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_VECTOR2I_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Vector2i,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  BOOL.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_DOUBLE_DOUBLE_BOOL_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Double,
  p3: Double,
  p4: Boolean,
  p5: Double,
  p6: Double,
  p7: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  DOUBLE.write(buffer, p6)
  DOUBLE.write(buffer, p7)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Double,
  p3: Double,
  p4: Double,
  p5: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_DOUBLE_DOUBLE_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Double,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_RECT2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Rect2,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  RECT2.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_AABB_RID_ret_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: AABB,
  p1: RID,
): PackedInt64Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  godot.core.VariantParser.AABB.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 31)
  return PACKED_INT_64_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_RID_ret_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
  p2: RID,
): PackedInt64Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 31)
  return PACKED_INT_64_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_RID_ret_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: RID,
): PackedInt64Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ARRAY.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 31)
  return PACKED_INT_64_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ARRAY_VECTOR2I_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: VariantArray<*>,
  p2: Vector2i,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_RID_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Color,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_BOOL_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  RECT2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_VECTOR2_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Vector2,
  p3: Color,
  p4: Double,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedVector2Array,
  p2: PackedColorArray,
  p3: Double,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  PACKED_COLOR_ARRAY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: Color,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_DOUBLE_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Double,
  p3: Color,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_DOUBLE_DOUBLE_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Double,
  p3: Double,
  p4: Color,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  COLOR.toGodot(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_RID_BOOL_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: RID,
  p3: Boolean,
  p4: Color,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  COLOR.toGodot(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_RID_RECT2_COLOR_LONG_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: RID,
  p3: Rect2,
  p4: Color,
  p5: Long,
  p6: Double,
  p7: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  RECT2.toGodot(buffer, p3)
  COLOR.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  DOUBLE.write(buffer, p6)
  DOUBLE.write(buffer, p7)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_RID_RECT2_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: RID,
  p3: Rect2,
  p4: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  RECT2.toGodot(buffer, p3)
  COLOR.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_RID_RECT2_COLOR_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: RID,
  p3: Rect2,
  p4: Color,
  p5: Boolean,
  p6: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  RECT2.toGodot(buffer, p3)
  COLOR.toGodot(buffer, p4)
  BOOL.write(buffer, p5)
  BOOL.write(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_RECT2_RID_VECTOR2_VECTOR2_LONG_LONG_BOOL_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: Rect2,
  p3: RID,
  p4: Vector2,
  p5: Vector2,
  p6: Long,
  p7: Long,
  p8: Boolean,
  p9: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 10)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  RECT2.toGodot(buffer, p2)
  _RID.toGodot(buffer, p3)
  VECTOR2.toGodot(buffer, p4)
  VECTOR2.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
  BOOL.write(buffer, p8)
  COLOR.toGodot(buffer, p9)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_PACKED_VECTOR2_ARRAY_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedVector2Array,
  p2: PackedColorArray,
  p3: PackedVector2Array,
  p4: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  PACKED_COLOR_ARRAY.toGodot(buffer, p2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p3)
  _RID.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callPtrMethod_RID_PACKED_INT_32_ARRAY_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_PACKED_VECTOR2_ARRAY_PACKED_INT_32_ARRAY_PACKED_FLOAT_32_ARRAY_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedInt32Array,
  p2: PackedVector2Array,
  p3: PackedColorArray,
  p4: PackedVector2Array,
  p5: PackedInt32Array,
  p6: PackedFloat32Array,
  p7: RID,
  p8: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 9)
  _RID.toGodot(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p2)
  PACKED_COLOR_ARRAY.toGodot(buffer, p3)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p4)
  PACKED_INT_32_ARRAY.toGodot(buffer, p5)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p6)
  _RID.toGodot(buffer, p7)
  LONG.write(buffer, p8)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_TRANSFORM2D_COLOR_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Transform2D,
  p3: Color,
  p4: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  _RID.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_BOOL_RECT2_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Boolean,
  p2: Rect2,
  p3: Callable,
  p4: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  RECT2.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_LONG_DOUBLE_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Double,
  p3: Boolean,
  p4: Double,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_PACKED_VECTOR2_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedVector2Array,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_NAME_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_DOUBLE_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Double,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_COLOR_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Color,
  p2: Long,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_COLOR_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Color,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_STRING_BOOL_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Boolean,
  p3: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: VariantArray<*>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: String,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 34)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_COLOR_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Color,
  p3: Long,
  p4: Boolean,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  COLOR.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal
    fun TransferContext.callMethod_OBJECT_DOUBLE_DOUBLE_COLOR_LONG_RECT2_ANY_BOOL_STRING_LONG_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Double,
  p2: Double,
  p3: Color,
  p4: Long,
  p5: Rect2,
  p6: Any?,
  p7: Boolean,
  p8: String,
  p9: Long,
  p10: Long,
  p11: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 12)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  RECT2.toGodot(buffer, p5)
  ANY.toGodot(buffer, p6)
  BOOL.write(buffer, p7)
  STRING.toGodot(buffer, p8)
  LONG.write(buffer, p9)
  LONG.write(buffer, p10)
  STRING.toGodot(buffer, p11)
  callMethod(methodPtr)
}

internal
    fun TransferContext.callMethod_ANY_LONG_OBJECT_DOUBLE_DOUBLE_COLOR_LONG_RECT2_BOOL_STRING_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Long,
  p2: GodotObject?,
  p3: Double,
  p4: Double,
  p5: Color,
  p6: Long,
  p7: Rect2,
  p8: Boolean,
  p9: String,
  p10: Long,
  p11: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 12)
  ANY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  COLOR.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  RECT2.toGodot(buffer, p7)
  BOOL.write(buffer, p8)
  STRING.toGodot(buffer, p9)
  LONG.write(buffer, p10)
  LONG.write(buffer, p11)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_LONG_STRING_LONG_LONG_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: String,
  p3: Long,
  p4: Long,
  p5: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p5)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_LONG_LONG_BOOL_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  STRING.toGodot(buffer, p3)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_ANY_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ANY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_LONG_LONG_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  STRING.toGodot(buffer, p3)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_OBJECT_LONG_RECT2_COLOR_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
  p2: Long,
  p3: Rect2,
  p4: Color,
  p5: Long,
  p6: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  RECT2.toGodot(buffer, p3)
  COLOR.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  COLOR.toGodot(buffer, p6)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: Long,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_COLOR_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Color,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  COLOR.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_PACKED_STRING_ARRAY_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedStringArray,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_STRING_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: Long,
  p2: Long,
  p3: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_NODE_PATH_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_NODE_PATH_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  NODE_PATH.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_ret_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
): NodePath {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 22)
  return NODE_PATH.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DOUBLE_BOOL_BOOL_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Boolean,
  p2: Boolean,
  p3: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_NAME_STRING_NAME_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: StringName,
  args: Array<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3 + args.size)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_STRING_NAME_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: String,
  p3: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  ANY.toGodot(buffer, p3)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_NAME_STRING_NAME_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  args: Array<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2 + args.size)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_NAME_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: String,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_OBJECT_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: NodePath,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  NODE_PATH.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_NODE_PATH_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: NodePath,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  NODE_PATH.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM2D_OBJECT_TRANSFORM2D_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform2D,
  p1: GodotObject?,
  p2: Transform2D,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  TRANSFORM2D.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM2D_VECTOR2_OBJECT_TRANSFORM2D_VECTOR2_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform2D,
  p1: Vector2,
  p2: GodotObject?,
  p3: Transform2D,
  p4: Vector2,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  TRANSFORM2D.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  TRANSFORM2D.toGodot(buffer, p3)
  VECTOR2.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_TRANSFORM2D_OBJECT_TRANSFORM2D_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform2D,
  p1: GodotObject?,
  p2: Transform2D,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  TRANSFORM2D.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_TRANSFORM2D_VECTOR2_OBJECT_TRANSFORM2D_VECTOR2_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform2D,
  p1: Vector2,
  p2: GodotObject?,
  p3: Transform2D,
  p4: Vector2,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  TRANSFORM2D.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  TRANSFORM2D.toGodot(buffer, p3)
  VECTOR2.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_TRANSFORM2D_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Transform2D,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  TRANSFORM2D.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_STRING_NAME_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_TRANSFORM3D_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Transform3D,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_DOUBLE_DOUBLE_BOOL_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Double,
  p2: Double,
  p3: Boolean,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_NODE_PATH_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: NodePath,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  NODE_PATH.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: NodePath,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  NODE_PATH.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): NodePath {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 22)
  return NODE_PATH.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_OBJECT_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: GodotObject?,
  p2: Double,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_OBJECT_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
  p2: GodotObject?,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_LONG_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Long,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_BOOL_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_RECT2_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: Rect2,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_PACKED_VECTOR2_ARRAY_PACKED_VECTOR3_ARRAY_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
  p1: PackedVector2Array,
  p2: PackedColorArray,
  p3: PackedVector2Array,
  p4: PackedVector3Array,
  p5: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  PACKED_COLOR_ARRAY.toGodot(buffer, p2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p3)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p4)
  ARRAY.toGodot(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
  p1: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_OBJECT_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_OBJECT_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: GodotObject?,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Boolean,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_LONG_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Long,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callMethod(methodPtr)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_BOOL_BOOL_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Boolean,
  p2: Boolean,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): Rect2i {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 8)
  return RECT2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_BOOL_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: Boolean,
  p3: Long,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_BOOL_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_BOOL_BOOL_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Boolean,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  BOOL.write(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_OBJECT_LONG_STRING_ANY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
  p2: Long,
  p3: String,
  p4: Any?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING.toGodot(buffer, p3)
  ANY.toGodot(buffer, p4)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_VECTOR2_LONG_LONG_DOUBLE_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Vector2,
  p2: Long,
  p3: Long,
  p4: Double,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  ANY.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_VECTOR2_LONG_DOUBLE_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Vector2,
  p2: Long,
  p3: Double,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ANY.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ANY.toGodot(buffer, p0)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ANY.toGodot(buffer, p0)
  callMethod(methodPtr)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Color,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Long,
  p3: Color,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  DOUBLE.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_OBJECT_LONG_RECT2_STRING_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: GodotObject?,
  p2: Long,
  p3: Rect2,
  p4: String,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  RECT2.toGodot(buffer, p3)
  STRING.toGodot(buffer, p4)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_ANY_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Any?,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_COLOR_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Color,
  p3: Color,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  DOUBLE.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_LONG_COLOR_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Long,
  p3: Color,
  p4: Color,
  p5: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  COLOR.toGodot(buffer, p4)
  DOUBLE.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_LONG_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Long,
  p3: Long,
  p4: Color,
  p5: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  COLOR.toGodot(buffer, p4)
  DOUBLE.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): PackedColorArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 37)
  return PACKED_COLOR_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedColorArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_COLOR_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
  p3: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
  p3: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  PACKED_INT_32_ARRAY.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
  p3: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 7)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
  p3: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  RECT2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2I_LONG_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2i,
  p2: Long,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_VECTOR2I_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Vector2i,
  p3: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_VECTOR2I_ret_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Vector2i,
): Vector2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 5)
  return VECTOR2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_RID_LONG_VECTOR2_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Long,
  p3: Vector2,
  p4: Long,
  p5: Color,
  p6: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  COLOR.toGodot(buffer, p5)
  DOUBLE.write(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_LONG_LONG_VECTOR2_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Long,
  p3: Long,
  p4: Vector2,
  p5: Long,
  p6: Color,
  p7: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  VECTOR2.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  COLOR.toGodot(buffer, p6)
  DOUBLE.write(buffer, p7)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_STRING_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: String,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_STRING_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: String,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_LONG_VECTOR2_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Vector2,
  p3: Long,
  p4: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  COLOR.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_STRING_ARRAY_LONG_DICTIONARY_STRING_ANY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: String,
  p2: VariantArray<*>,
  p3: Long,
  p4: Dictionary<*, *>,
  p5: String,
  p6: Any?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DICTIONARY.toGodot(buffer, p4)
  STRING.toGodot(buffer, p5)
  ANY.toGodot(buffer, p6)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_ANY_VECTOR2_LONG_LONG_DOUBLE_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Any?,
  p2: Vector2,
  p3: Long,
  p4: Long,
  p5: Double,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_ANY_VECTOR2_LONG_DOUBLE_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Any?,
  p2: Vector2,
  p3: Long,
  p4: Double,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_ANY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Any?,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_ARRAY_LONG_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: VariantArray<*>,
  p3: Long,
  p4: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DICTIONARY.toGodot(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_LONG_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Long,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_PACKED_FLOAT_32_ARRAY_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedFloat32Array,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_RID_PACKED_FLOAT_32_ARRAY_LONG_BOOL_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: PackedFloat32Array,
  p2: Long,
  p3: Boolean,
  p4: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_LONG_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Long,
  p3: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 30)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_RID_ANY_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Any?,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_RID_ANY_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Any?,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  callMethod(methodPtr)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_LONG_LONG_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: Long,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_DOUBLE_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Double,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_RID_VECTOR2_DOUBLE_DOUBLE_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Vector2,
  p3: Double,
  p4: Double,
  p5: Color,
  p6: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  COLOR.toGodot(buffer, p5)
  DOUBLE.write(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RID_VECTOR2_DOUBLE_DOUBLE_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: RID,
  p2: Vector2,
  p3: Double,
  p4: Double,
  p5: Long,
  p6: Color,
  p7: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  COLOR.toGodot(buffer, p6)
  DOUBLE.write(buffer, p7)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_STRING_LONG_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
  p2: Long,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_ret_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: String,
): PackedInt32Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return PACKED_INT_32_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_ARRAY_STRING_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: VariantArray<*>,
  p2: String,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_RID_VECTOR2_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Vector2,
  p2: Color,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_BOOL_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: Boolean,
  p3: Color,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_RID_RECT2_RECT2_COLOR_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: Rect2,
  p3: Color,
  p4: Boolean,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  RECT2.toGodot(buffer, p2)
  COLOR.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
  BOOL.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_STRING_NAME_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: StringName,
  p3: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  ANY.toGodot(buffer, p3)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_LONG_STRING_NAME_STRING_NAME_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: StringName,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_STRING_NAME_STRING_NAME_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: StringName,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_STRING_NAME_STRING_NAME_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: StringName,
  p3: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_STRING_NAME_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: StringName,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_STRING_ret_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
): PackedStringArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  callMethod(methodPtr)
  return PACKED_STRING_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_CALLABLE_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  CALLABLE.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_BOOL_BOOL_BOOL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Boolean,
  p2: Boolean,
  p3: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
  p3: Vector2i,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_BOOL_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Boolean,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_BOOL_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Boolean,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_BOOL_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Boolean,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_ARRAY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: VariantArray<*>,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_VECTOR2I_OBJECT_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Vector2i,
  p2: GodotObject?,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ARRAY_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: VariantArray<*>,
  p2: Long,
  p3: Long,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_LONG_VECTOR2I_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Vector2i,
  p3: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
  p2: Vector2i,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_ret_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): Vector2i {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 6)
  return VECTOR2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_ARRAY_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 39)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_ARRAY_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: VariantArray<*>,
  p1: Long,
  p2: Long,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
  p3: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 28)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
  p3: Long,
  p4: Vector2i,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  VECTOR2I.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_VECTOR2I_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_VECTOR2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Vector2i,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_VECTOR2I_LONG_VECTOR2I_LONG_VECTOR2I_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Vector2i,
  p2: Long,
  p3: Vector2i,
  p4: Long,
  p5: Vector2i,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  VECTOR2I.toGodot(buffer, p5)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_OBJECT_VECTOR2I_VECTOR2I_VECTOR2I_ret_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2i,
  p2: Vector2i,
  p3: Vector2i,
): PackedVector2Array {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 35)
  return PACKED_VECTOR2_ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_ret_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
): Double {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 3)
  return DOUBLE.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_ret_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
): Rect2i {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 8)
  return RECT2I.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2I_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2i,
  p1: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_DICTIONARY_BOOL_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Dictionary<*, *>,
  p1: Boolean,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DICTIONARY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_DICTIONARY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Dictionary<*, *>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DICTIONARY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_BOOL_BOOL_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Boolean,
  p1: Boolean,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_STRING_NAME_PACKED_STRING_ARRAY_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: PackedStringArray,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_STRING_NAME_LONG_STRING_NAME_ret_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: StringName,
  p2: Long,
  p3: StringName,
): StringName {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
  callPtrMethod(methodPtr, 21)
  return STRING_NAME.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_ret_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): VariantArray<*> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return ARRAY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_ret_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): String {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return STRING.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_LONG_ret_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
  p2: Long,
): Rect2 {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 7)
  return RECT2.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR2_ret_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 24)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_OBJECT_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_ret_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
): Callable {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
  callMethod(methodPtr)
  return CALLABLE.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Color,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  COLOR.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_LONG_OBJECT_LONG_BOOL_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
  p2: Long,
  p3: Boolean,
  p4: String,
  p5: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  STRING.toGodot(buffer, p4)
  STRING.toGodot(buffer, p5)
  callMethod(methodPtr)
}

internal fun TransferContext.callMethod_STRING_NAME_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  args: Array<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1 + args.size)
  STRING_NAME.toGodot(buffer, p0)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_PACKED_VECTOR3_ARRAY_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedVector3Array,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_VECTOR3_VECTOR3_ret_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector3,
  p1: Vector3,
): Dictionary<*, *> {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 27)
  return DICTIONARY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_NODE_PATH_ANY_DOUBLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: NodePath,
  p2: Any?,
  p3: Double,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  NODE_PATH.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_CALLABLE_ANY_ANY_DOUBLE_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
  p1: Any?,
  p2: Any?,
  p3: Double,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  CALLABLE.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_SIGNAL_ret_OBJECT_REF(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Signal,
): GodotObject? {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  SIGNAL.toGodot(buffer, p0)
  callMethod(methodPtr)
  return OBJECT.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_ANY_ANY_DOUBLE_DOUBLE_LONG_LONG_ret_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Any?,
  p1: Any?,
  p2: Double,
  p3: Double,
  p4: Long,
  p5: Long,
): Any? {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  ANY.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  callMethod(methodPtr)
  return ANY.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_LONG_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_LONG_STRING_STRING_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: String,
  p3: String,
  p4: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_OBJECT_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: StringName,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_RID_LONG_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Long,
  p2: VariantArray<*>,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_PACKED_FLOAT_32_ARRAY_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: PackedFloat32Array,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_OBJECT_VECTOR2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: GodotObject?,
  p2: Vector2,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_LONG_LONG_LONG_LONG_ret_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
): Boolean {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 1)
  return BOOL.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_ANY_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Any?,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  ANY.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_VECTOR4(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector4,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR4.toGodot(buffer, p0)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod0_ret_VECTOR4(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Vector4 {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 12)
  return VECTOR4.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_TRANSFORM3D_AABB_VECTOR3_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Transform3D,
  p1: AABB,
  p2: Vector3,
  p3: PackedByteArray,
  p4: PackedByteArray,
  p5: PackedByteArray,
  p6: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  TRANSFORM3D.toGodot(buffer, p0)
  godot.core.VariantParser.AABB.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
  PACKED_BYTE_ARRAY.toGodot(buffer, p4)
  PACKED_BYTE_ARRAY.toGodot(buffer, p5)
  PACKED_INT_32_ARRAY.toGodot(buffer, p6)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_LONG_ARRAY_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: VariantArray<*>,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Long,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_LONG_STRING_OBJECT_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: String,
  p2: GodotObject?,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: PackedByteArray,
  p1: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  callPtrMethod(methodPtr, 2)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_OBJECT_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Rect2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  RECT2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_OBJECT_VECTOR2I_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: GodotObject?,
  p1: Vector2i,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_CALLABLE_BOOL_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
  p1: Boolean,
  p2: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  CALLABLE.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_CALLABLE_LONG_LONG_BOOL_STRING_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Callable,
  p1: Long,
  p2: Long,
  p3: Boolean,
  p4: String,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  CALLABLE.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  STRING.toGodot(buffer, p4)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callPtrMethod0_ret_PLANE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
): Plane {
  val buffer = beginMethodCall(callerPtr, callerId, 0)
  callPtrMethod(methodPtr, 14)
  return PLANE.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: StringName,
  p2: Double,
  p3: Double,
  p4: Double,
  p5: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  DOUBLE.write(buffer, p5)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_LONG_TRANSFORM3D_ret_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Transform3D,
): Transform3D {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 18)
  return TRANSFORM3D.toKotlin(buffer.rewind())
}

internal fun TransferContext.callPtrMethod_LONG_DOUBLE_DOUBLE_DOUBLE_ret_PROJECTION(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Long,
  p1: Double,
  p2: Double,
  p3: Double,
): Projection {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  callPtrMethod(methodPtr, 19)
  return PROJECTION.toKotlin(buffer.rewind())
}

internal
    fun TransferContext.callPtrMethod_RID_RECT2_RECT2I_BOOL_LONG_BOOL_VECTOR2_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: RID,
  p1: Rect2,
  p2: Rect2i,
  p3: Boolean,
  p4: Long,
  p5: Boolean,
  p6: Vector2,
  p7: Double,
  p8: Double,
  p9: Double,
  p10: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 11)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  RECT2I.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
  BOOL.write(buffer, p5)
  VECTOR2.toGodot(buffer, p6)
  DOUBLE.write(buffer, p7)
  DOUBLE.write(buffer, p8)
  DOUBLE.write(buffer, p9)
  DOUBLE.write(buffer, p10)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callMethod_STRING_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  callMethod(methodPtr)
}

internal fun TransferContext.callPtrMethod_STRING_NAME_TRANSFORM3D_VECTOR3_VECTOR3_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: StringName,
  p1: Transform3D,
  p2: Vector3,
  p3: Vector3,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING_NAME.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  VECTOR3.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  callPtrMethod(methodPtr, 0)
}

internal fun TransferContext.callPtrMethod_VECTOR2_PACKED_VECTOR2_ARRAY_ret_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: Vector2,
  p1: PackedVector2Array,
): RID {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  callPtrMethod(methodPtr, 23)
  return _RID.toKotlin(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_LONG_LONG_ret_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Long,
  p2: Long,
): Long {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  callMethod(methodPtr)
  return LONG.read(buffer.rewind())
}

internal fun TransferContext.callMethod_STRING_BOOL_ret_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  methodPtr: VoidPtr,
  p0: String,
  p1: Boolean,
): PackedByteArray {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  callMethod(methodPtr)
  return PACKED_BYTE_ARRAY.toKotlin(buffer.rewind())
}
