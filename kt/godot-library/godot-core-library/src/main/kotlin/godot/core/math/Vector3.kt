@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.common.util.CMP_EPSILON
import godot.common.util.UNIT_EPSILON
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
import godot.internal.logging.GodotLogging
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt
import kotlin.math.truncate
import kotlin.math.sign
import godot.common.util.clampValue

private fun roundHalfAwayFromZero(value: RealT): RealT {
    val truncated = truncate(value)
    return if (abs(value - truncated) >= 0.5) truncated + sign(value) else truncated
}

class Vector3(
    var x: RealT,
    var y: RealT,
    var z: RealT
) : Comparable<Vector3>, CoreType {

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
                else -> throw AssertionError("Unknown axis for Vector3: $value")
            }
        }
    }

    companion object {
        val ZERO: Vector3
            get() = Vector3(0, 0, 0)
        val ONE: Vector3
            get() = Vector3(1, 1, 1)
        val INF: Vector3
            get() = Vector3(RealT.POSITIVE_INFINITY, RealT.POSITIVE_INFINITY, RealT.POSITIVE_INFINITY)
        val LEFT: Vector3
            get() = Vector3(-1, 0, 0)
        val RIGHT: Vector3
            get() = Vector3(1, 0, 0)
        val UP: Vector3
            get() = Vector3(0, 1, 0)
        val DOWN: Vector3
            get() = Vector3(0, -1, 0)
        val FORWARD: Vector3
            get() = Vector3(0, 0, -1)
        val BACK: Vector3
            get() = Vector3(0, 0, 1)
        val MODEL_LEFT: Vector3
            get() = Vector3(1, 0, 0)
        val MODEL_RIGHT: Vector3
            get() = Vector3(-1, 0, 0)
        val MODEL_TOP: Vector3
            get() = Vector3(0, 1, 0)
        val MODEL_BOTTOM: Vector3
            get() = Vector3(0, -1, 0)
        val MODEL_FRONT: Vector3
            get() = Vector3(0, 0, 1)
        val MODEL_REAR: Vector3
            get() = Vector3(0, 0, -1)

        fun octahedronDecode(uv: Vector2): Vector3 {
            val f = Vector2(uv.x * 2.0f - 1.0f, uv.y * 2.0f - 1.0f)
            val n = Vector3(f.x, f.y, 1.0f - abs(f.x) - abs(f.y))
            val t = clampValue(-n.z, 0.0, 1.0)
            n.x += if (n.x >= 0) -t else t
            n.y += if (n.y >= 0) -t else t
            return n.normalized()
        }
    }


    //CONSTRUCTOR
    constructor() :
        this(0.0, 0.0, 0.0)

    constructor(vec: Vector3) :
        this(vec.x, vec.y, vec.z)

    constructor(other: Vector3i) : this(other.x, other.y, other.z)

    constructor(x: Number, y: Number, z: Number) :
        this(x.toRealT(), y.toRealT(), z.toRealT())

    //API

    /**
     * Returns a new vector with all components in absolute values (i.e. positive).
     */
    fun abs(): Vector3 {
        return Vector3(abs(x), abs(y), abs(z))
    }

    /**
     * Returns the minimum angle to the given vector.
     */
    fun angleTo(to: Vector3): RealT {
        return atan2(cross(to).length(), dot(to))
    }

    /**
     * Returns the derivative at the given [t] on the Bézier curve defined by this vector and the given [control1],
     * [control2], and [end] points.
     */
    fun bezierDerivative(
        control1: Vector3,
        control2: Vector3,
        end: Vector3,
        t: RealT
    ) = Vector3(
        bezierDerivative(this.x, control1.x, control2.x, end.x, t),
        bezierDerivative(this.y, control1.y, control2.y, end.y, t),
        bezierDerivative(this.z, control1.z, control2.z, end.z, t)
    )

    /**
     * Returns the point at the given [t] on the Bézier curve defined by this vector and the given [control1],
     * [control2], and [end] points.
     */
    fun bezierInterpolate(
        control1: Vector3,
        control2: Vector3,
        end: Vector3,
        t: RealT
    ) = Vector3(
        bezierInterpolate(this.x, control1.x, control2.x, end.x, t),
        bezierInterpolate(this.y, control1.y, control2.y, end.y, t),
        bezierInterpolate(this.z, control1.z, control2.z, end.z, t)
    )

    /**
     * Returns the vector “bounced off” from a plane defined by the given normal.
     */
    fun bounce(n: Vector3): Vector3 {
        return -reflect(n)
    }

    /**
     * Returns a new vector with all components rounded up.
     */
    fun ceil(): Vector3 {
        return Vector3(ceil(x), ceil(y), ceil(z))
    }

    /**
     * Returns a new vector with all components clamped between the components of min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clamp(min: Vector3, max: Vector3) = Vector3(
        clampValue(x, min.x, max.x),
        clampValue(y, min.y, max.y),
        clampValue(z, min.z, max.z)
    )

    /**
     * Returns a new vector with all components clamped between the min and max, by running
     * @GlobalScope.clamp on each component.
     */
    fun clampf(min: RealT, max: RealT) = Vector3(clampValue(x, min, max), clampValue(y, min, max), clampValue(z, min, max))

    /**
     * Returns the cross product with b.
     */
    fun cross(b: Vector3): Vector3 {
        return Vector3((y * b.z) - (z * b.y), (z * b.x) - (x * b.z), (x * b.y) - (y * b.x))
    }

    /**
     * Performs a cubic interpolation between vectors pre_a, a, b, post_b (a is current), by the given amount t.
     * t is in the range of 0.0 - 1.0, representing the amount of interpolation.
     */
    fun cubicInterpolate(b: Vector3, pre: Vector3, post: Vector3, t: RealT): Vector3 {
        val p0: Vector3 = pre
        val p1: Vector3 = this
        val p2: Vector3 = b
        val p3: Vector3 = post

        val t2 = t * t
        val t3 = t2 * t

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
        b: Vector3,
        preA: Vector3,
        postB: Vector3,
        weight: RealT,
        bT: RealT,
        preAT: RealT,
        postBT: RealT
    ) = Vector3(this).also {
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
    }

    /**
     * Returns the normalized vector pointing from this vector to b.
     */
    fun directionTo(other: Vector3): Vector3 {
        val ret = Vector3(other.x - x, other.y - y, other.z - z)
        ret.normalize()
        return ret
    }

    /**
     * Returns the squared distance to b.
     * Prefer this function over distance_to if you need to sort vectors or need the squared distance for some formula.
     */
    fun distanceSquaredTo(other: Vector3): RealT {
        return (other - this).lengthSquared()
    }

    /**
     * Returns the distance to b.
     */
    fun distanceTo(other: Vector3): RealT {
        return (other - this).length()
    }

    /**
     * Returns the dot product with b.
     */
    fun dot(b: Vector3): RealT {
        return x * b.x + y * b.y + z * b.z
    }

    /**
     * Returns a new vector with all components rounded down.
     */
    fun floor(): Vector3 {
        return Vector3(floor(x), floor(y), floor(z))
    }

    internal fun getAnyPerpendicular(): Vector3 {
        // Return any perpendicular vector by cross product with the Vector3.RIGHT or Vector3.UP,
        // whichever has the greater angle to the current vector with the sign of each element positive.
        // The only essence is "to avoid being parallel to the current vector", and there is no mathematical basis for using Vector3.RIGHT and Vector3.UP,
        // since it could be a different vector depending on the prior branching code Math::abs(x) <= Math::abs(y) && Math::abs(x) <= Math::abs(z).
        // However, it would be reasonable to use any of the axes of the basis, as it is simpler to calculate.
        if (GodotJvmBuildConfig.DEBUG) {
            if (isZeroApprox()) {
                GodotLogging.error("The Vector3 must not be zero.")
                return Vector3(0.0, 0.0, 0.0)
            }
        }

        return cross(
            if (abs(x) <= abs(y) && abs(x) <= abs(z)) Vector3(1, 0, 0) else Vector3(0, 1, 0)
        ).normalized();
    }


    /**
     * Returns the inverse of the vector. This is the same as Vector3( 1.0 / v.x, 1.0 / v.y, 1.0 / v.z ).
     */
    fun inverse(): Vector3 {
        return Vector3(1.0 / x, 1.0 / y, 1.0 / z)
    }

    /**
     * Returns true if this vector and v are approximately equal, by running isEqualApprox on each component.
     */
    fun isEqualApprox(other: Vector3): Boolean {
        return x.isEqualApprox(other.x) && y.isEqualApprox(other.y) && z.isEqualApprox(other.z)
    }

    /**
     * Returns true if this vector's values are approximately zero
     */
    fun isZeroApprox() = abs(x) < CMP_EPSILON && abs(y) < CMP_EPSILON && abs(z) < CMP_EPSILON

    /**
     * Returns true if this vector is finite, by calling @GlobalScope.is_finite on each component.
     */
    fun isFinite() = x.isFinite() && y.isFinite() && z.isFinite()

    /**
     * Returns true if the vector is normalized.
     */
    fun isNormalized(): Boolean {
        return lengthSquared().isEqualApprox(1.0, UNIT_EPSILON)
    }

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
    fun lengthSquared(): RealT {
        return x * x + y * y + z * z
    }

    /**
     * Returns the result of the linear interpolation between this vector and to by amount weight. weight is on the
     * range of 0.0 to 1.0, representing the amount of interpolation.
     */
    fun lerp(to: Vector3, weight: RealT) = Vector3(
        x + (weight * (to.x - x)),
        y + (weight * (to.y - y)),
        z + (weight * (to.z - z))
    )

    /**
     * Returns the vector with a maximum length by limiting its length to length.
     */
    fun limitLength(length: RealT = 1.0): Vector3 {
        val l = length()
        var v = Vector3(this)
        if (l > 0 && length < l) {
            v /= l
            v *= length
        }

        return v
    }

    /**
     * Returns the component-wise maximum of this and with.
     */
    fun max(with: Vector3) = Vector3(maxOf(x, with.x), maxOf(y, with.y), maxOf(z, with.z))

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
     * Returns the component-wise maximum of this and with, equivalent to `Vector3(maxf(x, with.x), maxf(y, with.y), maxf(z, with.z)).`.
     */
    fun maxf(with: RealT) = Vector3(maxOf(x, with), maxOf(y, with), maxOf(z, with))

    /**
     * Returns the component-wise minimum of this and with, equivalent to `Vector3(maxf(x, with), maxf(y, with), maxf(z, with))`.
     */
    fun min(with: Vector3) = Vector3(minOf(x, with.x), minOf(y, with.y), minOf(z, with.z))

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
     * Returns the component-wise minimum of this and with, equivalent to `Vector3(minf(x, with.x), minf(y, with.y), minf(z, with.z))`.
     */
    fun minf(with: RealT) = Vector3(minOf(x, with), minOf(y, with), minOf(z, with))

    /**
     * Moves the vector toward to by the fixed delta amount.
     */
    fun moveToward(to: Vector3, delta: RealT): Vector3 {
        val vd = to - this
        val len = vd.length()
        return if (len <= delta || len < CMP_EPSILON) {
            Vector3(to)
        } else {
            this + vd / len * delta
        }
    }

    /**
     * Returns the vector scaled to unit length. Equivalent to v / v.length().
     */
    fun normalized(): Vector3 {
        val v = Vector3(this)
        v.normalize()
        return v
    }

    internal fun normalize() {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isFinite()) {
                GodotLogging.warning("Vector3 cannot be normalized, the elements must be finite. Making (0, 0, 0) as a fallback.")
                x = 0.0
                y = 0.0
                z = 0.0
                return
            }
        }

        val l = lengthSquared()
        if (l == 0.0) {
            x = 0.0
            y = 0.0
            z = 0.0
        } else {
            val length = sqrt(l)
            x /= length
            y /= length
            z /= length
        }
    }

    /**
     * Returns the Vector3 from an octahedral-compressed form created using [octahedronEncode] (stored as a Vector2).
     */
    fun octahedronDecode(uv: Vector2): Vector3 {
        val f = Vector2(uv.x * 2.0f - 1.0f, uv.y * 2.0f - 1.0f)
        val n = Vector3(f.x, f.y, 1.0f - abs(f.x) - abs(f.y))
        val t = clampValue(-n.z, 0.0, 1.0)
        n.x += (if (n.x >= 0) -t else t).toDouble()
        n.y += (if (n.y >= 0) -t else t).toDouble()
        return n.normalized()
    }

    fun octahedronEncode(): Vector2 {
        var n = Vector3(this)
        n /= abs(n.x) + abs(n.y) + abs(n.z)
        val o = Vector2()
        if (n.z >= 0.0f) {
            o.x = n.x
            o.y = n.y
        } else {
            o.x = (1.0f - abs(n.y)) * (if (n.x >= 0.0f) 1.0f else -1.0f)
            o.y = (1.0f - abs(n.x)) * (if (n.y >= 0.0f) 1.0f else -1.0f)
        }
        o.x = o.x * 0.5f + 0.5f
        o.y = o.y * 0.5f + 0.5f
        return o
    }

    /**
     * Returns the outer product with b.
     */
    fun outer(b: Vector3) = Basis(
        x * b.x, x * b.y, x * b.z,
        y * b.x, y * b.y, y * b.z,
        z * b.x, z * b.y, z * b.z
    )

    /**
     * Returns a vector composed of the fposmod of this vector’s components and mod.
     */
    fun posmod(mod: RealT): Vector3 {
        return Vector3(x.fposmod(mod), y.fposmod(mod), z.fposmod(mod))
    }

    /**
     * Returns a vector composed of the fposmod of this vector’s components and modv’s components.
     */
    fun posmodv(modv: Vector3): Vector3 {
        return Vector3(x.fposmod(modv.x), y.fposmod(modv.y), z.fposmod(modv.z))
    }

    /**
     * Returns the vector projected onto the vector b.
     */
    fun project(to: Vector3): Vector3 {
        return to * (dot(to) / to.lengthSquared());
    }

    /**
     * Returns the vector reflected from a plane defined by the given normal.
     */
    fun reflect(normal: Vector3): Vector3 {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!normal.isNormalized()) {
                GodotLogging.error("The normal Vector3 $normal must be normalized.")
                return Vector3()
            }
        }
        return 2.0 * normal * this.dot(normal) - this
    }

    /**
     * Rotates the vector around a given axis by phi radians. The axis must be a normalized vector.
     */
    fun rotated(axis: Vector3, phi: RealT): Vector3 {
        val v = Vector3(this)
        v.rotate(axis, phi)
        return v
    }

    internal fun rotate(axis: Vector3, phi: RealT) {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!axis.isNormalized()) {
                GodotLogging.error("The axis Vector3 $axis must be normalized.")
                return
            }
        }
        val ret = Basis(axis, phi).xform(this)
        this.x = ret.x
        this.y = ret.y
        this.z = ret.z
    }

    /**
     * Returns the result of rotating this vector toward [to], by increment [delta] (in radians).
     * Passing a negative [delta] will rotate away from [to].
     * This method supports vectors of different length, with the same behavior as [slerp].
     * If the vectors are colinear, this method behaves like [moveToward]. If [to] has a length of zero, this method behaves like [lerp].
     */
    fun rotateToward(to: Vector3, delta: RealT): Vector3 {
        val angle = angleTo(to)

        if (delta >= 0.0 && angle <= delta) {
            if (to.lengthSquared().isZeroApprox()) {
                return lerp(to, delta)
            }
            return moveToward(to, delta * to.length())
        }

        if (angle == 0.0) {
            return Vector3(this)
        }

        return slerp(to, delta / angle)
    }

    /**
     * Returns the vector with all components rounded to the nearest integer, with halfway cases rounded away from zero.
     */
    fun round(): Vector3 {
        return Vector3(roundHalfAwayFromZero(x), roundHalfAwayFromZero(y), roundHalfAwayFromZero(z))
    }

    /**
     * Returns the vector with each component set to one or negative one, depending on the signs of the components.
     */
    fun sign(): Vector3 {
        return Vector3(sign(x), sign(y), sign(z))
    }

    /**
     * Returns the signed angle to the given vector, in radians. The sign of the angle is positive in a
     * counter-clockwise direction and negative in a clockwise direction when viewed from the side specified by the axis.
     */
    fun signedAngleTo(to: Vector3, axis: Vector3): RealT {
        val crossTo = cross(to)
        val unsignedAngle = atan2(crossTo.length(), dot(to))
        val sign = crossTo.dot(axis)
        return if (sign < 0) -unsignedAngle else unsignedAngle
    }

    /**
     * Returns the result of spherical linear interpolation between this vector and to, by amount weight. weight is on the range of 0.0 to 1.0, representing the amount of interpolation.
     *
     * This method also handles interpolating the lengths if the input vectors have different lengths. For the special case of one or both input vectors having zero length, this method behaves like lerp.
     */
    fun slerp(to: Vector3, weight: RealT): Vector3 {
        // This method seems more complicated than it really is, since we write out
        // the internals of some methods for efficiency (mainly, checking length).
        val startLengthSq = lengthSquared()
        val endLengthSq = to.lengthSquared()

        if (startLengthSq == 0.0 || endLengthSq == 0.0) {
            // Zero length vectors have no angle, so the best we can do is either lerp or throw an error.
            return lerp(to, weight)
        }

        var axis = cross(to)
        val axisLengthSq = axis.lengthSquared()

        if (axisLengthSq == 0.0) {
            // Colinear vectors have no rotation axis or angle between them, so the best we can do is lerp.
            return lerp(to, weight)
        }

        axis /= sqrt(axisLengthSq)
        val startLength = sqrt(startLengthSq)
        val resultLength = lerp(startLength, sqrt(endLengthSq), weight)
        val angle = angleTo(to)

        return rotated(axis, angle * weight) * (resultLength / startLength)
    }

    /**
     * Returns the component of the vector along a plane defined by the given normal.
     */
    fun slide(normal: Vector3): Vector3 {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!normal.isNormalized()) {
                GodotLogging.error("The normal Vector3 $normal must be normalized.")
                return Vector3()
            }
        }
        return this - normal * dot(normal);
    }

    /**
     * Returns a new vector with each component snapped to the closest multiple of the corresponding component in [step].
     */
    fun snapped(by: Vector3): Vector3 {
        val v = Vector3(this)
        v.snap(by)
        return v
    }

    internal fun snap(by: Vector3) {
        x = snapped(x, by.x)
        y = snapped(y, by.y)
        z = snapped(z, by.z)
    }

    /**
     * Returns a new vector with each component snapped to the nearest multiple of step.
     * This can also be used to round the components to an arbitrary number of decimals.
     */
    fun snappedf(step: RealT) = Vector3(snapped(x, step), snapped(y, step), snapped(z, step))

    fun toVector3i() = Vector3i(this)


    operator fun get(n: Int): RealT = when (n) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(n: Int, f: RealT): Unit = when (n) {
        0 -> x = f
        1 -> y = f
        2 -> z = f
        else -> throw IndexOutOfBoundsException()
    }

    operator fun get(axis: Axis): RealT = when (axis) {
        Axis.X -> x
        Axis.Y -> y
        Axis.Z -> z
    }

    operator fun set(axis: Axis, f: RealT) = when (axis) {
        Axis.X -> x = f
        Axis.Y -> y = f
        Axis.Z -> z = f
    }

    operator fun plus(vec: Vector3) = Vector3(x + vec.x, y + vec.y, z + vec.z)
    operator fun plus(scalar: Int) = Vector3(x + scalar, y + scalar, z + scalar)
    operator fun plus(scalar: Long) = Vector3(x + scalar, y + scalar, z + scalar)
    operator fun plus(scalar: Float) = Vector3(x + scalar, y + scalar, z + scalar)
    operator fun plus(scalar: Double) = Vector3(x + scalar, y + scalar, z + scalar)

    operator fun minus(vec: Vector3) = Vector3(x - vec.x, y - vec.y, z - vec.z)
    operator fun minus(scalar: Int) = Vector3(x - scalar, y - scalar, z - scalar)
    operator fun minus(scalar: Long) = Vector3(x - scalar, y - scalar, z - scalar)
    operator fun minus(scalar: Float) = Vector3(x - scalar, y - scalar, z - scalar)
    operator fun minus(scalar: Double) = Vector3(x - scalar, y - scalar, z - scalar)

    operator fun times(basis: Basis) = basis.xformInv(this)
    operator fun times(vec: Vector3) = Vector3(x * vec.x, y * vec.y, z * vec.z)
    operator fun times(scalar: Int) = Vector3(x * scalar, y * scalar, z * scalar)
    operator fun times(scalar: Long) = Vector3(x * scalar, y * scalar, z * scalar)
    operator fun times(scalar: Float) = Vector3(x * scalar, y * scalar, z * scalar)
    operator fun times(scalar: Double) = Vector3(x * scalar, y * scalar, z * scalar)

    operator fun div(vec: Vector3) = Vector3(x / vec.x, y / vec.y, z / vec.z)
    operator fun div(scalar: Int) = Vector3(x / scalar, y / scalar, z / scalar)
    operator fun div(scalar: Long) = Vector3(x / scalar, y / scalar, z / scalar)
    operator fun div(scalar: Float) = Vector3(x / scalar, y / scalar, z / scalar)
    operator fun div(scalar: Double) = Vector3(x / scalar, y / scalar, z / scalar)

    operator fun unaryPlus() = Vector3(this)
    operator fun unaryMinus() = Vector3(-x, -y, -z)

    override fun equals(other: Any?): Boolean = when (other) {
        is Vector3 -> (x == other.x && y == other.y && z == other.z)
        else -> false
    }

    override fun compareTo(other: Vector3): Int {
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
        var h = (x + 0.0).hashCode()
        h = 31 * h + (y + 0.0).hashCode()
        h = 31 * h + (z + 0.0).hashCode()
        return h
    }
}

operator fun Int.plus(vec: Vector3) = vec + this
operator fun Long.plus(vec: Vector3) = vec + this
operator fun Float.plus(vec: Vector3) = vec + this
operator fun Double.plus(vec: Vector3) = vec + this

operator fun Int.minus(vec: Vector3) = Vector3(this - vec.x, this - vec.y, this - vec.z)
operator fun Long.minus(vec: Vector3) = Vector3(this - vec.x, this - vec.y, this - vec.z)
operator fun Float.minus(vec: Vector3) = Vector3(this - vec.x, this - vec.y, this - vec.z)
operator fun Double.minus(vec: Vector3) = Vector3(this - vec.x, this - vec.y, this - vec.z)

operator fun Int.times(vec: Vector3) = vec * this
operator fun Long.times(vec: Vector3) = vec * this
operator fun Float.times(vec: Vector3) = vec * this
operator fun Double.times(vec: Vector3) = vec * this
