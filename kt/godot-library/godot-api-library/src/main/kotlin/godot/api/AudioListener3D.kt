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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Transform3D
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_TRANSFORM3D
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Once added to the scene tree and enabled using [makeCurrent], this node will override the
 * location sounds are heard from. This can be used to listen from a location different from the
 * [Camera3D].
 */
@GodotBaseType
public open class AudioListener3D : Node3D() {
  /**
   * If not [DOPPLER_TRACKING_DISABLED], this listener will simulate the
   * [url=https://en.wikipedia.org/wiki/Doppler_effect]Doppler effect[/url] for objects changed in
   * particular `_process` methods.
   *
   * **Note:** The Doppler effect will only be heard on [AudioStreamPlayer3D]s if
   * [AudioStreamPlayer3D.dopplerTracking] is not set to
   * [AudioStreamPlayer3D.DOPPLER_TRACKING_DISABLED].
   */
  public final inline var dopplerTracking: DopplerTracking
    @JvmName("dopplerTrackingProperty")
    get() = getDopplerTracking()
    @JvmName("dopplerTrackingProperty")
    set(`value`) {
      setDopplerTracking(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(77, scriptPtr)
  }

  /**
   * Enables the listener. This will override the current camera's listener.
   */
  public final fun makeCurrent(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.makeCurrentPtr, 0)
  }

  /**
   * Disables the listener to use the current camera's listener instead.
   */
  public final fun clearCurrent(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearCurrentPtr, 0)
  }

  /**
   * Returns `true` if the listener was made current using [makeCurrent], `false` otherwise.
   *
   * **Note:** There may be more than one AudioListener3D marked as "current" in the scene tree, but
   * only the one that was made current last will be used.
   */
  public final fun isCurrent(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCurrentPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the listener's global orthonormalized [Transform3D].
   */
  public final fun getListenerTransform(): Transform3D {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getListenerTransformPtr, 18)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  public final fun setDopplerTracking(mode: DopplerTracking): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setDopplerTrackingPtr, 0)
  }

  public final fun getDopplerTracking(): DopplerTracking {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDopplerTrackingPtr, 2)
    return DopplerTracking.from(TransferContext.readReturnValue_LONG())
  }

  public enum class DopplerTracking(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables [url=https://en.wikipedia.org/wiki/Doppler_effect]Doppler effect[/url] simulation
     * (default).
     */
    DISABLED(0),
    /**
     * Simulate [url=https://en.wikipedia.org/wiki/Doppler_effect]Doppler effect[/url] by tracking
     * positions of objects that are changed in `_process`. Changes in the relative velocity of this
     * listener compared to those objects affect how audio is perceived (changing the audio's
     * [AudioStreamPlayer3D.pitchScale]).
     */
    IDLE_STEP(1),
    /**
     * Simulate [url=https://en.wikipedia.org/wiki/Doppler_effect]Doppler effect[/url] by tracking
     * positions of objects that are changed in `_physics_process`. Changes in the relative velocity of
     * this listener compared to those objects affect how audio is perceived (changing the audio's
     * [AudioStreamPlayer3D.pitchScale]).
     */
    PHYSICS_STEP(2),
    ;

    public companion object {
      public fun from(`value`: Long): DopplerTracking = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val makeCurrentName: MethodStringName0<AudioListener3D, Unit> =
        MethodStringName0<AudioListener3D, Unit>("make_current")

    @JvmField
    public val clearCurrentName: MethodStringName0<AudioListener3D, Unit> =
        MethodStringName0<AudioListener3D, Unit>("clear_current")

    @JvmField
    public val isCurrentName: MethodStringName0<AudioListener3D, Boolean> =
        MethodStringName0<AudioListener3D, Boolean>("is_current")

    @JvmField
    public val getListenerTransformName: MethodStringName0<AudioListener3D, Transform3D> =
        MethodStringName0<AudioListener3D, Transform3D>("get_listener_transform")

    @JvmField
    public val setDopplerTrackingName: MethodStringName1<AudioListener3D, Unit, DopplerTracking> =
        MethodStringName1<AudioListener3D, Unit, DopplerTracking>("set_doppler_tracking")

    @JvmField
    public val getDopplerTrackingName: MethodStringName0<AudioListener3D, DopplerTracking> =
        MethodStringName0<AudioListener3D, DopplerTracking>("get_doppler_tracking")
  }

  public object MethodBindings {
    internal val makeCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener3D", "make_current", 3218959716)

    internal val clearCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener3D", "clear_current", 3218959716)

    internal val isCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener3D", "is_current", 36873697)

    internal val getListenerTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener3D", "get_listener_transform", 3229777777)

    internal val setDopplerTrackingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener3D", "set_doppler_tracking", 2365921740)

    internal val getDopplerTrackingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioListener3D", "get_doppler_tracking", 550229039)
  }
}
