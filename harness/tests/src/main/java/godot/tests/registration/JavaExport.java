package godot.tests.registration;

import godot.annotation.ExpEasing;
import godot.annotation.Export;
import godot.annotation.File;
import godot.annotation.FloatRange;
import godot.annotation.IntFlag;
import godot.annotation.IntRange;
import godot.annotation.LongRange;
import godot.annotation.MultilineText;
import godot.annotation.PlaceHolderText;
import godot.annotation.Script;
import godot.annotation.Visible;
import godot.annotation.ColorNoAlpha;
import godot.annotation.Dir;
import godot.annotation.DoubleRange;
import godot.api.Button;
import godot.api.NavigationMesh;
import godot.api.Node;
import godot.core.AABB;
import godot.core.Basis;
import godot.core.BitField;
import godot.core.Color;
import godot.core.Dictionary;
import godot.core.NodePath;
import godot.core.PackedByteArray;
import godot.core.PackedColorArray;
import godot.core.PackedFloat32Array;
import godot.core.PackedFloat64Array;
import godot.core.PackedInt32Array;
import godot.core.PackedInt64Array;
import godot.core.PackedStringArray;
import godot.core.PackedVector2Array;
import godot.core.PackedVector3Array;
import godot.core.PackedVector4Array;
import godot.core.Plane;
import godot.core.Projection;
import godot.core.Quaternion;
import godot.core.RID;
import godot.core.Rect2;
import godot.core.Rect2i;
import godot.core.StringName;
import godot.core.Transform2D;
import godot.core.Transform3D;
import godot.core.VariantArray;
import godot.core.Vector2;
import godot.core.Vector2i;
import godot.core.Vector3;
import godot.core.Vector3i;
import godot.core.Vector4;
import godot.core.Vector4i;

@Script
public class JavaExport extends Node {
    public enum JavaExportEnum {
        JAVA_EXPORT_ENUM_1,
        JAVA_EXPORT_ENUM_2,
    }

    @Export
    @Visible
    public Button button;

    @Export
    @Visible
    public boolean booleanValue = true;

    @Export
    @Visible
    public byte byteValue = 1;

    @Export
    @Visible
    public int intValue = 1;

    @Export
    @Visible
    @IntRange(min = 1, max = 10)
    public int intRangeValue = 3;

    @Export
    @Visible
    @IntFlag(names = {"Player", "Enemy", "Npc"})
    public int intFlagValue = 0b011;

    @Export
    @Visible
    public long longValue = 1L;

    @Export
    @Visible
    @LongRange(min = 10L, max = 100L)
    public long longRangeValue = 42L;

    @Export
    @Visible
    public float floatValue = 1f;

    @Export
    @Visible
    @FloatRange(min = 0.5f, max = 5.5f, step = 0.5f)
    public float floatRangeValue = 2.5f;

    @Export
    @Visible
    @ExpEasing
    public float easingValue = 0.35f;

    @Export
    @Visible
    public double doubleValue = 1.0;

    @Export
    @Visible
    @DoubleRange(min = 1.25, max = 9.75, step = 0.25)
    public double doubleRangeValue = 4.75;

    @Export
    @Visible
    public String stringValue = "java-export";

    @Export
    @Visible
    @File(extensions = {"*.gd", "*.gdj"})
    public String filePathValue = "res://test/core/test_core.gd";

    @Export
    @Visible
    @Dir
    public String directoryPathValue = "res://test/core";

    @Export
    @Visible
    @MultilineText
    public String multilineTextValue = "Java export line 1\nJava export line 2";

    @Export
    @Visible
    @PlaceHolderText
    public String placeholderTextValue = "placeholder";

    @Export
    @Visible
    public JavaExportEnum enumValue = JavaExportEnum.JAVA_EXPORT_ENUM_1;

    @Export
    @Visible
    public BitField<JavaExportEnum> enumFlagValue =
        BitField.of(JavaExportEnum.JAVA_EXPORT_ENUM_1, JavaExportEnum.JAVA_EXPORT_ENUM_2);

    @Export
    @Visible
    public Object anyValue = "java-any";

    @Export
    @Visible
    public Vector2 vector2 = new Vector2(1, 2);

    @Export
    @Visible
    public Vector2i vector2i = new Vector2i(1, 2);

    @Export
    @Visible
    public Rect2 rect2 = new Rect2(1.0, 2.0, 3.0, 4.0);

    @Export
    @Visible
    public Rect2i rect2i = new Rect2i(1, 2, 3, 4);

    @Export
    @Visible
    public Vector3 vector3 = new Vector3(1, 2, 3);

    @Export
    @Visible
    public Vector3i vector3i = new Vector3i(1, 2, 3);

    @Export
    @Visible
    public Transform2D transform2D = new Transform2D(0, 1, 2, 3, 4, 5);

    @Export
    @Visible
    public Vector4 vector4 = new Vector4(1, 2, 3, 4);

    @Export
    @Visible
    public Vector4i vector4i = new Vector4i(1, 2, 3, 4);

    @Export
    @Visible
    public Plane plane = new Plane(1, 2, 3, 4);

    @Export
    @Visible
    public Quaternion quaternionValue = new Quaternion(1, 2, 3, 4);

    @Export
    @Visible
    public AABB aabb = new AABB(new Vector3(1, 1, 1), new Vector3(2, 2, 2));

    @Export
    @Visible
    public Basis basisValue = new Basis(new Vector3(0, 1, 2), new Vector3(3, 4, 5), new Vector3(6, 7, 8));

    @Export
    @Visible
    public Transform3D transform3D = new Transform3D(
        new Vector3(0, 1, 2),
        new Vector3(3, 4, 5),
        new Vector3(6, 7, 8),
        new Vector3(9, 10, 11)
    );

    @Export
    @Visible
    public Projection projectionValue = new Projection();

    @Export
    @Visible
    public Color color = new Color(0.1, 0.2, 0.3, 0.4);

    @Export
    @Visible
    @ColorNoAlpha
    public Color colorNoAlpha = new Color(0.6, 0.4, 0.2, 1.0);

    @Export
    @Visible
    public StringName stringName = new StringName("java_export");

    @Export
    @Visible
    public NodePath nodePath = new NodePath("Button");

    @Export
    @Visible
    public RID rid = new RID();

    @Export
    @Visible
    public NavigationMesh resourceTest = new NavigationMesh();

    @Export
    @Visible
    public int jvmId = 0;

    @Export
    @Visible
    public VariantArray<Integer> intArray = new VariantArray<>(Integer.class);

    @Export
    @Visible
    public VariantArray<String> stringArray = new VariantArray<>(String.class);

    @Export
    @Visible
    public VariantArray<NavigationMesh> navMeshes = new VariantArray<>(NavigationMesh.class);

    @Export
    @Visible
    public Dictionary<String, Integer> stringToIntDictionary = new Dictionary<>(String.class, Integer.class);

    @Export
    @Visible
    public Dictionary<String, NavigationMesh> navMeshesDictionary = new Dictionary<>(String.class, NavigationMesh.class);

    @Export
    @Visible
    public PackedByteArray packedByteArray = new PackedByteArray();

    @Export
    @Visible
    public PackedInt32Array packedInt32Array = new PackedInt32Array();

    @Export
    @Visible
    public PackedInt64Array packedInt64Array = new PackedInt64Array();

    @Export
    @Visible
    public PackedFloat32Array packedFloat32Array = new PackedFloat32Array();

    @Export
    @Visible
    public PackedFloat64Array packedFloat64Array = new PackedFloat64Array();

    @Export
    @Visible
    public PackedStringArray packedStringArray = new PackedStringArray();

    @Export
    @Visible
    public PackedVector2Array packedVector2Array = new PackedVector2Array();

    @Export
    @Visible
    public PackedVector3Array packedVector3Array = new PackedVector3Array();

    @Export
    @Visible
    public PackedVector4Array packedVector4Array = new PackedVector4Array();

    @Export
    @Visible
    public PackedColorArray packedColorArray = new PackedColorArray();

    public JavaExport() {
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);

        stringArray.add("one");
        stringArray.add("two");

        navMeshes.add(new NavigationMesh());

        stringToIntDictionary.set("one", 1);
        stringToIntDictionary.set("two", 2);

        navMeshesDictionary.set("AwesomeNavmesh", new NavigationMesh());
    }
}

