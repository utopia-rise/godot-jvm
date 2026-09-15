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
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import kotlin.Boolean
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Wrapper base class for OpenXR Spatial Capability Configuration headers. This class needs to be
 * implemented for each capability configuration structure usable within OpenXR's spatial entities
 * system.
 */
@GodotBaseType
public open class OpenXRSpatialCapabilityConfigurationBaseHeader : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(472, scriptPtr)
  }

  /**
   * Return `true` if this object contains a valid configuration that can be retrieved when calling
   * [_getConfiguration].
   */
  public open fun _hasValidConfiguration(): Boolean {
    throw NotImplementedError("OpenXRSpatialCapabilityConfigurationBaseHeader::_hasValidConfiguration is not implemented.")
  }

  /**
   * Return a pointer (encoded as an `int64_t`) to a struct holding the spatial capability
   * configuration data. The memory for this struct should remain accessible as long as this object
   * remains instantiated.
   */
  public open fun _getConfiguration(): Long {
    throw NotImplementedError("OpenXRSpatialCapabilityConfigurationBaseHeader::_getConfiguration is not implemented.")
  }

  /**
   * Returns `true` if this object contains a valid configuration that can be used when calling
   * [OpenXRSpatialEntityExtension.createSpatialContext].
   */
  public final fun hasValidConfiguration(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasValidConfigurationPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Gets a pointer to the `XrSpatialCapabilityConfigurationBaseHeaderEXT` struct.
   *
   * **Note:** This method is intended to be used from GDExtensions.
   */
  public final fun getConfiguration(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConfigurationPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public companion object {
    @JvmField
    public val hasValidConfigurationName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationBaseHeader, Boolean> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationBaseHeader, Boolean>("has_valid_configuration")

    @JvmField
    public val getConfigurationName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationBaseHeader, Long> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationBaseHeader, Long>("get_configuration")
  }

  public object MethodBindings {
    internal val hasValidConfigurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationBaseHeader", "has_valid_configuration", 36873697)

    internal val getConfigurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationBaseHeader", "get_configuration", 2455072627)
  }
}
