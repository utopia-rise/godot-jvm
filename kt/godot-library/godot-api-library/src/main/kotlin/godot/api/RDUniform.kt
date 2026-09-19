// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.callPtrMethod_RID
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.VariantArray
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
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setUniformTypePtr, pMember.value)
  }

  public final fun getUniformType(): RenderingDevice.UniformType =
      RenderingDevice.UniformType.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getUniformTypePtr))

  public final fun setBinding(pMember: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBindingPtr, pMember.toLong())
  }

  public final fun getBinding(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBindingPtr).toInt()

  /**
   * Binds the given id to the uniform. The data associated with the id is then used when the
   * uniform is passed to a shader.
   */
  public final fun addId(id: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.addIdPtr, id)
  }

  /**
   * Unbinds all ids currently bound to the uniform.
   */
  public final fun clearIds(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearIdsPtr)
  }

  /**
   * Returns an array of all ids currently bound to the uniform.
   */
  public final fun getIds(): VariantArray<RID> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getIdsPtr) as VariantArray<RID>)

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
