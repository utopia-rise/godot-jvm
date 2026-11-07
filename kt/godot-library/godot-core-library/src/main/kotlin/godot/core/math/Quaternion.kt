@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.core.EulerOrder
import godot.common.util.CMP_EPSILON
import godot.common.util.RealT
import godot.common.util.SHORTEST_ARC_DOT_THRESHOLD
import godot.common.util.UNIT_EPSILON
import godot.common.util.cubicInterpolate
import godot.common.util.cubicInterpolateInTime
import godot.common.util.isEqualApprox
import godot.common.util.isZeroApprox
import godot.common.util.signbit
import godot.common.util.toRealT
import godot.internal.logging.GodotLogging
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Quaternion(
    var x: RealT,
    var y: RealT,
    var z: RealT,
    var w: RealT
) : CoreType {

    //CONSTANTS
    companion object {
        val IDENTITY: Quaternion
            get() = Quaternion(0.0, 0.0, 0.0, 1.0)

        fun fromEuler(euler: Vector3): Quaternion {
            val halfA1 = euler.y * 0.5f
            val halfA2 = euler.x * 0.5f
            val halfA3 = euler.z * 0.5f

            // R = Y(a1).X(a2).Z(a3) convention for Euler angles.
            // Conversion to quaternion as listed in https://ntrs.nasa.gov/archive/nasa/casi.ntrs.nasa.gov/19770024290.pdf (page A-6)
            // a3 is the angle of the first rotation, following the notation in this reference.

            val cosA1 = cos(halfA1)
            val sinA1 = sin(halfA1)
            val cosA2 = cos(halfA2)
            val sinA2 = sin(halfA2)
            val cosA3 = cos(halfA3)
            val sinA3 = sin(halfA3)

            return Quaternion(
                sinA1 * cosA2 * sinA3 + cosA1 * sinA2 * cosA3,
                sinA1 * cosA2 * cosA3 - cosA1 * sinA2 * sinA3,
                -sinA1 * sinA2 * cosA3 + cosA1 * cosA2 * sinA3,
                sinA1 * sinA2 * sinA3 + cosA1 * cosA2 * cosA3
            )
        }
    }


    //CONSTRUCTOR
    constructor() :
        this(0.0, 0.0, 0.0, 1.0)

    constructor(other: Quaternion) : this(other.x, other.y, other.z, other.w)

    constructor(x: Number, y: Number, z: Number, w: Number = 1.0) :
        this(x.toRealT(), y.toRealT(), z.toRealT(), w.toRealT())

    constructor(axis: Vector3, angle: RealT) : this() {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!axis.isNormalized()) {
                GodotLogging.error("The axis Vector3 $axis must be normalized.")
                return
            }
        }

        val d: RealT = axis.length()
        if (d == 0.0) {
            set(0.0, 0.0, 0.0, 0.0)
        } else {
            val sinAngle: RealT = sin(angle * 0.5)
            val cosAngle: RealT = cos(angle * 0.5)
            val s: RealT = sinAngle / d
            set(axis.x * s, axis.y * s, axis.z * s, cosAngle)
        }
    }

    constructor(v0: Vector3, v1: Vector3) : this() {
        if (GodotJvmBuildConfig.DEBUG) {
            if (v0.isZeroApprox() || v1.isZeroApprox()) {
                GodotLogging.error("The vectors must not be zero.")
                return
            }
        }

        val n0 = v0.normalized();
        val n1 = v1.normalized();
        val d = n0.dot(n1);

        if (abs(d) > SHORTEST_ARC_DOT_THRESHOLD) {
            if (d >= 0) {
                return // Vectors are same.
            }
            val axis = n0.getAnyPerpendicular();
            x = axis.x;
            y = axis.y;
            z = axis.z;
            w = 0.0;
        } else {
            val c = n0.cross(n1);
            val s = sqrt((1.0 + d) * 2.0)
            val rs = 1.0 / s
            x = c.x * rs
            y = c.y * rs
            z = c.z * rs
            w = s * 0.5
        }
        normalize()
    }

    //API

    /**
     * Returns the angle between this quaternion and [to]. This is the magnitude of the angle you would need to rotate by
     * to get from one to the other.
     *
     * Note: The magnitude of the floating-point error for this method is abnormally high, so methods such as
     * [isZeroApprox] will not work reliably.
     */
    fun angleTo(to: Quaternion): RealT {
        val d = dot(to)
        return acos((d * d * 2 - 1).coerceIn(-1.0, 1.0))
    }

    /**
     * Returns the dot product of two quaternions.5
     */
    fun dot(q: Quaternion): RealT {
        return x * q.x + y * q.y + z * q.z + w * q.w
    }

    fun exp(): Quaternion {
        var srcV = Vector3(x, y, z)
        val theta = srcV.length()
        srcV = srcV.normalized()
        if (theta < CMP_EPSILON || !srcV.isNormalized()) {
            return Quaternion(0, 0, 0, 1)
        }
        return Quaternion(srcV, theta)
    }

    fun getAngle() = 2 * acos(w.coerceIn(-1.0, 1.0))

    fun getAxis(): Vector3 {
        if (abs(w) > 1 - CMP_EPSILON) {
            return Vector3(x, y, z)
        }
        val r = 1 / sqrt(1 - w * w)
        return Vector3(x * r, y * r, z * r)
    }

    /**
     * Returns Euler angles (in the YXZ convention: first Z, then X, and Y last) corresponding to the rotation
     * represented by the unit quaternion. Returned vector contains the rotation angles in the format (X angle, Y angle,
     * Z angle).
     */
    fun getEuler(order: EulerOrder = EulerOrder.YXZ): Vector3 {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isNormalized()) {
                GodotLogging.error("The quaternion $this must be normalized.")
                return Vector3(0, 0, 0)
            }
        }
        return Basis(this).getEuler(order)
    }

    /**
     * Returns the inverse of the quaternion.
     */
    fun inverse(): Quaternion {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isNormalized()) {
                GodotLogging.error("The quaternion $this must be normalized.")
                return Quaternion()
            }
        }
        return Quaternion(-x, -y, -z, w)
    }

    /**
     * Returns true if this quaterion and quat are approximately equal, by running isEqualApprox on each component.
     */
    fun isEqualApprox(other: Quaternion): Boolean {
        return x.isEqualApprox(other.x)
            && y.isEqualApprox(other.y)
            && z.isEqualApprox(other.z)
            && w.isEqualApprox(other.w)
    }

    /**
     * Returns `true` if this quaternion is finite, by calling [Float.isFinite] on each component.
     */
    fun isFinite() = x.isFinite() && y.isFinite() && z.isFinite() && w.isFinite()

    /**
     * Returns whether the quaternion is normalized or not.
     */
    fun isNormalized(): Boolean {
        return lengthSquared().isEqualApprox(1.0, UNIT_EPSILON)
    }

    /**
     * Returns the length of the quaternion.
     */
    fun length(): RealT {
        return sqrt(this.lengthSquared())
    }

    /**
     * Returns the length of the quaternion, squared.
     */
    fun lengthSquared(): RealT {
        return dot(this)
    }

    fun log(): Quaternion {
        val srcV = getAxis() * getAngle()
        return Quaternion(srcV.x, srcV.y, srcV.z, 0)
    }

    /**
     * Returns a copy of the quaternion, normalized to unit length.
     */
    fun normalized(): Quaternion {
        return this / length()
    }

    internal fun normalize() {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isFinite()) {
                GodotLogging.warning("Quaternion cannot be normalized, the elements must be finite. Making (0, 0, 0, 1) as a fallback.")
                x = 0.0
                y = 0.0
                z = 0.0
                w = 1.0
                return
            }
        }

        val r = 1 / length()
        x *= r
        y *= r
        z *= r
        w *= r
    }

    /**
     * Returns the result of rotating toward [to] by [delta] (in radians). Passing a negative [delta] will rotate away from [to].
     *
     * **Note:** Both quaternions must be normalized.
     */
    fun rotateToward(to: Quaternion, delta: Double): Quaternion {
        val angle = angleTo(to)

        if (delta >= 0.0 && angle <= delta) {
            return Quaternion(to)
        }

        if (angle == 0.0) {
            return Quaternion(this)
        }

        return slerp(to, delta / angle)
    }

    /**
     * Sets the quaternion to a rotation which rotates around axis by the specified angle, in radians. The axis must be a normalized vector.
     */
    fun setAxisAndAngle(axis: Vector3, angle: RealT) {
        if (GodotJvmBuildConfig.DEBUG) {
            require(axis.isNormalized()) { "Axis must be normalized!" }
        }

        val d = axis.length()
        if (d.isEqualApprox(0.0)) {
            set(0.0, 0.0, 0.0, 0.0)
        } else {
            val sin = sin(angle * 0.5)
            val cos = cos(angle * 0.5)
            val s = sin / d
            set(axis.x * s, axis.y * s, axis.z * s, cos)
        }
    }

    /**
     * Performs a spherical-linear interpolation with another quaternion.
     */
    fun slerp(q: Quaternion, t: RealT): Quaternion {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isNormalized()) {
                GodotLogging.error("The start quaternion $this must be normalized.")
                return Quaternion()
            }
            if (!q.isNormalized()) {
                GodotLogging.error("The end quaternion $q must be normalized.")
                return Quaternion()
            }
        }
        val to1 = Quaternion()
        val omega: RealT
        var cosom: RealT
        val sinom: RealT
        val scale0: RealT
        val scale1: RealT

        cosom = dot(q)

        if (cosom < 0) {
            cosom = -cosom
            to1.x = -q.x
            to1.y = -q.y
            to1.z = -q.z
            to1.w = -q.w
        } else {
            to1.x = q.x
            to1.y = q.y
            to1.z = q.z
            to1.w = q.w
        }

        if ((1.0 - cosom) > CMP_EPSILON) {
            // standard case (slerp)
            omega = acos(cosom)
            sinom = sin(omega)
            scale0 = sin((1.0 - t) * omega) / sinom
            scale1 = sin(t * omega) / sinom
        } else {
            // "from" and "to" quaternions are very close
            //  ... so we can do a linear interpolation
            scale0 = 1.0 - t
            scale1 = t
        }
        // calculate final values
        return Quaternion(
            scale0 * x + scale1 * to1.x,
            scale0 * y + scale1 * to1.y,
            scale0 * z + scale1 * to1.z,
            scale0 * w + scale1 * to1.w
        )
    }

    /**
     * Performs a spherical-linear interpolation with another quaterion without checking if the rotation path is not bigger than 90°.
     */
    fun slerpni(q: Quaternion, t: RealT): Quaternion {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isNormalized()) {
                GodotLogging.error("The start quaternion $this must be normalized.")
                return Quaternion()
            }
            if (!q.isNormalized()) {
                GodotLogging.error("The end quaternion $q must be normalized.")
                return Quaternion()
            }
        }
        val from = this
        val dot: RealT = from.dot(q)

        if (abs(dot) > 0.9999f.toDouble()) return Quaternion(from)

        val theta = acos(dot)
        val sinT = 1.0 / sin(theta)
        val newFactor: RealT = sin(t * theta) * sinT
        val invFactor: RealT = sin((1.0 - t) * theta) * sinT

        return Quaternion(
            invFactor * from.x + newFactor * q.x,
            invFactor * from.y + newFactor * q.y,
            invFactor * from.z + newFactor * q.z,
            invFactor * from.w + newFactor * q.w
        )
    }

    /**
     * Performs a spherical cubic interpolation between quaternions [preA], this vector, [b], and [postB], by the given
     * amount [weight].
     */
    fun sphericalCubicInterpolate(b: Quaternion, preA: Quaternion, postB: Quaternion, weight: RealT): Quaternion {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isNormalized()) {
                GodotLogging.error("The start quaternion $this must be normalized.")
                return Quaternion()
            }
            if (!b.isNormalized()) {
                GodotLogging.error("The end quaternion $b must be normalized.")
                return Quaternion()
            }
        }

        var fromQ = this
        var preQ = preA
        var toQ = b
        var postQ = postB

        // Align flip phases.
        fromQ = Basis(fromQ).getRotationQuaternion()
        preQ = Basis(preQ).getRotationQuaternion()
        toQ = Basis(toQ).getRotationQuaternion()
        postQ = Basis(postQ).getRotationQuaternion()

        // Flip quaternions to shortest path if necessary.
        val flip1 = fromQ.dot(preQ).signbit
        preQ = if (flip1) -preQ else preQ
        val flip2 = fromQ.dot(toQ).signbit
        toQ = if (flip2) -toQ else toQ
        val flip3 = if (flip2) toQ.dot(postQ) <= 0 else toQ.dot(postQ).signbit
        postQ = if (flip3) -postQ else postQ

        // Calc by Expmap in from_q space.
        var lnFrom = Quaternion(0, 0, 0, 0)
        var lnTo = (fromQ.inverse() * toQ).log()
        var lnPre = (fromQ.inverse() * preQ).log()
        var lnPost = (fromQ.inverse() * postQ).log()
        var ln = Quaternion(0, 0, 0, 0)

        ln.x = cubicInterpolate(lnFrom.x, lnTo.x, lnPre.x, lnPost.x, weight)
        ln.y = cubicInterpolate(lnFrom.y, lnTo.y, lnPre.y, lnPost.y, weight)
        ln.z = cubicInterpolate(lnFrom.z, lnTo.z, lnPre.z, lnPost.z, weight)
        val q1 = fromQ * ln.exp()

        // Calc by Expmap in to_q space.
        lnFrom = (toQ.inverse() * fromQ).log()
        lnTo = Quaternion(0, 0, 0, 0)
        lnPre = (toQ.inverse() * preQ).log()
        lnPost = (toQ.inverse() * postQ).log()
        ln = Quaternion(0, 0, 0, 0)
        ln.x = cubicInterpolate(lnFrom.x, lnTo.x, lnPre.x, lnPost.x, weight)
        ln.y = cubicInterpolate(lnFrom.y, lnTo.y, lnPre.y, lnPost.y, weight)
        ln.z = cubicInterpolate(lnFrom.z, lnTo.z, lnPre.z, lnPost.z, weight)
        val q2 = toQ * ln.exp()

        // To cancel error made by Expmap ambiguity, do blending.
        return q1.slerp(q2, weight)
    }

    /**
     * Performs a spherical cubic interpolation between quaternions pre_a, this vector, b, and post_b, by the given
     * amount weight.
     *
     * It can perform smoother interpolation than spherical_cubic_interpolate() by the time values.
     */
    fun sphericalCubicInterpolateInTime(
        p_b: Quaternion,
        p_pre_a: Quaternion,
        p_post_b: Quaternion,
        p_weight: RealT,
        p_b_t: RealT,
        p_pre_a_t: RealT,
        p_post_b_t: RealT
    ): Quaternion {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isNormalized()) {
                GodotLogging.error("The start quaternion $this must be normalized.")
                return Quaternion()
            }
            if (!p_b.isNormalized()) {
                GodotLogging.error("The end quaternion $p_b must be normalized.")
                return Quaternion()
            }
        }

        var from_q = this
        var pre_q = p_pre_a
        var to_q = p_b
        var post_q = p_post_b

        // Align flip phases.
        from_q = Basis(from_q).getRotationQuaternion()
        pre_q = Basis(pre_q).getRotationQuaternion()
        to_q = Basis(to_q).getRotationQuaternion()
        post_q = Basis(post_q).getRotationQuaternion()

        // Flip quaternions to shortest path if necessary.
        val flip1 = from_q.dot(pre_q).signbit
        pre_q = if (flip1) -pre_q else pre_q
        val flip2 = from_q.dot(to_q).signbit
        to_q = if (flip2) -to_q else to_q
        val flip3 = if (flip2) to_q.dot(post_q) <= 0 else to_q.dot(post_q).signbit
        post_q = if (flip3) -post_q else post_q

        // Calc by Expmap in from_q space.
        var ln_from = Quaternion(0, 0, 0, 0)
        var ln_to = (from_q.inverse() * to_q).log()
        var ln_pre = (from_q.inverse() * pre_q).log()
        var ln_post = (from_q.inverse() * post_q).log()
        var ln = Quaternion(0, 0, 0, 0)
        ln.x = cubicInterpolateInTime(ln_from.x, ln_to.x, ln_pre.x, ln_post.x, p_weight, p_b_t, p_pre_a_t, p_post_b_t)
        ln.y = cubicInterpolateInTime(ln_from.y, ln_to.y, ln_pre.y, ln_post.y, p_weight, p_b_t, p_pre_a_t, p_post_b_t)
        ln.z = cubicInterpolateInTime(ln_from.z, ln_to.z, ln_pre.z, ln_post.z, p_weight, p_b_t, p_pre_a_t, p_post_b_t)
        val q1 = from_q * ln.exp()

        // Calc by Expmap in to_q space.
        ln_from = (to_q.inverse() * from_q).log()
        ln_to = Quaternion(0, 0, 0, 0)
        ln_pre = (to_q.inverse() * pre_q).log()
        ln_post = (to_q.inverse() * post_q).log()
        ln = Quaternion(0, 0, 0, 0)
        ln.x = cubicInterpolateInTime(ln_from.x, ln_to.x, ln_pre.x, ln_post.x, p_weight, p_b_t, p_pre_a_t, p_post_b_t)
        ln.y = cubicInterpolateInTime(ln_from.y, ln_to.y, ln_pre.y, ln_post.y, p_weight, p_b_t, p_pre_a_t, p_post_b_t)
        ln.z = cubicInterpolateInTime(ln_from.z, ln_to.z, ln_pre.z, ln_post.z, p_weight, p_b_t, p_pre_a_t, p_post_b_t)
        val q2 = to_q * ln.exp()

        // To cancel error made by Expmap ambiguity, do blending.
        return q1.slerp(q2, p_weight);
    }

    fun set(px: RealT, py: RealT, pz: RealT, pw: RealT) {
        x = px
        y = py
        z = pz
        w = pw
    }

    internal fun xform(v: Vector3): Vector3 {
        if (GodotJvmBuildConfig.DEBUG) {
            if (!isNormalized()) {
                GodotLogging.error("The quaternion $this must be normalized.")
                return v
            }
        }

        val u = Vector3(x, y, z)
        val uv = u.cross(v)

        return v + (uv * w + u.cross(uv)) * 2.0f
    }

    internal fun xformInv(v: Vector3): Vector3 {
        return inverse().xform(v)
    }

    operator fun plus(q2: Quaternion) = Quaternion(this.x + q2.x, this.y + q2.y, this.z + q2.z, this.w + q2.w)

    operator fun minus(q2: Quaternion) = Quaternion(this.x - q2.x, this.y - q2.y, this.z - q2.z, this.w - q2.w)

    operator fun times(v: Vector3) = xform(v)
    operator fun times(q2: Quaternion): Quaternion {
        val xx = w * q2.x + x * q2.w + y * q2.z - z * q2.y
        val yy = w * q2.y + y * q2.w + z * q2.x - x * q2.z
        val zz = w * q2.z + z * q2.w + x * q2.y - y * q2.x
        val ww = w * q2.w - x * q2.x - y * q2.y - z * q2.z
        return Quaternion(xx, yy, zz, ww)
    }

    operator fun times(scalar: Int) = Quaternion(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun times(scalar: Long) = Quaternion(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun times(scalar: Float) = Quaternion(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun times(scalar: Double) = Quaternion(x * scalar, y * scalar, z * scalar, w * scalar)

    operator fun div(f: RealT): Quaternion {
        val r = 1 / f
        return Quaternion(x * r, y * r, z * r, w * r)
    }

    operator fun div(f: Int) = div(f.toRealT())

    operator fun unaryPlus() = Quaternion(this)

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

    operator fun unaryMinus() = Quaternion(-this.x, -this.y, -this.z, -this.w)

    override fun equals(other: Any?): Boolean = when (other) {
        is Quaternion -> (x == other.x && y == other.y && z == other.z && w == other.w)
        else -> false
    }

    override fun toString(): String {
        return "($x, $y, $z, $w)"
    }

    override fun hashCode(): Int {
        var result = (x + 0.0).hashCode()
        result = 31 * result + (y + 0.0).hashCode()
        result = 31 * result + (z + 0.0).hashCode()
        result = 31 * result + (w + 0.0).hashCode()
        return result
    }

    /*
     * GDScript related members
     */
    constructor(from: Basis) : this() {
        from.getQuaternion().also {
            set(it.x, it.y, it.z, it.w)
        }
    }
}

operator fun Int.times(quaternion: Quaternion) = quaternion * this
operator fun Long.times(quaternion: Quaternion) = quaternion * this
operator fun Float.times(quaternion: Quaternion) = quaternion * this
operator fun Double.times(quaternion: Quaternion) = quaternion * this
operator fun Vector3.times(quaternion: Quaternion) = quaternion.xformInv(this)
