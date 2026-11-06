@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.common.util.CMP_EPSILON
import godot.common.util.RealT
import godot.common.util.UNIT_EPSILON
import godot.common.util.cubicInterpolateInTime
import godot.common.util.fposmod
import godot.common.util.isEqualApprox
import godot.common.util.snapped
import godot.common.util.toRealT
import godot.internal.logging.GodotLogging
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt
import kotlin.math.truncate
import kotlin.math.sign
import godot.common.util.clampValue
import godot.common.util.roundValue

class Vector4(
    var x: RealT,
    var y: RealT,
    var z: RealT,
    var w: RealT
) : Comparable<Vector4>, CoreType {

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
        val ZERO: Vector4
            get() = Vector4(0, 0, 0, 0)
        val ONE: Vector4
            get() = Vector4(1, 1, 1, 1)
        val INF: Vector4
            get() = Vector4(RealT.POSITIVE_INFINITY, RealT.POSITIVE_INFINITY, RealT.POSITIVE_INFINITY, RealT.POSITIVE_INFINITY)
    }


    //CONSTRUCTOR
    constructor() :
        this(0.0, 0.0, 0.0, 0.0)

    constructor(vec: Vector4) :
        this(vec.x, vec.y, vec.z, vec.w)

    constructor(other: Vector4i) : this(other.x, other.y, other.z, other.w)

    constructor(x: Number, y: Number, z: Number, w: Number) :
        this(x.toRealT(), y.toRealT(), z.toRealT(), w.toRealT())

    //API

    /**
     * Returns a new vector with all components in absolute values (i.e. positive).
     */
    fun abs(): Vector4 {
        return Vector4(abs(x), abs(y), abs(z), abs(w))
    }

    /**
     * Returns a new vector with all components rounded up.
     */
    fun ceil(): Vector4 {
        return Vector4(ceil(x), ceil(y), ceil(z), ceil(w))
    }

    /**
     * Returns a new vector with all components clamped between the components of min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clamp(min: Vector4, max: Vector4) = Vector4(
        clampValue(x, min.x, max.x),
        clampValue(y, min.y, max.y),
        clampValue(z, min.z, max.z),
        clampValue(w, min.w, max.w)
    )

    /**
     * Returns a new vector with all components clamped between the min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clampf(min: RealT, max: RealT) = Vector4(clampValue(x, min, max), clampValue(y, min, max), clampValue(z, min, max), clampValue(w, min, max))

    /**
     * Performs a cubic interpolation between vectors pre_a, a, b, post_b (a is current), by the given amount t.
     * t is in the range of 0.0 - 1.0, representing the amount of interpolation.
     */
    fun cubicInterpolate(b: Vector4, pre: Vector4, post: Vector4, t: RealT): Vector4 {
        val t2 = t * t
        val t3 = t2 * t

        return ((this * 2.0) +
            (-pre + b) * t +
            (pre * 2.0 - this * 5.0 + b * 4.0 - post) * t2 +
            (-pre + this * 3.0 - b * 3.0 + post) * t3) * 0.5
    }

    /**
     * Cubically interpolates between this vector and b using pre_a and post_b as handles, and returns the result at
     * position weight. weight is on the range of 0.0 to 1.0, representing the amount of interpolation.
     */
    fun cubicInterpolateInTime(
        b: Vector4,
        preA: Vector4,
        postB: Vector4,
        weight: RealT,
        bT: RealT,
        preAT: RealT,
        postBT: RealT
    ) = Vector4(this).also {
        it.x = cubicInterpolateInTime(
            it.x,
            b.x,
            preA.x,
            postB.x,
            weight,
            bT,
            preAT,
            postBT
        )
        it.y = cubicInterpolateInTime(
            it.y,
            b.y,
            preA.y,
            postB.y,
            weight,
            bT,
            preAT,
            postBT
        )
        it.z = cubicInterpolateInTime(
            it.z,
            b.z,
            preA.z,
            postB.z,
            weight,
            bT,
            preAT,
            postBT
        )
        it.w = cubicInterpolateInTime(
            it.w,
            b.w,
            preA.w,
            postB.w,
            weight,
            bT,
            preAT,
            postBT
        )
    }

    /**
     * Returns the normalized vector pointing from this vector to b.
     */
    fun directionTo(other: Vector4): Vector4 {
        val ret = Vector4(other.x - x, other.y - y, other.z - z, other.w - w)
        ret.normalize()
        return ret
    }

    /**
     * Returns the squared distance to b.
     * Prefer this function over distance_to if you need to sort vectors or need the squared distance for some formula.
     */
    fun distanceSquaredTo(other: Vector4): RealT {
        return (other - this).lengthSquared()
    }

    /**
     * Returns the distance to b.
     */
    fun distanceTo(other: Vector4): RealT {
        return (other - this).length()
    }

    /**
     * Returns the dot product with b.
     */
    fun dot(b: Vector4): RealT {
        return x * b.x + y * b.y + z * b.z + w * b.w
    }

    /**
     * Returns a new vector with all components rounded down.
     */
    fun floor(): Vector4 {
        return Vector4(floor(x), floor(y), floor(z), floor(w))
    }

    /**
     * Returns the inverse of the vector. This is the same as Vector3( 1.0 / v.x, 1.0 / v.y, 1.0 / v.z ).
     */
    fun inverse() = Vector4(1.0 / x, 1.0 / y, 1.0 / z, 1.0 / w)

    /**
     * Returns true if this vector and v are approximately equal, by running isEqualApprox on each component.
     */
    fun isEqualApprox(other: Vector4): Boolean {
        return x.isEqualApprox(other.x) && y.isEqualApprox(other.y) && z.isEqualApprox(other.z) && w.isEqualApprox(other.w)
    }

    /**
     * Returns true if this vector is finite, by calling [Float.isFinite] on each component.
     */
    fun isFinite() = x.isFinite() && y.isFinite() && z.isFinite() && w.isFinite()

    /**
     * Returns true if the vector is normalized.
     */
    fun isNormalized(): Boolean {
        return lengthSquared().isEqualApprox(1.0, UNIT_EPSILON)
    }

    /**
     * Returns true if this vector's values are approximately zero
     */
    fun isZeroApprox() = abs(x) < CMP_EPSILON && abs(y) < CMP_EPSILON && abs(z) < CMP_EPSILON && abs(w) < CMP_EPSILON

    /**
     * Returns the vector’s length.
     */
    fun length(): RealT {
        return sqrt(lengthSquared())
    }

    /**
     * Returns the vector’s length squared.
     * Prefer this function over length if you need to sort vectors or need the squared length for some formula.
     */
    fun lengthSquared() = this.dot(this)

    /**
     * Returns the result of the linear interpolation between this vector and to by amount weight. weight is on the
     * range of 0.0 to 1.0, representing the amount of interpolation.
     */
    fun lerp(to: Vector4, weight: RealT) = Vector4(
        x + (weight * (to.x - x)),
        y + (weight * (to.y - y)),
        z + (weight * (to.z - z)),
        w + (weight * (to.w - w))
    )


    /**
     * Returns the component-wise maximum of this and with.
     */
    fun max(with: Vector4) = Vector4(maxOf(x, with.x), maxOf(y, with.y), maxOf(z, with.z), maxOf(w, with.w))

    /**
     * Returns the axis of the vector's highest value. See AXIS_* constants.
     * If all components are equal, this method returns AXIS_X.
     */
    fun maxAxis(): Axis {
        var maxIndex = 0
        var maxValue = x
        for (i in 1 until 4) {
            val axisValue = this[i]
            if (axisValue > maxValue) {
                maxIndex = i
                maxValue = axisValue
            }
        }
        return Axis.from(maxIndex.toLong())
    }

    /**
     * Returns the component-wise maximum of this and with.
     */
    fun maxf(with: RealT) = Vector4(maxOf(x, with), maxOf(y, with), maxOf(z, with), maxOf(w, with))

    /**
     * Returns the component-wise minimum of this and with.
     */
    fun min(with: Vector4) = Vector4(minOf(x, with.x), minOf(y, with.y), minOf(z, with.z), minOf(w, with.w))

    /**
     * Returns the axis of the vector’s smallest value. See AXIS_* constants.
     */
    fun minAxis(): Axis {
        var minIndex = 0
        var minValue = x
        for (i in 1 until 4) {
            val axisValue = this[i]
            if (axisValue <= minValue) {
                minIndex = i
                minValue = axisValue
            }
        }
        return Axis.from(minIndex.toLong())
    }

    /**
     * Returns the component-wise minimum of this and with.
     */
    fun minf(with: RealT) = Vector4(minOf(x, with), minOf(y, with), minOf(z, with), minOf(w, with))

    /**
     * Returns the vector scaled to unit length. Equivalent to v / v.length().
     */
    fun normalized(): Vector4 {
        val v = Vector4(this)
        v.normalize()
        return v
    }

    internal fun normalize() {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isFinite()) {
                GodotLogging.warning("Vector4 cannot be normalized, the elements must be finite. Making (0, 0, 0, 0) as a fallback.")
                x = 0.0
                y = 0.0
                z = 0.0
                w = 0.0
                return
            }
        }

        val l = lengthSquared()
        if (l == 0.0) {
            x = 0.0
            y = 0.0
            z = 0.0
            w = 0.0
        } else {
            val length = sqrt(l)
            x /= length
            y /= length
            z /= length
            w /= length
        }
    }

    /**
     * Returns a vector composed of the fposmod of this vector’s components and mod.
     */
    fun posmod(mod: RealT) = Vector4(x.fposmod(mod), y.fposmod(mod), z.fposmod(mod), w.fposmod(mod))

    /**
     * Returns a vector composed of the fposmod of this vector’s components and modv’s components.
     */
    fun posmodv(modv: Vector4) = Vector4(x.fposmod(modv.x), y.fposmod(modv.y), z.fposmod(modv.z), w.fposmod(modv.w))

    /**
     * Returns the vector with all components rounded to the nearest integer, with halfway cases rounded away from zero.
     */
    fun round(): Vector4 {
        return Vector4(roundValue(x), roundValue(y), roundValue(z), roundValue(w))
    }

    /**
     * Returns the vector with each component set to one or negative one, depending on the signs of the components.
     */
    fun sign(): Vector4 {
        return Vector4(sign(x), sign(y), sign(z), sign(w))
    }

    /**
     * Returns a new vector with each component snapped to the closest multiple of the corresponding component in [step].
     */
    fun snapped(by: Vector4): Vector4 {
        val v = Vector4(this)
        v.snap(by)
        return v
    }

    internal fun snap(by: Vector4) {
        x = snapped(x, by.x)
        y = snapped(y, by.y)
        z = snapped(z, by.z)
        w = snapped(w, by.w)
    }


    /**
     * Returns a new vector with each component snapped to the nearest multiple of step.
     * This can also be used to round the components to an arbitrary number of decimals.
     */
    fun snappedf(step: RealT) = Vector4(snapped(x, step), snapped(y, step), snapped(z, step), snapped(w, step))

    internal fun snap(vecal: RealT) {
        if (vecal != 0.0) {
            x = (floor(x / vecal + 0.5) * vecal)
            y = (floor(y / vecal + 0.5) * vecal)
            z = (floor(z / vecal + 0.5) * vecal)
            w = (floor(w / vecal + 0.5) * vecal)
        }
    }

    fun toVector4i() = Vector4i(this)


    operator fun get(n: Int): RealT = when (n) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(n: Int, f: RealT): Unit = when (n) {
        0 -> x = f
        1 -> y = f
        2 -> z = f
        3 -> w = f
        else -> throw IndexOutOfBoundsException()
    }

    operator fun get(axis: Axis): RealT = when (axis) {
        Axis.X -> x
        Axis.Y -> y
        Axis.Z -> z
        Axis.W -> w
    }

    operator fun set(axis: Axis, f: RealT) = when (axis) {
        Axis.X -> x = f
        Axis.Y -> y = f
        Axis.Z -> z = f
        Axis.W -> w = f
    }

    operator fun plus(vec: Vector4) = Vector4(x + vec.x, y + vec.y, z + vec.z, w + vec.w)
    operator fun plus(scalar: Int) = Vector4(x + scalar, y + scalar, z + scalar, w + scalar)
    operator fun plus(scalar: Long) = Vector4(x + scalar, y + scalar, z + scalar, w + scalar)
    operator fun plus(scalar: Float) = Vector4(x + scalar, y + scalar, z + scalar, w + scalar)
    operator fun plus(scalar: Double) = Vector4(x + scalar, y + scalar, z + scalar, w + scalar)

    operator fun minus(vec: Vector4) = Vector4(x - vec.x, y - vec.y, z - vec.z, w - vec.w)
    operator fun minus(scalar: Int) = Vector4(x - scalar, y - scalar, z - scalar, w - scalar)
    operator fun minus(scalar: Long) = Vector4(x - scalar, y - scalar, z - scalar, w - scalar)
    operator fun minus(scalar: Float) = Vector4(x - scalar, y - scalar, z - scalar, w - scalar)
    operator fun minus(scalar: Double) = Vector4(x - scalar, y - scalar, z - scalar, w - scalar)

    operator fun times(vec: Vector4) = Vector4(x * vec.x, y * vec.y, z * vec.z, w * vec.w)
    operator fun times(scalar: Int) = Vector4(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun times(scalar: Long) = Vector4(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun times(scalar: Float) = Vector4(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun times(scalar: Double) = Vector4(x * scalar, y * scalar, z * scalar, w * scalar)

    operator fun div(vec: Vector4) = Vector4(x / vec.x, y / vec.y, z / vec.z, w / vec.w)
    operator fun div(scalar: Int) = Vector4(x / scalar, y / scalar, z / scalar, w / scalar)
    operator fun div(scalar: Long) = Vector4(x / scalar, y / scalar, z / scalar, w / scalar)
    operator fun div(scalar: Float) = Vector4(x / scalar, y / scalar, z / scalar, w / scalar)
    operator fun div(scalar: Double) = Vector4(x / scalar, y / scalar, z / scalar, w / scalar)

    operator fun unaryMinus() = Vector4(-x, -y, -z, -w)
    operator fun unaryPlus() = Vector4(this)

    operator fun times(projection: Projection): Vector4 = projection.xformInv(this)

    override fun equals(other: Any?): Boolean = when (other) {
        is Vector4 -> (x == other.x && y == other.y && z == other.z && w == other.w)
        else -> false
    }

    override fun compareTo(other: Vector4): Int {
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
        var h = (x + 0.0).hashCode()
        h = 31 * h + (y + 0.0).hashCode()
        h = 31 * h + (z + 0.0).hashCode()
        h = 31 * h + (w + 0.0).hashCode()
        return h
    }
}

operator fun Int.plus(vec: Vector4) = vec + this
operator fun Long.plus(vec: Vector4) = vec + this
operator fun Float.plus(vec: Vector4) = vec + this
operator fun Double.plus(vec: Vector4) = vec + this

operator fun Int.minus(vec: Vector4) = Vector4(this - vec.x, this - vec.y, this - vec.z, this - vec.w)
operator fun Long.minus(vec: Vector4) = Vector4(this - vec.x, this - vec.y, this - vec.z, this - vec.w)
operator fun Float.minus(vec: Vector4) = Vector4(this - vec.x, this - vec.y, this - vec.z, this - vec.w)
operator fun Double.minus(vec: Vector4) = Vector4(this - vec.x, this - vec.y, this - vec.z, this - vec.w)

operator fun Int.times(vec: Vector4) = vec * this
operator fun Long.times(vec: Vector4) = vec * this
operator fun Float.times(vec: Vector4) = vec * this
operator fun Double.times(vec: Vector4) = vec * this
