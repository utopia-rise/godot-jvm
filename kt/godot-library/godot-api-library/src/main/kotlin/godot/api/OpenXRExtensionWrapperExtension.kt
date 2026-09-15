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
 * [OpenXRExtensionWrapperExtension] allows implementing OpenXR extensions with GDExtension. The
 * extension should be registered with [OpenXRExtensionWrapper.registerExtensionWrapper].
 */
@GodotBaseType
public open class OpenXRExtensionWrapperExtension : OpenXRExtensionWrapper() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(451, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
