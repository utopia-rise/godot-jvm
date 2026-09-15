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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedByteArray
import godot.core.RID
import godot.readReturnValue_ANY
import godot.readReturnValue_LONG
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_RID_LONG
import kotlin.Any
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing the queries marker result data when calling
 * [OpenXRSpatialEntityExtension.querySnapshot].
 */
@GodotBaseType
public open class OpenXRSpatialComponentMarkerList : OpenXRSpatialComponentData() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(480, scriptPtr)
  }

  /**
   * Returns the marker type for the marker at this [index].
   */
  public final fun getMarkerType(index: Long): MarkerType {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.getMarkerTypePtr)
    return MarkerType.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the marker ID for the marker at this [index]. Only applicable for Aruco or April Tag
   * markers.
   */
  public final fun getMarkerId(index: Long): Long {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.getMarkerIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns either a [String] or a [PackedByteArray] buffer with data for the marker at this
   * [index]. Only applicable for QR code markers.
   */
  public final fun getMarkerData(snapshot: RID, index: Long): Any? {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, snapshot, index)
    TransferContext.callMethod(MethodBindings.getMarkerDataPtr)
    return TransferContext.readReturnValue_ANY()
  }

  public enum class MarkerType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Unknown or unset marker type.
     */
    UNKNOWN(0),
    /**
     * Marker based on a QR code.
     */
    QRCODE(1),
    /**
     * Marker based on a micro QR code.
     */
    MICRO_QRCODE(2),
    /**
     * Marker based on an Aruco code.
     */
    ARUCO(3),
    /**
     * Marker based on an April Tag.
     */
    APRIL_TAG(4),
    /**
     * Maximum value for this enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): MarkerType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getMarkerTypeName:
        MethodStringName1<OpenXRSpatialComponentMarkerList, MarkerType, Long> =
        MethodStringName1<OpenXRSpatialComponentMarkerList, MarkerType, Long>("get_marker_type")

    @JvmField
    public val getMarkerIdName: MethodStringName1<OpenXRSpatialComponentMarkerList, Long, Long> =
        MethodStringName1<OpenXRSpatialComponentMarkerList, Long, Long>("get_marker_id")

    @JvmField
    public val getMarkerDataName:
        MethodStringName2<OpenXRSpatialComponentMarkerList, Any?, RID, Long> =
        MethodStringName2<OpenXRSpatialComponentMarkerList, Any?, RID, Long>("get_marker_data")
  }

  public object MethodBindings {
    internal val getMarkerTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentMarkerList", "get_marker_type", 2627847866)

    internal val getMarkerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentMarkerList", "get_marker_id", 923996154)

    internal val getMarkerDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentMarkerList", "get_marker_data", 4069510997)
  }
}
