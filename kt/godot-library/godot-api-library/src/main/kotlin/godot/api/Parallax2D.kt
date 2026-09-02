// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A [Parallax2D] is used to create a parallax effect. It can move at a different speed relative to
 * the camera movement using [scrollScale]. This creates an illusion of depth in a 2D game. If manual
 * scrolling is desired, the [Camera2D] position can be ignored with [ignoreCameraScroll].
 *
 * **Note:** Any changes to this node's position made after it enters the scene tree will be
 * overridden if [ignoreCameraScroll] is `false` or [screenOffset] is modified.
 */
@GodotBaseType
public open class Parallax2D : Node2D() {
  /**
   * Multiplier to the final [Parallax2D]'s offset. Can be used to simulate distance from the
   * camera.
   *
   * For example, a value of `1` scrolls at the same speed as the camera. A value greater than `1`
   * scrolls faster, making objects appear closer. Less than `1` scrolls slower, making objects appear
   * further, and a value of `0` stops the objects completely.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scrollScale: Vector2
    @JvmName("scrollScaleProperty")
    get() = getScrollScale()
    @JvmName("scrollScaleProperty")
    set(`value`) {
      setScrollScale(value)
    }

  /**
   * The [Parallax2D]'s offset. Similar to [screenOffset] and [Node2D.position], but will not be
   * overridden.
   *
   * **Note:** Values will loop if [repeatSize] is set higher than `0`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scrollOffset: Vector2
    @JvmName("scrollOffsetProperty")
    get() = getScrollOffset()
    @JvmName("scrollOffsetProperty")
    set(`value`) {
      setScrollOffset(value)
    }

  /**
   * Repeats the [Texture2D] of each of this node's children and offsets them by this value. When
   * scrolling, the node's position loops, giving the illusion of an infinite scrolling background if
   * the values are larger than the screen size. If an axis is set to `0`, the [Texture2D] will not be
   * repeated.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var repeatSize: Vector2
    @JvmName("repeatSizeProperty")
    get() = getRepeatSize()
    @JvmName("repeatSizeProperty")
    set(`value`) {
      setRepeatSize(value)
    }

  /**
   * Velocity at which the offset scrolls automatically, in pixels per second.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var autoscroll: Vector2
    @JvmName("autoscrollProperty")
    get() = getAutoscroll()
    @JvmName("autoscrollProperty")
    set(`value`) {
      setAutoscroll(value)
    }

  /**
   * Overrides the amount of times the texture repeats. Each texture copy spreads evenly from the
   * original by [repeatSize]. Useful for when zooming out with a camera.
   */
  public final inline var repeatTimes: Int
    @JvmName("repeatTimesProperty")
    get() = getRepeatTimes()
    @JvmName("repeatTimesProperty")
    set(`value`) {
      setRepeatTimes(value)
    }

  /**
   * Top-left limits for scrolling to begin. If the camera is outside of this limit, the
   * [Parallax2D] stops scrolling. Must be lower than [limitEnd] minus the viewport size to work.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var limitBegin: Vector2
    @JvmName("limitBeginProperty")
    get() = getLimitBegin()
    @JvmName("limitBeginProperty")
    set(`value`) {
      setLimitBegin(value)
    }

  /**
   * Bottom-right limits for scrolling to end. If the camera is outside of this limit, the
   * [Parallax2D] will stop scrolling. Must be higher than [limitBegin] and the viewport size combined
   * to work.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var limitEnd: Vector2
    @JvmName("limitEndProperty")
    get() = getLimitEnd()
    @JvmName("limitEndProperty")
    set(`value`) {
      setLimitEnd(value)
    }

  /**
   * If `true`, this [Parallax2D] is offset by the current camera's position. If the [Parallax2D] is
   * in a [CanvasLayer] separate from the current camera, it may be desired to match the value with
   * [CanvasLayer.followViewportEnabled].
   */
  public final inline var followViewport: Boolean
    @JvmName("followViewportProperty")
    get() = getFollowViewport()
    @JvmName("followViewportProperty")
    set(`value`) {
      setFollowViewport(value)
    }

  /**
   * If `true`, [Parallax2D]'s position is not affected by the position of the camera.
   */
  public final inline var ignoreCameraScroll: Boolean
    @JvmName("ignoreCameraScrollProperty")
    get() = isIgnoreCameraScroll()
    @JvmName("ignoreCameraScrollProperty")
    set(`value`) {
      setIgnoreCameraScroll(value)
    }

  /**
   * Offset used to scroll this [Parallax2D]. This value is updated automatically unless
   * [ignoreCameraScroll] is `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var screenOffset: Vector2
    @JvmName("screenOffsetProperty")
    get() = getScreenOffset()
    @JvmName("screenOffsetProperty")
    set(`value`) {
      setScreenOffset(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(511, scriptPtr)
  }

  /**
   * This is a helper function for [scrollScale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallax2d.scrollScale
   * //Your changes
   * parallax2d.scrollScale = myCoreType
   * ``````
   *
   * Multiplier to the final [Parallax2D]'s offset. Can be used to simulate distance from the
   * camera.
   *
   * For example, a value of `1` scrolls at the same speed as the camera. A value greater than `1`
   * scrolls faster, making objects appear closer. Less than `1` scrolls slower, making objects appear
   * further, and a value of `0` stops the objects completely.
   */
  @CoreTypeHelper
  public final fun scrollScaleMutate(block: Vector2.() -> Unit): Vector2 = scrollScale.apply {
     block(this)
     scrollScale = this
  }

  /**
   * This is a helper function for [scrollOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallax2d.scrollOffset
   * //Your changes
   * parallax2d.scrollOffset = myCoreType
   * ``````
   *
   * The [Parallax2D]'s offset. Similar to [screenOffset] and [Node2D.position], but will not be
   * overridden.
   *
   * **Note:** Values will loop if [repeatSize] is set higher than `0`.
   */
  @CoreTypeHelper
  public final fun scrollOffsetMutate(block: Vector2.() -> Unit): Vector2 = scrollOffset.apply {
     block(this)
     scrollOffset = this
  }

  /**
   * This is a helper function for [repeatSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallax2d.repeatSize
   * //Your changes
   * parallax2d.repeatSize = myCoreType
   * ``````
   *
   * Repeats the [Texture2D] of each of this node's children and offsets them by this value. When
   * scrolling, the node's position loops, giving the illusion of an infinite scrolling background if
   * the values are larger than the screen size. If an axis is set to `0`, the [Texture2D] will not be
   * repeated.
   */
  @CoreTypeHelper
  public final fun repeatSizeMutate(block: Vector2.() -> Unit): Vector2 = repeatSize.apply {
     block(this)
     repeatSize = this
  }

  /**
   * This is a helper function for [autoscroll] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallax2d.autoscroll
   * //Your changes
   * parallax2d.autoscroll = myCoreType
   * ``````
   *
   * Velocity at which the offset scrolls automatically, in pixels per second.
   */
  @CoreTypeHelper
  public final fun autoscrollMutate(block: Vector2.() -> Unit): Vector2 = autoscroll.apply {
     block(this)
     autoscroll = this
  }

  /**
   * This is a helper function for [limitBegin] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallax2d.limitBegin
   * //Your changes
   * parallax2d.limitBegin = myCoreType
   * ``````
   *
   * Top-left limits for scrolling to begin. If the camera is outside of this limit, the
   * [Parallax2D] stops scrolling. Must be lower than [limitEnd] minus the viewport size to work.
   */
  @CoreTypeHelper
  public final fun limitBeginMutate(block: Vector2.() -> Unit): Vector2 = limitBegin.apply {
     block(this)
     limitBegin = this
  }

  /**
   * This is a helper function for [limitEnd] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallax2d.limitEnd
   * //Your changes
   * parallax2d.limitEnd = myCoreType
   * ``````
   *
   * Bottom-right limits for scrolling to end. If the camera is outside of this limit, the
   * [Parallax2D] will stop scrolling. Must be higher than [limitBegin] and the viewport size combined
   * to work.
   */
  @CoreTypeHelper
  public final fun limitEndMutate(block: Vector2.() -> Unit): Vector2 = limitEnd.apply {
     block(this)
     limitEnd = this
  }

  /**
   * This is a helper function for [screenOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallax2d.screenOffset
   * //Your changes
   * parallax2d.screenOffset = myCoreType
   * ``````
   *
   * Offset used to scroll this [Parallax2D]. This value is updated automatically unless
   * [ignoreCameraScroll] is `true`.
   */
  @CoreTypeHelper
  public final fun screenOffsetMutate(block: Vector2.() -> Unit): Vector2 = screenOffset.apply {
     block(this)
     screenOffset = this
  }

  public final fun setScrollScale(scale: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to scale)
    TransferContext.callMethod(MethodBindings.setScrollScalePtr)
  }

  public final fun getScrollScale(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollScalePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setRepeatSize(repeatSize: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to repeatSize)
    TransferContext.callMethod(MethodBindings.setRepeatSizePtr)
  }

  public final fun getRepeatSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRepeatSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setRepeatTimes(repeatTimes: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to repeatTimes.toLong())
    TransferContext.callMethod(MethodBindings.setRepeatTimesPtr)
  }

  public final fun getRepeatTimes(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRepeatTimesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setAutoscroll(autoscroll: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to autoscroll)
    TransferContext.callMethod(MethodBindings.setAutoscrollPtr)
  }

  public final fun getAutoscroll(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutoscrollPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setScrollOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setScrollOffsetPtr)
  }

  public final fun getScrollOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setScreenOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setScreenOffsetPtr)
  }

  public final fun getScreenOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setLimitBegin(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setLimitBeginPtr)
  }

  public final fun getLimitBegin(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLimitBeginPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setLimitEnd(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setLimitEndPtr)
  }

  public final fun getLimitEnd(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLimitEndPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setFollowViewport(follow: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to follow)
    TransferContext.callMethod(MethodBindings.setFollowViewportPtr)
  }

  public final fun getFollowViewport(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFollowViewportPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setIgnoreCameraScroll(ignore: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to ignore)
    TransferContext.callMethod(MethodBindings.setIgnoreCameraScrollPtr)
  }

  public final fun isIgnoreCameraScroll(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIgnoreCameraScrollPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setScrollScaleName: MethodStringName1<Parallax2D, Unit, Vector2> =
        MethodStringName1<Parallax2D, Unit, Vector2>("set_scroll_scale")

    @JvmField
    public val getScrollScaleName: MethodStringName0<Parallax2D, Vector2> =
        MethodStringName0<Parallax2D, Vector2>("get_scroll_scale")

    @JvmField
    public val setRepeatSizeName: MethodStringName1<Parallax2D, Unit, Vector2> =
        MethodStringName1<Parallax2D, Unit, Vector2>("set_repeat_size")

    @JvmField
    public val getRepeatSizeName: MethodStringName0<Parallax2D, Vector2> =
        MethodStringName0<Parallax2D, Vector2>("get_repeat_size")

    @JvmField
    public val setRepeatTimesName: MethodStringName1<Parallax2D, Unit, Int> =
        MethodStringName1<Parallax2D, Unit, Int>("set_repeat_times")

    @JvmField
    public val getRepeatTimesName: MethodStringName0<Parallax2D, Int> =
        MethodStringName0<Parallax2D, Int>("get_repeat_times")

    @JvmField
    public val setAutoscrollName: MethodStringName1<Parallax2D, Unit, Vector2> =
        MethodStringName1<Parallax2D, Unit, Vector2>("set_autoscroll")

    @JvmField
    public val getAutoscrollName: MethodStringName0<Parallax2D, Vector2> =
        MethodStringName0<Parallax2D, Vector2>("get_autoscroll")

    @JvmField
    public val setScrollOffsetName: MethodStringName1<Parallax2D, Unit, Vector2> =
        MethodStringName1<Parallax2D, Unit, Vector2>("set_scroll_offset")

    @JvmField
    public val getScrollOffsetName: MethodStringName0<Parallax2D, Vector2> =
        MethodStringName0<Parallax2D, Vector2>("get_scroll_offset")

    @JvmField
    public val setScreenOffsetName: MethodStringName1<Parallax2D, Unit, Vector2> =
        MethodStringName1<Parallax2D, Unit, Vector2>("set_screen_offset")

    @JvmField
    public val getScreenOffsetName: MethodStringName0<Parallax2D, Vector2> =
        MethodStringName0<Parallax2D, Vector2>("get_screen_offset")

    @JvmField
    public val setLimitBeginName: MethodStringName1<Parallax2D, Unit, Vector2> =
        MethodStringName1<Parallax2D, Unit, Vector2>("set_limit_begin")

    @JvmField
    public val getLimitBeginName: MethodStringName0<Parallax2D, Vector2> =
        MethodStringName0<Parallax2D, Vector2>("get_limit_begin")

    @JvmField
    public val setLimitEndName: MethodStringName1<Parallax2D, Unit, Vector2> =
        MethodStringName1<Parallax2D, Unit, Vector2>("set_limit_end")

    @JvmField
    public val getLimitEndName: MethodStringName0<Parallax2D, Vector2> =
        MethodStringName0<Parallax2D, Vector2>("get_limit_end")

    @JvmField
    public val setFollowViewportName: MethodStringName1<Parallax2D, Unit, Boolean> =
        MethodStringName1<Parallax2D, Unit, Boolean>("set_follow_viewport")

    @JvmField
    public val getFollowViewportName: MethodStringName0<Parallax2D, Boolean> =
        MethodStringName0<Parallax2D, Boolean>("get_follow_viewport")

    @JvmField
    public val setIgnoreCameraScrollName: MethodStringName1<Parallax2D, Unit, Boolean> =
        MethodStringName1<Parallax2D, Unit, Boolean>("set_ignore_camera_scroll")

    @JvmField
    public val isIgnoreCameraScrollName: MethodStringName0<Parallax2D, Boolean> =
        MethodStringName0<Parallax2D, Boolean>("is_ignore_camera_scroll")
  }

  public object MethodBindings {
    internal val setScrollScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_scroll_scale", 743155724)

    internal val getScrollScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_scroll_scale", 3341600327)

    internal val setRepeatSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_repeat_size", 743155724)

    internal val getRepeatSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_repeat_size", 3341600327)

    internal val setRepeatTimesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_repeat_times", 1286410249)

    internal val getRepeatTimesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_repeat_times", 3905245786)

    internal val setAutoscrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_autoscroll", 743155724)

    internal val getAutoscrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_autoscroll", 3341600327)

    internal val setScrollOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_scroll_offset", 743155724)

    internal val getScrollOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_scroll_offset", 3341600327)

    internal val setScreenOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_screen_offset", 743155724)

    internal val getScreenOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_screen_offset", 3341600327)

    internal val setLimitBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_limit_begin", 743155724)

    internal val getLimitBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_limit_begin", 3341600327)

    internal val setLimitEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_limit_end", 743155724)

    internal val getLimitEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_limit_end", 3341600327)

    internal val setFollowViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_follow_viewport", 2586408642)

    internal val getFollowViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "get_follow_viewport", 2240911060)

    internal val setIgnoreCameraScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "set_ignore_camera_scroll", 2586408642)

    internal val isIgnoreCameraScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Parallax2D", "is_ignore_camera_scroll", 2240911060)
  }
}
