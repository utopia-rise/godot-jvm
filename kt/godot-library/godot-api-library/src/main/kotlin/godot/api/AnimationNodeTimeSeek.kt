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
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This animation node can be used to cause a seek command to happen to any sub-children of the
 * animation graph. Use to play an [Animation] from the start or a certain playback position inside the
 * [AnimationNodeBlendTree].
 *
 * After setting the time and changing the animation playback, the time seek node automatically goes
 * into sleep mode on the next process frame by setting its `seek_request` value to `-1.0`.
 *
 * ```gdscript
 * //gdscript
 * # Play child animation from the start.
 * animation_tree.set("parameters/TimeSeek/seek_request", 0.0)
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/TimeSeek/seek_request"] = 0.0
 *
 * # Play child animation from 12 second timestamp.
 * animation_tree.set("parameters/TimeSeek/seek_request", 12.0)
 * # Alternative syntax (same result as above).
 * animation_tree["parameters/TimeSeek/seek_request"] = 12.0
 * ```
 *
 * ```csharp
 * //csharp
 * // Play child animation from the start.
 * animationTree.Set("parameters/TimeSeek/seek_request", 0.0);
 *
 * // Play child animation from 12 second timestamp.
 * animationTree.Set("parameters/TimeSeek/seek_request", 12.0);
 * ```
 */
@GodotBaseType
public open class AnimationNodeTimeSeek : AnimationNode() {
  /**
   * If `true`, some processes are executed to handle keys between seeks, such as calculating root
   * motion and finding the nearest discrete key.
   */
  public final inline var explicitElapse: Boolean
    @JvmName("explicitElapseProperty")
    get() = isExplicitElapse()
    @JvmName("explicitElapseProperty")
    set(`value`) {
      setExplicitElapse(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(33, scriptPtr)
  }

  public final fun setExplicitElapse(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setExplicitElapsePtr, 0)
  }

  public final fun isExplicitElapse(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isExplicitElapsePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setExplicitElapseName: MethodStringName1<AnimationNodeTimeSeek, Unit, Boolean> =
        MethodStringName1<AnimationNodeTimeSeek, Unit, Boolean>("set_explicit_elapse")

    @JvmField
    public val isExplicitElapseName: MethodStringName0<AnimationNodeTimeSeek, Boolean> =
        MethodStringName0<AnimationNodeTimeSeek, Boolean>("is_explicit_elapse")
  }

  public object MethodBindings {
    internal val setExplicitElapsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTimeSeek", "set_explicit_elapse", 2586408642)

    internal val isExplicitElapsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationNodeTimeSeek", "is_explicit_elapse", 36873697)
  }
}
