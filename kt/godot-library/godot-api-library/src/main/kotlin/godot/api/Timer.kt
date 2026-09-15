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
import godot.core.Signal0
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * The [Timer] node is a countdown timer and is the simplest way to handle time-based logic in the
 * engine. When a timer reaches the end of its [waitTime], it will emit the [signal timeout] signal.
 *
 * After a timer enters the scene tree, it can be manually started with [start]. A timer node is
 * also started automatically if [autostart] is `true`.
 *
 * Without requiring much code, a timer node can be added and configured in the editor. The [signal
 * timeout] signal it emits can also be connected through the Signals dock in the editor:
 *
 * ```
 * func _on_timer_timeout():
 * 	print("Time to attack!")
 * ```
 *
 * **Note:** To create a one-shot timer without instantiating a node, use [SceneTree.createTimer].
 *
 * **Note:** Timers are affected by [Engine.timeScale] unless [ignoreTimeScale] is `true`. The
 * higher the time scale, the sooner timers will end. How often a timer processes may depend on the
 * framerate or [Engine.physicsTicksPerSecond].
 */
@GodotBaseType
public open class Timer : Node() {
  /**
   * Emitted when the timer reaches the end.
   */
  public val timeout: Signal0 by Signal0

  /**
   * Specifies when the timer is updated during the main loop.
   */
  public final inline var processCallback: TimerProcessCallback
    @JvmName("processCallbackProperty")
    get() = getTimerProcessCallback()
    @JvmName("processCallbackProperty")
    set(`value`) {
      setTimerProcessCallback(value)
    }

  /**
   * The time required for the timer to end, in seconds. This property can also be set every time
   * [start] is called.
   *
   * **Note:** Timers can only process once per physics or process frame (depending on the
   * [processCallback]). An unstable framerate may cause the timer to end inconsistently, which is
   * especially noticeable if the wait time is lower than roughly `0.05` seconds. For very short
   * timers, it is recommended to write your own code instead of using a [Timer] node. Timers are also
   * affected by [Engine.timeScale].
   */
  public final inline var waitTime: Double
    @JvmName("waitTimeProperty")
    get() = getWaitTime()
    @JvmName("waitTimeProperty")
    set(`value`) {
      setWaitTime(value)
    }

  /**
   * If `true`, the timer will stop after reaching the end. Otherwise, as by default, the timer will
   * automatically restart.
   */
  public final inline var oneShot: Boolean
    @JvmName("oneShotProperty")
    get() = isOneShot()
    @JvmName("oneShotProperty")
    set(`value`) {
      setOneShot(value)
    }

  /**
   * If `true`, the timer will start immediately when it enters the scene tree.
   *
   * **Note:** After the timer enters the tree, this property is automatically set to `false`.
   *
   * **Note:** This property does nothing when the timer is running in the editor.
   */
  public final inline var autostart: Boolean
    @JvmName("autostartProperty")
    get() = hasAutostart()
    @JvmName("autostartProperty")
    set(`value`) {
      setAutostart(value)
    }

  /**
   * If `true`, the timer is paused. A paused timer does not process until this property is set back
   * to `false`, even when [start] is called. See also [stop].
   */
  public final inline var paused: Boolean
    @JvmName("pausedProperty")
    get() = isPaused()
    @JvmName("pausedProperty")
    set(`value`) {
      setPaused(value)
    }

  /**
   * If `true`, the timer will ignore [Engine.timeScale] and update with the real, elapsed time.
   */
  public final inline var ignoreTimeScale: Boolean
    @JvmName("ignoreTimeScaleProperty")
    get() = isIgnoringTimeScale()
    @JvmName("ignoreTimeScaleProperty")
    set(`value`) {
      setIgnoreTimeScale(value)
    }

  /**
   * The timer's remaining time in seconds. This is always `0` if the timer is stopped.
   *
   * **Note:** This property is read-only and cannot be modified. It is based on [waitTime].
   */
  public final inline val timeLeft: Double
    @JvmName("timeLeftProperty")
    get() = getTimeLeft()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(765, scriptPtr)
  }

  public final fun setWaitTime(timeSec: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, timeSec)
    TransferContext.callMethod(MethodBindings.setWaitTimePtr)
  }

  public final fun getWaitTime(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWaitTimePtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setOneShot(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setOneShotPtr)
  }

  public final fun isOneShot(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOneShotPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAutostart(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setAutostartPtr)
  }

  public final fun hasAutostart(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasAutostartPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Starts the timer, or resets the timer if it was started already. Fails if the timer is not
   * inside the scene tree. If [timeSec] is greater than `0`, this value is used for the [waitTime].
   *
   * **Note:** This method does not resume a paused timer. See [paused].
   */
  @JvmOverloads
  public final fun start(timeSec: Double = -1.0): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, timeSec)
    TransferContext.callMethod(MethodBindings.startPtr)
  }

  /**
   * Stops the timer. See also [paused]. Unlike [start], this can safely be called if the timer is
   * not inside the scene tree.
   *
   * **Note:** Calling [stop] does not emit the [signal timeout] signal, as the timer is not
   * considered to have timed out. If this is desired, use `$Timer.timeout.emit()` after calling [stop]
   * to manually emit the signal.
   */
  public final fun stop(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.stopPtr)
  }

  public final fun setPaused(paused: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, paused)
    TransferContext.callMethod(MethodBindings.setPausedPtr)
  }

  public final fun isPaused(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPausedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setIgnoreTimeScale(ignore: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, ignore)
    TransferContext.callMethod(MethodBindings.setIgnoreTimeScalePtr)
  }

  public final fun isIgnoringTimeScale(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIgnoringTimeScalePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the timer is stopped or has not started.
   */
  public final fun isStopped(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isStoppedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getTimeLeft(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTimeLeftPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setTimerProcessCallback(callback: TimerProcessCallback): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, callback.value)
    TransferContext.callMethod(MethodBindings.setTimerProcessCallbackPtr)
  }

  public final fun getTimerProcessCallback(): TimerProcessCallback {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTimerProcessCallbackPtr)
    return TimerProcessCallback.from(TransferContext.readReturnValue_LONG())
  }

  public enum class TimerProcessCallback(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Update the timer every physics process frame (see
     * [Node.NOTIFICATION_INTERNAL_PHYSICS_PROCESS]).
     */
    PHYSICS(0),
    /**
     * Update the timer every process (rendered) frame (see [Node.NOTIFICATION_INTERNAL_PROCESS]).
     */
    IDLE(1),
    ;

    public companion object {
      public fun from(`value`: Long): TimerProcessCallback =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setWaitTimeName: MethodStringName1<Timer, Unit, Double> =
        MethodStringName1<Timer, Unit, Double>("set_wait_time")

    @JvmField
    public val getWaitTimeName: MethodStringName0<Timer, Double> =
        MethodStringName0<Timer, Double>("get_wait_time")

    @JvmField
    public val setOneShotName: MethodStringName1<Timer, Unit, Boolean> =
        MethodStringName1<Timer, Unit, Boolean>("set_one_shot")

    @JvmField
    public val isOneShotName: MethodStringName0<Timer, Boolean> =
        MethodStringName0<Timer, Boolean>("is_one_shot")

    @JvmField
    public val setAutostartName: MethodStringName1<Timer, Unit, Boolean> =
        MethodStringName1<Timer, Unit, Boolean>("set_autostart")

    @JvmField
    public val hasAutostartName: MethodStringName0<Timer, Boolean> =
        MethodStringName0<Timer, Boolean>("has_autostart")

    @JvmField
    public val startName: MethodStringName1<Timer, Unit, Double> =
        MethodStringName1<Timer, Unit, Double>("start")

    @JvmField
    public val stopName: MethodStringName0<Timer, Unit> = MethodStringName0<Timer, Unit>("stop")

    @JvmField
    public val setPausedName: MethodStringName1<Timer, Unit, Boolean> =
        MethodStringName1<Timer, Unit, Boolean>("set_paused")

    @JvmField
    public val isPausedName: MethodStringName0<Timer, Boolean> =
        MethodStringName0<Timer, Boolean>("is_paused")

    @JvmField
    public val setIgnoreTimeScaleName: MethodStringName1<Timer, Unit, Boolean> =
        MethodStringName1<Timer, Unit, Boolean>("set_ignore_time_scale")

    @JvmField
    public val isIgnoringTimeScaleName: MethodStringName0<Timer, Boolean> =
        MethodStringName0<Timer, Boolean>("is_ignoring_time_scale")

    @JvmField
    public val isStoppedName: MethodStringName0<Timer, Boolean> =
        MethodStringName0<Timer, Boolean>("is_stopped")

    @JvmField
    public val getTimeLeftName: MethodStringName0<Timer, Double> =
        MethodStringName0<Timer, Double>("get_time_left")

    @JvmField
    public val setTimerProcessCallbackName: MethodStringName1<Timer, Unit, TimerProcessCallback> =
        MethodStringName1<Timer, Unit, TimerProcessCallback>("set_timer_process_callback")

    @JvmField
    public val getTimerProcessCallbackName: MethodStringName0<Timer, TimerProcessCallback> =
        MethodStringName0<Timer, TimerProcessCallback>("get_timer_process_callback")
  }

  public object MethodBindings {
    internal val setWaitTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "set_wait_time", 373806689)

    internal val getWaitTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "get_wait_time", 1740695150)

    internal val setOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "set_one_shot", 2586408642)

    internal val isOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "is_one_shot", 36873697)

    internal val setAutostartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "set_autostart", 2586408642)

    internal val hasAutostartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "has_autostart", 36873697)

    internal val startPtr: VoidPtr = TypeManager.getMethodBindPtr("Timer", "start", 1392008558)

    internal val stopPtr: VoidPtr = TypeManager.getMethodBindPtr("Timer", "stop", 3218959716)

    internal val setPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "set_paused", 2586408642)

    internal val isPausedPtr: VoidPtr = TypeManager.getMethodBindPtr("Timer", "is_paused", 36873697)

    internal val setIgnoreTimeScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "set_ignore_time_scale", 2586408642)

    internal val isIgnoringTimeScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "is_ignoring_time_scale", 2240911060)

    internal val isStoppedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "is_stopped", 36873697)

    internal val getTimeLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "get_time_left", 1740695150)

    internal val setTimerProcessCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "set_timer_process_callback", 3469495063)

    internal val getTimerProcessCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Timer", "get_timer_process_callback", 2672570227)
  }
}
