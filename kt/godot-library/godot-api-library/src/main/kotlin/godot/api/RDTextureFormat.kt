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
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDTextureFormat : RefCounted() {
  /**
   * The texture's pixel data format.
   */
  public final inline var format: RenderingDevice.DataFormat
    @JvmName("formatProperty")
    get() = getFormat()
    @JvmName("formatProperty")
    set(`value`) {
      setFormat(value)
    }

  /**
   * The texture's width (in pixels).
   */
  public final inline var width: Long
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * The texture's height (in pixels).
   */
  public final inline var height: Long
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * The texture's depth (in pixels). This is always `1` for 2D textures.
   */
  public final inline var depth: Long
    @JvmName("depthProperty")
    get() = getDepth()
    @JvmName("depthProperty")
    set(`value`) {
      setDepth(value)
    }

  /**
   * The number of layers in the texture. Only relevant for 2D texture arrays.
   */
  public final inline var arrayLayers: Long
    @JvmName("arrayLayersProperty")
    get() = getArrayLayers()
    @JvmName("arrayLayersProperty")
    set(`value`) {
      setArrayLayers(value)
    }

  /**
   * The number of mipmaps available in the texture.
   */
  public final inline var mipmaps: Long
    @JvmName("mipmapsProperty")
    get() = getMipmaps()
    @JvmName("mipmapsProperty")
    set(`value`) {
      setMipmaps(value)
    }

  /**
   * The texture type.
   */
  public final inline var textureType: RenderingDevice.TextureType
    @JvmName("textureTypeProperty")
    get() = getTextureType()
    @JvmName("textureTypeProperty")
    set(`value`) {
      setTextureType(value)
    }

  /**
   * The number of samples used when sampling the texture.
   */
  public final inline var samples: RenderingDevice.TextureSamples
    @JvmName("samplesProperty")
    get() = getSamples()
    @JvmName("samplesProperty")
    set(`value`) {
      setSamples(value)
    }

  /**
   * The texture's usage bits, which determine what can be done using the texture.
   */
  public final inline var usageBits: RenderingDevice.TextureUsageBits
    @JvmName("usageBitsProperty")
    get() = getUsageBits()
    @JvmName("usageBitsProperty")
    set(`value`) {
      setUsageBits(value)
    }

  /**
   * The texture will be used as the destination of a resolve operation.
   */
  public final inline var isResolveBuffer: Boolean
    @JvmName("isResolveBufferProperty")
    get() = getIsResolveBuffer()
    @JvmName("isResolveBufferProperty")
    set(`value`) {
      setIsResolveBuffer(value)
    }

  /**
   * If a texture is discardable, its contents do not need to be preserved between frames. This flag
   * is only relevant when the texture is used as target in a draw list.
   *
   * This information is used by [RenderingDevice] to figure out if a texture's contents can be
   * discarded, eliminating unnecessary writes to memory and boosting performance.
   */
  public final inline var isDiscardable: Boolean
    @JvmName("isDiscardableProperty")
    get() = getIsDiscardable()
    @JvmName("isDiscardableProperty")
    set(`value`) {
      setIsDiscardable(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(593, scriptPtr)
  }

  public final fun setFormat(pMember: RenderingDevice.DataFormat): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setFormatPtr, 0)
  }

  public final fun getFormat(): RenderingDevice.DataFormat {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFormatPtr, 2)
    return RenderingDevice.DataFormat.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setWidth(pMember: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember)
    TransferContext.callPtrMethod(MethodBindings.setWidthPtr, 0)
  }

  public final fun getWidth(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getWidthPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setHeight(pMember: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember)
    TransferContext.callPtrMethod(MethodBindings.setHeightPtr, 0)
  }

  public final fun getHeight(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHeightPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setDepth(pMember: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember)
    TransferContext.callPtrMethod(MethodBindings.setDepthPtr, 0)
  }

  public final fun getDepth(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDepthPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setArrayLayers(pMember: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember)
    TransferContext.callPtrMethod(MethodBindings.setArrayLayersPtr, 0)
  }

  public final fun getArrayLayers(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getArrayLayersPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setMipmaps(pMember: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember)
    TransferContext.callPtrMethod(MethodBindings.setMipmapsPtr, 0)
  }

  public final fun getMipmaps(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMipmapsPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setTextureType(pMember: RenderingDevice.TextureType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setTextureTypePtr, 0)
  }

  public final fun getTextureType(): RenderingDevice.TextureType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextureTypePtr, 2)
    return RenderingDevice.TextureType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSamples(pMember: RenderingDevice.TextureSamples): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setSamplesPtr, 0)
  }

  public final fun getSamples(): RenderingDevice.TextureSamples {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSamplesPtr, 2)
    return RenderingDevice.TextureSamples.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setUsageBits(pMember: RenderingDevice.TextureUsageBits): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.flag)
    TransferContext.callPtrMethod(MethodBindings.setUsageBitsPtr, 0)
  }

  public final fun getUsageBits(): RenderingDevice.TextureUsageBits {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUsageBitsPtr, 2)
    return RenderingDevice.TextureUsageBits(TransferContext.readReturnValue_LONG())
  }

  public final fun setIsResolveBuffer(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pMember)
    TransferContext.callPtrMethod(MethodBindings.setIsResolveBufferPtr, 0)
  }

  public final fun getIsResolveBuffer(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIsResolveBufferPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setIsDiscardable(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pMember)
    TransferContext.callPtrMethod(MethodBindings.setIsDiscardablePtr, 0)
  }

  public final fun getIsDiscardable(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIsDiscardablePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Adds [format] as a valid format for the corresponding [RDTextureView]'s
   * [RDTextureView.formatOverride] property. If any format is added as shareable, then the main
   * [format] must also be added.
   */
  public final fun addShareableFormat(format: RenderingDevice.DataFormat): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, format.value)
    TransferContext.callPtrMethod(MethodBindings.addShareableFormatPtr, 0)
  }

  /**
   * Removes [format] from the list of valid formats that the corresponding [RDTextureView]'s
   * [RDTextureView.formatOverride] property can be set to.
   */
  public final fun removeShareableFormat(format: RenderingDevice.DataFormat): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, format.value)
    TransferContext.callPtrMethod(MethodBindings.removeShareableFormatPtr, 0)
  }

  public companion object {
    @JvmField
    public val setFormatName: MethodStringName1<RDTextureFormat, Unit, RenderingDevice.DataFormat> =
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.DataFormat>("set_format")

    @JvmField
    public val getFormatName: MethodStringName0<RDTextureFormat, RenderingDevice.DataFormat> =
        MethodStringName0<RDTextureFormat, RenderingDevice.DataFormat>("get_format")

    @JvmField
    public val setWidthName: MethodStringName1<RDTextureFormat, Unit, Long> =
        MethodStringName1<RDTextureFormat, Unit, Long>("set_width")

    @JvmField
    public val getWidthName: MethodStringName0<RDTextureFormat, Long> =
        MethodStringName0<RDTextureFormat, Long>("get_width")

    @JvmField
    public val setHeightName: MethodStringName1<RDTextureFormat, Unit, Long> =
        MethodStringName1<RDTextureFormat, Unit, Long>("set_height")

    @JvmField
    public val getHeightName: MethodStringName0<RDTextureFormat, Long> =
        MethodStringName0<RDTextureFormat, Long>("get_height")

    @JvmField
    public val setDepthName: MethodStringName1<RDTextureFormat, Unit, Long> =
        MethodStringName1<RDTextureFormat, Unit, Long>("set_depth")

    @JvmField
    public val getDepthName: MethodStringName0<RDTextureFormat, Long> =
        MethodStringName0<RDTextureFormat, Long>("get_depth")

    @JvmField
    public val setArrayLayersName: MethodStringName1<RDTextureFormat, Unit, Long> =
        MethodStringName1<RDTextureFormat, Unit, Long>("set_array_layers")

    @JvmField
    public val getArrayLayersName: MethodStringName0<RDTextureFormat, Long> =
        MethodStringName0<RDTextureFormat, Long>("get_array_layers")

    @JvmField
    public val setMipmapsName: MethodStringName1<RDTextureFormat, Unit, Long> =
        MethodStringName1<RDTextureFormat, Unit, Long>("set_mipmaps")

    @JvmField
    public val getMipmapsName: MethodStringName0<RDTextureFormat, Long> =
        MethodStringName0<RDTextureFormat, Long>("get_mipmaps")

    @JvmField
    public val setTextureTypeName:
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.TextureType> =
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.TextureType>("set_texture_type")

    @JvmField
    public val getTextureTypeName: MethodStringName0<RDTextureFormat, RenderingDevice.TextureType> =
        MethodStringName0<RDTextureFormat, RenderingDevice.TextureType>("get_texture_type")

    @JvmField
    public val setSamplesName:
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.TextureSamples> =
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.TextureSamples>("set_samples")

    @JvmField
    public val getSamplesName: MethodStringName0<RDTextureFormat, RenderingDevice.TextureSamples> =
        MethodStringName0<RDTextureFormat, RenderingDevice.TextureSamples>("get_samples")

    @JvmField
    public val setUsageBitsName:
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.TextureUsageBits> =
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.TextureUsageBits>("set_usage_bits")

    @JvmField
    public val getUsageBitsName:
        MethodStringName0<RDTextureFormat, RenderingDevice.TextureUsageBits> =
        MethodStringName0<RDTextureFormat, RenderingDevice.TextureUsageBits>("get_usage_bits")

    @JvmField
    public val setIsResolveBufferName: MethodStringName1<RDTextureFormat, Unit, Boolean> =
        MethodStringName1<RDTextureFormat, Unit, Boolean>("set_is_resolve_buffer")

    @JvmField
    public val getIsResolveBufferName: MethodStringName0<RDTextureFormat, Boolean> =
        MethodStringName0<RDTextureFormat, Boolean>("get_is_resolve_buffer")

    @JvmField
    public val setIsDiscardableName: MethodStringName1<RDTextureFormat, Unit, Boolean> =
        MethodStringName1<RDTextureFormat, Unit, Boolean>("set_is_discardable")

    @JvmField
    public val getIsDiscardableName: MethodStringName0<RDTextureFormat, Boolean> =
        MethodStringName0<RDTextureFormat, Boolean>("get_is_discardable")

    @JvmField
    public val addShareableFormatName:
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.DataFormat> =
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.DataFormat>("add_shareable_format")

    @JvmField
    public val removeShareableFormatName:
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.DataFormat> =
        MethodStringName1<RDTextureFormat, Unit, RenderingDevice.DataFormat>("remove_shareable_format")
  }

  public object MethodBindings {
    internal val setFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_format", 565531219)

    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_format", 2235804183)

    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_width", 1286410249)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_width", 3905245786)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_height", 1286410249)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_height", 3905245786)

    internal val setDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_depth", 1286410249)

    internal val getDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_depth", 3905245786)

    internal val setArrayLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_array_layers", 1286410249)

    internal val getArrayLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_array_layers", 3905245786)

    internal val setMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_mipmaps", 1286410249)

    internal val getMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_mipmaps", 3905245786)

    internal val setTextureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_texture_type", 652343381)

    internal val getTextureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_texture_type", 4036357416)

    internal val setSamplesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_samples", 3774171498)

    internal val getSamplesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_samples", 407791724)

    internal val setUsageBitsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_usage_bits", 245642367)

    internal val getUsageBitsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_usage_bits", 1313398998)

    internal val setIsResolveBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_is_resolve_buffer", 2586408642)

    internal val getIsResolveBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_is_resolve_buffer", 36873697)

    internal val setIsDiscardablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "set_is_discardable", 2586408642)

    internal val getIsDiscardablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "get_is_discardable", 36873697)

    internal val addShareableFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "add_shareable_format", 565531219)

    internal val removeShareableFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureFormat", "remove_shareable_format", 565531219)
  }
}
