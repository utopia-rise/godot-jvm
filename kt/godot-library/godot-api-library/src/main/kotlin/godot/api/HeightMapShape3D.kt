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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName3
import godot.core.PackedFloat32Array
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 3D heightmap shape, intended for use in physics to provide a shape for a [CollisionShape3D].
 * This type is most commonly used for terrain with vertices placed in a fixed-width grid.
 *
 * The heightmap is represented as a 2D grid of height values, which represent the position of grid
 * points on the Y axis. Grid points are spaced 1 unit apart on the X and Z axes, and the grid is
 * centered on the origin of the [CollisionShape3D] node. Internally, each grid square is divided into
 * two triangles.
 *
 * Due to the nature of the heightmap, it cannot be used to model overhangs or caves, which would
 * require multiple vertices at the same vertical location. Holes can be punched through the collision
 * by assigning [@GDScript.NAN] to the height of the desired vertices (this is supported in both
 * GodotPhysics3D and Jolt Physics). You could then insert meshes with their own separate collision to
 * provide overhangs, caves, and so on.
 *
 * **Performance:** [HeightMapShape3D] is faster to check collisions against than
 * [ConcavePolygonShape3D], but it is significantly slower than primitive shapes like [BoxShape3D].
 *
 * A heightmap collision shape can also be built by using an [Image] reference:
 *
 * ```gdscript
 * //gdscript
 * var heightmap_texture = ResourceLoader.load("res://heightmap_image.exr")
 * var heightmap_image = heightmap_texture.get_image()
 * heightmap_image.convert(Image.FORMAT_RF)
 *
 * var height_min = 0.0
 * var height_max = 10.0
 *
 * update_map_data_from_image(heightmap_image, height_min, height_max)
 * ```
 *
 * **Note:** If you need to use a spacing different than 1 unit, you can adjust the [Node3D.scale]
 * of the shape. However, keep in mind that GodotPhysics3D does not support non-uniform scaling: you'll
 * need to scale the Y axis by the same amount as the X and Z axes, which means the values in [mapData]
 * will need to be pre-scaled by the inverse of that scale. Also note that GodotPhysics3D does not
 * support scaling at all for dynamic bodies (that is, non-frozen [RigidBody3D] nodes); to use a scaled
 * [HeightMapShape3D] with those, you will need to use Jolt Physics.
 */
@GodotBaseType
public open class HeightMapShape3D : Shape3D() {
  /**
   * Number of vertices in the width of the heightmap. Changing this will resize the [mapData].
   */
  public final inline var mapWidth: Int
    @JvmName("mapWidthProperty")
    get() = getMapWidth()
    @JvmName("mapWidthProperty")
    set(`value`) {
      setMapWidth(value)
    }

  /**
   * Number of vertices in the depth of the heightmap. Changing this will resize the [mapData].
   */
  public final inline var mapDepth: Int
    @JvmName("mapDepthProperty")
    get() = getMapDepth()
    @JvmName("mapDepthProperty")
    set(`value`) {
      setMapDepth(value)
    }

  /**
   * Heightmap data. The array's size must be equal to [mapWidth] multiplied by [mapDepth].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var mapData: PackedFloat32Array
    @JvmName("mapDataProperty")
    get() = getMapData()
    @JvmName("mapDataProperty")
    set(`value`) {
      setMapData(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(296, scriptPtr)
  }

  /**
   * This is a helper function for [mapData] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = heightmapshape3d.mapData
   * //Your changes
   * heightmapshape3d.mapData = myCoreType
   * ``````
   *
   * Heightmap data. The array's size must be equal to [mapWidth] multiplied by [mapDepth].
   */
  @CoreTypeHelper
  public final fun mapDataMutate(block: PackedFloat32Array.() -> Unit): PackedFloat32Array =
      mapData.apply {
     block(this)
     mapData = this
  }

  /**
   * This is a helper function for [mapData] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Heightmap data. The array's size must be equal to [mapWidth] multiplied by [mapDepth].
   */
  @CoreTypeHelper
  public final fun mapDataMutateEach(block: (index: Int, `value`: Float) -> Unit):
      PackedFloat32Array = mapData.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     mapData = this
  }

  public final fun setMapWidth(width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setMapWidthPtr)
  }

  public final fun getMapWidth(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMapWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMapDepth(height: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to height.toLong())
    TransferContext.callMethod(MethodBindings.setMapDepthPtr)
  }

  public final fun getMapDepth(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMapDepthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMapData(`data`: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_FLOAT_32_ARRAY to data)
    TransferContext.callMethod(MethodBindings.setMapDataPtr)
  }

  public final fun getMapData(): PackedFloat32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMapDataPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_32_ARRAY) as PackedFloat32Array)
  }

  /**
   * Returns the smallest height value found in [mapData]. Recalculates only when [mapData] changes.
   */
  public final fun getMinHeight(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinHeightPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the largest height value found in [mapData]. Recalculates only when [mapData] changes.
   */
  public final fun getMaxHeight(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxHeightPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Updates [mapData] with data read from an [Image] reference. Automatically resizes heightmap
   * [mapWidth] and [mapDepth] to fit the full image width and height.
   *
   * The image needs to be in either [Image.FORMAT_RF] (32 bit), [Image.FORMAT_RH] (16 bit), or
   * [Image.FORMAT_R8] (8 bit).
   *
   * Each image pixel is read in as a float on the range from `0.0` (black pixel) to `1.0` (white
   * pixel). This range value gets remapped to [heightMin] and [heightMax] to form the final height
   * value.
   *
   * **Note:** Using a heightmap with 16-bit or 32-bit data, stored in EXR or HDR format is
   * recommended. Using 8-bit height data, or a format like PNG that Godot imports as 8-bit, will
   * result in a terraced terrain.
   */
  public final fun updateMapDataFromImage(
    image: Image?,
    heightMin: Float,
    heightMax: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to image, DOUBLE to heightMin.toDouble(), DOUBLE to heightMax.toDouble())
    TransferContext.callMethod(MethodBindings.updateMapDataFromImagePtr)
  }

  public companion object {
    @JvmField
    public val setMapWidthName: MethodStringName1<HeightMapShape3D, Unit, Int> =
        MethodStringName1<HeightMapShape3D, Unit, Int>("set_map_width")

    @JvmField
    public val getMapWidthName: MethodStringName0<HeightMapShape3D, Int> =
        MethodStringName0<HeightMapShape3D, Int>("get_map_width")

    @JvmField
    public val setMapDepthName: MethodStringName1<HeightMapShape3D, Unit, Int> =
        MethodStringName1<HeightMapShape3D, Unit, Int>("set_map_depth")

    @JvmField
    public val getMapDepthName: MethodStringName0<HeightMapShape3D, Int> =
        MethodStringName0<HeightMapShape3D, Int>("get_map_depth")

    @JvmField
    public val setMapDataName: MethodStringName1<HeightMapShape3D, Unit, PackedFloat32Array> =
        MethodStringName1<HeightMapShape3D, Unit, PackedFloat32Array>("set_map_data")

    @JvmField
    public val getMapDataName: MethodStringName0<HeightMapShape3D, PackedFloat32Array> =
        MethodStringName0<HeightMapShape3D, PackedFloat32Array>("get_map_data")

    @JvmField
    public val getMinHeightName: MethodStringName0<HeightMapShape3D, Float> =
        MethodStringName0<HeightMapShape3D, Float>("get_min_height")

    @JvmField
    public val getMaxHeightName: MethodStringName0<HeightMapShape3D, Float> =
        MethodStringName0<HeightMapShape3D, Float>("get_max_height")

    @JvmField
    public val updateMapDataFromImageName:
        MethodStringName3<HeightMapShape3D, Unit, Image?, Float, Float> =
        MethodStringName3<HeightMapShape3D, Unit, Image?, Float, Float>("update_map_data_from_image")
  }

  public object MethodBindings {
    internal val setMapWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "set_map_width", 1286410249)

    internal val getMapWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "get_map_width", 3905245786)

    internal val setMapDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "set_map_depth", 1286410249)

    internal val getMapDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "get_map_depth", 3905245786)

    internal val setMapDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "set_map_data", 2899603908)

    internal val getMapDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "get_map_data", 675695659)

    internal val getMinHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "get_min_height", 1740695150)

    internal val getMaxHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "get_max_height", 1740695150)

    internal val updateMapDataFromImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("HeightMapShape3D", "update_map_data_from_image", 2636652979)
  }
}
