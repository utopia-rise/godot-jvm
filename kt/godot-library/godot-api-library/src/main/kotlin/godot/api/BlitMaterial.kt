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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.VariantParser.LONG
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A material resource that can be used by DrawableTextures when processing blit calls to draw.
 */
@GodotBaseType
public open class BlitMaterial : Material() {
  /**
   * The manner in which the newly blitted texture is blended with the original DrawableTexture.
   */
  public final inline var blendMode: BlendMode
    @JvmName("blendModeProperty")
    get() = getBlendMode()
    @JvmName("blendModeProperty")
    set(`value`) {
      setBlendMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(108, scriptPtr)
  }

  public final fun setBlendMode(blendMode: BlendMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to blendMode.value)
    TransferContext.callMethod(MethodBindings.setBlendModePtr)
  }

  public final fun getBlendMode(): BlendMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendModePtr)
    return BlendMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderRid(): RID {
    throw NotImplementedError("BlitMaterial::_getShaderRid can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("BlitMaterial::_getShaderMode can't be called from the JVM.")
  }

  public enum class BlendMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Mix blending mode. Colors are assumed to be independent of the alpha (opacity) value.
     */
    MIX(0),
    /**
     * Additive blending mode.
     */
    ADD(1),
    /**
     * Subtractive blending mode.
     */
    SUB(2),
    /**
     * Multiplicative blending mode.
     */
    MUL(3),
    /**
     * No blending mode, direct color copy.
     */
    DISABLED(4),
    ;

    public companion object {
      public fun from(`value`: Long): BlendMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setBlendModeName: MethodStringName1<BlitMaterial, Unit, BlendMode> =
        MethodStringName1<BlitMaterial, Unit, BlendMode>("set_blend_mode")

    @JvmField
    public val getBlendModeName: MethodStringName0<BlitMaterial, BlendMode> =
        MethodStringName0<BlitMaterial, BlendMode>("get_blend_mode")
  }

  public object MethodBindings {
    internal val setBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BlitMaterial", "set_blend_mode", 80206916)

    internal val getBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BlitMaterial", "get_blend_mode", 4234246416)
  }
}
