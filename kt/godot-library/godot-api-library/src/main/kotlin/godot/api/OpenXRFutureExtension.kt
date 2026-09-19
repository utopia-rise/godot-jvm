// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_LONG_CALLABLE_ret_OBJECT_REF
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.Callable
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantCallable
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This is a support extension in OpenXR that allows other OpenXR extensions to start asynchronous
 * functions and get a callback after this function finishes. It is not intended for consumption within
 * GDScript but can be accessed from GDExtension.
 */
@GodotBaseType
public open class OpenXRFutureExtension : OpenXRExtensionWrapper() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(453, scriptPtr)
  }

  /**
   * Returns `true` if futures are available in the OpenXR runtime used. This function will only
   * return a usable result after OpenXR has been initialized.
   */
  public final fun isActive(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isActivePtr)

  /**
   * Register an OpenXR Future object so we monitor for completion. [future] must be an
   * `XrFutureEXT` value previously returned by an API that started an asynchronous function.
   *
   * You can optionally specify [onSuccess], it will be invoked on successful completion of the
   * future.
   *
   * Or you can use the returned [OpenXRFutureResult] object to `await` its [signal
   * OpenXRFutureResult.completed] signal.
   *
   * ```
   * var future_result = OpenXRFutureExtension.register_future(future)
   * await future_result.completed
   * if future_result.get_status() == OpenXRFutureResult.RESULT_FINISHED:
   * 	# Handle your success
   * 	pass
   * ```
   */
  @JvmOverloads
  public final fun registerFuture(future: Long, onSuccess: Callable = VariantCallable()):
      OpenXRFutureResult? =
      (TransferContext.callMethod_LONG_CALLABLE_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.registerFuturePtr, future, onSuccess) as OpenXRFutureResult?)

  /**
   * Cancels an in-progress future. [future] must be an `XrFutureEXT` value previously returned by
   * an API that started an asynchronous function.
   */
  public final fun cancelFuture(future: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.cancelFuturePtr, future)
  }

  public companion object {
    @JvmField
    public val isActiveName: MethodStringName0<OpenXRFutureExtension, Boolean> =
        MethodStringName0<OpenXRFutureExtension, Boolean>("is_active")

    @JvmField
    public val registerFutureName:
        MethodStringName2<OpenXRFutureExtension, OpenXRFutureResult?, Long, Callable> =
        MethodStringName2<OpenXRFutureExtension, OpenXRFutureResult?, Long, Callable>("register_future")

    @JvmField
    public val cancelFutureName: MethodStringName1<OpenXRFutureExtension, Unit, Long> =
        MethodStringName1<OpenXRFutureExtension, Unit, Long>("cancel_future")
  }

  public object MethodBindings {
    internal val isActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFutureExtension", "is_active", 36873697)

    internal val registerFuturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFutureExtension", "register_future", 1038012256)

    internal val cancelFuturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFutureExtension", "cancel_future", 1286410249)
  }
}
