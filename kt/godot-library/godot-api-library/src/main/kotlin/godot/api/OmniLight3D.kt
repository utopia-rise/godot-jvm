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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An Omnidirectional light is a type of [Light3D] that emits light in all directions. The light is
 * attenuated by distance and this attenuation can be configured by changing its energy, radius, and
 * attenuation parameters.
 *
 * **Note:** When using the Mobile rendering method, only 8 omni lights can be displayed on each
 * mesh resource. Attempting to display more than 8 omni lights on a single mesh resource will result
 * in omni lights flickering in and out as the camera moves. When using the Compatibility rendering
 * method, only 8 omni lights can be displayed on each mesh resource by default, but this can be
 * increased by adjusting [ProjectSettings.rendering/limits/opengl/maxLightsPerObject].
 *
 * **Note:** When using the Mobile or Compatibility rendering methods, omni lights will only
 * correctly affect meshes whose visibility AABB intersects with the light's AABB. If using a shader to
 * deform the mesh in a way that makes it go outside its AABB, [GeometryInstance3D.extraCullMargin]
 * must be increased on the mesh. Otherwise, the light may not be visible on the mesh.
 */
@GodotBaseType
public open class OmniLight3D : Light3D() {
  /**
   * The light's radius. Note that the effectively lit area may appear to be smaller depending on
   * the [omniAttenuation] in use. No matter the [omniAttenuation] in use, the light will never reach
   * anything outside this radius.
   *
   * **Note:** [omniRange] is not affected by [Node3D.scale] (the light's scale or its parent's
   * scale).
   */
  public final inline var omniRange: Float
    @JvmName("omniRangeProperty")
    get() = getParam(Light3D.Param.RANGE)
    @JvmName("omniRangeProperty")
    set(`value`) {
      setParam(Light3D.Param.RANGE, value)
    }

  /**
   * Controls the distance attenuation function for omnilights.
   *
   * A value of `0.0` will maintain a constant brightness through most of the range, but smoothly
   * attenuate the light at the edge of the range. Use a value of `2.0` for physically accurate lights
   * as it results in the proper inverse square attenutation.
   *
   * **Note:** Setting attenuation to `2.0` or higher may result in distant objects receiving
   * minimal light, even within range. For example, with a range of `4096`, an object at `100` units is
   * attenuated by a factor of `0.0001`. With a default brightness of `1`, the light would not be
   * visible at that distance.
   *
   * **Note:** Using negative or values higher than `10.0` may lead to unexpected results.
   */
  public final inline var omniAttenuation: Float
    @JvmName("omniAttenuationProperty")
    get() = getParam(Light3D.Param.ATTENUATION)
    @JvmName("omniAttenuationProperty")
    set(`value`) {
      setParam(Light3D.Param.ATTENUATION, value)
    }

  public final inline var omniShadowMode: ShadowMode
    @JvmName("omniShadowModeProperty")
    get() = getShadowMode()
    @JvmName("omniShadowModeProperty")
    set(`value`) {
      setShadowMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(435, scriptPtr)
  }

  public final fun setShadowMode(mode: ShadowMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setShadowModePtr, 0)
  }

  public final fun getShadowMode(): ShadowMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getShadowModePtr, 2)
    return ShadowMode.from(TransferContext.readReturnValue_LONG())
  }

  public enum class ShadowMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Shadows are rendered to a dual-paraboloid texture. Faster than [SHADOW_CUBE], but
     * lower-quality.
     */
    DUAL_PARABOLOID(0),
    /**
     * Shadows are rendered to a cubemap. Slower than [SHADOW_DUAL_PARABOLOID], but higher-quality.
     */
    CUBE(1),
    ;

    public companion object {
      public fun from(`value`: Long): ShadowMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setShadowModeName: MethodStringName1<OmniLight3D, Unit, ShadowMode> =
        MethodStringName1<OmniLight3D, Unit, ShadowMode>("set_shadow_mode")

    @JvmField
    public val getShadowModeName: MethodStringName0<OmniLight3D, ShadowMode> =
        MethodStringName0<OmniLight3D, ShadowMode>("get_shadow_mode")
  }

  public object MethodBindings {
    internal val setShadowModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OmniLight3D", "set_shadow_mode", 121862228)

    internal val getShadowModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OmniLight3D", "get_shadow_mode", 4181586331)
  }
}
