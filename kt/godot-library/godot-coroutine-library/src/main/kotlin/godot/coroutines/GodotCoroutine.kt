package godot.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


/**
 * Creates a [CoroutineScope] on [GodotDispatchers.MainThread] with a [SupervisorJob], for work that does not
 * belong to a node. Cancel it yourself when its owner is done.
 *
 * The dispatcher is immediate: coroutines launched from the main thread run inline until they first suspend, and
 * one that never suspends completes before `launch` returns. Add [GodotDispatchers.MainThreadDeferred] to
 * [context] when callers must be able to await the signals those coroutines emit.
 */
fun godotCoroutine(
    context: CoroutineContext = EmptyCoroutineContext,
): CoroutineScope = CoroutineScope(SupervisorJob() + GodotDispatchers.MainThread + context)

/** Runs [block] on Godot's main thread. */
suspend fun <T> threadSafe(
    block: suspend CoroutineScope.() -> T,
): T = withContext(GodotDispatchers.MainThread, block)

/** Runs [block] on Godot's worker thread pool. */
suspend fun <T> offload(
    block: suspend CoroutineScope.() -> T,
): T = withContext(GodotDispatchers.ThreadPool, block)
