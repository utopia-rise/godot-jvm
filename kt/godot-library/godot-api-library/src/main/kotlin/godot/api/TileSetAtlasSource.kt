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
import godot.core.MethodStringName6
import godot.core.PackedVector2Array
import godot.core.Rect2i
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2I
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2i
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * An atlas is a grid of tiles laid out on a texture. Each tile in the grid must be exposed using
 * [createTile]. Those tiles are then indexed using their coordinates in the grid.
 *
 * Each tile can also have a size in the grid coordinates, making it more or less cells in the
 * atlas.
 *
 * Alternatives version of a tile can be created using [createAlternativeTile], which are then
 * indexed using an alternative ID. The main tile (the one in the grid), is accessed with an
 * alternative ID equal to 0.
 *
 * Each tile alternate has a set of properties that is defined by the source's [TileSet] layers.
 * Those properties are stored in a TileData object that can be accessed and modified using
 * [getTileData].
 *
 * As TileData properties are stored directly in the TileSetAtlasSource resource, their properties
 * might also be set using
 * `TileSetAtlasSource.set("<coords_x>:<coords_y>/<alternative_id>/<tile_data_property>")`.
 */
@GodotBaseType
public open class TileSetAtlasSource : TileSetSource() {
  /**
   * The atlas texture.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * Margins, in pixels, to offset the origin of the grid in the texture.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var margins: Vector2i
    @JvmName("marginsProperty")
    get() = getMargins()
    @JvmName("marginsProperty")
    set(`value`) {
      setMargins(value)
    }

  /**
   * Separation, in pixels, between each tile texture region of the grid.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var separation: Vector2i
    @JvmName("separationProperty")
    get() = getSeparation()
    @JvmName("separationProperty")
    set(`value`) {
      setSeparation(value)
    }

  /**
   * The base tile size in the texture (in pixel). This size must be bigger than or equal to the
   * TileSet's `tile_size` value.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var textureRegionSize: Vector2i
    @JvmName("textureRegionSizeProperty")
    get() = getTextureRegionSize()
    @JvmName("textureRegionSizeProperty")
    set(`value`) {
      setTextureRegionSize(value)
    }

  /**
   * If `true`, generates an internal texture with an additional one pixel padding around each tile.
   * Texture padding avoids a common artifact where lines appear between tiles.
   *
   * Disabling this setting might lead a small performance improvement, as generating the internal
   * texture requires both memory and processing time when the TileSetAtlasSource resource is modified.
   */
  public final inline var useTexturePadding: Boolean
    @JvmName("useTexturePaddingProperty")
    get() = getUseTexturePadding()
    @JvmName("useTexturePaddingProperty")
    set(`value`) {
      setUseTexturePadding(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(761, scriptPtr)
  }

  /**
   * This is a helper function for [margins] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = tilesetatlassource.margins
   * //Your changes
   * tilesetatlassource.margins = myCoreType
   * ``````
   *
   * Margins, in pixels, to offset the origin of the grid in the texture.
   */
  @CoreTypeHelper
  public final fun marginsMutate(block: Vector2i.() -> Unit): Vector2i = margins.apply {
     block(this)
     margins = this
  }

  /**
   * This is a helper function for [separation] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = tilesetatlassource.separation
   * //Your changes
   * tilesetatlassource.separation = myCoreType
   * ``````
   *
   * Separation, in pixels, between each tile texture region of the grid.
   */
  @CoreTypeHelper
  public final fun separationMutate(block: Vector2i.() -> Unit): Vector2i = separation.apply {
     block(this)
     separation = this
  }

  /**
   * This is a helper function for [textureRegionSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = tilesetatlassource.textureRegionSize
   * //Your changes
   * tilesetatlassource.textureRegionSize = myCoreType
   * ``````
   *
   * The base tile size in the texture (in pixel). This size must be bigger than or equal to the
   * TileSet's `tile_size` value.
   */
  @CoreTypeHelper
  public final fun textureRegionSizeMutate(block: Vector2i.() -> Unit): Vector2i =
      textureRegionSize.apply {
     block(this)
     textureRegionSize = this
  }

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  public final fun getTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setMargins(margins: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to margins)
    TransferContext.callMethod(MethodBindings.setMarginsPtr)
  }

  public final fun getMargins(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarginsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setSeparation(separation: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to separation)
    TransferContext.callMethod(MethodBindings.setSeparationPtr)
  }

  public final fun getSeparation(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSeparationPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setTextureRegionSize(textureRegionSize: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to textureRegionSize)
    TransferContext.callMethod(MethodBindings.setTextureRegionSizePtr)
  }

  public final fun getTextureRegionSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureRegionSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setUseTexturePadding(useTexturePadding: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useTexturePadding)
    TransferContext.callMethod(MethodBindings.setUseTexturePaddingPtr)
  }

  public final fun getUseTexturePadding(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseTexturePaddingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Creates a new tile at coordinates [atlasCoords] with the given [size].
   */
  @JvmOverloads
  public final fun createTile(atlasCoords: Vector2i, size: Vector2i = Vector2i(1, 1)): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.createTilePtr)
  }

  /**
   * Remove a tile and its alternative at coordinates [atlasCoords].
   */
  public final fun removeTile(atlasCoords: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.removeTilePtr)
  }

  /**
   * Move the tile and its alternatives at the [atlasCoords] coordinates to the [newAtlasCoords]
   * coordinates with the [newSize] size. This functions will fail if a tile is already present in the
   * given area.
   *
   * If [newAtlasCoords] is `Vector2i(-1, -1)`, keeps the tile's coordinates. If [newSize] is
   * `Vector2i(-1, -1)`, keeps the tile's size.
   *
   * To avoid an error, first check if a move is possible using [hasRoomForTile].
   */
  @JvmOverloads
  public final fun moveTileInAtlas(
    atlasCoords: Vector2i,
    newAtlasCoords: Vector2i = Vector2i(-1, -1),
    newSize: Vector2i = Vector2i(-1, -1),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, VECTOR2I to newAtlasCoords, VECTOR2I to newSize)
    TransferContext.callMethod(MethodBindings.moveTileInAtlasPtr)
  }

  /**
   * Returns the size of the tile (in the grid coordinates system) at coordinates [atlasCoords].
   */
  public final fun getTileSizeInAtlas(atlasCoords: Vector2i): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getTileSizeInAtlasPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns whether there is enough room in an atlas to create/modify a tile with the given
   * properties. If [ignoredTile] is provided, act as is the given tile was not present in the atlas.
   * This may be used when you want to modify a tile's properties.
   */
  @JvmOverloads
  public final fun hasRoomForTile(
    atlasCoords: Vector2i,
    size: Vector2i,
    animationColumns: Int,
    animationSeparation: Vector2i,
    framesCount: Int,
    ignoredTile: Vector2i = Vector2i(-1, -1),
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, VECTOR2I to size, LONG to animationColumns.toLong(), VECTOR2I to animationSeparation, LONG to framesCount.toLong(), VECTOR2I to ignoredTile)
    TransferContext.callMethod(MethodBindings.hasRoomForTilePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns an array of tiles coordinates ID that will be automatically removed when modifying one
   * or several of those properties: [texture], [margins], [separation] or [textureRegionSize]. This
   * can be used to undo changes that would have caused tiles data loss.
   */
  public final fun getTilesToBeRemovedOnChange(
    texture: Texture2D?,
    margins: Vector2i,
    separation: Vector2i,
    textureRegionSize: Vector2i,
  ): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, VECTOR2I to margins, VECTOR2I to separation, VECTOR2I to textureRegionSize)
    TransferContext.callMethod(MethodBindings.getTilesToBeRemovedOnChangePtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * If there is a tile covering the [atlasCoords] coordinates, returns the top-left coordinates of
   * the tile (thus its coordinate ID). Returns `Vector2i(-1, -1)` otherwise.
   */
  public final fun getTileAtCoords(atlasCoords: Vector2i): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getTileAtCoordsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Checks if the source has any tiles that don't fit the texture area (either partially or
   * completely).
   */
  public final fun hasTilesOutsideTexture(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasTilesOutsideTexturePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes all tiles that don't fit the available texture area. This method iterates over all the
   * source's tiles, so it's advised to use [hasTilesOutsideTexture] beforehand.
   */
  public final fun clearTilesOutsideTexture(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearTilesOutsideTexturePtr)
  }

  /**
   * Sets the number of columns in the animation layout of the tile at coordinates [atlasCoords]. If
   * set to 0, then the different frames of the animation are laid out as a single horizontal line in
   * the atlas.
   */
  public final fun setTileAnimationColumns(atlasCoords: Vector2i, frameColumns: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to frameColumns.toLong())
    TransferContext.callMethod(MethodBindings.setTileAnimationColumnsPtr)
  }

  /**
   * Returns how many columns the tile at [atlasCoords] has in its animation layout.
   */
  public final fun getTileAnimationColumns(atlasCoords: Vector2i): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getTileAnimationColumnsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the margin (in grid tiles) between each tile in the animation layout of the tile at
   * coordinates [atlasCoords] has.
   */
  public final fun setTileAnimationSeparation(atlasCoords: Vector2i, separation: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, VECTOR2I to separation)
    TransferContext.callMethod(MethodBindings.setTileAnimationSeparationPtr)
  }

  /**
   * Returns the separation (as in the atlas grid) between each frame of an animated tile at
   * coordinates [atlasCoords].
   */
  public final fun getTileAnimationSeparation(atlasCoords: Vector2i): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getTileAnimationSeparationPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Sets the animation speed of the tile at coordinates [atlasCoords] has.
   */
  public final fun setTileAnimationSpeed(atlasCoords: Vector2i, speed: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, DOUBLE to speed.toDouble())
    TransferContext.callMethod(MethodBindings.setTileAnimationSpeedPtr)
  }

  /**
   * Returns the animation speed of the tile at coordinates [atlasCoords].
   */
  public final fun getTileAnimationSpeed(atlasCoords: Vector2i): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getTileAnimationSpeedPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the tile animation mode of the tile at [atlasCoords] to [mode]. See also
   * [getTileAnimationMode].
   */
  public final fun setTileAnimationMode(atlasCoords: Vector2i, mode: TileAnimationMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTileAnimationModePtr)
  }

  /**
   * Returns the tile animation mode of the tile at [atlasCoords]. See also [setTileAnimationMode].
   */
  public final fun getTileAnimationMode(atlasCoords: Vector2i): TileAnimationMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getTileAnimationModePtr)
    return TileAnimationMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets how many animation frames the tile at coordinates [atlasCoords] has.
   */
  public final fun setTileAnimationFramesCount(atlasCoords: Vector2i, framesCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to framesCount.toLong())
    TransferContext.callMethod(MethodBindings.setTileAnimationFramesCountPtr)
  }

  /**
   * Returns how many animation frames has the tile at coordinates [atlasCoords].
   */
  public final fun getTileAnimationFramesCount(atlasCoords: Vector2i): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getTileAnimationFramesCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the animation frame [duration] of frame [frameIndex] for the tile at coordinates
   * [atlasCoords].
   */
  public final fun setTileAnimationFrameDuration(
    atlasCoords: Vector2i,
    frameIndex: Int,
    duration: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to frameIndex.toLong(), DOUBLE to duration.toDouble())
    TransferContext.callMethod(MethodBindings.setTileAnimationFrameDurationPtr)
  }

  /**
   * Returns the animation frame duration of frame [frameIndex] for the tile at coordinates
   * [atlasCoords].
   */
  public final fun getTileAnimationFrameDuration(atlasCoords: Vector2i, frameIndex: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to frameIndex.toLong())
    TransferContext.callMethod(MethodBindings.getTileAnimationFrameDurationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the sum of the sum of the frame durations of the tile at coordinates [atlasCoords].
   * This value needs to be divided by the animation speed to get the actual animation loop duration.
   */
  public final fun getTileAnimationTotalDuration(atlasCoords: Vector2i): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getTileAnimationTotalDurationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Creates an alternative tile for the tile at coordinates [atlasCoords]. If
   * [alternativeIdOverride] is -1, give it an automatically generated unique ID, or assigns it the
   * given ID otherwise.
   *
   * Returns the new alternative identifier, or -1 if the alternative could not be created with a
   * provided [alternativeIdOverride].
   */
  @JvmOverloads
  public final fun createAlternativeTile(atlasCoords: Vector2i, alternativeIdOverride: Int = -1):
      Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to alternativeIdOverride.toLong())
    TransferContext.callMethod(MethodBindings.createAlternativeTilePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Remove a tile's alternative with alternative ID [alternativeTile].
   *
   * Calling this function with [alternativeTile] equals to 0 will fail, as the base tile
   * alternative cannot be removed.
   */
  public final fun removeAlternativeTile(atlasCoords: Vector2i, alternativeTile: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to alternativeTile.toLong())
    TransferContext.callMethod(MethodBindings.removeAlternativeTilePtr)
  }

  /**
   * Change a tile's alternative ID from [alternativeTile] to [newId].
   *
   * Calling this function with [newId] of 0 will fail, as the base tile alternative cannot be
   * moved.
   */
  public final fun setAlternativeTileId(
    atlasCoords: Vector2i,
    alternativeTile: Int,
    newId: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to alternativeTile.toLong(), LONG to newId.toLong())
    TransferContext.callMethod(MethodBindings.setAlternativeTileIdPtr)
  }

  /**
   * Returns the alternative ID a following call to [createAlternativeTile] would return.
   */
  public final fun getNextAlternativeTileId(atlasCoords: Vector2i): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords)
    TransferContext.callMethod(MethodBindings.getNextAlternativeTileIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [TileData] object for the given atlas coordinates and alternative ID.
   */
  public final fun getTileData(atlasCoords: Vector2i, alternativeTile: Int): TileData? {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to alternativeTile.toLong())
    TransferContext.callMethod(MethodBindings.getTileDataPtr)
    return (TransferContext.readReturnValue(OBJECT) as TileData?)
  }

  /**
   * Returns the atlas grid size, which depends on how many tiles can fit in the texture. It thus
   * depends on the [texture]'s size, the atlas [margins], and the tiles' [textureRegionSize].
   */
  public final fun getAtlasGridSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAtlasGridSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns a tile's texture region in the atlas texture. For animated tiles, a [frame] argument
   * might be provided for the different frames of the animation.
   */
  @JvmOverloads
  public final fun getTileTextureRegion(atlasCoords: Vector2i, frame: Int = 0): Rect2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to frame.toLong())
    TransferContext.callMethod(MethodBindings.getTileTextureRegionPtr)
    return (TransferContext.readReturnValue(RECT2I) as Rect2i)
  }

  /**
   * If [useTexturePadding] is `false`, returns [texture]. Otherwise, returns an internal
   * [ImageTexture] created that includes the padding.
   */
  public final fun getRuntimeTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRuntimeTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Returns the region of the tile at coordinates [atlasCoords] for the given [frame] inside the
   * texture returned by [getRuntimeTexture].
   *
   * **Note:** If [useTexturePadding] is `false`, returns the same as [getTileTextureRegion].
   */
  public final fun getRuntimeTileTextureRegion(atlasCoords: Vector2i, frame: Int): Rect2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to atlasCoords, LONG to frame.toLong())
    TransferContext.callMethod(MethodBindings.getRuntimeTileTextureRegionPtr)
    return (TransferContext.readReturnValue(RECT2I) as Rect2i)
  }

  public enum class TileAnimationMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Tile animations start at same time, looking identical.
     */
    DEFAULT(0),
    /**
     * Tile animations start at random times, looking varied.
     */
    RANDOM_START_TIMES(1),
    /**
     * Represents the size of the [TileAnimationMode] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): TileAnimationMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTextureName: MethodStringName1<TileSetAtlasSource, Unit, Texture2D?> =
        MethodStringName1<TileSetAtlasSource, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<TileSetAtlasSource, Texture2D?> =
        MethodStringName0<TileSetAtlasSource, Texture2D?>("get_texture")

    @JvmField
    public val setMarginsName: MethodStringName1<TileSetAtlasSource, Unit, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Unit, Vector2i>("set_margins")

    @JvmField
    public val getMarginsName: MethodStringName0<TileSetAtlasSource, Vector2i> =
        MethodStringName0<TileSetAtlasSource, Vector2i>("get_margins")

    @JvmField
    public val setSeparationName: MethodStringName1<TileSetAtlasSource, Unit, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Unit, Vector2i>("set_separation")

    @JvmField
    public val getSeparationName: MethodStringName0<TileSetAtlasSource, Vector2i> =
        MethodStringName0<TileSetAtlasSource, Vector2i>("get_separation")

    @JvmField
    public val setTextureRegionSizeName: MethodStringName1<TileSetAtlasSource, Unit, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Unit, Vector2i>("set_texture_region_size")

    @JvmField
    public val getTextureRegionSizeName: MethodStringName0<TileSetAtlasSource, Vector2i> =
        MethodStringName0<TileSetAtlasSource, Vector2i>("get_texture_region_size")

    @JvmField
    public val setUseTexturePaddingName: MethodStringName1<TileSetAtlasSource, Unit, Boolean> =
        MethodStringName1<TileSetAtlasSource, Unit, Boolean>("set_use_texture_padding")

    @JvmField
    public val getUseTexturePaddingName: MethodStringName0<TileSetAtlasSource, Boolean> =
        MethodStringName0<TileSetAtlasSource, Boolean>("get_use_texture_padding")

    @JvmField
    public val createTileName: MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Vector2i> =
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Vector2i>("create_tile")

    @JvmField
    public val removeTileName: MethodStringName1<TileSetAtlasSource, Unit, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Unit, Vector2i>("remove_tile")

    @JvmField
    public val moveTileInAtlasName:
        MethodStringName3<TileSetAtlasSource, Unit, Vector2i, Vector2i, Vector2i> =
        MethodStringName3<TileSetAtlasSource, Unit, Vector2i, Vector2i, Vector2i>("move_tile_in_atlas")

    @JvmField
    public val getTileSizeInAtlasName: MethodStringName1<TileSetAtlasSource, Vector2i, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Vector2i, Vector2i>("get_tile_size_in_atlas")

    @JvmField
    public val hasRoomForTileName:
        MethodStringName6<TileSetAtlasSource, Boolean, Vector2i, Vector2i, Int, Vector2i, Int, Vector2i>
        =
        MethodStringName6<TileSetAtlasSource, Boolean, Vector2i, Vector2i, Int, Vector2i, Int, Vector2i>("has_room_for_tile")

    @JvmField
    public val getTilesToBeRemovedOnChangeName:
        MethodStringName4<TileSetAtlasSource, PackedVector2Array, Texture2D?, Vector2i, Vector2i, Vector2i>
        =
        MethodStringName4<TileSetAtlasSource, PackedVector2Array, Texture2D?, Vector2i, Vector2i, Vector2i>("get_tiles_to_be_removed_on_change")

    @JvmField
    public val getTileAtCoordsName: MethodStringName1<TileSetAtlasSource, Vector2i, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Vector2i, Vector2i>("get_tile_at_coords")

    @JvmField
    public val hasTilesOutsideTextureName: MethodStringName0<TileSetAtlasSource, Boolean> =
        MethodStringName0<TileSetAtlasSource, Boolean>("has_tiles_outside_texture")

    @JvmField
    public val clearTilesOutsideTextureName: MethodStringName0<TileSetAtlasSource, Unit> =
        MethodStringName0<TileSetAtlasSource, Unit>("clear_tiles_outside_texture")

    @JvmField
    public val setTileAnimationColumnsName:
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Int> =
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Int>("set_tile_animation_columns")

    @JvmField
    public val getTileAnimationColumnsName: MethodStringName1<TileSetAtlasSource, Int, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Int, Vector2i>("get_tile_animation_columns")

    @JvmField
    public val setTileAnimationSeparationName:
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Vector2i> =
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Vector2i>("set_tile_animation_separation")

    @JvmField
    public val getTileAnimationSeparationName:
        MethodStringName1<TileSetAtlasSource, Vector2i, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Vector2i, Vector2i>("get_tile_animation_separation")

    @JvmField
    public val setTileAnimationSpeedName:
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Float> =
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Float>("set_tile_animation_speed")

    @JvmField
    public val getTileAnimationSpeedName: MethodStringName1<TileSetAtlasSource, Float, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Float, Vector2i>("get_tile_animation_speed")

    @JvmField
    public val setTileAnimationModeName:
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, TileAnimationMode> =
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, TileAnimationMode>("set_tile_animation_mode")

    @JvmField
    public val getTileAnimationModeName:
        MethodStringName1<TileSetAtlasSource, TileAnimationMode, Vector2i> =
        MethodStringName1<TileSetAtlasSource, TileAnimationMode, Vector2i>("get_tile_animation_mode")

    @JvmField
    public val setTileAnimationFramesCountName:
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Int> =
        MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Int>("set_tile_animation_frames_count")

    @JvmField
    public val getTileAnimationFramesCountName: MethodStringName1<TileSetAtlasSource, Int, Vector2i>
        = MethodStringName1<TileSetAtlasSource, Int, Vector2i>("get_tile_animation_frames_count")

    @JvmField
    public val setTileAnimationFrameDurationName:
        MethodStringName3<TileSetAtlasSource, Unit, Vector2i, Int, Float> =
        MethodStringName3<TileSetAtlasSource, Unit, Vector2i, Int, Float>("set_tile_animation_frame_duration")

    @JvmField
    public val getTileAnimationFrameDurationName:
        MethodStringName2<TileSetAtlasSource, Float, Vector2i, Int> =
        MethodStringName2<TileSetAtlasSource, Float, Vector2i, Int>("get_tile_animation_frame_duration")

    @JvmField
    public val getTileAnimationTotalDurationName:
        MethodStringName1<TileSetAtlasSource, Float, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Float, Vector2i>("get_tile_animation_total_duration")

    @JvmField
    public val createAlternativeTileName: MethodStringName2<TileSetAtlasSource, Int, Vector2i, Int>
        = MethodStringName2<TileSetAtlasSource, Int, Vector2i, Int>("create_alternative_tile")

    @JvmField
    public val removeAlternativeTileName: MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Int>
        = MethodStringName2<TileSetAtlasSource, Unit, Vector2i, Int>("remove_alternative_tile")

    @JvmField
    public val setAlternativeTileIdName:
        MethodStringName3<TileSetAtlasSource, Unit, Vector2i, Int, Int> =
        MethodStringName3<TileSetAtlasSource, Unit, Vector2i, Int, Int>("set_alternative_tile_id")

    @JvmField
    public val getNextAlternativeTileIdName: MethodStringName1<TileSetAtlasSource, Int, Vector2i> =
        MethodStringName1<TileSetAtlasSource, Int, Vector2i>("get_next_alternative_tile_id")

    @JvmField
    public val getTileDataName: MethodStringName2<TileSetAtlasSource, TileData?, Vector2i, Int> =
        MethodStringName2<TileSetAtlasSource, TileData?, Vector2i, Int>("get_tile_data")

    @JvmField
    public val getAtlasGridSizeName: MethodStringName0<TileSetAtlasSource, Vector2i> =
        MethodStringName0<TileSetAtlasSource, Vector2i>("get_atlas_grid_size")

    @JvmField
    public val getTileTextureRegionName:
        MethodStringName2<TileSetAtlasSource, Rect2i, Vector2i, Int> =
        MethodStringName2<TileSetAtlasSource, Rect2i, Vector2i, Int>("get_tile_texture_region")

    @JvmField
    public val getRuntimeTextureName: MethodStringName0<TileSetAtlasSource, Texture2D?> =
        MethodStringName0<TileSetAtlasSource, Texture2D?>("get_runtime_texture")

    @JvmField
    public val getRuntimeTileTextureRegionName:
        MethodStringName2<TileSetAtlasSource, Rect2i, Vector2i, Int> =
        MethodStringName2<TileSetAtlasSource, Rect2i, Vector2i, Int>("get_runtime_tile_texture_region")

    /**
     * Represents cell's horizontal flip flag. Should be used directly with [TileMapLayer] to flip
     * placed tiles by altering their alternative IDs.
     *
     * ```
     * var alternate_id = $TileMapLayer.get_cell_alternative_tile(Vector2i(2, 2))
     * if not alternate_id & TileSetAtlasSource.TRANSFORM_FLIP_H:
     * 	# If tile is not already flipped, flip it.
     * 	$TileMapLayer.set_cell(Vector2i(2, 2), source_id, atlas_coords, alternate_id |
     * TileSetAtlasSource.TRANSFORM_FLIP_H)
     * ```
     *
     * **Note:** These transformations can be combined to do the equivalent of 0, 90, 180, and 270
     * degree rotations, as shown below:
     *
     * ```
     * enum TileTransform {
     * 	ROTATE_0 = 0,
     * 	ROTATE_90 = TileSetAtlasSource.TRANSFORM_TRANSPOSE | TileSetAtlasSource.TRANSFORM_FLIP_H,
     * 	ROTATE_180 = TileSetAtlasSource.TRANSFORM_FLIP_H | TileSetAtlasSource.TRANSFORM_FLIP_V,
     * 	ROTATE_270 = TileSetAtlasSource.TRANSFORM_TRANSPOSE | TileSetAtlasSource.TRANSFORM_FLIP_V,
     * }
     * ```
     */
    public final const val TRANSFORM_FLIP_H: Long = 4096

    /**
     * Represents cell's vertical flip flag. See [TRANSFORM_FLIP_H] for usage.
     */
    public final const val TRANSFORM_FLIP_V: Long = 8192

    /**
     * Represents cell's transposed flag. See [TRANSFORM_FLIP_H] for usage.
     */
    public final const val TRANSFORM_TRANSPOSE: Long = 16384
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_texture", 3635182373)

    internal val setMarginsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_margins", 1130785943)

    internal val getMarginsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_margins", 3690982128)

    internal val setSeparationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_separation", 1130785943)

    internal val getSeparationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_separation", 3690982128)

    internal val setTextureRegionSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_texture_region_size", 1130785943)

    internal val getTextureRegionSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_texture_region_size", 3690982128)

    internal val setUseTexturePaddingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_use_texture_padding", 2586408642)

    internal val getUseTexturePaddingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_use_texture_padding", 36873697)

    internal val createTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "create_tile", 190528769)

    internal val removeTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "remove_tile", 1130785943)

    internal val moveTileInAtlasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "move_tile_in_atlas", 3870111920)

    internal val getTileSizeInAtlasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_size_in_atlas", 3050897911)

    internal val hasRoomForTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "has_room_for_tile", 3018597268)

    internal val getTilesToBeRemovedOnChangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tiles_to_be_removed_on_change", 1240378054)

    internal val getTileAtCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_at_coords", 3050897911)

    internal val hasTilesOutsideTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "has_tiles_outside_texture", 36873697)

    internal val clearTilesOutsideTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "clear_tiles_outside_texture", 3218959716)

    internal val setTileAnimationColumnsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_tile_animation_columns", 3200960707)

    internal val getTileAnimationColumnsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_animation_columns", 2485466453)

    internal val setTileAnimationSeparationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_tile_animation_separation", 1941061099)

    internal val getTileAnimationSeparationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_animation_separation", 3050897911)

    internal val setTileAnimationSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_tile_animation_speed", 2262553149)

    internal val getTileAnimationSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_animation_speed", 719993801)

    internal val setTileAnimationModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_tile_animation_mode", 3192753483)

    internal val getTileAnimationModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_animation_mode", 4025349959)

    internal val setTileAnimationFramesCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_tile_animation_frames_count", 3200960707)

    internal val getTileAnimationFramesCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_animation_frames_count", 2485466453)

    internal val setTileAnimationFrameDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_tile_animation_frame_duration", 2843487787)

    internal val getTileAnimationFrameDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_animation_frame_duration", 1802448425)

    internal val getTileAnimationTotalDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_animation_total_duration", 719993801)

    internal val createAlternativeTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "create_alternative_tile", 2226298068)

    internal val removeAlternativeTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "remove_alternative_tile", 3200960707)

    internal val setAlternativeTileIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "set_alternative_tile_id", 1499785778)

    internal val getNextAlternativeTileIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_next_alternative_tile_id", 2485466453)

    internal val getTileDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_data", 3534028207)

    internal val getAtlasGridSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_atlas_grid_size", 3690982128)

    internal val getTileTextureRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_tile_texture_region", 241857547)

    internal val getRuntimeTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_runtime_texture", 3635182373)

    internal val getRuntimeTileTextureRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetAtlasSource", "get_runtime_tile_texture_region", 104874263)
  }
}
