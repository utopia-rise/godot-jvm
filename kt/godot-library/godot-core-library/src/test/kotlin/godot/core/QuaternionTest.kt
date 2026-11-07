@file:Suppress("RemoveRedundantBackticks")

package godot.core

import godot.common.util.TAU
import godot.common.util.fposmod
import godot.common.util.signbit
import godot.common.util.isEqualApprox
import org.junit.Test
import kotlin.math.sqrt

class TestQuaternion {

    private fun degToRad(s: Double) = s * TAU / 360

    @Test
    fun `Default Construct`() {
        val q = Quaternion()

        checkTrue(q.x == 0.0)
        checkTrue(q.y == 0.0)
        checkTrue(q.z == 0.0)
        checkTrue(q.w == 1.0)
    }

    @Test
    fun `Construct x,y,z,w`() {
        // Values are taken from actual use in another project & are valid (except roundoff error).
        val q = Quaternion(0.2391, 0.099, 0.3696, 0.8924)

        checkTrue(q.x.isEqualApprox(0.2391))
        checkTrue(q.y.isEqualApprox(0.099))
        checkTrue(q.z.isEqualApprox(0.3696))
        checkTrue(q.w.isEqualApprox(0.8924))
    }

    @Test
    fun `Construct AxisAngle 1`() {
        // Easy to visualize: 120 deg about X-axis.
        val q = Quaternion(Vector3(1.0, 0.0, 0.0), degToRad(120.0))

        checkTrue(q.x.isEqualApprox(0.866025)) // Sine of half the angle.
        checkTrue(q.y.isEqualApprox(0.0))
        checkTrue(q.z.isEqualApprox(0.0))
        checkTrue(q.w.isEqualApprox(0.5)) // Cosine of half the angle.
    }

    @Test
    fun `Construct AxisAngle 2`() {
        // Easy to visualize: 30 deg about Y-axis.
        val q = Quaternion(Vector3(0.0, 1.0, 0.0), degToRad(30.0))

        checkTrue(q.x.isEqualApprox(0.0))
        checkTrue(q.y.isEqualApprox(0.258819)) // Sine of half the angle.
        checkTrue(q.z.isEqualApprox(0.0))
        checkTrue(q.w.isEqualApprox(0.965926)) // Cosine of half the angle.
    }

    @Test
    fun `Construct AxisAngle 3`() {
        // Easy to visualize: 60 deg about Z-axis.
        val q = Quaternion(Vector3(0.0, 0.0, 1.0), degToRad(60.0))

        checkTrue(q.x.isEqualApprox(0.0))
        checkTrue(q.y.isEqualApprox(0.0))
        checkTrue(q.z.isEqualApprox(0.5)) // Sine of half the angle.
        checkTrue(q.w.isEqualApprox(0.866025)) // Cosine of half the angle.
    }

    @Test
    fun `Construct AxisAngle 4`() {
        // More complex & hard to visualize, so test w/ data from online calculator.
        val axis = Vector3(1.0, 2.0, 0.5)
        val q = Quaternion(axis.normalized(), degToRad(35.0))

        checkTrue(q.x.isEqualApprox(0.131239))
        checkTrue(q.y.isEqualApprox(0.262478))
        checkTrue(q.z.isEqualApprox(0.0656194))
        checkTrue(q.w.isEqualApprox(0.953717))
    }

    @Test
    fun `Construct from Quaternion`() {
        val axis = Vector3(1.0, 2.0, 0.5)
        val qSrc = Quaternion(axis.normalized(), degToRad(35.0))
        val q = Quaternion(qSrc)

        checkTrue(q.x.isEqualApprox(0.131239))
        checkTrue(q.y.isEqualApprox(0.262478))
        checkTrue(q.z.isEqualApprox(0.0656194))
        checkTrue(q.w.isEqualApprox(0.953717))
    }

    @Test
    fun `Construct Euler SingleAxis`() {
        val yaw = degToRad(45.0)
        val pitch = degToRad(30.0)
        val roll = degToRad(10.0)

        val eulerY = Vector3(0.0, yaw, 0.0)
        val qY = Quaternion.fromEuler(eulerY)
        checkTrue(qY.x.isEqualApprox(0.0))
        checkTrue(qY.y.isEqualApprox(0.382684))
        checkTrue(qY.z.isEqualApprox(0.0))
        checkTrue(qY.w.isEqualApprox(0.923879))

        val eulerP = Vector3(pitch, 0.0, 0.0)
        val qP = Quaternion.fromEuler(eulerP)
        checkTrue(qP.x.isEqualApprox(0.258819))
        checkTrue(qP.y.isEqualApprox(0.0))
        checkTrue(qP.z.isEqualApprox(0.0))
        checkTrue(qP.w.isEqualApprox(0.965926))

        val eulerR = Vector3(0.0, 0.0, roll)
        val qR = Quaternion.fromEuler(eulerR)
        checkTrue(qR.x.isEqualApprox(0.0))
        checkTrue(qR.y.isEqualApprox(0.0))
        checkTrue(qR.z.isEqualApprox(0.0871558))
        checkTrue(qR.w.isEqualApprox(0.996195))
    }

    @Test
    fun `Construct Euler YXZ dynamic axes`() {
        val yaw = degToRad(45.0)
        val pitch = degToRad(30.0)
        val roll = degToRad(10.0)

        // Generate YXZ comparison data (Z-then-X-then-Y) using single-axis Euler
        // constructor and quaternion product, both tested separately.
        val eulerY = Vector3(0.0, yaw, 0.0)
        val qY = Quaternion.fromEuler(eulerY)
        val eulerP = Vector3(pitch, 0.0, 0.0)
        val qP = Quaternion.fromEuler(eulerP)
        val eulerR = Vector3(0.0, 0.0, roll)
        val qR = Quaternion.fromEuler(eulerR)

        // Intrinsically, Yaw-Y then Pitch-X then Roll-Z.
        // Extrinsically, Roll-Z is followed by Pitch-X, then Yaw-Y.
        val checkYXZ = qY * qP * qR

        // Test construction from YXZ Euler angles.
        val eulerYXZ = Vector3(pitch, yaw, roll)
        val q = Quaternion.fromEuler(eulerYXZ)
        checkTrue(q.x.isEqualApprox(checkYXZ.x))
        checkTrue(q.y.isEqualApprox(checkYXZ.y))
        checkTrue(q.z.isEqualApprox(checkYXZ.z))
        checkTrue(q.w.isEqualApprox(checkYXZ.w))
        checkTrue(q.isEqualApprox(checkYXZ))
        checkTrue(q.getEuler().isEqualApprox(eulerYXZ))
        checkTrue(checkYXZ.getEuler().isEqualApprox(eulerYXZ))
    }

    @Test
    fun `Construct Basis Euler`() {
        val yaw = degToRad(45.0)
        val pitch = degToRad(30.0)
        val roll = degToRad(10.0)
        val eulerYXZ = Vector3(pitch, yaw, roll)
        val qYXZ = Quaternion.fromEuler(eulerYXZ)
        val basisAxes = Basis.fromEuler(eulerYXZ)
        val q = Quaternion(basisAxes)
        checkTrue(q.isEqualApprox(qYXZ))
    }


    private fun quatEulerYXZDeg(angle: Vector3): Quaternion {
        val yaw = degToRad(angle.y)
        val pitch = degToRad(angle.x)
        val roll = degToRad(angle.z)

        // Generate YXZ (Z-then-X-then-Y) Quaternion using single-axis Euler
        // constructor and quaternion product, both tested separately.
        val qy = Quaternion.fromEuler(Vector3(0.0, yaw, 0.0))
        val qp = Quaternion.fromEuler(Vector3(pitch, 0.0, 0.0))
        val qr = Quaternion.fromEuler(Vector3(0.0, 0.0, roll))
        // Roll-Z is followed by Pitch-X, then Yaw-Y.
        return qy * qp * qr
    }

    @Test
    fun `Construct Basis Axes`() {
        // Arbitrary Euler angles.
        val eulerYXZ = Vector3(degToRad(31.41), degToRad(-49.16), degToRad(12.34))
        // Basis vectors from online calculation of the rotation matrix.
        val iUnit = Vector3(0.5545787, 0.1823950, 0.8118957)
        val jUnit = Vector3(-0.5249245, 0.8337420, 0.1712555)
        val kUnit = Vector3(-0.6456754, -0.5211586, 0.5581192)
        // Quaternion from online calculation.
        val qCalc = Quaternion(0.2016913, -0.4245716, 0.206033, 0.8582598)
        // Quaternion from local calculation.
        val qLocal = quatEulerYXZDeg(Vector3(31.41, -49.16, 12.34))
        // Quaternion from Euler angles constructor.
        val qEuler = Quaternion.fromEuler(eulerYXZ)
        checkTrue(qCalc.isEqualApprox(qLocal))
        checkTrue(qLocal.isEqualApprox(qEuler))

        // Calculate Basis and construct Quaternion.
        // When this is written, the C++ Basis class does not construct from basis vectors.
        // This is by design, but may be subject to change.
        // Workaround by constructing Basis from Euler angles.
        // basisAxes = Basis(iUnit, jUnit, kUnit);
        val basisAxes = Basis.fromEuler(eulerYXZ)
        val q = Quaternion(basisAxes)

        checkTrue(basisAxes.getColumn(0).isEqualApprox(iUnit))
        checkTrue(basisAxes.getColumn(1).isEqualApprox(jUnit))
        checkTrue(basisAxes.getColumn(2).isEqualApprox(kUnit))

        checkTrue(q.isEqualApprox(qCalc))
        checkTrue(!q.inverse().isEqualApprox(qCalc))
        checkTrue(q.isEqualApprox(qLocal))
        checkTrue(q.isEqualApprox(qEuler))
        checkTrue(q.x.isEqualApprox(0.2016913))
        checkTrue(q.y.isEqualApprox(-0.4245716))
        checkTrue(q.z.isEqualApprox(0.206033))
        checkTrue(q.w.isEqualApprox(0.8582598))
    }

    @Test
    fun `Construct Shortest Arc For 180 Degree Arc`() {
        val up = Vector3(0, 1, 0);
        val down = Vector3(0, -1, 0);
        val left = Vector3(-1, 0, 0);
        val right = Vector3(1, 0, 0);
        val forward = Vector3(0, 0, -1);
        val back = Vector3(0, 0, 1);

        // When we have a 180-degree rotation quaternion which was defined as
        // A to B, logically when we transform A, we expect to get B.
        val leftToRight = Quaternion (left, right);
        val rightToLeft = Quaternion (right, left);
        checkTrue(leftToRight.xform(left).isEqualApprox(right));
        checkTrue(Quaternion(right, left).xform(right).isEqualApprox(left));
        checkTrue(Quaternion(up, down).xform(up).isEqualApprox(down));
        checkTrue(Quaternion(down, up).xform(down).isEqualApprox(up));
        checkTrue(Quaternion(forward, back).xform(forward).isEqualApprox(back));
        checkTrue(Quaternion(back, forward).xform(back).isEqualApprox(forward));
        checkTrue(leftToRight.isNormalized())
        checkTrue(rightToLeft.isNormalized())

        // With (arbitrary) opposite vectors that are not axis-aligned as parameters.
        val diagonalUp = Vector3(1.2, 2.3, 4.5).normalized();
        val diagonalDown = -diagonalUp;
        val q1 = Quaternion(diagonalUp, diagonalDown);
        checkTrue(q1.xform(diagonalDown).isEqualApprox(diagonalUp));
        checkTrue(q1.xform(diagonalUp).isEqualApprox(diagonalDown));
        checkTrue(q1.isNormalized())

        // For the consistency of the rotation direction, they should be symmetrical to the plane.
        checkTrue(leftToRight.isEqualApprox(rightToLeft.inverse()));

        // If vectors are same, no rotation.
        checkTrue(Quaternion(diagonalUp, diagonalUp).isEqualApprox(Quaternion()));
    }

    @Test
    fun `Get Euler Orders`() {
        val x = degToRad(30.0)
        val y = degToRad(45.0)
        val z = degToRad(10.0)
        val euler = Vector3(x, y, z)
        for (i in 0 until 6) {
            val order = EulerOrder.entries[i]
            val basis = Basis.fromEuler(euler, order)
            val q = Quaternion(basis)
            val check = q.getEuler(order)
            checkMessage(check.isEqualApprox(euler)) { "Quaternion getEuler method should return the original angles." }
            checkMessage(check.isEqualApprox(basis.getEuler(order))) { "Quaternion getEuler method should behave the same as Basis getEuler." }
        }
    }

    @Test
    fun `Product (book)`() {
        // Example from "Quaternions and Rotation Sequences" by Jack Kuipers, p. 108.
        val p = Quaternion(1.0, -2.0, 1.0, 3.0)
        val q = Quaternion(-1.0, 2.0, 3.0, 2.0)

        val pq = p * q
        checkTrue(pq.x.isEqualApprox(-9.0))
        checkTrue(pq.y.isEqualApprox(-2.0))
        checkTrue(pq.z.isEqualApprox(11.0))
        checkTrue(pq.w.isEqualApprox(8.0))
    }

    @Test
    fun `Product`() {
        val yaw = degToRad(45.0)
        val pitch = degToRad(30.0)
        val roll = degToRad(10.0)

        val eulerY = Vector3(0.0, yaw, 0.0)
        val qY = Quaternion.fromEuler(eulerY)
        checkTrue(qY.x.isEqualApprox(0.0))
        checkTrue(qY.y.isEqualApprox(0.382684))
        checkTrue(qY.z.isEqualApprox(0.0))
        checkTrue(qY.w.isEqualApprox(0.923879))

        val eulerP = Vector3(pitch, 0.0, 0.0)
        val qP = Quaternion.fromEuler(eulerP)
        checkTrue(qP.x.isEqualApprox(0.258819))
        checkTrue(qP.y.isEqualApprox(0.0))
        checkTrue(qP.z.isEqualApprox(0.0))
        checkTrue(qP.w.isEqualApprox(0.965926))

        val eulerR = Vector3(0.0, 0.0, roll)
        val qR = Quaternion.fromEuler(eulerR)
        checkTrue(qR.x.isEqualApprox(0.0))
        checkTrue(qR.y.isEqualApprox(0.0))
        checkTrue(qR.z.isEqualApprox(0.0871558))
        checkTrue(qR.w.isEqualApprox(0.996195))

        // Test ZYX dynamic-axes since test data is available online.
        // Rotate first about the X-axis, then the new Y-axis, then the new Z-axis.
        // (Godot uses YXZ Yaw-Pitch-Roll order).
        val qYP = qY * qP
        checkTrue(qYP.x.isEqualApprox(0.239118))
        checkTrue(qYP.y.isEqualApprox(0.369644))
        checkTrue(qYP.z.isEqualApprox(-0.099046))
        checkTrue(qYP.w.isEqualApprox(0.892399))

        val qRYP = qR * qYP
        checkTrue(qRYP.x.isEqualApprox(0.205991))
        checkTrue(qRYP.y.isEqualApprox(0.389078))
        checkTrue(qRYP.z.isEqualApprox(-0.0208912))
        checkTrue(qRYP.w.isEqualApprox(0.897636))
    }

    @Test
    fun `Xform unit vectors`() {
        // Easy to visualize: 120 deg about X-axis.
        // Transform the i, j, & k unit vectors.
        val q = Quaternion(Vector3(1.0, 0.0, 0.0), degToRad(120.0))
        val iT = q.xform(Vector3(1.0, 0.0, 0.0))
        val jT = q.xform(Vector3(0.0, 1.0, 0.0))
        val kT = q.xform(Vector3(0.0, 0.0, 1.0))

        checkTrue(iT.isEqualApprox(Vector3(1.0, 0.0, 0.0)))
        checkTrue(jT.isEqualApprox(Vector3(0.0, -0.5, 0.866025)))
        checkTrue(kT.isEqualApprox(Vector3(0.0, -0.866025, -0.5)))
        checkTrue(iT.lengthSquared().isEqualApprox(1.0))
        checkTrue(jT.lengthSquared().isEqualApprox(1.0))
        checkTrue(kT.lengthSquared().isEqualApprox(1.0))

        // Easy to visualize: 30 deg about Y-axis.
        val q2 = Quaternion(Vector3(0.0, 1.0, 0.0), degToRad(30.0))
        val iT2 = q2.xform(Vector3(1.0, 0.0, 0.0))
        val jT2 = q2.xform(Vector3(0.0, 1.0, 0.0))
        val kT2 = q2.xform(Vector3(0.0, 0.0, 1.0))

        checkTrue(iT2.isEqualApprox(Vector3(0.866025, 0.0, -0.5)))
        checkTrue(jT2.isEqualApprox(Vector3(0.0, 1.0, 0.0)))
        checkTrue(kT2.isEqualApprox(Vector3(0.5, 0.0, 0.866025)))
        checkTrue(iT2.lengthSquared().isEqualApprox(1.0))
        checkTrue(jT2.lengthSquared().isEqualApprox(1.0))
        checkTrue(kT2.lengthSquared().isEqualApprox(1.0))

        // Easy to visualize: 60 deg about Z-axis.
        val q3 = Quaternion(Vector3(0.0, 0.0, 1.0), degToRad(60.0))
        val iT3 = q3.xform(Vector3(1.0, 0.0, 0.0))
        val jT3 = q3.xform(Vector3(0.0, 1.0, 0.0))
        val kT3 = q3.xform(Vector3(0.0, 0.0, 1.0))

        checkTrue(iT3.isEqualApprox(Vector3(0.5, 0.866025, 0.0)))
        checkTrue(jT3.isEqualApprox(Vector3(-0.866025, 0.5, 0.0)))
        checkTrue(kT3.isEqualApprox(Vector3(0.0, 0.0, 1.0)))
        checkTrue(iT3.lengthSquared().isEqualApprox(1.0))
        checkTrue(jT3.lengthSquared().isEqualApprox(1.0))
        checkTrue(kT3.lengthSquared().isEqualApprox(1.0))
    }

    @Test
    fun `Xform vector`() {
        // Arbitrary quaternion rotates an arbitrary vector.
        val eulerYZX = Vector3(degToRad(31.41), degToRad(-49.16), degToRad(12.34))
        val basisAxes = Basis.fromEuler(eulerYZX)
        val q = Quaternion(basisAxes)

        val vArb = Vector3(3.0, 4.0, 5.0)
        val vRot = q.xform(vArb)
        val vCompare = basisAxes.xform(vArb)

        checkTrue(vRot.lengthSquared().isEqualApprox(vArb.lengthSquared()))
        checkTrue(vRot.isEqualApprox(vCompare))
    }

    // Test vector xform for a single combination of Quaternion and Vector.
    private fun testQuatVecRotate(eulerYZX: Vector3, vIn: Vector3) {
        val basisAxes = Basis.fromEuler(eulerYZX)
        val q = Quaternion(basisAxes)

        val vRot = q.xform(vIn)
        val vCompare = basisAxes.xform(vIn)

        checkTrue(vRot.lengthSquared().isEqualApprox(vIn.lengthSquared()))
        checkTrue(vRot.isEqualApprox(vCompare))
    }

    @Test
    fun `Stress Many vector xforms`() {
        // Many arbitrary quaternions rotate many arbitrary vectors.
        // For each trial, check that rotation by Quaternion yields the same result as rotation by Basis.
        val STEPS = 100 // Number of test steps in each dimension
        val delta = 2.0 * Math.PI / STEPS // Angle increment per step
        val deltaVec = 20.0 / STEPS // Vector increment per step
        val vecArb = Vector3(1.0, 1.0, 1.0)
        for (i in 0 until STEPS) {
            vecArb.x = -10.0 + i * deltaVec
            val xAngle = i * delta - Math.PI
            for (j in 0 until STEPS) {
                vecArb.y = -10.0 + j * deltaVec
                val yAngle = j * delta - Math.PI
                for (k in 0 until STEPS) {
                    vecArb.z = -10.0 + k * deltaVec
                    val zAngle = k * delta - Math.PI
                    val eulerYZX = Vector3(xAngle, yAngle, zAngle)
                    testQuatVecRotate(eulerYZX, vecArb)
                }
            }
        }
    }

    @Test
    fun `Finite number checks`() {
        val x = Double.NaN

        checkMessage(Quaternion(0.0, 1.0, 2.0, 3.0).isFinite()) { "Quaternion with all components finite should be finite" }
        checkFalseMessage(Quaternion(x, 1.0, 2.0, 3.0).isFinite()) { "Quaternion with one component infinite should not be finite." }
        checkFalseMessage(Quaternion(0.0, x, 2.0, 3.0).isFinite()) { "Quaternion with one component infinite should not be finite." }
        checkFalseMessage(Quaternion(0.0, 1.0, x, 3.0).isFinite()) { "Quaternion with one component infinite should not be finite." }
        checkFalseMessage(Quaternion(0.0, 1.0, 2.0, x).isFinite()) { "Quaternion with one component infinite should not be finite." }
        checkFalseMessage(Quaternion(x, x, 2.0, 3.0).isFinite()) { "Quaternion with two components infinite should not be finite." }
        checkFalseMessage(Quaternion(x, 1.0, x, 3.0).isFinite()) { "Quaternion with two components infinite should not be finite." }
        checkFalseMessage(Quaternion(x, 1.0, 2.0, x).isFinite()) { "Quaternion with two components infinite should not be finite." }
        checkFalseMessage(Quaternion(0.0, x, x, 3.0).isFinite()) { "Quaternion with two components infinite should not be finite." }
        checkFalseMessage(Quaternion(0.0, x, 2.0, x).isFinite()) { "Quaternion with two components infinite should not be finite." }
        checkFalseMessage(Quaternion(0.0, 1.0, x, x).isFinite()) { "Quaternion with two components infinite should not be finite." }
        checkFalseMessage(Quaternion(0.0, x, x, x).isFinite()) { "Quaternion with three components infinite should not be finite." }
        checkFalseMessage(Quaternion(x, 1.0, x, x).isFinite()) { "Quaternion with three components infinite should not be finite." }
        checkFalseMessage(Quaternion(x, x, 2.0, x).isFinite()) { "Quaternion with three components infinite should not be finite." }
        checkFalseMessage(Quaternion(x, x, x, 3.0).isFinite()) { "Quaternion with three components infinite should not be finite." }
        checkFalseMessage(Quaternion(x, x, x, x).isFinite()) { "Quaternion with four components infinite should not be finite." }
    }

    @Test
    fun `Inverse is the conjugate`() {
        val quaternion = Quaternion(Vector3(1, 2, 3).normalized(), 0.8)
        val inverse = quaternion.inverse()
        checkTrue(inverse.x == -quaternion.x)
        checkTrue(inverse.y == -quaternion.y)
        checkTrue(inverse.z == -quaternion.z)
        checkTrue(inverse.w == quaternion.w)
        checkTrue((quaternion * inverse).isEqualApprox(Quaternion()))
    }

    @Test
    fun `Slerpni and rotate toward return copies`() {
        val quaternion = Quaternion(Vector3(1, 2, 3).normalized(), 0.8)
        val copy = Quaternion(quaternion)

        val same = quaternion.slerpni(Quaternion(quaternion), 0.5)
        checkTrue(same !== quaternion)
        same.x = 99.0
        checkTrue(quaternion == copy)

        val target = Quaternion(Vector3(0, 1, 0), 0.4)
        val targetCopy = Quaternion(target)
        val reached = quaternion.rotateToward(target, 100.0)
        checkTrue(reached.isEqualApprox(target))
        reached.x = 99.0
        checkTrue(target == targetCopy)
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Quaternion(Vector3(1, 2, 3).normalized(), 0.8)
        val b = Quaternion(Vector3(0, 1, 0), 0.4)
        val aCopy = Quaternion(a)
        val bCopy = Quaternion(b)

        val operations = listOf<() -> Any>(
            { a + b },
            { a - b },
            { a * b },
            { a * 2.0 },
            { a / 2.0 },
            { -a },
            { a.inverse() },
            { a.normalized() },
            { a.slerp(b, 0.5) },
            { a.slerpni(b, 0.5) },
            { a.slerpni(a, 0.5) },
            { a.rotateToward(b, 0.1) },
            { a.rotateToward(b, 100.0) },
            { a.rotateToward(b, -0.1) },
            { a.xform(Vector3(1, 2, 3)) },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }

    @Test
    fun `Rotate toward turns by a constant angle`() {
        val from = Quaternion(Vector3(1, 2, 3).normalized(), 0.8)
        val to = Quaternion(Vector3(0, 1, 0), 0.4)
        val angle = from.angleTo(to)

        val closer = from.rotateToward(to, 0.1)
        checkTrue(from.angleTo(closer).isEqualApprox(0.1))
        checkTrue(closer.angleTo(to).isEqualApprox(angle - 0.1))
        checkTrue(closer.isNormalized())

        val further = from.rotateToward(to, -0.1)
        checkTrue(from.angleTo(further).isEqualApprox(0.1))
        checkTrue(further.angleTo(to).isEqualApprox(angle + 0.1))
        checkTrue(further.isNormalized())

        checkTrue(from.rotateToward(to, angle).isEqualApprox(to))
        checkTrue(from.rotateToward(to, angle + 1.0).isEqualApprox(to))
    }

    @Test
    fun `Rotate toward handles a zero delta and identical orientations`() {
        val from = Quaternion(Vector3(1, 2, 3).normalized(), 0.8)
        val to = Quaternion(Vector3(0, 1, 0), 0.4)

        checkTrue(from.rotateToward(to, 0.0).isEqualApprox(from))
        checkTrue(from.rotateToward(Quaternion(from), 0.0).isEqualApprox(from))
        checkTrue(from.rotateToward(Quaternion(from), 0.5).isEqualApprox(from))
        checkTrue(from.rotateToward(Quaternion(from), -0.5).isEqualApprox(from))
    }

    @Test
    fun `isNormalized uses the unit epsilon`() {
        checkTrue(Quaternion(0.0, 0.0, 0.0, 1.0004).isNormalized())
        checkTrue(!Quaternion(0.0, 0.0, 0.0, 1.0006).isNormalized())
    }

    @Test
    fun `Division multiplies by the reciprocal`() {
        val q = Quaternion(49.0, 0.0, 0.0, 0.0) / 49.0

        checkTrue(q.x == 49.0 * (1.0 / 49.0))
        checkTrue((Quaternion(2.0, 4.0, 6.0, 8.0) / 2).isEqualApprox(Quaternion(1.0, 2.0, 3.0, 4.0)))
    }

    @Test
    fun `Index operators and unary plus`() {
        val q = Quaternion(1.0, 2.0, 3.0, 4.0)
        q[2] = 9.0

        checkTrue(q[0] == 1.0 && q[1] == 2.0 && q[2] == 9.0 && q[3] == 4.0)
        val plus = +q
        checkTrue(plus == q)
        plus.x = 5.0
        checkTrue(q.x == 1.0)
    }

    @Test
    fun `hashCode matches equals for signed zero`() {
        checkTrue(Quaternion(0.0, 0.0, 0.0, 1.0) == Quaternion(-0.0, -0.0, -0.0, 1.0))
        checkTrue(Quaternion(0.0, 0.0, 0.0, 1.0).hashCode() == Quaternion(-0.0, -0.0, -0.0, 1.0).hashCode())
    }

    @Test
    fun `signbit is true for negative zero and fposmod normalizes it`() {
        checkTrue((-0.0).signbit)
        checkTrue(!(0.0).signbit)
        checkTrue(!(-1.0).fposmod(1.0).signbit)
        checkTrue((-4.0).fposmod(2.0).toRawBits() == 0L)
    }

    @Test
    fun `getAngle clamps w like Math acos`() {
        checkTrue(Quaternion(0.0, 0.0, 0.0, 1.0000001).getAngle() == 0.0)
        checkTrue(Quaternion(0.0, 0.0, 0.0, -1.0000001).getAngle() == 2 * Math.PI)
    }

    @Test
    fun `log of w slightly above one is zero`() {
        val l = Quaternion(0.0, 0.0, 0.0, 1.0000001).log()
        checkTrue(l.x == 0.0 && l.y == 0.0 && l.z == 0.0 && l.w == 0.0)
    }

    @Test
    fun `isEqualApprox tolerance scales with the receiver`() {
        val a = Quaternion(100000.0, 0.0, 0.0, 1.0)
        val b = Quaternion(100001.0, 0.0, 0.0, 1.0)
        checkFalse(a.isEqualApprox(b))
        checkTrue(b.isEqualApprox(a))
    }

    @Test
    fun `slerpni early out uses the float threshold widened to double`() {
        val from = Quaternion()
        val w = 0.99989999
        val to = Quaternion(sqrt(1.0 - w * w), 0.0, 0.0, w)
        checkTrue(from.dot(to) < 0.9999)
        checkTrue(from.dot(to) > 0.9999f.toDouble())

        val result = from.slerpni(to, 0.5)
        checkTrue(result !== from)
        checkTrue(result == from)
    }

    @Test
    fun `Debug checks fall back like the C++ error paths`() {
        val unnormalized = Quaternion(1.0, 2.0, 3.0, 4.0)
        val unnormalizedCopy = Quaternion(unnormalized)
        val normalized = Quaternion(Vector3(0, 1, 0), 0.4)
        val v = Vector3(1, 2, 3)

        checkTrue(unnormalized.inverse() == Quaternion())
        checkTrue(unnormalized.getEuler() == Vector3(0, 0, 0))
        checkTrue(unnormalized.xform(v) == v)
        checkTrue(unnormalized.slerp(normalized, 0.5) == Quaternion())
        checkTrue(normalized.slerp(unnormalized, 0.5) == Quaternion())
        checkTrue(unnormalized.slerpni(normalized, 0.5) == Quaternion())
        checkTrue(normalized.slerpni(unnormalized, 0.5) == Quaternion())
        checkTrue(unnormalized.sphericalCubicInterpolate(normalized, normalized, normalized, 0.5) == Quaternion())
        checkTrue(normalized.sphericalCubicInterpolate(unnormalized, normalized, normalized, 0.5) == Quaternion())
        checkTrue(unnormalized.sphericalCubicInterpolateInTime(normalized, normalized, normalized, 0.5, 1.0, 0.0, 2.0) == Quaternion())
        checkTrue(normalized.sphericalCubicInterpolateInTime(unnormalized, normalized, normalized, 0.5, 1.0, 0.0, 2.0) == Quaternion())
        checkTrue(Quaternion(Vector3(0, 2, 0), 0.4) == Quaternion())
        checkTrue(Quaternion(Vector3(0, 0, 0), Vector3(0, 1, 0)) == Quaternion())
        checkTrue(Quaternion(Vector3(0, 1, 0), Vector3(0, 0, 0)) == Quaternion())
        checkTrue(unnormalized == unnormalizedCopy)
    }
}
