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
import godot.core.MethodStringName3
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_LONG_STRING
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Currently, has no direct usage, use the derived classes instead.
 */
@GodotBaseType
public open class VisualShaderNodeGroupBase internal constructor() : VisualShaderNodeResizableBase()
    {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(835, scriptPtr)
  }

  /**
   * Defines all input ports using a [String] formatted as a colon-separated list: `id,type,name;`
   * (see [addInputPort]).
   */
  public final fun setInputs(inputs: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, inputs)
    TransferContext.callMethod(MethodBindings.setInputsPtr)
  }

  /**
   * Returns a [String] description of the input ports as a colon-separated list using the format
   * `id,type,name;` (see [addInputPort]).
   */
  public final fun getInputs(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInputsPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Defines all output ports using a [String] formatted as a colon-separated list: `id,type,name;`
   * (see [addOutputPort]).
   */
  public final fun setOutputs(outputs: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, outputs)
    TransferContext.callMethod(MethodBindings.setOutputsPtr)
  }

  /**
   * Returns a [String] description of the output ports as a colon-separated list using the format
   * `id,type,name;` (see [addOutputPort]).
   */
  public final fun getOutputs(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutputsPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if the specified port name does not override an existed port name and is valid
   * within the shader.
   */
  public final fun isValidPortName(name: String): Boolean {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.isValidPortNamePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Adds an input port with the specified [type] (see [VisualShaderNode.PortType]) and [name].
   */
  public final fun addInputPort(
    id: Int,
    type: Int,
    name: String,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_STRING(ptr, objectID.id, id.toLong(), type.toLong(), name)
    TransferContext.callMethod(MethodBindings.addInputPortPtr)
  }

  /**
   * Removes the specified input port.
   */
  public final fun removeInputPort(id: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callPtrMethod(MethodBindings.removeInputPortPtr, 0)
  }

  /**
   * Returns the number of input ports in use. Alternative for [getFreeInputPortId].
   */
  public final fun getInputPortCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInputPortCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the specified input port exists.
   */
  public final fun hasInputPort(id: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callPtrMethod(MethodBindings.hasInputPortPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Removes all previously specified input ports.
   */
  public final fun clearInputPorts(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearInputPortsPtr, 0)
  }

  /**
   * Adds an output port with the specified [type] (see [VisualShaderNode.PortType]) and [name].
   */
  public final fun addOutputPort(
    id: Int,
    type: Int,
    name: String,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_STRING(ptr, objectID.id, id.toLong(), type.toLong(), name)
    TransferContext.callMethod(MethodBindings.addOutputPortPtr)
  }

  /**
   * Removes the specified output port.
   */
  public final fun removeOutputPort(id: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callPtrMethod(MethodBindings.removeOutputPortPtr, 0)
  }

  /**
   * Returns the number of output ports in use. Alternative for [getFreeOutputPortId].
   */
  public final fun getOutputPortCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOutputPortCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the specified output port exists.
   */
  public final fun hasOutputPort(id: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callPtrMethod(MethodBindings.hasOutputPortPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Removes all previously specified output ports.
   */
  public final fun clearOutputPorts(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearOutputPortsPtr, 0)
  }

  /**
   * Renames the specified input port.
   */
  public final fun setInputPortName(id: Int, name: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, id.toLong(), name)
    TransferContext.callMethod(MethodBindings.setInputPortNamePtr)
  }

  /**
   * Sets the specified input port's type (see [VisualShaderNode.PortType]).
   */
  public final fun setInputPortType(id: Int, type: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, id.toLong(), type.toLong())
    TransferContext.callPtrMethod(MethodBindings.setInputPortTypePtr, 0)
  }

  /**
   * Renames the specified output port.
   */
  public final fun setOutputPortName(id: Int, name: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, id.toLong(), name)
    TransferContext.callMethod(MethodBindings.setOutputPortNamePtr)
  }

  /**
   * Sets the specified output port's type (see [VisualShaderNode.PortType]).
   */
  public final fun setOutputPortType(id: Int, type: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, id.toLong(), type.toLong())
    TransferContext.callPtrMethod(MethodBindings.setOutputPortTypePtr, 0)
  }

  /**
   * Returns a free input port ID which can be used in [addInputPort].
   */
  public final fun getFreeInputPortId(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFreeInputPortIdPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns a free output port ID which can be used in [addOutputPort].
   */
  public final fun getFreeOutputPortId(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFreeOutputPortIdPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val setInputsName: MethodStringName1<VisualShaderNodeGroupBase, Unit, String> =
        MethodStringName1<VisualShaderNodeGroupBase, Unit, String>("set_inputs")

    @JvmField
    public val getInputsName: MethodStringName0<VisualShaderNodeGroupBase, String> =
        MethodStringName0<VisualShaderNodeGroupBase, String>("get_inputs")

    @JvmField
    public val setOutputsName: MethodStringName1<VisualShaderNodeGroupBase, Unit, String> =
        MethodStringName1<VisualShaderNodeGroupBase, Unit, String>("set_outputs")

    @JvmField
    public val getOutputsName: MethodStringName0<VisualShaderNodeGroupBase, String> =
        MethodStringName0<VisualShaderNodeGroupBase, String>("get_outputs")

    @JvmField
    public val isValidPortNameName: MethodStringName1<VisualShaderNodeGroupBase, Boolean, String> =
        MethodStringName1<VisualShaderNodeGroupBase, Boolean, String>("is_valid_port_name")

    @JvmField
    public val addInputPortName:
        MethodStringName3<VisualShaderNodeGroupBase, Unit, Int, Int, String> =
        MethodStringName3<VisualShaderNodeGroupBase, Unit, Int, Int, String>("add_input_port")

    @JvmField
    public val removeInputPortName: MethodStringName1<VisualShaderNodeGroupBase, Unit, Int> =
        MethodStringName1<VisualShaderNodeGroupBase, Unit, Int>("remove_input_port")

    @JvmField
    public val getInputPortCountName: MethodStringName0<VisualShaderNodeGroupBase, Int> =
        MethodStringName0<VisualShaderNodeGroupBase, Int>("get_input_port_count")

    @JvmField
    public val hasInputPortName: MethodStringName1<VisualShaderNodeGroupBase, Boolean, Int> =
        MethodStringName1<VisualShaderNodeGroupBase, Boolean, Int>("has_input_port")

    @JvmField
    public val clearInputPortsName: MethodStringName0<VisualShaderNodeGroupBase, Unit> =
        MethodStringName0<VisualShaderNodeGroupBase, Unit>("clear_input_ports")

    @JvmField
    public val addOutputPortName:
        MethodStringName3<VisualShaderNodeGroupBase, Unit, Int, Int, String> =
        MethodStringName3<VisualShaderNodeGroupBase, Unit, Int, Int, String>("add_output_port")

    @JvmField
    public val removeOutputPortName: MethodStringName1<VisualShaderNodeGroupBase, Unit, Int> =
        MethodStringName1<VisualShaderNodeGroupBase, Unit, Int>("remove_output_port")

    @JvmField
    public val getOutputPortCountName: MethodStringName0<VisualShaderNodeGroupBase, Int> =
        MethodStringName0<VisualShaderNodeGroupBase, Int>("get_output_port_count")

    @JvmField
    public val hasOutputPortName: MethodStringName1<VisualShaderNodeGroupBase, Boolean, Int> =
        MethodStringName1<VisualShaderNodeGroupBase, Boolean, Int>("has_output_port")

    @JvmField
    public val clearOutputPortsName: MethodStringName0<VisualShaderNodeGroupBase, Unit> =
        MethodStringName0<VisualShaderNodeGroupBase, Unit>("clear_output_ports")

    @JvmField
    public val setInputPortNameName: MethodStringName2<VisualShaderNodeGroupBase, Unit, Int, String>
        = MethodStringName2<VisualShaderNodeGroupBase, Unit, Int, String>("set_input_port_name")

    @JvmField
    public val setInputPortTypeName: MethodStringName2<VisualShaderNodeGroupBase, Unit, Int, Int> =
        MethodStringName2<VisualShaderNodeGroupBase, Unit, Int, Int>("set_input_port_type")

    @JvmField
    public val setOutputPortNameName:
        MethodStringName2<VisualShaderNodeGroupBase, Unit, Int, String> =
        MethodStringName2<VisualShaderNodeGroupBase, Unit, Int, String>("set_output_port_name")

    @JvmField
    public val setOutputPortTypeName: MethodStringName2<VisualShaderNodeGroupBase, Unit, Int, Int> =
        MethodStringName2<VisualShaderNodeGroupBase, Unit, Int, Int>("set_output_port_type")

    @JvmField
    public val getFreeInputPortIdName: MethodStringName0<VisualShaderNodeGroupBase, Int> =
        MethodStringName0<VisualShaderNodeGroupBase, Int>("get_free_input_port_id")

    @JvmField
    public val getFreeOutputPortIdName: MethodStringName0<VisualShaderNodeGroupBase, Int> =
        MethodStringName0<VisualShaderNodeGroupBase, Int>("get_free_output_port_id")
  }

  public object MethodBindings {
    internal val setInputsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "set_inputs", 83702148)

    internal val getInputsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "get_inputs", 201670096)

    internal val setOutputsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "set_outputs", 83702148)

    internal val getOutputsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "get_outputs", 201670096)

    internal val isValidPortNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "is_valid_port_name", 3927539163)

    internal val addInputPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "add_input_port", 2285447957)

    internal val removeInputPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "remove_input_port", 1286410249)

    internal val getInputPortCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "get_input_port_count", 3905245786)

    internal val hasInputPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "has_input_port", 1116898809)

    internal val clearInputPortsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "clear_input_ports", 3218959716)

    internal val addOutputPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "add_output_port", 2285447957)

    internal val removeOutputPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "remove_output_port", 1286410249)

    internal val getOutputPortCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "get_output_port_count", 3905245786)

    internal val hasOutputPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "has_output_port", 1116898809)

    internal val clearOutputPortsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "clear_output_ports", 3218959716)

    internal val setInputPortNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "set_input_port_name", 501894301)

    internal val setInputPortTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "set_input_port_type", 3937882851)

    internal val setOutputPortNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "set_output_port_name", 501894301)

    internal val setOutputPortTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "set_output_port_type", 3937882851)

    internal val getFreeInputPortIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "get_free_input_port_id", 3905245786)

    internal val getFreeOutputPortIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeGroupBase", "get_free_output_port_id", 3905245786)
  }
}
