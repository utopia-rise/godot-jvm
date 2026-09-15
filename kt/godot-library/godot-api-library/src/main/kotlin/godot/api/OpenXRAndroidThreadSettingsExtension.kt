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
import godot.core.MethodStringName2
import godot.readReturnValue_BOOL
import godot.writeMethodArguments_LONG_LONG
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * For XR to be comfortable, it is important for applications to deliver frames quickly and
 * consistently. In order to make sure the important application threads get their full share of time,
 * these threads must be identified to the system, which will adjust their scheduling priority
 * accordingly.
 */
@GodotBaseType
public open class OpenXRAndroidThreadSettingsExtension : OpenXRExtensionWrapper() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(443, scriptPtr)
  }

  /**
   * Sets the thread type of the given thread, so that the XR runtime can adjust its scheduling
   * priority accordingly.
   *
   * [threadId] refers to the OS thread id (ie from `gettid()`). When [threadId] is `0`, it will set
   * the thread type of the current thread.
   *
   * **NOTE:** The id returned by [Thread.getId] is incompatible with [threadId].
   */
  @JvmOverloads
  public final fun setApplicationThreadType(threadType: ThreadType, threadId: Long = 0): Boolean {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, threadType.value, threadId)
    TransferContext.callMethod(MethodBindings.setApplicationThreadTypePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class ThreadType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Hints to the XR runtime that the thread is doing time critical CPU tasks.
     */
    APPLICATION_MAIN(0),
    /**
     * Hints to the XR runtime that the thread is doing background CPU tasks.
     */
    APPLICATION_WORKER(1),
    /**
     * Hints to the XR runtime that the thread is doing time critical graphics device tasks.
     */
    RENDERER_MAIN(2),
    /**
     * Hints to the XR runtime that the thread is doing background graphics device tasks.
     */
    RENDERER_WORKER(3),
    ;

    public companion object {
      public fun from(`value`: Long): ThreadType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setApplicationThreadTypeName:
        MethodStringName2<OpenXRAndroidThreadSettingsExtension, Boolean, ThreadType, Long> =
        MethodStringName2<OpenXRAndroidThreadSettingsExtension, Boolean, ThreadType, Long>("set_application_thread_type")
  }

  public object MethodBindings {
    internal val setApplicationThreadTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAndroidThreadSettingsExtension", "set_application_thread_type", 1558751158)
  }
}
