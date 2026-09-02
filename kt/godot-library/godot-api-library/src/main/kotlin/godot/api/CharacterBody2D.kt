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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
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
 * [CharacterBody2D] is a specialized class for physics bodies that are meant to be user-controlled.
 * They are not affected by physics at all, but they affect other physics bodies in their path. They
 * are mainly used to provide high-level API to move objects with wall and slope detection
 * ([moveAndSlide] method) in addition to the general collision detection provided by
 * [PhysicsBody2D.moveAndCollide]. This makes it useful for highly configurable physics bodies that
 * must move in specific ways and collide with the world, as is often the case with user-controlled
 * characters.
 *
 * For game objects that don't require complex movement or collision detection, such as moving
 * platforms, [AnimatableBody2D] is simpler to configure.
 */
@GodotBaseType
public open class CharacterBody2D : PhysicsBody2D() {
  /**
   * Sets the motion mode which defines the behavior of [moveAndSlide].
   */
  public final inline var motionMode: MotionMode
    @JvmName("motionModeProperty")
    get() = getMotionMode()
    @JvmName("motionModeProperty")
    set(`value`) {
      setMotionMode(value)
    }

  /**
   * Vector pointing upwards, used to determine what is a wall and what is a floor (or a ceiling)
   * when calling [moveAndSlide]. Defaults to [Vector2.UP]. As the vector will be normalized it can't
   * be equal to [Vector2.ZERO], if you want all collisions to be reported as walls, consider using
   * [MOTION_MODE_FLOATING] as [motionMode].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var upDirection: Vector2
    @JvmName("upDirectionProperty")
    get() = getUpDirection()
    @JvmName("upDirectionProperty")
    set(`value`) {
      setUpDirection(value)
    }

  /**
   * Current velocity vector in pixels per second, used and modified during calls to [moveAndSlide].
   *
   * **Note:** A common mistake is setting this property to the desired velocity multiplied by
   * `delta`, which produces a motion vector in pixels.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var velocity: Vector2
    @JvmName("velocityProperty")
    get() = getVelocity()
    @JvmName("velocityProperty")
    set(`value`) {
      setVelocity(value)
    }

  /**
   * If `true`, during a jump against the ceiling, the body will slide, if `false` it will be
   * stopped and will fall vertically.
   */
  public final inline var slideOnCeiling: Boolean
    @JvmName("slideOnCeilingProperty")
    get() = isSlideOnCeilingEnabled()
    @JvmName("slideOnCeilingProperty")
    set(`value`) {
      setSlideOnCeilingEnabled(value)
    }

  /**
   * Maximum number of times the body can change direction before it stops when calling
   * [moveAndSlide]. Must be greater than zero.
   */
  public final inline var maxSlides: Int
    @JvmName("maxSlidesProperty")
    get() = getMaxSlides()
    @JvmName("maxSlidesProperty")
    set(`value`) {
      setMaxSlides(value)
    }

  /**
   * Minimum angle (in radians) where the body is allowed to slide when it encounters a wall. The
   * default value equals 15 degrees. This property only affects movement when [motionMode] is
   * [MOTION_MODE_FLOATING].
   */
  public final inline var wallMinSlideAngle: Float
    @JvmName("wallMinSlideAngleProperty")
    get() = getWallMinSlideAngle()
    @JvmName("wallMinSlideAngleProperty")
    set(`value`) {
      setWallMinSlideAngle(value)
    }

  /**
   * If `true`, the body will not slide on slopes when calling [moveAndSlide] when the body is
   * standing still.
   *
   * If `false`, the body will slide on floor's slopes when [velocity] applies a downward force.
   */
  public final inline var floorStopOnSlope: Boolean
    @JvmName("floorStopOnSlopeProperty")
    get() = isFloorStopOnSlopeEnabled()
    @JvmName("floorStopOnSlopeProperty")
    set(`value`) {
      setFloorStopOnSlopeEnabled(value)
    }

  /**
   * If `false` (by default), the body will move faster on downward slopes and slower on upward
   * slopes.
   *
   * If `true`, the body will always move at the same speed on the ground no matter the slope. Note
   * that you need to use [floorSnapLength] to stick along a downward slope at constant speed.
   */
  public final inline var floorConstantSpeed: Boolean
    @JvmName("floorConstantSpeedProperty")
    get() = isFloorConstantSpeedEnabled()
    @JvmName("floorConstantSpeedProperty")
    set(`value`) {
      setFloorConstantSpeedEnabled(value)
    }

  /**
   * If `true`, the body will be able to move on the floor only. This option avoids to be able to
   * walk on walls, it will however allow to slide down along them.
   */
  public final inline var floorBlockOnWall: Boolean
    @JvmName("floorBlockOnWallProperty")
    get() = isFloorBlockOnWallEnabled()
    @JvmName("floorBlockOnWallProperty")
    set(`value`) {
      setFloorBlockOnWallEnabled(value)
    }

  /**
   * Maximum angle (in radians) where a slope is still considered a floor (or a ceiling), rather
   * than a wall, when calling [moveAndSlide]. The default value equals 45 degrees.
   */
  public final inline var floorMaxAngle: Float
    @JvmName("floorMaxAngleProperty")
    get() = getFloorMaxAngle()
    @JvmName("floorMaxAngleProperty")
    set(`value`) {
      setFloorMaxAngle(value)
    }

  /**
   * Sets a snapping distance. When set to a value different from `0.0`, the body is kept attached
   * to slopes when calling [moveAndSlide]. The snapping vector is determined by the given distance
   * along the opposite direction of the [upDirection].
   *
   * As long as the snapping vector is in contact with the ground and the body moves against
   * [upDirection], the body will remain attached to the surface. Snapping is not applied if the body
   * moves along [upDirection], meaning it contains vertical rising velocity, so it will be able to
   * detach from the ground when jumping or when the body is pushed up by something. If you want to
   * apply a snap without taking into account the velocity, use [applyFloorSnap].
   */
  public final inline var floorSnapLength: Float
    @JvmName("floorSnapLengthProperty")
    get() = getFloorSnapLength()
    @JvmName("floorSnapLengthProperty")
    set(`value`) {
      setFloorSnapLength(value)
    }

  /**
   * Sets the behavior to apply when you leave a moving platform. By default, to be physically
   * accurate, when you leave the last platform velocity is applied.
   */
  public final inline var platformOnLeave: PlatformOnLeave
    @JvmName("platformOnLeaveProperty")
    get() = getPlatformOnLeave()
    @JvmName("platformOnLeaveProperty")
    set(`value`) {
      setPlatformOnLeave(value)
    }

  /**
   * Collision layers that will be included for detecting floor bodies that will act as moving
   * platforms to be followed by the [CharacterBody2D]. By default, all floor bodies are detected and
   * propagate their velocity.
   */
  public final inline var platformFloorLayers: Long
    @JvmName("platformFloorLayersProperty")
    get() = getPlatformFloorLayers()
    @JvmName("platformFloorLayersProperty")
    set(`value`) {
      setPlatformFloorLayers(value)
    }

  /**
   * Collision layers that will be included for detecting wall bodies that will act as moving
   * platforms to be followed by the [CharacterBody2D]. By default, all wall bodies are ignored.
   */
  public final inline var platformWallLayers: Long
    @JvmName("platformWallLayersProperty")
    get() = getPlatformWallLayers()
    @JvmName("platformWallLayersProperty")
    set(`value`) {
      setPlatformWallLayers(value)
    }

  /**
   * Extra margin used for collision recovery when calling [moveAndSlide].
   *
   * If the body is at least this close to another body, it will consider them to be colliding and
   * will be pushed away before performing the actual motion.
   *
   * A higher value means it's more flexible for detecting collision, which helps with consistently
   * detecting walls and floors.
   *
   * A lower value forces the collision algorithm to use more exact detection, so it can be used in
   * cases that specifically require precision, e.g at very low scale to avoid visible jittering, or
   * for stability with a stack of character bodies.
   */
  public final inline var safeMargin: Float
    @JvmName("safeMarginProperty")
    get() = getSafeMargin()
    @JvmName("safeMarginProperty")
    set(`value`) {
      setSafeMargin(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(155, scriptPtr)
  }

  /**
   * This is a helper function for [upDirection] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = characterbody2d.upDirection
   * //Your changes
   * characterbody2d.upDirection = myCoreType
   * ``````
   *
   * Vector pointing upwards, used to determine what is a wall and what is a floor (or a ceiling)
   * when calling [moveAndSlide]. Defaults to [Vector2.UP]. As the vector will be normalized it can't
   * be equal to [Vector2.ZERO], if you want all collisions to be reported as walls, consider using
   * [MOTION_MODE_FLOATING] as [motionMode].
   */
  @CoreTypeHelper
  public final fun upDirectionMutate(block: Vector2.() -> Unit): Vector2 = upDirection.apply {
     block(this)
     upDirection = this
  }

  /**
   * This is a helper function for [velocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = characterbody2d.velocity
   * //Your changes
   * characterbody2d.velocity = myCoreType
   * ``````
   *
   * Current velocity vector in pixels per second, used and modified during calls to [moveAndSlide].
   *
   * **Note:** A common mistake is setting this property to the desired velocity multiplied by
   * `delta`, which produces a motion vector in pixels.
   */
  @CoreTypeHelper
  public final fun velocityMutate(block: Vector2.() -> Unit): Vector2 = velocity.apply {
     block(this)
     velocity = this
  }

  /**
   * Moves the body based on [velocity]. If the body collides with another, it will slide along the
   * other body (by default only on floor) rather than stop immediately. If the other body is a
   * [CharacterBody2D] or [RigidBody2D], it will also be affected by the motion of the other body. You
   * can use this to make moving and rotating platforms, or to make nodes push other nodes.
   *
   * This method should be used in [Node.PhysicsProcess] (or in a method called by
   * [Node.PhysicsProcess]), as it uses the physics step's `delta` value automatically in calculations.
   * Otherwise, the simulation will run at an incorrect speed.
   *
   * Modifies [velocity] if a slide collision occurred. To get the latest collision call
   * [getLastSlideCollision], for detailed information about collisions that occurred, use
   * [getSlideCollision].
   *
   * When the body touches a moving platform, the platform's velocity is automatically added to the
   * body motion. If a collision occurs due to the platform's motion, it will always be first in the
   * slide collisions.
   *
   * The general behavior and available properties change according to the [motionMode].
   *
   * Returns `true` if the body collided, otherwise, returns `false`.
   */
  public final fun moveAndSlide(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.moveAndSlidePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Allows to manually apply a snap to the floor regardless of the body's velocity. This function
   * does nothing when [isOnFloor] returns `true`.
   */
  public final fun applyFloorSnap(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.applyFloorSnapPtr)
  }

  public final fun setVelocity(velocity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to velocity)
    TransferContext.callMethod(MethodBindings.setVelocityPtr)
  }

  public final fun getVelocity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setSafeMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to margin.toDouble())
    TransferContext.callMethod(MethodBindings.setSafeMarginPtr)
  }

  public final fun getSafeMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSafeMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun isFloorStopOnSlopeEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFloorStopOnSlopeEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFloorStopOnSlopeEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFloorStopOnSlopeEnabledPtr)
  }

  public final fun setFloorConstantSpeedEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFloorConstantSpeedEnabledPtr)
  }

  public final fun isFloorConstantSpeedEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFloorConstantSpeedEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFloorBlockOnWallEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFloorBlockOnWallEnabledPtr)
  }

  public final fun isFloorBlockOnWallEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFloorBlockOnWallEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSlideOnCeilingEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSlideOnCeilingEnabledPtr)
  }

  public final fun isSlideOnCeilingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSlideOnCeilingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPlatformFloorLayers(excludeLayer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to excludeLayer)
    TransferContext.callMethod(MethodBindings.setPlatformFloorLayersPtr)
  }

  public final fun getPlatformFloorLayers(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlatformFloorLayersPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setPlatformWallLayers(excludeLayer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to excludeLayer)
    TransferContext.callMethod(MethodBindings.setPlatformWallLayersPtr)
  }

  public final fun getPlatformWallLayers(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlatformWallLayersPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun getMaxSlides(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxSlidesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMaxSlides(maxSlides: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxSlides.toLong())
    TransferContext.callMethod(MethodBindings.setMaxSlidesPtr)
  }

  public final fun getFloorMaxAngle(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFloorMaxAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFloorMaxAngle(radians: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radians.toDouble())
    TransferContext.callMethod(MethodBindings.setFloorMaxAnglePtr)
  }

  public final fun getFloorSnapLength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFloorSnapLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFloorSnapLength(floorSnapLength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to floorSnapLength.toDouble())
    TransferContext.callMethod(MethodBindings.setFloorSnapLengthPtr)
  }

  public final fun getWallMinSlideAngle(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWallMinSlideAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setWallMinSlideAngle(radians: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radians.toDouble())
    TransferContext.callMethod(MethodBindings.setWallMinSlideAnglePtr)
  }

  public final fun getUpDirection(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUpDirectionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setUpDirection(upDirection: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to upDirection)
    TransferContext.callMethod(MethodBindings.setUpDirectionPtr)
  }

  public final fun setMotionMode(mode: MotionMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setMotionModePtr)
  }

  public final fun getMotionMode(): MotionMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMotionModePtr)
    return MotionMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setPlatformOnLeave(onLeaveApplyVelocity: PlatformOnLeave): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to onLeaveApplyVelocity.value)
    TransferContext.callMethod(MethodBindings.setPlatformOnLeavePtr)
  }

  public final fun getPlatformOnLeave(): PlatformOnLeave {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlatformOnLeavePtr)
    return PlatformOnLeave.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the body collided with the floor on the last call of [moveAndSlide].
   * Otherwise, returns `false`. The [upDirection] and [floorMaxAngle] are used to determine whether a
   * surface is "floor" or not.
   */
  public final fun isOnFloor(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnFloorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the body collided only with the floor on the last call of [moveAndSlide].
   * Otherwise, returns `false`. The [upDirection] and [floorMaxAngle] are used to determine whether a
   * surface is "floor" or not.
   */
  public final fun isOnFloorOnly(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnFloorOnlyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the body collided with the ceiling on the last call of [moveAndSlide].
   * Otherwise, returns `false`. The [upDirection] and [floorMaxAngle] are used to determine whether a
   * surface is "ceiling" or not.
   */
  public final fun isOnCeiling(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnCeilingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the body collided only with the ceiling on the last call of [moveAndSlide].
   * Otherwise, returns `false`. The [upDirection] and [floorMaxAngle] are used to determine whether a
   * surface is "ceiling" or not.
   */
  public final fun isOnCeilingOnly(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnCeilingOnlyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the body collided with a wall on the last call of [moveAndSlide]. Otherwise,
   * returns `false`. The [upDirection] and [floorMaxAngle] are used to determine whether a surface is
   * "wall" or not.
   */
  public final fun isOnWall(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnWallPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the body collided only with a wall on the last call of [moveAndSlide].
   * Otherwise, returns `false`. The [upDirection] and [floorMaxAngle] are used to determine whether a
   * surface is "wall" or not.
   */
  public final fun isOnWallOnly(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnWallOnlyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the collision normal of the floor at the last collision point. Only valid after calling
   * [moveAndSlide] and when [isOnFloor] returns `true`.
   *
   * **Warning:** The collision normal is not always the same as the surface normal.
   */
  public final fun getFloorNormal(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFloorNormalPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the collision normal of the wall at the last collision point. Only valid after calling
   * [moveAndSlide] and when [isOnWall] returns `true`.
   *
   * **Warning:** The collision normal is not always the same as the surface normal.
   */
  public final fun getWallNormal(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWallNormalPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the last motion applied to the [CharacterBody2D] during the last call to
   * [moveAndSlide]. The movement can be split into multiple motions when sliding occurs, and this
   * method return the last one, which is useful to retrieve the current direction of the movement.
   */
  public final fun getLastMotion(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLastMotionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the travel (position delta) that occurred during the last call to [moveAndSlide].
   */
  public final fun getPositionDelta(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionDeltaPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the current real velocity since the last call to [moveAndSlide]. For example, when you
   * climb a slope, you will move diagonally even though the velocity is horizontal. This method
   * returns the diagonal movement, as opposed to [velocity] which returns the requested velocity.
   */
  public final fun getRealVelocity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRealVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the floor's collision angle at the last collision point according to [upDirection],
   * which is [Vector2.UP] by default. This value is always positive and only valid after calling
   * [moveAndSlide] and when [isOnFloor] returns `true`.
   */
  @JvmOverloads
  public final fun getFloorAngle(upDirection: Vector2 = Vector2(0, -1)): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to upDirection)
    TransferContext.callMethod(MethodBindings.getFloorAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the linear velocity of the platform at the last collision point. Only valid after
   * calling [moveAndSlide].
   */
  public final fun getPlatformVelocity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlatformVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the number of times the body collided and changed direction during the last call to
   * [moveAndSlide].
   */
  public final fun getSlideCollisionCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSlideCollisionCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns a [KinematicCollision2D], which contains information about a collision that occurred
   * during the last call to [moveAndSlide]. Since the body can collide several times in a single call
   * to [moveAndSlide], you must specify the index of the collision in the range 0 to
   * ([getSlideCollisionCount] - 1). See also [getLastSlideCollision].
   *
   * **Example:** Iterate through the collisions with a `for` loop:
   *
   * ```gdscript
   * //gdscript
   * for i in get_slide_collision_count():
   * 	var collision = get_slide_collision(i)
   * 	print("Collided with: ", collision.get_collider().name)
   * ```
   *
   * ```csharp
   * //csharp
   * for (int i = 0; i < GetSlideCollisionCount(); i++)
   * {
   * 	KinematicCollision2D collision = GetSlideCollision(i);
   * 	GD.Print("Collided with: ", (collision.GetCollider() as Node).Name);
   * }
   * ```
   */
  public final fun getSlideCollision(slideIdx: Int): KinematicCollision2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to slideIdx.toLong())
    TransferContext.callMethod(MethodBindings.getSlideCollisionPtr)
    return (TransferContext.readReturnValue(OBJECT) as KinematicCollision2D?)
  }

  /**
   * Returns a [KinematicCollision2D] if a collision occurred. The returned value contains
   * information about the latest collision that occurred during the last call to [moveAndSlide].
   * Returns `null` if no collision occurred. See also [getSlideCollision].
   */
  public final fun getLastSlideCollision(): KinematicCollision2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLastSlideCollisionPtr)
    return (TransferContext.readReturnValue(OBJECT) as KinematicCollision2D?)
  }

  public enum class MotionMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Apply when notions of walls, ceiling and floor are relevant. In this mode the body motion
     * will react to slopes (acceleration/slowdown). This mode is suitable for sided games like
     * platformers.
     */
    GROUNDED(0),
    /**
     * Apply when there is no notion of floor or ceiling. All collisions will be reported as
     * `on_wall`. In this mode, when you slide, the speed will always be constant. This mode is
     * suitable for top-down games.
     */
    FLOATING(1),
    ;

    public companion object {
      public fun from(`value`: Long): MotionMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class PlatformOnLeave(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Add the last platform velocity to the [velocity] when you leave a moving platform.
     */
    ADD_VELOCITY(0),
    /**
     * Add the last platform velocity to the [velocity] when you leave a moving platform, but any
     * downward motion is ignored. It's useful to keep full jump height even when the platform is
     * moving down.
     */
    ADD_UPWARD_VELOCITY(1),
    /**
     * Do nothing when leaving a platform.
     */
    DO_NOTHING(2),
    ;

    public companion object {
      public fun from(`value`: Long): PlatformOnLeave = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val moveAndSlideName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("move_and_slide")

    @JvmField
    public val applyFloorSnapName: MethodStringName0<CharacterBody2D, Unit> =
        MethodStringName0<CharacterBody2D, Unit>("apply_floor_snap")

    @JvmField
    public val setVelocityName: MethodStringName1<CharacterBody2D, Unit, Vector2> =
        MethodStringName1<CharacterBody2D, Unit, Vector2>("set_velocity")

    @JvmField
    public val getVelocityName: MethodStringName0<CharacterBody2D, Vector2> =
        MethodStringName0<CharacterBody2D, Vector2>("get_velocity")

    @JvmField
    public val setSafeMarginName: MethodStringName1<CharacterBody2D, Unit, Float> =
        MethodStringName1<CharacterBody2D, Unit, Float>("set_safe_margin")

    @JvmField
    public val getSafeMarginName: MethodStringName0<CharacterBody2D, Float> =
        MethodStringName0<CharacterBody2D, Float>("get_safe_margin")

    @JvmField
    public val isFloorStopOnSlopeEnabledName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_floor_stop_on_slope_enabled")

    @JvmField
    public val setFloorStopOnSlopeEnabledName: MethodStringName1<CharacterBody2D, Unit, Boolean> =
        MethodStringName1<CharacterBody2D, Unit, Boolean>("set_floor_stop_on_slope_enabled")

    @JvmField
    public val setFloorConstantSpeedEnabledName: MethodStringName1<CharacterBody2D, Unit, Boolean> =
        MethodStringName1<CharacterBody2D, Unit, Boolean>("set_floor_constant_speed_enabled")

    @JvmField
    public val isFloorConstantSpeedEnabledName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_floor_constant_speed_enabled")

    @JvmField
    public val setFloorBlockOnWallEnabledName: MethodStringName1<CharacterBody2D, Unit, Boolean> =
        MethodStringName1<CharacterBody2D, Unit, Boolean>("set_floor_block_on_wall_enabled")

    @JvmField
    public val isFloorBlockOnWallEnabledName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_floor_block_on_wall_enabled")

    @JvmField
    public val setSlideOnCeilingEnabledName: MethodStringName1<CharacterBody2D, Unit, Boolean> =
        MethodStringName1<CharacterBody2D, Unit, Boolean>("set_slide_on_ceiling_enabled")

    @JvmField
    public val isSlideOnCeilingEnabledName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_slide_on_ceiling_enabled")

    @JvmField
    public val setPlatformFloorLayersName: MethodStringName1<CharacterBody2D, Unit, Long> =
        MethodStringName1<CharacterBody2D, Unit, Long>("set_platform_floor_layers")

    @JvmField
    public val getPlatformFloorLayersName: MethodStringName0<CharacterBody2D, Long> =
        MethodStringName0<CharacterBody2D, Long>("get_platform_floor_layers")

    @JvmField
    public val setPlatformWallLayersName: MethodStringName1<CharacterBody2D, Unit, Long> =
        MethodStringName1<CharacterBody2D, Unit, Long>("set_platform_wall_layers")

    @JvmField
    public val getPlatformWallLayersName: MethodStringName0<CharacterBody2D, Long> =
        MethodStringName0<CharacterBody2D, Long>("get_platform_wall_layers")

    @JvmField
    public val getMaxSlidesName: MethodStringName0<CharacterBody2D, Int> =
        MethodStringName0<CharacterBody2D, Int>("get_max_slides")

    @JvmField
    public val setMaxSlidesName: MethodStringName1<CharacterBody2D, Unit, Int> =
        MethodStringName1<CharacterBody2D, Unit, Int>("set_max_slides")

    @JvmField
    public val getFloorMaxAngleName: MethodStringName0<CharacterBody2D, Float> =
        MethodStringName0<CharacterBody2D, Float>("get_floor_max_angle")

    @JvmField
    public val setFloorMaxAngleName: MethodStringName1<CharacterBody2D, Unit, Float> =
        MethodStringName1<CharacterBody2D, Unit, Float>("set_floor_max_angle")

    @JvmField
    public val getFloorSnapLengthName: MethodStringName0<CharacterBody2D, Float> =
        MethodStringName0<CharacterBody2D, Float>("get_floor_snap_length")

    @JvmField
    public val setFloorSnapLengthName: MethodStringName1<CharacterBody2D, Unit, Float> =
        MethodStringName1<CharacterBody2D, Unit, Float>("set_floor_snap_length")

    @JvmField
    public val getWallMinSlideAngleName: MethodStringName0<CharacterBody2D, Float> =
        MethodStringName0<CharacterBody2D, Float>("get_wall_min_slide_angle")

    @JvmField
    public val setWallMinSlideAngleName: MethodStringName1<CharacterBody2D, Unit, Float> =
        MethodStringName1<CharacterBody2D, Unit, Float>("set_wall_min_slide_angle")

    @JvmField
    public val getUpDirectionName: MethodStringName0<CharacterBody2D, Vector2> =
        MethodStringName0<CharacterBody2D, Vector2>("get_up_direction")

    @JvmField
    public val setUpDirectionName: MethodStringName1<CharacterBody2D, Unit, Vector2> =
        MethodStringName1<CharacterBody2D, Unit, Vector2>("set_up_direction")

    @JvmField
    public val setMotionModeName: MethodStringName1<CharacterBody2D, Unit, MotionMode> =
        MethodStringName1<CharacterBody2D, Unit, MotionMode>("set_motion_mode")

    @JvmField
    public val getMotionModeName: MethodStringName0<CharacterBody2D, MotionMode> =
        MethodStringName0<CharacterBody2D, MotionMode>("get_motion_mode")

    @JvmField
    public val setPlatformOnLeaveName: MethodStringName1<CharacterBody2D, Unit, PlatformOnLeave> =
        MethodStringName1<CharacterBody2D, Unit, PlatformOnLeave>("set_platform_on_leave")

    @JvmField
    public val getPlatformOnLeaveName: MethodStringName0<CharacterBody2D, PlatformOnLeave> =
        MethodStringName0<CharacterBody2D, PlatformOnLeave>("get_platform_on_leave")

    @JvmField
    public val isOnFloorName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_on_floor")

    @JvmField
    public val isOnFloorOnlyName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_on_floor_only")

    @JvmField
    public val isOnCeilingName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_on_ceiling")

    @JvmField
    public val isOnCeilingOnlyName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_on_ceiling_only")

    @JvmField
    public val isOnWallName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_on_wall")

    @JvmField
    public val isOnWallOnlyName: MethodStringName0<CharacterBody2D, Boolean> =
        MethodStringName0<CharacterBody2D, Boolean>("is_on_wall_only")

    @JvmField
    public val getFloorNormalName: MethodStringName0<CharacterBody2D, Vector2> =
        MethodStringName0<CharacterBody2D, Vector2>("get_floor_normal")

    @JvmField
    public val getWallNormalName: MethodStringName0<CharacterBody2D, Vector2> =
        MethodStringName0<CharacterBody2D, Vector2>("get_wall_normal")

    @JvmField
    public val getLastMotionName: MethodStringName0<CharacterBody2D, Vector2> =
        MethodStringName0<CharacterBody2D, Vector2>("get_last_motion")

    @JvmField
    public val getPositionDeltaName: MethodStringName0<CharacterBody2D, Vector2> =
        MethodStringName0<CharacterBody2D, Vector2>("get_position_delta")

    @JvmField
    public val getRealVelocityName: MethodStringName0<CharacterBody2D, Vector2> =
        MethodStringName0<CharacterBody2D, Vector2>("get_real_velocity")

    @JvmField
    public val getFloorAngleName: MethodStringName1<CharacterBody2D, Float, Vector2> =
        MethodStringName1<CharacterBody2D, Float, Vector2>("get_floor_angle")

    @JvmField
    public val getPlatformVelocityName: MethodStringName0<CharacterBody2D, Vector2> =
        MethodStringName0<CharacterBody2D, Vector2>("get_platform_velocity")

    @JvmField
    public val getSlideCollisionCountName: MethodStringName0<CharacterBody2D, Int> =
        MethodStringName0<CharacterBody2D, Int>("get_slide_collision_count")

    @JvmField
    public val getSlideCollisionName: MethodStringName1<CharacterBody2D, KinematicCollision2D?, Int>
        = MethodStringName1<CharacterBody2D, KinematicCollision2D?, Int>("get_slide_collision")

    @JvmField
    public val getLastSlideCollisionName: MethodStringName0<CharacterBody2D, KinematicCollision2D?>
        = MethodStringName0<CharacterBody2D, KinematicCollision2D?>("get_last_slide_collision")
  }

  public object MethodBindings {
    internal val moveAndSlidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "move_and_slide", 2240911060)

    internal val applyFloorSnapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "apply_floor_snap", 3218959716)

    internal val setVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_velocity", 743155724)

    internal val getVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_velocity", 3341600327)

    internal val setSafeMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_safe_margin", 373806689)

    internal val getSafeMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_safe_margin", 1740695150)

    internal val isFloorStopOnSlopeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_floor_stop_on_slope_enabled", 36873697)

    internal val setFloorStopOnSlopeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_floor_stop_on_slope_enabled", 2586408642)

    internal val setFloorConstantSpeedEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_floor_constant_speed_enabled", 2586408642)

    internal val isFloorConstantSpeedEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_floor_constant_speed_enabled", 36873697)

    internal val setFloorBlockOnWallEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_floor_block_on_wall_enabled", 2586408642)

    internal val isFloorBlockOnWallEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_floor_block_on_wall_enabled", 36873697)

    internal val setSlideOnCeilingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_slide_on_ceiling_enabled", 2586408642)

    internal val isSlideOnCeilingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_slide_on_ceiling_enabled", 36873697)

    internal val setPlatformFloorLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_platform_floor_layers", 1286410249)

    internal val getPlatformFloorLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_platform_floor_layers", 3905245786)

    internal val setPlatformWallLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_platform_wall_layers", 1286410249)

    internal val getPlatformWallLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_platform_wall_layers", 3905245786)

    internal val getMaxSlidesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_max_slides", 3905245786)

    internal val setMaxSlidesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_max_slides", 1286410249)

    internal val getFloorMaxAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_floor_max_angle", 1740695150)

    internal val setFloorMaxAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_floor_max_angle", 373806689)

    internal val getFloorSnapLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_floor_snap_length", 191475506)

    internal val setFloorSnapLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_floor_snap_length", 373806689)

    internal val getWallMinSlideAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_wall_min_slide_angle", 1740695150)

    internal val setWallMinSlideAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_wall_min_slide_angle", 373806689)

    internal val getUpDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_up_direction", 3341600327)

    internal val setUpDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_up_direction", 743155724)

    internal val setMotionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_motion_mode", 1224392233)

    internal val getMotionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_motion_mode", 1160151236)

    internal val setPlatformOnLeavePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "set_platform_on_leave", 2423324375)

    internal val getPlatformOnLeavePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_platform_on_leave", 4054324341)

    internal val isOnFloorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_on_floor", 36873697)

    internal val isOnFloorOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_on_floor_only", 36873697)

    internal val isOnCeilingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_on_ceiling", 36873697)

    internal val isOnCeilingOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_on_ceiling_only", 36873697)

    internal val isOnWallPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_on_wall", 36873697)

    internal val isOnWallOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "is_on_wall_only", 36873697)

    internal val getFloorNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_floor_normal", 3341600327)

    internal val getWallNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_wall_normal", 3341600327)

    internal val getLastMotionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_last_motion", 3341600327)

    internal val getPositionDeltaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_position_delta", 3341600327)

    internal val getRealVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_real_velocity", 3341600327)

    internal val getFloorAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_floor_angle", 2841063350)

    internal val getPlatformVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_platform_velocity", 3341600327)

    internal val getSlideCollisionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_slide_collision_count", 3905245786)

    internal val getSlideCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_slide_collision", 860659811)

    internal val getLastSlideCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CharacterBody2D", "get_last_slide_collision", 2161834755)
  }
}
