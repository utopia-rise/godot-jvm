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
import godot.core.Signal0
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A one-shot timer managed by the scene tree, which emits [signal timeout] on completion. See also
 * [SceneTree.createTimer].
 *
 * As opposed to [Timer], it does not require the instantiation of a node. Commonly used to create a
 * one-shot delay timer as in the following example:
 *
 * ```gdscript
 * //gdscript
 * func some_function():
 * 	print("Timer started.")
 * 	await get_tree().create_timer(1.0).timeout
 * 	print("Timer ended.")
 * ```
 *
 * ```csharp
 * //csharp
 * public async Task SomeFunction()
 * {
 * 	GD.Print("Timer started.");
 * 	await ToSignal(GetTree().CreateTimer(1.0f), SceneTreeTimer.SignalName.Timeout);
 * 	GD.Print("Timer ended.");
 * }
 * ```
 *
 * The timer will be dereferenced after its time elapses. To preserve the timer, you can keep a
 * reference to it. See [RefCounted].
 *
 * **Note:** The timer is processed after all of the nodes in the current frame, i.e. node's
 * [Node.Process] method would be called before the timer (or [Node.PhysicsProcess] if
 * `process_in_physics` in [SceneTree.createTimer] has been set to `true`).
 */
@GodotBaseType
public open class SceneTreeTimer internal constructor() : RefCounted() {
  /**
   * Emitted when the timer reaches 0.
   */
  public val timeout: Signal0 by Signal0

  /**
   * The time remaining (in seconds).
   */
  public final inline var timeLeft: Double
    @JvmName("timeLeftProperty")
    get() = getTimeLeft()
    @JvmName("timeLeftProperty")
    set(`value`) {
      setTimeLeft(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(641, scriptPtr)
  }

  public final fun setTimeLeft(time: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, time)
    TransferContext.callPtrMethod(MethodBindings.setTimeLeftPtr, 0)
  }

  public final fun getTimeLeft(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTimeLeftPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public companion object {
    @JvmField
    public val setTimeLeftName: MethodStringName1<SceneTreeTimer, Unit, Double> =
        MethodStringName1<SceneTreeTimer, Unit, Double>("set_time_left")

    @JvmField
    public val getTimeLeftName: MethodStringName0<SceneTreeTimer, Double> =
        MethodStringName0<SceneTreeTimer, Double>("get_time_left")
  }

  public object MethodBindings {
    internal val setTimeLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTreeTimer", "set_time_left", 373806689)

    internal val getTimeLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneTreeTimer", "get_time_left", 1740695150)
  }
}
