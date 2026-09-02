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
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.Plane
import godot.core.Projection
import godot.core.RID
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PROJECTION
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR3
import godot.core.VariantParser._RID
import godot.core.Vector2
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
 * [Camera3D] is a special node that displays what is visible from its current location. Cameras
 * register themselves in the nearest [Viewport] node (when ascending the tree). Only one camera can be
 * active per viewport. If no viewport is available ascending the tree, the camera will register in the
 * global viewport. In other words, a camera just provides 3D display capabilities to a [Viewport],
 * and, without one, a scene registered in that [Viewport] (or higher viewports) can't be displayed.
 */
@GodotBaseType
public open class Camera3D : Node3D() {
  /**
   * The axis to lock during [fov]/[size] adjustments. Can be either [KEEP_WIDTH] or [KEEP_HEIGHT].
   */
  public final inline var keepAspect: KeepAspect
    @JvmName("keepAspectProperty")
    get() = getKeepAspectMode()
    @JvmName("keepAspectProperty")
    set(`value`) {
      setKeepAspectMode(value)
    }

  /**
   * The culling mask that describes which [VisualInstance3D.layers] are rendered by this camera. By
   * default, all 20 user-visible layers are rendered.
   *
   * **Note:** Since the [cullMask] allows for 32 layers to be stored in total, there are an
   * additional 12 layers that are only used internally by the engine and aren't exposed in the editor.
   * Setting [cullMask] using a script allows you to toggle those reserved layers, which can be useful
   * for editor plugins.
   *
   * To adjust [cullMask] more easily using a script, use [getCullMaskValue] and [setCullMaskValue].
   *
   * **Note:** [VoxelGI], SDFGI and [LightmapGI] will always take all layers into account to
   * determine what contributes to global illumination. If this is an issue, set
   * [GeometryInstance3D.giMode] to [GeometryInstance3D.GI_MODE_DISABLED] for meshes and
   * [Light3D.lightBakeMode] to [Light3D.BAKE_DISABLED] for lights to exclude them from global
   * illumination.
   */
  public final inline var cullMask: Long
    @JvmName("cullMaskProperty")
    get() = getCullMask()
    @JvmName("cullMaskProperty")
    set(`value`) {
      setCullMask(value)
    }

  /**
   * The [Environment] to use for this camera.
   */
  public final inline var environment: Environment?
    @JvmName("environmentProperty")
    get() = getEnvironment()
    @JvmName("environmentProperty")
    set(`value`) {
      setEnvironment(value)
    }

  /**
   * The [CameraAttributes] to use for this camera.
   */
  public final inline var attributes: CameraAttributes?
    @JvmName("attributesProperty")
    get() = getAttributes()
    @JvmName("attributesProperty")
    set(`value`) {
      setAttributes(value)
    }

  /**
   * The [Compositor] to use for this camera.
   */
  public final inline var compositor: Compositor?
    @JvmName("compositorProperty")
    get() = getCompositor()
    @JvmName("compositorProperty")
    set(`value`) {
      setCompositor(value)
    }

  /**
   * The horizontal (X) offset of the camera viewport.
   */
  public final inline var hOffset: Float
    @JvmName("hOffsetProperty")
    get() = getHOffset()
    @JvmName("hOffsetProperty")
    set(`value`) {
      setHOffset(value)
    }

  /**
   * The vertical (Y) offset of the camera viewport.
   */
  public final inline var vOffset: Float
    @JvmName("vOffsetProperty")
    get() = getVOffset()
    @JvmName("vOffsetProperty")
    set(`value`) {
      setVOffset(value)
    }

  /**
   * If not [DOPPLER_TRACKING_DISABLED], this camera will simulate the
   * [url=https://en.wikipedia.org/wiki/Doppler_effect]Doppler effect[/url] for objects changed in
   * particular `_process` methods.
   *
   * **Note:** The Doppler effect will only be heard on [AudioStreamPlayer3D]s if
   * [AudioStreamPlayer3D.dopplerTracking] is not set to
   * [AudioStreamPlayer3D.DOPPLER_TRACKING_DISABLED].
   */
  public final inline var dopplerTracking: DopplerTracking
    @JvmName("dopplerTrackingProperty")
    get() = getDopplerTracking()
    @JvmName("dopplerTrackingProperty")
    set(`value`) {
      setDopplerTracking(value)
    }

  /**
   * The camera's projection mode. In [PROJECTION_PERSPECTIVE] mode, objects' Z distance from the
   * camera's local space scales their perceived size.
   */
  public final inline var projection: ProjectionType
    @JvmName("projectionProperty")
    get() = getProjection()
    @JvmName("projectionProperty")
    set(`value`) {
      setProjection(value)
    }

  /**
   * If `true`, the ancestor [Viewport] is currently using this camera.
   *
   * If multiple cameras are in the scene, one will always be made current. For example, if two
   * [Camera3D] nodes are present in the scene and only one is current, setting one camera's [current]
   * to `false` will cause the other camera to be made current.
   */
  public final inline var current: Boolean
    @JvmName("currentProperty")
    get() = isCurrent()
    @JvmName("currentProperty")
    set(`value`) {
      setCurrent(value)
    }

  /**
   * The camera's field of view angle (in degrees). Only applicable in perspective mode. Since
   * [keepAspect] locks one axis, [fov] sets the other axis' field of view angle.
   *
   * For reference, the default vertical field of view value (`75.0`) is equivalent to a horizontal
   * FOV of:
   *
   * - ~91.31 degrees in a 4:3 viewport
   *
   * - ~101.67 degrees in a 16:10 viewport
   *
   * - ~107.51 degrees in a 16:9 viewport
   *
   * - ~121.63 degrees in a 21:9 viewport
   */
  public final inline var fov: Float
    @JvmName("fovProperty")
    get() = getFov()
    @JvmName("fovProperty")
    set(`value`) {
      setFov(value)
    }

  /**
   * The camera's size in meters measured as the diameter of the width or height, depending on
   * [keepAspect]. Only applicable in orthogonal and frustum modes.
   */
  public final inline var size: Float
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  /**
   * The camera's frustum offset. This can be changed from the default to create "tilted frustum"
   * effects such as [url=https://zdoom.org/wiki/Y-shearing]Y-shearing[/url].
   *
   * **Note:** Only effective if [projection] is [PROJECTION_FRUSTUM].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var frustumOffset: Vector2
    @JvmName("frustumOffsetProperty")
    get() = getFrustumOffset()
    @JvmName("frustumOffsetProperty")
    set(`value`) {
      setFrustumOffset(value)
    }

  /**
   * The distance to the near culling boundary for this camera relative to its local Z axis. Lower
   * values allow the camera to see objects more up close to its origin, at the cost of lower precision
   * across the *entire* range. Values lower than the default can lead to increased Z-fighting.
   */
  public final inline var near: Float
    @JvmName("nearProperty")
    get() = getNear()
    @JvmName("nearProperty")
    set(`value`) {
      setNear(value)
    }

  /**
   * The distance to the far culling boundary for this camera relative to its local Z axis. Higher
   * values allow the camera to see further away, while decreasing [far] can improve performance if it
   * results in objects being partially or fully culled.
   */
  public final inline var far: Float
    @JvmName("farProperty")
    get() = getFar()
    @JvmName("farProperty")
    set(`value`) {
      setFar(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(136, scriptPtr)
  }

  /**
   * This is a helper function for [frustumOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = camera3d.frustumOffset
   * //Your changes
   * camera3d.frustumOffset = myCoreType
   * ``````
   *
   * The camera's frustum offset. This can be changed from the default to create "tilted frustum"
   * effects such as [url=https://zdoom.org/wiki/Y-shearing]Y-shearing[/url].
   *
   * **Note:** Only effective if [projection] is [PROJECTION_FRUSTUM].
   */
  @CoreTypeHelper
  public final fun frustumOffsetMutate(block: Vector2.() -> Unit): Vector2 = frustumOffset.apply {
     block(this)
     frustumOffset = this
  }

  /**
   * Returns a normal vector in world space, that is the result of projecting a point on the
   * [Viewport] rectangle by the inverse camera projection. This is useful for casting rays in the form
   * of (origin, normal) for object intersection or picking.
   */
  public final fun projectRayNormal(screenPoint: Vector2): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to screenPoint)
    TransferContext.callMethod(MethodBindings.projectRayNormalPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns a normal vector from the screen point location directed along the camera. Orthogonal
   * cameras are normalized. Perspective cameras account for perspective, screen width/height, etc.
   */
  public final fun projectLocalRayNormal(screenPoint: Vector2): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to screenPoint)
    TransferContext.callMethod(MethodBindings.projectLocalRayNormalPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns a 3D position in world space, that is the result of projecting a point on the
   * [Viewport] rectangle by the inverse camera projection. This is useful for casting rays in the form
   * of (origin, normal) for object intersection or picking.
   */
  public final fun projectRayOrigin(screenPoint: Vector2): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to screenPoint)
    TransferContext.callMethod(MethodBindings.projectRayOriginPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the 2D coordinate in the [Viewport] rectangle that maps to the given 3D point in world
   * space.
   *
   * **Note:** When using this to position GUI elements over a 3D viewport, use [isPositionBehind]
   * to prevent them from appearing if the 3D point is behind the camera:
   *
   * ```
   * # This code block is part of a script that inherits from Node3D.
   * # `control` is a reference to a node inheriting from Control.
   * control.visible = not
   * get_viewport().get_camera_3d().is_position_behind(global_transform.origin)
   * control.position = get_viewport().get_camera_3d().unproject_position(global_transform.origin)
   * ```
   */
  public final fun unprojectPosition(worldPoint: Vector3): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to worldPoint)
    TransferContext.callMethod(MethodBindings.unprojectPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns `true` if the given position is behind the camera (the blue part of the linked
   * diagram).
   * [url=https://raw.githubusercontent.com/godotengine/godot-docs/master/img/camera3d_position_frustum.png]See
   * this diagram[/url] for an overview of position query methods.
   *
   * **Note:** A position which returns `false` may still be outside the camera's field of view.
   */
  public final fun isPositionBehind(worldPoint: Vector3): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to worldPoint)
    TransferContext.callMethod(MethodBindings.isPositionBehindPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the 3D point in world space that maps to the given 2D coordinate in the [Viewport]
   * rectangle on a plane that is the given [zDepth] distance into the scene away from the camera.
   */
  public final fun projectPosition(screenPoint: Vector2, zDepth: Float): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to screenPoint, DOUBLE to zDepth.toDouble())
    TransferContext.callMethod(MethodBindings.projectPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the camera projection to perspective mode (see [PROJECTION_PERSPECTIVE]), by specifying a
   * [fov] (field of view) angle in degrees, and the [zNear] and [zFar] clip planes in world space
   * units.
   */
  public final fun setPerspective(
    fov: Float,
    zNear: Float,
    zFar: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fov.toDouble(), DOUBLE to zNear.toDouble(), DOUBLE to zFar.toDouble())
    TransferContext.callMethod(MethodBindings.setPerspectivePtr)
  }

  /**
   * Sets the camera projection to orthogonal mode (see [PROJECTION_ORTHOGONAL]), by specifying a
   * [size], and the [zNear] and [zFar] clip planes in world space units.
   *
   * As a hint, 3D games that look 2D often use this projection, with [size] specified in pixels.
   */
  public final fun setOrthogonal(
    size: Float,
    zNear: Float,
    zFar: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble(), DOUBLE to zNear.toDouble(), DOUBLE to zFar.toDouble())
    TransferContext.callMethod(MethodBindings.setOrthogonalPtr)
  }

  /**
   * Sets the camera projection to frustum mode (see [PROJECTION_FRUSTUM]), by specifying a [size],
   * an [offset], and the [zNear] and [zFar] clip planes in world space units. The [size] parameter
   * represents the size of the near plane, either its width or height depending on the value of
   * [keepAspect]. See also [frustumOffset].
   */
  public final fun setFrustum(
    size: Float,
    offset: Vector2,
    zNear: Float,
    zFar: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble(), VECTOR2 to offset, DOUBLE to zNear.toDouble(), DOUBLE to zFar.toDouble())
    TransferContext.callMethod(MethodBindings.setFrustumPtr)
  }

  /**
   * Makes this camera the current camera for the [Viewport] (see class description). If the camera
   * node is outside the scene tree, it will attempt to become current once it's added.
   */
  public final fun makeCurrent(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.makeCurrentPtr)
  }

  /**
   * If this is the current camera, remove it from being current. If [enableNext] is `true`, request
   * to make the next camera current, if any.
   */
  @JvmOverloads
  public final fun clearCurrent(enableNext: Boolean = true): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enableNext)
    TransferContext.callMethod(MethodBindings.clearCurrentPtr)
  }

  public final fun setCurrent(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCurrentPtr)
  }

  public final fun isCurrent(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCurrentPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the transform of the camera plus the vertical ([vOffset]) and horizontal ([hOffset])
   * offsets; and any other adjustments made to the position and orientation of the camera by
   * subclassed cameras such as [XRCamera3D].
   */
  public final fun getCameraTransform(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Returns the projection matrix that this camera uses to render to its associated viewport. The
   * camera must be part of the scene tree to function.
   */
  public final fun getCameraProjection(): Projection {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraProjectionPtr)
    return (TransferContext.readReturnValue(PROJECTION) as Projection)
  }

  public final fun getFov(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFovPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getFrustumOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrustumOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun getSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getFar(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFarPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getNear(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNearPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFov(fov: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fov.toDouble())
    TransferContext.callMethod(MethodBindings.setFovPtr)
  }

  public final fun setFrustumOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setFrustumOffsetPtr)
  }

  public final fun setSize(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun setFar(far: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to far.toDouble())
    TransferContext.callMethod(MethodBindings.setFarPtr)
  }

  public final fun setNear(near: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to near.toDouble())
    TransferContext.callMethod(MethodBindings.setNearPtr)
  }

  public final fun getProjection(): ProjectionType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProjectionPtr)
    return ProjectionType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setProjection(mode: ProjectionType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setProjectionPtr)
  }

  public final fun setHOffset(offset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.setHOffsetPtr)
  }

  public final fun getHOffset(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVOffset(offset: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.setVOffsetPtr)
  }

  public final fun getVOffset(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVOffsetPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCullMask(mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask)
    TransferContext.callMethod(MethodBindings.setCullMaskPtr)
  }

  public final fun getCullMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCullMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setEnvironment(env: Environment?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to env)
    TransferContext.callMethod(MethodBindings.setEnvironmentPtr)
  }

  public final fun getEnvironment(): Environment? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnvironmentPtr)
    return (TransferContext.readReturnValue(OBJECT) as Environment?)
  }

  public final fun setAttributes(env: CameraAttributes?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to env)
    TransferContext.callMethod(MethodBindings.setAttributesPtr)
  }

  public final fun getAttributes(): CameraAttributes? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAttributesPtr)
    return (TransferContext.readReturnValue(OBJECT) as CameraAttributes?)
  }

  public final fun setCompositor(compositor: Compositor?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to compositor)
    TransferContext.callMethod(MethodBindings.setCompositorPtr)
  }

  public final fun getCompositor(): Compositor? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCompositorPtr)
    return (TransferContext.readReturnValue(OBJECT) as Compositor?)
  }

  public final fun setKeepAspectMode(mode: KeepAspect): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setKeepAspectModePtr)
  }

  public final fun getKeepAspectMode(): KeepAspect {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getKeepAspectModePtr)
    return KeepAspect.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDopplerTracking(mode: DopplerTracking): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setDopplerTrackingPtr)
  }

  public final fun getDopplerTracking(): DopplerTracking {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDopplerTrackingPtr)
    return DopplerTracking.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the camera's frustum planes in world space units as an array of [Plane]s in the
   * following order: near, far, left, top, right, bottom. Not to be confused with [frustumOffset].
   */
  public final fun getFrustum(): VariantArray<Plane> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrustumPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Plane>)
  }

  /**
   * Returns `true` if the given position is inside the camera's frustum (the green part of the
   * linked diagram).
   * [url=https://raw.githubusercontent.com/godotengine/godot-docs/master/img/camera3d_position_frustum.png]See
   * this diagram[/url] for an overview of position query methods.
   */
  public final fun isPositionInFrustum(worldPoint: Vector3): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to worldPoint)
    TransferContext.callMethod(MethodBindings.isPositionInFrustumPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the camera's RID from the [RenderingServer].
   */
  public final fun getCameraRid(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the RID of a pyramid shape encompassing the camera's view frustum, ignoring the
   * camera's near plane. The tip of the pyramid represents the position of the camera.
   */
  public final fun getPyramidShapeRid(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPyramidShapeRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Based on [value], enables or disables the specified layer in the [cullMask], given a
   * [layerNumber] between 1 and 20.
   */
  public final fun setCullMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong(), BOOL to value)
    TransferContext.callMethod(MethodBindings.setCullMaskValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [cullMask] is enabled, given a [layerNumber]
   * between 1 and 20.
   */
  public final fun getCullMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getCullMaskValuePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class ProjectionType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Perspective projection. Objects on the screen becomes smaller when they are far away.
     */
    PERSPECTIVE(0),
    /**
     * Orthogonal projection, also known as orthographic projection. Objects remain the same size on
     * the screen no matter how far away they are.
     */
    ORTHOGONAL(1),
    /**
     * Frustum projection. This mode allows adjusting [frustumOffset] to create "tilted frustum"
     * effects.
     */
    FRUSTUM(2),
    ;

    public companion object {
      public fun from(`value`: Long): ProjectionType = entries.single { it.`value` == `value` }
    }
  }

  public enum class KeepAspect(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Preserves the horizontal aspect ratio; also known as Vert- scaling. This is usually the best
     * option for projects running in portrait mode, as taller aspect ratios will benefit from a wider
     * vertical FOV.
     */
    WIDTH(0),
    /**
     * Preserves the vertical aspect ratio; also known as Hor+ scaling. This is usually the best
     * option for projects running in landscape mode, as wider aspect ratios will automatically benefit
     * from a wider horizontal FOV.
     */
    HEIGHT(1),
    ;

    public companion object {
      public fun from(`value`: Long): KeepAspect = entries.single { it.`value` == `value` }
    }
  }

  public enum class DopplerTracking(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables [url=https://en.wikipedia.org/wiki/Doppler_effect]Doppler effect[/url] simulation
     * (default).
     */
    DISABLED(0),
    /**
     * Simulate [url=https://en.wikipedia.org/wiki/Doppler_effect]Doppler effect[/url] by tracking
     * positions of objects that are changed in `_process`. Changes in the relative velocity of this
     * camera compared to those objects affect how audio is perceived (changing the audio's
     * [AudioStreamPlayer3D.pitchScale]).
     */
    IDLE_STEP(1),
    /**
     * Simulate [url=https://en.wikipedia.org/wiki/Doppler_effect]Doppler effect[/url] by tracking
     * positions of objects that are changed in `_physics_process`. Changes in the relative velocity of
     * this camera compared to those objects affect how audio is perceived (changing the audio's
     * [AudioStreamPlayer3D.pitchScale]).
     */
    PHYSICS_STEP(2),
    ;

    public companion object {
      public fun from(`value`: Long): DopplerTracking = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val projectRayNormalName: MethodStringName1<Camera3D, Vector3, Vector2> =
        MethodStringName1<Camera3D, Vector3, Vector2>("project_ray_normal")

    @JvmField
    public val projectLocalRayNormalName: MethodStringName1<Camera3D, Vector3, Vector2> =
        MethodStringName1<Camera3D, Vector3, Vector2>("project_local_ray_normal")

    @JvmField
    public val projectRayOriginName: MethodStringName1<Camera3D, Vector3, Vector2> =
        MethodStringName1<Camera3D, Vector3, Vector2>("project_ray_origin")

    @JvmField
    public val unprojectPositionName: MethodStringName1<Camera3D, Vector2, Vector3> =
        MethodStringName1<Camera3D, Vector2, Vector3>("unproject_position")

    @JvmField
    public val isPositionBehindName: MethodStringName1<Camera3D, Boolean, Vector3> =
        MethodStringName1<Camera3D, Boolean, Vector3>("is_position_behind")

    @JvmField
    public val projectPositionName: MethodStringName2<Camera3D, Vector3, Vector2, Float> =
        MethodStringName2<Camera3D, Vector3, Vector2, Float>("project_position")

    @JvmField
    public val setPerspectiveName: MethodStringName3<Camera3D, Unit, Float, Float, Float> =
        MethodStringName3<Camera3D, Unit, Float, Float, Float>("set_perspective")

    @JvmField
    public val setOrthogonalName: MethodStringName3<Camera3D, Unit, Float, Float, Float> =
        MethodStringName3<Camera3D, Unit, Float, Float, Float>("set_orthogonal")

    @JvmField
    public val setFrustumName: MethodStringName4<Camera3D, Unit, Float, Vector2, Float, Float> =
        MethodStringName4<Camera3D, Unit, Float, Vector2, Float, Float>("set_frustum")

    @JvmField
    public val makeCurrentName: MethodStringName0<Camera3D, Unit> =
        MethodStringName0<Camera3D, Unit>("make_current")

    @JvmField
    public val clearCurrentName: MethodStringName1<Camera3D, Unit, Boolean> =
        MethodStringName1<Camera3D, Unit, Boolean>("clear_current")

    @JvmField
    public val setCurrentName: MethodStringName1<Camera3D, Unit, Boolean> =
        MethodStringName1<Camera3D, Unit, Boolean>("set_current")

    @JvmField
    public val isCurrentName: MethodStringName0<Camera3D, Boolean> =
        MethodStringName0<Camera3D, Boolean>("is_current")

    @JvmField
    public val getCameraTransformName: MethodStringName0<Camera3D, Transform3D> =
        MethodStringName0<Camera3D, Transform3D>("get_camera_transform")

    @JvmField
    public val getCameraProjectionName: MethodStringName0<Camera3D, Projection> =
        MethodStringName0<Camera3D, Projection>("get_camera_projection")

    @JvmField
    public val getFovName: MethodStringName0<Camera3D, Float> =
        MethodStringName0<Camera3D, Float>("get_fov")

    @JvmField
    public val getFrustumOffsetName: MethodStringName0<Camera3D, Vector2> =
        MethodStringName0<Camera3D, Vector2>("get_frustum_offset")

    @JvmField
    public val getSizeName: MethodStringName0<Camera3D, Float> =
        MethodStringName0<Camera3D, Float>("get_size")

    @JvmField
    public val getFarName: MethodStringName0<Camera3D, Float> =
        MethodStringName0<Camera3D, Float>("get_far")

    @JvmField
    public val getNearName: MethodStringName0<Camera3D, Float> =
        MethodStringName0<Camera3D, Float>("get_near")

    @JvmField
    public val setFovName: MethodStringName1<Camera3D, Unit, Float> =
        MethodStringName1<Camera3D, Unit, Float>("set_fov")

    @JvmField
    public val setFrustumOffsetName: MethodStringName1<Camera3D, Unit, Vector2> =
        MethodStringName1<Camera3D, Unit, Vector2>("set_frustum_offset")

    @JvmField
    public val setSizeName: MethodStringName1<Camera3D, Unit, Float> =
        MethodStringName1<Camera3D, Unit, Float>("set_size")

    @JvmField
    public val setFarName: MethodStringName1<Camera3D, Unit, Float> =
        MethodStringName1<Camera3D, Unit, Float>("set_far")

    @JvmField
    public val setNearName: MethodStringName1<Camera3D, Unit, Float> =
        MethodStringName1<Camera3D, Unit, Float>("set_near")

    @JvmField
    public val getProjectionName: MethodStringName0<Camera3D, ProjectionType> =
        MethodStringName0<Camera3D, ProjectionType>("get_projection")

    @JvmField
    public val setProjectionName: MethodStringName1<Camera3D, Unit, ProjectionType> =
        MethodStringName1<Camera3D, Unit, ProjectionType>("set_projection")

    @JvmField
    public val setHOffsetName: MethodStringName1<Camera3D, Unit, Float> =
        MethodStringName1<Camera3D, Unit, Float>("set_h_offset")

    @JvmField
    public val getHOffsetName: MethodStringName0<Camera3D, Float> =
        MethodStringName0<Camera3D, Float>("get_h_offset")

    @JvmField
    public val setVOffsetName: MethodStringName1<Camera3D, Unit, Float> =
        MethodStringName1<Camera3D, Unit, Float>("set_v_offset")

    @JvmField
    public val getVOffsetName: MethodStringName0<Camera3D, Float> =
        MethodStringName0<Camera3D, Float>("get_v_offset")

    @JvmField
    public val setCullMaskName: MethodStringName1<Camera3D, Unit, Long> =
        MethodStringName1<Camera3D, Unit, Long>("set_cull_mask")

    @JvmField
    public val getCullMaskName: MethodStringName0<Camera3D, Long> =
        MethodStringName0<Camera3D, Long>("get_cull_mask")

    @JvmField
    public val setEnvironmentName: MethodStringName1<Camera3D, Unit, Environment?> =
        MethodStringName1<Camera3D, Unit, Environment?>("set_environment")

    @JvmField
    public val getEnvironmentName: MethodStringName0<Camera3D, Environment?> =
        MethodStringName0<Camera3D, Environment?>("get_environment")

    @JvmField
    public val setAttributesName: MethodStringName1<Camera3D, Unit, CameraAttributes?> =
        MethodStringName1<Camera3D, Unit, CameraAttributes?>("set_attributes")

    @JvmField
    public val getAttributesName: MethodStringName0<Camera3D, CameraAttributes?> =
        MethodStringName0<Camera3D, CameraAttributes?>("get_attributes")

    @JvmField
    public val setCompositorName: MethodStringName1<Camera3D, Unit, Compositor?> =
        MethodStringName1<Camera3D, Unit, Compositor?>("set_compositor")

    @JvmField
    public val getCompositorName: MethodStringName0<Camera3D, Compositor?> =
        MethodStringName0<Camera3D, Compositor?>("get_compositor")

    @JvmField
    public val setKeepAspectModeName: MethodStringName1<Camera3D, Unit, KeepAspect> =
        MethodStringName1<Camera3D, Unit, KeepAspect>("set_keep_aspect_mode")

    @JvmField
    public val getKeepAspectModeName: MethodStringName0<Camera3D, KeepAspect> =
        MethodStringName0<Camera3D, KeepAspect>("get_keep_aspect_mode")

    @JvmField
    public val setDopplerTrackingName: MethodStringName1<Camera3D, Unit, DopplerTracking> =
        MethodStringName1<Camera3D, Unit, DopplerTracking>("set_doppler_tracking")

    @JvmField
    public val getDopplerTrackingName: MethodStringName0<Camera3D, DopplerTracking> =
        MethodStringName0<Camera3D, DopplerTracking>("get_doppler_tracking")

    @JvmField
    public val getFrustumName: MethodStringName0<Camera3D, VariantArray<Plane>> =
        MethodStringName0<Camera3D, VariantArray<Plane>>("get_frustum")

    @JvmField
    public val isPositionInFrustumName: MethodStringName1<Camera3D, Boolean, Vector3> =
        MethodStringName1<Camera3D, Boolean, Vector3>("is_position_in_frustum")

    @JvmField
    public val getCameraRidName: MethodStringName0<Camera3D, RID> =
        MethodStringName0<Camera3D, RID>("get_camera_rid")

    @JvmField
    public val getPyramidShapeRidName: MethodStringName0<Camera3D, RID> =
        MethodStringName0<Camera3D, RID>("get_pyramid_shape_rid")

    @JvmField
    public val setCullMaskValueName: MethodStringName2<Camera3D, Unit, Int, Boolean> =
        MethodStringName2<Camera3D, Unit, Int, Boolean>("set_cull_mask_value")

    @JvmField
    public val getCullMaskValueName: MethodStringName1<Camera3D, Boolean, Int> =
        MethodStringName1<Camera3D, Boolean, Int>("get_cull_mask_value")
  }

  public object MethodBindings {
    internal val projectRayNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "project_ray_normal", 1718073306)

    internal val projectLocalRayNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "project_local_ray_normal", 1718073306)

    internal val projectRayOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "project_ray_origin", 1718073306)

    internal val unprojectPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "unproject_position", 3758901831)

    internal val isPositionBehindPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "is_position_behind", 3108956480)

    internal val projectPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "project_position", 2171975744)

    internal val setPerspectivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_perspective", 2385087082)

    internal val setOrthogonalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_orthogonal", 2385087082)

    internal val setFrustumPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_frustum", 354890663)

    internal val makeCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "make_current", 3218959716)

    internal val clearCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "clear_current", 3216645846)

    internal val setCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_current", 2586408642)

    internal val isCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "is_current", 36873697)

    internal val getCameraTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_camera_transform", 3229777777)

    internal val getCameraProjectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_camera_projection", 2910717950)

    internal val getFovPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_fov", 1740695150)

    internal val getFrustumOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_frustum_offset", 3341600327)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_size", 1740695150)

    internal val getFarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_far", 1740695150)

    internal val getNearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_near", 1740695150)

    internal val setFovPtr: VoidPtr = TypeManager.getMethodBindPtr("Camera3D", "set_fov", 373806689)

    internal val setFrustumOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_frustum_offset", 743155724)

    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_size", 373806689)

    internal val setFarPtr: VoidPtr = TypeManager.getMethodBindPtr("Camera3D", "set_far", 373806689)

    internal val setNearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_near", 373806689)

    internal val getProjectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_projection", 2624185235)

    internal val setProjectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_projection", 4218540108)

    internal val setHOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_h_offset", 373806689)

    internal val getHOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_h_offset", 1740695150)

    internal val setVOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_v_offset", 373806689)

    internal val getVOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_v_offset", 1740695150)

    internal val setCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_cull_mask", 1286410249)

    internal val getCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_cull_mask", 3905245786)

    internal val setEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_environment", 4143518816)

    internal val getEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_environment", 3082064660)

    internal val setAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_attributes", 2817810567)

    internal val getAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_attributes", 3921283215)

    internal val setCompositorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_compositor", 1586754307)

    internal val getCompositorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_compositor", 3647707413)

    internal val setKeepAspectModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_keep_aspect_mode", 1740651252)

    internal val getKeepAspectModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_keep_aspect_mode", 2790278316)

    internal val setDopplerTrackingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_doppler_tracking", 3109431270)

    internal val getDopplerTrackingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_doppler_tracking", 1584483649)

    internal val getFrustumPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_frustum", 3995934104)

    internal val isPositionInFrustumPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "is_position_in_frustum", 3108956480)

    internal val getCameraRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_camera_rid", 2944877500)

    internal val getPyramidShapeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_pyramid_shape_rid", 529393457)

    internal val setCullMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "set_cull_mask_value", 300928843)

    internal val getCullMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Camera3D", "get_cull_mask_value", 1116898809)
  }
}
