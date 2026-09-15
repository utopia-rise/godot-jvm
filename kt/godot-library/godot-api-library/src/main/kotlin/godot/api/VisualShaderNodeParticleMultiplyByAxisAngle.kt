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
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node helps to multiply a position input vector by rotation using specific axis. Intended to
 * work with emitters.
 */
@GodotBaseType
public open class VisualShaderNodeParticleMultiplyByAxisAngle : VisualShaderNode() {
  /**
   * If `true`, the angle will be interpreted in degrees instead of radians.
   */
  public final inline var degreesMode: Boolean
    @JvmName("degreesModeProperty")
    get() = isDegreesMode()
    @JvmName("degreesModeProperty")
    set(`value`) {
      setDegreesMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(856, scriptPtr)
  }

  public final fun setDegreesMode(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setDegreesModePtr)
  }

  public final fun isDegreesMode(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDegreesModePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setDegreesModeName:
        MethodStringName1<VisualShaderNodeParticleMultiplyByAxisAngle, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeParticleMultiplyByAxisAngle, Unit, Boolean>("set_degrees_mode")

    @JvmField
    public val isDegreesModeName:
        MethodStringName0<VisualShaderNodeParticleMultiplyByAxisAngle, Boolean> =
        MethodStringName0<VisualShaderNodeParticleMultiplyByAxisAngle, Boolean>("is_degrees_mode")
  }

  public object MethodBindings {
    internal val setDegreesModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleMultiplyByAxisAngle", "set_degrees_mode", 2586408642)

    internal val isDegreesModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleMultiplyByAxisAngle", "is_degrees_mode", 36873697)
  }
}
