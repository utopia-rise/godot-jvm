package godot.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


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
