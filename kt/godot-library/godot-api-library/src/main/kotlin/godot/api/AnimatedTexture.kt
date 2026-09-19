// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_DOUBLE
import godot.callPtrMethod_LONG_OBJECT
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_LONG_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [AnimatedTexture] is a resource format for frame-based animations, where multiple textures can be
 * chained automatically with a predefined delay for each frame. Unlike [AnimationPlayer] or
 * [AnimatedSprite2D], it isn't a [Node], but has the advantage of being usable anywhere a [Texture2D]
 * resource can be used, e.g. in a [TileSet].
 *
 * The playback of the animation is controlled by the [speedScale] property, as well as each frame's
 * duration (see [setFrameDuration]). The animation loops, i.e. it will restart at frame 0
 * automatically after playing the last frame.
 *
 * [AnimatedTexture] currently requires all frame textures to have the same size, otherwise the
 * bigger ones will be cropped to match the smallest one.
 *
 * **Note:** AnimatedTexture doesn't support using [AtlasTexture]s. Each frame needs to be a
 * separate [Texture2D].
 *
 * **Warning:** The current implementation is not efficient for the modern renderers.
 */
@GodotBaseType
public open class AnimatedTexture : Texture2D() {
  /**
   * Number of frames to use in the animation. While you can create the frames independently with
   * [setFrameTexture], you need to set this value for the animation to take new frames into account.
   * The maximum number of frames is [MAX_FRAMES].
   */
  public final inline var frames: Int
    @JvmName("framesProperty")
    get() = getFrames()
    @JvmName("framesProperty")
    set(`value`) {
      setFrames(value)
    }

  /**
   * Sets the currently visible frame of the texture. Setting this frame while playing resets the
   * current frame time, so the newly selected frame plays for its whole configured frame duration.
   */
  public final inline var currentFrame: Int
    @JvmName("currentFrameProperty")
    get() = getCurrentFrame()
    @JvmName("currentFrameProperty")
    set(`value`) {
      setCurrentFrame(value)
    }

  /**
   * If `true`, the animation will pause where it currently is (i.e. at [currentFrame]). The
   * animation will continue from where it was paused when changing this property to `false`.
   */
  public final inline var pause: Boolean
    @JvmName("pauseProperty")
    get() = getPause()
    @JvmName("pauseProperty")
    set(`value`) {
      setPause(value)
    }

  /**
   * If `true`, the animation will only play once and will not loop back to the first frame after
   * reaching the end. Note that reaching the end will not set [pause] to `true`.
   */
  public final inline var oneShot: Boolean
    @JvmName("oneShotProperty")
    get() = getOneShot()
    @JvmName("oneShotProperty")
    set(`value`) {
      setOneShot(value)
    }

  /**
   * The animation speed is multiplied by this value. If set to a negative value, the animation is
   * played in reverse.
   */
  public final inline var speedScale: Float
    @JvmName("speedScaleProperty")
    get() = getSpeedScale()
    @JvmName("speedScaleProperty")
    set(`value`) {
      setSpeedScale(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(11, scriptPtr)
  }

  public final fun setFrames(frames: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFramesPtr, frames.toLong())
  }

  public final fun getFrames(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFramesPtr).toInt()

  public final fun setCurrentFrame(frame: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCurrentFramePtr, frame.toLong())
  }

  public final fun getCurrentFrame(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCurrentFramePtr).toInt()

  public final fun setPause(pause: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setPausePtr, pause)
  }

  public final fun getPause(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getPausePtr)

  public final fun setOneShot(oneShot: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setOneShotPtr, oneShot)
  }

  public final fun getOneShot(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getOneShotPtr)

  public final fun setSpeedScale(scale: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setSpeedScalePtr, scale.toDouble())
  }

  public final fun getSpeedScale(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getSpeedScalePtr).toFloat()

  /**
   * Assigns a [Texture2D] to the given frame. Frame IDs start at 0, so the first frame has ID 0,
   * and the last frame of the animation has ID [frames] - 1.
   *
   * You can define any number of textures up to [MAX_FRAMES], but keep in mind that only frames
   * from 0 to [frames] - 1 will be part of the animation.
   */
  public final fun setFrameTexture(frame: Int, texture: Texture2D?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setFrameTexturePtr, frame.toLong(), texture)
  }

  /**
   * Returns the given frame's [Texture2D].
   */
  public final fun getFrameTexture(frame: Int): Texture2D? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getFrameTexturePtr, frame.toLong()) as Texture2D?)

  /**
   * Sets the duration of any given [frame]. The final duration is affected by the [speedScale]. If
   * set to `0`, the frame is skipped during playback.
   */
  public final fun setFrameDuration(frame: Int, duration: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setFrameDurationPtr, frame.toLong(), duration.toDouble())
  }

  /**
   * Returns the given [frame]'s duration, in seconds.
   */
  public final fun getFrameDuration(frame: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getFrameDurationPtr, frame.toLong()).toFloat()

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("AnimatedTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("AnimatedTexture::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setFramesName: MethodStringName1<AnimatedTexture, Unit, Int> =
        MethodStringName1<AnimatedTexture, Unit, Int>("set_frames")

    @JvmField
    public val getFramesName: MethodStringName0<AnimatedTexture, Int> =
        MethodStringName0<AnimatedTexture, Int>("get_frames")

    @JvmField
    public val setCurrentFrameName: MethodStringName1<AnimatedTexture, Unit, Int> =
        MethodStringName1<AnimatedTexture, Unit, Int>("set_current_frame")

    @JvmField
    public val getCurrentFrameName: MethodStringName0<AnimatedTexture, Int> =
        MethodStringName0<AnimatedTexture, Int>("get_current_frame")

    @JvmField
    public val setPauseName: MethodStringName1<AnimatedTexture, Unit, Boolean> =
        MethodStringName1<AnimatedTexture, Unit, Boolean>("set_pause")

    @JvmField
    public val getPauseName: MethodStringName0<AnimatedTexture, Boolean> =
        MethodStringName0<AnimatedTexture, Boolean>("get_pause")

    @JvmField
    public val setOneShotName: MethodStringName1<AnimatedTexture, Unit, Boolean> =
        MethodStringName1<AnimatedTexture, Unit, Boolean>("set_one_shot")

    @JvmField
    public val getOneShotName: MethodStringName0<AnimatedTexture, Boolean> =
        MethodStringName0<AnimatedTexture, Boolean>("get_one_shot")

    @JvmField
    public val setSpeedScaleName: MethodStringName1<AnimatedTexture, Unit, Float> =
        MethodStringName1<AnimatedTexture, Unit, Float>("set_speed_scale")

    @JvmField
    public val getSpeedScaleName: MethodStringName0<AnimatedTexture, Float> =
        MethodStringName0<AnimatedTexture, Float>("get_speed_scale")

    @JvmField
    public val setFrameTextureName: MethodStringName2<AnimatedTexture, Unit, Int, Texture2D?> =
        MethodStringName2<AnimatedTexture, Unit, Int, Texture2D?>("set_frame_texture")

    @JvmField
    public val getFrameTextureName: MethodStringName1<AnimatedTexture, Texture2D?, Int> =
        MethodStringName1<AnimatedTexture, Texture2D?, Int>("get_frame_texture")

    @JvmField
    public val setFrameDurationName: MethodStringName2<AnimatedTexture, Unit, Int, Float> =
        MethodStringName2<AnimatedTexture, Unit, Int, Float>("set_frame_duration")

    @JvmField
    public val getFrameDurationName: MethodStringName1<AnimatedTexture, Float, Int> =
        MethodStringName1<AnimatedTexture, Float, Int>("get_frame_duration")

    /**
     * The maximum number of frames supported by [AnimatedTexture]. If you need more frames in your
     * animation, use [AnimationPlayer] or [AnimatedSprite2D].
     */
    public final const val MAX_FRAMES: Long = 256
  }

  public object MethodBindings {
    internal val setFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "set_frames", 1286410249)

    internal val getFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "get_frames", 3905245786)

    internal val setCurrentFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "set_current_frame", 1286410249)

    internal val getCurrentFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "get_current_frame", 3905245786)

    internal val setPausePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "set_pause", 2586408642)

    internal val getPausePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "get_pause", 36873697)

    internal val setOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "set_one_shot", 2586408642)

    internal val getOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "get_one_shot", 36873697)

    internal val setSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "set_speed_scale", 373806689)

    internal val getSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "get_speed_scale", 1740695150)

    internal val setFrameTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "set_frame_texture", 666127730)

    internal val getFrameTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "get_frame_texture", 3536238170)

    internal val setFrameDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "set_frame_duration", 1602489585)

    internal val getFrameDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimatedTexture", "get_frame_duration", 2339986948)
  }
}
