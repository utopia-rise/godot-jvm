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
import godot.core.Callable
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_CALLABLE_BOOL_STRING
import godot.writeMethodArguments_CALLABLE_LONG_LONG_BOOL_STRING
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * The [WorkerThreadPool] singleton allocates a set of [Thread]s (called worker threads) on project
 * startup and provides methods for offloading tasks to them. This can be used for simple
 * multithreading without having to create [Thread]s.
 *
 * Tasks hold the [Callable] to be run by the threads. [WorkerThreadPool] can be used to create
 * regular tasks, which will be taken by one worker thread, or group tasks, which can be distributed
 * between multiple worker threads. Group tasks execute the [Callable] multiple times, which makes them
 * useful for iterating over a lot of elements, such as the enemies in an arena.
 *
 * Here's a sample on how to offload an expensive function to worker threads:
 *
 * ```gdscript
 * //gdscript
 * var enemies = [] # An array to be filled with enemies.
 *
 * func process_enemy_ai(enemy_index):
 * 	var processed_enemy = enemies[enemy_index]
 * 	# Expensive logic...
 *
 * func _process(delta):
 * 	var task_id = WorkerThreadPool.add_group_task(process_enemy_ai, enemies.size())
 * 	# Other code...
 * 	WorkerThreadPool.wait_for_group_task_completion(task_id)
 * 	# Other code that depends on the enemy AI already being processed.
 * ```
 *
 * ```csharp
 * //csharp
 * private List<Node> _enemies = new List<Node>(); // A list to be filled with enemies.
 *
 * private void ProcessEnemyAI(int enemyIndex)
 * {
 * 	Node processedEnemy = _enemies[enemyIndex];
 * 	// Expensive logic here.
 * }
 *
 * public override void _Process(double delta)
 * {
 * 	long taskId = WorkerThreadPool.AddGroupTask(Callable.From<int>(ProcessEnemyAI), _enemies.Count);
 * 	// Other code...
 * 	WorkerThreadPool.WaitForGroupTaskCompletion(taskId);
 * 	// Other code that depends on the enemy AI already being processed.
 * }
 * ```
 *
 * The above code relies on the number of elements in the `enemies` array remaining constant during
 * the multithreaded part.
 *
 * **Note:** Using this singleton could affect performance negatively if the task being distributed
 * between threads is not computationally expensive.
 */
@GodotBaseType
public object WorkerThreadPool : Object() {
  @JvmField
  public val addTaskName: MethodStringName3<WorkerThreadPool, Long, Callable, Boolean, String> =
      MethodStringName3<WorkerThreadPool, Long, Callable, Boolean, String>("add_task")

  @JvmField
  public val isTaskCompletedName: MethodStringName1<WorkerThreadPool, Boolean, Long> =
      MethodStringName1<WorkerThreadPool, Boolean, Long>("is_task_completed")

  @JvmField
  public val waitForTaskCompletionName: MethodStringName1<WorkerThreadPool, Error, Long> =
      MethodStringName1<WorkerThreadPool, Error, Long>("wait_for_task_completion")

  @JvmField
  public val getCallerTaskIdName: MethodStringName0<WorkerThreadPool, Long> =
      MethodStringName0<WorkerThreadPool, Long>("get_caller_task_id")

  @JvmField
  public val addGroupTaskName:
      MethodStringName5<WorkerThreadPool, Long, Callable, Int, Int, Boolean, String> =
      MethodStringName5<WorkerThreadPool, Long, Callable, Int, Int, Boolean, String>("add_group_task")

  @JvmField
  public val isGroupTaskCompletedName: MethodStringName1<WorkerThreadPool, Boolean, Long> =
      MethodStringName1<WorkerThreadPool, Boolean, Long>("is_group_task_completed")

  @JvmField
  public val getGroupProcessedElementCountName: MethodStringName1<WorkerThreadPool, Long, Long> =
      MethodStringName1<WorkerThreadPool, Long, Long>("get_group_processed_element_count")

  @JvmField
  public val waitForGroupTaskCompletionName: MethodStringName1<WorkerThreadPool, Unit, Long> =
      MethodStringName1<WorkerThreadPool, Unit, Long>("wait_for_group_task_completion")

  @JvmField
  public val getCallerGroupIdName: MethodStringName0<WorkerThreadPool, Long> =
      MethodStringName0<WorkerThreadPool, Long>("get_caller_group_id")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(37)
  }

  /**
   * Adds [action] as a task to be executed by a worker thread. [highPriority] determines if the
   * task has a high priority or a low priority (default). You can optionally provide a [description]
   * to help with debugging.
   *
   * Returns a task ID that can be used by other methods.
   *
   * **Warning:** Every task must be waited for completion using [waitForTaskCompletion] or
   * [waitForGroupTaskCompletion] at some point so that any allocated resources inside the task can be
   * cleaned up.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addTask(
    action: Callable,
    highPriority: Boolean = false,
    description: String = "",
  ): Long {
    TransferContext.writeMethodArguments_CALLABLE_BOOL_STRING(ptr, objectID.id, action, highPriority, description)
    TransferContext.callMethod(MethodBindings.addTaskPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns `true` if the task with the given ID is completed.
   *
   * **Note:** You should only call this method between adding the task and awaiting its completion.
   */
  @JvmStatic
  public final fun isTaskCompleted(taskId: Long): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, taskId)
    TransferContext.callMethod(MethodBindings.isTaskCompletedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Pauses the thread that calls this method until the task with the given ID is completed.
   *
   * Returns [@GlobalScope.OK] if the task could be successfully awaited.
   *
   * Returns [@GlobalScope.ERR_INVALID_PARAMETER] if a task with the passed ID does not exist (maybe
   * because it was already awaited and disposed of).
   *
   * Returns [@GlobalScope.ERR_BUSY] if the call is made from another running task and, due to task
   * scheduling, there's potential for deadlocking (e.g., the task to await may be at a lower level in
   * the call stack and therefore can't progress). This is an advanced situation that should only
   * matter when some tasks depend on others (in the current implementation, the tricky case is a task
   * trying to wait on an older one).
   */
  @JvmStatic
  public final fun waitForTaskCompletion(taskId: Long): Error {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, taskId)
    TransferContext.callMethod(MethodBindings.waitForTaskCompletionPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the task ID of the current thread calling this method, or `-1` if the task is a group
   * task, invalid or the current thread is not part of the thread pool (e.g. the main thread).
   *
   * Can be used by a task to get its own task ID, or to determine whether the current code is
   * running inside the worker thread pool.
   *
   * **Note:** Group tasks have their own IDs, so this method will return `-1` for group tasks.
   */
  @JvmStatic
  public final fun getCallerTaskId(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCallerTaskIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Adds [action] as a group task to be executed by the worker threads. The [Callable] will be
   * called a number of times based on [elements], with the first thread calling it with the value `0`
   * as a parameter, and each consecutive execution incrementing this value by 1 until it reaches
   * `element - 1`.
   *
   * The number of threads the task is distributed to is defined by [tasksNeeded], where the default
   * value `-1` means it is distributed to all worker threads. [highPriority] determines if the task
   * has a high priority or a low priority (default). You can optionally provide a [description] to
   * help with debugging.
   *
   * Returns a group task ID that can be used by other methods.
   *
   * **Warning:** Every task must be waited for completion using [waitForTaskCompletion] or
   * [waitForGroupTaskCompletion] at some point so that any allocated resources inside the task can be
   * cleaned up.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addGroupTask(
    action: Callable,
    elements: Int,
    tasksNeeded: Int = -1,
    highPriority: Boolean = false,
    description: String = "",
  ): Long {
    TransferContext.writeMethodArguments_CALLABLE_LONG_LONG_BOOL_STRING(ptr, objectID.id, action, elements.toLong(), tasksNeeded.toLong(), highPriority, description)
    TransferContext.callMethod(MethodBindings.addGroupTaskPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns `true` if the group task with the given ID is completed.
   *
   * **Note:** You should only call this method between adding the group task and awaiting its
   * completion.
   */
  @JvmStatic
  public final fun isGroupTaskCompleted(groupId: Long): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, groupId)
    TransferContext.callMethod(MethodBindings.isGroupTaskCompletedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns how many times the [Callable] of the group task with the given ID has already been
   * executed by the worker threads.
   *
   * **Note:** If a thread has started executing the [Callable] but is yet to finish, it won't be
   * counted.
   */
  @JvmStatic
  public final fun getGroupProcessedElementCount(groupId: Long): Long {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, groupId)
    TransferContext.callMethod(MethodBindings.getGroupProcessedElementCountPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Pauses the thread that calls this method until the group task with the given ID is completed.
   */
  @JvmStatic
  public final fun waitForGroupTaskCompletion(groupId: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, groupId)
    TransferContext.callMethod(MethodBindings.waitForGroupTaskCompletionPtr)
  }

  /**
   * Returns the task group ID of the current thread calling this method, or `-1` if invalid or the
   * current thread is not part of a task group.
   */
  @JvmStatic
  public final fun getCallerGroupId(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCallerGroupIdPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public object MethodBindings {
    internal val addTaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "add_task", 3745067146)

    internal val isTaskCompletedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "is_task_completed", 1116898809)

    internal val waitForTaskCompletionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "wait_for_task_completion", 844576869)

    internal val getCallerTaskIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "get_caller_task_id", 3905245786)

    internal val addGroupTaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "add_group_task", 1801953219)

    internal val isGroupTaskCompletedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "is_group_task_completed", 1116898809)

    internal val getGroupProcessedElementCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "get_group_processed_element_count", 923996154)

    internal val waitForGroupTaskCompletionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "wait_for_group_task_completion", 1286410249)

    internal val getCallerGroupIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorkerThreadPool", "get_caller_group_id", 3905245786)
  }
}
