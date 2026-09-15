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
 * Binding modifier base class. Subclasses implement various modifiers that alter how an OpenXR
 * runtime processes inputs.
 */
@GodotBaseType
public abstract class OpenXRBindingModifier : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(444, scriptPtr)
  }

  /**
   * Return the description of this class that is used for the title bar of the binding modifier
   * editor.
   */
  public abstract fun _getDescription(): String

  /**
   * Returns the data that is sent to OpenXR when submitting the suggested interacting bindings this
   * modifier is a part of.
   *
   * **Note:** This must be data compatible with an `XrBindingModificationBaseHeaderKHR` structure.
   */
  public abstract fun _getIpModification(): PackedByteArray

  public companion object

  public object MethodBindings
}

internal class OpenXRBindingModifierDummy : OpenXRBindingModifier() {
  public override fun _getDescription(): String {
    throw NotImplementedError("OpenXRBindingModifier::_getDescription is only implemented by non-JVM code.")
  }

  public override fun _getIpModification(): PackedByteArray {
    throw NotImplementedError("OpenXRBindingModifier::_getIpModification is only implemented by non-JVM code.")
  }
}
