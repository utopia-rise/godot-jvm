@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.common.util.RealT
import godot.common.util.snapped
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

class Vector3i(
    var x: Int,
    var y: Int,
    var z: Int
) : Comparable<Vector3i>, CoreType {
    //CONSTANTS
    enum class Axis(override val value: Long): GodotEnum {
        X(0L),
        Y(1L),
        Z(2L);

        companion object {
            fun from(value: Long) = when (value) {
                0L -> X
                1L -> Y
                2L -> Z
                else -> throw AssertionError("Unknown axis for Vector3i: $value")
            }
        }
    }

    companion object {
        val MIN: Vector3i
            get() = Vector3i(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)
        val MAX: Vector3i
            get() = Vector3i(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)
        val ZERO: Vector3i
            get() = Vector3i(0, 0, 0)
        val ONE: Vector3i
            get() = Vector3i(1, 1, 1)
        val LEFT: Vector3i
            get() = Vector3i(-1, 0, 0)
        val RIGHT: Vector3i
            get() = Vector3i(1, 0, 0)
        val UP: Vector3i
            get() = Vector3i(0, 1, 0)
        val DOWN: Vector3i
            get() = Vector3i(0, -1, 0)
        val FORWARD: Vector3i
            get() = Vector3i(0, 0, -1)
        val BACK: Vector3i
            get() = Vector3i(0, 0, 1)
    }

    //CONSTRUCTOR
    constructor() : this(0, 0, 0)

    constructor(vec: Vector3i) : this(vec.x, vec.y, vec.z)

    constructor(vec: Vector3) : this(vec.x, vec.y, vec.z)

    constructor(x: Number, y: Number, z: Number) : this(x.toInt(), y.toInt(), z.toInt())

    //API

    /**
     * Returns a new vector with all components in absolute values (i.e. positive).
     */
    fun abs(): Vector3i {
        return Vector3i(kotlin.math.abs(x), kotlin.math.abs(y), kotlin.math.abs(z))
    }

    /**
     * Returns a new vector with all components clamped between the components of min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clamp(min: Vector3i, max: Vector3i) = Vector3i(
        if (x < min.x) min.x else if (x > max.x) max.x else x,
        if (y < min.y) min.y else if (y > max.y) max.y else y,
        if (z < min.z) min.z else if (z > max.z) max.z else z
    )

    /**
     * Returns a new vector with all components clamped between the min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clampi(min: Int, max: Int) = Vector3i(
        if (x < min) min else if (x > max) max else x,
        if (y < min) min else if (y > max) max else y,
        if (z < min) min else if (z > max) max else z
    )

    /**
     * Returns the vector’s length.
     */
    fun length(): RealT {
        return sqrt(lengthSquared().toDouble())
    }

    /**
     * Returns the vector’s length squared.
     * Prefer this function over length if you need to sort vectors or need the squared length for some formula.
     */
    fun lengthSquared(): Long {
        return x.toLong() * x + y.toLong() * y + z.toLong() * z
    }

    fun distanceTo(to: Vector3i): RealT = (to - this).length()

    fun distanceSquaredTo(to: Vector3i): Long = (to - this).lengthSquared()

    /**
     * Returns the component-wise maximum of this and with, equivalent to `Vector3i(maxi(x, with.x), maxi(y, with.y), maxi(z, with.z))`.
     */
    fun max(with: Vector3i) = Vector3i(max(x, with.x), max(y, with.y), max(z, with.z))

    /**
     * Returns the axis of the vector's highest value. See AXIS_* constants.
     * If all components are equal, this method returns Axis.X.
     */
    fun maxAxis() = if (x < y) {
        if (y < z) {
            Axis.Z
        } else {
            Axis.Y
        }
    } else {
        if (x < z) {
            Axis.Z
        } else {
            Axis.X
        }
    }

    /**
     * Returns the component-wise maximum of this and with, equivalent to `Vector3i(maxi(x, with), maxi(y, with), maxi(z, with))`.
     */
    fun maxi(with: Int) = Vector3i(max(x, with), max(y, with), max(z, with))

    /**
     * Returns the component-wise minimum of this and with, equivalent to `Vector3i(mini(x, with.x), mini(y, with.y), mini(z, with.z))`
     */
    fun min(with: Vector3i) = Vector3i(min(x, with.x), min(y, with.y), min(z, with.z))

    /**
     * Returns the axis of the vector’s smallest value. See AXIS_* constants.
     */
    fun minAxis() = if (x < y) {
        if (x < z) {
            Axis.X
        } else {
            Axis.Z
        }
    } else {
        if (y < z) {
            Axis.Y
        } else {
            Axis.Z
        }
    }

    /**
     * Returns the component-wise minimum of this and with, equivalent to `ector3i(mini(x, with), mini(y, with), mini(z, with))`
     */
    fun mini(with: Int) = Vector3i(min(x, with), min(y, with), min(z, with))

    /**
     * Returns the vector with each component set to one or negative one, depending on the signs of the components.
     */
    fun sign(): Vector3i {
        return Vector3i(kotlin.math.sign(x.toDouble()), kotlin.math.sign(y.toDouble()), kotlin.math.sign(z.toDouble()))
    }

    /**
     * Returns a new vector with each component snapped to the closest multiple of the corresponding component in [step].
     */
    fun snapped(by: Vector3i): Vector3i {
        val v = Vector3i(this)
        v.snap(by)
        return v
    }

    internal fun snap(by: Vector3i) {
        x = snapped(x, by.x)
        y = snapped(y, by.y)
        z = snapped(z, by.z)
    }

    /**
     * Returns a new vector with each component snapped to the closest multiple of step.
     */
    fun snappedi(step: Int) = Vector3i(snapped(x, step), snapped(y, step), snapped(z, step))

    /**
     * Gets the remainder of each component of the Vector3i with the components of the given Vector3i.
     * This operation uses truncated division, which is often not desired as it does not work well with negative numbers.
     * Consider using @GlobalScope.posmod instead if you want to handle negative numbers.
     */
    operator fun rem(other: Vector3i) = Vector3i(
        x % other.x,
        y % other.y,
        z % other.z,
    )

    /**
     * Gets the remainder of each component of the Vector3i with the given int.
     * This operation uses truncated division, which is often not desired as it does not work well with negative numbers.
     * Consider using @GlobalScope.posmod instead if you want to handle negative numbers.
     */
    operator fun rem(scalar: Int) = Vector3i(
        x % scalar,
        y % scalar,
        z % scalar,
    )

    operator fun get(n: Int): Int = when (n) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(n: Int, i: Int): Unit = when (n) {
        0 -> x = i
        1 -> y = i
        2 -> z = i
        else -> throw IndexOutOfBoundsException()
    }

    operator fun get(axis: Axis): Int = when (axis) {
        Axis.X -> x
        Axis.Y -> y
        Axis.Z -> z
    }

    operator fun set(axis: Axis, i: Int) = when (axis) {
        Axis.X -> x = i
        Axis.Y -> y = i
        Axis.Z -> z = i
    }

    operator fun plus(vec: Vector3i) = Vector3i(x + vec.x, y + vec.y, z + vec.z)
    operator fun plus(scalar: Int) = Vector3i(x + scalar, y + scalar, z + scalar)
    operator fun plus(scalar: Long) = plus(scalar.toInt())
    operator fun plus(scalar: Float) = plus(scalar.toInt())
    operator fun plus(scalar: Double) = plus(scalar.toInt())

    operator fun minus(vec: Vector3i) = Vector3i(x - vec.x, y - vec.y, z - vec.z)
    operator fun minus(scalar: Int) = Vector3i(x - scalar, y - scalar, z - scalar)
    operator fun minus(scalar: Long) = minus(scalar.toInt())
    operator fun minus(scalar: Float) = minus(scalar.toInt())
    operator fun minus(scalar: Double) = minus(scalar.toInt())

    operator fun times(vec: Vector3i) = Vector3i(x * vec.x, y * vec.y, z * vec.z)
    operator fun times(scalar: Int) = Vector3i(x * scalar, y * scalar, z * scalar)
    operator fun times(scalar: Long) = times(scalar.toInt())
    operator fun times(scalar: Float) = times(scalar.toDouble())
    operator fun times(scalar: Double) = Vector3(x * scalar, y * scalar, z * scalar)

    operator fun div(vec: Vector3i) = Vector3i(x / vec.x, y / vec.y, z / vec.z)
    operator fun div(scalar: Int) = Vector3i(x / scalar, y / scalar, z / scalar)
    operator fun div(scalar: Long) = div(scalar.toInt())
    operator fun div(scalar: Float) = div(scalar.toDouble())
    operator fun div(scalar: Double) = Vector3(x / scalar, y / scalar, z / scalar)

    operator fun unaryPlus() = Vector3i(x, y, z)

    operator fun unaryMinus() = Vector3i(-x, -y, -z)

    fun toVector3() = Vector3(x, y, z)

    override fun equals(other: Any?): Boolean = when (other) {
        is Vector3i -> (x == other.x && y == other.y && z == other.z)
        else -> false
    }

    override fun compareTo(other: Vector3i): Int {
        if (x == other.x) {
            return if (y == other.y)
                when {
                    z < other.z -> -1
                    z == other.z -> 0
                    else -> 1
                }
            else
                when {
                    y < other.y -> -1
                    else -> 1
                }
        } else
            return when {
                x < other.x -> -1
                else -> 1
            }
    }

    override fun toString(): String {
        return "($x, $y, $z)"
    }

    override fun hashCode(): Int {
        var h = x
        h = 31 * h + y
        h = 31 * h + z
        return h
    }
}

operator fun Int.times(vector: Vector3i) = vector * this
operator fun Long.times(vector: Vector3i) = vector * this
operator fun Float.times(vector: Vector3i) = vector * this
operator fun Double.times(vector: Vector3i) = vector * this
