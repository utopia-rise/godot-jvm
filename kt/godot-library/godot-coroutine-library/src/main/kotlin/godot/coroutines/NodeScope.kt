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

fun Node.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend NodeScope.() -> Unit,
): Job {
    val scope = nodeScope()
    return scope.coroutineLaunch(context, start) { scope.block() }
}

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
