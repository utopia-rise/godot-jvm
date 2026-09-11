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
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedFloat32Array
import godot.core.PackedVector2Array
import godot.core.Rect2
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2
import kotlin.Any
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Container for parsed source geometry data used in navigation mesh baking.
 */
@GodotBaseType
public open class NavigationMeshSourceGeometryData2D : Resource() {
  public final inline var traversableOutlines: VariantArray<PackedVector2Array>
    @JvmName("traversableOutlinesProperty")
    get() = getTraversableOutlines()
    @JvmName("traversableOutlinesProperty")
    set(`value`) {
      setTraversableOutlines(value)
    }

  public final inline var obstructionOutlines: VariantArray<PackedVector2Array>
    @JvmName("obstructionOutlinesProperty")
    get() = getObstructionOutlines()
    @JvmName("obstructionOutlinesProperty")
    set(`value`) {
      setObstructionOutlines(value)
    }

  public final inline var projectedObstructions: VariantArray<Any?>
    @JvmName("projectedObstructionsProperty")
    get() = getProjectedObstructions()
    @JvmName("projectedObstructionsProperty")
    set(`value`) {
      setProjectedObstructions(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(405, scriptPtr)
  }

  /**
   * Clears the internal data.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Returns `true` when parsed source geometry data exists.
   */
  public final fun hasData(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasDataPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets all the traversable area outlines arrays.
   */
  public final fun setTraversableOutlines(traversableOutlines: VariantArray<PackedVector2Array>):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to traversableOutlines)
    TransferContext.callMethod(MethodBindings.setTraversableOutlinesPtr)
  }

  /**
   * Returns all the traversable area outlines arrays.
   */
  public final fun getTraversableOutlines(): VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTraversableOutlinesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Sets all the obstructed area outlines arrays.
   */
  public final fun setObstructionOutlines(obstructionOutlines: VariantArray<PackedVector2Array>):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to obstructionOutlines)
    TransferContext.callMethod(MethodBindings.setObstructionOutlinesPtr)
  }

  /**
   * Returns all the obstructed area outlines arrays.
   */
  public final fun getObstructionOutlines(): VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getObstructionOutlinesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Appends another array of [traversableOutlines] at the end of the existing traversable outlines
   * array.
   */
  public final fun appendTraversableOutlines(traversableOutlines: VariantArray<PackedVector2Array>):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to traversableOutlines)
    TransferContext.callMethod(MethodBindings.appendTraversableOutlinesPtr)
  }

  /**
   * Appends another array of [obstructionOutlines] at the end of the existing obstruction outlines
   * array.
   */
  public final fun appendObstructionOutlines(obstructionOutlines: VariantArray<PackedVector2Array>):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to obstructionOutlines)
    TransferContext.callMethod(MethodBindings.appendObstructionOutlinesPtr)
  }

  /**
   * Adds the outline points of a shape as traversable area.
   */
  public final fun addTraversableOutline(shapeOutline: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to shapeOutline)
    TransferContext.callMethod(MethodBindings.addTraversableOutlinePtr)
  }

  /**
   * Adds the outline points of a shape as obstructed area.
   */
  public final fun addObstructionOutline(shapeOutline: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to shapeOutline)
    TransferContext.callMethod(MethodBindings.addObstructionOutlinePtr)
  }

  /**
   * Adds the geometry data of another [NavigationMeshSourceGeometryData2D] to the navigation mesh
   * baking data.
   */
  public final fun merge(otherGeometry: NavigationMeshSourceGeometryData2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to otherGeometry)
    TransferContext.callMethod(MethodBindings.mergePtr)
  }

  /**
   * Adds a projected obstruction shape to the source geometry. If [carve] is `true` the carved
   * shape will not be affected by additional offsets (e.g. agent radius) of the navigation mesh baking
   * process.
   */
  public final fun addProjectedObstruction(vertices: PackedVector2Array, carve: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to vertices, BOOL to carve)
    TransferContext.callMethod(MethodBindings.addProjectedObstructionPtr)
  }

  /**
   * Clears all projected obstructions.
   */
  public final fun clearProjectedObstructions(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearProjectedObstructionsPtr)
  }

  /**
   * Sets the projected obstructions with an Array of Dictionaries with the following key value
   * pairs:
   *
   * ```gdscript
   * //gdscript
   * "vertices" : PackedFloat32Array
   * "carve" : bool
   * ```
   */
  public final fun setProjectedObstructions(projectedObstructions: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to projectedObstructions)
    TransferContext.callMethod(MethodBindings.setProjectedObstructionsPtr)
  }

  /**
   * Returns the projected obstructions as an [VariantArray] of dictionaries. Each [Dictionary]
   * contains the following entries:
   *
   * - `vertices` - A [PackedFloat32Array] that defines the outline points of the projected shape.
   *
   * - `carve` - A [Boolean] that defines how the projected shape affects the navigation mesh
   * baking. If `true` the projected shape will not be affected by addition offsets, e.g. agent radius.
   */
  public final fun getProjectedObstructions(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProjectedObstructionsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns an axis-aligned bounding box that covers all the stored geometry data. The bounds are
   * calculated when calling this function with the result cached until further geometry changes are
   * made.
   */
  public final fun getBounds(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoundsPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public companion object {
    @JvmField
    public val clearName: MethodStringName0<NavigationMeshSourceGeometryData2D, Unit> =
        MethodStringName0<NavigationMeshSourceGeometryData2D, Unit>("clear")

    @JvmField
    public val hasDataName: MethodStringName0<NavigationMeshSourceGeometryData2D, Boolean> =
        MethodStringName0<NavigationMeshSourceGeometryData2D, Boolean>("has_data")

    @JvmField
    public val setTraversableOutlinesName:
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<PackedVector2Array>>
        =
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<PackedVector2Array>>("set_traversable_outlines")

    @JvmField
    public val getTraversableOutlinesName:
        MethodStringName0<NavigationMeshSourceGeometryData2D, VariantArray<PackedVector2Array>> =
        MethodStringName0<NavigationMeshSourceGeometryData2D, VariantArray<PackedVector2Array>>("get_traversable_outlines")

    @JvmField
    public val setObstructionOutlinesName:
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<PackedVector2Array>>
        =
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<PackedVector2Array>>("set_obstruction_outlines")

    @JvmField
    public val getObstructionOutlinesName:
        MethodStringName0<NavigationMeshSourceGeometryData2D, VariantArray<PackedVector2Array>> =
        MethodStringName0<NavigationMeshSourceGeometryData2D, VariantArray<PackedVector2Array>>("get_obstruction_outlines")

    @JvmField
    public val appendTraversableOutlinesName:
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<PackedVector2Array>>
        =
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<PackedVector2Array>>("append_traversable_outlines")

    @JvmField
    public val appendObstructionOutlinesName:
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<PackedVector2Array>>
        =
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<PackedVector2Array>>("append_obstruction_outlines")

    @JvmField
    public val addTraversableOutlineName:
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, PackedVector2Array> =
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, PackedVector2Array>("add_traversable_outline")

    @JvmField
    public val addObstructionOutlineName:
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, PackedVector2Array> =
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, PackedVector2Array>("add_obstruction_outline")

    @JvmField
    public val mergeName:
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, NavigationMeshSourceGeometryData2D?>
        =
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, NavigationMeshSourceGeometryData2D?>("merge")

    @JvmField
    public val addProjectedObstructionName:
        MethodStringName2<NavigationMeshSourceGeometryData2D, Unit, PackedVector2Array, Boolean> =
        MethodStringName2<NavigationMeshSourceGeometryData2D, Unit, PackedVector2Array, Boolean>("add_projected_obstruction")

    @JvmField
    public val clearProjectedObstructionsName:
        MethodStringName0<NavigationMeshSourceGeometryData2D, Unit> =
        MethodStringName0<NavigationMeshSourceGeometryData2D, Unit>("clear_projected_obstructions")

    @JvmField
    public val setProjectedObstructionsName:
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<Any?>> =
        MethodStringName1<NavigationMeshSourceGeometryData2D, Unit, VariantArray<Any?>>("set_projected_obstructions")

    @JvmField
    public val getProjectedObstructionsName:
        MethodStringName0<NavigationMeshSourceGeometryData2D, VariantArray<Any?>> =
        MethodStringName0<NavigationMeshSourceGeometryData2D, VariantArray<Any?>>("get_projected_obstructions")

    @JvmField
    public val getBoundsName: MethodStringName0<NavigationMeshSourceGeometryData2D, Rect2> =
        MethodStringName0<NavigationMeshSourceGeometryData2D, Rect2>("get_bounds")
  }

  public object MethodBindings {
    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "clear", 3218959716)

    internal val hasDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "has_data", 2240911060)

    internal val setTraversableOutlinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "set_traversable_outlines", 381264803)

    internal val getTraversableOutlinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "get_traversable_outlines", 3995934104)

    internal val setObstructionOutlinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "set_obstruction_outlines", 381264803)

    internal val getObstructionOutlinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "get_obstruction_outlines", 3995934104)

    internal val appendTraversableOutlinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "append_traversable_outlines", 381264803)

    internal val appendObstructionOutlinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "append_obstruction_outlines", 381264803)

    internal val addTraversableOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "add_traversable_outline", 1509147220)

    internal val addObstructionOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "add_obstruction_outline", 1509147220)

    internal val mergePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "merge", 742424872)

    internal val addProjectedObstructionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "add_projected_obstruction", 3882407395)

    internal val clearProjectedObstructionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "clear_projected_obstructions", 3218959716)

    internal val setProjectedObstructionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "set_projected_obstructions", 381264803)

    internal val getProjectedObstructionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "get_projected_obstructions", 3995934104)

    internal val getBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData2D", "get_bounds", 3248174)
  }
}
