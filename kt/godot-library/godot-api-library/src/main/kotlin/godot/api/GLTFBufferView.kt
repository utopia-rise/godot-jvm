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
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedByteArray
import godot.readReturnValue_BOOL
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_BYTE_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DICTIONARY
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * GLTFBufferView is a data structure representing a glTF `bufferView` that would be found in the
 * `"bufferViews"` array. A buffer is a blob of binary data. A buffer view is a slice of a buffer that
 * can be used to identify and extract data from the buffer.
 *
 * Most custom uses of buffers only need to use the [buffer], [byteLength], and [byteOffset]. The
 * [byteStride] and [indices] properties are for more advanced use cases such as interleaved mesh data
 * encoded for the GPU.
 */
@GodotBaseType
public open class GLTFBufferView : Resource() {
  /**
   * The index of the buffer this buffer view is referencing. If `-1`, this buffer view is not
   * referencing any buffer.
   */
  public final inline var buffer: Int
    @JvmName("bufferProperty")
    get() = getBuffer()
    @JvmName("bufferProperty")
    set(`value`) {
      setBuffer(value)
    }

  /**
   * The offset, in bytes, from the start of the buffer to the start of this buffer view.
   */
  public final inline var byteOffset: Long
    @JvmName("byteOffsetProperty")
    get() = getByteOffset()
    @JvmName("byteOffsetProperty")
    set(`value`) {
      setByteOffset(value)
    }

  /**
   * The length, in bytes, of this buffer view. If `0`, this buffer view is empty.
   */
  public final inline var byteLength: Long
    @JvmName("byteLengthProperty")
    get() = getByteLength()
    @JvmName("byteLengthProperty")
    set(`value`) {
      setByteLength(value)
    }

  /**
   * The stride, in bytes, between interleaved data. If `-1`, this buffer view is not interleaved.
   */
  public final inline var byteStride: Long
    @JvmName("byteStrideProperty")
    get() = getByteStride()
    @JvmName("byteStrideProperty")
    set(`value`) {
      setByteStride(value)
    }

  /**
   * `true` if the GLTFBufferView's OpenGL GPU buffer type is an `ELEMENT_ARRAY_BUFFER` used for
   * vertex indices (integer constant `34963`). `false` if the buffer type is any other value. See
   * [url=https://github.com/KhronosGroup/glTF-Tutorials/blob/master/gltfTutorial/gltfTutorial_005_BuffersBufferViewsAccessors.md]Buffers,
   * BufferViews, and Accessors[/url] for possible values. This property is set on import and used on
   * export.
   */
  public final inline var indices: Boolean
    @JvmName("indicesProperty")
    get() = getIndices()
    @JvmName("indicesProperty")
    set(`value`) {
      setIndices(value)
    }

  /**
   * `true` if the GLTFBufferView's OpenGL GPU buffer type is an `ARRAY_BUFFER` used for vertex
   * attributes (integer constant `34962`). `false` if the buffer type is any other value. See
   * [url=https://github.com/KhronosGroup/glTF-Tutorials/blob/master/gltfTutorial/gltfTutorial_005_BuffersBufferViewsAccessors.md]Buffers,
   * BufferViews, and Accessors[/url] for possible values. This property is set on import and used on
   * export.
   */
  public final inline var vertexAttributes: Boolean
    @JvmName("vertexAttributesProperty")
    get() = getVertexAttributes()
    @JvmName("vertexAttributesProperty")
    set(`value`) {
      setVertexAttributes(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(240, scriptPtr)
  }

  /**
   * Loads the buffer view data from the buffer referenced by this buffer view in the given
   * [GLTFState]. Interleaved data with a byte stride is not yet supported by this method. The data is
   * returned as a [PackedByteArray].
   */
  public final fun loadBufferViewData(state: GLTFState?): PackedByteArray {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, state)
    TransferContext.callMethod(MethodBindings.loadBufferViewDataPtr)
    return TransferContext.readReturnValue_PACKED_BYTE_ARRAY()
  }

  /**
   * Serializes this GLTFBufferView instance into a [Dictionary].
   */
  public final fun toDictionary(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toDictionaryPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  public final fun getBuffer(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBufferPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setBuffer(buffer: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, buffer.toLong())
    TransferContext.callPtrMethod(MethodBindings.setBufferPtr, 0)
  }

  public final fun getByteOffset(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getByteOffsetPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setByteOffset(byteOffset: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, byteOffset)
    TransferContext.callPtrMethod(MethodBindings.setByteOffsetPtr, 0)
  }

  public final fun getByteLength(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getByteLengthPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setByteLength(byteLength: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, byteLength)
    TransferContext.callPtrMethod(MethodBindings.setByteLengthPtr, 0)
  }

  public final fun getByteStride(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getByteStridePtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setByteStride(byteStride: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, byteStride)
    TransferContext.callPtrMethod(MethodBindings.setByteStridePtr, 0)
  }

  public final fun getIndices(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIndicesPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setIndices(indices: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, indices)
    TransferContext.callPtrMethod(MethodBindings.setIndicesPtr, 0)
  }

  public final fun getVertexAttributes(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVertexAttributesPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setVertexAttributes(isAttributes: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, isAttributes)
    TransferContext.callPtrMethod(MethodBindings.setVertexAttributesPtr, 0)
  }

  public companion object {
    @JvmField
    public val loadBufferViewDataName:
        MethodStringName1<GLTFBufferView, PackedByteArray, GLTFState?> =
        MethodStringName1<GLTFBufferView, PackedByteArray, GLTFState?>("load_buffer_view_data")

    @JvmField
    public val fromDictionaryName:
        MethodStringName1<GLTFBufferView, GLTFBufferView?, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFBufferView, GLTFBufferView?, Dictionary<Any?, Any?>>("from_dictionary")

    @JvmField
    public val toDictionaryName: MethodStringName0<GLTFBufferView, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFBufferView, Dictionary<Any?, Any?>>("to_dictionary")

    @JvmField
    public val getBufferName: MethodStringName0<GLTFBufferView, Int> =
        MethodStringName0<GLTFBufferView, Int>("get_buffer")

    @JvmField
    public val setBufferName: MethodStringName1<GLTFBufferView, Unit, Int> =
        MethodStringName1<GLTFBufferView, Unit, Int>("set_buffer")

    @JvmField
    public val getByteOffsetName: MethodStringName0<GLTFBufferView, Long> =
        MethodStringName0<GLTFBufferView, Long>("get_byte_offset")

    @JvmField
    public val setByteOffsetName: MethodStringName1<GLTFBufferView, Unit, Long> =
        MethodStringName1<GLTFBufferView, Unit, Long>("set_byte_offset")

    @JvmField
    public val getByteLengthName: MethodStringName0<GLTFBufferView, Long> =
        MethodStringName0<GLTFBufferView, Long>("get_byte_length")

    @JvmField
    public val setByteLengthName: MethodStringName1<GLTFBufferView, Unit, Long> =
        MethodStringName1<GLTFBufferView, Unit, Long>("set_byte_length")

    @JvmField
    public val getByteStrideName: MethodStringName0<GLTFBufferView, Long> =
        MethodStringName0<GLTFBufferView, Long>("get_byte_stride")

    @JvmField
    public val setByteStrideName: MethodStringName1<GLTFBufferView, Unit, Long> =
        MethodStringName1<GLTFBufferView, Unit, Long>("set_byte_stride")

    @JvmField
    public val getIndicesName: MethodStringName0<GLTFBufferView, Boolean> =
        MethodStringName0<GLTFBufferView, Boolean>("get_indices")

    @JvmField
    public val setIndicesName: MethodStringName1<GLTFBufferView, Unit, Boolean> =
        MethodStringName1<GLTFBufferView, Unit, Boolean>("set_indices")

    @JvmField
    public val getVertexAttributesName: MethodStringName0<GLTFBufferView, Boolean> =
        MethodStringName0<GLTFBufferView, Boolean>("get_vertex_attributes")

    @JvmField
    public val setVertexAttributesName: MethodStringName1<GLTFBufferView, Unit, Boolean> =
        MethodStringName1<GLTFBufferView, Unit, Boolean>("set_vertex_attributes")

    /**
     * Creates a new GLTFBufferView instance by parsing the given [Dictionary].
     */
    @JvmStatic
    public final fun fromDictionary(dictionary: Dictionary<Any?, Any?>): GLTFBufferView? {
      TransferContext.writeMethodArguments_DICTIONARY(0L, 0L, dictionary)
      TransferContext.callPtrMethod(MethodBindings.fromDictionaryPtr, 39)
      return (TransferContext.readReturnValue_OBJECT() as GLTFBufferView?)
    }
  }

  public object MethodBindings {
    internal val loadBufferViewDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "load_buffer_view_data", 3945446907)

    internal val fromDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "from_dictionary", 2594413512)

    internal val toDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "to_dictionary", 3102165223)

    internal val getBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "get_buffer", 3905245786)

    internal val setBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "set_buffer", 1286410249)

    internal val getByteOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "get_byte_offset", 3905245786)

    internal val setByteOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "set_byte_offset", 1286410249)

    internal val getByteLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "get_byte_length", 3905245786)

    internal val setByteLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "set_byte_length", 1286410249)

    internal val getByteStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "get_byte_stride", 3905245786)

    internal val setByteStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "set_byte_stride", 1286410249)

    internal val getIndicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "get_indices", 36873697)

    internal val setIndicesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "set_indices", 2586408642)

    internal val getVertexAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "get_vertex_attributes", 36873697)

    internal val setVertexAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFBufferView", "set_vertex_attributes", 2586408642)
  }
}
