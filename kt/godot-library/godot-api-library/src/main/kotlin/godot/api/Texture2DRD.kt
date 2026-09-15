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
import godot.core.RID
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_RID
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This texture class allows you to use a 2D texture created directly on the [RenderingDevice] as a
 * texture for materials, meshes, etc.
 *
 * **Note:** [Texture2DRD] is intended for low-level usage with [RenderingDevice]. For most use
 * cases, use [Texture2D] instead.
 */
@GodotBaseType
public open class Texture2DRD : Texture2D() {
  /**
   * The RID of the texture object created on the [RenderingDevice].
   */
  public final inline var textureRdRid: RID
    @JvmName("textureRdRidProperty")
    get() = getTextureRdRid()
    @JvmName("textureRdRidProperty")
    set(`value`) {
      setTextureRdRid(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(743, scriptPtr)
  }

  public final fun setTextureRdRid(textureRdRid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, textureRdRid)
    TransferContext.callMethod(MethodBindings.setTextureRdRidPtr)
  }

  public final fun getTextureRdRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureRdRidPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("Texture2DRD::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("Texture2DRD::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setTextureRdRidName: MethodStringName1<Texture2DRD, Unit, RID> =
        MethodStringName1<Texture2DRD, Unit, RID>("set_texture_rd_rid")

    @JvmField
    public val getTextureRdRidName: MethodStringName0<Texture2DRD, RID> =
        MethodStringName0<Texture2DRD, RID>("get_texture_rd_rid")
  }

  public object MethodBindings {
    internal val setTextureRdRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2DRD", "set_texture_rd_rid", 2722037293)

    internal val getTextureRdRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Texture2DRD", "get_texture_rd_rid", 2944877500)
  }
}
