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
import godot.core.MethodStringName3
import godot.core.MethodStringName7
import godot.core.PackedInt32Array
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2I
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
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * ImporterMesh is a type of [Resource] analogous to [ArrayMesh]. It contains vertex array-based
 * geometry, divided in *surfaces*. Each surface contains a completely separate array and a material
 * used to draw it. Design wise, a mesh with multiple surfaces is preferred to a single surface,
 * because objects created in 3D editing software commonly contain multiple materials.
 *
 * Unlike its runtime counterpart, [ImporterMesh] contains mesh data before various import steps,
 * such as LOD and shadow mesh generation, have taken place. Modify surface data by calling [clear],
 * followed by [addSurface] for each surface.
 */
@GodotBaseType
public open class ImporterMesh : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(307, scriptPtr)
  }

  /**
   * Adds name for a blend shape that will be added with [addSurface]. Must be called before surface
   * is added.
   */
  public final fun addBlendShape(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.addBlendShapePtr)
  }

  /**
   * Returns the number of blend shapes that the mesh holds.
   */
  public final fun getBlendShapeCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendShapeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the name of the blend shape at this index.
   */
  public final fun getBlendShapeName(blendShapeIdx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to blendShapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBlendShapeNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the blend shape mode.
   */
  public final fun setBlendShapeMode(mode: Mesh.BlendShapeMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setBlendShapeModePtr)
  }

  /**
   * Returns the blend shape mode for this Mesh.
   */
  public final fun getBlendShapeMode(): Mesh.BlendShapeMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendShapeModePtr)
    return Mesh.BlendShapeMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a new surface. [Mesh.getSurfaceCount] will become the `surf_idx` for this new surface.
   *
   * Surfaces are created to be rendered using a [primitive], which may be any of the values defined
   * in [Mesh.PrimitiveType].
   *
   * The [arrays] argument is an array of arrays. Each of the [Mesh.ARRAY_MAX] elements contains an
   * array with some of the mesh data for this surface as described by the corresponding member of
   * [Mesh.ArrayType] or `null` if it is not used by the surface. For example, `arrays[0]` is the array
   * of vertices. That first vertex sub-array is always required; the others are optional. Adding an
   * index array puts this surface into "index mode" where the vertex and other arrays become the
   * sources of data and the index array defines the vertex order. All sub-arrays must have the same
   * length as the vertex array (or be an exact multiple of the vertex array's length, when multiple
   * elements of a sub-array correspond to a single vertex) or be empty, except for [Mesh.ARRAY_INDEX]
   * if it is used.
   *
   * The [blendShapes] argument is an array of vertex data for each blend shape. Each element is an
   * array of the same structure as [arrays], but [Mesh.ARRAY_VERTEX], [Mesh.ARRAY_NORMAL], and
   * [Mesh.ARRAY_TANGENT] are set if and only if they are set in [arrays] and all other entries are
   * `null`.
   *
   * The [lods] argument is a dictionary with [Double] keys and [PackedInt32Array] values. Each
   * entry in the dictionary represents an LOD level of the surface, where the value is the
   * [Mesh.ARRAY_INDEX] array to use for the LOD level and the key is roughly proportional to the
   * distance at which the LOD stats being used. I.e., increasing the key of an LOD also increases the
   * distance that the objects has to be from the camera before the LOD is used.
   *
   * The [flags] argument is the bitwise OR of, as required: One value of [Mesh.ArrayCustomFormat]
   * left shifted by `ARRAY_FORMAT_CUSTOMn_SHIFT` for each custom channel in use,
   * [Mesh.ARRAY_FLAG_USE_DYNAMIC_UPDATE], [Mesh.ARRAY_FLAG_USE_8_BONE_WEIGHTS], or
   * [Mesh.ARRAY_FLAG_USES_EMPTY_VERTEX_ARRAY].
   *
   * **Note:** When using indices, it is recommended to only use points, lines, or triangles.
   */
  @JvmOverloads
  public final fun addSurface(
    primitive: Mesh.PrimitiveType,
    arrays: VariantArray<Any?>,
    blendShapes: VariantArray<VariantArray<Any?>> = godot.core.variantArrayOf(),
    lods: Dictionary<Any?, Any?> = Dictionary(),
    material: Material? = null,
    name: String = "",
    flags: Long = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to primitive.value, ARRAY to arrays, ARRAY to blendShapes, DICTIONARY to lods, OBJECT to material, STRING to name, LONG to flags)
    TransferContext.callMethod(MethodBindings.addSurfacePtr)
  }

  /**
   * Returns the number of surfaces that the mesh holds.
   */
  public final fun getSurfaceCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSurfaceCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the primitive type of the requested surface (see [addSurface]).
   */
  public final fun getSurfacePrimitiveType(surfaceIdx: Int): Mesh.PrimitiveType {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfacePrimitiveTypePtr)
    return Mesh.PrimitiveType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Gets the name assigned to this surface.
   */
  public final fun getSurfaceName(surfaceIdx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the arrays for the vertices, normals, UVs, etc. that make up the requested surface. See
   * [addSurface].
   */
  public final fun getSurfaceArrays(surfaceIdx: Int): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceArraysPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns a single set of blend shape arrays for the requested blend shape index for a surface.
   */
  public final fun getSurfaceBlendShapeArrays(surfaceIdx: Int, blendShapeIdx: Int):
      VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong(), LONG to blendShapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceBlendShapeArraysPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns the number of lods that the mesh holds on a given surface.
   */
  public final fun getSurfaceLodCount(surfaceIdx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceLodCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the screen ratio which activates a lod for a surface.
   */
  public final fun getSurfaceLodSize(surfaceIdx: Int, lodIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong(), LONG to lodIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceLodSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the index buffer of a lod for a surface.
   */
  public final fun getSurfaceLodIndices(surfaceIdx: Int, lodIdx: Int): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong(), LONG to lodIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceLodIndicesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns a [Material] in a given surface. Surface is rendered using this material.
   */
  public final fun getSurfaceMaterial(surfaceIdx: Int): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  /**
   * Returns the format of the surface that the mesh holds.
   */
  public final fun getSurfaceFormat(surfaceIdx: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceFormatPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets a name for a given surface.
   */
  public final fun setSurfaceName(surfaceIdx: Int, name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong(), STRING to name)
    TransferContext.callMethod(MethodBindings.setSurfaceNamePtr)
  }

  /**
   * Sets a [Material] for a given surface. Surface will be rendered using this material.
   */
  public final fun setSurfaceMaterial(surfaceIdx: Int, material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surfaceIdx.toLong(), OBJECT to material)
    TransferContext.callMethod(MethodBindings.setSurfaceMaterialPtr)
  }

  /**
   * Generates all lods for this ImporterMesh.
   *
   * [normalMergeAngle] is in degrees and used in the same way as the importer settings in `lods`.
   *
   * [normalSplitAngle] is not used and only remains for compatibility with older versions of the
   * API.
   *
   * The number of generated lods can be accessed using [getSurfaceLodCount], and each LOD is
   * available in [getSurfaceLodSize] and [getSurfaceLodIndices].
   *
   * [boneTransformArray] is an [VariantArray] which can be either empty or contain [Transform3D]s
   * which, for each of the mesh's bone IDs, will apply mesh skinning when generating the LOD mesh
   * variations. This is usually used to account for discrepancies in scale between the mesh itself and
   * its skinning data.
   */
  public final fun generateLods(
    normalMergeAngle: Float,
    normalSplitAngle: Float,
    boneTransformArray: VariantArray<Any?>,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to normalMergeAngle.toDouble(), DOUBLE to normalSplitAngle.toDouble(), ARRAY to boneTransformArray)
    TransferContext.callMethod(MethodBindings.generateLodsPtr)
  }

  /**
   * Returns the mesh data represented by this [ImporterMesh] as a usable [ArrayMesh].
   *
   * This method caches the returned mesh, and subsequent calls will return the cached data until
   * [clear] is called.
   *
   * If not yet cached and [baseMesh] is provided, [baseMesh] will be used and mutated.
   */
  @JvmOverloads
  public final fun getMesh(baseMesh: ArrayMesh? = null): ArrayMesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to baseMesh)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as ArrayMesh?)
  }

  /**
   * Removes all surfaces and blend shapes from this [ImporterMesh].
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Sets the size hint of this mesh for lightmap-unwrapping in UV-space.
   */
  public final fun setLightmapSizeHint(size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.setLightmapSizeHintPtr)
  }

  /**
   * Returns the size hint of this mesh for lightmap-unwrapping in UV-space.
   */
  public final fun getLightmapSizeHint(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLightmapSizeHintPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public companion object {
    @JvmField
    public val mergeImporterMeshesName:
        MethodStringName3<ImporterMesh, ImporterMesh?, VariantArray<ImporterMesh>, VariantArray<Transform3D>, Boolean>
        =
        MethodStringName3<ImporterMesh, ImporterMesh?, VariantArray<ImporterMesh>, VariantArray<Transform3D>, Boolean>("merge_importer_meshes")

    @JvmField
    public val addBlendShapeName: MethodStringName1<ImporterMesh, Unit, String> =
        MethodStringName1<ImporterMesh, Unit, String>("add_blend_shape")

    @JvmField
    public val getBlendShapeCountName: MethodStringName0<ImporterMesh, Int> =
        MethodStringName0<ImporterMesh, Int>("get_blend_shape_count")

    @JvmField
    public val getBlendShapeNameName: MethodStringName1<ImporterMesh, String, Int> =
        MethodStringName1<ImporterMesh, String, Int>("get_blend_shape_name")

    @JvmField
    public val setBlendShapeModeName: MethodStringName1<ImporterMesh, Unit, Mesh.BlendShapeMode> =
        MethodStringName1<ImporterMesh, Unit, Mesh.BlendShapeMode>("set_blend_shape_mode")

    @JvmField
    public val getBlendShapeModeName: MethodStringName0<ImporterMesh, Mesh.BlendShapeMode> =
        MethodStringName0<ImporterMesh, Mesh.BlendShapeMode>("get_blend_shape_mode")

    @JvmField
    public val addSurfaceName:
        MethodStringName7<ImporterMesh, Unit, Mesh.PrimitiveType, VariantArray<Any?>, VariantArray<VariantArray<Any?>>, Dictionary<Any?, Any?>, Material?, String, Long>
        =
        MethodStringName7<ImporterMesh, Unit, Mesh.PrimitiveType, VariantArray<Any?>, VariantArray<VariantArray<Any?>>, Dictionary<Any?, Any?>, Material?, String, Long>("add_surface")

    @JvmField
    public val getSurfaceCountName: MethodStringName0<ImporterMesh, Int> =
        MethodStringName0<ImporterMesh, Int>("get_surface_count")

    @JvmField
    public val getSurfacePrimitiveTypeName: MethodStringName1<ImporterMesh, Mesh.PrimitiveType, Int>
        = MethodStringName1<ImporterMesh, Mesh.PrimitiveType, Int>("get_surface_primitive_type")

    @JvmField
    public val getSurfaceNameName: MethodStringName1<ImporterMesh, String, Int> =
        MethodStringName1<ImporterMesh, String, Int>("get_surface_name")

    @JvmField
    public val getSurfaceArraysName: MethodStringName1<ImporterMesh, VariantArray<Any?>, Int> =
        MethodStringName1<ImporterMesh, VariantArray<Any?>, Int>("get_surface_arrays")

    @JvmField
    public val getSurfaceBlendShapeArraysName:
        MethodStringName2<ImporterMesh, VariantArray<Any?>, Int, Int> =
        MethodStringName2<ImporterMesh, VariantArray<Any?>, Int, Int>("get_surface_blend_shape_arrays")

    @JvmField
    public val getSurfaceLodCountName: MethodStringName1<ImporterMesh, Int, Int> =
        MethodStringName1<ImporterMesh, Int, Int>("get_surface_lod_count")

    @JvmField
    public val getSurfaceLodSizeName: MethodStringName2<ImporterMesh, Float, Int, Int> =
        MethodStringName2<ImporterMesh, Float, Int, Int>("get_surface_lod_size")

    @JvmField
    public val getSurfaceLodIndicesName: MethodStringName2<ImporterMesh, PackedInt32Array, Int, Int>
        = MethodStringName2<ImporterMesh, PackedInt32Array, Int, Int>("get_surface_lod_indices")

    @JvmField
    public val getSurfaceMaterialName: MethodStringName1<ImporterMesh, Material?, Int> =
        MethodStringName1<ImporterMesh, Material?, Int>("get_surface_material")

    @JvmField
    public val getSurfaceFormatName: MethodStringName1<ImporterMesh, Long, Int> =
        MethodStringName1<ImporterMesh, Long, Int>("get_surface_format")

    @JvmField
    public val setSurfaceNameName: MethodStringName2<ImporterMesh, Unit, Int, String> =
        MethodStringName2<ImporterMesh, Unit, Int, String>("set_surface_name")

    @JvmField
    public val setSurfaceMaterialName: MethodStringName2<ImporterMesh, Unit, Int, Material?> =
        MethodStringName2<ImporterMesh, Unit, Int, Material?>("set_surface_material")

    @JvmField
    public val generateLodsName:
        MethodStringName3<ImporterMesh, Unit, Float, Float, VariantArray<Any?>> =
        MethodStringName3<ImporterMesh, Unit, Float, Float, VariantArray<Any?>>("generate_lods")

    @JvmField
    public val getMeshName: MethodStringName1<ImporterMesh, ArrayMesh?, ArrayMesh?> =
        MethodStringName1<ImporterMesh, ArrayMesh?, ArrayMesh?>("get_mesh")

    @JvmField
    public val fromMeshName: MethodStringName1<ImporterMesh, ImporterMesh?, Mesh?> =
        MethodStringName1<ImporterMesh, ImporterMesh?, Mesh?>("from_mesh")

    @JvmField
    public val clearName: MethodStringName0<ImporterMesh, Unit> =
        MethodStringName0<ImporterMesh, Unit>("clear")

    @JvmField
    public val setLightmapSizeHintName: MethodStringName1<ImporterMesh, Unit, Vector2i> =
        MethodStringName1<ImporterMesh, Unit, Vector2i>("set_lightmap_size_hint")

    @JvmField
    public val getLightmapSizeHintName: MethodStringName0<ImporterMesh, Vector2i> =
        MethodStringName0<ImporterMesh, Vector2i>("get_lightmap_size_hint")

    /**
     * Merges multiple [ImporterMesh]es into a single [ImporterMesh]. Each input mesh is transformed
     * by the corresponding [Transform3D] in the [relativeTransforms] array, which must be the same
     * size as [importerMeshes]. Negative scales are supported, and the winding order in the mesh data
     * will be corrected to account for this.
     *
     * If [deduplicateSurfaces] is `true` and multiple meshes have surfaces with the same names and
     * formats, the surfaces will be merged together when the meshes are merged, and will use the
     * material from the first matching surface. This is useful for reducing the number of surfaces in
     * the resulting mesh, and avoids duplicating materials. Surfaces with bone weights will never be
     * deduplicated. If [deduplicateSurfaces] is `false`, the surfaces will always be kept separate,
     * and will be given unique names.
     *
     * **Warning:** Blend shapes and LODs are not supported and will be discarded. Do not use this
     * function to discard blend shapes and LODs, as support for these may be added in the future.
     */
    @JvmOverloads
    @JvmStatic
    public final fun mergeImporterMeshes(
      importerMeshes: VariantArray<ImporterMesh>,
      relativeTransforms: VariantArray<Transform3D>,
      deduplicateSurfaces: Boolean = true,
    ): ImporterMesh? {
      TransferContext.writeMethodArguments(0L, 0L, ARRAY to importerMeshes, ARRAY to relativeTransforms, BOOL to deduplicateSurfaces)
      TransferContext.callMethod(MethodBindings.mergeImporterMeshesPtr)
      return (TransferContext.readReturnValue(OBJECT) as ImporterMesh?)
    }

    /**
     * Converts the given [Mesh] into an [ImporterMesh] by copying all its surfaces, blend shapes,
     * materials, and metadata into a new [ImporterMesh] object.
     */
    @JvmStatic
    public final fun fromMesh(mesh: Mesh?): ImporterMesh? {
      TransferContext.writeMethodArguments(0L, 0L, OBJECT to mesh)
      TransferContext.callMethod(MethodBindings.fromMeshPtr)
      return (TransferContext.readReturnValue(OBJECT) as ImporterMesh?)
    }
  }

  public object MethodBindings {
    internal val mergeImporterMeshesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "merge_importer_meshes", 1030647649)

    internal val addBlendShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "add_blend_shape", 83702148)

    internal val getBlendShapeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_blend_shape_count", 3905245786)

    internal val getBlendShapeNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_blend_shape_name", 844755477)

    internal val setBlendShapeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "set_blend_shape_mode", 227983991)

    internal val getBlendShapeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_blend_shape_mode", 836485024)

    internal val addSurfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "add_surface", 1740448849)

    internal val getSurfaceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_count", 3905245786)

    internal val getSurfacePrimitiveTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_primitive_type", 3552571330)

    internal val getSurfaceNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_name", 844755477)

    internal val getSurfaceArraysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_arrays", 663333327)

    internal val getSurfaceBlendShapeArraysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_blend_shape_arrays", 2345056839)

    internal val getSurfaceLodCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_lod_count", 923996154)

    internal val getSurfaceLodSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_lod_size", 3085491603)

    internal val getSurfaceLodIndicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_lod_indices", 1265128013)

    internal val getSurfaceMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_material", 2897466400)

    internal val getSurfaceFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_surface_format", 923996154)

    internal val setSurfaceNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "set_surface_name", 501894301)

    internal val setSurfaceMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "set_surface_material", 3671737478)

    internal val generateLodsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "generate_lods", 2491878677)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_mesh", 1457573577)

    internal val fromMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "from_mesh", 283226343)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "clear", 3218959716)

    internal val setLightmapSizeHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "set_lightmap_size_hint", 1130785943)

    internal val getLightmapSizeHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMesh", "get_lightmap_size_hint", 3690982128)
  }
}
