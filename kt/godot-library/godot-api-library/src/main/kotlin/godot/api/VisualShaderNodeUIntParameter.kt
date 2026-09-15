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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A [VisualShaderNodeParameter] of type unsigned [Long]. Offers additional customization for range
 * of accepted values.
 */
@GodotBaseType
public open class VisualShaderNodeUIntParameter : VisualShaderNodeParameter() {
  /**
   * If `true`, the node will have a custom default value.
   */
  public final inline var defaultValueEnabled: Boolean
    @JvmName("defaultValueEnabledProperty")
    get() = isDefaultValueEnabled()
    @JvmName("defaultValueEnabledProperty")
    set(`value`) {
      setDefaultValueEnabled(value)
    }

  /**
   * Default value of this parameter, which will be used if not set externally.
   * [defaultValueEnabled] must be enabled; defaults to `0` otherwise.
   */
  public final inline var defaultValue: Int
    @JvmName("defaultValueProperty")
    get() = getDefaultValue()
    @JvmName("defaultValueProperty")
    set(`value`) {
      setDefaultValue(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(895, scriptPtr)
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

  public final fun setDefaultValue(`value`: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, value.toLong())
    TransferContext.callPtrMethod(MethodBindings.setDefaultValuePtr, 0)
  }

  public final fun getDefaultValue(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDefaultValuePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val setDefaultValueEnabledName:
        MethodStringName1<VisualShaderNodeUIntParameter, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeUIntParameter, Unit, Boolean>("set_default_value_enabled")

    @JvmField
    public val isDefaultValueEnabledName: MethodStringName0<VisualShaderNodeUIntParameter, Boolean>
        = MethodStringName0<VisualShaderNodeUIntParameter, Boolean>("is_default_value_enabled")

    @JvmField
    public val setDefaultValueName: MethodStringName1<VisualShaderNodeUIntParameter, Unit, Int> =
        MethodStringName1<VisualShaderNodeUIntParameter, Unit, Int>("set_default_value")

    @JvmField
    public val getDefaultValueName: MethodStringName0<VisualShaderNodeUIntParameter, Int> =
        MethodStringName0<VisualShaderNodeUIntParameter, Int>("get_default_value")
  }

  public object MethodBindings {
    internal val setDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntParameter", "set_default_value_enabled", 2586408642)

    internal val isDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntParameter", "is_default_value_enabled", 36873697)

    internal val setDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntParameter", "set_default_value", 1286410249)

    internal val getDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntParameter", "get_default_value", 3905245786)
  }
}
