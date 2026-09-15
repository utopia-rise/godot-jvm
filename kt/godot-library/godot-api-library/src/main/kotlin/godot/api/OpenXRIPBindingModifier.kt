// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.PackedByteArray
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

/**
 * Binding modifier that applies directly on an interaction profile.
 */
@GodotBaseType
public open class OpenXRIPBindingModifier : OpenXRBindingModifier() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(459, scriptPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getDescription(): String {
    throw NotImplementedError("OpenXRIPBindingModifier::_getDescription can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getIpModification(): PackedByteArray {
    throw NotImplementedError("OpenXRIPBindingModifier::_getIpModification can't be called from the JVM.")
  }

  public companion object

  public object MethodBindings
}
