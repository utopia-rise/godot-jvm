@file:Suppress("RemoveRedundantBackticks")

package godot.core

import godot.common.util.PI
import org.junit.Test

class TestTransform3D {

    private fun createDummyTransform(): Transform3D {
        return Transform3D(Basis(Vector3(1, 2, 3), Vector3(4, 5, 6), Vector3(7, 8, 9)), Vector3(10, 11, 12))
    }

    private fun identity(): Transform3D {
        return Transform3D()
    }

    @Test
    fun `Translation`() {
        val offset = Vector3(1, 2, 3)

        // Both versions should give the same result applied to identity.
        checkTrue(identity().translated(offset) == identity().apply { translate(offset) })

        // Check both versions against left and right multiplications.
        val orig = createDummyTransform()
        val T = identity().translated(offset)
        checkTrue(orig.translated(offset) == T * orig)
        checkTrue(orig.translatedLocal(offset) == orig * T)
    }

    @Test
    fun `Scaling`() {
        val scaling = Vector3(1, 2, 3)

        // Both versions should give the same result applied to identity.
        checkTrue(identity().scaled(scaling) == identity().apply { scale(scaling) })

        // Check both versions against left and right multiplications.
        val orig = createDummyTransform()
        val S = identity().scaled(scaling)
        checkTrue(orig.scaled(scaling) == S * orig)
        checkTrue(orig.scaledLocal(scaling) == orig * S)
    }

    @Test
    fun `Rotation`() {
        val axis = Vector3(1, 2, 3).normalized()
        val phi = 1.0

        // Both versions should give the same result applied to identity.
        checkTrue(identity().rotated(axis, phi) == identity().apply { rotate(axis, phi) })

        // Check both versions against left and right multiplications.
        val orig = createDummyTransform()
        val R = identity().rotated(axis, phi)
        checkTrue(orig.rotated(axis, phi) == R * orig)
        checkTrue(orig.rotatedLocal(axis, phi) == orig * R)
    }

    @Test
    fun `Finite number checks`() {
        val y = Vector3(0, 1, 2)
        val infiniteVec = Vector3(Double.NaN, Double.NaN, Double.NaN)
        val x = Basis(y, y, y)
        val infiniteBasis = Basis(infiniteVec, infiniteVec, infiniteVec)

        checkMessage(Transform3D(x, y).isFinite()) { "Transform3D with all components finite should be finite" }

        checkFalseMessage(Transform3D(x, infiniteVec).isFinite()) { "Transform3D with one component infinite should not be finite." }
        checkFalseMessage(Transform3D(infiniteBasis, y).isFinite()) { "Transform3D with one component infinite should not be finite." }
        checkFalseMessage(Transform3D(infiniteBasis, infiniteVec).isFinite()) { "Transform3D with two components infinite should not be finite." }
    }

    @Test
    fun `Rotate around global origin`() {
        // Start with the default orientation, but not centered on the origin.
        // Rotating should rotate both our basis and the origin.
        val transform = Transform3D()
        transform._origin = Vector3(0, 0, 1)

        val expected = Transform3D()
        expected._origin = Vector3(0, 0, -1)
        expected._basis._x = Vector3(-1, 0, 0)
        expected._basis._z = Vector3(0, 0, -1)

        val rotatedTransform = transform.rotated(Vector3(0, 1, 0), PI)
        checkMessage(rotatedTransform.isEqualApprox(expected)) { "The rotated transform should have a new orientation and basis." }
    }


    @Test
    fun `Rotate in-place (local rotation`() {
        // Start with the default orientation.
        // Local rotation should not change the origin, only the basis.
        val transform = Transform3D()
        transform._origin = Vector3(1, 2, 3)

        val expected = Transform3D()
        expected._origin = Vector3(1, 2, 3)
        expected._basis._x = Vector3(-1, 0, 0)
        expected._basis._z = Vector3(0, 0, -1)

        val rotatedTransform = Transform3D(transform.rotatedLocal(Vector3(0, 1, 0), PI))
        checkMessage(rotatedTransform.isEqualApprox(expected)) { "The rotated transform should have a new orientation but still be based on the same origin." }
    }

    @Test
    fun `lookingAt with origin equal to target returns identity`() {
        val t = Transform3D(Basis(Vector3(1, 2, 3), Vector3(4, 5, 6), Vector3(7, 8, 9)), Vector3(1, 2, 3))
        val original = Transform3D(t)
        checkTrue(t.lookingAt(Vector3(1, 2, 3)) == Transform3D())
        checkTrue(t == original)
    }

    @Test
    fun `setLookAt with eye equal to target leaves the transform unchanged`() {
        val t = createDummyTransform()
        val original = Transform3D(t)
        t.setLookAt(Vector3(1, 1, 1), Vector3(1, 1, 1), Vector3(0, 1, 0), false)
        checkTrue(t == original)
    }

    @Test
    fun `lookingAt keeps the origin and faces the target`() {
        val t = Transform3D(Basis(), Vector3(0, 0, 5)).lookingAt(Vector3(0, 0, 0))
        checkTrue(t.origin == Vector3(0, 0, 5))
        checkTrue(t.basis.isEqualApprox(Basis()))
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = identity().rotated(Vector3(0, 1, 0), 0.3).scaled(Vector3(1, 2, 3)).translated(Vector3(1, 1, 1))
        val b = identity().rotated(Vector3(1, 2, 3).normalized(), 1.0).translated(Vector3(4, 5, 6))
        val aCopy = Transform3D(a)
        val bCopy = Transform3D(b)

        val operations = listOf<() -> Any>(
            { a * b },
            { a * 2.0 },
            { a / 2.0 },
            { a.inverse() },
            { a.affineInverse() },
            { a.orthonormalized() },
            { a.scaled(Vector3(1, 2, 3)) },
            { a.scaledLocal(Vector3(1, 2, 3)) },
            { a.rotated(Vector3(0, 1, 0), 1.0) },
            { a.rotatedLocal(Vector3(0, 1, 0), 1.0) },
            { a.translated(Vector3(1, 2, 3)) },
            { a.translatedLocal(Vector3(1, 2, 3)) },
            { a.orthonormalized().interpolateWith(b, 0.5) },
            { a.xform(Vector3(1, 2, 3)) },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }

    @Test
    fun `Multiplication returns a new transform`() {
        val a = createDummyTransform()
        val b = identity().rotated(Vector3(1, 2, 3).normalized(), 1.0).translated(Vector3(4, 5, 6))
        val aCopy = Transform3D(a)
        val bCopy = Transform3D(b)

        val product = a * b
        checkTrue(product !== a)
        checkTrue(product !== b)
        checkTrue(product == Transform3D(aCopy.basis * bCopy.basis, aCopy.xform(bCopy.origin)))
        checkTrue(a == aCopy)

        product.origin = Vector3(9, 9, 9)
        checkTrue(a == aCopy)
        checkTrue(b == bCopy)
    }

    @Test
    fun `interpolateWith keeps rotation times scale order`() {
        val t = Transform3D(Basis(0, -2, 0, 1, 0, 0, 0, 0, 1), Vector3(1, 2, 3))
        val result = t.interpolateWith(Transform3D(t), 0.5)
        checkTrue(result.basis.isEqualApprox(Basis(0, -2, 0, 1, 0, 0, 0, 0, 1)))
        checkTrue(result.origin.isEqualApprox(Vector3(1, 2, 3)))
    }

    @Test
    fun `xform AABB uses basis columns`() {
        val rotation = Transform3D(Basis(0, -1, 0, 1, 0, 0, 0, 0, 1))
        val result = rotation.xform(AABB(Vector3(0, 0, 0), Vector3(1, 2, 3)))
        checkTrue(result.isEqualApprox(AABB(Vector3(-2, 0, 0), Vector3(2, 1, 3))))
    }

    @Test
    fun `xform Plane uses inverse transpose for the normal`() {
        val t = Transform3D(Basis(2, 0, 0, 0, 1, 0, 0, 0, 1))
        val result = t.xform(Plane(Vector3(1, 1, 0).normalized(), 0))
        checkTrue(result.isEqualApprox(Plane(Vector3(1, 2, 0).normalized(), 0)))
        val shifted = t.xform(Plane(Vector3(1, 1, 0).normalized(), 1))
        val n = Vector3(1, 2, 0).normalized()
        val point = Vector3(2, 1, 0) * (1 / Vector3(1, 1, 0).length())
        checkTrue(shifted.isEqualApprox(Plane(n, n.dot(point))))
    }

    @Test
    fun `xformInv Plane uses affine inverse for the point`() {
        val t = Transform3D(Basis(2, 0, 0, 0, 1, 0, 0, 0, 1))
        val normal = Vector3(1, 0, 0)
        val result = t.xformInv(Plane(normal, 1))
        checkTrue(result.isEqualApprox(Plane(Vector3(1, 0, 0), 0.5)))
    }

    @Test
    fun `Constructor from Projection drops the w row`() {
        val projection = Projection(
            Vector4(1, 2, 3, 40),
            Vector4(4, 5, 6, 50),
            Vector4(7, 8, 9, 60),
            Vector4(10, 11, 12, 70)
        )
        val t = Transform3D(projection)
        checkTrue(t == Transform3D(Basis(Vector3(1, 2, 3), Vector3(4, 5, 6), Vector3(7, 8, 9)), Vector3(10, 11, 12)))
        checkTrue(t.basis.x == Vector3(1, 2, 3))
        checkTrue(t.origin == Vector3(10, 11, 12))
    }

    @Test
    fun `Constructor from Projection round trips with toTransform3D`() {
        val original = createDummyTransform()
        checkTrue(Transform3D(Projection(original)) == original)
        checkTrue(Projection(original).toTransform3D() == original)
    }

    @Test
    fun `times Plane equals xform Plane`() {
        val t = Transform3D(Basis(2, 0, 0, 0, 1, 0, 0, 0, 1), Vector3(1, 0, 0))
        val result = t * Plane(Vector3(1, 0, 0), 1)
        checkTrue(result.isEqualApprox(Plane(Vector3(1, 0, 0), 3)))
    }

    @Test
    fun `Plane times Transform3D is the inverse transform`() {
        val t = Transform3D(Basis(2, 0, 0, 0, 1, 0, 0, 0, 1), Vector3(1, 0, 0))
        val result = Plane(Vector3(1, 0, 0), 3) * t
        checkTrue(result.isEqualApprox(Plane(Vector3(1, 0, 0), 1)))
    }

    @Test
    fun `isEqualApprox takes its tolerance from the receiver`() {
        val a = Transform3D(Basis(1.0, 0, 0, 0, 1, 0, 0, 0, 1))
        val b = Transform3D(Basis(1.0 + 1.000005e-5, 0, 0, 0, 1, 0, 0, 0, 1))
        checkFalse(a.isEqualApprox(b))
        checkTrue(b.isEqualApprox(a))
    }
}
