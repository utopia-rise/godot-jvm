// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_NODE_PATH
import godot.callPtrMethod0_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod0_ret_QUATERNION
import godot.callPtrMethod0_ret_VECTOR3
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_NODE_PATH
import godot.callPtrMethod_OBJECT_ret_STRING_NAME
import godot.callPtrMethod_STRING_NAME
import godot.callPtrMethod_STRING_NAME_DOUBLE_LONG_LONG
import godot.callPtrMethod_STRING_NAME_OBJECT_ret_LONG
import godot.callPtrMethod_STRING_NAME_STRING_NAME
import godot.callPtrMethod_STRING_NAME_ret_BOOL
import godot.callPtrMethod_STRING_NAME_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.NodePath
import godot.core.PackedStringArray
import godot.core.Quaternion
import godot.core.Signal0
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantArray
import godot.core.Vector3
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Base class for [AnimationPlayer] and [AnimationTree] to manage animation lists. It also has
 * general properties and methods for playback and blending.
 *
 * After instantiating the playback information data within the extended class, the blending is
 * processed by the [AnimationMixer].
 */
@GodotBaseType
public open class AnimationMixer internal constructor() : Node() {
  /**
   * Notifies when an animation list is changed.
   */
  public val animationListChanged: Signal0 by Signal0

  /**
   * Notifies when the animation libraries have changed.
   */
  public val animationLibrariesUpdated: Signal0 by Signal0

  /**
   * Notifies when an animation finished playing.
   *
   * **Note:** This signal is not emitted if an animation is looping.
   */
  public val animationFinished: Signal1<StringName> by Signal1

  /**
   * Notifies when an animation starts playing.
   *
   * **Note:** This signal is not emitted if an animation is looping.
   */
  public val animationStarted: Signal1<StringName> by Signal1

  /**
   * Notifies when the caches have been cleared, either automatically, or manually via
   * [clearCaches].
   */
  public val cachesCleared: Signal0 by Signal0

  /**
   * Notifies when the blending result related have been applied to the target objects.
   */
  public val mixerApplied: Signal0 by Signal0

  /**
   * Notifies when the property related process have been updated.
   */
  public val mixerUpdated: Signal0 by Signal0

  /**
   * If `true`, the [AnimationMixer] will be processing.
   */
  public final inline var active: Boolean
    @JvmName("activeProperty")
    get() = isActive()
    @JvmName("activeProperty")
    set(`value`) {
      setActive(value)
    }

  /**
   * If `true`, the blending uses the deterministic algorithm. The total weight is not normalized
   * and the result is accumulated with an initial value (`0` or a `"RESET"` animation if present).
   *
   * This means that if the total amount of blending is `0.0`, the result is equal to the `"RESET"`
   * animation.
   *
   * If the number of tracks between the blended animations is different, the animation with the
   * missing track is treated as if it had the initial value.
   *
   * If `false`, The blend does not use the deterministic algorithm. The total weight is normalized
   * and always `1.0`. If the number of tracks between the blended animations is different, nothing is
   * done about the animation that is missing a track.
   *
   * **Note:** In [AnimationTree], the blending with [AnimationNodeAdd2], [AnimationNodeAdd3],
   * [AnimationNodeSub2] or the weight greater than `1.0` may produce unexpected results.
   *
   * For example, if [AnimationNodeAdd2] blends two nodes with the amount `1.0`, then total weight
   * is `2.0` but it will be normalized to make the total amount `1.0` and the result will be equal to
   * [AnimationNodeBlend2] with the amount `0.5`.
   */
  public final inline var deterministic: Boolean
    @JvmName("deterministicProperty")
    get() = isDeterministic()
    @JvmName("deterministicProperty")
    set(`value`) {
      setDeterministic(value)
    }

  /**
   * This is used by the editor. If set to `true`, the scene will be saved with the effects of the
   * reset animation (the animation with the key `"RESET"`) applied as if it had been seeked to time 0,
   * with the editor keeping the values that the scene had before saving.
   *
   * This makes it more convenient to preview and edit animations in the editor, as changes to the
   * scene will not be saved as long as they are set in the reset animation.
   */
  public final inline var resetOnSave: Boolean
    @JvmName("resetOnSaveProperty")
    get() = isResetOnSaveEnabled()
    @JvmName("resetOnSaveProperty")
    set(`value`) {
      setResetOnSaveEnabled(value)
    }

  /**
   * The node which node path references will travel from.
   */
  public final inline var rootNode: NodePath
    @JvmName("rootNodeProperty")
    get() = getRootNode()
    @JvmName("rootNodeProperty")
    set(`value`) {
      setRootNode(value)
    }

  /**
   * The path to the Animation track used for root motion. Paths must be valid scene-tree paths to a
   * node, and must be specified starting from the parent node of the node that will reproduce the
   * animation. The [rootMotionTrack] uses the same format as [Animation.trackSetPath], but note that a
   * bone must be specified.
   *
   * If the track has type [Animation.TYPE_POSITION_3D], [Animation.TYPE_ROTATION_3D], or
   * [Animation.TYPE_SCALE_3D] the transformation will be canceled visually, and the animation will
   * appear to stay in place. See also [getRootMotionPosition], [getRootMotionRotation],
   * [getRootMotionScale], and [RootMotionView].
   */
  public final inline var rootMotionTrack: NodePath
    @JvmName("rootMotionTrackProperty")
    get() = getRootMotionTrack()
    @JvmName("rootMotionTrackProperty")
    set(`value`) {
      setRootMotionTrack(value)
    }

  /**
   * If `true`, [getRootMotionPosition] value is extracted as a local translation value before
   * blending. In other words, it is treated like the translation is done after the rotation.
   */
  public final inline var rootMotionLocal: Boolean
    @JvmName("rootMotionLocalProperty")
    get() = isRootMotionLocal()
    @JvmName("rootMotionLocalProperty")
    set(`value`) {
      setRootMotionLocal(value)
    }

  /**
   * The number of possible simultaneous sounds for each of the assigned AudioStreamPlayers.
   *
   * For example, if this value is `32` and the animation has two audio tracks, the two
   * [AudioStreamPlayer]s assigned can play simultaneously up to `32` voices each.
   */
  public final inline var audioMaxPolyphony: Int
    @JvmName("audioMaxPolyphonyProperty")
    get() = getAudioMaxPolyphony()
    @JvmName("audioMaxPolyphonyProperty")
    set(`value`) {
      setAudioMaxPolyphony(value)
    }

  /**
   * The process notification in which to update animations.
   */
  public final inline var callbackModeProcess: AnimationCallbackModeProcess
    @JvmName("callbackModeProcessProperty")
    get() = getCallbackModeProcess()
    @JvmName("callbackModeProcessProperty")
    set(`value`) {
      setCallbackModeProcess(value)
    }

  /**
   * The call mode used for "Call Method" tracks.
   */
  public final inline var callbackModeMethod: AnimationCallbackModeMethod
    @JvmName("callbackModeMethodProperty")
    get() = getCallbackModeMethod()
    @JvmName("callbackModeMethodProperty")
    set(`value`) {
      setCallbackModeMethod(value)
    }

  /**
   * Ordinarily, tracks can be set to [Animation.UPDATE_DISCRETE] to update infrequently, usually
   * when using nearest interpolation.
   *
   * However, when blending with [Animation.UPDATE_CONTINUOUS] several results are considered. The
   * [callbackModeDiscrete] specify it explicitly. See also [AnimationCallbackModeDiscrete].
   *
   * To make the blended results look good, it is recommended to set this to
   * [ANIMATION_CALLBACK_MODE_DISCRETE_FORCE_CONTINUOUS] to update every frame during blending. Other
   * values exist for compatibility and they are fine if there is no blending, but not so, may produce
   * artifacts.
   */
  public final inline var callbackModeDiscrete: AnimationCallbackModeDiscrete
    @JvmName("callbackModeDiscreteProperty")
    get() = getCallbackModeDiscrete()
    @JvmName("callbackModeDiscreteProperty")
    set(`value`) {
      setCallbackModeDiscrete(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(14, scriptPtr)
  }

  /**
   * A virtual function for processing after getting a key during playback.
   */
  public open fun _postProcessKeyValue(
    animation: Animation?,
    track: Int,
    `value`: Any?,
    objectId: Long,
    objectSubIdx: Int,
  ): Any? {
    throw NotImplementedError("AnimationMixer::_postProcessKeyValue is not implemented.")
  }

  /**
   * Adds [library] to the animation player, under the key [name].
   *
   * AnimationMixer has a global library by default with an empty string as key. For adding an
   * animation to the global library:
   *
   * ```gdscript
   * //gdscript
   * var global_library = mixer.get_animation_library("")
   * global_library.add_animation("animation_name", animation_resource)
   * ```
   */
  public final fun addAnimationLibrary(name: StringName, library: AnimationLibrary?): Error =
      Error.from(TransferContext.callPtrMethod_STRING_NAME_OBJECT_ret_LONG(ptr, objectID.id, MethodBindings.addAnimationLibraryPtr, name, library))

  /**
   * Removes the [AnimationLibrary] associated with the key [name].
   */
  public final fun removeAnimationLibrary(name: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME(ptr, objectID.id, MethodBindings.removeAnimationLibraryPtr, name)
  }

  /**
   * Moves the [AnimationLibrary] associated with the key [name] to the key [newname].
   */
  public final fun renameAnimationLibrary(name: StringName, newname: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME_STRING_NAME(ptr, objectID.id, MethodBindings.renameAnimationLibraryPtr, name, newname)
  }

  /**
   * Returns `true` if the [AnimationMixer] stores an [AnimationLibrary] with key [name].
   */
  public final fun hasAnimationLibrary(name: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasAnimationLibraryPtr, name)

  /**
   * Returns the first [AnimationLibrary] with key [name] or `null` if not found.
   *
   * To get the [AnimationMixer]'s global animation library, use `get_animation_library("")`.
   */
  public final fun getAnimationLibrary(name: StringName): AnimationLibrary? =
      (TransferContext.callPtrMethod_STRING_NAME_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getAnimationLibraryPtr, name) as AnimationLibrary?)

  /**
   * Returns the list of stored library keys.
   */
  public final fun getAnimationLibraryList(): VariantArray<StringName> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getAnimationLibraryListPtr) as VariantArray<StringName>)

  /**
   * Returns `true` if the [AnimationMixer] stores an [Animation] with key [name].
   */
  public final fun hasAnimation(name: StringName): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_ret_BOOL(ptr, objectID.id, MethodBindings.hasAnimationPtr, name)

  /**
   * Returns the [Animation] with the key [name]. If the animation does not exist, `null` is
   * returned and an error is logged.
   */
  public final fun getAnimation(name: StringName): Animation? =
      (TransferContext.callPtrMethod_STRING_NAME_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getAnimationPtr, name) as Animation?)

  /**
   * Returns the list of stored animation keys.
   */
  public final fun getAnimationList(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getAnimationListPtr)

  public final fun setActive(active: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setActivePtr, active)
  }

  public final fun isActive(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isActivePtr)

  public final fun setDeterministic(deterministic: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setDeterministicPtr, deterministic)
  }

  public final fun isDeterministic(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isDeterministicPtr)

  public final fun setRootNode(path: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setRootNodePtr, path)
  }

  public final fun getRootNode(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getRootNodePtr)

  public final fun setCallbackModeProcess(mode: AnimationCallbackModeProcess): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCallbackModeProcessPtr, mode.value)
  }

  public final fun getCallbackModeProcess(): AnimationCallbackModeProcess =
      AnimationCallbackModeProcess.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCallbackModeProcessPtr))

  public final fun setCallbackModeMethod(mode: AnimationCallbackModeMethod): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCallbackModeMethodPtr, mode.value)
  }

  public final fun getCallbackModeMethod(): AnimationCallbackModeMethod =
      AnimationCallbackModeMethod.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCallbackModeMethodPtr))

  public final fun setCallbackModeDiscrete(mode: AnimationCallbackModeDiscrete): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCallbackModeDiscretePtr, mode.value)
  }

  public final fun getCallbackModeDiscrete(): AnimationCallbackModeDiscrete =
      AnimationCallbackModeDiscrete.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCallbackModeDiscretePtr))

  public final fun setAudioMaxPolyphony(maxPolyphony: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAudioMaxPolyphonyPtr, maxPolyphony.toLong())
  }

  public final fun getAudioMaxPolyphony(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAudioMaxPolyphonyPtr).toInt()

  public final fun setRootMotionTrack(path: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setRootMotionTrackPtr, path)
  }

  public final fun getRootMotionTrack(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getRootMotionTrackPtr)

  public final fun setRootMotionLocal(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setRootMotionLocalPtr, enabled)
  }

  public final fun isRootMotionLocal(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isRootMotionLocalPtr)

  /**
   * Retrieve the motion delta of position with the [rootMotionTrack] as a [Vector3] that can be
   * used elsewhere.
   *
   * If [rootMotionTrack] is not a path to a track of type [Animation.TYPE_POSITION_3D], returns
   * `Vector3(0, 0, 0)`.
   *
   * See also [rootMotionTrack] and [RootMotionView].
   *
   * The most basic example is applying position to [CharacterBody3D]:
   *
   * ```gdscript
   * //gdscript
   * var current_rotation
   *
   * func _process(delta):
   * 	if Input.is_action_just_pressed("animate"):
   * 		current_rotation = get_quaternion()
   * 		state_machine.travel("Animate")
   * 	var velocity = current_rotation * animation_tree.get_root_motion_position() / delta
   * 	set_velocity(velocity)
   * 	move_and_slide()
   * ```
   *
   * By using this in combination with [getRootMotionRotationAccumulator], you can apply the root
   * motion position more correctly to account for the rotation of the node.
   *
   * ```gdscript
   * //gdscript
   * func _process(delta):
   * 	if Input.is_action_just_pressed("animate"):
   * 		state_machine.travel("Animate")
   * 	set_quaternion(get_quaternion() * animation_tree.get_root_motion_rotation())
   * 	var velocity = (animation_tree.get_root_motion_rotation_accumulator().inverse() *
   * get_quaternion()) * animation_tree.get_root_motion_position() / delta
   * 	set_velocity(velocity)
   * 	move_and_slide()
   * ```
   *
   * If [rootMotionLocal] is `true`, returns the pre-multiplied translation value with the inverted
   * rotation.
   *
   * In this case, the code can be written as follows:
   *
   * ```gdscript
   * //gdscript
   * func _process(delta):
   * 	if Input.is_action_just_pressed("animate"):
   * 		state_machine.travel("Animate")
   * 	set_quaternion(get_quaternion() * animation_tree.get_root_motion_rotation())
   * 	var velocity = get_quaternion() * animation_tree.get_root_motion_position() / delta
   * 	set_velocity(velocity)
   * 	move_and_slide()
   * ```
   */
  public final fun getRootMotionPosition(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getRootMotionPositionPtr)

  /**
   * Retrieve the motion delta of rotation with the [rootMotionTrack] as a [Quaternion] that can be
   * used elsewhere.
   *
   * If [rootMotionTrack] is not a path to a track of type [Animation.TYPE_ROTATION_3D], returns
   * `Quaternion(0, 0, 0, 1)`.
   *
   * See also [rootMotionTrack] and [RootMotionView].
   *
   * The most basic example is applying rotation to [CharacterBody3D]:
   *
   * ```gdscript
   * //gdscript
   * func _process(delta):
   * 	if Input.is_action_just_pressed("animate"):
   * 		state_machine.travel("Animate")
   * 	set_quaternion(get_quaternion() * animation_tree.get_root_motion_rotation())
   * ```
   */
  public final fun getRootMotionRotation(): Quaternion =
      TransferContext.callPtrMethod0_ret_QUATERNION(ptr, objectID.id, MethodBindings.getRootMotionRotationPtr)

  /**
   * Retrieve the motion delta of scale with the [rootMotionTrack] as a [Vector3] that can be used
   * elsewhere.
   *
   * If [rootMotionTrack] is not a path to a track of type [Animation.TYPE_SCALE_3D], returns
   * `Vector3(0, 0, 0)`.
   *
   * See also [rootMotionTrack] and [RootMotionView].
   *
   * The most basic example is applying scale to [CharacterBody3D]:
   *
   * ```gdscript
   * //gdscript
   * var current_scale = Vector3(1, 1, 1)
   * var scale_accum = Vector3(1, 1, 1)
   *
   * func _process(delta):
   * 	if Input.is_action_just_pressed("animate"):
   * 		current_scale = get_scale()
   * 		scale_accum = Vector3(1, 1, 1)
   * 		state_machine.travel("Animate")
   * 	scale_accum += animation_tree.get_root_motion_scale()
   * 	set_scale(current_scale * scale_accum)
   * ```
   */
  public final fun getRootMotionScale(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getRootMotionScalePtr)

  /**
   * Retrieve the blended value of the position tracks with the [rootMotionTrack] as a [Vector3]
   * that can be used elsewhere.
   *
   * This is useful in cases where you want to respect the initial key values of the animation.
   *
   * For example, if an animation with only one key `Vector3(0, 0, 0)` is played in the previous
   * frame and then an animation with only one key `Vector3(1, 0, 1)` is played in the next frame, the
   * difference can be calculated as follows:
   *
   * ```gdscript
   * //gdscript
   * var prev_root_motion_position_accumulator
   *
   * func _process(delta):
   * 	if Input.is_action_just_pressed("animate"):
   * 		state_machine.travel("Animate")
   * 	var current_root_motion_position_accumulator =
   * animation_tree.get_root_motion_position_accumulator()
   * 	var difference = current_root_motion_position_accumulator -
   * prev_root_motion_position_accumulator
   * 	prev_root_motion_position_accumulator = current_root_motion_position_accumulator
   * 	transform.origin += difference
   * ```
   *
   * However, if the animation loops, an unintended discrete change may occur, so this is only
   * useful for some simple use cases.
   */
  public final fun getRootMotionPositionAccumulator(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getRootMotionPositionAccumulatorPtr)

  /**
   * Retrieve the blended value of the rotation tracks with the [rootMotionTrack] as a [Quaternion]
   * that can be used elsewhere.
   *
   * This is necessary to apply the root motion position correctly, taking rotation into account.
   * See also [getRootMotionPosition].
   *
   * Also, this is useful in cases where you want to respect the initial key values of the
   * animation.
   *
   * For example, if an animation with only one key `Quaternion(0, 0, 0, 1)` is played in the
   * previous frame and then an animation with only one key `Quaternion(0, 0.707, 0, 0.707)` is played
   * in the next frame, the difference can be calculated as follows:
   *
   * ```gdscript
   * //gdscript
   * var prev_root_motion_rotation_accumulator
   *
   * func _process(delta):
   * 	if Input.is_action_just_pressed("animate"):
   * 		state_machine.travel("Animate")
   * 	var current_root_motion_rotation_accumulator =
   * animation_tree.get_root_motion_rotation_accumulator()
   * 	var difference = prev_root_motion_rotation_accumulator.inverse() *
   * current_root_motion_rotation_accumulator
   * 	prev_root_motion_rotation_accumulator = current_root_motion_rotation_accumulator
   * 	transform.basis *=  Basis(difference)
   * ```
   *
   * However, if the animation loops, an unintended discrete change may occur, so this is only
   * useful for some simple use cases.
   */
  public final fun getRootMotionRotationAccumulator(): Quaternion =
      TransferContext.callPtrMethod0_ret_QUATERNION(ptr, objectID.id, MethodBindings.getRootMotionRotationAccumulatorPtr)

  /**
   * Retrieve the blended value of the scale tracks with the [rootMotionTrack] as a [Vector3] that
   * can be used elsewhere.
   *
   * For example, if an animation with only one key `Vector3(1, 1, 1)` is played in the previous
   * frame and then an animation with only one key `Vector3(2, 2, 2)` is played in the next frame, the
   * difference can be calculated as follows:
   *
   * ```gdscript
   * //gdscript
   * var prev_root_motion_scale_accumulator
   *
   * func _process(delta):
   * 	if Input.is_action_just_pressed("animate"):
   * 		state_machine.travel("Animate")
   * 	var current_root_motion_scale_accumulator = animation_tree.get_root_motion_scale_accumulator()
   * 	var difference = current_root_motion_scale_accumulator - prev_root_motion_scale_accumulator
   * 	prev_root_motion_scale_accumulator = current_root_motion_scale_accumulator
   * 	transform.basis = transform.basis.scaled(difference)
   * ```
   *
   * However, if the animation loops, an unintended discrete change may occur, so this is only
   * useful for some simple use cases.
   */
  public final fun getRootMotionScaleAccumulator(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getRootMotionScaleAccumulatorPtr)

  /**
   * [AnimationMixer] caches animated nodes. It may not notice if a node disappears; [clearCaches]
   * forces it to update the cache again.
   */
  public final fun clearCaches(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearCachesPtr)
  }

  /**
   * Manually advance the animations by the specified time (in seconds).
   */
  public final fun advance(delta: Double): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.advancePtr, delta)
  }

  /**
   * If the animation track specified by [name] has an option [Animation.UPDATE_CAPTURE], stores
   * current values of the objects indicated by the track path as a cache. If there is already a
   * captured cache, the old cache is discarded.
   *
   * After this it will interpolate with current animation blending result during the playback
   * process for the time specified by [duration], working like a crossfade.
   *
   * You can specify [transType] as the curve for the interpolation. For better results, it may be
   * appropriate to specify [Tween.TRANS_LINEAR] for cases where the first key of the track begins with
   * a non-zero value or where the key value does not change, and [Tween.TRANS_QUAD] for cases where
   * the key value changes linearly.
   */
  @JvmOverloads
  public final fun capture(
    name: StringName,
    duration: Double,
    transType: Tween.TransitionType = Tween.TransitionType.LINEAR,
    easeType: Tween.EaseType = Tween.EaseType.IN,
  ): Unit {
    TransferContext.callPtrMethod_STRING_NAME_DOUBLE_LONG_LONG(ptr, objectID.id, MethodBindings.capturePtr, name, duration, transType.value, easeType.value)
  }

  public final fun setResetOnSaveEnabled(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setResetOnSaveEnabledPtr, enabled)
  }

  public final fun isResetOnSaveEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isResetOnSaveEnabledPtr)

  /**
   * Returns the key of [animation] or an empty [StringName] if not found.
   */
  public final fun findAnimation(animation: Animation?): StringName =
      TransferContext.callPtrMethod_OBJECT_ret_STRING_NAME(ptr, objectID.id, MethodBindings.findAnimationPtr, animation)

  /**
   * Returns the key for the [AnimationLibrary] that contains [animation] or an empty [StringName]
   * if not found.
   */
  public final fun findAnimationLibrary(animation: Animation?): StringName =
      TransferContext.callPtrMethod_OBJECT_ret_STRING_NAME(ptr, objectID.id, MethodBindings.findAnimationLibraryPtr, animation)

  /**
   * Adds [library] to the animation player, under the key [name].
   *
   * AnimationMixer has a global library by default with an empty string as key. For adding an
   * animation to the global library:
   *
   * ```gdscript
   * //gdscript
   * var global_library = mixer.get_animation_library("")
   * global_library.add_animation("animation_name", animation_resource)
   * ```
   */
  public final fun addAnimationLibrary(name: String, library: AnimationLibrary?): Error =
      addAnimationLibrary(name.asCachedStringName(), library)

  /**
   * Removes the [AnimationLibrary] associated with the key [name].
   */
  public final fun removeAnimationLibrary(name: String) =
      removeAnimationLibrary(name.asCachedStringName())

  /**
   * Moves the [AnimationLibrary] associated with the key [name] to the key [newname].
   */
  public final fun renameAnimationLibrary(name: String, newname: String) =
      renameAnimationLibrary(name.asCachedStringName(), newname.asCachedStringName())

  /**
   * Returns `true` if the [AnimationMixer] stores an [AnimationLibrary] with key [name].
   */
  public final fun hasAnimationLibrary(name: String): Boolean =
      hasAnimationLibrary(name.asCachedStringName())

  /**
   * Returns the first [AnimationLibrary] with key [name] or `null` if not found.
   *
   * To get the [AnimationMixer]'s global animation library, use `get_animation_library("")`.
   */
  public final fun getAnimationLibrary(name: String): AnimationLibrary? =
      getAnimationLibrary(name.asCachedStringName())

  /**
   * Returns `true` if the [AnimationMixer] stores an [Animation] with key [name].
   */
  public final fun hasAnimation(name: String): Boolean = hasAnimation(name.asCachedStringName())

  /**
   * Returns the [Animation] with the key [name]. If the animation does not exist, `null` is
   * returned and an error is logged.
   */
  public final fun getAnimation(name: String): Animation? = getAnimation(name.asCachedStringName())

  public final fun setRootNode(path: String) = setRootNode(path.asCachedNodePath())

  public final fun setRootMotionTrack(path: String) = setRootMotionTrack(path.asCachedNodePath())

  /**
   * If the animation track specified by [name] has an option [Animation.UPDATE_CAPTURE], stores
   * current values of the objects indicated by the track path as a cache. If there is already a
   * captured cache, the old cache is discarded.
   *
   * After this it will interpolate with current animation blending result during the playback
   * process for the time specified by [duration], working like a crossfade.
   *
   * You can specify [transType] as the curve for the interpolation. For better results, it may be
   * appropriate to specify [Tween.TRANS_LINEAR] for cases where the first key of the track begins with
   * a non-zero value or where the key value does not change, and [Tween.TRANS_QUAD] for cases where
   * the key value changes linearly.
   */
  @JvmOverloads
  public final fun capture(
    name: String,
    duration: Double,
    transType: Tween.TransitionType = Tween.TransitionType.LINEAR,
    easeType: Tween.EaseType = Tween.EaseType.IN,
  ) = capture(name.asCachedStringName(), duration, transType, easeType)

  public enum class AnimationCallbackModeProcess(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Process animation during physics frames (see [Node.NOTIFICATION_INTERNAL_PHYSICS_PROCESS]).
     * This is especially useful when animating physics bodies.
     */
    PHYSICS(0),
    /**
     * Process animation during process frames (see [Node.NOTIFICATION_INTERNAL_PROCESS]).
     */
    IDLE(1),
    /**
     * Do not process animation. Use [advance] to process the animation manually.
     */
    MANUAL(2),
    ;

    public companion object {
      public fun from(`value`: Long): AnimationCallbackModeProcess =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class AnimationCallbackModeMethod(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Batch method calls during the animation process, then do the calls after events are
     * processed. This avoids bugs involving deleting nodes or modifying the AnimationPlayer while
     * playing.
     */
    DEFERRED(0),
    /**
     * Make method calls immediately when reached in the animation.
     */
    IMMEDIATE(1),
    ;

    public companion object {
      public fun from(`value`: Long): AnimationCallbackModeMethod =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class AnimationCallbackModeDiscrete(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * An [Animation.UPDATE_DISCRETE] track value takes precedence when blending
     * [Animation.UPDATE_CONTINUOUS] or [Animation.UPDATE_CAPTURE] track values and
     * [Animation.UPDATE_DISCRETE] track values.
     */
    DOMINANT(0),
    /**
     * An [Animation.UPDATE_CONTINUOUS] or [Animation.UPDATE_CAPTURE] track value takes precedence
     * when blending the [Animation.UPDATE_CONTINUOUS] or [Animation.UPDATE_CAPTURE] track values and
     * the [Animation.UPDATE_DISCRETE] track values. This is the default behavior for
     * [AnimationPlayer].
     */
    RECESSIVE(1),
    /**
     * Always treat the [Animation.UPDATE_DISCRETE] track value as [Animation.UPDATE_CONTINUOUS]
     * with [Animation.INTERPOLATION_NEAREST]. This is the default behavior for [AnimationTree].
     *
     * If a value track has un-interpolatable type key values, it is internally converted to use
     * [ANIMATION_CALLBACK_MODE_DISCRETE_RECESSIVE] with [Animation.UPDATE_DISCRETE].
     *
     * Un-interpolatable type list:
     *
     * - [@GlobalScope.TYPE_NIL]
     *
     * - [@GlobalScope.TYPE_NODE_PATH]
     *
     * - [@GlobalScope.TYPE_RID]
     *
     * - [@GlobalScope.TYPE_OBJECT]
     *
     * - [@GlobalScope.TYPE_CALLABLE]
     *
     * - [@GlobalScope.TYPE_SIGNAL]
     *
     * - [@GlobalScope.TYPE_DICTIONARY]
     *
     * - [@GlobalScope.TYPE_PACKED_BYTE_ARRAY]
     *
     * [@GlobalScope.TYPE_BOOL] and [@GlobalScope.TYPE_INT] are treated as [@GlobalScope.TYPE_FLOAT]
     * during blending and rounded when the result is retrieved.
     *
     * It is same for arrays and vectors with them such as [@GlobalScope.TYPE_PACKED_INT32_ARRAY] or
     * [@GlobalScope.TYPE_VECTOR2I], they are treated as [@GlobalScope.TYPE_PACKED_FLOAT32_ARRAY] or
     * [@GlobalScope.TYPE_VECTOR2]. Also note that for arrays, the size is also interpolated.
     *
     * [@GlobalScope.TYPE_STRING] and [@GlobalScope.TYPE_STRING_NAME] are interpolated between
     * character codes and lengths, but note that there is a difference in algorithm between
     * interpolation between keys and interpolation by blending.
     */
    FORCE_CONTINUOUS(2),
    ;

    public companion object {
      public fun from(`value`: Long): AnimationCallbackModeDiscrete =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addAnimationLibraryName:
        MethodStringName2<AnimationMixer, Error, StringName, AnimationLibrary?> =
        MethodStringName2<AnimationMixer, Error, StringName, AnimationLibrary?>("add_animation_library")

    @JvmField
    public val removeAnimationLibraryName: MethodStringName1<AnimationMixer, Unit, StringName> =
        MethodStringName1<AnimationMixer, Unit, StringName>("remove_animation_library")

    @JvmField
    public val renameAnimationLibraryName:
        MethodStringName2<AnimationMixer, Unit, StringName, StringName> =
        MethodStringName2<AnimationMixer, Unit, StringName, StringName>("rename_animation_library")

    @JvmField
    public val hasAnimationLibraryName: MethodStringName1<AnimationMixer, Boolean, StringName> =
        MethodStringName1<AnimationMixer, Boolean, StringName>("has_animation_library")

    @JvmField
    public val getAnimationLibraryName:
        MethodStringName1<AnimationMixer, AnimationLibrary?, StringName> =
        MethodStringName1<AnimationMixer, AnimationLibrary?, StringName>("get_animation_library")

    @JvmField
    public val getAnimationLibraryListName:
        MethodStringName0<AnimationMixer, VariantArray<StringName>> =
        MethodStringName0<AnimationMixer, VariantArray<StringName>>("get_animation_library_list")

    @JvmField
    public val hasAnimationName: MethodStringName1<AnimationMixer, Boolean, StringName> =
        MethodStringName1<AnimationMixer, Boolean, StringName>("has_animation")

    @JvmField
    public val getAnimationName: MethodStringName1<AnimationMixer, Animation?, StringName> =
        MethodStringName1<AnimationMixer, Animation?, StringName>("get_animation")

    @JvmField
    public val getAnimationListName: MethodStringName0<AnimationMixer, PackedStringArray> =
        MethodStringName0<AnimationMixer, PackedStringArray>("get_animation_list")

    @JvmField
    public val setActiveName: MethodStringName1<AnimationMixer, Unit, Boolean> =
        MethodStringName1<AnimationMixer, Unit, Boolean>("set_active")

    @JvmField
    public val isActiveName: MethodStringName0<AnimationMixer, Boolean> =
        MethodStringName0<AnimationMixer, Boolean>("is_active")

    @JvmField
    public val setDeterministicName: MethodStringName1<AnimationMixer, Unit, Boolean> =
        MethodStringName1<AnimationMixer, Unit, Boolean>("set_deterministic")

    @JvmField
    public val isDeterministicName: MethodStringName0<AnimationMixer, Boolean> =
        MethodStringName0<AnimationMixer, Boolean>("is_deterministic")

    @JvmField
    public val setRootNodeName: MethodStringName1<AnimationMixer, Unit, NodePath> =
        MethodStringName1<AnimationMixer, Unit, NodePath>("set_root_node")

    @JvmField
    public val getRootNodeName: MethodStringName0<AnimationMixer, NodePath> =
        MethodStringName0<AnimationMixer, NodePath>("get_root_node")

    @JvmField
    public val setCallbackModeProcessName:
        MethodStringName1<AnimationMixer, Unit, AnimationCallbackModeProcess> =
        MethodStringName1<AnimationMixer, Unit, AnimationCallbackModeProcess>("set_callback_mode_process")

    @JvmField
    public val getCallbackModeProcessName:
        MethodStringName0<AnimationMixer, AnimationCallbackModeProcess> =
        MethodStringName0<AnimationMixer, AnimationCallbackModeProcess>("get_callback_mode_process")

    @JvmField
    public val setCallbackModeMethodName:
        MethodStringName1<AnimationMixer, Unit, AnimationCallbackModeMethod> =
        MethodStringName1<AnimationMixer, Unit, AnimationCallbackModeMethod>("set_callback_mode_method")

    @JvmField
    public val getCallbackModeMethodName:
        MethodStringName0<AnimationMixer, AnimationCallbackModeMethod> =
        MethodStringName0<AnimationMixer, AnimationCallbackModeMethod>("get_callback_mode_method")

    @JvmField
    public val setCallbackModeDiscreteName:
        MethodStringName1<AnimationMixer, Unit, AnimationCallbackModeDiscrete> =
        MethodStringName1<AnimationMixer, Unit, AnimationCallbackModeDiscrete>("set_callback_mode_discrete")

    @JvmField
    public val getCallbackModeDiscreteName:
        MethodStringName0<AnimationMixer, AnimationCallbackModeDiscrete> =
        MethodStringName0<AnimationMixer, AnimationCallbackModeDiscrete>("get_callback_mode_discrete")

    @JvmField
    public val setAudioMaxPolyphonyName: MethodStringName1<AnimationMixer, Unit, Int> =
        MethodStringName1<AnimationMixer, Unit, Int>("set_audio_max_polyphony")

    @JvmField
    public val getAudioMaxPolyphonyName: MethodStringName0<AnimationMixer, Int> =
        MethodStringName0<AnimationMixer, Int>("get_audio_max_polyphony")

    @JvmField
    public val setRootMotionTrackName: MethodStringName1<AnimationMixer, Unit, NodePath> =
        MethodStringName1<AnimationMixer, Unit, NodePath>("set_root_motion_track")

    @JvmField
    public val getRootMotionTrackName: MethodStringName0<AnimationMixer, NodePath> =
        MethodStringName0<AnimationMixer, NodePath>("get_root_motion_track")

    @JvmField
    public val setRootMotionLocalName: MethodStringName1<AnimationMixer, Unit, Boolean> =
        MethodStringName1<AnimationMixer, Unit, Boolean>("set_root_motion_local")

    @JvmField
    public val isRootMotionLocalName: MethodStringName0<AnimationMixer, Boolean> =
        MethodStringName0<AnimationMixer, Boolean>("is_root_motion_local")

    @JvmField
    public val getRootMotionPositionName: MethodStringName0<AnimationMixer, Vector3> =
        MethodStringName0<AnimationMixer, Vector3>("get_root_motion_position")

    @JvmField
    public val getRootMotionRotationName: MethodStringName0<AnimationMixer, Quaternion> =
        MethodStringName0<AnimationMixer, Quaternion>("get_root_motion_rotation")

    @JvmField
    public val getRootMotionScaleName: MethodStringName0<AnimationMixer, Vector3> =
        MethodStringName0<AnimationMixer, Vector3>("get_root_motion_scale")

    @JvmField
    public val getRootMotionPositionAccumulatorName: MethodStringName0<AnimationMixer, Vector3> =
        MethodStringName0<AnimationMixer, Vector3>("get_root_motion_position_accumulator")

    @JvmField
    public val getRootMotionRotationAccumulatorName: MethodStringName0<AnimationMixer, Quaternion> =
        MethodStringName0<AnimationMixer, Quaternion>("get_root_motion_rotation_accumulator")

    @JvmField
    public val getRootMotionScaleAccumulatorName: MethodStringName0<AnimationMixer, Vector3> =
        MethodStringName0<AnimationMixer, Vector3>("get_root_motion_scale_accumulator")

    @JvmField
    public val clearCachesName: MethodStringName0<AnimationMixer, Unit> =
        MethodStringName0<AnimationMixer, Unit>("clear_caches")

    @JvmField
    public val advanceName: MethodStringName1<AnimationMixer, Unit, Double> =
        MethodStringName1<AnimationMixer, Unit, Double>("advance")

    @JvmField
    public val captureName:
        MethodStringName4<AnimationMixer, Unit, StringName, Double, Tween.TransitionType, Tween.EaseType>
        =
        MethodStringName4<AnimationMixer, Unit, StringName, Double, Tween.TransitionType, Tween.EaseType>("capture")

    @JvmField
    public val setResetOnSaveEnabledName: MethodStringName1<AnimationMixer, Unit, Boolean> =
        MethodStringName1<AnimationMixer, Unit, Boolean>("set_reset_on_save_enabled")

    @JvmField
    public val isResetOnSaveEnabledName: MethodStringName0<AnimationMixer, Boolean> =
        MethodStringName0<AnimationMixer, Boolean>("is_reset_on_save_enabled")

    @JvmField
    public val findAnimationName: MethodStringName1<AnimationMixer, StringName, Animation?> =
        MethodStringName1<AnimationMixer, StringName, Animation?>("find_animation")

    @JvmField
    public val findAnimationLibraryName: MethodStringName1<AnimationMixer, StringName, Animation?> =
        MethodStringName1<AnimationMixer, StringName, Animation?>("find_animation_library")
  }

  public object MethodBindings {
    internal val addAnimationLibraryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "add_animation_library", 618909818)

    internal val removeAnimationLibraryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "remove_animation_library", 3304788590)

    internal val renameAnimationLibraryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "rename_animation_library", 3740211285)

    internal val hasAnimationLibraryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "has_animation_library", 2619796661)

    internal val getAnimationLibraryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_animation_library", 147342321)

    internal val getAnimationLibraryListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_animation_library_list", 3995934104)

    internal val hasAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "has_animation", 2619796661)

    internal val getAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_animation", 2933122410)

    internal val getAnimationListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_animation_list", 1139954409)

    internal val setActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_active", 2586408642)

    internal val isActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "is_active", 36873697)

    internal val setDeterministicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_deterministic", 2586408642)

    internal val isDeterministicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "is_deterministic", 36873697)

    internal val setRootNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_root_node", 1348162250)

    internal val getRootNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_root_node", 4075236667)

    internal val setCallbackModeProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_callback_mode_process", 2153733086)

    internal val getCallbackModeProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_callback_mode_process", 1394468472)

    internal val setCallbackModeMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_callback_mode_method", 742218271)

    internal val getCallbackModeMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_callback_mode_method", 489449656)

    internal val setCallbackModeDiscretePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_callback_mode_discrete", 1998944670)

    internal val getCallbackModeDiscretePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_callback_mode_discrete", 3493168860)

    internal val setAudioMaxPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_audio_max_polyphony", 1286410249)

    internal val getAudioMaxPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_audio_max_polyphony", 3905245786)

    internal val setRootMotionTrackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_root_motion_track", 1348162250)

    internal val getRootMotionTrackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_root_motion_track", 4075236667)

    internal val setRootMotionLocalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_root_motion_local", 2586408642)

    internal val isRootMotionLocalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "is_root_motion_local", 36873697)

    internal val getRootMotionPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_root_motion_position", 3360562783)

    internal val getRootMotionRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_root_motion_rotation", 1222331677)

    internal val getRootMotionScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_root_motion_scale", 3360562783)

    internal val getRootMotionPositionAccumulatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_root_motion_position_accumulator", 3360562783)

    internal val getRootMotionRotationAccumulatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_root_motion_rotation_accumulator", 1222331677)

    internal val getRootMotionScaleAccumulatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "get_root_motion_scale_accumulator", 3360562783)

    internal val clearCachesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "clear_caches", 3218959716)

    internal val advancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "advance", 373806689)

    internal val capturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "capture", 1333632127)

    internal val setResetOnSaveEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "set_reset_on_save_enabled", 2586408642)

    internal val isResetOnSaveEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "is_reset_on_save_enabled", 36873697)

    internal val findAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "find_animation", 1559484580)

    internal val findAnimationLibraryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationMixer", "find_animation_library", 1559484580)
  }
}
