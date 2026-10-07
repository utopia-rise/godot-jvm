package godot.registration

import godot.core.KtObject
import godot.internal.logging.GodotLogging

/** The body of a `_process` or `_physics_process` override, taking `delta` as a primitive so nothing is boxed. */
fun interface ProcessBody<T : KtObject> {
    fun invoke(instance: T, delta: Double)
}

/**
 * A `_process` or `_physics_process` override. The engine calls them every frame on every node, so they are not
 * [KtFunction]s: the native side calls [invoke] with `delta` as a JNI argument and neither side touches the buffer.
 */
class KtProcess<T : KtObject>(
    val name: String,
    private val body: ProcessBody<T>,
) {
    fun invoke(instance: T, delta: Double) {
        try {
            body.invoke(instance, delta)
        } catch (t: Throwable) {
            GodotLogging.error("Error calling JVM method $name of script $instance from Godot:\n" + t.stackTraceToString())
        }
    }
}
