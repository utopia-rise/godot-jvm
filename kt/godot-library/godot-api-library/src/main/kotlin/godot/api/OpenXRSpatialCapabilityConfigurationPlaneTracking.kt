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
import godot.readReturnValue_BOOL
import godot.readReturnValue_PACKED_INT_64_ARRAY
import godot.writeMethodArguments0
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Configuration header for plane tracking. Pass this to
 * [OpenXRSpatialEntityExtension.createSpatialContext] to create a spatial context with plane tracking
 * capabilities.
 */
@GodotBaseType
public open class OpenXRSpatialCapabilityConfigurationPlaneTracking :
    OpenXRSpatialCapabilityConfigurationBaseHeader() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(474, scriptPtr)
  }

  /**
   * Returns `true` if we support the mesh 2D component (only valid after the OpenXR session has
   * started). You can query these using the [OpenXRSpatialComponentMesh2DList] data object.
   */
  public final fun supportsMesh2d(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.supportsMesh2dPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if we support the polygon 2D component (only valid after the OpenXR session has
   * started). You can query these using the [OpenXRSpatialComponentPolygon2DList] data object.
   */
  public final fun supportsPolygons(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.supportsPolygonsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if we support the plane semantic label component (only valid after the OpenXR
   * session has started). You can query these using the [OpenXRSpatialComponentPlaneSemanticLabelList]
   * data object.
   */
  public final fun supportsLabels(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.supportsLabelsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the components enabled by this configuration.
   *
   * **Note:** Only valid after this configuration was used to create a spatial context.
   */
  public final fun getEnabledComponents(): PackedInt64Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnabledComponentsPtr)
    return TransferContext.readReturnValue_PACKED_INT_64_ARRAY()
  }

  public companion object {
    @JvmField
    public val supportsMesh2dName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationPlaneTracking, Boolean> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationPlaneTracking, Boolean>("supports_mesh_2d")

    @JvmField
    public val supportsPolygonsName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationPlaneTracking, Boolean> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationPlaneTracking, Boolean>("supports_polygons")

    @JvmField
    public val supportsLabelsName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationPlaneTracking, Boolean> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationPlaneTracking, Boolean>("supports_labels")

    @JvmField
    public val getEnabledComponentsName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationPlaneTracking, PackedInt64Array> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationPlaneTracking, PackedInt64Array>("get_enabled_components")
  }

  public object MethodBindings {
    internal val supportsMesh2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationPlaneTracking", "supports_mesh_2d", 2240911060)

    internal val supportsPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationPlaneTracking", "supports_polygons", 2240911060)

    internal val supportsLabelsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationPlaneTracking", "supports_labels", 2240911060)

    internal val getEnabledComponentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationPlaneTracking", "get_enabled_components", 235988956)
  }
}
