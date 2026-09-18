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
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [CameraAttributesPhysical] is used to set rendering settings based on a physically-based camera's
 * settings. It is responsible for exposure, auto-exposure, and depth of field.
 *
 * When used in a [WorldEnvironment] it provides default settings for exposure, auto-exposure, and
 * depth of field that will be used by all cameras without their own [CameraAttributes], including the
 * editor camera. When used in a [Camera3D] it will override any [CameraAttributes] set in the
 * [WorldEnvironment] and will override the [Camera3D]s [Camera3D.far], [Camera3D.near],
 * [Camera3D.fov], and [Camera3D.keepAspect] properties. When used in [VoxelGI] or [LightmapGI], only
 * the exposure settings will be used.
 *
 * The default settings are intended for use in an outdoor environment, tips for settings for use in
 * an indoor environment can be found in each setting's documentation.
 *
 * **Note:** Depth of field blur is only supported in the Forward+ and Mobile rendering methods, not
 * Compatibility.
 *
 * **Note:** Auto-exposure is only supported in the Forward+ rendering method, not Mobile or
 * Compatibility.
 */
@GodotBaseType
public open class CameraAttributesPhysical : CameraAttributes() {
  /**
   * Distance from camera of object that will be in focus, measured in meters. Internally this will
   * be clamped to be at least 1 millimeter larger than [frustumFocalLength].
   */
  public final inline var frustumFocusDistance: Float
    @JvmName("frustumFocusDistanceProperty")
    get() = getFocusDistance()
    @JvmName("frustumFocusDistanceProperty")
    set(`value`) {
      setFocusDistance(value)
    }

  /**
   * Distance between camera lens and camera aperture, measured in millimeters. Controls field of
   * view and depth of field. A larger focal length will result in a smaller field of view and a
   * narrower depth of field meaning fewer objects will be in focus. A smaller focal length will result
   * in a wider field of view and a larger depth of field meaning more objects will be in focus. When
   * attached to a [Camera3D] as its [Camera3D.attributes], it will override the [Camera3D.fov]
   * property and the [Camera3D.keepAspect] property.
   */
  public final inline var frustumFocalLength: Float
    @JvmName("frustumFocalLengthProperty")
    get() = getFocalLength()
    @JvmName("frustumFocalLengthProperty")
    set(`value`) {
      setFocalLength(value)
    }

  /**
   * Override value for [Camera3D.near]. Used internally when calculating depth of field. When
   * attached to a [Camera3D] as its [Camera3D.attributes], it will override the [Camera3D.near]
   * property.
   */
  public final inline var frustumNear: Float
    @JvmName("frustumNearProperty")
    get() = getNear()
    @JvmName("frustumNearProperty")
    set(`value`) {
      setNear(value)
    }

  /**
   * Override value for [Camera3D.far]. Used internally when calculating depth of field. When
   * attached to a [Camera3D] as its [Camera3D.attributes], it will override the [Camera3D.far]
   * property.
   */
  public final inline var frustumFar: Float
    @JvmName("frustumFarProperty")
    get() = getFar()
    @JvmName("frustumFarProperty")
    set(`value`) {
      setFar(value)
    }

  /**
   * Size of the aperture of the camera, measured in f-stops. An f-stop is a unitless ratio between
   * the focal length of the camera and the diameter of the aperture. A high aperture setting will
   * result in a smaller aperture which leads to a dimmer image and sharper focus. A low aperture
   * results in a wide aperture which lets in more light resulting in a brighter, less-focused image.
   * Default is appropriate for outdoors at daytime (i.e. for use with a default [DirectionalLight3D]),
   * for indoor lighting, a value between 2 and 4 is more appropriate.
   *
   * Only available when [ProjectSettings.rendering/lightsAndShadows/usePhysicalLightUnits] is
   * enabled.
   */
  public final inline var exposureAperture: Float
    @JvmName("exposureApertureProperty")
    get() = getAperture()
    @JvmName("exposureApertureProperty")
    set(`value`) {
      setAperture(value)
    }

  /**
   * Time for shutter to open and close, evaluated as `1 / shutter_speed` seconds. A higher value
   * will allow less light (leading to a darker image), while a lower value will allow more light
   * (leading to a brighter image).
   *
   * Only available when [ProjectSettings.rendering/lightsAndShadows/usePhysicalLightUnits] is
   * enabled.
   */
  public final inline var exposureShutterSpeed: Float
    @JvmName("exposureShutterSpeedProperty")
    get() = getShutterSpeed()
    @JvmName("exposureShutterSpeedProperty")
    set(`value`) {
      setShutterSpeed(value)
    }

  /**
   * The minimum luminance (in EV100) used when calculating auto exposure. When calculating scene
   * average luminance, color values will be clamped to at least this value. This limits the
   * auto-exposure from exposing above a certain brightness, resulting in a cut off point where the
   * scene will remain dark.
   */
  public final inline var autoExposureMinExposureValue: Float
    @JvmName("autoExposureMinExposureValueProperty")
    get() = getAutoExposureMinExposureValue()
    @JvmName("autoExposureMinExposureValueProperty")
    set(`value`) {
      setAutoExposureMinExposureValue(value)
    }

  /**
   * The maximum luminance (in EV100) used when calculating auto exposure. When calculating scene
   * average luminance, color values will be clamped to at least this value. This limits the
   * auto-exposure from exposing below a certain brightness, resulting in a cut off point where the
   * scene will remain bright.
   */
  public final inline var autoExposureMaxExposureValue: Float
    @JvmName("autoExposureMaxExposureValueProperty")
    get() = getAutoExposureMaxExposureValue()
    @JvmName("autoExposureMaxExposureValueProperty")
    set(`value`) {
      setAutoExposureMaxExposureValue(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(136, scriptPtr)
  }

  public final fun setAperture(aperture: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, aperture.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAperturePtr, 0)
  }

  public final fun getAperture(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAperturePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setShutterSpeed(shutterSpeed: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, shutterSpeed.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setShutterSpeedPtr, 0)
  }

  public final fun getShutterSpeed(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getShutterSpeedPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFocalLength(focalLength: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, focalLength.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setFocalLengthPtr, 0)
  }

  public final fun getFocalLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFocalLengthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFocusDistance(focusDistance: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, focusDistance.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setFocusDistancePtr, 0)
  }

  public final fun getFocusDistance(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFocusDistancePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setNear(near: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, near.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setNearPtr, 0)
  }

  public final fun getNear(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNearPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFar(far: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, far.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setFarPtr, 0)
  }

  public final fun getFar(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFarPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the vertical field of view that corresponds to the [frustumFocalLength]. This value is
   * calculated internally whenever [frustumFocalLength] is changed.
   */
  public final fun getFov(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFovPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAutoExposureMaxExposureValue(exposureValueMax: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, exposureValueMax.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAutoExposureMaxExposureValuePtr, 0)
  }

  public final fun getAutoExposureMaxExposureValue(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoExposureMaxExposureValuePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAutoExposureMinExposureValue(exposureValueMin: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, exposureValueMin.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAutoExposureMinExposureValuePtr, 0)
  }

  public final fun getAutoExposureMinExposureValue(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAutoExposureMinExposureValuePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setApertureName: MethodStringName1<CameraAttributesPhysical, Unit, Float> =
        MethodStringName1<CameraAttributesPhysical, Unit, Float>("set_aperture")

    @JvmField
    public val getApertureName: MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_aperture")

    @JvmField
    public val setShutterSpeedName: MethodStringName1<CameraAttributesPhysical, Unit, Float> =
        MethodStringName1<CameraAttributesPhysical, Unit, Float>("set_shutter_speed")

    @JvmField
    public val getShutterSpeedName: MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_shutter_speed")

    @JvmField
    public val setFocalLengthName: MethodStringName1<CameraAttributesPhysical, Unit, Float> =
        MethodStringName1<CameraAttributesPhysical, Unit, Float>("set_focal_length")

    @JvmField
    public val getFocalLengthName: MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_focal_length")

    @JvmField
    public val setFocusDistanceName: MethodStringName1<CameraAttributesPhysical, Unit, Float> =
        MethodStringName1<CameraAttributesPhysical, Unit, Float>("set_focus_distance")

    @JvmField
    public val getFocusDistanceName: MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_focus_distance")

    @JvmField
    public val setNearName: MethodStringName1<CameraAttributesPhysical, Unit, Float> =
        MethodStringName1<CameraAttributesPhysical, Unit, Float>("set_near")

    @JvmField
    public val getNearName: MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_near")

    @JvmField
    public val setFarName: MethodStringName1<CameraAttributesPhysical, Unit, Float> =
        MethodStringName1<CameraAttributesPhysical, Unit, Float>("set_far")

    @JvmField
    public val getFarName: MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_far")

    @JvmField
    public val getFovName: MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_fov")

    @JvmField
    public val setAutoExposureMaxExposureValueName:
        MethodStringName1<CameraAttributesPhysical, Unit, Float> =
        MethodStringName1<CameraAttributesPhysical, Unit, Float>("set_auto_exposure_max_exposure_value")

    @JvmField
    public val getAutoExposureMaxExposureValueName:
        MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_auto_exposure_max_exposure_value")

    @JvmField
    public val setAutoExposureMinExposureValueName:
        MethodStringName1<CameraAttributesPhysical, Unit, Float> =
        MethodStringName1<CameraAttributesPhysical, Unit, Float>("set_auto_exposure_min_exposure_value")

    @JvmField
    public val getAutoExposureMinExposureValueName:
        MethodStringName0<CameraAttributesPhysical, Float> =
        MethodStringName0<CameraAttributesPhysical, Float>("get_auto_exposure_min_exposure_value")
  }

  public object MethodBindings {
    internal val setAperturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "set_aperture", 373806689)

    internal val getAperturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_aperture", 1740695150)

    internal val setShutterSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "set_shutter_speed", 373806689)

    internal val getShutterSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_shutter_speed", 1740695150)

    internal val setFocalLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "set_focal_length", 373806689)

    internal val getFocalLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_focal_length", 1740695150)

    internal val setFocusDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "set_focus_distance", 373806689)

    internal val getFocusDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_focus_distance", 1740695150)

    internal val setNearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "set_near", 373806689)

    internal val getNearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_near", 1740695150)

    internal val setFarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "set_far", 373806689)

    internal val getFarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_far", 1740695150)

    internal val getFovPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_fov", 1740695150)

    internal val setAutoExposureMaxExposureValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "set_auto_exposure_max_exposure_value", 373806689)

    internal val getAutoExposureMaxExposureValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_auto_exposure_max_exposure_value", 1740695150)

    internal val setAutoExposureMinExposureValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "set_auto_exposure_min_exposure_value", 373806689)

    internal val getAutoExposureMinExposureValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPhysical", "get_auto_exposure_min_exposure_value", 1740695150)
  }
}
