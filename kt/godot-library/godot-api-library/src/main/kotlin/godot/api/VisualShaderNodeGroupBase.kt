// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_LONG_LONG_STRING
import godot.callMethod_LONG_STRING
import godot.callMethod_STRING
import godot.callMethod_STRING_ret_BOOL
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_ret_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
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
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setInputsPtr, inputs)
  }

  /**
   * Returns a [String] description of the input ports as a colon-separated list using the format
   * `id,type,name;` (see [addInputPort]).
   */
  public final fun getInputs(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getInputsPtr)

  /**
   * Defines all output ports using a [String] formatted as a colon-separated list: `id,type,name;`
   * (see [addOutputPort]).
   */
  public final fun setOutputs(outputs: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setOutputsPtr, outputs)
  }

  /**
   * Returns a [String] description of the output ports as a colon-separated list using the format
   * `id,type,name;` (see [addOutputPort]).
   */
  public final fun getOutputs(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getOutputsPtr)

  /**
   * Returns `true` if the specified port name does not override an existed port name and is valid
   * within the shader.
   */
  public final fun isValidPortName(name: String): Boolean =
      TransferContext.callMethod_STRING_ret_BOOL(ptr, objectID.id, MethodBindings.isValidPortNamePtr, name)

  /**
   * Adds an input port with the specified [type] (see [VisualShaderNode.PortType]) and [name].
   */
  public final fun addInputPort(
    id: Int,
    type: Int,
    name: String,
  ): Unit {
    TransferContext.callMethod_LONG_LONG_STRING(ptr, objectID.id, MethodBindings.addInputPortPtr, id.toLong(), type.toLong(), name)
  }

  /**
   * Removes the specified input port.
   */
  public final fun removeInputPort(id: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.removeInputPortPtr, id.toLong())
  }

  /**
   * Returns the number of input ports in use. Alternative for [getFreeInputPortId].
   */
  public final fun getInputPortCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getInputPortCountPtr).toInt()

  /**
   * Returns `true` if the specified input port exists.
   */
  public final fun hasInputPort(id: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.hasInputPortPtr, id.toLong())

  /**
   * Removes all previously specified input ports.
   */
  public final fun clearInputPorts(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearInputPortsPtr)
  }

  /**
   * Adds an output port with the specified [type] (see [VisualShaderNode.PortType]) and [name].
   */
  public final fun addOutputPort(
    id: Int,
    type: Int,
    name: String,
  ): Unit {
    TransferContext.callMethod_LONG_LONG_STRING(ptr, objectID.id, MethodBindings.addOutputPortPtr, id.toLong(), type.toLong(), name)
  }

  /**
   * Removes the specified output port.
   */
  public final fun removeOutputPort(id: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.removeOutputPortPtr, id.toLong())
  }

  /**
   * Returns the number of output ports in use. Alternative for [getFreeOutputPortId].
   */
  public final fun getOutputPortCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOutputPortCountPtr).toInt()

  /**
   * Returns `true` if the specified output port exists.
   */
  public final fun hasOutputPort(id: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.hasOutputPortPtr, id.toLong())

  /**
   * Removes all previously specified output ports.
   */
  public final fun clearOutputPorts(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearOutputPortsPtr)
  }

  /**
   * Renames the specified input port.
   */
  public final fun setInputPortName(id: Int, name: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setInputPortNamePtr, id.toLong(), name)
  }

  /**
   * Sets the specified input port's type (see [VisualShaderNode.PortType]).
   */
  public final fun setInputPortType(id: Int, type: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setInputPortTypePtr, id.toLong(), type.toLong())
  }

  /**
   * Renames the specified output port.
   */
  public final fun setOutputPortName(id: Int, name: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setOutputPortNamePtr, id.toLong(), name)
  }

  /**
   * Sets the specified output port's type (see [VisualShaderNode.PortType]).
   */
  public final fun setOutputPortType(id: Int, type: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setOutputPortTypePtr, id.toLong(), type.toLong())
  }

  /**
   * Returns a free input port ID which can be used in [addInputPort].
   */
  public final fun getFreeInputPortId(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFreeInputPortIdPtr).toInt()

  /**
   * Returns a free output port ID which can be used in [addOutputPort].
   */
  public final fun getFreeOutputPortId(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFreeOutputPortIdPtr).toInt()

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
