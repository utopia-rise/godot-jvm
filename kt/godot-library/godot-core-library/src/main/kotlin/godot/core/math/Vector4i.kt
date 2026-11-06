@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.common.util.snapped
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign
import kotlin.math.sqrt

class Vector4i(
    var x: Int,
    var y: Int,
    var z: Int,
    var w: Int
) : Comparable<Vector4i>, CoreType {

    //CONSTANTS
    enum class Axis(override val value: Long): GodotEnum {
        X(0L),
        Y(1L),
        Z(2L),
        W(3L);

        companion object {
            fun from(value: Long) = when (value) {
                0L -> X
                1L -> Y
                2L -> Z
                3L -> W
                else -> throw AssertionError("Unknown axis for Vector4: $value")
            }
        }
    }

    companion object {
        val ZERO: Vector4i
            get() = Vector4i(0, 0, 0, 0)
        val ONE: Vector4i
            get() = Vector4i(1, 1, 1, 1)
        val MIN: Vector4i
            get() = Vector4i(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)
        val MAX: Vector4i
            get() = Vector4i(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)
    }


    //CONSTRUCTOR
    constructor() :
        this(0, 0, 0, 0)

    constructor(vec: Vector4i) :
        this(vec.x, vec.y, vec.z, vec.w)

    constructor(vec: Vector4) : this(vec.x, vec.y, vec.z, vec.w)

    constructor(x: Number, y: Number, z: Number, w: Number) :
        this(x.toInt(), y.toInt(), z.toInt(), w.toInt())

    //API

    /**
     * Returns a new vector with all components in absolute values (i.e. positive).
     */
    fun abs(): Vector4i {
        return Vector4i(abs(x), abs(y), abs(z), abs(w))
    }

    /**
     * Returns a new vector with all components clamped between the components of min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clamp(min: Vector4i, max: Vector4i) = Vector4i(
        clampComponent(x, min.x, max.x),
        clampComponent(y, min.y, max.y),
        clampComponent(z, min.z, max.z),
        clampComponent(w, min.w, max.w)
    )

    /**
     * Returns a new vector with all components clamped between the min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clampi(min: Int, max: Int) = Vector4i(clampComponent(x, min, max), clampComponent(y, min, max), clampComponent(z, min, max), clampComponent(w, min, max))

    private fun clampComponent(value: Int, min: Int, max: Int) = if (value < min) min else if (value > max) max else value

    /**
     * Returns the vector’s length.
     */
    fun length(): Double {
        return sqrt(lengthSquared().toDouble())
    }

    fun distanceTo(to: Vector4i) = (to - this).length()

    fun distanceSquaredTo(to: Vector4i) = (to - this).lengthSquared()

    /**
     * Returns the vector’s length squared.
     * Prefer this function over length if you need to sort vectors or need the squared length for some formula.
     */
    fun lengthSquared() = x.toLong() * x + y.toLong() * y + z.toLong() * z + w.toLong() * w

    /**
     * Returns the component-wise maximum of this and with.
     */
    fun max(with: Vector4i) = Vector4i(max(x, with.x), max(y, with.y), max(z, with.z), max(w, with.w))

    /**
     * Returns the axis of the vector's highest value. See AXIS_* constants.
     * If all components are equal, this method returns AXIS_X.
     */
    fun maxAxis(): Axis {
        var maxIndex = 0
        var maxValue = x
        for (i in 1 until 4) {
            val axisValue = this[i]
            if (axisValue <= maxValue) {
                continue
            }
            maxIndex = i
            maxValue = axisValue
        }
        return Axis.from(maxIndex.toLong())
    }

    /**
     * Returns the component-wise maximum of this and with.
     */
    fun maxi(with: Int) = Vector4i(max(x, with), max(y, with), max(z, with), max(w, with))

    /**
     * Returns the component-wise minimum of this and with.
     */
    fun min(with: Vector4i) = Vector4i(min(x, with.x), min(y, with.y), min(z, with.z), min(w, with.w))

    /**
     * Returns the axis of the vector’s smallest value. See AXIS_* constants.
     */
    fun minAxis(): Axis {
        var minIndex = 0
        var minValue = x
        for (i in 1 until 4) {
            val axisValue = this[i]
            if (axisValue > minValue) {
                continue
            }
            minIndex = i
            minValue = axisValue
        }
        return Axis.from(minIndex.toLong())
    }

    /**
     * Returns the component-wise minimum of this and with.
     */
    fun mini(with: Int) = Vector4i(min(x, with), min(y, with), min(z, with), min(w, with))

    /**
     * Returns the vector with each component set to one or negative one, depending on the signs of the components.
     */
    fun sign(): Vector4i {
        return Vector4i(x.sign, y.sign, z.sign, w.sign)
    }

    /**
     * Returns a new vector with each component snapped to the closest multiple of the corresponding component in [step].
     */
    fun snapped(by: Vector4i): Vector4i {
        val v = Vector4i(this)
        v.snap(by)
        return v
    }

    internal fun snap(by: Vector4i) {
        x = snapped(x, by.x)
        y = snapped(y, by.y)
        z = snapped(z, by.z)
        w = snapped(w, by.w)
    }

    /**
     * Returns a new vector with each component snapped to the closest multiple of step.
     */
    fun snappedi(step: Int) = Vector4i(snapped(x, step), snapped(y, step), snapped(z, step), snapped(w, step))

    fun toVector4() = Vector4(this)

    /**
     * Gets the remainder of each component of the Vector4i with the components of the given Vector4i.
     * This operation uses truncated division, which is often not desired as it does not work well with negative numbers.
     * Consider using @GlobalScope.posmod instead if you want to handle negative numbers.
     */
    operator fun rem(other: Vector4i) = Vector4i(
        x % other.x,
        y % other.y,
        z % other.z,
        w % other.w,
    )

    /**
     * Gets the remainder of each component of the Vector4i with the given int.
     * This operation uses truncated division, which is often not desired as it does not work well with negative numbers.
     * Consider using @GlobalScope.posmod instead if you want to handle negative numbers.
     */
    operator fun rem(scalar: Int) = Vector4i(
        x % scalar,
        y % scalar,
        z % scalar,
        w % scalar,
    )

    operator fun get(n: Int): Int = when (n) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(n: Int, i: Int): Unit = when (n) {
        0 -> x = i
        1 -> y = i
        2 -> z = i
        3 -> w = i
        else -> throw IndexOutOfBoundsException()
    }

    operator fun get(axis: Axis): Int = when (axis) {
        Axis.X -> x
        Axis.Y -> y
        Axis.Z -> z
        Axis.W -> w
    }

    operator fun set(axis: Axis, i: Int) = when (axis) {
        Axis.X -> x = i
        Axis.Y -> y = i
        Axis.Z -> z = i
        Axis.W -> w = i
    }

    operator fun plus(vec: Vector4i) = Vector4i(x + vec.x, y + vec.y, z + vec.z, w + vec.w)
    operator fun plus(scalar: Int) = Vector4i(x + scalar, y + scalar, z + scalar, w + scalar)
    operator fun plus(scalar: Long) = plus(scalar.toInt())
    operator fun plus(scalar: Float) = plus(scalar.toInt())
    operator fun plus(scalar: Double) = plus(scalar.toInt())

    operator fun minus(vec: Vector4i) = Vector4i(x - vec.x, y - vec.y, z - vec.z, w - vec.w)
    operator fun minus(scalar: Int) = Vector4i(x - scalar, y - scalar, z - scalar, w - scalar)
    operator fun minus(scalar: Long) = minus(scalar.toInt())
    operator fun minus(scalar: Float) = minus(scalar.toInt())
    operator fun minus(scalar: Double) = minus(scalar.toInt())

    operator fun times(vec: Vector4i) = Vector4i(x * vec.x, y * vec.y, z * vec.z, w * vec.w)
    operator fun times(scalar: Int) = Vector4i(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun times(scalar: Long) = times(scalar.toInt())
    operator fun times(scalar: Float) = times(scalar.toDouble())
    operator fun times(scalar: Double) = Vector4(x * scalar, y * scalar, z * scalar, w * scalar)

    operator fun div(vec: Vector4i) = Vector4i(x / vec.x, y / vec.y, z / vec.z, w / vec.w)
    operator fun div(scalar: Int) = Vector4i(x / scalar, y / scalar, z / scalar, w / scalar)
    operator fun div(scalar: Long) = div(scalar.toInt())
    operator fun div(scalar: Float) = div(scalar.toDouble())
    operator fun div(scalar: Double) = Vector4(x / scalar, y / scalar, z / scalar, w / scalar)

    operator fun unaryPlus() = Vector4i(this)
    operator fun unaryMinus() = Vector4i(-x, -y, -z, -w)

    override fun equals(other: Any?): Boolean = when (other) {
        is Vector4i -> (x == other.x && y == other.y && z == other.z && w == other.w)
        else -> false
    }

    override fun compareTo(other: Vector4i): Int {
        if (x == other.x) {
            if (y == other.y) {
                return if (z == other.z) {
                    when {
                        w < other.w -> -1
                        w == other.w -> 0
                        else -> 1
                    }
                } else {
                    when {
                        z < other.z -> -1
                        else -> 1
                    }
                }
            } else {
                return when {
                    y < other.y -> -1
                    else -> 1
                }
            }
        } else {
            return when {
                x < other.x -> -1
                else -> 1
            }
        }
    }

    override fun toString(): String {
        return "($x, $y, $z, $w)"
    }

    override fun hashCode(): Int {
        var h = x
        h = 31 * h + y
        h = 31 * h + z
        h = 31 * h + w
        return h
    }
}

operator fun Int.plus(vec: Vector4i) = vec + this
operator fun Long.plus(vec: Vector4i) = vec + this
operator fun Float.plus(vec: Vector4i) = vec + this
operator fun Double.plus(vec: Vector4i) = vec + this

operator fun Int.minus(vec: Vector4i) = Vector4i(this - vec.x, this - vec.y, this - vec.z, this - vec.w)
operator fun Long.minus(vec: Vector4i) = Vector4i(this - vec.x, this - vec.y, this - vec.z, this - vec.w)
operator fun Float.minus(vec: Vector4i) = Vector4i(this - vec.x, this - vec.y, this - vec.z, this - vec.w)
operator fun Double.minus(vec: Vector4i) = Vector4i(this - vec.x, this - vec.y, this - vec.z, this - vec.w)

operator fun Int.times(vec: Vector4i) = vec * this
operator fun Long.times(vec: Vector4i) = vec * this
operator fun Float.times(vec: Vector4i) = vec * this
operator fun Double.times(vec: Vector4i) = vec * this
