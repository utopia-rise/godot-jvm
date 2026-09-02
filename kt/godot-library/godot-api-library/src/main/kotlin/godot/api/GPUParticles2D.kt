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
import godot.core.MethodStringName5
import godot.core.NodePath
import godot.core.Rect2
import godot.core.Signal0
import godot.core.Transform2D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * 2D particle node used to create a variety of particle systems and effects. [GPUParticles2D]
 * features an emitter that generates some number of particles at a given rate.
 *
 * Use the [processMaterial] property to add a [ParticleProcessMaterial] to configure particle
 * appearance and behavior. Alternatively, you can add a [ShaderMaterial] which will be applied to all
 * particles.
 *
 * 2D particles can optionally collide with [LightOccluder2D], but they don't collide with
 * [PhysicsBody2D] nodes.
 */
@GodotBaseType
public open class GPUParticles2D : Node2D() {
  /**
   * Emitted when all active particles have finished processing. To immediately restart the emission
   * cycle, call [restart].
   *
   * This signal is never emitted when [oneShot] is disabled, as particles will be emitted and
   * processed continuously.
   *
   * **Note:** For [oneShot] emitters, due to the particles being computed on the GPU, there may be
   * a short period after receiving the signal during which setting [emitting] to `true` will not
   * restart the emission cycle. This delay is avoided by instead calling [restart].
   */
  public val finished: Signal0 by Signal0

  /**
   * If `true`, particles are being emitted. [emitting] can be used to start and stop particles from
   * emitting. However, if [oneShot] is `true` setting [emitting] to `true` will not restart the
   * emission cycle unless all active particles have finished processing. Use the [signal finished]
   * signal to be notified once all active particles finish processing.
   *
   * **Note:** For [oneShot] emitters, due to the particles being computed on the GPU, there may be
   * a short period after receiving the [signal finished] signal during which setting this to `true`
   * will not restart the emission cycle.
   *
   * **Tip:** If your [oneShot] emitter needs to immediately restart emitting particles once [signal
   * finished] signal is received, consider calling [restart] instead of setting [emitting].
   */
  public final inline var emitting: Boolean
    @JvmName("emittingProperty")
    get() = isEmitting()
    @JvmName("emittingProperty")
    set(`value`) {
      setEmitting(value)
    }

  /**
   * The number of particles to emit in one emission cycle. The effective emission rate is `(amount
   * * amount_ratio) / lifetime` particles per second. Higher values will increase GPU requirements,
   * even if not all particles are visible at a given time or if [amountRatio] is decreased.
   *
   * **Note:** Changing this value will cause the particle system to restart. To avoid this, change
   * [amountRatio] instead.
   */
  public final inline var amount: Int
    @JvmName("amountProperty")
    get() = getAmount()
    @JvmName("amountProperty")
    set(`value`) {
      setAmount(value)
    }

  /**
   * The ratio of particles that should actually be emitted. If set to a value lower than `1.0`,
   * this will set the amount of emitted particles throughout the lifetime to `amount * amount_ratio`.
   * Unlike changing [amount], changing [amountRatio] while emitting does not affect already-emitted
   * particles and doesn't cause the particle system to restart. [amountRatio] can be used to create
   * effects that make the number of emitted particles vary over time.
   *
   * **Note:** Reducing the [amountRatio] has no performance benefit, since resources need to be
   * allocated and processed for the total [amount] of particles regardless of the [amountRatio]. If
   * you don't intend to change the number of particles emitted while the particles are emitting, make
   * sure [amountRatio] is set to `1` and change [amount] to your liking instead.
   */
  public final inline var amountRatio: Float
    @JvmName("amountRatioProperty")
    get() = getAmountRatio()
    @JvmName("amountRatioProperty")
    set(`value`) {
      setAmountRatio(value)
    }

  /**
   * Path to another [GPUParticles2D] node that will be used as a subemitter (see
   * [ParticleProcessMaterial.subEmitterMode]). Subemitters can be used to achieve effects such as
   * fireworks, sparks on collision, bubbles popping into water drops, and more.
   *
   * **Note:** When [subEmitter] is set, the target [GPUParticles2D] node will no longer emit
   * particles on its own.
   */
  public final inline var subEmitter: NodePath
    @JvmName("subEmitterProperty")
    get() = getSubEmitter()
    @JvmName("subEmitterProperty")
    set(`value`) {
      setSubEmitter(value)
    }

  /**
   * Particle texture. If `null`, particles will be squares with a size of 1×1 pixels.
   *
   * **Note:** To use a flipbook texture, assign a new [CanvasItemMaterial] to the
   * [GPUParticles2D]'s [CanvasItem.material] property, then enable
   * [CanvasItemMaterial.particlesAnimation] and set [CanvasItemMaterial.particlesAnimHFrames],
   * [CanvasItemMaterial.particlesAnimVFrames], and [CanvasItemMaterial.particlesAnimLoop] to match the
   * flipbook texture.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * The amount of time each particle will exist (in seconds). The effective emission rate is
   * `(amount * amount_ratio) / lifetime` particles per second.
   */
  public final inline var lifetime: Double
    @JvmName("lifetimeProperty")
    get() = getLifetime()
    @JvmName("lifetimeProperty")
    set(`value`) {
      setLifetime(value)
    }

  /**
   * Causes all the particles in this node to interpolate towards the end of their lifetime.
   *
   * **Note:** This only works when used with a [ParticleProcessMaterial]. It needs to be manually
   * implemented for custom process shaders.
   */
  public final inline var interpToEnd: Float
    @JvmName("interpToEndProperty")
    get() = getInterpToEnd()
    @JvmName("interpToEndProperty")
    set(`value`) {
      setInterpToEnd(value)
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
   *
   * **Note:** This can be very expensive if set to a high number as it requires running the
   * particle shader a number of times equal to the [fixedFps] (or 30, if [fixedFps] is 0) for every
   * second. In extreme cases it can even lead to a GPU crash due to the volume of work done in a
   * single frame.
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
   * Enables particle interpolation, which makes the particle movement smoother when their
   * [fixedFps] is lower than the screen refresh rate.
   */
  public final inline var interpolate: Boolean
    @JvmName("interpolateProperty")
    get() = getInterpolate()
    @JvmName("interpolateProperty")
    set(`value`) {
      setInterpolate(value)
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
   * Multiplier for particle's collision radius. `1.0` corresponds to the size of the sprite. If
   * particles appear to sink into the ground when colliding, increase this value. If particles appear
   * to float when colliding, decrease this value. Only effective if
   * [ParticleProcessMaterial.collisionMode] is [ParticleProcessMaterial.COLLISION_RIGID] or
   * [ParticleProcessMaterial.COLLISION_HIDE_ON_CONTACT].
   *
   * **Note:** Particles always have a spherical collision shape.
   */
  public final inline var collisionBaseSize: Float
    @JvmName("collisionBaseSizeProperty")
    get() = getCollisionBaseSize()
    @JvmName("collisionBaseSizeProperty")
    set(`value`) {
      setCollisionBaseSize(value)
    }

  /**
   * The [Rect2] that determines the node's region which needs to be visible on screen for the
   * particle system to be active.
   *
   * Grow the rect if particles suddenly appear/disappear when the node enters/exits the screen. The
   * [Rect2] can be grown via code or with the **Particles → Generate Visibility Rect** editor tool.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var visibilityRect: Rect2
    @JvmName("visibilityRectProperty")
    get() = getVisibilityRect()
    @JvmName("visibilityRectProperty")
    set(`value`) {
      setVisibilityRect(value)
    }

  /**
   * If `true`, particles use the parent node's coordinate space (known as local coordinates). This
   * will cause particles to move and rotate along the [GPUParticles2D] node (and its parents) when it
   * is moved or rotated. If `false`, particles use global coordinates; they will not move or rotate
   * along the [GPUParticles2D] node (and its parents) when it is moved or rotated.
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
   * If `true`, enables particle trails using a mesh skinning system.
   *
   * **Note:** Unlike [GPUParticles3D], the number of trail sections and subdivisions is set with
   * the [trailSections] and [trailSectionSubdivisions] properties.
   */
  public final inline var trailEnabled: Boolean
    @JvmName("trailEnabledProperty")
    get() = isTrailEnabled()
    @JvmName("trailEnabledProperty")
    set(`value`) {
      setTrailEnabled(value)
    }

  /**
   * The amount of time the particle's trail should represent (in seconds). Only effective if
   * [trailEnabled] is `true`.
   */
  public final inline var trailLifetime: Double
    @JvmName("trailLifetimeProperty")
    get() = getTrailLifetime()
    @JvmName("trailLifetimeProperty")
    set(`value`) {
      setTrailLifetime(value)
    }

  /**
   * The number of sections to use for the particle trail rendering. Higher values can result in
   * smoother trail curves, at the cost of performance due to increased mesh complexity. See also
   * [trailSectionSubdivisions]. Only effective if [trailEnabled] is `true`.
   */
  public final inline var trailSections: Int
    @JvmName("trailSectionsProperty")
    get() = getTrailSections()
    @JvmName("trailSectionsProperty")
    set(`value`) {
      setTrailSections(value)
    }

  /**
   * The number of subdivisions to use for the particle trail rendering. Higher values can result in
   * smoother trail curves, at the cost of performance due to increased mesh complexity. See also
   * [trailSections]. Only effective if [trailEnabled] is `true`.
   */
  public final inline var trailSectionSubdivisions: Int
    @JvmName("trailSectionSubdivisionsProperty")
    get() = getTrailSectionSubdivisions()
    @JvmName("trailSectionSubdivisionsProperty")
    set(`value`) {
      setTrailSectionSubdivisions(value)
    }

  /**
   * [Material] for processing particles. Can be a [ParticleProcessMaterial] or a [ShaderMaterial].
   */
  public final inline var processMaterial: Material?
    @JvmName("processMaterialProperty")
    get() = getProcessMaterial()
    @JvmName("processMaterialProperty")
    set(`value`) {
      setProcessMaterial(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(259, scriptPtr)
  }

  /**
   * This is a helper function for [visibilityRect] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gpuparticles2d.visibilityRect
   * //Your changes
   * gpuparticles2d.visibilityRect = myCoreType
   * ``````
   *
   * The [Rect2] that determines the node's region which needs to be visible on screen for the
   * particle system to be active.
   *
   * Grow the rect if particles suddenly appear/disappear when the node enters/exits the screen. The
   * [Rect2] can be grown via code or with the **Particles → Generate Visibility Rect** editor tool.
   */
  @CoreTypeHelper
  public final fun visibilityRectMutate(block: Rect2.() -> Unit): Rect2 = visibilityRect.apply {
     block(this)
     visibilityRect = this
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

  public final fun setOneShot(secs: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to secs)
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

  public final fun setVisibilityRect(visibilityRect: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2 to visibilityRect)
    TransferContext.callMethod(MethodBindings.setVisibilityRectPtr)
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

  public final fun setInterpolate(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setInterpolatePtr)
  }

  public final fun setProcessMaterial(material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to material)
    TransferContext.callMethod(MethodBindings.setProcessMaterialPtr)
  }

  public final fun setSpeedScale(scale: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale)
    TransferContext.callMethod(MethodBindings.setSpeedScalePtr)
  }

  public final fun setCollisionBaseSize(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setCollisionBaseSizePtr)
  }

  public final fun setInterpToEnd(interp: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to interp.toDouble())
    TransferContext.callMethod(MethodBindings.setInterpToEndPtr)
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

  public final fun getVisibilityRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
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

  public final fun getInterpolate(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInterpolatePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun getProcessMaterial(): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProcessMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  public final fun getSpeedScale(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpeedScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun getCollisionBaseSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCollisionBaseSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getInterpToEnd(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInterpToEndPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
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
   * Returns a rectangle containing the positions of all existing particles.
   *
   * **Note:** When using threaded rendering this method synchronizes the rendering thread. Calling
   * it often may have a negative impact on performance.
   */
  public final fun captureRect(): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.captureRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Restarts the particle emission cycle, clearing existing particles. To avoid particles vanishing
   * from the viewport, wait for the [signal finished] signal before calling.
   *
   * **Note:** The [signal finished] signal is only emitted by [oneShot] emitters.
   *
   * If [keepSeed] is `true`, the current random seed will be preserved. Useful for seeking and
   * playback.
   */
  @JvmOverloads
  public final fun restart(keepSeed: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to keepSeed)
    TransferContext.callMethod(MethodBindings.restartPtr)
  }

  public final fun setSubEmitter(path: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to path)
    TransferContext.callMethod(MethodBindings.setSubEmitterPtr)
  }

  public final fun getSubEmitter(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubEmitterPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * Emits a single particle. Whether [xform], [velocity], [color] and [custom] are applied depends
   * on the value of [flags]. See [EmitFlags].
   *
   * The default ParticleProcessMaterial will overwrite [color] and use the contents of [custom] as
   * `(rotation, age, animation, lifetime)`.
   *
   * **Note:** [emitParticle] is only supported on the Forward+ and Mobile rendering methods, not
   * Compatibility.
   */
  public final fun emitParticle(
    xform: Transform2D,
    velocity: Vector2,
    color: Color,
    custom: Color,
    flags: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM2D to xform, VECTOR2 to velocity, COLOR to color, COLOR to custom, LONG to flags)
    TransferContext.callMethod(MethodBindings.emitParticlePtr)
  }

  public final fun setTrailEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setTrailEnabledPtr)
  }

  public final fun setTrailLifetime(secs: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to secs)
    TransferContext.callMethod(MethodBindings.setTrailLifetimePtr)
  }

  public final fun isTrailEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isTrailEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun getTrailLifetime(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrailLifetimePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setTrailSections(sections: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sections.toLong())
    TransferContext.callMethod(MethodBindings.setTrailSectionsPtr)
  }

  public final fun getTrailSections(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrailSectionsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setTrailSectionSubdivisions(subdivisions: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to subdivisions.toLong())
    TransferContext.callMethod(MethodBindings.setTrailSectionSubdivisionsPtr)
  }

  public final fun getTrailSectionSubdivisions(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrailSectionSubdivisionsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets this node's properties to match a given [CPUParticles2D] node.
   */
  public final fun convertFromParticles(particles: Node?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to particles)
    TransferContext.callMethod(MethodBindings.convertFromParticlesPtr)
  }

  public final fun setAmountRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setAmountRatioPtr)
  }

  public final fun getAmountRatio(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAmountRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
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

  public final fun setSubEmitter(path: String) = setSubEmitter(path.asCachedNodePath())

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
     * Particles are drawn in reverse order of remaining lifetime. In other words, the particle with
     * the lowest lifetime is drawn at the front.
     */
    REVERSE_LIFETIME(2),
    ;

    public companion object {
      public fun from(`value`: Long): DrawOrder = entries.single { it.`value` == `value` }
    }
  }

  public enum class EmitFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Particle starts at the specified position.
     */
    POSITION(1),
    /**
     * Particle starts with specified rotation and scale.
     */
    ROTATION_SCALE(2),
    /**
     * Particle starts with the specified velocity vector, which defines the emission direction and
     * speed.
     */
    VELOCITY(4),
    /**
     * Particle starts with specified color.
     */
    COLOR(8),
    /**
     * Particle starts with specified `CUSTOM` data.
     */
    CUSTOM(16),
    ;

    public companion object {
      public fun from(`value`: Long): EmitFlags = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setEmittingName: MethodStringName1<GPUParticles2D, Unit, Boolean> =
        MethodStringName1<GPUParticles2D, Unit, Boolean>("set_emitting")

    @JvmField
    public val setAmountName: MethodStringName1<GPUParticles2D, Unit, Int> =
        MethodStringName1<GPUParticles2D, Unit, Int>("set_amount")

    @JvmField
    public val setLifetimeName: MethodStringName1<GPUParticles2D, Unit, Double> =
        MethodStringName1<GPUParticles2D, Unit, Double>("set_lifetime")

    @JvmField
    public val setOneShotName: MethodStringName1<GPUParticles2D, Unit, Boolean> =
        MethodStringName1<GPUParticles2D, Unit, Boolean>("set_one_shot")

    @JvmField
    public val setPreProcessTimeName: MethodStringName1<GPUParticles2D, Unit, Double> =
        MethodStringName1<GPUParticles2D, Unit, Double>("set_pre_process_time")

    @JvmField
    public val setExplosivenessRatioName: MethodStringName1<GPUParticles2D, Unit, Float> =
        MethodStringName1<GPUParticles2D, Unit, Float>("set_explosiveness_ratio")

    @JvmField
    public val setRandomnessRatioName: MethodStringName1<GPUParticles2D, Unit, Float> =
        MethodStringName1<GPUParticles2D, Unit, Float>("set_randomness_ratio")

    @JvmField
    public val setVisibilityRectName: MethodStringName1<GPUParticles2D, Unit, Rect2> =
        MethodStringName1<GPUParticles2D, Unit, Rect2>("set_visibility_rect")

    @JvmField
    public val setUseLocalCoordinatesName: MethodStringName1<GPUParticles2D, Unit, Boolean> =
        MethodStringName1<GPUParticles2D, Unit, Boolean>("set_use_local_coordinates")

    @JvmField
    public val setFixedFpsName: MethodStringName1<GPUParticles2D, Unit, Int> =
        MethodStringName1<GPUParticles2D, Unit, Int>("set_fixed_fps")

    @JvmField
    public val setFractionalDeltaName: MethodStringName1<GPUParticles2D, Unit, Boolean> =
        MethodStringName1<GPUParticles2D, Unit, Boolean>("set_fractional_delta")

    @JvmField
    public val setInterpolateName: MethodStringName1<GPUParticles2D, Unit, Boolean> =
        MethodStringName1<GPUParticles2D, Unit, Boolean>("set_interpolate")

    @JvmField
    public val setProcessMaterialName: MethodStringName1<GPUParticles2D, Unit, Material?> =
        MethodStringName1<GPUParticles2D, Unit, Material?>("set_process_material")

    @JvmField
    public val setSpeedScaleName: MethodStringName1<GPUParticles2D, Unit, Double> =
        MethodStringName1<GPUParticles2D, Unit, Double>("set_speed_scale")

    @JvmField
    public val setCollisionBaseSizeName: MethodStringName1<GPUParticles2D, Unit, Float> =
        MethodStringName1<GPUParticles2D, Unit, Float>("set_collision_base_size")

    @JvmField
    public val setInterpToEndName: MethodStringName1<GPUParticles2D, Unit, Float> =
        MethodStringName1<GPUParticles2D, Unit, Float>("set_interp_to_end")

    @JvmField
    public val requestParticlesProcessName: MethodStringName2<GPUParticles2D, Unit, Float, Float> =
        MethodStringName2<GPUParticles2D, Unit, Float, Float>("request_particles_process")

    @JvmField
    public val isEmittingName: MethodStringName0<GPUParticles2D, Boolean> =
        MethodStringName0<GPUParticles2D, Boolean>("is_emitting")

    @JvmField
    public val getAmountName: MethodStringName0<GPUParticles2D, Int> =
        MethodStringName0<GPUParticles2D, Int>("get_amount")

    @JvmField
    public val getLifetimeName: MethodStringName0<GPUParticles2D, Double> =
        MethodStringName0<GPUParticles2D, Double>("get_lifetime")

    @JvmField
    public val getOneShotName: MethodStringName0<GPUParticles2D, Boolean> =
        MethodStringName0<GPUParticles2D, Boolean>("get_one_shot")

    @JvmField
    public val getPreProcessTimeName: MethodStringName0<GPUParticles2D, Double> =
        MethodStringName0<GPUParticles2D, Double>("get_pre_process_time")

    @JvmField
    public val getExplosivenessRatioName: MethodStringName0<GPUParticles2D, Float> =
        MethodStringName0<GPUParticles2D, Float>("get_explosiveness_ratio")

    @JvmField
    public val getRandomnessRatioName: MethodStringName0<GPUParticles2D, Float> =
        MethodStringName0<GPUParticles2D, Float>("get_randomness_ratio")

    @JvmField
    public val getVisibilityRectName: MethodStringName0<GPUParticles2D, Rect2> =
        MethodStringName0<GPUParticles2D, Rect2>("get_visibility_rect")

    @JvmField
    public val getUseLocalCoordinatesName: MethodStringName0<GPUParticles2D, Boolean> =
        MethodStringName0<GPUParticles2D, Boolean>("get_use_local_coordinates")

    @JvmField
    public val getFixedFpsName: MethodStringName0<GPUParticles2D, Int> =
        MethodStringName0<GPUParticles2D, Int>("get_fixed_fps")

    @JvmField
    public val getFractionalDeltaName: MethodStringName0<GPUParticles2D, Boolean> =
        MethodStringName0<GPUParticles2D, Boolean>("get_fractional_delta")

    @JvmField
    public val getInterpolateName: MethodStringName0<GPUParticles2D, Boolean> =
        MethodStringName0<GPUParticles2D, Boolean>("get_interpolate")

    @JvmField
    public val getProcessMaterialName: MethodStringName0<GPUParticles2D, Material?> =
        MethodStringName0<GPUParticles2D, Material?>("get_process_material")

    @JvmField
    public val getSpeedScaleName: MethodStringName0<GPUParticles2D, Double> =
        MethodStringName0<GPUParticles2D, Double>("get_speed_scale")

    @JvmField
    public val getCollisionBaseSizeName: MethodStringName0<GPUParticles2D, Float> =
        MethodStringName0<GPUParticles2D, Float>("get_collision_base_size")

    @JvmField
    public val getInterpToEndName: MethodStringName0<GPUParticles2D, Float> =
        MethodStringName0<GPUParticles2D, Float>("get_interp_to_end")

    @JvmField
    public val setDrawOrderName: MethodStringName1<GPUParticles2D, Unit, DrawOrder> =
        MethodStringName1<GPUParticles2D, Unit, DrawOrder>("set_draw_order")

    @JvmField
    public val getDrawOrderName: MethodStringName0<GPUParticles2D, DrawOrder> =
        MethodStringName0<GPUParticles2D, DrawOrder>("get_draw_order")

    @JvmField
    public val setTextureName: MethodStringName1<GPUParticles2D, Unit, Texture2D?> =
        MethodStringName1<GPUParticles2D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<GPUParticles2D, Texture2D?> =
        MethodStringName0<GPUParticles2D, Texture2D?>("get_texture")

    @JvmField
    public val captureRectName: MethodStringName0<GPUParticles2D, Rect2> =
        MethodStringName0<GPUParticles2D, Rect2>("capture_rect")

    @JvmField
    public val restartName: MethodStringName1<GPUParticles2D, Unit, Boolean> =
        MethodStringName1<GPUParticles2D, Unit, Boolean>("restart")

    @JvmField
    public val setSubEmitterName: MethodStringName1<GPUParticles2D, Unit, NodePath> =
        MethodStringName1<GPUParticles2D, Unit, NodePath>("set_sub_emitter")

    @JvmField
    public val getSubEmitterName: MethodStringName0<GPUParticles2D, NodePath> =
        MethodStringName0<GPUParticles2D, NodePath>("get_sub_emitter")

    @JvmField
    public val emitParticleName:
        MethodStringName5<GPUParticles2D, Unit, Transform2D, Vector2, Color, Color, Long> =
        MethodStringName5<GPUParticles2D, Unit, Transform2D, Vector2, Color, Color, Long>("emit_particle")

    @JvmField
    public val setTrailEnabledName: MethodStringName1<GPUParticles2D, Unit, Boolean> =
        MethodStringName1<GPUParticles2D, Unit, Boolean>("set_trail_enabled")

    @JvmField
    public val setTrailLifetimeName: MethodStringName1<GPUParticles2D, Unit, Double> =
        MethodStringName1<GPUParticles2D, Unit, Double>("set_trail_lifetime")

    @JvmField
    public val isTrailEnabledName: MethodStringName0<GPUParticles2D, Boolean> =
        MethodStringName0<GPUParticles2D, Boolean>("is_trail_enabled")

    @JvmField
    public val getTrailLifetimeName: MethodStringName0<GPUParticles2D, Double> =
        MethodStringName0<GPUParticles2D, Double>("get_trail_lifetime")

    @JvmField
    public val setTrailSectionsName: MethodStringName1<GPUParticles2D, Unit, Int> =
        MethodStringName1<GPUParticles2D, Unit, Int>("set_trail_sections")

    @JvmField
    public val getTrailSectionsName: MethodStringName0<GPUParticles2D, Int> =
        MethodStringName0<GPUParticles2D, Int>("get_trail_sections")

    @JvmField
    public val setTrailSectionSubdivisionsName: MethodStringName1<GPUParticles2D, Unit, Int> =
        MethodStringName1<GPUParticles2D, Unit, Int>("set_trail_section_subdivisions")

    @JvmField
    public val getTrailSectionSubdivisionsName: MethodStringName0<GPUParticles2D, Int> =
        MethodStringName0<GPUParticles2D, Int>("get_trail_section_subdivisions")

    @JvmField
    public val convertFromParticlesName: MethodStringName1<GPUParticles2D, Unit, Node?> =
        MethodStringName1<GPUParticles2D, Unit, Node?>("convert_from_particles")

    @JvmField
    public val setAmountRatioName: MethodStringName1<GPUParticles2D, Unit, Float> =
        MethodStringName1<GPUParticles2D, Unit, Float>("set_amount_ratio")

    @JvmField
    public val getAmountRatioName: MethodStringName0<GPUParticles2D, Float> =
        MethodStringName0<GPUParticles2D, Float>("get_amount_ratio")

    @JvmField
    public val setUseFixedSeedName: MethodStringName1<GPUParticles2D, Unit, Boolean> =
        MethodStringName1<GPUParticles2D, Unit, Boolean>("set_use_fixed_seed")

    @JvmField
    public val getUseFixedSeedName: MethodStringName0<GPUParticles2D, Boolean> =
        MethodStringName0<GPUParticles2D, Boolean>("get_use_fixed_seed")

    @JvmField
    public val setSeedName: MethodStringName1<GPUParticles2D, Unit, Long> =
        MethodStringName1<GPUParticles2D, Unit, Long>("set_seed")

    @JvmField
    public val getSeedName: MethodStringName0<GPUParticles2D, Long> =
        MethodStringName0<GPUParticles2D, Long>("get_seed")
  }

  public object MethodBindings {
    internal val setEmittingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_emitting", 2586408642)

    internal val setAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_amount", 1286410249)

    internal val setLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_lifetime", 373806689)

    internal val setOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_one_shot", 2586408642)

    internal val setPreProcessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_pre_process_time", 373806689)

    internal val setExplosivenessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_explosiveness_ratio", 373806689)

    internal val setRandomnessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_randomness_ratio", 373806689)

    internal val setVisibilityRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_visibility_rect", 2046264180)

    internal val setUseLocalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_use_local_coordinates", 2586408642)

    internal val setFixedFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_fixed_fps", 1286410249)

    internal val setFractionalDeltaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_fractional_delta", 2586408642)

    internal val setInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_interpolate", 2586408642)

    internal val setProcessMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_process_material", 2757459619)

    internal val setSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_speed_scale", 373806689)

    internal val setCollisionBaseSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_collision_base_size", 373806689)

    internal val setInterpToEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_interp_to_end", 373806689)

    internal val requestParticlesProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "request_particles_process", 2019720106)

    internal val isEmittingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "is_emitting", 36873697)

    internal val getAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_amount", 3905245786)

    internal val getLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_lifetime", 1740695150)

    internal val getOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_one_shot", 36873697)

    internal val getPreProcessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_pre_process_time", 1740695150)

    internal val getExplosivenessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_explosiveness_ratio", 1740695150)

    internal val getRandomnessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_randomness_ratio", 1740695150)

    internal val getVisibilityRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_visibility_rect", 1639390495)

    internal val getUseLocalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_use_local_coordinates", 36873697)

    internal val getFixedFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_fixed_fps", 3905245786)

    internal val getFractionalDeltaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_fractional_delta", 36873697)

    internal val getInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_interpolate", 36873697)

    internal val getProcessMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_process_material", 5934680)

    internal val getSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_speed_scale", 1740695150)

    internal val getCollisionBaseSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_collision_base_size", 1740695150)

    internal val getInterpToEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_interp_to_end", 1740695150)

    internal val setDrawOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_draw_order", 1939677959)

    internal val getDrawOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_draw_order", 941479095)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_texture", 3635182373)

    internal val captureRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "capture_rect", 1639390495)

    internal val restartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "restart", 107499316)

    internal val setSubEmitterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_sub_emitter", 1348162250)

    internal val getSubEmitterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_sub_emitter", 4075236667)

    internal val emitParticlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "emit_particle", 2179202058)

    internal val setTrailEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_trail_enabled", 2586408642)

    internal val setTrailLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_trail_lifetime", 373806689)

    internal val isTrailEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "is_trail_enabled", 36873697)

    internal val getTrailLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_trail_lifetime", 1740695150)

    internal val setTrailSectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_trail_sections", 1286410249)

    internal val getTrailSectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_trail_sections", 3905245786)

    internal val setTrailSectionSubdivisionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_trail_section_subdivisions", 1286410249)

    internal val getTrailSectionSubdivisionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_trail_section_subdivisions", 3905245786)

    internal val convertFromParticlesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "convert_from_particles", 1078189570)

    internal val setAmountRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_amount_ratio", 373806689)

    internal val getAmountRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_amount_ratio", 1740695150)

    internal val setUseFixedSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_use_fixed_seed", 2586408642)

    internal val getUseFixedSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_use_fixed_seed", 36873697)

    internal val setSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "set_seed", 1286410249)

    internal val getSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GPUParticles2D", "get_seed", 3905245786)
  }
}
