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
import godot.core.VariantParser.BOOL
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [CenterContainer] is a container that keeps all of its child controls in its center at their
 * minimum size.
 */
@GodotBaseType
public open class CenterContainer : Container() {
  /**
   * If `true`, centers children relative to the [CenterContainer]'s top left corner.
   */
  public final inline var useTopLeft: Boolean
    @JvmName("useTopLeftProperty")
    get() = isUsingTopLeft()
    @JvmName("useTopLeftProperty")
    set(`value`) {
      setUseTopLeft(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(150, scriptPtr)
  }

  public final fun setUseTopLeft(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseTopLeftPtr)
  }

  public final fun isUsingTopLeft(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingTopLeftPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setUseTopLeftName: MethodStringName1<CenterContainer, Unit, Boolean> =
        MethodStringName1<CenterContainer, Unit, Boolean>("set_use_top_left")

    @JvmField
    public val isUsingTopLeftName: MethodStringName0<CenterContainer, Boolean> =
        MethodStringName0<CenterContainer, Boolean>("is_using_top_left")
  }

  public object MethodBindings {
    internal val setUseTopLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CenterContainer", "set_use_top_left", 2586408642)

    internal val isUsingTopLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CenterContainer", "is_using_top_left", 36873697)
  }
}
