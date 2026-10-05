// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.VariantArray
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

/**
 * Custom logger to receive messages from the internal error/warning stream. Loggers are registered
 * via [OS.addLogger].
 */
@GodotBaseType
public open class Logger : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(363, scriptPtr)
  }

  /**
   * Called when an error is logged. The error provides the [function], [file], and [line] that it
   * originated from, as well as either the [code] that generated the error or a [rationale].
   *
   * The type of error provided by [errorType] is described in the [ErrorType] enumeration.
   *
   * Additionally, [scriptBacktraces] provides backtraces for each of the script languages. These
   * will only contain stack frames in editor builds and debug builds by default. To enable them for
   * release builds as well, you need to enable
   * [ProjectSettings.debug/settings/gdscript/alwaysTrackCallStacks].
   *
   * **Warning:** This method will be called from threads other than the main thread, possibly at
   * the same time, so you will need to have some kind of thread-safety in your implementation of it,
   * like a [Mutex].
   *
   * **Note:** [scriptBacktraces] will not contain any captured variables, due to its prohibitively
   * high cost. To get those, you will need to capture the backtraces yourself, from within the
   * [Logger] virtual methods, using [Engine.captureScriptBacktraces].
   *
   * **Note:** Logging errors from this method using functions like [@GlobalScope.pushError] or
   * [@GlobalScope.pushWarning] is not supported, as it could cause infinite recursion. These errors
   * will only show up in the console output.
   */
  public open fun _logError(
    function: String,
    `file`: String,
    line: Int,
    code: String,
    rationale: String,
    editorNotify: Boolean,
    errorType: Int,
    scriptBacktraces: VariantArray<ScriptBacktrace>,
  ): Unit {
    throw NotImplementedError("Logger::_logError is not implemented.")
  }

  /**
   * Called when a message is logged. If [error] is `true`, then this message was meant to be sent
   * to `stderr`.
   *
   * **Warning:** This method will be called from threads other than the main thread, possibly at
   * the same time, so you will need to have some kind of thread-safety in your implementation of it,
   * like a [Mutex].
   *
   * **Note:** Logging another message from this method using functions like [@GlobalScope.print] is
   * not supported, as it could cause infinite recursion. These messages will only show up in the
   * console output.
   */
  public open fun _logMessage(message: String, error: Boolean): Unit {
    throw NotImplementedError("Logger::_logMessage is not implemented.")
  }

  public enum class ErrorType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The message received is an error.
     */
    ERROR(0),
    /**
     * The message received is a warning.
     */
    WARNING(1),
    /**
     * The message received is a script error.
     */
    SCRIPT(2),
    /**
     * The message received is a shader error.
     */
    SHADER(3),
    ;

    public companion object {
      public fun from(`value`: Long): ErrorType = entries.single { it.`value` == `value` }
    }
  }

  public companion object

  public object MethodBindings
}
