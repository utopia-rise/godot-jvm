@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.annotation.CoreTypeLocalCopy
import godot.common.util.RealT
import godot.core.times
import godot.internal.logging.GodotLogging
import kotlincompile.definitions.GodotJvmBuildConfig

class Transform3D(
    p_basis: Basis,
    p_origin: Vector3 = Vector3()
) : CoreType {

    @PublishedApi
    internal var _basis = Basis(p_basis)

    @PublishedApi
    internal var _origin = Vector3(p_origin)


    //PROPERTIES
    /** Return a copy of the basis Basis.
     * Warning: Writing basis.x = 2 will only modify a copy, not the actual object.
     * To modify it, use basis().
     * */
    @CoreTypeLocalCopy
    var basis
        get() = Basis(_basis)
        set(value) {
            _basis = Basis(value)
        }

    @CoreTypeHelper
    inline fun <T> basis(block: Basis.() -> T): T {
        return _basis.block()
    }

    /** Return a copy of the origin Vector3
     * Warning: Writing origin.x = 2 will only modify a copy, not the actual object.
     * To modify it, use origin().
     * */
    @CoreTypeLocalCopy
    var origin
        get() = Vector3(_origin)
        set(value) {
            _origin = Vector3(value)
        }

    @CoreTypeHelper
    inline fun <T> origin(block: Vector3.() -> T): T {
        return _origin.block()
    }


    //CONSTANTS
    companion object {
        inline val IDENTITY: Transform3D
            get() = Transform3D(Basis(1, 0, 0, 0, 1, 0, 0, 0, 1), Vector3(0, 0, 0))
        inline val FLIP_X: Transform3D
            get() = Transform3D(Basis.FLIP_X)
        inline val FLIP_Y: Transform3D
            get() = Transform3D(Basis.FLIP_Y)
        inline val FLIP_Z: Transform3D
            get() = Transform3D(Basis.FLIP_Z)
    }


    //CONSTRUCTOR
    constructor() :
        this(Basis(), Vector3(0, 0, 0))

    constructor(other: Transform3D) :
        this(other._basis, other._origin)

    constructor(
        xx: Number,
        xy: Number,
        xz: Number,
        yx: Number,
        yy: Number,
        yz: Number,
        zx: Number,
        zy: Number,
        zz: Number,
        tx: Number,
        ty: Number,
        tz: Number
    ) :
        this(Basis(xx, xy, xz, yx, yy, yz, zx, zy, zz), Vector3(tx, ty, tz))

    constructor(from: Quaternion) :
        this(Basis(from))

    constructor(from: Projection) :
        this(
            Basis(
                Vector3(from.x.x, from.x.y, from.x.z),
                Vector3(from.y.x, from.y.y, from.y.z),
                Vector3(from.z.x, from.z.y, from.z.z)
            ),
            Vector3(from.w.x, from.w.y, from.w.z)
        )

    //API
    /**
     * Returns the inverse of the transform, under the assumption that the transformation is composed of rotation, scaling and translation.
     */
    fun affineInverse(): Transform3D {
        val ret = Transform3D(this._basis, this._origin)
        ret.affineInvert()
        return ret
    }

    internal fun affineInvert() {
        _basis.invert()
        _origin = _basis.xform(-_origin)
    }

    /**
     * Interpolates the transform to other Transform by weight amount (0-1).
     */
    fun interpolateWith(transform3D: Transform3D, c: RealT): Transform3D {
        val srcScale = _basis.getScale()
        val srcRot = _basis.getRotationQuaternion()
        val srcLoc = _origin

        val dstScale = transform3D._basis.getScale()
        val dstRot = transform3D._basis.getRotationQuaternion()
        val dstLoc = transform3D._origin

        return Transform3D(
            Basis(srcRot.slerp(dstRot, c).normalized()) * Basis.fromScale(srcScale.lerp(dstScale, c)),
            srcLoc.lerp(dstLoc, c)
        )
    }

    /**
     * Returns the inverse of the transform, under the assumption that the transformation is composed of rotation and translation (no scaling, use affine_inverse for transforms with scaling).
     */
    fun inverse(): Transform3D {
        val ret = Transform3D(this._basis, this._origin)
        ret.invert()
        return ret
    }

    internal fun invert() {
        _basis.transpose()
        _origin = _basis.xform(-_origin)
    }

    /**
     * Returns true if this transform and transform are approximately equal, by calling is_equal_approx on each component.
     */
    fun isEqualApprox(transform3D: Transform3D): Boolean {
        return _basis.isEqualApprox(transform3D._basis) && _origin.isEqualApprox(transform3D._origin)
    }

    /**
     * Returns true if this transform is finite, by calling @GlobalScope.is_finite on each component.
     */
    fun isFinite() = basis.isFinite() && origin.isFinite()

    /**
     * Returns a copy of the transform rotated such that the forward axis (-Z) points towards the [target] position.
     * The up axis (+Y) points as close to the [up] vector as possible while staying perpendicular to the forward axis. The resulting transform is orthonormalized. The existing rotation, scale, and skew information from the original transform is discarded. The [target] and [up] vectors cannot be zero, cannot be parallel to each other, and are defined in global/parent space.
     * If [useModelFront] is true, the +Z axis (asset front) is treated as forward (implies +X is left) and points toward the [target] position. By default, the -Z axis (camera forward) is treated as forward (implies +X is right).
     */
    fun lookingAt(target: Vector3, up: Vector3 = Vector3.UP, useModelFront: Boolean = false): Transform3D {
        if (GodotJvmBuildConfig.DEBUG) {
            if (_origin.isEqualApprox(target)) {
                GodotLogging.error("The transform's origin and target can't be equal.")
                return Transform3D()
            }
        }
        val t = Transform3D(this._basis, this._origin)
        t._basis = Basis.lookingAt(target - _origin, up, useModelFront)
        return t
    }

    internal fun setLookAt(eye: Vector3, target: Vector3, up: Vector3, useModelFront: Boolean) {
        if (GodotJvmBuildConfig.DEBUG) {
            if (eye.isEqualApprox(target)) {
                GodotLogging.error("The eye and target vectors can't be equal.")
                return
            }
        }
        _basis = Basis.lookingAt(target - eye, up, useModelFront);
        _origin = Vector3(eye)
    }

    /**
     * Returns the transform with the basis orthogonal (90 degrees), and normalized axis vectors.
     */
    fun orthonormalized(): Transform3D {
        val t = Transform3D(this._basis, this._origin)
        t.orthonormalize()
        return t
    }

    internal fun orthonormalize() {
        _basis.orthonormalize()
    }

    internal fun rotate(axis: Vector3, phi: RealT) {
        val t = rotated(axis, phi)
        this._basis = t._basis
        this._origin = t._origin
    }

    /**
     * Returns a copy of the transform rotated around the given axis by the given angle (in radians).
     * The axis must be a normalized vector.
     * This method is an optimized version of multiplying the given transform X with a corresponding rotation transform R from the left, i.e., R * X.
     * This can be seen as transforming with respect to the global/parent frame.
     */
    fun rotated(axis: Vector3, angle: RealT): Transform3D {
        val basis = Basis(axis, angle)
        return Transform3D(basis * _basis, basis.xform(_origin))
    }

    /**
     * Returns a copy of the transform rotated around the given axis by the given angle (in radians).
     * The axis must be a normalized vector.
     * This method is an optimized version of multiplying the given transform X with a corresponding rotation transform R from the right, i.e., X * R.
     * This can be seen as transforming with respect to the local frame.
     */
    fun rotatedLocal(axis: Vector3, angle: RealT): Transform3D {
        val basis = Basis(axis, angle)
        return Transform3D(_basis * basis, _origin)
    }

    internal fun scale(scale: Vector3) {
        _basis.scale(scale)
        _origin *= scale
    }

    /**
     * Returns a copy of the transform scaled by the given scale factor.
     *
     * This method is an optimized version of multiplying the given transform X with a corresponding scaling transform S from the left, i.e., S * X.
     *
     * This can be seen as transforming with respect to the global/parent frame.
     */
    fun scaled(scale: Vector3): Transform3D {
        return Transform3D(this._basis.scaled(scale), this._origin * scale)
    }

    /**
     * Returns a copy of the transform scaled by the given scale factor.
     * This method is an optimized version of multiplying the given transform X with a corresponding scaling transform S from the right, i.e., X * S.
     * This can be seen as transforming with respect to the local frame.
     */
    fun scaledLocal(scale: Vector3): Transform3D {
        return Transform3D(this._basis.scaledLocal(scale), this._origin);
    }

    internal fun translate(translation: Vector3) {
        _origin.x += _basis._x.dot(translation)
        _origin.y += _basis._y.dot(translation)
        _origin.z += _basis._z.dot(translation)
    }

    /**
     * Returns a copy of the transform translated by the given offset.
     * This method is an optimized version of multiplying the given transform X with a corresponding translation transform T from the left, i.e., T * X.
     * This can be seen as transforming with respect to the global/parent frame.
     */
    fun translated(translation: Vector3): Transform3D {
        return Transform3D(this._basis, this._origin + translation);
    }

    /**
     * Returns a copy of the transform translated by the given offset.
     * This method is an optimized version of multiplying the given transform X with a corresponding translation transform T from the right, i.e., X * T.
     * This can be seen as transforming with respect to the local frame.
     */
    fun translatedLocal(translation: Vector3): Transform3D {
        return Transform3D(this._basis, this._origin + this._basis.xform(translation));
    }

    /**
     * Transforms the given Vector3 by this transform.
     */
    internal fun xform(vector: Vector3): Vector3 =
        Vector3(
            _basis._x.dot(vector) + _origin.x,
            _basis._y.dot(vector) + _origin.y,
            _basis._z.dot(vector) + _origin.z
        )

    /**
     * Transforms the given AABB by this transform.
     */
    internal fun xform(aabb: AABB): AABB {
        val min = doubleArrayOf(aabb._position.x, aabb._position.y, aabb._position.z)
        val max = doubleArrayOf(
            aabb._position.x + aabb._size.x,
            aabb._position.y + aabb._size.y,
            aabb._position.z + aabb._size.z
        )
        val rows = arrayOf(_basis._x, _basis._y, _basis._z)
        val origin = doubleArrayOf(_origin.x, _origin.y, _origin.z)
        val tmin = DoubleArray(3)
        val tmax = DoubleArray(3)
        for (i in 0..2) {
            tmin[i] = origin[i]
            tmax[i] = origin[i]
            val row = doubleArrayOf(rows[i].x, rows[i].y, rows[i].z)
            for (j in 0..2) {
                val e = row[j] * min[j]
                val f = row[j] * max[j]
                if (e < f) {
                    tmin[i] += e
                    tmax[i] += f
                } else {
                    tmin[i] += f
                    tmax[i] += e
                }
            }
        }
        val position = Vector3(tmin[0], tmin[1], tmin[2])
        return AABB(position, Vector3(tmax[0], tmax[1], tmax[2]) - position)
    }

    /**
     * Transforms the given Plane by this transform.
     */
    internal fun xform(plane: Plane): Plane {
        val point = xform(plane._normal * plane.d)
        val normal = _basis.inverse().transposed().xform(plane._normal)
        normal.normalize()
        return Plane(normal, normal.dot(point))
    }

    /**
     * Inverse-transforms the given Vector3 by this transform.
     */
    internal fun xformInv(vector: Vector3): Vector3 {
        val v = vector - _origin
        return Vector3(
            (_basis._x.x * v.x) + (_basis._y.x * v.y) + (_basis._z.x * v.z),
            (_basis._x.y * v.x) + (_basis._y.y * v.y) + (_basis._z.y * v.z),
            (_basis._x.z * v.x) + (_basis._y.z * v.y) + (_basis._z.z * v.z)
        )
    }

    /**
     * Inverse-transforms the given Plane by this transform.
     */
    internal fun xformInv(plane: Plane): Plane {
        val point = affineInverse().xform(plane._normal * plane.d)
        val normal = _basis.transposed().xform(plane._normal)
        normal.normalize()
        return Plane(normal, normal.dot(point))
    }

    /**
     * Inverse-transforms the given AABB by this transform.
     */
    internal fun xformInv(aabb: AABB): AABB {
        val vertices = arrayOf(
            Vector3(aabb._position.x + aabb._size.x, aabb._position.y + aabb._size.y, aabb._position.z + aabb._size.z),
            Vector3(aabb._position.x + aabb._size.x, aabb._position.y + aabb._size.y, aabb._position.z),
            Vector3(aabb._position.x + aabb._size.x, aabb._position.y, aabb._position.z + aabb._size.z),
            Vector3(aabb._position.x + aabb._size.x, aabb._position.y, aabb._position.z),
            Vector3(aabb._position.x, aabb._position.y + aabb._size.y, aabb._position.z + aabb._size.z),
            Vector3(aabb._position.x, aabb._position.y + aabb._size.y, aabb._position.z),
            Vector3(aabb._position.x, aabb._position.y, aabb._position.z + aabb._size.z),
            Vector3(aabb._position.x, aabb._position.y, aabb._position.z)
        )

        val ret = AABB()
        ret._position = xformInv(vertices[0])
        for (i in 1..7)
            ret.expandTo(xformInv(vertices[i]))

        return ret
    }


    override fun equals(other: Any?): Boolean = when (other) {
        is Transform3D -> _basis == other._basis && _origin == other._origin
        else -> false
    }

    override fun toString(): String {
        return "$_basis - $_origin"
    }

    override fun hashCode(): Int {
        var result = _basis.hashCode()
        result = 31 * result + _origin.hashCode()
        return result
    }

    /*
     * GDScript related members
     */
    constructor(x: Vector3, y: Vector3, z: Vector3, origin: Vector3) :
        this(Basis(x, y, z), origin)


    operator fun times(transform3D: Transform3D): Transform3D {
        return Transform3D(_basis * transform3D._basis, xform(transform3D._origin))
    }

    operator fun times(other: PackedVector3Array): PackedVector3Array {
        val newPackedArray = PackedVector3Array()
        other.toList().onEach { newPackedArray.pushBack(this * it) }
        return newPackedArray
    }

    operator fun times(other: AABB) = this.xform(other)
    operator fun times(other: Vector3) = this.xform(other)
    operator fun times(plane: Plane): Plane = xform(plane)

    operator fun times(other: Int) = Transform3D(other * _basis, other * _origin)
    operator fun times(other: Long) = Transform3D(other * _basis, other * _origin)
    operator fun times(other: Float) = Transform3D(other * _basis, other * _origin)
    operator fun times(other: Double) = Transform3D(other * _basis, other * _origin)

    operator fun div(other: Int) = Transform3D(_basis / other, _origin / other)
    operator fun div(other: Long) = Transform3D(_basis / other, _origin / other)
    operator fun div(other: Float) = Transform3D(_basis / other, _origin / other)
    operator fun div(other: Double) = Transform3D(_basis / other, _origin / other)
}

operator fun Vector3.times(other: Transform3D) = other.xformInv(this)
operator fun AABB.times(other: Transform3D) = other.xformInv(this)
operator fun Plane.times(other: Transform3D): Plane = other.xformInv(this)
operator fun PackedVector3Array.times(other: Transform3D): PackedVector3Array {
    val newPackedArray = PackedVector3Array()
    toList().onEach { newPackedArray.pushBack(other.xformInv(it)) }
    return newPackedArray
}

operator fun Int.times(other: Transform3D) = other * this
operator fun Long.times(other: Transform3D) = other * this
operator fun Float.times(other: Transform3D) = other * this
operator fun Double.times(other: Transform3D) = other * this
