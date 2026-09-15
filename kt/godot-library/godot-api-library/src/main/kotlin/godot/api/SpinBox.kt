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
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [SpinBox] is a numerical input text field. It allows entering integers and floating-point
 * numbers. The [SpinBox] also has up and down buttons that can be clicked to increase or decrease the
 * value. The value can also be changed by dragging the mouse up or down over the [SpinBox]'s arrows.
 *
 * Additionally, mathematical expressions can be entered. These are evaluated when the user presses
 * [kbd]Enter[/kbd] while editing the [SpinBox]'s text field. This uses the [Expression] class to parse
 * and evaluate the expression. The result of the expression is then set as the value of the [SpinBox].
 * Some examples of valid expressions are `5 + 2 * 3`, `pow(2, 4)`, and `PI + sin(0.5)`. Expressions
 * are case-sensitive.
 *
 * **Example:** Create a [SpinBox], disable its context menu and set its text alignment to right.
 *
 * ```gdscript
 * //gdscript
 * var spin_box = SpinBox.new()
 * add_child(spin_box)
 * var line_edit = spin_box.get_line_edit()
 * line_edit.context_menu_enabled = false
 * spin_box.horizontal_alignment = LineEdit.HORIZONTAL_ALIGNMENT_RIGHT
 * ```
 *
 * ```csharp
 * //csharp
 * var spinBox = new SpinBox();
 * AddChild(spinBox);
 * var lineEdit = spinBox.GetLineEdit();
 * lineEdit.ContextMenuEnabled = false;
 * spinBox.AlignHorizontal = LineEdit.HorizontalAlignEnum.Right;
 * ```
 *
 * See [Range] class for more options over the [SpinBox].
 *
 * **Note:** With the [SpinBox]'s context menu disabled, you can right-click the bottom half of the
 * spinbox to set the value to its minimum, while right-clicking the top half sets the value to its
 * maximum.
 *
 * **Note:** [SpinBox] relies on an underlying [LineEdit] node. To theme a [SpinBox]'s background,
 * add theme items for [LineEdit] and customize them. The [LineEdit] has the `SpinBoxInnerLineEdit`
 * theme variation, so that you can give it a distinct appearance from regular [LineEdit]s.
 *
 * **Note:** If you want to implement drag and drop for the underlying [LineEdit], you can use
 * [Control.setDragForwarding] on the node returned by [getLineEdit].
 */
@GodotBaseType
public open class SpinBox : Range() {
  /**
   * Changes the alignment of the underlying [LineEdit].
   */
  public final inline var alignment: HorizontalAlignment
    @JvmName("alignmentProperty")
    get() = getHorizontalAlignment()
    @JvmName("alignmentProperty")
    set(`value`) {
      setHorizontalAlignment(value)
    }

  /**
   * If `true`, the [SpinBox] will be editable. Otherwise, it will be read only.
   */
  public final inline var editable: Boolean
    @JvmName("editableProperty")
    get() = isEditable()
    @JvmName("editableProperty")
    set(`value`) {
      setEditable(value)
    }

  /**
   * Sets the value of the [Range] for this [SpinBox] when the [LineEdit] text is *changed* instead
   * of *submitted*. See [signal LineEdit.text_changed] and [signal LineEdit.text_submitted].
   *
   * **Note:** If set to `true`, this will interfere with entering mathematical expressions in the
   * [SpinBox]. The [SpinBox] will try to evaluate the expression as you type, which means symbols like
   * a trailing `+` are removed immediately by the expression being evaluated.
   */
  public final inline var updateOnTextChanged: Boolean
    @JvmName("updateOnTextChangedProperty")
    get() = getUpdateOnTextChanged()
    @JvmName("updateOnTextChangedProperty")
    set(`value`) {
      setUpdateOnTextChanged(value)
    }

  /**
   * Adds the specified prefix string before the numerical value of the [SpinBox].
   */
  public final inline var prefix: String
    @JvmName("prefixProperty")
    get() = getPrefix()
    @JvmName("prefixProperty")
    set(`value`) {
      setPrefix(value)
    }

  /**
   * Adds the specified suffix string after the numerical value of the [SpinBox].
   */
  public final inline var suffix: String
    @JvmName("suffixProperty")
    get() = getSuffix()
    @JvmName("suffixProperty")
    set(`value`) {
      setSuffix(value)
    }

  /**
   * If not `0`, sets the step when interacting with the arrow buttons of the [SpinBox].
   *
   * **Note:** [Range.value] will still be rounded to a multiple of [Range.step].
   */
  public final inline var customArrowStep: Double
    @JvmName("customArrowStepProperty")
    get() = getCustomArrowStep()
    @JvmName("customArrowStepProperty")
    set(`value`) {
      setCustomArrowStep(value)
    }

  /**
   * If `true`, the value will be rounded to a multiple of [customArrowStep] when interacting with
   * the arrow buttons. Otherwise, increments the value by [customArrowStep] and then rounds it
   * according to [Range.step].
   */
  public final inline var customArrowRound: Boolean
    @JvmName("customArrowRoundProperty")
    get() = isCustomArrowRounding()
    @JvmName("customArrowRoundProperty")
    set(`value`) {
      setCustomArrowRound(value)
    }

  /**
   * If `true`, the [SpinBox] will select the whole text when the [LineEdit] gains focus. Clicking
   * the up and down arrows won't trigger this behavior.
   */
  public final inline var selectAllOnFocus: Boolean
    @JvmName("selectAllOnFocusProperty")
    get() = isSelectAllOnFocus()
    @JvmName("selectAllOnFocusProperty")
    set(`value`) {
      setSelectAllOnFocus(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(689, scriptPtr)
  }

  public final fun setHorizontalAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignment.value)
    TransferContext.callMethod(MethodBindings.setHorizontalAlignmentPtr)
  }

  public final fun getHorizontalAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHorizontalAlignmentPtr)
    return HorizontalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSuffix(suffix: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, suffix)
    TransferContext.callMethod(MethodBindings.setSuffixPtr)
  }

  public final fun getSuffix(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSuffixPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setPrefix(prefix: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, prefix)
    TransferContext.callMethod(MethodBindings.setPrefixPtr)
  }

  public final fun getPrefix(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPrefixPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setEditable(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setEditablePtr)
  }

  public final fun setCustomArrowStep(arrowStep: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, arrowStep)
    TransferContext.callMethod(MethodBindings.setCustomArrowStepPtr)
  }

  public final fun getCustomArrowStep(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomArrowStepPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setCustomArrowRound(round: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, round)
    TransferContext.callMethod(MethodBindings.setCustomArrowRoundPtr)
  }

  public final fun isCustomArrowRounding(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCustomArrowRoundingPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun isEditable(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEditablePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setUpdateOnTextChanged(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setUpdateOnTextChangedPtr)
  }

  public final fun getUpdateOnTextChanged(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUpdateOnTextChangedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSelectAllOnFocus(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setSelectAllOnFocusPtr)
  }

  public final fun isSelectAllOnFocus(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSelectAllOnFocusPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Applies the current value of this [SpinBox]. This is equivalent to pressing [kbd]Enter[/kbd]
   * while editing the [LineEdit] used by the [SpinBox]. This will cause [signal
   * LineEdit.text_submitted] to be emitted and its currently contained expression to be evaluated.
   */
  public final fun apply(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.applyPtr)
  }

  /**
   * Returns the [LineEdit] instance from this [SpinBox]. You can use it to access properties and
   * methods of [LineEdit].
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getLineEdit(): LineEdit? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineEditPtr)
    return (TransferContext.readReturnValue_OBJECT() as LineEdit?)
  }

  public companion object {
    @JvmField
    public val setHorizontalAlignmentName: MethodStringName1<SpinBox, Unit, HorizontalAlignment> =
        MethodStringName1<SpinBox, Unit, HorizontalAlignment>("set_horizontal_alignment")

    @JvmField
    public val getHorizontalAlignmentName: MethodStringName0<SpinBox, HorizontalAlignment> =
        MethodStringName0<SpinBox, HorizontalAlignment>("get_horizontal_alignment")

    @JvmField
    public val setSuffixName: MethodStringName1<SpinBox, Unit, String> =
        MethodStringName1<SpinBox, Unit, String>("set_suffix")

    @JvmField
    public val getSuffixName: MethodStringName0<SpinBox, String> =
        MethodStringName0<SpinBox, String>("get_suffix")

    @JvmField
    public val setPrefixName: MethodStringName1<SpinBox, Unit, String> =
        MethodStringName1<SpinBox, Unit, String>("set_prefix")

    @JvmField
    public val getPrefixName: MethodStringName0<SpinBox, String> =
        MethodStringName0<SpinBox, String>("get_prefix")

    @JvmField
    public val setEditableName: MethodStringName1<SpinBox, Unit, Boolean> =
        MethodStringName1<SpinBox, Unit, Boolean>("set_editable")

    @JvmField
    public val setCustomArrowStepName: MethodStringName1<SpinBox, Unit, Double> =
        MethodStringName1<SpinBox, Unit, Double>("set_custom_arrow_step")

    @JvmField
    public val getCustomArrowStepName: MethodStringName0<SpinBox, Double> =
        MethodStringName0<SpinBox, Double>("get_custom_arrow_step")

    @JvmField
    public val setCustomArrowRoundName: MethodStringName1<SpinBox, Unit, Boolean> =
        MethodStringName1<SpinBox, Unit, Boolean>("set_custom_arrow_round")

    @JvmField
    public val isCustomArrowRoundingName: MethodStringName0<SpinBox, Boolean> =
        MethodStringName0<SpinBox, Boolean>("is_custom_arrow_rounding")

    @JvmField
    public val isEditableName: MethodStringName0<SpinBox, Boolean> =
        MethodStringName0<SpinBox, Boolean>("is_editable")

    @JvmField
    public val setUpdateOnTextChangedName: MethodStringName1<SpinBox, Unit, Boolean> =
        MethodStringName1<SpinBox, Unit, Boolean>("set_update_on_text_changed")

    @JvmField
    public val getUpdateOnTextChangedName: MethodStringName0<SpinBox, Boolean> =
        MethodStringName0<SpinBox, Boolean>("get_update_on_text_changed")

    @JvmField
    public val setSelectAllOnFocusName: MethodStringName1<SpinBox, Unit, Boolean> =
        MethodStringName1<SpinBox, Unit, Boolean>("set_select_all_on_focus")

    @JvmField
    public val isSelectAllOnFocusName: MethodStringName0<SpinBox, Boolean> =
        MethodStringName0<SpinBox, Boolean>("is_select_all_on_focus")

    @JvmField
    public val applyName: MethodStringName0<SpinBox, Unit> =
        MethodStringName0<SpinBox, Unit>("apply")

    @JvmField
    public val getLineEditName: MethodStringName0<SpinBox, LineEdit?> =
        MethodStringName0<SpinBox, LineEdit?>("get_line_edit")
  }

  public object MethodBindings {
    internal val setHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "set_horizontal_alignment", 2312603777)

    internal val getHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "get_horizontal_alignment", 341400642)

    internal val setSuffixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "set_suffix", 83702148)

    internal val getSuffixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "get_suffix", 201670096)

    internal val setPrefixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "set_prefix", 83702148)

    internal val getPrefixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "get_prefix", 201670096)

    internal val setEditablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "set_editable", 2586408642)

    internal val setCustomArrowStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "set_custom_arrow_step", 373806689)

    internal val getCustomArrowStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "get_custom_arrow_step", 1740695150)

    internal val setCustomArrowRoundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "set_custom_arrow_round", 2586408642)

    internal val isCustomArrowRoundingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "is_custom_arrow_rounding", 36873697)

    internal val isEditablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "is_editable", 36873697)

    internal val setUpdateOnTextChangedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "set_update_on_text_changed", 2586408642)

    internal val getUpdateOnTextChangedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "get_update_on_text_changed", 36873697)

    internal val setSelectAllOnFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "set_select_all_on_focus", 2586408642)

    internal val isSelectAllOnFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "is_select_all_on_focus", 36873697)

    internal val applyPtr: VoidPtr = TypeManager.getMethodBindPtr("SpinBox", "apply", 3218959716)

    internal val getLineEditPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpinBox", "get_line_edit", 4071694264)
  }
}
