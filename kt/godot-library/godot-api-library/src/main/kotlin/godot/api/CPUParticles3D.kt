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
import godot.core.AABB
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedColorArray
import godot.core.PackedVector3Array
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * CPU-based 3D particle node used to create a variety of particle systems and effects.
 *
 * See also [GPUParticles3D], which provides the same functionality with hardware acceleration, but
 * may not run on older devices.
 */
@GodotBaseType
public open class CPUParticles3D : GeometryInstance3D() {
  /**
   * Emitted when all active particles have finished processing. When [oneShot] is disabled,
   * particles will process continuously, so this is never emitted.
   */
  public val finished: Signal0 by Signal0

  /**
   * If `true`, particles are being emitted. [emitting] can be used to start and stop particles from
   * emitting. However, if [oneShot] is `true` setting [emitting] to `true` will not restart the
   * emission cycle until after all active particles finish processing. You can use the [signal
   * finished] signal to be notified once all active particles finish processing.
   */
  public final inline var emitting: Boolean
    @JvmName("emittingProperty")
    get() = isEmitting()
    @JvmName("emittingProperty")
    set(`value`) {
      setEmitting(value)
    }

  /**
   * Number of particles emitted in one emission cycle.
   */
  public final inline var amount: Int
    @JvmName("amountProperty")
    get() = getAmount()
    @JvmName("amountProperty")
    set(`value`) {
      setAmount(value)
    }

  /**
   * Amount of time each particle will exist.
   */
  public final inline var lifetime: Double
    @JvmName("lifetimeProperty")
    get() = getLifetime()
    @JvmName("lifetimeProperty")
    set(`value`) {
      setLifetime(value)
    }

  /**
   * If `true`, only one emission cycle occurs. If set `true` during a cycle, emission will stop at
   * the cycle's end.
   */
  public final inline var oneShot: Boolean
    @JvmName("oneShotProperty")
    get() = getOneShot()
    @JvmName("oneShotProperty")
    set(`value`) {
      setOneShot(value)
    }

  /**
   * Particle system starts as if it had already run for this many seconds.
   */
  public final inline var preprocess: Double
    @JvmName("preprocessProperty")
    get() = getPreProcessTime()
    @JvmName("preprocessProperty")
    set(`value`) {
      setPreProcessTime(value)
    }

  /**
   * Particle system's running speed scaling ratio. A value of `0` can be used to pause the
   * particles.
   */
  public final inline var speedScale: Double
    @JvmName("speedScaleProperty")
    get() = getSpeedScale()
    @JvmName("speedScaleProperty")
    set(`value`) {
      setSpeedScale(value)
    }

  /**
   * How rapidly particles in an emission cycle are emitted. If greater than `0`, there will be a
   * gap in emissions before the next cycle begins.
   */
  public final inline var explosiveness: Float
    @JvmName("explosivenessProperty")
    get() = getExplosivenessRatio()
    @JvmName("explosivenessProperty")
    set(`value`) {
      setExplosivenessRatio(value)
    }

  /**
   * Emission lifetime randomness ratio.
   */
  public final inline var randomness: Float
    @JvmName("randomnessProperty")
    get() = getRandomnessRatio()
    @JvmName("randomnessProperty")
    set(`value`) {
      setRandomnessRatio(value)
    }

  /**
   * If `true`, particles will use the same seed for every simulation using the seed defined in
   * [seed]. This is useful for situations where the visual outcome should be consistent across
   * replays, for example when using Movie Maker mode.
   */
  public final inline var useFixedSeed: Boolean
    @JvmName("useFixedSeedProperty")
    get() = getUseFixedSeed()
    @JvmName("useFixedSeedProperty")
    set(`value`) {
      setUseFixedSeed(value)
    }

  /**
   * Sets the random seed used by the particle system. Only effective if [useFixedSeed] is `true`.
   */
  public final inline var seed: Long
    @JvmName("seedProperty")
    get() = getSeed()
    @JvmName("seedProperty")
    set(`value`) {
      setSeed(value)
    }

  /**
   * Particle lifetime randomness ratio.
   */
  public final inline var lifetimeRandomness: Double
    @JvmName("lifetimeRandomnessProperty")
    get() = getLifetimeRandomness()
    @JvmName("lifetimeRandomnessProperty")
    set(`value`) {
      setLifetimeRandomness(value)
    }

  /**
   * The particle system's frame rate is fixed to a value. For example, changing the value to 2 will
   * make the particles render at 2 frames per second. Note this does not slow down the particle system
   * itself.
   */
  public final inline var fixedFps: Int
    @JvmName("fixedFpsProperty")
    get() = getFixedFps()
    @JvmName("fixedFpsProperty")
    set(`value`) {
      setFixedFps(value)
    }

  /**
   * If `true`, results in fractional delta calculation which has a smoother particles display
   * effect.
   */
  public final inline var fractDelta: Boolean
    @JvmName("fractDeltaProperty")
    get() = getFractionalDelta()
    @JvmName("fractDeltaProperty")
    set(`value`) {
      setFractionalDelta(value)
    }

  /**
   * The [AABB] that determines the node's region which needs to be visible on screen for the
   * particle system to be active.
   *
   * Grow the box if particles suddenly appear/disappear when the node enters/exits the screen. The
   * [AABB] can be grown via code or with the **Particles → Generate AABB** editor tool.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var visibilityAabb: AABB
    @JvmName("visibilityAabbProperty")
    get() = getVisibilityAabb()
    @JvmName("visibilityAabbProperty")
    set(`value`) {
      setVisibilityAabb(value)
    }

  /**
   * If `true`, particles use the parent node's coordinate space (known as local coordinates). This
   * will cause particles to move and rotate along the [CPUParticles3D] node (and its parents) when it
   * is moved or rotated. If `false`, particles use global coordinates; they will not move or rotate
   * along the [CPUParticles3D] node (and its parents) when it is moved or rotated.
   */
  public final inline var localCoords: Boolean
    @JvmName("localCoordsProperty")
    get() = getUseLocalCoordinates()
    @JvmName("localCoordsProperty")
    set(`value`) {
      setUseLocalCoordinates(value)
    }

  /**
   * Particle draw order.
   */
  public final inline var drawOrder: DrawOrder
    @JvmName("drawOrderProperty")
    get() = getDrawOrder()
    @JvmName("drawOrderProperty")
    set(`value`) {
      setDrawOrder(value)
    }

  /**
   * The [Mesh] used for each particle. If `null`, particles will be spheres.
   */
  public final inline var mesh: Mesh?
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
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
   * The sphere's radius if [EmissionShape] is set to [EMISSION_SHAPE_SPHERE].
   */
  public final inline var emissionSphereRadius: Float
    @JvmName("emissionSphereRadiusProperty")
    get() = getEmissionSphereRadius()
    @JvmName("emissionSphereRadiusProperty")
    set(`value`) {
      setEmissionSphereRadius(value)
    }

  /**
   * The rectangle's extents if [emissionShape] is set to [EMISSION_SHAPE_BOX].
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
   * Sets the initial positions to spawn particles when using [EMISSION_SHAPE_POINTS] or
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var emissionPoints: PackedVector3Array
    @JvmName("emissionPointsProperty")
    get() = getEmissionPoints()
    @JvmName("emissionPointsProperty")
    set(`value`) {
      setEmissionPoints(value)
    }

  /**
   * Sets the direction the particles will be emitted in when using
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var emissionNormals: PackedVector3Array
    @JvmName("emissionNormalsProperty")
    get() = getEmissionNormals()
    @JvmName("emissionNormalsProperty")
    set(`value`) {
      setEmissionNormals(value)
    }

  /**
   * Sets the [Color]s to modulate particles by when using [EMISSION_SHAPE_POINTS] or
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   *
   * **Note:** [emissionColors] multiplies the particle mesh's vertex colors. To have a visible
   * effect on a [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [emissionColors] will have no visible effect.
   */
  public final inline var emissionColors: PackedColorArray
    @JvmName("emissionColorsProperty")
    get() = getEmissionColors()
    @JvmName("emissionColorsProperty")
    set(`value`) {
      setEmissionColors(value)
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
   * Align Y axis of particle with the direction of its velocity.
   */
  public final inline var particleFlagAlignY: Boolean
    @JvmName("particleFlagAlignYProperty")
    get() = getParticleFlag(CPUParticles3D.ParticleFlags.ALIGN_Y_TO_VELOCITY)
    @JvmName("particleFlagAlignYProperty")
    set(`value`) {
      setParticleFlag(CPUParticles3D.ParticleFlags.ALIGN_Y_TO_VELOCITY, value)
    }

  /**
   * If `true`, particles rotate around Y axis by [angleMin].
   */
  public final inline var particleFlagRotateY: Boolean
    @JvmName("particleFlagRotateYProperty")
    get() = getParticleFlag(CPUParticles3D.ParticleFlags.ROTATE_Y)
    @JvmName("particleFlagRotateYProperty")
    set(`value`) {
      setParticleFlag(CPUParticles3D.ParticleFlags.ROTATE_Y, value)
    }

  /**
   * If `true`, particles will not move on the Z axis.
   */
  public final inline var particleFlagDisableZ: Boolean
    @JvmName("particleFlagDisableZProperty")
    get() = getParticleFlag(CPUParticles3D.ParticleFlags.DISABLE_Z)
    @JvmName("particleFlagDisableZProperty")
    set(`value`) {
      setParticleFlag(CPUParticles3D.ParticleFlags.DISABLE_Z, value)
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
   * Each particle's initial direction range from `+spread` to `-spread` degrees. Applied to X/Z
   * plane and Y/Z planes.
   */
  public final inline var spread: Float
    @JvmName("spreadProperty")
    get() = getSpread()
    @JvmName("spreadProperty")
    set(`value`) {
      setSpread(value)
    }

  /**
   * Amount of [spread] in Y/Z plane. A value of `1` restricts particles to X/Z plane.
   */
  public final inline var flatness: Float
    @JvmName("flatnessProperty")
    get() = getFlatness()
    @JvmName("flatnessProperty")
    set(`value`) {
      setFlatness(value)
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
   * Minimum value of the initial velocity.
   */
  public final inline var initialVelocityMin: Float
    @JvmName("initialVelocityMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.INITIAL_LINEAR_VELOCITY)
    @JvmName("initialVelocityMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.INITIAL_LINEAR_VELOCITY, value)
    }

  /**
   * Maximum value of the initial velocity.
   */
  public final inline var initialVelocityMax: Float
    @JvmName("initialVelocityMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.INITIAL_LINEAR_VELOCITY)
    @JvmName("initialVelocityMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.INITIAL_LINEAR_VELOCITY, value)
    }

  /**
   * Minimum initial angular velocity (rotation speed) applied to each particle in *degrees* per
   * second.
   */
  public final inline var angularVelocityMin: Float
    @JvmName("angularVelocityMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Maximum initial angular velocity (rotation speed) applied to each particle in *degrees* per
   * second.
   */
  public final inline var angularVelocityMax: Float
    @JvmName("angularVelocityMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Each particle's angular velocity (rotation speed) will vary along this [Curve] over its
   * lifetime. Should be a unit [Curve].
   */
  public final inline var angularVelocityCurve: Curve?
    @JvmName("angularVelocityCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Minimum orbit velocity.
   */
  public final inline var orbitVelocityMin: Float
    @JvmName("orbitVelocityMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Maximum orbit velocity.
   */
  public final inline var orbitVelocityMax: Float
    @JvmName("orbitVelocityMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Each particle's orbital velocity will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var orbitVelocityCurve: Curve?
    @JvmName("orbitVelocityCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Minimum linear acceleration.
   */
  public final inline var linearAccelMin: Float
    @JvmName("linearAccelMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Maximum linear acceleration.
   */
  public final inline var linearAccelMax: Float
    @JvmName("linearAccelMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Each particle's linear acceleration will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var linearAccelCurve: Curve?
    @JvmName("linearAccelCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Minimum radial acceleration.
   */
  public final inline var radialAccelMin: Float
    @JvmName("radialAccelMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Maximum radial acceleration.
   */
  public final inline var radialAccelMax: Float
    @JvmName("radialAccelMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Each particle's radial acceleration will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var radialAccelCurve: Curve?
    @JvmName("radialAccelCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Minimum tangent acceleration.
   */
  public final inline var tangentialAccelMin: Float
    @JvmName("tangentialAccelMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Maximum tangent acceleration.
   */
  public final inline var tangentialAccelMax: Float
    @JvmName("tangentialAccelMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Each particle's tangential acceleration will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var tangentialAccelCurve: Curve?
    @JvmName("tangentialAccelCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Minimum damping.
   */
  public final inline var dampingMin: Float
    @JvmName("dampingMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.DAMPING)
    @JvmName("dampingMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.DAMPING, value)
    }

  /**
   * Maximum damping.
   */
  public final inline var dampingMax: Float
    @JvmName("dampingMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.DAMPING)
    @JvmName("dampingMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.DAMPING, value)
    }

  /**
   * Damping will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var dampingCurve: Curve?
    @JvmName("dampingCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.DAMPING)
    @JvmName("dampingCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.DAMPING, value)
    }

  /**
   * Minimum angle.
   */
  public final inline var angleMin: Float
    @JvmName("angleMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.ANGLE)
    @JvmName("angleMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.ANGLE, value)
    }

  /**
   * Maximum angle.
   */
  public final inline var angleMax: Float
    @JvmName("angleMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.ANGLE)
    @JvmName("angleMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.ANGLE, value)
    }

  /**
   * Each particle's rotation will be animated along this [Curve]. Should be a unit [Curve].
   */
  public final inline var angleCurve: Curve?
    @JvmName("angleCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.ANGLE)
    @JvmName("angleCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.ANGLE, value)
    }

  /**
   * Minimum scale.
   */
  public final inline var scaleAmountMin: Float
    @JvmName("scaleAmountMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.SCALE)
    @JvmName("scaleAmountMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.SCALE, value)
    }

  /**
   * Maximum scale.
   */
  public final inline var scaleAmountMax: Float
    @JvmName("scaleAmountMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.SCALE)
    @JvmName("scaleAmountMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.SCALE, value)
    }

  /**
   * Each particle's scale will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var scaleAmountCurve: Curve?
    @JvmName("scaleAmountCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.SCALE)
    @JvmName("scaleAmountCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.SCALE, value)
    }

  /**
   * If set to `true`, three different scale curves can be specified, one per scale axis.
   */
  public final inline var splitScale: Boolean
    @JvmName("splitScaleProperty")
    get() = getSplitScale()
    @JvmName("splitScaleProperty")
    set(`value`) {
      setSplitScale(value)
    }

  /**
   * Curve for the scale over life, along the x axis.
   */
  public final inline var scaleCurveX: Curve?
    @JvmName("scaleCurveXProperty")
    get() = getScaleCurveX()
    @JvmName("scaleCurveXProperty")
    set(`value`) {
      setScaleCurveX(value)
    }

  /**
   * Curve for the scale over life, along the y axis.
   */
  public final inline var scaleCurveY: Curve?
    @JvmName("scaleCurveYProperty")
    get() = getScaleCurveY()
    @JvmName("scaleCurveYProperty")
    set(`value`) {
      setScaleCurveY(value)
    }

  /**
   * Curve for the scale over life, along the z axis.
   */
  public final inline var scaleCurveZ: Curve?
    @JvmName("scaleCurveZProperty")
    get() = getScaleCurveZ()
    @JvmName("scaleCurveZProperty")
    set(`value`) {
      setScaleCurveZ(value)
    }

  /**
   * Each particle's initial color.
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
   * Each particle's color will vary along this [Gradient] over its lifetime (multiplied with
   * [color]).
   *
   * **Note:** [colorRamp] multiplies the particle mesh's vertex colors. To have a visible effect on
   * a [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [colorRamp] will have no visible effect.
   */
  public final inline var colorRamp: Gradient?
    @JvmName("colorRampProperty")
    get() = getColorRamp()
    @JvmName("colorRampProperty")
    set(`value`) {
      setColorRamp(value)
    }

  /**
   * Each particle's initial color will vary along this [Gradient] (multiplied with [color]).
   *
   * **Note:** [colorInitialRamp] multiplies the particle mesh's vertex colors. To have a visible
   * effect on a [BaseMaterial3D], [BaseMaterial3D.vertexColorUseAsAlbedo] *must* be `true`. For a
   * [ShaderMaterial], `ALBEDO *= COLOR.rgb;` must be inserted in the shader's `fragment()` function.
   * Otherwise, [colorInitialRamp] will have no visible effect.
   */
  public final inline var colorInitialRamp: Gradient?
    @JvmName("colorInitialRampProperty")
    get() = getColorInitialRamp()
    @JvmName("colorInitialRampProperty")
    set(`value`) {
      setColorInitialRamp(value)
    }

  /**
   * Minimum hue variation.
   */
  public final inline var hueVariationMin: Float
    @JvmName("hueVariationMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.HUE_VARIATION)
    @JvmName("hueVariationMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.HUE_VARIATION, value)
    }

  /**
   * Maximum hue variation.
   */
  public final inline var hueVariationMax: Float
    @JvmName("hueVariationMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.HUE_VARIATION)
    @JvmName("hueVariationMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.HUE_VARIATION, value)
    }

  /**
   * Each particle's hue will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var hueVariationCurve: Curve?
    @JvmName("hueVariationCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.HUE_VARIATION)
    @JvmName("hueVariationCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.HUE_VARIATION, value)
    }

  /**
   * Minimum particle animation speed.
   */
  public final inline var animSpeedMin: Float
    @JvmName("animSpeedMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.ANIM_SPEED)
    @JvmName("animSpeedMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.ANIM_SPEED, value)
    }

  /**
   * Maximum particle animation speed.
   */
  public final inline var animSpeedMax: Float
    @JvmName("animSpeedMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.ANIM_SPEED)
    @JvmName("animSpeedMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.ANIM_SPEED, value)
    }

  /**
   * Each particle's animation speed will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var animSpeedCurve: Curve?
    @JvmName("animSpeedCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.ANIM_SPEED)
    @JvmName("animSpeedCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.ANIM_SPEED, value)
    }

  /**
   * Minimum animation offset.
   */
  public final inline var animOffsetMin: Float
    @JvmName("animOffsetMinProperty")
    get() = getParamMin(CPUParticles3D.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetMinProperty")
    set(`value`) {
      setParamMin(CPUParticles3D.Parameter.ANIM_OFFSET, value)
    }

  /**
   * Maximum animation offset.
   */
  public final inline var animOffsetMax: Float
    @JvmName("animOffsetMaxProperty")
    get() = getParamMax(CPUParticles3D.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles3D.Parameter.ANIM_OFFSET, value)
    }

  /**
   * Each particle's animation offset will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var animOffsetCurve: Curve?
    @JvmName("animOffsetCurveProperty")
    get() = getParamCurve(CPUParticles3D.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles3D.Parameter.ANIM_OFFSET, value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(124, scriptPtr)
  }

  /**
   * This is a helper function for [visibilityAabb] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles3d.visibilityAabb
   * //Your changes
   * cpuparticles3d.visibilityAabb = myCoreType
   * ``````
   *
   * The [AABB] that determines the node's region which needs to be visible on screen for the
   * particle system to be active.
   *
   * Grow the box if particles suddenly appear/disappear when the node enters/exits the screen. The
   * [AABB] can be grown via code or with the **Particles → Generate AABB** editor tool.
   */
  @CoreTypeHelper
  public final fun visibilityAabbMutate(block: AABB.() -> Unit): AABB = visibilityAabb.apply {
     block(this)
     visibilityAabb = this
  }

  /**
   * This is a helper function for [emissionBoxExtents] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles3d.emissionBoxExtents
   * //Your changes
   * cpuparticles3d.emissionBoxExtents = myCoreType
   * ``````
   *
   * The rectangle's extents if [emissionShape] is set to [EMISSION_SHAPE_BOX].
   */
  @CoreTypeHelper
  public final fun emissionBoxExtentsMutate(block: Vector3.() -> Unit): Vector3 =
      emissionBoxExtents.apply {
     block(this)
     emissionBoxExtents = this
  }

  /**
   * This is a helper function for [emissionPoints] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles3d.emissionPoints
   * //Your changes
   * cpuparticles3d.emissionPoints = myCoreType
   * ``````
   *
   * Sets the initial positions to spawn particles when using [EMISSION_SHAPE_POINTS] or
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   */
  @CoreTypeHelper
  public final fun emissionPointsMutate(block: PackedVector3Array.() -> Unit): PackedVector3Array =
      emissionPoints.apply {
     block(this)
     emissionPoints = this
  }

  /**
   * This is a helper function for [emissionPoints] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Sets the initial positions to spawn particles when using [EMISSION_SHAPE_POINTS] or
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   */
  @CoreTypeHelper
  public final fun emissionPointsMutateEach(block: (index: Int, `value`: Vector3) -> Unit):
      PackedVector3Array = emissionPoints.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     emissionPoints = this
  }

  /**
   * This is a helper function for [emissionNormals] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles3d.emissionNormals
   * //Your changes
   * cpuparticles3d.emissionNormals = myCoreType
   * ``````
   *
   * Sets the direction the particles will be emitted in when using
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   */
  @CoreTypeHelper
  public final fun emissionNormalsMutate(block: PackedVector3Array.() -> Unit): PackedVector3Array =
      emissionNormals.apply {
     block(this)
     emissionNormals = this
  }

  /**
   * This is a helper function for [emissionNormals] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Sets the direction the particles will be emitted in when using
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   */
  @CoreTypeHelper
  public final fun emissionNormalsMutateEach(block: (index: Int, `value`: Vector3) -> Unit):
      PackedVector3Array = emissionNormals.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     emissionNormals = this
  }

  /**
   * This is a helper function for [emissionRingAxis] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles3d.emissionRingAxis
   * //Your changes
   * cpuparticles3d.emissionRingAxis = myCoreType
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
   * This is a helper function for [direction] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles3d.direction
   * //Your changes
   * cpuparticles3d.direction = myCoreType
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
   * This is a helper function for [gravity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles3d.gravity
   * //Your changes
   * cpuparticles3d.gravity = myCoreType
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
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles3d.color
   * //Your changes
   * cpuparticles3d.color = myCoreType
   * ``````
   *
   * Each particle's initial color.
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

  public final fun setEmitting(emitting: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to emitting)
    TransferContext.callMethod(MethodBindings.setEmittingPtr)
  }

  public final fun setAmount(amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.setAmountPtr)
  }

  public final fun setLifetime(secs: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to secs)
    TransferContext.callMethod(MethodBindings.setLifetimePtr)
  }

  public final fun setOneShot(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setOneShotPtr)
  }

  public final fun setPreProcessTime(secs: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to secs)
    TransferContext.callMethod(MethodBindings.setPreProcessTimePtr)
  }

  public final fun setExplosivenessRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setExplosivenessRatioPtr)
  }

  public final fun setRandomnessRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setRandomnessRatioPtr)
  }

  public final fun setVisibilityAabb(aabb: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, godot.core.VariantParser.AABB to aabb)
    TransferContext.callMethod(MethodBindings.setVisibilityAabbPtr)
  }

  public final fun setLifetimeRandomness(random: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to random)
    TransferContext.callMethod(MethodBindings.setLifetimeRandomnessPtr)
  }

  public final fun setUseLocalCoordinates(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseLocalCoordinatesPtr)
  }

  public final fun setFixedFps(fps: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fps.toLong())
    TransferContext.callMethod(MethodBindings.setFixedFpsPtr)
  }

  public final fun setFractionalDelta(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setFractionalDeltaPtr)
  }

  public final fun setSpeedScale(scale: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale)
    TransferContext.callMethod(MethodBindings.setSpeedScalePtr)
  }

  public final fun isEmitting(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmittingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun getAmount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun getLifetime(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLifetimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun getOneShot(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOneShotPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun getPreProcessTime(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPreProcessTimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun getExplosivenessRatio(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExplosivenessRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getRandomnessRatio(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRandomnessRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getVisibilityAabb(): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityAabbPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  public final fun getLifetimeRandomness(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLifetimeRandomnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun getUseLocalCoordinates(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseLocalCoordinatesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun getFixedFps(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFixedFpsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun getFractionalDelta(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFractionalDeltaPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun getSpeedScale(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpeedScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setDrawOrder(order: DrawOrder): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to order.value)
    TransferContext.callMethod(MethodBindings.setDrawOrderPtr)
  }

  public final fun getDrawOrder(): DrawOrder {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDrawOrderPtr)
    return DrawOrder.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMesh(mesh: Mesh?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh)
    TransferContext.callMethod(MethodBindings.setMeshPtr)
  }

  public final fun getMesh(): Mesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as Mesh?)
  }

  public final fun setUseFixedSeed(useFixedSeed: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useFixedSeed)
    TransferContext.callMethod(MethodBindings.setUseFixedSeedPtr)
  }

  public final fun getUseFixedSeed(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseFixedSeedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSeed(seed: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to seed)
    TransferContext.callMethod(MethodBindings.setSeedPtr)
  }

  public final fun getSeed(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSeedPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Restarts the particle emitter.
   *
   * If [keepSeed] is `true`, the current random seed will be preserved. Useful for seeking and
   * playback.
   */
  @JvmOverloads
  public final fun restart(keepSeed: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to keepSeed)
    TransferContext.callMethod(MethodBindings.restartPtr)
  }

  /**
   * Requests the particles to process for extra process time during a single frame.
   *
   * [processTime] defines the time that the particles will process while emitting is on.
   * [processTimeResidual] defines the time that particles will process with emitting turned off for
   * the simulation. When combined with [speedScale] set to `0.0`, this is useful to be able to seek a
   * particle system timeline.
   */
  @JvmOverloads
  public final fun requestParticlesProcess(processTime: Float, processTimeResidual: Float = 0.0f):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to processTime.toDouble(), DOUBLE to processTimeResidual.toDouble())
    TransferContext.callMethod(MethodBindings.requestParticlesProcessPtr)
  }

  /**
   * Returns the axis-aligned bounding box that contains all the particles that are active in the
   * current frame.
   */
  public final fun captureAabb(): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.captureAabbPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  public final fun setDirection(direction: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to direction)
    TransferContext.callMethod(MethodBindings.setDirectionPtr)
  }

  public final fun getDirection(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDirectionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
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
   * Sets the minimum value for the given parameter.
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
   * Sets the maximum value for the given parameter.
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
   * Sets the [Curve] of the parameter specified by [Parameter]. Should be a unit [Curve].
   */
  public final fun setParamCurve(`param`: Parameter, curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setParamCurvePtr)
  }

  /**
   * Returns the [Curve] of the parameter specified by [Parameter].
   */
  public final fun getParamCurve(`param`: Parameter): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to param.value)
    TransferContext.callMethod(MethodBindings.getParamCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
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

  public final fun setColorRamp(ramp: Gradient?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to ramp)
    TransferContext.callMethod(MethodBindings.setColorRampPtr)
  }

  public final fun getColorRamp(): Gradient? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorRampPtr)
    return (TransferContext.readReturnValue(OBJECT) as Gradient?)
  }

  public final fun setColorInitialRamp(ramp: Gradient?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to ramp)
    TransferContext.callMethod(MethodBindings.setColorInitialRampPtr)
  }

  public final fun getColorInitialRamp(): Gradient? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorInitialRampPtr)
    return (TransferContext.readReturnValue(OBJECT) as Gradient?)
  }

  /**
   * Enables or disables the given particle flag.
   */
  public final fun setParticleFlag(particleFlag: ParticleFlags, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to particleFlag.value, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setParticleFlagPtr)
  }

  /**
   * Returns the enabled state of the given particle flag.
   */
  public final fun getParticleFlag(particleFlag: ParticleFlags): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to particleFlag.value)
    TransferContext.callMethod(MethodBindings.getParticleFlagPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
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

  public final fun setEmissionPoints(array: PackedVector3Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to array)
    TransferContext.callMethod(MethodBindings.setEmissionPointsPtr)
  }

  public final fun getEmissionPoints(): PackedVector3Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionPointsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR3_ARRAY) as PackedVector3Array)
  }

  public final fun setEmissionNormals(array: PackedVector3Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to array)
    TransferContext.callMethod(MethodBindings.setEmissionNormalsPtr)
  }

  public final fun getEmissionNormals(): PackedVector3Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionNormalsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR3_ARRAY) as PackedVector3Array)
  }

  public final fun setEmissionColors(array: PackedColorArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_COLOR_ARRAY to array)
    TransferContext.callMethod(MethodBindings.setEmissionColorsPtr)
  }

  public final fun getEmissionColors(): PackedColorArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionColorsPtr)
    return (TransferContext.readReturnValue(PACKED_COLOR_ARRAY) as PackedColorArray)
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

  public final fun getGravity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setGravity(accelVec: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to accelVec)
    TransferContext.callMethod(MethodBindings.setGravityPtr)
  }

  public final fun getSplitScale(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSplitScalePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSplitScale(splitScale: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to splitScale)
    TransferContext.callMethod(MethodBindings.setSplitScalePtr)
  }

  public final fun getScaleCurveX(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScaleCurveXPtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setScaleCurveX(scaleCurve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to scaleCurve)
    TransferContext.callMethod(MethodBindings.setScaleCurveXPtr)
  }

  public final fun getScaleCurveY(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScaleCurveYPtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setScaleCurveY(scaleCurve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to scaleCurve)
    TransferContext.callMethod(MethodBindings.setScaleCurveYPtr)
  }

  public final fun getScaleCurveZ(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScaleCurveZPtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setScaleCurveZ(scaleCurve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to scaleCurve)
    TransferContext.callMethod(MethodBindings.setScaleCurveZPtr)
  }

  /**
   * Sets this node's properties to match a given [GPUParticles3D] node with an assigned
   * [ParticleProcessMaterial].
   */
  public final fun convertFromParticles(particles: Node?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to particles)
    TransferContext.callMethod(MethodBindings.convertFromParticlesPtr)
  }

  public enum class DrawOrder(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Particles are drawn in the order emitted.
     */
    INDEX(0),
    /**
     * Particles are drawn in order of remaining lifetime. In other words, the particle with the
     * highest lifetime is drawn at the front.
     */
    LIFETIME(1),
    /**
     * Particles are drawn in order of depth.
     */
    VIEW_DEPTH(2),
    ;

    public companion object {
      public fun from(`value`: Long): DrawOrder = entries.single { it.`value` == `value` }
    }
  }

  public enum class Parameter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set initial velocity
     * properties.
     */
    INITIAL_LINEAR_VELOCITY(0),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set angular velocity
     * properties.
     */
    ANGULAR_VELOCITY(1),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set orbital velocity
     * properties.
     */
    ORBIT_VELOCITY(2),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set linear acceleration
     * properties.
     */
    LINEAR_ACCEL(3),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set radial acceleration
     * properties.
     */
    RADIAL_ACCEL(4),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set tangential acceleration
     * properties.
     */
    TANGENTIAL_ACCEL(5),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set damping properties.
     */
    DAMPING(6),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set angle properties.
     */
    ANGLE(7),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set scale properties.
     */
    SCALE(8),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set hue variation properties.
     */
    HUE_VARIATION(9),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set animation speed properties.
     */
    ANIM_SPEED(10),
    /**
     * Use with [setParamMin], [setParamMax], and [setParamCurve] to set animation offset
     * properties.
     */
    ANIM_OFFSET(11),
    /**
     * Represents the size of the [Parameter] enum.
     */
    MAX(12),
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
    /**
     * Represents the size of the [ParticleFlags] enum.
     */
    MAX(3),
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
     * Particles will be emitted at a position chosen randomly among [emissionPoints]. Particle
     * color will be modulated by [emissionColors].
     */
    POINTS(4),
    /**
     * Particles will be emitted at a position chosen randomly among [emissionPoints]. Particle
     * velocity and rotation will be set based on [emissionNormals]. Particle color will be modulated
     * by [emissionColors].
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

  public companion object {
    @JvmField
    public val setEmittingName: MethodStringName1<CPUParticles3D, Unit, Boolean> =
        MethodStringName1<CPUParticles3D, Unit, Boolean>("set_emitting")

    @JvmField
    public val setAmountName: MethodStringName1<CPUParticles3D, Unit, Int> =
        MethodStringName1<CPUParticles3D, Unit, Int>("set_amount")

    @JvmField
    public val setLifetimeName: MethodStringName1<CPUParticles3D, Unit, Double> =
        MethodStringName1<CPUParticles3D, Unit, Double>("set_lifetime")

    @JvmField
    public val setOneShotName: MethodStringName1<CPUParticles3D, Unit, Boolean> =
        MethodStringName1<CPUParticles3D, Unit, Boolean>("set_one_shot")

    @JvmField
    public val setPreProcessTimeName: MethodStringName1<CPUParticles3D, Unit, Double> =
        MethodStringName1<CPUParticles3D, Unit, Double>("set_pre_process_time")

    @JvmField
    public val setExplosivenessRatioName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_explosiveness_ratio")

    @JvmField
    public val setRandomnessRatioName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_randomness_ratio")

    @JvmField
    public val setVisibilityAabbName: MethodStringName1<CPUParticles3D, Unit, AABB> =
        MethodStringName1<CPUParticles3D, Unit, AABB>("set_visibility_aabb")

    @JvmField
    public val setLifetimeRandomnessName: MethodStringName1<CPUParticles3D, Unit, Double> =
        MethodStringName1<CPUParticles3D, Unit, Double>("set_lifetime_randomness")

    @JvmField
    public val setUseLocalCoordinatesName: MethodStringName1<CPUParticles3D, Unit, Boolean> =
        MethodStringName1<CPUParticles3D, Unit, Boolean>("set_use_local_coordinates")

    @JvmField
    public val setFixedFpsName: MethodStringName1<CPUParticles3D, Unit, Int> =
        MethodStringName1<CPUParticles3D, Unit, Int>("set_fixed_fps")

    @JvmField
    public val setFractionalDeltaName: MethodStringName1<CPUParticles3D, Unit, Boolean> =
        MethodStringName1<CPUParticles3D, Unit, Boolean>("set_fractional_delta")

    @JvmField
    public val setSpeedScaleName: MethodStringName1<CPUParticles3D, Unit, Double> =
        MethodStringName1<CPUParticles3D, Unit, Double>("set_speed_scale")

    @JvmField
    public val isEmittingName: MethodStringName0<CPUParticles3D, Boolean> =
        MethodStringName0<CPUParticles3D, Boolean>("is_emitting")

    @JvmField
    public val getAmountName: MethodStringName0<CPUParticles3D, Int> =
        MethodStringName0<CPUParticles3D, Int>("get_amount")

    @JvmField
    public val getLifetimeName: MethodStringName0<CPUParticles3D, Double> =
        MethodStringName0<CPUParticles3D, Double>("get_lifetime")

    @JvmField
    public val getOneShotName: MethodStringName0<CPUParticles3D, Boolean> =
        MethodStringName0<CPUParticles3D, Boolean>("get_one_shot")

    @JvmField
    public val getPreProcessTimeName: MethodStringName0<CPUParticles3D, Double> =
        MethodStringName0<CPUParticles3D, Double>("get_pre_process_time")

    @JvmField
    public val getExplosivenessRatioName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_explosiveness_ratio")

    @JvmField
    public val getRandomnessRatioName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_randomness_ratio")

    @JvmField
    public val getVisibilityAabbName: MethodStringName0<CPUParticles3D, AABB> =
        MethodStringName0<CPUParticles3D, AABB>("get_visibility_aabb")

    @JvmField
    public val getLifetimeRandomnessName: MethodStringName0<CPUParticles3D, Double> =
        MethodStringName0<CPUParticles3D, Double>("get_lifetime_randomness")

    @JvmField
    public val getUseLocalCoordinatesName: MethodStringName0<CPUParticles3D, Boolean> =
        MethodStringName0<CPUParticles3D, Boolean>("get_use_local_coordinates")

    @JvmField
    public val getFixedFpsName: MethodStringName0<CPUParticles3D, Int> =
        MethodStringName0<CPUParticles3D, Int>("get_fixed_fps")

    @JvmField
    public val getFractionalDeltaName: MethodStringName0<CPUParticles3D, Boolean> =
        MethodStringName0<CPUParticles3D, Boolean>("get_fractional_delta")

    @JvmField
    public val getSpeedScaleName: MethodStringName0<CPUParticles3D, Double> =
        MethodStringName0<CPUParticles3D, Double>("get_speed_scale")

    @JvmField
    public val setDrawOrderName: MethodStringName1<CPUParticles3D, Unit, DrawOrder> =
        MethodStringName1<CPUParticles3D, Unit, DrawOrder>("set_draw_order")

    @JvmField
    public val getDrawOrderName: MethodStringName0<CPUParticles3D, DrawOrder> =
        MethodStringName0<CPUParticles3D, DrawOrder>("get_draw_order")

    @JvmField
    public val setMeshName: MethodStringName1<CPUParticles3D, Unit, Mesh?> =
        MethodStringName1<CPUParticles3D, Unit, Mesh?>("set_mesh")

    @JvmField
    public val getMeshName: MethodStringName0<CPUParticles3D, Mesh?> =
        MethodStringName0<CPUParticles3D, Mesh?>("get_mesh")

    @JvmField
    public val setUseFixedSeedName: MethodStringName1<CPUParticles3D, Unit, Boolean> =
        MethodStringName1<CPUParticles3D, Unit, Boolean>("set_use_fixed_seed")

    @JvmField
    public val getUseFixedSeedName: MethodStringName0<CPUParticles3D, Boolean> =
        MethodStringName0<CPUParticles3D, Boolean>("get_use_fixed_seed")

    @JvmField
    public val setSeedName: MethodStringName1<CPUParticles3D, Unit, Long> =
        MethodStringName1<CPUParticles3D, Unit, Long>("set_seed")

    @JvmField
    public val getSeedName: MethodStringName0<CPUParticles3D, Long> =
        MethodStringName0<CPUParticles3D, Long>("get_seed")

    @JvmField
    public val restartName: MethodStringName1<CPUParticles3D, Unit, Boolean> =
        MethodStringName1<CPUParticles3D, Unit, Boolean>("restart")

    @JvmField
    public val requestParticlesProcessName: MethodStringName2<CPUParticles3D, Unit, Float, Float> =
        MethodStringName2<CPUParticles3D, Unit, Float, Float>("request_particles_process")

    @JvmField
    public val captureAabbName: MethodStringName0<CPUParticles3D, AABB> =
        MethodStringName0<CPUParticles3D, AABB>("capture_aabb")

    @JvmField
    public val setDirectionName: MethodStringName1<CPUParticles3D, Unit, Vector3> =
        MethodStringName1<CPUParticles3D, Unit, Vector3>("set_direction")

    @JvmField
    public val getDirectionName: MethodStringName0<CPUParticles3D, Vector3> =
        MethodStringName0<CPUParticles3D, Vector3>("get_direction")

    @JvmField
    public val setSpreadName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_spread")

    @JvmField
    public val getSpreadName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_spread")

    @JvmField
    public val setFlatnessName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_flatness")

    @JvmField
    public val getFlatnessName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_flatness")

    @JvmField
    public val setParamMinName: MethodStringName2<CPUParticles3D, Unit, Parameter, Float> =
        MethodStringName2<CPUParticles3D, Unit, Parameter, Float>("set_param_min")

    @JvmField
    public val getParamMinName: MethodStringName1<CPUParticles3D, Float, Parameter> =
        MethodStringName1<CPUParticles3D, Float, Parameter>("get_param_min")

    @JvmField
    public val setParamMaxName: MethodStringName2<CPUParticles3D, Unit, Parameter, Float> =
        MethodStringName2<CPUParticles3D, Unit, Parameter, Float>("set_param_max")

    @JvmField
    public val getParamMaxName: MethodStringName1<CPUParticles3D, Float, Parameter> =
        MethodStringName1<CPUParticles3D, Float, Parameter>("get_param_max")

    @JvmField
    public val setParamCurveName: MethodStringName2<CPUParticles3D, Unit, Parameter, Curve?> =
        MethodStringName2<CPUParticles3D, Unit, Parameter, Curve?>("set_param_curve")

    @JvmField
    public val getParamCurveName: MethodStringName1<CPUParticles3D, Curve?, Parameter> =
        MethodStringName1<CPUParticles3D, Curve?, Parameter>("get_param_curve")

    @JvmField
    public val setColorName: MethodStringName1<CPUParticles3D, Unit, Color> =
        MethodStringName1<CPUParticles3D, Unit, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName0<CPUParticles3D, Color> =
        MethodStringName0<CPUParticles3D, Color>("get_color")

    @JvmField
    public val setColorRampName: MethodStringName1<CPUParticles3D, Unit, Gradient?> =
        MethodStringName1<CPUParticles3D, Unit, Gradient?>("set_color_ramp")

    @JvmField
    public val getColorRampName: MethodStringName0<CPUParticles3D, Gradient?> =
        MethodStringName0<CPUParticles3D, Gradient?>("get_color_ramp")

    @JvmField
    public val setColorInitialRampName: MethodStringName1<CPUParticles3D, Unit, Gradient?> =
        MethodStringName1<CPUParticles3D, Unit, Gradient?>("set_color_initial_ramp")

    @JvmField
    public val getColorInitialRampName: MethodStringName0<CPUParticles3D, Gradient?> =
        MethodStringName0<CPUParticles3D, Gradient?>("get_color_initial_ramp")

    @JvmField
    public val setParticleFlagName: MethodStringName2<CPUParticles3D, Unit, ParticleFlags, Boolean>
        = MethodStringName2<CPUParticles3D, Unit, ParticleFlags, Boolean>("set_particle_flag")

    @JvmField
    public val getParticleFlagName: MethodStringName1<CPUParticles3D, Boolean, ParticleFlags> =
        MethodStringName1<CPUParticles3D, Boolean, ParticleFlags>("get_particle_flag")

    @JvmField
    public val setEmissionShapeName: MethodStringName1<CPUParticles3D, Unit, EmissionShape> =
        MethodStringName1<CPUParticles3D, Unit, EmissionShape>("set_emission_shape")

    @JvmField
    public val getEmissionShapeName: MethodStringName0<CPUParticles3D, EmissionShape> =
        MethodStringName0<CPUParticles3D, EmissionShape>("get_emission_shape")

    @JvmField
    public val setEmissionSphereRadiusName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_emission_sphere_radius")

    @JvmField
    public val getEmissionSphereRadiusName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_emission_sphere_radius")

    @JvmField
    public val setEmissionBoxExtentsName: MethodStringName1<CPUParticles3D, Unit, Vector3> =
        MethodStringName1<CPUParticles3D, Unit, Vector3>("set_emission_box_extents")

    @JvmField
    public val getEmissionBoxExtentsName: MethodStringName0<CPUParticles3D, Vector3> =
        MethodStringName0<CPUParticles3D, Vector3>("get_emission_box_extents")

    @JvmField
    public val setEmissionPointsName: MethodStringName1<CPUParticles3D, Unit, PackedVector3Array> =
        MethodStringName1<CPUParticles3D, Unit, PackedVector3Array>("set_emission_points")

    @JvmField
    public val getEmissionPointsName: MethodStringName0<CPUParticles3D, PackedVector3Array> =
        MethodStringName0<CPUParticles3D, PackedVector3Array>("get_emission_points")

    @JvmField
    public val setEmissionNormalsName: MethodStringName1<CPUParticles3D, Unit, PackedVector3Array> =
        MethodStringName1<CPUParticles3D, Unit, PackedVector3Array>("set_emission_normals")

    @JvmField
    public val getEmissionNormalsName: MethodStringName0<CPUParticles3D, PackedVector3Array> =
        MethodStringName0<CPUParticles3D, PackedVector3Array>("get_emission_normals")

    @JvmField
    public val setEmissionColorsName: MethodStringName1<CPUParticles3D, Unit, PackedColorArray> =
        MethodStringName1<CPUParticles3D, Unit, PackedColorArray>("set_emission_colors")

    @JvmField
    public val getEmissionColorsName: MethodStringName0<CPUParticles3D, PackedColorArray> =
        MethodStringName0<CPUParticles3D, PackedColorArray>("get_emission_colors")

    @JvmField
    public val setEmissionRingAxisName: MethodStringName1<CPUParticles3D, Unit, Vector3> =
        MethodStringName1<CPUParticles3D, Unit, Vector3>("set_emission_ring_axis")

    @JvmField
    public val getEmissionRingAxisName: MethodStringName0<CPUParticles3D, Vector3> =
        MethodStringName0<CPUParticles3D, Vector3>("get_emission_ring_axis")

    @JvmField
    public val setEmissionRingHeightName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_emission_ring_height")

    @JvmField
    public val getEmissionRingHeightName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_emission_ring_height")

    @JvmField
    public val setEmissionRingRadiusName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_emission_ring_radius")

    @JvmField
    public val getEmissionRingRadiusName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_emission_ring_radius")

    @JvmField
    public val setEmissionRingInnerRadiusName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_emission_ring_inner_radius")

    @JvmField
    public val getEmissionRingInnerRadiusName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_emission_ring_inner_radius")

    @JvmField
    public val setEmissionRingConeAngleName: MethodStringName1<CPUParticles3D, Unit, Float> =
        MethodStringName1<CPUParticles3D, Unit, Float>("set_emission_ring_cone_angle")

    @JvmField
    public val getEmissionRingConeAngleName: MethodStringName0<CPUParticles3D, Float> =
        MethodStringName0<CPUParticles3D, Float>("get_emission_ring_cone_angle")

    @JvmField
    public val getGravityName: MethodStringName0<CPUParticles3D, Vector3> =
        MethodStringName0<CPUParticles3D, Vector3>("get_gravity")

    @JvmField
    public val setGravityName: MethodStringName1<CPUParticles3D, Unit, Vector3> =
        MethodStringName1<CPUParticles3D, Unit, Vector3>("set_gravity")

    @JvmField
    public val getSplitScaleName: MethodStringName0<CPUParticles3D, Boolean> =
        MethodStringName0<CPUParticles3D, Boolean>("get_split_scale")

    @JvmField
    public val setSplitScaleName: MethodStringName1<CPUParticles3D, Unit, Boolean> =
        MethodStringName1<CPUParticles3D, Unit, Boolean>("set_split_scale")

    @JvmField
    public val getScaleCurveXName: MethodStringName0<CPUParticles3D, Curve?> =
        MethodStringName0<CPUParticles3D, Curve?>("get_scale_curve_x")

    @JvmField
    public val setScaleCurveXName: MethodStringName1<CPUParticles3D, Unit, Curve?> =
        MethodStringName1<CPUParticles3D, Unit, Curve?>("set_scale_curve_x")

    @JvmField
    public val getScaleCurveYName: MethodStringName0<CPUParticles3D, Curve?> =
        MethodStringName0<CPUParticles3D, Curve?>("get_scale_curve_y")

    @JvmField
    public val setScaleCurveYName: MethodStringName1<CPUParticles3D, Unit, Curve?> =
        MethodStringName1<CPUParticles3D, Unit, Curve?>("set_scale_curve_y")

    @JvmField
    public val getScaleCurveZName: MethodStringName0<CPUParticles3D, Curve?> =
        MethodStringName0<CPUParticles3D, Curve?>("get_scale_curve_z")

    @JvmField
    public val setScaleCurveZName: MethodStringName1<CPUParticles3D, Unit, Curve?> =
        MethodStringName1<CPUParticles3D, Unit, Curve?>("set_scale_curve_z")

    @JvmField
    public val convertFromParticlesName: MethodStringName1<CPUParticles3D, Unit, Node?> =
        MethodStringName1<CPUParticles3D, Unit, Node?>("convert_from_particles")
  }

  public object MethodBindings {
    internal val setEmittingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emitting", 2586408642)

    internal val setAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_amount", 1286410249)

    internal val setLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_lifetime", 373806689)

    internal val setOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_one_shot", 2586408642)

    internal val setPreProcessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_pre_process_time", 373806689)

    internal val setExplosivenessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_explosiveness_ratio", 373806689)

    internal val setRandomnessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_randomness_ratio", 373806689)

    internal val setVisibilityAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_visibility_aabb", 259215842)

    internal val setLifetimeRandomnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_lifetime_randomness", 373806689)

    internal val setUseLocalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_use_local_coordinates", 2586408642)

    internal val setFixedFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_fixed_fps", 1286410249)

    internal val setFractionalDeltaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_fractional_delta", 2586408642)

    internal val setSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_speed_scale", 373806689)

    internal val isEmittingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "is_emitting", 36873697)

    internal val getAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_amount", 3905245786)

    internal val getLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_lifetime", 1740695150)

    internal val getOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_one_shot", 36873697)

    internal val getPreProcessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_pre_process_time", 1740695150)

    internal val getExplosivenessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_explosiveness_ratio", 1740695150)

    internal val getRandomnessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_randomness_ratio", 1740695150)

    internal val getVisibilityAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_visibility_aabb", 1068685055)

    internal val getLifetimeRandomnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_lifetime_randomness", 1740695150)

    internal val getUseLocalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_use_local_coordinates", 36873697)

    internal val getFixedFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_fixed_fps", 3905245786)

    internal val getFractionalDeltaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_fractional_delta", 36873697)

    internal val getSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_speed_scale", 1740695150)

    internal val setDrawOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_draw_order", 1427401774)

    internal val getDrawOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_draw_order", 1321900776)

    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_mesh", 194775623)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_mesh", 1808005922)

    internal val setUseFixedSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_use_fixed_seed", 2586408642)

    internal val getUseFixedSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_use_fixed_seed", 36873697)

    internal val setSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_seed", 1286410249)

    internal val getSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_seed", 3905245786)

    internal val restartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "restart", 107499316)

    internal val requestParticlesProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "request_particles_process", 66938510)

    internal val captureAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "capture_aabb", 1068685055)

    internal val setDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_direction", 3460891852)

    internal val getDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_direction", 3360562783)

    internal val setSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_spread", 373806689)

    internal val getSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_spread", 1740695150)

    internal val setFlatnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_flatness", 373806689)

    internal val getFlatnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_flatness", 1740695150)

    internal val setParamMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_param_min", 557936109)

    internal val getParamMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_param_min", 597646162)

    internal val setParamMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_param_max", 557936109)

    internal val getParamMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_param_max", 597646162)

    internal val setParamCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_param_curve", 4044142537)

    internal val getParamCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_param_curve", 4132790277)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_color", 2920490490)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_color", 3444240500)

    internal val setColorRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_color_ramp", 2756054477)

    internal val getColorRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_color_ramp", 132272999)

    internal val setColorInitialRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_color_initial_ramp", 2756054477)

    internal val getColorInitialRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_color_initial_ramp", 132272999)

    internal val setParticleFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_particle_flag", 3515406498)

    internal val getParticleFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_particle_flag", 2845201987)

    internal val setEmissionShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_shape", 491823814)

    internal val getEmissionShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_shape", 2961454842)

    internal val setEmissionSphereRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_sphere_radius", 373806689)

    internal val getEmissionSphereRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_sphere_radius", 1740695150)

    internal val setEmissionBoxExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_box_extents", 3460891852)

    internal val getEmissionBoxExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_box_extents", 3360562783)

    internal val setEmissionPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_points", 334873810)

    internal val getEmissionPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_points", 497664490)

    internal val setEmissionNormalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_normals", 334873810)

    internal val getEmissionNormalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_normals", 497664490)

    internal val setEmissionColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_colors", 3546319833)

    internal val getEmissionColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_colors", 1392750486)

    internal val setEmissionRingAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_ring_axis", 3460891852)

    internal val getEmissionRingAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_ring_axis", 3360562783)

    internal val setEmissionRingHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_ring_height", 373806689)

    internal val getEmissionRingHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_ring_height", 1740695150)

    internal val setEmissionRingRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_ring_radius", 373806689)

    internal val getEmissionRingRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_ring_radius", 1740695150)

    internal val setEmissionRingInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_ring_inner_radius", 373806689)

    internal val getEmissionRingInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_ring_inner_radius", 1740695150)

    internal val setEmissionRingConeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_emission_ring_cone_angle", 373806689)

    internal val getEmissionRingConeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_emission_ring_cone_angle", 1740695150)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_gravity", 3360562783)

    internal val setGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_gravity", 3460891852)

    internal val getSplitScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_split_scale", 2240911060)

    internal val setSplitScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_split_scale", 2586408642)

    internal val getScaleCurveXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_scale_curve_x", 2460114913)

    internal val setScaleCurveXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_scale_curve_x", 270443179)

    internal val getScaleCurveYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_scale_curve_y", 2460114913)

    internal val setScaleCurveYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_scale_curve_y", 270443179)

    internal val getScaleCurveZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "get_scale_curve_z", 2460114913)

    internal val setScaleCurveZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "set_scale_curve_z", 270443179)

    internal val convertFromParticlesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles3D", "convert_from_particles", 1078189570)
  }
}
