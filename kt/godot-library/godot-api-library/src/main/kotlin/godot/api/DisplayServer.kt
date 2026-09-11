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
import godot.core.Dictionary
import godot.core.Error
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.Key
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName10
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.MethodStringName8
import godot.core.MethodStringName9
import godot.core.MouseButtonMask
import godot.core.PackedInt32Array
import godot.core.PackedStringArray
import godot.core.PackedVector2Array
import godot.core.RID
import godot.core.Rect2
import godot.core.Rect2i
import godot.core.Signal1
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.VariantCallable
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.RECT2I
import godot.core.VariantParser.STRING
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantParser.VECTOR3I
import godot.core.VariantParser._RID
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3i
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

/**
 * [DisplayServer] handles everything related to window management. It is separated from [OS] as a
 * single operating system may support multiple display servers.
 *
 * **Headless mode:** Starting the engine with the `--headless`
 * [url=$DOCS_URL/tutorials/editor/command_line_tutorial.html]command line argument[/url] disables all
 * rendering and window management functions. Most functions from [DisplayServer] will return dummy
 * values in this case.
 */
@GodotBaseType
public object DisplayServer : Object() {
  @JvmField
  public val hasFeatureName: MethodStringName1<DisplayServer, Boolean, Feature> =
      MethodStringName1<DisplayServer, Boolean, Feature>("has_feature")

  @JvmField
  public val getNameName: MethodStringName0<DisplayServer, String> =
      MethodStringName0<DisplayServer, String>("get_name")

  @JvmField
  public val helpSetSearchCallbacksName: MethodStringName2<DisplayServer, Unit, Callable, Callable>
      = MethodStringName2<DisplayServer, Unit, Callable, Callable>("help_set_search_callbacks")

  @JvmField
  public val globalMenuSetPopupCallbacksName:
      MethodStringName3<DisplayServer, Unit, String, Callable, Callable> =
      MethodStringName3<DisplayServer, Unit, String, Callable, Callable>("global_menu_set_popup_callbacks")

  @JvmField
  public val globalMenuAddSubmenuItemName:
      MethodStringName4<DisplayServer, Int, String, String, String, Int> =
      MethodStringName4<DisplayServer, Int, String, String, String, Int>("global_menu_add_submenu_item")

  @JvmField
  public val globalMenuAddItemName:
      MethodStringName7<DisplayServer, Int, String, String, Callable, Callable, Any?, Key, Int> =
      MethodStringName7<DisplayServer, Int, String, String, Callable, Callable, Any?, Key, Int>("global_menu_add_item")

  @JvmField
  public val globalMenuAddCheckItemName:
      MethodStringName7<DisplayServer, Int, String, String, Callable, Callable, Any?, Key, Int> =
      MethodStringName7<DisplayServer, Int, String, String, Callable, Callable, Any?, Key, Int>("global_menu_add_check_item")

  @JvmField
  public val globalMenuAddIconItemName:
      MethodStringName8<DisplayServer, Int, String, Texture2D?, String, Callable, Callable, Any?, Key, Int>
      =
      MethodStringName8<DisplayServer, Int, String, Texture2D?, String, Callable, Callable, Any?, Key, Int>("global_menu_add_icon_item")

  @JvmField
  public val globalMenuAddIconCheckItemName:
      MethodStringName8<DisplayServer, Int, String, Texture2D?, String, Callable, Callable, Any?, Key, Int>
      =
      MethodStringName8<DisplayServer, Int, String, Texture2D?, String, Callable, Callable, Any?, Key, Int>("global_menu_add_icon_check_item")

  @JvmField
  public val globalMenuAddRadioCheckItemName:
      MethodStringName7<DisplayServer, Int, String, String, Callable, Callable, Any?, Key, Int> =
      MethodStringName7<DisplayServer, Int, String, String, Callable, Callable, Any?, Key, Int>("global_menu_add_radio_check_item")

  @JvmField
  public val globalMenuAddIconRadioCheckItemName:
      MethodStringName8<DisplayServer, Int, String, Texture2D?, String, Callable, Callable, Any?, Key, Int>
      =
      MethodStringName8<DisplayServer, Int, String, Texture2D?, String, Callable, Callable, Any?, Key, Int>("global_menu_add_icon_radio_check_item")

  @JvmField
  public val globalMenuAddMultistateItemName:
      MethodStringName9<DisplayServer, Int, String, String, Int, Int, Callable, Callable, Any?, Key, Int>
      =
      MethodStringName9<DisplayServer, Int, String, String, Int, Int, Callable, Callable, Any?, Key, Int>("global_menu_add_multistate_item")

  @JvmField
  public val globalMenuAddSeparatorName: MethodStringName2<DisplayServer, Int, String, Int> =
      MethodStringName2<DisplayServer, Int, String, Int>("global_menu_add_separator")

  @JvmField
  public val globalMenuGetItemIndexFromTextName:
      MethodStringName2<DisplayServer, Int, String, String> =
      MethodStringName2<DisplayServer, Int, String, String>("global_menu_get_item_index_from_text")

  @JvmField
  public val globalMenuGetItemIndexFromTagName: MethodStringName2<DisplayServer, Int, String, Any?>
      = MethodStringName2<DisplayServer, Int, String, Any?>("global_menu_get_item_index_from_tag")

  @JvmField
  public val globalMenuIsItemCheckedName: MethodStringName2<DisplayServer, Boolean, String, Int> =
      MethodStringName2<DisplayServer, Boolean, String, Int>("global_menu_is_item_checked")

  @JvmField
  public val globalMenuIsItemCheckableName: MethodStringName2<DisplayServer, Boolean, String, Int> =
      MethodStringName2<DisplayServer, Boolean, String, Int>("global_menu_is_item_checkable")

  @JvmField
  public val globalMenuIsItemRadioCheckableName:
      MethodStringName2<DisplayServer, Boolean, String, Int> =
      MethodStringName2<DisplayServer, Boolean, String, Int>("global_menu_is_item_radio_checkable")

  @JvmField
  public val globalMenuGetItemCallbackName: MethodStringName2<DisplayServer, Callable, String, Int>
      = MethodStringName2<DisplayServer, Callable, String, Int>("global_menu_get_item_callback")

  @JvmField
  public val globalMenuGetItemKeyCallbackName:
      MethodStringName2<DisplayServer, Callable, String, Int> =
      MethodStringName2<DisplayServer, Callable, String, Int>("global_menu_get_item_key_callback")

  @JvmField
  public val globalMenuGetItemTagName: MethodStringName2<DisplayServer, Any?, String, Int> =
      MethodStringName2<DisplayServer, Any?, String, Int>("global_menu_get_item_tag")

  @JvmField
  public val globalMenuGetItemTextName: MethodStringName2<DisplayServer, String, String, Int> =
      MethodStringName2<DisplayServer, String, String, Int>("global_menu_get_item_text")

  @JvmField
  public val globalMenuGetItemSubmenuName: MethodStringName2<DisplayServer, String, String, Int> =
      MethodStringName2<DisplayServer, String, String, Int>("global_menu_get_item_submenu")

  @JvmField
  public val globalMenuGetItemAcceleratorName: MethodStringName2<DisplayServer, Key, String, Int> =
      MethodStringName2<DisplayServer, Key, String, Int>("global_menu_get_item_accelerator")

  @JvmField
  public val globalMenuIsItemDisabledName: MethodStringName2<DisplayServer, Boolean, String, Int> =
      MethodStringName2<DisplayServer, Boolean, String, Int>("global_menu_is_item_disabled")

  @JvmField
  public val globalMenuIsItemHiddenName: MethodStringName2<DisplayServer, Boolean, String, Int> =
      MethodStringName2<DisplayServer, Boolean, String, Int>("global_menu_is_item_hidden")

  @JvmField
  public val globalMenuGetItemTooltipName: MethodStringName2<DisplayServer, String, String, Int> =
      MethodStringName2<DisplayServer, String, String, Int>("global_menu_get_item_tooltip")

  @JvmField
  public val globalMenuGetItemStateName: MethodStringName2<DisplayServer, Int, String, Int> =
      MethodStringName2<DisplayServer, Int, String, Int>("global_menu_get_item_state")

  @JvmField
  public val globalMenuGetItemMaxStatesName: MethodStringName2<DisplayServer, Int, String, Int> =
      MethodStringName2<DisplayServer, Int, String, Int>("global_menu_get_item_max_states")

  @JvmField
  public val globalMenuGetItemIconName: MethodStringName2<DisplayServer, Texture2D?, String, Int> =
      MethodStringName2<DisplayServer, Texture2D?, String, Int>("global_menu_get_item_icon")

  @JvmField
  public val globalMenuGetItemIndentationLevelName:
      MethodStringName2<DisplayServer, Int, String, Int> =
      MethodStringName2<DisplayServer, Int, String, Int>("global_menu_get_item_indentation_level")

  @JvmField
  public val globalMenuSetItemCheckedName:
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean> =
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean>("global_menu_set_item_checked")

  @JvmField
  public val globalMenuSetItemCheckableName:
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean> =
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean>("global_menu_set_item_checkable")

  @JvmField
  public val globalMenuSetItemRadioCheckableName:
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean> =
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean>("global_menu_set_item_radio_checkable")

  @JvmField
  public val globalMenuSetItemCallbackName:
      MethodStringName3<DisplayServer, Unit, String, Int, Callable> =
      MethodStringName3<DisplayServer, Unit, String, Int, Callable>("global_menu_set_item_callback")

  @JvmField
  public val globalMenuSetItemHoverCallbacksName:
      MethodStringName3<DisplayServer, Unit, String, Int, Callable> =
      MethodStringName3<DisplayServer, Unit, String, Int, Callable>("global_menu_set_item_hover_callbacks")

  @JvmField
  public val globalMenuSetItemKeyCallbackName:
      MethodStringName3<DisplayServer, Unit, String, Int, Callable> =
      MethodStringName3<DisplayServer, Unit, String, Int, Callable>("global_menu_set_item_key_callback")

  @JvmField
  public val globalMenuSetItemTagName: MethodStringName3<DisplayServer, Unit, String, Int, Any?> =
      MethodStringName3<DisplayServer, Unit, String, Int, Any?>("global_menu_set_item_tag")

  @JvmField
  public val globalMenuSetItemTextName: MethodStringName3<DisplayServer, Unit, String, Int, String>
      = MethodStringName3<DisplayServer, Unit, String, Int, String>("global_menu_set_item_text")

  @JvmField
  public val globalMenuSetItemSubmenuName:
      MethodStringName3<DisplayServer, Unit, String, Int, String> =
      MethodStringName3<DisplayServer, Unit, String, Int, String>("global_menu_set_item_submenu")

  @JvmField
  public val globalMenuSetItemAcceleratorName:
      MethodStringName3<DisplayServer, Unit, String, Int, Key> =
      MethodStringName3<DisplayServer, Unit, String, Int, Key>("global_menu_set_item_accelerator")

  @JvmField
  public val globalMenuSetItemDisabledName:
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean> =
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean>("global_menu_set_item_disabled")

  @JvmField
  public val globalMenuSetItemHiddenName:
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean> =
      MethodStringName3<DisplayServer, Unit, String, Int, Boolean>("global_menu_set_item_hidden")

  @JvmField
  public val globalMenuSetItemTooltipName:
      MethodStringName3<DisplayServer, Unit, String, Int, String> =
      MethodStringName3<DisplayServer, Unit, String, Int, String>("global_menu_set_item_tooltip")

  @JvmField
  public val globalMenuSetItemStateName: MethodStringName3<DisplayServer, Unit, String, Int, Int> =
      MethodStringName3<DisplayServer, Unit, String, Int, Int>("global_menu_set_item_state")

  @JvmField
  public val globalMenuSetItemMaxStatesName:
      MethodStringName3<DisplayServer, Unit, String, Int, Int> =
      MethodStringName3<DisplayServer, Unit, String, Int, Int>("global_menu_set_item_max_states")

  @JvmField
  public val globalMenuSetItemIconName:
      MethodStringName3<DisplayServer, Unit, String, Int, Texture2D?> =
      MethodStringName3<DisplayServer, Unit, String, Int, Texture2D?>("global_menu_set_item_icon")

  @JvmField
  public val globalMenuSetItemIndentationLevelName:
      MethodStringName3<DisplayServer, Unit, String, Int, Int> =
      MethodStringName3<DisplayServer, Unit, String, Int, Int>("global_menu_set_item_indentation_level")

  @JvmField
  public val globalMenuGetItemCountName: MethodStringName1<DisplayServer, Int, String> =
      MethodStringName1<DisplayServer, Int, String>("global_menu_get_item_count")

  @JvmField
  public val globalMenuRemoveItemName: MethodStringName2<DisplayServer, Unit, String, Int> =
      MethodStringName2<DisplayServer, Unit, String, Int>("global_menu_remove_item")

  @JvmField
  public val globalMenuClearName: MethodStringName1<DisplayServer, Unit, String> =
      MethodStringName1<DisplayServer, Unit, String>("global_menu_clear")

  @JvmField
  public val globalMenuGetSystemMenuRootsName:
      MethodStringName0<DisplayServer, Dictionary<Any?, Any?>> =
      MethodStringName0<DisplayServer, Dictionary<Any?, Any?>>("global_menu_get_system_menu_roots")

  @JvmField
  public val ttsIsSpeakingName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("tts_is_speaking")

  @JvmField
  public val ttsIsPausedName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("tts_is_paused")

  @JvmField
  public val ttsGetVoicesName:
      MethodStringName0<DisplayServer, VariantArray<Dictionary<Any?, Any?>>> =
      MethodStringName0<DisplayServer, VariantArray<Dictionary<Any?, Any?>>>("tts_get_voices")

  @JvmField
  public val ttsGetVoicesForLanguageName:
      MethodStringName1<DisplayServer, PackedStringArray, String> =
      MethodStringName1<DisplayServer, PackedStringArray, String>("tts_get_voices_for_language")

  @JvmField
  public val ttsSpeakName:
      MethodStringName7<DisplayServer, Unit, String, String, Int, Float, Float, Long, Boolean> =
      MethodStringName7<DisplayServer, Unit, String, String, Int, Float, Float, Long, Boolean>("tts_speak")

  @JvmField
  public val ttsPauseName: MethodStringName0<DisplayServer, Unit> =
      MethodStringName0<DisplayServer, Unit>("tts_pause")

  @JvmField
  public val ttsResumeName: MethodStringName0<DisplayServer, Unit> =
      MethodStringName0<DisplayServer, Unit>("tts_resume")

  @JvmField
  public val ttsStopName: MethodStringName0<DisplayServer, Unit> =
      MethodStringName0<DisplayServer, Unit>("tts_stop")

  @JvmField
  public val ttsSetUtteranceCallbackName:
      MethodStringName2<DisplayServer, Unit, TTSUtteranceEvent, Callable> =
      MethodStringName2<DisplayServer, Unit, TTSUtteranceEvent, Callable>("tts_set_utterance_callback")

  @JvmField
  public val isDarkModeSupportedName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("is_dark_mode_supported")

  @JvmField
  public val isDarkModeName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("is_dark_mode")

  @JvmField
  public val getAccentColorName: MethodStringName0<DisplayServer, Color> =
      MethodStringName0<DisplayServer, Color>("get_accent_color")

  @JvmField
  public val getBaseColorName: MethodStringName0<DisplayServer, Color> =
      MethodStringName0<DisplayServer, Color>("get_base_color")

  @JvmField
  public val setSystemThemeChangeCallbackName: MethodStringName1<DisplayServer, Unit, Callable> =
      MethodStringName1<DisplayServer, Unit, Callable>("set_system_theme_change_callback")

  @JvmField
  public val mouseSetModeName: MethodStringName1<DisplayServer, Unit, MouseMode> =
      MethodStringName1<DisplayServer, Unit, MouseMode>("mouse_set_mode")

  @JvmField
  public val mouseGetModeName: MethodStringName0<DisplayServer, MouseMode> =
      MethodStringName0<DisplayServer, MouseMode>("mouse_get_mode")

  @JvmField
  public val warpMouseName: MethodStringName1<DisplayServer, Unit, Vector2i> =
      MethodStringName1<DisplayServer, Unit, Vector2i>("warp_mouse")

  @JvmField
  public val mouseGetPositionName: MethodStringName0<DisplayServer, Vector2i> =
      MethodStringName0<DisplayServer, Vector2i>("mouse_get_position")

  @JvmField
  public val mouseGetButtonStateName: MethodStringName0<DisplayServer, MouseButtonMask> =
      MethodStringName0<DisplayServer, MouseButtonMask>("mouse_get_button_state")

  @JvmField
  public val clipboardSetName: MethodStringName1<DisplayServer, Unit, String> =
      MethodStringName1<DisplayServer, Unit, String>("clipboard_set")

  @JvmField
  public val clipboardGetName: MethodStringName0<DisplayServer, String> =
      MethodStringName0<DisplayServer, String>("clipboard_get")

  @JvmField
  public val clipboardGetImageName: MethodStringName0<DisplayServer, Image?> =
      MethodStringName0<DisplayServer, Image?>("clipboard_get_image")

  @JvmField
  public val clipboardHasName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("clipboard_has")

  @JvmField
  public val clipboardHasImageName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("clipboard_has_image")

  @JvmField
  public val clipboardSetPrimaryName: MethodStringName1<DisplayServer, Unit, String> =
      MethodStringName1<DisplayServer, Unit, String>("clipboard_set_primary")

  @JvmField
  public val clipboardGetPrimaryName: MethodStringName0<DisplayServer, String> =
      MethodStringName0<DisplayServer, String>("clipboard_get_primary")

  @JvmField
  public val getDisplayCutoutsName: MethodStringName0<DisplayServer, VariantArray<Rect2>> =
      MethodStringName0<DisplayServer, VariantArray<Rect2>>("get_display_cutouts")

  @JvmField
  public val getDisplaySafeAreaName: MethodStringName0<DisplayServer, Rect2i> =
      MethodStringName0<DisplayServer, Rect2i>("get_display_safe_area")

  @JvmField
  public val getScreenCountName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("get_screen_count")

  @JvmField
  public val getPrimaryScreenName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("get_primary_screen")

  @JvmField
  public val getKeyboardFocusScreenName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("get_keyboard_focus_screen")

  @JvmField
  public val getScreenFromRectName: MethodStringName1<DisplayServer, Int, Rect2> =
      MethodStringName1<DisplayServer, Int, Rect2>("get_screen_from_rect")

  @JvmField
  public val screenGetPositionName: MethodStringName1<DisplayServer, Vector2i, Int> =
      MethodStringName1<DisplayServer, Vector2i, Int>("screen_get_position")

  @JvmField
  public val screenGetSizeName: MethodStringName1<DisplayServer, Vector2i, Int> =
      MethodStringName1<DisplayServer, Vector2i, Int>("screen_get_size")

  @JvmField
  public val screenGetUsableRectName: MethodStringName1<DisplayServer, Rect2i, Int> =
      MethodStringName1<DisplayServer, Rect2i, Int>("screen_get_usable_rect")

  @JvmField
  public val screenGetDpiName: MethodStringName1<DisplayServer, Int, Int> =
      MethodStringName1<DisplayServer, Int, Int>("screen_get_dpi")

  @JvmField
  public val screenGetScaleName: MethodStringName1<DisplayServer, Float, Int> =
      MethodStringName1<DisplayServer, Float, Int>("screen_get_scale")

  @JvmField
  public val isTouchscreenAvailableName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("is_touchscreen_available")

  @JvmField
  public val screenGetMaxScaleName: MethodStringName0<DisplayServer, Float> =
      MethodStringName0<DisplayServer, Float>("screen_get_max_scale")

  @JvmField
  public val screenGetRefreshRateName: MethodStringName1<DisplayServer, Float, Int> =
      MethodStringName1<DisplayServer, Float, Int>("screen_get_refresh_rate")

  @JvmField
  public val screenGetPixelName: MethodStringName1<DisplayServer, Color, Vector2i> =
      MethodStringName1<DisplayServer, Color, Vector2i>("screen_get_pixel")

  @JvmField
  public val screenGetImageName: MethodStringName1<DisplayServer, Image?, Int> =
      MethodStringName1<DisplayServer, Image?, Int>("screen_get_image")

  @JvmField
  public val screenGetImageRectName: MethodStringName1<DisplayServer, Image?, Rect2i> =
      MethodStringName1<DisplayServer, Image?, Rect2i>("screen_get_image_rect")

  @JvmField
  public val screenSetOrientationName:
      MethodStringName2<DisplayServer, Unit, ScreenOrientation, Int> =
      MethodStringName2<DisplayServer, Unit, ScreenOrientation, Int>("screen_set_orientation")

  @JvmField
  public val screenGetOrientationName: MethodStringName1<DisplayServer, ScreenOrientation, Int> =
      MethodStringName1<DisplayServer, ScreenOrientation, Int>("screen_get_orientation")

  @JvmField
  public val screenSetKeepOnName: MethodStringName1<DisplayServer, Unit, Boolean> =
      MethodStringName1<DisplayServer, Unit, Boolean>("screen_set_keep_on")

  @JvmField
  public val screenIsKeptOnName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("screen_is_kept_on")

  @JvmField
  public val getWindowListName: MethodStringName0<DisplayServer, PackedInt32Array> =
      MethodStringName0<DisplayServer, PackedInt32Array>("get_window_list")

  @JvmField
  public val getWindowAtScreenPositionName: MethodStringName1<DisplayServer, Int, Vector2i> =
      MethodStringName1<DisplayServer, Int, Vector2i>("get_window_at_screen_position")

  @JvmField
  public val windowGetNativeHandleName: MethodStringName2<DisplayServer, Long, HandleType, Int> =
      MethodStringName2<DisplayServer, Long, HandleType, Int>("window_get_native_handle")

  @JvmField
  public val windowGetActivePopupName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("window_get_active_popup")

  @JvmField
  public val windowSetPopupSafeRectName: MethodStringName2<DisplayServer, Unit, Int, Rect2i> =
      MethodStringName2<DisplayServer, Unit, Int, Rect2i>("window_set_popup_safe_rect")

  @JvmField
  public val windowGetPopupSafeRectName: MethodStringName1<DisplayServer, Rect2i, Int> =
      MethodStringName1<DisplayServer, Rect2i, Int>("window_get_popup_safe_rect")

  @JvmField
  public val windowSetTitleName: MethodStringName2<DisplayServer, Unit, String, Int> =
      MethodStringName2<DisplayServer, Unit, String, Int>("window_set_title")

  @JvmField
  public val windowGetTitleSizeName: MethodStringName2<DisplayServer, Vector2i, String, Int> =
      MethodStringName2<DisplayServer, Vector2i, String, Int>("window_get_title_size")

  @JvmField
  public val windowSetMousePassthroughName:
      MethodStringName2<DisplayServer, Unit, PackedVector2Array, Int> =
      MethodStringName2<DisplayServer, Unit, PackedVector2Array, Int>("window_set_mouse_passthrough")

  @JvmField
  public val windowGetCurrentScreenName: MethodStringName1<DisplayServer, Int, Int> =
      MethodStringName1<DisplayServer, Int, Int>("window_get_current_screen")

  @JvmField
  public val windowSetCurrentScreenName: MethodStringName2<DisplayServer, Unit, Int, Int> =
      MethodStringName2<DisplayServer, Unit, Int, Int>("window_set_current_screen")

  @JvmField
  public val windowGetPositionName: MethodStringName1<DisplayServer, Vector2i, Int> =
      MethodStringName1<DisplayServer, Vector2i, Int>("window_get_position")

  @JvmField
  public val windowGetPositionWithDecorationsName: MethodStringName1<DisplayServer, Vector2i, Int> =
      MethodStringName1<DisplayServer, Vector2i, Int>("window_get_position_with_decorations")

  @JvmField
  public val windowSetPositionName: MethodStringName2<DisplayServer, Unit, Vector2i, Int> =
      MethodStringName2<DisplayServer, Unit, Vector2i, Int>("window_set_position")

  @JvmField
  public val windowGetSizeName: MethodStringName1<DisplayServer, Vector2i, Int> =
      MethodStringName1<DisplayServer, Vector2i, Int>("window_get_size")

  @JvmField
  public val windowSetSizeName: MethodStringName2<DisplayServer, Unit, Vector2i, Int> =
      MethodStringName2<DisplayServer, Unit, Vector2i, Int>("window_set_size")

  @JvmField
  public val windowSetRectChangedCallbackName: MethodStringName2<DisplayServer, Unit, Callable, Int>
      = MethodStringName2<DisplayServer, Unit, Callable, Int>("window_set_rect_changed_callback")

  @JvmField
  public val windowSetWindowEventCallbackName: MethodStringName2<DisplayServer, Unit, Callable, Int>
      = MethodStringName2<DisplayServer, Unit, Callable, Int>("window_set_window_event_callback")

  @JvmField
  public val windowSetInputEventCallbackName: MethodStringName2<DisplayServer, Unit, Callable, Int>
      = MethodStringName2<DisplayServer, Unit, Callable, Int>("window_set_input_event_callback")

  @JvmField
  public val windowSetInputTextCallbackName: MethodStringName2<DisplayServer, Unit, Callable, Int> =
      MethodStringName2<DisplayServer, Unit, Callable, Int>("window_set_input_text_callback")

  @JvmField
  public val windowSetDropFilesCallbackName: MethodStringName2<DisplayServer, Unit, Callable, Int> =
      MethodStringName2<DisplayServer, Unit, Callable, Int>("window_set_drop_files_callback")

  @JvmField
  public val windowGetAttachedInstanceIdName: MethodStringName1<DisplayServer, Long, Int> =
      MethodStringName1<DisplayServer, Long, Int>("window_get_attached_instance_id")

  @JvmField
  public val windowGetMaxSizeName: MethodStringName1<DisplayServer, Vector2i, Int> =
      MethodStringName1<DisplayServer, Vector2i, Int>("window_get_max_size")

  @JvmField
  public val windowSetMaxSizeName: MethodStringName2<DisplayServer, Unit, Vector2i, Int> =
      MethodStringName2<DisplayServer, Unit, Vector2i, Int>("window_set_max_size")

  @JvmField
  public val windowGetMinSizeName: MethodStringName1<DisplayServer, Vector2i, Int> =
      MethodStringName1<DisplayServer, Vector2i, Int>("window_get_min_size")

  @JvmField
  public val windowSetMinSizeName: MethodStringName2<DisplayServer, Unit, Vector2i, Int> =
      MethodStringName2<DisplayServer, Unit, Vector2i, Int>("window_set_min_size")

  @JvmField
  public val windowGetSizeWithDecorationsName: MethodStringName1<DisplayServer, Vector2i, Int> =
      MethodStringName1<DisplayServer, Vector2i, Int>("window_get_size_with_decorations")

  @JvmField
  public val windowGetModeName: MethodStringName1<DisplayServer, WindowMode, Int> =
      MethodStringName1<DisplayServer, WindowMode, Int>("window_get_mode")

  @JvmField
  public val windowSetModeName: MethodStringName2<DisplayServer, Unit, WindowMode, Int> =
      MethodStringName2<DisplayServer, Unit, WindowMode, Int>("window_set_mode")

  @JvmField
  public val windowSetFlagName: MethodStringName3<DisplayServer, Unit, WindowFlags, Boolean, Int> =
      MethodStringName3<DisplayServer, Unit, WindowFlags, Boolean, Int>("window_set_flag")

  @JvmField
  public val windowGetFlagName: MethodStringName2<DisplayServer, Boolean, WindowFlags, Int> =
      MethodStringName2<DisplayServer, Boolean, WindowFlags, Int>("window_get_flag")

  @JvmField
  public val windowSetIconName: MethodStringName2<DisplayServer, Unit, Image?, Int> =
      MethodStringName2<DisplayServer, Unit, Image?, Int>("window_set_icon")

  @JvmField
  public val windowSetWindowButtonsOffsetName: MethodStringName2<DisplayServer, Unit, Vector2i, Int>
      = MethodStringName2<DisplayServer, Unit, Vector2i, Int>("window_set_window_buttons_offset")

  @JvmField
  public val windowGetSafeTitleMarginsName: MethodStringName1<DisplayServer, Vector3i, Int> =
      MethodStringName1<DisplayServer, Vector3i, Int>("window_get_safe_title_margins")

  @JvmField
  public val windowRequestAttentionName: MethodStringName1<DisplayServer, Unit, Int> =
      MethodStringName1<DisplayServer, Unit, Int>("window_request_attention")

  @JvmField
  public val windowSetTaskbarProgressValueName: MethodStringName2<DisplayServer, Unit, Float, Int> =
      MethodStringName2<DisplayServer, Unit, Float, Int>("window_set_taskbar_progress_value")

  @JvmField
  public val windowSetTaskbarProgressStateName:
      MethodStringName2<DisplayServer, Unit, ProgressState, Int> =
      MethodStringName2<DisplayServer, Unit, ProgressState, Int>("window_set_taskbar_progress_state")

  @JvmField
  public val windowMoveToForegroundName: MethodStringName1<DisplayServer, Unit, Int> =
      MethodStringName1<DisplayServer, Unit, Int>("window_move_to_foreground")

  @JvmField
  public val windowIsFocusedName: MethodStringName1<DisplayServer, Boolean, Int> =
      MethodStringName1<DisplayServer, Boolean, Int>("window_is_focused")

  @JvmField
  public val windowCanDrawName: MethodStringName1<DisplayServer, Boolean, Int> =
      MethodStringName1<DisplayServer, Boolean, Int>("window_can_draw")

  @JvmField
  public val windowSetTransientName: MethodStringName2<DisplayServer, Unit, Int, Int> =
      MethodStringName2<DisplayServer, Unit, Int, Int>("window_set_transient")

  @JvmField
  public val windowSetExclusiveName: MethodStringName2<DisplayServer, Unit, Int, Boolean> =
      MethodStringName2<DisplayServer, Unit, Int, Boolean>("window_set_exclusive")

  @JvmField
  public val windowSetImeActiveName: MethodStringName2<DisplayServer, Unit, Boolean, Int> =
      MethodStringName2<DisplayServer, Unit, Boolean, Int>("window_set_ime_active")

  @JvmField
  public val windowSetImePositionName: MethodStringName2<DisplayServer, Unit, Vector2i, Int> =
      MethodStringName2<DisplayServer, Unit, Vector2i, Int>("window_set_ime_position")

  @JvmField
  public val windowSetVsyncModeName: MethodStringName2<DisplayServer, Unit, VSyncMode, Int> =
      MethodStringName2<DisplayServer, Unit, VSyncMode, Int>("window_set_vsync_mode")

  @JvmField
  public val windowGetVsyncModeName: MethodStringName1<DisplayServer, VSyncMode, Int> =
      MethodStringName1<DisplayServer, VSyncMode, Int>("window_get_vsync_mode")

  @JvmField
  public val windowIsHdrOutputSupportedName: MethodStringName1<DisplayServer, Boolean, Int> =
      MethodStringName1<DisplayServer, Boolean, Int>("window_is_hdr_output_supported")

  @JvmField
  public val windowRequestHdrOutputName: MethodStringName2<DisplayServer, Unit, Boolean, Int> =
      MethodStringName2<DisplayServer, Unit, Boolean, Int>("window_request_hdr_output")

  @JvmField
  public val windowIsHdrOutputRequestedName: MethodStringName1<DisplayServer, Boolean, Int> =
      MethodStringName1<DisplayServer, Boolean, Int>("window_is_hdr_output_requested")

  @JvmField
  public val windowIsHdrOutputEnabledName: MethodStringName1<DisplayServer, Boolean, Int> =
      MethodStringName1<DisplayServer, Boolean, Int>("window_is_hdr_output_enabled")

  @JvmField
  public val windowSetHdrOutputReferenceLuminanceName:
      MethodStringName2<DisplayServer, Unit, Float, Int> =
      MethodStringName2<DisplayServer, Unit, Float, Int>("window_set_hdr_output_reference_luminance")

  @JvmField
  public val windowGetHdrOutputReferenceLuminanceName: MethodStringName1<DisplayServer, Float, Int>
      = MethodStringName1<DisplayServer, Float, Int>("window_get_hdr_output_reference_luminance")

  @JvmField
  public val windowGetHdrOutputCurrentReferenceLuminanceName:
      MethodStringName1<DisplayServer, Float, Int> =
      MethodStringName1<DisplayServer, Float, Int>("window_get_hdr_output_current_reference_luminance")

  @JvmField
  public val windowSetHdrOutputMaxLuminanceName: MethodStringName2<DisplayServer, Unit, Float, Int>
      = MethodStringName2<DisplayServer, Unit, Float, Int>("window_set_hdr_output_max_luminance")

  @JvmField
  public val windowGetHdrOutputMaxLuminanceName: MethodStringName1<DisplayServer, Float, Int> =
      MethodStringName1<DisplayServer, Float, Int>("window_get_hdr_output_max_luminance")

  @JvmField
  public val windowGetHdrOutputCurrentMaxLuminanceName: MethodStringName1<DisplayServer, Float, Int>
      = MethodStringName1<DisplayServer, Float, Int>("window_get_hdr_output_current_max_luminance")

  @JvmField
  public val windowGetOutputMaxLinearValueName: MethodStringName1<DisplayServer, Float, Int> =
      MethodStringName1<DisplayServer, Float, Int>("window_get_output_max_linear_value")

  @JvmField
  public val windowIsMaximizeAllowedName: MethodStringName1<DisplayServer, Boolean, Int> =
      MethodStringName1<DisplayServer, Boolean, Int>("window_is_maximize_allowed")

  @JvmField
  public val windowMaximizeOnTitleDblClickName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("window_maximize_on_title_dbl_click")

  @JvmField
  public val windowMinimizeOnTitleDblClickName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("window_minimize_on_title_dbl_click")

  @JvmField
  public val windowStartDragName: MethodStringName1<DisplayServer, Unit, Int> =
      MethodStringName1<DisplayServer, Unit, Int>("window_start_drag")

  @JvmField
  public val windowStartResizeName: MethodStringName2<DisplayServer, Unit, WindowResizeEdge, Int> =
      MethodStringName2<DisplayServer, Unit, WindowResizeEdge, Int>("window_start_resize")

  @JvmField
  public val windowSetColorName: MethodStringName1<DisplayServer, Unit, Color> =
      MethodStringName1<DisplayServer, Unit, Color>("window_set_color")

  @JvmField
  public val accessibilityShouldIncreaseContrastName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("accessibility_should_increase_contrast")

  @JvmField
  public val accessibilityShouldReduceAnimationName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("accessibility_should_reduce_animation")

  @JvmField
  public val accessibilityShouldReduceTransparencyName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("accessibility_should_reduce_transparency")

  @JvmField
  public val accessibilityScreenReaderActiveName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("accessibility_screen_reader_active")

  @JvmField
  public val accessibilityCreateElementName:
      MethodStringName2<DisplayServer, RID, Int, AccessibilityRole> =
      MethodStringName2<DisplayServer, RID, Int, AccessibilityRole>("accessibility_create_element")

  @JvmField
  public val accessibilityCreateSubElementName:
      MethodStringName3<DisplayServer, RID, RID, AccessibilityRole, Int> =
      MethodStringName3<DisplayServer, RID, RID, AccessibilityRole, Int>("accessibility_create_sub_element")

  @JvmField
  public val accessibilityCreateSubTextEditElementsName:
      MethodStringName5<DisplayServer, RID, RID, RID, Float, Int, Boolean> =
      MethodStringName5<DisplayServer, RID, RID, RID, Float, Int, Boolean>("accessibility_create_sub_text_edit_elements")

  @JvmField
  public val accessibilityHasElementName: MethodStringName1<DisplayServer, Boolean, RID> =
      MethodStringName1<DisplayServer, Boolean, RID>("accessibility_has_element")

  @JvmField
  public val accessibilityFreeElementName: MethodStringName1<DisplayServer, Unit, RID> =
      MethodStringName1<DisplayServer, Unit, RID>("accessibility_free_element")

  @JvmField
  public val accessibilityElementSetMetaName: MethodStringName2<DisplayServer, Unit, RID, Any?> =
      MethodStringName2<DisplayServer, Unit, RID, Any?>("accessibility_element_set_meta")

  @JvmField
  public val accessibilityElementGetMetaName: MethodStringName1<DisplayServer, Any?, RID> =
      MethodStringName1<DisplayServer, Any?, RID>("accessibility_element_get_meta")

  @JvmField
  public val accessibilitySetWindowRectName:
      MethodStringName3<DisplayServer, Unit, Int, Rect2, Rect2> =
      MethodStringName3<DisplayServer, Unit, Int, Rect2, Rect2>("accessibility_set_window_rect")

  @JvmField
  public val accessibilitySetWindowFocusedName: MethodStringName2<DisplayServer, Unit, Int, Boolean>
      = MethodStringName2<DisplayServer, Unit, Int, Boolean>("accessibility_set_window_focused")

  @JvmField
  public val accessibilityUpdateSetFocusName: MethodStringName1<DisplayServer, Unit, RID> =
      MethodStringName1<DisplayServer, Unit, RID>("accessibility_update_set_focus")

  @JvmField
  public val accessibilityGetWindowRootName: MethodStringName1<DisplayServer, RID, Int> =
      MethodStringName1<DisplayServer, RID, Int>("accessibility_get_window_root")

  @JvmField
  public val accessibilityUpdateSetRoleName:
      MethodStringName2<DisplayServer, Unit, RID, AccessibilityRole> =
      MethodStringName2<DisplayServer, Unit, RID, AccessibilityRole>("accessibility_update_set_role")

  @JvmField
  public val accessibilityUpdateSetNameName: MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_name")

  @JvmField
  public val accessibilityUpdateSetExtraInfoName:
      MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_extra_info")

  @JvmField
  public val accessibilityUpdateSetDescriptionName:
      MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_description")

  @JvmField
  public val accessibilityUpdateSetValueName: MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_value")

  @JvmField
  public val accessibilityUpdateSetTooltipName: MethodStringName2<DisplayServer, Unit, RID, String>
      = MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_tooltip")

  @JvmField
  public val accessibilityUpdateSetBoundsName: MethodStringName2<DisplayServer, Unit, RID, Rect2> =
      MethodStringName2<DisplayServer, Unit, RID, Rect2>("accessibility_update_set_bounds")

  @JvmField
  public val accessibilityUpdateSetTransformName:
      MethodStringName2<DisplayServer, Unit, RID, Transform2D> =
      MethodStringName2<DisplayServer, Unit, RID, Transform2D>("accessibility_update_set_transform")

  @JvmField
  public val accessibilityUpdateAddChildName: MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_add_child")

  @JvmField
  public val accessibilityUpdateAddRelatedControlsName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_add_related_controls")

  @JvmField
  public val accessibilityUpdateAddRelatedDetailsName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_add_related_details")

  @JvmField
  public val accessibilityUpdateAddRelatedDescribedByName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_add_related_described_by")

  @JvmField
  public val accessibilityUpdateAddRelatedFlowToName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_add_related_flow_to")

  @JvmField
  public val accessibilityUpdateAddRelatedLabeledByName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_add_related_labeled_by")

  @JvmField
  public val accessibilityUpdateAddRelatedRadioGroupName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_add_related_radio_group")

  @JvmField
  public val accessibilityUpdateSetActiveDescendantName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_set_active_descendant")

  @JvmField
  public val accessibilityUpdateSetNextOnLineName: MethodStringName2<DisplayServer, Unit, RID, RID>
      = MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_set_next_on_line")

  @JvmField
  public val accessibilityUpdateSetPreviousOnLineName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_set_previous_on_line")

  @JvmField
  public val accessibilityUpdateSetMemberOfName: MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_set_member_of")

  @JvmField
  public val accessibilityUpdateSetInPageLinkTargetName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_set_in_page_link_target")

  @JvmField
  public val accessibilityUpdateSetErrorMessageName:
      MethodStringName2<DisplayServer, Unit, RID, RID> =
      MethodStringName2<DisplayServer, Unit, RID, RID>("accessibility_update_set_error_message")

  @JvmField
  public val accessibilityUpdateSetLiveName:
      MethodStringName2<DisplayServer, Unit, RID, AccessibilityLiveMode> =
      MethodStringName2<DisplayServer, Unit, RID, AccessibilityLiveMode>("accessibility_update_set_live")

  @JvmField
  public val accessibilityUpdateAddActionName:
      MethodStringName3<DisplayServer, Unit, RID, AccessibilityAction, Callable> =
      MethodStringName3<DisplayServer, Unit, RID, AccessibilityAction, Callable>("accessibility_update_add_action")

  @JvmField
  public val accessibilityUpdateAddCustomActionName:
      MethodStringName3<DisplayServer, Unit, RID, Int, String> =
      MethodStringName3<DisplayServer, Unit, RID, Int, String>("accessibility_update_add_custom_action")

  @JvmField
  public val accessibilityUpdateSetTableRowCountName:
      MethodStringName2<DisplayServer, Unit, RID, Int> =
      MethodStringName2<DisplayServer, Unit, RID, Int>("accessibility_update_set_table_row_count")

  @JvmField
  public val accessibilityUpdateSetTableColumnCountName:
      MethodStringName2<DisplayServer, Unit, RID, Int> =
      MethodStringName2<DisplayServer, Unit, RID, Int>("accessibility_update_set_table_column_count")

  @JvmField
  public val accessibilityUpdateSetTableRowIndexName:
      MethodStringName2<DisplayServer, Unit, RID, Int> =
      MethodStringName2<DisplayServer, Unit, RID, Int>("accessibility_update_set_table_row_index")

  @JvmField
  public val accessibilityUpdateSetTableColumnIndexName:
      MethodStringName2<DisplayServer, Unit, RID, Int> =
      MethodStringName2<DisplayServer, Unit, RID, Int>("accessibility_update_set_table_column_index")

  @JvmField
  public val accessibilityUpdateSetTableCellPositionName:
      MethodStringName3<DisplayServer, Unit, RID, Int, Int> =
      MethodStringName3<DisplayServer, Unit, RID, Int, Int>("accessibility_update_set_table_cell_position")

  @JvmField
  public val accessibilityUpdateSetTableCellSpanName:
      MethodStringName3<DisplayServer, Unit, RID, Int, Int> =
      MethodStringName3<DisplayServer, Unit, RID, Int, Int>("accessibility_update_set_table_cell_span")

  @JvmField
  public val accessibilityUpdateSetListItemCountName:
      MethodStringName2<DisplayServer, Unit, RID, Int> =
      MethodStringName2<DisplayServer, Unit, RID, Int>("accessibility_update_set_list_item_count")

  @JvmField
  public val accessibilityUpdateSetListItemIndexName:
      MethodStringName2<DisplayServer, Unit, RID, Int> =
      MethodStringName2<DisplayServer, Unit, RID, Int>("accessibility_update_set_list_item_index")

  @JvmField
  public val accessibilityUpdateSetListItemLevelName:
      MethodStringName2<DisplayServer, Unit, RID, Int> =
      MethodStringName2<DisplayServer, Unit, RID, Int>("accessibility_update_set_list_item_level")

  @JvmField
  public val accessibilityUpdateSetListItemSelectedName:
      MethodStringName2<DisplayServer, Unit, RID, Boolean> =
      MethodStringName2<DisplayServer, Unit, RID, Boolean>("accessibility_update_set_list_item_selected")

  @JvmField
  public val accessibilityUpdateSetListItemExpandedName:
      MethodStringName2<DisplayServer, Unit, RID, Boolean> =
      MethodStringName2<DisplayServer, Unit, RID, Boolean>("accessibility_update_set_list_item_expanded")

  @JvmField
  public val accessibilityUpdateSetPopupTypeName:
      MethodStringName2<DisplayServer, Unit, RID, AccessibilityPopupType> =
      MethodStringName2<DisplayServer, Unit, RID, AccessibilityPopupType>("accessibility_update_set_popup_type")

  @JvmField
  public val accessibilityUpdateSetCheckedName: MethodStringName2<DisplayServer, Unit, RID, Boolean>
      = MethodStringName2<DisplayServer, Unit, RID, Boolean>("accessibility_update_set_checked")

  @JvmField
  public val accessibilityUpdateSetNumValueName: MethodStringName2<DisplayServer, Unit, RID, Double>
      = MethodStringName2<DisplayServer, Unit, RID, Double>("accessibility_update_set_num_value")

  @JvmField
  public val accessibilityUpdateSetNumRangeName:
      MethodStringName3<DisplayServer, Unit, RID, Double, Double> =
      MethodStringName3<DisplayServer, Unit, RID, Double, Double>("accessibility_update_set_num_range")

  @JvmField
  public val accessibilityUpdateSetNumStepName: MethodStringName2<DisplayServer, Unit, RID, Double>
      = MethodStringName2<DisplayServer, Unit, RID, Double>("accessibility_update_set_num_step")

  @JvmField
  public val accessibilityUpdateSetNumJumpName: MethodStringName2<DisplayServer, Unit, RID, Double>
      = MethodStringName2<DisplayServer, Unit, RID, Double>("accessibility_update_set_num_jump")

  @JvmField
  public val accessibilityUpdateSetScrollXName: MethodStringName2<DisplayServer, Unit, RID, Double>
      = MethodStringName2<DisplayServer, Unit, RID, Double>("accessibility_update_set_scroll_x")

  @JvmField
  public val accessibilityUpdateSetScrollXRangeName:
      MethodStringName3<DisplayServer, Unit, RID, Double, Double> =
      MethodStringName3<DisplayServer, Unit, RID, Double, Double>("accessibility_update_set_scroll_x_range")

  @JvmField
  public val accessibilityUpdateSetScrollYName: MethodStringName2<DisplayServer, Unit, RID, Double>
      = MethodStringName2<DisplayServer, Unit, RID, Double>("accessibility_update_set_scroll_y")

  @JvmField
  public val accessibilityUpdateSetScrollYRangeName:
      MethodStringName3<DisplayServer, Unit, RID, Double, Double> =
      MethodStringName3<DisplayServer, Unit, RID, Double, Double>("accessibility_update_set_scroll_y_range")

  @JvmField
  public val accessibilityUpdateSetTextDecorationsName:
      MethodStringName4<DisplayServer, Unit, RID, Boolean, Boolean, Boolean> =
      MethodStringName4<DisplayServer, Unit, RID, Boolean, Boolean, Boolean>("accessibility_update_set_text_decorations")

  @JvmField
  public val accessibilityUpdateSetTextAlignName:
      MethodStringName2<DisplayServer, Unit, RID, HorizontalAlignment> =
      MethodStringName2<DisplayServer, Unit, RID, HorizontalAlignment>("accessibility_update_set_text_align")

  @JvmField
  public val accessibilityUpdateSetTextSelectionName:
      MethodStringName5<DisplayServer, Unit, RID, RID, Int, RID, Int> =
      MethodStringName5<DisplayServer, Unit, RID, RID, Int, RID, Int>("accessibility_update_set_text_selection")

  @JvmField
  public val accessibilityUpdateSetFlagName:
      MethodStringName3<DisplayServer, Unit, RID, AccessibilityFlags, Boolean> =
      MethodStringName3<DisplayServer, Unit, RID, AccessibilityFlags, Boolean>("accessibility_update_set_flag")

  @JvmField
  public val accessibilityUpdateSetClassnameName:
      MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_classname")

  @JvmField
  public val accessibilityUpdateSetPlaceholderName:
      MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_placeholder")

  @JvmField
  public val accessibilityUpdateSetLanguageName: MethodStringName2<DisplayServer, Unit, RID, String>
      = MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_language")

  @JvmField
  public val accessibilityUpdateSetTextOrientationName:
      MethodStringName2<DisplayServer, Unit, RID, Boolean> =
      MethodStringName2<DisplayServer, Unit, RID, Boolean>("accessibility_update_set_text_orientation")

  @JvmField
  public val accessibilityUpdateSetListOrientationName:
      MethodStringName2<DisplayServer, Unit, RID, Boolean> =
      MethodStringName2<DisplayServer, Unit, RID, Boolean>("accessibility_update_set_list_orientation")

  @JvmField
  public val accessibilityUpdateSetShortcutName: MethodStringName2<DisplayServer, Unit, RID, String>
      = MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_shortcut")

  @JvmField
  public val accessibilityUpdateSetUrlName: MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_url")

  @JvmField
  public val accessibilityUpdateSetRoleDescriptionName:
      MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_role_description")

  @JvmField
  public val accessibilityUpdateSetStateDescriptionName:
      MethodStringName2<DisplayServer, Unit, RID, String> =
      MethodStringName2<DisplayServer, Unit, RID, String>("accessibility_update_set_state_description")

  @JvmField
  public val accessibilityUpdateSetColorValueName:
      MethodStringName2<DisplayServer, Unit, RID, Color> =
      MethodStringName2<DisplayServer, Unit, RID, Color>("accessibility_update_set_color_value")

  @JvmField
  public val accessibilityUpdateSetBackgroundColorName:
      MethodStringName2<DisplayServer, Unit, RID, Color> =
      MethodStringName2<DisplayServer, Unit, RID, Color>("accessibility_update_set_background_color")

  @JvmField
  public val accessibilityUpdateSetForegroundColorName:
      MethodStringName2<DisplayServer, Unit, RID, Color> =
      MethodStringName2<DisplayServer, Unit, RID, Color>("accessibility_update_set_foreground_color")

  @JvmField
  public val imeGetSelectionName: MethodStringName0<DisplayServer, Vector2i> =
      MethodStringName0<DisplayServer, Vector2i>("ime_get_selection")

  @JvmField
  public val imeGetTextName: MethodStringName0<DisplayServer, String> =
      MethodStringName0<DisplayServer, String>("ime_get_text")

  @JvmField
  public val virtualKeyboardShowName:
      MethodStringName6<DisplayServer, Unit, String, Rect2, VirtualKeyboardType, Int, Int, Int> =
      MethodStringName6<DisplayServer, Unit, String, Rect2, VirtualKeyboardType, Int, Int, Int>("virtual_keyboard_show")

  @JvmField
  public val virtualKeyboardHideName: MethodStringName0<DisplayServer, Unit> =
      MethodStringName0<DisplayServer, Unit>("virtual_keyboard_hide")

  @JvmField
  public val virtualKeyboardGetHeightName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("virtual_keyboard_get_height")

  @JvmField
  public val hasHardwareKeyboardName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("has_hardware_keyboard")

  @JvmField
  public val setHardwareKeyboardConnectionChangeCallbackName:
      MethodStringName1<DisplayServer, Unit, Callable> =
      MethodStringName1<DisplayServer, Unit, Callable>("set_hardware_keyboard_connection_change_callback")

  @JvmField
  public val cursorSetShapeName: MethodStringName1<DisplayServer, Unit, CursorShape> =
      MethodStringName1<DisplayServer, Unit, CursorShape>("cursor_set_shape")

  @JvmField
  public val cursorGetShapeName: MethodStringName0<DisplayServer, CursorShape> =
      MethodStringName0<DisplayServer, CursorShape>("cursor_get_shape")

  @JvmField
  public val cursorSetCustomImageName:
      MethodStringName3<DisplayServer, Unit, Resource?, CursorShape, Vector2> =
      MethodStringName3<DisplayServer, Unit, Resource?, CursorShape, Vector2>("cursor_set_custom_image")

  @JvmField
  public val getSwapCancelOkName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("get_swap_cancel_ok")

  @JvmField
  public val enableForStealingFocusName: MethodStringName1<DisplayServer, Unit, Long> =
      MethodStringName1<DisplayServer, Unit, Long>("enable_for_stealing_focus")

  @JvmField
  public val dialogShowName:
      MethodStringName4<DisplayServer, Error, String, String, PackedStringArray, Callable> =
      MethodStringName4<DisplayServer, Error, String, String, PackedStringArray, Callable>("dialog_show")

  @JvmField
  public val dialogInputTextName:
      MethodStringName4<DisplayServer, Error, String, String, String, Callable> =
      MethodStringName4<DisplayServer, Error, String, String, String, Callable>("dialog_input_text")

  @JvmField
  public val fileDialogShowName:
      MethodStringName8<DisplayServer, Error, String, String, String, Boolean, FileDialogMode, PackedStringArray, Callable, Int>
      =
      MethodStringName8<DisplayServer, Error, String, String, String, Boolean, FileDialogMode, PackedStringArray, Callable, Int>("file_dialog_show")

  @JvmField
  public val fileDialogWithOptionsShowName:
      MethodStringName10<DisplayServer, Error, String, String, String, String, Boolean, FileDialogMode, PackedStringArray, VariantArray<Dictionary<Any?, Any?>>, Callable, Int>
      =
      MethodStringName10<DisplayServer, Error, String, String, String, String, Boolean, FileDialogMode, PackedStringArray, VariantArray<Dictionary<Any?, Any?>>, Callable, Int>("file_dialog_with_options_show")

  @JvmField
  public val beepName: MethodStringName0<DisplayServer, Unit> =
      MethodStringName0<DisplayServer, Unit>("beep")

  @JvmField
  public val keyboardGetLayoutCountName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("keyboard_get_layout_count")

  @JvmField
  public val keyboardGetCurrentLayoutName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("keyboard_get_current_layout")

  @JvmField
  public val keyboardSetCurrentLayoutName: MethodStringName1<DisplayServer, Unit, Int> =
      MethodStringName1<DisplayServer, Unit, Int>("keyboard_set_current_layout")

  @JvmField
  public val keyboardGetLayoutLanguageName: MethodStringName1<DisplayServer, String, Int> =
      MethodStringName1<DisplayServer, String, Int>("keyboard_get_layout_language")

  @JvmField
  public val keyboardGetLayoutNameName: MethodStringName1<DisplayServer, String, Int> =
      MethodStringName1<DisplayServer, String, Int>("keyboard_get_layout_name")

  @JvmField
  public val keyboardGetKeycodeFromPhysicalName: MethodStringName1<DisplayServer, Key, Key> =
      MethodStringName1<DisplayServer, Key, Key>("keyboard_get_keycode_from_physical")

  @JvmField
  public val keyboardGetLabelFromPhysicalName: MethodStringName1<DisplayServer, Key, Key> =
      MethodStringName1<DisplayServer, Key, Key>("keyboard_get_label_from_physical")

  @JvmField
  public val showEmojiAndSymbolPickerName: MethodStringName0<DisplayServer, Unit> =
      MethodStringName0<DisplayServer, Unit>("show_emoji_and_symbol_picker")

  @JvmField
  public val colorPickerName: MethodStringName1<DisplayServer, Boolean, Callable> =
      MethodStringName1<DisplayServer, Boolean, Callable>("color_picker")

  @JvmField
  public val processEventsName: MethodStringName0<DisplayServer, Unit> =
      MethodStringName0<DisplayServer, Unit>("process_events")

  @JvmField
  public val forceProcessAndDropEventsName: MethodStringName0<DisplayServer, Unit> =
      MethodStringName0<DisplayServer, Unit>("force_process_and_drop_events")

  @JvmField
  public val setNativeIconName: MethodStringName1<DisplayServer, Unit, String> =
      MethodStringName1<DisplayServer, Unit, String>("set_native_icon")

  @JvmField
  public val setIconName: MethodStringName1<DisplayServer, Unit, Image?> =
      MethodStringName1<DisplayServer, Unit, Image?>("set_icon")

  @JvmField
  public val createStatusIndicatorName:
      MethodStringName3<DisplayServer, Int, Texture2D?, String, Callable> =
      MethodStringName3<DisplayServer, Int, Texture2D?, String, Callable>("create_status_indicator")

  @JvmField
  public val statusIndicatorSetIconName: MethodStringName2<DisplayServer, Unit, Int, Texture2D?> =
      MethodStringName2<DisplayServer, Unit, Int, Texture2D?>("status_indicator_set_icon")

  @JvmField
  public val statusIndicatorSetTooltipName: MethodStringName2<DisplayServer, Unit, Int, String> =
      MethodStringName2<DisplayServer, Unit, Int, String>("status_indicator_set_tooltip")

  @JvmField
  public val statusIndicatorSetMenuName: MethodStringName2<DisplayServer, Unit, Int, RID> =
      MethodStringName2<DisplayServer, Unit, Int, RID>("status_indicator_set_menu")

  @JvmField
  public val statusIndicatorSetCallbackName: MethodStringName2<DisplayServer, Unit, Int, Callable> =
      MethodStringName2<DisplayServer, Unit, Int, Callable>("status_indicator_set_callback")

  @JvmField
  public val statusIndicatorGetRectName: MethodStringName1<DisplayServer, Rect2, Int> =
      MethodStringName1<DisplayServer, Rect2, Int>("status_indicator_get_rect")

  @JvmField
  public val deleteStatusIndicatorName: MethodStringName1<DisplayServer, Unit, Int> =
      MethodStringName1<DisplayServer, Unit, Int>("delete_status_indicator")

  @JvmField
  public val tabletGetDriverCountName: MethodStringName0<DisplayServer, Int> =
      MethodStringName0<DisplayServer, Int>("tablet_get_driver_count")

  @JvmField
  public val tabletGetDriverNameName: MethodStringName1<DisplayServer, String, Int> =
      MethodStringName1<DisplayServer, String, Int>("tablet_get_driver_name")

  @JvmField
  public val tabletGetCurrentDriverName: MethodStringName0<DisplayServer, String> =
      MethodStringName0<DisplayServer, String>("tablet_get_current_driver")

  @JvmField
  public val tabletSetCurrentDriverName: MethodStringName1<DisplayServer, Unit, String> =
      MethodStringName1<DisplayServer, Unit, String>("tablet_set_current_driver")

  @JvmField
  public val isWindowTransparencyAvailableName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("is_window_transparency_available")

  @JvmField
  public val registerAdditionalOutputName: MethodStringName1<DisplayServer, Unit, Object?> =
      MethodStringName1<DisplayServer, Unit, Object?>("register_additional_output")

  @JvmField
  public val unregisterAdditionalOutputName: MethodStringName1<DisplayServer, Unit, Object?> =
      MethodStringName1<DisplayServer, Unit, Object?>("unregister_additional_output")

  @JvmField
  public val hasAdditionalOutputsName: MethodStringName0<DisplayServer, Boolean> =
      MethodStringName0<DisplayServer, Boolean>("has_additional_outputs")

  @JvmField
  public val isInPipModeName: MethodStringName1<DisplayServer, Boolean, Int> =
      MethodStringName1<DisplayServer, Boolean, Int>("is_in_pip_mode")

  @JvmField
  public val pipModeEnterName: MethodStringName1<DisplayServer, Unit, Int> =
      MethodStringName1<DisplayServer, Unit, Int>("pip_mode_enter")

  @JvmField
  public val pipModeSetAspectRatioName: MethodStringName3<DisplayServer, Unit, Int, Int, Int> =
      MethodStringName3<DisplayServer, Unit, Int, Int, Int>("pip_mode_set_aspect_ratio")

  @JvmField
  public val pipModeSetAutoEnterOnBackgroundName:
      MethodStringName2<DisplayServer, Unit, Boolean, Int> =
      MethodStringName2<DisplayServer, Unit, Boolean, Int>("pip_mode_set_auto_enter_on_background")

  /**
   * Emitted when the device orientation changes. [orientation] is the new orientation.
   *
   * Returns `1` for portrait, `2` for landscape, and `0` if the orientation is undefined.
   *
   * **Note:** This method is implemented on Android and iOS.
   */
  @JvmStatic
  public val orientationChanged: Signal1<Long> by Signal1

  /**
   * The ID that refers to a screen that does not exist. This is returned by some [DisplayServer]
   * methods if no screen matches the requested result.
   */
  public final const val INVALID_SCREEN: Long = -1

  /**
   * Represents the screen containing the mouse pointer.
   *
   * **Note:** On Android, iOS, Web, and Linux (Wayland), this constant always represents the screen
   * at index `0`.
   */
  public final const val SCREEN_WITH_MOUSE_FOCUS: Long = -4

  /**
   * Represents the screen containing the window with the keyboard focus.
   *
   * **Note:** On Android, iOS, Web, and Linux (Wayland), this constant always represents the screen
   * at index `0`.
   */
  public final const val SCREEN_WITH_KEYBOARD_FOCUS: Long = -3

  /**
   * Represents the primary screen.
   *
   * **Note:** On Android, iOS, Web, and Linux (Wayland), this constant always represents the screen
   * at index `0`.
   */
  public final const val SCREEN_PRIMARY: Long = -2

  /**
   * Represents the screen where the main window is located. This is usually the default value in
   * functions that allow specifying one of several screens.
   *
   * **Note:** On Android, iOS, Web, and Linux (Wayland), this constant always represents the screen
   * at index `0`.
   */
  public final const val SCREEN_OF_MAIN_WINDOW: Long = -1

  /**
   * The ID of the main window spawned by the engine, which can be passed to methods expecting a
   * `window_id`.
   */
  public final const val MAIN_WINDOW_ID: Long = 0

  /**
   * The ID that refers to a nonexistent window. This is returned by some [DisplayServer] methods if
   * no window matches the requested result.
   */
  public final const val INVALID_WINDOW_ID: Long = -1

  /**
   * The ID that refers to a nonexistent application status indicator.
   */
  public final const val INVALID_INDICATOR_ID: Long = -1

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(4)
  }

  /**
   * Returns `true` if the specified [feature] is supported by the current [DisplayServer], `false`
   * otherwise.
   */
  @JvmStatic
  public final fun hasFeature(feature: Feature): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to feature.value)
    TransferContext.callMethod(MethodBindings.hasFeaturePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the name of the [DisplayServer] currently in use. Most operating systems only have a
   * single [DisplayServer], but Linux has access to more than one [DisplayServer] (currently X11 and
   * Wayland).
   *
   * The names of built-in display servers are `Windows`, `macOS`, `X11` (Linux), `Wayland` (Linux),
   * `Android`, `iOS`, `web` (HTML5), and `headless` (when started with the `--headless`
   * [url=$DOCS_URL/tutorials/editor/command_line_tutorial.html]command line argument[/url]).
   */
  @JvmStatic
  public final fun getName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets native help system search callbacks.
   *
   * [searchCallback] has the following arguments: `String search_string, int result_limit` and
   * return a [Dictionary] with "key, display name" pairs for the search results. Called when the user
   * enters search terms in the `Help` menu.
   *
   * [actionCallback] has the following arguments: `String key`. Called when the user selects a
   * search result in the `Help` menu.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun helpSetSearchCallbacks(searchCallback: Callable, actionCallback: Callable):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to searchCallback, CALLABLE to actionCallback)
    TransferContext.callMethod(MethodBindings.helpSetSearchCallbacksPtr)
  }

  /**
   * Registers callables to emit when the menu is respectively about to show or closed. Callback
   * methods should have zero arguments.
   */
  @JvmStatic
  public final fun globalMenuSetPopupCallbacks(
    menuRoot: String,
    openCallback: Callable,
    closeCallback: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, CALLABLE to openCallback, CALLABLE to closeCallback)
    TransferContext.callMethod(MethodBindings.globalMenuSetPopupCallbacksPtr)
  }

  /**
   * Adds an item that will act as a submenu of the global menu [menuRoot]. The [submenu] argument
   * is the ID of the global menu root that will be shown when the item is clicked.
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddSubmenuItem(
    menuRoot: String,
    label: String,
    submenu: String,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, STRING to label, STRING to submenu, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddSubmenuItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new item with text [label] to the global menu with ID [menuRoot].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddItem(
    menuRoot: String,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, STRING to label, CALLABLE to callback, CALLABLE to keyCallback, ANY to tag, LONG to accelerator.value, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new checkable item with text [label] to the global menu with ID [menuRoot].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddCheckItem(
    menuRoot: String,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, STRING to label, CALLABLE to callback, CALLABLE to keyCallback, ANY to tag, LONG to accelerator.value, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddCheckItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new item with text [label] and icon [icon] to the global menu with ID [menuRoot].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddIconItem(
    menuRoot: String,
    icon: Texture2D?,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, OBJECT to icon, STRING to label, CALLABLE to callback, CALLABLE to keyCallback, ANY to tag, LONG to accelerator.value, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddIconItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new checkable item with text [label] and icon [icon] to the global menu with ID
   * [menuRoot].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddIconCheckItem(
    menuRoot: String,
    icon: Texture2D?,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, OBJECT to icon, STRING to label, CALLABLE to callback, CALLABLE to keyCallback, ANY to tag, LONG to accelerator.value, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddIconCheckItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new radio-checkable item with text [label] to the global menu with ID [menuRoot].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** Radio-checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [globalMenuSetItemChecked] for more info on
   * how to control it.
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddRadioCheckItem(
    menuRoot: String,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, STRING to label, CALLABLE to callback, CALLABLE to keyCallback, ANY to tag, LONG to accelerator.value, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddRadioCheckItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new radio-checkable item with text [label] and icon [icon] to the global menu with ID
   * [menuRoot].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** Radio-checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [globalMenuSetItemChecked] for more info on
   * how to control it.
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddIconRadioCheckItem(
    menuRoot: String,
    icon: Texture2D?,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, OBJECT to icon, STRING to label, CALLABLE to callback, CALLABLE to keyCallback, ANY to tag, LONG to accelerator.value, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddIconRadioCheckItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a new item with text [label] to the global menu with ID [menuRoot].
   *
   * Contrarily to normal binary items, multistate items can have more than two states, as defined
   * by [maxStates]. Each press or activate of the item will increase the state by one. The default
   * value is defined by [defaultState].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** By default, there's no indication of the current item state, it should be changed
   * manually.
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddMultistateItem(
    menuRoot: String,
    label: String,
    maxStates: Int,
    defaultState: Int,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, STRING to label, LONG to maxStates.toLong(), LONG to defaultState.toLong(), CALLABLE to callback, CALLABLE to keyCallback, ANY to tag, LONG to accelerator.value, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddMultistateItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a separator between items to the global menu with ID [menuRoot]. Separators also occupy an
   * index.
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun globalMenuAddSeparator(menuRoot: String, index: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuAddSeparatorPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the index of the item with the specified [text]. Indices are automatically assigned to
   * each item by the engine, and cannot be set manually.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemIndexFromText(menuRoot: String, text: String): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, STRING to text)
    TransferContext.callMethod(MethodBindings.globalMenuGetItemIndexFromTextPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the index of the item with the specified [tag]. Indices are automatically assigned to
   * each item by the engine, and cannot be set manually.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemIndexFromTag(menuRoot: String, tag: Any?): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, ANY to tag)
    TransferContext.callMethod(MethodBindings.globalMenuGetItemIndexFromTagPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if the item at index [idx] is checked.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuIsItemChecked(menuRoot: String, idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuIsItemCheckedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the item at index [idx] is checkable in some way, i.e. if it has a checkbox
   * or radio button.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuIsItemCheckable(menuRoot: String, idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuIsItemCheckablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the item at index [idx] has radio button-style checkability.
   *
   * **Note:** This is purely cosmetic; you must add the logic for checking/unchecking items in
   * radio groups.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuIsItemRadioCheckable(menuRoot: String, idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuIsItemRadioCheckablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the callback of the item at index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemCallback(menuRoot: String, idx: Int): Callable {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemCallbackPtr)
    return (TransferContext.readReturnValue(CALLABLE) as Callable)
  }

  /**
   * Returns the callback of the item accelerator at index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemKeyCallback(menuRoot: String, idx: Int): Callable {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemKeyCallbackPtr)
    return (TransferContext.readReturnValue(CALLABLE) as Callable)
  }

  /**
   * Returns the metadata of the specified item, which might be of any type. You can set it with
   * [globalMenuSetItemTag], which provides a simple way of assigning context data to items.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemTag(menuRoot: String, idx: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemTagPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the text of the item at index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemText(menuRoot: String, idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the submenu ID of the item at index [idx]. See [globalMenuAddSubmenuItem] for more info
   * on how to add a submenu.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemSubmenu(menuRoot: String, idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemSubmenuPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the accelerator of the item at index [idx]. Accelerators are special combinations of
   * keys that activate the item, no matter which control is focused.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemAccelerator(menuRoot: String, idx: Int): Key {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemAcceleratorPtr)
    return Key.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the item at index [idx] is disabled. When it is disabled it can't be
   * selected, or its action invoked.
   *
   * See [globalMenuSetItemDisabled] for more info on how to disable an item.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuIsItemDisabled(menuRoot: String, idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuIsItemDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the item at index [idx] is hidden.
   *
   * See [globalMenuSetItemHidden] for more info on how to hide an item.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuIsItemHidden(menuRoot: String, idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuIsItemHiddenPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the tooltip associated with the specified index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemTooltip(menuRoot: String, idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemTooltipPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the state of a multistate item. See [globalMenuAddMultistateItem] for details.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemState(menuRoot: String, idx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemStatePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns number of states of a multistate item. See [globalMenuAddMultistateItem] for details.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemMaxStates(menuRoot: String, idx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemMaxStatesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the icon of the item at index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemIcon(menuRoot: String, idx: Int): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemIconPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Returns the horizontal offset of the item at the given [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemIndentationLevel(menuRoot: String, idx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuGetItemIndentationLevelPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the checkstate status of the item at index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemChecked(
    menuRoot: String,
    idx: Int,
    checked: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), BOOL to checked)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemCheckedPtr)
  }

  /**
   * Sets whether the item at index [idx] has a checkbox. If `false`, sets the type of the item to
   * plain text.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemCheckable(
    menuRoot: String,
    idx: Int,
    checkable: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), BOOL to checkable)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemCheckablePtr)
  }

  /**
   * Sets the type of the item at the specified index [idx] to radio button. If `false`, sets the
   * type of the item to plain text.
   *
   * **Note:** This is purely cosmetic; you must add the logic for checking/unchecking items in
   * radio groups.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemRadioCheckable(
    menuRoot: String,
    idx: Int,
    checkable: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), BOOL to checkable)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemRadioCheckablePtr)
  }

  /**
   * Sets the callback of the item at index [idx]. Callback is emitted when an item is pressed.
   *
   * **Note:** The [callback] Callable needs to accept exactly one Variant parameter, the parameter
   * passed to the Callable will be the value passed to the `tag` parameter when the menu item was
   * created.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemCallback(
    menuRoot: String,
    idx: Int,
    callback: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemCallbackPtr)
  }

  /**
   * Sets the callback of the item at index [idx]. The callback is emitted when an item is hovered.
   *
   * **Note:** The [callback] Callable needs to accept exactly one Variant parameter, the parameter
   * passed to the Callable will be the value passed to the `tag` parameter when the menu item was
   * created.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemHoverCallbacks(
    menuRoot: String,
    idx: Int,
    callback: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemHoverCallbacksPtr)
  }

  /**
   * Sets the callback of the item at index [idx]. Callback is emitted when its accelerator is
   * activated.
   *
   * **Note:** The [keyCallback] Callable needs to accept exactly one Variant parameter, the
   * parameter passed to the Callable will be the value passed to the `tag` parameter when the menu
   * item was created.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemKeyCallback(
    menuRoot: String,
    idx: Int,
    keyCallback: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), CALLABLE to keyCallback)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemKeyCallbackPtr)
  }

  /**
   * Sets the metadata of an item, which may be of any type. You can later get it with
   * [globalMenuGetItemTag], which provides a simple way of assigning context data to items.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemTag(
    menuRoot: String,
    idx: Int,
    tag: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), ANY to tag)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemTagPtr)
  }

  /**
   * Sets the text of the item at index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemText(
    menuRoot: String,
    idx: Int,
    text: String,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), STRING to text)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemTextPtr)
  }

  /**
   * Sets the submenu of the item at index [idx]. The submenu is the ID of a global menu root that
   * would be shown when the item is clicked.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemSubmenu(
    menuRoot: String,
    idx: Int,
    submenu: String,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), STRING to submenu)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemSubmenuPtr)
  }

  /**
   * Sets the accelerator of the item at index [idx]. [keycode] can be a single [Key], or a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemAccelerator(
    menuRoot: String,
    idx: Int,
    keycode: Key,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), LONG to keycode.value)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemAcceleratorPtr)
  }

  /**
   * Enables/disables the item at index [idx]. When it is disabled, it can't be selected and its
   * action can't be invoked.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemDisabled(
    menuRoot: String,
    idx: Int,
    disabled: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), BOOL to disabled)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemDisabledPtr)
  }

  /**
   * Hides/shows the item at index [idx]. When it is hidden, an item does not appear in a menu and
   * its action cannot be invoked.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemHidden(
    menuRoot: String,
    idx: Int,
    hidden: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), BOOL to hidden)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemHiddenPtr)
  }

  /**
   * Sets the [String] tooltip of the item at the specified index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemTooltip(
    menuRoot: String,
    idx: Int,
    tooltip: String,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), STRING to tooltip)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemTooltipPtr)
  }

  /**
   * Sets the state of a multistate item. See [globalMenuAddMultistateItem] for details.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemState(
    menuRoot: String,
    idx: Int,
    state: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), LONG to state.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuSetItemStatePtr)
  }

  /**
   * Sets number of state of a multistate item. See [globalMenuAddMultistateItem] for details.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemMaxStates(
    menuRoot: String,
    idx: Int,
    maxStates: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), LONG to maxStates.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuSetItemMaxStatesPtr)
  }

  /**
   * Replaces the [Texture2D] icon of the specified [idx].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Note:** This method is not supported by macOS "_dock" menu items.
   */
  @JvmStatic
  public final fun globalMenuSetItemIcon(
    menuRoot: String,
    idx: Int,
    icon: Texture2D?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), OBJECT to icon)
    TransferContext.callMethod(MethodBindings.globalMenuSetItemIconPtr)
  }

  /**
   * Sets the horizontal offset of the item at the given [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuSetItemIndentationLevel(
    menuRoot: String,
    idx: Int,
    level: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong(), LONG to level.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuSetItemIndentationLevelPtr)
  }

  /**
   * Returns number of items in the global menu with ID [menuRoot].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetItemCount(menuRoot: String): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot)
    TransferContext.callMethod(MethodBindings.globalMenuGetItemCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes the item at index [idx] from the global menu [menuRoot].
   *
   * **Note:** The indices of items after the removed item will be shifted by one.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuRemoveItem(menuRoot: String, idx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.globalMenuRemoveItemPtr)
  }

  /**
   * Removes all items from the global menu with ID [menuRoot].
   *
   * **Note:** This method is implemented only on macOS.
   *
   * **Supported system menu IDs:**
   *
   * [codeblock lang=text]
   *
   * "_main" - Main menu (macOS).
   *
   * "_dock" - Dock popup menu (macOS).
   *
   * "_apple" - Apple menu (macOS, custom items added before "Services").
   *
   * "_window" - Window menu (macOS, custom items added after "Bring All to Front").
   *
   * "_help" - Help menu (macOS).
   *
   * ```
   */
  @JvmStatic
  public final fun globalMenuClear(menuRoot: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to menuRoot)
    TransferContext.callMethod(MethodBindings.globalMenuClearPtr)
  }

  /**
   * Returns Dictionary of supported system menu IDs and names.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun globalMenuGetSystemMenuRoots(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.globalMenuGetSystemMenuRootsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns `true` if the synthesizer is generating speech, or have utterance waiting in the queue.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmStatic
  public final fun ttsIsSpeaking(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.ttsIsSpeakingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the synthesizer is in a paused state.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmStatic
  public final fun ttsIsPaused(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.ttsIsPausedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns an [VariantArray] of voice information dictionaries.
   *
   * Each [Dictionary] contains two [String] entries:
   *
   * - `name` is voice name.
   *
   * - `id` is voice identifier.
   *
   * - `language` is language code in `lang_Variant` format. The `lang` part is a 2 or 3-letter code
   * based on the ISO-639 standard, in lowercase. The [code skip-lint]Variant[/code] part is an
   * engine-dependent string describing country, region or/and dialect.
   *
   * Note that Godot depends on system libraries for text-to-speech functionality. These libraries
   * are installed by default on Windows and macOS, but not on all Linux distributions. If they are not
   * present, this method will return an empty list. This applies to both Godot users on Linux, as well
   * as end-users on Linux running Godot games that use text-to-speech.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmStatic
  public final fun ttsGetVoices(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.ttsGetVoicesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns a [PackedStringArray] of voice identifiers for the [language].
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmStatic
  public final fun ttsGetVoicesForLanguage(language: String): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to language)
    TransferContext.callMethod(MethodBindings.ttsGetVoicesForLanguagePtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Adds an utterance to the queue. If [interrupt] is `true`, the queue is cleared first.
   *
   * - [voice] identifier is one of the `"id"` values returned by [ttsGetVoices] or one of the
   * values returned by [ttsGetVoicesForLanguage].
   *
   * - [volume] ranges from `0` (lowest) to `100` (highest).
   *
   * - [pitch] ranges from `0.0` (lowest) to `2.0` (highest), `1.0` is default pitch for the current
   * voice.
   *
   * - [rate] ranges from `0.1` (lowest) to `10.0` (highest), `1.0` is a normal speaking rate. Other
   * values act as a percentage relative.
   *
   * - [utteranceId] is passed as a parameter to the callback functions.
   *
   * **Note:** On Windows and Linux (X11/Wayland), utterance [text] can use SSML markup. SSML
   * support is engine and voice dependent. If the engine does not support SSML, you should strip out
   * all XML markup before calling [ttsSpeak].
   *
   * **Note:** The granularity of pitch, rate, and volume is engine and voice dependent. Values may
   * be truncated.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun ttsSpeak(
    text: String,
    voice: String,
    volume: Int = 50,
    pitch: Float = 1.0f,
    rate: Float = 1.0f,
    utteranceId: Long = 0,
    interrupt: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text, STRING to voice, LONG to volume.toLong(), DOUBLE to pitch.toDouble(), DOUBLE to rate.toDouble(), LONG to utteranceId, BOOL to interrupt)
    TransferContext.callMethod(MethodBindings.ttsSpeakPtr)
  }

  /**
   * Puts the synthesizer into a paused state.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmStatic
  public final fun ttsPause(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.ttsPausePtr)
  }

  /**
   * Resumes the synthesizer if it was paused.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmStatic
  public final fun ttsResume(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.ttsResumePtr)
  }

  /**
   * Stops synthesis in progress and removes all utterances from the queue.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmStatic
  public final fun ttsStop(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.ttsStopPtr)
  }

  /**
   * Adds a callback, which is called when the utterance has started, finished, canceled or reached
   * a text boundary.
   *
   * - [TTS_UTTERANCE_STARTED], [TTS_UTTERANCE_ENDED], and [TTS_UTTERANCE_CANCELED] callable's
   * method should take one [Long] parameter, the utterance ID.
   *
   * - [TTS_UTTERANCE_BOUNDARY] callable's method should take two [Long] parameters, the index of
   * the character and the utterance ID.
   *
   * **Note:** The granularity of the boundary callbacks is engine dependent.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux (X11/Wayland), macOS, and
   * Windows.
   */
  @JvmStatic
  public final fun ttsSetUtteranceCallback(event: TTSUtteranceEvent, callable: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to event.value, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.ttsSetUtteranceCallbackPtr)
  }

  /**
   * Returns `true` if OS supports dark mode.
   *
   * **Note:** This method is implemented on Android, iOS, macOS, Windows, and Linux (X11/Wayland).
   */
  @JvmStatic
  public final fun isDarkModeSupported(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDarkModeSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if OS is using dark mode.
   *
   * **Note:** This method is implemented on Android, iOS, macOS, Windows, and Linux (X11/Wayland).
   */
  @JvmStatic
  public final fun isDarkMode(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDarkModePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns OS theme accent color. Returns `Color(0, 0, 0, 0)`, if accent color is unknown.
   *
   * **Note:** This method is implemented on macOS, Windows, Android, and Linux (X11/Wayland).
   */
  @JvmStatic
  public final fun getAccentColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccentColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Returns the OS theme base color (default control background). Returns `Color(0, 0, 0, 0)` if
   * the base color is unknown.
   *
   * **Note:** This method is implemented on macOS, Windows, and Android.
   */
  @JvmStatic
  public final fun getBaseColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBaseColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Sets the callback that should be called when the system's theme settings are changed.
   * [callable] should accept zero arguments.
   *
   * **Note:** This method is implemented on Android, iOS, macOS, Windows, and Linux (X11/Wayland).
   */
  @JvmStatic
  public final fun setSystemThemeChangeCallback(callable: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.setSystemThemeChangeCallbackPtr)
  }

  /**
   * Sets the current mouse mode. See also [mouseGetMode].
   */
  @JvmStatic
  public final fun mouseSetMode(mouseMode: MouseMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mouseMode.value)
    TransferContext.callMethod(MethodBindings.mouseSetModePtr)
  }

  /**
   * Returns the current mouse mode. See also [mouseSetMode].
   */
  @JvmStatic
  public final fun mouseGetMode(): MouseMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.mouseGetModePtr)
    return MouseMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the mouse cursor position to the given [position] relative to an origin at the upper left
   * corner of the currently focused game Window Manager window.
   *
   * **Note:** [warpMouse] is only supported on Windows, macOS, and Linux (X11/Wayland). It has no
   * effect on Android, iOS, and Web.
   */
  @JvmStatic
  public final fun warpMouse(position: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position)
    TransferContext.callMethod(MethodBindings.warpMousePtr)
  }

  /**
   * Returns the mouse cursor's current position in screen coordinates.
   */
  @JvmStatic
  public final fun mouseGetPosition(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.mouseGetPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the current state of mouse buttons (whether each button is pressed) as a bitmask. If
   * multiple mouse buttons are pressed at the same time, the bits are added together. Equivalent to
   * [Input.getMouseButtonMask].
   */
  @JvmStatic
  public final fun mouseGetButtonState(): MouseButtonMask {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.mouseGetButtonStatePtr)
    return MouseButtonMask(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the user's clipboard content to the given string.
   */
  @JvmStatic
  public final fun clipboardSet(clipboard: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to clipboard)
    TransferContext.callMethod(MethodBindings.clipboardSetPtr)
  }

  /**
   * Returns the user's clipboard as a string if possible.
   */
  @JvmStatic
  public final fun clipboardGet(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clipboardGetPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the user's clipboard as an image if possible.
   *
   * **Note:** This method uses the copied pixel data, e.g. from an image editing software or a web
   * browser, not an image file copied from file explorer.
   */
  @JvmStatic
  public final fun clipboardGetImage(): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clipboardGetImagePtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Returns `true` if there is a text content on the user's clipboard.
   */
  @JvmStatic
  public final fun clipboardHas(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clipboardHasPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is an image content on the user's clipboard.
   */
  @JvmStatic
  public final fun clipboardHasImage(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clipboardHasImagePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the user's
   * [url=https://unix.stackexchange.com/questions/139191/whats-the-difference-between-primary-selection-and-clipboard-buffer]primary[/url]
   * clipboard content to the given string. This is the clipboard that is set when the user selects
   * text in any application, rather than when pressing [kbd]Ctrl + C[/kbd]. The clipboard data can
   * then be pasted by clicking the middle mouse button in any application that supports the primary
   * clipboard mechanism.
   *
   * **Note:** This method is only implemented on Linux (X11/Wayland).
   */
  @JvmStatic
  public final fun clipboardSetPrimary(clipboardPrimary: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to clipboardPrimary)
    TransferContext.callMethod(MethodBindings.clipboardSetPrimaryPtr)
  }

  /**
   * Returns the user's
   * [url=https://unix.stackexchange.com/questions/139191/whats-the-difference-between-primary-selection-and-clipboard-buffer]primary[/url]
   * clipboard as a string if possible. This is the clipboard that is set when the user selects text in
   * any application, rather than when pressing [kbd]Ctrl + C[/kbd]. The clipboard data can then be
   * pasted by clicking the middle mouse button in any application that supports the primary clipboard
   * mechanism.
   *
   * **Note:** This method is only implemented on Linux (X11/Wayland).
   */
  @JvmStatic
  public final fun clipboardGetPrimary(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clipboardGetPrimaryPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns an [VariantArray] of [Rect2], each of which is the bounding rectangle for a display
   * cutout or notch. These are non-functional areas on edge-to-edge screens used by cameras and
   * sensors. Returns an empty array if the device does not have cutouts. See also
   * [getDisplaySafeArea].
   *
   * **Note:** Currently only implemented on Android. Other platforms will return an empty array
   * even if they do have display cutouts or notches.
   */
  @JvmStatic
  public final fun getDisplayCutouts(): VariantArray<Rect2> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDisplayCutoutsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Rect2>)
  }

  /**
   * Returns the unobscured area of the display where interactive controls should be rendered. See
   * also [getDisplayCutouts].
   *
   * **Note:** Currently only implemented on Android and iOS. On other platforms,
   * `screen_get_usable_rect(SCREEN_OF_MAIN_WINDOW)` will be returned as a fallback. See also
   * [screenGetUsableRect].
   */
  @JvmStatic
  public final fun getDisplaySafeArea(): Rect2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDisplaySafeAreaPtr)
    return (TransferContext.readReturnValue(RECT2I) as Rect2i)
  }

  /**
   * Returns the number of displays available.
   *
   * **Note:** This method is implemented on Linux (X11 and Wayland), macOS, and Windows. On other
   * platforms, this method always returns `1`.
   */
  @JvmStatic
  public final fun getScreenCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the index of the primary screen.
   *
   * **Note:** This method is implemented on Linux/X11, macOS, and Windows. On other platforms, this
   * method always returns `0`.
   */
  @JvmStatic
  public final fun getPrimaryScreen(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPrimaryScreenPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the index of the screen containing the window with the keyboard focus, or the primary
   * screen if there's no focused window.
   *
   * **Note:** This method is implemented on Linux/X11, macOS, and Windows. On other platforms, this
   * method always returns the primary screen.
   */
  @JvmStatic
  public final fun getKeyboardFocusScreen(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getKeyboardFocusScreenPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the index of the screen that overlaps the most with the given rectangle. Returns
   * [INVALID_SCREEN] if the rectangle doesn't overlap with any screen or has no area.
   */
  @JvmStatic
  public final fun getScreenFromRect(rect: Rect2): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.getScreenFromRectPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the screen's top-left corner position in pixels. Returns [Vector2i.ZERO] if [screen] is
   * invalid. On multi-monitor setups, the screen position is relative to the virtual desktop area. On
   * multi-monitor setups with different screen resolutions or orientations, the origin might be
   * located outside any display like this:
   *
   * [codeblock lang=text]
   *
   * * (0, 0)        +-------+
   *
   *                 |       |
   *
   * +-------------+ |       |
   *
   * |             | |       |
   *
   * |             | |       |
   *
   * +-------------+ +-------+
   *
   * ```
   *
   * See also [screenGetSize].
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenGetPosition(screen: Int = -1): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the screen's size in pixels. See also [screenGetPosition] and [screenGetUsableRect].
   * Returns [Vector2i.ZERO] if [screen] is invalid.
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenGetSize(screen: Int = -1): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the portion of the screen that is not obstructed by a status bar in pixels. See also
   * [screenGetSize].
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   *
   * **Note:** This method is implemented on Linux/X11, macOS, and Windows. On other platforms, this
   * method always returns `Rect2i(screen_get_position(screen), screen_get_size(screen))`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenGetUsableRect(screen: Int = -1): Rect2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetUsableRectPtr)
    return (TransferContext.readReturnValue(RECT2I) as Rect2i)
  }

  /**
   * Returns the dots per inch density of the specified screen. Returns platform specific default
   * value if [screen] is invalid.
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   *
   * **Note:** On macOS, returned value is inaccurate if fractional display scaling mode is used.
   *
   * **Note:** On Android devices, the actual screen densities are grouped into six generalized
   * densities:
   *
   * [codeblock lang=text]
   *
   *    ldpi - 120 dpi
   *
   *    mdpi - 160 dpi
   *
   *    hdpi - 240 dpi
   *
   *   xhdpi - 320 dpi
   *
   *  xxhdpi - 480 dpi
   *
   * xxxhdpi - 640 dpi
   *
   * ```
   *
   * **Note:** This method is implemented on Android, iOS, Linux (X11/Wayland), macOS, Web, and
   * Windows. On other platforms, this method always returns `72`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenGetDpi(screen: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetDpiPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the scale factor of the specified screen by index. Returns `1.0` if [screen] is
   * invalid. See also [screenGetMaxScale].
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   *
   * **Note:** On macOS, the returned value is `2.0` for hiDPI (Retina) screens, and `1.0` for all
   * other cases.
   *
   * **Note:** On Linux (Wayland), the returned value is accurate only when [screen] is
   * [SCREEN_OF_MAIN_WINDOW]. Due to API limitations, passing a direct index will return a rounded-up
   * integer, if the screen has a fractional scale (e.g. `1.25` would get rounded up to `2.0`).
   *
   * **Note:** This method is implemented on Android, iOS, Web, macOS, and Linux (Wayland). On other
   * platforms, this method always returns `1.0`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenGetScale(screen: Int = -1): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns `true` if touch events are available (Android or iOS), the capability is detected on
   * the Web platform or if [ProjectSettings.inputDevices/pointing/emulateTouchFromMouse] is `true`.
   */
  @JvmStatic
  public final fun isTouchscreenAvailable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isTouchscreenAvailablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the greatest scale factor of all screens. See also [screenGetScale].
   *
   * **Note:** On macOS, the returned value is `2.0` if there is at least one hiDPI (Retina) screen
   * in the system, and `1.0` in all other cases.
   */
  @JvmStatic
  public final fun screenGetMaxScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.screenGetMaxScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the current refresh rate of the specified screen. When V-Sync is enabled, this returns
   * the maximum framerate the project can effectively reach. Returns `-1.0` if [screen] is invalid or
   * the [DisplayServer] fails to find the refresh rate for the specified screen.
   *
   * To fallback to a default refresh rate if the method fails, try:
   *
   * ```
   * var refresh_rate = DisplayServer.screen_get_refresh_rate()
   * if refresh_rate < 0:
   * 	refresh_rate = 60.0
   * ```
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   *
   * **Note:** This method is implemented on Android, iOS, macOS, Linux (X11 and Wayland), and
   * Windows. On other platforms, this method always returns `-1.0`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenGetRefreshRate(screen: Int = -1): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetRefreshRatePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the color of the pixel at the given screen [position]. On multi-monitor setups, the
   * screen position is relative to the virtual desktop area.
   *
   * **Note:** This method is implemented on Linux (X11, excluding XWayland), macOS, and Windows. On
   * other platforms, this method always returns `Color(0, 0, 0, 1)`.
   *
   * **Note:** On macOS, this method requires the "Screen Recording" permission. If permission is
   * not granted, this method returns a color from a screenshot that will not include other application
   * windows or OS elements not related to the application.
   */
  @JvmStatic
  public final fun screenGetPixel(position: Vector2i): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position)
    TransferContext.callMethod(MethodBindings.screenGetPixelPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Returns a screenshot of the [screen]. Returns `null` if [screen] is invalid or the
   * [DisplayServer] fails to capture screenshot.
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   *
   * **Note:** This method is implemented on Linux (X11, excluding XWayland), macOS, and Windows. On
   * other platforms, this method always returns `null`.
   *
   * **Note:** On macOS, this method requires the "Screen Recording" permission. If permission is
   * not granted, this method returns a screenshot that will not include other application windows or
   * OS elements not related to the application.
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenGetImage(screen: Int = -1): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetImagePtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Returns a screenshot of the screen region defined by [rect]. Returns `null` if [rect] is
   * outside screen bounds or the [DisplayServer] fails to capture screenshot.
   *
   * **Note:** This method is implemented on macOS and Windows. On other platforms, this method
   * always returns `null`.
   *
   * **Note:** On macOS, this method requires the "Screen Recording" permission. If permission is
   * not granted, this method returns a screenshot that will not include other application windows or
   * OS elements not related to the application.
   */
  @JvmStatic
  public final fun screenGetImageRect(rect: Rect2i): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2I to rect)
    TransferContext.callMethod(MethodBindings.screenGetImageRectPtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Sets the [screen]'s [orientation]. See also [screenGetOrientation].
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   *
   * **Note:** This method is implemented on Android and iOS.
   *
   * **Note:** On iOS, this method has no effect if
   * [ProjectSettings.display/window/handheld/orientation] is not set to [SCREEN_SENSOR].
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenSetOrientation(orientation: ScreenOrientation, screen: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to orientation.value, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenSetOrientationPtr)
  }

  /**
   * Returns the [screen]'s current orientation. See also [screenSetOrientation]. Returns
   * [SCREEN_LANDSCAPE] if [screen] is invalid.
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   *
   * **Note:** This method is implemented on Android and iOS. On other platforms, this method always
   * returns [SCREEN_LANDSCAPE].
   */
  @JvmOverloads
  @JvmStatic
  public final fun screenGetOrientation(screen: Int = -1): ScreenOrientation {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetOrientationPtr)
    return ScreenOrientation.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets whether the screen should never be turned off by the operating system's power-saving
   * measures. See also [screenIsKeptOn].
   */
  @JvmStatic
  public final fun screenSetKeepOn(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.screenSetKeepOnPtr)
  }

  /**
   * Returns `true` if the screen should never be turned off by the operating system's power-saving
   * measures. See also [screenSetKeepOn].
   */
  @JvmStatic
  public final fun screenIsKeptOn(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.screenIsKeptOnPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the list of Godot window IDs belonging to this process.
   *
   * **Note:** Native dialogs are not included in this list.
   */
  @JvmStatic
  public final fun getWindowList(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWindowListPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns the ID of the window at the specified screen [position] (in pixels). On multi-monitor
   * setups, the screen position is relative to the virtual desktop area. On multi-monitor setups with
   * different screen resolutions or orientations, the origin may be located outside any display like
   * this:
   *
   * [codeblock lang=text]
   *
   * * (0, 0)        +-------+
   *
   *                 |       |
   *
   * +-------------+ |       |
   *
   * |             | |       |
   *
   * |             | |       |
   *
   * +-------------+ +-------+
   *
   * ```
   */
  @JvmStatic
  public final fun getWindowAtScreenPosition(position: Vector2i): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position)
    TransferContext.callMethod(MethodBindings.getWindowAtScreenPositionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns internal structure pointers for use in plugins.
   *
   * **Note:** This method is implemented on Android, Linux (X11/Wayland), macOS, and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetNativeHandle(handleType: HandleType, windowId: Int = 0): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to handleType.value, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetNativeHandlePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns ID of the active popup window, or [INVALID_WINDOW_ID] if there is none.
   */
  @JvmStatic
  public final fun windowGetActivePopup(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.windowGetActivePopupPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the bounding box of control, or menu item that was used to open the popup window, in the
   * screen coordinate system. Clicking this area will not auto-close this popup.
   */
  @JvmStatic
  public final fun windowSetPopupSafeRect(window: Int, rect: Rect2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to window.toLong(), RECT2I to rect)
    TransferContext.callMethod(MethodBindings.windowSetPopupSafeRectPtr)
  }

  /**
   * Returns the bounding box of control, or menu item that was used to open the popup window, in
   * the screen coordinate system.
   */
  @JvmStatic
  public final fun windowGetPopupSafeRect(window: Int): Rect2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to window.toLong())
    TransferContext.callMethod(MethodBindings.windowGetPopupSafeRectPtr)
    return (TransferContext.readReturnValue(RECT2I) as Rect2i)
  }

  /**
   * Sets the title of the given window to [title].
   *
   * **Note:** It's recommended to change this value using [Window.title] instead.
   *
   * **Note:** Avoid changing the window title every frame, as this can cause performance issues on
   * certain window managers. Try to change the window title only a few times per second at most.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetTitle(title: String, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to title, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetTitlePtr)
  }

  /**
   * Returns the estimated window title bar size (including text and window buttons) for the window
   * specified by [windowId] (in pixels). This method does not change the window title.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetTitleSize(title: String, windowId: Int = 0): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to title, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetTitleSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Sets a polygonal region of the window which accepts mouse events. Mouse events outside the
   * region will be passed through.
   *
   * Passing an empty array will disable passthrough support (all mouse events will be intercepted
   * by the window, which is the default behavior).
   *
   * ```gdscript
   * //gdscript
   * # Set region, using Path2D node.
   * DisplayServer.window_set_mouse_passthrough($Path2D.curve.get_baked_points())
   *
   * # Set region, using Polygon2D node.
   * DisplayServer.window_set_mouse_passthrough($Polygon2D.polygon)
   *
   * # Reset region to default.
   * DisplayServer.window_set_mouse_passthrough([])
   * ```
   *
   * ```csharp
   * //csharp
   * // Set region, using Path2D node.
   * DisplayServer.WindowSetMousePassthrough(GetNode<Path2D>("Path2D").Curve.GetBakedPoints());
   *
   * // Set region, using Polygon2D node.
   * DisplayServer.WindowSetMousePassthrough(GetNode<Polygon2D>("Polygon2D").Polygon);
   *
   * // Reset region to default.
   * DisplayServer.WindowSetMousePassthrough([]);
   * ```
   *
   * **Note:** On Windows, the portion of a window that lies outside the region is not drawn, while
   * on Linux (X11) and macOS it is.
   *
   * **Note:** This method is implemented on Linux (X11), macOS and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetMousePassthrough(region: PackedVector2Array, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to region, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetMousePassthroughPtr)
  }

  /**
   * Returns the screen the window specified by [windowId] is currently positioned on. If the screen
   * overlaps multiple displays, the screen where the window's center is located is returned. See also
   * [windowSetCurrentScreen]. Returns [INVALID_SCREEN] if [windowId] is invalid.
   *
   * **Note:** This method is implemented on Linux/X11, macOS, and Windows. On other platforms, this
   * method always returns `0`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetCurrentScreen(windowId: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetCurrentScreenPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Moves the window specified by [windowId] to the specified [screen]. See also
   * [windowGetCurrentScreen].
   *
   * **Note:** One of the following constants can be used as [screen]: [SCREEN_OF_MAIN_WINDOW],
   * [SCREEN_PRIMARY], [SCREEN_WITH_MOUSE_FOCUS], or [SCREEN_WITH_KEYBOARD_FOCUS].
   *
   * **Note:** This method is implemented on Linux/X11, macOS, and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetCurrentScreen(screen: Int, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong(), LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetCurrentScreenPtr)
  }

  /**
   * Returns the position of the client area of the given window on the screen.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetPosition(windowId: Int = 0): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the position of the given window on the screen including the borders drawn by the
   * operating system. See also [windowGetPosition].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetPositionWithDecorations(windowId: Int = 0): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetPositionWithDecorationsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Sets the position of the given window to [position]. On multi-monitor setups, the screen
   * position is relative to the virtual desktop area. On multi-monitor setups with different screen
   * resolutions or orientations, the origin may be located outside any display like this:
   *
   * [codeblock lang=text]
   *
   * * (0, 0)        +-------+
   *
   *                 |       |
   *
   * +-------------+ |       |
   *
   * |             | |       |
   *
   * |             | |       |
   *
   * +-------------+ +-------+
   *
   * ```
   *
   * See also [windowGetPosition] and [windowSetSize].
   *
   * **Note:** It's recommended to change this value using [Window.position] instead.
   *
   * **Note:** On Linux (Wayland): this method is a no-op.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetPosition(position: Vector2i, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetPositionPtr)
  }

  /**
   * Returns the size of the window specified by [windowId] (in pixels), excluding the borders drawn
   * by the operating system. This is also called the "client area". See also
   * [windowGetSizeWithDecorations], [windowSetSize] and [windowGetPosition].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetSize(windowId: Int = 0): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Sets the size of the given window to [size] (in pixels). See also [windowGetSize] and
   * [windowGetPosition].
   *
   * **Note:** It's recommended to change this value using [Window.size] instead.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetSize(size: Vector2i, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to size, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetSizePtr)
  }

  /**
   * Sets the [callback] that will be called when the window specified by [windowId] is moved or
   * resized.
   *
   * **Warning:** Advanced users only! Adding such a callback to a [Window] node will override its
   * default implementation, which can introduce bugs.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetRectChangedCallback(callback: Callable, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callback, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetRectChangedCallbackPtr)
  }

  /**
   * Sets the [callback] that will be called when an event occurs in the window specified by
   * [windowId].
   *
   * **Warning:** Advanced users only! Adding such a callback to a [Window] node will override its
   * default implementation, which can introduce bugs.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetWindowEventCallback(callback: Callable, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callback, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetWindowEventCallbackPtr)
  }

  /**
   * Sets the [callback] that should be called when any [InputEvent] is sent to the window specified
   * by [windowId].
   *
   * **Warning:** Advanced users only! Adding such a callback to a [Window] node will override its
   * default implementation, which can introduce bugs.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetInputEventCallback(callback: Callable, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callback, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetInputEventCallbackPtr)
  }

  /**
   * Sets the [callback] that should be called when text is entered using the virtual keyboard to
   * the window specified by [windowId].
   *
   * **Warning:** Advanced users only! Adding such a callback to a [Window] node will override its
   * default implementation, which can introduce bugs.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetInputTextCallback(callback: Callable, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callback, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetInputTextCallbackPtr)
  }

  /**
   * Sets the [callback] that should be called when files are dropped from the operating system's
   * file manager to the window specified by [windowId]. [callback] should take one [PackedStringArray]
   * argument, which is the list of dropped files.
   *
   * **Warning:** Advanced users only! Adding such a callback to a [Window] node will override its
   * default implementation, which can introduce bugs.
   *
   * **Note:** This method is implemented on Windows, macOS, Linux (X11/Wayland), and Web.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetDropFilesCallback(callback: Callable, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callback, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetDropFilesCallbackPtr)
  }

  /**
   * Returns the [Object.getInstanceId] of the [Window] the [windowId] is attached to.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetAttachedInstanceId(windowId: Int = 0): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetAttachedInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the window's maximum size (in pixels). See also [windowSetMaxSize].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetMaxSize(windowId: Int = 0): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetMaxSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Sets the maximum size of the window specified by [windowId] in pixels. Normally, the user will
   * not be able to drag the window to make it larger than the specified size. See also
   * [windowGetMaxSize].
   *
   * **Note:** It's recommended to change this value using [Window.maxSize] instead.
   *
   * **Note:** Using third-party tools, it is possible for users to disable window geometry
   * restrictions and therefore bypass this limit.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetMaxSize(maxSize: Vector2i, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to maxSize, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetMaxSizePtr)
  }

  /**
   * Returns the window's minimum size (in pixels). See also [windowSetMinSize].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetMinSize(windowId: Int = 0): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetMinSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Sets the minimum size for the given window to [minSize] in pixels. Normally, the user will not
   * be able to drag the window to make it smaller than the specified size. See also
   * [windowGetMinSize].
   *
   * **Note:** It's recommended to change this value using [Window.minSize] instead.
   *
   * **Note:** By default, the main window has a minimum size of `Vector2i(64, 64)`. This prevents
   * issues that can arise when the window is resized to a near-zero size.
   *
   * **Note:** Using third-party tools, it is possible for users to disable window geometry
   * restrictions and therefore bypass this limit.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetMinSize(minSize: Vector2i, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to minSize, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetMinSizePtr)
  }

  /**
   * Returns the size of the window specified by [windowId] (in pixels), including the borders drawn
   * by the operating system. See also [windowGetSize].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetSizeWithDecorations(windowId: Int = 0): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetSizeWithDecorationsPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the mode of the given window.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetMode(windowId: Int = 0): WindowMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetModePtr)
    return WindowMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets window mode for the given window to [mode].
   *
   * **Note:** On Android, setting it to [WINDOW_MODE_FULLSCREEN] or
   * [WINDOW_MODE_EXCLUSIVE_FULLSCREEN] will enable immersive mode.
   *
   * **Note:** Setting the window to full screen forcibly sets the borderless flag to `true`, so
   * make sure to set it back to `false` when not wanted.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetMode(mode: WindowMode, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetModePtr)
  }

  /**
   * Enables or disables the given window's given [flag].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetFlag(
    flag: WindowFlags,
    enabled: Boolean,
    windowId: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value, BOOL to enabled, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetFlagPtr)
  }

  /**
   * Returns the current value of the given window's [flag].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetFlag(flag: WindowFlags, windowId: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the window icon (usually displayed in the top-left corner) for the window specified by
   * [windowId].
   *
   * **Note:** This method is implemented on Linux and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetIcon(icon: Image?, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to icon, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetIconPtr)
  }

  /**
   * When [WINDOW_FLAG_EXTEND_TO_TITLE] flag is set, set offset to the center of the first titlebar
   * button.
   *
   * **Note:** This flag is implemented only on macOS.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetWindowButtonsOffset(offset: Vector2i, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to offset, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetWindowButtonsOffsetPtr)
  }

  /**
   * Returns left margins (`x`), right margins (`y`) and height (`z`) of the title that are safe to
   * use (contains no buttons or other elements) when [WINDOW_FLAG_EXTEND_TO_TITLE] flag is set.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetSafeTitleMargins(windowId: Int = 0): Vector3i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetSafeTitleMarginsPtr)
    return (TransferContext.readReturnValue(VECTOR3I) as Vector3i)
  }

  /**
   * Makes the window specified by [windowId] request attention, which is materialized by the window
   * title and taskbar entry blinking until the window is focused. This usually has no visible effect
   * if the window is currently focused. The exact behavior varies depending on the operating system.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowRequestAttention(windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowRequestAttentionPtr)
  }

  /**
   * Creates a progress bar on the taskbar/dock icon of the window specified by [windowId] if it
   * does not exist, sets the progress of the icon.
   *
   * [value] acts as a relative percentage value, ranges from `0.0` (lowest) to `1.0` (highest).
   *
   * **Note:** This method is implemented only on Windows and macOS.
   *
   * **Note:** On macOS, the progress bar is displayed only for the main window.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetTaskbarProgressValue(`value`: Float, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value.toDouble(), LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetTaskbarProgressValuePtr)
  }

  /**
   * Sets the type and state of the progress bar on the taskbar/dock icon of the window specified by
   * [windowId]. See [ProgressState] for possible values and how each mode behaves.
   *
   * **Note:** This method is implemented only on Windows and macOS.
   *
   * **Note:** On macOS, the progress bar is displayed only for the main window.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetTaskbarProgressState(state: ProgressState, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to state.value, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetTaskbarProgressStatePtr)
  }

  /**
   * Moves the window specified by [windowId] to the foreground, so that it is visible over other
   * windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowMoveToForeground(windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowMoveToForegroundPtr)
  }

  /**
   * Returns `true` if the window specified by [windowId] is focused.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowIsFocused(windowId: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowIsFocusedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if anything can be drawn in the window specified by [windowId], `false`
   * otherwise. Using the `--disable-render-loop` command line argument or a headless build will return
   * `false`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowCanDraw(windowId: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowCanDrawPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets window transient parent. Transient window will be destroyed with its transient parent and
   * will return focus to their parent when closed. The transient window is displayed on top of a
   * non-exclusive full-screen parent window. Transient windows can't enter full-screen mode.
   *
   * **Note:** It's recommended to change this value using [Window.transient] instead.
   *
   * **Note:** The behavior might be different depending on the platform.
   */
  @JvmStatic
  public final fun windowSetTransient(windowId: Int, parentWindowId: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong(), LONG to parentWindowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetTransientPtr)
  }

  /**
   * If set to `true`, this window will always stay on top of its parent window, parent window will
   * ignore input while this window is opened.
   *
   * **Note:** On macOS, exclusive windows are confined to the same space (virtual desktop or
   * screen) as the parent window.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun windowSetExclusive(windowId: Int, exclusive: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong(), BOOL to exclusive)
    TransferContext.callMethod(MethodBindings.windowSetExclusivePtr)
  }

  /**
   * Sets whether [url=https://en.wikipedia.org/wiki/Input_method]Input Method Editor[/url] should
   * be enabled for the window specified by [windowId]. See also [windowSetImePosition].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetImeActive(active: Boolean, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to active, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetImeActivePtr)
  }

  /**
   * Sets the position of the [url=https://en.wikipedia.org/wiki/Input_method]Input Method
   * Editor[/url] popup for the specified [windowId]. Only effective if [windowSetImeActive] was set to
   * `true` for the specified [windowId].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetImePosition(position: Vector2i, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetImePositionPtr)
  }

  /**
   * Sets the V-Sync mode of the given window. See also
   * [ProjectSettings.display/window/vsync/vsyncMode].
   *
   * Depending on the platform and used renderer, the engine will fall back to [VSYNC_ENABLED] if
   * the desired mode is not supported.
   *
   * **Note:** V-Sync modes other than [VSYNC_ENABLED] are only supported in the Forward+ and Mobile
   * rendering methods, not Compatibility.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetVsyncMode(vsyncMode: VSyncMode, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to vsyncMode.value, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetVsyncModePtr)
  }

  /**
   * Returns the V-Sync mode of the given window.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetVsyncMode(windowId: Int = 0): VSyncMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetVsyncModePtr)
    return VSyncMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the window specified by [windowId] supports HDR output. This depends on the
   * platform, screen capabilities, system settings, and the screen the window is currently on.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowIsHdrOutputSupported(windowId: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowIsHdrOutputSupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If [enable] is `true`, HDR output is requested for the window specified by [windowId]. The
   * window will automatically switch between HDR and SDR if it is moved between screens, screen
   * capabilities change, or system settings are modified. This will internally force
   * [Viewport.useHdr2d] to be enabled on the main [Viewport]. All other [SubViewport] of the [Window]
   * must have their [Viewport.useHdr2d] property enabled to produce HDR output. Corresponds to
   * [Window.hdrOutputRequested].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowRequestHdrOutput(enable: Boolean, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowRequestHdrOutputPtr)
  }

  /**
   * Returns `true` if HDR output is requested for the window specified by [windowId]. Corresponds
   * to [Window.hdrOutputRequested].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowIsHdrOutputRequested(windowId: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowIsHdrOutputRequestedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if HDR output is currently enabled for the window specified by [windowId]. The
   * returned value may change dynamically based on system settings, screen capabilities, and which
   * screen the window is currently on.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowIsHdrOutputEnabled(windowId: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowIsHdrOutputEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the reference white luminance in nits (cd/m²) for HDR output by the window specified by
   * [windowId]. If [referenceLuminance] is negative, the window automatically adjusts to the
   * brightness set by the operating system. By default, this luminance is set to `-1.0` for every
   * window. Typically this property should be left at this default value, but may optionally be
   * exposed as an "HDR Brightness" in-game setting to allow the player to adjust the brightness of
   * their game, independently of their device settings. See also
   * [windowGetHdrOutputCurrentReferenceLuminance] and [windowGetHdrOutputReferenceLuminance].
   *
   * **Note:** This method is only implemented on Windows. Other platforms will always use the
   * reference luminance that is reported by the operating system.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetHdrOutputReferenceLuminance(referenceLuminance: Float, windowId: Int =
      0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to referenceLuminance.toDouble(), LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetHdrOutputReferenceLuminancePtr)
  }

  /**
   * Returns the reference white luminance in nits (cd/m²) set for HDR output by the window
   * specified by [windowId]. Negative values indicate that the value is being automatically adjusted
   * to match the operating system brightness. See also [windowGetHdrOutputCurrentReferenceLuminance].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetHdrOutputReferenceLuminance(windowId: Int = 0): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetHdrOutputReferenceLuminancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * When [windowIsHdrOutputEnabled] returns `true`, this returns the current reference white
   * luminance in nits (cd/m²) for HDR output by the window specified by [windowId]. If the reference
   * luminance is being automatically adjusted to match the operating system brightness, this will
   * return that value. Otherwise, it will return the value set by
   * [windowSetHdrOutputReferenceLuminance]. This reference luminance value is used when calculating
   * [windowGetOutputMaxLinearValue].
   *
   * **Note:** This reference white luminance may not match the physical behavior of the screen, but
   * will always be proportionally correct relative to [windowGetHdrOutputCurrentMaxLuminance].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetHdrOutputCurrentReferenceLuminance(windowId: Int = 0): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetHdrOutputCurrentReferenceLuminancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the maximum luminance in nits (cd/m²) for HDR output by the window specified by
   * [windowId]. If [maxLuminance] is negative, the window uses the screen's maximum luminance that is
   * reported by the operating system. By default, this luminance is set to `-1.0` for every window.
   * Typically this property should be left at this default value, but may optionally be exposed
   * through in-game settings to allow the player to correct an inaccurate maximum luminance reported
   * by the operating system. See also [windowGetHdrOutputCurrentMaxLuminance] and
   * [windowGetHdrOutputMaxLuminance].
   *
   * **Note:** This method is only implemented on macOS and Windows. Other platforms will always use
   * the screen's maximum luminance that is reported by the operating system.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowSetHdrOutputMaxLuminance(maxLuminance: Float, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to maxLuminance.toDouble(), LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowSetHdrOutputMaxLuminancePtr)
  }

  /**
   * Returns the maximum luminance in nits (cd/m²) set for HDR output by the window specified by
   * [windowId]. Negative values indicate that the value is being automatically adjusted based on the
   * screen's capabilities. See also [windowGetHdrOutputCurrentMaxLuminance].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetHdrOutputMaxLuminance(windowId: Int = 0): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetHdrOutputMaxLuminancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * When [windowIsHdrOutputEnabled] returns `true`, this returns the current maximum luminance in
   * nits (cd/m²) for HDR output by the window specified by [windowId]. If the maximum luminance is
   * being automatically adjusted based on the screen's capabilities, this method will return that
   * value. Otherwise, it will return the value set by [windowSetHdrOutputMaxLuminance]. This maximum
   * luminance value is used when calculating [windowGetOutputMaxLinearValue].
   *
   * **Note:** This maximum luminance may not match the physical behavior of the screen, but will
   * always be proportionally correct relative to [windowGetHdrOutputCurrentReferenceLuminance].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetHdrOutputCurrentMaxLuminance(windowId: Int = 0): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetHdrOutputCurrentMaxLuminancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the maximum value for linear color components that can be displayed for the window
   * specified by [windowId], regardless of SDR or HDR output. Returns `1.0` if HDR is not enabled or
   * not supported. When HDR output is enabled, this is calculated based on
   * [windowGetHdrOutputCurrentReferenceLuminance] and [windowGetHdrOutputCurrentMaxLuminance]. The
   * [signal Window.output_max_linear_value_changed] signal will be emitted whenever this value
   * changes. This value is used by tonemapping and other [Environment] effects to ensure that bright
   * colors are presented in the range that can be displayed by this window. Corresponds to
   * [Window.getOutputMaxLinearValue].
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowGetOutputMaxLinearValue(windowId: Int = 0): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowGetOutputMaxLinearValuePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns `true` if the given window can be maximized (the maximize button is enabled).
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowIsMaximizeAllowed(windowId: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowIsMaximizeAllowedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if double-clicking on a window's title should maximize it.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun windowMaximizeOnTitleDblClick(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.windowMaximizeOnTitleDblClickPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if double-clicking on a window's title should minimize it.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun windowMinimizeOnTitleDblClick(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.windowMinimizeOnTitleDblClickPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Starts an interactive drag operation on the window with the given [windowId], using the current
   * mouse position. Call this method when handling a mouse button being pressed to simulate a pressed
   * event on the window's title bar. Using this method allows the window to participate in space
   * switching, tiling, and other system features.
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS, and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowStartDrag(windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowStartDragPtr)
  }

  /**
   * Starts an interactive resize operation on the window with the given [windowId], using the
   * current mouse position. Call this method when handling a mouse button being pressed to simulate a
   * pressed event on the window's edge.
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS, and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun windowStartResize(edge: WindowResizeEdge, windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to edge.value, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.windowStartResizePtr)
  }

  /**
   * Sets the background color of the root window.
   *
   * **Note:** This method is implemented only on Android.
   */
  @JvmStatic
  public final fun windowSetColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.windowSetColorPtr)
  }

  /**
   * Returns `1` if a high-contrast user interface theme should be used, `0` otherwise. Returns `-1`
   * if status is unknown.
   *
   * **Note:** This method is implemented on Linux (X11/Wayland, GNOME), macOS, and Windows.
   */
  @JvmStatic
  public final fun accessibilityShouldIncreaseContrast(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.accessibilityShouldIncreaseContrastPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `1` if flashing, blinking, and other moving content that can cause seizures in users
   * with photosensitive epilepsy should be disabled, `0` otherwise. Returns `-1` if status is unknown.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun accessibilityShouldReduceAnimation(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.accessibilityShouldReduceAnimationPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `1` if background images, transparency, and other features that can reduce the contrast
   * between the foreground and background should be disabled, `0` otherwise. Returns `-1` if status is
   * unknown.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun accessibilityShouldReduceTransparency(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.accessibilityShouldReduceTransparencyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `1` if a screen reader, Braille display or other assistive app is active, `0`
   * otherwise. Returns `-1` if status is unknown.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   *
   * **Note:** Accessibility debugging tools, such as Accessibility Insights for Windows,
   * Accessibility Inspector (macOS), or AT-SPI Browser (Linux/BSD), do not count as assistive apps and
   * will not affect this value. To test your project with these tools, set
   * [ProjectSettings.accessibility/general/accessibilitySupport] to `1`.
   */
  @JvmStatic
  public final fun accessibilityScreenReaderActive(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.accessibilityScreenReaderActivePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Creates a new, empty accessibility element resource.
   *
   * **Note:** An accessibility element is created and freed automatically for each [Node]. In
   * general, this function should not be called manually.
   */
  @JvmStatic
  public final fun accessibilityCreateElement(windowId: Int, role: AccessibilityRole): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong(), LONG to role.value)
    TransferContext.callMethod(MethodBindings.accessibilityCreateElementPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new, empty accessibility sub-element resource. Sub-elements can be used to provide
   * accessibility information for objects which are not [Node]s, such as list items, table cells, or
   * menu items. Sub-elements are freed automatically when the parent element is freed, or can be freed
   * early using the [accessibilityFreeElement] method.
   */
  @JvmOverloads
  @JvmStatic
  public final fun accessibilityCreateSubElement(
    parentRid: RID,
    role: AccessibilityRole,
    insertPos: Int = -1,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to parentRid, LONG to role.value, LONG to insertPos.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityCreateSubElementPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new, empty accessibility sub-element from the shaped text buffer. Sub-elements are
   * freed automatically when the parent element is freed, or can be freed early using the
   * [accessibilityFreeElement] method.
   *
   * If [isLastLine] is `true`, no trailing newline is appended to the text content. Set to `true`
   * for the last line in multi-line text fields and for single-line text fields.
   */
  @JvmOverloads
  @JvmStatic
  public final fun accessibilityCreateSubTextEditElements(
    parentRid: RID,
    shapedText: RID,
    minHeight: Float,
    insertPos: Int = -1,
    isLastLine: Boolean = false,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to parentRid, _RID to shapedText, DOUBLE to minHeight.toDouble(), LONG to insertPos.toLong(), BOOL to isLastLine)
    TransferContext.callMethod(MethodBindings.accessibilityCreateSubTextEditElementsPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns `true` if [id] is a valid accessibility element.
   */
  @JvmStatic
  public final fun accessibilityHasElement(id: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id)
    TransferContext.callMethod(MethodBindings.accessibilityHasElementPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Frees the accessibility element [id] created by [accessibilityCreateElement],
   * [accessibilityCreateSubElement], or [accessibilityCreateSubTextEditElements].
   */
  @JvmStatic
  public final fun accessibilityFreeElement(id: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id)
    TransferContext.callMethod(MethodBindings.accessibilityFreeElementPtr)
  }

  /**
   * Sets the metadata of the accessibility element [id] to [meta].
   */
  @JvmStatic
  public final fun accessibilityElementSetMeta(id: RID, meta: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, ANY to meta)
    TransferContext.callMethod(MethodBindings.accessibilityElementSetMetaPtr)
  }

  /**
   * Returns the metadata of the accessibility element [id].
   */
  @JvmStatic
  public final fun accessibilityElementGetMeta(id: RID): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id)
    TransferContext.callMethod(MethodBindings.accessibilityElementGetMetaPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sets window outer (with decorations) and inner (without decorations) bounds for assistive apps.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   *
   * **Note:** Advanced users only! [Window] objects call this method automatically.
   */
  @JvmStatic
  public final fun accessibilitySetWindowRect(
    windowId: Int,
    rectOut: Rect2,
    rectIn: Rect2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong(), RECT2 to rectOut, RECT2 to rectIn)
    TransferContext.callMethod(MethodBindings.accessibilitySetWindowRectPtr)
  }

  /**
   * Sets the window focused state for assistive apps.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   *
   * **Note:** Advanced users only! [Window] objects call this method automatically.
   */
  @JvmStatic
  public final fun accessibilitySetWindowFocused(windowId: Int, focused: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong(), BOOL to focused)
    TransferContext.callMethod(MethodBindings.accessibilitySetWindowFocusedPtr)
  }

  /**
   * Sets currently focused element.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetFocus(id: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetFocusPtr)
  }

  /**
   * Returns the main accessibility element of the OS native window.
   */
  @JvmStatic
  public final fun accessibilityGetWindowRoot(windowId: Int): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityGetWindowRootPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets element accessibility role.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetRole(id: RID, role: AccessibilityRole): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to role.value)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetRolePtr)
  }

  /**
   * Sets element accessibility name.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetName(id: RID, name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to name)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetNamePtr)
  }

  /**
   * Sets element accessibility extra information added to the element name.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetExtraInfo(id: RID, name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to name)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetExtraInfoPtr)
  }

  /**
   * Sets element accessibility description.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetDescription(id: RID, description: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to description)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetDescriptionPtr)
  }

  /**
   * Sets element text value.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetValue(id: RID, `value`: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to value)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetValuePtr)
  }

  /**
   * Sets tooltip text.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTooltip(id: RID, tooltip: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to tooltip)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTooltipPtr)
  }

  /**
   * Sets element bounding box, relative to the node position.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetBounds(id: RID, rect: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetBoundsPtr)
  }

  /**
   * Sets element 2D transform.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTransform(id: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTransformPtr)
  }

  /**
   * Adds a child accessibility element.
   *
   * **Note:** [Node] children and sub-elements are added to the child list automatically.
   */
  @JvmStatic
  public final fun accessibilityUpdateAddChild(id: RID, childId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to childId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddChildPtr)
  }

  /**
   * Adds an element that is controlled by this element.
   */
  @JvmStatic
  public final fun accessibilityUpdateAddRelatedControls(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to relatedId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddRelatedControlsPtr)
  }

  /**
   * Adds an element that details this element.
   */
  @JvmStatic
  public final fun accessibilityUpdateAddRelatedDetails(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to relatedId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddRelatedDetailsPtr)
  }

  /**
   * Adds an element that describes this element.
   */
  @JvmStatic
  public final fun accessibilityUpdateAddRelatedDescribedBy(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to relatedId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddRelatedDescribedByPtr)
  }

  /**
   * Adds an element that this element flow into.
   */
  @JvmStatic
  public final fun accessibilityUpdateAddRelatedFlowTo(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to relatedId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddRelatedFlowToPtr)
  }

  /**
   * Adds an element that labels this element.
   */
  @JvmStatic
  public final fun accessibilityUpdateAddRelatedLabeledBy(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to relatedId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddRelatedLabeledByPtr)
  }

  /**
   * Adds an element that is part of the same radio group.
   *
   * **Note:** This method should be called on each element of the group, using all other elements
   * as [relatedId].
   */
  @JvmStatic
  public final fun accessibilityUpdateAddRelatedRadioGroup(id: RID, relatedId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to relatedId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddRelatedRadioGroupPtr)
  }

  /**
   * Adds an element that is an active descendant of this element.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetActiveDescendant(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to otherId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetActiveDescendantPtr)
  }

  /**
   * Sets next element on the line.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetNextOnLine(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to otherId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetNextOnLinePtr)
  }

  /**
   * Sets previous element on the line.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetPreviousOnLine(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to otherId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetPreviousOnLinePtr)
  }

  /**
   * Sets the element to be a member of the group.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetMemberOf(id: RID, groupId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to groupId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetMemberOfPtr)
  }

  /**
   * Sets target element for the link.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetInPageLinkTarget(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to otherId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetInPageLinkTargetPtr)
  }

  /**
   * Sets an element which contains an error message for this element.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetErrorMessage(id: RID, otherId: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to otherId)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetErrorMessagePtr)
  }

  /**
   * Sets the priority of the live region updates.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetLive(id: RID, live: AccessibilityLiveMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to live.value)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetLivePtr)
  }

  /**
   * Adds a callback for the accessibility action (action which can be performed by using a special
   * screen reader command or buttons on the Braille display), and marks this action as supported. The
   * action callback receives one [Any] argument, which value depends on action type.
   */
  @JvmStatic
  public final fun accessibilityUpdateAddAction(
    id: RID,
    action: AccessibilityAction,
    callable: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to action.value, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddActionPtr)
  }

  /**
   * Adds support for a custom accessibility action. [actionId] is passed as an argument to the
   * callback of [ACTION_CUSTOM] action.
   */
  @JvmStatic
  public final fun accessibilityUpdateAddCustomAction(
    id: RID,
    actionId: Int,
    actionDescription: String,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to actionId.toLong(), STRING to actionDescription)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateAddCustomActionPtr)
  }

  /**
   * Sets number of rows in the table.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTableRowCount(id: RID, count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTableRowCountPtr)
  }

  /**
   * Sets number of columns in the table.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTableColumnCount(id: RID, count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTableColumnCountPtr)
  }

  /**
   * Sets position of the row in the table.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTableRowIndex(id: RID, index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTableRowIndexPtr)
  }

  /**
   * Sets position of the column.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTableColumnIndex(id: RID, index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTableColumnIndexPtr)
  }

  /**
   * Sets cell position in the table.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTableCellPosition(
    id: RID,
    rowIndex: Int,
    columnIndex: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to rowIndex.toLong(), LONG to columnIndex.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTableCellPositionPtr)
  }

  /**
   * Sets cell row/column span.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTableCellSpan(
    id: RID,
    rowSpan: Int,
    columnSpan: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to rowSpan.toLong(), LONG to columnSpan.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTableCellSpanPtr)
  }

  /**
   * Sets number of items in the list.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetListItemCount(id: RID, size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetListItemCountPtr)
  }

  /**
   * Sets the position of the element in the list.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetListItemIndex(id: RID, index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetListItemIndexPtr)
  }

  /**
   * Sets the hierarchical level of the element in the list.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetListItemLevel(id: RID, level: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to level.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetListItemLevelPtr)
  }

  /**
   * Sets list/tree item selected status.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetListItemSelected(id: RID, selected: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, BOOL to selected)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetListItemSelectedPtr)
  }

  /**
   * Sets list/tree item expanded status.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetListItemExpanded(id: RID, expanded: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, BOOL to expanded)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetListItemExpandedPtr)
  }

  /**
   * Sets popup type for popup buttons.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetPopupType(id: RID, popup: AccessibilityPopupType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to popup.value)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetPopupTypePtr)
  }

  /**
   * Sets element checked state.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetChecked(id: RID, checekd: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, BOOL to checekd)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetCheckedPtr)
  }

  /**
   * Sets numeric value.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetNumValue(id: RID, position: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, DOUBLE to position)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetNumValuePtr)
  }

  /**
   * Sets numeric value range.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetNumRange(
    id: RID,
    min: Double,
    max: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, DOUBLE to min, DOUBLE to max)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetNumRangePtr)
  }

  /**
   * Sets numeric value step.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetNumStep(id: RID, step: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, DOUBLE to step)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetNumStepPtr)
  }

  /**
   * Sets numeric value jump.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetNumJump(id: RID, jump: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, DOUBLE to jump)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetNumJumpPtr)
  }

  /**
   * Sets scroll bar x position.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetScrollX(id: RID, position: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, DOUBLE to position)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetScrollXPtr)
  }

  /**
   * Sets scroll bar x range.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetScrollXRange(
    id: RID,
    min: Double,
    max: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, DOUBLE to min, DOUBLE to max)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetScrollXRangePtr)
  }

  /**
   * Sets scroll bar y position.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetScrollY(id: RID, position: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, DOUBLE to position)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetScrollYPtr)
  }

  /**
   * Sets scroll bar y range.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetScrollYRange(
    id: RID,
    min: Double,
    max: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, DOUBLE to min, DOUBLE to max)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetScrollYRangePtr)
  }

  /**
   * Sets text underline/overline/strikethrough.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTextDecorations(
    id: RID,
    underline: Boolean,
    strikethrough: Boolean,
    overline: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, BOOL to underline, BOOL to strikethrough, BOOL to overline)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTextDecorationsPtr)
  }

  /**
   * Sets element text alignment.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTextAlign(id: RID, align: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to align.value)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTextAlignPtr)
  }

  /**
   * Sets text selection to the text field. [textStartId] and [textEndId] should be elements created
   * by [accessibilityCreateSubTextEditElements]. Character offsets are relative to the corresponding
   * element.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTextSelection(
    id: RID,
    textStartId: RID,
    startChar: Int,
    textEndId: RID,
    endChar: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, _RID to textStartId, LONG to startChar.toLong(), _RID to textEndId, LONG to endChar.toLong())
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTextSelectionPtr)
  }

  /**
   * Sets element flag.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetFlag(
    id: RID,
    flag: AccessibilityFlags,
    `value`: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, LONG to flag.value, BOOL to value)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetFlagPtr)
  }

  /**
   * Sets element class name.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetClassname(id: RID, classname: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to classname)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetClassnamePtr)
  }

  /**
   * Sets placeholder text.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetPlaceholder(id: RID, placeholder: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to placeholder)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetPlaceholderPtr)
  }

  /**
   * Sets element text language.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetLanguage(id: RID, language: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to language)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetLanguagePtr)
  }

  /**
   * Sets text orientation.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetTextOrientation(id: RID, vertical: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, BOOL to vertical)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetTextOrientationPtr)
  }

  /**
   * Sets the orientation of the list elements.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetListOrientation(id: RID, vertical: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, BOOL to vertical)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetListOrientationPtr)
  }

  /**
   * Sets the list of keyboard shortcuts used by element.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetShortcut(id: RID, shortcut: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to shortcut)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetShortcutPtr)
  }

  /**
   * Sets link URL.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetUrl(id: RID, url: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to url)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetUrlPtr)
  }

  /**
   * Sets element accessibility role description text.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetRoleDescription(id: RID, description: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to description)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetRoleDescriptionPtr)
  }

  /**
   * Sets human-readable description of the current checked state.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetStateDescription(id: RID, description: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to description)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetStateDescriptionPtr)
  }

  /**
   * Sets element color value.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetColorValue(id: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, COLOR to color)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetColorValuePtr)
  }

  /**
   * Sets element background color.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetBackgroundColor(id: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, COLOR to color)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetBackgroundColorPtr)
  }

  /**
   * Sets element foreground color.
   */
  @JvmStatic
  public final fun accessibilityUpdateSetForegroundColor(id: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, COLOR to color)
    TransferContext.callMethod(MethodBindings.accessibilityUpdateSetForegroundColorPtr)
  }

  /**
   * Returns the text selection in the [url=https://en.wikipedia.org/wiki/Input_method]Input Method
   * Editor[/url] composition string, with the [Vector2i]'s `x` component being the caret position and
   * `y` being the length of the selection.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun imeGetSelection(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.imeGetSelectionPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the composition string contained within the
   * [url=https://en.wikipedia.org/wiki/Input_method]Input Method Editor[/url] window.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun imeGetText(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.imeGetTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Shows the virtual keyboard if the platform has one.
   *
   * [existingText] parameter is useful for implementing your own [LineEdit] or [TextEdit], as it
   * tells the virtual keyboard what text has already been typed (the virtual keyboard uses it for
   * auto-correct and predictions).
   *
   * [position] parameter is the screen space [Rect2] of the edited text.
   *
   * [type] parameter allows configuring which type of virtual keyboard to show.
   *
   * [maxLength] limits the number of characters that can be entered if different from `-1`.
   *
   * [cursorStart] can optionally define the current text cursor position if [cursorEnd] is not set.
   *
   * [cursorStart] and [cursorEnd] can optionally define the current text selection.
   *
   * **Note:** This method is implemented on Android, iOS and Web.
   */
  @JvmOverloads
  @JvmStatic
  public final fun virtualKeyboardShow(
    existingText: String,
    position: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
    type: VirtualKeyboardType = DisplayServer.VirtualKeyboardType.KEYBOARD_TYPE_DEFAULT,
    maxLength: Int = -1,
    cursorStart: Int = -1,
    cursorEnd: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to existingText, RECT2 to position, LONG to type.value, LONG to maxLength.toLong(), LONG to cursorStart.toLong(), LONG to cursorEnd.toLong())
    TransferContext.callMethod(MethodBindings.virtualKeyboardShowPtr)
  }

  /**
   * Hides the virtual keyboard if it is shown, does nothing otherwise.
   */
  @JvmStatic
  public final fun virtualKeyboardHide(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.virtualKeyboardHidePtr)
  }

  /**
   * Returns the on-screen keyboard's height in pixels. Returns `0` if there is no keyboard or if it
   * is currently hidden.
   *
   * **Note:** On Android 7 and 8, the keyboard height may return `0` the first time the keyboard is
   * opened in non-immersive mode. This behavior does not occur in immersive mode.
   */
  @JvmStatic
  public final fun virtualKeyboardGetHeight(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.virtualKeyboardGetHeightPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if a hardware keyboard is connected.
   *
   * **Note:** This method is implemented on Android and iOS. On other platforms, this method always
   * returns `true`.
   */
  @JvmStatic
  public final fun hasHardwareKeyboard(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasHardwareKeyboardPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the callback that should be called when a hardware keyboard is connected or disconnected.
   * [callable] should accept a single [Boolean] argument indicating whether the keyboard has been
   * connected (`true`) or disconnected (`false`).
   *
   * **Note:** This method is only implemented on Android.
   */
  @JvmStatic
  public final fun setHardwareKeyboardConnectionChangeCallback(callable: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.setHardwareKeyboardConnectionChangeCallbackPtr)
  }

  /**
   * Sets the default mouse cursor shape. The cursor's appearance will vary depending on the user's
   * operating system and mouse cursor theme. See also [cursorGetShape] and [cursorSetCustomImage].
   */
  @JvmStatic
  public final fun cursorSetShape(shape: CursorShape): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.cursorSetShapePtr)
  }

  /**
   * Returns the default mouse cursor shape set by [cursorSetShape].
   */
  @JvmStatic
  public final fun cursorGetShape(): CursorShape {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cursorGetShapePtr)
    return CursorShape.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets a custom mouse cursor image for the given [shape]. This means the user's operating system
   * and mouse cursor theme will no longer influence the mouse cursor's appearance.
   *
   * [cursor] can be either a [Texture2D] or an [Image], and it should not be larger than 256×256 to
   * display correctly. Optionally, [hotspot] can be set to offset the image's position relative to the
   * click point. By default, [hotspot] is set to the top-left corner of the image. See also
   * [cursorSetShape].
   *
   * **Note:** On Web, calling this method every frame can cause the cursor to flicker.
   */
  @JvmOverloads
  @JvmStatic
  public final fun cursorSetCustomImage(
    cursor: Resource?,
    shape: CursorShape = DisplayServer.CursorShape.ARROW,
    hotspot: Vector2 = Vector2(0, 0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to cursor, LONG to shape.value, VECTOR2 to hotspot)
    TransferContext.callMethod(MethodBindings.cursorSetCustomImagePtr)
  }

  /**
   * Returns `true` if positions of **OK** and **Cancel** buttons are swapped in dialogs. This is
   * enabled by default on Windows to follow interface conventions, and be toggled by changing
   * [ProjectSettings.gui/common/swapCancelOk].
   *
   * **Note:** This doesn't affect native dialogs such as the ones spawned by
   * [DisplayServer.dialogShow].
   */
  @JvmStatic
  public final fun getSwapCancelOk(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSwapCancelOkPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Allows the [processId] PID to steal focus from this window. In other words, this disables the
   * operating system's focus stealing protection for the specified PID.
   *
   * **Note:** This method is implemented only on Windows.
   */
  @JvmStatic
  public final fun enableForStealingFocus(processId: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to processId)
    TransferContext.callMethod(MethodBindings.enableForStealingFocusPtr)
  }

  /**
   * Shows a text dialog which uses the operating system's native look-and-feel. [callback] should
   * accept a single [Long] parameter which corresponds to the index of the pressed button.
   *
   * **Note:** This method is implemented if the display server has the [FEATURE_NATIVE_DIALOG]
   * feature. Supported platforms include macOS, Windows, and Android.
   */
  @JvmStatic
  public final fun dialogShow(
    title: String,
    description: String,
    buttons: PackedStringArray,
    callback: Callable,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to title, STRING to description, PACKED_STRING_ARRAY to buttons, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.dialogShowPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Shows a text input dialog which uses the operating system's native look-and-feel. [callback]
   * should accept a single [String] parameter which contains the text field's contents.
   *
   * **Note:** This method is implemented if the display server has the
   * [FEATURE_NATIVE_DIALOG_INPUT] feature. Supported platforms include macOS, Windows, and Android.
   */
  @JvmStatic
  public final fun dialogInputText(
    title: String,
    description: String,
    existingText: String,
    callback: Callable,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to title, STRING to description, STRING to existingText, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.dialogInputTextPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Displays OS native dialog for selecting files or directories in the file system.
   *
   * Each filter string in the [filters] array should be formatted like this:
   * `*.png,*.jpg,*.jpeg;Image Files;image/png,image/jpeg`. The description text of the filter is
   * optional and can be omitted. It is recommended to set both file extension and MIME type. See also
   * [FileDialog.filters].
   *
   * Callbacks have the following arguments: `status: bool, selected_paths: PackedStringArray,
   * selected_filter_index: int`. **On Android,** the third callback argument (`selected_filter_index`)
   * is always `0`.
   *
   * **Note:** This method is implemented if the display server has the [FEATURE_NATIVE_DIALOG_FILE]
   * feature. Supported platforms include Linux (X11/Wayland), Windows, macOS, and Android.
   *
   * **Note:** [currentDirectory] might be ignored.
   *
   * **Note:** Embedded file dialogs and Windows file dialogs support only file extensions, while
   * Android, Linux, and macOS file dialogs also support MIME types.
   *
   * **Note:** On Android and Linux, [showHidden] is ignored.
   *
   * **Note:** On Android and macOS, native file dialogs have no title.
   *
   * **Note:** On macOS, sandboxed apps will save security-scoped bookmarks to retain access to the
   * opened folders across multiple sessions. Use [OS.getGrantedPermissions] to get a list of saved
   * bookmarks.
   *
   * **Note:** On Android, this method uses the Android Storage Access Framework (SAF).
   *
   * The file picker returns a URI instead of a filesystem path. This URI can be passed directly to
   * [FileAccess] to perform read/write operations.
   *
   * When using [FILE_DIALOG_MODE_OPEN_DIR], it returns a tree URI that grants full access to the
   * selected directory. File operations inside this directory can be performed by passing a path on
   * the form `treeUri#relative/path/to/file` to [FileAccess].
   *
   * To avoid opening the file picker again after each app restart, you can take persistable URI
   * permission as follows:
   *
   * ```gdscript
   * //gdscript
   * val uri = "content://com.android..." # URI of the selected file or folder.
   * val persist = true # Set to false to release the persistable permission.
   * var android_runtime = Engine.get_singleton("AndroidRuntime")
   * android_runtime.updatePersistableUriPermission(uri, persist)
   * ```
   *
   * The persistable URI permission remains valid across app restarts as long as the directory is
   * not moved, renamed, or deleted.
   */
  @JvmOverloads
  @JvmStatic
  public final fun fileDialogShow(
    title: String,
    currentDirectory: String,
    filename: String,
    showHidden: Boolean,
    mode: FileDialogMode,
    filters: PackedStringArray,
    callback: Callable,
    parentWindowId: Int = 0,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to title, STRING to currentDirectory, STRING to filename, BOOL to showHidden, LONG to mode.value, PACKED_STRING_ARRAY to filters, CALLABLE to callback, LONG to parentWindowId.toLong())
    TransferContext.callMethod(MethodBindings.fileDialogShowPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Displays OS native dialog for selecting files or directories in the file system with additional
   * user selectable options.
   *
   * Each filter string in the [filters] array should be formatted like this:
   * `*.png,*.jpg,*.jpeg;Image Files;image/png,image/jpeg`. The description text of the filter is
   * optional and can be omitted. It is recommended to set both file extension and MIME type. See also
   * [FileDialog.filters].
   *
   * [options] is array of [Dictionary]s with the following keys:
   *
   * - `"name"` - option's name [String].
   *
   * - `"values"` - [PackedStringArray] of values. If empty, boolean option (check box) is used.
   *
   * - `"default"` - default selected option index ([Long]) or default boolean value ([Boolean]).
   *
   * Callbacks have the following arguments: `status: bool, selected_paths: PackedStringArray,
   * selected_filter_index: int, selected_option: Dictionary`.
   *
   * **Note:** This method is implemented if the display server has the
   * [FEATURE_NATIVE_DIALOG_FILE_EXTRA] feature. Supported platforms include Linux (X11/Wayland),
   * Windows, and macOS.
   *
   * **Note:** [currentDirectory] might be ignored.
   *
   * **Note:** Embedded file dialogs and Windows file dialogs support only file extensions, while
   * Android, Linux, and macOS file dialogs also support MIME types.
   *
   * **Note:** On Linux (X11), [showHidden] is ignored.
   *
   * **Note:** On macOS, native file dialogs have no title.
   *
   * **Note:** On macOS, sandboxed apps will save security-scoped bookmarks to retain access to the
   * opened folders across multiple sessions. Use [OS.getGrantedPermissions] to get a list of saved
   * bookmarks.
   */
  @JvmOverloads
  @JvmStatic
  public final fun fileDialogWithOptionsShow(
    title: String,
    currentDirectory: String,
    root: String,
    filename: String,
    showHidden: Boolean,
    mode: FileDialogMode,
    filters: PackedStringArray,
    options: VariantArray<Dictionary<Any?, Any?>>,
    callback: Callable,
    parentWindowId: Int = 0,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to title, STRING to currentDirectory, STRING to root, STRING to filename, BOOL to showHidden, LONG to mode.value, PACKED_STRING_ARRAY to filters, ARRAY to options, CALLABLE to callback, LONG to parentWindowId.toLong())
    TransferContext.callMethod(MethodBindings.fileDialogWithOptionsShowPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Plays the beep sound from the operative system, if possible. Because it comes from the OS, the
   * beep sound will be audible even if the application is muted. It may also be disabled for the
   * entire OS by the user.
   *
   * **Note:** This method is implemented on macOS, Linux (X11/Wayland), and Windows.
   */
  @JvmStatic
  public final fun beep(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.beepPtr)
  }

  /**
   * Returns the number of keyboard layouts.
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS and Windows.
   */
  @JvmStatic
  public final fun keyboardGetLayoutCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.keyboardGetLayoutCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns active keyboard layout index.
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS, and Windows.
   */
  @JvmStatic
  public final fun keyboardGetCurrentLayout(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.keyboardGetCurrentLayoutPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the active keyboard layout.
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS and Windows.
   */
  @JvmStatic
  public final fun keyboardSetCurrentLayout(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.keyboardSetCurrentLayoutPtr)
  }

  /**
   * Returns the ISO-639/BCP-47 language code of the keyboard layout at position [index].
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS and Windows.
   */
  @JvmStatic
  public final fun keyboardGetLayoutLanguage(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.keyboardGetLayoutLanguagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the localized name of the keyboard layout at position [index].
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS and Windows.
   */
  @JvmStatic
  public final fun keyboardGetLayoutName(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.keyboardGetLayoutNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Converts a physical (US QWERTY) [keycode] to one in the active keyboard layout.
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS and Windows.
   */
  @JvmStatic
  public final fun keyboardGetKeycodeFromPhysical(keycode: Key): Key {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to keycode.value)
    TransferContext.callMethod(MethodBindings.keyboardGetKeycodeFromPhysicalPtr)
    return Key.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Converts a physical (US QWERTY) [keycode] to localized label printed on the key in the active
   * keyboard layout.
   *
   * **Note:** This method is implemented on Linux (X11/Wayland), macOS and Windows.
   */
  @JvmStatic
  public final fun keyboardGetLabelFromPhysical(keycode: Key): Key {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to keycode.value)
    TransferContext.callMethod(MethodBindings.keyboardGetLabelFromPhysicalPtr)
    return Key.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Opens system emoji and symbol picker.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun showEmojiAndSymbolPicker(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.showEmojiAndSymbolPickerPtr)
  }

  /**
   * Displays OS native color picker.
   *
   * Callbacks have the following arguments: `status: bool, color: Color`.
   *
   * **Note:** This method is implemented if the display server has the
   * [FEATURE_NATIVE_COLOR_PICKER] feature.
   *
   * **Note:** This method is only implemented on Linux (X11/Wayland).
   */
  @JvmStatic
  public final fun colorPicker(callback: Callable): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.colorPickerPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Perform window manager processing, including input flushing. See also
   * [forceProcessAndDropEvents], [Input.flushBufferedEvents] and [Input.useAccumulatedInput].
   */
  @JvmStatic
  public final fun processEvents(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.processEventsPtr)
  }

  /**
   * Forces window manager processing while ignoring all [InputEvent]s. See also [processEvents].
   *
   * **Note:** This method is implemented on Windows and macOS.
   */
  @JvmStatic
  public final fun forceProcessAndDropEvents(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceProcessAndDropEventsPtr)
  }

  /**
   * Sets the window icon (usually displayed in the top-left corner) in the operating system's
   * *native* format. The file at [filename] must be in `.ico` format on Windows or `.icns` on macOS.
   * By using specially crafted `.ico` or `.icns` icons, [setNativeIcon] allows specifying different
   * icons depending on the size the icon is displayed at. This size is determined by the operating
   * system and user preferences (including the display scale factor). To use icons in other formats,
   * use [setIcon] instead.
   *
   * **Note:** Requires support for [FEATURE_NATIVE_ICON].
   */
  @JvmStatic
  public final fun setNativeIcon(filename: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to filename)
    TransferContext.callMethod(MethodBindings.setNativeIconPtr)
  }

  /**
   * Sets the application icon and icons of all windows with an [Image]. To use icons in the
   * operating system's native format, use [setNativeIcon] instead.
   *
   * **Note:** Requires support for [FEATURE_ICON].
   */
  @JvmStatic
  public final fun setIcon(image: Image?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to image)
    TransferContext.callMethod(MethodBindings.setIconPtr)
  }

  /**
   * Creates a new application status indicator with the specified icon, tooltip, and activation
   * callback.
   *
   * [callback] should take two arguments: the pressed mouse button (one of the [MouseButton]
   * constants) and the click position in screen coordinates (a [Vector2i]).
   */
  @JvmStatic
  public final fun createStatusIndicator(
    icon: Texture2D?,
    tooltip: String,
    callback: Callable,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to icon, STRING to tooltip, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.createStatusIndicatorPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the application status indicator icon.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun statusIndicatorSetIcon(id: Int, icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong(), OBJECT to icon)
    TransferContext.callMethod(MethodBindings.statusIndicatorSetIconPtr)
  }

  /**
   * Sets the application status indicator tooltip.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun statusIndicatorSetTooltip(id: Int, tooltip: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong(), STRING to tooltip)
    TransferContext.callMethod(MethodBindings.statusIndicatorSetTooltipPtr)
  }

  /**
   * Sets the application status indicator native popup menu.
   *
   * **Note:** On macOS, the menu is activated by any mouse button. Its activation callback is *not*
   * triggered.
   *
   * **Note:** On Windows, the menu is activated by the right mouse button, selecting the status
   * icon and pressing [kbd]Shift + F10[/kbd], or the applications key. The menu's activation callback
   * for the other mouse buttons is still triggered.
   *
   * **Note:** Native popup is only supported if [NativeMenu] supports the
   * [NativeMenu.FEATURE_POPUP_MENU] feature.
   */
  @JvmStatic
  public final fun statusIndicatorSetMenu(id: Int, menuRid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong(), _RID to menuRid)
    TransferContext.callMethod(MethodBindings.statusIndicatorSetMenuPtr)
  }

  /**
   * Sets the application status indicator activation callback. [callback] should take two
   * arguments: [Long] mouse button index (one of [MouseButton] values) and [Vector2i] click position
   * in screen coordinates.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun statusIndicatorSetCallback(id: Int, callback: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong(), CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.statusIndicatorSetCallbackPtr)
  }

  /**
   * Returns the rectangle for the given status indicator [id] in screen coordinates. If the status
   * indicator is not visible, returns an empty [Rect2].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun statusIndicatorGetRect(id: Int): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.statusIndicatorGetRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Removes the application status indicator.
   */
  @JvmStatic
  public final fun deleteStatusIndicator(id: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.deleteStatusIndicatorPtr)
  }

  /**
   * Returns the total number of available tablet drivers.
   *
   * **Note:** This method is implemented only on Windows.
   */
  @JvmStatic
  public final fun tabletGetDriverCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.tabletGetDriverCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the tablet driver name for the given index.
   *
   * **Note:** This method is implemented only on Windows.
   */
  @JvmStatic
  public final fun tabletGetDriverName(idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.tabletGetDriverNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns current active tablet driver name.
   *
   * **Note:** This method is implemented only on Windows.
   */
  @JvmStatic
  public final fun tabletGetCurrentDriver(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.tabletGetCurrentDriverPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Set active tablet driver name.
   *
   * Supported drivers:
   *
   * - `winink`: Windows Ink API, default.
   *
   * - `wintab`: Wacom Wintab API (compatible device driver required).
   *
   * - `dummy`: Dummy driver, tablet input is disabled.
   *
   * **Note:** This method is implemented only on Windows.
   */
  @JvmStatic
  public final fun tabletSetCurrentDriver(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.tabletSetCurrentDriverPtr)
  }

  /**
   * Returns `true` if the window background can be made transparent. This method returns `false` if
   * [ProjectSettings.display/window/perPixelTransparency/allowed] is set to `false`, or if
   * transparency is not supported by the renderer or OS compositor.
   */
  @JvmStatic
  public final fun isWindowTransparencyAvailable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isWindowTransparencyAvailablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Registers an [Object] which represents an additional output that will be rendered too, beyond
   * normal windows. The [Object] is only used as an identifier, which can be later passed to
   * [unregisterAdditionalOutput].
   *
   * This can be used to prevent Godot from skipping rendering when no normal windows are visible.
   */
  @JvmStatic
  public final fun registerAdditionalOutput(`object`: Object?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to `object`)
    TransferContext.callMethod(MethodBindings.registerAdditionalOutputPtr)
  }

  /**
   * Unregisters an [Object] representing an additional output, that was registered via
   * [registerAdditionalOutput].
   */
  @JvmStatic
  public final fun unregisterAdditionalOutput(`object`: Object?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to `object`)
    TransferContext.callMethod(MethodBindings.unregisterAdditionalOutputPtr)
  }

  /**
   * Returns `true` if any additional outputs have been registered via [registerAdditionalOutput].
   */
  @JvmStatic
  public final fun hasAdditionalOutputs(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasAdditionalOutputsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the application is in picture-in-picture mode.
   *
   * **Note:** This method is implemented on Android.
   */
  @JvmOverloads
  @JvmStatic
  public final fun isInPipMode(windowId: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.isInPipModePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Enters picture-in-picture mode.
   *
   * **Note:** This method is implemented on Android.
   */
  @JvmOverloads
  @JvmStatic
  public final fun pipModeEnter(windowId: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.pipModeEnterPtr)
  }

  /**
   * Specifies the aspect ratio for picture-in-picture mode.
   *
   * **Note:** This method is implemented on Android.
   */
  @JvmOverloads
  @JvmStatic
  public final fun pipModeSetAspectRatio(
    numerator: Int,
    denominator: Int,
    windowId: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to numerator.toLong(), LONG to denominator.toLong(), LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.pipModeSetAspectRatioPtr)
  }

  /**
   * Specifies whether picture-in-picture mode should be entered automatically when the application
   * goes in the background.
   *
   * **Note:** This method is implemented on Android.
   */
  @JvmOverloads
  @JvmStatic
  public final fun pipModeSetAutoEnterOnBackground(autoEnterOnBackground: Boolean, windowId: Int =
      0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to autoEnterOnBackground, LONG to windowId.toLong())
    TransferContext.callMethod(MethodBindings.pipModeSetAutoEnterOnBackgroundPtr)
  }

  public enum class Feature(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Display server supports global menu. This allows the application to display its menu items in
     * the operating system's top bar. **macOS**
     */
    GLOBAL_MENU(0),
    /**
     * Display server supports multiple windows that can be moved outside of the main window.
     * **Windows, macOS, Linux (X11)**
     */
    SUBWINDOWS(1),
    /**
     * Display server supports touchscreen input. **Windows, Linux (X11/Wayland), Android, iOS,
     * Web**
     */
    TOUCHSCREEN(2),
    /**
     * Display server supports mouse input. **Windows, macOS, Linux (X11/Wayland), Android, Web**
     */
    MOUSE(3),
    /**
     * Display server supports warping mouse coordinates to keep the mouse cursor constrained within
     * an area, but looping when one of the edges is reached. **Windows, macOS, Linux (X11/Wayland)**
     */
    MOUSE_WARP(4),
    /**
     * Display server supports setting and getting clipboard data. See also
     * [FEATURE_CLIPBOARD_PRIMARY]. **Windows, macOS, Linux (X11/Wayland), Android, iOS, Web**
     */
    CLIPBOARD(5),
    /**
     * Display server supports popping up a virtual keyboard when requested to input text without a
     * physical keyboard. **Android, iOS, Web**
     */
    VIRTUAL_KEYBOARD(6),
    /**
     * Display server supports setting the mouse cursor shape to be different from the default.
     * **Windows, macOS, Linux (X11/Wayland), Android, Web**
     */
    CURSOR_SHAPE(7),
    /**
     * Display server supports setting the mouse cursor shape to a custom image. **Windows, macOS,
     * Linux (X11/Wayland), Web**
     */
    CUSTOM_CURSOR_SHAPE(8),
    /**
     * Display server supports spawning text dialogs using the operating system's native
     * look-and-feel. See [dialogShow]. **Windows, macOS**
     */
    NATIVE_DIALOG(9),
    /**
     * Display server supports [url=https://en.wikipedia.org/wiki/Input_method]Input Method
     * Editor[/url], which is commonly used for inputting Chinese/Japanese/Korean text. This is handled
     * by the operating system, rather than by Godot. **Windows, macOS, Linux (X11)**
     */
    IME(10),
    /**
     * Display server supports windows can use per-pixel transparency to make windows behind them
     * partially or fully visible. **Windows, macOS, Linux (X11/Wayland), Android**
     */
    WINDOW_TRANSPARENCY(11),
    /**
     * Display server supports querying the operating system's display scale factor. This allows
     * automatically detecting the hiDPI display *reliably*, instead of guessing based on the screen
     * resolution and the display's reported DPI (which might be unreliable due to broken monitor
     * EDID). **Windows, Linux (Wayland), macOS**
     */
    HIDPI(12),
    /**
     * Display server supports changing the window icon (usually displayed in the top-left corner).
     * **Windows, macOS, Linux (X11/Wayland)**
     *
     * **Note:** Use on Wayland requires the compositor to implement the
     * [url=https://wayland.app/protocols/xdg-toplevel-icon-v1#xdg_toplevel_icon_v1]xdg_toplevel_icon_v1[/url]
     * protocol, which not all compositors do. See
     * [url=https://wayland.app/protocols/xdg-toplevel-icon-v1#compositor-support]xdg_toplevel_icon_v1#compositor-support[/url]
     * for more information on individual compositor support.
     */
    ICON(13),
    /**
     * Display server supports changing the window icon (usually displayed in the top-left corner).
     * **Windows, macOS**
     */
    NATIVE_ICON(14),
    /**
     * Display server supports changing the screen orientation. **Android, iOS**
     */
    ORIENTATION(15),
    /**
     * Display server supports V-Sync status can be changed from the default (which is forced to be
     * enabled platforms not supporting this feature). **Windows, macOS, Linux (X11/Wayland)**
     */
    SWAP_BUFFERS(16),
    /**
     * Display server supports Primary clipboard can be used. This is a different clipboard from
     * [FEATURE_CLIPBOARD]. **Linux (X11/Wayland)**
     */
    CLIPBOARD_PRIMARY(18),
    /**
     * Display server supports text-to-speech. See `tts_*` methods. **Windows, macOS, Linux
     * (X11/Wayland), Android, iOS, Web**
     */
    TEXT_TO_SPEECH(19),
    /**
     * Display server supports expanding window content to the title. See
     * [WINDOW_FLAG_EXTEND_TO_TITLE]. **macOS**
     */
    EXTEND_TO_TITLE(20),
    /**
     * Display server supports reading screen pixels. See [screenGetPixel].
     */
    SCREEN_CAPTURE(21),
    /**
     * Display server supports application status indicators.
     */
    STATUS_INDICATOR(22),
    /**
     * Display server supports native help system search callbacks. See [helpSetSearchCallbacks].
     */
    NATIVE_HELP(23),
    /**
     * Display server supports spawning text input dialogs using the operating system's native
     * look-and-feel. See [dialogInputText]. **Windows, macOS**
     */
    NATIVE_DIALOG_INPUT(24),
    /**
     * Display server supports spawning dialogs for selecting files or directories using the
     * operating system's native look-and-feel. See [fileDialogShow]. **Windows, macOS, Linux
     * (X11/Wayland), Android**
     */
    NATIVE_DIALOG_FILE(25),
    /**
     * The display server supports all features of [FEATURE_NATIVE_DIALOG_FILE], with the added
     * functionality of Options and native dialog file access to `res://` and `user://` paths. See
     * [fileDialogShow] and [fileDialogWithOptionsShow]. **Windows, macOS, Linux (X11/Wayland)**
     */
    NATIVE_DIALOG_FILE_EXTRA(26),
    /**
     * The display server supports initiating window drag and resize operations on demand. See
     * [windowStartDrag] and [windowStartResize].
     */
    WINDOW_DRAG(27),
    /**
     * Display server supports [WINDOW_FLAG_EXCLUDE_FROM_CAPTURE] window flag. **Windows, macOS**
     */
    SCREEN_EXCLUDE_FROM_CAPTURE(28),
    /**
     * Display server supports embedding a window from another process. **Windows, Linux (X11),
     * macOS**
     */
    WINDOW_EMBEDDING(29),
    /**
     * Native file selection dialog supports MIME types as filters.
     */
    NATIVE_DIALOG_FILE_MIME(30),
    /**
     * Display server supports system emoji and symbol picker. **Windows, macOS**
     */
    EMOJI_AND_SYMBOL_PICKER(31),
    /**
     * Display server supports native color picker. **Linux (X11/Wayland)**
     */
    NATIVE_COLOR_PICKER(32),
    /**
     * Display server automatically fits popups according to the screen boundaries. Window nodes
     * should not attempt to do that themselves.
     */
    SELF_FITTING_WINDOWS(33),
    /**
     * Display server supports interaction with screen reader or Braille display. **Linux
     * (X11/Wayland), macOS, Windows**
     */
    ACCESSIBILITY_SCREEN_READER(34),
    /**
     * Display server supports HDR output. **Linux (Wayland), macOS, iOS, visionOS, Windows**
     */
    HDR_OUTPUT(35),
    /**
     * Display server supports putting the application in picture-in-picture mode. **Android**
     */
    PIP_MODE(36),
    ;

    public companion object {
      public fun from(`value`: Long): Feature = entries.single { it.`value` == `value` }
    }
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

  public enum class MouseMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Makes the mouse cursor visible if it is hidden.
     */
    VISIBLE(0),
    /**
     * Makes the mouse cursor hidden if it is visible.
     */
    HIDDEN(1),
    /**
     * Captures the mouse. The mouse will be hidden and its position locked at the center of the
     * window manager's window.
     *
     * **Note:** If you want to process the mouse's movement in this mode, you need to use
     * [InputEventMouseMotion.relative].
     */
    CAPTURED(2),
    /**
     * Confines the mouse cursor to the game window, and make it visible.
     */
    CONFINED(3),
    /**
     * Confines the mouse cursor to the game window, and make it hidden.
     */
    CONFINED_HIDDEN(4),
    /**
     * Max value of the [MouseMode].
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): MouseMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ScreenOrientation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Default landscape orientation.
     */
    LANDSCAPE(0),
    /**
     * Default portrait orientation.
     */
    PORTRAIT(1),
    /**
     * Reverse landscape orientation (upside down).
     */
    REVERSE_LANDSCAPE(2),
    /**
     * Reverse portrait orientation (upside down).
     */
    REVERSE_PORTRAIT(3),
    /**
     * Automatic landscape orientation (default or reverse depending on sensor).
     */
    SENSOR_LANDSCAPE(4),
    /**
     * Automatic portrait orientation (default or reverse depending on sensor).
     */
    SENSOR_PORTRAIT(5),
    /**
     * Automatic landscape or portrait orientation (default or reverse depending on sensor).
     */
    SENSOR(6),
    ;

    public companion object {
      public fun from(`value`: Long): ScreenOrientation = entries.single { it.`value` == `value` }
    }
  }

  public enum class VirtualKeyboardType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Default text virtual keyboard.
     */
    KEYBOARD_TYPE_DEFAULT(0),
    /**
     * Multiline virtual keyboard.
     */
    KEYBOARD_TYPE_MULTILINE(1),
    /**
     * Virtual number keypad, useful for PIN entry.
     */
    KEYBOARD_TYPE_NUMBER(2),
    /**
     * Virtual number keypad, useful for entering fractional numbers.
     */
    KEYBOARD_TYPE_NUMBER_DECIMAL(3),
    /**
     * Virtual phone number keypad.
     */
    KEYBOARD_TYPE_PHONE(4),
    /**
     * Virtual keyboard with additional keys to assist with typing email addresses.
     */
    KEYBOARD_TYPE_EMAIL_ADDRESS(5),
    /**
     * Virtual keyboard for entering a password. On most platforms, this should disable autocomplete
     * and autocapitalization.
     *
     * **Note:** This is not supported on Web. Instead, this behaves identically to
     * [KEYBOARD_TYPE_DEFAULT].
     */
    KEYBOARD_TYPE_PASSWORD(6),
    /**
     * Virtual keyboard with additional keys to assist with typing URLs.
     */
    KEYBOARD_TYPE_URL(7),
    ;

    public companion object {
      public fun from(`value`: Long): VirtualKeyboardType = entries.single { it.`value` == `value` }
    }
  }

  public enum class CursorShape(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Arrow cursor shape. This is the default when not pointing anything that overrides the mouse
     * cursor, such as a [LineEdit] or [TextEdit].
     */
    ARROW(0),
    /**
     * I-beam cursor shape. This is used by default when hovering a control that accepts text input,
     * such as [LineEdit] or [TextEdit].
     */
    IBEAM(1),
    /**
     * Pointing hand cursor shape. This is used by default when hovering a [LinkButton] or a URL tag
     * in a [RichTextLabel].
     */
    POINTING_HAND(2),
    /**
     * Crosshair cursor. This is intended to be displayed when the user needs precise aim over an
     * element, such as a rectangle selection tool or a color picker.
     */
    CROSS(3),
    /**
     * Wait cursor. On most cursor themes, this displays a spinning icon *besides* the arrow.
     * Intended to be used for non-blocking operations (when the user can do something else at the
     * moment). See also [CURSOR_BUSY].
     */
    WAIT(4),
    /**
     * Wait cursor. On most cursor themes, this *replaces* the arrow with a spinning icon. Intended
     * to be used for blocking operations (when the user can't do anything else at the moment). See
     * also [CURSOR_WAIT].
     */
    BUSY(5),
    /**
     * Dragging hand cursor. This is displayed during drag-and-drop operations. See also
     * [CURSOR_CAN_DROP].
     */
    DRAG(6),
    /**
     * "Can drop" cursor. This is displayed during drag-and-drop operations if hovering over a
     * [Control] that can accept the drag-and-drop event. On most cursor themes, this displays a
     * dragging hand with an arrow symbol besides it. See also [CURSOR_DRAG].
     */
    CAN_DROP(7),
    /**
     * Forbidden cursor. This is displayed during drag-and-drop operations if the hovered [Control]
     * can't accept the drag-and-drop event.
     */
    FORBIDDEN(8),
    /**
     * Vertical resize cursor. Intended to be displayed when the hovered [Control] can be vertically
     * resized using the mouse. See also [CURSOR_VSPLIT].
     */
    VSIZE(9),
    /**
     * Horizontal resize cursor. Intended to be displayed when the hovered [Control] can be
     * horizontally resized using the mouse. See also [CURSOR_HSPLIT].
     */
    HSIZE(10),
    /**
     * Secondary diagonal resize cursor (top-right/bottom-left). Intended to be displayed when the
     * hovered [Control] can be resized on both axes at once using the mouse.
     */
    BDIAGSIZE(11),
    /**
     * Main diagonal resize cursor (top-left/bottom-right). Intended to be displayed when the
     * hovered [Control] can be resized on both axes at once using the mouse.
     */
    FDIAGSIZE(12),
    /**
     * Move cursor. Intended to be displayed when the hovered [Control] can be moved using the
     * mouse.
     */
    MOVE(13),
    /**
     * Vertical split cursor. This is displayed when hovering a [Control] with splits that can be
     * vertically resized using the mouse, such as [VSplitContainer]. On some cursor themes, this
     * cursor may have the same appearance as [CURSOR_VSIZE].
     */
    VSPLIT(14),
    /**
     * Horizontal split cursor. This is displayed when hovering a [Control] with splits that can be
     * horizontally resized using the mouse, such as [HSplitContainer]. On some cursor themes, this
     * cursor may have the same appearance as [CURSOR_HSIZE].
     */
    HSPLIT(15),
    /**
     * Help cursor. On most cursor themes, this displays a question mark icon instead of the mouse
     * cursor. Intended to be used when the user has requested help on the next element that will be
     * clicked.
     */
    HELP(16),
    /**
     * Represents the size of the [CursorShape] enum.
     */
    MAX(17),
    ;

    public companion object {
      public fun from(`value`: Long): CursorShape = entries.single { it.`value` == `value` }
    }
  }

  public enum class FileDialogMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The native file dialog allows selecting one, and only one file.
     */
    OPEN_FILE(0),
    /**
     * The native file dialog allows selecting multiple files.
     */
    OPEN_FILES(1),
    /**
     * The native file dialog only allows selecting a directory, disallowing the selection of any
     * file.
     */
    OPEN_DIR(2),
    /**
     * The native file dialog allows selecting one file or directory.
     */
    OPEN_ANY(3),
    /**
     * The native file dialog will warn when a file exists.
     */
    SAVE_FILE(4),
    ;

    public companion object {
      public fun from(`value`: Long): FileDialogMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class WindowMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Windowed mode, i.e. [Window] doesn't occupy the whole screen (unless set to the size of the
     * screen).
     */
    WINDOWED(0),
    /**
     * Minimized window mode, i.e. [Window] is not visible and available on window manager's window
     * list. Normally happens when the minimize button is pressed.
     */
    MINIMIZED(1),
    /**
     * Maximized window mode, i.e. [Window] will occupy whole screen area except task bar and still
     * display its borders. Normally happens when the maximize button is pressed.
     */
    MAXIMIZED(2),
    /**
     * Full screen mode with full multi-window support.
     *
     * Full screen window covers the entire display area of a screen and has no decorations. The
     * display's video mode is not changed.
     *
     * **On Android:** This enables immersive mode.
     *
     * **On macOS:** A new desktop is used to display the running project.
     *
     * **Note:** Regardless of the platform, enabling full screen will change the window size to
     * match the monitor's size. Therefore, make sure your project supports
     * [url=$DOCS_URL/tutorials/rendering/multiple_resolutions.html]multiple resolutions[/url] when
     * enabling full screen mode.
     */
    FULLSCREEN(3),
    /**
     * A single window full screen mode. This mode has less overhead, but only one window can be
     * open on a given screen at a time (opening a child window or application switching will trigger a
     * full screen transition).
     *
     * Full screen window covers the entire display area of a screen and has no border or
     * decorations. The display's video mode is not changed.
     *
     * **Note:** This mode might not work with screen recording software.
     *
     * **On Android:** This enables immersive mode.
     *
     * **On Windows:** Depending on video driver, full screen transition might cause screens to go
     * black for a moment.
     *
     * **On macOS:** A new desktop is used to display the running project. Exclusive full screen
     * mode prevents Dock and Menu from showing up when the mouse pointer is hovering the edge of the
     * screen.
     *
     * **On Linux (X11):** Exclusive full screen mode bypasses compositor.
     *
     * **On Linux (Wayland):** Equivalent to [WINDOW_MODE_FULLSCREEN].
     *
     * **Note:** Regardless of the platform, enabling full screen will change the window size to
     * match the monitor's size. Therefore, make sure your project supports
     * [url=$DOCS_URL/tutorials/rendering/multiple_resolutions.html]multiple resolutions[/url] when
     * enabling full screen mode.
     */
    EXCLUSIVE_FULLSCREEN(4),
    ;

    public companion object {
      public fun from(`value`: Long): WindowMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ProgressState(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Stops displaying progress and returns the button to its normal state.
     */
    NOPROGRESS(0),
    /**
     * The progress indicator shows an indeterminate progress.
     *
     * On Windows, the progress indicator does not grow in size, but cycles repeatedly along the
     * length of the taskbar button by default.
     */
    INDETERMINATE(1),
    /**
     * The progress indicator shows progress normally.
     */
    NORMAL(2),
    /**
     * The progress indicator shows that an error has occurred.
     *
     * On Windows, the progress indicator turns red by default to show that an error has occurred in
     * one of the windows that is broadcasting progress.
     */
    ERROR(3),
    /**
     * The progress indicator shows it was paused.
     *
     * On Windows, the progress indicator turns yellow by default to show that progress is currently
     * stopped in one of the windows but can be resumed by the user.
     */
    PAUSED(4),
    ;

    public companion object {
      public fun from(`value`: Long): ProgressState = entries.single { it.`value` == `value` }
    }
  }

  public enum class WindowFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The window can't be resized by dragging its resize grip. It's still possible to resize the
     * window using [windowSetSize]. This flag is ignored for full screen windows.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, and Windows.
     */
    RESIZE_DISABLED(0),
    /**
     * The window do not have native title bar and other decorations. This flag is ignored for
     * full-screen windows.
     *
     * **Note:** This flag is implemented on Linux (X11/Wayland), macOS, and Windows.
     */
    BORDERLESS(1),
    /**
     * The window is floating on top of all other windows. This flag is ignored for full-screen
     * windows.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, and Windows.
     */
    ALWAYS_ON_TOP(2),
    /**
     * The window background can be transparent.
     *
     * **Note:** This flag has no effect if [isWindowTransparencyAvailable] returns `false`.
     *
     * **Note:** Transparency support is implemented on Linux (X11/Wayland), macOS, and Windows, but
     * availability might vary depending on GPU driver, display manager, and compositor capabilities.
     *
     * **Note:** Transparency support is implemented on Android, but can only be enabled via
     * [ProjectSettings.display/window/perPixelTransparency/allowed]. This flag has no effect on
     * Android.
     */
    TRANSPARENT(3),
    /**
     * The window can't be focused. No-focus window will ignore all input, except mouse clicks.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, and Windows.
     */
    NO_FOCUS(4),
    /**
     * Window is part of menu or [OptionButton] dropdown. This flag can't be changed when the window
     * is visible. An active popup window will exclusively receive all input, without stealing focus
     * from its parent. Popup windows are automatically closed when uses click outside it, or when an
     * application is switched. Popup window must have transient parent set (see [windowSetTransient]).
     *
     * **Note:** This flag is implemented on Linux (X11/Wayland), macOS, and Windows.
     */
    POPUP(5),
    /**
     * Window content is expanded to the full size of the window. Unlike borderless window, the
     * frame is left intact and can be used to resize the window, title bar is transparent, but have
     * minimize/maximize/close buttons.
     *
     * Use [windowSetWindowButtonsOffset] to adjust minimize/maximize/close buttons offset.
     *
     * Use [windowGetSafeTitleMargins] to determine area under the title bar that is not covered by
     * decorations.
     *
     * **Note:** This flag is implemented only on macOS.
     */
    EXTEND_TO_TITLE(6),
    /**
     * All mouse events are passed to the underlying window of the same application.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, and Windows.
     */
    MOUSE_PASSTHROUGH(7),
    /**
     * Window style is overridden, forcing sharp corners.
     *
     * **Note:** This flag is implemented only on Windows (11).
     */
    SHARP_CORNERS(8),
    /**
     * Window is excluded from screenshots taken by [screenGetImage], [screenGetImageRect], and
     * [screenGetPixel].
     *
     * **Note:** This flag is implemented on macOS and Windows (10, 20H1).
     *
     * **Note:** Setting this flag will prevent standard screenshot methods from capturing a window
     * image, but does **NOT** guarantee that other apps won't be able to capture an image. It should
     * not be used as a DRM or security measure.
     */
    EXCLUDE_FROM_CAPTURE(9),
    /**
     * Signals the window manager that this window is supposed to be an implementation-defined
     * "popup" (usually a floating, borderless, untileable and immovable child window).
     *
     * **Note:** This flag is implemented on Linux (Wayland).
     */
    POPUP_WM_HINT(10),
    /**
     * Window minimize button is disabled.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, and Windows.
     */
    MINIMIZE_DISABLED(11),
    /**
     * Window maximize button is disabled.
     *
     * **Note:** This flag is implemented on Linux (X11), macOS, and Windows.
     */
    MAXIMIZE_DISABLED(12),
    /**
     * Represents the size of the [WindowFlags] enum.
     */
    MAX(13),
    ;

    public companion object {
      public fun from(`value`: Long): WindowFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class WindowEvent(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Sent when the mouse pointer enters the window.
     */
    MOUSE_ENTER(0),
    /**
     * Sent when the mouse pointer exits the window.
     */
    MOUSE_EXIT(1),
    /**
     * Sent when the window grabs focus.
     */
    FOCUS_IN(2),
    /**
     * Sent when the window loses focus.
     */
    FOCUS_OUT(3),
    /**
     * Sent when the user has attempted to close the window (e.g. close button is pressed).
     */
    CLOSE_REQUEST(4),
    /**
     * Sent when the device "Back" button is pressed.
     *
     * **Note:** This event is implemented only on Android.
     */
    GO_BACK_REQUEST(5),
    /**
     * Sent when the window is moved to the display with different DPI, or display DPI is changed.
     *
     * **Note:** This flag is implemented only on macOS and Linux (Wayland).
     */
    DPI_CHANGE(6),
    /**
     * Sent when the window title bar decoration is changed (e.g. [WINDOW_FLAG_EXTEND_TO_TITLE] is
     * set or window entered/exited full screen mode).
     *
     * **Note:** This flag is implemented only on macOS.
     */
    TITLEBAR_CHANGE(7),
    /**
     * Sent when the window has been forcibly closed by the display server. The window will
     * immediately hide and clean any internal rendering references.
     *
     * **Note:** This flag is implemented only on Linux (Wayland).
     */
    FORCE_CLOSE(8),
    /**
     * Sent when the output max linear value returned by [Window.getOutputMaxLinearValue] has
     * changed.
     *
     * This occurs when HDR output is enabled or disabled and when any HDR output luminance values
     * of the window have changed, such as when the player adjusts their screen brightness setting or
     * moves the window to a different screen.
     */
    OUTPUT_MAX_LINEAR_VALUE_CHANGED(9),
    ;

    public companion object {
      public fun from(`value`: Long): WindowEvent = entries.single { it.`value` == `value` }
    }
  }

  public enum class WindowResizeEdge(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Top-left edge of a window.
     */
    EDGE_TOP_LEFT(0),
    /**
     * Top edge of a window.
     */
    EDGE_TOP(1),
    /**
     * Top-right edge of a window.
     */
    EDGE_TOP_RIGHT(2),
    /**
     * Left edge of a window.
     */
    EDGE_LEFT(3),
    /**
     * Right edge of a window.
     */
    EDGE_RIGHT(4),
    /**
     * Bottom-left edge of a window.
     */
    EDGE_BOTTOM_LEFT(5),
    /**
     * Bottom edge of a window.
     */
    EDGE_BOTTOM(6),
    /**
     * Bottom-right edge of a window.
     */
    EDGE_BOTTOM_RIGHT(7),
    /**
     * Represents the size of the [WindowResizeEdge] enum.
     */
    EDGE_MAX(8),
    ;

    public companion object {
      public fun from(`value`: Long): WindowResizeEdge = entries.single { it.`value` == `value` }
    }
  }

  public enum class VSyncMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No vertical synchronization, which means the engine will display frames as fast as possible
     * (tearing may be visible). Framerate is unlimited (regardless of [Engine.maxFps]).
     */
    VSYNC_DISABLED(0),
    /**
     * Default vertical synchronization mode, the image is displayed only on vertical blanking
     * intervals (no tearing is visible). Framerate is limited by the monitor refresh rate (regardless
     * of [Engine.maxFps]).
     */
    VSYNC_ENABLED(1),
    /**
     * Behaves like [VSYNC_DISABLED] when the framerate drops below the screen's refresh rate to
     * reduce stuttering (tearing may be visible). Otherwise, vertical synchronization is enabled to
     * avoid tearing. Framerate is limited by the monitor refresh rate (regardless of [Engine.maxFps]).
     * Behaves like [VSYNC_ENABLED] when using the Compatibility rendering method.
     */
    VSYNC_ADAPTIVE(2),
    /**
     * Displays the most recent image in the queue on vertical blanking intervals, while rendering
     * to the other images (no tearing is visible). Framerate is unlimited (regardless of
     * [Engine.maxFps]).
     *
     * Although not guaranteed, the images can be rendered as fast as possible, which may reduce
     * input lag (also called "Fast" V-Sync mode). [VSYNC_MAILBOX] works best when at least twice as
     * many frames as the display refresh rate are rendered. Behaves like [VSYNC_ENABLED] when using
     * the Compatibility rendering method.
     */
    VSYNC_MAILBOX(3),
    ;

    public companion object {
      public fun from(`value`: Long): VSyncMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class HandleType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Display handle:
     *
     * - Linux (X11): `X11::Display*` for the display.
     *
     * - Linux (Wayland): `wl_display` for the display.
     *
     * - Android: `EGLDisplay` for the display.
     */
    DISPLAY_HANDLE(0),
    /**
     * Window handle:
     *
     * - Windows: `HWND` for the window.
     *
     * - Linux (X11): `X11::Window*` for the window.
     *
     * - Linux (Wayland): `wl_surface` for the window.
     *
     * - macOS: `NSWindow*` for the window.
     *
     * - iOS: `UIViewController*` for the view controller.
     *
     * - Android: `jObject` for the activity.
     */
    WINDOW_HANDLE(1),
    /**
     * Window view:
     *
     * - Windows: `HDC` for the window (only with the Compatibility renderer).
     *
     * - macOS: `NSView*` for the window main view.
     *
     * - iOS: `UIView*` for the window main view.
     */
    WINDOW_VIEW(2),
    /**
     * OpenGL context (only with the Compatibility renderer):
     *
     * - Windows: `HGLRC` for the window (native GL), or `EGLContext` for the window (ANGLE).
     *
     * - Linux (X11): `GLXContext*` for the window.
     *
     * - Linux (Wayland): `EGLContext` for the window.
     *
     * - macOS: `NSOpenGLContext*` for the window (native GL), or `EGLContext` for the window
     * (ANGLE).
     *
     * - Android: `EGLContext` for the window.
     */
    OPENGL_CONTEXT(3),
    /**
     * - Windows: `EGLDisplay` for the window (ANGLE).
     *
     * - macOS: `EGLDisplay` for the window (ANGLE).
     *
     * - Linux (Wayland): `EGLDisplay` for the window.
     */
    EGL_DISPLAY(4),
    /**
     * - Windows: `EGLConfig` for the window (ANGLE).
     *
     * - macOS: `EGLConfig` for the window (ANGLE).
     *
     * - Linux (Wayland): `EGLConfig` for the window.
     */
    EGL_CONFIG(5),
    /**
     * The GLX `VisualID` for the window.
     *
     * **Note:** Only available on Linux when using X11.
     */
    GLX_VISUALID(6),
    /**
     * The `GLXFBConfig` for the window.
     *
     * **Note:** Only available on Linux when using X11.
     */
    GLX_FBCONFIG(7),
    ;

    public companion object {
      public fun from(`value`: Long): HandleType = entries.single { it.`value` == `value` }
    }
  }

  public enum class TTSUtteranceEvent(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Utterance has begun to be spoken.
     */
    STARTED(0),
    /**
     * Utterance was successfully finished.
     */
    ENDED(1),
    /**
     * Utterance was canceled, or TTS service was unable to process it.
     */
    CANCELED(2),
    /**
     * Utterance reached a word or sentence boundary.
     */
    BOUNDARY(3),
    ;

    public companion object {
      public fun from(`value`: Long): TTSUtteranceEvent = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val hasFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "has_feature", 334065950)

    internal val getNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_name", 201670096)

    internal val helpSetSearchCallbacksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "help_set_search_callbacks", 1687350599)

    internal val globalMenuSetPopupCallbacksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_popup_callbacks", 3893727526)

    internal val globalMenuAddSubmenuItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_submenu_item", 2828985934)

    internal val globalMenuAddItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_item", 3616842746)

    internal val globalMenuAddCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_check_item", 3616842746)

    internal val globalMenuAddIconItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_icon_item", 3867083847)

    internal val globalMenuAddIconCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_icon_check_item", 3867083847)

    internal val globalMenuAddRadioCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_radio_check_item", 3616842746)

    internal val globalMenuAddIconRadioCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_icon_radio_check_item", 3867083847)

    internal val globalMenuAddMultistateItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_multistate_item", 3297554655)

    internal val globalMenuAddSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_add_separator", 3214812433)

    internal val globalMenuGetItemIndexFromTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_index_from_text", 2878152881)

    internal val globalMenuGetItemIndexFromTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_index_from_tag", 2941063483)

    internal val globalMenuIsItemCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_is_item_checked", 3511468594)

    internal val globalMenuIsItemCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_is_item_checkable", 3511468594)

    internal val globalMenuIsItemRadioCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_is_item_radio_checkable", 3511468594)

    internal val globalMenuGetItemCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_callback", 748666903)

    internal val globalMenuGetItemKeyCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_key_callback", 748666903)

    internal val globalMenuGetItemTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_tag", 330672633)

    internal val globalMenuGetItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_text", 591067909)

    internal val globalMenuGetItemSubmenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_submenu", 591067909)

    internal val globalMenuGetItemAcceleratorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_accelerator", 936065394)

    internal val globalMenuIsItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_is_item_disabled", 3511468594)

    internal val globalMenuIsItemHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_is_item_hidden", 3511468594)

    internal val globalMenuGetItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_tooltip", 591067909)

    internal val globalMenuGetItemStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_state", 3422818498)

    internal val globalMenuGetItemMaxStatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_max_states", 3422818498)

    internal val globalMenuGetItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_icon", 3591713183)

    internal val globalMenuGetItemIndentationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_indentation_level", 3422818498)

    internal val globalMenuSetItemCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_checked", 4108344793)

    internal val globalMenuSetItemCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_checkable", 4108344793)

    internal val globalMenuSetItemRadioCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_radio_checkable", 4108344793)

    internal val globalMenuSetItemCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_callback", 3809915389)

    internal val globalMenuSetItemHoverCallbacksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_hover_callbacks", 3809915389)

    internal val globalMenuSetItemKeyCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_key_callback", 3809915389)

    internal val globalMenuSetItemTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_tag", 453659863)

    internal val globalMenuSetItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_text", 965966136)

    internal val globalMenuSetItemSubmenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_submenu", 965966136)

    internal val globalMenuSetItemAcceleratorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_accelerator", 566943293)

    internal val globalMenuSetItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_disabled", 4108344793)

    internal val globalMenuSetItemHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_hidden", 4108344793)

    internal val globalMenuSetItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_tooltip", 965966136)

    internal val globalMenuSetItemStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_state", 3474840532)

    internal val globalMenuSetItemMaxStatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_max_states", 3474840532)

    internal val globalMenuSetItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_icon", 3201338066)

    internal val globalMenuSetItemIndentationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_set_item_indentation_level", 3474840532)

    internal val globalMenuGetItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_item_count", 1321353865)

    internal val globalMenuRemoveItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_remove_item", 2956805083)

    internal val globalMenuClearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_clear", 83702148)

    internal val globalMenuGetSystemMenuRootsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "global_menu_get_system_menu_roots", 3102165223)

    internal val ttsIsSpeakingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_is_speaking", 36873697)

    internal val ttsIsPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_is_paused", 36873697)

    internal val ttsGetVoicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_get_voices", 3995934104)

    internal val ttsGetVoicesForLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_get_voices_for_language", 4291131558)

    internal val ttsSpeakPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_speak", 903992738)

    internal val ttsPausePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_pause", 3218959716)

    internal val ttsResumePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_resume", 3218959716)

    internal val ttsStopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_stop", 3218959716)

    internal val ttsSetUtteranceCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tts_set_utterance_callback", 109679083)

    internal val isDarkModeSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "is_dark_mode_supported", 36873697)

    internal val isDarkModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "is_dark_mode", 36873697)

    internal val getAccentColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_accent_color", 3444240500)

    internal val getBaseColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_base_color", 3444240500)

    internal val setSystemThemeChangeCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "set_system_theme_change_callback", 1611583062)

    internal val mouseSetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "mouse_set_mode", 348288463)

    internal val mouseGetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "mouse_get_mode", 1353961651)

    internal val warpMousePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "warp_mouse", 1130785943)

    internal val mouseGetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "mouse_get_position", 3690982128)

    internal val mouseGetButtonStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "mouse_get_button_state", 2512161324)

    internal val clipboardSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "clipboard_set", 83702148)

    internal val clipboardGetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "clipboard_get", 201670096)

    internal val clipboardGetImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "clipboard_get_image", 4190603485)

    internal val clipboardHasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "clipboard_has", 36873697)

    internal val clipboardHasImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "clipboard_has_image", 36873697)

    internal val clipboardSetPrimaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "clipboard_set_primary", 83702148)

    internal val clipboardGetPrimaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "clipboard_get_primary", 201670096)

    internal val getDisplayCutoutsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_display_cutouts", 3995934104)

    internal val getDisplaySafeAreaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_display_safe_area", 410525958)

    internal val getScreenCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_screen_count", 3905245786)

    internal val getPrimaryScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_primary_screen", 3905245786)

    internal val getKeyboardFocusScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_keyboard_focus_screen", 3905245786)

    internal val getScreenFromRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_screen_from_rect", 741354659)

    internal val screenGetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_position", 1725937825)

    internal val screenGetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_size", 1725937825)

    internal val screenGetUsableRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_usable_rect", 2439012528)

    internal val screenGetDpiPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_dpi", 181039630)

    internal val screenGetScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_scale", 909105437)

    internal val isTouchscreenAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "is_touchscreen_available", 36873697)

    internal val screenGetMaxScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_max_scale", 1740695150)

    internal val screenGetRefreshRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_refresh_rate", 909105437)

    internal val screenGetPixelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_pixel", 1532707496)

    internal val screenGetImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_image", 3813388802)

    internal val screenGetImageRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_image_rect", 2601441065)

    internal val screenSetOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_set_orientation", 2211511631)

    internal val screenGetOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_get_orientation", 133818562)

    internal val screenSetKeepOnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_set_keep_on", 2586408642)

    internal val screenIsKeptOnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "screen_is_kept_on", 36873697)

    internal val getWindowListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_window_list", 1930428628)

    internal val getWindowAtScreenPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_window_at_screen_position", 2485466453)

    internal val windowGetNativeHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_native_handle", 1096425680)

    internal val windowGetActivePopupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_active_popup", 3905245786)

    internal val windowSetPopupSafeRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_popup_safe_rect", 3317281434)

    internal val windowGetPopupSafeRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_popup_safe_rect", 2161169500)

    internal val windowSetTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_title", 441246282)

    internal val windowGetTitleSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_title_size", 2925301799)

    internal val windowSetMousePassthroughPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_mouse_passthrough", 1993637420)

    internal val windowGetCurrentScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_current_screen", 1591665591)

    internal val windowSetCurrentScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_current_screen", 2230941749)

    internal val windowGetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_position", 763922886)

    internal val windowGetPositionWithDecorationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_position_with_decorations", 763922886)

    internal val windowSetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_position", 2019273902)

    internal val windowGetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_size", 763922886)

    internal val windowSetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_size", 2019273902)

    internal val windowSetRectChangedCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_rect_changed_callback", 1091192925)

    internal val windowSetWindowEventCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_window_event_callback", 1091192925)

    internal val windowSetInputEventCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_input_event_callback", 1091192925)

    internal val windowSetInputTextCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_input_text_callback", 1091192925)

    internal val windowSetDropFilesCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_drop_files_callback", 1091192925)

    internal val windowGetAttachedInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_attached_instance_id", 1591665591)

    internal val windowGetMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_max_size", 763922886)

    internal val windowSetMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_max_size", 2019273902)

    internal val windowGetMinSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_min_size", 763922886)

    internal val windowSetMinSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_min_size", 2019273902)

    internal val windowGetSizeWithDecorationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_size_with_decorations", 763922886)

    internal val windowGetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_mode", 2185728461)

    internal val windowSetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_mode", 1319965401)

    internal val windowSetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_flag", 254894155)

    internal val windowGetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_flag", 802816991)

    internal val windowSetIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_icon", 2457502155)

    internal val windowSetWindowButtonsOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_window_buttons_offset", 2019273902)

    internal val windowGetSafeTitleMarginsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_safe_title_margins", 2295066620)

    internal val windowRequestAttentionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_request_attention", 1995695955)

    internal val windowSetTaskbarProgressValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_taskbar_progress_value", 3506631519)

    internal val windowSetTaskbarProgressStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_taskbar_progress_state", 4119882768)

    internal val windowMoveToForegroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_move_to_foreground", 1995695955)

    internal val windowIsFocusedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_is_focused", 1051549951)

    internal val windowCanDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_can_draw", 1051549951)

    internal val windowSetTransientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_transient", 3937882851)

    internal val windowSetExclusivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_exclusive", 300928843)

    internal val windowSetImeActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_ime_active", 1661950165)

    internal val windowSetImePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_ime_position", 2019273902)

    internal val windowSetVsyncModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_vsync_mode", 2179333492)

    internal val windowGetVsyncModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_vsync_mode", 578873795)

    internal val windowIsHdrOutputSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_is_hdr_output_supported", 1051549951)

    internal val windowRequestHdrOutputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_request_hdr_output", 1661950165)

    internal val windowIsHdrOutputRequestedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_is_hdr_output_requested", 1051549951)

    internal val windowIsHdrOutputEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_is_hdr_output_enabled", 1051549951)

    internal val windowSetHdrOutputReferenceLuminancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_hdr_output_reference_luminance", 3506631519)

    internal val windowGetHdrOutputReferenceLuminancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_hdr_output_reference_luminance", 218038398)

    internal val windowGetHdrOutputCurrentReferenceLuminancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_hdr_output_current_reference_luminance", 218038398)

    internal val windowSetHdrOutputMaxLuminancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_hdr_output_max_luminance", 3506631519)

    internal val windowGetHdrOutputMaxLuminancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_hdr_output_max_luminance", 218038398)

    internal val windowGetHdrOutputCurrentMaxLuminancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_hdr_output_current_max_luminance", 218038398)

    internal val windowGetOutputMaxLinearValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_get_output_max_linear_value", 218038398)

    internal val windowIsMaximizeAllowedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_is_maximize_allowed", 1051549951)

    internal val windowMaximizeOnTitleDblClickPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_maximize_on_title_dbl_click", 36873697)

    internal val windowMinimizeOnTitleDblClickPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_minimize_on_title_dbl_click", 36873697)

    internal val windowStartDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_start_drag", 1995695955)

    internal val windowStartResizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_start_resize", 4009722312)

    internal val windowSetColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "window_set_color", 2920490490)

    internal val accessibilityShouldIncreaseContrastPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_should_increase_contrast", 3905245786)

    internal val accessibilityShouldReduceAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_should_reduce_animation", 3905245786)

    internal val accessibilityShouldReduceTransparencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_should_reduce_transparency", 3905245786)

    internal val accessibilityScreenReaderActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_screen_reader_active", 3905245786)

    internal val accessibilityCreateElementPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_create_element", 2968347744)

    internal val accessibilityCreateSubElementPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_create_sub_element", 1949948826)

    internal val accessibilityCreateSubTextEditElementsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_create_sub_text_edit_elements", 2702009895)

    internal val accessibilityHasElementPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_has_element", 4155700596)

    internal val accessibilityFreeElementPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_free_element", 2722037293)

    internal val accessibilityElementSetMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_element_set_meta", 3175752987)

    internal val accessibilityElementGetMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_element_get_meta", 4171304767)

    internal val accessibilitySetWindowRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_set_window_rect", 2386961724)

    internal val accessibilitySetWindowFocusedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_set_window_focused", 300928843)

    internal val accessibilityUpdateSetFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_focus", 2722037293)

    internal val accessibilityGetWindowRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_get_window_root", 495598643)

    internal val accessibilityUpdateSetRolePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_role", 3352768215)

    internal val accessibilityUpdateSetNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_name", 2726140452)

    internal val accessibilityUpdateSetExtraInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_extra_info", 2726140452)

    internal val accessibilityUpdateSetDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_description", 2726140452)

    internal val accessibilityUpdateSetValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_value", 2726140452)

    internal val accessibilityUpdateSetTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_tooltip", 2726140452)

    internal val accessibilityUpdateSetBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_bounds", 1378122625)

    internal val accessibilityUpdateSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_transform", 1246044741)

    internal val accessibilityUpdateAddChildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_child", 395945892)

    internal val accessibilityUpdateAddRelatedControlsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_related_controls", 395945892)

    internal val accessibilityUpdateAddRelatedDetailsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_related_details", 395945892)

    internal val accessibilityUpdateAddRelatedDescribedByPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_related_described_by", 395945892)

    internal val accessibilityUpdateAddRelatedFlowToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_related_flow_to", 395945892)

    internal val accessibilityUpdateAddRelatedLabeledByPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_related_labeled_by", 395945892)

    internal val accessibilityUpdateAddRelatedRadioGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_related_radio_group", 395945892)

    internal val accessibilityUpdateSetActiveDescendantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_active_descendant", 395945892)

    internal val accessibilityUpdateSetNextOnLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_next_on_line", 395945892)

    internal val accessibilityUpdateSetPreviousOnLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_previous_on_line", 395945892)

    internal val accessibilityUpdateSetMemberOfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_member_of", 395945892)

    internal val accessibilityUpdateSetInPageLinkTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_in_page_link_target", 395945892)

    internal val accessibilityUpdateSetErrorMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_error_message", 395945892)

    internal val accessibilityUpdateSetLivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_live", 2683302212)

    internal val accessibilityUpdateAddActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_action", 2898696987)

    internal val accessibilityUpdateAddCustomActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_add_custom_action", 4153150897)

    internal val accessibilityUpdateSetTableRowCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_table_row_count", 3411492887)

    internal val accessibilityUpdateSetTableColumnCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_table_column_count", 3411492887)

    internal val accessibilityUpdateSetTableRowIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_table_row_index", 3411492887)

    internal val accessibilityUpdateSetTableColumnIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_table_column_index", 3411492887)

    internal val accessibilityUpdateSetTableCellPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_table_cell_position", 4288446313)

    internal val accessibilityUpdateSetTableCellSpanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_table_cell_span", 4288446313)

    internal val accessibilityUpdateSetListItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_list_item_count", 3411492887)

    internal val accessibilityUpdateSetListItemIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_list_item_index", 3411492887)

    internal val accessibilityUpdateSetListItemLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_list_item_level", 3411492887)

    internal val accessibilityUpdateSetListItemSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_list_item_selected", 1265174801)

    internal val accessibilityUpdateSetListItemExpandedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_list_item_expanded", 1265174801)

    internal val accessibilityUpdateSetPopupTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_popup_type", 2040885448)

    internal val accessibilityUpdateSetCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_checked", 1265174801)

    internal val accessibilityUpdateSetNumValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_num_value", 1794382983)

    internal val accessibilityUpdateSetNumRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_num_range", 2513314492)

    internal val accessibilityUpdateSetNumStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_num_step", 1794382983)

    internal val accessibilityUpdateSetNumJumpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_num_jump", 1794382983)

    internal val accessibilityUpdateSetScrollXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_scroll_x", 1794382983)

    internal val accessibilityUpdateSetScrollXRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_scroll_x_range", 2513314492)

    internal val accessibilityUpdateSetScrollYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_scroll_y", 1794382983)

    internal val accessibilityUpdateSetScrollYRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_scroll_y_range", 2513314492)

    internal val accessibilityUpdateSetTextDecorationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_text_decorations", 1672422386)

    internal val accessibilityUpdateSetTextAlignPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_text_align", 3725995085)

    internal val accessibilityUpdateSetTextSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_text_selection", 3119144029)

    internal val accessibilityUpdateSetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_flag", 3758675396)

    internal val accessibilityUpdateSetClassnamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_classname", 2726140452)

    internal val accessibilityUpdateSetPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_placeholder", 2726140452)

    internal val accessibilityUpdateSetLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_language", 2726140452)

    internal val accessibilityUpdateSetTextOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_text_orientation", 1265174801)

    internal val accessibilityUpdateSetListOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_list_orientation", 1265174801)

    internal val accessibilityUpdateSetShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_shortcut", 2726140452)

    internal val accessibilityUpdateSetUrlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_url", 2726140452)

    internal val accessibilityUpdateSetRoleDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_role_description", 2726140452)

    internal val accessibilityUpdateSetStateDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_state_description", 2726140452)

    internal val accessibilityUpdateSetColorValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_color_value", 2948539648)

    internal val accessibilityUpdateSetBackgroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_background_color", 2948539648)

    internal val accessibilityUpdateSetForegroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "accessibility_update_set_foreground_color", 2948539648)

    internal val imeGetSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "ime_get_selection", 3690982128)

    internal val imeGetTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "ime_get_text", 201670096)

    internal val virtualKeyboardShowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "virtual_keyboard_show", 3042891259)

    internal val virtualKeyboardHidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "virtual_keyboard_hide", 3218959716)

    internal val virtualKeyboardGetHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "virtual_keyboard_get_height", 3905245786)

    internal val hasHardwareKeyboardPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "has_hardware_keyboard", 36873697)

    internal val setHardwareKeyboardConnectionChangeCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "set_hardware_keyboard_connection_change_callback", 1611583062)

    internal val cursorSetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "cursor_set_shape", 2026291549)

    internal val cursorGetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "cursor_get_shape", 1087724927)

    internal val cursorSetCustomImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "cursor_set_custom_image", 1816663697)

    internal val getSwapCancelOkPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "get_swap_cancel_ok", 2240911060)

    internal val enableForStealingFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "enable_for_stealing_focus", 1286410249)

    internal val dialogShowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "dialog_show", 4115553226)

    internal val dialogInputTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "dialog_input_text", 3088703427)

    internal val fileDialogShowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "file_dialog_show", 1386825884)

    internal val fileDialogWithOptionsShowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "file_dialog_with_options_show", 1448789813)

    internal val beepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "beep", 4051624405)

    internal val keyboardGetLayoutCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "keyboard_get_layout_count", 3905245786)

    internal val keyboardGetCurrentLayoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "keyboard_get_current_layout", 3905245786)

    internal val keyboardSetCurrentLayoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "keyboard_set_current_layout", 1286410249)

    internal val keyboardGetLayoutLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "keyboard_get_layout_language", 844755477)

    internal val keyboardGetLayoutNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "keyboard_get_layout_name", 844755477)

    internal val keyboardGetKeycodeFromPhysicalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "keyboard_get_keycode_from_physical", 3447613187)

    internal val keyboardGetLabelFromPhysicalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "keyboard_get_label_from_physical", 3447613187)

    internal val showEmojiAndSymbolPickerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "show_emoji_and_symbol_picker", 4051624405)

    internal val colorPickerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "color_picker", 151643214)

    internal val processEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "process_events", 3218959716)

    internal val forceProcessAndDropEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "force_process_and_drop_events", 3218959716)

    internal val setNativeIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "set_native_icon", 83702148)

    internal val setIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "set_icon", 532598488)

    internal val createStatusIndicatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "create_status_indicator", 1904285171)

    internal val statusIndicatorSetIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "status_indicator_set_icon", 666127730)

    internal val statusIndicatorSetTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "status_indicator_set_tooltip", 501894301)

    internal val statusIndicatorSetMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "status_indicator_set_menu", 4040184819)

    internal val statusIndicatorSetCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "status_indicator_set_callback", 957362965)

    internal val statusIndicatorGetRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "status_indicator_get_rect", 3327874267)

    internal val deleteStatusIndicatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "delete_status_indicator", 1286410249)

    internal val tabletGetDriverCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tablet_get_driver_count", 3905245786)

    internal val tabletGetDriverNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tablet_get_driver_name", 844755477)

    internal val tabletGetCurrentDriverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tablet_get_current_driver", 201670096)

    internal val tabletSetCurrentDriverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "tablet_set_current_driver", 83702148)

    internal val isWindowTransparencyAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "is_window_transparency_available", 36873697)

    internal val registerAdditionalOutputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "register_additional_output", 3975164845)

    internal val unregisterAdditionalOutputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "unregister_additional_output", 3975164845)

    internal val hasAdditionalOutputsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "has_additional_outputs", 36873697)

    internal val isInPipModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "is_in_pip_mode", 1885608816)

    internal val pipModeEnterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "pip_mode_enter", 1995695955)

    internal val pipModeSetAspectRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "pip_mode_set_aspect_ratio", 3471927553)

    internal val pipModeSetAutoEnterOnBackgroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DisplayServer", "pip_mode_set_auto_enter_on_background", 1661950165)
  }
}
