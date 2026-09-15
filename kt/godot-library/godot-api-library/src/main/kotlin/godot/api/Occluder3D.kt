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
import godot.core.MethodStringName0
import godot.core.PackedInt32Array
import godot.core.PackedVector3Array
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [Occluder3D] stores an occluder shape that can be used by the engine's occlusion culling system.
 *
 * See [OccluderInstance3D]'s documentation for instructions on setting up occlusion culling.
 */
@GodotBaseType
public open class Occluder3D internal constructor() : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(429, scriptPtr)
  }

  /**
   * Returns the occluder shape's vertex positions.
   */
  public final fun getVertices(): PackedVector3Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVerticesPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR3_ARRAY) as PackedVector3Array)
  }

  /**
   * Returns the occluder shape's vertex indices.
   */
  public final fun getIndices(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIndicesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  public companion object {
    @JvmField
    public val getVerticesName: MethodStringName0<Occluder3D, PackedVector3Array> =
        MethodStringName0<Occluder3D, PackedVector3Array>("get_vertices")

    @JvmField
    public val getIndicesName: MethodStringName0<Occluder3D, PackedInt32Array> =
        MethodStringName0<Occluder3D, PackedInt32Array>("get_indices")
  }

  public object MethodBindings {
    internal val getVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Occluder3D", "get_vertices", 497664490)

    internal val getIndicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Occluder3D", "get_indices", 1930428628)
  }
}
