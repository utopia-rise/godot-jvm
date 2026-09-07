package godot.coroutines

import godot.api.Resource
import godot.api.ResourceLoader
import godot.api.ResourceLoader.CacheMode
import kotlinx.coroutines.withContext


/**
 * Suspends the coroutine until a resource is loaded from the given path.
 *
 * @param path The path of the resource to be loaded.
 * @param typeHint A hint about the type of resource being loaded.
 * @param cacheMode The cache mode to be used while loading the resource.
 * @return The loaded resource, or null if there was an error.
 */
suspend inline fun ResourceLoader.awaitLoad(
    path: String,
    typeHint: String = "",
    cacheMode: CacheMode = CacheMode.REUSE,
): Resource? {
    // Switch to the worker thread pool so the load doesn't block the caller's thread
    // (especially important when the caller is on the main thread). This also makes
    // cached and uncached loads complete asynchronously.
    return withContext(GodotDispatchers.ThreadPool) {
        load(path, typeHint, cacheMode)
    }
}

/**
 * Suspends the coroutine until a resource is loaded from the given path.
 *
 * @param path The path of the resource to be loaded.
 * @param typeHint A hint about the type of resource being loaded.
 * @param cacheMode The cache mode to be used while loading the resource.
 * @return The loaded resource, or null if there was an error.
 */
suspend inline fun <R> ResourceLoader.awaitLoadAs(
    path: String,
    typeHint: String = "",
    cacheMode: CacheMode = CacheMode.REUSE,
): R? {
    @Suppress("UNCHECKED_CAST")
    return this.awaitLoad(path, typeHint, cacheMode) as? R
}
