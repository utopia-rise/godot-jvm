@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.common.util.RealT
import godot.common.util.isEqualApprox
import godot.common.util.lerp
import godot.common.util.toRealT
import godot.internal.logging.GodotLogging
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.truncate

class Color : Comparable<Color>, CoreType {

    var r: RealT
    var g: RealT
    var b: RealT
    var a: RealT

    //PROPERTIES
    var r8: Int
        get() = toChannel8(r)
        set(value) {
            r = (value.coerceIn(0, 255) / 255.0f).toDouble()
        }
    var g8: Int
        get() = toChannel8(g)
        set(value) {
            g = (value.coerceIn(0, 255) / 255.0f).toDouble()
        }
    var b8: Int
        get() = toChannel8(b)
        set(value) {
            b = (value.coerceIn(0, 255) / 255.0f).toDouble()
        }
    var a8: Int
        get() = toChannel8(a)
        set(value) {
            a = (value.coerceIn(0, 255) / 255.0f).toDouble()
        }

    var h: RealT
        get() {
            var min: RealT = if (r < g) r else g
            min = if (min < b) min else b
            var max: RealT = if (r > g) r else g
            max = if (max > b) max else b

            val delta = max - min

            if (delta == 0.0) return 0.0

            var h: RealT
            h = when {
                r == max -> ((g - b) / delta) // between yellow & magenta
                g == max -> (2 + (b - r) / delta) // between cyan & yellow
                else -> (4 + (r - g) / delta) // between magenta & cyan
            }

            h /= 6.0f
            if (h < 0) {
                h += 1.0f
            }

            return h
        }
        set(value) {
            setHSV(value, s, v, a)
        }
    var s: RealT
        get() {
            var min: RealT = if (r < g) r else g
            min = if (min < b) min else b
            var max: RealT = if (r > g) r else g
            max = if (max > b) max else b

            val delta = max - min

            return if (max != 0.0) (delta / max).toRealT() else 0.0
        }
        set(value) {
            setHSV(h, value, v, a)
        }
    var v: RealT
        get() {
            var max: RealT = if (r > g) r else g
            max = if (max > b) max else b
            return max.toRealT()
        }
        set(value) {
            setHSV(h, s, value, a)
        }

    private fun setHSV(h: RealT, s: RealT, v: RealT, alpha: RealT) {
        val f: RealT
        val p = v * (1 - s)
        val q: RealT
        val t: RealT

        a = alpha
        if (s == 0.0) {
            // acp_chromatic (grey)
            r = v
            g = v
            b = v
            return
        }

        var h2 = h * 6.0
        h2 = h2.rem(6.0)

        val i = floor(h2).toInt()
        f = h2 - i
        q = v * (1 - s * f)
        t = v * (1 - s * (1 - f))

        when (i) {
            0 -> { // Red is the dominant color
                r = v
                g = t
                b = p
            }

            1 -> { // Green is the dominant color
                r = q
                g = v
                b = p
            }

            2 -> {
                r = p
                g = v
                b = t
            }

            3 -> { // Blue is the dominant color
                r = p
                g = q
                b = v
            }

            4 -> {
                r = t
                g = p
                b = v
            }

            else -> { // (5) Red is the dominant color
                r = v
                g = p
                b = q
            }
        }
    }

    //CONSTANTS
    private enum class ColorByte(val size: Int, val shift: Int) {
        BITS32(255, 8),
        BITS64(65535, 16)
    }

    companion object {
        inline val aliceBlue: Color
            get() = hex(0xF0F8FFFFu)
        inline val antiqueWhite: Color
            get() = hex(0xFAEBD7FFu)
        inline val aqua: Color
            get() = hex(0x00FFFFFFu)
        inline val aquamarine: Color
            get() = hex(0x7FFFD4FFu)
        inline val azure: Color
            get() = hex(0xF0FFFFFFu)
        inline val beige: Color
            get() = hex(0xF5F5DCFFu)
        inline val bisque: Color
            get() = hex(0xFFE4C4FFu)
        inline val black: Color
            get() = hex(0x000000FFu)
        inline val blanchedAlmond: Color
            get() = hex(0xFFEBCDFFu)
        inline val blue: Color
            get() = hex(0x0000FFFFu)
        inline val blueViolet: Color
            get() = hex(0x8A2BE2FFu)
        inline val brown: Color
            get() = hex(0xA52A2AFFu)
        inline val burlywood: Color
            get() = hex(0xDEB887FFu)
        inline val cadetBlue: Color
            get() = hex(0x5F9EA0FFu)
        inline val chartreuse: Color
            get() = hex(0x7FFF00FFu)
        inline val chocolate: Color
            get() = hex(0xD2691EFFu)
        inline val coral: Color
            get() = hex(0xFF7F50FFu)
        inline val cornflowerBlue: Color
            get() = hex(0x6495EDFFu)
        inline val cornsilk: Color
            get() = hex(0xFFF8DCFFu)
        inline val crimson: Color
            get() = hex(0xDC143CFFu)
        inline val cyan: Color
            get() = hex(0x00FFFFFFu)
        inline val darkBlue: Color
            get() = hex(0x00008BFFu)
        inline val darkCyan: Color
            get() = hex(0x008B8BFFu)
        inline val darkGoldenrod: Color
            get() = hex(0xB8860BFFu)
        inline val darkGray: Color
            get() = hex(0xA9A9A9FFu)
        inline val darkGreen: Color
            get() = hex(0x006400FFu)
        inline val darkKhaki: Color
            get() = hex(0xBDB76BFFu)
        inline val darkMagenta: Color
            get() = hex(0x8B008BFFu)
        inline val darkOliveGreen: Color
            get() = hex(0x556B2FFFu)
        inline val darkorange: Color
            get() = hex(0xFF8C00FFu)
        inline val darkOrchid: Color
            get() = hex(0x9932CCFFu)
        inline val darkRed: Color
            get() = hex(0x8B0000FFu)
        inline val darkSalmon: Color
            get() = hex(0xE9967AFFu)
        inline val darkSeaGreen: Color
            get() = hex(0x8FBC8FFFu)
        inline val darkSlateBlue: Color
            get() = hex(0x483D8BFFu)
        inline val darkSlateGray: Color
            get() = hex(0x2F4F4FFFu)
        inline val darkTurquoise: Color
            get() = hex(0x00CED1FFu)
        inline val darkViolet: Color
            get() = hex(0x9400D3FFu)
        inline val deepPink: Color
            get() = hex(0xFF1493FFu)
        inline val deepSkyBlue: Color
            get() = hex(0x00BFFFFFu)
        inline val dimGray: Color
            get() = hex(0x696969FFu)
        inline val dodgerBlue: Color
            get() = hex(0x1E90FFFFu)
        inline val firebrick: Color
            get() = hex(0xB22222FFu)
        inline val floralWhite: Color
            get() = hex(0xFFFAF0FFu)
        inline val forestGreen: Color
            get() = hex(0x228B22FFu)
        inline val fuchsia: Color
            get() = hex(0xFF00FFFFu)
        inline val gainsboro: Color
            get() = hex(0xDCDCDCFFu)
        inline val ghostWhite: Color
            get() = hex(0xF8F8FFFFu)
        inline val gold: Color
            get() = hex(0xFFD700FFu)
        inline val goldenrod: Color
            get() = hex(0xDAA520FFu)
        inline val gray: Color
            get() = hex(0xBEBEBEFFu)
        inline val green: Color
            get() = hex(0x00FF00FFu)
        inline val greenYellow: Color
            get() = hex(0xADFF2FFFu)
        inline val honeydew: Color
            get() = hex(0xF0FFF0FFu)
        inline val hotPink: Color
            get() = hex(0xFF69B4FFu)
        inline val indianRed: Color
            get() = hex(0xCD5C5CFFu)
        inline val indigo: Color
            get() = hex(0x4B0082FFu)
        inline val ivory: Color
            get() = hex(0xFFFFF0FFu)
        inline val khaki: Color
            get() = hex(0xF0E68CFFu)
        inline val lavender: Color
            get() = hex(0xE6E6FAFFu)
        inline val lavenderBlush: Color
            get() = hex(0xFFF0F5FFu)
        inline val lawnGreen: Color
            get() = hex(0x7CFC00FFu)
        inline val lemonChiffon: Color
            get() = hex(0xFFFACDFFu)
        inline val lightBlue: Color
            get() = hex(0xADD8E6FFu)
        inline val lightCoral: Color
            get() = hex(0xF08080FFu)
        inline val lightCyan: Color
            get() = hex(0xE0FFFFFFu)
        inline val lightGoldenrod: Color
            get() = hex(0xFAFAD2FFu)
        inline val lightGray: Color
            get() = hex(0xD3D3D3FFu)
        inline val lightGreen: Color
            get() = hex(0x90EE90FFu)
        inline val lightPink: Color
            get() = hex(0xFFB6C1FFu)
        inline val lightSalmon: Color
            get() = hex(0xFFA07AFFu)
        inline val lightSeaGreen: Color
            get() = hex(0x20B2AAFFu)
        inline val lightSkyBlue: Color
            get() = hex(0x87CEFAFFu)
        inline val lightSlateGray: Color
            get() = hex(0x778899FFu)
        inline val lightSteelBlue: Color
            get() = hex(0xB0C4DEFFu)
        inline val lightYellow: Color
            get() = hex(0xFFFFE0FFu)
        inline val lime: Color
            get() = hex(0x00FF00FFu)
        inline val limeGreen: Color
            get() = hex(0x32CD32FFu)
        inline val linen: Color
            get() = hex(0xFAF0E6FFu)
        inline val magenta: Color
            get() = hex(0xFF00FFFFu)
        inline val maroon: Color
            get() = hex(0xB03060FFu)
        inline val mediumAquamarine: Color
            get() = hex(0x66CDAAFFu)
        inline val mediumBlue: Color
            get() = hex(0x0000CDFFu)
        inline val mediumOrchid: Color
            get() = hex(0xBA55D3FFu)
        inline val mediumPurple: Color
            get() = hex(0x9370DBFFu)
        inline val mediumSeaGreen: Color
            get() = hex(0x3CB371FFu)
        inline val mediumSlateBlue: Color
            get() = hex(0x7B68EEFFu)
        inline val mediumSpringGreen: Color
            get() = hex(0x00FA9AFFu)
        inline val mediumTurquoise: Color
            get() = hex(0x48D1CCFFu)
        inline val mediumVioletRed: Color
            get() = hex(0xC71585FFu)
        inline val midnightBlue: Color
            get() = hex(0x191970FFu)
        inline val mintCream: Color
            get() = hex(0xF5FFFAFFu)
        inline val mistyRose: Color
            get() = hex(0xFFE4E1FFu)
        inline val moccasin: Color
            get() = hex(0xFFE4B5FFu)
        inline val navajoWhite: Color
            get() = hex(0xFFDEADFFu)
        inline val navyBlue: Color
            get() = hex(0x000080FFu)
        inline val oldLace: Color
            get() = hex(0xFDF5E6FFu)
        inline val olive: Color
            get() = hex(0x808000FFu)
        inline val oliveDrab: Color
            get() = hex(0x6B8E23FFu)
        inline val orange: Color
            get() = hex(0xFFA500FFu)
        inline val orangeRed: Color
            get() = hex(0xFF4500FFu)
        inline val orchid: Color
            get() = hex(0xDA70D6FFu)
        inline val paleGoldenrod: Color
            get() = hex(0xEEE8AAFFu)
        inline val paleGreen: Color
            get() = hex(0x98FB98FFu)
        inline val paleTurquoise: Color
            get() = hex(0xAFEEEEFFu)
        inline val paleVioletRed: Color
            get() = hex(0xDB7093FFu)
        inline val papayaWhip: Color
            get() = hex(0xFFEFD5FFu)
        inline val peachPuff: Color
            get() = hex(0xFFDAB9FFu)
        inline val peru: Color
            get() = hex(0xCD853FFFu)
        inline val pink: Color
            get() = hex(0xFFC0CBFFu)
        inline val plum: Color
            get() = hex(0xDDA0DDFFu)
        inline val powderBlue: Color
            get() = hex(0xB0E0E6FFu)
        inline val purple: Color
            get() = hex(0xA020F0FFu)
        inline val rebeccaPurple: Color
            get() = hex(0x663399FFu)
        inline val red: Color
            get() = hex(0xFF0000FFu)
        inline val rosyBrown: Color
            get() = hex(0xBC8F8FFFu)
        inline val royalBlue: Color
            get() = hex(0x4169E1FFu)
        inline val saddleBrown: Color
            get() = hex(0x8B4513FFu)
        inline val salmon: Color
            get() = hex(0xFA8072FFu)
        inline val sandyBrown: Color
            get() = hex(0xF4A460FFu)
        inline val seaGreen: Color
            get() = hex(0x2E8B57FFu)
        inline val seashell: Color
            get() = hex(0xFFF5EEFFu)
        inline val sienna: Color
            get() = hex(0xA0522DFFu)
        inline val silver: Color
            get() = hex(0xC0C0C0FFu)
        inline val skyBlue: Color
            get() = hex(0x87CEEBFFu)
        inline val slateBlue: Color
            get() = hex(0x6A5ACDFFu)
        inline val slateGray: Color
            get() = hex(0x708090FFu)
        inline val snow: Color
            get() = hex(0xFFFAFAFFu)
        inline val springGreen: Color
            get() = hex(0x00FF7FFFu)
        inline val steelBlue: Color
            get() = hex(0x4682B4FFu)
        inline val tan: Color
            get() = hex(0xD2B48CFFu)
        inline val teal: Color
            get() = hex(0x008080FFu)
        inline val thistle: Color
            get() = hex(0xD8BFD8FFu)
        inline val tomato: Color
            get() = hex(0xFF6347FFu)
        inline val transparent: Color
            get() = hex(0xFFFFFF00u)
        inline val turquoise: Color
            get() = hex(0x40E0D0FFu)
        inline val violet: Color
            get() = hex(0xEE82EEFFu)
        inline val webGray: Color
            get() = hex(0x808080FFu)
        inline val webGreen: Color
            get() = hex(0x008000FFu)
        inline val webMaroon: Color
            get() = hex(0x800000FFu)
        inline val webPurple: Color
            get() = hex(0x800080FFu)
        inline val wheat: Color
            get() = hex(0xF5DEB3FFu)
        inline val white: Color
            get() = hex(0xFFFFFFFFu)
        inline val whiteSmoke: Color
            get() = hex(0xF5F5F5FFu)
        inline val yellow: Color
            get() = hex(0xFFFF00FFu)
        inline val yellowGreen: Color
            get() = hex(0x9ACD32FFu)

        internal fun parseCol(p_str: String, p_ofs: Int): RealT {
            var ig = 0.0
            for (i in 0..1) {
                var v: Int

                when (val c: Char = p_str[i + p_ofs]) {
                    in '0'..'9' -> v = c.code - '0'.code
                    in 'a'..'f' -> {
                        v = c.code - 'a'.code
                        v += 10
                    }

                    in 'A'..'F' -> {
                        v = c.code - 'A'.code
                        v += 10
                    }

                    else -> return -1.0
                }

                ig += if (i == 0)
                    v * 16
                else
                    v
            }
            return ig
        }

        /**
         * Constructs a color from an HSV profile. h, s, and v are values between 0 and 1.
         */
        fun fromHsv(h: RealT, s: RealT, v: RealT, a: RealT = 1.0): Color {
            val color = Color()
            color.setHSV(h, s, v, a)
            return color
        }

        /**
         * Decodes a Color from a RGBE9995 format integer. See Image.FORMAT_RGBE9995.
         */
        fun fromRgbe9995(rgbe: Int): Color {
            val r = rgbe and 0x1ff
            val g = (rgbe shr 9) and 0x1ff
            val b = (rgbe shr 18) and 0x1ff
            val e = (rgbe ushr 27)
            val m = 2.0.pow(e - 15.0 - 9.0)

            val rd = r * m
            val gd = g * m
            val bd = b * m

            return Color(rd, gd, bd, 1.0f)
        }

        /**
         * 	Returns a [Color] constructed from red ([param r8]), green ([param g8]), blue ([param b8]), and optionally alpha ([param a8]) integer channels, each divided by 255.0 for their final value.
         * 	```
         * 	var red = Color.fromRgba(255, 0, 0)             # Same as Color(1, 0, 0).
         * 	var darkBlue = Color.fromRgba(0, 0, 51)        # Same as Color(0, 0, 0.2).
         * 	var myColor = Color.fromRgba(306, 255, 0, 102) # Same as Color(1.2, 1, 0, 0.4).
         * 	```
         * 	***Note:*** Due to the lower precision of [fromRgba] compared to the standard [Color] constructor, a color created with [fromRgba] will generally not be equal to the same color created with the standard [Color] constructor.
         * 	Use [isEqualApprox] for comparisons to avoid issues with floating-point precision error.
         */
        fun fromRgba(r: Int, g: Int, b: Int, a: Int = 255): Color {
            return Color(r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f);
        }

        fun fromRgba8(r8: Int, g8: Int, b8: Int, a8: Int = 255): Color = fromRgba(r8, g8, b8, a8)

        /**
         * Creates a Color from the given string, which can be either an HTML color code or a named color
         * (case-insensitive). Returns default if the color cannot be inferred from the string.
         */
        fun fromString(str: String, default: Color): Color {
            if (htmlIsValid(str)) {
                return html(str)
            }
            val idx = findNamedColor(str)
            return if (idx == -1) Color(default) else Color(namedColors[idx].second)
        }

        //Color construction helpers
        fun html(from: String): Color {
            var color = from
            if (color.isEmpty()) {
                return Color()
            }

            color = color.removePrefix("#")

            val isShorthand = color.length < 5

            val alpha = when (color.length) {
                8, 4 -> {
                    true
                }

                6, 3 -> {
                    false
                }

                else -> {
                    if (GodotJvmBuildConfig.DEBUG) {
                        GodotLogging.error("Invalid color code: $from.")
                    }
                    return Color()
                }
            }

            val r: Float
            val g: Float
            val b: Float
            var a = 1.0f

            if (isShorthand) {
                r = parseCol4(color, 0) / 15.0f
                g = parseCol4(color, 1) / 15.0f
                b = parseCol4(color, 2) / 15.0f
                if (alpha) {
                    a = parseCol4(color, 3) / 15.0f
                }
            } else {
                r = parseCol8(color, 0) / 255.0f
                g = parseCol8(color, 2) / 255.0f
                b = parseCol8(color, 4) / 255.0f
                if (alpha) {
                    a = parseCol8(color, 6) / 255.0f
                }
            }

            if (GodotJvmBuildConfig.DEBUG && (r < 0.0f || g < 0.0f || b < 0.0f || a < 0.0f)) {
                GodotLogging.error("Invalid color code: $from.")
                return Color()
            }

            return Color(r, g, b, a)
        }

        fun hex(from: UInt): Color {
            val a = ((from and 0xFFu).toFloat() / 255.0f).toDouble()
            var hex = from shr 8
            val b = ((hex and 0xFFu).toFloat() / 255.0f).toDouble()
            hex = hex shr 8
            val g = ((hex and 0xFFu).toFloat() / 255.0f).toDouble()
            hex = hex shr 8
            val r = ((hex and 0xFFu).toFloat() / 255.0f).toDouble()
            return Color(r, g, b, a)
        }

        fun hex64(from: ULong): Color {
            val a = ((from and 0xFFFFu).toFloat() / 65535.0f).toDouble()
            var hex = from shr 16
            val b = ((hex and 0xFFFFu).toFloat() / 65535.0f).toDouble()
            hex = hex shr 16
            val g = ((hex and 0xFFFFu).toFloat() / 65535.0f).toDouble()
            hex = hex shr 16
            val r = ((hex and 0xFFFFu).toFloat() / 65535.0f).toDouble()
            return Color(r, g, b, a)
        }

        private val namedColors = arrayOf(
            "ALICE_BLUE" to aliceBlue,
            "ANTIQUE_WHITE" to antiqueWhite,
            "AQUA" to aqua,
            "AQUAMARINE" to aquamarine,
            "AZURE" to azure,
            "BEIGE" to beige,
            "BISQUE" to bisque,
            "BLACK" to black,
            "BLANCHED_ALMOND" to blanchedAlmond,
            "BLUE" to blue,
            "BLUE_VIOLET" to blueViolet,
            "BROWN" to brown,
            "BURLYWOOD" to burlywood,
            "CADET_BLUE" to cadetBlue,
            "CHARTREUSE" to chartreuse,
            "CHOCOLATE" to chocolate,
            "CORAL" to coral,
            "CORNFLOWER_BLUE" to cornflowerBlue,
            "CORNSILK" to cornsilk,
            "CRIMSON" to crimson,
            "CYAN" to cyan,
            "DARK_BLUE" to darkBlue,
            "DARK_CYAN" to darkCyan,
            "DARK_GOLDENROD" to darkGoldenrod,
            "DARK_GRAY" to darkGray,
            "DARK_GREEN" to darkGreen,
            "DARK_KHAKI" to darkKhaki,
            "DARK_MAGENTA" to darkMagenta,
            "DARK_OLIVE_GREEN" to darkOliveGreen,
            "DARK_ORANGE" to darkorange,
            "DARK_ORCHID" to darkOrchid,
            "DARK_RED" to darkRed,
            "DARK_SALMON" to darkSalmon,
            "DARK_SEA_GREEN" to darkSeaGreen,
            "DARK_SLATE_BLUE" to darkSlateBlue,
            "DARK_SLATE_GRAY" to darkSlateGray,
            "DARK_TURQUOISE" to darkTurquoise,
            "DARK_VIOLET" to darkViolet,
            "DEEP_PINK" to deepPink,
            "DEEP_SKY_BLUE" to deepSkyBlue,
            "DIM_GRAY" to dimGray,
            "DODGER_BLUE" to dodgerBlue,
            "FIREBRICK" to firebrick,
            "FLORAL_WHITE" to floralWhite,
            "FOREST_GREEN" to forestGreen,
            "FUCHSIA" to fuchsia,
            "GAINSBORO" to gainsboro,
            "GHOST_WHITE" to ghostWhite,
            "GOLD" to gold,
            "GOLDENROD" to goldenrod,
            "GRAY" to gray,
            "GREEN" to green,
            "GREEN_YELLOW" to greenYellow,
            "HONEYDEW" to honeydew,
            "HOT_PINK" to hotPink,
            "INDIAN_RED" to indianRed,
            "INDIGO" to indigo,
            "IVORY" to ivory,
            "KHAKI" to khaki,
            "LAVENDER" to lavender,
            "LAVENDER_BLUSH" to lavenderBlush,
            "LAWN_GREEN" to lawnGreen,
            "LEMON_CHIFFON" to lemonChiffon,
            "LIGHT_BLUE" to lightBlue,
            "LIGHT_CORAL" to lightCoral,
            "LIGHT_CYAN" to lightCyan,
            "LIGHT_GOLDENROD" to lightGoldenrod,
            "LIGHT_GRAY" to lightGray,
            "LIGHT_GREEN" to lightGreen,
            "LIGHT_PINK" to lightPink,
            "LIGHT_SALMON" to lightSalmon,
            "LIGHT_SEA_GREEN" to lightSeaGreen,
            "LIGHT_SKY_BLUE" to lightSkyBlue,
            "LIGHT_SLATE_GRAY" to lightSlateGray,
            "LIGHT_STEEL_BLUE" to lightSteelBlue,
            "LIGHT_YELLOW" to lightYellow,
            "LIME" to lime,
            "LIME_GREEN" to limeGreen,
            "LINEN" to linen,
            "MAGENTA" to magenta,
            "MAROON" to maroon,
            "MEDIUM_AQUAMARINE" to mediumAquamarine,
            "MEDIUM_BLUE" to mediumBlue,
            "MEDIUM_ORCHID" to mediumOrchid,
            "MEDIUM_PURPLE" to mediumPurple,
            "MEDIUM_SEA_GREEN" to mediumSeaGreen,
            "MEDIUM_SLATE_BLUE" to mediumSlateBlue,
            "MEDIUM_SPRING_GREEN" to mediumSpringGreen,
            "MEDIUM_TURQUOISE" to mediumTurquoise,
            "MEDIUM_VIOLET_RED" to mediumVioletRed,
            "MIDNIGHT_BLUE" to midnightBlue,
            "MINT_CREAM" to mintCream,
            "MISTY_ROSE" to mistyRose,
            "MOCCASIN" to moccasin,
            "NAVAJO_WHITE" to navajoWhite,
            "NAVY_BLUE" to navyBlue,
            "OLD_LACE" to oldLace,
            "OLIVE" to olive,
            "OLIVE_DRAB" to oliveDrab,
            "ORANGE" to orange,
            "ORANGE_RED" to orangeRed,
            "ORCHID" to orchid,
            "PALE_GOLDENROD" to paleGoldenrod,
            "PALE_GREEN" to paleGreen,
            "PALE_TURQUOISE" to paleTurquoise,
            "PALE_VIOLET_RED" to paleVioletRed,
            "PAPAYA_WHIP" to papayaWhip,
            "PEACH_PUFF" to peachPuff,
            "PERU" to peru,
            "PINK" to pink,
            "PLUM" to plum,
            "POWDER_BLUE" to powderBlue,
            "PURPLE" to purple,
            "REBECCA_PURPLE" to rebeccaPurple,
            "RED" to red,
            "ROSY_BROWN" to rosyBrown,
            "ROYAL_BLUE" to royalBlue,
            "SADDLE_BROWN" to saddleBrown,
            "SALMON" to salmon,
            "SANDY_BROWN" to sandyBrown,
            "SEA_GREEN" to seaGreen,
            "SEASHELL" to seashell,
            "SIENNA" to sienna,
            "SILVER" to silver,
            "SKY_BLUE" to skyBlue,
            "SLATE_BLUE" to slateBlue,
            "SLATE_GRAY" to slateGray,
            "SNOW" to snow,
            "SPRING_GREEN" to springGreen,
            "STEEL_BLUE" to steelBlue,
            "TAN" to tan,
            "TEAL" to teal,
            "THISTLE" to thistle,
            "TOMATO" to tomato,
            "TRANSPARENT" to transparent,
            "TURQUOISE" to turquoise,
            "VIOLET" to violet,
            "WEB_GRAY" to webGray,
            "WEB_GREEN" to webGreen,
            "WEB_MAROON" to webMaroon,
            "WEB_PURPLE" to webPurple,
            "WHEAT" to wheat,
            "WHITE" to white,
            "WHITE_SMOKE" to whiteSmoke,
            "YELLOW" to yellow,
            "YELLOW_GREEN" to yellowGreen,
            null to Color(),
        )

        private fun findNamedColor(name: String): Int {
            var nameCopy = name
            // Normalize name
            nameCopy = nameCopy.replace(" ", "")
            nameCopy = nameCopy.replace("-", "")
            nameCopy = nameCopy.replace("_", "")
            nameCopy = nameCopy.replace("'", "")
            nameCopy = nameCopy.replace(".", "")
            nameCopy = nameCopy.uppercase()

            var idx = 0
            var color = namedColors[idx].first
            while (color != null) {
                if (nameCopy == color.replace("_", "")) {
                    return idx
                }
                idx++
                color = namedColors[idx].first
            }

            return -1
        }

        val namedColorCount = namedColors.size - 1

        internal fun named(name: String): Color {
            val idx: Int = findNamedColor(name)
            return if (idx == -1) {
                if (GodotJvmBuildConfig.DEBUG) {
                    GodotLogging.error("Invalid color name: $name.")
                }
                Color()
            } else Color(namedColors[idx].second)
        }

        private fun parseCol4(str: String, ofs: Int) = when (val character: Char = str[ofs]) {
            in '0'..'9' -> {
                character.code - '0'.code
            }

            in 'a'..'f' -> {
                character.code + (10 - 'a'.code)
            }

            in 'A'..'F' -> {
                character.code + (10 - 'A'.code)
            }

            else -> -1
        }

        private fun parseCol8(str: String, ofs: Int) = parseCol4(str, ofs) * 16 + parseCol4(str, ofs + 1)

        /**
         * Returns true if color is a valid HTML hexadecimal color string. The string must be a hexadecimal value
         * (case-insensitive) of either 3, 4, 6 or 8 digits, and may be prefixed by a hash sign (#). This method is
         * identical to String.is_valid_html_color.
         */
        fun htmlIsValid(color: String): Boolean {
            var clr: String = color

            if (clr.isEmpty()) {
                return false
            }
            if (clr[0] == '#') {
                clr = clr.substring(1)
            }

            // Check if the amount of hex digits is valid.
            val len = clr.length
            if (!(len == 3 || len == 4 || len == 6 || len == 8)) {
                return false
            }

            // Check if each hex digit is valid.
            for (i in 0 until len) {
                if (parseCol4(clr, i) == -1) {
                    return false
                }
            }

            return true
        }

        operator fun invoke(code: String) = if (htmlIsValid(code)) html(code) else named(code)

        operator fun invoke(code: String, a: RealT) = invoke(code).also { it.a = a }
    }

    //CONSTRUCTOR
    constructor() {
        r = 0.0
        g = 0.0
        b = 0.0
        a = 1.0
    }

    constructor(other: Color) {
        r = other.r
        g = other.g
        b = other.b
        a = other.a
    }

    constructor(other: Color, alpha: RealT = 1.0) {
        r = other.r
        g = other.g
        b = other.b
        a = alpha
    }

    constructor(r: Number, g: Number, b: Number, a: Number = 1.0) {
        this.r = r.toRealT()
        this.g = g.toRealT()
        this.b = b.toRealT()
        this.a = a.toRealT()
    }
    //API
    /**
     * Returns a new color resulting from blending this color over another.
     * If the color is opaque, the result is also opaque. The second color may have a range of alpha values.
     */
    fun blend(over: Color): Color {
        val res = Color()
        val sa = 1.0 - over.a
        res.a = a * sa + over.a
        if (res.a == 0.0) {
            return Color(0.0, 0.0, 0.0, 0.0)
        } else {
            res.r = (r * a * sa + over.r * over.a) / res.a
            res.g = (g * a * sa + over.g * over.a) / res.a
            res.b = (b * a * sa + over.b * over.a) / res.a
        }
        return res
    }

    /**
     * Returns a new color with all components clamped between the components of [min] and [max], by running clamp on
     * each component.
     */
    fun clamp(min: Color = Color(0, 0, 0, 0), max: Color = Color(1, 1, 1, 1)) = Color(
        clampComponent(r, min.r, max.r),
        clampComponent(g, min.g, max.g),
        clampComponent(b, min.b, max.b),
        clampComponent(a, min.a, max.a),
    )

    /**
     * Returns the most contrasting color.
     */
    fun contrasted(): Color {
        val c = Color(r, g, b, a)
        c.contrast()
        return c
    }


    internal fun contrast() {
        r = (r + 0.5).rem(1.0)
        g = (g + 0.5).rem(1.0)
        b = (b + 0.5).rem(1.0)
    }

    /**
     * Returns a new color resulting from making this color darker by the specified percentage (ratio from 0 to 1).
     */
    fun darkened(amount: RealT): Color {
        return Color(
            r * (1.0 - amount),
            g * (1.0 - amount),
            b * (1.0 - amount),
            a
        )
    }

    /**
     * Returns the light intensity of the color, as a value between 0.0 and 1.0 (inclusive). This is useful when
     * determining light or dark color. Colors with a luminance smaller than 0.5 can be generally considered dark.
     *
     * Note: get_luminance relies on the color being in the linear color space to return an accurate relative luminance
     * value. If the color is in the sRGB color space, use srgb_to_linear to convert it to the linear color space first.
     */
    fun getLuminance() = 0.2126f * r + 0.7152f * g + 0.0722f * b

    /**
     * Returns the color’s grayscale representation.
     * The gray value is calculated as (r + g + b) / 3.
     */
    fun gray(): RealT = (r + g + b) / 3.0

    /**
     * Returns the inverted color (1 - r, 1 - g, 1 - b, a).
     */
    fun inverted(): Color {
        val c = Color(r, g, b, a)
        c.invert()
        return c
    }

    internal fun invert() {
        r = 1.0 - r
        g = 1.0 - g
        b = 1.0 - b
    }

    /**
     * Returns true if this color and color are approximately equal, by running isEqualApprox on each component.
     */
    fun isEqualApprox(color: Color): Boolean {
        return r.isEqualApprox(color.r)
            && g.isEqualApprox(color.g)
            && b.isEqualApprox(color.b)
            && a.isEqualApprox(color.a)
    }

    /**
     * Returns the linear interpolation between this color's components and [to]'s components. The interpolation factor
     * [weight] should be between 0.0 and 1.0 (inclusive). See also @GlobalScope.lerp.
     */
    fun lerp(to: Color, weight: RealT): Color {
        val res = Color(this)
        res.r = lerp(r, to.r, weight)
        res.g = lerp(g, to.g, weight)
        res.b = lerp(b, to.b, weight)
        res.a = lerp(a, to.a, weight)

        return res
    }

    /**
     * Returns a new color resulting from making this color lighter by the specified percentage (ratio from 0 to 1).
     */
    fun lightened(amount: RealT): Color {
        return Color(
            r + (1.0 - r) * amount,
            g + (1.0 - g) * amount,
            b + (1.0 - b) * amount,
            a
        )
    }

    /**
     * Returns the linear interpolation with another color. The interpolation factor t is between 0 and 1.
     */
    fun linearInterpolate(otherColor: Color, t: RealT): Color {
        val res = Color(r, g, b, a)
        res.r += (t * (otherColor.r - r))
        res.g += (t * (otherColor.g - g))
        res.b += (t * (otherColor.b - b))
        res.a += (t * (otherColor.a - a))
        return res
    }

    /**
     * Returns the color converted to the sRGB color space. This method assumes the original color is in the linear
     * color space. See also srgb_to_linear which performs the opposite operation.
     */
    fun linearToSrgb() = Color(
        if (r < 0.0031308f) 12.92f * r else (1.0 + 0.055) * r.pow((1.0f / 2.4f).toDouble()) - 0.055,
        if (g < 0.0031308f) 12.92f * g else (1.0 + 0.055) * g.pow((1.0f / 2.4f).toDouble()) - 0.055,
        if (b < 0.0031308f) 12.92f * b else (1.0 + 0.055) * b.pow((1.0f / 2.4f).toDouble()) - 0.055,
        a
    )

    /**
     * Returns the color converted to the linear color space. This method assumes the original color already is in the
     * sRGB color space. See also linear_to_srgb which performs the opposite operation.
     */
    fun srgbToLinear() = Color(
        if (r < 0.04045f) r * (1.0f / 12.92f) else ((r + 0.055) * (1.0 / (1.0 + 0.055))).pow(2.4f.toDouble()),
        if (g < 0.04045f) g * (1.0f / 12.92f) else ((g + 0.055) * (1.0 / (1.0 + 0.055))).pow(2.4f.toDouble()),
        if (b < 0.04045f) b * (1.0f / 12.92f) else ((b + 0.055) * (1.0 / (1.0 + 0.055))).pow(2.4f.toDouble()),
        a
    )

    /**
     * Returns the color’s 32-bit integer in ABGR format (each byte represents a component of the ABGR profile).
     * ABGR is the reversed version of the default format.
     */
    fun toABGR32(): Long = toByteColorCode(a, b, g, r, ColorByte.BITS32)

    /**
     * Returns the color’s 64-bit integer in ABGR format (each word represents a component of the ABGR profile).
     * ABGR is the reversed version of the default format.
     */
    fun toABGR64(): Long = toByteColorCode(a, b, g, r, ColorByte.BITS64)

    /**
     * Returns the color’s 32-bit integer in ARGB format (each byte represents a component of the ARGB profile).
     * ARGB is more compatible with DirectX.
     */
    fun toARGB32(): Long = toByteColorCode(a, r, g, b, ColorByte.BITS32)

    /**
     * Returns the color’s 64-bit integer in ARGB format (each word represents a component of the ARGB profile).
     * ARGB is more compatible with DirectX.
     */
    fun toARGB64(): Long = toByteColorCode(a, r, g, b, ColorByte.BITS64)

    /**
     * Returns the color’s 32-bit integer in RGBA format (each byte represents a component of the RGBA profile).
     * RGBA is Godot’s default format.
     */
    fun toRGBA32(): Long = toByteColorCode(r, g, b, a, ColorByte.BITS32)

    /**
    Returns the color’s 64-bit integer in RGBA format (each word represents a component of the RGBA profile).
    RGBA is Godot’s default format.
     */
    fun toRGBA64(): Long = toByteColorCode(r, g, b, a, ColorByte.BITS64)

    private fun toByteColorCode(first: RealT, second: RealT, third: RealT, fourth: RealT, colorByte: ColorByte): Long {
        val size = colorByte.size
        val mask = size.toLong()
        var c = 0L
        for (channel in doubleArrayOf(first, second, third, fourth)) {
            c = (c shl colorByte.shift) or (roundHalfAway(channel * size).toLong() and mask)
        }
        return c
    }

    /**
     * Returns the color’s HTML hexadecimal color string in RGBA format (ex: 34f822ff).
     * Setting with_alpha to false excludes alpha from the hexadecimal string.
     */
    fun toHtml(alpha: Boolean = true): String {
        var txt = ""
        txt += toHex(r)
        txt += toHex(g)
        txt += toHex(b)
        if (alpha) {
            txt += toHex(a)
        }
        return txt
    }

    private fun toHex(value: RealT): String {
        var v = toChannel8(value)
        var ret = ""

        for (i in 0..1) {
            val c = shortArrayOf(0, 0)
            val lv = v and 0xF
            if (lv < 10) {
                c[0] = ('0'.code + lv).toShort()
            } else {
                c[0] = ('a'.code + lv - 10).toShort()
            }

            v = v ushr 4
            val cs = String(charArrayOf(c[0].toInt().toChar()))
            ret = cs + ret
        }
        return ret
    }

    override fun equals(other: Any?): Boolean = when (other) {
        is Color -> (this.r == other.r && this.g == other.g && this.b == other.b &&
            this.a == other.a)

        else -> false
    }

    operator fun get(n: Int): RealT = when (n) {
        0 -> r
        1 -> g
        2 -> b
        3 -> a
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(n: Int, f: RealT) = when (n) {
        0 -> r = f
        1 -> g = f
        2 -> b = f
        3 -> a = f
        else -> throw IndexOutOfBoundsException()
    }

    operator fun unaryPlus() = Color(this)

    operator fun unaryMinus() = Color(1.0 - r, 1.0 - g, 1.0 - b, 1.0 - a)

    operator fun plus(c: Color) = Color(r + c.r, g + c.g, b + c.b, a + c.a)
    operator fun plus(scalar: Float) = Color(r + scalar, g + scalar, b + scalar, a + scalar)
    operator fun plus(scalar: Double) = Color(r + scalar, g + scalar, b + scalar, a + scalar)


    operator fun minus(c: Color) = Color(r - c.r, g - c.g, b - c.b, a - c.a)
    operator fun minus(scalar: Float) = Color(r - scalar, g - scalar, b - scalar, a - scalar)
    operator fun minus(scalar: Double) = Color(r - scalar, g - scalar, b - scalar, a - scalar)

    operator fun times(c: Color) = Color(r * c.r, g * c.g, b * c.b, a * c.a)
    operator fun times(scalar: Float) = Color(r * scalar, g * scalar, b * scalar, a * scalar)
    operator fun times(scalar: Double) = Color(r * scalar, g * scalar, b * scalar, a * scalar)

    operator fun div(c: Color) = Color(r / c.r, g / c.g, b / c.b, a / c.a)
    operator fun div(scalar: Float) = Color(r / scalar, g / scalar, b / scalar, a / scalar)
    operator fun div(scalar: Double) = Color(r / scalar, g / scalar, b / scalar, a / scalar)
    operator fun times(scalar: Int) = Color(r * scalar, g * scalar, b * scalar, a * scalar)
    operator fun div(scalar: Int) = Color(r / scalar, g / scalar, b / scalar, a / scalar)

    override fun compareTo(other: Color): Int {
        return when {
            r == other.r -> when {
                g == other.g -> when {
                    b == other.b -> when {
                        a < other.a -> -1
                        a == other.a -> 0
                        else -> 1
                    }

                    b < other.b -> -1
                    else -> 1
                }

                g < other.g -> -1
                else -> 1
            }

            r < other.r -> -1
            else -> 1
        }
    }

    override fun toString(): String {
        return "$r, $g, $b, $a"
    }

    override fun hashCode(): Int {
        var result = (r + 0.0).hashCode()
        result = 31 * result + (g + 0.0).hashCode()
        result = 31 * result + (b + 0.0).hashCode()
        result = 31 * result + (a + 0.0).hashCode()
        return result
    }
}

operator fun Int.times(color: Color) = color * this

operator fun Double.times(color: Color) = color * this

operator fun Float.times(color: Color) = color * this

private fun roundHalfAway(value: RealT): RealT {
    val t = truncate(value)
    return if (abs(value - t) >= 0.5) t + (if (value < 0.0) -1.0 else 1.0) else t
}

private fun clampComponent(value: RealT, min: RealT, max: RealT): RealT = if (value < min) min else if (value > max) max else value

private fun toChannel8(value: RealT): Int = clampComponent(roundHalfAway(value * 255.0), 0.0, 255.0).toInt()
