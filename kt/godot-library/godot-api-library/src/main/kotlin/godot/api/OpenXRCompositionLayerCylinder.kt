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
 * cylinder.
 */
@GodotBaseType
public open class OpenXRCompositionLayerCylinder : OpenXRCompositionLayer() {
  /**
   * The radius of the cylinder.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * The aspect ratio of the slice. Used to set the height relative to the width.
   */
  public final inline var aspectRatio: Float
    @JvmName("aspectRatioProperty")
    get() = getAspectRatio()
    @JvmName("aspectRatioProperty")
    set(`value`) {
      setAspectRatio(value)
    }

  /**
   * The central angle of the cylinder. Used to set the width.
   */
  public final inline var centralAngle: Float
    @JvmName("centralAngleProperty")
    get() = getCentralAngle()
    @JvmName("centralAngleProperty")
    set(`value`) {
      setCentralAngle(value)
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
    createNativeObject(446, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, radius.toDouble())
    TransferContext.callMethod(MethodBindings.setRadiusPtr)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRadiusPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAspectRatio(aspectRatio: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, aspectRatio.toDouble())
    TransferContext.callMethod(MethodBindings.setAspectRatioPtr)
  }

  public final fun getAspectRatio(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAspectRatioPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setCentralAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callMethod(MethodBindings.setCentralAnglePtr)
  }

  public final fun getCentralAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCentralAnglePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFallbackSegments(segments: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, segments)
    TransferContext.callMethod(MethodBindings.setFallbackSegmentsPtr)
  }

  public final fun getFallbackSegments(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFallbackSegmentsPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<OpenXRCompositionLayerCylinder, Unit, Float> =
        MethodStringName1<OpenXRCompositionLayerCylinder, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<OpenXRCompositionLayerCylinder, Float> =
        MethodStringName0<OpenXRCompositionLayerCylinder, Float>("get_radius")

    @JvmField
    public val setAspectRatioName: MethodStringName1<OpenXRCompositionLayerCylinder, Unit, Float> =
        MethodStringName1<OpenXRCompositionLayerCylinder, Unit, Float>("set_aspect_ratio")

    @JvmField
    public val getAspectRatioName: MethodStringName0<OpenXRCompositionLayerCylinder, Float> =
        MethodStringName0<OpenXRCompositionLayerCylinder, Float>("get_aspect_ratio")

    @JvmField
    public val setCentralAngleName: MethodStringName1<OpenXRCompositionLayerCylinder, Unit, Float> =
        MethodStringName1<OpenXRCompositionLayerCylinder, Unit, Float>("set_central_angle")

    @JvmField
    public val getCentralAngleName: MethodStringName0<OpenXRCompositionLayerCylinder, Float> =
        MethodStringName0<OpenXRCompositionLayerCylinder, Float>("get_central_angle")

    @JvmField
    public val setFallbackSegmentsName:
        MethodStringName1<OpenXRCompositionLayerCylinder, Unit, Long> =
        MethodStringName1<OpenXRCompositionLayerCylinder, Unit, Long>("set_fallback_segments")

    @JvmField
    public val getFallbackSegmentsName: MethodStringName0<OpenXRCompositionLayerCylinder, Long> =
        MethodStringName0<OpenXRCompositionLayerCylinder, Long>("get_fallback_segments")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerCylinder", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerCylinder", "get_radius", 1740695150)

    internal val setAspectRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerCylinder", "set_aspect_ratio", 373806689)

    internal val getAspectRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerCylinder", "get_aspect_ratio", 1740695150)

    internal val setCentralAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerCylinder", "set_central_angle", 373806689)

    internal val getCentralAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerCylinder", "get_central_angle", 1740695150)

    internal val setFallbackSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerCylinder", "set_fallback_segments", 1286410249)

    internal val getFallbackSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerCylinder", "get_fallback_segments", 3905245786)
  }
}
