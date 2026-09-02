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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.PackedVector2Array
import godot.core.Signal0
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2
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
 * [TileData] object represents a single tile in a [TileSet]. It is usually edited using the tileset
 * editor, but it can be modified at runtime using [TileMapLayer.TileDataRuntimeUpdate].
 */
@GodotBaseType
public open class TileData : Object() {
  /**
   * Emitted when any of the properties are changed.
   */
  public val changed: Signal0 by Signal0

  /**
   * If `true`, the tile will have its texture flipped horizontally.
   */
  public final inline var flipH: Boolean
    @JvmName("flipHProperty")
    get() = getFlipH()
    @JvmName("flipHProperty")
    set(`value`) {
      setFlipH(value)
    }

  /**
   * If `true`, the tile will have its texture flipped vertically.
   */
  public final inline var flipV: Boolean
    @JvmName("flipVProperty")
    get() = getFlipV()
    @JvmName("flipVProperty")
    set(`value`) {
      setFlipV(value)
    }

  /**
   * If `true`, the tile will display transposed, i.e. with horizontal and vertical texture UVs
   * swapped.
   */
  public final inline var transpose: Boolean
    @JvmName("transposeProperty")
    get() = getTranspose()
    @JvmName("transposeProperty")
    set(`value`) {
      setTranspose(value)
    }

  /**
   * Offsets the position of where the tile is drawn.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var textureOrigin: Vector2i
    @JvmName("textureOriginProperty")
    get() = getTextureOrigin()
    @JvmName("textureOriginProperty")
    set(`value`) {
      setTextureOrigin(value)
    }

  /**
   * Color modulation of the tile.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var modulate: Color
    @JvmName("modulateProperty")
    get() = getModulate()
    @JvmName("modulateProperty")
    set(`value`) {
      setModulate(value)
    }

  /**
   * The [Material] to use for this [TileData]. This can be a [CanvasItemMaterial] to use the
   * default shader, or a [ShaderMaterial] to use a custom shader.
   */
  public final inline var material: Material?
    @JvmName("materialProperty")
    get() = getMaterial()
    @JvmName("materialProperty")
    set(`value`) {
      setMaterial(value)
    }

  /**
   * Ordering index of this tile, relative to [TileMapLayer].
   */
  public final inline var zIndex: Int
    @JvmName("zIndexProperty")
    get() = getZIndex()
    @JvmName("zIndexProperty")
    set(`value`) {
      setZIndex(value)
    }

  /**
   * Vertical point of the tile used for determining y-sorted order.
   */
  public final inline var ySortOrigin: Int
    @JvmName("ySortOriginProperty")
    get() = getYSortOrigin()
    @JvmName("ySortOriginProperty")
    set(`value`) {
      setYSortOrigin(value)
    }

  /**
   * ID of the terrain set that the tile uses.
   */
  public final inline var terrainSet: Int
    @JvmName("terrainSetProperty")
    get() = getTerrainSet()
    @JvmName("terrainSetProperty")
    set(`value`) {
      setTerrainSet(value)
    }

  /**
   * ID of the terrain from the terrain set that the tile uses.
   */
  public final inline var terrain: Int
    @JvmName("terrainProperty")
    get() = getTerrain()
    @JvmName("terrainProperty")
    set(`value`) {
      setTerrain(value)
    }

  /**
   * Relative probability of this tile being selected when drawing a pattern of random tiles.
   */
  public final inline var probability: Float
    @JvmName("probabilityProperty")
    get() = getProbability()
    @JvmName("probabilityProperty")
    set(`value`) {
      setProbability(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(756, scriptPtr)
  }

  /**
   * This is a helper function for [textureOrigin] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = tiledata.textureOrigin
   * //Your changes
   * tiledata.textureOrigin = myCoreType
   * ``````
   *
   * Offsets the position of where the tile is drawn.
   */
  @CoreTypeHelper
  public final fun textureOriginMutate(block: Vector2i.() -> Unit): Vector2i = textureOrigin.apply {
     block(this)
     textureOrigin = this
  }

  /**
   * This is a helper function for [modulate] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = tiledata.modulate
   * //Your changes
   * tiledata.modulate = myCoreType
   * ``````
   *
   * Color modulation of the tile.
   */
  @CoreTypeHelper
  public final fun modulateMutate(block: Color.() -> Unit): Color = modulate.apply {
     block(this)
     modulate = this
  }

  public final fun setFlipH(flipH: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flipH)
    TransferContext.callMethod(MethodBindings.setFlipHPtr)
  }

  public final fun getFlipH(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFlipHPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFlipV(flipV: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flipV)
    TransferContext.callMethod(MethodBindings.setFlipVPtr)
  }

  public final fun getFlipV(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFlipVPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTranspose(transpose: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to transpose)
    TransferContext.callMethod(MethodBindings.setTransposePtr)
  }

  public final fun getTranspose(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransposePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMaterial(material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to material)
    TransferContext.callMethod(MethodBindings.setMaterialPtr)
  }

  public final fun getMaterial(): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  public final fun setTextureOrigin(textureOrigin: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to textureOrigin)
    TransferContext.callMethod(MethodBindings.setTextureOriginPtr)
  }

  public final fun getTextureOrigin(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureOriginPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setModulate(modulate: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to modulate)
    TransferContext.callMethod(MethodBindings.setModulatePtr)
  }

  public final fun getModulate(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModulatePtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setZIndex(zIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to zIndex.toLong())
    TransferContext.callMethod(MethodBindings.setZIndexPtr)
  }

  public final fun getZIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
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

  /**
   * Sets the occluder polygon count in the TileSet occlusion layer with index [layerId].
   */
  public final fun setOccluderPolygonsCount(layerId: Int, polygonsCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonsCount.toLong())
    TransferContext.callMethod(MethodBindings.setOccluderPolygonsCountPtr)
  }

  /**
   * Returns the number of occluder polygons of the tile in the TileSet occlusion layer with index
   * [layerId].
   */
  public final fun getOccluderPolygonsCount(layerId: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong())
    TransferContext.callMethod(MethodBindings.getOccluderPolygonsCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds an occlusion polygon to the tile on the TileSet occlusion layer with index [layerId].
   */
  public final fun addOccluderPolygon(layerId: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong())
    TransferContext.callMethod(MethodBindings.addOccluderPolygonPtr)
  }

  /**
   * Removes the polygon at index [polygonIndex] for TileSet occlusion layer with index [layerId].
   */
  public final fun removeOccluderPolygon(layerId: Int, polygonIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong())
    TransferContext.callMethod(MethodBindings.removeOccluderPolygonPtr)
  }

  /**
   * Sets the occluder for polygon with index [polygonIndex] in the TileSet occlusion layer with
   * index [layerId].
   */
  public final fun setOccluderPolygon(
    layerId: Int,
    polygonIndex: Int,
    polygon: OccluderPolygon2D?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong(), OBJECT to polygon)
    TransferContext.callMethod(MethodBindings.setOccluderPolygonPtr)
  }

  /**
   * Returns the occluder polygon at index [polygonIndex] from the TileSet occlusion layer with
   * index [layerId].
   *
   * The [flipH], [flipV], and [transpose] parameters can be `true` to transform the returned
   * polygon.
   */
  @JvmOverloads
  public final fun getOccluderPolygon(
    layerId: Int,
    polygonIndex: Int,
    flipH: Boolean = false,
    flipV: Boolean = false,
    transpose: Boolean = false,
  ): OccluderPolygon2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong(), BOOL to flipH, BOOL to flipV, BOOL to transpose)
    TransferContext.callMethod(MethodBindings.getOccluderPolygonPtr)
    return (TransferContext.readReturnValue(OBJECT) as OccluderPolygon2D?)
  }

  /**
   * Sets the occluder for the TileSet occlusion layer with index [layerId].
   */
  public final fun setOccluder(layerId: Int, occluderPolygon: OccluderPolygon2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), OBJECT to occluderPolygon)
    TransferContext.callMethod(MethodBindings.setOccluderPtr)
  }

  /**
   * Returns the occluder polygon of the tile for the TileSet occlusion layer with index [layerId].
   *
   * [flipH], [flipV], and [transpose] allow transforming the returned polygon.
   */
  @JvmOverloads
  public final fun getOccluder(
    layerId: Int,
    flipH: Boolean = false,
    flipV: Boolean = false,
    transpose: Boolean = false,
  ): OccluderPolygon2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), BOOL to flipH, BOOL to flipV, BOOL to transpose)
    TransferContext.callMethod(MethodBindings.getOccluderPtr)
    return (TransferContext.readReturnValue(OBJECT) as OccluderPolygon2D?)
  }

  /**
   * Sets the constant linear velocity. This does not move the tile. This linear velocity is applied
   * to objects colliding with this tile. This is useful to create conveyor belts.
   */
  public final fun setConstantLinearVelocity(layerId: Int, velocity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), VECTOR2 to velocity)
    TransferContext.callMethod(MethodBindings.setConstantLinearVelocityPtr)
  }

  /**
   * Returns the constant linear velocity applied to objects colliding with this tile.
   */
  public final fun getConstantLinearVelocity(layerId: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong())
    TransferContext.callMethod(MethodBindings.getConstantLinearVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets the constant angular velocity. This does not rotate the tile. This angular velocity is
   * applied to objects colliding with this tile.
   */
  public final fun setConstantAngularVelocity(layerId: Int, velocity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), DOUBLE to velocity.toDouble())
    TransferContext.callMethod(MethodBindings.setConstantAngularVelocityPtr)
  }

  /**
   * Returns the constant angular velocity applied to objects colliding with this tile.
   */
  public final fun getConstantAngularVelocity(layerId: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong())
    TransferContext.callMethod(MethodBindings.getConstantAngularVelocityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the polygons count for TileSet physics layer with index [layerId].
   */
  public final fun setCollisionPolygonsCount(layerId: Int, polygonsCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonsCount.toLong())
    TransferContext.callMethod(MethodBindings.setCollisionPolygonsCountPtr)
  }

  /**
   * Returns how many polygons the tile has for TileSet physics layer with index [layerId].
   */
  public final fun getCollisionPolygonsCount(layerId: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionPolygonsCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a collision polygon to the tile on the given TileSet physics layer.
   */
  public final fun addCollisionPolygon(layerId: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong())
    TransferContext.callMethod(MethodBindings.addCollisionPolygonPtr)
  }

  /**
   * Removes the polygon at index [polygonIndex] for TileSet physics layer with index [layerId].
   */
  public final fun removeCollisionPolygon(layerId: Int, polygonIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong())
    TransferContext.callMethod(MethodBindings.removeCollisionPolygonPtr)
  }

  /**
   * Sets the points of the polygon at index [polygonIndex] for TileSet physics layer with index
   * [layerId].
   */
  public final fun setCollisionPolygonPoints(
    layerId: Int,
    polygonIndex: Int,
    polygon: PackedVector2Array,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong(), PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.setCollisionPolygonPointsPtr)
  }

  /**
   * Returns the points of the polygon at index [polygonIndex] for TileSet physics layer with index
   * [layerId].
   */
  public final fun getCollisionPolygonPoints(layerId: Int, polygonIndex: Int): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionPolygonPointsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Enables/disables one-way collisions on the polygon at index [polygonIndex] for TileSet physics
   * layer with index [layerId].
   */
  public final fun setCollisionPolygonOneWay(
    layerId: Int,
    polygonIndex: Int,
    oneWay: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong(), BOOL to oneWay)
    TransferContext.callMethod(MethodBindings.setCollisionPolygonOneWayPtr)
  }

  /**
   * Returns whether one-way collisions are enabled for the polygon at index [polygonIndex] for
   * TileSet physics layer with index [layerId].
   */
  public final fun isCollisionPolygonOneWay(layerId: Int, polygonIndex: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong())
    TransferContext.callMethod(MethodBindings.isCollisionPolygonOneWayPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the one-way margin (for one-way platforms) of the polygon at index [polygonIndex] for
   * TileSet physics layer with index [layerId].
   */
  public final fun setCollisionPolygonOneWayMargin(
    layerId: Int,
    polygonIndex: Int,
    oneWayMargin: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong(), DOUBLE to oneWayMargin.toDouble())
    TransferContext.callMethod(MethodBindings.setCollisionPolygonOneWayMarginPtr)
  }

  /**
   * Returns the one-way margin (for one-way platforms) of the polygon at index [polygonIndex] for
   * TileSet physics layer with index [layerId].
   */
  public final fun getCollisionPolygonOneWayMargin(layerId: Int, polygonIndex: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), LONG to polygonIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionPolygonOneWayMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTerrainSet(terrainSet: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrainSet.toLong())
    TransferContext.callMethod(MethodBindings.setTerrainSetPtr)
  }

  public final fun getTerrainSet(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTerrainSetPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setTerrain(terrain: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to terrain.toLong())
    TransferContext.callMethod(MethodBindings.setTerrainPtr)
  }

  public final fun getTerrain(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTerrainPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the tile's terrain bit for the given [peeringBit] direction. To check that a direction is
   * valid, use [isValidTerrainPeeringBit].
   */
  public final fun setTerrainPeeringBit(peeringBit: TileSet.CellNeighbor, terrain: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to peeringBit.value, LONG to terrain.toLong())
    TransferContext.callMethod(MethodBindings.setTerrainPeeringBitPtr)
  }

  /**
   * Returns the tile's terrain bit for the given [peeringBit] direction. To check that a direction
   * is valid, use [isValidTerrainPeeringBit].
   */
  public final fun getTerrainPeeringBit(peeringBit: TileSet.CellNeighbor): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to peeringBit.value)
    TransferContext.callMethod(MethodBindings.getTerrainPeeringBitPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns whether the given [peeringBit] direction is valid for this tile.
   */
  public final fun isValidTerrainPeeringBit(peeringBit: TileSet.CellNeighbor): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to peeringBit.value)
    TransferContext.callMethod(MethodBindings.isValidTerrainPeeringBitPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the navigation polygon for the TileSet navigation layer with index [layerId].
   */
  public final fun setNavigationPolygon(layerId: Int, navigationPolygon: NavigationPolygon?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), OBJECT to navigationPolygon)
    TransferContext.callMethod(MethodBindings.setNavigationPolygonPtr)
  }

  /**
   * Returns the navigation polygon of the tile for the TileSet navigation layer with index
   * [layerId].
   *
   * [flipH], [flipV], and [transpose] allow transforming the returned polygon.
   */
  @JvmOverloads
  public final fun getNavigationPolygon(
    layerId: Int,
    flipH: Boolean = false,
    flipV: Boolean = false,
    transpose: Boolean = false,
  ): NavigationPolygon? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), BOOL to flipH, BOOL to flipV, BOOL to transpose)
    TransferContext.callMethod(MethodBindings.getNavigationPolygonPtr)
    return (TransferContext.readReturnValue(OBJECT) as NavigationPolygon?)
  }

  public final fun setProbability(probability: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to probability.toDouble())
    TransferContext.callMethod(MethodBindings.setProbabilityPtr)
  }

  public final fun getProbability(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProbabilityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the tile's custom data value for the TileSet custom data layer with name [layerName].
   */
  public final fun setCustomData(layerName: String, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to layerName, ANY to value)
    TransferContext.callMethod(MethodBindings.setCustomDataPtr)
  }

  /**
   * Returns the custom data value for custom data layer named [layerName]. To check if a custom
   * data layer exists, use [hasCustomData].
   */
  public final fun getCustomData(layerName: String): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to layerName)
    TransferContext.callMethod(MethodBindings.getCustomDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns whether there exists a custom data layer named [layerName].
   */
  public final fun hasCustomData(layerName: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to layerName)
    TransferContext.callMethod(MethodBindings.hasCustomDataPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the tile's custom data value for the TileSet custom data layer with index [layerId].
   */
  public final fun setCustomDataByLayerId(layerId: Int, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong(), ANY to value)
    TransferContext.callMethod(MethodBindings.setCustomDataByLayerIdPtr)
  }

  /**
   * Returns the custom data value for custom data layer with index [layerId].
   */
  public final fun getCustomDataByLayerId(layerId: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerId.toLong())
    TransferContext.callMethod(MethodBindings.getCustomDataByLayerIdPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public companion object {
    @JvmField
    public val setFlipHName: MethodStringName1<TileData, Unit, Boolean> =
        MethodStringName1<TileData, Unit, Boolean>("set_flip_h")

    @JvmField
    public val getFlipHName: MethodStringName0<TileData, Boolean> =
        MethodStringName0<TileData, Boolean>("get_flip_h")

    @JvmField
    public val setFlipVName: MethodStringName1<TileData, Unit, Boolean> =
        MethodStringName1<TileData, Unit, Boolean>("set_flip_v")

    @JvmField
    public val getFlipVName: MethodStringName0<TileData, Boolean> =
        MethodStringName0<TileData, Boolean>("get_flip_v")

    @JvmField
    public val setTransposeName: MethodStringName1<TileData, Unit, Boolean> =
        MethodStringName1<TileData, Unit, Boolean>("set_transpose")

    @JvmField
    public val getTransposeName: MethodStringName0<TileData, Boolean> =
        MethodStringName0<TileData, Boolean>("get_transpose")

    @JvmField
    public val setMaterialName: MethodStringName1<TileData, Unit, Material?> =
        MethodStringName1<TileData, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<TileData, Material?> =
        MethodStringName0<TileData, Material?>("get_material")

    @JvmField
    public val setTextureOriginName: MethodStringName1<TileData, Unit, Vector2i> =
        MethodStringName1<TileData, Unit, Vector2i>("set_texture_origin")

    @JvmField
    public val getTextureOriginName: MethodStringName0<TileData, Vector2i> =
        MethodStringName0<TileData, Vector2i>("get_texture_origin")

    @JvmField
    public val setModulateName: MethodStringName1<TileData, Unit, Color> =
        MethodStringName1<TileData, Unit, Color>("set_modulate")

    @JvmField
    public val getModulateName: MethodStringName0<TileData, Color> =
        MethodStringName0<TileData, Color>("get_modulate")

    @JvmField
    public val setZIndexName: MethodStringName1<TileData, Unit, Int> =
        MethodStringName1<TileData, Unit, Int>("set_z_index")

    @JvmField
    public val getZIndexName: MethodStringName0<TileData, Int> =
        MethodStringName0<TileData, Int>("get_z_index")

    @JvmField
    public val setYSortOriginName: MethodStringName1<TileData, Unit, Int> =
        MethodStringName1<TileData, Unit, Int>("set_y_sort_origin")

    @JvmField
    public val getYSortOriginName: MethodStringName0<TileData, Int> =
        MethodStringName0<TileData, Int>("get_y_sort_origin")

    @JvmField
    public val setOccluderPolygonsCountName: MethodStringName2<TileData, Unit, Int, Int> =
        MethodStringName2<TileData, Unit, Int, Int>("set_occluder_polygons_count")

    @JvmField
    public val getOccluderPolygonsCountName: MethodStringName1<TileData, Int, Int> =
        MethodStringName1<TileData, Int, Int>("get_occluder_polygons_count")

    @JvmField
    public val addOccluderPolygonName: MethodStringName1<TileData, Unit, Int> =
        MethodStringName1<TileData, Unit, Int>("add_occluder_polygon")

    @JvmField
    public val removeOccluderPolygonName: MethodStringName2<TileData, Unit, Int, Int> =
        MethodStringName2<TileData, Unit, Int, Int>("remove_occluder_polygon")

    @JvmField
    public val setOccluderPolygonName:
        MethodStringName3<TileData, Unit, Int, Int, OccluderPolygon2D?> =
        MethodStringName3<TileData, Unit, Int, Int, OccluderPolygon2D?>("set_occluder_polygon")

    @JvmField
    public val getOccluderPolygonName:
        MethodStringName5<TileData, OccluderPolygon2D?, Int, Int, Boolean, Boolean, Boolean> =
        MethodStringName5<TileData, OccluderPolygon2D?, Int, Int, Boolean, Boolean, Boolean>("get_occluder_polygon")

    @JvmField
    public val setOccluderName: MethodStringName2<TileData, Unit, Int, OccluderPolygon2D?> =
        MethodStringName2<TileData, Unit, Int, OccluderPolygon2D?>("set_occluder")

    @JvmField
    public val getOccluderName:
        MethodStringName4<TileData, OccluderPolygon2D?, Int, Boolean, Boolean, Boolean> =
        MethodStringName4<TileData, OccluderPolygon2D?, Int, Boolean, Boolean, Boolean>("get_occluder")

    @JvmField
    public val setConstantLinearVelocityName: MethodStringName2<TileData, Unit, Int, Vector2> =
        MethodStringName2<TileData, Unit, Int, Vector2>("set_constant_linear_velocity")

    @JvmField
    public val getConstantLinearVelocityName: MethodStringName1<TileData, Vector2, Int> =
        MethodStringName1<TileData, Vector2, Int>("get_constant_linear_velocity")

    @JvmField
    public val setConstantAngularVelocityName: MethodStringName2<TileData, Unit, Int, Float> =
        MethodStringName2<TileData, Unit, Int, Float>("set_constant_angular_velocity")

    @JvmField
    public val getConstantAngularVelocityName: MethodStringName1<TileData, Float, Int> =
        MethodStringName1<TileData, Float, Int>("get_constant_angular_velocity")

    @JvmField
    public val setCollisionPolygonsCountName: MethodStringName2<TileData, Unit, Int, Int> =
        MethodStringName2<TileData, Unit, Int, Int>("set_collision_polygons_count")

    @JvmField
    public val getCollisionPolygonsCountName: MethodStringName1<TileData, Int, Int> =
        MethodStringName1<TileData, Int, Int>("get_collision_polygons_count")

    @JvmField
    public val addCollisionPolygonName: MethodStringName1<TileData, Unit, Int> =
        MethodStringName1<TileData, Unit, Int>("add_collision_polygon")

    @JvmField
    public val removeCollisionPolygonName: MethodStringName2<TileData, Unit, Int, Int> =
        MethodStringName2<TileData, Unit, Int, Int>("remove_collision_polygon")

    @JvmField
    public val setCollisionPolygonPointsName:
        MethodStringName3<TileData, Unit, Int, Int, PackedVector2Array> =
        MethodStringName3<TileData, Unit, Int, Int, PackedVector2Array>("set_collision_polygon_points")

    @JvmField
    public val getCollisionPolygonPointsName:
        MethodStringName2<TileData, PackedVector2Array, Int, Int> =
        MethodStringName2<TileData, PackedVector2Array, Int, Int>("get_collision_polygon_points")

    @JvmField
    public val setCollisionPolygonOneWayName: MethodStringName3<TileData, Unit, Int, Int, Boolean> =
        MethodStringName3<TileData, Unit, Int, Int, Boolean>("set_collision_polygon_one_way")

    @JvmField
    public val isCollisionPolygonOneWayName: MethodStringName2<TileData, Boolean, Int, Int> =
        MethodStringName2<TileData, Boolean, Int, Int>("is_collision_polygon_one_way")

    @JvmField
    public val setCollisionPolygonOneWayMarginName:
        MethodStringName3<TileData, Unit, Int, Int, Float> =
        MethodStringName3<TileData, Unit, Int, Int, Float>("set_collision_polygon_one_way_margin")

    @JvmField
    public val getCollisionPolygonOneWayMarginName: MethodStringName2<TileData, Float, Int, Int> =
        MethodStringName2<TileData, Float, Int, Int>("get_collision_polygon_one_way_margin")

    @JvmField
    public val setTerrainSetName: MethodStringName1<TileData, Unit, Int> =
        MethodStringName1<TileData, Unit, Int>("set_terrain_set")

    @JvmField
    public val getTerrainSetName: MethodStringName0<TileData, Int> =
        MethodStringName0<TileData, Int>("get_terrain_set")

    @JvmField
    public val setTerrainName: MethodStringName1<TileData, Unit, Int> =
        MethodStringName1<TileData, Unit, Int>("set_terrain")

    @JvmField
    public val getTerrainName: MethodStringName0<TileData, Int> =
        MethodStringName0<TileData, Int>("get_terrain")

    @JvmField
    public val setTerrainPeeringBitName:
        MethodStringName2<TileData, Unit, TileSet.CellNeighbor, Int> =
        MethodStringName2<TileData, Unit, TileSet.CellNeighbor, Int>("set_terrain_peering_bit")

    @JvmField
    public val getTerrainPeeringBitName: MethodStringName1<TileData, Int, TileSet.CellNeighbor> =
        MethodStringName1<TileData, Int, TileSet.CellNeighbor>("get_terrain_peering_bit")

    @JvmField
    public val isValidTerrainPeeringBitName:
        MethodStringName1<TileData, Boolean, TileSet.CellNeighbor> =
        MethodStringName1<TileData, Boolean, TileSet.CellNeighbor>("is_valid_terrain_peering_bit")

    @JvmField
    public val setNavigationPolygonName: MethodStringName2<TileData, Unit, Int, NavigationPolygon?>
        = MethodStringName2<TileData, Unit, Int, NavigationPolygon?>("set_navigation_polygon")

    @JvmField
    public val getNavigationPolygonName:
        MethodStringName4<TileData, NavigationPolygon?, Int, Boolean, Boolean, Boolean> =
        MethodStringName4<TileData, NavigationPolygon?, Int, Boolean, Boolean, Boolean>("get_navigation_polygon")

    @JvmField
    public val setProbabilityName: MethodStringName1<TileData, Unit, Float> =
        MethodStringName1<TileData, Unit, Float>("set_probability")

    @JvmField
    public val getProbabilityName: MethodStringName0<TileData, Float> =
        MethodStringName0<TileData, Float>("get_probability")

    @JvmField
    public val setCustomDataName: MethodStringName2<TileData, Unit, String, Any?> =
        MethodStringName2<TileData, Unit, String, Any?>("set_custom_data")

    @JvmField
    public val getCustomDataName: MethodStringName1<TileData, Any?, String> =
        MethodStringName1<TileData, Any?, String>("get_custom_data")

    @JvmField
    public val hasCustomDataName: MethodStringName1<TileData, Boolean, String> =
        MethodStringName1<TileData, Boolean, String>("has_custom_data")

    @JvmField
    public val setCustomDataByLayerIdName: MethodStringName2<TileData, Unit, Int, Any?> =
        MethodStringName2<TileData, Unit, Int, Any?>("set_custom_data_by_layer_id")

    @JvmField
    public val getCustomDataByLayerIdName: MethodStringName1<TileData, Any?, Int> =
        MethodStringName1<TileData, Any?, Int>("get_custom_data_by_layer_id")
  }

  public object MethodBindings {
    internal val setFlipHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_flip_h", 2586408642)

    internal val getFlipHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_flip_h", 36873697)

    internal val setFlipVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_flip_v", 2586408642)

    internal val getFlipVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_flip_v", 36873697)

    internal val setTransposePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_transpose", 2586408642)

    internal val getTransposePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_transpose", 36873697)

    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_material", 5934680)

    internal val setTextureOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_texture_origin", 1130785943)

    internal val getTextureOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_texture_origin", 3690982128)

    internal val setModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_modulate", 2920490490)

    internal val getModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_modulate", 3444240500)

    internal val setZIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_z_index", 1286410249)

    internal val getZIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_z_index", 3905245786)

    internal val setYSortOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_y_sort_origin", 1286410249)

    internal val getYSortOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_y_sort_origin", 3905245786)

    internal val setOccluderPolygonsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_occluder_polygons_count", 3937882851)

    internal val getOccluderPolygonsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_occluder_polygons_count", 923996154)

    internal val addOccluderPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "add_occluder_polygon", 1286410249)

    internal val removeOccluderPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "remove_occluder_polygon", 3937882851)

    internal val setOccluderPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_occluder_polygon", 164249167)

    internal val getOccluderPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_occluder_polygon", 971166743)

    internal val setOccluderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_occluder", 914399637)

    internal val getOccluderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_occluder", 2377324099)

    internal val setConstantLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_constant_linear_velocity", 163021252)

    internal val getConstantLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_constant_linear_velocity", 2299179447)

    internal val setConstantAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_constant_angular_velocity", 1602489585)

    internal val getConstantAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_constant_angular_velocity", 2339986948)

    internal val setCollisionPolygonsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_collision_polygons_count", 3937882851)

    internal val getCollisionPolygonsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_collision_polygons_count", 923996154)

    internal val addCollisionPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "add_collision_polygon", 1286410249)

    internal val removeCollisionPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "remove_collision_polygon", 3937882851)

    internal val setCollisionPolygonPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_collision_polygon_points", 3230546541)

    internal val getCollisionPolygonPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_collision_polygon_points", 103942801)

    internal val setCollisionPolygonOneWayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_collision_polygon_one_way", 1383440665)

    internal val isCollisionPolygonOneWayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "is_collision_polygon_one_way", 2522259332)

    internal val setCollisionPolygonOneWayMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_collision_polygon_one_way_margin", 3506521499)

    internal val getCollisionPolygonOneWayMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_collision_polygon_one_way_margin", 3085491603)

    internal val setTerrainSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_terrain_set", 1286410249)

    internal val getTerrainSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_terrain_set", 3905245786)

    internal val setTerrainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_terrain", 1286410249)

    internal val getTerrainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_terrain", 3905245786)

    internal val setTerrainPeeringBitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_terrain_peering_bit", 1084452308)

    internal val getTerrainPeeringBitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_terrain_peering_bit", 3831796792)

    internal val isValidTerrainPeeringBitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "is_valid_terrain_peering_bit", 845723972)

    internal val setNavigationPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_navigation_polygon", 2224691167)

    internal val getNavigationPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_navigation_polygon", 2907127272)

    internal val setProbabilityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_probability", 373806689)

    internal val getProbabilityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_probability", 1740695150)

    internal val setCustomDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_custom_data", 402577236)

    internal val getCustomDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_custom_data", 1868160156)

    internal val hasCustomDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "has_custom_data", 3927539163)

    internal val setCustomDataByLayerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "set_custom_data_by_layer_id", 2152698145)

    internal val getCustomDataByLayerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileData", "get_custom_data_by_layer_id", 4227898402)
  }
}
