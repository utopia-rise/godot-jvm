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
import godot.core.PackedStringArray
import godot.readReturnValue_BOOL
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * This object contains shader fragments from Godot's internal shaders. These can be used when
 * access to internal uniform buffers and/or internal functions is required for instance when composing
 * compositor effects or compute shaders. Only fragments for the current rendering device are loaded.
 */
@GodotBaseType
public open class ShaderIncludeDB : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(657, scriptPtr)
  }

  public companion object {
    @JvmField
    public val listBuiltInIncludeFilesName: MethodStringName0<ShaderIncludeDB, PackedStringArray> =
        MethodStringName0<ShaderIncludeDB, PackedStringArray>("list_built_in_include_files")

    @JvmField
    public val hasBuiltInIncludeFileName: MethodStringName1<ShaderIncludeDB, Boolean, String> =
        MethodStringName1<ShaderIncludeDB, Boolean, String>("has_built_in_include_file")

    @JvmField
    public val getBuiltInIncludeFileName: MethodStringName1<ShaderIncludeDB, String, String> =
        MethodStringName1<ShaderIncludeDB, String, String>("get_built_in_include_file")

    /**
     * Returns a list of built-in include files that are currently registered.
     */
    @JvmStatic
    public final fun listBuiltInIncludeFiles(): PackedStringArray {
      TransferContext.writeMethodArguments0(0L, 0L)
      TransferContext.callPtrMethod(MethodBindings.listBuiltInIncludeFilesPtr, 34)
      return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
    }

    /**
     * Returns `true` if an include file with this name exists.
     */
    @JvmStatic
    public final fun hasBuiltInIncludeFile(filename: String): Boolean {
      TransferContext.writeMethodArguments_STRING(0L, 0L, filename)
      TransferContext.callMethod(MethodBindings.hasBuiltInIncludeFilePtr)
      return TransferContext.readReturnValue_BOOL()
    }

    /**
     * Returns the code for the built-in shader fragment. You can also access this in your shader
     * code through `#include "filename"`.
     */
    @JvmStatic
    public final fun getBuiltInIncludeFile(filename: String): String {
      TransferContext.writeMethodArguments_STRING(0L, 0L, filename)
      TransferContext.callMethod(MethodBindings.getBuiltInIncludeFilePtr)
      return TransferContext.readReturnValue_STRING()
    }
  }

  public object MethodBindings {
    internal val listBuiltInIncludeFilesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderIncludeDB", "list_built_in_include_files", 2981934095)

    internal val hasBuiltInIncludeFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderIncludeDB", "has_built_in_include_file", 2323990056)

    internal val getBuiltInIncludeFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderIncludeDB", "get_built_in_include_file", 1703090593)
  }
}
