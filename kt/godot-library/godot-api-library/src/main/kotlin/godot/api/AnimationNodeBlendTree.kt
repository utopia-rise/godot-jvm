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
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_OBJECT
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_LONG
import godot.writeMethodArguments_STRING_NAME_LONG_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_OBJECT_VECTOR2
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_VECTOR2
import godot.writeMethodArguments_VECTOR2
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This animation node may contain a sub-tree of any other type animation nodes, such as
 * [AnimationNodeTransition], [AnimationNodeBlend2], [AnimationNodeBlend3], [AnimationNodeOneShot],
 * etc. This is one of the most commonly used animation node roots.
 *
 * An [AnimationNodeOutput] node named `output` is created by default.
 */
@GodotBaseType
public open class AnimationNodeBlendTree : AnimationRootNode() {
  /**
   * Emitted when the input port information is changed.
   */
  public val nodeChanged: Signal1<StringName> by Signal1

  /**
   * The global offset of all sub animation nodes.
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
    createNativeObject(23, scriptPtr)
  }

  /**
   * This is a helper function for [graphOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = animationnodeblendtree.graphOffset
   * //Your changes
   * animationnodeblendtree.graphOffset = myCoreType
   * ``````
   *
   * The global offset of all sub animation nodes.
   */
  @CoreTypeHelper
  public final fun graphOffsetMutate(block: Vector2.() -> Unit): Vector2 = graphOffset.apply {
     block(this)
     graphOffset = this
  }

  /**
   * Adds an [AnimationNode] at the given [position]. The [name] is used to identify the created sub
   * animation node later.
   */
  @JvmOverloads
  public final fun addNode(
    name: StringName,
    node: AnimationNode?,
    position: Vector2 = Vector2(0, 0),
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_OBJECT_VECTOR2(ptr, objectID.id, name, node, position)
    TransferContext.callPtrMethod(MethodBindings.addNodePtr, 0)
  }

  /**
   * Returns the sub animation node with the specified [name].
   */
  public final fun getNode(name: StringName): AnimationNode? {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.getNodePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as AnimationNode?)
  }

  /**
   * Removes a sub animation node.
   */
  public final fun removeNode(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.removeNodePtr, 0)
  }

  /**
   * Changes the name of a sub animation node.
   */
  public final fun renameNode(name: StringName, newName: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, newName)
    TransferContext.callPtrMethod(MethodBindings.renameNodePtr, 0)
  }

  /**
   * Returns `true` if a sub animation node with specified [name] exists.
   */
  public final fun hasNode(name: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.hasNodePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Connects the output of an [AnimationNode] as input for another [AnimationNode], at the input
   * port specified by [inputIndex].
   */
  public final fun connectNode(
    inputNode: StringName,
    inputIndex: Int,
    outputNode: StringName,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_LONG_STRING_NAME(ptr, objectID.id, inputNode, inputIndex.toLong(), outputNode)
    TransferContext.callPtrMethod(MethodBindings.connectNodePtr, 0)
  }

  /**
   * Disconnects the animation node connected to the specified input.
   */
  public final fun disconnectNode(inputNode: StringName, inputIndex: Int): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_LONG(ptr, objectID.id, inputNode, inputIndex.toLong())
    TransferContext.callPtrMethod(MethodBindings.disconnectNodePtr, 0)
  }

  /**
   * Returns a list containing the names of all sub animation nodes in this blend tree.
   */
  public final fun getNodeList(): VariantArray<StringName> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNodeListPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<StringName>)
  }

  /**
   * Modifies the position of a sub animation node.
   */
  public final fun setNodePosition(name: StringName, position: Vector2): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_VECTOR2(ptr, objectID.id, name, position)
    TransferContext.callPtrMethod(MethodBindings.setNodePositionPtr, 0)
  }

  /**
   * Returns the position of the sub animation node with the specified [name].
   */
  public final fun getNodePosition(name: StringName): Vector2 {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.getNodePositionPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  public final fun setGraphOffset(offset: Vector2): Unit {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, offset)
    TransferContext.callPtrMethod(MethodBindings.setGraphOffsetPtr, 0)
  }

  public final fun getGraphOffset(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGraphOffsetPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Adds an [AnimationNode] at the given [position]. The [name] is used to identify the created sub
   * animation node later.
   */
  @JvmOverloads
  public final fun addNode(
    name: String,
    node: AnimationNode?,
    position: Vector2 = Vector2(0, 0),
  ) = addNode(name.asCachedStringName(), node, position)

  /**
   * Returns the sub animation node with the specified [name].
   */
  public final fun getNode(name: String): AnimationNode? = getNode(name.asCachedStringName())

  /**
   * Removes a sub animation node.
   */
  public final fun removeNode(name: String) = removeNode(name.asCachedStringName())

  /**
   * Changes the name of a sub animation node.
   */
  public final fun renameNode(name: String, newName: String) =
      renameNode(name.asCachedStringName(), newName.asCachedStringName())

  /**
   * Returns `true` if a sub animation node with specified [name] exists.
   */
  public final fun hasNode(name: String): Boolean = hasNode(name.asCachedStringName())

  /**
   * Connects the output of an [AnimationNode] as input for another [AnimationNode], at the input
   * port specified by [inputIndex].
   */
  public final fun connectNode(
    inputNode: String,
    inputIndex: Int,
    outputNode: String,
  ) = connectNode(inputNode.asCachedStringName(), inputIndex, outputNode.asCachedStringName())

  /**
   * Disconnects the animation node connected to the specified input.
   */
  public final fun disconnectNode(inputNode: String, inputIndex: Int) =
      disconnectNode(inputNode.asCachedStringName(), inputIndex)

  /**
   * Modifies the position of a sub animation node.
   */
  public final fun setNodePosition(name: String, position: Vector2) =
      setNodePosition(name.asCachedStringName(), position)

  /**
   * Returns the position of the sub animation node with the specified [name].
   */
  public final fun getNodePosition(name: String): Vector2 =
      getNodePosition(name.asCachedStringName())

  public companion object {
    @JvmField
    public val addNodeName:
        MethodStringName3<AnimationNodeBlendTree, Unit, StringName, AnimationNode?, Vector2> =
        MethodStringName3<AnimationNodeBlendTree, Unit, StringName, AnimationNode?, Vector2>("add_node")

    @JvmField
    public val getNodeName: MethodStringName1<AnimationNodeBlendTree, AnimationNode?, StringName> =
        MethodStringName1<AnimationNodeBlendTree, AnimationNode?, StringName>("get_node")

    @JvmField
    public val removeNodeName: MethodStringName1<AnimationNodeBlendTree, Unit, StringName> =
        MethodStringName1<AnimationNodeBlendTree, Unit, StringName>("remove_node")

    @JvmField
    public val renameNodeName:
        MethodStringName2<AnimationNodeBlendTree, Unit, StringName, StringName> =
        MethodStringName2<AnimationNodeBlendTree, Unit, StringName, StringName>("rename_node")

    @JvmField
    public val hasNodeName: MethodStringName1<AnimationNodeBlendTree, Boolean, StringName> =
        MethodStringName1<AnimationNodeBlendTree, Boolean, StringName>("has_node")

    @JvmField
    public val connectNodeName:
        MethodStringName3<AnimationNodeBlendTree, Unit, StringName, Int, StringName> =
        MethodStringName3<AnimationNodeBlendTree, Unit, StringName, Int, StringName>("connect_node")

    @JvmField
    public val disconnectNodeName: MethodStringName2<AnimationNodeBlendTree, Unit, StringName, Int>
        = MethodStringName2<AnimationNodeBlendTree, Unit, StringName, Int>("disconnect_node")

    @JvmField
    public val getNodeListName: MethodStringName0<AnimationNodeBlendTree, VariantArray<StringName>>
        = MethodStringName0<AnimationNodeBlendTree, VariantArray<StringName>>("get_node_list")

    @JvmField
    public val setNodePositionName:
        MethodStringName2<AnimationNodeBlendTree, Unit, StringName, Vector2> =
        MethodStringName2<AnimationNodeBlendTree, Unit, StringName, Vector2>("set_node_position")

    @JvmField
    public val getNodePositionName: MethodStringName1<AnimationNodeBlendTree, Vector2, StringName> =
        MethodStringName1<AnimationNodeBlendTree, Vector2, StringName>("get_node_position")

    @JvmField
    public val setGraphOffsetName: MethodStringName1<AnimationNodeBlendTree, Unit, Vector2> =
        MethodStringName1<AnimationNodeBlendTree, Unit, Vector2>("set_graph_offset")

    @JvmField
    public val getGraphOffsetName: MethodStringName0<AnimationNodeBlendTree, Vector2> =
        MethodStringName0<AnimationNodeBlendTree, Vector2>("get_graph_offset")

    /**
     * The connection was successful.
     */
    public final const val CONNECTION_OK: Long = 0

    /**
     * The input node is `null`.
     */
    public final const val CONNECTION_ERROR_NO_INPUT: Long = 1

    /**
     * The specified input port is out of range.
     */
    public final const val CONNECTION_ERROR_NO_INPUT_INDEX: Long = 2

    /**
     * The output node is `null`.
     */
    public final const val CONNECTION_ERROR_NO_OUTPUT: Long = 3

    /**
     * Input and output nodes are the same.
     */
    public final const val CONNECTION_ERROR_SAME_NODE: Long = 4

    /**
     * The specified connection already exists.
     */
    public final const val CONNECTION_ERROR_CONNECTION_EXISTS: Long = 5
  }

  public object MethodBindings {
    internal val addNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "add_node", 1980270704)

    internal val getNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "get_node", 625644256)

    internal val removeNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "remove_node", 3304788590)

    internal val renameNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "rename_node", 3740211285)

    internal val hasNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "has_node", 2619796661)

    internal val connectNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "connect_node", 2168001410)

    internal val disconnectNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "disconnect_node", 2415702435)

    internal val getNodeListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "get_node_list", 3995934104)

    internal val setNodePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "set_node_position", 1999414630)

    internal val getNodePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "get_node_position", 3100822709)

    internal val setGraphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "set_graph_offset", 743155724)

    internal val getGraphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeBlendTree", "get_graph_offset", 3341600327)
  }
}
