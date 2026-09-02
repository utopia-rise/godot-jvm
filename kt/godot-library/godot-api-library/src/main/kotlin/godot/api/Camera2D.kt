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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Side
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Camera node for 2D scenes. It forces the screen (current layer) to scroll following this node.
 * This makes it easier (and faster) to program scrollable scenes than manually changing the position
 * of [CanvasItem]-based nodes.
 *
 * Cameras register themselves in the nearest [Viewport] node (when ascending the tree). Only one
 * camera can be active per viewport. If no viewport is available ascending the tree, the camera will
 * register in the global viewport.
 *
 * This node is intended to be a simple helper to get things going quickly, but more functionality
 * may be desired to change how the camera works. To make your own custom camera node, inherit it from
 * [Node2D] and change the transform of the canvas by setting [Viewport.canvasTransform] in [Viewport]
 * (you can obtain the current [Viewport] by using [Node.getViewport]).
 *
 * Note that the [Camera2D] node's [Node2D.globalPosition] doesn't represent the actual position of
 * the screen, which may differ due to applied smoothing or limits. You can use
 * [getScreenCenterPosition] to get the real position. Same for the node's [Node2D.globalRotation]
 * which may be different due to applied rotation smoothing. You can use [getScreenRotation] to get the
 * current rotation of the screen.
 */
@GodotBaseType
public open class Camera2D : Node2D() {
  /**
   * The camera's relative offset. Useful for looking around or camera shake animations. The
   * offsetted camera can go past the limits defined in [limitTop], [limitBottom], [limitLeft] and
   * [limitRight].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offset: Vector2
    @JvmName("offsetProperty")
    get() = getOffset()
    @JvmName("offsetProperty")
    set(`value`) {
      setOffset(value)
    }

  /**
   * The Camera2D's anchor point.
   */
  public final inline var anchorMode: AnchorMode
    @JvmName("anchorModeProperty")
    get() = getAnchorMode()
    @JvmName("anchorModeProperty")
    set(`value`) {
      setAnchorMode(value)
    }

  /**
   * If `true`, the camera's rendered view is not affected by its [Node2D.rotation] and
   * [Node2D.globalRotation].
   */
  public final inline var ignoreRotation: Boolean
    @JvmName("ignoreRotationProperty")
    get() = isIgnoringRotation()
    @JvmName("ignoreRotationProperty")
    set(`value`) {
      setIgnoreRotation(value)
    }

  /**
   * Controls whether the camera can be active or not. If `true`, the [Camera2D] will become the
   * main camera when it enters the scene tree and there is no active camera currently (see
   * [Viewport.getCamera2d]).
   *
   * When the camera is currently active and [enabled] is set to `false`, the next enabled
   * [Camera2D] in the scene tree will become active.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = isEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * The camera's zoom. Higher values are more zoomed in. For example, a zoom of `Vector2(2.0, 2.0)`
   * will be twice as zoomed in on each axis (the view covers an area four times smaller). In contrast,
   * a zoom of `Vector2(0.5, 0.5)` will be twice as zoomed out on each axis (the view covers an area
   * four times larger). The X and Y components should generally always be set to the same value,
   * unless you wish to stretch the camera view.
   *
   * **Note:** [FontFile.oversampling] does *not* take [Camera2D] zoom into account. This means that
   * zooming in/out will cause bitmap fonts and rasterized (non-MSDF) dynamic fonts to appear blurry or
   * pixelated unless the font is part of a [CanvasLayer] that makes it ignore camera zoom. To ensure
   * text remains crisp regardless of zoom, you can enable MSDF font rendering by enabling
   * [ProjectSettings.gui/theme/defaultFontMultichannelSignedDistanceField] (applies to the default
   * project font only), or enabling **Multichannel Signed Distance Field** in the import options of a
   * DynamicFont for custom fonts. On system fonts, [SystemFont.multichannelSignedDistanceField] can be
   * enabled in the inspector.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var zoom: Vector2
    @JvmName("zoomProperty")
    get() = getZoom()
    @JvmName("zoomProperty")
    set(`value`) {
      setZoom(value)
    }

  /**
   * The custom [Viewport] node attached to the [Camera2D]. If `null` or not a [Viewport], uses the
   * default viewport instead.
   */
  public final inline var customViewport: Node?
    @JvmName("customViewportProperty")
    get() = getCustomViewport()
    @JvmName("customViewportProperty")
    set(`value`) {
      setCustomViewport(value)
    }

  /**
   * The camera's process callback.
   */
  public final inline var processCallback: Camera2DProcessCallback
    @JvmName("processCallbackProperty")
    get() = getProcessCallback()
    @JvmName("processCallbackProperty")
    set(`value`) {
      setProcessCallback(value)
    }

  /**
   * If `true`, the limits will be enabled. Disabling this will allow the camera to focus anywhere,
   * when the four `limit_*` properties will not work.
   */
  public final inline var limitEnabled: Boolean
    @JvmName("limitEnabledProperty")
    get() = isLimitEnabled()
    @JvmName("limitEnabledProperty")
    set(`value`) {
      setLimitEnabled(value)
    }

  /**
   * Left scroll limit in pixels. The camera stops moving when reaching this value, but [offset] can
   * push the view past the limit.
   */
  public final inline var limitLeft: Int
    @JvmName("limitLeftProperty")
    get() = getLimit(Side.LEFT)
    @JvmName("limitLeftProperty")
    set(`value`) {
      setLimit(Side.LEFT, value)
    }

  /**
   * Top scroll limit in pixels. The camera stops moving when reaching this value, but [offset] can
   * push the view past the limit.
   */
  public final inline var limitTop: Int
    @JvmName("limitTopProperty")
    get() = getLimit(Side.TOP)
    @JvmName("limitTopProperty")
    set(`value`) {
      setLimit(Side.TOP, value)
    }

  /**
   * Right scroll limit in pixels. The camera stops moving when reaching this value, but [offset]
   * can push the view past the limit.
   */
  public final inline var limitRight: Int
    @JvmName("limitRightProperty")
    get() = getLimit(Side.RIGHT)
    @JvmName("limitRightProperty")
    set(`value`) {
      setLimit(Side.RIGHT, value)
    }

  /**
   * Bottom scroll limit in pixels. The camera stops moving when reaching this value, but [offset]
   * can push the view past the limit.
   */
  public final inline var limitBottom: Int
    @JvmName("limitBottomProperty")
    get() = getLimit(Side.BOTTOM)
    @JvmName("limitBottomProperty")
    set(`value`) {
      setLimit(Side.BOTTOM, value)
    }

  /**
   * If `true`, the camera smoothly stops when reaches its limits.
   *
   * This property has no effect if [positionSmoothingEnabled] is `false`.
   *
   * **Note:** To immediately update the camera's position to be within limits without smoothing,
   * even with this setting enabled, invoke [resetSmoothing].
   */
  public final inline var limitSmoothed: Boolean
    @JvmName("limitSmoothedProperty")
    get() = isLimitSmoothingEnabled()
    @JvmName("limitSmoothedProperty")
    set(`value`) {
      setLimitSmoothingEnabled(value)
    }

  /**
   * If `true`, the camera's view smoothly moves towards its target position at
   * [positionSmoothingSpeed].
   */
  public final inline var positionSmoothingEnabled: Boolean
    @JvmName("positionSmoothingEnabledProperty")
    get() = isPositionSmoothingEnabled()
    @JvmName("positionSmoothingEnabledProperty")
    set(`value`) {
      setPositionSmoothingEnabled(value)
    }

  /**
   * Speed in pixels per second of the camera's smoothing effect when [positionSmoothingEnabled] is
   * `true`.
   */
  public final inline var positionSmoothingSpeed: Float
    @JvmName("positionSmoothingSpeedProperty")
    get() = getPositionSmoothingSpeed()
    @JvmName("positionSmoothingSpeedProperty")
    set(`value`) {
      setPositionSmoothingSpeed(value)
    }

  /**
   * If `true`, the camera's view smoothly rotates, via asymptotic smoothing, to align with its
   * target rotation at [rotationSmoothingSpeed].
   *
   * **Note:** This property has no effect if [ignoreRotation] is `true`.
   */
  public final inline var rotationSmoothingEnabled: Boolean
    @JvmName("rotationSmoothingEnabledProperty")
    get() = isRotationSmoothingEnabled()
    @JvmName("rotationSmoothingEnabledProperty")
    set(`value`) {
      setRotationSmoothingEnabled(value)
    }

  /**
   * The angular, asymptotic speed of the camera's rotation smoothing effect when
   * [rotationSmoothingEnabled] is `true`.
   */
  public final inline var rotationSmoothingSpeed: Float
    @JvmName("rotationSmoothingSpeedProperty")
    get() = getRotationSmoothingSpeed()
    @JvmName("rotationSmoothingSpeedProperty")
    set(`value`) {
      setRotationSmoothingSpeed(value)
    }

  /**
   * If `true`, the camera only moves when reaching the horizontal (left and right) drag margins. If
   * `false`, the camera moves horizontally regardless of margins.
   */
  public final inline var dragHorizontalEnabled: Boolean
    @JvmName("dragHorizontalEnabledProperty")
    get() = isDragHorizontalEnabled()
    @JvmName("dragHorizontalEnabledProperty")
    set(`value`) {
      setDragHorizontalEnabled(value)
    }

  /**
   * If `true`, the camera only moves when reaching the vertical (top and bottom) drag margins. If
   * `false`, the camera moves vertically regardless of the drag margins.
   */
  public final inline var dragVerticalEnabled: Boolean
    @JvmName("dragVerticalEnabledProperty")
    get() = isDragVerticalEnabled()
    @JvmName("dragVerticalEnabledProperty")
    set(`value`) {
      setDragVerticalEnabled(value)
    }

  /**
   * The relative horizontal drag offset of the camera between the right (`-1`) and left (`1`) drag
   * margins.
   *
   * **Note:** Used to set the initial horizontal drag offset; determine the current offset; or
   * force the current offset. It's not automatically updated when [dragHorizontalEnabled] is `true` or
   * the drag margins are changed.
   */
  public final inline var dragHorizontalOffset: Float
    @JvmName("dragHorizontalOffsetProperty")
    get() = getDragHorizontalOffset()
    @JvmName("dragHorizontalOffsetProperty")
    set(`value`) {
      setDragHorizontalOffset(value)
    }

  /**
   * The relative vertical drag offset of the camera between the bottom (`-1`) and top (`1`) drag
   * margins.
   *
   * **Note:** Used to set the initial vertical drag offset; determine the current offset; or force
   * the current offset. It's not automatically updated when [dragVerticalEnabled] is `true` or the
   * drag margins are changed.
   */
  public final inline var dragVerticalOffset: Float
    @JvmName("dragVerticalOffsetProperty")
    get() = getDragVerticalOffset()
    @JvmName("dragVerticalOffsetProperty")
    set(`value`) {
      setDragVerticalOffset(value)
    }

  /**
   * Left margin needed to drag the camera. A value of `1` makes the camera move only when reaching
   * the left edge of the screen.
   */
  public final inline var dragLeftMargin: Float
    @JvmName("dragLeftMarginProperty")
    get() = getDragMargin(Side.LEFT)
    @JvmName("dragLeftMarginProperty")
    set(`value`) {
      setDragMargin(Side.LEFT, value)
    }

  /**
   * Top margin needed to drag the camera. A value of `1` makes the camera move only when reaching
   * the top edge of the screen.
   */
  public final inline var dragTopMargin: Float
    @JvmName("dragTopMarginProperty")
    get() = getDragMargin(Side.TOP)
    @JvmName("dragTopMarginProperty")
    set(`value`) {
      setDragMargin(Side.TOP, value)
    }

  /**
   * Right margin needed to drag the camera. A value of `1` makes the camera move only when reaching
   * the right edge of the screen.
   */
  public final inline var dragRightMargin: Float
    @JvmName("dragRightMarginProperty")
    get() = getDragMargin(Side.RIGHT)
    @JvmName("dragRightMarginProperty")
    set(`value`) {
      setDragMargin(Side.RIGHT, value)
    }

  /**
   * Bottom margin needed to drag the camera. A value of `1` makes the camera move only when
   * reaching the bottom edge of the screen.
   */
  public final inline var dragBottomMargin: Float
    @JvmName("dragBottomMarginProperty")
    get() = getDragMargin(Side.BOTTOM)
    @JvmName("dragBottomMarginProperty")
    set(`value`) {
      setDragMargin(Side.BOTTOM, value)
    }

  /**
   * If `true`, draws the camera's screen rectangle in the editor.
   */
  public final inline var editorDrawScreen: Boolean
    @JvmName("editorDrawScreenProperty")
    get() = isScreenDrawingEnabled()
    @JvmName("editorDrawScreenProperty")
    set(`value`) {
      setScreenDrawingEnabled(value)
    }

  /**
   * If `true`, draws the camera's limits rectangle in the editor.
   */
  public final inline var editorDrawLimits: Boolean
    @JvmName("editorDrawLimitsProperty")
    get() = isLimitDrawingEnabled()
    @JvmName("editorDrawLimitsProperty")
    set(`value`) {
      setLimitDrawingEnabled(value)
    }

  /**
   * If `true`, draws the camera's drag margin rectangle in the editor.
   */
  public final inline var editorDrawDragMargin: Boolean
    @JvmName("editorDrawDragMarginProperty")
    get() = isMarginDrawingEnabled()
    @JvmName("editorDrawDragMarginProperty")
    set(`value`) {
      setMarginDrawingEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(135, scriptPtr)
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = camera2d.offset
   * //Your changes
   * camera2d.offset = myCoreType
   * ``````
   *
   * The camera's relative offset. Useful for looking around or camera shake animations. The
   * offsetted camera can go past the limits defined in [limitTop], [limitBottom], [limitLeft] and
   * [limitRight].
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  /**
   * This is a helper function for [zoom] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = camera2d.zoom
   * //Your changes
   * camera2d.zoom = myCoreType
   * ``````
   *
   * The camera's zoom. Higher values are more zoomed in. For example, a zoom of `Vector2(2.0, 2.0)`
   * will be twice as zoomed in on each axis (the view covers an area four times smaller). In contrast,
   * a zoom of `Vector2(0.5, 0.5)` will be twice as zoomed out on each axis (the view covers an area
   * four times larger). The X and Y components should generally always be set to the same value,
   * unless you wish to stretch the camera view.
   *
   * **Note:** [FontFile.oversampling] does *not* take [Camera2D] zoom into account. This means that
   * zooming in/out will cause bitmap fonts and rasterized (non-MSDF) dynamic fonts to appear blurry or
   * pixelated unless the font is part of a [CanvasLayer] that makes it ignore camera zoom. To ensure
   * text remains crisp regardless of zoom, you can enable MSDF font rendering by enabling
   * [ProjectSettings.gui/theme/defaultFontMultichannelSignedDistanceField] (applies to the default
   * project font only), or enabling **Multichannel Signed Distance Field** in the import options of a
   * DynamicFont for custom fonts. On system fonts, [SystemFont.multichannelSignedDistanceField] can be
   * enabled in the inspector.
   */
  @CoreTypeHelper
  public final fun zoomMutate(block: Vector2.() -> Unit): Vector2 = zoom.apply {
     block(this)
     zoom = this
  }

  public final fun setOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setOffsetPtr)
  }

  public final fun getOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setAnchorMode(anchorMode: AnchorMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to anchorMode.value)
    TransferContext.callMethod(MethodBindings.setAnchorModePtr)
  }

  public final fun getAnchorMode(): AnchorMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnchorModePtr)
    return AnchorMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setIgnoreRotation(ignore: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to ignore)
    TransferContext.callMethod(MethodBindings.setIgnoreRotationPtr)
  }

  public final fun isIgnoringRotation(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIgnoringRotationPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setProcessCallback(mode: Camera2DProcessCallback): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setProcessCallbackPtr)
  }

  public final fun getProcessCallback(): Camera2DProcessCallback {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProcessCallbackPtr)
    return Camera2DProcessCallback.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEnabledPtr)
  }

  public final fun isEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Forces this [Camera2D] to become the current active one. [enabled] must be `true`.
   */
  public final fun makeCurrent(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.makeCurrentPtr)
  }

  /**
   * Returns `true` if this [Camera2D] is the active camera (see [Viewport.getCamera2d]).
   */
  public final fun isCurrent(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCurrentPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLimitEnabled(limitEnabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to limitEnabled)
    TransferContext.callMethod(MethodBindings.setLimitEnabledPtr)
  }

  public final fun isLimitEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLimitEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the camera limit for the specified [Side]. See also [limitBottom], [limitTop],
   * [limitLeft], and [limitRight].
   */
  public final fun setLimit(margin: Side, limit: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value, LONG to limit.toLong())
    TransferContext.callMethod(MethodBindings.setLimitPtr)
  }

  /**
   * Returns the camera limit for the specified [Side]. See also [limitBottom], [limitTop],
   * [limitLeft], and [limitRight].
   */
  public final fun getLimit(margin: Side): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value)
    TransferContext.callMethod(MethodBindings.getLimitPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setLimitSmoothingEnabled(limitSmoothingEnabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to limitSmoothingEnabled)
    TransferContext.callMethod(MethodBindings.setLimitSmoothingEnabledPtr)
  }

  public final fun isLimitSmoothingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLimitSmoothingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDragVerticalEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setDragVerticalEnabledPtr)
  }

  public final fun isDragVerticalEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDragVerticalEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDragHorizontalEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setDragHorizontalEnabledPtr)
  }

  public final fun isDragHorizontalEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDragHorizontalEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDragVerticalOffset(offset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.setDragVerticalOffsetPtr)
  }

  public final fun getDragVerticalOffset(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDragVerticalOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDragHorizontalOffset(offset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.setDragHorizontalOffsetPtr)
  }

  public final fun getDragHorizontalOffset(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDragHorizontalOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the specified [Side]'s margin. See also [dragBottomMargin], [dragTopMargin],
   * [dragLeftMargin], and [dragRightMargin].
   */
  public final fun setDragMargin(margin: Side, dragMargin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value, DOUBLE to dragMargin.toDouble())
    TransferContext.callMethod(MethodBindings.setDragMarginPtr)
  }

  /**
   * Returns the specified [Side]'s margin. See also [dragBottomMargin], [dragTopMargin],
   * [dragLeftMargin], and [dragRightMargin].
   */
  public final fun getDragMargin(margin: Side): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to margin.value)
    TransferContext.callMethod(MethodBindings.getDragMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns this camera's target position, in global coordinates.
   *
   * **Note:** The returned value is not the same as [Node2D.globalPosition], as it is affected by
   * the drag properties. It is also not the same as the current position if [positionSmoothingEnabled]
   * is `true` (see [getScreenCenterPosition]).
   */
  public final fun getTargetPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the center of the screen from this camera's point of view, in global coordinates.
   *
   * **Note:** The exact targeted position of the camera may be different. See [getTargetPosition].
   */
  public final fun getScreenCenterPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenCenterPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the current screen rotation from this camera's point of view.
   *
   * **Note:** The screen rotation can be different from [Node2D.globalRotation] if the camera is
   * rotating smoothly due to [rotationSmoothingEnabled].
   */
  public final fun getScreenRotation(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenRotationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setZoom(zoom: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to zoom)
    TransferContext.callMethod(MethodBindings.setZoomPtr)
  }

  public final fun getZoom(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZoomPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setCustomViewport(viewport: Node?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to viewport)
    TransferContext.callMethod(MethodBindings.setCustomViewportPtr)
  }

  public final fun getCustomViewport(): Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomViewportPtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  public final fun setPositionSmoothingSpeed(positionSmoothingSpeed: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to positionSmoothingSpeed.toDouble())
    TransferContext.callMethod(MethodBindings.setPositionSmoothingSpeedPtr)
  }

  public final fun getPositionSmoothingSpeed(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionSmoothingSpeedPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPositionSmoothingEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setPositionSmoothingEnabledPtr)
  }

  public final fun isPositionSmoothingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPositionSmoothingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRotationSmoothingEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setRotationSmoothingEnabledPtr)
  }

  public final fun isRotationSmoothingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRotationSmoothingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRotationSmoothingSpeed(speed: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to speed.toDouble())
    TransferContext.callMethod(MethodBindings.setRotationSmoothingSpeedPtr)
  }

  public final fun getRotationSmoothingSpeed(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationSmoothingSpeedPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Forces the camera to update scroll immediately.
   */
  public final fun forceUpdateScroll(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceUpdateScrollPtr)
  }

  /**
   * Sets the camera's position immediately to its current smoothing destination.
   *
   * This method has no effect if [positionSmoothingEnabled] is `false`.
   */
  public final fun resetSmoothing(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetSmoothingPtr)
  }

  /**
   * Aligns the camera to the tracked node.
   *
   * **Note:** Calling [forceUpdateScroll] after this method is not required.
   */
  public final fun align(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.alignPtr)
  }

  public final fun setScreenDrawingEnabled(screenDrawingEnabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to screenDrawingEnabled)
    TransferContext.callMethod(MethodBindings.setScreenDrawingEnabledPtr)
  }

  public final fun isScreenDrawingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isScreenDrawingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLimitDrawingEnabled(limitDrawingEnabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to limitDrawingEnabled)
    TransferContext.callMethod(MethodBindings.setLimitDrawingEnabledPtr)
  }

  public final fun isLimitDrawingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLimitDrawingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMarginDrawingEnabled(marginDrawingEnabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to marginDrawingEnabled)
    TransferContext.callMethod(MethodBindings.setMarginDrawingEnabledPtr)
  }

  public final fun isMarginDrawingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMarginDrawingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class AnchorMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The camera's position is fixed so that the top-left corner is always at the origin.
     */
    FIXED_TOP_LEFT(0),
    /**
     * The camera's position takes into account vertical/horizontal offsets and the screen size.
     */
    DRAG_CENTER(1),
    ;

    public companion object {
      public fun from(`value`: Long): AnchorMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class Camera2DProcessCallback(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The camera updates during physics frames (see [Node.NOTIFICATION_INTERNAL_PHYSICS_PROCESS]).
     */
    PHYSICS(0),
    /**
     * The camera updates during process frames (see [Node.NOTIFICATION_INTERNAL_PROCESS]).
     */
    IDLE(1),
    ;

    public companion object {
      public fun from(`value`: Long): Camera2DProcessCallback =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setOffsetName: MethodStringName1<Camera2D, Unit, Vector2> =
        MethodStringName1<Camera2D, Unit, Vector2>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<Camera2D, Vector2> =
        MethodStringName0<Camera2D, Vector2>("get_offset")

    @JvmField
    public val setAnchorModeName: MethodStringName1<Camera2D, Unit, AnchorMode> =
        MethodStringName1<Camera2D, Unit, AnchorMode>("set_anchor_mode")

    @JvmField
    public val getAnchorModeName: MethodStringName0<Camera2D, AnchorMode> =
        MethodStringName0<Camera2D, AnchorMode>("get_anchor_mode")

    @JvmField
    public val setIgnoreRotationName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_ignore_rotation")

    @JvmField
    public val isIgnoringRotationName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_ignoring_rotation")

    @JvmField
    public val setProcessCallbackName: MethodStringName1<Camera2D, Unit, Camera2DProcessCallback> =
        MethodStringName1<Camera2D, Unit, Camera2DProcessCallback>("set_process_callback")

    @JvmField
    public val getProcessCallbackName: MethodStringName0<Camera2D, Camera2DProcessCallback> =
        MethodStringName0<Camera2D, Camera2DProcessCallback>("get_process_callback")

    @JvmField
    public val setEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_enabled")

    @JvmField
    public val isEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_enabled")

    @JvmField
    public val makeCurrentName: MethodStringName0<Camera2D, Unit> =
        MethodStringName0<Camera2D, Unit>("make_current")

    @JvmField
    public val isCurrentName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_current")

    @JvmField
    public val setLimitEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_limit_enabled")

    @JvmField
    public val isLimitEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_limit_enabled")

    @JvmField
    public val setLimitName: MethodStringName2<Camera2D, Unit, Side, Int> =
        MethodStringName2<Camera2D, Unit, Side, Int>("set_limit")

    @JvmField
    public val getLimitName: MethodStringName1<Camera2D, Int, Side> =
        MethodStringName1<Camera2D, Int, Side>("get_limit")

    @JvmField
    public val setLimitSmoothingEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_limit_smoothing_enabled")

    @JvmField
    public val isLimitSmoothingEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_limit_smoothing_enabled")

    @JvmField
    public val setDragVerticalEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_drag_vertical_enabled")

    @JvmField
    public val isDragVerticalEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_drag_vertical_enabled")

    @JvmField
    public val setDragHorizontalEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_drag_horizontal_enabled")

    @JvmField
    public val isDragHorizontalEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_drag_horizontal_enabled")

    @JvmField
    public val setDragVerticalOffsetName: MethodStringName1<Camera2D, Unit, Float> =
        MethodStringName1<Camera2D, Unit, Float>("set_drag_vertical_offset")

    @JvmField
    public val getDragVerticalOffsetName: MethodStringName0<Camera2D, Float> =
        MethodStringName0<Camera2D, Float>("get_drag_vertical_offset")

    @JvmField
    public val setDragHorizontalOffsetName: MethodStringName1<Camera2D, Unit, Float> =
        MethodStringName1<Camera2D, Unit, Float>("set_drag_horizontal_offset")

    @JvmField
    public val getDragHorizontalOffsetName: MethodStringName0<Camera2D, Float> =
        MethodStringName0<Camera2D, Float>("get_drag_horizontal_offset")

    @JvmField
    public val setDragMarginName: MethodStringName2<Camera2D, Unit, Side, Float> =
        MethodStringName2<Camera2D, Unit, Side, Float>("set_drag_margin")

    @JvmField
    public val getDragMarginName: MethodStringName1<Camera2D, Float, Side> =
        MethodStringName1<Camera2D, Float, Side>("get_drag_margin")

    @JvmField
    public val getTargetPositionName: MethodStringName0<Camera2D, Vector2> =
        MethodStringName0<Camera2D, Vector2>("get_target_position")

    @JvmField
    public val getScreenCenterPositionName: MethodStringName0<Camera2D, Vector2> =
        MethodStringName0<Camera2D, Vector2>("get_screen_center_position")

    @JvmField
    public val getScreenRotationName: MethodStringName0<Camera2D, Float> =
        MethodStringName0<Camera2D, Float>("get_screen_rotation")

    @JvmField
    public val setZoomName: MethodStringName1<Camera2D, Unit, Vector2> =
        MethodStringName1<Camera2D, Unit, Vector2>("set_zoom")

    @JvmField
    public val getZoomName: MethodStringName0<Camera2D, Vector2> =
        MethodStringName0<Camera2D, Vector2>("get_zoom")

    @JvmField
    public val setCustomViewportName: MethodStringName1<Camera2D, Unit, Node?> =
        MethodStringName1<Camera2D, Unit, Node?>("set_custom_viewport")

    @JvmField
    public val getCustomViewportName: MethodStringName0<Camera2D, Node?> =
        MethodStringName0<Camera2D, Node?>("get_custom_viewport")

    @JvmField
    public val setPositionSmoothingSpeedName: MethodStringName1<Camera2D, Unit, Float> =
        MethodStringName1<Camera2D, Unit, Float>("set_position_smoothing_speed")

    @JvmField
    public val getPositionSmoothingSpeedName: MethodStringName0<Camera2D, Float> =
        MethodStringName0<Camera2D, Float>("get_position_smoothing_speed")

    @JvmField
    public val setPositionSmoothingEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_position_smoothing_enabled")

    @JvmField
    public val isPositionSmoothingEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_position_smoothing_enabled")

    @JvmField
    public val setRotationSmoothingEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_rotation_smoothing_enabled")

    @JvmField
    public val isRotationSmoothingEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_rotation_smoothing_enabled")

    @JvmField
    public val setRotationSmoothingSpeedName: MethodStringName1<Camera2D, Unit, Float> =
        MethodStringName1<Camera2D, Unit, Float>("set_rotation_smoothing_speed")

    @JvmField
    public val getRotationSmoothingSpeedName: MethodStringName0<Camera2D, Float> =
        MethodStringName0<Camera2D, Float>("get_rotation_smoothing_speed")

    @JvmField
    public val forceUpdateScrollName: MethodStringName0<Camera2D, Unit> =
        MethodStringName0<Camera2D, Unit>("force_update_scroll")

    @JvmField
    public val resetSmoothingName: MethodStringName0<Camera2D, Unit> =
        MethodStringName0<Camera2D, Unit>("reset_smoothing")

    @JvmField
    public val alignName: MethodStringName0<Camera2D, Unit> =
        MethodStringName0<Camera2D, Unit>("align")

    @JvmField
    public val setScreenDrawingEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_screen_drawing_enabled")

    @JvmField
    public val isScreenDrawingEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_screen_drawing_enabled")

    @JvmField
    public val setLimitDrawingEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_limit_drawing_enabled")

    @JvmField
    public val isLimitDrawingEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_limit_drawing_enabled")

    @JvmField
    public val setMarginDrawingEnabledName: MethodStringName1<Camera2D, Unit, Boolean> =
        MethodStringName1<Camera2D, Unit, Boolean>("set_margin_drawing_enabled")

    @JvmField
    public val isMarginDrawingEnabledName: MethodStringName0<Camera2D, Boolean> =
        MethodStringName0<Camera2D, Boolean>("is_margin_drawing_enabled")
  }

  public object MethodBindings {
    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_offset", 743155724)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_offset", 3341600327)

    internal val setAnchorModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_anchor_mode", 2050398218)

    internal val getAnchorModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_anchor_mode", 155978067)

    internal val setIgnoreRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_ignore_rotation", 2586408642)

    internal val isIgnoringRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_ignoring_rotation", 36873697)

    internal val setProcessCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_process_callback", 4201947462)

    internal val getProcessCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_process_callback", 2325344499)

    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_enabled", 2586408642)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_enabled", 36873697)

    internal val makeCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "make_current", 3218959716)

    internal val isCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_current", 36873697)

    internal val setLimitEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_limit_enabled", 2586408642)

    internal val isLimitEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_limit_enabled", 36873697)

    internal val setLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_limit", 437707142)

    internal val getLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_limit", 1983885014)

    internal val setLimitSmoothingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_limit_smoothing_enabled", 2586408642)

    internal val isLimitSmoothingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_limit_smoothing_enabled", 36873697)

    internal val setDragVerticalEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_drag_vertical_enabled", 2586408642)

    internal val isDragVerticalEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_drag_vertical_enabled", 36873697)

    internal val setDragHorizontalEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_drag_horizontal_enabled", 2586408642)

    internal val isDragHorizontalEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_drag_horizontal_enabled", 36873697)

    internal val setDragVerticalOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_drag_vertical_offset", 373806689)

    internal val getDragVerticalOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_drag_vertical_offset", 1740695150)

    internal val setDragHorizontalOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_drag_horizontal_offset", 373806689)

    internal val getDragHorizontalOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_drag_horizontal_offset", 1740695150)

    internal val setDragMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_drag_margin", 4290182280)

    internal val getDragMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_drag_margin", 2869120046)

    internal val getTargetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_target_position", 3341600327)

    internal val getScreenCenterPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_screen_center_position", 3341600327)

    internal val getScreenRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_screen_rotation", 1740695150)

    internal val setZoomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_zoom", 743155724)

    internal val getZoomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_zoom", 3341600327)

    internal val setCustomViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_custom_viewport", 1078189570)

    internal val getCustomViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_custom_viewport", 3160264692)

    internal val setPositionSmoothingSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_position_smoothing_speed", 373806689)

    internal val getPositionSmoothingSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_position_smoothing_speed", 1740695150)

    internal val setPositionSmoothingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_position_smoothing_enabled", 2586408642)

    internal val isPositionSmoothingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_position_smoothing_enabled", 36873697)

    internal val setRotationSmoothingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_rotation_smoothing_enabled", 2586408642)

    internal val isRotationSmoothingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_rotation_smoothing_enabled", 36873697)

    internal val setRotationSmoothingSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_rotation_smoothing_speed", 373806689)

    internal val getRotationSmoothingSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "get_rotation_smoothing_speed", 1740695150)

    internal val forceUpdateScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "force_update_scroll", 3218959716)

    internal val resetSmoothingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "reset_smoothing", 3218959716)

    internal val alignPtr: VoidPtr = TypeManager.getMethodBindPtr("Camera2D", "align", 3218959716)

    internal val setScreenDrawingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_screen_drawing_enabled", 2586408642)

    internal val isScreenDrawingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_screen_drawing_enabled", 36873697)

    internal val setLimitDrawingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_limit_drawing_enabled", 2586408642)

    internal val isLimitDrawingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_limit_drawing_enabled", 36873697)

    internal val setMarginDrawingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "set_margin_drawing_enabled", 2586408642)

    internal val isMarginDrawingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera2D", "is_margin_drawing_enabled", 36873697)
  }
}
