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
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.LONG
import kotlin.Any
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A *specialization constant* is a way to create additional variants of shaders without actually
 * increasing the number of shader versions that are compiled. This allows improving performance by
 * reducing the number of shader versions and reducing `if` branching, while still allowing shaders to
 * be flexible for different use cases.
 *
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDPipelineSpecializationConstant : RefCounted() {
  /**
   * The specialization constant's value. Only [Boolean], [Long] and [Double] types are valid for
   * specialization constants.
   */
  public final inline var `value`: Any?
    @JvmName("valueProperty")
    get() = getValue()
    @JvmName("valueProperty")
    set(`value`) {
      setValue(value)
    }

  /**
   * The identifier of the specialization constant. This is a value starting from `0` and that
   * increments for every different specialization constant for a given shader.
   */
  public final inline var constantId: Long
    @JvmName("constantIdProperty")
    get() = getConstantId()
    @JvmName("constantIdProperty")
    set(`value`) {
      setConstantId(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(589, scriptPtr)
  }

  public final fun setValue(`value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to value)
    TransferContext.callMethod(MethodBindings.setValuePtr)
  }

  public final fun getValue(): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public final fun setConstantId(constantId: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to constantId)
    TransferContext.callMethod(MethodBindings.setConstantIdPtr)
  }

  public final fun getConstantId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public companion object {
    @JvmField
    public val setValueName: MethodStringName1<RDPipelineSpecializationConstant, Unit, Any?> =
        MethodStringName1<RDPipelineSpecializationConstant, Unit, Any?>("set_value")

    @JvmField
    public val getValueName: MethodStringName0<RDPipelineSpecializationConstant, Any?> =
        MethodStringName0<RDPipelineSpecializationConstant, Any?>("get_value")

    @JvmField
    public val setConstantIdName: MethodStringName1<RDPipelineSpecializationConstant, Unit, Long> =
        MethodStringName1<RDPipelineSpecializationConstant, Unit, Long>("set_constant_id")

    @JvmField
    public val getConstantIdName: MethodStringName0<RDPipelineSpecializationConstant, Long> =
        MethodStringName0<RDPipelineSpecializationConstant, Long>("get_constant_id")
  }

  public object MethodBindings {
    internal val setValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineSpecializationConstant", "set_value", 1114965689)

    internal val getValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineSpecializationConstant", "get_value", 1214101251)

    internal val setConstantIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineSpecializationConstant", "set_constant_id", 1286410249)

    internal val getConstantIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineSpecializationConstant", "get_constant_id", 3905245786)
  }
}
