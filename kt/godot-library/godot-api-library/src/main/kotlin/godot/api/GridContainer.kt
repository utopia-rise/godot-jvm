// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [GridContainer] arranges its child controls in a grid layout. The number of columns is specified
 * by the [columns] property, whereas the number of rows depends on how many are needed for the child
 * controls. The number of rows and columns is preserved for every size of the container.
 *
 * **Note:** [GridContainer] only works with child nodes inheriting from [Control]. It won't
 * rearrange child nodes inheriting from [Node2D].
 */
@GodotBaseType
public open class GridContainer : Container() {
  /**
   * The number of columns in the [GridContainer]. If modified, [GridContainer] reorders its
   * Control-derived children to accommodate the new layout.
   */
  public final inline var columns: Int
    @JvmName("columnsProperty")
    get() = getColumns()
    @JvmName("columnsProperty")
    set(`value`) {
      setColumns(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(281, scriptPtr)
  }

  public final fun setColumns(columns: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setColumnsPtr, columns.toLong())
  }

  public final fun getColumns(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getColumnsPtr).toInt()

  public companion object {
    @JvmField
    public val setColumnsName: MethodStringName1<GridContainer, Unit, Int> =
        MethodStringName1<GridContainer, Unit, Int>("set_columns")

    @JvmField
    public val getColumnsName: MethodStringName0<GridContainer, Int> =
        MethodStringName0<GridContainer, Int>("get_columns")
  }

  public object MethodBindings {
    internal val setColumnsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridContainer", "set_columns", 1286410249)

    internal val getColumnsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridContainer", "get_columns", 3905245786)
  }
}
