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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
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
 * The [Engine] singleton allows you to query and modify the project's run-time parameters, such as
 * frames per second, time scale, and others. It also stores information about the current build of
 * Godot, such as the current version.
 */
@GodotBaseType
public object Engine : Object() {
  @JvmField
  public val setPhysicsTicksPerSecondName: MethodStringName1<Engine, Unit, Int> =
      MethodStringName1<Engine, Unit, Int>("set_physics_ticks_per_second")

  @JvmField
  public val getPhysicsTicksPerSecondName: MethodStringName0<Engine, Int> =
      MethodStringName0<Engine, Int>("get_physics_ticks_per_second")

  @JvmField
  public val setMaxPhysicsStepsPerFrameName: MethodStringName1<Engine, Unit, Int> =
      MethodStringName1<Engine, Unit, Int>("set_max_physics_steps_per_frame")

  @JvmField
  public val getMaxPhysicsStepsPerFrameName: MethodStringName0<Engine, Int> =
      MethodStringName0<Engine, Int>("get_max_physics_steps_per_frame")

  @JvmField
  public val setPhysicsJitterFixName: MethodStringName1<Engine, Unit, Double> =
      MethodStringName1<Engine, Unit, Double>("set_physics_jitter_fix")

  @JvmField
  public val getPhysicsJitterFixName: MethodStringName0<Engine, Double> =
      MethodStringName0<Engine, Double>("get_physics_jitter_fix")

  @JvmField
  public val getPhysicsInterpolationFractionName: MethodStringName0<Engine, Double> =
      MethodStringName0<Engine, Double>("get_physics_interpolation_fraction")

  @JvmField
  public val setMaxFpsName: MethodStringName1<Engine, Unit, Int> =
      MethodStringName1<Engine, Unit, Int>("set_max_fps")

  @JvmField
  public val getMaxFpsName: MethodStringName0<Engine, Int> =
      MethodStringName0<Engine, Int>("get_max_fps")

  @JvmField
  public val setTimeScaleName: MethodStringName1<Engine, Unit, Double> =
      MethodStringName1<Engine, Unit, Double>("set_time_scale")

  @JvmField
  public val getTimeScaleName: MethodStringName0<Engine, Double> =
      MethodStringName0<Engine, Double>("get_time_scale")

  @JvmField
  public val getFramesDrawnName: MethodStringName0<Engine, Int> =
      MethodStringName0<Engine, Int>("get_frames_drawn")

  @JvmField
  public val getFramesPerSecondName: MethodStringName0<Engine, Double> =
      MethodStringName0<Engine, Double>("get_frames_per_second")

  @JvmField
  public val getPhysicsFramesName: MethodStringName0<Engine, Long> =
      MethodStringName0<Engine, Long>("get_physics_frames")

  @JvmField
  public val getProcessFramesName: MethodStringName0<Engine, Long> =
      MethodStringName0<Engine, Long>("get_process_frames")

  @JvmField
  public val getMainLoopName: MethodStringName0<Engine, MainLoop?> =
      MethodStringName0<Engine, MainLoop?>("get_main_loop")

  @JvmField
  public val getVersionInfoName: MethodStringName0<Engine, Dictionary<Any?, Any?>> =
      MethodStringName0<Engine, Dictionary<Any?, Any?>>("get_version_info")

  @JvmField
  public val getAuthorInfoName: MethodStringName0<Engine, Dictionary<Any?, Any?>> =
      MethodStringName0<Engine, Dictionary<Any?, Any?>>("get_author_info")

  @JvmField
  public val getCopyrightInfoName: MethodStringName0<Engine, VariantArray<Dictionary<Any?, Any?>>> =
      MethodStringName0<Engine, VariantArray<Dictionary<Any?, Any?>>>("get_copyright_info")

  @JvmField
  public val getDonorInfoName: MethodStringName0<Engine, Dictionary<Any?, Any?>> =
      MethodStringName0<Engine, Dictionary<Any?, Any?>>("get_donor_info")

  @JvmField
  public val getLicenseInfoName: MethodStringName0<Engine, Dictionary<Any?, Any?>> =
      MethodStringName0<Engine, Dictionary<Any?, Any?>>("get_license_info")

  @JvmField
  public val getLicenseTextName: MethodStringName0<Engine, String> =
      MethodStringName0<Engine, String>("get_license_text")

  @JvmField
  public val getArchitectureNameName: MethodStringName0<Engine, String> =
      MethodStringName0<Engine, String>("get_architecture_name")

  @JvmField
  public val isInPhysicsFrameName: MethodStringName0<Engine, Boolean> =
      MethodStringName0<Engine, Boolean>("is_in_physics_frame")

  @JvmField
  public val hasSingletonName: MethodStringName1<Engine, Boolean, StringName> =
      MethodStringName1<Engine, Boolean, StringName>("has_singleton")

  @JvmField
  public val getSingletonName: MethodStringName1<Engine, Object?, StringName> =
      MethodStringName1<Engine, Object?, StringName>("get_singleton")

  @JvmField
  public val registerSingletonName: MethodStringName2<Engine, Unit, StringName, Object> =
      MethodStringName2<Engine, Unit, StringName, Object>("register_singleton")

  @JvmField
  public val unregisterSingletonName: MethodStringName1<Engine, Unit, StringName> =
      MethodStringName1<Engine, Unit, StringName>("unregister_singleton")

  @JvmField
  public val getSingletonListName: MethodStringName0<Engine, PackedStringArray> =
      MethodStringName0<Engine, PackedStringArray>("get_singleton_list")

  @JvmField
  public val registerScriptLanguageName: MethodStringName1<Engine, Error, ScriptLanguage> =
      MethodStringName1<Engine, Error, ScriptLanguage>("register_script_language")

  @JvmField
  public val unregisterScriptLanguageName: MethodStringName1<Engine, Error, ScriptLanguage> =
      MethodStringName1<Engine, Error, ScriptLanguage>("unregister_script_language")

  @JvmField
  public val getScriptLanguageCountName: MethodStringName0<Engine, Int> =
      MethodStringName0<Engine, Int>("get_script_language_count")

  @JvmField
  public val getScriptLanguageName: MethodStringName1<Engine, ScriptLanguage?, Int> =
      MethodStringName1<Engine, ScriptLanguage?, Int>("get_script_language")

  @JvmField
  public val captureScriptBacktracesName:
      MethodStringName1<Engine, VariantArray<ScriptBacktrace>, Boolean> =
      MethodStringName1<Engine, VariantArray<ScriptBacktrace>, Boolean>("capture_script_backtraces")

  @JvmField
  public val isEditorHintName: MethodStringName0<Engine, Boolean> =
      MethodStringName0<Engine, Boolean>("is_editor_hint")

  @JvmField
  public val isEmbeddedInEditorName: MethodStringName0<Engine, Boolean> =
      MethodStringName0<Engine, Boolean>("is_embedded_in_editor")

  @JvmField
  public val getWriteMoviePathName: MethodStringName0<Engine, String> =
      MethodStringName0<Engine, String>("get_write_movie_path")

  @JvmField
  public val setPrintToStdoutName: MethodStringName1<Engine, Unit, Boolean> =
      MethodStringName1<Engine, Unit, Boolean>("set_print_to_stdout")

  @JvmField
  public val isPrintingToStdoutName: MethodStringName0<Engine, Boolean> =
      MethodStringName0<Engine, Boolean>("is_printing_to_stdout")

  @JvmField
  public val setPrintErrorMessagesName: MethodStringName1<Engine, Unit, Boolean> =
      MethodStringName1<Engine, Unit, Boolean>("set_print_error_messages")

  @JvmField
  public val isPrintingErrorMessagesName: MethodStringName0<Engine, Boolean> =
      MethodStringName0<Engine, Boolean>("is_printing_error_messages")

  /**
   * If `false`, stops printing error and warning messages to the console and editor Output log.
   * This can be used to hide error and warning messages during unit test suite runs. This property is
   * equivalent to the [ProjectSettings.application/run/disableStderr] project setting.
   *
   * **Note:** This property does not impact the editor's Errors tab when running a project from the
   * editor.
   *
   * **Warning:** If set to `false` anywhere in the project, important error messages may be hidden
   * even if they are emitted from other scripts. In a `@tool` script, this will also impact the editor
   * itself. Do *not* report bugs before ensuring error messages are enabled (as they are by default).
   */
  @JvmStatic
  public final inline var printErrorMessages: Boolean
    @JvmName("printErrorMessagesProperty")
    get() = isPrintingErrorMessages()
    @JvmName("printErrorMessagesProperty")
    set(`value`) {
      setPrintErrorMessages(value)
    }

  /**
   * If `false`, stops printing messages (for example using [@GlobalScope.print]) to the console,
   * log files, and editor Output log. This property is equivalent to the
   * [ProjectSettings.application/run/disableStdout] project setting.
   *
   * **Note:** This does not stop printing errors or warnings produced by scripts to the console or
   * log files, for more details see [printErrorMessages].
   */
  @JvmStatic
  public final inline var printToStdout: Boolean
    @JvmName("printToStdoutProperty")
    get() = isPrintingToStdout()
    @JvmName("printToStdoutProperty")
    set(`value`) {
      setPrintToStdout(value)
    }

  /**
   * The number of fixed iterations per second. This controls how often physics simulation and the
   * [Node.PhysicsProcess] method are run.
   *
   * CPU usage scales approximately with the physics tick rate. However, at very low tick rates
   * (usually below 30), physics behavior can break down. Input can also become less responsive at low
   * tick rates as there can be a gap between input being registered, and the response on the next
   * physics tick. High tick rates give more accurate physics simulation, particularly for fast moving
   * objects. For example, racing games may benefit from increasing the tick rate above the default 60.
   *
   * See also [maxFps] and [ProjectSettings.physics/common/physicsTicksPerSecond].
   *
   * **Note:** Only [maxPhysicsStepsPerFrame] physics ticks may be simulated per rendered frame at
   * most. If more physics ticks have to be simulated per rendered frame to keep up with rendering, the
   * project will appear to slow down (even if `delta` is used consistently in physics calculations).
   * Therefore, it is recommended to also increase [maxPhysicsStepsPerFrame] if increasing
   * [physicsTicksPerSecond] significantly above its default value.
   *
   * **Note:** Consider enabling [url=$DOCS_URL/tutorials/physics/interpolation/index.html]physics
   * interpolation[/url] if you change [physicsTicksPerSecond] to a value that is not a multiple of
   * `60`. Using physics interpolation will avoid jittering when the monitor refresh rate and physics
   * update rate don't exactly match.
   */
  @JvmStatic
  public final inline var physicsTicksPerSecond: Int
    @JvmName("physicsTicksPerSecondProperty")
    get() = getPhysicsTicksPerSecond()
    @JvmName("physicsTicksPerSecondProperty")
    set(`value`) {
      setPhysicsTicksPerSecond(value)
    }

  /**
   * The maximum number of physics steps that can be simulated each rendered frame.
   *
   * **Note:** The default value is tuned to prevent expensive physics simulations from triggering
   * even more expensive simulations indefinitely. However, the game will appear to slow down if the
   * rendering FPS is less than `1 / max_physics_steps_per_frame` of [physicsTicksPerSecond]. This
   * occurs even if `delta` is consistently used in physics calculations. To avoid this, increase
   * [maxPhysicsStepsPerFrame] if you have increased [physicsTicksPerSecond] significantly above its
   * default value.
   */
  @JvmStatic
  public final inline var maxPhysicsStepsPerFrame: Int
    @JvmName("maxPhysicsStepsPerFrameProperty")
    get() = getMaxPhysicsStepsPerFrame()
    @JvmName("maxPhysicsStepsPerFrameProperty")
    set(`value`) {
      setMaxPhysicsStepsPerFrame(value)
    }

  /**
   * The maximum number of frames that can be rendered every second (FPS). A value of `0` means the
   * framerate is uncapped.
   *
   * Limiting the FPS can be useful to reduce the host machine's power consumption, which reduces
   * heat, noise emissions, and improves battery life.
   *
   * If [ProjectSettings.display/window/vsync/vsyncMode] is **Enabled** or **Adaptive**, the setting
   * takes precedence and the max FPS number cannot exceed the monitor's refresh rate. See also
   * [DisplayServer.screenGetRefreshRate].
   *
   * If [ProjectSettings.display/window/vsync/vsyncMode] is **Enabled**, on monitors with variable
   * refresh rate enabled (G-Sync/FreeSync), using an FPS limit a few frames lower than the monitor's
   * refresh rate will [url=https://blurbusters.com/howto-low-lag-vsync-on/]reduce input lag while
   * avoiding tearing[/url]. At higher refresh rates, the difference between the FPS limit and the
   * monitor refresh rate should be increased to ensure frames to account for timing inaccuracies. The
   * optimal formula for the FPS limit value in this scenario is `r - (r * r) / 3600.0`, where `r` is
   * the monitor's refresh rate.
   *
   * **Note:** The actual number of frames per second may still be below this value if the CPU or
   * GPU cannot keep up with the project's logic and rendering.
   *
   * **Note:** If [ProjectSettings.display/window/vsync/vsyncMode] is **Disabled**, limiting the FPS
   * to a high value that can be consistently reached on the system can reduce input lag compared to an
   * uncapped framerate. Since this works by ensuring the GPU load is lower than 100&#37;, this latency
   * reduction is only effective in GPU-bottlenecked scenarios, not CPU-bottlenecked scenarios.
   */
  @JvmStatic
  public final inline var maxFps: Int
    @JvmName("maxFpsProperty")
    get() = getMaxFps()
    @JvmName("maxFpsProperty")
    set(`value`) {
      setMaxFps(value)
    }

  /**
   * The speed multiplier at which the in-game clock updates, compared to real time. For example, if
   * set to `2.0` the game runs twice as fast, and if set to `0.5` the game runs half as fast.
   *
   * This value affects [Timer], [SceneTreeTimer], and all other simulations that make use of
   * `delta` time (such as [Node.Process] and [Node.PhysicsProcess]).
   *
   * **Note:** It's recommended to keep this property above `0.0`, as the game may behave
   * unexpectedly otherwise.
   *
   * **Note:** This does not affect audio playback speed. Use [AudioServer.playbackSpeedScale] to
   * adjust audio playback speed independently of [Engine.timeScale].
   *
   * **Note:** This does not automatically adjust [physicsTicksPerSecond]. With values above `1.0`
   * physics simulation may become less precise, as each physics tick will stretch over a larger period
   * of engine time. If you're modifying [Engine.timeScale] to speed up simulation by a large factor,
   * consider also increasing [physicsTicksPerSecond] to make the simulation more reliable.
   */
  @JvmStatic
  public final inline var timeScale: Double
    @JvmName("timeScaleProperty")
    get() = getTimeScale()
    @JvmName("timeScaleProperty")
    set(`value`) {
      setTimeScale(value)
    }

  /**
   * How much physics ticks are synchronized with real time. If `0` or less, the ticks are fully
   * synchronized. Higher values cause the in-game clock to deviate more from the real clock, but they
   * smooth out framerate jitters.
   *
   * **Note:** The default value of `0.5` should be good enough for most cases; values above `2`
   * could cause the game to react to dropped frames with a noticeable delay and are not recommended.
   *
   * **Note:** When using a custom physics interpolation solution, or within a network game, it's
   * recommended to disable the physics jitter fix by setting this property to `0`.
   */
  @JvmStatic
  public final inline var physicsJitterFix: Double
    @JvmName("physicsJitterFixProperty")
    get() = getPhysicsJitterFix()
    @JvmName("physicsJitterFixProperty")
    set(`value`) {
      setPhysicsJitterFix(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(5)
  }

  @JvmStatic
  public final fun setPhysicsTicksPerSecond(physicsTicksPerSecond: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to physicsTicksPerSecond.toLong())
    TransferContext.callMethod(MethodBindings.setPhysicsTicksPerSecondPtr)
  }

  @JvmStatic
  public final fun getPhysicsTicksPerSecond(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsTicksPerSecondPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  @JvmStatic
  public final fun setMaxPhysicsStepsPerFrame(maxPhysicsSteps: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxPhysicsSteps.toLong())
    TransferContext.callMethod(MethodBindings.setMaxPhysicsStepsPerFramePtr)
  }

  @JvmStatic
  public final fun getMaxPhysicsStepsPerFrame(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxPhysicsStepsPerFramePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  @JvmStatic
  public final fun setPhysicsJitterFix(physicsJitterFix: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to physicsJitterFix)
    TransferContext.callMethod(MethodBindings.setPhysicsJitterFixPtr)
  }

  @JvmStatic
  public final fun getPhysicsJitterFix(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsJitterFixPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns the fraction through the current physics tick we are at the time of rendering the
   * frame. This can be used to implement fixed timestep interpolation.
   */
  @JvmStatic
  public final fun getPhysicsInterpolationFraction(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsInterpolationFractionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  @JvmStatic
  public final fun setMaxFps(maxFps: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxFps.toLong())
    TransferContext.callMethod(MethodBindings.setMaxFpsPtr)
  }

  @JvmStatic
  public final fun getMaxFps(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxFpsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  @JvmStatic
  public final fun setTimeScale(timeScale: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to timeScale)
    TransferContext.callMethod(MethodBindings.setTimeScalePtr)
  }

  @JvmStatic
  public final fun getTimeScale(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTimeScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns the total number of frames drawn since the engine started.
   *
   * **Note:** On headless platforms, or if rendering is disabled with `--disable-render-loop` via
   * command line, this method always returns `0`. See also [getProcessFrames].
   */
  @JvmStatic
  public final fun getFramesDrawn(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFramesDrawnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the average frames rendered every second (FPS), also known as the framerate.
   */
  @JvmStatic
  public final fun getFramesPerSecond(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFramesPerSecondPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns the total number of frames passed since the engine started. This number is increased
   * every **physics frame**. See also [getProcessFrames].
   *
   * This method can be used to run expensive logic less often without relying on a [Timer]:
   *
   * ```gdscript
   * //gdscript
   * func _physics_process(_delta):
   * 	if Engine.get_physics_frames() &#37; 2 == 0:
   * 		pass # Run expensive logic only once every 2 physics frames here.
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _PhysicsProcess(double delta)
   * {
   * 	base._PhysicsProcess(delta);
   *
   * 	if (Engine.GetPhysicsFrames() &#37; 2 == 0)
   * 	{
   * 		// Run expensive logic only once every 2 physics frames here.
   * 	}
   * }
   * ```
   */
  @JvmStatic
  public final fun getPhysicsFrames(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsFramesPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the total number of frames passed since the engine started. This number is increased
   * every **process frame**, regardless of whether the render loop is enabled. See also
   * [getFramesDrawn] and [getPhysicsFrames].
   *
   * This method can be used to run expensive logic less often without relying on a [Timer]:
   *
   * ```gdscript
   * //gdscript
   * func _process(_delta):
   * 	if Engine.get_process_frames() &#37; 5 == 0:
   * 		pass # Run expensive logic only once every 5 process (render) frames here.
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Process(double delta)
   * {
   * 	base._Process(delta);
   *
   * 	if (Engine.GetProcessFrames() &#37; 5 == 0)
   * 	{
   * 		// Run expensive logic only once every 5 process (render) frames here.
   * 	}
   * }
   * ```
   */
  @JvmStatic
  public final fun getProcessFrames(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProcessFramesPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the instance of the [MainLoop]. This is usually the main [SceneTree] and is the same as
   * [Node.getTree].
   *
   * **Note:** The type instantiated as the main loop can changed with
   * [ProjectSettings.application/run/mainLoopType].
   */
  @JvmStatic
  public final fun getMainLoop(): MainLoop? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMainLoopPtr)
    return (TransferContext.readReturnValue(OBJECT) as MainLoop?)
  }

  /**
   * Returns the current engine version information as a [Dictionary] containing the following
   * entries:
   *
   * - `major` - Major version number as an int;
   *
   * - `minor` - Minor version number as an int;
   *
   * - `patch` - Patch version number as an int;
   *
   * - `hex` - Full version encoded as a hexadecimal int with one byte (2 hex digits) per number
   * (see example below);
   *
   * - `status` - Status (such as "beta", "rc1", "rc2", "stable", etc.) as a String;
   *
   * - `build` - Build name (e.g. "custom_build") as a String;
   *
   * - `hash` - Full Git commit hash as a String;
   *
   * - `timestamp` - Holds the Git commit date UNIX timestamp in seconds as an int, or `0` if
   * unavailable;
   *
   * - `string` - `major`, `minor`, `patch`, `status`, and `build` in a single String.
   *
   * The `hex` value is encoded as follows, from left to right: one byte for the major, one byte for
   * the minor, one byte for the patch version. For example, "3.1.12" would be `0x03010C`.
   *
   * **Note:** The `hex` value is still an [Long] internally, and printing it will give you its
   * decimal representation, which is not particularly meaningful. Use hexadecimal literals for quick
   * version comparisons from code:
   *
   * ```gdscript
   * //gdscript
   * if Engine.get_version_info().hex >= 0x040100:
   * 	pass # Do things specific to version 4.1 or later.
   * else:
   * 	pass # Do things specific to versions before 4.1.
   * ```
   *
   * ```csharp
   * //csharp
   * if ((int)Engine.GetVersionInfo()["hex"] >= 0x040100)
   * {
   * 	// Do things specific to version 4.1 or later.
   * }
   * else
   * {
   * 	// Do things specific to versions before 4.1.
   * }
   * ```
   */
  @JvmStatic
  public final fun getVersionInfo(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVersionInfoPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns the engine author information as a [Dictionary], where each entry is an [VariantArray]
   * of strings with the names of notable contributors to the Godot Engine: `lead_developers`,
   * `founders`, `project_managers`, and `developers`.
   */
  @JvmStatic
  public final fun getAuthorInfo(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAuthorInfoPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns an [VariantArray] of dictionaries with copyright information for every component of
   * Godot's source code.
   *
   * Every [Dictionary] contains a `name` identifier, and a `parts` array of dictionaries. It
   * describes the component in detail with the following entries:
   *
   * - `files` - [VariantArray] of file paths from the source code affected by this component;
   *
   * - `copyright` - [VariantArray] of owners of this component;
   *
   * - `license` - The license applied to this component (such as
   * "[url=https://en.wikipedia.org/wiki/MIT_License#Ambiguity_and_variants]Expat[/url]" or
   * "[url=https://creativecommons.org/licenses/by/4.0/]CC-BY-4.0[/url]").
   */
  @JvmStatic
  public final fun getCopyrightInfo(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCopyrightInfoPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns a [Dictionary] of categorized donor names. Each entry is an [VariantArray] of strings:
   *
   * {`platinum_sponsors`, `gold_sponsors`, `silver_sponsors`, `bronze_sponsors`, `mini_sponsors`,
   * `gold_donors`, `silver_donors`, `bronze_donors`}
   */
  @JvmStatic
  public final fun getDonorInfo(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDonorInfoPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns a [Dictionary] of licenses used by Godot and included third party components. Each
   * entry is a license name (such as
   * "[url=https://en.wikipedia.org/wiki/MIT_License#Ambiguity_and_variants]Expat[/url]") and its
   * associated text.
   */
  @JvmStatic
  public final fun getLicenseInfo(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLicenseInfoPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns the full Godot license text.
   */
  @JvmStatic
  public final fun getLicenseText(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLicenseTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the CPU architecture the Godot binary was built for. Possible return values
   * include `"x86_64"`, `"x86_32"`, `"arm64"`, `"arm32"`, `"rv64"`, `"ppc64"`, `"loongarch64"`,
   * `"wasm64"`, and `"wasm32"`.
   *
   * To detect whether the current build is 64-bit, or the type of architecture, don't use the
   * architecture name. Instead, use [OS.hasFeature] to check for the `"64"` feature tag, or tags such
   * as `"x86"` or `"arm"`. See the [url=$DOCS_URL/tutorials/export/feature_tags.html]Feature
   * Tags[/url] documentation for more details.
   *
   * **Note:** This method does *not* return the name of the system's CPU architecture (like
   * [OS.getProcessorName]). For example, when running an `x86_32` Godot binary on an `x86_64` system,
   * the returned value will still be `"x86_32"`.
   */
  @JvmStatic
  public final fun getArchitectureName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getArchitectureNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the engine is inside the fixed physics process step of the main loop.
   *
   * ```
   * func _enter_tree():
   * 	# Depending on when the node is added to the tree,
   * 	# prints either "true" or "false".
   * 	print(Engine.is_in_physics_frame())
   *
   * func _process(delta):
   * 	print(Engine.is_in_physics_frame()) # Prints false
   *
   * func _physics_process(delta):
   * 	print(Engine.is_in_physics_frame()) # Prints true
   * ```
   */
  @JvmStatic
  public final fun isInPhysicsFrame(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isInPhysicsFramePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if a singleton with the given [name] exists in the global scope. See also
   * [getSingleton].
   *
   * ```gdscript
   * //gdscript
   * print(Engine.has_singleton("OS"))          # Prints true
   * print(Engine.has_singleton("Engine"))      # Prints true
   * print(Engine.has_singleton("AudioServer")) # Prints true
   * print(Engine.has_singleton("Unknown"))     # Prints false
   * ```
   *
   * ```csharp
   * //csharp
   * GD.Print(Engine.HasSingleton("OS"));          // Prints True
   * GD.Print(Engine.HasSingleton("Engine"));      // Prints True
   * GD.Print(Engine.HasSingleton("AudioServer")); // Prints True
   * GD.Print(Engine.HasSingleton("Unknown"));     // Prints False
   * ```
   *
   * **Note:** Global singletons are not the same as autoloaded nodes, which are configurable in the
   * project settings.
   */
  @JvmStatic
  public final fun hasSingleton(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasSingletonPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the global singleton with the given [name], or `null` if it does not exist. Often used
   * for plugins. See also [hasSingleton] and [getSingletonList].
   *
   * **Note:** Global singletons are not the same as autoloaded nodes, which are configurable in the
   * project settings.
   */
  @JvmStatic
  public final fun getSingleton(name: StringName): Object? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getSingletonPtr)
    return (TransferContext.readReturnValue(OBJECT) as Object?)
  }

  /**
   * Registers the given [Object] [instance] as a singleton, available globally under [name]. Useful
   * for plugins.
   */
  @JvmStatic
  public final fun registerSingleton(name: StringName, instance: Object): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to instance)
    TransferContext.callMethod(MethodBindings.registerSingletonPtr)
  }

  /**
   * Removes the singleton registered under [name]. The singleton object is *not* freed. Only works
   * with user-defined singletons registered with [registerSingleton].
   */
  @JvmStatic
  public final fun unregisterSingleton(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.unregisterSingletonPtr)
  }

  /**
   * Returns a list of names of all available global singletons. See also [getSingleton].
   */
  @JvmStatic
  public final fun getSingletonList(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSingletonListPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Registers a [ScriptLanguage] instance to be available with `ScriptServer`.
   *
   * Returns:
   *
   * - [OK] on success;
   *
   * - [ERR_UNAVAILABLE] if `ScriptServer` has reached the limit and cannot register any new
   * language;
   *
   * - [ERR_ALREADY_EXISTS] if `ScriptServer` already contains a language with similar
   * extension/name/type.
   */
  @JvmStatic
  public final fun registerScriptLanguage(language: ScriptLanguage): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to language)
    TransferContext.callMethod(MethodBindings.registerScriptLanguagePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Unregisters the [ScriptLanguage] instance from `ScriptServer`.
   *
   * Returns:
   *
   * - [OK] on success;
   *
   * - [ERR_DOES_NOT_EXIST] if the language is not registered in `ScriptServer`.
   */
  @JvmStatic
  public final fun unregisterScriptLanguage(language: ScriptLanguage): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to language)
    TransferContext.callMethod(MethodBindings.unregisterScriptLanguagePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the number of available script languages. Use with [getScriptLanguage].
   */
  @JvmStatic
  public final fun getScriptLanguageCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScriptLanguageCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns an instance of a [ScriptLanguage] with the given [index].
   */
  @JvmStatic
  public final fun getScriptLanguage(index: Int): ScriptLanguage? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getScriptLanguagePtr)
    return (TransferContext.readReturnValue(OBJECT) as ScriptLanguage?)
  }

  /**
   * Captures and returns backtraces from all registered script languages.
   *
   * By default, the returned [ScriptBacktrace] will only contain stack frames in editor builds and
   * debug builds. To enable them for release builds as well, you need to enable
   * [ProjectSettings.debug/settings/gdscript/alwaysTrackCallStacks].
   *
   * If [includeVariables] is `true`, the backtrace will also include the names and values of any
   * global variables (e.g. autoload singletons) at the point of the capture, as well as local
   * variables and class member variables at each stack frame. This will however will only be respected
   * when running the game with a debugger attached, like when running the game from the editor. To
   * enable it for export builds as well, you need to enable
   * [ProjectSettings.debug/settings/gdscript/alwaysTrackLocalVariables].
   *
   * **Warning:** When [includeVariables] is `true`, any captured variables can potentially (e.g.
   * with GDScript backtraces) be their actual values, including any object references. This means that
   * storing such a [ScriptBacktrace] will prevent those objects from being deallocated, so it's
   * generally recommended not to do so.
   */
  @JvmOverloads
  @JvmStatic
  public final fun captureScriptBacktraces(includeVariables: Boolean = false):
      VariantArray<ScriptBacktrace> {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to includeVariables)
    TransferContext.callMethod(MethodBindings.captureScriptBacktracesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<ScriptBacktrace>)
  }

  /**
   * Returns `true` if the script is currently running inside the editor, otherwise returns `false`.
   * This is useful for `@tool` scripts to conditionally draw editor helpers, or prevent accidentally
   * running "game" code that would affect the scene state while in the editor:
   *
   * ```gdscript
   * //gdscript
   * if Engine.is_editor_hint():
   * 	draw_gizmos()
   * else:
   * 	simulate_physics()
   * ```
   *
   * ```csharp
   * //csharp
   * if (Engine.IsEditorHint())
   * 	DrawGizmos();
   * else
   * 	SimulatePhysics();
   * ```
   *
   * See [url=$DOCS_URL/tutorials/plugins/running_code_in_the_editor.html]Running code in the
   * editor[/url] in the documentation for more information.
   *
   * **Note:** To detect whether the script is running on an editor *build* (such as when pressing
   * [kbd]F5[/kbd]), use [OS.hasFeature] with the `"editor"` argument instead.
   * `OS.has_feature("editor")` evaluate to `true` both when the script is running in the editor and
   * when running the project from the editor, but returns `false` when run from an exported project.
   */
  @JvmStatic
  public final fun isEditorHint(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEditorHintPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the engine is running embedded in the editor. This is useful to prevent
   * attempting to update window mode or window flags that are not supported when running the project
   * embedded in the editor.
   */
  @JvmStatic
  public final fun isEmbeddedInEditor(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmbeddedInEditorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the path to the [MovieWriter]'s output file, or an empty string if the engine wasn't
   * started in Movie Maker mode. The default path can be changed in
   * [ProjectSettings.editor/movieWriter/movieFile].
   */
  @JvmStatic
  public final fun getWriteMoviePath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWriteMoviePathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  @JvmStatic
  public final fun setPrintToStdout(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setPrintToStdoutPtr)
  }

  @JvmStatic
  public final fun isPrintingToStdout(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPrintingToStdoutPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  @JvmStatic
  public final fun setPrintErrorMessages(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setPrintErrorMessagesPtr)
  }

  @JvmStatic
  public final fun isPrintingErrorMessages(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPrintingErrorMessagesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if a singleton with the given [name] exists in the global scope. See also
   * [getSingleton].
   *
   * ```gdscript
   * //gdscript
   * print(Engine.has_singleton("OS"))          # Prints true
   * print(Engine.has_singleton("Engine"))      # Prints true
   * print(Engine.has_singleton("AudioServer")) # Prints true
   * print(Engine.has_singleton("Unknown"))     # Prints false
   * ```
   *
   * ```csharp
   * //csharp
   * GD.Print(Engine.HasSingleton("OS"));          // Prints True
   * GD.Print(Engine.HasSingleton("Engine"));      // Prints True
   * GD.Print(Engine.HasSingleton("AudioServer")); // Prints True
   * GD.Print(Engine.HasSingleton("Unknown"));     // Prints False
   * ```
   *
   * **Note:** Global singletons are not the same as autoloaded nodes, which are configurable in the
   * project settings.
   */
  @JvmStatic
  public final fun hasSingleton(name: String): Boolean = hasSingleton(name.asCachedStringName())

  /**
   * Returns the global singleton with the given [name], or `null` if it does not exist. Often used
   * for plugins. See also [hasSingleton] and [getSingletonList].
   *
   * **Note:** Global singletons are not the same as autoloaded nodes, which are configurable in the
   * project settings.
   */
  @JvmStatic
  public final fun getSingleton(name: String): Object? = getSingleton(name.asCachedStringName())

  /**
   * Registers the given [Object] [instance] as a singleton, available globally under [name]. Useful
   * for plugins.
   */
  @JvmStatic
  public final fun registerSingleton(name: String, instance: Object) =
      registerSingleton(name.asCachedStringName(), instance)

  /**
   * Removes the singleton registered under [name]. The singleton object is *not* freed. Only works
   * with user-defined singletons registered with [registerSingleton].
   */
  @JvmStatic
  public final fun unregisterSingleton(name: String) =
      unregisterSingleton(name.asCachedStringName())

  public object MethodBindings {
    internal val setPhysicsTicksPerSecondPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "set_physics_ticks_per_second", 1286410249)

    internal val getPhysicsTicksPerSecondPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_physics_ticks_per_second", 3905245786)

    internal val setMaxPhysicsStepsPerFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "set_max_physics_steps_per_frame", 1286410249)

    internal val getMaxPhysicsStepsPerFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_max_physics_steps_per_frame", 3905245786)

    internal val setPhysicsJitterFixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "set_physics_jitter_fix", 373806689)

    internal val getPhysicsJitterFixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_physics_jitter_fix", 1740695150)

    internal val getPhysicsInterpolationFractionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_physics_interpolation_fraction", 1740695150)

    internal val setMaxFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "set_max_fps", 1286410249)

    internal val getMaxFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_max_fps", 3905245786)

    internal val setTimeScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "set_time_scale", 373806689)

    internal val getTimeScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_time_scale", 191475506)

    internal val getFramesDrawnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_frames_drawn", 2455072627)

    internal val getFramesPerSecondPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_frames_per_second", 1740695150)

    internal val getPhysicsFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_physics_frames", 3905245786)

    internal val getProcessFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_process_frames", 3905245786)

    internal val getMainLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_main_loop", 1016888095)

    internal val getVersionInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_version_info", 3102165223)

    internal val getAuthorInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_author_info", 3102165223)

    internal val getCopyrightInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_copyright_info", 3995934104)

    internal val getDonorInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_donor_info", 3102165223)

    internal val getLicenseInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_license_info", 3102165223)

    internal val getLicenseTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_license_text", 201670096)

    internal val getArchitectureNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_architecture_name", 201670096)

    internal val isInPhysicsFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "is_in_physics_frame", 36873697)

    internal val hasSingletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "has_singleton", 2619796661)

    internal val getSingletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_singleton", 1371597918)

    internal val registerSingletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "register_singleton", 965313290)

    internal val unregisterSingletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "unregister_singleton", 3304788590)

    internal val getSingletonListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_singleton_list", 1139954409)

    internal val registerScriptLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "register_script_language", 1850254898)

    internal val unregisterScriptLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "unregister_script_language", 1850254898)

    internal val getScriptLanguageCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_script_language_count", 2455072627)

    internal val getScriptLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_script_language", 2151255799)

    internal val captureScriptBacktracesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "capture_script_backtraces", 873284517)

    internal val isEditorHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "is_editor_hint", 36873697)

    internal val isEmbeddedInEditorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "is_embedded_in_editor", 36873697)

    internal val getWriteMoviePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "get_write_movie_path", 201670096)

    internal val setPrintToStdoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "set_print_to_stdout", 2586408642)

    internal val isPrintingToStdoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "is_printing_to_stdout", 36873697)

    internal val setPrintErrorMessagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "set_print_error_messages", 2586408642)

    internal val isPrintingErrorMessagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Engine", "is_printing_error_messages", 36873697)
  }
}
