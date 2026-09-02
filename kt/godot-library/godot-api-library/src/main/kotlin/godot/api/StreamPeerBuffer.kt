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
import godot.core.PackedByteArray
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A data buffer stream peer that uses a byte array as the stream. This object can be used to handle
 * binary data from network sessions. To handle binary data stored in files, [FileAccess] can be used
 * directly.
 *
 * A [StreamPeerBuffer] object keeps an internal cursor which is the offset in bytes to the start of
 * the buffer. Get and put operations are performed at the cursor position and will move the cursor
 * accordingly.
 */
@GodotBaseType
public open class StreamPeerBuffer : StreamPeer() {
  /**
   * The underlying data buffer. Setting this value resets the cursor.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var dataArray: PackedByteArray
    @JvmName("dataArrayProperty")
    get() = getDataArray()
    @JvmName("dataArrayProperty")
    set(`value`) {
      setDataArray(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(708, scriptPtr)
  }

  /**
   * This is a helper function for [dataArray] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = streampeerbuffer.dataArray
   * //Your changes
   * streampeerbuffer.dataArray = myCoreType
   * ``````
   *
   * The underlying data buffer. Setting this value resets the cursor.
   */
  @CoreTypeHelper
  public final fun dataArrayMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      dataArray.apply {
     block(this)
     dataArray = this
  }

  /**
   * This is a helper function for [dataArray] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The underlying data buffer. Setting this value resets the cursor.
   */
  @CoreTypeHelper
  public final fun dataArrayMutateEach(block: (index: Int, `value`: Byte) -> Unit): PackedByteArray
      = dataArray.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     dataArray = this
  }

  /**
   * Moves the cursor to the specified position. [position] must be a valid index of [dataArray].
   */
  public final fun seek(position: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to position.toLong())
    TransferContext.callMethod(MethodBindings.seekPtr)
  }

  /**
   * Returns the size of [dataArray].
   */
  public final fun getSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the current cursor position.
   */
  public final fun getPosition(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Resizes the [dataArray]. This *doesn't* update the cursor.
   */
  public final fun resize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.resizePtr)
  }

  public final fun setDataArray(`data`: PackedByteArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.setDataArrayPtr)
  }

  public final fun getDataArray(): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDataArrayPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Clears the [dataArray] and resets the cursor.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Returns a new [StreamPeerBuffer] with the same [dataArray] content.
   */
  public final fun duplicate(): StreamPeerBuffer? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.duplicatePtr)
    return (TransferContext.readReturnValue(OBJECT) as StreamPeerBuffer?)
  }

  public companion object {
    @JvmField
    public val seekName: MethodStringName1<StreamPeerBuffer, Unit, Int> =
        MethodStringName1<StreamPeerBuffer, Unit, Int>("seek")

    @JvmField
    public val getSizeName: MethodStringName0<StreamPeerBuffer, Int> =
        MethodStringName0<StreamPeerBuffer, Int>("get_size")

    @JvmField
    public val getPositionName: MethodStringName0<StreamPeerBuffer, Int> =
        MethodStringName0<StreamPeerBuffer, Int>("get_position")

    @JvmField
    public val resizeName: MethodStringName1<StreamPeerBuffer, Unit, Int> =
        MethodStringName1<StreamPeerBuffer, Unit, Int>("resize")

    @JvmField
    public val setDataArrayName: MethodStringName1<StreamPeerBuffer, Unit, PackedByteArray> =
        MethodStringName1<StreamPeerBuffer, Unit, PackedByteArray>("set_data_array")

    @JvmField
    public val getDataArrayName: MethodStringName0<StreamPeerBuffer, PackedByteArray> =
        MethodStringName0<StreamPeerBuffer, PackedByteArray>("get_data_array")

    @JvmField
    public val clearName: MethodStringName0<StreamPeerBuffer, Unit> =
        MethodStringName0<StreamPeerBuffer, Unit>("clear")

    @JvmField
    public val duplicateName: MethodStringName0<StreamPeerBuffer, StreamPeerBuffer?> =
        MethodStringName0<StreamPeerBuffer, StreamPeerBuffer?>("duplicate")
  }

  public object MethodBindings {
    internal val seekPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerBuffer", "seek", 1286410249)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerBuffer", "get_size", 3905245786)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerBuffer", "get_position", 3905245786)

    internal val resizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerBuffer", "resize", 1286410249)

    internal val setDataArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerBuffer", "set_data_array", 2971499966)

    internal val getDataArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerBuffer", "get_data_array", 2362200018)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerBuffer", "clear", 3218959716)

    internal val duplicatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerBuffer", "duplicate", 2474064677)
  }
}
