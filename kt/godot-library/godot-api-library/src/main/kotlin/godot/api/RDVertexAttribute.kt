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
import godot.core.VariantParser.LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDVertexAttribute : RefCounted() {
  /**
   * The index of the buffer in the vertex buffer array to bind this vertex attribute. When set to
   * `-1`, it defaults to the index of the attribute.
   *
   * **Note:** You cannot mix binding explicitly assigned attributes with implicitly assigned ones
   * (i.e. `-1`). Either all attributes must have their binding set to `-1`, or all must have explicit
   * bindings.
   */
  public final inline var binding: Long
    @JvmName("bindingProperty")
    get() = getBinding()
    @JvmName("bindingProperty")
    set(`value`) {
      setBinding(value)
    }

  /**
   * The location in the shader that this attribute is bound to.
   */
  public final inline var location: Long
    @JvmName("locationProperty")
    get() = getLocation()
    @JvmName("locationProperty")
    set(`value`) {
      setLocation(value)
    }

  /**
   * The number of bytes between the start of the vertex buffer and the first instance of this
   * attribute.
   */
  public final inline var offset: Long
    @JvmName("offsetProperty")
    get() = getOffset()
    @JvmName("offsetProperty")
    set(`value`) {
      setOffset(value)
    }

  /**
   * The way that this attribute's data is interpreted when sent to a shader.
   */
  public final inline var format: RenderingDevice.DataFormat
    @JvmName("formatProperty")
    get() = getFormat()
    @JvmName("formatProperty")
    set(`value`) {
      setFormat(value)
    }

  /**
   * The number of bytes between the starts of consecutive instances of this attribute.
   */
  public final inline var stride: Long
    @JvmName("strideProperty")
    get() = getStride()
    @JvmName("strideProperty")
    set(`value`) {
      setStride(value)
    }

  /**
   * The rate at which this attribute is pulled from its vertex buffer.
   */
  public final inline var frequency: RenderingDevice.VertexFrequency
    @JvmName("frequencyProperty")
    get() = getFrequency()
    @JvmName("frequencyProperty")
    set(`value`) {
      setFrequency(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(596, scriptPtr)
  }

  public final fun setBinding(pMember: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember)
    TransferContext.callMethod(MethodBindings.setBindingPtr)
  }

  public final fun getBinding(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBindingPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLocation(pMember: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember)
    TransferContext.callMethod(MethodBindings.setLocationPtr)
  }

  public final fun getLocation(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocationPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setOffset(pMember: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember)
    TransferContext.callMethod(MethodBindings.setOffsetPtr)
  }

  public final fun getOffset(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFormat(pMember: RenderingDevice.DataFormat): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setFormatPtr)
  }

  public final fun getFormat(): RenderingDevice.DataFormat {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFormatPtr)
    return RenderingDevice.DataFormat.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setStride(pMember: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember)
    TransferContext.callMethod(MethodBindings.setStridePtr)
  }

  public final fun getStride(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStridePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFrequency(pMember: RenderingDevice.VertexFrequency): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setFrequencyPtr)
  }

  public final fun getFrequency(): RenderingDevice.VertexFrequency {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrequencyPtr)
    return RenderingDevice.VertexFrequency.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public companion object {
    @JvmField
    public val setBindingName: MethodStringName1<RDVertexAttribute, Unit, Long> =
        MethodStringName1<RDVertexAttribute, Unit, Long>("set_binding")

    @JvmField
    public val getBindingName: MethodStringName0<RDVertexAttribute, Long> =
        MethodStringName0<RDVertexAttribute, Long>("get_binding")

    @JvmField
    public val setLocationName: MethodStringName1<RDVertexAttribute, Unit, Long> =
        MethodStringName1<RDVertexAttribute, Unit, Long>("set_location")

    @JvmField
    public val getLocationName: MethodStringName0<RDVertexAttribute, Long> =
        MethodStringName0<RDVertexAttribute, Long>("get_location")

    @JvmField
    public val setOffsetName: MethodStringName1<RDVertexAttribute, Unit, Long> =
        MethodStringName1<RDVertexAttribute, Unit, Long>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<RDVertexAttribute, Long> =
        MethodStringName0<RDVertexAttribute, Long>("get_offset")

    @JvmField
    public val setFormatName: MethodStringName1<RDVertexAttribute, Unit, RenderingDevice.DataFormat>
        = MethodStringName1<RDVertexAttribute, Unit, RenderingDevice.DataFormat>("set_format")

    @JvmField
    public val getFormatName: MethodStringName0<RDVertexAttribute, RenderingDevice.DataFormat> =
        MethodStringName0<RDVertexAttribute, RenderingDevice.DataFormat>("get_format")

    @JvmField
    public val setStrideName: MethodStringName1<RDVertexAttribute, Unit, Long> =
        MethodStringName1<RDVertexAttribute, Unit, Long>("set_stride")

    @JvmField
    public val getStrideName: MethodStringName0<RDVertexAttribute, Long> =
        MethodStringName0<RDVertexAttribute, Long>("get_stride")

    @JvmField
    public val setFrequencyName:
        MethodStringName1<RDVertexAttribute, Unit, RenderingDevice.VertexFrequency> =
        MethodStringName1<RDVertexAttribute, Unit, RenderingDevice.VertexFrequency>("set_frequency")

    @JvmField
    public val getFrequencyName:
        MethodStringName0<RDVertexAttribute, RenderingDevice.VertexFrequency> =
        MethodStringName0<RDVertexAttribute, RenderingDevice.VertexFrequency>("get_frequency")
  }

  public object MethodBindings {
    internal val setBindingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "set_binding", 1286410249)

    internal val getBindingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "get_binding", 3905245786)

    internal val setLocationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "set_location", 1286410249)

    internal val getLocationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "get_location", 3905245786)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "set_offset", 1286410249)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "get_offset", 3905245786)

    internal val setFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "set_format", 565531219)

    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "get_format", 2235804183)

    internal val setStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "set_stride", 1286410249)

    internal val getStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "get_stride", 3905245786)

    internal val setFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "set_frequency", 522141836)

    internal val getFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDVertexAttribute", "get_frequency", 4154106413)
  }
}
