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
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_STRING_NAME
import godot.writeMethodArguments_OBJECT_BOOL_BOOL
import godot.writeMethodArguments_STRING_ARRAY
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_ARRAY
import godot.writeMethodArguments_STRING_NAME_BOOL_ARRAY
import godot.writeMethodArguments_STRING_NAME_CALLABLE
import godot.writeMethodArguments_STRING_NAME_OBJECT
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * [EngineDebugger] handles the communication between the editor and the running game. It is active
 * in the running game. Messages can be sent/received through it. It also manages the profilers.
 */
@GodotBaseType
public object EngineDebugger : Object() {
  @JvmField
  public val isActiveName: MethodStringName0<EngineDebugger, Boolean> =
      MethodStringName0<EngineDebugger, Boolean>("is_active")

  @JvmField
  public val registerProfilerName:
      MethodStringName2<EngineDebugger, Unit, StringName, EngineProfiler?> =
      MethodStringName2<EngineDebugger, Unit, StringName, EngineProfiler?>("register_profiler")

  @JvmField
  public val unregisterProfilerName: MethodStringName1<EngineDebugger, Unit, StringName> =
      MethodStringName1<EngineDebugger, Unit, StringName>("unregister_profiler")

  @JvmField
  public val isProfilingName: MethodStringName1<EngineDebugger, Boolean, StringName> =
      MethodStringName1<EngineDebugger, Boolean, StringName>("is_profiling")

  @JvmField
  public val hasProfilerName: MethodStringName1<EngineDebugger, Boolean, StringName> =
      MethodStringName1<EngineDebugger, Boolean, StringName>("has_profiler")

  @JvmField
  public val profilerAddFrameDataName:
      MethodStringName2<EngineDebugger, Unit, StringName, VariantArray<Any?>> =
      MethodStringName2<EngineDebugger, Unit, StringName, VariantArray<Any?>>("profiler_add_frame_data")

  @JvmField
  public val profilerEnableName:
      MethodStringName3<EngineDebugger, Unit, StringName, Boolean, VariantArray<Any?>> =
      MethodStringName3<EngineDebugger, Unit, StringName, Boolean, VariantArray<Any?>>("profiler_enable")

  @JvmField
  public val registerMessageCaptureName:
      MethodStringName2<EngineDebugger, Unit, StringName, Callable> =
      MethodStringName2<EngineDebugger, Unit, StringName, Callable>("register_message_capture")

  @JvmField
  public val unregisterMessageCaptureName: MethodStringName1<EngineDebugger, Unit, StringName> =
      MethodStringName1<EngineDebugger, Unit, StringName>("unregister_message_capture")

  @JvmField
  public val hasCaptureName: MethodStringName1<EngineDebugger, Boolean, StringName> =
      MethodStringName1<EngineDebugger, Boolean, StringName>("has_capture")

  @JvmField
  public val linePollName: MethodStringName0<EngineDebugger, Unit> =
      MethodStringName0<EngineDebugger, Unit>("line_poll")

  @JvmField
  public val sendMessageName: MethodStringName2<EngineDebugger, Unit, String, VariantArray<Any?>> =
      MethodStringName2<EngineDebugger, Unit, String, VariantArray<Any?>>("send_message")

  @JvmField
  public val debugName: MethodStringName2<EngineDebugger, Unit, Boolean, Boolean> =
      MethodStringName2<EngineDebugger, Unit, Boolean, Boolean>("debug")

  @JvmField
  public val scriptDebugName:
      MethodStringName3<EngineDebugger, Unit, ScriptLanguage?, Boolean, Boolean> =
      MethodStringName3<EngineDebugger, Unit, ScriptLanguage?, Boolean, Boolean>("script_debug")

  @JvmField
  public val setLinesLeftName: MethodStringName1<EngineDebugger, Unit, Int> =
      MethodStringName1<EngineDebugger, Unit, Int>("set_lines_left")

  @JvmField
  public val getLinesLeftName: MethodStringName0<EngineDebugger, Int> =
      MethodStringName0<EngineDebugger, Int>("get_lines_left")

  @JvmField
  public val setDepthName: MethodStringName1<EngineDebugger, Unit, Int> =
      MethodStringName1<EngineDebugger, Unit, Int>("set_depth")

  @JvmField
  public val getDepthName: MethodStringName0<EngineDebugger, Int> =
      MethodStringName0<EngineDebugger, Int>("get_depth")

  @JvmField
  public val isBreakpointName: MethodStringName2<EngineDebugger, Boolean, Int, StringName> =
      MethodStringName2<EngineDebugger, Boolean, Int, StringName>("is_breakpoint")

  @JvmField
  public val isSkippingBreakpointsName: MethodStringName0<EngineDebugger, Boolean> =
      MethodStringName0<EngineDebugger, Boolean>("is_skipping_breakpoints")

  @JvmField
  public val insertBreakpointName: MethodStringName2<EngineDebugger, Unit, Int, StringName> =
      MethodStringName2<EngineDebugger, Unit, Int, StringName>("insert_breakpoint")

  @JvmField
  public val removeBreakpointName: MethodStringName2<EngineDebugger, Unit, Int, StringName> =
      MethodStringName2<EngineDebugger, Unit, Int, StringName>("remove_breakpoint")

  @JvmField
  public val clearBreakpointsName: MethodStringName0<EngineDebugger, Unit> =
      MethodStringName0<EngineDebugger, Unit>("clear_breakpoints")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(6)
  }

  /**
   * Returns `true` if the debugger is active otherwise `false`.
   */
  @JvmStatic
  public final fun isActive(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isActivePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Registers a profiler with the given [name]. See [EngineProfiler] for more information.
   */
  @JvmStatic
  public final fun registerProfiler(name: StringName, profiler: EngineProfiler?): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_OBJECT(ptr, objectID.id, name, profiler)
    TransferContext.callPtrMethod(MethodBindings.registerProfilerPtr, 0)
  }

  /**
   * Unregisters a profiler with given [name].
   */
  @JvmStatic
  public final fun unregisterProfiler(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.unregisterProfilerPtr, 0)
  }

  /**
   * Returns `true` if a profiler with the given name is present and active otherwise `false`.
   */
  @JvmStatic
  public final fun isProfiling(name: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.isProfilingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if a profiler with the given name is present otherwise `false`.
   */
  @JvmStatic
  public final fun hasProfiler(name: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.hasProfilerPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Calls the `add` callable of the profiler with given [name] and [data].
   */
  @JvmStatic
  public final fun profilerAddFrameData(name: StringName, `data`: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_ARRAY(ptr, objectID.id, name, data)
    TransferContext.callPtrMethod(MethodBindings.profilerAddFrameDataPtr, 0)
  }

  /**
   * Calls the `toggle` callable of the profiler with given [name] and [arguments]. Enables/Disables
   * the same profiler depending on [enable] argument.
   */
  @JvmOverloads
  @JvmStatic
  public final fun profilerEnable(
    name: StringName,
    enable: Boolean,
    arguments: VariantArray<Any?> = godot.core.variantArrayOf(),
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL_ARRAY(ptr, objectID.id, name, enable, arguments)
    TransferContext.callPtrMethod(MethodBindings.profilerEnablePtr, 0)
  }

  /**
   * Registers a message capture with given [name]. If [name] is "my_message" then messages starting
   * with "my_message:" will be called with the given callable.
   *
   * The callable must accept a message string and a data array as argument. The callable should
   * return `true` if the message is recognized.
   *
   * **Note:** The callable will receive the message with the prefix stripped, unlike
   * [EditorDebuggerPlugin.Capture]. See the [EditorDebuggerPlugin] description for an example.
   */
  @JvmStatic
  public final fun registerMessageCapture(name: StringName, callable: Callable): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_CALLABLE(ptr, objectID.id, name, callable)
    TransferContext.callMethod(MethodBindings.registerMessageCapturePtr)
  }

  /**
   * Unregisters the message capture with given [name].
   */
  @JvmStatic
  public final fun unregisterMessageCapture(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.unregisterMessageCapturePtr, 0)
  }

  /**
   * Returns `true` if a capture with the given name is present otherwise `false`.
   */
  @JvmStatic
  public final fun hasCapture(name: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.hasCapturePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Forces a processing loop of debugger events. The purpose of this method is just processing
   * events every now and then when the script might get too busy, so that bugs like infinite loops can
   * be caught.
   */
  @JvmStatic
  public final fun linePoll(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.linePollPtr, 0)
  }

  /**
   * Sends a message with given [message] and [data] array.
   */
  @JvmStatic
  public final fun sendMessage(message: String, `data`: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments_STRING_ARRAY(ptr, objectID.id, message, data)
    TransferContext.callMethod(MethodBindings.sendMessagePtr)
  }

  /**
   * Starts a debug break in script execution, optionally specifying whether the program can
   * continue based on [canContinue] and whether the break was due to a breakpoint.
   */
  @JvmOverloads
  @JvmStatic
  public final fun debug(canContinue: Boolean = true, isErrorBreakpoint: Boolean = false): Unit {
    TransferContext.writeMethodArguments_BOOL_BOOL(ptr, objectID.id, canContinue, isErrorBreakpoint)
    TransferContext.callPtrMethod(MethodBindings.debugPtr, 0)
  }

  /**
   * Starts a debug break in script execution, optionally specifying whether the program can
   * continue based on [canContinue] and whether the break was due to a breakpoint.
   */
  @JvmOverloads
  @JvmStatic
  public final fun scriptDebug(
    language: ScriptLanguage?,
    canContinue: Boolean = true,
    isErrorBreakpoint: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_OBJECT_BOOL_BOOL(ptr, objectID.id, language, canContinue, isErrorBreakpoint)
    TransferContext.callPtrMethod(MethodBindings.scriptDebugPtr, 0)
  }

  /**
   * Sets the current debugging lines that remain.
   */
  @JvmStatic
  public final fun setLinesLeft(lines: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, lines.toLong())
    TransferContext.callPtrMethod(MethodBindings.setLinesLeftPtr, 0)
  }

  /**
   * Returns the number of lines that remain.
   */
  @JvmStatic
  public final fun getLinesLeft(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLinesLeftPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the current debugging depth.
   */
  @JvmStatic
  public final fun setDepth(depth: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, depth.toLong())
    TransferContext.callPtrMethod(MethodBindings.setDepthPtr, 0)
  }

  /**
   * Returns the current debug depth.
   */
  @JvmStatic
  public final fun getDepth(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDepthPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the given [source] and [line] represent an existing breakpoint.
   */
  @JvmStatic
  public final fun isBreakpoint(line: Int, source: StringName): Boolean {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, line.toLong(), source)
    TransferContext.callPtrMethod(MethodBindings.isBreakpointPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the debugger is skipping breakpoints otherwise `false`.
   */
  @JvmStatic
  public final fun isSkippingBreakpoints(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isSkippingBreakpointsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Inserts a new breakpoint with the given [source] and [line].
   */
  @JvmStatic
  public final fun insertBreakpoint(line: Int, source: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, line.toLong(), source)
    TransferContext.callPtrMethod(MethodBindings.insertBreakpointPtr, 0)
  }

  /**
   * Removes a breakpoint with the given [source] and [line].
   */
  @JvmStatic
  public final fun removeBreakpoint(line: Int, source: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, line.toLong(), source)
    TransferContext.callPtrMethod(MethodBindings.removeBreakpointPtr, 0)
  }

  /**
   * Clears all breakpoints.
   */
  @JvmStatic
  public final fun clearBreakpoints(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearBreakpointsPtr, 0)
  }

  /**
   * Registers a profiler with the given [name]. See [EngineProfiler] for more information.
   */
  @JvmStatic
  public final fun registerProfiler(name: String, profiler: EngineProfiler?) =
      registerProfiler(name.asCachedStringName(), profiler)

  /**
   * Unregisters a profiler with given [name].
   */
  @JvmStatic
  public final fun unregisterProfiler(name: String) = unregisterProfiler(name.asCachedStringName())

  /**
   * Returns `true` if a profiler with the given name is present and active otherwise `false`.
   */
  @JvmStatic
  public final fun isProfiling(name: String): Boolean = isProfiling(name.asCachedStringName())

  /**
   * Returns `true` if a profiler with the given name is present otherwise `false`.
   */
  @JvmStatic
  public final fun hasProfiler(name: String): Boolean = hasProfiler(name.asCachedStringName())

  /**
   * Calls the `add` callable of the profiler with given [name] and [data].
   */
  @JvmStatic
  public final fun profilerAddFrameData(name: String, `data`: VariantArray<Any?>) =
      profilerAddFrameData(name.asCachedStringName(), data)

  /**
   * Calls the `toggle` callable of the profiler with given [name] and [arguments]. Enables/Disables
   * the same profiler depending on [enable] argument.
   */
  @JvmOverloads
  @JvmStatic
  public final fun profilerEnable(
    name: String,
    enable: Boolean,
    arguments: VariantArray<Any?> = godot.core.variantArrayOf(),
  ) = profilerEnable(name.asCachedStringName(), enable, arguments)

  /**
   * Registers a message capture with given [name]. If [name] is "my_message" then messages starting
   * with "my_message:" will be called with the given callable.
   *
   * The callable must accept a message string and a data array as argument. The callable should
   * return `true` if the message is recognized.
   *
   * **Note:** The callable will receive the message with the prefix stripped, unlike
   * [EditorDebuggerPlugin.Capture]. See the [EditorDebuggerPlugin] description for an example.
   */
  @JvmStatic
  public final fun registerMessageCapture(name: String, callable: Callable) =
      registerMessageCapture(name.asCachedStringName(), callable)

  /**
   * Unregisters the message capture with given [name].
   */
  @JvmStatic
  public final fun unregisterMessageCapture(name: String) =
      unregisterMessageCapture(name.asCachedStringName())

  /**
   * Returns `true` if a capture with the given name is present otherwise `false`.
   */
  @JvmStatic
  public final fun hasCapture(name: String): Boolean = hasCapture(name.asCachedStringName())

  /**
   * Returns `true` if the given [source] and [line] represent an existing breakpoint.
   */
  @JvmStatic
  public final fun isBreakpoint(line: Int, source: String): Boolean =
      isBreakpoint(line, source.asCachedStringName())

  /**
   * Inserts a new breakpoint with the given [source] and [line].
   */
  @JvmStatic
  public final fun insertBreakpoint(line: Int, source: String) =
      insertBreakpoint(line, source.asCachedStringName())

  /**
   * Removes a breakpoint with the given [source] and [line].
   */
  @JvmStatic
  public final fun removeBreakpoint(line: Int, source: String) =
      removeBreakpoint(line, source.asCachedStringName())

  public object MethodBindings {
    internal val isActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "is_active", 2240911060)

    internal val registerProfilerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "register_profiler", 3651669560)

    internal val unregisterProfilerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "unregister_profiler", 3304788590)

    internal val isProfilingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "is_profiling", 2041966384)

    internal val hasProfilerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "has_profiler", 2041966384)

    internal val profilerAddFrameDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "profiler_add_frame_data", 1895267858)

    internal val profilerEnablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "profiler_enable", 3192561009)

    internal val registerMessageCapturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "register_message_capture", 1874754934)

    internal val unregisterMessageCapturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "unregister_message_capture", 3304788590)

    internal val hasCapturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "has_capture", 2041966384)

    internal val linePollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "line_poll", 3218959716)

    internal val sendMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "send_message", 1209351045)

    internal val debugPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "debug", 2751962654)

    internal val scriptDebugPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "script_debug", 2442343672)

    internal val setLinesLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "set_lines_left", 1286410249)

    internal val getLinesLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "get_lines_left", 3905245786)

    internal val setDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "set_depth", 1286410249)

    internal val getDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "get_depth", 3905245786)

    internal val isBreakpointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "is_breakpoint", 921227809)

    internal val isSkippingBreakpointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "is_skipping_breakpoints", 36873697)

    internal val insertBreakpointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "insert_breakpoint", 3780747571)

    internal val removeBreakpointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "remove_breakpoint", 3780747571)

    internal val clearBreakpointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EngineDebugger", "clear_breakpoints", 3218959716)
  }
}
