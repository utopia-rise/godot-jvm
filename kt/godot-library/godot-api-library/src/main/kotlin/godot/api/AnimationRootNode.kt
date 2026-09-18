// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Suppress
import kotlin.Unit

/**
 * [AnimationRootNode] is a base class for [AnimationNode]s that hold a complete animation. A
 * complete animation refers to the output of an [AnimationNodeOutput] in an [AnimationNodeBlendTree]
 * or the output of another [AnimationRootNode]. Used for [AnimationTree.treeRoot] or in other
 * [AnimationRootNode]s.
 *
 * Examples of built-in root nodes include [AnimationNodeBlendTree] (allows blending nodes between
 * each other using various modes), [AnimationNodeStateMachine] (allows to configure blending and
 * transitions between nodes using a state machine pattern), [AnimationNodeBlendSpace2D] (allows linear
 * blending between **three** [AnimationNode]s), [AnimationNodeBlendSpace1D] (allows linear blending
 * only between **two** [AnimationNode]s).
 */
@GodotBaseType
public open class AnimationRootNode : AnimationNode() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(36, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
