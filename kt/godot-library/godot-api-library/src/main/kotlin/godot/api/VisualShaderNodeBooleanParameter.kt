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
 * Translated to `uniform bool` in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeBooleanParameter : VisualShaderNodeParameter() {
  /**
   * Enables usage of the [defaultValue].
   */
  public final inline var defaultValueEnabled: Boolean
    @JvmName("defaultValueEnabledProperty")
    get() = isDefaultValueEnabled()
    @JvmName("defaultValueEnabledProperty")
    set(`value`) {
      setDefaultValueEnabled(value)
    }

  /**
   * A default value to be assigned within the shader.
   */
  public final inline var defaultValue: Boolean
    @JvmName("defaultValueProperty")
    get() = getDefaultValue()
    @JvmName("defaultValueProperty")
    set(`value`) {
      setDefaultValue(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(808, scriptPtr)
  }

  public final fun setDefaultValueEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setDefaultValueEnabledPtr, 0)
  }

  public final fun isDefaultValueEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isDefaultValueEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDefaultValue(`value`: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, value)
    TransferContext.callPtrMethod(MethodBindings.setDefaultValuePtr, 0)
  }

  public final fun getDefaultValue(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDefaultValuePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setDefaultValueEnabledName:
        MethodStringName1<VisualShaderNodeBooleanParameter, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeBooleanParameter, Unit, Boolean>("set_default_value_enabled")

    @JvmField
    public val isDefaultValueEnabledName:
        MethodStringName0<VisualShaderNodeBooleanParameter, Boolean> =
        MethodStringName0<VisualShaderNodeBooleanParameter, Boolean>("is_default_value_enabled")

    @JvmField
    public val setDefaultValueName:
        MethodStringName1<VisualShaderNodeBooleanParameter, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeBooleanParameter, Unit, Boolean>("set_default_value")

    @JvmField
    public val getDefaultValueName: MethodStringName0<VisualShaderNodeBooleanParameter, Boolean> =
        MethodStringName0<VisualShaderNodeBooleanParameter, Boolean>("get_default_value")
  }

  public object MethodBindings {
    internal val setDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeBooleanParameter", "set_default_value_enabled", 2586408642)

    internal val isDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeBooleanParameter", "is_default_value_enabled", 36873697)

    internal val setDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeBooleanParameter", "set_default_value", 2586408642)

    internal val getDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeBooleanParameter", "get_default_value", 36873697)
  }
}
