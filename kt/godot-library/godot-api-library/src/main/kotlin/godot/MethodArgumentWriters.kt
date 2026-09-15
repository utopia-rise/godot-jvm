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

internal fun TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedByteArray,
  p2: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments0(callerPtr: VoidPtr, callerId: Long): Unit {
  beginMethodCall(callerPtr, callerId, 0)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Vector2,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  LONG.write(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BOOL.write(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR3_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Vector3,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Rect2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  RECT2I.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR2I.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RECT2I_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Rect2i,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  RECT2I.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RECT2I_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Rect2i,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  RECT2I.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_VECTOR2I_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Vector2i,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_BOOL_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Boolean,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  OBJECT.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_RID_DOUBLE_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: RID,
  p2: Double,
  p3: Long,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  _RID.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_RID_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_RECT2_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Rect2,
  p2: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  RECT2.toGodot(buffer, p1)
  RECT2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  TRANSFORM2D.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_BOOL_BOOL_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_LONG_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  STRING_NAME.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Double,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DOUBLE.write(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: NodePath,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  NODE_PATH.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_NODE_PATH_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: NodePath,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: Quaternion,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  QUATERNION.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_ANY_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: Any?,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  ANY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: Long,
  p3: Boolean,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_DOUBLE_VECTOR2_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: Double,
  p3: Vector2,
  p4: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
  VECTOR2.toGodot(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_VECTOR2_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_OBJECT_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: GodotObject?,
  p3: Double,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  DOUBLE.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Double,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: NodePath,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  NODE_PATH.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_NODE_PATH_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: NodePath,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_BOOL_BOOL_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_STRING_NAME_OBJECT_DOUBLE_BOOL_BOOL_DOUBLE_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: GodotObject?,
  p2: Double,
  p3: Boolean,
  p4: Boolean,
  p5: Double,
  p6: Long,
  p7: Boolean,
  p8: Boolean,
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_BOOL_BOOL_DOUBLE_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Double,
  p2: Boolean,
  p3: Boolean,
  p4: Double,
  p5: Long,
  p6: Boolean,
  p7: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  LONG.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  LONG.write(buffer, p5)
  BOOL.write(buffer, p6)
  BOOL.write(buffer, p7)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_DOUBLE_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_VECTOR2_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_OBJECT_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: GodotObject?,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Long,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_PACKED_FLOAT_32_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedFloat32Array,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_BOOL_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Boolean,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_ARRAY_ARRAY_DICTIONARY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM3D_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform3D,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  TRANSFORM3D.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_AABB(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: AABB,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  godot.core.VariantParser.AABB.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector3Array,
  p1: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector3Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_INT_32_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  RECT2.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_LONG_DOUBLE_BOOL_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  DICTIONARY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_DOUBLE_DOUBLE_DOUBLE_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Double,
  p2: Double,
  p3: Double,
  p4: Long,
  p5: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  LONG.write(buffer, p4)
  STRING_NAME.toGodot(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_LONG_OBJECT_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: GodotObject?,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  COLOR.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_OBJECT_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Rect2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  RECT2I.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  TRANSFORM2D.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Quaternion,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  QUATERNION.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedColorArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_COLOR_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_VECTOR2_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2_COLOR_DOUBLE_DOUBLE_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_VECTOR2_DOUBLE_DOUBLE_DOUBLE_DOUBLE_LONG_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_VECTOR2_DOUBLE_DOUBLE_DOUBLE_LONG_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RECT2_COLOR_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_DOUBLE_COLOR_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_DOUBLE_DOUBLE_COLOR_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_VECTOR2_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Vector2,
  p2: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_RECT2_BOOL_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_RECT2_RECT2_COLOR_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_RECT2_RECT2_COLOR_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_RECT2_RECT2_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
}

internal
    fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_PACKED_VECTOR2_ARRAY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_COLOR_PACKED_VECTOR2_ARRAY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_OBJECT_VECTOR2_STRING_LONG_DOUBLE_LONG_COLOR_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_OBJECT_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_OBJECT_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_OBJECT_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_VECTOR2_STRING_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_VECTOR2_STRING_LONG_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT_TRANSFORM2D_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_DOUBLE_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Double,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: StringName,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_STRING_COLOR_OBJECT_ANY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  TRANSFORM2D.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_ANY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_CALLABLE_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Callable,
  p1: Callable,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  CALLABLE.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: String,
  p2: String,
  p3: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedByteArray,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedByteArray,
  p2: PackedByteArray,
  p3: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_OBJECT_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_DOUBLE_DOUBLE_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Double,
  p2: Double,
  p3: Long,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  VECTOR2.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2_VECTOR2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_DOUBLE_DOUBLE_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Double,
  p2: Double,
  p3: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  DICTIONARY.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Callable,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  CALLABLE.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Callable,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: String,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: Callable,
  p3: Callable,
  p4: Any?,
  p5: Long,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  ANY.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
}

internal
    fun TransferContext.writeMethodArguments_STRING_OBJECT_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: GodotObject?,
  p2: String,
  p3: Callable,
  p4: Callable,
  p5: Any?,
  p6: Long,
  p7: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
  ANY.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
}

internal
    fun TransferContext.writeMethodArguments_STRING_STRING_LONG_LONG_CALLABLE_CALLABLE_ANY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: Long,
  p3: Long,
  p4: Callable,
  p5: Callable,
  p6: Any?,
  p7: Long,
  p8: Long,
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_LONG_DOUBLE_DOUBLE_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  CALLABLE.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector2Array,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_CALLABLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Callable,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  CALLABLE.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Boolean,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Boolean,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_RECT2_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Long,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_PACKED_STRING_ARRAY_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: PackedStringArray,
  p3: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  PACKED_STRING_ARRAY.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_STRING_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: String,
  p3: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
}

internal
    fun TransferContext.writeMethodArguments_STRING_STRING_STRING_BOOL_LONG_PACKED_STRING_ARRAY_CALLABLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: String,
  p3: Boolean,
  p4: Long,
  p5: PackedStringArray,
  p6: Callable,
  p7: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
  PACKED_STRING_ARRAY.toGodot(buffer, p5)
  CALLABLE.toGodot(buffer, p6)
  LONG.write(buffer, p7)
}

internal
    fun TransferContext.writeMethodArguments_STRING_STRING_STRING_STRING_BOOL_LONG_PACKED_STRING_ARRAY_ARRAY_CALLABLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: String,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  _RID.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RECT2I_OBJECT_COLOR_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RECT2I_ARRAY_ARRAY_COLOR_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedByteArray,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_BOOL_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Boolean,
  p2: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Boolean,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Boolean,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_ARRAY_OBJECT_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: GodotObject?,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ARRAY.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_PACKED_STRING_ARRAY_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedStringArray,
  p1: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_STRING_ARRAY.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_ANY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: PackedByteArray,
  p3: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_STRING_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: String,
  p2: String,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_STRING_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_PACKED_STRING_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: PackedStringArray,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal
    fun TransferContext.writeMethodArguments_DICTIONARY_LONG_DOUBLE_TRANSFORM2D_LONG_LONG_LONG_LONG_DOUBLE_LONG_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_DOUBLE_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Double,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_DOUBLE_LONG_LONG_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Double,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
  p7: Long,
  p8: Long,
): Unit {
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
}

internal
    fun TransferContext.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_COLOR_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_COLOR_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_VECTOR2_STRING_LONG_DOUBLE_LONG_LONG_LONG_COLOR_LONG_LONG_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_LONG_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_LONG_LONG_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector2,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Color,
  p6: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  COLOR.toGodot(buffer, p5)
  DOUBLE.write(buffer, p6)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Vector2i,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_VECTOR2I_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_ARRAY_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
  args: Array<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, args.size)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
}

internal fun TransferContext.writeMethodArguments_PACKED_FLOAT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedFloat64Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_FLOAT_64_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_STRING_OBJECT_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: GodotObject?,
  p2: Long,
  p3: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_STRING_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: String,
  p2: GodotObject?,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_DOUBLE_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Double,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_NODE_PATH_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: NodePath,
  p2: GodotObject?,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  NODE_PATH.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  TRANSFORM3D.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Quaternion,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  QUATERNION.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_NODE_PATH_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: NodePath,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_BASIS(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Basis,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  BASIS.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM2D_VECTOR2_COLOR_COLOR_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_TRANSFORM3D_VECTOR3_COLOR_COLOR_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Vector2,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2_VECTOR2_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2_VECTOR2_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
  p3: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  VECTOR2.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Vector2,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector2Array,
  p1: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector2Array,
  p1: Double,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_DOUBLE_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector2Array,
  p1: Double,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_DOUBLE_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Double,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_DOUBLE_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Double,
  p2: Long,
  p3: Long,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  VECTOR3.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_VECTOR3_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Vector3,
  p4: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  VECTOR3.toGodot(buffer, p3)
  VECTOR3.toGodot(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: Vector3,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: Double,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY_PLANE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector3Array,
  p1: Plane,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  PLANE.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DOUBLE.write(buffer, p0)
  COLOR.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  COLOR.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_LONG_STRING_NAME_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Long,
  p2: StringName,
  p3: Long,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_LONG_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_LONG_STRING_NAME_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
}

internal
    fun TransferContext.writeMethodArguments_LONG_BOOL_LONG_COLOR_BOOL_LONG_COLOR_OBJECT_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  ANY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR3I_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3i,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR3I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR3I.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_VECTOR3I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3i,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Boolean,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_PACKED_STRING_ARRAY_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: String,
  p2: PackedStringArray,
  p3: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  PACKED_STRING_ARRAY.toGodot(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_PACKED_STRING_ARRAY_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: String,
  p2: PackedStringArray,
  p3: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  PACKED_STRING_ARRAY.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_PACKED_STRING_ARRAY_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: PackedStringArray,
  p2: Long,
  p3: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_PACKED_STRING_ARRAY_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: PackedStringArray,
  p2: Long,
  p3: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_OBJECT_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_BOOL_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_BOOL_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Boolean,
  p2: Boolean,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  DOUBLE.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_BOOL_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Boolean,
  p1: Boolean,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  BOOL.write(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Boolean,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_RECT2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Rect2i,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  RECT2I.toGodot(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT_RECT2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RECT2I_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Rect2i,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  RECT2I.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  COLOR.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_BOOL_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Boolean,
  p5: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  BOOL.write(buffer, p4)
  ARRAY.toGodot(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_PLANE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Plane,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PLANE.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_ARRAY_ARRAY_DICTIONARY_OBJECT_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_DOUBLE_DOUBLE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Double,
  p2: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_ARRAY_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: GodotObject?,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal
    fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_STRING_NAME_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: StringName,
  p3: StringName,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
  DOUBLE.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Boolean,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM2D_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform2D,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  TRANSFORM2D.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING_NAME_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: StringName,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_BOOL_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Boolean,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: GodotObject?,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  RECT2.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_QUATERNION(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Quaternion,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  QUATERNION.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  ANY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_ANY_STRING_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
  p1: String,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ANY.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_ANY_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Any?,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_ANY_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ANY.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: String,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  args: Array<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1 + args.size)
  STRING.toGodot(buffer, p0)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: String,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_NODE_PATH_RECT2_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_PLANE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Plane,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PLANE.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_FLOAT_32_ARRAY_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedFloat32Array,
  p1: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_OBJECT_STRING_NAME_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: GodotObject?,
  p2: StringName,
  p3: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  ARRAY.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_OBJECT_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_STRING_RID_ANY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: String,
  p2: RID,
  p3: Any?,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
  ANY.toGodot(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: String,
  p2: Callable,
  p3: Callable,
  p4: Any?,
  p5: Long,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  ANY.toGodot(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
}

internal fun TransferContext.writeMethodArguments_RID_OBJECT_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: GodotObject?,
  p2: String,
  p3: Callable,
  p4: Callable,
  p5: Any?,
  p6: Long,
  p7: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  _RID.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
  ANY.toGodot(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
}

internal
    fun TransferContext.writeMethodArguments_RID_STRING_LONG_LONG_CALLABLE_CALLABLE_ANY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: String,
  p2: Long,
  p3: Long,
  p4: Callable,
  p5: Callable,
  p6: Any?,
  p7: Long,
  p8: Long,
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  _RID.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT_OBJECT_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector2Array,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_FLOAT_32_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedFloat32Array,
  p1: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_ARRAY_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ARRAY.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector3Array,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedInt64Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  PACKED_INT_64_ARRAY.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  LONG.write(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_VECTOR2_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector2,
  p2: Vector2,
  p3: Boolean,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector2Array,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR3_VECTOR3_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector3,
  p2: Vector3,
  p3: Boolean,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR3_VECTOR3_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector3,
  p2: Vector3,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_VECTOR3_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedVector3Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector3Array,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Boolean,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Boolean,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: VariantArray<*>,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_NAME_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: StringName,
  p2: Long,
  p3: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  args: Array<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1 + args.size)
  STRING_NAME.toGodot(buffer, p0)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: StringName,
  args: Array<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2 + args.size)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  for (arg in args) {
    ANY.toGodot(buffer, arg)
  }
}

internal fun TransferContext.writeMethodArguments_OBJECT_LONG_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Long,
  p2: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  TRANSFORM3D.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_BOOL_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Boolean,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_BOOL_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Boolean,
  p4: Double,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Boolean,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Boolean,
  p4: Double,
  p5: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  DOUBLE.write(buffer, p4)
  BOOL.write(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: Long,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_STRING_STRING_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: String,
  p3: String,
  p4: Long,
  p5: Long,
  p6: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  BOOL.write(buffer, p6)
}

internal fun TransferContext.writeMethodArguments_STRING_PACKED_STRING_ARRAY_ARRAY_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: PackedStringArray,
  p2: VariantArray<*>,
  p3: Boolean,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  BOOL.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_STRING_PACKED_STRING_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: PackedStringArray,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_BOOL_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Boolean,
  p1: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  BOOL.write(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_NODE_PATH_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: NodePath,
  p1: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_CALLABLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Callable,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: Long,
  p3: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING_NAME.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: String,
  p2: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_STRING_STRING_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_TRANSFORM3D_PACKED_VECTOR2_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform3D,
  p1: PackedVector2Array,
  p2: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  TRANSFORM3D.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  PACKED_INT_32_ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM3D_RID_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform3D,
  p1: RID,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  TRANSFORM3D.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_RID_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: RID,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_ARRAY_OBJECT_OBJECT_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: VariantArray<*>,
  p2: GodotObject?,
  p3: GodotObject?,
  p4: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  CALLABLE.toGodot(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_ARRAY_OBJECT_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_ARRAY_OBJECT_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: GodotObject?,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_ARRAY_OBJECT_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: VariantArray<*>,
  p2: GodotObject?,
  p3: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_INT_64_ARRAY_OBJECT_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedInt64Array,
  p2: GodotObject?,
  p3: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  PACKED_INT_64_ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  CALLABLE.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_ARRAY_PACKED_INT_64_ARRAY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: VariantArray<*>,
  p2: PackedInt64Array,
  p3: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  PACKED_INT_64_ARRAY.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_ARRAY_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: VariantArray<*>,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: String,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_STRING_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Long,
  p2: String,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_PACKED_BYTE_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: PackedByteArray,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: String,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: String,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM3D_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform3D,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  TRANSFORM3D.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_CALLABLE_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Boolean,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM2D_VECTOR2_OBJECT_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform2D,
  p1: Vector2,
  p2: GodotObject?,
  p3: Double,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  TRANSFORM2D.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_BOOL_DOUBLE_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Boolean,
  p2: Double,
  p3: Boolean,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  VECTOR3.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM3D_VECTOR3_OBJECT_DOUBLE_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform3D,
  p1: Vector3,
  p2: GodotObject?,
  p3: Double,
  p4: Boolean,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  TRANSFORM3D.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  BOOL.write(buffer, p4)
  LONG.write(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_VECTOR2_VECTOR2_LONG_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Vector2,
  p2: Long,
  p3: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR2.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  ARRAY.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_LONG_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: Long,
  p3: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  ARRAY.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_RID_TRANSFORM2D_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_BOOL_DOUBLE_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector2,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_CALLABLE_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Callable,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_OBJECT_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: GodotObject?,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_VECTOR2_VECTOR2_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_VECTOR2_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_TRANSFORM3D_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  TRANSFORM3D.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR3_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector3,
  p2: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Vector3,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR3.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_RID_VECTOR3_RID_VECTOR3(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_TRANSFORM3D_RID_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_NODE_PATH_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: NodePath,
  p1: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  NODE_PATH.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedVector2Array,
  p1: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p0)
  PACKED_INT_32_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_STRING_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Long,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: GodotObject?,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_LONG_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_PACKED_STRING_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: PackedStringArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING_NAME.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Boolean,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_BOOL_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: Boolean,
  p3: Long,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal
    fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_VECTOR2I_LONG_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_OBJECT_OBJECT_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: GodotObject?,
  p3: GodotObject?,
  p4: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
  BOOL.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: StringName,
  p3: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
  OBJECT.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
}

internal
    fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  OBJECT.toGodot(buffer, p6)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_OBJECT_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: GodotObject?,
  p2: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_RID_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: RID,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  OBJECT.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_LONG_LONG_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
}

internal
    fun TransferContext.writeMethodArguments_RID_RID_VECTOR3_VECTOR3_VECTOR3_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: RID,
  p2: Vector3,
  p3: Vector3,
  p4: Vector3,
  p5: Long,
  p6: Long,
  p7: Long,
  p8: Long,
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_RID_COLOR_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Color,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_ARRAY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_ARRAY_ARRAY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_ARRAY_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: VariantArray<*>,
  p3: PackedInt64Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  PACKED_INT_64_ARRAY.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_PACKED_BYTE_ARRAY_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: PackedByteArray,
  p3: Boolean,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_BYTE_ARRAY.toGodot(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_BYTE_ARRAY_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedByteArray,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_ARRAY_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: RID,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ARRAY.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_RID_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: RID,
  p2: Long,
  p3: Long,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_LONG_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_CALLABLE_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Callable,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal
    fun TransferContext.writeMethodArguments_RID_LONG_LONG_LONG_OBJECT_OBJECT_OBJECT_OBJECT_LONG_LONG_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_RID_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_ARRAY_ARRAY_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: VariantArray<*>,
  p2: VariantArray<*>,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ARRAY.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_LONG_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Long,
  p3: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  PACKED_INT_32_ARRAY.toGodot(buffer, p3)
}

internal
    fun TransferContext.writeMethodArguments_RID_LONG_PACKED_COLOR_ARRAY_DOUBLE_LONG_RECT2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: PackedColorArray,
  p3: Double,
  p4: Long,
  p5: Rect2,
  p6: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_COLOR_ARRAY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
  LONG.write(buffer, p4)
  RECT2.toGodot(buffer, p5)
  LONG.write(buffer, p6)
}

internal
    fun TransferContext.writeMethodArguments_RID_LONG_LONG_LONG_LONG_LONG_PACKED_COLOR_ARRAY_DOUBLE_LONG_RECT2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
): Unit {
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
}

internal fun TransferContext.writeMethodArguments_LONG_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: RID,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  _RID.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_ARRAY_PACKED_INT_64_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL_RID_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_RID_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_LONG_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Long,
  p3: Long,
  p4: Long,
  p5: Long,
  p6: Long,
  p7: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 8)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
  LONG.write(buffer, p6)
  LONG.write(buffer, p7)
}

internal fun TransferContext.writeMethodArguments_RID_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_ARRAY_RECT2I_RID_COLOR_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_STRING_NAME_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: StringName,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: StringName,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_ARRAY_ARRAY_DICTIONARY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_AABB(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: AABB,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  godot.core.VariantParser.AABB.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_LONG_BOOL_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  COLOR.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_FLOAT_32_ARRAY_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedFloat32Array,
  p2: PackedFloat32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_TRANSFORM3D_AABB_VECTOR3I_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: RID,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal
    fun TransferContext.writeMethodArguments_RID_PACKED_VECTOR3_ARRAY_PACKED_COLOR_ARRAY_PACKED_INT_32_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Boolean,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_TRANSFORM3D_VECTOR3_COLOR_COLOR_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Callable,
  p2: Callable,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  CALLABLE.toGodot(buffer, p1)
  CALLABLE.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_VECTOR3_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedVector3Array,
  p2: PackedInt32Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR3_ARRAY.toGodot(buffer, p1)
  PACKED_INT_32_ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_VECTOR2_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RECT2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Rect2,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_RID_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: RID,
  p2: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_RID_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_BOOL_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Double,
  p2: Boolean,
  p3: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_BASIS(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Basis,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  BASIS.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_COLOR_LONG_DOUBLE_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_BOOL_PACKED_FLOAT_32_ARRAY_DOUBLE_DOUBLE_DOUBLE_DOUBLE_LONG_DOUBLE_DOUBLE_DOUBLE_DOUBLE_RID(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_DOUBLE_DOUBLE_DOUBLE_BOOL_RID(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_LONG_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_BOOL_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_BOOL_COLOR_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_BOOL_LONG_DOUBLE_LONG_BOOL_DOUBLE_BOOL_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_BOOL_DOUBLE_COLOR_COLOR_DOUBLE_DOUBLE_DOUBLE_DOUBLE_DOUBLE_BOOL_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL_DOUBLE_LONG_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Boolean,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_BOOL_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Boolean,
  p1: Double,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  BOOL.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_DOUBLE_DOUBLE_BOOL_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Double,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_DOUBLE_DOUBLE_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_RECT2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_AABB_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: AABB,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  godot.core.VariantParser.AABB.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_VECTOR3_VECTOR3_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector3,
  p1: Vector3,
  p2: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR3.toGodot(buffer, p0)
  VECTOR3.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_ARRAY_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: VariantArray<*>,
  p1: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  ARRAY.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_ARRAY_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: VariantArray<*>,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_RID_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: RID,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector2,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Color,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Boolean,
  p2: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  RECT2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_VECTOR2_COLOR_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RECT2_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_DOUBLE_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_DOUBLE_DOUBLE_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RECT2_RID_BOOL_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RECT2_RID_RECT2_COLOR_LONG_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RECT2_RID_RECT2_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RECT2_RID_RECT2_COLOR_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_RECT2_RECT2_RID_VECTOR2_VECTOR2_LONG_LONG_BOOL_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_PACKED_VECTOR2_ARRAY_RID(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_PACKED_INT_32_ARRAY_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_PACKED_VECTOR2_ARRAY_PACKED_INT_32_ARRAY_PACKED_FLOAT_32_ARRAY_RID_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_TRANSFORM2D_COLOR_RID(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_RID(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: RID,
  p2: RID,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  _RID.toGodot(buffer, p1)
  _RID.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_BOOL_RECT2_CALLABLE_CALLABLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_DOUBLE_BOOL_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_VECTOR2_ARRAY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedVector2Array,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_LONG_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: Long,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_COLOR_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_COLOR_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: String,
  p2: Boolean,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  STRING.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_COLOR_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_OBJECT_DOUBLE_DOUBLE_COLOR_LONG_RECT2_ANY_BOOL_STRING_LONG_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_ANY_LONG_OBJECT_DOUBLE_DOUBLE_COLOR_LONG_RECT2_BOOL_STRING_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_STRING_LONG_LONG_PACKED_FLOAT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_BOOL_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_ANY_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  ANY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_OBJECT_LONG_RECT2_COLOR_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_COLOR_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Color,
  p1: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  COLOR.toGodot(buffer, p0)
  COLOR.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Dictionary<*, *>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  DICTIONARY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_LONG_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: Long,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_DOUBLE_BOOL_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Boolean,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  DOUBLE.write(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME_VARARG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: StringName,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: String,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: NodePath,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  NODE_PATH.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_OBJECT_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: GodotObject?,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM2D_OBJECT_TRANSFORM2D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform2D,
  p1: GodotObject?,
  p2: Transform2D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  TRANSFORM2D.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  TRANSFORM2D.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_TRANSFORM2D_VECTOR2_OBJECT_TRANSFORM2D_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Transform2D,
  p1: Vector2,
  p2: GodotObject?,
  p3: Transform2D,
  p4: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  TRANSFORM2D.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
  TRANSFORM2D.toGodot(buffer, p3)
  VECTOR2.toGodot(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_LONG_TRANSFORM2D_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: StringName,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_TRANSFORM3D_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_DOUBLE_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Double,
  p1: Double,
  p2: Double,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  DOUBLE.write(buffer, p0)
  DOUBLE.write(buffer, p1)
  DOUBLE.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_TRANSFORM3D(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: Transform3D,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  STRING.toGodot(buffer, p0)
  TRANSFORM3D.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL_NODE_PATH_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_NODE_PATH(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: NodePath,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  NODE_PATH.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_OBJECT_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_LONG_OBJECT_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2,
  p1: Rect2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2.toGodot(buffer, p0)
  RECT2.toGodot(buffer, p1)
}

internal
    fun TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY_PACKED_VECTOR2_ARRAY_PACKED_COLOR_ARRAY_PACKED_VECTOR2_ARRAY_PACKED_VECTOR3_ARRAY_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_LONG_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Long,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_LONG_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Boolean,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL_BOOL_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_STRING_OBJECT_LONG_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: GodotObject?,
  p2: Long,
  p3: String,
  p4: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  STRING.toGodot(buffer, p3)
  ANY.toGodot(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_ANY_VECTOR2_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
  p1: Vector2,
  p2: Long,
  p3: Long,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  ANY.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_ANY_VECTOR2_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
  p1: Vector2,
  p2: Long,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  ANY.toGodot(buffer, p0)
  VECTOR2.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  DOUBLE.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_OBJECT_LONG_RECT2_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: String,
  p1: GodotObject?,
  p2: Long,
  p3: Rect2,
  p4: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  STRING.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  RECT2.toGodot(buffer, p3)
  STRING.toGodot(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_COLOR_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_LONG_COLOR_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_BYTE_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedByteArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_BYTE_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_COLOR_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedColorArray,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  _RID.toGodot(buffer, p0)
  PACKED_COLOR_ARRAY.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Vector2i,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2I_LONG_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2I_LONG_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2I_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2I_LONG_RECT2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2I_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_VECTOR2I_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_LONG_VECTOR2_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_LONG_LONG_VECTOR2_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_STRING_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: String,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_VECTOR2_LONG_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_STRING_ARRAY_LONG_DICTIONARY_STRING_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: String,
  p2: VariantArray<*>,
  p3: Long,
  p4: Dictionary<*, *>,
  p5: String,
  p6: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 7)
  _RID.toGodot(buffer, p0)
  STRING.toGodot(buffer, p1)
  ARRAY.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DICTIONARY.toGodot(buffer, p4)
  STRING.toGodot(buffer, p5)
  ANY.toGodot(buffer, p6)
}

internal fun TransferContext.writeMethodArguments_RID_ANY_VECTOR2_LONG_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Any?,
  p2: Vector2,
  p3: Long,
  p4: Long,
  p5: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  LONG.write(buffer, p4)
  DOUBLE.write(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_RID_ANY_VECTOR2_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Any?,
  p2: Vector2,
  p3: Long,
  p4: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
  LONG.write(buffer, p3)
  DOUBLE.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_ARRAY_LONG_DICTIONARY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Double,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_PACKED_FLOAT_32_ARRAY_LONG_BOOL_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: PackedFloat32Array,
  p2: Long,
  p3: Boolean,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  _RID.toGodot(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_DOUBLE_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Double,
  p2: Long,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  _RID.toGodot(buffer, p0)
  DOUBLE.write(buffer, p1)
  LONG.write(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_RID_RID_VECTOR2_DOUBLE_DOUBLE_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RID_VECTOR2_DOUBLE_DOUBLE_LONG_COLOR_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_ARRAY_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: VariantArray<*>,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  ARRAY.toGodot(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_RID_VECTOR2_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RECT2_BOOL_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_RID_RECT2_RECT2_COLOR_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_COLOR(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: StringName,
  p2: Color,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  COLOR.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: StringName,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING_NAME.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_NAME_STRING_NAME_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_BOOL_BOOL_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Boolean,
  p2: Boolean,
  p3: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  BOOL.write(buffer, p1)
  BOOL.write(buffer, p2)
  BOOL.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_PACKED_VECTOR2_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: PackedVector2Array,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  PACKED_VECTOR2_ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Vector2i,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_VECTOR2I_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Vector2i,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Vector2i,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_ARRAY_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Vector2i,
  p3: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  LONG.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  VECTOR2I.toGodot(buffer, p0)
  OBJECT.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_ARRAY_LONG_LONG_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_VECTOR2I_LONG_LONG_VECTOR2I_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_VECTOR2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Vector2i,
  p2: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_VECTOR2I_LONG_VECTOR2I_LONG_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Vector2i,
  p2: Long,
  p3: Vector2i,
  p4: Long,
  p5: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  VECTOR2I.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  LONG.write(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
  LONG.write(buffer, p4)
  VECTOR2I.toGodot(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_OBJECT_VECTOR2I_VECTOR2I_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Vector2i,
  p2: Vector2i,
  p3: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  VECTOR2I.toGodot(buffer, p2)
  VECTOR2I.toGodot(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_VECTOR2I_LONG_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector2i,
  p1: Long,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  VECTOR2I.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_DICTIONARY_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Dictionary<*, *>,
  p1: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  DICTIONARY.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_PACKED_STRING_ARRAY_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: StringName,
  p1: PackedStringArray,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  STRING_NAME.toGodot(buffer, p0)
  PACKED_STRING_ARRAY.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_OBJECT_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Long,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_DOUBLE_DOUBLE_DOUBLE_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_OBJECT_STRING_NAME(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: GodotObject?,
  p2: StringName,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  OBJECT.toGodot(buffer, p1)
  STRING_NAME.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_COLOR_BOOL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Color,
  p2: Boolean,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  COLOR.toGodot(buffer, p1)
  BOOL.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_OBJECT_LONG_BOOL_STRING_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_OBJECT_NODE_PATH_ANY_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: NodePath,
  p2: Any?,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  OBJECT.toGodot(buffer, p0)
  NODE_PATH.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_CALLABLE_ANY_ANY_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Callable,
  p1: Any?,
  p2: Any?,
  p3: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 4)
  CALLABLE.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
  DOUBLE.write(buffer, p3)
}

internal fun TransferContext.writeMethodArguments_SIGNAL(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Signal,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  SIGNAL.toGodot(buffer, p0)
}

internal fun TransferContext.writeMethodArguments_ANY_ANY_DOUBLE_DOUBLE_LONG_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Any?,
  p1: Any?,
  p2: Double,
  p3: Double,
  p4: Long,
  p5: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 6)
  ANY.toGodot(buffer, p0)
  ANY.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
  DOUBLE.write(buffer, p3)
  LONG.write(buffer, p4)
  LONG.write(buffer, p5)
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_STRING_STRING_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: String,
  p3: String,
  p4: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  STRING.toGodot(buffer, p2)
  STRING.toGodot(buffer, p3)
  LONG.write(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_RID_LONG_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: RID,
  p1: Long,
  p2: VariantArray<*>,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  _RID.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  ARRAY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_PACKED_FLOAT_32_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: PackedFloat32Array,
  p2: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  PACKED_FLOAT_32_ARRAY.toGodot(buffer, p1)
  LONG.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_OBJECT_VECTOR2_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_LONG_VECTOR2(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Long,
  p2: Vector2,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  LONG.write(buffer, p1)
  VECTOR2.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_LONG_ANY_ANY(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: Any?,
  p2: Any?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  ANY.toGodot(buffer, p1)
  ANY.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_VECTOR4(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Vector4,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 1)
  VECTOR4.toGodot(buffer, p0)
}

internal
    fun TransferContext.writeMethodArguments_TRANSFORM3D_AABB_VECTOR3_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_INT_32_ARRAY(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_LONG_STRING_OBJECT(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Long,
  p1: String,
  p2: GodotObject?,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  LONG.write(buffer, p0)
  STRING.toGodot(buffer, p1)
  OBJECT.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: PackedByteArray,
  p1: Long,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  PACKED_BYTE_ARRAY.toGodot(buffer, p0)
  LONG.write(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_RECT2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Rect2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  RECT2I.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_VECTOR2I(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Vector2i,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 2)
  OBJECT.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
}

internal fun TransferContext.writeMethodArguments_OBJECT_VECTOR2I_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: GodotObject?,
  p1: Vector2i,
  p2: Double,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  OBJECT.toGodot(buffer, p0)
  VECTOR2I.toGodot(buffer, p1)
  DOUBLE.write(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_CALLABLE_BOOL_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Callable,
  p1: Boolean,
  p2: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 3)
  CALLABLE.toGodot(buffer, p0)
  BOOL.write(buffer, p1)
  STRING.toGodot(buffer, p2)
}

internal fun TransferContext.writeMethodArguments_CALLABLE_LONG_LONG_BOOL_STRING(
  callerPtr: VoidPtr,
  callerId: Long,
  p0: Callable,
  p1: Long,
  p2: Long,
  p3: Boolean,
  p4: String,
): Unit {
  val buffer = beginMethodCall(callerPtr, callerId, 5)
  CALLABLE.toGodot(buffer, p0)
  LONG.write(buffer, p1)
  LONG.write(buffer, p2)
  BOOL.write(buffer, p3)
  STRING.toGodot(buffer, p4)
}

internal fun TransferContext.writeMethodArguments_STRING_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal
    fun TransferContext.writeMethodArguments_RID_RECT2_RECT2I_BOOL_LONG_BOOL_VECTOR2_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_DOUBLE_DOUBLE_DOUBLE_DOUBLE(
  callerPtr: VoidPtr,
  callerId: Long,
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
}

internal fun TransferContext.writeMethodArguments_STRING_NAME_TRANSFORM3D_VECTOR3_VECTOR3_LONG(
  callerPtr: VoidPtr,
  callerId: Long,
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
}
