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
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_BOOL
import godot.writeMethodArguments_STRING_NAME_DOUBLE
import godot.writeMethodArguments_STRING_NAME_LONG
import godot.writeMethodArguments_STRING_NAME_LONG_OBJECT_DOUBLE
import godot.writeMethodArguments_STRING_NAME_OBJECT_DOUBLE_LONG
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * Sprite frame library for an [AnimatedSprite2D] or [AnimatedSprite3D] node. Contains frames and
 * animation data for playback.
 */
@GodotBaseType
public open class SpriteFrames : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(702, scriptPtr)
  }

  /**
   * Adds a new [anim] animation to the library.
   */
  public final fun addAnimation(anim: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, anim)
    TransferContext.callPtrMethod(MethodBindings.addAnimationPtr, 0)
  }

  /**
   * Returns `true` if the [anim] animation exists.
   */
  public final fun hasAnimation(anim: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, anim)
    TransferContext.callPtrMethod(MethodBindings.hasAnimationPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Duplicates the animation [animFrom] to a new animation named [animTo]. Fails if [animTo]
   * already exists, or if [animFrom] does not exist.
   */
  public final fun duplicateAnimation(animFrom: StringName, animTo: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, animFrom, animTo)
    TransferContext.callPtrMethod(MethodBindings.duplicateAnimationPtr, 0)
  }

  /**
   * Removes the [anim] animation.
   */
  public final fun removeAnimation(anim: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, anim)
    TransferContext.callPtrMethod(MethodBindings.removeAnimationPtr, 0)
  }

  /**
   * Changes the [anim] animation's name to [newname].
   */
  public final fun renameAnimation(anim: StringName, newname: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, anim, newname)
    TransferContext.callPtrMethod(MethodBindings.renameAnimationPtr, 0)
  }

  /**
   * Returns an array containing the names associated to each animation. Values are placed in
   * alphabetical order.
   */
  public final fun getAnimationNames(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnimationNamesPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Sets the speed for the [anim] animation in frames per second.
   */
  public final fun setAnimationSpeed(anim: StringName, fps: Double): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE(ptr, objectID.id, anim, fps)
    TransferContext.callPtrMethod(MethodBindings.setAnimationSpeedPtr, 0)
  }

  /**
   * Returns the speed in frames per second for the [anim] animation.
   */
  public final fun getAnimationSpeed(anim: StringName): Double {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, anim)
    TransferContext.callPtrMethod(MethodBindings.getAnimationSpeedPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  /**
   * If [loop] is `false` equivalent to `set_animation_loop_mode(LOOP_NONE)`.
   *
   * If [loop] is `true` equivalent to `set_animation_loop_mode(LOOP_LINEAR)`.
   */
  public final fun setAnimationLoop(anim: StringName, loop: Boolean): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL(ptr, objectID.id, anim, loop)
    TransferContext.callPtrMethod(MethodBindings.setAnimationLoopPtr, 0)
  }

  /**
   * Returns `true` if `get_animation_loop_mode(anim) == LOOP_LINEAR`. Otherwise, returns `false`.
   */
  public final fun getAnimationLoop(anim: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, anim)
    TransferContext.callPtrMethod(MethodBindings.getAnimationLoopPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the [loopMode] for the [anim] animation.
   */
  public final fun setAnimationLoopMode(anim: StringName, loopMode: LoopMode): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_LONG(ptr, objectID.id, anim, loopMode.value)
    TransferContext.callPtrMethod(MethodBindings.setAnimationLoopModePtr, 0)
  }

  /**
   * Returns the loop mode for the [anim] animation.
   */
  public final fun getAnimationLoopMode(anim: StringName): LoopMode {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, anim)
    TransferContext.callPtrMethod(MethodBindings.getAnimationLoopModePtr, 2)
    return LoopMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Adds a frame to the [anim] animation. If [atPosition] is `-1`, the frame will be added to the
   * end of the animation. [duration] specifies the relative duration, see [getFrameDuration] for
   * details.
   */
  @JvmOverloads
  public final fun addFrame(
    anim: StringName,
    texture: Texture2D?,
    duration: Float = 1.0f,
    atPosition: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_OBJECT_DOUBLE_LONG(ptr, objectID.id, anim, texture, duration.toDouble(), atPosition.toLong())
    TransferContext.callPtrMethod(MethodBindings.addFramePtr, 0)
  }

  /**
   * Sets the [texture] and the [duration] of the frame [idx] in the [anim] animation. [duration]
   * specifies the relative duration, see [getFrameDuration] for details.
   */
  @JvmOverloads
  public final fun setFrame(
    anim: StringName,
    idx: Int,
    texture: Texture2D?,
    duration: Float = 1.0f,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_LONG_OBJECT_DOUBLE(ptr, objectID.id, anim, idx.toLong(), texture, duration.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setFramePtr, 0)
  }

  /**
   * Removes the [anim] animation's frame [idx].
   */
  public final fun removeFrame(anim: StringName, idx: Int): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_LONG(ptr, objectID.id, anim, idx.toLong())
    TransferContext.callPtrMethod(MethodBindings.removeFramePtr, 0)
  }

  /**
   * Returns the number of frames for the [anim] animation.
   */
  public final fun getFrameCount(anim: StringName): Int {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, anim)
    TransferContext.callPtrMethod(MethodBindings.getFrameCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the texture of the frame [idx] in the [anim] animation.
   */
  public final fun getFrameTexture(anim: StringName, idx: Int): Texture2D? {
    TransferContext.writeMethodArguments_STRING_NAME_LONG(ptr, objectID.id, anim, idx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getFrameTexturePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  /**
   * Returns a relative duration of the frame [idx] in the [anim] animation (defaults to `1.0`). For
   * example, a frame with a duration of `2.0` is displayed twice as long as a frame with a duration of
   * `1.0`. You can calculate the absolute duration (in seconds) of a frame using the following
   * formula:
   *
   * ```
   * absolute_duration = relative_duration / (animation_fps * abs(playing_speed))
   * ```
   *
   * In this example, `playing_speed` refers to either [AnimatedSprite2D.getPlayingSpeed] or
   * [AnimatedSprite3D.getPlayingSpeed].
   */
  public final fun getFrameDuration(anim: StringName, idx: Int): Float {
    TransferContext.writeMethodArguments_STRING_NAME_LONG(ptr, objectID.id, anim, idx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getFrameDurationPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Removes all frames from the [anim] animation.
   */
  public final fun clear(anim: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, anim)
    TransferContext.callPtrMethod(MethodBindings.clearPtr, 0)
  }

  /**
   * Removes all animations. An empty `default` animation will be created.
   */
  public final fun clearAll(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearAllPtr, 0)
  }

  /**
   * Adds a new [anim] animation to the library.
   */
  public final fun addAnimation(anim: String) = addAnimation(anim.asCachedStringName())

  /**
   * Returns `true` if the [anim] animation exists.
   */
  public final fun hasAnimation(anim: String): Boolean = hasAnimation(anim.asCachedStringName())

  /**
   * Duplicates the animation [animFrom] to a new animation named [animTo]. Fails if [animTo]
   * already exists, or if [animFrom] does not exist.
   */
  public final fun duplicateAnimation(animFrom: String, animTo: String) =
      duplicateAnimation(animFrom.asCachedStringName(), animTo.asCachedStringName())

  /**
   * Removes the [anim] animation.
   */
  public final fun removeAnimation(anim: String) = removeAnimation(anim.asCachedStringName())

  /**
   * Changes the [anim] animation's name to [newname].
   */
  public final fun renameAnimation(anim: String, newname: String) =
      renameAnimation(anim.asCachedStringName(), newname.asCachedStringName())

  /**
   * Sets the speed for the [anim] animation in frames per second.
   */
  public final fun setAnimationSpeed(anim: String, fps: Double) =
      setAnimationSpeed(anim.asCachedStringName(), fps)

  /**
   * Returns the speed in frames per second for the [anim] animation.
   */
  public final fun getAnimationSpeed(anim: String): Double =
      getAnimationSpeed(anim.asCachedStringName())

  /**
   * If [loop] is `false` equivalent to `set_animation_loop_mode(LOOP_NONE)`.
   *
   * If [loop] is `true` equivalent to `set_animation_loop_mode(LOOP_LINEAR)`.
   */
  public final fun setAnimationLoop(anim: String, loop: Boolean) =
      setAnimationLoop(anim.asCachedStringName(), loop)

  /**
   * Returns `true` if `get_animation_loop_mode(anim) == LOOP_LINEAR`. Otherwise, returns `false`.
   */
  public final fun getAnimationLoop(anim: String): Boolean =
      getAnimationLoop(anim.asCachedStringName())

  /**
   * Sets the [loopMode] for the [anim] animation.
   */
  public final fun setAnimationLoopMode(anim: String, loopMode: LoopMode) =
      setAnimationLoopMode(anim.asCachedStringName(), loopMode)

  /**
   * Returns the loop mode for the [anim] animation.
   */
  public final fun getAnimationLoopMode(anim: String): LoopMode =
      getAnimationLoopMode(anim.asCachedStringName())

  /**
   * Adds a frame to the [anim] animation. If [atPosition] is `-1`, the frame will be added to the
   * end of the animation. [duration] specifies the relative duration, see [getFrameDuration] for
   * details.
   */
  @JvmOverloads
  public final fun addFrame(
    anim: String,
    texture: Texture2D?,
    duration: Float = 1.0f,
    atPosition: Int = -1,
  ) = addFrame(anim.asCachedStringName(), texture, duration, atPosition)

  /**
   * Sets the [texture] and the [duration] of the frame [idx] in the [anim] animation. [duration]
   * specifies the relative duration, see [getFrameDuration] for details.
   */
  @JvmOverloads
  public final fun setFrame(
    anim: String,
    idx: Int,
    texture: Texture2D?,
    duration: Float = 1.0f,
  ) = setFrame(anim.asCachedStringName(), idx, texture, duration)

  /**
   * Removes the [anim] animation's frame [idx].
   */
  public final fun removeFrame(anim: String, idx: Int) = removeFrame(anim.asCachedStringName(), idx)

  /**
   * Returns the number of frames for the [anim] animation.
   */
  public final fun getFrameCount(anim: String): Int = getFrameCount(anim.asCachedStringName())

  /**
   * Returns the texture of the frame [idx] in the [anim] animation.
   */
  public final fun getFrameTexture(anim: String, idx: Int): Texture2D? =
      getFrameTexture(anim.asCachedStringName(), idx)

  /**
   * Returns a relative duration of the frame [idx] in the [anim] animation (defaults to `1.0`). For
   * example, a frame with a duration of `2.0` is displayed twice as long as a frame with a duration of
   * `1.0`. You can calculate the absolute duration (in seconds) of a frame using the following
   * formula:
   *
   * ```
   * absolute_duration = relative_duration / (animation_fps * abs(playing_speed))
   * ```
   *
   * In this example, `playing_speed` refers to either [AnimatedSprite2D.getPlayingSpeed] or
   * [AnimatedSprite3D.getPlayingSpeed].
   */
  public final fun getFrameDuration(anim: String, idx: Int): Float =
      getFrameDuration(anim.asCachedStringName(), idx)

  /**
   * Removes all frames from the [anim] animation.
   */
  public final fun clear(anim: String) = clear(anim.asCachedStringName())

  public enum class LoopMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The animation plays once and stops when it reaches the end, or the start if played in
     * reverse.
     */
    NONE(0),
    /**
     * The animation restarts from the beginning when it reaches the end, or from the end if played
     * in reverse, repeating continuously.
     */
    LINEAR(1),
    /**
     * The animation alternates direction each time it reaches the end or start, playing forward and
     * then in reverse repeatedly.
     *
     * **Note:** Both [AnimatedSprite2D] and [AnimatedSprite3D] play the first/last frame for its
     * duration only once at each end of the animation loop (instead of twice, once per
     * forward/backward animation direction).
     */
    PINGPONG(2),
    ;

    public companion object {
      public fun from(`value`: Long): LoopMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addAnimationName: MethodStringName1<SpriteFrames, Unit, StringName> =
        MethodStringName1<SpriteFrames, Unit, StringName>("add_animation")

    @JvmField
    public val hasAnimationName: MethodStringName1<SpriteFrames, Boolean, StringName> =
        MethodStringName1<SpriteFrames, Boolean, StringName>("has_animation")

    @JvmField
    public val duplicateAnimationName: MethodStringName2<SpriteFrames, Unit, StringName, StringName>
        = MethodStringName2<SpriteFrames, Unit, StringName, StringName>("duplicate_animation")

    @JvmField
    public val removeAnimationName: MethodStringName1<SpriteFrames, Unit, StringName> =
        MethodStringName1<SpriteFrames, Unit, StringName>("remove_animation")

    @JvmField
    public val renameAnimationName: MethodStringName2<SpriteFrames, Unit, StringName, StringName> =
        MethodStringName2<SpriteFrames, Unit, StringName, StringName>("rename_animation")

    @JvmField
    public val getAnimationNamesName: MethodStringName0<SpriteFrames, PackedStringArray> =
        MethodStringName0<SpriteFrames, PackedStringArray>("get_animation_names")

    @JvmField
    public val setAnimationSpeedName: MethodStringName2<SpriteFrames, Unit, StringName, Double> =
        MethodStringName2<SpriteFrames, Unit, StringName, Double>("set_animation_speed")

    @JvmField
    public val getAnimationSpeedName: MethodStringName1<SpriteFrames, Double, StringName> =
        MethodStringName1<SpriteFrames, Double, StringName>("get_animation_speed")

    @JvmField
    public val setAnimationLoopName: MethodStringName2<SpriteFrames, Unit, StringName, Boolean> =
        MethodStringName2<SpriteFrames, Unit, StringName, Boolean>("set_animation_loop")

    @JvmField
    public val getAnimationLoopName: MethodStringName1<SpriteFrames, Boolean, StringName> =
        MethodStringName1<SpriteFrames, Boolean, StringName>("get_animation_loop")

    @JvmField
    public val setAnimationLoopModeName: MethodStringName2<SpriteFrames, Unit, StringName, LoopMode>
        = MethodStringName2<SpriteFrames, Unit, StringName, LoopMode>("set_animation_loop_mode")

    @JvmField
    public val getAnimationLoopModeName: MethodStringName1<SpriteFrames, LoopMode, StringName> =
        MethodStringName1<SpriteFrames, LoopMode, StringName>("get_animation_loop_mode")

    @JvmField
    public val addFrameName:
        MethodStringName4<SpriteFrames, Unit, StringName, Texture2D?, Float, Int> =
        MethodStringName4<SpriteFrames, Unit, StringName, Texture2D?, Float, Int>("add_frame")

    @JvmField
    public val setFrameName:
        MethodStringName4<SpriteFrames, Unit, StringName, Int, Texture2D?, Float> =
        MethodStringName4<SpriteFrames, Unit, StringName, Int, Texture2D?, Float>("set_frame")

    @JvmField
    public val removeFrameName: MethodStringName2<SpriteFrames, Unit, StringName, Int> =
        MethodStringName2<SpriteFrames, Unit, StringName, Int>("remove_frame")

    @JvmField
    public val getFrameCountName: MethodStringName1<SpriteFrames, Int, StringName> =
        MethodStringName1<SpriteFrames, Int, StringName>("get_frame_count")

    @JvmField
    public val getFrameTextureName: MethodStringName2<SpriteFrames, Texture2D?, StringName, Int> =
        MethodStringName2<SpriteFrames, Texture2D?, StringName, Int>("get_frame_texture")

    @JvmField
    public val getFrameDurationName: MethodStringName2<SpriteFrames, Float, StringName, Int> =
        MethodStringName2<SpriteFrames, Float, StringName, Int>("get_frame_duration")

    @JvmField
    public val clearName: MethodStringName1<SpriteFrames, Unit, StringName> =
        MethodStringName1<SpriteFrames, Unit, StringName>("clear")

    @JvmField
    public val clearAllName: MethodStringName0<SpriteFrames, Unit> =
        MethodStringName0<SpriteFrames, Unit>("clear_all")
  }

  public object MethodBindings {
    internal val addAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "add_animation", 3304788590)

    internal val hasAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "has_animation", 2619796661)

    internal val duplicateAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "duplicate_animation", 3740211285)

    internal val removeAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "remove_animation", 3304788590)

    internal val renameAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "rename_animation", 3740211285)

    internal val getAnimationNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "get_animation_names", 1139954409)

    internal val setAnimationSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "set_animation_speed", 4135858297)

    internal val getAnimationSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "get_animation_speed", 2349060816)

    internal val setAnimationLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "set_animation_loop", 2524380260)

    internal val getAnimationLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "get_animation_loop", 2619796661)

    internal val setAnimationLoopModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "set_animation_loop_mode", 918068248)

    internal val getAnimationLoopModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "get_animation_loop_mode", 3606360228)

    internal val addFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "add_frame", 1351332740)

    internal val setFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "set_frame", 56804795)

    internal val removeFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "remove_frame", 2415702435)

    internal val getFrameCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "get_frame_count", 2458036349)

    internal val getFrameTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "get_frame_texture", 2900517879)

    internal val getFrameDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "get_frame_duration", 1129309260)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "clear", 3304788590)

    internal val clearAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteFrames", "clear_all", 3218959716)
  }
}
