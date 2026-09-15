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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A virtual class, use the descendants instead.
 */
@GodotBaseType
public open class VisualShaderNodeSample3D internal constructor() : VisualShaderNode() {
  /**
   * An input source type.
   */
  public final inline var source: Source
    @JvmName("sourceProperty")
    get() = getSource()
    @JvmName("sourceProperty")
    set(`value`) {
      setSource(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(869, scriptPtr)
  }

  public final fun setSource(`value`: Source): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, value.value)
    TransferContext.callMethod(MethodBindings.setSourcePtr)
  }

  public final fun getSource(): Source {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSourcePtr)
    return Source.from(TransferContext.readReturnValue_LONG())
  }

  public enum class Source(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Creates internal uniform and provides a way to assign it within node.
     */
    TEXTURE(0),
    /**
     * Use the uniform texture from sampler port.
     */
    PORT(1),
    /**
     * Represents the size of the [Source] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): Source = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSourceName: MethodStringName1<VisualShaderNodeSample3D, Unit, Source> =
        MethodStringName1<VisualShaderNodeSample3D, Unit, Source>("set_source")

    @JvmField
    public val getSourceName: MethodStringName0<VisualShaderNodeSample3D, Source> =
        MethodStringName0<VisualShaderNodeSample3D, Source>("get_source")
  }

  public object MethodBindings {
    internal val setSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeSample3D", "set_source", 3315130991)

    internal val getSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeSample3D", "get_source", 1079494121)
  }
}
