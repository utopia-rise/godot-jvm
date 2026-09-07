package godot.tests.registration

import godot.annotation.{ColorNoAlpha, Dir, DoubleRange, ExpEasing, Export, File, FloatRange, IntFlag, IntRange, LongRange, MultilineText, PlaceHolderText, Script, Visible}
import godot.api.{Button, NavigationMesh, Node}
import godot.tests.ScalaEnum
import godot.core.{AABB, Basis, BitField, Color, Dictionary, NodePath, PackedByteArray, PackedColorArray, PackedFloat32Array, PackedFloat64Array, PackedInt32Array, PackedInt64Array, PackedStringArray, PackedVector2Array, PackedVector3Array, PackedVector4Array, Plane, Projection, Quaternion, RID, Rect2, Rect2i, StringName, Transform2D, Transform3D, VariantArray, Vector2, Vector2i, Vector3, Vector3i, Vector4, Vector4i}

@Script
class ScalaExport extends Node {
  @Export
  @Visible
  var button: Button = null

  @Export
  @Visible
  var booleanValue: Boolean = true

  @Export
  @Visible
  var byteValue: Byte = 1

  @Export
  @Visible
  var intValue: Int = 1

  @Export
  @Visible
  @IntRange(min = 1, max = 10)
  var intRangeValue: Int = 3

  @Export
  @Visible
  @IntFlag(names = Array("Player", "Enemy", "Npc"))
  var intFlagValue: Int = 0x3

  @Export
  @Visible
  var longValue: Long = 1L

  @Export
  @Visible
  @LongRange(min = 10L, max = 100L)
  var longRangeValue: Long = 42L

  @Export
  @Visible
  var floatValue: Float = 1f

  @Export
  @Visible
  @FloatRange(min = 0.5f, max = 5.5f, step = 0.5f)
  var floatRangeValue: Float = 2.5f

  @Export
  @Visible
  @ExpEasing()
  var easingValue: Float = 0.35f

  @Export
  @Visible
  var doubleValue: Double = 1.0

  @Export
  @Visible
  @DoubleRange(min = 1.25, max = 9.75, step = 0.25)
  var doubleRangeValue: Double = 4.75

  @Export
  @Visible
  var stringValue: String = "scala-export"

  @Export
  @Visible
  @File(extensions = Array("*.gd", "*.gdj"))
  var filePathValue: String = "res://test/core/test_core.gd"

  @Export
  @Visible
  @Dir()
  var directoryPathValue: String = "res://test/core"

  @Export
  @Visible
  @MultilineText()
  var multilineTextValue: String = "Scala export line 1\nScala export line 2"

  @Export
  @Visible
  @PlaceHolderText()
  var placeholderTextValue: String = "placeholder"

  @Export
  @Visible
  var enumValue: ScalaEnum = ScalaEnum.SCALA_ENUM_1

  @Export
  @Visible
  var enumFlagValue: BitField[ScalaEnum] = BitField.of(ScalaEnum.SCALA_ENUM_1, ScalaEnum.SCALA_ENUM_2)

  @Export
  @Visible
  var anyValue: Any = "scala-any"

  @Export
  @Visible
  var vector2: Vector2 = new Vector2(1, 2)

  @Export
  @Visible
  var vector2i: Vector2i = new Vector2i(1, 2)

  @Export
  @Visible
  var rect2: Rect2 = new Rect2(1.0, 2.0, 3.0, 4.0)

  @Export
  @Visible
  var rect2i: Rect2i = new Rect2i(1, 2, 3, 4)

  @Export
  @Visible
  var vector3: Vector3 = new Vector3(1, 2, 3)

  @Export
  @Visible
  var vector3i: Vector3i = new Vector3i(1, 2, 3)

  @Export
  @Visible
  var transform2D: Transform2D = new Transform2D(0, 1, 2, 3, 4, 5)

  @Export
  @Visible
  var vector4: Vector4 = new Vector4(1, 2, 3, 4)

  @Export
  @Visible
  var vector4i: Vector4i = new Vector4i(1, 2, 3, 4)

  @Export
  @Visible
  var plane: Plane = new Plane(1, 2, 3, 4)

  @Export
  @Visible
  var quaternionValue: Quaternion = new Quaternion(1, 2, 3, 4)

  @Export
  @Visible
  var aabb: AABB = new AABB(new Vector3(1, 1, 1), new Vector3(2, 2, 2))

  @Export
  @Visible
  var basisValue: Basis = new Basis(new Vector3(0, 1, 2), new Vector3(3, 4, 5), new Vector3(6, 7, 8))

  @Export
  @Visible
  var transform3D: Transform3D = new Transform3D(
    new Vector3(0, 1, 2),
    new Vector3(3, 4, 5),
    new Vector3(6, 7, 8),
    new Vector3(9, 10, 11)
  )

  @Export
  @Visible
  var projectionValue: Projection = new Projection()

  @Export
  @Visible
  var color: Color = new Color(0.1, 0.2, 0.3, 0.4)

  @Export
  @Visible
  @ColorNoAlpha()
  var colorNoAlpha: Color = new Color(0.6, 0.4, 0.2, 1.0)

  @Export
  @Visible
  var stringName: StringName = new StringName("scala_export")

  @Export
  @Visible
  var nodePath: NodePath = new NodePath("Button")

  @Export
  @Visible
  var rid: RID = new RID()

  @Export
  @Visible
  var resourceTest: NavigationMesh = new NavigationMesh()

  @Export
  @Visible
  var jvmId: Int = 0

  @Export
  @Visible
  var intArray: VariantArray[Integer] = new VariantArray[Integer](classOf[Integer])

  @Export
  @Visible
  var stringArray: VariantArray[String] = new VariantArray[String](classOf[String])

  @Export
  @Visible
  var navMeshes: VariantArray[NavigationMesh] = new VariantArray[NavigationMesh](classOf[NavigationMesh])

  @Export
  @Visible
  var stringToIntDictionary: Dictionary[String, Integer] = new Dictionary[String, Integer](classOf[String], classOf[Integer])

  @Export
  @Visible
  var navMeshesDictionary: Dictionary[String, NavigationMesh] = new Dictionary[String, NavigationMesh](classOf[String], classOf[NavigationMesh])

  @Export
  @Visible
  var packedByteArray: PackedByteArray = new PackedByteArray()

  @Export
  @Visible
  var packedInt32Array: PackedInt32Array = new PackedInt32Array()

  @Export
  @Visible
  var packedInt64Array: PackedInt64Array = new PackedInt64Array()

  @Export
  @Visible
  var packedFloat32Array: PackedFloat32Array = new PackedFloat32Array()

  @Export
  @Visible
  var packedFloat64Array: PackedFloat64Array = new PackedFloat64Array()

  @Export
  @Visible
  var packedStringArray: PackedStringArray = new PackedStringArray()

  @Export
  @Visible
  var packedVector2Array: PackedVector2Array = new PackedVector2Array()

  @Export
  @Visible
  var packedVector3Array: PackedVector3Array = new PackedVector3Array()

  @Export
  @Visible
  var packedVector4Array: PackedVector4Array = new PackedVector4Array()

  @Export
  @Visible
  var packedColorArray: PackedColorArray = new PackedColorArray()

  intArray.add(1)
  intArray.add(2)
  intArray.add(3)

  stringArray.add("one")
  stringArray.add("two")

  navMeshes.add(new NavigationMesh())

  stringToIntDictionary.set("one", 1)
  stringToIntDictionary.set("two", 2)

  navMeshesDictionary.set("AwesomeNavmesh", new NavigationMesh())
}

