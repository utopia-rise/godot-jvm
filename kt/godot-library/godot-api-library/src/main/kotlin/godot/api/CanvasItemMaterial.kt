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
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [CanvasItemMaterial]s provide a means of modifying the textures associated with a CanvasItem.
 * They specialize in describing blend and lighting behaviors for textures. Use a [ShaderMaterial] to
 * more fully customize a material's interactions with a [CanvasItem].
 */
@GodotBaseType
public open class CanvasItemMaterial : Material() {
  /**
   * The manner in which a material's rendering is applied to underlying textures.
   */
  public final inline var blendMode: BlendMode
    @JvmName("blendModeProperty")
    get() = getBlendMode()
    @JvmName("blendModeProperty")
    set(`value`) {
      setBlendMode(value)
    }

  /**
   * The manner in which material reacts to lighting.
   */
  public final inline var lightMode: LightMode
    @JvmName("lightModeProperty")
    get() = getLightMode()
    @JvmName("lightModeProperty")
    set(`value`) {
      setLightMode(value)
    }

  /**
   * If `true`, enable spritesheet-based animation features when assigned to [GPUParticles2D] and
   * [CPUParticles2D] nodes. The [ParticleProcessMaterial.animSpeedMax] or
   * [CPUParticles2D.animSpeedMax] should also be set to a positive value for the animation to play.
   *
   * This property (and other `particles_anim_*` properties that depend on it) has no effect on
   * other types of nodes.
   */
  public final inline var particlesAnimation: Boolean
    @JvmName("particlesAnimationProperty")
    get() = getParticlesAnimation()
    @JvmName("particlesAnimationProperty")
    set(`value`) {
      setParticlesAnimation(value)
    }

  /**
   * The number of columns in the spritesheet assigned as [Texture2D] for a [GPUParticles2D] or
   * [CPUParticles2D].
   *
   * **Note:** This property is only used and visible in the editor if [particlesAnimation] is
   * `true`.
   */
  public final inline var particlesAnimHFrames: Int
    @JvmName("particlesAnimHFramesProperty")
    get() = getParticlesAnimHFrames()
    @JvmName("particlesAnimHFramesProperty")
    set(`value`) {
      setParticlesAnimHFrames(value)
    }

  /**
   * The number of rows in the spritesheet assigned as [Texture2D] for a [GPUParticles2D] or
   * [CPUParticles2D].
   *
   * **Note:** This property is only used and visible in the editor if [particlesAnimation] is
   * `true`.
   */
  public final inline var particlesAnimVFrames: Int
    @JvmName("particlesAnimVFramesProperty")
    get() = getParticlesAnimVFrames()
    @JvmName("particlesAnimVFramesProperty")
    set(`value`) {
      setParticlesAnimVFrames(value)
    }

  /**
   * If `true`, the particles animation will loop.
   *
   * **Note:** This property is only used and visible in the editor if [particlesAnimation] is
   * `true`.
   */
  public final inline var particlesAnimLoop: Boolean
    @JvmName("particlesAnimLoopProperty")
    get() = getParticlesAnimLoop()
    @JvmName("particlesAnimLoopProperty")
    set(`value`) {
      setParticlesAnimLoop(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(143, scriptPtr)
  }

  public final fun setBlendMode(blendMode: BlendMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, blendMode.value)
    TransferContext.callPtrMethod(MethodBindings.setBlendModePtr, 0)
  }

  public final fun getBlendMode(): BlendMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBlendModePtr, 2)
    return BlendMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setLightMode(lightMode: LightMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, lightMode.value)
    TransferContext.callPtrMethod(MethodBindings.setLightModePtr, 0)
  }

  public final fun getLightMode(): LightMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLightModePtr, 2)
    return LightMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setParticlesAnimation(particlesAnim: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, particlesAnim)
    TransferContext.callPtrMethod(MethodBindings.setParticlesAnimationPtr, 0)
  }

  public final fun getParticlesAnimation(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getParticlesAnimationPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setParticlesAnimHFrames(frames: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, frames.toLong())
    TransferContext.callPtrMethod(MethodBindings.setParticlesAnimHFramesPtr, 0)
  }

  public final fun getParticlesAnimHFrames(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getParticlesAnimHFramesPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setParticlesAnimVFrames(frames: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, frames.toLong())
    TransferContext.callPtrMethod(MethodBindings.setParticlesAnimVFramesPtr, 0)
  }

  public final fun getParticlesAnimVFrames(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getParticlesAnimVFramesPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setParticlesAnimLoop(loop: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, loop)
    TransferContext.callPtrMethod(MethodBindings.setParticlesAnimLoopPtr, 0)
  }

  public final fun getParticlesAnimLoop(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getParticlesAnimLoopPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderRid(): RID {
    throw NotImplementedError("CanvasItemMaterial::_getShaderRid can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("CanvasItemMaterial::_getShaderMode can't be called from the JVM.")
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
     * Mix blending mode. Colors are assumed to be premultiplied by the alpha (opacity) value.
     */
    PREMULT_ALPHA(4),
    ;

    public companion object {
      public fun from(`value`: Long): BlendMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LightMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Render the material using both light and non-light sensitive material properties.
     */
    NORMAL(0),
    /**
     * Render the material as if there were no light.
     */
    UNSHADED(1),
    /**
     * Render the material as if there were only light.
     */
    LIGHT_ONLY(2),
    ;

    public companion object {
      public fun from(`value`: Long): LightMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setBlendModeName: MethodStringName1<CanvasItemMaterial, Unit, BlendMode> =
        MethodStringName1<CanvasItemMaterial, Unit, BlendMode>("set_blend_mode")

    @JvmField
    public val getBlendModeName: MethodStringName0<CanvasItemMaterial, BlendMode> =
        MethodStringName0<CanvasItemMaterial, BlendMode>("get_blend_mode")

    @JvmField
    public val setLightModeName: MethodStringName1<CanvasItemMaterial, Unit, LightMode> =
        MethodStringName1<CanvasItemMaterial, Unit, LightMode>("set_light_mode")

    @JvmField
    public val getLightModeName: MethodStringName0<CanvasItemMaterial, LightMode> =
        MethodStringName0<CanvasItemMaterial, LightMode>("get_light_mode")

    @JvmField
    public val setParticlesAnimationName: MethodStringName1<CanvasItemMaterial, Unit, Boolean> =
        MethodStringName1<CanvasItemMaterial, Unit, Boolean>("set_particles_animation")

    @JvmField
    public val getParticlesAnimationName: MethodStringName0<CanvasItemMaterial, Boolean> =
        MethodStringName0<CanvasItemMaterial, Boolean>("get_particles_animation")

    @JvmField
    public val setParticlesAnimHFramesName: MethodStringName1<CanvasItemMaterial, Unit, Int> =
        MethodStringName1<CanvasItemMaterial, Unit, Int>("set_particles_anim_h_frames")

    @JvmField
    public val getParticlesAnimHFramesName: MethodStringName0<CanvasItemMaterial, Int> =
        MethodStringName0<CanvasItemMaterial, Int>("get_particles_anim_h_frames")

    @JvmField
    public val setParticlesAnimVFramesName: MethodStringName1<CanvasItemMaterial, Unit, Int> =
        MethodStringName1<CanvasItemMaterial, Unit, Int>("set_particles_anim_v_frames")

    @JvmField
    public val getParticlesAnimVFramesName: MethodStringName0<CanvasItemMaterial, Int> =
        MethodStringName0<CanvasItemMaterial, Int>("get_particles_anim_v_frames")

    @JvmField
    public val setParticlesAnimLoopName: MethodStringName1<CanvasItemMaterial, Unit, Boolean> =
        MethodStringName1<CanvasItemMaterial, Unit, Boolean>("set_particles_anim_loop")

    @JvmField
    public val getParticlesAnimLoopName: MethodStringName0<CanvasItemMaterial, Boolean> =
        MethodStringName0<CanvasItemMaterial, Boolean>("get_particles_anim_loop")
  }

  public object MethodBindings {
    internal val setBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "set_blend_mode", 1786054936)

    internal val getBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "get_blend_mode", 3318684035)

    internal val setLightModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "set_light_mode", 628074070)

    internal val getLightModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "get_light_mode", 3863292382)

    internal val setParticlesAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "set_particles_animation", 2586408642)

    internal val getParticlesAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "get_particles_animation", 36873697)

    internal val setParticlesAnimHFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "set_particles_anim_h_frames", 1286410249)

    internal val getParticlesAnimHFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "get_particles_anim_h_frames", 3905245786)

    internal val setParticlesAnimVFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "set_particles_anim_v_frames", 1286410249)

    internal val getParticlesAnimVFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "get_particles_anim_v_frames", 3905245786)

    internal val setParticlesAnimLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "set_particles_anim_loop", 2586408642)

    internal val getParticlesAnimLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CanvasItemMaterial", "get_particles_anim_loop", 36873697)
  }
}
