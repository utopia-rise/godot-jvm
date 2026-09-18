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
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_INT_64_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Configuration header for Aruco markers. Pass this to
 * [OpenXRSpatialEntityExtension.createSpatialContext] to create a spatial context that can detect
 * Aruco markers.
 */
@GodotBaseType
public open class OpenXRSpatialCapabilityConfigurationAruco :
    OpenXRSpatialCapabilityConfigurationBaseHeader() {
  /**
   * Dictionary to use to decode Aruco markers.
   *
   * **Note:** Must be set before using this configuration to create a spatial context.
   */
  public final inline var arucoDict: ArucoDict
    @JvmName("arucoDictProperty")
    get() = getArucoDict()
    @JvmName("arucoDictProperty")
    set(`value`) {
      setArucoDict(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(471, scriptPtr)
  }

  /**
   * Returns the components enabled by this configuration.
   *
   * **Note:** Only valid after this configuration was used to create a spatial context.
   */
  public final fun getEnabledComponents(): PackedInt64Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEnabledComponentsPtr, 31)
    return TransferContext.readReturnValue_PACKED_INT_64_ARRAY()
  }

  public final fun setArucoDict(arucoDict: ArucoDict): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, arucoDict.value)
    TransferContext.callPtrMethod(MethodBindings.setArucoDictPtr, 0)
  }

  public final fun getArucoDict(): ArucoDict {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getArucoDictPtr, 2)
    return ArucoDict.from(TransferContext.readReturnValue_LONG())
  }

  public enum class ArucoDict(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 4 by 4 pixel Aruco marker dictionary with 50 IDs.
     */
    ARUCO_DICT_4X4_50(1),
    /**
     * 4 by 4 pixel Aruco marker dictionary with 100 IDs.
     */
    ARUCO_DICT_4X4_100(2),
    /**
     * 4 by 4 pixel Aruco marker dictionary with 250 IDs.
     */
    ARUCO_DICT_4X4_250(3),
    /**
     * 4 by 4 pixel Aruco marker dictionary with 1000 IDs.
     */
    ARUCO_DICT_4X4_1000(4),
    /**
     * 5 by 5 pixel Aruco marker dictionary with 50 IDs.
     */
    ARUCO_DICT_5X5_50(5),
    /**
     * 5 by 5 pixel Aruco marker dictionary with 100 IDs.
     */
    ARUCO_DICT_5X5_100(6),
    /**
     * 5 by 5 pixel Aruco marker dictionary with 250 IDs.
     */
    ARUCO_DICT_5X5_250(7),
    /**
     * 5 by 5 pixel Aruco marker dictionary with 1000 IDs.
     */
    ARUCO_DICT_5X5_1000(8),
    /**
     * 6 by 6 pixel Aruco marker dictionary with 50 IDs.
     */
    ARUCO_DICT_6X6_50(9),
    /**
     * 6 by 6 pixel Aruco marker dictionary with 100 IDs.
     */
    ARUCO_DICT_6X6_100(10),
    /**
     * 6 by 6 pixel Aruco marker dictionary with 250 IDs.
     */
    ARUCO_DICT_6X6_250(11),
    /**
     * 6 by 6 pixel Aruco marker dictionary with 1000 IDs.
     */
    ARUCO_DICT_6X6_1000(12),
    /**
     * 7 by 7 pixel Aruco marker dictionary with 50 IDs.
     */
    ARUCO_DICT_7X7_50(13),
    /**
     * 7 by 7 pixel Aruco marker dictionary with 100 IDs.
     */
    ARUCO_DICT_7X7_100(14),
    /**
     * 7 by 7 pixel Aruco marker dictionary with 250 IDs.
     */
    ARUCO_DICT_7X7_250(15),
    /**
     * 7 by 7 pixel Aruco marker dictionary with 1000 IDs.
     */
    ARUCO_DICT_7X7_1000(16),
    ;

    public companion object {
      public fun from(`value`: Long): ArucoDict = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getEnabledComponentsName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationAruco, PackedInt64Array> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationAruco, PackedInt64Array>("get_enabled_components")

    @JvmField
    public val setArucoDictName:
        MethodStringName1<OpenXRSpatialCapabilityConfigurationAruco, Unit, ArucoDict> =
        MethodStringName1<OpenXRSpatialCapabilityConfigurationAruco, Unit, ArucoDict>("set_aruco_dict")

    @JvmField
    public val getArucoDictName:
        MethodStringName0<OpenXRSpatialCapabilityConfigurationAruco, ArucoDict> =
        MethodStringName0<OpenXRSpatialCapabilityConfigurationAruco, ArucoDict>("get_aruco_dict")
  }

  public object MethodBindings {
    internal val getEnabledComponentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationAruco", "get_enabled_components", 235988956)

    internal val setArucoDictPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationAruco", "set_aruco_dict", 2268055963)

    internal val getArucoDictPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialCapabilityConfigurationAruco", "get_aruco_dict", 1080386209)
  }
}
