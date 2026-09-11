@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.common.interop.VariantConverter
import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.util.IndexedIterator
import godot.common.interop.VoidPtr
import godot.common.interop.nullptr
import godot.common.util.isNullable
import godot.core.bridge.DeepDuplicateMode
import godot.internal.reflection.TypeManager
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.jvm.internal.Reflection
import kotlin.reflect.KClass


@Suppress("unused", "UNCHECKED_CAST")
class VariantArray<T> : NativeCoreType, MutableCollection<T> {

    internal var variantConverter: VariantConverter

    @PublishedApi
    internal constructor(handle: VoidPtr) : this(handle, VariantCaster.ANY)

    @PublishedApi
    internal constructor(handle: VoidPtr, converter: VariantConverter) {
        variantConverter = converter
        ptr = handle
        MemoryManager.registerNativeCoreType(this, VariantParser.ARRAY)
    }

    constructor(parameterClazz: Class<*>) : this(Reflection.getOrCreateKotlinClass(parameterClazz))


    constructor(converter: VariantConverter) {
        variantConverter = converter
        ptr = if (converter != VariantCaster.ANY) {
            TransferContext.writeArguments(
                VariantCaster.INT to converter.id,
                VariantCaster.INT to -1,
                VariantParser.LONG to nullptr
            )
            Bridge.engine_call_constructor_typed()
        } else {
            Bridge.engine_call_constructor()
        }
        MemoryManager.registerNativeCoreType(this, VariantParser.ARRAY)
    }

    @PublishedApi
    internal constructor(parameterClazz: KClass<*>) {
        val variantConverter = getVariantConverter(parameterClazz)

        if (GodotJvmBuildConfig.DEBUG) {
            checkNotNull(variantConverter) {
                "Can't create a VariantArray with generic ${parameterClazz}."
            }
        }

        this.variantConverter = variantConverter!!
        ptr = if (variantConverter != VariantCaster.ANY) {
            TransferContext.writeArguments(
                VariantCaster.INT to variantConverter.id,
                VariantCaster.INT to (TypeManager.engineTypeToId[parameterClazz] ?: -1),
                VariantParser.LONG to (TypeManager.userClassToScriptPtr[parameterClazz] ?: nullptr)
            )
            Bridge.engine_call_constructor_typed()
        } else {
            Bridge.engine_call_constructor()
        }
        MemoryManager.registerNativeCoreType(this, VariantParser.ARRAY)
    }

//########################PUBLIC###############################
    //PROPERTIES
    /**
     * Returns the number of elements in the array.
     */
    override val size: Int
        get() {
            Bridge.engine_call_size(ptr)
            return TransferContext.readReturnValue(VariantCaster.INT) as Int
        }

    /**
     * Create a shallow copy of the Array
     */
    constructor(other: VariantArray<T>) {
        this.variantConverter = other.variantConverter
        this.ptr = other.ptr
        MemoryManager.registerNativeCoreType(this, VariantParser.ARRAY)
    }

    //COMMON API
    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elements.forEach {
            append(it)
        }
        return true
    }

    /**
     * Clears the array. This is equivalent to using resize with a size of 0.
     */
    override fun clear() {
        Bridge.engine_call_clear(ptr)
    }

    /**
     * Returns true if the array is empty.
     */
    override fun isEmpty(): Boolean {
        Bridge.engine_call_isEmpty(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Returns true if the array is read-only.
     */
    fun isReadOnly(): Boolean {
        Bridge.engine_call_isReadOnly(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Returns `true` if the array is typed. Typed arrays can only store elements of their associated type and provide
     * type safety for the [get] operator.
     */
    fun isTyped(): Boolean {
        Bridge.engine_call_isTyped(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Returns a hashed integer value representing the array contents.
     */
    fun hash(): Int {
        Bridge.engine_call_hash(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Reverses the order of the elements in the array.
     */
    fun invert() {
        Bridge.engine_call_reverse(ptr)
    }

    override fun remove(element: T): Boolean {
        if (has(element)) {
            erase(element)
            return true
        }

        return false
    }

    /**
     * Removes an element from the array by index.
     */
    fun removeAt(position: Int) {
        TransferContext.writeArguments(VariantCaster.INT to position)
        Bridge.engine_call_removeAt(ptr)
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var ret = false
        elements.forEach {
            ret = remove(it) || ret
        }
        return ret
    }

    /**
     * Resizes the array to contain a different number of elements.
     * If the array size is smaller, elements are cleared, if bigger, new elements are null.
     */
    fun resize(size: Int) {
        TransferContext.writeArguments(VariantCaster.INT to size)
        Bridge.engine_call_resize(ptr)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var ret = false
        val iter = this.iterator()
        while (iter.hasNext()) {
            val value = iter.next()
            if (value !in elements) {
                iter.remove()
                ret = true
            }
        }
        return ret
    }

    /**
     * Shuffles the array such that the items will have a random order.
     * This method uses the global random number generator common to methods such as @randi.
     * Call @randomize to ensure that a new seed will be used each time if you want non-reproducible shuffling.
     */
    fun shuffle() {
        Bridge.engine_call_shuffle(ptr)
    }


    /**
     * Sorts the array.
     */
    fun sort() {
        Bridge.engine_call_sort(ptr)
    }

    /**
     * Sorts the array using a custom method. The arguments are an object that holds the method and the name of such method.
     * The custom method receives two arguments (a pair of elements from the array) and must return either true or false.
     */
    fun sortCustom(obj: KtObject, func: String) {
        TransferContext.writeArguments(VariantParser.OBJECT to obj, VariantParser.STRING to func)
        Bridge.engine_call_sortCustom(ptr)
    }

    //API

    /**
     * Calls the provided [Callable] on each element in the array and returns `true` if the Callable returns `true` for
     * all elements in the array. If the [Callable] returns `false` for one array element or more, this method returns
     * `false`.
     *
     * The callable's method should take one Variant parameter (the current array element) and return a boolean value.
     *
     * See also [any], [filter], [map] and [reduce].
     *
     * **Note**: Unlike relying on the size of an array returned by [filter], this method will return as early as possible
     * to improve performance (especially with large arrays).
     *
     * **Note**: For an empty array, this method always returns `true`.
     */
    fun all(callable: Callable): Boolean {
        TransferContext.writeArguments(VariantParser.CALLABLE to callable)
        Bridge.engine_call_all(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Calls the provided [Callable] on each element in the array and returns `true` if the Callable returns `true` for
     * one or more elements in the array. If the [Callable] returns `false` for all elements in the array, this method
     * returns `false`.
     *
     * The callable's method should take one Variant parameter (the current array element) and return a boolean value.
     *
     * See also [all], [filter], [map] and [reduce].
     *
     * Note: Unlike relying on the size of an array returned by filter, this method will return as early as possible to
     * improve performance (especially with large arrays).
     *
     * Note: For an empty array, this method always returns `false`.
     */
    fun any(callable: Callable): Boolean {
        TransferContext.writeArguments(VariantParser.CALLABLE to callable)
        Bridge.engine_call_any(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Appends an element at the end of the array (alias of push_back).
     */
    fun append(value: T) {
        TransferContext.writeArguments(variantConverter to value)
        Bridge.engine_call_append(ptr)
    }

    /**
     * Appends another array at the end of this array.
     */
    fun appendArray(array: VariantArray<T>) {
        TransferContext.writeArguments(VariantParser.ARRAY to array)
        Bridge.engine_call_appendArray(ptr)
    }

    /**
     * Returns the last element of the array. Prints an error and returns `null` if the array is empty.
     */
    fun back(): T {
        Bridge.engine_call_back(ptr)
        return TransferContext.readReturnValue(variantConverter) as T
    }

    /**
     * Finds the index of an existing value (or the insertion index that maintains sorting order, if the value is not yet present in the array) using binary search.
     * Optionally, a before specifier can be passed.
     * If false, the returned index comes after all existing entries of the value in the array.
     * Note: Calling bsearch on an unsorted array results in unexpected behavior.
     */
    @JvmOverloads
    fun bsearch(value: T, before: Boolean = true): Int {
        TransferContext.writeArguments(variantConverter to value, VariantParser.BOOL to before)
        Bridge.engine_call_bsearch(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Finds the index of an existing value (or the insertion index that maintains sorting order, if the value is not yet present in the array) using binary search and a custom comparison method.
     * Optionally, a before specifier can be passed.
     * If false, the returned index comes after all existing entries of the value in the array.
     * The custom method receives two arguments (an element from the array and the value searched for) and must return true if the first argument is less than the second, and return false otherwise.
     * Note: Calling bsearch on an unsorted array results in unexpected behavior.
     */
    @JvmOverloads
    fun bsearchCustom(value: T, obj: KtObject, func: String, before: Boolean = true): Int {
        TransferContext.writeArguments(
            variantConverter to value, VariantParser.OBJECT to obj,
            VariantParser.STRING to func, VariantParser.BOOL to before
        )
        Bridge.engine_call_bsearchCustom(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Returns the number of times an element is in the array.
     */
    fun count(value: T): Int {
        TransferContext.writeArguments(variantConverter to value)
        Bridge.engine_call_count(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }


    /**
     * Returns a copy of the array.
     * If deep is true, a deep copy is performed:
     * all nested arrays and dictionaries are duplicated and will not be shared with the original array.
     * If false, a shallow copy is made and references to the original nested arrays and dictionaries are kept, so that modifying a sub-array or dictionary in the copy will also impact those referenced in the source array.
     */
    fun duplicate(deep: Boolean): VariantArray<T> {
        TransferContext.writeArguments(VariantParser.BOOL to deep)
        Bridge.engine_call_duplicate(ptr)
        return (TransferContext.readReturnValue(VariantParser.ARRAY) as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }

    /**
     * Duplicates this array, deeply, like duplicate()(true), with extra control over how subresources are handled.
     * deepSubresourceMode must be one of the values from DeepDuplicateMode. By default, only internal resources will be duplicated (recursively).
    */
    fun duplicateDeep(deepSubresourceMode: DeepDuplicateMode): VariantArray<T> {
        TransferContext.writeArguments(VariantParser.LONG to deepSubresourceMode.value)
        Bridge.engine_call_duplicate_deep(ptr)
        return (TransferContext.readReturnValue(VariantParser.ARRAY) as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }

    /**
     * Removes the first occurrence of a value from the array.
     */
    fun erase(value: T) {
        TransferContext.writeArguments(variantConverter to value)
        Bridge.engine_call_erase(ptr)
    }

    /**
     * Assigns the given value to all elements in the array. This can typically be used together with [resize] to create
     * an array with a given size and initialized elements.
     *
     * **Note**: If value is of a reference type ([Object]-derived, [VariantArray], [Dictionary], etc.) then the array is
     * filled with the references to the same object, i.e. no duplicates are created.
     */
    fun fill(value: T) {
        TransferContext.writeArguments(variantConverter to value)
        Bridge.engine_call_fill(ptr)
    }

    /**
     * Calls the provided [Callable] on each element in the array and returns a new array with the elements for which
     * the method returned `true`.
     *
     * The callable's method should take one Variant parameter (the current array element) and return a boolean value.
     *
     * See also [any], [all], [map] and [reduce].
     */
    fun filter(callable: Callable): VariantArray<T> {
        TransferContext.writeArguments(VariantParser.CALLABLE to callable)
        Bridge.engine_call_filter(ptr)
        return (TransferContext.readReturnValue(VariantParser.ARRAY) as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }

    /**
     * Searches the array for a value and returns its index or -1 if not found.
     * Optionally, the initial search index can be passed.
     */
    fun find(what: T, from: Int): Int {
        TransferContext.writeArguments(variantConverter to what, VariantCaster.INT to from)
        Bridge.engine_call_find(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Returns the first element of the array, or null if the array is empty.
     */
    fun front(): T? {
        Bridge.engine_call_front(ptr)
        return TransferContext.readReturnValue(variantConverter) as T?
    }

    /**
     * Returns the [VariantParser] constant for a typed array. If the [VariantArray] is not typed, returns [VariantParser.NIL].
     */
    fun getTypedBuiltin() = variantConverter.id

    /**
     * Returns a class name of a typed [VariantArray] of type [VariantParser.OBJECT].
     */
    fun getTypedClassName(): StringName {
        Bridge.engine_call_getTypedClassName(ptr)
        return TransferContext.readReturnValue(VariantParser.STRING_NAME) as StringName
    }

    /**
     * Returns the script associated with a typed array tied to a class name.
     */
    fun getTypedScript(): Any {
        Bridge.engine_call_getTypedScript(ptr)
        return TransferContext.readReturnValue(VariantCaster.ANY) as Any
    }

    /**
     * Returns true if the array contains the given value.
     */
    fun has(value: T): Boolean {
        TransferContext.writeArguments(variantConverter to value)
        Bridge.engine_call_has(ptr)
        return TransferContext.readReturnValue(VariantParser.BOOL) as Boolean
    }

    /**
     * Inserts a new element at a given position in the array.
     * The position must be valid, or at the end of the array (pos == size()).
     */
    fun insert(position: Int, value: T) {
        TransferContext.writeArguments(VariantCaster.INT to position, variantConverter to value)
        Bridge.engine_call_insert(ptr)
    }

    /**
     * Calls the provided [Callable] for each element in the array and returns a new array filled with values returned
     * by the method.
     *
     * The callable's method should take one Variant parameter (the current array element) and can return any Variant.
     */
    fun map(callable: Callable): VariantArray<Any?> {
        TransferContext.writeArguments(VariantParser.CALLABLE to callable)
        Bridge.engine_call_map(ptr)
        return (TransferContext.readReturnValue(VariantParser.ARRAY) as VariantArray<Any?>).also {
            it.variantConverter = VariantCaster.ANY
        }
    }

    /**
     * Returns the maximum value contained in the array if all elements are of comparable types.
     * If the elements can't be compared, null is returned.
     */
    fun max(): T? {
        Bridge.engine_call_max(ptr)
        return TransferContext.readReturnValue(variantConverter) as T?
    }

    /**
     * Returns the minimum value contained in the array if all elements are of comparable types.
     * If the elements can't be compared, null is returned.
     */
    fun min(): T? {
        Bridge.engine_call_min(ptr)
        return TransferContext.readReturnValue(variantConverter) as T?
    }

    /**
     * Returns a random value from the target array.
     */
    fun pickRandom(): T? {
        Bridge.engine_call_pickRandom(ptr)
        return TransferContext.readReturnValue(variantConverter) as T?
    }

    /**
     * Removes and returns the last element of the array.
     * Returns null if the array is empty.
     */
    fun popBack(): T? {
        Bridge.engine_call_popBack(ptr)
        return TransferContext.readReturnValue(variantConverter) as T?
    }

    /**
     * Removes and returns the first element of the array.
     * Returns null if the array is empty.
     */
    fun popFront(): T? {
        Bridge.engine_call_popFront(ptr)
        return TransferContext.readReturnValue(variantConverter) as T?
    }

    /**
     * Appends an element at the end of the array.
     */
    fun pushBack(value: T) {
        TransferContext.writeArguments(variantConverter to value)
        Bridge.engine_call_pushBack(ptr)
    }

    /**
     * Adds an element at the beginning of the array
     */
    fun pushFront(value: T) {
        TransferContext.writeArguments(variantConverter to value)
        Bridge.engine_call_pushFront(ptr)
    }

    fun reduce(callable: Callable, accum: Any?): Any? {
        TransferContext.writeArguments(VariantParser.CALLABLE to callable, VariantCaster.ANY to accum)
        Bridge.engine_call_reduce(ptr)
        return TransferContext.readReturnValue(VariantCaster.ANY)
    }

    /**
     * Searches the array in reverse order.
     * Optionally, a start search index can be passed.
     * If negative, the start index is considered relative to the end of the array.
     */
    fun rfind(what: T, from: Int): Int {
        TransferContext.writeArguments(variantConverter to what, VariantCaster.INT to from)
        Bridge.engine_call_rfind(ptr)
        return TransferContext.readReturnValue(VariantCaster.INT) as Int
    }

    /**
     * Returns the slice of the [VariantArray], from begin (inclusive) to end (exclusive), as a new [VariantArray].
     *
     * The absolute value of `begin` and `end` will be clamped to the array size, so the default value for `end makes
     * it slice to the size of the array by default (i.e. `arr.slice(1)` is a shorthand for `arr.slice(1, arr.size())`).
     *
     * If either `begin` or `end` are negative, they will be relative to the end of the array (i.e. `arr.slice(0, -2)`
     * is a shorthand for `arr.slice(0, arr.size() - 2)`).
     *
     * If deep is `true`, each element will be copied by value rather than by reference.
     */
    fun slice(begin: Int, end: Int, step: Int, deep: Boolean): VariantArray<T> {
        TransferContext.writeArguments(
            VariantCaster.INT to begin, VariantCaster.INT to end,
            VariantCaster.INT to step, VariantParser.BOOL to deep
        )
        Bridge.engine_call_slice(ptr)
        return (TransferContext.readReturnValue(VariantParser.ARRAY) as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }


    //UTILITIES
    operator fun set(idx: Int, data: T) {
        TransferContext.writeArguments(VariantCaster.INT to idx, variantConverter to data)
        Bridge.engine_call_operator_set(ptr)
    }

    @CoreTypeHelper
    inline fun <R> mutate(idx: Int, block: (T) -> R): R {
        val localCopy = this[idx]
        val ret = block(localCopy)
        this[idx] = localCopy
        return ret
    }

    @CoreTypeHelper
    inline fun mutateEach(block: (index: Int, value: T) -> Unit) {
        forEachIndexed { index, value ->
            block(index, value)
            this[index] = value
        }
    }

    operator fun get(idx: Int): T {
        TransferContext.writeArguments(VariantCaster.INT to idx)
        Bridge.engine_call_operator_get(ptr)
        return TransferContext.readReturnValue(variantConverter) as T
    }

    operator fun plus(other: T) {
        this.append(other)
    }

    override operator fun contains(element: T) = has(element)

    override fun containsAll(elements: Collection<T>): Boolean {
        elements.forEach {
            if (!has(it)) return false
        }
        return true
    }

    override fun iterator(): MutableIterator<T> {
        return IndexedIterator(this::size, this::get, this::removeAt)
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is VariantArray<*>) {
            val list1 = this.toList()
            val list2 = other.toList()
            list1 == list2
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return ptr.hashCode()
    }

    override fun toString(): String {
        return "Array(${size})"
    }


    @Suppress("FunctionName")
    private object Bridge {
        external fun engine_call_constructor(): VoidPtr
        external fun engine_call_constructor_typed(): VoidPtr

        external fun engine_call_all(_handle: VoidPtr)
        external fun engine_call_any(_handle: VoidPtr)
        external fun engine_call_append(_handle: VoidPtr)
        external fun engine_call_appendArray(_handle: VoidPtr)
        external fun engine_call_back(_handle: VoidPtr)
        external fun engine_call_bsearch(_handle: VoidPtr)
        external fun engine_call_bsearchCustom(_handle: VoidPtr)
        external fun engine_call_clear(_handle: VoidPtr)
        external fun engine_call_count(_handle: VoidPtr)
        external fun engine_call_duplicate(_handle: VoidPtr)
        external fun engine_call_duplicate_deep(_handle: VoidPtr)
        external fun engine_call_erase(_handle: VoidPtr)
        external fun engine_call_fill(_handle: VoidPtr)
        external fun engine_call_filter(_handle: VoidPtr)
        external fun engine_call_find(_handle: VoidPtr)
        external fun engine_call_front(_handle: VoidPtr)
        external fun engine_call_getTypedClassName(_handle: VoidPtr)
        external fun engine_call_getTypedScript(_handle: VoidPtr)
        external fun engine_call_has(_handle: VoidPtr)
        external fun engine_call_hash(_handle: VoidPtr)
        external fun engine_call_insert(_handle: VoidPtr)
        external fun engine_call_isEmpty(_handle: VoidPtr)
        external fun engine_call_isReadOnly(_handle: VoidPtr)
        external fun engine_call_isTyped(_handle: VoidPtr)
        external fun engine_call_map(_handle: VoidPtr)
        external fun engine_call_max(_handle: VoidPtr)
        external fun engine_call_min(_handle: VoidPtr)
        external fun engine_call_pickRandom(_handle: VoidPtr)
        external fun engine_call_popAt(_handle: VoidPtr)
        external fun engine_call_popBack(_handle: VoidPtr)
        external fun engine_call_popFront(_handle: VoidPtr)
        external fun engine_call_pushBack(_handle: VoidPtr)
        external fun engine_call_pushFront(_handle: VoidPtr)
        external fun engine_call_reduce(_handle: VoidPtr)
        external fun engine_call_removeAt(_handle: VoidPtr)
        external fun engine_call_resize(_handle: VoidPtr)
        external fun engine_call_reverse(_handle: VoidPtr)
        external fun engine_call_rfind(_handle: VoidPtr)
        external fun engine_call_shuffle(_handle: VoidPtr)
        external fun engine_call_size(_handle: VoidPtr)
        external fun engine_call_slice(_handle: VoidPtr)
        external fun engine_call_sort(_handle: VoidPtr)
        external fun engine_call_sortCustom(_handle: VoidPtr)
        external fun engine_call_operator_set(_handle: VoidPtr)
        external fun engine_call_operator_get(_handle: VoidPtr)
    }

    companion object {
        inline operator fun <reified T> invoke(): VariantArray<T> {
            // The nullable check can't be inside the regular constructor because of Java
            if (GodotJvmBuildConfig.DEBUG) {
                if (hasInvalidNullability<T>()) {
                    error("Can't create a VariantArray with generic ${T::class} as nullable.")
                }
            }
            return VariantArray(T::class)
        }
    }
}

//HELPER
inline fun <reified T> variantArrayOf(vararg args: T) = VariantArray<T>().also { it.addAll(args) }

/**
 * Convert an iterable into a GodotArray
 * Warning: Might be slow if the iterable contains a lot of items because can only append items one by one
 */
inline fun <reified T> Iterable<T>.toVariantArray() = VariantArray<T>().also { arr ->
    forEach {
        arr.append(it)
    }
}
