// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * GodotInstance represents a running Godot instance that is controlled from an outside codebase,
 * without a perpetual main loop. It is created by the C API `libgodot_create_godot_instance`. Only one
 * may be created per process.
 */
@GodotBaseType
public open class GodotInstance internal constructor() : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(273, scriptPtr)
  }

  /**
   * Finishes this instance's startup sequence. Returns `true` on success.
   */
  public final fun start(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.startPtr)

  /**
   * Returns `true` if this instance has been fully started.
   */
  public final fun isStarted(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isStartedPtr)

  /**
   * Runs a single iteration of the main loop. Returns `true` if the engine is attempting to quit.
   */
  public final fun iteration(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.iterationPtr)

  /**
   * Notifies the instance that it is now in focus.
   */
  public final fun focusIn(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.focusInPtr)
  }

  /**
   * Notifies the instance that it is now not in focus.
   */
  public final fun focusOut(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.focusOutPtr)
  }

  /**
   * Notifies the instance that it is going to be paused.
   */
  public final fun pause(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pausePtr)
  }

  /**
   * Notifies the instance that it is being resumed.
   */
  public final fun resume(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.resumePtr)
  }

  public companion object {
    @JvmField
    public val startName: MethodStringName0<GodotInstance, Boolean> =
        MethodStringName0<GodotInstance, Boolean>("start")

    @JvmField
    public val isStartedName: MethodStringName0<GodotInstance, Boolean> =
        MethodStringName0<GodotInstance, Boolean>("is_started")

    @JvmField
    public val iterationName: MethodStringName0<GodotInstance, Boolean> =
        MethodStringName0<GodotInstance, Boolean>("iteration")

    @JvmField
    public val focusInName: MethodStringName0<GodotInstance, Unit> =
        MethodStringName0<GodotInstance, Unit>("focus_in")

    @JvmField
    public val focusOutName: MethodStringName0<GodotInstance, Unit> =
        MethodStringName0<GodotInstance, Unit>("focus_out")

    @JvmField
    public val pauseName: MethodStringName0<GodotInstance, Unit> =
        MethodStringName0<GodotInstance, Unit>("pause")

    @JvmField
    public val resumeName: MethodStringName0<GodotInstance, Unit> =
        MethodStringName0<GodotInstance, Unit>("resume")
  }

  public object MethodBindings {
    internal val startPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GodotInstance", "start", 2240911060)

    internal val isStartedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GodotInstance", "is_started", 2240911060)

    internal val iterationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GodotInstance", "iteration", 2240911060)

    internal val focusInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GodotInstance", "focus_in", 3218959716)

    internal val focusOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GodotInstance", "focus_out", 3218959716)

    internal val pausePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GodotInstance", "pause", 3218959716)

    internal val resumePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GodotInstance", "resume", 3218959716)
  }
}
