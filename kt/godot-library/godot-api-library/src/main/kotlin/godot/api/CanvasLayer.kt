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
import godot.core.RID
import godot.core.Signal0
import godot.core.Transform2D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser._RID
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
 * [CanvasItem]-derived nodes that are direct or indirect children of a [CanvasLayer] will be drawn
 * in that layer. The layer is a numeric index that defines the draw order. The default 2D scene
 * renders with index `0`, so a [CanvasLayer] with index `-1` will be drawn below, and a [CanvasLayer]
 * with index `1` will be drawn above. This order will hold regardless of the [CanvasItem.zIndex] of
 * the nodes within each layer.
 *
 * [CanvasLayer]s can be hidden and they can also optionally follow the viewport. This makes them
 * useful for HUDs like health bar overlays (on layers `1` and higher) or backgrounds (on layers `-1`
 * and lower).
 *
 * **Note:** Embedded [Window]s are placed on layer `1024`. [CanvasItem]s on layers `1025` and
 * higher appear in front of embedded windows.
 *
 * **Note:** Each [CanvasLayer] is drawn on one specific [Viewport] and cannot be shared between
 * multiple [Viewport]s, see [customViewport]. When using multiple [Viewport]s, for example in a
 * split-screen game, you need to create an individual [CanvasLayer] for each [Viewport] you want it to
 * be drawn on.
 */
@GodotBaseType
public open class CanvasLayer : Node() {
  /**
   * Emitted when visibility of the layer is changed. See [visible].
   */
  public val visibilityChanged: Signal0 by Signal0

  /**
   * Layer index for draw order. Lower values are drawn behind higher values.
   *
   * **Note:** If multiple CanvasLayers have the same layer index, [CanvasItem] children of one
   * CanvasLayer are drawn behind the [CanvasItem] children of the other CanvasLayer. Which CanvasLayer
   * is drawn in front is non-deterministic.
   *
   * **Note:** The layer index should be between [RenderingServer.CANVAS_LAYER_MIN] and
   * [RenderingServer.CANVAS_LAYER_MAX] (inclusive). Any other value will wrap around.
   */
  public final inline var layer: Int
    @JvmName("layerProperty")
    get() = getLayer()
    @JvmName("layerProperty")
    set(`value`) {
      setLayer(value)
    }

  /**
   * If `false`, any [CanvasItem] under this [CanvasLayer] will be hidden.
   *
   * Unlike [CanvasItem.visible], visibility of a [CanvasLayer] isn't propagated to underlying
   * layers.
   */
  public final inline var visible: Boolean
    @JvmName("visibleProperty")
    get() = isVisible()
    @JvmName("visibleProperty")
    set(`value`) {
      setVisible(value)
    }

  /**
   * The layer's base offset.
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
   * The layer's rotation in radians.
   */
  public final inline var rotation: Float
    @JvmName("rotationProperty")
    get() = getRotation()
    @JvmName("rotationProperty")
    set(`value`) {
      setRotation(value)
    }

  /**
   * The layer's scale.
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
   * The layer's transform.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var transform: Transform2D
    @JvmName("transformProperty")
    get() = getTransform()
    @JvmName("transformProperty")
    set(`value`) {
      setTransform(value)
    }

  /**
   * The custom [Viewport] node assigned to the [CanvasLayer]. If `null`, uses the default viewport
   * instead.
   */
  public final inline var customViewport: Node?
    @JvmName("customViewportProperty")
    get() = getCustomViewport()
    @JvmName("customViewportProperty")
    set(`value`) {
      setCustomViewport(value)
    }

  /**
   * If enabled, the [CanvasLayer] maintains its position in world space. If disabled, the
   * [CanvasLayer] stays in a fixed position on the screen.
   *
   * Together with [followViewportScale], this can be used for a pseudo-3D effect.
   */
  public final inline var followViewportEnabled: Boolean
    @JvmName("followViewportEnabledProperty")
    get() = isFollowingViewport()
    @JvmName("followViewportEnabledProperty")
    set(`value`) {
      setFollowViewport(value)
    }

  /**
   * Scales the layer when using [followViewportEnabled]. Layers moving into the foreground should
   * have increasing scales, while layers moving into the background should have decreasing scales.
   */
  public final inline var followViewportScale: Float
    @JvmName("followViewportScaleProperty")
    get() = getFollowViewportScale()
    @JvmName("followViewportScaleProperty")
    set(`value`) {
      setFollowViewportScale(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(146, scriptPtr)
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = canvaslayer.offset
   * //Your changes
   * canvaslayer.offset = myCoreType
   * ``````
   *
   * The layer's base offset.
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  /**
   * This is a helper function for [scale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = canvaslayer.scale
   * //Your changes
   * canvaslayer.scale = myCoreType
   * ``````
   *
   * The layer's scale.
   */
  @CoreTypeHelper
  public final fun scaleMutate(block: Vector2.() -> Unit): Vector2 = scale.apply {
     block(this)
     scale = this
  }

  /**
   * This is a helper function for [transform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = canvaslayer.transform
   * //Your changes
   * canvaslayer.transform = myCoreType
   * ``````
   *
   * The layer's transform.
   */
  @CoreTypeHelper
  public final fun transformMutate(block: Transform2D.() -> Unit): Transform2D = transform.apply {
     block(this)
     transform = this
  }

  public final fun setLayer(layer: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.setLayerPtr)
  }

  public final fun getLayer(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
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
   * Shows any [CanvasItem] under this [CanvasLayer]. This is equivalent to setting [visible] to
   * `true`.
   */
  public final fun show(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.showPtr)
  }

  /**
   * Hides any [CanvasItem] under this [CanvasLayer]. This is equivalent to setting [visible] to
   * `false`.
   */
  public final fun hide(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hidePtr)
  }

  public final fun setTransform(transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.setTransformPtr)
  }

  public final fun getTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the transform from the [CanvasLayer]s coordinate system to the [Viewport]s coordinate
   * system.
   */
  public final fun getFinalTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFinalTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
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

  public final fun setRotation(radians: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radians.toDouble())
    TransferContext.callMethod(MethodBindings.setRotationPtr)
  }

  public final fun getRotation(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setScale(scale: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to scale)
    TransferContext.callMethod(MethodBindings.setScalePtr)
  }

  public final fun getScale(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScalePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setFollowViewport(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setFollowViewportPtr)
  }

  public final fun isFollowingViewport(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFollowingViewportPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFollowViewportScale(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setFollowViewportScalePtr)
  }

  public final fun getFollowViewportScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFollowViewportScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
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

  /**
   * Returns the RID of the canvas used by this layer.
   */
  public final fun getCanvas(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public companion object {
    @JvmField
    public val setLayerName: MethodStringName1<CanvasLayer, Unit, Int> =
        MethodStringName1<CanvasLayer, Unit, Int>("set_layer")

    @JvmField
    public val getLayerName: MethodStringName0<CanvasLayer, Int> =
        MethodStringName0<CanvasLayer, Int>("get_layer")

    @JvmField
    public val setVisibleName: MethodStringName1<CanvasLayer, Unit, Boolean> =
        MethodStringName1<CanvasLayer, Unit, Boolean>("set_visible")

    @JvmField
    public val isVisibleName: MethodStringName0<CanvasLayer, Boolean> =
        MethodStringName0<CanvasLayer, Boolean>("is_visible")

    @JvmField
    public val showName: MethodStringName0<CanvasLayer, Unit> =
        MethodStringName0<CanvasLayer, Unit>("show")

    @JvmField
    public val hideName: MethodStringName0<CanvasLayer, Unit> =
        MethodStringName0<CanvasLayer, Unit>("hide")

    @JvmField
    public val setTransformName: MethodStringName1<CanvasLayer, Unit, Transform2D> =
        MethodStringName1<CanvasLayer, Unit, Transform2D>("set_transform")

    @JvmField
    public val getTransformName: MethodStringName0<CanvasLayer, Transform2D> =
        MethodStringName0<CanvasLayer, Transform2D>("get_transform")

    @JvmField
    public val getFinalTransformName: MethodStringName0<CanvasLayer, Transform2D> =
        MethodStringName0<CanvasLayer, Transform2D>("get_final_transform")

    @JvmField
    public val setOffsetName: MethodStringName1<CanvasLayer, Unit, Vector2> =
        MethodStringName1<CanvasLayer, Unit, Vector2>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<CanvasLayer, Vector2> =
        MethodStringName0<CanvasLayer, Vector2>("get_offset")

    @JvmField
    public val setRotationName: MethodStringName1<CanvasLayer, Unit, Float> =
        MethodStringName1<CanvasLayer, Unit, Float>("set_rotation")

    @JvmField
    public val getRotationName: MethodStringName0<CanvasLayer, Float> =
        MethodStringName0<CanvasLayer, Float>("get_rotation")

    @JvmField
    public val setScaleName: MethodStringName1<CanvasLayer, Unit, Vector2> =
        MethodStringName1<CanvasLayer, Unit, Vector2>("set_scale")

    @JvmField
    public val getScaleName: MethodStringName0<CanvasLayer, Vector2> =
        MethodStringName0<CanvasLayer, Vector2>("get_scale")

    @JvmField
    public val setFollowViewportName: MethodStringName1<CanvasLayer, Unit, Boolean> =
        MethodStringName1<CanvasLayer, Unit, Boolean>("set_follow_viewport")

    @JvmField
    public val isFollowingViewportName: MethodStringName0<CanvasLayer, Boolean> =
        MethodStringName0<CanvasLayer, Boolean>("is_following_viewport")

    @JvmField
    public val setFollowViewportScaleName: MethodStringName1<CanvasLayer, Unit, Float> =
        MethodStringName1<CanvasLayer, Unit, Float>("set_follow_viewport_scale")

    @JvmField
    public val getFollowViewportScaleName: MethodStringName0<CanvasLayer, Float> =
        MethodStringName0<CanvasLayer, Float>("get_follow_viewport_scale")

    @JvmField
    public val setCustomViewportName: MethodStringName1<CanvasLayer, Unit, Node?> =
        MethodStringName1<CanvasLayer, Unit, Node?>("set_custom_viewport")

    @JvmField
    public val getCustomViewportName: MethodStringName0<CanvasLayer, Node?> =
        MethodStringName0<CanvasLayer, Node?>("get_custom_viewport")

    @JvmField
    public val getCanvasName: MethodStringName0<CanvasLayer, RID> =
        MethodStringName0<CanvasLayer, RID>("get_canvas")
  }

  public object MethodBindings {
    internal val setLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_layer", 1286410249)

    internal val getLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_layer", 3905245786)

    internal val setVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_visible", 2586408642)

    internal val isVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "is_visible", 36873697)

    internal val showPtr: VoidPtr = TypeManager.getMethodBindPtr("CanvasLayer", "show", 3218959716)

    internal val hidePtr: VoidPtr = TypeManager.getMethodBindPtr("CanvasLayer", "hide", 3218959716)

    internal val setTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_transform", 2761652528)

    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_transform", 3814499831)

    internal val getFinalTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_final_transform", 3814499831)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_offset", 743155724)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_offset", 3341600327)

    internal val setRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_rotation", 373806689)

    internal val getRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_rotation", 1740695150)

    internal val setScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_scale", 743155724)

    internal val getScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_scale", 3341600327)

    internal val setFollowViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_follow_viewport", 2586408642)

    internal val isFollowingViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "is_following_viewport", 36873697)

    internal val setFollowViewportScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_follow_viewport_scale", 373806689)

    internal val getFollowViewportScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_follow_viewport_scale", 1740695150)

    internal val setCustomViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "set_custom_viewport", 1078189570)

    internal val getCustomViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_custom_viewport", 3160264692)

    internal val getCanvasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasLayer", "get_canvas", 2944877500)
  }
}
