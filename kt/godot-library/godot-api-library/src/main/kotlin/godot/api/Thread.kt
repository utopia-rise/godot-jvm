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
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.readReturnValue_ANY
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_CALLABLE_LONG
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * A unit of execution in a process. Can run methods on [Object]s simultaneously. The use of
 * synchronization via [Mutex] or [Semaphore] is advised if working with shared objects.
 *
 * **Warning:** To ensure proper cleanup without crashes or deadlocks, when a [Thread]'s reference
 * count reaches zero and it is therefore destroyed, the following conditions must be met:
 *
 * - It must not have any [Mutex] objects locked.
 *
 * - It must not be waiting on any [Semaphore] objects.
 *
 * - [waitToFinish] should have been called on it.
 */
@GodotBaseType
public open class Thread : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(755, scriptPtr)
  }

  /**
   * Starts a new [Thread] that calls [callable].
   *
   * If the method takes some arguments, you can pass them using [Callable.bind].
   *
   * The [priority] of the [Thread] can be changed by passing a value from the [Priority] enum.
   *
   * Returns [OK] on success, or [ERR_CANT_CREATE] on failure.
   */
  @JvmOverloads
  public final fun start(callable: Callable, priority: Priority = Thread.Priority.NORMAL): Error {
    TransferContext.writeMethodArguments_CALLABLE_LONG(ptr, objectID.id, callable, priority.value)
    TransferContext.callMethod(MethodBindings.startPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the current [Thread]'s ID, uniquely identifying it among all threads. If the [Thread]
   * has not started running or if [waitToFinish] has been called, this returns an empty string.
   */
  public final fun getId(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIdPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if this [Thread] has been started. Once started, this will return `true` until
   * it is joined using [waitToFinish]. For checking if a [Thread] is still executing its task, use
   * [isAlive].
   */
  public final fun isStarted(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isStartedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if this [Thread] is currently running the provided function. This is useful for
   * determining if [waitToFinish] can be called without blocking the calling thread.
   *
   * To check if a [Thread] is joinable, use [isStarted].
   */
  public final fun isAlive(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAlivePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Joins the [Thread] and waits for it to finish. Returns the output of the [Callable] passed to
   * [start].
   *
   * Should either be used when you want to retrieve the value returned from the method called by
   * the [Thread] or before freeing the instance that contains the [Thread].
   *
   * To determine if this can be called without blocking the calling thread, check if [isAlive] is
   * `false`.
   */
  public final fun waitToFinish(): Any? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.waitToFinishPtr)
    return TransferContext.readReturnValue_ANY()
  }

  public enum class Priority(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A thread running with lower priority than normally.
     */
    LOW(0),
    /**
     * A thread with a standard priority.
     */
    NORMAL(1),
    /**
     * A thread running with higher priority than normally.
     */
    HIGH(2),
    ;

    public companion object {
      public fun from(`value`: Long): Priority = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val startName: MethodStringName2<Thread, Error, Callable, Priority> =
        MethodStringName2<Thread, Error, Callable, Priority>("start")

    @JvmField
    public val getIdName: MethodStringName0<Thread, String> =
        MethodStringName0<Thread, String>("get_id")

    @JvmField
    public val isStartedName: MethodStringName0<Thread, Boolean> =
        MethodStringName0<Thread, Boolean>("is_started")

    @JvmField
    public val isAliveName: MethodStringName0<Thread, Boolean> =
        MethodStringName0<Thread, Boolean>("is_alive")

    @JvmField
    public val waitToFinishName: MethodStringName0<Thread, Any?> =
        MethodStringName0<Thread, Any?>("wait_to_finish")

    @JvmField
    public val setThreadSafetyChecksEnabledName: MethodStringName1<Thread, Unit, Boolean> =
        MethodStringName1<Thread, Unit, Boolean>("set_thread_safety_checks_enabled")

    @JvmField
    public val isMainThreadName: MethodStringName0<Thread, Boolean> =
        MethodStringName0<Thread, Boolean>("is_main_thread")

    /**
     * Sets whether the thread safety checks the engine normally performs in methods of certain
     * classes (e.g., [Node]) should happen **on the current thread**.
     *
     * The default, for every thread, is that they are enabled (as if called with [enabled] being
     * `true`).
     *
     * Those checks are conservative. That means that they will only succeed in considering a call
     * thread-safe (and therefore allow it to happen) if the engine can guarantee such safety.
     *
     * Because of that, there may be cases where the user may want to disable them ([enabled] being
     * `false`) to make certain operations allowed again. By doing so, it becomes the user's
     * responsibility to ensure thread safety (e.g., by using [Mutex]) for those objects that are
     * otherwise protected by the engine.
     *
     * **Note:** This is an advanced usage of the engine. You are advised to use it only if you know
     * what you are doing and there is no safer way.
     *
     * **Note:** This is useful for scripts running on either arbitrary [Thread] objects or tasks
     * submitted to the [WorkerThreadPool]. It doesn't apply to code running during [Node] group
     * processing, where the checks will be always performed.
     *
     * **Note:** Even in the case of having disabled the checks in a [WorkerThreadPool] task,
     * there's no need to re-enable them at the end. The engine will do so.
     */
    @JvmStatic
    public final fun setThreadSafetyChecksEnabled(enabled: Boolean): Unit {
      TransferContext.writeMethodArguments_BOOL(0L, 0L, enabled)
      TransferContext.callPtrMethod(MethodBindings.setThreadSafetyChecksEnabledPtr, 0)
    }

    /**
     * Returns `true` if the thread this method was called from is the main thread.
     *
     * **Note:** This is a static method and isn't associated with a specific [Thread] object.
     */
    @JvmStatic
    public final fun isMainThread(): Boolean {
      TransferContext.writeMethodArguments0(0L, 0L)
      TransferContext.callPtrMethod(MethodBindings.isMainThreadPtr, 1)
      return TransferContext.readReturnValue_BOOL()
    }
  }

  public object MethodBindings {
    internal val startPtr: VoidPtr = TypeManager.getMethodBindPtr("Thread", "start", 1327203254)

    internal val getIdPtr: VoidPtr = TypeManager.getMethodBindPtr("Thread", "get_id", 201670096)

    internal val isStartedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Thread", "is_started", 36873697)

    internal val isAlivePtr: VoidPtr = TypeManager.getMethodBindPtr("Thread", "is_alive", 36873697)

    internal val waitToFinishPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Thread", "wait_to_finish", 1460262497)

    internal val setThreadSafetyChecksEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Thread", "set_thread_safety_checks_enabled", 2586408642)

    internal val isMainThreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Thread", "is_main_thread", 2240911060)
  }
}
