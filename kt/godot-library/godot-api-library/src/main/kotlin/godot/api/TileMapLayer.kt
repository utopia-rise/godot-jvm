// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedByteArray
import godot.core.RID
import godot.core.Rect2i
import godot.core.Signal0
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.RECT2I
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantParser._RID
import godot.core.Vector2
import godot.core.Vector2i
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Node for 2D tile-based maps. A [TileMapLayer] uses a [TileSet] which contain a list of tiles
 * which are used to create grid-based maps. Unlike the [TileMap] node, which is deprecated,
 * [TileMapLayer] has only one layer of tiles. You can use several [TileMapLayer] to achieve the same
 * result as a [TileMap] node.
 *
 * For performance reasons, all TileMap updates are batched at the end of a frame. Notably, this
 * means that scene tiles from a [TileSetScenesCollectionSource] are initialized after their parent.
 * This is only queued when inside the scene tree.
 *
 * To force an update earlier on, call [updateInternals].
 *
 * **Note:** For performance and compatibility reasons, the coordinates serialized by [TileMapLayer]
 * are limited to 16-bit signed integers, i.e. the range for X and Y coordinates is from `-32768` to
 * `32767`. When saving tile data, tiles outside this range are wrapped.
 */
@GodotBaseType
public open class TileMapLayer : Node2D() {
  /**
   * Emitted when this [TileMapLayer]'s properties changes. This includes modified cells,
   * properties, or changes made to its assigned [TileSet].
   *
   * **Note:** This signal may be emitted very often when batch-modifying a [TileMapLayer]. Avoid
   * executing complex processing in a connected function, and consider delaying it to the end of the
   * frame instead (i.e. calling [Object.callDeferred]).
   */
  public val changed: Signal0 by Signal0

  /**
   * The raw tile map data as a byte array.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tileMapData: PackedByteArray
    @JvmName("tileMapDataProperty")
    get() = getTileMapDataAsArray()
    @JvmName("tileMapDataProperty")
    set(`value`) {
      setTileMapDataFromArray(value)
    }

  /**
   * If `false`, disables this [TileMapLayer] completely (rendering, collision, navigation, scene
   * tiles, etc.)
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = isEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * The [TileSet] used by this layer. The textures, collisions, and additional behavior of all
   * available tiles are stored here.
   */
  public final inline var tileSet: TileSet?
    @JvmName("tileSetProperty")
    get() = getTileSet()
    @JvmName("tileSetProperty")
    set(`value`) {
      setTileSet(value)
    }

  /**
   * Enable or disable light occlusion.
   */
  public final inline var occlusionEnabled: Boolean
    @JvmName("occlusionEnabledProperty")
    get() = isOcclusionEnabled()
    @JvmName("occlusionEnabledProperty")
    set(`value`) {
      setOcclusionEnabled(value)
    }

  /**
   * This Y-sort origin value is added to each tile's Y-sort origin value. This allows, for example,
   * to fake a different height level. This can be useful for top-down view games.
   */
  public final inline var ySortOrigin: Int
    @JvmName("ySortOriginProperty")
    get() = getYSortOrigin()
    @JvmName("ySortOriginProperty")
    set(`value`) {
      setYSortOrigin(value)
    }

  /**
   * If [CanvasItem.ySortEnabled] is enabled, setting this to `true` will reverse the order the
   * tiles are drawn on the X-axis.
   */
  public final inline var xDrawOrderReversed: Boolean
    @JvmName("xDrawOrderReversedProperty")
    get() = isXDrawOrderReversed()
    @JvmName("xDrawOrderReversedProperty")
    set(`value`) {
      setXDrawOrderReversed(value)
    }

  /**
   * The [TileMapLayer]'s rendering quadrant size. A quadrant is a group of tiles to be drawn
   * together on a single canvas item, for optimization purposes. [renderingQuadrantSize] defines the
   * length of a square's side, in the map's coordinate system, that forms the quadrant. Thus, the
   * default quadrant size groups together `16 * 16 = 256` tiles.
   *
   * The quadrant size does not apply on a Y-sorted [TileMapLayer], as tiles are grouped by Y
   * position instead in that case.
   *
   * **Note:** As quadrants are created according to the map's coordinate system, the quadrant's
   * "square shape" might not look like square in the [TileMapLayer]'s local coordinate system.
   */
  public final inline var renderingQuadrantSize: Int
    @JvmName("renderingQuadrantSizeProperty")
    get() = getRenderingQuadrantSize()
    @JvmName("renderingQuadrantSizeProperty")
    set(`value`) {
      setRenderingQuadrantSize(value)
    }

  /**
   * Enable or disable collisions.
   */
  public final inline var collisionEnabled: Boolean
    @JvmName("collisionEnabledProperty")
    get() = isCollisionEnabled()
    @JvmName("collisionEnabledProperty")
    set(`value`) {
      setCollisionEnabled(value)
    }

  /**
   * If `true`, this [TileMapLayer] collision shapes will be instantiated as kinematic bodies. This
   * can be needed for moving [TileMapLayer] nodes (i.e. moving platforms).
   */
  public final inline var useKinematicBodies: Boolean
    @JvmName("useKinematicBodiesProperty")
    get() = isUsingKinematicBodies()
    @JvmName("useKinematicBodiesProperty")
    set(`value`) {
      setUseKinematicBodies(value)
    }

  /**
   * Show or hide the [TileMapLayer]'s collision shapes. If set to [DEBUG_VISIBILITY_MODE_DEFAULT],
   * this depends on the show collision debug settings.
   */
  public final inline var collisionVisibilityMode: DebugVisibilityMode
    @JvmName("collisionVisibilityModeProperty")
    get() = getCollisionVisibilityMode()
    @JvmName("collisionVisibilityModeProperty")
    set(`value`) {
      setCollisionVisibilityMode(value)
    }

  /**
   * The [TileMapLayer]'s physics quadrant size. Within a physics quadrant, cells with similar
   * physics properties are grouped together and their collision shapes get merged.
   * [physicsQuadrantSize] defines the length of a square's side, in the map's coordinate system, that
   * forms the quadrant. Thus, the default quadrant size groups together `16 * 16 = 256` tiles.
   *
   * **Note:** As quadrants are created according to the map's coordinate system, the quadrant's
   * "square shape" might not look like square in the [TileMapLayer]'s local coordinate system.
   *
   * **Note:** This impacts the value returned by [getCoordsForBodyRid]. Higher values will make
   * that function less precise. To get the exact cell coordinates, you need to set
   * [physicsQuadrantSize] to `1`, which disables physics chunking.
   */
  public final inline var physicsQuadrantSize: Int
    @JvmName("physicsQuadrantSizeProperty")
    get() = getPhysicsQuadrantSize()
    @JvmName("physicsQuadrantSizeProperty")
    set(`value`) {
      setPhysicsQuadrantSize(value)
    }

  /**
   * If `true`, navigation regions are enabled.
   */
  public final inline var navigationEnabled: Boolean
    @JvmName("navigationEnabledProperty")
    get() = isNavigationEnabled()
    @JvmName("navigationEnabledProperty")
    set(`value`) {
      setNavigationEnabled(value)
    }

  /**
   * Show or hide the [TileMapLayer]'s navigation meshes. If set to [DEBUG_VISIBILITY_MODE_DEFAULT],
   * this depends on the show navigation debug settings.
   */
  public final inline var navigationVisibilityMode: DebugVisibilityMode
    @JvmName("navigationVisibilityModeProperty")
    get() = getNavigationVisibilityMode()
    @JvmName("navigationVisibilityModeProperty")
    set(`value`) {
      setNavigationVisibilityMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(758, scriptPtr)
  }

  /**
   * This is a helper function for [tileMapData] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = tilemaplayer.tileMapData
   * //Your changes
   * tilemaplayer.tileMapData = myCoreType
   * ``````
   *
   * The raw tile map data as a byte array.
   */
  @CoreTypeHelper
  public final fun tileMapDataMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      tileMapData.apply {
     block(this)
     tileMapData = this
  }

  /**
   * This is a helper function for [tileMapData] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The raw tile map data as a byte array.
   */
  @CoreTypeHelper
  public final fun tileMapDataMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = tileMapData.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     tileMapData = this
  }

  /**
   * Should return `true` if the tile at coordinates [coords] requires a runtime update.
   *
   * **Warning:** Make sure this function only returns `true` when needed. Any tile processed at
   * runtime without a need for it will imply a significant performance penalty.
   *
   * **Note:** If the result of this function should change, use [notifyRuntimeTileDataUpdate] to
   * notify the [TileMapLayer] it needs an update.
   */
  public open fun _useTileDataRuntimeUpdate(coords: Vector2i): Boolean {
    throw NotImplementedError("TileMapLayer::_useTileDataRuntimeUpdate is not implemented.")
  }

  /**
   * Called with a [TileData] object about to be used internally by the [TileMapLayer], allowing its
   * modification at runtime.
   *
   * This method is only called if [_useTileDataRuntimeUpdate] is implemented and returns `true` for
   * the given tile [coords].
   *
   * **Warning:** The [tileData] object's sub-resources are the same as the one in the TileSet.
   * Modifying them might impact the whole TileSet. Instead, make sure to duplicate those resources.
   *
   * **Note:** If the properties of [tileData] object should change over time, use
   * [notifyRuntimeTileDataUpdate] to notify the [TileMapLayer] it needs an update.
   */
  public open fun _tileDataRuntimeUpdate(coords: Vector2i, tileData: TileData?): Unit {
    throw NotImplementedError("TileMapLayer::_tileDataRuntimeUpdate is not implemented.")
  }

  /**
   * Called when this [TileMapLayer]'s cells need an internal update. This update may be caused from
   * individual cells being modified or by a change in the [tileSet] (causing all cells to be queued
   * for an update). The first call to this function is always for initializing all the
   * [TileMapLayer]'s cells. [coords] contains the coordinates of all modified cells, roughly in the
   * order they were modified. [forcedCleanup] is `true` when the [TileMapLayer]'s internals should be
   * fully cleaned up. This is the case when:
   *
   * - The layer is disabled;
   *
   * - The layer is not visible;
   *
   * - [tileSet] is set to `null`;
   *
   * - The node is removed from the tree;
   *
   * - The node is freed.
   *
   * Note that any internal update happening while one of these conditions is verified is considered
   * to be a "cleanup". See also [updateInternals].
   *
   * **Warning:** Implementing this method may degrade the [TileMapLayer]'s performance.
   */
  public open fun _updateCells(coords: VariantArray<Vector2i>, forcedCleanup: Boolean): Unit {
    throw NotImplementedError("TileMapLayer::_updateCells is not implemented.")
  }

  /**
   * Sets the tile identifiers for the cell at coordinates [coords]. Each tile of the [TileSet] is
   * identified using three parts:
   *
   * - The source identifier [sourceId] identifies a [TileSetSource] identifier. See
   * [TileSet.setSourceId],
   *
   * - The atlas coordinate identifier [atlasCoords] identifies a tile coordinates in the atlas (if
   * the source is a [TileSetAtlasSource]). For [TileSetScenesCollectionSource] it should always be
   * `Vector2i(0, 0)`,
   *
   * - The alternative tile identifier [alternativeTile] identifies a tile alternative in the atlas
   * (if the source is a [TileSetAtlasSource]), and the scene for a [TileSetScenesCollectionSource].
   *
   * If [sourceId] is set to `-1`, [atlasCoords] to `Vector2i(-1, -1)`, or [alternativeTile] to
   * `-1`, the cell will be erased. An erased cell gets **all** its identifiers automatically set to
   * their respective invalid values, namely `-1`, `Vector2i(-1, -1)` and `-1`.
   */
  @JvmOverloads
  public final fun setCell(
    coords: Vector2i,
    sourceId: Int = -1,
    atlasCoords: Vector2i = Vector2i(-1, -1),
    alternativeTile: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords, LONG to sourceId.toLong(), VECTOR2I to atlasCoords, LONG to alternativeTile.toLong())
    TransferContext.callMethod(MethodBindings.setCellPtr)
  }

  /**
   * Erases the cell at coordinates [coords].
   */
  public final fun eraseCell(coords: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.eraseCellPtr)
  }

  /**
   * Clears cells containing tiles that do not exist in the [tileSet].
   */
  public final fun fixInvalidTiles(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.fixInvalidTilesPtr)
  }

  /**
   * Clears all cells.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Returns the tile source ID of the cell at coordinates [coords]. Returns `-1` if the cell does
   * not exist.
   */
  public final fun getCellSourceId(coords: Vector2i): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.getCellSourceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the tile atlas coordinates ID of the cell at coordinates [coords]. Returns
   * `Vector2i(-1, -1)` if the cell does not exist.
   */
  public final fun getCellAtlasCoords(coords: Vector2i): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.getCellAtlasCoordsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the tile alternative ID of the cell at coordinates [coords].
   */
  public final fun getCellAlternativeTile(coords: Vector2i): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.getCellAlternativeTilePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [TileData] object associated with the given cell, or `null` if the cell does not
   * exist or is not a [TileSetAtlasSource].
   *
   * ```
   * func get_clicked_tile_power():
   * 	var clicked_cell = tile_map_layer.local_to_map(tile_map_layer.get_local_mouse_position())
   * 	var data = tile_map_layer.get_cell_tile_data(clicked_cell)
   * 	if data:
   * 		return data.get_custom_data("power")
   * 	else:
   * 		return 0
   * ```
   */
  public final fun getCellTileData(coords: Vector2i): TileData? {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.getCellTileDataPtr)
    return (TransferContext.readReturnValue(OBJECT) as TileData?)
  }

  /**
   * Returns `true` if the cell at coordinates [coords] is flipped horizontally. The result is valid
   * only for atlas sources.
   */
  public final fun isCellFlippedH(coords: Vector2i): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.isCellFlippedHPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the cell at coordinates [coords] is flipped vertically. The result is valid
   * only for atlas sources.
   */
  public final fun isCellFlippedV(coords: Vector2i): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.isCellFlippedVPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the cell at coordinates [coords] is transposed. The result is valid only for
   * atlas sources.
   */
  public final fun isCellTransposed(coords: Vector2i): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.isCellTransposedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a [Vector2i] array with the positions of all cells containing a tile. A cell is
   * considered empty if its source identifier equals `-1`, its atlas coordinate identifier is
   * `Vector2(-1, -1)` and its alternative identifier is `-1`.
   */
  public final fun getUsedCells(): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUsedCellsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  /**
   * Returns a [Vector2i] array with the positions of all cells containing a tile. Tiles may be
   * filtered according to their source ([sourceId]), their atlas coordinates ([atlasCoords]), or
   * alternative id ([alternativeTile]).
   *
   * If a parameter has its value set to the default one, this parameter is not used to filter a
   * cell. Thus, if all parameters have their respective default values, this method returns the same
   * result as [getUsedCells].
   *
   * A cell is considered empty if its source identifier equals `-1`, its atlas coordinate
   * identifier is `Vector2(-1, -1)` and its alternative identifier is `-1`.
   */
  @JvmOverloads
  public final fun getUsedCellsById(
    sourceId: Int = -1,
    atlasCoords: Vector2i = Vector2i(-1, -1),
    alternativeTile: Int = -1,
  ): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceId.toLong(), VECTOR2I to atlasCoords, LONG to alternativeTile.toLong())
    TransferContext.callMethod(MethodBindings.getUsedCellsByIdPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  /**
   * Returns a rectangle enclosing the used (non-empty) tiles of the map.
   */
  public final fun getUsedRect(): Rect2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUsedRectPtr)
    return (TransferContext.readReturnValue(RECT2I) as Rect2i)
  }

  /**
   * Creates and returns a new [TileMapPattern] from the given array of cells. See also
   * [setPattern].
   */
  public final fun getPattern(coordsArray: VariantArray<Vector2i>): TileMapPattern? {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to coordsArray)
    TransferContext.callMethod(MethodBindings.getPatternPtr)
    return (TransferContext.readReturnValue(OBJECT) as TileMapPattern?)
  }

  /**
   * Pastes the [TileMapPattern] at the given [position] in the tile map. See also [getPattern].
   */
  public final fun setPattern(position: Vector2i, pattern: TileMapPattern?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position, OBJECT to pattern)
    TransferContext.callMethod(MethodBindings.setPatternPtr)
  }

  /**
   * Update all the cells in the [cells] coordinates array so that they use the given [terrain] for
   * the given [terrainSet]. If an updated cell has the same terrain as one of its neighboring cells,
   * this function tries to join the two. This function might update neighboring tiles if needed to
   * create correct terrain transitions.
   *
   * If [ignoreEmptyTerrains] is `true`, empty terrains will be ignored when trying to find the best
   * fitting tile for the given terrain constraints.
   *
   * **Note:** To work correctly, this method requires the [TileMapLayer]'s TileSet to have terrains
   * set up with all required terrain combinations. Otherwise, it may produce unexpected results.
   */
  @JvmOverloads
  public final fun setCellsTerrainConnect(
    cells: VariantArray<Vector2i>,
    terrainSet: Int,
    terrain: Int,
    ignoreEmptyTerrains: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to cells, LONG to terrainSet.toLong(), LONG to terrain.toLong(), BOOL to ignoreEmptyTerrains)
    TransferContext.callMethod(MethodBindings.setCellsTerrainConnectPtr)
  }

  /**
   * Update all the cells in the [path] coordinates array so that they use the given [terrain] for
   * the given [terrainSet]. The function will also connect two successive cell in the path with the
   * same terrain. This function might update neighboring tiles if needed to create correct terrain
   * transitions.
   *
   * If [ignoreEmptyTerrains] is `true`, empty terrains will be ignored when trying to find the best
   * fitting tile for the given terrain constraints.
   *
   * **Note:** To work correctly, this method requires the [TileMapLayer]'s TileSet to have terrains
   * set up with all required terrain combinations. Otherwise, it may produce unexpected results.
   */
  @JvmOverloads
  public final fun setCellsTerrainPath(
    path: VariantArray<Vector2i>,
    terrainSet: Int,
    terrain: Int,
    ignoreEmptyTerrains: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to path, LONG to terrainSet.toLong(), LONG to terrain.toLong(), BOOL to ignoreEmptyTerrains)
    TransferContext.callMethod(MethodBindings.setCellsTerrainPathPtr)
  }

  /**
   * Returns whether the provided [body] [RID] belongs to one of this [TileMapLayer]'s cells.
   */
  public final fun hasBodyRid(body: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.hasBodyRidPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the coordinates of the physics quadrant (see [physicsQuadrantSize]) for given physics
   * body [RID]. Such an [RID] can be retrieved from [KinematicCollision2D.getColliderRid], when
   * colliding with a tile.
   *
   * **Note:** Higher values of [physicsQuadrantSize] will make this function less precise. To get
   * the exact cell coordinates, you need to set [physicsQuadrantSize] to `1`, which disables physics
   * chunking.
   */
  public final fun getCoordsForBodyRid(body: RID): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to body)
    TransferContext.callMethod(MethodBindings.getCoordsForBodyRidPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Triggers a direct update of the [TileMapLayer]. Usually, calling this function is not needed,
   * as [TileMapLayer] node updates automatically when one of its properties or cells is modified.
   *
   * However, for performance reasons, those updates are batched and delayed to the end of the
   * frame. Calling this function will force the [TileMapLayer] to update right away instead.
   *
   * **Warning:** Updating the [TileMapLayer] is computationally expensive and may impact
   * performance. Try to limit the number of updates and how many tiles they impact.
   */
  public final fun updateInternals(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.updateInternalsPtr)
  }

  /**
   * Notifies the [TileMapLayer] node that calls to [_useTileDataRuntimeUpdate] or
   * [_tileDataRuntimeUpdate] will lead to different results. This will thus trigger a [TileMapLayer]
   * update.
   *
   * **Warning:** Updating the [TileMapLayer] is computationally expensive and may impact
   * performance. Try to limit the number of calls to this function to avoid unnecessary update.
   *
   * **Note:** This does not trigger a direct update of the [TileMapLayer], the update will be done
   * at the end of the frame as usual (unless you call [updateInternals]).
   */
  public final fun notifyRuntimeTileDataUpdate(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.notifyRuntimeTileDataUpdatePtr)
  }

  /**
   * Returns for the given coordinates [coordsInPattern] in a [TileMapPattern] the corresponding
   * cell coordinates if the pattern was pasted at the [positionInTilemap] coordinates (see
   * [setPattern]). This mapping is required as in half-offset tile shapes, the mapping might not work
   * by calculating `position_in_tile_map + coords_in_pattern`.
   */
  public final fun mapPattern(
    positionInTilemap: Vector2i,
    coordsInPattern: Vector2i,
    pattern: TileMapPattern?,
  ): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to positionInTilemap, VECTOR2I to coordsInPattern, OBJECT to pattern)
    TransferContext.callMethod(MethodBindings.mapPatternPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the list of all neighboring cells to the one at [coords]. Any neighboring cell is one
   * that is touching edges, so for a square cell 4 cells would be returned, for a hexagon 6 cells are
   * returned.
   */
  public final fun getSurroundingCells(coords: Vector2i): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords)
    TransferContext.callMethod(MethodBindings.getSurroundingCellsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  /**
   * Returns the neighboring cell to the one at coordinates [coords], identified by the [neighbor]
   * direction. This method takes into account the different layouts a TileMap can take.
   */
  public final fun getNeighborCell(coords: Vector2i, neighbor: TileSet.CellNeighbor): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to coords, LONG to neighbor.value)
    TransferContext.callMethod(MethodBindings.getNeighborCellPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the centered position of a cell in the [TileMapLayer]'s local coordinate space. To
   * convert the returned value into global coordinates, use [Node2D.toGlobal]. See also [localToMap].
   *
   * **Note:** This may not correspond to the visual position of the tile, i.e. it ignores the
   * [TileData.textureOrigin] property of individual tiles.
   */
  public final fun mapToLocal(mapPosition: Vector2i): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to mapPosition)
    TransferContext.callMethod(MethodBindings.mapToLocalPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the map coordinates of the cell containing the given [localPosition]. If
   * [localPosition] is in global coordinates, consider using [Node2D.toLocal] before passing it to
   * this method. See also [mapToLocal].
   */
  public final fun localToMap(localPosition: Vector2): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to localPosition)
    TransferContext.callMethod(MethodBindings.localToMapPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setTileMapDataFromArray(tileMapLayerData: PackedByteArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to tileMapLayerData)
    TransferContext.callMethod(MethodBindings.setTileMapDataFromArrayPtr)
  }

  public final fun getTileMapDataAsArray(): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTileMapDataAsArrayPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEnabledPtr)
  }

  public final fun isEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTileSet(tileSet: TileSet?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to tileSet)
    TransferContext.callMethod(MethodBindings.setTileSetPtr)
  }

  public final fun getTileSet(): TileSet? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTileSetPtr)
    return (TransferContext.readReturnValue(OBJECT) as TileSet?)
  }

  public final fun setYSortOrigin(ySortOrigin: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ySortOrigin.toLong())
    TransferContext.callMethod(MethodBindings.setYSortOriginPtr)
  }

  public final fun getYSortOrigin(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getYSortOriginPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setXDrawOrderReversed(xDrawOrderReversed: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to xDrawOrderReversed)
    TransferContext.callMethod(MethodBindings.setXDrawOrderReversedPtr)
  }

  public final fun isXDrawOrderReversed(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isXDrawOrderReversedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRenderingQuadrantSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setRenderingQuadrantSizePtr)
  }

  public final fun getRenderingQuadrantSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderingQuadrantSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setCollisionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCollisionEnabledPtr)
  }

  public final fun isCollisionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCollisionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseKinematicBodies(useKinematicBodies: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useKinematicBodies)
    TransferContext.callMethod(MethodBindings.setUseKinematicBodiesPtr)
  }

  public final fun isUsingKinematicBodies(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingKinematicBodiesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCollisionVisibilityMode(visibilityMode: DebugVisibilityMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to visibilityMode.value)
    TransferContext.callMethod(MethodBindings.setCollisionVisibilityModePtr)
  }

  public final fun getCollisionVisibilityMode(): DebugVisibilityMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionVisibilityModePtr)
    return DebugVisibilityMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setPhysicsQuadrantSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setPhysicsQuadrantSizePtr)
  }

  public final fun getPhysicsQuadrantSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsQuadrantSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setOcclusionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setOcclusionEnabledPtr)
  }

  public final fun isOcclusionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOcclusionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setNavigationEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setNavigationEnabledPtr)
  }

  public final fun isNavigationEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isNavigationEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets a custom [map] as a [NavigationServer2D] navigation map. If not set, uses the default
   * [World2D] navigation map instead.
   */
  public final fun setNavigationMap(map: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to map)
    TransferContext.callMethod(MethodBindings.setNavigationMapPtr)
  }

  /**
   * Returns the [RID] of the [NavigationServer2D] navigation used by this [TileMapLayer].
   *
   * By default this returns the default [World2D] navigation map, unless a custom map was provided
   * using [setNavigationMap].
   */
  public final fun getNavigationMap(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationMapPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setNavigationVisibilityMode(showNavigation: DebugVisibilityMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to showNavigation.value)
    TransferContext.callMethod(MethodBindings.setNavigationVisibilityModePtr)
  }

  public final fun getNavigationVisibilityMode(): DebugVisibilityMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationVisibilityModePtr)
    return DebugVisibilityMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class DebugVisibilityMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Hide the collisions or navigation debug shapes in the editor, and use the debug settings to
     * determine their visibility in game (i.e. [SceneTree.debugCollisionsHint] or
     * [SceneTree.debugNavigationHint]).
     */
    DEFAULT(0),
    /**
     * Always hide the collisions or navigation debug shapes.
     */
    FORCE_HIDE(2),
    /**
     * Always show the collisions or navigation debug shapes.
     */
    FORCE_SHOW(1),
    ;

    public companion object {
      public fun from(`value`: Long): DebugVisibilityMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setCellName: MethodStringName4<TileMapLayer, Unit, Vector2i, Int, Vector2i, Int> =
        MethodStringName4<TileMapLayer, Unit, Vector2i, Int, Vector2i, Int>("set_cell")

    @JvmField
    public val eraseCellName: MethodStringName1<TileMapLayer, Unit, Vector2i> =
        MethodStringName1<TileMapLayer, Unit, Vector2i>("erase_cell")

    @JvmField
    public val fixInvalidTilesName: MethodStringName0<TileMapLayer, Unit> =
        MethodStringName0<TileMapLayer, Unit>("fix_invalid_tiles")

    @JvmField
    public val clearName: MethodStringName0<TileMapLayer, Unit> =
        MethodStringName0<TileMapLayer, Unit>("clear")

    @JvmField
    public val getCellSourceIdName: MethodStringName1<TileMapLayer, Int, Vector2i> =
        MethodStringName1<TileMapLayer, Int, Vector2i>("get_cell_source_id")

    @JvmField
    public val getCellAtlasCoordsName: MethodStringName1<TileMapLayer, Vector2i, Vector2i> =
        MethodStringName1<TileMapLayer, Vector2i, Vector2i>("get_cell_atlas_coords")

    @JvmField
    public val getCellAlternativeTileName: MethodStringName1<TileMapLayer, Int, Vector2i> =
        MethodStringName1<TileMapLayer, Int, Vector2i>("get_cell_alternative_tile")

    @JvmField
    public val getCellTileDataName: MethodStringName1<TileMapLayer, TileData?, Vector2i> =
        MethodStringName1<TileMapLayer, TileData?, Vector2i>("get_cell_tile_data")

    @JvmField
    public val isCellFlippedHName: MethodStringName1<TileMapLayer, Boolean, Vector2i> =
        MethodStringName1<TileMapLayer, Boolean, Vector2i>("is_cell_flipped_h")

    @JvmField
    public val isCellFlippedVName: MethodStringName1<TileMapLayer, Boolean, Vector2i> =
        MethodStringName1<TileMapLayer, Boolean, Vector2i>("is_cell_flipped_v")

    @JvmField
    public val isCellTransposedName: MethodStringName1<TileMapLayer, Boolean, Vector2i> =
        MethodStringName1<TileMapLayer, Boolean, Vector2i>("is_cell_transposed")

    @JvmField
    public val getUsedCellsName: MethodStringName0<TileMapLayer, VariantArray<Vector2i>> =
        MethodStringName0<TileMapLayer, VariantArray<Vector2i>>("get_used_cells")

    @JvmField
    public val getUsedCellsByIdName:
        MethodStringName3<TileMapLayer, VariantArray<Vector2i>, Int, Vector2i, Int> =
        MethodStringName3<TileMapLayer, VariantArray<Vector2i>, Int, Vector2i, Int>("get_used_cells_by_id")

    @JvmField
    public val getUsedRectName: MethodStringName0<TileMapLayer, Rect2i> =
        MethodStringName0<TileMapLayer, Rect2i>("get_used_rect")

    @JvmField
    public val getPatternName:
        MethodStringName1<TileMapLayer, TileMapPattern?, VariantArray<Vector2i>> =
        MethodStringName1<TileMapLayer, TileMapPattern?, VariantArray<Vector2i>>("get_pattern")

    @JvmField
    public val setPatternName: MethodStringName2<TileMapLayer, Unit, Vector2i, TileMapPattern?> =
        MethodStringName2<TileMapLayer, Unit, Vector2i, TileMapPattern?>("set_pattern")

    @JvmField
    public val setCellsTerrainConnectName:
        MethodStringName4<TileMapLayer, Unit, VariantArray<Vector2i>, Int, Int, Boolean> =
        MethodStringName4<TileMapLayer, Unit, VariantArray<Vector2i>, Int, Int, Boolean>("set_cells_terrain_connect")

    @JvmField
    public val setCellsTerrainPathName:
        MethodStringName4<TileMapLayer, Unit, VariantArray<Vector2i>, Int, Int, Boolean> =
        MethodStringName4<TileMapLayer, Unit, VariantArray<Vector2i>, Int, Int, Boolean>("set_cells_terrain_path")

    @JvmField
    public val hasBodyRidName: MethodStringName1<TileMapLayer, Boolean, RID> =
        MethodStringName1<TileMapLayer, Boolean, RID>("has_body_rid")

    @JvmField
    public val getCoordsForBodyRidName: MethodStringName1<TileMapLayer, Vector2i, RID> =
        MethodStringName1<TileMapLayer, Vector2i, RID>("get_coords_for_body_rid")

    @JvmField
    public val updateInternalsName: MethodStringName0<TileMapLayer, Unit> =
        MethodStringName0<TileMapLayer, Unit>("update_internals")

    @JvmField
    public val notifyRuntimeTileDataUpdateName: MethodStringName0<TileMapLayer, Unit> =
        MethodStringName0<TileMapLayer, Unit>("notify_runtime_tile_data_update")

    @JvmField
    public val mapPatternName:
        MethodStringName3<TileMapLayer, Vector2i, Vector2i, Vector2i, TileMapPattern?> =
        MethodStringName3<TileMapLayer, Vector2i, Vector2i, Vector2i, TileMapPattern?>("map_pattern")

    @JvmField
    public val getSurroundingCellsName:
        MethodStringName1<TileMapLayer, VariantArray<Vector2i>, Vector2i> =
        MethodStringName1<TileMapLayer, VariantArray<Vector2i>, Vector2i>("get_surrounding_cells")

    @JvmField
    public val getNeighborCellName:
        MethodStringName2<TileMapLayer, Vector2i, Vector2i, TileSet.CellNeighbor> =
        MethodStringName2<TileMapLayer, Vector2i, Vector2i, TileSet.CellNeighbor>("get_neighbor_cell")

    @JvmField
    public val mapToLocalName: MethodStringName1<TileMapLayer, Vector2, Vector2i> =
        MethodStringName1<TileMapLayer, Vector2, Vector2i>("map_to_local")

    @JvmField
    public val localToMapName: MethodStringName1<TileMapLayer, Vector2i, Vector2> =
        MethodStringName1<TileMapLayer, Vector2i, Vector2>("local_to_map")

    @JvmField
    public val setTileMapDataFromArrayName: MethodStringName1<TileMapLayer, Unit, PackedByteArray> =
        MethodStringName1<TileMapLayer, Unit, PackedByteArray>("set_tile_map_data_from_array")

    @JvmField
    public val getTileMapDataAsArrayName: MethodStringName0<TileMapLayer, PackedByteArray> =
        MethodStringName0<TileMapLayer, PackedByteArray>("get_tile_map_data_as_array")

    @JvmField
    public val setEnabledName: MethodStringName1<TileMapLayer, Unit, Boolean> =
        MethodStringName1<TileMapLayer, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<TileMapLayer, Boolean> =
        MethodStringName0<TileMapLayer, Boolean>("is_enabled")

    @JvmField
    public val setTileSetName: MethodStringName1<TileMapLayer, Unit, TileSet?> =
        MethodStringName1<TileMapLayer, Unit, TileSet?>("set_tile_set")

    @JvmField
    public val getTileSetName: MethodStringName0<TileMapLayer, TileSet?> =
        MethodStringName0<TileMapLayer, TileSet?>("get_tile_set")

    @JvmField
    public val setYSortOriginName: MethodStringName1<TileMapLayer, Unit, Int> =
        MethodStringName1<TileMapLayer, Unit, Int>("set_y_sort_origin")

    @JvmField
    public val getYSortOriginName: MethodStringName0<TileMapLayer, Int> =
        MethodStringName0<TileMapLayer, Int>("get_y_sort_origin")

    @JvmField
    public val setXDrawOrderReversedName: MethodStringName1<TileMapLayer, Unit, Boolean> =
        MethodStringName1<TileMapLayer, Unit, Boolean>("set_x_draw_order_reversed")

    @JvmField
    public val isXDrawOrderReversedName: MethodStringName0<TileMapLayer, Boolean> =
        MethodStringName0<TileMapLayer, Boolean>("is_x_draw_order_reversed")

    @JvmField
    public val setRenderingQuadrantSizeName: MethodStringName1<TileMapLayer, Unit, Int> =
        MethodStringName1<TileMapLayer, Unit, Int>("set_rendering_quadrant_size")

    @JvmField
    public val getRenderingQuadrantSizeName: MethodStringName0<TileMapLayer, Int> =
        MethodStringName0<TileMapLayer, Int>("get_rendering_quadrant_size")

    @JvmField
    public val setCollisionEnabledName: MethodStringName1<TileMapLayer, Unit, Boolean> =
        MethodStringName1<TileMapLayer, Unit, Boolean>("set_collision_enabled")

    @JvmField
    public val isCollisionEnabledName: MethodStringName0<TileMapLayer, Boolean> =
        MethodStringName0<TileMapLayer, Boolean>("is_collision_enabled")

    @JvmField
    public val setUseKinematicBodiesName: MethodStringName1<TileMapLayer, Unit, Boolean> =
        MethodStringName1<TileMapLayer, Unit, Boolean>("set_use_kinematic_bodies")

    @JvmField
    public val isUsingKinematicBodiesName: MethodStringName0<TileMapLayer, Boolean> =
        MethodStringName0<TileMapLayer, Boolean>("is_using_kinematic_bodies")

    @JvmField
    public val setCollisionVisibilityModeName:
        MethodStringName1<TileMapLayer, Unit, DebugVisibilityMode> =
        MethodStringName1<TileMapLayer, Unit, DebugVisibilityMode>("set_collision_visibility_mode")

    @JvmField
    public val getCollisionVisibilityModeName: MethodStringName0<TileMapLayer, DebugVisibilityMode>
        = MethodStringName0<TileMapLayer, DebugVisibilityMode>("get_collision_visibility_mode")

    @JvmField
    public val setPhysicsQuadrantSizeName: MethodStringName1<TileMapLayer, Unit, Int> =
        MethodStringName1<TileMapLayer, Unit, Int>("set_physics_quadrant_size")

    @JvmField
    public val getPhysicsQuadrantSizeName: MethodStringName0<TileMapLayer, Int> =
        MethodStringName0<TileMapLayer, Int>("get_physics_quadrant_size")

    @JvmField
    public val setOcclusionEnabledName: MethodStringName1<TileMapLayer, Unit, Boolean> =
        MethodStringName1<TileMapLayer, Unit, Boolean>("set_occlusion_enabled")

    @JvmField
    public val isOcclusionEnabledName: MethodStringName0<TileMapLayer, Boolean> =
        MethodStringName0<TileMapLayer, Boolean>("is_occlusion_enabled")

    @JvmField
    public val setNavigationEnabledName: MethodStringName1<TileMapLayer, Unit, Boolean> =
        MethodStringName1<TileMapLayer, Unit, Boolean>("set_navigation_enabled")

    @JvmField
    public val isNavigationEnabledName: MethodStringName0<TileMapLayer, Boolean> =
        MethodStringName0<TileMapLayer, Boolean>("is_navigation_enabled")

    @JvmField
    public val setNavigationMapName: MethodStringName1<TileMapLayer, Unit, RID> =
        MethodStringName1<TileMapLayer, Unit, RID>("set_navigation_map")

    @JvmField
    public val getNavigationMapName: MethodStringName0<TileMapLayer, RID> =
        MethodStringName0<TileMapLayer, RID>("get_navigation_map")

    @JvmField
    public val setNavigationVisibilityModeName:
        MethodStringName1<TileMapLayer, Unit, DebugVisibilityMode> =
        MethodStringName1<TileMapLayer, Unit, DebugVisibilityMode>("set_navigation_visibility_mode")

    @JvmField
    public val getNavigationVisibilityModeName: MethodStringName0<TileMapLayer, DebugVisibilityMode>
        = MethodStringName0<TileMapLayer, DebugVisibilityMode>("get_navigation_visibility_mode")
  }

  public object MethodBindings {
    internal val setCellPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_cell", 2428518503)

    internal val eraseCellPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "erase_cell", 1130785943)

    internal val fixInvalidTilesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "fix_invalid_tiles", 3218959716)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "clear", 3218959716)

    internal val getCellSourceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_cell_source_id", 2485466453)

    internal val getCellAtlasCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_cell_atlas_coords", 3050897911)

    internal val getCellAlternativeTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_cell_alternative_tile", 2485466453)

    internal val getCellTileDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_cell_tile_data", 205084707)

    internal val isCellFlippedHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_cell_flipped_h", 3900751641)

    internal val isCellFlippedVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_cell_flipped_v", 3900751641)

    internal val isCellTransposedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_cell_transposed", 3900751641)

    internal val getUsedCellsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_used_cells", 3995934104)

    internal val getUsedCellsByIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_used_cells_by_id", 4175304538)

    internal val getUsedRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_used_rect", 410525958)

    internal val getPatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_pattern", 3820813253)

    internal val setPatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_pattern", 1491151770)

    internal val setCellsTerrainConnectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_cells_terrain_connect", 748968311)

    internal val setCellsTerrainPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_cells_terrain_path", 748968311)

    internal val hasBodyRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "has_body_rid", 4155700596)

    internal val getCoordsForBodyRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_coords_for_body_rid", 733700038)

    internal val updateInternalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "update_internals", 3218959716)

    internal val notifyRuntimeTileDataUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "notify_runtime_tile_data_update", 3218959716)

    internal val mapPatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "map_pattern", 1864516957)

    internal val getSurroundingCellsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_surrounding_cells", 2673526557)

    internal val getNeighborCellPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_neighbor_cell", 986575103)

    internal val mapToLocalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "map_to_local", 108438297)

    internal val localToMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "local_to_map", 837806996)

    internal val setTileMapDataFromArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_tile_map_data_from_array", 2971499966)

    internal val getTileMapDataAsArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_tile_map_data_as_array", 2362200018)

    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_enabled", 36873697)

    internal val setTileSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_tile_set", 774531446)

    internal val getTileSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_tile_set", 2678226422)

    internal val setYSortOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_y_sort_origin", 1286410249)

    internal val getYSortOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_y_sort_origin", 3905245786)

    internal val setXDrawOrderReversedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_x_draw_order_reversed", 2586408642)

    internal val isXDrawOrderReversedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_x_draw_order_reversed", 36873697)

    internal val setRenderingQuadrantSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_rendering_quadrant_size", 1286410249)

    internal val getRenderingQuadrantSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_rendering_quadrant_size", 3905245786)

    internal val setCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_collision_enabled", 2586408642)

    internal val isCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_collision_enabled", 36873697)

    internal val setUseKinematicBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_use_kinematic_bodies", 2586408642)

    internal val isUsingKinematicBodiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_using_kinematic_bodies", 36873697)

    internal val setCollisionVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_collision_visibility_mode", 3508099847)

    internal val getCollisionVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_collision_visibility_mode", 338220793)

    internal val setPhysicsQuadrantSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_physics_quadrant_size", 1286410249)

    internal val getPhysicsQuadrantSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_physics_quadrant_size", 3905245786)

    internal val setOcclusionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_occlusion_enabled", 2586408642)

    internal val isOcclusionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_occlusion_enabled", 36873697)

    internal val setNavigationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_navigation_enabled", 2586408642)

    internal val isNavigationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "is_navigation_enabled", 36873697)

    internal val setNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_navigation_map", 2722037293)

    internal val getNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_navigation_map", 2944877500)

    internal val setNavigationVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "set_navigation_visibility_mode", 3508099847)

    internal val getNavigationVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileMapLayer", "get_navigation_visibility_mode", 338220793)
  }
}
