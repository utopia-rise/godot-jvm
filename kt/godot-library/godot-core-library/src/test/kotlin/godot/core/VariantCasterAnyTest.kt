package godot.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertSame
import godot.common.interop.VariantConverter
import org.junit.Test
import java.nio.ByteBuffer

class VariantCasterAnyTest {
    private enum class Plain { FIRST, SECOND }

    private enum class Custom(override val value: Long) : GodotEnum { TEN(10), TWENTY(20), TEN_ALIAS(10) }

    private enum class WithBody {
        A { override fun label() = "a" },
        B { override fun label() = "b" };

        abstract fun label(): String
    }

    private fun writeAsVariantAndReadLong(value: Any?): Long {
        val buffer = ByteBuffer.allocate(16)
        VariantCaster.ANY.toGodot(buffer, value)
        buffer.rewind()
        return VariantParser.LONG.read(buffer)
    }

    @Test
    fun plainEnumIsWrittenAsItsOrdinal() {
        assertEquals(1L, writeAsVariantAndReadLong(Plain.SECOND))
    }

    @Test
    fun godotEnumIsWrittenAsItsValue() {
        assertEquals(20L, writeAsVariantAndReadLong(Custom.TWENTY))
    }

    @Test
    fun enumEntryWithBodyIsWrittenAsItsOrdinal() {
        assertEquals(1L, writeAsVariantAndReadLong(WithBody.B))
    }

    private fun <T> readFromLong(converter: VariantConverter<T>, value: Long): T {
        val buffer = ByteBuffer.allocate(16)
        VariantParser.LONG.write(buffer, value)
        buffer.rewind()
        return converter.toKotlin(buffer)
    }

    @Test
    fun plainEnumConverterReadsItsOrdinal() {
        assertSame(Plain.SECOND, readFromLong(getVariantConverter<Plain>()!!, 1))
    }

    @Test
    fun godotEnumConverterReadsItsValue() {
        assertSame(Custom.TWENTY, readFromLong(getVariantConverter(Custom::class.java)!!, 20))
    }

    @Test
    fun duplicateEnumValuesDecodeToTheFirstDeclaredEntry() {
        assertSame(Custom.TEN, readFromLong(getVariantConverter(Custom::class.java)!!, 10))
        assertSame(Custom.TEN, 10L.toEnum<Custom>())
    }

    @Test
    fun primitiveAndWrapperClassesShareTheirConverter() {
        val primitives = listOf(Boolean::class, Byte::class, Short::class, Char::class, Int::class, Long::class, Float::class, Double::class)
        for (primitive in primitives) {
            val converter = getVariantConverter(primitive.javaPrimitiveType!!)
            assertNotNull(primitive.simpleName, converter)
            assertSame(primitive.simpleName, converter, getVariantConverter(primitive.javaObjectType))
        }
    }

    @Test
    fun voidAndUnitMapToNil() {
        assertSame(VariantParser.NIL, getVariantConverter(Void.TYPE))
        assertSame(VariantParser.NIL, getVariantConverter(Void::class.java))
        assertSame(VariantParser.NIL, getVariantConverter(Unit::class.java))
    }

    @Test
    fun narrowIntegralTypesAreWrittenAsLongs() {
        assertEquals(7L, writeAsVariantAndReadLong(7.toShort()))
        assertEquals(65L, writeAsVariantAndReadLong('A'))
        assertSame('A', readFromLong(VariantCaster.CHAR, 65))
    }

    @Test
    fun bitFieldsAreWrittenAsTheirFlag() {
        assertEquals(3L, writeAsVariantAndReadLong(BitField.of(Plain.FIRST, Plain.SECOND)))
        assertEquals(20L, writeAsVariantAndReadLong(BitField.of(Custom.TWENTY)))
    }

    @Test
    fun bitFieldConverterRebuildsTheFlag() {
        val bitField = readFromLong(getVariantConverter<BitField<Plain>>()!!, 3)
        assertEquals(3L, (bitField as BitField<*>).flag)
    }

    @Test
    fun mappedTypeStillUsesItsOwnConverter() {
        assertEquals(42L, writeAsVariantAndReadLong(42L))
    }
}
