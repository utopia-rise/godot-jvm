// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.Vector3
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmName

/**
 * A Spotlight is a type of [Light3D] node that emits lights in a specific direction, in the shape
 * of a cone. The light is attenuated through the distance. This attenuation can be configured by
 * changing the energy, radius and attenuation parameters of [Light3D].
 *
 * Light is emitted in the -Z direction of the node's global basis. For an unrotated light, this
 * means that the light is emitted forwards, illuminating the front side of a 3D model (see
 * [Vector3.FORWARD] and [Vector3.MODEL_FRONT]).
 *
 * **Note:** When using the Mobile rendering method, only 8 spot lights can be displayed on each
 * mesh resource. Attempting to display more than 8 spot lights on a single mesh resource will result
 * in spot lights flickering in and out as the camera moves. When using the Compatibility rendering
 * method, only 8 spot lights can be displayed on each mesh resource by default, but this can be
 * increased by adjusting [ProjectSettings.rendering/limits/opengl/maxLightsPerObject].
 *
 * **Note:** When using the Mobile or Compatibility rendering methods, spot lights will only
 * correctly affect meshes whose visibility AABB intersects with the light's AABB. If using a shader to
 * deform the mesh in a way that makes it go outside its AABB, [GeometryInstance3D.extraCullMargin]
 * must be increased on the mesh. Otherwise, the light may not be visible on the mesh.
 */
@GodotBaseType
public open class SpotLight3D : Light3D() {
  /**
   * The maximal range that can be reached by the spotlight. Note that the effectively lit area may
   * appear to be smaller depending on the [spotAttenuation] in use. No matter the [spotAttenuation] in
   * use, the light will never reach anything outside this range.
   *
   * **Note:** [spotRange] is not affected by [Node3D.scale] (the light's scale or its parent's
   * scale).
   */
  public final inline var spotRange: Float
    @JvmName("spotRangeProperty")
    get() = getParam(Light3D.Param.RANGE)
    @JvmName("spotRangeProperty")
    set(`value`) {
      setParam(Light3D.Param.RANGE, value)
    }

  /**
   * Controls the distance attenuation function for spotlights.
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
  public final inline var spotAttenuation: Float
    @JvmName("spotAttenuationProperty")
    get() = getParam(Light3D.Param.ATTENUATION)
    @JvmName("spotAttenuationProperty")
    set(`value`) {
      setParam(Light3D.Param.ATTENUATION, value)
    }

  /**
   * The spotlight's angle in degrees. This is the angular radius, meaning the angle from the -Z
   * axis, the cone's center, to the edge of the cone. The default angular radius of 45 degrees
   * corresponds to a cone with an angular diameter of 90 degrees.
   *
   * **Note:** [spotAngle] is not affected by [Node3D.scale] (the light's scale or its parent's
   * scale).
   */
  public final inline var spotAngle: Float
    @JvmName("spotAngleProperty")
    get() = getParam(Light3D.Param.SPOT_ANGLE)
    @JvmName("spotAngleProperty")
    set(`value`) {
      setParam(Light3D.Param.SPOT_ANGLE, value)
    }

  /**
   * The spotlight's *angular* attenuation curve. See also [spotAttenuation].
   */
  public final inline var spotAngleAttenuation: Float
    @JvmName("spotAngleAttenuationProperty")
    get() = getParam(Light3D.Param.SPOT_ATTENUATION)
    @JvmName("spotAngleAttenuationProperty")
    set(`value`) {
      setParam(Light3D.Param.SPOT_ATTENUATION, value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(692, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
