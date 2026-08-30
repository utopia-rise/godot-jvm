package godot.coroutines

import godot.api.Engine
import godot.api.SceneTree
import godot.core.Callable
import godot.core.Signal0
import godot.core.asCallable
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume

suspend fun awaitNextFrame() {
    withContext(GodotDispatchers.MainThread) {
        awaitFrame(sceneTree(), signal = { it.processFrame })
    }
}

suspend fun awaitNextPhysicsFrame() {
    withContext(GodotDispatchers.MainThread) {
        awaitFrame(sceneTree(), signal = { it.physicsFrame })
    }
}

suspend fun NodeScope.awaitNextProcess() {
    withContext(GodotDispatchers.MainThread) {
        awaitNodeFrame { it.processFrame }
    }
}

suspend fun NodeScope.awaitNextPhysicsProcess() {
    withContext(GodotDispatchers.MainThread) {
        awaitNodeFrame { it.physicsFrame }
    }
}

private fun sceneTree(): SceneTree = Engine.getMainLoop() as? SceneTree
    ?: error("Godot's main loop must be a SceneTree.")

private suspend fun NodeScope.awaitNodeFrame(signal: (SceneTree) -> Signal0) {
    val tree = node.getTree() ?: error("Node must be inside the SceneTree")

    awaitFrame(tree, signal) { node.canProcess() }
}

private suspend fun awaitFrame(
    tree: SceneTree,
    signal: (SceneTree) -> Signal0,
    canResume: () -> Boolean = { true },
) {
    suspendCancellableCoroutine { continuation ->
        lateinit var callable: Callable
        callable = {
            if (canResume()) {
                signal(tree).disconnectUnsafe(callable)
                continuation.resume(Unit)
            }
        }.asCallable()

        val frameSignal = signal(tree)
        frameSignal.connectUnsafe(callable)
        continuation.invokeOnCancellation {
            if (frameSignal.isValid() && frameSignal.isConnected(callable)) {
                frameSignal.disconnectUnsafe(callable)
            }
        }
    }
}
