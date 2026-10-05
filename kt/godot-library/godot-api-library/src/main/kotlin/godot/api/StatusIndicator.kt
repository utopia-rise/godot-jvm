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
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_NODE_PATH
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_RECT2
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_NODE_PATH
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.Rect2
import godot.core.Signal2
import godot.core.Vector2i
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

@GodotBaseType
public open class StatusIndicator : Node() {
  /**
   * Emitted when the status indicator is pressed.
   */
  public val pressed: Signal2<Long, Vector2i> by Signal2

  /**
   * Status indicator tooltip.
   */
  public final inline var tooltip: String
    @JvmName("tooltipProperty")
    get() = getTooltip()
    @JvmName("tooltipProperty")
    set(`value`) {
      setTooltip(value)
    }

  /**
   * Status indicator icon.
   */
  public final inline var icon: Texture2D?
    @JvmName("iconProperty")
    get() = getIcon()
    @JvmName("iconProperty")
    set(`value`) {
      setIcon(value)
    }

  /**
   * Status indicator native popup menu. If this is set, the [signal pressed] signal is not emitted.
   *
   * **Note:** Native popup is only supported if [NativeMenu] supports
   * [NativeMenu.FEATURE_POPUP_MENU] feature.
   */
  public final inline var menu: NodePath
    @JvmName("menuProperty")
    get() = getMenu()
    @JvmName("menuProperty")
    set(`value`) {
      setMenu(value)
    }

  /**
   * If `true`, the status indicator is visible.
   */
  public final inline var visible: Boolean
    @JvmName("visibleProperty")
    get() = isVisible()
    @JvmName("visibleProperty")
    set(`value`) {
      setVisible(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(706, scriptPtr)
  }

  public final fun setTooltip(tooltip: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setTooltipPtr, tooltip)
  }

  public final fun getTooltip(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getTooltipPtr)

  public final fun setIcon(texture: Texture2D?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setIconPtr, texture)
  }

  public final fun getIcon(): Texture2D? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getIconPtr) as Texture2D?)

  public final fun setVisible(visible: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setVisiblePtr, visible)
  }

  public final fun isVisible(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isVisiblePtr)

  public final fun setMenu(menu: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setMenuPtr, menu)
  }

  public final fun getMenu(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getMenuPtr)

  /**
   * Returns the status indicator rectangle in screen coordinates. If this status indicator is not
   * visible, returns an empty [Rect2].
   */
  public final fun getRect(): Rect2 =
      TransferContext.callPtrMethod0_ret_RECT2(ptr, objectID.id, MethodBindings.getRectPtr)

  public final fun setMenu(menu: String) = setMenu(menu.asCachedNodePath())

  public companion object {
    @JvmField
    public val setTooltipName: MethodStringName1<StatusIndicator, Unit, String> =
        MethodStringName1<StatusIndicator, Unit, String>("set_tooltip")

    @JvmField
    public val getTooltipName: MethodStringName0<StatusIndicator, String> =
        MethodStringName0<StatusIndicator, String>("get_tooltip")

    @JvmField
    public val setIconName: MethodStringName1<StatusIndicator, Unit, Texture2D?> =
        MethodStringName1<StatusIndicator, Unit, Texture2D?>("set_icon")

    @JvmField
    public val getIconName: MethodStringName0<StatusIndicator, Texture2D?> =
        MethodStringName0<StatusIndicator, Texture2D?>("get_icon")

    @JvmField
    public val setVisibleName: MethodStringName1<StatusIndicator, Unit, Boolean> =
        MethodStringName1<StatusIndicator, Unit, Boolean>("set_visible")

    @JvmField
    public val isVisibleName: MethodStringName0<StatusIndicator, Boolean> =
        MethodStringName0<StatusIndicator, Boolean>("is_visible")

    @JvmField
    public val setMenuName: MethodStringName1<StatusIndicator, Unit, NodePath> =
        MethodStringName1<StatusIndicator, Unit, NodePath>("set_menu")

    @JvmField
    public val getMenuName: MethodStringName0<StatusIndicator, NodePath> =
        MethodStringName0<StatusIndicator, NodePath>("get_menu")

    @JvmField
    public val getRectName: MethodStringName0<StatusIndicator, Rect2> =
        MethodStringName0<StatusIndicator, Rect2>("get_rect")
  }

  public object MethodBindings {
    internal val setTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "set_tooltip", 83702148)

    internal val getTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "get_tooltip", 201670096)

    internal val setIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "set_icon", 4051416890)

    internal val getIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "get_icon", 3635182373)

    internal val setVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "set_visible", 2586408642)

    internal val isVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "is_visible", 36873697)

    internal val setMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "set_menu", 1348162250)

    internal val getMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "get_menu", 4075236667)

    internal val getRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StatusIndicator", "get_rect", 1639390495)
  }
}
