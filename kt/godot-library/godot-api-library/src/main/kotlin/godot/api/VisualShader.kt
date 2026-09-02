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
import godot.core.Dictionary
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.PackedInt32Array
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This class provides a graph-like visual editor for creating a [Shader]. Although [VisualShader]s
 * do not require coding, they share the same logic with script shaders. They use [VisualShaderNode]s
 * that can be connected to each other to control the flow of the shader. The visual shader graph is
 * converted to a script shader behind the scenes.
 */
@GodotBaseType
public open class VisualShader : Shader() {
  /**
   * Deprecated.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var graphOffset: Vector2
    @JvmName("graphOffsetProperty")
    get() = getGraphOffset()
    @JvmName("graphOffsetProperty")
    set(`value`) {
      setGraphOffset(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(804, scriptPtr)
  }

  /**
   * This is a helper function for [graphOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = visualshader.graphOffset
   * //Your changes
   * visualshader.graphOffset = myCoreType
   * ``````
   *
   * Deprecated.
   */
  @CoreTypeHelper
  public final fun graphOffsetMutate(block: Vector2.() -> Unit): Vector2 = graphOffset.apply {
     block(this)
     graphOffset = this
  }

  /**
   * Sets the mode of this shader.
   */
  public final fun setMode(mode: Shader.Mode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setModePtr)
  }

  /**
   * Adds the specified [node] to the shader.
   */
  public final fun addNode(
    type: Type,
    node: VisualShaderNode?,
    position: Vector2,
    id: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, OBJECT to node, VECTOR2 to position, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.addNodePtr)
  }

  /**
   * Returns the shader node instance with specified [type] and [id].
   */
  public final fun getNode(type: Type, id: Int): VisualShaderNode? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getNodePtr)
    return (TransferContext.readReturnValue(OBJECT) as VisualShaderNode?)
  }

  /**
   * Sets the position of the specified node.
   */
  public final fun setNodePosition(
    type: Type,
    id: Int,
    position: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to id.toLong(), VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.setNodePositionPtr)
  }

  /**
   * Returns the position of the specified node within the shader graph.
   */
  public final fun getNodePosition(type: Type, id: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getNodePositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the list of all nodes in the shader with the specified type.
   */
  public final fun getNodeList(type: Type): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value)
    TransferContext.callMethod(MethodBindings.getNodeListPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns next valid node ID that can be added to the shader graph.
   */
  public final fun getValidNodeId(type: Type): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value)
    TransferContext.callMethod(MethodBindings.getValidNodeIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes the specified node from the shader.
   */
  public final fun removeNode(type: Type, id: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.removeNodePtr)
  }

  /**
   * Replaces the specified node with a node of new class type.
   */
  public final fun replaceNode(
    type: Type,
    id: Int,
    newClass: StringName,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to id.toLong(), STRING_NAME to newClass)
    TransferContext.callMethod(MethodBindings.replaceNodePtr)
  }

  /**
   * Returns `true` if the specified node and port connection exist.
   */
  public final fun isNodeConnection(
    type: Type,
    fromNode: Int,
    fromPort: Int,
    toNode: Int,
    toPort: Int,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to fromNode.toLong(), LONG to fromPort.toLong(), LONG to toNode.toLong(), LONG to toPort.toLong())
    TransferContext.callMethod(MethodBindings.isNodeConnectionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the specified nodes and ports can be connected together.
   */
  public final fun canConnectNodes(
    type: Type,
    fromNode: Int,
    fromPort: Int,
    toNode: Int,
    toPort: Int,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to fromNode.toLong(), LONG to fromPort.toLong(), LONG to toNode.toLong(), LONG to toPort.toLong())
    TransferContext.callMethod(MethodBindings.canConnectNodesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Connects the specified nodes and ports.
   */
  public final fun connectNodes(
    type: Type,
    fromNode: Int,
    fromPort: Int,
    toNode: Int,
    toPort: Int,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to fromNode.toLong(), LONG to fromPort.toLong(), LONG to toNode.toLong(), LONG to toPort.toLong())
    TransferContext.callMethod(MethodBindings.connectNodesPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Connects the specified nodes and ports.
   */
  public final fun disconnectNodes(
    type: Type,
    fromNode: Int,
    fromPort: Int,
    toNode: Int,
    toPort: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to fromNode.toLong(), LONG to fromPort.toLong(), LONG to toNode.toLong(), LONG to toPort.toLong())
    TransferContext.callMethod(MethodBindings.disconnectNodesPtr)
  }

  /**
   * Connects the specified nodes and ports, even if they can't be connected. Such connection is
   * invalid and will not function properly.
   */
  public final fun connectNodesForced(
    type: Type,
    fromNode: Int,
    fromPort: Int,
    toNode: Int,
    toPort: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to fromNode.toLong(), LONG to fromPort.toLong(), LONG to toNode.toLong(), LONG to toPort.toLong())
    TransferContext.callMethod(MethodBindings.connectNodesForcedPtr)
  }

  /**
   * Returns the list of connected nodes with the specified type.
   */
  public final fun getNodeConnections(type: Type): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value)
    TransferContext.callMethod(MethodBindings.getNodeConnectionsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Attaches the given node to the given frame.
   */
  public final fun attachNodeToFrame(
    type: Type,
    id: Int,
    frame: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to id.toLong(), LONG to frame.toLong())
    TransferContext.callMethod(MethodBindings.attachNodeToFramePtr)
  }

  /**
   * Detaches the given node from the frame it is attached to.
   */
  public final fun detachNodeFromFrame(type: Type, id: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.detachNodeFromFramePtr)
  }

  /**
   * Adds a new varying value node to the shader.
   */
  public final fun addVarying(
    name: String,
    mode: VaryingMode,
    type: VaryingType,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name, LONG to mode.value, LONG to type.value)
    TransferContext.callMethod(MethodBindings.addVaryingPtr)
  }

  /**
   * Removes a varying value node with the given [name]. Prints an error if a node with this name is
   * not found.
   */
  public final fun removeVarying(name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.removeVaryingPtr)
  }

  /**
   * Returns `true` if the shader has a varying with the given [name].
   */
  public final fun hasVarying(name: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.hasVaryingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setGraphOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.setGraphOffsetPtr)
  }

  public final fun getGraphOffset(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGraphOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Replaces the specified node with a node of new class type.
   */
  public final fun replaceNode(
    type: Type,
    id: Int,
    newClass: String,
  ) = replaceNode(type, id, newClass.asCachedStringName())

  public enum class Type(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A vertex shader, operating on vertices.
     */
    VERTEX(0),
    /**
     * A fragment shader, operating on fragments (pixels).
     */
    FRAGMENT(1),
    /**
     * A shader for light calculations.
     */
    LIGHT(2),
    /**
     * A function for the "start" stage of particle shader.
     */
    START(3),
    /**
     * A function for the "process" stage of particle shader.
     */
    PROCESS(4),
    /**
     * A function for the "collide" stage (particle collision handler) of particle shader.
     */
    COLLIDE(5),
    /**
     * A function for the "start" stage of particle shader, with customized output.
     */
    START_CUSTOM(6),
    /**
     * A function for the "process" stage of particle shader, with customized output.
     */
    PROCESS_CUSTOM(7),
    /**
     * A shader for 3D environment's sky.
     */
    SKY(8),
    /**
     * A compute shader that runs for each froxel of the volumetric fog map.
     */
    FOG(9),
    /**
     * A shader used to process blit calls to a DrawableTexture.
     */
    TEXTURE_BLIT(10),
    /**
     * Represents the size of the [Type] enum.
     */
    MAX(11),
    ;

    public companion object {
      public fun from(`value`: Long): Type = entries.single { it.`value` == `value` }
    }
  }

  public enum class VaryingMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Varying is passed from `Vertex` function to `Fragment` and `Light` functions.
     */
    VERTEX_TO_FRAG_LIGHT(0),
    /**
     * Varying is passed from `Fragment` function to `Light` function.
     */
    FRAG_TO_LIGHT(1),
    /**
     * Represents the size of the [VaryingMode] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): VaryingMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class VaryingType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Varying is of type [float].
     */
    FLOAT(0),
    /**
     * Varying is of type [int].
     */
    INT(1),
    /**
     * Varying is of type unsigned [int].
     */
    UINT(2),
    /**
     * Varying is of type [Vector2].
     */
    VECTOR_2D(3),
    /**
     * Varying is of type [Vector3].
     */
    VECTOR_3D(4),
    /**
     * Varying is of type [Vector4].
     */
    VECTOR_4D(5),
    /**
     * Varying is of type [bool].
     */
    BOOLEAN(6),
    /**
     * Varying is of type [Transform3D].
     */
    TRANSFORM(7),
    /**
     * Represents the size of the [VaryingType] enum.
     */
    MAX(8),
    ;

    public companion object {
      public fun from(`value`: Long): VaryingType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setModeName: MethodStringName1<VisualShader, Unit, Shader.Mode> =
        MethodStringName1<VisualShader, Unit, Shader.Mode>("set_mode")

    @JvmField
    public val addNodeName:
        MethodStringName4<VisualShader, Unit, Type, VisualShaderNode?, Vector2, Int> =
        MethodStringName4<VisualShader, Unit, Type, VisualShaderNode?, Vector2, Int>("add_node")

    @JvmField
    public val getNodeName: MethodStringName2<VisualShader, VisualShaderNode?, Type, Int> =
        MethodStringName2<VisualShader, VisualShaderNode?, Type, Int>("get_node")

    @JvmField
    public val setNodePositionName: MethodStringName3<VisualShader, Unit, Type, Int, Vector2> =
        MethodStringName3<VisualShader, Unit, Type, Int, Vector2>("set_node_position")

    @JvmField
    public val getNodePositionName: MethodStringName2<VisualShader, Vector2, Type, Int> =
        MethodStringName2<VisualShader, Vector2, Type, Int>("get_node_position")

    @JvmField
    public val getNodeListName: MethodStringName1<VisualShader, PackedInt32Array, Type> =
        MethodStringName1<VisualShader, PackedInt32Array, Type>("get_node_list")

    @JvmField
    public val getValidNodeIdName: MethodStringName1<VisualShader, Int, Type> =
        MethodStringName1<VisualShader, Int, Type>("get_valid_node_id")

    @JvmField
    public val removeNodeName: MethodStringName2<VisualShader, Unit, Type, Int> =
        MethodStringName2<VisualShader, Unit, Type, Int>("remove_node")

    @JvmField
    public val replaceNodeName: MethodStringName3<VisualShader, Unit, Type, Int, StringName> =
        MethodStringName3<VisualShader, Unit, Type, Int, StringName>("replace_node")

    @JvmField
    public val isNodeConnectionName:
        MethodStringName5<VisualShader, Boolean, Type, Int, Int, Int, Int> =
        MethodStringName5<VisualShader, Boolean, Type, Int, Int, Int, Int>("is_node_connection")

    @JvmField
    public val canConnectNodesName:
        MethodStringName5<VisualShader, Boolean, Type, Int, Int, Int, Int> =
        MethodStringName5<VisualShader, Boolean, Type, Int, Int, Int, Int>("can_connect_nodes")

    @JvmField
    public val connectNodesName: MethodStringName5<VisualShader, Error, Type, Int, Int, Int, Int> =
        MethodStringName5<VisualShader, Error, Type, Int, Int, Int, Int>("connect_nodes")

    @JvmField
    public val disconnectNodesName: MethodStringName5<VisualShader, Unit, Type, Int, Int, Int, Int>
        = MethodStringName5<VisualShader, Unit, Type, Int, Int, Int, Int>("disconnect_nodes")

    @JvmField
    public val connectNodesForcedName:
        MethodStringName5<VisualShader, Unit, Type, Int, Int, Int, Int> =
        MethodStringName5<VisualShader, Unit, Type, Int, Int, Int, Int>("connect_nodes_forced")

    @JvmField
    public val getNodeConnectionsName:
        MethodStringName1<VisualShader, VariantArray<Dictionary<Any?, Any?>>, Type> =
        MethodStringName1<VisualShader, VariantArray<Dictionary<Any?, Any?>>, Type>("get_node_connections")

    @JvmField
    public val attachNodeToFrameName: MethodStringName3<VisualShader, Unit, Type, Int, Int> =
        MethodStringName3<VisualShader, Unit, Type, Int, Int>("attach_node_to_frame")

    @JvmField
    public val detachNodeFromFrameName: MethodStringName2<VisualShader, Unit, Type, Int> =
        MethodStringName2<VisualShader, Unit, Type, Int>("detach_node_from_frame")

    @JvmField
    public val addVaryingName:
        MethodStringName3<VisualShader, Unit, String, VaryingMode, VaryingType> =
        MethodStringName3<VisualShader, Unit, String, VaryingMode, VaryingType>("add_varying")

    @JvmField
    public val removeVaryingName: MethodStringName1<VisualShader, Unit, String> =
        MethodStringName1<VisualShader, Unit, String>("remove_varying")

    @JvmField
    public val hasVaryingName: MethodStringName1<VisualShader, Boolean, String> =
        MethodStringName1<VisualShader, Boolean, String>("has_varying")

    @JvmField
    public val setGraphOffsetName: MethodStringName1<VisualShader, Unit, Vector2> =
        MethodStringName1<VisualShader, Unit, Vector2>("set_graph_offset")

    @JvmField
    public val getGraphOffsetName: MethodStringName0<VisualShader, Vector2> =
        MethodStringName0<VisualShader, Vector2>("get_graph_offset")

    /**
     * Indicates an invalid [VisualShader] node.
     */
    public final const val NODE_ID_INVALID: Long = -1

    /**
     * Indicates an output node of [VisualShader].
     */
    public final const val NODE_ID_OUTPUT: Long = 0
  }

  public object MethodBindings {
    internal val setModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "set_mode", 3978014962)

    internal val addNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "add_node", 1560769431)

    internal val getNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "get_node", 3784670312)

    internal val setNodePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "set_node_position", 2726660721)

    internal val getNodePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "get_node_position", 2175036082)

    internal val getNodeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "get_node_list", 2370592410)

    internal val getValidNodeIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "get_valid_node_id", 629467342)

    internal val removeNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "remove_node", 844050912)

    internal val replaceNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "replace_node", 3144735253)

    internal val isNodeConnectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "is_node_connection", 3922381898)

    internal val canConnectNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "can_connect_nodes", 3922381898)

    internal val connectNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "connect_nodes", 3081049573)

    internal val disconnectNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "disconnect_nodes", 2268060358)

    internal val connectNodesForcedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "connect_nodes_forced", 2268060358)

    internal val getNodeConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "get_node_connections", 1441964831)

    internal val attachNodeToFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "attach_node_to_frame", 2479945279)

    internal val detachNodeFromFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "detach_node_from_frame", 844050912)

    internal val addVaryingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "add_varying", 2084110726)

    internal val removeVaryingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "remove_varying", 83702148)

    internal val hasVaryingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "has_varying", 3927539163)

    internal val setGraphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "set_graph_offset", 743155724)

    internal val getGraphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShader", "get_graph_offset", 3341600327)
  }
}
