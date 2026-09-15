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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_ANY
import godot.writeMethodArguments_CALLABLE
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Any
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [PropertyTweener] is used to interpolate a property in an object. See [Tween.tweenProperty] for
 * more usage information.
 *
 * The tweener will finish automatically if the target object is freed.
 *
 * **Note:** [Tween.tweenProperty] is the only correct way to create [PropertyTweener]. Any
 * [PropertyTweener] created manually will not function correctly.
 */
@GodotBaseType
public open class PropertyTweener : Tweener() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(574, scriptPtr)
  }

  /**
   * Sets a custom initial value to the [PropertyTweener].
   *
   * **Example:** Move the node from position `(100, 100)` to `(200, 100)`.
   *
   * ```gdscript
   * //gdscript
   * var tween = get_tree().create_tween()
   * tween.tween_property(self, "position", Vector2(200, 100), 1).from(Vector2(100, 100))
   * ```
   *
   * ```csharp
   * //csharp
   * Tween tween = GetTree().CreateTween();
   * tween.TweenProperty(this, "position", new Vector2(200.0f, 100.0f), 1.0f).From(new
   * Vector2(100.0f, 100.0f));
   * ```
   */
  public final fun from(`value`: Any?): PropertyTweener {
    TransferContext.writeMethodArguments_ANY(ptr, objectID.id, value)
    TransferContext.callMethod(MethodBindings.fromPtr)
    return (TransferContext.readReturnValue_OBJECT() as PropertyTweener)
  }

  /**
   * Makes the [PropertyTweener] use the current property value (i.e. at the time of creating this
   * [PropertyTweener]) as a starting point. This is equivalent of using [from] with the current value.
   * These two calls will do the same:
   *
   * ```gdscript
   * //gdscript
   * tween.tween_property(self, "position", Vector2(200, 100), 1).from(position)
   * tween.tween_property(self, "position", Vector2(200, 100), 1).from_current()
   * ```
   *
   * ```csharp
   * //csharp
   * tween.TweenProperty(this, "position", new Vector2(200.0f, 100.0f), 1.0f).From(Position);
   * tween.TweenProperty(this, "position", new Vector2(200.0f, 100.0f), 1.0f).FromCurrent();
   * ```
   */
  public final fun fromCurrent(): PropertyTweener {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.fromCurrentPtr)
    return (TransferContext.readReturnValue_OBJECT() as PropertyTweener)
  }

  /**
   * When called, the final value will be used as a relative value instead.
   *
   * **Example:** Move the node by `100` pixels to the right.
   *
   * ```gdscript
   * //gdscript
   * var tween = get_tree().create_tween()
   * tween.tween_property(self, "position", Vector2.RIGHT * 100, 1).as_relative()
   * ```
   *
   * ```csharp
   * //csharp
   * Tween tween = GetTree().CreateTween();
   * tween.TweenProperty(this, "position", Vector2.Right * 100.0f, 1.0f).AsRelative();
   * ```
   */
  public final fun asRelative(): PropertyTweener {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.asRelativePtr)
    return (TransferContext.readReturnValue_OBJECT() as PropertyTweener)
  }

  /**
   * Sets the type of used transition from [Tween.TransitionType]. If not set, the default
   * transition is used from the [Tween] that contains this Tweener.
   */
  public final fun setTrans(trans: Tween.TransitionType): PropertyTweener {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, trans.value)
    TransferContext.callMethod(MethodBindings.setTransPtr)
    return (TransferContext.readReturnValue_OBJECT() as PropertyTweener)
  }

  /**
   * Sets the type of used easing from [Tween.EaseType]. If not set, the default easing is used from
   * the [Tween] that contains this Tweener.
   */
  public final fun setEase(ease: Tween.EaseType): PropertyTweener {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, ease.value)
    TransferContext.callMethod(MethodBindings.setEasePtr)
    return (TransferContext.readReturnValue_OBJECT() as PropertyTweener)
  }

  /**
   * Allows interpolating the value with a custom easing function. The provided [interpolatorMethod]
   * will be called with a value ranging from `0.0` to `1.0` and is expected to return a value within
   * the same range (values outside the range can be used for overshoot). The return value of the
   * method is then used for interpolation between initial and final value. Note that the parameter
   * passed to the method is still subject to the tweener's own easing.
   *
   * ```gdscript
   * //gdscript
   * @export var curve: Curve
   *
   * func _ready():
   * 	var tween = create_tween()
   * 	# Interpolate the value using a custom curve.
   * 	tween.tween_property(self, "position:x", 300,
   * 1).as_relative().set_custom_interpolator(tween_curve)
   *
   * func tween_curve(v):
   * 	return curve.sample_baked(v)
   * ```
   *
   * ```csharp
   * //csharp
   * [Export]
   * public Curve Curve { get; set; }
   *
   * public override void _Ready()
   * {
   * 	Tween tween = CreateTween();
   * 	// Interpolate the value using a custom curve.
   * 	Callable tweenCurveCallable = Callable.From<float, float>(TweenCurve);
   * 	tween.TweenProperty(this, "position:x", 300.0f,
   * 1.0f).AsRelative().SetCustomInterpolator(tweenCurveCallable);
   * }
   *
   * private float TweenCurve(float value)
   * {
   * 	return Curve.SampleBaked(value);
   * }
   * ```
   */
  public final fun setCustomInterpolator(interpolatorMethod: Callable): PropertyTweener {
    TransferContext.writeMethodArguments_CALLABLE(ptr, objectID.id, interpolatorMethod)
    TransferContext.callMethod(MethodBindings.setCustomInterpolatorPtr)
    return (TransferContext.readReturnValue_OBJECT() as PropertyTweener)
  }

  /**
   * Sets the time in seconds after which the [PropertyTweener] will start interpolating. By default
   * there's no delay.
   */
  public final fun setDelay(delay: Double): PropertyTweener {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, delay)
    TransferContext.callMethod(MethodBindings.setDelayPtr)
    return (TransferContext.readReturnValue_OBJECT() as PropertyTweener)
  }

  public companion object {
    @JvmField
    public val fromName: MethodStringName1<PropertyTweener, PropertyTweener, Any?> =
        MethodStringName1<PropertyTweener, PropertyTweener, Any?>("from")

    @JvmField
    public val fromCurrentName: MethodStringName0<PropertyTweener, PropertyTweener> =
        MethodStringName0<PropertyTweener, PropertyTweener>("from_current")

    @JvmField
    public val asRelativeName: MethodStringName0<PropertyTweener, PropertyTweener> =
        MethodStringName0<PropertyTweener, PropertyTweener>("as_relative")

    @JvmField
    public val setTransName:
        MethodStringName1<PropertyTweener, PropertyTweener, Tween.TransitionType> =
        MethodStringName1<PropertyTweener, PropertyTweener, Tween.TransitionType>("set_trans")

    @JvmField
    public val setEaseName: MethodStringName1<PropertyTweener, PropertyTweener, Tween.EaseType> =
        MethodStringName1<PropertyTweener, PropertyTweener, Tween.EaseType>("set_ease")

    @JvmField
    public val setCustomInterpolatorName:
        MethodStringName1<PropertyTweener, PropertyTweener, Callable> =
        MethodStringName1<PropertyTweener, PropertyTweener, Callable>("set_custom_interpolator")

    @JvmField
    public val setDelayName: MethodStringName1<PropertyTweener, PropertyTweener, Double> =
        MethodStringName1<PropertyTweener, PropertyTweener, Double>("set_delay")
  }

  public object MethodBindings {
    internal val fromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PropertyTweener", "from", 4190193059)

    internal val fromCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PropertyTweener", "from_current", 4279177709)

    internal val asRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PropertyTweener", "as_relative", 4279177709)

    internal val setTransPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PropertyTweener", "set_trans", 1899107404)

    internal val setEasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PropertyTweener", "set_ease", 1080455622)

    internal val setCustomInterpolatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PropertyTweener", "set_custom_interpolator", 3174170268)

    internal val setDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PropertyTweener", "set_delay", 2171559331)
  }
}
