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
 * Comes with a built-in editor for texture's curves.
 */
@GodotBaseType
public open class VisualShaderNodeCurveTexture : VisualShaderNodeResizableBase() {
  /**
   * The source texture.
   */
  public final inline var texture: CurveTexture?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(819, scriptPtr)
  }

  public final fun setTexture(texture: CurveTexture?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, texture)
    TransferContext.callPtrMethod(MethodBindings.setTexturePtr, 0)
  }

  public final fun getTexture(): CurveTexture? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTexturePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as CurveTexture?)
  }

  public companion object {
    @JvmField
    public val setTextureName: MethodStringName1<VisualShaderNodeCurveTexture, Unit, CurveTexture?>
        = MethodStringName1<VisualShaderNodeCurveTexture, Unit, CurveTexture?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<VisualShaderNodeCurveTexture, CurveTexture?> =
        MethodStringName0<VisualShaderNodeCurveTexture, CurveTexture?>("get_texture")
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCurveTexture", "set_texture", 181872837)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCurveTexture", "get_texture", 2800800579)
  }
}
