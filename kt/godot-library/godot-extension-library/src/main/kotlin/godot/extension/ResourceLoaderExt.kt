@file:JvmName("ResourceLoaderUtils")

package godot.extension

import godot.api.Resource
import godot.api.ResourceLoader

@Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST")
inline fun <T : Resource> ResourceLoader.loadAs(
    path: String,
    typeHint: String = "",
    cacheMode: ResourceLoader.CacheMode = ResourceLoader.CacheMode.REUSE
): T? {
    return load(path, typeHint, cacheMode) as T?
}
