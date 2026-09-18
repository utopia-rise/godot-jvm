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
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * This [SkeletonModification2D] holds a reference to a [SkeletonModificationStack2D], allowing you
 * to use multiple modification stacks on a single [Skeleton2D].
 *
 * **Note:** The modifications in the held [SkeletonModificationStack2D] will only be executed if
 * their execution mode matches the execution mode of the SkeletonModification2DStackHolder.
 */
@GodotBaseType
public open class SkeletonModification2DStackHolder : SkeletonModification2D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(673, scriptPtr)
  }

  /**
   * Sets the [SkeletonModificationStack2D] that this modification is holding. This modification
   * stack will then be executed when this modification is executed.
   */
  public final fun setHeldModificationStack(heldModificationStack: SkeletonModificationStack2D?):
      Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, heldModificationStack)
    TransferContext.callPtrMethod(MethodBindings.setHeldModificationStackPtr, 0)
  }

  /**
   * Returns the [SkeletonModificationStack2D] that this modification is holding.
   */
  public final fun getHeldModificationStack(): SkeletonModificationStack2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHeldModificationStackPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as SkeletonModificationStack2D?)
  }

  public companion object {
    @JvmField
    public val setHeldModificationStackName:
        MethodStringName1<SkeletonModification2DStackHolder, Unit, SkeletonModificationStack2D?> =
        MethodStringName1<SkeletonModification2DStackHolder, Unit, SkeletonModificationStack2D?>("set_held_modification_stack")

    @JvmField
    public val getHeldModificationStackName:
        MethodStringName0<SkeletonModification2DStackHolder, SkeletonModificationStack2D?> =
        MethodStringName0<SkeletonModification2DStackHolder, SkeletonModificationStack2D?>("get_held_modification_stack")
  }

  public object MethodBindings {
    internal val setHeldModificationStackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DStackHolder", "set_held_modification_stack", 3907307132)

    internal val getHeldModificationStackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DStackHolder", "get_held_modification_stack", 2107508396)
  }
}
