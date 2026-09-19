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
            Basis.fromEuler(Vector3(-1, -1, -1)).isOrthogonal()
        )
        { "Basis with only a flip should be orthogonal." }

        checkMessage(
            Basis.fromEuler(Vector3(1.2, 3.4, 5.6)).isOrthogonal()
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
}
