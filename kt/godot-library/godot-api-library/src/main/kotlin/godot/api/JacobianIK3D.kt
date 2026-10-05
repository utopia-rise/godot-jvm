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
 * [JacobianIK3D] calculates rotations for all joints simultaneously, producing natural and smooth
 * movement. It is particularly suited for biological animations.
 *
 * The resulting twist around the forward vector will always be kept from the previous pose.
 *
 * **Note:** It converges more slowly than other IK solvers, leading to gentler and less immediate
 * tracking of targets.
 */
@GodotBaseType
public open class JacobianIK3D : IterateIK3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(333, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
