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
import godot.core.MethodStringName2
import godot.core.RID
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_ANY
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_ANY
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A material that uses a custom [Shader] program to render visual items (canvas items, meshes,
 * skies, fog), or to process particles. Compared to other materials, [ShaderMaterial] gives deeper
 * control over the generated shader code. For more information, see the shaders documentation index
 * below.
 *
 * Multiple [ShaderMaterial]s can use the same shader and configure different values for the shader
 * uniforms.
 *
 * **Note:** For performance reasons, the [signal Resource.changed] signal is only emitted when the
 * [Resource.resourceName] changes. Only in editor, it is also emitted for [shader] changes.
 */
@GodotBaseType
public open class ShaderMaterial : Material() {
  /**
   * The [Shader] program used to render this material.
   */
  public final inline var shader: Shader?
    @JvmName("shaderProperty")
    get() = getShader()
    @JvmName("shaderProperty")
    set(`value`) {
      setShader(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(658, scriptPtr)
  }

  public final fun setShader(shader: Shader?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, shader)
    TransferContext.callMethod(MethodBindings.setShaderPtr)
  }

  public final fun getShader(): Shader? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShaderPtr)
    return (TransferContext.readReturnValue_OBJECT() as Shader?)
  }

  /**
   * Changes the value set for this material of a uniform in the shader.
   *
   * **Note:** [param] is case-sensitive and must match the name of the uniform in the code exactly
   * (not the capitalized name in the inspector).
   *
   * **Note:** Changes to the shader uniform will be effective on all instances using this
   * [ShaderMaterial]. To prevent this, use per-instance uniforms with
   * [CanvasItem.setInstanceShaderParameter], [GeometryInstance3D.setInstanceShaderParameter] or
   * duplicate the [ShaderMaterial] resource using [Resource.duplicate]. Per-instance uniforms allow
   * for better shader reuse and are therefore faster, so they should be preferred over duplicating the
   * [ShaderMaterial] when possible.
   */
  public final fun setShaderParameter(`param`: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_ANY(ptr, objectID.id, param, value)
    TransferContext.callMethod(MethodBindings.setShaderParameterPtr)
  }

  /**
   * Returns the current value set for this material of a uniform in the shader.
   */
  public final fun getShaderParameter(`param`: StringName): Any? {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, param)
    TransferContext.callMethod(MethodBindings.getShaderParameterPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderRid(): RID {
    throw NotImplementedError("ShaderMaterial::_getShaderRid can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("ShaderMaterial::_getShaderMode can't be called from the JVM.")
  }

  /**
   * Changes the value set for this material of a uniform in the shader.
   *
   * **Note:** [param] is case-sensitive and must match the name of the uniform in the code exactly
   * (not the capitalized name in the inspector).
   *
   * **Note:** Changes to the shader uniform will be effective on all instances using this
   * [ShaderMaterial]. To prevent this, use per-instance uniforms with
   * [CanvasItem.setInstanceShaderParameter], [GeometryInstance3D.setInstanceShaderParameter] or
   * duplicate the [ShaderMaterial] resource using [Resource.duplicate]. Per-instance uniforms allow
   * for better shader reuse and are therefore faster, so they should be preferred over duplicating the
   * [ShaderMaterial] when possible.
   */
  public final fun setShaderParameter(`param`: String, `value`: Any?) =
      setShaderParameter(param.asCachedStringName(), value)

  /**
   * Returns the current value set for this material of a uniform in the shader.
   */
  public final fun getShaderParameter(`param`: String): Any? =
      getShaderParameter(param.asCachedStringName())

  public companion object {
    @JvmField
    public val setShaderName: MethodStringName1<ShaderMaterial, Unit, Shader?> =
        MethodStringName1<ShaderMaterial, Unit, Shader?>("set_shader")

    @JvmField
    public val getShaderName: MethodStringName0<ShaderMaterial, Shader?> =
        MethodStringName0<ShaderMaterial, Shader?>("get_shader")

    @JvmField
    public val setShaderParameterName: MethodStringName2<ShaderMaterial, Unit, StringName, Any?> =
        MethodStringName2<ShaderMaterial, Unit, StringName, Any?>("set_shader_parameter")

    @JvmField
    public val getShaderParameterName: MethodStringName1<ShaderMaterial, Any?, StringName> =
        MethodStringName1<ShaderMaterial, Any?, StringName>("get_shader_parameter")
  }

  public object MethodBindings {
    internal val setShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderMaterial", "set_shader", 3341921675)

    internal val getShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderMaterial", "get_shader", 2078273437)

    internal val setShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderMaterial", "set_shader_parameter", 3776071444)

    internal val getShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ShaderMaterial", "get_shader_parameter", 2760726917)
  }
}
