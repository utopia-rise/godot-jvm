package godot.tests.core

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import godot.core.Dictionary
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
}
