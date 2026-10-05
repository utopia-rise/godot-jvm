// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_DOUBLE_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [AwaitTweener] is used to await a specified signal, allowing asynchronous steps in [Tween]
 * animation. See [Tween.tweenAwait] for more usage information.
 *
 * The [signal Tweener.finished] signal is emitted when either the awaited signal is received, when
 * timeout is reached, or when the target object is freed.
 */
@GodotBaseType
public open class AwaitTweener : Tweener() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(103, scriptPtr)
  }

  /**
   * Sets the maximum time an [AwaitTweener] can wait for the signal. Can be used as a safeguard for
   * signals that may never be emitted. If not specified, the tweener will wait indefinitely.
   */
  public final fun setTimeout(timeout: Double): AwaitTweener? =
      (TransferContext.callPtrMethod_DOUBLE_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.setTimeoutPtr, timeout) as AwaitTweener?)

  public companion object {
    @JvmField
    public val setTimeoutName: MethodStringName1<AwaitTweener, AwaitTweener?, Double> =
        MethodStringName1<AwaitTweener, AwaitTweener?, Double>("set_timeout")
  }

  public object MethodBindings {
    internal val setTimeoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AwaitTweener", "set_timeout", 3123469156)
  }
}
