@file:Suppress("FloatingPointLiteralPrecision", "RemoveRedundantBackticks")

package godot.core

import godot.common.util.PI
import godot.common.util.SQRT12
import godot.common.util.SQRT2
import godot.common.util.TAU
import godot.common.util.isEqualApprox
import org.junit.Test
import kotlin.math.sqrt

class TestVector2 {

    @Test
    fun `Constructor Methods`() {
        val vectorEmpty = Vector2()
        val vectorZero = Vector2(0.0, 0.0)
        checkMessage(vectorZero == vectorEmpty) { "Vector2 Constructor with no inputs should return a zero Vector2." }
    }

    @Test
    fun `Angle Methods`() {
        val vectorX = Vector2(1.0, 0.0)
        val vectorY = Vector2(0.0, 1.0)
        checkMessage((TAU / 4.0).isEqualApprox(vectorX.angleTo(vectorY))) { "Vector2 angle_to should work as expected." }
        checkMessage((-TAU / 4.0).isEqualApprox(vectorY.angleTo(vectorX))) { "Vector2 angle_to should work as expected." }
        checkMessage((TAU * 3 / 8).isEqualApprox(vectorX.angleToPoint(vectorY))) { "Vector2 angle_to_point should work as expected." }
        checkMessage((-TAU / 8).isEqualApprox(vectorY.angleToPoint(vectorX))) { "Vector2 angle_to_point should work as expected." }
    }

    @Test
    fun `Axis Methods`() {
        val vector = Vector2(1.2, 3.4)
        checkMessage(Vector2.Axis.Y == vector.maxAxisIndex()) { "Vector2 max_axis_index should work as expected." }
        checkMessage(Vector2.Axis.X == vector.minAxisIndex()) { "Vector2 min_axis_index should work as expected." }
        checkMessage(1.2.isEqualApprox(vector[vector.minAxisIndex()])) { "Vector2 array operator should work as expected." }
        vector[Vector2.Axis.Y] = 3.7
        checkMessage(3.7.isEqualApprox(vector[Vector2.Axis.Y])) { "Vector2 array operator setter should work as expected." }
    }

    @Test
    fun `Interpolation methods`() {
        val vector1 = Vector2(1, 2)
        val vector2 = Vector2(4, 5)

        checkMessage(vector1.lerp(vector2, 0.5) == Vector2(2.5, 3.5)) { "Vector2 lerp should work as expected." }

        val lerpValue = 1.0 / 3.0
        checkMessage(vector1.lerp(vector2, lerpValue).isEqualApprox(Vector2(2, 3))) { "Vector2 lerp should work as expected." }

        checkMessage(
            vector1.normalized().slerp(vector2.normalized(), 0.5).isEqualApprox(Vector2(0.538953602313995361, 0.84233558177947998))
        ) { "Vector2 slerp should work as expected." }
        checkMessage(
            vector1.normalized().slerp(vector2.normalized(), lerpValue).isEqualApprox(Vector2(0.508990883827209473, 0.860771894454956055))
        ) { "Vector2 slerp should work as expected." }
        checkMessage(
            Vector2(5, 0).slerp(Vector2(0, 5), 0.5).isEqualApprox(Vector2(5, 5) * SQRT12)
        ) { "Vector2 slerp with non-normalized values should work as expected." }
        checkMessage(
            Vector2(1, 1).slerp(Vector2(2, 2), 0.5).isEqualApprox(Vector2(1.5, 1.5))
        ) { "Vector2 slerp with colinear inputs should behave as expected." }
        checkMessage(Vector2().slerp(Vector2(), 0.5) == Vector2()) { "Vector2 slerp with both inputs as zero vectors should return a zero vector." }
        checkMessage(Vector2().slerp(Vector2(1, 1), 0.5) == Vector2(0.5, 0.5)) { "Vector2 slerp with one input as zero should behave like a regular lerp." }
        checkMessage(Vector2(1, 1).slerp(Vector2(), 0.5) == Vector2(0.5, 0.5)) { "Vector2 slerp with one input as zero should behave like a regular lerp." }
        checkMessage(
            Vector2(4, 6).slerp(Vector2(8, 10), 0.5).isEqualApprox(Vector2(5.9076470794008017626, 8.07918879020090480697))
        ) { "Vector2 slerp should work as expected." }

        val slerpLength = vector1.slerp(vector2, 0.5).length()
        checkMessage(
            slerpLength.isEqualApprox(4.31959610746631919)
        ) { "Vector2 slerp with different length input should return a vector with an interpolated length." }

        val slerpAngle = vector1.angleTo(vector1.slerp(vector2, 0.5)) * 2
        val originalAngle = vector1.angleTo(vector2)
        checkMessage(
            slerpAngle.isEqualApprox(originalAngle)
        ) { "Vector2 slerp with different length input should return a vector with an interpolated angle." }

        val cubicInterpolationResult = vector1.cubicInterpolate(vector2, Vector2(), Vector2(7, 7), 0.5)
        checkMessage(cubicInterpolationResult == Vector2(2.375, 3.5)) { "Vector2 cubic_interpolate should work as expected." }

        val cubicInterpolationResult2 = vector1.cubicInterpolate(vector2, Vector2(), Vector2(7, 7), 1.0 / 3.0)
        checkMessage(
            cubicInterpolationResult2.isEqualApprox(
                Vector2(
                    1.851851940155029297,
                    2.962963104248046875
                )
            )
        ) { "Vector2 cubic_interpolate should work as expected." }

        val moveTowardResult = Vector2(1, 0).moveToward(Vector2(10, 0), 3.0)
        checkMessage(moveTowardResult == Vector2(4, 0)) { "Vector2 move_toward should work as expected." }

        checkMessage(
            Vector2(1, 0).rotateToward(
                Vector2(0, 1),
                PI * 0.25
            ).isEqualApprox(Vector2(SQRT12, SQRT12))
        ) { "Vector2 rotate_toward should work as expected." }
        checkMessage(
            Vector2(0, 1).rotateToward(
                Vector2(1, 0),
                PI * 0.25
            ).isEqualApprox(Vector2(SQRT12, SQRT12))
        ) { "Vector2 rotate_toward should work as expected." }

        checkMessage(
            Vector2(1, 0).rotateToward(
                Vector2(0, 1),
                -PI * 0.5
            ).isEqualApprox(Vector2(0, -1))
        ) { "Vector2 rotate_toward with negative delta should behave as expected." }
        checkMessage(
            Vector2(1, 1).rotateToward(
                Vector2(10, 10),
                0.5
            ).isEqualApprox(Vector2(6, 6))
        ) { "Vector2 rotate_toward with colinear inputs should behave as expected." }
        checkMessage(
            Vector2(10, 10).rotateToward(
                Vector2(0, 0),
                0.5
            ).isEqualApprox(Vector2(5, 5))
        ) { "Vector2 rotate_toward with second input as zero should behave as expected." }
    }

    @Test
    fun `Length methods`() {
        val vector1 = Vector2(10.0, 10.0)
        val vector2 = Vector2(20.0, 30.0)

        checkMessage(vector1.lengthSquared() == 200.0) { "Vector2 lengthSquared should work as expected and return the exact result." }
        checkMessage(vector1.length().isEqualApprox(10.0 * SQRT2)) { "Vector2 length should work as expected." }
        checkMessage(vector2.lengthSquared() == 1300.0) { "Vector2 lengthSquared should work as expected and return the exact result." }
        checkMessage(vector2.length().isEqualApprox(36.05551275463989293119)) { "Vector2 length should work as expected." }
        checkMessage(vector1.distanceSquaredTo(vector2) == 500.0) { "Vector2 distanceSquaredTo should work as expected and return the exact result." }
        checkMessage(vector1.distanceTo(vector2).isEqualApprox(22.36067977499789696409)) { "Vector2 distanceTo should work as expected." }
    }

    @Test
    fun `Vector2 limiting methods`() {
        val vector = Vector2(10.0, 10.0)

        checkMessage(vector.limitLength().isEqualApprox(Vector2(SQRT12, SQRT12))) { "Vector2 limit_length should work as expected." }
        checkMessage(vector.limitLength(5.0).isEqualApprox(Vector2(5 * SQRT12, 5 * SQRT12))) { "Vector2 limit_length should work as expected." }

        val v1 = Vector2(-5.0, 15.0)
        val v2 = Vector2(0.0, 10.0)
        checkMessage(v1.clamp(Vector2(), v2).isEqualApprox(Vector2(0.0, 10.0))) { "Vector2 clamp should work as expected." }

        val v3 = Vector2(10.0, 10.0)
        val v4 = Vector2(0.0, 15.0)
        val v5 = Vector2(5.0, 20.0)
        checkMessage(v3.clamp(v4, v5).isEqualApprox(Vector2(5.0, 15.0))) { "Vector2 clamp should work as expected." }
    }

    @Test
    fun `Vector2 normalization methods`() {
        checkMessage(Vector2(1.0, 0.0).isNormalized()) { "Vector2 isNormalized should return true for a normalized vector." }
        checkFalseMessage(Vector2(1.0, 1.0).isNormalized()) { "Vector2 isNormalized should return false for a non-normalized vector." }
        checkMessage(Vector2(1.0, 0.0).normalized() == Vector2(1.0, 0.0)) { "Vector2 normalized should return the same vector for a normalized vector." }

        val expectedNormalized = Vector2(sqrt(0.5), sqrt(0.5))
        checkMessage(Vector2(1.0, 1.0).normalized().isEqualApprox(expectedNormalized)) { "Vector2 normalized should work as expected." }

        val vector = Vector2(3.2, -5.4)
        vector.normalize()
        checkMessage(vector == Vector2(3.2, -5.4).normalized()) { "Vector2 normalize should convert the same way as Vector2 normalized." }
        val expectedNormalizedVector = Vector2(0.5098023903017329, -0.8602915336341743)
        checkMessage(vector.isEqualApprox(expectedNormalizedVector)) { "Vector2 normalize should work as expected." }
    }

    @Test
    fun `Operators`() {
        val decimal1 = Vector2(2.3, 4.9)
        val decimal2 = Vector2(1.2, 3.4)
        val power1 = Vector2(0.75, 1.5)
        val power2 = Vector2(0.5, 0.125)
        val int1 = Vector2(4.0, 5.0)
        val int2 = Vector2(1.0, 2.0)

        checkMessage((decimal1 + decimal2).isEqualApprox(Vector2(3.5, 8.3))) { "Vector2 addition should behave as expected." }
        checkMessage((power1 + power2) == Vector2(1.25, 1.625)) { "Vector2 addition with powers of two should give exact results." }
        checkMessage((int1 + int2) == Vector2(5.0, 7.0)) { "Vector2 addition with integers should give exact results." }

        checkMessage((decimal1 - decimal2).isEqualApprox(Vector2(1.1, 1.5))) { "Vector2 subtraction should behave as expected." }
        checkMessage((power1 - power2) == Vector2(0.25, 1.375)) { "Vector2 subtraction with powers of two should give exact results." }
        checkMessage((int1 - int2) == Vector2(3.0, 3.0)) { "Vector2 subtraction with integers should give exact results." }

        checkMessage((decimal1 * decimal2).isEqualApprox(Vector2(2.76, 16.66))) { "Vector2 multiplication should behave as expected." }
        checkMessage((power1 * power2) == Vector2(0.375, 0.1875)) { "Vector2 multiplication with powers of two should give exact results." }
        checkMessage((int1 * int2) == Vector2(4.0, 10.0)) { "Vector2 multiplication with integers should give exact results." }

        checkMessage((decimal1 / decimal2).isEqualApprox(Vector2(1.91666666666666666, 1.44117647058823529))) { "Vector2 division should behave as expected." }
        checkMessage((power1 / power2) == Vector2(1.5, 12.0)) { "Vector2 division with powers of two should give exact results." }
        checkMessage((int1 / int2) == Vector2(4.0, 2.5)) { "Vector2 division with integers should give exact results." }

        checkMessage((decimal1 * 2.0).isEqualApprox(Vector2(4.6, 9.8))) { "Vector2 multiplication should behave as expected." }
        checkMessage((power1 * 2.0) == Vector2(1.5, 3.0)) { "Vector2 multiplication with powers of two should give exact results." }
        checkMessage((int1 * 2.0) == Vector2(8.0, 10.0)) { "Vector2 multiplication with integers should give exact results." }

        checkMessage((decimal1 / 2.0).isEqualApprox(Vector2(1.15, 2.45))) { "Vector2 division should behave as expected." }
        checkMessage((power1 / 2.0) == Vector2(0.375, 0.75)) { "Vector2 division with powers of two should give exact results." }
        checkMessage((int1 / 2.0) == Vector2(2.0, 2.5)) { "Vector2 division with integers should give exact results." }

        checkMessage((decimal1.toVector2i()) == Vector2i(2, 4)) { "Vector2 cast to Vector2i should work as expected." }
        checkMessage((decimal2.toVector2i()) == Vector2i(1, 3)) { "Vector2 cast to Vector2i should work as expected." }
        checkMessage(Vector2(Vector2i(1, 2)) == Vector2(1.0, 2.0)) { "Vector2 constructed from Vector2i should work as expected." }

        checkMessage((decimal1.toString()) == "(2.3, 4.9)") { "Vector2 cast to String should work as expected." }
        checkMessage((decimal2.toString()) == "(1.2, 3.4)") { "Vector2 cast to String should work as expected." }
        checkMessage((Vector2(9.8, 9.9).toString()) == "(9.8, 9.9)") { "Vector2 cast to String should work as expected." }

        checkMessage(
            Vector2(
                PI,
                TAU
            ).toString() == "(3.141592653589793, 6.283185307179586)"
        ) { "Vector2 cast to String should print the correct amount of digits for RealT = Double" }
    }

    @Test
    fun `Other methods`() {
        val vector = Vector2(1.2, 3.4)
        checkMessage(vector.aspect() == (1.2 / 3.4)) { "Vector2 aspect should work as expected." }

        checkMessage(vector.directionTo(Vector2()).isEqualApprox(-vector.normalized())) { "Vector2 directionTo should work as expected." }
        checkMessage(Vector2(1.0, 1.0).directionTo(Vector2(2.0, 2.0)).isEqualApprox(Vector2(SQRT12, SQRT12))) { "Vector2 directionTo should work as expected." }

        checkMessage(vector.posmod(2.0).isEqualApprox(Vector2(1.2, 1.4))) { "Vector2 posmod should work as expected." }
        checkMessage((-vector).posmod(2.0).isEqualApprox(Vector2(0.8, 0.6))) { "Vector2 posmod should work as expected." }
        checkMessage(vector.posmodv(Vector2(1.0, 2.0)).isEqualApprox(Vector2(0.2, 1.4))) { "Vector2 posmodv should work as expected." }
        checkMessage((-vector).posmodv(Vector2(2.0, 3.0)).isEqualApprox(Vector2(0.8, 2.6))) { "Vector2 posmodv should work as expected." }

        checkMessage(vector.rotated(TAU).isEqualApprox(Vector2(1.2, 3.4))) { "Vector2 rotated should work as expected." }
        checkMessage(vector.rotated(TAU / 4).isEqualApprox(Vector2(-3.4, 1.2))) { "Vector2 rotated should work as expected." }
        checkMessage(
            vector.rotated(TAU / 3).isEqualApprox(Vector2(-3.544486372867091398996, -0.660769515458673623883))
        ) { "Vector2 rotated should work as expected." }
        checkMessage(vector.rotated(TAU / 2).isEqualApprox(vector.rotated(TAU / -2))) { "Vector2 rotated should work as expected." }

        checkMessage(vector.snapped(Vector2(1.0, 1.0)) == Vector2(1.0, 3.0)) { "Vector2 snapped to integers should be the same as rounding." }
        checkMessage(
            Vector2(3.4, 5.6).snapped(Vector2(1.0, 1.0)).isEqualApprox(Vector2(3.0, 6.0))
        ) { "Vector2 snapped to integers should be the same as rounding." }
        checkMessage(vector.snapped(Vector2(0.25, 0.25)).isEqualApprox(Vector2(1.25, 3.5))) { "Vector2 snapped to 0.25 should give exact results." }
    }

    @Test
    fun `Plane methods`() {
        val vector = Vector2(1.2, 3.4)
        val vectorY = Vector2(0.0, 1.0)
        val vectorNormal = Vector2(0.9587981127083872, 0.284088329691374)
        val vectorNonNormal = Vector2(5.4, 1.6)

        checkMessage(vector.bounce(vectorY) == Vector2(1.2, -3.4)) { "Vector2 bounce on a plane with normal of the Y axis should." }

        val expectedBounce = Vector2(-2.858511979823455, 2.197477931904161)
        checkMessage(vector.bounce(vectorNormal).isEqualApprox(expectedBounce)) { "Vector2 bounce with normal should return the expected value." }

        checkMessage(vector.reflect(vectorY) == Vector2(-1.2, 3.4)) { "Vector2 reflect on a plane with normal of the Y axis should." }

        val expectedReflect = Vector2(2.858511979823455, -2.197477931904161)
        checkMessage(vector.reflect(vectorNormal).isEqualApprox(expectedReflect)) { "Vector2 reflect with normal should return the expected value." }

        checkMessage(vector.project(vectorY) == Vector2(0.0, 3.4)) { "Vector2 projected on the Y axis should only give the Y component." }

        val expectedProjection = Vector2(2.0292559899117276, 0.6012610340479193)
        checkMessage(vector.project(vectorNormal).isEqualApprox(expectedProjection)) { "Vector2 projected on a normal should return the expected value." }

        checkMessage(vector.slide(vectorY) == Vector2(1.2, 0.0)) { "Vector2 slide on a plane with normal of the Y axis should set the Y component to zero." }

        val expectedSlide = Vector2(-0.8292559899117276, 2.798738965952081)
        checkMessage(vector.slide(vectorNormal).isEqualApprox(expectedSlide)) { "Vector2 slide with normal should return the expected value." }
    }

    @Test
    fun `Rounding methods`() {
        val vector1 = Vector2(1.2, 5.6)
        val vector2 = Vector2(1.2, -5.6)

        checkMessage(vector1.abs().isEqualApprox(vector1)) { "Vector2 abs should work as expected." }
        checkMessage(vector2.abs().isEqualApprox(vector1)) { "Vector2 abs should work as expected." }

        checkMessage(vector1.ceil().isEqualApprox(Vector2(2.0, 6.0))) { "Vector2 ceil should work as expected." }
        checkMessage(vector2.ceil().isEqualApprox(Vector2(2.0, -5.0))) { "Vector2 ceil should work as expected." }

        checkMessage(vector1.floor().isEqualApprox(Vector2(1.0, 5.0))) { "Vector2 floor should work as expected." }
        checkMessage(vector2.floor().isEqualApprox(Vector2(1.0, -6.0))) { "Vector2 floor should work as expected." }

        checkMessage(vector1.round().isEqualApprox(Vector2(1.0, 6.0))) { "Vector2 round should work as expected." }
        checkMessage(vector2.round().isEqualApprox(Vector2(1.0, -6.0))) { "Vector2 round should work as expected." }

        checkMessage(vector1.sign().isEqualApprox(Vector2(1.0, 1.0))) { "Vector2 sign should work as expected." }
        checkMessage(vector2.sign().isEqualApprox(Vector2(1.0, -1.0))) { "Vector2 sign should work as expected." }
    }

    @Test
    fun `Linear algebra methods`() {
        val vectorX = Vector2(1.0, 0.0)
        val vectorY = Vector2(0.0, 1.0)
        val a = Vector2(3.5, 8.5)
        val b = Vector2(5.2, 4.6)

        checkMessage(vectorX.cross(vectorY) == 1.0) { "Vector2 cross product of X and Y should give 1." }
        checkMessage(vectorY.cross(vectorX) == -1.0) { "Vector2 cross product of Y and X should give negative 1." }
        checkMessage(a.cross(b).isEqualApprox(-28.1)) { "Vector2 cross should return expected value." }
        checkMessage(Vector2(-a.x, a.y).cross(Vector2(b.x, -b.y)).isEqualApprox(-28.1)) { "Vector2 cross should return expected value." }

        checkMessage(vectorX.dot(vectorY) == 0.0) { "Vector2 dot product of perpendicular vectors should be zero." }
        checkMessage(vectorX.dot(vectorX) == 1.0) { "Vector2 dot product of identical unit vectors should be one." }
        checkMessage((vectorX * 10).dot(vectorX * 10) == 100.0) { "Vector2 dot product of same direction vectors should behave as expected." }
        checkMessage(a.dot(b).isEqualApprox(57.3)) { "Vector2 dot should return the expected value." }
        checkMessage(Vector2(-a.x, a.y).dot(Vector2(b.x, -b.y)).isEqualApprox(-57.3)) { "Vector2 dot should return the expected value." }
    }

    @Test
    fun `Finite number checks`() {
        val infinite = doubleArrayOf(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)

        checkMessage(Vector2(0.0, 1.0).isFinite()) { "Vector2(0, 1) should be finite" }

        for (x in infinite) {
            checkFalseMessage(Vector2(x, 1.0).isFinite()) { "Vector2 with one component infinite should not be finite." }
            checkFalseMessage(Vector2(0.0, x).isFinite()) { "Vector2 with one component infinite should not be finite." }
        }

        for (x in infinite) {
            for (y in infinite) {
                checkFalseMessage(Vector2(x, y).isFinite()) { "Vector2 with two components infinite should not be finite." }
            }
        }
    }

    @Test
    fun `Move toward returns a copy`() {
        val from = Vector2(1, 2)
        val to = Vector2(4, 5)

        val reached = from.moveToward(to, 100.0)
        checkTrue(reached == to)
        checkTrue(reached !== to)
        reached.x = 99.0
        checkTrue(to == Vector2(4, 5))

        val same = from.moveToward(from, 1.0)
        checkTrue(same !== from)

        val partial = from.moveToward(to, 1.0)
        checkTrue((partial - from).length().isEqualApprox(1.0))
    }

    @Test
    fun `Rotate toward returns a copy`() {
        val from = Vector2(1, 0)
        val to = Vector2(0, 1)
        val reached = from.rotateToward(to, 100.0)
        checkTrue(reached.isEqualApprox(to))
        reached.x = 99.0
        checkTrue(to == Vector2(0, 1))
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Vector2(1, 2)
        val b = Vector2(4, -5)
        val aCopy = Vector2(a)
        val bCopy = Vector2(b)

        val operations = listOf<() -> Any>(
            { a + b },
            { a - b },
            { a * b },
            { a / b },
            { a * 2.0 },
            { -a },
            { a.normalized() },
            { a.abs() },
            { a.lerp(b, 0.5) },
            { a.slerp(b, 0.5) },
            { a.limitLength(1.0) },
            { a.project(b) },
            { a.reflect(b.normalized()) },
            { a.slide(b.normalized()) },
            { a.bounce(b.normalized()) },
            { a.rotated(1.0) },
            { a.snapped(Vector2(2, 2)) },
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
    fun `round rounds halfway cases away from zero`() {
        val rounded = Vector2(2.5, -2.5).round()
        checkTrue(rounded.x == 3.0)
        checkTrue(rounded.y == -3.0)
    }

    @Test
    fun `isNormalized tolerates 0_001 on the squared length`() {
        checkTrue(Vector2(1.0004, 0.0).isNormalized())
    }

    @Test
    fun `clamp does not throw when min is greater than max`() {
        val clamped = Vector2(5.0, 5.0).clamp(Vector2(3.0, 3.0), Vector2(1.0, 1.0))
        checkTrue(clamped.x == 1.0)
        checkTrue(clamped.y == 1.0)
        val clampedf = Vector2(5.0, 5.0).clampf(3.0, 1.0)
        checkTrue(clampedf.x == 1.0)
        checkTrue(clampedf.y == 1.0)
    }

    @Test
    fun `round is exact for values next to half and for large odd integers`() {
        val rounded = Vector2(0.49999999999999994, 4503599627370497.0).round()
        checkTrue(rounded.x == 0.0)
        checkTrue(rounded.y == 4503599627370497.0)
    }

    @Test
    fun `isZeroApprox compares each absolute component to CMP_EPSILON`() {
        checkTrue(Vector2(1e-6, 1e-6).isZeroApprox())
        checkTrue(Vector2(-1e-6, 1e-6).isZeroApprox())
        checkTrue(!Vector2(1e-5, 0.0).isZeroApprox())
        checkTrue(!Vector2(0.0, 1e-5).isZeroApprox())
        checkTrue(!Vector2(2.0, 0.0).isZeroApprox())
        checkTrue(!Vector2(0.0, -2.0).isZeroApprox())
    }

    @Test
    fun `fromAngle is static`() {
        checkTrue(Vector2.fromAngle(PI / 2.0).isEqualApprox(Vector2(0.0, 1.0)))
    }

    @Test
    fun `isEqualApprox uses the receiver for the relative tolerance`() {
        checkTrue(!Vector2(1000000.0, 0.0).isEqualApprox(Vector2(1000010.000005, 0.0)))
    }

    @Test
    fun `rotateToward with a zero delta on identical vectors returns the vector`() {
        val result = Vector2(1.0, 0.0).rotateToward(Vector2(1.0, 0.0), 0.0)
        checkTrue(result.isEqualApprox(Vector2(1.0, 0.0)))
    }

    @Test
    fun `rotateToward with a negative delta rotates away from the target`() {
        val result = Vector2(1.0, 0.0).rotateToward(Vector2(0.0, 1.0), -PI)
        checkTrue(result.isEqualApprox(Vector2(-1.0, 0.0)))
    }

    @Test
    fun `unaryPlus returns an equal copy`() {
        val v = Vector2(1.0, -2.0)
        val plus = +v
        checkTrue(plus == v && plus !== v)
        plus.x = 5.0
        checkTrue(v.x == 1.0)
    }

    @Test
    fun `hashCode ignores the sign of zero`() {
        checkTrue(Vector2(0.0, 0.0).hashCode() == Vector2(-0.0, 0.0).hashCode())
        checkTrue(Vector2(0.0, 0.0).hashCode() == Vector2(0.0, -0.0).hashCode())
    }

    @Test
    fun `equals is exact`() {
        checkTrue(Vector2(1.0, 0.0) != Vector2(1.000001, 0.0))
        checkTrue(Vector2(1.0, 0.0) != Vector2(1.0, 0.000001))
        checkTrue(Vector2(1.0, 2.0) == Vector2(1.0, 2.0))
        checkTrue(Vector2(0.0, 0.0) == Vector2(-0.0, 0.0))
    }

    @Test
    fun `equal vectors have equal hash codes`() {
        checkTrue(Vector2(1.5, -2.25).hashCode() == Vector2(1.5, -2.25).hashCode())
        checkTrue(Vector2(0.0, 3.0).hashCode() == Vector2(-0.0, 3.0).hashCode())
    }

    @Test
    fun `reflect slide and bounce return zero for a non normalized normal in debug`() {
        val v = Vector2(1, 1)
        val bad = Vector2(2, 0)
        checkTrue(v.reflect(bad) == Vector2())
        checkTrue(v.slide(bad) == Vector2())
        checkTrue(v.bounce(bad) == Vector2())
        checkTrue(v == Vector2(1, 1))
        checkTrue(bad == Vector2(2, 0))
    }

    @Test
    fun `normalize falls back to zero for non finite components in debug`() {
        checkTrue(Vector2(Double.NaN, 1.0).normalized() == Vector2())
        checkTrue(Vector2(Double.POSITIVE_INFINITY, 1.0).directionTo(Vector2()) == Vector2())
    }

    @Test
    fun `compareTo follows the C++ comparison operators`() {
        val a = Vector2(1.0, 5.0)
        val sameX = Vector2(1.0, 6.0)
        val greaterX = Vector2(2.0, 0.0)

        checkTrue(a < sameX)
        checkTrue(a <= sameX)
        checkTrue(sameX > a)
        checkTrue(sameX >= a)
        checkTrue(a < greaterX)
        checkTrue(greaterX > a)
        checkTrue(a <= Vector2(1.0, 5.0))
        checkTrue(a >= Vector2(1.0, 5.0))
        checkTrue(a.compareTo(Vector2(1.0, 5.0)) == 0)
        checkTrue(a.compareTo(sameX) == -1)
        checkTrue(sameX.compareTo(a) == 1)
        checkTrue(greaterX.compareTo(a) == 1)
        checkTrue(a.compareTo(greaterX) == -1)
        checkTrue(Vector2(1.0, 0.0) < Vector2(1.000001, -5.0))
        checkTrue(Vector2(1.000001, 0.0) > Vector2(1.0, 5.0))
    }
}
