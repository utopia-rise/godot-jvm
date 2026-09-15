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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDAttachmentFormat : RefCounted() {
  /**
   * The attachment's data format.
   */
  public final inline var format: RenderingDevice.DataFormat
    @JvmName("formatProperty")
    get() = getFormat()
    @JvmName("formatProperty")
    set(`value`) {
      setFormat(value)
    }

  /**
   * The number of samples used when sampling the attachment.
   */
  public final inline var samples: RenderingDevice.TextureSamples
    @JvmName("samplesProperty")
    get() = getSamples()
    @JvmName("samplesProperty")
    set(`value`) {
      setSamples(value)
    }

  /**
   * The attachment's usage flags, which determine what can be done with it.
   */
  public final inline var usageFlags: Long
    @JvmName("usageFlagsProperty")
    get() = getUsageFlags()
    @JvmName("usageFlagsProperty")
    set(`value`) {
      setUsageFlags(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(579, scriptPtr)
  }

  public final fun setFormat(pMember: RenderingDevice.DataFormat): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callMethod(MethodBindings.setFormatPtr)
  }

  public final fun getFormat(): RenderingDevice.DataFormat {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFormatPtr)
    return RenderingDevice.DataFormat.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSamples(pMember: RenderingDevice.TextureSamples): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callMethod(MethodBindings.setSamplesPtr)
  }

  public final fun getSamples(): RenderingDevice.TextureSamples {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSamplesPtr)
    return RenderingDevice.TextureSamples.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setUsageFlags(pMember: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember)
    TransferContext.callMethod(MethodBindings.setUsageFlagsPtr)
  }

  public final fun getUsageFlags(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUsageFlagsPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public companion object {
    @JvmField
    public val setFormatName:
        MethodStringName1<RDAttachmentFormat, Unit, RenderingDevice.DataFormat> =
        MethodStringName1<RDAttachmentFormat, Unit, RenderingDevice.DataFormat>("set_format")

    @JvmField
    public val getFormatName: MethodStringName0<RDAttachmentFormat, RenderingDevice.DataFormat> =
        MethodStringName0<RDAttachmentFormat, RenderingDevice.DataFormat>("get_format")

    @JvmField
    public val setSamplesName:
        MethodStringName1<RDAttachmentFormat, Unit, RenderingDevice.TextureSamples> =
        MethodStringName1<RDAttachmentFormat, Unit, RenderingDevice.TextureSamples>("set_samples")

    @JvmField
    public val getSamplesName: MethodStringName0<RDAttachmentFormat, RenderingDevice.TextureSamples>
        = MethodStringName0<RDAttachmentFormat, RenderingDevice.TextureSamples>("get_samples")

    @JvmField
    public val setUsageFlagsName: MethodStringName1<RDAttachmentFormat, Unit, Long> =
        MethodStringName1<RDAttachmentFormat, Unit, Long>("set_usage_flags")

    @JvmField
    public val getUsageFlagsName: MethodStringName0<RDAttachmentFormat, Long> =
        MethodStringName0<RDAttachmentFormat, Long>("get_usage_flags")
  }

  public object MethodBindings {
    internal val setFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAttachmentFormat", "set_format", 565531219)

    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAttachmentFormat", "get_format", 2235804183)

    internal val setSamplesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAttachmentFormat", "set_samples", 3774171498)

    internal val getSamplesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAttachmentFormat", "get_samples", 407791724)

    internal val setUsageFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAttachmentFormat", "set_usage_flags", 1286410249)

    internal val getUsageFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAttachmentFormat", "get_usage_flags", 3905245786)
  }
}
