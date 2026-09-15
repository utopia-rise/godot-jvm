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
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Translated to `uniform sampler2DArray` in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeTexture2DArray : VisualShaderNodeSample3D() {
  /**
   * A source texture array. Used if [VisualShaderNodeSample3D.source] is set to
   * [VisualShaderNodeSample3D.SOURCE_TEXTURE].
   */
  public final inline var textureArray: TextureLayered?
    @JvmName("textureArrayProperty")
    get() = getTextureArray()
    @JvmName("textureArrayProperty")
    set(`value`) {
      setTextureArray(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(876, scriptPtr)
  }

  public final fun setTextureArray(`value`: TextureLayered?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, value)
    TransferContext.callMethod(MethodBindings.setTextureArrayPtr)
  }

  public final fun getTextureArray(): TextureLayered? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureArrayPtr)
    return (TransferContext.readReturnValue_OBJECT() as TextureLayered?)
  }

  public companion object {
    @JvmField
    public val setTextureArrayName:
        MethodStringName1<VisualShaderNodeTexture2DArray, Unit, TextureLayered?> =
        MethodStringName1<VisualShaderNodeTexture2DArray, Unit, TextureLayered?>("set_texture_array")

    @JvmField
    public val getTextureArrayName:
        MethodStringName0<VisualShaderNodeTexture2DArray, TextureLayered?> =
        MethodStringName0<VisualShaderNodeTexture2DArray, TextureLayered?>("get_texture_array")
  }

  public object MethodBindings {
    internal val setTextureArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture2DArray", "set_texture_array", 1278366092)

    internal val getTextureArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture2DArray", "get_texture_array", 3984243839)
  }
}
