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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.Signal0
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_DOUBLE_BOOL
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [AnimatedSprite3D] is similar to the [Sprite3D] node, except it carries multiple textures as
 * animation [spriteFrames]. Animations are created using a [SpriteFrames] resource, which allows you
 * to import image files (or a folder containing said files) to provide the animation frames for the
 * sprite. The [SpriteFrames] resource can be configured in the editor via the SpriteFrames bottom
 * panel.
 */
@GodotBaseType
public open class AnimatedSprite3D : SpriteBase3D() {
  /**
   * Emitted when [spriteFrames] changes.
   */
  public val spriteFramesChanged: Signal0 by Signal0

  /**
   * Emitted when [animation] changes.
   */
  public val animationChanged: Signal0 by Signal0

  /**
   * Emitted when [frame] changes.
   */
  public val frameChanged: Signal0 by Signal0

  /**
   * Emitted when the animation loops.
   */
  public val animationLooped: Signal0 by Signal0

  /**
   * Emitted when the animation reaches the end, or the start if it is played in reverse. When the
   * animation finishes, it pauses the playback.
   *
   * **Note:** This signal is not emitted if an animation is looping.
   */
  public val animationFinished: Signal0 by Signal0

  /**
   * The [SpriteFrames] resource containing the animation(s). Allows you the option to load, edit,
   * clear, make unique and save the states of the [SpriteFrames] resource.
   */
  public final inline var spriteFrames: SpriteFrames?
    @JvmName("spriteFramesProperty")
    get() = getSpriteFrames()
    @JvmName("spriteFramesProperty")
    set(`value`) {
      setSpriteFrames(value)
    }

  /**
   * The current animation from the [spriteFrames] resource. If this value is changed, the [frame]
   * counter and the [frameProgress] are reset.
   */
  public final inline var animation: StringName
    @JvmName("animationProperty")
    get() = getAnimation()
    @JvmName("animationProperty")
    set(`value`) {
      setAnimation(value)
    }

  /**
   * The key of the animation to play when the scene loads.
   */
  public final inline var autoplay: String
    @JvmName("autoplayProperty")
    get() = getAutoplay()
    @JvmName("autoplayProperty")
    set(`value`) {
      setAutoplay(value)
    }

  /**
   * The displayed animation frame's index. Setting this property also resets [frameProgress]. If
   * this is not desired, use [setFrameAndProgress].
   */
  public final inline var frame: Int
    @JvmName("frameProperty")
    get() = getFrame()
    @JvmName("frameProperty")
    set(`value`) {
      setFrame(value)
    }

  /**
   * The progress value between `0.0` and `1.0` until the current frame transitions to the next
   * frame. If the animation is playing backwards, the value transitions from `1.0` to `0.0`.
   */
  public final inline var frameProgress: Float
    @JvmName("frameProgressProperty")
    get() = getFrameProgress()
    @JvmName("frameProgressProperty")
    set(`value`) {
      setFrameProgress(value)
    }

  /**
   * The speed scaling ratio. For example, if this value is `1`, then the animation plays at normal
   * speed. If it's `0.5`, then it plays at half speed. If it's `2`, then it plays at double speed.
   *
   * If set to a negative value, the animation is played in reverse. If set to `0`, the animation
   * will not advance.
   */
  public final inline var speedScale: Float
    @JvmName("speedScaleProperty")
    get() = getSpeedScale()
    @JvmName("speedScaleProperty")
    set(`value`) {
      setSpeedScale(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(10, scriptPtr)
  }

  public final fun setSpriteFrames(spriteFrames: SpriteFrames?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, spriteFrames)
    TransferContext.callMethod(MethodBindings.setSpriteFramesPtr)
  }

  public final fun getSpriteFrames(): SpriteFrames? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpriteFramesPtr)
    return (TransferContext.readReturnValue_OBJECT() as SpriteFrames?)
  }

  public final fun setAnimation(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.setAnimationPtr)
  }

  public final fun getAnimation(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnimationPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setAutoplay(name: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.setAutoplayPtr)
  }

  public final fun getAutoplay(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutoplayPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if an animation is currently playing (even if [speedScale] and/or `custom_speed`
   * are `0`).
   */
  public final fun isPlaying(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPlayingPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Plays the animation with key [name]. If [customSpeed] is negative and [fromEnd] is `true`, the
   * animation will play backwards (which is equivalent to calling [playBackwards]).
   *
   * If this method is called with that same animation [name], or with no [name] parameter, the
   * assigned animation will resume playing if it was paused.
   */
  @JvmOverloads
  public final fun play(
    name: StringName = StringName(""),
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE_BOOL(ptr, objectID.id, name, customSpeed.toDouble(), fromEnd)
    TransferContext.callMethod(MethodBindings.playPtr)
  }

  /**
   * Plays the animation with key [name] in reverse.
   *
   * This method is a shorthand for [play] with `custom_speed = -1.0` and `from_end = true`, so see
   * its description for more information.
   */
  public final fun playBackwards(name: StringName = StringName("")): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.playBackwardsPtr)
  }

  /**
   * Pauses the currently playing animation. The [frame] and [frameProgress] will be kept and
   * calling [play] or [playBackwards] without arguments will resume the animation from the current
   * playback position.
   *
   * See also [stop].
   */
  public final fun pause(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.pausePtr)
  }

  /**
   * Stops the currently playing animation. The animation position is reset to `0` and the
   * `custom_speed` is reset to `1.0`. See also [pause].
   */
  public final fun stop(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.stopPtr)
  }

  public final fun setFrame(frame: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, frame.toLong())
    TransferContext.callMethod(MethodBindings.setFramePtr)
  }

  public final fun getFrame(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFramePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setFrameProgress(progress: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, progress.toDouble())
    TransferContext.callMethod(MethodBindings.setFrameProgressPtr)
  }

  public final fun getFrameProgress(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrameProgressPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets [frame] and [frameProgress] to the given values. Unlike setting [frame], this method does
   * not reset the [frameProgress] to `0.0` implicitly.
   *
   * **Example:** Change the animation while keeping the same [frame] and [frameProgress]:
   *
   * ```gdscript
   * //gdscript
   * var current_frame = animated_sprite.get_frame()
   * var current_progress = animated_sprite.get_frame_progress()
   * animated_sprite.play("walk_another_skin")
   * animated_sprite.set_frame_and_progress(current_frame, current_progress)
   * ```
   */
  public final fun setFrameAndProgress(frame: Int, progress: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, frame.toLong(), progress.toDouble())
    TransferContext.callMethod(MethodBindings.setFrameAndProgressPtr)
  }

  public final fun setSpeedScale(speedScale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, speedScale.toDouble())
    TransferContext.callMethod(MethodBindings.setSpeedScalePtr)
  }

  public final fun getSpeedScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpeedScalePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the actual playing speed of current animation or `0` if not playing. This speed is the
   * [speedScale] property multiplied by `custom_speed` argument specified when calling the [play]
   * method.
   *
   * Returns a negative value if the current animation is playing backwards.
   */
  public final fun getPlayingSpeed(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlayingSpeedPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAnimation(name: String) = setAnimation(name.asCachedStringName())

  /**
   * Plays the animation with key [name]. If [customSpeed] is negative and [fromEnd] is `true`, the
   * animation will play backwards (which is equivalent to calling [playBackwards]).
   *
   * If this method is called with that same animation [name], or with no [name] parameter, the
   * assigned animation will resume playing if it was paused.
   */
  @JvmOverloads
  public final fun play(
    name: String,
    customSpeed: Float = 1.0f,
    fromEnd: Boolean = false,
  ) = play(name.asCachedStringName(), customSpeed, fromEnd)

  /**
   * Plays the animation with key [name] in reverse.
   *
   * This method is a shorthand for [play] with `custom_speed = -1.0` and `from_end = true`, so see
   * its description for more information.
   */
  public final fun playBackwards(name: String) = playBackwards(name.asCachedStringName())

  public companion object {
    @JvmField
    public val setSpriteFramesName: MethodStringName1<AnimatedSprite3D, Unit, SpriteFrames?> =
        MethodStringName1<AnimatedSprite3D, Unit, SpriteFrames?>("set_sprite_frames")

    @JvmField
    public val getSpriteFramesName: MethodStringName0<AnimatedSprite3D, SpriteFrames?> =
        MethodStringName0<AnimatedSprite3D, SpriteFrames?>("get_sprite_frames")

    @JvmField
    public val setAnimationName: MethodStringName1<AnimatedSprite3D, Unit, StringName> =
        MethodStringName1<AnimatedSprite3D, Unit, StringName>("set_animation")

    @JvmField
    public val getAnimationName: MethodStringName0<AnimatedSprite3D, StringName> =
        MethodStringName0<AnimatedSprite3D, StringName>("get_animation")

    @JvmField
    public val setAutoplayName: MethodStringName1<AnimatedSprite3D, Unit, String> =
        MethodStringName1<AnimatedSprite3D, Unit, String>("set_autoplay")

    @JvmField
    public val getAutoplayName: MethodStringName0<AnimatedSprite3D, String> =
        MethodStringName0<AnimatedSprite3D, String>("get_autoplay")

    @JvmField
    public val isPlayingName: MethodStringName0<AnimatedSprite3D, Boolean> =
        MethodStringName0<AnimatedSprite3D, Boolean>("is_playing")

    @JvmField
    public val playName: MethodStringName3<AnimatedSprite3D, Unit, StringName, Float, Boolean> =
        MethodStringName3<AnimatedSprite3D, Unit, StringName, Float, Boolean>("play")

    @JvmField
    public val playBackwardsName: MethodStringName1<AnimatedSprite3D, Unit, StringName> =
        MethodStringName1<AnimatedSprite3D, Unit, StringName>("play_backwards")

    @JvmField
    public val pauseName: MethodStringName0<AnimatedSprite3D, Unit> =
        MethodStringName0<AnimatedSprite3D, Unit>("pause")

    @JvmField
    public val stopName: MethodStringName0<AnimatedSprite3D, Unit> =
        MethodStringName0<AnimatedSprite3D, Unit>("stop")

    @JvmField
    public val setFrameName: MethodStringName1<AnimatedSprite3D, Unit, Int> =
        MethodStringName1<AnimatedSprite3D, Unit, Int>("set_frame")

    @JvmField
    public val getFrameName: MethodStringName0<AnimatedSprite3D, Int> =
        MethodStringName0<AnimatedSprite3D, Int>("get_frame")

    @JvmField
    public val setFrameProgressName: MethodStringName1<AnimatedSprite3D, Unit, Float> =
        MethodStringName1<AnimatedSprite3D, Unit, Float>("set_frame_progress")

    @JvmField
    public val getFrameProgressName: MethodStringName0<AnimatedSprite3D, Float> =
        MethodStringName0<AnimatedSprite3D, Float>("get_frame_progress")

    @JvmField
    public val setFrameAndProgressName: MethodStringName2<AnimatedSprite3D, Unit, Int, Float> =
        MethodStringName2<AnimatedSprite3D, Unit, Int, Float>("set_frame_and_progress")

    @JvmField
    public val setSpeedScaleName: MethodStringName1<AnimatedSprite3D, Unit, Float> =
        MethodStringName1<AnimatedSprite3D, Unit, Float>("set_speed_scale")

    @JvmField
    public val getSpeedScaleName: MethodStringName0<AnimatedSprite3D, Float> =
        MethodStringName0<AnimatedSprite3D, Float>("get_speed_scale")

    @JvmField
    public val getPlayingSpeedName: MethodStringName0<AnimatedSprite3D, Float> =
        MethodStringName0<AnimatedSprite3D, Float>("get_playing_speed")
  }

  public object MethodBindings {
    internal val setSpriteFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "set_sprite_frames", 905781144)

    internal val getSpriteFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "get_sprite_frames", 3804851214)

    internal val setAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "set_animation", 3304788590)

    internal val getAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "get_animation", 2002593661)

    internal val setAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "set_autoplay", 83702148)

    internal val getAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "get_autoplay", 201670096)

    internal val isPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "is_playing", 36873697)

    internal val playPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "play", 3269405555)

    internal val playBackwardsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "play_backwards", 3323268493)

    internal val pausePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "pause", 3218959716)

    internal val stopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "stop", 3218959716)

    internal val setFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "set_frame", 1286410249)

    internal val getFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "get_frame", 3905245786)

    internal val setFrameProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "set_frame_progress", 373806689)

    internal val getFrameProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "get_frame_progress", 1740695150)

    internal val setFrameAndProgressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "set_frame_and_progress", 1602489585)

    internal val setSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "set_speed_scale", 373806689)

    internal val getSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "get_speed_scale", 1740695150)

    internal val getPlayingSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedSprite3D", "get_playing_speed", 1740695150)
  }
}
