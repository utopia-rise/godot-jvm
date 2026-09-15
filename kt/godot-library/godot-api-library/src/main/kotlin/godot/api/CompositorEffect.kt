// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This resource defines a custom rendering effect that can be applied to [Viewport]s through the
 * viewports' [Environment]. You can implement a callback that is called during rendering at a given
 * stage of the rendering pipeline and allows you to insert additional passes. Note that this callback
 * happens on the rendering thread. CompositorEffect is an abstract base class and must be extended to
 * implement specific rendering logic.
 */
@GodotBaseType
public open class CompositorEffect : Resource() {
  /**
   * If `true` this rendering effect is applied to any viewport it is added to.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = getEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * The type of effect that is implemented, determines at what stage of rendering the callback is
   * called.
   */
  public final inline var effectCallbackType: EffectCallbackType
    @JvmName("effectCallbackTypeProperty")
    get() = getEffectCallbackType()
    @JvmName("effectCallbackTypeProperty")
    set(`value`) {
      setEffectCallbackType(value)
    }

  /**
   * If `true` and MSAA is enabled, this will trigger a color buffer resolve before the effect is
   * run.
   *
   * **Note:** In [_renderCallback], to access the resolved buffer use:
   *
   * ```
   * var render_scene_buffers = render_data.get_render_scene_buffers()
   * var color_buffer = render_scene_buffers.get_texture("render_buffers", "color")
   * ```
   */
  public final inline var accessResolvedColor: Boolean
    @JvmName("accessResolvedColorProperty")
    get() = getAccessResolvedColor()
    @JvmName("accessResolvedColorProperty")
    set(`value`) {
      setAccessResolvedColor(value)
    }

  /**
   * If `true` and MSAA is enabled, this will trigger a depth buffer resolve before the effect is
   * run.
   *
   * **Note:** In [_renderCallback], to access the resolved buffer use:
   *
   * ```
   * var render_scene_buffers = render_data.get_render_scene_buffers()
   * var depth_buffer = render_scene_buffers.get_texture("render_buffers", "depth")
   * ```
   */
  public final inline var accessResolvedDepth: Boolean
    @JvmName("accessResolvedDepthProperty")
    get() = getAccessResolvedDepth()
    @JvmName("accessResolvedDepthProperty")
    set(`value`) {
      setAccessResolvedDepth(value)
    }

  /**
   * If `true` this triggers motion vectors being calculated during the opaque render state.
   *
   * **Note:** In [_renderCallback], to access the motion vector buffer use:
   *
   * ```
   * var render_scene_buffers = render_data.get_render_scene_buffers()
   * var motion_buffer = render_scene_buffers.get_velocity_texture()
   * ```
   */
  public final inline var needsMotionVectors: Boolean
    @JvmName("needsMotionVectorsProperty")
    get() = getNeedsMotionVectors()
    @JvmName("needsMotionVectorsProperty")
    set(`value`) {
      setNeedsMotionVectors(value)
    }

  /**
   * If `true` this triggers normal and roughness data to be output during our depth pre-pass, only
   * applicable for the Forward+ renderer.
   *
   * **Note:** In [_renderCallback], to access the roughness buffer use:
   *
   * ```
   * var render_scene_buffers = render_data.get_render_scene_buffers()
   * var roughness_buffer = render_scene_buffers.get_texture("forward_clustered",
   * "normal_roughness")
   * ```
   *
   * The raw normal and roughness buffer is stored in an optimized format, different than the one
   * available in Spatial shaders. When sampling the buffer, a conversion function must be applied. Use
   * this function, copied from
   * [url=https://github.com/godotengine/godot/blob/da5f39889f155658cef7f7ec3cc1abb94e17d815/servers/rendering/renderer_rd/shaders/forward_clustered/scene_forward_clustered_inc.glsl#L334-L341]here[/url]:
   *
   * ```
   * vec4 normal_roughness_compatibility(vec4 p_normal_roughness) {
   * 	float roughness = p_normal_roughness.w;
   * 	if (roughness > 0.5) {
   * 		roughness = 1.0 - roughness;
   * 	}
   * 	roughness /= (127.0 / 255.0);
   * 	return vec4(normalize(p_normal_roughness.xyz * 2.0 - 1.0) * 0.5 + 0.5, roughness);
   * }
   * ```
   */
  public final inline var needsNormalRoughness: Boolean
    @JvmName("needsNormalRoughnessProperty")
    get() = getNeedsNormalRoughness()
    @JvmName("needsNormalRoughnessProperty")
    set(`value`) {
      setNeedsNormalRoughness(value)
    }

  /**
   * If `true` this triggers specular data being rendered to a separate buffer and combined after
   * effects have been applied, only applicable for the Forward+ renderer.
   */
  public final inline var needsSeparateSpecular: Boolean
    @JvmName("needsSeparateSpecularProperty")
    get() = getNeedsSeparateSpecular()
    @JvmName("needsSeparateSpecularProperty")
    set(`value`) {
      setNeedsSeparateSpecular(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(172, scriptPtr)
  }

  /**
   * Implement this function with your custom rendering code. [effectCallbackType] should always
   * match the effect callback type you've specified in [effectCallbackType]. [renderData] provides
   * access to the rendering state, it is only valid during rendering and should not be stored.
   */
  public open fun _renderCallback(effectCallbackType: Int, renderData: RenderData?): Unit {
    throw NotImplementedError("CompositorEffect::_renderCallback is not implemented.")
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setEnabledPtr, 0)
  }

  public final fun getEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEffectCallbackType(effectCallbackType: EffectCallbackType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, effectCallbackType.value)
    TransferContext.callPtrMethod(MethodBindings.setEffectCallbackTypePtr, 0)
  }

  public final fun getEffectCallbackType(): EffectCallbackType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEffectCallbackTypePtr, 2)
    return EffectCallbackType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setAccessResolvedColor(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setAccessResolvedColorPtr, 0)
  }

  public final fun getAccessResolvedColor(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAccessResolvedColorPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAccessResolvedDepth(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setAccessResolvedDepthPtr, 0)
  }

  public final fun getAccessResolvedDepth(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAccessResolvedDepthPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setNeedsMotionVectors(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setNeedsMotionVectorsPtr, 0)
  }

  public final fun getNeedsMotionVectors(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNeedsMotionVectorsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setNeedsNormalRoughness(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setNeedsNormalRoughnessPtr, 0)
  }

  public final fun getNeedsNormalRoughness(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNeedsNormalRoughnessPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setNeedsSeparateSpecular(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setNeedsSeparateSpecularPtr, 0)
  }

  public final fun getNeedsSeparateSpecular(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNeedsSeparateSpecularPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class EffectCallbackType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The callback is called before our opaque rendering pass, but after depth prepass (if
     * applicable).
     */
    PRE_OPAQUE(0),
    /**
     * The callback is called after our opaque rendering pass, but before our sky is rendered.
     */
    POST_OPAQUE(1),
    /**
     * The callback is called after our sky is rendered, but before our back buffers are created
     * (and if enabled, before subsurface scattering and/or screen space reflections).
     */
    POST_SKY(2),
    /**
     * The callback is called before our transparent rendering pass, but after our sky is rendered
     * and we've created our back buffers.
     */
    PRE_TRANSPARENT(3),
    /**
     * The callback is called after our transparent rendering pass, but before any built-in
     * post-processing effects and output to our render target.
     */
    POST_TRANSPARENT(4),
    /**
     * Represents the size of the [EffectCallbackType] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): EffectCallbackType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setEnabledName: MethodStringName1<CompositorEffect, Unit, Boolean> =
        MethodStringName1<CompositorEffect, Unit, Boolean>("set_enabled")

    @JvmField
    public val getEnabledName: MethodStringName0<CompositorEffect, Boolean> =
        MethodStringName0<CompositorEffect, Boolean>("get_enabled")

    @JvmField
    public val setEffectCallbackTypeName:
        MethodStringName1<CompositorEffect, Unit, EffectCallbackType> =
        MethodStringName1<CompositorEffect, Unit, EffectCallbackType>("set_effect_callback_type")

    @JvmField
    public val getEffectCallbackTypeName: MethodStringName0<CompositorEffect, EffectCallbackType> =
        MethodStringName0<CompositorEffect, EffectCallbackType>("get_effect_callback_type")

    @JvmField
    public val setAccessResolvedColorName: MethodStringName1<CompositorEffect, Unit, Boolean> =
        MethodStringName1<CompositorEffect, Unit, Boolean>("set_access_resolved_color")

    @JvmField
    public val getAccessResolvedColorName: MethodStringName0<CompositorEffect, Boolean> =
        MethodStringName0<CompositorEffect, Boolean>("get_access_resolved_color")

    @JvmField
    public val setAccessResolvedDepthName: MethodStringName1<CompositorEffect, Unit, Boolean> =
        MethodStringName1<CompositorEffect, Unit, Boolean>("set_access_resolved_depth")

    @JvmField
    public val getAccessResolvedDepthName: MethodStringName0<CompositorEffect, Boolean> =
        MethodStringName0<CompositorEffect, Boolean>("get_access_resolved_depth")

    @JvmField
    public val setNeedsMotionVectorsName: MethodStringName1<CompositorEffect, Unit, Boolean> =
        MethodStringName1<CompositorEffect, Unit, Boolean>("set_needs_motion_vectors")

    @JvmField
    public val getNeedsMotionVectorsName: MethodStringName0<CompositorEffect, Boolean> =
        MethodStringName0<CompositorEffect, Boolean>("get_needs_motion_vectors")

    @JvmField
    public val setNeedsNormalRoughnessName: MethodStringName1<CompositorEffect, Unit, Boolean> =
        MethodStringName1<CompositorEffect, Unit, Boolean>("set_needs_normal_roughness")

    @JvmField
    public val getNeedsNormalRoughnessName: MethodStringName0<CompositorEffect, Boolean> =
        MethodStringName0<CompositorEffect, Boolean>("get_needs_normal_roughness")

    @JvmField
    public val setNeedsSeparateSpecularName: MethodStringName1<CompositorEffect, Unit, Boolean> =
        MethodStringName1<CompositorEffect, Unit, Boolean>("set_needs_separate_specular")

    @JvmField
    public val getNeedsSeparateSpecularName: MethodStringName0<CompositorEffect, Boolean> =
        MethodStringName0<CompositorEffect, Boolean>("get_needs_separate_specular")
  }

  public object MethodBindings {
    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "set_enabled", 2586408642)

    internal val getEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "get_enabled", 36873697)

    internal val setEffectCallbackTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "set_effect_callback_type", 1390728419)

    internal val getEffectCallbackTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "get_effect_callback_type", 1221912590)

    internal val setAccessResolvedColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "set_access_resolved_color", 2586408642)

    internal val getAccessResolvedColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "get_access_resolved_color", 36873697)

    internal val setAccessResolvedDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "set_access_resolved_depth", 2586408642)

    internal val getAccessResolvedDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "get_access_resolved_depth", 36873697)

    internal val setNeedsMotionVectorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "set_needs_motion_vectors", 2586408642)

    internal val getNeedsMotionVectorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "get_needs_motion_vectors", 36873697)

    internal val setNeedsNormalRoughnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "set_needs_normal_roughness", 2586408642)

    internal val getNeedsNormalRoughnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "get_needs_normal_roughness", 36873697)

    internal val setNeedsSeparateSpecularPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "set_needs_separate_specular", 2586408642)

    internal val getNeedsSeparateSpecularPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CompositorEffect", "get_needs_separate_specular", 36873697)
  }
}
