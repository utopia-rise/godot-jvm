// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_VECTOR2I
import godot.callPtrMethod_VECTOR2I
import godot.callPtrMethod_VECTOR2I_BOOL
import godot.callPtrMethod_VECTOR2I_LONG_VECTOR2I_LONG
import godot.callPtrMethod_VECTOR2I_ret_BOOL
import godot.callPtrMethod_VECTOR2I_ret_LONG
import godot.callPtrMethod_VECTOR2I_ret_VECTOR2I
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.VariantArray
import godot.core.Vector2i
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This resource holds a set of cells to help bulk manipulations of [TileMap].
 *
 * A pattern always starts at the `(0, 0)` coordinates and cannot have cells with negative
 * coordinates.
 */
@GodotBaseType
public open class TileMapPattern : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(759, scriptPtr)
  }

  /**
   * Sets the tile identifiers for the cell at coordinates [coords]. See [TileMap.setCell].
   */
  @JvmOverloads
  public final fun setCell(
    coords: Vector2i,
    sourceId: Int = -1,
    atlasCoords: Vector2i = Vector2i(-1, -1),
    alternativeTile: Int = -1,
  ): Unit {
    TransferContext.callPtrMethod_VECTOR2I_LONG_VECTOR2I_LONG(ptr, objectID.id, MethodBindings.setCellPtr, coords, sourceId.toLong(), atlasCoords, alternativeTile.toLong())
  }

  /**
   * Returns whether the pattern has a tile at the given coordinates.
   */
  public final fun hasCell(coords: Vector2i): Boolean =
      TransferContext.callPtrMethod_VECTOR2I_ret_BOOL(ptr, objectID.id, MethodBindings.hasCellPtr, coords)

  /**
   * Remove the cell at the given coordinates.
   */
  public final fun removeCell(coords: Vector2i, updateSize: Boolean): Unit {
    TransferContext.callPtrMethod_VECTOR2I_BOOL(ptr, objectID.id, MethodBindings.removeCellPtr, coords, updateSize)
  }

  /**
   * Returns the tile source ID of the cell at [coords].
   */
  public final fun getCellSourceId(coords: Vector2i): Int =
      TransferContext.callPtrMethod_VECTOR2I_ret_LONG(ptr, objectID.id, MethodBindings.getCellSourceIdPtr, coords).toInt()

  /**
   * Returns the tile atlas coordinates ID of the cell at [coords].
   */
  public final fun getCellAtlasCoords(coords: Vector2i): Vector2i =
      TransferContext.callPtrMethod_VECTOR2I_ret_VECTOR2I(ptr, objectID.id, MethodBindings.getCellAtlasCoordsPtr, coords)

  /**
   * Returns the tile alternative ID of the cell at [coords].
   */
  public final fun getCellAlternativeTile(coords: Vector2i): Int =
      TransferContext.callPtrMethod_VECTOR2I_ret_LONG(ptr, objectID.id, MethodBindings.getCellAlternativeTilePtr, coords).toInt()

  /**
   * Returns the list of used cell coordinates in the pattern.
   */
  public final fun getUsedCells(): VariantArray<Vector2i> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getUsedCellsPtr) as VariantArray<Vector2i>)

  /**
   * Returns the size, in cells, of the pattern.
   */
  public final fun getSize(): Vector2i =
      TransferContext.callPtrMethod0_ret_VECTOR2I(ptr, objectID.id, MethodBindings.getSizePtr)

  /**
   * Sets the size of the pattern.
   */
  public final fun setSize(size: Vector2i): Unit {
    TransferContext.callPtrMethod_VECTOR2I(ptr, objectID.id, MethodBindings.setSizePtr, size)
  }

  /**
   * Returns whether the pattern is empty or not.
   */
  public final fun isEmpty(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isEmptyPtr)

  public companion object {
    @JvmField
    public val setCellName: MethodStringName4<TileMapPattern, Unit, Vector2i, Int, Vector2i, Int> =
        MethodStringName4<TileMapPattern, Unit, Vector2i, Int, Vector2i, Int>("set_cell")

    @JvmField
    public val hasCellName: MethodStringName1<TileMapPattern, Boolean, Vector2i> =
        MethodStringName1<TileMapPattern, Boolean, Vector2i>("has_cell")

    @JvmField
    public val removeCellName: MethodStringName2<TileMapPattern, Unit, Vector2i, Boolean> =
        MethodStringName2<TileMapPattern, Unit, Vector2i, Boolean>("remove_cell")

    @JvmField
    public val getCellSourceIdName: MethodStringName1<TileMapPattern, Int, Vector2i> =
        MethodStringName1<TileMapPattern, Int, Vector2i>("get_cell_source_id")

    @JvmField
    public val getCellAtlasCoordsName: MethodStringName1<TileMapPattern, Vector2i, Vector2i> =
        MethodStringName1<TileMapPattern, Vector2i, Vector2i>("get_cell_atlas_coords")

    @JvmField
    public val getCellAlternativeTileName: MethodStringName1<TileMapPattern, Int, Vector2i> =
        MethodStringName1<TileMapPattern, Int, Vector2i>("get_cell_alternative_tile")

    @JvmField
    public val getUsedCellsName: MethodStringName0<TileMapPattern, VariantArray<Vector2i>> =
        MethodStringName0<TileMapPattern, VariantArray<Vector2i>>("get_used_cells")

    @JvmField
    public val getSizeName: MethodStringName0<TileMapPattern, Vector2i> =
        MethodStringName0<TileMapPattern, Vector2i>("get_size")

    @JvmField
    public val setSizeName: MethodStringName1<TileMapPattern, Unit, Vector2i> =
        MethodStringName1<TileMapPattern, Unit, Vector2i>("set_size")

    @JvmField
    public val isEmptyName: MethodStringName0<TileMapPattern, Boolean> =
        MethodStringName0<TileMapPattern, Boolean>("is_empty")
  }

  public object MethodBindings {
    internal val setCellPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "set_cell", 2224802556)

    internal val hasCellPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "has_cell", 3900751641)

    internal val removeCellPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "remove_cell", 4153096796)

    internal val getCellSourceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "get_cell_source_id", 2485466453)

    internal val getCellAtlasCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "get_cell_atlas_coords", 3050897911)

    internal val getCellAlternativeTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "get_cell_alternative_tile", 2485466453)

    internal val getUsedCellsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "get_used_cells", 3995934104)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "get_size", 3690982128)

    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "set_size", 1130785943)

    internal val isEmptyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapPattern", "is_empty", 36873697)
  }
}
