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
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.NodePath
import godot.core.PackedStringArray
import godot.core.Quaternion
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.QUATERNION
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR3
import godot.core.Vector2
import godot.core.Vector3
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This resource holds data that can be used to animate anything in the engine. Animations are
 * divided into tracks and each track must be linked to a node. The state of that node can be changed
 * through time, by adding timed keys (events) to the track.
 *
 * ```gdscript
 * //gdscript
 * # This creates an animation that makes the node "Enemy" move to the right by
 * # 100 pixels in 2.0 seconds.
 * var animation = Animation.new()
 * var track_index = animation.add_track(Animation.TYPE_VALUE)
 * animation.track_set_path(track_index, "Enemy:position:x")
 * animation.track_insert_key(track_index, 0.0, 0)
 * animation.track_insert_key(track_index, 2.0, 100)
 * animation.length = 2.0
 * ```
 *
 * ```csharp
 * //csharp
 * // This creates an animation that makes the node "Enemy" move to the right by
 * // 100 pixels in 2.0 seconds.
 * var animation = new Animation();
 * int trackIndex = animation.AddTrack(Animation.TrackType.Value);
 * animation.TrackSetPath(trackIndex, "Enemy:position:x");
 * animation.TrackInsertKey(trackIndex, 0.0f, 0);
 * animation.TrackInsertKey(trackIndex, 2.0f, 100);
 * animation.Length = 2.0f;
 * ```
 *
 * Animations are just data containers, and must be added to nodes such as an [AnimationPlayer] to
 * be played back. Animation tracks have different types, each with its own set of dedicated methods.
 * Check [TrackType] to see available types.
 *
 * **Note:** For 3D position/rotation/scale, using the dedicated [TYPE_POSITION_3D],
 * [TYPE_ROTATION_3D] and [TYPE_SCALE_3D] track types instead of [TYPE_VALUE] is recommended for
 * performance reasons.
 */
@GodotBaseType
public open class Animation : Resource() {
  /**
   * The total length of the animation (in seconds).
   *
   * **Note:** Length is not delimited by the last key, as this one may be before or after the end
   * to ensure correct interpolation and looping.
   */
  public final inline var length: Double
    @JvmName("lengthProperty")
    get() = getLength()
    @JvmName("lengthProperty")
    set(`value`) {
      setLength(value)
    }

  /**
   * Determines the behavior of both ends of the animation timeline during animation playback. This
   * indicates whether and how the animation should be restarted, and is also used to correctly
   * interpolate animation cycles.
   */
  public final inline var loopMode: LoopMode
    @JvmName("loopModeProperty")
    get() = getLoopMode()
    @JvmName("loopModeProperty")
    set(`value`) {
      setLoopMode(value)
    }

  /**
   * The animation step value.
   */
  public final inline var step: Float
    @JvmName("stepProperty")
    get() = getStep()
    @JvmName("stepProperty")
    set(`value`) {
      setStep(value)
    }

  /**
   * Returns `true` if the capture track is included. This is a cached readonly value for
   * performance.
   */
  public final inline val captureIncluded: Boolean
    @JvmName("captureIncludedProperty")
    get() = isCaptureIncluded()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(12, scriptPtr)
  }

  /**
   * Adds a track to the Animation.
   */
  @JvmOverloads
  public final fun addTrack(type: TrackType, atPosition: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to atPosition.toLong())
    TransferContext.callMethod(MethodBindings.addTrackPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes a track by specifying the track index.
   */
  public final fun removeTrack(trackIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.removeTrackPtr)
  }

  /**
   * Returns the amount of tracks in the animation.
   */
  public final fun getTrackCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets the type of a track.
   */
  public final fun trackGetType(trackIdx: Int): TrackType {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackGetTypePtr)
    return TrackType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Gets the path of a track. For more information on the path format, see [trackSetPath].
   */
  public final fun trackGetPath(trackIdx: Int): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackGetPathPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * Sets the path of a track. Paths must be valid scene-tree paths to a node and must be specified
   * starting from the [AnimationMixer.rootNode] that will reproduce the animation. Tracks that control
   * properties or bones must append their name after the path, separated by `":"`.
   *
   * For example, `"character/skeleton:ankle"` or `"character/mesh:transform/local"`.
   */
  public final fun trackSetPath(trackIdx: Int, path: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), NODE_PATH to path)
    TransferContext.callMethod(MethodBindings.trackSetPathPtr)
  }

  /**
   * Returns the index of the specified track. If the track is not found, return -1.
   */
  public final fun findTrack(path: NodePath, type: TrackType): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to path, LONG to type.value)
    TransferContext.callMethod(MethodBindings.findTrackPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Moves a track up.
   */
  public final fun trackMoveUp(trackIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackMoveUpPtr)
  }

  /**
   * Moves a track down.
   */
  public final fun trackMoveDown(trackIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackMoveDownPtr)
  }

  /**
   * Changes the index position of track [trackIdx] to the one defined in [toIdx].
   */
  public final fun trackMoveTo(trackIdx: Int, toIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to toIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackMoveToPtr)
  }

  /**
   * Swaps the track [trackIdx]'s index position with the track [withIdx].
   */
  public final fun trackSwap(trackIdx: Int, withIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to withIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackSwapPtr)
  }

  /**
   * Sets the given track as imported or not.
   */
  public final fun trackSetImported(trackIdx: Int, imported: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), BOOL to imported)
    TransferContext.callMethod(MethodBindings.trackSetImportedPtr)
  }

  /**
   * Returns `true` if the given track is imported. Else, return `false`.
   */
  public final fun trackIsImported(trackIdx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackIsImportedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Enables/disables the given track. Tracks are enabled by default.
   */
  public final fun trackSetEnabled(trackIdx: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.trackSetEnabledPtr)
  }

  /**
   * Returns `true` if the track at index [trackIdx] is enabled.
   */
  public final fun trackIsEnabled(trackIdx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackIsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Inserts a key in a given 3D position track. Returns the key index.
   */
  public final fun positionTrackInsertKey(
    trackIdx: Int,
    time: Double,
    position: Vector3,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.positionTrackInsertKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Inserts a key in a given 3D rotation track. Returns the key index.
   */
  public final fun rotationTrackInsertKey(
    trackIdx: Int,
    time: Double,
    rotation: Quaternion,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, QUATERNION to rotation)
    TransferContext.callMethod(MethodBindings.rotationTrackInsertKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Inserts a key in a given 3D scale track. Returns the key index.
   */
  public final fun scaleTrackInsertKey(
    trackIdx: Int,
    time: Double,
    scale: Vector3,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, VECTOR3 to scale)
    TransferContext.callMethod(MethodBindings.scaleTrackInsertKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Inserts a key in a given blend shape track. Returns the key index.
   */
  public final fun blendShapeTrackInsertKey(
    trackIdx: Int,
    time: Double,
    amount: Float,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.blendShapeTrackInsertKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the interpolated position value at the given time (in seconds). The [trackIdx] must be
   * the index of a 3D position track.
   */
  @JvmOverloads
  public final fun positionTrackInterpolate(
    trackIdx: Int,
    timeSec: Double,
    backward: Boolean = false,
  ): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to timeSec, BOOL to backward)
    TransferContext.callMethod(MethodBindings.positionTrackInterpolatePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the interpolated rotation value at the given time (in seconds). The [trackIdx] must be
   * the index of a 3D rotation track.
   */
  @JvmOverloads
  public final fun rotationTrackInterpolate(
    trackIdx: Int,
    timeSec: Double,
    backward: Boolean = false,
  ): Quaternion {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to timeSec, BOOL to backward)
    TransferContext.callMethod(MethodBindings.rotationTrackInterpolatePtr)
    return (TransferContext.readReturnValue(QUATERNION) as Quaternion)
  }

  /**
   * Returns the interpolated scale value at the given time (in seconds). The [trackIdx] must be the
   * index of a 3D scale track.
   */
  @JvmOverloads
  public final fun scaleTrackInterpolate(
    trackIdx: Int,
    timeSec: Double,
    backward: Boolean = false,
  ): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to timeSec, BOOL to backward)
    TransferContext.callMethod(MethodBindings.scaleTrackInterpolatePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the interpolated blend shape value at the given time (in seconds). The [trackIdx] must
   * be the index of a blend shape track.
   */
  @JvmOverloads
  public final fun blendShapeTrackInterpolate(
    trackIdx: Int,
    timeSec: Double,
    backward: Boolean = false,
  ): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to timeSec, BOOL to backward)
    TransferContext.callMethod(MethodBindings.blendShapeTrackInterpolatePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Inserts a generic key in a given track. Returns the key index.
   */
  @JvmOverloads
  public final fun trackInsertKey(
    trackIdx: Int,
    time: Double,
    key: Any?,
    transition: Float = 1.0f,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, ANY to key, DOUBLE to transition.toDouble())
    TransferContext.callMethod(MethodBindings.trackInsertKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes a key by index in a given track.
   */
  public final fun trackRemoveKey(trackIdx: Int, keyIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackRemoveKeyPtr)
  }

  /**
   * Removes a key at [time] in a given track.
   */
  public final fun trackRemoveKeyAtTime(trackIdx: Int, time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time)
    TransferContext.callMethod(MethodBindings.trackRemoveKeyAtTimePtr)
  }

  /**
   * Sets the value of an existing key.
   */
  public final fun trackSetKeyValue(
    trackIdx: Int,
    key: Int,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to key.toLong(), ANY to value)
    TransferContext.callMethod(MethodBindings.trackSetKeyValuePtr)
  }

  /**
   * Sets the transition curve (easing) for a specific key (see the built-in math function
   * [@GlobalScope.ease]).
   */
  public final fun trackSetKeyTransition(
    trackIdx: Int,
    keyIdx: Int,
    transition: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), DOUBLE to transition.toDouble())
    TransferContext.callMethod(MethodBindings.trackSetKeyTransitionPtr)
  }

  /**
   * Sets the time of an existing key.
   */
  public final fun trackSetKeyTime(
    trackIdx: Int,
    keyIdx: Int,
    time: Double,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), DOUBLE to time)
    TransferContext.callMethod(MethodBindings.trackSetKeyTimePtr)
  }

  /**
   * Returns the transition curve (easing) for a specific key (see the built-in math function
   * [@GlobalScope.ease]).
   */
  public final fun trackGetKeyTransition(trackIdx: Int, keyIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackGetKeyTransitionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the number of keys in a given track.
   */
  public final fun trackGetKeyCount(trackIdx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackGetKeyCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the value of a given key in a given track.
   */
  public final fun trackGetKeyValue(trackIdx: Int, keyIdx: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackGetKeyValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the time at which the key is located.
   */
  public final fun trackGetKeyTime(trackIdx: Int, keyIdx: Int): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackGetKeyTimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Finds the key index by time in a given track. Optionally, only find it if the approx/exact time
   * is given.
   *
   * If [limit] is `true`, it does not return keys outside the animation range.
   *
   * If [backward] is `true`, the direction is reversed in methods that rely on one directional
   * processing.
   *
   * For example, in case [findMode] is [FIND_MODE_NEAREST], if there is no key in the current
   * position just after seeked, the first key found is retrieved by searching before the position, but
   * if [backward] is `true`, the first key found is retrieved after the position.
   */
  @JvmOverloads
  public final fun trackFindKey(
    trackIdx: Int,
    time: Double,
    findMode: FindMode = Animation.FindMode.NEAREST,
    limit: Boolean = false,
    backward: Boolean = false,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, LONG to findMode.value, BOOL to limit, BOOL to backward)
    TransferContext.callMethod(MethodBindings.trackFindKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the interpolation type of a given track.
   */
  public final fun trackSetInterpolationType(trackIdx: Int, interpolation: InterpolationType):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to interpolation.value)
    TransferContext.callMethod(MethodBindings.trackSetInterpolationTypePtr)
  }

  /**
   * Returns the interpolation type of a given track.
   */
  public final fun trackGetInterpolationType(trackIdx: Int): InterpolationType {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackGetInterpolationTypePtr)
    return InterpolationType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If `true`, the track at [trackIdx] wraps the interpolation loop.
   */
  public final fun trackSetInterpolationLoopWrap(trackIdx: Int, interpolation: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), BOOL to interpolation)
    TransferContext.callMethod(MethodBindings.trackSetInterpolationLoopWrapPtr)
  }

  /**
   * Returns `true` if the track at [trackIdx] wraps the interpolation loop. New tracks wrap the
   * interpolation loop by default.
   */
  public final fun trackGetInterpolationLoopWrap(trackIdx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackGetInterpolationLoopWrapPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the track is compressed, `false` otherwise. See also [compress].
   */
  public final fun trackIsCompressed(trackIdx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.trackIsCompressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the update mode of a value track.
   */
  public final fun valueTrackSetUpdateMode(trackIdx: Int, mode: UpdateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to mode.value)
    TransferContext.callMethod(MethodBindings.valueTrackSetUpdateModePtr)
  }

  /**
   * Returns the update mode of a value track.
   */
  public final fun valueTrackGetUpdateMode(trackIdx: Int): UpdateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.valueTrackGetUpdateModePtr)
    return UpdateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the interpolated value at the given time (in seconds). The [trackIdx] must be the index
   * of a value track.
   *
   * A [backward] mainly affects the direction of key retrieval of the track with [UPDATE_DISCRETE]
   * converted by [AnimationMixer.ANIMATION_CALLBACK_MODE_DISCRETE_FORCE_CONTINUOUS] to match the
   * result with [trackFindKey].
   */
  @JvmOverloads
  public final fun valueTrackInterpolate(
    trackIdx: Int,
    timeSec: Double,
    backward: Boolean = false,
  ): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to timeSec, BOOL to backward)
    TransferContext.callMethod(MethodBindings.valueTrackInterpolatePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the method name of a method track.
   */
  public final fun methodTrackGetName(trackIdx: Int, keyIdx: Int): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.methodTrackGetNamePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Returns the arguments values to be called on a method track for a given key in a given track.
   */
  public final fun methodTrackGetParams(trackIdx: Int, keyIdx: Int): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.methodTrackGetParamsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Inserts a Bezier Track key at the given [time] in seconds. The [trackIdx] must be the index of
   * a Bezier Track.
   *
   * [inHandle] is the left-side weight of the added Bezier curve point, [outHandle] is the
   * right-side one, while [value] is the actual value at this point.
   */
  @JvmOverloads
  public final fun bezierTrackInsertKey(
    trackIdx: Int,
    time: Double,
    `value`: Float,
    inHandle: Vector2 = Vector2(0, 0),
    outHandle: Vector2 = Vector2(0, 0),
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, DOUBLE to value.toDouble(), VECTOR2 to inHandle, VECTOR2 to outHandle)
    TransferContext.callMethod(MethodBindings.bezierTrackInsertKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the value of the key identified by [keyIdx] to the given value. The [trackIdx] must be the
   * index of a Bezier Track.
   */
  public final fun bezierTrackSetKeyValue(
    trackIdx: Int,
    keyIdx: Int,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.bezierTrackSetKeyValuePtr)
  }

  /**
   * Sets the in handle of the key identified by [keyIdx] to value [inHandle]. The [trackIdx] must
   * be the index of a Bezier Track.
   */
  @JvmOverloads
  public final fun bezierTrackSetKeyInHandle(
    trackIdx: Int,
    keyIdx: Int,
    inHandle: Vector2,
    balancedValueTimeRatio: Float = 1.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), VECTOR2 to inHandle, DOUBLE to balancedValueTimeRatio.toDouble())
    TransferContext.callMethod(MethodBindings.bezierTrackSetKeyInHandlePtr)
  }

  /**
   * Sets the out handle of the key identified by [keyIdx] to value [outHandle]. The [trackIdx] must
   * be the index of a Bezier Track.
   */
  @JvmOverloads
  public final fun bezierTrackSetKeyOutHandle(
    trackIdx: Int,
    keyIdx: Int,
    outHandle: Vector2,
    balancedValueTimeRatio: Float = 1.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), VECTOR2 to outHandle, DOUBLE to balancedValueTimeRatio.toDouble())
    TransferContext.callMethod(MethodBindings.bezierTrackSetKeyOutHandlePtr)
  }

  /**
   * Returns the value of the key identified by [keyIdx]. The [trackIdx] must be the index of a
   * Bezier Track.
   */
  public final fun bezierTrackGetKeyValue(trackIdx: Int, keyIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.bezierTrackGetKeyValuePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the in handle of the key identified by [keyIdx]. The [trackIdx] must be the index of a
   * Bezier Track.
   */
  public final fun bezierTrackGetKeyInHandle(trackIdx: Int, keyIdx: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.bezierTrackGetKeyInHandlePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the out handle of the key identified by [keyIdx]. The [trackIdx] must be the index of a
   * Bezier Track.
   */
  public final fun bezierTrackGetKeyOutHandle(trackIdx: Int, keyIdx: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.bezierTrackGetKeyOutHandlePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the interpolated value at the given [time] (in seconds). The [trackIdx] must be the
   * index of a Bezier Track.
   */
  public final fun bezierTrackInterpolate(trackIdx: Int, time: Double): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time)
    TransferContext.callMethod(MethodBindings.bezierTrackInterpolatePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Inserts an Audio Track key at the given [time] in seconds. The [trackIdx] must be the index of
   * an Audio Track.
   *
   * [stream] is the [AudioStream] resource to play. [startOffset] is the number of seconds cut off
   * at the beginning of the audio stream, while [endOffset] is at the ending.
   */
  @JvmOverloads
  public final fun audioTrackInsertKey(
    trackIdx: Int,
    time: Double,
    stream: Resource?,
    startOffset: Float = 0.0f,
    endOffset: Float = 0.0f,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, OBJECT to stream, DOUBLE to startOffset.toDouble(), DOUBLE to endOffset.toDouble())
    TransferContext.callMethod(MethodBindings.audioTrackInsertKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the stream of the key identified by [keyIdx] to value [stream]. The [trackIdx] must be the
   * index of an Audio Track.
   */
  public final fun audioTrackSetKeyStream(
    trackIdx: Int,
    keyIdx: Int,
    stream: Resource?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), OBJECT to stream)
    TransferContext.callMethod(MethodBindings.audioTrackSetKeyStreamPtr)
  }

  /**
   * Sets the start offset of the key identified by [keyIdx] to value [offset]. The [trackIdx] must
   * be the index of an Audio Track.
   */
  public final fun audioTrackSetKeyStartOffset(
    trackIdx: Int,
    keyIdx: Int,
    offset: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.audioTrackSetKeyStartOffsetPtr)
  }

  /**
   * Sets the end offset of the key identified by [keyIdx] to value [offset]. The [trackIdx] must be
   * the index of an Audio Track.
   */
  public final fun audioTrackSetKeyEndOffset(
    trackIdx: Int,
    keyIdx: Int,
    offset: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.audioTrackSetKeyEndOffsetPtr)
  }

  /**
   * Returns the audio stream of the key identified by [keyIdx]. The [trackIdx] must be the index of
   * an Audio Track.
   */
  public final fun audioTrackGetKeyStream(trackIdx: Int, keyIdx: Int): Resource? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.audioTrackGetKeyStreamPtr)
    return (TransferContext.readReturnValue(OBJECT) as Resource?)
  }

  /**
   * Returns the start offset of the key identified by [keyIdx]. The [trackIdx] must be the index of
   * an Audio Track.
   *
   * Start offset is the number of seconds cut off at the beginning of the audio stream.
   */
  public final fun audioTrackGetKeyStartOffset(trackIdx: Int, keyIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.audioTrackGetKeyStartOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the end offset of the key identified by [keyIdx]. The [trackIdx] must be the index of
   * an Audio Track.
   *
   * End offset is the number of seconds cut off at the ending of the audio stream.
   */
  public final fun audioTrackGetKeyEndOffset(trackIdx: Int, keyIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.audioTrackGetKeyEndOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets whether the track will be blended with other animations. If `true`, the audio playback
   * volume changes depending on the blend value.
   */
  public final fun audioTrackSetUseBlend(trackIdx: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.audioTrackSetUseBlendPtr)
  }

  /**
   * Returns `true` if the track at [trackIdx] will be blended with other animations.
   */
  public final fun audioTrackIsUseBlend(trackIdx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong())
    TransferContext.callMethod(MethodBindings.audioTrackIsUseBlendPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Inserts a key with value [animation] at the given [time] (in seconds). The [trackIdx] must be
   * the index of an Animation Track.
   */
  public final fun animationTrackInsertKey(
    trackIdx: Int,
    time: Double,
    animation: StringName,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), DOUBLE to time, STRING_NAME to animation)
    TransferContext.callMethod(MethodBindings.animationTrackInsertKeyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the key identified by [keyIdx] to value [animation]. The [trackIdx] must be the index of
   * an Animation Track.
   */
  public final fun animationTrackSetKeyAnimation(
    trackIdx: Int,
    keyIdx: Int,
    animation: StringName,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong(), STRING_NAME to animation)
    TransferContext.callMethod(MethodBindings.animationTrackSetKeyAnimationPtr)
  }

  /**
   * Returns the animation name at the key identified by [keyIdx]. The [trackIdx] must be the index
   * of an Animation Track.
   */
  public final fun animationTrackGetKeyAnimation(trackIdx: Int, keyIdx: Int): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), LONG to keyIdx.toLong())
    TransferContext.callMethod(MethodBindings.animationTrackGetKeyAnimationPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Adds a marker to this Animation.
   */
  public final fun addMarker(name: StringName, time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.addMarkerPtr)
  }

  /**
   * Removes the marker with the given name from this Animation.
   */
  public final fun removeMarker(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeMarkerPtr)
  }

  /**
   * Returns `true` if this Animation contains a marker with the given name.
   */
  public final fun hasMarker(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasMarkerPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the name of the marker located at the given time.
   */
  public final fun getMarkerAtTime(time: Double): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.getMarkerAtTimePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Returns the closest marker that comes after the given time. If no such marker exists, an empty
   * string is returned.
   */
  public final fun getNextMarker(time: Double): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.getNextMarkerPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Returns the closest marker that comes before the given time. If no such marker exists, an empty
   * string is returned.
   */
  public final fun getPrevMarker(time: Double): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.getPrevMarkerPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Returns the given marker's time.
   */
  public final fun getMarkerTime(name: StringName): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getMarkerTimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns every marker in this Animation, sorted ascending by time.
   */
  public final fun getMarkerNames(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarkerNamesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns the given marker's color.
   */
  public final fun getMarkerColor(name: StringName): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getMarkerColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Sets the given marker's color.
   */
  public final fun setMarkerColor(name: StringName, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, COLOR to color)
    TransferContext.callMethod(MethodBindings.setMarkerColorPtr)
  }

  public final fun setLength(timeSec: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to timeSec)
    TransferContext.callMethod(MethodBindings.setLengthPtr)
  }

  public final fun getLength(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setLoopMode(loopMode: LoopMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to loopMode.value)
    TransferContext.callMethod(MethodBindings.setLoopModePtr)
  }

  public final fun getLoopMode(): LoopMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLoopModePtr)
    return LoopMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setStep(sizeSec: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to sizeSec.toDouble())
    TransferContext.callMethod(MethodBindings.setStepPtr)
  }

  public final fun getStep(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStepPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Clear the animation (clear all tracks and reset all).
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Adds a new track to [toAnimation] that is a copy of the given track from this animation.
   */
  public final fun copyTrack(trackIdx: Int, toAnimation: Animation?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackIdx.toLong(), OBJECT to toAnimation)
    TransferContext.callMethod(MethodBindings.copyTrackPtr)
  }

  /**
   * Optimize the animation and all its tracks in-place. This will preserve only as many keys as are
   * necessary to keep the animation within the specified bounds.
   */
  @JvmOverloads
  public final fun optimize(
    allowedVelocityErr: Float = 0.01f,
    allowedAngularErr: Float = 0.01f,
    precision: Int = 3,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to allowedVelocityErr.toDouble(), DOUBLE to allowedAngularErr.toDouble(), LONG to precision.toLong())
    TransferContext.callMethod(MethodBindings.optimizePtr)
  }

  /**
   * Compress the animation and all its tracks in-place. This will make [trackIsCompressed] return
   * `true` once called on this [Animation]. Compressed tracks require less memory to be played, and
   * are designed to be used for complex 3D animations (such as cutscenes) imported from external 3D
   * software. Compression is lossy, but the difference is usually not noticeable in real world
   * conditions.
   *
   * **Note:** Compressed tracks have various limitations (such as not being editable from the
   * editor), so only use compressed animations if you actually need them.
   */
  @JvmOverloads
  public final fun compress(
    pageSize: Long = 8192,
    fps: Long = 120,
    splitTolerance: Float = 4.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pageSize, LONG to fps, DOUBLE to splitTolerance.toDouble())
    TransferContext.callMethod(MethodBindings.compressPtr)
  }

  public final fun isCaptureIncluded(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCaptureIncludedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the path of a track. Paths must be valid scene-tree paths to a node and must be specified
   * starting from the [AnimationMixer.rootNode] that will reproduce the animation. Tracks that control
   * properties or bones must append their name after the path, separated by `":"`.
   *
   * For example, `"character/skeleton:ankle"` or `"character/mesh:transform/local"`.
   */
  public final fun trackSetPath(trackIdx: Int, path: String) =
      trackSetPath(trackIdx, path.asCachedNodePath())

  /**
   * Returns the index of the specified track. If the track is not found, return -1.
   */
  public final fun findTrack(path: String, type: TrackType): Int =
      findTrack(path.asCachedNodePath(), type)

  /**
   * Inserts a key with value [animation] at the given [time] (in seconds). The [trackIdx] must be
   * the index of an Animation Track.
   */
  public final fun animationTrackInsertKey(
    trackIdx: Int,
    time: Double,
    animation: String,
  ): Int = animationTrackInsertKey(trackIdx, time, animation.asCachedStringName())

  /**
   * Sets the key identified by [keyIdx] to value [animation]. The [trackIdx] must be the index of
   * an Animation Track.
   */
  public final fun animationTrackSetKeyAnimation(
    trackIdx: Int,
    keyIdx: Int,
    animation: String,
  ) = animationTrackSetKeyAnimation(trackIdx, keyIdx, animation.asCachedStringName())

  /**
   * Adds a marker to this Animation.
   */
  public final fun addMarker(name: String, time: Double) =
      addMarker(name.asCachedStringName(), time)

  /**
   * Removes the marker with the given name from this Animation.
   */
  public final fun removeMarker(name: String) = removeMarker(name.asCachedStringName())

  /**
   * Returns `true` if this Animation contains a marker with the given name.
   */
  public final fun hasMarker(name: String): Boolean = hasMarker(name.asCachedStringName())

  /**
   * Returns the given marker's time.
   */
  public final fun getMarkerTime(name: String): Double = getMarkerTime(name.asCachedStringName())

  /**
   * Returns the given marker's color.
   */
  public final fun getMarkerColor(name: String): Color = getMarkerColor(name.asCachedStringName())

  /**
   * Sets the given marker's color.
   */
  public final fun setMarkerColor(name: String, color: Color) =
      setMarkerColor(name.asCachedStringName(), color)

  public enum class TrackType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Value tracks set values in node properties, but only those which can be interpolated. For 3D
     * position/rotation/scale, using the dedicated [TYPE_POSITION_3D], [TYPE_ROTATION_3D] and
     * [TYPE_SCALE_3D] track types instead of [TYPE_VALUE] is recommended for performance reasons.
     */
    TYPE_VALUE(0),
    /**
     * 3D position track (values are stored in [Vector3]s).
     */
    TYPE_POSITION_3D(1),
    /**
     * 3D rotation track (values are stored in [Quaternion]s).
     */
    TYPE_ROTATION_3D(2),
    /**
     * 3D scale track (values are stored in [Vector3]s).
     */
    TYPE_SCALE_3D(3),
    /**
     * Blend shape track.
     */
    TYPE_BLEND_SHAPE(4),
    /**
     * Method tracks call functions with given arguments per key.
     */
    TYPE_METHOD(5),
    /**
     * Bezier tracks are used to interpolate a value using custom curves. They can also be used to
     * animate sub-properties of vectors and colors (e.g. alpha value of a [Color]).
     */
    TYPE_BEZIER(6),
    /**
     * Audio tracks are used to play an audio stream with either type of [AudioStreamPlayer]. The
     * stream can be trimmed and previewed in the animation.
     */
    TYPE_AUDIO(7),
    /**
     * Animation tracks play animations in other [AnimationPlayer] nodes.
     */
    TYPE_ANIMATION(8),
    ;

    public companion object {
      public fun from(`value`: Long): TrackType = entries.single { it.`value` == `value` }
    }
  }

  public enum class InterpolationType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No interpolation (nearest value).
     */
    NEAREST(0),
    /**
     * Linear interpolation.
     */
    LINEAR(1),
    /**
     * Cubic interpolation. This looks smoother than linear interpolation, but is more expensive to
     * interpolate. Stick to [INTERPOLATION_LINEAR] for complex 3D animations imported from external
     * software, even if it requires using a higher animation framerate in return.
     */
    CUBIC(2),
    /**
     * Linear interpolation with shortest path rotation.
     *
     * **Note:** The result value is always normalized and may not match the key value.
     */
    LINEAR_ANGLE(3),
    /**
     * Cubic interpolation with shortest path rotation.
     *
     * **Note:** The result value is always normalized and may not match the key value.
     */
    CUBIC_ANGLE(4),
    ;

    public companion object {
      public fun from(`value`: Long): InterpolationType = entries.single { it.`value` == `value` }
    }
  }

  public enum class UpdateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Update between keyframes and hold the value.
     */
    CONTINUOUS(0),
    /**
     * Update at the keyframes.
     */
    DISCRETE(1),
    /**
     * Same as [UPDATE_CONTINUOUS] but works as a flag to capture the value of the current object
     * and perform interpolation in some methods. See also [AnimationMixer.capture],
     * [AnimationPlayer.playbackAutoCapture], and [AnimationPlayer.playWithCapture].
     */
    CAPTURE(2),
    ;

    public companion object {
      public fun from(`value`: Long): UpdateMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LoopMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * At both ends of the animation, the animation will stop playing.
     */
    NONE(0),
    /**
     * At both ends of the animation, the animation will be repeated without changing the playback
     * direction.
     */
    LINEAR(1),
    /**
     * Repeats playback and reverse playback at both ends of the animation.
     */
    PINGPONG(2),
    ;

    public companion object {
      public fun from(`value`: Long): LoopMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LoopedFlag(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This flag indicates that the animation proceeds without any looping.
     */
    NONE(0),
    /**
     * This flag indicates that the animation has reached the end of the animation and just after
     * loop processed.
     */
    END(1),
    /**
     * This flag indicates that the animation has reached the start of the animation and just after
     * loop processed.
     */
    START(2),
    ;

    public companion object {
      public fun from(`value`: Long): LoopedFlag = entries.single { it.`value` == `value` }
    }
  }

  public enum class FindMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Finds the nearest time key.
     */
    NEAREST(0),
    /**
     * Finds only the key with approximating the time.
     */
    APPROX(1),
    /**
     * Finds only the key with matching the time.
     */
    EXACT(2),
    ;

    public companion object {
      public fun from(`value`: Long): FindMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addTrackName: MethodStringName2<Animation, Int, TrackType, Int> =
        MethodStringName2<Animation, Int, TrackType, Int>("add_track")

    @JvmField
    public val removeTrackName: MethodStringName1<Animation, Unit, Int> =
        MethodStringName1<Animation, Unit, Int>("remove_track")

    @JvmField
    public val getTrackCountName: MethodStringName0<Animation, Int> =
        MethodStringName0<Animation, Int>("get_track_count")

    @JvmField
    public val trackGetTypeName: MethodStringName1<Animation, TrackType, Int> =
        MethodStringName1<Animation, TrackType, Int>("track_get_type")

    @JvmField
    public val trackGetPathName: MethodStringName1<Animation, NodePath, Int> =
        MethodStringName1<Animation, NodePath, Int>("track_get_path")

    @JvmField
    public val trackSetPathName: MethodStringName2<Animation, Unit, Int, NodePath> =
        MethodStringName2<Animation, Unit, Int, NodePath>("track_set_path")

    @JvmField
    public val findTrackName: MethodStringName2<Animation, Int, NodePath, TrackType> =
        MethodStringName2<Animation, Int, NodePath, TrackType>("find_track")

    @JvmField
    public val trackMoveUpName: MethodStringName1<Animation, Unit, Int> =
        MethodStringName1<Animation, Unit, Int>("track_move_up")

    @JvmField
    public val trackMoveDownName: MethodStringName1<Animation, Unit, Int> =
        MethodStringName1<Animation, Unit, Int>("track_move_down")

    @JvmField
    public val trackMoveToName: MethodStringName2<Animation, Unit, Int, Int> =
        MethodStringName2<Animation, Unit, Int, Int>("track_move_to")

    @JvmField
    public val trackSwapName: MethodStringName2<Animation, Unit, Int, Int> =
        MethodStringName2<Animation, Unit, Int, Int>("track_swap")

    @JvmField
    public val trackSetImportedName: MethodStringName2<Animation, Unit, Int, Boolean> =
        MethodStringName2<Animation, Unit, Int, Boolean>("track_set_imported")

    @JvmField
    public val trackIsImportedName: MethodStringName1<Animation, Boolean, Int> =
        MethodStringName1<Animation, Boolean, Int>("track_is_imported")

    @JvmField
    public val trackSetEnabledName: MethodStringName2<Animation, Unit, Int, Boolean> =
        MethodStringName2<Animation, Unit, Int, Boolean>("track_set_enabled")

    @JvmField
    public val trackIsEnabledName: MethodStringName1<Animation, Boolean, Int> =
        MethodStringName1<Animation, Boolean, Int>("track_is_enabled")

    @JvmField
    public val positionTrackInsertKeyName: MethodStringName3<Animation, Int, Int, Double, Vector3> =
        MethodStringName3<Animation, Int, Int, Double, Vector3>("position_track_insert_key")

    @JvmField
    public val rotationTrackInsertKeyName:
        MethodStringName3<Animation, Int, Int, Double, Quaternion> =
        MethodStringName3<Animation, Int, Int, Double, Quaternion>("rotation_track_insert_key")

    @JvmField
    public val scaleTrackInsertKeyName: MethodStringName3<Animation, Int, Int, Double, Vector3> =
        MethodStringName3<Animation, Int, Int, Double, Vector3>("scale_track_insert_key")

    @JvmField
    public val blendShapeTrackInsertKeyName: MethodStringName3<Animation, Int, Int, Double, Float> =
        MethodStringName3<Animation, Int, Int, Double, Float>("blend_shape_track_insert_key")

    @JvmField
    public val positionTrackInterpolateName:
        MethodStringName3<Animation, Vector3, Int, Double, Boolean> =
        MethodStringName3<Animation, Vector3, Int, Double, Boolean>("position_track_interpolate")

    @JvmField
    public val rotationTrackInterpolateName:
        MethodStringName3<Animation, Quaternion, Int, Double, Boolean> =
        MethodStringName3<Animation, Quaternion, Int, Double, Boolean>("rotation_track_interpolate")

    @JvmField
    public val scaleTrackInterpolateName:
        MethodStringName3<Animation, Vector3, Int, Double, Boolean> =
        MethodStringName3<Animation, Vector3, Int, Double, Boolean>("scale_track_interpolate")

    @JvmField
    public val blendShapeTrackInterpolateName:
        MethodStringName3<Animation, Float, Int, Double, Boolean> =
        MethodStringName3<Animation, Float, Int, Double, Boolean>("blend_shape_track_interpolate")

    @JvmField
    public val trackInsertKeyName: MethodStringName4<Animation, Int, Int, Double, Any?, Float> =
        MethodStringName4<Animation, Int, Int, Double, Any?, Float>("track_insert_key")

    @JvmField
    public val trackRemoveKeyName: MethodStringName2<Animation, Unit, Int, Int> =
        MethodStringName2<Animation, Unit, Int, Int>("track_remove_key")

    @JvmField
    public val trackRemoveKeyAtTimeName: MethodStringName2<Animation, Unit, Int, Double> =
        MethodStringName2<Animation, Unit, Int, Double>("track_remove_key_at_time")

    @JvmField
    public val trackSetKeyValueName: MethodStringName3<Animation, Unit, Int, Int, Any?> =
        MethodStringName3<Animation, Unit, Int, Int, Any?>("track_set_key_value")

    @JvmField
    public val trackSetKeyTransitionName: MethodStringName3<Animation, Unit, Int, Int, Float> =
        MethodStringName3<Animation, Unit, Int, Int, Float>("track_set_key_transition")

    @JvmField
    public val trackSetKeyTimeName: MethodStringName3<Animation, Unit, Int, Int, Double> =
        MethodStringName3<Animation, Unit, Int, Int, Double>("track_set_key_time")

    @JvmField
    public val trackGetKeyTransitionName: MethodStringName2<Animation, Float, Int, Int> =
        MethodStringName2<Animation, Float, Int, Int>("track_get_key_transition")

    @JvmField
    public val trackGetKeyCountName: MethodStringName1<Animation, Int, Int> =
        MethodStringName1<Animation, Int, Int>("track_get_key_count")

    @JvmField
    public val trackGetKeyValueName: MethodStringName2<Animation, Any?, Int, Int> =
        MethodStringName2<Animation, Any?, Int, Int>("track_get_key_value")

    @JvmField
    public val trackGetKeyTimeName: MethodStringName2<Animation, Double, Int, Int> =
        MethodStringName2<Animation, Double, Int, Int>("track_get_key_time")

    @JvmField
    public val trackFindKeyName:
        MethodStringName5<Animation, Int, Int, Double, FindMode, Boolean, Boolean> =
        MethodStringName5<Animation, Int, Int, Double, FindMode, Boolean, Boolean>("track_find_key")

    @JvmField
    public val trackSetInterpolationTypeName:
        MethodStringName2<Animation, Unit, Int, InterpolationType> =
        MethodStringName2<Animation, Unit, Int, InterpolationType>("track_set_interpolation_type")

    @JvmField
    public val trackGetInterpolationTypeName: MethodStringName1<Animation, InterpolationType, Int> =
        MethodStringName1<Animation, InterpolationType, Int>("track_get_interpolation_type")

    @JvmField
    public val trackSetInterpolationLoopWrapName: MethodStringName2<Animation, Unit, Int, Boolean> =
        MethodStringName2<Animation, Unit, Int, Boolean>("track_set_interpolation_loop_wrap")

    @JvmField
    public val trackGetInterpolationLoopWrapName: MethodStringName1<Animation, Boolean, Int> =
        MethodStringName1<Animation, Boolean, Int>("track_get_interpolation_loop_wrap")

    @JvmField
    public val trackIsCompressedName: MethodStringName1<Animation, Boolean, Int> =
        MethodStringName1<Animation, Boolean, Int>("track_is_compressed")

    @JvmField
    public val valueTrackSetUpdateModeName: MethodStringName2<Animation, Unit, Int, UpdateMode> =
        MethodStringName2<Animation, Unit, Int, UpdateMode>("value_track_set_update_mode")

    @JvmField
    public val valueTrackGetUpdateModeName: MethodStringName1<Animation, UpdateMode, Int> =
        MethodStringName1<Animation, UpdateMode, Int>("value_track_get_update_mode")

    @JvmField
    public val valueTrackInterpolateName: MethodStringName3<Animation, Any?, Int, Double, Boolean> =
        MethodStringName3<Animation, Any?, Int, Double, Boolean>("value_track_interpolate")

    @JvmField
    public val methodTrackGetNameName: MethodStringName2<Animation, StringName, Int, Int> =
        MethodStringName2<Animation, StringName, Int, Int>("method_track_get_name")

    @JvmField
    public val methodTrackGetParamsName: MethodStringName2<Animation, VariantArray<Any?>, Int, Int>
        = MethodStringName2<Animation, VariantArray<Any?>, Int, Int>("method_track_get_params")

    @JvmField
    public val bezierTrackInsertKeyName:
        MethodStringName5<Animation, Int, Int, Double, Float, Vector2, Vector2> =
        MethodStringName5<Animation, Int, Int, Double, Float, Vector2, Vector2>("bezier_track_insert_key")

    @JvmField
    public val bezierTrackSetKeyValueName: MethodStringName3<Animation, Unit, Int, Int, Float> =
        MethodStringName3<Animation, Unit, Int, Int, Float>("bezier_track_set_key_value")

    @JvmField
    public val bezierTrackSetKeyInHandleName:
        MethodStringName4<Animation, Unit, Int, Int, Vector2, Float> =
        MethodStringName4<Animation, Unit, Int, Int, Vector2, Float>("bezier_track_set_key_in_handle")

    @JvmField
    public val bezierTrackSetKeyOutHandleName:
        MethodStringName4<Animation, Unit, Int, Int, Vector2, Float> =
        MethodStringName4<Animation, Unit, Int, Int, Vector2, Float>("bezier_track_set_key_out_handle")

    @JvmField
    public val bezierTrackGetKeyValueName: MethodStringName2<Animation, Float, Int, Int> =
        MethodStringName2<Animation, Float, Int, Int>("bezier_track_get_key_value")

    @JvmField
    public val bezierTrackGetKeyInHandleName: MethodStringName2<Animation, Vector2, Int, Int> =
        MethodStringName2<Animation, Vector2, Int, Int>("bezier_track_get_key_in_handle")

    @JvmField
    public val bezierTrackGetKeyOutHandleName: MethodStringName2<Animation, Vector2, Int, Int> =
        MethodStringName2<Animation, Vector2, Int, Int>("bezier_track_get_key_out_handle")

    @JvmField
    public val bezierTrackInterpolateName: MethodStringName2<Animation, Float, Int, Double> =
        MethodStringName2<Animation, Float, Int, Double>("bezier_track_interpolate")

    @JvmField
    public val audioTrackInsertKeyName:
        MethodStringName5<Animation, Int, Int, Double, Resource?, Float, Float> =
        MethodStringName5<Animation, Int, Int, Double, Resource?, Float, Float>("audio_track_insert_key")

    @JvmField
    public val audioTrackSetKeyStreamName: MethodStringName3<Animation, Unit, Int, Int, Resource?> =
        MethodStringName3<Animation, Unit, Int, Int, Resource?>("audio_track_set_key_stream")

    @JvmField
    public val audioTrackSetKeyStartOffsetName: MethodStringName3<Animation, Unit, Int, Int, Float>
        = MethodStringName3<Animation, Unit, Int, Int, Float>("audio_track_set_key_start_offset")

    @JvmField
    public val audioTrackSetKeyEndOffsetName: MethodStringName3<Animation, Unit, Int, Int, Float> =
        MethodStringName3<Animation, Unit, Int, Int, Float>("audio_track_set_key_end_offset")

    @JvmField
    public val audioTrackGetKeyStreamName: MethodStringName2<Animation, Resource?, Int, Int> =
        MethodStringName2<Animation, Resource?, Int, Int>("audio_track_get_key_stream")

    @JvmField
    public val audioTrackGetKeyStartOffsetName: MethodStringName2<Animation, Float, Int, Int> =
        MethodStringName2<Animation, Float, Int, Int>("audio_track_get_key_start_offset")

    @JvmField
    public val audioTrackGetKeyEndOffsetName: MethodStringName2<Animation, Float, Int, Int> =
        MethodStringName2<Animation, Float, Int, Int>("audio_track_get_key_end_offset")

    @JvmField
    public val audioTrackSetUseBlendName: MethodStringName2<Animation, Unit, Int, Boolean> =
        MethodStringName2<Animation, Unit, Int, Boolean>("audio_track_set_use_blend")

    @JvmField
    public val audioTrackIsUseBlendName: MethodStringName1<Animation, Boolean, Int> =
        MethodStringName1<Animation, Boolean, Int>("audio_track_is_use_blend")

    @JvmField
    public val animationTrackInsertKeyName:
        MethodStringName3<Animation, Int, Int, Double, StringName> =
        MethodStringName3<Animation, Int, Int, Double, StringName>("animation_track_insert_key")

    @JvmField
    public val animationTrackSetKeyAnimationName:
        MethodStringName3<Animation, Unit, Int, Int, StringName> =
        MethodStringName3<Animation, Unit, Int, Int, StringName>("animation_track_set_key_animation")

    @JvmField
    public val animationTrackGetKeyAnimationName: MethodStringName2<Animation, StringName, Int, Int>
        = MethodStringName2<Animation, StringName, Int, Int>("animation_track_get_key_animation")

    @JvmField
    public val addMarkerName: MethodStringName2<Animation, Unit, StringName, Double> =
        MethodStringName2<Animation, Unit, StringName, Double>("add_marker")

    @JvmField
    public val removeMarkerName: MethodStringName1<Animation, Unit, StringName> =
        MethodStringName1<Animation, Unit, StringName>("remove_marker")

    @JvmField
    public val hasMarkerName: MethodStringName1<Animation, Boolean, StringName> =
        MethodStringName1<Animation, Boolean, StringName>("has_marker")

    @JvmField
    public val getMarkerAtTimeName: MethodStringName1<Animation, StringName, Double> =
        MethodStringName1<Animation, StringName, Double>("get_marker_at_time")

    @JvmField
    public val getNextMarkerName: MethodStringName1<Animation, StringName, Double> =
        MethodStringName1<Animation, StringName, Double>("get_next_marker")

    @JvmField
    public val getPrevMarkerName: MethodStringName1<Animation, StringName, Double> =
        MethodStringName1<Animation, StringName, Double>("get_prev_marker")

    @JvmField
    public val getMarkerTimeName: MethodStringName1<Animation, Double, StringName> =
        MethodStringName1<Animation, Double, StringName>("get_marker_time")

    @JvmField
    public val getMarkerNamesName: MethodStringName0<Animation, PackedStringArray> =
        MethodStringName0<Animation, PackedStringArray>("get_marker_names")

    @JvmField
    public val getMarkerColorName: MethodStringName1<Animation, Color, StringName> =
        MethodStringName1<Animation, Color, StringName>("get_marker_color")

    @JvmField
    public val setMarkerColorName: MethodStringName2<Animation, Unit, StringName, Color> =
        MethodStringName2<Animation, Unit, StringName, Color>("set_marker_color")

    @JvmField
    public val setLengthName: MethodStringName1<Animation, Unit, Double> =
        MethodStringName1<Animation, Unit, Double>("set_length")

    @JvmField
    public val getLengthName: MethodStringName0<Animation, Double> =
        MethodStringName0<Animation, Double>("get_length")

    @JvmField
    public val setLoopModeName: MethodStringName1<Animation, Unit, LoopMode> =
        MethodStringName1<Animation, Unit, LoopMode>("set_loop_mode")

    @JvmField
    public val getLoopModeName: MethodStringName0<Animation, LoopMode> =
        MethodStringName0<Animation, LoopMode>("get_loop_mode")

    @JvmField
    public val setStepName: MethodStringName1<Animation, Unit, Float> =
        MethodStringName1<Animation, Unit, Float>("set_step")

    @JvmField
    public val getStepName: MethodStringName0<Animation, Float> =
        MethodStringName0<Animation, Float>("get_step")

    @JvmField
    public val clearName: MethodStringName0<Animation, Unit> =
        MethodStringName0<Animation, Unit>("clear")

    @JvmField
    public val copyTrackName: MethodStringName2<Animation, Unit, Int, Animation?> =
        MethodStringName2<Animation, Unit, Int, Animation?>("copy_track")

    @JvmField
    public val optimizeName: MethodStringName3<Animation, Unit, Float, Float, Int> =
        MethodStringName3<Animation, Unit, Float, Float, Int>("optimize")

    @JvmField
    public val compressName: MethodStringName3<Animation, Unit, Long, Long, Float> =
        MethodStringName3<Animation, Unit, Long, Long, Float>("compress")

    @JvmField
    public val isCaptureIncludedName: MethodStringName0<Animation, Boolean> =
        MethodStringName0<Animation, Boolean>("is_capture_included")
  }

  public object MethodBindings {
    internal val addTrackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "add_track", 3843682357)

    internal val removeTrackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "remove_track", 1286410249)

    internal val getTrackCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_track_count", 3905245786)

    internal val trackGetTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_get_type", 3445944217)

    internal val trackGetPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_get_path", 408788394)

    internal val trackSetPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_set_path", 2761262315)

    internal val findTrackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "find_track", 245376003)

    internal val trackMoveUpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_move_up", 1286410249)

    internal val trackMoveDownPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_move_down", 1286410249)

    internal val trackMoveToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_move_to", 3937882851)

    internal val trackSwapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_swap", 3937882851)

    internal val trackSetImportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_set_imported", 300928843)

    internal val trackIsImportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_is_imported", 1116898809)

    internal val trackSetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_set_enabled", 300928843)

    internal val trackIsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_is_enabled", 1116898809)

    internal val positionTrackInsertKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "position_track_insert_key", 2540608232)

    internal val rotationTrackInsertKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "rotation_track_insert_key", 4165004800)

    internal val scaleTrackInsertKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "scale_track_insert_key", 2540608232)

    internal val blendShapeTrackInsertKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "blend_shape_track_insert_key", 1534913637)

    internal val positionTrackInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "position_track_interpolate", 3530011197)

    internal val rotationTrackInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "rotation_track_interpolate", 2915876792)

    internal val scaleTrackInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "scale_track_interpolate", 3530011197)

    internal val blendShapeTrackInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "blend_shape_track_interpolate", 2482365182)

    internal val trackInsertKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_insert_key", 808952278)

    internal val trackRemoveKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_remove_key", 3937882851)

    internal val trackRemoveKeyAtTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_remove_key_at_time", 1602489585)

    internal val trackSetKeyValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_set_key_value", 2060538656)

    internal val trackSetKeyTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_set_key_transition", 3506521499)

    internal val trackSetKeyTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_set_key_time", 3506521499)

    internal val trackGetKeyTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_get_key_transition", 3085491603)

    internal val trackGetKeyCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_get_key_count", 923996154)

    internal val trackGetKeyValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_get_key_value", 678354945)

    internal val trackGetKeyTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_get_key_time", 3085491603)

    internal val trackFindKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_find_key", 4230953007)

    internal val trackSetInterpolationTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_set_interpolation_type", 4112932513)

    internal val trackGetInterpolationTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_get_interpolation_type", 1530756894)

    internal val trackSetInterpolationLoopWrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_set_interpolation_loop_wrap", 300928843)

    internal val trackGetInterpolationLoopWrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_get_interpolation_loop_wrap", 1116898809)

    internal val trackIsCompressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "track_is_compressed", 1116898809)

    internal val valueTrackSetUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "value_track_set_update_mode", 2854058312)

    internal val valueTrackGetUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "value_track_get_update_mode", 1440326473)

    internal val valueTrackInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "value_track_interpolate", 747269075)

    internal val methodTrackGetNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "method_track_get_name", 351665558)

    internal val methodTrackGetParamsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "method_track_get_params", 2345056839)

    internal val bezierTrackInsertKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "bezier_track_insert_key", 3656773645)

    internal val bezierTrackSetKeyValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "bezier_track_set_key_value", 3506521499)

    internal val bezierTrackSetKeyInHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "bezier_track_set_key_in_handle", 1719223284)

    internal val bezierTrackSetKeyOutHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "bezier_track_set_key_out_handle", 1719223284)

    internal val bezierTrackGetKeyValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "bezier_track_get_key_value", 3085491603)

    internal val bezierTrackGetKeyInHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "bezier_track_get_key_in_handle", 3016396712)

    internal val bezierTrackGetKeyOutHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "bezier_track_get_key_out_handle", 3016396712)

    internal val bezierTrackInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "bezier_track_interpolate", 1900462983)

    internal val audioTrackInsertKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_insert_key", 4021027286)

    internal val audioTrackSetKeyStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_set_key_stream", 3886397084)

    internal val audioTrackSetKeyStartOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_set_key_start_offset", 3506521499)

    internal val audioTrackSetKeyEndOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_set_key_end_offset", 3506521499)

    internal val audioTrackGetKeyStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_get_key_stream", 635277205)

    internal val audioTrackGetKeyStartOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_get_key_start_offset", 3085491603)

    internal val audioTrackGetKeyEndOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_get_key_end_offset", 3085491603)

    internal val audioTrackSetUseBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_set_use_blend", 300928843)

    internal val audioTrackIsUseBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "audio_track_is_use_blend", 1116898809)

    internal val animationTrackInsertKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "animation_track_insert_key", 158676774)

    internal val animationTrackSetKeyAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "animation_track_set_key_animation", 117615382)

    internal val animationTrackGetKeyAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "animation_track_get_key_animation", 351665558)

    internal val addMarkerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "add_marker", 4135858297)

    internal val removeMarkerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "remove_marker", 3304788590)

    internal val hasMarkerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "has_marker", 2619796661)

    internal val getMarkerAtTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_marker_at_time", 4079494655)

    internal val getNextMarkerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_next_marker", 4079494655)

    internal val getPrevMarkerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_prev_marker", 4079494655)

    internal val getMarkerTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_marker_time", 2349060816)

    internal val getMarkerNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_marker_names", 1139954409)

    internal val getMarkerColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_marker_color", 3742943038)

    internal val setMarkerColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "set_marker_color", 4260178595)

    internal val setLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "set_length", 373806689)

    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_length", 1740695150)

    internal val setLoopModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "set_loop_mode", 3155355575)

    internal val getLoopModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_loop_mode", 1988889481)

    internal val setStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "set_step", 373806689)

    internal val getStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "get_step", 1740695150)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("Animation", "clear", 3218959716)

    internal val copyTrackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "copy_track", 148001024)

    internal val optimizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "optimize", 3303583852)

    internal val compressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "compress", 3608408117)

    internal val isCaptureIncludedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Animation", "is_capture_included", 36873697)
  }
}
