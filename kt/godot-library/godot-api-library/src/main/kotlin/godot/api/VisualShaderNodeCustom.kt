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
import godot.core.MethodStringName1
import godot.core.PackedStringArray
import godot.core.VariantArray
import godot.readReturnValue_LONG
import godot.writeMethodArguments_LONG
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * By inheriting this class you can create a custom [VisualShader] script addon which will be
 * automatically added to the Visual Shader Editor. The [VisualShaderNode]'s behavior is defined by
 * overriding the provided virtual methods.
 *
 * In order for the node to be registered as an editor addon, you must use the `@tool` annotation
 * and provide a `class_name` for your custom script. For example:
 *
 * ```
 * @tool
 * extends VisualShaderNodeCustom
 * class_name VisualShaderNodeNoise
 * ```
 */
@GodotBaseType
public open class VisualShaderNodeCustom : VisualShaderNode() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(821, scriptPtr)
  }

  /**
   * Override this method to define the name of the associated custom node in the Visual Shader
   * Editor's members dialog and graph.
   *
   * Defining this method is **optional**, but recommended. If not overridden, the node will be
   * named as "Unnamed".
   */
  public open fun _getName(): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getName is not implemented.")
  }

  /**
   * Override this method to define the description of the associated custom node in the Visual
   * Shader Editor's members dialog.
   *
   * Defining this method is **optional**.
   */
  public open fun _getDescription(): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getDescription is not implemented.")
  }

  /**
   * Override this method to define the path to the associated custom node in the Visual Shader
   * Editor's members dialog. The path may look like `"MyGame/MyFunctions/Noise"`.
   *
   * Defining this method is **optional**. If not overridden, the node will be filed under the
   * "Addons" category.
   */
  public open fun _getCategory(): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getCategory is not implemented.")
  }

  /**
   * Override this method to define the return icon of the associated custom node in the Visual
   * Shader Editor's members dialog.
   *
   * Defining this method is **optional**. If not overridden, no return icon is shown.
   */
  public open fun _getReturnIconType(): VisualShaderNode.PortType {
    throw NotImplementedError("VisualShaderNodeCustom::_getReturnIconType is not implemented.")
  }

  /**
   * Override this method to define the number of input ports of the associated custom node.
   *
   * Defining this method is **required**. If not overridden, the node has no input ports.
   */
  public open fun _getInputPortCount(): Int {
    throw NotImplementedError("VisualShaderNodeCustom::_getInputPortCount is not implemented.")
  }

  /**
   * Override this method to define the returned type of each input port of the associated custom
   * node.
   *
   * Defining this method is **optional**, but recommended. If not overridden, input ports will
   * return the [VisualShaderNode.PORT_TYPE_SCALAR] type.
   */
  public open fun _getInputPortType(port: Int): VisualShaderNode.PortType {
    throw NotImplementedError("VisualShaderNodeCustom::_getInputPortType is not implemented.")
  }

  /**
   * Override this method to define the names of input ports of the associated custom node. The
   * names are used both for the input slots in the editor and as identifiers in the shader code, and
   * are passed in the `input_vars` array in [_getCode].
   *
   * Defining this method is **optional**, but recommended. If not overridden, input ports are named
   * as `"in" + str(port)`.
   */
  public open fun _getInputPortName(port: Int): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getInputPortName is not implemented.")
  }

  /**
   * Override this method to define the default value for the specified input port. Prefer use this
   * over [VisualShaderNode.setInputPortDefaultValue].
   *
   * Defining this method is **required**. If not overridden, the node has no default values for
   * their input ports.
   */
  public open fun _getInputPortDefaultValue(port: Int): Any? {
    throw NotImplementedError("VisualShaderNodeCustom::_getInputPortDefaultValue is not implemented.")
  }

  /**
   * Override this method to define the input port which should be connected by default when this
   * node is created as a result of dragging a connection from an existing node to the empty space on
   * the graph.
   *
   * Defining this method is **optional**. If not overridden, the connection will be created to the
   * first valid port.
   */
  public open fun _getDefaultInputPort(type: VisualShaderNode.PortType): Int {
    throw NotImplementedError("VisualShaderNodeCustom::_getDefaultInputPort is not implemented.")
  }

  /**
   * Override this method to define the number of output ports of the associated custom node.
   *
   * Defining this method is **required**. If not overridden, the node has no output ports.
   */
  public open fun _getOutputPortCount(): Int {
    throw NotImplementedError("VisualShaderNodeCustom::_getOutputPortCount is not implemented.")
  }

  /**
   * Override this method to define the returned type of each output port of the associated custom
   * node.
   *
   * Defining this method is **optional**, but recommended. If not overridden, output ports will
   * return the [VisualShaderNode.PORT_TYPE_SCALAR] type.
   */
  public open fun _getOutputPortType(port: Int): VisualShaderNode.PortType {
    throw NotImplementedError("VisualShaderNodeCustom::_getOutputPortType is not implemented.")
  }

  /**
   * Override this method to define the names of output ports of the associated custom node. The
   * names are used both for the output slots in the editor and as identifiers in the shader code, and
   * are passed in the `output_vars` array in [_getCode].
   *
   * Defining this method is **optional**, but recommended. If not overridden, output ports are
   * named as `"out" + str(port)`.
   */
  public open fun _getOutputPortName(port: Int): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getOutputPortName is not implemented.")
  }

  /**
   * Override this method to define the number of the properties.
   *
   * Defining this method is **optional**.
   */
  public open fun _getPropertyCount(): Int {
    throw NotImplementedError("VisualShaderNodeCustom::_getPropertyCount is not implemented.")
  }

  /**
   * Override this method to define the names of the property of the associated custom node.
   *
   * Defining this method is **optional**.
   */
  public open fun _getPropertyName(index: Int): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getPropertyName is not implemented.")
  }

  /**
   * Override this method to define the default index of the property of the associated custom node.
   *
   * Defining this method is **optional**.
   */
  public open fun _getPropertyDefaultIndex(index: Int): Int {
    throw NotImplementedError("VisualShaderNodeCustom::_getPropertyDefaultIndex is not implemented.")
  }

  /**
   * Override this method to define the options inside the drop-down list property of the associated
   * custom node.
   *
   * Defining this method is **optional**.
   */
  public open fun _getPropertyOptions(index: Int): PackedStringArray {
    throw NotImplementedError("VisualShaderNodeCustom::_getPropertyOptions is not implemented.")
  }

  /**
   * Override this method to define the actual shader code of the associated custom node. The shader
   * code should be returned as a string, which can have multiple lines (the `"""` multiline string
   * construct can be used for convenience).
   *
   * The [inputVars] and [outputVars] arrays contain the string names of the various input and
   * output variables, as defined by `_get_input_*` and `_get_output_*` virtual methods in this class.
   *
   * The output ports can be assigned values in the shader code. For example, `return
   * output_vars[0] + " = " + input_vars[0] + ";"`.
   *
   * You can customize the generated code based on the shader [mode] and/or [type].
   *
   * Defining this method is **required**.
   */
  public open fun _getCode(
    inputVars: VariantArray<String>,
    outputVars: VariantArray<String>,
    mode: Shader.Mode,
    type: VisualShader.Type,
  ): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getCode is not implemented.")
  }

  /**
   * Override this method to add a shader code to the beginning of each shader function (once). The
   * shader code should be returned as a string, which can have multiple lines (the `"""` multiline
   * string construct can be used for convenience).
   *
   * If there are multiple custom nodes of different types which use this feature the order of each
   * insertion is undefined.
   *
   * You can customize the generated code based on the shader [mode] and/or [type].
   *
   * Defining this method is **optional**.
   */
  public open fun _getFuncCode(mode: Shader.Mode, type: VisualShader.Type): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getFuncCode is not implemented.")
  }

  /**
   * Override this method to add shader code on top of the global shader, to define your own
   * standard library of reusable methods, varyings, constants, uniforms, etc. The shader code should
   * be returned as a string, which can have multiple lines (the `"""` multiline string construct can
   * be used for convenience).
   *
   * Be careful with this functionality as it can cause name conflicts with other custom nodes, so
   * be sure to give the defined entities unique names.
   *
   * You can customize the generated code based on the shader [mode].
   *
   * Defining this method is **optional**.
   */
  public open fun _getGlobalCode(mode: Shader.Mode): String {
    throw NotImplementedError("VisualShaderNodeCustom::_getGlobalCode is not implemented.")
  }

  /**
   * Override this method to enable the high-end mark in the Visual Shader Editor's members dialog.
   * This should return `true` for nodes that only work when using the Forward+ and Mobile renderers.
   *
   * Defining this method is **optional**. If not overridden, it's `false`, which indicates this
   * node works with all renderers (including Compatibility).
   */
  public open fun _isHighend(): Boolean {
    throw NotImplementedError("VisualShaderNodeCustom::_isHighend is not implemented.")
  }

  /**
   * Override this method to prevent the node to be visible in the member dialog for the certain
   * [mode] and/or [type].
   *
   * Defining this method is **optional**. If not overridden, it's `true`.
   */
  public open fun _isAvailable(mode: Shader.Mode, type: VisualShader.Type): Boolean {
    throw NotImplementedError("VisualShaderNodeCustom::_isAvailable is not implemented.")
  }

  /**
   * Returns the selected index of the drop-down list option within a graph. You may use this
   * function to define the specific behavior in the [_getCode] or [_getGlobalCode].
   */
  public final fun getOptionIndex(option: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, option.toLong())
    TransferContext.callMethod(MethodBindings.getOptionIndexPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val getOptionIndexName: MethodStringName1<VisualShaderNodeCustom, Int, Int> =
        MethodStringName1<VisualShaderNodeCustom, Int, Int>("get_option_index")
  }

  public object MethodBindings {
    internal val getOptionIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeCustom", "get_option_index", 923996154)
  }
}
