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
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A synchronization semaphore that can be used to synchronize multiple [Thread]s. Initialized to
 * zero on creation. For a binary version, see [Mutex].
 *
 * **Warning:** Semaphores must be used carefully to avoid deadlocks.
 *
 * **Warning:** To guarantee that the operating system is able to perform proper cleanup (no
 * crashes, no deadlocks), these conditions must be met:
 *
 * - When a [Semaphore]'s reference count reaches zero and it is therefore destroyed, no threads
 * must be waiting on it.
 *
 * - When a [Thread]'s reference count reaches zero and it is therefore destroyed, it must not be
 * waiting on any semaphore.
 */
@GodotBaseType
public open class Semaphore : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(650, scriptPtr)
  }

  /**
   * Waits for the [Semaphore], if its value is zero, blocks until non-zero.
   */
  public final fun waitFor(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.waitPtr, 0)
  }

  /**
   * Like [wait], but won't block, so if the value is zero, fails immediately and returns `false`.
   * If non-zero, it returns `true` to report success.
   */
  public final fun tryWait(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.tryWaitPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Lowers the [Semaphore], allowing one thread in, or more if [count] is specified.
   */
  @JvmOverloads
  public final fun post(count: Int = 1): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, count.toLong())
    TransferContext.callPtrMethod(MethodBindings.postPtr, 0)
  }

  public companion object {
    @JvmField
    public val waitName: MethodStringName0<Semaphore, Unit> =
        MethodStringName0<Semaphore, Unit>("wait")

    @JvmField
    public val tryWaitName: MethodStringName0<Semaphore, Boolean> =
        MethodStringName0<Semaphore, Boolean>("try_wait")

    @JvmField
    public val postName: MethodStringName1<Semaphore, Unit, Int> =
        MethodStringName1<Semaphore, Unit, Int>("post")
  }

  public object MethodBindings {
    internal val waitPtr: VoidPtr = TypeManager.getMethodBindPtr("Semaphore", "wait", 3218959716)

    internal val tryWaitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Semaphore", "try_wait", 2240911060)

    internal val postPtr: VoidPtr = TypeManager.getMethodBindPtr("Semaphore", "post", 1667783136)
  }
}
