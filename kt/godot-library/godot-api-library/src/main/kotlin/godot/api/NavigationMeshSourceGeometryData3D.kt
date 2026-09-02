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
import godot.core.AABB
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.PackedFloat32Array
import godot.core.PackedInt32Array
import godot.core.PackedVector3Array
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.VariantParser.TRANSFORM3D
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Container for parsed source geometry data used in navigation mesh baking.
 */
@GodotBaseType
public open class NavigationMeshSourceGeometryData3D : Resource() {
  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var vertices: PackedFloat32Array
    @JvmName("verticesProperty")
    get() = getVertices()
    @JvmName("verticesProperty")
    set(`value`) {
      setVertices(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var indices: PackedInt32Array
    @JvmName("indicesProperty")
    get() = getIndices()
    @JvmName("indicesProperty")
    set(`value`) {
      setIndices(value)
    }

  public final inline var projectedObstructions: VariantArray<Any?>
    @JvmName("projectedObstructionsProperty")
    get() = getProjectedObstructions()
    @JvmName("projectedObstructionsProperty")
    set(`value`) {
      setProjectedObstructions(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(406, scriptPtr)
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationmeshsourcegeometrydata3d.vertices
   * //Your changes
   * navigationmeshsourcegeometrydata3d.vertices = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun verticesMutate(block: PackedFloat32Array.() -> Unit): PackedFloat32Array =
      vertices.apply {
     block(this)
     vertices = this
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   */
  @CoreTypeHelper
  public final fun verticesMutateEach(block: (index: Int, `value`: Float) -> Unit):
      PackedFloat32Array = vertices.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     vertices = this
  }

  /**
   * This is a helper function for [indices] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationmeshsourcegeometrydata3d.indices
   * //Your changes
   * navigationmeshsourcegeometrydata3d.indices = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun indicesMutate(block: PackedInt32Array.() -> Unit): PackedInt32Array =
      indices.apply {
     block(this)
     indices = this
  }

  /**
   * This is a helper function for [indices] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   */
  @CoreTypeHelper
  public final fun indicesMutateEach(block: (index: Int, `value`: Int) -> Unit): PackedInt32Array =
      indices.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     indices = this
  }

  /**
   * Sets the parsed source geometry data vertices. The vertices need to be matched with
   * appropriated indices.
   *
   * **Warning:** Inappropriate data can crash the baking process of the involved third-party
   * libraries.
   */
  public final fun setVertices(vertices: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_FLOAT_32_ARRAY to vertices)
    TransferContext.callMethod(MethodBindings.setVerticesPtr)
  }

  /**
   * Returns the parsed source geometry data vertices array.
   */
  public final fun getVertices(): PackedFloat32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVerticesPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_32_ARRAY) as PackedFloat32Array)
  }

  /**
   * Sets the parsed source geometry data indices. The indices need to be matched with appropriated
   * vertices.
   *
   * **Warning:** Inappropriate data can crash the baking process of the involved third-party
   * libraries.
   */
  public final fun setIndices(indices: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_32_ARRAY to indices)
    TransferContext.callMethod(MethodBindings.setIndicesPtr)
  }

  /**
   * Returns the parsed source geometry data indices array.
   */
  public final fun getIndices(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIndicesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Appends arrays of [vertices] and [indices] at the end of the existing arrays. Adds the existing
   * index as an offset to the appended indices.
   */
  public final fun appendArrays(vertices: PackedFloat32Array, indices: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_FLOAT_32_ARRAY to vertices, PACKED_INT_32_ARRAY to indices)
    TransferContext.callMethod(MethodBindings.appendArraysPtr)
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
   * Adds the geometry data of a [Mesh] resource to the navigation mesh baking data. The mesh must
   * have valid triangulated mesh data to be considered. Since [NavigationMesh] resources have no
   * transform, all vertex positions need to be offset by the node's transform using [xform].
   */
  public final fun addMesh(mesh: Mesh?, xform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh, TRANSFORM3D to xform)
    TransferContext.callMethod(MethodBindings.addMeshPtr)
  }

  /**
   * Adds an [Array] the size of [Mesh.ARRAY_MAX] and with vertices at index [Mesh.ARRAY_VERTEX] and
   * indices at index [Mesh.ARRAY_INDEX] to the navigation mesh baking data. The array must have valid
   * triangulated mesh data to be considered. Since [NavigationMesh] resources have no transform, all
   * vertex positions need to be offset by the node's transform using [xform].
   */
  public final fun addMeshArray(meshArray: VariantArray<Any?>, xform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to meshArray, TRANSFORM3D to xform)
    TransferContext.callMethod(MethodBindings.addMeshArrayPtr)
  }

  /**
   * Adds an array of vertex positions to the geometry data for navigation mesh baking to form
   * triangulated faces. For each face the array must have three vertex positions in clockwise winding
   * order. Since [NavigationMesh] resources have no transform, all vertex positions need to be offset
   * by the node's transform using [xform].
   */
  public final fun addFaces(faces: PackedVector3Array, xform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to faces, TRANSFORM3D to xform)
    TransferContext.callMethod(MethodBindings.addFacesPtr)
  }

  /**
   * Adds the geometry data of another [NavigationMeshSourceGeometryData3D] to the navigation mesh
   * baking data.
   */
  public final fun merge(otherGeometry: NavigationMeshSourceGeometryData3D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to otherGeometry)
    TransferContext.callMethod(MethodBindings.mergePtr)
  }

  /**
   * Adds a projected obstruction shape to the source geometry. The [vertices] are considered
   * projected on an xz-axes plane, placed at the global y-axis [elevation] and extruded by [height].
   * If [carve] is `true` the carved shape will not be affected by additional offsets (e.g. agent
   * radius) of the navigation mesh baking process.
   */
  public final fun addProjectedObstruction(
    vertices: PackedVector3Array,
    elevation: Float,
    height: Float,
    carve: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to vertices, DOUBLE to elevation.toDouble(), DOUBLE to height.toDouble(), BOOL to carve)
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
   * "elevation" : float
   * "height" : float
   * "carve" : bool
   * ```
   */
  public final fun setProjectedObstructions(projectedObstructions: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to projectedObstructions)
    TransferContext.callMethod(MethodBindings.setProjectedObstructionsPtr)
  }

  /**
   * Returns the projected obstructions as an [Array] of dictionaries. Each [Dictionary] contains
   * the following entries:
   *
   * - `vertices` - A [PackedFloat32Array] that defines the outline points of the projected shape.
   *
   * - `elevation` - A [float] that defines the projected shape placement on the y-axis.
   *
   * - `height` - A [float] that defines how much the projected shape is extruded along the y-axis.
   *
   * - `carve` - A [bool] that defines how the obstacle affects the navigation mesh baking. If
   * `true` the projected shape will not be affected by addition offsets, e.g. agent radius.
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
  public final fun getBounds(): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoundsPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  public companion object {
    @JvmField
    public val setVerticesName:
        MethodStringName1<NavigationMeshSourceGeometryData3D, Unit, PackedFloat32Array> =
        MethodStringName1<NavigationMeshSourceGeometryData3D, Unit, PackedFloat32Array>("set_vertices")

    @JvmField
    public val getVerticesName:
        MethodStringName0<NavigationMeshSourceGeometryData3D, PackedFloat32Array> =
        MethodStringName0<NavigationMeshSourceGeometryData3D, PackedFloat32Array>("get_vertices")

    @JvmField
    public val setIndicesName:
        MethodStringName1<NavigationMeshSourceGeometryData3D, Unit, PackedInt32Array> =
        MethodStringName1<NavigationMeshSourceGeometryData3D, Unit, PackedInt32Array>("set_indices")

    @JvmField
    public val getIndicesName:
        MethodStringName0<NavigationMeshSourceGeometryData3D, PackedInt32Array> =
        MethodStringName0<NavigationMeshSourceGeometryData3D, PackedInt32Array>("get_indices")

    @JvmField
    public val appendArraysName:
        MethodStringName2<NavigationMeshSourceGeometryData3D, Unit, PackedFloat32Array, PackedInt32Array>
        =
        MethodStringName2<NavigationMeshSourceGeometryData3D, Unit, PackedFloat32Array, PackedInt32Array>("append_arrays")

    @JvmField
    public val clearName: MethodStringName0<NavigationMeshSourceGeometryData3D, Unit> =
        MethodStringName0<NavigationMeshSourceGeometryData3D, Unit>("clear")

    @JvmField
    public val hasDataName: MethodStringName0<NavigationMeshSourceGeometryData3D, Boolean> =
        MethodStringName0<NavigationMeshSourceGeometryData3D, Boolean>("has_data")

    @JvmField
    public val addMeshName:
        MethodStringName2<NavigationMeshSourceGeometryData3D, Unit, Mesh?, Transform3D> =
        MethodStringName2<NavigationMeshSourceGeometryData3D, Unit, Mesh?, Transform3D>("add_mesh")

    @JvmField
    public val addMeshArrayName:
        MethodStringName2<NavigationMeshSourceGeometryData3D, Unit, VariantArray<Any?>, Transform3D>
        =
        MethodStringName2<NavigationMeshSourceGeometryData3D, Unit, VariantArray<Any?>, Transform3D>("add_mesh_array")

    @JvmField
    public val addFacesName:
        MethodStringName2<NavigationMeshSourceGeometryData3D, Unit, PackedVector3Array, Transform3D>
        =
        MethodStringName2<NavigationMeshSourceGeometryData3D, Unit, PackedVector3Array, Transform3D>("add_faces")

    @JvmField
    public val mergeName:
        MethodStringName1<NavigationMeshSourceGeometryData3D, Unit, NavigationMeshSourceGeometryData3D?>
        =
        MethodStringName1<NavigationMeshSourceGeometryData3D, Unit, NavigationMeshSourceGeometryData3D?>("merge")

    @JvmField
    public val addProjectedObstructionName:
        MethodStringName4<NavigationMeshSourceGeometryData3D, Unit, PackedVector3Array, Float, Float, Boolean>
        =
        MethodStringName4<NavigationMeshSourceGeometryData3D, Unit, PackedVector3Array, Float, Float, Boolean>("add_projected_obstruction")

    @JvmField
    public val clearProjectedObstructionsName:
        MethodStringName0<NavigationMeshSourceGeometryData3D, Unit> =
        MethodStringName0<NavigationMeshSourceGeometryData3D, Unit>("clear_projected_obstructions")

    @JvmField
    public val setProjectedObstructionsName:
        MethodStringName1<NavigationMeshSourceGeometryData3D, Unit, VariantArray<Any?>> =
        MethodStringName1<NavigationMeshSourceGeometryData3D, Unit, VariantArray<Any?>>("set_projected_obstructions")

    @JvmField
    public val getProjectedObstructionsName:
        MethodStringName0<NavigationMeshSourceGeometryData3D, VariantArray<Any?>> =
        MethodStringName0<NavigationMeshSourceGeometryData3D, VariantArray<Any?>>("get_projected_obstructions")

    @JvmField
    public val getBoundsName: MethodStringName0<NavigationMeshSourceGeometryData3D, AABB> =
        MethodStringName0<NavigationMeshSourceGeometryData3D, AABB>("get_bounds")
  }

  public object MethodBindings {
    internal val setVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "set_vertices", 2899603908)

    internal val getVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "get_vertices", 675695659)

    internal val setIndicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "set_indices", 3614634198)

    internal val getIndicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "get_indices", 1930428628)

    internal val appendArraysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "append_arrays", 3117535015)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "clear", 3218959716)

    internal val hasDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "has_data", 2240911060)

    internal val addMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "add_mesh", 975462459)

    internal val addMeshArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "add_mesh_array", 4235710913)

    internal val addFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "add_faces", 1440358797)

    internal val mergePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "merge", 655828145)

    internal val addProjectedObstructionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "add_projected_obstruction", 3351846707)

    internal val clearProjectedObstructionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "clear_projected_obstructions", 3218959716)

    internal val setProjectedObstructionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "set_projected_obstructions", 381264803)

    internal val getProjectedObstructionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "get_projected_obstructions", 3995934104)

    internal val getBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshSourceGeometryData3D", "get_bounds", 1021181044)
  }
}
