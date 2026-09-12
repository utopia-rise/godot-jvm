@file:Suppress("unused", "PackageDirectoryMismatch", "UNCHECKED_CAST")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.common.interop.VariantConverter
import godot.common.interop.VoidPtr
import godot.common.interop.nullptr
import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.util.MapIterator
import godot.common.util.isNullable
import godot.core.bridge.DeepDuplicateMode
import godot.internal.reflection.TypeManager
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.jvm.internal.Reflection
import kotlin.reflect.KClass

class Dictionary<K, V> : NativeCoreType, MutableMap<K, V> {

    internal var keyVariantConverter: VariantConverter<K>
    internal var valueVariantConverter: VariantConverter<V>

    @PublishedApi
    internal constructor(handle: VoidPtr) : this(handle, VariantCaster.ANY as VariantConverter<K>, VariantCaster.ANY as VariantConverter<V>)

    @PublishedApi
    internal constructor(handle: VoidPtr, keyConverter: VariantConverter<K>, valueConverter: VariantConverter<V>) {
        keyVariantConverter = keyConverter
        valueVariantConverter = valueConverter
        ptr = handle
        MemoryManager.registerNativeCoreType(this, VariantParser.DICTIONARY)
    }

    constructor(keyClass: Class<*>, valueClass: Class<*>) : this(Reflection.getOrCreateKotlinClass(keyClass), Reflection.getOrCreateKotlinClass(valueClass))

    constructor(keyConverter: VariantConverter<K>, valueConverter: VariantConverter<V>) {
        keyVariantConverter = keyConverter
        valueVariantConverter = valueConverter
        ptr = if (keyConverter != VariantCaster.ANY || valueConverter != VariantCaster.ANY) {
            TransferContext.writeArguments(
                VariantCaster.INT to keyConverter.id,
                VariantCaster.INT to -1,
                VariantParser.LONG to nullptr,
                VariantCaster.INT to valueConverter.id,
                VariantCaster.INT to -1,
                VariantParser.LONG to nullptr
            )
            Bridge.engine_call_constructor_typed()
        } else {
            Bridge.engine_call_constructor()
        }
        MemoryManager.registerNativeCoreType(this, VariantParser.DICTIONARY)
    }

    @PublishedApi
    internal constructor(keyClass: KClass<*>, valueClass: KClass<*>) {
        val keyVariantConverter = getVariantConverter(keyClass)
        val valueVariantConverter = getVariantConverter(valueClass)

        if (GodotJvmBuildConfig.DEBUG) {
            checkNotNull(keyVariantConverter) {
                "Can't create a Dictionary with generic key ${keyClass}."
            }

            checkNotNull(valueVariantConverter) {
                "Can't create a Dictionary with generic value ${valueClass}."
            }
        }

        this.keyVariantConverter = keyVariantConverter as VariantConverter<K>
        this.valueVariantConverter = valueVariantConverter as VariantConverter<V>

        ptr = if (keyVariantConverter != VariantCaster.ANY || valueVariantConverter != VariantCaster.ANY) {
            TransferContext.writeArguments(
                VariantCaster.INT to keyVariantConverter.id,
                VariantCaster.INT to (TypeManager.engineTypeToId[keyClass] ?: -1),
                VariantParser.LONG to (TypeManager.userClassToScriptPtr[keyClass] ?: nullptr),
                VariantCaster.INT to valueVariantConverter.id,
                VariantCaster.INT to (TypeManager.engineTypeToId[valueClass] ?: -1),
                VariantParser.LONG to (TypeManager.userClassToScriptPtr[valueClass] ?: nullptr)
            )
            Bridge.engine_call_constructor_typed()
        } else {
            Bridge.engine_call_constructor()
        }

        MemoryManager.registerNativeCoreType(this, VariantParser.DICTIONARY)
    }

    //########################PUBLIC###############################
    //PROPERTIES
    override val size: Int
        get() {
            Bridge.engine_call_size(ptr)
            return TransferContext.readReturnValue(VariantCaster.INT) as Int
        }

    override val keys: MutableSet<K>
        get() = object : AbstractMutableSet<K>() {
            override fun add(element: K): Boolean = throw UnsupportedOperationException("Add is not supported on keys")
            override fun clear() {
                this@Dictionary.clear()
            }

            override operator fun contains(element: K): Boolean = containsKey(element)

            override operator fun iterator(): MutableIterator<K> {
                val entryIterator = keys().iterator()
                return object : MutableIterator<K> {
                    override fun hasNext(): Boolean = entryIterator.hasNext()
                    override fun next(): K = entryIterator.next()
                    override fun remove() = throw UnsupportedOperationException("Remove is not supported on keys")
                }
            }

            override fun remove(element: K): Boolean {
                if (containsKey(element)) {
                    this@Dictionary.remove(element)
                    return true
                }
                return false
            }

            override val size: Int get() = this@Dictionary.size
        }

    override val values: MutableCollection<V>
        get() = object : AbstractMutableCollection<V>() {
            override fun add(element: V): Boolean =
                throw UnsupportedOperationException("Add is not supported on values")

            override fun clear() = this@Dictionary.clear()

            override operator fun contains(element: V): Boolean = containsValue(element)

            override operator fun iterator(): MutableIterator<V> {
                val entryIterator = values().iterator()
                return object : MutableIterator<V> {
                    override fun hasNext(): Boolean = entryIterator.hasNext()
                    override fun next(): V = entryIterator.next()
                    override fun remove() = throw UnsupportedOperationException("Remove is not supported on values")
                }
            }

            override val size: Int get() = this@Dictionary.size
        }

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = object : AbstractMutableSet<MutableMap.MutableEntry<K, V>>() {

            override fun add(element: MutableMap.MutableEntry<K, V>): Boolean {
                val ret = has(element.key)
                this@Dictionary[element.key] = element.value
                return ret
            }

            override fun clear() {
                this@Dictionary.clear()
            }

            override operator fun contains(element: MutableMap.MutableEntry<K, V>): Boolean {
                val value = get(element.key, null)
                return value == element.value
            }

            override operator fun iterator(): MapIterator<K, V> {
                return MapIterator(
                    this@Dictionary.keys.iterator(),
                    this@Dictionary::get,
                    this@Dictionary::set,
                    this@Dictionary::erase
                )
            }

            override fun remove(element: MutableMap.MutableEntry<K, V>): Boolean {
                val value = get(element.key, null)
                if (value == element.value) {
                    this@Dictionary.remove(element.key)
                    return true
                }
                return false
            }

            override val size: Int get() = this@Dictionary.size
        }

//CONSTRUCTOR
    /**
     * Create a shallow copy of the Dictionary
     */
    constructor(other: Dictionary<K, V>) {
        keyVariantConverter = other.keyVariantConverter
        valueVariantConverter = other.valueVariantConverter
        ptr = other.ptr
        MemoryManager.registerNativeCoreType(this, VariantParser.DICTIONARY)
    }


//API
    /**
     * Clear the dictionary, removing all key/value pairs.
     */
    override fun clear() {
        Bridge.engine_call_clear(ptr)
    }

    override fun containsKey(key: K) = contains(key)

    override fun containsValue(value: V): Boolean {
        values.forEach {
            if (it == value)
                return true
        }
        return false
    }

    /**
     * Creates a copy of the dictionary, and returns it.
     * The deep parameter causes inner dictionaries and arrays to be copied recursively, but does not apply to objects.
     */

    fun duplicate(deep: Boolean): Dictionary<K, V> {
        TransferContext.writeArguments(VariantParser.BOOL to deep)
        Bridge.engine_call_duplicate(ptr)
        @Suppress("UNCHECKED_CAST")
        return (TransferContext.readReturnValue(VariantParser.DICTIONARY) as Dictionary<K, V>).also {
            it.keyVariantConverter = keyVariantConverter
            it.valueVariantConverter = valueVariantConverter
        }
    }

    /**
     * Duplicates this dictionary, deeply, like duplicate()(true), with extra control over how subresources are handled.
     * deepSubresourceMode must be one of the values from DeepDuplicateMode. By default, only internal resources will be duplicated (recursively).
     */
    fun duplicateDeep(deepSubresourceMode: DeepDuplicateMode): Dictionary<K,V> {
        TransferContext.writeArguments(VariantParser.LONG to deepSubresourceMode.value)
        Bridge.engine_call_duplicate_deep(ptr)
        return (TransferContext.readReturnValue(VariantParser.DICTIONARY) as Dictionary<K, V>).also {
            it.keyVariantConverter = keyVariantConverter
            it.valueVariantConverter = valueVariantConverter
        }
    }

    /**
     * Erase a dictionary key/value pair by key. Doesn't return a Boolean like the GDScript version because the GDNative function doesn't return anything
     */
    fun erase(key: K) {
        TransferContext.writeArguments(keyVariantConverter to key)
        Bridge.engine_call_erase(ptr)
    }

    fun findKey(value: V): K {
        TransferContext.writeArguments(valueVariantConverter to value)
        Bridge.engine_call_find_key(ptr)
        @Suppress("UNCHECKED_CAST")
        return TransferContext.readReturnValue(keyVariantConverter) as K
    }

    /**
     * Returns the current value for the specified key in the Dictionary.
     * If the key does not exist, the method returns the value of the optional default argument, or null if it is omitted.
     */
    fun get(key: K, default: V?): V? {
        TransferContext.writeArguments(keyVariantConverter to key, valueVariantConverter to default)
        Bridge.engine_call_get(ptr)
        @Suppress("UNCHECKED_CAST")
        return TransferContext.readReturnValue(valueVariantConverter) as V?
    }

    /**
     * Returns true if the dictionary has a given key.
     * Note: This is equivalent to using the in operator as follows:
     */
    fun has(key: K): Boolean {
        TransferContext.writeArguments(keyVariantConverter to key)
        Bridge.engine_call_has(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }


    /**
     * Returns true if the dictionary has all of the keys in the given array.
     */
    fun hasAll(keys: VariantArray<K>): Boolean {
        TransferContext.writeArguments(VariantParser.ARRAY to keys)
        Bridge.engine_call_hasAll(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }


    /**
     * Returns a hashed integer value representing the dictionary contents. This can be used to compare dictionaries by value
     */
    fun hash(): Int {
        Bridge.engine_call_hash(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Returns true if the dictionary is read-only. See [makeReadOnly]
     */
    fun isReadOnly(): Boolean {
        Bridge.engine_call_is_read_only(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Returns true if the dictionary is empty.
     */
    override fun isEmpty(): Boolean {
        Bridge.engine_call_is_empty(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Returns the list of keys in the Dictionary.
     */
    fun keys(): VariantArray<K> {
        Bridge.engine_call_keys(ptr)
        @Suppress("UNCHECKED_CAST")
        return (TransferContext.readReturnValue(VariantParser.ARRAY) as VariantArray<K>).also {
            it.variantConverter = keyVariantConverter
        }
    }

    fun makeReadOnly() {
        Bridge.engine_call_make_read_only(ptr)
    }

    fun merge(dictionary: Dictionary<K, V>, overwrite: Boolean = false) {
        TransferContext.writeArguments(VariantParser.DICTIONARY to dictionary, VariantParser.BOOL to overwrite)
        Bridge.engine_call_merge(ptr)
    }

    override fun put(key: K, value: V): V? {
        val ret = if (has(key)) get(key) else null
        set(key, value)
        return ret
    }

    override fun putAll(from: Map<out K, V>) {
        from.forEach {
            set(it.key, it.value)
        }
    }

    override fun remove(key: K): V? {
        val ret = get(key, null)
        erase(key)
        return ret
    }

    fun sort() {
        Bridge.engine_call_sort(ptr)
    }

    /**
     * Returns the list of values in the Dictionary.
     */
    fun values(): VariantArray<V> {
        Bridge.engine_call_values(ptr)
        @Suppress("UNCHECKED_CAST")
        return (TransferContext.readReturnValue(VariantParser.ARRAY) as VariantArray<V>).also {
            it.variantConverter = valueVariantConverter
        }
    }


    //UTILITIES
    override operator fun get(key: K): V {
        TransferContext.writeArguments(keyVariantConverter to key)
        Bridge.engine_call_operator_get(ptr)
        @Suppress("UNCHECKED_CAST")
        return TransferContext.readReturnValue(valueVariantConverter) as V
    }

    @CoreTypeHelper
    inline fun <R> mutate(key: K, block: (V) -> R): R {
        val localCopy = this[key]
        val ret = block(localCopy)
        this[key] = localCopy
        return ret
    }

    @CoreTypeHelper
    inline fun mutateEach(block: (key: K, value: V) -> Unit){
        for ((key, value) in this){
            block(key, value)
            this[key] = value
        }
    }

    operator fun set(key: K, value: V) {
        TransferContext.writeArguments(keyVariantConverter to key, valueVariantConverter to value)
        Bridge.engine_call_operator_set(ptr)
    }

    operator fun contains(key: K): Boolean = has(key)

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Dictionary<*, *>) {
            return false
        }
        TransferContext.writeArguments(VariantParser.DICTIONARY to this, VariantParser.DICTIONARY to other)
        Bridge.engine_call_equals(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    override fun hashCode(): Int {
        return ptr.hashCode()
    }

    override fun toString(): String {
        return "Dictionary($size)"
    }

    @Suppress("FunctionName")
    private object Bridge {
        external fun engine_call_constructor(): VoidPtr
        external fun engine_call_constructor_typed(): VoidPtr

        external fun engine_call_clear(_handle: VoidPtr)
        external fun engine_call_duplicate(_handle: VoidPtr)
        external fun engine_call_duplicate_deep(_handle: VoidPtr)
        external fun engine_call_erase(_handle: VoidPtr)
        external fun engine_call_find_key(_handle: VoidPtr)
        external fun engine_call_get(_handle: VoidPtr)
        external fun engine_call_has(_handle: VoidPtr)
        external fun engine_call_hasAll(_handle: VoidPtr)
        external fun engine_call_hash(_handle: VoidPtr)
        external fun engine_call_is_empty(_handle: VoidPtr)
        external fun engine_call_is_read_only(_handle: VoidPtr)
        external fun engine_call_keys(_handle: VoidPtr)
        external fun engine_call_make_read_only(_handle: VoidPtr)
        external fun engine_call_merge(_handle: VoidPtr)
        external fun engine_call_size(_handle: VoidPtr)
        external fun engine_call_sort(_handle: VoidPtr)
        external fun engine_call_values(_handle: VoidPtr)
        external fun engine_call_operator_get(_handle: VoidPtr)
        external fun engine_call_operator_set(_handle: VoidPtr)
        external fun engine_call_equals(_handle: VoidPtr)
    }


    companion object {
        inline operator fun <reified K, reified V> invoke(): Dictionary<K, V> {

            // The nullable check can't be inside the regular constructor because of Java
            if (GodotJvmBuildConfig.DEBUG) {
                if (hasInvalidNullability<K>()) {
                    error("Can't create a Dictionary with generic key ${K::class} as nullable.")
                }

                if (hasInvalidNullability<V>()) {
                    error("Can't create a Dictionary with generic value ${V::class} as nullable.")
                }
            }
            return Dictionary<K, V>(K::class, V::class)
        }
    }
}

inline fun <reified K, reified V> dictionaryOf(vararg args: Pair<K, V>) = Dictionary<K, V>().also {
    it.putAll(args)
}

/**
 * Convert a Map into a Dictionary
 */
inline fun <reified K, reified V> Map<K, V>.toDictionary() = Dictionary<K, V>().also {
    it.putAll(this)
}
