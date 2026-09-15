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
import godot.core.MethodStringName1
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [MethodTweener] is similar to a combination of [CallbackTweener] and [PropertyTweener]. It calls
 * a method providing an interpolated value as a parameter. See [Tween.tweenMethod] for more usage
 * information.
 *
 * The tweener will finish automatically if the callback's target object is freed.
 *
 * **Note:** [Tween.tweenMethod] is the only correct way to create [MethodTweener]. Any
 * [MethodTweener] created manually will not function correctly.
 */
@GodotBaseType
public open class MethodTweener : Tweener() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(380, scriptPtr)
  }

  /**
   * Sets the time in seconds after which the [MethodTweener] will start interpolating. By default
   * there's no delay.
   */
  public final fun setDelay(delay: Double): MethodTweener {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, delay)
    TransferContext.callMethod(MethodBindings.setDelayPtr)
    return (TransferContext.readReturnValue_OBJECT() as MethodTweener)
  }

  /**
   * Sets the type of used transition from [Tween.TransitionType]. If not set, the default
   * transition is used from the [Tween] that contains this Tweener.
   */
  public final fun setTrans(trans: Tween.TransitionType): MethodTweener {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, trans.value)
    TransferContext.callMethod(MethodBindings.setTransPtr)
    return (TransferContext.readReturnValue_OBJECT() as MethodTweener)
  }

  /**
   * Sets the type of used easing from [Tween.EaseType]. If not set, the default easing is used from
   * the [Tween] that contains this Tweener.
   */
  public final fun setEase(ease: Tween.EaseType): MethodTweener {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, ease.value)
    TransferContext.callMethod(MethodBindings.setEasePtr)
    return (TransferContext.readReturnValue_OBJECT() as MethodTweener)
  }

  public companion object {
    @JvmField
    public val setDelayName: MethodStringName1<MethodTweener, MethodTweener, Double> =
        MethodStringName1<MethodTweener, MethodTweener, Double>("set_delay")

    @JvmField
    public val setTransName: MethodStringName1<MethodTweener, MethodTweener, Tween.TransitionType> =
        MethodStringName1<MethodTweener, MethodTweener, Tween.TransitionType>("set_trans")

    @JvmField
    public val setEaseName: MethodStringName1<MethodTweener, MethodTweener, Tween.EaseType> =
        MethodStringName1<MethodTweener, MethodTweener, Tween.EaseType>("set_ease")
  }

  public object MethodBindings {
    internal val setDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MethodTweener", "set_delay", 266477812)

    internal val setTransPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MethodTweener", "set_trans", 3740975367)

    internal val setEasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MethodTweener", "set_ease", 315540545)
  }
}
