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
 * For complex arrangements of shapes, it is sometimes needed to add structure to your CSG nodes.
 * The CSGCombiner3D node allows you to create this structure. The node encapsulates the result of the
 * CSG operations of its children. In this way, it is possible to do operations on one set of shapes
 * that are children of one CSGCombiner3D node, and a set of separate operations on a second set of
 * shapes that are children of a second CSGCombiner3D node, and then do an operation that takes the two
 * end results as its input to create the final shape.
 *
 * **Note:** CSG nodes are intended to be used for level prototyping. Creating CSG nodes has a
 * significant CPU cost compared to creating a [MeshInstance3D] with a [PrimitiveMesh]. Moving a CSG
 * node within another CSG node also has a significant CPU cost, so it should be avoided during
 * gameplay.
 */
@GodotBaseType
public open class CSGCombiner3D : CSGShape3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(124, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
