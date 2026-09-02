@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.annotation.CoreTypeLocalCopy
import godot.common.util.RealT
import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class Projection(
    p_x: Vector4,
    p_y: Vector4,
    p_z: Vector4,
    p_w: Vector4
) {
    enum class Planes {
        PLANE_NEAR,
        PLANE_FAR,
        PLANE_LEFT,
        PLANE_TOP,
        PLANE_RIGHT,
        PLANE_BOTTOM
    }

    @PublishedApi
    internal var _x = Vector4(p_x)

    @PublishedApi
    internal var _y = Vector4(p_y)

    @PublishedApi
    internal var _z = Vector4(p_z)

    @PublishedApi
    internal var _w = Vector4(p_w)

    constructor(tranform: Transform3D) : this(
        Vector4(
            tranform.basis.x.x,
            tranform.basis.y.x,
            tranform.basis.z.x,
            0
        ),
        Vector4(
            tranform.basis.x.y,
            tranform.basis.y.y,
            tranform.basis.z.y,
            0
        ),
        Vector4(
            tranform.basis.x.z,
            tranform.basis.y.z,
            tranform.basis.z.z,
            0
        ),
        Vector4(
            tranform.origin.x,
            tranform.origin.y,
            tranform.origin.z,
            1
        )
    )

    constructor(projection: Projection) : this(
        projection._x,
        projection._y,
        projection._z,
        projection._w
    )

    constructor() : this(
        Vector4(1, 0, 0, 0),
        Vector4(0, 1, 0, 0),
        Vector4(0, 0, 1, 0),
        Vector4(0, 0, 0, 1)
    )

    private val _leftPlane: Plane
        get() = Plane(
            _x.w + _x.x,
            _y.w + _y.x,
            _z.w + _z.x,
            _w.w + _w.x
        )

    private val _rightPlane: Plane
        get() = Plane(
            _x.w - _x.x,
            _y.w - _y.x,
            _z.w - _z.x,
            -_w.w + _w.x
        )

    private val _topPlane: Plane
        get() = Plane(
            _x.w - _x.y,
            _y.w - _y.y,
            _z.w - _z.y,
            _w.w - _w.y
        )

    private val _bottomPlane: Plane
        get() = Plane(
            _x.w + _x.y,
            _y.w + _y.y,
            _z.w + _z.y,
            _w.w + _w.y
        )

    private val _farPlane: Plane
        get() = Plane(
            _x.w - _x.z,
            _y.w - _y.z,
            _z.w - _z.z,
            _w.w - _w.z
        )

    //PROPERTIES
    /** Return a copy of the x Vector4
     *
     *
     * **Warning**: Writing `x.x = 2` will only modify a copy, not the actual object.
     * To modify it, use [x] method.
     *
     * See: [Documentation](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types)
     * */
    @CoreTypeLocalCopy
    var x
        get() = Vector4(_x)
        set(value) {
            _x = Vector4(value)
        }

    /**
     * Apply modifications on actual [x] [Vector4].
     *
     *
     * [x] var return a copy of actual x [Vector4] of this [Projection]. This method purpose is to make changes to the
     * actual x.
     * See also: [x]
     */
    @CoreTypeHelper
    inline fun <T> x(block: Vector4.() -> T): T {
        return _x.block()
    }

    /** Return a copy of the y Vector4
     *
     *
     * **Warning**: Writing `y.x = 2` will only modify a copy, not the actual object.
     * To modify it, use [y] method.
     *
     * See: [Documentation](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types)
     * */
    @CoreTypeLocalCopy
    var y
        get() = Vector4(_y)
        set(value) {
            _y = Vector4(value)
        }

    /**
     * Apply modifications on actual [y] [Vector4].
     *
     *
     * [y] var return a copy of actual y [Vector4] of this [Projection]. This method purpose is to make changes to the
     * actual y.
     * See also: [y]
     */
    @CoreTypeHelper
    inline fun <T> y(block: Vector4.() -> T): T {
        return _y.block()
    }

    /** Return a copy of the z Vector4
     *
     *
     * **Warning**: Writing `z.x = 2` will only modify a copy, not the actual object.
     * To modify it, use [z] method.
     *
     * See: [Documentation](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types)
     * */
    @CoreTypeLocalCopy
    var z
        get() = Vector4(_z)
        set(value) {
            _z = Vector4(value)
        }

    /**
     * Apply modifications on actual [z] [Vector4].
     *
     *
     * [z] var return a copy of actual z [Vector4] of this [Projection]. This method purpose is to make changes to the
     * actual z.
     * See also: [z]
     */
    @CoreTypeHelper
    inline fun <T> z(block: Vector4.() -> T): T {
        return _z.block()
    }

    /** Return a copy of the w Vector4
     *
     *
     * **Warning**: Writing `w.x = 2` will only modify a copy, not the actual object.
     * To modify it, use [w] method.
     *
     * See: [Documentation](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types)
     * */
    @CoreTypeLocalCopy
    var w
        get() = Vector4(_w)
        set(value) {
            _w = Vector4(value)
        }

    /**
     * Apply modifications on actual [w] [Vector4].
     *
     *
     * [w] var return a copy of actual w [Vector4] of this [Projection]. This method purpose is to make changes to the
     * actual w.
     * See also: [w]
     */
    @CoreTypeHelper
    inline fun <T> w(block: Vector4.() -> T): T {
        return _w.block()
    }

    /**
     * Returns the column of the Projection with the given index.
     *
     * Indices are in the following order: x, y, z, w.
     */
    operator fun get(n: Int) = when (n) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException()
    }

    /**
     * Sets the column of the Projection with the given index.
     *
     * Indices are in the following order: x, y, z, w.
     */
    operator fun set(n: Int, vector: Vector4) {
        when (n) {
            0 -> _x = vector
            1 -> _y = vector
            2 -> _z = vector
            3 -> _w = vector
            else -> throw IndexOutOfBoundsException()
        }
    }

    /**
     * Returns a scalar value that is the signed factor by which areas are scaled by this matrix. If the sign is
     * negative, the matrix flips the orientation of the area.
     *
     * The determinant can be used to calculate the invertibility of a matrix or solve linear systems of equations
     * involving the matrix, among other applications.
     */
    fun determinant() = (
        _x.w * _y.z * _z.y * _w.x - _x.z * _y.w * _z.y * _w.x -
            _x.w * _y.y * _z.z * _w.x + _x.y * _y.w * _z.z * _w.x +
            _x.z * _y.y * _z.w * _w.x - _x.y * _y.z * _z.w * _w.x -
            _x.w * _y.z * _z.x * _w.y + _x.z * _y.w * _z.x * _w.y +
            _x.w * _y.x * _z.z * _w.y - _x.x * _y.w * _z.z * _w.y -
            _x.z * _y.x * _z.w * _w.y + _x.x * _y.z * _z.w * _w.y +
            _x.w * _y.y * _z.x * _w.z - _x.y * _y.w * _z.x * _w.z -
            _x.w * _y.x * _z.y * _w.z + _x.x * _y.w * _z.y * _w.z +
            _x.y * _y.x * _z.w * _w.z - _x.x * _y.y * _z.w * _w.z -
            _x.z * _y.y * _z.x * _w.w + _x.y * _y.z * _z.x * _w.w +
            _x.z * _y.x * _z.y * _w.w - _x.x * _y.z * _z.y * _w.w -
            _x.y * _y.x * _z.z * _w.w + _x.x * _y.y * _z.z * _w.w
        ).toFloat()

    @Suppress("MemberVisibilityCanBePrivate")
    fun setIdentity() {
        _x = Vector4(1, 0, 0, 0)
        _y = Vector4(0, 1, 0, 0)
        _z = Vector4(0, 0, 1, 0)
        _w = Vector4(0, 0, 0, 1)
    }

    fun setZero() {
        _x = Vector4(0, 0, 0, 0)
        _y = Vector4(0, 0, 0, 0)
        _z = Vector4(0, 0, 0, 0)
        _w = Vector4(0, 0, 0, 0)
    }

    fun setLightBias() {
        _x.x = 0.5
        _x.y = 0.0
        _x.z = 0.0
        _x.w = 0.0
        _y.x = 0.0
        _y.y = 0.5
        _y.z = 0.0
        _y.w = 0.0
        _z.x = 0.0
        _z.y = 0.0
        _z.z = 0.5
        _z.w = 0.0
        _w.x = 0.5
        _w.y = 0.5
        _w.z = 0.5
        _w.w = 1.0
    }

    fun setDepthCorrection(flipY: Boolean) {
        _x.x = 1.0
        _x.y = 0.0
        _x.z = 0.0
        _x.w = 0.0
        _y.x = 0.0
        _y.y = if (flipY) -1.0 else 1.0
        _y.z = 0.0
        _y.w = 0.0
        _z.x = 0.0
        _z.y = 0.0
        _z.z = 0.5
        _z.w = 0.0
        _w.x = 0.0
        _w.y = 0.0
        _w.z = 0.5
        _w.w = 1.0
    }

    fun setLightAtlasRect(p_rect: Rect2) {
        _x.x = p_rect.size.x
        _x.y = 0.0
        _x.z = 0.0
        _x.w = 0.0
        _y.x = 0.0
        _y.y = p_rect.size.y
        _y.z = 0.0
        _y.w = 0.0
        _z.x = 0.0
        _z.y = 0.0
        _z.z = 1.0
        _z.w = 0.0
        _w.x = p_rect.position.x
        _w.y = p_rect.position.y
        _w.z = 0.0
        _w.w = 1.0
    }

    fun setPerspective(pFovyDegrees: RealT, aspect: RealT, zNear: RealT, zFar: RealT, flipFov: Boolean) {
        val fovyDegrees = if (flipFov) getFovy(pFovyDegrees, 1.0 / aspect) else pFovyDegrees

        val radians = Math.toRadians(fovyDegrees / 2.0)
        val sine: RealT = sin(radians)
        val deltaZ = zFar - zNear

        if (deltaZ == 0.0 || sine == 0.0 || aspect == 0.0) {
            return
        }

        val cotangent = cos(radians) / sine

        setIdentity()

        _x.x = cotangent / aspect
        _y.y = cotangent
        _z.z = -(zFar + zNear) / deltaZ
        _z.w = -1.0
        _w.z = -2 * zNear * zFar / deltaZ
        _w.w = 0.0
    }

    fun setPerspective(
        pFovyDegrees: RealT,
        aspect: RealT,
        zNear: RealT,
        zFar: RealT,
        flipFov: Boolean,
        eye: Int,
        intraocularDist: RealT,
        convergenceDist: RealT
    ) {
        val fovyDegrees = if (flipFov) getFovy(pFovyDegrees, 1.0 / aspect) else pFovyDegrees

        val ymax = zNear * tan(Math.toRadians(fovyDegrees / 2.0))
        val xmax = ymax * aspect
        val frustumshift = (intraocularDist / 2.0) * zNear / convergenceDist

        val left: RealT
        val right: RealT
        val modelTranslation: RealT
        when (eye) {
            1 -> {
                left = -xmax + frustumshift
                right = xmax + frustumshift
                modelTranslation = intraocularDist / 2.0
            }

            2 -> {
                left = -xmax - frustumshift
                right = xmax - frustumshift
                modelTranslation = -intraocularDist / 2.0
            }

            else -> {
                left = -xmax
                right = xmax
                modelTranslation = 0.0
            }
        }

        setFrustrum(left, right, -ymax, ymax, zNear, zFar)

        val cm = Projection()
        cm._w.x = modelTranslation
        set(this * cm)
    }

    fun setForHmd(
        pEye: Int,
        pAspect: RealT,
        pIntraocularDist: RealT,
        pDisplayWidth: RealT,
        pDisplayToLens: RealT,
        pOversample: RealT,
        pZNear: RealT,
        pZFar: RealT
    ) {
        // we first calculate our base frustum on our values without taking our lens magnification into account.
        var f1: RealT = pIntraocularDist * 0.5 / pDisplayToLens
        var f2: RealT = (pDisplayWidth - pIntraocularDist) * 0.5 / pDisplayToLens
        var f3: RealT = pDisplayWidth / 4.0 / pDisplayToLens

        // now we apply our oversample factor to increase our FOV. how much we oversample is always a balance we strike between performance and how much
        // we're willing to sacrifice in FOV.

        // now we apply our oversample factor to increase our FOV. how much we oversample is always a balance we strike between performance and how much
        // we're willing to sacrifice in FOV.
        val add: RealT = (f1 + f2) * (pOversample - 1.0) / 2.0
        f1 += add
        f2 += add
        f3 *= pOversample

        // always apply KEEP_WIDTH aspect ratio
        f3 /= pAspect

        when (pEye) {
            1 -> {
                // left eye
                setFrustrum(-f2 * pZNear, f1 * pZNear, -f3 * pZNear, f3 * pZNear, pZNear, pZFar)
            }

            2 -> {
                // right eye
                setFrustrum(-f1 * pZNear, f2 * pZNear, -f3 * pZNear, f3 * pZNear, pZNear, pZFar)
            }

            else -> {}
        }
    }

    fun setOrthogonal(pLeft: RealT, pRight: RealT, pBottom: RealT, pTop: RealT, pZnear: RealT, pZfar: RealT) {
        setIdentity()

        _x.x = 2.0 / (pRight - pLeft)
        _w.x = -((pRight + pLeft) / (pRight - pLeft))
        _y.y = 2.0 / (pTop - pBottom)
        _w.y = -((pTop + pBottom) / (pTop - pBottom))
        _z.z = -2.0 / (pZfar - pZnear)
        _w.z = -((pZfar + pZnear) / (pZfar - pZnear))
        _w.w = 1.0
    }

    fun setOrthogonal(pSize: RealT, pAspect: RealT, pZnear: RealT, pZfar: RealT, pFlipFov: Boolean) {
        val size = if (!pFlipFov) {
            pSize * pAspect
        } else {
            pSize
        }

        setOrthogonal(-size / 2, +size / 2, -size / pAspect / 2, +size / pAspect / 2, pZnear, pZfar)
    }

    fun setFrustrum(left: RealT, right: RealT, bottom: RealT, top: RealT, near: RealT, far: RealT) {
        if (right <= left) throw IllegalArgumentException("right <= left")
        if (top <= bottom) throw IllegalArgumentException("top <= bottom")
        if (far <= near) throw IllegalArgumentException("far <= near")

        val x = 2 * near / (right - left)
        val y = 2 * near / (top - bottom)
        val a = (right + left) / (right - left)
        val b = (top + bottom) / (top - bottom)
        val c = -(far + near) / (far - near)
        val d = -2 * far * near / (far - near)
        _x.x = x
        _x.y = 0.0
        _x.z = 0.0
        _x.w = 0.0
        _y.x = 0.0
        _y.y = y
        _y.z = 0.0
        _y.w = 0.0
        _z.x = a
        _z.y = b
        _z.z = c
        _z.w = -1.0
        _w.x = 0.0
        _w.y = 0.0
        _w.z = d
        _w.w = 0.0
    }

    fun setFrustrum(pSize: RealT, aspect: RealT, offset: Vector2, near: RealT, far: RealT, flipFov: Boolean) {
        val size = if (!flipFov) {
            pSize * aspect
        } else {
            pSize
        }

        setFrustrum(
            -size / 2 + offset.x,
            size / 2 + offset.x,
            -size / aspect / 2 + offset.y,
            size / aspect / 2 + offset.y,
            near,
            far
        )
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun adjustPerspectiveZnear(p_new_znear: RealT) {
        val zfar: RealT = getZFar()
        val znear: RealT = p_new_znear

        val deltaZ: RealT = zfar - znear
        _z.z = -(zfar + znear) / deltaZ
        _w.z = -2 * znear * zfar / deltaZ
    }

    /**
     * Returns a Projection with the near clipping distance adjusted to be [newZnear].
     *
     * **Note**: The original Projection must be a perspective projection.
     */
    fun perspectiveZnearAdjusted(newZnear: RealT) = Projection(this).also {
        it.adjustPerspectiveZnear(newZnear)
    }

    /**
     * Returns the clipping plane of this Projection whose index is given by [plane].
     *
     * [plane] should be equal to one of PLANE_NEAR, PLANE_FAR, PLANE_LEFT, PLANE_TOP, PLANE_RIGHT, or PLANE_BOTTOM.
     */
    @Suppress("DuplicatedCode")
    fun getProjectionPlane(plane: Planes): Plane {
        val newPlane = when (plane) {
            Planes.PLANE_NEAR -> Plane(
                _x.w + _x.z,
                _y.w + _y.z,
                _z.w + _z.z,
                _w.w + _w.z
            )

            Planes.PLANE_FAR -> _farPlane

            Planes.PLANE_LEFT -> _leftPlane

            Planes.PLANE_TOP -> _topPlane

            Planes.PLANE_RIGHT -> Plane(
                _x.w - _x.x,
                _y.w - _y.x,
                _z.w - _z.x,
                _w.w - _w.x
            )

            Planes.PLANE_BOTTOM -> _bottomPlane
        }

        newPlane.normal = -newPlane.normal
        newPlane.normalize()
        return newPlane
    }

    /**
     * Returns a copy of this Projection with the signs of the values of the Y column flipped.
     */
    fun flippedY() = Projection(this).also {
        it.flipY()
    }

    /**
     * Returns a Projection with the X and Y values from the given [Vector2] added to the first and second values of the
     * final column respectively.
     */
    fun jitterOffseted(pOffset: Vector2) = Projection(this).also {
        it.addJitterOffset(pOffset)
    }

    /**
     * Returns the distance for this Projection beyond which positions are clipped.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun getZFar(): RealT {
        val newPlane = _farPlane

        newPlane.normal = -newPlane.normal
        newPlane.normalize()

        return newPlane.d
    }

    /**
     * Returns the distance for this Projection before which positions are clipped.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun getZNear(): RealT {
        val newPlane = Plane(
            _x.w + _x.z,
            _y.w + _y.z,
            _z.w + _z.z,
            -_w.w - _w.z
        )

        newPlane.normalize()
        return newPlane.d
    }

    /**
     * Returns the X:Y aspect ratio of this Projection's viewport.
     */
    fun getAspect(): RealT {
        val vpHe = getViewportHalfExtents()
        return vpHe.x / vpHe.y
    }

    /**
     * Returns the horizontal field of view of the projection (in degrees).
     */
    fun getFov(): RealT {
        val rightPlane = _rightPlane
        rightPlane.normalize()

        return if (_z.x == 0.0 && _z.y == 0.0) {
            Math.toDegrees(acos(abs(rightPlane.normal.x))) * 2.0
        } else {
            val leftPlane = _leftPlane
            leftPlane.normalize()

            Math.toDegrees(acos(abs(leftPlane.normal.x))) + Math.toDegrees(acos(abs(rightPlane.normal.x)))
        }
    }

    /**
     * Returns `true` if this Projection performs an orthogonal projection.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun isOrthogonal() = _w.w == 1.0

    @Suppress("MemberVisibilityCanBePrivate")
    fun getProjectionPlanes(pTransform: Transform3D): Array<Plane> {
        val nearPlane = Plane(
            _x.w + _x.z,
            _y.w + _y.z,
            _z.w + _z.z,
            _w.w + _w.z
        )

        nearPlane.normal = -nearPlane._normal
        nearPlane.normalize()

        val farPlane = _farPlane

        farPlane.normal = -farPlane.normal
        farPlane.normalize()

        val leftPlane = _leftPlane

        leftPlane.normal = -leftPlane.normal
        leftPlane.normalize()

        val topPlane = _topPlane

        topPlane.normal = -topPlane.normal
        topPlane.normalize()

        val rightPlane = Plane(
            _x.w - _x.x,
            _y.w - _y.x,
            _z.w - _z.x,
            _w.w - _w.x
        )

        rightPlane.normal = -rightPlane.normal
        rightPlane.normalize()

        val bottomPlane = _bottomPlane

        bottomPlane.normal = -bottomPlane.normal
        bottomPlane.normalize()

        return arrayOf(
            pTransform.xform(nearPlane),
            pTransform.xform(farPlane),
            pTransform.xform(leftPlane),
            pTransform.xform(topPlane),
            pTransform.xform(rightPlane),
            pTransform.xform(bottomPlane)
        )
    }

    fun getEndpoints(pTransform: Transform3D): Array<Vector3>? {
        val planes = getProjectionPlanes(Transform3D())
        val intersections = arrayOf(
            arrayOf(Planes.PLANE_FAR, Planes.PLANE_LEFT, Planes.PLANE_TOP),
            arrayOf(Planes.PLANE_FAR, Planes.PLANE_LEFT, Planes.PLANE_BOTTOM),
            arrayOf(Planes.PLANE_FAR, Planes.PLANE_RIGHT, Planes.PLANE_TOP),
            arrayOf(Planes.PLANE_FAR, Planes.PLANE_RIGHT, Planes.PLANE_BOTTOM),
            arrayOf(Planes.PLANE_NEAR, Planes.PLANE_LEFT, Planes.PLANE_TOP),
            arrayOf(Planes.PLANE_NEAR, Planes.PLANE_LEFT, Planes.PLANE_BOTTOM),
            arrayOf(Planes.PLANE_NEAR, Planes.PLANE_RIGHT, Planes.PLANE_TOP),
            arrayOf(Planes.PLANE_NEAR, Planes.PLANE_RIGHT, Planes.PLANE_BOTTOM)
        )

        return Array(8) { i: Int ->
            val a = planes[intersections[i][0].ordinal]
            val b = planes[intersections[i][1].ordinal]
            val c = planes[intersections[i][2].ordinal]

            val point = a.intersect3(b, c) ?: return null

            pTransform.xform(point)
        }
    }

    /**
     * Returns the dimensions of the viewport plane that this Projection projects positions onto, divided by two.
     */
    @Suppress("MemberVisibilityCanBePrivate", "DuplicatedCode")
    fun getViewportHalfExtents(): Vector2 {

        ////--- Near Plane ---///////
        val nearPlane = Plane(
            _x.w + _x.z,
            _y.w + _y.z,
            _z.w + _z.z,
            -_w.w - _w.z
        )
        nearPlane.normalize()

        ///////--- Right Plane ---///////
        val rightPlane = _rightPlane
        rightPlane.normalize()

        val topPlane = _topPlane
        topPlane.normalize()

        val res = nearPlane.intersect3(rightPlane, topPlane)

        return if (res == null) Vector2() else Vector2(res.x, res.y)
    }

    /**
     * Returns the dimensions of the far clipping plane of the projection, divided by two.
     */
    @Suppress("DuplicatedCode")
    fun getFarPlaneHalfExtents(): Vector2 {

        ////--- Far Plane ---///////
        val farPlane = Plane(
            _x.w - _x.z,
            _y.w - _y.z,
            _z.w - _z.z,
            -_w.w + _w.z
        )
        farPlane.normalize()

        ///////--- Right Plane ---///////
        val rightPlane = _rightPlane
        rightPlane.normalize()

        val topPlane = _topPlane
        topPlane.normalize()

        val res = farPlane.intersect3(rightPlane, topPlane)

        return if (res == null) Vector2() else Vector2(res.x, res.y)
    }

    private fun invert() {
        // Adapted from Mesa's `src/util/u_math.c` `util_invert_mat4x4`.
        // MIT licensed. Copyright 2008 VMware, Inc. Authored by Jacques Leroy.

        var m0: RealT = 0.0
        var m1: RealT = 0.0
        var m2: RealT = 0.0
        var m3: RealT = 0.0
        var s: RealT = 0.0

        var swap1 = Vector4()
        var swap2 = Vector4()

        var r01 = Vector4(this._x)
        var r02 = Vector4(1.0, 0.0, 0.0, 0.0)

        var r11 = Vector4(this._y)
        var r12 = Vector4(0.0, 1.0, 0.0, 0.0)

        var r21 = Vector4(this._z)
        var r22 = Vector4(0.0, 0.0, 1.0, 0.0)

        var r31 = Vector4(this._w)
        var r32 = Vector4(0.0, 0.0, 0.0, 1.0)


        /* choose pivot - or die */
        if (abs(r31.x) > abs(r21.x)) {
            swap1 = r31
            swap2 = r32
            r31 = r21
            r32 = r22
            r21 = swap1
            r22 = swap2
        }

        if (abs(r21.x) > abs(r11.x)) {
            swap1 = r21
            swap2 = r22
            r21 = r11
            r22 = r12
            r11 = swap1
            r12 = swap2
        }
        if (abs(r11.x) > abs(r01.x)) {
            swap1 = r11
            swap2 = r12
            r11 = r01
            r12 = r02
            r01 = swap1
            r02 = swap2
        }

        check(r01.x != 0.0)

        /* eliminate first variable     */
        m1 = r11.x / r01.x
        m2 = r21.x / r01.x
        m3 = r31.x / r01.x
        s = r01.y
        r11.y -= m1 * s
        r21.y -= m2 * s
        r31.y -= m3 * s
        s = r01.z
        r11.z -= m1 * s
        r21.z -= m2 * s
        r31.z -= m3 * s
        s = r01.w
        r11.w -= m1 * s
        r21.w -= m2 * s
        r31.w -= m3 * s
        s = r02.x
        if (s != 0.0) {
            r12.x -= m1 * s
            r22.x -= m2 * s
            r32.x -= m3 * s
        }
        s = r02.y
        if (s != 0.0) {
            r12.y -= m1 * s
            r22.y -= m2 * s
            r32.y -= m3 * s
        }
        s = r02.z
        if (s != 0.0) {
            r12.z -= m1 * s
            r22.z -= m2 * s
            r32.z -= m3 * s
        }
        s = r02.w
        if (s != 0.0) {
            r12.w -= m1 * s
            r22.w -= m2 * s
            r32.w -= m3 * s
        }

        /* choose pivot - or die */
        if (abs(r31.y) > abs(r21.y)) {
            swap1 = r31
            swap2 = r32
            r31 = r21
            r32 = r22
            r21 = swap1
            r22 = swap2
        }
        if (abs(r21.y) > abs(r11.y)) {
            swap1 = r21
            swap2 = r22
            r21 = r11
            r22 = r12
            r11 = swap1
            r12 = swap2
        }
        check(r11.y != 0.0)

        /* eliminate second variable */
        m2 = r21.y / r11.y
        m3 = r31.y / r11.y
        r21.z -= m2 * r11.z
        r31.z -= m3 * r11.z
        r21.w -= m2 * r11.w
        r31.w -= m3 * r11.w
        s = r12.x
        if (0.0 != s) {
            r22.x -= m2 * s
            r32.x -= m3 * s
        }
        s = r12.y
        if (0.0 != s) {
            r22.y -= m2 * s
            r32.y -= m3 * s
        }
        s = r12.z
        if (0.0 != s) {
            r22.z -= m2 * s
            r32.z -= m3 * s
        }
        s = r12.w
        if (0.0 != s) {
            r22.w -= m2 * s
            r32.w -= m3 * s
        }

        /* choose pivot - or die */
        if (abs(r31.z) > abs(r21.z)) {
            swap1 = r31
            swap2 = r32
            r31 = r21
            r32 = r22
            r21 = swap1
            r22 = swap2
        }
        check(r21.z != 0.0)

        /* eliminate third variable */
        m3 = r31.z / r21.z
        r31.w -= m3 * r21.w
        r32.x -= m3 * r22.x
        r32.y -= m3 * r22.y
        r32.z -= m3 * r22.z
        r32.w -= m3 * r22.w

        /* last check */
        check(r31.w != 0.0)

        s = 1.0 / r31.w /* now back substitute row 3 */
        r32.x *= s
        r32.y *= s
        r32.z *= s
        r32.w *= s

        m2 = r21.w /* now back substitute row 2 */
        s = 1.0 / r21.z
        r22.x = s * (r22.x - r32.x * m2)
        r22.y = s * (r22.y - r32.y * m2)
        r22.z = s * (r22.z - r32.z * m2)
        r22.w = s * (r22.w - r32.w * m2)
        m1 = r11.w
        r12.x -= r32.x * m1
        r12.y -= r32.y * m1
        r12.z -= r32.z * m1
        r12.w -= r32.w * m1
        m0 = r01.w
        r02.x -= r32.x * m0
        r02.y -= r32.y * m0
        r02.z -= r32.z * m0
        r02.w -= r32.w * m0

        m1 = r11.z /* now back substitute row 1 */
        s = 1.0 / r11.y
        r12.x = s * (r12.x - r22.x * m1)
        r12.y = s * (r12.y - r22.y * m1)
        r12.z = s * (r12.z - r22.z * m1)
        r12.w = s * (r12.w - r22.w * m1)
        m0 = r01.z
        r02.x -= r22.x * m0
        r02.y -= r22.y * m0
        r02.z -= r22.z * m0
        r02.w -= r22.w * m0

        m0 = r01.y /* now back substitute row 0 */
        s = 1.0 / r01.x
        r02.x = s * (r02.x - r12.x * m0)
        r02.y = s * (r02.y - r12.y * m0)
        r02.z = s * (r02.z - r12.z * m0)
        r02.w = s * (r02.w - r12.w * m0)

        _x.x = r02.x
        _x.y = r02.y
        _x.z = r02.z
        _x.w = r02.w
        _y.x = r12.x
        _y.y = r12.y
        _y.z = r12.z
        _y.w = r12.w
        _z.x = r22.x
        _z.y = r22.y
        _z.z = r22.z
        _z.w = r22.w
        _w.x = r32.x
        _w.y = r32.y
        _w.z = r32.z
        _w.w = r32.w
    }

    /**
     * Returns a Projection that performs the inverse of this Projection's projective transformation.
     */
    fun inverse() = Projection(this).also {
        it.invert()
    }

    fun xform4(plane: Plane) = Plane(
        Vector3(
            _x.x * plane.normal.x + _y.x * plane.normal.y + _z.x * plane.normal.z + _w.x * plane.d,
            _x.y * plane.normal.x + _y.y * plane.normal.y + _z.y * plane.normal.z + _w.y * plane.d,
            _x.z * plane.normal.x + _y.z * plane.normal.y + _z.z * plane.normal.z + _w.z * plane.d
        ),
        _x.w * plane.normal.x + _y.w * plane.normal.y + _z.w * plane.normal.z + _w.w * plane.d
    )

    fun xform(vec3: Vector3): Vector3 {
        val ret = Vector3(
            _x.x * vec3.x + _y.x * vec3.y + _z.x * vec3.z + _w.x,
            _x.y * vec3.x + _y.y * vec3.y + _z.y * vec3.z + _w.y,
            _x.z * vec3.x + _y.z * vec3.y + _z.z * vec3.z + _w.z
        )
        val w: RealT = _x.w * vec3.x + _y.w * vec3.y + _z.w * vec3.z + _w.w
        return ret / w
    }

    @Suppress("DuplicatedCode")
    fun xform(vec4: Vector4) = Vector4(
        _x.x * vec4.x + _y.x * vec4.y + _z.x * vec4.z + _w.x * vec4.w,
        _x.y * vec4.x + _y.y * vec4.y + _z.y * vec4.z + _w.y * vec4.w,
        _x.z * vec4.x + _y.z * vec4.y + _z.z * vec4.z + _w.z * vec4.w,
        _x.w * vec4.x + _y.w * vec4.y + _z.w * vec4.z + _w.w * vec4.w
    )

    @Suppress("DuplicatedCode")
    fun xformInv(vec4: Vector4) = Vector4(
        _x.x * vec4.x + _x.y * vec4.y + _x.z * vec4.z + _x.w * vec4.w,
        _y.x * vec4.x + _y.y * vec4.y + _y.z * vec4.z + _y.w * vec4.w,
        _z.x * vec4.x + _z.y * vec4.y + _z.z * vec4.z + _z.w * vec4.w,
        _w.x * vec4.x + _w.y * vec4.y + _w.z * vec4.z + _w.w * vec4.w
    )

    fun scaleTranslateToFit(pAabb: AABB) {
        val min: Vector3 = pAabb.position
        val max: Vector3 = pAabb.position + pAabb.size

        _x.x = 2 / (max.x - min.x)
        _y.x = 0.0
        _z.x = 0.0
        _w.x = -(max.x + min.x) / (max.x - min.x)

        _x.y = 0.0
        _y.y = 2 / (max.y - min.y)
        _z.y = 0.0
        _w.y = -(max.y + min.y) / (max.y - min.y)

        _x.z = 0.0
        _y.z = 0.0
        _z.z = 2 / (max.z - min.z)
        _w.z = -(max.z + min.z) / (max.z - min.z)

        _x.w = 0.0
        _y.w = 0.0
        _z.w = 0.0
        _w.w = 1.0
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun addJitterOffset(pOffset: Vector2) {
        _w.x += pOffset.x
        _w.y += pOffset.y
    }

    fun makeScale(scale: Vector3) {
        setIdentity()
        _x.x = scale.x
        _y.y = scale.y
        _z.z = scale.z
    }

    /**
     * Returns the number of pixels with the given pixel width displayed per meter, after this Projection is applied.
     */
    fun getPixelPerMeter(pixelWidth: Int): Int {
        val result = xform(Vector3(1, 0, -1))
        return ((result.x * 0.5 + 0.5) * pixelWidth).toInt()
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun flipY() {
        for (i in 0..3) {
            _y[i] = -_y[i]
        }
    }

    /**
     * Returns the factor by which the visible level of detail is scaled by this Projection.
     */
    fun getLodMultiplier() = if (isOrthogonal()) {
        getViewportHalfExtents().x
    } else {
        val zNear = getZNear()
        val width = getViewportHalfExtents().x * 2.0
        1.0 / (zNear / width)
    }

    /**
     * Returns a Projection that applies the combined transformations of this Projection and `right`.
     */
    operator fun times(matrix: Projection): Projection {
        val newMatrix = Projection()

        for (j in 0..3) {
            for (i in 0..3) {
                var ab: RealT = 0.0
                for (k in 0..3) {
                    ab += this[k][i] * matrix[j][k]
                }
                newMatrix.setMatrixElement(j, i, ab)
            }
        }

        return newMatrix
    }

    /**
     * Returns `true` if the projections are equal.
     *
     * Note: Due to floating-point precision errors, this may return `false`, even if the projections are virtually equal.
     * An `isEqualApprox` method may be added in a future version of Godot.
     */
    override fun equals(other: Any?): Boolean = when (other) {
        is Projection -> (_x == other._x && _y == other._y && _z == other._z && _w == other._w)
        else -> false
    }

    override fun hashCode(): Int {
        var result = _x.hashCode()
        result = 31 * result + _y.hashCode()
        result = 31 * result + _z.hashCode()
        result = 31 * result + _w.hashCode()
        return result
    }

    fun toTransform3D(): Transform3D {
        val transform = Transform3D()

        transform.basis._x.x = _x.x
        transform.basis._y.x = _x.y
        transform.basis._z.x = _x.z

        transform.basis._x.y = _y.x
        transform.basis._y.y = _y.y
        transform.basis._z.y = _y.z

        transform.basis._x.z = _z.x
        transform.basis._y.z = _z.y
        transform.basis._z.z = _z.z

        transform.origin.x = _w.x
        transform.origin.y = _w.y
        transform.origin.z = _w.z

        return transform
    }

    override fun toString() = buildString {
        append("[X: ")
        append(_x)
        append(", Y: ")
        append(_y)
        append(", Z: ")
        append(_z)
        append(", W: ")
        append(_w)
        append("]")
    }

    private fun set(projection: Projection) {
        this._x = projection._x
        this._y = projection._y
        this._z = projection._z
        this._w = projection._w
    }

    private fun setMatrixElement(i: Int, j: Int, value: RealT) {
        val row = when (i) {
            0 -> _x
            1 -> _y
            2 -> _z
            3 -> _w
            else -> throw IndexOutOfBoundsException()
        }
        when (j) {
            0 -> row.x = value
            1 -> row.y = value
            2 -> row.z = value
            3 -> row.w = value
            else -> throw IndexOutOfBoundsException()
        }
    }

    companion object {
        /**
         * Creates a new `Projection` that projects positions from a depth range of -1 to 1 to one that ranges from
         * 0 to 1, and flips the projected positions vertically, according to flip_y.
         */
        fun createDepthCorrection(pFlipY: Boolean) = Projection().also {
            it.setDepthCorrection(pFlipY)
        }

        /**
         * Creates a new Projection that projects positions into the given Rect2.
         */
        fun createLightAtlasRect(pRect: Rect2) = Projection().also {
            it.setLightAtlasRect(pRect)
        }

        /**
         * Creates a new Projection that projects positions using a perspective projection with the given Y-axis field
         * of view (in degrees), X:Y aspect ratio, and clipping planes.
         *
         * flipFov determines whether the projection's field of view is flipped over its diagonal.
         */
        fun createPerspective(pFovyDegrees: RealT, aspect: RealT, zNear: RealT, zFar: RealT, flipFov: Boolean = false) =
            Projection().also {
                it.setPerspective(pFovyDegrees, aspect, zNear, zFar, flipFov)
            }

        /**
         * Creates a new Projection that projects positions using a perspective projection with the given Y-axis field
         * of view (in degrees), X:Y aspect ratio, anxd clipping distances. The projection is adjusted for a head-mounted
         * display with the given distance between eyes and distance to a point that can be focused on.
         *
         * eye creates the projection for the left eye when set to 1, or the right eye when set to 2.
         *
         * flipFov determines whether the projection's field of view is flipped over its diagonal.
         */
        fun createPerspectiveHmd(
            pFovyDegrees: RealT,
            aspect: RealT,
            zNear: RealT,
            zFar: RealT,
            flipFov: Boolean,
            eye: Int,
            intraocularDist: RealT,
            convergenceDist: RealT
        ) = Projection().also {
            it.setPerspective(
                pFovyDegrees,
                aspect,
                zNear,
                zFar,
                flipFov,
                eye,
                intraocularDist,
                convergenceDist
            )
        }

        /**
         * Creates a new Projection for projecting positions onto a head-mounted display with the given X:Y aspect
         * ratio, distance between eyes, display width, distance to lens, oversampling factor, and depth clipping
         * planes.
         *
         * eye creates the projection for the left eye when set to 1, or the right eye when set to 2.
         */
        fun createForHmd(
            pEye: Int,
            pAspect: RealT,
            pIntraocularDist: RealT,
            pDisplayWidth: RealT,
            pDisplayToLens: RealT,
            pOversample: RealT,
            pZNear: RealT,
            pZFar: RealT
        ) = Projection().also {
            it.setForHmd(pEye, pAspect, pIntraocularDist, pDisplayWidth, pDisplayToLens, pOversample, pZNear, pZFar)
        }

        /**
         * Creates a new Projection that projects positions using an orthogonal projection with the given clipping
         * planes.
         */
        fun createOrthogonal(pLeft: RealT, pRight: RealT, pBottom: RealT, pTop: RealT, pZnear: RealT, pZfar: RealT) =
            Projection().also {
                it.setOrthogonal(pLeft, pRight, pBottom, pTop, pZnear, pZfar)
            }

        /**
         * Creates a new Projection that projects positions using an orthogonal projection with the given size, X:Y
         * aspect ratio, and clipping planes.
         *
         * flipFov determines whether the projection's field of view is flipped over its diagonal.
         */
        fun createOrthogonalAspect(pSize: RealT, pAspect: RealT, pZnear: RealT, pZfar: RealT, pFlipFov: Boolean) =
            Projection().also {
                it.setOrthogonal(pSize, pAspect, pZnear, pZfar, pFlipFov)
            }

        /**
         * Creates a new Projection that projects positions in a frustum with the given clipping planes.
         */
        fun createFrustrum(left: RealT, right: RealT, bottom: RealT, top: RealT, near: RealT, far: RealT) =
            Projection().also {
                it.setFrustrum(left, right, bottom, top, near, far)
            }

        /**
         * Creates a new Projection that projects positions in a frustum with the given size, X:Y aspect ratio, offset,
         * and clipping planes.
         *
         * flipFov determines whether the projection's field of view is flipped over its diagonal.
         */
        fun createFrustrumAspect(
            pSize: RealT,
            aspect: RealT,
            offset: Vector2,
            near: RealT,
            far: RealT,
            flipFov: Boolean
        ) = Projection().also {
            it.setFrustrum(pSize, aspect, offset, near, far, flipFov)
        }

        /**
         * Creates a new Projection that scales a given projection to fit around a given AABB in projection space.
         */
        fun createFitAabb(pAabb: AABB) = Projection().also {
            it.scaleTranslateToFit(pAabb)
        }

        /**
         * Returns the vertical field of view of the projection (in degrees) associated with the given horizontal field
         * of view (in degrees) and aspect ratio.
         */
        fun getFovy(fovx: RealT, aspect: RealT): RealT = Math.toDegrees(
            atan(
                aspect * tan(Math.toRadians(fovx) * 0.5)
            ) * 2.0
        )
    }
}
