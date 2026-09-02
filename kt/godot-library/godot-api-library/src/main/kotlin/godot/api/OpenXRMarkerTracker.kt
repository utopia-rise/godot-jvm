// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Any
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Spatial entity tracker for our OpenXR spatial entity marker tracking extension. These trackers
 * identify entities in our real space detected by a visual marker such as a QRCode or Aruco code, and
 * map their location to our virtual space.
 */
@GodotBaseType
public open class OpenXRMarkerTracker : OpenXRSpatialEntityTracker() {
  /**
   * The bounds size for this marker.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var boundsSize: Vector2
    @JvmName("boundsSizeProperty")
    get() = getBoundsSize()
    @JvmName("boundsSizeProperty")
    set(`value`) {
      setBoundsSize(value)
    }

  /**
   * The type of marker.
   */
  public final inline var markerType: OpenXRSpatialComponentMarkerList.MarkerType
    @JvmName("markerTypeProperty")
    get() = getMarkerType()
    @JvmName("markerTypeProperty")
    set(`value`) {
      setMarkerType(value)
    }

  /**
   * The marker ID for this marker, this is only returned for Aruco and April Tag markers. Call
   * [getMarkerData] for QRCode markers.
   */
  public final inline var markerId: Long
    @JvmName("markerIdProperty")
    get() = getMarkerId()
    @JvmName("markerIdProperty")
    set(`value`) {
      setMarkerId(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(464, scriptPtr)
  }

  /**
   * This is a helper function for [boundsSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = openxrmarkertracker.boundsSize
   * //Your changes
   * openxrmarkertracker.boundsSize = myCoreType
   * ``````
   *
   * The bounds size for this marker.
   */
  @CoreTypeHelper
  public final fun boundsSizeMutate(block: Vector2.() -> Unit): Vector2 = boundsSize.apply {
     block(this)
     boundsSize = this
  }

  public final fun setBoundsSize(boundsSize: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to boundsSize)
    TransferContext.callMethod(MethodBindings.setBoundsSizePtr)
  }

  public final fun getBoundsSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoundsSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setMarkerType(markerType: OpenXRSpatialComponentMarkerList.MarkerType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to markerType.value)
    TransferContext.callMethod(MethodBindings.setMarkerTypePtr)
  }

  public final fun getMarkerType(): OpenXRSpatialComponentMarkerList.MarkerType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarkerTypePtr)
    return OpenXRSpatialComponentMarkerList.MarkerType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMarkerId(markerId: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to markerId)
    TransferContext.callMethod(MethodBindings.setMarkerIdPtr)
  }

  public final fun getMarkerId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarkerIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the marker data for this marker.
   *
   * **Note:** This should only be set by marker discovery logic.
   */
  public final fun setMarkerData(markerData: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to markerData)
    TransferContext.callMethod(MethodBindings.setMarkerDataPtr)
  }

  /**
   * Returns the marker data for this marker. This can return a [String] or [PackedByteArray]. Only
   * applicable to QR Code based markers.
   */
  public final fun getMarkerData(): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMarkerDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public companion object {
    @JvmField
    public val setBoundsSizeName: MethodStringName1<OpenXRMarkerTracker, Unit, Vector2> =
        MethodStringName1<OpenXRMarkerTracker, Unit, Vector2>("set_bounds_size")

    @JvmField
    public val getBoundsSizeName: MethodStringName0<OpenXRMarkerTracker, Vector2> =
        MethodStringName0<OpenXRMarkerTracker, Vector2>("get_bounds_size")

    @JvmField
    public val setMarkerTypeName:
        MethodStringName1<OpenXRMarkerTracker, Unit, OpenXRSpatialComponentMarkerList.MarkerType> =
        MethodStringName1<OpenXRMarkerTracker, Unit, OpenXRSpatialComponentMarkerList.MarkerType>("set_marker_type")

    @JvmField
    public val getMarkerTypeName:
        MethodStringName0<OpenXRMarkerTracker, OpenXRSpatialComponentMarkerList.MarkerType> =
        MethodStringName0<OpenXRMarkerTracker, OpenXRSpatialComponentMarkerList.MarkerType>("get_marker_type")

    @JvmField
    public val setMarkerIdName: MethodStringName1<OpenXRMarkerTracker, Unit, Long> =
        MethodStringName1<OpenXRMarkerTracker, Unit, Long>("set_marker_id")

    @JvmField
    public val getMarkerIdName: MethodStringName0<OpenXRMarkerTracker, Long> =
        MethodStringName0<OpenXRMarkerTracker, Long>("get_marker_id")

    @JvmField
    public val setMarkerDataName: MethodStringName1<OpenXRMarkerTracker, Unit, Any?> =
        MethodStringName1<OpenXRMarkerTracker, Unit, Any?>("set_marker_data")

    @JvmField
    public val getMarkerDataName: MethodStringName0<OpenXRMarkerTracker, Any?> =
        MethodStringName0<OpenXRMarkerTracker, Any?>("get_marker_data")
  }

  public object MethodBindings {
    internal val setBoundsSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRMarkerTracker", "set_bounds_size", 743155724)

    internal val getBoundsSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRMarkerTracker", "get_bounds_size", 3341600327)

    internal val setMarkerTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRMarkerTracker", "set_marker_type", 2156241362)

    internal val getMarkerTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRMarkerTracker", "get_marker_type", 612702862)

    internal val setMarkerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRMarkerTracker", "set_marker_id", 1286410249)

    internal val getMarkerIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRMarkerTracker", "get_marker_id", 3905245786)

    internal val setMarkerDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRMarkerTracker", "set_marker_data", 1114965689)

    internal val getMarkerDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRMarkerTracker", "get_marker_data", 1214101251)
  }
}
