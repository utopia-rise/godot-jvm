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
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName6
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantType
import godot.core.Vector2i
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A TileSet is a library of tiles for a [TileMapLayer]. A TileSet handles a list of
 * [TileSetSource], each of them storing a set of tiles.
 *
 * Tiles can either be from a [TileSetAtlasSource], which renders tiles out of a texture with
 * support for physics, navigation, etc., or from a [TileSetScenesCollectionSource], which exposes
 * scene-based tiles.
 *
 * Tiles are referenced by using three IDs: their source ID, their atlas coordinates ID, and their
 * alternative tile ID.
 *
 * A TileSet can be configured so that its tiles expose more or fewer properties. To do so, the
 * TileSet resources use property layers, which you can add or remove depending on your needs.
 *
 * For example, adding a physics layer allows giving collision shapes to your tiles. Each layer has
 * dedicated properties (physics layer and mask), so you may add several TileSet physics layers for
 * each type of collision you need.
 *
 * See the functions to add new layers for more information.
 */
@GodotBaseType
public open class TileSet : Resource() {
  /**
   * The tile shape.
   */
  public final inline var tileShape: TileShape
    @JvmName("tileShapeProperty")
    get() = getTileShape()
    @JvmName("tileShapeProperty")
    set(`value`) {
      setTileShape(value)
    }

  /**
   * For all half-offset shapes (Isometric, Hexagonal and Half-Offset square), changes the way tiles
   * are indexed in the [TileMapLayer] grid.
   */
  public final inline var tileLayout: TileLayout
    @JvmName("tileLayoutProperty")
    get() = getTileLayout()
    @JvmName("tileLayoutProperty")
    set(`value`) {
      setTileLayout(value)
    }

  /**
   * For all half-offset shapes (Isometric, Hexagonal and Half-Offset square), determines the offset
   * axis.
   */
  public final inline var tileOffsetAxis: TileOffsetAxis
    @JvmName("tileOffsetAxisProperty")
    get() = getTileOffsetAxis()
    @JvmName("tileOffsetAxisProperty")
    set(`value`) {
      setTileOffsetAxis(value)
    }

  /**
   * The tile size, in pixels. For all tile shapes, this size corresponds to the encompassing
   * rectangle of the tile shape. This is thus the minimal cell size required in an atlas.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tileSize: Vector2i
    @JvmName("tileSizeProperty")
    get() = getTileSize()
    @JvmName("tileSizeProperty")
    set(`value`) {
      setTileSize(value)
    }

  /**
   * Enables/Disable uv clipping when rendering the tiles.
   */
  public final inline var uvClipping: Boolean
    @JvmName("uvClippingProperty")
    get() = isUvClipping()
    @JvmName("uvClippingProperty")
    set(`value`) {
      setUvClipping(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(760, scriptPtr)
  }

  /**
   * This is a helper function for [tileSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = tileset.tileSize
   * //Your changes
   * tileset.tileSize = myCoreType
   * ``````
   *
   * The tile size, in pixels. For all tile shapes, this size corresponds to the encompassing
   * rectangle of the tile shape. This is thus the minimal cell size required in an atlas.
   */
  @CoreTypeHelper
  public final fun tileSizeMutate(block: Vector2i.() -> Unit): Vector2i = tileSize.apply {
     block(this)
     tileSize = this
  }

  /**
   * Returns a new unused source ID. This generated ID is the same that a call to [addSource] would
   * return.
   */
  public final fun getNextSourceId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNextSourceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a [TileSetSource] to the TileSet. If [atlasSourceIdOverride] is not -1, also set its
   * source ID. Otherwise, a unique identifier is automatically generated.
   *
   * The function returns the added source ID or -1 if the source could not be added.
   *
   * **Warning:** A source cannot belong to two TileSets at the same time. If the added source was
   * attached to another [TileSet], it will be removed from that one.
   */
  @JvmOverloads
  public final fun addSource(source: TileSetSource?, atlasSourceIdOverride: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to source, LONG to atlasSourceIdOverride.toLong())
    TransferContext.callMethod(MethodBindings.addSourcePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes the source with the given source ID.
   */
  public final fun removeSource(sourceId: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceId.toLong())
    TransferContext.callMethod(MethodBindings.removeSourcePtr)
  }

  /**
   * Changes a source's ID.
   */
  public final fun setSourceId(sourceId: Int, newSourceId: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceId.toLong(), LONG to newSourceId.toLong())
    TransferContext.callMethod(MethodBindings.setSourceIdPtr)
  }

  /**
   * Returns the number of [TileSetSource] in this TileSet.
   */
  public final fun getSourceCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSourceCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the source ID for source with index [index].
   */
  public final fun getSourceId(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getSourceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns if this TileSet has a source for the given source ID.
   */
  public final fun hasSource(sourceId: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceId.toLong())
    TransferContext.callMethod(MethodBindings.hasSourcePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [TileSetSource] with ID [sourceId].
   */
  public final fun getSource(sourceId: Int): TileSetSource? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceId.toLong())
    TransferContext.callMethod(MethodBindings.getSourcePtr)
    return (TransferContext.readReturnValue(OBJECT) as TileSetSource?)
  }

  public final fun setTileShape(shape: TileShape): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.setTileShapePtr)
  }

  public final fun getTileShape(): TileShape {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTileShapePtr)
    return TileShape.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTileLayout(layout: TileLayout): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layout.value)
    TransferContext.callMethod(MethodBindings.setTileLayoutPtr)
  }

  public final fun getTileLayout(): TileLayout {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTileLayoutPtr)
    return TileLayout.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTileOffsetAxis(alignment: TileOffsetAxis): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to alignment.value)
    TransferContext.callMethod(MethodBindings.setTileOffsetAxisPtr)
  }

  public final fun getTileOffsetAxis(): TileOffsetAxis {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTileOffsetAxisPtr)
    return TileOffsetAxis.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTileSize(size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.setTileSizePtr)
  }

  public final fun getTileSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTileSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setUvClipping(uvClipping: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to uvClipping)
    TransferContext.callMethod(MethodBindings.setUvClippingPtr)
  }

  public final fun isUvClipping(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUvClippingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the occlusion layers count.
   */
  public final fun getOcclusionLayersCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOcclusionLayersCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds an occlusion layer to the TileSet at the given position [toPosition] in the array. If
   * [toPosition] is -1, adds it at the end of the array.
   *
   * Occlusion layers allow assigning occlusion polygons to atlas tiles.
   */
  @JvmOverloads
  public final fun addOcclusionLayer(toPosition: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.addOcclusionLayerPtr)
  }

  /**
   * Moves the occlusion layer at index [layerIndex] to the given position [toPosition] in the
   * array. Also updates the atlas tiles accordingly.
   */
  public final fun moveOcclusionLayer(layerIndex: Int, toPosition: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.moveOcclusionLayerPtr)
  }

  /**
   * Removes the occlusion layer at index [layerIndex]. Also updates the atlas tiles accordingly.
   */
  public final fun removeOcclusionLayer(layerIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.removeOcclusionLayerPtr)
  }

  /**
   * Sets the occlusion layer (as in the rendering server) for occluders in the given TileSet
   * occlusion layer.
   */
  public final fun setOcclusionLayerLightMask(layerIndex: Int, lightMask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to lightMask.toLong())
    TransferContext.callMethod(MethodBindings.setOcclusionLayerLightMaskPtr)
  }

  /**
   * Returns the light mask of the occlusion layer.
   */
  public final fun getOcclusionLayerLightMask(layerIndex: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getOcclusionLayerLightMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Enables or disables SDF collision for occluders in the given TileSet occlusion layer.
   */
  public final fun setOcclusionLayerSdfCollision(layerIndex: Int, sdfCollision: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), BOOL to sdfCollision)
    TransferContext.callMethod(MethodBindings.setOcclusionLayerSdfCollisionPtr)
  }

  /**
   * Returns if the occluders from this layer use `sdf_collision`.
   */
  public final fun getOcclusionLayerSdfCollision(layerIndex: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getOcclusionLayerSdfCollisionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the physics layers count.
   */
  public final fun getPhysicsLayersCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsLayersCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a physics layer to the TileSet at the given position [toPosition] in the array. If
   * [toPosition] is -1, adds it at the end of the array.
   *
   * Physics layers allow assigning collision polygons to atlas tiles.
   */
  @JvmOverloads
  public final fun addPhysicsLayer(toPosition: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.addPhysicsLayerPtr)
  }

  /**
   * Moves the physics layer at index [layerIndex] to the given position [toPosition] in the array.
   * Also updates the atlas tiles accordingly.
   */
  public final fun movePhysicsLayer(layerIndex: Int, toPosition: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.movePhysicsLayerPtr)
  }

  /**
   * Removes the physics layer at index [layerIndex]. Also updates the atlas tiles accordingly.
   */
  public final fun removePhysicsLayer(layerIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.removePhysicsLayerPtr)
  }

  /**
   * Sets the collision layer (as in the physics server) for bodies in the given TileSet physics
   * layer.
   */
  public final fun setPhysicsLayerCollisionLayer(layerIndex: Int, layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to layer)
    TransferContext.callMethod(MethodBindings.setPhysicsLayerCollisionLayerPtr)
  }

  /**
   * Returns the collision layer (as in the physics server) bodies on the given TileSet's physics
   * layer are in.
   */
  public final fun getPhysicsLayerCollisionLayer(layerIndex: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getPhysicsLayerCollisionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the collision mask for bodies in the given TileSet physics layer.
   */
  public final fun setPhysicsLayerCollisionMask(layerIndex: Int, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to mask)
    TransferContext.callMethod(MethodBindings.setPhysicsLayerCollisionMaskPtr)
  }

  /**
   * Returns the collision mask of bodies on the given TileSet's physics layer.
   */
  public final fun getPhysicsLayerCollisionMask(layerIndex: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getPhysicsLayerCollisionMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the collision priority for bodies in the given TileSet physics layer.
   */
  public final fun setPhysicsLayerCollisionPriority(layerIndex: Int, priority: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), DOUBLE to priority.toDouble())
    TransferContext.callMethod(MethodBindings.setPhysicsLayerCollisionPriorityPtr)
  }

  /**
   * Returns the collision priority of bodies on the given TileSet's physics layer.
   */
  public final fun getPhysicsLayerCollisionPriority(layerIndex: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getPhysicsLayerCollisionPriorityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the physics material for bodies in the given TileSet physics layer.
   */
  public final fun setPhysicsLayerPhysicsMaterial(layerIndex: Int,
      physicsMaterial: PhysicsMaterial?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), OBJECT to physicsMaterial)
    TransferContext.callMethod(MethodBindings.setPhysicsLayerPhysicsMaterialPtr)
  }

  /**
   * Returns the physics material of bodies on the given TileSet's physics layer.
   */
  public final fun getPhysicsLayerPhysicsMaterial(layerIndex: Int): PhysicsMaterial? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getPhysicsLayerPhysicsMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as PhysicsMaterial?)
  }

  /**
   * Returns the terrain sets count.
   */
  public final fun getTerrainSetsCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTerrainSetsCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new terrain set at the given position [toPosition] in the array. If [toPosition] is -1,
   * adds it at the end of the array.
   */
  @JvmOverloads
  public final fun addTerrainSet(toPosition: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.addTerrainSetPtr)
  }

  /**
   * Moves the terrain set at index [terrainSet] to the given position [toPosition] in the array.
   * Also updates the atlas tiles accordingly.
   */
  public final fun moveTerrainSet(terrainSet: Int, toPosition: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.moveTerrainSetPtr)
  }

  /**
   * Removes the terrain set at index [terrainSet]. Also updates the atlas tiles accordingly.
   */
  public final fun removeTerrainSet(terrainSet: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong())
    TransferContext.callMethod(MethodBindings.removeTerrainSetPtr)
  }

  /**
   * Sets a terrain mode. Each mode determines which bits of a tile shape is used to match the
   * neighboring tiles' terrains.
   */
  public final fun setTerrainSetMode(terrainSet: Int, mode: TerrainMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTerrainSetModePtr)
  }

  /**
   * Returns a terrain set mode.
   */
  public final fun getTerrainSetMode(terrainSet: Int): TerrainMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong())
    TransferContext.callMethod(MethodBindings.getTerrainSetModePtr)
    return TerrainMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the number of terrains in the given terrain set.
   */
  public final fun getTerrainsCount(terrainSet: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong())
    TransferContext.callMethod(MethodBindings.getTerrainsCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new terrain to the given terrain set [terrainSet] at the given position [toPosition] in
   * the array. If [toPosition] is -1, adds it at the end of the array.
   */
  @JvmOverloads
  public final fun addTerrain(terrainSet: Int, toPosition: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.addTerrainPtr)
  }

  /**
   * Moves the terrain at index [terrainIndex] for terrain set [terrainSet] to the given position
   * [toPosition] in the array. Also updates the atlas tiles accordingly.
   */
  public final fun moveTerrain(
    terrainSet: Int,
    terrainIndex: Int,
    toPosition: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to terrainIndex.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.moveTerrainPtr)
  }

  /**
   * Removes the terrain at index [terrainIndex] in the given terrain set [terrainSet]. Also updates
   * the atlas tiles accordingly.
   */
  public final fun removeTerrain(terrainSet: Int, terrainIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to terrainIndex.toLong())
    TransferContext.callMethod(MethodBindings.removeTerrainPtr)
  }

  /**
   * Clears all terrain properties for the given terrain set.
   */
  public final fun clearTerrains(terrainSet: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong())
    TransferContext.callMethod(MethodBindings.clearTerrainsPtr)
  }

  /**
   * Sets a terrain's name.
   */
  public final fun setTerrainName(
    terrainSet: Int,
    terrainIndex: Int,
    name: String,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to terrainIndex.toLong(), STRING to name)
    TransferContext.callMethod(MethodBindings.setTerrainNamePtr)
  }

  /**
   * Returns a terrain's name.
   */
  public final fun getTerrainName(terrainSet: Int, terrainIndex: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to terrainIndex.toLong())
    TransferContext.callMethod(MethodBindings.getTerrainNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets a terrain's color. This color is used for identifying the different terrains in the
   * TileSet editor.
   */
  public final fun setTerrainColor(
    terrainSet: Int,
    terrainIndex: Int,
    color: Color,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to terrainIndex.toLong(), COLOR to color)
    TransferContext.callMethod(MethodBindings.setTerrainColorPtr)
  }

  /**
   * Returns a terrain's color.
   */
  public final fun getTerrainColor(terrainSet: Int, terrainIndex: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong(), LONG to terrainIndex.toLong())
    TransferContext.callMethod(MethodBindings.getTerrainColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Returns the navigation layers count.
   */
  public final fun getNavigationLayersCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNavigationLayersCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a navigation layer to the TileSet at the given position [toPosition] in the array. If
   * [toPosition] is -1, adds it at the end of the array.
   *
   * Navigation layers allow assigning a navigable area to atlas tiles.
   */
  @JvmOverloads
  public final fun addNavigationLayer(toPosition: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.addNavigationLayerPtr)
  }

  /**
   * Moves the navigation layer at index [layerIndex] to the given position [toPosition] in the
   * array. Also updates the atlas tiles accordingly.
   */
  public final fun moveNavigationLayer(layerIndex: Int, toPosition: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.moveNavigationLayerPtr)
  }

  /**
   * Removes the navigation layer at index [layerIndex]. Also updates the atlas tiles accordingly.
   */
  public final fun removeNavigationLayer(layerIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.removeNavigationLayerPtr)
  }

  /**
   * Sets the navigation layers (as in the navigation server) for navigation regions in the given
   * TileSet navigation layer.
   */
  public final fun setNavigationLayerLayers(layerIndex: Int, layers: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to layers)
    TransferContext.callMethod(MethodBindings.setNavigationLayerLayersPtr)
  }

  /**
   * Returns the navigation layers (as in the Navigation server) of the given TileSet navigation
   * layer.
   */
  public final fun getNavigationLayerLayers(layerIndex: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getNavigationLayerLayersPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Based on [value], enables or disables the specified navigation layer of the TileSet navigation
   * data layer identified by the given [layerIndex], given a navigation_layers [layerNumber] between 1
   * and 32.
   */
  public final fun setNavigationLayerLayerValue(
    layerIndex: Int,
    layerNumber: Int,
    `value`: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setNavigationLayerLayerValuePtr)
  }

  /**
   * Returns whether or not the specified navigation layer of the TileSet navigation data layer
   * identified by the given [layerIndex] is enabled, given a navigation_layers [layerNumber] between 1
   * and 32.
   */
  public final fun getNavigationLayerLayerValue(layerIndex: Int, layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getNavigationLayerLayerValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the custom data layers count.
   */
  public final fun getCustomDataLayersCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomDataLayersCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a custom data layer to the TileSet at the given position [toPosition] in the array. If
   * [toPosition] is -1, adds it at the end of the array.
   *
   * Custom data layers allow assigning custom properties to atlas tiles.
   */
  @JvmOverloads
  public final fun addCustomDataLayer(toPosition: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.addCustomDataLayerPtr)
  }

  /**
   * Moves the custom data layer at index [layerIndex] to the given position [toPosition] in the
   * array. Also updates the atlas tiles accordingly.
   */
  public final fun moveCustomDataLayer(layerIndex: Int, toPosition: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to toPosition.toLong())
    TransferContext.callMethod(MethodBindings.moveCustomDataLayerPtr)
  }

  /**
   * Removes the custom data layer at index [layerIndex]. Also updates the atlas tiles accordingly.
   */
  public final fun removeCustomDataLayer(layerIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.removeCustomDataLayerPtr)
  }

  /**
   * Returns the index of the custom data layer identified by the given name.
   */
  public final fun getCustomDataLayerByName(layerName: String): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to layerName)
    TransferContext.callMethod(MethodBindings.getCustomDataLayerByNamePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the name of the custom data layer identified by the given index. Names are identifiers of
   * the layer therefore if the name is already taken it will fail and raise an error.
   */
  public final fun setCustomDataLayerName(layerIndex: Int, layerName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), STRING to layerName)
    TransferContext.callMethod(MethodBindings.setCustomDataLayerNamePtr)
  }

  /**
   * Returns if there is a custom data layer named [layerName].
   */
  public final fun hasCustomDataLayerByName(layerName: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to layerName)
    TransferContext.callMethod(MethodBindings.hasCustomDataLayerByNamePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the name of the custom data layer identified by the given index.
   */
  public final fun getCustomDataLayerName(layerIndex: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCustomDataLayerNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the type of the custom data layer identified by the given index.
   */
  public final fun setCustomDataLayerType(layerIndex: Int, layerType: VariantType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong(), LONG to layerType.value)
    TransferContext.callMethod(MethodBindings.setCustomDataLayerTypePtr)
  }

  /**
   * Returns the type of the custom data layer identified by the given index.
   */
  public final fun getCustomDataLayerType(layerIndex: Int): VariantType {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCustomDataLayerTypePtr)
    return VariantType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a source-level proxy for the given source ID. A proxy will map set of tile identifiers
   * to another set of identifiers. Both the atlas coordinates ID and the alternative tile ID are kept
   * the same when using source-level proxies.
   *
   * Proxied tiles can be automatically replaced in TileMapLayer nodes using the editor.
   */
  public final fun setSourceLevelTileProxy(sourceFrom: Int, sourceTo: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), LONG to sourceTo.toLong())
    TransferContext.callMethod(MethodBindings.setSourceLevelTileProxyPtr)
  }

  /**
   * Returns the source-level proxy for the given source identifier.
   *
   * If the TileSet has no proxy for the given identifier, returns -1.
   */
  public final fun getSourceLevelTileProxy(sourceFrom: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong())
    TransferContext.callMethod(MethodBindings.getSourceLevelTileProxyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns if there is a source-level proxy for the given source ID.
   */
  public final fun hasSourceLevelTileProxy(sourceFrom: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong())
    TransferContext.callMethod(MethodBindings.hasSourceLevelTileProxyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes a source-level tile proxy.
   */
  public final fun removeSourceLevelTileProxy(sourceFrom: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong())
    TransferContext.callMethod(MethodBindings.removeSourceLevelTileProxyPtr)
  }

  /**
   * Creates a coordinates-level proxy for the given identifiers. A proxy will map set of tile
   * identifiers to another set of identifiers. The alternative tile ID is kept the same when using
   * coordinates-level proxies.
   *
   * Proxied tiles can be automatically replaced in TileMapLayer nodes using the editor.
   */
  public final fun setCoordsLevelTileProxy(
    sourceFrom: Int,
    coordsFrom: Vector2i,
    sourceTo: Int,
    coordsTo: Vector2i,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom, LONG to sourceTo.toLong(), VECTOR2I to coordsTo)
    TransferContext.callMethod(MethodBindings.setCoordsLevelTileProxyPtr)
  }

  /**
   * Returns the coordinate-level proxy for the given identifiers. The returned array contains the
   * two target identifiers of the proxy (source ID and atlas coordinates ID).
   *
   * If the TileSet has no proxy for the given identifiers, returns an empty Array.
   */
  public final fun getCoordsLevelTileProxy(sourceFrom: Int, coordsFrom: Vector2i):
      VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom)
    TransferContext.callMethod(MethodBindings.getCoordsLevelTileProxyPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns if there is a coodinates-level proxy for the given identifiers.
   */
  public final fun hasCoordsLevelTileProxy(sourceFrom: Int, coordsFrom: Vector2i): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom)
    TransferContext.callMethod(MethodBindings.hasCoordsLevelTileProxyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes a coordinates-level proxy for the given identifiers.
   */
  public final fun removeCoordsLevelTileProxy(sourceFrom: Int, coordsFrom: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom)
    TransferContext.callMethod(MethodBindings.removeCoordsLevelTileProxyPtr)
  }

  /**
   * Create an alternative-level proxy for the given identifiers. A proxy will map set of tile
   * identifiers to another set of identifiers.
   *
   * Proxied tiles can be automatically replaced in TileMapLayer nodes using the editor.
   */
  public final fun setAlternativeLevelTileProxy(
    sourceFrom: Int,
    coordsFrom: Vector2i,
    alternativeFrom: Int,
    sourceTo: Int,
    coordsTo: Vector2i,
    alternativeTo: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom, LONG to alternativeFrom.toLong(), LONG to sourceTo.toLong(), VECTOR2I to coordsTo, LONG to alternativeTo.toLong())
    TransferContext.callMethod(MethodBindings.setAlternativeLevelTileProxyPtr)
  }

  /**
   * Returns the alternative-level proxy for the given identifiers. The returned array contains the
   * three proxie's target identifiers (source ID, atlas coords ID and alternative tile ID).
   *
   * If the TileSet has no proxy for the given identifiers, returns an empty Array.
   */
  public final fun getAlternativeLevelTileProxy(
    sourceFrom: Int,
    coordsFrom: Vector2i,
    alternativeFrom: Int,
  ): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom, LONG to alternativeFrom.toLong())
    TransferContext.callMethod(MethodBindings.getAlternativeLevelTileProxyPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns if there is an alternative-level proxy for the given identifiers.
   */
  public final fun hasAlternativeLevelTileProxy(
    sourceFrom: Int,
    coordsFrom: Vector2i,
    alternativeFrom: Int,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom, LONG to alternativeFrom.toLong())
    TransferContext.callMethod(MethodBindings.hasAlternativeLevelTileProxyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes an alternative-level proxy for the given identifiers.
   */
  public final fun removeAlternativeLevelTileProxy(
    sourceFrom: Int,
    coordsFrom: Vector2i,
    alternativeFrom: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom, LONG to alternativeFrom.toLong())
    TransferContext.callMethod(MethodBindings.removeAlternativeLevelTileProxyPtr)
  }

  /**
   * According to the configured proxies, maps the provided identifiers to a new set of identifiers.
   * The source ID, atlas coordinates ID and alternative tile ID are returned as a 3 elements Array.
   *
   * This function first look for matching alternative-level proxies, then coordinates-level
   * proxies, then source-level proxies.
   *
   * If no proxy corresponding to provided identifiers are found, returns the same values the ones
   * used as arguments.
   */
  public final fun mapTileProxy(
    sourceFrom: Int,
    coordsFrom: Vector2i,
    alternativeFrom: Int,
  ): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sourceFrom.toLong(), VECTOR2I to coordsFrom, LONG to alternativeFrom.toLong())
    TransferContext.callMethod(MethodBindings.mapTileProxyPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Clears tile proxies pointing to invalid tiles.
   */
  public final fun cleanupInvalidTileProxies(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cleanupInvalidTileProxiesPtr)
  }

  /**
   * Clears all tile proxies.
   */
  public final fun clearTileProxies(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearTileProxiesPtr)
  }

  /**
   * Adds a [TileMapPattern] to be stored in the TileSet resource. If provided, insert it at the
   * given [index].
   */
  @JvmOverloads
  public final fun addPattern(pattern: TileMapPattern?, index: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to pattern, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.addPatternPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [TileMapPattern] at the given [index].
   */
  @JvmOverloads
  public final fun getPattern(index: Int = -1): TileMapPattern? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getPatternPtr)
    return (TransferContext.readReturnValue(OBJECT) as TileMapPattern?)
  }

  /**
   * Remove the [TileMapPattern] at the given index.
   */
  public final fun removePattern(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.removePatternPtr)
  }

  /**
   * Returns the number of [TileMapPattern] this tile set handles.
   */
  public final fun getPatternsCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPatternsCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public enum class TileShape(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Rectangular tile shape.
     */
    SQUARE(0),
    /**
     * Diamond tile shape (for isometric look).
     *
     * **Note:** Isometric [TileSet] works best if all sibling [TileMapLayer]s and their parent
     * inheriting from [Node2D] have Y-sort enabled.
     */
    ISOMETRIC(1),
    /**
     * Rectangular tile shape with one row/column out of two offset by half a tile.
     */
    HALF_OFFSET_SQUARE(2),
    /**
     * Hexagonal tile shape.
     */
    HEXAGON(3),
    ;

    public companion object {
      public fun from(`value`: Long): TileShape = entries.single { it.`value` == `value` }
    }
  }

  public enum class TileLayout(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Tile coordinates layout where both axis stay consistent with their respective local
     * horizontal and vertical axis.
     */
    STACKED(0),
    /**
     * Same as [TILE_LAYOUT_STACKED], but the first half-offset is negative instead of positive.
     */
    STACKED_OFFSET(1),
    /**
     * Tile coordinates layout where the horizontal axis stay horizontal, and the vertical one goes
     * down-right.
     */
    STAIRS_RIGHT(2),
    /**
     * Tile coordinates layout where the vertical axis stay vertical, and the horizontal one goes
     * down-right.
     */
    STAIRS_DOWN(3),
    /**
     * Tile coordinates layout where the horizontal axis goes up-right, and the vertical one goes
     * down-right.
     */
    DIAMOND_RIGHT(4),
    /**
     * Tile coordinates layout where the horizontal axis goes down-right, and the vertical one goes
     * down-left.
     */
    DIAMOND_DOWN(5),
    ;

    public companion object {
      public fun from(`value`: Long): TileLayout = entries.single { it.`value` == `value` }
    }
  }

  public enum class TileOffsetAxis(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Horizontal half-offset.
     */
    HORIZONTAL(0),
    /**
     * Vertical half-offset.
     */
    VERTICAL(1),
    ;

    public companion object {
      public fun from(`value`: Long): TileOffsetAxis = entries.single { it.`value` == `value` }
    }
  }

  public enum class CellNeighbor(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Neighbor on the right side.
     */
    RIGHT_SIDE(0),
    /**
     * Neighbor in the right corner.
     */
    RIGHT_CORNER(1),
    /**
     * Neighbor on the bottom right side.
     */
    BOTTOM_RIGHT_SIDE(2),
    /**
     * Neighbor in the bottom right corner.
     */
    BOTTOM_RIGHT_CORNER(3),
    /**
     * Neighbor on the bottom side.
     */
    BOTTOM_SIDE(4),
    /**
     * Neighbor in the bottom corner.
     */
    BOTTOM_CORNER(5),
    /**
     * Neighbor on the bottom left side.
     */
    BOTTOM_LEFT_SIDE(6),
    /**
     * Neighbor in the bottom left corner.
     */
    BOTTOM_LEFT_CORNER(7),
    /**
     * Neighbor on the left side.
     */
    LEFT_SIDE(8),
    /**
     * Neighbor in the left corner.
     */
    LEFT_CORNER(9),
    /**
     * Neighbor on the top left side.
     */
    TOP_LEFT_SIDE(10),
    /**
     * Neighbor in the top left corner.
     */
    TOP_LEFT_CORNER(11),
    /**
     * Neighbor on the top side.
     */
    TOP_SIDE(12),
    /**
     * Neighbor in the top corner.
     */
    TOP_CORNER(13),
    /**
     * Neighbor on the top right side.
     */
    TOP_RIGHT_SIDE(14),
    /**
     * Neighbor in the top right corner.
     */
    TOP_RIGHT_CORNER(15),
    ;

    public companion object {
      public fun from(`value`: Long): CellNeighbor = entries.single { it.`value` == `value` }
    }
  }

  public enum class TerrainMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Requires both corners and side to match with neighboring tiles' terrains.
     */
    MATCH_CORNERS_AND_SIDES(0),
    /**
     * Requires corners to match with neighboring tiles' terrains.
     */
    MATCH_CORNERS(1),
    /**
     * Requires sides to match with neighboring tiles' terrains.
     */
    MATCH_SIDES(2),
    ;

    public companion object {
      public fun from(`value`: Long): TerrainMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getNextSourceIdName: MethodStringName0<TileSet, Int> =
        MethodStringName0<TileSet, Int>("get_next_source_id")

    @JvmField
    public val addSourceName: MethodStringName2<TileSet, Int, TileSetSource?, Int> =
        MethodStringName2<TileSet, Int, TileSetSource?, Int>("add_source")

    @JvmField
    public val removeSourceName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("remove_source")

    @JvmField
    public val setSourceIdName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("set_source_id")

    @JvmField
    public val getSourceCountName: MethodStringName0<TileSet, Int> =
        MethodStringName0<TileSet, Int>("get_source_count")

    @JvmField
    public val getSourceIdName: MethodStringName1<TileSet, Int, Int> =
        MethodStringName1<TileSet, Int, Int>("get_source_id")

    @JvmField
    public val hasSourceName: MethodStringName1<TileSet, Boolean, Int> =
        MethodStringName1<TileSet, Boolean, Int>("has_source")

    @JvmField
    public val getSourceName: MethodStringName1<TileSet, TileSetSource?, Int> =
        MethodStringName1<TileSet, TileSetSource?, Int>("get_source")

    @JvmField
    public val setTileShapeName: MethodStringName1<TileSet, Unit, TileShape> =
        MethodStringName1<TileSet, Unit, TileShape>("set_tile_shape")

    @JvmField
    public val getTileShapeName: MethodStringName0<TileSet, TileShape> =
        MethodStringName0<TileSet, TileShape>("get_tile_shape")

    @JvmField
    public val setTileLayoutName: MethodStringName1<TileSet, Unit, TileLayout> =
        MethodStringName1<TileSet, Unit, TileLayout>("set_tile_layout")

    @JvmField
    public val getTileLayoutName: MethodStringName0<TileSet, TileLayout> =
        MethodStringName0<TileSet, TileLayout>("get_tile_layout")

    @JvmField
    public val setTileOffsetAxisName: MethodStringName1<TileSet, Unit, TileOffsetAxis> =
        MethodStringName1<TileSet, Unit, TileOffsetAxis>("set_tile_offset_axis")

    @JvmField
    public val getTileOffsetAxisName: MethodStringName0<TileSet, TileOffsetAxis> =
        MethodStringName0<TileSet, TileOffsetAxis>("get_tile_offset_axis")

    @JvmField
    public val setTileSizeName: MethodStringName1<TileSet, Unit, Vector2i> =
        MethodStringName1<TileSet, Unit, Vector2i>("set_tile_size")

    @JvmField
    public val getTileSizeName: MethodStringName0<TileSet, Vector2i> =
        MethodStringName0<TileSet, Vector2i>("get_tile_size")

    @JvmField
    public val setUvClippingName: MethodStringName1<TileSet, Unit, Boolean> =
        MethodStringName1<TileSet, Unit, Boolean>("set_uv_clipping")

    @JvmField
    public val isUvClippingName: MethodStringName0<TileSet, Boolean> =
        MethodStringName0<TileSet, Boolean>("is_uv_clipping")

    @JvmField
    public val getOcclusionLayersCountName: MethodStringName0<TileSet, Int> =
        MethodStringName0<TileSet, Int>("get_occlusion_layers_count")

    @JvmField
    public val addOcclusionLayerName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("add_occlusion_layer")

    @JvmField
    public val moveOcclusionLayerName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("move_occlusion_layer")

    @JvmField
    public val removeOcclusionLayerName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("remove_occlusion_layer")

    @JvmField
    public val setOcclusionLayerLightMaskName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("set_occlusion_layer_light_mask")

    @JvmField
    public val getOcclusionLayerLightMaskName: MethodStringName1<TileSet, Int, Int> =
        MethodStringName1<TileSet, Int, Int>("get_occlusion_layer_light_mask")

    @JvmField
    public val setOcclusionLayerSdfCollisionName: MethodStringName2<TileSet, Unit, Int, Boolean> =
        MethodStringName2<TileSet, Unit, Int, Boolean>("set_occlusion_layer_sdf_collision")

    @JvmField
    public val getOcclusionLayerSdfCollisionName: MethodStringName1<TileSet, Boolean, Int> =
        MethodStringName1<TileSet, Boolean, Int>("get_occlusion_layer_sdf_collision")

    @JvmField
    public val getPhysicsLayersCountName: MethodStringName0<TileSet, Int> =
        MethodStringName0<TileSet, Int>("get_physics_layers_count")

    @JvmField
    public val addPhysicsLayerName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("add_physics_layer")

    @JvmField
    public val movePhysicsLayerName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("move_physics_layer")

    @JvmField
    public val removePhysicsLayerName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("remove_physics_layer")

    @JvmField
    public val setPhysicsLayerCollisionLayerName: MethodStringName2<TileSet, Unit, Int, Long> =
        MethodStringName2<TileSet, Unit, Int, Long>("set_physics_layer_collision_layer")

    @JvmField
    public val getPhysicsLayerCollisionLayerName: MethodStringName1<TileSet, Long, Int> =
        MethodStringName1<TileSet, Long, Int>("get_physics_layer_collision_layer")

    @JvmField
    public val setPhysicsLayerCollisionMaskName: MethodStringName2<TileSet, Unit, Int, Long> =
        MethodStringName2<TileSet, Unit, Int, Long>("set_physics_layer_collision_mask")

    @JvmField
    public val getPhysicsLayerCollisionMaskName: MethodStringName1<TileSet, Long, Int> =
        MethodStringName1<TileSet, Long, Int>("get_physics_layer_collision_mask")

    @JvmField
    public val setPhysicsLayerCollisionPriorityName: MethodStringName2<TileSet, Unit, Int, Float> =
        MethodStringName2<TileSet, Unit, Int, Float>("set_physics_layer_collision_priority")

    @JvmField
    public val getPhysicsLayerCollisionPriorityName: MethodStringName1<TileSet, Float, Int> =
        MethodStringName1<TileSet, Float, Int>("get_physics_layer_collision_priority")

    @JvmField
    public val setPhysicsLayerPhysicsMaterialName:
        MethodStringName2<TileSet, Unit, Int, PhysicsMaterial?> =
        MethodStringName2<TileSet, Unit, Int, PhysicsMaterial?>("set_physics_layer_physics_material")

    @JvmField
    public val getPhysicsLayerPhysicsMaterialName: MethodStringName1<TileSet, PhysicsMaterial?, Int>
        = MethodStringName1<TileSet, PhysicsMaterial?, Int>("get_physics_layer_physics_material")

    @JvmField
    public val getTerrainSetsCountName: MethodStringName0<TileSet, Int> =
        MethodStringName0<TileSet, Int>("get_terrain_sets_count")

    @JvmField
    public val addTerrainSetName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("add_terrain_set")

    @JvmField
    public val moveTerrainSetName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("move_terrain_set")

    @JvmField
    public val removeTerrainSetName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("remove_terrain_set")

    @JvmField
    public val setTerrainSetModeName: MethodStringName2<TileSet, Unit, Int, TerrainMode> =
        MethodStringName2<TileSet, Unit, Int, TerrainMode>("set_terrain_set_mode")

    @JvmField
    public val getTerrainSetModeName: MethodStringName1<TileSet, TerrainMode, Int> =
        MethodStringName1<TileSet, TerrainMode, Int>("get_terrain_set_mode")

    @JvmField
    public val getTerrainsCountName: MethodStringName1<TileSet, Int, Int> =
        MethodStringName1<TileSet, Int, Int>("get_terrains_count")

    @JvmField
    public val addTerrainName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("add_terrain")

    @JvmField
    public val moveTerrainName: MethodStringName3<TileSet, Unit, Int, Int, Int> =
        MethodStringName3<TileSet, Unit, Int, Int, Int>("move_terrain")

    @JvmField
    public val removeTerrainName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("remove_terrain")

    @JvmField
    public val clearTerrainsName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("clear_terrains")

    @JvmField
    public val setTerrainNameName: MethodStringName3<TileSet, Unit, Int, Int, String> =
        MethodStringName3<TileSet, Unit, Int, Int, String>("set_terrain_name")

    @JvmField
    public val getTerrainNameName: MethodStringName2<TileSet, String, Int, Int> =
        MethodStringName2<TileSet, String, Int, Int>("get_terrain_name")

    @JvmField
    public val setTerrainColorName: MethodStringName3<TileSet, Unit, Int, Int, Color> =
        MethodStringName3<TileSet, Unit, Int, Int, Color>("set_terrain_color")

    @JvmField
    public val getTerrainColorName: MethodStringName2<TileSet, Color, Int, Int> =
        MethodStringName2<TileSet, Color, Int, Int>("get_terrain_color")

    @JvmField
    public val getNavigationLayersCountName: MethodStringName0<TileSet, Int> =
        MethodStringName0<TileSet, Int>("get_navigation_layers_count")

    @JvmField
    public val addNavigationLayerName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("add_navigation_layer")

    @JvmField
    public val moveNavigationLayerName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("move_navigation_layer")

    @JvmField
    public val removeNavigationLayerName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("remove_navigation_layer")

    @JvmField
    public val setNavigationLayerLayersName: MethodStringName2<TileSet, Unit, Int, Long> =
        MethodStringName2<TileSet, Unit, Int, Long>("set_navigation_layer_layers")

    @JvmField
    public val getNavigationLayerLayersName: MethodStringName1<TileSet, Long, Int> =
        MethodStringName1<TileSet, Long, Int>("get_navigation_layer_layers")

    @JvmField
    public val setNavigationLayerLayerValueName: MethodStringName3<TileSet, Unit, Int, Int, Boolean>
        = MethodStringName3<TileSet, Unit, Int, Int, Boolean>("set_navigation_layer_layer_value")

    @JvmField
    public val getNavigationLayerLayerValueName: MethodStringName2<TileSet, Boolean, Int, Int> =
        MethodStringName2<TileSet, Boolean, Int, Int>("get_navigation_layer_layer_value")

    @JvmField
    public val getCustomDataLayersCountName: MethodStringName0<TileSet, Int> =
        MethodStringName0<TileSet, Int>("get_custom_data_layers_count")

    @JvmField
    public val addCustomDataLayerName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("add_custom_data_layer")

    @JvmField
    public val moveCustomDataLayerName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("move_custom_data_layer")

    @JvmField
    public val removeCustomDataLayerName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("remove_custom_data_layer")

    @JvmField
    public val getCustomDataLayerByNameName: MethodStringName1<TileSet, Int, String> =
        MethodStringName1<TileSet, Int, String>("get_custom_data_layer_by_name")

    @JvmField
    public val setCustomDataLayerNameName: MethodStringName2<TileSet, Unit, Int, String> =
        MethodStringName2<TileSet, Unit, Int, String>("set_custom_data_layer_name")

    @JvmField
    public val hasCustomDataLayerByNameName: MethodStringName1<TileSet, Boolean, String> =
        MethodStringName1<TileSet, Boolean, String>("has_custom_data_layer_by_name")

    @JvmField
    public val getCustomDataLayerNameName: MethodStringName1<TileSet, String, Int> =
        MethodStringName1<TileSet, String, Int>("get_custom_data_layer_name")

    @JvmField
    public val setCustomDataLayerTypeName: MethodStringName2<TileSet, Unit, Int, VariantType> =
        MethodStringName2<TileSet, Unit, Int, VariantType>("set_custom_data_layer_type")

    @JvmField
    public val getCustomDataLayerTypeName: MethodStringName1<TileSet, VariantType, Int> =
        MethodStringName1<TileSet, VariantType, Int>("get_custom_data_layer_type")

    @JvmField
    public val setSourceLevelTileProxyName: MethodStringName2<TileSet, Unit, Int, Int> =
        MethodStringName2<TileSet, Unit, Int, Int>("set_source_level_tile_proxy")

    @JvmField
    public val getSourceLevelTileProxyName: MethodStringName1<TileSet, Int, Int> =
        MethodStringName1<TileSet, Int, Int>("get_source_level_tile_proxy")

    @JvmField
    public val hasSourceLevelTileProxyName: MethodStringName1<TileSet, Boolean, Int> =
        MethodStringName1<TileSet, Boolean, Int>("has_source_level_tile_proxy")

    @JvmField
    public val removeSourceLevelTileProxyName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("remove_source_level_tile_proxy")

    @JvmField
    public val setCoordsLevelTileProxyName:
        MethodStringName4<TileSet, Unit, Int, Vector2i, Int, Vector2i> =
        MethodStringName4<TileSet, Unit, Int, Vector2i, Int, Vector2i>("set_coords_level_tile_proxy")

    @JvmField
    public val getCoordsLevelTileProxyName:
        MethodStringName2<TileSet, VariantArray<Any?>, Int, Vector2i> =
        MethodStringName2<TileSet, VariantArray<Any?>, Int, Vector2i>("get_coords_level_tile_proxy")

    @JvmField
    public val hasCoordsLevelTileProxyName: MethodStringName2<TileSet, Boolean, Int, Vector2i> =
        MethodStringName2<TileSet, Boolean, Int, Vector2i>("has_coords_level_tile_proxy")

    @JvmField
    public val removeCoordsLevelTileProxyName: MethodStringName2<TileSet, Unit, Int, Vector2i> =
        MethodStringName2<TileSet, Unit, Int, Vector2i>("remove_coords_level_tile_proxy")

    @JvmField
    public val setAlternativeLevelTileProxyName:
        MethodStringName6<TileSet, Unit, Int, Vector2i, Int, Int, Vector2i, Int> =
        MethodStringName6<TileSet, Unit, Int, Vector2i, Int, Int, Vector2i, Int>("set_alternative_level_tile_proxy")

    @JvmField
    public val getAlternativeLevelTileProxyName:
        MethodStringName3<TileSet, VariantArray<Any?>, Int, Vector2i, Int> =
        MethodStringName3<TileSet, VariantArray<Any?>, Int, Vector2i, Int>("get_alternative_level_tile_proxy")

    @JvmField
    public val hasAlternativeLevelTileProxyName:
        MethodStringName3<TileSet, Boolean, Int, Vector2i, Int> =
        MethodStringName3<TileSet, Boolean, Int, Vector2i, Int>("has_alternative_level_tile_proxy")

    @JvmField
    public val removeAlternativeLevelTileProxyName:
        MethodStringName3<TileSet, Unit, Int, Vector2i, Int> =
        MethodStringName3<TileSet, Unit, Int, Vector2i, Int>("remove_alternative_level_tile_proxy")

    @JvmField
    public val mapTileProxyName: MethodStringName3<TileSet, VariantArray<Any?>, Int, Vector2i, Int>
        = MethodStringName3<TileSet, VariantArray<Any?>, Int, Vector2i, Int>("map_tile_proxy")

    @JvmField
    public val cleanupInvalidTileProxiesName: MethodStringName0<TileSet, Unit> =
        MethodStringName0<TileSet, Unit>("cleanup_invalid_tile_proxies")

    @JvmField
    public val clearTileProxiesName: MethodStringName0<TileSet, Unit> =
        MethodStringName0<TileSet, Unit>("clear_tile_proxies")

    @JvmField
    public val addPatternName: MethodStringName2<TileSet, Int, TileMapPattern?, Int> =
        MethodStringName2<TileSet, Int, TileMapPattern?, Int>("add_pattern")

    @JvmField
    public val getPatternName: MethodStringName1<TileSet, TileMapPattern?, Int> =
        MethodStringName1<TileSet, TileMapPattern?, Int>("get_pattern")

    @JvmField
    public val removePatternName: MethodStringName1<TileSet, Unit, Int> =
        MethodStringName1<TileSet, Unit, Int>("remove_pattern")

    @JvmField
    public val getPatternsCountName: MethodStringName0<TileSet, Int> =
        MethodStringName0<TileSet, Int>("get_patterns_count")
  }

  public object MethodBindings {
    internal val getNextSourceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_next_source_id", 3905245786)

    internal val addSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "add_source", 1059186179)

    internal val removeSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_source", 1286410249)

    internal val setSourceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_source_id", 3937882851)

    internal val getSourceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_source_count", 3905245786)

    internal val getSourceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_source_id", 923996154)

    internal val hasSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "has_source", 1116898809)

    internal val getSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_source", 1763540252)

    internal val setTileShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_tile_shape", 2131427112)

    internal val getTileShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_tile_shape", 716918169)

    internal val setTileLayoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_tile_layout", 1071216679)

    internal val getTileLayoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_tile_layout", 194628839)

    internal val setTileOffsetAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_tile_offset_axis", 3300198521)

    internal val getTileOffsetAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_tile_offset_axis", 762494114)

    internal val setTileSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_tile_size", 1130785943)

    internal val getTileSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_tile_size", 3690982128)

    internal val setUvClippingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_uv_clipping", 2586408642)

    internal val isUvClippingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "is_uv_clipping", 36873697)

    internal val getOcclusionLayersCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_occlusion_layers_count", 3905245786)

    internal val addOcclusionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "add_occlusion_layer", 1025054187)

    internal val moveOcclusionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "move_occlusion_layer", 3937882851)

    internal val removeOcclusionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_occlusion_layer", 1286410249)

    internal val setOcclusionLayerLightMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_occlusion_layer_light_mask", 3937882851)

    internal val getOcclusionLayerLightMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_occlusion_layer_light_mask", 923996154)

    internal val setOcclusionLayerSdfCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_occlusion_layer_sdf_collision", 300928843)

    internal val getOcclusionLayerSdfCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_occlusion_layer_sdf_collision", 1116898809)

    internal val getPhysicsLayersCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_physics_layers_count", 3905245786)

    internal val addPhysicsLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "add_physics_layer", 1025054187)

    internal val movePhysicsLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "move_physics_layer", 3937882851)

    internal val removePhysicsLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_physics_layer", 1286410249)

    internal val setPhysicsLayerCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_physics_layer_collision_layer", 3937882851)

    internal val getPhysicsLayerCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_physics_layer_collision_layer", 923996154)

    internal val setPhysicsLayerCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_physics_layer_collision_mask", 3937882851)

    internal val getPhysicsLayerCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_physics_layer_collision_mask", 923996154)

    internal val setPhysicsLayerCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_physics_layer_collision_priority", 1602489585)

    internal val getPhysicsLayerCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_physics_layer_collision_priority", 2339986948)

    internal val setPhysicsLayerPhysicsMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_physics_layer_physics_material", 1018687357)

    internal val getPhysicsLayerPhysicsMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_physics_layer_physics_material", 788318639)

    internal val getTerrainSetsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_terrain_sets_count", 3905245786)

    internal val addTerrainSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "add_terrain_set", 1025054187)

    internal val moveTerrainSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "move_terrain_set", 3937882851)

    internal val removeTerrainSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_terrain_set", 1286410249)

    internal val setTerrainSetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_terrain_set_mode", 3943003916)

    internal val getTerrainSetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_terrain_set_mode", 2084469411)

    internal val getTerrainsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_terrains_count", 923996154)

    internal val addTerrainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "add_terrain", 1230568737)

    internal val moveTerrainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "move_terrain", 1649997291)

    internal val removeTerrainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_terrain", 3937882851)

    internal val clearTerrainsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "clear_terrains", 1286410249)

    internal val setTerrainNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_terrain_name", 2285447957)

    internal val getTerrainNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_terrain_name", 1391810591)

    internal val setTerrainColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_terrain_color", 3733378741)

    internal val getTerrainColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_terrain_color", 2165839948)

    internal val getNavigationLayersCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_navigation_layers_count", 3905245786)

    internal val addNavigationLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "add_navigation_layer", 1025054187)

    internal val moveNavigationLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "move_navigation_layer", 3937882851)

    internal val removeNavigationLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_navigation_layer", 1286410249)

    internal val setNavigationLayerLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_navigation_layer_layers", 3937882851)

    internal val getNavigationLayerLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_navigation_layer_layers", 923996154)

    internal val setNavigationLayerLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_navigation_layer_layer_value", 1383440665)

    internal val getNavigationLayerLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_navigation_layer_layer_value", 2522259332)

    internal val getCustomDataLayersCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_custom_data_layers_count", 3905245786)

    internal val addCustomDataLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "add_custom_data_layer", 1025054187)

    internal val moveCustomDataLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "move_custom_data_layer", 3937882851)

    internal val removeCustomDataLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_custom_data_layer", 1286410249)

    internal val getCustomDataLayerByNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_custom_data_layer_by_name", 1321353865)

    internal val setCustomDataLayerNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_custom_data_layer_name", 501894301)

    internal val hasCustomDataLayerByNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "has_custom_data_layer_by_name", 3927539163)

    internal val getCustomDataLayerNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_custom_data_layer_name", 844755477)

    internal val setCustomDataLayerTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_custom_data_layer_type", 3492912874)

    internal val getCustomDataLayerTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_custom_data_layer_type", 2990820875)

    internal val setSourceLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_source_level_tile_proxy", 3937882851)

    internal val getSourceLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_source_level_tile_proxy", 3744713108)

    internal val hasSourceLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "has_source_level_tile_proxy", 3067735520)

    internal val removeSourceLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_source_level_tile_proxy", 1286410249)

    internal val setCoordsLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_coords_level_tile_proxy", 1769939278)

    internal val getCoordsLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_coords_level_tile_proxy", 2856536371)

    internal val hasCoordsLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "has_coords_level_tile_proxy", 3957903770)

    internal val removeCoordsLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_coords_level_tile_proxy", 2311374912)

    internal val setAlternativeLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "set_alternative_level_tile_proxy", 3862385460)

    internal val getAlternativeLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_alternative_level_tile_proxy", 2303761075)

    internal val hasAlternativeLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "has_alternative_level_tile_proxy", 180086755)

    internal val removeAlternativeLevelTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_alternative_level_tile_proxy", 2328951467)

    internal val mapTileProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "map_tile_proxy", 4267935328)

    internal val cleanupInvalidTileProxiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "cleanup_invalid_tile_proxies", 3218959716)

    internal val clearTileProxiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "clear_tile_proxies", 3218959716)

    internal val addPatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "add_pattern", 763712015)

    internal val getPatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_pattern", 4207737510)

    internal val removePatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "remove_pattern", 1286410249)

    internal val getPatternsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSet", "get_patterns_count", 2455072627)
  }
}
