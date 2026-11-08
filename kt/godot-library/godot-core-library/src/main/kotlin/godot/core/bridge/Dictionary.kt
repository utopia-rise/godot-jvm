@file:Suppress("unused", "PackageDirectoryMismatch", "UNCHECKED_CAST")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.common.interop.VariantConverter
import godot.common.interop.VoidPtr
import godot.common.interop.nullptr
import godot.internal.memory.MemoryManager
import godot.internal.memory.VariantBuffer
import godot.common.util.MapIterator
import godot.common.util.isNullable
import godot.core.bridge.DeepDuplicateMode
import godot.internal.reflection.TypeManager
import kotlincompile.definitions.GodotJvmBuildConfig

class Dictionary<K, V> : NativeCoreType, MutableMap<K, V> {

    override val size: Int
        get() {
            return VariantBuffer.transfer.callBridge(VariantParser.LONG) { Bridge.engine_call_size(ptr) }.toInt()
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
                return get(element.key) == element.value
            }

            override operator fun iterator(): MapIterator<K, V> {
                return MapIterator(
                    this@Dictionary.keys.iterator(),
                    { this@Dictionary.getValue(it) },
                    this@Dictionary::set,
                    this@Dictionary::erase
                )
            }

            override fun remove(element: MutableMap.MutableEntry<K, V>): Boolean {
                if (get(element.key) == element.value) {
                    this@Dictionary.remove(element.key)
                    return true
                }
                return false
            }

            override val size: Int get() = this@Dictionary.size
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

    constructor(keyConverter: VariantConverter<K>, valueConverter: VariantConverter<V>) {
        keyVariantConverter = keyConverter
        valueVariantConverter = valueConverter
        ptr = if (keyConverter != VariantCaster.ANY || valueConverter != VariantCaster.ANY) {
            VariantBuffer.transfer.writeArgs(6) {
                VariantParser.LONG.write(keyConverter.id.toLong())
                VariantParser.LONG.write((-1).toLong())
                VariantParser.LONG.write(nullptr)
                VariantParser.LONG.write(valueConverter.id.toLong())
                VariantParser.LONG.write((-1).toLong())
                VariantParser.LONG.write(nullptr)
            }
            Bridge.engine_call_constructor_typed()
        } else {
            Bridge.engine_call_constructor()
        }
        MemoryManager.registerNativeCoreType(this, VariantParser.DICTIONARY)
    }

    constructor(keyClass: Class<*>, valueClass: Class<*>) {
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
            VariantBuffer.transfer.writeArgs(6) {
                VariantParser.LONG.write(keyVariantConverter.id.toLong())
                VariantParser.LONG.write(((TypeManager.engineTypeToId[keyClass] ?: -1)).toLong())
                VariantParser.LONG.write((TypeManager.classToScriptPtr[keyClass] ?: nullptr))
                VariantParser.LONG.write(valueVariantConverter.id.toLong())
                VariantParser.LONG.write(((TypeManager.engineTypeToId[valueClass] ?: -1)).toLong())
                VariantParser.LONG.write((TypeManager.classToScriptPtr[valueClass] ?: nullptr))
            }
            Bridge.engine_call_constructor_typed()
        } else {
            Bridge.engine_call_constructor()
        }

        MemoryManager.registerNativeCoreType(this, VariantParser.DICTIONARY)
    }

    /**
     * Create a shallow copy of the Dictionary
     */
    constructor(other: Dictionary<K, V>) {
        keyVariantConverter = other.keyVariantConverter
        valueVariantConverter = other.valueVariantConverter
        ptr = Bridge.engine_call_copy_constructor(other.ptr)
        MemoryManager.registerNativeCoreType(this, VariantParser.DICTIONARY)
    }

    fun assign(dictionary: Dictionary<*, *>) {
        VariantBuffer.transfer.writeArgs(1) {
            VariantParser.DICTIONARY.toGodot(dictionary)
        }
        Bridge.engine_call_assign(ptr)
    }

    /**
     * Clear the dictionary, removing all key/value pairs.
     */
    override fun clear() {
        Bridge.engine_call_clear(ptr)
    }

    /**
     * Creates a copy of the dictionary, and returns it.
     * The deep parameter causes inner dictionaries and arrays to be copied recursively, but does not apply to objects.
     */
    @JvmOverloads
    fun duplicate(deep: Boolean = false): Dictionary<K, V> {
        @Suppress("UNCHECKED_CAST")
        return (VariantBuffer.transfer.callBridge(1, VariantParser.DICTIONARY) {
            VariantParser.BOOL.write(deep)
            Bridge.engine_call_duplicate(ptr)
        } as Dictionary<K, V>).also {
            it.keyVariantConverter = keyVariantConverter
            it.valueVariantConverter = valueVariantConverter
        }
    }

    /**
     * Duplicates this dictionary, deeply, like duplicate()(true), with extra control over how subresources are handled.
     * deepSubresourceMode must be one of the values from DeepDuplicateMode. By default, only internal resources will be duplicated (recursively).
     */
    @JvmOverloads
    fun duplicateDeep(deepSubresourceMode: DeepDuplicateMode = DeepDuplicateMode.INTERNAL): Dictionary<K, V> {
        return (VariantBuffer.transfer.callBridge(1, VariantParser.DICTIONARY) {
            VariantParser.LONG.write(deepSubresourceMode.value)
            Bridge.engine_call_duplicate_deep(ptr)
        } as Dictionary<K, V>).also {
            it.keyVariantConverter = keyVariantConverter
            it.valueVariantConverter = valueVariantConverter
        }
    }

    fun erase(key: K): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            keyVariantConverter.toGodot(key)
            Bridge.engine_call_erase(ptr)
        }
    }

    fun findKey(value: V): K? {
        return VariantBuffer.transfer.callBridge(1, keyVariantConverter.toNullable()) {
            valueVariantConverter.toGodot(value)
            Bridge.engine_call_find_key(ptr)
        }
    }

    /**
     * Returns the current value for the specified key in the Dictionary.
     * If the key does not exist, the method returns the value of the optional default argument, or null if it is omitted.
     */
    fun get(key: K, default: V?): V? {
        val nullableValueConverter = valueVariantConverter.toNullable()
        return VariantBuffer.transfer.callBridge(2, nullableValueConverter) {
            keyVariantConverter.toGodot(key)
            nullableValueConverter.toGodot(default)
            Bridge.engine_call_get(ptr)
        }
    }

    fun getOrAdd(key: K, default: V): V {
        return VariantBuffer.transfer.callBridge(2, valueVariantConverter) {
            keyVariantConverter.toGodot(key)
            valueVariantConverter.toGodot(default)
            Bridge.engine_call_get_or_add(ptr)
        }
    }

    fun getTypedKeyBuiltin() = keyVariantConverter.id

    fun getTypedKeyClassName(): StringName {
        return VariantBuffer.transfer.callBridge(VariantParser.STRING_NAME) { Bridge.engine_call_get_typed_key_class_name(ptr) }
    }

    fun getTypedKeyScript(): Any? {
        return VariantBuffer.transfer.callBridge(VariantCaster.ANY) { Bridge.engine_call_get_typed_key_script(ptr) }
    }

    fun getTypedValueBuiltin() = valueVariantConverter.id

    fun getTypedValueClassName(): StringName {
        return VariantBuffer.transfer.callBridge(VariantParser.STRING_NAME) { Bridge.engine_call_get_typed_value_class_name(ptr) }
    }

    fun getTypedValueScript(): Any? {
        return VariantBuffer.transfer.callBridge(VariantCaster.ANY) { Bridge.engine_call_get_typed_value_script(ptr) }
    }

    /**
     * Returns true if the dictionary has a given key.
     * Note: This is equivalent to using the in operator as follows:
     */
    fun has(key: K): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            keyVariantConverter.toGodot(key)
            Bridge.engine_call_has(ptr)
        }
    }

    /**
     * Returns true if the dictionary has all of the keys in the given array.
     */
    fun hasAll(keys: VariantArray<K>): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            VariantParser.ARRAY.toGodot(keys)
            Bridge.engine_call_hasAll(ptr)
        }
    }

    /**
     * Returns a hashed integer value representing the dictionary contents. This can be used to compare dictionaries by value
     */
    fun hash(): Int {
        return VariantBuffer.transfer.callBridge(VariantParser.LONG) { Bridge.engine_call_hash(ptr) }.toInt()
    }

    /**
     * Returns true if the dictionary is empty.
     */
    override fun isEmpty(): Boolean {
        return VariantBuffer.transfer.callBridge(VariantParser.BOOL) { Bridge.engine_call_is_empty(ptr) }
    }

    /**
     * Returns true if the dictionary is read-only. See [makeReadOnly]
     */
    fun isReadOnly(): Boolean {
        return VariantBuffer.transfer.callBridge(VariantParser.BOOL) { Bridge.engine_call_is_read_only(ptr) }
    }

    fun isSameTyped(dictionary: Dictionary<*, *>): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            VariantParser.DICTIONARY.toGodot(dictionary)
            Bridge.engine_call_is_same_typed(ptr)
        }
    }

    fun isSameTypedKey(dictionary: Dictionary<*, *>): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            VariantParser.DICTIONARY.toGodot(dictionary)
            Bridge.engine_call_is_same_typed_key(ptr)
        }
    }

    fun isSameTypedValue(dictionary: Dictionary<*, *>): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            VariantParser.DICTIONARY.toGodot(dictionary)
            Bridge.engine_call_is_same_typed_value(ptr)
        }
    }

    fun isTyped() = isTypedKey() || isTypedValue()

    fun isTypedKey() = keyVariantConverter.id != VariantParser.NIL.id

    fun isTypedValue() = valueVariantConverter.id != VariantParser.NIL.id

    /**
     * Returns the list of keys in the Dictionary.
     */
    fun keys(): VariantArray<K> {
        @Suppress("UNCHECKED_CAST")
        return (VariantBuffer.transfer.callBridge(VariantParser.ARRAY) {
            Bridge.engine_call_keys(ptr)
        } as VariantArray<K>).also {
            it.variantConverter = keyVariantConverter
        }
    }

    fun makeReadOnly() {
        Bridge.engine_call_make_read_only(ptr)
    }

    @JvmOverloads
    fun merge(dictionary: Dictionary<K, V>, overwrite: Boolean = false) {
        VariantBuffer.transfer.writeArgs(2) {
            VariantParser.DICTIONARY.toGodot(dictionary)
            VariantParser.BOOL.write(overwrite)
        }
        Bridge.engine_call_merge(ptr)
    }

    @JvmOverloads
    fun merged(dictionary: Dictionary<K, V>, overwrite: Boolean = false): Dictionary<K, V> {
        return (VariantBuffer.transfer.callBridge(2, VariantParser.DICTIONARY) {
            VariantParser.DICTIONARY.toGodot(dictionary)
            VariantParser.BOOL.write(overwrite)
            Bridge.engine_call_merged(ptr)
        } as Dictionary<K, V>).also {
            it.keyVariantConverter = keyVariantConverter
            it.valueVariantConverter = valueVariantConverter
        }
    }

    fun recursiveEqual(dictionary: Dictionary<*, *>, recursionCount: Int): Boolean {
        return VariantBuffer.transfer.callBridge(2, VariantParser.BOOL) {
            VariantParser.DICTIONARY.toGodot(dictionary)
            VariantParser.LONG.write(recursionCount.toLong())
            Bridge.engine_call_recursive_equal(ptr)
        }
    }

    operator fun set(key: K, value: V): Boolean {
        return VariantBuffer.transfer.callBridge(2, VariantParser.BOOL) {
            keyVariantConverter.toGodot(key)
            valueVariantConverter.toGodot(value)
            Bridge.engine_call_set(ptr)
        }
    }

    fun sort() {
        Bridge.engine_call_sort(ptr)
    }

    /**
     * Returns the list of values in the Dictionary.
     */
    fun values(): VariantArray<V> {
        @Suppress("UNCHECKED_CAST")
        return (VariantBuffer.transfer.callBridge(VariantParser.ARRAY) {
            Bridge.engine_call_values(ptr)
        } as VariantArray<V>).also {
            it.variantConverter = valueVariantConverter
        }
    }

    override fun containsKey(key: K) = contains(key)

    override fun containsValue(value: V): Boolean {
        values.forEach {
            if (it == value)
                return true
        }
        return false
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Dictionary<*, *>) {
            return false
        }
        return VariantBuffer.transfer.callBridge(2, VariantParser.BOOL) {
            VariantParser.DICTIONARY.toGodot(this)
            VariantParser.DICTIONARY.toGodot(other)
            Bridge.engine_call_equals(ptr)
        }
    }

    override operator fun get(key: K): V? = get(key, null)

    override fun hashCode(): Int = hash()

    override fun put(key: K, value: V): V? {
        val ret = get(key)
        set(key, value)
        return ret
    }

    override fun putAll(from: Map<out K, V>) {
        from.forEach {
            set(it.key, it.value)
        }
    }

    override fun remove(key: K): V? {
        val ret = get(key)
        erase(key)
        return ret
    }

    override fun toString(): String {
        return "Dictionary($size)"
    }

    @CoreTypeHelper
    inline fun <R> mutate(key: K, block: (V) -> R): R {
        val localCopy = getValue(key)
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

    operator fun contains(key: K): Boolean = has(key)

    @Suppress("FunctionName")
    private object Bridge {
        external fun engine_call_constructor(): VoidPtr
        external fun engine_call_constructor_typed(): VoidPtr
        external fun engine_call_copy_constructor(_handle: VoidPtr): VoidPtr

        external fun engine_call_assign(_handle: VoidPtr)
        external fun engine_call_clear(_handle: VoidPtr)
        external fun engine_call_duplicate(_handle: VoidPtr)
        external fun engine_call_duplicate_deep(_handle: VoidPtr)
        external fun engine_call_erase(_handle: VoidPtr)
        external fun engine_call_find_key(_handle: VoidPtr)
        external fun engine_call_get(_handle: VoidPtr)
        external fun engine_call_get_or_add(_handle: VoidPtr)
        external fun engine_call_get_typed_key_class_name(_handle: VoidPtr)
        external fun engine_call_get_typed_value_class_name(_handle: VoidPtr)
        external fun engine_call_get_typed_key_script(_handle: VoidPtr)
        external fun engine_call_get_typed_value_script(_handle: VoidPtr)
        external fun engine_call_has(_handle: VoidPtr)
        external fun engine_call_hasAll(_handle: VoidPtr)
        external fun engine_call_hash(_handle: VoidPtr)
        external fun engine_call_is_empty(_handle: VoidPtr)
        external fun engine_call_is_read_only(_handle: VoidPtr)
        external fun engine_call_is_same_typed(_handle: VoidPtr)
        external fun engine_call_is_same_typed_key(_handle: VoidPtr)
        external fun engine_call_is_same_typed_value(_handle: VoidPtr)
        external fun engine_call_keys(_handle: VoidPtr)
        external fun engine_call_make_read_only(_handle: VoidPtr)
        external fun engine_call_merge(_handle: VoidPtr)
        external fun engine_call_merged(_handle: VoidPtr)
        external fun engine_call_recursive_equal(_handle: VoidPtr)
        external fun engine_call_size(_handle: VoidPtr)
        external fun engine_call_sort(_handle: VoidPtr)
        external fun engine_call_values(_handle: VoidPtr)
        external fun engine_call_set(_handle: VoidPtr)
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
            return Dictionary<K, V>(K::class.java, V::class.java)
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
