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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedInt32Array
import godot.core.PackedVector2Array
import godot.core.Rect2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

@GodotBaseType
public open class PolygonPathFinder : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(564, scriptPtr)
  }

  /**
   * Sets up [PolygonPathFinder] with an array of points that define the vertices of the polygon,
   * and an array of indices that determine the edges of the polygon.
   *
   * The length of [connections] must be even, returns an error if odd.
   *
   * ```gdscript
   * //gdscript
   * var polygon_path_finder = PolygonPathFinder.new()
   * var points = [Vector2(0.0, 0.0), Vector2(1.0, 0.0), Vector2(0.0, 1.0)]
   * var connections = [0, 1, 1, 2, 2, 0]
   * polygon_path_finder.setup(points, connections)
   * ```
   *
   * ```csharp
   * //csharp
   * var polygonPathFinder = new PolygonPathFinder();
   * Vector2[] points =
   * [
   * 	new Vector2(0.0f, 0.0f),
   * 	new Vector2(1.0f, 0.0f),
   * 	new Vector2(0.0f, 1.0f)
   * ];
   * int[] connections = [0, 1, 1, 2, 2, 0];
   * polygonPathFinder.Setup(points, connections);
   * ```
   */
  public final fun setup(points: PackedVector2Array, connections: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points, PACKED_INT_32_ARRAY to connections)
    TransferContext.callMethod(MethodBindings.setupPtr)
  }

  public final fun findPath(from: Vector2, to: Vector2): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to from, VECTOR2 to to)
    TransferContext.callMethod(MethodBindings.findPathPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  public final fun getIntersections(from: Vector2, to: Vector2): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to from, VECTOR2 to to)
    TransferContext.callMethod(MethodBindings.getIntersectionsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  public final fun getClosestPoint(point: Vector2): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to point)
    TransferContext.callMethod(MethodBindings.getClosestPointPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns `true` if [point] falls inside the polygon area.
   *
   * ```gdscript
   * //gdscript
   * var polygon_path_finder = PolygonPathFinder.new()
   * var points = [Vector2(0.0, 0.0), Vector2(1.0, 0.0), Vector2(0.0, 1.0)]
   * var connections = [0, 1, 1, 2, 2, 0]
   * polygon_path_finder.setup(points, connections)
   * print(polygon_path_finder.is_point_inside(Vector2(0.2, 0.2))) # Prints true
   * print(polygon_path_finder.is_point_inside(Vector2(1.0, 1.0))) # Prints false
   * ```
   *
   * ```csharp
   * //csharp
   * var polygonPathFinder = new PolygonPathFinder();
   * Vector2[] points =
   * [
   * 	new Vector2(0.0f, 0.0f),
   * 	new Vector2(1.0f, 0.0f),
   * 	new Vector2(0.0f, 1.0f)
   * ];
   * int[] connections = [0, 1, 1, 2, 2, 0];
   * polygonPathFinder.Setup(points, connections);
   * GD.Print(polygonPathFinder.IsPointInside(new Vector2(0.2f, 0.2f))); // Prints True
   * GD.Print(polygonPathFinder.IsPointInside(new Vector2(1.0f, 1.0f))); // Prints False
   * ```
   */
  public final fun isPointInside(point: Vector2): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to point)
    TransferContext.callMethod(MethodBindings.isPointInsidePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPointPenalty(idx: Int, penalty: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), DOUBLE to penalty.toDouble())
    TransferContext.callMethod(MethodBindings.setPointPenaltyPtr)
  }

  public final fun getPointPenalty(idx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getPointPenaltyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getBounds(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoundsPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public companion object {
    @JvmField
    public val setupName:
        MethodStringName2<PolygonPathFinder, Unit, PackedVector2Array, PackedInt32Array> =
        MethodStringName2<PolygonPathFinder, Unit, PackedVector2Array, PackedInt32Array>("setup")

    @JvmField
    public val findPathName:
        MethodStringName2<PolygonPathFinder, PackedVector2Array, Vector2, Vector2> =
        MethodStringName2<PolygonPathFinder, PackedVector2Array, Vector2, Vector2>("find_path")

    @JvmField
    public val getIntersectionsName:
        MethodStringName2<PolygonPathFinder, PackedVector2Array, Vector2, Vector2> =
        MethodStringName2<PolygonPathFinder, PackedVector2Array, Vector2, Vector2>("get_intersections")

    @JvmField
    public val getClosestPointName: MethodStringName1<PolygonPathFinder, Vector2, Vector2> =
        MethodStringName1<PolygonPathFinder, Vector2, Vector2>("get_closest_point")

    @JvmField
    public val isPointInsideName: MethodStringName1<PolygonPathFinder, Boolean, Vector2> =
        MethodStringName1<PolygonPathFinder, Boolean, Vector2>("is_point_inside")

    @JvmField
    public val setPointPenaltyName: MethodStringName2<PolygonPathFinder, Unit, Int, Float> =
        MethodStringName2<PolygonPathFinder, Unit, Int, Float>("set_point_penalty")

    @JvmField
    public val getPointPenaltyName: MethodStringName1<PolygonPathFinder, Float, Int> =
        MethodStringName1<PolygonPathFinder, Float, Int>("get_point_penalty")

    @JvmField
    public val getBoundsName: MethodStringName0<PolygonPathFinder, Rect2> =
        MethodStringName0<PolygonPathFinder, Rect2>("get_bounds")
  }

  public object MethodBindings {
    internal val setupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonPathFinder", "setup", 3251786936)

    internal val findPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonPathFinder", "find_path", 1562168077)

    internal val getIntersectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonPathFinder", "get_intersections", 3932192302)

    internal val getClosestPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonPathFinder", "get_closest_point", 2656412154)

    internal val isPointInsidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonPathFinder", "is_point_inside", 556197845)

    internal val setPointPenaltyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonPathFinder", "set_point_penalty", 1602489585)

    internal val getPointPenaltyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonPathFinder", "get_point_penalty", 2339986948)

    internal val getBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PolygonPathFinder", "get_bounds", 1639390495)
  }
}
