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
import godot.core.Color
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName11
import godot.core.MethodStringName12
import godot.core.MethodStringName13
import godot.core.MethodStringName14
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.MethodStringName8
import godot.core.MethodStringName9
import godot.core.PackedColorArray
import godot.core.PackedVector2Array
import godot.core.RID
import godot.core.Rect2
import godot.core.Signal0
import godot.core.StringName
import godot.core.Transform2D
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser._RID
import godot.core.Vector2
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

/**
 * Abstract base class for everything in 2D space. Canvas items are laid out in a tree; children
 * inherit and extend their parent's transform. [CanvasItem] is extended by [Control] for GUI-related
 * nodes, and by [Node2D] for 2D game objects.
 *
 * Any [CanvasItem] can draw. For this, [queueRedraw] is called by the engine, then
 * [NOTIFICATION_DRAW] will be received on idle time to request a redraw. Because of this, canvas items
 * don't need to be redrawn on every frame, improving the performance significantly. Several functions
 * for drawing on the [CanvasItem] are provided (see `draw_*` functions). However, they can only be
 * used inside [_draw], its corresponding [Object.Notification] or methods connected to the [signal
 * draw] signal.
 *
 * Canvas items are drawn in tree order on their canvas layer. By default, children are on top of
 * their parents, so a root [CanvasItem] will be drawn behind everything. This behavior can be changed
 * on a per-item basis.
 *
 * A [CanvasItem] can be hidden, which will also hide its children. By adjusting various other
 * properties of a [CanvasItem], you can also modulate its color (via [modulate] or [selfModulate]),
 * change its Z-index, blend mode, and more.
 *
 * Note that properties like transform, modulation, and visibility are only propagated to *direct*
 * [CanvasItem] child nodes. If there is a non-[CanvasItem] node in between, like [Node] or
 * [AnimationPlayer], the [CanvasItem] nodes below will have an independent position and [modulate]
 * chain. See also [topLevel].
 */
@GodotBaseType
public open class CanvasItem internal constructor() : Node() {
  /**
   * Emitted when the [CanvasItem] must redraw, *after* the related [NOTIFICATION_DRAW]
   * notification, and *before* [_draw] is called.
   *
   * **Note:** Deferred connections do not allow drawing through the `draw_*` methods.
   */
  public val draw: Signal0 by Signal0

  /**
   * Emitted when the [CanvasItem]'s visibility changes, either because its own [visible] property
   * changed or because its visibility in the tree changed (see [isVisibleInTree]).
   *
   * This signal is emitted *after* the related [NOTIFICATION_VISIBILITY_CHANGED] notification.
   */
  public val visibilityChanged: Signal0 by Signal0

  /**
   * Emitted when this node becomes hidden, i.e. it's no longer visible in the tree (see
   * [isVisibleInTree]).
   */
  public val hidden: Signal0 by Signal0

  /**
   * Emitted when the [CanvasItem]'s boundaries (position or size) change, or when an action took
   * place that may have affected these boundaries (e.g. changing [Sprite2D.texture]).
   */
  public val itemRectChanged: Signal0 by Signal0

  /**
   * If `true`, this [CanvasItem] may be drawn. Whether this [CanvasItem] is actually drawn depends
   * on the visibility of all of its [CanvasItem] ancestors. In other words: this [CanvasItem] will be
   * drawn when [isVisibleInTree] returns `true` and all [CanvasItem] ancestors share at least one
   * [visibilityLayer] with this [CanvasItem].
   *
   * **Note:** For controls that inherit [Popup], the correct way to make them visible is to call
   * one of the multiple `popup*()` functions instead.
   */
  public final inline var visible: Boolean
    @JvmName("visibleProperty")
    get() = isVisible()
    @JvmName("visibleProperty")
    set(`value`) {
      setVisible(value)
    }

  /**
   * The color applied to this [CanvasItem]. This property does affect child [CanvasItem]s, unlike
   * [selfModulate] which only affects the node itself.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var modulate: Color
    @JvmName("modulateProperty")
    get() = getModulate()
    @JvmName("modulateProperty")
    set(`value`) {
      setModulate(value)
    }

  /**
   * The color applied to this [CanvasItem]. This property does **not** affect child [CanvasItem]s,
   * unlike [modulate] which affects both the node itself and its children.
   *
   * **Note:** Internal children are also not affected by this property (see the `include_internal`
   * parameter in [Node.addChild]). For built-in nodes this includes sliders in [ColorPicker], and the
   * tab bar in [TabContainer].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var selfModulate: Color
    @JvmName("selfModulateProperty")
    get() = getSelfModulate()
    @JvmName("selfModulateProperty")
    set(`value`) {
      setSelfModulate(value)
    }

  /**
   * If `true`, this node draws behind its parent.
   */
  public final inline var showBehindParent: Boolean
    @JvmName("showBehindParentProperty")
    get() = isDrawBehindParentEnabled()
    @JvmName("showBehindParentProperty")
    set(`value`) {
      setDrawBehindParent(value)
    }

  /**
   * If `true`, this [CanvasItem] will *not* inherit its transform from parent [CanvasItem]s. Its
   * draw order will also be changed to make it draw on top of other [CanvasItem]s that do not have
   * [topLevel] set to `true`. The [CanvasItem] will effectively act as if it was placed as a child of
   * a bare [Node].
   */
  public final inline var topLevel: Boolean
    @JvmName("topLevelProperty")
    get() = isSetAsTopLevel()
    @JvmName("topLevelProperty")
    set(`value`) {
      setAsTopLevel(value)
    }

  /**
   * The mode in which this node clips its children, acting as a mask.
   *
   * **Note:** Clipping nodes cannot be nested or placed within a [CanvasGroup]. If an ancestor of
   * this node clips its children or is a [CanvasGroup], then this node's clip mode should be set to
   * [CLIP_CHILDREN_DISABLED] to avoid unexpected behavior.
   */
  public final inline var clipChildren: ClipChildrenMode
    @JvmName("clipChildrenProperty")
    get() = getClipChildrenMode()
    @JvmName("clipChildrenProperty")
    set(`value`) {
      setClipChildrenMode(value)
    }

  /**
   * If enabled, oversampling for this [CanvasItem] is automatically adjusted with scale.
   */
  public final inline var oversamplingWithScale: OversamplingWithScale
    @JvmName("oversamplingWithScaleProperty")
    get() = getOversamplingWithScale()
    @JvmName("oversamplingWithScaleProperty")
    set(`value`) {
      setOversamplingWithScale(value)
    }

  /**
   * The rendering layers in which this [CanvasItem] responds to [Light2D] nodes.
   */
  public final inline var lightMask: Int
    @JvmName("lightMaskProperty")
    get() = getLightMask()
    @JvmName("lightMaskProperty")
    set(`value`) {
      setLightMask(value)
    }

  /**
   * The rendering layer in which this [CanvasItem] is rendered by [Viewport] nodes. A [Viewport]
   * will render a [CanvasItem] if it and all its parents share a layer with the [Viewport]'s canvas
   * cull mask.
   *
   * **Note:** A [CanvasItem] does not inherit its parents' visibility layers. This means that if a
   * parent [CanvasItem] does not have all the same layers as its child, the child may not be visible
   * even if both the parent and child have [visible] set to `true`. For example, if a parent has layer
   * 1 and a child has layer 2, the child will not be visible in a [Viewport] with the canvas cull mask
   * set to layer 1 or 2 (see [Viewport.canvasCullMask]). To ensure that both the parent and child are
   * visible, the parent must have both layers 1 and 2, or the child must have [topLevel] set to
   * `true`.
   */
  public final inline var visibilityLayer: Long
    @JvmName("visibilityLayerProperty")
    get() = getVisibilityLayer()
    @JvmName("visibilityLayerProperty")
    set(`value`) {
      setVisibilityLayer(value)
    }

  /**
   * The order in which this node is drawn. A node with a higher Z index will display in front of
   * others. Must be between [RenderingServer.CANVAS_ITEM_Z_MIN] and
   * [RenderingServer.CANVAS_ITEM_Z_MAX] (inclusive).
   *
   * **Note:** The Z index does **not** affect the order in which [CanvasItem] nodes are processed
   * or the way input events are handled. This is especially important to keep in mind for [Control]
   * nodes.
   */
  public final inline var zIndex: Int
    @JvmName("zIndexProperty")
    get() = getZIndex()
    @JvmName("zIndexProperty")
    set(`value`) {
      setZIndex(value)
    }

  /**
   * If `true`, this node's final Z index is relative to its parent's Z index.
   *
   * For example, if [zIndex] is `2` and its parent's final Z index is `3`, then this node's final Z
   * index will be `5` (`2 + 3`).
   */
  public final inline var zAsRelative: Boolean
    @JvmName("zAsRelativeProperty")
    get() = isZRelative()
    @JvmName("zAsRelativeProperty")
    set(`value`) {
      setZAsRelative(value)
    }

  /**
   * If `true`, this and child [CanvasItem] nodes with a higher Y position are rendered in front of
   * nodes with a lower Y position. If `false`, this and child [CanvasItem] nodes are rendered normally
   * in scene tree order.
   *
   * With Y-sorting enabled on a parent node ('A') but disabled on a child node ('B'), the child
   * node ('B') is sorted but its children ('C1', 'C2', etc.) render together on the same Y position as
   * the child node ('B'). This allows you to organize the render order of a scene without changing the
   * scene tree.
   *
   * Nodes sort relative to each other only if they are on the same [zIndex].
   */
  public final inline var ySortEnabled: Boolean
    @JvmName("ySortEnabledProperty")
    get() = isYSortEnabled()
    @JvmName("ySortEnabledProperty")
    set(`value`) {
      setYSortEnabled(value)
    }

  /**
   * The filtering mode used to render this [CanvasItem]'s texture(s).
   */
  public final inline var textureFilter: TextureFilter
    @JvmName("textureFilterProperty")
    get() = getTextureFilter()
    @JvmName("textureFilterProperty")
    set(`value`) {
      setTextureFilter(value)
    }

  /**
   * The repeating mode used to render this [CanvasItem]'s texture(s). It affects what happens when
   * the texture is sampled outside its extents, for example by setting a [Sprite2D.regionRect] that is
   * larger than the texture or assigning [Polygon2D] UV points outside the texture.
   *
   * **Note:** [TextureRect] is not affected by [textureRepeat], as it uses its own texture
   * repeating implementation.
   */
  public final inline var textureRepeat: TextureRepeat
    @JvmName("textureRepeatProperty")
    get() = getTextureRepeat()
    @JvmName("textureRepeatProperty")
    set(`value`) {
      setTextureRepeat(value)
    }

  /**
   * The material applied to this [CanvasItem].
   */
  public final inline var material: Material?
    @JvmName("materialProperty")
    get() = getMaterial()
    @JvmName("materialProperty")
    set(`value`) {
      setMaterial(value)
    }

  /**
   * If `true`, the parent [CanvasItem]'s [material] is used as this node's material.
   */
  public final inline var useParentMaterial: Boolean
    @JvmName("useParentMaterialProperty")
    get() = getUseParentMaterial()
    @JvmName("useParentMaterialProperty")
    set(`value`) {
      setUseParentMaterial(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(144, scriptPtr)
  }

  /**
   * This is a helper function for [modulate] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = canvasitem.modulate
   * //Your changes
   * canvasitem.modulate = myCoreType
   * ``````
   *
   * The color applied to this [CanvasItem]. This property does affect child [CanvasItem]s, unlike
   * [selfModulate] which only affects the node itself.
   */
  @CoreTypeHelper
  public final fun modulateMutate(block: Color.() -> Unit): Color = modulate.apply {
     block(this)
     modulate = this
  }

  /**
   * This is a helper function for [selfModulate] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = canvasitem.selfModulate
   * //Your changes
   * canvasitem.selfModulate = myCoreType
   * ``````
   *
   * The color applied to this [CanvasItem]. This property does **not** affect child [CanvasItem]s,
   * unlike [modulate] which affects both the node itself and its children.
   *
   * **Note:** Internal children are also not affected by this property (see the `include_internal`
   * parameter in [Node.addChild]). For built-in nodes this includes sliders in [ColorPicker], and the
   * tab bar in [TabContainer].
   */
  @CoreTypeHelper
  public final fun selfModulateMutate(block: Color.() -> Unit): Color = selfModulate.apply {
     block(this)
     selfModulate = this
  }

  /**
   * Called when [CanvasItem] has been requested to redraw (after [queueRedraw] is called, either
   * manually or by the engine).
   *
   * Corresponds to the [NOTIFICATION_DRAW] notification in [Object.Notification].
   */
  public open fun _draw(): Unit {
    throw NotImplementedError("CanvasItem::_draw is not implemented.")
  }

  /**
   * Returns the internal canvas item [RID] used by the [RenderingServer] for this node.
   */
  public final fun getCanvasItem(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasItemPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public final fun setVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setVisiblePtr)
  }

  public final fun isVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the node is present in the [SceneTree], its [visible] property is `true` and
   * all its ancestors are also visible. If any ancestor is hidden, this node will not be visible in
   * the scene tree, and is therefore not drawn (see [_draw]).
   *
   * Visibility is checked only in parent nodes that inherit from [CanvasItem], [CanvasLayer], and
   * [Window]. If the parent is of any other type (such as [Node], [AnimationPlayer], or [Node3D]), it
   * is assumed to be visible.
   *
   * **Note:** This method does not take [visibilityLayer] into account, so even if this method
   * returns `true`, the node might end up not being rendered.
   */
  public final fun isVisibleInTree(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVisibleInTreePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Show the [CanvasItem] if it's currently hidden. This is equivalent to setting [visible] to
   * `true`.
   *
   * **Note:** For controls that inherit [Popup], the correct way to make them visible is to call
   * one of the multiple `popup*()` functions instead.
   */
  public final fun show(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.showPtr)
  }

  /**
   * Hide the [CanvasItem] if it's currently visible. This is equivalent to setting [visible] to
   * `false`.
   */
  public final fun hide(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hidePtr)
  }

  /**
   * Queues the [CanvasItem] to redraw. During idle time, if [CanvasItem] is visible,
   * [NOTIFICATION_DRAW] is sent and [_draw] is called. This only occurs **once** per frame, even if
   * this method has been called multiple times.
   */
  public final fun queueRedraw(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.queueRedrawPtr)
  }

  /**
   * Moves this node below its siblings, usually causing the node to draw on top of its siblings.
   * Does nothing if this node does not have a parent. See also [Node.moveChild].
   */
  public final fun moveToFront(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.moveToFrontPtr)
  }

  public final fun setAsTopLevel(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAsTopLevelPtr)
  }

  public final fun isSetAsTopLevel(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSetAsTopLevelPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLightMask(lightMask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to lightMask.toLong())
    TransferContext.callMethod(MethodBindings.setLightMaskPtr)
  }

  public final fun getLightMask(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLightMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setModulate(modulate: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to modulate)
    TransferContext.callMethod(MethodBindings.setModulatePtr)
  }

  public final fun getModulate(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModulatePtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setSelfModulate(selfModulate: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to selfModulate)
    TransferContext.callMethod(MethodBindings.setSelfModulatePtr)
  }

  public final fun getSelfModulate(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelfModulatePtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setZIndex(zIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to zIndex.toLong())
    TransferContext.callMethod(MethodBindings.setZIndexPtr)
  }

  public final fun getZIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getZIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setZAsRelative(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setZAsRelativePtr)
  }

  public final fun isZRelative(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isZRelativePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setYSortEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setYSortEnabledPtr)
  }

  public final fun isYSortEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isYSortEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDrawBehindParent(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDrawBehindParentPtr)
  }

  public final fun isDrawBehindParentEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawBehindParentEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Draws a line from a 2D point to another, with a given color and width. It can be optionally
   * antialiased. The [from] and [to] positions are defined in local space. See also [drawDashedLine],
   * [drawMultiline], and [drawPolyline].
   *
   * If [width] is negative, then a two-point primitive will be drawn instead of a four-point one.
   * This means that when the CanvasItem is scaled, the line will remain thin. If this behavior is not
   * desired, then pass a positive [width] like `1.0`.
   */
  @JvmOverloads
  public final fun drawLine(
    from: Vector2,
    to: Vector2,
    color: Color,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to from, VECTOR2 to to, COLOR to color, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawLinePtr)
  }

  /**
   * Draws a dashed line from a 2D point to another, with a given color and width. The [from] and
   * [to] positions are defined in local space. See also [drawLine], [drawMultiline], and
   * [drawPolyline].
   *
   * If [width] is negative, then a two-point primitives will be drawn instead of a four-point ones.
   * This means that when the CanvasItem is scaled, the line parts will remain thin. If this behavior
   * is not desired, then pass a positive [width] like `1.0`.
   *
   * [dash] is the length of each dash in pixels, with the gap between each dash being the same
   * length. If [aligned] is `true`, the length of the first and last dashes may be shortened or
   * lengthened to allow the line to begin and end at the precise points defined by [from] and [to].
   * Both ends are always symmetrical when [aligned] is `true`. If [aligned] is `false`, all dashes
   * will have the same length, but the line may appear incomplete at the end due to the dash length
   * not dividing evenly into the line length. Only full dashes are drawn when [aligned] is `false`.
   *
   * If [antialiased] is `true`, half transparent "feathers" will be attached to the boundary,
   * making outlines smooth.
   *
   * **Note:** [antialiased] is only effective if [width] is greater than `0.0`.
   */
  @JvmOverloads
  public final fun drawDashedLine(
    from: Vector2,
    to: Vector2,
    color: Color,
    width: Float = -1.0f,
    dash: Float = 2.0f,
    aligned: Boolean = true,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to from, VECTOR2 to to, COLOR to color, DOUBLE to width.toDouble(), DOUBLE to dash.toDouble(), BOOL to aligned, BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawDashedLinePtr)
  }

  /**
   * Draws interconnected line segments with a uniform [color] and [width] and optional antialiasing
   * (supported only for positive [width]). The [points] array is defined in local space. When drawing
   * large amounts of lines, this is faster than using individual [drawLine] calls. To draw
   * disconnected lines, use [drawMultiline] instead. See also [drawPolygon].
   *
   * If [width] is negative, it will be ignored and the polyline will be drawn using
   * [RenderingServer.PRIMITIVE_LINE_STRIP]. This means that when the CanvasItem is scaled, the
   * polyline will remain thin. If this behavior is not desired, then pass a positive [width] like
   * `1.0`.
   */
  @JvmOverloads
  public final fun drawPolyline(
    points: PackedVector2Array,
    color: Color,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points, COLOR to color, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawPolylinePtr)
  }

  /**
   * Draws interconnected line segments with a uniform [width], point-by-point coloring, and
   * optional antialiasing (supported only for positive [width]). Colors assigned to line points match
   * by index between [points] and [colors], i.e. each line segment is filled with a gradient between
   * the colors of the endpoints. The [points] array is defined in local space. When drawing large
   * amounts of lines, this is faster than using individual [drawLine] calls. To draw disconnected
   * lines, use [drawMultilineColors] instead. See also [drawPolygon].
   *
   * If [width] is negative, it will be ignored and the polyline will be drawn using
   * [RenderingServer.PRIMITIVE_LINE_STRIP]. This means that when the CanvasItem is scaled, the
   * polyline will remain thin. If this behavior is not desired, then pass a positive [width] like
   * `1.0`.
   */
  @JvmOverloads
  public final fun drawPolylineColors(
    points: PackedVector2Array,
    colors: PackedColorArray,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawPolylineColorsPtr)
  }

  /**
   * Draws an unfilled elliptical arc between the given angles with a uniform [color] and [width]
   * and optional antialiasing (supported only for positive [width]). The larger the value of
   * [pointCount], the smoother the curve. For circular arcs, see [drawArc]. See also [drawEllipse].
   *
   * If [width] is negative, it will be ignored and the arc will be drawn using
   * [RenderingServer.PRIMITIVE_LINE_STRIP]. This means that when the CanvasItem is scaled, the arc
   * will remain thin. If this behavior is not desired, then pass a positive [width] like `1.0`.
   *
   * The arc is drawn from [startAngle] towards the value of [endAngle] so in clockwise direction if
   * `start_angle < end_angle` and counter-clockwise otherwise. Passing the same angles but in reversed
   * order will produce the same arc. If absolute difference of [startAngle] and [endAngle] is greater
   * than [@GDScript.TAU] radians, then a full ellipse is drawn (i.e. arc will not overlap itself).
   */
  @JvmOverloads
  public final fun drawEllipseArc(
    center: Vector2,
    major: Float,
    minor: Float,
    startAngle: Float,
    endAngle: Float,
    pointCount: Int,
    color: Color,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to center, DOUBLE to major.toDouble(), DOUBLE to minor.toDouble(), DOUBLE to startAngle.toDouble(), DOUBLE to endAngle.toDouble(), LONG to pointCount.toLong(), COLOR to color, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawEllipseArcPtr)
  }

  /**
   * Draws an unfilled arc between the given angles with a uniform [color] and [width] and optional
   * antialiasing (supported only for positive [width]). The larger the value of [pointCount], the
   * smoother the curve. [center] is defined in local space. For elliptical arcs, see [drawEllipseArc].
   * See also [drawCircle].
   *
   * If [width] is negative, it will be ignored and the arc will be drawn using
   * [RenderingServer.PRIMITIVE_LINE_STRIP]. This means that when the CanvasItem is scaled, the arc
   * will remain thin. If this behavior is not desired, then pass a positive [width] like `1.0`.
   *
   * The arc is drawn from [startAngle] towards the value of [endAngle] so in clockwise direction if
   * `start_angle < end_angle` and counter-clockwise otherwise. Passing the same angles but in reversed
   * order will produce the same arc. If absolute difference of [startAngle] and [endAngle] is greater
   * than [@GDScript.TAU] radians, then a full circle arc is drawn (i.e. arc will not overlap itself).
   */
  @JvmOverloads
  public final fun drawArc(
    center: Vector2,
    radius: Float,
    startAngle: Float,
    endAngle: Float,
    pointCount: Int,
    color: Color,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to center, DOUBLE to radius.toDouble(), DOUBLE to startAngle.toDouble(), DOUBLE to endAngle.toDouble(), LONG to pointCount.toLong(), COLOR to color, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawArcPtr)
  }

  /**
   * Draws multiple disconnected lines with a uniform [width] and [color]. Each line is defined by
   * two consecutive points from [points] array in local space, i.e. i-th segment consists of `points[2
   * * i]`, `points[2 * i + 1]` endpoints. When drawing large amounts of lines, this is faster than
   * using individual [drawLine] calls. To draw interconnected lines, use [drawPolyline] instead.
   *
   * If [width] is negative, then two-point primitives will be drawn instead of a four-point ones.
   * This means that when the CanvasItem is scaled, the lines will remain thin. If this behavior is not
   * desired, then pass a positive [width] like `1.0`.
   *
   * **Note:** [antialiased] is only effective if [width] is greater than `0.0`.
   */
  @JvmOverloads
  public final fun drawMultiline(
    points: PackedVector2Array,
    color: Color,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points, COLOR to color, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawMultilinePtr)
  }

  /**
   * Draws multiple disconnected lines with a uniform [width] and segment-by-segment coloring. Each
   * segment is defined by two consecutive points from [points] array in local space and a
   * corresponding color from [colors] array, i.e. i-th segment consists of `points[2 * i]`, `points[2
   * * i + 1]` endpoints and has `colors[i]` color. When drawing large amounts of lines, this is faster
   * than using individual [drawLine] calls. To draw interconnected lines, use [drawPolylineColors]
   * instead.
   *
   * If [width] is negative, then two-point primitives will be drawn instead of a four-point ones.
   * This means that when the CanvasItem is scaled, the lines will remain thin. If this behavior is not
   * desired, then pass a positive [width] like `1.0`.
   *
   * **Note:** [antialiased] is only effective if [width] is greater than `0.0`.
   */
  @JvmOverloads
  public final fun drawMultilineColors(
    points: PackedVector2Array,
    colors: PackedColorArray,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawMultilineColorsPtr)
  }

  /**
   * Draws a rectangle. If [filled] is `true`, the rectangle will be filled with the [color]
   * specified. If [filled] is `false`, the rectangle will be drawn as a stroke with the [color] and
   * [width] specified. The [rect] is specified in local space. See also [drawTextureRect].
   *
   * If [width] is negative, then two-point primitives will be drawn instead of a four-point ones.
   * This means that when the CanvasItem is scaled, the lines will remain thin. If this behavior is not
   * desired, then pass a positive [width] like `1.0`.
   *
   * If [antialiased] is `true`, half transparent "feathers" will be attached to the boundary,
   * making outlines smooth.
   *
   * **Note:** [width] is only effective if [filled] is `false`.
   *
   * **Note:** Unfilled rectangles drawn with a negative [width] may not display perfectly. For
   * example, corners may be missing or brighter due to overlapping lines (for a translucent [color]).
   */
  @JvmOverloads
  public final fun drawRect(
    rect: Rect2,
    color: Color,
    filled: Boolean = true,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to rect, COLOR to color, BOOL to filled, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawRectPtr)
  }

  /**
   * Draws a circle, with [position] defined in local space. See also [drawEllipse], [drawArc],
   * [drawPolyline], and [drawPolygon].
   *
   * If [filled] is `true`, the circle will be filled with the [color] specified. If [filled] is
   * `false`, the circle will be drawn as a stroke with the [color] and [width] specified.
   *
   * If [width] is negative, then two-point primitives will be drawn instead of a four-point ones.
   * This means that when the CanvasItem is scaled, the lines will remain thin. If this behavior is not
   * desired, then pass a positive [width] like `1.0`.
   *
   * If [antialiased] is `true`, half transparent "feathers" will be attached to the boundary,
   * making outlines smooth.
   *
   * **Note:** [width] is only effective if [filled] is `false`.
   */
  @JvmOverloads
  public final fun drawCircle(
    position: Vector2,
    radius: Float,
    color: Color,
    filled: Boolean = true,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position, DOUBLE to radius.toDouble(), COLOR to color, BOOL to filled, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawCirclePtr)
  }

  /**
   * Draws an ellipse with semi-major axis [major] and semi-minor axis [minor]. See also
   * [drawCircle], [drawEllipseArc], [drawPolyline], and [drawPolygon].
   *
   * If [filled] is `true`, the ellipse will be filled with the [color] specified. If [filled] is
   * `false`, the ellipse will be drawn as a stroke with the [color] and [width] specified.
   *
   * If [width] is negative, then two-point primitives will be drawn instead of four-point ones.
   * This means that when the CanvasItem is scaled, the lines will remain thin. If this behavior is not
   * desired, then pass a positive [width] like `1.0`.
   *
   * If [antialiased] is `true`, half transparent "feathers" will be attached to the boundary,
   * making outlines smooth.
   *
   * **Note:** [width] is only effective if [filled] is `false`.
   */
  @JvmOverloads
  public final fun drawEllipse(
    position: Vector2,
    major: Float,
    minor: Float,
    color: Color,
    filled: Boolean = true,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position, DOUBLE to major.toDouble(), DOUBLE to minor.toDouble(), COLOR to color, BOOL to filled, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.drawEllipsePtr)
  }

  /**
   * Draws a texture at a given position. The [position] is defined in local space.
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawTexture(
    texture: Texture2D,
    position: Vector2,
    modulate: Color = Color(Color(1, 1, 1, 1)),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, VECTOR2 to position, COLOR to modulate)
    TransferContext.callMethod(MethodBindings.drawTexturePtr)
  }

  /**
   * Draws a textured rectangle at a given position, optionally modulated by a color. The [rect] is
   * defined in local space. If [transpose] is `true`, the texture will have its X and Y coordinates
   * swapped. See also [drawRect] and [drawTextureRectRegion].
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawTextureRect(
    texture: Texture2D,
    rect: Rect2,
    tile: Boolean,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    transpose: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, RECT2 to rect, BOOL to tile, COLOR to modulate, BOOL to transpose)
    TransferContext.callMethod(MethodBindings.drawTextureRectPtr)
  }

  /**
   * Draws a textured rectangle from a texture's region (specified by [srcRect]) at a given position
   * in local space, optionally modulated by a color. If [transpose] is `true`, the texture will have
   * its X and Y coordinates swapped. See also [drawTextureRect].
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawTextureRectRegion(
    texture: Texture2D,
    rect: Rect2,
    srcRect: Rect2,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    transpose: Boolean = false,
    clipUv: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, RECT2 to rect, RECT2 to srcRect, COLOR to modulate, BOOL to transpose, BOOL to clipUv)
    TransferContext.callMethod(MethodBindings.drawTextureRectRegionPtr)
  }

  /**
   * Draws a textured rectangle region of the multichannel signed distance field texture at a given
   * position, optionally modulated by a color. The [rect] is defined in local space. See
   * [FontFile.multichannelSignedDistanceField] for more information and caveats about MSDF font
   * rendering.
   *
   * If [outline] is positive, each alpha channel value of pixel in region is set to maximum value
   * of true distance in the [outline] radius.
   *
   * Value of the [pixelRange] should the same that was used during distance field texture
   * generation.
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawMsdfTextureRectRegion(
    texture: Texture2D,
    rect: Rect2,
    srcRect: Rect2,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    outline: Double = 0.0,
    pixelRange: Double = 4.0,
    scale: Double = 1.0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, RECT2 to rect, RECT2 to srcRect, COLOR to modulate, DOUBLE to outline, DOUBLE to pixelRange, DOUBLE to scale)
    TransferContext.callMethod(MethodBindings.drawMsdfTextureRectRegionPtr)
  }

  /**
   * Draws a textured rectangle region of the font texture with LCD subpixel anti-aliasing at a
   * given position, optionally modulated by a color. The [rect] is defined in local space.
   *
   * Texture is drawn using the following blend operation, blend mode of the [CanvasItemMaterial] is
   * ignored:
   *
   * ```
   * dst.r = texture.r * modulate.r * modulate.a + dst.r * (1.0 - texture.r * modulate.a);
   * dst.g = texture.g * modulate.g * modulate.a + dst.g * (1.0 - texture.g * modulate.a);
   * dst.b = texture.b * modulate.b * modulate.a + dst.b * (1.0 - texture.b * modulate.a);
   * dst.a = modulate.a + dst.a * (1.0 - modulate.a);
   * ```
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawLcdTextureRectRegion(
    texture: Texture2D,
    rect: Rect2,
    srcRect: Rect2,
    modulate: Color = Color(Color(1, 1, 1, 1)),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, RECT2 to rect, RECT2 to srcRect, COLOR to modulate)
    TransferContext.callMethod(MethodBindings.drawLcdTextureRectRegionPtr)
  }

  /**
   * Draws a styled rectangle. The [rect] is defined in local space.
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  public final fun drawStyleBox(styleBox: StyleBox, rect: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to styleBox, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.drawStyleBoxPtr)
  }

  /**
   * Draws a custom primitive. 1 point for a point, 2 points for a line, 3 points for a triangle,
   * and 4 points for a quad. If 0 points or more than 4 points are specified, nothing will be drawn
   * and an error message will be printed. The [points] array is defined in local space. See also
   * [drawLine], [drawPolyline], [drawPolygon], and [drawRect].
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawPrimitive(
    points: PackedVector2Array,
    colors: PackedColorArray,
    uvs: PackedVector2Array,
    texture: Texture2D? = null,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, PACKED_VECTOR2_ARRAY to uvs, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.drawPrimitivePtr)
  }

  /**
   * Draws a solid polygon of any number of points, convex or concave. Unlike [drawColoredPolygon],
   * each point's color can be changed individually. The [points] array is defined in local space. See
   * also [drawPolyline] and [drawPolylineColors]. If you need more flexibility (such as being able to
   * use bones), use [RenderingServer.canvasItemAddTriangleArray] instead.
   *
   * **Note:** If you frequently redraw the same polygon with a large number of vertices, consider
   * pre-calculating the triangulation with [Geometry2D.triangulatePolygon] and using [drawMesh],
   * [drawMultimesh], or [RenderingServer.canvasItemAddTriangleArray].
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawPolygon(
    points: PackedVector2Array,
    colors: PackedColorArray,
    uvs: PackedVector2Array = PackedVector2Array(),
    texture: Texture2D? = null,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, PACKED_VECTOR2_ARRAY to uvs, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.drawPolygonPtr)
  }

  /**
   * Draws a colored polygon of any number of points, convex or concave. The points in the [points]
   * array are defined in local space. Unlike [drawPolygon], a single color must be specified for the
   * whole polygon.
   *
   * **Note:** If you frequently redraw the same polygon with a large number of vertices, consider
   * pre-calculating the triangulation with [Geometry2D.triangulatePolygon] and using [drawMesh],
   * [drawMultimesh], or [RenderingServer.canvasItemAddTriangleArray].
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawColoredPolygon(
    points: PackedVector2Array,
    color: Color,
    uvs: PackedVector2Array = PackedVector2Array(),
    texture: Texture2D? = null,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points, COLOR to color, PACKED_VECTOR2_ARRAY to uvs, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.drawColoredPolygonPtr)
  }

  /**
   * Draws [text] using the specified [font] at the [pos] in local space (bottom-left corner using
   * the baseline of the font). The text will have its color multiplied by [modulate]. If [width] is
   * greater than or equal to 0, the text will be clipped if it exceeds the specified width. If
   * [oversampling] is greater than zero, it is used as font oversampling factor, otherwise viewport
   * oversampling settings are used.
   *
   * **Example:** Draw "Hello world", using the project's default font:
   *
   * ```gdscript
   * //gdscript
   * draw_string(ThemeDB.fallback_font, Vector2(64, 64), "Hello world",
   * HORIZONTAL_ALIGNMENT_LEFT, -1, ThemeDB.fallback_font_size)
   * ```
   *
   * ```csharp
   * //csharp
   * DrawString(ThemeDB.FallbackFont, new Vector2(64, 64), "Hello world",
   * HorizontalAlignment.Left, -1, ThemeDB.FallbackFontSize);
   * ```
   *
   * See also [Font.drawString].
   */
  @JvmOverloads
  public final fun drawString(
    font: Font,
    pos: Vector2,
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font, VECTOR2 to pos, STRING to text, LONG to alignment.value, DOUBLE to width.toDouble(), LONG to fontSize.toLong(), COLOR to modulate, LONG to justificationFlags.flag, LONG to direction.value, LONG to orientation.value, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawStringPtr)
  }

  /**
   * Breaks [text] into lines and draws it using the specified [font] at the [pos] in local space
   * (top-left corner). The text will have its color multiplied by [modulate]. If [width] is greater
   * than or equal to 0, the text will be clipped if it exceeds the specified width. If [oversampling]
   * is greater than zero, it is used as font oversampling factor, otherwise viewport oversampling
   * settings are used.
   */
  @JvmOverloads
  public final fun drawMultilineString(
    font: Font,
    pos: Vector2,
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    maxLines: Int = -1,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    brkFlags: TextServer.LineBreakFlag = TextServer.LineBreakFlag(3),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font, VECTOR2 to pos, STRING to text, LONG to alignment.value, DOUBLE to width.toDouble(), LONG to fontSize.toLong(), LONG to maxLines.toLong(), COLOR to modulate, LONG to brkFlags.flag, LONG to justificationFlags.flag, LONG to direction.value, LONG to orientation.value, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawMultilineStringPtr)
  }

  /**
   * Draws [text] outline using the specified [font] at the [pos] in local space (bottom-left corner
   * using the baseline of the font). The text will have its color multiplied by [modulate]. If [width]
   * is greater than or equal to 0, the text will be clipped if it exceeds the specified width. If
   * [oversampling] is greater than zero, it is used as font oversampling factor, otherwise viewport
   * oversampling settings are used.
   */
  @JvmOverloads
  public final fun drawStringOutline(
    font: Font,
    pos: Vector2,
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    size: Int = 1,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font, VECTOR2 to pos, STRING to text, LONG to alignment.value, DOUBLE to width.toDouble(), LONG to fontSize.toLong(), LONG to size.toLong(), COLOR to modulate, LONG to justificationFlags.flag, LONG to direction.value, LONG to orientation.value, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawStringOutlinePtr)
  }

  /**
   * Breaks [text] to the lines and draws text outline using the specified [font] at the [pos] in
   * local space (top-left corner). The text will have its color multiplied by [modulate]. If [width]
   * is greater than or equal to 0, the text will be clipped if it exceeds the specified width. If
   * [oversampling] is greater than zero, it is used as font oversampling factor, otherwise viewport
   * oversampling settings are used.
   */
  @JvmOverloads
  public final fun drawMultilineStringOutline(
    font: Font,
    pos: Vector2,
    text: String,
    alignment: HorizontalAlignment = HorizontalAlignment.LEFT,
    width: Float = -1.0f,
    fontSize: Int = 16,
    maxLines: Int = -1,
    size: Int = 1,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    brkFlags: TextServer.LineBreakFlag = TextServer.LineBreakFlag(3),
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(3),
    direction: TextServer.Direction = TextServer.Direction.AUTO,
    orientation: TextServer.Orientation = TextServer.Orientation.HORIZONTAL,
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font, VECTOR2 to pos, STRING to text, LONG to alignment.value, DOUBLE to width.toDouble(), LONG to fontSize.toLong(), LONG to maxLines.toLong(), LONG to size.toLong(), COLOR to modulate, LONG to brkFlags.flag, LONG to justificationFlags.flag, LONG to direction.value, LONG to orientation.value, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawMultilineStringOutlinePtr)
  }

  /**
   * Draws a string first character using a custom font. If [oversampling] is greater than zero, it
   * is used as font oversampling factor, otherwise viewport oversampling settings are used. [pos] is
   * defined in local space.
   */
  @JvmOverloads
  public final fun drawChar(
    font: Font,
    pos: Vector2,
    char: String,
    fontSize: Int = 16,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font, VECTOR2 to pos, STRING to char, LONG to fontSize.toLong(), COLOR to modulate, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawCharPtr)
  }

  /**
   * Draws a string first character outline using a custom font. If [oversampling] is greater than
   * zero, it is used as font oversampling factor, otherwise viewport oversampling settings are used.
   * [pos] is defined in local space.
   */
  @JvmOverloads
  public final fun drawCharOutline(
    font: Font,
    pos: Vector2,
    char: String,
    fontSize: Int = 16,
    size: Int = -1,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to font, VECTOR2 to pos, STRING to char, LONG to fontSize.toLong(), LONG to size.toLong(), COLOR to modulate, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawCharOutlinePtr)
  }

  /**
   * Draws a [Mesh] in 2D, using the provided texture. See [MeshInstance2D] for related
   * documentation. The [transform] is defined in local space.
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  @JvmOverloads
  public final fun drawMesh(
    mesh: Mesh,
    texture: Texture2D?,
    transform: Transform2D = Transform2D(),
    modulate: Color = Color(Color(1, 1, 1, 1)),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh, OBJECT to texture, TRANSFORM2D to transform, COLOR to modulate)
    TransferContext.callMethod(MethodBindings.drawMeshPtr)
  }

  /**
   * Draws a [MultiMesh] in 2D with the provided texture. See [MultiMeshInstance2D] for related
   * documentation.
   *
   * **Note:** Styleboxes, textures, and meshes stored only inside local variables should **not** be
   * used with this method in GDScript, because the drawing operation doesn't begin immediately once
   * this method is called. In GDScript, when the function with the local variables ends, the local
   * variables get destroyed before the rendering takes place.
   */
  public final fun drawMultimesh(multimesh: MultiMesh, texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to multimesh, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.drawMultimeshPtr)
  }

  /**
   * Sets a custom local transform for drawing via components. Anything drawn afterwards will be
   * transformed by this.
   *
   * **Note:** [FontFile.oversampling] does *not* take [scale] into account. This means that scaling
   * up/down will cause bitmap fonts and rasterized (non-MSDF) dynamic fonts to appear blurry or
   * pixelated. To ensure text remains crisp regardless of scale, you can enable MSDF font rendering by
   * enabling [ProjectSettings.gui/theme/defaultFontMultichannelSignedDistanceField] (applies to the
   * default project font only), or enabling **Multichannel Signed Distance Field** in the import
   * options of a DynamicFont for custom fonts. On system fonts,
   * [SystemFont.multichannelSignedDistanceField] can be enabled in the inspector.
   */
  @JvmOverloads
  public final fun drawSetTransform(
    position: Vector2,
    rotation: Float = 0.0f,
    scale: Vector2 = Vector2(1, 1),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position, DOUBLE to rotation.toDouble(), VECTOR2 to scale)
    TransferContext.callMethod(MethodBindings.drawSetTransformPtr)
  }

  /**
   * Sets a custom local transform for drawing via matrix. Anything drawn afterwards will be
   * transformed by this.
   */
  public final fun drawSetTransformMatrix(xform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to xform)
    TransferContext.callMethod(MethodBindings.drawSetTransformMatrixPtr)
  }

  /**
   * Subsequent drawing commands will be ignored unless they fall within the specified animation
   * slice. This is a faster way to implement animations that loop on background rather than redrawing
   * constantly.
   */
  @JvmOverloads
  public final fun drawAnimationSlice(
    animationLength: Double,
    sliceBegin: Double,
    sliceEnd: Double,
    offset: Double = 0.0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to animationLength, DOUBLE to sliceBegin, DOUBLE to sliceEnd, DOUBLE to offset)
    TransferContext.callMethod(MethodBindings.drawAnimationSlicePtr)
  }

  /**
   * After submitting all animations slices via [drawAnimationSlice], this function can be used to
   * revert drawing to its default state (all subsequent drawing commands will be visible). If you
   * don't care about this particular use case, usage of this function after submitting the slices is
   * not required.
   */
  public final fun drawEndAnimation(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.drawEndAnimationPtr)
  }

  /**
   * Returns the transform matrix of this [CanvasItem].
   */
  public final fun getTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the global transform matrix of this item, i.e. the combined transform up to the topmost
   * [CanvasItem] node. The topmost item is a [CanvasItem] that either has no parent, has
   * non-[CanvasItem] parent or it has [topLevel] enabled.
   */
  public final fun getGlobalTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the transform from the local coordinate system of this [CanvasItem] to the [Viewport]s
   * coordinate system.
   */
  public final fun getGlobalTransformWithCanvas(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalTransformWithCanvasPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the transform of this node, converted from its registered canvas's coordinate system to
   * its viewport embedder's coordinate system. See also [Viewport.getFinalTransform] and
   * [Node.getViewport].
   */
  public final fun getViewportTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getViewportTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns this node's viewport boundaries as a [Rect2]. See also [Node.getViewport].
   */
  public final fun getViewportRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getViewportRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Returns the transform of this node, converted from its registered canvas's coordinate system to
   * its viewport's coordinate system. See also [Node.getViewport].
   */
  public final fun getCanvasTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the transform of this [CanvasItem] in global screen coordinates (i.e. taking window
   * position into account). Mostly useful for editor plugins.
   *
   * Equivalent to [getGlobalTransformWithCanvas] if the window is embedded (see
   * [Viewport.guiEmbedSubwindows]).
   */
  public final fun getScreenTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the mouse's position in this [CanvasItem] using the local coordinate system of this
   * [CanvasItem].
   */
  public final fun getLocalMousePosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalMousePositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns mouse cursor's global position relative to the [CanvasLayer] that contains this node.
   *
   * **Note:** For screen-space coordinates (e.g. when using a non-embedded [Popup]), you can use
   * [DisplayServer.mouseGetPosition].
   */
  public final fun getGlobalMousePosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalMousePositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the [RID] of the [World2D] canvas where this node is registered to, used by the
   * [RenderingServer].
   */
  public final fun getCanvas(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the [CanvasLayer] that contains this node, or `null` if the node is not in any
   * [CanvasLayer].
   */
  public final fun getCanvasLayerNode(): CanvasLayer? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasLayerNodePtr)
    return (TransferContext.readReturnValue(OBJECT) as CanvasLayer?)
  }

  /**
   * Returns the [World2D] this node is registered to.
   *
   * Usually, this is the same as this node's viewport (see [Node.getViewport] and
   * [Viewport.findWorld2d]).
   */
  public final fun getWorld2d(): World2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWorld2dPtr)
    return (TransferContext.readReturnValue(OBJECT) as World2D?)
  }

  public final fun setMaterial(material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to material)
    TransferContext.callMethod(MethodBindings.setMaterialPtr)
  }

  public final fun getMaterial(): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  /**
   * Set the value of a shader uniform for this instance only
   * ([url=$DOCS_URL/tutorials/shaders/shader_reference/shading_language.html#per-instance-uniforms]per-instance
   * uniform[/url]). See also [ShaderMaterial.setShaderParameter] to assign a uniform on all instances
   * using the same [ShaderMaterial].
   *
   * **Note:** For a shader uniform to be assignable on a per-instance basis, it *must* be defined
   * with `instance uniform ...` rather than `uniform ...` in the shader code.
   *
   * **Note:** [name] is case-sensitive and must match the name of the uniform in the code exactly
   * (not the capitalized name in the inspector).
   */
  public final fun setInstanceShaderParameter(name: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, ANY to value)
    TransferContext.callMethod(MethodBindings.setInstanceShaderParameterPtr)
  }

  /**
   * Get the value of a shader parameter as set on this instance.
   */
  public final fun getInstanceShaderParameter(name: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getInstanceShaderParameterPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public final fun setUseParentMaterial(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseParentMaterialPtr)
  }

  public final fun getUseParentMaterial(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseParentMaterialPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, the node will receive [NOTIFICATION_LOCAL_TRANSFORM_CHANGED] whenever its local
   * transform changes.
   *
   * **Note:** Many canvas items such as [Bone2D] or [CollisionShape2D] automatically enable this in
   * order to function correctly.
   */
  public final fun setNotifyLocalTransform(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setNotifyLocalTransformPtr)
  }

  /**
   * Returns `true` if the node receives [NOTIFICATION_LOCAL_TRANSFORM_CHANGED] whenever its local
   * transform changes. This is enabled with [setNotifyLocalTransform].
   */
  public final fun isLocalTransformNotificationEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLocalTransformNotificationEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, the node will receive [NOTIFICATION_TRANSFORM_CHANGED] whenever its global transform
   * changes.
   *
   * **Note:** Many canvas items such as [Camera2D] or [Light2D] automatically enable this in order
   * to function correctly.
   */
  public final fun setNotifyTransform(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setNotifyTransformPtr)
  }

  /**
   * Returns `true` if the node receives [NOTIFICATION_TRANSFORM_CHANGED] whenever its global
   * transform changes. This is enabled with [setNotifyTransform].
   */
  public final fun isTransformNotificationEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isTransformNotificationEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Forces the node's transform to update. Fails if the node is not inside the tree. See also
   * [getTransform].
   *
   * **Note:** For performance reasons, transform changes are usually accumulated and applied *once*
   * at the end of the frame. The update propagates through [CanvasItem] children, as well. Therefore,
   * use this method only when you need an up-to-date transform (such as during physics operations).
   */
  public final fun forceUpdateTransform(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceUpdateTransformPtr)
  }

  /**
   * Transforms [viewportPoint] from the viewport's coordinates to this node's local coordinates.
   *
   * For the opposite operation, use [getGlobalTransformWithCanvas].
   *
   * ```
   * var viewport_point = get_global_transform_with_canvas() * local_point
   * ```
   */
  public final fun makeCanvasPositionLocal(viewportPoint: Vector2): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to viewportPoint)
    TransferContext.callMethod(MethodBindings.makeCanvasPositionLocalPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns a copy of the given [event] with its coordinates converted from global space to this
   * [CanvasItem]'s local space. If not possible, returns the same [InputEvent] unchanged.
   */
  public final fun makeInputLocal(event: InputEvent): InputEvent {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to event)
    TransferContext.callMethod(MethodBindings.makeInputLocalPtr)
    return (TransferContext.readReturnValue(OBJECT) as InputEvent)
  }

  public final fun setVisibilityLayer(layer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer)
    TransferContext.callMethod(MethodBindings.setVisibilityLayerPtr)
  }

  public final fun getVisibilityLayer(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Set/clear individual bits on the rendering visibility layer. This simplifies editing this
   * [CanvasItem]'s visibility layer.
   */
  public final fun setVisibilityLayerBit(layer: Long, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setVisibilityLayerBitPtr)
  }

  /**
   * Returns `true` if the layer at the given index is set in [visibilityLayer].
   */
  public final fun getVisibilityLayerBit(layer: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer)
    TransferContext.callMethod(MethodBindings.getVisibilityLayerBitPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTextureFilter(mode: TextureFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTextureFilterPtr)
  }

  public final fun getTextureFilter(): TextureFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureFilterPtr)
    return TextureFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTextureRepeat(mode: TextureRepeat): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTextureRepeatPtr)
  }

  public final fun getTextureRepeat(): TextureRepeat {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureRepeatPtr)
    return TextureRepeat.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setClipChildrenMode(mode: ClipChildrenMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setClipChildrenModePtr)
  }

  public final fun getClipChildrenMode(): ClipChildrenMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClipChildrenModePtr)
    return ClipChildrenMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setOversamplingWithScale(enabled: OversamplingWithScale): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to enabled.value)
    TransferContext.callMethod(MethodBindings.setOversamplingWithScalePtr)
  }

  public final fun getOversamplingWithScale(): OversamplingWithScale {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOversamplingWithScalePtr)
    return OversamplingWithScale.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Set the value of a shader uniform for this instance only
   * ([url=$DOCS_URL/tutorials/shaders/shader_reference/shading_language.html#per-instance-uniforms]per-instance
   * uniform[/url]). See also [ShaderMaterial.setShaderParameter] to assign a uniform on all instances
   * using the same [ShaderMaterial].
   *
   * **Note:** For a shader uniform to be assignable on a per-instance basis, it *must* be defined
   * with `instance uniform ...` rather than `uniform ...` in the shader code.
   *
   * **Note:** [name] is case-sensitive and must match the name of the uniform in the code exactly
   * (not the capitalized name in the inspector).
   */
  public final fun setInstanceShaderParameter(name: String, `value`: Any?) =
      setInstanceShaderParameter(name.asCachedStringName(), value)

  /**
   * Get the value of a shader parameter as set on this instance.
   */
  public final fun getInstanceShaderParameter(name: String): Any? =
      getInstanceShaderParameter(name.asCachedStringName())

  public enum class TextureFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The [CanvasItem] will inherit the filter from its parent.
     */
    PARENT_NODE(0),
    /**
     * The texture filter reads from the nearest pixel only. This makes the texture look pixelated
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    NEAREST(1),
    /**
     * The texture filter blends between the nearest 4 pixels. This makes the texture look smooth
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    LINEAR(2),
    /**
     * The texture filter reads from the nearest pixel and blends between the nearest 2 mipmaps (or
     * uses the nearest mipmap if
     * [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is `true`). This
     * makes the texture look pixelated from up close, and smooth from a distance.
     *
     * Use this for non-pixel art textures that may be viewed at a low scale (e.g. due to [Camera2D]
     * zoom or sprite scaling), as mipmaps are important to smooth out pixels that are smaller than
     * on-screen pixels.
     */
    NEAREST_WITH_MIPMAPS(3),
    /**
     * The texture filter blends between the nearest 4 pixels and between the nearest 2 mipmaps (or
     * uses the nearest mipmap if
     * [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is `true`). This
     * makes the texture look smooth from up close, and smooth from a distance.
     *
     * Use this for non-pixel art textures that may be viewed at a low scale (e.g. due to [Camera2D]
     * zoom or sprite scaling), as mipmaps are important to smooth out pixels that are smaller than
     * on-screen pixels.
     */
    LINEAR_WITH_MIPMAPS(4),
    /**
     * The texture filter reads from the nearest pixel and blends between 2 mipmaps (or uses the
     * nearest mipmap if [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is
     * `true`) based on the angle between the surface and the camera view. This makes the texture look
     * pixelated from up close, and smooth from a distance. Anisotropic filtering improves texture
     * quality on surfaces that are almost in line with the camera, but is slightly slower. The
     * anisotropic filtering level can be changed by adjusting
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     *
     * **Note:** This texture filter is rarely useful in 2D projects.
     * [TEXTURE_FILTER_NEAREST_WITH_MIPMAPS] is usually more appropriate in this case.
     */
    NEAREST_WITH_MIPMAPS_ANISOTROPIC(5),
    /**
     * The texture filter blends between the nearest 4 pixels and blends between 2 mipmaps (or uses
     * the nearest mipmap if [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter]
     * is `true`) based on the angle between the surface and the camera view. This makes the texture
     * look smooth from up close, and smooth from a distance. Anisotropic filtering improves texture
     * quality on surfaces that are almost in line with the camera, but is slightly slower. The
     * anisotropic filtering level can be changed by adjusting
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     *
     * **Note:** This texture filter is rarely useful in 2D projects.
     * [TEXTURE_FILTER_LINEAR_WITH_MIPMAPS] is usually more appropriate in this case.
     */
    LINEAR_WITH_MIPMAPS_ANISOTROPIC(6),
    /**
     * Represents the size of the [TextureFilter] enum.
     */
    MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): TextureFilter = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureRepeat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The [CanvasItem] will inherit the repeat mode from its parent.
     */
    PARENT_NODE(0),
    /**
     * The texture does not repeat. Sampling the texture outside its extents will result in
     * "stretching" of the edge pixels. You can avoid this by ensuring a 1-pixel fully transparent
     * border on each side of the texture.
     */
    DISABLED(1),
    /**
     * The texture repeats when exceeding the texture's size.
     */
    ENABLED(2),
    /**
     * The texture repeats when the exceeding the texture's size in a "2×2 tiled mode". Repeated
     * textures at even positions are mirrored.
     */
    MIRROR(3),
    /**
     * Represents the size of the [TextureRepeat] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): TextureRepeat = entries.single { it.`value` == `value` }
    }
  }

  public enum class ClipChildrenMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Children are drawn over this node and are not clipped.
     */
    DISABLED(0),
    /**
     * This node is used as a mask and is **not** drawn. The mask is based on this node's alpha
     * channel: Opaque pixels are kept, transparent pixels are discarded, and semi-transparent pixels
     * are blended in according to their opacity. Children are clipped to this node's drawn area.
     */
    ONLY(1),
    /**
     * This node is used as a mask and is also drawn. The mask is based on this node's alpha
     * channel: Opaque pixels are kept, transparent pixels are discarded, and semi-transparent pixels
     * are blended in according to their opacity. Children are clipped to the parent's drawn area.
     */
    AND_DRAW(2),
    /**
     * Represents the size of the [ClipChildrenMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ClipChildrenMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class OversamplingWithScale(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The [CanvasItem] will inherit the oversampling mode from its parent.
     */
    PARENT_NODE(0),
    /**
     * The oversampling is not affected by [CanvasItem] scale, and is equal to the [Viewport]
     * oversampling.
     */
    DISABLED(1),
    /**
     * The oversampling is a product of [CanvasItem] scale and [Viewport] oversampling.
     */
    ENABLED(2),
    /**
     * Represents the size of the [OversamplingWithScale] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): OversamplingWithScale =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getCanvasItemName: MethodStringName0<CanvasItem, RID> =
        MethodStringName0<CanvasItem, RID>("get_canvas_item")

    @JvmField
    public val setVisibleName: MethodStringName1<CanvasItem, Unit, Boolean> =
        MethodStringName1<CanvasItem, Unit, Boolean>("set_visible")

    @JvmField
    public val isVisibleName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("is_visible")

    @JvmField
    public val isVisibleInTreeName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("is_visible_in_tree")

    @JvmField
    public val showName: MethodStringName0<CanvasItem, Unit> =
        MethodStringName0<CanvasItem, Unit>("show")

    @JvmField
    public val hideName: MethodStringName0<CanvasItem, Unit> =
        MethodStringName0<CanvasItem, Unit>("hide")

    @JvmField
    public val queueRedrawName: MethodStringName0<CanvasItem, Unit> =
        MethodStringName0<CanvasItem, Unit>("queue_redraw")

    @JvmField
    public val moveToFrontName: MethodStringName0<CanvasItem, Unit> =
        MethodStringName0<CanvasItem, Unit>("move_to_front")

    @JvmField
    public val setAsTopLevelName: MethodStringName1<CanvasItem, Unit, Boolean> =
        MethodStringName1<CanvasItem, Unit, Boolean>("set_as_top_level")

    @JvmField
    public val isSetAsTopLevelName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("is_set_as_top_level")

    @JvmField
    public val setLightMaskName: MethodStringName1<CanvasItem, Unit, Int> =
        MethodStringName1<CanvasItem, Unit, Int>("set_light_mask")

    @JvmField
    public val getLightMaskName: MethodStringName0<CanvasItem, Int> =
        MethodStringName0<CanvasItem, Int>("get_light_mask")

    @JvmField
    public val setModulateName: MethodStringName1<CanvasItem, Unit, Color> =
        MethodStringName1<CanvasItem, Unit, Color>("set_modulate")

    @JvmField
    public val getModulateName: MethodStringName0<CanvasItem, Color> =
        MethodStringName0<CanvasItem, Color>("get_modulate")

    @JvmField
    public val setSelfModulateName: MethodStringName1<CanvasItem, Unit, Color> =
        MethodStringName1<CanvasItem, Unit, Color>("set_self_modulate")

    @JvmField
    public val getSelfModulateName: MethodStringName0<CanvasItem, Color> =
        MethodStringName0<CanvasItem, Color>("get_self_modulate")

    @JvmField
    public val setZIndexName: MethodStringName1<CanvasItem, Unit, Int> =
        MethodStringName1<CanvasItem, Unit, Int>("set_z_index")

    @JvmField
    public val getZIndexName: MethodStringName0<CanvasItem, Int> =
        MethodStringName0<CanvasItem, Int>("get_z_index")

    @JvmField
    public val setZAsRelativeName: MethodStringName1<CanvasItem, Unit, Boolean> =
        MethodStringName1<CanvasItem, Unit, Boolean>("set_z_as_relative")

    @JvmField
    public val isZRelativeName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("is_z_relative")

    @JvmField
    public val setYSortEnabledName: MethodStringName1<CanvasItem, Unit, Boolean> =
        MethodStringName1<CanvasItem, Unit, Boolean>("set_y_sort_enabled")

    @JvmField
    public val isYSortEnabledName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("is_y_sort_enabled")

    @JvmField
    public val setDrawBehindParentName: MethodStringName1<CanvasItem, Unit, Boolean> =
        MethodStringName1<CanvasItem, Unit, Boolean>("set_draw_behind_parent")

    @JvmField
    public val isDrawBehindParentEnabledName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("is_draw_behind_parent_enabled")

    @JvmField
    public val drawLineName:
        MethodStringName5<CanvasItem, Unit, Vector2, Vector2, Color, Float, Boolean> =
        MethodStringName5<CanvasItem, Unit, Vector2, Vector2, Color, Float, Boolean>("draw_line")

    @JvmField
    public val drawDashedLineName:
        MethodStringName7<CanvasItem, Unit, Vector2, Vector2, Color, Float, Float, Boolean, Boolean>
        =
        MethodStringName7<CanvasItem, Unit, Vector2, Vector2, Color, Float, Float, Boolean, Boolean>("draw_dashed_line")

    @JvmField
    public val drawPolylineName:
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, Color, Float, Boolean> =
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, Color, Float, Boolean>("draw_polyline")

    @JvmField
    public val drawPolylineColorsName:
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, PackedColorArray, Float, Boolean> =
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, PackedColorArray, Float, Boolean>("draw_polyline_colors")

    @JvmField
    public val drawEllipseArcName:
        MethodStringName9<CanvasItem, Unit, Vector2, Float, Float, Float, Float, Int, Color, Float, Boolean>
        =
        MethodStringName9<CanvasItem, Unit, Vector2, Float, Float, Float, Float, Int, Color, Float, Boolean>("draw_ellipse_arc")

    @JvmField
    public val drawArcName:
        MethodStringName8<CanvasItem, Unit, Vector2, Float, Float, Float, Int, Color, Float, Boolean>
        =
        MethodStringName8<CanvasItem, Unit, Vector2, Float, Float, Float, Int, Color, Float, Boolean>("draw_arc")

    @JvmField
    public val drawMultilineName:
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, Color, Float, Boolean> =
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, Color, Float, Boolean>("draw_multiline")

    @JvmField
    public val drawMultilineColorsName:
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, PackedColorArray, Float, Boolean> =
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, PackedColorArray, Float, Boolean>("draw_multiline_colors")

    @JvmField
    public val drawRectName:
        MethodStringName5<CanvasItem, Unit, Rect2, Color, Boolean, Float, Boolean> =
        MethodStringName5<CanvasItem, Unit, Rect2, Color, Boolean, Float, Boolean>("draw_rect")

    @JvmField
    public val drawCircleName:
        MethodStringName6<CanvasItem, Unit, Vector2, Float, Color, Boolean, Float, Boolean> =
        MethodStringName6<CanvasItem, Unit, Vector2, Float, Color, Boolean, Float, Boolean>("draw_circle")

    @JvmField
    public val drawEllipseName:
        MethodStringName7<CanvasItem, Unit, Vector2, Float, Float, Color, Boolean, Float, Boolean> =
        MethodStringName7<CanvasItem, Unit, Vector2, Float, Float, Color, Boolean, Float, Boolean>("draw_ellipse")

    @JvmField
    public val drawTextureName: MethodStringName3<CanvasItem, Unit, Texture2D, Vector2, Color> =
        MethodStringName3<CanvasItem, Unit, Texture2D, Vector2, Color>("draw_texture")

    @JvmField
    public val drawTextureRectName:
        MethodStringName5<CanvasItem, Unit, Texture2D, Rect2, Boolean, Color, Boolean> =
        MethodStringName5<CanvasItem, Unit, Texture2D, Rect2, Boolean, Color, Boolean>("draw_texture_rect")

    @JvmField
    public val drawTextureRectRegionName:
        MethodStringName6<CanvasItem, Unit, Texture2D, Rect2, Rect2, Color, Boolean, Boolean> =
        MethodStringName6<CanvasItem, Unit, Texture2D, Rect2, Rect2, Color, Boolean, Boolean>("draw_texture_rect_region")

    @JvmField
    public val drawMsdfTextureRectRegionName:
        MethodStringName7<CanvasItem, Unit, Texture2D, Rect2, Rect2, Color, Double, Double, Double>
        =
        MethodStringName7<CanvasItem, Unit, Texture2D, Rect2, Rect2, Color, Double, Double, Double>("draw_msdf_texture_rect_region")

    @JvmField
    public val drawLcdTextureRectRegionName:
        MethodStringName4<CanvasItem, Unit, Texture2D, Rect2, Rect2, Color> =
        MethodStringName4<CanvasItem, Unit, Texture2D, Rect2, Rect2, Color>("draw_lcd_texture_rect_region")

    @JvmField
    public val drawStyleBoxName: MethodStringName2<CanvasItem, Unit, StyleBox, Rect2> =
        MethodStringName2<CanvasItem, Unit, StyleBox, Rect2>("draw_style_box")

    @JvmField
    public val drawPrimitiveName:
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, PackedColorArray, PackedVector2Array, Texture2D?>
        =
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, PackedColorArray, PackedVector2Array, Texture2D?>("draw_primitive")

    @JvmField
    public val drawPolygonName:
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, PackedColorArray, PackedVector2Array, Texture2D?>
        =
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, PackedColorArray, PackedVector2Array, Texture2D?>("draw_polygon")

    @JvmField
    public val drawColoredPolygonName:
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, Color, PackedVector2Array, Texture2D?>
        =
        MethodStringName4<CanvasItem, Unit, PackedVector2Array, Color, PackedVector2Array, Texture2D?>("draw_colored_polygon")

    @JvmField
    public val drawStringName:
        MethodStringName11<CanvasItem, Unit, Font, Vector2, String, HorizontalAlignment, Float, Int, Color, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>
        =
        MethodStringName11<CanvasItem, Unit, Font, Vector2, String, HorizontalAlignment, Float, Int, Color, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>("draw_string")

    @JvmField
    public val drawMultilineStringName:
        MethodStringName13<CanvasItem, Unit, Font, Vector2, String, HorizontalAlignment, Float, Int, Int, Color, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>
        =
        MethodStringName13<CanvasItem, Unit, Font, Vector2, String, HorizontalAlignment, Float, Int, Int, Color, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>("draw_multiline_string")

    @JvmField
    public val drawStringOutlineName:
        MethodStringName12<CanvasItem, Unit, Font, Vector2, String, HorizontalAlignment, Float, Int, Int, Color, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>
        =
        MethodStringName12<CanvasItem, Unit, Font, Vector2, String, HorizontalAlignment, Float, Int, Int, Color, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>("draw_string_outline")

    @JvmField
    public val drawMultilineStringOutlineName:
        MethodStringName14<CanvasItem, Unit, Font, Vector2, String, HorizontalAlignment, Float, Int, Int, Int, Color, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>
        =
        MethodStringName14<CanvasItem, Unit, Font, Vector2, String, HorizontalAlignment, Float, Int, Int, Int, Color, TextServer.LineBreakFlag, TextServer.JustificationFlag, TextServer.Direction, TextServer.Orientation, Float>("draw_multiline_string_outline")

    @JvmField
    public val drawCharName:
        MethodStringName6<CanvasItem, Unit, Font, Vector2, String, Int, Color, Float> =
        MethodStringName6<CanvasItem, Unit, Font, Vector2, String, Int, Color, Float>("draw_char")

    @JvmField
    public val drawCharOutlineName:
        MethodStringName7<CanvasItem, Unit, Font, Vector2, String, Int, Int, Color, Float> =
        MethodStringName7<CanvasItem, Unit, Font, Vector2, String, Int, Int, Color, Float>("draw_char_outline")

    @JvmField
    public val drawMeshName:
        MethodStringName4<CanvasItem, Unit, Mesh, Texture2D?, Transform2D, Color> =
        MethodStringName4<CanvasItem, Unit, Mesh, Texture2D?, Transform2D, Color>("draw_mesh")

    @JvmField
    public val drawMultimeshName: MethodStringName2<CanvasItem, Unit, MultiMesh, Texture2D?> =
        MethodStringName2<CanvasItem, Unit, MultiMesh, Texture2D?>("draw_multimesh")

    @JvmField
    public val drawSetTransformName: MethodStringName3<CanvasItem, Unit, Vector2, Float, Vector2> =
        MethodStringName3<CanvasItem, Unit, Vector2, Float, Vector2>("draw_set_transform")

    @JvmField
    public val drawSetTransformMatrixName: MethodStringName1<CanvasItem, Unit, Transform2D> =
        MethodStringName1<CanvasItem, Unit, Transform2D>("draw_set_transform_matrix")

    @JvmField
    public val drawAnimationSliceName:
        MethodStringName4<CanvasItem, Unit, Double, Double, Double, Double> =
        MethodStringName4<CanvasItem, Unit, Double, Double, Double, Double>("draw_animation_slice")

    @JvmField
    public val drawEndAnimationName: MethodStringName0<CanvasItem, Unit> =
        MethodStringName0<CanvasItem, Unit>("draw_end_animation")

    @JvmField
    public val getTransformName: MethodStringName0<CanvasItem, Transform2D> =
        MethodStringName0<CanvasItem, Transform2D>("get_transform")

    @JvmField
    public val getGlobalTransformName: MethodStringName0<CanvasItem, Transform2D> =
        MethodStringName0<CanvasItem, Transform2D>("get_global_transform")

    @JvmField
    public val getGlobalTransformWithCanvasName: MethodStringName0<CanvasItem, Transform2D> =
        MethodStringName0<CanvasItem, Transform2D>("get_global_transform_with_canvas")

    @JvmField
    public val getViewportTransformName: MethodStringName0<CanvasItem, Transform2D> =
        MethodStringName0<CanvasItem, Transform2D>("get_viewport_transform")

    @JvmField
    public val getViewportRectName: MethodStringName0<CanvasItem, Rect2> =
        MethodStringName0<CanvasItem, Rect2>("get_viewport_rect")

    @JvmField
    public val getCanvasTransformName: MethodStringName0<CanvasItem, Transform2D> =
        MethodStringName0<CanvasItem, Transform2D>("get_canvas_transform")

    @JvmField
    public val getScreenTransformName: MethodStringName0<CanvasItem, Transform2D> =
        MethodStringName0<CanvasItem, Transform2D>("get_screen_transform")

    @JvmField
    public val getLocalMousePositionName: MethodStringName0<CanvasItem, Vector2> =
        MethodStringName0<CanvasItem, Vector2>("get_local_mouse_position")

    @JvmField
    public val getGlobalMousePositionName: MethodStringName0<CanvasItem, Vector2> =
        MethodStringName0<CanvasItem, Vector2>("get_global_mouse_position")

    @JvmField
    public val getCanvasName: MethodStringName0<CanvasItem, RID> =
        MethodStringName0<CanvasItem, RID>("get_canvas")

    @JvmField
    public val getCanvasLayerNodeName: MethodStringName0<CanvasItem, CanvasLayer?> =
        MethodStringName0<CanvasItem, CanvasLayer?>("get_canvas_layer_node")

    @JvmField
    public val getWorld2dName: MethodStringName0<CanvasItem, World2D?> =
        MethodStringName0<CanvasItem, World2D?>("get_world_2d")

    @JvmField
    public val setMaterialName: MethodStringName1<CanvasItem, Unit, Material?> =
        MethodStringName1<CanvasItem, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<CanvasItem, Material?> =
        MethodStringName0<CanvasItem, Material?>("get_material")

    @JvmField
    public val setInstanceShaderParameterName: MethodStringName2<CanvasItem, Unit, StringName, Any?>
        = MethodStringName2<CanvasItem, Unit, StringName, Any?>("set_instance_shader_parameter")

    @JvmField
    public val getInstanceShaderParameterName: MethodStringName1<CanvasItem, Any?, StringName> =
        MethodStringName1<CanvasItem, Any?, StringName>("get_instance_shader_parameter")

    @JvmField
    public val setUseParentMaterialName: MethodStringName1<CanvasItem, Unit, Boolean> =
        MethodStringName1<CanvasItem, Unit, Boolean>("set_use_parent_material")

    @JvmField
    public val getUseParentMaterialName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("get_use_parent_material")

    @JvmField
    public val setNotifyLocalTransformName: MethodStringName1<CanvasItem, Unit, Boolean> =
        MethodStringName1<CanvasItem, Unit, Boolean>("set_notify_local_transform")

    @JvmField
    public val isLocalTransformNotificationEnabledName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("is_local_transform_notification_enabled")

    @JvmField
    public val setNotifyTransformName: MethodStringName1<CanvasItem, Unit, Boolean> =
        MethodStringName1<CanvasItem, Unit, Boolean>("set_notify_transform")

    @JvmField
    public val isTransformNotificationEnabledName: MethodStringName0<CanvasItem, Boolean> =
        MethodStringName0<CanvasItem, Boolean>("is_transform_notification_enabled")

    @JvmField
    public val forceUpdateTransformName: MethodStringName0<CanvasItem, Unit> =
        MethodStringName0<CanvasItem, Unit>("force_update_transform")

    @JvmField
    public val makeCanvasPositionLocalName: MethodStringName1<CanvasItem, Vector2, Vector2> =
        MethodStringName1<CanvasItem, Vector2, Vector2>("make_canvas_position_local")

    @JvmField
    public val makeInputLocalName: MethodStringName1<CanvasItem, InputEvent, InputEvent> =
        MethodStringName1<CanvasItem, InputEvent, InputEvent>("make_input_local")

    @JvmField
    public val setVisibilityLayerName: MethodStringName1<CanvasItem, Unit, Long> =
        MethodStringName1<CanvasItem, Unit, Long>("set_visibility_layer")

    @JvmField
    public val getVisibilityLayerName: MethodStringName0<CanvasItem, Long> =
        MethodStringName0<CanvasItem, Long>("get_visibility_layer")

    @JvmField
    public val setVisibilityLayerBitName: MethodStringName2<CanvasItem, Unit, Long, Boolean> =
        MethodStringName2<CanvasItem, Unit, Long, Boolean>("set_visibility_layer_bit")

    @JvmField
    public val getVisibilityLayerBitName: MethodStringName1<CanvasItem, Boolean, Long> =
        MethodStringName1<CanvasItem, Boolean, Long>("get_visibility_layer_bit")

    @JvmField
    public val setTextureFilterName: MethodStringName1<CanvasItem, Unit, TextureFilter> =
        MethodStringName1<CanvasItem, Unit, TextureFilter>("set_texture_filter")

    @JvmField
    public val getTextureFilterName: MethodStringName0<CanvasItem, TextureFilter> =
        MethodStringName0<CanvasItem, TextureFilter>("get_texture_filter")

    @JvmField
    public val setTextureRepeatName: MethodStringName1<CanvasItem, Unit, TextureRepeat> =
        MethodStringName1<CanvasItem, Unit, TextureRepeat>("set_texture_repeat")

    @JvmField
    public val getTextureRepeatName: MethodStringName0<CanvasItem, TextureRepeat> =
        MethodStringName0<CanvasItem, TextureRepeat>("get_texture_repeat")

    @JvmField
    public val setClipChildrenModeName: MethodStringName1<CanvasItem, Unit, ClipChildrenMode> =
        MethodStringName1<CanvasItem, Unit, ClipChildrenMode>("set_clip_children_mode")

    @JvmField
    public val getClipChildrenModeName: MethodStringName0<CanvasItem, ClipChildrenMode> =
        MethodStringName0<CanvasItem, ClipChildrenMode>("get_clip_children_mode")

    @JvmField
    public val setOversamplingWithScaleName:
        MethodStringName1<CanvasItem, Unit, OversamplingWithScale> =
        MethodStringName1<CanvasItem, Unit, OversamplingWithScale>("set_oversampling_with_scale")

    @JvmField
    public val getOversamplingWithScaleName: MethodStringName0<CanvasItem, OversamplingWithScale> =
        MethodStringName0<CanvasItem, OversamplingWithScale>("get_oversampling_with_scale")

    /**
     * Notification received when this node's global transform changes, if
     * [isTransformNotificationEnabled] is `true`. See also [setNotifyTransform] and [getTransform].
     *
     * **Note:** Many canvas items such as [Camera2D] or [CollisionObject2D] automatically enable
     * this in order to function correctly.
     */
    public final const val NOTIFICATION_TRANSFORM_CHANGED: Long = 2000

    /**
     * Notification received when this node's transform changes, if
     * [isLocalTransformNotificationEnabled] is `true`. This is not received when a parent [Node2D]'s
     * transform changes. See also [setNotifyLocalTransform].
     *
     * **Note:** Many canvas items such as [Camera2D] or [CollisionShape2D] automatically enable
     * this in order to function correctly.
     */
    public final const val NOTIFICATION_LOCAL_TRANSFORM_CHANGED: Long = 35

    /**
     * The [CanvasItem] is requested to draw (see [_draw]).
     */
    public final const val NOTIFICATION_DRAW: Long = 30

    /**
     * Notification received when this node's visibility changes (see [visible] and
     * [isVisibleInTree]).
     *
     * This notification is received *before* the related [signal visibility_changed] signal.
     */
    public final const val NOTIFICATION_VISIBILITY_CHANGED: Long = 31

    /**
     * The [CanvasItem] has entered the canvas.
     */
    public final const val NOTIFICATION_ENTER_CANVAS: Long = 32

    /**
     * The [CanvasItem] has exited the canvas.
     *
     * This notification is sent in reversed order.
     */
    public final const val NOTIFICATION_EXIT_CANVAS: Long = 33

    /**
     * Notification received when this [CanvasItem] is registered to a new [World2D] (see
     * [getWorld2d]).
     */
    public final const val NOTIFICATION_WORLD_2D_CHANGED: Long = 36
  }

  public object MethodBindings {
    internal val getCanvasItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_canvas_item", 2944877500)

    internal val setVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_visible", 2586408642)

    internal val isVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "is_visible", 36873697)

    internal val isVisibleInTreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "is_visible_in_tree", 36873697)

    internal val showPtr: VoidPtr = TypeManager.getMethodBindPtr("CanvasItem", "show", 3218959716)

    internal val hidePtr: VoidPtr = TypeManager.getMethodBindPtr("CanvasItem", "hide", 3218959716)

    internal val queueRedrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "queue_redraw", 3218959716)

    internal val moveToFrontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "move_to_front", 3218959716)

    internal val setAsTopLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_as_top_level", 2586408642)

    internal val isSetAsTopLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "is_set_as_top_level", 36873697)

    internal val setLightMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_light_mask", 1286410249)

    internal val getLightMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_light_mask", 3905245786)

    internal val setModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_modulate", 2920490490)

    internal val getModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_modulate", 3444240500)

    internal val setSelfModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_self_modulate", 2920490490)

    internal val getSelfModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_self_modulate", 3444240500)

    internal val setZIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_z_index", 1286410249)

    internal val getZIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_z_index", 3905245786)

    internal val setZAsRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_z_as_relative", 2586408642)

    internal val isZRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "is_z_relative", 36873697)

    internal val setYSortEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_y_sort_enabled", 2586408642)

    internal val isYSortEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "is_y_sort_enabled", 36873697)

    internal val setDrawBehindParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_draw_behind_parent", 2586408642)

    internal val isDrawBehindParentEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "is_draw_behind_parent_enabled", 36873697)

    internal val drawLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_line", 1562330099)

    internal val drawDashedLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_dashed_line", 3653831622)

    internal val drawPolylinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_polyline", 3797364428)

    internal val drawPolylineColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_polyline_colors", 2311979562)

    internal val drawEllipseArcPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_ellipse_arc", 936174114)

    internal val drawArcPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_arc", 4140652635)

    internal val drawMultilinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_multiline", 3797364428)

    internal val drawMultilineColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_multiline_colors", 2311979562)

    internal val drawRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_rect", 2773573813)

    internal val drawCirclePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_circle", 3153026596)

    internal val drawEllipsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_ellipse", 3790774806)

    internal val drawTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_texture", 520200117)

    internal val drawTextureRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_texture_rect", 3832805018)

    internal val drawTextureRectRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_texture_rect_region", 3883821411)

    internal val drawMsdfTextureRectRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_msdf_texture_rect_region", 4219163252)

    internal val drawLcdTextureRectRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_lcd_texture_rect_region", 3212350954)

    internal val drawStyleBoxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_style_box", 388176283)

    internal val drawPrimitivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_primitive", 3288481815)

    internal val drawPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_polygon", 974537912)

    internal val drawColoredPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_colored_polygon", 15245644)

    internal val drawStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_string", 719605945)

    internal val drawMultilineStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_multiline_string", 2341488182)

    internal val drawStringOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_string_outline", 707403449)

    internal val drawMultilineStringOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_multiline_string_outline", 3050414441)

    internal val drawCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_char", 1336210142)

    internal val drawCharOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_char_outline", 1846384149)

    internal val drawMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_mesh", 153818295)

    internal val drawMultimeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_multimesh", 937992368)

    internal val drawSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_set_transform", 288975085)

    internal val drawSetTransformMatrixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_set_transform_matrix", 2761652528)

    internal val drawAnimationSlicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_animation_slice", 3112831842)

    internal val drawEndAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "draw_end_animation", 3218959716)

    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_transform", 3814499831)

    internal val getGlobalTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_global_transform", 3814499831)

    internal val getGlobalTransformWithCanvasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_global_transform_with_canvas", 3814499831)

    internal val getViewportTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_viewport_transform", 3814499831)

    internal val getViewportRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_viewport_rect", 1639390495)

    internal val getCanvasTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_canvas_transform", 3814499831)

    internal val getScreenTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_screen_transform", 3814499831)

    internal val getLocalMousePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_local_mouse_position", 3341600327)

    internal val getGlobalMousePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_global_mouse_position", 3341600327)

    internal val getCanvasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_canvas", 2944877500)

    internal val getCanvasLayerNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_canvas_layer_node", 2602762519)

    internal val getWorld2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_world_2d", 2339128592)

    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_material", 5934680)

    internal val setInstanceShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_instance_shader_parameter", 3776071444)

    internal val getInstanceShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_instance_shader_parameter", 2760726917)

    internal val setUseParentMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_use_parent_material", 2586408642)

    internal val getUseParentMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_use_parent_material", 36873697)

    internal val setNotifyLocalTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_notify_local_transform", 2586408642)

    internal val isLocalTransformNotificationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "is_local_transform_notification_enabled", 36873697)

    internal val setNotifyTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_notify_transform", 2586408642)

    internal val isTransformNotificationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "is_transform_notification_enabled", 36873697)

    internal val forceUpdateTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "force_update_transform", 3218959716)

    internal val makeCanvasPositionLocalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "make_canvas_position_local", 2656412154)

    internal val makeInputLocalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "make_input_local", 811130057)

    internal val setVisibilityLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_visibility_layer", 1286410249)

    internal val getVisibilityLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_visibility_layer", 3905245786)

    internal val setVisibilityLayerBitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_visibility_layer_bit", 300928843)

    internal val getVisibilityLayerBitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_visibility_layer_bit", 1116898809)

    internal val setTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_texture_filter", 1037999706)

    internal val getTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_texture_filter", 121960042)

    internal val setTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_texture_repeat", 1716472974)

    internal val getTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_texture_repeat", 2667158319)

    internal val setClipChildrenModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_clip_children_mode", 1319393776)

    internal val getClipChildrenModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_clip_children_mode", 3581808349)

    internal val setOversamplingWithScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "set_oversampling_with_scale", 872218804)

    internal val getOversamplingWithScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItem", "get_oversampling_with_scale", 2026097197)
  }
}
