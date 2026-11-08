@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.common.interop.VariantConverter
import godot.internal.memory.MemoryManager
import godot.internal.memory.VariantBuffer
import godot.common.util.IndexedIterator
import godot.common.interop.VoidPtr
import godot.common.interop.nullptr
import godot.common.util.isNullable
import godot.core.bridge.DeepDuplicateMode
import godot.internal.reflection.TypeManager
import kotlincompile.definitions.GodotJvmBuildConfig

@Suppress("unused", "UNCHECKED_CAST")
class VariantArray<T> : NativeCoreType, MutableCollection<T> {

    /**
     * Returns the number of elements in the array.
     */
    override val size: Int
        get() {
            return VariantBuffer.transfer.callBridge(VariantParser.LONG) { Bridge.engine_call_size(ptr) }.toInt()
        }

    internal var variantConverter: VariantConverter<T>

    @PublishedApi
    internal constructor(handle: VoidPtr) : this(handle, VariantCaster.ANY as VariantConverter<T>)

    @PublishedApi
    internal constructor(handle: VoidPtr, converter: VariantConverter<T>) {
        variantConverter = converter
        ptr = handle
        MemoryManager.registerNativeCoreType(this, VariantParser.ARRAY)
    }

    constructor(converter: VariantConverter<T>) {
        variantConverter = converter
        ptr = if (converter != VariantCaster.ANY) {
            VariantBuffer.transfer.writeArgs(3) {
                VariantParser.LONG.write(converter.id.toLong())
                VariantParser.LONG.write((-1).toLong())
                VariantParser.LONG.write(nullptr)
            }
            Bridge.engine_call_constructor_typed()
        } else {
            Bridge.engine_call_constructor()
        }
        MemoryManager.registerNativeCoreType(this, VariantParser.ARRAY)
    }

    constructor(parameterClazz: Class<*>) {
        val variantConverter = getVariantConverter(parameterClazz)

        if (GodotJvmBuildConfig.DEBUG) {
            checkNotNull(variantConverter) {
                "Can't create a VariantArray with generic ${parameterClazz}."
            }
        }

        this.variantConverter = variantConverter as VariantConverter<T>
        ptr = if (variantConverter != VariantCaster.ANY) {
            VariantBuffer.transfer.writeArgs(3) {
                VariantParser.LONG.write(variantConverter.id.toLong())
                VariantParser.LONG.write(((TypeManager.engineTypeToId[parameterClazz] ?: -1)).toLong())
                VariantParser.LONG.write((TypeManager.classToScriptPtr[parameterClazz] ?: nullptr))
            }
            Bridge.engine_call_constructor_typed()
        } else {
            Bridge.engine_call_constructor()
        }
        MemoryManager.registerNativeCoreType(this, VariantParser.ARRAY)
    }

    /**
     * Create a shallow copy of the Array
     */
    constructor(other: VariantArray<T>) {
        this.variantConverter = other.variantConverter
        this.ptr = Bridge.engine_call_copy_constructor(other.ptr)
        MemoryManager.registerNativeCoreType(this, VariantParser.ARRAY)
    }

    /**
     * Calls the given [Callable] on each element in the array and returns `true` if the [Callable] returns `true` for
     * all elements in the array. If the [Callable] returns `false` for one array element or more, this method returns
     * `false`.
     *
     * The method should take one parameter (the current array element) and return a `Boolean`.
     *
     * See also [any], [filter], [map] and [reduce].
     *
     * **Note**: Unlike relying on the size of an array returned by [filter], this method will return as early as
     * possible to improve performance (especially with large arrays).
     *
     * **Note**: For an empty array, this method always returns `true`.
     *
     * **Performance**: Godot calls [method] up to once per element. When it is a JVM lambda or method, every call
     * crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such
     * as `all`.
     */
    fun all(method: Callable1<Boolean, T>) = allUnsafe(method)

    /**
     * Calls the given [Callable] on each element in the array and returns `true` if the [Callable] returns `true` for
     * all elements in the array. If the [Callable] returns `false` for one array element or more, this method returns
     * `false`.
     *
     * The method should take one parameter (the current array element) and return a `Boolean`.
     *
     * See also [any], [filter], [map] and [reduce].
     *
     * **Note**: Unlike relying on the size of an array returned by [filter], this method will return as early as
     * possible to improve performance (especially with large arrays).
     *
     * **Note**: For an empty array, this method always returns `true`.
     *
     * **Performance**: Godot calls [callable] up to once per element. When it is a JVM lambda or method, every call
     * crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such
     * as `all`.
     */
    fun allUnsafe(callable: Callable): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            VariantParser.CALLABLE.toGodot(callable)
            Bridge.engine_call_all(ptr)
        }
    }

    /**
     * Calls the given [Callable] on each element in the array and returns `true` if the [Callable] returns `true` for
     * one or more elements in the array. If the [Callable] returns `false` for all elements in the array, this method
     * returns `false`.
     *
     * The method should take one parameter (the current array element) and return a `Boolean`.
     *
     * See also [all], [filter], [map] and [reduce].
     *
     * **Note**: Unlike relying on the size of an array returned by [filter], this method will return as early as
     * possible to improve performance (especially with large arrays).
     *
     * **Note**: For an empty array, this method always returns `false`.
     *
     * **Performance**: Godot calls [method] up to once per element. When it is a JVM lambda or method, every call
     * crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such
     * as `any`.
     */
    fun any(method: Callable1<Boolean, T>) = anyUnsafe(method)

    /**
     * Calls the given [Callable] on each element in the array and returns `true` if the [Callable] returns `true` for
     * one or more elements in the array. If the [Callable] returns `false` for all elements in the array, this method
     * returns `false`.
     *
     * The method should take one parameter (the current array element) and return a `Boolean`.
     *
     * See also [all], [filter], [map] and [reduce].
     *
     * **Note**: Unlike relying on the size of an array returned by [filter], this method will return as early as
     * possible to improve performance (especially with large arrays).
     *
     * **Note**: For an empty array, this method always returns `false`.
     *
     * **Performance**: Godot calls [callable] up to once per element. When it is a JVM lambda or method, every call
     * crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such
     * as `any`.
     */
    fun anyUnsafe(callable: Callable): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            VariantParser.CALLABLE.toGodot(callable)
            Bridge.engine_call_any(ptr)
        }
    }

    /**
     * Appends an element at the end of the array (alias of push_back).
     */
    fun append(value: T) {
        VariantBuffer.transfer.writeArgs(1) {
            variantConverter.toGodot(value)
        }
        Bridge.engine_call_append(ptr)
    }

    /**
     * Appends another array at the end of this array.
     */
    fun appendArray(array: VariantArray<T>) {
        VariantBuffer.transfer.writeArgs(1) {
            VariantParser.ARRAY.toGodot(array)
        }
        Bridge.engine_call_appendArray(ptr)
    }

    fun assign(array: VariantArray<*>) {
        VariantBuffer.transfer.writeArgs(1) {
            VariantParser.ARRAY.toGodot(array)
        }
        Bridge.engine_call_assign(ptr)
    }

    /**
     * Returns the last element of the array. Prints an error and returns `null` if the array is empty.
     */
    fun back(): T? {
        return VariantBuffer.transfer.callBridge(variantConverter.toNullable()) { Bridge.engine_call_back(ptr) }
    }

    /**
     * Finds the index of an existing value (or the insertion index that maintains sorting order, if the value is not yet present in the array) using binary search.
     * Optionally, a before specifier can be passed.
     * If false, the returned index comes after all existing entries of the value in the array.
     * Note: Calling bsearch on an unsorted array results in unexpected behavior.
     */
    @JvmOverloads
    fun bsearch(value: T, before: Boolean = true): Int {
        return VariantBuffer.transfer.callBridge(2, VariantParser.LONG) {
            variantConverter.toGodot(value)
            VariantParser.BOOL.write(before)
            Bridge.engine_call_bsearch(ptr)
        }.toInt()
    }

    /**
     * Returns the index of [value] in the sorted array. If it cannot be found, returns where [value] should be inserted
     * to keep the array sorted (using [func] for the comparisons). The algorithm used is binary search.
     *
     * Similar to [sortCustom], [func] is called as many times as necessary, receiving one array element and [value] as
     * arguments. The function should return `true` if the array element should be behind [value], otherwise it should
     * return `false`.
     *
     * If [before] is `true` (as by default), the returned index comes before all existing elements equal to [value] in
     * the array.
     *
     * **Note**: Calling [bsearchCustom] on an unsorted array will result in unexpected behavior. Use [sortCustom] with
     * [func] before calling this method.
     */
    @JvmOverloads
    fun bsearchCustom(value: T, func: Callable2<Boolean, T, T>, before: Boolean = true) =
        bsearchCustomUnsafe(value, func, before)

    /**
     * Returns the index of [value] in the sorted array. If it cannot be found, returns where [value] should be inserted
     * to keep the array sorted (using [func] for the comparisons). The algorithm used is binary search.
     *
     * Similar to [sortCustom], [func] is called as many times as necessary, receiving one array element and [value] as
     * arguments. The function should return `true` if the array element should be behind [value], otherwise it should
     * return `false`.
     *
     * If [before] is `true` (as by default), the returned index comes before all existing elements equal to [value] in
     * the array.
     *
     * **Note**: Calling [bsearchCustom] on an unsorted array will result in unexpected behavior. Use [sortCustom] with
     * [func] before calling this method.
     */
    @JvmOverloads
    fun bsearchCustomUnsafe(value: T, func: Callable, before: Boolean = true): Int {
        return VariantBuffer.transfer.callBridge(3, VariantParser.LONG) {
            variantConverter.toGodot(value)
            VariantParser.CALLABLE.toGodot(func)
            VariantParser.BOOL.write(before)
            Bridge.engine_call_bsearchCustom(ptr)
        }.toInt()
    }

    /**
     * Clears the array. This is equivalent to using resize with a size of 0.
     */
    override fun clear() {
        Bridge.engine_call_clear(ptr)
    }

    /**
     * Returns the number of times an element is in the array.
     */
    fun count(value: T): Int {
        return VariantBuffer.transfer.callBridge(1, VariantParser.LONG) {
            variantConverter.toGodot(value)
            Bridge.engine_call_count(ptr)
        }.toInt()
    }

    /**
     * Returns a copy of the array.
     * If deep is true, a deep copy is performed:
     * all nested arrays and dictionaries are duplicated and will not be shared with the original array.
     * If false, a shallow copy is made and references to the original nested arrays and dictionaries are kept, so that modifying a sub-array or dictionary in the copy will also impact those referenced in the source array.
     */
    @JvmOverloads
    fun duplicate(deep: Boolean = false): VariantArray<T> {
        return (VariantBuffer.transfer.callBridge(1, VariantParser.ARRAY) {
            VariantParser.BOOL.write(deep)
            Bridge.engine_call_duplicate(ptr)
        } as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }

    /**
     * Duplicates this array, deeply, like duplicate()(true), with extra control over how subresources are handled.
     * deepSubresourceMode must be one of the values from DeepDuplicateMode. By default, only internal resources will be duplicated (recursively).
    */
    @JvmOverloads
    fun duplicateDeep(deepSubresourceMode: DeepDuplicateMode = DeepDuplicateMode.INTERNAL): VariantArray<T> {
        return (VariantBuffer.transfer.callBridge(1, VariantParser.ARRAY) {
            VariantParser.LONG.write(deepSubresourceMode.value)
            Bridge.engine_call_duplicate_deep(ptr)
        } as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }

    /**
     * Removes the first occurrence of a value from the array.
     */
    fun erase(value: T) {
        VariantBuffer.transfer.writeArgs(1) {
            variantConverter.toGodot(value)
        }
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
        VariantBuffer.transfer.writeArgs(1) {
            variantConverter.toGodot(value)
        }
        Bridge.engine_call_fill(ptr)
    }

    /**
     * Calls the given [Callable] on each element in the array and returns a new, filtered array.
     *
     * The method receives one of the array elements as an argument, and should return `true` to add the element to the
     * filtered array, or `false` to exclude it.
     *
     * See also [any], [all], [map] and [reduce].
     *
     * **Performance**: Godot calls [method] once per element. When it is a JVM lambda or method, every call crosses
     * from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such as
     * `filter`.
     */
    fun filter(method: Callable1<Boolean, T>) = filterUnsafe(method)

    /**
     * Calls the given [Callable] on each element in the array and returns a new, filtered array.
     *
     * The method receives one of the array elements as an argument, and should return `true` to add the element to the
     * filtered array, or `false` to exclude it.
     *
     * See also [any], [all], [map] and [reduce].
     *
     * **Performance**: Godot calls [callable] once per element. When it is a JVM lambda or method, every call crosses
     * from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such as
     * `filter`.
     */
    fun filterUnsafe(callable: Callable): VariantArray<T> {
        return (VariantBuffer.transfer.callBridge(1, VariantParser.ARRAY) {
            VariantParser.CALLABLE.toGodot(callable)
            Bridge.engine_call_filter(ptr)
        } as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }

    /**
     * Searches the array for a value and returns its index or -1 if not found.
     * Optionally, the initial search index can be passed.
     */
    @JvmOverloads
    fun find(what: T, from: Int = 0): Int {
        return VariantBuffer.transfer.callBridge(2, VariantParser.LONG) {
            variantConverter.toGodot(what)
            VariantParser.LONG.write(from.toLong())
            Bridge.engine_call_find(ptr)
        }.toInt()
    }

    /**
     * Returns the index of the first element in the array that causes [method] to return `true`, or -1 if there are
     * none. The search's start can be specified with [from], continuing to the end of the array.
     *
     * [method] is a callable that takes an element of the array, and returns a `Boolean`.
     *
     * **Note**: If you just want to know whether the array contains anything that satisfies [method], use [any].
     *
     * **Performance**: Godot calls [method] up to once per element. When it is a JVM lambda or method, every call
     * crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such
     * as `indexOfFirst`.
     */
    @JvmOverloads
    fun findCustom(method: Callable1<Boolean, T>, from: Int = 0) = findCustomUnsafe(method, from)

    /**
     * Returns the index of the first element in the array that causes [method] to return `true`, or -1 if there are
     * none. The search's start can be specified with [from], continuing to the end of the array.
     *
     * [method] is a callable that takes an element of the array, and returns a `Boolean`.
     *
     * **Note**: If you just want to know whether the array contains anything that satisfies [method], use [any].
     *
     * **Performance**: Godot calls [method] up to once per element. When it is a JVM lambda or method, every call
     * crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such
     * as `indexOfFirst`.
     */
    @JvmOverloads
    fun findCustomUnsafe(method: Callable, from: Int = 0): Int {
        return VariantBuffer.transfer.callBridge(2, VariantParser.LONG) {
            VariantParser.CALLABLE.toGodot(method)
            VariantParser.LONG.write(from.toLong())
            Bridge.engine_call_find_custom(ptr)
        }.toInt()
    }

    /**
     * Returns the first element of the array, or null if the array is empty.
     */
    fun front(): T? {
        return VariantBuffer.transfer.callBridge(variantConverter.toNullable()) { Bridge.engine_call_front(ptr) }
    }

    operator fun get(idx: Int): T {
        return VariantBuffer.transfer.callBridge(1, variantConverter) {
            VariantParser.LONG.write(idx.toLong())
            Bridge.engine_call_operator_get(ptr)
        } as T
    }

    /**
     * Returns the [VariantParser] constant for a typed array. If the [VariantArray] is not typed, returns [VariantParser.NIL].
     */
    fun getTypedBuiltin() = variantConverter.id

    /**
     * Returns a class name of a typed [VariantArray] of type [VariantParser.OBJECT].
     */
    fun getTypedClassName(): StringName {
        return VariantBuffer.transfer.callBridge(VariantParser.STRING_NAME) { Bridge.engine_call_getTypedClassName(ptr) } as StringName
    }

    /**
     * Returns the script associated with a typed array tied to a class name.
     */
    fun getTypedScript(): Any? {
        return VariantBuffer.transfer.callBridge(VariantCaster.ANY) { Bridge.engine_call_getTypedScript(ptr) }
    }

    /**
     * Returns true if the array contains the given value.
     */
    fun has(value: T): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            variantConverter.toGodot(value)
            Bridge.engine_call_has(ptr)
        }
    }

    /**
     * Returns a hashed integer value representing the array contents.
     */
    fun hash(): Int {
        return VariantBuffer.transfer.callBridge(VariantParser.LONG) { Bridge.engine_call_hash(ptr) }.toInt()
    }

    /**
     * Inserts a new element at a given position in the array.
     * The position must be valid, or at the end of the array (pos == size()).
     */
    fun insert(position: Int, value: T): Error {
        return Error.from(VariantBuffer.transfer.callBridge(2, VariantParser.LONG) {
            VariantParser.LONG.write(position.toLong())
            variantConverter.toGodot(value)
            Bridge.engine_call_insert(ptr)
        })
    }

    /**
     * Returns true if the array is empty.
     */
    override fun isEmpty(): Boolean {
        return VariantBuffer.transfer.callBridge(VariantParser.BOOL) { Bridge.engine_call_isEmpty(ptr) }
    }

    /**
     * Returns true if the array is read-only.
     */
    fun isReadOnly(): Boolean {
        return VariantBuffer.transfer.callBridge(VariantParser.BOOL) { Bridge.engine_call_isReadOnly(ptr) }
    }

    fun isSameTyped(array: VariantArray<*>): Boolean {
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            VariantParser.ARRAY.toGodot(array)
            Bridge.engine_call_is_same_typed(ptr)
        }
    }

    /**
     * Returns `true` if the array is typed. Typed arrays can only store elements of their associated type and provide
     * type safety for the [get] operator.
     */
    fun isTyped() = variantConverter.id != VariantParser.NIL.id

    fun makeReadOnly() {
        Bridge.engine_call_make_read_only(ptr)
    }

    /**
     * Calls the given [Callable] for each element in the array and returns a new array filled with values returned by
     * the method.
     *
     * The method should take one parameter (the current array element) and can return any Variant.
     *
     * See also [filter], [reduce], [any] and [all].
     *
     * **Performance**: Godot calls [method] once per element. When it is a JVM lambda or method, every call crosses
     * from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such as `map`.
     */
    fun map(method: Callable1<*, T>) = mapUnsafe(method)

    /**
     * Calls the given [Callable] for each element in the array and returns a new array filled with values returned by
     * the method.
     *
     * The method should take one parameter (the current array element) and can return any Variant.
     *
     * See also [filter], [reduce], [any] and [all].
     *
     * **Performance**: Godot calls [callable] once per element. When it is a JVM lambda or method, every call crosses
     * from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such as `map`.
     */
    fun mapUnsafe(callable: Callable): VariantArray<Any?> {
        return (VariantBuffer.transfer.callBridge(1, VariantParser.ARRAY) {
            VariantParser.CALLABLE.toGodot(callable)
            Bridge.engine_call_map(ptr)
        } as VariantArray<Any?>).also {
            it.variantConverter = VariantCaster.ANY
        }
    }

    /**
     * Returns the maximum value contained in the array if all elements are of comparable types.
     * If the elements can't be compared, null is returned.
     */
    fun max(): T? {
        return VariantBuffer.transfer.callBridge(variantConverter.toNullable()) { Bridge.engine_call_max(ptr) }
    }

    /**
     * Returns the minimum value contained in the array if all elements are of comparable types.
     * If the elements can't be compared, null is returned.
     */
    fun min(): T? {
        return VariantBuffer.transfer.callBridge(variantConverter.toNullable()) { Bridge.engine_call_min(ptr) }
    }

    /**
     * Returns a random value from the target array.
     */
    fun pickRandom(): T? {
        return VariantBuffer.transfer.callBridge(variantConverter.toNullable()) { Bridge.engine_call_pickRandom(ptr) }
    }

    fun popAt(position: Int): T? {
        return VariantBuffer.transfer.callBridge(1, variantConverter.toNullable()) {
            VariantParser.LONG.write(position.toLong())
            Bridge.engine_call_pop_at(ptr)
        }
    }

    /**
     * Removes and returns the last element of the array.
     * Returns null if the array is empty.
     */
    fun popBack(): T? {
        return VariantBuffer.transfer.callBridge(variantConverter.toNullable()) { Bridge.engine_call_popBack(ptr) }
    }

    /**
     * Removes and returns the first element of the array.
     * Returns null if the array is empty.
     */
    fun popFront(): T? {
        return VariantBuffer.transfer.callBridge(variantConverter.toNullable()) { Bridge.engine_call_popFront(ptr) }
    }

    /**
     * Appends an element at the end of the array.
     */
    fun pushBack(value: T) {
        VariantBuffer.transfer.writeArgs(1) {
            variantConverter.toGodot(value)
        }
        Bridge.engine_call_pushBack(ptr)
    }

    /**
     * Adds an element at the beginning of the array
     */
    fun pushFront(value: T) {
        VariantBuffer.transfer.writeArgs(1) {
            variantConverter.toGodot(value)
        }
        Bridge.engine_call_pushFront(ptr)
    }

    /**
     * Calls the given [Callable] for each element in array, accumulates the result in [accum], then returns it.
     *
     * The method takes two arguments: the current value of [accum] and the current array element. If [accum] is `null`,
     * the iteration will start from the second element, with the first one used as initial value of [accum].
     *
     * See also [map], [filter], [any], and [all].
     *
     * **Performance**: Godot calls [method] once per element. When it is a JVM lambda or method, every call crosses
     * from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such as
     * `fold`.
     */
    fun <A> reduce(method: Callable2<A, A, T>, accum: A): A = reduceUnsafe(method, accum) as A

    /**
     * Calls the given [Callable] for each element in array, accumulates the result in [accum], then returns it.
     *
     * The method takes two arguments: the current value of [accum] and the current array element. If [accum] is `null`,
     * the iteration will start from the second element, with the first one used as initial value of [accum].
     *
     * See also [map], [filter], [any], and [all].
     *
     * **Performance**: Godot calls [callable] once per element. When it is a JVM lambda or method, every call crosses
     * from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such as
     * `fold`.
     */
    @JvmOverloads
    fun reduceUnsafe(callable: Callable, accum: Any? = null): Any? {
        return VariantBuffer.transfer.callBridge(2, VariantCaster.ANY) {
            VariantParser.CALLABLE.toGodot(callable)
            VariantCaster.ANY.toGodot(accum)
            Bridge.engine_call_reduce(ptr)
        }
    }

    /**
     * Removes an element from the array by index.
     */
    fun removeAt(position: Int) {
        VariantBuffer.transfer.writeArgs(1) {
            VariantParser.LONG.write(position.toLong())
        }
        Bridge.engine_call_removeAt(ptr)
    }

    /**
     * Resizes the array to contain a different number of elements.
     * If the array size is smaller, elements are cleared, if bigger, new elements are null.
     */
    fun resize(size: Int): Error {
        return Error.from(VariantBuffer.transfer.callBridge(1, VariantParser.LONG) {
            VariantParser.LONG.write(size.toLong())
            Bridge.engine_call_resize(ptr)
        })
    }

    /**
     * Reverses the order of the elements in the array.
     */
    fun reverse() {
        Bridge.engine_call_reverse(ptr)
    }

    /**
     * Searches the array in reverse order.
     * Optionally, a start search index can be passed.
     * If negative, the start index is considered relative to the end of the array.
     */
    @JvmOverloads
    fun rfind(what: T, from: Int = -1): Int {
        return VariantBuffer.transfer.callBridge(2, VariantParser.LONG) {
            variantConverter.toGodot(what)
            VariantParser.LONG.write(from.toLong())
            Bridge.engine_call_rfind(ptr)
        }.toInt()
    }

    /**
     * Returns the index of the last element of the array that causes [method] to return `true`, or -1 if there are
     * none. The search's start can be specified with [from], continuing to the beginning of the array. This method is
     * the reverse of [findCustom].
     *
     * **Performance**: Godot calls [method] up to once per element. When it is a JVM lambda or method, every call
     * crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such
     * as `indexOfLast`.
     */
    @JvmOverloads
    fun rfindCustom(method: Callable1<Boolean, T>, from: Int = -1) = rfindCustomUnsafe(method, from)

    /**
     * Returns the index of the last element of the array that causes [method] to return `true`, or -1 if there are
     * none. The search's start can be specified with [from], continuing to the beginning of the array. This method is
     * the reverse of [findCustom].
     *
     * **Performance**: Godot calls [method] up to once per element. When it is a JVM lambda or method, every call
     * crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language, such
     * as `indexOfLast`.
     */
    @JvmOverloads
    fun rfindCustomUnsafe(method: Callable, from: Int = -1): Int {
        return VariantBuffer.transfer.callBridge(2, VariantParser.LONG) {
            VariantParser.CALLABLE.toGodot(method)
            VariantParser.LONG.write(from.toLong())
            Bridge.engine_call_rfind_custom(ptr)
        }.toInt()
    }

    operator fun set(idx: Int, data: T) {
        VariantBuffer.transfer.writeArgs(2) {
            VariantParser.LONG.write(idx.toLong())
            variantConverter.toGodot(data)
        }
        Bridge.engine_call_operator_set(ptr)
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
    @JvmOverloads
    fun slice(begin: Int, end: Int = Int.MAX_VALUE, step: Int = 1, deep: Boolean = false): VariantArray<T> {
        return (VariantBuffer.transfer.callBridge(4, VariantParser.ARRAY) {
            VariantParser.LONG.write(begin.toLong())
            VariantParser.LONG.write(end.toLong())
            VariantParser.LONG.write(step.toLong())
            VariantParser.BOOL.write(deep)
            Bridge.engine_call_slice(ptr)
        } as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }

    /**
     * Sorts the array.
     */
    fun sort() {
        Bridge.engine_call_sort(ptr)
    }

    /**
     * Sorts the array using a custom [Callable].
     *
     * [func] is called as many times as necessary, receiving two array elements as arguments. The function should
     * return `true` if the first element should be moved before the second one, otherwise it should return `false`.
     *
     * **Note**: The sorting algorithm used is not stable. This means that values considered equal may have their order
     * changed when calling this method.
     *
     * **Note**: You should not randomize the return value of [func], as the heapsort algorithm expects a consistent
     * result. Randomizing the return value will result in unexpected behavior.
     *
     * **Performance**: Godot calls [func] about n log n times for n elements. When it is a JVM lambda or method, every
     * call crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language,
     * such as `sortedWith`.
     */
    fun sortCustom(func: Callable2<Boolean, T, T>) = sortCustomUnsafe(func)

    /**
     * Sorts the array using a custom [Callable].
     *
     * [func] is called as many times as necessary, receiving two array elements as arguments. The function should
     * return `true` if the first element should be moved before the second one, otherwise it should return `false`.
     *
     * **Note**: The sorting algorithm used is not stable. This means that values considered equal may have their order
     * changed when calling this method.
     *
     * **Note**: You should not randomize the return value of [func], as the heapsort algorithm expects a consistent
     * result. Randomizing the return value will result in unexpected behavior.
     *
     * **Performance**: Godot calls [func] about n log n times for n elements. When it is a JVM lambda or method, every
     * call crosses from C++ into the JVM, which is slow: on large arrays, prefer the collection API of your language,
     * such as `sortedWith`.
     */
    fun sortCustomUnsafe(func: Callable) {
        VariantBuffer.transfer.writeArgs(1) {
            VariantParser.CALLABLE.toGodot(func)
        }
        Bridge.engine_call_sortCustom(ptr)
    }

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

    override operator fun contains(element: T) = has(element)

    override fun containsAll(elements: Collection<T>): Boolean {
        elements.forEach {
            if (!has(it)) return false
        }
        return true
    }

    override fun equals(other: Any?): Boolean {
        if (other !is VariantArray<*>) {
            return false
        }
        return VariantBuffer.transfer.callBridge(1, VariantParser.BOOL) {
            VariantParser.ARRAY.toGodot(other)
            Bridge.engine_call_equals(ptr)
        }
    }

    override fun hashCode(): Int = hash()

    override fun iterator(): MutableIterator<T> {
        return IndexedIterator(this::size, this::get, this::removeAt)
    }

    override fun remove(element: T): Boolean {
        if (has(element)) {
            erase(element)
            return true
        }

        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var ret = false
        elements.forEach {
            ret = remove(it) || ret
        }
        return ret
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

    override fun toString(): String {
        return "Array(${size})"
    }

    private fun assignPacked(packed: NativeCoreType, parser: VariantParser<*>) = apply {
        VariantBuffer.transfer.writeArgs(1) {
            parser.toGodot(this, packed)
        }
        Bridge.engine_call_assign_packed(ptr)
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

    operator fun compareTo(other: VariantArray<T>): Int {
        return VariantBuffer.transfer.callBridge(1, VariantParser.LONG) {
            VariantParser.ARRAY.toGodot(other)
            Bridge.engine_call_compare(ptr)
        }.toInt()
    }

    operator fun get(indices: IntProgression): VariantArray<T> {
        if (indices.isEmpty()) {
            return slice(0, 0)
        }
        if (GodotJvmBuildConfig.DEBUG) {
            val size = size
            if (indices.first !in 0..<size || indices.last !in 0..<size) {
                throw IndexOutOfBoundsException("Range $indices out of bounds for length $size")
            }
        }
        val end = when {
            indices.step > 0 -> indices.last + 1
            indices.last == 0 -> Int.MIN_VALUE
            else -> indices.last - 1
        }
        return slice(indices.first, end, indices.step)
    }

    operator fun minus(element: T): VariantArray<T> = duplicate().also { it.erase(element) }

    operator fun minusAssign(element: T) = erase(element)

    operator fun plus(other: T): VariantArray<T> = duplicate().also { it.append(other) }

    operator fun plus(other: VariantArray<T>): VariantArray<T> {
        return (VariantBuffer.transfer.callBridge(1, VariantParser.ARRAY) {
            VariantParser.ARRAY.toGodot(other)
            Bridge.engine_call_operator_plus(ptr)
        } as VariantArray<T>).also {
            it.variantConverter = variantConverter
        }
    }

    operator fun plusAssign(element: T) = append(element)

    operator fun plusAssign(other: VariantArray<T>) = appendArray(other)

    @Suppress("FunctionName")
    private object Bridge {
        external fun engine_call_constructor(): VoidPtr
        external fun engine_call_constructor_typed(): VoidPtr
        external fun engine_call_copy_constructor(_handle: VoidPtr): VoidPtr

        external fun engine_call_all(_handle: VoidPtr)
        external fun engine_call_any(_handle: VoidPtr)
        external fun engine_call_append(_handle: VoidPtr)
        external fun engine_call_appendArray(_handle: VoidPtr)
        external fun engine_call_assign(_handle: VoidPtr)
        external fun engine_call_assign_packed(_handle: VoidPtr)
        external fun engine_call_back(_handle: VoidPtr)
        external fun engine_call_bsearch(_handle: VoidPtr)
        external fun engine_call_bsearchCustom(_handle: VoidPtr)
        external fun engine_call_clear(_handle: VoidPtr)
        external fun engine_call_compare(_handle: VoidPtr)
        external fun engine_call_count(_handle: VoidPtr)
        external fun engine_call_duplicate(_handle: VoidPtr)
        external fun engine_call_duplicate_deep(_handle: VoidPtr)
        external fun engine_call_equals(_handle: VoidPtr)
        external fun engine_call_erase(_handle: VoidPtr)
        external fun engine_call_fill(_handle: VoidPtr)
        external fun engine_call_filter(_handle: VoidPtr)
        external fun engine_call_find(_handle: VoidPtr)
        external fun engine_call_find_custom(_handle: VoidPtr)
        external fun engine_call_front(_handle: VoidPtr)
        external fun engine_call_getTypedClassName(_handle: VoidPtr)
        external fun engine_call_getTypedScript(_handle: VoidPtr)
        external fun engine_call_has(_handle: VoidPtr)
        external fun engine_call_hash(_handle: VoidPtr)
        external fun engine_call_insert(_handle: VoidPtr)
        external fun engine_call_isEmpty(_handle: VoidPtr)
        external fun engine_call_isReadOnly(_handle: VoidPtr)
        external fun engine_call_is_same_typed(_handle: VoidPtr)
        external fun engine_call_make_read_only(_handle: VoidPtr)
        external fun engine_call_map(_handle: VoidPtr)
        external fun engine_call_max(_handle: VoidPtr)
        external fun engine_call_min(_handle: VoidPtr)
        external fun engine_call_operator_get(_handle: VoidPtr)
        external fun engine_call_operator_plus(_handle: VoidPtr)
        external fun engine_call_operator_set(_handle: VoidPtr)
        external fun engine_call_pickRandom(_handle: VoidPtr)
        external fun engine_call_popBack(_handle: VoidPtr)
        external fun engine_call_popFront(_handle: VoidPtr)
        external fun engine_call_pop_at(_handle: VoidPtr)
        external fun engine_call_pushBack(_handle: VoidPtr)
        external fun engine_call_pushFront(_handle: VoidPtr)
        external fun engine_call_reduce(_handle: VoidPtr)
        external fun engine_call_removeAt(_handle: VoidPtr)
        external fun engine_call_resize(_handle: VoidPtr)
        external fun engine_call_reverse(_handle: VoidPtr)
        external fun engine_call_rfind(_handle: VoidPtr)
        external fun engine_call_rfind_custom(_handle: VoidPtr)
        external fun engine_call_shuffle(_handle: VoidPtr)
        external fun engine_call_size(_handle: VoidPtr)
        external fun engine_call_slice(_handle: VoidPtr)
        external fun engine_call_sort(_handle: VoidPtr)
        external fun engine_call_sortCustom(_handle: VoidPtr)
    }

    companion object {
        inline operator fun <reified T> invoke(): VariantArray<T> {
            // The nullable check can't be inside the regular constructor because of Java
            if (GodotJvmBuildConfig.DEBUG) {
                if (hasInvalidNullability<T>()) {
                    error("Can't create a VariantArray with generic ${T::class} as nullable.")
                }
            }
            return VariantArray(T::class.java)
        }

        @JvmStatic
        operator fun invoke(from: PackedByteArray) = VariantArray(VariantCaster.BYTE).assignPacked(from, VariantParser.PACKED_BYTE_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedInt32Array) = VariantArray(VariantCaster.INT).assignPacked(from, VariantParser.PACKED_INT_32_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedInt64Array) = VariantArray(VariantParser.LONG).assignPacked(from, VariantParser.PACKED_INT_64_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedFloat32Array) = VariantArray(VariantCaster.FLOAT).assignPacked(from, VariantParser.PACKED_FLOAT_32_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedFloat64Array) = VariantArray(VariantParser.DOUBLE).assignPacked(from, VariantParser.PACKED_FLOAT_64_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedStringArray) = VariantArray(VariantParser.STRING).assignPacked(from, VariantParser.PACKED_STRING_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedVector2Array) = VariantArray(VariantParser.VECTOR2).assignPacked(from, VariantParser.PACKED_VECTOR2_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedVector3Array) = VariantArray(VariantParser.VECTOR3).assignPacked(from, VariantParser.PACKED_VECTOR3_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedColorArray) = VariantArray(VariantParser.COLOR).assignPacked(from, VariantParser.PACKED_COLOR_ARRAY)

        @JvmStatic
        operator fun invoke(from: PackedVector4Array) = VariantArray(VariantParser.VECTOR4).assignPacked(from, VariantParser.PACKED_VECTOR4_ARRAY)
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
