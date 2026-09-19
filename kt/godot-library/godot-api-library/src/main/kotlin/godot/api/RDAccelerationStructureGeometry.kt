// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_RID
import godot.callPtrMethod_LONG
import godot.callPtrMethod_RID
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [RDAccelerationStructureGeometry] describes a set of triangles used as raytracing geometry in the
 * [RenderingDevice.blasCreate] method.
 *
 * The geometry is always in triangle list form, either indexed or non-indexed. Triangle strips are
 * not supported.
 */
@GodotBaseType
public open class RDAccelerationStructureGeometry : RefCounted() {
  /**
   * Flags for the geometry.
   */
  public final inline var flags: RenderingDevice.AccelerationStructureGeometryFlagBits
    @JvmName("flagsProperty")
    get() = getFlags()
    @JvmName("flagsProperty")
    set(`value`) {
      setFlags(value)
    }

  /**
   * Buffer containing vertices.
   */
  public final inline var vertexBuffer: RID
    @JvmName("vertexBufferProperty")
    get() = getVertexBuffer()
    @JvmName("vertexBufferProperty")
    set(`value`) {
      setVertexBuffer(value)
    }

  /**
   * Byte offset of the first vertex in [vertexBuffer].
   */
  public final inline var vertexOffset: Long
    @JvmName("vertexOffsetProperty")
    get() = getVertexOffset()
    @JvmName("vertexOffsetProperty")
    set(`value`) {
      setVertexOffset(value)
    }

  /**
   * Number of bytes between each vertex in [vertexBuffer].
   */
  public final inline var vertexStride: Long
    @JvmName("vertexStrideProperty")
    get() = getVertexStride()
    @JvmName("vertexStrideProperty")
    set(`value`) {
      setVertexStride(value)
    }

  /**
   * Number of vertices used by this geometry in [vertexBuffer].
   */
  public final inline var vertexCount: Long
    @JvmName("vertexCountProperty")
    get() = getVertexCount()
    @JvmName("vertexCountProperty")
    set(`value`) {
      setVertexCount(value)
    }

  /**
   * Format of the vertices in [vertexBuffer].
   */
  public final inline var vertexFormat: RenderingDevice.DataFormat
    @JvmName("vertexFormatProperty")
    get() = getVertexFormat()
    @JvmName("vertexFormatProperty")
    set(`value`) {
      setVertexFormat(value)
    }

  /**
   * Buffer containing vertex indices. If `null`, triangles are non-indexed.
   */
  public final inline var indexBuffer: RID
    @JvmName("indexBufferProperty")
    get() = getIndexBuffer()
    @JvmName("indexBufferProperty")
    set(`value`) {
      setIndexBuffer(value)
    }

  /**
   * Byte offset of the first index in [indexBuffer].
   */
  public final inline var indexOffset: Long
    @JvmName("indexOffsetProperty")
    get() = getIndexOffset()
    @JvmName("indexOffsetProperty")
    set(`value`) {
      setIndexOffset(value)
    }

  /**
   * Number of indices used by this geometry in [indexBuffer].
   */
  public final inline var indexCount: Long
    @JvmName("indexCountProperty")
    get() = getIndexCount()
    @JvmName("indexCountProperty")
    set(`value`) {
      setIndexCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(577, scriptPtr)
  }

  public final fun setFlags(pMember: RenderingDevice.AccelerationStructureGeometryFlagBits): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFlagsPtr, pMember.flag)
  }

  public final fun getFlags(): RenderingDevice.AccelerationStructureGeometryFlagBits =
      RenderingDevice.AccelerationStructureGeometryFlagBits(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFlagsPtr))

  public final fun setVertexBuffer(pMember: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.setVertexBufferPtr, pMember)
  }

  public final fun getVertexBuffer(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getVertexBufferPtr)

  public final fun setVertexOffset(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVertexOffsetPtr, pMember)
  }

  public final fun getVertexOffset(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVertexOffsetPtr)

  public final fun setVertexStride(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVertexStridePtr, pMember)
  }

  public final fun getVertexStride(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVertexStridePtr)

  public final fun setVertexCount(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVertexCountPtr, pMember)
  }

  public final fun getVertexCount(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVertexCountPtr)

  public final fun setVertexFormat(pMember: RenderingDevice.DataFormat): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVertexFormatPtr, pMember.value)
  }

  public final fun getVertexFormat(): RenderingDevice.DataFormat =
      RenderingDevice.DataFormat.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVertexFormatPtr))

  public final fun setIndexBuffer(pMember: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.setIndexBufferPtr, pMember)
  }

  public final fun getIndexBuffer(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getIndexBufferPtr)

  public final fun setIndexOffset(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setIndexOffsetPtr, pMember)
  }

  public final fun getIndexOffset(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getIndexOffsetPtr)

  public final fun setIndexCount(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setIndexCountPtr, pMember)
  }

  public final fun getIndexCount(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getIndexCountPtr)

  public companion object {
    @JvmField
    public val setFlagsName:
        MethodStringName1<RDAccelerationStructureGeometry, Unit, RenderingDevice.AccelerationStructureGeometryFlagBits>
        =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, RenderingDevice.AccelerationStructureGeometryFlagBits>("set_flags")

    @JvmField
    public val getFlagsName:
        MethodStringName0<RDAccelerationStructureGeometry, RenderingDevice.AccelerationStructureGeometryFlagBits>
        =
        MethodStringName0<RDAccelerationStructureGeometry, RenderingDevice.AccelerationStructureGeometryFlagBits>("get_flags")

    @JvmField
    public val setVertexBufferName: MethodStringName1<RDAccelerationStructureGeometry, Unit, RID> =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, RID>("set_vertex_buffer")

    @JvmField
    public val getVertexBufferName: MethodStringName0<RDAccelerationStructureGeometry, RID> =
        MethodStringName0<RDAccelerationStructureGeometry, RID>("get_vertex_buffer")

    @JvmField
    public val setVertexOffsetName: MethodStringName1<RDAccelerationStructureGeometry, Unit, Long> =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, Long>("set_vertex_offset")

    @JvmField
    public val getVertexOffsetName: MethodStringName0<RDAccelerationStructureGeometry, Long> =
        MethodStringName0<RDAccelerationStructureGeometry, Long>("get_vertex_offset")

    @JvmField
    public val setVertexStrideName: MethodStringName1<RDAccelerationStructureGeometry, Unit, Long> =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, Long>("set_vertex_stride")

    @JvmField
    public val getVertexStrideName: MethodStringName0<RDAccelerationStructureGeometry, Long> =
        MethodStringName0<RDAccelerationStructureGeometry, Long>("get_vertex_stride")

    @JvmField
    public val setVertexCountName: MethodStringName1<RDAccelerationStructureGeometry, Unit, Long> =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, Long>("set_vertex_count")

    @JvmField
    public val getVertexCountName: MethodStringName0<RDAccelerationStructureGeometry, Long> =
        MethodStringName0<RDAccelerationStructureGeometry, Long>("get_vertex_count")

    @JvmField
    public val setVertexFormatName:
        MethodStringName1<RDAccelerationStructureGeometry, Unit, RenderingDevice.DataFormat> =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, RenderingDevice.DataFormat>("set_vertex_format")

    @JvmField
    public val getVertexFormatName:
        MethodStringName0<RDAccelerationStructureGeometry, RenderingDevice.DataFormat> =
        MethodStringName0<RDAccelerationStructureGeometry, RenderingDevice.DataFormat>("get_vertex_format")

    @JvmField
    public val setIndexBufferName: MethodStringName1<RDAccelerationStructureGeometry, Unit, RID> =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, RID>("set_index_buffer")

    @JvmField
    public val getIndexBufferName: MethodStringName0<RDAccelerationStructureGeometry, RID> =
        MethodStringName0<RDAccelerationStructureGeometry, RID>("get_index_buffer")

    @JvmField
    public val setIndexOffsetName: MethodStringName1<RDAccelerationStructureGeometry, Unit, Long> =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, Long>("set_index_offset")

    @JvmField
    public val getIndexOffsetName: MethodStringName0<RDAccelerationStructureGeometry, Long> =
        MethodStringName0<RDAccelerationStructureGeometry, Long>("get_index_offset")

    @JvmField
    public val setIndexCountName: MethodStringName1<RDAccelerationStructureGeometry, Unit, Long> =
        MethodStringName1<RDAccelerationStructureGeometry, Unit, Long>("set_index_count")

    @JvmField
    public val getIndexCountName: MethodStringName0<RDAccelerationStructureGeometry, Long> =
        MethodStringName0<RDAccelerationStructureGeometry, Long>("get_index_count")
  }

  public object MethodBindings {
    internal val setFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_flags", 1046628555)

    internal val getFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_flags", 1694887119)

    internal val setVertexBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_vertex_buffer", 2722037293)

    internal val getVertexBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_vertex_buffer", 2944877500)

    internal val setVertexOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_vertex_offset", 1286410249)

    internal val getVertexOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_vertex_offset", 3905245786)

    internal val setVertexStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_vertex_stride", 1286410249)

    internal val getVertexStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_vertex_stride", 3905245786)

    internal val setVertexCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_vertex_count", 1286410249)

    internal val getVertexCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_vertex_count", 3905245786)

    internal val setVertexFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_vertex_format", 565531219)

    internal val getVertexFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_vertex_format", 2235804183)

    internal val setIndexBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_index_buffer", 2722037293)

    internal val getIndexBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_index_buffer", 2944877500)

    internal val setIndexOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_index_offset", 1286410249)

    internal val getIndexOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_index_offset", 3905245786)

    internal val setIndexCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "set_index_count", 1286410249)

    internal val getIndexCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureGeometry", "get_index_count", 3905245786)
  }
}
