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
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_COLOR
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_VECTOR2I
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_COLOR
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_VECTOR2I
import godot.callPtrMethod_VECTOR3_VECTOR3_ret_VECTOR2
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Composition layers allow 2D viewports to be displayed inside of the headset by the XR compositor
 * through special projections that retain their quality. This allows for rendering clear text while
 * keeping the layer at a native resolution.
 *
 * **Note:** If the OpenXR runtime doesn't support the given composition layer type, a fallback mesh
 * can be generated with a [ViewportTexture], in order to emulate the composition layer.
 */
@GodotBaseType
public open class OpenXRCompositionLayer internal constructor() : Node3D() {
  /**
   * The [SubViewport] to render on the composition layer.
   */
  public final inline var layerViewport: SubViewport?
    @JvmName("layerViewportProperty")
    get() = getLayerViewport()
    @JvmName("layerViewportProperty")
    set(`value`) {
      setLayerViewport(value)
    }

  /**
   * If enabled, an Android surface will be created (with the dimensions from [androidSurfaceSize])
   * which will provide the 2D content for the composition layer, rather than using [layerViewport].
   *
   * See [getAndroidSurface] for information about how to get the surface so that your application
   * can draw to it.
   *
   * **Note:** This will only work in Android builds.
   */
  public final inline var useAndroidSurface: Boolean
    @JvmName("useAndroidSurfaceProperty")
    get() = getUseAndroidSurface()
    @JvmName("useAndroidSurfaceProperty")
    set(`value`) {
      setUseAndroidSurface(value)
    }

  /**
   * If enabled, the OpenXR swapchain will be created with the
   * `XR_SWAPCHAIN_CREATE_PROTECTED_CONTENT_BIT` flag, which will protect its contents from CPU access.
   *
   * When used with an Android Surface, this may allow DRM content to be presented, and will only
   * take effect when the Surface is first created; later changes to this property will have no effect.
   */
  public final inline var protectedContent: Boolean
    @JvmName("protectedContentProperty")
    get() = isProtectedContent()
    @JvmName("protectedContentProperty")
    set(`value`) {
      setProtectedContent(value)
    }

  /**
   * The size of the Android surface to create if [useAndroidSurface] is enabled.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var androidSurfaceSize: Vector2i
    @JvmName("androidSurfaceSizeProperty")
    get() = getAndroidSurfaceSize()
    @JvmName("androidSurfaceSizeProperty")
    set(`value`) {
      setAndroidSurfaceSize(value)
    }

  /**
   * The sort order for this composition layer. Higher numbers will be shown in front of lower
   * numbers.
   *
   * **Note:** This will have no effect if a fallback mesh is being used.
   */
  public final inline var sortOrder: Int
    @JvmName("sortOrderProperty")
    get() = getSortOrder()
    @JvmName("sortOrderProperty")
    set(`value`) {
      setSortOrder(value)
    }

  /**
   * Enables the blending the layer using its alpha channel.
   *
   * Can be combined with [Viewport.transparentBg] to give the layer a transparent background.
   */
  public final inline var alphaBlend: Boolean
    @JvmName("alphaBlendProperty")
    get() = getAlphaBlend()
    @JvmName("alphaBlendProperty")
    set(`value`) {
      setAlphaBlend(value)
    }

  /**
   * Enables a technique called "hole punching", which allows putting the composition layer behind
   * the main projection layer (i.e. setting [sortOrder] to a negative value) while "punching a hole"
   * through everything rendered by Godot so that the layer is still visible.
   *
   * This can be used to create the illusion that the composition layer exists in the same 3D space
   * as everything rendered by Godot, allowing objects to appear to pass both behind or in front of the
   * composition layer.
   */
  public final inline var enableHolePunch: Boolean
    @JvmName("enableHolePunchProperty")
    get() = getEnableHolePunch()
    @JvmName("enableHolePunchProperty")
    set(`value`) {
      setEnableHolePunch(value)
    }

  /**
   * The eye(s) the composition layer is visible to.
   *
   * **Note:** Not all composition layer types or runtimes support restricting visibility to a
   * single eye.
   */
  public final inline var eyeVisibility: EyeVisibility
    @JvmName("eyeVisibilityProperty")
    get() = getEyeVisibility()
    @JvmName("eyeVisibilityProperty")
    set(`value`) {
      setEyeVisibility(value)
    }

  /**
   * The minification filter of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateMinFilter: Filter
    @JvmName("swapchainStateMinFilterProperty")
    get() = getMinFilter()
    @JvmName("swapchainStateMinFilterProperty")
    set(`value`) {
      setMinFilter(value)
    }

  /**
   * The magnification filter of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateMagFilter: Filter
    @JvmName("swapchainStateMagFilterProperty")
    get() = getMagFilter()
    @JvmName("swapchainStateMagFilterProperty")
    set(`value`) {
      setMagFilter(value)
    }

  /**
   * The mipmap mode of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateMipmapMode: MipmapMode
    @JvmName("swapchainStateMipmapModeProperty")
    get() = getMipmapMode()
    @JvmName("swapchainStateMipmapModeProperty")
    set(`value`) {
      setMipmapMode(value)
    }

  /**
   * The horizontal wrap mode of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateHorizontalWrap: Wrap
    @JvmName("swapchainStateHorizontalWrapProperty")
    get() = getHorizontalWrap()
    @JvmName("swapchainStateHorizontalWrapProperty")
    set(`value`) {
      setHorizontalWrap(value)
    }

  /**
   * The vertical wrap mode of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateVerticalWrap: Wrap
    @JvmName("swapchainStateVerticalWrapProperty")
    get() = getVerticalWrap()
    @JvmName("swapchainStateVerticalWrapProperty")
    set(`value`) {
      setVerticalWrap(value)
    }

  /**
   * The swizzle value for the red channel of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateRedSwizzle: Swizzle
    @JvmName("swapchainStateRedSwizzleProperty")
    get() = getRedSwizzle()
    @JvmName("swapchainStateRedSwizzleProperty")
    set(`value`) {
      setRedSwizzle(value)
    }

  /**
   * The swizzle value for the green channel of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateGreenSwizzle: Swizzle
    @JvmName("swapchainStateGreenSwizzleProperty")
    get() = getGreenSwizzle()
    @JvmName("swapchainStateGreenSwizzleProperty")
    set(`value`) {
      setGreenSwizzle(value)
    }

  /**
   * The swizzle value for the blue channel of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateBlueSwizzle: Swizzle
    @JvmName("swapchainStateBlueSwizzleProperty")
    get() = getBlueSwizzle()
    @JvmName("swapchainStateBlueSwizzleProperty")
    set(`value`) {
      setBlueSwizzle(value)
    }

  /**
   * The swizzle value for the alpha channel of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateAlphaSwizzle: Swizzle
    @JvmName("swapchainStateAlphaSwizzleProperty")
    get() = getAlphaSwizzle()
    @JvmName("swapchainStateAlphaSwizzleProperty")
    set(`value`) {
      setAlphaSwizzle(value)
    }

  /**
   * The max anisotropy of the swapchain state.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  public final inline var swapchainStateMaxAnisotropy: Float
    @JvmName("swapchainStateMaxAnisotropyProperty")
    get() = getMaxAnisotropy()
    @JvmName("swapchainStateMaxAnisotropyProperty")
    set(`value`) {
      setMaxAnisotropy(value)
    }

  /**
   * The border color of the swapchain state that is used when the wrap mode clamps to the border.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var swapchainStateBorderColor: Color
    @JvmName("swapchainStateBorderColorProperty")
    get() = getBorderColor()
    @JvmName("swapchainStateBorderColorProperty")
    set(`value`) {
      setBorderColor(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(445, scriptPtr)
  }

  /**
   * This is a helper function for [androidSurfaceSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = openxrcompositionlayer.androidSurfaceSize
   * //Your changes
   * openxrcompositionlayer.androidSurfaceSize = myCoreType
   * ``````
   *
   * The size of the Android surface to create if [useAndroidSurface] is enabled.
   */
  @CoreTypeHelper
  public final fun androidSurfaceSizeMutate(block: Vector2i.() -> Unit): Vector2i =
      androidSurfaceSize.apply {
     block(this)
     androidSurfaceSize = this
  }

  /**
   * This is a helper function for [swapchainStateBorderColor] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = openxrcompositionlayer.swapchainStateBorderColor
   * //Your changes
   * openxrcompositionlayer.swapchainStateBorderColor = myCoreType
   * ``````
   *
   * The border color of the swapchain state that is used when the wrap mode clamps to the border.
   *
   * **Note:** This property only has an effect on devices that support the OpenXR
   * XR_FB_swapchain_update_state OpenGLES/Vulkan extensions.
   */
  @CoreTypeHelper
  public final fun swapchainStateBorderColorMutate(block: Color.() -> Unit): Color =
      swapchainStateBorderColor.apply {
     block(this)
     swapchainStateBorderColor = this
  }

  public final fun setLayerViewport(viewport: SubViewport?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setLayerViewportPtr, viewport)
  }

  public final fun getLayerViewport(): SubViewport? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getLayerViewportPtr) as SubViewport?)

  public final fun setUseAndroidSurface(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setUseAndroidSurfacePtr, enable)
  }

  public final fun getUseAndroidSurface(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getUseAndroidSurfacePtr)

  public final fun setAndroidSurfaceSize(size: Vector2i): Unit {
    TransferContext.callPtrMethod_VECTOR2I(ptr, objectID.id, MethodBindings.setAndroidSurfaceSizePtr, size)
  }

  public final fun getAndroidSurfaceSize(): Vector2i =
      TransferContext.callPtrMethod0_ret_VECTOR2I(ptr, objectID.id, MethodBindings.getAndroidSurfaceSizePtr)

  public final fun setEnableHolePunch(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableHolePunchPtr, enable)
  }

  public final fun getEnableHolePunch(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableHolePunchPtr)

  public final fun setSortOrder(order: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSortOrderPtr, order.toLong())
  }

  public final fun getSortOrder(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSortOrderPtr).toInt()

  public final fun setAlphaBlend(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAlphaBlendPtr, enabled)
  }

  public final fun getAlphaBlend(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getAlphaBlendPtr)

  /**
   * Returns a [JavaObject] representing an `android.view.Surface` if [useAndroidSurface] is enabled
   * and OpenXR has created the surface. Otherwise, this will return `null`.
   *
   * **Note:** The surface can only be created during an active OpenXR session. So, if
   * [useAndroidSurface] is enabled outside of an OpenXR session, it won't be created until a new
   * session fully starts.
   */
  public final fun getAndroidSurface(): JavaObject? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getAndroidSurfacePtr) as JavaObject?)

  /**
   * Returns `true` if the OpenXR runtime natively supports this composition layer type.
   *
   * **Note:** This will only return an accurate result after the OpenXR session has started.
   */
  public final fun isNativelySupported(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isNativelySupportedPtr)

  public final fun isProtectedContent(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isProtectedContentPtr)

  public final fun setProtectedContent(protectedContent: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setProtectedContentPtr, protectedContent)
  }

  public final fun setMinFilter(mode: Filter): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setMinFilterPtr, mode.value)
  }

  public final fun getMinFilter(): Filter =
      Filter.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getMinFilterPtr))

  public final fun setMagFilter(mode: Filter): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setMagFilterPtr, mode.value)
  }

  public final fun getMagFilter(): Filter =
      Filter.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getMagFilterPtr))

  public final fun setMipmapMode(mode: MipmapMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setMipmapModePtr, mode.value)
  }

  public final fun getMipmapMode(): MipmapMode =
      MipmapMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getMipmapModePtr))

  public final fun setHorizontalWrap(mode: Wrap): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setHorizontalWrapPtr, mode.value)
  }

  public final fun getHorizontalWrap(): Wrap =
      Wrap.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getHorizontalWrapPtr))

  public final fun setVerticalWrap(mode: Wrap): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVerticalWrapPtr, mode.value)
  }

  public final fun getVerticalWrap(): Wrap =
      Wrap.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVerticalWrapPtr))

  public final fun setRedSwizzle(mode: Swizzle): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setRedSwizzlePtr, mode.value)
  }

  public final fun getRedSwizzle(): Swizzle =
      Swizzle.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getRedSwizzlePtr))

  public final fun setGreenSwizzle(mode: Swizzle): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setGreenSwizzlePtr, mode.value)
  }

  public final fun getGreenSwizzle(): Swizzle =
      Swizzle.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getGreenSwizzlePtr))

  public final fun setBlueSwizzle(mode: Swizzle): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBlueSwizzlePtr, mode.value)
  }

  public final fun getBlueSwizzle(): Swizzle =
      Swizzle.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBlueSwizzlePtr))

  public final fun setAlphaSwizzle(mode: Swizzle): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAlphaSwizzlePtr, mode.value)
  }

  public final fun getAlphaSwizzle(): Swizzle =
      Swizzle.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAlphaSwizzlePtr))

  public final fun setMaxAnisotropy(`value`: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setMaxAnisotropyPtr, value.toDouble())
  }

  public final fun getMaxAnisotropy(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getMaxAnisotropyPtr).toFloat()

  public final fun setBorderColor(color: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.setBorderColorPtr, color)
  }

  public final fun getBorderColor(): Color =
      TransferContext.callPtrMethod0_ret_COLOR(ptr, objectID.id, MethodBindings.getBorderColorPtr)

  public final fun setEyeVisibility(eyeVisibility: EyeVisibility): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setEyeVisibilityPtr, eyeVisibility.value)
  }

  public final fun getEyeVisibility(): EyeVisibility =
      EyeVisibility.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getEyeVisibilityPtr))

  /**
   * Returns UV coordinates where the given ray intersects with the composition layer. [origin] and
   * [direction] must be in global space.
   *
   * Returns `Vector2(-1.0, -1.0)` if the ray doesn't intersect.
   */
  public final fun intersectsRay(origin: Vector3, direction: Vector3): Vector2 =
      TransferContext.callPtrMethod_VECTOR3_VECTOR3_ret_VECTOR2(ptr, objectID.id, MethodBindings.intersectsRayPtr, origin, direction)

  public enum class Filter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Perform nearest-neighbor filtering when sampling the texture.
     */
    NEAREST(0),
    /**
     * Perform linear filtering when sampling the texture.
     */
    LINEAR(1),
    /**
     * Perform cubic filtering when sampling the texture.
     */
    CUBIC(2),
    ;

    public companion object {
      public fun from(`value`: Long): Filter = entries.single { it.`value` == `value` }
    }
  }

  public enum class MipmapMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disable mipmapping.
     *
     * **Note:** Mipmapping can only be disabled in the Compatibility renderer.
     */
    DISABLED(0),
    /**
     * Use the mipmap of the nearest resolution.
     */
    NEAREST(1),
    /**
     * Use linear interpolation of the two mipmaps of the nearest resolution.
     */
    LINEAR(2),
    ;

    public companion object {
      public fun from(`value`: Long): MipmapMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class Wrap(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Clamp the texture to its specified border color.
     */
    CLAMP_TO_BORDER(0),
    /**
     * Clamp the texture to its edge color.
     */
    CLAMP_TO_EDGE(1),
    /**
     * Repeat the texture infinitely.
     */
    REPEAT(2),
    /**
     * Repeat the texture infinitely, mirroring it on each repeat.
     */
    MIRRORED_REPEAT(3),
    /**
     * Mirror the texture once and then clamp the texture to its edge color.
     *
     * **Note:** This wrap mode is not available in the Compatibility renderer.
     */
    MIRROR_CLAMP_TO_EDGE(4),
    ;

    public companion object {
      public fun from(`value`: Long): Wrap = entries.single { it.`value` == `value` }
    }
  }

  public enum class Swizzle(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Maps a color channel to the value of the red channel.
     */
    RED(0),
    /**
     * Maps a color channel to the value of the green channel.
     */
    GREEN(1),
    /**
     * Maps a color channel to the value of the blue channel.
     */
    BLUE(2),
    /**
     * Maps a color channel to the value of the alpha channel.
     */
    ALPHA(3),
    /**
     * Maps a color channel to the value of zero.
     */
    ZERO(4),
    /**
     * Maps a color channel to the value of one.
     */
    ONE(5),
    ;

    public companion object {
      public fun from(`value`: Long): Swizzle = entries.single { it.`value` == `value` }
    }
  }

  public enum class EyeVisibility(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The layer is visible to both the left and right eyes.
     */
    BOTH(0),
    /**
     * The layer is visible only to the left eye.
     */
    LEFT(1),
    /**
     * The layer is visible only to the right eye.
     */
    RIGHT(2),
    ;

    public companion object {
      public fun from(`value`: Long): EyeVisibility = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setLayerViewportName: MethodStringName1<OpenXRCompositionLayer, Unit, SubViewport?> =
        MethodStringName1<OpenXRCompositionLayer, Unit, SubViewport?>("set_layer_viewport")

    @JvmField
    public val getLayerViewportName: MethodStringName0<OpenXRCompositionLayer, SubViewport?> =
        MethodStringName0<OpenXRCompositionLayer, SubViewport?>("get_layer_viewport")

    @JvmField
    public val setUseAndroidSurfaceName: MethodStringName1<OpenXRCompositionLayer, Unit, Boolean> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Boolean>("set_use_android_surface")

    @JvmField
    public val getUseAndroidSurfaceName: MethodStringName0<OpenXRCompositionLayer, Boolean> =
        MethodStringName0<OpenXRCompositionLayer, Boolean>("get_use_android_surface")

    @JvmField
    public val setAndroidSurfaceSizeName: MethodStringName1<OpenXRCompositionLayer, Unit, Vector2i>
        = MethodStringName1<OpenXRCompositionLayer, Unit, Vector2i>("set_android_surface_size")

    @JvmField
    public val getAndroidSurfaceSizeName: MethodStringName0<OpenXRCompositionLayer, Vector2i> =
        MethodStringName0<OpenXRCompositionLayer, Vector2i>("get_android_surface_size")

    @JvmField
    public val setEnableHolePunchName: MethodStringName1<OpenXRCompositionLayer, Unit, Boolean> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Boolean>("set_enable_hole_punch")

    @JvmField
    public val getEnableHolePunchName: MethodStringName0<OpenXRCompositionLayer, Boolean> =
        MethodStringName0<OpenXRCompositionLayer, Boolean>("get_enable_hole_punch")

    @JvmField
    public val setSortOrderName: MethodStringName1<OpenXRCompositionLayer, Unit, Int> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Int>("set_sort_order")

    @JvmField
    public val getSortOrderName: MethodStringName0<OpenXRCompositionLayer, Int> =
        MethodStringName0<OpenXRCompositionLayer, Int>("get_sort_order")

    @JvmField
    public val setAlphaBlendName: MethodStringName1<OpenXRCompositionLayer, Unit, Boolean> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Boolean>("set_alpha_blend")

    @JvmField
    public val getAlphaBlendName: MethodStringName0<OpenXRCompositionLayer, Boolean> =
        MethodStringName0<OpenXRCompositionLayer, Boolean>("get_alpha_blend")

    @JvmField
    public val getAndroidSurfaceName: MethodStringName0<OpenXRCompositionLayer, JavaObject?> =
        MethodStringName0<OpenXRCompositionLayer, JavaObject?>("get_android_surface")

    @JvmField
    public val isNativelySupportedName: MethodStringName0<OpenXRCompositionLayer, Boolean> =
        MethodStringName0<OpenXRCompositionLayer, Boolean>("is_natively_supported")

    @JvmField
    public val isProtectedContentName: MethodStringName0<OpenXRCompositionLayer, Boolean> =
        MethodStringName0<OpenXRCompositionLayer, Boolean>("is_protected_content")

    @JvmField
    public val setProtectedContentName: MethodStringName1<OpenXRCompositionLayer, Unit, Boolean> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Boolean>("set_protected_content")

    @JvmField
    public val setMinFilterName: MethodStringName1<OpenXRCompositionLayer, Unit, Filter> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Filter>("set_min_filter")

    @JvmField
    public val getMinFilterName: MethodStringName0<OpenXRCompositionLayer, Filter> =
        MethodStringName0<OpenXRCompositionLayer, Filter>("get_min_filter")

    @JvmField
    public val setMagFilterName: MethodStringName1<OpenXRCompositionLayer, Unit, Filter> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Filter>("set_mag_filter")

    @JvmField
    public val getMagFilterName: MethodStringName0<OpenXRCompositionLayer, Filter> =
        MethodStringName0<OpenXRCompositionLayer, Filter>("get_mag_filter")

    @JvmField
    public val setMipmapModeName: MethodStringName1<OpenXRCompositionLayer, Unit, MipmapMode> =
        MethodStringName1<OpenXRCompositionLayer, Unit, MipmapMode>("set_mipmap_mode")

    @JvmField
    public val getMipmapModeName: MethodStringName0<OpenXRCompositionLayer, MipmapMode> =
        MethodStringName0<OpenXRCompositionLayer, MipmapMode>("get_mipmap_mode")

    @JvmField
    public val setHorizontalWrapName: MethodStringName1<OpenXRCompositionLayer, Unit, Wrap> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Wrap>("set_horizontal_wrap")

    @JvmField
    public val getHorizontalWrapName: MethodStringName0<OpenXRCompositionLayer, Wrap> =
        MethodStringName0<OpenXRCompositionLayer, Wrap>("get_horizontal_wrap")

    @JvmField
    public val setVerticalWrapName: MethodStringName1<OpenXRCompositionLayer, Unit, Wrap> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Wrap>("set_vertical_wrap")

    @JvmField
    public val getVerticalWrapName: MethodStringName0<OpenXRCompositionLayer, Wrap> =
        MethodStringName0<OpenXRCompositionLayer, Wrap>("get_vertical_wrap")

    @JvmField
    public val setRedSwizzleName: MethodStringName1<OpenXRCompositionLayer, Unit, Swizzle> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Swizzle>("set_red_swizzle")

    @JvmField
    public val getRedSwizzleName: MethodStringName0<OpenXRCompositionLayer, Swizzle> =
        MethodStringName0<OpenXRCompositionLayer, Swizzle>("get_red_swizzle")

    @JvmField
    public val setGreenSwizzleName: MethodStringName1<OpenXRCompositionLayer, Unit, Swizzle> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Swizzle>("set_green_swizzle")

    @JvmField
    public val getGreenSwizzleName: MethodStringName0<OpenXRCompositionLayer, Swizzle> =
        MethodStringName0<OpenXRCompositionLayer, Swizzle>("get_green_swizzle")

    @JvmField
    public val setBlueSwizzleName: MethodStringName1<OpenXRCompositionLayer, Unit, Swizzle> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Swizzle>("set_blue_swizzle")

    @JvmField
    public val getBlueSwizzleName: MethodStringName0<OpenXRCompositionLayer, Swizzle> =
        MethodStringName0<OpenXRCompositionLayer, Swizzle>("get_blue_swizzle")

    @JvmField
    public val setAlphaSwizzleName: MethodStringName1<OpenXRCompositionLayer, Unit, Swizzle> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Swizzle>("set_alpha_swizzle")

    @JvmField
    public val getAlphaSwizzleName: MethodStringName0<OpenXRCompositionLayer, Swizzle> =
        MethodStringName0<OpenXRCompositionLayer, Swizzle>("get_alpha_swizzle")

    @JvmField
    public val setMaxAnisotropyName: MethodStringName1<OpenXRCompositionLayer, Unit, Float> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Float>("set_max_anisotropy")

    @JvmField
    public val getMaxAnisotropyName: MethodStringName0<OpenXRCompositionLayer, Float> =
        MethodStringName0<OpenXRCompositionLayer, Float>("get_max_anisotropy")

    @JvmField
    public val setBorderColorName: MethodStringName1<OpenXRCompositionLayer, Unit, Color> =
        MethodStringName1<OpenXRCompositionLayer, Unit, Color>("set_border_color")

    @JvmField
    public val getBorderColorName: MethodStringName0<OpenXRCompositionLayer, Color> =
        MethodStringName0<OpenXRCompositionLayer, Color>("get_border_color")

    @JvmField
    public val setEyeVisibilityName: MethodStringName1<OpenXRCompositionLayer, Unit, EyeVisibility>
        = MethodStringName1<OpenXRCompositionLayer, Unit, EyeVisibility>("set_eye_visibility")

    @JvmField
    public val getEyeVisibilityName: MethodStringName0<OpenXRCompositionLayer, EyeVisibility> =
        MethodStringName0<OpenXRCompositionLayer, EyeVisibility>("get_eye_visibility")

    @JvmField
    public val intersectsRayName:
        MethodStringName2<OpenXRCompositionLayer, Vector2, Vector3, Vector3> =
        MethodStringName2<OpenXRCompositionLayer, Vector2, Vector3, Vector3>("intersects_ray")
  }

  public object MethodBindings {
    internal val setLayerViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_layer_viewport", 3888077664)

    internal val getLayerViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_layer_viewport", 3750751911)

    internal val setUseAndroidSurfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_use_android_surface", 2586408642)

    internal val getUseAndroidSurfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_use_android_surface", 36873697)

    internal val setAndroidSurfaceSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_android_surface_size", 1130785943)

    internal val getAndroidSurfaceSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_android_surface_size", 3690982128)

    internal val setEnableHolePunchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_enable_hole_punch", 2586408642)

    internal val getEnableHolePunchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_enable_hole_punch", 36873697)

    internal val setSortOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_sort_order", 1286410249)

    internal val getSortOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_sort_order", 3905245786)

    internal val setAlphaBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_alpha_blend", 2586408642)

    internal val getAlphaBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_alpha_blend", 36873697)

    internal val getAndroidSurfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_android_surface", 3277089691)

    internal val isNativelySupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "is_natively_supported", 36873697)

    internal val isProtectedContentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "is_protected_content", 36873697)

    internal val setProtectedContentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_protected_content", 2586408642)

    internal val setMinFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_min_filter", 3653437593)

    internal val getMinFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_min_filter", 845677307)

    internal val setMagFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_mag_filter", 3653437593)

    internal val getMagFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_mag_filter", 845677307)

    internal val setMipmapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_mipmap_mode", 3271133183)

    internal val getMipmapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_mipmap_mode", 3962697095)

    internal val setHorizontalWrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_horizontal_wrap", 15634990)

    internal val getHorizontalWrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_horizontal_wrap", 2798816834)

    internal val setVerticalWrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_vertical_wrap", 15634990)

    internal val getVerticalWrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_vertical_wrap", 2798816834)

    internal val setRedSwizzlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_red_swizzle", 741598951)

    internal val getRedSwizzlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_red_swizzle", 2334776767)

    internal val setGreenSwizzlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_green_swizzle", 741598951)

    internal val getGreenSwizzlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_green_swizzle", 2334776767)

    internal val setBlueSwizzlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_blue_swizzle", 741598951)

    internal val getBlueSwizzlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_blue_swizzle", 2334776767)

    internal val setAlphaSwizzlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_alpha_swizzle", 741598951)

    internal val getAlphaSwizzlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_alpha_swizzle", 2334776767)

    internal val setMaxAnisotropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_max_anisotropy", 373806689)

    internal val getMaxAnisotropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_max_anisotropy", 1740695150)

    internal val setBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_border_color", 2920490490)

    internal val getBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_border_color", 3444240500)

    internal val setEyeVisibilityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "set_eye_visibility", 156391336)

    internal val getEyeVisibilityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "get_eye_visibility", 467669000)

    internal val intersectsRayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayer", "intersects_ray", 1091262597)
  }
}
