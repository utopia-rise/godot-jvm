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
public abstract class PacketPeerExtension : PacketPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(504, scriptPtr)
  }

  public abstract fun _getAvailablePacketCount(): Int

  public abstract fun _getMaxPacketSize(): Int

  public companion object

  public object MethodBindings
}

internal class PacketPeerExtensionDummy : PacketPeerExtension() {
  public override fun _getAvailablePacketCount(): Int {
    throw NotImplementedError("PacketPeerExtension::_getAvailablePacketCount is only implemented by non-JVM code.")
  }

  public override fun _getMaxPacketSize(): Int {
    throw NotImplementedError("PacketPeerExtension::_getMaxPacketSize is only implemented by non-JVM code.")
  }
}
