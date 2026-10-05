// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_COLOR
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_NODE_PATH
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_PACKED_COLOR_ARRAY
import godot.callPtrMethod0_ret_PACKED_VECTOR2_ARRAY
import godot.callPtrMethod0_ret_VECTOR2
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_COLOR
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_NODE_PATH
import godot.callPtrMethod_LONG_PACKED_FLOAT_32_ARRAY
import godot.callPtrMethod_LONG_ret_NODE_PATH
import godot.callPtrMethod_LONG_ret_PACKED_FLOAT_32_ARRAY
import godot.callPtrMethod_NODE_PATH
import godot.callPtrMethod_NODE_PATH_PACKED_FLOAT_32_ARRAY
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_PACKED_COLOR_ARRAY
import godot.callPtrMethod_PACKED_VECTOR2_ARRAY
import godot.callPtrMethod_VECTOR2
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import godot.core.PackedInt32Array
import godot.core.PackedVector2Array
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.asCachedNodePath
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A Polygon2D is defined by a set of points. Each point is connected to the next, with the final
 * point being connected to the first, resulting in a closed polygon. Polygon2Ds can be filled with
 * color (solid or gradient) or filled with a given texture.
 */
@GodotBaseType
public open class Polygon2D : Node2D() {
  /**
   * The polygon's fill color. If [texture] is set, it will be multiplied by this color. It will
   * also be the default color for vertices not set in [vertexColors].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var color: Color
    @JvmName("colorProperty")
    get() = getColor()
    @JvmName("colorProperty")
    set(`value`) {
      setColor(value)
    }

  /**
   * The offset applied to each vertex.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offset: Vector2
    @JvmName("offsetProperty")
    get() = getOffset()
    @JvmName("offsetProperty")
    set(`value`) {
      setOffset(value)
    }

  /**
   * If `true`, polygon edges will be anti-aliased.
   */
  public final inline var antialiased: Boolean
    @JvmName("antialiasedProperty")
    get() = getAntialiased()
    @JvmName("antialiasedProperty")
    set(`value`) {
      setAntialiased(value)
    }

  /**
   * The polygon's fill texture. Use [uv] to set texture coordinates.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * Amount to offset the polygon's [texture]. If set to `Vector2(0, 0)`, the texture's origin (its
   * top-left corner) will be placed at the polygon's position.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var textureOffset: Vector2
    @JvmName("textureOffsetProperty")
    get() = getTextureOffset()
    @JvmName("textureOffsetProperty")
    set(`value`) {
      setTextureOffset(value)
    }

  /**
   * Amount to multiply the [uv] coordinates when using [texture]. Larger values make the texture
   * smaller, and vice versa.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var textureScale: Vector2
    @JvmName("textureScaleProperty")
    get() = getTextureScale()
    @JvmName("textureScaleProperty")
    set(`value`) {
      setTextureScale(value)
    }

  /**
   * The texture's rotation in radians.
   */
  public final inline var textureRotation: Float
    @JvmName("textureRotationProperty")
    get() = getTextureRotation()
    @JvmName("textureRotationProperty")
    set(`value`) {
      setTextureRotation(value)
    }

  /**
   * Path to a [Skeleton2D] node used for skeleton-based deformations of this polygon. If empty or
   * invalid, skeletal deformations will not be used.
   */
  public final inline var skeleton: NodePath
    @JvmName("skeletonProperty")
    get() = getSkeleton()
    @JvmName("skeletonProperty")
    set(`value`) {
      setSkeleton(value)
    }

  /**
   * If `true`, the polygon will be inverted, containing the area outside the defined points and
   * extending to the [invertBorder].
   */
  public final inline var invertEnabled: Boolean
    @JvmName("invertEnabledProperty")
    get() = getInvertEnabled()
    @JvmName("invertEnabledProperty")
    set(`value`) {
      setInvertEnabled(value)
    }

  /**
   * Added padding applied to the bounding box when [invertEnabled] is set to `true`. Setting this
   * value too small may result in a "Bad Polygon" error.
   */
  public final inline var invertBorder: Float
    @JvmName("invertBorderProperty")
    get() = getInvertBorder()
    @JvmName("invertBorderProperty")
    set(`value`) {
      setInvertBorder(value)
    }

  /**
   * The polygon's list of vertices. The final point will be connected to the first.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var polygon: PackedVector2Array
    @JvmName("polygonProperty")
    get() = getPolygon()
    @JvmName("polygonProperty")
    set(`value`) {
      setPolygon(value)
    }

  /**
   * Texture coordinates for each vertex of the polygon. There should be one UV value per polygon
   * vertex. If there are fewer, undefined vertices will use `Vector2(0, 0)`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var uv: PackedVector2Array
    @JvmName("uvProperty")
    get() = getUv()
    @JvmName("uvProperty")
    set(`value`) {
      setUv(value)
    }

  /**
   * Color for each vertex. Colors are interpolated between vertices, resulting in smooth gradients.
   * There should be one per polygon vertex. If there are fewer, undefined vertices will use [color].
   */
  public final inline var vertexColors: PackedColorArray
    @JvmName("vertexColorsProperty")
    get() = getVertexColors()
    @JvmName("vertexColorsProperty")
    set(`value`) {
      setVertexColors(value)
    }

  /**
   * The list of polygons, in case more than one is being represented. Every individual polygon is
   * stored as a [PackedInt32Array] where each [Long] is an index to a point in [polygon]. If empty,
   * this property will be ignored, and the resulting single polygon will be composed of all points in
   * [polygon], using the order they are stored in.
   */
  public final inline var polygons: VariantArray<Any?>
    @JvmName("polygonsProperty")
    get() = getPolygons()
    @JvmName("polygonsProperty")
    set(`value`) {
      setPolygons(value)
    }

  /**
   * Number of internal vertices, used for UV mapping.
   */
  public final inline var internalVertexCount: Int
    @JvmName("internalVertexCountProperty")
    get() = getInternalVertexCount()
    @JvmName("internalVertexCountProperty")
    set(`value`) {
      setInternalVertexCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(562, scriptPtr)
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = polygon2d.color
   * //Your changes
   * polygon2d.color = myCoreType
   * ``````
   *
   * The polygon's fill color. If [texture] is set, it will be multiplied by this color. It will
   * also be the default color for vertices not set in [vertexColors].
   */
  @CoreTypeHelper
  public final fun colorMutate(block: Color.() -> Unit): Color = color.apply {
     block(this)
     color = this
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = polygon2d.offset
   * //Your changes
   * polygon2d.offset = myCoreType
   * ``````
   *
   * The offset applied to each vertex.
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  /**
   * This is a helper function for [textureOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = polygon2d.textureOffset
   * //Your changes
   * polygon2d.textureOffset = myCoreType
   * ``````
   *
   * Amount to offset the polygon's [texture]. If set to `Vector2(0, 0)`, the texture's origin (its
   * top-left corner) will be placed at the polygon's position.
   */
  @CoreTypeHelper
  public final fun textureOffsetMutate(block: Vector2.() -> Unit): Vector2 = textureOffset.apply {
     block(this)
     textureOffset = this
  }

  /**
   * This is a helper function for [textureScale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = polygon2d.textureScale
   * //Your changes
   * polygon2d.textureScale = myCoreType
   * ``````
   *
   * Amount to multiply the [uv] coordinates when using [texture]. Larger values make the texture
   * smaller, and vice versa.
   */
  @CoreTypeHelper
  public final fun textureScaleMutate(block: Vector2.() -> Unit): Vector2 = textureScale.apply {
     block(this)
     textureScale = this
  }

  /**
   * This is a helper function for [polygon] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = polygon2d.polygon
   * //Your changes
   * polygon2d.polygon = myCoreType
   * ``````
   *
   * The polygon's list of vertices. The final point will be connected to the first.
   */
  @CoreTypeHelper
  public final fun polygonMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
      polygon.apply {
     block(this)
     polygon = this
  }

  /**
   * This is a helper function for [polygon] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The polygon's list of vertices. The final point will be connected to the first.
   */
  @CoreTypeHelper
  public final fun polygonMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = polygon.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     polygon = this
  }

  /**
   * This is a helper function for [uv] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = polygon2d.uv
   * //Your changes
   * polygon2d.uv = myCoreType
   * ``````
   *
   * Texture coordinates for each vertex of the polygon. There should be one UV value per polygon
   * vertex. If there are fewer, undefined vertices will use `Vector2(0, 0)`.
   */
  @CoreTypeHelper
  public final fun uvMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array = uv.apply {
     block(this)
     uv = this
  }

  /**
   * This is a helper function for [uv] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Texture coordinates for each vertex of the polygon. There should be one UV value per polygon
   * vertex. If there are fewer, undefined vertices will use `Vector2(0, 0)`.
   */
  @CoreTypeHelper
  public final fun uvMutateEach(block: (index: Int, `value`: Vector2) -> Unit): PackedVector2Array =
      uv.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     uv = this
  }

  public final fun setPolygon(polygon: PackedVector2Array): Unit {
    callPtrMethod_PACKED_VECTOR2_ARRAY(MethodBindings.setPolygonPtr, polygon)
  }

  public final fun getPolygon(): PackedVector2Array =
      callPtrMethod0_ret_PACKED_VECTOR2_ARRAY(MethodBindings.getPolygonPtr)

  public final fun setUv(uv: PackedVector2Array): Unit {
    callPtrMethod_PACKED_VECTOR2_ARRAY(MethodBindings.setUvPtr, uv)
  }

  public final fun getUv(): PackedVector2Array =
      callPtrMethod0_ret_PACKED_VECTOR2_ARRAY(MethodBindings.getUvPtr)

  public final fun setColor(color: Color): Unit {
    callPtrMethod_COLOR(MethodBindings.setColorPtr, color)
  }

  public final fun getColor(): Color = callPtrMethod0_ret_COLOR(MethodBindings.getColorPtr)

  public final fun setPolygons(polygons: VariantArray<Any?>): Unit {
    callPtrMethod_ARRAY(MethodBindings.setPolygonsPtr, polygons)
  }

  public final fun getPolygons(): VariantArray<Any?> =
      (callPtrMethod0_ret_ARRAY(MethodBindings.getPolygonsPtr) as VariantArray<Any?>)

  public final fun setVertexColors(vertexColors: PackedColorArray): Unit {
    callPtrMethod_PACKED_COLOR_ARRAY(MethodBindings.setVertexColorsPtr, vertexColors)
  }

  public final fun getVertexColors(): PackedColorArray =
      callPtrMethod0_ret_PACKED_COLOR_ARRAY(MethodBindings.getVertexColorsPtr)

  public final fun setTexture(texture: Texture2D?): Unit {
    callPtrMethod_OBJECT(MethodBindings.setTexturePtr, texture)
  }

  public final fun getTexture(): Texture2D? =
      (callPtrMethod0_ret_OBJECT_REF(MethodBindings.getTexturePtr) as Texture2D?)

  public final fun setTextureOffset(textureOffset: Vector2): Unit {
    callPtrMethod_VECTOR2(MethodBindings.setTextureOffsetPtr, textureOffset)
  }

  public final fun getTextureOffset(): Vector2 =
      callPtrMethod0_ret_VECTOR2(MethodBindings.getTextureOffsetPtr)

  public final fun setTextureRotation(textureRotation: Float): Unit {
    callPtrMethod_DOUBLE(MethodBindings.setTextureRotationPtr, textureRotation.toDouble())
  }

  public final fun getTextureRotation(): Float =
      callPtrMethod0_ret_DOUBLE(MethodBindings.getTextureRotationPtr).toFloat()

  public final fun setTextureScale(textureScale: Vector2): Unit {
    callPtrMethod_VECTOR2(MethodBindings.setTextureScalePtr, textureScale)
  }

  public final fun getTextureScale(): Vector2 =
      callPtrMethod0_ret_VECTOR2(MethodBindings.getTextureScalePtr)

  public final fun setInvertEnabled(invert: Boolean): Unit {
    callPtrMethod_BOOL(MethodBindings.setInvertEnabledPtr, invert)
  }

  public final fun getInvertEnabled(): Boolean =
      callPtrMethod0_ret_BOOL(MethodBindings.getInvertEnabledPtr)

  public final fun setAntialiased(antialiased: Boolean): Unit {
    callPtrMethod_BOOL(MethodBindings.setAntialiasedPtr, antialiased)
  }

  public final fun getAntialiased(): Boolean =
      callPtrMethod0_ret_BOOL(MethodBindings.getAntialiasedPtr)

  public final fun setInvertBorder(invertBorder: Float): Unit {
    callPtrMethod_DOUBLE(MethodBindings.setInvertBorderPtr, invertBorder.toDouble())
  }

  public final fun getInvertBorder(): Float =
      callPtrMethod0_ret_DOUBLE(MethodBindings.getInvertBorderPtr).toFloat()

  public final fun setOffset(offset: Vector2): Unit {
    callPtrMethod_VECTOR2(MethodBindings.setOffsetPtr, offset)
  }

  public final fun getOffset(): Vector2 = callPtrMethod0_ret_VECTOR2(MethodBindings.getOffsetPtr)

  /**
   * Adds a bone with the specified [path] and [weights].
   */
  public final fun addBone(path: NodePath, weights: PackedFloat32Array): Unit {
    callPtrMethod_NODE_PATH_PACKED_FLOAT_32_ARRAY(MethodBindings.addBonePtr, path, weights)
  }

  /**
   * Returns the number of bones in this [Polygon2D].
   */
  public final fun getBoneCount(): Int =
      callPtrMethod0_ret_LONG(MethodBindings.getBoneCountPtr).toInt()

  /**
   * Returns the path to the node associated with the specified bone.
   */
  public final fun getBonePath(index: Int): NodePath =
      callPtrMethod_LONG_ret_NODE_PATH(MethodBindings.getBonePathPtr, index.toLong())

  /**
   * Returns the weight values of the specified bone.
   */
  public final fun getBoneWeights(index: Int): PackedFloat32Array =
      callPtrMethod_LONG_ret_PACKED_FLOAT_32_ARRAY(MethodBindings.getBoneWeightsPtr, index.toLong())

  /**
   * Removes the specified bone from this [Polygon2D].
   */
  public final fun eraseBone(index: Int): Unit {
    callPtrMethod_LONG(MethodBindings.eraseBonePtr, index.toLong())
  }

  /**
   * Removes all bones from this [Polygon2D].
   */
  public final fun clearBones(): Unit {
    callPtrMethod0(MethodBindings.clearBonesPtr)
  }

  /**
   * Sets the path to the node associated with the specified bone.
   */
  public final fun setBonePath(index: Int, path: NodePath): Unit {
    callPtrMethod_LONG_NODE_PATH(MethodBindings.setBonePathPtr, index.toLong(), path)
  }

  /**
   * Sets the weight values for the specified bone.
   */
  public final fun setBoneWeights(index: Int, weights: PackedFloat32Array): Unit {
    callPtrMethod_LONG_PACKED_FLOAT_32_ARRAY(MethodBindings.setBoneWeightsPtr, index.toLong(), weights)
  }

  public final fun setSkeleton(skeleton: NodePath): Unit {
    callPtrMethod_NODE_PATH(MethodBindings.setSkeletonPtr, skeleton)
  }

  public final fun getSkeleton(): NodePath =
      callPtrMethod0_ret_NODE_PATH(MethodBindings.getSkeletonPtr)

  public final fun setInternalVertexCount(internalVertexCount: Int): Unit {
    callPtrMethod_LONG(MethodBindings.setInternalVertexCountPtr, internalVertexCount.toLong())
  }

  public final fun getInternalVertexCount(): Int =
      callPtrMethod0_ret_LONG(MethodBindings.getInternalVertexCountPtr).toInt()

  /**
   * Adds a bone with the specified [path] and [weights].
   */
  public final fun addBone(path: String, weights: PackedFloat32Array) =
      addBone(path.asCachedNodePath(), weights)

  /**
   * Sets the path to the node associated with the specified bone.
   */
  public final fun setBonePath(index: Int, path: String) =
      setBonePath(index, path.asCachedNodePath())

  public final fun setSkeleton(skeleton: String) = setSkeleton(skeleton.asCachedNodePath())

  public companion object {
    @JvmField
    public val setPolygonName: MethodStringName1<Polygon2D, Unit, PackedVector2Array> =
        MethodStringName1<Polygon2D, Unit, PackedVector2Array>("set_polygon")

    @JvmField
    public val getPolygonName: MethodStringName0<Polygon2D, PackedVector2Array> =
        MethodStringName0<Polygon2D, PackedVector2Array>("get_polygon")

    @JvmField
    public val setUvName: MethodStringName1<Polygon2D, Unit, PackedVector2Array> =
        MethodStringName1<Polygon2D, Unit, PackedVector2Array>("set_uv")

    @JvmField
    public val getUvName: MethodStringName0<Polygon2D, PackedVector2Array> =
        MethodStringName0<Polygon2D, PackedVector2Array>("get_uv")

    @JvmField
    public val setColorName: MethodStringName1<Polygon2D, Unit, Color> =
        MethodStringName1<Polygon2D, Unit, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName0<Polygon2D, Color> =
        MethodStringName0<Polygon2D, Color>("get_color")

    @JvmField
    public val setPolygonsName: MethodStringName1<Polygon2D, Unit, VariantArray<Any?>> =
        MethodStringName1<Polygon2D, Unit, VariantArray<Any?>>("set_polygons")

    @JvmField
    public val getPolygonsName: MethodStringName0<Polygon2D, VariantArray<Any?>> =
        MethodStringName0<Polygon2D, VariantArray<Any?>>("get_polygons")

    @JvmField
    public val setVertexColorsName: MethodStringName1<Polygon2D, Unit, PackedColorArray> =
        MethodStringName1<Polygon2D, Unit, PackedColorArray>("set_vertex_colors")

    @JvmField
    public val getVertexColorsName: MethodStringName0<Polygon2D, PackedColorArray> =
        MethodStringName0<Polygon2D, PackedColorArray>("get_vertex_colors")

    @JvmField
    public val setTextureName: MethodStringName1<Polygon2D, Unit, Texture2D?> =
        MethodStringName1<Polygon2D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<Polygon2D, Texture2D?> =
        MethodStringName0<Polygon2D, Texture2D?>("get_texture")

    @JvmField
    public val setTextureOffsetName: MethodStringName1<Polygon2D, Unit, Vector2> =
        MethodStringName1<Polygon2D, Unit, Vector2>("set_texture_offset")

    @JvmField
    public val getTextureOffsetName: MethodStringName0<Polygon2D, Vector2> =
        MethodStringName0<Polygon2D, Vector2>("get_texture_offset")

    @JvmField
    public val setTextureRotationName: MethodStringName1<Polygon2D, Unit, Float> =
        MethodStringName1<Polygon2D, Unit, Float>("set_texture_rotation")

    @JvmField
    public val getTextureRotationName: MethodStringName0<Polygon2D, Float> =
        MethodStringName0<Polygon2D, Float>("get_texture_rotation")

    @JvmField
    public val setTextureScaleName: MethodStringName1<Polygon2D, Unit, Vector2> =
        MethodStringName1<Polygon2D, Unit, Vector2>("set_texture_scale")

    @JvmField
    public val getTextureScaleName: MethodStringName0<Polygon2D, Vector2> =
        MethodStringName0<Polygon2D, Vector2>("get_texture_scale")

    @JvmField
    public val setInvertEnabledName: MethodStringName1<Polygon2D, Unit, Boolean> =
        MethodStringName1<Polygon2D, Unit, Boolean>("set_invert_enabled")

    @JvmField
    public val getInvertEnabledName: MethodStringName0<Polygon2D, Boolean> =
        MethodStringName0<Polygon2D, Boolean>("get_invert_enabled")

    @JvmField
    public val setAntialiasedName: MethodStringName1<Polygon2D, Unit, Boolean> =
        MethodStringName1<Polygon2D, Unit, Boolean>("set_antialiased")

    @JvmField
    public val getAntialiasedName: MethodStringName0<Polygon2D, Boolean> =
        MethodStringName0<Polygon2D, Boolean>("get_antialiased")

    @JvmField
    public val setInvertBorderName: MethodStringName1<Polygon2D, Unit, Float> =
        MethodStringName1<Polygon2D, Unit, Float>("set_invert_border")

    @JvmField
    public val getInvertBorderName: MethodStringName0<Polygon2D, Float> =
        MethodStringName0<Polygon2D, Float>("get_invert_border")

    @JvmField
    public val setOffsetName: MethodStringName1<Polygon2D, Unit, Vector2> =
        MethodStringName1<Polygon2D, Unit, Vector2>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<Polygon2D, Vector2> =
        MethodStringName0<Polygon2D, Vector2>("get_offset")

    @JvmField
    public val addBoneName: MethodStringName2<Polygon2D, Unit, NodePath, PackedFloat32Array> =
        MethodStringName2<Polygon2D, Unit, NodePath, PackedFloat32Array>("add_bone")

    @JvmField
    public val getBoneCountName: MethodStringName0<Polygon2D, Int> =
        MethodStringName0<Polygon2D, Int>("get_bone_count")

    @JvmField
    public val getBonePathName: MethodStringName1<Polygon2D, NodePath, Int> =
        MethodStringName1<Polygon2D, NodePath, Int>("get_bone_path")

    @JvmField
    public val getBoneWeightsName: MethodStringName1<Polygon2D, PackedFloat32Array, Int> =
        MethodStringName1<Polygon2D, PackedFloat32Array, Int>("get_bone_weights")

    @JvmField
    public val eraseBoneName: MethodStringName1<Polygon2D, Unit, Int> =
        MethodStringName1<Polygon2D, Unit, Int>("erase_bone")

    @JvmField
    public val clearBonesName: MethodStringName0<Polygon2D, Unit> =
        MethodStringName0<Polygon2D, Unit>("clear_bones")

    @JvmField
    public val setBonePathName: MethodStringName2<Polygon2D, Unit, Int, NodePath> =
        MethodStringName2<Polygon2D, Unit, Int, NodePath>("set_bone_path")

    @JvmField
    public val setBoneWeightsName: MethodStringName2<Polygon2D, Unit, Int, PackedFloat32Array> =
        MethodStringName2<Polygon2D, Unit, Int, PackedFloat32Array>("set_bone_weights")

    @JvmField
    public val setSkeletonName: MethodStringName1<Polygon2D, Unit, NodePath> =
        MethodStringName1<Polygon2D, Unit, NodePath>("set_skeleton")

    @JvmField
    public val getSkeletonName: MethodStringName0<Polygon2D, NodePath> =
        MethodStringName0<Polygon2D, NodePath>("get_skeleton")

    @JvmField
    public val setInternalVertexCountName: MethodStringName1<Polygon2D, Unit, Int> =
        MethodStringName1<Polygon2D, Unit, Int>("set_internal_vertex_count")

    @JvmField
    public val getInternalVertexCountName: MethodStringName0<Polygon2D, Int> =
        MethodStringName0<Polygon2D, Int>("get_internal_vertex_count")
  }

  public object MethodBindings {
    internal val setPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_polygon", 1509147220)

    internal val getPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_polygon", 2961356807)

    internal val setUvPtr: VoidPtr = TypeManager.getMethodBindPtr("Polygon2D", "set_uv", 1509147220)

    internal val getUvPtr: VoidPtr = TypeManager.getMethodBindPtr("Polygon2D", "get_uv", 2961356807)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_color", 2920490490)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_color", 3444240500)

    internal val setPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_polygons", 381264803)

    internal val getPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_polygons", 3995934104)

    internal val setVertexColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_vertex_colors", 3546319833)

    internal val getVertexColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_vertex_colors", 1392750486)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_texture", 3635182373)

    internal val setTextureOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_texture_offset", 743155724)

    internal val getTextureOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_texture_offset", 3341600327)

    internal val setTextureRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_texture_rotation", 373806689)

    internal val getTextureRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_texture_rotation", 1740695150)

    internal val setTextureScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_texture_scale", 743155724)

    internal val getTextureScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_texture_scale", 3341600327)

    internal val setInvertEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_invert_enabled", 2586408642)

    internal val getInvertEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_invert_enabled", 36873697)

    internal val setAntialiasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_antialiased", 2586408642)

    internal val getAntialiasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_antialiased", 36873697)

    internal val setInvertBorderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_invert_border", 373806689)

    internal val getInvertBorderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_invert_border", 1740695150)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_offset", 743155724)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_offset", 3341600327)

    internal val addBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "add_bone", 703042815)

    internal val getBoneCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_bone_count", 3905245786)

    internal val getBonePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_bone_path", 408788394)

    internal val getBoneWeightsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_bone_weights", 1542882410)

    internal val eraseBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "erase_bone", 1286410249)

    internal val clearBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "clear_bones", 3218959716)

    internal val setBonePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_bone_path", 2761262315)

    internal val setBoneWeightsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_bone_weights", 1345852415)

    internal val setSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_skeleton", 1348162250)

    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_skeleton", 4075236667)

    internal val setInternalVertexCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "set_internal_vertex_count", 1286410249)

    internal val getInternalVertexCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Polygon2D", "get_internal_vertex_count", 3905245786)
  }
}
