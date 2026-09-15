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
 * A synchronization mutex (mutual exclusion). This is used to synchronize multiple [Thread]s, and
 * is equivalent to a binary [Semaphore]. It guarantees that only one thread can access a critical
 * section at a time.
 *
 * This is a reentrant mutex, meaning that it can be locked multiple times by one thread, provided
 * it also unlocks it as many times.
 *
 * **Warning:** To ensure proper cleanup without crashes or deadlocks, the following conditions must
 * be met:
 *
 * - When a [Mutex]'s reference count reaches zero and it is therefore destroyed, no threads
 * (including the one on which the destruction will happen) must have it locked.
 *
 * - When a [Thread]'s reference count reaches zero and it is therefore destroyed, it must not have
 * any mutex locked.
 */
@GodotBaseType
public open class Mutex : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(395, scriptPtr)
  }

  /**
   * Locks this [Mutex], blocks until it is unlocked by the current owner.
   *
   * **Note:** This function returns without blocking if the thread already has ownership of the
   * mutex.
   */
  public final fun lock(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.lockPtr)
  }

  /**
   * Tries locking this [Mutex], but does not block. Returns `true` on success, `false` otherwise.
   *
   * **Note:** This function returns `true` if the thread already has ownership of the mutex.
   */
  public final fun tryLock(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.tryLockPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Unlocks this [Mutex], leaving it to other threads.
   *
   * **Note:** If a thread called [lock] or [tryLock] multiple times while already having ownership
   * of the mutex, it must also call [unlock] the same number of times in order to unlock it correctly.
   *
   * **Warning:** Calling [unlock] more times than [lock] on a given thread, thus ending up trying
   * to unlock a non-locked mutex, is wrong and may causes crashes or deadlocks.
   */
  public final fun unlock(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.unlockPtr)
  }

  public companion object {
    @JvmField
    public val lockName: MethodStringName0<Mutex, Unit> = MethodStringName0<Mutex, Unit>("lock")

    @JvmField
    public val tryLockName: MethodStringName0<Mutex, Boolean> =
        MethodStringName0<Mutex, Boolean>("try_lock")

    @JvmField
    public val unlockName: MethodStringName0<Mutex, Unit> = MethodStringName0<Mutex, Unit>("unlock")
  }

  public object MethodBindings {
    internal val lockPtr: VoidPtr = TypeManager.getMethodBindPtr("Mutex", "lock", 3218959716)

    internal val tryLockPtr: VoidPtr = TypeManager.getMethodBindPtr("Mutex", "try_lock", 2240911060)

    internal val unlockPtr: VoidPtr = TypeManager.getMethodBindPtr("Mutex", "unlock", 3218959716)
  }
}
