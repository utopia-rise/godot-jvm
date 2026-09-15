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
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.StringName
import godot.core.VariantArray
import godot.readReturnValue_BOOL
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_RID
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * Node that can be the parent of [PhysicalBone3D] and can apply the simulation results to
 * [Skeleton3D].
 */
@GodotBaseType
public open class PhysicalBoneSimulator3D : SkeletonModifier3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(521, scriptPtr)
  }

  /**
   * Returns a boolean that indicates whether the [PhysicalBoneSimulator3D] is running and
   * simulating.
   */
  public final fun isSimulatingPhysics(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSimulatingPhysicsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Tells the [PhysicalBone3D] nodes in the Skeleton to stop simulating.
   */
  public final fun physicalBonesStopSimulation(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.physicalBonesStopSimulationPtr)
  }

  /**
   * Tells the [PhysicalBone3D] nodes in the Skeleton to start simulating and reacting to the
   * physics world.
   *
   * Optionally, a list of bone names can be passed-in, allowing only the passed-in bones to be
   * simulated.
   */
  @JvmOverloads
  public final fun physicalBonesStartSimulation(bones: VariantArray<StringName> =
      godot.core.variantArrayOf()): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, bones)
    TransferContext.callMethod(MethodBindings.physicalBonesStartSimulationPtr)
  }

  /**
   * Adds a collision exception to the physical bone.
   *
   * Works just like the [RigidBody3D] node.
   */
  public final fun physicalBonesAddCollisionException(exception: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, exception)
    TransferContext.callMethod(MethodBindings.physicalBonesAddCollisionExceptionPtr)
  }

  /**
   * Removes a collision exception to the physical bone.
   *
   * Works just like the [RigidBody3D] node.
   */
  public final fun physicalBonesRemoveCollisionException(exception: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, exception)
    TransferContext.callMethod(MethodBindings.physicalBonesRemoveCollisionExceptionPtr)
  }

  public companion object {
    @JvmField
    public val isSimulatingPhysicsName: MethodStringName0<PhysicalBoneSimulator3D, Boolean> =
        MethodStringName0<PhysicalBoneSimulator3D, Boolean>("is_simulating_physics")

    @JvmField
    public val physicalBonesStopSimulationName: MethodStringName0<PhysicalBoneSimulator3D, Unit> =
        MethodStringName0<PhysicalBoneSimulator3D, Unit>("physical_bones_stop_simulation")

    @JvmField
    public val physicalBonesStartSimulationName:
        MethodStringName1<PhysicalBoneSimulator3D, Unit, VariantArray<StringName>> =
        MethodStringName1<PhysicalBoneSimulator3D, Unit, VariantArray<StringName>>("physical_bones_start_simulation")

    @JvmField
    public val physicalBonesAddCollisionExceptionName:
        MethodStringName1<PhysicalBoneSimulator3D, Unit, RID> =
        MethodStringName1<PhysicalBoneSimulator3D, Unit, RID>("physical_bones_add_collision_exception")

    @JvmField
    public val physicalBonesRemoveCollisionExceptionName:
        MethodStringName1<PhysicalBoneSimulator3D, Unit, RID> =
        MethodStringName1<PhysicalBoneSimulator3D, Unit, RID>("physical_bones_remove_collision_exception")
  }

  public object MethodBindings {
    internal val isSimulatingPhysicsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBoneSimulator3D", "is_simulating_physics", 36873697)

    internal val physicalBonesStopSimulationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBoneSimulator3D", "physical_bones_stop_simulation", 3218959716)

    internal val physicalBonesStartSimulationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBoneSimulator3D", "physical_bones_start_simulation", 2787316981)

    internal val physicalBonesAddCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBoneSimulator3D", "physical_bones_add_collision_exception", 2722037293)

    internal val physicalBonesRemoveCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicalBoneSimulator3D", "physical_bones_remove_collision_exception", 2722037293)
  }
}
