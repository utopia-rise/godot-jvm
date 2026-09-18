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
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Controls camera-specific attributes such as depth of field and exposure override.
 *
 * When used in a [WorldEnvironment] it provides default settings for exposure, auto-exposure, and
 * depth of field that will be used by all cameras without their own [CameraAttributes], including the
 * editor camera. When used in a [Camera3D] it will override any [CameraAttributes] set in the
 * [WorldEnvironment]. When used in [VoxelGI] or [LightmapGI], only the exposure settings will be used.
 *
 * See also [Environment] for general 3D environment settings.
 *
 * This is a pure virtual class that is inherited by [CameraAttributesPhysical] and
 * [CameraAttributesPractical].
 */
@GodotBaseType
public open class CameraAttributes : Resource() {
  /**
   * Sensitivity of camera sensors, measured in ISO. A higher sensitivity results in a brighter
   * image.
   *
   * If [autoExposureEnabled] is `true`, this can be used as a method of exposure compensation,
   * doubling the value will increase the exposure value (measured in EV100) by 1 stop.
   *
   * **Note:** Only available when
   * [ProjectSettings.rendering/lightsAndShadows/usePhysicalLightUnits] is enabled.
   */
  public final inline var exposureSensitivity: Float
    @JvmName("exposureSensitivityProperty")
    get() = getExposureSensitivity()
    @JvmName("exposureSensitivityProperty")
    set(`value`) {
      setExposureSensitivity(value)
    }

  /**
   * Multiplier for the exposure amount. A higher value results in a brighter image.
   */
  public final inline var exposureMultiplier: Float
    @JvmName("exposureMultiplierProperty")
    get() = getExposureMultiplier()
    @JvmName("exposureMultiplierProperty")
    set(`value`) {
      setExposureMultiplier(value)
    }

  /**
   * If `true`, enables the tonemapping auto exposure mode of the scene renderer. If `true`, the
   * renderer will automatically determine the exposure setting to adapt to the scene's illumination
   * and the observed light.
   *
   * **Note:** Auto-exposure is only supported in the Forward+ rendering method, not Mobile or
   * Compatibility.
   */
  public final inline var autoExposureEnabled: Boolean
    @JvmName("autoExposureEnabledProperty")
    get() = isAutoExposureEnabled()
    @JvmName("autoExposureEnabledProperty")
    set(`value`) {
      setAutoExposureEnabled(value)
    }

  /**
   * The scale of the auto exposure effect. Affects the intensity of auto exposure.
   */
  public final inline var autoExposureScale: Float
    @JvmName("autoExposureScaleProperty")
    get() = getAutoExposureScale()
    @JvmName("autoExposureScaleProperty")
    set(`value`) {
      setAutoExposureScale(value)
    }

  /**
   * The speed of the auto exposure effect. Affects the time needed for the camera to perform auto
   * exposure.
   */
  public final inline var autoExposureSpeed: Float
    @JvmName("autoExposureSpeedProperty")
    get() = getAutoExposureSpeed()
    @JvmName("autoExposureSpeedProperty")
    set(`value`) {
      setAutoExposureSpeed(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(135, scriptPtr)
  }

  public final fun setExposureMultiplier(multiplier: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, multiplier.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setExposureMultiplierPtr, 0)
  }

  public final fun getExposureMultiplier(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getExposureMultiplierPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setExposureSensitivity(sensitivity: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, sensitivity.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setExposureSensitivityPtr, 0)
  }

  public final fun getExposureSensitivity(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getExposureSensitivityPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAutoExposureEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setAutoExposureEnabledPtr, 0)
  }

  public final fun isAutoExposureEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAutoExposureEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAutoExposureSpeed(exposureSpeed: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, exposureSpeed.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAutoExposureSpeedPtr, 0)
  }

  public final fun getAutoExposureSpeed(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoExposureSpeedPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAutoExposureScale(exposureGrey: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, exposureGrey.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAutoExposureScalePtr, 0)
  }

  public final fun getAutoExposureScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoExposureScalePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setExposureMultiplierName: MethodStringName1<CameraAttributes, Unit, Float> =
        MethodStringName1<CameraAttributes, Unit, Float>("set_exposure_multiplier")

    @JvmField
    public val getExposureMultiplierName: MethodStringName0<CameraAttributes, Float> =
        MethodStringName0<CameraAttributes, Float>("get_exposure_multiplier")

    @JvmField
    public val setExposureSensitivityName: MethodStringName1<CameraAttributes, Unit, Float> =
        MethodStringName1<CameraAttributes, Unit, Float>("set_exposure_sensitivity")

    @JvmField
    public val getExposureSensitivityName: MethodStringName0<CameraAttributes, Float> =
        MethodStringName0<CameraAttributes, Float>("get_exposure_sensitivity")

    @JvmField
    public val setAutoExposureEnabledName: MethodStringName1<CameraAttributes, Unit, Boolean> =
        MethodStringName1<CameraAttributes, Unit, Boolean>("set_auto_exposure_enabled")

    @JvmField
    public val isAutoExposureEnabledName: MethodStringName0<CameraAttributes, Boolean> =
        MethodStringName0<CameraAttributes, Boolean>("is_auto_exposure_enabled")

    @JvmField
    public val setAutoExposureSpeedName: MethodStringName1<CameraAttributes, Unit, Float> =
        MethodStringName1<CameraAttributes, Unit, Float>("set_auto_exposure_speed")

    @JvmField
    public val getAutoExposureSpeedName: MethodStringName0<CameraAttributes, Float> =
        MethodStringName0<CameraAttributes, Float>("get_auto_exposure_speed")

    @JvmField
    public val setAutoExposureScaleName: MethodStringName1<CameraAttributes, Unit, Float> =
        MethodStringName1<CameraAttributes, Unit, Float>("set_auto_exposure_scale")

    @JvmField
    public val getAutoExposureScaleName: MethodStringName0<CameraAttributes, Float> =
        MethodStringName0<CameraAttributes, Float>("get_auto_exposure_scale")
  }

  public object MethodBindings {
    internal val setExposureMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "set_exposure_multiplier", 373806689)

    internal val getExposureMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "get_exposure_multiplier", 1740695150)

    internal val setExposureSensitivityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "set_exposure_sensitivity", 373806689)

    internal val getExposureSensitivityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "get_exposure_sensitivity", 1740695150)

    internal val setAutoExposureEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "set_auto_exposure_enabled", 2586408642)

    internal val isAutoExposureEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "is_auto_exposure_enabled", 36873697)

    internal val setAutoExposureSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "set_auto_exposure_speed", 373806689)

    internal val getAutoExposureSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "get_auto_exposure_speed", 1740695150)

    internal val setAutoExposureScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "set_auto_exposure_scale", 373806689)

    internal val getAutoExposureScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributes", "get_auto_exposure_scale", 1740695150)
  }
}
