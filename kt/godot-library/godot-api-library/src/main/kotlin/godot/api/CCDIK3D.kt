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
 * [CCDIK3D] is rotation based IK, enabling fast and effective tracking even with large joint
 * rotations. It's especially suitable for chains with limitations, providing smoother and more stable
 * target tracking compared to [FABRIK3D].
 *
 * The resulting twist around the forward vector will always be kept from the previous pose.
 *
 * **Note:** When the target is close to the root, it can cause unnatural movement, including joint
 * flips and oscillations.
 */
@GodotBaseType
public open class CCDIK3D : IterateIK3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(120, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
