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
import godot.core.RID
import godot.core.Rect2
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser._RID
import godot.core.Vector2
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A [Viewport] creates a different view into the screen, or a sub-view inside another viewport.
 * Child 2D nodes will display on it, and child Camera3D 3D nodes will render on it too.
 *
 * Optionally, a viewport can have its own 2D or 3D world, so it doesn't share what it draws with
 * other viewports.
 *
 * Viewports can also choose to be audio listeners, so they generate positional audio depending on a
 * 2D or 3D camera child of it.
 *
 * Also, viewports can be assigned to different screens in case the devices have multiple screens.
 *
 * Finally, viewports can also behave as render targets, in which case they will not be visible
 * unless the associated texture is used to draw.
 */
@GodotBaseType
public open class Viewport internal constructor() : Node() {
  /**
   * Emitted when the size of the viewport is changed, whether by resizing of window, or some other
   * means.
   */
  public val sizeChanged: Signal0 by Signal0

  /**
   * Emitted when a Control node grabs keyboard focus.
   *
   * **Note:** A Control node losing focus doesn't cause this signal to be emitted.
   */
  public val guiFocusChanged: Signal1<Control> by Signal1

  /**
   * Disable 3D rendering (but keep 2D rendering).
   */
  public final inline var disable3d: Boolean
    @JvmName("disable3dProperty")
    get() = is3dDisabled()
    @JvmName("disable3dProperty")
    set(`value`) {
      setDisable3d(value)
    }

  /**
   * If `true`, the viewport will use the primary XR interface to render XR output. When applicable
   * this can result in a stereoscopic image and the resulting render being output to a headset.
   */
  public final inline var useXr: Boolean
    @JvmName("useXrProperty")
    get() = isUsingXr()
    @JvmName("useXrProperty")
    set(`value`) {
      setUseXr(value)
    }

  /**
   * If `true`, the viewport will use a unique copy of the [World3D] defined in [world3d].
   */
  public final inline var ownWorld3d: Boolean
    @JvmName("ownWorld3dProperty")
    get() = isUsingOwnWorld3d()
    @JvmName("ownWorld3dProperty")
    set(`value`) {
      setUseOwnWorld3d(value)
    }

  /**
   * The custom [World3D] which can be used as 3D environment source.
   */
  public final inline var world3d: World3D?
    @JvmName("world3dProperty")
    get() = getWorld3d()
    @JvmName("world3dProperty")
    set(`value`) {
      setWorld3d(value)
    }

  /**
   * The custom [World2D] which can be used as 2D environment source.
   */
  public final inline var world2d: World2D?
    @JvmName("world2dProperty")
    get() = getWorld2d()
    @JvmName("world2dProperty")
    set(`value`) {
      setWorld2d(value)
    }

  /**
   * If `true`, the viewport should render its background as transparent.
   *
   * **Note:** Due to technical limitations, certain rendering features are disabled when a viewport
   * has a transparent background. This currently applies to screen-space reflections, subsurface
   * scattering, and depth of field.
   */
  public final inline var transparentBg: Boolean
    @JvmName("transparentBgProperty")
    get() = hasTransparentBackground()
    @JvmName("transparentBgProperty")
    set(`value`) {
      setTransparentBackground(value)
    }

  /**
   * If `true`, this viewport will mark incoming input events as handled by itself. If `false`, this
   * is instead done by the first parent viewport that is set to handle input locally.
   *
   * A [SubViewportContainer] will automatically set this property to `false` for the [Viewport]
   * contained inside of it.
   *
   * See also [setInputAsHandled] and [isInputHandled].
   */
  public final inline var handleInputLocally: Boolean
    @JvmName("handleInputLocallyProperty")
    get() = isHandlingInputLocally()
    @JvmName("handleInputLocallyProperty")
    set(`value`) {
      setHandleInputLocally(value)
    }

  /**
   * If `true`, [CanvasItem] nodes will internally snap to full pixels. Their position can still be
   * sub-pixel, but the decimals will not have effect. This can lead to a crisper appearance at the
   * cost of less smooth movement, especially when [Camera2D] smoothing is enabled.
   */
  public final inline var snap2dTransformsToPixel: Boolean
    @JvmName("snap2dTransformsToPixelProperty")
    get() = isSnap2dTransformsToPixelEnabled()
    @JvmName("snap2dTransformsToPixelProperty")
    set(`value`) {
      setSnap2dTransformsToPixel(value)
    }

  /**
   * If `true`, vertices of [CanvasItem] nodes will snap to full pixels. Only affects the final
   * vertex positions, not the transforms. This can lead to a crisper appearance at the cost of less
   * smooth movement, especially when [Camera2D] smoothing is enabled.
   */
  public final inline var snap2dVerticesToPixel: Boolean
    @JvmName("snap2dVerticesToPixelProperty")
    get() = isSnap2dVerticesToPixelEnabled()
    @JvmName("snap2dVerticesToPixelProperty")
    set(`value`) {
      setSnap2dVerticesToPixel(value)
    }

  /**
   * The multisample antialiasing mode for 2D/Canvas rendering. A higher number results in smoother
   * edges at the cost of significantly worse performance. A value of [Viewport.MSAA_2X] or
   * [Viewport.MSAA_4X] is best unless targeting very high-end systems. This has no effect on
   * shader-induced aliasing or texture aliasing.
   *
   * See also [ProjectSettings.rendering/antiAliasing/quality/msaa2d] and
   * [RenderingServer.viewportSetMsaa2d].
   */
  public final inline var msaa2d: MSAA
    @JvmName("msaa2dProperty")
    get() = getMsaa2d()
    @JvmName("msaa2dProperty")
    set(`value`) {
      setMsaa2d(value)
    }

  /**
   * The multisample antialiasing mode for 3D rendering. A higher number results in smoother edges
   * at the cost of significantly worse performance. A value of [Viewport.MSAA_2X] or
   * [Viewport.MSAA_4X] is best unless targeting very high-end systems. See also bilinear scaling 3D
   * [scaling3dMode] for supersampling, which provides higher quality but is much more expensive. This
   * has no effect on shader-induced aliasing or texture aliasing.
   *
   * See also [ProjectSettings.rendering/antiAliasing/quality/msaa3d] and
   * [RenderingServer.viewportSetMsaa3d].
   */
  public final inline var msaa3d: MSAA
    @JvmName("msaa3dProperty")
    get() = getMsaa3d()
    @JvmName("msaa3dProperty")
    set(`value`) {
      setMsaa3d(value)
    }

  /**
   * Sets the screen-space antialiasing method used. Screen-space antialiasing works by selectively
   * blurring edges in a post-process shader. It differs from MSAA which takes multiple coverage
   * samples while rendering objects. Screen-space AA methods are typically faster than MSAA and will
   * smooth out specular aliasing, but tend to make scenes appear blurry.
   *
   * See also [ProjectSettings.rendering/antiAliasing/quality/screenSpaceAa] and
   * [RenderingServer.viewportSetScreenSpaceAa].
   */
  public final inline var screenSpaceAa: ScreenSpaceAA
    @JvmName("screenSpaceAaProperty")
    get() = getScreenSpaceAa()
    @JvmName("screenSpaceAaProperty")
    set(`value`) {
      setScreenSpaceAa(value)
    }

  /**
   * Enables temporal antialiasing for this viewport. TAA works by jittering the camera and
   * accumulating the images of the last rendered frames, motion vector rendering is used to account
   * for camera and object motion.
   *
   * **Note:** The implementation is not complete yet, some visual instances such as particles and
   * skinned meshes may show artifacts.
   *
   * See also [ProjectSettings.rendering/antiAliasing/quality/useTaa] and
   * [RenderingServer.viewportSetUseTaa].
   */
  public final inline var useTaa: Boolean
    @JvmName("useTaaProperty")
    get() = isUsingTaa()
    @JvmName("useTaaProperty")
    set(`value`) {
      setUseTaa(value)
    }

  /**
   * When using the Mobile or Forward+ renderers, set [useDebanding] to enable or disable the
   * debanding feature of this [Viewport]. If [useHdr2d] is `false`, 2D rendering is *not* affected by
   * debanding unless the [Environment.backgroundMode] is [Environment.BG_CANVAS]. If [useHdr2d] is
   * `true`, debanding will only be applied if this is the root [Viewport] and will affect all 2D and
   * 3D rendering, including canvas items.
   *
   * [useDebanding] has no effect when using the Compatibility rendering method. The Mobile renderer
   * can also use material debanding, which can be set with [RenderingServer.materialSetUseDebanding]
   * or configured with [ProjectSettings.rendering/antiAliasing/quality/useDebanding].
   *
   * See also [ProjectSettings.rendering/antiAliasing/quality/useDebanding],
   * [RenderingServer.materialSetUseDebanding], and [RenderingServer.viewportSetUseDebanding].
   */
  public final inline var useDebanding: Boolean
    @JvmName("useDebandingProperty")
    get() = isUsingDebanding()
    @JvmName("useDebandingProperty")
    set(`value`) {
      setUseDebanding(value)
    }

  /**
   * If `true`, [OccluderInstance3D] nodes will be usable for occlusion culling in 3D for this
   * viewport. For the root viewport, [ProjectSettings.rendering/occlusionCulling/useOcclusionCulling]
   * must be set to `true` instead.
   *
   * **Note:** Enabling occlusion culling has a cost on the CPU. Only enable occlusion culling if
   * you actually plan to use it, and think whether your scene can actually benefit from occlusion
   * culling. Large, open scenes with few or no objects blocking the view will generally not benefit
   * much from occlusion culling. Large open scenes generally benefit more from mesh LOD and visibility
   * ranges ([GeometryInstance3D.visibilityRangeBegin] and [GeometryInstance3D.visibilityRangeEnd])
   * compared to occlusion culling.
   *
   * **Note:** Due to memory constraints, occlusion culling is not supported by default in Web
   * export templates. It can be enabled by compiling custom Web export templates with
   * `module_raycast_enabled=yes`.
   */
  public final inline var useOcclusionCulling: Boolean
    @JvmName("useOcclusionCullingProperty")
    get() = isUsingOcclusionCulling()
    @JvmName("useOcclusionCullingProperty")
    set(`value`) {
      setUseOcclusionCulling(value)
    }

  /**
   * The automatic LOD bias to use for meshes rendered within the [Viewport] (this is analogous to
   * [ReflectionProbe.meshLodThreshold]). Higher values will use less detailed versions of meshes that
   * have LOD variations generated. If set to `0.0`, automatic LOD is disabled. Increase
   * [meshLodThreshold] to improve performance at the cost of geometry detail.
   *
   * To control this property on the root viewport, set the
   * [ProjectSettings.rendering/meshLod/lodChange/thresholdPixels] project setting.
   *
   * **Note:** Depending on the mesh's attributes (vertex colors, blend shapes, ...), a mesh may
   * have fewer levels of LOD generated to avoid visible distortion of the mesh once it is affected by
   * vertex colors or blend shapes. Meshes with a very low vertex count will also not have any LODs
   * generated, which means this setting will not affect them at all. In general, this setting makes
   * the largest impact on static meshes with a high vertex count.
   *
   * **Note:** [meshLodThreshold] does not affect [GeometryInstance3D] visibility ranges (also known
   * as "manual" LOD or hierarchical LOD).
   */
  public final inline var meshLodThreshold: Float
    @JvmName("meshLodThresholdProperty")
    get() = getMeshLodThreshold()
    @JvmName("meshLodThresholdProperty")
    set(`value`) {
      setMeshLodThreshold(value)
    }

  /**
   * The overlay mode for test rendered geometry in debug purposes.
   */
  public final inline var debugDraw: DebugDraw
    @JvmName("debugDrawProperty")
    get() = getDebugDraw()
    @JvmName("debugDrawProperty")
    set(`value`) {
      setDebugDraw(value)
    }

  /**
   * If `true`, 2D rendering will use a high dynamic range (HDR) `RGBA16` format framebuffer.
   * Additionally, 2D rendering will be performed on linear values and will be converted using the
   * appropriate transfer function immediately before blitting to the screen (if the Viewport is
   * attached to the screen).
   *
   * Practically speaking, this means that the end result of the Viewport will not be clamped to the
   * `0-1` range and can be used in 3D rendering without color encoding adjustments. This allows 2D
   * rendering to take advantage of effects requiring high dynamic range (e.g. 2D glow) as well as
   * substantially improves the appearance of effects requiring highly detailed gradients.
   */
  public final inline var useHdr2d: Boolean
    @JvmName("useHdr2dProperty")
    get() = isUsingHdr2d()
    @JvmName("useHdr2dProperty")
    set(`value`) {
      setUseHdr2d(value)
    }

  /**
   * Sets scaling 3D mode. Bilinear scaling renders at different resolution to either undersample or
   * supersample the viewport. FidelityFX Super Resolution 1.0, abbreviated to FSR, is an upscaling
   * technology that produces high quality images at fast framerates by using a spatially aware
   * upscaling algorithm. FSR is slightly more expensive than bilinear, but it produces significantly
   * higher image quality. FSR should be used where possible.
   *
   * To control this property on the root viewport, set the
   * [ProjectSettings.rendering/scaling3d/mode] project setting.
   */
  public final inline var scaling3dMode: Scaling3DMode
    @JvmName("scaling3dModeProperty")
    get() = getScaling3dMode()
    @JvmName("scaling3dModeProperty")
    set(`value`) {
      setScaling3dMode(value)
    }

  /**
   * Scales the 3D render buffer based on the viewport size uses an image filter specified in
   * [ProjectSettings.rendering/scaling3d/mode] to scale the output image to the full viewport size.
   * Values lower than `1.0` can be used to speed up 3D rendering at the cost of quality
   * (undersampling). Values greater than `1.0` are only valid for bilinear mode and can be used to
   * improve 3D rendering quality at a high performance cost (supersampling). See also
   * [ProjectSettings.rendering/antiAliasing/quality/msaa3d] for multi-sample antialiasing, which is
   * significantly cheaper but only smooths the edges of polygons.
   *
   * When using FSR upscaling, AMD recommends exposing the following values as preset options to
   * users "Ultra Quality: 0.77", "Quality: 0.67", "Balanced: 0.59", "Performance: 0.5" instead of
   * exposing the entire scale.
   *
   * To control this property on the root viewport, set the
   * [ProjectSettings.rendering/scaling3d/scale] project setting.
   */
  public final inline var scaling3dScale: Float
    @JvmName("scaling3dScaleProperty")
    get() = getScaling3dScale()
    @JvmName("scaling3dScaleProperty")
    set(`value`) {
      setScaling3dScale(value)
    }

  /**
   * Affects the final texture sharpness by reading from a lower or higher mipmap (also called
   * "texture LOD bias"). Negative values make mipmapped textures sharper but grainier when viewed at a
   * distance, while positive values make mipmapped textures blurrier (even when up close).
   *
   * Enabling temporal antialiasing ([useTaa]) will automatically apply a `-0.5` offset to this
   * value, while enabling FXAA ([screenSpaceAa]) will automatically apply a `-0.25` offset to this
   * value. If both TAA and FXAA are enabled at the same time, an offset of `-0.75` is applied to this
   * value.
   *
   * To control this property on the root viewport, set the
   * [ProjectSettings.rendering/textures/defaultFilters/textureMipmapBias] project setting.
   *
   * **Note:** If [scaling3dScale] is lower than `1.0` (exclusive), [textureMipmapBias] is used to
   * adjust the automatic mipmap bias which is calculated internally based on the scale factor. The
   * formula for this is `log2(scaling_3d_scale) + mipmap_bias`.
   *
   * **Note:** This property is only supported in the Forward+ and Mobile renderers, not
   * Compatibility. In Compatibility, this property is always treated as if it was set to `0.0`.
   */
  public final inline var textureMipmapBias: Float
    @JvmName("textureMipmapBiasProperty")
    get() = getTextureMipmapBias()
    @JvmName("textureMipmapBiasProperty")
    set(`value`) {
      setTextureMipmapBias(value)
    }

  /**
   * Sets the maximum number of samples to take when using anisotropic filtering on textures (as a
   * power of two). A higher sample count will result in sharper textures at oblique angles, but is
   * more expensive to compute. A value of `0` forcibly disables anisotropic filtering, even on
   * materials where it is enabled.
   *
   * The anisotropic filtering level also affects decals and light projectors if they are configured
   * to use anisotropic filtering. See [ProjectSettings.rendering/textures/decals/filter] and
   * [ProjectSettings.rendering/textures/lightProjectors/filter].
   *
   * **Note:** In 3D, for this setting to have an effect, set [BaseMaterial3D.textureFilter] to
   * [BaseMaterial3D.TEXTURE_FILTER_LINEAR_WITH_MIPMAPS_ANISOTROPIC] or
   * [BaseMaterial3D.TEXTURE_FILTER_NEAREST_WITH_MIPMAPS_ANISOTROPIC] on materials.
   *
   * **Note:** In 2D, for this setting to have an effect, set [CanvasItem.textureFilter] to
   * [CanvasItem.TEXTURE_FILTER_LINEAR_WITH_MIPMAPS_ANISOTROPIC] or
   * [CanvasItem.TEXTURE_FILTER_NEAREST_WITH_MIPMAPS_ANISOTROPIC] on the [CanvasItem] node displaying
   * the texture (or in [CanvasTexture]). However, anisotropic filtering is rarely useful in 2D, so
   * only enable it for textures in 2D if it makes a meaningful visual difference.
   */
  public final inline var anisotropicFilteringLevel: AnisotropicFiltering
    @JvmName("anisotropicFilteringLevelProperty")
    get() = getAnisotropicFilteringLevel()
    @JvmName("anisotropicFilteringLevelProperty")
    set(`value`) {
      setAnisotropicFilteringLevel(value)
    }

  /**
   * Determines how sharp the upscaled image will be when using the FSR upscaling mode. Sharpness
   * halves with every whole number. Values go from 0.0 (sharpest) to 2.0. Values above 2.0 won't make
   * a visible difference.
   *
   * To control this property on the root viewport, set the
   * [ProjectSettings.rendering/scaling3d/fsrSharpness] project setting.
   */
  public final inline var fsrSharpness: Float
    @JvmName("fsrSharpnessProperty")
    get() = getFsrSharpness()
    @JvmName("fsrSharpnessProperty")
    set(`value`) {
      setFsrSharpness(value)
    }

  /**
   * The Variable Rate Shading (VRS) mode that is used for this viewport. Note, if hardware does not
   * support VRS this property is ignored.
   */
  public final inline var vrsMode: VRSMode
    @JvmName("vrsModeProperty")
    get() = getVrsMode()
    @JvmName("vrsModeProperty")
    set(`value`) {
      setVrsMode(value)
    }

  /**
   * Sets the update mode for Variable Rate Shading (VRS) for the viewport. VRS requires the input
   * texture to be converted to the format usable by the VRS method supported by the hardware. The
   * update mode defines how often this happens. If the GPU does not support VRS, or VRS is not
   * enabled, this property is ignored.
   */
  public final inline var vrsUpdateMode: VRSUpdateMode
    @JvmName("vrsUpdateModeProperty")
    get() = getVrsUpdateMode()
    @JvmName("vrsUpdateModeProperty")
    set(`value`) {
      setVrsUpdateMode(value)
    }

  /**
   * Texture to use when [vrsMode] is set to [Viewport.VRS_TEXTURE].
   *
   * The texture *must* use a lossless compression format so that colors can be matched precisely.
   * The following VRS densities are mapped to various colors, with brighter colors representing a
   * lower level of shading precision:
   *
   * [codeblock lang=text]
   *
   * - 1×1 = rgb(0, 0, 0)     - #000000
   *
   * - 1×2 = rgb(0, 85, 0)    - #005500
   *
   * - 2×1 = rgb(85, 0, 0)    - #550000
   *
   * - 2×2 = rgb(85, 85, 0)   - #555500
   *
   * - 2×4 = rgb(85, 170, 0)  - #55aa00
   *
   * - 4×2 = rgb(170, 85, 0)  - #aa5500
   *
   * - 4×4 = rgb(170, 170, 0) - #aaaa00
   *
   * - 4×8 = rgb(170, 255, 0) - #aaff00 - Not supported on most hardware
   *
   * - 8×4 = rgb(255, 170, 0) - #ffaa00 - Not supported on most hardware
   *
   * - 8×8 = rgb(255, 255, 0) - #ffff00 - Not supported on most hardware
   *
   * ```
   */
  public final inline var vrsTexture: Texture2D?
    @JvmName("vrsTextureProperty")
    get() = getVrsTexture()
    @JvmName("vrsTextureProperty")
    set(`value`) {
      setVrsTexture(value)
    }

  /**
   * The default filter mode used by [CanvasItem] nodes in this viewport.
   */
  public final inline var canvasItemDefaultTextureFilter: DefaultCanvasItemTextureFilter
    @JvmName("canvasItemDefaultTextureFilterProperty")
    get() = getDefaultCanvasItemTextureFilter()
    @JvmName("canvasItemDefaultTextureFilterProperty")
    set(`value`) {
      setDefaultCanvasItemTextureFilter(value)
    }

  /**
   * The default repeat mode used by [CanvasItem] nodes in this viewport.
   */
  public final inline var canvasItemDefaultTextureRepeat: DefaultCanvasItemTextureRepeat
    @JvmName("canvasItemDefaultTextureRepeatProperty")
    get() = getDefaultCanvasItemTextureRepeat()
    @JvmName("canvasItemDefaultTextureRepeatProperty")
    set(`value`) {
      setDefaultCanvasItemTextureRepeat(value)
    }

  /**
   * If `true`, the viewport will process 2D audio streams.
   */
  public final inline var audioListenerEnable2d: Boolean
    @JvmName("audioListenerEnable2dProperty")
    get() = isAudioListener2d()
    @JvmName("audioListenerEnable2dProperty")
    set(`value`) {
      setAsAudioListener2d(value)
    }

  /**
   * If `true`, the viewport will process 3D audio streams.
   */
  public final inline var audioListenerEnable3d: Boolean
    @JvmName("audioListenerEnable3dProperty")
    get() = isAudioListener3d()
    @JvmName("audioListenerEnable3dProperty")
    set(`value`) {
      setAsAudioListener3d(value)
    }

  /**
   * If `true`, the objects rendered by viewport become subjects of mouse picking process.
   *
   * **Note:** The number of simultaneously pickable objects is limited to 64 and they are selected
   * in a non-deterministic order, which can be different in each picking process.
   */
  public final inline var physicsObjectPicking: Boolean
    @JvmName("physicsObjectPickingProperty")
    get() = getPhysicsObjectPicking()
    @JvmName("physicsObjectPickingProperty")
    set(`value`) {
      setPhysicsObjectPicking(value)
    }

  /**
   * If `true`, objects receive mouse picking events sorted primarily by their [CanvasItem.zIndex]
   * and secondarily by their position in the scene tree. If `false`, the order is undetermined.
   *
   * **Note:** This setting is disabled by default because of its potential expensive computational
   * cost.
   *
   * **Note:** Sorting happens after selecting the pickable objects. Because of the limitation of 64
   * simultaneously pickable objects, it is not guaranteed that the object with the highest
   * [CanvasItem.zIndex] receives the picking event.
   */
  public final inline var physicsObjectPickingSort: Boolean
    @JvmName("physicsObjectPickingSortProperty")
    get() = getPhysicsObjectPickingSort()
    @JvmName("physicsObjectPickingSortProperty")
    set(`value`) {
      setPhysicsObjectPickingSort(value)
    }

  /**
   * If `true`, the input_event signal will only be sent to one physics object in the mouse picking
   * process. If you want to get the top object only, you must also enable [physicsObjectPickingSort].
   *
   * If `false`, an input_event signal will be sent to all physics objects in the mouse picking
   * process.
   *
   * This applies to 2D CanvasItem object picking only.
   */
  public final inline var physicsObjectPickingFirstOnly: Boolean
    @JvmName("physicsObjectPickingFirstOnlyProperty")
    get() = getPhysicsObjectPickingFirstOnly()
    @JvmName("physicsObjectPickingFirstOnlyProperty")
    set(`value`) {
      setPhysicsObjectPickingFirstOnly(value)
    }

  /**
   * If `true`, the viewport will not receive input events.
   */
  public final inline var guiDisableInput: Boolean
    @JvmName("guiDisableInputProperty")
    get() = isInputDisabled()
    @JvmName("guiDisableInputProperty")
    set(`value`) {
      setDisableInput(value)
    }

  /**
   * If `true`, the GUI controls on the viewport will lay pixel perfectly.
   */
  public final inline var guiSnapControlsToPixels: Boolean
    @JvmName("guiSnapControlsToPixelsProperty")
    get() = isSnapControlsToPixelsEnabled()
    @JvmName("guiSnapControlsToPixelsProperty")
    set(`value`) {
      setSnapControlsToPixels(value)
    }

  /**
   * If `true`, sub-windows (popups and dialogs) will be embedded inside application window as
   * control-like nodes. If `false`, they will appear as separate windows handled by the operating
   * system.
   */
  public final inline var guiEmbedSubwindows: Boolean
    @JvmName("guiEmbedSubwindowsProperty")
    get() = isEmbeddingSubwindows()
    @JvmName("guiEmbedSubwindowsProperty")
    set(`value`) {
      setEmbeddingSubwindows(value)
    }

  /**
   * The minimum distance the mouse cursor must move while pressed before a drag operation begins.
   */
  public final inline var guiDragThreshold: Int
    @JvmName("guiDragThresholdProperty")
    get() = getDragThreshold()
    @JvmName("guiDragThresholdProperty")
    set(`value`) {
      setDragThreshold(value)
    }

  /**
   * Controls how much of the original viewport's size should be covered by the 2D signed distance
   * field. This SDF can be sampled in [CanvasItem] shaders and is also used for [GPUParticles2D]
   * collision. Higher values allow portions of occluders located outside the viewport to still be
   * taken into account in the generated signed distance field, at the cost of performance. If you
   * notice particles falling through [LightOccluder2D]s as the occluders leave the viewport, increase
   * this setting.
   *
   * The percentage is added on each axis and on both sides. For example, with the default
   * [SDF_OVERSIZE_120_PERCENT], the signed distance field will cover 20&#37; of the viewport's size
   * outside the viewport on each side (top, right, bottom, left).
   */
  public final inline var sdfOversize: SDFOversize
    @JvmName("sdfOversizeProperty")
    get() = getSdfOversize()
    @JvmName("sdfOversizeProperty")
    set(`value`) {
      setSdfOversize(value)
    }

  /**
   * The resolution scale to use for the 2D signed distance field. Higher values lead to a more
   * precise and more stable signed distance field as the camera moves, at the cost of performance.
   */
  public final inline var sdfScale: SDFScale
    @JvmName("sdfScaleProperty")
    get() = getSdfScale()
    @JvmName("sdfScaleProperty")
    set(`value`) {
      setSdfScale(value)
    }

  /**
   * The shadow atlas' resolution (used for omni and spot lights). The value is rounded up to the
   * nearest power of 2.
   *
   * **Note:** If this is set to `0`, no positional shadows will be visible at all. This can improve
   * performance significantly on low-end systems by reducing both the CPU and GPU load (as fewer draw
   * calls are needed to draw the scene without shadows).
   */
  public final inline var positionalShadowAtlasSize: Int
    @JvmName("positionalShadowAtlasSizeProperty")
    get() = getPositionalShadowAtlasSize()
    @JvmName("positionalShadowAtlasSizeProperty")
    set(`value`) {
      setPositionalShadowAtlasSize(value)
    }

  /**
   * Use 16 bits for the omni/spot shadow depth map. Enabling this results in shadows having less
   * precision and may result in shadow acne, but can lead to performance improvements on some devices.
   */
  public final inline var positionalShadowAtlas16Bits: Boolean
    @JvmName("positionalShadowAtlas16BitsProperty")
    get() = getPositionalShadowAtlas16Bits()
    @JvmName("positionalShadowAtlas16BitsProperty")
    set(`value`) {
      setPositionalShadowAtlas16Bits(value)
    }

  /**
   * The subdivision amount of the first quadrant on the shadow atlas.
   */
  public final inline var positionalShadowAtlasQuad0: PositionalShadowAtlasQuadrantSubdiv
    @JvmName("positionalShadowAtlasQuad0Property")
    get() = getPositionalShadowAtlasQuadrantSubdiv(0)
    @JvmName("positionalShadowAtlasQuad0Property")
    set(`value`) {
      setPositionalShadowAtlasQuadrantSubdiv(0, value)
    }

  /**
   * The subdivision amount of the second quadrant on the shadow atlas.
   */
  public final inline var positionalShadowAtlasQuad1: PositionalShadowAtlasQuadrantSubdiv
    @JvmName("positionalShadowAtlasQuad1Property")
    get() = getPositionalShadowAtlasQuadrantSubdiv(1)
    @JvmName("positionalShadowAtlasQuad1Property")
    set(`value`) {
      setPositionalShadowAtlasQuadrantSubdiv(1, value)
    }

  /**
   * The subdivision amount of the third quadrant on the shadow atlas.
   */
  public final inline var positionalShadowAtlasQuad2: PositionalShadowAtlasQuadrantSubdiv
    @JvmName("positionalShadowAtlasQuad2Property")
    get() = getPositionalShadowAtlasQuadrantSubdiv(2)
    @JvmName("positionalShadowAtlasQuad2Property")
    set(`value`) {
      setPositionalShadowAtlasQuadrantSubdiv(2, value)
    }

  /**
   * The subdivision amount of the fourth quadrant on the shadow atlas.
   */
  public final inline var positionalShadowAtlasQuad3: PositionalShadowAtlasQuadrantSubdiv
    @JvmName("positionalShadowAtlasQuad3Property")
    get() = getPositionalShadowAtlasQuadrantSubdiv(3)
    @JvmName("positionalShadowAtlasQuad3Property")
    set(`value`) {
      setPositionalShadowAtlasQuadrantSubdiv(3, value)
    }

  /**
   * The canvas transform of the viewport, useful for changing the on-screen positions of all child
   * [CanvasItem]s. This is relative to the global canvas transform of the viewport.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var canvasTransform: Transform2D
    @JvmName("canvasTransformProperty")
    get() = getCanvasTransform()
    @JvmName("canvasTransformProperty")
    set(`value`) {
      setCanvasTransform(value)
    }

  /**
   * The global canvas transform of the viewport. The canvas transform is relative to this.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var globalCanvasTransform: Transform2D
    @JvmName("globalCanvasTransformProperty")
    get() = getGlobalCanvasTransform()
    @JvmName("globalCanvasTransformProperty")
    set(`value`) {
      setGlobalCanvasTransform(value)
    }

  /**
   * The rendering layers in which this [Viewport] renders [CanvasItem] nodes.
   *
   * **Note:** A [CanvasItem] does not inherit its parents' visibility layers. See
   * [CanvasItem.visibilityLayer]'s description for details.
   */
  public final inline var canvasCullMask: Long
    @JvmName("canvasCullMaskProperty")
    get() = getCanvasCullMask()
    @JvmName("canvasCullMaskProperty")
    set(`value`) {
      setCanvasCullMask(value)
    }

  /**
   * If `true` and one of the following conditions are true: [SubViewport.size2dOverrideStretch] and
   * [SubViewport.size2dOverride] are set, [Window.contentScaleFactor] is set and scaling is enabled,
   * [oversamplingOverride] is set, font and [DPITexture] oversampling are enabled.
   */
  public final inline var oversampling: Boolean
    @JvmName("oversamplingProperty")
    get() = isUsingOversampling()
    @JvmName("oversamplingProperty")
    set(`value`) {
      setUseOversampling(value)
    }

  /**
   * If greater than zero, this value is used as the font oversampling factor, otherwise
   * oversampling is equal to viewport scale.
   */
  public final inline var oversamplingOverride: Float
    @JvmName("oversamplingOverrideProperty")
    get() = getOversamplingOverride()
    @JvmName("oversamplingOverrideProperty")
    set(`value`) {
      setOversamplingOverride(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(796, scriptPtr)
  }

  /**
   * This is a helper function for [canvasTransform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = viewport.canvasTransform
   * //Your changes
   * viewport.canvasTransform = myCoreType
   * ``````
   *
   * The canvas transform of the viewport, useful for changing the on-screen positions of all child
   * [CanvasItem]s. This is relative to the global canvas transform of the viewport.
   */
  @CoreTypeHelper
  public final fun canvasTransformMutate(block: Transform2D.() -> Unit): Transform2D =
      canvasTransform.apply {
     block(this)
     canvasTransform = this
  }

  /**
   * This is a helper function for [globalCanvasTransform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = viewport.globalCanvasTransform
   * //Your changes
   * viewport.globalCanvasTransform = myCoreType
   * ``````
   *
   * The global canvas transform of the viewport. The canvas transform is relative to this.
   */
  @CoreTypeHelper
  public final fun globalCanvasTransformMutate(block: Transform2D.() -> Unit): Transform2D =
      globalCanvasTransform.apply {
     block(this)
     globalCanvasTransform = this
  }

  public final fun setWorld2d(world2d: World2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to world2d)
    TransferContext.callMethod(MethodBindings.setWorld2dPtr)
  }

  public final fun getWorld2d(): World2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWorld2dPtr)
    return (TransferContext.readReturnValue(OBJECT) as World2D?)
  }

  /**
   * Returns the first valid [World2D] for this viewport, searching the [world2d] property of itself
   * and any Viewport ancestor.
   */
  public final fun findWorld2d(): World2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.findWorld2dPtr)
    return (TransferContext.readReturnValue(OBJECT) as World2D?)
  }

  public final fun setCanvasTransform(xform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to xform)
    TransferContext.callMethod(MethodBindings.setCanvasTransformPtr)
  }

  public final fun getCanvasTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  public final fun setGlobalCanvasTransform(xform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to xform)
    TransferContext.callMethod(MethodBindings.setGlobalCanvasTransformPtr)
  }

  public final fun getGlobalCanvasTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalCanvasTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the automatically computed 2D stretch transform, taking the [Viewport]'s stretch
   * settings into account. The final value is multiplied by [Window.contentScaleFactor], but only for
   * the root viewport. If this method is called on a [SubViewport] (e.g., in a scene tree with
   * [SubViewportContainer] and [SubViewport]), the scale factor of the root window will not be
   * applied. Using [Transform2D.getScale] on the returned value, this can be used to compensate for
   * scaling when zooming a [Camera2D] node, or to scale down a [TextureRect] to be pixel-perfect
   * regardless of the automatically computed scale factor.
   *
   * **Note:** Due to how pixel scaling works, the returned transform's X and Y scale may differ
   * slightly, even when [Window.contentScaleAspect] is set to a mode that preserves the pixels' aspect
   * ratio. If [Window.contentScaleAspect] is [Window.CONTENT_SCALE_ASPECT_IGNORE], the X and Y scale
   * may differ *significantly*.
   */
  public final fun getStretchTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStretchTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the transform from the viewport's coordinate system to the embedder's coordinate
   * system.
   */
  public final fun getFinalTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFinalTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the transform from the Viewport's coordinates to the screen coordinates of the
   * containing window manager window.
   */
  public final fun getScreenTransform(): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the visible rectangle in global screen coordinates.
   */
  public final fun getVisibleRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibleRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public final fun setTransparentBackground(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setTransparentBackgroundPtr)
  }

  public final fun hasTransparentBackground(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasTransparentBackgroundPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseHdr2d(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseHdr2dPtr)
  }

  public final fun isUsingHdr2d(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingHdr2dPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMsaa2d(msaa: MSAA): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to msaa.value)
    TransferContext.callMethod(MethodBindings.setMsaa2dPtr)
  }

  public final fun getMsaa2d(): MSAA {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMsaa2dPtr)
    return MSAA.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMsaa3d(msaa: MSAA): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to msaa.value)
    TransferContext.callMethod(MethodBindings.setMsaa3dPtr)
  }

  public final fun getMsaa3d(): MSAA {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMsaa3dPtr)
    return MSAA.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setScreenSpaceAa(screenSpaceAa: ScreenSpaceAA): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screenSpaceAa.value)
    TransferContext.callMethod(MethodBindings.setScreenSpaceAaPtr)
  }

  public final fun getScreenSpaceAa(): ScreenSpaceAA {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenSpaceAaPtr)
    return ScreenSpaceAA.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setUseTaa(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseTaaPtr)
  }

  public final fun isUsingTaa(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingTaaPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseDebanding(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseDebandingPtr)
  }

  public final fun isUsingDebanding(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingDebandingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseOcclusionCulling(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseOcclusionCullingPtr)
  }

  public final fun isUsingOcclusionCulling(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingOcclusionCullingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDebugDraw(debugDraw: DebugDraw): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to debugDraw.value)
    TransferContext.callMethod(MethodBindings.setDebugDrawPtr)
  }

  public final fun getDebugDraw(): DebugDraw {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDebugDrawPtr)
    return DebugDraw.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setUseOversampling(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseOversamplingPtr)
  }

  public final fun isUsingOversampling(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingOversamplingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setOversamplingOverride(oversampling: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.setOversamplingOverridePtr)
  }

  public final fun getOversamplingOverride(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOversamplingOverridePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns viewport oversampling factor.
   */
  public final fun getOversampling(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOversamplingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns rendering statistics of the given type.
   */
  public final fun getRenderInfo(type: RenderInfoType, info: RenderInfo): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to info.value)
    TransferContext.callMethod(MethodBindings.getRenderInfoPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the viewport's texture.
   *
   * **Note:** When trying to store the current texture (e.g. in a file), it might be completely
   * black or outdated if used too early, especially when used in e.g. [Node.Ready]. To make sure the
   * texture you get is correct, you can await [signal RenderingServer.frame_post_draw] signal.
   *
   * ```gdscript
   * //gdscript
   * func _ready():
   *     await RenderingServer.frame_post_draw
   *     $Viewport.get_texture().get_image().save_png("user://Screenshot.png")
   * ```
   *
   * ```csharp
   * //csharp
   * public async override void _Ready()
   * {
   *     await ToSignal(RenderingServer.Singleton, RenderingServer.SignalName.FramePostDraw);
   *     var viewport = GetNode<Viewport>("Viewport");
   *     viewport.GetTexture().GetImage().SavePng("user://Screenshot.png");
   * }
   * ```
   *
   * **Note:** When [useHdr2d] is `true` the returned texture will be an HDR image using linear
   * encoding.
   */
  public final fun getTexture(): ViewportTexture? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as ViewportTexture?)
  }

  public final fun setPhysicsObjectPicking(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setPhysicsObjectPickingPtr)
  }

  public final fun getPhysicsObjectPicking(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsObjectPickingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPhysicsObjectPickingSort(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setPhysicsObjectPickingSortPtr)
  }

  public final fun getPhysicsObjectPickingSort(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsObjectPickingSortPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPhysicsObjectPickingFirstOnly(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setPhysicsObjectPickingFirstOnlyPtr)
  }

  public final fun getPhysicsObjectPickingFirstOnly(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPhysicsObjectPickingFirstOnlyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the viewport's RID from the [RenderingServer].
   */
  public final fun getViewportRid(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getViewportRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Helper method which calls the `set_text()` method on the currently focused [Control], provided
   * that it is defined (e.g. if the focused Control is [Button] or [LineEdit]).
   */
  public final fun pushTextInput(text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text)
    TransferContext.callMethod(MethodBindings.pushTextInputPtr)
  }

  /**
   * Triggers the given [event] in this [Viewport]. This can be used to pass an [InputEvent] between
   * viewports, or to locally apply inputs that were sent over the network or saved to a file.
   *
   * If [inLocalCoords] is `false`, the event's position is in the embedder's coordinates and will
   * be converted to viewport coordinates. If [inLocalCoords] is `true`, the event's position is in
   * viewport coordinates.
   *
   * While this method serves a similar purpose as [Input.parseInputEvent], it does not remap the
   * specified [event] based on project settings like
   * [ProjectSettings.inputDevices/pointing/emulateTouchFromMouse].
   *
   * Calling this method will propagate calls to child nodes for following methods in the given
   * order:
   *
   * - [Node.Input]
   *
   * - [Control.GuiInput] for [Control] nodes
   *
   * - [Node.ShortcutInput]
   *
   * - [Node.UnhandledKeyInput]
   *
   * - [Node.UnhandledInput]
   *
   * If an earlier method marks the input as handled via [setInputAsHandled], any later method in
   * this list will not be called.
   *
   * If none of the methods handle the event and [physicsObjectPicking] is `true`, the event is used
   * for physics object picking.
   */
  @JvmOverloads
  public final fun pushInput(event: InputEvent, inLocalCoords: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to event, BOOL to inLocalCoords)
    TransferContext.callMethod(MethodBindings.pushInputPtr)
  }

  /**
   * Triggers the given [event] in this [Viewport]. This can be used to pass an [InputEvent] between
   * viewports, or to locally apply inputs that were sent over the network or saved to a file.
   *
   * If [inLocalCoords] is `false`, the event's position is in the embedder's coordinates and will
   * be converted to viewport coordinates. If [inLocalCoords] is `true`, the event's position is in
   * viewport coordinates.
   *
   * Calling this method will propagate calls to child nodes for following methods in the given
   * order:
   *
   * - [Node.ShortcutInput]
   *
   * - [Node.UnhandledKeyInput]
   *
   * - [Node.UnhandledInput]
   *
   * If an earlier method marks the input as handled via [setInputAsHandled], any later method in
   * this list will not be called.
   *
   * If none of the methods handle the event and [physicsObjectPicking] is `true`, the event is used
   * for physics object picking.
   *
   * **Note:** This method doesn't propagate input events to embedded [Window]s or [SubViewport]s.
   */
  @JvmOverloads
  public final fun pushUnhandledInput(event: InputEvent, inLocalCoords: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to event, BOOL to inLocalCoords)
    TransferContext.callMethod(MethodBindings.pushUnhandledInputPtr)
  }

  /**
   * Inform the Viewport that the mouse has entered its area. Use this function before sending an
   * [InputEventMouseButton] or [InputEventMouseMotion] to the [Viewport] with [Viewport.pushInput].
   * See also [notifyMouseExited].
   *
   * **Note:** In most cases, it is not necessary to call this function because [SubViewport] nodes
   * that are children of [SubViewportContainer] are notified automatically. This is only necessary
   * when interacting with viewports in non-default ways, for example as textures in [TextureRect] or
   * with an [Area3D] that forwards input events.
   */
  public final fun notifyMouseEntered(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.notifyMouseEnteredPtr)
  }

  /**
   * Inform the Viewport that the mouse has left its area. Use this function when the node that
   * displays the viewport notices the mouse has left the area of the displayed viewport. See also
   * [notifyMouseEntered].
   *
   * **Note:** In most cases, it is not necessary to call this function because [SubViewport] nodes
   * that are children of [SubViewportContainer] are notified automatically. This is only necessary
   * when interacting with viewports in non-default ways, for example as textures in [TextureRect] or
   * with an [Area3D] that forwards input events.
   */
  public final fun notifyMouseExited(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.notifyMouseExitedPtr)
  }

  /**
   * Returns the mouse's position in this [Viewport] using the coordinate system of this [Viewport].
   */
  public final fun getMousePosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMousePositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Moves the mouse pointer to the specified position in this [Viewport] using the coordinate
   * system of this [Viewport].
   *
   * **Note:** [warpMouse] is only supported on Windows, macOS and Linux. It has no effect on
   * Android, iOS and Web.
   */
  public final fun warpMouse(position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.warpMousePtr)
  }

  /**
   * Force instantly updating the display based on the current mouse cursor position. This includes
   * updating the mouse cursor shape and sending necessary [signal Control.mouse_entered], [signal
   * CollisionObject2D.mouse_entered], [signal CollisionObject3D.mouse_entered] and [signal
   * Window.mouse_entered] signals and their respective `mouse_exited` counterparts.
   */
  public final fun updateMouseCursorState(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.updateMouseCursorStatePtr)
  }

  /**
   * Cancels the drag operation that was previously started through [Control.GetDragData] or forced
   * with [Control.forceDrag].
   */
  public final fun guiCancelDrag(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.guiCancelDragPtr)
  }

  /**
   * Returns the drag data from the GUI, that was previously returned by [Control.GetDragData].
   */
  public final fun guiGetDragData(): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.guiGetDragDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the human-readable description of the drag data, used for assistive apps.
   */
  public final fun guiGetDragDescription(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.guiGetDragDescriptionPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the human-readable description of the drag data to [description], used for assistive apps.
   */
  public final fun guiSetDragDescription(description: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to description)
    TransferContext.callMethod(MethodBindings.guiSetDragDescriptionPtr)
  }

  /**
   * Returns `true` if a drag operation is currently ongoing and where the drop action could happen
   * in this viewport.
   *
   * Alternative to [Node.NOTIFICATION_DRAG_BEGIN] and [Node.NOTIFICATION_DRAG_END] when you prefer
   * polling the value.
   */
  public final fun guiIsDragging(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.guiIsDraggingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the drag operation is successful.
   */
  public final fun guiIsDragSuccessful(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.guiIsDragSuccessfulPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes the focus from the currently focused [Control] within this viewport. If no [Control]
   * has the focus, does nothing.
   */
  public final fun guiReleaseFocus(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.guiReleaseFocusPtr)
  }

  /**
   * Returns the currently focused [Control] within this viewport. If no [Control] is focused,
   * returns `null`.
   */
  public final fun guiGetFocusOwner(): Control? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.guiGetFocusOwnerPtr)
    return (TransferContext.readReturnValue(OBJECT) as Control?)
  }

  /**
   * Returns the [Control] that the mouse is currently hovering over in this viewport. If no
   * [Control] has the cursor, returns `null`.
   *
   * Typically the leaf [Control] node or deepest level of the subtree which claims hover. This is
   * very useful when used together with [Node.isAncestorOf] to find if the mouse is within a control
   * tree.
   */
  public final fun guiGetHoveredControl(): Control? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.guiGetHoveredControlPtr)
    return (TransferContext.readReturnValue(OBJECT) as Control?)
  }

  public final fun setDisableInput(disable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disable)
    TransferContext.callMethod(MethodBindings.setDisableInputPtr)
  }

  public final fun isInputDisabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isInputDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPositionalShadowAtlasSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setPositionalShadowAtlasSizePtr)
  }

  public final fun getPositionalShadowAtlasSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionalShadowAtlasSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setPositionalShadowAtlas16Bits(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setPositionalShadowAtlas16BitsPtr)
  }

  public final fun getPositionalShadowAtlas16Bits(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionalShadowAtlas16BitsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSnapControlsToPixels(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSnapControlsToPixelsPtr)
  }

  public final fun isSnapControlsToPixelsEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSnapControlsToPixelsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSnap2dTransformsToPixel(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSnap2dTransformsToPixelPtr)
  }

  public final fun isSnap2dTransformsToPixelEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSnap2dTransformsToPixelEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSnap2dVerticesToPixel(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSnap2dVerticesToPixelPtr)
  }

  public final fun isSnap2dVerticesToPixelEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSnap2dVerticesToPixelEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the number of subdivisions to use in the specified quadrant. A higher number of
   * subdivisions allows you to have more shadows in the scene at once, but reduces the quality of the
   * shadows. A good practice is to have quadrants with a varying number of subdivisions and to have as
   * few subdivisions as possible.
   */
  public final fun setPositionalShadowAtlasQuadrantSubdiv(quadrant: Int,
      subdiv: PositionalShadowAtlasQuadrantSubdiv): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quadrant.toLong(), LONG to subdiv.value)
    TransferContext.callMethod(MethodBindings.setPositionalShadowAtlasQuadrantSubdivPtr)
  }

  /**
   * Returns the positional shadow atlas quadrant subdivision of the specified quadrant.
   */
  public final fun getPositionalShadowAtlasQuadrantSubdiv(quadrant: Int):
      PositionalShadowAtlasQuadrantSubdiv {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quadrant.toLong())
    TransferContext.callMethod(MethodBindings.getPositionalShadowAtlasQuadrantSubdivPtr)
    return PositionalShadowAtlasQuadrantSubdiv.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Stops the input from propagating further up the [SceneTree].
   *
   * **Note:** This does not affect the methods in [Input], only the way events are propagated.
   */
  public final fun setInputAsHandled(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.setInputAsHandledPtr)
  }

  /**
   * Returns whether the current [InputEvent] has been handled. Input events are not handled until
   * [setInputAsHandled] has been called during the lifetime of an [InputEvent].
   *
   * This is usually done as part of input handling methods like [Node.Input], [Control.GuiInput] or
   * others, as well as in corresponding signal handlers.
   *
   * If [handleInputLocally] is set to `false`, this method will try finding the first parent
   * viewport that is set to handle input locally, and return its value for [isInputHandled] instead.
   */
  public final fun isInputHandled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isInputHandledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHandleInputLocally(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setHandleInputLocallyPtr)
  }

  public final fun isHandlingInputLocally(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHandlingInputLocallyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDefaultCanvasItemTextureFilter(mode: DefaultCanvasItemTextureFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setDefaultCanvasItemTextureFilterPtr)
  }

  public final fun getDefaultCanvasItemTextureFilter(): DefaultCanvasItemTextureFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDefaultCanvasItemTextureFilterPtr)
    return DefaultCanvasItemTextureFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setEmbeddingSubwindows(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setEmbeddingSubwindowsPtr)
  }

  public final fun isEmbeddingSubwindows(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmbeddingSubwindowsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a list of the visible embedded [Window]s inside the viewport.
   *
   * **Note:** [Window]s inside other viewports will not be listed.
   */
  public final fun getEmbeddedSubwindows(): VariantArray<Window> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmbeddedSubwindowsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Window>)
  }

  public final fun setDragThreshold(threshold: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to threshold.toLong())
    TransferContext.callMethod(MethodBindings.setDragThresholdPtr)
  }

  public final fun getDragThreshold(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDragThresholdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setCanvasCullMask(mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask)
    TransferContext.callMethod(MethodBindings.setCanvasCullMaskPtr)
  }

  public final fun getCanvasCullMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCanvasCullMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Set/clear individual bits on the rendering layer mask. This simplifies editing this
   * [Viewport]'s layers.
   */
  public final fun setCanvasCullMaskBit(layer: Long, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setCanvasCullMaskBitPtr)
  }

  /**
   * Returns an individual bit on the rendering layer mask.
   */
  public final fun getCanvasCullMaskBit(layer: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layer)
    TransferContext.callMethod(MethodBindings.getCanvasCullMaskBitPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDefaultCanvasItemTextureRepeat(mode: DefaultCanvasItemTextureRepeat): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setDefaultCanvasItemTextureRepeatPtr)
  }

  public final fun getDefaultCanvasItemTextureRepeat(): DefaultCanvasItemTextureRepeat {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDefaultCanvasItemTextureRepeatPtr)
    return DefaultCanvasItemTextureRepeat.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSdfOversize(oversize: SDFOversize): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to oversize.value)
    TransferContext.callMethod(MethodBindings.setSdfOversizePtr)
  }

  public final fun getSdfOversize(): SDFOversize {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfOversizePtr)
    return SDFOversize.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSdfScale(scale: SDFScale): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to scale.value)
    TransferContext.callMethod(MethodBindings.setSdfScalePtr)
  }

  public final fun getSdfScale(): SDFScale {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSdfScalePtr)
    return SDFScale.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMeshLodThreshold(pixels: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pixels.toDouble())
    TransferContext.callMethod(MethodBindings.setMeshLodThresholdPtr)
  }

  public final fun getMeshLodThreshold(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshLodThresholdPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAsAudioListener2d(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAsAudioListener2dPtr)
  }

  public final fun isAudioListener2d(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAudioListener2dPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the currently active 2D audio listener. Returns `null` if there are no active 2D audio
   * listeners, in which case the active 2D camera will be treated as listener.
   */
  public final fun getAudioListener2d(): AudioListener2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAudioListener2dPtr)
    return (TransferContext.readReturnValue(OBJECT) as AudioListener2D?)
  }

  /**
   * Returns the currently active 2D camera. Returns `null` if there are no active cameras.
   *
   * **Note:** If called while the *Camera Override* system is active in editor, this will return
   * the internally managed override camera. It is therefore advised to avoid caching the return value,
   * or to check that the cached value is still a valid instance and is the current camera before use.
   * See [@GlobalScope.isInstanceValid] and [Camera2D.isCurrent].
   */
  public final fun getCamera2d(): Camera2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCamera2dPtr)
    return (TransferContext.readReturnValue(OBJECT) as Camera2D?)
  }

  public final fun setWorld3d(world3d: World3D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to world3d)
    TransferContext.callMethod(MethodBindings.setWorld3dPtr)
  }

  public final fun getWorld3d(): World3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWorld3dPtr)
    return (TransferContext.readReturnValue(OBJECT) as World3D?)
  }

  /**
   * Returns the first valid [World3D] for this viewport, searching the [world3d] property of itself
   * and any Viewport ancestor.
   */
  public final fun findWorld3d(): World3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.findWorld3dPtr)
    return (TransferContext.readReturnValue(OBJECT) as World3D?)
  }

  public final fun setUseOwnWorld3d(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseOwnWorld3dPtr)
  }

  public final fun isUsingOwnWorld3d(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingOwnWorld3dPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the currently active 3D audio listener. Returns `null` if there are no active 3D audio
   * listeners, in which case the active 3D camera will be treated as listener.
   */
  public final fun getAudioListener3d(): AudioListener3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAudioListener3dPtr)
    return (TransferContext.readReturnValue(OBJECT) as AudioListener3D?)
  }

  /**
   * Returns the currently active 3D camera. Returns `null` if there are no active cameras.
   *
   * **Note:** If called while the *Camera Override* system is active in editor, this will return
   * the internally managed override camera. It is therefore advised to avoid caching the return value,
   * or to check that the cached value is a valid instance and is the current camera before use. See
   * [@GlobalScope.isInstanceValid] and [Camera3D.current].
   */
  public final fun getCamera3d(): Camera3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCamera3dPtr)
    return (TransferContext.readReturnValue(OBJECT) as Camera3D?)
  }

  public final fun setAsAudioListener3d(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAsAudioListener3dPtr)
  }

  public final fun isAudioListener3d(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAudioListener3dPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDisable3d(disable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disable)
    TransferContext.callMethod(MethodBindings.setDisable3dPtr)
  }

  public final fun is3dDisabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.is3dDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseXr(use: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to use)
    TransferContext.callMethod(MethodBindings.setUseXrPtr)
  }

  public final fun isUsingXr(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingXrPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setScaling3dMode(scaling3dMode: Scaling3DMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to scaling3dMode.value)
    TransferContext.callMethod(MethodBindings.setScaling3dModePtr)
  }

  public final fun getScaling3dMode(): Scaling3DMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScaling3dModePtr)
    return Scaling3DMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setScaling3dScale(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setScaling3dScalePtr)
  }

  public final fun getScaling3dScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScaling3dScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFsrSharpness(fsrSharpness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fsrSharpness.toDouble())
    TransferContext.callMethod(MethodBindings.setFsrSharpnessPtr)
  }

  public final fun getFsrSharpness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFsrSharpnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTextureMipmapBias(textureMipmapBias: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to textureMipmapBias.toDouble())
    TransferContext.callMethod(MethodBindings.setTextureMipmapBiasPtr)
  }

  public final fun getTextureMipmapBias(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureMipmapBiasPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAnisotropicFilteringLevel(anisotropicFilteringLevel: AnisotropicFiltering):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to anisotropicFilteringLevel.value)
    TransferContext.callMethod(MethodBindings.setAnisotropicFilteringLevelPtr)
  }

  public final fun getAnisotropicFilteringLevel(): AnisotropicFiltering {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnisotropicFilteringLevelPtr)
    return AnisotropicFiltering.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVrsMode(mode: VRSMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setVrsModePtr)
  }

  public final fun getVrsMode(): VRSMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVrsModePtr)
    return VRSMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVrsUpdateMode(mode: VRSUpdateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setVrsUpdateModePtr)
  }

  public final fun getVrsUpdateMode(): VRSUpdateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVrsUpdateModePtr)
    return VRSUpdateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVrsTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setVrsTexturePtr)
  }

  public final fun getVrsTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVrsTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public enum class PositionalShadowAtlasQuadrantSubdiv(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This quadrant will not be used.
     */
    SHADOW_ATLAS_QUADRANT_SUBDIV_DISABLED(0),
    /**
     * This quadrant will only be used by one shadow map.
     */
    SHADOW_ATLAS_QUADRANT_SUBDIV_1(1),
    /**
     * This quadrant will be split in 4 and used by up to 4 shadow maps.
     */
    SHADOW_ATLAS_QUADRANT_SUBDIV_4(2),
    /**
     * This quadrant will be split 16 ways and used by up to 16 shadow maps.
     */
    SHADOW_ATLAS_QUADRANT_SUBDIV_16(3),
    /**
     * This quadrant will be split 64 ways and used by up to 64 shadow maps.
     */
    SHADOW_ATLAS_QUADRANT_SUBDIV_64(4),
    /**
     * This quadrant will be split 256 ways and used by up to 256 shadow maps. Unless the
     * [positionalShadowAtlasSize] is very high, the shadows in this quadrant will be very low
     * resolution.
     */
    SHADOW_ATLAS_QUADRANT_SUBDIV_256(5),
    /**
     * This quadrant will be split 1024 ways and used by up to 1024 shadow maps. Unless the
     * [positionalShadowAtlasSize] is very high, the shadows in this quadrant will be very low
     * resolution.
     */
    SHADOW_ATLAS_QUADRANT_SUBDIV_1024(6),
    /**
     * Represents the size of the [PositionalShadowAtlasQuadrantSubdiv] enum.
     */
    SHADOW_ATLAS_QUADRANT_SUBDIV_MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): PositionalShadowAtlasQuadrantSubdiv =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class Scaling3DMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use bilinear scaling for the viewport's 3D buffer. The amount of scaling can be set using
     * [scaling3dScale]. Values less than `1.0` will result in undersampling while values greater than
     * `1.0` will result in supersampling. A value of `1.0` disables scaling.
     */
    SCALING_3D_MODE_BILINEAR(0),
    /**
     * Use AMD FidelityFX Super Resolution 1.0 upscaling for the viewport's 3D buffer. The amount of
     * scaling can be set using [scaling3dScale]. Values less than `1.0` will result in the viewport
     * being upscaled using FSR. Values greater than `1.0` are not supported and bilinear downsampling
     * will be used instead. A value of `1.0` disables scaling.
     */
    SCALING_3D_MODE_FSR(1),
    /**
     * Use AMD FidelityFX Super Resolution 2.2 upscaling for the viewport's 3D buffer. The amount of
     * scaling can be set using [Viewport.scaling3dScale]. Values less than `1.0` will result in the
     * viewport being upscaled using FSR2. Values greater than `1.0` are not supported and bilinear
     * downsampling will be used instead. A value of `1.0` will use FSR2 at native resolution as a TAA
     * solution.
     */
    SCALING_3D_MODE_FSR2(2),
    /**
     * Use the
     * [url=https://developer.apple.com/documentation/metalfx/mtlfxspatialscaler#overview]MetalFX
     * spatial upscaler[/url] for the viewport's 3D buffer.
     *
     * The amount of scaling can be set using [scaling3dScale].
     *
     * Values less than `1.0` will result in the viewport being upscaled using MetalFX. Values
     * greater than `1.0` are not supported and bilinear downsampling will be used instead. A value of
     * `1.0` disables scaling.
     *
     * More information: [url=https://developer.apple.com/documentation/metalfx]MetalFX[/url].
     *
     * **Note:** Only supported when the Metal rendering driver is in use, which limits this scaling
     * mode to macOS and iOS.
     */
    SCALING_3D_MODE_METALFX_SPATIAL(3),
    /**
     * Use the
     * [url=https://developer.apple.com/documentation/metalfx/mtlfxtemporalscaler#overview]MetalFX
     * temporal upscaler[/url] for the viewport's 3D buffer.
     *
     * The amount of scaling can be set using [scaling3dScale]. To determine the minimum input
     * scale, use the [RenderingDevice.limitGet] method with
     * [RenderingDevice.LIMIT_METALFX_TEMPORAL_SCALER_MIN_SCALE].
     *
     * Values less than `1.0` will result in the viewport being upscaled using MetalFX. Values
     * greater than `1.0` are not supported and bilinear downsampling will be used instead. A value of
     * `1.0` will use MetalFX at native resolution as a TAA solution.
     *
     * More information: [url=https://developer.apple.com/documentation/metalfx]MetalFX[/url].
     *
     * **Note:** Only supported when the Metal rendering driver is in use, which limits this scaling
     * mode to macOS and iOS.
     */
    SCALING_3D_MODE_METALFX_TEMPORAL(4),
    /**
     * Use nearest-neighbor filtering for the viewport's 3D buffer. This looks crisper than
     * [SCALING_3D_MODE_BILINEAR] and has no additional rendering cost. The amount of scaling can be
     * set using [scaling3dScale]. Values greater than `1.0` are not supported and bilinear
     * downsampling will be used instead. A value of `1.0` disables scaling.
     *
     * **Note:** When using the **Nearest** scaling mode, to avoid uneven pixel scaling, it's highly
     * recommended to use a value equal to an integer divisor with a dividend of `1`. For example, it's
     * best to use a scale of `0.5` (1/2), `0.3333` (1/3), `0.25` (1/4), `0.2` (1/5), and so on.
     */
    SCALING_3D_MODE_NEAREST(5),
    /**
     * Represents the size of the [Scaling3DMode] enum.
     */
    SCALING_3D_MODE_MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): Scaling3DMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class MSAA(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Multisample antialiasing mode disabled. This is the default value, and is also the fastest
     * setting.
     */
    DISABLED(0),
    /**
     * Use 2× Multisample Antialiasing. This has a moderate performance cost. It helps reduce
     * aliasing noticeably, but 4× MSAA still looks substantially better.
     */
    MSAA_2X(1),
    /**
     * Use 4× Multisample Antialiasing. This has a significant performance cost, and is generally a
     * good compromise between performance and quality.
     */
    MSAA_4X(2),
    /**
     * Use 8× Multisample Antialiasing. This has a very high performance cost. The difference
     * between 4× and 8× MSAA may not always be visible in real gameplay conditions. Likely unsupported
     * on low-end and older hardware.
     */
    MSAA_8X(3),
    /**
     * Represents the size of the [MSAA] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): MSAA = entries.single { it.`value` == `value` }
    }
  }

  public enum class AnisotropicFiltering(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Anisotropic filtering is disabled.
     */
    ANISOTROPY_DISABLED(0),
    /**
     * Use 2× anisotropic filtering.
     */
    ANISOTROPY_2X(1),
    /**
     * Use 4× anisotropic filtering. This is the default value.
     */
    ANISOTROPY_4X(2),
    /**
     * Use 8× anisotropic filtering.
     */
    ANISOTROPY_8X(3),
    /**
     * Use 16× anisotropic filtering.
     */
    ANISOTROPY_16X(4),
    /**
     * Represents the size of the [AnisotropicFiltering] enum.
     */
    ANISOTROPY_MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): AnisotropicFiltering =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ScreenSpaceAA(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not perform any antialiasing in the full screen post-process.
     */
    DISABLED(0),
    /**
     * Use fast approximate antialiasing. FXAA is a popular screen-space antialiasing method, which
     * is fast but will make the image look blurry, especially at lower resolutions. It can still work
     * relatively well at large resolutions such as 1440p and 4K.
     */
    FXAA(1),
    /**
     * Use subpixel morphological antialiasing. SMAA may produce clearer results than FXAA, but at a
     * slightly higher performance cost.
     */
    SMAA(2),
    /**
     * Represents the size of the [ScreenSpaceAA] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ScreenSpaceAA = entries.single { it.`value` == `value` }
    }
  }

  public enum class RenderInfo(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Amount of objects in frame.
     */
    OBJECTS_IN_FRAME(0),
    /**
     * Amount of vertices in frame.
     */
    PRIMITIVES_IN_FRAME(1),
    /**
     * Amount of draw calls in frame.
     */
    DRAW_CALLS_IN_FRAME(2),
    /**
     * Represents the size of the [RenderInfo] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): RenderInfo = entries.single { it.`value` == `value` }
    }
  }

  public enum class RenderInfoType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Visible render pass (excluding shadows).
     */
    VISIBLE(0),
    /**
     * Shadow render pass. Objects will be rendered several times depending on the number of amounts
     * of lights with shadows and the number of directional shadow splits.
     */
    SHADOW(1),
    /**
     * Canvas item rendering. This includes all 2D rendering.
     */
    CANVAS(2),
    /**
     * Represents the size of the [RenderInfoType] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): RenderInfoType = entries.single { it.`value` == `value` }
    }
  }

  public enum class DebugDraw(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Objects are displayed normally.
     */
    DISABLED(0),
    /**
     * Objects are displayed without light information.
     */
    UNSHADED(1),
    /**
     * Objects are displayed without textures and only with lighting information.
     *
     * **Note:** When using this debug draw mode, custom shaders are ignored since all materials in
     * the scene temporarily use a debug material. This means the result from custom shader functions
     * (such as vertex displacement) won't be visible anymore when using this debug draw mode.
     */
    LIGHTING(2),
    /**
     * Objects are displayed semi-transparent with additive blending so you can see where they are
     * drawing over top of one another. A higher overdraw means you are wasting performance on drawing
     * pixels that are being hidden behind others.
     *
     * **Note:** When using this debug draw mode, custom shaders are ignored since all materials in
     * the scene temporarily use a debug material. This means the result from custom shader functions
     * (such as vertex displacement) won't be visible anymore when using this debug draw mode.
     */
    OVERDRAW(3),
    /**
     * Objects are displayed as wireframe models.
     *
     * **Note:** [RenderingServer.setDebugGenerateWireframes] must be called before loading any
     * meshes for wireframes to be visible when using the Compatibility renderer.
     *
     * **Note:** In the Compatibility renderer, backfaces are always visible when using wireframe
     * rendering. In the Forward+ and Mobile renderers, wireframes follow the material's backface
     * culling properties instead.
     */
    WIREFRAME(4),
    /**
     * Objects are displayed without lighting information and their textures replaced by normal
     * mapping.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    NORMAL_BUFFER(5),
    /**
     * Objects are displayed with only the albedo value from [VoxelGI]s. Requires at least one
     * visible [VoxelGI] node that has been baked to have a visible effect.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    VOXEL_GI_ALBEDO(6),
    /**
     * Objects are displayed with only the lighting value from [VoxelGI]s. Requires at least one
     * visible [VoxelGI] node that has been baked to have a visible effect.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    VOXEL_GI_LIGHTING(7),
    /**
     * Objects are displayed with only the emission color from [VoxelGI]s. Requires at least one
     * visible [VoxelGI] node that has been baked to have a visible effect.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    VOXEL_GI_EMISSION(8),
    /**
     * Draws the shadow atlas that stores shadows from [OmniLight3D]s and [SpotLight3D]s in the
     * upper left quadrant of the [Viewport].
     */
    SHADOW_ATLAS(9),
    /**
     * Draws the shadow atlas that stores shadows from [DirectionalLight3D]s in the upper left
     * quadrant of the [Viewport].
     */
    DIRECTIONAL_SHADOW_ATLAS(10),
    /**
     * Draws the scene luminance buffer (if available) in the upper left quadrant of the [Viewport].
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    SCENE_LUMINANCE(11),
    /**
     * Draws the screen-space ambient occlusion texture instead of the scene so that you can clearly
     * see how it is affecting objects. In order for this display mode to work, you must have
     * [Environment.ssaoEnabled] set in your [WorldEnvironment].
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    SSAO(12),
    /**
     * Draws the screen-space indirect lighting texture instead of the scene so that you can clearly
     * see how it is affecting objects. In order for this display mode to work, you must have
     * [Environment.ssilEnabled] set in your [WorldEnvironment].
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    SSIL(13),
    /**
     * Colors each PSSM split for the [DirectionalLight3D]s in the scene a different color so you
     * can see where the splits are. In order (from closest to furthest from the camera), they are
     * colored red, green, blue, and yellow.
     *
     * **Note:** When using this debug draw mode, custom shaders are ignored since all materials in
     * the scene temporarily use a debug material. This means the result from custom shader functions
     * (such as vertex displacement) won't be visible anymore when using this debug draw mode.
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    PSSM_SPLITS(14),
    /**
     * Draws the decal atlas used by [Decal]s and light projector textures in the upper left
     * quadrant of the [Viewport].
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    DECAL_ATLAS(15),
    /**
     * Draws the cascades used to render signed distance field global illumination (SDFGI).
     *
     * Does nothing if the current environment's [Environment.sdfgiEnabled] is `false`.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    SDFGI(16),
    /**
     * Draws the probes used for signed distance field global illumination (SDFGI).
     *
     * When in the editor, left-clicking a probe will display additional bright dots that show its
     * occlusion information. A white dot means the light is not occluded at all at the dot's position,
     * while a red dot means the light is fully occluded. Intermediate values are possible.
     *
     * Does nothing if the current environment's [Environment.sdfgiEnabled] is `false`.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    SDFGI_PROBES(17),
    /**
     * Draws the buffer used for global illumination from [VoxelGI] or SDFGI. Requires [VoxelGI] (at
     * least one visible baked VoxelGI node) or SDFGI ([Environment.sdfgiEnabled]) to be enabled to
     * have a visible effect.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    GI_BUFFER(18),
    /**
     * Draws all of the objects at their highest polycount regardless of their distance from the
     * camera. No low level of detail (LOD) is applied.
     */
    DISABLE_LOD(19),
    /**
     * Draws the cluster used by [OmniLight3D] nodes to optimize light rendering.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_OMNI_LIGHTS(20),
    /**
     * Draws the cluster used by [SpotLight3D] nodes to optimize light rendering.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_SPOT_LIGHTS(21),
    /**
     * Draws the cluster used by [Decal] nodes to optimize decal rendering.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_DECALS(22),
    /**
     * Draws the cluster used by [ReflectionProbe] nodes to optimize reflection probes.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_REFLECTION_PROBES(23),
    /**
     * Draws the buffer used for occlusion culling.
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    OCCLUDERS(24),
    /**
     * Draws vector lines over the viewport to indicate the movement of pixels between frames.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    MOTION_VECTORS(25),
    /**
     * Draws the internal resolution buffer of the scene in linear colorspace before tonemapping or
     * post-processing is applied.
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    INTERNAL_BUFFER(26),
    /**
     * Draws the cluster used by [AreaLight3D] nodes to optimize light rendering.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_AREA_LIGHTS(27),
    /**
     * Draws the atlas used by [AreaLight3D] nodes in the upper left quadrant of the [Viewport].
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering method.
     */
    AREA_LIGHT_ATLAS(28),
    ;

    public companion object {
      public fun from(`value`: Long): DebugDraw = entries.single { it.`value` == `value` }
    }
  }

  public enum class DefaultCanvasItemTextureFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The texture filter reads from the nearest pixel only. This makes the texture look pixelated
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    NEAREST(0),
    /**
     * The texture filter blends between the nearest 4 pixels. This makes the texture look smooth
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    LINEAR(1),
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
    LINEAR_WITH_MIPMAPS(2),
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
     * The [Viewport] will inherit the filter from its parent [CanvasItem] or [Viewport].
     */
    PARENT_NODE(4),
    /**
     * Represents the size of the [DefaultCanvasItemTextureFilter] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): DefaultCanvasItemTextureFilter =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class DefaultCanvasItemTextureRepeat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables textures repeating. Instead, when reading UVs outside the 0-1 range, the value will
     * be clamped to the edge of the texture, resulting in a stretched out look at the borders of the
     * texture.
     */
    DISABLED(0),
    /**
     * Enables the texture to repeat when UV coordinates are outside the 0-1 range. If using one of
     * the linear filtering modes, this can result in artifacts at the edges of a texture when the
     * sampler filters across the edges of the texture.
     */
    ENABLED(1),
    /**
     * Flip the texture when repeating so that the edge lines up instead of abruptly changing.
     */
    MIRROR(2),
    /**
     * The [Viewport] will inherit the repeat mode from its parent [CanvasItem] or [Viewport].
     */
    PARENT_NODE(3),
    /**
     * Represents the size of the [DefaultCanvasItemTextureRepeat] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): DefaultCanvasItemTextureRepeat =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class SDFOversize(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The signed distance field only covers the viewport's own rectangle.
     */
    SDF_OVERSIZE_100_PERCENT(0),
    /**
     * The signed distance field is expanded to cover 20&#37; of the viewport's size around the
     * borders.
     */
    SDF_OVERSIZE_120_PERCENT(1),
    /**
     * The signed distance field is expanded to cover 50&#37; of the viewport's size around the
     * borders.
     */
    SDF_OVERSIZE_150_PERCENT(2),
    /**
     * The signed distance field is expanded to cover 100&#37; (double) of the viewport's size
     * around the borders.
     */
    SDF_OVERSIZE_200_PERCENT(3),
    /**
     * Represents the size of the [SDFOversize] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): SDFOversize = entries.single { it.`value` == `value` }
    }
  }

  public enum class SDFScale(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The signed distance field is rendered at full resolution.
     */
    SDF_SCALE_100_PERCENT(0),
    /**
     * The signed distance field is rendered at half the resolution of this viewport.
     */
    SDF_SCALE_50_PERCENT(1),
    /**
     * The signed distance field is rendered at a quarter the resolution of this viewport.
     */
    SDF_SCALE_25_PERCENT(2),
    /**
     * Represents the size of the [SDFScale] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): SDFScale = entries.single { it.`value` == `value` }
    }
  }

  public enum class VRSMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Variable Rate Shading is disabled.
     */
    DISABLED(0),
    /**
     * Variable Rate Shading uses a texture. Note, for stereoscopic use a texture atlas with a
     * texture for each view.
     */
    TEXTURE(1),
    /**
     * Variable Rate Shading's texture is supplied by the primary [XRInterface].
     */
    XR(2),
    /**
     * Represents the size of the [VRSMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): VRSMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class VRSUpdateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The input texture for variable rate shading will not be processed.
     */
    DISABLED(0),
    /**
     * The input texture for variable rate shading will be processed once.
     */
    ONCE(1),
    /**
     * The input texture for variable rate shading will be processed each frame.
     */
    ALWAYS(2),
    /**
     * Represents the size of the [VRSUpdateMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): VRSUpdateMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setWorld2dName: MethodStringName1<Viewport, Unit, World2D?> =
        MethodStringName1<Viewport, Unit, World2D?>("set_world_2d")

    @JvmField
    public val getWorld2dName: MethodStringName0<Viewport, World2D?> =
        MethodStringName0<Viewport, World2D?>("get_world_2d")

    @JvmField
    public val findWorld2dName: MethodStringName0<Viewport, World2D?> =
        MethodStringName0<Viewport, World2D?>("find_world_2d")

    @JvmField
    public val setCanvasTransformName: MethodStringName1<Viewport, Unit, Transform2D> =
        MethodStringName1<Viewport, Unit, Transform2D>("set_canvas_transform")

    @JvmField
    public val getCanvasTransformName: MethodStringName0<Viewport, Transform2D> =
        MethodStringName0<Viewport, Transform2D>("get_canvas_transform")

    @JvmField
    public val setGlobalCanvasTransformName: MethodStringName1<Viewport, Unit, Transform2D> =
        MethodStringName1<Viewport, Unit, Transform2D>("set_global_canvas_transform")

    @JvmField
    public val getGlobalCanvasTransformName: MethodStringName0<Viewport, Transform2D> =
        MethodStringName0<Viewport, Transform2D>("get_global_canvas_transform")

    @JvmField
    public val getStretchTransformName: MethodStringName0<Viewport, Transform2D> =
        MethodStringName0<Viewport, Transform2D>("get_stretch_transform")

    @JvmField
    public val getFinalTransformName: MethodStringName0<Viewport, Transform2D> =
        MethodStringName0<Viewport, Transform2D>("get_final_transform")

    @JvmField
    public val getScreenTransformName: MethodStringName0<Viewport, Transform2D> =
        MethodStringName0<Viewport, Transform2D>("get_screen_transform")

    @JvmField
    public val getVisibleRectName: MethodStringName0<Viewport, Rect2> =
        MethodStringName0<Viewport, Rect2>("get_visible_rect")

    @JvmField
    public val setTransparentBackgroundName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_transparent_background")

    @JvmField
    public val hasTransparentBackgroundName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("has_transparent_background")

    @JvmField
    public val setUseHdr2dName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_use_hdr_2d")

    @JvmField
    public val isUsingHdr2dName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_using_hdr_2d")

    @JvmField
    public val setMsaa2dName: MethodStringName1<Viewport, Unit, MSAA> =
        MethodStringName1<Viewport, Unit, MSAA>("set_msaa_2d")

    @JvmField
    public val getMsaa2dName: MethodStringName0<Viewport, MSAA> =
        MethodStringName0<Viewport, MSAA>("get_msaa_2d")

    @JvmField
    public val setMsaa3dName: MethodStringName1<Viewport, Unit, MSAA> =
        MethodStringName1<Viewport, Unit, MSAA>("set_msaa_3d")

    @JvmField
    public val getMsaa3dName: MethodStringName0<Viewport, MSAA> =
        MethodStringName0<Viewport, MSAA>("get_msaa_3d")

    @JvmField
    public val setScreenSpaceAaName: MethodStringName1<Viewport, Unit, ScreenSpaceAA> =
        MethodStringName1<Viewport, Unit, ScreenSpaceAA>("set_screen_space_aa")

    @JvmField
    public val getScreenSpaceAaName: MethodStringName0<Viewport, ScreenSpaceAA> =
        MethodStringName0<Viewport, ScreenSpaceAA>("get_screen_space_aa")

    @JvmField
    public val setUseTaaName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_use_taa")

    @JvmField
    public val isUsingTaaName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_using_taa")

    @JvmField
    public val setUseDebandingName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_use_debanding")

    @JvmField
    public val isUsingDebandingName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_using_debanding")

    @JvmField
    public val setUseOcclusionCullingName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_use_occlusion_culling")

    @JvmField
    public val isUsingOcclusionCullingName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_using_occlusion_culling")

    @JvmField
    public val setDebugDrawName: MethodStringName1<Viewport, Unit, DebugDraw> =
        MethodStringName1<Viewport, Unit, DebugDraw>("set_debug_draw")

    @JvmField
    public val getDebugDrawName: MethodStringName0<Viewport, DebugDraw> =
        MethodStringName0<Viewport, DebugDraw>("get_debug_draw")

    @JvmField
    public val setUseOversamplingName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_use_oversampling")

    @JvmField
    public val isUsingOversamplingName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_using_oversampling")

    @JvmField
    public val setOversamplingOverrideName: MethodStringName1<Viewport, Unit, Float> =
        MethodStringName1<Viewport, Unit, Float>("set_oversampling_override")

    @JvmField
    public val getOversamplingOverrideName: MethodStringName0<Viewport, Float> =
        MethodStringName0<Viewport, Float>("get_oversampling_override")

    @JvmField
    public val getOversamplingName: MethodStringName0<Viewport, Float> =
        MethodStringName0<Viewport, Float>("get_oversampling")

    @JvmField
    public val getRenderInfoName: MethodStringName2<Viewport, Int, RenderInfoType, RenderInfo> =
        MethodStringName2<Viewport, Int, RenderInfoType, RenderInfo>("get_render_info")

    @JvmField
    public val getTextureName: MethodStringName0<Viewport, ViewportTexture?> =
        MethodStringName0<Viewport, ViewportTexture?>("get_texture")

    @JvmField
    public val setPhysicsObjectPickingName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_physics_object_picking")

    @JvmField
    public val getPhysicsObjectPickingName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("get_physics_object_picking")

    @JvmField
    public val setPhysicsObjectPickingSortName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_physics_object_picking_sort")

    @JvmField
    public val getPhysicsObjectPickingSortName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("get_physics_object_picking_sort")

    @JvmField
    public val setPhysicsObjectPickingFirstOnlyName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_physics_object_picking_first_only")

    @JvmField
    public val getPhysicsObjectPickingFirstOnlyName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("get_physics_object_picking_first_only")

    @JvmField
    public val getViewportRidName: MethodStringName0<Viewport, RID> =
        MethodStringName0<Viewport, RID>("get_viewport_rid")

    @JvmField
    public val pushTextInputName: MethodStringName1<Viewport, Unit, String> =
        MethodStringName1<Viewport, Unit, String>("push_text_input")

    @JvmField
    public val pushInputName: MethodStringName2<Viewport, Unit, InputEvent, Boolean> =
        MethodStringName2<Viewport, Unit, InputEvent, Boolean>("push_input")

    @JvmField
    public val pushUnhandledInputName: MethodStringName2<Viewport, Unit, InputEvent, Boolean> =
        MethodStringName2<Viewport, Unit, InputEvent, Boolean>("push_unhandled_input")

    @JvmField
    public val notifyMouseEnteredName: MethodStringName0<Viewport, Unit> =
        MethodStringName0<Viewport, Unit>("notify_mouse_entered")

    @JvmField
    public val notifyMouseExitedName: MethodStringName0<Viewport, Unit> =
        MethodStringName0<Viewport, Unit>("notify_mouse_exited")

    @JvmField
    public val getMousePositionName: MethodStringName0<Viewport, Vector2> =
        MethodStringName0<Viewport, Vector2>("get_mouse_position")

    @JvmField
    public val warpMouseName: MethodStringName1<Viewport, Unit, Vector2> =
        MethodStringName1<Viewport, Unit, Vector2>("warp_mouse")

    @JvmField
    public val updateMouseCursorStateName: MethodStringName0<Viewport, Unit> =
        MethodStringName0<Viewport, Unit>("update_mouse_cursor_state")

    @JvmField
    public val guiCancelDragName: MethodStringName0<Viewport, Unit> =
        MethodStringName0<Viewport, Unit>("gui_cancel_drag")

    @JvmField
    public val guiGetDragDataName: MethodStringName0<Viewport, Any?> =
        MethodStringName0<Viewport, Any?>("gui_get_drag_data")

    @JvmField
    public val guiGetDragDescriptionName: MethodStringName0<Viewport, String> =
        MethodStringName0<Viewport, String>("gui_get_drag_description")

    @JvmField
    public val guiSetDragDescriptionName: MethodStringName1<Viewport, Unit, String> =
        MethodStringName1<Viewport, Unit, String>("gui_set_drag_description")

    @JvmField
    public val guiIsDraggingName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("gui_is_dragging")

    @JvmField
    public val guiIsDragSuccessfulName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("gui_is_drag_successful")

    @JvmField
    public val guiReleaseFocusName: MethodStringName0<Viewport, Unit> =
        MethodStringName0<Viewport, Unit>("gui_release_focus")

    @JvmField
    public val guiGetFocusOwnerName: MethodStringName0<Viewport, Control?> =
        MethodStringName0<Viewport, Control?>("gui_get_focus_owner")

    @JvmField
    public val guiGetHoveredControlName: MethodStringName0<Viewport, Control?> =
        MethodStringName0<Viewport, Control?>("gui_get_hovered_control")

    @JvmField
    public val setDisableInputName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_disable_input")

    @JvmField
    public val isInputDisabledName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_input_disabled")

    @JvmField
    public val setPositionalShadowAtlasSizeName: MethodStringName1<Viewport, Unit, Int> =
        MethodStringName1<Viewport, Unit, Int>("set_positional_shadow_atlas_size")

    @JvmField
    public val getPositionalShadowAtlasSizeName: MethodStringName0<Viewport, Int> =
        MethodStringName0<Viewport, Int>("get_positional_shadow_atlas_size")

    @JvmField
    public val setPositionalShadowAtlas16BitsName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_positional_shadow_atlas_16_bits")

    @JvmField
    public val getPositionalShadowAtlas16BitsName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("get_positional_shadow_atlas_16_bits")

    @JvmField
    public val setSnapControlsToPixelsName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_snap_controls_to_pixels")

    @JvmField
    public val isSnapControlsToPixelsEnabledName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_snap_controls_to_pixels_enabled")

    @JvmField
    public val setSnap2dTransformsToPixelName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_snap_2d_transforms_to_pixel")

    @JvmField
    public val isSnap2dTransformsToPixelEnabledName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_snap_2d_transforms_to_pixel_enabled")

    @JvmField
    public val setSnap2dVerticesToPixelName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_snap_2d_vertices_to_pixel")

    @JvmField
    public val isSnap2dVerticesToPixelEnabledName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_snap_2d_vertices_to_pixel_enabled")

    @JvmField
    public val setPositionalShadowAtlasQuadrantSubdivName:
        MethodStringName2<Viewport, Unit, Int, PositionalShadowAtlasQuadrantSubdiv> =
        MethodStringName2<Viewport, Unit, Int, PositionalShadowAtlasQuadrantSubdiv>("set_positional_shadow_atlas_quadrant_subdiv")

    @JvmField
    public val getPositionalShadowAtlasQuadrantSubdivName:
        MethodStringName1<Viewport, PositionalShadowAtlasQuadrantSubdiv, Int> =
        MethodStringName1<Viewport, PositionalShadowAtlasQuadrantSubdiv, Int>("get_positional_shadow_atlas_quadrant_subdiv")

    @JvmField
    public val setInputAsHandledName: MethodStringName0<Viewport, Unit> =
        MethodStringName0<Viewport, Unit>("set_input_as_handled")

    @JvmField
    public val isInputHandledName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_input_handled")

    @JvmField
    public val setHandleInputLocallyName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_handle_input_locally")

    @JvmField
    public val isHandlingInputLocallyName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_handling_input_locally")

    @JvmField
    public val setDefaultCanvasItemTextureFilterName:
        MethodStringName1<Viewport, Unit, DefaultCanvasItemTextureFilter> =
        MethodStringName1<Viewport, Unit, DefaultCanvasItemTextureFilter>("set_default_canvas_item_texture_filter")

    @JvmField
    public val getDefaultCanvasItemTextureFilterName:
        MethodStringName0<Viewport, DefaultCanvasItemTextureFilter> =
        MethodStringName0<Viewport, DefaultCanvasItemTextureFilter>("get_default_canvas_item_texture_filter")

    @JvmField
    public val setEmbeddingSubwindowsName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_embedding_subwindows")

    @JvmField
    public val isEmbeddingSubwindowsName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_embedding_subwindows")

    @JvmField
    public val getEmbeddedSubwindowsName: MethodStringName0<Viewport, VariantArray<Window>> =
        MethodStringName0<Viewport, VariantArray<Window>>("get_embedded_subwindows")

    @JvmField
    public val setDragThresholdName: MethodStringName1<Viewport, Unit, Int> =
        MethodStringName1<Viewport, Unit, Int>("set_drag_threshold")

    @JvmField
    public val getDragThresholdName: MethodStringName0<Viewport, Int> =
        MethodStringName0<Viewport, Int>("get_drag_threshold")

    @JvmField
    public val setCanvasCullMaskName: MethodStringName1<Viewport, Unit, Long> =
        MethodStringName1<Viewport, Unit, Long>("set_canvas_cull_mask")

    @JvmField
    public val getCanvasCullMaskName: MethodStringName0<Viewport, Long> =
        MethodStringName0<Viewport, Long>("get_canvas_cull_mask")

    @JvmField
    public val setCanvasCullMaskBitName: MethodStringName2<Viewport, Unit, Long, Boolean> =
        MethodStringName2<Viewport, Unit, Long, Boolean>("set_canvas_cull_mask_bit")

    @JvmField
    public val getCanvasCullMaskBitName: MethodStringName1<Viewport, Boolean, Long> =
        MethodStringName1<Viewport, Boolean, Long>("get_canvas_cull_mask_bit")

    @JvmField
    public val setDefaultCanvasItemTextureRepeatName:
        MethodStringName1<Viewport, Unit, DefaultCanvasItemTextureRepeat> =
        MethodStringName1<Viewport, Unit, DefaultCanvasItemTextureRepeat>("set_default_canvas_item_texture_repeat")

    @JvmField
    public val getDefaultCanvasItemTextureRepeatName:
        MethodStringName0<Viewport, DefaultCanvasItemTextureRepeat> =
        MethodStringName0<Viewport, DefaultCanvasItemTextureRepeat>("get_default_canvas_item_texture_repeat")

    @JvmField
    public val setSdfOversizeName: MethodStringName1<Viewport, Unit, SDFOversize> =
        MethodStringName1<Viewport, Unit, SDFOversize>("set_sdf_oversize")

    @JvmField
    public val getSdfOversizeName: MethodStringName0<Viewport, SDFOversize> =
        MethodStringName0<Viewport, SDFOversize>("get_sdf_oversize")

    @JvmField
    public val setSdfScaleName: MethodStringName1<Viewport, Unit, SDFScale> =
        MethodStringName1<Viewport, Unit, SDFScale>("set_sdf_scale")

    @JvmField
    public val getSdfScaleName: MethodStringName0<Viewport, SDFScale> =
        MethodStringName0<Viewport, SDFScale>("get_sdf_scale")

    @JvmField
    public val setMeshLodThresholdName: MethodStringName1<Viewport, Unit, Float> =
        MethodStringName1<Viewport, Unit, Float>("set_mesh_lod_threshold")

    @JvmField
    public val getMeshLodThresholdName: MethodStringName0<Viewport, Float> =
        MethodStringName0<Viewport, Float>("get_mesh_lod_threshold")

    @JvmField
    public val setAsAudioListener2dName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_as_audio_listener_2d")

    @JvmField
    public val isAudioListener2dName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_audio_listener_2d")

    @JvmField
    public val getAudioListener2dName: MethodStringName0<Viewport, AudioListener2D?> =
        MethodStringName0<Viewport, AudioListener2D?>("get_audio_listener_2d")

    @JvmField
    public val getCamera2dName: MethodStringName0<Viewport, Camera2D?> =
        MethodStringName0<Viewport, Camera2D?>("get_camera_2d")

    @JvmField
    public val setWorld3dName: MethodStringName1<Viewport, Unit, World3D?> =
        MethodStringName1<Viewport, Unit, World3D?>("set_world_3d")

    @JvmField
    public val getWorld3dName: MethodStringName0<Viewport, World3D?> =
        MethodStringName0<Viewport, World3D?>("get_world_3d")

    @JvmField
    public val findWorld3dName: MethodStringName0<Viewport, World3D?> =
        MethodStringName0<Viewport, World3D?>("find_world_3d")

    @JvmField
    public val setUseOwnWorld3dName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_use_own_world_3d")

    @JvmField
    public val isUsingOwnWorld3dName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_using_own_world_3d")

    @JvmField
    public val getAudioListener3dName: MethodStringName0<Viewport, AudioListener3D?> =
        MethodStringName0<Viewport, AudioListener3D?>("get_audio_listener_3d")

    @JvmField
    public val getCamera3dName: MethodStringName0<Viewport, Camera3D?> =
        MethodStringName0<Viewport, Camera3D?>("get_camera_3d")

    @JvmField
    public val setAsAudioListener3dName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_as_audio_listener_3d")

    @JvmField
    public val isAudioListener3dName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_audio_listener_3d")

    @JvmField
    public val setDisable3dName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_disable_3d")

    @JvmField
    public val is3dDisabledName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_3d_disabled")

    @JvmField
    public val setUseXrName: MethodStringName1<Viewport, Unit, Boolean> =
        MethodStringName1<Viewport, Unit, Boolean>("set_use_xr")

    @JvmField
    public val isUsingXrName: MethodStringName0<Viewport, Boolean> =
        MethodStringName0<Viewport, Boolean>("is_using_xr")

    @JvmField
    public val setScaling3dModeName: MethodStringName1<Viewport, Unit, Scaling3DMode> =
        MethodStringName1<Viewport, Unit, Scaling3DMode>("set_scaling_3d_mode")

    @JvmField
    public val getScaling3dModeName: MethodStringName0<Viewport, Scaling3DMode> =
        MethodStringName0<Viewport, Scaling3DMode>("get_scaling_3d_mode")

    @JvmField
    public val setScaling3dScaleName: MethodStringName1<Viewport, Unit, Float> =
        MethodStringName1<Viewport, Unit, Float>("set_scaling_3d_scale")

    @JvmField
    public val getScaling3dScaleName: MethodStringName0<Viewport, Float> =
        MethodStringName0<Viewport, Float>("get_scaling_3d_scale")

    @JvmField
    public val setFsrSharpnessName: MethodStringName1<Viewport, Unit, Float> =
        MethodStringName1<Viewport, Unit, Float>("set_fsr_sharpness")

    @JvmField
    public val getFsrSharpnessName: MethodStringName0<Viewport, Float> =
        MethodStringName0<Viewport, Float>("get_fsr_sharpness")

    @JvmField
    public val setTextureMipmapBiasName: MethodStringName1<Viewport, Unit, Float> =
        MethodStringName1<Viewport, Unit, Float>("set_texture_mipmap_bias")

    @JvmField
    public val getTextureMipmapBiasName: MethodStringName0<Viewport, Float> =
        MethodStringName0<Viewport, Float>("get_texture_mipmap_bias")

    @JvmField
    public val setAnisotropicFilteringLevelName:
        MethodStringName1<Viewport, Unit, AnisotropicFiltering> =
        MethodStringName1<Viewport, Unit, AnisotropicFiltering>("set_anisotropic_filtering_level")

    @JvmField
    public val getAnisotropicFilteringLevelName: MethodStringName0<Viewport, AnisotropicFiltering> =
        MethodStringName0<Viewport, AnisotropicFiltering>("get_anisotropic_filtering_level")

    @JvmField
    public val setVrsModeName: MethodStringName1<Viewport, Unit, VRSMode> =
        MethodStringName1<Viewport, Unit, VRSMode>("set_vrs_mode")

    @JvmField
    public val getVrsModeName: MethodStringName0<Viewport, VRSMode> =
        MethodStringName0<Viewport, VRSMode>("get_vrs_mode")

    @JvmField
    public val setVrsUpdateModeName: MethodStringName1<Viewport, Unit, VRSUpdateMode> =
        MethodStringName1<Viewport, Unit, VRSUpdateMode>("set_vrs_update_mode")

    @JvmField
    public val getVrsUpdateModeName: MethodStringName0<Viewport, VRSUpdateMode> =
        MethodStringName0<Viewport, VRSUpdateMode>("get_vrs_update_mode")

    @JvmField
    public val setVrsTextureName: MethodStringName1<Viewport, Unit, Texture2D?> =
        MethodStringName1<Viewport, Unit, Texture2D?>("set_vrs_texture")

    @JvmField
    public val getVrsTextureName: MethodStringName0<Viewport, Texture2D?> =
        MethodStringName0<Viewport, Texture2D?>("get_vrs_texture")
  }

  public object MethodBindings {
    internal val setWorld2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_world_2d", 2736080068)

    internal val getWorld2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_world_2d", 2339128592)

    internal val findWorld2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "find_world_2d", 2339128592)

    internal val setCanvasTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_canvas_transform", 2761652528)

    internal val getCanvasTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_canvas_transform", 3814499831)

    internal val setGlobalCanvasTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_global_canvas_transform", 2761652528)

    internal val getGlobalCanvasTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_global_canvas_transform", 3814499831)

    internal val getStretchTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_stretch_transform", 3814499831)

    internal val getFinalTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_final_transform", 3814499831)

    internal val getScreenTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_screen_transform", 3814499831)

    internal val getVisibleRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_visible_rect", 1639390495)

    internal val setTransparentBackgroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_transparent_background", 2586408642)

    internal val hasTransparentBackgroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "has_transparent_background", 36873697)

    internal val setUseHdr2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_use_hdr_2d", 2586408642)

    internal val isUsingHdr2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_using_hdr_2d", 36873697)

    internal val setMsaa2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_msaa_2d", 3330258708)

    internal val getMsaa2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_msaa_2d", 2542055527)

    internal val setMsaa3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_msaa_3d", 3330258708)

    internal val getMsaa3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_msaa_3d", 2542055527)

    internal val setScreenSpaceAaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_screen_space_aa", 3544169389)

    internal val getScreenSpaceAaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_screen_space_aa", 1390814124)

    internal val setUseTaaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_use_taa", 2586408642)

    internal val isUsingTaaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_using_taa", 36873697)

    internal val setUseDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_use_debanding", 2586408642)

    internal val isUsingDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_using_debanding", 36873697)

    internal val setUseOcclusionCullingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_use_occlusion_culling", 2586408642)

    internal val isUsingOcclusionCullingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_using_occlusion_culling", 36873697)

    internal val setDebugDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_debug_draw", 1970246205)

    internal val getDebugDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_debug_draw", 579191299)

    internal val setUseOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_use_oversampling", 2586408642)

    internal val isUsingOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_using_oversampling", 36873697)

    internal val setOversamplingOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_oversampling_override", 373806689)

    internal val getOversamplingOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_oversampling_override", 1740695150)

    internal val getOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_oversampling", 1740695150)

    internal val getRenderInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_render_info", 481977019)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_texture", 1746695840)

    internal val setPhysicsObjectPickingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_physics_object_picking", 2586408642)

    internal val getPhysicsObjectPickingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_physics_object_picking", 2240911060)

    internal val setPhysicsObjectPickingSortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_physics_object_picking_sort", 2586408642)

    internal val getPhysicsObjectPickingSortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_physics_object_picking_sort", 2240911060)

    internal val setPhysicsObjectPickingFirstOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_physics_object_picking_first_only", 2586408642)

    internal val getPhysicsObjectPickingFirstOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_physics_object_picking_first_only", 2240911060)

    internal val getViewportRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_viewport_rid", 2944877500)

    internal val pushTextInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "push_text_input", 83702148)

    internal val pushInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "push_input", 3644664830)

    internal val pushUnhandledInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "push_unhandled_input", 3644664830)

    internal val notifyMouseEnteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "notify_mouse_entered", 3218959716)

    internal val notifyMouseExitedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "notify_mouse_exited", 3218959716)

    internal val getMousePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_mouse_position", 3341600327)

    internal val warpMousePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "warp_mouse", 743155724)

    internal val updateMouseCursorStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "update_mouse_cursor_state", 3218959716)

    internal val guiCancelDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_cancel_drag", 3218959716)

    internal val guiGetDragDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_get_drag_data", 1214101251)

    internal val guiGetDragDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_get_drag_description", 201670096)

    internal val guiSetDragDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_set_drag_description", 83702148)

    internal val guiIsDraggingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_is_dragging", 36873697)

    internal val guiIsDragSuccessfulPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_is_drag_successful", 36873697)

    internal val guiReleaseFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_release_focus", 3218959716)

    internal val guiGetFocusOwnerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_get_focus_owner", 2783021301)

    internal val guiGetHoveredControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "gui_get_hovered_control", 2783021301)

    internal val setDisableInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_disable_input", 2586408642)

    internal val isInputDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_input_disabled", 36873697)

    internal val setPositionalShadowAtlasSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_positional_shadow_atlas_size", 1286410249)

    internal val getPositionalShadowAtlasSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_positional_shadow_atlas_size", 3905245786)

    internal val setPositionalShadowAtlas16BitsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_positional_shadow_atlas_16_bits", 2586408642)

    internal val getPositionalShadowAtlas16BitsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_positional_shadow_atlas_16_bits", 36873697)

    internal val setSnapControlsToPixelsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_snap_controls_to_pixels", 2586408642)

    internal val isSnapControlsToPixelsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_snap_controls_to_pixels_enabled", 36873697)

    internal val setSnap2dTransformsToPixelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_snap_2d_transforms_to_pixel", 2586408642)

    internal val isSnap2dTransformsToPixelEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_snap_2d_transforms_to_pixel_enabled", 36873697)

    internal val setSnap2dVerticesToPixelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_snap_2d_vertices_to_pixel", 2586408642)

    internal val isSnap2dVerticesToPixelEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_snap_2d_vertices_to_pixel_enabled", 36873697)

    internal val setPositionalShadowAtlasQuadrantSubdivPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_positional_shadow_atlas_quadrant_subdiv", 2596956071)

    internal val getPositionalShadowAtlasQuadrantSubdivPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_positional_shadow_atlas_quadrant_subdiv", 2676778355)

    internal val setInputAsHandledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_input_as_handled", 3218959716)

    internal val isInputHandledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_input_handled", 36873697)

    internal val setHandleInputLocallyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_handle_input_locally", 2586408642)

    internal val isHandlingInputLocallyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_handling_input_locally", 36873697)

    internal val setDefaultCanvasItemTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_default_canvas_item_texture_filter", 2815160100)

    internal val getDefaultCanvasItemTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_default_canvas_item_texture_filter", 896601198)

    internal val setEmbeddingSubwindowsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_embedding_subwindows", 2586408642)

    internal val isEmbeddingSubwindowsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_embedding_subwindows", 36873697)

    internal val getEmbeddedSubwindowsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_embedded_subwindows", 3995934104)

    internal val setDragThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_drag_threshold", 1286410249)

    internal val getDragThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_drag_threshold", 3905245786)

    internal val setCanvasCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_canvas_cull_mask", 1286410249)

    internal val getCanvasCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_canvas_cull_mask", 3905245786)

    internal val setCanvasCullMaskBitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_canvas_cull_mask_bit", 300928843)

    internal val getCanvasCullMaskBitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_canvas_cull_mask_bit", 1116898809)

    internal val setDefaultCanvasItemTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_default_canvas_item_texture_repeat", 1658513413)

    internal val getDefaultCanvasItemTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_default_canvas_item_texture_repeat", 4049774160)

    internal val setSdfOversizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_sdf_oversize", 2574159017)

    internal val getSdfOversizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_sdf_oversize", 2631427510)

    internal val setSdfScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_sdf_scale", 1402773951)

    internal val getSdfScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_sdf_scale", 3162688184)

    internal val setMeshLodThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_mesh_lod_threshold", 373806689)

    internal val getMeshLodThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_mesh_lod_threshold", 1740695150)

    internal val setAsAudioListener2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_as_audio_listener_2d", 2586408642)

    internal val isAudioListener2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_audio_listener_2d", 36873697)

    internal val getAudioListener2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_audio_listener_2d", 1840977180)

    internal val getCamera2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_camera_2d", 3551466917)

    internal val setWorld3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_world_3d", 1400875337)

    internal val getWorld3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_world_3d", 317588385)

    internal val findWorld3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "find_world_3d", 317588385)

    internal val setUseOwnWorld3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_use_own_world_3d", 2586408642)

    internal val isUsingOwnWorld3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_using_own_world_3d", 36873697)

    internal val getAudioListener3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_audio_listener_3d", 3472246991)

    internal val getCamera3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_camera_3d", 2285090890)

    internal val setAsAudioListener3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_as_audio_listener_3d", 2586408642)

    internal val isAudioListener3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_audio_listener_3d", 36873697)

    internal val setDisable3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_disable_3d", 2586408642)

    internal val is3dDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_3d_disabled", 36873697)

    internal val setUseXrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_use_xr", 2586408642)

    internal val isUsingXrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "is_using_xr", 36873697)

    internal val setScaling3dModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_scaling_3d_mode", 1531597597)

    internal val getScaling3dModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_scaling_3d_mode", 2597660574)

    internal val setScaling3dScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_scaling_3d_scale", 373806689)

    internal val getScaling3dScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_scaling_3d_scale", 1740695150)

    internal val setFsrSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_fsr_sharpness", 373806689)

    internal val getFsrSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_fsr_sharpness", 1740695150)

    internal val setTextureMipmapBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_texture_mipmap_bias", 373806689)

    internal val getTextureMipmapBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_texture_mipmap_bias", 1740695150)

    internal val setAnisotropicFilteringLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_anisotropic_filtering_level", 3445583046)

    internal val getAnisotropicFilteringLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_anisotropic_filtering_level", 3991528932)

    internal val setVrsModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_vrs_mode", 2749867817)

    internal val getVrsModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_vrs_mode", 349660525)

    internal val setVrsUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_vrs_update_mode", 3182412319)

    internal val getVrsUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_vrs_update_mode", 2255951583)

    internal val setVrsTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "set_vrs_texture", 4051416890)

    internal val getVrsTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Viewport", "get_vrs_texture", 3635182373)
  }
}
