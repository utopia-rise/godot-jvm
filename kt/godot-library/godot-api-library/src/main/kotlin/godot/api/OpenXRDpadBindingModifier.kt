// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * The DPad binding modifier converts an axis input to a dpad output, emulating a DPad. New input
 * paths for each dpad direction will be added to the interaction profile. When bound to actions the
 * DPad emulation will be activated. You should **not** combine dpad inputs with normal inputs in the
 * same action set for the same control, this will result in an error being returned when suggested
 * bindings are submitted to OpenXR.
 *
 * See
 * [url=https://registry.khronos.org/OpenXR/specs/1.1/html/xrspec.html#XR_EXT_dpad_binding]XR_EXT_dpad_binding[/url]
 * for in-depth details.
 *
 * **Note:** If the DPad binding modifier extension is enabled, all dpad binding paths will be
 * available in the action map. Adding the modifier to an interaction profile allows you to further
 * customize the behavior.
 */
@GodotBaseType
public open class OpenXRDpadBindingModifier : OpenXRIPBindingModifier() {
  /**
   * Action set for which this dpad binding modifier is active.
   */
  public final inline var actionSet: OpenXRActionSet?
    @JvmName("actionSetProperty")
    get() = getActionSet()
    @JvmName("actionSetProperty")
    set(`value`) {
      setActionSet(value)
    }

  /**
   * Input path for this dpad binding modifier.
   */
  public final inline var inputPath: String
    @JvmName("inputPathProperty")
    get() = getInputPath()
    @JvmName("inputPathProperty")
    set(`value`) {
      setInputPath(value)
    }

  /**
   * When our input value is equal or larger than this value, our dpad in that direction becomes
   * `true`. It stays `true` until it falls under the [thresholdReleased] value.
   */
  public final inline var threshold: Float
    @JvmName("thresholdProperty")
    get() = getThreshold()
    @JvmName("thresholdProperty")
    set(`value`) {
      setThreshold(value)
    }

  /**
   * When our input value falls below this, our output becomes `false`.
   */
  public final inline var thresholdReleased: Float
    @JvmName("thresholdReleasedProperty")
    get() = getThresholdReleased()
    @JvmName("thresholdReleasedProperty")
    set(`value`) {
      setThresholdReleased(value)
    }

  /**
   * Center region in which our center position of our dpad return `true`.
   */
  public final inline var centerRegion: Float
    @JvmName("centerRegionProperty")
    get() = getCenterRegion()
    @JvmName("centerRegionProperty")
    set(`value`) {
      setCenterRegion(value)
    }

  /**
   * The angle of each wedge that identifies the 4 directions of the emulated dpad.
   */
  public final inline var wedgeAngle: Float
    @JvmName("wedgeAngleProperty")
    get() = getWedgeAngle()
    @JvmName("wedgeAngleProperty")
    set(`value`) {
      setWedgeAngle(value)
    }

  /**
   * If `false`, when the joystick enters a new dpad zone this becomes `true`.
   *
   * If `true`, when the joystick remains in active dpad zone, this remains `true` even if we
   * overlap with another zone.
   */
  public final inline var isSticky: Boolean
    @JvmName("isStickyProperty")
    get() = getIsSticky()
    @JvmName("isStickyProperty")
    set(`value`) {
      setIsSticky(value)
    }

  /**
   * Haptic pulse to emit when the user presses the input.
   */
  public final inline var onHaptic: OpenXRHapticBase?
    @JvmName("onHapticProperty")
    get() = getOnHaptic()
    @JvmName("onHapticProperty")
    set(`value`) {
      setOnHaptic(value)
    }

  /**
   * Haptic pulse to emit when the user releases the input.
   */
  public final inline var offHaptic: OpenXRHapticBase?
    @JvmName("offHapticProperty")
    get() = getOffHaptic()
    @JvmName("offHapticProperty")
    set(`value`) {
      setOffHaptic(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(449, scriptPtr)
  }

  public final fun setActionSet(actionSet: OpenXRActionSet?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to actionSet)
    TransferContext.callMethod(MethodBindings.setActionSetPtr)
  }

  public final fun getActionSet(): OpenXRActionSet? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionSetPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRActionSet?)
  }

  public final fun setInputPath(inputPath: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to inputPath)
    TransferContext.callMethod(MethodBindings.setInputPathPtr)
  }

  public final fun getInputPath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInputPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setThreshold(threshold: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to threshold.toDouble())
    TransferContext.callMethod(MethodBindings.setThresholdPtr)
  }

  public final fun getThreshold(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThresholdPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setThresholdReleased(thresholdReleased: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to thresholdReleased.toDouble())
    TransferContext.callMethod(MethodBindings.setThresholdReleasedPtr)
  }

  public final fun getThresholdReleased(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getThresholdReleasedPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCenterRegion(centerRegion: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to centerRegion.toDouble())
    TransferContext.callMethod(MethodBindings.setCenterRegionPtr)
  }

  public final fun getCenterRegion(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCenterRegionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setWedgeAngle(wedgeAngle: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to wedgeAngle.toDouble())
    TransferContext.callMethod(MethodBindings.setWedgeAnglePtr)
  }

  public final fun getWedgeAngle(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWedgeAnglePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setIsSticky(isSticky: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to isSticky)
    TransferContext.callMethod(MethodBindings.setIsStickyPtr)
  }

  public final fun getIsSticky(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIsStickyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setOnHaptic(haptic: OpenXRHapticBase?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to haptic)
    TransferContext.callMethod(MethodBindings.setOnHapticPtr)
  }

  public final fun getOnHaptic(): OpenXRHapticBase? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOnHapticPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRHapticBase?)
  }

  public final fun setOffHaptic(haptic: OpenXRHapticBase?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to haptic)
    TransferContext.callMethod(MethodBindings.setOffHapticPtr)
  }

  public final fun getOffHaptic(): OpenXRHapticBase? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffHapticPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRHapticBase?)
  }

  public companion object {
    @JvmField
    public val setActionSetName:
        MethodStringName1<OpenXRDpadBindingModifier, Unit, OpenXRActionSet?> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, OpenXRActionSet?>("set_action_set")

    @JvmField
    public val getActionSetName: MethodStringName0<OpenXRDpadBindingModifier, OpenXRActionSet?> =
        MethodStringName0<OpenXRDpadBindingModifier, OpenXRActionSet?>("get_action_set")

    @JvmField
    public val setInputPathName: MethodStringName1<OpenXRDpadBindingModifier, Unit, String> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, String>("set_input_path")

    @JvmField
    public val getInputPathName: MethodStringName0<OpenXRDpadBindingModifier, String> =
        MethodStringName0<OpenXRDpadBindingModifier, String>("get_input_path")

    @JvmField
    public val setThresholdName: MethodStringName1<OpenXRDpadBindingModifier, Unit, Float> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, Float>("set_threshold")

    @JvmField
    public val getThresholdName: MethodStringName0<OpenXRDpadBindingModifier, Float> =
        MethodStringName0<OpenXRDpadBindingModifier, Float>("get_threshold")

    @JvmField
    public val setThresholdReleasedName: MethodStringName1<OpenXRDpadBindingModifier, Unit, Float> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, Float>("set_threshold_released")

    @JvmField
    public val getThresholdReleasedName: MethodStringName0<OpenXRDpadBindingModifier, Float> =
        MethodStringName0<OpenXRDpadBindingModifier, Float>("get_threshold_released")

    @JvmField
    public val setCenterRegionName: MethodStringName1<OpenXRDpadBindingModifier, Unit, Float> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, Float>("set_center_region")

    @JvmField
    public val getCenterRegionName: MethodStringName0<OpenXRDpadBindingModifier, Float> =
        MethodStringName0<OpenXRDpadBindingModifier, Float>("get_center_region")

    @JvmField
    public val setWedgeAngleName: MethodStringName1<OpenXRDpadBindingModifier, Unit, Float> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, Float>("set_wedge_angle")

    @JvmField
    public val getWedgeAngleName: MethodStringName0<OpenXRDpadBindingModifier, Float> =
        MethodStringName0<OpenXRDpadBindingModifier, Float>("get_wedge_angle")

    @JvmField
    public val setIsStickyName: MethodStringName1<OpenXRDpadBindingModifier, Unit, Boolean> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, Boolean>("set_is_sticky")

    @JvmField
    public val getIsStickyName: MethodStringName0<OpenXRDpadBindingModifier, Boolean> =
        MethodStringName0<OpenXRDpadBindingModifier, Boolean>("get_is_sticky")

    @JvmField
    public val setOnHapticName:
        MethodStringName1<OpenXRDpadBindingModifier, Unit, OpenXRHapticBase?> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, OpenXRHapticBase?>("set_on_haptic")

    @JvmField
    public val getOnHapticName: MethodStringName0<OpenXRDpadBindingModifier, OpenXRHapticBase?> =
        MethodStringName0<OpenXRDpadBindingModifier, OpenXRHapticBase?>("get_on_haptic")

    @JvmField
    public val setOffHapticName:
        MethodStringName1<OpenXRDpadBindingModifier, Unit, OpenXRHapticBase?> =
        MethodStringName1<OpenXRDpadBindingModifier, Unit, OpenXRHapticBase?>("set_off_haptic")

    @JvmField
    public val getOffHapticName: MethodStringName0<OpenXRDpadBindingModifier, OpenXRHapticBase?> =
        MethodStringName0<OpenXRDpadBindingModifier, OpenXRHapticBase?>("get_off_haptic")
  }

  public object MethodBindings {
    internal val setActionSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_action_set", 2093310581)

    internal val getActionSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_action_set", 619941079)

    internal val setInputPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_input_path", 83702148)

    internal val getInputPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_input_path", 201670096)

    internal val setThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_threshold", 373806689)

    internal val getThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_threshold", 1740695150)

    internal val setThresholdReleasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_threshold_released", 373806689)

    internal val getThresholdReleasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_threshold_released", 1740695150)

    internal val setCenterRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_center_region", 373806689)

    internal val getCenterRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_center_region", 1740695150)

    internal val setWedgeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_wedge_angle", 373806689)

    internal val getWedgeAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_wedge_angle", 1740695150)

    internal val setIsStickyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_is_sticky", 2586408642)

    internal val getIsStickyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_is_sticky", 36873697)

    internal val setOnHapticPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_on_haptic", 2998020150)

    internal val getOnHapticPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_on_haptic", 922310751)

    internal val setOffHapticPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "set_off_haptic", 2998020150)

    internal val getOffHapticPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRDpadBindingModifier", "get_off_haptic", 922310751)
  }
}
