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
import godot.core.Signal1
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.LONG
import kotlin.Any
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Result object tracking the asynchronous result of an OpenXR Future object, you can use this
 * object to track the result status.
 */
@GodotBaseType
public open class OpenXRFutureResult internal constructor() : RefCounted() {
  /**
   * Emitted when the asynchronous function is finished or has been cancelled.
   */
  public val completed: Signal1<OpenXRFutureResult> by Signal1

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(454, scriptPtr)
  }

  /**
   * Returns the status of this result.
   */
  public final fun getStatus(): ResultStatus {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStatusPtr)
    return ResultStatus.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Return the `XrFutureEXT` value this result relates to.
   */
  public final fun getFuture(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFuturePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Cancel this future, this will interrupt and stop the asynchronous function.
   */
  public final fun cancelFuture(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cancelFuturePtr)
  }

  /**
   * Stores the result value we expose to the user.
   *
   * **Note:** This method should only be called by an OpenXR extension that implements an
   * asynchronous function.
   */
  public final fun setResultValue(resultValue: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to resultValue)
    TransferContext.callMethod(MethodBindings.setResultValuePtr)
  }

  /**
   * Returns the result value of our asynchronous function (if set by the extension). The type of
   * this result value depends on the function being called. Consult the documentation of the relevant
   * function.
   */
  public final fun getResultValue(): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getResultValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public enum class ResultStatus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The asynchronous function is running.
     */
    RUNNING(0),
    /**
     * The asynchronous function has finished.
     */
    FINISHED(1),
    /**
     * The asynchronous function has been cancelled.
     */
    CANCELLED(2),
    ;

    public companion object {
      public fun from(`value`: Long): ResultStatus = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getStatusName: MethodStringName0<OpenXRFutureResult, ResultStatus> =
        MethodStringName0<OpenXRFutureResult, ResultStatus>("get_status")

    @JvmField
    public val getFutureName: MethodStringName0<OpenXRFutureResult, Long> =
        MethodStringName0<OpenXRFutureResult, Long>("get_future")

    @JvmField
    public val cancelFutureName: MethodStringName0<OpenXRFutureResult, Unit> =
        MethodStringName0<OpenXRFutureResult, Unit>("cancel_future")

    @JvmField
    public val setResultValueName: MethodStringName1<OpenXRFutureResult, Unit, Any?> =
        MethodStringName1<OpenXRFutureResult, Unit, Any?>("set_result_value")

    @JvmField
    public val getResultValueName: MethodStringName0<OpenXRFutureResult, Any?> =
        MethodStringName0<OpenXRFutureResult, Any?>("get_result_value")
  }

  public object MethodBindings {
    internal val getStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFutureResult", "get_status", 2023607463)

    internal val getFuturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFutureResult", "get_future", 3905245786)

    internal val cancelFuturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFutureResult", "cancel_future", 3218959716)

    internal val setResultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFutureResult", "set_result_value", 1114965689)

    internal val getResultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFutureResult", "get_result_value", 1214101251)
  }
}
