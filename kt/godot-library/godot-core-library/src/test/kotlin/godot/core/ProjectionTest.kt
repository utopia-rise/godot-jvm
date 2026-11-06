@file:Suppress("RemoveRedundantBackticks")

package godot.core

import godot.common.util.isEqualApprox
import org.junit.Test

class ProjectionTest {

    @Test
    fun `Default construct`() {
        val p = Projection()
        check(p._x.x == 1.0)
        check(p._x.y == 0.0)
        check(p._x.z == 0.0)
        check(p._x.w == 0.0)
        check(p._y.x == 0.0)
        check(p._y.y == 1.0)
        check(p._y.z == 0.0)
        check(p._y.w == 0.0)
        check(p._z.x == 0.0)
        check(p._z.y == 0.0)
        check(p._z.z == 1.0)
        check(p._z.w == 0.0)
        check(p._w.x == 0.0)
        check(p._w.y == 0.0)
        check(p._w.z == 0.0)
        check(p._w.w == 1.0)
    }

    private fun projectionIsEqualApprox(p_a: Projection, p_b: Projection): Boolean {
        for (i in 0..3) {
            for (j in 0..3) {
            if (!(p_a[i][j]).isEqualApprox(p_b[i][j])) {
                return false
            }
        }
        }
        return true
    }

    @Test
    fun `Orthogonal projection matrix inversion`() {
        val p = Projection.createOrthogonal(-125.0, 125.0, -125.0, 125.0, 0.01, 25.0)
        check(projectionIsEqualApprox(p.inverse() * p, Projection()))
    }

    @Test
    fun `Perspective projection matrix inversion`() {
        val p = Projection.createPerspective(90.0, 1.77777, 0.05, 4000.0)
        check(projectionIsEqualApprox(p.inverse() * p, Projection()))
    }

    @Test
    fun `Set column copies the vector`() {
        val projection = Projection()
        val vector = Vector4(1, 2, 3, 4)
        for (index in 0..3) {
            projection[index] = vector
        }
        vector.x = 99.0
        for (index in 0..3) {
            checkTrue(projection[index] == Vector4(1, 2, 3, 4))
        }
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Projection.createPerspective(60.0, 1.5, 0.1, 100.0)
        val b = Projection.createOrthogonal(-2.0, 2.0, -1.0, 1.0, 0.1, 100.0)
        val aCopy = Projection(a)
        val bCopy = Projection(b)

        val operations = listOf<() -> Any>(
            { a * b },
            { a.inverse() },
            { a.flippedY() },
            { a.jitterOffseted(Vector2(0.1, 0.2)) },
            { a.perspectiveZnearAdjusted(0.2) },
            { a.xform(Vector3(1, 2, 3)) },
            { a.xform(Vector4(1, 2, 3, 4)) },
            { a.xform4(Plane(Vector3(0, 1, 0), 1.0)) },
            { a.xformInv(Vector4(1, 2, 3, 4)) },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }

    private fun obliquePerspective() = Projection(
        Vector4(1, 0, 0, 2),
        Vector4(0, 1, 0, 0),
        Vector4(0, 0, -3, -1),
        Vector4(0, 0, -4, 0)
    )

    private fun checkNear(actual: Double, expected: Double) {
        checkMessage(kotlin.math.abs(actual - expected) < 1e-4) { "expected $expected but was $actual" }
    }

    @Test
    fun `Construct from Transform3D uses basis columns`() {
        val transform = Transform3D(Basis(1, 2, 3, 4, 5, 6, 7, 8, 9), Vector3(10, 11, 12))
        val projection = Projection(transform)
        checkTrue(projection[0] == Vector4(1, 4, 7, 0))
        checkTrue(projection[1] == Vector4(2, 5, 8, 0))
        checkTrue(projection[2] == Vector4(3, 6, 9, 0))
        checkTrue(projection[3] == Vector4(10, 11, 12, 1))
    }

    @Test
    fun `toTransform3D returns the converted transform`() {
        val transform = Transform3D(Basis(1, 2, 3, 4, 5, 6, 7, 8, 9), Vector3(10, 11, 12))
        checkTrue(Projection(transform).toTransform3D() == transform)
    }

    @Test
    fun `Determinant keeps double precision`() {
        val projection = Projection(
            Vector4(0.1, 0, 0, 0),
            Vector4(0, 0.1, 0, 0),
            Vector4(0, 0, 0.1, 0),
            Vector4(0, 0, 0, 0.1)
        )
        checkTrue(projection.determinant() == 0.1 * 0.1 * 0.1 * 0.1)
    }

    @Test
    fun `Depth correction defaults reverse and remap Z`() {
        val projection = Projection.createDepthCorrection(true)
        checkTrue(projection[1].y == -1.0)
        checkTrue(projection[2].z == -0.5)
        checkTrue(projection[3].z == 0.5)

        val plain = Projection()
        plain.setDepthCorrection(false, false, false)
        checkTrue(plain[1].y == 1.0)
        checkTrue(plain[2].z == 1.0)
        checkTrue(plain[3].z == 0.0)
    }

    @Test
    fun `Z near and far use the matrix terms`() {
        val projection = obliquePerspective()
        checkNear(projection.getZNear(), 1.0)
        checkNear(projection.getZFar(), 2.0)
    }

    @Test
    fun `Aspect is the ratio of the diagonal terms`() {
        val projection = Projection(
            Vector4(2, 0, 0, 0),
            Vector4(0, 3, 0, 0),
            Vector4(0, 0, 1, 0),
            Vector4(0, 0, 0, 1)
        )
        checkNear(projection.getAspect(), 1.5)
    }

    @Test
    fun `Fov of an asymmetric frustum`() {
        val projection = Projection(
            Vector4(1, 0, 0, 0),
            Vector4(0, 1, 0, 0),
            Vector4(0.5, 0, 1, 0),
            Vector4(0, 0, 0, 1)
        )
        checkNear(projection.getFov(), 82.8750)
    }

    @Test
    fun `Fov ignores the vertical skew`() {
        val projection = Projection(
            Vector4(1, 0, 0, 0),
            Vector4(0, 1, 0, 0),
            Vector4(0, 0.5, 1, 0),
            Vector4(0, 0, 0, 1)
        )
        checkNear(projection.getFov(), 90.0)
    }

    @Test
    fun `isOrthogonal reads the Z row W term`() {
        val perspectiveLike = Projection(
            Vector4(1, 0, 0, 0),
            Vector4(0, 1, 0, 0),
            Vector4(0, 0, 1, -1),
            Vector4(0, 0, 0, 1)
        )
        checkFalse(perspectiveLike.isOrthogonal())

        val orthogonalLike = Projection(
            Vector4(1, 0, 0, 0),
            Vector4(0, 1, 0, 0),
            Vector4(0, 0, 1, 0),
            Vector4(0, 0, 0, 0)
        )
        checkTrue(orthogonalLike.isOrthogonal())
    }

    @Test
    fun `Half extents use the matrix terms`() {
        val projection = obliquePerspective()
        val near = projection.getViewportHalfExtents()
        checkNear(near.x, 1.0)
        checkNear(near.y, 1.0)
        val far = projection.getFarPlaneHalfExtents()
        checkNear(far.x, 2.0)
        checkNear(far.y, 2.0)
    }

    @Test
    fun `Pixels per meter uses the viewport width`() {
        val projection = Projection.createPerspective(90.0, 1.0, 1.0, 10.0)
        checkTrue(projection.getPixelPerMeter(100) == 50)
        checkTrue(projection.getPixelPerMeter(101) == 50)
    }

    @Test
    fun `Lod multiplier is two over the X scale`() {
        val projection = Projection.createOrthogonal(-4.0, 4.0, -2.0, 2.0, 1.0, 10.0)
        checkNear(projection.getLodMultiplier(), 8.0)
    }

    @Test
    fun `Multiply by a Vector4 projects it`() {
        val projection = Projection()
        projection.makeScale(Vector3(2, 3, 4))
        checkTrue(projection * Vector4(1, 1, 1, 1) == Vector4(2, 3, 4, 1))
    }

    @Test
    fun `Identity and zero constants`() {
        checkTrue(Projection.IDENTITY == Projection())
        checkTrue(Projection.ZERO[0] == Vector4())
        checkTrue(Projection.ZERO[1] == Vector4())
        checkTrue(Projection.ZERO[2] == Vector4())
        checkTrue(Projection.ZERO[3] == Vector4())
    }

    @Test
    fun `Frustum with invalid bounds leaves the identity`() {
        checkTrue(Projection.createFrustrum(1.0, 0.0, -1.0, 1.0, 0.1, 10.0) == Projection.IDENTITY)
        checkTrue(Projection.createFrustrum(-1.0, 1.0, 1.0, 1.0, 0.1, 10.0) == Projection.IDENTITY)
        checkTrue(Projection.createFrustrum(-1.0, 1.0, -1.0, 1.0, 5.0, 5.0) == Projection.IDENTITY)
        checkTrue(Projection.createFrustrumAspect(0.0, 1.0, Vector2(), 0.1, 10.0) == Projection.IDENTITY)
    }

    @Test
    fun `Invalid frustum leaves an existing projection unchanged`() {
        val projection = Projection.createOrthogonal(-4.0, 4.0, -2.0, 2.0, 1.0, 10.0)
        projection.setFrustrum(1.0, 0.0, -1.0, 1.0, 0.1, 10.0)
        checkTrue(projection == Projection.createOrthogonal(-4.0, 4.0, -2.0, 2.0, 1.0, 10.0))
    }

    @Test
    fun `Hmd perspective with invalid depth range is identity for the mono eye`() {
        checkTrue(Projection.createPerspectiveHmd(90.0, 1.0, 10.0, 1.0, false, 0, 0.06, 1.0) == Projection.IDENTITY)
    }

    @Test
    fun `Inverse of a singular projection is an unchanged copy`() {
        checkTrue(Projection.ZERO.inverse() == Projection.ZERO)
        val singular = Projection()
        singular.makeScale(Vector3(1, 1, 0))
        val inverse = singular.inverse()
        checkTrue(inverse == singular)
        checkTrue(inverse !== singular)
    }

    @Test
    fun `Endpoints of a degenerate projection are null`() {
        checkTrue(Projection.ZERO.getEndpoints(Transform3D()) == null)
    }

    @Test
    fun `Orthogonal aspect flip fov defaults to false`() {
        val projection = Projection.createOrthogonalAspect(2.0, 2.0, 1.0, 10.0)
        checkNear(projection._x.x, 0.5)
        checkNear(projection._y.y, 1.0)
        checkNear(projection._z.z, -2.0 / 9.0)
        checkNear(projection._w.z, -11.0 / 9.0)
    }

    @Test
    fun `Frustum aspect flip fov defaults to false`() {
        val projection = Projection.createFrustrumAspect(2.0, 2.0, Vector2(), 1.0, 10.0)
        checkNear(projection._x.x, 0.5)
        checkNear(projection._y.y, 1.0)
        checkNear(projection._z.z, -11.0 / 9.0)
        checkNear(projection._w.z, -20.0 / 9.0)
    }
}
