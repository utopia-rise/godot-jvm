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
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node was replaced by [VisualShaderNodeFrame] and only exists to preserve compatibility. In
 * the [VisualShader] editor it behaves exactly like [VisualShaderNodeFrame].
 */
@GodotBaseType
public open class VisualShaderNodeComment : VisualShaderNodeFrame() {
  /**
   * This property only exists to preserve data authored in earlier versions of Godot. It has
   * currently no function.
   */
  public final inline var description: String
    @JvmName("descriptionProperty")
    get() = getDescription()
    @JvmName("descriptionProperty")
    set(`value`) {
      setDescription(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(814, scriptPtr)
  }

  public final fun setDescription(description: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, description)
    TransferContext.callMethod(MethodBindings.setDescriptionPtr)
  }

  public final fun getDescription(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDescriptionPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val setDescriptionName: MethodStringName1<VisualShaderNodeComment, Unit, String> =
        MethodStringName1<VisualShaderNodeComment, Unit, String>("set_description")

    @JvmField
    public val getDescriptionName: MethodStringName0<VisualShaderNodeComment, String> =
        MethodStringName0<VisualShaderNodeComment, String>("get_description")
  }

  public object MethodBindings {
    internal val setDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeComment", "set_description", 83702148)

    internal val getDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeComment", "get_description", 201670096)
  }
}
