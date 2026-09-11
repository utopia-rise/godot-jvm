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
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.NodePath
import godot.core.Signal0
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedNodePath
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

/**
 * As one of the most important classes, the [SceneTree] manages the hierarchy of nodes in a scene,
 * as well as scenes themselves. Nodes can be added, fetched and removed. The whole scene tree (and
 * thus the current scene) can be paused. Scenes can be loaded, switched and reloaded.
 *
 * You can also use the [SceneTree] to organize your nodes into **groups**: every node can be added
 * to as many groups as you want to create, e.g. an "enemy" group. You can then iterate these groups or
 * even call methods and set properties on all the nodes belonging to any given group.
 *
 * [SceneTree] is the default [MainLoop] implementation used by the engine, and is thus in charge of
 * the game loop.
 */
@GodotBaseType
public open class SceneTree : MainLoop() {
  /**
   * Emitted any time the tree's hierarchy changes (nodes being moved, renamed, etc.).
   */
  public val treeChanged: Signal0 by Signal0

  /**
   * Emitted after the new scene is added to scene tree and initialized. Can be used to reliably
   * access [currentScene] when changing scenes.
   *
   * ```
   * # This code should be inside an autoload.
   * get_tree().change_scene_to_file(other_scene_path)
   * await get_tree().scene_changed
   * print(get_tree().current_scene) # Prints the new scene.
   * ```
   */
  public val sceneChanged: Signal0 by Signal0

  /**
   * Emitted when the [Node.processMode] of any node inside the tree is changed. Only emitted in the
   * editor, to update the visibility of disabled nodes.
   */
  public val treeProcessModeChanged: Signal0 by Signal0

  /**
   * Emitted when the [node] enters this tree.
   */
  public val nodeAdded: Signal1<Node> by Signal1

  /**
   * Emitted when the [node] exits this tree.
   */
  public val nodeRemoved: Signal1<Node> by Signal1

  /**
   * Emitted when the [node]'s [Node.name] is changed.
   */
  public val nodeRenamed: Signal1<Node> by Signal1

  /**
   * Emitted when the [node]'s [Node.updateConfigurationWarnings] is called. Only emitted in the
   * editor.
   */
  public val nodeConfigurationWarningChanged: Signal1<Node> by Signal1

  /**
   * Emitted immediately before [Node.Process] is called on every node in this tree.
   */
  public val processFrame: Signal0 by Signal0

  /**
   * Emitted immediately before [Node.PhysicsProcess] is called on every node in this tree.
   */
  public val physicsFrame: Signal0 by Signal0

  /**
   * If `true`, the application automatically accepts quitting requests.
   *
   * For mobile platforms, see [quitOnGoBack].
   */
  public final inline var autoAcceptQuit: Boolean
    @JvmName("autoAcceptQuitProperty")
    get() = isAutoAcceptQuit()
    @JvmName("autoAcceptQuitProperty")
    set(`value`) {
      setAutoAcceptQuit(value)
    }

  /**
   * If `true`, the application quits automatically when navigating back (e.g. using the system
   * "Back" button on Android).
   *
   * To handle 'Go Back' button when this option is disabled, use
   * [DisplayServer.WINDOW_EVENT_GO_BACK_REQUEST].
   */
  public final inline var quitOnGoBack: Boolean
    @JvmName("quitOnGoBackProperty")
    get() = isQuitOnGoBack()
    @JvmName("quitOnGoBackProperty")
    set(`value`) {
      setQuitOnGoBack(value)
    }

  /**
   * If `true`, collision shapes will be visible when running the game from the editor for debugging
   * purposes.
   *
   * **Note:** This property is not designed to be changed at run-time. Changing the value of
   * [debugCollisionsHint] while the project is running will not have the desired effect.
   */
  public final inline var debugCollisionsHint: Boolean
    @JvmName("debugCollisionsHintProperty")
    get() = isDebuggingCollisionsHint()
    @JvmName("debugCollisionsHintProperty")
    set(`value`) {
      setDebugCollisionsHint(value)
    }

  /**
   * If `true`, curves from [Path2D] and [Path3D] nodes will be visible when running the game from
   * the editor for debugging purposes.
   *
   * **Note:** This property is not designed to be changed at run-time. Changing the value of
   * [debugPathsHint] while the project is running will not have the desired effect.
   */
  public final inline var debugPathsHint: Boolean
    @JvmName("debugPathsHintProperty")
    get() = isDebuggingPathsHint()
    @JvmName("debugPathsHintProperty")
    set(`value`) {
      setDebugPathsHint(value)
    }

  /**
   * If `true`, navigation polygons will be visible when running the game from the editor for
   * debugging purposes.
   *
   * **Note:** This property is not designed to be changed at run-time. Changing the value of
   * [debugNavigationHint] while the project is running will not have the desired effect.
   */
  public final inline var debugNavigationHint: Boolean
    @JvmName("debugNavigationHintProperty")
    get() = isDebuggingNavigationHint()
    @JvmName("debugNavigationHintProperty")
    set(`value`) {
      setDebugNavigationHint(value)
    }

  /**
   * If `true`, the scene tree is considered paused. This causes the following behavior:
   *
   * - 2D and 3D physics will be stopped, as well as collision detection and related signals.
   *
   * - Depending on each node's [Node.processMode], their [Node.Process], [Node.PhysicsProcess] and
   * [Node.Input] callback methods may not called anymore.
   */
  public final inline var paused: Boolean
    @JvmName("pausedProperty")
    get() = isPaused()
    @JvmName("pausedProperty")
    set(`value`) {
      setPause(value)
    }

  /**
   * The root of the scene currently being edited in the editor. This is usually a direct child of
   * [root].
   *
   * **Note:** This property does nothing in release builds.
   */
  public final inline var editedSceneRoot: Node?
    @JvmName("editedSceneRootProperty")
    get() = getEditedSceneRoot()
    @JvmName("editedSceneRootProperty")
    set(`value`) {
      setEditedSceneRoot(value)
    }

  /**
   * The root node of the currently loaded main scene, usually as a direct child of [root]. See also
   * [changeSceneToFile], [changeSceneToPacked], and [reloadCurrentScene].
   *
   * **Warning:** Setting this property directly may not work as expected, as it does *not* add or
   * remove any nodes from this tree.
   */
  public final inline var currentScene: Node?
    @JvmName("currentSceneProperty")
    get() = getCurrentScene()
    @JvmName("currentSceneProperty")
    set(`value`) {
      setCurrentScene(value)
    }

  /**
   * The tree's root [Window]. This is top-most [Node] of the scene tree, and is always present. An
   * absolute [NodePath] always starts from this node. Children of the root node may include the loaded
   * [currentScene], as well as any
   * [url=$DOCS_URL/tutorials/scripting/singletons_autoload.html]AutoLoad[/url] configured in the
   * Project Settings.
   *
   * **Warning:** Do not delete this node. This will result in unstable behavior, followed by a
   * crash.
   */
  public final inline val root: Window
    @JvmName("rootProperty")
    get() = getRoot()

  /**
   * If `true` (default value), enables automatic polling of the [MultiplayerAPI] for this SceneTree
   * during [signal process_frame].
   *
   * If `false`, you need to manually call [MultiplayerAPI.poll] to process network packets and
   * deliver RPCs. This allows running RPCs in a different loop (e.g. physics, thread, specific time
   * step) and for manual [Mutex] protection when accessing the [MultiplayerAPI] from threads.
   */
  public final inline var multiplayerPoll: Boolean
    @JvmName("multiplayerPollProperty")
    get() = isMultiplayerPollEnabled()
    @JvmName("multiplayerPollProperty")
    set(`value`) {
      setMultiplayerPollEnabled(value)
    }

  /**
   * If `true`, the renderer will interpolate the transforms of objects (both physics and
   * non-physics) between the last two transforms, so that smooth motion is seen even when physics
   * ticks do not coincide with rendered frames.
   *
   * The default value of this property is controlled by
   * [ProjectSettings.physics/common/physicsInterpolation].
   *
   * **Note:** Although this is a global setting, finer control of individual branches of the
   * [SceneTree] is possible using [Node.physicsInterpolationMode].
   */
  public final inline var physicsInterpolation: Boolean
    @JvmName("physicsInterpolationProperty")
    get() = isPhysicsInterpolationEnabled()
    @JvmName("physicsInterpolationProperty")
    set(`value`) {
      setPhysicsInterpolationEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(640, scriptPtr)
  }

  public final fun getRoot(): Window {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootPtr)
    return (TransferContext.readReturnValue(OBJECT) as Window)
  }

  /**
   * Returns `true` if a node added to the given group [name] exists in the tree.
   */
  public final fun hasGroup(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasGroupPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if accessibility features are enabled, and accessibility information updates are
   * actively processed.
   */
  public final fun isAccessibilityEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAccessibilityEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if accessibility features are supported by the OS and enabled in project
   * settings.
   */
  public final fun isAccessibilitySupported(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAccessibilitySupportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun isAutoAcceptQuit(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAutoAcceptQuitPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutoAcceptQuit(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAutoAcceptQuitPtr)
  }

  public final fun isQuitOnGoBack(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isQuitOnGoBackPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setQuitOnGoBack(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setQuitOnGoBackPtr)
  }

  public final fun setDebugCollisionsHint(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDebugCollisionsHintPtr)
  }

  public final fun isDebuggingCollisionsHint(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDebuggingCollisionsHintPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDebugPathsHint(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDebugPathsHintPtr)
  }

  public final fun isDebuggingPathsHint(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDebuggingPathsHintPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDebugNavigationHint(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDebugNavigationHintPtr)
  }

  public final fun isDebuggingNavigationHint(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDebuggingNavigationHintPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setEditedSceneRoot(scene: Node?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to scene)
    TransferContext.callMethod(MethodBindings.setEditedSceneRootPtr)
  }

  public final fun getEditedSceneRoot(): Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEditedSceneRootPtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  public final fun setPause(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setPausePtr)
  }

  public final fun isPaused(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPausedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a new [SceneTreeTimer]. After [timeSec] in seconds have passed, the timer will emit
   * [signal SceneTreeTimer.timeout] and will be automatically freed.
   *
   * If [processAlways] is `false`, the timer will be paused when setting [SceneTree.paused] to
   * `true`.
   *
   * If [processInPhysics] is `true`, the timer will update at the end of the physics frame, instead
   * of the process frame.
   *
   * If [ignoreTimeScale] is `true`, the timer will ignore [Engine.timeScale] and update with the
   * real, elapsed time.
   *
   * This method is commonly used to create a one-shot delay timer, as in the following example:
   *
   * ```gdscript
   * //gdscript
   * func some_function():
   * 	print("start")
   * 	await get_tree().create_timer(1.0).timeout
   * 	print("end")
   * ```
   *
   * ```csharp
   * //csharp
   * public async Task SomeFunction()
   * {
   * 	GD.Print("start");
   * 	await ToSignal(GetTree().CreateTimer(1.0f), SceneTreeTimer.SignalName.Timeout);
   * 	GD.Print("end");
   * }
   * ```
   *
   * **Note:** The timer is always updated *after* all of the nodes in the tree. A node's
   * [Node.Process] method would be called before the timer updates (or [Node.PhysicsProcess] if
   * [processInPhysics] is set to `true`).
   */
  @JvmOverloads
  public final fun createTimer(
    timeSec: Double,
    processAlways: Boolean = true,
    processInPhysics: Boolean = false,
    ignoreTimeScale: Boolean = false,
  ): SceneTreeTimer {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to timeSec, BOOL to processAlways, BOOL to processInPhysics, BOOL to ignoreTimeScale)
    TransferContext.callMethod(MethodBindings.createTimerPtr)
    return (TransferContext.readReturnValue(OBJECT) as SceneTreeTimer)
  }

  /**
   * Creates and returns a new [Tween] processed in this tree. The Tween will start automatically on
   * the next process frame or physics frame (depending on its [Tween.TweenProcessMode]).
   *
   * **Note:** A [Tween] created using this method is not bound to any [Node]. It may keep working
   * until there is nothing left to animate. If you want the [Tween] to be automatically killed when
   * the [Node] is freed, use [Node.createTween] or [Tween.bindNode].
   */
  public final fun createTween(): Tween {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createTweenPtr)
    return (TransferContext.readReturnValue(OBJECT) as Tween)
  }

  /**
   * Returns an [VariantArray] of currently existing [Tween]s in the tree, including paused tweens.
   */
  public final fun getProcessedTweens(): VariantArray<Tween> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProcessedTweensPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Tween>)
  }

  /**
   * Returns the number of nodes inside this tree.
   */
  public final fun getNodeCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNodeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns how many physics process steps have been processed, since the application started. This
   * is *not* a measurement of elapsed time. See also [signal physics_frame]. For the number of frames
   * rendered, see [Engine.getProcessFrames].
   */
  public final fun getFrame(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFramePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Quits the application at the end of the current iteration, with the given [exitCode].
   *
   * By convention, an exit code of `0` indicates success, whereas any other exit code indicates an
   * error. For portability reasons, it should be between `0` and `125` (inclusive).
   *
   * **Note:** On iOS this method doesn't work. Instead, as recommended by the
   * [url=https://developer.apple.com/library/archive/qa/qa1561/_index.html]iOS Human Interface
   * Guidelines[/url], the user is expected to close apps via the Home button.
   */
  @JvmOverloads
  public final fun quit(exitCode: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to exitCode.toLong())
    TransferContext.callMethod(MethodBindings.quitPtr)
  }

  public final fun setPhysicsInterpolationEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setPhysicsInterpolationEnabledPtr)
  }

  public final fun isPhysicsInterpolationEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPhysicsInterpolationEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Queues the given [obj] to be deleted, calling its [Object.free] at the end of the current
   * frame. This method is similar to [Node.queueFree].
   */
  public final fun queueDelete(obj: Object): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to obj)
    TransferContext.callMethod(MethodBindings.queueDeletePtr)
  }

  /**
   * Calls the given [method] on each node inside this tree added to the given [group]. Use [flags]
   * to customize this method's behavior (see [GroupCallFlags]). Additional arguments for [method] can
   * be passed at the end of this method. Nodes that cannot call [method] (either because the method
   * doesn't exist or the arguments do not match) are ignored.
   *
   * ```
   * # Calls "hide" to all nodes of the "enemies" group, at the end of the frame and in reverse tree
   * order.
   * get_tree().call_group_flags(
   * 		SceneTree.GROUP_CALL_DEFERRED | SceneTree.GROUP_CALL_REVERSE,
   * 		"enemies", "hide")
   * ```
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun callGroupFlags(
    flags: Long,
    group: StringName,
    method: StringName,
    vararg args: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flags, STRING_NAME to group, STRING_NAME to method, *args.map { ANY to it }.toTypedArray())
    TransferContext.callMethod(MethodBindings.callGroupFlagsPtr)
  }

  /**
   * Calls [Object.notification] with the given [notification] to all nodes inside this tree added
   * to the [group]. Use [callFlags] to customize this method's behavior (see [GroupCallFlags]).
   */
  public final fun notifyGroupFlags(
    callFlags: Long,
    group: StringName,
    notification: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to callFlags, STRING_NAME to group, LONG to notification.toLong())
    TransferContext.callMethod(MethodBindings.notifyGroupFlagsPtr)
  }

  /**
   * Sets the given [property] to [value] on all nodes inside this tree added to the given [group].
   * Nodes that do not have the [property] are ignored. Use [callFlags] to customize this method's
   * behavior (see [GroupCallFlags]).
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun setGroupFlags(
    callFlags: Long,
    group: StringName,
    `property`: String,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to callFlags, STRING_NAME to group, STRING to property, ANY to value)
    TransferContext.callMethod(MethodBindings.setGroupFlagsPtr)
  }

  /**
   * Calls [method] on each node inside this tree added to the given [group]. You can pass arguments
   * to [method] by specifying them at the end of this method call. Nodes that cannot call [method]
   * (either because the method doesn't exist or the arguments do not match) are ignored. See also
   * [setGroup] and [notifyGroup].
   *
   * **Note:** This method acts immediately on all selected nodes at once, which may cause
   * stuttering in some performance-intensive situations.
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun callGroup(
    group: StringName,
    method: StringName,
    vararg args: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to group, STRING_NAME to method, *args.map { ANY to it }.toTypedArray())
    TransferContext.callMethod(MethodBindings.callGroupPtr)
  }

  /**
   * Calls [Object.notification] with the given [notification] to all nodes inside this tree added
   * to the [group]. See also [url=$DOCS_URL/tutorials/best_practices/godot_notifications.html]Godot
   * notifications[/url] and [callGroup] and [setGroup].
   *
   * **Note:** This method acts immediately on all selected nodes at once, which may cause
   * stuttering in some performance-intensive situations.
   */
  public final fun notifyGroup(group: StringName, notification: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to group, LONG to notification.toLong())
    TransferContext.callMethod(MethodBindings.notifyGroupPtr)
  }

  /**
   * Sets the given [property] to [value] on all nodes inside this tree added to the given [group].
   * Nodes that do not have the [property] are ignored. See also [callGroup] and [notifyGroup].
   *
   * **Note:** This method acts immediately on all selected nodes at once, which may cause
   * stuttering in some performance-intensive situations.
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun setGroup(
    group: StringName,
    `property`: String,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to group, STRING to property, ANY to value)
    TransferContext.callMethod(MethodBindings.setGroupPtr)
  }

  /**
   * Returns an [VariantArray] containing all nodes inside this tree, that have been added to the
   * given [group], in scene hierarchy order.
   */
  public final fun getNodesInGroup(group: StringName): VariantArray<Node> {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to group)
    TransferContext.callMethod(MethodBindings.getNodesInGroupPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Node>)
  }

  /**
   * Returns the first [Node] found inside the tree, that has been added to the given [group], in
   * scene hierarchy order. Returns `null` if no match is found. See also [getNodesInGroup].
   */
  public final fun getFirstNodeInGroup(group: StringName): Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to group)
    TransferContext.callMethod(MethodBindings.getFirstNodeInGroupPtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  /**
   * Returns the number of nodes assigned to the given group.
   */
  public final fun getNodeCountInGroup(group: StringName): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to group)
    TransferContext.callMethod(MethodBindings.getNodeCountInGroupPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setCurrentScene(childNode: Node?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to childNode)
    TransferContext.callMethod(MethodBindings.setCurrentScenePtr)
  }

  public final fun getCurrentScene(): Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentScenePtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  /**
   * Changes the running scene to the one at the given [path], after loading it into a [PackedScene]
   * and creating a new instance.
   *
   * Returns [OK] on success, [ERR_CANT_OPEN] if the [path] cannot be loaded into a [PackedScene],
   * or [ERR_CANT_CREATE] if that scene cannot be instantiated.
   *
   * **Note:** See [changeSceneToNode] for details on the order of operations.
   */
  public final fun changeSceneToFile(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.changeSceneToFilePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Changes the running scene to a new instance of the given [PackedScene] (which must be valid).
   *
   * Returns [OK] on success, [ERR_CANT_CREATE] if the scene cannot be instantiated, or
   * [ERR_INVALID_PARAMETER] if the scene is invalid.
   *
   * **Note:** See [changeSceneToNode] for details on the order of operations.
   */
  public final fun changeSceneToPacked(packedScene: PackedScene): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to packedScene)
    TransferContext.callMethod(MethodBindings.changeSceneToPackedPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Changes the running scene to the provided [Node]. Useful when you want to set up the new scene
   * before changing.
   *
   * Returns [OK] on success, [ERR_INVALID_PARAMETER] if the [node] is `null`, or [ERR_UNCONFIGURED]
   * if the [node] is already inside the scene tree.
   *
   * **Note:** Operations happen in the following order when [changeSceneToNode] is called:
   *
   * 1. The current scene node is immediately removed from the tree. From that point, [Node.getTree]
   * called on the current (outgoing) scene will return `null`. [currentScene] will be `null` too,
   * because the new scene is not available yet.
   *
   * 2. At the end of the frame, the formerly current scene, already removed from the tree, will be
   * deleted (freed from memory) and then the new scene node will be added to the tree. [Node.getTree]
   * and [currentScene] will be back to working as usual.
   *
   * This ensures that both scenes aren't running at the same time, while still freeing the previous
   * scene in a safe way similar to [Node.queueFree].
   *
   * If you want to reliably access the new scene, await the [signal scene_changed] signal.
   *
   * **Warning:** After using this method, the [SceneTree] will take ownership of the node and will
   * free it automatically when changing scene again. Any references you had to that node will become
   * invalid.
   */
  public final fun changeSceneToNode(node: Node): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to node)
    TransferContext.callMethod(MethodBindings.changeSceneToNodePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Reloads the currently active scene, replacing [currentScene] with a new instance of its
   * original [PackedScene].
   *
   * Returns [OK] on success, [ERR_UNCONFIGURED] if no [currentScene] is defined, [ERR_CANT_OPEN] if
   * [currentScene] cannot be loaded into a [PackedScene], or [ERR_CANT_CREATE] if the scene cannot be
   * instantiated.
   */
  public final fun reloadCurrentScene(): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.reloadCurrentScenePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If a current scene is loaded, calling this method will unload it.
   */
  public final fun unloadCurrentScene(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.unloadCurrentScenePtr)
  }

  /**
   * Sets a custom [MultiplayerAPI] with the given [rootPath] (controlling also the relative
   * subpaths), or override the default one if [rootPath] is empty.
   *
   * **Note:** No [MultiplayerAPI] must be configured for the subpath containing [rootPath], nested
   * custom multiplayers are not allowed. I.e. if one is configured for `"/root/Foo"` setting one for
   * `"/root/Foo/Bar"` will cause an error.
   *
   * **Note:** [setMultiplayer] should be called *before* the child nodes are ready at the given
   * [rootPath]. If multiplayer nodes like [MultiplayerSpawner] or [MultiplayerSynchronizer] are added
   * to the tree before the custom multiplayer API is set, they will not work.
   */
  public final fun setMultiplayer(multiplayer: MultiplayerAPI?, rootPath: NodePath = NodePath("")):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to multiplayer, NODE_PATH to rootPath)
    TransferContext.callMethod(MethodBindings.setMultiplayerPtr)
  }

  /**
   * Searches for the [MultiplayerAPI] configured for the given path, if one does not exist it
   * searches the parent paths until one is found. If the path is empty, or none is found, the default
   * one is returned. See [setMultiplayer].
   */
  public final fun getMultiplayer(forPath: NodePath = NodePath("")): MultiplayerAPI {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to forPath)
    TransferContext.callMethod(MethodBindings.getMultiplayerPtr)
    return (TransferContext.readReturnValue(OBJECT) as MultiplayerAPI)
  }

  public final fun setMultiplayerPollEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setMultiplayerPollEnabledPtr)
  }

  public final fun isMultiplayerPollEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMultiplayerPollEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if a node added to the given group [name] exists in the tree.
   */
  public final fun hasGroup(name: String): Boolean = hasGroup(name.asCachedStringName())

  /**
   * Calls the given [method] on each node inside this tree added to the given [group]. Use [flags]
   * to customize this method's behavior (see [GroupCallFlags]). Additional arguments for [method] can
   * be passed at the end of this method. Nodes that cannot call [method] (either because the method
   * doesn't exist or the arguments do not match) are ignored.
   *
   * ```
   * # Calls "hide" to all nodes of the "enemies" group, at the end of the frame and in reverse tree
   * order.
   * get_tree().call_group_flags(
   * 		SceneTree.GROUP_CALL_DEFERRED | SceneTree.GROUP_CALL_REVERSE,
   * 		"enemies", "hide")
   * ```
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun callGroupFlags(
    flags: Long,
    group: String,
    method: String,
    vararg args: Any?,
  ) = callGroupFlags(flags, group.asCachedStringName(), method.asCachedStringName(), *args)

  /**
   * Calls [Object.notification] with the given [notification] to all nodes inside this tree added
   * to the [group]. Use [callFlags] to customize this method's behavior (see [GroupCallFlags]).
   */
  public final fun notifyGroupFlags(
    callFlags: Long,
    group: String,
    notification: Int,
  ) = notifyGroupFlags(callFlags, group.asCachedStringName(), notification)

  /**
   * Sets the given [property] to [value] on all nodes inside this tree added to the given [group].
   * Nodes that do not have the [property] are ignored. Use [callFlags] to customize this method's
   * behavior (see [GroupCallFlags]).
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun setGroupFlags(
    callFlags: Long,
    group: String,
    `property`: String,
    `value`: Any?,
  ) = setGroupFlags(callFlags, group.asCachedStringName(), property, value)

  /**
   * Calls [method] on each node inside this tree added to the given [group]. You can pass arguments
   * to [method] by specifying them at the end of this method call. Nodes that cannot call [method]
   * (either because the method doesn't exist or the arguments do not match) are ignored. See also
   * [setGroup] and [notifyGroup].
   *
   * **Note:** This method acts immediately on all selected nodes at once, which may cause
   * stuttering in some performance-intensive situations.
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun callGroup(
    group: String,
    method: String,
    vararg args: Any?,
  ) = callGroup(group.asCachedStringName(), method.asCachedStringName(), *args)

  /**
   * Calls [Object.notification] with the given [notification] to all nodes inside this tree added
   * to the [group]. See also [url=$DOCS_URL/tutorials/best_practices/godot_notifications.html]Godot
   * notifications[/url] and [callGroup] and [setGroup].
   *
   * **Note:** This method acts immediately on all selected nodes at once, which may cause
   * stuttering in some performance-intensive situations.
   */
  public final fun notifyGroup(group: String, notification: Int) =
      notifyGroup(group.asCachedStringName(), notification)

  /**
   * Sets the given [property] to [value] on all nodes inside this tree added to the given [group].
   * Nodes that do not have the [property] are ignored. See also [callGroup] and [notifyGroup].
   *
   * **Note:** This method acts immediately on all selected nodes at once, which may cause
   * stuttering in some performance-intensive situations.
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun setGroup(
    group: String,
    `property`: String,
    `value`: Any?,
  ) = setGroup(group.asCachedStringName(), property, value)

  /**
   * Returns an [VariantArray] containing all nodes inside this tree, that have been added to the
   * given [group], in scene hierarchy order.
   */
  public final fun getNodesInGroup(group: String): VariantArray<Node> =
      getNodesInGroup(group.asCachedStringName())

  /**
   * Returns the first [Node] found inside the tree, that has been added to the given [group], in
   * scene hierarchy order. Returns `null` if no match is found. See also [getNodesInGroup].
   */
  public final fun getFirstNodeInGroup(group: String): Node? =
      getFirstNodeInGroup(group.asCachedStringName())

  /**
   * Returns the number of nodes assigned to the given group.
   */
  public final fun getNodeCountInGroup(group: String): Int =
      getNodeCountInGroup(group.asCachedStringName())

  /**
   * Sets a custom [MultiplayerAPI] with the given [rootPath] (controlling also the relative
   * subpaths), or override the default one if [rootPath] is empty.
   *
   * **Note:** No [MultiplayerAPI] must be configured for the subpath containing [rootPath], nested
   * custom multiplayers are not allowed. I.e. if one is configured for `"/root/Foo"` setting one for
   * `"/root/Foo/Bar"` will cause an error.
   *
   * **Note:** [setMultiplayer] should be called *before* the child nodes are ready at the given
   * [rootPath]. If multiplayer nodes like [MultiplayerSpawner] or [MultiplayerSynchronizer] are added
   * to the tree before the custom multiplayer API is set, they will not work.
   */
  public final fun setMultiplayer(multiplayer: MultiplayerAPI?, rootPath: String) =
      setMultiplayer(multiplayer, rootPath.asCachedNodePath())

  /**
   * Searches for the [MultiplayerAPI] configured for the given path, if one does not exist it
   * searches the parent paths until one is found. If the path is empty, or none is found, the default
   * one is returned. See [setMultiplayer].
   */
  public final fun getMultiplayer(forPath: String): MultiplayerAPI =
      getMultiplayer(forPath.asCachedNodePath())

  public enum class GroupCallFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Call nodes within a group with no special behavior (default).
     */
    DEFAULT(0),
    /**
     * Call nodes within a group in reverse tree hierarchy order (all nested children are called
     * before their respective parent nodes).
     */
    REVERSE(1),
    /**
     * Call nodes within a group at the end of the current frame (can be either process or physics
     * frame), similar to [Object.callDeferred].
     */
    DEFERRED(2),
    /**
     * Call nodes within a group only once, even if the call is executed many times in the same
     * frame. Must be combined with [GROUP_CALL_DEFERRED] to work.
     *
     * **Note:** Different arguments are not taken into account. Therefore, when the same call is
     * executed with different arguments, only the first call will be performed.
     */
    UNIQUE(4),
    ;

    public companion object {
      public fun from(`value`: Long): GroupCallFlags = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getRootName: MethodStringName0<SceneTree, Window> =
        MethodStringName0<SceneTree, Window>("get_root")

    @JvmField
    public val hasGroupName: MethodStringName1<SceneTree, Boolean, StringName> =
        MethodStringName1<SceneTree, Boolean, StringName>("has_group")

    @JvmField
    public val isAccessibilityEnabledName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_accessibility_enabled")

    @JvmField
    public val isAccessibilitySupportedName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_accessibility_supported")

    @JvmField
    public val isAutoAcceptQuitName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_auto_accept_quit")

    @JvmField
    public val setAutoAcceptQuitName: MethodStringName1<SceneTree, Unit, Boolean> =
        MethodStringName1<SceneTree, Unit, Boolean>("set_auto_accept_quit")

    @JvmField
    public val isQuitOnGoBackName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_quit_on_go_back")

    @JvmField
    public val setQuitOnGoBackName: MethodStringName1<SceneTree, Unit, Boolean> =
        MethodStringName1<SceneTree, Unit, Boolean>("set_quit_on_go_back")

    @JvmField
    public val setDebugCollisionsHintName: MethodStringName1<SceneTree, Unit, Boolean> =
        MethodStringName1<SceneTree, Unit, Boolean>("set_debug_collisions_hint")

    @JvmField
    public val isDebuggingCollisionsHintName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_debugging_collisions_hint")

    @JvmField
    public val setDebugPathsHintName: MethodStringName1<SceneTree, Unit, Boolean> =
        MethodStringName1<SceneTree, Unit, Boolean>("set_debug_paths_hint")

    @JvmField
    public val isDebuggingPathsHintName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_debugging_paths_hint")

    @JvmField
    public val setDebugNavigationHintName: MethodStringName1<SceneTree, Unit, Boolean> =
        MethodStringName1<SceneTree, Unit, Boolean>("set_debug_navigation_hint")

    @JvmField
    public val isDebuggingNavigationHintName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_debugging_navigation_hint")

    @JvmField
    public val setEditedSceneRootName: MethodStringName1<SceneTree, Unit, Node?> =
        MethodStringName1<SceneTree, Unit, Node?>("set_edited_scene_root")

    @JvmField
    public val getEditedSceneRootName: MethodStringName0<SceneTree, Node?> =
        MethodStringName0<SceneTree, Node?>("get_edited_scene_root")

    @JvmField
    public val setPauseName: MethodStringName1<SceneTree, Unit, Boolean> =
        MethodStringName1<SceneTree, Unit, Boolean>("set_pause")

    @JvmField
    public val isPausedName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_paused")

    @JvmField
    public val createTimerName:
        MethodStringName4<SceneTree, SceneTreeTimer, Double, Boolean, Boolean, Boolean> =
        MethodStringName4<SceneTree, SceneTreeTimer, Double, Boolean, Boolean, Boolean>("create_timer")

    @JvmField
    public val createTweenName: MethodStringName0<SceneTree, Tween> =
        MethodStringName0<SceneTree, Tween>("create_tween")

    @JvmField
    public val getProcessedTweensName: MethodStringName0<SceneTree, VariantArray<Tween>> =
        MethodStringName0<SceneTree, VariantArray<Tween>>("get_processed_tweens")

    @JvmField
    public val getNodeCountName: MethodStringName0<SceneTree, Int> =
        MethodStringName0<SceneTree, Int>("get_node_count")

    @JvmField
    public val getFrameName: MethodStringName0<SceneTree, Long> =
        MethodStringName0<SceneTree, Long>("get_frame")

    @JvmField
    public val quitName: MethodStringName1<SceneTree, Unit, Int> =
        MethodStringName1<SceneTree, Unit, Int>("quit")

    @JvmField
    public val setPhysicsInterpolationEnabledName: MethodStringName1<SceneTree, Unit, Boolean> =
        MethodStringName1<SceneTree, Unit, Boolean>("set_physics_interpolation_enabled")

    @JvmField
    public val isPhysicsInterpolationEnabledName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_physics_interpolation_enabled")

    @JvmField
    public val queueDeleteName: MethodStringName1<SceneTree, Unit, Object> =
        MethodStringName1<SceneTree, Unit, Object>("queue_delete")

    @JvmField
    public val notifyGroupFlagsName: MethodStringName3<SceneTree, Unit, Long, StringName, Int> =
        MethodStringName3<SceneTree, Unit, Long, StringName, Int>("notify_group_flags")

    @JvmField
    public val setGroupFlagsName: MethodStringName4<SceneTree, Unit, Long, StringName, String, Any?>
        = MethodStringName4<SceneTree, Unit, Long, StringName, String, Any?>("set_group_flags")

    @JvmField
    public val notifyGroupName: MethodStringName2<SceneTree, Unit, StringName, Int> =
        MethodStringName2<SceneTree, Unit, StringName, Int>("notify_group")

    @JvmField
    public val setGroupName: MethodStringName3<SceneTree, Unit, StringName, String, Any?> =
        MethodStringName3<SceneTree, Unit, StringName, String, Any?>("set_group")

    @JvmField
    public val getNodesInGroupName: MethodStringName1<SceneTree, VariantArray<Node>, StringName> =
        MethodStringName1<SceneTree, VariantArray<Node>, StringName>("get_nodes_in_group")

    @JvmField
    public val getFirstNodeInGroupName: MethodStringName1<SceneTree, Node?, StringName> =
        MethodStringName1<SceneTree, Node?, StringName>("get_first_node_in_group")

    @JvmField
    public val getNodeCountInGroupName: MethodStringName1<SceneTree, Int, StringName> =
        MethodStringName1<SceneTree, Int, StringName>("get_node_count_in_group")

    @JvmField
    public val setCurrentSceneName: MethodStringName1<SceneTree, Unit, Node?> =
        MethodStringName1<SceneTree, Unit, Node?>("set_current_scene")

    @JvmField
    public val getCurrentSceneName: MethodStringName0<SceneTree, Node?> =
        MethodStringName0<SceneTree, Node?>("get_current_scene")

    @JvmField
    public val changeSceneToFileName: MethodStringName1<SceneTree, Error, String> =
        MethodStringName1<SceneTree, Error, String>("change_scene_to_file")

    @JvmField
    public val changeSceneToPackedName: MethodStringName1<SceneTree, Error, PackedScene> =
        MethodStringName1<SceneTree, Error, PackedScene>("change_scene_to_packed")

    @JvmField
    public val changeSceneToNodeName: MethodStringName1<SceneTree, Error, Node> =
        MethodStringName1<SceneTree, Error, Node>("change_scene_to_node")

    @JvmField
    public val reloadCurrentSceneName: MethodStringName0<SceneTree, Error> =
        MethodStringName0<SceneTree, Error>("reload_current_scene")

    @JvmField
    public val unloadCurrentSceneName: MethodStringName0<SceneTree, Unit> =
        MethodStringName0<SceneTree, Unit>("unload_current_scene")

    @JvmField
    public val setMultiplayerName: MethodStringName2<SceneTree, Unit, MultiplayerAPI?, NodePath> =
        MethodStringName2<SceneTree, Unit, MultiplayerAPI?, NodePath>("set_multiplayer")

    @JvmField
    public val getMultiplayerName: MethodStringName1<SceneTree, MultiplayerAPI, NodePath> =
        MethodStringName1<SceneTree, MultiplayerAPI, NodePath>("get_multiplayer")

    @JvmField
    public val setMultiplayerPollEnabledName: MethodStringName1<SceneTree, Unit, Boolean> =
        MethodStringName1<SceneTree, Unit, Boolean>("set_multiplayer_poll_enabled")

    @JvmField
    public val isMultiplayerPollEnabledName: MethodStringName0<SceneTree, Boolean> =
        MethodStringName0<SceneTree, Boolean>("is_multiplayer_poll_enabled")
  }

  public object MethodBindings {
    internal val getRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_root", 1757182445)

    internal val hasGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "has_group", 2619796661)

    internal val isAccessibilityEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_accessibility_enabled", 36873697)

    internal val isAccessibilitySupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_accessibility_supported", 36873697)

    internal val isAutoAcceptQuitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_auto_accept_quit", 36873697)

    internal val setAutoAcceptQuitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_auto_accept_quit", 2586408642)

    internal val isQuitOnGoBackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_quit_on_go_back", 36873697)

    internal val setQuitOnGoBackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_quit_on_go_back", 2586408642)

    internal val setDebugCollisionsHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_debug_collisions_hint", 2586408642)

    internal val isDebuggingCollisionsHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_debugging_collisions_hint", 36873697)

    internal val setDebugPathsHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_debug_paths_hint", 2586408642)

    internal val isDebuggingPathsHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_debugging_paths_hint", 36873697)

    internal val setDebugNavigationHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_debug_navigation_hint", 2586408642)

    internal val isDebuggingNavigationHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_debugging_navigation_hint", 36873697)

    internal val setEditedSceneRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_edited_scene_root", 1078189570)

    internal val getEditedSceneRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_edited_scene_root", 3160264692)

    internal val setPausePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_pause", 2586408642)

    internal val isPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_paused", 36873697)

    internal val createTimerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "create_timer", 2709170273)

    internal val createTweenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "create_tween", 3426978995)

    internal val getProcessedTweensPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_processed_tweens", 2915620761)

    internal val getNodeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_node_count", 3905245786)

    internal val getFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_frame", 3905245786)

    internal val quitPtr: VoidPtr = TypeManager.getMethodBindPtr("SceneTree", "quit", 1995695955)

    internal val setPhysicsInterpolationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_physics_interpolation_enabled", 2586408642)

    internal val isPhysicsInterpolationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_physics_interpolation_enabled", 36873697)

    internal val queueDeletePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "queue_delete", 3975164845)

    internal val callGroupFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "call_group_flags", 1527739229)

    internal val notifyGroupFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "notify_group_flags", 1245489420)

    internal val setGroupFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_group_flags", 3497599527)

    internal val callGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "call_group", 1257962832)

    internal val notifyGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "notify_group", 2415702435)

    internal val setGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_group", 1279312029)

    internal val getNodesInGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_nodes_in_group", 689397652)

    internal val getFirstNodeInGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_first_node_in_group", 4071044623)

    internal val getNodeCountInGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_node_count_in_group", 2458036349)

    internal val setCurrentScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_current_scene", 1078189570)

    internal val getCurrentScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_current_scene", 3160264692)

    internal val changeSceneToFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "change_scene_to_file", 166001499)

    internal val changeSceneToPackedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "change_scene_to_packed", 107349098)

    internal val changeSceneToNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "change_scene_to_node", 2584678054)

    internal val reloadCurrentScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "reload_current_scene", 166280745)

    internal val unloadCurrentScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "unload_current_scene", 3218959716)

    internal val setMultiplayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_multiplayer", 2385607013)

    internal val getMultiplayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "get_multiplayer", 3453401404)

    internal val setMultiplayerPollEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "set_multiplayer_poll_enabled", 2586408642)

    internal val isMultiplayerPollEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTree", "is_multiplayer_poll_enabled", 36873697)
  }
}
