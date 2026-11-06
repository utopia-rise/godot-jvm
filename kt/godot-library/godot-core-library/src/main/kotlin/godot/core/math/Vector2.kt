@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.common.util.CMP_EPSILON
import godot.common.util.RealT
import godot.common.util.bezierDerivative
import godot.common.util.bezierInterpolate
import godot.common.util.cubicInterpolateInTime
import godot.common.util.fposmod
import godot.common.util.isEqualApprox
import godot.common.util.isZeroApprox
import godot.common.util.lerp
import godot.common.util.snapped
import godot.common.util.toRealT
import godot.common.util.UNIT_EPSILON
import godot.internal.logging.GodotLogging
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.ceil
import kotlin.math.cos
import kotlin.math.floor
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.truncate
import kotlin.math.sign
import godot.common.util.roundValue

class Vector2(
    var x: RealT,
    var y: RealT
) : Comparable<Vector2>, CoreType {

    //CONSTANTS
    enum class Axis(override val value: Long): GodotEnum {
        X(0L),
        Y(1L);

        companion object {
            fun from(value: Long) = when (value) {
                0L -> X
                1L -> Y
                else -> throw AssertionError("Unknown axis for Vector2: $value")
            }
        }
    }

    companion object {
        val ZERO: Vector2
            get() = Vector2(0, 0)
        val ONE: Vector2
            get() = Vector2(1, 1)
        val INF: Vector2
            get() = Vector2(RealT.POSITIVE_INFINITY, RealT.POSITIVE_INFINITY)
        val LEFT: Vector2
            get() = Vector2(-1, 0)
        val RIGHT: Vector2
            get() = Vector2(1, 0)
        val UP: Vector2
            get() = Vector2(0, -1)
        val DOWN: Vector2
            get() = Vector2(0, 1)

        fun fromAngle(angle: RealT) = Vector2(cos(angle), sin(angle))
    }


    //CONSTRUCTOR
    constructor() :
        this(0.0, 0.0)

    constructor(vec: Vector2) :
        this(vec.x, vec.y)

    constructor(other: Vector2i) : this(other.x, other.y)

    constructor(x: Number, y: Number) :
        this(x.toRealT(), y.toRealT())


    //API
    /**
     * Returns a new vector with all components in absolute values (i.e. positive).
     */
    fun abs() = Vector2(abs(x), abs(y))

    /**
     * Returns the vector’s angle in radians with respect to the x-axis, or (1, 0) vector.
     * Equivalent to the result of atan2 when called with the vector’s x and y as parameters: atan2(x, y).
     */
    fun angle(): RealT {
        return atan2(y, x)
    }

    /**
     * Returns the angle in radians between the two vectors.
     */
    fun angleTo(to: Vector2): RealT {
        return atan2(cross(to), dot(to))
    }

    /**
     * Returns the angle in radians between the line connecting the two points and the x coordinate.
     */
    fun angleToPoint(other: Vector2): RealT {
        return (other - this).angle();
    }

    /**
     * Returns the ratio of x to y.
     */
    fun aspect(): RealT {
        return this.x / this.y
    }

    /**
     * Returns the derivative at the given [t] on the Bézier curve defined by this vector and the given [control1],
     * [control2], and [end] points.
     */
    fun bezierDerivative(
        control1: Vector2,
        control2: Vector2,
        end: Vector2,
        t: RealT
    ) = Vector2(
        bezierDerivative(this.x, control1.x, control2.x, end.x, t),
        bezierDerivative(this.y, control1.y, control2.y, end.y, t)
    )

    /**
     * Returns the point at the given [t] on the Bézier curve defined by this vector and the given [control1],
     * [control2], and [end] points.
     */
    fun bezierInterpolate(
        control1: Vector2,
        control2: Vector2,
        end: Vector2,
        t: RealT
    ) = Vector2(
        bezierInterpolate(this.x, control1.x, control2.x, end.x, t),
        bezierInterpolate(this.y, control1.y, control2.y, end.y, t)
    )

    /**
     * Returns the vector “bounced off” from a plane defined by the given normal.
     */
    fun bounce(normal: Vector2): Vector2 {
        return -reflect(normal)
    }

    /**
     * Returns the vector with all components rounded up.
     */
    fun ceil(): Vector2 {
        return Vector2(ceil(x), ceil(y))
    }

    /**
     * Returns a new vector with all components clamped between the components of min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clamp(min: Vector2, max: Vector2) = Vector2(
        if (x < min.x) min.x else if (x > max.x) max.x else x,
        if (y < min.y) min.y else if (y > max.y) max.y else y
    )

    /**
     * Returns a new vector with all components clamped between the min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clampf(min: RealT, max: RealT) = Vector2(
        if (x < min) min else if (x > max) max else x,
        if (y < min) min else if (y > max) max else y
    )

    /**
     * Returns the 2 dimensional analog of the cross product with the given vector.
     */
    fun cross(other: Vector2): RealT {
        return x * other.y - y * other.x
    }

    /**
     * Cubicly interpolates between this vector and b using pre_a and post_b as handles, and returns the result at position t.
     * t is in the range of 0.0 - 1.0, representing the amount of interpolation.
     */
    fun cubicInterpolate(v: Vector2, pre: Vector2, post: Vector2, t: RealT): Vector2 {
        val p0: Vector2 = pre
        val p1: Vector2 = this
        val p2: Vector2 = v
        val p3: Vector2 = post

        val t2: RealT = t * t
        val t3: RealT = t2 * t

        return ((p1 * 2.0) +
            (-p0 + p2) * t +
            (p0 * 2.0 - p1 * 5.0 + p2 * 4.0 - p3) * t2 +
            (-p0 + p1 * 3.0 - p2 * 3.0 + p3) * t3) * 0.5
    }

    /**
     * Cubically interpolates between this vector and b using pre_a and post_b as handles, and returns the result at
     * position weight. weight is on the range of 0.0 to 1.0, representing the amount of interpolation.
     */
    fun cubicInterpolateInTime(
        b: Vector2,
        preA: Vector2,
        postB: Vector2,
        weight: RealT,
        bT: RealT,
        preAT: RealT,
        postBT: RealT
    ) = Vector2(this).also {
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
    }

    /**
     * Returns the normalized vector pointing from this vector to b.
     */
    fun directionTo(other: Vector2): Vector2 {
        val ret = Vector2(other.x - x, other.y - y)
        ret.normalize()
        return ret
    }

    /**
     * Returns the squared distance to vector b.
     * Prefer this function over distance_to if you need to sort vectors or need the squared distance for some formula.
     */
    fun distanceSquaredTo(other: Vector2): RealT {
        return (x - other.x) * (x - other.x) + (y - other.y) * (y - other.y)
    }

    /**
     * Returns the distance to vector b.
     */
    fun distanceTo(other: Vector2): RealT {
        return sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y))
    }

    /**
     * Returns the dot product with vector b.
     */
    fun dot(other: Vector2): RealT {
        return x * other.x + y * other.y
    }

    /**
     * Returns the vector with all components rounded down.
     */
    fun floor(): Vector2 {
        return Vector2(floor(x), floor(y))
    }

    /**
     * Returns true if this vector and v are approximately equal, by running isEqualApprox on each component.
     */
    fun isEqualApprox(other: Vector2): Boolean {
        return x.isEqualApprox(other.x) && y.isEqualApprox(other.y)
    }

    /**
     * Returns true if this vector is finite, by calling @GlobalScope.is_finite on each component.
     */
    fun isFinite() = x.isFinite() && y.isFinite()

    /**
     * Returns true if the vector is normalized.
     */
    fun isNormalized(): Boolean {
        return lengthSquared().isEqualApprox(1.0, UNIT_EPSILON)
    }

    /**
     * Returns true if this vector's values are approximately zero
     */
    fun isZeroApprox() = abs(x) < CMP_EPSILON && abs(y) < CMP_EPSILON

    /**
     * Returns the vector’s length.
     */
    fun length(): RealT {
        return sqrt(x * x + y * y)
    }

    /**
     * Returns the vector’s length squared.
     * Prefer this method over length if you need to sort vectors or need the squared length for some formula.
     */
    fun lengthSquared(): RealT {
        return x * x + y * y
    }

    /**
     * Returns the result of the linear interpolation between this vector and to by amount weight. weight is on the
     * range of 0.0 to 1.0, representing the amount of interpolation.
     */
    fun lerp(to: Vector2, weight: RealT) = Vector2(
        x + (weight * (to.x - x)),
        y + (weight * (to.y - y))
    )

    /**
     * Returns the vector with a maximum length by limiting its length to length.
     */
    fun limitLength(length: RealT = 1.0): Vector2 {
        val l = length()
        var v = Vector2(this)
        if (l > 0 && length < l) {
            v /= l
            v *= length
        }

        return v
    }

    /**
     * Returns the component-wise maximum of this and with, equivalent to `Vector2(maxf(x, with.x), maxf(y, with.y))`.
     */
    fun max(with: Vector2) = Vector2(if (x > with.x) x else with.x, if (y > with.y) y else with.y)

    /**
     * Returns the axis of the vector's highest value. See AXIS_* constants. If all components are equal,
     * this method returns AXIS_X.
     */
    fun maxAxisIndex() = if (x < y) Axis.Y else Axis.X

    /**
     * Returns the component-wise maximum of this and with, equivalent to `Vector2(maxf(x, with), maxf(y, with))`.
     */
    fun maxf(with: RealT) = Vector2(if (x > with) x else with, if (y > with) y else with)

    /**
     * Returns the component-wise minimum of this and with, equivalent to `Vector2(minf(x, with.x), minf(y, with.y))`.
     */
    fun min(with: Vector2) = Vector2(if (x < with.x) x else with.x, if (y < with.y) y else with.y)

    /**
     * Returns the axis of the vector's lowest value. See AXIS_* constants. If all components are equal,
     * this method returns AXIS_Y.
     */
    fun minAxisIndex() = if (x < y) Axis.X else Axis.Y

    /**
     * Returns the component-wise minimum of this and with, equivalent to `Vector2(minf(x, with), minf(y, with))`.
     */
    fun minf(with: RealT) = Vector2(if (x < with) x else with, if (y < with) y else with)

    /**
     * Moves the vector toward to by the fixed delta amount.
     */
    fun moveToward(to: Vector2, delta: RealT): Vector2 {
        val vd = to - this
        val len = vd.length()
        return if (len <= delta || len < CMP_EPSILON)
            Vector2(to)
        else
            this + vd / len * delta
    }

    /**
     * Returns the vector scaled to unit length. Equivalent to v / v.length().
     */
    fun normalized(): Vector2 {
        val v = Vector2(this)

        v.normalize()
        return v
    }

    internal fun normalize() {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isFinite()) {
                GodotLogging.warning("Vector2 cannot be normalized, the elements must be finite. Making (0, 0) as a fallback.")
                x = 0.0
                y = 0.0
                return
            }
        }

        val l  = lengthSquared()
        if (l == 0.0) {
            x = 0.0
            y = 0.0
        } else {
            val length = sqrt(l)
            x /= length
            y /= length
        }
    }

    /**
     * Returns a perpendicular vector rotated 90 degrees counter-clockwise compared to the original,
     * with the same length.
     */
    fun orthogonal() = Vector2(y, -x)

    /**
     * Returns a vector composed of the fposmod of this vector’s components and mod.
     */
    fun posmod(mod: RealT): Vector2 {
        return Vector2(x.fposmod(mod), y.fposmod(mod))
    }

    /**
     * Returns a vector composed of the fposmod of this vector’s components and modv’s components.
     */
    fun posmodv(modv: Vector2): Vector2 {
        return Vector2(x.fposmod(modv.x), y.fposmod(modv.y))
    }

    /**
     * Returns the vector projected onto the vector b.
     */
    fun project(to: Vector2): Vector2 {
        return to * (dot(to) / to.lengthSquared());
    }

    /**
     * Returns the vector reflected from a plane defined by the given normal.
     */
    fun reflect(normal: Vector2): Vector2 {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!normal.isNormalized()) {
                GodotLogging.error("The normal Vector2 $normal must be normalized.")
                return Vector2()
            }
        }
        return 2.0 * normal * dot(normal) - this;
    }

    /**
     * Returns the vector rotated by phi radians.
     */
    fun rotated(by: RealT): Vector2 {
        val sine = sin(by)
        val cosi = cos(by)
        return Vector2(x * cosi - y * sine, x * sine + y * cosi)
    }

    /**
     * Returns the result of rotating this vector toward [to], by increment [delta] (in radians).
     * Passing a negative [delta] will rotate away from [to].
     * This method supports vectors of different length, with the same behavior as [slerp].
     * If the vectors are colinear, this method behaves like [moveToward]. If [to] has a length of zero, this method behaves like [lerp].
     */
    fun rotateToward(to: Vector2, delta: RealT): Vector2 {
        val angle = abs(angleTo(to))

        if (delta >= 0.0 && angle <= delta) {
            if (to.lengthSquared().isZeroApprox()) {
                return lerp(to, delta)
            }
            return moveToward(to, delta * to.length())
        }

        if (angle == 0.0) {
            return Vector2(this)
        }

        return slerp(to, delta / angle)
    }

    /**
     * Returns the vector with all components rounded to the nearest integer, with halfway cases rounded away from zero.
     */
    fun round(): Vector2 {
        return Vector2(roundValue(x), roundValue(y))
    }

    /**
     * Returns the vector with each component set to one or negative one, depending on the signs of the components.
     */
    fun sign(): Vector2 {
        return Vector2(sign(x), sign(y))
    }

    /**
     * Returns the result of spherical linear interpolation between this vector and to, by amount weight. weight is on the range of 0.0 to 1.0, representing the amount of interpolation.
     *
     * This method also handles interpolating the lengths if the input vectors have different lengths. For the special case of one or both input vectors having zero length, this method behaves like lerp.
     */
    fun slerp(to: Vector2, weight: RealT): Vector2 {
        val startLengthSq = lengthSquared()
        val endLengthSq = to.lengthSquared()

        if (startLengthSq == 0.0 || endLengthSq == 0.0) {
            // Zero length vectors have no angle, so the best we can do is either lerp or throw an error.
            return lerp(to, weight)
        }

        val startLength = sqrt(startLengthSq)
        val resultLength = lerp(startLength, sqrt(endLengthSq), weight)
        val angle = angleTo(to)

        return rotated(angle * weight) * (resultLength / startLength)
    }

    /**
     * Returns the component of the vector along a plane defined by the given normal.
     */
    fun slide(normal: Vector2): Vector2 {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!normal.isNormalized()) {
                GodotLogging.error("The normal Vector2 $normal must be normalized.")
                return Vector2()
            }
        }
        return this - normal * dot(normal);
    }

    /**
     * Returns a new vector with each component snapped to the closest multiple of the corresponding component in [step].
     */
    fun snapped(step: Vector2): Vector2 {
        val v = Vector2(this)
        v.snap(step)
        return v
    }


    internal fun snap(by: Vector2) {
        x = snapped(x, by.x)
        y = snapped(y, by.y)
    }

    /**
     * Returns a new vector with each component snapped to the nearest multiple of step.
     * This can also be used to round the components to an arbitrary number of decimals.
     */
    fun snappedf(step: RealT) = Vector2(snapped(x, step), snapped(y, step))

    operator fun get(idx: Int): RealT = when (idx) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(n: Int, f: RealT) = when (n) {
        0 -> x = f
        1 -> y = f
        else -> throw IndexOutOfBoundsException()
    }

    operator fun get(axis: Axis): RealT = when (axis) {
        Axis.X -> x
        Axis.Y -> y
    }

    operator fun set(axis: Axis, f: RealT) = when (axis) {
        Axis.X -> x = f
        Axis.Y -> y = f
    }

    operator fun plus(v: Vector2) = Vector2(x + v.x, y + v.y)
    operator fun plus(scalar: Int) = Vector2(x + scalar, y + scalar)
    operator fun plus(scalar: Long) = Vector2(x + scalar, y + scalar)
    operator fun plus(scalar: Float) = Vector2(x + scalar, y + scalar)
    operator fun plus(scalar: Double) = Vector2(x + scalar, y + scalar)

    operator fun minus(v: Vector2) = Vector2(x - v.x, y - v.y)
    operator fun minus(scalar: Int) = Vector2(x - scalar, y - scalar)
    operator fun minus(scalar: Long) = Vector2(x - scalar, y - scalar)
    operator fun minus(scalar: Float) = Vector2(x - scalar, y - scalar)
    operator fun minus(scalar: Double) = Vector2(x - scalar, y - scalar)

    operator fun times(v1: Vector2) = Vector2(x * v1.x, y * v1.y)
    operator fun times(scalar: Int) = Vector2(x * scalar, y * scalar)
    operator fun times(scalar: Long) = Vector2(x * scalar, y * scalar)
    operator fun times(scalar: Float) = Vector2(x * scalar, y * scalar)
    operator fun times(scalar: Double) = Vector2(x * scalar, y * scalar)

    operator fun div(v1: Vector2) = Vector2(x / v1.x, y / v1.y)
    operator fun div(scalar: Int) = Vector2(x / scalar, y / scalar)
    operator fun div(scalar: Long) = Vector2(x / scalar, y / scalar)
    operator fun div(scalar: Float) = Vector2(x / scalar, y / scalar)
    operator fun div(scalar: Double) = Vector2(x / scalar, y / scalar)

    operator fun unaryPlus() = Vector2(this)
    operator fun unaryMinus() = Vector2(-x, -y)

    fun toVector2i() = Vector2i(x.toInt(), y.toInt())

    override fun equals(other: Any?): Boolean = when (other) {
        is Vector2 -> x == other.x && y == other.y
        else -> false
    }

    override fun compareTo(other: Vector2): Int =
        if (x == other.x) {
            when {
                y < other.y -> -1
                y == other.y -> 0
                else -> 1
            }
        } else {
            if (x < other.x) -1 else 1
        }

    override fun hashCode(): Int {
        var result = (x + 0.0).hashCode()
        result = 31 * result + (y + 0.0).hashCode()
        return result
    }

    override fun toString(): String {
        return "($x, $y)"
    }
}

operator fun Int.plus(vec: Vector2) = vec + this
operator fun Long.plus(vec: Vector2) = vec + this
operator fun Float.plus(vec: Vector2) = vec + this
operator fun Double.plus(vec: Vector2) = vec + this

operator fun Int.minus(vec: Vector2) = Vector2(this - vec.x, this - vec.y)
operator fun Long.minus(vec: Vector2) = Vector2(this - vec.x, this - vec.y)
operator fun Float.minus(vec: Vector2) = Vector2(this - vec.x, this - vec.y)
operator fun Double.minus(vec: Vector2) = Vector2(this - vec.x, this - vec.y)

operator fun Int.times(vec: Vector2) = vec * this
operator fun Long.times(vec: Vector2) = vec * this
operator fun Float.times(vec: Vector2) = vec * this
operator fun Double.times(vec: Vector2) = vec * this
