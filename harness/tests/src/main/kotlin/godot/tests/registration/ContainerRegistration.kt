package godot.tests.registration

import godot.api.Node
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.core.Dictionary
import godot.core.VariantArray
import godot.core.VariantCaster
import godot.core.VariantParser
import godot.core.Vector2
import godot.core.dictionaryOf
import godot.core.variantArrayOf

// Containers are a special case of registration: Godot only knows its own builtin element types (an int array is a
// `Long` array), so the registered converters must hand the JVM the declared element types.
// Every case follows the same pattern: GDScript reads the initial value (JVM -> Godot), assigns a new one, then calls
// the matching `describe` function that consumes the elements with their JVM type (Godot -> JVM).
@Script
class ContainerRegistration : Node() {

    @Visible
    var anyArray: VariantArray<Any?> = variantArrayOf(1L, "two", 3.0, Vector2(4, 5))

    @Visible
    var starArray: VariantArray<*> = variantArrayOf<Any?>(1L, "two", 3.0)

    @Visible
    var intArray: VariantArray<Int> = variantArrayOf(1, 2, 3)

    @Visible
    var byteArray: VariantArray<Byte> = variantArrayOf(1.toByte(), 2.toByte())

    @Visible
    var stringArray: VariantArray<String> = variantArrayOf("a", "b")

    // Built from converters because a class cannot describe the inner element type.
    @Visible
    var nestedIntArray: VariantArray<VariantArray<Int>> = VariantArray<VariantArray<Int>>(VariantCaster.TYPED_ARRAY(VariantCaster.INT)).also {
        it.add(variantArrayOf(1, 2))
        it.add(variantArrayOf(3))
    }

    @Visible
    var starDictionary: Dictionary<*, *> = dictionaryOf<Any?, Any?>("one" to 1L, 2L to "two")

    @Visible
    var stringIntDictionary: Dictionary<String, Int> = dictionaryOf("one" to 1, "two" to 2)

    @Visible
    var byteFloatDictionary: Dictionary<Byte, Float> = dictionaryOf(1.toByte() to 1.5f, 2.toByte() to 2.5f)

    @Visible
    var nestedDictionary: Dictionary<String, VariantArray<Int>> = Dictionary<String, VariantArray<Int>>(
        VariantParser.STRING,
        VariantCaster.TYPED_ARRAY(VariantCaster.INT)
    ).also {
        it["odd"] = variantArrayOf(1, 3)
        it["even"] = variantArrayOf(2)
    }

    @Register
    fun describeAnyArray(): String = anyArray.joinToString("|") { "${it?.let { value -> value::class.simpleName }}:$it" }

    @Register
    fun describeStarArray(): String = starArray.joinToString("|") { "${it?.let { value -> value::class.simpleName }}:$it" }

    @Register
    fun describeIntArray(): String = intArray.joinToString("|") { (it + 1).toString() }

    @Register
    fun describeByteArray(): String = byteArray.joinToString("|") { (it + 1).toString() }

    @Register
    fun describeStringArray(): String = stringArray.joinToString("|") { it.uppercase() }

    @Register
    fun describeNestedIntArray(): String = nestedIntArray.joinToString("|") { inner -> inner.sum().toString() }

    @Register
    fun describeStarDictionary(): String =
        starDictionary.entries.joinToString("|") { "${it.key}=${it.value?.let { value -> value::class.simpleName }}:${it.value}" }

    @Register
    fun describeStringIntDictionary(): String =
        stringIntDictionary.entries.sortedBy { it.key }.joinToString("|") { "${it.key}=${it.value + 1}" }

    @Register
    fun describeByteFloatDictionary(): String =
        byteFloatDictionary.entries.sortedBy { it.key }.joinToString("|") { "${it.key + 1}=${it.value * 2}" }

    @Register
    fun describeNestedDictionary(): String =
        nestedDictionary.entries.sortedBy { it.key }.joinToString("|") { "${it.key}=${it.value.sum()}" }
}
