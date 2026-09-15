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
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal1
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A container that can be expanded/collapsed, with a title that can be filled with controls, such
 * as buttons. This is also called an accordion.
 *
 * The title can be positioned at the top or bottom of the container. The container can be expanded
 * or collapsed by clicking the title or by pressing `ui_accept` when focused. Child control nodes are
 * hidden when the container is collapsed. Ignores non-control children.
 *
 * A FoldableContainer can be grouped with other FoldableContainers so that only one of them can be
 * opened at a time; see [foldableGroup] and [FoldableGroup].
 */
@GodotBaseType
public open class FoldableContainer : Container() {
  /**
   * Emitted when the container is folded/expanded.
   */
  public val foldingChanged: Signal1<Boolean> by Signal1

  /**
   * If `true`, the container will become folded and will hide all its children.
   */
  public final inline var folded: Boolean
    @JvmName("foldedProperty")
    get() = isFolded()
    @JvmName("foldedProperty")
    set(`value`) {
      setFolded(value)
    }

  /**
   * The container's title text.
   */
  public final inline var title: String
    @JvmName("titleProperty")
    get() = getTitle()
    @JvmName("titleProperty")
    set(`value`) {
      setTitle(value)
    }

  /**
   * Title's horizontal text alignment.
   */
  public final inline var titleAlignment: HorizontalAlignment
    @JvmName("titleAlignmentProperty")
    get() = getTitleAlignment()
    @JvmName("titleAlignmentProperty")
    set(`value`) {
      setTitleAlignment(value)
    }

  /**
   * Title's position.
   */
  public final inline var titlePosition: TitlePosition
    @JvmName("titlePositionProperty")
    get() = getTitlePosition()
    @JvmName("titlePositionProperty")
    set(`value`) {
      setTitlePosition(value)
    }

  /**
   * Defines the behavior of the title when the text is longer than the available space.
   */
  public final inline var titleTextOverrunBehavior: TextServer.OverrunBehavior
    @JvmName("titleTextOverrunBehaviorProperty")
    get() = getTitleTextOverrunBehavior()
    @JvmName("titleTextOverrunBehaviorProperty")
    set(`value`) {
      setTitleTextOverrunBehavior(value)
    }

  /**
   * The [FoldableGroup] associated with the container. When multiple [FoldableContainer] nodes
   * share the same group, only one of them is allowed to be unfolded.
   */
  public final inline var foldableGroup: FoldableGroup?
    @JvmName("foldableGroupProperty")
    get() = getFoldableGroup()
    @JvmName("foldableGroupProperty")
    set(`value`) {
      setFoldableGroup(value)
    }

  /**
   * Title text writing direction.
   */
  public final inline var titleTextDirection: Control.TextDirection
    @JvmName("titleTextDirectionProperty")
    get() = getTitleTextDirection()
    @JvmName("titleTextDirectionProperty")
    set(`value`) {
      setTitleTextDirection(value)
    }

  /**
   * Language code used for text shaping algorithms. If left empty, the current locale is used
   * instead.
   */
  public final inline var language: String
    @JvmName("languageProperty")
    get() = getLanguage()
    @JvmName("languageProperty")
    set(`value`) {
      setLanguage(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(229, scriptPtr)
  }

  /**
   * Folds the container and emits [signal folding_changed].
   */
  public final fun fold(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.foldPtr)
  }

  /**
   * Expands the container and emits [signal folding_changed].
   */
  public final fun expand(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.expandPtr)
  }

  public final fun setFolded(folded: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, folded)
    TransferContext.callMethod(MethodBindings.setFoldedPtr)
  }

  public final fun isFolded(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFoldedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setFoldableGroup(buttonGroup: FoldableGroup?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, buttonGroup)
    TransferContext.callMethod(MethodBindings.setFoldableGroupPtr)
  }

  public final fun getFoldableGroup(): FoldableGroup? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFoldableGroupPtr)
    return (TransferContext.readReturnValue_OBJECT() as FoldableGroup?)
  }

  public final fun setTitle(text: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, text)
    TransferContext.callMethod(MethodBindings.setTitlePtr)
  }

  public final fun getTitle(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTitlePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setTitleAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignment.value)
    TransferContext.callMethod(MethodBindings.setTitleAlignmentPtr)
  }

  public final fun getTitleAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTitleAlignmentPtr)
    return HorizontalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setLanguage(language: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, language)
    TransferContext.callMethod(MethodBindings.setLanguagePtr)
  }

  public final fun getLanguage(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguagePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setTitleTextDirection(textDirection: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, textDirection.value)
    TransferContext.callMethod(MethodBindings.setTitleTextDirectionPtr)
  }

  public final fun getTitleTextDirection(): Control.TextDirection {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTitleTextDirectionPtr)
    return Control.TextDirection.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTitleTextOverrunBehavior(overrunBehavior: TextServer.OverrunBehavior): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, overrunBehavior.value)
    TransferContext.callMethod(MethodBindings.setTitleTextOverrunBehaviorPtr)
  }

  public final fun getTitleTextOverrunBehavior(): TextServer.OverrunBehavior {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTitleTextOverrunBehaviorPtr)
    return TextServer.OverrunBehavior.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTitlePosition(titlePosition: TitlePosition): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, titlePosition.value)
    TransferContext.callMethod(MethodBindings.setTitlePositionPtr)
  }

  public final fun getTitlePosition(): TitlePosition {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTitlePositionPtr)
    return TitlePosition.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Adds a [Control] that will be placed next to the container's title, obscuring the clickable
   * area. Prime usage is adding [Button] nodes, but it can be any [Control].
   *
   * The control will be added as a child of this container and removed from previous parent if
   * necessary. The controls will be placed aligned to the right, with the first added control being
   * the leftmost one.
   */
  public final fun addTitleBarControl(control: Control?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, control)
    TransferContext.callMethod(MethodBindings.addTitleBarControlPtr)
  }

  /**
   * Removes a [Control] added with [addTitleBarControl]. The node is not freed automatically, you
   * need to use [Node.queueFree].
   */
  public final fun removeTitleBarControl(control: Control?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, control)
    TransferContext.callMethod(MethodBindings.removeTitleBarControlPtr)
  }

  public enum class TitlePosition(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Makes the title appear at the top of the container.
     */
    POSITION_TOP(0),
    /**
     * Makes the title appear at the bottom of the container. Also makes all StyleBoxes flipped
     * vertically.
     */
    POSITION_BOTTOM(1),
    ;

    public companion object {
      public fun from(`value`: Long): TitlePosition = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val foldName: MethodStringName0<FoldableContainer, Unit> =
        MethodStringName0<FoldableContainer, Unit>("fold")

    @JvmField
    public val expandName: MethodStringName0<FoldableContainer, Unit> =
        MethodStringName0<FoldableContainer, Unit>("expand")

    @JvmField
    public val setFoldedName: MethodStringName1<FoldableContainer, Unit, Boolean> =
        MethodStringName1<FoldableContainer, Unit, Boolean>("set_folded")

    @JvmField
    public val isFoldedName: MethodStringName0<FoldableContainer, Boolean> =
        MethodStringName0<FoldableContainer, Boolean>("is_folded")

    @JvmField
    public val setFoldableGroupName: MethodStringName1<FoldableContainer, Unit, FoldableGroup?> =
        MethodStringName1<FoldableContainer, Unit, FoldableGroup?>("set_foldable_group")

    @JvmField
    public val getFoldableGroupName: MethodStringName0<FoldableContainer, FoldableGroup?> =
        MethodStringName0<FoldableContainer, FoldableGroup?>("get_foldable_group")

    @JvmField
    public val setTitleName: MethodStringName1<FoldableContainer, Unit, String> =
        MethodStringName1<FoldableContainer, Unit, String>("set_title")

    @JvmField
    public val getTitleName: MethodStringName0<FoldableContainer, String> =
        MethodStringName0<FoldableContainer, String>("get_title")

    @JvmField
    public val setTitleAlignmentName:
        MethodStringName1<FoldableContainer, Unit, HorizontalAlignment> =
        MethodStringName1<FoldableContainer, Unit, HorizontalAlignment>("set_title_alignment")

    @JvmField
    public val getTitleAlignmentName: MethodStringName0<FoldableContainer, HorizontalAlignment> =
        MethodStringName0<FoldableContainer, HorizontalAlignment>("get_title_alignment")

    @JvmField
    public val setLanguageName: MethodStringName1<FoldableContainer, Unit, String> =
        MethodStringName1<FoldableContainer, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<FoldableContainer, String> =
        MethodStringName0<FoldableContainer, String>("get_language")

    @JvmField
    public val setTitleTextDirectionName:
        MethodStringName1<FoldableContainer, Unit, Control.TextDirection> =
        MethodStringName1<FoldableContainer, Unit, Control.TextDirection>("set_title_text_direction")

    @JvmField
    public val getTitleTextDirectionName:
        MethodStringName0<FoldableContainer, Control.TextDirection> =
        MethodStringName0<FoldableContainer, Control.TextDirection>("get_title_text_direction")

    @JvmField
    public val setTitleTextOverrunBehaviorName:
        MethodStringName1<FoldableContainer, Unit, TextServer.OverrunBehavior> =
        MethodStringName1<FoldableContainer, Unit, TextServer.OverrunBehavior>("set_title_text_overrun_behavior")

    @JvmField
    public val getTitleTextOverrunBehaviorName:
        MethodStringName0<FoldableContainer, TextServer.OverrunBehavior> =
        MethodStringName0<FoldableContainer, TextServer.OverrunBehavior>("get_title_text_overrun_behavior")

    @JvmField
    public val setTitlePositionName: MethodStringName1<FoldableContainer, Unit, TitlePosition> =
        MethodStringName1<FoldableContainer, Unit, TitlePosition>("set_title_position")

    @JvmField
    public val getTitlePositionName: MethodStringName0<FoldableContainer, TitlePosition> =
        MethodStringName0<FoldableContainer, TitlePosition>("get_title_position")

    @JvmField
    public val addTitleBarControlName: MethodStringName1<FoldableContainer, Unit, Control?> =
        MethodStringName1<FoldableContainer, Unit, Control?>("add_title_bar_control")

    @JvmField
    public val removeTitleBarControlName: MethodStringName1<FoldableContainer, Unit, Control?> =
        MethodStringName1<FoldableContainer, Unit, Control?>("remove_title_bar_control")
  }

  public object MethodBindings {
    internal val foldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "fold", 3218959716)

    internal val expandPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "expand", 3218959716)

    internal val setFoldedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "set_folded", 2586408642)

    internal val isFoldedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "is_folded", 36873697)

    internal val setFoldableGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "set_foldable_group", 3001390597)

    internal val getFoldableGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "get_foldable_group", 66499518)

    internal val setTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "set_title", 83702148)

    internal val getTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "get_title", 201670096)

    internal val setTitleAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "set_title_alignment", 2312603777)

    internal val getTitleAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "get_title_alignment", 341400642)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "get_language", 201670096)

    internal val setTitleTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "set_title_text_direction", 119160795)

    internal val getTitleTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "get_title_text_direction", 797257663)

    internal val setTitleTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "set_title_text_overrun_behavior", 1008890932)

    internal val getTitleTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "get_title_text_overrun_behavior", 3779142101)

    internal val setTitlePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "set_title_position", 2276829442)

    internal val getTitlePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "get_title_position", 3028840207)

    internal val addTitleBarControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "add_title_bar_control", 1496901182)

    internal val removeTitleBarControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FoldableContainer", "remove_title_bar_control", 1496901182)
  }
}
