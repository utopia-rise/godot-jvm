@file:Suppress("unused")

package godot.global

import godot.api.Object
import godot.api.RandomNumberGenerator
import godot.api.Resource
import godot.api.ResourceLoader
import godot.core.NodePath
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedFloat64Array
import godot.core.PackedInt32Array
import godot.core.PackedStringArray
import godot.core.PackedVector2Array
import godot.core.PackedVector3Array
import godot.internal.memory.MemoryManager
import godot.extension.asStatic
import godot.extension.loadAs
import godot.common.interop.nullptr
import godot.common.util.DB2NEPER
import godot.common.util.NEPER2DB
import godot.common.util.TAU
import godot.common.util.bezierDerivative as bezierDerivativeImpl
import godot.common.util.fposmod
import godot.common.util.isEqualApprox
import godot.common.util.isZeroApprox
import godot.common.util.snapped as snap
import godot.common.util.toRealT
import godot.core.Color
import godot.core.Dictionary
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector3
import godot.internal.logging.GodotPrint
import kotlin.math.pow
import kotlin.math.sign


object GD {
    //region Core

    /** Asserts that the condition is true.
    If the condition is false, an error is generated and the program is halted until you resume it.
    Only executes in debug builds. Use it for debugging purposes, to make sure a statement is true during development. */
    @JvmStatic
    @JvmOverloads
    fun assert(condition: Boolean, message: String = "") = assert(condition) { message }

    /** Returns whether instance is a valid object (e.g. has not been deleted from memory).*/
    @JvmStatic
    fun isInstanceValid(instance: Object?): Boolean {
        if (instance != null) {
            return instance.ptr != nullptr && MemoryManager.isInstanceValid(instance)
        }
        return false
    }

    /** Returns length of Variant var
     * Note: Generates a fatal error if Variant can not provide a length.
     * */
    @JvmStatic
    fun len(what: Any?): Int {
        if (what is Collection<*>) {
            return what.size
        } else if (what is Map<*, *>) {
            return what.size
        }

        return when (what) {
            is String -> len(what)
            is NodePath -> len(what)
            is PackedByteArray -> len(what)
            is PackedInt32Array -> len(what)
            is PackedFloat64Array -> len(what)
            is PackedStringArray -> len(what)
            is PackedVector2Array -> len(what)
            is PackedVector3Array -> len(what)
            is PackedColorArray -> len(what)
            else -> throw IllegalArgumentException("This type doesn't have a length. It must be a compatible Variant, Collection or Map")
        }
    }

    /**
     * Loads a resource from the filesystem located at path.
     * The resource is loaded on the method call (unless it's referenced already elsewhere, e.g. in another script or in the scene), which might cause slight delay, especially when loading scenes.
     * Important: The path must be absolute, a local path will just return null.
     * */
    @JvmStatic
    @JvmOverloads
    fun <T : Resource> load(
        path: String,
        typeHint: String = "",
        cacheMode: ResourceLoader.CacheMode = ResourceLoader.CacheMode.REUSE
    ): T? {
        return ResourceLoader.loadAs(path, typeHint, cacheMode)
    }

    /**
     * The MemoryManager runs automatically at the end of each frame, but it can happen that the engine freeze for a long period of time (a loading screen).
     * You can use that method to manually trigger it if you want memory to be quickly freed.
     * */
    @JvmStatic
    fun syncMemory() {
        MemoryManager.querySync()
    }


    /**
     * If some cleanup operations are needed when the game closes, you can register callbacks for it.
     * Useful when you have to free third party resources or terminate non-daemon threads.
     * */
    @JvmStatic
    fun callWhenClosing(callback: () -> Unit) {
        MemoryManager.registerCallback(false, callback)
    }

    /** Returns a character as a String of the given Unicode code point (which is compatible with ASCII code). */
    @JvmStatic
    fun char(code: Int) = code.toChar().toString()

    /** Returns a color constructed from integer red, green, blue, and alpha channels.
     * Each channel should have 8 bits of information ranging from 0 to 255. */
    @JvmStatic
    fun Color8(r8: Int, g8: Int, b8: Int, a8: Int = 255) = Color(r8 / 256f, g8 / 256f, b8 / 256f, a8 / 256f)

    /** Returns a color according to the standardized name with alpha ranging from 0 to 1.*/
    @JvmStatic
    fun ColorN(name: String, alpha: Float = 1.0f): Color {
        return when (name) {
            "aliceblue" -> Color.aliceBlue
            "aqua" -> Color.aqua
            "aquamarine" -> Color.aquamarine
            "azure" -> Color.azure
            "beige" -> Color.beige
            "bisque" -> Color.bisque
            "black" -> Color.black
            "blanchedalmond" -> Color.blanchedAlmond
            "blue" -> Color.blue
            "blueviolet" -> Color.blueViolet
            "brown" -> Color.brown
            "burlywood" -> Color.burlywood
            "cadetblue" -> Color.cadetBlue
            "chartreuse" -> Color.chartreuse
            "chocolate" -> Color.chocolate
            "coral" -> Color.coral
            "cornflower" -> Color.cornflowerBlue
            "cornsilk" -> Color.cornsilk
            "crimson" -> Color.crimson
            "cyan" -> Color.cyan
            "darkblue" -> Color.darkBlue
            "darkcyan" -> Color.darkCyan
            "darkgoldenrod" -> Color.darkGoldenrod
            "darkgray" -> Color.darkGray
            "darkgreen" -> Color.darkGreen
            "darkkhaki" -> Color.darkKhaki
            "darkmagenta" -> Color.darkMagenta
            "darkolivegreen" -> Color.darkOliveGreen
            "darkorange" -> Color.darkorange
            "darkorchid" -> Color.darkOrchid
            "darkred" -> Color.darkRed
            "darksalmon" -> Color.darkSalmon
            "darkseagreen" -> Color.darkSeaGreen
            "darkslateblue" -> Color.darkSlateBlue
            "darkslategray" -> Color.darkSlateGray
            "darkturquoise" -> Color.darkTurquoise
            "darkviolet" -> Color.darkViolet
            "deeppink" -> Color.deepPink
            "deepskyblue" -> Color.deepSkyBlue
            "dimgray" -> Color.dimGray
            "dodgerblue" -> Color.dodgerBlue
            "firebrick" -> Color.firebrick
            "floralwhite" -> Color.floralWhite
            "forestgreen" -> Color.forestGreen
            "fuchsia" -> Color.fuchsia
            "gainsboro" -> Color.gainsboro
            "ghostwhite" -> Color.ghostWhite
            "gold" -> Color.gold
            "goldenrod" -> Color.goldenrod
            "gray" -> Color.gray
            "webgray" -> Color.webGray
            "green" -> Color.green
            "webgreen" -> Color.webGreen
            "greenyellow" -> Color.greenYellow
            "honeydew" -> Color.honeydew
            "hotpink" -> Color.hotPink
            "indianred" -> Color.indianRed
            "indigo" -> Color.indigo
            "ivory" -> Color.ivory
            "khaki" -> Color.khaki
            "lavender" -> Color.lavender
            "lavenderblush" -> Color.lavenderBlush
            "lawngreen" -> Color.lawnGreen
            "lemonchiffon" -> Color.lemonChiffon
            "lightblue" -> Color.lightBlue
            "lightcoral" -> Color.lightCoral
            "lightcyan" -> Color.lightCyan
            "lightgoldenrod" -> Color.lightGoldenrod
            "lightgray" -> Color.lightGray
            "lightgreen" -> Color.lightGreen
            "lightpink" -> Color.lightPink
            "lightsalmon" -> Color.lightSalmon
            "lightseagreen" -> Color.lightSeaGreen
            "lightskyblue" -> Color.lightSkyBlue
            "lightslategray" -> Color.lightSlateGray
            "lightsteelblue" -> Color.lightSteelBlue
            "lightyellow" -> Color.lightYellow
            "lime" -> Color.lime
            "limegreen" -> Color.limeGreen
            "linen" -> Color.linen
            "magenta" -> Color.magenta
            "maroon" -> Color.maroon
            "webmaroon" -> Color.webMaroon
            "mediumaquamarine" -> Color.mediumAquamarine
            "mediumblue" -> Color.mediumBlue
            "mediumorchid" -> Color.mediumOrchid
            "mediumpurple" -> Color.mediumPurple
            "mediumseagreen" -> Color.mediumSeaGreen
            "mediumslateblue" -> Color.mediumSlateBlue
            "mediumspringgreen" -> Color.mediumSpringGreen
            "mediumturquoise" -> Color.mediumTurquoise
            "mediumvioletred" -> Color.mediumVioletRed
            "midnightblue" -> Color.midnightBlue
            "mintcream" -> Color.mintCream
            "mistyrose" -> Color.mistyRose
            "moccasin" -> Color.moccasin
            "navajowhite" -> Color.navajoWhite
            "navyblue" -> Color.navyBlue
            "oldlace" -> Color.oldLace
            "olive" -> Color.olive
            "olivedrab" -> Color.oliveDrab
            "orange" -> Color.orange
            "orangered" -> Color.orangeRed
            "orchid" -> Color.orchid
            "palegoldenrod" -> Color.paleGoldenrod
            "palegreen" -> Color.paleGreen
            "paleturquoise" -> Color.paleTurquoise
            "palevioletred" -> Color.paleVioletRed
            "papayawhip" -> Color.papayaWhip
            "peachpuff" -> Color.peachPuff
            "peru" -> Color.peru
            "pink" -> Color.pink
            "plum" -> Color.plum
            "powderblue" -> Color.powderBlue
            "purple" -> Color.purple
            "webpurple" -> Color.webPurple
            "rebeccapurple" -> Color.rebeccaPurple
            "red" -> Color.red
            "rosybrown" -> Color.rosyBrown
            "royalblue" -> Color.royalBlue
            "saddlebrown" -> Color.saddleBrown
            "salmon" -> Color.salmon
            "sandybrown" -> Color.sandyBrown
            "seagreen" -> Color.seaGreen
            "seashell" -> Color.seashell
            "sienna" -> Color.sienna
            "silver" -> Color.silver
            "skyblue" -> Color.skyBlue
            "slateblue" -> Color.slateBlue
            "slategray" -> Color.slateGray
            "snow" -> Color.snow
            "springgreen" -> Color.springGreen
            "steelblue" -> Color.steelBlue
            "tan" -> Color.tan
            "teal" -> Color.teal
            "thistle" -> Color.thistle
            "tomato" -> Color.tomato
            "turquoise" -> Color.turquoise
            "transparent" -> Color.transparent
            "violet" -> Color.violet
            "wheat" -> Color.wheat
            "white" -> Color.white
            "whitesmoke" -> Color.whiteSmoke
            "yellow" -> Color.yellow
            "yellowgreen" -> Color.yellowGreen
            else -> throw NoSuchElementException("$name is not a valid color name.")
        }.also {
            it.a = alpha.toRealT()
        }
    }

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: String): Int = s.length

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: NodePath): Int = len(s.path)

    /** Returns length of Variant var */
    @JvmStatic
    fun <T> len(s: VariantArray<T>): Int = s.size

    /** Returns length of Variant var */
    @JvmStatic
    fun <K, V> len(s: Dictionary<K, V>): Int = s.size

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: PackedByteArray): Int = s.size

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: PackedColorArray): Int = s.size

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: PackedInt32Array): Int = s.size

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: PackedFloat64Array): Int = s.size

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: PackedStringArray): Int = s.size

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: PackedVector2Array): Int = s.size

    /** Returns length of Variant var */
    @JvmStatic
    fun len(s: PackedVector3Array): Int = s.size

    /** Returns an integer representing the Unicode code point of the given Unicode character char. */
    @JvmStatic
    fun ord(char: String): Int {
        return char[0].code
    }

    //endregion
    //region Math

    private const val MAX_N = 10
    private val sd = arrayOf(
        0.9999,
        0.09999,
        0.009999,
        0.0009999,
        0.00009999,
        0.000009999,
        0.0000009999,
        0.00000009999,
        0.000000009999,
        0.0000000009999
    )

    /** Returns the absolute value of parameter s (i.e. unsigned value, works for integer and float). */
    @JvmStatic
    fun abs(s: Int) = kotlin.math.abs(s)

    /** Returns the absolute value of parameter s (i.e. unsigned value, works for integer and float). */
    @JvmStatic
    fun abs(s: Long) = kotlin.math.abs(s)

    /** Returns the absolute value of parameter s (i.e. unsigned value, works for integer and float). */
    @JvmStatic
    fun abs(s: Float) = kotlin.math.abs(s)

    /** Returns the absolute value of parameter s (i.e. unsigned value, works for integer and float). */
    @JvmStatic
    fun abs(s: Double) = kotlin.math.abs(s)


    /** Returns the arc cosine of s in radians. Use to get the angle of cosine s. */
    @JvmStatic
    fun acos(s: Float) = kotlin.math.acos(s)

    /** Returns the arc cosine of s in radians. Use to get the angle of cosine s. */
    @JvmStatic
    fun acos(s: Double) = kotlin.math.acos(s)


    /** Returns the arc sine of s in radians. Use to get the angle of sine s. */
    @JvmStatic
    fun asin(s: Float) = kotlin.math.asin(s)

    /** Returns the arc sine of s in radians. Use to get the angle of sine s. */
    @JvmStatic
    fun asin(s: Double) = kotlin.math.asin(s)


    /** Returns the arc tangent of s in radians. Use it to get the angle from an angle's tangent in trigonometry: atan(tan(angle)) == angle.
     * The method cannot know in which quadrant the angle should fall. See atan2 if you always want an exact angle. */
    @JvmStatic
    fun atan(s: Float) = kotlin.math.atan(s)

    /** Returns the arc tangent of s in radians. Use it to get the angle from an angle's tangent in trigonometry: atan(tan(angle)) == angle.
     * The method cannot know in which quadrant the angle should fall. See atan2 if you always want an exact angle. */
    @JvmStatic
    fun atan(s: Double) = kotlin.math.atan(s)


    /** Returns the arc tangent of y/x in radians. Use to get the angle of tangent y/x. To compute the value, the method takes into account the sign of both arguments in order to determine the quadrant.
     * a = atan2(0 */
    @JvmStatic
    fun atan2(y: Float, x: Float) = kotlin.math.atan2(y, x)

    /** Returns the arc tangent of y/x in radians. Use to get the angle of tangent y/x. To compute the value, the method takes into account the sign of both arguments in order to determine the quadrant.
     * a = atan2(0 */
    @JvmStatic
    fun atan2(y: Double, x: Double) = kotlin.math.atan2(y, x)


    /** Returns the hyperbolic arc (also called inverse) sine of [x], returning a value in radians.
     * Use it to get the angle from an angle's sine in hyperbolic space. */
    @JvmStatic
    fun asinh(x: Float) = kotlin.math.asinh(x)

    /** Returns the hyperbolic arc (also called inverse) sine of [x], returning a value in radians.
     * Use it to get the angle from an angle's sine in hyperbolic space. */
    @JvmStatic
    fun asinh(x: Double) = kotlin.math.asinh(x)

    /** Returns the hyperbolic arc (also called inverse) cosine of [x], returning a value in radians.
     * For values lower than 1, returns 0 to prevent a NaN result. */
    @JvmStatic
    fun acosh(x: Float) = if (x < 1f) 0f else kotlin.math.acosh(x)

    /** Returns the hyperbolic arc (also called inverse) cosine of [x], returning a value in radians.
     * For values lower than 1, returns 0 to prevent a NaN result. */
    @JvmStatic
    fun acosh(x: Double) = if (x < 1.0) 0.0 else kotlin.math.acosh(x)

    /** Returns the hyperbolic arc (also called inverse) tangent of [x], returning a value in radians.
     * Values less than or equal to -1 return negative infinity; values greater than or equal to 1 return positive infinity. */
    @JvmStatic
    fun atanh(x: Float) = when {
        x <= -1f -> Float.NEGATIVE_INFINITY
        x >= 1f -> Float.POSITIVE_INFINITY
        else -> kotlin.math.atanh(x)
    }

    /** Returns the hyperbolic arc (also called inverse) tangent of [x], returning a value in radians.
     * Values less than or equal to -1 return negative infinity; values greater than or equal to 1 return positive infinity. */
    @JvmStatic
    fun atanh(x: Double) = when {
        x <= -1.0 -> Double.NEGATIVE_INFINITY
        x >= 1.0 -> Double.POSITIVE_INFINITY
        else -> kotlin.math.atanh(x)
    }


    /** Returns the derivative at [t] on a one-dimensional Bézier curve defined by [start], [control1], [control2], and [end]. */
    @JvmStatic
    fun bezierDerivative(start: Float, control1: Float, control2: Float, end: Float, t: Float) =
        bezierDerivative(start.toDouble(), control1.toDouble(), control2.toDouble(), end.toDouble(), t.toDouble()).toFloat()

    /** Returns the derivative at [t] on a one-dimensional Bézier curve defined by [start], [control1], [control2], and [end]. */
    @JvmStatic
    fun bezierDerivative(start: Double, control1: Double, control2: Double, end: Double, t: Double) =
        bezierDerivativeImpl(start, control1, control2, end, t)


    /** Converts a 2D point expressed in the cartesian coordinate system (X and Y axis) to the polar coordinate system (a distance from the origin and an angle). */
    @JvmStatic
    fun cartesian2polar(x: Float, y: Float) = Vector2(sqrt(x * x + y * y), kotlin.math.atan2(y, x))

    /** Converts a 2D point expressed in the cartesian coordinate system (X and Y axis) to the polar coordinate system (a distance from the origin and an angle). */
    @JvmStatic
    fun cartesian2polar(x: Double, y: Double) = Vector2(sqrt(x * x + y * y), kotlin.math.atan2(y, x))


    /** Rounds s upward, returning the smallest integral value that is not less than s. */
    @JvmStatic
    fun ceil(s: Float) = kotlin.math.ceil(s)

    /** Rounds s upward, returning the smallest integral value that is not less than s. */
    @JvmStatic
    fun ceil(s: Double) = kotlin.math.ceil(s)


    /** Clamps value and returns a value not less than min and not more than max. */
    @JvmStatic
    fun clamp(value: Float, min: Float, max: Float) = kotlin.math.min(kotlin.math.max(value, min), max)

    /** Clamps value and returns a value not less than min and not more than max. */
    @JvmStatic
    fun clamp(value: Double, min: Double, max: Double) = kotlin.math.min(kotlin.math.max(value, min), max)

    /** Clamps value and returns a value not less than min and not more than max. */
    @JvmStatic
    fun clamp(value: Float, min: Int, max: Int) = kotlin.math.min(kotlin.math.max(value, min.toFloat()), max.toFloat())

    /** Clamps value and returns a value not less than min and not more than max. */
    @JvmStatic
    fun clamp(value: Double, min: Long, max: Long) =
        kotlin.math.min(kotlin.math.max(value, min.toDouble()), max.toDouble())


    /** Returns the cosine of angle s in radians. */
    @JvmStatic
    fun cos(s: Float) = kotlin.math.cos(s)

    /** Returns the cosine of angle s in radians. */
    @JvmStatic
    fun cos(s: Double) = kotlin.math.cos(s)


    /** Returns the hyperbolic cosine of s in radians. */
    @JvmStatic
    fun cosh(s: Float) = kotlin.math.cosh(s)

    /** Returns the hyperbolic cosine of s in radians. */
    @JvmStatic
    fun cosh(s: Double) = kotlin.math.cosh(s)


    /** Converts from decibels to linear energy (audio). */
    @JvmStatic
    fun dbToLinear(db: Float) = kotlin.math.exp(db * DB2NEPER)

    /** Converts from decibels to linear energy (audio). */
    @JvmStatic
    fun dbToLinear(db: Double) = kotlin.math.exp(db * DB2NEPER)


    /** Returns degrees converted to radians. */
    @JvmStatic
    fun degToRad(s: Float) = s * TAU / 360

    /** Returns degrees converted to radians. */
    @JvmStatic
    fun degToRad(s: Double) = s * TAU / 360

    /** Easing function, based on exponent. 0 is constant, 1 is linear, 0 to 1 is ease-in, 1+ is ease out.
     * Negative values are in-out/out in.
     * Value must be between 0 and 1.
     */
    @JvmStatic
    fun ease(value: Float, curve: Float): Float = ease(value.toDouble(), curve.toDouble()).toFloat()

    /** Easing function, based on exponent. 0 is constant, 1 is linear, 0 to 1 is ease-in, 1+ is ease out.
     * Negative values are in-out/out in.
     * Value must be between 0 and 1.
     */
    @JvmStatic
    fun ease(value: Double, curve: Double): Double {
        val s = when {
            value < 0 -> 0.0
            value > 1.0 -> 1.0
            else -> value
        }

        return when {
            curve > 0.0 -> {
                if (curve < 1.0) {
                    val a = 1.0 - s
                    1.0 - a.pow(1.0 / curve)
                } else {
                    s.pow(curve)
                }
            }

            curve < 0.0 -> {
                if (value < 0.5) {
                    val a = s * 2.0
                    a.pow(-curve) * 0.5
                } else {
                    val a = 1.0 - (s - 0.5) * 2.0
                    (1.0 - a.pow(-curve)) * 0.5 + 0.5
                }
            }

            else -> 0.0
        }
    }


    /** The natural exponential function. It raises the mathematical constant e to the power of s and returns it. */
    @JvmStatic
    fun exp(s: Float) = kotlin.math.exp(s)

    /** The natural exponential function. It raises the mathematical constant e to the power of s and returns it. */
    @JvmStatic
    fun exp(s: Double) = kotlin.math.exp(s)


    /** Rounds s to the closest smaller integer and returns it. */
    @JvmStatic
    fun floor(s: Float) = kotlin.math.floor(s)

    /** Rounds s to the closest smaller integer and returns it. */
    @JvmStatic
    fun floor(s: Double) = kotlin.math.floor(s)

    /** Rounds s to the closest smaller integer and returns it. */
    @JvmStatic
    fun floori(s: Float) = kotlin.math.floor(s).toInt()

    /** Rounds s to the closest smaller integer and returns it. */
    @JvmStatic
    fun floori(s: Double) = kotlin.math.floor(s).toInt()


    /** Returns the floating-point remainder of a/b, keeping the sign of a. */
    @JvmStatic
    fun fmod(a: Float, b: Float) = a.rem(b)

    /** Returns the floating-point remainder of a/b, keeping the sign of a. */
    @JvmStatic
    fun fmod(a: Double, b: Double) = a.rem(b)


    /** Returns the floating-point modulus of a/b that wraps equally in positive and negative. */
    @JvmStatic
    fun fposmod(a: Float, b: Float): Float {
        return a.toRealT().fposmod(b.toRealT()).toFloat()
    }

    /** Returns the floating-point modulus of a/b that wraps equally in positive and negative. */
    @JvmStatic
    fun fposmod(a: Double, b: Double): Double {
        return a.toRealT().fposmod(b.toRealT())
    }

    /** Returns a normalized value considering the given range. This is the opposite of lerp. */
    @JvmStatic
    fun inverseLerp(from: Float, to: Float, weight: Float) = (weight - from) / (to - from)

    /** Returns a normalized value considering the given range. This is the opposite of lerp. */
    @JvmStatic
    fun inverseLerp(from: Double, to: Double, weight: Double) = (weight - from) / (to - from)


    /** Returns true if a and b are approximately equal to each other. */
    @JvmStatic
    fun isEqualApprox(a: Float, b: Float) = a.toRealT().isEqualApprox(b.toRealT())

    /** Returns true if a and b are approximately equal to each other. */
    @JvmStatic
    fun isEqualApprox(a: Double, b: Double) = a.toRealT().isEqualApprox(b.toRealT())


    /** Returns whether x is a finite value, i.e. it is not NAN, positive infinity, or negative infinity. */
    @JvmStatic
    fun isFinite(s: Float) = s.isFinite()

    /** Returns whether s is an infinity value (either positive infinity or negative infinity). */
    @JvmStatic
    fun isFinite(s: Double) = s.isFinite()

    /** Returns whether s is an infinity value (either positive infinity or negative infinity). */
    @JvmStatic
    fun isInf(s: Float) = s.isInfinite()

    /** Returns whether s is an infinity value (either positive infinity or negative infinity). */
    @JvmStatic
    fun isInf(s: Double) = s.isInfinite()

    /** Returns whether s is an infinity value (either positive infinity or negative infinity). */
    @JvmStatic
    fun isNan(s: Float) = s.isNaN()

    /** Returns whether s is an infinity value (either positive infinity or negative infinity). */
    @JvmStatic
    fun isNan(s: Double) = s.isNaN()


    /** Returns true, for value types, if a and b share the same value. Returns true, for reference types, if the references of a and b are the same. */
    @JvmStatic
    fun isSame(a: Any, b: Any) = a == b


    /** Returns true if s is zero or almost zero. */
    @JvmStatic
    fun isZeroApprox(s: Float) = s.toRealT().isZeroApprox()

    /** Returns true if s is zero or almost zero. */
    @JvmStatic
    fun isZeroApprox(s: Double) = s.toRealT().isZeroApprox()

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Int, to: Int, weight: Float) = from + weight * (to - from)

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Long, to: Long, weight: Double) = from + weight * (to - from)

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Float, to: Float, weight: Float) = from + weight * (to - from)

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Double, to: Double, weight: Double) = from + weight * (to - from)

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Color, to: Color, weight: Float) = from + (to - from) * weight.toRealT()

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Color, to: Color, weight: Double) = from + (to - from) * weight

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Vector2, to: Vector2, weight: Float) = from + (to - from) * weight.toRealT()

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Vector2, to: Vector2, weight: Double) = from + (to - from) * weight

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Vector3, to: Vector3, weight: Float) = from + (to - from) * weight.toRealT()

    /** Linearly interpolates between two values by a normalized value. This is the opposite of inverse_lerp. */
    @JvmStatic
    fun lerp(from: Vector3, to: Vector3, weight: Double) = from + (to - from) * weight


    /** Returns the difference between the two angles (in radians), in the range of `[-PI, +PI]`.
     * When [from] and [to] are opposite, returns `-PI` if [from] is smaller than [to], or `PI` otherwise. */
    @JvmStatic
    fun angleDifference(from: Float, to: Float) = angleDifference(from.toDouble(), to.toDouble()).toFloat()

    /** Returns the difference between the two angles (in radians), in the range of `[-PI, +PI]`.
     * When [from] and [to] are opposite, returns `-PI` if [from] is smaller than [to], or `PI` otherwise. */
    @JvmStatic
    fun angleDifference(from: Double, to: Double): Double {
        val difference = fmod(to - from, TAU)
        return fmod(2.0 * difference, TAU) - difference
    }


    /** Linearly interpolates between two angles (in radians) by a normalized value.
     * Similar to lerp, but interpolates correctly when the angles wrap around TAU. */
    @JvmStatic
    fun lerpAngle(from: Float, to: Float, weight: Float) =
        lerpAngle(from.toDouble(), to.toDouble(), weight.toDouble()).toFloat()

    /** Linearly interpolates between two angles (in radians) by a normalized value.
     * Similar to lerp, but interpolates correctly when the angles wrap around TAU. */
    @JvmStatic
    fun lerpAngle(from: Double, to: Double, weight: Double): Double {
        val difference = fmod(to - from, TAU)
        val distance = fmod(2.0f * difference, TAU) - difference
        return from + distance * weight
    }


    /** Converts from linear energy to decibels (audio).
     * This can be used to implement volume sliders that behave as expected (since volume isn't linear) */
    @JvmStatic
    fun linearToDb(nrg: Float) = kotlin.math.ln(nrg) * NEPER2DB

    /** Converts from linear energy to decibels (audio).
     * This can be used to implement volume sliders that behave as expected (since volume isn't linear) */
    @JvmStatic
    fun linearToDb(nrg: Double) = kotlin.math.ln(nrg) * NEPER2DB


    /** Natural logarithm. The amount of time needed to reach a certain level of continuous growth.
     *  Note: This is not the same as the "log" function on most calculators, which uses a base 10 logarithm. */
    @JvmStatic
    fun log(s: Float) = kotlin.math.ln(s)

    /** Natural logarithm. The amount of time needed to reach a certain level of continuous growth.
     *  Note: This is not the same as the "log" function on most calculators, which uses a base 10 logarithm. */
    @JvmStatic
    fun log(s: Double) = kotlin.math.ln(s)

    /** Returns the minimum of two values. */
    @JvmStatic
    fun min(a: Int, b: Int) = kotlin.math.min(a, b)

    /** Returns the minimum of two values. */
    @JvmStatic
    fun min(a: Long, b: Long) = kotlin.math.min(a, b)

    /** Returns the minimum of two values. */
    @JvmStatic
    fun min(a: Float, b: Float) = kotlin.math.min(a, b)

    /** Returns the minimum of two values. */
    @JvmStatic
    fun min(a: Double, b: Double) = kotlin.math.min(a, b)

    /** Returns the maximum of two values. */
    @JvmStatic
    fun max(a: Int, b: Int) = kotlin.math.max(a, b)

    /** Returns the maximum of two values. */
    @JvmStatic
    fun max(a: Long, b: Long) = kotlin.math.max(a, b)

    /** Returns the maximum of two values. */
    @JvmStatic
    fun max(a: Float, b: Float) = kotlin.math.max(a, b)

    /** Returns the maximum of two values. */
    @JvmStatic
    fun max(a: Double, b: Double) = kotlin.math.max(a, b)


    /** Returns the floating-point remainder of a/b, keeping the sign of a. */
    @JvmStatic
    fun mod(a: Int, b: Int) = a.rem(b)

    /** Returns the floating-point remainder of a/b, keeping the sign of a. */
    @JvmStatic
    fun mod(a: Long, b: Long) = a.rem(b)

    /** Moves from toward to by the delta value.
     *  Use a negative delta value to move away. */
    @JvmStatic
    fun moveToward(from: Int, to: Int, delta: Int) = if (abs(to - from) <= delta) to else from + (to - from).sign * delta

    /** Moves from toward to by the delta value.
     *  Use a negative delta value to move away. */
    @JvmStatic
    fun moveToward(from: Long, to: Long, delta: Long) = if (abs(to - from) <= delta) to else from + (to - from).sign * delta

    /** Moves from toward to by the delta value.
     *  Use a negative delta value to move away. */
    @JvmStatic
    fun moveToward(from: Float, to: Float, delta: Float) = if (abs(to - from) <= delta) to else from + (to - from).sign * delta

    /** Moves from toward to by the delta value.
     *  Use a negative delta value to move away. */
    @JvmStatic
    fun moveToward(from: Double, to: Double, delta: Double) = if (abs(to - from) <= delta) to else from + (to - from).sign * delta


    /** Rotates [from] toward [to] by the [delta] amount. Will not go past [to].
     * Similar to [moveToward], but interpolates correctly when the angles wrap around TAU.
     * If [delta] is negative, this function will rotate away from [to], toward the opposite angle, and will not go past the opposite angle. */
    @JvmStatic
    fun rotateToward(from: Float, to: Float, delta: Float) =
        rotateToward(from.toDouble(), to.toDouble(), delta.toDouble()).toFloat()

    /** Rotates [from] toward [to] by the [delta] amount. Will not go past [to].
     * Similar to [moveToward], but interpolates correctly when the angles wrap around TAU.
     * If [delta] is negative, this function will rotate away from [to], toward the opposite angle, and will not go past the opposite angle. */
    @JvmStatic
    fun rotateToward(from: Double, to: Double, delta: Double): Double {
        val difference = angleDifference(from, to)
        val absDifference = abs(difference)
        return from + delta.coerceIn(absDifference - kotlin.math.PI, absDifference) * if (difference >= 0.0) 1.0 else -1.0
    }


    /** Returns the nearest larger power of 2 for integer value. */
    @JvmStatic
    fun nearestPo2(value: Int) = nearestPo2(value.toLong()).toInt()

    /** Returns the nearest larger power of 2 for long value. */
    @JvmStatic
    fun nearestPo2(value: Long): Long {
        val powerOf = kotlin.math.ceil(kotlin.math.ln(value.toDouble()) / kotlin.math.ln(2.0))
        return 2.0.pow(powerOf).toLong()
    }

    /** Returns the nearest larger power of 2 for float value. */
    @JvmStatic
    fun nearestPo2(value: Float) = nearestPo2(value.toDouble()).toFloat()

    /** Returns the nearest larger power of 2 for double value. */
    @JvmStatic
    fun nearestPo2(value: Double): Double {
        val powerOf = kotlin.math.ceil(kotlin.math.ln(value) / kotlin.math.ln(2.0))
        return 2.0.pow(powerOf)
    }

    /** Converts a 2D point expressed in the polar coordinate system (a distance from the origin r and an angle th) to the cartesian coordinate system (X and Y axis). */
    @JvmStatic
    fun polarToCartesian(r: Float, th: Float) = polarToCartesian(r.toDouble(), th.toDouble())

    /** Converts a 2D point expressed in the polar coordinate system (a distance from the origin r and an angle th) to the cartesian coordinate system (X and Y axis). */
    @JvmStatic
    fun polarToCartesian(r: Double, th: Double) = Vector2(r * kotlin.math.sin(th), r * kotlin.math.cos(th))


    /** Returns the floating-point modulus of a/b that wraps equally in positive and negative. */
    @JvmStatic
    fun posmod(a: Int, b: Int): Int {
        val value = a.rem(b)
        if ((value < 0 && b > 0) || (value > 0 && b < 0)) {
            return value + b;
        }
        return value
    }

    /** Returns the floating-point modulus of a/b that wraps equally in positive and negative. */
    @JvmStatic
    fun posmod(a: Long, b: Long): Long {
        val value = a.rem(b)
        if ((value < 0 && b > 0) || (value > 0 && b < 0)) {
            return value + b;
        }
        return value
    }


    /** Returns the result of x raised to the power of y. */
    @JvmStatic
    fun pow(base: Float, exp: Float) = base.pow(exp)

    /** Returns the result of x raised to the power of y. */
    @JvmStatic
    fun pow(base: Double, exp: Double) = base.pow(exp)


    /** Converts from radians to degrees. */
    @JvmStatic
    fun radToDeg(rad: Float) = radToDeg(rad.toDouble()).toFloat()

    /** Converts from radians to degrees. */
    @JvmStatic
    fun radToDeg(rad: Double) = rad * 360 / TAU


    /** Maps a value from range [istart, istop] to [ostart, ostop]. See also lerp and inverse_lerp.
     * If value is outside [istart, istop], then the resulting value will also be outside [ostart, ostop].
     * If this is not desired, use clamp on the result of this function.
     * For complex use cases where multiple ranges are needed, consider using Curve or Gradient instead.
     * Note: If istart == istop, the return value is undefined (most likely NaN, INF, or -INF).*/
    @JvmStatic
    fun remap(value: Float, istart: Float, istop: Float, ostart: Float, ostop: Float) =
        lerp(ostart, ostop, inverseLerp(istart, istop, value))

    /** Maps a value from range [istart, istop] to [ostart, ostop]. See also lerp and inverse_lerp.
     * If value is outside [istart, istop], then the resulting value will also be outside [ostart, ostop].
     * If this is not desired, use clamp on the result of this function.
     * For complex use cases where multiple ranges are needed, consider using Curve or Gradient instead.
     * Note: If istart == istop, the return value is undefined (most likely NaN, INF, or -INF).*/
    @JvmStatic
    fun remap(value: Double, istart: Double, istop: Double, ostart: Double, ostop: Double) =
        lerp(ostart, ostop, inverseLerp(istart, istop, value))

    /** Returns the integral value that is nearest to s, with halfway cases rounded away from zero. */
    @JvmStatic
    fun round(s: Float) = kotlin.math.round(s)

    /** Returns the integral value that is nearest to s, with halfway cases rounded away from zero. */
    @JvmStatic
    fun round(s: Double) = kotlin.math.round(s)


    /** Returns the sign of s: -1 or 1. Returns 0 if s is 0. */
    @JvmStatic
    fun sign(s: Float) = kotlin.math.sign(s)

    /** Returns the sign of s: -1 or 1. Returns 0 if s is 0. */
    @JvmStatic
    fun sign(s: Double) = kotlin.math.sign(s)


    /** Returns the sine of angle s in radians. */
    @JvmStatic
    fun sin(s: Float) = kotlin.math.sin(s)

    /** Returns the sine of angle s in radians. */
    @JvmStatic
    fun sin(s: Double) = kotlin.math.sin(s)


    /** Returns the hyperbolic sine of s in radians. */
    @JvmStatic
    fun sinh(s: Float) = kotlin.math.sinh(s)

    /** Returns the hyperbolic sine of s in radians. */
    @JvmStatic
    fun sinh(s: Double) = kotlin.math.sinh(s)


    /** Returns the multiple of [step] that is closest to [x]. */
    @JvmStatic
    fun snapped(x: Int, step: Int) = snap(x, step)

    /** Returns the multiple of [step] that is closest to [x]. */
    @JvmStatic
    fun snapped(x: Long, step: Long) = if (step != 0L) {
        (kotlin.math.floor(x.toDouble() / step.toDouble() + 0.5) * step).toLong()
    } else {
        x
    }

    /** Returns the multiple of [step] that is closest to [x]. */
    @JvmStatic
    fun snapped(x: Float, step: Float) = snap(x.toDouble(), step.toDouble()).toFloat()

    /** Returns the multiple of [step] that is closest to [x]. */
    @JvmStatic
    fun snapped(x: Double, step: Double) = snap(x, step)

    /** Returns the multiple of [step] that is closest to [x]. */
    @JvmStatic
    fun snappedf(x: Float, step: Float) = snapped(x, step)

    /** Returns the multiple of [step] that is closest to [x]. */
    @JvmStatic
    fun snappedf(x: Double, step: Double) = snapped(x, step)

    /** Returns the multiple of [step] that is closest to [x]. */
    @JvmStatic
    fun snappedi(x: Float, step: Int) = snap(x.toDouble(), step.toDouble()).toInt()

    /** Returns the multiple of [step] that is closest to [x]. */
    @JvmStatic
    fun snappedi(x: Double, step: Long) = if (step != 0L) {
        (kotlin.math.floor(x / step.toDouble() + 0.5) * step).toLong()
    } else {
        x.toLong()
    }


    /** Returns a number smoothly interpolated between the from and to, based on the weight.
     * Similar to lerp, but interpolates faster at the beginning and slower at the end.
     */
    @JvmStatic
    fun smoothstep(from: Float, to: Float, weight: Float) =
        smoothstep(from.toDouble(), to.toDouble(), weight.toDouble()).toFloat()

    /** Returns a number smoothly interpolated between the from and to, based on the weight.
     * Similar to lerp, but interpolates faster at the beginning and slower at the end.
     */
    @JvmStatic
    fun smoothstep(from: Double, to: Double, weight: Double): Double {
        if (from.isEqualApprox(to)) {
            return from
        }
        val x: Double = clamp((weight - from) / (to - from), 0.0, 1.0)
        return x * x * (3.0 - 2.0 * x)
    }


    /** Returns the square root of s. */
    @JvmStatic
    fun sqrt(s: Float) = kotlin.math.sqrt(s)

    /** Returns the square root of s. */
    @JvmStatic
    fun sqrt(s: Double) = kotlin.math.sqrt(s)


    /** Returns the position of the first non-zero digit, after the decimal point.
     * Note that the maximum return value is 10, which is a design decision in the implementation. */
    @JvmStatic
    fun stepDecimals(step: Float) = stepDecimals(step.toDouble())

    /** Returns the position of the first non-zero digit, after the decimal point.
     * Note that the maximum return value is 10, which is a design decision in the implementation. */
    @JvmStatic
    fun stepDecimals(step: Double): Int {
        val abs = kotlin.math.abs(step)
        val decs = abs - kotlin.math.floor(abs)
        for (i in 0 until MAX_N) {
            if (decs >= sd[i]) {
                return i
            }
        }
        return 0
    }


    /** Snaps float value s to a given step.
     * This can also be used to round a floating point number to an arbitrary number of decimals. */
    @JvmStatic
    fun stepify(s: Int, step: Int) = (s / step) * step

    /** Snaps float value s to a given step.
     * This can also be used to round a floating point number to an arbitrary number of decimals. */
    @JvmStatic
    fun stepify(s: Long, step: Long) = (s / step) * step

    /** Snaps float value s to a given step.
     * This can also be used to round a floating point number to an arbitrary number of decimals. */
    @JvmStatic
    fun stepify(s: Float, step: Float) = kotlin.math.floor(s / step) * step

    /** Snaps float value s to a given step.
     * This can also be used to round a floating point number to an arbitrary number of decimals. */
    @JvmStatic
    fun stepify(s: Double, step: Double) = kotlin.math.floor(s / step) * step


    /** Returns the tangent of angle s in radians. */
    @JvmStatic
    fun tan(s: Float) = kotlin.math.tan(s)

    /** Returns the tangent of angle s in radians. */
    @JvmStatic
    fun tan(s: Double) = kotlin.math.tan(s)

    /** Returns the tangent of angle s in radians. */
    @JvmStatic
    fun tanh(s: Float) = kotlin.math.tanh(s)

    /** Returns the tangent of angle s in radians. */
    @JvmStatic
    fun tanh(s: Double) = kotlin.math.tanh(s)


    /** Wraps float value between min and max.
     *  Usable for creating loop-alike behavior or infinite surfaces.*/
    @JvmStatic
    fun wrapf(value: Float, min: Float, max: Float) = min + fposmod(value + min, max - min)

    /** Wraps double value between min and max.
     *  Usable for creating loop-alike behavior or infinite surfaces.*/
    @JvmStatic
    fun wrapf(value: Double, min: Double, max: Double) = min + fposmod(value + min, max - min)


    /** Wraps int value between min and max.
     *  Usable for creating loop-alike behavior or infinite surfaces.*/
    @JvmStatic
    fun wrapi(value: Int, min: Int, max: Int) = min + posmod(value + min, max - min)

    /** Wraps long value between min and max.
     *  Usable for creating loop-alike behavior or infinite surfaces.*/
    @JvmStatic
    fun wrapi(value: Long, min: Long, max: Long) = min + posmod(value + min, max - min)

    //endregion
    //region Print
    private val rng = RandomNumberGenerator().asStatic()

    /** Converts one or more arguments to strings in the best way possible and prints them to the console.**/
    @JvmStatic
    fun print(vararg args: Any?) {
        GodotPrint.print(args.joinToString(""))
    }

    /**
     * Converts one or more arguments of any type to string in the best way possible and prints them to the console.
     *
     * The following BBCode tags are supported: b, i, u, s, indent, code, url, center, right, color, bgcolor, fgcolor.
     *
     * Color tags only support the following named colors: black, red, green, yellow, blue, magenta, pink, purple, cyan, white, orange, gray. Hexadecimal color codes are not supported.
     *
     * URL tags only support URLs wrapped by a URL tag, not URLs with a different title.
     *
     * When printing to standard output, the supported subset of BBCode is converted to ANSI escape codes for the terminal emulator to display. Support for ANSI escape codes varies across terminal emulators, especially for italic and strikethrough. In standard output, code is represented with faint text but without any font change. Unsupported tags are left as-is in standard output.
     *
     * ```printRich("[color=green][b]Hello world![/b][/color]")```
     *
     * Note: Consider using [pushError] and [pushWarning] to print error and warning messages instead of print or print_rich. This distinguishes them from print messages used for debugging purposes, while also displaying a stack trace when an error or warning is printed.
     *
     * Note: On Windows, only Windows 10 and later correctly displays ANSI escape codes in standard output.
     *
     * Note: Output displayed in the editor supports clickable [url=address]text[/url] tags. The [url] tag's address value is handled by OS.shell_open when clicked.
     * **/
    @JvmStatic
    fun printRich(vararg args: Any?) {
        GodotPrint.printRich(args.joinToString(""))
    }

    /** If verbose mode is enabled (OS.is_stdout_verbose returning true), converts one or more arguments of any type to string in the best way possible and prints them to the console.**/
    @JvmStatic
    fun printVerbose(vararg args: Any?) {
        GodotPrint.printVerbose(args.joinToString(""))
    }

    /** Converts one or more arguments to strings in the best way possible and prints them as error to the console.**/
    @JvmStatic
    fun printErr(vararg args: Any?) {
        GodotPrint.printErr(args.joinToString(""))
    }

    /** Prints the args without any modifications to the console.**/
    @JvmStatic
    fun printRaw(vararg args: Any?) {
        GodotPrint.printRaw(args.joinToString(""))
    }

    /** Prints one or more arguments to the console with a space between each argument.**/
    @JvmStatic
    fun prints(vararg args: Any?) = print(args.joinToString(" "))

    /** Converts one or more arguments to strings in the best way possible and prints them to the console.**/
    @JvmStatic
    fun printt(vararg args: Any?) = print(args.joinToString("\t"))

    /** Pushes an error message to Godot's built-in debugger and to the OS terminal.**/
    @JvmStatic
    fun pushError(vararg args: Any?) {
        GodotPrint.pushError(args.joinToString(""))
    }

    /** Pushes a warning message to Godot's built-in debugger and to the OS terminal.**/
    @JvmStatic
    fun pushWarning(vararg args: Any?) {
        GodotPrint.pushWarning(args.joinToString(""))
    }

    @JvmStatic
    fun printStack() = print(Thread.currentThread().stackTrace.joinToString("\n"))

    //endregion
    //region Random

    /** Returns a random floating-point value between 0.0 and 1.0 (inclusive). */
    @JvmStatic
    fun randf() = rng.randf()

    /**
     * Returns a [normally-distributed](https://en.wikipedia.org/wiki/Normal_distribution) pseudo-random number, using Box-Muller transform with the specified [mean] and a standard [deviation]. This is also called Gaussian distribution.
     */
    @JvmStatic
    fun randfn(mean: Float = 0.0f, deviation: Float = 1.0f) = rng.randfn(mean, deviation)

    /** Random range, any floating point value between from and to. */
    @JvmStatic
    fun randfRange(from: Float, to: Float) = rng.randfRange(from, to)

    /** Returns a random unsigned 32-bit integer. Use remainder to obtain a random value in the interval [0, N - 1] (where N is smaller than 2^32). */
    @JvmStatic
    fun randi() = rng.randi()

    /** Random range, any integer value between from and to. */
    @JvmStatic
    fun randiRange(from: Int, to: Int) = rng.randiRange(from, to)

    /**
     * Given a seed, returns a PackedInt64Array of size 2, where its first element is the randomized int value, and the second element is the same as seed. Passing the same seed consistently returns the same array.
     * Note: "Seed" here refers to the internal state of the pseudo random number generator, currently implemented as a 64 bit integer.
     */
    @JvmStatic
    fun randFromSeed(seed: Long): Pair<Long, Long> {
        rng.seed = seed
        //Call to randi() should change the value of the seed, that's why we retrieve it again in the return statement
        val randomValue = rng.randi()
        return Pair(randomValue, rng.seed)
    }

    /** Randomizes the seed (or the internal state) of the random number generator. Current implementation reseeds using a number based on time. */
    @JvmStatic
    fun randomize() = rng.randomize()

    /** Set the value of the seed **/
    @JvmStatic
    fun seed(seed: Long) {
        rng.seed = seed
    }

    //endregion
}
