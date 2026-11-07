package godot.core

import godot.common.util.PI
import godot.common.util.SQRT12
import org.junit.Test

class TestBasis {
    private fun degToRad(pRotation: Vector3): Vector3 {
        return pRotation / 180.0 * PI
    }

    private fun radToDeg(pRotation: Vector3): Vector3 {
        return pRotation / PI * 180.0
    }

    private fun getRotOrderName(ro: EulerOrder): String {
        return when (ro) {
            EulerOrder.XYZ -> "XYZ"
            EulerOrder.XZY -> "XZY"
            EulerOrder.YZX -> "YZX"
            EulerOrder.YXZ -> "YXZ"
            EulerOrder.ZXY -> "ZXY"
            EulerOrder.ZYX -> "ZYX"
        }
    }

    private fun testRotation(degOriginalEuler: Vector3, rotOrder: EulerOrder) {
        // This test:
        // 1. Converts the rotation vector from deg to rad.
        // 2. Converts euler to basis.
        // 3. Converts the above basis back into euler.
        // 4. Converts the above euler into basis again.
        // 5. Compares the basis obtained in step 2 with the basis of step 4
        //
        // The conversion "basis to euler", done in the step 3, may be different from
        // the original euler, even if the final rotation are the same.
        // This happens because there are more ways to represents the same rotation,
        // both valid, using eulers.
        // For this reason is necessary to convert that euler back to basis and finally
        // compares it.
        //
        // In this way we can assert that both functions: basis to euler / euler to basis
        // are correct.

        // Euler to rotation
        val originalEuler = degToRad(degOriginalEuler)
        val toRotation = Basis.fromEuler(originalEuler, rotOrder)

        // Euler from rotation
        val eulerFromRotation = toRotation.getEuler(rotOrder)
        val rotationFromComputedEuler = Basis.fromEuler(eulerFromRotation, rotOrder)

        val res = toRotation.inverse() * rotationFromComputedEuler

        checkMessage((res.getColumn(0) - Vector3(1.0, 0.0, 0.0)).length() <= 0.001) { "Fail due to X ${res.getColumn(0)}" }
        checkMessage((res.getColumn(1) - Vector3(0.0, 1.0, 0.0)).length() <= 0.001) { "Fail due to Y ${res.getColumn(1)}" }
        checkMessage((res.getColumn(2) - Vector3(0.0, 0.0, 1.0)).length() <= 0.001) { "Fail due to Z ${res.getColumn(2)}" }

        // Double check `toRotation` decomposing with XYZ rotation order.
        val eulerXyzFromRotation = toRotation.getEuler(EulerOrder.XYZ)
        val rotationFromXyzComputedEuler = Basis.fromEuler(eulerXyzFromRotation, EulerOrder.XYZ)

        val res2 = toRotation.inverse() * rotationFromXyzComputedEuler

        checkMessage((res2.getColumn(0) - Vector3(1.0, 0.0, 0.0)).length() <= 0.001) { "Double check with XYZ rot order failed, due to X ${res2.getColumn(0)}" }
        checkMessage((res2.getColumn(1) - Vector3(0.0, 1.0, 0.0)).length() <= 0.001) { "Double check with XYZ rot order failed, due to Y ${res2.getColumn(1)}" }
        checkMessage((res2.getColumn(2) - Vector3(0.0, 0.0, 1.0)).length() <= 0.001) { "Double check with XYZ rot order failed, due to Z ${res2.getColumn(2)}" }

        println("Rotation order: ${getRotOrderName(rotOrder)}.")
        println("Original Rotation: $degOriginalEuler")
        println("Quaternion to rotation order: ${radToDeg(eulerFromRotation)}")

    }

    @Test
    fun `Euler conversions`() {
        val eulerOrderToTest = listOf(
            EulerOrder.XYZ,
            EulerOrder.XZY,
            EulerOrder.YZX,
            EulerOrder.YXZ,
            EulerOrder.ZXY,
            EulerOrder.ZYX
        )

        val vectorsToTest = mutableListOf(
            Vector3(0.0, 0.0, 0.0),
            Vector3(0.5, 0.5, 0.5),
            Vector3(-0.5, -0.5, -0.5),
            Vector3(40.0, 40.0, 40.0),
            Vector3(-40.0, -40.0, -40.0),
            Vector3(0.0, 0.0, -90.0),
            Vector3(0.0, -90.0, 0.0),
            Vector3(-90.0, 0.0, 0.0),
            Vector3(0.0, 0.0, 90.0),
            Vector3(0.0, 90.0, 0.0),
            Vector3(90.0, 0.0, 0.0),
            Vector3(0.0, 0.0, -30.0),
            Vector3(0.0, -30.0, 0.0),
            Vector3(-30.0, 0.0, 0.0),
            Vector3(0.0, 0.0, 30.0),
            Vector3(0.0, 30.0, 0.0),
            Vector3(30.0, 0.0, 0.0),
            Vector3(0.5, 50.0, 20.0),
            Vector3(-0.5, -50.0, -20.0),
            Vector3(0.5, 0.0, 90.0),
            Vector3(0.5, 0.0, -90.0),
            Vector3(360.0, 360.0, 360.0),
            Vector3(-360.0, -360.0, -360.0),
            Vector3(-90.0, 60.0, -90.0),
            Vector3(90.0, 60.0, -90.0),
            Vector3(90.0, -60.0, -90.0),
            Vector3(-90.0, -60.0, -90.0),
            Vector3(-90.0, 60.0, 90.0),
            Vector3(90.0, 60.0, 90.0),
            Vector3(90.0, -60.0, 90.0),
            Vector3(-90.0, -60.0, 90.0),
            Vector3(60.0, 90.0, -40.0),
            Vector3(60.0, -90.0, -40.0),
            Vector3(-60.0, -90.0, -40.0),
            Vector3(-60.0, 90.0, 40.0),
            Vector3(60.0, 90.0, 40.0),
            Vector3(60.0, -90.0, 40.0),
            Vector3(-60.0, -90.0, 40.0),
            Vector3(-90.0, 90.0, -90.0),
            Vector3(90.0, 90.0, -90.0),
            Vector3(90.0, -90.0, -90.0),
            Vector3(-90.0, -90.0, -90.0),
            Vector3(-90.0, 90.0, 90.0),
            Vector3(90.0, 90.0, 90.0),
            Vector3(90.0, -90.0, 90.0),
            Vector3(20.0, 150.0, 30.0),
            Vector3(20.0, -150.0, 30.0),
            Vector3(-120.0, -150.0, 30.0),
            Vector3(-120.0, -150.0, -130.0),
            Vector3(120.0, -150.0, -130.0),
            Vector3(120.0, 150.0, -130.0),
            Vector3(120.0, 150.0, 130.0),
            Vector3(89.9, 0.0, 0.0),
            Vector3(-89.9, 0.0, 0.0),
            Vector3(0.0, 89.9, 0.0),
            Vector3(0.0, -89.9, 0.0),
            Vector3(0.0, 0.0, 89.9),
            Vector3(0.0, 0.0, -89.9),
        )

        for (rotOrder in eulerOrderToTest) {
            for (vector in vectorsToTest) {
                testRotation(vector, rotOrder)
            }
        }
    }

    @Test
    fun `Stress Euler conversions`() {
        val eulerOrderToTest = listOf(
            EulerOrder.XYZ,
            EulerOrder.XZY,
            EulerOrder.YZX,
            EulerOrder.YXZ,
            EulerOrder.ZXY,
            EulerOrder.ZYX
        )

        val vectorsToTest = mutableListOf<Vector3>()
        for (i in 0 until 1000) {
            vectorsToTest.add(
                Vector3(
                    (-1800..1800).random(),
                    (-1800..1800).random(),
                    (-1800..1800).random(),
                )
            )
        }

        for (rotOrder in eulerOrderToTest) {
            for (vector in vectorsToTest) {
                testRotation(vector, rotOrder)
            }
        }
    }


    @Test
    fun `Finite number checks`() {
        val x = Vector3(0.0, 1.0, 2.0)
        val infinite = Vector3(Double.NaN, Double.NaN, Double.NaN)

        checkMessage(Basis(x, x, x).isFinite()) { "Basis with all components finite should be finite" }

        checkFalseMessage(Basis(infinite, x, x).isFinite()) { "Basis with one component infinite should not be finite." }
        checkFalseMessage(Basis(x, infinite, x).isFinite()) { "Basis with one component infinite should not be finite." }
        checkFalseMessage(Basis(x, x, infinite).isFinite()) { "Basis with one component infinite should not be finite." }

        checkFalseMessage(Basis(infinite, infinite, x).isFinite()) { "Basis with two components infinite should not be finite." }
        checkFalseMessage(Basis(infinite, x, infinite).isFinite()) { "Basis with two components infinite should not be finite." }
        checkFalseMessage(Basis(x, infinite, infinite).isFinite()) { "Basis with two components infinite should not be finite." }

        checkFalseMessage(Basis(infinite, infinite, infinite).isFinite()) { "Basis with three components infinite should not be finite." }
    }

    @Test
    fun `Is conformal checks`() {
        checkMessage(Basis().isConformal()) { "Identity Basis should be conformal." }

        checkMessage(Basis.fromEuler(Vector3(1.2, 3.4, 5.6)).isConformal()) { "Basis with only rotation should be conformal." }

        checkMessage(Basis.fromScale(Vector3(-1.0, -1.0, -1.0)).isConformal()) { "Basis with only a flip should be conformal." }

        checkMessage(Basis.fromScale(Vector3(1.2, 1.2, 1.2)).isConformal()) { "Basis with only uniform scale should be conformal." }

        checkMessage(
            Basis(
                Vector3(3.0, 4.0, 0.0),
                Vector3(4.0, -3.0, 0.0),
                Vector3(0.0, 0.0, 5.0)
            ).isConformal()
        ) { "Basis with a flip, rotation, and uniform scale should be conformal." }

        checkFalseMessage(Basis.fromScale(Vector3(1.2, 3.4, 5.6)).isConformal()) { "Basis with non-uniform scale should not be conformal." }

        checkFalseMessage(
            Basis(
                Vector3(SQRT12, SQRT12, 0.0),
                Vector3(0.0, 1.0, 0.0),
                Vector3(0.0, 0.0, 1.0)
            ).isConformal()
        ) { "Basis with the X axis skewed 45 degrees should not be conformal." }


        checkMessage(
            Basis(0, 0, 0, 0, 0, 0, 0, 0, 0).isConformal()
        )
        { "Edge case: Basis with all zeroes should return true for is_conformal (because a 0 scale is uniform)." }
    }

    @Test
    fun `Is orthogonal checks`() {
        checkMessage(
            Basis().isOrthogonal()
        ) { "Identity Basis should be orthogonal." }

        checkMessage(
            Basis.fromEuler(Vector3(1.2, 3.4, 5.6)).isOrthogonal()
        ) { "Basis with only rotation should be orthogonal." }

        checkMessage(
            Basis.fromScale(Vector3(-1, -1, -1)).isOrthogonal()
        )
        { "Basis with only a flip should be orthogonal." }

        checkMessage(
            Basis.fromScale(Vector3(1.2, 3.4, 5.6)).isOrthogonal()
        )
        { "Basis with only scale should be orthogonal." }

        checkMessage(
            Basis(Vector3(3, 4, 0), Vector3(4, -3, 0), Vector3(0, 0, 5)).isOrthogonal()
        )
        { "Basis with a flip, rotation, and uniform scale should be orthogonal." }

        checkFalseMessage(
            Basis(Vector3(SQRT12, SQRT12, 0), Vector3(0, 1, 0), Vector3(0, 0, 1)).isOrthogonal()
        )
        { "Basis with the X axis skewed 45 degrees should not be orthogonal." }

        checkMessage(
            Basis(0, 0, 0, 0, 0, 0, 0, 0, 0).isOrthogonal()
        )
        { "Edge case: Basis with all zeroes should return true for is_orthogonal, since zero vectors are orthogonal to all vectors." }
    }

    @Test
    fun `Slerp checks`() {
        val from = Basis.fromEuler(Vector3(0.2, -0.4, 0.6))
        val to = Basis.fromEuler(Vector3(-1.1, 2.3, 0.9))

        checkMessage(from.slerp(to, 0.0).isEqualApprox(from)) { "Slerp with a weight of 0 should return the first Basis." }
        checkMessage(from.slerp(to, 1.0).isEqualApprox(to)) { "Slerp with a weight of 1 should return the second Basis." }
        checkMessage(from.slerp(from, 0.5).isEqualApprox(from)) { "Slerp between a Basis and itself should return that Basis." }

        for (weight in listOf(0.25, 0.5, 0.75)) {
            val interpolated = from.slerp(to, weight)

            checkMessage(
                interpolated.isEqualApprox(Basis(Quaternion(from).slerp(Quaternion(to), weight)))
            ) { "Slerp of two rotations should match the slerp of their quaternions at weight $weight." }

            checkMessage(interpolated.isRotation()) { "Slerp of two rotations should stay a rotation at weight $weight." }
        }
    }

    @Test
    fun `Is rotation checks`() {
        checkMessage(
            Basis().isRotation()
        ) { "Identity Basis should be a rotation (a rotation of zero)." }

        checkMessage(
            Basis.fromEuler(Vector3(1.2, 3.4, 5.6)).isRotation()
        ) { "Basis with only rotation should be a rotation." }

        checkFalseMessage(
            Basis.fromScale(Vector3(-1, -1, -1)).isRotation()
        ) { "Basis with only a flip should not be a rotation." }

        checkFalseMessage(
            Basis.fromScale(Vector3(1.2, 3.4, 5.6)).isRotation()
        ) { "Basis with only scale should not be a rotation." }

        checkFalseMessage(
            Basis(Vector3(2, 0, 0), Vector3(0, 0.5, 0), Vector3(0, 0, 1)).isRotation()
        ) { "Basis with a squeeze should not be a rotation." }

        checkFalseMessage(
            Basis(Vector3(SQRT12, SQRT12, 0), Vector3(0, 1, 0), Vector3(0, 0, 1)).isRotation()
        ) { "Basis with the X axis skewed 45 degrees should not be a rotation." }

        checkFalseMessage(
            Basis(0, 0, 0, 0, 0, 0, 0, 0, 0).isRotation()
        ) { "Edge case: Basis with all zeroes should return false for is_rotation, because it is not just a rotation (has a scale of 0)." }
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Basis(Vector3(1, 2, 3).normalized(), 0.7)
        val b = Basis(Vector3(0, 1, 0), 0.5).scaled(Vector3(1, 2, 3))
        val aCopy = Basis(a)
        val bCopy = Basis(b)

        val operations = listOf<() -> Any>(
            { a * b },
            { a + b },
            { a - b },
            { a * 2.0 },
            { a / 2.0 },
            { a.inverse() },
            { a.transposed() },
            { a.orthonormalized() },
            { a.scaled(Vector3(1, 2, 3)) },
            { a.scaledLocal(Vector3(1, 2, 3)) },
            { a.rotated(Vector3(0, 1, 0), 1.0) },
            { a.xform(Vector3(1, 2, 3)) },
            { a.xformInv(Vector3(1, 2, 3)) },
            { a.slerp(b.orthonormalized(), 0.5) },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }



    @Test
    fun `Scalar multiplication and division`() {
        val basis = Basis(Vector3(1, 2, 3), Vector3(4, 5, 6), Vector3(7, 8, 9))
        checkTrue(basis * 2.0 == basis + basis)
        checkTrue(2.0 * basis == basis + basis)
        checkTrue(basis * 2.0 / 2.0 == basis)
    }

    @Test
    fun `getScale of a singular basis is zero`() {
        val scale = Basis(1, 0, 0, 0, 2, 0, 0, 0, 0).getScale()
        checkMessage(scale == Vector3(0, 0, 0)) { "getScale() returned $scale, expected (0, 0, 0)" }
    }

    @Test
    fun `isOrthonormal matches C++`() {
        checkTrue(Basis.IDENTITY.isOrthonormal())
        checkTrue(Basis.fromEuler(Vector3(0.3, 0.5, 0.7)).isOrthonormal())
        checkFalse(Basis.fromScale(Vector3(2, 1, 1)).isOrthonormal())
        checkFalse(Basis(1, 1, 0, 0, 1, 0, 0, 0, 1).isOrthonormal())
    }

    @Test
    fun `isEqualApprox tolerance is relative`() {
        val base = Basis(1000, 0, 0, 0, 1, 0, 0, 0, 1)
        checkTrue(base.isEqualApprox(Basis(1000.005, 0, 0, 0, 1, 0, 0, 0, 1)))
        checkFalse(base.isEqualApprox(Basis(1000.011, 0, 0, 0, 1, 0, 0, 0, 1)))
        checkFalse(Basis.IDENTITY.isEqualApprox(Basis(1.00002, 0, 0, 0, 1, 0, 0, 0, 1)))
    }

    @Test
    fun `orthonormalized of a small uniform scale is identity`() {
        val small = Basis.fromScale(Vector3(0.01, 0.01, 0.01))
        checkTrue(small.orthonormalized().isEqualApprox(Basis.IDENTITY))

        val q = small.getRotationQuaternion()
        checkTrue(q.x == 0.0 && q.y == 0.0 && q.z == 0.0 && q.w == 1.0)
    }

    @Test
    fun `scaledLocal scales each element by the component of its column`() {
        val flipped = Basis.IDENTITY.scaledLocal(Vector3(-1, 1, 1))
        checkTrue(flipped._x.x == -1.0)
        checkTrue(1.0 / flipped._y.x < 0.0)
        checkTrue(flipped._y.y == 1.0 && flipped._z.z == 1.0)

        val basis = Basis(1, 2, 3, 4, 5, 6, 7, 8, 9)
        checkTrue(basis.scaledLocal(Vector3(2, 3, 4)) == Basis(2, 6, 12, 8, 15, 24, 14, 24, 36))
        checkTrue(basis == Basis(1, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    @Test
    fun `lookingAt with a zero target or up returns identity`() {
        checkTrue(Basis.lookingAt(Vector3(0, 0, 0)) == Basis.IDENTITY)
        checkTrue(Basis.lookingAt(Vector3(1, 2, 3), Vector3(0, 0, 0)) == Basis.IDENTITY)
    }

    @Test
    fun `lookingAt with colinear target and up returns a valid basis`() {
        val basis = Basis.lookingAt(Vector3(0, 1, 0), Vector3(0, 1, 0))
        checkTrue(basis.isOrthonormal())
        checkTrue(basis.getColumn(2).isEqualApprox(Vector3(0, -1, 0)))
    }

    @Test
    fun `invert of a singular basis leaves it unchanged`() {
        val singular = Basis(1, 0, 0, 0, 1, 0, 0, 0, 0)
        val copy = Basis(singular)
        singular.invert()
        checkTrue(singular == copy)
        checkTrue(copy.inverse() == copy)
    }

    @Test
    fun `axis angle constructor with a non normalized axis returns identity`() {
        checkTrue(Basis(Vector3(0, 2, 0), 0.5) == Basis.IDENTITY)
    }

    @Test
    fun `getQuaternion of a non rotation returns identity`() {
        val q = Basis.fromScale(Vector3(2, 2, 2)).getQuaternion()
        checkTrue(q.x == 0.0 && q.y == 0.0 && q.z == 0.0 && q.w == 1.0)
    }

    @Test
    fun `slerp of a non rotation does not throw and uses the identity fallback`() {
        val result = Basis.fromScale(Vector3(2, 2, 2)).slerp(Basis.IDENTITY, 0.5)
        checkTrue(result.isEqualApprox(Basis.fromScale(Vector3(1.5, 1.5, 1.5))))
    }
}
