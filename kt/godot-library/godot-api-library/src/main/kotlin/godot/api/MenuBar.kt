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
import godot.core.MethodStringName2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A horizontal menu bar that creates a menu for each [PopupMenu] child. New items are created by
 * adding [PopupMenu]s to this node. Item title is determined by [Window.title], or node name if
 * [Window.title] is empty. Item title can be overridden using [setMenuTitle].
 */
@GodotBaseType
public open class MenuBar : Control() {
  /**
   * Flat [MenuBar] don't display item decoration.
   */
  public final inline var flat: Boolean
    @JvmName("flatProperty")
    get() = isFlat()
    @JvmName("flatProperty")
    set(`value`) {
      setFlat(value)
    }

  /**
   * Position order in the global menu to insert [MenuBar] items at. All menu items in the [MenuBar]
   * are always inserted as a continuous range. Menus with lower [startIndex] are inserted first. Menus
   * with [startIndex] equal to `-1` are inserted last.
   */
  public final inline var startIndex: Int
    @JvmName("startIndexProperty")
    get() = getStartIndex()
    @JvmName("startIndexProperty")
    set(`value`) {
      setStartIndex(value)
    }

  /**
   * If `true`, when the cursor hovers above menu item, it will close the current [PopupMenu] and
   * open the other one.
   */
  public final inline var switchOnHover: Boolean
    @JvmName("switchOnHoverProperty")
    get() = isSwitchOnHover()
    @JvmName("switchOnHoverProperty")
    set(`value`) {
      setSwitchOnHover(value)
    }

  /**
   * If `true`, [MenuBar] will use system global menu when supported.
   *
   * **Note:** If `true` and global menu is supported, this node is not displayed, has zero size,
   * and all its child nodes except [PopupMenu]s are inaccessible.
   *
   * **Note:** This property overrides the value of the [PopupMenu.preferNativeMenu] property of the
   * child nodes.
   */
  public final inline var preferGlobalMenu: Boolean
    @JvmName("preferGlobalMenuProperty")
    get() = isPreferGlobalMenu()
    @JvmName("preferGlobalMenuProperty")
    set(`value`) {
      setPreferGlobalMenu(value)
    }

  /**
   * Base text writing direction.
   */
  public final inline var textDirection: Control.TextDirection
    @JvmName("textDirectionProperty")
    get() = getTextDirection()
    @JvmName("textDirectionProperty")
    set(`value`) {
      setTextDirection(value)
    }

  /**
   * Language code used for line-breaking and text shaping algorithms. If left empty, the current
   * locale is used instead.
   */
  public final inline var language: String
    @JvmName("languageProperty")
    get() = getLanguage()
    @JvmName("languageProperty")
    set(`value`) {
      setLanguage(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(371, scriptPtr)
  }

  public final fun setSwitchOnHover(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSwitchOnHoverPtr)
  }

  public final fun isSwitchOnHover(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSwitchOnHoverPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, shortcuts are disabled and cannot be used to trigger the button.
   */
  public final fun setDisableShortcuts(disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setDisableShortcutsPtr)
  }

  public final fun setPreferGlobalMenu(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setPreferGlobalMenuPtr)
  }

  public final fun isPreferGlobalMenu(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPreferGlobalMenuPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the current system's global menu is supported and used by this [MenuBar].
   */
  public final fun isNativeMenu(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isNativeMenuPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns number of menu items.
   */
  public final fun getMenuCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMenuCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setTextDirection(direction: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setTextDirectionPtr)
  }

  public final fun getTextDirection(): Control.TextDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextDirectionPtr)
    return Control.TextDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLanguage(language: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to language)
    TransferContext.callMethod(MethodBindings.setLanguagePtr)
  }

  public final fun getLanguage(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setFlat(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFlatPtr)
  }

  public final fun isFlat(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFlatPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setStartIndex(enabled: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to enabled.toLong())
    TransferContext.callMethod(MethodBindings.setStartIndexPtr)
  }

  public final fun getStartIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStartIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets menu item title.
   */
  public final fun setMenuTitle(menu: Int, title: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong(), STRING to title)
    TransferContext.callMethod(MethodBindings.setMenuTitlePtr)
  }

  /**
   * Returns menu item title.
   */
  public final fun getMenuTitle(menu: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong())
    TransferContext.callMethod(MethodBindings.getMenuTitlePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets menu item tooltip.
   */
  public final fun setMenuTooltip(menu: Int, tooltip: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong(), STRING to tooltip)
    TransferContext.callMethod(MethodBindings.setMenuTooltipPtr)
  }

  /**
   * Returns menu item tooltip.
   */
  public final fun getMenuTooltip(menu: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong())
    TransferContext.callMethod(MethodBindings.getMenuTooltipPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * If `true`, menu item is disabled.
   */
  public final fun setMenuDisabled(menu: Int, disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong(), BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setMenuDisabledPtr)
  }

  /**
   * Returns `true` if the menu item is disabled.
   */
  public final fun isMenuDisabled(menu: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong())
    TransferContext.callMethod(MethodBindings.isMenuDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, menu item is hidden.
   */
  public final fun setMenuHidden(menu: Int, hidden: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong(), BOOL to hidden)
    TransferContext.callMethod(MethodBindings.setMenuHiddenPtr)
  }

  /**
   * Returns `true` if the menu item is hidden.
   */
  public final fun isMenuHidden(menu: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong())
    TransferContext.callMethod(MethodBindings.isMenuHiddenPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns [PopupMenu] associated with menu item.
   */
  public final fun getMenuPopup(menu: Int): PopupMenu? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to menu.toLong())
    TransferContext.callMethod(MethodBindings.getMenuPopupPtr)
    return (TransferContext.readReturnValue(OBJECT) as PopupMenu?)
  }

  public companion object {
    @JvmField
    public val setSwitchOnHoverName: MethodStringName1<MenuBar, Unit, Boolean> =
        MethodStringName1<MenuBar, Unit, Boolean>("set_switch_on_hover")

    @JvmField
    public val isSwitchOnHoverName: MethodStringName0<MenuBar, Boolean> =
        MethodStringName0<MenuBar, Boolean>("is_switch_on_hover")

    @JvmField
    public val setDisableShortcutsName: MethodStringName1<MenuBar, Unit, Boolean> =
        MethodStringName1<MenuBar, Unit, Boolean>("set_disable_shortcuts")

    @JvmField
    public val setPreferGlobalMenuName: MethodStringName1<MenuBar, Unit, Boolean> =
        MethodStringName1<MenuBar, Unit, Boolean>("set_prefer_global_menu")

    @JvmField
    public val isPreferGlobalMenuName: MethodStringName0<MenuBar, Boolean> =
        MethodStringName0<MenuBar, Boolean>("is_prefer_global_menu")

    @JvmField
    public val isNativeMenuName: MethodStringName0<MenuBar, Boolean> =
        MethodStringName0<MenuBar, Boolean>("is_native_menu")

    @JvmField
    public val getMenuCountName: MethodStringName0<MenuBar, Int> =
        MethodStringName0<MenuBar, Int>("get_menu_count")

    @JvmField
    public val setTextDirectionName: MethodStringName1<MenuBar, Unit, Control.TextDirection> =
        MethodStringName1<MenuBar, Unit, Control.TextDirection>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<MenuBar, Control.TextDirection> =
        MethodStringName0<MenuBar, Control.TextDirection>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<MenuBar, Unit, String> =
        MethodStringName1<MenuBar, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<MenuBar, String> =
        MethodStringName0<MenuBar, String>("get_language")

    @JvmField
    public val setFlatName: MethodStringName1<MenuBar, Unit, Boolean> =
        MethodStringName1<MenuBar, Unit, Boolean>("set_flat")

    @JvmField
    public val isFlatName: MethodStringName0<MenuBar, Boolean> =
        MethodStringName0<MenuBar, Boolean>("is_flat")

    @JvmField
    public val setStartIndexName: MethodStringName1<MenuBar, Unit, Int> =
        MethodStringName1<MenuBar, Unit, Int>("set_start_index")

    @JvmField
    public val getStartIndexName: MethodStringName0<MenuBar, Int> =
        MethodStringName0<MenuBar, Int>("get_start_index")

    @JvmField
    public val setMenuTitleName: MethodStringName2<MenuBar, Unit, Int, String> =
        MethodStringName2<MenuBar, Unit, Int, String>("set_menu_title")

    @JvmField
    public val getMenuTitleName: MethodStringName1<MenuBar, String, Int> =
        MethodStringName1<MenuBar, String, Int>("get_menu_title")

    @JvmField
    public val setMenuTooltipName: MethodStringName2<MenuBar, Unit, Int, String> =
        MethodStringName2<MenuBar, Unit, Int, String>("set_menu_tooltip")

    @JvmField
    public val getMenuTooltipName: MethodStringName1<MenuBar, String, Int> =
        MethodStringName1<MenuBar, String, Int>("get_menu_tooltip")

    @JvmField
    public val setMenuDisabledName: MethodStringName2<MenuBar, Unit, Int, Boolean> =
        MethodStringName2<MenuBar, Unit, Int, Boolean>("set_menu_disabled")

    @JvmField
    public val isMenuDisabledName: MethodStringName1<MenuBar, Boolean, Int> =
        MethodStringName1<MenuBar, Boolean, Int>("is_menu_disabled")

    @JvmField
    public val setMenuHiddenName: MethodStringName2<MenuBar, Unit, Int, Boolean> =
        MethodStringName2<MenuBar, Unit, Int, Boolean>("set_menu_hidden")

    @JvmField
    public val isMenuHiddenName: MethodStringName1<MenuBar, Boolean, Int> =
        MethodStringName1<MenuBar, Boolean, Int>("is_menu_hidden")

    @JvmField
    public val getMenuPopupName: MethodStringName1<MenuBar, PopupMenu?, Int> =
        MethodStringName1<MenuBar, PopupMenu?, Int>("get_menu_popup")
  }

  public object MethodBindings {
    internal val setSwitchOnHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_switch_on_hover", 2586408642)

    internal val isSwitchOnHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "is_switch_on_hover", 2240911060)

    internal val setDisableShortcutsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_disable_shortcuts", 2586408642)

    internal val setPreferGlobalMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_prefer_global_menu", 2586408642)

    internal val isPreferGlobalMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "is_prefer_global_menu", 36873697)

    internal val isNativeMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "is_native_menu", 36873697)

    internal val getMenuCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "get_menu_count", 3905245786)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_text_direction", 119160795)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "get_text_direction", 797257663)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "get_language", 201670096)

    internal val setFlatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_flat", 2586408642)

    internal val isFlatPtr: VoidPtr = TypeManager.getMethodBindPtr("MenuBar", "is_flat", 36873697)

    internal val setStartIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_start_index", 1286410249)

    internal val getStartIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "get_start_index", 3905245786)

    internal val setMenuTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_menu_title", 501894301)

    internal val getMenuTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "get_menu_title", 844755477)

    internal val setMenuTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_menu_tooltip", 501894301)

    internal val getMenuTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "get_menu_tooltip", 844755477)

    internal val setMenuDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_menu_disabled", 300928843)

    internal val isMenuDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "is_menu_disabled", 1116898809)

    internal val setMenuHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "set_menu_hidden", 300928843)

    internal val isMenuHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "is_menu_hidden", 1116898809)

    internal val getMenuPopupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuBar", "get_menu_popup", 2100501353)
  }
}
