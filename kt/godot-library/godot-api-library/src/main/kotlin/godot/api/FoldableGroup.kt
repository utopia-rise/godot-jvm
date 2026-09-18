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
import godot.core.Signal1
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A group of [FoldableContainer]-derived nodes. Only one container can be expanded at a time.
 */
@GodotBaseType
public open class FoldableGroup : Resource() {
  /**
   * Emitted when one of the containers of the group is expanded.
   */
  public val expanded: Signal1<FoldableContainer> by Signal1

  /**
   * If `true`, it is possible to fold all containers in this FoldableGroup.
   */
  public final inline var allowFoldingAll: Boolean
    @JvmName("allowFoldingAllProperty")
    get() = isAllowFoldingAll()
    @JvmName("allowFoldingAllProperty")
    set(`value`) {
      setAllowFoldingAll(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(230, scriptPtr)
  }

  /**
   * Returns the current expanded container.
   */
  public final fun getExpandedContainer(): FoldableContainer? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getExpandedContainerPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as FoldableContainer?)
  }

  /**
   * Returns an [VariantArray] of [FoldableContainer]s that have this as their FoldableGroup (see
   * [FoldableContainer.foldableGroup]). This is equivalent to [ButtonGroup] but for
   * FoldableContainers.
   */
  public final fun getContainers(): VariantArray<FoldableContainer> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getContainersPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<FoldableContainer>)
  }

  public final fun setAllowFoldingAll(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setAllowFoldingAllPtr, 0)
  }

  public final fun isAllowFoldingAll(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAllowFoldingAllPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val getExpandedContainerName: MethodStringName0<FoldableGroup, FoldableContainer?> =
        MethodStringName0<FoldableGroup, FoldableContainer?>("get_expanded_container")

    @JvmField
    public val getContainersName: MethodStringName0<FoldableGroup, VariantArray<FoldableContainer>>
        = MethodStringName0<FoldableGroup, VariantArray<FoldableContainer>>("get_containers")

    @JvmField
    public val setAllowFoldingAllName: MethodStringName1<FoldableGroup, Unit, Boolean> =
        MethodStringName1<FoldableGroup, Unit, Boolean>("set_allow_folding_all")

    @JvmField
    public val isAllowFoldingAllName: MethodStringName0<FoldableGroup, Boolean> =
        MethodStringName0<FoldableGroup, Boolean>("is_allow_folding_all")
  }

  public object MethodBindings {
    internal val getExpandedContainerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableGroup", "get_expanded_container", 1427441056)

    internal val getContainersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableGroup", "get_containers", 3995934104)

    internal val setAllowFoldingAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableGroup", "set_allow_folding_all", 2586408642)

    internal val isAllowFoldingAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableGroup", "is_allow_folding_all", 36873697)
  }
}
