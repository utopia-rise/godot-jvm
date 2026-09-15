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
import godot.core.PackedInt64Array
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Configuration header for April tag markers. Pass this to
 * [OpenXRSpatialEntityExtension.createSpatialContext] to create a spatial context that can detect
 * April tags.
 */
@GodotBaseType
public open class OpenXRSpatialCapabilityConfigurationAprilTag :
    OpenXRSpatialCapabilityConfigurationBaseHeader() {
  /**
   * Dictionary to use to decode April tags.
   *
   * **Note:** Must be set before using this configuration to create a spatial context.
   */
  public final inline var aprilDict: AprilTagDict
    @JvmName("aprilDictProperty")
    get() = getAprilDict()
    @JvmName("aprilDictProperty")
    set(`value`) {
      setAprilDict(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(470, scriptPtr)
  }

  /**
   * Returns the components enabled by this configuration.
   *
   * **Note:** Only valid after this configuration was used to create a spatial context.
   */
  public final fun getEnabledComponents(): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnabledComponentsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  public final fun setAprilDict(aprilDict: AprilTagDict): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to aprilDict.value)
    TransferContext.callMethod(MethodBindings.setAprilDictPtr)
  }

  public final fun getAprilDict(): AprilTagDict {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAprilDictPtr)
    return AprilTagDict.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public enum class AprilTagDict(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 4 by 4 bits, minimum Hamming distance between any two codes = 5, 30 codes.
     */
    APRIL_TAG_DICT_16H5(1),
    /**
     * 5 by 5 bits, minimum Hamming distance between any two codes = 9, 35 codes.
     */
    APRIL_TAG_DICT_25H9(2),
    /**
     *  6 by 6 bits, minimum Hamming distance between any two codes = 10, 2320 codes.
     */
    APRIL_TAG_DICT_36H10(3),
    /**
     * 6 by 6 bits, minimum Hamming distance between any two codes = 11, 587 codes.
     */
    APRIL_TAG_DICT_36H11(4),
    ;

    public companion object {
      public fun from(`value`: Long): AprilTagDict = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getEnabledComponentsName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationAprilTag, PackedInt64Array> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationAprilTag, PackedInt64Array>("get_enabled_components")

    @JvmField
    public val setAprilDictName:
        MethodStringName1<OpenXRSpatialCapabilityConfigurationAprilTag, Unit, AprilTagDict> =
        MethodStringName1<OpenXRSpatialCapabilityConfigurationAprilTag, Unit, AprilTagDict>("set_april_dict")

    @JvmField
    public val getAprilDictName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationAprilTag, AprilTagDict> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationAprilTag, AprilTagDict>("get_april_dict")
  }

  public object MethodBindings {
    internal val getEnabledComponentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationAprilTag", "get_enabled_components", 235988956)

    internal val setAprilDictPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationAprilTag", "set_april_dict", 3902905799)

    internal val getAprilDictPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationAprilTag", "get_april_dict", 440273016)
  }
}
