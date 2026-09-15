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
import godot.core.Signal0
import godot.core.Signal1
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Double
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Range is an abstract base class for controls that represent a number within a range, using a
 * configured [step] and [page] size. See e.g. [ScrollBar] and [Slider] for examples of higher-level
 * nodes using Range.
 */
@GodotBaseType
public open class Range : Control() {
  /**
   * Emitted when [value] changes. When used on a [Slider], this is called continuously while
   * dragging (potentially every frame). If you are performing an expensive operation in a function
   * connected to [signal value_changed], consider using a *debouncing* [Timer] to call the function
   * less often.
   *
   * **Note:** Unlike signals such as [signal LineEdit.text_changed], [signal value_changed] is also
   * emitted when [value] is set directly via code.
   */
  public val valueChanged: Signal1<Double> by Signal1

  /**
   * Emitted when [minValue], [maxValue], [page], or [step] change.
   */
  public val changed: Signal0 by Signal0

  /**
   * Minimum value. Range is clamped if [value] is less than [minValue].
   */
  public final inline var minValue: Double
    @JvmName("minValueProperty")
    get() = getMin()
    @JvmName("minValueProperty")
    set(`value`) {
      setMin(value)
    }

  /**
   * Maximum value. Range is clamped if [value] is greater than [maxValue].
   */
  public final inline var maxValue: Double
    @JvmName("maxValueProperty")
    get() = getMax()
    @JvmName("maxValueProperty")
    set(`value`) {
      setMax(value)
    }

  /**
   * If greater than `0.0`, [value] will always be rounded to a multiple of this property's value
   * above [minValue]. For example, if [minValue] is `0.1` and step is `0.2`, then [value] is limited
   * to `0.1`, `0.3`, `0.5`, and so on. If [rounded] is also `true`, [value] will first be rounded to a
   * multiple of this property's value, then rounded to the nearest integer.
   */
  public final inline var step: Double
    @JvmName("stepProperty")
    get() = getStep()
    @JvmName("stepProperty")
    set(`value`) {
      setStep(value)
    }

  /**
   * Page size. Used mainly for [ScrollBar]. A [ScrollBar]'s grabber length is the [ScrollBar]'s
   * size multiplied by [page] over the difference between [minValue] and [maxValue].
   */
  public final inline var page: Double
    @JvmName("pageProperty")
    get() = getPage()
    @JvmName("pageProperty")
    set(`value`) {
      setPage(value)
    }

  /**
   * Range's current value. Changing this property (even via code) will trigger [signal
   * value_changed] signal. Use [setValueNoSignal] if you want to avoid it.
   */
  public final inline var `value`: Double
    @JvmName("valueProperty")
    get() = getValue()
    @JvmName("valueProperty")
    set(`value`) {
      setValue(value)
    }

  /**
   * The value mapped between 0 and 1.
   */
  public final inline var ratio: Double
    @JvmName("ratioProperty")
    get() = getAsRatio()
    @JvmName("ratioProperty")
    set(`value`) {
      setAsRatio(value)
    }

  /**
   * If `true`, and [minValue] is greater or equal to `0`, [value] will be represented exponentially
   * rather than linearly.
   */
  public final inline var expEdit: Boolean
    @JvmName("expEditProperty")
    get() = isRatioExp()
    @JvmName("expEditProperty")
    set(`value`) {
      setExpRatio(value)
    }

  /**
   * If `true`, [value] will always be rounded to the nearest integer.
   */
  public final inline var rounded: Boolean
    @JvmName("roundedProperty")
    get() = isUsingRoundedValues()
    @JvmName("roundedProperty")
    set(`value`) {
      setUseRoundedValues(value)
    }

  /**
   * If `true`, [value] may be greater than [maxValue].
   */
  public final inline var allowGreater: Boolean
    @JvmName("allowGreaterProperty")
    get() = isGreaterAllowed()
    @JvmName("allowGreaterProperty")
    set(`value`) {
      setAllowGreater(value)
    }

  /**
   * If `true`, [value] may be less than [minValue].
   */
  public final inline var allowLesser: Boolean
    @JvmName("allowLesserProperty")
    get() = isLesserAllowed()
    @JvmName("allowLesserProperty")
    set(`value`) {
      setAllowLesser(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(598, scriptPtr)
  }

  /**
   * Called when the [Range]'s value is changed (following the same conditions as [signal
   * value_changed]).
   */
  public open fun _valueChanged(newValue: Double): Unit {
    throw NotImplementedError("Range::_valueChanged is not implemented.")
  }

  public final fun getValue(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getValuePtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun getMin(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun getMax(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun getStep(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStepPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun getPage(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPagePtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun getAsRatio(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAsRatioPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setValue(`value`: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value)
    TransferContext.callMethod(MethodBindings.setValuePtr)
  }

  /**
   * Sets the [Range]'s current value to the specified [value], without emitting the [signal
   * value_changed] signal.
   */
  public final fun setValueNoSignal(`value`: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value)
    TransferContext.callMethod(MethodBindings.setValueNoSignalPtr)
  }

  public final fun setMin(minimum: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, minimum)
    TransferContext.callMethod(MethodBindings.setMinPtr)
  }

  public final fun setMax(maximum: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, maximum)
    TransferContext.callMethod(MethodBindings.setMaxPtr)
  }

  public final fun setStep(step: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, step)
    TransferContext.callMethod(MethodBindings.setStepPtr)
  }

  public final fun setPage(pagesize: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, pagesize)
    TransferContext.callMethod(MethodBindings.setPagePtr)
  }

  public final fun setAsRatio(`value`: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value)
    TransferContext.callMethod(MethodBindings.setAsRatioPtr)
  }

  public final fun setUseRoundedValues(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setUseRoundedValuesPtr)
  }

  public final fun isUsingRoundedValues(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingRoundedValuesPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setExpRatio(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setExpRatioPtr)
  }

  public final fun isRatioExp(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRatioExpPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAllowGreater(allow: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, allow)
    TransferContext.callMethod(MethodBindings.setAllowGreaterPtr)
  }

  public final fun isGreaterAllowed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isGreaterAllowedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAllowLesser(allow: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, allow)
    TransferContext.callMethod(MethodBindings.setAllowLesserPtr)
  }

  public final fun isLesserAllowed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLesserAllowedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Binds two [Range]s together along with any ranges previously grouped with either of them. When
   * any of range's member variables change, it will share the new value with all other ranges in its
   * group.
   */
  public final fun share(with: Node?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, with)
    TransferContext.callMethod(MethodBindings.sharePtr)
  }

  /**
   * Stops the [Range] from sharing its member variables with any other.
   */
  public final fun unshare(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.unsharePtr)
  }

  public companion object {
    @JvmField
    public val getValueName: MethodStringName0<Range, Double> =
        MethodStringName0<Range, Double>("get_value")

    @JvmField
    public val getMinName: MethodStringName0<Range, Double> =
        MethodStringName0<Range, Double>("get_min")

    @JvmField
    public val getMaxName: MethodStringName0<Range, Double> =
        MethodStringName0<Range, Double>("get_max")

    @JvmField
    public val getStepName: MethodStringName0<Range, Double> =
        MethodStringName0<Range, Double>("get_step")

    @JvmField
    public val getPageName: MethodStringName0<Range, Double> =
        MethodStringName0<Range, Double>("get_page")

    @JvmField
    public val getAsRatioName: MethodStringName0<Range, Double> =
        MethodStringName0<Range, Double>("get_as_ratio")

    @JvmField
    public val setValueName: MethodStringName1<Range, Unit, Double> =
        MethodStringName1<Range, Unit, Double>("set_value")

    @JvmField
    public val setValueNoSignalName: MethodStringName1<Range, Unit, Double> =
        MethodStringName1<Range, Unit, Double>("set_value_no_signal")

    @JvmField
    public val setMinName: MethodStringName1<Range, Unit, Double> =
        MethodStringName1<Range, Unit, Double>("set_min")

    @JvmField
    public val setMaxName: MethodStringName1<Range, Unit, Double> =
        MethodStringName1<Range, Unit, Double>("set_max")

    @JvmField
    public val setStepName: MethodStringName1<Range, Unit, Double> =
        MethodStringName1<Range, Unit, Double>("set_step")

    @JvmField
    public val setPageName: MethodStringName1<Range, Unit, Double> =
        MethodStringName1<Range, Unit, Double>("set_page")

    @JvmField
    public val setAsRatioName: MethodStringName1<Range, Unit, Double> =
        MethodStringName1<Range, Unit, Double>("set_as_ratio")

    @JvmField
    public val setUseRoundedValuesName: MethodStringName1<Range, Unit, Boolean> =
        MethodStringName1<Range, Unit, Boolean>("set_use_rounded_values")

    @JvmField
    public val isUsingRoundedValuesName: MethodStringName0<Range, Boolean> =
        MethodStringName0<Range, Boolean>("is_using_rounded_values")

    @JvmField
    public val setExpRatioName: MethodStringName1<Range, Unit, Boolean> =
        MethodStringName1<Range, Unit, Boolean>("set_exp_ratio")

    @JvmField
    public val isRatioExpName: MethodStringName0<Range, Boolean> =
        MethodStringName0<Range, Boolean>("is_ratio_exp")

    @JvmField
    public val setAllowGreaterName: MethodStringName1<Range, Unit, Boolean> =
        MethodStringName1<Range, Unit, Boolean>("set_allow_greater")

    @JvmField
    public val isGreaterAllowedName: MethodStringName0<Range, Boolean> =
        MethodStringName0<Range, Boolean>("is_greater_allowed")

    @JvmField
    public val setAllowLesserName: MethodStringName1<Range, Unit, Boolean> =
        MethodStringName1<Range, Unit, Boolean>("set_allow_lesser")

    @JvmField
    public val isLesserAllowedName: MethodStringName0<Range, Boolean> =
        MethodStringName0<Range, Boolean>("is_lesser_allowed")

    @JvmField
    public val shareName: MethodStringName1<Range, Unit, Node?> =
        MethodStringName1<Range, Unit, Node?>("share")

    @JvmField
    public val unshareName: MethodStringName0<Range, Unit> =
        MethodStringName0<Range, Unit>("unshare")
  }

  public object MethodBindings {
    internal val getValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "get_value", 1740695150)

    internal val getMinPtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "get_min", 1740695150)

    internal val getMaxPtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "get_max", 1740695150)

    internal val getStepPtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "get_step", 1740695150)

    internal val getPagePtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "get_page", 1740695150)

    internal val getAsRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "get_as_ratio", 1740695150)

    internal val setValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "set_value", 373806689)

    internal val setValueNoSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "set_value_no_signal", 373806689)

    internal val setMinPtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "set_min", 373806689)

    internal val setMaxPtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "set_max", 373806689)

    internal val setStepPtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "set_step", 373806689)

    internal val setPagePtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "set_page", 373806689)

    internal val setAsRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "set_as_ratio", 373806689)

    internal val setUseRoundedValuesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "set_use_rounded_values", 2586408642)

    internal val isUsingRoundedValuesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "is_using_rounded_values", 36873697)

    internal val setExpRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "set_exp_ratio", 2586408642)

    internal val isRatioExpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "is_ratio_exp", 36873697)

    internal val setAllowGreaterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "set_allow_greater", 2586408642)

    internal val isGreaterAllowedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "is_greater_allowed", 36873697)

    internal val setAllowLesserPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "set_allow_lesser", 2586408642)

    internal val isLesserAllowedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Range", "is_lesser_allowed", 36873697)

    internal val sharePtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "share", 1078189570)

    internal val unsharePtr: VoidPtr = TypeManager.getMethodBindPtr("Range", "unshare", 3218959716)
  }
}
