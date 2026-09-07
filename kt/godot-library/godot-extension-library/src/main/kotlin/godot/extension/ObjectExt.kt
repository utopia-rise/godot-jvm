@file:JvmName("ObjectUtils")

package godot.extension

import godot.api.Object
import godot.api.RefCounted
import godot.internal.memory.MemoryManager
import godot.core.asCachedStringName
import godot.core.toGodotName
import kotlin.reflect.KFunction

/**
 * **Note:** The function name is converted to snake_case
 * Use [Object.hasMethod] to check function existence by string or [hasMethodRawName] for an unconverted version of this function
 */
inline fun <reified T : KFunction<*>> Object.hasMethod(function: T) =
    hasMethod(function.name.toGodotName())

/**
 * Same as [hasMethod] but the function name is not converted to snake_case
 */
inline fun <reified T : KFunction<*>> Object.hasMethodRawName(function: T) =
    hasMethod(function.name.asCachedStringName())

/**
 * Instance will be automatically freed when the engine closes.
 */
fun <T : Object?> T.asStatic(): T {
    if (this == null || this is RefCounted) {
        return this
    }
    MemoryManager.registerCallback {
        if (!MemoryManager.isInstanceValid(this)) {
            return@registerCallback
        }
        free()

    }
    return this
}
