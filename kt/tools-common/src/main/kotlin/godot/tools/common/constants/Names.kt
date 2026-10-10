package godot.tools.common.constants


const val GODOT_NIL = "Nil"
const val GODOT_BOOL = "bool"
const val GODOT_INT = "int"
const val GODOT_FLOAT = "float"
const val GODOT_STRING = "String"
const val GODOT_VECTOR2 = "Vector2"
const val GODOT_VECTOR2I = "Vector2i"
const val GODOT_RECT2 = "Rect2"
const val GODOT_RECT2I = "Rect2i"
const val GODOT_VECTOR3 = "Vector3"
const val GODOT_VECTOR3I = "Vector3i"
const val GODOT_TRANSFORM2D = "Transform2D"
const val GODOT_VECTOR4 = "Vector4"
const val GODOT_VECTOR4I = "Vector4i"
const val GODOT_PLANE = "Plane"
const val GODOT_QUATERNION = "Quaternion"
const val GODOT_AABB = "AABB"
const val GODOT_BASIS = "Basis"
const val GODOT_TRANSFORM3D = "Transform3D"
const val GODOT_PROJECTION = "Projection"
const val GODOT_COLOR = "Color"
const val GODOT_STRING_NAME = "StringName"
const val GODOT_NODE_PATH = "NodePath"
const val GODOT_RID = "RID"
const val GODOT_OBJECT = "Object"
const val GODOT_CALLABLE = "Callable"
const val GODOT_SIGNAL = "Signal"
const val GODOT_DICTIONARY = "Dictionary"
const val GODOT_ARRAY = "Array"
const val GODOT_PACKED_BYTE_ARRAY = "PackedByteArray"
const val GODOT_PACKED_INT32_ARRAY = "PackedInt32Array"
const val GODOT_PACKED_INT64_ARRAY = "PackedInt64Array"
const val GODOT_PACKED_FLOAT32_ARRAY = "PackedFloat32Array"
const val GODOT_PACKED_FLOAT64_ARRAY = "PackedFloat64Array"
const val GODOT_PACKED_STRING_ARRAY = "PackedStringArray"
const val GODOT_PACKED_VECTOR2_ARRAY = "PackedVector2Array"
const val GODOT_PACKED_VECTOR3_ARRAY = "PackedVector3Array"
const val GODOT_PACKED_COLOR_ARRAY = "PackedColorArray"
const val GODOT_PACKED_VECTOR4_ARRAY = "PackedVector4Array"

// Common Godot Object and Node types
const val GODOT_REF_COUNTED = "RefCounted"
const val GODOT_RESOURCE = "Resource"
const val GODOT_NODE = "Node"
const val GODOT_NODE_2D = "Node2D"
const val GODOT_NODE_3D = "Node3D"
const val GODOT_CANVAS_ITEM = "CanvasItem"
const val GODOT_CONTROL = "Control"
const val GODOT_SCRIPT = "Script"
const val GODOT_MULTIPLAYER_API = "MultiplayerAPI"
const val GODOT_MULTIPLAYER_PEER = "MultiplayerPeer"

val lifecycleFunctions = listOf(
    "_ready",
    "_enterTree",
    "_exitTree",
    "_process",
    "_physicsProcess",
    "_input",
    "_unhandledInput",
    "_draw",
)

val rpcModeDisabled = "$godotApiPackage.MultiplayerAPI.DISABLED"
val transferModeUnreliableOrdered = "$godotApiPackage.MultiplayerPeer.UNRELIABLE_ORDERED"
val variantParser = "VariantParser"
val variantCaster = "VariantCaster"
