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
import godot.core.Transform3D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.TRANSFORM3D
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Translated to `uniform mat4` in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeTransformParameter : VisualShaderNodeParameter() {
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
  public final inline var defaultValue: Transform3D
    @JvmName("defaultValueProperty")
    get() = getDefaultValue()
    @JvmName("defaultValueProperty")
    set(`value`) {
      setDefaultValue(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(890, scriptPtr)
  }

  /**
   * This is a helper function for [defaultValue] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visualshadernodetransformparameter.defaultValue
   * //Your changes
   * visualshadernodetransformparameter.defaultValue = myCoreType
   * ``````
   *
   * A default value to be assigned within the shader.
   */
  @CoreTypeHelper
  public final fun defaultValueMutate(block: Transform3D.() -> Unit): Transform3D =
      defaultValue.apply {
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

  public final fun setDefaultValue(`value`: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to value)
    TransferContext.callMethod(MethodBindings.setDefaultValuePtr)
  }

  public final fun getDefaultValue(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDefaultValuePtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  public companion object {
    @JvmField
    public val setDefaultValueEnabledName:
        MethodStringName1<VisualShaderNodeTransformParameter, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeTransformParameter, Unit, Boolean>("set_default_value_enabled")

    @JvmField
    public val isDefaultValueEnabledName:
        MethodStringName0<VisualShaderNodeTransformParameter, Boolean> =
        MethodStringName0<VisualShaderNodeTransformParameter, Boolean>("is_default_value_enabled")

    @JvmField
    public val setDefaultValueName:
        MethodStringName1<VisualShaderNodeTransformParameter, Unit, Transform3D> =
        MethodStringName1<VisualShaderNodeTransformParameter, Unit, Transform3D>("set_default_value")

    @JvmField
    public val getDefaultValueName:
        MethodStringName0<VisualShaderNodeTransformParameter, Transform3D> =
        MethodStringName0<VisualShaderNodeTransformParameter, Transform3D>("get_default_value")
  }

  public object MethodBindings {
    internal val setDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformParameter", "set_default_value_enabled", 2586408642)

    internal val isDefaultValueEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformParameter", "is_default_value_enabled", 36873697)

    internal val setDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformParameter", "set_default_value", 2952846383)

    internal val getDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformParameter", "get_default_value", 3229777777)
  }
}
