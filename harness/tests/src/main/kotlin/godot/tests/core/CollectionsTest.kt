package godot.tests.core

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import godot.core.Color
import godot.core.Dictionary
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import godot.core.PackedInt32Array
import godot.core.PackedStringArray
import godot.core.VariantArray
import godot.core.asCallable
import godot.core.dictionaryOf
import godot.core.variantArrayOf

@Script
class CollectionsTest : Node() {

    @Register
    fun readMissingKey(dictionary: Dictionary<String, Long>): Any? = dictionary["missing"]

    @Register
    fun getValueOfMissingKeyThrows(dictionary: Dictionary<String, Long>): Boolean {
        return runCatching { dictionary.getValue("missing") }.exceptionOrNull() is NoSuchElementException
    }

    @Register
    fun untypedNullsReadAsNull(): Boolean {
        val array = variantArrayOf<Any?>(null)
        val dictionary = dictionaryOf<Any?, Any?>("key" to null)
        return array[0] == null && dictionary["key"] == null && dictionary.has("key")
    }

    @Register
    fun newTypedDictionary() = Dictionary<String, Long>()

    @Register
    fun jvmTypingOfDictionary(): VariantArray<Any?> {
        val typed = Dictionary<String, Long>()
        val untyped = Dictionary<Any?, Any?>()
        return variantArrayOf(
            typed.isTyped(),
            typed.isTypedKey(),
            typed.isTypedValue(),
            typed.getTypedKeyBuiltin(),
            typed.getTypedValueBuiltin(),
            untyped.isTyped(),
            untyped.isTypedKey(),
            untyped.getTypedValueBuiltin(),
            typed.isSameTyped(Dictionary<String, Long>()),
            typed.isSameTypedKey(Dictionary<String, String>()),
            typed.isSameTypedValue(Dictionary<String, String>()),
        )
    }

    @Register
    fun dictionaryOperations(): VariantArray<Any?> {
        val dictionary = dictionaryOf("a" to 1L, "b" to 2L)
        val added = dictionary.getOrAdd("c", 3L)
        val existing = dictionary.getOrAdd("a", 10L)
        val merged = dictionary.merged(dictionaryOf("a" to 100L, "d" to 4L), true)
        val erasedPresent = dictionary.erase("c")
        val erasedMissing = dictionary.erase("c")
        val foundKey = dictionary.findKey(2L)
        val missingKey = dictionary.findKey(42L)
        val assigned = Dictionary<String, Long>().also { it.assign(dictionary) }
        val equalHashes = assigned.hashCode() == dictionary.hashCode()
        val recursiveEqual = assigned.recursiveEqual(dictionary, 0)
        val removed = dictionary.remove("missing")
        val readOnly = dictionaryOf("x" to 1L).also { it.makeReadOnly() }
        val setOnWritable = dictionary.set("e", 5L)
        return variantArrayOf(
            added, existing, merged, erasedPresent, erasedMissing, foundKey, missingKey,
            equalHashes, recursiveEqual, removed, readOnly.isReadOnly(), setOnWritable, dictionary,
        )
    }

    @Register
    fun emptyTypedArrayAccessors(): VariantArray<Any?> {
        val array = VariantArray<Long>()
        return variantArrayOf(array.popBack(), array.popFront(), array.max(), array.min())
    }

    @Register
    fun outOfRangeIndexesThrow(): VariantArray<Boolean> {
        val untyped = variantArrayOf<Any?>(1L)
        val typed = variantArrayOf(1L)
        val packed = PackedInt32Array(intArrayOf(1))
        val accesses = listOf<() -> Any?>(
            { untyped[1] }, { untyped[-1] = 0L },
            { typed[-1] }, { typed[1] = 0L },
            { packed[1] }, { packed[-1] = 0 },
        )
        return VariantArray<Boolean>().also { results ->
            accesses.mapTo(results) { runCatching(it).exceptionOrNull() is IndexOutOfBoundsException }
        }
    }

    @Register
    fun arrayCallables(): VariantArray<Any?> {
        val array = variantArrayOf(3L, 1L, 4L, 1L, 5L)
        val isOne = { value: Long -> value == 1L }.asCallable()
        val first = array.findCustom(isOne)
        val last = array.rfindCustom(isOne)
        val allPositive = array.all({ value: Long -> value > 0 }.asCallable())
        val anyAboveFour = array.any({ value: Long -> value > 4 }.asCallable())
        val filtered = array.filter({ value: Long -> value > 2 }.asCallable())
        val mapped = array.map({ value: Long -> value * 2 }.asCallable())
        val sum = array.reduce({ accumulator: Long, value: Long -> accumulator + value }.asCallable(), 0L)
        val sorted = array.duplicate()
        sorted.sortCustom({ a: Long, b: Long -> a > b }.asCallable())
        val ascending = variantArrayOf(1L, 3L, 5L, 7L)
        val insertion = ascending.bsearchCustom(4L, { a: Long, b: Long -> a < b }.asCallable())
        return variantArrayOf(first, last, allPositive, anyAboveFour, filtered, mapped, sum, sorted, insertion)
    }

    @Register
    fun arrayOperations(): VariantArray<Any?> {
        val array = variantArrayOf(1L, 2L, 3L)
        array.reverse()
        val popped = array.popAt(1)
        val resized = array.resize(3)
        val inserted = array.insert(1, 9L)
        val concatenated = array + variantArrayOf(7L)
        val assigned = VariantArray<Long>().also { it.assign(array) }
        val equal = assigned == array
        val equalHashes = assigned.hashCode() == array.hashCode()
        val lessThan = variantArrayOf(1L, 2L) < variantArrayOf(1L, 3L)
        val sameTyped = array.isSameTyped(VariantArray<Long>())
        val untypedIsTyped = VariantArray<Any?>().isTyped()
        val readOnly = variantArrayOf(1L).also { it.makeReadOnly() }
        return variantArrayOf(
            array, popped, resized, inserted, concatenated, equal, equalHashes, lessThan, sameTyped,
            untypedIsTyped, readOnly.isReadOnly(), array.isTyped(), array.getTypedBuiltin(),
        )
    }

    @Register
    fun arraysFromPackedArrays(): VariantArray<Any?> {
        val bytes = VariantArray(PackedByteArray(byteArrayOf(1, 2)))
        val ints = VariantArray(PackedInt32Array(intArrayOf(3, 4)))
        val floats = VariantArray(PackedFloat32Array(floatArrayOf(0.5f)))
        val strings = VariantArray(PackedStringArray(variantArrayOf("a", "b")))
        val colors = VariantArray(PackedColorArray(listOf(Color(1, 0, 0, 1))))
        val firstByte: Byte = bytes[0]
        val secondInt: Int = ints[1]
        return variantArrayOf(bytes, ints, floats, strings, colors, firstByte, secondInt)
    }
}
