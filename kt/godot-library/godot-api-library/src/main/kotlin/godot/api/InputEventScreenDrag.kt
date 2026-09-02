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
import godot.core.VariantParser.LONG
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

/**
 * Stores information about screen drag events. See [Node.Input].
 */
@GodotBaseType
public open class InputEventScreenDrag : InputEventFromWindow() {
  /**
   * The drag event index in the case of a multi-drag event.
   */
  public final inline var index: Int
    @JvmName("indexProperty")
    get() = getIndex()
    @JvmName("indexProperty")
    set(`value`) {
      setIndex(value)
    }

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
   */
  public final inline var penInverted: Boolean
    @JvmName("penInvertedProperty")
    get() = getPenInverted()
    @JvmName("penInvertedProperty")
    set(`value`) {
      setPenInverted(value)
    }

  /**
   * The drag position in the viewport the node is in, using the coordinate system of this viewport.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var position: Vector2
    @JvmName("positionProperty")
    get() = getPosition()
    @JvmName("positionProperty")
    set(`value`) {
      setPosition(value)
    }

  /**
   * The drag position relative to the previous position (position at the last frame).
   *
   * **Note:** [relative] is automatically scaled according to the content scale factor, which is
   * defined by the project's stretch mode settings. This means touch sensitivity will appear different
   * depending on resolution when using [relative] in a script that handles touch aiming. To avoid
   * this, use [screenRelative] instead.
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
   * The unscaled drag position relative to the previous position in screen coordinates (position at
   * the last frame). This position is *not* scaled according to the content scale factor or calls to
   * [InputEvent.xformedBy]. This should be preferred over [relative] for touch aiming regardless of
   * the project's stretch mode.
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
   * The drag velocity.
   *
   * **Note:** [velocity] is automatically scaled according to the content scale factor, which is
   * defined by the project's stretch mode settings. This means touch sensitivity will appear different
   * depending on resolution when using [velocity] in a script that handles touch aiming. To avoid
   * this, use [screenVelocity] instead.
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
   * The unscaled drag velocity in pixels per second in screen coordinates. This velocity is *not*
   * scaled according to the content scale factor or calls to [InputEvent.xformedBy]. This should be
   * preferred over [velocity] for touch aiming regardless of the project's stretch mode.
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
    createNativeObject(323, scriptPtr)
  }

  /**
   * This is a helper function for [tilt] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventscreendrag.tilt
   * //Your changes
   * inputeventscreendrag.tilt = myCoreType
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
   * This is a helper function for [position] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventscreendrag.position
   * //Your changes
   * inputeventscreendrag.position = myCoreType
   * ``````
   *
   * The drag position in the viewport the node is in, using the coordinate system of this viewport.
   */
  @CoreTypeHelper
  public final fun positionMutate(block: Vector2.() -> Unit): Vector2 = position.apply {
     block(this)
     position = this
  }

  /**
   * This is a helper function for [relative] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventscreendrag.relative
   * //Your changes
   * inputeventscreendrag.relative = myCoreType
   * ``````
   *
   * The drag position relative to the previous position (position at the last frame).
   *
   * **Note:** [relative] is automatically scaled according to the content scale factor, which is
   * defined by the project's stretch mode settings. This means touch sensitivity will appear different
   * depending on resolution when using [relative] in a script that handles touch aiming. To avoid
   * this, use [screenRelative] instead.
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
   * val myCoreType = inputeventscreendrag.screenRelative
   * //Your changes
   * inputeventscreendrag.screenRelative = myCoreType
   * ``````
   *
   * The unscaled drag position relative to the previous position in screen coordinates (position at
   * the last frame). This position is *not* scaled according to the content scale factor or calls to
   * [InputEvent.xformedBy]. This should be preferred over [relative] for touch aiming regardless of
   * the project's stretch mode.
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
   * val myCoreType = inputeventscreendrag.velocity
   * //Your changes
   * inputeventscreendrag.velocity = myCoreType
   * ``````
   *
   * The drag velocity.
   *
   * **Note:** [velocity] is automatically scaled according to the content scale factor, which is
   * defined by the project's stretch mode settings. This means touch sensitivity will appear different
   * depending on resolution when using [velocity] in a script that handles touch aiming. To avoid
   * this, use [screenVelocity] instead.
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
   * val myCoreType = inputeventscreendrag.screenVelocity
   * //Your changes
   * inputeventscreendrag.screenVelocity = myCoreType
   * ``````
   *
   * The unscaled drag velocity in pixels per second in screen coordinates. This velocity is *not*
   * scaled according to the content scale factor or calls to [InputEvent.xformedBy]. This should be
   * preferred over [velocity] for touch aiming regardless of the project's stretch mode.
   */
  @CoreTypeHelper
  public final fun screenVelocityMutate(block: Vector2.() -> Unit): Vector2 = screenVelocity.apply {
     block(this)
     screenVelocity = this
  }

  public final fun setIndex(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.setIndexPtr)
  }

  public final fun getIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
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

  public final fun setPosition(position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.setPositionPtr)
  }

  public final fun getPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
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
    public val setIndexName: MethodStringName1<InputEventScreenDrag, Unit, Int> =
        MethodStringName1<InputEventScreenDrag, Unit, Int>("set_index")

    @JvmField
    public val getIndexName: MethodStringName0<InputEventScreenDrag, Int> =
        MethodStringName0<InputEventScreenDrag, Int>("get_index")

    @JvmField
    public val setTiltName: MethodStringName1<InputEventScreenDrag, Unit, Vector2> =
        MethodStringName1<InputEventScreenDrag, Unit, Vector2>("set_tilt")

    @JvmField
    public val getTiltName: MethodStringName0<InputEventScreenDrag, Vector2> =
        MethodStringName0<InputEventScreenDrag, Vector2>("get_tilt")

    @JvmField
    public val setPressureName: MethodStringName1<InputEventScreenDrag, Unit, Float> =
        MethodStringName1<InputEventScreenDrag, Unit, Float>("set_pressure")

    @JvmField
    public val getPressureName: MethodStringName0<InputEventScreenDrag, Float> =
        MethodStringName0<InputEventScreenDrag, Float>("get_pressure")

    @JvmField
    public val setPenInvertedName: MethodStringName1<InputEventScreenDrag, Unit, Boolean> =
        MethodStringName1<InputEventScreenDrag, Unit, Boolean>("set_pen_inverted")

    @JvmField
    public val getPenInvertedName: MethodStringName0<InputEventScreenDrag, Boolean> =
        MethodStringName0<InputEventScreenDrag, Boolean>("get_pen_inverted")

    @JvmField
    public val setPositionName: MethodStringName1<InputEventScreenDrag, Unit, Vector2> =
        MethodStringName1<InputEventScreenDrag, Unit, Vector2>("set_position")

    @JvmField
    public val getPositionName: MethodStringName0<InputEventScreenDrag, Vector2> =
        MethodStringName0<InputEventScreenDrag, Vector2>("get_position")

    @JvmField
    public val setRelativeName: MethodStringName1<InputEventScreenDrag, Unit, Vector2> =
        MethodStringName1<InputEventScreenDrag, Unit, Vector2>("set_relative")

    @JvmField
    public val getRelativeName: MethodStringName0<InputEventScreenDrag, Vector2> =
        MethodStringName0<InputEventScreenDrag, Vector2>("get_relative")

    @JvmField
    public val setScreenRelativeName: MethodStringName1<InputEventScreenDrag, Unit, Vector2> =
        MethodStringName1<InputEventScreenDrag, Unit, Vector2>("set_screen_relative")

    @JvmField
    public val getScreenRelativeName: MethodStringName0<InputEventScreenDrag, Vector2> =
        MethodStringName0<InputEventScreenDrag, Vector2>("get_screen_relative")

    @JvmField
    public val setVelocityName: MethodStringName1<InputEventScreenDrag, Unit, Vector2> =
        MethodStringName1<InputEventScreenDrag, Unit, Vector2>("set_velocity")

    @JvmField
    public val getVelocityName: MethodStringName0<InputEventScreenDrag, Vector2> =
        MethodStringName0<InputEventScreenDrag, Vector2>("get_velocity")

    @JvmField
    public val setScreenVelocityName: MethodStringName1<InputEventScreenDrag, Unit, Vector2> =
        MethodStringName1<InputEventScreenDrag, Unit, Vector2>("set_screen_velocity")

    @JvmField
    public val getScreenVelocityName: MethodStringName0<InputEventScreenDrag, Vector2> =
        MethodStringName0<InputEventScreenDrag, Vector2>("get_screen_velocity")
  }

  public object MethodBindings {
    internal val setIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_index", 1286410249)

    internal val getIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_index", 3905245786)

    internal val setTiltPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_tilt", 743155724)

    internal val getTiltPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_tilt", 3341600327)

    internal val setPressurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_pressure", 373806689)

    internal val getPressurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_pressure", 1740695150)

    internal val setPenInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_pen_inverted", 2586408642)

    internal val getPenInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_pen_inverted", 36873697)

    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_position", 743155724)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_position", 3341600327)

    internal val setRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_relative", 743155724)

    internal val getRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_relative", 3341600327)

    internal val setScreenRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_screen_relative", 743155724)

    internal val getScreenRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_screen_relative", 3341600327)

    internal val setVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_velocity", 743155724)

    internal val getVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_velocity", 3341600327)

    internal val setScreenVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "set_screen_velocity", 743155724)

    internal val getScreenVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenDrag", "get_screen_velocity", 3341600327)
  }
}
