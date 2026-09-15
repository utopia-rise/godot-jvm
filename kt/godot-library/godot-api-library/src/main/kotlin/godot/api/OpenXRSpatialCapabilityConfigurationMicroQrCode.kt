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
import godot.core.PackedInt64Array
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Configuration header for QR code markers. Pass this to
 * [OpenXRSpatialEntityExtension.createSpatialContext] to create a spatial context that can detect QR
 * code markers.
 */
@GodotBaseType
public open class OpenXRSpatialCapabilityConfigurationMicroQrCode :
    OpenXRSpatialCapabilityConfigurationBaseHeader() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(473, scriptPtr)
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

  public companion object {
    @JvmField
    public val getEnabledComponentsName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationMicroQrCode, PackedInt64Array> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationMicroQrCode, PackedInt64Array>("get_enabled_components")
  }

  public object MethodBindings {
    internal val getEnabledComponentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationMicroQrCode", "get_enabled_components", 235988956)
  }
}
