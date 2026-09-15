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
import godot.core.MethodStringName1
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Object for storing OpenXR structure data that is passed when calling into OpenXR APIs.
 */
@GodotBaseType
public open class OpenXRStructureBase : RefCounted() {
  /**
   * Setting another structure object here chains these structures together to extend the API
   * functionality. Consult the OpenXR documentation for which structures can be used with a given API
   * call.
   */
  public final inline var next: OpenXRStructureBase?
    @JvmName("nextProperty")
    get() = getNext()
    @JvmName("nextProperty")
    set(`value`) {
      setNext(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(494, scriptPtr)
  }

  public open fun _getHeader(next: Long): Long {
    throw NotImplementedError("OpenXRStructureBase::_getHeader is not implemented.")
  }

  /**
   * Returns the structure type (OpenXR `XrStructureType`) used for this structure.
   */
  public final fun getStructureType(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStructureTypePtr)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setNext(entity: OpenXRStructureBase?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, entity)
    TransferContext.callMethod(MethodBindings.setNextPtr)
  }

  public final fun getNext(): OpenXRStructureBase? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNextPtr)
    return (TransferContext.readReturnValue_OBJECT() as OpenXRStructureBase?)
  }

  public companion object {
    @JvmField
    public val getStructureTypeName: MethodStringName0<OpenXRStructureBase, Long> =
        MethodStringName0<OpenXRStructureBase, Long>("get_structure_type")

    @JvmField
    public val setNextName: MethodStringName1<OpenXRStructureBase, Unit, OpenXRStructureBase?> =
        MethodStringName1<OpenXRStructureBase, Unit, OpenXRStructureBase?>("set_next")

    @JvmField
    public val getNextName: MethodStringName0<OpenXRStructureBase, OpenXRStructureBase?> =
        MethodStringName0<OpenXRStructureBase, OpenXRStructureBase?>("get_next")
  }

  public object MethodBindings {
    internal val getStructureTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRStructureBase", "get_structure_type", 2455072627)

    internal val setNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRStructureBase", "set_next", 334698771)

    internal val getNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRStructureBase", "get_next", 2798796760)
  }
}
