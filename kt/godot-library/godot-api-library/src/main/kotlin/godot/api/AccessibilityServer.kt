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
import godot.core.Callable
import godot.core.Color
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.core.RID
import godot.core.Rect2
import godot.core.Transform2D
import godot.readReturnValue_ANY
import godot.readReturnValue_BOOL
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_RECT2_RECT2
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_RID_ANY
import godot.writeMethodArguments_RID_BOOL
import godot.writeMethodArguments_RID_BOOL_BOOL_BOOL_COLOR
import godot.writeMethodArguments_RID_COLOR
import godot.writeMethodArguments_RID_DOUBLE
import godot.writeMethodArguments_RID_DOUBLE_DOUBLE
import godot.writeMethodArguments_RID_LONG
import godot.writeMethodArguments_RID_LONG_BOOL
import godot.writeMethodArguments_RID_LONG_CALLABLE
import godot.writeMethodArguments_RID_LONG_LONG
import godot.writeMethodArguments_RID_LONG_STRING
import godot.writeMethodArguments_RID_RECT2
import godot.writeMethodArguments_RID_RID
import godot.writeMethodArguments_RID_RID_DOUBLE_LONG_BOOL
import godot.writeMethodArguments_RID_RID_LONG_RID_LONG
import godot.writeMethodArguments_RID_STRING
import godot.writeMethodArguments_RID_TRANSFORM2D
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

@GodotBaseType
public object AccessibilityServer : Object() {
  @JvmField
  public val isSupportedName: MethodStringName0<AccessibilityServer, Boolean> =
      MethodStringName0<AccessibilityServer, Boolean>("is_supported")

  @JvmField
  public val createElementName: MethodStringName2<AccessibilityServer, RID, Int, AccessibilityRole>
      = MethodStringName2<AccessibilityServer, RID, Int, AccessibilityRole>("create_element")

  @JvmField
  public val createSubElementName:
      MethodStringName3<AccessibilityServer, RID, RID, AccessibilityRole, Int> =
      MethodStringName3<AccessibilityServer, RID, RID, AccessibilityRole, Int>("create_sub_element")

  @JvmField
  public val createSubTextEditElementsName:
      MethodStringName5<AccessibilityServer, RID, RID, RID, Float, Int, Boolean> =
      MethodStringName5<AccessibilityServer, RID, RID, RID, Float, Int, Boolean>("create_sub_text_edit_elements")

  @JvmField
  public val hasElementName: MethodStringName1<AccessibilityServer, Boolean, RID> =
      MethodStringName1<AccessibilityServer, Boolean, RID>("has_element")

  @JvmField
  public val freeElementName: MethodStringName1<AccessibilityServer, Unit, RID> =
      MethodStringName1<AccessibilityServer, Unit, RID>("free_element")

  @JvmField
  public val elementSetMetaName: MethodStringName2<AccessibilityServer, Unit, RID, Any?> =
      MethodStringName2<AccessibilityServer, Unit, RID, Any?>("element_set_meta")

  @JvmField
  public val elementGetMetaName: MethodStringName1<AccessibilityServer, Any?, RID> =
      MethodStringName1<AccessibilityServer, Any?, RID>("element_get_meta")

  @JvmField
  public val setWindowRectName: MethodStringName3<AccessibilityServer, Unit, Int, Rect2, Rect2> =
      MethodStringName3<AccessibilityServer, Unit, Int, Rect2, Rect2>("set_window_rect")

  @JvmField
  public val setWindowFocusedName: MethodStringName2<AccessibilityServer, Unit, Int, Boolean> =
      MethodStringName2<AccessibilityServer, Unit, Int, Boolean>("set_window_focused")

  @JvmField
  public val updateSetFocusName: MethodStringName1<AccessibilityServer, Unit, RID> =
      MethodStringName1<AccessibilityServer, Unit, RID>("update_set_focus")

  @JvmField
  public val getWindowRootName: MethodStringName1<AccessibilityServer, RID, Int> =
      MethodStringName1<AccessibilityServer, RID, Int>("get_window_root")

  @JvmField
  public val updateSetRoleName: MethodStringName2<AccessibilityServer, Unit, RID, AccessibilityRole>
      = MethodStringName2<AccessibilityServer, Unit, RID, AccessibilityRole>("update_set_role")

  @JvmField
  public val updateSetNameName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_name")

  @JvmField
  public val updateSetBrailleLabelName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_braille_label")

  @JvmField
  public val updateSetBrailleRoleDescriptionName:
      MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_braille_role_description")

  @JvmField
  public val updateSetExtraInfoName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_extra_info")

  @JvmField
  public val updateSetDescriptionName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_description")

  @JvmField
  public val updateSetValueName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_value")

  @JvmField
  public val updateSetTooltipName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_tooltip")

  @JvmField
  public val updateSetBoundsName: MethodStringName2<AccessibilityServer, Unit, RID, Rect2> =
      MethodStringName2<AccessibilityServer, Unit, RID, Rect2>("update_set_bounds")

  @JvmField
  public val updateSetTransformName: MethodStringName2<AccessibilityServer, Unit, RID, Transform2D>
      = MethodStringName2<AccessibilityServer, Unit, RID, Transform2D>("update_set_transform")

  @JvmField
  public val updateAddChildName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_add_child")

  @JvmField
  public val updateAddRelatedControlsName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_add_related_controls")

  @JvmField
  public val updateAddRelatedDetailsName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_add_related_details")

  @JvmField
  public val updateAddRelatedDescribedByName: MethodStringName2<AccessibilityServer, Unit, RID, RID>
      = MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_add_related_described_by")

  @JvmField
  public val updateAddRelatedFlowToName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_add_related_flow_to")

  @JvmField
  public val updateAddRelatedLabeledByName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_add_related_labeled_by")

  @JvmField
  public val updateAddRelatedRadioGroupName: MethodStringName2<AccessibilityServer, Unit, RID, RID>
      = MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_add_related_radio_group")

  @JvmField
  public val updateSetActiveDescendantName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_set_active_descendant")

  @JvmField
  public val updateSetNextOnLineName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_set_next_on_line")

  @JvmField
  public val updateSetPreviousOnLineName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_set_previous_on_line")

  @JvmField
  public val updateSetMemberOfName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_set_member_of")

  @JvmField
  public val updateSetInPageLinkTargetName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_set_in_page_link_target")

  @JvmField
  public val updateSetErrorMessageName: MethodStringName2<AccessibilityServer, Unit, RID, RID> =
      MethodStringName2<AccessibilityServer, Unit, RID, RID>("update_set_error_message")

  @JvmField
  public val updateSetLiveName:
      MethodStringName2<AccessibilityServer, Unit, RID, AccessibilityLiveMode> =
      MethodStringName2<AccessibilityServer, Unit, RID, AccessibilityLiveMode>("update_set_live")

  @JvmField
  public val updateAddActionName:
      MethodStringName3<AccessibilityServer, Unit, RID, AccessibilityAction, Callable> =
      MethodStringName3<AccessibilityServer, Unit, RID, AccessibilityAction, Callable>("update_add_action")

  @JvmField
  public val updateAddCustomActionName:
      MethodStringName3<AccessibilityServer, Unit, RID, Int, String> =
      MethodStringName3<AccessibilityServer, Unit, RID, Int, String>("update_add_custom_action")

  @JvmField
  public val updateSetTableRowCountName: MethodStringName2<AccessibilityServer, Unit, RID, Int> =
      MethodStringName2<AccessibilityServer, Unit, RID, Int>("update_set_table_row_count")

  @JvmField
  public val updateSetTableColumnCountName: MethodStringName2<AccessibilityServer, Unit, RID, Int> =
      MethodStringName2<AccessibilityServer, Unit, RID, Int>("update_set_table_column_count")

  @JvmField
  public val updateSetTableRowIndexName: MethodStringName2<AccessibilityServer, Unit, RID, Int> =
      MethodStringName2<AccessibilityServer, Unit, RID, Int>("update_set_table_row_index")

  @JvmField
  public val updateSetTableColumnIndexName: MethodStringName2<AccessibilityServer, Unit, RID, Int> =
      MethodStringName2<AccessibilityServer, Unit, RID, Int>("update_set_table_column_index")

  @JvmField
  public val updateSetTableCellPositionName:
      MethodStringName3<AccessibilityServer, Unit, RID, Int, Int> =
      MethodStringName3<AccessibilityServer, Unit, RID, Int, Int>("update_set_table_cell_position")

  @JvmField
  public val updateSetTableCellSpanName: MethodStringName3<AccessibilityServer, Unit, RID, Int, Int>
      = MethodStringName3<AccessibilityServer, Unit, RID, Int, Int>("update_set_table_cell_span")

  @JvmField
  public val updateSetListItemCountName: MethodStringName2<AccessibilityServer, Unit, RID, Int> =
      MethodStringName2<AccessibilityServer, Unit, RID, Int>("update_set_list_item_count")

  @JvmField
  public val updateSetListItemIndexName: MethodStringName2<AccessibilityServer, Unit, RID, Int> =
      MethodStringName2<AccessibilityServer, Unit, RID, Int>("update_set_list_item_index")

  @JvmField
  public val updateSetListItemLevelName: MethodStringName2<AccessibilityServer, Unit, RID, Int> =
      MethodStringName2<AccessibilityServer, Unit, RID, Int>("update_set_list_item_level")

  @JvmField
  public val updateSetListItemSelectedName:
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean> =
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean>("update_set_list_item_selected")

  @JvmField
  public val updateSetListItemExpandedName:
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean> =
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean>("update_set_list_item_expanded")

  @JvmField
  public val updateSetPopupTypeName:
      MethodStringName2<AccessibilityServer, Unit, RID, AccessibilityPopupType> =
      MethodStringName2<AccessibilityServer, Unit, RID, AccessibilityPopupType>("update_set_popup_type")

  @JvmField
  public val updateSetCheckedName: MethodStringName2<AccessibilityServer, Unit, RID, Boolean> =
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean>("update_set_checked")

  @JvmField
  public val updateSetNumValueName: MethodStringName2<AccessibilityServer, Unit, RID, Double> =
      MethodStringName2<AccessibilityServer, Unit, RID, Double>("update_set_num_value")

  @JvmField
  public val updateSetNumRangeName:
      MethodStringName3<AccessibilityServer, Unit, RID, Double, Double> =
      MethodStringName3<AccessibilityServer, Unit, RID, Double, Double>("update_set_num_range")

  @JvmField
  public val updateSetNumStepName: MethodStringName2<AccessibilityServer, Unit, RID, Double> =
      MethodStringName2<AccessibilityServer, Unit, RID, Double>("update_set_num_step")

  @JvmField
  public val updateSetNumJumpName: MethodStringName2<AccessibilityServer, Unit, RID, Double> =
      MethodStringName2<AccessibilityServer, Unit, RID, Double>("update_set_num_jump")

  @JvmField
  public val updateSetScrollXName: MethodStringName2<AccessibilityServer, Unit, RID, Double> =
      MethodStringName2<AccessibilityServer, Unit, RID, Double>("update_set_scroll_x")

  @JvmField
  public val updateSetScrollXRangeName:
      MethodStringName3<AccessibilityServer, Unit, RID, Double, Double> =
      MethodStringName3<AccessibilityServer, Unit, RID, Double, Double>("update_set_scroll_x_range")

  @JvmField
  public val updateSetScrollYName: MethodStringName2<AccessibilityServer, Unit, RID, Double> =
      MethodStringName2<AccessibilityServer, Unit, RID, Double>("update_set_scroll_y")

  @JvmField
  public val updateSetScrollYRangeName:
      MethodStringName3<AccessibilityServer, Unit, RID, Double, Double> =
      MethodStringName3<AccessibilityServer, Unit, RID, Double, Double>("update_set_scroll_y_range")

  @JvmField
  public val updateSetTextDecorationsName:
      MethodStringName5<AccessibilityServer, Unit, RID, Boolean, Boolean, Boolean, Color> =
      MethodStringName5<AccessibilityServer, Unit, RID, Boolean, Boolean, Boolean, Color>("update_set_text_decorations")

  @JvmField
  public val updateSetTextAlignName:
      MethodStringName2<AccessibilityServer, Unit, RID, HorizontalAlignment> =
      MethodStringName2<AccessibilityServer, Unit, RID, HorizontalAlignment>("update_set_text_align")

  @JvmField
  public val updateSetTextSelectionName:
      MethodStringName5<AccessibilityServer, Unit, RID, RID, Int, RID, Int> =
      MethodStringName5<AccessibilityServer, Unit, RID, RID, Int, RID, Int>("update_set_text_selection")

  @JvmField
  public val updateSetFlagName:
      MethodStringName3<AccessibilityServer, Unit, RID, AccessibilityFlags, Boolean> =
      MethodStringName3<AccessibilityServer, Unit, RID, AccessibilityFlags, Boolean>("update_set_flag")

  @JvmField
  public val updateSetClassnameName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_classname")

  @JvmField
  public val updateSetPlaceholderName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_placeholder")

  @JvmField
  public val updateSetLanguageName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_language")

  @JvmField
  public val updateSetTextOrientationName:
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean> =
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean>("update_set_text_orientation")

  @JvmField
  public val updateSetListOrientationName:
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean> =
      MethodStringName2<AccessibilityServer, Unit, RID, Boolean>("update_set_list_orientation")

  @JvmField
  public val updateSetShortcutName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_shortcut")

  @JvmField
  public val updateSetUrlName: MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_url")

  @JvmField
  public val updateSetRoleDescriptionName: MethodStringName2<AccessibilityServer, Unit, RID, String>
      = MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_role_description")

  @JvmField
  public val updateSetStateDescriptionName:
      MethodStringName2<AccessibilityServer, Unit, RID, String> =
      MethodStringName2<AccessibilityServer, Unit, RID, String>("update_set_state_description")

  @JvmField
  public val updateSetColorValueName: MethodStringName2<AccessibilityServer, Unit, RID, Color> =
      MethodStringName2<AccessibilityServer, Unit, RID, Color>("update_set_color_value")

  @JvmField
  public val updateSetBackgroundColorName: MethodStringName2<AccessibilityServer, Unit, RID, Color>
      = MethodStringName2<AccessibilityServer, Unit, RID, Color>("update_set_background_color")

  @JvmField
  public val updateSetForegroundColorName: MethodStringName2<AccessibilityServer, Unit, RID, Color>
      = MethodStringName2<AccessibilityServer, Unit, RID, Color>("update_set_foreground_color")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(0)
  }

  /**
   * Returns `true` if screen reader is support by this implementation.
   */
  @JvmStatic
  public final fun isSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Creates a new, empty accessibility element resource.
   *
   * **Note:** An accessibility element is created and freed automatically for each [Node]. In
   * general, this function should not be called manually.
   */
  @JvmStatic
  public final fun createElement(windowId: Int, role: AccessibilityRole): RID {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, windowId.toLong(), role.value)
    TransferContext.callMethod(MethodBindings.createElementPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Creates a new, empty accessibility sub-element resource. Sub-elements can be used to provide
   * accessibility information for objects which are not [Node]s, such as list items, table cells, or
   * menu items. Sub-elements are freed automatically when the parent element is freed, or can be freed
   * early using the [freeElement] method.
   */
  @JvmOverloads
  @JvmStatic
  public final fun createSubElement(
    parentRid: RID,
    role: AccessibilityRole,
    insertPos: Int = -1,
  ): RID {
    TransferContext.writeMethodArguments_RID_LONG_LONG(ptr, objectID.id, parentRid, role.value, insertPos.toLong())
    TransferContext.callMethod(MethodBindings.createSubElementPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Creates a new, empty accessibility sub-element from the shaped text buffer. Sub-elements are
   * freed automatically when the parent element is freed, or can be freed early using the
   * [freeElement] method.
   *
   * If [isLastLine] is `true`, no trailing newline is appended to the text content. Set to `true`
   * for the last line in multi-line text fields and for single-line text fields.
   */
  @JvmOverloads
  @JvmStatic
  public final fun createSubTextEditElements(
    parentRid: RID,
    shapedText: RID,
    minHeight: Float,
    insertPos: Int = -1,
    isLastLine: Boolean = false,
  ): RID {
    TransferContext.writeMethodArguments_RID_RID_DOUBLE_LONG_BOOL(ptr, objectID.id, parentRid, shapedText, minHeight.toDouble(), insertPos.toLong(), isLastLine)
    TransferContext.callMethod(MethodBindings.createSubTextEditElementsPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns `true` if [id] is a valid accessibility element.
   */
  @JvmStatic
  public final fun hasElement(id: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, id)
    TransferContext.callMethod(MethodBindings.hasElementPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Frees the accessibility element [id] created by [createElement], [createSubElement], or
   * [createSubTextEditElements].
   */
  @JvmStatic
  public final fun freeElement(id: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, id)
    TransferContext.callMethod(MethodBindings.freeElementPtr)
  }

  /**
   * Sets the metadata of the accessibility element [id] to [meta].
   */
  @JvmStatic
  public final fun elementSetMeta(id: RID, meta: Any?): Unit {
    TransferContext.writeMethodArguments_RID_ANY(ptr, objectID.id, id, meta)
    TransferContext.callMethod(MethodBindings.elementSetMetaPtr)
  }

  /**
   * Returns the metadata of the accessibility element [id].
   */
  @JvmStatic
  public final fun elementGetMeta(id: RID): Any? {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, id)
    TransferContext.callMethod(MethodBindings.elementGetMetaPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Sets window outer (with decorations) and inner (without decorations) bounds for assistive apps.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   *
   * **Note:** Advanced users only! [Window] objects call this method automatically.
   */
  @JvmStatic
  public final fun setWindowRect(
    windowId: Int,
    rectOut: Rect2,
    rectIn: Rect2,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_RECT2_RECT2(ptr, objectID.id, windowId.toLong(), rectOut, rectIn)
    TransferContext.callMethod(MethodBindings.setWindowRectPtr)
  }

  /**
   * Sets the window focused state for assistive apps.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   *
   * **Note:** Advanced users only! [Window] objects call this method automatically.
   */
  @JvmStatic
  public final fun setWindowFocused(windowId: Int, focused: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, windowId.toLong(), focused)
    TransferContext.callMethod(MethodBindings.setWindowFocusedPtr)
  }

  /**
   * Sets currently focused element.
   */
  @JvmStatic
  public final fun updateSetFocus(id: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, id)
    TransferContext.callMethod(MethodBindings.updateSetFocusPtr)
  }

  /**
   * Returns the main accessibility element of the OS native window.
   */
  @JvmStatic
  public final fun getWindowRoot(windowId: Int): RID {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, windowId.toLong())
    TransferContext.callMethod(MethodBindings.getWindowRootPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Sets element accessibility role.
   */
  @JvmStatic
  public final fun updateSetRole(id: RID, role: AccessibilityRole): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, role.value)
    TransferContext.callMethod(MethodBindings.updateSetRolePtr)
  }

  /**
   * Sets element accessibility name.
   */
  @JvmStatic
  public final fun updateSetName(id: RID, name: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, name)
    TransferContext.callMethod(MethodBindings.updateSetNamePtr)
  }

  /**
   * Sets element accessibility label for Braille display.
   */
  @JvmStatic
  public final fun updateSetBrailleLabel(id: RID, name: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, name)
    TransferContext.callMethod(MethodBindings.updateSetBrailleLabelPtr)
  }

  /**
   * Sets element accessibility role description for Braille display.
   */
  @JvmStatic
  public final fun updateSetBrailleRoleDescription(id: RID, description: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, description)
    TransferContext.callMethod(MethodBindings.updateSetBrailleRoleDescriptionPtr)
  }

  /**
   * Sets element accessibility extra information added to the element name.
   */
  @JvmStatic
  public final fun updateSetExtraInfo(id: RID, name: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, name)
    TransferContext.callMethod(MethodBindings.updateSetExtraInfoPtr)
  }

  /**
   * Sets element accessibility description.
   */
  @JvmStatic
  public final fun updateSetDescription(id: RID, description: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, description)
    TransferContext.callMethod(MethodBindings.updateSetDescriptionPtr)
  }

  /**
   * Sets element text value.
   */
  @JvmStatic
  public final fun updateSetValue(id: RID, `value`: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, value)
    TransferContext.callMethod(MethodBindings.updateSetValuePtr)
  }

  /**
   * Sets tooltip text.
   */
  @JvmStatic
  public final fun updateSetTooltip(id: RID, tooltip: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, tooltip)
    TransferContext.callMethod(MethodBindings.updateSetTooltipPtr)
  }

  /**
   * Sets element bounding box, relative to the node position.
   */
  @JvmStatic
  public final fun updateSetBounds(id: RID, rect: Rect2): Unit {
    TransferContext.writeMethodArguments_RID_RECT2(ptr, objectID.id, id, rect)
    TransferContext.callMethod(MethodBindings.updateSetBoundsPtr)
  }

  /**
   * Sets element 2D transform.
   */
  @JvmStatic
  public final fun updateSetTransform(id: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments_RID_TRANSFORM2D(ptr, objectID.id, id, transform)
    TransferContext.callMethod(MethodBindings.updateSetTransformPtr)
  }

  /**
   * Adds a child accessibility element.
   *
   * **Note:** [Node] children and sub-elements are added to the child list automatically.
   */
  @JvmStatic
  public final fun updateAddChild(id: RID, childId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, childId)
    TransferContext.callMethod(MethodBindings.updateAddChildPtr)
  }

  /**
   * Adds an element that is controlled by this element.
   */
  @JvmStatic
  public final fun updateAddRelatedControls(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, relatedId)
    TransferContext.callMethod(MethodBindings.updateAddRelatedControlsPtr)
  }

  /**
   * Adds an element that details this element.
   */
  @JvmStatic
  public final fun updateAddRelatedDetails(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, relatedId)
    TransferContext.callMethod(MethodBindings.updateAddRelatedDetailsPtr)
  }

  /**
   * Adds an element that describes this element.
   */
  @JvmStatic
  public final fun updateAddRelatedDescribedBy(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, relatedId)
    TransferContext.callMethod(MethodBindings.updateAddRelatedDescribedByPtr)
  }

  /**
   * Adds an element that this element flow into.
   */
  @JvmStatic
  public final fun updateAddRelatedFlowTo(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, relatedId)
    TransferContext.callMethod(MethodBindings.updateAddRelatedFlowToPtr)
  }

  /**
   * Adds an element that labels this element.
   */
  @JvmStatic
  public final fun updateAddRelatedLabeledBy(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, relatedId)
    TransferContext.callMethod(MethodBindings.updateAddRelatedLabeledByPtr)
  }

  /**
   * Adds an element that is part of the same radio group.
   *
   * **Note:** This method should be called on each element of the group, using all other elements
   * as [relatedId].
   */
  @JvmStatic
  public final fun updateAddRelatedRadioGroup(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, relatedId)
    TransferContext.callMethod(MethodBindings.updateAddRelatedRadioGroupPtr)
  }

  /**
   * Adds an element that is an active descendant of this element.
   */
  @JvmStatic
  public final fun updateSetActiveDescendant(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, otherId)
    TransferContext.callMethod(MethodBindings.updateSetActiveDescendantPtr)
  }

  /**
   * Sets next element on the line.
   */
  @JvmStatic
  public final fun updateSetNextOnLine(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, otherId)
    TransferContext.callMethod(MethodBindings.updateSetNextOnLinePtr)
  }

  /**
   * Sets previous element on the line.
   */
  @JvmStatic
  public final fun updateSetPreviousOnLine(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, otherId)
    TransferContext.callMethod(MethodBindings.updateSetPreviousOnLinePtr)
  }

  /**
   * Sets the element to be a member of the group.
   */
  @JvmStatic
  public final fun updateSetMemberOf(id: RID, groupId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, groupId)
    TransferContext.callMethod(MethodBindings.updateSetMemberOfPtr)
  }

  /**
   * Sets target element for the link.
   */
  @JvmStatic
  public final fun updateSetInPageLinkTarget(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, otherId)
    TransferContext.callMethod(MethodBindings.updateSetInPageLinkTargetPtr)
  }

  /**
   * Sets an element which contains an error message for this element.
   */
  @JvmStatic
  public final fun updateSetErrorMessage(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, id, otherId)
    TransferContext.callMethod(MethodBindings.updateSetErrorMessagePtr)
  }

  /**
   * Sets the priority of the live region updates.
   */
  @JvmStatic
  public final fun updateSetLive(id: RID, live: AccessibilityLiveMode): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, live.value)
    TransferContext.callMethod(MethodBindings.updateSetLivePtr)
  }

  /**
   * Adds a callback for the accessibility action (action which can be performed by using a special
   * screen reader command or buttons on the Braille display), and marks this action as supported. The
   * action callback receives one [Any] argument, which value depends on action type.
   */
  @JvmStatic
  public final fun updateAddAction(
    id: RID,
    action: AccessibilityAction,
    callable: Callable,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_CALLABLE(ptr, objectID.id, id, action.value, callable)
    TransferContext.callMethod(MethodBindings.updateAddActionPtr)
  }

  /**
   * Adds support for a custom accessibility action. [actionId] is passed as an argument to the
   * callback of [ACTION_CUSTOM] action.
   */
  @JvmStatic
  public final fun updateAddCustomAction(
    id: RID,
    actionId: Int,
    actionDescription: String,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_STRING(ptr, objectID.id, id, actionId.toLong(), actionDescription)
    TransferContext.callMethod(MethodBindings.updateAddCustomActionPtr)
  }

  /**
   * Sets number of rows in the table.
   */
  @JvmStatic
  public final fun updateSetTableRowCount(id: RID, count: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, count.toLong())
    TransferContext.callMethod(MethodBindings.updateSetTableRowCountPtr)
  }

  /**
   * Sets number of columns in the table.
   */
  @JvmStatic
  public final fun updateSetTableColumnCount(id: RID, count: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, count.toLong())
    TransferContext.callMethod(MethodBindings.updateSetTableColumnCountPtr)
  }

  /**
   * Sets position of the row in the table.
   */
  @JvmStatic
  public final fun updateSetTableRowIndex(id: RID, index: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, index.toLong())
    TransferContext.callMethod(MethodBindings.updateSetTableRowIndexPtr)
  }

  /**
   * Sets position of the column.
   */
  @JvmStatic
  public final fun updateSetTableColumnIndex(id: RID, index: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, index.toLong())
    TransferContext.callMethod(MethodBindings.updateSetTableColumnIndexPtr)
  }

  /**
   * Sets cell position in the table.
   */
  @JvmStatic
  public final fun updateSetTableCellPosition(
    id: RID,
    rowIndex: Int,
    columnIndex: Int,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_LONG(ptr, objectID.id, id, rowIndex.toLong(), columnIndex.toLong())
    TransferContext.callMethod(MethodBindings.updateSetTableCellPositionPtr)
  }

  /**
   * Sets cell row/column span.
   */
  @JvmStatic
  public final fun updateSetTableCellSpan(
    id: RID,
    rowSpan: Int,
    columnSpan: Int,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_LONG(ptr, objectID.id, id, rowSpan.toLong(), columnSpan.toLong())
    TransferContext.callMethod(MethodBindings.updateSetTableCellSpanPtr)
  }

  /**
   * Sets number of items in the list.
   */
  @JvmStatic
  public final fun updateSetListItemCount(id: RID, size: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, size.toLong())
    TransferContext.callMethod(MethodBindings.updateSetListItemCountPtr)
  }

  /**
   * Sets the position of the element in the list.
   */
  @JvmStatic
  public final fun updateSetListItemIndex(id: RID, index: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, index.toLong())
    TransferContext.callMethod(MethodBindings.updateSetListItemIndexPtr)
  }

  /**
   * Sets the hierarchical level of the element in the list.
   */
  @JvmStatic
  public final fun updateSetListItemLevel(id: RID, level: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, level.toLong())
    TransferContext.callMethod(MethodBindings.updateSetListItemLevelPtr)
  }

  /**
   * Sets list/tree item selected status.
   */
  @JvmStatic
  public final fun updateSetListItemSelected(id: RID, selected: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, id, selected)
    TransferContext.callMethod(MethodBindings.updateSetListItemSelectedPtr)
  }

  /**
   * Sets list/tree item expanded status.
   */
  @JvmStatic
  public final fun updateSetListItemExpanded(id: RID, expanded: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, id, expanded)
    TransferContext.callMethod(MethodBindings.updateSetListItemExpandedPtr)
  }

  /**
   * Sets popup type for popup buttons.
   */
  @JvmStatic
  public final fun updateSetPopupType(id: RID, popup: AccessibilityPopupType): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, popup.value)
    TransferContext.callMethod(MethodBindings.updateSetPopupTypePtr)
  }

  /**
   * Sets element checked state.
   */
  @JvmStatic
  public final fun updateSetChecked(id: RID, checekd: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, id, checekd)
    TransferContext.callMethod(MethodBindings.updateSetCheckedPtr)
  }

  /**
   * Sets numeric value.
   */
  @JvmStatic
  public final fun updateSetNumValue(id: RID, position: Double): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, id, position)
    TransferContext.callMethod(MethodBindings.updateSetNumValuePtr)
  }

  /**
   * Sets numeric value range.
   */
  @JvmStatic
  public final fun updateSetNumRange(
    id: RID,
    min: Double,
    max: Double,
  ): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE_DOUBLE(ptr, objectID.id, id, min, max)
    TransferContext.callMethod(MethodBindings.updateSetNumRangePtr)
  }

  /**
   * Sets numeric value step.
   */
  @JvmStatic
  public final fun updateSetNumStep(id: RID, step: Double): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, id, step)
    TransferContext.callMethod(MethodBindings.updateSetNumStepPtr)
  }

  /**
   * Sets numeric value jump.
   */
  @JvmStatic
  public final fun updateSetNumJump(id: RID, jump: Double): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, id, jump)
    TransferContext.callMethod(MethodBindings.updateSetNumJumpPtr)
  }

  /**
   * Sets scroll bar x position.
   */
  @JvmStatic
  public final fun updateSetScrollX(id: RID, position: Double): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, id, position)
    TransferContext.callMethod(MethodBindings.updateSetScrollXPtr)
  }

  /**
   * Sets scroll bar x range.
   */
  @JvmStatic
  public final fun updateSetScrollXRange(
    id: RID,
    min: Double,
    max: Double,
  ): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE_DOUBLE(ptr, objectID.id, id, min, max)
    TransferContext.callMethod(MethodBindings.updateSetScrollXRangePtr)
  }

  /**
   * Sets scroll bar y position.
   */
  @JvmStatic
  public final fun updateSetScrollY(id: RID, position: Double): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, id, position)
    TransferContext.callMethod(MethodBindings.updateSetScrollYPtr)
  }

  /**
   * Sets scroll bar y range.
   */
  @JvmStatic
  public final fun updateSetScrollYRange(
    id: RID,
    min: Double,
    max: Double,
  ): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE_DOUBLE(ptr, objectID.id, id, min, max)
    TransferContext.callMethod(MethodBindings.updateSetScrollYRangePtr)
  }

  /**
   * Sets text underline/overline/strikethrough.
   */
  @JvmOverloads
  @JvmStatic
  public final fun updateSetTextDecorations(
    id: RID,
    underline: Boolean,
    strikethrough: Boolean,
    overline: Boolean,
    color: Color = Color(Color(0, 0, 0, 1)),
  ): Unit {
    TransferContext.writeMethodArguments_RID_BOOL_BOOL_BOOL_COLOR(ptr, objectID.id, id, underline, strikethrough, overline, color)
    TransferContext.callMethod(MethodBindings.updateSetTextDecorationsPtr)
  }

  /**
   * Sets element text alignment.
   */
  @JvmStatic
  public final fun updateSetTextAlign(id: RID, align: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, id, align.value)
    TransferContext.callMethod(MethodBindings.updateSetTextAlignPtr)
  }

  /**
   * Sets text selection to the text field. [textStartId] and [textEndId] should be elements created
   * by [createSubTextEditElements]. Character offsets are relative to the corresponding element.
   */
  @JvmStatic
  public final fun updateSetTextSelection(
    id: RID,
    textStartId: RID,
    startChar: Int,
    textEndId: RID,
    endChar: Int,
  ): Unit {
    TransferContext.writeMethodArguments_RID_RID_LONG_RID_LONG(ptr, objectID.id, id, textStartId, startChar.toLong(), textEndId, endChar.toLong())
    TransferContext.callMethod(MethodBindings.updateSetTextSelectionPtr)
  }

  /**
   * Sets element flag.
   */
  @JvmStatic
  public final fun updateSetFlag(
    id: RID,
    flag: AccessibilityFlags,
    `value`: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_BOOL(ptr, objectID.id, id, flag.value, value)
    TransferContext.callMethod(MethodBindings.updateSetFlagPtr)
  }

  /**
   * Sets element class name.
   */
  @JvmStatic
  public final fun updateSetClassname(id: RID, classname: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, classname)
    TransferContext.callMethod(MethodBindings.updateSetClassnamePtr)
  }

  /**
   * Sets placeholder text.
   */
  @JvmStatic
  public final fun updateSetPlaceholder(id: RID, placeholder: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, placeholder)
    TransferContext.callMethod(MethodBindings.updateSetPlaceholderPtr)
  }

  /**
   * Sets element text language.
   */
  @JvmStatic
  public final fun updateSetLanguage(id: RID, language: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, language)
    TransferContext.callMethod(MethodBindings.updateSetLanguagePtr)
  }

  /**
   * Sets text orientation.
   */
  @JvmStatic
  public final fun updateSetTextOrientation(id: RID, vertical: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, id, vertical)
    TransferContext.callMethod(MethodBindings.updateSetTextOrientationPtr)
  }

  /**
   * Sets the orientation of the list elements.
   */
  @JvmStatic
  public final fun updateSetListOrientation(id: RID, vertical: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, id, vertical)
    TransferContext.callMethod(MethodBindings.updateSetListOrientationPtr)
  }

  /**
   * Sets the list of keyboard shortcuts used by element.
   */
  @JvmStatic
  public final fun updateSetShortcut(id: RID, shortcut: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, shortcut)
    TransferContext.callMethod(MethodBindings.updateSetShortcutPtr)
  }

  /**
   * Sets link URL.
   */
  @JvmStatic
  public final fun updateSetUrl(id: RID, url: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, url)
    TransferContext.callMethod(MethodBindings.updateSetUrlPtr)
  }

  /**
   * Sets element accessibility role description text.
   */
  @JvmStatic
  public final fun updateSetRoleDescription(id: RID, description: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, description)
    TransferContext.callMethod(MethodBindings.updateSetRoleDescriptionPtr)
  }

  /**
   * Sets human-readable description of the current checked state.
   */
  @JvmStatic
  public final fun updateSetStateDescription(id: RID, description: String): Unit {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, id, description)
    TransferContext.callMethod(MethodBindings.updateSetStateDescriptionPtr)
  }

  /**
   * Sets element color value.
   */
  @JvmStatic
  public final fun updateSetColorValue(id: RID, color: Color): Unit {
    TransferContext.writeMethodArguments_RID_COLOR(ptr, objectID.id, id, color)
    TransferContext.callMethod(MethodBindings.updateSetColorValuePtr)
  }

  /**
   * Sets element background color.
   */
  @JvmStatic
  public final fun updateSetBackgroundColor(id: RID, color: Color): Unit {
    TransferContext.writeMethodArguments_RID_COLOR(ptr, objectID.id, id, color)
    TransferContext.callMethod(MethodBindings.updateSetBackgroundColorPtr)
  }

  /**
   * Sets element foreground color.
   */
  @JvmStatic
  public final fun updateSetForegroundColor(id: RID, color: Color): Unit {
    TransferContext.writeMethodArguments_RID_COLOR(ptr, objectID.id, id, color)
    TransferContext.callMethod(MethodBindings.updateSetForegroundColorPtr)
  }

  public enum class AccessibilityRole(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Unknown or custom role.
     */
    ROLE_UNKNOWN(0),
    /**
     * Default dialog button element.
     */
    ROLE_DEFAULT_BUTTON(1),
    /**
     * Audio player element.
     */
    ROLE_AUDIO(2),
    /**
     * Video player element.
     */
    ROLE_VIDEO(3),
    /**
     * Non-editable text label.
     */
    ROLE_STATIC_TEXT(4),
    /**
     * Container element. Elements with this role are used for internal structure and ignored by
     * screen readers.
     */
    ROLE_CONTAINER(5),
    /**
     * Panel container element.
     */
    ROLE_PANEL(6),
    /**
     * Button element.
     */
    ROLE_BUTTON(7),
    /**
     * Link element.
     */
    ROLE_LINK(8),
    /**
     * Check box element.
     */
    ROLE_CHECK_BOX(9),
    /**
     * Radio button element.
     */
    ROLE_RADIO_BUTTON(10),
    /**
     * Check button element.
     */
    ROLE_CHECK_BUTTON(11),
    /**
     * Scroll bar element.
     */
    ROLE_SCROLL_BAR(12),
    /**
     * Scroll container element.
     */
    ROLE_SCROLL_VIEW(13),
    /**
     * Container splitter handle element.
     */
    ROLE_SPLITTER(14),
    /**
     * Slider element.
     */
    ROLE_SLIDER(15),
    /**
     * Spin box element.
     */
    ROLE_SPIN_BUTTON(16),
    /**
     * Progress indicator element.
     */
    ROLE_PROGRESS_INDICATOR(17),
    /**
     * Editable text field element.
     */
    ROLE_TEXT_FIELD(18),
    /**
     * Multiline editable text field element.
     */
    ROLE_MULTILINE_TEXT_FIELD(19),
    /**
     * Color picker element.
     */
    ROLE_COLOR_PICKER(20),
    /**
     * Table element.
     */
    ROLE_TABLE(21),
    /**
     * Table/tree cell element.
     */
    ROLE_CELL(22),
    /**
     * Table/tree row element.
     */
    ROLE_ROW(23),
    /**
     * Table/tree row group element.
     */
    ROLE_ROW_GROUP(24),
    /**
     * Table/tree row header element.
     */
    ROLE_ROW_HEADER(25),
    /**
     * Table/tree column header element.
     */
    ROLE_COLUMN_HEADER(26),
    /**
     * Tree view element.
     */
    ROLE_TREE(27),
    /**
     * Tree view item element.
     */
    ROLE_TREE_ITEM(28),
    /**
     * List element.
     */
    ROLE_LIST(29),
    /**
     * List item element.
     */
    ROLE_LIST_ITEM(30),
    /**
     * List view element.
     */
    ROLE_LIST_BOX(31),
    /**
     * List view item element.
     */
    ROLE_LIST_BOX_OPTION(32),
    /**
     * Tab bar element.
     */
    ROLE_TAB_BAR(33),
    /**
     * Tab bar item element.
     */
    ROLE_TAB(34),
    /**
     * Tab panel element.
     */
    ROLE_TAB_PANEL(35),
    /**
     * Menu bar element.
     */
    ROLE_MENU_BAR(36),
    /**
     * Popup menu element.
     */
    ROLE_MENU(37),
    /**
     * Popup menu item element.
     */
    ROLE_MENU_ITEM(38),
    /**
     * Popup menu check button item element.
     */
    ROLE_MENU_ITEM_CHECK_BOX(39),
    /**
     * Popup menu radio button item element.
     */
    ROLE_MENU_ITEM_RADIO(40),
    /**
     * Image element.
     */
    ROLE_IMAGE(41),
    /**
     * Window element.
     */
    ROLE_WINDOW(42),
    /**
     * Embedded window title bar element.
     */
    ROLE_TITLE_BAR(43),
    /**
     * Dialog window element.
     */
    ROLE_DIALOG(44),
    /**
     * Tooltip element.
     */
    ROLE_TOOLTIP(45),
    /**
     * Region/landmark element. Screen readers can navigate between regions using landmark
     * navigation.
     */
    ROLE_REGION(46),
    /**
     * Unifor text run.
     *
     * Note: This role is used for internal text elements, and should not be assigned to nodes.
     */
    ROLE_TEXT_RUN(47),
    ;

    public companion object {
      public fun from(`value`: Long): AccessibilityRole = entries.single { it.`value` == `value` }
    }
  }

  public enum class AccessibilityPopupType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Popup menu.
     */
    POPUP_MENU(0),
    /**
     * Popup list.
     */
    POPUP_LIST(1),
    /**
     * Popup tree view.
     */
    POPUP_TREE(2),
    /**
     * Popup dialog.
     */
    POPUP_DIALOG(3),
    ;

    public companion object {
      public fun from(`value`: Long): AccessibilityPopupType =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class AccessibilityFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Element is hidden for accessibility tools.
     */
    FLAG_HIDDEN(0),
    /**
     * Element supports multiple item selection.
     */
    FLAG_MULTISELECTABLE(1),
    /**
     * Element require user input.
     */
    FLAG_REQUIRED(2),
    /**
     * Element is a visited link.
     */
    FLAG_VISITED(3),
    /**
     * Element content is not ready (e.g. loading).
     */
    FLAG_BUSY(4),
    /**
     * Element is modal window.
     */
    FLAG_MODAL(5),
    /**
     * Element allows touches to be passed through when a screen reader is in touch exploration
     * mode.
     */
    FLAG_TOUCH_PASSTHROUGH(6),
    /**
     * Element is text field with selectable but read-only text.
     */
    FLAG_READONLY(7),
    /**
     * Element is disabled.
     */
    FLAG_DISABLED(8),
    /**
     * Element clips children.
     */
    FLAG_CLIPS_CHILDREN(9),
    ;

    public companion object {
      public fun from(`value`: Long): AccessibilityFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class AccessibilityAction(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Single click action, callback argument is not set.
     */
    ACTION_CLICK(0),
    /**
     * Focus action, callback argument is not set.
     */
    ACTION_FOCUS(1),
    /**
     * Blur action, callback argument is not set.
     */
    ACTION_BLUR(2),
    /**
     * Collapse action, callback argument is not set.
     */
    ACTION_COLLAPSE(3),
    /**
     * Expand action, callback argument is not set.
     */
    ACTION_EXPAND(4),
    /**
     * Decrement action, callback argument is not set.
     */
    ACTION_DECREMENT(5),
    /**
     * Increment action, callback argument is not set.
     */
    ACTION_INCREMENT(6),
    /**
     * Hide tooltip action, callback argument is not set.
     */
    ACTION_HIDE_TOOLTIP(7),
    /**
     * Show tooltip action, callback argument is not set.
     */
    ACTION_SHOW_TOOLTIP(8),
    /**
     * Set text selection action, callback argument is set to [Dictionary] with the following keys:
     *
     * - `"start_element"` accessibility element of the selection start.
     *
     * - `"start_char"` character offset relative to the accessibility element of the selection
     * start.
     *
     * - `"end_element"` accessibility element of the selection end.
     *
     * - `"end_char"` character offset relative to the accessibility element of the selection end.
     */
    ACTION_SET_TEXT_SELECTION(9),
    /**
     * Replace text action, callback argument is set to [String] with the replacement text.
     */
    ACTION_REPLACE_SELECTED_TEXT(10),
    /**
     * Scroll backward action, callback argument is not set.
     */
    ACTION_SCROLL_BACKWARD(11),
    /**
     * Scroll down action, callback argument is set to [AccessibilityScrollUnit].
     */
    ACTION_SCROLL_DOWN(12),
    /**
     * Scroll forward action, callback argument is not set.
     */
    ACTION_SCROLL_FORWARD(13),
    /**
     * Scroll left action, callback argument is set to [AccessibilityScrollUnit].
     */
    ACTION_SCROLL_LEFT(14),
    /**
     * Scroll right action, callback argument is set to [AccessibilityScrollUnit].
     */
    ACTION_SCROLL_RIGHT(15),
    /**
     * Scroll up action, callback argument is set to [AccessibilityScrollUnit].
     */
    ACTION_SCROLL_UP(16),
    /**
     * Scroll into view action, callback argument is set to [AccessibilityScrollHint].
     */
    ACTION_SCROLL_INTO_VIEW(17),
    /**
     * Scroll to point action, callback argument is set to [Vector2] with the relative point
     * coordinates.
     */
    ACTION_SCROLL_TO_POINT(18),
    /**
     * Set scroll offset action, callback argument is set to [Vector2] with the scroll offset.
     */
    ACTION_SET_SCROLL_OFFSET(19),
    /**
     * Set value action, callback argument is set to [String] or number with the new value.
     */
    ACTION_SET_VALUE(20),
    /**
     * Show context menu action, callback argument is not set.
     */
    ACTION_SHOW_CONTEXT_MENU(21),
    /**
     * Custom action, callback argument is set to the integer action ID.
     */
    ACTION_CUSTOM(22),
    ;

    public companion object {
      public fun from(`value`: Long): AccessibilityAction = entries.single { it.`value` == `value` }
    }
  }

  public enum class AccessibilityLiveMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Indicates that updates to the live region should not be presented.
     */
    LIVE_OFF(0),
    /**
     * Indicates that updates to the live region should be presented at the next opportunity (for
     * example at the end of speaking the current sentence).
     */
    LIVE_POLITE(1),
    /**
     * Indicates that updates to the live region have the highest priority and should be presented
     * immediately.
     */
    LIVE_ASSERTIVE(2),
    ;

    public companion object {
      public fun from(`value`: Long): AccessibilityLiveMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class AccessibilityScrollUnit(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The amount by which to scroll. A single item of a list, line of text.
     */
    SCROLL_UNIT_ITEM(0),
    /**
     * The amount by which to scroll. A single page.
     */
    SCROLL_UNIT_PAGE(1),
    ;

    public companion object {
      public fun from(`value`: Long): AccessibilityScrollUnit =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class AccessibilityScrollHint(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A preferred position for the node scrolled into view. Top-left edge of the scroll container.
     */
    SCROLL_HINT_TOP_LEFT(0),
    /**
     * A preferred position for the node scrolled into view. Bottom-right edge of the scroll
     * container.
     */
    SCROLL_HINT_BOTTOM_RIGHT(1),
    /**
     * A preferred position for the node scrolled into view. Top edge of the scroll container.
     */
    SCROLL_HINT_TOP_EDGE(2),
    /**
     * A preferred position for the node scrolled into view. Bottom edge of the scroll container.
     */
    SCROLL_HINT_BOTTOM_EDGE(3),
    /**
     * A preferred position for the node scrolled into view. Left edge of the scroll container.
     */
    SCROLL_HINT_LEFT_EDGE(4),
    /**
     * A preferred position for the node scrolled into view. Right edge of the scroll container.
     */
    SCROLL_HINT_RIGHT_EDGE(5),
    ;

    public companion object {
      public fun from(`value`: Long): AccessibilityScrollHint =
          entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val isSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "is_supported", 36873697)

    internal val createElementPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "create_element", 3846965249)

    internal val createSubElementPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "create_sub_element", 1151690429)

    internal val createSubTextEditElementsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "create_sub_text_edit_elements", 2702009895)

    internal val hasElementPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "has_element", 4155700596)

    internal val freeElementPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "free_element", 2722037293)

    internal val elementSetMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "element_set_meta", 3175752987)

    internal val elementGetMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "element_get_meta", 4171304767)

    internal val setWindowRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "set_window_rect", 2386961724)

    internal val setWindowFocusedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "set_window_focused", 300928843)

    internal val updateSetFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_focus", 2722037293)

    internal val getWindowRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "get_window_root", 495598643)

    internal val updateSetRolePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_role", 3747886520)

    internal val updateSetNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_name", 2726140452)

    internal val updateSetBrailleLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_braille_label", 2726140452)

    internal val updateSetBrailleRoleDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_braille_role_description", 2726140452)

    internal val updateSetExtraInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_extra_info", 2726140452)

    internal val updateSetDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_description", 2726140452)

    internal val updateSetValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_value", 2726140452)

    internal val updateSetTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_tooltip", 2726140452)

    internal val updateSetBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_bounds", 1378122625)

    internal val updateSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_transform", 1246044741)

    internal val updateAddChildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_child", 395945892)

    internal val updateAddRelatedControlsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_related_controls", 395945892)

    internal val updateAddRelatedDetailsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_related_details", 395945892)

    internal val updateAddRelatedDescribedByPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_related_described_by", 395945892)

    internal val updateAddRelatedFlowToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_related_flow_to", 395945892)

    internal val updateAddRelatedLabeledByPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_related_labeled_by", 395945892)

    internal val updateAddRelatedRadioGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_related_radio_group", 395945892)

    internal val updateSetActiveDescendantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_active_descendant", 395945892)

    internal val updateSetNextOnLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_next_on_line", 395945892)

    internal val updateSetPreviousOnLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_previous_on_line", 395945892)

    internal val updateSetMemberOfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_member_of", 395945892)

    internal val updateSetInPageLinkTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_in_page_link_target", 395945892)

    internal val updateSetErrorMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_error_message", 395945892)

    internal val updateSetLivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_live", 2993365237)

    internal val updateAddActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_action", 3960092835)

    internal val updateAddCustomActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_add_custom_action", 4153150897)

    internal val updateSetTableRowCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_table_row_count", 3411492887)

    internal val updateSetTableColumnCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_table_column_count", 3411492887)

    internal val updateSetTableRowIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_table_row_index", 3411492887)

    internal val updateSetTableColumnIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_table_column_index", 3411492887)

    internal val updateSetTableCellPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_table_cell_position", 4288446313)

    internal val updateSetTableCellSpanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_table_cell_span", 4288446313)

    internal val updateSetListItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_list_item_count", 3411492887)

    internal val updateSetListItemIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_list_item_index", 3411492887)

    internal val updateSetListItemLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_list_item_level", 3411492887)

    internal val updateSetListItemSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_list_item_selected", 1265174801)

    internal val updateSetListItemExpandedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_list_item_expanded", 1265174801)

    internal val updateSetPopupTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_popup_type", 690307634)

    internal val updateSetCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_checked", 1265174801)

    internal val updateSetNumValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_num_value", 1794382983)

    internal val updateSetNumRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_num_range", 2513314492)

    internal val updateSetNumStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_num_step", 1794382983)

    internal val updateSetNumJumpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_num_jump", 1794382983)

    internal val updateSetScrollXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_scroll_x", 1794382983)

    internal val updateSetScrollXRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_scroll_x_range", 2513314492)

    internal val updateSetScrollYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_scroll_y", 1794382983)

    internal val updateSetScrollYRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_scroll_y_range", 2513314492)

    internal val updateSetTextDecorationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_text_decorations", 457503484)

    internal val updateSetTextAlignPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_text_align", 3725995085)

    internal val updateSetTextSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_text_selection", 3119144029)

    internal val updateSetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_flag", 1473043386)

    internal val updateSetClassnamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_classname", 2726140452)

    internal val updateSetPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_placeholder", 2726140452)

    internal val updateSetLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_language", 2726140452)

    internal val updateSetTextOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_text_orientation", 1265174801)

    internal val updateSetListOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_list_orientation", 1265174801)

    internal val updateSetShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_shortcut", 2726140452)

    internal val updateSetUrlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_url", 2726140452)

    internal val updateSetRoleDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_role_description", 2726140452)

    internal val updateSetStateDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_state_description", 2726140452)

    internal val updateSetColorValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_color_value", 2948539648)

    internal val updateSetBackgroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_background_color", 2948539648)

    internal val updateSetForegroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AccessibilityServer", "update_set_foreground_color", 2948539648)
  }
}
