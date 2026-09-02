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
import godot.core.BitFieldBase
import godot.core.Callable
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.NodePath
import godot.core.Rect2
import godot.core.Side
import godot.core.Signal0
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.Vector3i
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

public infix fun Long.or(other: Control.SizeFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: Control.SizeFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: Control.SizeFlags): Long = this.and(other.flag)

/**
 * Base class for all UI-related nodes. [Control] features a bounding rectangle that defines its
 * extents, an anchor position relative to its parent control or the current viewport, and offsets
 * relative to the anchor. The offsets update automatically when the node, any of its parents, or the
 * screen size change.
 *
 * For more information on Godot's UI system, anchors, offsets, and containers, see the related
 * tutorials in the manual. To build flexible UIs, you'll need a mix of UI elements that inherit from
 * [Control] and [Container] nodes.
 *
 * **Note:** Since both [Node2D] and [Control] inherit from [CanvasItem], they share several
 * concepts from the class such as the [CanvasItem.zIndex] and [CanvasItem.visible] properties.
 *
 * **User Interface nodes and input**
 *
 * Godot propagates input events via viewports. Each [Viewport] is responsible for propagating
 * [InputEvent]s to their child nodes. As the [SceneTree.root] is a [Window], this already happens
 * automatically for all UI elements in your game.
 *
 * Input events are propagated through the [SceneTree] from the root node to all child nodes by
 * calling [Node.Input]. For UI elements specifically, it makes more sense to override the virtual
 * method [_guiInput], which filters out unrelated input events, such as by checking z-order,
 * [mouseFilter], focus, or if the event was inside of the control's bounding box.
 *
 * Call [acceptEvent] so no other node receives the event. Once you accept an input, it becomes
 * handled so [Node.UnhandledInput] will not process it.
 *
 * Only one [Control] node can be in focus. Only the node in focus will receive events. To get the
 * focus, call [grabFocus]. [Control] nodes lose focus when another node grabs it, or if you hide the
 * node in focus. Focus will not be represented visually if gained via mouse/touch input, only
 * appearing with keyboard/gamepad input (for accessibility), or via [grabFocus].
 *
 * Set [mouseFilter] to [MOUSE_FILTER_IGNORE] to tell a [Control] node to ignore mouse or touch
 * events. You'll need it if you place an icon on top of a button.
 *
 * [Theme] resources change the control's appearance. The [theme] of a [Control] node affects all of
 * its direct and indirect children (as long as a chain of controls is uninterrupted). To override some
 * of the theme items, call one of the `add_theme_*_override` methods, like [addThemeFontOverride]. You
 * can also override theme items in the Inspector.
 *
 * **Note:** Theme items are *not* [Object] properties. This means you can't access their values
 * using [Object.get] and [Object.set]. Instead, use the `get_theme_*` and `add_theme_*_override`
 * methods provided by this class.
 */
@GodotBaseType
public open class Control : CanvasItem() {
  /**
   * Emitted when the control changes size.
   */
  public val resized: Signal0 by Signal0

  /**
   * Emitted when the node receives an [InputEvent].
   */
  public val guiInput: Signal1<InputEvent> by Signal1

  /**
   * Emitted when the mouse cursor enters the control's (or any child control's) visible area, that
   * is not occluded behind other Controls or Windows, provided its [mouseFilter] lets the event reach
   * it and regardless if it's currently focused or not.
   *
   * **Note:** [CanvasItem.zIndex] doesn't affect, which Control receives the signal.
   */
  public val mouseEntered: Signal0 by Signal0

  /**
   * Emitted when the mouse cursor leaves the control's (and all child control's) visible area, that
   * is not occluded behind other Controls or Windows, provided its [mouseFilter] lets the event reach
   * it and regardless if it's currently focused or not.
   *
   * **Note:** [CanvasItem.zIndex] doesn't affect, which Control receives the signal.
   *
   * **Note:** If you want to check whether the mouse truly left the area, ignoring any top nodes,
   * you can use code like this:
   *
   * ```
   * func _on_mouse_exited():
   * 	if not Rect2(Vector2(), size).has_point(get_local_mouse_position()):
   * 		# Not hovering over area.
   * ```
   */
  public val mouseExited: Signal0 by Signal0

  /**
   * Emitted when the node gains focus.
   */
  public val focusEntered: Signal0 by Signal0

  /**
   * Emitted when the node loses focus.
   */
  public val focusExited: Signal0 by Signal0

  /**
   * Emitted when one of the size flags changes. See [sizeFlagsHorizontal] and [sizeFlagsVertical].
   */
  public val sizeFlagsChanged: Signal0 by Signal0

  /**
   * Emitted when the node's maximum size changes.
   */
  public val maximumSizeChanged: Signal0 by Signal0

  /**
   * Emitted when the node's minimum size changes.
   */
  public val minimumSizeChanged: Signal0 by Signal0

  /**
   * Emitted when the [NOTIFICATION_THEME_CHANGED] notification is sent.
   */
  public val themeChanged: Signal0 by Signal0

  /**
   * The minimum size of the node's bounding rectangle. If you set it to a value greater than `(0,
   * 0)`, the node's bounding rectangle will always have at least this size. Note that [Control] nodes
   * have their internal minimum size returned by [getMinimumSize]. It depends on the control's
   * contents, like text, textures, or style boxes. The actual minimum size is the maximum value of
   * this property and the internal minimum size (see [getCombinedMinimumSize]).
   *
   * **Note:** [customMaximumSize] has priority over this property. For example, if you set
   * [customMinimumSize] to `(200, 200)` and [customMaximumSize] to `(100, 100)`, the resulting size
   * will be `(100, 100)`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var customMinimumSize: Vector2
    @JvmName("customMinimumSizeProperty")
    get() = getCustomMinimumSize()
    @JvmName("customMinimumSizeProperty")
    set(`value`) {
      setCustomMinimumSize(value)
    }

  /**
   * The maximum size of this Control's bounding rectangle. If set to a value greater than or equal
   * to `(0, 0)`, the node's bounding rectangle will never exceed this size. A value below `(0, 0)`
   * means there is no maximum size.
   *
   * **Note:** The final effective maximum size may be subject to parent Container sizing and
   * propagated maximum sizes. See also: [getCombinedMaximumSize].
   *
   * **Note:** Not all [Control] subtypes handle a custom maximum size gracefully, which may lead to
   * unexpected behavior if the control's contents exceed this size.
   *
   * **Note:** This value has priority over [customMinimumSize]. For example, if you set
   * [customMaximumSize] to `(100, 100)` and [customMinimumSize] to `(200, 200)`, the resulting size
   * will be `(100, 100)`.
   *
   * **Note:** It is recommended to use [getBoundMinimumSize] instead of [getCombinedMinimumSize]
   * when using this property, as the former respects maximum size limits when calculating the minimum
   * size, while the latter does not.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var customMaximumSize: Vector2
    @JvmName("customMaximumSizeProperty")
    get() = getCustomMaximumSize()
    @JvmName("customMaximumSizeProperty")
    set(`value`) {
      setCustomMaximumSize(value)
    }

  /**
   * If `true`, this Control's children will use the value returned by [getCombinedMaximumSize] in
   * their own size calculations.
   */
  public final inline var propagateMaximumSize: Boolean
    @JvmName("propagateMaximumSizeProperty")
    get() = isPropagatingMaximumSize()
    @JvmName("propagateMaximumSizeProperty")
    set(`value`) {
      setPropagateMaximumSize(value)
    }

  /**
   * Enables whether rendering of [CanvasItem] based children should be clipped to this control's
   * rectangle. If `true`, parts of a child which would be visibly outside of this control's rectangle
   * will not be rendered and won't receive input.
   */
  public final inline var clipContents: Boolean
    @JvmName("clipContentsProperty")
    get() = isClippingContents()
    @JvmName("clipContentsProperty")
    set(`value`) {
      setClipContents(value)
    }

  /**
   * Anchors the left edge of the node to the origin, the center or the end of its parent control.
   * It changes how the left offset updates when the node moves or changes size. You can use one of the
   * [Anchor] constants for convenience.
   */
  public final inline val anchorLeft: Float
    @JvmName("anchorLeftProperty")
    get() = getAnchor(Side.LEFT)

  /**
   * Anchors the top edge of the node to the origin, the center or the end of its parent control. It
   * changes how the top offset updates when the node moves or changes size. You can use one of the
   * [Anchor] constants for convenience.
   */
  public final inline val anchorTop: Float
    @JvmName("anchorTopProperty")
    get() = getAnchor(Side.TOP)

  /**
   * Anchors the right edge of the node to the origin, the center or the end of its parent control.
   * It changes how the right offset updates when the node moves or changes size. You can use one of
   * the [Anchor] constants for convenience.
   */
  public final inline val anchorRight: Float
    @JvmName("anchorRightProperty")
    get() = getAnchor(Side.RIGHT)

  /**
   * Anchors the bottom edge of the node to the origin, the center, or the end of its parent
   * control. It changes how the bottom offset updates when the node moves or changes size. You can use
   * one of the [Anchor] constants for convenience.
   */
  public final inline val anchorBottom: Float
    @JvmName("anchorBottomProperty")
    get() = getAnchor(Side.BOTTOM)

  /**
   * Distance between the node's left edge and its parent control, based on [anchorLeft].
   *
   * Offsets are often controlled by one or multiple parent [Container] nodes, so you should not
   * modify them manually if your node is a direct child of a [Container]. Offsets update automatically
   * when you move or resize the node.
   */
  public final inline var offsetLeft: Float
    @JvmName("offsetLeftProperty")
    get() = getOffset(Side.LEFT)
    @JvmName("offsetLeftProperty")
    set(`value`) {
      setOffset(Side.LEFT, value)
    }

  /**
   * Distance between the node's top edge and its parent control, based on [anchorTop].
   *
   * Offsets are often controlled by one or multiple parent [Container] nodes, so you should not
   * modify them manually if your node is a direct child of a [Container]. Offsets update automatically
   * when you move or resize the node.
   */
  public final inline var offsetTop: Float
    @JvmName("offsetTopProperty")
    get() = getOffset(Side.TOP)
    @JvmName("offsetTopProperty")
    set(`value`) {
      setOffset(Side.TOP, value)
    }

  /**
   * Distance between the node's right edge and its parent control, based on [anchorRight].
   *
   * Offsets are often controlled by one or multiple parent [Container] nodes, so you should not
   * modify them manually if your node is a direct child of a [Container]. Offsets update automatically
   * when you move or resize the node.
   */
  public final inline var offsetRight: Float
    @JvmName("offsetRightProperty")
    get() = getOffset(Side.RIGHT)
    @JvmName("offsetRightProperty")
    set(`value`) {
      setOffset(Side.RIGHT, value)
    }

  /**
   * Distance between the node's bottom edge and its parent control, based on [anchorBottom].
   *
   * Offsets are often controlled by one or multiple parent [Container] nodes, so you should not
   * modify them manually if your node is a direct child of a [Container]. Offsets update automatically
   * when you move or resize the node.
   */
  public final inline var offsetBottom: Float
    @JvmName("offsetBottomProperty")
    get() = getOffset(Side.BOTTOM)
    @JvmName("offsetBottomProperty")
    set(`value`) {
      setOffset(Side.BOTTOM, value)
    }

  /**
   * Controls the direction on the horizontal axis in which the control should grow if its
   * horizontal minimum size is changed to be greater than its current size, as the control always has
   * to be at least the minimum size.
   */
  public final inline var growHorizontal: GrowDirection
    @JvmName("growHorizontalProperty")
    get() = getHGrowDirection()
    @JvmName("growHorizontalProperty")
    set(`value`) {
      setHGrowDirection(value)
    }

  /**
   * Controls the direction on the vertical axis in which the control should grow if its vertical
   * minimum size is changed to be greater than its current size, as the control always has to be at
   * least the minimum size.
   */
  public final inline var growVertical: GrowDirection
    @JvmName("growVerticalProperty")
    get() = getVGrowDirection()
    @JvmName("growVerticalProperty")
    set(`value`) {
      setVGrowDirection(value)
    }

  /**
   * The size of the node's bounding rectangle, in the node's coordinate system. [Container] nodes
   * update this property automatically.
   */
  public final inline val size: Vector2
    @JvmName("sizeProperty")
    get() = getSize()

  /**
   * The node's position, relative to its containing node. It corresponds to the rectangle's
   * top-left corner. The property is not affected by [pivotOffset].
   */
  public final inline val position: Vector2
    @JvmName("positionProperty")
    get() = getPosition()

  /**
   * The node's global position, relative to the world (usually to the [CanvasLayer]).
   */
  public final inline val globalPosition: Vector2
    @JvmName("globalPositionProperty")
    get() = getGlobalPosition()

  /**
   * The node's rotation around its pivot, in radians. See [pivotOffset] to change the pivot's
   * position.
   *
   * **Note:** This property is edited in the inspector in degrees. If you want to use degrees in a
   * script, use [rotationDegrees].
   */
  public final inline var rotation: Float
    @JvmName("rotationProperty")
    get() = getRotation()
    @JvmName("rotationProperty")
    set(`value`) {
      setRotation(value)
    }

  /**
   * Helper property to access [rotation] in degrees instead of radians.
   */
  public final inline var rotationDegrees: Float
    @JvmName("rotationDegreesProperty")
    get() = getRotationDegrees()
    @JvmName("rotationDegreesProperty")
    set(`value`) {
      setRotationDegrees(value)
    }

  /**
   * The node's scale, relative to its [size]. Change this property to scale the node around its
   * [pivotOffset]. The Control's tooltip will also scale according to this value.
   *
   * **Note:** This property is mainly intended to be used for animation purposes. To support
   * multiple resolutions in your project, use an appropriate viewport stretch mode as described in the
   * [url=$DOCS_URL/tutorials/rendering/multiple_resolutions.html]documentation[/url] instead of
   * scaling Controls individually.
   *
   * **Note:** [FontFile.oversampling] does *not* take [Control] [scale] into account. This means
   * that scaling up/down will cause bitmap fonts and rasterized (non-MSDF) dynamic fonts to appear
   * blurry or pixelated. To ensure text remains crisp regardless of scale, you can enable MSDF font
   * rendering by enabling [ProjectSettings.gui/theme/defaultFontMultichannelSignedDistanceField]
   * (applies to the default project font only), or enabling **Multichannel Signed Distance Field** in
   * the import options of a DynamicFont for custom fonts. On system fonts,
   * [SystemFont.multichannelSignedDistanceField] can be enabled in the inspector.
   *
   * **Note:** If the Control node is a child of a [Container] node, the scale will be reset to
   * `Vector2(1, 1)` when the scene is instantiated. To set the Control's scale when it's instantiated,
   * wait for one frame using `await get_tree().process_frame` then set its [scale] property.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scale: Vector2
    @JvmName("scaleProperty")
    get() = getScale()
    @JvmName("scaleProperty")
    set(`value`) {
      setScale(value)
    }

  /**
   * By default, the node's pivot is its top-left corner. When you change its [rotation] or [scale],
   * it will rotate or scale around this pivot.
   *
   * The actual offset is the combined value of this property and [pivotOffsetRatio].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var pivotOffset: Vector2
    @JvmName("pivotOffsetProperty")
    get() = getPivotOffset()
    @JvmName("pivotOffsetProperty")
    set(`value`) {
      setPivotOffset(value)
    }

  /**
   * Same as [pivotOffset], but expressed as uniform vector, where `Vector2(0, 0)` is the top-left
   * corner of this control, and `Vector2(1, 1)` is its bottom-right corner. Set this property to
   * `Vector2(0.5, 0.5)` to pivot around this control's center.
   *
   * The actual offset is the combined value of this property and [pivotOffset].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var pivotOffsetRatio: Vector2
    @JvmName("pivotOffsetRatioProperty")
    get() = getPivotOffsetRatio()
    @JvmName("pivotOffsetRatioProperty")
    set(`value`) {
      setPivotOffsetRatio(value)
    }

  /**
   * Tells the parent [Container] nodes how they should resize and place the node on the X axis. Use
   * a combination of the [SizeFlags] constants to change the flags. See the constants to learn what
   * each does.
   */
  public final inline var sizeFlagsHorizontal: SizeFlags
    @JvmName("sizeFlagsHorizontalProperty")
    get() = getHSizeFlags()
    @JvmName("sizeFlagsHorizontalProperty")
    set(`value`) {
      setHSizeFlags(value)
    }

  /**
   * Tells the parent [Container] nodes how they should resize and place the node on the Y axis. Use
   * a combination of the [SizeFlags] constants to change the flags. See the constants to learn what
   * each does.
   */
  public final inline var sizeFlagsVertical: SizeFlags
    @JvmName("sizeFlagsVerticalProperty")
    get() = getVSizeFlags()
    @JvmName("sizeFlagsVerticalProperty")
    set(`value`) {
      setVSizeFlags(value)
    }

  /**
   * If the node and at least one of its neighbors uses the [SIZE_EXPAND] size flag, the parent
   * [Container] will let it take more or less space depending on this property. If this node has a
   * stretch ratio of 2 and its neighbor a ratio of 1, this node will take two thirds of the available
   * space.
   */
  public final inline var sizeFlagsStretchRatio: Float
    @JvmName("sizeFlagsStretchRatioProperty")
    get() = getStretchRatio()
    @JvmName("sizeFlagsStretchRatioProperty")
    set(`value`) {
      setStretchRatio(value)
    }

  /**
   * If `true`, applies all offset transform properties. Otherwise, no offset transform is applied
   * and the properties have no effect.
   */
  public final inline var offsetTransformEnabled: Boolean
    @JvmName("offsetTransformEnabledProperty")
    get() = isOffsetTransformEnabled()
    @JvmName("offsetTransformEnabledProperty")
    set(`value`) {
      setOffsetTransformEnabled(value)
    }

  /**
   * Position offset in absolute units. The final offset is the combined value of this property and
   * [offsetTransformPositionRatio].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offsetTransformPosition: Vector2
    @JvmName("offsetTransformPositionProperty")
    get() = getOffsetTransformPosition()
    @JvmName("offsetTransformPositionProperty")
    set(`value`) {
      setOffsetTransformPosition(value)
    }

  /**
   * Same as [offsetTransformPosition] but expressed in units relative to the [Control] [size] where
   * `Vector2(0, 0)` is the top-left corner of this control, and `Vector2(1, 1)` is its bottom-right
   * corner.
   *
   * The final offset is the combined value of this property and [offsetTransformPosition].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offsetTransformPositionRatio: Vector2
    @JvmName("offsetTransformPositionRatioProperty")
    get() = getOffsetTransformPositionRatio()
    @JvmName("offsetTransformPositionRatioProperty")
    set(`value`) {
      setOffsetTransformPositionRatio(value)
    }

  /**
   * Scale offset. The scale pivot is defined by [offsetTransformPivot] and
   * [offsetTransformPivotRatio].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offsetTransformScale: Vector2
    @JvmName("offsetTransformScaleProperty")
    get() = getOffsetTransformScale()
    @JvmName("offsetTransformScaleProperty")
    set(`value`) {
      setOffsetTransformScale(value)
    }

  /**
   * Rotation offset. The rotation pivot is defined by [offsetTransformPivot] and
   * [offsetTransformPivotRatio].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   */
  public final inline var offsetTransformRotation: Float
    @JvmName("offsetTransformRotationProperty")
    get() = getOffsetTransformRotation()
    @JvmName("offsetTransformRotationProperty")
    set(`value`) {
      setOffsetTransformRotation(value)
    }

  /**
   * Pivot used by [offsetTransformRotation] and [offsetTransformScale] in absolute units.
   *
   * The final pivot position is the combined value of this property and
   * [offsetTransformPivotRatio].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offsetTransformPivot: Vector2
    @JvmName("offsetTransformPivotProperty")
    get() = getOffsetTransformPivot()
    @JvmName("offsetTransformPivotProperty")
    set(`value`) {
      setOffsetTransformPivot(value)
    }

  /**
   * Same as [offsetTransformPivot] but expressed in units relative to the [Control] [size] where
   * `Vector2(0, 0)` is the top-left corner of this control, and `Vector2(1, 1)` is its bottom-right
   * corner.
   *
   * The final pivot position is the combined value of this property and [offsetTransformPivot].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offsetTransformPivotRatio: Vector2
    @JvmName("offsetTransformPivotRatioProperty")
    get() = getOffsetTransformPivotRatio()
    @JvmName("offsetTransformPivotRatioProperty")
    set(`value`) {
      setOffsetTransformPivotRatio(value)
    }

  /**
   * If `true`, the offset transforms is only applied visually and does not affect input. In other
   * words, this Control will still receive input events at its original location before the offset
   * transform is applied.
   *
   * If `false`, the entire transform of this Control is affected and input events will register
   * where the Control is visually.
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   */
  public final inline var offsetTransformVisualOnly: Boolean
    @JvmName("offsetTransformVisualOnlyProperty")
    get() = isOffsetTransformVisualOnly()
    @JvmName("offsetTransformVisualOnlyProperty")
    set(`value`) {
      setOffsetTransformVisualOnly(value)
    }

  /**
   * If `true`, automatically converts code line numbers, list indices, [SpinBox] and [ProgressBar]
   * values from the Western Arabic (0..9) to the numeral systems used in current locale.
   *
   * **Note:** Numbers within the text are not automatically converted, it can be done manually,
   * using [TextServer.formatNumber].
   */
  public final inline var localizeNumeralSystem: Boolean
    @JvmName("localizeNumeralSystemProperty")
    get() = isLocalizingNumeralSystem()
    @JvmName("localizeNumeralSystemProperty")
    set(`value`) {
      setLocalizeNumeralSystem(value)
    }

  /**
   * Controls layout direction and text writing direction. Right-to-left layouts are necessary for
   * certain languages (e.g. Arabic and Hebrew). See also [isLayoutRtl].
   */
  public final inline var layoutDirection: LayoutDirection
    @JvmName("layoutDirectionProperty")
    get() = getLayoutDirection()
    @JvmName("layoutDirectionProperty")
    set(`value`) {
      setLayoutDirection(value)
    }

  /**
   * The translation context used when translating this control's displayed text, if it has any.
   * Also used when generating translation templates.
   */
  public final inline var translationContext: StringName
    @JvmName("translationContextProperty")
    get() = getTranslationContext()
    @JvmName("translationContextProperty")
    set(`value`) {
      setTranslationContext(value)
    }

  /**
   * Toggles if any text should automatically change to its translated version depending on the
   * current locale.
   */
  public final inline var autoTranslate: Boolean
    @JvmName("autoTranslateProperty")
    get() = isAutoTranslating()
    @JvmName("autoTranslateProperty")
    set(`value`) {
      setAutoTranslate(value)
    }

  /**
   * The default tooltip text. The tooltip appears when the user's mouse cursor stays idle over this
   * control for a few moments, provided that the [mouseFilter] property is not [MOUSE_FILTER_IGNORE].
   * The time required for the tooltip to appear can be changed with the
   * [ProjectSettings.gui/timers/tooltipDelaySec] setting.
   *
   * This string is the default return value of [getTooltip]. Override [_getTooltip] to generate
   * tooltip text dynamically. Override [_makeCustomTooltip] to customize the tooltip interface and
   * behavior.
   *
   * The tooltip popup will use either a default implementation, or a custom one that you can
   * provide by overriding [_makeCustomTooltip]. The default tooltip includes a [PopupPanel] and
   * [Label] whose theme properties can be customized using [Theme] methods with the `"TooltipPanel"`
   * and `"TooltipLabel"` respectively. For example:
   *
   * ```gdscript
   * //gdscript
   * var style_box = StyleBoxFlat.new()
   * style_box.set_bg_color(Color(1, 1, 0))
   * style_box.set_border_width_all(2)
   * # We assume here that the `theme` property has been assigned a custom Theme beforehand.
   * theme.set_stylebox("panel", "TooltipPanel", style_box)
   * theme.set_color("font_color", "TooltipLabel", Color(0, 1, 1))
   * ```
   *
   * ```csharp
   * //csharp
   * var styleBox = new StyleBoxFlat();
   * styleBox.SetBgColor(new Color(1, 1, 0));
   * styleBox.SetBorderWidthAll(2);
   * // We assume here that the `Theme` property has been assigned a custom Theme beforehand.
   * Theme.SetStyleBox("panel", "TooltipPanel", styleBox);
   * Theme.SetColor("font_color", "TooltipLabel", new Color(0, 1, 1));
   * ```
   */
  public final inline var tooltipText: String
    @JvmName("tooltipTextProperty")
    get() = getTooltipText()
    @JvmName("tooltipTextProperty")
    set(`value`) {
      setTooltipText(value)
    }

  /**
   * Defines if tooltip text should automatically change to its translated version depending on the
   * current locale. Uses the same auto translate mode as this control when set to
   * [Node.AUTO_TRANSLATE_MODE_INHERIT].
   *
   * **Note:** Tooltips customized using [_makeCustomTooltip] do not use this auto translate mode
   * automatically.
   */
  public final inline var tooltipAutoTranslateMode: Node.AutoTranslateMode
    @JvmName("tooltipAutoTranslateModeProperty")
    get() = getTooltipAutoTranslateMode()
    @JvmName("tooltipAutoTranslateModeProperty")
    set(`value`) {
      setTooltipAutoTranslateMode(value)
    }

  /**
   * Tells Godot which node it should give focus to if the user presses the left arrow on the
   * keyboard or left on a gamepad by default. You can change the key by editing the
   * [ProjectSettings.input/uiLeft] input action. The node must be a [Control]. If this property is not
   * set, Godot will give focus to the closest [Control] to the left of this one.
   */
  public final inline var focusNeighborLeft: NodePath
    @JvmName("focusNeighborLeftProperty")
    get() = getFocusNeighbor(Side.LEFT)
    @JvmName("focusNeighborLeftProperty")
    set(`value`) {
      setFocusNeighbor(Side.LEFT, value)
    }

  /**
   * Tells Godot which node it should give focus to if the user presses the top arrow on the
   * keyboard or top on a gamepad by default. You can change the key by editing the
   * [ProjectSettings.input/uiUp] input action. The node must be a [Control]. If this property is not
   * set, Godot will give focus to the closest [Control] to the top of this one.
   */
  public final inline var focusNeighborTop: NodePath
    @JvmName("focusNeighborTopProperty")
    get() = getFocusNeighbor(Side.TOP)
    @JvmName("focusNeighborTopProperty")
    set(`value`) {
      setFocusNeighbor(Side.TOP, value)
    }

  /**
   * Tells Godot which node it should give focus to if the user presses the right arrow on the
   * keyboard or right on a gamepad by default. You can change the key by editing the
   * [ProjectSettings.input/uiRight] input action. The node must be a [Control]. If this property is
   * not set, Godot will give focus to the closest [Control] to the right of this one.
   */
  public final inline var focusNeighborRight: NodePath
    @JvmName("focusNeighborRightProperty")
    get() = getFocusNeighbor(Side.RIGHT)
    @JvmName("focusNeighborRightProperty")
    set(`value`) {
      setFocusNeighbor(Side.RIGHT, value)
    }

  /**
   * Tells Godot which node it should give focus to if the user presses the down arrow on the
   * keyboard or down on a gamepad by default. You can change the key by editing the
   * [ProjectSettings.input/uiDown] input action. The node must be a [Control]. If this property is not
   * set, Godot will give focus to the closest [Control] to the bottom of this one.
   */
  public final inline var focusNeighborBottom: NodePath
    @JvmName("focusNeighborBottomProperty")
    get() = getFocusNeighbor(Side.BOTTOM)
    @JvmName("focusNeighborBottomProperty")
    set(`value`) {
      setFocusNeighbor(Side.BOTTOM, value)
    }

  /**
   * Tells Godot which node it should give focus to if the user presses [kbd]Tab[/kbd] on a keyboard
   * by default. You can change the key by editing the [ProjectSettings.input/uiFocusNext] input
   * action.
   *
   * If this property is not set, Godot will select a "best guess" based on surrounding nodes in the
   * scene tree.
   */
  public final inline var focusNext: NodePath
    @JvmName("focusNextProperty")
    get() = getFocusNext()
    @JvmName("focusNextProperty")
    set(`value`) {
      setFocusNext(value)
    }

  /**
   * Tells Godot which node it should give focus to if the user presses [kbd]Shift + Tab[/kbd] on a
   * keyboard by default. You can change the key by editing the [ProjectSettings.input/uiFocusPrev]
   * input action.
   *
   * If this property is not set, Godot will select a "best guess" based on surrounding nodes in the
   * scene tree.
   */
  public final inline var focusPrevious: NodePath
    @JvmName("focusPreviousProperty")
    get() = getFocusPrevious()
    @JvmName("focusPreviousProperty")
    set(`value`) {
      setFocusPrevious(value)
    }

  /**
   * Determines which controls can be focused. Only one control can be focused at a time, and the
   * focused control will receive keyboard, gamepad, and mouse events in [_guiInput]. Use
   * [getFocusModeWithOverride] to determine if a control can grab focus, since
   * [focusBehaviorRecursive] also affects it. See also [grabFocus].
   */
  public final inline var focusMode: FocusMode
    @JvmName("focusModeProperty")
    get() = getFocusMode()
    @JvmName("focusModeProperty")
    set(`value`) {
      setFocusMode(value)
    }

  /**
   * Determines which controls can be focused together with [focusMode]. See
   * [getFocusModeWithOverride]. Since the default behavior is [FOCUS_BEHAVIOR_INHERITED], this can be
   * used to prevent all children controls from getting focused.
   */
  public final inline var focusBehaviorRecursive: FocusBehaviorRecursive
    @JvmName("focusBehaviorRecursiveProperty")
    get() = getFocusBehaviorRecursive()
    @JvmName("focusBehaviorRecursiveProperty")
    set(`value`) {
      setFocusBehaviorRecursive(value)
    }

  /**
   * Determines which controls will be able to receive mouse button input events through [_guiInput]
   * and the [signal mouse_entered], and [signal mouse_exited] signals. Also determines how these
   * events should be propagated. See the constants to learn what each does. Use
   * [getMouseFilterWithOverride] to determine if a control can receive mouse input, since
   * [mouseBehaviorRecursive] also affects it.
   */
  public final inline var mouseFilter: MouseFilter
    @JvmName("mouseFilterProperty")
    get() = getMouseFilter()
    @JvmName("mouseFilterProperty")
    set(`value`) {
      setMouseFilter(value)
    }

  /**
   * Determines which controls can receive mouse input together with [mouseFilter]. See
   * [getMouseFilterWithOverride]. Since the default behavior is [MOUSE_BEHAVIOR_INHERITED], this can
   * be used to prevent all children controls from receiving mouse input.
   */
  public final inline var mouseBehaviorRecursive: MouseBehaviorRecursive
    @JvmName("mouseBehaviorRecursiveProperty")
    get() = getMouseBehaviorRecursive()
    @JvmName("mouseBehaviorRecursiveProperty")
    set(`value`) {
      setMouseBehaviorRecursive(value)
    }

  /**
   * When enabled, scroll wheel events processed by [_guiInput] will be passed to the parent control
   * even if [mouseFilter] is set to [MOUSE_FILTER_STOP].
   *
   * You should disable it on the root of your UI if you do not want scroll events to go to the
   * [Node.UnhandledInput] processing.
   *
   * **Note:** Because this property defaults to `true`, this allows nested scrollable containers to
   * work out of the box.
   */
  public final inline var mouseForcePassScrollEvents: Boolean
    @JvmName("mouseForcePassScrollEventsProperty")
    get() = isForcePassScrollEvents()
    @JvmName("mouseForcePassScrollEventsProperty")
    set(`value`) {
      setForcePassScrollEvents(value)
    }

  /**
   * The default cursor shape for this control. Useful for Godot plugins and applications or games
   * that use the system's mouse cursors.
   *
   * **Note:** On Linux, shapes may vary depending on the cursor theme of the system.
   */
  public final inline var mouseDefaultCursorShape: CursorShape
    @JvmName("mouseDefaultCursorShapeProperty")
    get() = getDefaultCursorShape()
    @JvmName("mouseDefaultCursorShapeProperty")
    set(`value`) {
      setDefaultCursorShape(value)
    }

  /**
   * The [Node] which must be a parent of the focused [Control] for the shortcut to be activated. If
   * `null`, the shortcut can be activated when any control is focused (a global shortcut). This allows
   * shortcuts to be accepted only when the user has a certain area of the GUI focused.
   */
  public final inline var shortcutContext: Node?
    @JvmName("shortcutContextProperty")
    get() = getShortcutContext()
    @JvmName("shortcutContextProperty")
    set(`value`) {
      setShortcutContext(value)
    }

  /**
   * The human-readable node name that is reported to assistive apps.
   */
  public final inline var accessibilityName: String
    @JvmName("accessibilityNameProperty")
    get() = getAccessibilityName()
    @JvmName("accessibilityNameProperty")
    set(`value`) {
      setAccessibilityName(value)
    }

  /**
   * The human-readable node description that is reported to assistive apps.
   */
  public final inline var accessibilityDescription: String
    @JvmName("accessibilityDescriptionProperty")
    get() = getAccessibilityDescription()
    @JvmName("accessibilityDescriptionProperty")
    set(`value`) {
      setAccessibilityDescription(value)
    }

  /**
   * The mode with which a live region updates. A live region is a [Node] that is updated as a
   * result of an external event when the user's focus may be elsewhere.
   */
  public final inline var accessibilityLive: AccessibilityServer.AccessibilityLiveMode
    @JvmName("accessibilityLiveProperty")
    get() = getAccessibilityLive()
    @JvmName("accessibilityLiveProperty")
    set(`value`) {
      setAccessibilityLive(value)
    }

  /**
   * The paths to the nodes which are controlled by this node.
   */
  public final inline var accessibilityControlsNodes: VariantArray<NodePath>
    @JvmName("accessibilityControlsNodesProperty")
    get() = getAccessibilityControlsNodes()
    @JvmName("accessibilityControlsNodesProperty")
    set(`value`) {
      setAccessibilityControlsNodes(value)
    }

  /**
   * The paths to the nodes which are describing this node.
   */
  public final inline var accessibilityDescribedByNodes: VariantArray<NodePath>
    @JvmName("accessibilityDescribedByNodesProperty")
    get() = getAccessibilityDescribedByNodes()
    @JvmName("accessibilityDescribedByNodesProperty")
    set(`value`) {
      setAccessibilityDescribedByNodes(value)
    }

  /**
   * The paths to the nodes which label this node.
   */
  public final inline var accessibilityLabeledByNodes: VariantArray<NodePath>
    @JvmName("accessibilityLabeledByNodesProperty")
    get() = getAccessibilityLabeledByNodes()
    @JvmName("accessibilityLabeledByNodesProperty")
    set(`value`) {
      setAccessibilityLabeledByNodes(value)
    }

  /**
   * The paths to the nodes which this node flows into.
   */
  public final inline var accessibilityFlowToNodes: VariantArray<NodePath>
    @JvmName("accessibilityFlowToNodesProperty")
    get() = getAccessibilityFlowToNodes()
    @JvmName("accessibilityFlowToNodesProperty")
    set(`value`) {
      setAccessibilityFlowToNodes(value)
    }

  /**
   * The [Theme] resource this node and all its [Control] and [Window] children use. If a child node
   * has its own [Theme] resource set, theme items are merged with child's definitions having higher
   * priority.
   *
   * **Note:** [Window] styles will have no effect unless the window is embedded.
   */
  public final inline var theme: Theme?
    @JvmName("themeProperty")
    get() = getTheme()
    @JvmName("themeProperty")
    set(`value`) {
      setTheme(value)
    }

  /**
   * The name of a theme type variation used by this [Control] to look up its own theme items. When
   * empty, the class name of the node is used (e.g. [code skip-lint]Button[/code] for the [Button]
   * control), as well as the class names of all parent classes (in order of inheritance).
   *
   * When set, this property gives the highest priority to the type of the specified name. This type
   * can in turn extend another type, forming a dependency chain. See [Theme.setTypeVariation]. If the
   * theme item cannot be found using this type or its base types, lookup falls back on the class
   * names.
   *
   * **Note:** To look up [Control]'s own items use various `get_theme_*` methods without specifying
   * `theme_type`.
   *
   * **Note:** Theme items are looked for in the tree order, from branch to root, where each
   * [Control] node is checked for its [theme] property. The earliest match against any type/class name
   * is returned. The project-level Theme and the default Theme are checked last.
   */
  public final inline var themeTypeVariation: StringName
    @JvmName("themeTypeVariationProperty")
    get() = getThemeTypeVariation()
    @JvmName("themeTypeVariationProperty")
    set(`value`) {
      setThemeTypeVariation(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(187, scriptPtr)
  }

  /**
   * This is a helper function for [customMinimumSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.customMinimumSize
   * //Your changes
   * control.customMinimumSize = myCoreType
   * ``````
   *
   * The minimum size of the node's bounding rectangle. If you set it to a value greater than `(0,
   * 0)`, the node's bounding rectangle will always have at least this size. Note that [Control] nodes
   * have their internal minimum size returned by [getMinimumSize]. It depends on the control's
   * contents, like text, textures, or style boxes. The actual minimum size is the maximum value of
   * this property and the internal minimum size (see [getCombinedMinimumSize]).
   *
   * **Note:** [customMaximumSize] has priority over this property. For example, if you set
   * [customMinimumSize] to `(200, 200)` and [customMaximumSize] to `(100, 100)`, the resulting size
   * will be `(100, 100)`.
   */
  @CoreTypeHelper
  public final fun customMinimumSizeMutate(block: Vector2.() -> Unit): Vector2 =
      customMinimumSize.apply {
     block(this)
     customMinimumSize = this
  }

  /**
   * This is a helper function for [customMaximumSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.customMaximumSize
   * //Your changes
   * control.customMaximumSize = myCoreType
   * ``````
   *
   * The maximum size of this Control's bounding rectangle. If set to a value greater than or equal
   * to `(0, 0)`, the node's bounding rectangle will never exceed this size. A value below `(0, 0)`
   * means there is no maximum size.
   *
   * **Note:** The final effective maximum size may be subject to parent Container sizing and
   * propagated maximum sizes. See also: [getCombinedMaximumSize].
   *
   * **Note:** Not all [Control] subtypes handle a custom maximum size gracefully, which may lead to
   * unexpected behavior if the control's contents exceed this size.
   *
   * **Note:** This value has priority over [customMinimumSize]. For example, if you set
   * [customMaximumSize] to `(100, 100)` and [customMinimumSize] to `(200, 200)`, the resulting size
   * will be `(100, 100)`.
   *
   * **Note:** It is recommended to use [getBoundMinimumSize] instead of [getCombinedMinimumSize]
   * when using this property, as the former respects maximum size limits when calculating the minimum
   * size, while the latter does not.
   */
  @CoreTypeHelper
  public final fun customMaximumSizeMutate(block: Vector2.() -> Unit): Vector2 =
      customMaximumSize.apply {
     block(this)
     customMaximumSize = this
  }

  /**
   * This is a helper function for [scale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.scale
   * //Your changes
   * control.scale = myCoreType
   * ``````
   *
   * The node's scale, relative to its [size]. Change this property to scale the node around its
   * [pivotOffset]. The Control's tooltip will also scale according to this value.
   *
   * **Note:** This property is mainly intended to be used for animation purposes. To support
   * multiple resolutions in your project, use an appropriate viewport stretch mode as described in the
   * [url=$DOCS_URL/tutorials/rendering/multiple_resolutions.html]documentation[/url] instead of
   * scaling Controls individually.
   *
   * **Note:** [FontFile.oversampling] does *not* take [Control] [scale] into account. This means
   * that scaling up/down will cause bitmap fonts and rasterized (non-MSDF) dynamic fonts to appear
   * blurry or pixelated. To ensure text remains crisp regardless of scale, you can enable MSDF font
   * rendering by enabling [ProjectSettings.gui/theme/defaultFontMultichannelSignedDistanceField]
   * (applies to the default project font only), or enabling **Multichannel Signed Distance Field** in
   * the import options of a DynamicFont for custom fonts. On system fonts,
   * [SystemFont.multichannelSignedDistanceField] can be enabled in the inspector.
   *
   * **Note:** If the Control node is a child of a [Container] node, the scale will be reset to
   * `Vector2(1, 1)` when the scene is instantiated. To set the Control's scale when it's instantiated,
   * wait for one frame using `await get_tree().process_frame` then set its [scale] property.
   */
  @CoreTypeHelper
  public final fun scaleMutate(block: Vector2.() -> Unit): Vector2 = scale.apply {
     block(this)
     scale = this
  }

  /**
   * This is a helper function for [pivotOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.pivotOffset
   * //Your changes
   * control.pivotOffset = myCoreType
   * ``````
   *
   * By default, the node's pivot is its top-left corner. When you change its [rotation] or [scale],
   * it will rotate or scale around this pivot.
   *
   * The actual offset is the combined value of this property and [pivotOffsetRatio].
   */
  @CoreTypeHelper
  public final fun pivotOffsetMutate(block: Vector2.() -> Unit): Vector2 = pivotOffset.apply {
     block(this)
     pivotOffset = this
  }

  /**
   * This is a helper function for [pivotOffsetRatio] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.pivotOffsetRatio
   * //Your changes
   * control.pivotOffsetRatio = myCoreType
   * ``````
   *
   * Same as [pivotOffset], but expressed as uniform vector, where `Vector2(0, 0)` is the top-left
   * corner of this control, and `Vector2(1, 1)` is its bottom-right corner. Set this property to
   * `Vector2(0.5, 0.5)` to pivot around this control's center.
   *
   * The actual offset is the combined value of this property and [pivotOffset].
   */
  @CoreTypeHelper
  public final fun pivotOffsetRatioMutate(block: Vector2.() -> Unit): Vector2 =
      pivotOffsetRatio.apply {
     block(this)
     pivotOffsetRatio = this
  }

  /**
   * This is a helper function for [offsetTransformPosition] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.offsetTransformPosition
   * //Your changes
   * control.offsetTransformPosition = myCoreType
   * ``````
   *
   * Position offset in absolute units. The final offset is the combined value of this property and
   * [offsetTransformPositionRatio].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   */
  @CoreTypeHelper
  public final fun offsetTransformPositionMutate(block: Vector2.() -> Unit): Vector2 =
      offsetTransformPosition.apply {
     block(this)
     offsetTransformPosition = this
  }

  /**
   * This is a helper function for [offsetTransformPositionRatio] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.offsetTransformPositionRatio
   * //Your changes
   * control.offsetTransformPositionRatio = myCoreType
   * ``````
   *
   * Same as [offsetTransformPosition] but expressed in units relative to the [Control] [size] where
   * `Vector2(0, 0)` is the top-left corner of this control, and `Vector2(1, 1)` is its bottom-right
   * corner.
   *
   * The final offset is the combined value of this property and [offsetTransformPosition].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   */
  @CoreTypeHelper
  public final fun offsetTransformPositionRatioMutate(block: Vector2.() -> Unit): Vector2 =
      offsetTransformPositionRatio.apply {
     block(this)
     offsetTransformPositionRatio = this
  }

  /**
   * This is a helper function for [offsetTransformScale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.offsetTransformScale
   * //Your changes
   * control.offsetTransformScale = myCoreType
   * ``````
   *
   * Scale offset. The scale pivot is defined by [offsetTransformPivot] and
   * [offsetTransformPivotRatio].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   */
  @CoreTypeHelper
  public final fun offsetTransformScaleMutate(block: Vector2.() -> Unit): Vector2 =
      offsetTransformScale.apply {
     block(this)
     offsetTransformScale = this
  }

  /**
   * This is a helper function for [offsetTransformPivot] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.offsetTransformPivot
   * //Your changes
   * control.offsetTransformPivot = myCoreType
   * ``````
   *
   * Pivot used by [offsetTransformRotation] and [offsetTransformScale] in absolute units.
   *
   * The final pivot position is the combined value of this property and
   * [offsetTransformPivotRatio].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   */
  @CoreTypeHelper
  public final fun offsetTransformPivotMutate(block: Vector2.() -> Unit): Vector2 =
      offsetTransformPivot.apply {
     block(this)
     offsetTransformPivot = this
  }

  /**
   * This is a helper function for [offsetTransformPivotRatio] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = control.offsetTransformPivotRatio
   * //Your changes
   * control.offsetTransformPivotRatio = myCoreType
   * ``````
   *
   * Same as [offsetTransformPivot] but expressed in units relative to the [Control] [size] where
   * `Vector2(0, 0)` is the top-left corner of this control, and `Vector2(1, 1)` is its bottom-right
   * corner.
   *
   * The final pivot position is the combined value of this property and [offsetTransformPivot].
   *
   * Has no effect unless [offsetTransformEnabled] is `true`.
   */
  @CoreTypeHelper
  public final fun offsetTransformPivotRatioMutate(block: Vector2.() -> Unit): Vector2 =
      offsetTransformPivotRatio.apply {
     block(this)
     offsetTransformPivotRatio = this
  }

  /**
   * Virtual method to be implemented by the user. Returns whether the given [point] is inside this
   * control.
   *
   * If not overridden, default behavior is checking if the point is within the control's Rect.
   *
   * **Note:** If you want to check if a point is inside the control, you can use
   * `Rect2(Vector2.ZERO, size).has_point(point)`.
   */
  public open fun _hasPoint(point: Vector2): Boolean {
    throw NotImplementedError("Control::_hasPoint is not implemented.")
  }

  /**
   * User defined BiDi algorithm override function.
   *
   * Returns an [Array] of [Vector3i] text ranges and text base directions, in the left-to-right
   * order. Ranges should cover full source [text] without overlaps. BiDi algorithm will be used on
   * each range separately.
   */
  public open fun _structuredTextParser(args: VariantArray<Any?>, text: String):
      VariantArray<Vector3i> {
    throw NotImplementedError("Control::_structuredTextParser is not implemented.")
  }

  /**
   * Virtual method to be implemented by the user. Returns the maximum size for this control.
   * Alternative to [customMaximumSize] for controlling maximum size via code. The actual maximum size
   * will be the max value of these two (in each axis separately).
   *
   * If not overridden, defaults to [Vector2.ZERO].
   *
   * **Note:** This method will not be called when the script is attached to a [Control] node that
   * already overrides its maximum size (e.g. [ScrollContainer]).
   *
   * **Note:** It is recommended to use [getBoundMinimumSize] instead of [getCombinedMinimumSize]
   * when implementing this method, as the former respects maximum size limits when calculating the
   * minimum size, while the latter does not.
   */
  public open fun _getMaximumSize(): Vector2 {
    throw NotImplementedError("Control::_getMaximumSize is not implemented.")
  }

  /**
   * Virtual method to be implemented by the user. Returns the minimum size for this control.
   * Alternative to [customMinimumSize] for controlling minimum size via code. The actual minimum size
   * will be the max value of these two (in each axis separately).
   *
   * If not overridden, defaults to [Vector2.ZERO].
   *
   * **Note:** This method will not be called when the script is attached to a [Control] node that
   * already overrides its minimum size (e.g. [Label], [Button], [PanelContainer] etc.). It can only be
   * used with most basic GUI nodes, like [Control], [Container], [Panel] etc.
   */
  public open fun _getMinimumSize(): Vector2 {
    throw NotImplementedError("Control::_getMinimumSize is not implemented.")
  }

  /**
   * Virtual method to be implemented by the user. Returns the tooltip text for the position
   * [atPosition] in the control's local coordinates, which will typically appear when the cursor is
   * resting over this control. See [getTooltip].
   *
   * **Note:** If this method returns an empty [String] and [_makeCustomTooltip] is not overridden,
   * no tooltip is displayed.
   */
  public open fun _getTooltip(atPosition: Vector2): String {
    throw NotImplementedError("Control::_getTooltip is not implemented.")
  }

  /**
   * Return the auto-translation mode at the given [atPosition]. If not implemented, the
   * [tooltipAutoTranslateMode] property will be used instead.
   */
  public open fun _getTooltipAutoTranslateModeAt(atPosition: Vector2): Node.AutoTranslateMode {
    throw NotImplementedError("Control::_getTooltipAutoTranslateModeAt is not implemented.")
  }

  /**
   * Godot calls this method to get data that can be dragged and dropped onto controls that expect
   * drop data. Returns `null` if there is no data to drag. Controls that want to receive drop data
   * should implement [_canDropData] and [_dropData]. [atPosition] is local to this control. Drag may
   * be forced with [forceDrag].
   *
   * A preview that will follow the mouse that should represent the data can be set with
   * [setDragPreview]. A good time to set the preview is in this method.
   *
   * **Note:** If the drag was initiated by a keyboard shortcut or [accessibilityDrag], [atPosition]
   * is set to [Vector2.INF], and the currently selected item/text position should be used as the drag
   * position.
   *
   * ```gdscript
   * //gdscript
   * func _get_drag_data(position):
   * 	var mydata = make_data() # This is your custom method generating the drag data.
   * 	set_drag_preview(make_preview(mydata)) # This is your custom method generating the preview of
   * the drag data.
   * 	return mydata
   * ```
   *
   * ```csharp
   * //csharp
   * public override Variant _GetDragData(Vector2 atPosition)
   * {
   * 	var myData = MakeData(); // This is your custom method generating the drag data.
   * 	SetDragPreview(MakePreview(myData)); // This is your custom method generating the preview of
   * the drag data.
   * 	return myData;
   * }
   * ```
   */
  public open fun _getDragData(atPosition: Vector2): Any? {
    throw NotImplementedError("Control::_getDragData is not implemented.")
  }

  /**
   * Godot calls this method to test if [data] from a control's [_getDragData] can be dropped at
   * [atPosition]. [atPosition] is local to this control.
   *
   * This method should only be used to test the data. Process the data in [_dropData].
   *
   * **Note:** If the drag was initiated by a keyboard shortcut or [accessibilityDrag], [atPosition]
   * is set to [Vector2.INF], and the currently selected item/text position should be used as the drop
   * position.
   *
   * ```gdscript
   * //gdscript
   * func _can_drop_data(position, data):
   * 	# Check position if it is relevant to you
   * 	# Otherwise, just check data
   * 	return typeof(data) == TYPE_DICTIONARY and data.has("expected")
   * ```
   *
   * ```csharp
   * //csharp
   * public override bool _CanDropData(Vector2 atPosition, Variant data)
   * {
   * 	// Check position if it is relevant to you
   * 	// Otherwise, just check data
   * 	return data.VariantType == Variant.Type.Dictionary &&
   * data.AsGodotDictionary().ContainsKey("expected");
   * }
   * ```
   */
  public open fun _canDropData(atPosition: Vector2, `data`: Any?): Boolean {
    throw NotImplementedError("Control::_canDropData is not implemented.")
  }

  /**
   * Godot calls this method to pass you the [data] from a control's [_getDragData] result. Godot
   * first calls [_canDropData] to test if [data] is allowed to drop at [atPosition] where [atPosition]
   * is local to this control.
   *
   * **Note:** If the drag was initiated by a keyboard shortcut or [accessibilityDrag], [atPosition]
   * is set to [Vector2.INF], and the currently selected item/text position should be used as the drop
   * position.
   *
   * ```gdscript
   * //gdscript
   * func _can_drop_data(position, data):
   * 	return typeof(data) == TYPE_DICTIONARY and data.has("color")
   *
   * func _drop_data(position, data):
   * 	var color = data["color"]
   * ```
   *
   * ```csharp
   * //csharp
   * public override bool _CanDropData(Vector2 atPosition, Variant data)
   * {
   * 	return data.VariantType == Variant.Type.Dictionary &&
   * data.AsGodotDictionary().ContainsKey("color");
   * }
   *
   * public override void _DropData(Vector2 atPosition, Variant data)
   * {
   * 	Color color = data.AsGodotDictionary()["color"].AsColor();
   * }
   * ```
   */
  public open fun _dropData(atPosition: Vector2, `data`: Any?): Unit {
    throw NotImplementedError("Control::_dropData is not implemented.")
  }

  /**
   * Virtual method to be implemented by the user. Returns a [Control] node that should be used as a
   * tooltip instead of the default one. [forText] is the return value of [getTooltip].
   *
   * The returned node must be of type [Control] or Control-derived. It can have child nodes of any
   * type. It is freed when the tooltip disappears, so make sure you always provide a new instance (if
   * you want to use a pre-existing node from your scene tree, you can duplicate it and pass the
   * duplicated instance). When `null` or a non-Control node is returned, the default tooltip will be
   * used instead.
   *
   * The returned node will be added as child to a [PopupPanel], so you should only provide the
   * contents of that panel. That [PopupPanel] can be themed using [Theme.setStylebox] for the type
   * `"TooltipPanel"` (see [tooltipText] for an example).
   *
   * **Note:** The tooltip is shrunk to minimal size. If you want to ensure it's fully visible, you
   * might want to set its [customMinimumSize] to some non-zero value.
   *
   * **Note:** The node (and any relevant children) should have their [CanvasItem.visible] set to
   * `true` when returned, otherwise, the viewport that instantiates it will not be able to calculate
   * its minimum size reliably.
   *
   * **Note:** If overridden, this method is called even if [getTooltip] returns an empty string.
   * When this happens with the default tooltip, it is not displayed. To copy this behavior, return
   * `null` in this method when [forText] is empty.
   *
   * **Example:** Use a constructed node as a tooltip:
   *
   * ```gdscript
   * //gdscript
   * func _make_custom_tooltip(for_text):
   * 	var label = Label.new()
   * 	label.text = for_text
   * 	return label
   * ```
   *
   * ```csharp
   * //csharp
   * public override Control _MakeCustomTooltip(string forText)
   * {
   * 	var label = new Label();
   * 	label.Text = forText;
   * 	return label;
   * }
   * ```
   *
   * **Example:** Use a scene instance as a tooltip:
   *
   * ```gdscript
   * //gdscript
   * func _make_custom_tooltip(for_text):
   * 	var tooltip = preload("res://some_tooltip_scene.tscn").instantiate()
   * 	tooltip.get_node("Label").text = for_text
   * 	return tooltip
   * ```
   *
   * ```csharp
   * //csharp
   * public override Control _MakeCustomTooltip(string forText)
   * {
   * 	Node tooltip =
   * ResourceLoader.Load<PackedScene>("res://some_tooltip_scene.tscn").Instantiate();
   * 	tooltip.GetNode<Label>("Label").Text = forText;
   * 	return tooltip;
   * }
   * ```
   */
  public open fun _makeCustomTooltip(forText: String): Object? {
    throw NotImplementedError("Control::_makeCustomTooltip is not implemented.")
  }

  /**
   * Virtual method to be implemented by the user. Returns the cursor shape for the position
   * [atPosition] in the control's local coordinates, which will typically be used while hovering over
   * this control. See [getCursorShape].
   *
   * If not overridden, defaults to [mouseDefaultCursorShape].
   */
  public open fun _getCursorShape(atPosition: Vector2): Int {
    throw NotImplementedError("Control::_getCursorShape is not implemented.")
  }

  /**
   * Return the description of the keyboard shortcuts and other contextual help for this control.
   */
  public open fun _accessibilityGetContextualInfo(): String {
    throw NotImplementedError("Control::_accessibilityGetContextualInfo is not implemented.")
  }

  /**
   * Override this method to return a human-readable description of the position of the child [node]
   * in the custom container, added to the [accessibilityName].
   */
  public open fun _getAccessibilityContainerName(node: Node): String {
    throw NotImplementedError("Control::_getAccessibilityContainerName is not implemented.")
  }

  /**
   * Virtual method to be implemented by the user. Override this method to handle and accept inputs
   * on UI elements. See also [acceptEvent].
   *
   * **Example:** Click on the control to print a message:
   *
   * ```gdscript
   * //gdscript
   * func _gui_input(event):
   * 	if event is InputEventMouseButton:
   * 		if event.button_index == MOUSE_BUTTON_LEFT and event.pressed:
   * 			print("I've been clicked D:")
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _GuiInput(InputEvent @event)
   * {
   * 	if (@event is InputEventMouseButton mb)
   * 	{
   * 		if (mb.ButtonIndex == MouseButton.Left && mb.Pressed)
   * 		{
   * 			GD.Print("I've been clicked D:");
   * 		}
   * 	}
   * }
   * ```
   *
   * If the [event] inherits [InputEventMouse], this method will **not** be called when:
   *
   * - the control's [mouseFilter] is set to [MOUSE_FILTER_IGNORE];
   *
   * - the control is obstructed by another control on top, that doesn't have [mouseFilter] set to
   * [MOUSE_FILTER_IGNORE];
   *
   * - the control's parent has [mouseFilter] set to [MOUSE_FILTER_STOP] or has accepted the event;
   *
   * - the control's parent has [clipContents] enabled and the [event]'s position is outside the
   * parent's rectangle;
   *
   * - the [event]'s position is outside the control (see [_hasPoint]).
   *
   * **Note:** The [event]'s position is relative to this control's origin.
   */
  public open fun _guiInput(event: InputEvent): Unit {
    throw NotImplementedError("Control::_guiInput is not implemented.")
  }

  /**
   * Marks an input event as handled. Once you accept an input event, it stops propagating, even to
   * nodes listening to [Node.UnhandledInput] or [Node.UnhandledKeyInput].
   *
   * **Note:** This does not affect the methods in [Input], only the way events are propagated.
   */
  public final fun acceptEvent(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.acceptEventPtr)
  }

  /**
   * Returns the maximum size for this control. See [customMaximumSize].
   */
  public final fun getMaximumSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaximumSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the combined maximum size from [customMaximumSize] and [getMaximumSize], as well as the
   * [customMaximumSize] of this node's parent if it is a Control node with [propagateMaximumSize] set
   * to `true`.
   */
  public final fun getCombinedMaximumSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCombinedMaximumSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the minimum size for this control. See [customMinimumSize].
   */
  public final fun getMinimumSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinimumSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the combined minimum size from [customMinimumSize] and [getMinimumSize].
   */
  public final fun getCombinedMinimumSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCombinedMinimumSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setPropagateMaximumSize(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setPropagateMaximumSizePtr)
  }

  public final fun isPropagatingMaximumSize(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPropagatingMaximumSizePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the bound value of [getCombinedMinimumSize] by [getCombinedMaximumSize].
   *
   * This value is the true minimum size of the container, as the maximum size has priority over the
   * minimum size.
   *
   * For example, if the combined minimum size is (100, 100) and the combined maximum size is (50,
   * 150), the bound minimum size will be (50, 100).
   */
  public final fun getBoundMinimumSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoundMinimumSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets the anchors to a [preset] from [Control.LayoutPreset] enum. This is the code equivalent to
   * using the Layout menu in the 2D editor.
   *
   * If [keepOffsets] is `true`, control's position will also be updated.
   */
  @JvmOverloads
  public final fun setAnchorsPreset(preset: LayoutPreset, keepOffsets: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to preset.value, BOOL to keepOffsets)
    TransferContext.callMethod(MethodBindings.setAnchorsPresetPtr)
  }

  /**
   * Sets the offsets to a [preset] from [Control.LayoutPreset] enum. This is the code equivalent to
   * using the Layout menu in the 2D editor.
   *
   * Use parameter [resizeMode] with constants from [Control.LayoutPresetMode] to better determine
   * the resulting size of the [Control]. Constant size will be ignored if used with presets that
   * change size, e.g. [PRESET_LEFT_WIDE].
   *
   * Use parameter [margin] to determine the gap between the [Control] and the edges.
   */
  @JvmOverloads
  public final fun setOffsetsPreset(
    preset: LayoutPreset,
    resizeMode: LayoutPresetMode = Control.LayoutPresetMode.PRESET_MODE_MINSIZE,
    margin: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to preset.value, LONG to resizeMode.value, LONG to margin.toLong())
    TransferContext.callMethod(MethodBindings.setOffsetsPresetPtr)
  }

  /**
   * Sets both anchor preset and offset preset. See [setAnchorsPreset] and [setOffsetsPreset].
   */
  @JvmOverloads
  public final fun setAnchorsAndOffsetsPreset(
    preset: LayoutPreset,
    resizeMode: LayoutPresetMode = Control.LayoutPresetMode.PRESET_MODE_MINSIZE,
    margin: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to preset.value, LONG to resizeMode.value, LONG to margin.toLong())
    TransferContext.callMethod(MethodBindings.setAnchorsAndOffsetsPresetPtr)
  }

  /**
   * Sets the anchor for the specified [Side] to [anchor]. A setter method for [anchorBottom],
   * [anchorLeft], [anchorRight] and [anchorTop].
   *
   * If [keepOffset] is `true`, offsets aren't updated after this operation.
   *
   * If [pushOppositeAnchor] is `true` and the opposite anchor overlaps this anchor, the opposite
   * one will have its value overridden. For example, when setting left anchor to 1 and the right
   * anchor has value of 0.5, the right anchor will also get value of 1. If [pushOppositeAnchor] was
   * `false`, the left anchor would get value 0.5.
   */
  @JvmOverloads
  public final fun setAnchor(
    side: Side,
    anchor: Float,
    keepOffset: Boolean = false,
    pushOppositeAnchor: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to side.value, DOUBLE to anchor.toDouble(), BOOL to keepOffset, BOOL to pushOppositeAnchor)
    TransferContext.callMethod(MethodBindings.setAnchorPtr)
  }

  /**
   * Returns the anchor for the specified [Side]. A getter method for [anchorBottom], [anchorLeft],
   * [anchorRight] and [anchorTop].
   */
  public final fun getAnchor(side: Side): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to side.value)
    TransferContext.callMethod(MethodBindings.getAnchorPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the offset for the specified [Side] to [offset]. A setter method for [offsetBottom],
   * [offsetLeft], [offsetRight] and [offsetTop].
   */
  public final fun setOffset(side: Side, offset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to side.value, DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.setOffsetPtr)
  }

  /**
   * Returns the offset for the specified [Side]. A getter method for [offsetBottom], [offsetLeft],
   * [offsetRight] and [offsetTop].
   */
  public final fun getOffset(offset: Side): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to offset.value)
    TransferContext.callMethod(MethodBindings.getOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Works the same as [setAnchor], but instead of `keep_offset` argument and automatic update of
   * offset, it allows to set the offset yourself (see [setOffset]).
   */
  @JvmOverloads
  public final fun setAnchorAndOffset(
    side: Side,
    anchor: Float,
    offset: Float,
    pushOppositeAnchor: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to side.value, DOUBLE to anchor.toDouble(), DOUBLE to offset.toDouble(), BOOL to pushOppositeAnchor)
    TransferContext.callMethod(MethodBindings.setAnchorAndOffsetPtr)
  }

  /**
   * Sets [offsetLeft] and [offsetTop] at the same time. Equivalent of changing [position].
   */
  public final fun setBegin(position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.setBeginPtr)
  }

  /**
   * Sets [offsetRight] and [offsetBottom] at the same time.
   */
  public final fun setEnd(position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.setEndPtr)
  }

  /**
   * Sets the [position] to given [position].
   *
   * If [keepOffsets] is `true`, control's anchors will be updated instead of offsets.
   */
  @JvmOverloads
  public final fun setPosition(position: Vector2, keepOffsets: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position, BOOL to keepOffsets)
    TransferContext.callMethod(MethodBindings.setPositionPtr)
  }

  /**
   * Sets the size (see [size]).
   *
   * If [keepOffsets] is `true`, control's anchors will be updated instead of offsets.
   */
  @JvmOverloads
  public final fun setSize(size: Vector2, keepOffsets: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size, BOOL to keepOffsets)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  /**
   * Resets the size to [getCombinedMinimumSize]. This is equivalent to calling
   * `set_size(Vector2())` (or any size below the minimum).
   */
  public final fun resetSize(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetSizePtr)
  }

  public final fun setCustomMaximumSize(size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.setCustomMaximumSizePtr)
  }

  public final fun setCustomMinimumSize(size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.setCustomMinimumSizePtr)
  }

  /**
   * Sets the [globalPosition] to given [position].
   *
   * If [keepOffsets] is `true`, control's anchors will be updated instead of offsets.
   */
  @JvmOverloads
  public final fun setGlobalPosition(position: Vector2, keepOffsets: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position, BOOL to keepOffsets)
    TransferContext.callMethod(MethodBindings.setGlobalPositionPtr)
  }

  public final fun setRotation(radians: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radians.toDouble())
    TransferContext.callMethod(MethodBindings.setRotationPtr)
  }

  public final fun setRotationDegrees(degrees: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to degrees.toDouble())
    TransferContext.callMethod(MethodBindings.setRotationDegreesPtr)
  }

  public final fun setScale(scale: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to scale)
    TransferContext.callMethod(MethodBindings.setScalePtr)
  }

  public final fun setPivotOffset(pivotOffset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to pivotOffset)
    TransferContext.callMethod(MethodBindings.setPivotOffsetPtr)
  }

  public final fun setPivotOffsetRatio(ratio: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to ratio)
    TransferContext.callMethod(MethodBindings.setPivotOffsetRatioPtr)
  }

  /**
   * Returns [offsetLeft] and [offsetTop]. See also [position].
   */
  public final fun getBegin(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBeginPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns [offsetRight] and [offsetBottom].
   */
  public final fun getEnd(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEndPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getRotation(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getRotationDegrees(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationDegreesPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getScale(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScalePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getPivotOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPivotOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getPivotOffsetRatio(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPivotOffsetRatioPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the combined value of [pivotOffset] and [pivotOffsetRatio], in pixels. The ratio is
   * multiplied by the control's size.
   */
  public final fun getCombinedPivotOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCombinedPivotOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getCustomMaximumSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomMaximumSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getCustomMinimumSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomMinimumSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the width/height occupied in the parent control.
   */
  public final fun getParentAreaSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParentAreaSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getGlobalPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the position of this [Control] in global screen coordinates (i.e. taking window
   * position into account). Mostly useful for editor plugins.
   *
   * Equivalent to `get_screen_transform().origin` (see [CanvasItem.getScreenTransform]).
   *
   * **Example:** Show a popup at the mouse position:
   *
   * ```
   * popup_menu.position = get_screen_position() +
   * get_screen_transform().basis_xform(get_local_mouse_position())
   *
   * # The above code is equivalent to:
   * popup_menu.position = get_screen_transform() * get_local_mouse_position()
   *
   * popup_menu.reset_size()
   * popup_menu.popup()
   * ```
   */
  public final fun getScreenPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the position and size of the control in the coordinate system of the containing node.
   * See [position], [scale] and [size].
   *
   * **Note:** If [rotation] is not the default rotation, the resulting size is not meaningful.
   *
   * **Note:** Setting [Viewport.guiSnapControlsToPixels] to `true` can lead to rounding
   * inaccuracies between the displayed control and the returned [Rect2].
   */
  public final fun getRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Returns the position and size of the control relative to the containing canvas. See
   * [globalPosition] and [size].
   *
   * **Note:** If the node itself or any parent [CanvasItem] between the node and the canvas have a
   * non default rotation or skew, the resulting size is likely not meaningful.
   *
   * **Note:** Setting [Viewport.guiSnapControlsToPixels] to `true` can lead to rounding
   * inaccuracies between the displayed control and the returned [Rect2].
   */
  public final fun getGlobalRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setFocusMode(mode: FocusMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setFocusModePtr)
  }

  public final fun getFocusMode(): FocusMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFocusModePtr)
    return FocusMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the [focusMode], but takes the [focusBehaviorRecursive] into account. If
   * [focusBehaviorRecursive] is set to [FOCUS_BEHAVIOR_DISABLED], or it is set to
   * [FOCUS_BEHAVIOR_INHERITED] and its ancestor is set to [FOCUS_BEHAVIOR_DISABLED], then this returns
   * [FOCUS_NONE].
   */
  public final fun getFocusModeWithOverride(): FocusMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFocusModeWithOverridePtr)
    return FocusMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFocusBehaviorRecursive(focusBehaviorRecursive: FocusBehaviorRecursive): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to focusBehaviorRecursive.value)
    TransferContext.callMethod(MethodBindings.setFocusBehaviorRecursivePtr)
  }

  public final fun getFocusBehaviorRecursive(): FocusBehaviorRecursive {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFocusBehaviorRecursivePtr)
    return FocusBehaviorRecursive.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if this is the current focused control. See [focusMode].
   *
   * If [ignoreHiddenFocus] is `true`, controls that have their focus hidden will always return
   * `false`. Hidden focus happens automatically when controls gain focus via mouse input, or manually
   * using [grabFocus] with `hide_focus` set to `true`.
   */
  @JvmOverloads
  public final fun hasFocus(ignoreHiddenFocus: Boolean = false): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to ignoreHiddenFocus)
    TransferContext.callMethod(MethodBindings.hasFocusPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Steal the focus from another control and become the focused control (see [focusMode]).
   *
   * If [hideFocus] is `true`, the control will not visually show its focused state. Has no effect
   * for [LineEdit] and [TextEdit] when [ProjectSettings.gui/common/showFocusStateOnPointerEvent] is
   * set to `Text Input Controls`, or for any control when it is set to `Always`.
   *
   * **Note:** Using this method together with [Callable.callDeferred] makes it more reliable,
   * especially when called inside [Node.Ready].
   */
  @JvmOverloads
  public final fun grabFocus(hideFocus: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to hideFocus)
    TransferContext.callMethod(MethodBindings.grabFocusPtr)
  }

  /**
   * Give up the focus. No other control will be able to receive input.
   */
  public final fun releaseFocus(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.releaseFocusPtr)
  }

  /**
   * Finds the previous (above in the tree) [Control] that can receive the focus.
   */
  public final fun findPrevValidFocus(): Control? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.findPrevValidFocusPtr)
    return (TransferContext.readReturnValue(OBJECT) as Control?)
  }

  /**
   * Finds the next (below in the tree) [Control] that can receive the focus.
   */
  public final fun findNextValidFocus(): Control? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.findNextValidFocusPtr)
    return (TransferContext.readReturnValue(OBJECT) as Control?)
  }

  /**
   * Finds the next [Control] that can receive the focus on the specified [Side].
   *
   * **Note:** This is different from [getFocusNeighbor], which returns the path of a specified
   * focus neighbor.
   */
  public final fun findValidFocusNeighbor(side: Side): Control? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to side.value)
    TransferContext.callMethod(MethodBindings.findValidFocusNeighborPtr)
    return (TransferContext.readReturnValue(OBJECT) as Control?)
  }

  public final fun setHSizeFlags(flags: SizeFlags): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flags.flag)
    TransferContext.callMethod(MethodBindings.setHSizeFlagsPtr)
  }

  public final fun getHSizeFlags(): SizeFlags {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHSizeFlagsPtr)
    return SizeFlags(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setStretchRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setStretchRatioPtr)
  }

  public final fun getStretchRatio(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStretchRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVSizeFlags(flags: SizeFlags): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flags.flag)
    TransferContext.callMethod(MethodBindings.setVSizeFlagsPtr)
  }

  public final fun getVSizeFlags(): SizeFlags {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVSizeFlagsPtr)
    return SizeFlags(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setOffsetTransformEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setOffsetTransformEnabledPtr)
  }

  public final fun isOffsetTransformEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOffsetTransformEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setOffsetTransformPosition(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setOffsetTransformPositionPtr)
  }

  public final fun getOffsetTransformPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetTransformPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setOffsetTransformPositionRatio(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setOffsetTransformPositionRatioPtr)
  }

  public final fun getOffsetTransformPositionRatio(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetTransformPositionRatioPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setOffsetTransformScale(scale: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to scale)
    TransferContext.callMethod(MethodBindings.setOffsetTransformScalePtr)
  }

  public final fun getOffsetTransformScale(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetTransformScalePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setOffsetTransformRotation(rotation: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to rotation.toDouble())
    TransferContext.callMethod(MethodBindings.setOffsetTransformRotationPtr)
  }

  public final fun getOffsetTransformRotation(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetTransformRotationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setOffsetTransformPivot(pivot: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to pivot)
    TransferContext.callMethod(MethodBindings.setOffsetTransformPivotPtr)
  }

  public final fun getOffsetTransformPivot(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetTransformPivotPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setOffsetTransformPivotRatio(pivot: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to pivot)
    TransferContext.callMethod(MethodBindings.setOffsetTransformPivotRatioPtr)
  }

  public final fun getOffsetTransformPivotRatio(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetTransformPivotRatioPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setOffsetTransformVisualOnly(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setOffsetTransformVisualOnlyPtr)
  }

  public final fun isOffsetTransformVisualOnly(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOffsetTransformVisualOnlyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTheme(theme: Theme?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to theme)
    TransferContext.callMethod(MethodBindings.setThemePtr)
  }

  public final fun getTheme(): Theme? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemePtr)
    return (TransferContext.readReturnValue(OBJECT) as Theme?)
  }

  public final fun setThemeTypeVariation(themeType: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.setThemeTypeVariationPtr)
  }

  public final fun getThemeTypeVariation(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemeTypeVariationPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Prevents `*_theme_*_override` methods from emitting [NOTIFICATION_THEME_CHANGED] until
   * [endBulkThemeOverride] is called.
   */
  public final fun beginBulkThemeOverride(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.beginBulkThemeOverridePtr)
  }

  /**
   * Ends a bulk theme override update. See [beginBulkThemeOverride].
   */
  public final fun endBulkThemeOverride(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.endBulkThemeOverridePtr)
  }

  /**
   * Creates a local override for a theme icon with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeIconOverride].
   *
   * See also [getThemeIcon].
   */
  public final fun addThemeIconOverride(name: StringName, texture: Texture2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.addThemeIconOverridePtr)
  }

  /**
   * Creates a local override for a theme [StyleBox] with the specified [name]. Local overrides
   * always take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeStyleboxOverride].
   *
   * See also [getThemeStylebox].
   *
   * **Example:** Modify a property in a [StyleBox] by duplicating it:
   *
   * ```gdscript
   * //gdscript
   * # The snippet below assumes the child node "MyButton" has a StyleBoxFlat assigned.
   * # Resources are shared across instances, so we need to duplicate it
   * # to avoid modifying the appearance of all other buttons.
   * var new_stylebox_normal = $MyButton.get_theme_stylebox("normal").duplicate()
   * new_stylebox_normal.border_width_top = 3
   * new_stylebox_normal.border_color = Color(0, 1, 0.5)
   * $MyButton.add_theme_stylebox_override("normal", new_stylebox_normal)
   * # Remove the stylebox override.
   * $MyButton.remove_theme_stylebox_override("normal")
   * ```
   *
   * ```csharp
   * //csharp
   * // The snippet below assumes the child node "MyButton" has a StyleBoxFlat assigned.
   * // Resources are shared across instances, so we need to duplicate it
   * // to avoid modifying the appearance of all other buttons.
   * StyleBoxFlat newStyleboxNormal =
   * GetNode<Button>("MyButton").GetThemeStylebox("normal").Duplicate() as StyleBoxFlat;
   * newStyleboxNormal.BorderWidthTop = 3;
   * newStyleboxNormal.BorderColor = new Color(0, 1, 0.5f);
   * GetNode<Button>("MyButton").AddThemeStyleboxOverride("normal", newStyleboxNormal);
   * // Remove the stylebox override.
   * GetNode<Button>("MyButton").RemoveThemeStyleboxOverride("normal");
   * ```
   */
  public final fun addThemeStyleboxOverride(name: StringName, stylebox: StyleBox): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to stylebox)
    TransferContext.callMethod(MethodBindings.addThemeStyleboxOverridePtr)
  }

  /**
   * Creates a local override for a theme [Font] with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeFontOverride].
   *
   * See also [getThemeFont].
   */
  public final fun addThemeFontOverride(name: StringName, font: Font): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to font)
    TransferContext.callMethod(MethodBindings.addThemeFontOverridePtr)
  }

  /**
   * Creates a local override for a theme font size with the specified [name]. Local overrides
   * always take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeFontSizeOverride].
   *
   * See also [getThemeFontSize].
   */
  public final fun addThemeFontSizeOverride(name: StringName, fontSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, LONG to fontSize.toLong())
    TransferContext.callMethod(MethodBindings.addThemeFontSizeOverridePtr)
  }

  /**
   * Creates a local override for a theme [Color] with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeColorOverride].
   *
   * See also [getThemeColor].
   *
   * **Example:** Override a [Label]'s color and reset it later:
   *
   * ```gdscript
   * //gdscript
   * # Given the child Label node "MyLabel", override its font color with a custom value.
   * $MyLabel.add_theme_color_override("font_color", Color(1, 0.5, 0))
   * # Reset the font color of the child label.
   * $MyLabel.remove_theme_color_override("font_color")
   * # Alternatively it can be overridden with the default value from the Label type.
   * $MyLabel.add_theme_color_override("font_color", get_theme_color("font_color", "Label"))
   * ```
   *
   * ```csharp
   * //csharp
   * // Given the child Label node "MyLabel", override its font color with a custom value.
   * GetNode<Label>("MyLabel").AddThemeColorOverride("font_color", new Color(1, 0.5f, 0));
   * // Reset the font color of the child label.
   * GetNode<Label>("MyLabel").RemoveThemeColorOverride("font_color");
   * // Alternatively it can be overridden with the default value from the Label type.
   * GetNode<Label>("MyLabel").AddThemeColorOverride("font_color", GetThemeColor("font_color",
   * "Label"));
   * ```
   */
  public final fun addThemeColorOverride(name: StringName, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, COLOR to color)
    TransferContext.callMethod(MethodBindings.addThemeColorOverridePtr)
  }

  /**
   * Creates a local override for a theme constant with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeConstantOverride].
   *
   * See also [getThemeConstant].
   */
  public final fun addThemeConstantOverride(name: StringName, constant: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, LONG to constant.toLong())
    TransferContext.callMethod(MethodBindings.addThemeConstantOverridePtr)
  }

  /**
   * Removes a local override for a theme icon with the specified [name] previously added by
   * [addThemeIconOverride] or via the Inspector dock.
   */
  public final fun removeThemeIconOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeIconOverridePtr)
  }

  /**
   * Removes a local override for a theme [StyleBox] with the specified [name] previously added by
   * [addThemeStyleboxOverride] or via the Inspector dock.
   */
  public final fun removeThemeStyleboxOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeStyleboxOverridePtr)
  }

  /**
   * Removes a local override for a theme [Font] with the specified [name] previously added by
   * [addThemeFontOverride] or via the Inspector dock.
   */
  public final fun removeThemeFontOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeFontOverridePtr)
  }

  /**
   * Removes a local override for a theme font size with the specified [name] previously added by
   * [addThemeFontSizeOverride] or via the Inspector dock.
   */
  public final fun removeThemeFontSizeOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeFontSizeOverridePtr)
  }

  /**
   * Removes a local override for a theme [Color] with the specified [name] previously added by
   * [addThemeColorOverride] or via the Inspector dock.
   */
  public final fun removeThemeColorOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeColorOverridePtr)
  }

  /**
   * Removes a local override for a theme constant with the specified [name] previously added by
   * [addThemeConstantOverride] or via the Inspector dock.
   */
  public final fun removeThemeConstantOverride(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeThemeConstantOverridePtr)
  }

  /**
   * Returns an icon from the first matching [Theme] in the tree if that [Theme] has an icon item
   * with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeIcon(name: StringName, themeType: StringName = StringName("")):
      Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeIconPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Returns a [StyleBox] from the first matching [Theme] in the tree if that [Theme] has a stylebox
   * item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeStylebox(name: StringName, themeType: StringName = StringName("")):
      StyleBox? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeStyleboxPtr)
    return (TransferContext.readReturnValue(OBJECT) as StyleBox?)
  }

  /**
   * Returns a [Font] from the first matching [Theme] in the tree if that [Theme] has a font item
   * with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeFont(name: StringName, themeType: StringName = StringName("")): Font? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeFontPtr)
    return (TransferContext.readReturnValue(OBJECT) as Font?)
  }

  /**
   * Returns a font size from the first matching [Theme] in the tree if that [Theme] has a font size
   * item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeFontSize(name: StringName, themeType: StringName = StringName("")): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeFontSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns a [Color] from the first matching [Theme] in the tree if that [Theme] has a color item
   * with the specified [name] and [themeType]. If [themeType] is omitted the class name of the current
   * control is used as the type, or [themeTypeVariation] if it is defined. If the type is a class name
   * its parent classes are also checked, in order of inheritance. If the type is a variation its base
   * types are checked, in order of dependency, then the control's class name and its parent classes
   * are checked.
   *
   * For the current control its local overrides are considered first (see [addThemeColorOverride]),
   * then its assigned [theme]. After the current control, each parent control and its assigned [theme]
   * are considered; controls without a [theme] assigned are skipped. If no matching [Theme] is found
   * in the tree, the custom project [Theme] (see [ProjectSettings.gui/theme/custom]) and the default
   * [Theme] are used (see [ThemeDB]).
   *
   * ```gdscript
   * //gdscript
   * func _ready():
   * 	# Get the font color defined for the current Control's class, if it exists.
   * 	modulate = get_theme_color("font_color")
   * 	# Get the font color defined for the Button class.
   * 	modulate = get_theme_color("font_color", "Button")
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Ready()
   * {
   * 	// Get the font color defined for the current Control's class, if it exists.
   * 	Modulate = GetThemeColor("font_color");
   * 	// Get the font color defined for the Button class.
   * 	Modulate = GetThemeColor("font_color", "Button");
   * }
   * ```
   */
  public final fun getThemeColor(name: StringName, themeType: StringName = StringName("")): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Returns a constant from the first matching [Theme] in the tree if that [Theme] has a constant
   * item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeConstant(name: StringName, themeType: StringName = StringName("")): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.getThemeConstantPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if there is a local override for a theme icon with the specified [name] in this
   * [Control] node.
   *
   * See [addThemeIconOverride].
   */
  public final fun hasThemeIconOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeIconOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme [StyleBox] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeStyleboxOverride].
   */
  public final fun hasThemeStyleboxOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeStyleboxOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme [Font] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeFontOverride].
   */
  public final fun hasThemeFontOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeFontOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme font size with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeFontSizeOverride].
   */
  public final fun hasThemeFontSizeOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeFontSizeOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme [Color] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeColorOverride].
   */
  public final fun hasThemeColorOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeColorOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a local override for a theme constant with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeConstantOverride].
   */
  public final fun hasThemeConstantOverride(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasThemeConstantOverridePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has an icon item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeIcon(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeIconPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a stylebox item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeStylebox(name: StringName, themeType: StringName = StringName("")):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeStyleboxPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a font item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeFont(name: StringName, themeType: StringName = StringName("")): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeFontPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a font size item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeFontSize(name: StringName, themeType: StringName = StringName("")):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeFontSizePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a color item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeColor(name: StringName, themeType: StringName = StringName("")):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeColorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a constant item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeConstant(name: StringName, themeType: StringName = StringName("")):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to themeType)
    TransferContext.callMethod(MethodBindings.hasThemeConstantPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the default base scale value from the first matching [Theme] in the tree if that
   * [Theme] has a valid [Theme.defaultBaseScale] value.
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeDefaultBaseScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemeDefaultBaseScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the default font from the first matching [Theme] in the tree if that [Theme] has a
   * valid [Theme.defaultFont] value.
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeDefaultFont(): Font? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemeDefaultFontPtr)
    return (TransferContext.readReturnValue(OBJECT) as Font?)
  }

  /**
   * Returns the default font size value from the first matching [Theme] in the tree if that [Theme]
   * has a valid [Theme.defaultFontSize] value.
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeDefaultFontSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThemeDefaultFontSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the parent control node.
   */
  public final fun getParentControl(): Control? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParentControlPtr)
    return (TransferContext.readReturnValue(OBJECT) as Control?)
  }

  public final fun setHGrowDirection(direction: GrowDirection): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setHGrowDirectionPtr)
  }

  public final fun getHGrowDirection(): GrowDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHGrowDirectionPtr)
    return GrowDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVGrowDirection(direction: GrowDirection): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setVGrowDirectionPtr)
  }

  public final fun getVGrowDirection(): GrowDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVGrowDirectionPtr)
    return GrowDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTooltipAutoTranslateMode(mode: Node.AutoTranslateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTooltipAutoTranslateModePtr)
  }

  public final fun getTooltipAutoTranslateMode(): Node.AutoTranslateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTooltipAutoTranslateModePtr)
    return Node.AutoTranslateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTooltipText(hint: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to hint)
    TransferContext.callMethod(MethodBindings.setTooltipTextPtr)
  }

  public final fun getTooltipText(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTooltipTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the tooltip text for the position [atPosition] in the control's local coordinates,
   * which will typically appear when the cursor is resting over this control. By default, it returns
   * [tooltipText].
   *
   * You can override [_getTooltip] to implement custom behavior for this method.
   *
   * **Note:** If this method returns an empty [String] and [_makeCustomTooltip] is not overridden,
   * no tooltip is displayed.
   */
  @JvmOverloads
  public final fun getTooltip(atPosition: Vector2 = Vector2(0, 0)): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to atPosition)
    TransferContext.callMethod(MethodBindings.getTooltipPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setTranslationContext(context: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to context)
    TransferContext.callMethod(MethodBindings.setTranslationContextPtr)
  }

  public final fun getTranslationContext(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTranslationContextPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setDefaultCursorShape(shape: CursorShape): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.setDefaultCursorShapePtr)
  }

  public final fun getDefaultCursorShape(): CursorShape {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDefaultCursorShapePtr)
    return CursorShape.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the mouse cursor shape for this control when hovered over [atPosition] in local
   * coordinates. For most controls, this is the same as [mouseDefaultCursorShape], but some built-in
   * controls implement more complex logic.
   *
   * You can override [_getCursorShape] to implement custom behavior for this method.
   */
  @JvmOverloads
  public final fun getCursorShape(atPosition: Vector2 = Vector2(0, 0)): CursorShape {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to atPosition)
    TransferContext.callMethod(MethodBindings.getCursorShapePtr)
    return CursorShape.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the focus neighbor for the specified [Side] to the [Control] at [neighbor] node path. A
   * setter method for [focusNeighborBottom], [focusNeighborLeft], [focusNeighborRight] and
   * [focusNeighborTop].
   */
  public final fun setFocusNeighbor(side: Side, neighbor: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to side.value, NODE_PATH to neighbor)
    TransferContext.callMethod(MethodBindings.setFocusNeighborPtr)
  }

  /**
   * Returns the focus neighbor for the specified [Side]. A getter method for [focusNeighborBottom],
   * [focusNeighborLeft], [focusNeighborRight] and [focusNeighborTop].
   *
   * **Note:** To find the next [Control] on the specific [Side], even if a neighbor is not
   * assigned, use [findValidFocusNeighbor].
   */
  public final fun getFocusNeighbor(side: Side): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to side.value)
    TransferContext.callMethod(MethodBindings.getFocusNeighborPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  public final fun setFocusNext(next: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to next)
    TransferContext.callMethod(MethodBindings.setFocusNextPtr)
  }

  public final fun getFocusNext(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFocusNextPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  public final fun setFocusPrevious(previous: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to previous)
    TransferContext.callMethod(MethodBindings.setFocusPreviousPtr)
  }

  public final fun getFocusPrevious(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFocusPreviousPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * Forces drag and bypasses [_getDragData] and [setDragPreview] by passing [data] and [preview].
   * Drag will start even if the mouse is neither over nor pressed on this control.
   *
   * The methods [_canDropData] and [_dropData] must be implemented on controls that want to receive
   * drop data.
   */
  public final fun forceDrag(`data`: Any?, preview: Control?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to data, OBJECT to preview)
    TransferContext.callMethod(MethodBindings.forceDragPtr)
  }

  /**
   * Starts drag-and-drop operation without using a mouse.
   */
  public final fun accessibilityDrag(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.accessibilityDragPtr)
  }

  /**
   * Ends drag-and-drop operation without using a mouse.
   */
  public final fun accessibilityDrop(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.accessibilityDropPtr)
  }

  public final fun setAccessibilityName(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.setAccessibilityNamePtr)
  }

  public final fun getAccessibilityName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setAccessibilityDescription(description: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to description)
    TransferContext.callMethod(MethodBindings.setAccessibilityDescriptionPtr)
  }

  public final fun getAccessibilityDescription(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityDescriptionPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setAccessibilityLive(mode: AccessibilityServer.AccessibilityLiveMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setAccessibilityLivePtr)
  }

  public final fun getAccessibilityLive(): AccessibilityServer.AccessibilityLiveMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityLivePtr)
    return AccessibilityServer.AccessibilityLiveMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAccessibilityControlsNodes(nodePath: VariantArray<NodePath>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to nodePath)
    TransferContext.callMethod(MethodBindings.setAccessibilityControlsNodesPtr)
  }

  public final fun getAccessibilityControlsNodes(): VariantArray<NodePath> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityControlsNodesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<NodePath>)
  }

  public final fun setAccessibilityDescribedByNodes(nodePath: VariantArray<NodePath>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to nodePath)
    TransferContext.callMethod(MethodBindings.setAccessibilityDescribedByNodesPtr)
  }

  public final fun getAccessibilityDescribedByNodes(): VariantArray<NodePath> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityDescribedByNodesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<NodePath>)
  }

  public final fun setAccessibilityLabeledByNodes(nodePath: VariantArray<NodePath>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to nodePath)
    TransferContext.callMethod(MethodBindings.setAccessibilityLabeledByNodesPtr)
  }

  public final fun getAccessibilityLabeledByNodes(): VariantArray<NodePath> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityLabeledByNodesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<NodePath>)
  }

  public final fun setAccessibilityFlowToNodes(nodePath: VariantArray<NodePath>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to nodePath)
    TransferContext.callMethod(MethodBindings.setAccessibilityFlowToNodesPtr)
  }

  public final fun getAccessibilityFlowToNodes(): VariantArray<NodePath> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessibilityFlowToNodesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<NodePath>)
  }

  public final fun setMouseFilter(filter: MouseFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to filter.value)
    TransferContext.callMethod(MethodBindings.setMouseFilterPtr)
  }

  public final fun getMouseFilter(): MouseFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMouseFilterPtr)
    return MouseFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the [mouseFilter], but takes the [mouseBehaviorRecursive] into account. If
   * [mouseBehaviorRecursive] is set to [MOUSE_BEHAVIOR_DISABLED], or it is set to
   * [MOUSE_BEHAVIOR_INHERITED] and its ancestor is set to [MOUSE_BEHAVIOR_DISABLED], then this returns
   * [MOUSE_FILTER_IGNORE].
   */
  public final fun getMouseFilterWithOverride(): MouseFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMouseFilterWithOverridePtr)
    return MouseFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMouseBehaviorRecursive(mouseBehaviorRecursive: MouseBehaviorRecursive): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mouseBehaviorRecursive.value)
    TransferContext.callMethod(MethodBindings.setMouseBehaviorRecursivePtr)
  }

  public final fun getMouseBehaviorRecursive(): MouseBehaviorRecursive {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMouseBehaviorRecursivePtr)
    return MouseBehaviorRecursive.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setForcePassScrollEvents(forcePassScrollEvents: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to forcePassScrollEvents)
    TransferContext.callMethod(MethodBindings.setForcePassScrollEventsPtr)
  }

  public final fun isForcePassScrollEvents(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isForcePassScrollEventsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setClipContents(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setClipContentsPtr)
  }

  public final fun isClippingContents(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isClippingContentsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Creates an [InputEventMouseButton] that attempts to click the control. If the event is
   * received, the control gains focus.
   *
   * ```gdscript
   * //gdscript
   * func _process(delta):
   * 	grab_click_focus() # When clicking another Control node, this node will be clicked instead.
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Process(double delta)
   * {
   * 	GrabClickFocus(); // When clicking another Control node, this node will be clicked instead.
   * }
   * ```
   */
  public final fun grabClickFocus(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.grabClickFocusPtr)
  }

  /**
   * Sets the given callables to be used instead of the control's own drag-and-drop virtual methods.
   * If a callable is empty, its respective virtual method is used as normal.
   *
   * The arguments for each callable should be exactly the same as their respective virtual methods,
   * which would be:
   *
   * - [dragFunc] corresponds to [_getDragData] and requires a [Vector2];
   *
   * - [canDropFunc] corresponds to [_canDropData] and requires both a [Vector2] and a [Variant];
   *
   * - [dropFunc] corresponds to [_dropData] and requires both a [Vector2] and a [Variant].
   */
  public final fun setDragForwarding(
    dragFunc: Callable,
    canDropFunc: Callable,
    dropFunc: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to dragFunc, CALLABLE to canDropFunc, CALLABLE to dropFunc)
    TransferContext.callMethod(MethodBindings.setDragForwardingPtr)
  }

  /**
   * Shows the given control at the mouse pointer. A good time to call this method is in
   * [_getDragData]. The control must not be in the scene tree. You should not free the control, and
   * you should not keep a reference to the control beyond the duration of the drag. It will be deleted
   * automatically after the drag has ended.
   *
   * ```gdscript
   * //gdscript
   * @export var color = Color(1, 0, 0, 1)
   *
   * func _get_drag_data(position):
   * 	# Use a control that is not in the tree
   * 	var cpb = ColorPickerButton.new()
   * 	cpb.color = color
   * 	cpb.size = Vector2(50, 50)
   * 	set_drag_preview(cpb)
   * 	return color
   * ```
   *
   * ```csharp
   * //csharp
   * [Export]
   * private Color _color = new Color(1, 0, 0, 1);
   *
   * public override Variant _GetDragData(Vector2 atPosition)
   * {
   * 	// Use a control that is not in the tree
   * 	var cpb = new ColorPickerButton();
   * 	cpb.Color = _color;
   * 	cpb.Size = new Vector2(50, 50);
   * 	SetDragPreview(cpb);
   * 	return _color;
   * }
   * ```
   */
  public final fun setDragPreview(control: Control?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to control)
    TransferContext.callMethod(MethodBindings.setDragPreviewPtr)
  }

  /**
   * Returns `true` if a drag operation is successful. Alternative to
   * [Viewport.guiIsDragSuccessful].
   *
   * Best used with [Node.NOTIFICATION_DRAG_END].
   */
  public final fun isDragSuccessful(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDragSuccessfulPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Moves the mouse cursor to [position], relative to [position] of this [Control].
   *
   * **Note:** [warpMouse] is only supported on Windows, macOS and Linux. It has no effect on
   * Android, iOS and Web.
   */
  public final fun warpMouse(position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.warpMousePtr)
  }

  public final fun setShortcutContext(node: Node?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to node)
    TransferContext.callMethod(MethodBindings.setShortcutContextPtr)
  }

  public final fun getShortcutContext(): Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShortcutContextPtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  /**
   * Invalidates the maximum size cache in this node and in parent nodes up to top level. Intended
   * to be used with [getMaximumSize] when the return value is changed. Setting [customMaximumSize]
   * directly calls this method automatically.
   *
   * **Note:** Calling this method also calls [updateMinimumSize] since the combined minimum size
   * may be affected by the maximum size change.
   */
  public final fun updateMaximumSize(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.updateMaximumSizePtr)
  }

  /**
   * Invalidates the minimum size cache in this node and in parent nodes up to top level. Intended
   * to be used with [getMinimumSize] when the return value is changed. Setting [customMinimumSize]
   * directly calls this method automatically.
   */
  public final fun updateMinimumSize(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.updateMinimumSizePtr)
  }

  public final fun setLayoutDirection(direction: LayoutDirection): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setLayoutDirectionPtr)
  }

  public final fun getLayoutDirection(): LayoutDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayoutDirectionPtr)
    return LayoutDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the layout is right-to-left. See also [layoutDirection].
   */
  public final fun isLayoutRtl(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLayoutRtlPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutoTranslate(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAutoTranslatePtr)
  }

  public final fun isAutoTranslating(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAutoTranslatingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLocalizeNumeralSystem(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setLocalizeNumeralSystemPtr)
  }

  public final fun isLocalizingNumeralSystem(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLocalizingNumeralSystemPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setThemeTypeVariation(themeType: String) =
      setThemeTypeVariation(themeType.asCachedStringName())

  /**
   * Creates a local override for a theme icon with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeIconOverride].
   *
   * See also [getThemeIcon].
   */
  public final fun addThemeIconOverride(name: String, texture: Texture2D) =
      addThemeIconOverride(name.asCachedStringName(), texture)

  /**
   * Creates a local override for a theme [StyleBox] with the specified [name]. Local overrides
   * always take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeStyleboxOverride].
   *
   * See also [getThemeStylebox].
   *
   * **Example:** Modify a property in a [StyleBox] by duplicating it:
   *
   * ```gdscript
   * //gdscript
   * # The snippet below assumes the child node "MyButton" has a StyleBoxFlat assigned.
   * # Resources are shared across instances, so we need to duplicate it
   * # to avoid modifying the appearance of all other buttons.
   * var new_stylebox_normal = $MyButton.get_theme_stylebox("normal").duplicate()
   * new_stylebox_normal.border_width_top = 3
   * new_stylebox_normal.border_color = Color(0, 1, 0.5)
   * $MyButton.add_theme_stylebox_override("normal", new_stylebox_normal)
   * # Remove the stylebox override.
   * $MyButton.remove_theme_stylebox_override("normal")
   * ```
   *
   * ```csharp
   * //csharp
   * // The snippet below assumes the child node "MyButton" has a StyleBoxFlat assigned.
   * // Resources are shared across instances, so we need to duplicate it
   * // to avoid modifying the appearance of all other buttons.
   * StyleBoxFlat newStyleboxNormal =
   * GetNode<Button>("MyButton").GetThemeStylebox("normal").Duplicate() as StyleBoxFlat;
   * newStyleboxNormal.BorderWidthTop = 3;
   * newStyleboxNormal.BorderColor = new Color(0, 1, 0.5f);
   * GetNode<Button>("MyButton").AddThemeStyleboxOverride("normal", newStyleboxNormal);
   * // Remove the stylebox override.
   * GetNode<Button>("MyButton").RemoveThemeStyleboxOverride("normal");
   * ```
   */
  public final fun addThemeStyleboxOverride(name: String, stylebox: StyleBox) =
      addThemeStyleboxOverride(name.asCachedStringName(), stylebox)

  /**
   * Creates a local override for a theme [Font] with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeFontOverride].
   *
   * See also [getThemeFont].
   */
  public final fun addThemeFontOverride(name: String, font: Font) =
      addThemeFontOverride(name.asCachedStringName(), font)

  /**
   * Creates a local override for a theme font size with the specified [name]. Local overrides
   * always take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeFontSizeOverride].
   *
   * See also [getThemeFontSize].
   */
  public final fun addThemeFontSizeOverride(name: String, fontSize: Int) =
      addThemeFontSizeOverride(name.asCachedStringName(), fontSize)

  /**
   * Creates a local override for a theme [Color] with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeColorOverride].
   *
   * See also [getThemeColor].
   *
   * **Example:** Override a [Label]'s color and reset it later:
   *
   * ```gdscript
   * //gdscript
   * # Given the child Label node "MyLabel", override its font color with a custom value.
   * $MyLabel.add_theme_color_override("font_color", Color(1, 0.5, 0))
   * # Reset the font color of the child label.
   * $MyLabel.remove_theme_color_override("font_color")
   * # Alternatively it can be overridden with the default value from the Label type.
   * $MyLabel.add_theme_color_override("font_color", get_theme_color("font_color", "Label"))
   * ```
   *
   * ```csharp
   * //csharp
   * // Given the child Label node "MyLabel", override its font color with a custom value.
   * GetNode<Label>("MyLabel").AddThemeColorOverride("font_color", new Color(1, 0.5f, 0));
   * // Reset the font color of the child label.
   * GetNode<Label>("MyLabel").RemoveThemeColorOverride("font_color");
   * // Alternatively it can be overridden with the default value from the Label type.
   * GetNode<Label>("MyLabel").AddThemeColorOverride("font_color", GetThemeColor("font_color",
   * "Label"));
   * ```
   */
  public final fun addThemeColorOverride(name: String, color: Color) =
      addThemeColorOverride(name.asCachedStringName(), color)

  /**
   * Creates a local override for a theme constant with the specified [name]. Local overrides always
   * take precedence when fetching theme items for the control. An override can be removed with
   * [removeThemeConstantOverride].
   *
   * See also [getThemeConstant].
   */
  public final fun addThemeConstantOverride(name: String, constant: Int) =
      addThemeConstantOverride(name.asCachedStringName(), constant)

  /**
   * Removes a local override for a theme icon with the specified [name] previously added by
   * [addThemeIconOverride] or via the Inspector dock.
   */
  public final fun removeThemeIconOverride(name: String) =
      removeThemeIconOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme [StyleBox] with the specified [name] previously added by
   * [addThemeStyleboxOverride] or via the Inspector dock.
   */
  public final fun removeThemeStyleboxOverride(name: String) =
      removeThemeStyleboxOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme [Font] with the specified [name] previously added by
   * [addThemeFontOverride] or via the Inspector dock.
   */
  public final fun removeThemeFontOverride(name: String) =
      removeThemeFontOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme font size with the specified [name] previously added by
   * [addThemeFontSizeOverride] or via the Inspector dock.
   */
  public final fun removeThemeFontSizeOverride(name: String) =
      removeThemeFontSizeOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme [Color] with the specified [name] previously added by
   * [addThemeColorOverride] or via the Inspector dock.
   */
  public final fun removeThemeColorOverride(name: String) =
      removeThemeColorOverride(name.asCachedStringName())

  /**
   * Removes a local override for a theme constant with the specified [name] previously added by
   * [addThemeConstantOverride] or via the Inspector dock.
   */
  public final fun removeThemeConstantOverride(name: String) =
      removeThemeConstantOverride(name.asCachedStringName())

  /**
   * Returns an icon from the first matching [Theme] in the tree if that [Theme] has an icon item
   * with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeIcon(name: String, themeType: String): Texture2D? =
      getThemeIcon(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a [StyleBox] from the first matching [Theme] in the tree if that [Theme] has a stylebox
   * item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeStylebox(name: String, themeType: String): StyleBox? =
      getThemeStylebox(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a [Font] from the first matching [Theme] in the tree if that [Theme] has a font item
   * with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeFont(name: String, themeType: String): Font? =
      getThemeFont(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a font size from the first matching [Theme] in the tree if that [Theme] has a font size
   * item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeFontSize(name: String, themeType: String): Int =
      getThemeFontSize(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a [Color] from the first matching [Theme] in the tree if that [Theme] has a color item
   * with the specified [name] and [themeType]. If [themeType] is omitted the class name of the current
   * control is used as the type, or [themeTypeVariation] if it is defined. If the type is a class name
   * its parent classes are also checked, in order of inheritance. If the type is a variation its base
   * types are checked, in order of dependency, then the control's class name and its parent classes
   * are checked.
   *
   * For the current control its local overrides are considered first (see [addThemeColorOverride]),
   * then its assigned [theme]. After the current control, each parent control and its assigned [theme]
   * are considered; controls without a [theme] assigned are skipped. If no matching [Theme] is found
   * in the tree, the custom project [Theme] (see [ProjectSettings.gui/theme/custom]) and the default
   * [Theme] are used (see [ThemeDB]).
   *
   * ```gdscript
   * //gdscript
   * func _ready():
   * 	# Get the font color defined for the current Control's class, if it exists.
   * 	modulate = get_theme_color("font_color")
   * 	# Get the font color defined for the Button class.
   * 	modulate = get_theme_color("font_color", "Button")
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Ready()
   * {
   * 	// Get the font color defined for the current Control's class, if it exists.
   * 	Modulate = GetThemeColor("font_color");
   * 	// Get the font color defined for the Button class.
   * 	Modulate = GetThemeColor("font_color", "Button");
   * }
   * ```
   */
  public final fun getThemeColor(name: String, themeType: String): Color =
      getThemeColor(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns a constant from the first matching [Theme] in the tree if that [Theme] has a constant
   * item with the specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun getThemeConstant(name: String, themeType: String): Int =
      getThemeConstant(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme icon with the specified [name] in this
   * [Control] node.
   *
   * See [addThemeIconOverride].
   */
  public final fun hasThemeIconOverride(name: String): Boolean =
      hasThemeIconOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme [StyleBox] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeStyleboxOverride].
   */
  public final fun hasThemeStyleboxOverride(name: String): Boolean =
      hasThemeStyleboxOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme [Font] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeFontOverride].
   */
  public final fun hasThemeFontOverride(name: String): Boolean =
      hasThemeFontOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme font size with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeFontSizeOverride].
   */
  public final fun hasThemeFontSizeOverride(name: String): Boolean =
      hasThemeFontSizeOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme [Color] with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeColorOverride].
   */
  public final fun hasThemeColorOverride(name: String): Boolean =
      hasThemeColorOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a local override for a theme constant with the specified [name] in
   * this [Control] node.
   *
   * See [addThemeConstantOverride].
   */
  public final fun hasThemeConstantOverride(name: String): Boolean =
      hasThemeConstantOverride(name.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has an icon item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeIcon(name: String, themeType: String): Boolean =
      hasThemeIcon(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a stylebox item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeStylebox(name: String, themeType: String): Boolean =
      hasThemeStylebox(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a font item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeFont(name: String, themeType: String): Boolean =
      hasThemeFont(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a font size item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeFontSize(name: String, themeType: String): Boolean =
      hasThemeFontSize(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a color item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeColor(name: String, themeType: String): Boolean =
      hasThemeColor(name.asCachedStringName(), themeType.asCachedStringName())

  /**
   * Returns `true` if there is a matching [Theme] in the tree that has a constant item with the
   * specified [name] and [themeType].
   *
   * See [getThemeColor] for details.
   */
  public final fun hasThemeConstant(name: String, themeType: String): Boolean =
      hasThemeConstant(name.asCachedStringName(), themeType.asCachedStringName())

  public final fun setTranslationContext(context: String) =
      setTranslationContext(context.asCachedStringName())

  /**
   * Sets the focus neighbor for the specified [Side] to the [Control] at [neighbor] node path. A
   * setter method for [focusNeighborBottom], [focusNeighborLeft], [focusNeighborRight] and
   * [focusNeighborTop].
   */
  public final fun setFocusNeighbor(side: Side, neighbor: String) =
      setFocusNeighbor(side, neighbor.asCachedNodePath())

  public final fun setFocusNext(next: String) = setFocusNext(next.asCachedNodePath())

  public final fun setFocusPrevious(previous: String) =
      setFocusPrevious(previous.asCachedNodePath())

  public enum class FocusMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The node cannot grab focus. Use with [focusMode].
     */
    NONE(0),
    /**
     * The node can only grab focus on mouse clicks. Use with [focusMode].
     */
    CLICK(1),
    /**
     * The node can grab focus on mouse click, using the arrows and the Tab keys on the keyboard, or
     * using the D-pad buttons on a gamepad. Use with [focusMode].
     */
    ALL(2),
    /**
     * The node can grab focus only when screen reader is active. Use with [focusMode].
     */
    ACCESSIBILITY(3),
    ;

    public companion object {
      public fun from(`value`: Long): FocusMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class FocusBehaviorRecursive(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Inherits the [focusBehaviorRecursive] from the parent control. If there is no parent control,
     * this is the same as [FOCUS_BEHAVIOR_ENABLED].
     */
    INHERITED(0),
    /**
     * Prevents the control from getting focused. [getFocusModeWithOverride] will return
     * [FOCUS_NONE].
     */
    DISABLED(1),
    /**
     * Allows the control to be focused, depending on the [focusMode]. This can be used to ignore
     * the parent's [focusBehaviorRecursive]. [getFocusModeWithOverride] will return the [focusMode].
     */
    ENABLED(2),
    ;

    public companion object {
      public fun from(`value`: Long): FocusBehaviorRecursive =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class MouseBehaviorRecursive(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Inherits the [mouseBehaviorRecursive] from the parent control. If there is no parent control,
     * this is the same as [MOUSE_BEHAVIOR_ENABLED].
     */
    INHERITED(0),
    /**
     * Prevents the control from receiving mouse input. [getMouseFilterWithOverride] will return
     * [MOUSE_FILTER_IGNORE].
     */
    DISABLED(1),
    /**
     * Allows the control to receive mouse input, depending on the [mouseFilter]. This can be used
     * to ignore the parent's [mouseBehaviorRecursive]. [getMouseFilterWithOverride] will return the
     * [mouseFilter].
     */
    ENABLED(2),
    ;

    public companion object {
      public fun from(`value`: Long): MouseBehaviorRecursive =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class CursorShape(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Show the system's arrow mouse cursor when the user hovers the node. Use with
     * [mouseDefaultCursorShape].
     */
    ARROW(0),
    /**
     * Show the system's I-beam mouse cursor when the user hovers the node. The I-beam pointer has a
     * shape similar to "I". It tells the user they can highlight or insert text.
     */
    IBEAM(1),
    /**
     * Show the system's pointing hand mouse cursor when the user hovers the node.
     */
    POINTING_HAND(2),
    /**
     * Show the system's cross mouse cursor when the user hovers the node.
     */
    CROSS(3),
    /**
     * Show the system's wait mouse cursor when the user hovers the node. Often an hourglass.
     */
    WAIT(4),
    /**
     * Show the system's busy mouse cursor when the user hovers the node. Often an arrow with a
     * small hourglass.
     */
    BUSY(5),
    /**
     * Show the system's drag mouse cursor, often a closed fist or a cross symbol, when the user
     * hovers the node. It tells the user they're currently dragging an item, like a node in the Scene
     * dock.
     */
    DRAG(6),
    /**
     * Show the system's drop mouse cursor when the user hovers the node. It can be an open hand. It
     * tells the user they can drop an item they're currently grabbing, like a node in the Scene dock.
     */
    CAN_DROP(7),
    /**
     * Show the system's forbidden mouse cursor when the user hovers the node. Often a crossed
     * circle.
     */
    FORBIDDEN(8),
    /**
     * Show the system's vertical resize mouse cursor when the user hovers the node. A double-headed
     * vertical arrow. It tells the user they can resize the window or the panel vertically.
     */
    VSIZE(9),
    /**
     * Show the system's horizontal resize mouse cursor when the user hovers the node. A
     * double-headed horizontal arrow. It tells the user they can resize the window or the panel
     * horizontally.
     */
    HSIZE(10),
    /**
     * Show the system's window resize mouse cursor when the user hovers the node. The cursor is a
     * double-headed arrow that goes from the bottom left to the top right. It tells the user they can
     * resize the window or the panel both horizontally and vertically.
     */
    BDIAGSIZE(11),
    /**
     * Show the system's window resize mouse cursor when the user hovers the node. The cursor is a
     * double-headed arrow that goes from the top left to the bottom right, the opposite of
     * [CURSOR_BDIAGSIZE]. It tells the user they can resize the window or the panel both horizontally
     * and vertically.
     */
    FDIAGSIZE(12),
    /**
     * Show the system's move mouse cursor when the user hovers the node. It shows 2 double-headed
     * arrows at a 90 degree angle. It tells the user they can move a UI element freely.
     */
    MOVE(13),
    /**
     * Show the system's vertical split mouse cursor when the user hovers the node. On Windows, it's
     * the same as [CURSOR_VSIZE].
     */
    VSPLIT(14),
    /**
     * Show the system's horizontal split mouse cursor when the user hovers the node. On Windows,
     * it's the same as [CURSOR_HSIZE].
     */
    HSPLIT(15),
    /**
     * Show the system's help mouse cursor when the user hovers the node, a question mark.
     */
    HELP(16),
    ;

    public companion object {
      public fun from(`value`: Long): CursorShape = entries.single { it.`value` == `value` }
    }
  }

  public enum class LayoutPreset(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Snap all 4 anchors to the top-left of the parent control's bounds. Use with
     * [setAnchorsPreset].
     */
    PRESET_TOP_LEFT(0),
    /**
     * Snap all 4 anchors to the top-right of the parent control's bounds. Use with
     * [setAnchorsPreset].
     */
    PRESET_TOP_RIGHT(1),
    /**
     * Snap all 4 anchors to the bottom-left of the parent control's bounds. Use with
     * [setAnchorsPreset].
     */
    PRESET_BOTTOM_LEFT(2),
    /**
     * Snap all 4 anchors to the bottom-right of the parent control's bounds. Use with
     * [setAnchorsPreset].
     */
    PRESET_BOTTOM_RIGHT(3),
    /**
     * Snap all 4 anchors to the center of the left edge of the parent control's bounds. Use with
     * [setAnchorsPreset].
     */
    PRESET_CENTER_LEFT(4),
    /**
     * Snap all 4 anchors to the center of the top edge of the parent control's bounds. Use with
     * [setAnchorsPreset].
     */
    PRESET_CENTER_TOP(5),
    /**
     * Snap all 4 anchors to the center of the right edge of the parent control's bounds. Use with
     * [setAnchorsPreset].
     */
    PRESET_CENTER_RIGHT(6),
    /**
     * Snap all 4 anchors to the center of the bottom edge of the parent control's bounds. Use with
     * [setAnchorsPreset].
     */
    PRESET_CENTER_BOTTOM(7),
    /**
     * Snap all 4 anchors to the center of the parent control's bounds. Use with [setAnchorsPreset].
     */
    PRESET_CENTER(8),
    /**
     * Snap all 4 anchors to the left edge of the parent control. The left offset becomes relative
     * to the left edge and the top offset relative to the top left corner of the node's parent. Use
     * with [setAnchorsPreset].
     */
    PRESET_LEFT_WIDE(9),
    /**
     * Snap all 4 anchors to the top edge of the parent control. The left offset becomes relative to
     * the top left corner, the top offset relative to the top edge, and the right offset relative to
     * the top right corner of the node's parent. Use with [setAnchorsPreset].
     */
    PRESET_TOP_WIDE(10),
    /**
     * Snap all 4 anchors to the right edge of the parent control. The right offset becomes relative
     * to the right edge and the top offset relative to the top right corner of the node's parent. Use
     * with [setAnchorsPreset].
     */
    PRESET_RIGHT_WIDE(11),
    /**
     * Snap all 4 anchors to the bottom edge of the parent control. The left offset becomes relative
     * to the bottom left corner, the bottom offset relative to the bottom edge, and the right offset
     * relative to the bottom right corner of the node's parent. Use with [setAnchorsPreset].
     */
    PRESET_BOTTOM_WIDE(12),
    /**
     * Snap all 4 anchors to a vertical line that cuts the parent control in half. Use with
     * [setAnchorsPreset].
     */
    PRESET_VCENTER_WIDE(13),
    /**
     * Snap all 4 anchors to a horizontal line that cuts the parent control in half. Use with
     * [setAnchorsPreset].
     */
    PRESET_HCENTER_WIDE(14),
    /**
     * Snap all 4 anchors to the respective corners of the parent control. Set all 4 offsets to 0
     * after you applied this preset and the [Control] will fit its parent control. Use with
     * [setAnchorsPreset].
     */
    PRESET_FULL_RECT(15),
    ;

    public companion object {
      public fun from(`value`: Long): LayoutPreset = entries.single { it.`value` == `value` }
    }
  }

  public enum class LayoutPresetMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The control will be resized to its minimum size.
     */
    PRESET_MODE_MINSIZE(0),
    /**
     * The control's width will not change.
     */
    PRESET_MODE_KEEP_WIDTH(1),
    /**
     * The control's height will not change.
     */
    PRESET_MODE_KEEP_HEIGHT(2),
    /**
     * The control's size will not change.
     */
    PRESET_MODE_KEEP_SIZE(3),
    ;

    public companion object {
      public fun from(`value`: Long): LayoutPresetMode = entries.single { it.`value` == `value` }
    }
  }

  public class SizeFlags(
    flag: Long,
  ) : BitFieldBase<SizeFlags>(flag) {
    protected override fun wrap(flag: Long): SizeFlags = SizeFlags(flag)

    public companion object {
      /**
       * Tells the parent [Container] to align the node with its start, either the top or the left
       * edge. It is mutually exclusive with [SIZE_FILL] and other shrink size flags, but can be used
       * with [SIZE_EXPAND] in some containers. Use with [sizeFlagsHorizontal] and [sizeFlagsVertical].
       *
       * **Note:** Setting this flag is equal to not having any size flags.
       */
      @JvmField
      public val SHRINK_BEGIN: SizeFlags = SizeFlags(0)

      /**
       * Tells the parent [Container] to expand the bounds of this node to fill all the available
       * space without pushing any other node. It is mutually exclusive with shrink size flags. Use
       * with [sizeFlagsHorizontal] and [sizeFlagsVertical].
       */
      @JvmField
      public val FILL: SizeFlags = SizeFlags(1)

      /**
       * Tells the parent [Container] to let this node take all the available space on the axis you
       * flag. If multiple neighboring nodes are set to expand, they'll share the space based on their
       * stretch ratio. See [sizeFlagsStretchRatio]. Use with [sizeFlagsHorizontal] and
       * [sizeFlagsVertical].
       */
      @JvmField
      public val EXPAND: SizeFlags = SizeFlags(2)

      /**
       * Sets the node's size flags to both fill and expand. See [SIZE_FILL] and [SIZE_EXPAND] for
       * more information.
       */
      @JvmField
      public val EXPAND_FILL: SizeFlags = SizeFlags(3)

      /**
       * Tells the parent [Container] to center the node in the available space. It is mutually
       * exclusive with [SIZE_FILL] and other shrink size flags, but can be used with [SIZE_EXPAND] in
       * some containers. Use with [sizeFlagsHorizontal] and [sizeFlagsVertical].
       */
      @JvmField
      public val SHRINK_CENTER: SizeFlags = SizeFlags(4)

      /**
       * Tells the parent [Container] to align the node with its end, either the bottom or the right
       * edge. It is mutually exclusive with [SIZE_FILL] and other shrink size flags, but can be used
       * with [SIZE_EXPAND] in some containers. Use with [sizeFlagsHorizontal] and [sizeFlagsVertical].
       */
      @JvmField
      public val SHRINK_END: SizeFlags = SizeFlags(8)
    }
  }

  public enum class MouseFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The control will receive mouse movement input events and mouse button input events if clicked
     * on through [_guiInput]. The control will also receive the [signal mouse_entered] and [signal
     * mouse_exited] signals. These events are automatically marked as handled, and they will not
     * propagate further to other controls. This also results in blocking signals in other controls.
     */
    STOP(0),
    /**
     * The control will receive mouse movement input events and mouse button input events if clicked
     * on through [_guiInput]. The control will also receive the [signal mouse_entered] and [signal
     * mouse_exited] signals.
     *
     * If this control does not handle the event, the event will propagate up to its parent control
     * if it has one. The event is bubbled up the node hierarchy until it reaches a non-[CanvasItem], a
     * control with [MOUSE_FILTER_STOP], or a [CanvasItem] with [CanvasItem.topLevel] enabled. This
     * will allow signals to fire in all controls it reaches. If no control handled it, the event will
     * be passed to [Node.ShortcutInput] for further processing.
     */
    PASS(1),
    /**
     * The control will not receive any mouse movement input events nor mouse button input events
     * through [_guiInput]. The control will also not receive the [signal mouse_entered] nor [signal
     * mouse_exited] signals. This will not block other controls from receiving these events or firing
     * the signals. Ignored events will not be handled automatically. If a child has
     * [MOUSE_FILTER_PASS] and an event was passed to this control, the event will further propagate up
     * to the control's parent.
     *
     * **Note:** If the control has received [signal mouse_entered] but not [signal mouse_exited],
     * changing the [mouseFilter] to [MOUSE_FILTER_IGNORE] will cause [signal mouse_exited] to be
     * emitted.
     */
    IGNORE(2),
    ;

    public companion object {
      public fun from(`value`: Long): MouseFilter = entries.single { it.`value` == `value` }
    }
  }

  public enum class GrowDirection(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The control will grow to the left or top to make up if its minimum size is changed to be
     * greater than its current size on the respective axis.
     */
    BEGIN(0),
    /**
     * The control will grow to the right or bottom to make up if its minimum size is changed to be
     * greater than its current size on the respective axis.
     */
    END(1),
    /**
     * The control will grow in both directions equally to make up if its minimum size is changed to
     * be greater than its current size.
     */
    BOTH(2),
    ;

    public companion object {
      public fun from(`value`: Long): GrowDirection = entries.single { it.`value` == `value` }
    }
  }

  public enum class Anchor(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Snaps one of the 4 anchor's sides to the origin of the node's `Rect`, in the top left. Use it
     * with one of the `anchor_*` member variables, like [anchorLeft]. To change all 4 anchors at once,
     * use [setAnchorsPreset].
     */
    BEGIN(0),
    /**
     * Snaps one of the 4 anchor's sides to the end of the node's `Rect`, in the bottom right. Use
     * it with one of the `anchor_*` member variables, like [anchorLeft]. To change all 4 anchors at
     * once, use [setAnchorsPreset].
     */
    END(1),
    ;

    public companion object {
      public fun from(`value`: Long): Anchor = entries.single { it.`value` == `value` }
    }
  }

  public enum class LayoutDirection(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Automatic layout direction, determined from the parent control layout direction.
     */
    INHERITED(0),
    /**
     * Automatic layout direction, determined from the current locale. Right-to-left layout
     * direction is automatically used for languages that require it such as Arabic and Hebrew, but
     * only if a valid translation file is loaded for the given language (unless said language is
     * configured as a fallback in [ProjectSettings.internationalization/locale/fallback]). For all
     * other languages (or if no valid translation file is found by Godot), left-to-right layout
     * direction is used. If using [TextServerFallback]
     * ([ProjectSettings.internationalization/rendering/textDriver]), left-to-right layout direction is
     * always used regardless of the language. Right-to-left layout direction can also be forced using
     * [ProjectSettings.internationalization/rendering/forceRightToLeftLayoutDirection].
     */
    APPLICATION_LOCALE(1),
    /**
     * Left-to-right layout direction.
     */
    LTR(2),
    /**
     * Right-to-left layout direction.
     */
    RTL(3),
    /**
     * Automatic layout direction, determined from the system locale. Right-to-left layout direction
     * is automatically used for languages that require it such as Arabic and Hebrew, but only if a
     * valid translation file is loaded for the given language. For all other languages (or if no valid
     * translation file is found by Godot), left-to-right layout direction is used. If using
     * [TextServerFallback] ([ProjectSettings.internationalization/rendering/textDriver]),
     * left-to-right layout direction is always used regardless of the language.
     */
    SYSTEM_LOCALE(4),
    /**
     * Represents the size of the [LayoutDirection] enum.
     */
    MAX(5),
    LOCALE(1),
    ;

    public companion object {
      public fun from(`value`: Long): LayoutDirection = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextDirection(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Text writing direction is the same as layout direction.
     */
    INHERITED(3),
    /**
     * Automatic text writing direction, determined from the current locale and text content.
     */
    AUTO(0),
    /**
     * Left-to-right text writing direction.
     */
    LTR(1),
    /**
     * Right-to-left text writing direction.
     */
    RTL(2),
    ;

    public companion object {
      public fun from(`value`: Long): TextDirection = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val acceptEventName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("accept_event")

    @JvmField
    public val getMaximumSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_maximum_size")

    @JvmField
    public val getCombinedMaximumSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_combined_maximum_size")

    @JvmField
    public val getMinimumSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_minimum_size")

    @JvmField
    public val getCombinedMinimumSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_combined_minimum_size")

    @JvmField
    public val setPropagateMaximumSizeName: MethodStringName1<Control, Unit, Boolean> =
        MethodStringName1<Control, Unit, Boolean>("set_propagate_maximum_size")

    @JvmField
    public val isPropagatingMaximumSizeName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_propagating_maximum_size")

    @JvmField
    public val getBoundMinimumSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_bound_minimum_size")

    @JvmField
    public val setAnchorsPresetName: MethodStringName2<Control, Unit, LayoutPreset, Boolean> =
        MethodStringName2<Control, Unit, LayoutPreset, Boolean>("set_anchors_preset")

    @JvmField
    public val setOffsetsPresetName:
        MethodStringName3<Control, Unit, LayoutPreset, LayoutPresetMode, Int> =
        MethodStringName3<Control, Unit, LayoutPreset, LayoutPresetMode, Int>("set_offsets_preset")

    @JvmField
    public val setAnchorsAndOffsetsPresetName:
        MethodStringName3<Control, Unit, LayoutPreset, LayoutPresetMode, Int> =
        MethodStringName3<Control, Unit, LayoutPreset, LayoutPresetMode, Int>("set_anchors_and_offsets_preset")

    @JvmField
    public val setAnchorName: MethodStringName4<Control, Unit, Side, Float, Boolean, Boolean> =
        MethodStringName4<Control, Unit, Side, Float, Boolean, Boolean>("set_anchor")

    @JvmField
    public val getAnchorName: MethodStringName1<Control, Float, Side> =
        MethodStringName1<Control, Float, Side>("get_anchor")

    @JvmField
    public val setOffsetName: MethodStringName2<Control, Unit, Side, Float> =
        MethodStringName2<Control, Unit, Side, Float>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName1<Control, Float, Side> =
        MethodStringName1<Control, Float, Side>("get_offset")

    @JvmField
    public val setAnchorAndOffsetName: MethodStringName4<Control, Unit, Side, Float, Float, Boolean>
        = MethodStringName4<Control, Unit, Side, Float, Float, Boolean>("set_anchor_and_offset")

    @JvmField
    public val setBeginName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_begin")

    @JvmField
    public val setEndName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_end")

    @JvmField
    public val setPositionName: MethodStringName2<Control, Unit, Vector2, Boolean> =
        MethodStringName2<Control, Unit, Vector2, Boolean>("set_position")

    @JvmField
    public val setSizeName: MethodStringName2<Control, Unit, Vector2, Boolean> =
        MethodStringName2<Control, Unit, Vector2, Boolean>("set_size")

    @JvmField
    public val resetSizeName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("reset_size")

    @JvmField
    public val setCustomMaximumSizeName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_custom_maximum_size")

    @JvmField
    public val setCustomMinimumSizeName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_custom_minimum_size")

    @JvmField
    public val setGlobalPositionName: MethodStringName2<Control, Unit, Vector2, Boolean> =
        MethodStringName2<Control, Unit, Vector2, Boolean>("set_global_position")

    @JvmField
    public val setRotationName: MethodStringName1<Control, Unit, Float> =
        MethodStringName1<Control, Unit, Float>("set_rotation")

    @JvmField
    public val setRotationDegreesName: MethodStringName1<Control, Unit, Float> =
        MethodStringName1<Control, Unit, Float>("set_rotation_degrees")

    @JvmField
    public val setScaleName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_scale")

    @JvmField
    public val setPivotOffsetName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_pivot_offset")

    @JvmField
    public val setPivotOffsetRatioName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_pivot_offset_ratio")

    @JvmField
    public val getBeginName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_begin")

    @JvmField
    public val getEndName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_end")

    @JvmField
    public val getPositionName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_position")

    @JvmField
    public val getSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_size")

    @JvmField
    public val getRotationName: MethodStringName0<Control, Float> =
        MethodStringName0<Control, Float>("get_rotation")

    @JvmField
    public val getRotationDegreesName: MethodStringName0<Control, Float> =
        MethodStringName0<Control, Float>("get_rotation_degrees")

    @JvmField
    public val getScaleName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_scale")

    @JvmField
    public val getPivotOffsetName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_pivot_offset")

    @JvmField
    public val getPivotOffsetRatioName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_pivot_offset_ratio")

    @JvmField
    public val getCombinedPivotOffsetName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_combined_pivot_offset")

    @JvmField
    public val getCustomMaximumSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_custom_maximum_size")

    @JvmField
    public val getCustomMinimumSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_custom_minimum_size")

    @JvmField
    public val getParentAreaSizeName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_parent_area_size")

    @JvmField
    public val getGlobalPositionName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_global_position")

    @JvmField
    public val getScreenPositionName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_screen_position")

    @JvmField
    public val getRectName: MethodStringName0<Control, Rect2> =
        MethodStringName0<Control, Rect2>("get_rect")

    @JvmField
    public val getGlobalRectName: MethodStringName0<Control, Rect2> =
        MethodStringName0<Control, Rect2>("get_global_rect")

    @JvmField
    public val setFocusModeName: MethodStringName1<Control, Unit, FocusMode> =
        MethodStringName1<Control, Unit, FocusMode>("set_focus_mode")

    @JvmField
    public val getFocusModeName: MethodStringName0<Control, FocusMode> =
        MethodStringName0<Control, FocusMode>("get_focus_mode")

    @JvmField
    public val getFocusModeWithOverrideName: MethodStringName0<Control, FocusMode> =
        MethodStringName0<Control, FocusMode>("get_focus_mode_with_override")

    @JvmField
    public val setFocusBehaviorRecursiveName:
        MethodStringName1<Control, Unit, FocusBehaviorRecursive> =
        MethodStringName1<Control, Unit, FocusBehaviorRecursive>("set_focus_behavior_recursive")

    @JvmField
    public val getFocusBehaviorRecursiveName: MethodStringName0<Control, FocusBehaviorRecursive> =
        MethodStringName0<Control, FocusBehaviorRecursive>("get_focus_behavior_recursive")

    @JvmField
    public val hasFocusName: MethodStringName1<Control, Boolean, Boolean> =
        MethodStringName1<Control, Boolean, Boolean>("has_focus")

    @JvmField
    public val grabFocusName: MethodStringName1<Control, Unit, Boolean> =
        MethodStringName1<Control, Unit, Boolean>("grab_focus")

    @JvmField
    public val releaseFocusName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("release_focus")

    @JvmField
    public val findPrevValidFocusName: MethodStringName0<Control, Control?> =
        MethodStringName0<Control, Control?>("find_prev_valid_focus")

    @JvmField
    public val findNextValidFocusName: MethodStringName0<Control, Control?> =
        MethodStringName0<Control, Control?>("find_next_valid_focus")

    @JvmField
    public val findValidFocusNeighborName: MethodStringName1<Control, Control?, Side> =
        MethodStringName1<Control, Control?, Side>("find_valid_focus_neighbor")

    @JvmField
    public val setHSizeFlagsName: MethodStringName1<Control, Unit, SizeFlags> =
        MethodStringName1<Control, Unit, SizeFlags>("set_h_size_flags")

    @JvmField
    public val getHSizeFlagsName: MethodStringName0<Control, SizeFlags> =
        MethodStringName0<Control, SizeFlags>("get_h_size_flags")

    @JvmField
    public val setStretchRatioName: MethodStringName1<Control, Unit, Float> =
        MethodStringName1<Control, Unit, Float>("set_stretch_ratio")

    @JvmField
    public val getStretchRatioName: MethodStringName0<Control, Float> =
        MethodStringName0<Control, Float>("get_stretch_ratio")

    @JvmField
    public val setVSizeFlagsName: MethodStringName1<Control, Unit, SizeFlags> =
        MethodStringName1<Control, Unit, SizeFlags>("set_v_size_flags")

    @JvmField
    public val getVSizeFlagsName: MethodStringName0<Control, SizeFlags> =
        MethodStringName0<Control, SizeFlags>("get_v_size_flags")

    @JvmField
    public val setOffsetTransformEnabledName: MethodStringName1<Control, Unit, Boolean> =
        MethodStringName1<Control, Unit, Boolean>("set_offset_transform_enabled")

    @JvmField
    public val isOffsetTransformEnabledName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_offset_transform_enabled")

    @JvmField
    public val setOffsetTransformPositionName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_offset_transform_position")

    @JvmField
    public val getOffsetTransformPositionName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_offset_transform_position")

    @JvmField
    public val setOffsetTransformPositionRatioName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_offset_transform_position_ratio")

    @JvmField
    public val getOffsetTransformPositionRatioName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_offset_transform_position_ratio")

    @JvmField
    public val setOffsetTransformScaleName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_offset_transform_scale")

    @JvmField
    public val getOffsetTransformScaleName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_offset_transform_scale")

    @JvmField
    public val setOffsetTransformRotationName: MethodStringName1<Control, Unit, Float> =
        MethodStringName1<Control, Unit, Float>("set_offset_transform_rotation")

    @JvmField
    public val getOffsetTransformRotationName: MethodStringName0<Control, Float> =
        MethodStringName0<Control, Float>("get_offset_transform_rotation")

    @JvmField
    public val setOffsetTransformPivotName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_offset_transform_pivot")

    @JvmField
    public val getOffsetTransformPivotName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_offset_transform_pivot")

    @JvmField
    public val setOffsetTransformPivotRatioName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("set_offset_transform_pivot_ratio")

    @JvmField
    public val getOffsetTransformPivotRatioName: MethodStringName0<Control, Vector2> =
        MethodStringName0<Control, Vector2>("get_offset_transform_pivot_ratio")

    @JvmField
    public val setOffsetTransformVisualOnlyName: MethodStringName1<Control, Unit, Boolean> =
        MethodStringName1<Control, Unit, Boolean>("set_offset_transform_visual_only")

    @JvmField
    public val isOffsetTransformVisualOnlyName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_offset_transform_visual_only")

    @JvmField
    public val setThemeName: MethodStringName1<Control, Unit, Theme?> =
        MethodStringName1<Control, Unit, Theme?>("set_theme")

    @JvmField
    public val getThemeName: MethodStringName0<Control, Theme?> =
        MethodStringName0<Control, Theme?>("get_theme")

    @JvmField
    public val setThemeTypeVariationName: MethodStringName1<Control, Unit, StringName> =
        MethodStringName1<Control, Unit, StringName>("set_theme_type_variation")

    @JvmField
    public val getThemeTypeVariationName: MethodStringName0<Control, StringName> =
        MethodStringName0<Control, StringName>("get_theme_type_variation")

    @JvmField
    public val beginBulkThemeOverrideName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("begin_bulk_theme_override")

    @JvmField
    public val endBulkThemeOverrideName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("end_bulk_theme_override")

    @JvmField
    public val addThemeIconOverrideName: MethodStringName2<Control, Unit, StringName, Texture2D> =
        MethodStringName2<Control, Unit, StringName, Texture2D>("add_theme_icon_override")

    @JvmField
    public val addThemeStyleboxOverrideName: MethodStringName2<Control, Unit, StringName, StyleBox>
        = MethodStringName2<Control, Unit, StringName, StyleBox>("add_theme_stylebox_override")

    @JvmField
    public val addThemeFontOverrideName: MethodStringName2<Control, Unit, StringName, Font> =
        MethodStringName2<Control, Unit, StringName, Font>("add_theme_font_override")

    @JvmField
    public val addThemeFontSizeOverrideName: MethodStringName2<Control, Unit, StringName, Int> =
        MethodStringName2<Control, Unit, StringName, Int>("add_theme_font_size_override")

    @JvmField
    public val addThemeColorOverrideName: MethodStringName2<Control, Unit, StringName, Color> =
        MethodStringName2<Control, Unit, StringName, Color>("add_theme_color_override")

    @JvmField
    public val addThemeConstantOverrideName: MethodStringName2<Control, Unit, StringName, Int> =
        MethodStringName2<Control, Unit, StringName, Int>("add_theme_constant_override")

    @JvmField
    public val removeThemeIconOverrideName: MethodStringName1<Control, Unit, StringName> =
        MethodStringName1<Control, Unit, StringName>("remove_theme_icon_override")

    @JvmField
    public val removeThemeStyleboxOverrideName: MethodStringName1<Control, Unit, StringName> =
        MethodStringName1<Control, Unit, StringName>("remove_theme_stylebox_override")

    @JvmField
    public val removeThemeFontOverrideName: MethodStringName1<Control, Unit, StringName> =
        MethodStringName1<Control, Unit, StringName>("remove_theme_font_override")

    @JvmField
    public val removeThemeFontSizeOverrideName: MethodStringName1<Control, Unit, StringName> =
        MethodStringName1<Control, Unit, StringName>("remove_theme_font_size_override")

    @JvmField
    public val removeThemeColorOverrideName: MethodStringName1<Control, Unit, StringName> =
        MethodStringName1<Control, Unit, StringName>("remove_theme_color_override")

    @JvmField
    public val removeThemeConstantOverrideName: MethodStringName1<Control, Unit, StringName> =
        MethodStringName1<Control, Unit, StringName>("remove_theme_constant_override")

    @JvmField
    public val getThemeIconName: MethodStringName2<Control, Texture2D?, StringName, StringName> =
        MethodStringName2<Control, Texture2D?, StringName, StringName>("get_theme_icon")

    @JvmField
    public val getThemeStyleboxName: MethodStringName2<Control, StyleBox?, StringName, StringName> =
        MethodStringName2<Control, StyleBox?, StringName, StringName>("get_theme_stylebox")

    @JvmField
    public val getThemeFontName: MethodStringName2<Control, Font?, StringName, StringName> =
        MethodStringName2<Control, Font?, StringName, StringName>("get_theme_font")

    @JvmField
    public val getThemeFontSizeName: MethodStringName2<Control, Int, StringName, StringName> =
        MethodStringName2<Control, Int, StringName, StringName>("get_theme_font_size")

    @JvmField
    public val getThemeColorName: MethodStringName2<Control, Color, StringName, StringName> =
        MethodStringName2<Control, Color, StringName, StringName>("get_theme_color")

    @JvmField
    public val getThemeConstantName: MethodStringName2<Control, Int, StringName, StringName> =
        MethodStringName2<Control, Int, StringName, StringName>("get_theme_constant")

    @JvmField
    public val hasThemeIconOverrideName: MethodStringName1<Control, Boolean, StringName> =
        MethodStringName1<Control, Boolean, StringName>("has_theme_icon_override")

    @JvmField
    public val hasThemeStyleboxOverrideName: MethodStringName1<Control, Boolean, StringName> =
        MethodStringName1<Control, Boolean, StringName>("has_theme_stylebox_override")

    @JvmField
    public val hasThemeFontOverrideName: MethodStringName1<Control, Boolean, StringName> =
        MethodStringName1<Control, Boolean, StringName>("has_theme_font_override")

    @JvmField
    public val hasThemeFontSizeOverrideName: MethodStringName1<Control, Boolean, StringName> =
        MethodStringName1<Control, Boolean, StringName>("has_theme_font_size_override")

    @JvmField
    public val hasThemeColorOverrideName: MethodStringName1<Control, Boolean, StringName> =
        MethodStringName1<Control, Boolean, StringName>("has_theme_color_override")

    @JvmField
    public val hasThemeConstantOverrideName: MethodStringName1<Control, Boolean, StringName> =
        MethodStringName1<Control, Boolean, StringName>("has_theme_constant_override")

    @JvmField
    public val hasThemeIconName: MethodStringName2<Control, Boolean, StringName, StringName> =
        MethodStringName2<Control, Boolean, StringName, StringName>("has_theme_icon")

    @JvmField
    public val hasThemeStyleboxName: MethodStringName2<Control, Boolean, StringName, StringName> =
        MethodStringName2<Control, Boolean, StringName, StringName>("has_theme_stylebox")

    @JvmField
    public val hasThemeFontName: MethodStringName2<Control, Boolean, StringName, StringName> =
        MethodStringName2<Control, Boolean, StringName, StringName>("has_theme_font")

    @JvmField
    public val hasThemeFontSizeName: MethodStringName2<Control, Boolean, StringName, StringName> =
        MethodStringName2<Control, Boolean, StringName, StringName>("has_theme_font_size")

    @JvmField
    public val hasThemeColorName: MethodStringName2<Control, Boolean, StringName, StringName> =
        MethodStringName2<Control, Boolean, StringName, StringName>("has_theme_color")

    @JvmField
    public val hasThemeConstantName: MethodStringName2<Control, Boolean, StringName, StringName> =
        MethodStringName2<Control, Boolean, StringName, StringName>("has_theme_constant")

    @JvmField
    public val getThemeDefaultBaseScaleName: MethodStringName0<Control, Float> =
        MethodStringName0<Control, Float>("get_theme_default_base_scale")

    @JvmField
    public val getThemeDefaultFontName: MethodStringName0<Control, Font?> =
        MethodStringName0<Control, Font?>("get_theme_default_font")

    @JvmField
    public val getThemeDefaultFontSizeName: MethodStringName0<Control, Int> =
        MethodStringName0<Control, Int>("get_theme_default_font_size")

    @JvmField
    public val getParentControlName: MethodStringName0<Control, Control?> =
        MethodStringName0<Control, Control?>("get_parent_control")

    @JvmField
    public val setHGrowDirectionName: MethodStringName1<Control, Unit, GrowDirection> =
        MethodStringName1<Control, Unit, GrowDirection>("set_h_grow_direction")

    @JvmField
    public val getHGrowDirectionName: MethodStringName0<Control, GrowDirection> =
        MethodStringName0<Control, GrowDirection>("get_h_grow_direction")

    @JvmField
    public val setVGrowDirectionName: MethodStringName1<Control, Unit, GrowDirection> =
        MethodStringName1<Control, Unit, GrowDirection>("set_v_grow_direction")

    @JvmField
    public val getVGrowDirectionName: MethodStringName0<Control, GrowDirection> =
        MethodStringName0<Control, GrowDirection>("get_v_grow_direction")

    @JvmField
    public val setTooltipAutoTranslateModeName:
        MethodStringName1<Control, Unit, Node.AutoTranslateMode> =
        MethodStringName1<Control, Unit, Node.AutoTranslateMode>("set_tooltip_auto_translate_mode")

    @JvmField
    public val getTooltipAutoTranslateModeName: MethodStringName0<Control, Node.AutoTranslateMode> =
        MethodStringName0<Control, Node.AutoTranslateMode>("get_tooltip_auto_translate_mode")

    @JvmField
    public val setTooltipTextName: MethodStringName1<Control, Unit, String> =
        MethodStringName1<Control, Unit, String>("set_tooltip_text")

    @JvmField
    public val getTooltipTextName: MethodStringName0<Control, String> =
        MethodStringName0<Control, String>("get_tooltip_text")

    @JvmField
    public val getTooltipName: MethodStringName1<Control, String, Vector2> =
        MethodStringName1<Control, String, Vector2>("get_tooltip")

    @JvmField
    public val setTranslationContextName: MethodStringName1<Control, Unit, StringName> =
        MethodStringName1<Control, Unit, StringName>("set_translation_context")

    @JvmField
    public val getTranslationContextName: MethodStringName0<Control, StringName> =
        MethodStringName0<Control, StringName>("get_translation_context")

    @JvmField
    public val setDefaultCursorShapeName: MethodStringName1<Control, Unit, CursorShape> =
        MethodStringName1<Control, Unit, CursorShape>("set_default_cursor_shape")

    @JvmField
    public val getDefaultCursorShapeName: MethodStringName0<Control, CursorShape> =
        MethodStringName0<Control, CursorShape>("get_default_cursor_shape")

    @JvmField
    public val getCursorShapeName: MethodStringName1<Control, CursorShape, Vector2> =
        MethodStringName1<Control, CursorShape, Vector2>("get_cursor_shape")

    @JvmField
    public val setFocusNeighborName: MethodStringName2<Control, Unit, Side, NodePath> =
        MethodStringName2<Control, Unit, Side, NodePath>("set_focus_neighbor")

    @JvmField
    public val getFocusNeighborName: MethodStringName1<Control, NodePath, Side> =
        MethodStringName1<Control, NodePath, Side>("get_focus_neighbor")

    @JvmField
    public val setFocusNextName: MethodStringName1<Control, Unit, NodePath> =
        MethodStringName1<Control, Unit, NodePath>("set_focus_next")

    @JvmField
    public val getFocusNextName: MethodStringName0<Control, NodePath> =
        MethodStringName0<Control, NodePath>("get_focus_next")

    @JvmField
    public val setFocusPreviousName: MethodStringName1<Control, Unit, NodePath> =
        MethodStringName1<Control, Unit, NodePath>("set_focus_previous")

    @JvmField
    public val getFocusPreviousName: MethodStringName0<Control, NodePath> =
        MethodStringName0<Control, NodePath>("get_focus_previous")

    @JvmField
    public val forceDragName: MethodStringName2<Control, Unit, Any?, Control?> =
        MethodStringName2<Control, Unit, Any?, Control?>("force_drag")

    @JvmField
    public val accessibilityDragName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("accessibility_drag")

    @JvmField
    public val accessibilityDropName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("accessibility_drop")

    @JvmField
    public val setAccessibilityNameName: MethodStringName1<Control, Unit, String> =
        MethodStringName1<Control, Unit, String>("set_accessibility_name")

    @JvmField
    public val getAccessibilityNameName: MethodStringName0<Control, String> =
        MethodStringName0<Control, String>("get_accessibility_name")

    @JvmField
    public val setAccessibilityDescriptionName: MethodStringName1<Control, Unit, String> =
        MethodStringName1<Control, Unit, String>("set_accessibility_description")

    @JvmField
    public val getAccessibilityDescriptionName: MethodStringName0<Control, String> =
        MethodStringName0<Control, String>("get_accessibility_description")

    @JvmField
    public val setAccessibilityLiveName:
        MethodStringName1<Control, Unit, AccessibilityServer.AccessibilityLiveMode> =
        MethodStringName1<Control, Unit, AccessibilityServer.AccessibilityLiveMode>("set_accessibility_live")

    @JvmField
    public val getAccessibilityLiveName:
        MethodStringName0<Control, AccessibilityServer.AccessibilityLiveMode> =
        MethodStringName0<Control, AccessibilityServer.AccessibilityLiveMode>("get_accessibility_live")

    @JvmField
    public val setAccessibilityControlsNodesName:
        MethodStringName1<Control, Unit, VariantArray<NodePath>> =
        MethodStringName1<Control, Unit, VariantArray<NodePath>>("set_accessibility_controls_nodes")

    @JvmField
    public val getAccessibilityControlsNodesName: MethodStringName0<Control, VariantArray<NodePath>>
        = MethodStringName0<Control, VariantArray<NodePath>>("get_accessibility_controls_nodes")

    @JvmField
    public val setAccessibilityDescribedByNodesName:
        MethodStringName1<Control, Unit, VariantArray<NodePath>> =
        MethodStringName1<Control, Unit, VariantArray<NodePath>>("set_accessibility_described_by_nodes")

    @JvmField
    public val getAccessibilityDescribedByNodesName:
        MethodStringName0<Control, VariantArray<NodePath>> =
        MethodStringName0<Control, VariantArray<NodePath>>("get_accessibility_described_by_nodes")

    @JvmField
    public val setAccessibilityLabeledByNodesName:
        MethodStringName1<Control, Unit, VariantArray<NodePath>> =
        MethodStringName1<Control, Unit, VariantArray<NodePath>>("set_accessibility_labeled_by_nodes")

    @JvmField
    public val getAccessibilityLabeledByNodesName:
        MethodStringName0<Control, VariantArray<NodePath>> =
        MethodStringName0<Control, VariantArray<NodePath>>("get_accessibility_labeled_by_nodes")

    @JvmField
    public val setAccessibilityFlowToNodesName:
        MethodStringName1<Control, Unit, VariantArray<NodePath>> =
        MethodStringName1<Control, Unit, VariantArray<NodePath>>("set_accessibility_flow_to_nodes")

    @JvmField
    public val getAccessibilityFlowToNodesName: MethodStringName0<Control, VariantArray<NodePath>> =
        MethodStringName0<Control, VariantArray<NodePath>>("get_accessibility_flow_to_nodes")

    @JvmField
    public val setMouseFilterName: MethodStringName1<Control, Unit, MouseFilter> =
        MethodStringName1<Control, Unit, MouseFilter>("set_mouse_filter")

    @JvmField
    public val getMouseFilterName: MethodStringName0<Control, MouseFilter> =
        MethodStringName0<Control, MouseFilter>("get_mouse_filter")

    @JvmField
    public val getMouseFilterWithOverrideName: MethodStringName0<Control, MouseFilter> =
        MethodStringName0<Control, MouseFilter>("get_mouse_filter_with_override")

    @JvmField
    public val setMouseBehaviorRecursiveName:
        MethodStringName1<Control, Unit, MouseBehaviorRecursive> =
        MethodStringName1<Control, Unit, MouseBehaviorRecursive>("set_mouse_behavior_recursive")

    @JvmField
    public val getMouseBehaviorRecursiveName: MethodStringName0<Control, MouseBehaviorRecursive> =
        MethodStringName0<Control, MouseBehaviorRecursive>("get_mouse_behavior_recursive")

    @JvmField
    public val setForcePassScrollEventsName: MethodStringName1<Control, Unit, Boolean> =
        MethodStringName1<Control, Unit, Boolean>("set_force_pass_scroll_events")

    @JvmField
    public val isForcePassScrollEventsName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_force_pass_scroll_events")

    @JvmField
    public val setClipContentsName: MethodStringName1<Control, Unit, Boolean> =
        MethodStringName1<Control, Unit, Boolean>("set_clip_contents")

    @JvmField
    public val isClippingContentsName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_clipping_contents")

    @JvmField
    public val grabClickFocusName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("grab_click_focus")

    @JvmField
    public val setDragForwardingName: MethodStringName3<Control, Unit, Callable, Callable, Callable>
        = MethodStringName3<Control, Unit, Callable, Callable, Callable>("set_drag_forwarding")

    @JvmField
    public val setDragPreviewName: MethodStringName1<Control, Unit, Control?> =
        MethodStringName1<Control, Unit, Control?>("set_drag_preview")

    @JvmField
    public val isDragSuccessfulName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_drag_successful")

    @JvmField
    public val warpMouseName: MethodStringName1<Control, Unit, Vector2> =
        MethodStringName1<Control, Unit, Vector2>("warp_mouse")

    @JvmField
    public val setShortcutContextName: MethodStringName1<Control, Unit, Node?> =
        MethodStringName1<Control, Unit, Node?>("set_shortcut_context")

    @JvmField
    public val getShortcutContextName: MethodStringName0<Control, Node?> =
        MethodStringName0<Control, Node?>("get_shortcut_context")

    @JvmField
    public val updateMaximumSizeName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("update_maximum_size")

    @JvmField
    public val updateMinimumSizeName: MethodStringName0<Control, Unit> =
        MethodStringName0<Control, Unit>("update_minimum_size")

    @JvmField
    public val setLayoutDirectionName: MethodStringName1<Control, Unit, LayoutDirection> =
        MethodStringName1<Control, Unit, LayoutDirection>("set_layout_direction")

    @JvmField
    public val getLayoutDirectionName: MethodStringName0<Control, LayoutDirection> =
        MethodStringName0<Control, LayoutDirection>("get_layout_direction")

    @JvmField
    public val isLayoutRtlName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_layout_rtl")

    @JvmField
    public val setAutoTranslateName: MethodStringName1<Control, Unit, Boolean> =
        MethodStringName1<Control, Unit, Boolean>("set_auto_translate")

    @JvmField
    public val isAutoTranslatingName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_auto_translating")

    @JvmField
    public val setLocalizeNumeralSystemName: MethodStringName1<Control, Unit, Boolean> =
        MethodStringName1<Control, Unit, Boolean>("set_localize_numeral_system")

    @JvmField
    public val isLocalizingNumeralSystemName: MethodStringName0<Control, Boolean> =
        MethodStringName0<Control, Boolean>("is_localizing_numeral_system")

    /**
     * Sent when the node changes size. Use [size] to get the new size.
     */
    public final const val NOTIFICATION_RESIZED: Long = 40

    /**
     * Sent when the mouse cursor enters the control's (or any child control's) visible area, that
     * is not occluded behind other Controls or Windows, provided its [mouseFilter] lets the event
     * reach it and regardless if it's currently focused or not.
     *
     * **Note:** [CanvasItem.zIndex] doesn't affect which Control receives the notification.
     *
     * See also [NOTIFICATION_MOUSE_ENTER_SELF].
     */
    public final const val NOTIFICATION_MOUSE_ENTER: Long = 41

    /**
     * Sent when the mouse cursor leaves the control's (and all child control's) visible area, that
     * is not occluded behind other Controls or Windows, provided its [mouseFilter] lets the event
     * reach it and regardless if it's currently focused or not.
     *
     * **Note:** [CanvasItem.zIndex] doesn't affect which Control receives the notification.
     *
     * See also [NOTIFICATION_MOUSE_EXIT_SELF].
     */
    public final const val NOTIFICATION_MOUSE_EXIT: Long = 42

    /**
     * Sent when the mouse cursor enters the control's visible area, that is not occluded behind
     * other Controls or Windows, provided its [mouseFilter] lets the event reach it and regardless if
     * it's currently focused or not.
     *
     * **Note:** [CanvasItem.zIndex] doesn't affect which Control receives the notification.
     *
     * See also [NOTIFICATION_MOUSE_ENTER].
     */
    public final const val NOTIFICATION_MOUSE_ENTER_SELF: Long = 60

    /**
     * Sent when the mouse cursor leaves the control's visible area, that is not occluded behind
     * other Controls or Windows, provided its [mouseFilter] lets the event reach it and regardless if
     * it's currently focused or not.
     *
     * **Note:** [CanvasItem.zIndex] doesn't affect which Control receives the notification.
     *
     * See also [NOTIFICATION_MOUSE_EXIT].
     */
    public final const val NOTIFICATION_MOUSE_EXIT_SELF: Long = 61

    /**
     * Sent when the node grabs focus.
     */
    public final const val NOTIFICATION_FOCUS_ENTER: Long = 43

    /**
     * Sent when the node loses focus.
     *
     * This notification is sent in reversed order.
     */
    public final const val NOTIFICATION_FOCUS_EXIT: Long = 44

    /**
     * Sent when the node needs to refresh its theme items. This happens in one of the following
     * cases:
     *
     * - The [theme] property is changed on this node or any of its ancestors.
     *
     * - The [themeTypeVariation] property is changed on this node.
     *
     * - One of the node's theme property overrides is changed.
     *
     * - The node enters the scene tree.
     *
     * **Note:** As an optimization, this notification won't be sent from changes that occur while
     * this node is outside of the scene tree. Instead, all of the theme item updates can be applied at
     * once when the node enters the scene tree.
     *
     * **Note:** This notification is received alongside [Node.NOTIFICATION_ENTER_TREE], so if you
     * are instantiating a scene, the child nodes will not be initialized yet. You can use it to setup
     * theming for this node, child nodes created from script, or if you want to access child nodes
     * added in the editor, make sure the node is ready using [Node.isNodeReady].
     *
     * ```
     * func _notification(what):
     * 	if what == NOTIFICATION_THEME_CHANGED:
     * 		if not is_node_ready():
     * 			await ready # Wait until ready signal.
     * 		$Label.add_theme_color_override("font_color", Color.YELLOW)
     * ```
     */
    public final const val NOTIFICATION_THEME_CHANGED: Long = 45

    /**
     * Sent when this node is inside a [ScrollContainer] which has begun being scrolled when
     * dragging the scrollable area *with a touch event*. This notification is *not* sent when
     * scrolling by dragging the scrollbar, scrolling with the mouse wheel or scrolling with
     * keyboard/gamepad events.
     *
     * **Note:** This signal is only emitted on Android or iOS, or on desktop/web platforms when
     * [ProjectSettings.inputDevices/pointing/emulateTouchFromMouse] is enabled.
     */
    public final const val NOTIFICATION_SCROLL_BEGIN: Long = 47

    /**
     * Sent when this node is inside a [ScrollContainer] which has stopped being scrolled when
     * dragging the scrollable area *with a touch event*. This notification is *not* sent when
     * scrolling by dragging the scrollbar, scrolling with the mouse wheel or scrolling with
     * keyboard/gamepad events.
     *
     * **Note:** This signal is only emitted on Android or iOS, or on desktop/web platforms when
     * [ProjectSettings.inputDevices/pointing/emulateTouchFromMouse] is enabled.
     */
    public final const val NOTIFICATION_SCROLL_END: Long = 48

    /**
     * Sent when the control layout direction is changed from LTR or RTL or vice versa. This
     * notification is propagated to child Control nodes as result of a change to [layoutDirection].
     */
    public final const val NOTIFICATION_LAYOUT_DIRECTION_CHANGED: Long = 49
  }

  public object MethodBindings {
    internal val acceptEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "accept_event", 3218959716)

    internal val getMaximumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_maximum_size", 3341600327)

    internal val getCombinedMaximumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_combined_maximum_size", 3341600327)

    internal val getMinimumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_minimum_size", 3341600327)

    internal val getCombinedMinimumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_combined_minimum_size", 3341600327)

    internal val setPropagateMaximumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_propagate_maximum_size", 2586408642)

    internal val isPropagatingMaximumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_propagating_maximum_size", 2240911060)

    internal val getBoundMinimumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_bound_minimum_size", 3341600327)

    internal val setAnchorsPresetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_anchors_preset", 509135270)

    internal val setOffsetsPresetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offsets_preset", 3724524307)

    internal val setAnchorsAndOffsetsPresetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_anchors_and_offsets_preset", 3724524307)

    internal val setAnchorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_anchor", 2302782885)

    internal val getAnchorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_anchor", 2869120046)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset", 4290182280)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_offset", 2869120046)

    internal val setAnchorAndOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_anchor_and_offset", 4031722181)

    internal val setBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_begin", 743155724)

    internal val setEndPtr: VoidPtr = TypeManager.getMethodBindPtr("Control", "set_end", 743155724)

    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_position", 2436320129)

    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_size", 2436320129)

    internal val resetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "reset_size", 3218959716)

    internal val setCustomMaximumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_custom_maximum_size", 743155724)

    internal val setCustomMinimumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_custom_minimum_size", 743155724)

    internal val setGlobalPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_global_position", 2436320129)

    internal val setRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_rotation", 373806689)

    internal val setRotationDegreesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_rotation_degrees", 373806689)

    internal val setScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_scale", 743155724)

    internal val setPivotOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_pivot_offset", 743155724)

    internal val setPivotOffsetRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_pivot_offset_ratio", 743155724)

    internal val getBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_begin", 3341600327)

    internal val getEndPtr: VoidPtr = TypeManager.getMethodBindPtr("Control", "get_end", 3341600327)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_position", 3341600327)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_size", 3341600327)

    internal val getRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_rotation", 1740695150)

    internal val getRotationDegreesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_rotation_degrees", 1740695150)

    internal val getScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_scale", 3341600327)

    internal val getPivotOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_pivot_offset", 3341600327)

    internal val getPivotOffsetRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_pivot_offset_ratio", 3341600327)

    internal val getCombinedPivotOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_combined_pivot_offset", 3341600327)

    internal val getCustomMaximumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_custom_maximum_size", 3341600327)

    internal val getCustomMinimumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_custom_minimum_size", 3341600327)

    internal val getParentAreaSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_parent_area_size", 3341600327)

    internal val getGlobalPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_global_position", 3341600327)

    internal val getScreenPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_screen_position", 3341600327)

    internal val getRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_rect", 1639390495)

    internal val getGlobalRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_global_rect", 1639390495)

    internal val setFocusModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_focus_mode", 3232914922)

    internal val getFocusModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_focus_mode", 2132829277)

    internal val getFocusModeWithOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_focus_mode_with_override", 2132829277)

    internal val setFocusBehaviorRecursivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_focus_behavior_recursive", 4256832521)

    internal val getFocusBehaviorRecursivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_focus_behavior_recursive", 2435707181)

    internal val hasFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_focus", 3302206351)

    internal val grabFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "grab_focus", 107499316)

    internal val releaseFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "release_focus", 3218959716)

    internal val findPrevValidFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "find_prev_valid_focus", 2783021301)

    internal val findNextValidFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "find_next_valid_focus", 2783021301)

    internal val findValidFocusNeighborPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "find_valid_focus_neighbor", 1543910170)

    internal val setHSizeFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_h_size_flags", 394851643)

    internal val getHSizeFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_h_size_flags", 3781367401)

    internal val setStretchRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_stretch_ratio", 373806689)

    internal val getStretchRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_stretch_ratio", 1740695150)

    internal val setVSizeFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_v_size_flags", 394851643)

    internal val getVSizeFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_v_size_flags", 3781367401)

    internal val setOffsetTransformEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset_transform_enabled", 2586408642)

    internal val isOffsetTransformEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_offset_transform_enabled", 36873697)

    internal val setOffsetTransformPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset_transform_position", 743155724)

    internal val getOffsetTransformPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_offset_transform_position", 3341600327)

    internal val setOffsetTransformPositionRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset_transform_position_ratio", 743155724)

    internal val getOffsetTransformPositionRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_offset_transform_position_ratio", 3341600327)

    internal val setOffsetTransformScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset_transform_scale", 743155724)

    internal val getOffsetTransformScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_offset_transform_scale", 3341600327)

    internal val setOffsetTransformRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset_transform_rotation", 373806689)

    internal val getOffsetTransformRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_offset_transform_rotation", 1740695150)

    internal val setOffsetTransformPivotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset_transform_pivot", 743155724)

    internal val getOffsetTransformPivotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_offset_transform_pivot", 3341600327)

    internal val setOffsetTransformPivotRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset_transform_pivot_ratio", 743155724)

    internal val getOffsetTransformPivotRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_offset_transform_pivot_ratio", 3341600327)

    internal val setOffsetTransformVisualOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_offset_transform_visual_only", 2586408642)

    internal val isOffsetTransformVisualOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_offset_transform_visual_only", 36873697)

    internal val setThemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_theme", 2326690814)

    internal val getThemePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme", 3846893731)

    internal val setThemeTypeVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_theme_type_variation", 3304788590)

    internal val getThemeTypeVariationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_type_variation", 2002593661)

    internal val beginBulkThemeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "begin_bulk_theme_override", 3218959716)

    internal val endBulkThemeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "end_bulk_theme_override", 3218959716)

    internal val addThemeIconOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "add_theme_icon_override", 1373065600)

    internal val addThemeStyleboxOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "add_theme_stylebox_override", 4188838905)

    internal val addThemeFontOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "add_theme_font_override", 3518018674)

    internal val addThemeFontSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "add_theme_font_size_override", 2415702435)

    internal val addThemeColorOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "add_theme_color_override", 4260178595)

    internal val addThemeConstantOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "add_theme_constant_override", 2415702435)

    internal val removeThemeIconOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "remove_theme_icon_override", 3304788590)

    internal val removeThemeStyleboxOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "remove_theme_stylebox_override", 3304788590)

    internal val removeThemeFontOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "remove_theme_font_override", 3304788590)

    internal val removeThemeFontSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "remove_theme_font_size_override", 3304788590)

    internal val removeThemeColorOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "remove_theme_color_override", 3304788590)

    internal val removeThemeConstantOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "remove_theme_constant_override", 3304788590)

    internal val getThemeIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_icon", 3163973443)

    internal val getThemeStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_stylebox", 604739069)

    internal val getThemeFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_font", 2826986490)

    internal val getThemeFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_font_size", 1327056374)

    internal val getThemeColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_color", 2798751242)

    internal val getThemeConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_constant", 1327056374)

    internal val hasThemeIconOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_icon_override", 2619796661)

    internal val hasThemeStyleboxOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_stylebox_override", 2619796661)

    internal val hasThemeFontOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_font_override", 2619796661)

    internal val hasThemeFontSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_font_size_override", 2619796661)

    internal val hasThemeColorOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_color_override", 2619796661)

    internal val hasThemeConstantOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_constant_override", 2619796661)

    internal val hasThemeIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_icon", 866386512)

    internal val hasThemeStyleboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_stylebox", 866386512)

    internal val hasThemeFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_font", 866386512)

    internal val hasThemeFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_font_size", 866386512)

    internal val hasThemeColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_color", 866386512)

    internal val hasThemeConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "has_theme_constant", 866386512)

    internal val getThemeDefaultBaseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_default_base_scale", 1740695150)

    internal val getThemeDefaultFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_default_font", 3229501585)

    internal val getThemeDefaultFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_theme_default_font_size", 3905245786)

    internal val getParentControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_parent_control", 2783021301)

    internal val setHGrowDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_h_grow_direction", 2022385301)

    internal val getHGrowDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_h_grow_direction", 3635610155)

    internal val setVGrowDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_v_grow_direction", 2022385301)

    internal val getVGrowDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_v_grow_direction", 3635610155)

    internal val setTooltipAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_tooltip_auto_translate_mode", 776149714)

    internal val getTooltipAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_tooltip_auto_translate_mode", 2498906432)

    internal val setTooltipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_tooltip_text", 83702148)

    internal val getTooltipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_tooltip_text", 201670096)

    internal val getTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_tooltip", 2895288280)

    internal val setTranslationContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_translation_context", 3304788590)

    internal val getTranslationContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_translation_context", 2002593661)

    internal val setDefaultCursorShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_default_cursor_shape", 217062046)

    internal val getDefaultCursorShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_default_cursor_shape", 2359535750)

    internal val getCursorShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_cursor_shape", 1395773853)

    internal val setFocusNeighborPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_focus_neighbor", 2024461774)

    internal val getFocusNeighborPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_focus_neighbor", 2757935761)

    internal val setFocusNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_focus_next", 1348162250)

    internal val getFocusNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_focus_next", 4075236667)

    internal val setFocusPreviousPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_focus_previous", 1348162250)

    internal val getFocusPreviousPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_focus_previous", 4075236667)

    internal val forceDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "force_drag", 3191844692)

    internal val accessibilityDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "accessibility_drag", 3218959716)

    internal val accessibilityDropPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "accessibility_drop", 3218959716)

    internal val setAccessibilityNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_accessibility_name", 83702148)

    internal val getAccessibilityNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_accessibility_name", 201670096)

    internal val setAccessibilityDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_accessibility_description", 83702148)

    internal val getAccessibilityDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_accessibility_description", 201670096)

    internal val setAccessibilityLivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_accessibility_live", 353443434)

    internal val getAccessibilityLivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_accessibility_live", 2858591811)

    internal val setAccessibilityControlsNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_accessibility_controls_nodes", 381264803)

    internal val getAccessibilityControlsNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_accessibility_controls_nodes", 3995934104)

    internal val setAccessibilityDescribedByNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_accessibility_described_by_nodes", 381264803)

    internal val getAccessibilityDescribedByNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_accessibility_described_by_nodes", 3995934104)

    internal val setAccessibilityLabeledByNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_accessibility_labeled_by_nodes", 381264803)

    internal val getAccessibilityLabeledByNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_accessibility_labeled_by_nodes", 3995934104)

    internal val setAccessibilityFlowToNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_accessibility_flow_to_nodes", 381264803)

    internal val getAccessibilityFlowToNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_accessibility_flow_to_nodes", 3995934104)

    internal val setMouseFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_mouse_filter", 3891156122)

    internal val getMouseFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_mouse_filter", 1572545674)

    internal val getMouseFilterWithOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_mouse_filter_with_override", 1572545674)

    internal val setMouseBehaviorRecursivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_mouse_behavior_recursive", 849284636)

    internal val getMouseBehaviorRecursivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_mouse_behavior_recursive", 3779367402)

    internal val setForcePassScrollEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_force_pass_scroll_events", 2586408642)

    internal val isForcePassScrollEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_force_pass_scroll_events", 36873697)

    internal val setClipContentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_clip_contents", 2586408642)

    internal val isClippingContentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_clipping_contents", 2240911060)

    internal val grabClickFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "grab_click_focus", 3218959716)

    internal val setDragForwardingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_drag_forwarding", 1076571380)

    internal val setDragPreviewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_drag_preview", 1496901182)

    internal val isDragSuccessfulPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_drag_successful", 36873697)

    internal val warpMousePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "warp_mouse", 743155724)

    internal val setShortcutContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_shortcut_context", 1078189570)

    internal val getShortcutContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_shortcut_context", 3160264692)

    internal val updateMaximumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "update_maximum_size", 3218959716)

    internal val updateMinimumSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "update_minimum_size", 3218959716)

    internal val setLayoutDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_layout_direction", 3310692370)

    internal val getLayoutDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "get_layout_direction", 1546772008)

    internal val isLayoutRtlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_layout_rtl", 36873697)

    internal val setAutoTranslatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_auto_translate", 2586408642)

    internal val isAutoTranslatingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_auto_translating", 36873697)

    internal val setLocalizeNumeralSystemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "set_localize_numeral_system", 2586408642)

    internal val isLocalizingNumeralSystemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Control", "is_localizing_numeral_system", 36873697)
  }
}
