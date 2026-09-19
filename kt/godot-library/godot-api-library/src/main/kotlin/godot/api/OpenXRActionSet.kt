// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantArray
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Action sets in OpenXR define a collection of actions that can be activated in unison. This allows
 * games to easily change between different states that require different inputs or need to reinterpret
 * inputs. For instance we could have an action set that is active when a menu is open, an action set
 * that is active when the player is freely walking around and an action set that is active when the
 * player is controlling a vehicle.
 *
 * Action sets can contain the same action with the same name, if such action sets are active at the
 * same time the action set with the highest priority defines which binding is active.
 */
@GodotBaseType
public open class OpenXRActionSet : Resource() {
  /**
   * The localized name of this action set.
   */
  public final inline var localizedName: String
    @JvmName("localizedNameProperty")
    get() = getLocalizedName()
    @JvmName("localizedNameProperty")
    set(`value`) {
      setLocalizedName(value)
    }

  /**
   * The priority for this action set.
   */
  public final inline var priority: Int
    @JvmName("priorityProperty")
    get() = getPriority()
    @JvmName("priorityProperty")
    set(`value`) {
      setPriority(value)
    }

  /**
   * Collection of actions for this action set.
   */
  public final inline var actions: VariantArray<Any?>
    @JvmName("actionsProperty")
    get() = getActions()
    @JvmName("actionsProperty")
    set(`value`) {
      setActions(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(440, scriptPtr)
  }

  public final fun setLocalizedName(localizedName: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setLocalizedNamePtr, localizedName)
  }

  public final fun getLocalizedName(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getLocalizedNamePtr)

  public final fun setPriority(priority: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setPriorityPtr, priority.toLong())
  }

  public final fun getPriority(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getPriorityPtr).toInt()

  /**
   * Retrieve the number of actions in our action set.
   */
  public final fun getActionCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getActionCountPtr).toInt()

  public final fun setActions(actions: VariantArray<Any?>): Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.setActionsPtr, actions)
  }

  public final fun getActions(): VariantArray<Any?> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getActionsPtr) as VariantArray<Any?>)

  /**
   * Add an action to this action set.
   */
  public final fun addAction(action: OpenXRAction?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.addActionPtr, action)
  }

  /**
   * Remove an action from this action set.
   */
  public final fun removeAction(action: OpenXRAction?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.removeActionPtr, action)
  }

  public companion object {
    @JvmField
    public val setLocalizedNameName: MethodStringName1<OpenXRActionSet, Unit, String> =
        MethodStringName1<OpenXRActionSet, Unit, String>("set_localized_name")

    @JvmField
    public val getLocalizedNameName: MethodStringName0<OpenXRActionSet, String> =
        MethodStringName0<OpenXRActionSet, String>("get_localized_name")

    @JvmField
    public val setPriorityName: MethodStringName1<OpenXRActionSet, Unit, Int> =
        MethodStringName1<OpenXRActionSet, Unit, Int>("set_priority")

    @JvmField
    public val getPriorityName: MethodStringName0<OpenXRActionSet, Int> =
        MethodStringName0<OpenXRActionSet, Int>("get_priority")

    @JvmField
    public val getActionCountName: MethodStringName0<OpenXRActionSet, Int> =
        MethodStringName0<OpenXRActionSet, Int>("get_action_count")

    @JvmField
    public val setActionsName: MethodStringName1<OpenXRActionSet, Unit, VariantArray<Any?>> =
        MethodStringName1<OpenXRActionSet, Unit, VariantArray<Any?>>("set_actions")

    @JvmField
    public val getActionsName: MethodStringName0<OpenXRActionSet, VariantArray<Any?>> =
        MethodStringName0<OpenXRActionSet, VariantArray<Any?>>("get_actions")

    @JvmField
    public val addActionName: MethodStringName1<OpenXRActionSet, Unit, OpenXRAction?> =
        MethodStringName1<OpenXRActionSet, Unit, OpenXRAction?>("add_action")

    @JvmField
    public val removeActionName: MethodStringName1<OpenXRActionSet, Unit, OpenXRAction?> =
        MethodStringName1<OpenXRActionSet, Unit, OpenXRAction?>("remove_action")
  }

  public object MethodBindings {
    internal val setLocalizedNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "set_localized_name", 83702148)

    internal val getLocalizedNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "get_localized_name", 201670096)

    internal val setPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "set_priority", 1286410249)

    internal val getPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "get_priority", 3905245786)

    internal val getActionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "get_action_count", 3905245786)

    internal val setActionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "set_actions", 381264803)

    internal val getActionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "get_actions", 3995934104)

    internal val addActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "add_action", 349361333)

    internal val removeActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRActionSet", "remove_action", 349361333)
  }
}
