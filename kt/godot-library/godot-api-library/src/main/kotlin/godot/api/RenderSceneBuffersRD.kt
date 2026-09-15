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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName10
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.RID
import godot.core.StringName
import godot.core.Vector2i
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.readReturnValue_VECTOR2I
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_LONG
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_LONG
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_LONG_OBJECT
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_VECTOR2I_LONG_LONG_BOOL_BOOL
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_OBJECT_OBJECT_BOOL
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_OBJECT
import kotlin.Boolean
import kotlin.Float
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This object manages all 3D rendering buffers for the rendering device based renderers. An
 * instance of this object is created for every viewport that has 3D rendering enabled. See also
 * [RenderSceneBuffers].
 *
 * All buffers are organized in **contexts**. The default context is called **render_buffers** and
 * can contain amongst others the color buffer, depth buffer, velocity buffers, VRS density map and
 * MSAA variants of these buffers.
 *
 * Buffers are only guaranteed to exist during rendering of the viewport.
 *
 * **Note:** This is an internal rendering server object. Do not instantiate this class from a
 * script.
 */
@GodotBaseType
public open class RenderSceneBuffersRD : RenderSceneBuffers() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(615, scriptPtr)
  }

  /**
   * Returns `true` if a cached texture exists for this name.
   */
  public final fun hasTexture(context: StringName, name: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, context, name)
    TransferContext.callPtrMethod(MethodBindings.hasTexturePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Create a new texture with the given definition and cache this under the given name. Will return
   * the existing texture if it already exists.
   */
  public final fun createTexture(
    context: StringName,
    name: StringName,
    dataFormat: RenderingDevice.DataFormat,
    usageBits: Long,
    textureSamples: RenderingDevice.TextureSamples,
    size: Vector2i,
    layers: Long,
    mipmaps: Long,
    unique: Boolean,
    discardable: Boolean,
  ): RID {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_VECTOR2I_LONG_LONG_BOOL_BOOL(ptr, objectID.id, context, name, dataFormat.value, usageBits, textureSamples.value, size, layers, mipmaps, unique, discardable)
    TransferContext.callPtrMethod(MethodBindings.createTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Create a new texture using the given format and view and cache this under the given name. Will
   * return the existing texture if it already exists.
   */
  public final fun createTextureFromFormat(
    context: StringName,
    name: StringName,
    format: RDTextureFormat?,
    view: RDTextureView?,
    unique: Boolean,
  ): RID {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_OBJECT_OBJECT_BOOL(ptr, objectID.id, context, name, format, view, unique)
    TransferContext.callPtrMethod(MethodBindings.createTextureFromFormatPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Create a new texture view for an existing texture and cache this under the given [viewName].
   * Will return the existing texture view if it already exists. Will error if the source texture
   * doesn't exist.
   */
  public final fun createTextureView(
    context: StringName,
    name: StringName,
    viewName: StringName,
    view: RDTextureView?,
  ): RID {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME_OBJECT(ptr, objectID.id, context, name, viewName, view)
    TransferContext.callPtrMethod(MethodBindings.createTextureViewPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns a cached texture with this name.
   */
  public final fun getTexture(context: StringName, name: StringName): RID {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, context, name)
    TransferContext.callPtrMethod(MethodBindings.getTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the texture format information with which a cached texture was created.
   */
  public final fun getTextureFormat(context: StringName, name: StringName): RDTextureFormat? {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, context, name)
    TransferContext.callPtrMethod(MethodBindings.getTextureFormatPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as RDTextureFormat?)
  }

  /**
   * Returns a specific slice (layer or mipmap) for a cached texture.
   */
  public final fun getTextureSlice(
    context: StringName,
    name: StringName,
    layer: Long,
    mipmap: Long,
    layers: Long,
    mipmaps: Long,
  ): RID {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_LONG(ptr, objectID.id, context, name, layer, mipmap, layers, mipmaps)
    TransferContext.callPtrMethod(MethodBindings.getTextureSlicePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns a specific view of a slice (layer or mipmap) for a cached texture.
   */
  public final fun getTextureSliceView(
    context: StringName,
    name: StringName,
    layer: Long,
    mipmap: Long,
    layers: Long,
    mipmaps: Long,
    view: RDTextureView?,
  ): RID {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_LONG_LONG_LONG_OBJECT(ptr, objectID.id, context, name, layer, mipmap, layers, mipmaps, view)
    TransferContext.callPtrMethod(MethodBindings.getTextureSliceViewPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the texture size of a given slice of a cached texture.
   */
  public final fun getTextureSliceSize(
    context: StringName,
    name: StringName,
    mipmap: Long,
  ): Vector2i {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG(ptr, objectID.id, context, name, mipmap)
    TransferContext.callPtrMethod(MethodBindings.getTextureSliceSizePtr, 6)
    return TransferContext.readReturnValue_VECTOR2I()
  }

  /**
   * Frees all buffers related to this context.
   */
  public final fun clearContext(context: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, context)
    TransferContext.callPtrMethod(MethodBindings.clearContextPtr, 0)
  }

  /**
   * Returns the color texture we are rendering 3D content to. If multiview is used this will be a
   * texture array with all views.
   *
   * If [msaa] is `true` and MSAA is enabled, this returns the MSAA variant of the buffer.
   */
  @JvmOverloads
  public final fun getColorTexture(msaa: Boolean = false): RID {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, msaa)
    TransferContext.callPtrMethod(MethodBindings.getColorTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the specified layer from the color texture we are rendering 3D content to.
   *
   * If [msaa] is `true` and MSAA is enabled, this returns the MSAA variant of the buffer.
   */
  @JvmOverloads
  public final fun getColorLayer(layer: Long, msaa: Boolean = false): RID {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layer, msaa)
    TransferContext.callPtrMethod(MethodBindings.getColorLayerPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the depth texture we are rendering 3D content to. If multiview is used this will be a
   * texture array with all views.
   *
   * If [msaa] is `true` and MSAA is enabled, this returns the MSAA variant of the buffer.
   */
  @JvmOverloads
  public final fun getDepthTexture(msaa: Boolean = false): RID {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, msaa)
    TransferContext.callPtrMethod(MethodBindings.getDepthTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the specified layer from the depth texture we are rendering 3D content to.
   *
   * If [msaa] is `true` and MSAA is enabled, this returns the MSAA variant of the buffer.
   */
  @JvmOverloads
  public final fun getDepthLayer(layer: Long, msaa: Boolean = false): RID {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layer, msaa)
    TransferContext.callPtrMethod(MethodBindings.getDepthLayerPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the velocity texture we are rendering 3D content to. If multiview is used this will be
   * a texture array with all views.
   *
   * If [msaa] is **true** and MSAA is enabled, this returns the MSAA variant of the buffer.
   */
  @JvmOverloads
  public final fun getVelocityTexture(msaa: Boolean = false): RID {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, msaa)
    TransferContext.callPtrMethod(MethodBindings.getVelocityTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the specified layer from the velocity texture we are rendering 3D content to.
   */
  @JvmOverloads
  public final fun getVelocityLayer(layer: Long, msaa: Boolean = false): RID {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layer, msaa)
    TransferContext.callPtrMethod(MethodBindings.getVelocityLayerPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the render target associated with this buffers object.
   */
  public final fun getRenderTarget(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRenderTargetPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the view count for the associated viewport.
   */
  public final fun getViewCount(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getViewCountPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns the internal size of the render buffer (size before upscaling) with which textures are
   * created by default.
   */
  public final fun getInternalSize(): Vector2i {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInternalSizePtr, 6)
    return TransferContext.readReturnValue_VECTOR2I()
  }

  /**
   * Returns the target size of the render buffer (size after upscaling).
   */
  public final fun getTargetSize(): Vector2i {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTargetSizePtr, 6)
    return TransferContext.readReturnValue_VECTOR2I()
  }

  /**
   * Returns the scaling mode used for upscaling.
   */
  public final fun getScaling3dMode(): RenderingServer.ViewportScaling3DMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getScaling3dModePtr, 2)
    return RenderingServer.ViewportScaling3DMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the FSR sharpness value used while rendering the 3D content (if [getScaling3dMode] is
   * an FSR mode).
   */
  public final fun getFsrSharpness(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFsrSharpnessPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the applied 3D MSAA mode for this viewport.
   */
  public final fun getMsaa3d(): RenderingServer.ViewportMSAA {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMsaa3dPtr, 2)
    return RenderingServer.ViewportMSAA.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the number of MSAA samples used.
   */
  public final fun getTextureSamples(): RenderingDevice.TextureSamples {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextureSamplesPtr, 2)
    return RenderingDevice.TextureSamples.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the screen-space antialiasing method applied.
   */
  public final fun getScreenSpaceAa(): RenderingServer.ViewportScreenSpaceAA {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getScreenSpaceAaPtr, 2)
    return RenderingServer.ViewportScreenSpaceAA.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns `true` if TAA is enabled.
   */
  public final fun getUseTaa(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUseTaaPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if debanding is enabled.
   */
  public final fun getUseDebanding(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUseDebandingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if a cached texture exists for this name.
   */
  public final fun hasTexture(context: String, name: String): Boolean =
      hasTexture(context.asCachedStringName(), name.asCachedStringName())

  /**
   * Create a new texture with the given definition and cache this under the given name. Will return
   * the existing texture if it already exists.
   */
  public final fun createTexture(
    context: String,
    name: String,
    dataFormat: RenderingDevice.DataFormat,
    usageBits: Long,
    textureSamples: RenderingDevice.TextureSamples,
    size: Vector2i,
    layers: Long,
    mipmaps: Long,
    unique: Boolean,
    discardable: Boolean,
  ): RID =
      createTexture(context.asCachedStringName(), name.asCachedStringName(), dataFormat, usageBits, textureSamples, size, layers, mipmaps, unique, discardable)

  /**
   * Create a new texture using the given format and view and cache this under the given name. Will
   * return the existing texture if it already exists.
   */
  public final fun createTextureFromFormat(
    context: String,
    name: String,
    format: RDTextureFormat?,
    view: RDTextureView?,
    unique: Boolean,
  ): RID =
      createTextureFromFormat(context.asCachedStringName(), name.asCachedStringName(), format, view, unique)

  /**
   * Create a new texture view for an existing texture and cache this under the given [viewName].
   * Will return the existing texture view if it already exists. Will error if the source texture
   * doesn't exist.
   */
  public final fun createTextureView(
    context: String,
    name: String,
    viewName: String,
    view: RDTextureView?,
  ): RID =
      createTextureView(context.asCachedStringName(), name.asCachedStringName(), viewName.asCachedStringName(), view)

  /**
   * Returns a cached texture with this name.
   */
  public final fun getTexture(context: String, name: String): RID =
      getTexture(context.asCachedStringName(), name.asCachedStringName())

  /**
   * Returns the texture format information with which a cached texture was created.
   */
  public final fun getTextureFormat(context: String, name: String): RDTextureFormat? =
      getTextureFormat(context.asCachedStringName(), name.asCachedStringName())

  /**
   * Returns a specific slice (layer or mipmap) for a cached texture.
   */
  public final fun getTextureSlice(
    context: String,
    name: String,
    layer: Long,
    mipmap: Long,
    layers: Long,
    mipmaps: Long,
  ): RID =
      getTextureSlice(context.asCachedStringName(), name.asCachedStringName(), layer, mipmap, layers, mipmaps)

  /**
   * Returns a specific view of a slice (layer or mipmap) for a cached texture.
   */
  public final fun getTextureSliceView(
    context: String,
    name: String,
    layer: Long,
    mipmap: Long,
    layers: Long,
    mipmaps: Long,
    view: RDTextureView?,
  ): RID =
      getTextureSliceView(context.asCachedStringName(), name.asCachedStringName(), layer, mipmap, layers, mipmaps, view)

  /**
   * Returns the texture size of a given slice of a cached texture.
   */
  public final fun getTextureSliceSize(
    context: String,
    name: String,
    mipmap: Long,
  ): Vector2i = getTextureSliceSize(context.asCachedStringName(), name.asCachedStringName(), mipmap)

  /**
   * Frees all buffers related to this context.
   */
  public final fun clearContext(context: String) = clearContext(context.asCachedStringName())

  public companion object {
    @JvmField
    public val hasTextureName:
        MethodStringName2<RenderSceneBuffersRD, Boolean, StringName, StringName> =
        MethodStringName2<RenderSceneBuffersRD, Boolean, StringName, StringName>("has_texture")

    @JvmField
    public val createTextureName:
        MethodStringName10<RenderSceneBuffersRD, RID, StringName, StringName, RenderingDevice.DataFormat, Long, RenderingDevice.TextureSamples, Vector2i, Long, Long, Boolean, Boolean>
        =
        MethodStringName10<RenderSceneBuffersRD, RID, StringName, StringName, RenderingDevice.DataFormat, Long, RenderingDevice.TextureSamples, Vector2i, Long, Long, Boolean, Boolean>("create_texture")

    @JvmField
    public val createTextureFromFormatName:
        MethodStringName5<RenderSceneBuffersRD, RID, StringName, StringName, RDTextureFormat?, RDTextureView?, Boolean>
        =
        MethodStringName5<RenderSceneBuffersRD, RID, StringName, StringName, RDTextureFormat?, RDTextureView?, Boolean>("create_texture_from_format")

    @JvmField
    public val createTextureViewName:
        MethodStringName4<RenderSceneBuffersRD, RID, StringName, StringName, StringName, RDTextureView?>
        =
        MethodStringName4<RenderSceneBuffersRD, RID, StringName, StringName, StringName, RDTextureView?>("create_texture_view")

    @JvmField
    public val getTextureName: MethodStringName2<RenderSceneBuffersRD, RID, StringName, StringName>
        = MethodStringName2<RenderSceneBuffersRD, RID, StringName, StringName>("get_texture")

    @JvmField
    public val getTextureFormatName:
        MethodStringName2<RenderSceneBuffersRD, RDTextureFormat?, StringName, StringName> =
        MethodStringName2<RenderSceneBuffersRD, RDTextureFormat?, StringName, StringName>("get_texture_format")

    @JvmField
    public val getTextureSliceName:
        MethodStringName6<RenderSceneBuffersRD, RID, StringName, StringName, Long, Long, Long, Long>
        =
        MethodStringName6<RenderSceneBuffersRD, RID, StringName, StringName, Long, Long, Long, Long>("get_texture_slice")

    @JvmField
    public val getTextureSliceViewName:
        MethodStringName7<RenderSceneBuffersRD, RID, StringName, StringName, Long, Long, Long, Long, RDTextureView?>
        =
        MethodStringName7<RenderSceneBuffersRD, RID, StringName, StringName, Long, Long, Long, Long, RDTextureView?>("get_texture_slice_view")

    @JvmField
    public val getTextureSliceSizeName:
        MethodStringName3<RenderSceneBuffersRD, Vector2i, StringName, StringName, Long> =
        MethodStringName3<RenderSceneBuffersRD, Vector2i, StringName, StringName, Long>("get_texture_slice_size")

    @JvmField
    public val clearContextName: MethodStringName1<RenderSceneBuffersRD, Unit, StringName> =
        MethodStringName1<RenderSceneBuffersRD, Unit, StringName>("clear_context")

    @JvmField
    public val getColorTextureName: MethodStringName1<RenderSceneBuffersRD, RID, Boolean> =
        MethodStringName1<RenderSceneBuffersRD, RID, Boolean>("get_color_texture")

    @JvmField
    public val getColorLayerName: MethodStringName2<RenderSceneBuffersRD, RID, Long, Boolean> =
        MethodStringName2<RenderSceneBuffersRD, RID, Long, Boolean>("get_color_layer")

    @JvmField
    public val getDepthTextureName: MethodStringName1<RenderSceneBuffersRD, RID, Boolean> =
        MethodStringName1<RenderSceneBuffersRD, RID, Boolean>("get_depth_texture")

    @JvmField
    public val getDepthLayerName: MethodStringName2<RenderSceneBuffersRD, RID, Long, Boolean> =
        MethodStringName2<RenderSceneBuffersRD, RID, Long, Boolean>("get_depth_layer")

    @JvmField
    public val getVelocityTextureName: MethodStringName1<RenderSceneBuffersRD, RID, Boolean> =
        MethodStringName1<RenderSceneBuffersRD, RID, Boolean>("get_velocity_texture")

    @JvmField
    public val getVelocityLayerName: MethodStringName2<RenderSceneBuffersRD, RID, Long, Boolean> =
        MethodStringName2<RenderSceneBuffersRD, RID, Long, Boolean>("get_velocity_layer")

    @JvmField
    public val getRenderTargetName: MethodStringName0<RenderSceneBuffersRD, RID> =
        MethodStringName0<RenderSceneBuffersRD, RID>("get_render_target")

    @JvmField
    public val getViewCountName: MethodStringName0<RenderSceneBuffersRD, Long> =
        MethodStringName0<RenderSceneBuffersRD, Long>("get_view_count")

    @JvmField
    public val getInternalSizeName: MethodStringName0<RenderSceneBuffersRD, Vector2i> =
        MethodStringName0<RenderSceneBuffersRD, Vector2i>("get_internal_size")

    @JvmField
    public val getTargetSizeName: MethodStringName0<RenderSceneBuffersRD, Vector2i> =
        MethodStringName0<RenderSceneBuffersRD, Vector2i>("get_target_size")

    @JvmField
    public val getScaling3dModeName:
        MethodStringName0<RenderSceneBuffersRD, RenderingServer.ViewportScaling3DMode> =
        MethodStringName0<RenderSceneBuffersRD, RenderingServer.ViewportScaling3DMode>("get_scaling_3d_mode")

    @JvmField
    public val getFsrSharpnessName: MethodStringName0<RenderSceneBuffersRD, Float> =
        MethodStringName0<RenderSceneBuffersRD, Float>("get_fsr_sharpness")

    @JvmField
    public val getMsaa3dName: MethodStringName0<RenderSceneBuffersRD, RenderingServer.ViewportMSAA>
        = MethodStringName0<RenderSceneBuffersRD, RenderingServer.ViewportMSAA>("get_msaa_3d")

    @JvmField
    public val getTextureSamplesName:
        MethodStringName0<RenderSceneBuffersRD, RenderingDevice.TextureSamples> =
        MethodStringName0<RenderSceneBuffersRD, RenderingDevice.TextureSamples>("get_texture_samples")

    @JvmField
    public val getScreenSpaceAaName:
        MethodStringName0<RenderSceneBuffersRD, RenderingServer.ViewportScreenSpaceAA> =
        MethodStringName0<RenderSceneBuffersRD, RenderingServer.ViewportScreenSpaceAA>("get_screen_space_aa")

    @JvmField
    public val getUseTaaName: MethodStringName0<RenderSceneBuffersRD, Boolean> =
        MethodStringName0<RenderSceneBuffersRD, Boolean>("get_use_taa")

    @JvmField
    public val getUseDebandingName: MethodStringName0<RenderSceneBuffersRD, Boolean> =
        MethodStringName0<RenderSceneBuffersRD, Boolean>("get_use_debanding")
  }

  public object MethodBindings {
    internal val hasTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "has_texture", 471820014)

    internal val createTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "create_texture", 2950875024)

    internal val createTextureFromFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "create_texture_from_format", 3344669382)

    internal val createTextureViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "create_texture_view", 283055834)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_texture", 750006389)

    internal val getTextureFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_texture_format", 371461758)

    internal val getTextureSlicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_texture_slice", 588440706)

    internal val getTextureSliceViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_texture_slice_view", 682451778)

    internal val getTextureSliceSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_texture_slice_size", 2617625368)

    internal val clearContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "clear_context", 3304788590)

    internal val getColorTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_color_texture", 3050822880)

    internal val getColorLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_color_layer", 3087988589)

    internal val getDepthTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_depth_texture", 3050822880)

    internal val getDepthLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_depth_layer", 3087988589)

    internal val getVelocityTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_velocity_texture", 3050822880)

    internal val getVelocityLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_velocity_layer", 3087988589)

    internal val getRenderTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_render_target", 2944877500)

    internal val getViewCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_view_count", 3905245786)

    internal val getInternalSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_internal_size", 3690982128)

    internal val getTargetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_target_size", 3690982128)

    internal val getScaling3dModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_scaling_3d_mode", 976778074)

    internal val getFsrSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_fsr_sharpness", 1740695150)

    internal val getMsaa3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_msaa_3d", 3109158617)

    internal val getTextureSamplesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_texture_samples", 407791724)

    internal val getScreenSpaceAaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_screen_space_aa", 641513172)

    internal val getUseTaaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_use_taa", 36873697)

    internal val getUseDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersRD", "get_use_debanding", 36873697)
  }
}
