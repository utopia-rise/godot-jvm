// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Translated to `uniform vec3` in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeVec3Parameter : VisualShaderNodeParameter() {
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
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var defaultValue: Vector3
    @JvmName("defaultValueProperty")
    get() = getDefaultValue()
    @JvmName("defaultValueProperty")
    set(`value`) {
      setDefaultValue(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(904, scriptPtr)
  }

  /**
   * This is a helper function for [defaultValue] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visualshadernodevec3parameter.defaultValue
   * //Your changes
   * visualshadernodevec3parameter.defaultValue = myCoreType
   * ``````
   *
   * A default value to be assigned within the shader.
   */
  @CoreTypeHelper
  public final fun defaultValueMutate(block: Vector3.() -> Unit): Vector3 = defaultValue.apply {
     block(this)
     defaultValue = this
  }

  public final fun setDefaultValueEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setDefaultValueEnabledPtr)
  }

  public final fun isDefaultValueEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDefaultValueEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDefaultValue(`value`: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to value)
    TransferContext.callMethod(MethodBindings.setDefaultValuePtr)
  }

  public final fun getDefaultValue(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDefaultValuePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public companion object {
    @JvmField
    public val setDefaultValueEnabledName:
        MethodStringName1<VisualShaderNodeVec3Parameter, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeVec3Parameter, Unit, Boolean>("set_default_value_enabled")

    @JvmField
    public val isDefaultValueEnabledName: MethodStringName0<VisualShaderNodeVec3Parameter, Boolean>
        = MethodStringName0<VisualShaderNodeVec3Parameter, Boolean>("is_default_value_enabled")

    @JvmField
    public val setDefaultValueName: MethodStringName1<VisualShaderNodeVec3Parameter, Unit, Vector3>
        = MethodStringName1<VisualShaderNodeVec3Parameter, Unit, Vector3>("set_default_value")

    @JvmField
    public val getDefaultValueName: MethodStringName0<VisualShaderNodeVec3Parameter, Vector3> =
        MethodStringName0<VisualShaderNodeVec3Parameter, Vector3>("get_default_value")
  }

  public object MethodBindings {
    internal val setDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVec3Parameter", "set_default_value_enabled", 2586408642)

    internal val isDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVec3Parameter", "is_default_value_enabled", 36873697)

    internal val setDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVec3Parameter", "set_default_value", 3460891852)

    internal val getDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVec3Parameter", "get_default_value", 3360562783)
  }
}
