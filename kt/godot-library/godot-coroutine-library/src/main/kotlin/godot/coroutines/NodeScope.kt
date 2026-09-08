package godot.coroutines

import godot.api.Node
import godot.api.Object
import godot.core.asCallable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async as coroutineAsync
import kotlinx.coroutines.launch as coroutineLaunch
import java.util.IdentityHashMap
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * The coroutine scope owned by a [Node]. It is cancelled when the node exits the scene tree.
 *
 * Its dispatcher is [GodotDispatchers.MainThread], which is immediate: a body launched from the main thread runs
 * inline until its first real suspension, and a body that never suspends completes before [Node.launch] returns.
 * Signals emitted by such a body fire before the caller can await them. Suspend once before emitting, or pass
 * [GodotDispatchers.MainThreadDeferred] as the launch context, when the caller relies on those signals.
 */
class NodeScope internal constructor(
    internal val node: Node,
) : CoroutineScope {
    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext = job + GodotDispatchers.MainThread

    internal fun cancel() {
        job.cancel()
    }
}

private val nodeScopes = IdentityHashMap<Node, NodeScope>()

fun Node.nodeScope(): NodeScope {
    check(isInsideTree()) {
        "A NodeScope can only be used while its node is inside the scene tree."
    }

    synchronized(nodeScopes) {
        nodeScopes[this]?.let { return it }

        val scope = NodeScope(this)
        nodeScopes[this] = scope
        treeExiting.connectUnsafe(
            {
                releaseNodeScope(this, scope)
            }.asCallable(),
            Object.ConnectFlags.ONE_SHOT,
        )
        return scope
    }
}

/**
 * Launches [block] in this node's [NodeScope]. Valid only while the node is inside the scene tree.
 *
 * The block starts immediately on the main thread and runs until it first suspends; see [NodeScope] for what that
 * implies when the block emits signals the caller awaits. Pass [GodotDispatchers.MainThreadDeferred] as [context]
 * to start it at the next frame's message queue flush instead.
 */
fun Node.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend NodeScope.() -> Unit,
): Job {
    val scope = nodeScope()
    return scope.coroutineLaunch(context, start) { scope.block() }
}

/**
 * Starts [block] in this node's [NodeScope] and returns its result as a [Deferred]. Same start semantics as
 * [Node.launch].
 */
fun <T> Node.async(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend NodeScope.() -> T,
): Deferred<T> {
    val scope = nodeScope()
    return scope.coroutineAsync(context, start) { scope.block() }
}

private fun releaseNodeScope(node: Node, scope: NodeScope) {
    val removed = synchronized(nodeScopes) {
        if (nodeScopes[node] !== scope) {
            false
        } else {
            nodeScopes.remove(node)
            true
        }
    }

    if (removed) {
        scope.cancel()
    }
}
