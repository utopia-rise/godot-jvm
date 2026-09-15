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
import godot.core.MethodStringName2
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT_STRING_NAME
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_NAME
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Compiled shader file in SPIR-V form.
 *
 * See also [RDShaderSource]. [RDShaderFile] is only meant to be used with the [RenderingDevice]
 * API. It should not be confused with Godot's own [Shader] resource, which is what Godot's various
 * nodes use for high-level shader programming.
 */
@GodotBaseType
public open class RDShaderFile : Resource() {
  /**
   * The base compilation error message, which indicates errors not related to a specific shader
   * stage if non-empty. If empty, shader compilation is not necessarily successful (check
   * [RDShaderSPIRV]'s error message members).
   */
  public final inline var baseError: String
    @JvmName("baseErrorProperty")
    get() = getBaseError()
    @JvmName("baseErrorProperty")
    set(`value`) {
      setBaseError(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(590, scriptPtr)
  }

  /**
   * Sets the SPIR-V [bytecode] that will be compiled for the specified [version].
   */
  public final fun setBytecode(bytecode: RDShaderSPIRV?, version: StringName = StringName("")):
      Unit {
    TransferContext.writeMethodArguments_OBJECT_STRING_NAME(ptr, objectID.id, bytecode, version)
    TransferContext.callMethod(MethodBindings.setBytecodePtr)
  }

  /**
   * Returns the SPIR-V intermediate representation for the specified shader [version].
   */
  public final fun getSpirv(version: StringName = StringName("")): RDShaderSPIRV? {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, version)
    TransferContext.callMethod(MethodBindings.getSpirvPtr)
    return (TransferContext.readReturnValue_OBJECT() as RDShaderSPIRV?)
  }

  /**
   * Returns the list of compiled versions for this shader.
   */
  public final fun getVersionList(): VariantArray<StringName> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVersionListPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<StringName>)
  }

  public final fun setBaseError(error: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, error)
    TransferContext.callMethod(MethodBindings.setBaseErrorPtr)
  }

  public final fun getBaseError(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBaseErrorPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the SPIR-V [bytecode] that will be compiled for the specified [version].
   */
  public final fun setBytecode(bytecode: RDShaderSPIRV?, version: String) =
      setBytecode(bytecode, version.asCachedStringName())

  /**
   * Returns the SPIR-V intermediate representation for the specified shader [version].
   */
  public final fun getSpirv(version: String): RDShaderSPIRV? =
      getSpirv(version.asCachedStringName())

  public companion object {
    @JvmField
    public val setBytecodeName: MethodStringName2<RDShaderFile, Unit, RDShaderSPIRV?, StringName> =
        MethodStringName2<RDShaderFile, Unit, RDShaderSPIRV?, StringName>("set_bytecode")

    @JvmField
    public val getSpirvName: MethodStringName1<RDShaderFile, RDShaderSPIRV?, StringName> =
        MethodStringName1<RDShaderFile, RDShaderSPIRV?, StringName>("get_spirv")

    @JvmField
    public val getVersionListName: MethodStringName0<RDShaderFile, VariantArray<StringName>> =
        MethodStringName0<RDShaderFile, VariantArray<StringName>>("get_version_list")

    @JvmField
    public val setBaseErrorName: MethodStringName1<RDShaderFile, Unit, String> =
        MethodStringName1<RDShaderFile, Unit, String>("set_base_error")

    @JvmField
    public val getBaseErrorName: MethodStringName0<RDShaderFile, String> =
        MethodStringName0<RDShaderFile, String>("get_base_error")
  }

  public object MethodBindings {
    internal val setBytecodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderFile", "set_bytecode", 1526857008)

    internal val getSpirvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderFile", "get_spirv", 2689310080)

    internal val getVersionListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderFile", "get_version_list", 3995934104)

    internal val setBaseErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderFile", "set_base_error", 83702148)

    internal val getBaseErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderFile", "get_base_error", 201670096)
  }
}
