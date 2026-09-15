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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An OpenXR composition layer that allows rendering a [SubViewport] on an internal slice of a
 * sphere.
 */
@GodotBaseType
public open class OpenXRCompositionLayerEquirect : OpenXRCompositionLayer() {
  /**
   * The radius of the sphere.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * The central horizontal angle of the sphere. Used to set the width.
   */
  public final inline var centralHorizontalAngle: Float
    @JvmName("centralHorizontalAngleProperty")
    get() = getCentralHorizontalAngle()
    @JvmName("centralHorizontalAngleProperty")
    set(`value`) {
      setCentralHorizontalAngle(value)
    }

  /**
   * The upper vertical angle of the sphere. Used (together with [lowerVerticalAngle]) to set the
   * height.
   */
  public final inline var upperVerticalAngle: Float
    @JvmName("upperVerticalAngleProperty")
    get() = getUpperVerticalAngle()
    @JvmName("upperVerticalAngleProperty")
    set(`value`) {
      setUpperVerticalAngle(value)
    }

  /**
   * The lower vertical angle of the sphere. Used (together with [upperVerticalAngle]) to set the
   * height.
   */
  public final inline var lowerVerticalAngle: Float
    @JvmName("lowerVerticalAngleProperty")
    get() = getLowerVerticalAngle()
    @JvmName("lowerVerticalAngleProperty")
    set(`value`) {
      setLowerVerticalAngle(value)
    }

  /**
   * The number of segments to use in the fallback mesh.
   */
  public final inline var fallbackSegments: Long
    @JvmName("fallbackSegmentsProperty")
    get() = getFallbackSegments()
    @JvmName("fallbackSegmentsProperty")
    set(`value`) {
      setFallbackSegments(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(447, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, radius.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRadiusPtr, 0)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRadiusPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setCentralHorizontalAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCentralHorizontalAnglePtr, 0)
  }

  public final fun getCentralHorizontalAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCentralHorizontalAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setUpperVerticalAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setUpperVerticalAnglePtr, 0)
  }

  public final fun getUpperVerticalAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUpperVerticalAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setLowerVerticalAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setLowerVerticalAnglePtr, 0)
  }

  public final fun getLowerVerticalAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLowerVerticalAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFallbackSegments(segments: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, segments)
    TransferContext.callPtrMethod(MethodBindings.setFallbackSegmentsPtr, 0)
  }

  public final fun getFallbackSegments(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFallbackSegmentsPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Float> =
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<OpenXRCompositionLayerEquirect, Float> =
        MethodStringName0<OpenXRCompositionLayerEquirect, Float>("get_radius")

    @JvmField
    public val setCentralHorizontalAngleName:
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Float> =
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Float>("set_central_horizontal_angle")

    @JvmField
    public val getCentralHorizontalAngleName:
        MethodStringName0<OpenXRCompositionLayerEquirect, Float> =
        MethodStringName0<OpenXRCompositionLayerEquirect, Float>("get_central_horizontal_angle")

    @JvmField
    public val setUpperVerticalAngleName:
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Float> =
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Float>("set_upper_vertical_angle")

    @JvmField
    public val getUpperVerticalAngleName: MethodStringName0<OpenXRCompositionLayerEquirect, Float> =
        MethodStringName0<OpenXRCompositionLayerEquirect, Float>("get_upper_vertical_angle")

    @JvmField
    public val setLowerVerticalAngleName:
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Float> =
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Float>("set_lower_vertical_angle")

    @JvmField
    public val getLowerVerticalAngleName: MethodStringName0<OpenXRCompositionLayerEquirect, Float> =
        MethodStringName0<OpenXRCompositionLayerEquirect, Float>("get_lower_vertical_angle")

    @JvmField
    public val setFallbackSegmentsName:
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Long> =
        MethodStringName1<OpenXRCompositionLayerEquirect, Unit, Long>("set_fallback_segments")

    @JvmField
    public val getFallbackSegmentsName: MethodStringName0<OpenXRCompositionLayerEquirect, Long> =
        MethodStringName0<OpenXRCompositionLayerEquirect, Long>("get_fallback_segments")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "get_radius", 1740695150)

    internal val setCentralHorizontalAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "set_central_horizontal_angle", 373806689)

    internal val getCentralHorizontalAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "get_central_horizontal_angle", 1740695150)

    internal val setUpperVerticalAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "set_upper_vertical_angle", 373806689)

    internal val getUpperVerticalAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "get_upper_vertical_angle", 1740695150)

    internal val setLowerVerticalAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "set_lower_vertical_angle", 373806689)

    internal val getLowerVerticalAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "get_lower_vertical_angle", 1740695150)

    internal val setFallbackSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "set_fallback_segments", 1286410249)

    internal val getFallbackSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerEquirect", "get_fallback_segments", 3905245786)
  }
}
