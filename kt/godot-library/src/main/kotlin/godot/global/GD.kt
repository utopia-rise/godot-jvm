package godot.global

import godot.Object
import godot.RandomNumberGenerator
import godot.Resource
import godot.ResourceLoader
import godot.core.Dictionary
import godot.core.NodePath
import godot.core.PoolByteArray
import godot.core.PoolColorArray
import godot.core.PoolIntArray
import godot.core.PoolRealArray
import godot.core.PoolStringArray
import godot.core.PoolVector2Array
import godot.core.PoolVector3Array
import godot.core.VariantArray
import godot.util.nullptr


object GD : GDMath, GDCore, GDRandom, GDPrint {
    override val rng = RandomNumberGenerator()

    /** Asserts that the condition is true.
    If the condition is false, an error is generated and the program is halted until you resume it.
    Only executes in debug builds. Use it for debugging purposes, to make sure a statement is true during development. */
    fun assert(condition: Boolean, message: String = "") = assert(condition) { message }

    /** Returns whether instance is a valid object (e.g. has not been deleted from memory).*/
    fun isInstanceValid(instance: Object): Boolean {
        return instance.rawPtr != nullptr
    }

    /** Returns length of Variant var
     * Note: Generates a fatal error if Variant can not provide a length.
     * */
    fun len(what: Any?): Int {
        if (what is Collection<*>) {
            return what.size
        } else if (what is Map<*, *>) {
            return what.size
        }

        return when (what) {
            is String -> len(what)
            is NodePath -> len(what)
            is Dictionary<*, *> -> len(what)
            is VariantArray<*> -> len(what)
            is PoolByteArray -> len(what)
            is PoolIntArray -> len(what)
            is PoolRealArray -> len(what)
            is PoolStringArray -> len(what)
            is PoolVector2Array -> len(what)
            is PoolVector3Array -> len(what)
            is PoolColorArray -> len(what)
            else -> throw IllegalArgumentException("This type doesn't have a length. It must be a compatible Variant, Collection or Map")
        }
    }

    /**
     * Loads a resource from the filesystem located at path.
     * The resource is loaded on the method call (unless it's referenced already elsewhere, e.g. in another script or in the scene), which might cause slight delay, especially when loading scenes.
     * Important: The path must be absolute, a local path will just return null.
     * */
    @Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST")
    inline fun <T : Resource> load(path: String, typeHint: String = "", noCache: Boolean = false): T {
        return ResourceLoader.load(path, typeHint, noCache) as T
    }
}
