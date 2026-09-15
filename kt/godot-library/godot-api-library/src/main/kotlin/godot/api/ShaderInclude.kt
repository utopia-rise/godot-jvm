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
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A shader include file, saved with the `.gdshaderinc` extension. This class allows you to define a
 * custom shader snippet that can be included in a [Shader] by using the preprocessor directive
 * `#include`, followed by the file path (e.g. `#include "res://shader_lib.gdshaderinc"`). The snippet
 * doesn't have to be a valid shader on its own.
 */
@GodotBaseType
public open class ShaderInclude : Resource() {
  /**
   * Returns the code of the shader include file. The returned text is what the user has written,
   * not the full generated code used internally.
   */
  public final inline var code: String
    @JvmName("codeProperty")
    get() = getCode()
    @JvmName("codeProperty")
    set(`value`) {
      setCode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(656, scriptPtr)
  }

  public final fun setCode(code: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, code)
    TransferContext.callMethod(MethodBindings.setCodePtr)
  }

  public final fun getCode(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCodePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val setCodeName: MethodStringName1<ShaderInclude, Unit, String> =
        MethodStringName1<ShaderInclude, Unit, String>("set_code")

    @JvmField
    public val getCodeName: MethodStringName0<ShaderInclude, String> =
        MethodStringName0<ShaderInclude, String>("get_code")
  }

  public object MethodBindings {
    internal val setCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderInclude", "set_code", 83702148)

    internal val getCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderInclude", "get_code", 201670096)
  }
}
