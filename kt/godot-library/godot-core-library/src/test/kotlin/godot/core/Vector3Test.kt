@file:Suppress("FloatingPointLiteralPrecision", "RemoveRedundantBackticks")

package godot.core

import godot.common.util.SQRT12
import godot.common.util.SQRT2
import godot.common.util.TAU
import godot.common.util.isEqualApprox
import org.junit.Test

private const val SQRT3 = 1.7320508075688772935274463415059
private const val SQRT13 = 0.57735026918962576450914878050196

class TestVector3 {

    @Test
    fun `Constructor Methods`() {
        val vectorEmpty = Vector3()
        val vectorZero = Vector3(0.0, 0.0, 0.0)
        checkMessage(vectorZero == vectorEmpty) { "Vector3 Constructor with no inputs should return a zero Vector3." }
    }

    @Test
    fun `Angle Methods`() {
        val vectorX = Vector3(1.0, 0.0, 0.0)
        val vectorY = Vector3(0.0, 1.0, 0.0)
        val vectorYZ = Vector3(0.0, 1.0, 1.0)

        checkMessage((TAU / 4.0).isEqualApprox(vectorX.angleTo(vectorY))) { "Vector3 angle_to should work as expected." }
        checkMessage((TAU / 4.0).isEqualApprox(vectorX.angleTo(vectorYZ))) { "Vector3 angle_to should work as expected." }
        checkMessage((TAU / 4.0).isEqualApprox(vectorYZ.angleTo(vectorX))) { "Vector3 angle_to should work as expected." }
        checkMessage((TAU / 8.0).isEqualApprox(vectorY.angleTo(vectorYZ))) { "Vector3 angle_to should work as expected." }

        checkMessage((TAU / 4.0).isEqualApprox(vectorX.signedAngleTo(vectorY, vectorY))) { "Vector3 signed_angle_to edge case should be positive." }
        checkMessage((TAU / -4.0).isEqualApprox(vectorX.signedAngleTo(vectorYZ, vectorY))) { "Vector3 signed_angle_to should work as expected." }
        checkMessage((TAU / 4.0).isEqualApprox(vectorYZ.signedAngleTo(vectorX, vectorY))) { "Vector3 signed_angle_to should work as expected." }
    }

    @Test
    fun `Axis Methods`() {
        val vector = Vector3(1.2, 3.4, 5.6)
        checkMessage(Vector3.Axis.Z == vector.maxAxis()) { "Vector3 max_axis_index should work as expected." }
        checkMessage(Vector3.Axis.X == vector.minAxis()) { "Vector3 min_axis_index should work as expected." }
        checkMessage(5.6.isEqualApprox(vector[Vector3.Axis.Z])) { "Vector3 array operator should work as expected." }
        checkMessage(1.2.isEqualApprox(vector[Vector3.Axis.X])) { "Vector3 array operator should work as expected." }

        vector[Vector3.Axis.Y] = 3.7
        checkMessage(3.7.isEqualApprox(vector[Vector3.Axis.Y])) { "Vector3 array operator setter should work as expected." }
    }

    @Test
    fun `Interpolation methods`() {
        val vector1 = Vector3(1.0, 2.0, 3.0)
        val vector2 = Vector3(4.0, 5.0, 6.0)

        checkMessage(vector1.lerp(vector2, 0.5).isEqualApprox(Vector3(2.5, 3.5, 4.5))) { "lerp() should return the expected result." }
        checkMessage(vector1.lerp(vector2, 1.0 / 3.0).isEqualApprox(Vector3(2.0, 3.0, 4.0))) { "lerp() should return the expected result." }
        checkMessage(
            vector1.normalized().slerp(vector2.normalized(), 0.5).isEqualApprox(Vector3(0.363866806030273438, 0.555698215961456299, 0.747529566287994385))
        ) { "slerp() should return the expected result." }
        checkMessage(
            vector1.normalized().slerp(vector2.normalized(), 1.0 / 3.0).isEqualApprox(Vector3(0.332119762897491455, 0.549413740634918213, 0.766707837581634521))
        ) { "slerp() should return the expected result." }
        checkMessage(
            Vector3(5.0, 0.0, 0.0).slerp(Vector3(0.0, 3.0, 4.0), 0.5).isEqualApprox(Vector3(3.535533905029296875, 2.121320486068725586, 2.828427314758300781))
        ) { "slerp() should return the expected result." }
        checkMessage(
            Vector3(1.0, 1.0, 1.0).slerp(Vector3(2.0, 2.0, 2.0), 0.5).isEqualApprox(Vector3(1.5, 1.5, 1.5))
        ) { "slerp() should return the expected result." }
        checkMessage(Vector3().slerp(Vector3(), 0.5) == Vector3()) { "slerp() with an empty vector should return the expected result." }
        checkMessage(
            Vector3().slerp(Vector3(1.0, 1.0, 1.0), 0.5) == Vector3(
                0.5,
                0.5,
                0.5
            )
        ) { "slerp() with an empty vector should return the expected result." }
        checkMessage(
            Vector3(1.0, 1.0, 1.0).slerp(Vector3(), 0.5) == Vector3(
                0.5,
                0.5,
                0.5
            )
        ) { "slerp() with an empty vector should return the expected result." }
        checkMessage(
            Vector3(4.0, 6.0, 2.0).slerp(Vector3(8.0, 10.0, 3.0), 0.5)
                .isEqualApprox(Vector3(5.90194219811429941053, 8.06758688849378394534, 2.558307894718317120038))
        ) { "slerp() should return the expected result." }
        checkMessage(
            vector1.slerp(vector2, 0.5).length().isEqualApprox(6.25831088708303172)
        ) { "slerp() with different length input should return a vector with an interpolated length." }
        checkMessage(
            (vector1.angleTo(vector1.slerp(vector2, 0.5)) * 2).isEqualApprox(vector1.angleTo(vector2))
        ) { "slerp() with different length input should return a vector with an interpolated angle." }
        checkMessage(
            vector1.cubicInterpolate(vector2, Vector3(), Vector3(7.0, 7.0, 7.0), 0.5) == Vector3(
                2.375,
                3.5,
                4.625
            )
        ) { "cubicInterpolate() should return the expected result." }
        checkMessage(
            vector1.cubicInterpolate(vector2, Vector3(), Vector3(7.0, 7.0, 7.0), 1.0 / 3.0)
                .isEqualApprox(Vector3(1.851851940155029297, 2.962963104248046875, 4.074074268341064453))
        ) { "cubicInterpolate() should return the expected result." }
        checkMessage(
            Vector3(1.0, 0.0, 0.0).moveToward(Vector3(10.0, 0.0, 0.0), 3.0) == Vector3(
                4.0,
                0.0,
                0.0
            )
        ) { "moveToward() should return the expected result." }

        checkMessage(
            Vector3(1, 0, 0).rotateToward(
                Vector3(0, 1, 0),
                TAU / 8.0
            ).isEqualApprox(Vector3(SQRT12, SQRT12, 0))
        ) { "Vector3 rotate_toward should work as expected." }
        checkMessage(
            Vector3(1, 0, 0).rotateToward(
                Vector3(0, 1, 0), -TAU / 8.0
            ).isEqualApprox(Vector3(SQRT12, -SQRT12, 0))
        ) { "Vector3 rotate_toward with negative delta should behave as expected." }
        checkMessage(
            Vector3(1, 1, 1).rotateToward(
                Vector3(10, 10, 10), 0.5
            ).isEqualApprox(Vector3(6, 6, 6))
        ) { "Vector3 rotate_toward with colinear inputs should behave as expected." }
        checkMessage(
            Vector3(10, 10, 10).rotateToward(
                Vector3(0, 0, 0), 0.5
            ).isEqualApprox(Vector3(5, 5, 5))
        ) { "Vector3 rotate_toward with second input as zero should behave as expected." }
    }

    @Test
    fun `Length methods`() {
        val vector1 = Vector3(10.0, 10.0, 10.0)
        val vector2 = Vector3(20.0, 30.0, 40.0)

        checkMessage(vector1.lengthSquared() == 300.0) { "lengthSquared() should work as expected and return the exact result." }
        checkMessage(vector1.length().isEqualApprox(10 * SQRT3)) { "length() should work as expected." }
        checkMessage(vector2.lengthSquared() == 2900.0) { "lengthSquared() should work as expected and return the exact result." }
        checkMessage(vector2.length().isEqualApprox(53.8516480713450403125)) { "length() should work as expected." }
        checkMessage(vector1.distanceSquaredTo(vector2) == 1400.0) { "distanceSquaredTo() should work as expected and return the exact result." }
        checkMessage(vector1.distanceTo(vector2).isEqualApprox(37.41657386773941385584)) { "distanceTo() should work as expected." }
    }

    @Test
    fun `Limiting methods`() {
        val vector = Vector3(10.0, 10.0, 10.0)
        checkMessage(vector.limitLength().isEqualApprox(Vector3(SQRT13, SQRT13, SQRT13))) { "Vector3 limit_length should work as expected." }
        checkMessage(vector.limitLength(5.0).isEqualApprox(5.0 * Vector3(SQRT13, SQRT13, SQRT13))) { "Vector3 limit_length should work as expected." }

        val result1 = Vector3(-5.0, 5.0, 15.0).clamp(Vector3(), vector)
        checkMessage(result1 == Vector3(0.0, 5.0, 10.0)) { "Vector3 clamp should work as expected." }

        val result2 = vector.clamp(Vector3(0.0, 10.0, 15.0), Vector3(5.0, 10.0, 20.0))
        checkMessage(result2 == Vector3(5.0, 10.0, 15.0)) { "Vector3 clamp should work as expected." }
    }

    @Test
    fun `Normalization methods`() {
        checkMessage(Vector3(1.0, 0.0, 0.0).isNormalized() == true) { "Vector3 isNormalized should return true for a normalized vector." }

        checkMessage(Vector3(1.0, 1.0, 1.0).isNormalized() == false) { "Vector3 isNormalized should return false for a non-normalized vector." }

        checkMessage(
            Vector3(1.0, 0.0, 0.0).normalized() == Vector3(
                1.0,
                0.0,
                0.0
            )
        ) { "Vector3 normalized should return the same vector for a normalized vector." }

        checkMessage(Vector3(1.0, 1.0, 0.0).normalized().isEqualApprox(Vector3(SQRT12, SQRT12, 0.0))) { "Vector3 normalized should work as expected." }

        checkMessage(Vector3(1.0, 1.0, 1.0).normalized().isEqualApprox(Vector3(SQRT13, SQRT13, SQRT13))) { "Vector3 normalized should work as expected." }

        val vector = Vector3(3.2, -5.4, 6.0)
        vector.normalize()
        checkMessage(vector == Vector3(3.2, -5.4, 6.0).normalized()) { "Vector3 normalize should convert in the same way as Vector3 normalized." }
        checkMessage(
            vector.isEqualApprox(
                Vector3(
                    0.368522751763902980457,
                    -0.621882143601586279522,
                    0.6909801595573180883585
                )
            )
        ) { "Vector3 normalize should work as expected." }
    }

    @Test
    fun `Operators`() {
        val decimal1 = Vector3(2.3, 4.9, 7.8)
        val decimal2 = Vector3(1.2, 3.4, 5.6)
        val power1 = Vector3(0.75, 1.5, 0.625)
        val power2 = Vector3(0.5, 0.125, 0.25)
        val int1 = Vector3(4, 5, 9)
        val int2 = Vector3(1, 2, 3)

        checkMessage((decimal1 + decimal2).isEqualApprox(Vector3(3.5, 8.3, 13.4))) { "Vector3 addition should behave as expected." }
        checkMessage((power1 + power2) == Vector3(1.25, 1.625, 0.875)) { "Vector3 addition with powers of two should give exact results." }
        checkMessage((int1 + int2) == Vector3(5, 7, 12)) { "Vector3 addition with integers should give exact results." }

        checkMessage((decimal1 - decimal2).isEqualApprox(Vector3(1.1, 1.5, 2.2))) { "Vector3 subtraction should behave as expected." }
        checkMessage((power1 - power2) == Vector3(0.25, 1.375, 0.375)) { "Vector3 subtraction with powers of two should give exact results." }
        checkMessage((int1 - int2) == Vector3(3, 3, 6)) { "Vector3 subtraction with integers should give exact results." }

        checkMessage((decimal1 * decimal2).isEqualApprox(Vector3(2.76, 16.66, 43.68))) { "Vector3 multiplication should behave as expected." }
        checkMessage((power1 * power2) == Vector3(0.375, 0.1875, 0.15625)) { "Vector3 multiplication with powers of two should give exact results." }
        checkMessage((int1 * int2) == Vector3(4, 10, 27)) { "Vector3 multiplication with integers should give exact results." }

        checkMessage(
            (decimal1 / decimal2).isEqualApprox(
                Vector3(
                    1.91666666666666666,
                    1.44117647058823529,
                    1.39285714285714286
                )
            )
        ) { "Vector3 division should behave as expected." }
        checkMessage((power1 / power2) == Vector3(1.5, 12.0, 2.5)) { "Vector3 division with powers of two should give exact results." }
        checkMessage((int1 / int2) == Vector3(4, 2.5, 3)) { "Vector3 division with integers should give exact results." }

        checkMessage((decimal1 * 2).isEqualApprox(Vector3(4.6, 9.8, 15.6))) { "Vector3 multiplication should behave as expected." }
        checkMessage((power1 * 2) == Vector3(1.5, 3, 1.25)) { "Vector3 multiplication with powers of two should give exact results." }
        checkMessage((int1 * 2) == Vector3(8, 10, 18)) { "Vector3 multiplication with integers should give exact results." }

        checkMessage((decimal1 / 2).isEqualApprox(Vector3(1.15, 2.45, 3.9))) { "Vector3 division should behave as expected." }
        checkMessage((power1 / 2) == Vector3(0.375, 0.75, 0.3125)) { "Vector3 division with powers of two should give exact results." }
        checkMessage((int1 / 2) == Vector3(2, 2.5, 4.5)) { "Vector3 division with integers should give exact results." }

        checkMessage(decimal1.toVector3i() == Vector3i(2, 4, 7)) { "Vector3 cast to Vector3i should work as expected." }
        checkMessage(decimal2.toVector3i() == Vector3i(1, 3, 5)) { "Vector3 cast to Vector3i should work as expected." }
        checkMessage(Vector3(Vector3i(1, 2, 3)) == Vector3(1, 2, 3)) { "Vector3 constructed from Vector3i should work as expected." }

        checkMessage(decimal1.toString() == "(2.3, 4.9, 7.8)") { "Vector3 cast to String should work as expected." }
        checkMessage(decimal2.toString() == "(1.2, 3.4, 5.6)") { "Vector3 cast to String should work as expected." }
        checkMessage(Vector3(9.7, 9.8, 9.9).toString() == "(9.7, 9.8, 9.9)") { "Vector3 cast to String should work as expected." }

        checkMessage(
            Vector3(Math.E, SQRT2, SQRT3).toString() == "(2.718281828459045, 1.4142135623730951, 1.7320508075688772)"
        ) { "Vector3 cast to String should print the correct amount of digits for real_t = float." }
    }

    @Test
    fun `Other methods`() {
        val vector = Vector3(1.2, 3.4, 5.6)

        checkMessage(vector.directionTo(Vector3()).isEqualApprox(-vector.normalized())) { "Vector3 directionTo should work as expected." }
        checkMessage(
            Vector3(1, 1, 1).directionTo(Vector3(2, 2, 2)).isEqualApprox(Vector3(SQRT13, SQRT13, SQRT13)),
        ) { "Vector3 directionTo should work as expected." }
        checkMessage(vector.inverse().isEqualApprox(Vector3(1.0 / 1.2, 1.0 / 3.4, 1.0 / 5.6))) { "Vector3 inverse should work as expected." }
        checkMessage(vector.posmod(2.0).isEqualApprox(Vector3(1.2, 1.4, 1.6))) { "Vector3 posmod should work as expected." }
        checkMessage((-vector).posmod(2.0).isEqualApprox(Vector3(0.8, 0.6, 0.4))) { "Vector3 posmod should work as expected." }
        checkMessage(vector.posmodv(Vector3(1.0, 2.0, 3.0)).isEqualApprox(Vector3(0.2, 1.4, 2.6))) { "Vector3 posmodv should work as expected." }
        checkMessage((-vector).posmodv(Vector3(2.0, 3.0, 4.0)).isEqualApprox(Vector3(0.8, 2.6, 2.4))) { "Vector3 posmodv should work as expected." }

        checkMessage(vector.rotated(Vector3(0.0, 1.0, 0.0), TAU).isEqualApprox(vector)) { "Vector3 rotated should work as expected." }
        checkMessage(vector.rotated(Vector3(0.0, 1.0, 0.0), TAU / 4.0).isEqualApprox(Vector3(5.6, 3.4, -1.2))) { "Vector3 rotated should work as expected." }
        checkMessage(
            vector.rotated(Vector3(1.0, 0.0, 0.0), TAU / 3.0).isEqualApprox(Vector3(1.2, -6.54974226119285642, 0.1444863728670914))
        ) { "Vector3 rotated should work as expected." }
        checkMessage(
            vector.rotated(Vector3(0.0, 0.0, 1.0), TAU / 2.0).isEqualApprox(vector.rotated(Vector3(0.0, 0.0, 1.0), -TAU / 2.0))
        ) { "Vector3 rotated should work as expected." }

        checkMessage(vector.snapped(Vector3(1.0, 1.0, 1.0)) == Vector3(1.0, 3.0, 6.0)) { "Vector3 snapped to integers should be the same as rounding." }
        checkMessage(vector.snapped(Vector3(0.25, 0.25, 0.25)) == Vector3(1.25, 3.5, 5.5)) { "Vector3 snapped to 0.25 should give exact results." }
    }

    @Test
    fun `Plane methods`() {
        val vector = Vector3(1.2, 3.4, 5.6)
        val vectorY = Vector3(0.0, 1.0, 0.0)
        val vectorNormal = Vector3(0.88763458893247992491, 0.26300284116517923701, 0.37806658417494515320)
        val vectorNonNormal = Vector3(5.4, 1.6, 2.3)

        checkMessage(vector.bounce(vectorY) == Vector3(1.2, -3.4, 5.6)) { "Vector3 bounce on a plane with a normal of the Y axis should." }
        checkMessage(
            vector.bounce(vectorNormal).isEqualApprox(Vector3(-6.0369629829775736287, 1.25571467171034855444, 2.517589840583626047))
        ) { "Vector3 bounce with a normal should return the expected value." }

        checkMessage(vector.reflect(vectorY) == Vector3(-1.2, 3.4, -5.6)) { "Vector3 reflect on a plane with a normal of the Y axis should." }
        checkMessage(
            vector.reflect(vectorNormal).isEqualApprox(Vector3(6.0369629829775736287, -1.25571467171034855444, -2.517589840583626047))
        ) { "Vector3 reflect with a normal should return the expected value." }

        checkMessage(vector.project(vectorY) == Vector3(0.0, 3.4, 0.0)) { "Vector3 projected on the Y axis should only give the Y component." }
        checkMessage(
            vector.project(vectorNormal).isEqualApprox(Vector3(3.61848149148878681437, 1.0721426641448257227776, 1.54120507970818697649))
        ) { "Vector3 projected on a normal should return the expected value." }

        checkMessage(
            vector.slide(vectorY) == Vector3(
                1.2,
                0.0,
                5.6
            )
        ) { "Vector3 slide on a plane with a normal of the Y axis should set the Y component to zero." }
        checkMessage(
            vector.slide(vectorNormal).isEqualApprox(Vector3(-2.41848149148878681437, 2.32785733585517427722237, 4.0587949202918130235))
        ) { "Vector3 slide with a normal should return the expected value." }
    }

    @Test
    fun `Rounding methods`() {
        val vector1 = Vector3(1.2, 3.4, 5.6)
        val vector2 = Vector3(1.2, -3.4, -5.6)

        checkMessage(vector1.abs().isEqualApprox(vector1)) { "Vector3 abs should work as expected." }
        checkMessage(vector2.abs().isEqualApprox(vector1)) { "Vector3 abs should work as expected." }

        checkMessage(vector1.ceil().isEqualApprox(Vector3(2.0, 4.0, 6.0))) { "Vector3 ceil should work as expected." }
        checkMessage(vector2.ceil().isEqualApprox(Vector3(2.0, -3.0, -5.0))) { "Vector3 ceil should work as expected." }

        checkMessage(vector1.floor().isEqualApprox(Vector3(1.0, 3.0, 5.0))) { "Vector3 floor should work as expected." }
        checkMessage(vector2.floor().isEqualApprox(Vector3(1.0, -4.0, -6.0))) { "Vector3 floor should work as expected." }

        checkMessage(vector1.round().isEqualApprox(Vector3(1.0, 3.0, 6.0))) { "Vector3 round should work as expected." }
        checkMessage(vector2.round().isEqualApprox(Vector3(1.0, -3.0, -6.0))) { "Vector3 round should work as expected." }

        checkMessage(vector1.sign().isEqualApprox(Vector3(1.0, 1.0, 1.0))) { "Vector3 sign should work as expected." }
        checkMessage(vector2.sign().isEqualApprox(Vector3(1.0, -1.0, -1.0))) { "Vector3 sign should work as expected." }
    }

    @Test
    fun `Linear algebra methods`() {
        val vectorX = Vector3(1.0, 0.0, 0.0)
        val vectorY = Vector3(0.0, 1.0, 0.0)
        val vectorZ = Vector3(0.0, 0.0, 1.0)
        val a = Vector3(3.5, 8.5, 2.3)
        val b = Vector3(5.2, 4.6, 7.8)

        checkMessage(vectorX.cross(vectorY).isEqualApprox(vectorZ)) { "Vector3 cross product of X and Y should give Z." }
        checkMessage(vectorY.cross(vectorX).isEqualApprox(-vectorZ)) { "Vector3 cross product of Y and X should give negative Z." }
        checkMessage(vectorY.cross(vectorZ).isEqualApprox(vectorX)) { "Vector3 cross product of Y and Z should give X." }
        checkMessage(vectorZ.cross(vectorX).isEqualApprox(vectorY)) { "Vector3 cross product of Z and X should give Y." }
        checkMessage(a.cross(b).isEqualApprox(Vector3(55.72, -15.34, -28.1))) { "Vector3 cross should return expected value." }
        checkMessage(
            Vector3(-a.x, a.y, -a.z).cross(Vector3(b.x, -b.y, b.z)).isEqualApprox(Vector3(55.72, 15.34, -28.1))
        ) { "Vector2 cross should return expected value." }

        checkMessage(vectorX.dot(vectorY) == 0.0) { "Vector3 dot product of perpendicular vectors should be zero." }
        checkMessage(vectorX.dot(vectorX) == 1.0) { "Vector3 dot product of identical unit vectors should be one." }
        checkMessage((vectorX * 10.0).dot(vectorX * 10.0) == 100.0) { "Vector3 dot product of same direction vectors should behave as expected." }
        checkMessage(a.dot(b).isEqualApprox(75.24)) { "Vector3 dot should return the expected value." }
        checkMessage(Vector3(-a.x, a.y, -a.z).dot(Vector3(b.x, -b.y, b.z)).isEqualApprox(-75.24)) { "Vector3 dot should return the expected value." }
    }

    @Test
    fun `Finite number checks`() {
        val infinite = doubleArrayOf(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)

        checkMessage(Vector3(0.0, 1.0, 2.0).isFinite()) { "Vector3(0, 1, 2) should be finite" }

        for (x in infinite) {
            checkFalseMessage(Vector3(x, 1.0, 2.0).isFinite()) { "Vector3 with one component infinite should not be finite." }
            checkFalseMessage(Vector3(0.0, x, 2.0).isFinite()) { "Vector3 with one component infinite should not be finite." }
            checkFalseMessage(Vector3(0.0, 1.0, x).isFinite()) { "Vector3 with one component infinite should not be finite." }
        }

        for (x in infinite) {
            for (y in infinite) {
                checkFalseMessage(Vector3(x, y, 2.0).isFinite()) { "Vector3 with two components infinite should not be finite." }
                checkFalseMessage(Vector3(x, 1.0, y).isFinite()) { "Vector3 with two components infinite should not be finite." }
                checkFalseMessage(Vector3(0.0, x, y).isFinite()) { "Vector3 with two components infinite should not be finite." }
            }
        }

        for (x in infinite) {
            for (y in infinite) {
                for (z in infinite) {
                    checkFalseMessage(Vector3(x, y, z).isFinite()) { "Vector3 with three components infinite should not be finite." }
                }
            }
        }
    }

    @Test
    fun `Move toward returns a copy`() {
        val from = Vector3(1, 2, 3)
        val to = Vector3(4, 5, 6)

        val reached = from.moveToward(to, 100.0)
        checkTrue(reached == to)
        checkTrue(reached !== to)
        reached.x = 99.0
        checkTrue(to == Vector3(4, 5, 6))

        val same = from.moveToward(from, 1.0)
        checkTrue(same !== from)

        val partial = from.moveToward(to, 1.0)
        checkTrue((partial - from).length().isEqualApprox(1.0))
    }

    @Test
    fun `Rotate toward returns a copy`() {
        val from = Vector3(1, 0, 0)
        val to = Vector3(0, 1, 0)
        val reached = from.rotateToward(to, 100.0)
        checkTrue(reached.isEqualApprox(to))
        reached.x = 99.0
        checkTrue(to == Vector3(0, 1, 0))
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Vector3(1, 2, 3)
        val b = Vector3(4, -5, 6)
        val aCopy = Vector3(a)
        val bCopy = Vector3(b)

        val operations = listOf<() -> Any>(
            { a + b },
            { a - b },
            { a * b },
            { a / b },
            { a * 2.0 },
            { -a },
            { a.cross(b) },
            { a.normalized() },
            { a.abs() },
            { a.lerp(b, 0.5) },
            { a.slerp(b, 0.5) },
            { a.limitLength(1.0) },
            { a.project(b) },
            { a.reflect(b.normalized()) },
            { a.slide(b.normalized()) },
            { a.bounce(b.normalized()) },
            { a.rotated(Vector3(0, 1, 0), 1.0) },
            { a.snapped(Vector3(2, 2, 2)) },
            { a.snappedf(2.0) },
            { a.directionTo(b) },
            { a.moveToward(b, 1.0) },
            { a.moveToward(b, 100.0) },
            { a.rotateToward(b, 0.1) },
            { a.rotateToward(b, 100.0) },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }

    @Test
    fun `octahedronDecode clamps the negated z`() {
        checkTrue(Vector3.octahedronDecode(Vector2(0, 0)).isEqualApprox(Vector3(0, 0, -1)))
        checkTrue(Vector3(0, 0, 0).octahedronDecode(Vector2(0, 0)).isEqualApprox(Vector3(0, 0, -1)))
    }

    @Test
    fun `clamp does not throw when min is greater than max`() {
        checkTrue(Vector3(5, 5, 5).clamp(Vector3(10, 10, 10), Vector3(0, 0, 0)) == Vector3(10, 10, 10))
        checkTrue(Vector3(5, 5, 5).clampf(10.0, 0.0) == Vector3(10, 10, 10))
    }

    @Test
    fun `round rounds halfway cases away from zero`() {
        checkTrue(Vector3(0.5, -0.5, 2.5).round() == Vector3(1, -1, 3))
    }

    @Test
    fun `isNormalized compares the squared length with UNIT_EPSILON`() {
        checkTrue(Vector3(1.0004, 0.0, 0.0).isNormalized())
        checkFalse(Vector3(1.0006, 0.0, 0.0).isNormalized())
    }

    @Test
    fun `isEqualApprox scales the tolerance by this vector`() {
        checkFalse(Vector3(1000.0, 0.0, 0.0).isEqualApprox(Vector3(1000.01000005, 0.0, 0.0)))
        checkTrue(Vector3(1000.01000005, 0.0, 0.0).isEqualApprox(Vector3(1000.0, 0.0, 0.0)))
    }

    @Test
    fun `outer fills the rows of the basis`() {
        val basis = Vector3(1, 2, 3).outer(Vector3(4, 5, 6))
        checkTrue(basis[0] == Vector3(4, 8, 12))
        checkTrue(basis[1] == Vector3(5, 10, 15))
        checkTrue(basis[2] == Vector3(6, 12, 18))
    }

    @Test
    fun `rotateToward with a negative delta rotates away from the target`() {
        val result = Vector3(1, 0, 0).rotateToward(Vector3(0, 1, 0), -TAU / 8.0)
        checkTrue(result.isEqualApprox(Vector3(SQRT12, -SQRT12, 0)))
    }

    @Test
    fun `rotateToward with a zero delta and colinear vectors does not return NaN`() {
        checkTrue(Vector3(1, 0, 0).rotateToward(Vector3(1, 0, 0), 0.0) == Vector3(1, 0, 0))
    }

    @Test
    fun `Model constants`() {
        checkTrue(Vector3.MODEL_LEFT == Vector3(1, 0, 0))
        checkTrue(Vector3.MODEL_RIGHT == Vector3(-1, 0, 0))
        checkTrue(Vector3.MODEL_TOP == Vector3(0, 1, 0))
        checkTrue(Vector3.MODEL_BOTTOM == Vector3(0, -1, 0))
        checkTrue(Vector3.MODEL_FRONT == Vector3(0, 0, 1))
        checkTrue(Vector3.MODEL_REAR == Vector3(0, 0, -1))
    }

    @Test
    fun `unaryPlus returns an equal copy`() {
        val v = Vector3(1, -2, 3)
        val result = +v
        checkTrue(result == v)
        checkTrue(result !== v)
    }

    @Test
    fun `hashCode is equal for negative and positive zero`() {
        checkTrue(Vector3(0.0, 0.0, 0.0) == Vector3(-0.0, 0.0, 0.0))
        checkTrue(Vector3(0.0, 0.0, 0.0).hashCode() == Vector3(-0.0, 0.0, 0.0).hashCode())
        checkTrue(Vector3(1.0, 0.0, 0.0).hashCode() == Vector3(1.0, -0.0, -0.0).hashCode())
    }

    @Test
    fun `getAnyPerpendicular returns zero for a near zero vector`() {
        checkTrue(Vector3(1e-6, 0, 0).getAnyPerpendicular() == Vector3(0, 0, 0))
    }

    @Test
    fun `isZeroApprox uses an absolute tolerance`() {
        checkTrue(Vector3(1e-6, -1e-6, 0).isZeroApprox())
        checkFalse(Vector3(1e-5, 0, 0).isZeroApprox())
        checkFalse(Vector3(0, 0, -1e-5).isZeroApprox())
        checkFalse(Vector3(2.0, 0, 0).isZeroApprox())
    }

    @Test
    fun `hashCode is consistent with equals`() {
        checkTrue(Vector3(1.5, -2.5, 3.5).hashCode() == Vector3(1.5, -2.5, 3.5).hashCode())
        checkTrue(Vector3(0.0, 0.0, -0.0).hashCode() == Vector3(0.0, 0.0, 0.0).hashCode())
        checkTrue(Vector3(1, 2, 3).hashCode() != Vector3(3, 2, 1).hashCode())
    }

    @Test
    fun `reflect slide and bounce return zero for a non normalized normal`() {
        val v = Vector3(1, 2, 3)
        val normal = Vector3(0, 2, 0)
        checkTrue(v.reflect(normal) == Vector3())
        checkTrue(v.slide(normal) == Vector3())
        checkTrue(v.bounce(normal) == Vector3())
    }

    @Test
    fun `rotated with a non normalized axis returns an unchanged copy`() {
        val v = Vector3(1, 2, 3)
        val result = v.rotated(Vector3(0, 2, 0), 1.0)
        checkTrue(result == v)
        checkTrue(result !== v)
    }

    @Test
    fun `normalized returns zero for non finite components`() {
        checkTrue(Vector3(Double.NaN, 0.0, 0.0).normalized() == Vector3(0, 0, 0))
        checkTrue(Vector3(0.0, Double.POSITIVE_INFINITY, 1.0).normalized() == Vector3(0, 0, 0))
    }
}
