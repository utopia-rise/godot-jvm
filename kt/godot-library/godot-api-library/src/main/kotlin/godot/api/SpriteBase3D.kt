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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Rect2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.Vector3
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
 * A node that displays 2D texture information in a 3D environment. See also [Sprite3D] where many
 * other properties are defined.
 */
@GodotBaseType
public open class SpriteBase3D internal constructor() : GeometryInstance3D() {
  /**
   * If `true`, texture will be centered.
   */
  public final inline var centered: Boolean
    @JvmName("centeredProperty")
    get() = isCentered()
    @JvmName("centeredProperty")
    set(`value`) {
      setCentered(value)
    }

  /**
   * The texture's drawing offset.
   *
   * **Note:** When you increase [offset].y in Sprite3D, the sprite moves upward in world space
   * (i.e., +Y is up).
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
   * If `true`, texture is flipped horizontally.
   */
  public final inline var flipH: Boolean
    @JvmName("flipHProperty")
    get() = isFlippedH()
    @JvmName("flipHProperty")
    set(`value`) {
      setFlipH(value)
    }

  /**
   * If `true`, texture is flipped vertically.
   */
  public final inline var flipV: Boolean
    @JvmName("flipVProperty")
    get() = isFlippedV()
    @JvmName("flipVProperty")
    set(`value`) {
      setFlipV(value)
    }

  /**
   * A color value used to *multiply* the texture's colors. Can be used for mood-coloring or to
   * simulate the color of ambient light.
   *
   * **Note:** Unlike [CanvasItem.modulate] for 2D, colors with values above `1.0` (overbright) are
   * not supported.
   *
   * **Note:** If a [GeometryInstance3D.materialOverride] is defined on the [SpriteBase3D], the
   * material override must be configured to take vertex colors into account for albedo. Otherwise, the
   * color defined in [modulate] will be ignored. For a [BaseMaterial3D],
   * [BaseMaterial3D.vertexColorUseAsAlbedo] must be `true`. For a [ShaderMaterial], `ALBEDO *=
   * COLOR.rgb;` must be inserted in the shader's `fragment()` function.
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
   * The size of one pixel's width on the sprite to scale it in 3D.
   */
  public final inline var pixelSize: Float
    @JvmName("pixelSizeProperty")
    get() = getPixelSize()
    @JvmName("pixelSizeProperty")
    set(`value`) {
      setPixelSize(value)
    }

  /**
   * The direction in which the front of the texture faces.
   */
  public final inline var axis: Vector3.Axis
    @JvmName("axisProperty")
    get() = getAxis()
    @JvmName("axisProperty")
    set(`value`) {
      setAxis(value)
    }

  /**
   * The billboard mode to use for the sprite.
   *
   * **Note:** When billboarding is enabled and the material also casts shadows, billboards will
   * face **the** camera in the scene when rendering shadows. In scenes with multiple cameras, the
   * intended shadow cannot be determined and this will result in undefined behavior. See
   * [url=https://github.com/godotengine/godot/pull/72638]GitHub Pull Request #72638[/url] for details.
   */
  public final inline var billboard: BaseMaterial3D.BillboardMode
    @JvmName("billboardProperty")
    get() = getBillboardMode()
    @JvmName("billboardProperty")
    set(`value`) {
      setBillboardMode(value)
    }

  /**
   * If `true`, the texture's transparency and the opacity are used to make those parts of the
   * sprite invisible.
   */
  public final inline var transparent: Boolean
    @JvmName("transparentProperty")
    get() = getDrawFlag(SpriteBase3D.DrawFlags.FLAG_TRANSPARENT)
    @JvmName("transparentProperty")
    set(`value`) {
      setDrawFlag(SpriteBase3D.DrawFlags.FLAG_TRANSPARENT, value)
    }

  /**
   * If `true`, the [Light3D] in the [Environment] has effects on the sprite.
   */
  public final inline var shaded: Boolean
    @JvmName("shadedProperty")
    get() = getDrawFlag(SpriteBase3D.DrawFlags.FLAG_SHADED)
    @JvmName("shadedProperty")
    set(`value`) {
      setDrawFlag(SpriteBase3D.DrawFlags.FLAG_SHADED, value)
    }

  /**
   * If `true`, texture can be seen from the back as well, if `false`, it is invisible when looking
   * at it from behind.
   */
  public final inline var doubleSided: Boolean
    @JvmName("doubleSidedProperty")
    get() = getDrawFlag(SpriteBase3D.DrawFlags.FLAG_DOUBLE_SIDED)
    @JvmName("doubleSidedProperty")
    set(`value`) {
      setDrawFlag(SpriteBase3D.DrawFlags.FLAG_DOUBLE_SIDED, value)
    }

  /**
   * If `true`, depth testing is disabled and the object will be drawn in render order.
   */
  public final inline var noDepthTest: Boolean
    @JvmName("noDepthTestProperty")
    get() = getDrawFlag(SpriteBase3D.DrawFlags.FLAG_DISABLE_DEPTH_TEST)
    @JvmName("noDepthTestProperty")
    set(`value`) {
      setDrawFlag(SpriteBase3D.DrawFlags.FLAG_DISABLE_DEPTH_TEST, value)
    }

  /**
   * If `true`, the texture is rendered at the same size regardless of distance. The texture's size
   * on screen is the same as if the camera was `1.0` units away from the texture's origin, regardless
   * of the actual distance from the camera. The [Camera3D]'s field of view (or [Camera3D.size] when in
   * orthogonal/frustum mode) still affects the size the sprite is drawn at.
   */
  public final inline var fixedSize: Boolean
    @JvmName("fixedSizeProperty")
    get() = getDrawFlag(SpriteBase3D.DrawFlags.FLAG_FIXED_SIZE)
    @JvmName("fixedSizeProperty")
    set(`value`) {
      setDrawFlag(SpriteBase3D.DrawFlags.FLAG_FIXED_SIZE, value)
    }

  /**
   * The alpha cutting mode to use for the sprite.
   */
  public final inline var alphaCut: AlphaCutMode
    @JvmName("alphaCutProperty")
    get() = getAlphaCutMode()
    @JvmName("alphaCutProperty")
    set(`value`) {
      setAlphaCutMode(value)
    }

  /**
   * Threshold at which the alpha scissor will discard values.
   */
  public final inline var alphaScissorThreshold: Float
    @JvmName("alphaScissorThresholdProperty")
    get() = getAlphaScissorThreshold()
    @JvmName("alphaScissorThresholdProperty")
    set(`value`) {
      setAlphaScissorThreshold(value)
    }

  /**
   * The hashing scale for Alpha Hash. Recommended values between `0` and `2`.
   */
  public final inline var alphaHashScale: Float
    @JvmName("alphaHashScaleProperty")
    get() = getAlphaHashScale()
    @JvmName("alphaHashScaleProperty")
    set(`value`) {
      setAlphaHashScale(value)
    }

  /**
   * The type of alpha antialiasing to apply.
   */
  public final inline var alphaAntialiasingMode: BaseMaterial3D.AlphaAntiAliasing
    @JvmName("alphaAntialiasingModeProperty")
    get() = getAlphaAntialiasing()
    @JvmName("alphaAntialiasingModeProperty")
    set(`value`) {
      setAlphaAntialiasing(value)
    }

  /**
   * Threshold at which antialiasing will be applied on the alpha channel.
   */
  public final inline var alphaAntialiasingEdge: Float
    @JvmName("alphaAntialiasingEdgeProperty")
    get() = getAlphaAntialiasingEdge()
    @JvmName("alphaAntialiasingEdgeProperty")
    set(`value`) {
      setAlphaAntialiasingEdge(value)
    }

  /**
   * Filter flags for the texture.
   *
   * **Note:** Linear filtering may cause artifacts around the edges, which are especially
   * noticeable on opaque textures. To prevent this, use textures with transparent or identical colors
   * around the edges.
   */
  public final inline var textureFilter: BaseMaterial3D.TextureFilter
    @JvmName("textureFilterProperty")
    get() = getTextureFilter()
    @JvmName("textureFilterProperty")
    set(`value`) {
      setTextureFilter(value)
    }

  /**
   * Sets the render priority for the sprite. Higher priority objects will be sorted in front of
   * lower priority objects.
   *
   * **Note:** This only applies if [alphaCut] is set to [ALPHA_CUT_DISABLED] (default value).
   *
   * **Note:** This only applies to sorting of transparent objects. This will not impact how
   * transparent objects are sorted relative to opaque objects. This is because opaque objects are not
   * sorted, while transparent objects are sorted from back to front (subject to priority).
   */
  public final inline var renderPriority: Int
    @JvmName("renderPriorityProperty")
    get() = getRenderPriority()
    @JvmName("renderPriorityProperty")
    set(`value`) {
      setRenderPriority(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(701, scriptPtr)
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = spritebase3d.offset
   * //Your changes
   * spritebase3d.offset = myCoreType
   * ``````
   *
   * The texture's drawing offset.
   *
   * **Note:** When you increase [offset].y in Sprite3D, the sprite moves upward in world space
   * (i.e., +Y is up).
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector2.() -> Unit): Vector2 = offset.apply {
     block(this)
     offset = this
  }

  /**
   * This is a helper function for [modulate] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = spritebase3d.modulate
   * //Your changes
   * spritebase3d.modulate = myCoreType
   * ``````
   *
   * A color value used to *multiply* the texture's colors. Can be used for mood-coloring or to
   * simulate the color of ambient light.
   *
   * **Note:** Unlike [CanvasItem.modulate] for 2D, colors with values above `1.0` (overbright) are
   * not supported.
   *
   * **Note:** If a [GeometryInstance3D.materialOverride] is defined on the [SpriteBase3D], the
   * material override must be configured to take vertex colors into account for albedo. Otherwise, the
   * color defined in [modulate] will be ignored. For a [BaseMaterial3D],
   * [BaseMaterial3D.vertexColorUseAsAlbedo] must be `true`. For a [ShaderMaterial], `ALBEDO *=
   * COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   */
  @CoreTypeHelper
  public final fun modulateMutate(block: Color.() -> Unit): Color = modulate.apply {
     block(this)
     modulate = this
  }

  public final fun setCentered(centered: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to centered)
    TransferContext.callMethod(MethodBindings.setCenteredPtr)
  }

  public final fun isCentered(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCenteredPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
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

  public final fun setFlipH(flipH: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flipH)
    TransferContext.callMethod(MethodBindings.setFlipHPtr)
  }

  public final fun isFlippedH(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFlippedHPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFlipV(flipV: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flipV)
    TransferContext.callMethod(MethodBindings.setFlipVPtr)
  }

  public final fun isFlippedV(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFlippedVPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
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

  public final fun setRenderPriority(priority: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to priority.toLong())
    TransferContext.callMethod(MethodBindings.setRenderPriorityPtr)
  }

  public final fun getRenderPriority(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderPriorityPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setPixelSize(pixelSize: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pixelSize.toDouble())
    TransferContext.callMethod(MethodBindings.setPixelSizePtr)
  }

  public final fun getPixelSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPixelSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAxis(axis: Vector3.Axis): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to axis.value)
    TransferContext.callMethod(MethodBindings.setAxisPtr)
  }

  public final fun getAxis(): Vector3.Axis {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAxisPtr)
    return Vector3.Axis.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If `true`, the specified flag will be enabled.
   */
  public final fun setDrawFlag(flag: DrawFlags, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setDrawFlagPtr)
  }

  /**
   * Returns the value of the specified flag.
   */
  public final fun getDrawFlag(flag: DrawFlags): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value)
    TransferContext.callMethod(MethodBindings.getDrawFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAlphaCutMode(mode: AlphaCutMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setAlphaCutModePtr)
  }

  public final fun getAlphaCutMode(): AlphaCutMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaCutModePtr)
    return AlphaCutMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAlphaScissorThreshold(threshold: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to threshold.toDouble())
    TransferContext.callMethod(MethodBindings.setAlphaScissorThresholdPtr)
  }

  public final fun getAlphaScissorThreshold(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaScissorThresholdPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAlphaHashScale(threshold: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to threshold.toDouble())
    TransferContext.callMethod(MethodBindings.setAlphaHashScalePtr)
  }

  public final fun getAlphaHashScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaHashScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAlphaAntialiasing(alphaAa: BaseMaterial3D.AlphaAntiAliasing): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to alphaAa.value)
    TransferContext.callMethod(MethodBindings.setAlphaAntialiasingPtr)
  }

  public final fun getAlphaAntialiasing(): BaseMaterial3D.AlphaAntiAliasing {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaAntialiasingPtr)
    return BaseMaterial3D.AlphaAntiAliasing.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAlphaAntialiasingEdge(edge: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to edge.toDouble())
    TransferContext.callMethod(MethodBindings.setAlphaAntialiasingEdgePtr)
  }

  public final fun getAlphaAntialiasingEdge(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaAntialiasingEdgePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBillboardMode(mode: BaseMaterial3D.BillboardMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setBillboardModePtr)
  }

  public final fun getBillboardMode(): BaseMaterial3D.BillboardMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBillboardModePtr)
    return BaseMaterial3D.BillboardMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTextureFilter(mode: BaseMaterial3D.TextureFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTextureFilterPtr)
  }

  public final fun getTextureFilter(): BaseMaterial3D.TextureFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureFilterPtr)
    return BaseMaterial3D.TextureFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the rectangle representing this sprite.
   */
  public final fun getItemRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getItemRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Returns a [TriangleMesh] with the sprite's vertices following its current configuration (such
   * as its [axis] and [pixelSize]).
   */
  public final fun generateTriangleMesh(): TriangleMesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.generateTriangleMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as TriangleMesh?)
  }

  public enum class DrawFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If set, the texture's transparency and the opacity are used to make those parts of the sprite
     * invisible.
     */
    FLAG_TRANSPARENT(0),
    /**
     * If set, lights in the environment affect the sprite.
     */
    FLAG_SHADED(1),
    /**
     * If set, texture can be seen from the back as well. If not, the texture is invisible when
     * looking at it from behind.
     */
    FLAG_DOUBLE_SIDED(2),
    /**
     * Disables the depth test, so this object is drawn on top of all others. However, objects drawn
     * after it in the draw order may cover it.
     */
    FLAG_DISABLE_DEPTH_TEST(3),
    /**
     * Label is scaled by depth so that it always appears the same size on screen.
     */
    FLAG_FIXED_SIZE(4),
    /**
     * Represents the size of the [DrawFlags] enum.
     */
    FLAG_MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): DrawFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class AlphaCutMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This mode performs standard alpha blending. It can display translucent areas, but
     * transparency sorting issues may be visible when multiple transparent materials are overlapping.
     */
    DISABLED(0),
    /**
     * This mode only allows fully transparent or fully opaque pixels. Harsh edges will be visible
     * unless some form of screen-space antialiasing is enabled (see
     * [ProjectSettings.rendering/antiAliasing/quality/screenSpaceAa]). On the bright side, this mode
     * doesn't suffer from transparency sorting issues when multiple transparent materials are
     * overlapping. This mode is also known as *alpha testing* or *1-bit transparency*.
     */
    DISCARD(1),
    /**
     * This mode draws fully opaque pixels in the depth prepass. This is slower than
     * [ALPHA_CUT_DISABLED] or [ALPHA_CUT_DISCARD], but it allows displaying translucent areas and
     * smooth edges while using proper sorting.
     */
    OPAQUE_PREPASS(2),
    /**
     * This mode draws cuts off all values below a spatially-deterministic threshold, the rest will
     * remain opaque.
     */
    HASH(3),
    ;

    public companion object {
      public fun from(`value`: Long): AlphaCutMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setCenteredName: MethodStringName1<SpriteBase3D, Unit, Boolean> =
        MethodStringName1<SpriteBase3D, Unit, Boolean>("set_centered")

    @JvmField
    public val isCenteredName: MethodStringName0<SpriteBase3D, Boolean> =
        MethodStringName0<SpriteBase3D, Boolean>("is_centered")

    @JvmField
    public val setOffsetName: MethodStringName1<SpriteBase3D, Unit, Vector2> =
        MethodStringName1<SpriteBase3D, Unit, Vector2>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<SpriteBase3D, Vector2> =
        MethodStringName0<SpriteBase3D, Vector2>("get_offset")

    @JvmField
    public val setFlipHName: MethodStringName1<SpriteBase3D, Unit, Boolean> =
        MethodStringName1<SpriteBase3D, Unit, Boolean>("set_flip_h")

    @JvmField
    public val isFlippedHName: MethodStringName0<SpriteBase3D, Boolean> =
        MethodStringName0<SpriteBase3D, Boolean>("is_flipped_h")

    @JvmField
    public val setFlipVName: MethodStringName1<SpriteBase3D, Unit, Boolean> =
        MethodStringName1<SpriteBase3D, Unit, Boolean>("set_flip_v")

    @JvmField
    public val isFlippedVName: MethodStringName0<SpriteBase3D, Boolean> =
        MethodStringName0<SpriteBase3D, Boolean>("is_flipped_v")

    @JvmField
    public val setModulateName: MethodStringName1<SpriteBase3D, Unit, Color> =
        MethodStringName1<SpriteBase3D, Unit, Color>("set_modulate")

    @JvmField
    public val getModulateName: MethodStringName0<SpriteBase3D, Color> =
        MethodStringName0<SpriteBase3D, Color>("get_modulate")

    @JvmField
    public val setRenderPriorityName: MethodStringName1<SpriteBase3D, Unit, Int> =
        MethodStringName1<SpriteBase3D, Unit, Int>("set_render_priority")

    @JvmField
    public val getRenderPriorityName: MethodStringName0<SpriteBase3D, Int> =
        MethodStringName0<SpriteBase3D, Int>("get_render_priority")

    @JvmField
    public val setPixelSizeName: MethodStringName1<SpriteBase3D, Unit, Float> =
        MethodStringName1<SpriteBase3D, Unit, Float>("set_pixel_size")

    @JvmField
    public val getPixelSizeName: MethodStringName0<SpriteBase3D, Float> =
        MethodStringName0<SpriteBase3D, Float>("get_pixel_size")

    @JvmField
    public val setAxisName: MethodStringName1<SpriteBase3D, Unit, Vector3.Axis> =
        MethodStringName1<SpriteBase3D, Unit, Vector3.Axis>("set_axis")

    @JvmField
    public val getAxisName: MethodStringName0<SpriteBase3D, Vector3.Axis> =
        MethodStringName0<SpriteBase3D, Vector3.Axis>("get_axis")

    @JvmField
    public val setDrawFlagName: MethodStringName2<SpriteBase3D, Unit, DrawFlags, Boolean> =
        MethodStringName2<SpriteBase3D, Unit, DrawFlags, Boolean>("set_draw_flag")

    @JvmField
    public val getDrawFlagName: MethodStringName1<SpriteBase3D, Boolean, DrawFlags> =
        MethodStringName1<SpriteBase3D, Boolean, DrawFlags>("get_draw_flag")

    @JvmField
    public val setAlphaCutModeName: MethodStringName1<SpriteBase3D, Unit, AlphaCutMode> =
        MethodStringName1<SpriteBase3D, Unit, AlphaCutMode>("set_alpha_cut_mode")

    @JvmField
    public val getAlphaCutModeName: MethodStringName0<SpriteBase3D, AlphaCutMode> =
        MethodStringName0<SpriteBase3D, AlphaCutMode>("get_alpha_cut_mode")

    @JvmField
    public val setAlphaScissorThresholdName: MethodStringName1<SpriteBase3D, Unit, Float> =
        MethodStringName1<SpriteBase3D, Unit, Float>("set_alpha_scissor_threshold")

    @JvmField
    public val getAlphaScissorThresholdName: MethodStringName0<SpriteBase3D, Float> =
        MethodStringName0<SpriteBase3D, Float>("get_alpha_scissor_threshold")

    @JvmField
    public val setAlphaHashScaleName: MethodStringName1<SpriteBase3D, Unit, Float> =
        MethodStringName1<SpriteBase3D, Unit, Float>("set_alpha_hash_scale")

    @JvmField
    public val getAlphaHashScaleName: MethodStringName0<SpriteBase3D, Float> =
        MethodStringName0<SpriteBase3D, Float>("get_alpha_hash_scale")

    @JvmField
    public val setAlphaAntialiasingName:
        MethodStringName1<SpriteBase3D, Unit, BaseMaterial3D.AlphaAntiAliasing> =
        MethodStringName1<SpriteBase3D, Unit, BaseMaterial3D.AlphaAntiAliasing>("set_alpha_antialiasing")

    @JvmField
    public val getAlphaAntialiasingName:
        MethodStringName0<SpriteBase3D, BaseMaterial3D.AlphaAntiAliasing> =
        MethodStringName0<SpriteBase3D, BaseMaterial3D.AlphaAntiAliasing>("get_alpha_antialiasing")

    @JvmField
    public val setAlphaAntialiasingEdgeName: MethodStringName1<SpriteBase3D, Unit, Float> =
        MethodStringName1<SpriteBase3D, Unit, Float>("set_alpha_antialiasing_edge")

    @JvmField
    public val getAlphaAntialiasingEdgeName: MethodStringName0<SpriteBase3D, Float> =
        MethodStringName0<SpriteBase3D, Float>("get_alpha_antialiasing_edge")

    @JvmField
    public val setBillboardModeName:
        MethodStringName1<SpriteBase3D, Unit, BaseMaterial3D.BillboardMode> =
        MethodStringName1<SpriteBase3D, Unit, BaseMaterial3D.BillboardMode>("set_billboard_mode")

    @JvmField
    public val getBillboardModeName: MethodStringName0<SpriteBase3D, BaseMaterial3D.BillboardMode> =
        MethodStringName0<SpriteBase3D, BaseMaterial3D.BillboardMode>("get_billboard_mode")

    @JvmField
    public val setTextureFilterName:
        MethodStringName1<SpriteBase3D, Unit, BaseMaterial3D.TextureFilter> =
        MethodStringName1<SpriteBase3D, Unit, BaseMaterial3D.TextureFilter>("set_texture_filter")

    @JvmField
    public val getTextureFilterName: MethodStringName0<SpriteBase3D, BaseMaterial3D.TextureFilter> =
        MethodStringName0<SpriteBase3D, BaseMaterial3D.TextureFilter>("get_texture_filter")

    @JvmField
    public val getItemRectName: MethodStringName0<SpriteBase3D, Rect2> =
        MethodStringName0<SpriteBase3D, Rect2>("get_item_rect")

    @JvmField
    public val generateTriangleMeshName: MethodStringName0<SpriteBase3D, TriangleMesh?> =
        MethodStringName0<SpriteBase3D, TriangleMesh?>("generate_triangle_mesh")
  }

  public object MethodBindings {
    internal val setCenteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_centered", 2586408642)

    internal val isCenteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "is_centered", 36873697)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_offset", 743155724)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_offset", 3341600327)

    internal val setFlipHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_flip_h", 2586408642)

    internal val isFlippedHPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "is_flipped_h", 36873697)

    internal val setFlipVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_flip_v", 2586408642)

    internal val isFlippedVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "is_flipped_v", 36873697)

    internal val setModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_modulate", 2920490490)

    internal val getModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_modulate", 3444240500)

    internal val setRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_render_priority", 1286410249)

    internal val getRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_render_priority", 3905245786)

    internal val setPixelSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_pixel_size", 373806689)

    internal val getPixelSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_pixel_size", 1740695150)

    internal val setAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_axis", 1144690656)

    internal val getAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_axis", 3050976882)

    internal val setDrawFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_draw_flag", 1135633219)

    internal val getDrawFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_draw_flag", 1733036628)

    internal val setAlphaCutModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_alpha_cut_mode", 227561226)

    internal val getAlphaCutModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_alpha_cut_mode", 336003791)

    internal val setAlphaScissorThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_alpha_scissor_threshold", 373806689)

    internal val getAlphaScissorThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_alpha_scissor_threshold", 1740695150)

    internal val setAlphaHashScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_alpha_hash_scale", 373806689)

    internal val getAlphaHashScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_alpha_hash_scale", 1740695150)

    internal val setAlphaAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_alpha_antialiasing", 3212649852)

    internal val getAlphaAntialiasingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_alpha_antialiasing", 2889939400)

    internal val setAlphaAntialiasingEdgePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_alpha_antialiasing_edge", 373806689)

    internal val getAlphaAntialiasingEdgePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_alpha_antialiasing_edge", 1740695150)

    internal val setBillboardModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_billboard_mode", 4202036497)

    internal val getBillboardModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_billboard_mode", 1283840139)

    internal val setTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "set_texture_filter", 22904437)

    internal val getTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_texture_filter", 3289213076)

    internal val getItemRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "get_item_rect", 1639390495)

    internal val generateTriangleMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpriteBase3D", "generate_triangle_mesh", 3476533166)
  }
}
