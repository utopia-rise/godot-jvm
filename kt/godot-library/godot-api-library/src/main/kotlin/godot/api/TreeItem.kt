// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_LONG_ANY
import godot.callMethod_LONG_CALLABLE
import godot.callMethod_LONG_LONG_STRING
import godot.callMethod_LONG_LONG_ret_STRING
import godot.callMethod_LONG_OBJECT_LONG_BOOL_STRING_STRING
import godot.callMethod_LONG_STRING
import godot.callMethod_LONG_ret_ANY
import godot.callMethod_LONG_ret_CALLABLE
import godot.callMethod_LONG_ret_STRING
import godot.callMethod_STRING_NAME_VARARG
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_BOOL_ret_BOOL
import godot.callPtrMethod_BOOL_ret_OBJECT
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_ARRAY
import godot.callPtrMethod_LONG_BOOL
import godot.callPtrMethod_LONG_COLOR
import godot.callPtrMethod_LONG_COLOR_BOOL
import godot.callPtrMethod_LONG_DOUBLE
import godot.callPtrMethod_LONG_DOUBLE_DOUBLE_DOUBLE_BOOL
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_LONG_BOOL
import godot.callPtrMethod_LONG_LONG_COLOR
import godot.callPtrMethod_LONG_LONG_OBJECT
import godot.callPtrMethod_LONG_LONG_ret_BOOL
import godot.callPtrMethod_LONG_LONG_ret_COLOR
import godot.callPtrMethod_LONG_LONG_ret_LONG
import godot.callPtrMethod_LONG_LONG_ret_OBJECT_REF
import godot.callPtrMethod_LONG_OBJECT
import godot.callPtrMethod_LONG_OBJECT_STRING_NAME
import godot.callPtrMethod_LONG_RECT2
import godot.callPtrMethod_LONG_ret_ARRAY
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_COLOR
import godot.callPtrMethod_LONG_ret_DICTIONARY
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_OBJECT
import godot.callPtrMethod_LONG_ret_OBJECT_REF
import godot.callPtrMethod_LONG_ret_RECT2
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.Callable
import godot.core.Color
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.Rect2
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A single item of a [Tree] control. It can contain other [TreeItem]s as children, which allows it
 * to create a hierarchy. It can also contain text and buttons. [TreeItem] is not a [Node], it is
 * internal to the [Tree].
 *
 * To create a [TreeItem], use [Tree.createItem] or [TreeItem.createChild]. To remove a [TreeItem],
 * use [Object.free].
 *
 * **Note:** The ID values used for buttons are 32-bit, unlike [Long] which is always 64-bit. They
 * go from `-2147483648` to `2147483647`.
 */
@GodotBaseType
public open class TreeItem internal constructor() : Object() {
  /**
   * If `true`, the TreeItem is collapsed.
   */
  public final inline var collapsed: Boolean
    @JvmName("collapsedProperty")
    get() = isCollapsed()
    @JvmName("collapsedProperty")
    set(`value`) {
      setCollapsed(value)
    }

  /**
   * If `true`, the [TreeItem] is visible (default).
   *
   * Note that if a [TreeItem] is set to not be visible, none of its children will be visible
   * either.
   */
  public final inline var visible: Boolean
    @JvmName("visibleProperty")
    get() = isVisible()
    @JvmName("visibleProperty")
    set(`value`) {
      setVisible(value)
    }

  /**
   * If `true`, folding is disabled for this TreeItem.
   */
  public final inline var disableFolding: Boolean
    @JvmName("disableFoldingProperty")
    get() = isFoldingDisabled()
    @JvmName("disableFoldingProperty")
    set(`value`) {
      setDisableFolding(value)
    }

  /**
   * The custom minimum height.
   */
  public final inline var customMinimumHeight: Int
    @JvmName("customMinimumHeightProperty")
    get() = getCustomMinimumHeight()
    @JvmName("customMinimumHeightProperty")
    set(`value`) {
      setCustomMinimumHeight(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(772, scriptPtr)
  }

  /**
   * Sets the given column's cell mode to [mode]. This determines how the cell is displayed and
   * edited.
   */
  public final fun setCellMode(column: Int, mode: TreeCellMode): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setCellModePtr, column.toLong(), mode.value)
  }

  /**
   * Returns the column's cell mode.
   */
  public final fun getCellMode(column: Int): TreeCellMode =
      TreeCellMode.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getCellModePtr, column.toLong()))

  /**
   * Sets the given column's auto translate mode to [mode].
   *
   * All columns use [Node.AUTO_TRANSLATE_MODE_INHERIT] by default, which uses the same auto
   * translate mode as the [Tree] itself.
   */
  public final fun setAutoTranslateMode(column: Int, mode: Node.AutoTranslateMode): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setAutoTranslateModePtr, column.toLong(), mode.value)
  }

  /**
   * Returns the column's auto translate mode.
   */
  public final fun getAutoTranslateMode(column: Int): Node.AutoTranslateMode =
      Node.AutoTranslateMode.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getAutoTranslateModePtr, column.toLong()))

  /**
   * If [multiline] is `true`, the given [column] is multiline editable.
   *
   * **Note:** This option only affects the type of control ([LineEdit] or [TextEdit]) that appears
   * when editing the column. You can set multiline values with [setText] even if the column is not
   * multiline editable.
   */
  public final fun setEditMultiline(column: Int, multiline: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setEditMultilinePtr, column.toLong(), multiline)
  }

  /**
   * Returns `true` if the given [column] is multiline editable.
   */
  public final fun isEditMultiline(column: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isEditMultilinePtr, column.toLong())

  /**
   * If [checked] is `true`, the given [column] is checked. Clears column's indeterminate status.
   */
  public final fun setChecked(column: Int, checked: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setCheckedPtr, column.toLong(), checked)
  }

  /**
   * If [indeterminate] is `true`, the given [column] is marked indeterminate.
   *
   * **Note:** If set `true` from `false`, then column is cleared of checked status.
   */
  public final fun setIndeterminate(column: Int, indeterminate: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setIndeterminatePtr, column.toLong(), indeterminate)
  }

  /**
   * Returns `true` if the given [column] is checked.
   */
  public final fun isChecked(column: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isCheckedPtr, column.toLong())

  /**
   * Returns `true` if the given [column] is indeterminate.
   */
  public final fun isIndeterminate(column: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isIndeterminatePtr, column.toLong())

  /**
   * Propagates this item's checked status to its children and parents for the given [column]. It is
   * possible to process the items affected by this method call by connecting to [signal
   * Tree.check_propagated_to_item]. The order that the items affected will be processed is as follows:
   * the item invoking this method, children of that item, and finally parents of that item. If
   * [emitSignal] is `false`, then [signal Tree.check_propagated_to_item] will not be emitted.
   */
  @JvmOverloads
  public final fun propagateCheck(column: Int, emitSignal: Boolean = true): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.propagateCheckPtr, column.toLong(), emitSignal)
  }

  /**
   * Sets the given column's text value.
   */
  public final fun setText(column: Int, text: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setTextPtr, column.toLong(), text)
  }

  /**
   * Returns the given column's text.
   */
  public final fun getText(column: Int): String =
      TransferContext.callMethod_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getTextPtr, column.toLong())

  /**
   * Sets the given column's description for assistive apps.
   */
  public final fun setDescription(column: Int, description: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setDescriptionPtr, column.toLong(), description)
  }

  /**
   * Returns the given column's description for assistive apps.
   */
  public final fun getDescription(column: Int): String =
      TransferContext.callMethod_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getDescriptionPtr, column.toLong())

  /**
   * Sets item's text base writing direction.
   */
  public final fun setTextDirection(column: Int, direction: Control.TextDirection): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setTextDirectionPtr, column.toLong(), direction.value)
  }

  /**
   * Returns item's text base writing direction.
   */
  public final fun getTextDirection(column: Int): Control.TextDirection =
      Control.TextDirection.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getTextDirectionPtr, column.toLong()))

  /**
   * Sets the autowrap mode in the given [column]. If set to something other than
   * [TextServer.AUTOWRAP_OFF], the text gets wrapped inside the cell's bounding rectangle.
   */
  public final fun setAutowrapMode(column: Int, autowrapMode: TextServer.AutowrapMode): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setAutowrapModePtr, column.toLong(), autowrapMode.value)
  }

  /**
   * Returns the text autowrap mode in the given [column]. By default it is
   * [TextServer.AUTOWRAP_OFF].
   */
  public final fun getAutowrapMode(column: Int): TextServer.AutowrapMode =
      TextServer.AutowrapMode.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getAutowrapModePtr, column.toLong()))

  /**
   * Sets the autowrap trim flags for the given [column]. These flags control whether leading and
   * trailing spaces are trimmed on wrapped lines. Set to `0` to disable all trimming.
   */
  public final fun setAutowrapTrimFlags(column: Int, flags: TextServer.LineBreakFlag): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setAutowrapTrimFlagsPtr, column.toLong(), flags.flag)
  }

  /**
   * Returns the autowrap trim flags for the given [column]. By default, both
   * [TextServer.BREAK_TRIM_START_EDGE_SPACES] and [TextServer.BREAK_TRIM_END_EDGE_SPACES] are enabled.
   */
  public final fun getAutowrapTrimFlags(column: Int): TextServer.LineBreakFlag =
      TextServer.LineBreakFlag(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getAutowrapTrimFlagsPtr, column.toLong()))

  /**
   * Sets the clipping behavior when the text exceeds the item's bounding rectangle in the given
   * [column].
   */
  public final fun setTextOverrunBehavior(column: Int, overrunBehavior: TextServer.OverrunBehavior):
      Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setTextOverrunBehaviorPtr, column.toLong(), overrunBehavior.value)
  }

  /**
   * Returns the clipping behavior when the text exceeds the item's bounding rectangle in the given
   * [column]. By default it is [TextServer.OVERRUN_TRIM_ELLIPSIS].
   */
  public final fun getTextOverrunBehavior(column: Int): TextServer.OverrunBehavior =
      TextServer.OverrunBehavior.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getTextOverrunBehaviorPtr, column.toLong()))

  /**
   * Set BiDi algorithm override for the structured text. Has effect for cells that display text.
   */
  public final fun setStructuredTextBidiOverride(column: Int,
      parser: TextServer.StructuredTextParser): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setStructuredTextBidiOverridePtr, column.toLong(), parser.value)
  }

  /**
   * Returns the BiDi algorithm override set for this cell.
   */
  public final fun getStructuredTextBidiOverride(column: Int): TextServer.StructuredTextParser =
      TextServer.StructuredTextParser.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getStructuredTextBidiOverridePtr, column.toLong()))

  /**
   * Set additional options for BiDi override. Has effect for cells that display text.
   */
  public final fun setStructuredTextBidiOverrideOptions(column: Int, args: VariantArray<Any?>):
      Unit {
    TransferContext.callPtrMethod_LONG_ARRAY(ptr, objectID.id, MethodBindings.setStructuredTextBidiOverrideOptionsPtr, column.toLong(), args)
  }

  /**
   * Returns the additional BiDi options set for this cell.
   */
  public final fun getStructuredTextBidiOverrideOptions(column: Int): VariantArray<Any?> =
      (TransferContext.callPtrMethod_LONG_ret_ARRAY(ptr, objectID.id, MethodBindings.getStructuredTextBidiOverrideOptionsPtr, column.toLong()) as VariantArray<Any?>)

  /**
   * Sets the language code of the given [column]'s text to [language]. This is used for
   * line-breaking and text shaping algorithms. If [language] is empty, the current locale is used.
   */
  public final fun setLanguage(column: Int, language: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setLanguagePtr, column.toLong(), language)
  }

  /**
   * Returns item's text language code.
   */
  public final fun getLanguage(column: Int): String =
      TransferContext.callMethod_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getLanguagePtr, column.toLong())

  /**
   * Sets a string to be shown after a column's value (for example, a unit abbreviation).
   */
  public final fun setSuffix(column: Int, text: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setSuffixPtr, column.toLong(), text)
  }

  /**
   * Gets the suffix string shown after the column value.
   */
  public final fun getSuffix(column: Int): String =
      TransferContext.callMethod_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getSuffixPtr, column.toLong())

  /**
   * Sets the given cell's icon [Texture2D]. If the cell is in [CELL_MODE_ICON] mode, the icon is
   * displayed in the center of the cell. Otherwise, the icon is displayed before the cell's text.
   * [CELL_MODE_RANGE] does not display an icon.
   */
  public final fun setIcon(column: Int, texture: Texture2D?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setIconPtr, column.toLong(), texture)
  }

  /**
   * Returns the given column's icon [Texture2D]. Error if no icon is set.
   */
  public final fun getIcon(column: Int): Texture2D? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getIconPtr, column.toLong()) as Texture2D?)

  /**
   * Sets the given cell's icon overlay [Texture2D]. The cell has to be in [CELL_MODE_ICON] mode,
   * and icon has to be set. Overlay is drawn on top of icon, in the bottom left corner.
   */
  public final fun setIconOverlay(column: Int, texture: Texture2D?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setIconOverlayPtr, column.toLong(), texture)
  }

  /**
   * Returns the given column's icon overlay [Texture2D].
   */
  public final fun getIconOverlay(column: Int): Texture2D? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getIconOverlayPtr, column.toLong()) as Texture2D?)

  /**
   * Sets the given column's icon's texture region.
   */
  public final fun setIconRegion(column: Int, region: Rect2): Unit {
    TransferContext.callPtrMethod_LONG_RECT2(ptr, objectID.id, MethodBindings.setIconRegionPtr, column.toLong(), region)
  }

  /**
   * Returns the icon [Texture2D] region as [Rect2].
   */
  public final fun getIconRegion(column: Int): Rect2 =
      TransferContext.callPtrMethod_LONG_ret_RECT2(ptr, objectID.id, MethodBindings.getIconRegionPtr, column.toLong())

  /**
   * Sets the maximum allowed width of the icon in the given [column]. This limit is applied on top
   * of the default size of the icon and on top of [theme_item Tree.icon_max_width]. The height is
   * adjusted according to the icon's ratio.
   */
  public final fun setIconMaxWidth(column: Int, width: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setIconMaxWidthPtr, column.toLong(), width.toLong())
  }

  /**
   * Returns the maximum allowed width of the icon in the given [column].
   */
  public final fun getIconMaxWidth(column: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getIconMaxWidthPtr, column.toLong()).toInt()

  /**
   * Modulates the given column's icon with [modulate].
   */
  public final fun setIconModulate(column: Int, modulate: Color): Unit {
    TransferContext.callPtrMethod_LONG_COLOR(ptr, objectID.id, MethodBindings.setIconModulatePtr, column.toLong(), modulate)
  }

  /**
   * Returns the [Color] modulating the column's icon.
   */
  public final fun getIconModulate(column: Int): Color =
      TransferContext.callPtrMethod_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getIconModulatePtr, column.toLong())

  /**
   * Sets the value of a [CELL_MODE_RANGE] column.
   */
  public final fun setRange(column: Int, `value`: Double): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setRangePtr, column.toLong(), value)
  }

  /**
   * Returns the value of a [CELL_MODE_RANGE] column.
   */
  public final fun getRange(column: Int): Double =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRangePtr, column.toLong())

  /**
   * Sets the range of accepted values for a column. The column must be in the [CELL_MODE_RANGE]
   * mode.
   *
   * If [expr] is `true`, the edit mode slider will use an exponential scale as with
   * [Range.expEdit].
   */
  @JvmOverloads
  public final fun setRangeConfig(
    column: Int,
    min: Double,
    max: Double,
    step: Double,
    expr: Boolean = false,
  ): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE_DOUBLE_DOUBLE_BOOL(ptr, objectID.id, MethodBindings.setRangeConfigPtr, column.toLong(), min, max, step, expr)
  }

  /**
   * Returns a dictionary containing the range parameters for a given column. The keys are "min",
   * "max", "step", and "expr".
   */
  public final fun getRangeConfig(column: Int): Dictionary<Any?, Any?> =
      (TransferContext.callPtrMethod_LONG_ret_DICTIONARY(ptr, objectID.id, MethodBindings.getRangeConfigPtr, column.toLong()) as Dictionary<Any?, Any?>)

  /**
   * Sets the metadata value for the given column, which can be retrieved later using [getMetadata].
   * This can be used, for example, to store a reference to the original data.
   */
  public final fun setMetadata(column: Int, meta: Any?): Unit {
    TransferContext.callMethod_LONG_ANY(ptr, objectID.id, MethodBindings.setMetadataPtr, column.toLong(), meta)
  }

  /**
   * Returns the metadata value that was set for the given column using [setMetadata].
   */
  public final fun getMetadata(column: Int): Any? =
      TransferContext.callMethod_LONG_ret_ANY(ptr, objectID.id, MethodBindings.getMetadataPtr, column.toLong())

  /**
   * Sets the given column's custom draw callback to the [callback] method on [object].
   *
   * The method named [callback] should accept two arguments: the [TreeItem] that is drawn and its
   * position and size as a [Rect2].
   */
  public final fun setCustomDraw(
    column: Int,
    `object`: Object?,
    callback: StringName,
  ): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT_STRING_NAME(ptr, objectID.id, MethodBindings.setCustomDrawPtr, column.toLong(), `object`, callback)
  }

  /**
   * Sets the given column's custom draw callback. Use an empty [Callable] ([code
   * skip-lint]Callable()[/code]) to clear the custom callback. The cell has to be in
   * [CELL_MODE_CUSTOM] to use this feature.
   *
   * The [callback] should accept two arguments: the [TreeItem] that is drawn and its position and
   * size as a [Rect2].
   *
   * To draw custom content over the native style, please use [Tree.getCustomDrawingCanvasItem].
   */
  public final fun setCustomDrawCallback(column: Int, callback: Callable): Unit {
    TransferContext.callMethod_LONG_CALLABLE(ptr, objectID.id, MethodBindings.setCustomDrawCallbackPtr, column.toLong(), callback)
  }

  /**
   * Returns the custom callback of column [column].
   */
  public final fun getCustomDrawCallback(column: Int): Callable =
      TransferContext.callMethod_LONG_ret_CALLABLE(ptr, objectID.id, MethodBindings.getCustomDrawCallbackPtr, column.toLong())

  /**
   * Sets the given column's custom [StyleBox] used to draw the background.
   *
   * **Note:** If a custom background color is set, the [StyleBox] will be drawn in front of it.
   */
  public final fun setCustomStylebox(column: Int, stylebox: StyleBox?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setCustomStyleboxPtr, column.toLong(), stylebox)
  }

  /**
   * Returns the given column's custom [StyleBox] used to draw the background.
   */
  public final fun getCustomStylebox(column: Int): StyleBox? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getCustomStyleboxPtr, column.toLong()) as StyleBox?)

  public final fun setCollapsed(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setCollapsedPtr, enable)
  }

  public final fun isCollapsed(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isCollapsedPtr)

  /**
   * Collapses or uncollapses this [TreeItem] and all the descendants of this item.
   */
  public final fun setCollapsedRecursive(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setCollapsedRecursivePtr, enable)
  }

  /**
   * Returns `true` if this [TreeItem], or any of its descendants, is collapsed.
   *
   * If [onlyVisible] is `true` it ignores non-visible [TreeItem]s.
   */
  @JvmOverloads
  public final fun isAnyCollapsed(onlyVisible: Boolean = false): Boolean =
      TransferContext.callPtrMethod_BOOL_ret_BOOL(ptr, objectID.id, MethodBindings.isAnyCollapsedPtr, onlyVisible)

  public final fun setVisible(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setVisiblePtr, enable)
  }

  public final fun isVisible(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isVisiblePtr)

  /**
   * Returns `true` if [visible] is `true` and all its ancestors are also visible.
   */
  public final fun isVisibleInTree(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isVisibleInTreePtr)

  /**
   * Uncollapses all [TreeItem]s necessary to reveal this [TreeItem], i.e. all ancestor [TreeItem]s.
   */
  public final fun uncollapseTree(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.uncollapseTreePtr)
  }

  public final fun setCustomMinimumHeight(height: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCustomMinimumHeightPtr, height.toLong())
  }

  public final fun getCustomMinimumHeight(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCustomMinimumHeightPtr).toInt()

  /**
   * If [selectable] is `true`, the given [column] is selectable.
   */
  public final fun setSelectable(column: Int, selectable: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setSelectablePtr, column.toLong(), selectable)
  }

  /**
   * Returns `true` if the given [column] is selectable.
   */
  public final fun isSelectable(column: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isSelectablePtr, column.toLong())

  /**
   * Returns `true` if the given [column] is selected.
   */
  public final fun isSelected(column: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isSelectedPtr, column.toLong())

  /**
   * Selects the given [column]. If [setAsCursor] is `true`, the [Tree]'s cursor will be moved to
   * this item (only matters if [Tree.selectMode] is set to [Tree.SELECT_MULTI]).
   */
  @JvmOverloads
  public final fun select(column: Int, setAsCursor: Boolean = true): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.selectPtr, column.toLong(), setAsCursor)
  }

  /**
   * Deselects the given column.
   */
  public final fun deselect(column: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.deselectPtr, column.toLong())
  }

  /**
   * If [enabled] is `true`, the given [column] is editable.
   */
  public final fun setEditable(column: Int, enabled: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setEditablePtr, column.toLong(), enabled)
  }

  /**
   * Returns `true` if the given [column] is editable.
   */
  public final fun isEditable(column: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isEditablePtr, column.toLong())

  /**
   * Sets the given column's custom color.
   */
  public final fun setCustomColor(column: Int, color: Color): Unit {
    TransferContext.callPtrMethod_LONG_COLOR(ptr, objectID.id, MethodBindings.setCustomColorPtr, column.toLong(), color)
  }

  /**
   * Returns the custom color of column [column].
   */
  public final fun getCustomColor(column: Int): Color =
      TransferContext.callPtrMethod_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getCustomColorPtr, column.toLong())

  /**
   * Resets the color for the given column to default.
   */
  public final fun clearCustomColor(column: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.clearCustomColorPtr, column.toLong())
  }

  /**
   * Sets custom font used to draw text in the given [column].
   */
  public final fun setCustomFont(column: Int, font: Font?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setCustomFontPtr, column.toLong(), font)
  }

  /**
   * Returns custom font used to draw text in the column [column].
   */
  public final fun getCustomFont(column: Int): Font? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getCustomFontPtr, column.toLong()) as Font?)

  /**
   * Sets custom font size used to draw text in the given [column].
   */
  public final fun setCustomFontSize(column: Int, fontSize: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setCustomFontSizePtr, column.toLong(), fontSize.toLong())
  }

  /**
   * Returns custom font size used to draw text in the column [column].
   */
  public final fun getCustomFontSize(column: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getCustomFontSizePtr, column.toLong()).toInt()

  /**
   * Sets the given column's custom background color and whether to just use it as an outline.
   *
   * **Note:** If a custom [StyleBox] is set, the background color will be drawn behind it.
   */
  @JvmOverloads
  public final fun setCustomBgColor(
    column: Int,
    color: Color,
    justOutline: Boolean = false,
  ): Unit {
    TransferContext.callPtrMethod_LONG_COLOR_BOOL(ptr, objectID.id, MethodBindings.setCustomBgColorPtr, column.toLong(), color, justOutline)
  }

  /**
   * Resets the background color for the given column to default.
   */
  public final fun clearCustomBgColor(column: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.clearCustomBgColorPtr, column.toLong())
  }

  /**
   * Returns the custom background color of column [column].
   */
  public final fun getCustomBgColor(column: Int): Color =
      TransferContext.callPtrMethod_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getCustomBgColorPtr, column.toLong())

  /**
   * Makes a cell with [CELL_MODE_CUSTOM] display as a non-flat button with a [StyleBox].
   */
  public final fun setCustomAsButton(column: Int, enable: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setCustomAsButtonPtr, column.toLong(), enable)
  }

  /**
   * Returns `true` if the cell was made into a button with [setCustomAsButton].
   */
  public final fun isCustomSetAsButton(column: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isCustomSetAsButtonPtr, column.toLong())

  /**
   * Removes all buttons from all columns of this item.
   */
  public final fun clearButtons(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearButtonsPtr)
  }

  /**
   * Adds a button with [Texture2D] [button] to the end of the cell at column [column]. The [id] is
   * used to identify the button in the according [signal Tree.button_clicked] signal and can be
   * different from the buttons index. If not specified, the next available index is used, which may be
   * retrieved by calling [getButtonCount] immediately before this method. Optionally, the button can
   * be [disabled] and have a [tooltipText]. [description] is used as the button description for
   * assistive apps.
   */
  @JvmOverloads
  public final fun addButton(
    column: Int,
    button: Texture2D?,
    id: Int = -1,
    disabled: Boolean = false,
    tooltipText: String = "",
    description: String = "",
  ): Unit {
    TransferContext.callMethod_LONG_OBJECT_LONG_BOOL_STRING_STRING(ptr, objectID.id, MethodBindings.addButtonPtr, column.toLong(), button, id.toLong(), disabled, tooltipText, description)
  }

  /**
   * Returns the number of buttons in column [column].
   */
  public final fun getButtonCount(column: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getButtonCountPtr, column.toLong()).toInt()

  /**
   * Returns the tooltip text for the button at index [buttonIndex] in column [column].
   */
  public final fun getButtonTooltipText(column: Int, buttonIndex: Int): String =
      TransferContext.callMethod_LONG_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getButtonTooltipTextPtr, column.toLong(), buttonIndex.toLong())

  /**
   * Returns the ID for the button at index [buttonIndex] in column [column].
   */
  public final fun getButtonId(column: Int, buttonIndex: Int): Int =
      TransferContext.callPtrMethod_LONG_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getButtonIdPtr, column.toLong(), buttonIndex.toLong()).toInt()

  /**
   * Returns the button index if there is a button with ID [id] in column [column], otherwise
   * returns -1.
   */
  public final fun getButtonById(column: Int, id: Int): Int =
      TransferContext.callPtrMethod_LONG_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getButtonByIdPtr, column.toLong(), id.toLong()).toInt()

  /**
   * Returns the color of the button with ID [id] in column [column]. If the specified button does
   * not exist, returns [Color.BLACK].
   */
  public final fun getButtonColor(column: Int, id: Int): Color =
      TransferContext.callPtrMethod_LONG_LONG_ret_COLOR(ptr, objectID.id, MethodBindings.getButtonColorPtr, column.toLong(), id.toLong())

  /**
   * Returns the [Texture2D] of the button at index [buttonIndex] in column [column].
   */
  public final fun getButton(column: Int, buttonIndex: Int): Texture2D? =
      (TransferContext.callPtrMethod_LONG_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getButtonPtr, column.toLong(), buttonIndex.toLong()) as Texture2D?)

  /**
   * Sets the tooltip text for the button at index [buttonIndex] in the given [column].
   */
  public final fun setButtonTooltipText(
    column: Int,
    buttonIndex: Int,
    tooltip: String,
  ): Unit {
    TransferContext.callMethod_LONG_LONG_STRING(ptr, objectID.id, MethodBindings.setButtonTooltipTextPtr, column.toLong(), buttonIndex.toLong(), tooltip)
  }

  /**
   * Sets the given column's button [Texture2D] at index [buttonIndex] to [button].
   */
  public final fun setButton(
    column: Int,
    buttonIndex: Int,
    button: Texture2D?,
  ): Unit {
    TransferContext.callPtrMethod_LONG_LONG_OBJECT(ptr, objectID.id, MethodBindings.setButtonPtr, column.toLong(), buttonIndex.toLong(), button)
  }

  /**
   * Removes the button at index [buttonIndex] in column [column].
   */
  public final fun eraseButton(column: Int, buttonIndex: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.eraseButtonPtr, column.toLong(), buttonIndex.toLong())
  }

  /**
   * Sets the given column's button description at index [buttonIndex] for assistive apps.
   */
  public final fun setButtonDescription(
    column: Int,
    buttonIndex: Int,
    description: String,
  ): Unit {
    TransferContext.callMethod_LONG_LONG_STRING(ptr, objectID.id, MethodBindings.setButtonDescriptionPtr, column.toLong(), buttonIndex.toLong(), description)
  }

  /**
   * If `true`, disables the button at index [buttonIndex] in the given [column].
   */
  public final fun setButtonDisabled(
    column: Int,
    buttonIndex: Int,
    disabled: Boolean,
  ): Unit {
    TransferContext.callPtrMethod_LONG_LONG_BOOL(ptr, objectID.id, MethodBindings.setButtonDisabledPtr, column.toLong(), buttonIndex.toLong(), disabled)
  }

  /**
   * Sets the given column's button color at index [buttonIndex] to [color].
   */
  public final fun setButtonColor(
    column: Int,
    buttonIndex: Int,
    color: Color,
  ): Unit {
    TransferContext.callPtrMethod_LONG_LONG_COLOR(ptr, objectID.id, MethodBindings.setButtonColorPtr, column.toLong(), buttonIndex.toLong(), color)
  }

  /**
   * Returns `true` if the button at index [buttonIndex] for the given [column] is disabled.
   */
  public final fun isButtonDisabled(column: Int, buttonIndex: Int): Boolean =
      TransferContext.callPtrMethod_LONG_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isButtonDisabledPtr, column.toLong(), buttonIndex.toLong())

  /**
   * Sets the given column's tooltip text.
   */
  public final fun setTooltipText(column: Int, tooltip: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setTooltipTextPtr, column.toLong(), tooltip)
  }

  /**
   * Returns the given column's tooltip text.
   */
  public final fun getTooltipText(column: Int): String =
      TransferContext.callMethod_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getTooltipTextPtr, column.toLong())

  /**
   * Sets the given column's text alignment to [textAlignment].
   */
  public final fun setTextAlignment(column: Int, textAlignment: HorizontalAlignment): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setTextAlignmentPtr, column.toLong(), textAlignment.value)
  }

  /**
   * Returns the given column's text alignment.
   */
  public final fun getTextAlignment(column: Int): HorizontalAlignment =
      HorizontalAlignment.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getTextAlignmentPtr, column.toLong()))

  /**
   * If [enable] is `true`, the given [column] is expanded to the right.
   */
  public final fun setExpandRight(column: Int, enable: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setExpandRightPtr, column.toLong(), enable)
  }

  /**
   * Returns `true` if `expand_right` is set.
   */
  public final fun getExpandRight(column: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.getExpandRightPtr, column.toLong())

  public final fun setDisableFolding(disable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setDisableFoldingPtr, disable)
  }

  public final fun isFoldingDisabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isFoldingDisabledPtr)

  /**
   * Sets [TreeItem]'s ability to accept children.
   */
  public final fun setAcceptChildren(allowed: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAcceptChildrenPtr, allowed)
  }

  /**
   * Returns `true` if this [TreeItem] is allowed to accept children.
   */
  public final fun isAcceptingChildren(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isAcceptingChildrenPtr)

  /**
   * Creates an item and adds it as a child.
   *
   * The new item will be inserted as position [index] (the default value `-1` means the last
   * position), or it will be the last child if [index] is higher than the child count.
   */
  @JvmOverloads
  public final fun createChild(index: Int = -1): TreeItem? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT(ptr, objectID.id, MethodBindings.createChildPtr, index.toLong()) as TreeItem?)

  /**
   * Adds a previously unparented [TreeItem] as a direct child of this one. The [child] item must
   * not be a part of any [Tree] or parented to any [TreeItem]. See also [removeChild].
   */
  public final fun addChild(child: TreeItem?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.addChildPtr, child)
  }

  /**
   * Removes the given child [TreeItem] and all its children from the [Tree]. Note that it doesn't
   * free the item from memory, so it can be reused later (see [addChild]). To completely remove a
   * [TreeItem] use [Object.free].
   *
   * **Note:** If you want to move a child from one [Tree] to another, then instead of removing and
   * adding it manually you can use [moveBefore] or [moveAfter].
   */
  public final fun removeChild(child: TreeItem?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.removeChildPtr, child)
  }

  /**
   * Returns the [Tree] that owns this TreeItem.
   */
  public final fun getTree(): Tree? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getTreePtr) as Tree?)

  /**
   * Returns the next sibling TreeItem in the tree or a `null` object if there is none.
   */
  public final fun getNext(): TreeItem? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getNextPtr) as TreeItem?)

  /**
   * Returns the previous sibling TreeItem in the tree or a `null` object if there is none.
   */
  public final fun getPrev(): TreeItem? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getPrevPtr) as TreeItem?)

  /**
   * Returns the parent TreeItem or a `null` object if there is none.
   */
  public final fun getParent(): TreeItem? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getParentPtr) as TreeItem?)

  /**
   * Returns the TreeItem's first child.
   */
  public final fun getFirstChild(): TreeItem? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getFirstChildPtr) as TreeItem?)

  /**
   * Returns the next TreeItem in the tree (in the context of a depth-first search) or a `null`
   * object if there is none.
   *
   * If [wrap] is enabled, the method will wrap around to the first element in the tree when called
   * on the last element, otherwise it returns `null`.
   */
  @JvmOverloads
  public final fun getNextInTree(wrap: Boolean = false): TreeItem? =
      (TransferContext.callPtrMethod_BOOL_ret_OBJECT(ptr, objectID.id, MethodBindings.getNextInTreePtr, wrap) as TreeItem?)

  /**
   * Returns the previous TreeItem in the tree (in the context of a depth-first search) or a `null`
   * object if there is none.
   *
   * If [wrap] is enabled, the method will wrap around to the last element in the tree when called
   * on the first visible element, otherwise it returns `null`.
   */
  @JvmOverloads
  public final fun getPrevInTree(wrap: Boolean = false): TreeItem? =
      (TransferContext.callPtrMethod_BOOL_ret_OBJECT(ptr, objectID.id, MethodBindings.getPrevInTreePtr, wrap) as TreeItem?)

  /**
   * Returns the next visible TreeItem in the tree (in the context of a depth-first search) or a
   * `null` object if there is none.
   *
   * If [wrap] is enabled, the method will wrap around to the first visible element in the tree when
   * called on the last visible element, otherwise it returns `null`.
   */
  @JvmOverloads
  public final fun getNextVisible(wrap: Boolean = false): TreeItem? =
      (TransferContext.callPtrMethod_BOOL_ret_OBJECT(ptr, objectID.id, MethodBindings.getNextVisiblePtr, wrap) as TreeItem?)

  /**
   * Returns the previous visible sibling TreeItem in the tree (in the context of a depth-first
   * search) or a `null` object if there is none.
   *
   * If [wrap] is enabled, the method will wrap around to the last visible element in the tree when
   * called on the first visible element, otherwise it returns `null`.
   */
  @JvmOverloads
  public final fun getPrevVisible(wrap: Boolean = false): TreeItem? =
      (TransferContext.callPtrMethod_BOOL_ret_OBJECT(ptr, objectID.id, MethodBindings.getPrevVisiblePtr, wrap) as TreeItem?)

  /**
   * Returns a child item by its [index] (see [getChildCount]). This method is often used for
   * iterating all children of an item.
   *
   * Negative indices access the children from the last one.
   */
  public final fun getChild(index: Int): TreeItem? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT(ptr, objectID.id, MethodBindings.getChildPtr, index.toLong()) as TreeItem?)

  /**
   * Returns the number of child items.
   */
  public final fun getChildCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getChildCountPtr).toInt()

  /**
   * Returns an array of references to the item's children.
   */
  public final fun getChildren(): VariantArray<TreeItem> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getChildrenPtr) as VariantArray<TreeItem>)

  /**
   * Returns the node's order in the tree. For example, if called on the first child item the
   * position is `0`.
   */
  public final fun getIndex(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getIndexPtr).toInt()

  /**
   * Moves this TreeItem right before the given [item].
   *
   * **Note:** You can't move to the root or move the root.
   */
  public final fun moveBefore(item: TreeItem?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.moveBeforePtr, item)
  }

  /**
   * Moves this TreeItem right after the given [item].
   *
   * **Note:** You can't move to the root or move the root.
   */
  public final fun moveAfter(item: TreeItem?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.moveAfterPtr, item)
  }

  /**
   * Calls the [method] on the actual TreeItem and its children recursively. Pass parameters as a
   * comma separated list.
   */
  public final fun callRecursive(method: StringName, vararg args: Any?): Unit {
    TransferContext.callMethod_STRING_NAME_VARARG(ptr, objectID.id, MethodBindings.callRecursivePtr, method, args)
  }

  /**
   * Sets the given column's custom draw callback to the [callback] method on [object].
   *
   * The method named [callback] should accept two arguments: the [TreeItem] that is drawn and its
   * position and size as a [Rect2].
   */
  public final fun setCustomDraw(
    column: Int,
    `object`: Object?,
    callback: String,
  ) = setCustomDraw(column, `object`, callback.asCachedStringName())

  /**
   * Calls the [method] on the actual TreeItem and its children recursively. Pass parameters as a
   * comma separated list.
   */
  public final fun callRecursive(method: String, vararg args: Any?) =
      callRecursive(method.asCachedStringName(), *args)

  public enum class TreeCellMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Cell shows a string label, optionally with an icon. When editable, the text can be edited
     * using a [LineEdit], or a [TextEdit] popup if [setEditMultiline] is used.
     */
    CELL_MODE_STRING(0),
    /**
     * Cell shows a checkbox, optionally with text and an icon. The checkbox can be pressed,
     * released, or indeterminate (via [setIndeterminate]). The checkbox can't be clicked unless the
     * cell is editable.
     */
    CELL_MODE_CHECK(1),
    /**
     * Cell shows a numeric range. When editable, it can be edited using a range slider. Use
     * [setRange] to set the value and [setRangeConfig] to configure the range.
     *
     * This cell can also be used in a text dropdown mode when you assign a text with [setText].
     * Separate options with a comma, e.g. `"Option1,Option2,Option3"`.
     */
    CELL_MODE_RANGE(2),
    /**
     * Cell shows an icon. It can't be edited nor display text. The icon is always centered within
     * the cell.
     */
    CELL_MODE_ICON(3),
    /**
     * Cell shows as a clickable button. It will display an arrow similar to [OptionButton], but
     * doesn't feature a dropdown (for that you can use [CELL_MODE_RANGE]). Clicking the button emits
     * the [signal Tree.item_edited] signal. The button is flat by default, you can use
     * [setCustomAsButton] to display it with a [StyleBox].
     *
     * This mode also supports custom drawing using [setCustomDrawCallback].
     */
    CELL_MODE_CUSTOM(4),
    ;

    public companion object {
      public fun from(`value`: Long): TreeCellMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setCellModeName: MethodStringName2<TreeItem, Unit, Int, TreeCellMode> =
        MethodStringName2<TreeItem, Unit, Int, TreeCellMode>("set_cell_mode")

    @JvmField
    public val getCellModeName: MethodStringName1<TreeItem, TreeCellMode, Int> =
        MethodStringName1<TreeItem, TreeCellMode, Int>("get_cell_mode")

    @JvmField
    public val setAutoTranslateModeName:
        MethodStringName2<TreeItem, Unit, Int, Node.AutoTranslateMode> =
        MethodStringName2<TreeItem, Unit, Int, Node.AutoTranslateMode>("set_auto_translate_mode")

    @JvmField
    public val getAutoTranslateModeName: MethodStringName1<TreeItem, Node.AutoTranslateMode, Int> =
        MethodStringName1<TreeItem, Node.AutoTranslateMode, Int>("get_auto_translate_mode")

    @JvmField
    public val setEditMultilineName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("set_edit_multiline")

    @JvmField
    public val isEditMultilineName: MethodStringName1<TreeItem, Boolean, Int> =
        MethodStringName1<TreeItem, Boolean, Int>("is_edit_multiline")

    @JvmField
    public val setCheckedName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("set_checked")

    @JvmField
    public val setIndeterminateName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("set_indeterminate")

    @JvmField
    public val isCheckedName: MethodStringName1<TreeItem, Boolean, Int> =
        MethodStringName1<TreeItem, Boolean, Int>("is_checked")

    @JvmField
    public val isIndeterminateName: MethodStringName1<TreeItem, Boolean, Int> =
        MethodStringName1<TreeItem, Boolean, Int>("is_indeterminate")

    @JvmField
    public val propagateCheckName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("propagate_check")

    @JvmField
    public val setTextName: MethodStringName2<TreeItem, Unit, Int, String> =
        MethodStringName2<TreeItem, Unit, Int, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName1<TreeItem, String, Int> =
        MethodStringName1<TreeItem, String, Int>("get_text")

    @JvmField
    public val setDescriptionName: MethodStringName2<TreeItem, Unit, Int, String> =
        MethodStringName2<TreeItem, Unit, Int, String>("set_description")

    @JvmField
    public val getDescriptionName: MethodStringName1<TreeItem, String, Int> =
        MethodStringName1<TreeItem, String, Int>("get_description")

    @JvmField
    public val setTextDirectionName: MethodStringName2<TreeItem, Unit, Int, Control.TextDirection> =
        MethodStringName2<TreeItem, Unit, Int, Control.TextDirection>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName1<TreeItem, Control.TextDirection, Int> =
        MethodStringName1<TreeItem, Control.TextDirection, Int>("get_text_direction")

    @JvmField
    public val setAutowrapModeName: MethodStringName2<TreeItem, Unit, Int, TextServer.AutowrapMode>
        = MethodStringName2<TreeItem, Unit, Int, TextServer.AutowrapMode>("set_autowrap_mode")

    @JvmField
    public val getAutowrapModeName: MethodStringName1<TreeItem, TextServer.AutowrapMode, Int> =
        MethodStringName1<TreeItem, TextServer.AutowrapMode, Int>("get_autowrap_mode")

    @JvmField
    public val setAutowrapTrimFlagsName:
        MethodStringName2<TreeItem, Unit, Int, TextServer.LineBreakFlag> =
        MethodStringName2<TreeItem, Unit, Int, TextServer.LineBreakFlag>("set_autowrap_trim_flags")

    @JvmField
    public val getAutowrapTrimFlagsName: MethodStringName1<TreeItem, TextServer.LineBreakFlag, Int>
        = MethodStringName1<TreeItem, TextServer.LineBreakFlag, Int>("get_autowrap_trim_flags")

    @JvmField
    public val setTextOverrunBehaviorName:
        MethodStringName2<TreeItem, Unit, Int, TextServer.OverrunBehavior> =
        MethodStringName2<TreeItem, Unit, Int, TextServer.OverrunBehavior>("set_text_overrun_behavior")

    @JvmField
    public val getTextOverrunBehaviorName:
        MethodStringName1<TreeItem, TextServer.OverrunBehavior, Int> =
        MethodStringName1<TreeItem, TextServer.OverrunBehavior, Int>("get_text_overrun_behavior")

    @JvmField
    public val setStructuredTextBidiOverrideName:
        MethodStringName2<TreeItem, Unit, Int, TextServer.StructuredTextParser> =
        MethodStringName2<TreeItem, Unit, Int, TextServer.StructuredTextParser>("set_structured_text_bidi_override")

    @JvmField
    public val getStructuredTextBidiOverrideName:
        MethodStringName1<TreeItem, TextServer.StructuredTextParser, Int> =
        MethodStringName1<TreeItem, TextServer.StructuredTextParser, Int>("get_structured_text_bidi_override")

    @JvmField
    public val setStructuredTextBidiOverrideOptionsName:
        MethodStringName2<TreeItem, Unit, Int, VariantArray<Any?>> =
        MethodStringName2<TreeItem, Unit, Int, VariantArray<Any?>>("set_structured_text_bidi_override_options")

    @JvmField
    public val getStructuredTextBidiOverrideOptionsName:
        MethodStringName1<TreeItem, VariantArray<Any?>, Int> =
        MethodStringName1<TreeItem, VariantArray<Any?>, Int>("get_structured_text_bidi_override_options")

    @JvmField
    public val setLanguageName: MethodStringName2<TreeItem, Unit, Int, String> =
        MethodStringName2<TreeItem, Unit, Int, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName1<TreeItem, String, Int> =
        MethodStringName1<TreeItem, String, Int>("get_language")

    @JvmField
    public val setSuffixName: MethodStringName2<TreeItem, Unit, Int, String> =
        MethodStringName2<TreeItem, Unit, Int, String>("set_suffix")

    @JvmField
    public val getSuffixName: MethodStringName1<TreeItem, String, Int> =
        MethodStringName1<TreeItem, String, Int>("get_suffix")

    @JvmField
    public val setIconName: MethodStringName2<TreeItem, Unit, Int, Texture2D?> =
        MethodStringName2<TreeItem, Unit, Int, Texture2D?>("set_icon")

    @JvmField
    public val getIconName: MethodStringName1<TreeItem, Texture2D?, Int> =
        MethodStringName1<TreeItem, Texture2D?, Int>("get_icon")

    @JvmField
    public val setIconOverlayName: MethodStringName2<TreeItem, Unit, Int, Texture2D?> =
        MethodStringName2<TreeItem, Unit, Int, Texture2D?>("set_icon_overlay")

    @JvmField
    public val getIconOverlayName: MethodStringName1<TreeItem, Texture2D?, Int> =
        MethodStringName1<TreeItem, Texture2D?, Int>("get_icon_overlay")

    @JvmField
    public val setIconRegionName: MethodStringName2<TreeItem, Unit, Int, Rect2> =
        MethodStringName2<TreeItem, Unit, Int, Rect2>("set_icon_region")

    @JvmField
    public val getIconRegionName: MethodStringName1<TreeItem, Rect2, Int> =
        MethodStringName1<TreeItem, Rect2, Int>("get_icon_region")

    @JvmField
    public val setIconMaxWidthName: MethodStringName2<TreeItem, Unit, Int, Int> =
        MethodStringName2<TreeItem, Unit, Int, Int>("set_icon_max_width")

    @JvmField
    public val getIconMaxWidthName: MethodStringName1<TreeItem, Int, Int> =
        MethodStringName1<TreeItem, Int, Int>("get_icon_max_width")

    @JvmField
    public val setIconModulateName: MethodStringName2<TreeItem, Unit, Int, Color> =
        MethodStringName2<TreeItem, Unit, Int, Color>("set_icon_modulate")

    @JvmField
    public val getIconModulateName: MethodStringName1<TreeItem, Color, Int> =
        MethodStringName1<TreeItem, Color, Int>("get_icon_modulate")

    @JvmField
    public val setRangeName: MethodStringName2<TreeItem, Unit, Int, Double> =
        MethodStringName2<TreeItem, Unit, Int, Double>("set_range")

    @JvmField
    public val getRangeName: MethodStringName1<TreeItem, Double, Int> =
        MethodStringName1<TreeItem, Double, Int>("get_range")

    @JvmField
    public val setRangeConfigName:
        MethodStringName5<TreeItem, Unit, Int, Double, Double, Double, Boolean> =
        MethodStringName5<TreeItem, Unit, Int, Double, Double, Double, Boolean>("set_range_config")

    @JvmField
    public val getRangeConfigName: MethodStringName1<TreeItem, Dictionary<Any?, Any?>, Int> =
        MethodStringName1<TreeItem, Dictionary<Any?, Any?>, Int>("get_range_config")

    @JvmField
    public val setMetadataName: MethodStringName2<TreeItem, Unit, Int, Any?> =
        MethodStringName2<TreeItem, Unit, Int, Any?>("set_metadata")

    @JvmField
    public val getMetadataName: MethodStringName1<TreeItem, Any?, Int> =
        MethodStringName1<TreeItem, Any?, Int>("get_metadata")

    @JvmField
    public val setCustomDrawName: MethodStringName3<TreeItem, Unit, Int, Object?, StringName> =
        MethodStringName3<TreeItem, Unit, Int, Object?, StringName>("set_custom_draw")

    @JvmField
    public val setCustomDrawCallbackName: MethodStringName2<TreeItem, Unit, Int, Callable> =
        MethodStringName2<TreeItem, Unit, Int, Callable>("set_custom_draw_callback")

    @JvmField
    public val getCustomDrawCallbackName: MethodStringName1<TreeItem, Callable, Int> =
        MethodStringName1<TreeItem, Callable, Int>("get_custom_draw_callback")

    @JvmField
    public val setCustomStyleboxName: MethodStringName2<TreeItem, Unit, Int, StyleBox?> =
        MethodStringName2<TreeItem, Unit, Int, StyleBox?>("set_custom_stylebox")

    @JvmField
    public val getCustomStyleboxName: MethodStringName1<TreeItem, StyleBox?, Int> =
        MethodStringName1<TreeItem, StyleBox?, Int>("get_custom_stylebox")

    @JvmField
    public val setCollapsedName: MethodStringName1<TreeItem, Unit, Boolean> =
        MethodStringName1<TreeItem, Unit, Boolean>("set_collapsed")

    @JvmField
    public val isCollapsedName: MethodStringName0<TreeItem, Boolean> =
        MethodStringName0<TreeItem, Boolean>("is_collapsed")

    @JvmField
    public val setCollapsedRecursiveName: MethodStringName1<TreeItem, Unit, Boolean> =
        MethodStringName1<TreeItem, Unit, Boolean>("set_collapsed_recursive")

    @JvmField
    public val isAnyCollapsedName: MethodStringName1<TreeItem, Boolean, Boolean> =
        MethodStringName1<TreeItem, Boolean, Boolean>("is_any_collapsed")

    @JvmField
    public val setVisibleName: MethodStringName1<TreeItem, Unit, Boolean> =
        MethodStringName1<TreeItem, Unit, Boolean>("set_visible")

    @JvmField
    public val isVisibleName: MethodStringName0<TreeItem, Boolean> =
        MethodStringName0<TreeItem, Boolean>("is_visible")

    @JvmField
    public val isVisibleInTreeName: MethodStringName0<TreeItem, Boolean> =
        MethodStringName0<TreeItem, Boolean>("is_visible_in_tree")

    @JvmField
    public val uncollapseTreeName: MethodStringName0<TreeItem, Unit> =
        MethodStringName0<TreeItem, Unit>("uncollapse_tree")

    @JvmField
    public val setCustomMinimumHeightName: MethodStringName1<TreeItem, Unit, Int> =
        MethodStringName1<TreeItem, Unit, Int>("set_custom_minimum_height")

    @JvmField
    public val getCustomMinimumHeightName: MethodStringName0<TreeItem, Int> =
        MethodStringName0<TreeItem, Int>("get_custom_minimum_height")

    @JvmField
    public val setSelectableName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("set_selectable")

    @JvmField
    public val isSelectableName: MethodStringName1<TreeItem, Boolean, Int> =
        MethodStringName1<TreeItem, Boolean, Int>("is_selectable")

    @JvmField
    public val isSelectedName: MethodStringName1<TreeItem, Boolean, Int> =
        MethodStringName1<TreeItem, Boolean, Int>("is_selected")

    @JvmField
    public val selectName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("select")

    @JvmField
    public val deselectName: MethodStringName1<TreeItem, Unit, Int> =
        MethodStringName1<TreeItem, Unit, Int>("deselect")

    @JvmField
    public val setEditableName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("set_editable")

    @JvmField
    public val isEditableName: MethodStringName1<TreeItem, Boolean, Int> =
        MethodStringName1<TreeItem, Boolean, Int>("is_editable")

    @JvmField
    public val setCustomColorName: MethodStringName2<TreeItem, Unit, Int, Color> =
        MethodStringName2<TreeItem, Unit, Int, Color>("set_custom_color")

    @JvmField
    public val getCustomColorName: MethodStringName1<TreeItem, Color, Int> =
        MethodStringName1<TreeItem, Color, Int>("get_custom_color")

    @JvmField
    public val clearCustomColorName: MethodStringName1<TreeItem, Unit, Int> =
        MethodStringName1<TreeItem, Unit, Int>("clear_custom_color")

    @JvmField
    public val setCustomFontName: MethodStringName2<TreeItem, Unit, Int, Font?> =
        MethodStringName2<TreeItem, Unit, Int, Font?>("set_custom_font")

    @JvmField
    public val getCustomFontName: MethodStringName1<TreeItem, Font?, Int> =
        MethodStringName1<TreeItem, Font?, Int>("get_custom_font")

    @JvmField
    public val setCustomFontSizeName: MethodStringName2<TreeItem, Unit, Int, Int> =
        MethodStringName2<TreeItem, Unit, Int, Int>("set_custom_font_size")

    @JvmField
    public val getCustomFontSizeName: MethodStringName1<TreeItem, Int, Int> =
        MethodStringName1<TreeItem, Int, Int>("get_custom_font_size")

    @JvmField
    public val setCustomBgColorName: MethodStringName3<TreeItem, Unit, Int, Color, Boolean> =
        MethodStringName3<TreeItem, Unit, Int, Color, Boolean>("set_custom_bg_color")

    @JvmField
    public val clearCustomBgColorName: MethodStringName1<TreeItem, Unit, Int> =
        MethodStringName1<TreeItem, Unit, Int>("clear_custom_bg_color")

    @JvmField
    public val getCustomBgColorName: MethodStringName1<TreeItem, Color, Int> =
        MethodStringName1<TreeItem, Color, Int>("get_custom_bg_color")

    @JvmField
    public val setCustomAsButtonName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("set_custom_as_button")

    @JvmField
    public val isCustomSetAsButtonName: MethodStringName1<TreeItem, Boolean, Int> =
        MethodStringName1<TreeItem, Boolean, Int>("is_custom_set_as_button")

    @JvmField
    public val clearButtonsName: MethodStringName0<TreeItem, Unit> =
        MethodStringName0<TreeItem, Unit>("clear_buttons")

    @JvmField
    public val addButtonName:
        MethodStringName6<TreeItem, Unit, Int, Texture2D?, Int, Boolean, String, String> =
        MethodStringName6<TreeItem, Unit, Int, Texture2D?, Int, Boolean, String, String>("add_button")

    @JvmField
    public val getButtonCountName: MethodStringName1<TreeItem, Int, Int> =
        MethodStringName1<TreeItem, Int, Int>("get_button_count")

    @JvmField
    public val getButtonTooltipTextName: MethodStringName2<TreeItem, String, Int, Int> =
        MethodStringName2<TreeItem, String, Int, Int>("get_button_tooltip_text")

    @JvmField
    public val getButtonIdName: MethodStringName2<TreeItem, Int, Int, Int> =
        MethodStringName2<TreeItem, Int, Int, Int>("get_button_id")

    @JvmField
    public val getButtonByIdName: MethodStringName2<TreeItem, Int, Int, Int> =
        MethodStringName2<TreeItem, Int, Int, Int>("get_button_by_id")

    @JvmField
    public val getButtonColorName: MethodStringName2<TreeItem, Color, Int, Int> =
        MethodStringName2<TreeItem, Color, Int, Int>("get_button_color")

    @JvmField
    public val getButtonName: MethodStringName2<TreeItem, Texture2D?, Int, Int> =
        MethodStringName2<TreeItem, Texture2D?, Int, Int>("get_button")

    @JvmField
    public val setButtonTooltipTextName: MethodStringName3<TreeItem, Unit, Int, Int, String> =
        MethodStringName3<TreeItem, Unit, Int, Int, String>("set_button_tooltip_text")

    @JvmField
    public val setButtonName: MethodStringName3<TreeItem, Unit, Int, Int, Texture2D?> =
        MethodStringName3<TreeItem, Unit, Int, Int, Texture2D?>("set_button")

    @JvmField
    public val eraseButtonName: MethodStringName2<TreeItem, Unit, Int, Int> =
        MethodStringName2<TreeItem, Unit, Int, Int>("erase_button")

    @JvmField
    public val setButtonDescriptionName: MethodStringName3<TreeItem, Unit, Int, Int, String> =
        MethodStringName3<TreeItem, Unit, Int, Int, String>("set_button_description")

    @JvmField
    public val setButtonDisabledName: MethodStringName3<TreeItem, Unit, Int, Int, Boolean> =
        MethodStringName3<TreeItem, Unit, Int, Int, Boolean>("set_button_disabled")

    @JvmField
    public val setButtonColorName: MethodStringName3<TreeItem, Unit, Int, Int, Color> =
        MethodStringName3<TreeItem, Unit, Int, Int, Color>("set_button_color")

    @JvmField
    public val isButtonDisabledName: MethodStringName2<TreeItem, Boolean, Int, Int> =
        MethodStringName2<TreeItem, Boolean, Int, Int>("is_button_disabled")

    @JvmField
    public val setTooltipTextName: MethodStringName2<TreeItem, Unit, Int, String> =
        MethodStringName2<TreeItem, Unit, Int, String>("set_tooltip_text")

    @JvmField
    public val getTooltipTextName: MethodStringName1<TreeItem, String, Int> =
        MethodStringName1<TreeItem, String, Int>("get_tooltip_text")

    @JvmField
    public val setTextAlignmentName: MethodStringName2<TreeItem, Unit, Int, HorizontalAlignment> =
        MethodStringName2<TreeItem, Unit, Int, HorizontalAlignment>("set_text_alignment")

    @JvmField
    public val getTextAlignmentName: MethodStringName1<TreeItem, HorizontalAlignment, Int> =
        MethodStringName1<TreeItem, HorizontalAlignment, Int>("get_text_alignment")

    @JvmField
    public val setExpandRightName: MethodStringName2<TreeItem, Unit, Int, Boolean> =
        MethodStringName2<TreeItem, Unit, Int, Boolean>("set_expand_right")

    @JvmField
    public val getExpandRightName: MethodStringName1<TreeItem, Boolean, Int> =
        MethodStringName1<TreeItem, Boolean, Int>("get_expand_right")

    @JvmField
    public val setDisableFoldingName: MethodStringName1<TreeItem, Unit, Boolean> =
        MethodStringName1<TreeItem, Unit, Boolean>("set_disable_folding")

    @JvmField
    public val isFoldingDisabledName: MethodStringName0<TreeItem, Boolean> =
        MethodStringName0<TreeItem, Boolean>("is_folding_disabled")

    @JvmField
    public val setAcceptChildrenName: MethodStringName1<TreeItem, Unit, Boolean> =
        MethodStringName1<TreeItem, Unit, Boolean>("set_accept_children")

    @JvmField
    public val isAcceptingChildrenName: MethodStringName0<TreeItem, Boolean> =
        MethodStringName0<TreeItem, Boolean>("is_accepting_children")

    @JvmField
    public val createChildName: MethodStringName1<TreeItem, TreeItem?, Int> =
        MethodStringName1<TreeItem, TreeItem?, Int>("create_child")

    @JvmField
    public val addChildName: MethodStringName1<TreeItem, Unit, TreeItem?> =
        MethodStringName1<TreeItem, Unit, TreeItem?>("add_child")

    @JvmField
    public val removeChildName: MethodStringName1<TreeItem, Unit, TreeItem?> =
        MethodStringName1<TreeItem, Unit, TreeItem?>("remove_child")

    @JvmField
    public val getTreeName: MethodStringName0<TreeItem, Tree?> =
        MethodStringName0<TreeItem, Tree?>("get_tree")

    @JvmField
    public val getNextName: MethodStringName0<TreeItem, TreeItem?> =
        MethodStringName0<TreeItem, TreeItem?>("get_next")

    @JvmField
    public val getPrevName: MethodStringName0<TreeItem, TreeItem?> =
        MethodStringName0<TreeItem, TreeItem?>("get_prev")

    @JvmField
    public val getParentName: MethodStringName0<TreeItem, TreeItem?> =
        MethodStringName0<TreeItem, TreeItem?>("get_parent")

    @JvmField
    public val getFirstChildName: MethodStringName0<TreeItem, TreeItem?> =
        MethodStringName0<TreeItem, TreeItem?>("get_first_child")

    @JvmField
    public val getNextInTreeName: MethodStringName1<TreeItem, TreeItem?, Boolean> =
        MethodStringName1<TreeItem, TreeItem?, Boolean>("get_next_in_tree")

    @JvmField
    public val getPrevInTreeName: MethodStringName1<TreeItem, TreeItem?, Boolean> =
        MethodStringName1<TreeItem, TreeItem?, Boolean>("get_prev_in_tree")

    @JvmField
    public val getNextVisibleName: MethodStringName1<TreeItem, TreeItem?, Boolean> =
        MethodStringName1<TreeItem, TreeItem?, Boolean>("get_next_visible")

    @JvmField
    public val getPrevVisibleName: MethodStringName1<TreeItem, TreeItem?, Boolean> =
        MethodStringName1<TreeItem, TreeItem?, Boolean>("get_prev_visible")

    @JvmField
    public val getChildName: MethodStringName1<TreeItem, TreeItem?, Int> =
        MethodStringName1<TreeItem, TreeItem?, Int>("get_child")

    @JvmField
    public val getChildCountName: MethodStringName0<TreeItem, Int> =
        MethodStringName0<TreeItem, Int>("get_child_count")

    @JvmField
    public val getChildrenName: MethodStringName0<TreeItem, VariantArray<TreeItem>> =
        MethodStringName0<TreeItem, VariantArray<TreeItem>>("get_children")

    @JvmField
    public val getIndexName: MethodStringName0<TreeItem, Int> =
        MethodStringName0<TreeItem, Int>("get_index")

    @JvmField
    public val moveBeforeName: MethodStringName1<TreeItem, Unit, TreeItem?> =
        MethodStringName1<TreeItem, Unit, TreeItem?>("move_before")

    @JvmField
    public val moveAfterName: MethodStringName1<TreeItem, Unit, TreeItem?> =
        MethodStringName1<TreeItem, Unit, TreeItem?>("move_after")
  }

  public object MethodBindings {
    internal val setCellModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_cell_mode", 289920701)

    internal val getCellModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_cell_mode", 3406114978)

    internal val setAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_auto_translate_mode", 287402019)

    internal val getAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_auto_translate_mode", 906302372)

    internal val setEditMultilinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_edit_multiline", 300928843)

    internal val isEditMultilinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_edit_multiline", 1116898809)

    internal val setCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_checked", 300928843)

    internal val setIndeterminatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_indeterminate", 300928843)

    internal val isCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_checked", 1116898809)

    internal val isIndeterminatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_indeterminate", 1116898809)

    internal val propagateCheckPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "propagate_check", 972357352)

    internal val setTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_text", 501894301)

    internal val getTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_text", 844755477)

    internal val setDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_description", 501894301)

    internal val getDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_description", 844755477)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_text_direction", 1707680378)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_text_direction", 4235602388)

    internal val setAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_autowrap_mode", 3633006561)

    internal val getAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_autowrap_mode", 2902757236)

    internal val setAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_autowrap_trim_flags", 2186029660)

    internal val getAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_autowrap_trim_flags", 3513056523)

    internal val setTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_text_overrun_behavior", 1940772195)

    internal val getTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_text_overrun_behavior", 3782727860)

    internal val setStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_structured_text_bidi_override", 868756907)

    internal val getStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_structured_text_bidi_override", 3377823772)

    internal val setStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_structured_text_bidi_override_options", 537221740)

    internal val getStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_structured_text_bidi_override_options", 663333327)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_language", 501894301)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_language", 844755477)

    internal val setSuffixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_suffix", 501894301)

    internal val getSuffixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_suffix", 844755477)

    internal val setIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_icon", 666127730)

    internal val getIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_icon", 3536238170)

    internal val setIconOverlayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_icon_overlay", 666127730)

    internal val getIconOverlayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_icon_overlay", 3536238170)

    internal val setIconRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_icon_region", 1356297692)

    internal val getIconRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_icon_region", 3327874267)

    internal val setIconMaxWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_icon_max_width", 3937882851)

    internal val getIconMaxWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_icon_max_width", 923996154)

    internal val setIconModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_icon_modulate", 2878471219)

    internal val getIconModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_icon_modulate", 3457211756)

    internal val setRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_range", 1602489585)

    internal val getRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_range", 2339986948)

    internal val setRangeConfigPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_range_config", 1547181014)

    internal val getRangeConfigPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_range_config", 3554694381)

    internal val setMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_metadata", 2152698145)

    internal val getMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_metadata", 4227898402)

    internal val setCustomDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_draw", 272420368)

    internal val setCustomDrawCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_draw_callback", 957362965)

    internal val getCustomDrawCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_custom_draw_callback", 1317077508)

    internal val setCustomStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_stylebox", 1433009359)

    internal val getCustomStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_custom_stylebox", 3362509644)

    internal val setCollapsedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_collapsed", 2586408642)

    internal val isCollapsedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_collapsed", 2240911060)

    internal val setCollapsedRecursivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_collapsed_recursive", 2586408642)

    internal val isAnyCollapsedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_any_collapsed", 2595650253)

    internal val setVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_visible", 2586408642)

    internal val isVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_visible", 2240911060)

    internal val isVisibleInTreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_visible_in_tree", 36873697)

    internal val uncollapseTreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "uncollapse_tree", 3218959716)

    internal val setCustomMinimumHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_minimum_height", 1286410249)

    internal val getCustomMinimumHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_custom_minimum_height", 3905245786)

    internal val setSelectablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_selectable", 300928843)

    internal val isSelectablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_selectable", 1116898809)

    internal val isSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_selected", 3067735520)

    internal val selectPtr: VoidPtr = TypeManager.getMethodBindPtr("TreeItem", "select", 972357352)

    internal val deselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "deselect", 1286410249)

    internal val setEditablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_editable", 300928843)

    internal val isEditablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_editable", 3067735520)

    internal val setCustomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_color", 2878471219)

    internal val getCustomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_custom_color", 3457211756)

    internal val clearCustomColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "clear_custom_color", 1286410249)

    internal val setCustomFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_font", 2637609184)

    internal val getCustomFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_custom_font", 4244553094)

    internal val setCustomFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_font_size", 3937882851)

    internal val getCustomFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_custom_font_size", 923996154)

    internal val setCustomBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_bg_color", 894174518)

    internal val clearCustomBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "clear_custom_bg_color", 1286410249)

    internal val getCustomBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_custom_bg_color", 3457211756)

    internal val setCustomAsButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_custom_as_button", 300928843)

    internal val isCustomSetAsButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_custom_set_as_button", 1116898809)

    internal val clearButtonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "clear_buttons", 3218959716)

    internal val addButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "add_button", 973481897)

    internal val getButtonCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_button_count", 923996154)

    internal val getButtonTooltipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_button_tooltip_text", 1391810591)

    internal val getButtonIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_button_id", 3175239445)

    internal val getButtonByIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_button_by_id", 3175239445)

    internal val getButtonColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_button_color", 2165839948)

    internal val getButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_button", 2584904275)

    internal val setButtonTooltipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_button_tooltip_text", 2285447957)

    internal val setButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_button", 176101966)

    internal val eraseButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "erase_button", 3937882851)

    internal val setButtonDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_button_description", 2285447957)

    internal val setButtonDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_button_disabled", 1383440665)

    internal val setButtonColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_button_color", 3733378741)

    internal val isButtonDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_button_disabled", 2522259332)

    internal val setTooltipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_tooltip_text", 501894301)

    internal val getTooltipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_tooltip_text", 844755477)

    internal val setTextAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_text_alignment", 3276431499)

    internal val getTextAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_text_alignment", 4171562184)

    internal val setExpandRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_expand_right", 300928843)

    internal val getExpandRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_expand_right", 1116898809)

    internal val setDisableFoldingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_disable_folding", 2586408642)

    internal val isFoldingDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_folding_disabled", 36873697)

    internal val setAcceptChildrenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "set_accept_children", 2586408642)

    internal val isAcceptingChildrenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "is_accepting_children", 36873697)

    internal val createChildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "create_child", 954243986)

    internal val addChildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "add_child", 1819951137)

    internal val removeChildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "remove_child", 1819951137)

    internal val getTreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_tree", 2243340556)

    internal val getNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_next", 1514277247)

    internal val getPrevPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_prev", 2768121250)

    internal val getParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_parent", 1514277247)

    internal val getFirstChildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_first_child", 1514277247)

    internal val getNextInTreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_next_in_tree", 1666920593)

    internal val getPrevInTreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_prev_in_tree", 1666920593)

    internal val getNextVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_next_visible", 1666920593)

    internal val getPrevVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_prev_visible", 1666920593)

    internal val getChildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_child", 306700752)

    internal val getChildCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_child_count", 2455072627)

    internal val getChildrenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_children", 2915620761)

    internal val getIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "get_index", 2455072627)

    internal val moveBeforePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "move_before", 1819951137)

    internal val moveAfterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "move_after", 1819951137)

    internal val callRecursivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TreeItem", "call_recursive", 2866548813)
  }
}
