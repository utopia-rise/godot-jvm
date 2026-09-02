 package godot.tests.registration

import godot.annotation.ExpEasing
import godot.annotation.Export
import godot.annotation.File
import godot.annotation.FloatRange
import godot.annotation.IntFlag
import godot.annotation.IntRange
import godot.annotation.LongRange
import godot.annotation.MultilineText
import godot.annotation.PlaceHolderText
import godot.annotation.Script
import godot.annotation.Visible
import godot.annotation.ColorNoAlpha
import godot.annotation.Dir
import godot.annotation.DoubleRange
import godot.api.Button
import godot.api.NavigationMesh
import godot.api.Node
import godot.core.AABB
import godot.core.Basis
import godot.core.BitField
import godot.core.Color
import godot.core.Dictionary
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
import godot.core.PackedVector4Array
import godot.core.Plane
import godot.core.Projection
import godot.core.Quaternion
import godot.core.RID
import godot.core.Rect2
import godot.core.Rect2i
import godot.core.StringName
import godot.core.Transform2D
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3
import godot.core.Vector3i
import godot.core.Vector4
import godot.core.Vector4i
import godot.core.variantArrayOf
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias KotlinExportAlias = String
typealias KotlinVector2ExportAlias = Vector2

private val visibleNotNullIntDelegate = Delegates.notNull<Int>()
private val exportNotNullIntDelegate = Delegates.notNull<Int>()

private class ExportIntDelegate(initialValue: Int) : ReadWriteProperty<KotlinExport, Int> {
    private var value = initialValue

    override fun getValue(thisRef: KotlinExport, property: KProperty<*>): Int = value

    override fun setValue(thisRef: KotlinExport, property: KProperty<*>, value: Int) {
        this.value = value
    }
}

private object StaticExportIntDelegate : ReadWriteProperty<KotlinExport, Int> {
    private var value = 60

    override fun getValue(thisRef: KotlinExport, property: KProperty<*>): Int = value

    override fun setValue(thisRef: KotlinExport, property: KProperty<*>, value: Int) {
        this.value = value
    }
}

private object StaticVisibleIntDelegate : ReadWriteProperty<KotlinExport, Int> {
    private var value = 160

    override fun getValue(thisRef: KotlinExport, property: KProperty<*>): Int = value

    override fun setValue(thisRef: KotlinExport, property: KProperty<*>, value: Int) {
        this.value = value
    }
}

@Script
class KotlinExport : Node() {
    enum class KotlinExportEnum {
        ENUM_1,
        ENUM_2,
    }

    @Export
    @Visible
    lateinit var button: Button

    @Export
    @Visible
    var booleanValue = true

    @Export
    @Visible
    var byteValue: Byte = 1

    @Export
    @Visible
    var intValue = 1

    @Export
    val lazyIntValue: Int by lazy { 42 }

    @Visible
    var observableVisibleIntValue: Int by Delegates.observable(110) { _, _, _ -> }

    @Export
    var observableExportIntValue: Int by Delegates.observable(10) { _, _, _ -> }

    @Visible
    var vetoableVisibleIntValue: Int by Delegates.vetoable(120) { _, _, _ -> true }

    @Export
    var vetoableExportIntValue: Int by Delegates.vetoable(20) { _, _, _ -> true }

    @Visible
    var notNullVisibleIntValue: Int by visibleNotNullIntDelegate

    @Export
    var notNullExportIntValue: Int by exportNotNullIntDelegate

    @Visible
    var customDelegateVisibleIntValue: Int by ExportIntDelegate(140)

    @Export
    var customDelegateExportIntValue: Int by ExportIntDelegate(40)

    @Visible
    var staticDelegateVisibleIntValue: Int by StaticVisibleIntDelegate

    @Export
    var staticDelegateExportIntValue: Int by StaticExportIntDelegate

    private var delegatedPropertyVisibleBackingValue = 170
    private var delegatedPropertyExportBackingValue = 70

    @Visible
    var delegatedPropertyReferenceVisibleIntValue: Int by this::delegatedPropertyVisibleBackingValue

    @Export
    var delegatedPropertyReferenceExportIntValue: Int by this::delegatedPropertyExportBackingValue

    private var computedPropertyVisibleBackingValue = 180
    private var computedPropertyExportBackingValue = 80

    @Visible
    var computedVisibleIntValue: Int
        get() = computedPropertyVisibleBackingValue
        set(value) {
            computedPropertyVisibleBackingValue = value
        }

    @IntRange(0, 200)
    var computedExportIntValue: Int
        get() = computedPropertyExportBackingValue
        set(value) {
            computedPropertyExportBackingValue = value
        }

    @Export
    @Visible
    @IntRange(1, 10)
    var intRangeValue = 3

    @Export
    @Visible
    @IntFlag("Player", "Enemy", "Npc")
    var intFlagValue = 0b011

    @Export
    @Visible
    var longValue = 1L

    @Export
    @Visible
    @LongRange(10L, 100L)
    var longRangeValue = 42L

    @Export
    @Visible
    var floatValue = 1f

    @Export
    @Visible
    @FloatRange(0.5f, 5.5f, 0.5f)
    var floatRangeValue = 2.5f

    @Export
    @Visible
    @ExpEasing
    var easingValue = 0.35f

    @Export
    @Visible
    var doubleValue = 1.0

    @Export
    @Visible
    @DoubleRange(1.25, 9.75, 0.25)
    var doubleRangeValue = 4.75

    @Export
    @Visible
    var stringValue = "kotlin-export"

    @Export
    @Visible
    @File("gd", "gdj")
    var filePathValue = "res://test/core/test_core.gd"

    @Export
    @Visible
    @Dir
    var directoryPathValue = "res://test/core"

    @Export
    @Visible
    @MultilineText
    var multilineTextValue = "Kotlin export line 1\nKotlin export line 2"

    @Export
    @Visible
    @PlaceHolderText
    var placeholderTextValue = "placeholder"

    @Export
    @Visible
    var enumValue = KotlinExportEnum.ENUM_1

    @Export
    @Visible
    var enumFlagValue = BitField.of(KotlinExportEnum.ENUM_1, KotlinExportEnum.ENUM_2)

    @Export
    @Visible
    var anyValue: Any = "kotlin-any"

    @Export
    @Visible
    var aliasValue: KotlinExportAlias = "kotlin-alias"

    @Export
    @Visible
    var vector2 = Vector2(1, 2)

    @Export
    var vector2Alias: KotlinVector2ExportAlias = Vector2(3, 4)

    @Export
    @Visible
    var vector2i = Vector2i(1, 2)

    @Export
    @Visible
    var rect2 = Rect2(1.0, 2.0, 3.0, 4.0)

    @Export
    @Visible
    var rect2i = Rect2i(1, 2, 3, 4)

    @Export
    @Visible
    var vector3 = Vector3(1, 2, 3)

    @Export
    @Visible
    var vector3i = Vector3i(1, 2, 3)

    @Export
    @Visible
    var transform2D = Transform2D(0, 1, 2, 3, 4, 5)

    @Export
    @Visible
    var vector4 = Vector4(1, 2, 3, 4)

    @Export
    @Visible
    var vector4i = Vector4i(1, 2, 3, 4)

    @Export
    @Visible
    var plane = Plane(1, 2, 3, 4)

    @Export
    @Visible
    var quaternionValue = Quaternion(1, 2, 3, 4)

    @Export
    @Visible
    var aabb = AABB(Vector3(1, 1, 1), Vector3(2, 2, 2))

    @Export
    @Visible
    var basisValue = Basis(Vector3(0, 1, 2), Vector3(3, 4, 5), Vector3(6, 7, 8))

    @Export
    @Visible
    var transform3D =
        Transform3D(Vector3(0, 1, 2), Vector3(3, 4, 5), Vector3(6, 7, 8), Vector3(9, 10, 11))

    @Export
    @Visible
    var projectionValue = Projection()

    @Export
    @Visible
    var color = Color(0.1, 0.2, 0.3, 0.4)

    @Export
    @Visible
    @ColorNoAlpha
    var colorNoAlpha = Color(0.6, 0.4, 0.2, 1.0)

    @Export
    @Visible
    var stringName = StringName("kotlin_export")

    @Export
    @Visible
    var nodePath = NodePath("CanvasLayer/Button")

    @Export
    @Visible
    var rid = RID()

    @Export
    @Visible
    var resourceTest = NavigationMesh()

    @Export
    @Visible
    var jvmId = 0

    @Export
    @Visible
    var intArray: VariantArray<Int> = variantArrayOf(1, 2, 3)

    @Export
    @Visible
    var stringArray: VariantArray<String> = variantArrayOf("one", "two")

    @Export
    @Visible
    var navMeshes = variantArrayOf(NavigationMesh())

    @Export
    @Visible
    var nullableArray = variantArrayOf<Any?>(NavigationMesh(), null)

    @Export
    @Visible
    var stringToIntDictionary: Dictionary<String, Int> = Dictionary()

    @Export
    @Visible
    var navMeshesDictionary: Dictionary<String, NavigationMesh> = Dictionary()

    @Export
    @Visible
    var nullableDictionary: Dictionary<String, Any?> = Dictionary()

    @Export
    @Visible
    var packedByteArray = PackedByteArray()

    @Export
    @Visible
    var packedInt32Array = PackedInt32Array()

    @Export
    @Visible
    var packedInt64Array = PackedInt64Array()

    @Export
    @Visible
    var packedFloat32Array = PackedFloat32Array()

    @Export
    @Visible
    var packedFloat64Array = PackedFloat64Array()

    @Export
    @Visible
    var packedStringArray = PackedStringArray()

    @Export
    @Visible
    var packedVector2Array = PackedVector2Array()

    @Export
    @Visible
    var packedVector3Array = PackedVector3Array()

    @Export
    @Visible
    var packedVector4Array = PackedVector4Array()

    @Export
    @Visible
    var packedColorArray = PackedColorArray()

    init {
        notNullVisibleIntValue = 130
        notNullExportIntValue = 30

        stringToIntDictionary["one"] = 1
        stringToIntDictionary["two"] = 2

        navMeshesDictionary["AwesomeNavmesh"] = NavigationMesh()

        nullableDictionary["notnull"] = NavigationMesh()
        nullableDictionary["null"] = null
    }
}
