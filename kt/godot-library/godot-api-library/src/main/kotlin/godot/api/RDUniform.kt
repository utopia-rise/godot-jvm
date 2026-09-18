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
import godot.core.RID
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_RID
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDUniform : RefCounted() {
  /**
   * The uniform's data type.
   */
  public final inline var uniformType: RenderingDevice.UniformType
    @JvmName("uniformTypeProperty")
    get() = getUniformType()
    @JvmName("uniformTypeProperty")
    set(`value`) {
      setUniformType(value)
    }

  /**
   * The uniform's binding.
   */
  public final inline var binding: Int
    @JvmName("bindingProperty")
    get() = getBinding()
    @JvmName("bindingProperty")
    set(`value`) {
      setBinding(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(595, scriptPtr)
  }

  public final fun setUniformType(pMember: RenderingDevice.UniformType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setUniformTypePtr, 0)
  }

  public final fun getUniformType(): RenderingDevice.UniformType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUniformTypePtr, 2)
    return RenderingDevice.UniformType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setBinding(pMember: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.toLong())
    TransferContext.callPtrMethod(MethodBindings.setBindingPtr, 0)
  }

  public final fun getBinding(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBindingPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Binds the given id to the uniform. The data associated with the id is then used when the
   * uniform is passed to a shader.
   */
  public final fun addId(id: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, id)
    TransferContext.callPtrMethod(MethodBindings.addIdPtr, 0)
  }

  /**
   * Unbinds all ids currently bound to the uniform.
   */
  public final fun clearIds(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearIdsPtr, 0)
  }

  /**
   * Returns an array of all ids currently bound to the uniform.
   */
  public final fun getIds(): VariantArray<RID> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIdsPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RID>)
  }

  public companion object {
    @JvmField
    public val setUniformTypeName: MethodStringName1<RDUniform, Unit, RenderingDevice.UniformType> =
        MethodStringName1<RDUniform, Unit, RenderingDevice.UniformType>("set_uniform_type")

    @JvmField
    public val getUniformTypeName: MethodStringName0<RDUniform, RenderingDevice.UniformType> =
        MethodStringName0<RDUniform, RenderingDevice.UniformType>("get_uniform_type")

    @JvmField
    public val setBindingName: MethodStringName1<RDUniform, Unit, Int> =
        MethodStringName1<RDUniform, Unit, Int>("set_binding")

    @JvmField
    public val getBindingName: MethodStringName0<RDUniform, Int> =
        MethodStringName0<RDUniform, Int>("get_binding")

    @JvmField
    public val addIdName: MethodStringName1<RDUniform, Unit, RID> =
        MethodStringName1<RDUniform, Unit, RID>("add_id")

    @JvmField
    public val clearIdsName: MethodStringName0<RDUniform, Unit> =
        MethodStringName0<RDUniform, Unit>("clear_ids")

    @JvmField
    public val getIdsName: MethodStringName0<RDUniform, VariantArray<RID>> =
        MethodStringName0<RDUniform, VariantArray<RID>>("get_ids")
  }

  public object MethodBindings {
    internal val setUniformTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDUniform", "set_uniform_type", 1664894931)

    internal val getUniformTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDUniform", "get_uniform_type", 475470040)

    internal val setBindingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDUniform", "set_binding", 1286410249)

    internal val getBindingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDUniform", "get_binding", 3905245786)

    internal val addIdPtr: VoidPtr = TypeManager.getMethodBindPtr("RDUniform", "add_id", 2722037293)

    internal val clearIdsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDUniform", "clear_ids", 3218959716)

    internal val getIdsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDUniform", "get_ids", 3995934104)
  }
}
