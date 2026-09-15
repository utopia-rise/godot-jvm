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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Automatically adapts its port type to the type of the incoming connection and ensures valid
 * connections.
 */
@GodotBaseType
public open class VisualShaderNodeReroute : VisualShaderNode() {
  public final inline val portType: VisualShaderNode.PortType
    @JvmName("portTypeProperty")
    get() = getPortType()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(864, scriptPtr)
  }

  /**
   * Returns the port type of the reroute node.
   */
  public final fun getPortType(): VisualShaderNode.PortType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPortTypePtr, 2)
    return VisualShaderNode.PortType.from(TransferContext.readReturnValue_LONG())
  }

  public companion object {
    @JvmField
    public val getPortTypeName:
        MethodStringName0<VisualShaderNodeReroute, VisualShaderNode.PortType> =
        MethodStringName0<VisualShaderNodeReroute, VisualShaderNode.PortType>("get_port_type")
  }

  public object MethodBindings {
    internal val getPortTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeReroute", "get_port_type", 1287173294)
  }
}
