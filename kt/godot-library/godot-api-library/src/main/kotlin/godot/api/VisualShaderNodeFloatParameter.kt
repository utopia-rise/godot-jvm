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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Translated to `uniform float` in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeFloatParameter : VisualShaderNodeParameter() {
  /**
   * A hint applied to the uniform, which controls the values it can take when set through the
   * Inspector.
   */
  public final inline var hint: Hint
    @JvmName("hintProperty")
    get() = getHint()
    @JvmName("hintProperty")
    set(`value`) {
      setHint(value)
    }

  /**
   * Maximum value for range hints. Used if [hint] is set to [HINT_RANGE] or [HINT_RANGE_STEP].
   */
  public final inline var min: Float
    @JvmName("minProperty")
    get() = getMin()
    @JvmName("minProperty")
    set(`value`) {
      setMin(value)
    }

  /**
   * Minimum value for range hints. Used if [hint] is set to [HINT_RANGE] or [HINT_RANGE_STEP].
   */
  public final inline var max: Float
    @JvmName("maxProperty")
    get() = getMax()
    @JvmName("maxProperty")
    set(`value`) {
      setMax(value)
    }

  /**
   * Step (increment) value for the range hint with step. Used if [hint] is set to
   * [HINT_RANGE_STEP].
   */
  public final inline var step: Float
    @JvmName("stepProperty")
    get() = getStep()
    @JvmName("stepProperty")
    set(`value`) {
      setStep(value)
    }

  /**
   * Enables usage of the [defaultValue].
   */
  public final inline var defaultValueEnabled: Boolean
    @JvmName("defaultValueEnabledProperty")
    get() = isDefaultValueEnabled()
    @JvmName("defaultValueEnabledProperty")
    set(`value`) {
      setDefaultValueEnabled(value)
    }

  /**
   * A default value to be assigned within the shader.
   */
  public final inline var defaultValue: Float
    @JvmName("defaultValueProperty")
    get() = getDefaultValue()
    @JvmName("defaultValueProperty")
    set(`value`) {
      setDefaultValue(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(831, scriptPtr)
  }

  public final fun setHint(hint: Hint): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, hint.value)
    TransferContext.callPtrMethod(MethodBindings.setHintPtr, 0)
  }

  public final fun getHint(): Hint {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHintPtr, 2)
    return Hint.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setMin(`value`: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMinPtr, 0)
  }

  public final fun getMin(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMinPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMax(`value`: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMaxPtr, 0)
  }

  public final fun getMax(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setStep(`value`: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setStepPtr, 0)
  }

  public final fun getStep(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStepPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDefaultValueEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setDefaultValueEnabledPtr, 0)
  }

  public final fun isDefaultValueEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isDefaultValueEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDefaultValue(`value`: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setDefaultValuePtr, 0)
  }

  public final fun getDefaultValue(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDefaultValuePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public enum class Hint(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No hint used.
     */
    NONE(0),
    /**
     * A range hint for scalar value, which limits possible input values between [min] and [max].
     * Translated to `hint_range(min, max)` in shader code.
     */
    RANGE(1),
    /**
     * A range hint for scalar value with step, which limits possible input values between [min] and
     * [max], with a step (increment) of [step]). Translated to `hint_range(min, max, step)` in shader
     * code.
     */
    RANGE_STEP(2),
    /**
     * Represents the size of the [Hint] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): Hint = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setHintName: MethodStringName1<VisualShaderNodeFloatParameter, Unit, Hint> =
        MethodStringName1<VisualShaderNodeFloatParameter, Unit, Hint>("set_hint")

    @JvmField
    public val getHintName: MethodStringName0<VisualShaderNodeFloatParameter, Hint> =
        MethodStringName0<VisualShaderNodeFloatParameter, Hint>("get_hint")

    @JvmField
    public val setMinName: MethodStringName1<VisualShaderNodeFloatParameter, Unit, Float> =
        MethodStringName1<VisualShaderNodeFloatParameter, Unit, Float>("set_min")

    @JvmField
    public val getMinName: MethodStringName0<VisualShaderNodeFloatParameter, Float> =
        MethodStringName0<VisualShaderNodeFloatParameter, Float>("get_min")

    @JvmField
    public val setMaxName: MethodStringName1<VisualShaderNodeFloatParameter, Unit, Float> =
        MethodStringName1<VisualShaderNodeFloatParameter, Unit, Float>("set_max")

    @JvmField
    public val getMaxName: MethodStringName0<VisualShaderNodeFloatParameter, Float> =
        MethodStringName0<VisualShaderNodeFloatParameter, Float>("get_max")

    @JvmField
    public val setStepName: MethodStringName1<VisualShaderNodeFloatParameter, Unit, Float> =
        MethodStringName1<VisualShaderNodeFloatParameter, Unit, Float>("set_step")

    @JvmField
    public val getStepName: MethodStringName0<VisualShaderNodeFloatParameter, Float> =
        MethodStringName0<VisualShaderNodeFloatParameter, Float>("get_step")

    @JvmField
    public val setDefaultValueEnabledName:
        MethodStringName1<VisualShaderNodeFloatParameter, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeFloatParameter, Unit, Boolean>("set_default_value_enabled")

    @JvmField
    public val isDefaultValueEnabledName: MethodStringName0<VisualShaderNodeFloatParameter, Boolean>
        = MethodStringName0<VisualShaderNodeFloatParameter, Boolean>("is_default_value_enabled")

    @JvmField
    public val setDefaultValueName: MethodStringName1<VisualShaderNodeFloatParameter, Unit, Float> =
        MethodStringName1<VisualShaderNodeFloatParameter, Unit, Float>("set_default_value")

    @JvmField
    public val getDefaultValueName: MethodStringName0<VisualShaderNodeFloatParameter, Float> =
        MethodStringName0<VisualShaderNodeFloatParameter, Float>("get_default_value")
  }

  public object MethodBindings {
    internal val setHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "set_hint", 3712586466)

    internal val getHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "get_hint", 3042240429)

    internal val setMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "set_min", 373806689)

    internal val getMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "get_min", 1740695150)

    internal val setMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "set_max", 373806689)

    internal val getMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "get_max", 1740695150)

    internal val setStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "set_step", 373806689)

    internal val getStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "get_step", 1740695150)

    internal val setDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "set_default_value_enabled", 2586408642)

    internal val isDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "is_default_value_enabled", 36873697)

    internal val setDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "set_default_value", 373806689)

    internal val getDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatParameter", "get_default_value", 1740695150)
  }
}
