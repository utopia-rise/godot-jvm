@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.annotation.CoreTypeLocalCopy
import godot.common.util.CMP_EPSILON
import godot.common.util.RealT
import godot.common.util.UNIT_EPSILON
import godot.common.util.isEqualApprox
import godot.common.util.isZeroApprox
import godot.common.util.lerp
import godot.common.util.toRealT
import godot.internal.logging.GodotLogging
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

// This epsilon value results in angles within a +/- 0.04 degree range being simplified/truncated.
// Based on testing, this is the largest the epsilon can be without the angle truncation becoming
// visually noticeable.
private const val ANGLE_EPSILON = 0.00000025

class Basis() : CoreType {
    @PublishedApi
    internal var _x = Vector3()

    @PublishedApi
    internal var _y = Vector3()

    @PublishedApi
    internal var _z = Vector3()

    init {
        _x.x = 1.0
        _x.y = 0.0
        _x.z = 0.0
        _y.x = 0.0
        _y.y = 1.0
        _y.z = 0.0
        _z.x = 0.0
        _z.y = 0.0
        _z.z = 1.0
    }

    //CONSTANTS
    companion object {
        val IDENTITY: Basis
            get() = Basis(1, 0, 0, 0, 1, 0, 0, 0, 1)
        val FLIP_X: Basis
            get() = Basis(-1, 0, 0, 0, 1, 0, 0, 0, 1)
        val FLIP_Y: Basis
            get() = Basis(1, 0, 0, 0, -1, 0, 0, 0, 1)
        val FLIP_Z: Basis
            get() = Basis(1, 0, 0, 0, 1, 0, 0, 0, -1)

        //used internally by a few methods
        private val orthoBases: Array<Basis> =
            arrayOf(
                Basis(1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0),
                Basis(0.0, -1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0),
                Basis(-1.0, 0.0, 0.0, 0.0, -1.0, 0.0, 0.0, 0.0, 1.0),
                Basis(0.0, 1.0, 0.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0),
                Basis(1.0, 0.0, 0.0, 0.0, 0.0, -1.0, 0.0, 1.0, 0.0),
                Basis(0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0),
                Basis(-1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0),
                Basis(0.0, 0.0, -1.0, -1.0, 0.0, 0.0, 0.0, 1.0, 0.0),
                Basis(1.0, 0.0, 0.0, 0.0, -1.0, 0.0, 0.0, 0.0, -1.0),
                Basis(0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, -1.0),
                Basis(-1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, -1.0),
                Basis(0.0, -1.0, 0.0, -1.0, 0.0, 0.0, 0.0, 0.0, -1.0),
                Basis(1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0),
                Basis(0.0, 0.0, -1.0, 1.0, 0.0, 0.0, 0.0, -1.0, 0.0),
                Basis(-1.0, 0.0, 0.0, 0.0, 0.0, -1.0, 0.0, -1.0, 0.0),
                Basis(0.0, 0.0, 1.0, -1.0, 0.0, 0.0, 0.0, -1.0, 0.0),
                Basis(0.0, 0.0, 1.0, 0.0, 1.0, 0.0, -1.0, 0.0, 0.0),
                Basis(0.0, -1.0, 0.0, 0.0, 0.0, 1.0, -1.0, 0.0, 0.0),
                Basis(0.0, 0.0, -1.0, 0.0, -1.0, 0.0, -1.0, 0.0, 0.0),
                Basis(0.0, 1.0, 0.0, 0.0, 0.0, -1.0, -1.0, 0.0, 0.0),
                Basis(0.0, 0.0, 1.0, 0.0, -1.0, 0.0, 1.0, 0.0, 0.0),
                Basis(0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0),
                Basis(0.0, 0.0, -1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0),
                Basis(0.0, -1.0, 0.0, 0.0, 0.0, -1.0, 1.0, 0.0, 0.0)
            )

        /**
         * Constructs a pure rotation Basis matrix from Euler angles in the specified Euler rotation order. By default, use YXZ order (most common). See the EulerOrder enum for possible values.
         */
        fun fromEuler(euler: Vector3, order: EulerOrder = EulerOrder.YXZ) = Basis().also {
            it.setEuler(euler, order)
        }

        /**
         * Constructs a pure scale basis matrix with no rotation or shearing. The scale values are set as the diagonal of the matrix, and the other parts of the matrix are zero.
         */
        fun fromScale(scale: Vector3) = Basis(scale.x, 0, 0, 0, scale.y, 0, 0, 0, scale.z)

        /**
         * Creates a Basis with a rotation such that the forward axis (-Z) points towards the [target] position.
         *
         * 	The up axis (+Y) points as close to the [param up] vector as possible while staying perpendicular to the forward axis. The returned basis is orthonormalized (see [method orthonormalized]).
         * 	The [param target] and the [param up] cannot be [constant Vector3.ZERO], and shouldn't be colinear to avoid unintended rotation around local Z axis.
         *
         * If [useModelFront] is true, the +Z axis (asset front) is treated as forward (implies +X is left) and points toward the [target] position. By default, the -Z axis (camera forward) is treated as forward (implies +X is right).
         */
        fun lookingAt(target: Vector3, up: Vector3 = Vector3(0, 1, 0), useModelFront: Boolean = false): Basis {
            if (GodotJvmBuildConfig.DEBUG) {
                require(!target.isZeroApprox()) {
                    "The target vector can't be zero."
                }
                require(!up.isZeroApprox()) {
                    "The up vector can't be zero."
                }
            }
            val vZ: Vector3 = if (!useModelFront) {
                -target.normalized()
            } else {
                target.normalized()
            }

            var vX: Vector3 = up.cross(vZ)
            if (GodotJvmBuildConfig.DEBUG) {
                if (vX.isZeroApprox()) {
                    GodotLogging.warning("Target and up vectors are colinear. This is not advised as it may cause unwanted rotation around local Z axis.")
                    vX = up.getAnyPerpendicular(); // Vectors are almost parallel.
                }
            }

            vX.normalize()
            val vY = vZ.cross(vX)

            val basis = Basis()
            basis.setColumns(vX, vY, vZ)
            return basis
        }
    }


    //CONSTRUCTOR
    constructor(other: Basis) : this() {
        _x.x = other._x.x
        _x.y = other._x.y
        _x.z = other._x.z
        _y.x = other._y.x
        _y.y = other._y.y
        _y.z = other._y.z
        _z.x = other._z.x
        _z.y = other._z.y
        _z.z = other._z.z
    }

    constructor(
        xx: Number,
        xy: Number,
        xz: Number,
        yx: Number,
        yy: Number,
        yz: Number,
        zx: Number,
        zy: Number,
        zz: Number
    ) : this() {
        _x.x = xx.toRealT()
        _x.y = xy.toRealT()
        _x.z = xz.toRealT()
        _y.x = yx.toRealT()
        _y.y = yy.toRealT()
        _y.z = yz.toRealT()
        _z.x = zx.toRealT()
        _z.y = zy.toRealT()
        _z.z = zz.toRealT()
    }


    constructor(from: Vector3) : this() {
        setEuler(from)
    }

    constructor(quaternion: Quaternion) : this() {
        val d = quaternion.lengthSquared()
        val s = 2.0 / d
        val xs = quaternion.x * s
        val ys = quaternion.y * s
        val zs = quaternion.z * s
        val wx = quaternion.w * xs
        val wy = quaternion.w * ys
        val wz = quaternion.w * zs
        val xx = quaternion.x * xs
        val xy = quaternion.x * ys
        val xz = quaternion.x * zs
        val yy = quaternion.y * ys
        val yz = quaternion.y * zs
        val zz = quaternion.z * zs
        set(
            1.0 - (yy + zz), xy - wz, xz + wy,
            xy + wz, 1.0 - (xx + zz), yz - wx,
            xz - wy, yz + wx, 1.0 - (xx + yy)
        )
    }

    constructor(axis: Vector3, angle: RealT) : this() {
        // Rotation matrix from axis and angle, see https://en.wikipedia.org/wiki/Rotation_matrix#Rotation_matrix_from_axis_and_angle
        if (GodotJvmBuildConfig.DEBUG) {
            require(axis.isNormalized()) { "The axis Vector3 $axis must be normalized." }
        }

        val axiSq = Vector3(axis.x * axis.x, axis.y * axis.y, axis.z * axis.z)
        val cosine: RealT = cos(angle)
        _x.x = axiSq.x + cosine * (1.0f - axiSq.x)
        _y.y = axiSq.y + cosine * (1.0f - axiSq.y)
        _z.z = axiSq.z + cosine * (1.0f - axiSq.z)

        val sine: RealT = sin(angle)
        val t = 1.0 - cosine

        var xyzt = axis.x * axis.y * t
        var zyxs = axis.z * sine
        _x.y = xyzt - zyxs
        _y.x = xyzt + zyxs

        xyzt = axis.x * axis.z * t
        zyxs = axis.y * sine
        _x.z = xyzt + zyxs
        _z.x = xyzt - zyxs

        xyzt = axis.y * axis.z * t
        zyxs = axis.x * sine
        _y.z = xyzt - zyxs
        _z.y = xyzt + zyxs
    }

    //API
    /**
     * Returns the determinant of the matrix.
     */
    fun determinant(): RealT {
        return this._x.x * (this._y.y * this._z.z - this._z.y * this._y.z) -
            this._y.x * (this._x.y * this._z.z - this._z.y * this._x.z) +
            this._z.x * (this._x.y * this._y.z - this._y.y * this._x.z)
    }

    /**
     * Returns the basis's rotation in the form of Euler angles. The Euler order depends on the [order] parameter, by
     * default it uses the YXZ convention: when decomposing, first Z, then X, and Y last. The returned vector contains
     * the rotation angles in the format (X angle, Y angle, Z angle).
     *
     * Consider using the [getRotationQuaternion] method instead, which returns a [Quaternion] quaternion instead of
     * Euler angles.
     */
    fun getEuler(order: EulerOrder = EulerOrder.YXZ) = when (order) {
        EulerOrder.XYZ -> getEulerXyz()
        EulerOrder.XZY -> getEulerXzy()
        EulerOrder.YXZ -> getEulerYxz()
        EulerOrder.YZX -> getEulerYzx()
        EulerOrder.ZXY -> getEulerZxy()
        EulerOrder.ZYX -> getEulerZyx()
    }

    /**
     * getEulerXyz returns a vector containing the Euler angles in the format
     * (a1,a2,a3), where a3 is the angle of the first rotation, and a1 is the last
     * (following the convention they are commonly defined in the literature).
     *
     * The current implementation uses XYZ convention (Z is the first rotation),
     * so euler.z is the angle of the (first) rotation around Z axis and so on,
     *
     * And thus, assuming the matrix is a rotation matrix, this function returns
     * @return the angles in the decomposition R = X(a1).Y(a2).Z(a3) where Z(a) rotates
     */
    private fun getEulerXyz(): Vector3 {
        // Euler angles in XYZ convention.
        // See https://en.wikipedia.org/wiki/Euler_angles#Rotation_matrix
        //
        // rot =  cy*cz          -cy*sz           sy
        //        cz*sx*sy+cx*sz  cx*cz-sx*sy*sz -cy*sx
        //       -cx*cz*sy+sx*sz  cz*sx+cx*sy*sz  cx*cy
        val euler = Vector3()

        val sy = this._x.z
        if (sy < (1.0 - ANGLE_EPSILON)) {
            if (sy > -(1.0 - ANGLE_EPSILON)) {
                // is this a pure Y rotation?
                if (this._y.x == 0.0 && this._x.y == 0.0 && this._y.z == 0.0 && this._z.y == 0.0 && this._y.y == 1.0) {
                    // return the simplest form (human friendlier in editor and scripts)
                    euler.x = 0.0
                    euler.y = atan2(this._x.z, this._x.x)
                    euler.z = 0.0
                } else {
                    euler.x = atan2(-this._y.z, this._z.z)
                    euler.y = asin(sy)
                    euler.z = atan2(-this._x.y, this._x.x)
                }
            } else {
                euler.x = atan2(this._z.y, this._y.y)
                euler.y = (-PI).toRealT() / 2.0
                euler.z = 0.0
            }
        } else {
            euler.x = atan2(this._z.y, this._y.y)
            euler.y = PI.toRealT() / 2.0
            euler.z = 0.0
        }
        return euler
    }

    /**
     * Euler angles in XZY convention.
     * See https://en.wikipedia.org/wiki/Euler_angles#Rotation_matrix
     * rot =  cz*cy             -sz             cz*sy
     *        sx*sy+cx*cy*sz    cx*cz           cx*sz*sy-cy*sx
     *        cy*sx*sz          cz*sx           cx*cy+sx*sz*sy
     */
    private fun getEulerXzy(): Vector3 {
        val euler = Vector3()
        val sz = _x.y
        if (sz < (1.0f - ANGLE_EPSILON)) {
            if (sz > -(1.0f - ANGLE_EPSILON)) {
                euler.x = atan2(_z.y, _y.y)
                euler.y = atan2(_x.z, _x.x)
                euler.z = asin(-sz)
            } else {
                // It's -1
                euler.x = -atan2(_y.z, _z.z)
                euler.y = 0.0
                euler.z = Math.PI / 2.0f
            }
        } else {
            // It's 1
            euler.x = -atan2(_y.z, _z.z)
            euler.y = 0.0
            euler.z = -Math.PI / 2.0
        }
        return euler
    }

    /**
     * getEulerYxz returns a vector containing the Euler angles in the YXZ convention,
     * as in first-Z, then-X, last-Y. The angles for X, Y, and Z rotations are returned
     * as the x, y, and z components of a Vector3 respectively.
     */
    private fun getEulerYxz(): Vector3 {

        // Euler angles in YXZ convention.
        // See https://en.wikipedia.org/wiki/Euler_angles#Rotation_matrix
        //
        // rot =  cy*cz+sy*sx*sz    cz*sy*sx-cy*sz        cx*sy
        //        cx*sz             cx*cz                 -sx
        //        cy*sx*sz-cz*sy    cy*cz*sx+sy*sz        cy*cx

        val euler = Vector3()

        val m12 = this._y.z

        if (m12 < (1.0f - ANGLE_EPSILON)) {
            if (m12 > -(1.0f - ANGLE_EPSILON)) {
                // is this a pure X rotation?
                if (this._y.x == 0.0 && this._x.y == 0.0 && this._x.z == 0.0 && this._z.x == 0.0 && this._x.x == 1.0) {
                    // return the simplest form (human friendlier in editor and scripts)
                    euler.x = atan2(-m12, this._y.y)
                    euler.y = 0.0
                    euler.z = 0.0
                } else {
                    euler.x = asin(-m12)
                    euler.y = atan2(this._x.z, this._z.z)
                    euler.z = atan2(this._y.x, this._y.y)
                }
            } else { // m12 == -1
                euler.x = PI.toRealT() * 0.5
                euler.y = atan2(this._x.y, this._x.x)
                euler.z = 0.0
            }
        } else { // m12 == 1
            euler.x = (-PI).toRealT() * 0.5
            euler.y = -atan2(this._x.y, this._x.x)
            euler.z = 0.0
        }

        return euler
    }

    /**
     * Euler angles in YZX convention.
     * See https://en.wikipedia.org/wiki/Euler_angles#Rotation_matrix
     * rot =  cy*cz             sy*sx-cy*cx*sz     cx*sy+cy*sz*sx
     *        sz                cz*cx              -cz*sx
     *        -cz*sy            cy*sx+cx*sy*sz     cy*cx-sy*sz*sx
     */
    private fun getEulerYzx(): Vector3 {
        val euler = Vector3()
        val sz = _y.x
        if (sz < (1.0f - ANGLE_EPSILON)) {
            if (sz > -(1.0f - ANGLE_EPSILON)) {
                euler.x = atan2(-_y.z, _y.y)
                euler.y = atan2(-_z.x, _x.x)
                euler.z = asin(sz)
            } else {
                // It's -1
                euler.x = atan2(_z.y, _z.z)
                euler.y = 0.0
                euler.z = -Math.PI / 2.0
            }
        } else {
            // It's 1
            euler.x = atan2(_z.y, _z.z)
            euler.y = 0.0
            euler.z = Math.PI / 2.0
        }

        return euler
    }

    /**
     * Euler angles in ZXY convention.
     * See https://en.wikipedia.org/wiki/Euler_angles#Rotation_matrix
     * rot =  cz*cy-sz*sx*sy    -cx*sz                cz*sy+cy*sz*sx
     *        cy*sz+cz*sx*sy    cz*cx                 sz*sy-cz*cy*sx
     *        -cx*sy            sx                    cx*cy
     */
    private fun getEulerZxy(): Vector3 {
        val euler = Vector3()
        val sx = _z.y

        if (sx < 1.0f - ANGLE_EPSILON) {
            if (sx > -(1.0f - ANGLE_EPSILON)) {
                euler.x = asin(sx)
                euler.y = atan2(-_z.x, _z.z)
                euler.z = atan2(-_x.y, _y.y)
            } else {
                // It's -1
                euler.x = -Math.PI / 2.0f
                euler.y = atan2(_x.z, _x.x)
                euler.z = 0.0
            }
        } else {
            // It's 1
            euler.x = Math.PI / 2.0f
            euler.y = atan2(_x.z, _x.x)
            euler.z = 0.0
        }

        return euler
    }

    private fun getEulerZyx(): Vector3 {
        val euler = Vector3()
        val sy = _z.x

        if (sy < 1.0f - ANGLE_EPSILON) {
            if (sy > -(1.0f - ANGLE_EPSILON)) {
                euler.x = atan2(_z.y, _z.z)
                euler.y = asin(-sy)
                euler.z = atan2(_y.x, _x.x)
            } else {
                // It's -1
                euler.x = 0.0
                euler.y = Math.PI / 2.0f
                euler.z = -atan2(_x.y, _y.y)
            }
        } else {
            // It's 1
            euler.x = 0.0
            euler.y = -Math.PI / 2.0f
            euler.z = -atan2(_x.y, _y.y)
        }

        return euler
    }

    /**
     *Returns true if this basis is conformal.
     * A conformal basis is both orthogonal (the axes are perpendicular to each other) and uniform (the axes share the same length).
     * This method can be especially useful during physics calculations.
     */
    fun isConformal(): Boolean {
        val x = getColumn(0);
        val y = getColumn(1);
        val z = getColumn(2);
        val xLenSq = x.lengthSquared()
        return xLenSq.isEqualApprox(y.lengthSquared())
            && xLenSq.isEqualApprox(z.lengthSquared())
            && x.dot(y).isZeroApprox()
            && x.dot(z).isZeroApprox()
            && y.dot(z).isZeroApprox()
    }

    /**
     * Returns true if the basis vectors are orthogonal (perpendicular), so it has no skew or shear, and can be decomposed into rotation and scale.
     * See https://en.wikipedia.org/wiki/Orthogonal_basis
     */
    internal fun isOrthogonal(): Boolean {
        val x = getColumn(0);
        val y = getColumn(1);
        val z = getColumn(2);
        return x.dot(y).isZeroApprox()
            && x.dot(z).isZeroApprox()
            && y.dot(z).isZeroApprox()
    }

    /**
     * Returns true if the basis is a pure rotation matrix, so it has no scale, skew, shear, or flip.
     */
    internal fun isRotation(): Boolean =
        isConformal() && determinant().isEqualApprox(1.0, UNIT_EPSILON)

    /**
     * This function considers a discretization of rotations into 24 points on unit sphere,
     * lying along the vectors (x,y,z) with each component being either -1,0 or 1,
     * and returns the index of the point best representing the orientation of the object.
     * It is mainly used by the grid map editor. For further details, refer to Godot source code.
     */
    fun getOrthogonalIndex(): Int {
        val orth = this
        for (i in 0..2) {
            for (j in 0..2) {
                var v = orth._get(i)[j]
                v = when {
                    v > 0.5 -> 1.0
                    v < -0.5 -> -1.0
                    else -> 0.0
                }
                orth._get(i)[j] = v
            }
        }

        for (i in 0..23) {
            if (orthoBases[i] == orth) {
                return i
            }
        }
        return 0
    }

    /**
     *
     */
    fun getRotationQuaternion(): Quaternion {
        // Assumes that the matrix can be decomposed into a proper rotation and scaling matrix as M = R.S,
        // and returns the Euler angles corresponding to the rotation part, complementing get_scale().
        // See the comment in get_scale() for further information.
        val m = orthonormalized()
        val det: RealT = m.determinant().toRealT()
        if (det < 0) {
            // Ensure that the determinant is 1, such that result is a proper rotation matrix which can be represented by Euler angles.
            m.scale(Vector3(-1, -1, -1))
        }

        return Quaternion(m)
    }

    /**
     * Assuming that the matrix is the combination of a rotation and scaling,
     * return the absolute value of scaling factors along each axis.
     */
    fun getScale(): Vector3 {
        // We are assuming M = R.S, and performing a polar decomposition to extract R and S.
        // FIXME: We eventually need a proper polar decomposition.
        // As a cheap workaround until then, to ensure that R is a proper rotation matrix with determinant +1
        // (such that it can be represented by a Quat or Euler angles), we absorb the sign flip into the scaling matrix.
        // As such, it works in conjuction with getRotation().
        val detSign: RealT = if (determinant() > 0) 1.0 else -1.0
        return detSign * Vector3(
            Vector3(this._x.x, this._y.x, this._z.x).length(),
            Vector3(this._x.y, this._y.y, this._z.y).length(),
            Vector3(this._x.z, this._y.z, this._z.z).length()
        )
    }

    /**
     * Returns the inverse of the matrix.
     */
    fun inverse(): Basis {
        val b = Basis(this)
        b.invert()
        return b
    }


    internal fun invert() {
        val co1 = _y.y * _z.z - _y.z * _z.y
        val co2 = _y.z * _z.x - _y.x * _z.z
        val co3 = _y.x * _z.y - _y.y * _z.x

        val det: RealT = this._x.x * co1 + this._x.y * co2 + this._x.z * co3

        if (GodotJvmBuildConfig.DEBUG) {
            require(det != 0.0) { "Determinant is zero!" }
        }

        val s = 1.0 / det
        set(
            co1 * s, (_x.z * _z.y - _x.y * _z.z) * s, (_x.y * _y.z - _x.z * _y.y) * s,
            co2 * s, (_x.x * _z.z - _x.z * _z.x) * s, (_x.z * _y.x - _x.x * _y.z) * s,
            co3 * s, (_x.y * _z.x - _x.x * _z.y) * s, (_x.x * _y.y - _x.y * _y.x) * s
        )
    }

    fun getQuaternion(): Quaternion {
        if (GodotJvmBuildConfig.DEBUG) {
            require(isRotation()) { "Basis must be normalized in order to be casted to a Quaternion. Use get_rotation_quat() or call orthonormalized() instead." }
        }
        val trace = this._x.x + this._y.y + this._z.z
        val temp: DoubleArray

        if (trace > 0.0) {
            var s = sqrt(trace + 1.0)
            val temp3 = s * 0.5
            s = 0.5 / s
            temp = doubleArrayOf(
                ((this._z.y - this._y.z) * s),
                ((this._x.z - this._z.x) * s),
                ((this._y.x - this._x.y) * s),
                temp3
            )
        } else {
            temp = doubleArrayOf(0.0, 0.0, 0.0, 0.0)
            val i = if (this._x.x < this._y.y) {
                if (this._y.y < this._z.z) 2 else 1
            } else {
                if (this._x.x < this._z.z) 2 else 0
            }
            val j = (i + 1) % 3
            val k = (i + 2) % 3

            var s = sqrt(this._get(i)[i] - this._get(j)[j] - this._get(k)[k] + 1.0)
            temp[i] = s * 0.5
            s = 0.5 / s
            temp[3] = (this._get(k)[j] - this._get(j)[k]) * s
            temp[j] = (this._get(j)[i] + this._get(i)[j]) * s
            temp[k] = (this._get(k)[i] + this._get(i)[k]) * s
        }

        return Quaternion(temp[0], temp[1], temp[2], temp[3])
    }

    /**
     *
     */
    @JvmOverloads
    fun isEqualApprox(a: Basis, epsilon: RealT = CMP_EPSILON): Boolean {
        if (!this._x.x.isEqualApprox(a._x.x, epsilon)) return false
        if (!this._x.y.isEqualApprox(a._x.y, epsilon)) return false
        if (!this._x.z.isEqualApprox(a._x.z, epsilon)) return false

        if (!this._y.x.isEqualApprox(a._y.x, epsilon)) return false
        if (!this._y.y.isEqualApprox(a._y.y, epsilon)) return false
        if (!this._y.z.isEqualApprox(a._y.z, epsilon)) return false

        if (!this._z.x.isEqualApprox(a._z.x, epsilon)) return false
        if (!this._z.y.isEqualApprox(a._z.y, epsilon)) return false
        if (!this._z.z.isEqualApprox(a._z.z, epsilon)) return false

        return true
    }

    /**
     * Returns `true` if this basis is finite, by calling [Vector3.isFinite] on each component.
     */
    fun isFinite() = _x.isFinite() && _y.isFinite() && _z.isFinite()

    /**
     * Returns the orthonormalized version of the matrix (useful to call from time to time to avoid rounding error for orthogonal matrices).
     * This performs a Gram-Schmidt orthonormalization on the basis of the matrix.
     */
    fun orthonormalized(): Basis {
        val b = Basis(this)
        b.orthonormalize()
        return b
    }

    internal fun orthonormalize() {
        if (GodotJvmBuildConfig.DEBUG) {
            require(!determinant().isEqualApprox(0.0)) { "Determinant is zero!" }
        }

        val x = getColumn(0)
        var y = getColumn(1)
        var z = getColumn(2)

        x.normalize()
        y = (y - x * (x.dot(y)))
        y.normalize()
        z = (z - x * (x.dot(z)) - y * (y.dot(z)))
        z.normalize()

        setColumn(0, x)
        setColumn(1, y)
        setColumn(2, z)
    }

    @PublishedApi
    internal fun getColumn(column: Int): Vector3 =
        Vector3(this._x[column], this._y[column], this._z[column])

    @PublishedApi
    internal fun setColumn(column: Int, value: Vector3) {
        this._x[column] = value.x
        this._y[column] = value.y
        this._z[column] = value.z
    }

    internal fun setColumns(x: Vector3, y: Vector3, z: Vector3) {
        setColumn(0, x)
        setColumn(1, y)
        setColumn(2, z)
    }

    /**
     * Introduce an additional rotation around the given axis by phi (radians). The axis must be a normalized vector.
     */
    fun rotated(axis: Vector3, phi: RealT): Basis {
        return Basis(axis, phi) * this
    }

    internal fun rotate(axis: Vector3, phi: RealT) {
        val ret = rotated(axis, phi)
        this._x = ret._x
        this._y = ret._y
        this._z = ret._z
    }

    /**
     * Assuming that the matrix is a proper rotation matrix, returns the result of rotating toward [to] by [delta] (in radians).
     * Passing a negative [delta] will rotate toward the inverse of [to].
     */
    fun rotateToward(to: Basis, delta: RealT): Basis {
        return Basis(
            getRotationQuaternion().rotateToward(
                to.getRotationQuaternion(),
                delta
            )
        )
    }

    /**
     * Introduce an additional scaling specified by the given 3D scaling factor.
     */
    fun scaled(scale: Vector3): Basis {
        val b = Basis(this)
        b.scale(scale)
        return b
    }

    /**
     * Introduce an additional scaling specified by the given 3D scaling factor.
     */
    internal fun scaledLocal(scale: Vector3): Basis {
        return Basis(this) * fromScale(scale)
    }

    internal fun scale(scale: Vector3) {
        this._x.x *= scale.x
        this._x.y *= scale.x
        this._x.z *= scale.x
        this._y.x *= scale.y
        this._y.y *= scale.y
        this._y.z *= scale.y
        this._z.x *= scale.z
        this._z.y *= scale.z
        this._z.z *= scale.z
    }

    private fun set(basis: Basis) {
        this._x = basis._x
        this._y = basis._y
        this._z = basis._z
    }

    internal fun setEuler(euler: Vector3, order: EulerOrder = EulerOrder.YXZ) {
        var c: RealT = cos(euler.x)
        var s: RealT = sin(euler.x)

        val xmat = Basis(1.0, 0.0, 0.0, 0.0, c, -s, 0.0, s, c)

        c = cos(euler.y)
        s = sin(euler.y)
        val ymat = Basis(c, 0.0, s, 0.0, 1.0, 0.0, -s, 0.0, c)

        c = cos(euler.z)
        s = sin(euler.z)
        val zmat = Basis(c, -s, 0.0, s, c, 0.0, 0.0, 0.0, 1.0)

        when (order) {
            EulerOrder.XYZ -> set(xmat * (ymat * zmat))
            EulerOrder.XZY -> set(xmat * zmat * ymat)
            EulerOrder.YXZ -> set(ymat * xmat * zmat)
            EulerOrder.YZX -> set(ymat * zmat * xmat)
            EulerOrder.ZXY -> set(zmat * xmat * ymat)
            EulerOrder.ZYX -> set(zmat * ymat * xmat)
        }
    }

    /**
     *
     */
    fun setOrthogonalIndex(index: Int) {
        if (GodotJvmBuildConfig.DEBUG) {
            require(index < 24) { "Index must be less than 24!" }
        }
        val ret = orthoBases[index]
        this._x = ret._x
        this._y = ret._y
        this._z = ret._z
    }

    /**
     * Assuming that the matrix is a proper rotation matrix, slerp performs a spherical-linear interpolation with another rotation matrix.
     */
    fun slerp(b: Basis, t: RealT): Basis {
        if (GodotJvmBuildConfig.DEBUG) {
            require(isRotation()) { "Basis is not a rotation!" }
        }

        val from = Quaternion(this)
        val to = Quaternion(b)

        val ret = Basis(from.slerp(to, t))
        ret._x *= lerp(this._x.length(), b._x.length(), t)
        ret._y *= lerp(this._y.length(), b._y.length(), t)
        ret._z *= lerp(this._z.length(), b._z.length(), t)

        return ret
    }

    /**
     * Transposed dot product with the x axis of the matrix.
     */
    fun tdotx(v: Vector3): RealT {
        return this._x.x * v.x + this._y.x * v.y + this._z.x * v.z
    }

    /**
     * Transposed dot product with the y axis of the matrix.
     */
    fun tdoty(v: Vector3): RealT {
        return this._x.y * v.x + this._y.y * v.y + this._z.y * v.z
    }

    /**
     * Transposed dot product with the z axis of the matrix.
     */
    fun tdotz(v: Vector3): RealT {
        return this._x.z * v.x + this._y.z * v.y + this._z.z * v.z
    }

    /**
     * Returns the transposed version of the matrix.
     */
    fun transposed(): Basis {
        val b = Basis(this)
        b.transpose()
        return b
    }

    internal fun transpose() {
        this._x.y = this._y.x.also { this._y.x = this._x.y }
        this._x.z = this._z.x.also { this._z.x = this._x.z }
        this._y.z = this._z.y.also { this._z.y = this._y.z }
    }

    /**
     * Returns a vector transformed (multiplied) by the matrix.
     */
    fun xform(vector: Vector3): Vector3 =
        Vector3(
            this._x.dot(vector),
            this._y.dot(vector),
            this._z.dot(vector)
        )

    /**
     * Returns a vector transformed (multiplied) by the transposed matrix.
     * Note that this results in a multiplication by the inverse of the matrix only if it represents a rotation-reflection.
     */
    fun xformInv(vector: Vector3): Vector3 =
        Vector3(
            (this._x.x * vector.x) + (this._y.x * vector.y) + (this._z.x * vector.z),
            (this._x.y * vector.x) + (this._y.y * vector.y) + (this._z.y * vector.z),
            (this._x.z * vector.x) + (this._y.z * vector.y) + (this._z.z * vector.z)
        )


    internal fun _get(n: Int): Vector3 {
        return when (n) {
            0 -> _x
            1 -> _y
            2 -> _z
            else -> throw IndexOutOfBoundsException()
        }
    }

    internal fun _set(n: Int, f: Vector3) {
        when (n) {
            0 -> _x = f
            1 -> _y = f
            2 -> _z = f
            else -> throw IndexOutOfBoundsException()
        }
    }

    fun set(
        xx: RealT,
        xy: RealT,
        xz: RealT,
        yx: RealT,
        yy: RealT,
        yz: RealT,
        zx: RealT,
        zy: RealT,
        zz: RealT
    ) {
        _x.x = xx; _x.y = xy; _x.z = xz
        _y.x = yx; _y.y = yy; _y.z = yz
        _z.x = zx; _z.y = zy; _z.z = zz
    }


    operator fun plus(matrix: Basis) = Basis().also {
        it._x = this._x + matrix._x
        it._y = this._y + matrix._y
        it._z = this._z + matrix._z
    }

    operator fun minus(matrix: Basis) = Basis().also {
        it._x = this._x - matrix._x
        it._y = this._y - matrix._y
        it._z = this._z - matrix._z
    }

    operator fun times(matrix: Basis) = Basis(
        matrix.tdotx(this._x), matrix.tdoty(this._x), matrix.tdotz(this._x),
        matrix.tdotx(this._y), matrix.tdoty(this._y), matrix.tdotz(this._y),
        matrix.tdotx(this._z), matrix.tdoty(this._z), matrix.tdotz(this._z)
    )

    operator fun times(scalar: Int) = Basis().also {
        it._x = this._x * scalar
        it._y = this._y * scalar
        it._z = this._z * scalar
    }

    operator fun times(scalar: Long) = Basis().also {
        it._x = this._x * scalar
        it._y = this._y * scalar
        it._z = this._z * scalar
    }

    operator fun times(scalar: Float) = Basis().also {
        it._x = this._x * scalar
        it._y = this._y * scalar
        it._z = this._z * scalar
    }

    operator fun times(scalar: Double) = Basis().also {
        it._x = this._x / scalar
        it._y = this._y / scalar
        it._z = this._z / scalar
    }

    operator fun div(scalar: Int) = Basis().also {
        it._x = this._x / scalar
        it._y = this._y / scalar
        it._z = this._z / scalar
    }

    operator fun div(scalar: Long) = Basis().also {
        it._x = this._x / scalar
        it._y = this._y / scalar
        it._z = this._z / scalar
    }

    operator fun div(scalar: Float) = Basis().also {
        it._x = this._x / scalar
        it._y = this._y / scalar
        it._z = this._z / scalar
    }

    operator fun div(scalar: Double) = Basis().also {
        it._x = this._x / scalar
        it._y = this._y / scalar
        it._z = this._z / scalar
    }

    operator fun times(vector: Vector3) = this.xform(vector)

    override fun toString(): String {
        return buildString {
            append("${this@Basis._x.x}, ${this@Basis._x.y}, ${this@Basis._x.z}, ")
            append("${this@Basis._y.x}, ${this@Basis._y.y}, ${this@Basis._y.z}, ")
            append("${this@Basis._z.x}, ${this@Basis._z.y}, ${this@Basis._z.z}")
        }
    }

    override fun equals(other: Any?): Boolean = when (other) {
        is Basis -> (this._x.x == other._x.x && this._x.y == other._x.y && this._x.z == other._x.z &&
            this._y.x == other._y.x && this._y.y == other._y.y && this._y.z == other._y.z &&
            this._z.x == other._z.x && this._z.y == other._z.y && this._z.z == other._z.z)

        else -> false
    }

    override fun hashCode(): Int {
        var result = _x.hashCode()
        result = 31 * result + _y.hashCode()
        result = 31 * result + _z.hashCode()
        return result
    }


    fun set(xAxis: Vector3, yAxis: Vector3, zAxis: Vector3) {
        setColumn(0, xAxis)
        setColumn(1, yAxis)
        setColumn(2, zAxis)
    }

    /*
     * GDScript related members
     */
    constructor(xAxis: Vector3, yAxis: Vector3, zAxis: Vector3) : this() {
        set(xAxis, yAxis, zAxis)
    }

    //PROPERTIES
    /** Return a copy of the x Vector3
     * Warning: Writing x.x = 2 will only modify a copy, not the actual object.
     * To modify it, use x().
     * */
    @CoreTypeLocalCopy
    var x
        get() = getColumn(0)
        set(value) {
            setColumn(0, value)
        }

    @CoreTypeHelper
    inline fun <T> x(block: Vector3.() -> T): T {
        val x = getColumn(0)
        val ret = x.block()
        setColumn(0, x)
        return ret
    }

    /** Return a copy of the y Vector3
     * Warning: Writing y.x = 2 will only modify a copy, not the actual object.
     * To modify it, use y().
     * */
    @CoreTypeLocalCopy
    var y
        get() = getColumn(1)
        set(value) {
            setColumn(1, value)
        }

    @CoreTypeHelper
    inline fun <T> y(block: Vector3.() -> T): T {
        val y = getColumn(1)
        val ret = y.block()
        setColumn(1, y)
        return ret
    }

    /** Return a copy of the z Vector3
     * Warning: Writing z.x = 2 will only modify a copy, not the actual object.
     * To modify it, use z().
     * */
    @CoreTypeLocalCopy
    var z
        get() = getColumn(2)
        set(value) {
            setColumn(2, value)
        }

    @CoreTypeHelper
    inline fun <T> z(block: Vector3.() -> T): T {
        val z = getColumn(2)
        val ret = z.block()
        setColumn(2, z)
        return ret
    }

    operator fun get(index: Int): Vector3 {
        return getColumn(index)
    }

    operator fun set(index: Int, value: Vector3) {
        setColumn(index, value)
    }
}

operator fun Int.times(basis: Basis) = basis * this
operator fun Long.times(basis: Basis) = basis * this
operator fun Float.times(basis: Basis) = basis * this
operator fun Double.times(basis: Basis) = basis * this
