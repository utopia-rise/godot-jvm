package godot.coroutines

import godot.api.WorkerThreadPool
import godot.core.asCallable
import godot.internal.memory.MemoryManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.coroutines.CoroutineContext
import godot.api.Thread as GodotThread

private const val TASKS_INITIAL_CAPACITY = 16
private val taskLock = ReentrantLock()
private val finishedTaskIds = ArrayDeque<Long>(TASKS_INITIAL_CAPACITY)

object GodotDispatchers {

    val MainThread: CoroutineDispatcher = GodotMainThreadCoroutineDispatcher
    val ThreadPool: CoroutineDispatcher = GodotThreadPoolCoroutineDispatcher

    private object GodotMainThreadCoroutineDispatcher : CoroutineDispatcher() {
        @Volatile
        private var cachedMainThread: Thread? = null

        override fun isDispatchNeeded(context: CoroutineContext): Boolean {
            val current = Thread.currentThread()
            val cached = cachedMainThread
            // Already on the main thread → no dispatch needed.
            if (cached != null) return cached !== current

            // Slow path: ask Godot. Caches on success so subsequent checks are JNI-free.
            if (GodotThread.isMainThread()) {
                cachedMainThread = current
                return false
            }
            return true
        }

        override fun dispatch(context: CoroutineContext, block: Runnable) {
            { block.run() }.asCallable().callDeferred()
        }
    }

    private object GodotThreadPoolCoroutineDispatcher : CoroutineDispatcher() {
        private class PendingTask {
            private var taskId: Long? = null
            private var callableFinished = false

            fun register(taskId: Long) {
                taskLock.withLock {
                    this.taskId = taskId
                    if (callableFinished) {
                        finishedTaskIds.addLast(taskId)
                    }
                }
            }

            fun finish() {
                taskLock.withLock {
                    callableFinished = true
                    taskId?.let(finishedTaskIds::addLast)
                }
            }
        }

        init {
            MemoryManager.registerCallback(true, ::flushCompletedTasks)
        }

        override fun dispatch(context: CoroutineContext, block: Runnable) {
            clearCompletedTasks()

            val task = PendingTask()
            val callable = {
                try {
                    block.run()
                } finally {
                    task.finish()
                }
            }.asCallable()

            task.register(WorkerThreadPool.addTask(callable))
        }

        private fun clearCompletedTasks() {
            val taskIds = taskLock.withLock {
                finishedTaskIds.toList().also { finishedTaskIds.clear() }
            }

            taskIds.forEach {
                if (WorkerThreadPool.isTaskCompleted(it)) {
                    WorkerThreadPool.waitForTaskCompletion(it)
                } else {
                    taskLock.withLock { finishedTaskIds.addLast(it) }
                }
            }
        }

        private fun flushCompletedTasks() {
            while (true) {
                val taskIds = taskLock.withLock {
                    if (finishedTaskIds.isEmpty()) {
                        return
                    }
                    finishedTaskIds.toList().also { finishedTaskIds.clear() }
                }

                taskIds.forEach(WorkerThreadPool::waitForTaskCompletion)
            }
        }
    }

}
