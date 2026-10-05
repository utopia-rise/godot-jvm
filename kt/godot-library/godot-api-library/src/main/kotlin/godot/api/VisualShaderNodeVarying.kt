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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Varying values are shader variables that can be passed between shader functions, e.g. from Vertex
 * shader to Fragment shader.
 */
@GodotBaseType
public open class VisualShaderNodeVarying internal constructor() : VisualShaderNode() {
  /**
   * Name of the variable. Must be unique.
   */
  public final inline var varyingName: String
    @JvmName("varyingNameProperty")
    get() = getVaryingName()
    @JvmName("varyingNameProperty")
    set(`value`) {
      setVaryingName(value)
    }

  /**
   * Type of the variable. Determines where the variable can be accessed.
   */
  public final inline var varyingType: VisualShader.VaryingType
    @JvmName("varyingTypeProperty")
    get() = getVaryingType()
    @JvmName("varyingTypeProperty")
    set(`value`) {
      setVaryingType(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(898, scriptPtr)
  }

  public final fun setVaryingName(name: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setVaryingNamePtr, name)
  }

  public final fun getVaryingName(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getVaryingNamePtr)

  public final fun setVaryingType(type: VisualShader.VaryingType): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVaryingTypePtr, type.value)
  }

  public final fun getVaryingType(): VisualShader.VaryingType =
      VisualShader.VaryingType.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVaryingTypePtr))

  public companion object {
    @JvmField
    public val setVaryingNameName: MethodStringName1<VisualShaderNodeVarying, Unit, String> =
        MethodStringName1<VisualShaderNodeVarying, Unit, String>("set_varying_name")

    @JvmField
    public val getVaryingNameName: MethodStringName0<VisualShaderNodeVarying, String> =
        MethodStringName0<VisualShaderNodeVarying, String>("get_varying_name")

    @JvmField
    public val setVaryingTypeName:
        MethodStringName1<VisualShaderNodeVarying, Unit, VisualShader.VaryingType> =
        MethodStringName1<VisualShaderNodeVarying, Unit, VisualShader.VaryingType>("set_varying_type")

    @JvmField
    public val getVaryingTypeName:
        MethodStringName0<VisualShaderNodeVarying, VisualShader.VaryingType> =
        MethodStringName0<VisualShaderNodeVarying, VisualShader.VaryingType>("get_varying_type")
  }

  public object MethodBindings {
    internal val setVaryingNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVarying", "set_varying_name", 83702148)

    internal val getVaryingNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVarying", "get_varying_name", 201670096)

    internal val setVaryingTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVarying", "set_varying_type", 3565867981)

    internal val getVaryingTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVarying", "get_varying_type", 523183580)
  }
}
