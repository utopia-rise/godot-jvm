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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Stores information about a mouse or a pen motion. This includes relative position, absolute
 * position, and velocity. See [Node.Input].
 *
 * **Note:** By default, this event is only emitted once per frame rendered at most. If you need
 * more precise input reporting, set [Input.useAccumulatedInput] to `false` to make events emitted as
 * often as possible. If you use InputEventMouseMotion to draw lines, consider using
 * [Geometry2D.bresenhamLine] as well to avoid visible gaps in lines if the user is moving the mouse
 * quickly.
 *
 * **Note:** This event may be emitted even when the mouse hasn't moved, either by the operating
 * system or by Godot itself. If you really need to know if the mouse has moved (e.g. to suppress
 * displaying a tooltip), you should check that `relative.is_zero_approx()` is `false`.
 */
@GodotBaseType
public open class InputEventMouseMotion : InputEventMouse() {
  /**
   * Represents the angles of tilt of the pen. Positive X-coordinate value indicates a tilt to the
   * right. Positive Y-coordinate value indicates a tilt toward the user. Ranges from `-1.0` to `1.0`
   * for both axes.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tilt: Vector2
    @JvmName("tiltProperty")
    get() = getTilt()
    @JvmName("tiltProperty")
    set(`value`) {
      setTilt(value)
    }

  /**
   * Represents the pressure the user puts on the pen. Ranges from `0.0` to `1.0`.
   */
  public final inline var pressure: Float
    @JvmName("pressureProperty")
    get() = getPressure()
    @JvmName("pressureProperty")
    set(`value`) {
      setPressure(value)
    }

  /**
   * Returns `true` when using the eraser end of a stylus pen.
   *
   * **Note:** This property is implemented on Linux, macOS and Windows.
   */
  public final inline var penInverted: Boolean
    @JvmName("penInvertedProperty")
    get() = getPenInverted()
    @JvmName("penInvertedProperty")
    set(`value`) {
      setPenInverted(value)
    }

  /**
   * The mouse position relative to the previous position (position at the last frame).
   *
   * **Note:** Since [InputEventMouseMotion] may only be emitted when the mouse moves, it is not
   * possible to reliably detect when the mouse has stopped moving by checking this property. A
   * separate, short timer may be necessary.
   *
   * **Note:** [relative] is automatically scaled according to the content scale factor, which is
   * defined by the project's stretch mode settings. This means mouse sensitivity will appear different
   * depending on resolution when using [relative] in a script that handles mouse aiming with the
   * [Input.MOUSE_MODE_CAPTURED] mouse mode. To avoid this, use [screenRelative] instead.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var relative: Vector2
    @JvmName("relativeProperty")
    get() = getRelative()
    @JvmName("relativeProperty")
    set(`value`) {
      setRelative(value)
    }

  /**
   * The unscaled mouse position relative to the previous position in the coordinate system of the
   * screen (position at the last frame).
   *
   * **Note:** Since [InputEventMouseMotion] may only be emitted when the mouse moves, it is not
   * possible to reliably detect when the mouse has stopped moving by checking this property. A
   * separate, short timer may be necessary.
   *
   * **Note:** This coordinate is *not* scaled according to the content scale factor or calls to
   * [InputEvent.xformedBy]. This should be preferred over [relative] for mouse aiming when using the
   * [Input.MOUSE_MODE_CAPTURED] mouse mode, regardless of the project's stretch mode.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var screenRelative: Vector2
    @JvmName("screenRelativeProperty")
    get() = getScreenRelative()
    @JvmName("screenRelativeProperty")
    set(`value`) {
      setScreenRelative(value)
    }

  /**
   * The mouse velocity in pixels per second.
   *
   * **Note:** [velocity] is automatically scaled according to the content scale factor, which is
   * defined by the project's stretch mode settings. That means mouse sensitivity may appear different
   * depending on resolution.
   *
   * **Note:** In [Input.MOUSE_MODE_CAPTURED] mode, [velocity] returns `(0, 0)` because the mouse
   * cursor is hidden and locked. Use [screenRelative] for mouse aiming using the
   * [Input.MOUSE_MODE_CAPTURED] mouse mode.
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
   * The unscaled mouse velocity in pixels per second in screen coordinates. This velocity is *not*
   * scaled according to the content scale factor or calls to [InputEvent.xformedBy].
   *
   * **Note:** In [Input.MOUSE_MODE_CAPTURED] mode, [screenVelocity] returns `(0, 0)` because the
   * mouse cursor is hidden and locked. Use [screenRelative] for mouse aiming using the
   * [Input.MOUSE_MODE_CAPTURED] mouse mode.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var screenVelocity: Vector2
    @JvmName("screenVelocityProperty")
    get() = getScreenVelocity()
    @JvmName("screenVelocityProperty")
    set(`value`) {
      setScreenVelocity(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(321, scriptPtr)
  }

  /**
   * This is a helper function for [tilt] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventmousemotion.tilt
   * //Your changes
   * inputeventmousemotion.tilt = myCoreType
   * ``````
   *
   * Represents the angles of tilt of the pen. Positive X-coordinate value indicates a tilt to the
   * right. Positive Y-coordinate value indicates a tilt toward the user. Ranges from `-1.0` to `1.0`
   * for both axes.
   */
  @CoreTypeHelper
  public final fun tiltMutate(block: Vector2.() -> Unit): Vector2 = tilt.apply {
     block(this)
     tilt = this
  }

  /**
   * This is a helper function for [relative] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventmousemotion.relative
   * //Your changes
   * inputeventmousemotion.relative = myCoreType
   * ``````
   *
   * The mouse position relative to the previous position (position at the last frame).
   *
   * **Note:** Since [InputEventMouseMotion] may only be emitted when the mouse moves, it is not
   * possible to reliably detect when the mouse has stopped moving by checking this property. A
   * separate, short timer may be necessary.
   *
   * **Note:** [relative] is automatically scaled according to the content scale factor, which is
   * defined by the project's stretch mode settings. This means mouse sensitivity will appear different
   * depending on resolution when using [relative] in a script that handles mouse aiming with the
   * [Input.MOUSE_MODE_CAPTURED] mouse mode. To avoid this, use [screenRelative] instead.
   */
  @CoreTypeHelper
  public final fun relativeMutate(block: Vector2.() -> Unit): Vector2 = relative.apply {
     block(this)
     relative = this
  }

  /**
   * This is a helper function for [screenRelative] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventmousemotion.screenRelative
   * //Your changes
   * inputeventmousemotion.screenRelative = myCoreType
   * ``````
   *
   * The unscaled mouse position relative to the previous position in the coordinate system of the
   * screen (position at the last frame).
   *
   * **Note:** Since [InputEventMouseMotion] may only be emitted when the mouse moves, it is not
   * possible to reliably detect when the mouse has stopped moving by checking this property. A
   * separate, short timer may be necessary.
   *
   * **Note:** This coordinate is *not* scaled according to the content scale factor or calls to
   * [InputEvent.xformedBy]. This should be preferred over [relative] for mouse aiming when using the
   * [Input.MOUSE_MODE_CAPTURED] mouse mode, regardless of the project's stretch mode.
   */
  @CoreTypeHelper
  public final fun screenRelativeMutate(block: Vector2.() -> Unit): Vector2 = screenRelative.apply {
     block(this)
     screenRelative = this
  }

  /**
   * This is a helper function for [velocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventmousemotion.velocity
   * //Your changes
   * inputeventmousemotion.velocity = myCoreType
   * ``````
   *
   * The mouse velocity in pixels per second.
   *
   * **Note:** [velocity] is automatically scaled according to the content scale factor, which is
   * defined by the project's stretch mode settings. That means mouse sensitivity may appear different
   * depending on resolution.
   *
   * **Note:** In [Input.MOUSE_MODE_CAPTURED] mode, [velocity] returns `(0, 0)` because the mouse
   * cursor is hidden and locked. Use [screenRelative] for mouse aiming using the
   * [Input.MOUSE_MODE_CAPTURED] mouse mode.
   */
  @CoreTypeHelper
  public final fun velocityMutate(block: Vector2.() -> Unit): Vector2 = velocity.apply {
     block(this)
     velocity = this
  }

  /**
   * This is a helper function for [screenVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventmousemotion.screenVelocity
   * //Your changes
   * inputeventmousemotion.screenVelocity = myCoreType
   * ``````
   *
   * The unscaled mouse velocity in pixels per second in screen coordinates. This velocity is *not*
   * scaled according to the content scale factor or calls to [InputEvent.xformedBy].
   *
   * **Note:** In [Input.MOUSE_MODE_CAPTURED] mode, [screenVelocity] returns `(0, 0)` because the
   * mouse cursor is hidden and locked. Use [screenRelative] for mouse aiming using the
   * [Input.MOUSE_MODE_CAPTURED] mouse mode.
   */
  @CoreTypeHelper
  public final fun screenVelocityMutate(block: Vector2.() -> Unit): Vector2 = screenVelocity.apply {
     block(this)
     screenVelocity = this
  }

  public final fun setTilt(tilt: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to tilt)
    TransferContext.callMethod(MethodBindings.setTiltPtr)
  }

  public final fun getTilt(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTiltPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setPressure(pressure: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pressure.toDouble())
    TransferContext.callMethod(MethodBindings.setPressurePtr)
  }

  public final fun getPressure(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPressurePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPenInverted(penInverted: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to penInverted)
    TransferContext.callMethod(MethodBindings.setPenInvertedPtr)
  }

  public final fun getPenInverted(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPenInvertedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setRelative(relative: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to relative)
    TransferContext.callMethod(MethodBindings.setRelativePtr)
  }

  public final fun getRelative(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRelativePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setScreenRelative(relative: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to relative)
    TransferContext.callMethod(MethodBindings.setScreenRelativePtr)
  }

  public final fun getScreenRelative(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenRelativePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
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

  public final fun setScreenVelocity(velocity: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to velocity)
    TransferContext.callMethod(MethodBindings.setScreenVelocityPtr)
  }

  public final fun getScreenVelocity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScreenVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public companion object {
    @JvmField
    public val setTiltName: MethodStringName1<InputEventMouseMotion, Unit, Vector2> =
        MethodStringName1<InputEventMouseMotion, Unit, Vector2>("set_tilt")

    @JvmField
    public val getTiltName: MethodStringName0<InputEventMouseMotion, Vector2> =
        MethodStringName0<InputEventMouseMotion, Vector2>("get_tilt")

    @JvmField
    public val setPressureName: MethodStringName1<InputEventMouseMotion, Unit, Float> =
        MethodStringName1<InputEventMouseMotion, Unit, Float>("set_pressure")

    @JvmField
    public val getPressureName: MethodStringName0<InputEventMouseMotion, Float> =
        MethodStringName0<InputEventMouseMotion, Float>("get_pressure")

    @JvmField
    public val setPenInvertedName: MethodStringName1<InputEventMouseMotion, Unit, Boolean> =
        MethodStringName1<InputEventMouseMotion, Unit, Boolean>("set_pen_inverted")

    @JvmField
    public val getPenInvertedName: MethodStringName0<InputEventMouseMotion, Boolean> =
        MethodStringName0<InputEventMouseMotion, Boolean>("get_pen_inverted")

    @JvmField
    public val setRelativeName: MethodStringName1<InputEventMouseMotion, Unit, Vector2> =
        MethodStringName1<InputEventMouseMotion, Unit, Vector2>("set_relative")

    @JvmField
    public val getRelativeName: MethodStringName0<InputEventMouseMotion, Vector2> =
        MethodStringName0<InputEventMouseMotion, Vector2>("get_relative")

    @JvmField
    public val setScreenRelativeName: MethodStringName1<InputEventMouseMotion, Unit, Vector2> =
        MethodStringName1<InputEventMouseMotion, Unit, Vector2>("set_screen_relative")

    @JvmField
    public val getScreenRelativeName: MethodStringName0<InputEventMouseMotion, Vector2> =
        MethodStringName0<InputEventMouseMotion, Vector2>("get_screen_relative")

    @JvmField
    public val setVelocityName: MethodStringName1<InputEventMouseMotion, Unit, Vector2> =
        MethodStringName1<InputEventMouseMotion, Unit, Vector2>("set_velocity")

    @JvmField
    public val getVelocityName: MethodStringName0<InputEventMouseMotion, Vector2> =
        MethodStringName0<InputEventMouseMotion, Vector2>("get_velocity")

    @JvmField
    public val setScreenVelocityName: MethodStringName1<InputEventMouseMotion, Unit, Vector2> =
        MethodStringName1<InputEventMouseMotion, Unit, Vector2>("set_screen_velocity")

    @JvmField
    public val getScreenVelocityName: MethodStringName0<InputEventMouseMotion, Vector2> =
        MethodStringName0<InputEventMouseMotion, Vector2>("get_screen_velocity")
  }

  public object MethodBindings {
    internal val setTiltPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "set_tilt", 743155724)

    internal val getTiltPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "get_tilt", 3341600327)

    internal val setPressurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "set_pressure", 373806689)

    internal val getPressurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "get_pressure", 1740695150)

    internal val setPenInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "set_pen_inverted", 2586408642)

    internal val getPenInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "get_pen_inverted", 36873697)

    internal val setRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "set_relative", 743155724)

    internal val getRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "get_relative", 3341600327)

    internal val setScreenRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "set_screen_relative", 743155724)

    internal val getScreenRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "get_screen_relative", 3341600327)

    internal val setVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "set_velocity", 743155724)

    internal val getVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "get_velocity", 3341600327)

    internal val setScreenVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "set_screen_velocity", 743155724)

    internal val getScreenVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseMotion", "get_screen_velocity", 3341600327)
  }
}
