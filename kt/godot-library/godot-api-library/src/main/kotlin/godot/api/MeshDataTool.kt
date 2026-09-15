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
import godot.core.Color
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedFloat32Array
import godot.core.PackedInt32Array
import godot.core.Plane
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PLANE
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR3
import godot.core.Vector2
import godot.core.Vector3
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * MeshDataTool provides access to individual vertices in a [Mesh]. It allows users to read and edit
 * vertex data of meshes. It also creates an array of faces and edges.
 *
 * To use MeshDataTool, load a mesh with [createFromSurface]. When you are finished editing the data
 * commit the data to a mesh with [commitToSurface].
 *
 * Below is an example of how MeshDataTool may be used.
 *
 * ```gdscript
 * //gdscript
 * var mesh = ArrayMesh.new()
 * mesh.add_surface_from_arrays(Mesh.PRIMITIVE_TRIANGLES, BoxMesh.new().get_mesh_arrays())
 * var mdt = MeshDataTool.new()
 * mdt.create_from_surface(mesh, 0)
 * for i in range(mdt.get_vertex_count()):
 * 	var vertex = mdt.get_vertex(i)
 * 	# In this example we extend the mesh by one unit, which results in separated faces as it is flat
 * shaded.
 * 	vertex += mdt.get_vertex_normal(i)
 * 	# Save your change.
 * 	mdt.set_vertex(i, vertex)
 * mesh.clear_surfaces()
 * mdt.commit_to_surface(mesh)
 * var mi = MeshInstance.new()
 * mi.mesh = mesh
 * add_child(mi)
 * ```
 *
 * ```csharp
 * //csharp
 * var mesh = new ArrayMesh();
 * mesh.AddSurfaceFromArrays(Mesh.PrimitiveType.Triangles, new BoxMesh().GetMeshArrays());
 * var mdt = new MeshDataTool();
 * mdt.CreateFromSurface(mesh, 0);
 * for (var i = 0; i < mdt.GetVertexCount(); i++)
 * {
 * 	Vector3 vertex = mdt.GetVertex(i);
 * 	// In this example we extend the mesh by one unit, which results in separated faces as it is
 * flat shaded.
 * 	vertex += mdt.GetVertexNormal(i);
 * 	// Save your change.
 * 	mdt.SetVertex(i, vertex);
 * }
 * mesh.ClearSurfaces();
 * mdt.CommitToSurface(mesh);
 * var mi = new MeshInstance();
 * mi.Mesh = mesh;
 * AddChild(mi);
 * ```
 *
 * See also [ArrayMesh], [ImmediateMesh] and [SurfaceTool] for procedural geometry generation.
 *
 * **Note:** Godot uses clockwise [url=https://learnopengl.com/Advanced-OpenGL/Face-culling]winding
 * order[/url] for front faces of triangle primitive modes.
 */
@GodotBaseType
public open class MeshDataTool : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(375, scriptPtr)
  }

  /**
   * Clears all data currently in MeshDataTool.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Uses specified surface of given [Mesh] to populate data for MeshDataTool.
   *
   * Requires [Mesh] with primitive type [Mesh.PRIMITIVE_TRIANGLES].
   */
  public final fun createFromSurface(mesh: ArrayMesh?, surface: Int): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh, LONG to surface.toLong())
    TransferContext.callMethod(MethodBindings.createFromSurfacePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Adds a new surface to specified [Mesh] with edited data.
   */
  @JvmOverloads
  public final fun commitToSurface(mesh: ArrayMesh?, compressionFlags: Long = 0): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh, LONG to compressionFlags)
    TransferContext.callMethod(MethodBindings.commitToSurfacePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the [Mesh]'s format as a combination of the [Mesh.ArrayFormat] flags. For example, a
   * mesh containing both vertices and normals would return a format of `3` because
   * [Mesh.ARRAY_FORMAT_VERTEX] is `1` and [Mesh.ARRAY_FORMAT_NORMAL] is `2`.
   */
  public final fun getFormat(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFormatPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the total number of vertices in [Mesh].
   */
  public final fun getVertexCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVertexCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of edges in this [Mesh].
   */
  public final fun getEdgeCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEdgeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of faces in this [Mesh].
   */
  public final fun getFaceCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFaceCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the position of the given vertex.
   */
  public final fun setVertex(idx: Int, vertex: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), VECTOR3 to vertex)
    TransferContext.callMethod(MethodBindings.setVertexPtr)
  }

  /**
   * Returns the position of the given vertex.
   */
  public final fun getVertex(idx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the normal of the given vertex.
   */
  public final fun setVertexNormal(idx: Int, normal: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), VECTOR3 to normal)
    TransferContext.callMethod(MethodBindings.setVertexNormalPtr)
  }

  /**
   * Returns the normal of the given vertex.
   */
  public final fun getVertexNormal(idx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexNormalPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the tangent of the given vertex.
   *
   * **Note:** Even though [tangent] is a [Plane], it does not directly represent the tangent plane.
   * Its [Plane.x], [Plane.y], and [Plane.z] represent the tangent vector and [Plane.d] should be
   * either `-1` or `1`. See also [Mesh.ARRAY_TANGENT].
   */
  public final fun setVertexTangent(idx: Int, tangent: Plane): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), PLANE to tangent)
    TransferContext.callMethod(MethodBindings.setVertexTangentPtr)
  }

  /**
   * Returns the tangent of the given vertex.
   */
  public final fun getVertexTangent(idx: Int): Plane {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexTangentPtr)
    return (TransferContext.readReturnValue(PLANE) as Plane)
  }

  /**
   * Sets the UV of the given vertex.
   */
  public final fun setVertexUv(idx: Int, uv: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), VECTOR2 to uv)
    TransferContext.callMethod(MethodBindings.setVertexUvPtr)
  }

  /**
   * Returns the UV of the given vertex.
   */
  public final fun getVertexUv(idx: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexUvPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets the UV2 of the given vertex.
   */
  public final fun setVertexUv2(idx: Int, uv2: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), VECTOR2 to uv2)
    TransferContext.callMethod(MethodBindings.setVertexUv2Ptr)
  }

  /**
   * Returns the UV2 of the given vertex.
   */
  public final fun getVertexUv2(idx: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexUv2Ptr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets the color of the given vertex.
   */
  public final fun setVertexColor(idx: Int, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), COLOR to color)
    TransferContext.callMethod(MethodBindings.setVertexColorPtr)
  }

  /**
   * Returns the color of the given vertex.
   */
  public final fun getVertexColor(idx: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Sets the bones of the given vertex.
   */
  public final fun setVertexBones(idx: Int, bones: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), PACKED_INT_32_ARRAY to bones)
    TransferContext.callMethod(MethodBindings.setVertexBonesPtr)
  }

  /**
   * Returns the bones of the given vertex.
   */
  public final fun getVertexBones(idx: Int): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexBonesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Sets the bone weights of the given vertex.
   */
  public final fun setVertexWeights(idx: Int, weights: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), PACKED_FLOAT_32_ARRAY to weights)
    TransferContext.callMethod(MethodBindings.setVertexWeightsPtr)
  }

  /**
   * Returns bone weights of the given vertex.
   */
  public final fun getVertexWeights(idx: Int): PackedFloat32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexWeightsPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_32_ARRAY) as PackedFloat32Array)
  }

  /**
   * Sets the metadata associated with the given vertex.
   */
  public final fun setVertexMeta(idx: Int, meta: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), ANY to meta)
    TransferContext.callMethod(MethodBindings.setVertexMetaPtr)
  }

  /**
   * Returns the metadata associated with the given vertex.
   */
  public final fun getVertexMeta(idx: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexMetaPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns an array of edges that share the given vertex.
   */
  public final fun getVertexEdges(idx: Int): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexEdgesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns an array of faces that share the given vertex.
   */
  public final fun getVertexFaces(idx: Int): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getVertexFacesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns the index of the specified [vertex] connected to the edge at index [idx].
   *
   * [vertex] can only be `0` or `1`, as edges are composed of two vertices.
   */
  public final fun getEdgeVertex(idx: Int, vertex: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), LONG to vertex.toLong())
    TransferContext.callMethod(MethodBindings.getEdgeVertexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns array of faces that touch given edge.
   */
  public final fun getEdgeFaces(idx: Int): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getEdgeFacesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Sets the metadata of the given edge.
   */
  public final fun setEdgeMeta(idx: Int, meta: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), ANY to meta)
    TransferContext.callMethod(MethodBindings.setEdgeMetaPtr)
  }

  /**
   * Returns meta information assigned to given edge.
   */
  public final fun getEdgeMeta(idx: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getEdgeMetaPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the specified vertex index of the given face.
   *
   * [vertex] must be either `0`, `1`, or `2` because faces contain three vertices.
   *
   * ```gdscript
   * //gdscript
   * var index = mesh_data_tool.get_face_vertex(0, 1) # Gets the index of the second vertex of the
   * first face.
   * var position = mesh_data_tool.get_vertex(index)
   * var normal = mesh_data_tool.get_vertex_normal(index)
   * ```
   *
   * ```csharp
   * //csharp
   * int index = meshDataTool.GetFaceVertex(0, 1); // Gets the index of the second vertex of the
   * first face.
   * Vector3 position = meshDataTool.GetVertex(index);
   * Vector3 normal = meshDataTool.GetVertexNormal(index);
   * ```
   */
  public final fun getFaceVertex(idx: Int, vertex: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), LONG to vertex.toLong())
    TransferContext.callMethod(MethodBindings.getFaceVertexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the edge associated with the face at index [idx].
   *
   * [edge] argument must be either `0`, `1`, or `2` because a face only has three edges.
   */
  public final fun getFaceEdge(idx: Int, edge: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), LONG to edge.toLong())
    TransferContext.callMethod(MethodBindings.getFaceEdgePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the metadata of the given face.
   */
  public final fun setFaceMeta(idx: Int, meta: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), ANY to meta)
    TransferContext.callMethod(MethodBindings.setFaceMetaPtr)
  }

  /**
   * Returns the metadata associated with the given face.
   */
  public final fun getFaceMeta(idx: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getFaceMetaPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Calculates and returns the face normal of the given face.
   */
  public final fun getFaceNormal(idx: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getFaceNormalPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the material to be used by newly-constructed [Mesh].
   */
  public final fun setMaterial(material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to material)
    TransferContext.callMethod(MethodBindings.setMaterialPtr)
  }

  /**
   * Returns the material assigned to the [Mesh].
   */
  public final fun getMaterial(): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  public companion object {
    @JvmField
    public val clearName: MethodStringName0<MeshDataTool, Unit> =
        MethodStringName0<MeshDataTool, Unit>("clear")

    @JvmField
    public val createFromSurfaceName: MethodStringName2<MeshDataTool, Error, ArrayMesh?, Int> =
        MethodStringName2<MeshDataTool, Error, ArrayMesh?, Int>("create_from_surface")

    @JvmField
    public val commitToSurfaceName: MethodStringName2<MeshDataTool, Error, ArrayMesh?, Long> =
        MethodStringName2<MeshDataTool, Error, ArrayMesh?, Long>("commit_to_surface")

    @JvmField
    public val getFormatName: MethodStringName0<MeshDataTool, Long> =
        MethodStringName0<MeshDataTool, Long>("get_format")

    @JvmField
    public val getVertexCountName: MethodStringName0<MeshDataTool, Int> =
        MethodStringName0<MeshDataTool, Int>("get_vertex_count")

    @JvmField
    public val getEdgeCountName: MethodStringName0<MeshDataTool, Int> =
        MethodStringName0<MeshDataTool, Int>("get_edge_count")

    @JvmField
    public val getFaceCountName: MethodStringName0<MeshDataTool, Int> =
        MethodStringName0<MeshDataTool, Int>("get_face_count")

    @JvmField
    public val setVertexName: MethodStringName2<MeshDataTool, Unit, Int, Vector3> =
        MethodStringName2<MeshDataTool, Unit, Int, Vector3>("set_vertex")

    @JvmField
    public val getVertexName: MethodStringName1<MeshDataTool, Vector3, Int> =
        MethodStringName1<MeshDataTool, Vector3, Int>("get_vertex")

    @JvmField
    public val setVertexNormalName: MethodStringName2<MeshDataTool, Unit, Int, Vector3> =
        MethodStringName2<MeshDataTool, Unit, Int, Vector3>("set_vertex_normal")

    @JvmField
    public val getVertexNormalName: MethodStringName1<MeshDataTool, Vector3, Int> =
        MethodStringName1<MeshDataTool, Vector3, Int>("get_vertex_normal")

    @JvmField
    public val setVertexTangentName: MethodStringName2<MeshDataTool, Unit, Int, Plane> =
        MethodStringName2<MeshDataTool, Unit, Int, Plane>("set_vertex_tangent")

    @JvmField
    public val getVertexTangentName: MethodStringName1<MeshDataTool, Plane, Int> =
        MethodStringName1<MeshDataTool, Plane, Int>("get_vertex_tangent")

    @JvmField
    public val setVertexUvName: MethodStringName2<MeshDataTool, Unit, Int, Vector2> =
        MethodStringName2<MeshDataTool, Unit, Int, Vector2>("set_vertex_uv")

    @JvmField
    public val getVertexUvName: MethodStringName1<MeshDataTool, Vector2, Int> =
        MethodStringName1<MeshDataTool, Vector2, Int>("get_vertex_uv")

    @JvmField
    public val setVertexUv2Name: MethodStringName2<MeshDataTool, Unit, Int, Vector2> =
        MethodStringName2<MeshDataTool, Unit, Int, Vector2>("set_vertex_uv2")

    @JvmField
    public val getVertexUv2Name: MethodStringName1<MeshDataTool, Vector2, Int> =
        MethodStringName1<MeshDataTool, Vector2, Int>("get_vertex_uv2")

    @JvmField
    public val setVertexColorName: MethodStringName2<MeshDataTool, Unit, Int, Color> =
        MethodStringName2<MeshDataTool, Unit, Int, Color>("set_vertex_color")

    @JvmField
    public val getVertexColorName: MethodStringName1<MeshDataTool, Color, Int> =
        MethodStringName1<MeshDataTool, Color, Int>("get_vertex_color")

    @JvmField
    public val setVertexBonesName: MethodStringName2<MeshDataTool, Unit, Int, PackedInt32Array> =
        MethodStringName2<MeshDataTool, Unit, Int, PackedInt32Array>("set_vertex_bones")

    @JvmField
    public val getVertexBonesName: MethodStringName1<MeshDataTool, PackedInt32Array, Int> =
        MethodStringName1<MeshDataTool, PackedInt32Array, Int>("get_vertex_bones")

    @JvmField
    public val setVertexWeightsName: MethodStringName2<MeshDataTool, Unit, Int, PackedFloat32Array>
        = MethodStringName2<MeshDataTool, Unit, Int, PackedFloat32Array>("set_vertex_weights")

    @JvmField
    public val getVertexWeightsName: MethodStringName1<MeshDataTool, PackedFloat32Array, Int> =
        MethodStringName1<MeshDataTool, PackedFloat32Array, Int>("get_vertex_weights")

    @JvmField
    public val setVertexMetaName: MethodStringName2<MeshDataTool, Unit, Int, Any?> =
        MethodStringName2<MeshDataTool, Unit, Int, Any?>("set_vertex_meta")

    @JvmField
    public val getVertexMetaName: MethodStringName1<MeshDataTool, Any?, Int> =
        MethodStringName1<MeshDataTool, Any?, Int>("get_vertex_meta")

    @JvmField
    public val getVertexEdgesName: MethodStringName1<MeshDataTool, PackedInt32Array, Int> =
        MethodStringName1<MeshDataTool, PackedInt32Array, Int>("get_vertex_edges")

    @JvmField
    public val getVertexFacesName: MethodStringName1<MeshDataTool, PackedInt32Array, Int> =
        MethodStringName1<MeshDataTool, PackedInt32Array, Int>("get_vertex_faces")

    @JvmField
    public val getEdgeVertexName: MethodStringName2<MeshDataTool, Int, Int, Int> =
        MethodStringName2<MeshDataTool, Int, Int, Int>("get_edge_vertex")

    @JvmField
    public val getEdgeFacesName: MethodStringName1<MeshDataTool, PackedInt32Array, Int> =
        MethodStringName1<MeshDataTool, PackedInt32Array, Int>("get_edge_faces")

    @JvmField
    public val setEdgeMetaName: MethodStringName2<MeshDataTool, Unit, Int, Any?> =
        MethodStringName2<MeshDataTool, Unit, Int, Any?>("set_edge_meta")

    @JvmField
    public val getEdgeMetaName: MethodStringName1<MeshDataTool, Any?, Int> =
        MethodStringName1<MeshDataTool, Any?, Int>("get_edge_meta")

    @JvmField
    public val getFaceVertexName: MethodStringName2<MeshDataTool, Int, Int, Int> =
        MethodStringName2<MeshDataTool, Int, Int, Int>("get_face_vertex")

    @JvmField
    public val getFaceEdgeName: MethodStringName2<MeshDataTool, Int, Int, Int> =
        MethodStringName2<MeshDataTool, Int, Int, Int>("get_face_edge")

    @JvmField
    public val setFaceMetaName: MethodStringName2<MeshDataTool, Unit, Int, Any?> =
        MethodStringName2<MeshDataTool, Unit, Int, Any?>("set_face_meta")

    @JvmField
    public val getFaceMetaName: MethodStringName1<MeshDataTool, Any?, Int> =
        MethodStringName1<MeshDataTool, Any?, Int>("get_face_meta")

    @JvmField
    public val getFaceNormalName: MethodStringName1<MeshDataTool, Vector3, Int> =
        MethodStringName1<MeshDataTool, Vector3, Int>("get_face_normal")

    @JvmField
    public val setMaterialName: MethodStringName1<MeshDataTool, Unit, Material?> =
        MethodStringName1<MeshDataTool, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<MeshDataTool, Material?> =
        MethodStringName0<MeshDataTool, Material?>("get_material")
  }

  public object MethodBindings {
    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "clear", 3218959716)

    internal val createFromSurfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "create_from_surface", 2727020678)

    internal val commitToSurfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "commit_to_surface", 2021686445)

    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_format", 3905245786)

    internal val getVertexCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_count", 3905245786)

    internal val getEdgeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_edge_count", 3905245786)

    internal val getFaceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_face_count", 3905245786)

    internal val setVertexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex", 1530502735)

    internal val getVertexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex", 711720468)

    internal val setVertexNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex_normal", 1530502735)

    internal val getVertexNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_normal", 711720468)

    internal val setVertexTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex_tangent", 1104099133)

    internal val getVertexTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_tangent", 1372055458)

    internal val setVertexUvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex_uv", 163021252)

    internal val getVertexUvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_uv", 2299179447)

    internal val setVertexUv2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex_uv2", 163021252)

    internal val getVertexUv2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_uv2", 2299179447)

    internal val setVertexColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex_color", 2878471219)

    internal val getVertexColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_color", 3457211756)

    internal val setVertexBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex_bones", 3500328261)

    internal val getVertexBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_bones", 1706082319)

    internal val setVertexWeightsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex_weights", 1345852415)

    internal val getVertexWeightsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_weights", 1542882410)

    internal val setVertexMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_vertex_meta", 2152698145)

    internal val getVertexMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_meta", 4227898402)

    internal val getVertexEdgesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_edges", 1706082319)

    internal val getVertexFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_vertex_faces", 1706082319)

    internal val getEdgeVertexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_edge_vertex", 3175239445)

    internal val getEdgeFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_edge_faces", 1706082319)

    internal val setEdgeMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_edge_meta", 2152698145)

    internal val getEdgeMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_edge_meta", 4227898402)

    internal val getFaceVertexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_face_vertex", 3175239445)

    internal val getFaceEdgePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_face_edge", 3175239445)

    internal val setFaceMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_face_meta", 2152698145)

    internal val getFaceMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_face_meta", 4227898402)

    internal val getFaceNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_face_normal", 711720468)

    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshDataTool", "get_material", 5934680)
  }
}
