package godot.core

import godot.common.util.isEqualApprox
import godot.common.util.toRealT
import org.junit.Test
import kotlin.math.pow

class TestColor {

    @Test
    fun `Color Constructor methods`() {
        val blueRgba = Color(0.25098, 0.376471, 1, 0.501961)
        val blueHtml = Color.html("#4060ff80")
        val blueHex = Color.hex(0x4060ff80u)
        val blueHex64 = Color.hex64(0x40406060ffff8080u)

        checkMessage(blueRgba.isEqualApprox(blueHtml)) { "Creation with HTML notation should result in components approximately equal to the default constructor." }
        checkMessage(blueRgba.isEqualApprox(blueHex)) { "Creation with a 32-bit hexadecimal number should result in components approximately equal to the default constructor." }
        checkMessage(blueRgba.isEqualApprox(blueHex64)) { "Creation with a 64-bit hexadecimal number should result in components approximately equal to the default constructor." }

        val htmlInvalid = Color.html("invalid")
        checkMessage(htmlInvalid == Color()) { "Creation with invalid HTML notation should result in a Color with the default values." }

        val greenRgba = Color(0, 1, 0, 0.25)
        val greenHsva = Color.fromHsv(120.0 / 360.0, 1.0, 1.0, 0.25)

        checkMessage(greenRgba.isEqualApprox(greenHsva)) { "Creation with HSV notation should result in components approximately equal to the default constructor." }
    }

    @Test
    fun `Color Operators`() {
        val blue = Color(0.2, 0.2, 1)
        val darkRed = Color(0.3, 0.1, 0.1)

        checkMessage((blue + darkRed).isEqualApprox(Color(0.5, 0.3, 1.1, 2))) { "Color addition should behave as expected." }
        checkMessage((blue - darkRed).isEqualApprox(Color(-0.1, 0.1, 0.9, 0))) { "Color subtraction should behave as expected." }
        checkMessage((blue * 2f).isEqualApprox(Color(0.4, 0.4, 2, 2))) { "Color multiplication with a scalar should behave as expected." }
        checkMessage((blue / 2f).isEqualApprox(Color(0.1, 0.1, 0.5, 0.5))) { "Color division with a scalar should behave as expected." }
        checkMessage((blue * darkRed).isEqualApprox(Color(0.06, 0.02, 0.1))) { "Color multiplication with another Color should behave as expected." }
        checkMessage((blue / darkRed).isEqualApprox(Color(0.666667, 2, 10))) { "Color division with another Color should behave as expected." }
        checkMessage(
            (-blue).isEqualApprox(
                Color(
                    0.8,
                    0.8,
                    0,
                    0
                )
            )
        ) { "Color negation should behave as expected (affecting the alpha channel, unlike `invert()`)." }
    }

    @Test
    fun `Reading methods`() {
        val darkBlue = Color(0.0, 0.0, 0.5, 0.4)
        checkMessage(darkBlue.h.isEqualApprox((240.0f / 360.0f).toRealT())) { "The returned HSV hue should match the expected value." }
        checkMessage(darkBlue.s.isEqualApprox(1.0)) { "The returned HSV saturation should match the expected value." }
        checkMessage(darkBlue.v.isEqualApprox(0.5)) { "The returned HSV value should match the expected value." }
    }

    @Test
    fun `Color Conversion methods`() {
        val cyan = Color(0, 1, 1)
        val cyanTransparent = Color(0, 1, 1, 0)

        checkMessage(cyan.toHtml() == "00ffffff") { "The returned RGBA HTML color code should match the expected value." }
        checkMessage(cyan.toHtml(false) == "00ffff") { "The returned RGB HTML color code should match the expected value." }
        checkMessage(cyanTransparent.toHtml() == "00ffff00") { "The returned RGBA HTML color code should keep the alpha last." }
        checkMessage(cyan.toRGBA32() == 0x00FFFFFFL) { "The returned 32-bit RGBA number should match the expected value." }
        checkMessage(cyan.toARGB32() == 0xFF00FFFFL) { "The returned 32-bit ARGB number should match the expected value." }
        checkMessage(cyan.toABGR32() == 0xFFFFFF00L) { "The returned 32-bit ABGR number should match the expected value." }
        checkMessage(cyan.toRGBA64() == 0x0000FFFFFFFFFFFFL) { "The returned 64-bit RGBA number should match the expected value." }
        checkMessage(cyan.toARGB64() == 0xFFFF0000FFFFFFFFuL.toLong()) { "The returned 64-bit ARGB number should match the expected value." }
        checkMessage(cyan.toABGR64() == 0xFFFFFFFFFFFF0000uL.toLong()) { "The returned 64-bit ABGR number should match the expected value." }
    }

    @Test
    fun `Color Linear --- sRGB conversion`() {
        val color = Color(0.35, 0.5, 0.6, 0.7)
        val colorLinear = color.srgbToLinear()
        val colorSrgb = color.linearToSrgb()

        checkMessage(
            colorLinear.isEqualApprox(
                Color(
                    0.100481,
                    0.214041,
                    0.318547,
                    0.7
                )
            )
        ) { "The color converted to linear color space should match the expected value." }
        checkMessage(
            colorSrgb.isEqualApprox(
                Color(
                    0.62621,
                    0.735357,
                    0.797738,
                    0.7
                )
            )
        ) { "The color converted to sRGB color space should match the expected value." }
        checkMessage(
            colorLinear.linearToSrgb().isEqualApprox(Color(0.35, 0.5, 0.6, 0.7))
        ) { "The linear color converted back to sRGB color space should match the expected value." }
        checkMessage(
            colorSrgb.srgbToLinear().isEqualApprox(Color(0.35, 0.5, 0.6, 0.7))
        ) { "The sRGB color converted back to linear color space should match the expected value." }
        checkMessage(
            Color(1.0, 1.0, 1.0, 1.0).srgbToLinear().isEqualApprox(Color(1.0, 1.0, 1.0, 1.0))
        ) { "White converted from sRGB to linear should remain white." }
    }

    @Test
    fun `Color Named colors`() {
        checkMessage(Color.named("red").isEqualApprox(Color.hex(0xFF0000FFu))) { "The named color \"red\" should match the expected value." }
        checkMessage(Color.named("white_smoke").isEqualApprox(Color.hex(0xF5F5F5FFu))) { "The named color \"white_smoke\" should match the expected value." }
        checkMessage(Color.named("Slate Blue").isEqualApprox(Color.hex(0x6A5ACDFFu))) { "The named color \"Slate Blue\" should match the expected value." }
        checkMessage(Color.named("doesn't exist") == Color()) { "The invalid named color \"doesn't exist\" should result in a Color with the default values." }
    }

    @Test
    fun `Color Validation methods`() {
        checkMessage(Color.htmlIsValid("#4080ff")) { "Valid HTML color (with leading #) should be considered valid." }
        checkMessage(Color.htmlIsValid("4080ff")) { "Valid HTML color (without leading #) should be considered valid." }
        checkFalseMessage(Color.htmlIsValid("12345")) { "Invalid HTML color should be considered invalid." }
        checkFalseMessage(Color.htmlIsValid("#fuf")) { "Invalid HTML color should be considered invalid." }
    }

    @Test
    fun `Color Manipulation methods`() {
        val blue = Color(0, 0, 1, 0.4)
        checkMessage(blue.inverted().isEqualApprox(Color(1, 1, 0, 0.4))) { "Inverted color should have its red, green, and blue components inverted." }

        val purple = Color(0.5, 0.2, 0.5, 0.25)
        checkMessage(purple.lightened(0.2).isEqualApprox(Color(0.6, 0.36, 0.6, 0.25))) { "Color should be lightened by the expected amount." }
        checkMessage(purple.darkened(0.2).isEqualApprox(Color(0.4, 0.16, 0.4, 0.25))) { "Color should be darkened by the expected amount." }

        val red = Color(1, 0, 0, 0.2)
        val yellow = Color(1, 1, 0, 0.8)
        checkMessage(red.lerp(yellow, 0.5).isEqualApprox(Color(1, 0.5, 0, 0.5))) { "Red interpolated with yellow should be orange (with interpolated alpha)." }
    }

    @Test
    fun `Blend computes the resulting alpha`() {
        val blended = Color(1.0, 0.0, 0.0, 0.5).blend(Color(0.0, 0.0, 1.0, 0.5))
        checkTrue(blended.isEqualApprox(Color(1.0 / 3.0, 0.0, 2.0 / 3.0, 0.75)))
        checkTrue(Color(1.0, 0.0, 0.0, 0.0).blend(Color(0.0, 0.0, 1.0, 0.0)) == Color(0.0, 0.0, 0.0, 0.0))
        checkTrue(Color(1.0, 0.0, 0.0, 1.0).blend(Color(0.0, 0.0, 1.0, 0.0)).isEqualApprox(Color(1.0, 0.0, 0.0, 1.0)))
    }

    @Test
    fun `Hue setter selects the right sector`() {
        checkTrue(Color(1.0, 0.0, 0.0).also { it.h = 0.5 }.isEqualApprox(Color(0.0, 1.0, 1.0)))
        checkTrue(Color(1.0, 0.0, 0.0).also { it.h = 0.25 }.isEqualApprox(Color(0.5, 1.0, 0.0)))
        checkTrue(Color(1.0, 0.0, 0.0).also { it.h = 0.75 }.isEqualApprox(Color(0.5, 0.0, 1.0)))
        checkTrue(Color(1.0, 0.0, 0.0).also { it.h = 0.0 }.isEqualApprox(Color(1.0, 0.0, 0.0)))
    }

    @Test
    fun `From HSV keeps alpha`() {
        checkTrue(Color.fromHsv(0.3, 0.0, 0.5, 0.25) == Color(0.5, 0.5, 0.5, 0.25))
        checkTrue(Color.fromHsv(0.5, 1.0, 1.0, 0.4).isEqualApprox(Color(0.0, 1.0, 1.0, 0.4)))
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Color(0.2, 0.4, 0.6, 0.8)
        val b = Color(0.9, 0.1, 0.5, 0.3)
        val aCopy = Color(a)
        val bCopy = Color(b)

        val operations = listOf<() -> Any>(
            { a + b },
            { a - b },
            { a * b },
            { a / b },
            { a * 2.0 },
            { -a },
            { a.blend(b) },
            { a.clamp() },
            { a.darkened(0.2) },
            { a.lightened(0.2) },
            { a.contrasted() },
            { a.inverted() },
            { a.lerp(b, 0.5) },
            { a.linearToSrgb() },
            { a.srgbToLinear() },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }

    @Test
    fun `toHtml writes alpha last and rounds`() {
        val color = Color(1.0, 0.5, 0.0, 0.2)
        checkTrue(color.toHtml() == "ff800033")
        checkTrue(color.toHtml(false) == "ff8000")
        checkTrue(Color.html(color.toHtml()).isEqualApprox(Color(1.0, 128 / 255.0, 0.0, 0.2)))
    }

    @Test
    fun `8 bit channels are clamped`() {
        val color = Color(1.5, -0.5, 0.5, 2.0)
        checkTrue(color.r8 == 255)
        checkTrue(color.g8 == 0)
        checkTrue(color.b8 == 128)
        checkTrue(color.a8 == 255)
        color.r8 = 300
        color.g8 = -5
        checkTrue(color.r == 1.0)
        checkTrue(color.g == 0.0)
    }

    @Test
    fun `Integer conversions wrap each channel`() {
        checkTrue(Color(1.2, 0.0, 0.0, 0.0).toRGBA32() == 0x32000000L)
        checkTrue(Color(0.0, 0.0, 0.0, 1.2).toRGBA32() == 0x32L)
        checkTrue(Color(0.0, 0.0, 1.2, 0.0).toARGB32() == 0x32L)
        checkTrue(Color(1.2, 0.0, 0.0, 0.0).toRGBA64() == 0x3332L shl 48)
    }

    @Test
    fun `From HSV floors negative hue`() {
        checkTrue(Color.fromHsv(-1.0 / 6.0, 1.0, 1.0).isEqualApprox(Color(1.0, 0.0, 1.0, 1.0)))
        checkTrue(Color.fromHsv(-0.5 / 6.0, 1.0, 1.0, 0.5).isEqualApprox(Color(1.0, 0.0, 0.5, 0.5)))
    }

    @Test
    fun `From RGBE9995 reads the exponent unsigned`() {
        val color = Color.fromRgbe9995((16 shl 27) or 1)
        checkTrue(color.isEqualApprox(Color(1.0 / 256.0, 0.0, 0.0, 1.0)))
    }

    @Test
    fun `From string returns the default only when nothing matches`() {
        val default = Color(1.0, 0.0, 0.0, 1.0)
        checkTrue(Color.fromString("black", default) == Color(0.0, 0.0, 0.0, 1.0))
        checkTrue(Color.fromString("#000", default) == Color(0.0, 0.0, 0.0, 1.0))
        checkTrue(Color.fromString("not a color", default) == default)
        checkTrue(Color.fromString("not a color", default) !== default)
    }

    @Test
    fun `Html with invalid digits returns the default color`() {
        checkTrue(Color.html("zzzzzz") == Color())
        checkTrue(Color.html("#zzz") == Color())
    }

    @Test
    fun `Invalid html code of the wrong length falls back to the default color`() {
        checkTrue(Color.html("12345") == Color())
        checkTrue(Color.html("#") == Color())
        checkTrue(Color.html("") == Color())
        checkTrue(Color.html("1234567") == Color())
    }

    @Test
    fun `Color from a string builds from html codes and names and falls back on invalid names`() {
        checkTrue(Color("#ff0000") == Color.hex(0xFF0000FFu))
        checkTrue(Color("Slate Blue") == Color.hex(0x6A5ACDFFu))
        checkTrue(Color("red", 0.5) == Color(1.0, 0.0, 0.0, 0.5))
        checkTrue(Color("nope") == Color())
        checkTrue(Color("zzzzzz") == Color())
        checkTrue(Color("nope", 0.25) == Color(0.0, 0.0, 0.0, 0.25))
    }

    @Test
    fun `Named color count excludes the sentinel`() {
        checkTrue(Color.namedColorCount == 146)
    }

    @Test
    fun `Clamp with inverted bounds does not throw`() {
        val clamped = Color(0.5, 0.5, 0.5, 0.5).clamp(Color(1.0, 1.0, 1.0, 1.0), Color(0.0, 0.0, 0.0, 0.0))
        checkTrue(clamped == Color(1.0, 1.0, 1.0, 1.0))
    }

    @Test
    fun `Linear to sRGB uses the float exponent and the double offset`() {
        val expected = (1.0 + 0.055) * 0.5.pow((1.0f / 2.4f).toDouble()) - 0.055
        checkTrue(Color(0.5, 0.5, 0.5, 1.0).linearToSrgb().r == expected)
        checkTrue(expected.isEqualApprox(0.7353569884946884))
    }

    @Test
    fun `sRGB to linear uses the float exponent`() {
        val expected = ((0.5 + 0.055) * (1.0 / (1.0 + 0.055))).pow(2.4f.toDouble())
        checkTrue(Color(0.5, 0.5, 0.5, 1.0).srgbToLinear().r == expected)
        checkTrue(expected.isEqualApprox(0.21404112737067946))
    }

    @Test
    fun `Components are indexable`() {
        val color = Color(0.1, 0.2, 0.3, 0.4)
        checkTrue(color[0] == 0.1 && color[1] == 0.2 && color[2] == 0.3 && color[3] == 0.4)
        color[2] = 0.9
        checkTrue(color.b == 0.9)
        var thrown = false
        try {
            color[4]
        } catch (e: IndexOutOfBoundsException) {
            thrown = true
        }
        checkTrue(thrown)
    }

    @Test
    fun `Unary plus returns a copy`() {
        val color = Color(0.1, 0.2, 0.3, 0.4)
        val plus = +color
        checkTrue(plus == color)
        checkTrue(plus !== color)
    }

    @Test
    fun `32-bit integer conversions are unsigned`() {
        checkTrue(Color.white.toRGBA32() == 4294967295L)
        checkTrue(Color(1.0, 0.0, 0.0, 1.0).toRGBA32() == 0xFF0000FFL)
        checkTrue(Color(1.0, 0.0, 0.0, 1.0).toARGB32() == 0xFFFF0000L)
        checkTrue(Color(1.0, 0.0, 0.0, 1.0).toABGR32() == 0xFF0000FFL)
        checkTrue(Color(0.0, 0.0, 1.0, 1.0).toABGR32() == 0xFFFF0000L)
    }

    @Test
    fun `From RGBA8 divides each channel by 255`() {
        checkTrue(Color.fromRgba8(255, 0, 51, 102) == Color(1.0f, 0.0f, 51 / 255.0f, 102 / 255.0f))
        checkTrue(Color.fromRgba8(306, 255, 0) == Color(306 / 255.0f, 1.0f, 0.0f, 1.0f))
    }

    @Test
    fun `Named colors are bit identical to hex`() {
        checkTrue(Color.aliceBlue == Color.hex(0xF0F8FFFFu))
        checkTrue(Color.white == Color.hex(0xFFFFFFFFu))
        checkTrue(Color.black == Color.hex(0x000000FFu))
        checkTrue(Color.rebeccaPurple == Color.hex(0x663399FFu))
        checkTrue(Color.transparent == Color.hex(0xFFFFFF00u))
    }

    @Test
    fun `Integer scalar operators`() {
        val color = Color(0.5, 0.25, 1.0, 0.75)
        checkTrue(color * 2 == Color(1.0, 0.5, 2.0, 1.5))
        checkTrue(2 * color == Color(1.0, 0.5, 2.0, 1.5))
        checkTrue(color / 2 == Color(0.25, 0.125, 0.5, 0.375))
    }

    @Test
    fun `Hash code ignores the sign of zero`() {
        val positive = Color(0.0, 0.0, 0.0, 0.0)
        val negative = Color(-0.0, -0.0, -0.0, -0.0)
        checkTrue(positive == negative)
        checkTrue(positive.hashCode() == negative.hashCode())
    }

    @Test
    fun `Hex and html build bit identical colors`() {
        checkTrue(Color.html("f0f8ff") == Color.hex(0xF0F8FFFFu))
        checkTrue(Color.html("#4060ff80") == Color.hex(0x4060FF80u))
        checkTrue(Color.aliceBlue == Color.fromRgba8(240, 248, 255))
        checkTrue(Color.fromString("alice_blue", Color()) == Color.fromString("#F0F8FF", Color()))
        checkTrue(Color.hex(0xF0F8FFFFu).r == (240.0f / 255.0f).toDouble())
        checkTrue(Color.hex64(0x8080FFFF00000000uL).r == (32896.0f / 65535.0f).toDouble())
    }

    @Test
    fun `8 bit conversion rounds half away from zero like std round`() {
        checkTrue(Color(Math.nextDown(0.5f / 255.0f).toDouble(), 0.0, 0.0, 0.0).r8 == 0)
        checkTrue(Color((0.5f / 255.0f).toDouble(), 0.0, 0.0, 0.0).r8 == 1)
        checkTrue(Color(0.0019607844296842813, 0.0, 0.0, 0.0).r8 == 1)
        checkTrue(Color(0.0, 0.0, 0.0, Math.nextDown(0.5f / 255.0f).toDouble()).toRGBA32() == 0L)
        checkTrue(Color(0.0, 0.0, 0.0, (0.5f / 255.0f).toDouble()).toRGBA32() == 1L)
        checkTrue(Color(-(0.5f / 255.0f).toDouble(), 0.0, 0.0, 0.0).toRGBA32() == 0xFF000000L)
        checkTrue(Color(1.0, 0.0, 0.0, 0.0).toHtml(false) == "ff0000")
    }

    @Test
    fun `8 bit setters divide in float like C++`() {
        checkTrue(Color().also { it.r8 = 240 }.r == Color.hex(0xF0000000u).r)
        checkTrue(Color().also { it.g8 = 51 }.g == 0.20000000298023224)
        checkTrue(Color().also { it.b8 = 255 }.b == 1.0)
        checkTrue(Color().also { it.a8 = 0 }.a == 0.0)
    }

    @Test
    fun `Value keeps the sign of zero like the C++ MAX macro`() {
        checkTrue(1.0 / Color(-0.0, 0.0, -0.0).v < 0.0)
        checkTrue(1.0 / Color(0.0, -0.0, 0.0).v > 0.0)
    }

    @Test
    fun `Floating point scalar times color`() {
        val color = Color(0.5, 0.25, 1.0, 0.75)
        checkTrue(2.0 * color == Color(1.0, 0.5, 2.0, 1.5))
        checkTrue(2.0f * color == Color(1.0, 0.5, 2.0, 1.5))
    }
}
