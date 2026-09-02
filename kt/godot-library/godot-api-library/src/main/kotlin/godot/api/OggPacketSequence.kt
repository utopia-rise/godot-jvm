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
import godot.core.PackedInt64Array
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import kotlin.Any
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A sequence of Ogg packets.
 */
@GodotBaseType
public open class OggPacketSequence : Resource() {
  /**
   * Contains the raw packets that make up this OggPacketSequence.
   */
  public final inline var packetData: VariantArray<VariantArray<Any?>>
    @JvmName("packetDataProperty")
    get() = getPacketData()
    @JvmName("packetDataProperty")
    set(`value`) {
      setPacketData(value)
    }

  /**
   * Contains the granule positions for each page in this packet sequence.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var granulePositions: PackedInt64Array
    @JvmName("granulePositionsProperty")
    get() = getPacketGranulePositions()
    @JvmName("granulePositionsProperty")
    set(`value`) {
      setPacketGranulePositions(value)
    }

  /**
   * Holds sample rate information about this sequence. Must be set by another class that actually
   * understands the codec.
   */
  public final inline var samplingRate: Float
    @JvmName("samplingRateProperty")
    get() = getSamplingRate()
    @JvmName("samplingRateProperty")
    set(`value`) {
      setSamplingRate(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(434, scriptPtr)
  }

  /**
   * This is a helper function for [granulePositions] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = oggpacketsequence.granulePositions
   * //Your changes
   * oggpacketsequence.granulePositions = myCoreType
   * ``````
   *
   * Contains the granule positions for each page in this packet sequence.
   */
  @CoreTypeHelper
  public final fun granulePositionsMutate(block: PackedInt64Array.() -> Unit): PackedInt64Array =
      granulePositions.apply {
     block(this)
     granulePositions = this
  }

  /**
   * This is a helper function for [granulePositions] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Contains the granule positions for each page in this packet sequence.
   */
  @CoreTypeHelper
  public final fun granulePositionsMutateEach(block: (index: Int, `value`: Long) -> Unit):
      PackedInt64Array = granulePositions.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     granulePositions = this
  }

  public final fun setPacketData(packetData: VariantArray<VariantArray<Any?>>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to packetData)
    TransferContext.callMethod(MethodBindings.setPacketDataPtr)
  }

  public final fun getPacketData(): VariantArray<VariantArray<Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPacketDataPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<VariantArray<Any?>>)
  }

  public final fun setPacketGranulePositions(granulePositions: PackedInt64Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_64_ARRAY to granulePositions)
    TransferContext.callMethod(MethodBindings.setPacketGranulePositionsPtr)
  }

  public final fun getPacketGranulePositions(): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPacketGranulePositionsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  public final fun setSamplingRate(samplingRate: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to samplingRate.toDouble())
    TransferContext.callMethod(MethodBindings.setSamplingRatePtr)
  }

  public final fun getSamplingRate(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSamplingRatePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * The length of this stream, in seconds.
   */
  public final fun getLength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public companion object {
    @JvmField
    public val setPacketDataName:
        MethodStringName1<OggPacketSequence, Unit, VariantArray<VariantArray<Any?>>> =
        MethodStringName1<OggPacketSequence, Unit, VariantArray<VariantArray<Any?>>>("set_packet_data")

    @JvmField
    public val getPacketDataName:
        MethodStringName0<OggPacketSequence, VariantArray<VariantArray<Any?>>> =
        MethodStringName0<OggPacketSequence, VariantArray<VariantArray<Any?>>>("get_packet_data")

    @JvmField
    public val setPacketGranulePositionsName:
        MethodStringName1<OggPacketSequence, Unit, PackedInt64Array> =
        MethodStringName1<OggPacketSequence, Unit, PackedInt64Array>("set_packet_granule_positions")

    @JvmField
    public val getPacketGranulePositionsName: MethodStringName0<OggPacketSequence, PackedInt64Array>
        = MethodStringName0<OggPacketSequence, PackedInt64Array>("get_packet_granule_positions")

    @JvmField
    public val setSamplingRateName: MethodStringName1<OggPacketSequence, Unit, Float> =
        MethodStringName1<OggPacketSequence, Unit, Float>("set_sampling_rate")

    @JvmField
    public val getSamplingRateName: MethodStringName0<OggPacketSequence, Float> =
        MethodStringName0<OggPacketSequence, Float>("get_sampling_rate")

    @JvmField
    public val getLengthName: MethodStringName0<OggPacketSequence, Float> =
        MethodStringName0<OggPacketSequence, Float>("get_length")
  }

  public object MethodBindings {
    internal val setPacketDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OggPacketSequence", "set_packet_data", 381264803)

    internal val getPacketDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OggPacketSequence", "get_packet_data", 3995934104)

    internal val setPacketGranulePositionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OggPacketSequence", "set_packet_granule_positions", 3709968205)

    internal val getPacketGranulePositionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OggPacketSequence", "get_packet_granule_positions", 235988956)

    internal val setSamplingRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OggPacketSequence", "set_sampling_rate", 373806689)

    internal val getSamplingRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OggPacketSequence", "get_sampling_rate", 1740695150)

    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OggPacketSequence", "get_length", 1740695150)
  }
}
