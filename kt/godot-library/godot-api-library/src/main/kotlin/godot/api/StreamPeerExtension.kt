// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public abstract class StreamPeerExtension : StreamPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(709, scriptPtr)
  }

  public abstract fun _getAvailableBytes(): Int

  public companion object

  public object MethodBindings
}

@GodotBaseType
internal class StreamPeerExtensionDummy : StreamPeerExtension() {
  public override fun _getAvailableBytes(): Int {
    throw NotImplementedError("StreamPeerExtension::_getAvailableBytes is only implemented by non-JVM code.")
  }
}
