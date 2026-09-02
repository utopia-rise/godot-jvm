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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedInt32Array
import godot.core.PackedVector3Array
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.Vector3
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [ArrayOccluder3D] stores an arbitrary 3D polygon shape that can be used by the engine's occlusion
 * culling system. This is analogous to [ArrayMesh], but for occluders.
 *
 * See [OccluderInstance3D]'s documentation for instructions on setting up occlusion culling.
 */
@GodotBaseType
public open class ArrayOccluder3D : Occluder3D() {
  /**
   * The occluder's vertex positions in local 3D coordinates.
   *
   * **Note:** The occluder is always updated after setting this value. If creating occluders
   * procedurally, consider using [setArrays] instead to avoid updating the occluder twice when it's
   * created.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var vertices: PackedVector3Array
    @JvmName("verticesProperty")
    get() = getVertices()
    @JvmName("verticesProperty")
    set(`value`) {
      setVertices(value)
    }

  /**
   * The occluder's index position. Indices determine which points from the [vertices] array should
   * be drawn, and in which order.
   *
   * **Note:** The occluder is always updated after setting this value. If creating occluders
   * procedurally, consider using [setArrays] instead to avoid updating the occluder twice when it's
   * created.
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

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(44, scriptPtr)
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = arrayoccluder3d.vertices
   * //Your changes
   * arrayoccluder3d.vertices = myCoreType
   * ``````
   *
   * The occluder's vertex positions in local 3D coordinates.
   *
   * **Note:** The occluder is always updated after setting this value. If creating occluders
   * procedurally, consider using [setArrays] instead to avoid updating the occluder twice when it's
   * created.
   */
  @CoreTypeHelper
  public final fun verticesMutate(block: PackedVector3Array.() -> Unit): PackedVector3Array =
      vertices.apply {
     block(this)
     vertices = this
  }

  /**
   * This is a helper function for [vertices] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The occluder's vertex positions in local 3D coordinates.
   *
   * **Note:** The occluder is always updated after setting this value. If creating occluders
   * procedurally, consider using [setArrays] instead to avoid updating the occluder twice when it's
   * created.
   */
  @CoreTypeHelper
  public final fun verticesMutateEach(block: (index: Int, `value`: Vector3) -> Unit):
      PackedVector3Array = vertices.apply {
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
   * val myCoreType = arrayoccluder3d.indices
   * //Your changes
   * arrayoccluder3d.indices = myCoreType
   * ``````
   *
   * The occluder's index position. Indices determine which points from the [vertices] array should
   * be drawn, and in which order.
   *
   * **Note:** The occluder is always updated after setting this value. If creating occluders
   * procedurally, consider using [setArrays] instead to avoid updating the occluder twice when it's
   * created.
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
   *
   * The occluder's index position. Indices determine which points from the [vertices] array should
   * be drawn, and in which order.
   *
   * **Note:** The occluder is always updated after setting this value. If creating occluders
   * procedurally, consider using [setArrays] instead to avoid updating the occluder twice when it's
   * created.
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
   * Sets [indices] and [vertices], while updating the final occluder only once after both values
   * are set.
   */
  public final fun setArrays(vertices: PackedVector3Array, indices: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to vertices, PACKED_INT_32_ARRAY to indices)
    TransferContext.callMethod(MethodBindings.setArraysPtr)
  }

  public final fun setVertices(vertices: PackedVector3Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to vertices)
    TransferContext.callMethod(MethodBindings.setVerticesPtr)
  }

  public final fun setIndices(indices: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_32_ARRAY to indices)
    TransferContext.callMethod(MethodBindings.setIndicesPtr)
  }

  public companion object {
    @JvmField
    public val setArraysName:
        MethodStringName2<ArrayOccluder3D, Unit, PackedVector3Array, PackedInt32Array> =
        MethodStringName2<ArrayOccluder3D, Unit, PackedVector3Array, PackedInt32Array>("set_arrays")

    @JvmField
    public val setVerticesName: MethodStringName1<ArrayOccluder3D, Unit, PackedVector3Array> =
        MethodStringName1<ArrayOccluder3D, Unit, PackedVector3Array>("set_vertices")

    @JvmField
    public val setIndicesName: MethodStringName1<ArrayOccluder3D, Unit, PackedInt32Array> =
        MethodStringName1<ArrayOccluder3D, Unit, PackedInt32Array>("set_indices")
  }

  public object MethodBindings {
    internal val setArraysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ArrayOccluder3D", "set_arrays", 3233972621)

    internal val setVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ArrayOccluder3D", "set_vertices", 334873810)

    internal val setIndicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ArrayOccluder3D", "set_indices", 3614634198)
  }
}
