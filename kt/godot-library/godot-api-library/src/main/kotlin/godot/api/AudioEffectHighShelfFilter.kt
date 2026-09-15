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
 * A "high-shelf" filter controls the gain of all frequencies above [AudioEffectFilter.cutoffHz].
 *
 * This filter can be used to increase or decrease clarity of a sound.
 */
@GodotBaseType
public open class AudioEffectHighShelfFilter : AudioEffectFilter() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(62, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
