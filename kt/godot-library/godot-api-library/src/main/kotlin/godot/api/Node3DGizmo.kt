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
 * This abstract class helps connect the [Node3D] scene with the editor-specific [EditorNode3DGizmo]
 * class.
 *
 * [Node3DGizmo] by itself has no exposed API, refer to [Node3D.addGizmo] and pass it an
 * [EditorNode3DGizmo] instance.
 */
@GodotBaseType
public open class Node3DGizmo internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(422, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
