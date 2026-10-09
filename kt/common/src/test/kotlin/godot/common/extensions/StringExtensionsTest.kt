package godot.common.extensions

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringExtensionsTest {
    @Test
    fun titleCaseMatchesGodotCapitalize() {
        mapOf(
            "ENUM_VALUE" to "Enum Value",
            "OK" to "Ok",
            "VALUE_2D" to "Value 2d",
            "TEXTURE2D" to "Texture 2d",
            "HTTPRequest" to "Http Request",
            "myEnumValue" to "My Enum Value",
            "Value2x" to "Value 2x",
            "UTF8_STRING" to "Utf 8 String",
            "A__B" to "A B",
            "_LEADING" to "Leading",
            "" to "",
        ).forEach { (name, expected) -> assertEquals(expected, name.convertToTitleCase(), name) }
    }

    @Test
    fun camelCase() {
        assertEquals("helloWorld", "hello_world".convertToCamelCase())
        assertEquals("_getName", "_get_name".convertToCamelCase())
    }

    @Test
    fun snakeCase() {
        assertEquals("health_changed", "healthChanged".convertToSnakeCase())
        assertEquals("name", "Name".convertToSnakeCase())
    }

    @Test
    fun upperSnakeCase() {
        assertEquals("MY_ENUM_VALUE", "myEnumValue".toUpperSnakeCase())
        assertEquals("HTTP_REQUEST", "HTTPRequest".toUpperSnakeCase())
    }

    @Test
    fun prefixAndSuffixWords() {
        assertEquals("IN", "EASE_IN".removePrefixWords("EASE_TYPE"))
        assertEquals("LEFT", "LEFT_SIDE".removeSuffixWords("SIDE"))
    }

    @Test
    fun identifiers() {
        assertEquals("name", "__name".escapeUnderscore())
        assertTrue("_a1".isValidKotlinIdentifier())
        assertFalse("1a".isValidKotlinIdentifier())
        assertEquals("`in`", "in".escapeKotlinReservedNames())
        assertEquals("name", "name".escapeKotlinReservedNames())
    }
}
