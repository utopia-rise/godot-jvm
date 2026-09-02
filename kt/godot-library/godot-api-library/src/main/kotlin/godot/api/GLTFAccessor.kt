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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedFloat64Array
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_FLOAT_64_ARRAY
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * GLTFAccessor is a data structure representing a glTF `accessor` that would be found in the
 * `"accessors"` array. A buffer is a blob of binary data. A buffer view is a slice of a buffer. An
 * accessor is a typed interpretation of the data in a buffer view.
 *
 * Most custom data stored in glTF does not need accessors, only buffer views (see
 * [GLTFBufferView]). Accessors are for more advanced use cases such as interleaved mesh data encoded
 * for the GPU.
 */
@GodotBaseType
public open class GLTFAccessor : Resource() {
  /**
   * The index of the buffer view this accessor is referencing. If `-1`, this accessor is not
   * referencing any buffer view.
   */
  public final inline var bufferView: Int
    @JvmName("bufferViewProperty")
    get() = getBufferView()
    @JvmName("bufferViewProperty")
    set(`value`) {
      setBufferView(value)
    }

  /**
   * The offset relative to the start of the buffer view in bytes.
   */
  public final inline var byteOffset: Long
    @JvmName("byteOffsetProperty")
    get() = getByteOffset()
    @JvmName("byteOffsetProperty")
    set(`value`) {
      setByteOffset(value)
    }

  /**
   * The glTF component type as an enum. See [GLTFComponentType] for possible values. Within the
   * core glTF specification, a value of 5125 or "UNSIGNED_INT" must not be used for any accessor that
   * is not referenced by mesh.primitive.indices.
   */
  public final inline var componentType: GLTFComponentType
    @JvmName("componentTypeProperty")
    get() = getComponentType()
    @JvmName("componentTypeProperty")
    set(`value`) {
      setComponentType(value)
    }

  /**
   * Specifies whether integer data values are normalized before usage.
   */
  public final inline var normalized: Boolean
    @JvmName("normalizedProperty")
    get() = getNormalized()
    @JvmName("normalizedProperty")
    set(`value`) {
      setNormalized(value)
    }

  /**
   * The number of elements referenced by this accessor.
   */
  public final inline var count: Long
    @JvmName("countProperty")
    get() = getCount()
    @JvmName("countProperty")
    set(`value`) {
      setCount(value)
    }

  /**
   * The glTF accessor type, as an enum.
   */
  public final inline var accessorType: GLTFAccessorType
    @JvmName("accessorTypeProperty")
    get() = getAccessorType()
    @JvmName("accessorTypeProperty")
    set(`value`) {
      setAccessorType(value)
    }

  /**
   * The glTF accessor type, as an [int]. Possible values are `0` for "SCALAR", `1` for "VEC2", `2`
   * for "VEC3", `3` for "VEC4", `4` for "MAT2", `5` for "MAT3", and `6` for "MAT4".
   */
  public final inline var type: Int
    @JvmName("typeProperty")
    get() = getType()
    @JvmName("typeProperty")
    set(`value`) {
      setType(value)
    }

  /**
   * Minimum value of each component in this accessor.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var min: PackedFloat64Array
    @JvmName("minProperty")
    get() = getMin()
    @JvmName("minProperty")
    set(`value`) {
      setMin(value)
    }

  /**
   * Maximum value of each component in this accessor.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var max: PackedFloat64Array
    @JvmName("maxProperty")
    get() = getMax()
    @JvmName("maxProperty")
    set(`value`) {
      setMax(value)
    }

  /**
   * Number of deviating accessor values stored in the sparse array.
   */
  public final inline var sparseCount: Long
    @JvmName("sparseCountProperty")
    get() = getSparseCount()
    @JvmName("sparseCountProperty")
    set(`value`) {
      setSparseCount(value)
    }

  /**
   * The index of the buffer view with sparse indices. The referenced buffer view MUST NOT have its
   * target or byteStride properties defined. The buffer view and the optional byteOffset MUST be
   * aligned to the componentType byte length.
   */
  public final inline var sparseIndicesBufferView: Int
    @JvmName("sparseIndicesBufferViewProperty")
    get() = getSparseIndicesBufferView()
    @JvmName("sparseIndicesBufferViewProperty")
    set(`value`) {
      setSparseIndicesBufferView(value)
    }

  /**
   * The offset relative to the start of the buffer view in bytes.
   */
  public final inline var sparseIndicesByteOffset: Long
    @JvmName("sparseIndicesByteOffsetProperty")
    get() = getSparseIndicesByteOffset()
    @JvmName("sparseIndicesByteOffsetProperty")
    set(`value`) {
      setSparseIndicesByteOffset(value)
    }

  /**
   * The indices component data type as an enum. Possible values are 5121 for "UNSIGNED_BYTE", 5123
   * for "UNSIGNED_SHORT", and 5125 for "UNSIGNED_INT".
   */
  public final inline var sparseIndicesComponentType: GLTFComponentType
    @JvmName("sparseIndicesComponentTypeProperty")
    get() = getSparseIndicesComponentType()
    @JvmName("sparseIndicesComponentTypeProperty")
    set(`value`) {
      setSparseIndicesComponentType(value)
    }

  /**
   * The index of the bufferView with sparse values. The referenced buffer view MUST NOT have its
   * target or byteStride properties defined.
   */
  public final inline var sparseValuesBufferView: Int
    @JvmName("sparseValuesBufferViewProperty")
    get() = getSparseValuesBufferView()
    @JvmName("sparseValuesBufferViewProperty")
    set(`value`) {
      setSparseValuesBufferView(value)
    }

  /**
   * The offset relative to the start of the bufferView in bytes.
   */
  public final inline var sparseValuesByteOffset: Long
    @JvmName("sparseValuesByteOffsetProperty")
    get() = getSparseValuesByteOffset()
    @JvmName("sparseValuesByteOffsetProperty")
    set(`value`) {
      setSparseValuesByteOffset(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(240, scriptPtr)
  }

  /**
   * This is a helper function for [min] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfaccessor.min
   * //Your changes
   * gltfaccessor.min = myCoreType
   * ``````
   *
   * Minimum value of each component in this accessor.
   */
  @CoreTypeHelper
  public final fun minMutate(block: PackedFloat64Array.() -> Unit): PackedFloat64Array = min.apply {
     block(this)
     min = this
  }

  /**
   * This is a helper function for [min] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Minimum value of each component in this accessor.
   */
  @CoreTypeHelper
  public final fun minMutateEach(block: (index: Int, `value`: Double) -> Unit): PackedFloat64Array =
      min.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     min = this
  }

  /**
   * This is a helper function for [max] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfaccessor.max
   * //Your changes
   * gltfaccessor.max = myCoreType
   * ``````
   *
   * Maximum value of each component in this accessor.
   */
  @CoreTypeHelper
  public final fun maxMutate(block: PackedFloat64Array.() -> Unit): PackedFloat64Array = max.apply {
     block(this)
     max = this
  }

  /**
   * This is a helper function for [max] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Maximum value of each component in this accessor.
   */
  @CoreTypeHelper
  public final fun maxMutateEach(block: (index: Int, `value`: Double) -> Unit): PackedFloat64Array =
      max.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     max = this
  }

  /**
   * Serializes this GLTFAccessor instance into a [Dictionary].
   */
  public final fun toDictionary(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toDictionaryPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun getBufferView(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBufferViewPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setBufferView(bufferView: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bufferView.toLong())
    TransferContext.callMethod(MethodBindings.setBufferViewPtr)
  }

  public final fun getByteOffset(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getByteOffsetPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setByteOffset(byteOffset: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to byteOffset)
    TransferContext.callMethod(MethodBindings.setByteOffsetPtr)
  }

  public final fun getComponentType(): GLTFComponentType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getComponentTypePtr)
    return GLTFComponentType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setComponentType(componentType: GLTFComponentType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to componentType.value)
    TransferContext.callMethod(MethodBindings.setComponentTypePtr)
  }

  public final fun getNormalized(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNormalizedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setNormalized(normalized: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to normalized)
    TransferContext.callMethod(MethodBindings.setNormalizedPtr)
  }

  public final fun getCount(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCount(count: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count)
    TransferContext.callMethod(MethodBindings.setCountPtr)
  }

  public final fun getAccessorType(): GLTFAccessorType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessorTypePtr)
    return GLTFAccessorType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAccessorType(accessorType: GLTFAccessorType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to accessorType.value)
    TransferContext.callMethod(MethodBindings.setAccessorTypePtr)
  }

  public final fun getType(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTypePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setType(type: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.toLong())
    TransferContext.callMethod(MethodBindings.setTypePtr)
  }

  public final fun getMin(): PackedFloat64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_64_ARRAY) as PackedFloat64Array)
  }

  public final fun setMin(min: PackedFloat64Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_FLOAT_64_ARRAY to min)
    TransferContext.callMethod(MethodBindings.setMinPtr)
  }

  public final fun getMax(): PackedFloat64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_64_ARRAY) as PackedFloat64Array)
  }

  public final fun setMax(max: PackedFloat64Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_FLOAT_64_ARRAY to max)
    TransferContext.callMethod(MethodBindings.setMaxPtr)
  }

  public final fun getSparseCount(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSparseCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSparseCount(sparseCount: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sparseCount)
    TransferContext.callMethod(MethodBindings.setSparseCountPtr)
  }

  public final fun getSparseIndicesBufferView(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSparseIndicesBufferViewPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSparseIndicesBufferView(sparseIndicesBufferView: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sparseIndicesBufferView.toLong())
    TransferContext.callMethod(MethodBindings.setSparseIndicesBufferViewPtr)
  }

  public final fun getSparseIndicesByteOffset(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSparseIndicesByteOffsetPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSparseIndicesByteOffset(sparseIndicesByteOffset: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sparseIndicesByteOffset)
    TransferContext.callMethod(MethodBindings.setSparseIndicesByteOffsetPtr)
  }

  public final fun getSparseIndicesComponentType(): GLTFComponentType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSparseIndicesComponentTypePtr)
    return GLTFComponentType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSparseIndicesComponentType(sparseIndicesComponentType: GLTFComponentType):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sparseIndicesComponentType.value)
    TransferContext.callMethod(MethodBindings.setSparseIndicesComponentTypePtr)
  }

  public final fun getSparseValuesBufferView(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSparseValuesBufferViewPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSparseValuesBufferView(sparseValuesBufferView: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sparseValuesBufferView.toLong())
    TransferContext.callMethod(MethodBindings.setSparseValuesBufferViewPtr)
  }

  public final fun getSparseValuesByteOffset(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSparseValuesByteOffsetPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSparseValuesByteOffset(sparseValuesByteOffset: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sparseValuesByteOffset)
    TransferContext.callMethod(MethodBindings.setSparseValuesByteOffsetPtr)
  }

  public enum class GLTFAccessorType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Accessor type "SCALAR". For the glTF object model, this can be used to map to a single float,
     * int, or bool value, or a float array.
     */
    TYPE_SCALAR(0),
    /**
     * Accessor type "VEC2". For the glTF object model, this maps to "float2", represented in the
     * glTF JSON as an array of two floats.
     */
    TYPE_VEC2(1),
    /**
     * Accessor type "VEC3". For the glTF object model, this maps to "float3", represented in the
     * glTF JSON as an array of three floats.
     */
    TYPE_VEC3(2),
    /**
     * Accessor type "VEC4". For the glTF object model, this maps to "float4", represented in the
     * glTF JSON as an array of four floats.
     */
    TYPE_VEC4(3),
    /**
     * Accessor type "MAT2". For the glTF object model, this maps to "float2x2", represented in the
     * glTF JSON as an array of four floats.
     */
    TYPE_MAT2(4),
    /**
     * Accessor type "MAT3". For the glTF object model, this maps to "float3x3", represented in the
     * glTF JSON as an array of nine floats.
     */
    TYPE_MAT3(5),
    /**
     * Accessor type "MAT4". For the glTF object model, this maps to "float4x4", represented in the
     * glTF JSON as an array of sixteen floats.
     */
    TYPE_MAT4(6),
    ;

    public companion object {
      public fun from(`value`: Long): GLTFAccessorType = entries.single { it.`value` == `value` }
    }
  }

  public enum class GLTFComponentType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Component type "NONE". This is not a valid component type, and is used to indicate that the
     * component type is not set.
     */
    COMPONENT_TYPE_NONE(0),
    /**
     * Component type "BYTE". The value is `0x1400` which comes from OpenGL. This indicates data is
     * stored in 1-byte or 8-bit signed integers. This is a core part of the glTF specification.
     */
    COMPONENT_TYPE_SIGNED_BYTE(5120),
    /**
     * Component type "UNSIGNED_BYTE". The value is `0x1401` which comes from OpenGL. This indicates
     * data is stored in 1-byte or 8-bit unsigned integers. This is a core part of the glTF
     * specification.
     */
    COMPONENT_TYPE_UNSIGNED_BYTE(5121),
    /**
     * Component type "SHORT". The value is `0x1402` which comes from OpenGL. This indicates data is
     * stored in 2-byte or 16-bit signed integers. This is a core part of the glTF specification.
     */
    COMPONENT_TYPE_SIGNED_SHORT(5122),
    /**
     * Component type "UNSIGNED_SHORT". The value is `0x1403` which comes from OpenGL. This
     * indicates data is stored in 2-byte or 16-bit unsigned integers. This is a core part of the glTF
     * specification.
     */
    COMPONENT_TYPE_UNSIGNED_SHORT(5123),
    /**
     * Component type "INT". The value is `0x1404` which comes from OpenGL. This indicates data is
     * stored in 4-byte or 32-bit signed integers. This is NOT a core part of the glTF specification,
     * and may not be supported by all glTF importers. May be used by some extensions including
     * `KHR_interactivity`.
     */
    COMPONENT_TYPE_SIGNED_INT(5124),
    /**
     * Component type "UNSIGNED_INT". The value is `0x1405` which comes from OpenGL. This indicates
     * data is stored in 4-byte or 32-bit unsigned integers. This is a core part of the glTF
     * specification.
     */
    COMPONENT_TYPE_UNSIGNED_INT(5125),
    /**
     * Component type "FLOAT". The value is `0x1406` which comes from OpenGL. This indicates data is
     * stored in 4-byte or 32-bit floating-point numbers. This is a core part of the glTF
     * specification.
     */
    COMPONENT_TYPE_SINGLE_FLOAT(5126),
    /**
     * Component type "DOUBLE". The value is `0x140A` which comes from OpenGL. This indicates data
     * is stored in 8-byte or 64-bit floating-point numbers. This is NOT a core part of the glTF
     * specification, and may not be supported by all glTF importers. May be used by some extensions
     * including `KHR_interactivity`.
     */
    COMPONENT_TYPE_DOUBLE_FLOAT(5130),
    /**
     * Component type "HALF_FLOAT". The value is `0x140B` which comes from OpenGL. This indicates
     * data is stored in 2-byte or 16-bit floating-point numbers. This is NOT a core part of the glTF
     * specification, and may not be supported by all glTF importers. May be used by some extensions
     * including `KHR_interactivity`.
     */
    COMPONENT_TYPE_HALF_FLOAT(5131),
    /**
     * Component type "LONG". The value is `0x140E` which comes from OpenGL. This indicates data is
     * stored in 8-byte or 64-bit signed integers. This is NOT a core part of the glTF specification,
     * and may not be supported by all glTF importers. May be used by some extensions including
     * `KHR_interactivity`.
     */
    COMPONENT_TYPE_SIGNED_LONG(5134),
    /**
     * Component type "UNSIGNED_LONG". The value is `0x140F` which comes from OpenGL. This indicates
     * data is stored in 8-byte or 64-bit unsigned integers. This is NOT a core part of the glTF
     * specification, and may not be supported by all glTF importers. May be used by some extensions
     * including `KHR_interactivity`.
     */
    COMPONENT_TYPE_UNSIGNED_LONG(5135),
    ;

    public companion object {
      public fun from(`value`: Long): GLTFComponentType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val fromDictionaryName:
        MethodStringName1<GLTFAccessor, GLTFAccessor?, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFAccessor, GLTFAccessor?, Dictionary<Any?, Any?>>("from_dictionary")

    @JvmField
    public val toDictionaryName: MethodStringName0<GLTFAccessor, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFAccessor, Dictionary<Any?, Any?>>("to_dictionary")

    @JvmField
    public val getBufferViewName: MethodStringName0<GLTFAccessor, Int> =
        MethodStringName0<GLTFAccessor, Int>("get_buffer_view")

    @JvmField
    public val setBufferViewName: MethodStringName1<GLTFAccessor, Unit, Int> =
        MethodStringName1<GLTFAccessor, Unit, Int>("set_buffer_view")

    @JvmField
    public val getByteOffsetName: MethodStringName0<GLTFAccessor, Long> =
        MethodStringName0<GLTFAccessor, Long>("get_byte_offset")

    @JvmField
    public val setByteOffsetName: MethodStringName1<GLTFAccessor, Unit, Long> =
        MethodStringName1<GLTFAccessor, Unit, Long>("set_byte_offset")

    @JvmField
    public val getComponentTypeName: MethodStringName0<GLTFAccessor, GLTFComponentType> =
        MethodStringName0<GLTFAccessor, GLTFComponentType>("get_component_type")

    @JvmField
    public val setComponentTypeName: MethodStringName1<GLTFAccessor, Unit, GLTFComponentType> =
        MethodStringName1<GLTFAccessor, Unit, GLTFComponentType>("set_component_type")

    @JvmField
    public val getNormalizedName: MethodStringName0<GLTFAccessor, Boolean> =
        MethodStringName0<GLTFAccessor, Boolean>("get_normalized")

    @JvmField
    public val setNormalizedName: MethodStringName1<GLTFAccessor, Unit, Boolean> =
        MethodStringName1<GLTFAccessor, Unit, Boolean>("set_normalized")

    @JvmField
    public val getCountName: MethodStringName0<GLTFAccessor, Long> =
        MethodStringName0<GLTFAccessor, Long>("get_count")

    @JvmField
    public val setCountName: MethodStringName1<GLTFAccessor, Unit, Long> =
        MethodStringName1<GLTFAccessor, Unit, Long>("set_count")

    @JvmField
    public val getAccessorTypeName: MethodStringName0<GLTFAccessor, GLTFAccessorType> =
        MethodStringName0<GLTFAccessor, GLTFAccessorType>("get_accessor_type")

    @JvmField
    public val setAccessorTypeName: MethodStringName1<GLTFAccessor, Unit, GLTFAccessorType> =
        MethodStringName1<GLTFAccessor, Unit, GLTFAccessorType>("set_accessor_type")

    @JvmField
    public val getTypeName: MethodStringName0<GLTFAccessor, Int> =
        MethodStringName0<GLTFAccessor, Int>("get_type")

    @JvmField
    public val setTypeName: MethodStringName1<GLTFAccessor, Unit, Int> =
        MethodStringName1<GLTFAccessor, Unit, Int>("set_type")

    @JvmField
    public val getMinName: MethodStringName0<GLTFAccessor, PackedFloat64Array> =
        MethodStringName0<GLTFAccessor, PackedFloat64Array>("get_min")

    @JvmField
    public val setMinName: MethodStringName1<GLTFAccessor, Unit, PackedFloat64Array> =
        MethodStringName1<GLTFAccessor, Unit, PackedFloat64Array>("set_min")

    @JvmField
    public val getMaxName: MethodStringName0<GLTFAccessor, PackedFloat64Array> =
        MethodStringName0<GLTFAccessor, PackedFloat64Array>("get_max")

    @JvmField
    public val setMaxName: MethodStringName1<GLTFAccessor, Unit, PackedFloat64Array> =
        MethodStringName1<GLTFAccessor, Unit, PackedFloat64Array>("set_max")

    @JvmField
    public val getSparseCountName: MethodStringName0<GLTFAccessor, Long> =
        MethodStringName0<GLTFAccessor, Long>("get_sparse_count")

    @JvmField
    public val setSparseCountName: MethodStringName1<GLTFAccessor, Unit, Long> =
        MethodStringName1<GLTFAccessor, Unit, Long>("set_sparse_count")

    @JvmField
    public val getSparseIndicesBufferViewName: MethodStringName0<GLTFAccessor, Int> =
        MethodStringName0<GLTFAccessor, Int>("get_sparse_indices_buffer_view")

    @JvmField
    public val setSparseIndicesBufferViewName: MethodStringName1<GLTFAccessor, Unit, Int> =
        MethodStringName1<GLTFAccessor, Unit, Int>("set_sparse_indices_buffer_view")

    @JvmField
    public val getSparseIndicesByteOffsetName: MethodStringName0<GLTFAccessor, Long> =
        MethodStringName0<GLTFAccessor, Long>("get_sparse_indices_byte_offset")

    @JvmField
    public val setSparseIndicesByteOffsetName: MethodStringName1<GLTFAccessor, Unit, Long> =
        MethodStringName1<GLTFAccessor, Unit, Long>("set_sparse_indices_byte_offset")

    @JvmField
    public val getSparseIndicesComponentTypeName: MethodStringName0<GLTFAccessor, GLTFComponentType>
        = MethodStringName0<GLTFAccessor, GLTFComponentType>("get_sparse_indices_component_type")

    @JvmField
    public val setSparseIndicesComponentTypeName:
        MethodStringName1<GLTFAccessor, Unit, GLTFComponentType> =
        MethodStringName1<GLTFAccessor, Unit, GLTFComponentType>("set_sparse_indices_component_type")

    @JvmField
    public val getSparseValuesBufferViewName: MethodStringName0<GLTFAccessor, Int> =
        MethodStringName0<GLTFAccessor, Int>("get_sparse_values_buffer_view")

    @JvmField
    public val setSparseValuesBufferViewName: MethodStringName1<GLTFAccessor, Unit, Int> =
        MethodStringName1<GLTFAccessor, Unit, Int>("set_sparse_values_buffer_view")

    @JvmField
    public val getSparseValuesByteOffsetName: MethodStringName0<GLTFAccessor, Long> =
        MethodStringName0<GLTFAccessor, Long>("get_sparse_values_byte_offset")

    @JvmField
    public val setSparseValuesByteOffsetName: MethodStringName1<GLTFAccessor, Unit, Long> =
        MethodStringName1<GLTFAccessor, Unit, Long>("set_sparse_values_byte_offset")

    /**
     * Creates a new GLTFAccessor instance by parsing the given [Dictionary].
     */
    @JvmStatic
    public final fun fromDictionary(dictionary: Dictionary<Any?, Any?>): GLTFAccessor? {
      TransferContext.writeMethodArguments(0L, 0L, DICTIONARY to dictionary)
      TransferContext.callMethod(MethodBindings.fromDictionaryPtr)
      return (TransferContext.readReturnValue(OBJECT) as GLTFAccessor?)
    }
  }

  public object MethodBindings {
    internal val fromDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "from_dictionary", 3495091019)

    internal val toDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "to_dictionary", 3102165223)

    internal val getBufferViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_buffer_view", 3905245786)

    internal val setBufferViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_buffer_view", 1286410249)

    internal val getByteOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_byte_offset", 3905245786)

    internal val setByteOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_byte_offset", 1286410249)

    internal val getComponentTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_component_type", 852227802)

    internal val setComponentTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_component_type", 1780020221)

    internal val getNormalizedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_normalized", 36873697)

    internal val setNormalizedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_normalized", 2586408642)

    internal val getCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_count", 3905245786)

    internal val setCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_count", 1286410249)

    internal val getAccessorTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_accessor_type", 1998183368)

    internal val setAccessorTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_accessor_type", 2347728198)

    internal val getTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_type", 3905245786)

    internal val setTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_type", 1286410249)

    internal val getMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_min", 547233126)

    internal val setMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_min", 2576592201)

    internal val getMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_max", 547233126)

    internal val setMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_max", 2576592201)

    internal val getSparseCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_sparse_count", 3905245786)

    internal val setSparseCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_sparse_count", 1286410249)

    internal val getSparseIndicesBufferViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_sparse_indices_buffer_view", 3905245786)

    internal val setSparseIndicesBufferViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_sparse_indices_buffer_view", 1286410249)

    internal val getSparseIndicesByteOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_sparse_indices_byte_offset", 3905245786)

    internal val setSparseIndicesByteOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_sparse_indices_byte_offset", 1286410249)

    internal val getSparseIndicesComponentTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_sparse_indices_component_type", 852227802)

    internal val setSparseIndicesComponentTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_sparse_indices_component_type", 1780020221)

    internal val getSparseValuesBufferViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_sparse_values_buffer_view", 3905245786)

    internal val setSparseValuesBufferViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_sparse_values_buffer_view", 1286410249)

    internal val getSparseValuesByteOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "get_sparse_values_byte_offset", 3905245786)

    internal val setSparseValuesByteOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAccessor", "set_sparse_values_byte_offset", 1286410249)
  }
}
