// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A parameter represents a variable in the shader which is set externally, i.e. from the
 * [ShaderMaterial]. Parameters are exposed as properties in the [ShaderMaterial] and can be assigned
 * from the Inspector or from a script.
 */
@GodotBaseType
public open class VisualShaderNodeParameter internal constructor() : VisualShaderNode() {
  /**
   * Name of the parameter, by which it can be accessed through the [ShaderMaterial] properties.
   */
  public final inline var parameterName: String
    @JvmName("parameterNameProperty")
    get() = getParameterName()
    @JvmName("parameterNameProperty")
    set(`value`) {
      setParameterName(value)
    }

  /**
   * Defines the scope of the parameter.
   */
  public final inline var qualifier: Qualifier
    @JvmName("qualifierProperty")
    get() = getQualifier()
    @JvmName("qualifierProperty")
    set(`value`) {
      setQualifier(value)
    }

  /**
   * The index within 0-15 range, which is used to avoid clashes when shader used on multiple
   * materials.
   */
  public final inline var instanceIndex: Int
    @JvmName("instanceIndexProperty")
    get() = getInstanceIndex()
    @JvmName("instanceIndexProperty")
    set(`value`) {
      setInstanceIndex(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(848, scriptPtr)
  }

  public final fun setParameterName(name: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setParameterNamePtr, name)
  }

  public final fun getParameterName(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getParameterNamePtr)

  public final fun setQualifier(qualifier: Qualifier): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setQualifierPtr, qualifier.value)
  }

  public final fun getQualifier(): Qualifier =
      Qualifier.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getQualifierPtr))

  public final fun setInstanceIndex(instanceIndex: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setInstanceIndexPtr, instanceIndex.toLong())
  }

  public final fun getInstanceIndex(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getInstanceIndexPtr).toInt()

  public enum class Qualifier(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The parameter will be tied to the [ShaderMaterial] using this shader.
     */
    NONE(0),
    /**
     * The parameter will use a global value, defined in Project Settings.
     */
    GLOBAL(1),
    /**
     * The parameter will be tied to the node with attached [ShaderMaterial] using this shader.
     */
    INSTANCE(2),
    /**
     * The parameter will be tied to the node with attached [ShaderMaterial] using this shader.
     * Enables setting a [instanceIndex] property.
     */
    INSTANCE_INDEX(3),
    /**
     * Represents the size of the [Qualifier] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): Qualifier = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setParameterNameName: MethodStringName1<VisualShaderNodeParameter, Unit, String> =
        MethodStringName1<VisualShaderNodeParameter, Unit, String>("set_parameter_name")

    @JvmField
    public val getParameterNameName: MethodStringName0<VisualShaderNodeParameter, String> =
        MethodStringName0<VisualShaderNodeParameter, String>("get_parameter_name")

    @JvmField
    public val setQualifierName: MethodStringName1<VisualShaderNodeParameter, Unit, Qualifier> =
        MethodStringName1<VisualShaderNodeParameter, Unit, Qualifier>("set_qualifier")

    @JvmField
    public val getQualifierName: MethodStringName0<VisualShaderNodeParameter, Qualifier> =
        MethodStringName0<VisualShaderNodeParameter, Qualifier>("get_qualifier")

    @JvmField
    public val setInstanceIndexName: MethodStringName1<VisualShaderNodeParameter, Unit, Int> =
        MethodStringName1<VisualShaderNodeParameter, Unit, Int>("set_instance_index")

    @JvmField
    public val getInstanceIndexName: MethodStringName0<VisualShaderNodeParameter, Int> =
        MethodStringName0<VisualShaderNodeParameter, Int>("get_instance_index")
  }

  public object MethodBindings {
    internal val setParameterNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParameter", "set_parameter_name", 83702148)

    internal val getParameterNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParameter", "get_parameter_name", 201670096)

    internal val setQualifierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParameter", "set_qualifier", 1276489447)

    internal val getQualifierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParameter", "get_qualifier", 3558406205)

    internal val setInstanceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParameter", "set_instance_index", 1286410249)

    internal val getInstanceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParameter", "get_instance_index", 3905245786)
  }
}
