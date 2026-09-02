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
import godot.core.PackedColorArray
import godot.core.PackedVector2Array
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
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
 * CPU-based 2D particle node used to create a variety of particle systems and effects.
 *
 * See also [GPUParticles2D], which provides the same functionality with hardware acceleration, but
 * may not run on older devices.
 */
@GodotBaseType
public open class CPUParticles2D : Node2D() {
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
   * Particle texture. If `null`, particles will be squares.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
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
   * make the particles render at 2 frames per second. Note this does not slow down the simulation of
   * the particle system itself.
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
   * If `true`, particles use the parent node's coordinate space (known as local coordinates). This
   * will cause particles to move and rotate along the [CPUParticles2D] node (and its parents) when it
   * is moved or rotated. If `false`, particles use global coordinates; they will not move or rotate
   * along the [CPUParticles2D] node (and its parents) when it is moved or rotated.
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
   * The rectangle's extents if [emissionShape] is set to [EMISSION_SHAPE_RECTANGLE].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var emissionRectExtents: Vector2
    @JvmName("emissionRectExtentsProperty")
    get() = getEmissionRectExtents()
    @JvmName("emissionRectExtentsProperty")
    set(`value`) {
      setEmissionRectExtents(value)
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
  public final inline var emissionPoints: PackedVector2Array
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
  public final inline var emissionNormals: PackedVector2Array
    @JvmName("emissionNormalsProperty")
    get() = getEmissionNormals()
    @JvmName("emissionNormalsProperty")
    set(`value`) {
      setEmissionNormals(value)
    }

  /**
   * Sets the [Color]s to modulate particles by when using [EMISSION_SHAPE_POINTS] or
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   */
  public final inline var emissionColors: PackedColorArray
    @JvmName("emissionColorsProperty")
    get() = getEmissionColors()
    @JvmName("emissionColorsProperty")
    set(`value`) {
      setEmissionColors(value)
    }

  /**
   * The ring's inner radius if [emissionShape] is set to [EMISSION_SHAPE_RING].
   */
  public final inline var emissionRingInnerRadius: Float
    @JvmName("emissionRingInnerRadiusProperty")
    get() = getEmissionRingInnerRadius()
    @JvmName("emissionRingInnerRadiusProperty")
    set(`value`) {
      setEmissionRingInnerRadius(value)
    }

  /**
   * The ring's outer radius if [emissionShape] is set to [EMISSION_SHAPE_RING].
   */
  public final inline var emissionRingRadius: Float
    @JvmName("emissionRingRadiusProperty")
    get() = getEmissionRingRadius()
    @JvmName("emissionRingRadiusProperty")
    set(`value`) {
      setEmissionRingRadius(value)
    }

  /**
   * Align Y axis of particle with the direction of its velocity.
   */
  public final inline var particleFlagAlignY: Boolean
    @JvmName("particleFlagAlignYProperty")
    get() = getParticleFlag(CPUParticles2D.ParticleFlags.ALIGN_Y_TO_VELOCITY)
    @JvmName("particleFlagAlignYProperty")
    set(`value`) {
      setParticleFlag(CPUParticles2D.ParticleFlags.ALIGN_Y_TO_VELOCITY, value)
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
  public final inline var direction: Vector2
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
  public final inline var gravity: Vector2
    @JvmName("gravityProperty")
    get() = getGravity()
    @JvmName("gravityProperty")
    set(`value`) {
      setGravity(value)
    }

  /**
   * Minimum equivalent of [initialVelocityMax].
   */
  public final inline var initialVelocityMin: Float
    @JvmName("initialVelocityMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.INITIAL_LINEAR_VELOCITY)
    @JvmName("initialVelocityMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.INITIAL_LINEAR_VELOCITY, value)
    }

  /**
   * Maximum initial velocity magnitude for each particle. Direction comes from [direction] and
   * [spread].
   */
  public final inline var initialVelocityMax: Float
    @JvmName("initialVelocityMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.INITIAL_LINEAR_VELOCITY)
    @JvmName("initialVelocityMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.INITIAL_LINEAR_VELOCITY, value)
    }

  /**
   * Minimum equivalent of [angularVelocityMax].
   */
  public final inline var angularVelocityMin: Float
    @JvmName("angularVelocityMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Maximum initial angular velocity (rotation speed) applied to each particle in *degrees* per
   * second.
   */
  public final inline var angularVelocityMax: Float
    @JvmName("angularVelocityMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Each particle's angular velocity will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var angularVelocityCurve: Curve?
    @JvmName("angularVelocityCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.ANGULAR_VELOCITY)
    @JvmName("angularVelocityCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.ANGULAR_VELOCITY, value)
    }

  /**
   * Minimum equivalent of [orbitVelocityMax].
   */
  public final inline var orbitVelocityMin: Float
    @JvmName("orbitVelocityMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Maximum orbital velocity applied to each particle. Makes the particles circle around origin.
   * Specified in number of full rotations around origin per second.
   */
  public final inline var orbitVelocityMax: Float
    @JvmName("orbitVelocityMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Each particle's orbital velocity will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var orbitVelocityCurve: Curve?
    @JvmName("orbitVelocityCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.ORBIT_VELOCITY)
    @JvmName("orbitVelocityCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.ORBIT_VELOCITY, value)
    }

  /**
   * Minimum equivalent of [linearAccelMax].
   */
  public final inline var linearAccelMin: Float
    @JvmName("linearAccelMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Maximum linear acceleration applied to each particle in the direction of motion.
   */
  public final inline var linearAccelMax: Float
    @JvmName("linearAccelMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Each particle's linear acceleration will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var linearAccelCurve: Curve?
    @JvmName("linearAccelCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.LINEAR_ACCEL)
    @JvmName("linearAccelCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.LINEAR_ACCEL, value)
    }

  /**
   * Minimum equivalent of [radialAccelMax].
   */
  public final inline var radialAccelMin: Float
    @JvmName("radialAccelMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Maximum radial acceleration applied to each particle. Makes particle accelerate away from the
   * origin or towards it if negative.
   */
  public final inline var radialAccelMax: Float
    @JvmName("radialAccelMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Each particle's radial acceleration will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var radialAccelCurve: Curve?
    @JvmName("radialAccelCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.RADIAL_ACCEL)
    @JvmName("radialAccelCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.RADIAL_ACCEL, value)
    }

  /**
   * Minimum equivalent of [tangentialAccelMax].
   */
  public final inline var tangentialAccelMin: Float
    @JvmName("tangentialAccelMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Maximum tangential acceleration applied to each particle. Tangential acceleration is
   * perpendicular to the particle's velocity giving the particles a swirling motion.
   */
  public final inline var tangentialAccelMax: Float
    @JvmName("tangentialAccelMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Each particle's tangential acceleration will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var tangentialAccelCurve: Curve?
    @JvmName("tangentialAccelCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.TANGENTIAL_ACCEL)
    @JvmName("tangentialAccelCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.TANGENTIAL_ACCEL, value)
    }

  /**
   * Minimum equivalent of [dampingMax].
   */
  public final inline var dampingMin: Float
    @JvmName("dampingMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.DAMPING)
    @JvmName("dampingMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.DAMPING, value)
    }

  /**
   * The maximum rate at which particles lose velocity. For example value of `100` means that the
   * particle will go from `100` velocity to `0` in `1` second.
   */
  public final inline var dampingMax: Float
    @JvmName("dampingMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.DAMPING)
    @JvmName("dampingMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.DAMPING, value)
    }

  /**
   * Damping will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var dampingCurve: Curve?
    @JvmName("dampingCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.DAMPING)
    @JvmName("dampingCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.DAMPING, value)
    }

  /**
   * Minimum equivalent of [angleMax].
   */
  public final inline var angleMin: Float
    @JvmName("angleMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.ANGLE)
    @JvmName("angleMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.ANGLE, value)
    }

  /**
   * Maximum initial rotation applied to each particle, in degrees.
   */
  public final inline var angleMax: Float
    @JvmName("angleMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.ANGLE)
    @JvmName("angleMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.ANGLE, value)
    }

  /**
   * Each particle's rotation will be animated along this [Curve]. Should be a unit [Curve].
   */
  public final inline var angleCurve: Curve?
    @JvmName("angleCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.ANGLE)
    @JvmName("angleCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.ANGLE, value)
    }

  /**
   * Minimum equivalent of [scaleAmountMax].
   */
  public final inline var scaleAmountMin: Float
    @JvmName("scaleAmountMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.SCALE)
    @JvmName("scaleAmountMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.SCALE, value)
    }

  /**
   * Maximum initial scale applied to each particle.
   */
  public final inline var scaleAmountMax: Float
    @JvmName("scaleAmountMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.SCALE)
    @JvmName("scaleAmountMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.SCALE, value)
    }

  /**
   * Each particle's scale will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var scaleAmountCurve: Curve?
    @JvmName("scaleAmountCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.SCALE)
    @JvmName("scaleAmountCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.SCALE, value)
    }

  /**
   * If `true`, the scale curve will be split into x and y components. See [scaleCurveX] and
   * [scaleCurveY].
   */
  public final inline var splitScale: Boolean
    @JvmName("splitScaleProperty")
    get() = getSplitScale()
    @JvmName("splitScaleProperty")
    set(`value`) {
      setSplitScale(value)
    }

  /**
   * Each particle's horizontal scale will vary along this [Curve]. Should be a unit [Curve].
   *
   * [splitScale] must be enabled.
   */
  public final inline var scaleCurveX: Curve?
    @JvmName("scaleCurveXProperty")
    get() = getScaleCurveX()
    @JvmName("scaleCurveXProperty")
    set(`value`) {
      setScaleCurveX(value)
    }

  /**
   * Each particle's vertical scale will vary along this [Curve]. Should be a unit [Curve].
   *
   * [splitScale] must be enabled.
   */
  public final inline var scaleCurveY: Curve?
    @JvmName("scaleCurveYProperty")
    get() = getScaleCurveY()
    @JvmName("scaleCurveYProperty")
    set(`value`) {
      setScaleCurveY(value)
    }

  /**
   * Each particle's initial color. If [texture] is defined, it will be multiplied by this color.
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
   */
  public final inline var colorInitialRamp: Gradient?
    @JvmName("colorInitialRampProperty")
    get() = getColorInitialRamp()
    @JvmName("colorInitialRampProperty")
    set(`value`) {
      setColorInitialRamp(value)
    }

  /**
   * Minimum equivalent of [hueVariationMax].
   */
  public final inline var hueVariationMin: Float
    @JvmName("hueVariationMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.HUE_VARIATION)
    @JvmName("hueVariationMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.HUE_VARIATION, value)
    }

  /**
   * Maximum initial hue variation applied to each particle. It will shift the particle color's hue.
   */
  public final inline var hueVariationMax: Float
    @JvmName("hueVariationMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.HUE_VARIATION)
    @JvmName("hueVariationMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.HUE_VARIATION, value)
    }

  /**
   * Each particle's hue will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var hueVariationCurve: Curve?
    @JvmName("hueVariationCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.HUE_VARIATION)
    @JvmName("hueVariationCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.HUE_VARIATION, value)
    }

  /**
   * Minimum equivalent of [animSpeedMax].
   */
  public final inline var animSpeedMin: Float
    @JvmName("animSpeedMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.ANIM_SPEED)
    @JvmName("animSpeedMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.ANIM_SPEED, value)
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
    get() = getParamMax(CPUParticles2D.Parameter.ANIM_SPEED)
    @JvmName("animSpeedMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.ANIM_SPEED, value)
    }

  /**
   * Each particle's animation speed will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var animSpeedCurve: Curve?
    @JvmName("animSpeedCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.ANIM_SPEED)
    @JvmName("animSpeedCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.ANIM_SPEED, value)
    }

  /**
   * Minimum equivalent of [animOffsetMax].
   */
  public final inline var animOffsetMin: Float
    @JvmName("animOffsetMinProperty")
    get() = getParamMin(CPUParticles2D.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetMinProperty")
    set(`value`) {
      setParamMin(CPUParticles2D.Parameter.ANIM_OFFSET, value)
    }

  /**
   * Maximum animation offset that corresponds to frame index in the texture. `0` is the first
   * frame, `1` is the last one. See [CanvasItemMaterial.particlesAnimation].
   */
  public final inline var animOffsetMax: Float
    @JvmName("animOffsetMaxProperty")
    get() = getParamMax(CPUParticles2D.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetMaxProperty")
    set(`value`) {
      setParamMax(CPUParticles2D.Parameter.ANIM_OFFSET, value)
    }

  /**
   * Each particle's animation offset will vary along this [Curve]. Should be a unit [Curve].
   */
  public final inline var animOffsetCurve: Curve?
    @JvmName("animOffsetCurveProperty")
    get() = getParamCurve(CPUParticles2D.Parameter.ANIM_OFFSET)
    @JvmName("animOffsetCurveProperty")
    set(`value`) {
      setParamCurve(CPUParticles2D.Parameter.ANIM_OFFSET, value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(123, scriptPtr)
  }

  /**
   * This is a helper function for [emissionRectExtents] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles2d.emissionRectExtents
   * //Your changes
   * cpuparticles2d.emissionRectExtents = myCoreType
   * ``````
   *
   * The rectangle's extents if [emissionShape] is set to [EMISSION_SHAPE_RECTANGLE].
   */
  @CoreTypeHelper
  public final fun emissionRectExtentsMutate(block: Vector2.() -> Unit): Vector2 =
      emissionRectExtents.apply {
     block(this)
     emissionRectExtents = this
  }

  /**
   * This is a helper function for [emissionPoints] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles2d.emissionPoints
   * //Your changes
   * cpuparticles2d.emissionPoints = myCoreType
   * ``````
   *
   * Sets the initial positions to spawn particles when using [EMISSION_SHAPE_POINTS] or
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   */
  @CoreTypeHelper
  public final fun emissionPointsMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
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
  public final fun emissionPointsMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = emissionPoints.apply {
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
   * val myCoreType = cpuparticles2d.emissionNormals
   * //Your changes
   * cpuparticles2d.emissionNormals = myCoreType
   * ``````
   *
   * Sets the direction the particles will be emitted in when using
   * [EMISSION_SHAPE_DIRECTED_POINTS].
   */
  @CoreTypeHelper
  public final fun emissionNormalsMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
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
  public final fun emissionNormalsMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = emissionNormals.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     emissionNormals = this
  }

  /**
   * This is a helper function for [direction] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles2d.direction
   * //Your changes
   * cpuparticles2d.direction = myCoreType
   * ``````
   *
   * Unit vector specifying the particles' emission direction.
   */
  @CoreTypeHelper
  public final fun directionMutate(block: Vector2.() -> Unit): Vector2 = direction.apply {
     block(this)
     direction = this
  }

  /**
   * This is a helper function for [gravity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles2d.gravity
   * //Your changes
   * cpuparticles2d.gravity = myCoreType
   * ``````
   *
   * Gravity applied to every particle.
   */
  @CoreTypeHelper
  public final fun gravityMutate(block: Vector2.() -> Unit): Vector2 = gravity.apply {
     block(this)
     gravity = this
  }

  /**
   * This is a helper function for [color] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = cpuparticles2d.color
   * //Your changes
   * cpuparticles2d.color = myCoreType
   * ``````
   *
   * Each particle's initial color. If [texture] is defined, it will be multiplied by this color.
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

  public final fun setDrawOrder(order: DrawOrder): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to order.value)
    TransferContext.callMethod(MethodBindings.setDrawOrderPtr)
  }

  public final fun getDrawOrder(): DrawOrder {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDrawOrderPtr)
    return DrawOrder.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  public final fun getTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
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

  public final fun setDirection(direction: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to direction)
    TransferContext.callMethod(MethodBindings.setDirectionPtr)
  }

  public final fun getDirection(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDirectionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setSpread(spread: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to spread.toDouble())
    TransferContext.callMethod(MethodBindings.setSpreadPtr)
  }

  public final fun getSpread(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpreadPtr)
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

  public final fun setEmissionRectExtents(extents: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to extents)
    TransferContext.callMethod(MethodBindings.setEmissionRectExtentsPtr)
  }

  public final fun getEmissionRectExtents(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionRectExtentsPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setEmissionPoints(array: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to array)
    TransferContext.callMethod(MethodBindings.setEmissionPointsPtr)
  }

  public final fun getEmissionPoints(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionPointsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  public final fun setEmissionNormals(array: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to array)
    TransferContext.callMethod(MethodBindings.setEmissionNormalsPtr)
  }

  public final fun getEmissionNormals(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionNormalsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
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

  public final fun setEmissionRingInnerRadius(innerRadius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to innerRadius.toDouble())
    TransferContext.callMethod(MethodBindings.setEmissionRingInnerRadiusPtr)
  }

  public final fun getEmissionRingInnerRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEmissionRingInnerRadiusPtr)
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

  public final fun getGravity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setGravity(accelVec: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to accelVec)
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

  /**
   * Sets this node's properties to match a given [GPUParticles2D] node with an assigned
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
     * Present for consistency with 3D particle nodes, not used in 2D.
     */
    ROTATE_Y(1),
    /**
     * Present for consistency with 3D particle nodes, not used in 2D.
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
     * Particles will be emitted in the volume of a sphere flattened to two dimensions.
     */
    SPHERE(1),
    /**
     * Particles will be emitted on the surface of a sphere flattened to two dimensions.
     */
    SPHERE_SURFACE(2),
    /**
     * Particles will be emitted in the area of a rectangle.
     */
    RECTANGLE(3),
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
     * Particles will be emitted in the area of a ring parameterized by its outer and inner radius.
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
    public val setEmittingName: MethodStringName1<CPUParticles2D, Unit, Boolean> =
        MethodStringName1<CPUParticles2D, Unit, Boolean>("set_emitting")

    @JvmField
    public val setAmountName: MethodStringName1<CPUParticles2D, Unit, Int> =
        MethodStringName1<CPUParticles2D, Unit, Int>("set_amount")

    @JvmField
    public val setLifetimeName: MethodStringName1<CPUParticles2D, Unit, Double> =
        MethodStringName1<CPUParticles2D, Unit, Double>("set_lifetime")

    @JvmField
    public val setOneShotName: MethodStringName1<CPUParticles2D, Unit, Boolean> =
        MethodStringName1<CPUParticles2D, Unit, Boolean>("set_one_shot")

    @JvmField
    public val setPreProcessTimeName: MethodStringName1<CPUParticles2D, Unit, Double> =
        MethodStringName1<CPUParticles2D, Unit, Double>("set_pre_process_time")

    @JvmField
    public val setExplosivenessRatioName: MethodStringName1<CPUParticles2D, Unit, Float> =
        MethodStringName1<CPUParticles2D, Unit, Float>("set_explosiveness_ratio")

    @JvmField
    public val setRandomnessRatioName: MethodStringName1<CPUParticles2D, Unit, Float> =
        MethodStringName1<CPUParticles2D, Unit, Float>("set_randomness_ratio")

    @JvmField
    public val setLifetimeRandomnessName: MethodStringName1<CPUParticles2D, Unit, Double> =
        MethodStringName1<CPUParticles2D, Unit, Double>("set_lifetime_randomness")

    @JvmField
    public val setUseLocalCoordinatesName: MethodStringName1<CPUParticles2D, Unit, Boolean> =
        MethodStringName1<CPUParticles2D, Unit, Boolean>("set_use_local_coordinates")

    @JvmField
    public val setFixedFpsName: MethodStringName1<CPUParticles2D, Unit, Int> =
        MethodStringName1<CPUParticles2D, Unit, Int>("set_fixed_fps")

    @JvmField
    public val setFractionalDeltaName: MethodStringName1<CPUParticles2D, Unit, Boolean> =
        MethodStringName1<CPUParticles2D, Unit, Boolean>("set_fractional_delta")

    @JvmField
    public val setSpeedScaleName: MethodStringName1<CPUParticles2D, Unit, Double> =
        MethodStringName1<CPUParticles2D, Unit, Double>("set_speed_scale")

    @JvmField
    public val requestParticlesProcessName: MethodStringName2<CPUParticles2D, Unit, Float, Float> =
        MethodStringName2<CPUParticles2D, Unit, Float, Float>("request_particles_process")

    @JvmField
    public val isEmittingName: MethodStringName0<CPUParticles2D, Boolean> =
        MethodStringName0<CPUParticles2D, Boolean>("is_emitting")

    @JvmField
    public val getAmountName: MethodStringName0<CPUParticles2D, Int> =
        MethodStringName0<CPUParticles2D, Int>("get_amount")

    @JvmField
    public val getLifetimeName: MethodStringName0<CPUParticles2D, Double> =
        MethodStringName0<CPUParticles2D, Double>("get_lifetime")

    @JvmField
    public val getOneShotName: MethodStringName0<CPUParticles2D, Boolean> =
        MethodStringName0<CPUParticles2D, Boolean>("get_one_shot")

    @JvmField
    public val getPreProcessTimeName: MethodStringName0<CPUParticles2D, Double> =
        MethodStringName0<CPUParticles2D, Double>("get_pre_process_time")

    @JvmField
    public val getExplosivenessRatioName: MethodStringName0<CPUParticles2D, Float> =
        MethodStringName0<CPUParticles2D, Float>("get_explosiveness_ratio")

    @JvmField
    public val getRandomnessRatioName: MethodStringName0<CPUParticles2D, Float> =
        MethodStringName0<CPUParticles2D, Float>("get_randomness_ratio")

    @JvmField
    public val getLifetimeRandomnessName: MethodStringName0<CPUParticles2D, Double> =
        MethodStringName0<CPUParticles2D, Double>("get_lifetime_randomness")

    @JvmField
    public val getUseLocalCoordinatesName: MethodStringName0<CPUParticles2D, Boolean> =
        MethodStringName0<CPUParticles2D, Boolean>("get_use_local_coordinates")

    @JvmField
    public val getFixedFpsName: MethodStringName0<CPUParticles2D, Int> =
        MethodStringName0<CPUParticles2D, Int>("get_fixed_fps")

    @JvmField
    public val getFractionalDeltaName: MethodStringName0<CPUParticles2D, Boolean> =
        MethodStringName0<CPUParticles2D, Boolean>("get_fractional_delta")

    @JvmField
    public val getSpeedScaleName: MethodStringName0<CPUParticles2D, Double> =
        MethodStringName0<CPUParticles2D, Double>("get_speed_scale")

    @JvmField
    public val setUseFixedSeedName: MethodStringName1<CPUParticles2D, Unit, Boolean> =
        MethodStringName1<CPUParticles2D, Unit, Boolean>("set_use_fixed_seed")

    @JvmField
    public val getUseFixedSeedName: MethodStringName0<CPUParticles2D, Boolean> =
        MethodStringName0<CPUParticles2D, Boolean>("get_use_fixed_seed")

    @JvmField
    public val setSeedName: MethodStringName1<CPUParticles2D, Unit, Long> =
        MethodStringName1<CPUParticles2D, Unit, Long>("set_seed")

    @JvmField
    public val getSeedName: MethodStringName0<CPUParticles2D, Long> =
        MethodStringName0<CPUParticles2D, Long>("get_seed")

    @JvmField
    public val setDrawOrderName: MethodStringName1<CPUParticles2D, Unit, DrawOrder> =
        MethodStringName1<CPUParticles2D, Unit, DrawOrder>("set_draw_order")

    @JvmField
    public val getDrawOrderName: MethodStringName0<CPUParticles2D, DrawOrder> =
        MethodStringName0<CPUParticles2D, DrawOrder>("get_draw_order")

    @JvmField
    public val setTextureName: MethodStringName1<CPUParticles2D, Unit, Texture2D?> =
        MethodStringName1<CPUParticles2D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<CPUParticles2D, Texture2D?> =
        MethodStringName0<CPUParticles2D, Texture2D?>("get_texture")

    @JvmField
    public val restartName: MethodStringName1<CPUParticles2D, Unit, Boolean> =
        MethodStringName1<CPUParticles2D, Unit, Boolean>("restart")

    @JvmField
    public val setDirectionName: MethodStringName1<CPUParticles2D, Unit, Vector2> =
        MethodStringName1<CPUParticles2D, Unit, Vector2>("set_direction")

    @JvmField
    public val getDirectionName: MethodStringName0<CPUParticles2D, Vector2> =
        MethodStringName0<CPUParticles2D, Vector2>("get_direction")

    @JvmField
    public val setSpreadName: MethodStringName1<CPUParticles2D, Unit, Float> =
        MethodStringName1<CPUParticles2D, Unit, Float>("set_spread")

    @JvmField
    public val getSpreadName: MethodStringName0<CPUParticles2D, Float> =
        MethodStringName0<CPUParticles2D, Float>("get_spread")

    @JvmField
    public val setParamMinName: MethodStringName2<CPUParticles2D, Unit, Parameter, Float> =
        MethodStringName2<CPUParticles2D, Unit, Parameter, Float>("set_param_min")

    @JvmField
    public val getParamMinName: MethodStringName1<CPUParticles2D, Float, Parameter> =
        MethodStringName1<CPUParticles2D, Float, Parameter>("get_param_min")

    @JvmField
    public val setParamMaxName: MethodStringName2<CPUParticles2D, Unit, Parameter, Float> =
        MethodStringName2<CPUParticles2D, Unit, Parameter, Float>("set_param_max")

    @JvmField
    public val getParamMaxName: MethodStringName1<CPUParticles2D, Float, Parameter> =
        MethodStringName1<CPUParticles2D, Float, Parameter>("get_param_max")

    @JvmField
    public val setParamCurveName: MethodStringName2<CPUParticles2D, Unit, Parameter, Curve?> =
        MethodStringName2<CPUParticles2D, Unit, Parameter, Curve?>("set_param_curve")

    @JvmField
    public val getParamCurveName: MethodStringName1<CPUParticles2D, Curve?, Parameter> =
        MethodStringName1<CPUParticles2D, Curve?, Parameter>("get_param_curve")

    @JvmField
    public val setColorName: MethodStringName1<CPUParticles2D, Unit, Color> =
        MethodStringName1<CPUParticles2D, Unit, Color>("set_color")

    @JvmField
    public val getColorName: MethodStringName0<CPUParticles2D, Color> =
        MethodStringName0<CPUParticles2D, Color>("get_color")

    @JvmField
    public val setColorRampName: MethodStringName1<CPUParticles2D, Unit, Gradient?> =
        MethodStringName1<CPUParticles2D, Unit, Gradient?>("set_color_ramp")

    @JvmField
    public val getColorRampName: MethodStringName0<CPUParticles2D, Gradient?> =
        MethodStringName0<CPUParticles2D, Gradient?>("get_color_ramp")

    @JvmField
    public val setColorInitialRampName: MethodStringName1<CPUParticles2D, Unit, Gradient?> =
        MethodStringName1<CPUParticles2D, Unit, Gradient?>("set_color_initial_ramp")

    @JvmField
    public val getColorInitialRampName: MethodStringName0<CPUParticles2D, Gradient?> =
        MethodStringName0<CPUParticles2D, Gradient?>("get_color_initial_ramp")

    @JvmField
    public val setParticleFlagName: MethodStringName2<CPUParticles2D, Unit, ParticleFlags, Boolean>
        = MethodStringName2<CPUParticles2D, Unit, ParticleFlags, Boolean>("set_particle_flag")

    @JvmField
    public val getParticleFlagName: MethodStringName1<CPUParticles2D, Boolean, ParticleFlags> =
        MethodStringName1<CPUParticles2D, Boolean, ParticleFlags>("get_particle_flag")

    @JvmField
    public val setEmissionShapeName: MethodStringName1<CPUParticles2D, Unit, EmissionShape> =
        MethodStringName1<CPUParticles2D, Unit, EmissionShape>("set_emission_shape")

    @JvmField
    public val getEmissionShapeName: MethodStringName0<CPUParticles2D, EmissionShape> =
        MethodStringName0<CPUParticles2D, EmissionShape>("get_emission_shape")

    @JvmField
    public val setEmissionSphereRadiusName: MethodStringName1<CPUParticles2D, Unit, Float> =
        MethodStringName1<CPUParticles2D, Unit, Float>("set_emission_sphere_radius")

    @JvmField
    public val getEmissionSphereRadiusName: MethodStringName0<CPUParticles2D, Float> =
        MethodStringName0<CPUParticles2D, Float>("get_emission_sphere_radius")

    @JvmField
    public val setEmissionRectExtentsName: MethodStringName1<CPUParticles2D, Unit, Vector2> =
        MethodStringName1<CPUParticles2D, Unit, Vector2>("set_emission_rect_extents")

    @JvmField
    public val getEmissionRectExtentsName: MethodStringName0<CPUParticles2D, Vector2> =
        MethodStringName0<CPUParticles2D, Vector2>("get_emission_rect_extents")

    @JvmField
    public val setEmissionPointsName: MethodStringName1<CPUParticles2D, Unit, PackedVector2Array> =
        MethodStringName1<CPUParticles2D, Unit, PackedVector2Array>("set_emission_points")

    @JvmField
    public val getEmissionPointsName: MethodStringName0<CPUParticles2D, PackedVector2Array> =
        MethodStringName0<CPUParticles2D, PackedVector2Array>("get_emission_points")

    @JvmField
    public val setEmissionNormalsName: MethodStringName1<CPUParticles2D, Unit, PackedVector2Array> =
        MethodStringName1<CPUParticles2D, Unit, PackedVector2Array>("set_emission_normals")

    @JvmField
    public val getEmissionNormalsName: MethodStringName0<CPUParticles2D, PackedVector2Array> =
        MethodStringName0<CPUParticles2D, PackedVector2Array>("get_emission_normals")

    @JvmField
    public val setEmissionColorsName: MethodStringName1<CPUParticles2D, Unit, PackedColorArray> =
        MethodStringName1<CPUParticles2D, Unit, PackedColorArray>("set_emission_colors")

    @JvmField
    public val getEmissionColorsName: MethodStringName0<CPUParticles2D, PackedColorArray> =
        MethodStringName0<CPUParticles2D, PackedColorArray>("get_emission_colors")

    @JvmField
    public val setEmissionRingInnerRadiusName: MethodStringName1<CPUParticles2D, Unit, Float> =
        MethodStringName1<CPUParticles2D, Unit, Float>("set_emission_ring_inner_radius")

    @JvmField
    public val getEmissionRingInnerRadiusName: MethodStringName0<CPUParticles2D, Float> =
        MethodStringName0<CPUParticles2D, Float>("get_emission_ring_inner_radius")

    @JvmField
    public val setEmissionRingRadiusName: MethodStringName1<CPUParticles2D, Unit, Float> =
        MethodStringName1<CPUParticles2D, Unit, Float>("set_emission_ring_radius")

    @JvmField
    public val getEmissionRingRadiusName: MethodStringName0<CPUParticles2D, Float> =
        MethodStringName0<CPUParticles2D, Float>("get_emission_ring_radius")

    @JvmField
    public val getGravityName: MethodStringName0<CPUParticles2D, Vector2> =
        MethodStringName0<CPUParticles2D, Vector2>("get_gravity")

    @JvmField
    public val setGravityName: MethodStringName1<CPUParticles2D, Unit, Vector2> =
        MethodStringName1<CPUParticles2D, Unit, Vector2>("set_gravity")

    @JvmField
    public val getSplitScaleName: MethodStringName0<CPUParticles2D, Boolean> =
        MethodStringName0<CPUParticles2D, Boolean>("get_split_scale")

    @JvmField
    public val setSplitScaleName: MethodStringName1<CPUParticles2D, Unit, Boolean> =
        MethodStringName1<CPUParticles2D, Unit, Boolean>("set_split_scale")

    @JvmField
    public val getScaleCurveXName: MethodStringName0<CPUParticles2D, Curve?> =
        MethodStringName0<CPUParticles2D, Curve?>("get_scale_curve_x")

    @JvmField
    public val setScaleCurveXName: MethodStringName1<CPUParticles2D, Unit, Curve?> =
        MethodStringName1<CPUParticles2D, Unit, Curve?>("set_scale_curve_x")

    @JvmField
    public val getScaleCurveYName: MethodStringName0<CPUParticles2D, Curve?> =
        MethodStringName0<CPUParticles2D, Curve?>("get_scale_curve_y")

    @JvmField
    public val setScaleCurveYName: MethodStringName1<CPUParticles2D, Unit, Curve?> =
        MethodStringName1<CPUParticles2D, Unit, Curve?>("set_scale_curve_y")

    @JvmField
    public val convertFromParticlesName: MethodStringName1<CPUParticles2D, Unit, Node?> =
        MethodStringName1<CPUParticles2D, Unit, Node?>("convert_from_particles")
  }

  public object MethodBindings {
    internal val setEmittingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emitting", 2586408642)

    internal val setAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_amount", 1286410249)

    internal val setLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_lifetime", 373806689)

    internal val setOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_one_shot", 2586408642)

    internal val setPreProcessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_pre_process_time", 373806689)

    internal val setExplosivenessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_explosiveness_ratio", 373806689)

    internal val setRandomnessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_randomness_ratio", 373806689)

    internal val setLifetimeRandomnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_lifetime_randomness", 373806689)

    internal val setUseLocalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_use_local_coordinates", 2586408642)

    internal val setFixedFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_fixed_fps", 1286410249)

    internal val setFractionalDeltaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_fractional_delta", 2586408642)

    internal val setSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_speed_scale", 373806689)

    internal val requestParticlesProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "request_particles_process", 66938510)

    internal val isEmittingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "is_emitting", 36873697)

    internal val getAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_amount", 3905245786)

    internal val getLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_lifetime", 1740695150)

    internal val getOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_one_shot", 36873697)

    internal val getPreProcessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_pre_process_time", 1740695150)

    internal val getExplosivenessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_explosiveness_ratio", 1740695150)

    internal val getRandomnessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_randomness_ratio", 1740695150)

    internal val getLifetimeRandomnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_lifetime_randomness", 1740695150)

    internal val getUseLocalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_use_local_coordinates", 36873697)

    internal val getFixedFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_fixed_fps", 3905245786)

    internal val getFractionalDeltaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_fractional_delta", 36873697)

    internal val getSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_speed_scale", 1740695150)

    internal val setUseFixedSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_use_fixed_seed", 2586408642)

    internal val getUseFixedSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_use_fixed_seed", 36873697)

    internal val setSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_seed", 1286410249)

    internal val getSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_seed", 3905245786)

    internal val setDrawOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_draw_order", 4183193490)

    internal val getDrawOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_draw_order", 1668655735)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_texture", 3635182373)

    internal val restartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "restart", 107499316)

    internal val setDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_direction", 743155724)

    internal val getDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_direction", 3341600327)

    internal val setSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_spread", 373806689)

    internal val getSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_spread", 1740695150)

    internal val setParamMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_param_min", 3320615296)

    internal val getParamMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_param_min", 2038050600)

    internal val setParamMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_param_max", 3320615296)

    internal val getParamMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_param_max", 2038050600)

    internal val setParamCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_param_curve", 2959350143)

    internal val getParamCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_param_curve", 2603158474)

    internal val setColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_color", 2920490490)

    internal val getColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_color", 3444240500)

    internal val setColorRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_color_ramp", 2756054477)

    internal val getColorRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_color_ramp", 132272999)

    internal val setColorInitialRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_color_initial_ramp", 2756054477)

    internal val getColorInitialRampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_color_initial_ramp", 132272999)

    internal val setParticleFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_particle_flag", 4178137949)

    internal val getParticleFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_particle_flag", 2829976507)

    internal val setEmissionShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emission_shape", 393763892)

    internal val getEmissionShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_emission_shape", 1740246024)

    internal val setEmissionSphereRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emission_sphere_radius", 373806689)

    internal val getEmissionSphereRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_emission_sphere_radius", 1740695150)

    internal val setEmissionRectExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emission_rect_extents", 743155724)

    internal val getEmissionRectExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_emission_rect_extents", 3341600327)

    internal val setEmissionPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emission_points", 1509147220)

    internal val getEmissionPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_emission_points", 2961356807)

    internal val setEmissionNormalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emission_normals", 1509147220)

    internal val getEmissionNormalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_emission_normals", 2961356807)

    internal val setEmissionColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emission_colors", 3546319833)

    internal val getEmissionColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_emission_colors", 1392750486)

    internal val setEmissionRingInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emission_ring_inner_radius", 373806689)

    internal val getEmissionRingInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_emission_ring_inner_radius", 1740695150)

    internal val setEmissionRingRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_emission_ring_radius", 373806689)

    internal val getEmissionRingRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_emission_ring_radius", 1740695150)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_gravity", 3341600327)

    internal val setGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_gravity", 743155724)

    internal val getSplitScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_split_scale", 2240911060)

    internal val setSplitScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_split_scale", 2586408642)

    internal val getScaleCurveXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_scale_curve_x", 2460114913)

    internal val setScaleCurveXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_scale_curve_x", 270443179)

    internal val getScaleCurveYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "get_scale_curve_y", 2460114913)

    internal val setScaleCurveYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "set_scale_curve_y", 270443179)

    internal val convertFromParticlesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CPUParticles2D", "convert_from_particles", 1078189570)
  }
}
