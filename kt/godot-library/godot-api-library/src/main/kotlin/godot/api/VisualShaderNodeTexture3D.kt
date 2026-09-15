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
 * Performs a lookup operation on the provided texture, with support for multiple texture sources to
 * choose from.
 */
@GodotBaseType
public open class VisualShaderNodeTexture3D : VisualShaderNodeSample3D() {
  /**
   * A source texture. Used if [VisualShaderNodeSample3D.source] is set to
   * [VisualShaderNodeSample3D.SOURCE_TEXTURE].
   */
  public final inline var texture: Texture3D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(879, scriptPtr)
  }

  public final fun setTexture(`value`: Texture3D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, value)
    TransferContext.callPtrMethod(MethodBindings.setTexturePtr, 0)
  }

  public final fun getTexture(): Texture3D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTexturePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Texture3D?)
  }

  public companion object {
    @JvmField
    public val setTextureName: MethodStringName1<VisualShaderNodeTexture3D, Unit, Texture3D?> =
        MethodStringName1<VisualShaderNodeTexture3D, Unit, Texture3D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<VisualShaderNodeTexture3D, Texture3D?> =
        MethodStringName0<VisualShaderNodeTexture3D, Texture3D?>("get_texture")
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture3D", "set_texture", 1188404210)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTexture3D", "get_texture", 373985333)
  }
}
