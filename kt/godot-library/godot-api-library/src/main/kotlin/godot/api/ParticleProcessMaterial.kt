// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR3
import godot.core.Vector2
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [ParticleProcessMaterial] defines particle properties and behavior. It is used in the
 * `process_material` of the [GPUParticles2D] and [GPUParticles3D] nodes. Some of this material's
 * properties are applied to each particle when emitted, while others can have a [CurveTexture] or a
 * [GradientTexture1D] applied to vary numerical or color values over the lifetime of the particle.
 */
@GodotBaseType
public open class ParticleProcessMaterial : Material() {
  /**
   * Emitted when this material's emission shape is changed in any way. This includes changes to
   * [emissionShape], [emissionShapeScale], or [emissionSphereRadius], and any other property that
   * affects the emission shape's offset, size, scale, or orientation.
   *
   * **Note:** This signal is only emitted inside the editor for performance reasons.
   */
  public val emissionShapeChanged: Signal0 by Signal0

  /**
   * Particle lifetime randomness ratio. The equation for the lifetime of a particle is `lifetime *
   * (1.0 - randf() * lifetime_randomness)`. For example, a [lifetimeRandomness] of `0.4` scales the
   * lifetime between `0.6` to `1.0` of its original value.
   */
  public final inline var lifetimeRandomness: Double
    @JvmName("lifetimeRandomnessProperty")
    get() = getLifetimeRandomness()
    @JvmName("lifetimeRandomnessProperty")
    set(`value`) {
      setLifetimeRandomness(value)
    }

  /**
   * Align Y axis of particle with the direction of its velocity.
   */
  public final inline var particleFlagAlignY: Boolean
    @JvmName("particleFlagAlignYProperty")
    get() = getParticleFlag(ParticleProcessMaterial.ParticleFlags.ALIGN_Y_TO_VELOCITY)
    @JvmName("particleFlagAlignYProperty")
    set(`value`) {
      setParticleFlag(ParticleProcessMaterial.ParticleFlags.ALIGN_Y_TO_VELOCITY, value)
    }

  /**
   * If `true`, particles rotate around Y axis by [angleMin].
   */
  public final inline var particleFlagRotateY: Boolean
    @JvmName("particleFlagRotateYProperty")
    get() = getParticleFlag(ParticleProcessMaterial.ParticleFlags.ROTATE_Y)
    @JvmName("particleFlagRotateYProperty")
    set(`value`) {
      setParticleFlag(ParticleProcessMaterial.ParticleFlags.ROTATE_Y, value)
    }

  /**
   * If `true`, particles will not move on the z axis.
   */
  public final inline var particleFlagDisableZ: Boolean
    @JvmName("particleFlagDisableZProperty")
    get() = getParticleFlag(ParticleProcessMaterial.ParticleFlags.DISABLE_Z)
    @JvmName("particleFlagDisableZProperty")
    set(`value`) {
      setParticleFlag(ParticleProcessMaterial.ParticleFlags.DISABLE_Z, value)
    }

  /**
   * Changes the behavior of the damping properties from a linear deceleration to a deceleration
   * based on speed percentage.
   */
  public final inline var particleFlagDampingAsFriction: Boolean
    @JvmName("particleFlagDampingAsFrictionProperty")
    get() = getParticleFlag(ParticleProcessMaterial.ParticleFlags.DAMPING_AS_FRICTION)
    @JvmName("particleFlagDampingAsFrictionProperty")
    set(`value`) {
      setParticleFlag(ParticleProcessMaterial.ParticleFlags.DAMPING_AS_FRICTION, value)
    }

  /**
   * If `true`, particles will inherit the scale of the emitter.
   *
   * **Note:** This has no effect when [GPUParticles3D.localCoords] is `true`, since particles in
   * local space are already affected by the emitter's scale.
   */
  public final inline var particleFlagInheritEmitterScale: Boolean
    @JvmName("particleFlagInheritEmitterScaleProperty")
    get() = getParticleFlag(ParticleProcessMaterial.ParticleFlags.INHERIT_EMITTER_SCALE)
    @JvmName("particleFlagInheritEmitterScaleProperty")
    set(`value`) {
      setParticleFlag(ParticleProcessMaterial.ParticleFlags.INHERIT_EMITTER_SCALE, value)
    }

  /**
   * The offset for the [emissionShape], in local space.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var emissionShapeOffset: Vector3
    @JvmName("emissionShapeOffsetProperty")
    get() = getEmissionShapeOffset()
    @JvmName("emissionShapeOffsetProperty")
    set(`value`) {
      setEmissionShapeOffset(value)
    }

  /**
   * The scale of the [emissionShape], in local space.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var emissionShapeScale: Vector3
    @JvmName("emissionShapeScaleProperty")
    get() = getEmissionShapeScale()
    @JvmName("emissionShapeScaleProperty")
    set(`value`) {
      setEmissionShapeScale(value)
    }

  /**
   * Particles will be emitted inside this region.
   */
  public final inline var emissionShape: EmissionShape
    @JvmName("emissionShapeProperty")
    get() = getEmissionShape()
    @JvmName("emissionShapeProperty")
    set(`value`) {
      setEmissionShape(value)
    }

  /**
   * The sphere's radius if [emissionShape] is set to [EMISSION_SHAPE_SPHERE].
   */
  public final inline var emissionSphereRadius: Float
    @JvmName("emissionSphereRadiusProperty")
    get() = getEmissionSphereRadius()
    @JvmName("emissionSphereRadiusProperty")
    set(`value`) {
      setEmissionSphereRadius(value)
    }

  /**
   * The box's extents if [emissionShape] is set to [EMISSION_SHAPE_BOX].
   *
   * **Note:** [emissionBoxExtents] starts from the center point and applies the X, Y, and Z values
   * in both directions. The size is twice the area of the extents.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var emissionBoxExtents: Vector3
    @JvmName("emissionBoxExtentsProperty")
    get() = getEmissionBoxExtents()
    @JvmName("emissionBoxExtentsProperty")
    set(`value`) {
      setEmissionBoxExtents(value)
    }

  /**
   * Particles will be emitted at positions determined by sampling this texture at a random
   * position. Used with [EMISSION_SHAPE_POINTS] and [EMISSION_SHAPE_DIRECTED_POINTS]. Can be created
   * automatically from mesh or node by selecting "Create Emission Points from Mesh/Node" under the
   * "Particles" tool in the toolbar.
   */
  public final inline var emissionPointTexture: Texture2D?
    @JvmName("emissionPointTextureProperty")
    get() = getEmissionPointTexture()
    @JvmName("emissionPointTextureProperty")
    set(`value`) {
      setEmissionPointTexture(value)
    }

  /**
   * Particle velocity and rotation will be set by sampling this texture at the same point as the
   * [emissionPointTexture]. Used only in [EMISSION_SHAPE_DIRECTED_POINTS]. Can be created
   * automatically from mesh or node by selecting "Create Emission Points from Mesh/Node" under the
   * "Particles" tool in the toolbar.
   */
  public final inline var emissionNormalTexture: Texture2D?
    @JvmName("emissionNormalTextureProperty")
    get() = getEmissionNormalTexture()
    @JvmName("emissionNormalTextureProperty")
    set(`value`) {
      setEmissionNormalTexture(value)
    }

  /**
   * Particle color will be modulated by color determined by sampling this texture at the same point
   * as the [emissionPointTexture].
   *
   * **Note:** [emissionColorTexture] multiplies the particle mesh's vertex colors. To have a
   * visible effect on a [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`.
   * For a [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()`
   * function. Otherwise, [emissionColorTexture] will have no visible effect.
   */
  public final inline var emissionColorTexture: Texture2D?
    @JvmName("emissionColorTextureProperty")
    get() = getEmissionColorTexture()
    @JvmName("emissionColorTextureProperty")
    set(`value`) {
      setEmissionColorTexture(value)
    }

  /**
   * The number of emission points if [emissionShape] is set to [EMISSION_SHAPE_POINTS] or
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   */
  public final inline var emissionPointCount: Int
    @JvmName("emissionPointCountProperty")
    get() = getEmissionPointCount()
    @JvmName("emissionPointCountProperty")
    set(`value`) {
      setEmissionPointCount(value)
    }

  /**
   * The axis of the ring when using the emitter [EMISSION_SHAPE_RING].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var emissionRingAxis: Vector3
    @JvmName("emissionRingAxisProperty")
    get() = getEmissionRingAxis()
    @JvmName("emissionRingAxisProperty")
    set(`value`) {
      setEmissionRingAxis(value)
    }

  /**
   * The height of the ring when using the emitter [EMISSION_SHAPE_RING].
   */
  public final inline var emissionRingHeight: Float
    @JvmName("emissionRingHeightProperty")
    get() = getEmissionRingHeight()
    @JvmName("emissionRingHeightProperty")
    set(`value`) {
      setEmissionRingHeight(value)
    }

  /**
   * The radius of the ring when using the emitter [EMISSION_SHAPE_RING].
   */
  public final inline var emissionRingRadius: Float
    @JvmName("emissionRingRadiusProperty")
    get() = getEmissionRingRadius()
    @JvmName("emissionRingRadiusProperty")
    set(`value`) {
      setEmissionRingRadius(value)
    }

  /**
   * The inner radius of the ring when using the emitter [EMISSION_SHAPE_RING].
   */
  public final inline var emissionRingInnerRadius: Float
    @JvmName("emissionRingInnerRadiusProperty")
    get() = getEmissionRingInnerRadius()
    @JvmName("emissionRingInnerRadiusProperty")
    set(`value`) {
      setEmissionRingInnerRadius(value)
    }

  /**
   * The angle of the cone when using the emitter [EMISSION_SHAPE_RING]. The default angle of 90
   * degrees results in a ring, while an angle of 0 degrees results in a cone. Intermediate values will
   * result in a ring where one end is larger than the other.
   *
   * **Note:** Depending on [emissionRingHeight], the angle may be clamped if the ring's end is
   * reached to form a perfect cone.
   */
  public final inline var emissionRingConeAngle: Float
    @JvmName("emissionRingConeAngleProperty")
    get() = getEmissionRingConeAngle()
    @JvmName("emissionRingConeAngleProperty")
    set(`value`) {
      setEmissionRingConeAngle(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var angle: Vector2
    @JvmName("angleProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.ANGLE)
    @JvmName("angleProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.ANGLE, value)
    }

  /**
   * Minimum equivalent of [angleMax].
   */
  public final inline var angleMin: Float
    @JvmName("angleMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.ANGLE)
    @JvmName("angleMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.ANGLE, value)
    }

  /**
   * Maximum initial rotation applied to each particle, in degrees.
   *
   * Only applied when [particleFlagDisableZ] or [particleFlagRotateY] are `true` or the
   * [BaseMaterial3D] being used to draw the particle is using [BaseMaterial3D.BILLBOARD_PARTICLES].
   */
  public final inline var angleMax: Float
    @JvmName("angleMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.ANGLE)
    @JvmName("angleMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.ANGLE, value)
    }

  /**
   * Each particle's rotation will be animated along this [CurveTexture].
   */
  public final inline var angleCurve: Texture2D?
    @JvmName("angleCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.ANGLE)
    @JvmName("angleCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.ANGLE, value)
    }

  /**
   * Enable the usage of [rotation3dMin] and [rotation3dMax].
   */
  public final inline var useRotation3d: Boolean
    @JvmName("useRotation3dProperty")
    get() = isUsingRotation3d()
    @JvmName("useRotation3dProperty")
    set(`value`) {
      setUseRotation3d(value)
    }

  /**
   * The minimum 3D orientation, in degrees. Works only in 3D and if [useRotation3d] is enabled.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rotation3dMin: Vector3
    @JvmName("rotation3dMinProperty")
    get() = getRotation3dMin()
    @JvmName("rotation3dMinProperty")
    set(`value`) {
      setRotation3dMin(value)
    }

  /**
   * The maximum 3D orientation, in degrees. Works only in 3D and if [useRotation3d] is enabled.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rotation3dMax: Vector3
    @JvmName("rotation3dMaxProperty")
    get() = getRotation3dMax()
    @JvmName("rotation3dMaxProperty")
    set(`value`) {
      setRotation3dMax(value)
    }

  /**
   * Percentage of the velocity of the respective [GPUParticles2D] or [GPUParticles3D] inherited by
   * each particle when spawning.
   */
  public final inline var inheritVelocityRatio: Double
    @JvmName("inheritVelocityRatioProperty")
    get() = getInheritVelocityRatio()
    @JvmName("inheritVelocityRatioProperty")
    set(`value`) {
      setInheritVelocityRatio(value)
    }

  /**
   * A pivot point used to calculate radial and orbital velocity of particles.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var velocityPivot: Vector3
    @JvmName("velocityPivotProperty")
    get() = getVelocityPivot()
    @JvmName("velocityPivotProperty")
    set(`value`) {
      setVelocityPivot(value)
    }

  /**
   * Unit vector specifying the particles' emission direction.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var direction: Vector3
    @JvmName("directionProperty")
    get() = getDirection()
    @JvmName("directionProperty")
    set(`value`) {
      setDirection(value)
    }

  /**
   * Each particle's initial direction range from `+spread` to `-spread` degrees.
   */
  public final inline var spread: Float
    @JvmName("spreadProperty")
    get() = getSpread()
    @JvmName("spreadProperty")
    set(`value`) {
      setSpread(value)
    }

  /**
   * Amount of [spread] along the Y axis.
   */
  public final inline var flatness: Float
    @JvmName("flatnessProperty")
    get() = getFlatness()
    @JvmName("flatnessProperty")
    set(`value`) {
      setFlatness(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var initialVelocity: Vector2
    @JvmName("initialVelocityProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.INITIAL_LINEAR_VELOCITY)
    @JvmName("initialVelocityProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.INITIAL_LINEAR_VELOCITY, value)
    }

  /**
   * Minimum equivalent of [initialVelocityMax].
   */
  public final inline var initialVelocityMin: Float
    @JvmName("initialVelocityMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.INITIAL_LINEAR_VELOCITY)
    @JvmName("initialVelocityMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.INITIAL_LINEAR_VELOCITY, value)
    }

  /**
   * Maximum initial velocity magnitude for each particle. Direction comes from [direction] and
   * [spread].
   */
  public final inline var initialVelocityMax: Float
    @JvmName("initialVelocityMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.INITIAL_LINEAR_VELOCITY)
    @JvmName("initialVelocityMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.INITIAL_LINEAR_VELOCITY, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var angularVelocity: Vector2
    @JvmName("angularVelocityProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Minimum equivalent of [angularVelocityMax].
   */
  public final inline var angularVelocityMin: Float
    @JvmName("angularVelocityMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Maximum initial angular velocity (rotation speed) applied to each particle in *degrees* per
   * second.
   *
   * Only applied when [particleFlagDisableZ] or [particleFlagRotateY] are `true` or the
   * [BaseMaterial3D] being used to draw the particle is using [BaseMaterial3D.BILLBOARD_PARTICLES].
   */
  public final inline var angularVelocityMax: Float
    @JvmName("angularVelocityMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Each particle's angular velocity (rotation speed) will vary along this [CurveTexture] over its
   * lifetime.
   */
  public final inline var angularVelocityCurve: Texture2D?
    @JvmName("angularVelocityCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var directionalVelocity: Vector2
    @JvmName("directionalVelocityProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.DIRECTIONAL_VELOCITY)
    @JvmName("directionalVelocityProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.DIRECTIONAL_VELOCITY, value)
    }

  /**
   * Minimum directional velocity value, which is multiplied by [directionalVelocityCurve].
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var directionalVelocityMin: Float
    @JvmName("directionalVelocityMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.DIRECTIONAL_VELOCITY)
    @JvmName("directionalVelocityMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.DIRECTIONAL_VELOCITY, value)
    }

  /**
   * Maximum directional velocity value, which is multiplied by [directionalVelocityCurve].
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var directionalVelocityMax: Float
    @JvmName("directionalVelocityMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.DIRECTIONAL_VELOCITY)
    @JvmName("directionalVelocityMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.DIRECTIONAL_VELOCITY, value)
    }

  /**
   * A curve that specifies the velocity along each of the axes of the particle system along its
   * lifetime.
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var directionalVelocityCurve: Texture2D?
    @JvmName("directionalVelocityCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.DIRECTIONAL_VELOCITY)
    @JvmName("directionalVelocityCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.DIRECTIONAL_VELOCITY, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var orbitVelocity: Vector2
    @JvmName("orbitVelocityProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Minimum equivalent of [orbitVelocityMax].
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var orbitVelocityMin: Float
    @JvmName("orbitVelocityMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Maximum orbital velocity applied to each particle. Makes the particles circle around origin.
   * Specified in number of full rotations around origin per second.
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var orbitVelocityMax: Float
    @JvmName("orbitVelocityMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Each particle's orbital velocity will vary along this [CurveTexture].
   *
   * **Note:** For 3D orbital velocity, use a [CurveXYZTexture].
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var orbitVelocityCurve: Texture2D?
    @JvmName("orbitVelocityCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var radialVelocity: Vector2
    @JvmName("radialVelocityProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.RADIAL_VELOCITY)
    @JvmName("radialVelocityProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.RADIAL_VELOCITY, value)
    }

  /**
   * Minimum radial velocity applied to each particle. Makes particles move away from the
   * [velocityPivot], or toward it if negative.
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var radialVelocityMin: Float
    @JvmName("radialVelocityMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.RADIAL_VELOCITY)
    @JvmName("radialVelocityMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.RADIAL_VELOCITY, value)
    }

  /**
   * Maximum radial velocity applied to each particle. Makes particles move away from the
   * [velocityPivot], or toward it if negative.
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var radialVelocityMax: Float
    @JvmName("radialVelocityMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.RADIAL_VELOCITY)
    @JvmName("radialVelocityMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.RADIAL_VELOCITY, value)
    }

  /**
   * A [CurveTexture] that defines the velocity over the particle's lifetime away (or toward) the
   * [velocityPivot].
   *
   * **Note:** Animated velocities will not be affected by damping, use [velocityLimitCurve]
   * instead.
   */
  public final inline var radialVelocityCurve: Texture2D?
    @JvmName("radialVelocityCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.RADIAL_VELOCITY)
    @JvmName("radialVelocityCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.RADIAL_VELOCITY, value)
    }

  /**
   * A [CurveTexture] that defines the maximum velocity of a particle during its lifetime.
   */
  public final inline var velocityLimitCurve: Texture2D?
    @JvmName("velocityLimitCurveProperty")
    get() = getVelocityLimitCurve()
    @JvmName("velocityLimitCurveProperty")
    set(`value`) {
      setVelocityLimitCurve(value)
    }

  /**
   * Enable 3D rotation velocity.
   */
  public final inline var useRotationVelocity3d: Boolean
    @JvmName("useRotationVelocity3dProperty")
    get() = isUsingRotationVelocity3d()
    @JvmName("useRotationVelocity3dProperty")
    set(`value`) {
      setUsingRotationVelocity3d(value)
    }

  /**
   * Minimum 3D rotation velocity on the particle's local axis. Enable [useRotationVelocity3d] to
   * use this.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rotationVelocity3dMin: Vector3
    @JvmName("rotationVelocity3dMinProperty")
    get() = getRotationVelocity3dMin()
    @JvmName("rotationVelocity3dMinProperty")
    set(`value`) {
      setRotationVelocity3dMin(value)
    }

  /**
   * Maximum 3D rotation velocity on the particle's local axis. Enable [useRotationVelocity3d] to
   * use this.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rotationVelocity3dMax: Vector3
    @JvmName("rotationVelocity3dMaxProperty")
    get() = getRotationVelocity3dMax()
    @JvmName("rotationVelocity3dMaxProperty")
    set(`value`) {
      setRotationVelocity3dMax(value)
    }

  /**
   * Rotation velocity curve over lifetime, per-axis. Enable [useRotationVelocity3d] to use this.
   */
  public final inline var rotationVelocity3dCurve: Texture2D?
    @JvmName("rotationVelocity3dCurveProperty")
    get() = getRotationVelocity3dCurve()
    @JvmName("rotationVelocity3dCurveProperty")
    set(`value`) {
      setRotationVelocity3dCurve(value)
    }

  /**
   * Gravity applied to every particle.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var gravity: Vector3
    @JvmName("gravityProperty")
    get() = getGravity()
    @JvmName("gravityProperty")
    set(`value`) {
      setGravity(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var linearAccel: Vector2
    @JvmName("linearAccelProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Minimum equivalent of [linearAccelMax].
   */
  public final inline var linearAccelMin: Float
    @JvmName("linearAccelMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Maximum linear acceleration applied to each particle in the direction of motion.
   */
  public final inline var linearAccelMax: Float
    @JvmName("linearAccelMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Each particle's linear acceleration will vary along this [CurveTexture].
   */
  public final inline var linearAccelCurve: Texture2D?
    @JvmName("linearAccelCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.LINEAR_ACCEL, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var radialAccel: Vector2
    @JvmName("radialAccelProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Minimum equivalent of [radialAccelMax].
   */
  public final inline var radialAccelMin: Float
    @JvmName("radialAccelMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Maximum radial acceleration applied to each particle. Makes particle accelerate away from the
   * origin or towards it if negative.
   */
  public final inline var radialAccelMax: Float
    @JvmName("radialAccelMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Each particle's radial acceleration will vary along this [CurveTexture].
   */
  public final inline var radialAccelCurve: Texture2D?
    @JvmName("radialAccelCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.RADIAL_ACCEL, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tangentialAccel: Vector2
    @JvmName("tangentialAccelProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Minimum equivalent of [tangentialAccelMax].
   */
  public final inline var tangentialAccelMin: Float
    @JvmName("tangentialAccelMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Maximum tangential acceleration applied to each particle. Tangential acceleration is
   * perpendicular to the particle's velocity giving the particles a swirling motion.
   */
  public final inline var tangentialAccelMax: Float
    @JvmName("tangentialAccelMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Each particle's tangential acceleration will vary along this [CurveTexture].
   */
  public final inline var tangentialAccelCurve: Texture2D?
    @JvmName("tangentialAccelCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var damping: Vector2
    @JvmName("dampingProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.DAMPING)
    @JvmName("dampingProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.DAMPING, value)
    }

  /**
   * Minimum equivalent of [dampingMax].
   */
  public final inline var dampingMin: Float
    @JvmName("dampingMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.DAMPING)
    @JvmName("dampingMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.DAMPING, value)
    }

  /**
   * The maximum rate at which particles lose velocity. For example value of `100` means that the
   * particle will go from `100` velocity to `0` in `1` second.
   */
  public final inline var dampingMax: Float
    @JvmName("dampingMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.DAMPING)
    @JvmName("dampingMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.DAMPING, value)
    }

  /**
   * Damping will vary along this [CurveTexture].
   */
  public final inline var dampingCurve: Texture2D?
    @JvmName("dampingCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.DAMPING)
    @JvmName("dampingCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.DAMPING, value)
    }

  /**
   * If `true`, interaction with particle attractors is enabled. In 3D, attraction only occurs
   * within the area defined by the [GPUParticles3D] node's [GPUParticles3D.visibilityAabb].
   */
  public final inline var attractorInteractionEnabled: Boolean
    @JvmName("attractorInteractionEnabledProperty")
    get() = isAttractorInteractionEnabled()
    @JvmName("attractorInteractionEnabledProperty")
    set(`value`) {
      setAttractorInteractionEnabled(value)
    }

  /**
   * Enable the usage of [scale3dMin] and [scale3dMax].
   */
  public final inline var useScale3d: Boolean
    @JvmName("useScale3dProperty")
    get() = isUsingScale3d()
    @JvmName("useScale3dProperty")
    set(`value`) {
      setUseScale3d(value)
    }

  /**
   * The minimum value of the random scale vector for each particle.
   *
   * Works only if [useScale3d] is enabled.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scale3dMin: Vector3
    @JvmName("scale3dMinProperty")
    get() = getScale3dMin()
    @JvmName("scale3dMinProperty")
    set(`value`) {
      setScale3dMin(value)
    }

  /**
   * The maximum value of the random scale vector for each particle.
   *
   * Works only if [useScale3d] is enabled.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scale3dMax: Vector3
    @JvmName("scale3dMaxProperty")
    get() = getScale3dMax()
    @JvmName("scale3dMaxProperty")
    set(`value`) {
      setScale3dMax(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scale: Vector2
    @JvmName("scaleProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.SCALE)
    @JvmName("scaleProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.SCALE, value)
    }

  /**
   * Minimum equivalent of [scaleMax].
   */
  public final inline var scaleMin: Float
    @JvmName("scaleMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.SCALE)
    @JvmName("scaleMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.SCALE, value)
    }

  /**
   * Maximum initial scale applied to each particle.
   */
  public final inline var scaleMax: Float
    @JvmName("scaleMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.SCALE)
    @JvmName("scaleMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.SCALE, value)
    }

  /**
   * Each particle's scale will vary along this [CurveTexture] over its lifetime. If a
   * [CurveXYZTexture] is supplied instead, the scale will be separated per-axis.
   */
  public final inline var scaleCurve: Texture2D?
    @JvmName("scaleCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.SCALE)
    @JvmName("scaleCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.SCALE, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scaleOverVelocity: Vector2
    @JvmName("scaleOverVelocityProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.SCALE_OVER_VELOCITY)
    @JvmName("scaleOverVelocityProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.SCALE_OVER_VELOCITY, value)
    }

  /**
   * Minimum velocity value reference for [scaleOverVelocityCurve].
   *
   * [scaleOverVelocityCurve] will be interpolated between [scaleOverVelocityMin] and
   * [scaleOverVelocityMax].
   */
  public final inline var scaleOverVelocityMin: Float
    @JvmName("scaleOverVelocityMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.SCALE_OVER_VELOCITY)
    @JvmName("scaleOverVelocityMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.SCALE_OVER_VELOCITY, value)
    }

  /**
   * Maximum velocity value reference for [scaleOverVelocityCurve].
   *
   * [scaleOverVelocityCurve] will be interpolated between [scaleOverVelocityMin] and
   * [scaleOverVelocityMax].
   */
  public final inline var scaleOverVelocityMax: Float
    @JvmName("scaleOverVelocityMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.SCALE_OVER_VELOCITY)
    @JvmName("scaleOverVelocityMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.SCALE_OVER_VELOCITY, value)
    }

  /**
   * Either a [CurveTexture] or a [CurveXYZTexture] that scales each particle based on its velocity.
   */
  public final inline var scaleOverVelocityCurve: Texture2D?
    @JvmName("scaleOverVelocityCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.SCALE_OVER_VELOCITY)
    @JvmName("scaleOverVelocityCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.SCALE_OVER_VELOCITY, value)
    }

  /**
   * Each particle's initial color. If the [GPUParticles2D]'s `texture` is defined, it will be
   * multiplied by this color.
   *
   * **Note:** [color] multiplies the particle mesh's vertex colors. To have a visible effect on a
   * [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [color] will have no visible effect.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var color: Color
    @JvmName("colorProperty")
    get() = getColor()
    @JvmName("colorProperty")
    set(`value`) {
      setColor(value)
    }

  /**
   * Each particle's color will vary along this [GradientTexture1D] over its lifetime (multiplied
   * with [color]).
   *
   * **Note:** [colorRamp] multiplies the particle mesh's vertex colors. To have a visible effect on
   * a [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [colorRamp] will have no visible effect.
   */
  public final inline var colorRamp: Texture2D?
    @JvmName("colorRampProperty")
    get() = getColorRamp()
    @JvmName("colorRampProperty")
    set(`value`) {
      setColorRamp(value)
    }

  /**
   * Each particle's initial color will vary along this [GradientTexture1D] (multiplied with
   * [color]).
   *
   * **Note:** [colorInitialRamp] multiplies the particle mesh's vertex colors. To have a visible
   * effect on a [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [colorInitialRamp] will have no visible effect.
   */
  public final inline var colorInitialRamp: Texture2D?
    @JvmName("colorInitialRampProperty")
    get() = getColorInitialRamp()
    @JvmName("colorInitialRampProperty")
    set(`value`) {
      setColorInitialRamp(value)
    }

  /**
   * The alpha value of each particle's color will be multiplied by this [CurveTexture] over its
   * lifetime.
   *
   * **Note:** [alphaCurve] multiplies the particle mesh's vertex colors. To have a visible effect
   * on a [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALPHA *= COLOR.a;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [alphaCurve] will have no visible effect.
   */
  public final inline var alphaCurve: Texture2D?
    @JvmName("alphaCurveProperty")
    get() = getAlphaCurve()
    @JvmName("alphaCurveProperty")
    set(`value`) {
      setAlphaCurve(value)
    }

  /**
   * Each particle's color will be multiplied by this [CurveTexture] over its lifetime.
   *
   * **Note:** [emissionCurve] multiplies the particle mesh's vertex colors. To have a visible
   * effect on a [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [emissionCurve] will have no visible effect.
   */
  public final inline var emissionCurve: Texture2D?
    @JvmName("emissionCurveProperty")
    get() = getEmissionCurve()
    @JvmName("emissionCurveProperty")
    set(`value`) {
      setEmissionCurve(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var hueVariation: Vector2
    @JvmName("hueVariationProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.HUE_VARIATION)
    @JvmName("hueVariationProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.HUE_VARIATION, value)
    }

  /**
   * Minimum equivalent of [hueVariationMax].
   */
  public final inline var hueVariationMin: Float
    @JvmName("hueVariationMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.HUE_VARIATION)
    @JvmName("hueVariationMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.HUE_VARIATION, value)
    }

  /**
   * Maximum initial hue variation applied to each particle. It will shift the particle color's hue.
   */
  public final inline var hueVariationMax: Float
    @JvmName("hueVariationMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.HUE_VARIATION)
    @JvmName("hueVariationMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.HUE_VARIATION, value)
    }

  /**
   * Each particle's hue will vary along this [CurveTexture].
   */
  public final inline var hueVariationCurve: Texture2D?
    @JvmName("hueVariationCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.HUE_VARIATION)
    @JvmName("hueVariationCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.HUE_VARIATION, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var animSpeed: Vector2
    @JvmName("animSpeedProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.ANIM_SPEED)
    @JvmName("animSpeedProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.ANIM_SPEED, value)
    }

  /**
   * Minimum equivalent of [animSpeedMax].
   */
  public final inline var animSpeedMin: Float
    @JvmName("animSpeedMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.ANIM_SPEED)
    @JvmName("animSpeedMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.ANIM_SPEED, value)
    }

  /**
   * Maximum particle animation speed. Animation speed of `1` means that the particles will make
   * full `0` to `1` offset cycle during lifetime, `2` means `2` cycles etc.
   *
   * With animation speed greater than `1`, remember to enable
   * [CanvasItemMaterial.particlesAnimLoop] property if you want the animation to repeat.
   */
  public final inline var animSpeedMax: Float
    @JvmName("animSpeedMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.ANIM_SPEED)
    @JvmName("animSpeedMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.ANIM_SPEED, value)
    }

  /**
   * Each particle's animation speed will vary along this [CurveTexture].
   */
  public final inline var animSpeedCurve: Texture2D?
    @JvmName("animSpeedCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.ANIM_SPEED)
    @JvmName("animSpeedCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.ANIM_SPEED, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var animOffset: Vector2
    @JvmName("animOffsetProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.ANIM_OFFSET, value)
    }

  /**
   * Minimum equivalent of [animOffsetMax].
   */
  public final inline var animOffsetMin: Float
    @JvmName("animOffsetMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.ANIM_OFFSET, value)
    }

  /**
   * Maximum animation offset that corresponds to frame index in the texture. `0` is the first
   * frame, `1` is the last one. See [CanvasItemMaterial.particlesAnimation].
   */
  public final inline var animOffsetMax: Float
    @JvmName("animOffsetMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.ANIM_OFFSET, value)
    }

  /**
   * Each particle's animation offset will vary along this [CurveTexture].
   */
  public final inline var animOffsetCurve: Texture2D?
    @JvmName("animOffsetCurveProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetCurveProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.ANIM_OFFSET, value)
    }

  /**
   * If `true`, enables turbulence for the particle system. Turbulence can be used to vary particle
   * movement according to its position (based on a 3D noise pattern). In 3D,
   * [GPUParticlesAttractorVectorField3D] with [NoiseTexture3D] can be used as an alternative to
   * turbulence that works in world space and with multiple particle systems reacting in the same way.
   *
   * **Note:** Enabling turbulence has a high performance cost on the GPU. Only enable turbulence on
   * a few particle systems at once at most, and consider disabling it when targeting mobile/web
   * platforms.
   */
  public final inline var turbulenceEnabled: Boolean
    @JvmName("turbulenceEnabledProperty")
    get() = getTurbulenceEnabled()
    @JvmName("turbulenceEnabledProperty")
    set(`value`) {
      setTurbulenceEnabled(value)
    }

  /**
   * The turbulence noise strength. Increasing this will result in a stronger, more contrasting,
   * flow pattern.
   */
  public final inline var turbulenceNoiseStrength: Float
    @JvmName("turbulenceNoiseStrengthProperty")
    get() = getTurbulenceNoiseStrength()
    @JvmName("turbulenceNoiseStrengthProperty")
    set(`value`) {
      setTurbulenceNoiseStrength(value)
    }

  /**
   * This value controls the overall scale/frequency of the turbulence noise pattern.
   *
   * A small scale will result in smaller features with more detail while a high scale will result
   * in smoother noise with larger features.
   */
  public final inline var turbulenceNoiseScale: Float
    @JvmName("turbulenceNoiseScaleProperty")
    get() = getTurbulenceNoiseScale()
    @JvmName("turbulenceNoiseScaleProperty")
    set(`value`) {
      setTurbulenceNoiseScale(value)
    }

  /**
   * A scrolling velocity for the turbulence field. This sets a directional trend for the pattern to
   * move in over time.
   *
   * The default value of `Vector3(0, 0, 0)` turns off the scrolling.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var turbulenceNoiseSpeed: Vector3
    @JvmName("turbulenceNoiseSpeedProperty")
    get() = getTurbulenceNoiseSpeed()
    @JvmName("turbulenceNoiseSpeedProperty")
    set(`value`) {
      setTurbulenceNoiseSpeed(value)
    }

  /**
   * The in-place rate of change of the turbulence field. This defines how quickly the noise pattern
   * varies over time.
   *
   * A value of 0.0 will result in a fixed pattern.
   */
  public final inline var turbulenceNoiseSpeedRandom: Float
    @JvmName("turbulenceNoiseSpeedRandomProperty")
    get() = getTurbulenceNoiseSpeedRandom()
    @JvmName("turbulenceNoiseSpeedRandomProperty")
    set(`value`) {
      setTurbulenceNoiseSpeedRandom(value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var turbulenceInfluence: Vector2
    @JvmName("turbulenceInfluenceProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.TURB_VEL_INFLUENCE)
    @JvmName("turbulenceInfluenceProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.TURB_VEL_INFLUENCE, value)
    }

  /**
   * Minimum turbulence influence on each particle.
   *
   * The actual amount of turbulence influence on each particle is calculated as a random value
   * between [turbulenceInfluenceMin] and [turbulenceInfluenceMax] and multiplied by the amount of
   * turbulence influence from [turbulenceInfluenceOverLife].
   */
  public final inline var turbulenceInfluenceMin: Float
    @JvmName("turbulenceInfluenceMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.TURB_VEL_INFLUENCE)
    @JvmName("turbulenceInfluenceMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.TURB_VEL_INFLUENCE, value)
    }

  /**
   * Maximum turbulence influence on each particle.
   *
   * The actual amount of turbulence influence on each particle is calculated as a random value
   * between [turbulenceInfluenceMin] and [turbulenceInfluenceMax] and multiplied by the amount of
   * turbulence influence from [turbulenceInfluenceOverLife].
   */
  public final inline var turbulenceInfluenceMax: Float
    @JvmName("turbulenceInfluenceMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.TURB_VEL_INFLUENCE)
    @JvmName("turbulenceInfluenceMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.TURB_VEL_INFLUENCE, value)
    }

  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var turbulenceInitialDisplacement: Vector2
    @JvmName("turbulenceInitialDisplacementProperty")
    get() = getParam(ParticleProcessMaterial.Parameter.TURB_INIT_DISPLACEMENT)
    @JvmName("turbulenceInitialDisplacementProperty")
    set(`value`) {
      setParam(ParticleProcessMaterial.Parameter.TURB_INIT_DISPLACEMENT, value)
    }

  /**
   * Minimum displacement of each particle's spawn position by the turbulence.
   *
   * The actual amount of displacement will be a factor of the underlying turbulence multiplied by a
   * random value between [turbulenceInitialDisplacementMin] and [turbulenceInitialDisplacementMax].
   */
  public final inline var turbulenceInitialDisplacementMin: Float
    @JvmName("turbulenceInitialDisplacementMinProperty")
    get() = getParamMin(ParticleProcessMaterial.Parameter.TURB_INIT_DISPLACEMENT)
    @JvmName("turbulenceInitialDisplacementMinProperty")
    set(`value`) {
      setParamMin(ParticleProcessMaterial.Parameter.TURB_INIT_DISPLACEMENT, value)
    }

  /**
   * Maximum displacement of each particle's spawn position by the turbulence.
   *
   * The actual amount of displacement will be a factor of the underlying turbulence multiplied by a
   * random value between [turbulenceInitialDisplacementMin] and [turbulenceInitialDisplacementMax].
   */
  public final inline var turbulenceInitialDisplacementMax: Float
    @JvmName("turbulenceInitialDisplacementMaxProperty")
    get() = getParamMax(ParticleProcessMaterial.Parameter.TURB_INIT_DISPLACEMENT)
    @JvmName("turbulenceInitialDisplacementMaxProperty")
    set(`value`) {
      setParamMax(ParticleProcessMaterial.Parameter.TURB_INIT_DISPLACEMENT, value)
    }

  /**
   * Each particle's amount of turbulence will be influenced along this [CurveTexture] over its life
   * time.
   */
  public final inline var turbulenceInfluenceOverLife: Texture2D?
    @JvmName("turbulenceInfluenceOverLifeProperty")
    get() = getParamTexture(ParticleProcessMaterial.Parameter.TURB_INFLUENCE_OVER_LIFE)
    @JvmName("turbulenceInfluenceOverLifeProperty")
    set(`value`) {
      setParamTexture(ParticleProcessMaterial.Parameter.TURB_INFLUENCE_OVER_LIFE, value)
    }

  /**
   * The particles' collision mode.
   *
   * **Note:** 3D Particles can only collide with [GPUParticlesCollision3D] nodes, not
   * [PhysicsBody3D] nodes. To make particles collide with various objects, you can add
   * [GPUParticlesCollision3D] nodes as children of [PhysicsBody3D] nodes. In 3D, collisions only occur
   * within the area defined by the [GPUParticles3D] node's [GPUParticles3D.visibilityAabb].
   *
   * **Note:** 2D Particles can only collide with [LightOccluder2D] nodes, not [PhysicsBody2D]
   * nodes.
   */
  public final inline var collisionMode: CollisionMode
    @JvmName("collisionModeProperty")
    get() = getCollisionMode()
    @JvmName("collisionModeProperty")
    set(`value`) {
      setCollisionMode(value)
    }

  /**
   * The particles' friction. Values range from `0` (frictionless) to `1` (maximum friction). Only
   * effective if [collisionMode] is [COLLISION_RIGID].
   */
  public final inline var collisionFriction: Float
    @JvmName("collisionFrictionProperty")
    get() = getCollisionFriction()
    @JvmName("collisionFrictionProperty")
    set(`value`) {
      setCollisionFriction(value)
    }

  /**
   * The particles' bounciness. Values range from `0` (no bounce) to `1` (full bounciness). Only
   * effective if [collisionMode] is [COLLISION_RIGID].
   */
  public final inline var collisionBounce: Float
    @JvmName("collisionBounceProperty")
    get() = getCollisionBounce()
    @JvmName("collisionBounceProperty")
    set(`value`) {
      setCollisionBounce(value)
    }

  /**
   * If `true`, [GPUParticles3D.collisionBaseSize] is multiplied by the particle's effective scale
   * (see [scaleMin], [scaleMax], [scaleCurve], and [scaleOverVelocityCurve]).
   */
  public final inline var collisionUseScale: Boolean
    @JvmName("collisionUseScaleProperty")
    get() = isCollisionUsingScale()
    @JvmName("collisionUseScaleProperty")
    set(`value`) {
      setCollisionUseScale(value)
    }

  /**
   * The particle subemitter mode (see [GPUParticles2D.subEmitter] and [GPUParticles3D.subEmitter]).
   */
  public final inline var subEmitterMode: SubEmitterMode
    @JvmName("subEmitterModeProperty")
    get() = getSubEmitterMode()
    @JvmName("subEmitterModeProperty")
    set(`value`) {
      setSubEmitterMode(value)
    }

  /**
   * The frequency at which particles should be emitted from the subemitter node. One particle will
   * be spawned every [subEmitterFrequency] seconds.
   *
   * **Note:** This value shouldn't exceed [GPUParticles2D.amount] or [GPUParticles3D.amount]
   * defined on the *subemitter node* (not the main node), relative to the subemitter's particle
   * lifetime. If the number of particles is exceeded, no new particles will spawn from the subemitter
   * until enough particles have expired.
   */
  public final inline var subEmitterFrequency: Double
    @JvmName("subEmitterFrequencyProperty")
    get() = getSubEmitterFrequency()
    @JvmName("subEmitterFrequencyProperty")
    set(`value`) {
      setSubEmitterFrequency(value)
    }

  /**
   * The amount of particles to spawn from the subemitter node when the particle expires.
   *
   * **Note:** This value shouldn't exceed [GPUParticles2D.amount] or [GPUParticles3D.amount]
   * defined on the *subemitter node* (not the main node), relative to the subemitter's particle
   * lifetime. If the number of particles is exceeded, no new particles will spawn from the subemitter
   * until enough particles have expired.
   */
  public final inline var subEmitterAmountAtEnd: Int
    @JvmName("subEmitterAmountAtEndProperty")
    get() = getSubEmitterAmountAtEnd()
    @JvmName("subEmitterAmountAtEndProperty")
    set(`value`) {
      setSubEmitterAmountAtEnd(value)
    }

  /**
   * The amount of particles to spawn from the subemitter node when a collision occurs. When
   * combined with [COLLISION_HIDE_ON_CONTACT] on the main particles material, this can be used to
   * achieve effects such as raindrops hitting the ground.
   *
   * **Note:** This value shouldn't exceed [GPUParticles2D.amount] or [GPUParticles3D.amount]
   * defined on the *subemitter node* (not the main node), relative to the subemitter's particle
   * lifetime. If the number of particles is exceeded, no new particles will spawn from the subemitter
   * until enough particles have expired.
   */
  public final inline var subEmitterAmountAtCollision: Int
    @JvmName("subEmitterAmountAtCollisionProperty")
    get() = getSubEmitterAmountAtCollision()
    @JvmName("subEmitterAmountAtCollisionProperty")
    set(`value`) {
      setSubEmitterAmountAtCollision(value)
    }

  /**
   * The amount of particles to spawn from the subemitter node when the particle spawns.
   *
   * **Note:** This value shouldn't exceed [GPUParticles2D.amount] or [GPUParticles3D.amount]
   * defined on the *subemitter node* (not the main node), relative to the subemitter's particle
   * lifetime. If the number of particles is exceeded, no new particles will spawn from the subemitter
   * until enough particles have expired.
   */
  public final inline var subEmitterAmountAtStart: Int
    @JvmName("subEmitterAmountAtStartProperty")
    get() = getSubEmitterAmountAtStart()
    @JvmName("subEmitterAmountAtStartProperty")
    set(`value`) {
      setSubEmitterAmountAtStart(value)
    }

  /**
   * If `true`, the subemitter inherits the parent particle's velocity when it spawns.
   */
  public final inline var subEmitterKeepVelocity: Boolean
    @JvmName("subEmitterKeepVelocityProperty")
    get() = getSubEmitterKeepVelocity()
    @JvmName("subEmitterKeepVelocityProperty")
    set(`value`) {
      setSubEmitterKeepVelocity(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(514, scriptPtr)
  }

  /**
   * This is a helper function for [emissionShapeOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.emissionShapeOffset
   * //Your changes
   * particleprocessmaterial.emissionShapeOffset = myCoreType
   * ``````
   *
   * The offset for the [emissionShape], in local space.
   */
  @CoreTypeHelper
  public final fun emissionShapeOffsetMutate(block: Vector3.() -> Unit): Vector3 =
      emissionShapeOffset.apply {
     block(this)
     emissionShapeOffset = this
  }

  /**
   * This is a helper function for [emissionShapeScale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.emissionShapeScale
   * //Your changes
   * particleprocessmaterial.emissionShapeScale = myCoreType
   * ``````
   *
   * The scale of the [emissionShape], in local space.
   */
  @CoreTypeHelper
  public final fun emissionShapeScaleMutate(block: Vector3.() -> Unit): Vector3 =
      emissionShapeScale.apply {
     block(this)
     emissionShapeScale = this
  }

  /**
   * This is a helper function for [emissionBoxExtents] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.emissionBoxExtents
   * //Your changes
   * particleprocessmaterial.emissionBoxExtents = myCoreType
   * ``````
   *
   * The box's extents if [emissionShape] is set to [EMISSION_SHAPE_BOX].
   *
   * **Note:** [emissionBoxExtents] starts from the center point and applies the X, Y, and Z values
   * in both directions. The size is twice the area of the extents.
   */
  @CoreTypeHelper
  public final fun emissionBoxExtentsMutate(block: Vector3.() -> Unit): Vector3 =
      emissionBoxExtents.apply {
     block(this)
     emissionBoxExtents = this
  }

  /**
   * This is a helper function for [emissionRingAxis] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.emissionRingAxis
   * //Your changes
   * particleprocessmaterial.emissionRingAxis = myCoreType
   * ``````
   *
   * The axis of the ring when using the emitter [EMISSION_SHAPE_RING].
   */
  @CoreTypeHelper
  public final fun emissionRingAxisMutate(block: Vector3.() -> Unit): Vector3 =
      emissionRingAxis.apply {
     block(this)
     emissionRingAxis = this
  }

  /**
   * This is a helper function for [angle] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.angle
   * //Your changes
   * particleprocessmaterial.angle = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun angleMutate(block: Vector2.() -> Unit): Vector2 = angle.apply {
     block(this)
     angle = this
  }

  /**
   * This is a helper function for [rotation3dMin] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.rotation3dMin
   * //Your changes
   * particleprocessmaterial.rotation3dMin = myCoreType
   * ``````
   *
   * The minimum 3D orientation, in degrees. Works only in 3D and if [useRotation3d] is enabled.
   */
  @CoreTypeHelper
  public final fun rotation3dMinMutate(block: Vector3.() -> Unit): Vector3 = rotation3dMin.apply {
     block(this)
     rotation3dMin = this
  }

  /**
   * This is a helper function for [rotation3dMax] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.rotation3dMax
   * //Your changes
   * particleprocessmaterial.rotation3dMax = myCoreType
   * ``````
   *
   * The maximum 3D orientation, in degrees. Works only in 3D and if [useRotation3d] is enabled.
   */
  @CoreTypeHelper
  public final fun rotation3dMaxMutate(block: Vector3.() -> Unit): Vector3 = rotation3dMax.apply {
     block(this)
     rotation3dMax = this
  }

  /**
   * This is a helper function for [velocityPivot] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.velocityPivot
   * //Your changes
   * particleprocessmaterial.velocityPivot = myCoreType
   * ``````
   *
   * A pivot point used to calculate radial and orbital velocity of particles.
   */
  @CoreTypeHelper
  public final fun velocityPivotMutate(block: Vector3.() -> Unit): Vector3 = velocityPivot.apply {
     block(this)
     velocityPivot = this
  }

  /**
   * This is a helper function for [direction] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.direction
   * //Your changes
   * particleprocessmaterial.direction = myCoreType
   * ``````
   *
   * Unit vector specifying the particles' emission direction.
   */
  @CoreTypeHelper
  public final fun directionMutate(block: Vector3.() -> Unit): Vector3 = direction.apply {
     block(this)
     direction = this
  }

  /**
   * This is a helper function for [initialVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.initialVelocity
   * //Your changes
   * particleprocessmaterial.initialVelocity = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun initialVelocityMutate(block: Vector2.() -> Unit): Vector2 =
      initialVelocity.apply {
     block(this)
     initialVelocity = this
  }

  /**
   * This is a helper function for [angularVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.angularVelocity
   * //Your changes
   * particleprocessmaterial.angularVelocity = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun angularVelocityMutate(block: Vector2.() -> Unit): Vector2 =
      angularVelocity.apply {
     block(this)
     angularVelocity = this
  }

  /**
   * This is a helper function for [directionalVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.directionalVelocity
   * //Your changes
   * particleprocessmaterial.directionalVelocity = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun directionalVelocityMutate(block: Vector2.() -> Unit): Vector2 =
      directionalVelocity.apply {
     block(this)
     directionalVelocity = this
  }

  /**
   * This is a helper function for [orbitVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.orbitVelocity
   * //Your changes
   * particleprocessmaterial.orbitVelocity = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun orbitVelocityMutate(block: Vector2.() -> Unit): Vector2 = orbitVelocity.apply {
     block(this)
     orbitVelocity = this
  }

  /**
   * This is a helper function for [radialVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.radialVelocity
   * //Your changes
   * particleprocessmaterial.radialVelocity = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun radialVelocityMutate(block: Vector2.() -> Unit): Vector2 = radialVelocity.apply {
     block(this)
     radialVelocity = this
  }

  /**
   * This is a helper function for [rotationVelocity3dMin] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.rotationVelocity3dMin
   * //Your changes
   * particleprocessmaterial.rotationVelocity3dMin = myCoreType
   * ``````
   *
   * Minimum 3D rotation velocity on the particle's local axis. Enable [useRotationVelocity3d] to
   * use this.
   */
  @CoreTypeHelper
  public final fun rotationVelocity3dMinMutate(block: Vector3.() -> Unit): Vector3 =
      rotationVelocity3dMin.apply {
     block(this)
     rotationVelocity3dMin = this
  }

  /**
   * This is a helper function for [rotationVelocity3dMax] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.rotationVelocity3dMax
   * //Your changes
   * particleprocessmaterial.rotationVelocity3dMax = myCoreType
   * ``````
   *
   * Maximum 3D rotation velocity on the particle's local axis. Enable [useRotationVelocity3d] to
   * use this.
   */
  @CoreTypeHelper
  public final fun rotationVelocity3dMaxMutate(block: Vector3.() -> Unit): Vector3 =
      rotationVelocity3dMax.apply {
     block(this)
     rotationVelocity3dMax = this
  }

  /**
   * This is a helper function for [gravity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.gravity
   * //Your changes
   * particleprocessmaterial.gravity = myCoreType
   * ``````
   *
   * Gravity applied to every particle.
   */
  @CoreTypeHelper
  public final fun gravityMutate(block: Vector3.() -> Unit): Vector3 = gravity.apply {
     block(this)
     gravity = this
  }

  /**
   * This is a helper function for [linearAccel] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.linearAccel
   * //Your changes
   * particleprocessmaterial.linearAccel = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun linearAccelMutate(block: Vector2.() -> Unit): Vector2 = linearAccel.apply {
     block(this)
     linearAccel = this
  }

  /**
   * This is a helper function for [radialAccel] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.radialAccel
   * //Your changes
   * particleprocessmaterial.radialAccel = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun radialAccelMutate(block: Vector2.() -> Unit): Vector2 = radialAccel.apply {
     block(this)
     radialAccel = this
  }

  /**
   * This is a helper function for [tangentialAccel] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.tangentialAccel
   * //Your changes
   * particleprocessmaterial.tangentialAccel = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun tangentialAccelMutate(block: Vector2.() -> Unit): Vector2 =
      tangentialAccel.apply {
     block(this)
     tangentialAccel = this
  }

  /**
   * This is a helper function for [damping] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.damping
   * //Your changes
   * particleprocessmaterial.damping = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun dampingMutate(block: Vector2.() -> Unit): Vector2 = damping.apply {
     block(this)
     damping = this
  }

  /**
   * This is a helper function for [scale3dMin] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.scale3dMin
   * //Your changes
   * particleprocessmaterial.scale3dMin = myCoreType
   * ``````
   *
   * The minimum value of the random scale vector for each particle.
   *
   * Works only if [useScale3d] is enabled.
   */
  @CoreTypeHelper
  public final fun scale3dMinMutate(block: Vector3.() -> Unit): Vector3 = scale3dMin.apply {
     block(this)
     scale3dMin = this
  }

  /**
   * This is a helper function for [scale3dMax] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.scale3dMax
   * //Your changes
   * particleprocessmaterial.scale3dMax = myCoreType
   * ``````
   *
   * The maximum value of the random scale vector for each particle.
   *
   * Works only if [useScale3d] is enabled.
   */
  @CoreTypeHelper
  public final fun scale3dMaxMutate(block: Vector3.() -> Unit): Vector3 = scale3dMax.apply {
     block(this)
     scale3dMax = this
  }

  /**
   * This is a helper function for [scale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.scale
   * //Your changes
   * particleprocessmaterial.scale = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun scaleMutate(block: Vector2.() -> Unit): Vector2 = scale.apply {
     block(this)
     scale = this
  }

  /**
   * This is a helper function for [scaleOverVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.scaleOverVelocity
   * //Your changes
   * particleprocessmaterial.scaleOverVelocity = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun scaleOverVelocityMutate(block: Vector2.() -> Unit): Vector2 =
      scaleOverVelocity.apply {
     block(this)
     scaleOverVelocity = this
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.color
   * //Your changes
   * particleprocessmaterial.color = myCoreType
   * ``````
   *
   * Each particle's initial color. If the [GPUParticles2D]'s `texture` is defined, it will be
   * multiplied by this color.
   *
   * **Note:** [color] multiplies the particle mesh's vertex colors. To have a visible effect on a
   * [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [color] will have no visible effect.
   */
  @CoreTypeHelper
  public final fun colorMutate(block: Color.() -> Unit): Color = color.apply {
     block(this)
     color = this
  }

  /**
   * This is a helper function for [hueVariation] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.hueVariation
   * //Your changes
   * particleprocessmaterial.hueVariation = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun hueVariationMutate(block: Vector2.() -> Unit): Vector2 = hueVariation.apply {
     block(this)
     hueVariation = this
  }

  /**
   * This is a helper function for [animSpeed] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.animSpeed
   * //Your changes
   * particleprocessmaterial.animSpeed = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun animSpeedMutate(block: Vector2.() -> Unit): Vector2 = animSpeed.apply {
     block(this)
     animSpeed = this
  }

  /**
   * This is a helper function for [animOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.animOffset
   * //Your changes
   * particleprocessmaterial.animOffset = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun animOffsetMutate(block: Vector2.() -> Unit): Vector2 = animOffset.apply {
     block(this)
     animOffset = this
  }

  /**
   * This is a helper function for [turbulenceNoiseSpeed] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.turbulenceNoiseSpeed
   * //Your changes
   * particleprocessmaterial.turbulenceNoiseSpeed = myCoreType
   * ``````
   *
   * A scrolling velocity for the turbulence field. This sets a directional trend for the pattern to
   * move in over time.
   *
   * The default value of `Vector3(0, 0, 0)` turns off the scrolling.
   */
  @CoreTypeHelper
  public final fun turbulenceNoiseSpeedMutate(block: Vector3.() -> Unit): Vector3 =
      turbulenceNoiseSpeed.apply {
     block(this)
     turbulenceNoiseSpeed = this
  }

  /**
   * This is a helper function for [turbulenceInfluence] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.turbulenceInfluence
   * //Your changes
   * particleprocessmaterial.turbulenceInfluence = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun turbulenceInfluenceMutate(block: Vector2.() -> Unit): Vector2 =
      turbulenceInfluence.apply {
     block(this)
     turbulenceInfluence = this
  }

  /**
   * This is a helper function for [turbulenceInitialDisplacement] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = particleprocessmaterial.turbulenceInitialDisplacement
   * //Your changes
   * particleprocessmaterial.turbulenceInitialDisplacement = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun turbulenceInitialDisplacementMutate(block: Vector2.() -> Unit): Vector2 =
      turbulenceInitialDisplacement.apply {
     block(this)
     turbulenceInitialDisplacement = this
  }

  public final fun setDirection(degrees: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to degrees)
    TransferContext.callMethod(MethodBindings.setDirectionPtr)
  }

  public final fun getDirection(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDirectionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setInheritVelocityRatio(ratio: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio)
    TransferContext.callMethod(MethodBindings.setInheritVelocityRatioPtr)
  }

  public final fun getInheritVelocityRatio(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInheritVelocityRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setSpread(degrees: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to degrees.toDouble())
    TransferContext.callMethod(MethodBindings.setSpreadPtr)
  }

  public final fun getSpread(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpreadPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFlatness(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setFlatnessPtr)
  }

  public final fun getFlatness(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFlatnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the minimum and maximum values of the given [param].
   *
   * The `x` component of the argument vector corresponds to minimum and the `y` component
   * corresponds to maximum.
   */
  public final fun setParam(`param`: Parameter, `value`: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value, VECTOR2 to value)
    TransferContext.callMethod(MethodBindings.setParamPtr)
  }

  /**
   * Returns the minimum and maximum values of the given [param] as a vector.
   *
   * The `x` component of the returned vector corresponds to minimum and the `y` component
   * corresponds to maximum.
   */
  public final fun getParam(`param`: Parameter): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value)
    TransferContext.callMethod(MethodBindings.getParamPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets the minimum value range for the given parameter.
   */
  public final fun setParamMin(`param`: Parameter, `value`: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.setParamMinPtr)
  }

  /**
   * Returns the minimum value range for the given parameter.
   */
  public final fun getParamMin(`param`: Parameter): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value)
    TransferContext.callMethod(MethodBindings.getParamMinPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the maximum value range for the given parameter.
   */
  public final fun setParamMax(`param`: Parameter, `value`: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.setParamMaxPtr)
  }

  /**
   * Returns the maximum value range for the given parameter.
   */
  public final fun getParamMax(`param`: Parameter): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value)
    TransferContext.callMethod(MethodBindings.getParamMaxPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the [Texture2D] for the specified [Parameter].
   */
  public final fun setParamTexture(`param`: Parameter, texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setParamTexturePtr)
  }

  /**
   * Returns the [Texture2D] used by the specified parameter.
   */
  public final fun getParamTexture(`param`: Parameter): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value)
    TransferContext.callMethod(MethodBindings.getParamTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setColorPtr)
  }

  public final fun getColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setUseScale3d(usingScale3d: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to usingScale3d)
    TransferContext.callMethod(MethodBindings.setUseScale3dPtr)
  }

  public final fun isUsingScale3d(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingScale3dPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setScale3dMin(scale3dMin: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to scale3dMin)
    TransferContext.callMethod(MethodBindings.setScale3dMinPtr)
  }

  public final fun getScale3dMin(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScale3dMinPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setScale3dMax(scale3dMax: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to scale3dMax)
    TransferContext.callMethod(MethodBindings.setScale3dMaxPtr)
  }

  public final fun getScale3dMax(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScale3dMaxPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setUseRotation3d(usingRotation3d: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to usingRotation3d)
    TransferContext.callMethod(MethodBindings.setUseRotation3dPtr)
  }

  public final fun isUsingRotation3d(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingRotation3dPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRotation3dMin(rotation3dMin: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to rotation3dMin)
    TransferContext.callMethod(MethodBindings.setRotation3dMinPtr)
  }

  public final fun getRotation3dMin(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotation3dMinPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setRotation3dMax(rotation3dMax: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to rotation3dMax)
    TransferContext.callMethod(MethodBindings.setRotation3dMaxPtr)
  }

  public final fun getRotation3dMax(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotation3dMaxPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setColorRamp(ramp: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to ramp)
    TransferContext.callMethod(MethodBindings.setColorRampPtr)
  }

  public final fun getColorRamp(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorRampPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setAlphaCurve(curve: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setAlphaCurvePtr)
  }

  public final fun getAlphaCurve(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAlphaCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setEmissionCurve(curve: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setEmissionCurvePtr)
  }

  public final fun getEmissionCurve(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setColorInitialRamp(ramp: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to ramp)
    TransferContext.callMethod(MethodBindings.setColorInitialRampPtr)
  }

  public final fun getColorInitialRamp(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorInitialRampPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setVelocityLimitCurve(curve: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setVelocityLimitCurvePtr)
  }

  public final fun getVelocityLimitCurve(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVelocityLimitCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Sets the [particleFlag] to [enable].
   */
  public final fun setParticleFlag(particleFlag: ParticleFlags, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to particleFlag.value, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setParticleFlagPtr)
  }

  /**
   * Returns `true` if the specified particle flag is enabled.
   */
  public final fun getParticleFlag(particleFlag: ParticleFlags): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to particleFlag.value)
    TransferContext.callMethod(MethodBindings.getParticleFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setVelocityPivot(pivot: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to pivot)
    TransferContext.callMethod(MethodBindings.setVelocityPivotPtr)
  }

  public final fun getVelocityPivot(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVelocityPivotPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setEmissionShape(shape: EmissionShape): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.setEmissionShapePtr)
  }

  public final fun getEmissionShape(): EmissionShape {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionShapePtr)
    return EmissionShape.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setEmissionSphereRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionSphereRadiusPtr)
  }

  public final fun getEmissionSphereRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionSphereRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEmissionBoxExtents(extents: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to extents)
    TransferContext.callMethod(MethodBindings.setEmissionBoxExtentsPtr)
  }

  public final fun getEmissionBoxExtents(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionBoxExtentsPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setEmissionPointTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setEmissionPointTexturePtr)
  }

  public final fun getEmissionPointTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionPointTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setEmissionNormalTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setEmissionNormalTexturePtr)
  }

  public final fun getEmissionNormalTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionNormalTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setEmissionColorTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setEmissionColorTexturePtr)
  }

  public final fun getEmissionColorTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionColorTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setEmissionPointCount(pointCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pointCount.toLong())
    TransferContext.callMethod(MethodBindings.setEmissionPointCountPtr)
  }

  public final fun getEmissionPointCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionPointCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setEmissionRingAxis(axis: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to axis)
    TransferContext.callMethod(MethodBindings.setEmissionRingAxisPtr)
  }

  public final fun getEmissionRingAxis(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionRingAxisPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setEmissionRingHeight(height: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to height.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionRingHeightPtr)
  }

  public final fun getEmissionRingHeight(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionRingHeightPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEmissionRingRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionRingRadiusPtr)
  }

  public final fun getEmissionRingRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionRingRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEmissionRingInnerRadius(innerRadius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to innerRadius.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionRingInnerRadiusPtr)
  }

  public final fun getEmissionRingInnerRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionRingInnerRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEmissionRingConeAngle(coneAngle: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to coneAngle.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionRingConeAnglePtr)
  }

  public final fun getEmissionRingConeAngle(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionRingConeAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEmissionShapeOffset(emissionShapeOffset: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to emissionShapeOffset)
    TransferContext.callMethod(MethodBindings.setEmissionShapeOffsetPtr)
  }

  public final fun getEmissionShapeOffset(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionShapeOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setEmissionShapeScale(emissionShapeScale: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to emissionShapeScale)
    TransferContext.callMethod(MethodBindings.setEmissionShapeScalePtr)
  }

  public final fun getEmissionShapeScale(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionShapeScalePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun getTurbulenceEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTurbulenceEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTurbulenceEnabled(turbulenceEnabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to turbulenceEnabled)
    TransferContext.callMethod(MethodBindings.setTurbulenceEnabledPtr)
  }

  public final fun getTurbulenceNoiseStrength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTurbulenceNoiseStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTurbulenceNoiseStrength(turbulenceNoiseStrength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to turbulenceNoiseStrength.toDouble())
    TransferContext.callMethod(MethodBindings.setTurbulenceNoiseStrengthPtr)
  }

  public final fun getTurbulenceNoiseScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTurbulenceNoiseScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTurbulenceNoiseScale(turbulenceNoiseScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to turbulenceNoiseScale.toDouble())
    TransferContext.callMethod(MethodBindings.setTurbulenceNoiseScalePtr)
  }

  public final fun getTurbulenceNoiseSpeedRandom(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTurbulenceNoiseSpeedRandomPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTurbulenceNoiseSpeedRandom(turbulenceNoiseSpeedRandom: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to turbulenceNoiseSpeedRandom.toDouble())
    TransferContext.callMethod(MethodBindings.setTurbulenceNoiseSpeedRandomPtr)
  }

  public final fun getTurbulenceNoiseSpeed(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTurbulenceNoiseSpeedPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setTurbulenceNoiseSpeed(turbulenceNoiseSpeed: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to turbulenceNoiseSpeed)
    TransferContext.callMethod(MethodBindings.setTurbulenceNoiseSpeedPtr)
  }

  public final fun getGravity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setGravity(accelVec: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to accelVec)
    TransferContext.callMethod(MethodBindings.setGravityPtr)
  }

  public final fun setLifetimeRandomness(randomness: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to randomness)
    TransferContext.callMethod(MethodBindings.setLifetimeRandomnessPtr)
  }

  public final fun getLifetimeRandomness(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLifetimeRandomnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun getSubEmitterMode(): SubEmitterMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubEmitterModePtr)
    return SubEmitterMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSubEmitterMode(mode: SubEmitterMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setSubEmitterModePtr)
  }

  public final fun getSubEmitterFrequency(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubEmitterFrequencyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setSubEmitterFrequency(hz: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to hz)
    TransferContext.callMethod(MethodBindings.setSubEmitterFrequencyPtr)
  }

  public final fun getSubEmitterAmountAtEnd(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubEmitterAmountAtEndPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSubEmitterAmountAtEnd(amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.setSubEmitterAmountAtEndPtr)
  }

  public final fun getSubEmitterAmountAtCollision(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubEmitterAmountAtCollisionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSubEmitterAmountAtCollision(amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.setSubEmitterAmountAtCollisionPtr)
  }

  public final fun getSubEmitterAmountAtStart(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubEmitterAmountAtStartPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSubEmitterAmountAtStart(amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.setSubEmitterAmountAtStartPtr)
  }

  public final fun getSubEmitterKeepVelocity(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubEmitterKeepVelocityPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSubEmitterKeepVelocity(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSubEmitterKeepVelocityPtr)
  }

  public final fun setAttractorInteractionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAttractorInteractionEnabledPtr)
  }

  public final fun isAttractorInteractionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAttractorInteractionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCollisionMode(mode: CollisionMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setCollisionModePtr)
  }

  public final fun getCollisionMode(): CollisionMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionModePtr)
    return CollisionMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCollisionUseScale(radius: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to radius)
    TransferContext.callMethod(MethodBindings.setCollisionUseScalePtr)
  }

  public final fun isCollisionUsingScale(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCollisionUsingScalePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCollisionFriction(friction: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to friction.toDouble())
    TransferContext.callMethod(MethodBindings.setCollisionFrictionPtr)
  }

  public final fun getCollisionFriction(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionFrictionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCollisionBounce(bounce: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to bounce.toDouble())
    TransferContext.callMethod(MethodBindings.setCollisionBouncePtr)
  }

  public final fun getCollisionBounce(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionBouncePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setUsingRotationVelocity3d(useRotationVelocity3d: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useRotationVelocity3d)
    TransferContext.callMethod(MethodBindings.setUsingRotationVelocity3dPtr)
  }

  public final fun isUsingRotationVelocity3d(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingRotationVelocity3dPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRotationVelocity3dMax(rotationVelocity3dMax: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to rotationVelocity3dMax)
    TransferContext.callMethod(MethodBindings.setRotationVelocity3dMaxPtr)
  }

  public final fun getRotationVelocity3dMax(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationVelocity3dMaxPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setRotationVelocity3dMin(rotationVelocity3dMin: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to rotationVelocity3dMin)
    TransferContext.callMethod(MethodBindings.setRotationVelocity3dMinPtr)
  }

  public final fun getRotationVelocity3dMin(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationVelocity3dMinPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setRotationVelocity3dCurve(rotationVelocity3dCurve: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to rotationVelocity3dCurve)
    TransferContext.callMethod(MethodBindings.setRotationVelocity3dCurvePtr)
  }

  public final fun getRotationVelocity3dCurve(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationVelocity3dCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderRid(): RID {
    throw NotImplementedError("ParticleProcessMaterial::_getShaderRid can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("ParticleProcessMaterial::_getShaderMode can't be called from the JVM.")
  }

  public enum class Parameter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set initial velocity
     * properties.
     */
    INITIAL_LINEAR_VELOCITY(0),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set angular velocity
     * properties.
     */
    ANGULAR_VELOCITY(1),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set orbital velocity
     * properties.
     */
    ORBIT_VELOCITY(2),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set linear acceleration
     * properties.
     */
    LINEAR_ACCEL(3),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set radial acceleration
     * properties.
     */
    RADIAL_ACCEL(4),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set tangential acceleration
     * properties.
     */
    TANGENTIAL_ACCEL(5),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set damping properties.
     */
    DAMPING(6),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set angle properties.
     */
    ANGLE(7),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set scale properties.
     */
    SCALE(8),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set hue variation properties.
     */
    HUE_VARIATION(9),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set animation speed
     * properties.
     */
    ANIM_SPEED(10),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set animation offset
     * properties.
     */
    ANIM_OFFSET(11),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set radial velocity
     * properties.
     */
    RADIAL_VELOCITY(15),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set directional velocity
     * properties.
     */
    DIRECTIONAL_VELOCITY(16),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamTexture] to set scale over velocity
     * properties.
     */
    SCALE_OVER_VELOCITY(17),
    /**
     * Represents the size of the [Parameter] enum.
     */
    MAX(18),
    /**
     * Use with [setParamMin] and [setParamMax] to set the turbulence minimum und maximum influence
     * on each particles velocity.
     */
    TURB_VEL_INFLUENCE(13),
    /**
     * Use with [setParamMin] and [setParamMax] to set the turbulence minimum and maximum
     * displacement of the particles spawn position.
     */
    TURB_INIT_DISPLACEMENT(14),
    /**
     * Use with [setParamTexture] to set the turbulence influence over the particles life time.
     */
    TURB_INFLUENCE_OVER_LIFE(12),
    ;

    public companion object {
      public fun from(`value`: Long): Parameter = entries.single { it.`value` == `value` }
    }
  }

  public enum class ParticleFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use with [setParticleFlag] to set [particleFlagAlignY].
     */
    ALIGN_Y_TO_VELOCITY(0),
    /**
     * Use with [setParticleFlag] to set [particleFlagRotateY].
     */
    ROTATE_Y(1),
    /**
     * Use with [setParticleFlag] to set [particleFlagDisableZ].
     */
    DISABLE_Z(2),
    DAMPING_AS_FRICTION(3),
    INHERIT_EMITTER_SCALE(4),
    /**
     * Represents the size of the [ParticleFlags] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): ParticleFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class EmissionShape(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * All particles will be emitted from a single point.
     */
    POINT(0),
    /**
     * Particles will be emitted in the volume of a sphere.
     */
    SPHERE(1),
    /**
     * Particles will be emitted on the surface of a sphere.
     */
    SPHERE_SURFACE(2),
    /**
     * Particles will be emitted in the volume of a box.
     */
    BOX(3),
    /**
     * Particles will be emitted at a position determined by sampling a random point on the
     * [emissionPointTexture]. Particle color will be modulated by [emissionColorTexture].
     */
    POINTS(4),
    /**
     * Particles will be emitted at a position determined by sampling a random point on the
     * [emissionPointTexture]. Particle velocity and rotation will be set based on
     * [emissionNormalTexture]. Particle color will be modulated by [emissionColorTexture].
     */
    DIRECTED_POINTS(5),
    /**
     * Particles will be emitted in a ring or cylinder.
     */
    RING(6),
    /**
     * Represents the size of the [EmissionShape] enum.
     */
    MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): EmissionShape = entries.single { it.`value` == `value` }
    }
  }

  public enum class SubEmitterMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The subemitter is disabled.
     */
    DISABLED(0),
    /**
     * The submitter is emitted on the constant interval defined by [subEmitterFrequency].
     */
    CONSTANT(1),
    /**
     * The subemitter is emitted at the end of the particle's lifetime.
     */
    AT_END(2),
    /**
     * The subemitter is emitted when the particle collides.
     */
    AT_COLLISION(3),
    /**
     * The subemitter is emitted when the particle spawns.
     */
    AT_START(4),
    /**
     * Represents the size of the [SubEmitterMode] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): SubEmitterMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CollisionMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No collision for particles. Particles will go through [GPUParticlesCollision3D] nodes.
     */
    DISABLED(0),
    /**
     * [RigidBody3D]-style collision for particles using [GPUParticlesCollision3D] nodes.
     */
    RIGID(1),
    /**
     * Hide particles instantly when colliding with a [GPUParticlesCollision3D] node. This can be
     * combined with a subemitter that uses the [COLLISION_RIGID] collision mode to "replace" the
     * parent particle with the subemitter on impact.
     */
    HIDE_ON_CONTACT(2),
    /**
     * Represents the size of the [CollisionMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): CollisionMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setDirectionName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_direction")

    @JvmField
    public val getDirectionName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_direction")

    @JvmField
    public val setInheritVelocityRatioName: MethodStringName1<ParticleProcessMaterial, Unit, Double>
        = MethodStringName1<ParticleProcessMaterial, Unit, Double>("set_inherit_velocity_ratio")

    @JvmField
    public val getInheritVelocityRatioName: MethodStringName0<ParticleProcessMaterial, Double> =
        MethodStringName0<ParticleProcessMaterial, Double>("get_inherit_velocity_ratio")

    @JvmField
    public val setSpreadName: MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_spread")

    @JvmField
    public val getSpreadName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_spread")

    @JvmField
    public val setFlatnessName: MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_flatness")

    @JvmField
    public val getFlatnessName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_flatness")

    @JvmField
    public val setParamName: MethodStringName2<ParticleProcessMaterial, Unit, Parameter, Vector2> =
        MethodStringName2<ParticleProcessMaterial, Unit, Parameter, Vector2>("set_param")

    @JvmField
    public val getParamName: MethodStringName1<ParticleProcessMaterial, Vector2, Parameter> =
        MethodStringName1<ParticleProcessMaterial, Vector2, Parameter>("get_param")

    @JvmField
    public val setParamMinName: MethodStringName2<ParticleProcessMaterial, Unit, Parameter, Float> =
        MethodStringName2<ParticleProcessMaterial, Unit, Parameter, Float>("set_param_min")

    @JvmField
    public val getParamMinName: MethodStringName1<ParticleProcessMaterial, Float, Parameter> =
        MethodStringName1<ParticleProcessMaterial, Float, Parameter>("get_param_min")

    @JvmField
    public val setParamMaxName: MethodStringName2<ParticleProcessMaterial, Unit, Parameter, Float> =
        MethodStringName2<ParticleProcessMaterial, Unit, Parameter, Float>("set_param_max")

    @JvmField
    public val getParamMaxName: MethodStringName1<ParticleProcessMaterial, Float, Parameter> =
        MethodStringName1<ParticleProcessMaterial, Float, Parameter>("get_param_max")

    @JvmField
    public val setParamTextureName:
        MethodStringName2<ParticleProcessMaterial, Unit, Parameter, Texture2D?> =
        MethodStringName2<ParticleProcessMaterial, Unit, Parameter, Texture2D?>("set_param_texture")

    @JvmField
    public val getParamTextureName:
        MethodStringName1<ParticleProcessMaterial, Texture2D?, Parameter> =
        MethodStringName1<ParticleProcessMaterial, Texture2D?, Parameter>("get_param_texture")

    @JvmField
    public val setColorName: MethodStringName1<ParticleProcessMaterial, Unit, Color> =
        MethodStringName1<ParticleProcessMaterial, Unit, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName0<ParticleProcessMaterial, Color> =
        MethodStringName0<ParticleProcessMaterial, Color>("get_color")

    @JvmField
    public val setUseScale3dName: MethodStringName1<ParticleProcessMaterial, Unit, Boolean> =
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean>("set_use_scale_3d")

    @JvmField
    public val isUsingScale3dName: MethodStringName0<ParticleProcessMaterial, Boolean> =
        MethodStringName0<ParticleProcessMaterial, Boolean>("is_using_scale_3d")

    @JvmField
    public val setScale3dMinName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_scale_3d_min")

    @JvmField
    public val getScale3dMinName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_scale_3d_min")

    @JvmField
    public val setScale3dMaxName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_scale_3d_max")

    @JvmField
    public val getScale3dMaxName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_scale_3d_max")

    @JvmField
    public val setUseRotation3dName: MethodStringName1<ParticleProcessMaterial, Unit, Boolean> =
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean>("set_use_rotation_3d")

    @JvmField
    public val isUsingRotation3dName: MethodStringName0<ParticleProcessMaterial, Boolean> =
        MethodStringName0<ParticleProcessMaterial, Boolean>("is_using_rotation_3d")

    @JvmField
    public val setRotation3dMinName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_rotation_3d_min")

    @JvmField
    public val getRotation3dMinName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_rotation_3d_min")

    @JvmField
    public val setRotation3dMaxName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_rotation_3d_max")

    @JvmField
    public val getRotation3dMaxName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_rotation_3d_max")

    @JvmField
    public val setColorRampName: MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?> =
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_color_ramp")

    @JvmField
    public val getColorRampName: MethodStringName0<ParticleProcessMaterial, Texture2D?> =
        MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_color_ramp")

    @JvmField
    public val setAlphaCurveName: MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?> =
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_alpha_curve")

    @JvmField
    public val getAlphaCurveName: MethodStringName0<ParticleProcessMaterial, Texture2D?> =
        MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_alpha_curve")

    @JvmField
    public val setEmissionCurveName: MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?> =
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_emission_curve")

    @JvmField
    public val getEmissionCurveName: MethodStringName0<ParticleProcessMaterial, Texture2D?> =
        MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_emission_curve")

    @JvmField
    public val setColorInitialRampName: MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>
        = MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_color_initial_ramp")

    @JvmField
    public val getColorInitialRampName: MethodStringName0<ParticleProcessMaterial, Texture2D?> =
        MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_color_initial_ramp")

    @JvmField
    public val setVelocityLimitCurveName:
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?> =
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_velocity_limit_curve")

    @JvmField
    public val getVelocityLimitCurveName: MethodStringName0<ParticleProcessMaterial, Texture2D?> =
        MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_velocity_limit_curve")

    @JvmField
    public val setParticleFlagName:
        MethodStringName2<ParticleProcessMaterial, Unit, ParticleFlags, Boolean> =
        MethodStringName2<ParticleProcessMaterial, Unit, ParticleFlags, Boolean>("set_particle_flag")

    @JvmField
    public val getParticleFlagName:
        MethodStringName1<ParticleProcessMaterial, Boolean, ParticleFlags> =
        MethodStringName1<ParticleProcessMaterial, Boolean, ParticleFlags>("get_particle_flag")

    @JvmField
    public val setVelocityPivotName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_velocity_pivot")

    @JvmField
    public val getVelocityPivotName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_velocity_pivot")

    @JvmField
    public val setEmissionShapeName: MethodStringName1<ParticleProcessMaterial, Unit, EmissionShape>
        = MethodStringName1<ParticleProcessMaterial, Unit, EmissionShape>("set_emission_shape")

    @JvmField
    public val getEmissionShapeName: MethodStringName0<ParticleProcessMaterial, EmissionShape> =
        MethodStringName0<ParticleProcessMaterial, EmissionShape>("get_emission_shape")

    @JvmField
    public val setEmissionSphereRadiusName: MethodStringName1<ParticleProcessMaterial, Unit, Float>
        = MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_emission_sphere_radius")

    @JvmField
    public val getEmissionSphereRadiusName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_emission_sphere_radius")

    @JvmField
    public val setEmissionBoxExtentsName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3>
        = MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_emission_box_extents")

    @JvmField
    public val getEmissionBoxExtentsName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_emission_box_extents")

    @JvmField
    public val setEmissionPointTextureName:
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?> =
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_emission_point_texture")

    @JvmField
    public val getEmissionPointTextureName: MethodStringName0<ParticleProcessMaterial, Texture2D?> =
        MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_emission_point_texture")

    @JvmField
    public val setEmissionNormalTextureName:
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?> =
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_emission_normal_texture")

    @JvmField
    public val getEmissionNormalTextureName: MethodStringName0<ParticleProcessMaterial, Texture2D?>
        = MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_emission_normal_texture")

    @JvmField
    public val setEmissionColorTextureName:
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?> =
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_emission_color_texture")

    @JvmField
    public val getEmissionColorTextureName: MethodStringName0<ParticleProcessMaterial, Texture2D?> =
        MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_emission_color_texture")

    @JvmField
    public val setEmissionPointCountName: MethodStringName1<ParticleProcessMaterial, Unit, Int> =
        MethodStringName1<ParticleProcessMaterial, Unit, Int>("set_emission_point_count")

    @JvmField
    public val getEmissionPointCountName: MethodStringName0<ParticleProcessMaterial, Int> =
        MethodStringName0<ParticleProcessMaterial, Int>("get_emission_point_count")

    @JvmField
    public val setEmissionRingAxisName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_emission_ring_axis")

    @JvmField
    public val getEmissionRingAxisName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_emission_ring_axis")

    @JvmField
    public val setEmissionRingHeightName: MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_emission_ring_height")

    @JvmField
    public val getEmissionRingHeightName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_emission_ring_height")

    @JvmField
    public val setEmissionRingRadiusName: MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_emission_ring_radius")

    @JvmField
    public val getEmissionRingRadiusName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_emission_ring_radius")

    @JvmField
    public val setEmissionRingInnerRadiusName:
        MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_emission_ring_inner_radius")

    @JvmField
    public val getEmissionRingInnerRadiusName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_emission_ring_inner_radius")

    @JvmField
    public val setEmissionRingConeAngleName: MethodStringName1<ParticleProcessMaterial, Unit, Float>
        = MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_emission_ring_cone_angle")

    @JvmField
    public val getEmissionRingConeAngleName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_emission_ring_cone_angle")

    @JvmField
    public val setEmissionShapeOffsetName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3>
        = MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_emission_shape_offset")

    @JvmField
    public val getEmissionShapeOffsetName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_emission_shape_offset")

    @JvmField
    public val setEmissionShapeScaleName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3>
        = MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_emission_shape_scale")

    @JvmField
    public val getEmissionShapeScaleName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_emission_shape_scale")

    @JvmField
    public val getTurbulenceEnabledName: MethodStringName0<ParticleProcessMaterial, Boolean> =
        MethodStringName0<ParticleProcessMaterial, Boolean>("get_turbulence_enabled")

    @JvmField
    public val setTurbulenceEnabledName: MethodStringName1<ParticleProcessMaterial, Unit, Boolean> =
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean>("set_turbulence_enabled")

    @JvmField
    public val getTurbulenceNoiseStrengthName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_turbulence_noise_strength")

    @JvmField
    public val setTurbulenceNoiseStrengthName:
        MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_turbulence_noise_strength")

    @JvmField
    public val getTurbulenceNoiseScaleName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_turbulence_noise_scale")

    @JvmField
    public val setTurbulenceNoiseScaleName: MethodStringName1<ParticleProcessMaterial, Unit, Float>
        = MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_turbulence_noise_scale")

    @JvmField
    public val getTurbulenceNoiseSpeedRandomName: MethodStringName0<ParticleProcessMaterial, Float>
        = MethodStringName0<ParticleProcessMaterial, Float>("get_turbulence_noise_speed_random")

    @JvmField
    public val setTurbulenceNoiseSpeedRandomName:
        MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_turbulence_noise_speed_random")

    @JvmField
    public val getTurbulenceNoiseSpeedName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_turbulence_noise_speed")

    @JvmField
    public val setTurbulenceNoiseSpeedName:
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_turbulence_noise_speed")

    @JvmField
    public val getGravityName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_gravity")

    @JvmField
    public val setGravityName: MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_gravity")

    @JvmField
    public val setLifetimeRandomnessName: MethodStringName1<ParticleProcessMaterial, Unit, Double> =
        MethodStringName1<ParticleProcessMaterial, Unit, Double>("set_lifetime_randomness")

    @JvmField
    public val getLifetimeRandomnessName: MethodStringName0<ParticleProcessMaterial, Double> =
        MethodStringName0<ParticleProcessMaterial, Double>("get_lifetime_randomness")

    @JvmField
    public val getSubEmitterModeName: MethodStringName0<ParticleProcessMaterial, SubEmitterMode> =
        MethodStringName0<ParticleProcessMaterial, SubEmitterMode>("get_sub_emitter_mode")

    @JvmField
    public val setSubEmitterModeName:
        MethodStringName1<ParticleProcessMaterial, Unit, SubEmitterMode> =
        MethodStringName1<ParticleProcessMaterial, Unit, SubEmitterMode>("set_sub_emitter_mode")

    @JvmField
    public val getSubEmitterFrequencyName: MethodStringName0<ParticleProcessMaterial, Double> =
        MethodStringName0<ParticleProcessMaterial, Double>("get_sub_emitter_frequency")

    @JvmField
    public val setSubEmitterFrequencyName: MethodStringName1<ParticleProcessMaterial, Unit, Double>
        = MethodStringName1<ParticleProcessMaterial, Unit, Double>("set_sub_emitter_frequency")

    @JvmField
    public val getSubEmitterAmountAtEndName: MethodStringName0<ParticleProcessMaterial, Int> =
        MethodStringName0<ParticleProcessMaterial, Int>("get_sub_emitter_amount_at_end")

    @JvmField
    public val setSubEmitterAmountAtEndName: MethodStringName1<ParticleProcessMaterial, Unit, Int> =
        MethodStringName1<ParticleProcessMaterial, Unit, Int>("set_sub_emitter_amount_at_end")

    @JvmField
    public val getSubEmitterAmountAtCollisionName: MethodStringName0<ParticleProcessMaterial, Int> =
        MethodStringName0<ParticleProcessMaterial, Int>("get_sub_emitter_amount_at_collision")

    @JvmField
    public val setSubEmitterAmountAtCollisionName:
        MethodStringName1<ParticleProcessMaterial, Unit, Int> =
        MethodStringName1<ParticleProcessMaterial, Unit, Int>("set_sub_emitter_amount_at_collision")

    @JvmField
    public val getSubEmitterAmountAtStartName: MethodStringName0<ParticleProcessMaterial, Int> =
        MethodStringName0<ParticleProcessMaterial, Int>("get_sub_emitter_amount_at_start")

    @JvmField
    public val setSubEmitterAmountAtStartName: MethodStringName1<ParticleProcessMaterial, Unit, Int>
        = MethodStringName1<ParticleProcessMaterial, Unit, Int>("set_sub_emitter_amount_at_start")

    @JvmField
    public val getSubEmitterKeepVelocityName: MethodStringName0<ParticleProcessMaterial, Boolean> =
        MethodStringName0<ParticleProcessMaterial, Boolean>("get_sub_emitter_keep_velocity")

    @JvmField
    public val setSubEmitterKeepVelocityName:
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean> =
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean>("set_sub_emitter_keep_velocity")

    @JvmField
    public val setAttractorInteractionEnabledName:
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean> =
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean>("set_attractor_interaction_enabled")

    @JvmField
    public val isAttractorInteractionEnabledName:
        MethodStringName0<ParticleProcessMaterial, Boolean> =
        MethodStringName0<ParticleProcessMaterial, Boolean>("is_attractor_interaction_enabled")

    @JvmField
    public val setCollisionModeName: MethodStringName1<ParticleProcessMaterial, Unit, CollisionMode>
        = MethodStringName1<ParticleProcessMaterial, Unit, CollisionMode>("set_collision_mode")

    @JvmField
    public val getCollisionModeName: MethodStringName0<ParticleProcessMaterial, CollisionMode> =
        MethodStringName0<ParticleProcessMaterial, CollisionMode>("get_collision_mode")

    @JvmField
    public val setCollisionUseScaleName: MethodStringName1<ParticleProcessMaterial, Unit, Boolean> =
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean>("set_collision_use_scale")

    @JvmField
    public val isCollisionUsingScaleName: MethodStringName0<ParticleProcessMaterial, Boolean> =
        MethodStringName0<ParticleProcessMaterial, Boolean>("is_collision_using_scale")

    @JvmField
    public val setCollisionFrictionName: MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_collision_friction")

    @JvmField
    public val getCollisionFrictionName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_collision_friction")

    @JvmField
    public val setCollisionBounceName: MethodStringName1<ParticleProcessMaterial, Unit, Float> =
        MethodStringName1<ParticleProcessMaterial, Unit, Float>("set_collision_bounce")

    @JvmField
    public val getCollisionBounceName: MethodStringName0<ParticleProcessMaterial, Float> =
        MethodStringName0<ParticleProcessMaterial, Float>("get_collision_bounce")

    @JvmField
    public val setUsingRotationVelocity3dName:
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean> =
        MethodStringName1<ParticleProcessMaterial, Unit, Boolean>("set_using_rotation_velocity_3d")

    @JvmField
    public val isUsingRotationVelocity3dName: MethodStringName0<ParticleProcessMaterial, Boolean> =
        MethodStringName0<ParticleProcessMaterial, Boolean>("is_using_rotation_velocity_3d")

    @JvmField
    public val setRotationVelocity3dMaxName:
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_rotation_velocity_3d_max")

    @JvmField
    public val getRotationVelocity3dMaxName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_rotation_velocity_3d_max")

    @JvmField
    public val setRotationVelocity3dMinName:
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3> =
        MethodStringName1<ParticleProcessMaterial, Unit, Vector3>("set_rotation_velocity_3d_min")

    @JvmField
    public val getRotationVelocity3dMinName: MethodStringName0<ParticleProcessMaterial, Vector3> =
        MethodStringName0<ParticleProcessMaterial, Vector3>("get_rotation_velocity_3d_min")

    @JvmField
    public val setRotationVelocity3dCurveName:
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?> =
        MethodStringName1<ParticleProcessMaterial, Unit, Texture2D?>("set_rotation_velocity_3d_curve")

    @JvmField
    public val getRotationVelocity3dCurveName:
        MethodStringName0<ParticleProcessMaterial, Texture2D?> =
        MethodStringName0<ParticleProcessMaterial, Texture2D?>("get_rotation_velocity_3d_curve")
  }

  public object MethodBindings {
    internal val setDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_direction", 3460891852)

    internal val getDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_direction", 3360562783)

    internal val setInheritVelocityRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_inherit_velocity_ratio", 373806689)

    internal val getInheritVelocityRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_inherit_velocity_ratio", 191475506)

    internal val setSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_spread", 373806689)

    internal val getSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_spread", 1740695150)

    internal val setFlatnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_flatness", 373806689)

    internal val getFlatnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_flatness", 1740695150)

    internal val setParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_param", 676779352)

    internal val getParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_param", 2623708480)

    internal val setParamMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_param_min", 2295964248)

    internal val getParamMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_param_min", 3903786503)

    internal val setParamMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_param_max", 2295964248)

    internal val getParamMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_param_max", 3903786503)

    internal val setParamTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_param_texture", 526976089)

    internal val getParamTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_param_texture", 3489372978)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_color", 2920490490)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_color", 3444240500)

    internal val setUseScale3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_use_scale_3d", 2586408642)

    internal val isUsingScale3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "is_using_scale_3d", 36873697)

    internal val setScale3dMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_scale_3d_min", 3460891852)

    internal val getScale3dMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_scale_3d_min", 3360562783)

    internal val setScale3dMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_scale_3d_max", 3460891852)

    internal val getScale3dMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_scale_3d_max", 3360562783)

    internal val setUseRotation3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_use_rotation_3d", 2586408642)

    internal val isUsingRotation3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "is_using_rotation_3d", 36873697)

    internal val setRotation3dMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_rotation_3d_min", 3460891852)

    internal val getRotation3dMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_rotation_3d_min", 3360562783)

    internal val setRotation3dMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_rotation_3d_max", 3460891852)

    internal val getRotation3dMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_rotation_3d_max", 3360562783)

    internal val setColorRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_color_ramp", 4051416890)

    internal val getColorRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_color_ramp", 3635182373)

    internal val setAlphaCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_alpha_curve", 4051416890)

    internal val getAlphaCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_alpha_curve", 3635182373)

    internal val setEmissionCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_curve", 4051416890)

    internal val getEmissionCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_curve", 3635182373)

    internal val setColorInitialRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_color_initial_ramp", 4051416890)

    internal val getColorInitialRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_color_initial_ramp", 3635182373)

    internal val setVelocityLimitCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_velocity_limit_curve", 4051416890)

    internal val getVelocityLimitCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_velocity_limit_curve", 3635182373)

    internal val setParticleFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_particle_flag", 1711815571)

    internal val getParticleFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_particle_flag", 3895316907)

    internal val setVelocityPivotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_velocity_pivot", 3460891852)

    internal val getVelocityPivotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_velocity_pivot", 3783033775)

    internal val setEmissionShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_shape", 461501442)

    internal val getEmissionShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_shape", 3719733018)

    internal val setEmissionSphereRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_sphere_radius", 373806689)

    internal val getEmissionSphereRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_sphere_radius", 1740695150)

    internal val setEmissionBoxExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_box_extents", 3460891852)

    internal val getEmissionBoxExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_box_extents", 3360562783)

    internal val setEmissionPointTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_point_texture", 4051416890)

    internal val getEmissionPointTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_point_texture", 3635182373)

    internal val setEmissionNormalTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_normal_texture", 4051416890)

    internal val getEmissionNormalTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_normal_texture", 3635182373)

    internal val setEmissionColorTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_color_texture", 4051416890)

    internal val getEmissionColorTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_color_texture", 3635182373)

    internal val setEmissionPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_point_count", 1286410249)

    internal val getEmissionPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_point_count", 3905245786)

    internal val setEmissionRingAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_ring_axis", 3460891852)

    internal val getEmissionRingAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_ring_axis", 3360562783)

    internal val setEmissionRingHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_ring_height", 373806689)

    internal val getEmissionRingHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_ring_height", 1740695150)

    internal val setEmissionRingRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_ring_radius", 373806689)

    internal val getEmissionRingRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_ring_radius", 1740695150)

    internal val setEmissionRingInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_ring_inner_radius", 373806689)

    internal val getEmissionRingInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_ring_inner_radius", 1740695150)

    internal val setEmissionRingConeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_ring_cone_angle", 373806689)

    internal val getEmissionRingConeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_ring_cone_angle", 1740695150)

    internal val setEmissionShapeOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_shape_offset", 3460891852)

    internal val getEmissionShapeOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_shape_offset", 3360562783)

    internal val setEmissionShapeScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_emission_shape_scale", 3460891852)

    internal val getEmissionShapeScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_emission_shape_scale", 3360562783)

    internal val getTurbulenceEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_turbulence_enabled", 36873697)

    internal val setTurbulenceEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_turbulence_enabled", 2586408642)

    internal val getTurbulenceNoiseStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_turbulence_noise_strength", 1740695150)

    internal val setTurbulenceNoiseStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_turbulence_noise_strength", 373806689)

    internal val getTurbulenceNoiseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_turbulence_noise_scale", 1740695150)

    internal val setTurbulenceNoiseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_turbulence_noise_scale", 373806689)

    internal val getTurbulenceNoiseSpeedRandomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_turbulence_noise_speed_random", 1740695150)

    internal val setTurbulenceNoiseSpeedRandomPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_turbulence_noise_speed_random", 373806689)

    internal val getTurbulenceNoiseSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_turbulence_noise_speed", 3360562783)

    internal val setTurbulenceNoiseSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_turbulence_noise_speed", 3460891852)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_gravity", 3360562783)

    internal val setGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_gravity", 3460891852)

    internal val setLifetimeRandomnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_lifetime_randomness", 373806689)

    internal val getLifetimeRandomnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_lifetime_randomness", 1740695150)

    internal val getSubEmitterModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_sub_emitter_mode", 2399052877)

    internal val setSubEmitterModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_sub_emitter_mode", 2161806672)

    internal val getSubEmitterFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_sub_emitter_frequency", 1740695150)

    internal val setSubEmitterFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_sub_emitter_frequency", 373806689)

    internal val getSubEmitterAmountAtEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_sub_emitter_amount_at_end", 3905245786)

    internal val setSubEmitterAmountAtEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_sub_emitter_amount_at_end", 1286410249)

    internal val getSubEmitterAmountAtCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_sub_emitter_amount_at_collision", 3905245786)

    internal val setSubEmitterAmountAtCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_sub_emitter_amount_at_collision", 1286410249)

    internal val getSubEmitterAmountAtStartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_sub_emitter_amount_at_start", 3905245786)

    internal val setSubEmitterAmountAtStartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_sub_emitter_amount_at_start", 1286410249)

    internal val getSubEmitterKeepVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_sub_emitter_keep_velocity", 36873697)

    internal val setSubEmitterKeepVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_sub_emitter_keep_velocity", 2586408642)

    internal val setAttractorInteractionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_attractor_interaction_enabled", 2586408642)

    internal val isAttractorInteractionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "is_attractor_interaction_enabled", 36873697)

    internal val setCollisionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_collision_mode", 653804659)

    internal val getCollisionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_collision_mode", 139371864)

    internal val setCollisionUseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_collision_use_scale", 2586408642)

    internal val isCollisionUsingScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "is_collision_using_scale", 36873697)

    internal val setCollisionFrictionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_collision_friction", 373806689)

    internal val getCollisionFrictionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_collision_friction", 1740695150)

    internal val setCollisionBouncePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_collision_bounce", 373806689)

    internal val getCollisionBouncePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_collision_bounce", 1740695150)

    internal val setUsingRotationVelocity3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_using_rotation_velocity_3d", 2586408642)

    internal val isUsingRotationVelocity3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "is_using_rotation_velocity_3d", 36873697)

    internal val setRotationVelocity3dMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_rotation_velocity_3d_max", 3460891852)

    internal val getRotationVelocity3dMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_rotation_velocity_3d_max", 3360562783)

    internal val setRotationVelocity3dMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_rotation_velocity_3d_min", 3460891852)

    internal val getRotationVelocity3dMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_rotation_velocity_3d_min", 3360562783)

    internal val setRotationVelocity3dCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "set_rotation_velocity_3d_curve", 4051416890)

    internal val getRotationVelocity3dCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ParticleProcessMaterial", "get_rotation_velocity_3d_curve", 3635182373)
  }
}
