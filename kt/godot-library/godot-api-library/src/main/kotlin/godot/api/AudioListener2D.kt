// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.readReturnValue_BOOL
import godot.writeMethodArguments0
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Once added to the scene tree and enabled using [makeCurrent], this node will override the
 * location sounds are heard from. Only one [AudioListener2D] can be current. Using [makeCurrent] will
 * disable the previous [AudioListener2D].
 *
 * If there is no active [AudioListener2D] in the current [Viewport], center of the screen will be
 * used as a hearing point for the audio. [AudioListener2D] needs to be inside [SceneTree] to function.
 */
@GodotBaseType
public open class AudioListener2D : Node2D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(76, scriptPtr)
  }

  /**
   * Makes the [AudioListener2D] active, setting it as the hearing point for the sounds. If there is
   * already another active [AudioListener2D], it will be disabled.
   *
   * This method will have no effect if the [AudioListener2D] is not added to [SceneTree].
   */
  public final fun makeCurrent(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.makeCurrentPtr, 0)
  }

  /**
   * Disables the [AudioListener2D]. If it's not set as current, this method will have no effect.
   */
  public final fun clearCurrent(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearCurrentPtr, 0)
  }

  /**
   * Returns `true` if this [AudioListener2D] is currently active.
   */
  public final fun isCurrent(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCurrentPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val makeCurrentName: MethodStringName0<AudioListener2D, Unit> =
        MethodStringName0<AudioListener2D, Unit>("make_current")

    @JvmField
    public val clearCurrentName: MethodStringName0<AudioListener2D, Unit> =
        MethodStringName0<AudioListener2D, Unit>("clear_current")

    @JvmField
    public val isCurrentName: MethodStringName0<AudioListener2D, Boolean> =
        MethodStringName0<AudioListener2D, Boolean>("is_current")
  }

  public object MethodBindings {
    internal val makeCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener2D", "make_current", 3218959716)

    internal val clearCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener2D", "clear_current", 3218959716)

    internal val isCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener2D", "is_current", 36873697)
  }
}
