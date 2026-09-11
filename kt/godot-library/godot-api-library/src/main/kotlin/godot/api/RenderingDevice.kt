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
import godot.core.BitFieldBase
import godot.core.Callable
import godot.core.Color
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName10
import godot.core.MethodStringName11
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.MethodStringName9
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedInt32Array
import godot.core.PackedInt64Array
import godot.core.RID
import godot.core.Rect2
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantParser.VECTOR3
import godot.core.VariantParser._RID
import godot.core.Vector2i
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

public infix fun Long.or(other: RenderingDevice.BarrierMask): Long = this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.BarrierMask): Long = this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.BarrierMask): Long = this.and(other.flag)

public infix fun Long.or(other: RenderingDevice.TextureUsageBits): Long = this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.TextureUsageBits): Long = this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.TextureUsageBits): Long = this.and(other.flag)

public infix fun Long.or(other: RenderingDevice.StorageBufferUsage): Long = this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.StorageBufferUsage): Long = this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.StorageBufferUsage): Long = this.and(other.flag)

public infix fun Long.or(other: RenderingDevice.BufferCreationBits): Long = this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.BufferCreationBits): Long = this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.BufferCreationBits): Long = this.and(other.flag)

public infix fun Long.or(other: RenderingDevice.AccelerationStructureFlagBits): Long =
    this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.AccelerationStructureFlagBits): Long =
    this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.AccelerationStructureFlagBits): Long =
    this.and(other.flag)

public infix fun Long.or(other: RenderingDevice.AccelerationStructureGeometryFlagBits): Long =
    this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.AccelerationStructureGeometryFlagBits): Long =
    this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.AccelerationStructureGeometryFlagBits): Long =
    this.and(other.flag)

public infix fun Long.or(other: RenderingDevice.AccelerationStructureInstanceFlagBits): Long =
    this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.AccelerationStructureInstanceFlagBits): Long =
    this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.AccelerationStructureInstanceFlagBits): Long =
    this.and(other.flag)

public infix fun Long.or(other: RenderingDevice.PipelineDynamicStateFlags): Long =
    this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.PipelineDynamicStateFlags): Long =
    this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.PipelineDynamicStateFlags): Long =
    this.and(other.flag)

public infix fun Long.or(other: RenderingDevice.DrawFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: RenderingDevice.DrawFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: RenderingDevice.DrawFlags): Long = this.and(other.flag)

/**
 * [RenderingDevice] is an abstraction for working with modern low-level graphics APIs such as
 * Vulkan. Compared to [RenderingServer] (which works with Godot's own rendering subsystems),
 * [RenderingDevice] is much lower-level and allows working more directly with the underlying graphics
 * APIs. [RenderingDevice] is used in Godot to provide support for several modern low-level graphics
 * APIs while reducing the amount of code duplication required. [RenderingDevice] can also be used in
 * your own projects to perform things that are not exposed by [RenderingServer] or high-level nodes,
 * such as using compute shaders.
 *
 * On startup, Godot creates a global [RenderingDevice] which can be retrieved using
 * [RenderingServer.getRenderingDevice]. This global [RenderingDevice] performs drawing to the screen.
 *
 * **Local RenderingDevices:** Using [RenderingServer.createLocalRenderingDevice], you can create
 * "secondary" rendering devices to perform drawing and GPU compute operations on separate threads.
 *
 * **Note:** [RenderingDevice] assumes intermediate knowledge of modern graphics APIs such as
 * Vulkan, Direct3D 12, Metal or WebGPU. These graphics APIs are lower-level than OpenGL or Direct3D
 * 11, requiring you to perform what was previously done by the graphics driver itself. If you have
 * difficulty understanding the concepts used in this class, follow the
 * [url=https://vulkan-tutorial.com/]Vulkan Tutorial[/url] or [url=https://vkguide.dev/]Vulkan
 * Guide[/url]. It's recommended to have existing modern OpenGL or Direct3D 11 knowledge before
 * attempting to learn a low-level graphics API.
 *
 * **Note:** [RenderingDevice] is not available when running in headless mode or when using the
 * Compatibility rendering method.
 */
@GodotBaseType
public open class RenderingDevice internal constructor() : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(619, scriptPtr)
  }

  /**
   * Creates a new texture. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * **Note:** [data] takes an [VariantArray] of [PackedByteArray]s. For [TEXTURE_TYPE_1D],
   * [TEXTURE_TYPE_2D], and [TEXTURE_TYPE_3D] types, this array should only have one element, a
   * [PackedByteArray] containing all the data for the texture. For `_ARRAY` and `_CUBE` types, the
   * length should be the same as the number of [RDTextureFormat.arrayLayers] in [format].
   *
   * **Note:** Not to be confused with [RenderingServer.texture2dCreate], which creates the
   * Godot-specific [Texture2D] resource as opposed to the graphics API's own texture type.
   */
  @JvmOverloads
  public final fun textureCreate(
    format: RDTextureFormat?,
    view: RDTextureView?,
    `data`: VariantArray<PackedByteArray> = godot.core.variantArrayOf(),
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to format, OBJECT to view, ARRAY to data)
    TransferContext.callMethod(MethodBindings.textureCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a shared texture using the specified [view] and the texture information from
   * [withTexture].
   *
   * This will be freed automatically when the [withTexture] is freed.
   */
  public final fun textureCreateShared(view: RDTextureView?, withTexture: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to view, _RID to withTexture)
    TransferContext.callMethod(MethodBindings.textureCreateSharedPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a shared texture using the specified [view] and the texture information from
   * [withTexture]'s [layer] and [mipmap]. The number of included mipmaps from the original texture can
   * be controlled using the [mipmaps] parameter. Only relevant for textures with multiple layers, such
   * as 3D textures, texture arrays and cubemaps. For single-layer textures, use [textureCreateShared].
   *
   * For 2D textures (which only have one layer), [layer] must be `0`.
   *
   * **Note:** Layer slicing is only supported for 2D texture arrays, not 3D textures or cubemaps.
   *
   * This will be freed automatically when the [withTexture] is freed.
   */
  @JvmOverloads
  public final fun textureCreateSharedFromSlice(
    view: RDTextureView?,
    withTexture: RID,
    layer: Long,
    mipmap: Long,
    mipmaps: Long = 1,
    sliceType: TextureSliceType = RenderingDevice.TextureSliceType.TEXTURE_SLICE_2D,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to view, _RID to withTexture, LONG to layer, LONG to mipmap, LONG to mipmaps, LONG to sliceType.value)
    TransferContext.callMethod(MethodBindings.textureCreateSharedFromSlicePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns an RID for an existing [image] (`VkImage`) with the given [type], [format], [samples],
   * [usageFlags], [width], [height], [depth], [layers], and [mipmaps]. This can be used to allow Godot
   * to render onto foreign images.
   */
  @JvmOverloads
  public final fun textureCreateFromExtension(
    type: TextureType,
    format: DataFormat,
    samples: TextureSamples,
    usageFlags: TextureUsageBits,
    image: Long,
    width: Long,
    height: Long,
    depth: Long,
    layers: Long,
    mipmaps: Long = 1,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to format.value, LONG to samples.value, LONG to usageFlags.flag, LONG to image, LONG to width, LONG to height, LONG to depth, LONG to layers, LONG to mipmaps)
    TransferContext.callMethod(MethodBindings.textureCreateFromExtensionPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Updates texture data with new data, replacing the previous data in place. The updated texture
   * data must have the same dimensions and format. For 2D textures (which only have one layer),
   * [layer] must be `0`. Returns [@GlobalScope.OK] if the update was successful,
   * [@GlobalScope.ERR_INVALID_PARAMETER] otherwise.
   *
   * **Note:** Updating textures is forbidden during creation of a draw or compute list.
   *
   * **Note:** The existing [texture] can't be updated while a draw list that uses it as part of a
   * framebuffer is being created. Ensure the draw list is finalized (and that the color/depth texture
   * using it is not set to [FINAL_ACTION_CONTINUE]) to update this texture.
   *
   * **Note:** The existing [texture] requires the [TEXTURE_USAGE_CAN_UPDATE_BIT] to be updatable.
   */
  public final fun textureUpdate(
    texture: RID,
    layer: Long,
    `data`: PackedByteArray,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, LONG to layer, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.textureUpdatePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the [texture] data for the specified [layer] as raw binary data. For 2D textures (which
   * only have one layer), [layer] must be `0`.
   *
   * **Note:** [texture] can't be retrieved while a draw list that uses it as part of a framebuffer
   * is being created. Ensure the draw list is finalized (and that the color/depth texture using it is
   * not set to [FINAL_ACTION_CONTINUE]) to retrieve this texture. Otherwise, an error is printed and
   * an empty [PackedByteArray] is returned.
   *
   * **Note:** [texture] requires the [TEXTURE_USAGE_CAN_COPY_FROM_BIT] to be retrieved. Otherwise,
   * an error is printed and an empty [PackedByteArray] is returned.
   *
   * **Note:** This method will block the GPU from working until the data is retrieved. Refer to
   * [textureGetDataAsync] for an alternative that returns the data in more performant way.
   */
  public final fun textureGetData(texture: RID, layer: Long): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, LONG to layer)
    TransferContext.callMethod(MethodBindings.textureGetDataPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Asynchronous version of [textureGetData]. RenderingDevice will call [callback] in a certain
   * amount of frames with the data the texture had at the time of the request.
   *
   * **Note:** At the moment, the delay corresponds to the amount of frames specified by
   * [ProjectSettings.rendering/renderingDevice/vsync/frameQueueSize].
   *
   * **Note:** Downloading large textures can have a prohibitive cost for real-time even when using
   * the asynchronous method due to hardware bandwidth limitations. When dealing with large resources,
   * you can adjust settings such as
   * [ProjectSettings.rendering/renderingDevice/stagingBuffer/textureDownloadRegionSizePx] and
   * [ProjectSettings.rendering/renderingDevice/stagingBuffer/blockSizeKb] to improve the transfer
   * speed at the cost of extra memory.
   *
   * ```
   * func _texture_get_data_callback(array):
   * 	value = array.decode_u32(0)
   *
   * ...
   *
   * rd.texture_get_data_async(texture, 0, _texture_get_data_callback)
   * ```
   */
  public final fun textureGetDataAsync(
    texture: RID,
    layer: Long,
    callback: Callable,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, LONG to layer, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.textureGetDataAsyncPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the specified [format] is supported for the given [usageFlags], `false`
   * otherwise.
   */
  public final fun textureIsFormatSupportedForUsage(format: DataFormat,
      usageFlags: TextureUsageBits): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.value, LONG to usageFlags.flag)
    TransferContext.callMethod(MethodBindings.textureIsFormatSupportedForUsagePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the [texture] is shared, `false` otherwise. See [RDTextureView].
   */
  public final fun textureIsShared(texture: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.textureIsSharedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the [texture] is valid, `false` otherwise.
   */
  public final fun textureIsValid(texture: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.textureIsValidPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Updates the discardable property of [texture].
   *
   * If a texture is discardable, its contents do not need to be preserved between frames. This flag
   * is only relevant when the texture is used as target in a draw list.
   *
   * This information is used by [RenderingDevice] to figure out if a texture's contents can be
   * discarded, eliminating unnecessary writes to memory and boosting performance.
   */
  public final fun textureSetDiscardable(texture: RID, discardable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, BOOL to discardable)
    TransferContext.callMethod(MethodBindings.textureSetDiscardablePtr)
  }

  /**
   * Returns `true` if the [texture] is discardable, `false` otherwise. See [RDTextureFormat] or
   * [textureSetDiscardable].
   */
  public final fun textureIsDiscardable(texture: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.textureIsDiscardablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Copies the [fromTexture] to [toTexture] with the specified [fromPos], [toPos] and [size]
   * coordinates. For 2-dimensional textures, [fromPos] and [toPos] must have a Z axis of `0`, and
   * [size] must have a Z axis of `1`. Source and destination mipmaps/layers must also be specified,
   * with these parameters being `0` for textures without mipmaps or single-layer textures. Returns
   * [@GlobalScope.OK] if the texture copy was successful or [@GlobalScope.ERR_INVALID_PARAMETER]
   * otherwise.
   *
   * **Note:** [fromTexture] texture can't be copied while a draw list that uses it as part of a
   * framebuffer is being created. Ensure the draw list is finalized (and that the color/depth texture
   * using it is not set to [FINAL_ACTION_CONTINUE]) to copy this texture.
   *
   * **Note:** [fromTexture] texture requires the [TEXTURE_USAGE_CAN_COPY_FROM_BIT] to be retrieved.
   *
   * **Note:** [toTexture] can't be copied while a draw list that uses it as part of a framebuffer
   * is being created. Ensure the draw list is finalized (and that the color/depth texture using it is
   * not set to [FINAL_ACTION_CONTINUE]) to copy this texture.
   *
   * **Note:** [toTexture] requires the [TEXTURE_USAGE_CAN_COPY_TO_BIT] to be retrieved.
   *
   * **Note:** [fromTexture] and [toTexture] must be of the same type (color or depth).
   */
  public final fun textureCopy(
    fromTexture: RID,
    toTexture: RID,
    fromPos: Vector3,
    toPos: Vector3,
    size: Vector3,
    srcMipmap: Long,
    dstMipmap: Long,
    srcLayer: Long,
    dstLayer: Long,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fromTexture, _RID to toTexture, VECTOR3 to fromPos, VECTOR3 to toPos, VECTOR3 to size, LONG to srcMipmap, LONG to dstMipmap, LONG to srcLayer, LONG to dstLayer)
    TransferContext.callMethod(MethodBindings.textureCopyPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Clears the specified [texture] by replacing all of its pixels with the specified [color].
   * [baseMipmap] and [mipmapCount] determine which mipmaps of the texture are affected by this clear
   * operation, while [baseLayer] and [layerCount] determine which layers of a 3D texture (or texture
   * array) are affected by this clear operation. For 2D textures (which only have one layer by
   * design), [baseLayer] must be `0` and [layerCount] must be `1`.
   *
   * **Note:** [texture] can't be cleared while a draw list that uses it as part of a framebuffer is
   * being created. Ensure the draw list is finalized (and that the color/depth texture using it is not
   * set to [FINAL_ACTION_CONTINUE]) to clear this texture.
   */
  public final fun textureClear(
    texture: RID,
    color: Color,
    baseMipmap: Long,
    mipmapCount: Long,
    baseLayer: Long,
    layerCount: Long,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, COLOR to color, LONG to baseMipmap, LONG to mipmapCount, LONG to baseLayer, LONG to layerCount)
    TransferContext.callMethod(MethodBindings.textureClearPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Resolves the [fromTexture] texture onto [toTexture] with multisample antialiasing enabled. This
   * must be used when rendering a framebuffer for MSAA to work. Returns [@GlobalScope.OK] if
   * successful, [@GlobalScope.ERR_INVALID_PARAMETER] otherwise.
   *
   * **Note:** [fromTexture] and [toTexture] textures must have the same dimension, format and type
   * (color or depth).
   *
   * **Note:** [fromTexture] can't be copied while a draw list that uses it as part of a framebuffer
   * is being created. Ensure the draw list is finalized (and that the color/depth texture using it is
   * not set to [FINAL_ACTION_CONTINUE]) to resolve this texture.
   *
   * **Note:** [fromTexture] requires the [TEXTURE_USAGE_CAN_COPY_FROM_BIT] to be retrieved.
   *
   * **Note:** [fromTexture] must be multisampled and must also be 2D (or a slice of a 3D/cubemap
   * texture).
   *
   * **Note:** [toTexture] can't be copied while a draw list that uses it as part of a framebuffer
   * is being created. Ensure the draw list is finalized (and that the color/depth texture using it is
   * not set to [FINAL_ACTION_CONTINUE]) to resolve this texture.
   *
   * **Note:** [toTexture] texture requires the [TEXTURE_USAGE_CAN_COPY_TO_BIT] to be retrieved.
   *
   * **Note:** [toTexture] texture must **not** be multisampled and must also be 2D (or a slice of a
   * 3D/cubemap texture).
   */
  public final fun textureResolveMultisample(fromTexture: RID, toTexture: RID): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fromTexture, _RID to toTexture)
    TransferContext.callMethod(MethodBindings.textureResolveMultisamplePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the data format used to create this texture.
   */
  public final fun textureGetFormat(texture: RID): RDTextureFormat? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.textureGetFormatPtr)
    return (TransferContext.readReturnValue(OBJECT) as RDTextureFormat?)
  }

  /**
   * Returns the internal graphics handle for this texture object. For use when communicating with
   * third-party APIs mostly with GDExtension.
   *
   * **Note:** This function returns a `uint64_t` which internally maps to a `GLuint` (OpenGL) or
   * `VkImage` (Vulkan).
   */
  public final fun textureGetNativeHandle(texture: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.textureGetNativeHandlePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a new framebuffer format with the specified [attachments] and [viewCount]. Returns the
   * new framebuffer's unique framebuffer format ID.
   *
   * If [viewCount] is greater than or equal to `2`, enables multiview which is used for VR
   * rendering. This requires support for the Vulkan multiview extension.
   */
  @JvmOverloads
  public final fun framebufferFormatCreate(attachments: VariantArray<RDAttachmentFormat>,
      viewCount: Long = 1): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to attachments, LONG to viewCount)
    TransferContext.callMethod(MethodBindings.framebufferFormatCreatePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a multipass framebuffer format with the specified [attachments], [passes] and
   * [viewCount] and returns its ID. If [viewCount] is greater than or equal to `2`, enables multiview
   * which is used for VR rendering. This requires support for the Vulkan multiview extension.
   */
  @JvmOverloads
  public final fun framebufferFormatCreateMultipass(
    attachments: VariantArray<RDAttachmentFormat>,
    passes: VariantArray<RDFramebufferPass>,
    viewCount: Long = 1,
  ): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to attachments, ARRAY to passes, LONG to viewCount)
    TransferContext.callMethod(MethodBindings.framebufferFormatCreateMultipassPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a new empty framebuffer format with the specified number of [samples] and returns its
   * ID.
   */
  @JvmOverloads
  public final fun framebufferFormatCreateEmpty(samples: TextureSamples =
      RenderingDevice.TextureSamples.TEXTURE_SAMPLES_1): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to samples.value)
    TransferContext.callMethod(MethodBindings.framebufferFormatCreateEmptyPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the number of texture samples used for the given framebuffer [format] ID (returned by
   * [framebufferGetFormat]).
   */
  @JvmOverloads
  public final fun framebufferFormatGetTextureSamples(format: Long, renderPass: Long = 0):
      TextureSamples {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format, LONG to renderPass)
    TransferContext.callMethod(MethodBindings.framebufferFormatGetTextureSamplesPtr)
    return TextureSamples.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a new framebuffer. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * This will be freed automatically when any of the [textures] is freed.
   */
  @JvmOverloads
  public final fun framebufferCreate(
    textures: VariantArray<RID>,
    validateWithFormat: Long = -1,
    viewCount: Long = 1,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to textures, LONG to validateWithFormat, LONG to viewCount)
    TransferContext.callMethod(MethodBindings.framebufferCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new multipass framebuffer. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * This will be freed automatically when any of the [textures] is freed.
   */
  @JvmOverloads
  public final fun framebufferCreateMultipass(
    textures: VariantArray<RID>,
    passes: VariantArray<RDFramebufferPass>,
    validateWithFormat: Long = -1,
    viewCount: Long = 1,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to textures, ARRAY to passes, LONG to validateWithFormat, LONG to viewCount)
    TransferContext.callMethod(MethodBindings.framebufferCreateMultipassPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new empty framebuffer. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  @JvmOverloads
  public final fun framebufferCreateEmpty(
    size: Vector2i,
    samples: TextureSamples = RenderingDevice.TextureSamples.TEXTURE_SAMPLES_1,
    validateWithFormat: Long = -1,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to size, LONG to samples.value, LONG to validateWithFormat)
    TransferContext.callMethod(MethodBindings.framebufferCreateEmptyPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the format ID of the framebuffer specified by the [framebuffer] RID. This ID is
   * guaranteed to be unique for the same formats and does not need to be freed.
   */
  public final fun framebufferGetFormat(framebuffer: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to framebuffer)
    TransferContext.callMethod(MethodBindings.framebufferGetFormatPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the framebuffer specified by the [framebuffer] RID is valid, `false`
   * otherwise.
   */
  public final fun framebufferIsValid(framebuffer: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to framebuffer)
    TransferContext.callMethod(MethodBindings.framebufferIsValidPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Creates a new sampler. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  public final fun samplerCreate(state: RDSamplerState?): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to state)
    TransferContext.callMethod(MethodBindings.samplerCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns `true` if implementation supports using a texture of [format] with the given
   * [samplerFilter].
   */
  public final fun samplerIsFormatSupportedForFilter(format: DataFormat,
      samplerFilter: SamplerFilter): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.value, LONG to samplerFilter.value)
    TransferContext.callMethod(MethodBindings.samplerIsFormatSupportedForFilterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Creates a new vertex buffer. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  @JvmOverloads
  public final fun vertexBufferCreate(
    sizeBytes: Long,
    `data`: PackedByteArray = PackedByteArray(),
    creationBits: BufferCreationBits = RenderingDevice.BufferCreationBits(0),
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sizeBytes, PACKED_BYTE_ARRAY to data, LONG to creationBits.flag)
    TransferContext.callMethod(MethodBindings.vertexBufferCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new vertex format with the specified [vertexDescriptions]. Returns a unique vertex
   * format ID corresponding to the newly created vertex format.
   */
  public final fun vertexFormatCreate(vertexDescriptions: VariantArray<RDVertexAttribute>): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to vertexDescriptions)
    TransferContext.callMethod(MethodBindings.vertexFormatCreatePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a vertex array based on the specified buffers. Optionally, [offsets] (in bytes) may be
   * defined for each buffer.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * This will be freed automatically when any of the [srcBuffers] is freed.
   */
  @JvmOverloads
  public final fun vertexArrayCreate(
    vertexCount: Long,
    vertexFormat: Long,
    srcBuffers: VariantArray<RID>,
    offsets: PackedInt64Array = PackedInt64Array(),
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to vertexCount, LONG to vertexFormat, ARRAY to srcBuffers, PACKED_INT_64_ARRAY to offsets)
    TransferContext.callMethod(MethodBindings.vertexArrayCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new index buffer. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  @JvmOverloads
  public final fun indexBufferCreate(
    sizeIndices: Long,
    format: IndexBufferFormat,
    `data`: PackedByteArray = PackedByteArray(),
    useRestartIndices: Boolean = false,
    creationBits: BufferCreationBits = RenderingDevice.BufferCreationBits(0),
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sizeIndices, LONG to format.value, PACKED_BYTE_ARRAY to data, BOOL to useRestartIndices, LONG to creationBits.flag)
    TransferContext.callMethod(MethodBindings.indexBufferCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new index array. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * This will be freed automatically when the [indexBuffer] is freed.
   */
  public final fun indexArrayCreate(
    indexBuffer: RID,
    indexOffset: Long,
    indexCount: Long,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to indexBuffer, LONG to indexOffset, LONG to indexCount)
    TransferContext.callMethod(MethodBindings.indexArrayCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Compiles a SPIR-V from the shader source code in [shaderSource] and returns the SPIR-V as an
   * [RDShaderSPIRV]. This intermediate language shader is portable across different GPU models and
   * driver versions, but cannot be run directly by GPUs until compiled into a binary shader using
   * [shaderCompileBinaryFromSpirv].
   *
   * If [allowCache] is `true`, make use of the shader cache generated by Godot. This avoids a
   * potentially lengthy shader compilation step if the shader is already in cache. If [allowCache] is
   * `false`, Godot's shader cache is ignored and the shader will always be recompiled.
   */
  @JvmOverloads
  public final fun shaderCompileSpirvFromSource(shaderSource: RDShaderSource?, allowCache: Boolean =
      true): RDShaderSPIRV? {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to shaderSource, BOOL to allowCache)
    TransferContext.callMethod(MethodBindings.shaderCompileSpirvFromSourcePtr)
    return (TransferContext.readReturnValue(OBJECT) as RDShaderSPIRV?)
  }

  /**
   * Compiles a binary shader from [spirvData] and returns the compiled binary data as a
   * [PackedByteArray]. This compiled shader is specific to the GPU model and driver version used; it
   * will not work on different GPU models or even different driver versions. See also
   * [shaderCompileSpirvFromSource].
   *
   * [name] is an optional human-readable name that can be given to the compiled shader for
   * organizational purposes.
   */
  @JvmOverloads
  public final fun shaderCompileBinaryFromSpirv(spirvData: RDShaderSPIRV?, name: String = ""):
      PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to spirvData, STRING to name)
    TransferContext.callMethod(MethodBindings.shaderCompileBinaryFromSpirvPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Creates a new shader instance from SPIR-V intermediate code. It can be accessed with the RID
   * that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method. See also [shaderCompileSpirvFromSource] and [shaderCreateFromBytecode].
   */
  @JvmOverloads
  public final fun shaderCreateFromSpirv(spirvData: RDShaderSPIRV?, name: String = ""): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to spirvData, STRING to name)
    TransferContext.callMethod(MethodBindings.shaderCreateFromSpirvPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new shader instance from a binary compiled shader. It can be accessed with the RID
   * that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method. See also [shaderCompileBinaryFromSpirv] and [shaderCreateFromSpirv].
   */
  @JvmOverloads
  public final fun shaderCreateFromBytecode(binaryData: PackedByteArray, placeholderRid: RID =
      RID()): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to binaryData, _RID to placeholderRid)
    TransferContext.callMethod(MethodBindings.shaderCreateFromBytecodePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Create a placeholder RID by allocating an RID without initializing it for use in
   * [shaderCreateFromBytecode]. This allows you to create an RID for a shader and pass it around, but
   * defer compiling the shader to a later time.
   */
  public final fun shaderCreatePlaceholder(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.shaderCreatePlaceholderPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the internal vertex input mask. Internally, the vertex input mask is an unsigned
   * integer consisting of the locations (specified in GLSL via. `layout(location = ...)`) of the input
   * variables (specified in GLSL by the `in` keyword).
   */
  public final fun shaderGetVertexInputAttributeMask(shader: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader)
    TransferContext.callMethod(MethodBindings.shaderGetVertexInputAttributeMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a new uniform buffer. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  @JvmOverloads
  public final fun uniformBufferCreate(
    sizeBytes: Long,
    `data`: PackedByteArray = PackedByteArray(),
    creationBits: BufferCreationBits = RenderingDevice.BufferCreationBits(0),
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sizeBytes, PACKED_BYTE_ARRAY to data, LONG to creationBits.flag)
    TransferContext.callMethod(MethodBindings.uniformBufferCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a [url=https://vkguide.dev/docs/chapter-4/storage_buffers/]storage buffer[/url] with
   * the specified [data] and [usage]. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  @JvmOverloads
  public final fun storageBufferCreate(
    sizeBytes: Long,
    `data`: PackedByteArray = PackedByteArray(),
    usage: StorageBufferUsage = RenderingDevice.StorageBufferUsage(0),
    creationBits: BufferCreationBits = RenderingDevice.BufferCreationBits(0),
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sizeBytes, PACKED_BYTE_ARRAY to data, LONG to usage.flag, LONG to creationBits.flag)
    TransferContext.callMethod(MethodBindings.storageBufferCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new texture buffer. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  @JvmOverloads
  public final fun textureBufferCreate(
    sizeBytes: Long,
    format: DataFormat,
    `data`: PackedByteArray = PackedByteArray(),
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sizeBytes, LONG to format.value, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.textureBufferCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new uniform set. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * This will be freed automatically when the [shader] or any of the RIDs in the [uniforms] is
   * freed.
   */
  public final fun uniformSetCreate(
    uniforms: VariantArray<RDUniform>,
    shader: RID,
    shaderSet: Long,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to uniforms, _RID to shader, LONG to shaderSet)
    TransferContext.callMethod(MethodBindings.uniformSetCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Checks if the [uniformSet] is valid, i.e. is owned.
   */
  public final fun uniformSetIsValid(uniformSet: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to uniformSet)
    TransferContext.callMethod(MethodBindings.uniformSetIsValidPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Copies [size] bytes from the [srcBuffer] at [srcOffset] into [dstBuffer] at [dstOffset].
   *
   * Prints an error if:
   *
   * - [size] exceeds the size of either [srcBuffer] or [dstBuffer] at their corresponding offsets
   *
   * - a draw list is currently active (created by [drawListBegin])
   *
   * - a compute list is currently active (created by [computeListBegin])
   */
  public final fun bufferCopy(
    srcBuffer: RID,
    dstBuffer: RID,
    srcOffset: Long,
    dstOffset: Long,
    size: Long,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to srcBuffer, _RID to dstBuffer, LONG to srcOffset, LONG to dstOffset, LONG to size)
    TransferContext.callMethod(MethodBindings.bufferCopyPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Updates a region of [sizeBytes] bytes, starting at [offset], in the buffer, with the specified
   * [data].
   *
   * Prints an error if:
   *
   * - the region specified by [offset] + [sizeBytes] exceeds the buffer
   *
   * - a draw list is currently active (created by [drawListBegin])
   *
   * - a compute list is currently active (created by [computeListBegin])
   */
  public final fun bufferUpdate(
    buffer: RID,
    offset: Long,
    sizeBytes: Long,
    `data`: PackedByteArray,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to buffer, LONG to offset, LONG to sizeBytes, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.bufferUpdatePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Clears the contents of the [buffer], clearing [sizeBytes] bytes, starting at [offset].
   *
   * Prints an error if:
   *
   * - the size isn't a multiple of four
   *
   * - the region specified by [offset] + [sizeBytes] exceeds the buffer
   *
   * - a draw list is currently active (created by [drawListBegin])
   *
   * - a compute list is currently active (created by [computeListBegin])
   */
  public final fun bufferClear(
    buffer: RID,
    offset: Long,
    sizeBytes: Long,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to buffer, LONG to offset, LONG to sizeBytes)
    TransferContext.callMethod(MethodBindings.bufferClearPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns a copy of the data of the specified [buffer], optionally [offsetBytes] and [sizeBytes]
   * can be set to copy only a portion of the buffer.
   *
   * **Note:** This method will block the GPU from working until the data is retrieved. Refer to
   * [bufferGetDataAsync] for an alternative that returns the data in more performant way.
   */
  @JvmOverloads
  public final fun bufferGetData(
    buffer: RID,
    offsetBytes: Long = 0,
    sizeBytes: Long = 0,
  ): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to buffer, LONG to offsetBytes, LONG to sizeBytes)
    TransferContext.callMethod(MethodBindings.bufferGetDataPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Asynchronous version of [bufferGetData]. RenderingDevice will call [callback] in a certain
   * amount of frames with the data the buffer had at the time of the request.
   *
   * **Note:** At the moment, the delay corresponds to the amount of frames specified by
   * [ProjectSettings.rendering/renderingDevice/vsync/frameQueueSize].
   *
   * **Note:** Downloading large buffers can have a prohibitive cost for real-time even when using
   * the asynchronous method due to hardware bandwidth limitations. When dealing with large resources,
   * you can adjust settings such as
   * [ProjectSettings.rendering/renderingDevice/stagingBuffer/blockSizeKb] to improve the transfer
   * speed at the cost of extra memory.
   *
   * ```
   * func _buffer_get_data_callback(array):
   * 	value = array.decode_u32(0)
   *
   * ...
   *
   * rd.buffer_get_data_async(buffer, _buffer_get_data_callback)
   * ```
   */
  @JvmOverloads
  public final fun bufferGetDataAsync(
    buffer: RID,
    callback: Callable,
    offsetBytes: Long = 0,
    sizeBytes: Long = 0,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to buffer, CALLABLE to callback, LONG to offsetBytes, LONG to sizeBytes)
    TransferContext.callMethod(MethodBindings.bufferGetDataAsyncPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the address of the given [buffer] which can be passed to shaders in any way to access
   * underlying data. Buffer must have been created with this feature enabled.
   *
   * **Note:** You must check that the GPU supports this functionality by calling [hasFeature] with
   * [SUPPORTS_BUFFER_DEVICE_ADDRESS] as a parameter.
   */
  public final fun bufferGetDeviceAddress(buffer: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to buffer)
    TransferContext.callMethod(MethodBindings.bufferGetDeviceAddressPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a new render pipeline. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * This will be freed automatically when the [shader] is freed.
   */
  @JvmOverloads
  public final fun renderPipelineCreate(
    shader: RID,
    framebufferFormat: Long,
    vertexFormat: Long,
    primitive: RenderPrimitive,
    rasterizationState: RDPipelineRasterizationState?,
    multisampleState: RDPipelineMultisampleState?,
    stencilState: RDPipelineDepthStencilState?,
    colorBlendState: RDPipelineColorBlendState?,
    dynamicStateFlags: PipelineDynamicStateFlags = RenderingDevice.PipelineDynamicStateFlags(0),
    forRenderPass: Long = 0,
    specializationConstants: VariantArray<RDPipelineSpecializationConstant> =
        godot.core.variantArrayOf(),
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader, LONG to framebufferFormat, LONG to vertexFormat, LONG to primitive.value, OBJECT to rasterizationState, OBJECT to multisampleState, OBJECT to stencilState, OBJECT to colorBlendState, LONG to dynamicStateFlags.flag, LONG to forRenderPass, ARRAY to specializationConstants)
    TransferContext.callMethod(MethodBindings.renderPipelineCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns `true` if the render pipeline specified by the [renderPipeline] RID is valid, `false`
   * otherwise.
   */
  public final fun renderPipelineIsValid(renderPipeline: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to renderPipeline)
    TransferContext.callMethod(MethodBindings.renderPipelineIsValidPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Creates a new compute pipeline. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * This will be freed automatically when the [shader] is freed.
   */
  @JvmOverloads
  public final fun computePipelineCreate(shader: RID,
      specializationConstants: VariantArray<RDPipelineSpecializationConstant> =
      godot.core.variantArrayOf()): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader, ARRAY to specializationConstants)
    TransferContext.callMethod(MethodBindings.computePipelineCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns `true` if the compute pipeline specified by the [computePipeline] RID is valid, `false`
   * otherwise.
   */
  public final fun computePipelineIsValid(computePipeline: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to computePipeline)
    TransferContext.callMethod(MethodBindings.computePipelineIsValidPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Creates a new raytracing pipeline. It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * Each shader must provide the required stage. All stages must use compatible pipeline layouts.
   * The pipeline selects the required stage from each shader.
   *
   * Input order defines stable indices used by the API:
   *
   * - [raygenShaders] is indexed in [raytracingListTraceRays].
   *
   * - [missShaders] is indexed in `traceRayEXT`.
   *
   * - [hitGroups] is indexed in [hitSbtRangeUpdate].
   */
  public final fun raytracingPipelineCreate(
    raygenShaders: VariantArray<RDPipelineShader>,
    missShaders: VariantArray<RDPipelineShader>,
    hitGroups: VariantArray<RDHitGroup>,
    maxTraceRecursionDepth: Long,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to raygenShaders, ARRAY to missShaders, ARRAY to hitGroups, LONG to maxTraceRecursionDepth)
    TransferContext.callMethod(MethodBindings.raytracingPipelineCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns `true` if the raytracing pipeline specified by the [raytracingPipeline] RID is valid,
   * `false` otherwise.
   */
  public final fun raytracingPipelineIsValid(raytracingPipeline: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to raytracingPipeline)
    TransferContext.callMethod(MethodBindings.raytracingPipelineIsValidPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Creates a new Bottom-Level Acceleration Structure (BLAS). It can be accessed with the RID that
   * is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  public final fun blasCreate(geometries: VariantArray<RDAccelerationStructureGeometry>,
      flags: AccelerationStructureFlagBits): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to geometries, LONG to flags.flag)
    TransferContext.callMethod(MethodBindings.blasCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new Top-Level Acceleration Structure (TLAS). It can be accessed with the RID that is
   * returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   */
  public final fun tlasCreate(maxInstanceCount: Long, flags: AccelerationStructureFlagBits): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxInstanceCount, LONG to flags.flag)
    TransferContext.callMethod(MethodBindings.tlasCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Builds the [blas].
   */
  public final fun blasBuild(blas: RID): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to blas)
    TransferContext.callMethod(MethodBindings.blasBuildPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Builds the [tlas]. The contents of previous builds are discarded.
   *
   * Any BLAS provided through the [RDAccelerationStructureInstance.blas] member must already have
   * been built using the [blasBuild] method.
   *
   * The number of instances can be equal to or smaller than the maximum instance count provided in
   * the [tlasCreate] method.
   *
   * **Note:** Freeing or rebuilding any of the provided BLASes after this method invalidates the
   * TLAS and requires it to be rebuilt.
   */
  public final fun tlasBuild(tlas: RID, instances: VariantArray<RDAccelerationStructureInstance>):
      Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to tlas, ARRAY to instances)
    TransferContext.callMethod(MethodBindings.tlasBuildPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a new hit shader binding table (SBT). It can be accessed with the RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingDevice's
   * [freeRid] method.
   *
   * This will be freed automatically when the [raytracingPipeline] is freed.
   *
   * The hit SBT resizes itself as needed. [initialHitGroupCapacity] is used to allocate the initial
   * backing memory.
   */
  public final fun hitSbtCreate(raytracingPipeline: RID, initialHitGroupCapacity: Long): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to raytracingPipeline, LONG to initialHitGroupCapacity)
    TransferContext.callMethod(MethodBindings.hitSbtCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets a new [raytracingPipeline] for [hitSbt].
   *
   * The new pipeline must be a superset of the previous one. Existing hit groups must keep the same
   * order and new hit groups should be appended to the end. This preserves existing SBT entries.
   *
   * The previous pipeline must remain valid during the call.
   */
  public final fun hitSbtSetPipeline(hitSbt: RID, raytracingPipeline: RID): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to hitSbt, _RID to raytracingPipeline)
    TransferContext.callMethod(MethodBindings.hitSbtSetPipelinePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Allocates a contiguous range of SBT entries from [hitSbt].
   *
   * The returned value should be assigned to [RDAccelerationStructureInstance.hitSbtRange].
   *
   * During ray traversal, hit group index is computed as:
   *
   * 	(geometry index in [RDAccelerationStructureInstance.blas])
   *
   * 	× (SBT stride used in `traceRayEXT`)
   *
   * 	+ (SBT offset used in `traceRayEXT`)
   *
   * 	+ (range offset)
   *
   * [hitGroupCount] must be large enough to cover all SBT entries that may be indexed by this
   * equation. This typically corresponds to:
   *
   * 	(geometry count in [RDAccelerationStructureInstance.blas])
   *
   * 	× (SBT stride used in `traceRayEXT`)
   *
   * The allocated range is uninitialized and must be filled using [hitSbtRangeUpdate].
   */
  public final fun hitSbtRangeAlloc(hitSbt: RID, hitGroupCount: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to hitSbt, LONG to hitGroupCount)
    TransferContext.callMethod(MethodBindings.hitSbtRangeAllocPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Frees a hit SBT range previously allocated with [hitSbtRangeAlloc].
   *
   * The range must not be in use by any acceleration structure after being freed.
   */
  public final fun hitSbtRangeFree(hitSbt: RID, range: Long): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to hitSbt, LONG to range)
    TransferContext.callMethod(MethodBindings.hitSbtRangeFreePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Updates the contents of a hit SBT range.
   *
   * [hitGroupIndices] specifies indices into the hit group array provided in
   * [raytracingPipelineCreate].
   *
   * The [offset] parameter specifies where within the allocated range the writing begins. This
   * allows partial updates of a range. However, the complete range must be fully initialized before it
   * is used in a raytracing dispatch.
   */
  public final fun hitSbtRangeUpdate(
    hitSbt: RID,
    range: Long,
    offset: Long,
    hitGroupIndices: PackedInt32Array,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to hitSbt, LONG to range, LONG to offset, PACKED_INT_32_ARRAY to hitGroupIndices)
    TransferContext.callMethod(MethodBindings.hitSbtRangeUpdatePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the window width matching the graphics API context for the given window ID (in pixels).
   * Despite the parameter being named [screen], this returns the *window* size. See also
   * [screenGetHeight].
   *
   * **Note:** Only the main [RenderingDevice] returned by [RenderingServer.getRenderingDevice] has
   * a width. If called on a local [RenderingDevice], this method prints an error and returns
   * [INVALID_ID].
   */
  @JvmOverloads
  public final fun screenGetWidth(screen: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the window height matching the graphics API context for the given window ID (in
   * pixels). Despite the parameter being named [screen], this returns the *window* size. See also
   * [screenGetWidth].
   *
   * **Note:** Only the main [RenderingDevice] returned by [RenderingServer.getRenderingDevice] has
   * a height. If called on a local [RenderingDevice], this method prints an error and returns
   * [INVALID_ID].
   */
  @JvmOverloads
  public final fun screenGetHeight(screen: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetHeightPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the framebuffer format of the given screen.
   *
   * **Note:** Only the main [RenderingDevice] returned by [RenderingServer.getRenderingDevice] has
   * a format. If called on a local [RenderingDevice], this method prints an error and returns
   * [INVALID_ID].
   */
  @JvmOverloads
  public final fun screenGetFramebufferFormat(screen: Int = 0): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.screenGetFramebufferFormatPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * High-level variant of [drawListBegin], with the parameters automatically being adjusted for
   * drawing onto the window specified by the [screen] ID.
   *
   * **Note:** Cannot be used with local RenderingDevices, as these don't have a screen. If called
   * on a local RenderingDevice, [drawListBeginForScreen] returns [INVALID_ID].
   */
  @JvmOverloads
  public final fun drawListBeginForScreen(screen: Int = 0, clearColor: Color = Color(Color(0, 0, 0,
      1))): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to screen.toLong(), COLOR to clearColor)
    TransferContext.callMethod(MethodBindings.drawListBeginForScreenPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Starts a list of raster drawing commands created with the `draw_*` methods. The returned value
   * should be passed to other `draw_list_*` functions.
   *
   * Multiple draw lists cannot be created at the same time; you must finish the previous draw list
   * first using [drawListEnd].
   *
   * A simple drawing operation might look like this (code is not a complete example):
   *
   * ```
   * var rd = RenderingDevice.new()
   * var clear_colors = PackedColorArray([Color(0, 0, 0, 0), Color(0, 0, 0, 0), Color(0, 0, 0, 0)])
   * var draw_list = rd.draw_list_begin(framebuffers[i], RenderingDevice.CLEAR_COLOR_ALL,
   * clear_colors, true, 1.0f, true, 0, Rect2(), RenderingDevice.OPAQUE_PASS)
   *
   * # Draw opaque.
   * rd.draw_list_bind_render_pipeline(draw_list, raster_pipeline)
   * rd.draw_list_bind_uniform_set(draw_list, raster_base_uniform, 0)
   * rd.draw_list_set_push_constant(draw_list, raster_push_constant, raster_push_constant.size())
   * rd.draw_list_draw(draw_list, false, 1, slice_triangle_count[i] * 3)
   * # Draw wire.
   * rd.draw_list_bind_render_pipeline(draw_list, raster_pipeline_wire)
   * rd.draw_list_bind_uniform_set(draw_list, raster_base_uniform, 0)
   * rd.draw_list_set_push_constant(draw_list, raster_push_constant, raster_push_constant.size())
   * rd.draw_list_draw(draw_list, false, 1, slice_triangle_count[i] * 3)
   *
   * rd.draw_list_end()
   * ```
   *
   * The [drawFlags] indicates if the texture attachments of the framebuffer should be cleared or
   * ignored. Only one of the two flags can be used for each individual attachment. Ignoring an
   * attachment means that any contents that existed before the draw list will be completely discarded,
   * reducing the memory bandwidth used by the render pass but producing garbage results if the pixels
   * aren't replaced. The default behavior allows the engine to figure out the right operation to use
   * if the texture is discardable, which can result in increased performance. See [RDTextureFormat] or
   * [textureSetDiscardable].
   *
   * The [breadcrumb] parameter can be an arbitrary 32-bit integer that is useful to diagnose GPU
   * crashes. If Godot is built in dev or debug mode; when the GPU crashes Godot will dump all shaders
   * that were being executed at the time of the crash and the breadcrumb is useful to diagnose what
   * passes did those shaders belong to.
   *
   * It does not affect rendering behavior and can be set to 0. It is recommended to use
   * [BreadcrumbMarker] enumerations for consistency but it's not required. It is also possible to use
   * bitwise operations to add extra data. e.g.
   *
   * ```
   * rd.draw_list_begin(fb[i], RenderingDevice.CLEAR_COLOR_ALL, clear_colors, true, 1.0f, true, 0,
   * Rect2(), RenderingDevice.OPAQUE_PASS | 5)
   * ```
   */
  @JvmOverloads
  public final fun drawListBegin(
    framebuffer: RID,
    drawFlags: DrawFlags = RenderingDevice.DrawFlags.DEFAULT_ALL,
    clearColorValues: PackedColorArray = PackedColorArray(),
    clearDepthValue: Float = 1.0f,
    clearStencilValue: Long = 0,
    region: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
    breadcrumb: Long = 0,
  ): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to framebuffer, LONG to drawFlags.flag, PACKED_COLOR_ARRAY to clearColorValues, DOUBLE to clearDepthValue.toDouble(), LONG to clearStencilValue, RECT2 to region, LONG to breadcrumb)
    TransferContext.callMethod(MethodBindings.drawListBeginPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * This method does nothing and always returns an empty [PackedInt64Array].
   */
  @JvmOverloads
  public final fun drawListBeginSplit(
    framebuffer: RID,
    splits: Long,
    initialColorAction: InitialAction,
    finalColorAction: FinalAction,
    initialDepthAction: InitialAction,
    finalDepthAction: FinalAction,
    clearColorValues: PackedColorArray = PackedColorArray(),
    clearDepth: Float = 1.0f,
    clearStencil: Long = 0,
    region: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
    storageTextures: VariantArray<RID> = godot.core.variantArrayOf(),
  ): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to framebuffer, LONG to splits, LONG to initialColorAction.value, LONG to finalColorAction.value, LONG to initialDepthAction.value, LONG to finalDepthAction.value, PACKED_COLOR_ARRAY to clearColorValues, DOUBLE to clearDepth.toDouble(), LONG to clearStencil, RECT2 to region, ARRAY to storageTextures)
    TransferContext.callMethod(MethodBindings.drawListBeginSplitPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  /**
   * Sets blend constants for the specified [drawList] to [color]. Blend constants are used only if
   * the graphics pipeline is created with [DYNAMIC_STATE_BLEND_CONSTANTS] flag set.
   */
  public final fun drawListSetBlendConstants(drawList: Long, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, COLOR to color)
    TransferContext.callMethod(MethodBindings.drawListSetBlendConstantsPtr)
  }

  /**
   * Binds [renderPipeline] to the specified [drawList].
   */
  public final fun drawListBindRenderPipeline(drawList: Long, renderPipeline: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, _RID to renderPipeline)
    TransferContext.callMethod(MethodBindings.drawListBindRenderPipelinePtr)
  }

  /**
   * Binds [uniformSet] to the specified [drawList]. A [setIndex] must also be specified, which is
   * an identifier starting from `0` that must match the one expected by the draw list.
   */
  public final fun drawListBindUniformSet(
    drawList: Long,
    uniformSet: RID,
    setIndex: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, _RID to uniformSet, LONG to setIndex)
    TransferContext.callMethod(MethodBindings.drawListBindUniformSetPtr)
  }

  /**
   * Binds [vertexArray] to the specified [drawList].
   */
  public final fun drawListBindVertexArray(drawList: Long, vertexArray: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, _RID to vertexArray)
    TransferContext.callMethod(MethodBindings.drawListBindVertexArrayPtr)
  }

  /**
   * Binds a set of [vertexBuffers] directly to the specified [drawList] using [vertexFormat]
   * without creating a vertex array RID. Provide the number of vertices in [vertexCount]; optional
   * per-buffer byte [offsets] may also be supplied.
   */
  @JvmOverloads
  public final fun drawListBindVertexBuffersFormat(
    drawList: Long,
    vertexFormat: Long,
    vertexCount: Long,
    vertexBuffers: VariantArray<RID>,
    offsets: PackedInt64Array = PackedInt64Array(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, LONG to vertexFormat, LONG to vertexCount, ARRAY to vertexBuffers, PACKED_INT_64_ARRAY to offsets)
    TransferContext.callMethod(MethodBindings.drawListBindVertexBuffersFormatPtr)
  }

  /**
   * Binds [indexArray] to the specified [drawList].
   */
  public final fun drawListBindIndexArray(drawList: Long, indexArray: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, _RID to indexArray)
    TransferContext.callMethod(MethodBindings.drawListBindIndexArrayPtr)
  }

  /**
   * Sets the push constant data to [buffer] for the specified [drawList]. The shader determines how
   * this binary data is used. The buffer's size in bytes must also be specified in [sizeBytes] (this
   * can be obtained by calling the [PackedByteArray.size] method on the passed [buffer]).
   */
  public final fun drawListSetPushConstant(
    drawList: Long,
    buffer: PackedByteArray,
    sizeBytes: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, PACKED_BYTE_ARRAY to buffer, LONG to sizeBytes)
    TransferContext.callMethod(MethodBindings.drawListSetPushConstantPtr)
  }

  /**
   * Submits [drawList] for rendering on the GPU. This is the raster equivalent to
   * [computeListDispatch].
   */
  @JvmOverloads
  public final fun drawListDraw(
    drawList: Long,
    useIndices: Boolean,
    instances: Long,
    proceduralVertexCount: Long = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, BOOL to useIndices, LONG to instances, LONG to proceduralVertexCount)
    TransferContext.callMethod(MethodBindings.drawListDrawPtr)
  }

  /**
   * Submits [drawList] for rendering on the GPU with the given parameters stored in the [buffer] at
   * [offset]. Parameters being integers: vertex count, instance count, first vertex, first instance.
   * And when using indices: index count, instance count, first index, vertex offset, first instance.
   * Buffer must have been created with [STORAGE_BUFFER_USAGE_DISPATCH_INDIRECT] flag.
   */
  @JvmOverloads
  public final fun drawListDrawIndirect(
    drawList: Long,
    useIndices: Boolean,
    buffer: RID,
    offset: Long = 0,
    drawCount: Long = 1,
    stride: Long = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, BOOL to useIndices, _RID to buffer, LONG to offset, LONG to drawCount, LONG to stride)
    TransferContext.callMethod(MethodBindings.drawListDrawIndirectPtr)
  }

  /**
   * Creates a scissor rectangle and enables it for the specified [drawList]. Scissor rectangles are
   * used for clipping by discarding fragments that fall outside a specified rectangular portion of the
   * screen. See also [drawListDisableScissor].
   *
   * **Note:** The specified [rect] is automatically intersected with the screen's dimensions, which
   * means it cannot exceed the screen's dimensions.
   */
  @JvmOverloads
  public final fun drawListEnableScissor(drawList: Long, rect: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0)):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.drawListEnableScissorPtr)
  }

  /**
   * Removes and disables the scissor rectangle for the specified [drawList]. See also
   * [drawListEnableScissor].
   */
  public final fun drawListDisableScissor(drawList: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to drawList)
    TransferContext.callMethod(MethodBindings.drawListDisableScissorPtr)
  }

  /**
   * Switches to the next draw pass.
   */
  public final fun drawListSwitchToNextPass(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.drawListSwitchToNextPassPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * This method does nothing and always returns an empty [PackedInt64Array].
   */
  public final fun drawListSwitchToNextPassSplit(splits: Long): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to splits)
    TransferContext.callMethod(MethodBindings.drawListSwitchToNextPassSplitPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  /**
   * Finishes a list of raster drawing commands created with the `draw_*` methods.
   */
  public final fun drawListEnd(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.drawListEndPtr)
  }

  /**
   * Starts a list of compute commands created with the `compute_*` methods. The returned value
   * should be passed to other `compute_list_*` functions.
   *
   * Multiple compute lists cannot be created at the same time; you must finish the previous compute
   * list first using [computeListEnd].
   *
   * A simple compute operation might look like this (code is not a complete example):
   *
   * ```
   * var rd = RenderingDevice.new()
   * var compute_list = rd.compute_list_begin()
   *
   * rd.compute_list_bind_compute_pipeline(compute_list, compute_shader_dilate_pipeline)
   * rd.compute_list_bind_uniform_set(compute_list, compute_base_uniform_set, 0)
   * rd.compute_list_bind_uniform_set(compute_list, dilate_uniform_set, 1)
   *
   * for i in atlas_slices:
   * 	rd.compute_list_set_push_constant(compute_list, push_constant, push_constant.size())
   * 	rd.compute_list_dispatch(compute_list, group_size.x, group_size.y, group_size.z)
   * 	# No barrier, let them run all together.
   *
   * rd.compute_list_end()
   * ```
   */
  public final fun computeListBegin(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.computeListBeginPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Tells the GPU what compute pipeline to use when processing the compute list. If the shader has
   * changed since the last time this function was called, Godot will unbind all descriptor sets and
   * will re-bind them inside [computeListDispatch].
   */
  public final fun computeListBindComputePipeline(computeList: Long, computePipeline: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to computeList, _RID to computePipeline)
    TransferContext.callMethod(MethodBindings.computeListBindComputePipelinePtr)
  }

  /**
   * Sets the push constant data to [buffer] for the specified [computeList]. The shader determines
   * how this binary data is used. The buffer's size in bytes must also be specified in [sizeBytes]
   * (this can be obtained by calling the [PackedByteArray.size] method on the passed [buffer]).
   */
  public final fun computeListSetPushConstant(
    computeList: Long,
    buffer: PackedByteArray,
    sizeBytes: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to computeList, PACKED_BYTE_ARRAY to buffer, LONG to sizeBytes)
    TransferContext.callMethod(MethodBindings.computeListSetPushConstantPtr)
  }

  /**
   * Binds the [uniformSet] to this [computeList]. Godot ensures that all textures in the uniform
   * set have the correct Vulkan access masks. If Godot had to change access masks of textures, it will
   * raise a Vulkan image memory barrier.
   */
  public final fun computeListBindUniformSet(
    computeList: Long,
    uniformSet: RID,
    setIndex: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to computeList, _RID to uniformSet, LONG to setIndex)
    TransferContext.callMethod(MethodBindings.computeListBindUniformSetPtr)
  }

  /**
   * Submits the compute list for processing on the GPU. This is the compute equivalent to
   * [drawListDraw].
   */
  public final fun computeListDispatch(
    computeList: Long,
    xGroups: Long,
    yGroups: Long,
    zGroups: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to computeList, LONG to xGroups, LONG to yGroups, LONG to zGroups)
    TransferContext.callMethod(MethodBindings.computeListDispatchPtr)
  }

  /**
   * Submits the compute list for processing on the GPU with the given group counts stored in the
   * [buffer] at [offset]. Buffer must have been created with [STORAGE_BUFFER_USAGE_DISPATCH_INDIRECT]
   * flag.
   */
  public final fun computeListDispatchIndirect(
    computeList: Long,
    buffer: RID,
    offset: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to computeList, _RID to buffer, LONG to offset)
    TransferContext.callMethod(MethodBindings.computeListDispatchIndirectPtr)
  }

  /**
   * Raises a Vulkan compute barrier in the specified [computeList].
   */
  public final fun computeListAddBarrier(computeList: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to computeList)
    TransferContext.callMethod(MethodBindings.computeListAddBarrierPtr)
  }

  /**
   * Finishes a list of compute commands created with the `compute_*` methods.
   */
  public final fun computeListEnd(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.computeListEndPtr)
  }

  /**
   * Starts a list of raytracing commands. The returned value should be passed to other
   * `raytracing_list_*` functions.
   *
   * Multiple raytracing lists cannot be created at the same time; you must finish the previous
   * raytracing list first using [raytracingListEnd].
   *
   * A simple raytracing operation might look like this (code is not a complete example):
   *
   * ```gdscript
   * //gdscript
   * var rd = RenderingDevice.new()
   * assert(rd.has_feature(RenderingDevice.SUPPORTS_RAYTRACING_PIPELINE))
   *
   * # Create a BLAS for a mesh.
   * var geometry = RDAccelerationStructureGeometry.new()
   * geometry.flags = RenderingDevice.ACCELERATION_STRUCTURE_GEOMETRY_OPAQUE_BIT
   * geometry.vertex_buffer = vertex_buffer
   * geometry.vertex_stride = 12
   * geometry.vertex_format = RenderingDevice.DATA_FORMAT_R32G32B32_SFLOAT
   * geometry.vertex_count = 3
   * geometry.index_buffer = index_buffer
   * geometry.index_count = 3
   * geometries.push_back(geometry)
   *
   * blas = rd.blas_create([geometry], 0)
   *
   * # Create TLAS.
   * tlas = rd.tlas_create(1, 0)
   *
   * # Build acceleration structures.
   * rd.blas_build(blas)
   *
   * var instance = RDAccelerationStructureInstance.new()
   * instance.blas = blas
   *
   * instance.hit_sbt_range = rd.hit_sbt_range_alloc(hit_sbt, 1)
   * rd.hit_sbt_range_update(hit_sbt, instance.hit_sbt_range, 0, [0])
   *
   * rd.tlas_build(tlas, [instance])
   *
   * var raylist = rd.raytracing_list_begin()
   *
   * # Bind pipeline and uniforms.
   * rd.raytracing_list_bind_raytracing_pipeline(raylist, raytracing_pipeline)
   * rd.raytracing_list_bind_uniform_set(raylist, uniform_set, 0)
   *
   * # Trace rays.
   * var width = get_viewport().size.x
   * var height = get_viewport().size.y
   * rd.raytracing_list_trace_rays(raylist, 0, hit_sbt, width, height, 1)
   *
   * rd.raytracing_list_end()
   * ```
   */
  public final fun raytracingListBegin(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.raytracingListBeginPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Binds [raytracingPipeline] to the specified [raytracingList].
   */
  public final fun raytracingListBindRaytracingPipeline(raytracingList: Long,
      raytracingPipeline: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to raytracingList, _RID to raytracingPipeline)
    TransferContext.callMethod(MethodBindings.raytracingListBindRaytracingPipelinePtr)
  }

  /**
   * Sets the push constant data to [buffer] for the specified [raytracingList]. The shader
   * determines how this binary data is used. The buffer's size in bytes must also be specified in
   * [sizeBytes] (this can be obtained by calling the [PackedByteArray.size] method on the passed
   * [buffer]).
   */
  public final fun raytracingListSetPushConstant(
    raytracingList: Long,
    buffer: PackedByteArray,
    sizeBytes: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to raytracingList, PACKED_BYTE_ARRAY to buffer, LONG to sizeBytes)
    TransferContext.callMethod(MethodBindings.raytracingListSetPushConstantPtr)
  }

  /**
   * Binds the [uniformSet] to this [raytracingList].
   */
  public final fun raytracingListBindUniformSet(
    raytracingList: Long,
    uniformSet: RID,
    setIndex: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to raytracingList, _RID to uniformSet, LONG to setIndex)
    TransferContext.callMethod(MethodBindings.raytracingListBindUniformSetPtr)
  }

  /**
   * Initializes a raytracing dispatch for [raytracingList], launching [width] × [height] × [depth]
   * rays.
   *
   * [raygenShaderIndex] selects the ray generation shader from the pipeline bound with
   * [raytracingListBindRaytracingPipeline].
   *
   * [hitSbt] must use the same pipeline bound to [raytracingList].
   */
  public final fun raytracingListTraceRays(
    raytracingList: Long,
    raygenShaderIndex: Long,
    hitSbt: RID,
    width: Long,
    height: Long,
    depth: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to raytracingList, LONG to raygenShaderIndex, _RID to hitSbt, LONG to width, LONG to height, LONG to depth)
    TransferContext.callMethod(MethodBindings.raytracingListTraceRaysPtr)
  }

  /**
   * Finishes a list of raytracing commands created with the `raytracing_*` methods.
   */
  public final fun raytracingListEnd(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.raytracingListEndPtr)
  }

  /**
   * Tries to free an object in the RenderingDevice. To avoid memory leaks, this should be called
   * after using an object as memory management does not occur automatically when using RenderingDevice
   * directly.
   */
  public final fun freeRid(rid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.freeRidPtr)
  }

  /**
   * Creates a timestamp marker with the specified [name]. This is used for performance reporting
   * with the [getCapturedTimestampCpuTime], [getCapturedTimestampGpuTime] and
   * [getCapturedTimestampName] methods.
   */
  public final fun captureTimestamp(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.captureTimestampPtr)
  }

  /**
   * Returns the total number of timestamps (rendering steps) available for profiling.
   */
  public final fun getCapturedTimestampsCount(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCapturedTimestampsCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the index of the last frame rendered that has rendering timestamps available for
   * querying.
   */
  public final fun getCapturedTimestampsFrame(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCapturedTimestampsFramePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the timestamp in GPU time for the rendering step specified by [index] (in microseconds
   * since the engine started). See also [getCapturedTimestampCpuTime] and [captureTimestamp].
   */
  public final fun getCapturedTimestampGpuTime(index: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index)
    TransferContext.callMethod(MethodBindings.getCapturedTimestampGpuTimePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the timestamp in CPU time for the rendering step specified by [index] (in microseconds
   * since the engine started). See also [getCapturedTimestampGpuTime] and [captureTimestamp].
   */
  public final fun getCapturedTimestampCpuTime(index: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index)
    TransferContext.callMethod(MethodBindings.getCapturedTimestampCpuTimePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the timestamp's name for the rendering step specified by [index]. See also
   * [captureTimestamp].
   */
  public final fun getCapturedTimestampName(index: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index)
    TransferContext.callMethod(MethodBindings.getCapturedTimestampNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the [feature] is supported by the GPU.
   */
  public final fun hasFeature(feature: Features): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to feature.value)
    TransferContext.callMethod(MethodBindings.hasFeaturePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the value of the specified [limit]. This limit varies depending on the current graphics
   * hardware (and sometimes the driver version). If the given limit is exceeded, rendering errors will
   * occur.
   *
   * Limits for various graphics hardware can be found in the
   * [url=https://vulkan.gpuinfo.org/]Vulkan Hardware Database[/url].
   */
  public final fun limitGet(limit: Limit): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to limit.value)
    TransferContext.callMethod(MethodBindings.limitGetPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the frame count kept by the graphics API. Higher values result in higher input lag, but
   * with more consistent throughput. For the main [RenderingDevice], frames are cycled (usually 3 with
   * triple-buffered V-Sync enabled). However, local [RenderingDevice]s only have 1 frame.
   */
  public final fun getFrameDelay(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrameDelayPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Pushes the frame setup and draw command buffers then marks the local device as currently
   * processing (which allows calling [sync]).
   *
   * **Note:** Only available in local RenderingDevices.
   */
  public final fun submit(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.submitPtr)
  }

  /**
   * Forces a synchronization between the CPU and GPU, which may be required in certain cases. Only
   * call this when needed, as CPU-GPU synchronization has a performance cost.
   *
   * **Note:** Only available in local RenderingDevices.
   *
   * **Note:** [sync] can only be called after a [submit].
   */
  public final fun sync(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.syncPtr)
  }

  /**
   * This method does nothing.
   */
  @JvmOverloads
  public final fun barrier(from: BarrierMask = RenderingDevice.BarrierMask.ALL_BARRIERS,
      to: BarrierMask = RenderingDevice.BarrierMask.ALL_BARRIERS): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to from.flag, LONG to to.flag)
    TransferContext.callMethod(MethodBindings.barrierPtr)
  }

  /**
   * This method does nothing.
   */
  public final fun fullBarrier(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.fullBarrierPtr)
  }

  /**
   * Create a new local [RenderingDevice]. This is most useful for performing compute operations on
   * the GPU independently from the rest of the engine.
   */
  public final fun createLocalDevice(): RenderingDevice? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createLocalDevicePtr)
    return (TransferContext.readReturnValue(OBJECT) as RenderingDevice?)
  }

  /**
   * Sets the resource name for [id] to [name]. This is used for debugging with third-party tools
   * such as [url=https://renderdoc.org/]RenderDoc[/url].
   *
   * The following types of resources can be named: texture, sampler, vertex buffer, index buffer,
   * uniform buffer, texture buffer, storage buffer, uniform set buffer, shader, render pipeline and
   * compute pipeline. Framebuffers cannot be named. Attempting to name an incompatible resource type
   * will print an error.
   *
   * **Note:** Resource names are only set when the engine runs in verbose mode
   * ([OS.isStdoutVerbose] = `true`), or when using an engine build compiled with the `dev_mode=yes`
   * SCons option. The graphics driver must also support the `VK_EXT_DEBUG_UTILS_EXTENSION_NAME` Vulkan
   * extension for named resources to work.
   */
  public final fun setResourceName(id: RID, name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to id, STRING to name)
    TransferContext.callMethod(MethodBindings.setResourceNamePtr)
  }

  /**
   * Create a command buffer debug label region that can be displayed in third-party tools such as
   * [url=https://renderdoc.org/]RenderDoc[/url]. All regions must be ended with a
   * [drawCommandEndLabel] call. When viewed from the linear series of submissions to a single queue,
   * calls to [drawCommandBeginLabel] and [drawCommandEndLabel] must be matched and balanced.
   *
   * The `VK_EXT_DEBUG_UTILS_EXTENSION_NAME` Vulkan extension must be available and enabled for
   * command buffer debug label region to work. See also [drawCommandEndLabel].
   */
  public final fun drawCommandBeginLabel(name: String, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name, COLOR to color)
    TransferContext.callMethod(MethodBindings.drawCommandBeginLabelPtr)
  }

  /**
   * This method does nothing.
   */
  public final fun drawCommandInsertLabel(name: String, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name, COLOR to color)
    TransferContext.callMethod(MethodBindings.drawCommandInsertLabelPtr)
  }

  /**
   * Ends the command buffer debug label region started by a [drawCommandBeginLabel] call.
   */
  public final fun drawCommandEndLabel(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.drawCommandEndLabelPtr)
  }

  /**
   * Returns the vendor of the video adapter (e.g. "NVIDIA Corporation"). Equivalent to
   * [RenderingServer.getVideoAdapterVendor]. See also [getDeviceName].
   */
  public final fun getDeviceVendorName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDeviceVendorNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the video adapter (e.g. "GeForce GTX 1080/PCIe/SSE2"). Equivalent to
   * [RenderingServer.getVideoAdapterName]. See also [getDeviceVendorName].
   */
  public final fun getDeviceName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDeviceNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the universally unique identifier for the pipeline cache. This is used to cache shader
   * files on disk, which avoids shader recompilations on subsequent engine runs. This UUID varies
   * depending on the graphics card model, but also the driver version. Therefore, updating graphics
   * drivers will invalidate the shader cache.
   */
  public final fun getDevicePipelineCacheUuid(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDevicePipelineCacheUuidPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the memory usage in bytes corresponding to the given [type]. When using Vulkan, these
   * statistics are calculated by
   * [url=https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator]Vulkan Memory
   * Allocator[/url].
   */
  public final fun getMemoryUsage(type: MemoryType): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value)
    TransferContext.callMethod(MethodBindings.getMemoryUsagePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the unique identifier of the driver [resource] for the specified [rid]. Some driver
   * resource types ignore the specified [rid]. [index] is always ignored but must be specified anyway.
   */
  public final fun getDriverResource(
    resource: DriverResource,
    rid: RID,
    index: Long,
  ): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to resource.value, _RID to rid, LONG to index)
    TransferContext.callMethod(MethodBindings.getDriverResourcePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns a string with a performance report from the past frame. Updates every frame.
   */
  public final fun getPerfReport(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPerfReportPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns string report in CSV format using the following methods:
   *
   * - [getTrackedObjectName]
   *
   * - [getTrackedObjectTypeCount]
   *
   * - [getDriverTotalMemory]
   *
   * - [getDriverAllocationCount]
   *
   * - [getDriverMemoryByObjectType]
   *
   * - [getDriverAllocsByObjectType]
   *
   * - [getDeviceTotalMemory]
   *
   * - [getDeviceAllocationCount]
   *
   * - [getDeviceMemoryByObjectType]
   *
   * - [getDeviceAllocsByObjectType]
   *
   * This is only used by Vulkan in debug builds. Godot must also be started with the
   * `--extra-gpu-memory-tracking` [url=$DOCS_URL/tutorials/editor/command_line_tutorial.html]command
   * line argument[/url].
   */
  public final fun getDriverAndDeviceMemoryReport(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDriverAndDeviceMemoryReportPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the type of object for the given [typeIndex]. This value must be in range
   * `[0; get_tracked_object_type_count - 1]`. If [getTrackedObjectTypeCount] is 0, then type argument
   * is ignored and always returns the same string.
   *
   * The return value is important because it gives meaning to the types passed to
   * [getDriverMemoryByObjectType], [getDriverAllocsByObjectType], [getDeviceMemoryByObjectType], and
   * [getDeviceAllocsByObjectType]. Examples of strings it can return (not exhaustive):
   *
   * - DEVICE_MEMORY
   *
   * - PIPELINE_CACHE
   *
   * - SWAPCHAIN_KHR
   *
   * - COMMAND_POOL
   *
   * Thus if e.g. `get_tracked_object_name(5)` returns "COMMAND_POOL", then
   * `get_device_memory_by_object_type(5)` returns the bytes used by the GPU for command pools.
   *
   * This is only used by Vulkan in debug builds. Godot must also be started with the
   * `--extra-gpu-memory-tracking` [url=$DOCS_URL/tutorials/editor/command_line_tutorial.html]command
   * line argument[/url].
   */
  public final fun getTrackedObjectName(typeIndex: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to typeIndex)
    TransferContext.callMethod(MethodBindings.getTrackedObjectNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns how many types of trackable objects there are.
   *
   * This is only used by Vulkan in debug builds. Godot must also be started with the
   * `--extra-gpu-memory-tracking` [url=$DOCS_URL/tutorials/editor/command_line_tutorial.html]command
   * line argument[/url].
   */
  public final fun getTrackedObjectTypeCount(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackedObjectTypeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns how much bytes the GPU driver is using for internal driver structures.
   *
   * This is only used by Vulkan in debug builds and can return 0 when this information is not
   * tracked or unknown.
   */
  public final fun getDriverTotalMemory(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDriverTotalMemoryPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns how many allocations the GPU driver has performed for internal driver structures.
   *
   * This is only used by Vulkan in debug builds and can return 0 when this information is not
   * tracked or unknown.
   */
  public final fun getDriverAllocationCount(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDriverAllocationCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Same as [getDriverTotalMemory] but filtered for a given object type.
   *
   * The type argument must be in range `[0; get_tracked_object_type_count - 1]`. If
   * [getTrackedObjectTypeCount] is 0, then type argument is ignored and always returns 0.
   *
   * This is only used by Vulkan in debug builds and can return 0 when this information is not
   * tracked or unknown.
   */
  public final fun getDriverMemoryByObjectType(type: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type)
    TransferContext.callMethod(MethodBindings.getDriverMemoryByObjectTypePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Same as [getDriverAllocationCount] but filtered for a given object type.
   *
   * The type argument must be in range `[0; get_tracked_object_type_count - 1]`. If
   * [getTrackedObjectTypeCount] is 0, then type argument is ignored and always returns 0.
   *
   * This is only used by Vulkan in debug builds and can return 0 when this information is not
   * tracked or unknown.
   */
  public final fun getDriverAllocsByObjectType(type: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type)
    TransferContext.callMethod(MethodBindings.getDriverAllocsByObjectTypePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns how much bytes the GPU is using.
   *
   * This is only used by Vulkan in debug builds and can return 0 when this information is not
   * tracked or unknown.
   */
  public final fun getDeviceTotalMemory(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDeviceTotalMemoryPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns how many allocations the GPU has performed for internal driver structures.
   *
   * This is only used by Vulkan in debug builds and can return 0 when this information is not
   * tracked or unknown.
   */
  public final fun getDeviceAllocationCount(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDeviceAllocationCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Same as [getDeviceTotalMemory] but filtered for a given object type.
   *
   * The type argument must be in range `[0; get_tracked_object_type_count - 1]`. If
   * [getTrackedObjectTypeCount] is 0, then type argument is ignored and always returns 0.
   *
   * This is only used by Vulkan in debug builds and can return 0 when this information is not
   * tracked or unknown.
   */
  public final fun getDeviceMemoryByObjectType(type: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type)
    TransferContext.callMethod(MethodBindings.getDeviceMemoryByObjectTypePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Same as [getDeviceAllocationCount] but filtered for a given object type.
   *
   * The type argument must be in range `[0; get_tracked_object_type_count - 1]`. If
   * [getTrackedObjectTypeCount] is 0, then type argument is ignored and always returns 0.
   *
   * This is only used by Vulkan in debug builds and can return 0 when this information is not
   * tracked or unknown.
   */
  public final fun getDeviceAllocsByObjectType(type: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type)
    TransferContext.callMethod(MethodBindings.getDeviceAllocsByObjectTypePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class DeviceType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Rendering device type does not match any of the other enum values or is unknown.
     */
    OTHER(0),
    /**
     * Rendering device is an integrated GPU, which is typically *(but not always)* slower than
     * dedicated GPUs ([DEVICE_TYPE_DISCRETE_GPU]). On Android and iOS, the rendering device type is
     * always considered to be [DEVICE_TYPE_INTEGRATED_GPU].
     */
    INTEGRATED_GPU(1),
    /**
     * Rendering device is a dedicated GPU, which is typically *(but not always)* faster than
     * integrated GPUs ([DEVICE_TYPE_INTEGRATED_GPU]).
     */
    DISCRETE_GPU(2),
    /**
     * Rendering device is an emulated GPU in a virtual environment. This is typically much slower
     * than the host GPU, which means the expected performance level on a dedicated GPU will be roughly
     * equivalent to [DEVICE_TYPE_INTEGRATED_GPU]. Virtual machine GPU passthrough (such as VFIO) will
     * not report the device type as [DEVICE_TYPE_VIRTUAL_GPU]. Instead, the host GPU's device type
     * will be reported as if the GPU was not emulated.
     */
    VIRTUAL_GPU(3),
    /**
     * Rendering device is provided by software emulation (such as Lavapipe or
     * [url=https://github.com/google/swiftshader]SwiftShader[/url]). This is the slowest kind of
     * rendering device available; it's typically much slower than [DEVICE_TYPE_INTEGRATED_GPU].
     */
    CPU(4),
    /**
     * Represents the size of the [DeviceType] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): DeviceType = entries.single { it.`value` == `value` }
    }
  }

  public enum class DriverResource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Specific device object based on a physical device (`rid` parameter is ignored).
     *
     * - Vulkan: Vulkan device driver resource (`VkDevice`).
     *
     * - D3D12: D3D12 device driver resource (`ID3D12Device`).
     *
     * - Metal: Metal device driver resource (`MTLDevice`).
     */
    LOGICAL_DEVICE(0),
    /**
     * Physical device the specific logical device is based on (`rid` parameter is ignored).
     *
     * - Vulkan: `VkPhysicalDevice`.
     *
     * - D3D12: `IDXGIAdapter`.
     */
    PHYSICAL_DEVICE(1),
    /**
     * Top-most graphics API entry object (`rid` parameter is ignored).
     *
     * - Vulkan: `VkInstance`.
     */
    TOPMOST_OBJECT(2),
    /**
     * The main graphics-compute command queue (`rid` parameter is ignored).
     *
     * - Vulkan: `VkQueue`.
     *
     * - D3D12: `ID3D12CommandQueue`.
     *
     * - Metal: `MTLCommandQueue`.
     */
    COMMAND_QUEUE(3),
    /**
     * The specific family the main queue belongs to (`rid` parameter is ignored).
     *
     * - Vulkan: The queue family index, a `uint32_t`.
     */
    QUEUE_FAMILY(4),
    /**
     * - Vulkan: `VkImage`.
     *
     * - D3D12: `ID3D12Resource`.
     */
    TEXTURE(5),
    /**
     * The view of an owned or shared texture.
     *
     * - Vulkan: `VkImageView`.
     *
     * - D3D12: `ID3D12Resource`.
     */
    TEXTURE_VIEW(6),
    /**
     * The native id of the data format of the texture.
     *
     * - Vulkan: `VkFormat`.
     *
     * - D3D12: `DXGI_FORMAT`.
     */
    TEXTURE_DATA_FORMAT(7),
    /**
     * - Vulkan: `VkSampler`.
     */
    SAMPLER(8),
    /**
     * - Vulkan: `VkDescriptorSet`.
     */
    UNIFORM_SET(9),
    /**
     * Buffer of any kind of (storage, vertex, etc.).
     *
     * - Vulkan: `VkBuffer`.
     *
     * - D3D12: `ID3D12Resource`.
     */
    BUFFER(10),
    /**
     * - Vulkan: `VkPipeline`.
     *
     * - Metal: `MTLComputePipelineState`.
     */
    COMPUTE_PIPELINE(11),
    /**
     * - Vulkan: `VkPipeline`.
     *
     * - Metal: `MTLRenderPipelineState`.
     */
    RENDER_PIPELINE(12),
    VULKAN_DEVICE(0),
    VULKAN_PHYSICAL_DEVICE(1),
    VULKAN_INSTANCE(2),
    VULKAN_QUEUE(3),
    VULKAN_QUEUE_FAMILY_INDEX(4),
    VULKAN_IMAGE(5),
    VULKAN_IMAGE_VIEW(6),
    VULKAN_IMAGE_NATIVE_TEXTURE_FORMAT(7),
    VULKAN_SAMPLER(8),
    VULKAN_DESCRIPTOR_SET(9),
    VULKAN_BUFFER(10),
    VULKAN_COMPUTE_PIPELINE(11),
    VULKAN_RENDER_PIPELINE(12),
    ;

    public companion object {
      public fun from(`value`: Long): DriverResource = entries.single { it.`value` == `value` }
    }
  }

  public enum class DataFormat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 4-bit-per-channel red/green channel data format, packed into 8 bits. Values are in the `[0.0,
     * 1.0]` range.
     *
     * **Note:** More information on all data formats can be found on the
     * [url=https://registry.khronos.org/vulkan/specs/1.1/html/vkspec.html#_identification_of_formats]Identification
     * of formats[/url] section of the Vulkan specification, as well as the
     * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/man/html/VkFormat.html]VkFormat[/url]
     * enum.
     */
    R4G4_UNORM_PACK8(0),
    /**
     * 4-bit-per-channel red/green/blue/alpha channel data format, packed into 16 bits. Values are
     * in the `[0.0, 1.0]` range.
     */
    R4G4B4A4_UNORM_PACK16(1),
    /**
     * 4-bit-per-channel blue/green/red/alpha channel data format, packed into 16 bits. Values are
     * in the `[0.0, 1.0]` range.
     */
    B4G4R4A4_UNORM_PACK16(2),
    /**
     * Red/green/blue channel data format with 5 bits of red, 6 bits of green and 5 bits of blue,
     * packed into 16 bits. Values are in the `[0.0, 1.0]` range.
     */
    R5G6B5_UNORM_PACK16(3),
    /**
     * Blue/green/red channel data format with 5 bits of blue, 6 bits of green and 5 bits of red,
     * packed into 16 bits. Values are in the `[0.0, 1.0]` range.
     */
    B5G6R5_UNORM_PACK16(4),
    /**
     * Red/green/blue/alpha channel data format with 5 bits of red, 6 bits of green, 5 bits of blue
     * and 1 bit of alpha, packed into 16 bits. Values are in the `[0.0, 1.0]` range.
     */
    R5G5B5A1_UNORM_PACK16(5),
    /**
     * Blue/green/red/alpha channel data format with 5 bits of blue, 6 bits of green, 5 bits of red
     * and 1 bit of alpha, packed into 16 bits. Values are in the `[0.0, 1.0]` range.
     */
    B5G5R5A1_UNORM_PACK16(6),
    /**
     * Alpha/red/green/blue channel data format with 1 bit of alpha, 5 bits of red, 6 bits of green
     * and 5 bits of blue, packed into 16 bits. Values are in the `[0.0, 1.0]` range.
     */
    A1R5G5B5_UNORM_PACK16(7),
    /**
     * 8-bit-per-channel unsigned floating-point red channel data format with normalized value.
     * Values are in the `[0.0, 1.0]` range.
     */
    R8_UNORM(8),
    /**
     * 8-bit-per-channel signed floating-point red channel data format with normalized value. Values
     * are in the `[-1.0, 1.0]` range.
     */
    R8_SNORM(9),
    /**
     * 8-bit-per-channel unsigned floating-point red channel data format with scaled value (value is
     * converted from integer to float). Values are in the `[0.0, 255.0]` range.
     */
    R8_USCALED(10),
    /**
     * 8-bit-per-channel signed floating-point red channel data format with scaled value (value is
     * converted from integer to float). Values are in the `[-127.0, 127.0]` range.
     */
    R8_SSCALED(11),
    /**
     * 8-bit-per-channel unsigned integer red channel data format. Values are in the `[0, 255]`
     * range.
     */
    R8_UINT(12),
    /**
     * 8-bit-per-channel signed integer red channel data format. Values are in the `[-127, 127]`
     * range.
     */
    R8_SINT(13),
    /**
     * 8-bit-per-channel unsigned floating-point red channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range.
     */
    R8_SRGB(14),
    /**
     * 8-bit-per-channel unsigned floating-point red/green channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range.
     */
    R8G8_UNORM(15),
    /**
     * 8-bit-per-channel signed floating-point red/green channel data format with normalized value.
     * Values are in the `[-1.0, 1.0]` range.
     */
    R8G8_SNORM(16),
    /**
     * 8-bit-per-channel unsigned floating-point red/green channel data format with scaled value
     * (value is converted from integer to float). Values are in the `[0.0, 255.0]` range.
     */
    R8G8_USCALED(17),
    /**
     * 8-bit-per-channel signed floating-point red/green channel data format with scaled value
     * (value is converted from integer to float). Values are in the `[-127.0, 127.0]` range.
     */
    R8G8_SSCALED(18),
    /**
     * 8-bit-per-channel unsigned integer red/green channel data format. Values are in the `[0,
     * 255]` range.
     */
    R8G8_UINT(19),
    /**
     * 8-bit-per-channel signed integer red/green channel data format. Values are in the `[-127,
     * 127]` range.
     */
    R8G8_SINT(20),
    /**
     * 8-bit-per-channel unsigned floating-point red/green channel data format with normalized value
     * and nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range.
     */
    R8G8_SRGB(21),
    /**
     * 8-bit-per-channel unsigned floating-point red/green/blue channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range.
     */
    R8G8B8_UNORM(22),
    /**
     * 8-bit-per-channel signed floating-point red/green/blue channel data format with normalized
     * value. Values are in the `[-1.0, 1.0]` range.
     */
    R8G8B8_SNORM(23),
    /**
     * 8-bit-per-channel unsigned floating-point red/green/blue channel data format with scaled
     * value (value is converted from integer to float). Values are in the `[0.0, 255.0]` range.
     */
    R8G8B8_USCALED(24),
    /**
     * 8-bit-per-channel signed floating-point red/green/blue channel data format with scaled value
     * (value is converted from integer to float). Values are in the `[-127.0, 127.0]` range.
     */
    R8G8B8_SSCALED(25),
    /**
     * 8-bit-per-channel unsigned integer red/green/blue channel data format. Values are in the `[0,
     * 255]` range.
     */
    R8G8B8_UINT(26),
    /**
     * 8-bit-per-channel signed integer red/green/blue channel data format. Values are in the
     * `[-127, 127]` range.
     */
    R8G8B8_SINT(27),
    /**
     * 8-bit-per-channel unsigned floating-point red/green/blue channel data format with normalized
     * value and nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range.
     */
    R8G8B8_SRGB(28),
    /**
     * 8-bit-per-channel unsigned floating-point blue/green/red channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range.
     */
    B8G8R8_UNORM(29),
    /**
     * 8-bit-per-channel signed floating-point blue/green/red channel data format with normalized
     * value. Values are in the `[-1.0, 1.0]` range.
     */
    B8G8R8_SNORM(30),
    /**
     * 8-bit-per-channel unsigned floating-point blue/green/red channel data format with scaled
     * value (value is converted from integer to float). Values are in the `[0.0, 255.0]` range.
     */
    B8G8R8_USCALED(31),
    /**
     * 8-bit-per-channel signed floating-point blue/green/red channel data format with scaled value
     * (value is converted from integer to float). Values are in the `[-127.0, 127.0]` range.
     */
    B8G8R8_SSCALED(32),
    /**
     * 8-bit-per-channel unsigned integer blue/green/red channel data format. Values are in the `[0,
     * 255]` range.
     */
    B8G8R8_UINT(33),
    /**
     * 8-bit-per-channel signed integer blue/green/red channel data format. Values are in the
     * `[-127, 127]` range.
     */
    B8G8R8_SINT(34),
    /**
     * 8-bit-per-channel unsigned floating-point blue/green/red data format with normalized value
     * and nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range.
     */
    B8G8R8_SRGB(35),
    /**
     * 8-bit-per-channel unsigned floating-point red/green/blue/alpha channel data format with
     * normalized value. Values are in the `[0.0, 1.0]` range.
     */
    R8G8B8A8_UNORM(36),
    /**
     * 8-bit-per-channel signed floating-point red/green/blue/alpha channel data format with
     * normalized value. Values are in the `[-1.0, 1.0]` range.
     */
    R8G8B8A8_SNORM(37),
    /**
     * 8-bit-per-channel unsigned floating-point red/green/blue/alpha channel data format with
     * scaled value (value is converted from integer to float). Values are in the `[0.0, 255.0]` range.
     */
    R8G8B8A8_USCALED(38),
    /**
     * 8-bit-per-channel signed floating-point red/green/blue/alpha channel data format with scaled
     * value (value is converted from integer to float). Values are in the `[-127.0, 127.0]` range.
     */
    R8G8B8A8_SSCALED(39),
    /**
     * 8-bit-per-channel unsigned integer red/green/blue/alpha channel data format. Values are in
     * the `[0, 255]` range.
     */
    R8G8B8A8_UINT(40),
    /**
     * 8-bit-per-channel signed integer red/green/blue/alpha channel data format. Values are in the
     * `[-127, 127]` range.
     */
    R8G8B8A8_SINT(41),
    /**
     * 8-bit-per-channel unsigned floating-point red/green/blue/alpha channel data format with
     * normalized value and nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range.
     */
    R8G8B8A8_SRGB(42),
    /**
     * 8-bit-per-channel unsigned floating-point blue/green/red/alpha channel data format with
     * normalized value. Values are in the `[0.0, 1.0]` range.
     */
    B8G8R8A8_UNORM(43),
    /**
     * 8-bit-per-channel signed floating-point blue/green/red/alpha channel data format with
     * normalized value. Values are in the `[-1.0, 1.0]` range.
     */
    B8G8R8A8_SNORM(44),
    /**
     * 8-bit-per-channel unsigned floating-point blue/green/red/alpha channel data format with
     * scaled value (value is converted from integer to float). Values are in the `[0.0, 255.0]` range.
     */
    B8G8R8A8_USCALED(45),
    /**
     * 8-bit-per-channel signed floating-point blue/green/red/alpha channel data format with scaled
     * value (value is converted from integer to float). Values are in the `[-127.0, 127.0]` range.
     */
    B8G8R8A8_SSCALED(46),
    /**
     * 8-bit-per-channel unsigned integer blue/green/red/alpha channel data format. Values are in
     * the `[0, 255]` range.
     */
    B8G8R8A8_UINT(47),
    /**
     * 8-bit-per-channel signed integer blue/green/red/alpha channel data format. Values are in the
     * `[-127, 127]` range.
     */
    B8G8R8A8_SINT(48),
    /**
     * 8-bit-per-channel unsigned floating-point blue/green/red/alpha channel data format with
     * normalized value and nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range.
     */
    B8G8R8A8_SRGB(49),
    /**
     * 8-bit-per-channel unsigned floating-point alpha/red/green/blue channel data format with
     * normalized value, packed in 32 bits. Values are in the `[0.0, 1.0]` range.
     */
    A8B8G8R8_UNORM_PACK32(50),
    /**
     * 8-bit-per-channel signed floating-point alpha/red/green/blue channel data format with
     * normalized value, packed in 32 bits. Values are in the `[-1.0, 1.0]` range.
     */
    A8B8G8R8_SNORM_PACK32(51),
    /**
     * 8-bit-per-channel unsigned floating-point alpha/red/green/blue channel data format with
     * scaled value (value is converted from integer to float), packed in 32 bits. Values are in the
     * `[0.0, 255.0]` range.
     */
    A8B8G8R8_USCALED_PACK32(52),
    /**
     * 8-bit-per-channel signed floating-point alpha/red/green/blue channel data format with scaled
     * value (value is converted from integer to float), packed in 32 bits. Values are in the `[-127.0,
     * 127.0]` range.
     */
    A8B8G8R8_SSCALED_PACK32(53),
    /**
     * 8-bit-per-channel unsigned integer alpha/red/green/blue channel data format, packed in 32
     * bits. Values are in the `[0, 255]` range.
     */
    A8B8G8R8_UINT_PACK32(54),
    /**
     * 8-bit-per-channel signed integer alpha/red/green/blue channel data format, packed in 32 bits.
     * Values are in the `[-127, 127]` range.
     */
    A8B8G8R8_SINT_PACK32(55),
    /**
     * 8-bit-per-channel unsigned floating-point alpha/red/green/blue channel data format with
     * normalized value and nonlinear sRGB encoding, packed in 32 bits. Values are in the `[0.0, 1.0]`
     * range.
     */
    A8B8G8R8_SRGB_PACK32(56),
    /**
     * Unsigned floating-point alpha/red/green/blue channel data format with normalized value,
     * packed in 32 bits. Format contains 2 bits of alpha, 10 bits of red, 10 bits of green and 10 bits
     * of blue. Values are in the `[0.0, 1.0]` range.
     */
    A2R10G10B10_UNORM_PACK32(57),
    /**
     * Signed floating-point alpha/red/green/blue channel data format with normalized value, packed
     * in 32 bits. Format contains 2 bits of alpha, 10 bits of red, 10 bits of green and 10 bits of
     * blue. Values are in the `[-1.0, 1.0]` range.
     */
    A2R10G10B10_SNORM_PACK32(58),
    /**
     * Unsigned floating-point alpha/red/green/blue channel data format with normalized value,
     * packed in 32 bits. Format contains 2 bits of alpha, 10 bits of red, 10 bits of green and 10 bits
     * of blue. Values are in the `[0.0, 1023.0]` range for red/green/blue and `[0.0, 3.0]` for alpha.
     */
    A2R10G10B10_USCALED_PACK32(59),
    /**
     * Signed floating-point alpha/red/green/blue channel data format with normalized value, packed
     * in 32 bits. Format contains 2 bits of alpha, 10 bits of red, 10 bits of green and 10 bits of
     * blue. Values are in the `[-511.0, 511.0]` range for red/green/blue and `[-1.0, 1.0]` for alpha.
     */
    A2R10G10B10_SSCALED_PACK32(60),
    /**
     * Unsigned integer alpha/red/green/blue channel data format with normalized value, packed in 32
     * bits. Format contains 2 bits of alpha, 10 bits of red, 10 bits of green and 10 bits of blue.
     * Values are in the `[0, 1023]` range for red/green/blue and `[0, 3]` for alpha.
     */
    A2R10G10B10_UINT_PACK32(61),
    /**
     * Signed integer alpha/red/green/blue channel data format with normalized value, packed in 32
     * bits. Format contains 2 bits of alpha, 10 bits of red, 10 bits of green and 10 bits of blue.
     * Values are in the `[-511, 511]` range for red/green/blue and `[-1, 1]` for alpha.
     */
    A2R10G10B10_SINT_PACK32(62),
    /**
     * Unsigned floating-point alpha/blue/green/red channel data format with normalized value,
     * packed in 32 bits. Format contains 2 bits of alpha, 10 bits of blue, 10 bits of green and 10
     * bits of red. Values are in the `[0.0, 1.0]` range.
     */
    A2B10G10R10_UNORM_PACK32(63),
    /**
     * Signed floating-point alpha/blue/green/red channel data format with normalized value, packed
     * in 32 bits. Format contains 2 bits of alpha, 10 bits of blue, 10 bits of green and 10 bits of
     * red. Values are in the `[-1.0, 1.0]` range.
     */
    A2B10G10R10_SNORM_PACK32(64),
    /**
     * Unsigned floating-point alpha/blue/green/red channel data format with normalized value,
     * packed in 32 bits. Format contains 2 bits of alpha, 10 bits of blue, 10 bits of green and 10
     * bits of red. Values are in the `[0.0, 1023.0]` range for blue/green/red and `[0.0, 3.0]` for
     * alpha.
     */
    A2B10G10R10_USCALED_PACK32(65),
    /**
     * Signed floating-point alpha/blue/green/red channel data format with normalized value, packed
     * in 32 bits. Format contains 2 bits of alpha, 10 bits of blue, 10 bits of green and 10 bits of
     * red. Values are in the `[-511.0, 511.0]` range for blue/green/red and `[-1.0, 1.0]` for alpha.
     */
    A2B10G10R10_SSCALED_PACK32(66),
    /**
     * Unsigned integer alpha/blue/green/red channel data format with normalized value, packed in 32
     * bits. Format contains 2 bits of alpha, 10 bits of blue, 10 bits of green and 10 bits of red.
     * Values are in the `[0, 1023]` range for blue/green/red and `[0, 3]` for alpha.
     */
    A2B10G10R10_UINT_PACK32(67),
    /**
     * Signed integer alpha/blue/green/red channel data format with normalized value, packed in 32
     * bits. Format contains 2 bits of alpha, 10 bits of blue, 10 bits of green and 10 bits of red.
     * Values are in the `[-511, 511]` range for blue/green/red and `[-1, 1]` for alpha.
     */
    A2B10G10R10_SINT_PACK32(68),
    /**
     * 16-bit-per-channel unsigned floating-point red channel data format with normalized value.
     * Values are in the `[0.0, 1.0]` range.
     */
    R16_UNORM(69),
    /**
     * 16-bit-per-channel signed floating-point red channel data format with normalized value.
     * Values are in the `[-1.0, 1.0]` range.
     */
    R16_SNORM(70),
    /**
     * 16-bit-per-channel unsigned floating-point red channel data format with scaled value (value
     * is converted from integer to float). Values are in the `[0.0, 65535.0]` range.
     */
    R16_USCALED(71),
    /**
     * 16-bit-per-channel signed floating-point red channel data format with scaled value (value is
     * converted from integer to float). Values are in the `[-32767.0, 32767.0]` range.
     */
    R16_SSCALED(72),
    /**
     * 16-bit-per-channel unsigned integer red channel data format. Values are in the `[0.0, 65535]`
     * range.
     */
    R16_UINT(73),
    /**
     * 16-bit-per-channel signed integer red channel data format. Values are in the `[-32767,
     * 32767]` range.
     */
    R16_SINT(74),
    /**
     * 16-bit-per-channel signed floating-point red channel data format with the value stored as-is.
     */
    R16_SFLOAT(75),
    /**
     * 16-bit-per-channel unsigned floating-point red/green channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range.
     */
    R16G16_UNORM(76),
    /**
     * 16-bit-per-channel signed floating-point red/green channel data format with normalized value.
     * Values are in the `[-1.0, 1.0]` range.
     */
    R16G16_SNORM(77),
    /**
     * 16-bit-per-channel unsigned floating-point red/green channel data format with scaled value
     * (value is converted from integer to float). Values are in the `[0.0, 65535.0]` range.
     */
    R16G16_USCALED(78),
    /**
     * 16-bit-per-channel signed floating-point red/green channel data format with scaled value
     * (value is converted from integer to float). Values are in the `[-32767.0, 32767.0]` range.
     */
    R16G16_SSCALED(79),
    /**
     * 16-bit-per-channel unsigned integer red/green channel data format. Values are in the `[0.0,
     * 65535]` range.
     */
    R16G16_UINT(80),
    /**
     * 16-bit-per-channel signed integer red/green channel data format. Values are in the `[-32767,
     * 32767]` range.
     */
    R16G16_SINT(81),
    /**
     * 16-bit-per-channel signed floating-point red/green channel data format with the value stored
     * as-is.
     */
    R16G16_SFLOAT(82),
    /**
     * 16-bit-per-channel unsigned floating-point red/green/blue channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range.
     */
    R16G16B16_UNORM(83),
    /**
     * 16-bit-per-channel signed floating-point red/green/blue channel data format with normalized
     * value. Values are in the `[-1.0, 1.0]` range.
     */
    R16G16B16_SNORM(84),
    /**
     * 16-bit-per-channel unsigned floating-point red/green/blue channel data format with scaled
     * value (value is converted from integer to float). Values are in the `[0.0, 65535.0]` range.
     */
    R16G16B16_USCALED(85),
    /**
     * 16-bit-per-channel signed floating-point red/green/blue channel data format with scaled value
     * (value is converted from integer to float). Values are in the `[-32767.0, 32767.0]` range.
     */
    R16G16B16_SSCALED(86),
    /**
     * 16-bit-per-channel unsigned integer red/green/blue channel data format. Values are in the
     * `[0.0, 65535]` range.
     */
    R16G16B16_UINT(87),
    /**
     * 16-bit-per-channel signed integer red/green/blue channel data format. Values are in the
     * `[-32767, 32767]` range.
     */
    R16G16B16_SINT(88),
    /**
     * 16-bit-per-channel signed floating-point red/green/blue channel data format with the value
     * stored as-is.
     */
    R16G16B16_SFLOAT(89),
    /**
     * 16-bit-per-channel unsigned floating-point red/green/blue/alpha channel data format with
     * normalized value. Values are in the `[0.0, 1.0]` range.
     */
    R16G16B16A16_UNORM(90),
    /**
     * 16-bit-per-channel signed floating-point red/green/blue/alpha channel data format with
     * normalized value. Values are in the `[-1.0, 1.0]` range.
     */
    R16G16B16A16_SNORM(91),
    /**
     * 16-bit-per-channel unsigned floating-point red/green/blue/alpha channel data format with
     * scaled value (value is converted from integer to float). Values are in the `[0.0, 65535.0]`
     * range.
     */
    R16G16B16A16_USCALED(92),
    /**
     * 16-bit-per-channel signed floating-point red/green/blue/alpha channel data format with scaled
     * value (value is converted from integer to float). Values are in the `[-32767.0, 32767.0]` range.
     */
    R16G16B16A16_SSCALED(93),
    /**
     * 16-bit-per-channel unsigned integer red/green/blue/alpha channel data format. Values are in
     * the `[0.0, 65535]` range.
     */
    R16G16B16A16_UINT(94),
    /**
     * 16-bit-per-channel signed integer red/green/blue/alpha channel data format. Values are in the
     * `[-32767, 32767]` range.
     */
    R16G16B16A16_SINT(95),
    /**
     * 16-bit-per-channel signed floating-point red/green/blue/alpha channel data format with the
     * value stored as-is.
     */
    R16G16B16A16_SFLOAT(96),
    /**
     * 32-bit-per-channel unsigned integer red channel data format. Values are in the `[0, 2^32 -
     * 1]` range.
     */
    R32_UINT(97),
    /**
     * 32-bit-per-channel signed integer red channel data format. Values are in the `[2^31 + 1,
     * 2^31 - 1]` range.
     */
    R32_SINT(98),
    /**
     * 32-bit-per-channel signed floating-point red channel data format with the value stored as-is.
     */
    R32_SFLOAT(99),
    /**
     * 32-bit-per-channel unsigned integer red/green channel data format. Values are in the `[0,
     * 2^32 - 1]` range.
     */
    R32G32_UINT(100),
    /**
     * 32-bit-per-channel signed integer red/green channel data format. Values are in the `[2^31 +
     * 1, 2^31 - 1]` range.
     */
    R32G32_SINT(101),
    /**
     * 32-bit-per-channel signed floating-point red/green channel data format with the value stored
     * as-is.
     */
    R32G32_SFLOAT(102),
    /**
     * 32-bit-per-channel unsigned integer red/green/blue channel data format. Values are in the
     * `[0, 2^32 - 1]` range.
     */
    R32G32B32_UINT(103),
    /**
     * 32-bit-per-channel signed integer red/green/blue channel data format. Values are in the
     * `[2^31 + 1, 2^31 - 1]` range.
     */
    R32G32B32_SINT(104),
    /**
     * 32-bit-per-channel signed floating-point red/green/blue channel data format with the value
     * stored as-is.
     */
    R32G32B32_SFLOAT(105),
    /**
     * 32-bit-per-channel unsigned integer red/green/blue/alpha channel data format. Values are in
     * the `[0, 2^32 - 1]` range.
     */
    R32G32B32A32_UINT(106),
    /**
     * 32-bit-per-channel signed integer red/green/blue/alpha channel data format. Values are in the
     * `[2^31 + 1, 2^31 - 1]` range.
     */
    R32G32B32A32_SINT(107),
    /**
     * 32-bit-per-channel signed floating-point red/green/blue/alpha channel data format with the
     * value stored as-is.
     */
    R32G32B32A32_SFLOAT(108),
    /**
     * 64-bit-per-channel unsigned integer red channel data format. Values are in the `[0, 2^64 -
     * 1]` range.
     */
    R64_UINT(109),
    /**
     * 64-bit-per-channel signed integer red channel data format. Values are in the `[2^63 + 1,
     * 2^63 - 1]` range.
     */
    R64_SINT(110),
    /**
     * 64-bit-per-channel signed floating-point red channel data format with the value stored as-is.
     */
    R64_SFLOAT(111),
    /**
     * 64-bit-per-channel unsigned integer red/green channel data format. Values are in the `[0,
     * 2^64 - 1]` range.
     */
    R64G64_UINT(112),
    /**
     * 64-bit-per-channel signed integer red/green channel data format. Values are in the `[2^63 +
     * 1, 2^63 - 1]` range.
     */
    R64G64_SINT(113),
    /**
     * 64-bit-per-channel signed floating-point red/green channel data format with the value stored
     * as-is.
     */
    R64G64_SFLOAT(114),
    /**
     * 64-bit-per-channel unsigned integer red/green/blue channel data format. Values are in the
     * `[0, 2^64 - 1]` range.
     */
    R64G64B64_UINT(115),
    /**
     * 64-bit-per-channel signed integer red/green/blue channel data format. Values are in the
     * `[2^63 + 1, 2^63 - 1]` range.
     */
    R64G64B64_SINT(116),
    /**
     * 64-bit-per-channel signed floating-point red/green/blue channel data format with the value
     * stored as-is.
     */
    R64G64B64_SFLOAT(117),
    /**
     * 64-bit-per-channel unsigned integer red/green/blue/alpha channel data format. Values are in
     * the `[0, 2^64 - 1]` range.
     */
    R64G64B64A64_UINT(118),
    /**
     * 64-bit-per-channel signed integer red/green/blue/alpha channel data format. Values are in the
     * `[2^63 + 1, 2^63 - 1]` range.
     */
    R64G64B64A64_SINT(119),
    /**
     * 64-bit-per-channel signed floating-point red/green/blue/alpha channel data format with the
     * value stored as-is.
     */
    R64G64B64A64_SFLOAT(120),
    /**
     * Unsigned floating-point blue/green/red data format with the value stored as-is, packed in 32
     * bits. The format's precision is 10 bits of blue channel, 11 bits of green channel and 11 bits of
     * red channel.
     */
    B10G11R11_UFLOAT_PACK32(121),
    /**
     * Unsigned floating-point exposure/blue/green/red data format with the value stored as-is,
     * packed in 32 bits. The format's precision is 5 bits of exposure, 9 bits of blue channel, 9 bits
     * of green channel and 9 bits of red channel.
     */
    E5B9G9R9_UFLOAT_PACK32(122),
    /**
     * 16-bit unsigned floating-point depth data format with normalized value. Values are in the
     * `[0.0, 1.0]` range.
     */
    D16_UNORM(123),
    /**
     * 24-bit unsigned floating-point depth data format with normalized value, plus 8 unused bits,
     * packed in 32 bits. Values for depth are in the `[0.0, 1.0]` range.
     */
    X8_D24_UNORM_PACK32(124),
    /**
     * 32-bit signed floating-point depth data format with the value stored as-is.
     */
    D32_SFLOAT(125),
    /**
     * 8-bit unsigned integer stencil data format.
     */
    S8_UINT(126),
    /**
     * 16-bit unsigned floating-point depth data format with normalized value, plus 8 bits of
     * stencil in unsigned integer format. Values for depth are in the `[0.0, 1.0]` range. Values for
     * stencil are in the `[0, 255]` range.
     */
    D16_UNORM_S8_UINT(127),
    /**
     * 24-bit unsigned floating-point depth data format with normalized value, plus 8 bits of
     * stencil in unsigned integer format. Values for depth are in the `[0.0, 1.0]` range. Values for
     * stencil are in the `[0, 255]` range.
     */
    D24_UNORM_S8_UINT(128),
    /**
     * 32-bit signed floating-point depth data format with the value stored as-is, plus 8 bits of
     * stencil in unsigned integer format. Values for stencil are in the `[0, 255]` range.
     */
    D32_SFLOAT_S8_UINT(129),
    /**
     * VRAM-compressed unsigned red/green/blue channel data format with normalized value. Values are
     * in the `[0.0, 1.0]` range. The format's precision is 5 bits of red channel, 6 bits of green
     * channel and 5 bits of blue channel. Using BC1 texture compression (also known as S3TC DXT1).
     */
    BC1_RGB_UNORM_BLOCK(130),
    /**
     * VRAM-compressed unsigned red/green/blue channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range. The format's precision is 5 bits
     * of red channel, 6 bits of green channel, and 5 bits of blue channel. Using BC1 texture
     * compression (also known as S3TC DXT1).
     */
    BC1_RGB_SRGB_BLOCK(131),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value.
     * Values are in the `[0.0, 1.0]` range. The format's precision is 5 bits of red channel, 6 bits of
     * green channel, 5 bits of blue channel and 1 bit of alpha channel. Using BC1 texture compression
     * (also known as S3TC DXT1).
     */
    BC1_RGBA_UNORM_BLOCK(132),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range. The format's precision is 5 bits
     * of red channel, 6 bits of green channel, 5 bits of blue channel, and 1 bit of alpha channel.
     * Using BC1 texture compression (also known as S3TC DXT1).
     */
    BC1_RGBA_SRGB_BLOCK(133),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value.
     * Values are in the `[0.0, 1.0]` range. The format's precision is 5 bits of red channel, 6 bits of
     * green channel, 5 bits of blue channel and 4 bits of alpha channel. Using BC2 texture compression
     * (also known as S3TC DXT3).
     */
    BC2_UNORM_BLOCK(134),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range. The format's precision is 5 bits
     * of red channel, 6 bits of green channel, 5 bits of blue channel, and 4 bits of alpha channel.
     * Using BC2 texture compression (also known as S3TC DXT3).
     */
    BC2_SRGB_BLOCK(135),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value.
     * Values are in the `[0.0, 1.0]` range. The format's precision is 5 bits of red channel, 6 bits of
     * green channel, 5 bits of blue channel and 8 bits of alpha channel. Using BC3 texture compression
     * (also known as S3TC DXT5).
     */
    BC3_UNORM_BLOCK(136),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range. The format's precision is 5 bits
     * of red channel, 6 bits of green channel, 5 bits of blue channel, and 8 bits of alpha channel.
     * Using BC3 texture compression (also known as S3TC DXT5).
     */
    BC3_SRGB_BLOCK(137),
    /**
     * VRAM-compressed unsigned red channel data format with normalized value. Values are in the
     * `[0.0, 1.0]` range. The format's precision is 8 bits of red channel. Using BC4 texture
     * compression.
     */
    BC4_UNORM_BLOCK(138),
    /**
     * VRAM-compressed signed red channel data format with normalized value. Values are in the
     * `[-1.0, 1.0]` range. The format's precision is 8 bits of red channel. Using BC4 texture
     * compression.
     */
    BC4_SNORM_BLOCK(139),
    /**
     * VRAM-compressed unsigned red/green channel data format with normalized value. Values are in
     * the `[0.0, 1.0]` range. The format's precision is 8 bits of red channel and 8 bits of green
     * channel. Using BC5 texture compression (also known as S3TC RGTC).
     */
    BC5_UNORM_BLOCK(140),
    /**
     * VRAM-compressed signed red/green channel data format with normalized value. Values are in the
     * `[-1.0, 1.0]` range. The format's precision is 8 bits of red channel and 8 bits of green
     * channel. Using BC5 texture compression (also known as S3TC RGTC).
     */
    BC5_SNORM_BLOCK(141),
    /**
     * VRAM-compressed unsigned red/green/blue channel data format with the floating-point value
     * stored as-is. The format's precision is between 10 and 13 bits for the red/green/blue channels.
     * Using BC6H texture compression (also known as BPTC HDR).
     */
    BC6H_UFLOAT_BLOCK(142),
    /**
     * VRAM-compressed signed red/green/blue channel data format with the floating-point value
     * stored as-is. The format's precision is between 10 and 13 bits for the red/green/blue channels.
     * Using BC6H texture compression (also known as BPTC HDR).
     */
    BC6H_SFLOAT_BLOCK(143),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value.
     * Values are in the `[0.0, 1.0]` range. The format's precision is between 4 and 7 bits for the
     * red/green/blue channels and between 0 and 8 bits for the alpha channel. Also known as BPTC LDR.
     */
    BC7_UNORM_BLOCK(144),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range. The format's precision is between
     * 4 and 7 bits for the red/green/blue channels and between 0 and 8 bits for the alpha channel.
     * Also known as BPTC LDR.
     */
    BC7_SRGB_BLOCK(145),
    /**
     * VRAM-compressed unsigned red/green/blue channel data format with normalized value. Values are
     * in the `[0.0, 1.0]` range. Using ETC2 texture compression.
     */
    ETC2_R8G8B8_UNORM_BLOCK(146),
    /**
     * VRAM-compressed unsigned red/green/blue channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range. Using ETC2 texture compression.
     */
    ETC2_R8G8B8_SRGB_BLOCK(147),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value.
     * Values are in the `[0.0, 1.0]` range. Red/green/blue use 8 bit of precision each, with alpha
     * using 1 bit of precision. Using ETC2 texture compression.
     */
    ETC2_R8G8B8A1_UNORM_BLOCK(148),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range. Red/green/blue use 8 bit of
     * precision each, with alpha using 1 bit of precision. Using ETC2 texture compression.
     */
    ETC2_R8G8B8A1_SRGB_BLOCK(149),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value.
     * Values are in the `[0.0, 1.0]` range. Red/green/blue use 8 bits of precision each, with alpha
     * using 8 bits of precision. Using ETC2 texture compression.
     */
    ETC2_R8G8B8A8_UNORM_BLOCK(150),
    /**
     * VRAM-compressed unsigned red/green/blue/alpha channel data format with normalized value and
     * nonlinear sRGB encoding. Values are in the `[0.0, 1.0]` range. Red/green/blue use 8 bits of
     * precision each, with alpha using 8 bits of precision. Using ETC2 texture compression.
     */
    ETC2_R8G8B8A8_SRGB_BLOCK(151),
    /**
     * 11-bit VRAM-compressed unsigned red channel data format with normalized value. Values are in
     * the `[0.0, 1.0]` range. Using ETC2 texture compression.
     */
    EAC_R11_UNORM_BLOCK(152),
    /**
     * 11-bit VRAM-compressed signed red channel data format with normalized value. Values are in
     * the `[-1.0, 1.0]` range. Using ETC2 texture compression.
     */
    EAC_R11_SNORM_BLOCK(153),
    /**
     * 11-bit VRAM-compressed unsigned red/green channel data format with normalized value. Values
     * are in the `[0.0, 1.0]` range. Using ETC2 texture compression.
     */
    EAC_R11G11_UNORM_BLOCK(154),
    /**
     * 11-bit VRAM-compressed signed red/green channel data format with normalized value. Values are
     * in the `[-1.0, 1.0]` range. Using ETC2 texture compression.
     */
    EAC_R11G11_SNORM_BLOCK(155),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 4×4
     * blocks (highest quality). Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_4x4_UNORM_BLOCK(156),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 4×4 blocks (highest quality). Values are in the `[0.0, 1.0]` range. Using
     * ASTC compression.
     */
    ASTC_4x4_SRGB_BLOCK(157),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 5×4
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_5x4_UNORM_BLOCK(158),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 5×4 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_5x4_SRGB_BLOCK(159),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 5×5
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_5x5_UNORM_BLOCK(160),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 5×5 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_5x5_SRGB_BLOCK(161),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 6×5
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_6x5_UNORM_BLOCK(162),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 6×5 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_6x5_SRGB_BLOCK(163),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 6×6
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_6x6_UNORM_BLOCK(164),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 6×6 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_6x6_SRGB_BLOCK(165),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 8×5
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_8x5_UNORM_BLOCK(166),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 8×5 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_8x5_SRGB_BLOCK(167),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 8×6
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_8x6_UNORM_BLOCK(168),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 8×6 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_8x6_SRGB_BLOCK(169),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 8×8
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_8x8_UNORM_BLOCK(170),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 8×8 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_8x8_SRGB_BLOCK(171),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 10×5
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_10x5_UNORM_BLOCK(172),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 10×5 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_10x5_SRGB_BLOCK(173),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 10×6
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_10x6_UNORM_BLOCK(174),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 10×6 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_10x6_SRGB_BLOCK(175),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 10×8
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_10x8_UNORM_BLOCK(176),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 10×8 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_10x8_SRGB_BLOCK(177),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 10×10
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_10x10_UNORM_BLOCK(178),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 10×10 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_10x10_SRGB_BLOCK(179),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 12×10
     * blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_12x10_UNORM_BLOCK(180),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 12×10 blocks. Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_12x10_SRGB_BLOCK(181),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value, packed in 12
     * blocks (lowest quality). Values are in the `[0.0, 1.0]` range. Using ASTC compression.
     */
    ASTC_12x12_UNORM_BLOCK(182),
    /**
     * VRAM-compressed unsigned floating-point data format with normalized value and nonlinear sRGB
     * encoding, packed in 12 blocks (lowest quality). Values are in the `[0.0, 1.0]` range. Using ASTC
     * compression.
     */
    ASTC_12x12_SRGB_BLOCK(183),
    /**
     * 8-bit-per-channel unsigned floating-point green/blue/red channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at halved
     * horizontal resolution (i.e. 2 horizontally adjacent pixels will share the same value for the
     * blue/red channel).
     */
    G8B8G8R8_422_UNORM(184),
    /**
     * 8-bit-per-channel unsigned floating-point blue/green/red channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at halved
     * horizontal resolution (i.e. 2 horizontally adjacent pixels will share the same value for the
     * blue/red channel).
     */
    B8G8R8G8_422_UNORM(185),
    /**
     * 8-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * stored across 3 separate planes (green + blue + red). Values are in the `[0.0, 1.0]` range. Blue
     * and red channel data is stored at halved horizontal and vertical resolution (i.e. 2×2 adjacent
     * pixels will share the same value for the blue/red channel).
     */
    G8_B8_R8_3PLANE_420_UNORM(186),
    /**
     * 8-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * stored across 2 separate planes (green + blue/red). Values are in the `[0.0, 1.0]` range. Blue
     * and red channel data is stored at halved horizontal and vertical resolution (i.e. 2×2 adjacent
     * pixels will share the same value for the blue/red channel).
     */
    G8_B8R8_2PLANE_420_UNORM(187),
    /**
     * 8-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * stored across 2 separate planes (green + blue + red). Values are in the `[0.0, 1.0]` range. Blue
     * and red channel data is stored at halved horizontal resolution (i.e. 2 horizontally adjacent
     * pixels will share the same value for the blue/red channel).
     */
    G8_B8_R8_3PLANE_422_UNORM(188),
    /**
     * 8-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * stored across 2 separate planes (green + blue/red). Values are in the `[0.0, 1.0]` range. Blue
     * and red channel data is stored at halved horizontal resolution (i.e. 2 horizontally adjacent
     * pixels will share the same value for the blue/red channel).
     */
    G8_B8R8_2PLANE_422_UNORM(189),
    /**
     * 8-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * stored across 3 separate planes. Values are in the `[0.0, 1.0]` range.
     */
    G8_B8_R8_3PLANE_444_UNORM(190),
    /**
     * 10-bit-per-channel unsigned floating-point red channel data with normalized value, plus 6
     * unused bits, packed in 16 bits. Values are in the `[0.0, 1.0]` range.
     */
    R10X6_UNORM_PACK16(191),
    /**
     * 10-bit-per-channel unsigned floating-point red/green channel data with normalized value, plus
     * 6 unused bits after each channel, packed in 2×16 bits. Values are in the `[0.0, 1.0]` range.
     */
    R10X6G10X6_UNORM_2PACK16(192),
    /**
     * 10-bit-per-channel unsigned floating-point red/green/blue/alpha channel data with normalized
     * value, plus 6 unused bits after each channel, packed in 4×16 bits. Values are in the `[0.0,
     * 1.0]` range.
     */
    R10X6G10X6B10X6A10X6_UNORM_4PACK16(193),
    /**
     * 10-bit-per-channel unsigned floating-point green/blue/green/red channel data with normalized
     * value, plus 6 unused bits after each channel, packed in 4×16 bits. Values are in the `[0.0,
     * 1.0]` range. Blue and red channel data is stored at halved horizontal resolution (i.e. 2
     * horizontally adjacent pixels will share the same value for the blue/red channel). The green
     * channel is listed twice, but contains different values to allow it to be represented at full
     * resolution.
     */
    G10X6B10X6G10X6R10X6_422_UNORM_4PACK16(194),
    /**
     * 10-bit-per-channel unsigned floating-point blue/green/red/green channel data with normalized
     * value, plus 6 unused bits after each channel, packed in 4×16 bits. Values are in the `[0.0,
     * 1.0]` range. Blue and red channel data is stored at halved horizontal resolution (i.e. 2
     * horizontally adjacent pixels will share the same value for the blue/red channel). The green
     * channel is listed twice, but contains different values to allow it to be represented at full
     * resolution.
     */
    B10X6G10X6R10X6G10X6_422_UNORM_4PACK16(195),
    /**
     * 10-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 2 separate planes
     * (green + blue + red). Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored
     * at halved horizontal and vertical resolution (i.e. 2×2 adjacent pixels will share the same value
     * for the blue/red channel).
     */
    G10X6_B10X6_R10X6_3PLANE_420_UNORM_3PACK16(196),
    /**
     * 10-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 2 separate planes
     * (green + blue/red). Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at
     * halved horizontal and vertical resolution (i.e. 2×2 adjacent pixels will share the same value
     * for the blue/red channel).
     */
    G10X6_B10X6R10X6_2PLANE_420_UNORM_3PACK16(197),
    /**
     * 10-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 3 separate planes
     * (green + blue + red). Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored
     * at halved horizontal resolution (i.e. 2 horizontally adjacent pixels will share the same value
     * for the blue/red channel).
     */
    G10X6_B10X6_R10X6_3PLANE_422_UNORM_3PACK16(198),
    /**
     * 10-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 3 separate planes
     * (green + blue/red). Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at
     * halved horizontal resolution (i.e. 2 horizontally adjacent pixels will share the same value for
     * the blue/red channel).
     */
    G10X6_B10X6R10X6_2PLANE_422_UNORM_3PACK16(199),
    /**
     * 10-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 3 separate planes
     * (green + blue + red). Values are in the `[0.0, 1.0]` range.
     */
    G10X6_B10X6_R10X6_3PLANE_444_UNORM_3PACK16(200),
    /**
     * 12-bit-per-channel unsigned floating-point red channel data with normalized value, plus 6
     * unused bits, packed in 16 bits. Values are in the `[0.0, 1.0]` range.
     */
    R12X4_UNORM_PACK16(201),
    /**
     * 12-bit-per-channel unsigned floating-point red/green channel data with normalized value, plus
     * 6 unused bits after each channel, packed in 2×16 bits. Values are in the `[0.0, 1.0]` range.
     */
    R12X4G12X4_UNORM_2PACK16(202),
    /**
     * 12-bit-per-channel unsigned floating-point red/green/blue/alpha channel data with normalized
     * value, plus 6 unused bits after each channel, packed in 4×16 bits. Values are in the `[0.0,
     * 1.0]` range.
     */
    R12X4G12X4B12X4A12X4_UNORM_4PACK16(203),
    /**
     * 12-bit-per-channel unsigned floating-point green/blue/green/red channel data with normalized
     * value, plus 6 unused bits after each channel, packed in 4×16 bits. Values are in the `[0.0,
     * 1.0]` range. Blue and red channel data is stored at halved horizontal resolution (i.e. 2
     * horizontally adjacent pixels will share the same value for the blue/red channel). The green
     * channel is listed twice, but contains different values to allow it to be represented at full
     * resolution.
     */
    G12X4B12X4G12X4R12X4_422_UNORM_4PACK16(204),
    /**
     * 12-bit-per-channel unsigned floating-point blue/green/red/green channel data with normalized
     * value, plus 6 unused bits after each channel, packed in 4×16 bits. Values are in the `[0.0,
     * 1.0]` range. Blue and red channel data is stored at halved horizontal resolution (i.e. 2
     * horizontally adjacent pixels will share the same value for the blue/red channel). The green
     * channel is listed twice, but contains different values to allow it to be represented at full
     * resolution.
     */
    B12X4G12X4R12X4G12X4_422_UNORM_4PACK16(205),
    /**
     * 12-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 2 separate planes
     * (green + blue + red). Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored
     * at halved horizontal and vertical resolution (i.e. 2×2 adjacent pixels will share the same value
     * for the blue/red channel).
     */
    G12X4_B12X4_R12X4_3PLANE_420_UNORM_3PACK16(206),
    /**
     * 12-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 2 separate planes
     * (green + blue/red). Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at
     * halved horizontal and vertical resolution (i.e. 2×2 adjacent pixels will share the same value
     * for the blue/red channel).
     */
    G12X4_B12X4R12X4_2PLANE_420_UNORM_3PACK16(207),
    /**
     * 12-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 3 separate planes
     * (green + blue + red). Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored
     * at halved horizontal resolution (i.e. 2 horizontally adjacent pixels will share the same value
     * for the blue/red channel).
     */
    G12X4_B12X4_R12X4_3PLANE_422_UNORM_3PACK16(208),
    /**
     * 12-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 3 separate planes
     * (green + blue/red). Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at
     * halved horizontal resolution (i.e. 2 horizontally adjacent pixels will share the same value for
     * the blue/red channel).
     */
    G12X4_B12X4R12X4_2PLANE_422_UNORM_3PACK16(209),
    /**
     * 12-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Packed in 3×16 bits and stored across 3 separate planes
     * (green + blue + red). Values are in the `[0.0, 1.0]` range.
     */
    G12X4_B12X4_R12X4_3PLANE_444_UNORM_3PACK16(210),
    /**
     * 16-bit-per-channel unsigned floating-point green/blue/red channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at halved
     * horizontal resolution (i.e. 2 horizontally adjacent pixels will share the same value for the
     * blue/red channel).
     */
    G16B16G16R16_422_UNORM(211),
    /**
     * 16-bit-per-channel unsigned floating-point blue/green/red channel data format with normalized
     * value. Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at halved
     * horizontal resolution (i.e. 2 horizontally adjacent pixels will share the same value for the
     * blue/red channel).
     */
    B16G16R16G16_422_UNORM(212),
    /**
     * 16-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Stored across 2 separate planes (green + blue + red).
     * Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at halved horizontal
     * and vertical resolution (i.e. 2×2 adjacent pixels will share the same value for the blue/red
     * channel).
     */
    G16_B16_R16_3PLANE_420_UNORM(213),
    /**
     * 16-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Stored across 2 separate planes (green + blue/red).
     * Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at halved horizontal
     * and vertical resolution (i.e. 2×2 adjacent pixels will share the same value for the blue/red
     * channel).
     */
    G16_B16R16_2PLANE_420_UNORM(214),
    /**
     * 16-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Stored across 3 separate planes (green + blue + red).
     * Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at halved horizontal
     * resolution (i.e. 2 horizontally adjacent pixels will share the same value for the blue/red
     * channel).
     */
    G16_B16_R16_3PLANE_422_UNORM(215),
    /**
     * 16-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Stored across 3 separate planes (green + blue/red).
     * Values are in the `[0.0, 1.0]` range. Blue and red channel data is stored at halved horizontal
     * resolution (i.e. 2 horizontally adjacent pixels will share the same value for the blue/red
     * channel).
     */
    G16_B16R16_2PLANE_422_UNORM(216),
    /**
     * 16-bit-per-channel unsigned floating-point green/blue/red channel data with normalized value,
     * plus 6 unused bits after each channel. Stored across 3 separate planes (green + blue + red).
     * Values are in the `[0.0, 1.0]` range.
     */
    G16_B16_R16_3PLANE_444_UNORM(217),
    ASTC_4x4_SFLOAT_BLOCK(218),
    ASTC_5x4_SFLOAT_BLOCK(219),
    ASTC_5x5_SFLOAT_BLOCK(220),
    ASTC_6x5_SFLOAT_BLOCK(221),
    ASTC_6x6_SFLOAT_BLOCK(222),
    ASTC_8x5_SFLOAT_BLOCK(223),
    ASTC_8x6_SFLOAT_BLOCK(224),
    ASTC_8x8_SFLOAT_BLOCK(225),
    ASTC_10x5_SFLOAT_BLOCK(226),
    ASTC_10x6_SFLOAT_BLOCK(227),
    ASTC_10x8_SFLOAT_BLOCK(228),
    ASTC_10x10_SFLOAT_BLOCK(229),
    ASTC_12x10_SFLOAT_BLOCK(230),
    ASTC_12x12_SFLOAT_BLOCK(231),
    /**
     * Represents the size of the [DataFormat] enum.
     */
    MAX(232),
    ;

    public companion object {
      public fun from(`value`: Long): DataFormat = entries.single { it.`value` == `value` }
    }
  }

  public class BarrierMask(
    flag: Long,
  ) : BitFieldBase<BarrierMask>(flag) {
    protected override fun wrap(flag: Long): BarrierMask = BarrierMask(flag)

    public companion object {
      /**
       * Vertex shader barrier mask.
       */
      @JvmField
      public val VERTEX: BarrierMask = BarrierMask(1)

      /**
       * Fragment shader barrier mask.
       */
      @JvmField
      public val FRAGMENT: BarrierMask = BarrierMask(8)

      /**
       * Compute barrier mask.
       */
      @JvmField
      public val COMPUTE: BarrierMask = BarrierMask(2)

      /**
       * Transfer barrier mask.
       */
      @JvmField
      public val TRANSFER: BarrierMask = BarrierMask(4)

      /**
       * Raster barrier mask (vertex and fragment). Equivalent to `BARRIER_MASK_VERTEX |
       * BARRIER_MASK_FRAGMENT`.
       */
      @JvmField
      public val RASTER: BarrierMask = BarrierMask(9)

      /**
       * Barrier mask for all types (vertex, fragment, compute, transfer).
       */
      @JvmField
      public val ALL_BARRIERS: BarrierMask = BarrierMask(32767)

      /**
       * No barrier for any type.
       */
      @JvmField
      public val NO_BARRIER: BarrierMask = BarrierMask(32768)
    }
  }

  public enum class TextureType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 1-dimensional texture.
     */
    TEXTURE_TYPE_1D(0),
    /**
     * 2-dimensional texture.
     */
    TEXTURE_TYPE_2D(1),
    /**
     * 3-dimensional texture.
     */
    TEXTURE_TYPE_3D(2),
    /**
     * [Cubemap] texture.
     */
    CUBE(3),
    /**
     * Array of 1-dimensional textures.
     */
    TEXTURE_TYPE_1D_ARRAY(4),
    /**
     * Array of 2-dimensional textures.
     */
    TEXTURE_TYPE_2D_ARRAY(5),
    /**
     * Array of [Cubemap] textures.
     */
    CUBE_ARRAY(6),
    /**
     * Represents the size of the [TextureType] enum.
     */
    MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): TextureType = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureSamples(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Perform 1 texture sample (this is the fastest but lowest-quality for antialiasing).
     */
    TEXTURE_SAMPLES_1(0),
    /**
     * Perform 2 texture samples.
     */
    TEXTURE_SAMPLES_2(1),
    /**
     * Perform 4 texture samples.
     */
    TEXTURE_SAMPLES_4(2),
    /**
     * Perform 8 texture samples. Not supported on mobile GPUs (including Apple Silicon).
     */
    TEXTURE_SAMPLES_8(3),
    /**
     * Perform 16 texture samples. Not supported on mobile GPUs and many desktop GPUs.
     */
    TEXTURE_SAMPLES_16(4),
    /**
     * Perform 32 texture samples. Not supported on most GPUs.
     */
    TEXTURE_SAMPLES_32(5),
    /**
     * Perform 64 texture samples (this is the slowest but highest-quality for antialiasing). Not
     * supported on most GPUs.
     */
    TEXTURE_SAMPLES_64(6),
    /**
     * Represents the size of the [TextureSamples] enum.
     */
    MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): TextureSamples = entries.single { it.`value` == `value` }
    }
  }

  public class TextureUsageBits(
    flag: Long,
  ) : BitFieldBase<TextureUsageBits>(flag) {
    protected override fun wrap(flag: Long): TextureUsageBits = TextureUsageBits(flag)

    public companion object {
      /**
       * Texture can be sampled.
       */
      @JvmField
      public val SAMPLING: TextureUsageBits = TextureUsageBits(1)

      /**
       * Texture can be used as a color attachment in a framebuffer.
       */
      @JvmField
      public val COLOR_ATTACHMENT: TextureUsageBits = TextureUsageBits(2)

      /**
       * Texture can be used as a depth/stencil attachment in a framebuffer.
       */
      @JvmField
      public val DEPTH_STENCIL_ATTACHMENT: TextureUsageBits = TextureUsageBits(4)

      /**
       * Texture can be used as a depth/stencil resolve attachment in a framebuffer.
       */
      @JvmField
      public val DEPTH_RESOLVE_ATTACHMENT: TextureUsageBits = TextureUsageBits(4096)

      /**
       * Texture can be used as a
       * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#descriptorsets-storageimage]storage
       * image[/url].
       */
      @JvmField
      public val STORAGE: TextureUsageBits = TextureUsageBits(8)

      /**
       * Texture can be used as a
       * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#descriptorsets-storageimage]storage
       * image[/url] with support for atomic operations.
       */
      @JvmField
      public val STORAGE_ATOMIC: TextureUsageBits = TextureUsageBits(16)

      /**
       * Texture can be read back on the CPU using [textureGetData] faster than without this bit,
       * since it is always kept in the system memory.
       */
      @JvmField
      public val CPU_READ: TextureUsageBits = TextureUsageBits(32)

      /**
       * Texture can be updated using [textureUpdate].
       */
      @JvmField
      public val CAN_UPDATE: TextureUsageBits = TextureUsageBits(64)

      /**
       * Texture can be a source for [textureCopy].
       */
      @JvmField
      public val CAN_COPY_FROM: TextureUsageBits = TextureUsageBits(128)

      /**
       * Texture can be a destination for [textureCopy].
       */
      @JvmField
      public val CAN_COPY_TO: TextureUsageBits = TextureUsageBits(256)

      /**
       * Texture can be used as a
       * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#descriptorsets-inputattachment]input
       * attachment[/url] in a framebuffer.
       */
      @JvmField
      public val INPUT_ATTACHMENT: TextureUsageBits = TextureUsageBits(512)
    }
  }

  public enum class TextureSwizzle(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Return the sampled value as-is.
     */
    IDENTITY(0),
    /**
     * Always return `0.0` when sampling.
     */
    ZERO(1),
    /**
     * Always return `1.0` when sampling.
     */
    ONE(2),
    /**
     * Sample the red color channel.
     */
    R(3),
    /**
     * Sample the green color channel.
     */
    G(4),
    /**
     * Sample the blue color channel.
     */
    B(5),
    /**
     * Sample the alpha channel.
     */
    A(6),
    /**
     * Represents the size of the [TextureSwizzle] enum.
     */
    MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): TextureSwizzle = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureSliceType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 2-dimensional texture slice.
     */
    TEXTURE_SLICE_2D(0),
    /**
     * Cubemap texture slice.
     */
    CUBEMAP(1),
    /**
     * 3-dimensional texture slice.
     */
    TEXTURE_SLICE_3D(2),
    ;

    public companion object {
      public fun from(`value`: Long): TextureSliceType = entries.single { it.`value` == `value` }
    }
  }

  public enum class SamplerFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Nearest-neighbor sampler filtering. Sampling at higher resolutions than the source will
     * result in a pixelated look.
     */
    NEAREST(0),
    /**
     * Bilinear sampler filtering. Sampling at higher resolutions than the source will result in a
     * blurry look.
     */
    LINEAR(1),
    ;

    public companion object {
      public fun from(`value`: Long): SamplerFilter = entries.single { it.`value` == `value` }
    }
  }

  public enum class SamplerRepeatMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Sample with repeating enabled.
     */
    REPEAT(0),
    /**
     * Sample with mirrored repeating enabled. When sampling outside the `[0.0, 1.0]` range, return
     * a mirrored version of the sampler. This mirrored version is mirrored again if sampling further
     * away, with the pattern repeating indefinitely.
     */
    MIRRORED_REPEAT(1),
    /**
     * Sample with repeating disabled. When sampling outside the `[0.0, 1.0]` range, return the
     * color of the last pixel on the edge.
     */
    CLAMP_TO_EDGE(2),
    /**
     * Sample with repeating disabled. When sampling outside the `[0.0, 1.0]` range, return the
     * specified [RDSamplerState.borderColor].
     */
    CLAMP_TO_BORDER(3),
    /**
     * Sample with mirrored repeating enabled, but only once. When sampling in the `[-1.0, 0.0]`
     * range, return a mirrored version of the sampler. When sampling outside the `[-1.0, 1.0]` range,
     * return the color of the last pixel on the edge.
     */
    MIRROR_CLAMP_TO_EDGE(4),
    /**
     * Represents the size of the [SamplerRepeatMode] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): SamplerRepeatMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class SamplerBorderColor(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Return a floating-point transparent black color when sampling outside the `[0.0, 1.0]` range.
     * Only effective if the sampler repeat mode is [SAMPLER_REPEAT_MODE_CLAMP_TO_BORDER].
     */
    FLOAT_TRANSPARENT_BLACK(0),
    /**
     * Return an integer transparent black color when sampling outside the `[0.0, 1.0]` range. Only
     * effective if the sampler repeat mode is [SAMPLER_REPEAT_MODE_CLAMP_TO_BORDER].
     */
    INT_TRANSPARENT_BLACK(1),
    /**
     * Return a floating-point opaque black color when sampling outside the `[0.0, 1.0]` range. Only
     * effective if the sampler repeat mode is [SAMPLER_REPEAT_MODE_CLAMP_TO_BORDER].
     */
    FLOAT_OPAQUE_BLACK(2),
    /**
     * Return an integer opaque black color when sampling outside the `[0.0, 1.0]` range. Only
     * effective if the sampler repeat mode is [SAMPLER_REPEAT_MODE_CLAMP_TO_BORDER].
     */
    INT_OPAQUE_BLACK(3),
    /**
     * Return a floating-point opaque white color when sampling outside the `[0.0, 1.0]` range. Only
     * effective if the sampler repeat mode is [SAMPLER_REPEAT_MODE_CLAMP_TO_BORDER].
     */
    FLOAT_OPAQUE_WHITE(4),
    /**
     * Return an integer opaque white color when sampling outside the `[0.0, 1.0]` range. Only
     * effective if the sampler repeat mode is [SAMPLER_REPEAT_MODE_CLAMP_TO_BORDER].
     */
    INT_OPAQUE_WHITE(5),
    /**
     * Represents the size of the [SamplerBorderColor] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): SamplerBorderColor = entries.single { it.`value` == `value` }
    }
  }

  public enum class VertexFrequency(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Vertex attribute addressing is a function of the vertex. This is used to specify the rate at
     * which vertex attributes are pulled from buffers.
     */
    VERTEX(0),
    /**
     * Vertex attribute addressing is a function of the instance index. This is used to specify the
     * rate at which vertex attributes are pulled from buffers.
     */
    INSTANCE(1),
    ;

    public companion object {
      public fun from(`value`: Long): VertexFrequency = entries.single { it.`value` == `value` }
    }
  }

  public enum class IndexBufferFormat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Index buffer in 16-bit unsigned integer format. This limits the maximum index that can be
     * specified to `65535`.
     */
    UINT16(0),
    /**
     * Index buffer in 32-bit unsigned integer format. This limits the maximum index that can be
     * specified to `4294967295`.
     */
    UINT32(1),
    ;

    public companion object {
      public fun from(`value`: Long): IndexBufferFormat = entries.single { it.`value` == `value` }
    }
  }

  public class StorageBufferUsage(
    flag: Long,
  ) : BitFieldBase<StorageBufferUsage>(flag) {
    protected override fun wrap(flag: Long): StorageBufferUsage = StorageBufferUsage(flag)

    public companion object {
      @JvmField
      public val DISPATCH_INDIRECT: StorageBufferUsage = StorageBufferUsage(1)
    }
  }

  public class BufferCreationBits(
    flag: Long,
  ) : BitFieldBase<BufferCreationBits>(flag) {
    protected override fun wrap(flag: Long): BufferCreationBits = BufferCreationBits(flag)

    public companion object {
      /**
       * Optionally, set this flag if you wish to use [bufferGetDeviceAddress] functionality. You
       * must first check the GPU supports it:
       *
       * ```gdscript
       * //gdscript
       * rd = RenderingServer.get_rendering_device()
       *
       * if rd.has_feature(RenderingDevice.SUPPORTS_BUFFER_DEVICE_ADDRESS):
       * 	storage_buffer = rd.storage_buffer_create(bytes.size(), bytes,
       * RenderingDevice.STORAGE_BUFFER_USAGE_SHADER_DEVICE_ADDRESS)
       * 	storage_buffer_address = rd.buffer_get_device_address(storage_buffer)
       * ```
       */
      @JvmField
      public val DEVICE_ADDRESS: BufferCreationBits = BufferCreationBits(1)

      /**
       * Set this flag so that it is created as storage. This is useful if Compute Shaders need
       * access (for reading or writing) to the buffer, e.g. skeletal animations are processed in
       * Compute Shaders which need access to vertex buffers, to be later consumed by vertex shaders as
       * part of the regular rasterization pipeline.
       */
      @JvmField
      public val AS_STORAGE: BufferCreationBits = BufferCreationBits(2)

      /**
       * Allows usage of this buffer as input data for an acceleration structure build operation.
       * You must first check that the GPU supports it:
       *
       * ```gdscript
       * //gdscript
       * rd = RenderingServer.get_rendering_device()
       *
       * if rd.has_feature(RenderingDevice.SUPPORTS_RAYTRACING_PIPELINE):
       *     storage_buffer = rd.storage_buffer_create(bytes.size(), bytes,
       * RenderingDevice.BUFFER_CREATION_ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY_BIT)
       * ```
       */
      @JvmField
      public val ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY: BufferCreationBits =
          BufferCreationBits(8)
    }
  }

  public class AccelerationStructureFlagBits(
    flag: Long,
  ) : BitFieldBase<AccelerationStructureFlagBits>(flag) {
    protected override fun wrap(flag: Long): AccelerationStructureFlagBits =
        AccelerationStructureFlagBits(flag)

    public companion object {
      /**
       * Allows the acceleration structure to be updated after it has been built.
       */
      @JvmField
      public val ALLOW_UPDATE: AccelerationStructureFlagBits = AccelerationStructureFlagBits(1)

      /**
       * Allows the acceleration structure to be compacted to reduce memory usage after it has been
       * built.
       */
      @JvmField
      public val ALLOW_COMPACTION: AccelerationStructureFlagBits = AccelerationStructureFlagBits(2)

      /**
       * Prioritizes ray traversal performance over build performance when building the acceleration
       * structure.
       */
      @JvmField
      public val PREFER_FAST_TRACE: AccelerationStructureFlagBits = AccelerationStructureFlagBits(4)

      /**
       * Prioritizes build performance over ray traversal performance when building the acceleration
       * structure.
       */
      @JvmField
      public val PREFER_FAST_BUILD: AccelerationStructureFlagBits = AccelerationStructureFlagBits(8)

      /**
       * Reduces the memory usage of the acceleration structure, potentially at the cost of reduced
       * ray traversal performance.
       */
      @JvmField
      public val LOW_MEMORY: AccelerationStructureFlagBits = AccelerationStructureFlagBits(16)
    }
  }

  public class AccelerationStructureGeometryFlagBits(
    flag: Long,
  ) : BitFieldBase<AccelerationStructureGeometryFlagBits>(flag) {
    protected override fun wrap(flag: Long): AccelerationStructureGeometryFlagBits =
        AccelerationStructureGeometryFlagBits(flag)

    public companion object {
      /**
       * An opaque geometry does not invoke the any hit shaders.
       */
      @JvmField
      public val OPAQUE: AccelerationStructureGeometryFlagBits =
          AccelerationStructureGeometryFlagBits(1)

      /**
       * This geometry only calls the any hit shader a single time for each primitive.
       */
      @JvmField
      public val NO_DUPLICATE_ANY_HIT_INVOCATION: AccelerationStructureGeometryFlagBits =
          AccelerationStructureGeometryFlagBits(2)
    }
  }

  public class AccelerationStructureInstanceFlagBits(
    flag: Long,
  ) : BitFieldBase<AccelerationStructureInstanceFlagBits>(flag) {
    protected override fun wrap(flag: Long): AccelerationStructureInstanceFlagBits =
        AccelerationStructureInstanceFlagBits(flag)

    public companion object {
      /**
       * Disables triangle face culling for this instance during ray traversal.
       */
      @JvmField
      public val TRIANGLE_FACING_CULL_DISABLE: AccelerationStructureInstanceFlagBits =
          AccelerationStructureInstanceFlagBits(1)

      /**
       * Flips the triangle facing direction for this instance during ray traversal.
       */
      @JvmField
      public val TRIANGLE_FLIP_FACING: AccelerationStructureInstanceFlagBits =
          AccelerationStructureInstanceFlagBits(2)

      /**
       * Forces all geometries in this instance to be treated as opaque, preventing any hit shaders
       * from being invoked.
       */
      @JvmField
      public val FORCE_OPAQUE: AccelerationStructureInstanceFlagBits =
          AccelerationStructureInstanceFlagBits(4)

      /**
       * Forces all geometries in this instance to be treated as non-opaque, allowing any hit
       * shaders to be invoked.
       */
      @JvmField
      public val FORCE_NO_OPAQUE: AccelerationStructureInstanceFlagBits =
          AccelerationStructureInstanceFlagBits(8)
    }
  }

  public enum class UniformType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Sampler uniform.
     */
    SAMPLER(0),
    /**
     * Sampler uniform with a texture.
     */
    SAMPLER_WITH_TEXTURE(1),
    /**
     * Texture uniform.
     */
    TEXTURE(2),
    /**
     * Image uniform.
     */
    IMAGE(3),
    /**
     * Texture buffer uniform.
     */
    TEXTURE_BUFFER(4),
    /**
     * Sampler uniform with a texture buffer.
     */
    SAMPLER_WITH_TEXTURE_BUFFER(5),
    /**
     * Image buffer uniform.
     */
    IMAGE_BUFFER(6),
    /**
     * Uniform buffer uniform.
     */
    UNIFORM_BUFFER(7),
    /**
     * [url=https://vkguide.dev/docs/chapter-4/storage_buffers/]Storage buffer[/url] uniform.
     */
    STORAGE_BUFFER(8),
    /**
     * Input attachment uniform.
     */
    INPUT_ATTACHMENT(9),
    /**
     * Same as UNIFORM_TYPE_UNIFORM_BUFFER but for buffers created with
     * BUFFER_CREATION_DYNAMIC_PERSISTENT_BIT.
     *
     * **Note:** This flag is not available to GD users due to being too dangerous (i.e. wrong usage
     * can result in visual glitches).
     *
     * It's exposed in case GD users receive a buffer created with such flag from Godot.
     */
    UNIFORM_BUFFER_DYNAMIC(10),
    /**
     * Same as UNIFORM_TYPE_STORAGE_BUFFER but for buffers created with
     * BUFFER_CREATION_DYNAMIC_PERSISTENT_BIT.
     *
     * **Note:** This flag is not available to GD users due to being too dangerous (i.e. wrong usage
     * can result in visual glitches).
     *
     * It's exposed in case GD users receive a buffer created with such flag from Godot.
     */
    STORAGE_BUFFER_DYNAMIC(11),
    /**
     * Acceleration structure uniform.
     */
    ACCELERATION_STRUCTURE(12),
    /**
     * Represents the size of the [UniformType] enum.
     */
    MAX(13),
    ;

    public companion object {
      public fun from(`value`: Long): UniformType = entries.single { it.`value` == `value` }
    }
  }

  public enum class RenderPrimitive(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Point rendering primitive (with constant size, regardless of distance from camera).
     */
    POINTS(0),
    /**
     * Line list rendering primitive. Lines are drawn separated from each other.
     */
    LINES(1),
    /**
     * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#drawing-line-lists-with-adjacency]Line
     * list rendering primitive with adjacency.[/url]
     *
     * **Note:** Adjacency is only useful with geometry shaders, which Godot does not expose.
     */
    LINES_WITH_ADJACENCY(2),
    /**
     * Line strip rendering primitive. Lines drawn are connected to the previous vertex.
     */
    LINESTRIPS(3),
    /**
     * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#drawing-line-strips-with-adjacency]Line
     * strip rendering primitive with adjacency.[/url]
     *
     * **Note:** Adjacency is only useful with geometry shaders, which Godot does not expose.
     */
    LINESTRIPS_WITH_ADJACENCY(4),
    /**
     * Triangle list rendering primitive. Triangles are drawn separated from each other.
     */
    TRIANGLES(5),
    /**
     * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#drawing-triangle-lists-with-adjacency]Triangle
     * list rendering primitive with adjacency.[/url]
     *
     * **Note:** Adjacency is only useful with geometry shaders, which Godot does not expose.
     */
    TRIANGLES_WITH_ADJACENCY(6),
    /**
     * Triangle strip rendering primitive. Triangles drawn are connected to the previous triangle.
     */
    TRIANGLE_STRIPS(7),
    /**
     * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#drawing-triangle-strips-with-adjacency]Triangle
     * strip rendering primitive with adjacency.[/url]
     *
     * **Note:** Adjacency is only useful with geometry shaders, which Godot does not expose.
     */
    TRIANGLE_STRIPS_WITH_AJACENCY(8),
    /**
     * Triangle strip rendering primitive with *primitive restart* enabled. Triangles drawn are
     * connected to the previous triangle, but a primitive restart index can be specified before
     * drawing to create a second triangle strip after the specified index.
     *
     * **Note:** Only compatible with indexed draws.
     */
    TRIANGLE_STRIPS_WITH_RESTART_INDEX(9),
    /**
     * Tessellation patch rendering primitive. Only useful with tessellation shaders, which can be
     * used to deform these patches.
     */
    TESSELATION_PATCH(10),
    /**
     * Represents the size of the [RenderPrimitive] enum.
     */
    MAX(11),
    ;

    public companion object {
      public fun from(`value`: Long): RenderPrimitive = entries.single { it.`value` == `value` }
    }
  }

  public enum class PolygonCullMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not use polygon front face or backface culling.
     */
    DISABLED(0),
    /**
     * Use polygon frontface culling (faces pointing towards the camera are hidden).
     */
    FRONT(1),
    /**
     * Use polygon backface culling (faces pointing away from the camera are hidden).
     */
    BACK(2),
    ;

    public companion object {
      public fun from(`value`: Long): PolygonCullMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class PolygonFrontFace(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Clockwise winding order to determine which face of a polygon is its front face.
     */
    CLOCKWISE(0),
    /**
     * Counter-clockwise winding order to determine which face of a polygon is its front face.
     */
    COUNTER_CLOCKWISE(1),
    ;

    public companion object {
      public fun from(`value`: Long): PolygonFrontFace = entries.single { it.`value` == `value` }
    }
  }

  public enum class StencilOperation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Keep the current stencil value.
     */
    KEEP(0),
    /**
     * Set the stencil value to `0`.
     */
    ZERO(1),
    /**
     * Replace the existing stencil value with the new one.
     */
    REPLACE(2),
    /**
     * Increment the existing stencil value and clamp to the maximum representable unsigned value if
     * reached. Stencil bits are considered as an unsigned integer.
     */
    INCREMENT_AND_CLAMP(3),
    /**
     * Decrement the existing stencil value and clamp to the minimum value if reached. Stencil bits
     * are considered as an unsigned integer.
     */
    DECREMENT_AND_CLAMP(4),
    /**
     * Bitwise-invert the existing stencil value.
     */
    INVERT(5),
    /**
     * Increment the stencil value and wrap around to `0` if reaching the maximum representable
     * unsigned. Stencil bits are considered as an unsigned integer.
     */
    INCREMENT_AND_WRAP(6),
    /**
     * Decrement the stencil value and wrap around to the maximum representable unsigned if reaching
     * the minimum. Stencil bits are considered as an unsigned integer.
     */
    DECREMENT_AND_WRAP(7),
    /**
     * Represents the size of the [StencilOperation] enum.
     */
    MAX(8),
    ;

    public companion object {
      public fun from(`value`: Long): StencilOperation = entries.single { it.`value` == `value` }
    }
  }

  public enum class CompareOperator(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * "Never" comparison (opposite of [COMPARE_OP_ALWAYS]).
     */
    NEVER(0),
    /**
     * "Less than" comparison.
     */
    LESS(1),
    /**
     * "Equal" comparison.
     */
    EQUAL(2),
    /**
     * "Less than or equal" comparison.
     */
    LESS_OR_EQUAL(3),
    /**
     * "Greater than" comparison.
     */
    GREATER(4),
    /**
     * "Not equal" comparison.
     */
    NOT_EQUAL(5),
    /**
     * "Greater than or equal" comparison.
     */
    GREATER_OR_EQUAL(6),
    /**
     * "Always" comparison (opposite of [COMPARE_OP_NEVER]).
     */
    ALWAYS(7),
    /**
     * Represents the size of the [CompareOperator] enum.
     */
    MAX(8),
    ;

    public companion object {
      public fun from(`value`: Long): CompareOperator = entries.single { it.`value` == `value` }
    }
  }

  public enum class LogicOperation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Clear logic operation (result is always `0`). See also [LOGIC_OP_SET].
     */
    CLEAR(0),
    /**
     * AND logic operation.
     */
    AND(1),
    /**
     * AND logic operation with the *destination* operand being inverted. See also
     * [LOGIC_OP_AND_INVERTED].
     */
    AND_REVERSE(2),
    /**
     * Copy logic operation (keeps the *source* value as-is). See also [LOGIC_OP_COPY_INVERTED] and
     * [LOGIC_OP_NO_OP].
     */
    COPY(3),
    /**
     * AND logic operation with the *source* operand being inverted. See also
     * [LOGIC_OP_AND_REVERSE].
     */
    AND_INVERTED(4),
    /**
     * No-op logic operation (keeps the *destination* value as-is). See also [LOGIC_OP_COPY].
     */
    NO(5),
    /**
     * Exclusive or (XOR) logic operation.
     */
    XOR(6),
    /**
     * OR logic operation.
     */
    OR(7),
    /**
     * Not-OR (NOR) logic operation.
     */
    NOR(8),
    /**
     * Not-XOR (XNOR) logic operation.
     */
    EQUIVALENT(9),
    /**
     * Invert logic operation.
     */
    INVERT(10),
    /**
     * OR logic operation with the *destination* operand being inverted. See also
     * [LOGIC_OP_OR_REVERSE].
     */
    OR_REVERSE(11),
    /**
     * NOT logic operation (inverts the value). See also [LOGIC_OP_COPY].
     */
    COPY_INVERTED(12),
    /**
     * OR logic operation with the *source* operand being inverted. See also [LOGIC_OP_OR_REVERSE].
     */
    OR_INVERTED(13),
    /**
     * Not-AND (NAND) logic operation.
     */
    NAND(14),
    /**
     * SET logic operation (result is always `1`). See also [LOGIC_OP_CLEAR].
     */
    SET(15),
    /**
     * Represents the size of the [LogicOperation] enum.
     */
    MAX(16),
    ;

    public companion object {
      public fun from(`value`: Long): LogicOperation = entries.single { it.`value` == `value` }
    }
  }

  public enum class BlendFactor(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant `0.0` blend factor.
     */
    ZERO(0),
    /**
     * Constant `1.0` blend factor.
     */
    ONE(1),
    /**
     * Color blend factor is `source color`. Alpha blend factor is `source alpha`.
     */
    SRC_COLOR(2),
    /**
     * Color blend factor is `1.0 - source color`. Alpha blend factor is `1.0 - source alpha`.
     */
    ONE_MINUS_SRC_COLOR(3),
    /**
     * Color blend factor is `destination color`. Alpha blend factor is `destination alpha`.
     */
    DST_COLOR(4),
    /**
     * Color blend factor is `1.0 - destination color`. Alpha blend factor is `1.0 - destination
     * alpha`.
     */
    ONE_MINUS_DST_COLOR(5),
    /**
     * Color and alpha blend factor is `source alpha`.
     */
    SRC_ALPHA(6),
    /**
     * Color and alpha blend factor is `1.0 - source alpha`.
     */
    ONE_MINUS_SRC_ALPHA(7),
    /**
     * Color and alpha blend factor is `destination alpha`.
     */
    DST_ALPHA(8),
    /**
     * Color and alpha blend factor is `1.0 - destination alpha`.
     */
    ONE_MINUS_DST_ALPHA(9),
    /**
     * Color blend factor is `blend constant color`. Alpha blend factor is `blend constant alpha`
     * (see [drawListSetBlendConstants]).
     */
    CONSTANT_COLOR(10),
    /**
     * Color blend factor is `1.0 - blend constant color`. Alpha blend factor is `1.0 - blend
     * constant alpha` (see [drawListSetBlendConstants]).
     */
    ONE_MINUS_CONSTANT_COLOR(11),
    /**
     * Color and alpha blend factor is `blend constant alpha` (see [drawListSetBlendConstants]).
     */
    CONSTANT_ALPHA(12),
    /**
     * Color and alpha blend factor is `1.0 - blend constant alpha` (see
     * [drawListSetBlendConstants]).
     */
    ONE_MINUS_CONSTANT_ALPHA(13),
    /**
     * Color blend factor is `min(source alpha, 1.0 - destination alpha)`. Alpha blend factor is
     * `1.0`.
     */
    SRC_ALPHA_SATURATE(14),
    /**
     * Color blend factor is `second source color`. Alpha blend factor is `second source alpha`.
     * Only relevant for dual-source blending.
     */
    SRC1_COLOR(15),
    /**
     * Color blend factor is `1.0 - second source color`. Alpha blend factor is `1.0 - second source
     * alpha`. Only relevant for dual-source blending.
     */
    ONE_MINUS_SRC1_COLOR(16),
    /**
     * Color and alpha blend factor is `second source alpha`. Only relevant for dual-source
     * blending.
     */
    SRC1_ALPHA(17),
    /**
     * Color and alpha blend factor is `1.0 - second source alpha`. Only relevant for dual-source
     * blending.
     */
    ONE_MINUS_SRC1_ALPHA(18),
    /**
     * Represents the size of the [BlendFactor] enum.
     */
    MAX(19),
    ;

    public companion object {
      public fun from(`value`: Long): BlendFactor = entries.single { it.`value` == `value` }
    }
  }

  public enum class BlendOperation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Additive blending operation (`source + destination`).
     */
    ADD(0),
    /**
     * Subtractive blending operation (`source - destination`).
     */
    SUBTRACT(1),
    /**
     * Reverse subtractive blending operation (`destination - source`).
     */
    REVERSE_SUBTRACT(2),
    /**
     * Minimum blending operation (keep the lowest value of the two).
     */
    MINIMUM(3),
    /**
     * Maximum blending operation (keep the highest value of the two).
     */
    MAXIMUM(4),
    /**
     * Represents the size of the [BlendOperation] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): BlendOperation = entries.single { it.`value` == `value` }
    }
  }

  public class PipelineDynamicStateFlags(
    flag: Long,
  ) : BitFieldBase<PipelineDynamicStateFlags>(flag) {
    protected override fun wrap(flag: Long): PipelineDynamicStateFlags =
        PipelineDynamicStateFlags(flag)

    public companion object {
      /**
       * Allows dynamically changing the width of rendering lines.
       */
      @JvmField
      public val DYNAMIC_STATE_LINE_WIDTH: PipelineDynamicStateFlags = PipelineDynamicStateFlags(1)

      /**
       * Allows dynamically changing the depth bias.
       */
      @JvmField
      public val DYNAMIC_STATE_DEPTH_BIAS: PipelineDynamicStateFlags = PipelineDynamicStateFlags(2)

      @JvmField
      public val DYNAMIC_STATE_BLEND_CONSTANTS: PipelineDynamicStateFlags =
          PipelineDynamicStateFlags(4)

      @JvmField
      public val DYNAMIC_STATE_DEPTH_BOUNDS: PipelineDynamicStateFlags =
          PipelineDynamicStateFlags(8)

      @JvmField
      public val DYNAMIC_STATE_STENCIL_COMPARE_MASK: PipelineDynamicStateFlags =
          PipelineDynamicStateFlags(16)

      @JvmField
      public val DYNAMIC_STATE_STENCIL_WRITE_MASK: PipelineDynamicStateFlags =
          PipelineDynamicStateFlags(32)

      @JvmField
      public val DYNAMIC_STATE_STENCIL_REFERENCE: PipelineDynamicStateFlags =
          PipelineDynamicStateFlags(64)
    }
  }

  public enum class InitialAction(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Load the previous contents of the framebuffer.
     */
    LOAD(0),
    /**
     * Clear the whole framebuffer or its specified region.
     */
    CLEAR(1),
    /**
     * Ignore the previous contents of the framebuffer. This is the fastest option if you'll
     * overwrite all of the pixels and don't need to read any of them.
     */
    DISCARD(2),
    /**
     * Represents the size of the [InitialAction] enum.
     */
    MAX(3),
    CLEAR_REGION(1),
    CLEAR_REGION_CONTINUE(1),
    KEEP(0),
    DROP(2),
    CONTINUE(0),
    ;

    public companion object {
      public fun from(`value`: Long): InitialAction = entries.single { it.`value` == `value` }
    }
  }

  public enum class FinalAction(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Store the result of the draw list in the framebuffer. This is generally what you want to do.
     */
    STORE(0),
    /**
     * Discard the contents of the framebuffer. This is the fastest option if you don't need to use
     * the results of the draw list.
     */
    DISCARD(1),
    /**
     * Represents the size of the [FinalAction] enum.
     */
    MAX(2),
    READ(0),
    CONTINUE(0),
    ;

    public companion object {
      public fun from(`value`: Long): FinalAction = entries.single { it.`value` == `value` }
    }
  }

  public enum class ShaderStage(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Vertex shader stage. This can be used to manipulate vertices from a shader (but not create
     * new vertices).
     */
    VERTEX(0),
    /**
     * Fragment shader stage (called "pixel shader" in Direct3D). This can be used to manipulate
     * pixels from a shader.
     */
    FRAGMENT(1),
    /**
     * Tessellation control shader stage. This can be used to create additional geometry from a
     * shader.
     */
    TESSELATION_CONTROL(2),
    /**
     * Tessellation evaluation shader stage. This can be used to create additional geometry from a
     * shader.
     */
    TESSELATION_EVALUATION(3),
    /**
     * Compute shader stage. This can be used to run arbitrary computing tasks in a shader,
     * performing them on the GPU instead of the CPU.
     */
    COMPUTE(4),
    /**
     * Ray generation shader stage. This can be used to generate primary rays.
     */
    RAYGEN(5),
    /**
     * Any hit shader stage. Invoked when ray intersections are not opaque. This can be used to
     * specify what happens when a ray hits any of the geometry in the scene.
     */
    ANY_HIT(6),
    /**
     * Closest hit shader stage. This can be used to specify what happens when a ray hits the
     * closest geometry in the scene.
     */
    CLOSEST_HIT(7),
    /**
     * Miss shader stage. This can be used to specify what happens if a ray does not hit anything in
     * the scene.
     */
    MISS(8),
    /**
     * Intersection shader stage. The intersection shader for triangles is built-in. This can be
     * used to compute ray intersections with primitives that are not triangles.
     */
    INTERSECTION(9),
    /**
     * Represents the size of the [ShaderStage] enum.
     */
    MAX(10),
    /**
     * Vertex shader stage bit (see also [SHADER_STAGE_VERTEX]).
     */
    VERTEX_BIT(1),
    /**
     * Fragment shader stage bit (see also [SHADER_STAGE_FRAGMENT]).
     */
    FRAGMENT_BIT(2),
    /**
     * Tessellation control shader stage bit (see also [SHADER_STAGE_TESSELATION_CONTROL]).
     */
    TESSELATION_CONTROL_BIT(4),
    /**
     * Tessellation evaluation shader stage bit (see also [SHADER_STAGE_TESSELATION_EVALUATION]).
     */
    TESSELATION_EVALUATION_BIT(8),
    /**
     * Compute shader stage bit (see also [SHADER_STAGE_COMPUTE]).
     */
    COMPUTE_BIT(16),
    /**
     * Ray generation shader stage bit (see also [SHADER_STAGE_RAYGEN]).
     */
    RAYGEN_BIT(32),
    /**
     * Any hit shader stage bit (see also [SHADER_STAGE_ANY_HIT]).
     */
    ANY_HIT_BIT(64),
    /**
     * Closest hit shader stage bit (see also [SHADER_STAGE_CLOSEST_HIT]).
     */
    CLOSEST_HIT_BIT(128),
    /**
     * Miss shader stage bit (see also [SHADER_STAGE_MISS]).
     */
    MISS_BIT(256),
    /**
     * Intersection shader stage bit (see also [SHADER_STAGE_INTERSECTION]).
     */
    INTERSECTION_BIT(512),
    ;

    public companion object {
      public fun from(`value`: Long): ShaderStage = entries.single { it.`value` == `value` }
    }
  }

  public enum class ShaderLanguage(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Khronos' GLSL shading language (used natively by OpenGL and Vulkan). This is the language
     * used for core Godot shaders.
     */
    GLSL(0),
    /**
     * Microsoft's High-Level Shading Language (used natively by Direct3D, but can also be used in
     * Vulkan).
     */
    HLSL(1),
    ;

    public companion object {
      public fun from(`value`: Long): ShaderLanguage = entries.single { it.`value` == `value` }
    }
  }

  public enum class PipelineSpecializationConstantType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Boolean specialization constant.
     */
    BOOL(0),
    /**
     * Integer specialization constant.
     */
    INT(1),
    /**
     * Floating-point specialization constant.
     */
    FLOAT(2),
    ;

    public companion object {
      public fun from(`value`: Long): PipelineSpecializationConstantType =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class Features(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Support for MetalFX spatial upscaling.
     */
    SUPPORTS_METALFX_SPATIAL(3),
    /**
     * Support for MetalFX temporal upscaling.
     */
    SUPPORTS_METALFX_TEMPORAL(4),
    /**
     * Features support for buffer device address extension.
     */
    SUPPORTS_BUFFER_DEVICE_ADDRESS(6),
    /**
     * Support for 32-bit image atomic operations.
     */
    SUPPORTS_IMAGE_ATOMIC_32_BIT(7),
    /**
     * Support for ray query extension.
     *
     * **Note:** This is currently only supported when using Vulkan. This is not supported on macOS
     * and iOS (even on hardware supporting raytracing) due to MoltenVK limitations.
     */
    SUPPORTS_RAY_QUERY(11),
    /**
     * Support for raytracing pipeline extension.
     *
     * **Note:** This is currently only supported when using Vulkan. This is not supported on macOS
     * and iOS (even on hardware supporting raytracing) due to MoltenVK limitations.
     */
    SUPPORTS_RAYTRACING_PIPELINE(12),
    /**
     * Support for high dynamic range (HDR) output.
     */
    SUPPORTS_HDR_OUTPUT(13),
    ;

    public companion object {
      public fun from(`value`: Long): Features = entries.single { it.`value` == `value` }
    }
  }

  public enum class Limit(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Maximum number of uniform sets that can be bound at a given time.
     */
    MAX_BOUND_UNIFORM_SETS(0),
    /**
     * Maximum number of color framebuffer attachments that can be used at a given time.
     */
    MAX_FRAMEBUFFER_COLOR_ATTACHMENTS(1),
    /**
     * Maximum number of textures that can be used per uniform set.
     */
    MAX_TEXTURES_PER_UNIFORM_SET(2),
    /**
     * Maximum number of samplers that can be used per uniform set.
     */
    MAX_SAMPLERS_PER_UNIFORM_SET(3),
    /**
     * Maximum number of [url=https://vkguide.dev/docs/chapter-4/storage_buffers/]storage
     * buffers[/url] per uniform set.
     */
    MAX_STORAGE_BUFFERS_PER_UNIFORM_SET(4),
    /**
     * Maximum number of storage images per uniform set.
     */
    MAX_STORAGE_IMAGES_PER_UNIFORM_SET(5),
    /**
     * Maximum number of uniform buffers per uniform set.
     */
    MAX_UNIFORM_BUFFERS_PER_UNIFORM_SET(6),
    /**
     * Maximum index for an indexed draw command.
     */
    MAX_DRAW_INDEXED_INDEX(7),
    /**
     * Maximum height of a framebuffer (in pixels).
     */
    MAX_FRAMEBUFFER_HEIGHT(8),
    /**
     * Maximum width of a framebuffer (in pixels).
     */
    MAX_FRAMEBUFFER_WIDTH(9),
    /**
     * Maximum number of texture array layers.
     */
    MAX_TEXTURE_ARRAY_LAYERS(10),
    /**
     * Maximum supported 1-dimensional texture size (in pixels on a single axis).
     */
    MAX_TEXTURE_SIZE_1D(11),
    /**
     * Maximum supported 2-dimensional texture size (in pixels on a single axis).
     */
    MAX_TEXTURE_SIZE_2D(12),
    /**
     * Maximum supported 3-dimensional texture size (in pixels on a single axis).
     */
    MAX_TEXTURE_SIZE_3D(13),
    /**
     * Maximum supported cubemap texture size (in pixels on a single axis of a single face).
     */
    MAX_TEXTURE_SIZE_CUBE(14),
    /**
     * Maximum number of textures per shader stage.
     */
    MAX_TEXTURES_PER_SHADER_STAGE(15),
    /**
     * Maximum number of samplers per shader stage.
     */
    MAX_SAMPLERS_PER_SHADER_STAGE(16),
    /**
     * Maximum number of [url=https://vkguide.dev/docs/chapter-4/storage_buffers/]storage
     * buffers[/url] per shader stage.
     */
    MAX_STORAGE_BUFFERS_PER_SHADER_STAGE(17),
    /**
     * Maximum number of storage images per shader stage.
     */
    MAX_STORAGE_IMAGES_PER_SHADER_STAGE(18),
    /**
     * Maximum number of uniform buffers per uniform set.
     */
    MAX_UNIFORM_BUFFERS_PER_SHADER_STAGE(19),
    /**
     * Maximum size of a push constant. A lot of devices are limited to 128 bytes, so try to avoid
     * exceeding 128 bytes in push constants to ensure compatibility even if your GPU is reporting a
     * higher value.
     */
    MAX_PUSH_CONSTANT_SIZE(20),
    /**
     * Maximum size of a uniform buffer.
     */
    MAX_UNIFORM_BUFFER_SIZE(21),
    /**
     * Maximum vertex input attribute offset.
     */
    MAX_VERTEX_INPUT_ATTRIBUTE_OFFSET(22),
    /**
     * Maximum number of vertex input attributes.
     */
    MAX_VERTEX_INPUT_ATTRIBUTES(23),
    /**
     * Maximum number of vertex input bindings.
     */
    MAX_VERTEX_INPUT_BINDINGS(24),
    /**
     * Maximum vertex input binding stride.
     */
    MAX_VERTEX_INPUT_BINDING_STRIDE(25),
    /**
     * Minimum uniform buffer offset alignment.
     */
    MIN_UNIFORM_BUFFER_OFFSET_ALIGNMENT(26),
    /**
     * Maximum shared memory size for compute shaders.
     */
    MAX_COMPUTE_SHARED_MEMORY_SIZE(27),
    /**
     * Maximum number of workgroups for compute shaders on the X axis.
     */
    MAX_COMPUTE_WORKGROUP_COUNT_X(28),
    /**
     * Maximum number of workgroups for compute shaders on the Y axis.
     */
    MAX_COMPUTE_WORKGROUP_COUNT_Y(29),
    /**
     * Maximum number of workgroups for compute shaders on the Z axis.
     */
    MAX_COMPUTE_WORKGROUP_COUNT_Z(30),
    /**
     * Maximum number of workgroup invocations for compute shaders.
     */
    MAX_COMPUTE_WORKGROUP_INVOCATIONS(31),
    /**
     * Maximum workgroup size for compute shaders on the X axis.
     */
    MAX_COMPUTE_WORKGROUP_SIZE_X(32),
    /**
     * Maximum workgroup size for compute shaders on the Y axis.
     */
    MAX_COMPUTE_WORKGROUP_SIZE_Y(33),
    /**
     * Maximum workgroup size for compute shaders on the Z axis.
     */
    MAX_COMPUTE_WORKGROUP_SIZE_Z(34),
    /**
     * Maximum viewport width (in pixels).
     */
    MAX_VIEWPORT_DIMENSIONS_X(35),
    /**
     * Maximum viewport height (in pixels).
     */
    MAX_VIEWPORT_DIMENSIONS_Y(36),
    /**
     * Returns the smallest value for [ProjectSettings.rendering/scaling3d/scale] when using the
     * MetalFX temporal upscaler.
     *
     * **Note:** The returned value is multiplied by a factor of `1000000` to preserve 6 digits of
     * precision. It must be divided by `1000000.0` to convert the value to a floating point number.
     */
    METALFX_TEMPORAL_SCALER_MIN_SCALE(46),
    /**
     * Returns the largest value for [ProjectSettings.rendering/scaling3d/scale] when using the
     * MetalFX temporal upscaler.
     *
     * **Note:** The returned value is multiplied by a factor of `1000000` to preserve 6 digits of
     * precision. It must be divided by `1000000.0` to convert the value to a floating point number.
     */
    METALFX_TEMPORAL_SCALER_MAX_SCALE(47),
    ;

    public companion object {
      public fun from(`value`: Long): Limit = entries.single { it.`value` == `value` }
    }
  }

  public enum class MemoryType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Memory taken by textures.
     */
    TEXTURES(0),
    /**
     * Memory taken by buffers.
     */
    BUFFERS(1),
    /**
     * Total memory taken. This is greater than the sum of [MEMORY_TEXTURES] and [MEMORY_BUFFERS],
     * as it also includes miscellaneous memory usage.
     */
    TOTAL(2),
    ;

    public companion object {
      public fun from(`value`: Long): MemoryType = entries.single { it.`value` == `value` }
    }
  }

  public enum class BreadcrumbMarker(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No breadcrumb marker will be added.
     */
    NONE(0),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include
     * `"REFLECTION_PROBES"` for added context as to when the crash occurred.
     */
    REFLECTION_PROBES(65536),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include `"SKY_PASS"` for
     * added context as to when the crash occurred.
     */
    SKY_PASS(131072),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include
     * `"LIGHTMAPPER_PASS"` for added context as to when the crash occurred.
     */
    LIGHTMAPPER_PASS(196608),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include
     * `"SHADOW_PASS_DIRECTIONAL"` for added context as to when the crash occurred.
     */
    SHADOW_PASS_DIRECTIONAL(262144),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include
     * `"SHADOW_PASS_CUBE"` for added context as to when the crash occurred.
     */
    SHADOW_PASS_CUBE(327680),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include `"OPAQUE_PASS"`
     * for added context as to when the crash occurred.
     */
    OPAQUE_PASS(393216),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include `"ALPHA_PASS"`
     * for added context as to when the crash occurred.
     */
    ALPHA_PASS(458752),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include
     * `"TRANSPARENT_PASS"` for added context as to when the crash occurred.
     */
    TRANSPARENT_PASS(524288),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include
     * `"POST_PROCESSING_PASS"` for added context as to when the crash occurred.
     */
    POST_PROCESSING_PASS(589824),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include `"BLIT_PASS"` for
     * added context as to when the crash occurred.
     */
    BLIT_PASS(655360),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include `"UI_PASS"` for
     * added context as to when the crash occurred.
     */
    UI_PASS(720896),
    /**
     * During a GPU crash in dev or debug mode, Godot's error message will include `"DEBUG_PASS"`
     * for added context as to when the crash occurred.
     */
    DEBUG_PASS(786432),
    ;

    public companion object {
      public fun from(`value`: Long): BreadcrumbMarker = entries.single { it.`value` == `value` }
    }
  }

  public class DrawFlags(
    flag: Long,
  ) : BitFieldBase<DrawFlags>(flag) {
    protected override fun wrap(flag: Long): DrawFlags = DrawFlags(flag)

    public companion object {
      /**
       * Do not clear or ignore any attachments.
       */
      @JvmField
      public val DEFAULT_ALL: DrawFlags = DrawFlags(0)

      /**
       * Clear the first color attachment.
       */
      @JvmField
      public val CLEAR_COLOR_0: DrawFlags = DrawFlags(1)

      /**
       * Clear the second color attachment.
       */
      @JvmField
      public val CLEAR_COLOR_1: DrawFlags = DrawFlags(2)

      /**
       * Clear the third color attachment.
       */
      @JvmField
      public val CLEAR_COLOR_2: DrawFlags = DrawFlags(4)

      /**
       * Clear the fourth color attachment.
       */
      @JvmField
      public val CLEAR_COLOR_3: DrawFlags = DrawFlags(8)

      /**
       * Clear the fifth color attachment.
       */
      @JvmField
      public val CLEAR_COLOR_4: DrawFlags = DrawFlags(16)

      /**
       * Clear the sixth color attachment.
       */
      @JvmField
      public val CLEAR_COLOR_5: DrawFlags = DrawFlags(32)

      /**
       * Clear the seventh color attachment.
       */
      @JvmField
      public val CLEAR_COLOR_6: DrawFlags = DrawFlags(64)

      /**
       * Clear the eighth color attachment.
       */
      @JvmField
      public val CLEAR_COLOR_7: DrawFlags = DrawFlags(128)

      /**
       * Mask for clearing all color attachments.
       */
      @JvmField
      public val CLEAR_COLOR_MASK: DrawFlags = DrawFlags(255)

      /**
       * Clear all color attachments.
       */
      @JvmField
      public val CLEAR_COLOR_ALL: DrawFlags = DrawFlags(255)

      /**
       * Ignore the previous contents of the first color attachment.
       */
      @JvmField
      public val IGNORE_COLOR_0: DrawFlags = DrawFlags(256)

      /**
       * Ignore the previous contents of the second color attachment.
       */
      @JvmField
      public val IGNORE_COLOR_1: DrawFlags = DrawFlags(512)

      /**
       * Ignore the previous contents of the third color attachment.
       */
      @JvmField
      public val IGNORE_COLOR_2: DrawFlags = DrawFlags(1024)

      /**
       * Ignore the previous contents of the fourth color attachment.
       */
      @JvmField
      public val IGNORE_COLOR_3: DrawFlags = DrawFlags(2048)

      /**
       * Ignore the previous contents of the fifth color attachment.
       */
      @JvmField
      public val IGNORE_COLOR_4: DrawFlags = DrawFlags(4096)

      /**
       * Ignore the previous contents of the sixth color attachment.
       */
      @JvmField
      public val IGNORE_COLOR_5: DrawFlags = DrawFlags(8192)

      /**
       * Ignore the previous contents of the seventh color attachment.
       */
      @JvmField
      public val IGNORE_COLOR_6: DrawFlags = DrawFlags(16384)

      /**
       * Ignore the previous contents of the eighth color attachment.
       */
      @JvmField
      public val IGNORE_COLOR_7: DrawFlags = DrawFlags(32768)

      /**
       * Mask for ignoring all the previous contents of the color attachments.
       */
      @JvmField
      public val IGNORE_COLOR_MASK: DrawFlags = DrawFlags(65280)

      /**
       * Ignore the previous contents of all color attachments.
       */
      @JvmField
      public val IGNORE_COLOR_ALL: DrawFlags = DrawFlags(65280)

      /**
       * Clear the depth attachment.
       */
      @JvmField
      public val CLEAR_DEPTH: DrawFlags = DrawFlags(65536)

      /**
       * Ignore the previous contents of the depth attachment.
       */
      @JvmField
      public val IGNORE_DEPTH: DrawFlags = DrawFlags(131072)

      /**
       * Clear the stencil attachment.
       */
      @JvmField
      public val CLEAR_STENCIL: DrawFlags = DrawFlags(262144)

      /**
       * Ignore the previous contents of the stencil attachment.
       */
      @JvmField
      public val IGNORE_STENCIL: DrawFlags = DrawFlags(524288)

      /**
       * Clear all attachments.
       */
      @JvmField
      public val CLEAR_ALL: DrawFlags = DrawFlags(327935)

      /**
       * Ignore the previous contents of all attachments.
       */
      @JvmField
      public val IGNORE_ALL: DrawFlags = DrawFlags(720640)
    }
  }

  public companion object {
    @JvmField
    public val textureCreateName:
        MethodStringName3<RenderingDevice, RID, RDTextureFormat?, RDTextureView?, VariantArray<PackedByteArray>>
        =
        MethodStringName3<RenderingDevice, RID, RDTextureFormat?, RDTextureView?, VariantArray<PackedByteArray>>("texture_create")

    @JvmField
    public val textureCreateSharedName: MethodStringName2<RenderingDevice, RID, RDTextureView?, RID>
        = MethodStringName2<RenderingDevice, RID, RDTextureView?, RID>("texture_create_shared")

    @JvmField
    public val textureCreateSharedFromSliceName:
        MethodStringName6<RenderingDevice, RID, RDTextureView?, RID, Long, Long, Long, TextureSliceType>
        =
        MethodStringName6<RenderingDevice, RID, RDTextureView?, RID, Long, Long, Long, TextureSliceType>("texture_create_shared_from_slice")

    @JvmField
    public val textureCreateFromExtensionName:
        MethodStringName10<RenderingDevice, RID, TextureType, DataFormat, TextureSamples, TextureUsageBits, Long, Long, Long, Long, Long, Long>
        =
        MethodStringName10<RenderingDevice, RID, TextureType, DataFormat, TextureSamples, TextureUsageBits, Long, Long, Long, Long, Long, Long>("texture_create_from_extension")

    @JvmField
    public val textureUpdateName:
        MethodStringName3<RenderingDevice, Error, RID, Long, PackedByteArray> =
        MethodStringName3<RenderingDevice, Error, RID, Long, PackedByteArray>("texture_update")

    @JvmField
    public val textureGetDataName: MethodStringName2<RenderingDevice, PackedByteArray, RID, Long> =
        MethodStringName2<RenderingDevice, PackedByteArray, RID, Long>("texture_get_data")

    @JvmField
    public val textureGetDataAsyncName:
        MethodStringName3<RenderingDevice, Error, RID, Long, Callable> =
        MethodStringName3<RenderingDevice, Error, RID, Long, Callable>("texture_get_data_async")

    @JvmField
    public val textureIsFormatSupportedForUsageName:
        MethodStringName2<RenderingDevice, Boolean, DataFormat, TextureUsageBits> =
        MethodStringName2<RenderingDevice, Boolean, DataFormat, TextureUsageBits>("texture_is_format_supported_for_usage")

    @JvmField
    public val textureIsSharedName: MethodStringName1<RenderingDevice, Boolean, RID> =
        MethodStringName1<RenderingDevice, Boolean, RID>("texture_is_shared")

    @JvmField
    public val textureIsValidName: MethodStringName1<RenderingDevice, Boolean, RID> =
        MethodStringName1<RenderingDevice, Boolean, RID>("texture_is_valid")

    @JvmField
    public val textureSetDiscardableName: MethodStringName2<RenderingDevice, Unit, RID, Boolean> =
        MethodStringName2<RenderingDevice, Unit, RID, Boolean>("texture_set_discardable")

    @JvmField
    public val textureIsDiscardableName: MethodStringName1<RenderingDevice, Boolean, RID> =
        MethodStringName1<RenderingDevice, Boolean, RID>("texture_is_discardable")

    @JvmField
    public val textureCopyName:
        MethodStringName9<RenderingDevice, Error, RID, RID, Vector3, Vector3, Vector3, Long, Long, Long, Long>
        =
        MethodStringName9<RenderingDevice, Error, RID, RID, Vector3, Vector3, Vector3, Long, Long, Long, Long>("texture_copy")

    @JvmField
    public val textureClearName:
        MethodStringName6<RenderingDevice, Error, RID, Color, Long, Long, Long, Long> =
        MethodStringName6<RenderingDevice, Error, RID, Color, Long, Long, Long, Long>("texture_clear")

    @JvmField
    public val textureResolveMultisampleName: MethodStringName2<RenderingDevice, Error, RID, RID> =
        MethodStringName2<RenderingDevice, Error, RID, RID>("texture_resolve_multisample")

    @JvmField
    public val textureGetFormatName: MethodStringName1<RenderingDevice, RDTextureFormat?, RID> =
        MethodStringName1<RenderingDevice, RDTextureFormat?, RID>("texture_get_format")

    @JvmField
    public val textureGetNativeHandleName: MethodStringName1<RenderingDevice, Long, RID> =
        MethodStringName1<RenderingDevice, Long, RID>("texture_get_native_handle")

    @JvmField
    public val framebufferFormatCreateName:
        MethodStringName2<RenderingDevice, Long, VariantArray<RDAttachmentFormat>, Long> =
        MethodStringName2<RenderingDevice, Long, VariantArray<RDAttachmentFormat>, Long>("framebuffer_format_create")

    @JvmField
    public val framebufferFormatCreateMultipassName:
        MethodStringName3<RenderingDevice, Long, VariantArray<RDAttachmentFormat>, VariantArray<RDFramebufferPass>, Long>
        =
        MethodStringName3<RenderingDevice, Long, VariantArray<RDAttachmentFormat>, VariantArray<RDFramebufferPass>, Long>("framebuffer_format_create_multipass")

    @JvmField
    public val framebufferFormatCreateEmptyName:
        MethodStringName1<RenderingDevice, Long, TextureSamples> =
        MethodStringName1<RenderingDevice, Long, TextureSamples>("framebuffer_format_create_empty")

    @JvmField
    public val framebufferFormatGetTextureSamplesName:
        MethodStringName2<RenderingDevice, TextureSamples, Long, Long> =
        MethodStringName2<RenderingDevice, TextureSamples, Long, Long>("framebuffer_format_get_texture_samples")

    @JvmField
    public val framebufferCreateName:
        MethodStringName3<RenderingDevice, RID, VariantArray<RID>, Long, Long> =
        MethodStringName3<RenderingDevice, RID, VariantArray<RID>, Long, Long>("framebuffer_create")

    @JvmField
    public val framebufferCreateMultipassName:
        MethodStringName4<RenderingDevice, RID, VariantArray<RID>, VariantArray<RDFramebufferPass>, Long, Long>
        =
        MethodStringName4<RenderingDevice, RID, VariantArray<RID>, VariantArray<RDFramebufferPass>, Long, Long>("framebuffer_create_multipass")

    @JvmField
    public val framebufferCreateEmptyName:
        MethodStringName3<RenderingDevice, RID, Vector2i, TextureSamples, Long> =
        MethodStringName3<RenderingDevice, RID, Vector2i, TextureSamples, Long>("framebuffer_create_empty")

    @JvmField
    public val framebufferGetFormatName: MethodStringName1<RenderingDevice, Long, RID> =
        MethodStringName1<RenderingDevice, Long, RID>("framebuffer_get_format")

    @JvmField
    public val framebufferIsValidName: MethodStringName1<RenderingDevice, Boolean, RID> =
        MethodStringName1<RenderingDevice, Boolean, RID>("framebuffer_is_valid")

    @JvmField
    public val samplerCreateName: MethodStringName1<RenderingDevice, RID, RDSamplerState?> =
        MethodStringName1<RenderingDevice, RID, RDSamplerState?>("sampler_create")

    @JvmField
    public val samplerIsFormatSupportedForFilterName:
        MethodStringName2<RenderingDevice, Boolean, DataFormat, SamplerFilter> =
        MethodStringName2<RenderingDevice, Boolean, DataFormat, SamplerFilter>("sampler_is_format_supported_for_filter")

    @JvmField
    public val vertexBufferCreateName:
        MethodStringName3<RenderingDevice, RID, Long, PackedByteArray, BufferCreationBits> =
        MethodStringName3<RenderingDevice, RID, Long, PackedByteArray, BufferCreationBits>("vertex_buffer_create")

    @JvmField
    public val vertexFormatCreateName:
        MethodStringName1<RenderingDevice, Long, VariantArray<RDVertexAttribute>> =
        MethodStringName1<RenderingDevice, Long, VariantArray<RDVertexAttribute>>("vertex_format_create")

    @JvmField
    public val vertexArrayCreateName:
        MethodStringName4<RenderingDevice, RID, Long, Long, VariantArray<RID>, PackedInt64Array> =
        MethodStringName4<RenderingDevice, RID, Long, Long, VariantArray<RID>, PackedInt64Array>("vertex_array_create")

    @JvmField
    public val indexBufferCreateName:
        MethodStringName5<RenderingDevice, RID, Long, IndexBufferFormat, PackedByteArray, Boolean, BufferCreationBits>
        =
        MethodStringName5<RenderingDevice, RID, Long, IndexBufferFormat, PackedByteArray, Boolean, BufferCreationBits>("index_buffer_create")

    @JvmField
    public val indexArrayCreateName: MethodStringName3<RenderingDevice, RID, RID, Long, Long> =
        MethodStringName3<RenderingDevice, RID, RID, Long, Long>("index_array_create")

    @JvmField
    public val shaderCompileSpirvFromSourceName:
        MethodStringName2<RenderingDevice, RDShaderSPIRV?, RDShaderSource?, Boolean> =
        MethodStringName2<RenderingDevice, RDShaderSPIRV?, RDShaderSource?, Boolean>("shader_compile_spirv_from_source")

    @JvmField
    public val shaderCompileBinaryFromSpirvName:
        MethodStringName2<RenderingDevice, PackedByteArray, RDShaderSPIRV?, String> =
        MethodStringName2<RenderingDevice, PackedByteArray, RDShaderSPIRV?, String>("shader_compile_binary_from_spirv")

    @JvmField
    public val shaderCreateFromSpirvName:
        MethodStringName2<RenderingDevice, RID, RDShaderSPIRV?, String> =
        MethodStringName2<RenderingDevice, RID, RDShaderSPIRV?, String>("shader_create_from_spirv")

    @JvmField
    public val shaderCreateFromBytecodeName:
        MethodStringName2<RenderingDevice, RID, PackedByteArray, RID> =
        MethodStringName2<RenderingDevice, RID, PackedByteArray, RID>("shader_create_from_bytecode")

    @JvmField
    public val shaderCreatePlaceholderName: MethodStringName0<RenderingDevice, RID> =
        MethodStringName0<RenderingDevice, RID>("shader_create_placeholder")

    @JvmField
    public val shaderGetVertexInputAttributeMaskName: MethodStringName1<RenderingDevice, Long, RID>
        = MethodStringName1<RenderingDevice, Long, RID>("shader_get_vertex_input_attribute_mask")

    @JvmField
    public val uniformBufferCreateName:
        MethodStringName3<RenderingDevice, RID, Long, PackedByteArray, BufferCreationBits> =
        MethodStringName3<RenderingDevice, RID, Long, PackedByteArray, BufferCreationBits>("uniform_buffer_create")

    @JvmField
    public val storageBufferCreateName:
        MethodStringName4<RenderingDevice, RID, Long, PackedByteArray, StorageBufferUsage, BufferCreationBits>
        =
        MethodStringName4<RenderingDevice, RID, Long, PackedByteArray, StorageBufferUsage, BufferCreationBits>("storage_buffer_create")

    @JvmField
    public val textureBufferCreateName:
        MethodStringName3<RenderingDevice, RID, Long, DataFormat, PackedByteArray> =
        MethodStringName3<RenderingDevice, RID, Long, DataFormat, PackedByteArray>("texture_buffer_create")

    @JvmField
    public val uniformSetCreateName:
        MethodStringName3<RenderingDevice, RID, VariantArray<RDUniform>, RID, Long> =
        MethodStringName3<RenderingDevice, RID, VariantArray<RDUniform>, RID, Long>("uniform_set_create")

    @JvmField
    public val uniformSetIsValidName: MethodStringName1<RenderingDevice, Boolean, RID> =
        MethodStringName1<RenderingDevice, Boolean, RID>("uniform_set_is_valid")

    @JvmField
    public val bufferCopyName: MethodStringName5<RenderingDevice, Error, RID, RID, Long, Long, Long>
        = MethodStringName5<RenderingDevice, Error, RID, RID, Long, Long, Long>("buffer_copy")

    @JvmField
    public val bufferUpdateName:
        MethodStringName4<RenderingDevice, Error, RID, Long, Long, PackedByteArray> =
        MethodStringName4<RenderingDevice, Error, RID, Long, Long, PackedByteArray>("buffer_update")

    @JvmField
    public val bufferClearName: MethodStringName3<RenderingDevice, Error, RID, Long, Long> =
        MethodStringName3<RenderingDevice, Error, RID, Long, Long>("buffer_clear")

    @JvmField
    public val bufferGetDataName:
        MethodStringName3<RenderingDevice, PackedByteArray, RID, Long, Long> =
        MethodStringName3<RenderingDevice, PackedByteArray, RID, Long, Long>("buffer_get_data")

    @JvmField
    public val bufferGetDataAsyncName:
        MethodStringName4<RenderingDevice, Error, RID, Callable, Long, Long> =
        MethodStringName4<RenderingDevice, Error, RID, Callable, Long, Long>("buffer_get_data_async")

    @JvmField
    public val bufferGetDeviceAddressName: MethodStringName1<RenderingDevice, Long, RID> =
        MethodStringName1<RenderingDevice, Long, RID>("buffer_get_device_address")

    @JvmField
    public val renderPipelineCreateName:
        MethodStringName11<RenderingDevice, RID, RID, Long, Long, RenderPrimitive, RDPipelineRasterizationState?, RDPipelineMultisampleState?, RDPipelineDepthStencilState?, RDPipelineColorBlendState?, PipelineDynamicStateFlags, Long, VariantArray<RDPipelineSpecializationConstant>>
        =
        MethodStringName11<RenderingDevice, RID, RID, Long, Long, RenderPrimitive, RDPipelineRasterizationState?, RDPipelineMultisampleState?, RDPipelineDepthStencilState?, RDPipelineColorBlendState?, PipelineDynamicStateFlags, Long, VariantArray<RDPipelineSpecializationConstant>>("render_pipeline_create")

    @JvmField
    public val renderPipelineIsValidName: MethodStringName1<RenderingDevice, Boolean, RID> =
        MethodStringName1<RenderingDevice, Boolean, RID>("render_pipeline_is_valid")

    @JvmField
    public val computePipelineCreateName:
        MethodStringName2<RenderingDevice, RID, RID, VariantArray<RDPipelineSpecializationConstant>>
        =
        MethodStringName2<RenderingDevice, RID, RID, VariantArray<RDPipelineSpecializationConstant>>("compute_pipeline_create")

    @JvmField
    public val computePipelineIsValidName: MethodStringName1<RenderingDevice, Boolean, RID> =
        MethodStringName1<RenderingDevice, Boolean, RID>("compute_pipeline_is_valid")

    @JvmField
    public val raytracingPipelineCreateName:
        MethodStringName4<RenderingDevice, RID, VariantArray<RDPipelineShader>, VariantArray<RDPipelineShader>, VariantArray<RDHitGroup>, Long>
        =
        MethodStringName4<RenderingDevice, RID, VariantArray<RDPipelineShader>, VariantArray<RDPipelineShader>, VariantArray<RDHitGroup>, Long>("raytracing_pipeline_create")

    @JvmField
    public val raytracingPipelineIsValidName: MethodStringName1<RenderingDevice, Boolean, RID> =
        MethodStringName1<RenderingDevice, Boolean, RID>("raytracing_pipeline_is_valid")

    @JvmField
    public val blasCreateName:
        MethodStringName2<RenderingDevice, RID, VariantArray<RDAccelerationStructureGeometry>, AccelerationStructureFlagBits>
        =
        MethodStringName2<RenderingDevice, RID, VariantArray<RDAccelerationStructureGeometry>, AccelerationStructureFlagBits>("blas_create")

    @JvmField
    public val tlasCreateName:
        MethodStringName2<RenderingDevice, RID, Long, AccelerationStructureFlagBits> =
        MethodStringName2<RenderingDevice, RID, Long, AccelerationStructureFlagBits>("tlas_create")

    @JvmField
    public val blasBuildName: MethodStringName1<RenderingDevice, Error, RID> =
        MethodStringName1<RenderingDevice, Error, RID>("blas_build")

    @JvmField
    public val tlasBuildName:
        MethodStringName2<RenderingDevice, Error, RID, VariantArray<RDAccelerationStructureInstance>>
        =
        MethodStringName2<RenderingDevice, Error, RID, VariantArray<RDAccelerationStructureInstance>>("tlas_build")

    @JvmField
    public val hitSbtCreateName: MethodStringName2<RenderingDevice, RID, RID, Long> =
        MethodStringName2<RenderingDevice, RID, RID, Long>("hit_sbt_create")

    @JvmField
    public val hitSbtSetPipelineName: MethodStringName2<RenderingDevice, Error, RID, RID> =
        MethodStringName2<RenderingDevice, Error, RID, RID>("hit_sbt_set_pipeline")

    @JvmField
    public val hitSbtRangeAllocName: MethodStringName2<RenderingDevice, Long, RID, Long> =
        MethodStringName2<RenderingDevice, Long, RID, Long>("hit_sbt_range_alloc")

    @JvmField
    public val hitSbtRangeFreeName: MethodStringName2<RenderingDevice, Error, RID, Long> =
        MethodStringName2<RenderingDevice, Error, RID, Long>("hit_sbt_range_free")

    @JvmField
    public val hitSbtRangeUpdateName:
        MethodStringName4<RenderingDevice, Error, RID, Long, Long, PackedInt32Array> =
        MethodStringName4<RenderingDevice, Error, RID, Long, Long, PackedInt32Array>("hit_sbt_range_update")

    @JvmField
    public val screenGetWidthName: MethodStringName1<RenderingDevice, Int, Int> =
        MethodStringName1<RenderingDevice, Int, Int>("screen_get_width")

    @JvmField
    public val screenGetHeightName: MethodStringName1<RenderingDevice, Int, Int> =
        MethodStringName1<RenderingDevice, Int, Int>("screen_get_height")

    @JvmField
    public val screenGetFramebufferFormatName: MethodStringName1<RenderingDevice, Long, Int> =
        MethodStringName1<RenderingDevice, Long, Int>("screen_get_framebuffer_format")

    @JvmField
    public val drawListBeginForScreenName: MethodStringName2<RenderingDevice, Long, Int, Color> =
        MethodStringName2<RenderingDevice, Long, Int, Color>("draw_list_begin_for_screen")

    @JvmField
    public val drawListBeginName:
        MethodStringName7<RenderingDevice, Long, RID, DrawFlags, PackedColorArray, Float, Long, Rect2, Long>
        =
        MethodStringName7<RenderingDevice, Long, RID, DrawFlags, PackedColorArray, Float, Long, Rect2, Long>("draw_list_begin")

    @JvmField
    public val drawListBeginSplitName:
        MethodStringName11<RenderingDevice, PackedInt64Array, RID, Long, InitialAction, FinalAction, InitialAction, FinalAction, PackedColorArray, Float, Long, Rect2, VariantArray<RID>>
        =
        MethodStringName11<RenderingDevice, PackedInt64Array, RID, Long, InitialAction, FinalAction, InitialAction, FinalAction, PackedColorArray, Float, Long, Rect2, VariantArray<RID>>("draw_list_begin_split")

    @JvmField
    public val drawListSetBlendConstantsName: MethodStringName2<RenderingDevice, Unit, Long, Color>
        = MethodStringName2<RenderingDevice, Unit, Long, Color>("draw_list_set_blend_constants")

    @JvmField
    public val drawListBindRenderPipelineName: MethodStringName2<RenderingDevice, Unit, Long, RID> =
        MethodStringName2<RenderingDevice, Unit, Long, RID>("draw_list_bind_render_pipeline")

    @JvmField
    public val drawListBindUniformSetName: MethodStringName3<RenderingDevice, Unit, Long, RID, Long>
        = MethodStringName3<RenderingDevice, Unit, Long, RID, Long>("draw_list_bind_uniform_set")

    @JvmField
    public val drawListBindVertexArrayName: MethodStringName2<RenderingDevice, Unit, Long, RID> =
        MethodStringName2<RenderingDevice, Unit, Long, RID>("draw_list_bind_vertex_array")

    @JvmField
    public val drawListBindVertexBuffersFormatName:
        MethodStringName5<RenderingDevice, Unit, Long, Long, Long, VariantArray<RID>, PackedInt64Array>
        =
        MethodStringName5<RenderingDevice, Unit, Long, Long, Long, VariantArray<RID>, PackedInt64Array>("draw_list_bind_vertex_buffers_format")

    @JvmField
    public val drawListBindIndexArrayName: MethodStringName2<RenderingDevice, Unit, Long, RID> =
        MethodStringName2<RenderingDevice, Unit, Long, RID>("draw_list_bind_index_array")

    @JvmField
    public val drawListSetPushConstantName:
        MethodStringName3<RenderingDevice, Unit, Long, PackedByteArray, Long> =
        MethodStringName3<RenderingDevice, Unit, Long, PackedByteArray, Long>("draw_list_set_push_constant")

    @JvmField
    public val drawListDrawName: MethodStringName4<RenderingDevice, Unit, Long, Boolean, Long, Long>
        = MethodStringName4<RenderingDevice, Unit, Long, Boolean, Long, Long>("draw_list_draw")

    @JvmField
    public val drawListDrawIndirectName:
        MethodStringName6<RenderingDevice, Unit, Long, Boolean, RID, Long, Long, Long> =
        MethodStringName6<RenderingDevice, Unit, Long, Boolean, RID, Long, Long, Long>("draw_list_draw_indirect")

    @JvmField
    public val drawListEnableScissorName: MethodStringName2<RenderingDevice, Unit, Long, Rect2> =
        MethodStringName2<RenderingDevice, Unit, Long, Rect2>("draw_list_enable_scissor")

    @JvmField
    public val drawListDisableScissorName: MethodStringName1<RenderingDevice, Unit, Long> =
        MethodStringName1<RenderingDevice, Unit, Long>("draw_list_disable_scissor")

    @JvmField
    public val drawListSwitchToNextPassName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("draw_list_switch_to_next_pass")

    @JvmField
    public val drawListSwitchToNextPassSplitName:
        MethodStringName1<RenderingDevice, PackedInt64Array, Long> =
        MethodStringName1<RenderingDevice, PackedInt64Array, Long>("draw_list_switch_to_next_pass_split")

    @JvmField
    public val drawListEndName: MethodStringName0<RenderingDevice, Unit> =
        MethodStringName0<RenderingDevice, Unit>("draw_list_end")

    @JvmField
    public val computeListBeginName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("compute_list_begin")

    @JvmField
    public val computeListBindComputePipelineName:
        MethodStringName2<RenderingDevice, Unit, Long, RID> =
        MethodStringName2<RenderingDevice, Unit, Long, RID>("compute_list_bind_compute_pipeline")

    @JvmField
    public val computeListSetPushConstantName:
        MethodStringName3<RenderingDevice, Unit, Long, PackedByteArray, Long> =
        MethodStringName3<RenderingDevice, Unit, Long, PackedByteArray, Long>("compute_list_set_push_constant")

    @JvmField
    public val computeListBindUniformSetName:
        MethodStringName3<RenderingDevice, Unit, Long, RID, Long> =
        MethodStringName3<RenderingDevice, Unit, Long, RID, Long>("compute_list_bind_uniform_set")

    @JvmField
    public val computeListDispatchName:
        MethodStringName4<RenderingDevice, Unit, Long, Long, Long, Long> =
        MethodStringName4<RenderingDevice, Unit, Long, Long, Long, Long>("compute_list_dispatch")

    @JvmField
    public val computeListDispatchIndirectName:
        MethodStringName3<RenderingDevice, Unit, Long, RID, Long> =
        MethodStringName3<RenderingDevice, Unit, Long, RID, Long>("compute_list_dispatch_indirect")

    @JvmField
    public val computeListAddBarrierName: MethodStringName1<RenderingDevice, Unit, Long> =
        MethodStringName1<RenderingDevice, Unit, Long>("compute_list_add_barrier")

    @JvmField
    public val computeListEndName: MethodStringName0<RenderingDevice, Unit> =
        MethodStringName0<RenderingDevice, Unit>("compute_list_end")

    @JvmField
    public val raytracingListBeginName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("raytracing_list_begin")

    @JvmField
    public val raytracingListBindRaytracingPipelineName:
        MethodStringName2<RenderingDevice, Unit, Long, RID> =
        MethodStringName2<RenderingDevice, Unit, Long, RID>("raytracing_list_bind_raytracing_pipeline")

    @JvmField
    public val raytracingListSetPushConstantName:
        MethodStringName3<RenderingDevice, Unit, Long, PackedByteArray, Long> =
        MethodStringName3<RenderingDevice, Unit, Long, PackedByteArray, Long>("raytracing_list_set_push_constant")

    @JvmField
    public val raytracingListBindUniformSetName:
        MethodStringName3<RenderingDevice, Unit, Long, RID, Long> =
        MethodStringName3<RenderingDevice, Unit, Long, RID, Long>("raytracing_list_bind_uniform_set")

    @JvmField
    public val raytracingListTraceRaysName:
        MethodStringName6<RenderingDevice, Unit, Long, Long, RID, Long, Long, Long> =
        MethodStringName6<RenderingDevice, Unit, Long, Long, RID, Long, Long, Long>("raytracing_list_trace_rays")

    @JvmField
    public val raytracingListEndName: MethodStringName0<RenderingDevice, Unit> =
        MethodStringName0<RenderingDevice, Unit>("raytracing_list_end")

    @JvmField
    public val freeRidName: MethodStringName1<RenderingDevice, Unit, RID> =
        MethodStringName1<RenderingDevice, Unit, RID>("free_rid")

    @JvmField
    public val captureTimestampName: MethodStringName1<RenderingDevice, Unit, String> =
        MethodStringName1<RenderingDevice, Unit, String>("capture_timestamp")

    @JvmField
    public val getCapturedTimestampsCountName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("get_captured_timestamps_count")

    @JvmField
    public val getCapturedTimestampsFrameName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("get_captured_timestamps_frame")

    @JvmField
    public val getCapturedTimestampGpuTimeName: MethodStringName1<RenderingDevice, Long, Long> =
        MethodStringName1<RenderingDevice, Long, Long>("get_captured_timestamp_gpu_time")

    @JvmField
    public val getCapturedTimestampCpuTimeName: MethodStringName1<RenderingDevice, Long, Long> =
        MethodStringName1<RenderingDevice, Long, Long>("get_captured_timestamp_cpu_time")

    @JvmField
    public val getCapturedTimestampNameName: MethodStringName1<RenderingDevice, String, Long> =
        MethodStringName1<RenderingDevice, String, Long>("get_captured_timestamp_name")

    @JvmField
    public val hasFeatureName: MethodStringName1<RenderingDevice, Boolean, Features> =
        MethodStringName1<RenderingDevice, Boolean, Features>("has_feature")

    @JvmField
    public val limitGetName: MethodStringName1<RenderingDevice, Long, Limit> =
        MethodStringName1<RenderingDevice, Long, Limit>("limit_get")

    @JvmField
    public val getFrameDelayName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("get_frame_delay")

    @JvmField
    public val submitName: MethodStringName0<RenderingDevice, Unit> =
        MethodStringName0<RenderingDevice, Unit>("submit")

    @JvmField
    public val syncName: MethodStringName0<RenderingDevice, Unit> =
        MethodStringName0<RenderingDevice, Unit>("sync")

    @JvmField
    public val barrierName: MethodStringName2<RenderingDevice, Unit, BarrierMask, BarrierMask> =
        MethodStringName2<RenderingDevice, Unit, BarrierMask, BarrierMask>("barrier")

    @JvmField
    public val fullBarrierName: MethodStringName0<RenderingDevice, Unit> =
        MethodStringName0<RenderingDevice, Unit>("full_barrier")

    @JvmField
    public val createLocalDeviceName: MethodStringName0<RenderingDevice, RenderingDevice?> =
        MethodStringName0<RenderingDevice, RenderingDevice?>("create_local_device")

    @JvmField
    public val setResourceNameName: MethodStringName2<RenderingDevice, Unit, RID, String> =
        MethodStringName2<RenderingDevice, Unit, RID, String>("set_resource_name")

    @JvmField
    public val drawCommandBeginLabelName: MethodStringName2<RenderingDevice, Unit, String, Color> =
        MethodStringName2<RenderingDevice, Unit, String, Color>("draw_command_begin_label")

    @JvmField
    public val drawCommandInsertLabelName: MethodStringName2<RenderingDevice, Unit, String, Color> =
        MethodStringName2<RenderingDevice, Unit, String, Color>("draw_command_insert_label")

    @JvmField
    public val drawCommandEndLabelName: MethodStringName0<RenderingDevice, Unit> =
        MethodStringName0<RenderingDevice, Unit>("draw_command_end_label")

    @JvmField
    public val getDeviceVendorNameName: MethodStringName0<RenderingDevice, String> =
        MethodStringName0<RenderingDevice, String>("get_device_vendor_name")

    @JvmField
    public val getDeviceNameName: MethodStringName0<RenderingDevice, String> =
        MethodStringName0<RenderingDevice, String>("get_device_name")

    @JvmField
    public val getDevicePipelineCacheUuidName: MethodStringName0<RenderingDevice, String> =
        MethodStringName0<RenderingDevice, String>("get_device_pipeline_cache_uuid")

    @JvmField
    public val getMemoryUsageName: MethodStringName1<RenderingDevice, Long, MemoryType> =
        MethodStringName1<RenderingDevice, Long, MemoryType>("get_memory_usage")

    @JvmField
    public val getDriverResourceName:
        MethodStringName3<RenderingDevice, Long, DriverResource, RID, Long> =
        MethodStringName3<RenderingDevice, Long, DriverResource, RID, Long>("get_driver_resource")

    @JvmField
    public val getPerfReportName: MethodStringName0<RenderingDevice, String> =
        MethodStringName0<RenderingDevice, String>("get_perf_report")

    @JvmField
    public val getDriverAndDeviceMemoryReportName: MethodStringName0<RenderingDevice, String> =
        MethodStringName0<RenderingDevice, String>("get_driver_and_device_memory_report")

    @JvmField
    public val getTrackedObjectNameName: MethodStringName1<RenderingDevice, String, Long> =
        MethodStringName1<RenderingDevice, String, Long>("get_tracked_object_name")

    @JvmField
    public val getTrackedObjectTypeCountName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("get_tracked_object_type_count")

    @JvmField
    public val getDriverTotalMemoryName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("get_driver_total_memory")

    @JvmField
    public val getDriverAllocationCountName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("get_driver_allocation_count")

    @JvmField
    public val getDriverMemoryByObjectTypeName: MethodStringName1<RenderingDevice, Long, Long> =
        MethodStringName1<RenderingDevice, Long, Long>("get_driver_memory_by_object_type")

    @JvmField
    public val getDriverAllocsByObjectTypeName: MethodStringName1<RenderingDevice, Long, Long> =
        MethodStringName1<RenderingDevice, Long, Long>("get_driver_allocs_by_object_type")

    @JvmField
    public val getDeviceTotalMemoryName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("get_device_total_memory")

    @JvmField
    public val getDeviceAllocationCountName: MethodStringName0<RenderingDevice, Long> =
        MethodStringName0<RenderingDevice, Long>("get_device_allocation_count")

    @JvmField
    public val getDeviceMemoryByObjectTypeName: MethodStringName1<RenderingDevice, Long, Long> =
        MethodStringName1<RenderingDevice, Long, Long>("get_device_memory_by_object_type")

    @JvmField
    public val getDeviceAllocsByObjectTypeName: MethodStringName1<RenderingDevice, Long, Long> =
        MethodStringName1<RenderingDevice, Long, Long>("get_device_allocs_by_object_type")

    /**
     * Returned by functions that return an ID if a value is invalid.
     */
    public final const val INVALID_ID: Long = -1

    /**
     * Returned by functions that return a format ID if a value is invalid.
     */
    public final const val INVALID_FORMAT_ID: Long = -1
  }

  public object MethodBindings {
    internal val textureCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_create", 3709173589)

    internal val textureCreateSharedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_create_shared", 3178156134)

    internal val textureCreateSharedFromSlicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_create_shared_from_slice", 1808971279)

    internal val textureCreateFromExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_create_from_extension", 3732868568)

    internal val textureUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_update", 1349464008)

    internal val textureGetDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_get_data", 1859412099)

    internal val textureGetDataAsyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_get_data_async", 498832090)

    internal val textureIsFormatSupportedForUsagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_is_format_supported_for_usage", 2592520478)

    internal val textureIsSharedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_is_shared", 3521089500)

    internal val textureIsValidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_is_valid", 3521089500)

    internal val textureSetDiscardablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_set_discardable", 1265174801)

    internal val textureIsDiscardablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_is_discardable", 3521089500)

    internal val textureCopyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_copy", 2859522160)

    internal val textureClearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_clear", 3477703247)

    internal val textureResolveMultisamplePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_resolve_multisample", 3181288260)

    internal val textureGetFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_get_format", 1374471690)

    internal val textureGetNativeHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_get_native_handle", 3917799429)

    internal val framebufferFormatCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_format_create", 697032759)

    internal val framebufferFormatCreateMultipassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_format_create_multipass", 2647479094)

    internal val framebufferFormatCreateEmptyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_format_create_empty", 555930169)

    internal val framebufferFormatGetTextureSamplesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_format_get_texture_samples", 4223391010)

    internal val framebufferCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_create", 3284231055)

    internal val framebufferCreateMultipassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_create_multipass", 1750306695)

    internal val framebufferCreateEmptyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_create_empty", 3058360618)

    internal val framebufferGetFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_get_format", 3917799429)

    internal val framebufferIsValidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "framebuffer_is_valid", 4155700596)

    internal val samplerCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "sampler_create", 2327892535)

    internal val samplerIsFormatSupportedForFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "sampler_is_format_supported_for_filter", 2247922238)

    internal val vertexBufferCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "vertex_buffer_create", 2089548973)

    internal val vertexFormatCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "vertex_format_create", 1242678479)

    internal val vertexArrayCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "vertex_array_create", 3799816279)

    internal val indexBufferCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "index_buffer_create", 2368684885)

    internal val indexArrayCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "index_array_create", 2256026069)

    internal val shaderCompileSpirvFromSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "shader_compile_spirv_from_source", 1178973306)

    internal val shaderCompileBinaryFromSpirvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "shader_compile_binary_from_spirv", 134910450)

    internal val shaderCreateFromSpirvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "shader_create_from_spirv", 342949005)

    internal val shaderCreateFromBytecodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "shader_create_from_bytecode", 1687031350)

    internal val shaderCreatePlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "shader_create_placeholder", 529393457)

    internal val shaderGetVertexInputAttributeMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "shader_get_vertex_input_attribute_mask", 3917799429)

    internal val uniformBufferCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "uniform_buffer_create", 2089548973)

    internal val storageBufferCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "storage_buffer_create", 1609052553)

    internal val textureBufferCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "texture_buffer_create", 1470338698)

    internal val uniformSetCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "uniform_set_create", 2280795797)

    internal val uniformSetIsValidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "uniform_set_is_valid", 3521089500)

    internal val bufferCopyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "buffer_copy", 864257779)

    internal val bufferUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "buffer_update", 3454956949)

    internal val bufferClearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "buffer_clear", 2452320800)

    internal val bufferGetDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "buffer_get_data", 3101830688)

    internal val bufferGetDataAsyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "buffer_get_data_async", 2370287848)

    internal val bufferGetDeviceAddressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "buffer_get_device_address", 3917799429)

    internal val renderPipelineCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "render_pipeline_create", 2385451958)

    internal val renderPipelineIsValidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "render_pipeline_is_valid", 3521089500)

    internal val computePipelineCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_pipeline_create", 1448838280)

    internal val computePipelineIsValidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_pipeline_is_valid", 3521089500)

    internal val raytracingPipelineCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "raytracing_pipeline_create", 1489129684)

    internal val raytracingPipelineIsValidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "raytracing_pipeline_is_valid", 3521089500)

    internal val blasCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "blas_create", 1010940044)

    internal val tlasCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "tlas_create", 592780330)

    internal val blasBuildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "blas_build", 813180755)

    internal val tlasBuildPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "tlas_build", 261981775)

    internal val hitSbtCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "hit_sbt_create", 2233757277)

    internal val hitSbtSetPipelinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "hit_sbt_set_pipeline", 3181288260)

    internal val hitSbtRangeAllocPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "hit_sbt_range_alloc", 2722015314)

    internal val hitSbtRangeFreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "hit_sbt_range_free", 3804025326)

    internal val hitSbtRangeUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "hit_sbt_range_update", 1332346675)

    internal val screenGetWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "screen_get_width", 1591665591)

    internal val screenGetHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "screen_get_height", 1591665591)

    internal val screenGetFramebufferFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "screen_get_framebuffer_format", 1591665591)

    internal val drawListBeginForScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_begin_for_screen", 3988079995)

    internal val drawListBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_begin", 1317926357)

    internal val drawListBeginSplitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_begin_split", 2406300660)

    internal val drawListSetBlendConstantsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_set_blend_constants", 2878471219)

    internal val drawListBindRenderPipelinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_bind_render_pipeline", 4040184819)

    internal val drawListBindUniformSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_bind_uniform_set", 749655778)

    internal val drawListBindVertexArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_bind_vertex_array", 4040184819)

    internal val drawListBindVertexBuffersFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_bind_vertex_buffers_format", 2008628980)

    internal val drawListBindIndexArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_bind_index_array", 4040184819)

    internal val drawListSetPushConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_set_push_constant", 2772371345)

    internal val drawListDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_draw", 4230067973)

    internal val drawListDrawIndirectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_draw_indirect", 1092133571)

    internal val drawListEnableScissorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_enable_scissor", 244650101)

    internal val drawListDisableScissorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_disable_scissor", 1286410249)

    internal val drawListSwitchToNextPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_switch_to_next_pass", 2455072627)

    internal val drawListSwitchToNextPassSplitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_switch_to_next_pass_split", 2865087369)

    internal val drawListEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_list_end", 3218959716)

    internal val computeListBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_list_begin", 2455072627)

    internal val computeListBindComputePipelinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_list_bind_compute_pipeline", 4040184819)

    internal val computeListSetPushConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_list_set_push_constant", 2772371345)

    internal val computeListBindUniformSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_list_bind_uniform_set", 749655778)

    internal val computeListDispatchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_list_dispatch", 4275841770)

    internal val computeListDispatchIndirectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_list_dispatch_indirect", 749655778)

    internal val computeListAddBarrierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_list_add_barrier", 1286410249)

    internal val computeListEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "compute_list_end", 3218959716)

    internal val raytracingListBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "raytracing_list_begin", 2455072627)

    internal val raytracingListBindRaytracingPipelinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "raytracing_list_bind_raytracing_pipeline", 4040184819)

    internal val raytracingListSetPushConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "raytracing_list_set_push_constant", 2772371345)

    internal val raytracingListBindUniformSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "raytracing_list_bind_uniform_set", 749655778)

    internal val raytracingListTraceRaysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "raytracing_list_trace_rays", 2559472681)

    internal val raytracingListEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "raytracing_list_end", 3218959716)

    internal val freeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "free_rid", 2722037293)

    internal val captureTimestampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "capture_timestamp", 83702148)

    internal val getCapturedTimestampsCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_captured_timestamps_count", 3905245786)

    internal val getCapturedTimestampsFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_captured_timestamps_frame", 3905245786)

    internal val getCapturedTimestampGpuTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_captured_timestamp_gpu_time", 923996154)

    internal val getCapturedTimestampCpuTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_captured_timestamp_cpu_time", 923996154)

    internal val getCapturedTimestampNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_captured_timestamp_name", 844755477)

    internal val hasFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "has_feature", 1772728326)

    internal val limitGetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "limit_get", 1559202131)

    internal val getFrameDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_frame_delay", 3905245786)

    internal val submitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "submit", 3218959716)

    internal val syncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "sync", 3218959716)

    internal val barrierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "barrier", 3718155691)

    internal val fullBarrierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "full_barrier", 3218959716)

    internal val createLocalDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "create_local_device", 2846302423)

    internal val setResourceNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "set_resource_name", 2726140452)

    internal val drawCommandBeginLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_command_begin_label", 1636512886)

    internal val drawCommandInsertLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_command_insert_label", 1636512886)

    internal val drawCommandEndLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "draw_command_end_label", 3218959716)

    internal val getDeviceVendorNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_device_vendor_name", 201670096)

    internal val getDeviceNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_device_name", 201670096)

    internal val getDevicePipelineCacheUuidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_device_pipeline_cache_uuid", 201670096)

    internal val getMemoryUsagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_memory_usage", 251690689)

    internal val getDriverResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_driver_resource", 501815484)

    internal val getPerfReportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_perf_report", 201670096)

    internal val getDriverAndDeviceMemoryReportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_driver_and_device_memory_report", 201670096)

    internal val getTrackedObjectNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_tracked_object_name", 844755477)

    internal val getTrackedObjectTypeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_tracked_object_type_count", 3905245786)

    internal val getDriverTotalMemoryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_driver_total_memory", 3905245786)

    internal val getDriverAllocationCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_driver_allocation_count", 3905245786)

    internal val getDriverMemoryByObjectTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_driver_memory_by_object_type", 923996154)

    internal val getDriverAllocsByObjectTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_driver_allocs_by_object_type", 923996154)

    internal val getDeviceTotalMemoryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_device_total_memory", 3905245786)

    internal val getDeviceAllocationCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_device_allocation_count", 3905245786)

    internal val getDeviceMemoryByObjectTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_device_memory_by_object_type", 923996154)

    internal val getDeviceAllocsByObjectTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingDevice", "get_device_allocs_by_object_type", 923996154)
  }
}
