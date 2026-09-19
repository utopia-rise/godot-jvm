// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Controls camera-specific attributes such as auto-exposure, depth of field, and exposure override.
 *
 * When used in a [WorldEnvironment] it provides default settings for exposure, auto-exposure, and
 * depth of field that will be used by all cameras without their own [CameraAttributes], including the
 * editor camera. When used in a [Camera3D] it will override any [CameraAttributes] set in the
 * [WorldEnvironment]. When used in [VoxelGI] or [LightmapGI], only the exposure settings will be used.
 *
 * **Note:** Depth of field blur is only supported in the Forward+ and Mobile rendering methods, not
 * Compatibility.
 *
 * **Note:** Auto-exposure is only supported in the Forward+ rendering method, not Mobile or
 * Compatibility.
 */
@GodotBaseType
public open class CameraAttributesPractical : CameraAttributes() {
  /**
   * Enables depth of field blur for objects further than [dofBlurFarDistance]. Strength of blur is
   * controlled by [dofBlurAmount] and modulated by [dofBlurFarTransition].
   *
   * **Note:** Depth of field blur is only supported in the Forward+ and Mobile rendering methods,
   * not Compatibility.
   *
   * **Note:** Depth of field blur is not supported on viewports that have a transparent background
   * (where [Viewport.transparentBg] is `true`).
   */
  public final inline var dofBlurFarEnabled: Boolean
    @JvmName("dofBlurFarEnabledProperty")
    get() = isDofBlurFarEnabled()
    @JvmName("dofBlurFarEnabledProperty")
    set(`value`) {
      setDofBlurFarEnabled(value)
    }

  /**
   * Objects further from the [Camera3D] by this amount will be blurred by the depth of field
   * effect. Measured in meters.
   */
  public final inline var dofBlurFarDistance: Float
    @JvmName("dofBlurFarDistanceProperty")
    get() = getDofBlurFarDistance()
    @JvmName("dofBlurFarDistanceProperty")
    set(`value`) {
      setDofBlurFarDistance(value)
    }

  /**
   * When positive, distance over which (starting from [dofBlurFarDistance]) blur effect will scale
   * from 0 to [dofBlurAmount]. When negative, uses physically-based scaling so depth of field effect
   * will scale from 0 at [dofBlurFarDistance] and will increase in a physically accurate way as
   * objects get further from the [Camera3D].
   */
  public final inline var dofBlurFarTransition: Float
    @JvmName("dofBlurFarTransitionProperty")
    get() = getDofBlurFarTransition()
    @JvmName("dofBlurFarTransitionProperty")
    set(`value`) {
      setDofBlurFarTransition(value)
    }

  /**
   * Enables depth of field blur for objects closer than [dofBlurNearDistance]. Strength of blur is
   * controlled by [dofBlurAmount] and modulated by [dofBlurNearTransition].
   *
   * **Note:** Depth of field blur is only supported in the Forward+ and Mobile rendering methods,
   * not Compatibility.
   *
   * **Note:** Depth of field blur is not supported on viewports that have a transparent background
   * (where [Viewport.transparentBg] is `true`).
   */
  public final inline var dofBlurNearEnabled: Boolean
    @JvmName("dofBlurNearEnabledProperty")
    get() = isDofBlurNearEnabled()
    @JvmName("dofBlurNearEnabledProperty")
    set(`value`) {
      setDofBlurNearEnabled(value)
    }

  /**
   * Objects closer from the [Camera3D] by this amount will be blurred by the depth of field effect.
   * Measured in meters.
   */
  public final inline var dofBlurNearDistance: Float
    @JvmName("dofBlurNearDistanceProperty")
    get() = getDofBlurNearDistance()
    @JvmName("dofBlurNearDistanceProperty")
    set(`value`) {
      setDofBlurNearDistance(value)
    }

  /**
   * When positive, distance over which blur effect will scale from 0 to [dofBlurAmount], ending at
   * [dofBlurNearDistance]. When negative, uses physically-based scaling so depth of field effect will
   * scale from 0 at [dofBlurNearDistance] and will increase in a physically accurate way as objects
   * get closer to the [Camera3D].
   */
  public final inline var dofBlurNearTransition: Float
    @JvmName("dofBlurNearTransitionProperty")
    get() = getDofBlurNearTransition()
    @JvmName("dofBlurNearTransitionProperty")
    set(`value`) {
      setDofBlurNearTransition(value)
    }

  /**
   * Sets the maximum amount of blur. When using physically-based blur amounts, will instead act as
   * a multiplier. High values lead to an increased amount of blurriness, but can be much more
   * expensive to calculate. It is best to keep this as low as possible for a given art style.
   */
  public final inline var dofBlurAmount: Float
    @JvmName("dofBlurAmountProperty")
    get() = getDofBlurAmount()
    @JvmName("dofBlurAmountProperty")
    set(`value`) {
      setDofBlurAmount(value)
    }

  /**
   * The minimum sensitivity (in ISO) used when calculating auto exposure. When calculating scene
   * average luminance, color values will be clamped to at least this value. This limits the
   * auto-exposure from exposing above a certain brightness, resulting in a cut off point where the
   * scene will remain dark.
   */
  public final inline var autoExposureMinSensitivity: Float
    @JvmName("autoExposureMinSensitivityProperty")
    get() = getAutoExposureMinSensitivity()
    @JvmName("autoExposureMinSensitivityProperty")
    set(`value`) {
      setAutoExposureMinSensitivity(value)
    }

  /**
   * The maximum sensitivity (in ISO) used when calculating auto exposure. When calculating scene
   * average luminance, color values will be clamped to at least this value. This limits the
   * auto-exposure from exposing below a certain brightness, resulting in a cut off point where the
   * scene will remain bright.
   */
  public final inline var autoExposureMaxSensitivity: Float
    @JvmName("autoExposureMaxSensitivityProperty")
    get() = getAutoExposureMaxSensitivity()
    @JvmName("autoExposureMaxSensitivityProperty")
    set(`value`) {
      setAutoExposureMaxSensitivity(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(137, scriptPtr)
  }

  public final fun setDofBlurFarEnabled(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setDofBlurFarEnabledPtr, enabled)
  }

  public final fun isDofBlurFarEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isDofBlurFarEnabledPtr)

  public final fun setDofBlurFarDistance(distance: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDofBlurFarDistancePtr, distance.toDouble())
  }

  public final fun getDofBlurFarDistance(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDofBlurFarDistancePtr).toFloat()

  public final fun setDofBlurFarTransition(distance: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDofBlurFarTransitionPtr, distance.toDouble())
  }

  public final fun getDofBlurFarTransition(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDofBlurFarTransitionPtr).toFloat()

  public final fun setDofBlurNearEnabled(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setDofBlurNearEnabledPtr, enabled)
  }

  public final fun isDofBlurNearEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isDofBlurNearEnabledPtr)

  public final fun setDofBlurNearDistance(distance: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDofBlurNearDistancePtr, distance.toDouble())
  }

  public final fun getDofBlurNearDistance(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDofBlurNearDistancePtr).toFloat()

  public final fun setDofBlurNearTransition(distance: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDofBlurNearTransitionPtr, distance.toDouble())
  }

  public final fun getDofBlurNearTransition(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDofBlurNearTransitionPtr).toFloat()

  public final fun setDofBlurAmount(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDofBlurAmountPtr, amount.toDouble())
  }

  public final fun getDofBlurAmount(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDofBlurAmountPtr).toFloat()

  public final fun setAutoExposureMaxSensitivity(maxSensitivity: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAutoExposureMaxSensitivityPtr, maxSensitivity.toDouble())
  }

  public final fun getAutoExposureMaxSensitivity(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAutoExposureMaxSensitivityPtr).toFloat()

  public final fun setAutoExposureMinSensitivity(minSensitivity: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAutoExposureMinSensitivityPtr, minSensitivity.toDouble())
  }

  public final fun getAutoExposureMinSensitivity(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAutoExposureMinSensitivityPtr).toFloat()

  public companion object {
    @JvmField
    public val setDofBlurFarEnabledName: MethodStringName1<CameraAttributesPractical, Unit, Boolean>
        = MethodStringName1<CameraAttributesPractical, Unit, Boolean>("set_dof_blur_far_enabled")

    @JvmField
    public val isDofBlurFarEnabledName: MethodStringName0<CameraAttributesPractical, Boolean> =
        MethodStringName0<CameraAttributesPractical, Boolean>("is_dof_blur_far_enabled")

    @JvmField
    public val setDofBlurFarDistanceName: MethodStringName1<CameraAttributesPractical, Unit, Float>
        = MethodStringName1<CameraAttributesPractical, Unit, Float>("set_dof_blur_far_distance")

    @JvmField
    public val getDofBlurFarDistanceName: MethodStringName0<CameraAttributesPractical, Float> =
        MethodStringName0<CameraAttributesPractical, Float>("get_dof_blur_far_distance")

    @JvmField
    public val setDofBlurFarTransitionName:
        MethodStringName1<CameraAttributesPractical, Unit, Float> =
        MethodStringName1<CameraAttributesPractical, Unit, Float>("set_dof_blur_far_transition")

    @JvmField
    public val getDofBlurFarTransitionName: MethodStringName0<CameraAttributesPractical, Float> =
        MethodStringName0<CameraAttributesPractical, Float>("get_dof_blur_far_transition")

    @JvmField
    public val setDofBlurNearEnabledName:
        MethodStringName1<CameraAttributesPractical, Unit, Boolean> =
        MethodStringName1<CameraAttributesPractical, Unit, Boolean>("set_dof_blur_near_enabled")

    @JvmField
    public val isDofBlurNearEnabledName: MethodStringName0<CameraAttributesPractical, Boolean> =
        MethodStringName0<CameraAttributesPractical, Boolean>("is_dof_blur_near_enabled")

    @JvmField
    public val setDofBlurNearDistanceName: MethodStringName1<CameraAttributesPractical, Unit, Float>
        = MethodStringName1<CameraAttributesPractical, Unit, Float>("set_dof_blur_near_distance")

    @JvmField
    public val getDofBlurNearDistanceName: MethodStringName0<CameraAttributesPractical, Float> =
        MethodStringName0<CameraAttributesPractical, Float>("get_dof_blur_near_distance")

    @JvmField
    public val setDofBlurNearTransitionName:
        MethodStringName1<CameraAttributesPractical, Unit, Float> =
        MethodStringName1<CameraAttributesPractical, Unit, Float>("set_dof_blur_near_transition")

    @JvmField
    public val getDofBlurNearTransitionName: MethodStringName0<CameraAttributesPractical, Float> =
        MethodStringName0<CameraAttributesPractical, Float>("get_dof_blur_near_transition")

    @JvmField
    public val setDofBlurAmountName: MethodStringName1<CameraAttributesPractical, Unit, Float> =
        MethodStringName1<CameraAttributesPractical, Unit, Float>("set_dof_blur_amount")

    @JvmField
    public val getDofBlurAmountName: MethodStringName0<CameraAttributesPractical, Float> =
        MethodStringName0<CameraAttributesPractical, Float>("get_dof_blur_amount")

    @JvmField
    public val setAutoExposureMaxSensitivityName:
        MethodStringName1<CameraAttributesPractical, Unit, Float> =
        MethodStringName1<CameraAttributesPractical, Unit, Float>("set_auto_exposure_max_sensitivity")

    @JvmField
    public val getAutoExposureMaxSensitivityName:
        MethodStringName0<CameraAttributesPractical, Float> =
        MethodStringName0<CameraAttributesPractical, Float>("get_auto_exposure_max_sensitivity")

    @JvmField
    public val setAutoExposureMinSensitivityName:
        MethodStringName1<CameraAttributesPractical, Unit, Float> =
        MethodStringName1<CameraAttributesPractical, Unit, Float>("set_auto_exposure_min_sensitivity")

    @JvmField
    public val getAutoExposureMinSensitivityName:
        MethodStringName0<CameraAttributesPractical, Float> =
        MethodStringName0<CameraAttributesPractical, Float>("get_auto_exposure_min_sensitivity")
  }

  public object MethodBindings {
    internal val setDofBlurFarEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_dof_blur_far_enabled", 2586408642)

    internal val isDofBlurFarEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "is_dof_blur_far_enabled", 36873697)

    internal val setDofBlurFarDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_dof_blur_far_distance", 373806689)

    internal val getDofBlurFarDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "get_dof_blur_far_distance", 1740695150)

    internal val setDofBlurFarTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_dof_blur_far_transition", 373806689)

    internal val getDofBlurFarTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "get_dof_blur_far_transition", 1740695150)

    internal val setDofBlurNearEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_dof_blur_near_enabled", 2586408642)

    internal val isDofBlurNearEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "is_dof_blur_near_enabled", 36873697)

    internal val setDofBlurNearDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_dof_blur_near_distance", 373806689)

    internal val getDofBlurNearDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "get_dof_blur_near_distance", 1740695150)

    internal val setDofBlurNearTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_dof_blur_near_transition", 373806689)

    internal val getDofBlurNearTransitionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "get_dof_blur_near_transition", 1740695150)

    internal val setDofBlurAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_dof_blur_amount", 373806689)

    internal val getDofBlurAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "get_dof_blur_amount", 1740695150)

    internal val setAutoExposureMaxSensitivityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_auto_exposure_max_sensitivity", 373806689)

    internal val getAutoExposureMaxSensitivityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "get_auto_exposure_max_sensitivity", 1740695150)

    internal val setAutoExposureMinSensitivityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "set_auto_exposure_min_sensitivity", 373806689)

    internal val getAutoExposureMinSensitivityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CameraAttributesPractical", "get_auto_exposure_min_sensitivity", 1740695150)
  }
}
