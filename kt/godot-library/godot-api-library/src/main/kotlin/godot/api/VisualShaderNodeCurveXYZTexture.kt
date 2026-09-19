// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Comes with a built-in editor for texture's curves.
 */
@GodotBaseType
public open class VisualShaderNodeCurveXYZTexture : VisualShaderNodeResizableBase() {
  /**
   * The source texture.
   */
  public final inline var texture: CurveXYZTexture?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(820, scriptPtr)
  }

  public final fun setTexture(texture: CurveXYZTexture?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setTexturePtr, texture)
  }

  public final fun getTexture(): CurveXYZTexture? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getTexturePtr) as CurveXYZTexture?)

  public companion object {
    @JvmField
    public val setTextureName:
        MethodStringName1<VisualShaderNodeCurveXYZTexture, Unit, CurveXYZTexture?> =
        MethodStringName1<VisualShaderNodeCurveXYZTexture, Unit, CurveXYZTexture?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<VisualShaderNodeCurveXYZTexture, CurveXYZTexture?>
        = MethodStringName0<VisualShaderNodeCurveXYZTexture, CurveXYZTexture?>("get_texture")
  }

  public object MethodBindings {
    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCurveXYZTexture", "set_texture", 8031783)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCurveXYZTexture", "get_texture", 1950275015)
  }
}
