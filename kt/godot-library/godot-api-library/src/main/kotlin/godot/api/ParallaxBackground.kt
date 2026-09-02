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
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A ParallaxBackground uses one or more [ParallaxLayer] child nodes to create a parallax effect.
 * Each [ParallaxLayer] can move at a different speed using [ParallaxLayer.motionOffset]. This creates
 * an illusion of depth in a 2D game. If not used with a [Camera2D], you must manually calculate the
 * [scrollOffset].
 *
 * **Note:** Each [ParallaxBackground] is drawn on one specific [Viewport] and cannot be shared
 * between multiple [Viewport]s, see [CanvasLayer.customViewport]. When using multiple [Viewport]s, for
 * example in a split-screen game, you need create an individual [ParallaxBackground] for each
 * [Viewport] you want it to be drawn on.
 */
@GodotBaseType
public open class ParallaxBackground : CanvasLayer() {
  /**
   * The ParallaxBackground's scroll value. Calculated automatically when using a [Camera2D], but
   * can be used to manually manage scrolling when no camera is present.
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
   * The base position offset for all [ParallaxLayer] children.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scrollBaseOffset: Vector2
    @JvmName("scrollBaseOffsetProperty")
    get() = getScrollBaseOffset()
    @JvmName("scrollBaseOffsetProperty")
    set(`value`) {
      setScrollBaseOffset(value)
    }

  /**
   * The base motion scale for all [ParallaxLayer] children.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scrollBaseScale: Vector2
    @JvmName("scrollBaseScaleProperty")
    get() = getScrollBaseScale()
    @JvmName("scrollBaseScaleProperty")
    set(`value`) {
      setScrollBaseScale(value)
    }

  /**
   * Top-left limits for scrolling to begin. If the camera is outside of this limit, the background
   * will stop scrolling. Must be lower than [scrollLimitEnd] to work.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scrollLimitBegin: Vector2
    @JvmName("scrollLimitBeginProperty")
    get() = getLimitBegin()
    @JvmName("scrollLimitBeginProperty")
    set(`value`) {
      setLimitBegin(value)
    }

  /**
   * Bottom-right limits for scrolling to end. If the camera is outside of this limit, the
   * background will stop scrolling. Must be higher than [scrollLimitBegin] to work.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scrollLimitEnd: Vector2
    @JvmName("scrollLimitEndProperty")
    get() = getLimitEnd()
    @JvmName("scrollLimitEndProperty")
    set(`value`) {
      setLimitEnd(value)
    }

  /**
   * If `true`, elements in [ParallaxLayer] child aren't affected by the zoom level of the camera.
   */
  public final inline var scrollIgnoreCameraZoom: Boolean
    @JvmName("scrollIgnoreCameraZoomProperty")
    get() = isIgnoreCameraZoom()
    @JvmName("scrollIgnoreCameraZoomProperty")
    set(`value`) {
      setIgnoreCameraZoom(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(512, scriptPtr)
  }

  /**
   * This is a helper function for [scrollOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxbackground.scrollOffset
   * //Your changes
   * parallaxbackground.scrollOffset = myCoreType
   * ``````
   *
   * The ParallaxBackground's scroll value. Calculated automatically when using a [Camera2D], but
   * can be used to manually manage scrolling when no camera is present.
   */
  @CoreTypeHelper
  public final fun scrollOffsetMutate(block: Vector2.() -> Unit): Vector2 = scrollOffset.apply {
     block(this)
     scrollOffset = this
  }

  /**
   * This is a helper function for [scrollBaseOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxbackground.scrollBaseOffset
   * //Your changes
   * parallaxbackground.scrollBaseOffset = myCoreType
   * ``````
   *
   * The base position offset for all [ParallaxLayer] children.
   */
  @CoreTypeHelper
  public final fun scrollBaseOffsetMutate(block: Vector2.() -> Unit): Vector2 =
      scrollBaseOffset.apply {
     block(this)
     scrollBaseOffset = this
  }

  /**
   * This is a helper function for [scrollBaseScale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxbackground.scrollBaseScale
   * //Your changes
   * parallaxbackground.scrollBaseScale = myCoreType
   * ``````
   *
   * The base motion scale for all [ParallaxLayer] children.
   */
  @CoreTypeHelper
  public final fun scrollBaseScaleMutate(block: Vector2.() -> Unit): Vector2 =
      scrollBaseScale.apply {
     block(this)
     scrollBaseScale = this
  }

  /**
   * This is a helper function for [scrollLimitBegin] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxbackground.scrollLimitBegin
   * //Your changes
   * parallaxbackground.scrollLimitBegin = myCoreType
   * ``````
   *
   * Top-left limits for scrolling to begin. If the camera is outside of this limit, the background
   * will stop scrolling. Must be lower than [scrollLimitEnd] to work.
   */
  @CoreTypeHelper
  public final fun scrollLimitBeginMutate(block: Vector2.() -> Unit): Vector2 =
      scrollLimitBegin.apply {
     block(this)
     scrollLimitBegin = this
  }

  /**
   * This is a helper function for [scrollLimitEnd] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = parallaxbackground.scrollLimitEnd
   * //Your changes
   * parallaxbackground.scrollLimitEnd = myCoreType
   * ``````
   *
   * Bottom-right limits for scrolling to end. If the camera is outside of this limit, the
   * background will stop scrolling. Must be higher than [scrollLimitBegin] to work.
   */
  @CoreTypeHelper
  public final fun scrollLimitEndMutate(block: Vector2.() -> Unit): Vector2 = scrollLimitEnd.apply {
     block(this)
     scrollLimitEnd = this
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

  public final fun setScrollBaseOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setScrollBaseOffsetPtr)
  }

  public final fun getScrollBaseOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollBaseOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setScrollBaseScale(scale: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to scale)
    TransferContext.callMethod(MethodBindings.setScrollBaseScalePtr)
  }

  public final fun getScrollBaseScale(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollBaseScalePtr)
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

  public final fun setIgnoreCameraZoom(ignore: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to ignore)
    TransferContext.callMethod(MethodBindings.setIgnoreCameraZoomPtr)
  }

  public final fun isIgnoreCameraZoom(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIgnoreCameraZoomPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setScrollOffsetName: MethodStringName1<ParallaxBackground, Unit, Vector2> =
        MethodStringName1<ParallaxBackground, Unit, Vector2>("set_scroll_offset")

    @JvmField
    public val getScrollOffsetName: MethodStringName0<ParallaxBackground, Vector2> =
        MethodStringName0<ParallaxBackground, Vector2>("get_scroll_offset")

    @JvmField
    public val setScrollBaseOffsetName: MethodStringName1<ParallaxBackground, Unit, Vector2> =
        MethodStringName1<ParallaxBackground, Unit, Vector2>("set_scroll_base_offset")

    @JvmField
    public val getScrollBaseOffsetName: MethodStringName0<ParallaxBackground, Vector2> =
        MethodStringName0<ParallaxBackground, Vector2>("get_scroll_base_offset")

    @JvmField
    public val setScrollBaseScaleName: MethodStringName1<ParallaxBackground, Unit, Vector2> =
        MethodStringName1<ParallaxBackground, Unit, Vector2>("set_scroll_base_scale")

    @JvmField
    public val getScrollBaseScaleName: MethodStringName0<ParallaxBackground, Vector2> =
        MethodStringName0<ParallaxBackground, Vector2>("get_scroll_base_scale")

    @JvmField
    public val setLimitBeginName: MethodStringName1<ParallaxBackground, Unit, Vector2> =
        MethodStringName1<ParallaxBackground, Unit, Vector2>("set_limit_begin")

    @JvmField
    public val getLimitBeginName: MethodStringName0<ParallaxBackground, Vector2> =
        MethodStringName0<ParallaxBackground, Vector2>("get_limit_begin")

    @JvmField
    public val setLimitEndName: MethodStringName1<ParallaxBackground, Unit, Vector2> =
        MethodStringName1<ParallaxBackground, Unit, Vector2>("set_limit_end")

    @JvmField
    public val getLimitEndName: MethodStringName0<ParallaxBackground, Vector2> =
        MethodStringName0<ParallaxBackground, Vector2>("get_limit_end")

    @JvmField
    public val setIgnoreCameraZoomName: MethodStringName1<ParallaxBackground, Unit, Boolean> =
        MethodStringName1<ParallaxBackground, Unit, Boolean>("set_ignore_camera_zoom")

    @JvmField
    public val isIgnoreCameraZoomName: MethodStringName0<ParallaxBackground, Boolean> =
        MethodStringName0<ParallaxBackground, Boolean>("is_ignore_camera_zoom")
  }

  public object MethodBindings {
    internal val setScrollOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "set_scroll_offset", 743155724)

    internal val getScrollOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "get_scroll_offset", 3341600327)

    internal val setScrollBaseOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "set_scroll_base_offset", 743155724)

    internal val getScrollBaseOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "get_scroll_base_offset", 3341600327)

    internal val setScrollBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "set_scroll_base_scale", 743155724)

    internal val getScrollBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "get_scroll_base_scale", 3341600327)

    internal val setLimitBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "set_limit_begin", 743155724)

    internal val getLimitBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "get_limit_begin", 3341600327)

    internal val setLimitEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "set_limit_end", 743155724)

    internal val getLimitEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "get_limit_end", 3341600327)

    internal val setIgnoreCameraZoomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "set_ignore_camera_zoom", 2586408642)

    internal val isIgnoreCameraZoomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParallaxBackground", "is_ignore_camera_zoom", 2240911060)
  }
}
