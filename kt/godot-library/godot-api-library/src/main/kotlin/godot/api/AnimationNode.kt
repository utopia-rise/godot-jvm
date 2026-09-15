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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName7
import godot.core.MethodStringName8
import godot.core.MethodStringName9
import godot.core.NodePath
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal2
import godot.core.Signal3
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Base resource for [AnimationTree] nodes. In general, it's not used directly, but you can create
 * custom ones with custom blending formulas.
 *
 * Inherit this when creating animation nodes mainly for use in [AnimationNodeBlendTree], otherwise
 * [AnimationRootNode] should be used instead.
 *
 * You can access the time information as read-only parameter which is processed and stored in the
 * previous frame for all nodes except [AnimationNodeOutput].
 *
 * **Note:** If multiple inputs exist in the [AnimationNode], which time information takes
 * precedence depends on the type of [AnimationNode].
 *
 * ```
 * var current_length = $AnimationTree["parameters/AnimationNodeName/current_length"]
 * var current_position = $AnimationTree["parameters/AnimationNodeName/current_position"]
 * var current_delta = $AnimationTree["parameters/AnimationNodeName/current_delta"]
 * ```
 */
@GodotBaseType
public open class AnimationNode : Resource() {
  /**
   * Emitted by nodes that inherit from this class and that have an internal tree when one of their
   * animation nodes changes. The animation nodes that emit this signal are
   * [AnimationNodeBlendSpace1D], [AnimationNodeBlendSpace2D], [AnimationNodeStateMachine],
   * [AnimationNodeBlendTree] and [AnimationNodeTransition].
   */
  public val treeChanged: Signal0 by Signal0

  /**
   * Emitted by [AnimationNodeAnimation] when its [AnimationNodeAnimation.animation] resource is
   * changed, or by [AnimationNodeBlendTree] when its connections change.
   */
  public val nodeUpdated: Signal1<Long> by Signal1

  /**
   * Emitted by nodes that inherit from this class and that have an internal tree when one of their
   * animation node names changes. The animation nodes that emit this signal are
   * [AnimationNodeBlendSpace1D], [AnimationNodeBlendSpace2D], [AnimationNodeStateMachine], and
   * [AnimationNodeBlendTree].
   */
  public val animationNodeRenamed: Signal3<Long, String, String> by Signal3

  /**
   * Emitted by nodes that inherit from this class and that have an internal tree when one of their
   * animation nodes removes. The animation nodes that emit this signal are
   * [AnimationNodeBlendSpace1D], [AnimationNodeBlendSpace2D], [AnimationNodeStateMachine], and
   * [AnimationNodeBlendTree].
   */
  public val animationNodeRemoved: Signal2<Long, String> by Signal2

  /**
   * If `true`, filtering is enabled.
   */
  public final inline var filterEnabled: Boolean
    @JvmName("filterEnabledProperty")
    get() = isFilterEnabled()
    @JvmName("filterEnabledProperty")
    set(`value`) {
      setFilterEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(15, scriptPtr)
  }

  /**
   * When inheriting from [AnimationRootNode], implement this virtual method to return all child
   * animation nodes in order as a `name: node` dictionary.
   */
  public open fun _getChildNodes(): Dictionary<Any?, Any?> {
    throw NotImplementedError("AnimationNode::_getChildNodes is not implemented.")
  }

  /**
   * When inheriting from [AnimationRootNode], implement this virtual method to return a list of the
   * properties on this animation node. Parameters are custom local memory used for your animation
   * nodes, given a resource can be reused in multiple trees. Format is similar to
   * [Object.getPropertyList].
   */
  public open fun _getParameterList(): VariantArray<Any?> {
    throw NotImplementedError("AnimationNode::_getParameterList is not implemented.")
  }

  /**
   * When inheriting from [AnimationRootNode], implement this virtual method to return a child
   * animation node by its [name].
   */
  public open fun _getChildByName(name: StringName): AnimationNode? {
    throw NotImplementedError("AnimationNode::_getChildByName is not implemented.")
  }

  /**
   * When inheriting from [AnimationRootNode], implement this virtual method to return the default
   * value of a [parameter]. Parameters are custom local memory used for your animation nodes, given a
   * resource can be reused in multiple trees.
   */
  public open fun _getParameterDefaultValue(parameter: StringName): Any? {
    throw NotImplementedError("AnimationNode::_getParameterDefaultValue is not implemented.")
  }

  /**
   * When inheriting from [AnimationRootNode], implement this virtual method to return whether the
   * [parameter] is read-only. Parameters are custom local memory used for your animation nodes, given
   * a resource can be reused in multiple trees.
   */
  public open fun _isParameterReadOnly(parameter: StringName): Boolean {
    throw NotImplementedError("AnimationNode::_isParameterReadOnly is not implemented.")
  }

  /**
   * When inheriting from [AnimationRootNode], implement this virtual method to run some code when
   * this animation node is processed. The [time] parameter is a relative delta, unless [seek] is
   * `true`, in which case it is absolute.
   *
   * Here, call the [blendInput], [blendNode] or [blendAnimation] functions. You can also use
   * [getParameter] and [setParameter] to modify local memory.
   *
   * This function should return the delta.
   */
  public open fun _process(
    time: Double,
    seek: Boolean,
    isExternalSeeking: Boolean,
    testOnly: Boolean,
  ): Double {
    throw NotImplementedError("AnimationNode::_process is not implemented.")
  }

  /**
   * When inheriting from [AnimationRootNode], implement this virtual method to override the text
   * caption for this animation node.
   */
  public open fun _getCaption(): String {
    throw NotImplementedError("AnimationNode::_getCaption is not implemented.")
  }

  /**
   * When inheriting from [AnimationRootNode], implement this virtual method to return whether the
   * blend tree editor should display filter editing on this animation node.
   */
  public open fun _hasFilter(): Boolean {
    throw NotImplementedError("AnimationNode::_hasFilter is not implemented.")
  }

  /**
   * Adds an input to the animation node. This is only useful for animation nodes created for use in
   * an [AnimationNodeBlendTree]. If the addition fails, returns `false`.
   */
  public final fun addInput(name: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.addInputPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes an input, call this only when inactive.
   */
  public final fun removeInput(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.removeInputPtr)
  }

  /**
   * Sets the name of the input at the given [input] index. If the setting fails, returns `false`.
   */
  public final fun setInputName(input: Int, name: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to input.toLong(), STRING to name)
    TransferContext.callMethod(MethodBindings.setInputNamePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Gets the name of an input by index.
   */
  public final fun getInputName(input: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to input.toLong())
    TransferContext.callMethod(MethodBindings.getInputNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Amount of inputs in this animation node, only useful for animation nodes that go into
   * [AnimationNodeBlendTree].
   */
  public final fun getInputCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInputCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the input index which corresponds to [name]. If not found, returns `-1`.
   */
  public final fun findInput(name: String): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.findInputPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds or removes a path for the filter.
   */
  public final fun setFilterPath(path: NodePath, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to path, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setFilterPathPtr)
  }

  /**
   * Returns `true` if the given path is filtered.
   */
  public final fun isPathFiltered(path: NodePath): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to path)
    TransferContext.callMethod(MethodBindings.isPathFilteredPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFilterEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setFilterEnabledPtr)
  }

  public final fun isFilterEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFilterEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the object id of the [AnimationTree] that owns this node.
   *
   * **Note:** This method should only be called from within the
   * [AnimationNodeExtension.ProcessAnimationNode] method, and will return an invalid id otherwise.
   */
  public final fun getProcessingAnimationTreeInstanceId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProcessingAnimationTreeInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if this animation node is being processed in test-only mode.
   */
  public final fun isProcessTesting(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isProcessTestingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Blends an animation by [blend] amount (name must be valid in the linked [AnimationPlayer]). A
   * [time] and [delta] may be passed, as well as whether [seeked] happened.
   *
   * A [loopedFlag] is used by internal processing immediately after the loop.
   */
  @JvmOverloads
  public final fun blendAnimation(
    animation: StringName,
    time: Double,
    delta: Double,
    seeked: Boolean,
    isExternalSeeking: Boolean,
    blend: Float,
    loopedFlag: Animation.LoopedFlag = Animation.LoopedFlag.NONE,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to animation, DOUBLE to time, DOUBLE to delta, BOOL to seeked, BOOL to isExternalSeeking, DOUBLE to blend.toDouble(), LONG to loopedFlag.value)
    TransferContext.callMethod(MethodBindings.blendAnimationPtr)
  }

  /**
   * Blend another animation node (in case this animation node contains child animation nodes). This
   * function is only useful if you inherit from [AnimationRootNode] instead, otherwise editors will
   * not display your animation node for addition.
   */
  @JvmOverloads
  public final fun blendNode(
    name: StringName,
    node: AnimationNode?,
    time: Double,
    seek: Boolean,
    isExternalSeeking: Boolean,
    blend: Float,
    filter: FilterAction = AnimationNode.FilterAction.IGNORE,
    sync: Boolean = true,
    testOnly: Boolean = false,
  ): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to node, DOUBLE to time, BOOL to seek, BOOL to isExternalSeeking, DOUBLE to blend.toDouble(), LONG to filter.value, BOOL to sync, BOOL to testOnly)
    TransferContext.callMethod(MethodBindings.blendNodePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Blends an input. This is only useful for animation nodes created for an
   * [AnimationNodeBlendTree]. The [time] parameter is a relative delta, unless [seek] is `true`, in
   * which case it is absolute. A filter mode may be optionally passed.
   */
  @JvmOverloads
  public final fun blendInput(
    inputIndex: Int,
    time: Double,
    seek: Boolean,
    isExternalSeeking: Boolean,
    blend: Float,
    filter: FilterAction = AnimationNode.FilterAction.IGNORE,
    sync: Boolean = true,
    testOnly: Boolean = false,
  ): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to inputIndex.toLong(), DOUBLE to time, BOOL to seek, BOOL to isExternalSeeking, DOUBLE to blend.toDouble(), LONG to filter.value, BOOL to sync, BOOL to testOnly)
    TransferContext.callMethod(MethodBindings.blendInputPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets a custom parameter. These are used as local memory, because resources can be reused across
   * the tree or scenes.
   */
  public final fun setParameter(name: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, ANY to value)
    TransferContext.callMethod(MethodBindings.setParameterPtr)
  }

  /**
   * Gets the value of a parameter. Parameters are custom local memory used for your animation
   * nodes, given a resource can be reused in multiple trees.
   */
  public final fun getParameter(name: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getParameterPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Adds or removes a path for the filter.
   */
  public final fun setFilterPath(path: String, enable: Boolean) =
      setFilterPath(path.asCachedNodePath(), enable)

  /**
   * Returns `true` if the given path is filtered.
   */
  public final fun isPathFiltered(path: String): Boolean = isPathFiltered(path.asCachedNodePath())

  /**
   * Blends an animation by [blend] amount (name must be valid in the linked [AnimationPlayer]). A
   * [time] and [delta] may be passed, as well as whether [seeked] happened.
   *
   * A [loopedFlag] is used by internal processing immediately after the loop.
   */
  @JvmOverloads
  public final fun blendAnimation(
    animation: String,
    time: Double,
    delta: Double,
    seeked: Boolean,
    isExternalSeeking: Boolean,
    blend: Float,
    loopedFlag: Animation.LoopedFlag = Animation.LoopedFlag.NONE,
  ) =
      blendAnimation(animation.asCachedStringName(), time, delta, seeked, isExternalSeeking, blend, loopedFlag)

  /**
   * Blend another animation node (in case this animation node contains child animation nodes). This
   * function is only useful if you inherit from [AnimationRootNode] instead, otherwise editors will
   * not display your animation node for addition.
   */
  @JvmOverloads
  public final fun blendNode(
    name: String,
    node: AnimationNode?,
    time: Double,
    seek: Boolean,
    isExternalSeeking: Boolean,
    blend: Float,
    filter: FilterAction = AnimationNode.FilterAction.IGNORE,
    sync: Boolean = true,
    testOnly: Boolean = false,
  ): Double =
      blendNode(name.asCachedStringName(), node, time, seek, isExternalSeeking, blend, filter, sync, testOnly)

  /**
   * Sets a custom parameter. These are used as local memory, because resources can be reused across
   * the tree or scenes.
   */
  public final fun setParameter(name: String, `value`: Any?) =
      setParameter(name.asCachedStringName(), value)

  /**
   * Gets the value of a parameter. Parameters are custom local memory used for your animation
   * nodes, given a resource can be reused in multiple trees.
   */
  public final fun getParameter(name: String): Any? = getParameter(name.asCachedStringName())

  public enum class FilterAction(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not use filtering.
     */
    IGNORE(0),
    /**
     * Paths matching the filter will be allowed to pass.
     */
    PASS(1),
    /**
     * Paths matching the filter will be discarded.
     */
    STOP(2),
    /**
     * Paths matching the filter will be blended (by the blend value).
     */
    BLEND(3),
    ;

    public companion object {
      public fun from(`value`: Long): FilterAction = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addInputName: MethodStringName1<AnimationNode, Boolean, String> =
        MethodStringName1<AnimationNode, Boolean, String>("add_input")

    @JvmField
    public val removeInputName: MethodStringName1<AnimationNode, Unit, Int> =
        MethodStringName1<AnimationNode, Unit, Int>("remove_input")

    @JvmField
    public val setInputNameName: MethodStringName2<AnimationNode, Boolean, Int, String> =
        MethodStringName2<AnimationNode, Boolean, Int, String>("set_input_name")

    @JvmField
    public val getInputNameName: MethodStringName1<AnimationNode, String, Int> =
        MethodStringName1<AnimationNode, String, Int>("get_input_name")

    @JvmField
    public val getInputCountName: MethodStringName0<AnimationNode, Int> =
        MethodStringName0<AnimationNode, Int>("get_input_count")

    @JvmField
    public val findInputName: MethodStringName1<AnimationNode, Int, String> =
        MethodStringName1<AnimationNode, Int, String>("find_input")

    @JvmField
    public val setFilterPathName: MethodStringName2<AnimationNode, Unit, NodePath, Boolean> =
        MethodStringName2<AnimationNode, Unit, NodePath, Boolean>("set_filter_path")

    @JvmField
    public val isPathFilteredName: MethodStringName1<AnimationNode, Boolean, NodePath> =
        MethodStringName1<AnimationNode, Boolean, NodePath>("is_path_filtered")

    @JvmField
    public val setFilterEnabledName: MethodStringName1<AnimationNode, Unit, Boolean> =
        MethodStringName1<AnimationNode, Unit, Boolean>("set_filter_enabled")

    @JvmField
    public val isFilterEnabledName: MethodStringName0<AnimationNode, Boolean> =
        MethodStringName0<AnimationNode, Boolean>("is_filter_enabled")

    @JvmField
    public val getProcessingAnimationTreeInstanceIdName: MethodStringName0<AnimationNode, Long> =
        MethodStringName0<AnimationNode, Long>("get_processing_animation_tree_instance_id")

    @JvmField
    public val isProcessTestingName: MethodStringName0<AnimationNode, Boolean> =
        MethodStringName0<AnimationNode, Boolean>("is_process_testing")

    @JvmField
    public val blendAnimationName:
        MethodStringName7<AnimationNode, Unit, StringName, Double, Double, Boolean, Boolean, Float, Animation.LoopedFlag>
        =
        MethodStringName7<AnimationNode, Unit, StringName, Double, Double, Boolean, Boolean, Float, Animation.LoopedFlag>("blend_animation")

    @JvmField
    public val blendNodeName:
        MethodStringName9<AnimationNode, Double, StringName, AnimationNode?, Double, Boolean, Boolean, Float, FilterAction, Boolean, Boolean>
        =
        MethodStringName9<AnimationNode, Double, StringName, AnimationNode?, Double, Boolean, Boolean, Float, FilterAction, Boolean, Boolean>("blend_node")

    @JvmField
    public val blendInputName:
        MethodStringName8<AnimationNode, Double, Int, Double, Boolean, Boolean, Float, FilterAction, Boolean, Boolean>
        =
        MethodStringName8<AnimationNode, Double, Int, Double, Boolean, Boolean, Float, FilterAction, Boolean, Boolean>("blend_input")

    @JvmField
    public val setParameterName: MethodStringName2<AnimationNode, Unit, StringName, Any?> =
        MethodStringName2<AnimationNode, Unit, StringName, Any?>("set_parameter")

    @JvmField
    public val getParameterName: MethodStringName1<AnimationNode, Any?, StringName> =
        MethodStringName1<AnimationNode, Any?, StringName>("get_parameter")
  }

  public object MethodBindings {
    internal val addInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "add_input", 2323990056)

    internal val removeInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "remove_input", 1286410249)

    internal val setInputNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "set_input_name", 215573526)

    internal val getInputNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "get_input_name", 844755477)

    internal val getInputCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "get_input_count", 3905245786)

    internal val findInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "find_input", 1321353865)

    internal val setFilterPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "set_filter_path", 3868023870)

    internal val isPathFilteredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "is_path_filtered", 861721659)

    internal val setFilterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "set_filter_enabled", 2586408642)

    internal val isFilterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "is_filter_enabled", 36873697)

    internal val getProcessingAnimationTreeInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "get_processing_animation_tree_instance_id", 3905245786)

    internal val isProcessTestingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "is_process_testing", 36873697)

    internal val blendAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "blend_animation", 1630801826)

    internal val blendNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "blend_node", 1746075988)

    internal val blendInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "blend_input", 1361527350)

    internal val setParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "set_parameter", 3776071444)

    internal val getParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNode", "get_parameter", 2760726917)
  }
}
