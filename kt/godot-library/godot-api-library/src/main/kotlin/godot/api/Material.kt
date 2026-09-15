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
import godot.core.RID
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [Material] is a base resource used for coloring and shading geometry. All materials inherit from
 * it and almost all [VisualInstance3D] derived nodes carry a [Material]. A few flags and parameters
 * are shared between all material types and are configured here.
 *
 * Importantly, you can inherit from [Material] to create your own custom material type in script or
 * in GDExtension.
 */
@GodotBaseType
public abstract class Material : Resource() {
  /**
   * Sets the render priority for objects in 3D scenes. Higher priority objects will be sorted in
   * front of lower priority objects. In other words, all objects with [renderPriority] `1` will render
   * on top of all objects with [renderPriority] `0`.
   *
   * **Note:** This only applies to [StandardMaterial3D]s and [ShaderMaterial]s with type "Spatial".
   *
   * **Note:** This will not impact how transparent objects are sorted relative to opaque objects or
   * how dynamic meshes will be sorted relative to other opaque meshes. This is because all transparent
   * objects are drawn after all opaque objects and all dynamic opaque meshes are drawn before other
   * opaque meshes.
   */
  public final inline var renderPriority: Int
    @JvmName("renderPriorityProperty")
    get() = getRenderPriority()
    @JvmName("renderPriorityProperty")
    set(`value`) {
      setRenderPriority(value)
    }

  /**
   * Sets the [Material] to be used for the next pass. This renders the object again using a
   * different material.
   *
   * **Note:** [nextPass] materials are not necessarily drawn immediately after the source
   * [Material]. Draw order is determined by material properties, [renderPriority], and distance to
   * camera.
   *
   * **Note:** This only applies to [StandardMaterial3D]s and [ShaderMaterial]s with type "Spatial".
   */
  public final inline var nextPass: Material?
    @JvmName("nextPassProperty")
    get() = getNextPass()
    @JvmName("nextPassProperty")
    set(`value`) {
      setNextPass(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(370, scriptPtr)
  }

  /**
   * Only exposed for the purpose of overriding. You cannot call this function directly. Used
   * internally by various editor tools. Used to access the RID of the [Material]'s [Shader].
   */
  public abstract fun _getShaderRid(): RID

  /**
   * Only exposed for the purpose of overriding. You cannot call this function directly. Used
   * internally by various editor tools.
   */
  public abstract fun _getShaderMode(): Shader.Mode

  /**
   * Only exposed for the purpose of overriding. You cannot call this function directly. Used
   * internally to determine if [nextPass] should be shown in the editor or not.
   */
  public open fun _canDoNextPass(): Boolean {
    throw NotImplementedError("Material::_canDoNextPass is not implemented.")
  }

  /**
   * Only exposed for the purpose of overriding. You cannot call this function directly. Used
   * internally to determine if [renderPriority] should be shown in the editor or not.
   */
  public open fun _canUseRenderPriority(): Boolean {
    throw NotImplementedError("Material::_canUseRenderPriority is not implemented.")
  }

  public final fun setNextPass(nextPass: Material?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, nextPass)
    TransferContext.callMethod(MethodBindings.setNextPassPtr)
  }

  public final fun getNextPass(): Material? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNextPassPtr)
    return (TransferContext.readReturnValue_OBJECT() as Material?)
  }

  public final fun setRenderPriority(priority: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, priority.toLong())
    TransferContext.callMethod(MethodBindings.setRenderPriorityPtr)
  }

  public final fun getRenderPriority(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderPriorityPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Only available when running in the editor. Opens a popup that visualizes the generated shader
   * code, including all variants and internal shader code. See also [Shader.inspectNativeShaderCode].
   */
  public final fun inspectNativeShaderCode(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.inspectNativeShaderCodePtr)
  }

  /**
   * Creates a placeholder version of this resource ([PlaceholderMaterial]).
   */
  public final fun createPlaceholder(): Resource? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createPlaceholderPtr)
    return (TransferContext.readReturnValue_OBJECT() as Resource?)
  }

  public companion object {
    @JvmField
    public val setNextPassName: MethodStringName1<Material, Unit, Material?> =
        MethodStringName1<Material, Unit, Material?>("set_next_pass")

    @JvmField
    public val getNextPassName: MethodStringName0<Material, Material?> =
        MethodStringName0<Material, Material?>("get_next_pass")

    @JvmField
    public val setRenderPriorityName: MethodStringName1<Material, Unit, Int> =
        MethodStringName1<Material, Unit, Int>("set_render_priority")

    @JvmField
    public val getRenderPriorityName: MethodStringName0<Material, Int> =
        MethodStringName0<Material, Int>("get_render_priority")

    @JvmField
    public val inspectNativeShaderCodeName: MethodStringName0<Material, Unit> =
        MethodStringName0<Material, Unit>("inspect_native_shader_code")

    @JvmField
    public val createPlaceholderName: MethodStringName0<Material, Resource?> =
        MethodStringName0<Material, Resource?>("create_placeholder")

    /**
     * Maximum value for the [renderPriority] parameter.
     */
    public final const val RENDER_PRIORITY_MAX: Long = 127

    /**
     * Minimum value for the [renderPriority] parameter.
     */
    public final const val RENDER_PRIORITY_MIN: Long = -128
  }

  public object MethodBindings {
    internal val setNextPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Material", "set_next_pass", 2757459619)

    internal val getNextPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Material", "get_next_pass", 5934680)

    internal val setRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Material", "set_render_priority", 1286410249)

    internal val getRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Material", "get_render_priority", 3905245786)

    internal val inspectNativeShaderCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Material", "inspect_native_shader_code", 3218959716)

    internal val createPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Material", "create_placeholder", 121922552)
  }
}

internal class MaterialDummy : Material() {
  public override fun _getShaderRid(): RID {
    throw NotImplementedError("Material::_getShaderRid is only implemented by non-JVM code.")
  }

  public override fun _getShaderMode(): Shader.Mode {
    throw NotImplementedError("Material::_getShaderMode is only implemented by non-JVM code.")
  }
}
