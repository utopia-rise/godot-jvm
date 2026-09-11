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
import godot.core.Dictionary
import godot.core.Error
import godot.core.GodotEnum
import godot.core.Key
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName7
import godot.core.PackedByteArray
import godot.core.PackedStringArray
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * The [OS] class wraps the most common functionalities for communicating with the host operating
 * system, such as the video driver, delays, environment variables, execution of binaries, command
 * line, etc.
 *
 * **Note:** In Godot 4, [OS] functions related to window management, clipboard, and TTS were moved
 * to the [DisplayServer] singleton (and the [Window] class). Functions related to time were removed
 * and are only available in the [Time] class.
 */
@GodotBaseType
public object OS : Object() {
  @JvmField
  public val getEntropyName: MethodStringName1<OS, PackedByteArray, Int> =
      MethodStringName1<OS, PackedByteArray, Int>("get_entropy")

  @JvmField
  public val getSystemCaCertificatesName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_system_ca_certificates")

  @JvmField
  public val getConnectedMidiInputsName: MethodStringName0<OS, PackedStringArray> =
      MethodStringName0<OS, PackedStringArray>("get_connected_midi_inputs")

  @JvmField
  public val openMidiInputsName: MethodStringName0<OS, Unit> =
      MethodStringName0<OS, Unit>("open_midi_inputs")

  @JvmField
  public val closeMidiInputsName: MethodStringName0<OS, Unit> =
      MethodStringName0<OS, Unit>("close_midi_inputs")

  @JvmField
  public val alertName: MethodStringName2<OS, Unit, String, String> =
      MethodStringName2<OS, Unit, String, String>("alert")

  @JvmField
  public val crashName: MethodStringName1<OS, Unit, String> =
      MethodStringName1<OS, Unit, String>("crash")

  @JvmField
  public val setLowProcessorUsageModeName: MethodStringName1<OS, Unit, Boolean> =
      MethodStringName1<OS, Unit, Boolean>("set_low_processor_usage_mode")

  @JvmField
  public val isInLowProcessorUsageModeName: MethodStringName0<OS, Boolean> =
      MethodStringName0<OS, Boolean>("is_in_low_processor_usage_mode")

  @JvmField
  public val setLowProcessorUsageModeSleepUsecName: MethodStringName1<OS, Unit, Int> =
      MethodStringName1<OS, Unit, Int>("set_low_processor_usage_mode_sleep_usec")

  @JvmField
  public val getLowProcessorUsageModeSleepUsecName: MethodStringName0<OS, Int> =
      MethodStringName0<OS, Int>("get_low_processor_usage_mode_sleep_usec")

  @JvmField
  public val setDeltaSmoothingName: MethodStringName1<OS, Unit, Boolean> =
      MethodStringName1<OS, Unit, Boolean>("set_delta_smoothing")

  @JvmField
  public val isDeltaSmoothingEnabledName: MethodStringName0<OS, Boolean> =
      MethodStringName0<OS, Boolean>("is_delta_smoothing_enabled")

  @JvmField
  public val getProcessorCountName: MethodStringName0<OS, Int> =
      MethodStringName0<OS, Int>("get_processor_count")

  @JvmField
  public val getProcessorNameName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_processor_name")

  @JvmField
  public val getSystemFontsName: MethodStringName0<OS, PackedStringArray> =
      MethodStringName0<OS, PackedStringArray>("get_system_fonts")

  @JvmField
  public val getSystemFontPathName: MethodStringName4<OS, String, String, Int, Int, Boolean> =
      MethodStringName4<OS, String, String, Int, Int, Boolean>("get_system_font_path")

  @JvmField
  public val getSystemFontPathForTextName:
      MethodStringName7<OS, PackedStringArray, String, String, String, String, Int, Int, Boolean> =
      MethodStringName7<OS, PackedStringArray, String, String, String, String, Int, Int, Boolean>("get_system_font_path_for_text")

  @JvmField
  public val getExecutablePathName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_executable_path")

  @JvmField
  public val readStringFromStdinName: MethodStringName1<OS, String, Long> =
      MethodStringName1<OS, String, Long>("read_string_from_stdin")

  @JvmField
  public val readBufferFromStdinName: MethodStringName1<OS, PackedByteArray, Long> =
      MethodStringName1<OS, PackedByteArray, Long>("read_buffer_from_stdin")

  @JvmField
  public val getStdinTypeName: MethodStringName0<OS, StdHandleType> =
      MethodStringName0<OS, StdHandleType>("get_stdin_type")

  @JvmField
  public val getStdoutTypeName: MethodStringName0<OS, StdHandleType> =
      MethodStringName0<OS, StdHandleType>("get_stdout_type")

  @JvmField
  public val getStderrTypeName: MethodStringName0<OS, StdHandleType> =
      MethodStringName0<OS, StdHandleType>("get_stderr_type")

  @JvmField
  public val executeName:
      MethodStringName5<OS, Int, String, PackedStringArray, VariantArray<Any?>, Boolean, Boolean> =
      MethodStringName5<OS, Int, String, PackedStringArray, VariantArray<Any?>, Boolean, Boolean>("execute")

  @JvmField
  public val executeWithPipeName:
      MethodStringName3<OS, Dictionary<Any?, Any?>, String, PackedStringArray, Boolean> =
      MethodStringName3<OS, Dictionary<Any?, Any?>, String, PackedStringArray, Boolean>("execute_with_pipe")

  @JvmField
  public val createProcessName: MethodStringName3<OS, Int, String, PackedStringArray, Boolean> =
      MethodStringName3<OS, Int, String, PackedStringArray, Boolean>("create_process")

  @JvmField
  public val createInstanceName: MethodStringName1<OS, Int, PackedStringArray> =
      MethodStringName1<OS, Int, PackedStringArray>("create_instance")

  @JvmField
  public val openWithProgramName: MethodStringName2<OS, Error, String, PackedStringArray> =
      MethodStringName2<OS, Error, String, PackedStringArray>("open_with_program")

  @JvmField
  public val killName: MethodStringName1<OS, Error, Int> = MethodStringName1<OS, Error, Int>("kill")

  @JvmField
  public val shellOpenName: MethodStringName1<OS, Error, String> =
      MethodStringName1<OS, Error, String>("shell_open")

  @JvmField
  public val shellShowInFileManagerName: MethodStringName2<OS, Error, String, Boolean> =
      MethodStringName2<OS, Error, String, Boolean>("shell_show_in_file_manager")

  @JvmField
  public val isProcessRunningName: MethodStringName1<OS, Boolean, Int> =
      MethodStringName1<OS, Boolean, Int>("is_process_running")

  @JvmField
  public val getProcessExitCodeName: MethodStringName1<OS, Int, Int> =
      MethodStringName1<OS, Int, Int>("get_process_exit_code")

  @JvmField
  public val getProcessIdName: MethodStringName0<OS, Int> =
      MethodStringName0<OS, Int>("get_process_id")

  @JvmField
  public val hasEnvironmentName: MethodStringName1<OS, Boolean, String> =
      MethodStringName1<OS, Boolean, String>("has_environment")

  @JvmField
  public val getEnvironmentName: MethodStringName1<OS, String, String> =
      MethodStringName1<OS, String, String>("get_environment")

  @JvmField
  public val setEnvironmentName: MethodStringName2<OS, Unit, String, String> =
      MethodStringName2<OS, Unit, String, String>("set_environment")

  @JvmField
  public val unsetEnvironmentName: MethodStringName1<OS, Unit, String> =
      MethodStringName1<OS, Unit, String>("unset_environment")

  @JvmField
  public val getNameName: MethodStringName0<OS, String> = MethodStringName0<OS, String>("get_name")

  @JvmField
  public val getDistributionNameName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_distribution_name")

  @JvmField
  public val getVersionName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_version")

  @JvmField
  public val getVersionAliasName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_version_alias")

  @JvmField
  public val getCmdlineArgsName: MethodStringName0<OS, PackedStringArray> =
      MethodStringName0<OS, PackedStringArray>("get_cmdline_args")

  @JvmField
  public val getCmdlineUserArgsName: MethodStringName0<OS, PackedStringArray> =
      MethodStringName0<OS, PackedStringArray>("get_cmdline_user_args")

  @JvmField
  public val getVideoAdapterDriverInfoName: MethodStringName0<OS, PackedStringArray> =
      MethodStringName0<OS, PackedStringArray>("get_video_adapter_driver_info")

  @JvmField
  public val setRestartOnExitName: MethodStringName2<OS, Unit, Boolean, PackedStringArray> =
      MethodStringName2<OS, Unit, Boolean, PackedStringArray>("set_restart_on_exit")

  @JvmField
  public val isRestartOnExitSetName: MethodStringName0<OS, Boolean> =
      MethodStringName0<OS, Boolean>("is_restart_on_exit_set")

  @JvmField
  public val getRestartOnExitArgumentsName: MethodStringName0<OS, PackedStringArray> =
      MethodStringName0<OS, PackedStringArray>("get_restart_on_exit_arguments")

  @JvmField
  public val delayUsecName: MethodStringName1<OS, Unit, Int> =
      MethodStringName1<OS, Unit, Int>("delay_usec")

  @JvmField
  public val delayMsecName: MethodStringName1<OS, Unit, Int> =
      MethodStringName1<OS, Unit, Int>("delay_msec")

  @JvmField
  public val getLocaleName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_locale")

  @JvmField
  public val getLocaleLanguageName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_locale_language")

  @JvmField
  public val getModelNameName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_model_name")

  @JvmField
  public val isUserfsPersistentName: MethodStringName0<OS, Boolean> =
      MethodStringName0<OS, Boolean>("is_userfs_persistent")

  @JvmField
  public val isStdoutVerboseName: MethodStringName0<OS, Boolean> =
      MethodStringName0<OS, Boolean>("is_stdout_verbose")

  @JvmField
  public val isDebugBuildName: MethodStringName0<OS, Boolean> =
      MethodStringName0<OS, Boolean>("is_debug_build")

  @JvmField
  public val getStaticMemoryUsageName: MethodStringName0<OS, Long> =
      MethodStringName0<OS, Long>("get_static_memory_usage")

  @JvmField
  public val getStaticMemoryPeakUsageName: MethodStringName0<OS, Long> =
      MethodStringName0<OS, Long>("get_static_memory_peak_usage")

  @JvmField
  public val getMemoryInfoName: MethodStringName0<OS, Dictionary<Any?, Any?>> =
      MethodStringName0<OS, Dictionary<Any?, Any?>>("get_memory_info")

  @JvmField
  public val moveToTrashName: MethodStringName1<OS, Error, String> =
      MethodStringName1<OS, Error, String>("move_to_trash")

  @JvmField
  public val getUserDataDirName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_user_data_dir")

  @JvmField
  public val getSystemDirName: MethodStringName2<OS, String, SystemDir, Boolean> =
      MethodStringName2<OS, String, SystemDir, Boolean>("get_system_dir")

  @JvmField
  public val getConfigDirName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_config_dir")

  @JvmField
  public val getDataDirName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_data_dir")

  @JvmField
  public val getCacheDirName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_cache_dir")

  @JvmField
  public val getTempDirName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_temp_dir")

  @JvmField
  public val getUniqueIdName: MethodStringName0<OS, String> =
      MethodStringName0<OS, String>("get_unique_id")

  @JvmField
  public val getKeycodeStringName: MethodStringName1<OS, String, Key> =
      MethodStringName1<OS, String, Key>("get_keycode_string")

  @JvmField
  public val isKeycodeUnicodeName: MethodStringName1<OS, Boolean, Long> =
      MethodStringName1<OS, Boolean, Long>("is_keycode_unicode")

  @JvmField
  public val findKeycodeFromStringName: MethodStringName1<OS, Key, String> =
      MethodStringName1<OS, Key, String>("find_keycode_from_string")

  @JvmField
  public val setUseFileAccessSaveAndSwapName: MethodStringName1<OS, Unit, Boolean> =
      MethodStringName1<OS, Unit, Boolean>("set_use_file_access_save_and_swap")

  @JvmField
  public val setThreadNameName: MethodStringName1<OS, Error, String> =
      MethodStringName1<OS, Error, String>("set_thread_name")

  @JvmField
  public val getThreadCallerIdName: MethodStringName0<OS, Long> =
      MethodStringName0<OS, Long>("get_thread_caller_id")

  @JvmField
  public val getMainThreadIdName: MethodStringName0<OS, Long> =
      MethodStringName0<OS, Long>("get_main_thread_id")

  @JvmField
  public val hasFeatureName: MethodStringName1<OS, Boolean, String> =
      MethodStringName1<OS, Boolean, String>("has_feature")

  @JvmField
  public val isSandboxedName: MethodStringName0<OS, Boolean> =
      MethodStringName0<OS, Boolean>("is_sandboxed")

  @JvmField
  public val requestPermissionName: MethodStringName1<OS, Boolean, String> =
      MethodStringName1<OS, Boolean, String>("request_permission")

  @JvmField
  public val requestPermissionsName: MethodStringName0<OS, Boolean> =
      MethodStringName0<OS, Boolean>("request_permissions")

  @JvmField
  public val getGrantedPermissionsName: MethodStringName0<OS, PackedStringArray> =
      MethodStringName0<OS, PackedStringArray>("get_granted_permissions")

  @JvmField
  public val revokeGrantedPermissionsName: MethodStringName0<OS, Unit> =
      MethodStringName0<OS, Unit>("revoke_granted_permissions")

  @JvmField
  public val addLoggerName: MethodStringName1<OS, Unit, Logger> =
      MethodStringName1<OS, Unit, Logger>("add_logger")

  @JvmField
  public val removeLoggerName: MethodStringName1<OS, Unit, Logger> =
      MethodStringName1<OS, Unit, Logger>("remove_logger")

  /**
   * If `true`, the engine optimizes for low processor usage by only refreshing the screen if
   * needed. Can improve battery consumption on mobile.
   *
   * **Note:** On start-up, this is the same as [ProjectSettings.application/run/lowProcessorMode].
   */
  @JvmStatic
  public final inline var lowProcessorUsageMode: Boolean
    @JvmName("lowProcessorUsageModeProperty")
    get() = isInLowProcessorUsageMode()
    @JvmName("lowProcessorUsageModeProperty")
    set(`value`) {
      setLowProcessorUsageMode(value)
    }

  /**
   * The amount of sleeping between frames when the low-processor usage mode is enabled, in
   * microseconds. Higher values will result in lower CPU usage. See also [lowProcessorUsageMode].
   *
   * **Note:** On start-up, this is the same as
   * [ProjectSettings.application/run/lowProcessorModeSleepUsec].
   */
  @JvmStatic
  public final inline var lowProcessorUsageModeSleepUsec: Int
    @JvmName("lowProcessorUsageModeSleepUsecProperty")
    get() = getLowProcessorUsageModeSleepUsec()
    @JvmName("lowProcessorUsageModeSleepUsecProperty")
    set(`value`) {
      setLowProcessorUsageModeSleepUsec(value)
    }

  /**
   * If `true`, the engine filters the time delta measured between each frame, and attempts to
   * compensate for random variation. This only works on systems where V-Sync is active.
   *
   * **Note:** On start-up, this is the same as [ProjectSettings.application/run/deltaSmoothing].
   */
  @JvmStatic
  public final inline var deltaSmoothing: Boolean
    @JvmName("deltaSmoothingProperty")
    get() = isDeltaSmoothingEnabled()
    @JvmName("deltaSmoothingProperty")
    set(`value`) {
      setDeltaSmoothing(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(22)
  }

  /**
   * Generates a [PackedByteArray] of cryptographically secure random bytes with given [size].
   *
   * **Note:** Generating large quantities of bytes using this method can result in locking and
   * entropy of lower quality on most platforms. Using [Crypto.generateRandomBytes] is preferred in
   * most cases.
   */
  @JvmStatic
  public final fun getEntropy(size: Int): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.getEntropyPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Returns the list of certification authorities trusted by the operating system as a string of
   * concatenated certificates in PEM format.
   */
  @JvmStatic
  public final fun getSystemCaCertificates(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSystemCaCertificatesPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns an array of connected MIDI device names, if they exist. Returns an empty array if the
   * system MIDI driver has not previously been initialized with [openMidiInputs]. See also
   * [closeMidiInputs].
   *
   * **Note:** This method is implemented on Linux, macOS, Windows, and Web.
   *
   * **Note:** On the Web platform, Web MIDI needs to be supported by the browser.
   * [url=https://caniuse.com/midi]For the time being[/url], it is currently supported by all major
   * browsers, except Safari.
   *
   * **Note:** On the Web platform, using MIDI input requires a browser permission to be granted
   * first. This permission request is performed when calling [openMidiInputs]. The browser will
   * refrain from processing MIDI input until the user accepts the permission request.
   */
  @JvmStatic
  public final fun getConnectedMidiInputs(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectedMidiInputsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Initializes the singleton for the system MIDI driver, allowing Godot to receive
   * [InputEventMIDI]. See also [getConnectedMidiInputs] and [closeMidiInputs].
   *
   * **Note:** This method is implemented on Linux, macOS, Windows, and Web.
   *
   * **Note:** On the Web platform, Web MIDI needs to be supported by the browser.
   * [url=https://caniuse.com/midi]For the time being[/url], it is currently supported by all major
   * browsers, except Safari.
   *
   * **Note:** On the Web platform, using MIDI input requires a browser permission to be granted
   * first. This permission request is performed when calling [openMidiInputs]. The browser will
   * refrain from processing MIDI input until the user accepts the permission request.
   */
  @JvmStatic
  public final fun openMidiInputs(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.openMidiInputsPtr)
  }

  /**
   * Shuts down the system MIDI driver. Godot will no longer receive [InputEventMIDI]. See also
   * [openMidiInputs] and [getConnectedMidiInputs].
   *
   * **Note:** This method is implemented on Linux, macOS, Windows, and Web.
   */
  @JvmStatic
  public final fun closeMidiInputs(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.closeMidiInputsPtr)
  }

  /**
   * Displays a modal dialog box using the host platform's implementation. The engine execution is
   * blocked until the dialog is closed.
   */
  @JvmOverloads
  @JvmStatic
  public final fun alert(text: String, title: String = "Alert!"): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text, STRING to title)
    TransferContext.callMethod(MethodBindings.alertPtr)
  }

  /**
   * Crashes the engine (or the editor if called within a `@tool` script). See also [kill].
   *
   * **Note:** This method should *only* be used for testing the system's crash handler, not for any
   * other purpose. For general error reporting, use (in order of preference) [@GDScript.assert],
   * [@GlobalScope.pushError], or [alert].
   */
  @JvmStatic
  public final fun crash(message: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to message)
    TransferContext.callMethod(MethodBindings.crashPtr)
  }

  @JvmStatic
  public final fun setLowProcessorUsageMode(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setLowProcessorUsageModePtr)
  }

  @JvmStatic
  public final fun isInLowProcessorUsageMode(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isInLowProcessorUsageModePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  @JvmStatic
  public final fun setLowProcessorUsageModeSleepUsec(usec: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to usec.toLong())
    TransferContext.callMethod(MethodBindings.setLowProcessorUsageModeSleepUsecPtr)
  }

  @JvmStatic
  public final fun getLowProcessorUsageModeSleepUsec(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLowProcessorUsageModeSleepUsecPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  @JvmStatic
  public final fun setDeltaSmoothing(deltaSmoothingEnabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to deltaSmoothingEnabled)
    TransferContext.callMethod(MethodBindings.setDeltaSmoothingPtr)
  }

  @JvmStatic
  public final fun isDeltaSmoothingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDeltaSmoothingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the number of *logical* CPU cores available on the host machine. On CPUs with
   * HyperThreading enabled, this number will be greater than the number of *physical* CPU cores.
   */
  @JvmStatic
  public final fun getProcessorCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProcessorCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the full name of the CPU model on the host machine (e.g. `"Intel(R) Core(TM) i7-6700K
   * CPU @ 4.00GHz"`).
   *
   * **Note:** This method is only implemented on Windows, macOS, Linux and iOS. On Android and Web,
   * [getProcessorName] returns an empty string.
   */
  @JvmStatic
  public final fun getProcessorName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProcessorNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the list of font family names available.
   *
   * **Note:** This method is implemented on Android, iOS, Linux, macOS and Windows.
   */
  @JvmStatic
  public final fun getSystemFonts(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSystemFontsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns the path to the system font file with [fontName] and style. Returns an empty string if
   * no matching fonts found.
   *
   * The following aliases can be used to request default fonts: "sans-serif", "serif", "monospace",
   * "cursive", and "fantasy".
   *
   * **Note:** Returned font might have different style if the requested style is not available.
   *
   * **Note:** This method is implemented on Android, iOS, Linux, macOS and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun getSystemFontPath(
    fontName: String,
    weight: Int = 400,
    stretch: Int = 100,
    italic: Boolean = false,
  ): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to fontName, LONG to weight.toLong(), LONG to stretch.toLong(), BOOL to italic)
    TransferContext.callMethod(MethodBindings.getSystemFontPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns an array of the system substitute font file paths, which are similar to the font with
   * [fontName] and style for the specified text, locale, and script. Returns an empty array if no
   * matching fonts found.
   *
   * The following aliases can be used to request default fonts: "sans-serif", "serif", "monospace",
   * "cursive", and "fantasy".
   *
   * **Note:** Depending on OS, it's not guaranteed that any of the returned fonts will be suitable
   * for rendering specified text. Fonts should be loaded and checked in the order they are returned,
   * and the first suitable one used.
   *
   * **Note:** Returned fonts might have different style if the requested style is not available or
   * belong to a different font family.
   *
   * **Note:** This method is implemented on Android, iOS, Linux, macOS and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun getSystemFontPathForText(
    fontName: String,
    text: String,
    locale: String = "",
    script: String = "",
    weight: Int = 400,
    stretch: Int = 100,
    italic: Boolean = false,
  ): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to fontName, STRING to text, STRING to locale, STRING to script, LONG to weight.toLong(), LONG to stretch.toLong(), BOOL to italic)
    TransferContext.callMethod(MethodBindings.getSystemFontPathForTextPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns the file path to the current engine executable.
   *
   * **Note:** On macOS, if you want to launch another instance of Godot, always use
   * [createInstance] instead of relying on the executable path.
   */
  @JvmStatic
  public final fun getExecutablePath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExecutablePathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Reads a user input as a UTF-8 encoded string from the standard input. This operation can be
   * *blocking*, which causes the window to freeze if [readStringFromStdin] is called on the main
   * thread.
   *
   * - If standard input is console, this method will block until the program receives a line break
   * in standard input (usually by the user pressing [kbd]Enter[/kbd]).
   *
   * - If standard input is pipe, this method will block until a specific amount of data is read or
   * pipe is closed.
   *
   * - If standard input is a file, this method will read a specific amount of data (or less if
   * end-of-file is reached) and return immediately.
   *
   * **Note:** This method automatically replaces `\r\n` line breaks with `\n` and removes them from
   * the end of the string. Use [readBufferFromStdin] to read the unprocessed data.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   *
   * **Note:** On exported Windows builds, run the console wrapper executable to access the
   * terminal. If standard input is console, calling this method without console wrapped will freeze
   * permanently. If standard input is pipe or file, it can be used without console wrapper. If you
   * need a single executable with full console support, use a custom build compiled with the
   * `windows_subsystem=console` flag.
   */
  @JvmOverloads
  @JvmStatic
  public final fun readStringFromStdin(bufferSize: Long = 1024): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bufferSize)
    TransferContext.callMethod(MethodBindings.readStringFromStdinPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Reads a user input as raw data from the standard input. This operation can be *blocking*, which
   * causes the window to freeze if [readBufferFromStdin] is called on the main thread.
   *
   * - If standard input is console, this method will block until the program receives a line break
   * in standard input (usually by the user pressing [kbd]Enter[/kbd]).
   *
   * - If standard input is pipe, this method will block until a specific amount of data is read or
   * pipe is closed.
   *
   * - If standard input is a file, this method will read a specific amount of data (or less if
   * end-of-file is reached) and return immediately.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   *
   * **Note:** On exported Windows builds, run the console wrapper executable to access the
   * terminal. If standard input is console, calling this method without console wrapped will freeze
   * permanently. If standard input is pipe or file, it can be used without console wrapper. If you
   * need a single executable with full console support, use a custom build compiled with the
   * `windows_subsystem=console` flag.
   */
  @JvmOverloads
  @JvmStatic
  public final fun readBufferFromStdin(bufferSize: Long = 1024): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bufferSize)
    TransferContext.callMethod(MethodBindings.readBufferFromStdinPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Returns the type of the standard input device.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   *
   * **Note:** On exported Windows builds, run the console wrapper executable to access the standard
   * input. If you need a single executable with full console support, use a custom build compiled with
   * the `windows_subsystem=console` flag.
   */
  @JvmStatic
  public final fun getStdinType(): StdHandleType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStdinTypePtr)
    return StdHandleType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the type of the standard output device.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   */
  @JvmStatic
  public final fun getStdoutType(): StdHandleType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStdoutTypePtr)
    return StdHandleType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the type of the standard error device.
   *
   * **Note:** This method is implemented on Linux, macOS, and Windows.
   */
  @JvmStatic
  public final fun getStderrType(): StdHandleType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStderrTypePtr)
    return StdHandleType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Executes the given process in a *blocking* way. The file specified in [path] must exist and be
   * executable. The system path resolution will be used. The [arguments] are used in the given order,
   * separated by spaces, and wrapped in quotes.
   *
   * If an [output] array is provided, the complete shell output of the process is appended to
   * [output] as a single [String] element. If [readStderr] is `true`, the output to the standard error
   * stream is also appended to the array.
   *
   * On Windows, if [openConsole] is `true` and the process is a console app, a new terminal window
   * is opened.
   *
   * This method returns the exit code of the command, or `-1` if the process fails to execute.
   *
   * **Note:** The main thread will be blocked until the executed command terminates. Use [Thread]
   * to create a separate thread that will not block the main thread, or use [createProcess] to create
   * a completely independent process.
   *
   * For example, to retrieve a list of the working directory's contents:
   *
   * ```gdscript
   * //gdscript
   * var output = []
   * var exit_code = OS.execute("ls", ["-l", "/tmp"], output)
   * ```
   *
   * ```csharp
   * //csharp
   * Godot.Collections.Array output = [];
   * int exitCode = OS.Execute("ls", ["-l", "/tmp"], output);
   * ```
   *
   * If you wish to access a shell built-in or execute a composite command, a platform-specific
   * shell can be invoked. For example:
   *
   * ```gdscript
   * //gdscript
   * var output = []
   * OS.execute("CMD.exe", ["/C", "cd &#37;TEMP&#37; && dir"], output)
   * ```
   *
   * ```csharp
   * //csharp
   * Godot.Collections.Array output = [];
   * OS.Execute("CMD.exe", ["/C", "cd &#37;TEMP&#37; && dir"], output);
   * ```
   *
   * **Note:** This method is implemented on Android, Linux, macOS, and Windows.
   *
   * **Note:** To execute a Windows command interpreter built-in command, specify `cmd.exe` in
   * [path], `/c` as the first argument, and the desired command as the second argument.
   *
   * **Note:** To execute a PowerShell built-in command, specify `powershell.exe` in [path],
   * `-Command` as the first argument, and the desired command as the second argument.
   *
   * **Note:** To execute a Unix shell built-in command, specify shell executable name in [path],
   * `-c` as the first argument, and the desired command as the second argument.
   *
   * **Note:** On macOS, sandboxed applications are limited to run only embedded helper executables,
   * specified during export.
   *
   * **Note:** On Android, system commands such as `dumpsys` can only be run on a rooted device.
   */
  @JvmOverloads
  @JvmStatic
  public final fun execute(
    path: String,
    arguments: PackedStringArray,
    output: VariantArray<Any?> = godot.core.variantArrayOf(),
    readStderr: Boolean = false,
    openConsole: Boolean = false,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path, PACKED_STRING_ARRAY to arguments, ARRAY to output, BOOL to readStderr, BOOL to openConsole)
    TransferContext.callMethod(MethodBindings.executePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Creates a new process that runs independently of Godot with redirected IO. It will not
   * terminate when Godot terminates. The path specified in [path] must exist and be an executable file
   * or macOS `.app` bundle. The path is resolved based on the current platform. The [arguments] are
   * used in the given order and separated by a space.
   *
   * If [blocking] is `false`, created pipes work in non-blocking mode, i.e. read and write
   * operations will return immediately. Use [FileAccess.getError] to check if the last read/write
   * operation was successful.
   *
   * If the process cannot be created, this method returns an empty [Dictionary]. Otherwise, this
   * method returns a [Dictionary] with the following keys:
   *
   * - `"stdio"` - [FileAccess] to access the process stdin and stdout pipes (read/write).
   *
   * - `"stderr"` - [FileAccess] to access the process stderr pipe (read only).
   *
   * - `"pid"` - Process ID as an [Long], which you can use to monitor the process (and potentially
   * terminate it with [kill]).
   *
   * **Note:** This method is implemented on Android, Linux, macOS, and Windows.
   *
   * **Note:** To execute a Windows command interpreter built-in command, specify `cmd.exe` in
   * [path], `/c` as the first argument, and the desired command as the second argument.
   *
   * **Note:** To execute a PowerShell built-in command, specify `powershell.exe` in [path],
   * `-Command` as the first argument, and the desired command as the second argument.
   *
   * **Note:** To execute a Unix shell built-in command, specify shell executable name in [path],
   * `-c` as the first argument, and the desired command as the second argument.
   *
   * **Note:** On macOS, sandboxed applications are limited to run only embedded helper executables,
   * specified during export or system .app bundle, system .app bundles will ignore arguments.
   */
  @JvmOverloads
  @JvmStatic
  public final fun executeWithPipe(
    path: String,
    arguments: PackedStringArray,
    blocking: Boolean = true,
  ): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path, PACKED_STRING_ARRAY to arguments, BOOL to blocking)
    TransferContext.callMethod(MethodBindings.executeWithPipePtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Creates a new process that runs independently of Godot. It will not terminate when Godot
   * terminates. The path specified in [path] must exist and be an executable file or macOS `.app`
   * bundle. The path is resolved based on the current platform. The [arguments] are used in the given
   * order and separated by a space.
   *
   * On Windows, if [openConsole] is `true` and the process is a console app, a new terminal window
   * will be opened.
   *
   * If the process is successfully created, this method returns its process ID, which you can use
   * to monitor the process (and potentially terminate it with [kill]). Otherwise, this method returns
   * `-1`.
   *
   * **Example:** Run another instance of the project:
   *
   * ```gdscript
   * //gdscript
   * var pid = OS.create_process(OS.get_executable_path(), [])
   * ```
   *
   * ```csharp
   * //csharp
   * var pid = OS.CreateProcess(OS.GetExecutablePath(), []);
   * ```
   *
   * See [execute] if you wish to run an external command and retrieve the results.
   *
   * **Note:** This method is implemented on Android, Linux, macOS, and Windows.
   *
   * **Note:** On macOS, sandboxed applications are limited to run only embedded helper executables,
   * specified during export or system .app bundle, system .app bundles will ignore arguments.
   */
  @JvmOverloads
  @JvmStatic
  public final fun createProcess(
    path: String,
    arguments: PackedStringArray,
    openConsole: Boolean = false,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path, PACKED_STRING_ARRAY to arguments, BOOL to openConsole)
    TransferContext.callMethod(MethodBindings.createProcessPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Creates a new instance of Godot that runs independently. The [arguments] are used in the given
   * order and separated by a space.
   *
   * If the process is successfully created, this method returns the new process' ID, which you can
   * use to monitor the process (and potentially terminate it with [kill]). If the process cannot be
   * created, this method returns `-1`.
   *
   * See [createProcess] if you wish to run a different process.
   *
   * **Note:** This method is implemented on Android, Linux, macOS and Windows.
   */
  @JvmStatic
  public final fun createInstance(arguments: PackedStringArray): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_STRING_ARRAY to arguments)
    TransferContext.callMethod(MethodBindings.createInstancePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Opens one or more files/directories with the specified application. The [programPath] specifies
   * the path to the application to use for opening the files, and [paths] contains an array of
   * file/directory paths to open.
   *
   * **Note:** This method is mostly only relevant for macOS, where opening files using
   * [createProcess] might fail. On other platforms, this falls back to using [createProcess].
   *
   * **Note:** On macOS, [programPath] should ideally be the path to a `.app` bundle.
   */
  @JvmStatic
  public final fun openWithProgram(programPath: String, paths: PackedStringArray): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to programPath, PACKED_STRING_ARRAY to paths)
    TransferContext.callMethod(MethodBindings.openWithProgramPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Kill (terminate) the process identified by the given process ID ([pid]), such as the ID
   * returned by [execute] in non-blocking mode. See also [crash].
   *
   * **Note:** This method can also be used to kill processes that were not spawned by the engine.
   *
   * **Note:** This method is implemented on Android, iOS, Linux, macOS and Windows.
   */
  @JvmStatic
  public final fun kill(pid: Int): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pid.toLong())
    TransferContext.callMethod(MethodBindings.killPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Requests the OS to open a resource identified by [uri] with the most appropriate program. For
   * example:
   *
   * - `OS.shell_open("C:\\Users\\name\\Downloads")` on Windows opens the file explorer at the
   * user's Downloads folder.
   *
   * - `OS.shell_open("C:/Users/name/Downloads")` also works on Windows and opens the file explorer
   * at the user's Downloads folder.
   *
   * - `OS.shell_open("https://godotengine.org")` opens the default web browser on the official
   * Godot website.
   *
   * - `OS.shell_open("mailto:example@example.com")` opens the default email client with the "To"
   * field set to `example@example.com`. See [url=https://datatracker.ietf.org/doc/html/rfc2368]RFC
   * 2368 - The mailto URL scheme[/url] for a list of fields that can be added.
   *
   * Use [ProjectSettings.globalizePath] to convert a `res://` or `user://` project path into a
   * system path for use with this method.
   *
   * **Note:** Use [String.uriEncode] to encode characters within URLs in a URL-safe, portable way.
   * This is especially required for line breaks. Otherwise, [shellOpen] may not work correctly in a
   * project exported to the Web platform.
   *
   * **Note:** This method is implemented on Android, iOS, Web, Linux, macOS and Windows.
   */
  @JvmStatic
  public final fun shellOpen(uri: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to uri)
    TransferContext.callMethod(MethodBindings.shellOpenPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Requests the OS to open the file manager, navigate to the given [fileOrDirPath] and select the
   * target file or folder.
   *
   * If [openFolder] is `true` and [fileOrDirPath] is a valid directory path, the OS will open the
   * file manager and navigate to the target folder without selecting anything.
   *
   * Use [ProjectSettings.globalizePath] to convert a `res://` or `user://` project path into a
   * system path to use with this method.
   *
   * **Note:** This method is currently only implemented on Windows and macOS. On other platforms,
   * it will fallback to [shellOpen] with a directory path of [fileOrDirPath] prefixed with `file://`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun shellShowInFileManager(fileOrDirPath: String, openFolder: Boolean = true):
      Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to fileOrDirPath, BOOL to openFolder)
    TransferContext.callMethod(MethodBindings.shellShowInFileManagerPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the child process ID ([pid]) is still running or `false` if it has
   * terminated. [pid] must be a valid ID generated from [createProcess].
   *
   * **Note:** This method is implemented on Android, iOS, Linux, macOS, and Windows.
   */
  @JvmStatic
  public final fun isProcessRunning(pid: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pid.toLong())
    TransferContext.callMethod(MethodBindings.isProcessRunningPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the exit code of a spawned process once it has finished running (see
   * [isProcessRunning]).
   *
   * Returns `-1` if the [pid] is not a PID of a spawned child process, the process is still
   * running, or the method is not implemented for the current platform.
   *
   * **Note:** Returns `-1` if the [pid] is a macOS bundled app process.
   *
   * **Note:** This method is implemented on Android, Linux, macOS and Windows.
   */
  @JvmStatic
  public final fun getProcessExitCode(pid: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pid.toLong())
    TransferContext.callMethod(MethodBindings.getProcessExitCodePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number used by the host machine to uniquely identify this application.
   *
   * **Note:** On Web, this method always returns `0`.
   */
  @JvmStatic
  public final fun getProcessId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProcessIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if the environment variable with the name [variable] exists.
   *
   * **Note:** Double-check the casing of [variable]. Environment variable names are case-sensitive
   * on all platforms except Windows.
   */
  @JvmStatic
  public final fun hasEnvironment(variable: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to variable)
    TransferContext.callMethod(MethodBindings.hasEnvironmentPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the value of the given environment variable, or an empty string if [variable] doesn't
   * exist.
   *
   * **Note:** Double-check the casing of [variable]. Environment variable names are case-sensitive
   * on all platforms except Windows.
   *
   * **Note:** On macOS, applications do not have access to shell environment variables.
   */
  @JvmStatic
  public final fun getEnvironment(variable: String): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to variable)
    TransferContext.callMethod(MethodBindings.getEnvironmentPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the value of the environment variable [variable] to [value]. The environment variable will
   * be set for the Godot process and any process executed with [execute] after running
   * [setEnvironment]. The environment variable will *not* persist to processes run after the Godot
   * process was terminated.
   *
   * **Note:** Environment variable names are case-sensitive on all platforms except Windows. The
   * [variable] name cannot be empty or include the `=` character. On Windows, there is a 32767
   * characters limit for the combined length of [variable], [value], and the `=` and null terminator
   * characters that will be registered in the environment block.
   */
  @JvmStatic
  public final fun setEnvironment(variable: String, `value`: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to variable, STRING to value)
    TransferContext.callMethod(MethodBindings.setEnvironmentPtr)
  }

  /**
   * Removes the given environment variable from the current environment, if it exists. The
   * [variable] name cannot be empty or include the `=` character. The environment variable will be
   * removed for the Godot process and any process executed with [execute] after running
   * [unsetEnvironment]. The removal of the environment variable will *not* persist to processes run
   * after the Godot process was terminated.
   *
   * **Note:** Environment variable names are case-sensitive on all platforms except Windows.
   */
  @JvmStatic
  public final fun unsetEnvironment(variable: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to variable)
    TransferContext.callMethod(MethodBindings.unsetEnvironmentPtr)
  }

  /**
   * Returns the name of the host platform.
   *
   * - On Windows, this is `"Windows"`.
   *
   * - On macOS, this is `"macOS"`.
   *
   * - On Linux-based operating systems, this is `"Linux"`.
   *
   * - On BSD-based operating systems, this is `"FreeBSD"`, `"NetBSD"`, `"OpenBSD"`, or `"BSD"` as a
   * fallback.
   *
   * - On Android, this is `"Android"`.
   *
   * - On iOS, this is `"iOS"`.
   *
   * - On Web, this is `"Web"`.
   *
   * **Note:** Custom builds of the engine may support additional platforms, such as consoles,
   * possibly returning other names.
   *
   * ```gdscript
   * //gdscript
   * match OS.get_name():
   * 	"Windows":
   * 		print("Welcome to Windows!")
   * 	"macOS":
   * 		print("Welcome to macOS!")
   * 	"Linux", "FreeBSD", "NetBSD", "OpenBSD", "BSD":
   * 		print("Welcome to Linux/BSD!")
   * 	"Android":
   * 		print("Welcome to Android!")
   * 	"iOS":
   * 		print("Welcome to iOS!")
   * 	"Web":
   * 		print("Welcome to the Web!")
   * ```
   *
   * ```csharp
   * //csharp
   * switch (OS.GetName())
   * {
   * 	case "Windows":
   * 		GD.Print("Welcome to Windows");
   * 		break;
   * 	case "macOS":
   * 		GD.Print("Welcome to macOS!");
   * 		break;
   * 	case "Linux":
   * 	case "FreeBSD":
   * 	case "NetBSD":
   * 	case "OpenBSD":
   * 	case "BSD":
   * 		GD.Print("Welcome to Linux/BSD!");
   * 		break;
   * 	case "Android":
   * 		GD.Print("Welcome to Android!");
   * 		break;
   * 	case "iOS":
   * 		GD.Print("Welcome to iOS!");
   * 		break;
   * 	case "Web":
   * 		GD.Print("Welcome to the Web!");
   * 		break;
   * }
   * ```
   *
   * **Note:** On Web platforms, it is still possible to determine the host platform's OS with
   * feature tags. See [hasFeature].
   */
  @JvmStatic
  public final fun getName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the distribution for Linux and BSD platforms (e.g. "Ubuntu", "Manjaro",
   * "OpenBSD", etc.).
   *
   * Returns the same value as [getName] for stock Android ROMs, but attempts to return the custom
   * ROM name for popular Android derivatives such as "LineageOS".
   *
   * Returns the same value as [getName] for other platforms.
   *
   * **Note:** This method is not supported on the Web platform. It returns an empty string.
   */
  @JvmStatic
  public final fun getDistributionName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDistributionNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the exact production and build version of the operating system. This is different from
   * the branded version used in marketing. This helps to distinguish between different releases of
   * operating systems, including minor versions, and insider and custom builds.
   *
   * - For Windows, the major and minor version are returned, as well as the build number. For
   * example, the returned string may look like `10.0.9926` for a build of Windows 10.
   *
   * - For rolling distributions, such as Arch Linux, an empty string is returned.
   *
   * - For macOS and iOS, the major and minor version are returned, as well as the patch number.
   *
   * - For Android, the SDK version and the incremental build number are returned. If it's a custom
   * ROM, it attempts to return its version instead.
   *
   * **Note:** This method is not supported on the Web platform. It returns an empty string.
   */
  @JvmStatic
  public final fun getVersion(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVersionPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the branded version used in marketing, followed by the build number (on Windows), the
   * version number (on macOS), or the SDK version and incremental build number (on Android). Examples
   * include `11 (build 22000)`, `Sequoia (15.0.0)`, and `15 (SDK 35 build abc528-11988f)`.
   *
   * This value can then be appended to [getName] to get a full, human-readable operating system
   * name and version combination for the operating system. Windows feature updates such as 24H2 are
   * not contained in the resulting string, but Windows Server is recognized as such (e.g. `2025 (build
   * 26100)` for Windows Server 2025).
   *
   * **Note:** This method is only supported on Windows, macOS, and Android. On other operating
   * systems, it returns the same value as [getVersion].
   */
  @JvmStatic
  public final fun getVersionAlias(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVersionAliasPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the command-line arguments passed to the engine, excluding arguments processed by the
   * engine, such as `--headless` and `--fullscreen`.
   *
   * ```
   * # Godot has been executed with the following command:
   * # godot --headless --verbose --scene my_scene.tscn --custom
   * OS.get_cmdline_args() # Returns ["--scene", "my_scene.tscn", "--custom"]
   * ```
   *
   * Command-line arguments can be written in any form, including both `--key value` and
   * `--key=value` forms so they can be properly parsed, as long as custom command-line arguments do
   * not conflict with engine arguments.
   *
   * You can also incorporate environment variables using the [getEnvironment] method.
   *
   * You can set [ProjectSettings.editor/run/mainRunArgs] to define command-line arguments to be
   * passed by the editor when running the project.
   *
   * **Example:** Parse command-line arguments into a [Dictionary] using the `--key=value` form for
   * arguments:
   *
   * ```gdscript
   * //gdscript
   * var arguments = {}
   * for argument in OS.get_cmdline_args():
   * 	if argument.contains("="):
   * 		var key_value = argument.split("=")
   * 		arguments[key_value[0].trim_prefix("--")] = key_value[1]
   * 	else:
   * 		# Options without an argument will be present in the dictionary,
   * 		# with the value set to an empty string.
   * 		arguments[argument.trim_prefix("--")] = ""
   * ```
   *
   * ```csharp
   * //csharp
   * var arguments = new Dictionary<string, string>();
   * foreach (var argument in OS.GetCmdlineArgs())
   * {
   * 	if (argument.Contains('='))
   * 	{
   * 		string[] keyValue = argument.Split("=");
   * 		arguments[keyValue[0].TrimPrefix("--")] = keyValue[1];
   * 	}
   * 	else
   * 	{
   * 		// Options without an argument will be present in the dictionary,
   * 		// with the value set to an empty string.
   * 		arguments[argument.TrimPrefix("--")] = "";
   * 	}
   * }
   * ```
   *
   * **Note:** Passing custom user arguments directly is not recommended, as the engine may discard
   * or modify them. Instead, pass the standard UNIX double dash (`--`) and then the custom arguments,
   * which the engine will ignore by design. These can be read via [getCmdlineUserArgs].
   */
  @JvmStatic
  public final fun getCmdlineArgs(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCmdlineArgsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns the command-line user arguments passed to the engine. User arguments are ignored by the
   * engine and reserved for the user. They are passed after the double dash `--` argument. `++` may be
   * used when `--` is intercepted by another program (such as `startx`).
   *
   * ```
   * # Godot has been executed with the following command:
   * # godot --fullscreen --custom -- --level=2 --hardcore
   *
   * OS.get_cmdline_args()      # Returns ["--custom"]
   * OS.get_cmdline_user_args() # Returns ["--level=2", "--hardcore"]
   * ```
   *
   * To get arguments passed before `--` or `++`, use [getCmdlineArgs].
   */
  @JvmStatic
  public final fun getCmdlineUserArgs(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCmdlineUserArgsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns the video adapter driver name and version for the user's currently active graphics
   * card, as a [PackedStringArray]. See also [RenderingServer.getVideoAdapterApiVersion].
   *
   * The first element holds the driver name, such as `nvidia`, `amdgpu`, etc.
   *
   * The second element holds the driver version. For example, on the `nvidia` driver on a Linux/BSD
   * platform, the version is in the format `510.85.02`. For Windows, the driver's format is
   * `31.0.15.1659`.
   *
   * **Note:** This method is only supported on Linux/BSD and Windows when not running in headless
   * mode. On other platforms, it returns an empty array.
   *
   * **Note:** This method will run slowly the first time it is called in a session; it can take
   * several seconds depending on the operating system and hardware. It is blocking if called on the
   * main thread, so it's recommended to call it on a separate thread using [Thread]. This allows the
   * engine to keep running while the information is being retrieved. However,
   * [getVideoAdapterDriverInfo] is *not* thread-safe, so it should not be called from multiple threads
   * at the same time.
   *
   * ```gdscript
   * //gdscript
   * var thread = Thread.new()
   *
   * func _ready():
   * 	thread.start(
   * 		func():
   * 			var driver_info = OS.get_video_adapter_driver_info()
   * 			if not driver_info.is_empty():
   * 				print("Driver: &#37;s &#37;s" &#37; [driver_info[0], driver_info[1]])
   * 			else:
   * 				print("Driver: (unknown)")
   * 	)
   *
   * func _exit_tree():
   * 	thread.wait_to_finish()
   * ```
   */
  @JvmStatic
  public final fun getVideoAdapterDriverInfo(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVideoAdapterDriverInfoPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * If [restart] is `true`, restarts the project automatically when it is exited with
   * [SceneTree.quit] or [Node.NOTIFICATION_WM_CLOSE_REQUEST]. Command-line [arguments] can be
   * supplied. To restart the project with the same command line arguments as originally used to run
   * the project, pass [getCmdlineArgs] as the value for [arguments].
   *
   * This method can be used to apply setting changes that require a restart. See also
   * [isRestartOnExitSet] and [getRestartOnExitArguments].
   *
   * **Note:** This method is only effective on desktop platforms, and only when the project isn't
   * started from the editor. It will have no effect on mobile and Web platforms, or when the project
   * is started from the editor.
   *
   * **Note:** If the project process crashes or is *killed* by the user (by sending `SIGKILL`
   * instead of the usual `SIGTERM`), the project won't restart automatically.
   */
  @JvmOverloads
  @JvmStatic
  public final fun setRestartOnExit(restart: Boolean, arguments: PackedStringArray =
      PackedStringArray()): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to restart, PACKED_STRING_ARRAY to arguments)
    TransferContext.callMethod(MethodBindings.setRestartOnExitPtr)
  }

  /**
   * Returns `true` if the project will automatically restart when it exits for any reason, `false`
   * otherwise. See also [setRestartOnExit] and [getRestartOnExitArguments].
   */
  @JvmStatic
  public final fun isRestartOnExitSet(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRestartOnExitSetPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the list of command line arguments that will be used when the project automatically
   * restarts using [setRestartOnExit]. See also [isRestartOnExitSet].
   */
  @JvmStatic
  public final fun getRestartOnExitArguments(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRestartOnExitArgumentsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Delays execution of the current thread by [usec] microseconds. [usec] must be greater than or
   * equal to `0`. Otherwise, [delayUsec] does nothing and prints an error message.
   *
   * **Note:** [delayUsec] is a *blocking* way to delay code execution. To delay code execution in a
   * non-blocking way, you may use [SceneTree.createTimer]. Awaiting with a [SceneTreeTimer] delays the
   * execution of code placed below the `await` without affecting the rest of the project (or editor,
   * for [EditorPlugin]s and [EditorScript]s).
   *
   * **Note:** When [delayUsec] is called on the main thread, it will freeze the project and will
   * prevent it from redrawing and registering input until the delay has passed. When using [delayUsec]
   * as part of an [EditorPlugin] or [EditorScript], it will freeze the editor but won't freeze the
   * project if it is currently running (since the project is an independent child process).
   */
  @JvmStatic
  public final fun delayUsec(usec: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to usec.toLong())
    TransferContext.callMethod(MethodBindings.delayUsecPtr)
  }

  /**
   * Delays execution of the current thread by [msec] milliseconds. [msec] must be greater than or
   * equal to `0`. Otherwise, [delayMsec] does nothing and prints an error message.
   *
   * **Note:** [delayMsec] is a *blocking* way to delay code execution. To delay code execution in a
   * non-blocking way, you may use [SceneTree.createTimer]. Awaiting with [SceneTreeTimer] delays the
   * execution of code placed below the `await` without affecting the rest of the project (or editor,
   * for [EditorPlugin]s and [EditorScript]s).
   *
   * **Note:** When [delayMsec] is called on the main thread, it will freeze the project and will
   * prevent it from redrawing and registering input until the delay has passed. When using [delayMsec]
   * as part of an [EditorPlugin] or [EditorScript], it will freeze the editor but won't freeze the
   * project if it is currently running (since the project is an independent child process).
   */
  @JvmStatic
  public final fun delayMsec(msec: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to msec.toLong())
    TransferContext.callMethod(MethodBindings.delayMsecPtr)
  }

  /**
   * Returns the host OS locale as a [String] of the form `language_Script_COUNTRY_VARIANT@extra`.
   * Every substring after `language` is optional and may not exist.
   *
   * - `language` - 2 or 3-letter
   * [url=https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes]language code[/url], in lower case.
   *
   * - [code skip-lint]Script[/code] - 4-letter [url=https://en.wikipedia.org/wiki/ISO_15924]script
   * code[/url], in title case.
   *
   * - `COUNTRY` - 2 or 3-letter [url=https://en.wikipedia.org/wiki/ISO_3166-1]country code[/url],
   * in upper case.
   *
   * - `VARIANT` - language variant, region and sort order. The variant can have any number of
   * underscored keywords.
   *
   * - `extra` - semicolon separated list of additional key words. This may include currency,
   * calendar, sort order and numbering system information.
   *
   * If you want only the language code and not the fully specified locale from the OS, you can use
   * [getLocaleLanguage].
   */
  @JvmStatic
  public final fun getLocale(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the host OS locale's 2 or 3-letter
   * [url=https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes]language code[/url] as a string which
   * should be consistent on all platforms. This is equivalent to extracting the `language` part of the
   * [getLocale] string.
   *
   * This can be used to narrow down fully specified locale strings to only the "common" language
   * code, when you don't need the additional information about country code or variants. For example,
   * for a French Canadian user with `fr_CA` locale, this would return `fr`.
   */
  @JvmStatic
  public final fun getLocaleLanguage(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocaleLanguagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the model name of the current device.
   *
   * **Note:** This method is implemented on Android, iOS, macOS, and Windows. Returns
   * `"GenericDevice"` on unsupported platforms.
   */
  @JvmStatic
  public final fun getModelName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModelNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the `user://` file system is persistent, that is, its state is the same after
   * a player quits and starts the game again. Relevant to the Web platform, where this persistence may
   * be unavailable.
   */
  @JvmStatic
  public final fun isUserfsPersistent(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUserfsPersistentPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the engine was executed with the `--verbose` or `-v` command line argument,
   * or if [ProjectSettings.debug/settings/stdout/verboseStdout] is `true`. See also
   * [@GlobalScope.printVerbose].
   */
  @JvmStatic
  public final fun isStdoutVerbose(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isStdoutVerbosePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the Godot binary used to run the project is a *debug* export template, or
   * when running in the editor.
   *
   * Returns `false` if the Godot binary used to run the project is a *release* export template.
   *
   * **Note:** To check whether the Godot binary used to run the project is an export template
   * (debug or release), use `OS.has_feature("template")` instead.
   */
  @JvmStatic
  public final fun isDebugBuild(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDebugBuildPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the amount of static memory being used by the program in bytes. Only works in debug
   * builds.
   */
  @JvmStatic
  public final fun getStaticMemoryUsage(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStaticMemoryUsagePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the maximum amount of static memory used. Only works in debug builds.
   */
  @JvmStatic
  public final fun getStaticMemoryPeakUsage(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStaticMemoryPeakUsagePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns a [Dictionary] containing information about the current memory with the following
   * entries:
   *
   * - `"physical"` - total amount of usable physical memory in bytes. This value can be slightly
   * less than the actual physical memory amount, since it does not include memory reserved by the
   * kernel and devices.
   *
   * - `"free"` - amount of physical memory, that can be immediately allocated without disk access
   * or other costly operations, in bytes. The process might be able to allocate more physical memory,
   * but this action will require moving inactive pages to disk, which can be expensive.
   *
   * - `"available"` - amount of memory that can be allocated without extending the swap file(s), in
   * bytes. This value includes both physical memory and swap.
   *
   * - `"stack"` - size of the current thread stack in bytes.
   *
   * **Note:** Each entry's value may be `-1` if it is unknown.
   */
  @JvmStatic
  public final fun getMemoryInfo(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMemoryInfoPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Moves the file or directory at the given [path] to the system's recycle bin. See also
   * [DirAccess.remove].
   *
   * The method takes only global paths, so you may need to use [ProjectSettings.globalizePath]. Do
   * not use it for files in `res://` as it will not work in exported projects.
   *
   * Returns [FAILED] if the file or directory cannot be found, or the system does not support this
   * method.
   *
   * ```gdscript
   * //gdscript
   * var file_to_remove = "user://slot1.save"
   * OS.move_to_trash(ProjectSettings.globalize_path(file_to_remove))
   * ```
   *
   * ```csharp
   * //csharp
   * var fileToRemove = "user://slot1.save";
   * OS.MoveToTrash(ProjectSettings.GlobalizePath(fileToRemove));
   * ```
   *
   * **Note:** This method is implemented on Android, Linux, macOS and Windows.
   *
   * **Note:** If the user has disabled the recycle bin on their system, the file will be
   * permanently deleted instead.
   */
  @JvmStatic
  public final fun moveToTrash(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.moveToTrashPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the absolute directory path where user data is written (the `user://` directory in
   * Godot). The path depends on the project name and
   * [ProjectSettings.application/config/useCustomUserDir].
   *
   * - On Windows, this is `&#37;AppData&#37;\Godot\app_userdata\[project_name]`, or
   * `&#37;AppData&#37;\[custom_name]` if `use_custom_user_dir` is set. `&#37;AppData&#37;` expands to
   * `&#37;UserProfile&#37;\AppData\Roaming`.
   *
   * - On macOS, this is `~/Library/Application Support/Godot/app_userdata/[project_name]`, or
   * `~/Library/Application Support/[custom_name]` if `use_custom_user_dir` is set.
   *
   * - On Linux and BSD, this is `~/.local/share/godot/app_userdata/[project_name]`, or
   * `~/.local/share/[custom_name]` if `use_custom_user_dir` is set.
   *
   * - On Android and iOS, this is a sandboxed directory in either internal or external storage,
   * depending on the user's configuration.
   *
   * - On Web, this is a virtual directory managed by the browser.
   *
   * If the project name is empty, `[project_name]` falls back to `[unnamed project]`.
   *
   * Not to be confused with [getDataDir], which returns the *global* (non-project-specific) user
   * home directory.
   */
  @JvmStatic
  public final fun getUserDataDir(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUserDataDirPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the path to commonly used folders across different platforms, as defined by [dir]. See
   * the [SystemDir] constants for available locations.
   *
   * **Note:** This method is implemented on Android, Linux, macOS and Windows.
   *
   * **Note:** Shared storage is implemented on Android and allows to differentiate between app
   * specific and shared directories, if [sharedStorage] is `true`. Shared directories have additional
   * restrictions on Android.
   */
  @JvmOverloads
  @JvmStatic
  public final fun getSystemDir(dir: SystemDir, sharedStorage: Boolean = true): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to dir.value, BOOL to sharedStorage)
    TransferContext.callMethod(MethodBindings.getSystemDirPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the *global* user configuration directory according to the operating system's
   * standards.
   *
   * On the Linux/BSD platform, this path can be overridden by setting the `XDG_CONFIG_HOME`
   * environment variable before starting the project. See
   * [url=$DOCS_URL/tutorials/io/data_paths.html]File paths in Godot projects[/url] in the
   * documentation for more information. See also [getCacheDir] and [getDataDir].
   *
   * Not to be confused with [getUserDataDir], which returns the *project-specific* user data path.
   */
  @JvmStatic
  public final fun getConfigDir(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConfigDirPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the *global* user data directory according to the operating system's standards.
   *
   * On the Linux/BSD platform, this path can be overridden by setting the `XDG_DATA_HOME`
   * environment variable before starting the project. See
   * [url=$DOCS_URL/tutorials/io/data_paths.html]File paths in Godot projects[/url] in the
   * documentation for more information. See also [getCacheDir] and [getConfigDir].
   *
   * Not to be confused with [getUserDataDir], which returns the *project-specific* user data path.
   */
  @JvmStatic
  public final fun getDataDir(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDataDirPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the *global* cache data directory according to the operating system's standards.
   *
   * On the Linux/BSD platform, this path can be overridden by setting the `XDG_CACHE_HOME`
   * environment variable before starting the project. See
   * [url=$DOCS_URL/tutorials/io/data_paths.html]File paths in Godot projects[/url] in the
   * documentation for more information. See also [getConfigDir] and [getDataDir].
   *
   * Not to be confused with [getUserDataDir], which returns the *project-specific* user data path.
   */
  @JvmStatic
  public final fun getCacheDir(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCacheDirPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the *global* temporary data directory according to the operating system's standards.
   */
  @JvmStatic
  public final fun getTempDir(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTempDirPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns a string that is unique to the device.
   *
   * **Note:** This string may change without notice if the user reinstalls their operating system,
   * upgrades it, or modifies their hardware. This means it should generally not be used to encrypt
   * persistent data, as the data saved before an unexpected ID change would become inaccessible. The
   * returned string may also be falsified using external programs, so do not rely on the string
   * returned by this method for security purposes.
   *
   * **Note:** On Web, returns an empty string and generates an error, as this method cannot be
   * implemented for security reasons.
   */
  @JvmStatic
  public final fun getUniqueId(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUniqueIdPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the given keycode as a [String].
   *
   * ```gdscript
   * //gdscript
   * print(OS.get_keycode_string(KEY_C))                    # Prints "C"
   * print(OS.get_keycode_string(KEY_ESCAPE))               # Prints "Escape"
   * print(OS.get_keycode_string(KEY_MASK_SHIFT | KEY_TAB)) # Prints "Shift+Tab"
   * ```
   *
   * ```csharp
   * //csharp
   * GD.Print(OS.GetKeycodeString(Key.C));                                    // Prints "C"
   * GD.Print(OS.GetKeycodeString(Key.Escape));                               // Prints "Escape"
   * GD.Print(OS.GetKeycodeString((Key)KeyModifierMask.MaskShift | Key.Tab)); // Prints "Shift+Tab"
   * ```
   *
   * See also [findKeycodeFromString], [InputEventKey.keycode], and
   * [InputEventKey.getKeycodeWithModifiers].
   */
  @JvmStatic
  public final fun getKeycodeString(code: Key): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to code.value)
    TransferContext.callMethod(MethodBindings.getKeycodeStringPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the input keycode corresponds to a Unicode character. For a list of codes,
   * see the [Key] constants.
   *
   * ```gdscript
   * //gdscript
   * print(OS.is_keycode_unicode(KEY_G))      # Prints true
   * print(OS.is_keycode_unicode(KEY_KP_4))   # Prints true
   * print(OS.is_keycode_unicode(KEY_TAB))    # Prints false
   * print(OS.is_keycode_unicode(KEY_ESCAPE)) # Prints false
   * ```
   *
   * ```csharp
   * //csharp
   * GD.Print(OS.IsKeycodeUnicode((long)Key.G));      // Prints True
   * GD.Print(OS.IsKeycodeUnicode((long)Key.Kp4));    // Prints True
   * GD.Print(OS.IsKeycodeUnicode((long)Key.Tab));    // Prints False
   * GD.Print(OS.IsKeycodeUnicode((long)Key.Escape)); // Prints False
   * ```
   */
  @JvmStatic
  public final fun isKeycodeUnicode(code: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to code)
    TransferContext.callMethod(MethodBindings.isKeycodeUnicodePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Finds the keycode for the given string. The returned values are equivalent to the [Key]
   * constants.
   *
   * ```gdscript
   * //gdscript
   * print(OS.find_keycode_from_string("C"))         # Prints 67 (KEY_C)
   * print(OS.find_keycode_from_string("Escape"))    # Prints 4194305 (KEY_ESCAPE)
   * print(OS.find_keycode_from_string("Shift+Tab")) # Prints 37748738 (KEY_MASK_SHIFT | KEY_TAB)
   * print(OS.find_keycode_from_string("Unknown"))   # Prints 0 (KEY_NONE)
   * ```
   *
   * ```csharp
   * //csharp
   * GD.Print(OS.FindKeycodeFromString("C"));         // Prints C (Key.C)
   * GD.Print(OS.FindKeycodeFromString("Escape"));    // Prints Escape (Key.Escape)
   * GD.Print(OS.FindKeycodeFromString("Shift+Tab")); // Prints 37748738 (KeyModifierMask.MaskShift
   * | Key.Tab)
   * GD.Print(OS.FindKeycodeFromString("Unknown"));   // Prints None (Key.None)
   * ```
   *
   * See also [getKeycodeString].
   */
  @JvmStatic
  public final fun findKeycodeFromString(string: String): Key {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string)
    TransferContext.callMethod(MethodBindings.findKeycodeFromStringPtr)
    return Key.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If [enabled] is `true`, when opening a file for writing, a temporary file is used in its place.
   * When closed, it is automatically applied to the target file.
   *
   * This can useful when files may be opened by other applications, such as antiviruses, text
   * editors, or even the Godot editor itself.
   */
  @JvmStatic
  public final fun setUseFileAccessSaveAndSwap(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setUseFileAccessSaveAndSwapPtr)
  }

  /**
   * Assigns the given name to the current thread. Returns [ERR_UNAVAILABLE] if unavailable on the
   * current platform.
   */
  @JvmStatic
  public final fun setThreadName(name: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.setThreadNamePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the ID of the current thread. This can be used in logs to ease debugging of
   * multi-threaded applications.
   *
   * **Note:** Thread IDs are not deterministic and may be reused across application restarts.
   */
  @JvmStatic
  public final fun getThreadCallerId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThreadCallerIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the ID of the main thread. See [getThreadCallerId].
   *
   * **Note:** Thread IDs are not deterministic and may be reused across application restarts.
   */
  @JvmStatic
  public final fun getMainThreadId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMainThreadIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the feature for the given feature tag is supported in the currently running
   * instance, depending on the platform, build, etc. Can be used to check whether you're currently
   * running a debug build, on a certain platform or arch, etc. Refer to the
   * [url=$DOCS_URL/tutorials/export/feature_tags.html]Feature Tags[/url] documentation for more
   * details.
   *
   * **Note:** Tag names are case-sensitive.
   *
   * **Note:** On the Web platform, one of the following additional tags is defined to indicate the
   * host platform: `web_android`, `web_ios`, `web_linuxbsd`, `web_macos`, or `web_windows`.
   */
  @JvmStatic
  public final fun hasFeature(tagName: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to tagName)
    TransferContext.callMethod(MethodBindings.hasFeaturePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the application is running in the sandbox.
   *
   * **Note:** This method is only implemented on macOS and Linux.
   */
  @JvmStatic
  public final fun isSandboxed(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSandboxedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Requests permission from the OS for the given [name]. Returns `true` if the permission has
   * already been granted. See also [signal MainLoop.on_request_permissions_result].
   *
   * The [name] must be the full permission name. For example:
   *
   * - `OS.request_permission("android.permission.READ_EXTERNAL_STORAGE")`
   *
   * - `OS.request_permission("android.permission.POST_NOTIFICATIONS")`
   *
   * - `OS.request_permission("macos.permission.RECORD_SCREEN")`
   *
   * - `OS.request_permission("appleembedded.permission.AUDIO_RECORD")`
   *
   * **Note:** On Android, permission must be checked during export.
   *
   * **Note:** This method is implemented on Android, macOS, and visionOS platforms.
   */
  @JvmStatic
  public final fun requestPermission(name: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.requestPermissionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Requests *dangerous* permissions from the OS. Returns `true` if permissions have already been
   * granted. See also [signal MainLoop.on_request_permissions_result].
   *
   * **Note:** Permissions must be checked during export.
   *
   * **Note:** This method is only implemented on Android. Normal permissions are automatically
   * granted at install time in Android applications.
   */
  @JvmStatic
  public final fun requestPermissions(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.requestPermissionsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * On Android devices: Returns the list of dangerous permissions that have been granted.
   *
   * On macOS: Returns the list of granted permissions and user selected folders accessible to the
   * application (sandboxed applications only). Use the native file dialog to request folder access
   * permission.
   *
   * On iOS, visionOS: Returns the list of granted permissions.
   */
  @JvmStatic
  public final fun getGrantedPermissions(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGrantedPermissionsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * On macOS (sandboxed applications only), this function clears list of user selected folders
   * accessible to the application.
   */
  @JvmStatic
  public final fun revokeGrantedPermissions(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.revokeGrantedPermissionsPtr)
  }

  /**
   * Add a custom logger to intercept the internal message stream.
   */
  @JvmStatic
  public final fun addLogger(logger: Logger): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to logger)
    TransferContext.callMethod(MethodBindings.addLoggerPtr)
  }

  /**
   * Remove a custom logger added by [addLogger].
   */
  @JvmStatic
  public final fun removeLogger(logger: Logger): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to logger)
    TransferContext.callMethod(MethodBindings.removeLoggerPtr)
  }

  public enum class RenderingDriver(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The Vulkan rendering driver. It requires Vulkan 1.0 support and automatically uses features
     * from Vulkan 1.1, 1.2, and 1.3 if available.
     */
    VULKAN(0),
    /**
     * The OpenGL 3 rendering driver. It uses OpenGL 3.3 Core Profile on desktop platforms, OpenGL
     * ES 3.0 on mobile devices, and WebGL 2.0 on Web.
     */
    OPENGL3(1),
    /**
     * The Direct3D 12 rendering driver. It requires the 12_0 feature level and Shader Model 6.0
     * support.
     */
    D3D12(2),
    /**
     * The Metal rendering driver.
     */
    METAL(3),
    ;

    public companion object {
      public fun from(`value`: Long): RenderingDriver = entries.single { it.`value` == `value` }
    }
  }

  public enum class SystemDir(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Refers to the Desktop directory path.
     */
    DESKTOP(0),
    /**
     * Refers to the DCIM (Digital Camera Images) directory path.
     */
    DCIM(1),
    /**
     * Refers to the Documents directory path.
     */
    DOCUMENTS(2),
    /**
     * Refers to the Downloads directory path.
     */
    DOWNLOADS(3),
    /**
     * Refers to the Movies (or Videos) directory path.
     */
    MOVIES(4),
    /**
     * Refers to the Music directory path.
     */
    MUSIC(5),
    /**
     * Refers to the Pictures directory path.
     */
    PICTURES(6),
    /**
     * Refers to the Ringtones directory path.
     */
    RINGTONES(7),
    ;

    public companion object {
      public fun from(`value`: Long): SystemDir = entries.single { it.`value` == `value` }
    }
  }

  public enum class StdHandleType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Standard I/O device is invalid. No data can be received from or sent to these standard I/O
     * devices.
     */
    INVALID(0),
    /**
     * Standard I/O device is a console. This typically occurs when Godot is run from a terminal
     * with no redirection. This is also used for all standard I/O devices when running Godot from the
     * editor, at least on desktop platforms.
     */
    CONSOLE(1),
    /**
     * Standard I/O device is a regular file. This typically occurs with redirection from a
     * terminal, e.g. `godot > stdout.txt`, `godot < stdin.txt` or `godot > stdout_stderr.txt 2>&1`.
     */
    FILE(2),
    /**
     * Standard I/O device is a FIFO/pipe. This typically occurs with pipe usage from a terminal,
     * e.g. `echo "Hello" | godot`.
     */
    PIPE(3),
    /**
     * Standard I/O device type is unknown.
     */
    UNKNOWN(4),
    ;

    public companion object {
      public fun from(`value`: Long): StdHandleType = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val getEntropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_entropy", 47165747)

    internal val getSystemCaCertificatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_system_ca_certificates", 2841200299)

    internal val getConnectedMidiInputsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_connected_midi_inputs", 2981934095)

    internal val openMidiInputsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "open_midi_inputs", 3218959716)

    internal val closeMidiInputsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "close_midi_inputs", 3218959716)

    internal val alertPtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "alert", 1783970740)

    internal val crashPtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "crash", 83702148)

    internal val setLowProcessorUsageModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "set_low_processor_usage_mode", 2586408642)

    internal val isInLowProcessorUsageModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_in_low_processor_usage_mode", 36873697)

    internal val setLowProcessorUsageModeSleepUsecPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "set_low_processor_usage_mode_sleep_usec", 1286410249)

    internal val getLowProcessorUsageModeSleepUsecPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_low_processor_usage_mode_sleep_usec", 3905245786)

    internal val setDeltaSmoothingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "set_delta_smoothing", 2586408642)

    internal val isDeltaSmoothingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_delta_smoothing_enabled", 36873697)

    internal val getProcessorCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_processor_count", 3905245786)

    internal val getProcessorNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_processor_name", 201670096)

    internal val getSystemFontsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_system_fonts", 1139954409)

    internal val getSystemFontPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_system_font_path", 626580860)

    internal val getSystemFontPathForTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_system_font_path_for_text", 197317981)

    internal val getExecutablePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_executable_path", 201670096)

    internal val readStringFromStdinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "read_string_from_stdin", 723587915)

    internal val readBufferFromStdinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "read_buffer_from_stdin", 3249455752)

    internal val getStdinTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_stdin_type", 1704816237)

    internal val getStdoutTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_stdout_type", 1704816237)

    internal val getStderrTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_stderr_type", 1704816237)

    internal val executePtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "execute", 1488299882)

    internal val executeWithPipePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "execute_with_pipe", 2851312030)

    internal val createProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "create_process", 2903767230)

    internal val createInstancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "create_instance", 1080601263)

    internal val openWithProgramPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "open_with_program", 2848259907)

    internal val killPtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "kill", 844576869)

    internal val shellOpenPtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "shell_open", 166001499)

    internal val shellShowInFileManagerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "shell_show_in_file_manager", 3565188097)

    internal val isProcessRunningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_process_running", 1116898809)

    internal val getProcessExitCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_process_exit_code", 923996154)

    internal val getProcessIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_process_id", 3905245786)

    internal val hasEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "has_environment", 3927539163)

    internal val getEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_environment", 3135753539)

    internal val setEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "set_environment", 3605043004)

    internal val unsetEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "unset_environment", 3089850668)

    internal val getNamePtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "get_name", 201670096)

    internal val getDistributionNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_distribution_name", 201670096)

    internal val getVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_version", 201670096)

    internal val getVersionAliasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_version_alias", 201670096)

    internal val getCmdlineArgsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_cmdline_args", 2981934095)

    internal val getCmdlineUserArgsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_cmdline_user_args", 2981934095)

    internal val getVideoAdapterDriverInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_video_adapter_driver_info", 1139954409)

    internal val setRestartOnExitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "set_restart_on_exit", 3331453935)

    internal val isRestartOnExitSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_restart_on_exit_set", 36873697)

    internal val getRestartOnExitArgumentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_restart_on_exit_arguments", 1139954409)

    internal val delayUsecPtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "delay_usec", 998575451)

    internal val delayMsecPtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "delay_msec", 998575451)

    internal val getLocalePtr: VoidPtr = TypeManager.getMethodBindPtr("OS", "get_locale", 201670096)

    internal val getLocaleLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_locale_language", 201670096)

    internal val getModelNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_model_name", 201670096)

    internal val isUserfsPersistentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_userfs_persistent", 36873697)

    internal val isStdoutVerbosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_stdout_verbose", 36873697)

    internal val isDebugBuildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_debug_build", 36873697)

    internal val getStaticMemoryUsagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_static_memory_usage", 3905245786)

    internal val getStaticMemoryPeakUsagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_static_memory_peak_usage", 3905245786)

    internal val getMemoryInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_memory_info", 3102165223)

    internal val moveToTrashPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "move_to_trash", 2113323047)

    internal val getUserDataDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_user_data_dir", 201670096)

    internal val getSystemDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_system_dir", 3073895123)

    internal val getConfigDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_config_dir", 201670096)

    internal val getDataDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_data_dir", 201670096)

    internal val getCacheDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_cache_dir", 201670096)

    internal val getTempDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_temp_dir", 201670096)

    internal val getUniqueIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_unique_id", 201670096)

    internal val getKeycodeStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_keycode_string", 2261993717)

    internal val isKeycodeUnicodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_keycode_unicode", 1116898809)

    internal val findKeycodeFromStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "find_keycode_from_string", 1084858572)

    internal val setUseFileAccessSaveAndSwapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "set_use_file_access_save_and_swap", 2586408642)

    internal val setThreadNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "set_thread_name", 166001499)

    internal val getThreadCallerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_thread_caller_id", 3905245786)

    internal val getMainThreadIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_main_thread_id", 3905245786)

    internal val hasFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "has_feature", 3927539163)

    internal val isSandboxedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "is_sandboxed", 36873697)

    internal val requestPermissionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "request_permission", 2323990056)

    internal val requestPermissionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "request_permissions", 2240911060)

    internal val getGrantedPermissionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "get_granted_permissions", 1139954409)

    internal val revokeGrantedPermissionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "revoke_granted_permissions", 3218959716)

    internal val addLoggerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "add_logger", 4261188958)

    internal val removeLoggerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OS", "remove_logger", 4261188958)
  }
}
