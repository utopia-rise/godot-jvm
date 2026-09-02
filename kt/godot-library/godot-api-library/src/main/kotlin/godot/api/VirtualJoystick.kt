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
import godot.core.Signal0
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.asCachedStringName
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A customizable on-screen joystick control designed for touchscreen devices. It allows users to
 * provide directional input by dragging a virtual tip within a defined circular area.
 *
 * This control can simulate directional actions (see [actionUp], [actionDown], [actionLeft], and
 * [actionRight]), which are triggered when the joystick is moved in the corresponding directions.
 */
@GodotBaseType
public open class VirtualJoystick : Control() {
  /**
   * Emitted when the joystick is pressed.
   */
  public val pressed: Signal0 by Signal0

  /**
   * Emitted when the joystick is released without moving the tip.
   */
  public val tapped: Signal0 by Signal0

  /**
   * Emitted when the joystick is released. The [inputVector] is the final input direction and
   * strength, with a length between `0.0` and `1.0`.
   */
  public val released: Signal1<Vector2> by Signal1

  /**
   * Emitted when the tip moved outside the deadzone and the joystick is released. The [inputVector]
   * contains the last input direction and strength before release. Its length is between `0.0` and
   * `1.0`.
   */
  public val flicked: Signal1<Vector2> by Signal1

  /**
   * Emitted when the tip enters the deadzone after being outside of it.
   */
  public val flickCanceled: Signal0 by Signal0

  /**
   * The joystick mode to use.
   */
  public final inline var joystickMode: JoystickMode
    @JvmName("joystickModeProperty")
    get() = getJoystickMode()
    @JvmName("joystickModeProperty")
    set(`value`) {
      setJoystickMode(value)
    }

  /**
   * The size of the joystick in pixels.
   */
  public final inline var joystickSize: Float
    @JvmName("joystickSizeProperty")
    get() = getJoystickSize()
    @JvmName("joystickSizeProperty")
    set(`value`) {
      setJoystickSize(value)
    }

  /**
   * The size of the joystick tip in pixels.
   */
  public final inline var tipSize: Float
    @JvmName("tipSizeProperty")
    get() = getTipSize()
    @JvmName("tipSizeProperty")
    set(`value`) {
      setTipSize(value)
    }

  /**
   * The ratio of the joystick size that defines the joystick deadzone. The joystick tip must move
   * beyond this ratio before being considered active.
   *
   * This deadzone is applied before triggering input actions and affects the joystick's input
   * vector and all related signals.
   *
   * Note that input actions may also define their own deadzones in the InputMap. If both are set,
   * the joystick deadzone is applied first, followed by the action's deadzone.
   *
   * By default, this value is `0.0`, meaning the joystick does not apply its own deadzone and
   * relies entirely on the InputMap action deadzones.
   */
  public final inline var deadzoneRatio: Float
    @JvmName("deadzoneRatioProperty")
    get() = getDeadzoneRatio()
    @JvmName("deadzoneRatioProperty")
    set(`value`) {
      setDeadzoneRatio(value)
    }

  /**
   * The multiplier applied to the joystick's radius that defines the clamp zone.
   *
   * This zone limits how far the joystick tip can move from its center before being clamped.
   *
   * A value of `1.0` means the tip can move up to the edge of the joystick's visual size.
   *
   * In [JOYSTICK_FOLLOWING] mode, this radius also determines how far the finger can move before
   * the joystick base starts following the touch input.
   */
  public final inline var clampzoneRatio: Float
    @JvmName("clampzoneRatioProperty")
    get() = getClampzoneRatio()
    @JvmName("clampzoneRatioProperty")
    set(`value`) {
      setClampzoneRatio(value)
    }

  /**
   * The initial position of the joystick as a ratio of the control's size. `(0, 0)` is top-left and
   * `(1, 1)` is bottom-right.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var initialOffsetRatio: Vector2
    @JvmName("initialOffsetRatioProperty")
    get() = getInitialOffsetRatio()
    @JvmName("initialOffsetRatioProperty")
    set(`value`) {
      setInitialOffsetRatio(value)
    }

  /**
   * The action to trigger when the joystick is moved left.
   */
  public final inline var actionLeft: StringName
    @JvmName("actionLeftProperty")
    get() = getActionLeft()
    @JvmName("actionLeftProperty")
    set(`value`) {
      setActionLeft(value)
    }

  /**
   * The action to trigger when the joystick is moved right.
   */
  public final inline var actionRight: StringName
    @JvmName("actionRightProperty")
    get() = getActionRight()
    @JvmName("actionRightProperty")
    set(`value`) {
      setActionRight(value)
    }

  /**
   * The action to trigger when the joystick is moved up.
   */
  public final inline var actionUp: StringName
    @JvmName("actionUpProperty")
    get() = getActionUp()
    @JvmName("actionUpProperty")
    set(`value`) {
      setActionUp(value)
    }

  /**
   * The action to trigger when the joystick is moved down.
   */
  public final inline var actionDown: StringName
    @JvmName("actionDownProperty")
    get() = getActionDown()
    @JvmName("actionDownProperty")
    set(`value`) {
      setActionDown(value)
    }

  /**
   * The visibility mode to use.
   */
  public final inline var visibilityMode: VisibilityMode
    @JvmName("visibilityModeProperty")
    get() = getVisibilityMode()
    @JvmName("visibilityModeProperty")
    set(`value`) {
      setVisibilityMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(798, scriptPtr)
  }

  /**
   * This is a helper function for [initialOffsetRatio] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = virtualjoystick.initialOffsetRatio
   * //Your changes
   * virtualjoystick.initialOffsetRatio = myCoreType
   * ``````
   *
   * The initial position of the joystick as a ratio of the control's size. `(0, 0)` is top-left and
   * `(1, 1)` is bottom-right.
   */
  @CoreTypeHelper
  public final fun initialOffsetRatioMutate(block: Vector2.() -> Unit): Vector2 =
      initialOffsetRatio.apply {
     block(this)
     initialOffsetRatio = this
  }

  public final fun setJoystickMode(mode: JoystickMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setJoystickModePtr)
  }

  public final fun getJoystickMode(): JoystickMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJoystickModePtr)
    return JoystickMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setJoystickSize(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setJoystickSizePtr)
  }

  public final fun getJoystickSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJoystickSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTipSize(size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.setTipSizePtr)
  }

  public final fun getTipSize(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTipSizePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDeadzoneRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setDeadzoneRatioPtr)
  }

  public final fun getDeadzoneRatio(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDeadzoneRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setClampzoneRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setClampzoneRatioPtr)
  }

  public final fun getClampzoneRatio(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClampzoneRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setInitialOffsetRatio(ratio: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to ratio)
    TransferContext.callMethod(MethodBindings.setInitialOffsetRatioPtr)
  }

  public final fun getInitialOffsetRatio(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInitialOffsetRatioPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setActionLeft(action: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action)
    TransferContext.callMethod(MethodBindings.setActionLeftPtr)
  }

  public final fun getActionLeft(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionLeftPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setActionRight(action: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action)
    TransferContext.callMethod(MethodBindings.setActionRightPtr)
  }

  public final fun getActionRight(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionRightPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setActionUp(action: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action)
    TransferContext.callMethod(MethodBindings.setActionUpPtr)
  }

  public final fun getActionUp(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionUpPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setActionDown(action: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action)
    TransferContext.callMethod(MethodBindings.setActionDownPtr)
  }

  public final fun getActionDown(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionDownPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setVisibilityMode(mode: VisibilityMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setVisibilityModePtr)
  }

  public final fun getVisibilityMode(): VisibilityMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityModePtr)
    return VisibilityMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setActionLeft(action: String) = setActionLeft(action.asCachedStringName())

  public final fun setActionRight(action: String) = setActionRight(action.asCachedStringName())

  public final fun setActionUp(action: String) = setActionUp(action.asCachedStringName())

  public final fun setActionDown(action: String) = setActionDown(action.asCachedStringName())

  public enum class JoystickMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The joystick doesn't move.
     */
    FIXED(0),
    /**
     * The joystick is moved to the initial touch position as long as it's within the joystick's
     * bounds. It moves back to its original position when released.
     */
    DYNAMIC(1),
    /**
     * The joystick is moved to the initial touch position as long as it's within the joystick's
     * bounds. It will follow the touch input if it goes outside the joystick's range. It moves back to
     * its original position when released.
     */
    FOLLOWING(2),
    ;

    public companion object {
      public fun from(`value`: Long): JoystickMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class VisibilityMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The joystick is always visible.
     */
    ALWAYS(0),
    /**
     * The joystick is only visible when being touched.
     */
    WHEN_TOUCHED(1),
    ;

    public companion object {
      public fun from(`value`: Long): VisibilityMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setJoystickModeName: MethodStringName1<VirtualJoystick, Unit, JoystickMode> =
        MethodStringName1<VirtualJoystick, Unit, JoystickMode>("set_joystick_mode")

    @JvmField
    public val getJoystickModeName: MethodStringName0<VirtualJoystick, JoystickMode> =
        MethodStringName0<VirtualJoystick, JoystickMode>("get_joystick_mode")

    @JvmField
    public val setJoystickSizeName: MethodStringName1<VirtualJoystick, Unit, Float> =
        MethodStringName1<VirtualJoystick, Unit, Float>("set_joystick_size")

    @JvmField
    public val getJoystickSizeName: MethodStringName0<VirtualJoystick, Float> =
        MethodStringName0<VirtualJoystick, Float>("get_joystick_size")

    @JvmField
    public val setTipSizeName: MethodStringName1<VirtualJoystick, Unit, Float> =
        MethodStringName1<VirtualJoystick, Unit, Float>("set_tip_size")

    @JvmField
    public val getTipSizeName: MethodStringName0<VirtualJoystick, Float> =
        MethodStringName0<VirtualJoystick, Float>("get_tip_size")

    @JvmField
    public val setDeadzoneRatioName: MethodStringName1<VirtualJoystick, Unit, Float> =
        MethodStringName1<VirtualJoystick, Unit, Float>("set_deadzone_ratio")

    @JvmField
    public val getDeadzoneRatioName: MethodStringName0<VirtualJoystick, Float> =
        MethodStringName0<VirtualJoystick, Float>("get_deadzone_ratio")

    @JvmField
    public val setClampzoneRatioName: MethodStringName1<VirtualJoystick, Unit, Float> =
        MethodStringName1<VirtualJoystick, Unit, Float>("set_clampzone_ratio")

    @JvmField
    public val getClampzoneRatioName: MethodStringName0<VirtualJoystick, Float> =
        MethodStringName0<VirtualJoystick, Float>("get_clampzone_ratio")

    @JvmField
    public val setInitialOffsetRatioName: MethodStringName1<VirtualJoystick, Unit, Vector2> =
        MethodStringName1<VirtualJoystick, Unit, Vector2>("set_initial_offset_ratio")

    @JvmField
    public val getInitialOffsetRatioName: MethodStringName0<VirtualJoystick, Vector2> =
        MethodStringName0<VirtualJoystick, Vector2>("get_initial_offset_ratio")

    @JvmField
    public val setActionLeftName: MethodStringName1<VirtualJoystick, Unit, StringName> =
        MethodStringName1<VirtualJoystick, Unit, StringName>("set_action_left")

    @JvmField
    public val getActionLeftName: MethodStringName0<VirtualJoystick, StringName> =
        MethodStringName0<VirtualJoystick, StringName>("get_action_left")

    @JvmField
    public val setActionRightName: MethodStringName1<VirtualJoystick, Unit, StringName> =
        MethodStringName1<VirtualJoystick, Unit, StringName>("set_action_right")

    @JvmField
    public val getActionRightName: MethodStringName0<VirtualJoystick, StringName> =
        MethodStringName0<VirtualJoystick, StringName>("get_action_right")

    @JvmField
    public val setActionUpName: MethodStringName1<VirtualJoystick, Unit, StringName> =
        MethodStringName1<VirtualJoystick, Unit, StringName>("set_action_up")

    @JvmField
    public val getActionUpName: MethodStringName0<VirtualJoystick, StringName> =
        MethodStringName0<VirtualJoystick, StringName>("get_action_up")

    @JvmField
    public val setActionDownName: MethodStringName1<VirtualJoystick, Unit, StringName> =
        MethodStringName1<VirtualJoystick, Unit, StringName>("set_action_down")

    @JvmField
    public val getActionDownName: MethodStringName0<VirtualJoystick, StringName> =
        MethodStringName0<VirtualJoystick, StringName>("get_action_down")

    @JvmField
    public val setVisibilityModeName: MethodStringName1<VirtualJoystick, Unit, VisibilityMode> =
        MethodStringName1<VirtualJoystick, Unit, VisibilityMode>("set_visibility_mode")

    @JvmField
    public val getVisibilityModeName: MethodStringName0<VirtualJoystick, VisibilityMode> =
        MethodStringName0<VirtualJoystick, VisibilityMode>("get_visibility_mode")
  }

  public object MethodBindings {
    internal val setJoystickModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_joystick_mode", 1316760817)

    internal val getJoystickModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_joystick_mode", 2694680530)

    internal val setJoystickSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_joystick_size", 373806689)

    internal val getJoystickSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_joystick_size", 1740695150)

    internal val setTipSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_tip_size", 373806689)

    internal val getTipSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_tip_size", 1740695150)

    internal val setDeadzoneRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_deadzone_ratio", 373806689)

    internal val getDeadzoneRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_deadzone_ratio", 1740695150)

    internal val setClampzoneRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_clampzone_ratio", 373806689)

    internal val getClampzoneRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_clampzone_ratio", 1740695150)

    internal val setInitialOffsetRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_initial_offset_ratio", 743155724)

    internal val getInitialOffsetRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_initial_offset_ratio", 3341600327)

    internal val setActionLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_action_left", 3304788590)

    internal val getActionLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_action_left", 2002593661)

    internal val setActionRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_action_right", 3304788590)

    internal val getActionRightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_action_right", 2002593661)

    internal val setActionUpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_action_up", 3304788590)

    internal val getActionUpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_action_up", 2002593661)

    internal val setActionDownPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_action_down", 3304788590)

    internal val getActionDownPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_action_down", 2002593661)

    internal val setVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "set_visibility_mode", 2638298545)

    internal val getVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VirtualJoystick", "get_visibility_mode", 3530872950)
  }
}
