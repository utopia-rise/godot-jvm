@file:JvmName("NodePaths")
@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.common.extensions.convertToSnakeCase
import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.interop.VoidPtr
import godot.common.util.LRUCache
import godot.internal.memory.MemoryManager.CACHE_INITIAL_CAPACITY
import kotlin.reflect.KProperty

@Suppress("MemberVisibilityCanBePrivate")
class NodePath : NativeCoreType {

    //INTERNAL
    internal constructor(_handle: VoidPtr) {
        this.ptr = _handle
        MemoryManager.registerNativeCoreType(this, VariantParser.NODE_PATH)
    }

    //CONSTRUCTORS

    constructor() {
        ptr = Bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.NODE_PATH)
    }

    constructor(from: String) {
        TransferContext.writeArguments(1) {
            VariantParser.STRING.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_string()
        MemoryManager.registerNativeCoreType(this, VariantParser.NODE_PATH)
    }

    constructor(from: NodePath) {
        TransferContext.writeArguments(1) {
            VariantParser.NODE_PATH.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_node_path()
        MemoryManager.registerNativeCoreType(this, VariantParser.NODE_PATH)
    }

    //API

    //PROPERTIES
    val path: String
        get() {
            return TransferContext.callBridge(VariantParser.STRING) { Bridge.engine_call_path(ptr) } as String
        }

    /**
     * Returns a node path with a colon character (`:`) prepended, transforming it to a pure property path with no node
     * name (defaults to resolving from the current node).
     */
    fun getAsPropertyPath(): NodePath {
        return TransferContext.callBridge(VariantParser.NODE_PATH) { Bridge.engine_call_getAsPropertyPath(ptr) } as NodePath
    }

    /**
     * Get the node name indicated by idx (0 to get_name_count)
     */
    fun getName(idx: Int): String {
        return TransferContext.callBridge(1, VariantParser.STRING) {
            VariantParser.LONG.write(idx.toLong())
            Bridge.engine_call_getName(ptr)
        } as String
    }

    /**
     * Get the number of node names which make up the path.
     */
    fun getNameCount(): Int {
        return TransferContext.callBridge(VariantParser.LONG) { Bridge.engine_call_getNameCount(ptr) }.toInt()
    }

    /**
     * Get the resource name indicated by idx (0 to get_subname_count)
     */
    fun getSubname(idx: Int): String {
        return TransferContext.callBridge(1, VariantParser.STRING) {
            VariantParser.LONG.write(idx.toLong())
            Bridge.engine_call_getSubname(ptr)
        } as String
    }

    /**
     * Get the number of resource names in the path.
     */
    fun getSubnameCount(): Int {
        return TransferContext.callBridge(VariantParser.LONG) { Bridge.engine_call_getSubnameCount(ptr) }.toInt()
    }

    /**
     * Return true if the node path is absolute (not relative).
     */
    fun isAbsolute(): Boolean {
        return TransferContext.callBridge(VariantParser.BOOL) { Bridge.engine_call_isAbsolute(ptr) }
    }

    /**
     * Returns the 32-bit hash value representing the NodePath's contents.
     */
    fun hash(): Int {
        return TransferContext.callBridge(VariantParser.LONG) { Bridge.engine_call_hash(ptr) }.toInt()
    }

    /**
     * Return true if the node path is empty.
     */
    fun isEmpty(): Boolean {
        return TransferContext.callBridge(VariantParser.BOOL) { Bridge.engine_call_isEmpty(ptr) }
    }

    /**
     * Returns all paths concatenated with a slash character (/) as separator without subnames.
     */
    fun getConcatenatedNames(): StringName {
        return TransferContext.callBridge(VariantParser.STRING_NAME) { Bridge.engine_call_getConcatenatedNames(ptr) } as StringName
    }

    /**
     * Returns all subnames concatenated with a colon character (`:`) as separator, i.e. the right side of the first colon
     * in a node path.
     */
    fun getConcatenatedSubnames(): StringName {
        return TransferContext.callBridge(VariantParser.STRING_NAME) { Bridge.engine_call_getConcatenatedSubnames(ptr) } as StringName
    }


    //UTILITIES
    override fun equals(other: Any?): Boolean {
        return if (other is NodePath) {
            return TransferContext.callBridge(1, VariantParser.BOOL) {
                VariantParser.NODE_PATH.toGodot(other)
                Bridge.engine_call_equals(ptr)
            }
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return ptr.hashCode()
    }

    override fun toString(): String {
        return "NodePath(${getConcatenatedSubnames()})"
    }

    @Suppress("FunctionName")
    private object Bridge {
        external fun engine_call_constructor(): VoidPtr
        external fun engine_call_constructor_string(): VoidPtr
        external fun engine_call_constructor_node_path(): VoidPtr

        external fun engine_call_path(_handle: VoidPtr)
        external fun engine_call_getAsPropertyPath(_handle: VoidPtr)
        external fun engine_call_getName(_handle: VoidPtr)
        external fun engine_call_getNameCount(_handle: VoidPtr)
        external fun engine_call_getSubname(_handle: VoidPtr)
        external fun engine_call_getSubnameCount(_handle: VoidPtr)
        external fun engine_call_isAbsolute(_handle: VoidPtr)
        external fun engine_call_hash(_handle: VoidPtr)
        external fun engine_call_isEmpty(_handle: VoidPtr)
        external fun engine_call_getConcatenatedNames(_handle: VoidPtr)
        external fun engine_call_getConcatenatedSubnames(_handle: VoidPtr)
        external fun engine_call_equals(_handle: VoidPtr)
    }

    internal companion object{
        private val nodePathCache = LRUCache<String, NodePath>(CACHE_INITIAL_CAPACITY)

        init {
            MemoryManager.registerCallback(true) {
                nodePathCache.clear()
            }
        }

        /**
         * Take a String, cache it and return it as a NodePath.
         */
        fun getOrCreateNodePath(key: String): NodePath {
            return synchronized(nodePathCache) {
                nodePathCache.getOrPut(key) {
                    // Cache miss, so create and return new instance.
                    NodePath(key)
                }
            }
        }

        /**
         * Take a CamelCase String, cache it and return a snakeCase version of it as a NodePath.
         */
        fun getOrCreateGodotPath(key: String): NodePath {
            return synchronized(nodePathCache) {
                nodePathCache.getOrPut(key) {
                    // Cache miss, so create and return new instance.
                    NodePath(key.convertToSnakeCase())
                }
            }
        }
    }
}

/**
 * Directly convert String to NodePath
 */
fun String.asNodePath(): NodePath {
    return NodePath(this)
}

/**
 * Directly convert StringName to NodePath
 */
fun StringName.asNodePath(): NodePath {
    return NodePath(this.toString())
}

/**
 * Convert String to NodePath and cache it for future calls.
 */
fun String.asCachedNodePath(): NodePath {
    return NodePath.getOrCreateNodePath(this)
}

/**
 * Convert a snake_case version of the String to NodePath and cache it for future calls.
 */
fun String.toGodotPath(): NodePath {
    return NodePath.getOrCreateGodotPath(this)
}

/**
 * Convert a snake_case version of the property's name to NodePath and cache it for future calls.
 */
fun KProperty<*>.toGodotPath(): NodePath {
    return NodePath.getOrCreateGodotPath(this.name)
}
