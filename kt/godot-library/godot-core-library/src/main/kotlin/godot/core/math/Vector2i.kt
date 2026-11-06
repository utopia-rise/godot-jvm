@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.common.util.RealT
import godot.common.util.snapped
import godot.common.util.toRealT
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

@Suppress("MemberVisibilityCanBePrivate")
class Vector2i(
    var x: Int,
    var y: Int
) : Comparable<Vector2i>, CoreType {
    var width: Int
        get() = x
        set(value) {
            x = value
        }

    var height: Int
        get() = y
        set(value) {
            y = value
        }

    //CONSTANTS
    enum class Axis(override val value: Long): GodotEnum {
        X(0L),
        Y(1L);

        companion object {
            fun from(value: Long) = when (value) {
                0L -> X
                1L -> Y
                else -> throw AssertionError("Unknown axis for Vector2i: $value")
            }
        }
    }

    companion object {
        val ZERO: Vector2i
            get() = Vector2i(0, 0)
        val ONE: Vector2i
            get() = Vector2i(1, 1)
        val LEFT: Vector2i
            get() = Vector2i(-1, 0)
        val RIGHT: Vector2i
            get() = Vector2i(1, 0)
        val UP: Vector2i
            get() = Vector2i(0, -1)
        val DOWN: Vector2i
            get() = Vector2i(0, 1)
        val MIN: Vector2i
            get() = Vector2i(Int.MIN_VALUE, Int.MIN_VALUE)
        val MAX: Vector2i
            get() = Vector2i(Int.MAX_VALUE, Int.MAX_VALUE)
    }

    //CONSTRUCTOR
    constructor() : this(0.0, 0.0)

    constructor(vec: Vector2i) : this(vec.x, vec.y)

    constructor(vec: Vector2) : this(vec.x, vec.y)

    constructor(x: Number, y: Number) : this(x.toInt(), y.toInt())

    //API

    /**
     * Returns a new vector with all components in absolute values (i.e. positive).
     */
    fun abs() = Vector2i(kotlin.math.abs(x), kotlin.math.abs(y))

    /**
     * Returns the ratio of x to y.
     */
    fun aspect(): RealT = this.x.toRealT() / this.y

    /**
     * Returns a new vector with all components clamped between the components of min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clamp(min: Vector2i, max: Vector2i) = Vector2i(
        if (x < min.x) min.x else if (x > max.x) max.x else x,
        if (y < min.y) min.y else if (y > max.y) max.y else y,
    )

    /**
     * Returns a new vector with all components clamped between the min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clampi(min: Int, max: Int) = Vector2i(
        if (x < min) min else if (x > max) max else x,
        if (y < min) min else if (y > max) max else y,
    )

    fun distanceTo(to: Vector2i) = (to - this).length()

    fun distanceSquaredTo(to: Vector2i) = (to - this).lengthSquared()


    /**
     * Returns the vector’s length.
     */
    fun length() = sqrt(lengthSquared().toDouble())

    /**
     * Returns the vector’s length squared.
     * Prefer this method over length if you need to sort vectors or need the squared length for some formula.
     */
    fun lengthSquared(): Long = x.toLong() * x + y.toLong() * y


    /**
     * Returns the component-wise maximum of this and with, equivalent to `Vector2i(maxi(x, with.x), maxi(y, with.y))`.
     */
    fun max(with: Vector2i) = Vector2i(max(x, with.x), max(y, with.y))

    /**
     * Returns the axis of the vector's highest value. See AXIS_* constants. If all components are equal,
     * this method returns AXIS_X.
     */
    fun maxAxis() = if (x < y) Axis.Y else Axis.X

    /**
     * Returns the component-wise maximum of this and with, equivalent to ``Vector2(maxi(x, with), maxi(y, with))``.
     */
    fun maxi(with: Int) = Vector2i(max(x, with), max(y, with))

    /**
     * Returns the component-wise minimum of this and with, equivalent to ``Vector2i(mini(x, with.x), mini(y, with.y)).``
     */
    fun min(with: Vector2i) = Vector2i(min(x, with.x), min(y, with.y))

    /**
     * Returns the axis of the vector's lowest value. See AXIS_* constants. If all components are equal,
     * this method returns AXIS_Y.
     */
    fun minAxis() = if (x < y) Axis.X else Axis.Y

    /**
     * Returns the component-wise minimum of this and with, equivalent to ``Vector2i(mini(x, with), mini(y, with)).``
     */
    fun mini(with: Int) = Vector2i(min(x, with), min(y, with))

    /**
     * Returns the vector with each component set to one or negative one, depending on the signs of the components.
     */
    fun sign() = Vector2i(kotlin.math.sign(x.toFloat()), kotlin.math.sign(y.toFloat()))

    /**
     * Returns a new vector with each component snapped to the closest multiple of the corresponding component in [step].
     */
    fun snapped(by: Vector2i): Vector2i {
        val v = Vector2i(this)
        v.snap(by)
        return v
    }

    internal fun snap(by: Vector2i) {
        x = snapped(x, by.x)
        y = snapped(y, by.y)
    }

    /**
     * Returns a new vector with each component snapped to the closest multiple of step.
     */
    fun snappedi(step: Int) = Vector2i(snapped(x, step), snapped(y, step))

    /**
     * Gets the remainder of each component of the [Vector2i] with the components of the given [Vector2i].
     * This operation uses truncated division, which is often not desired as it does not work well with negative numbers.
     * Consider using @GlobalScope.posmod instead if you want to handle negative numbers.
     */
    operator fun rem(other: Vector2i) = Vector2i(
        x % other.x,
        y % other.y,
    )

    /**
     * Gets the remainder of each component of the [Vector2i] with the given int.
     * This operation uses truncated division, which is often not desired as it does not work well with negative numbers.
     * Consider using @GlobalScope.posmod instead if you want to handle negative numbers.
     */
    operator fun rem(scalar: Int) = Vector2i(
        x % scalar,
        y % scalar,
    )

    operator fun get(idx: Int): Int = when (idx) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(n: Int, i: Int) = when (n) {
        0 -> x = i
        1 -> y = i
        else -> throw IndexOutOfBoundsException()
    }

    operator fun get(axis: Axis): Int = when (axis) {
        Axis.X -> x
        Axis.Y -> y
    }

    operator fun set(axis: Axis, i: Int) = when (axis) {
        Axis.X -> x = i
        Axis.Y -> y = i
    }


    operator fun plus(v: Vector2i) = Vector2i(x + v.x, y + v.y)
    operator fun plus(scalar: Int) = Vector2i(x + scalar, y + scalar)
    operator fun plus(scalar: Long) = plus(scalar.toInt())
    operator fun plus(scalar: Float) = plus(scalar.toInt())
    operator fun plus(scalar: Double) = plus(scalar.toInt())

    operator fun minus(v: Vector2i) = Vector2i(x - v.x, y - v.y)
    operator fun minus(scalar: Int) = Vector2i(x - scalar, y - scalar)
    operator fun minus(scalar: Long) = minus(scalar.toInt())
    operator fun minus(scalar: Float) = minus(scalar.toInt())
    operator fun minus(scalar: Double) = minus(scalar.toInt())

    operator fun times(v1: Vector2i) = Vector2i(x * v1.x, y * v1.y)
    operator fun times(scalar: Int) = Vector2i(x * scalar, y * scalar)
    operator fun times(scalar: Long) = times(scalar.toInt())
    operator fun times(scalar: Float) = times(scalar.toDouble())
    operator fun times(scalar: Double) = Vector2(x * scalar, y * scalar)

    operator fun div(v1: Vector2i) = Vector2i(x / v1.x, y / v1.y)
    operator fun div(scalar: Int) = Vector2i(x / scalar, y / scalar)
    operator fun div(scalar: Long) = div(scalar.toInt())
    operator fun div(scalar: Float) = div(scalar.toDouble())
    operator fun div(scalar: Double) = Vector2(x / scalar, y / scalar)

    operator fun unaryPlus() = Vector2i(x, y)

    operator fun unaryMinus() = Vector2i(-x, -y)

    fun toVector2() = Vector2(x, y)

    override fun compareTo(other: Vector2i): Int =
        if (x == other.x) {
            when {
                y < other.y -> -1
                y == other.y -> 0
                else -> 1
            }
        } else {
            when {
                x < other.x -> -1
                else -> 1
            }
        }

    override fun equals(other: Any?): Boolean = when (other) {
        is Vector2i -> (x == other.x && y == other.y)
        else -> false
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String {
        return "($x, $y)"
    }
}

operator fun Int.times(vector: Vector2i) = vector * this

operator fun Long.times(vector: Vector2i) = vector * this

operator fun Float.times(vector: Vector2i) = vector * this

operator fun Double.times(vector: Vector2i) = vector * this
