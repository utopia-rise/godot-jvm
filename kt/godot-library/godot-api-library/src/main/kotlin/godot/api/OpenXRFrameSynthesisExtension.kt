// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This class implements the
 * [url=https://registry.khronos.org/OpenXR/specs/1.1/html/xrspec.html#XR_EXT_frame_synthesis]OpenXR
 * Frame synthesis extension[/url]. When enabled in the project settings and supported by the XR
 * runtime in use, frame synthesis uses advanced reprojection techniques to inject additional frames so
 * that your XR experience hits the full frame rate of the device.
 */
@GodotBaseType
public open class OpenXRFrameSynthesisExtension : OpenXRExtensionWrapper() {
  /**
   * Enable frame synthesis. When `true` motion vector and depth data is provided to the XR runtime.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = isEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * If `true` this informs the XR runtime we will be providing frames at a greatly reduced rate.
   * Enable this when you expect your application to run at low framerates and wish to inject multiple
   * reprojected frames.
   */
  public final inline var relaxFrameInterval: Boolean
    @JvmName("relaxFrameIntervalProperty")
    get() = getRelaxFrameInterval()
    @JvmName("relaxFrameIntervalProperty")
    set(`value`) {
      setRelaxFrameInterval(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(452, scriptPtr)
  }

  /**
   * Returns `true` if frame synthesis is enabled in the project settings and the current XR runtime
   * supports frame synthesis. The value returned will only be valid once OpenXR has been initialized.
   */
  public final fun isAvailable(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isAvailablePtr)

  public final fun isEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isEnabledPtr)

  public final fun setEnabled(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnabledPtr, enable)
  }

  public final fun getRelaxFrameInterval(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getRelaxFrameIntervalPtr)

  public final fun setRelaxFrameInterval(relaxFrameInterval: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setRelaxFrameIntervalPtr, relaxFrameInterval)
  }

  /**
   * Queues the next frame to be skipped when supplying motion vector and depth data. Call this
   * after teleporting your player or a similar action has moved the player to prevent incorrect
   * reprojection results due to this movement.
   */
  public final fun skipNextFrame(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.skipNextFramePtr)
  }

  public companion object {
    @JvmField
    public val isAvailableName: MethodStringName0<OpenXRFrameSynthesisExtension, Boolean> =
        MethodStringName0<OpenXRFrameSynthesisExtension, Boolean>("is_available")

    @JvmField
    public val isEnabledName: MethodStringName0<OpenXRFrameSynthesisExtension, Boolean> =
        MethodStringName0<OpenXRFrameSynthesisExtension, Boolean>("is_enabled")

    @JvmField
    public val setEnabledName: MethodStringName1<OpenXRFrameSynthesisExtension, Unit, Boolean> =
        MethodStringName1<OpenXRFrameSynthesisExtension, Unit, Boolean>("set_enabled")

    @JvmField
    public val getRelaxFrameIntervalName: MethodStringName0<OpenXRFrameSynthesisExtension, Boolean>
        = MethodStringName0<OpenXRFrameSynthesisExtension, Boolean>("get_relax_frame_interval")

    @JvmField
    public val setRelaxFrameIntervalName:
        MethodStringName1<OpenXRFrameSynthesisExtension, Unit, Boolean> =
        MethodStringName1<OpenXRFrameSynthesisExtension, Unit, Boolean>("set_relax_frame_interval")

    @JvmField
    public val skipNextFrameName: MethodStringName0<OpenXRFrameSynthesisExtension, Unit> =
        MethodStringName0<OpenXRFrameSynthesisExtension, Unit>("skip_next_frame")
  }

  public object MethodBindings {
    internal val isAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFrameSynthesisExtension", "is_available", 36873697)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFrameSynthesisExtension", "is_enabled", 36873697)

    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFrameSynthesisExtension", "set_enabled", 2586408642)

    internal val getRelaxFrameIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFrameSynthesisExtension", "get_relax_frame_interval", 36873697)

    internal val setRelaxFrameIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFrameSynthesisExtension", "set_relax_frame_interval", 2586408642)

    internal val skipNextFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRFrameSynthesisExtension", "skip_next_frame", 3218959716)
  }
}
