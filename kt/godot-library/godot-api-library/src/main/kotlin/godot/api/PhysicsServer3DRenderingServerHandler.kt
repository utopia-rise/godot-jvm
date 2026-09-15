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
import godot.core.AABB
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Vector3
import godot.writeMethodArguments_AABB
import godot.writeMethodArguments_LONG_VECTOR3
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

@GodotBaseType
public abstract class PhysicsServer3DRenderingServerHandler : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(542, scriptPtr)
  }

  /**
   * Called by the [PhysicsServer3D] to set the position for the [SoftBody3D] vertex at the index
   * specified by [vertexId].
   *
   * **Note:** The [vertex] parameter used to be of type `const void*` prior to Godot 4.2.
   */
  public abstract fun _setVertex(vertexId: Int, vertex: Vector3): Unit

  /**
   * Called by the [PhysicsServer3D] to set the normal for the [SoftBody3D] vertex at the index
   * specified by [vertexId].
   *
   * **Note:** The [normal] parameter used to be of type `const void*` prior to Godot 4.2.
   */
  public abstract fun _setNormal(vertexId: Int, normal: Vector3): Unit

  /**
   * Called by the [PhysicsServer3D] to set the bounding box for the [SoftBody3D].
   */
  public abstract fun _setAabb(aabb: AABB): Unit

  /**
   * Sets the position for the [SoftBody3D] vertex at the index specified by [vertexId].
   */
  public final fun setVertex(vertexId: Int, vertex: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, vertexId.toLong(), vertex)
    TransferContext.callMethod(MethodBindings.setVertexPtr)
  }

  /**
   * Sets the normal for the [SoftBody3D] vertex at the index specified by [vertexId].
   */
  public final fun setNormal(vertexId: Int, normal: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, vertexId.toLong(), normal)
    TransferContext.callMethod(MethodBindings.setNormalPtr)
  }

  /**
   * Sets the bounding box for the [SoftBody3D].
   */
  public final fun setAabb(aabb: AABB): Unit {
    TransferContext.writeMethodArguments_AABB(ptr, objectID.id, aabb)
    TransferContext.callMethod(MethodBindings.setAabbPtr)
  }

  public companion object {
    @JvmField
    public val setVertexName:
        MethodStringName2<PhysicsServer3DRenderingServerHandler, Unit, Int, Vector3> =
        MethodStringName2<PhysicsServer3DRenderingServerHandler, Unit, Int, Vector3>("set_vertex")

    @JvmField
    public val setNormalName:
        MethodStringName2<PhysicsServer3DRenderingServerHandler, Unit, Int, Vector3> =
        MethodStringName2<PhysicsServer3DRenderingServerHandler, Unit, Int, Vector3>("set_normal")

    @JvmField
    public val setAabbName: MethodStringName1<PhysicsServer3DRenderingServerHandler, Unit, AABB> =
        MethodStringName1<PhysicsServer3DRenderingServerHandler, Unit, AABB>("set_aabb")
  }

  public object MethodBindings {
    internal val setVertexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3DRenderingServerHandler", "set_vertex", 1530502735)

    internal val setNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3DRenderingServerHandler", "set_normal", 1530502735)

    internal val setAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsServer3DRenderingServerHandler", "set_aabb", 259215842)
  }
}

internal class PhysicsServer3DRenderingServerHandlerDummy : PhysicsServer3DRenderingServerHandler()
    {
  public override fun _setVertex(vertexId: Int, vertex: Vector3): Unit {
    throw NotImplementedError("PhysicsServer3DRenderingServerHandler::_setVertex is only implemented by non-JVM code.")
  }

  public override fun _setNormal(vertexId: Int, normal: Vector3): Unit {
    throw NotImplementedError("PhysicsServer3DRenderingServerHandler::_setNormal is only implemented by non-JVM code.")
  }

  public override fun _setAabb(aabb: AABB): Unit {
    throw NotImplementedError("PhysicsServer3DRenderingServerHandler::_setAabb is only implemented by non-JVM code.")
  }
}
