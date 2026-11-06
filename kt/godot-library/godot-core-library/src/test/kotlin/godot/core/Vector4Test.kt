@file:Suppress("FloatingPointLiteralPrecision", "RemoveRedundantBackticks")

package godot.core

import godot.common.util.SQRT2
import godot.common.util.isEqualApprox
import org.junit.Test

private const val SQRT3 = 1.7320508075688772935274463415059

class TestVector4 {
    @Test
    fun `Constructor Methods`() {
        val vectorEmpty = Vector4()
        val vectorZero = Vector4(0.0, 0.0, 0.0, 0.0)
        checkTrue(vectorEmpty == vectorZero)
    }

    @Test
    fun `Axis Methods`() {
        val vector = Vector4(1.2, 3.4, 5.6, -0.9)
        checkTrue(vector.maxAxis() == Vector4.Axis.Z)
        checkTrue(vector.minAxis() == Vector4.Axis.W)
        checkTrue(vector[vector.maxAxis()] == 5.6)
        checkTrue(vector[vector.minAxis()] == -0.9)
        vector[Vector4.Axis.Y] = 3.7
        checkTrue(vector[Vector4.Axis.Y] == 3.7)
    }

    @Test
    fun `Interpolation Methods`() {
        val vector1 = Vector4(1.0, 2.0, 3.0, 4.0)
        val vector2 = Vector4(4.0, 5.0, 6.0, 7.0)
        checkTrue(vector1.lerp(vector2, 0.5) == Vector4(2.5, 3.5, 4.5, 5.5))
        checkTrue(vector1.lerp(vector2, 1.0 / 3.0).isEqualApprox(Vector4(2.0, 3.0, 4.0, 5.0)))
        checkTrue(
            vector1.cubicInterpolate(vector2, Vector4(), Vector4(7.0, 7.0, 7.0, 7.0), 0.5).isEqualApprox(
                Vector4(2.375, 3.5, 4.625, 5.75)
            )
        )
        checkTrue(
            vector1.cubicInterpolate(vector2, Vector4(), Vector4(7.0, 7.0, 7.0, 7.0), 1.0 / 3.0)
                .isEqualApprox(
                    Vector4(
                        1.851851940155029297,
                        2.962963104248046875,
                        4.074074268341064453,
                        5.185185185185
                    )
                )
        )
    }

    @Test
    fun `Length Methods`() {
        val vector1 = Vector4(10.0, 10.0, 10.0, 10.0)
        val vector2 = Vector4(20.0, 30.0, 40.0, 50.0)
        checkTrue(vector1.lengthSquared() == 400.0)
        checkTrue(vector1.length().isEqualApprox(20.0))
        checkTrue(vector2.lengthSquared() == 5400.0)
        checkTrue(vector2.length().isEqualApprox(73.484692283495))
        checkTrue(vector1.distanceTo(vector2).isEqualApprox(54.772255750517))
        checkTrue(vector1.distanceSquaredTo(vector2).isEqualApprox(3000.0))
    }

    @Test
    fun `Limiting Methods`() {
        val vector = Vector4(10.0, 10.0, 10.0, 10.0)
        checkTrue(vector.clamp(Vector4(), vector) == Vector4(10.0, 10.0, 10.0, 10.0))
        checkTrue(
            vector.clamp(Vector4(0.0, 10.0, 15.0, 18.0), Vector4(5.0, 10.0, 20.0, 25.0))
                == Vector4(5.0, 10.0, 15.0, 18.0)
        )
    }

    @Test
    fun `Normalization Methods`() {
        checkTrue(Vector4(1.0, 0.0, 0.0, 0.0).isNormalized())
        checkFalse(Vector4(1.0, 1.0, 1.0, 1.0).isNormalized())
        checkTrue(Vector4(1.0, 0.0, 0.0, 0.0).normalized() == Vector4(1.0, 0.0, 0.0, 0.0))
        checkTrue(
            Vector4(1.0, 1.0, 0.0, 0.0).normalized()
                .isEqualApprox(Vector4(0.7071067811865476, 0.7071067811865476, 0.0, 0.0))
        )
        checkTrue(Vector4(1.0, 1.0, 1.0, 1.0).normalized().isEqualApprox(Vector4(0.5, 0.5, 0.5, 0.5)))
    }

    @Test
    fun `Operators`() {
        val decimal1 = Vector4(2.3, 4.9, 7.8, 3.2)
        val decimal2 = Vector4(1.2, 3.4, 5.6, 1.7)
        val power1 = Vector4(0.75, 1.5, 0.625, 0.125)
        val power2 = Vector4(0.5, 0.125, 0.25, 0.75)
        val int1 = Vector4(4.0, 5.0, 9.0, 2.0)
        val int2 = Vector4(1.0, 2.0, 3.0, 1.0)

        checkTrue(-decimal1 == Vector4(-2.3, -4.9, -7.8, -3.2))
        check((decimal1 + decimal2).isEqualApprox(Vector4(3.5, 8.3, 13.4, 4.9)))
        checkTrue(power1 + power2 == Vector4(1.25, 1.625, 0.875, 0.875))
        checkTrue(int1 + int2 == Vector4(5.0, 7.0, 12.0, 3.0))

        check((decimal1 - decimal2).isEqualApprox(Vector4(1.1, 1.5, 2.2, 1.5)))
        checkTrue(power1 - power2 == Vector4(0.25, 1.375, 0.375, -0.625))
        checkTrue(int1 - int2 == Vector4(3.0, 3.0, 6.0, 1.0))

        check((decimal1 * decimal2).isEqualApprox(Vector4(2.76, 16.66, 43.68, 5.44)))
        check(power1 * power2 == Vector4(0.375, 0.1875, 0.15625, 0.09375))
        check(int1 * int2 == Vector4(4.0, 10.0, 27.0, 2.0))

        check(
            (decimal1 / decimal2).isEqualApprox(Vector4(1.9166666666666667, 1.4411764705882353, 1.3928571428571428, 1.8823529411764706))
        )
        check(power1 / power2 == Vector4(1.5, 12.0, 2.5, 0.16666666666666666))
        check(int1 / int2 == Vector4(4.0, 2.5, 3.0, 2.0))

        check((decimal1 * 2.0).isEqualApprox(Vector4(4.6, 9.8, 15.6, 6.4)))
        check(power1 * 2.0 == Vector4(1.5, 3.0, 1.25, 0.25))
        check(int1 * 2.0 == Vector4(8.0, 10.0, 18.0, 4.0))

        check((decimal1 / 2.0).isEqualApprox(Vector4(1.15, 2.45, 3.9, 1.6)))
        check(power1 / 2.0 == Vector4(0.375, 0.75, 0.3125, 0.0625))
        check(int1 / 2.0 == Vector4(2.0, 2.5, 4.5, 1.0))

        check(decimal1.toString() == "(2.3, 4.9, 7.8, 3.2)")
        check(decimal2.toString() == "(1.2, 3.4, 5.6, 1.7)")
        check(Vector4(9.7, 9.8, 9.9, -1.8).toString() == "(9.7, 9.8, 9.9, -1.8)")

        // Please note that the precision of floating-point numbers may vary, so adjust the comparison as needed.
        // The following checks are approximate comparisons.
        check(
            Vector4(Math.E, SQRT2, SQRT3, SQRT3).toString() == "(2.718281828459045, 1.4142135623730951, 1.7320508075688772, 1.7320508075688772)"
        )
    }

    @Test
    fun `Other Methods`() {
        val vector = Vector4(1.2, 3.4, 5.6, 1.6)
        checkTrue(vector.directionTo(Vector4()).isEqualApprox(-vector.normalized()))
        checkTrue(
            Vector4(1.0, 1.0, 1.0, 1.0).directionTo(
                Vector4(2.0, 2.0, 2.0, 2.0)
            ).isEqualApprox(
                Vector4(
                    0.5, +
                    0.5,
                    0.5,
                    0.5
                )
            )
        )
        checkTrue(vector.inverse().isEqualApprox(Vector4(1.0 / 1.2, 1.0 / 3.4, 1.0 / 5.6, 1.0 / 1.6)))
        checkTrue(vector.posmod(2.0).isEqualApprox(Vector4(1.2, 1.4, 1.6, 1.6)))
        checkTrue((-vector).posmod(2.0).isEqualApprox(Vector4(0.8, 0.6, 0.4, 0.4)))
        checkTrue(vector.posmodv(Vector4(1.0, 2.0, 3.0, 4.0)).isEqualApprox(Vector4(0.2, 1.4, 2.6, 1.6)))
        checkTrue((-vector).posmodv(Vector4(2.0, 3.0, 4.0, 5.0)).isEqualApprox(Vector4(0.8, 2.6, 2.4, 3.4)))
        check(
            vector.snapped(Vector4(1.0, 1.0, 1.0, 1.0)) == Vector4(1.0, 3.0, 6.0, 2.0)
        )

        check(
            vector.snapped(Vector4(0.25, 0.25, 0.25, 0.25)) == Vector4(1.25, 3.5, 5.5, 1.5)
        )
    }

    @Test
    fun `Rounding Methods`() {
        val vector1 = Vector4(1.2, 3.4, 5.6, 1.6)
        val vector2 = Vector4(1.2, -3.4, -5.6, -1.6)
        check(vector1.abs() == vector1)
        check(vector2.abs() == vector1)
        check(vector1.ceil() == Vector4(2.0, 4.0, 6.0, 2.0))
        check(vector2.ceil() == Vector4(2.0, -3.0, -5.0, -1.0))
        check(vector1.floor() == Vector4(1.0, 3.0, 5.0, 1.0))
        check(vector2.floor() == Vector4(1.0, -4.0, -6.0, -2.0))
        check(vector1.round() == Vector4(1.0, 3.0, 6.0, 2.0))
        check(vector2.round() == Vector4(1.0, -3.0, -6.0, -2.0))
        check(vector1.sign() == Vector4(1.0, 1.0, 1.0, 1.0))
        check(vector2.sign() == Vector4(1.0, -1.0, -1.0, -1.0))
    }

    @Test
    fun `Linear Algebra Methods`() {
        val vectorX = Vector4(1.0, 0.0, 0.0, 0.0)
        val vectorY = Vector4(0.0, 1.0, 0.0, 0.0)
        val vector1 = Vector4(1.7, 2.3, 1.0, 9.1)
        val vector2 = Vector4(-8.2, -16.0, 3.0, 2.4)

        checkTrue(vectorX.dot(vectorY) == 0.0)
        checkTrue(vectorX.dot(vectorX) == 1.0)
        checkTrue((vectorX * 10.0).dot(vectorX * 10.0) == 100.0)
        checkTrue((vector1 * 2.0).dot(vector2 * 4.0).isEqualApprox(-25.9 * 8.0))
    }

    @Test
    fun `Finite Number Checks`() {
        checkTrue(Vector4(0.0, 1.0, 2.0, 3.0).isFinite())

        val infinite = doubleArrayOf(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)

        for (x in infinite) {
            checkFalse(Vector4(x, 1.0, 2.0, 3.0).isFinite())
            checkFalse(Vector4(0.0, x, 2.0, 3.0).isFinite())
            checkFalse(Vector4(0.0, 1.0, x, 3.0).isFinite())
            checkFalse(Vector4(0.0, 1.0, 2.0, x).isFinite())
        }

        for (x in infinite) {
            for (y in infinite) {
                checkFalse(Vector4(x, y, 2.0, 3.0).isFinite())
                checkFalse(Vector4(x, 1.0, y, 3.0).isFinite())
                checkFalse(Vector4(x, 1.0, 2.0, y).isFinite())
                checkFalse(Vector4(0.0, x, y, 3.0).isFinite())
                checkFalse(Vector4(0.0, x, 2.0, y).isFinite())
                checkFalse(Vector4(0.0, 1.0, x, y).isFinite())
            }
        }

        for (x in infinite) {
            for (y in infinite) {
                for (z in infinite) {
                    checkFalse(Vector4(0.0, x, y, z).isFinite())
                    checkFalse(Vector4(x, 1.0, y, z).isFinite())
                    checkFalse(Vector4(x, y, 2.0, z).isFinite())
                    checkFalse(Vector4(x, y, z, 3.0).isFinite())
                }
            }
        }

        for (x in infinite) {
            for (y in infinite) {
                for (z in infinite) {
                    for (w in infinite) {
                        checkFalse(Vector4(x, y, z, w).isFinite())
                    }
                }
            }
        }
    }

    @Test
    fun `Minimum is component wise`() {
        checkTrue(Vector4(1, 2, 3, 4).min(Vector4(4, 3, 2, 1)) == Vector4(1, 2, 2, 1))
        checkTrue(Vector4(1, 2, 3, 4).max(Vector4(4, 3, 2, 1)) == Vector4(4, 3, 3, 4))
    }

    @Test
    fun `Snap rounds to the step`() {
        val vector = Vector4(1.2, 2.7, -0.4, 3.1)
        val expected = Vector4(1.0, 2.5, -0.5, 3.0)
        checkTrue(vector.snappedf(0.5) == expected)
        checkTrue(Vector4(vector).also { it.snap(0.5) } == expected)
        checkTrue(Vector4(vector).also { it.snap(0.0) } == vector)
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Vector4(1, 2, 3, 4)
        val b = Vector4(4, -5, 6, 7)
        val aCopy = Vector4(a)
        val bCopy = Vector4(b)

        val operations = listOf<() -> Any>(
            { a + b },
            { a - b },
            { a * b },
            { a / b },
            { a * 2.0 },
            { -a },
            { a.normalized() },
            { a.abs() },
            { a.min(b) },
            { a.max(b) },
            { a.lerp(b, 0.5) },
            { a.inverse() },
            { a.snapped(Vector4(2, 2, 2, 2)) },
            { a.snappedf(2.0) },
            { a.directionTo(b) },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }

    @Test
    fun `isNormalized uses squared length with unit epsilon`() {
        checkTrue(Vector4(0.0, 0.0, 0.0, 1.0004).isNormalized())
        checkFalse(Vector4(0.0, 0.0, 0.0, 1.002).isNormalized())
    }

    @Test
    fun `clamp does not throw when min is greater than max`() {
        val clamped = Vector4(5.0, -5.0, 0.5, 2.0).clamp(Vector4(3.0, 3.0, 3.0, 3.0), Vector4(1.0, 1.0, 1.0, 1.0))
        checkTrue(clamped == Vector4(1.0, 3.0, 3.0, 3.0))
        checkTrue(Vector4(5.0, -5.0, 0.5, 2.0).clampf(3.0, 1.0) == Vector4(1.0, 3.0, 3.0, 3.0))
    }

    @Test
    fun `round rounds halves away from zero`() {
        checkTrue(Vector4(0.5, 2.5, -1.5, -2.5).round() == Vector4(1.0, 3.0, -2.0, -3.0))
        checkTrue(Vector4(0.4, -0.4, 1.6, -1.6).round() == Vector4(0.0, 0.0, 2.0, -2.0))
    }

    @Test
    fun `snap with a tiny step still snaps`() {
        val vector = Vector4(3.3e-6, 0.0, 0.0, 0.0)
        vector.snap(1e-6)
        checkTrue(vector.x == 3.0 * 1e-6)
    }

    @Test
    fun `isEqualApprox takes the tolerance from this vector`() {
        checkTrue(!Vector4(1e6, 0.0, 0.0, 0.0).isEqualApprox(Vector4(1000010.00005, 0.0, 0.0, 0.0)))
        checkTrue(Vector4(1000010.00005, 0.0, 0.0, 0.0).isEqualApprox(Vector4(1e6, 0.0, 0.0, 0.0)))
    }

    @Test
    fun `hashCode ignores the sign of zero`() {
        checkTrue(Vector4(0.0, 0.0, 0.0, 0.0) == Vector4(-0.0, 0.0, 0.0, 0.0))
        checkTrue(Vector4(0.0, 0.0, 0.0, 0.0).hashCode() == Vector4(-0.0, 0.0, 0.0, 0.0).hashCode())
        checkTrue(Vector4(1.0, 0.0, 2.0, 0.0).hashCode() == Vector4(1.0, -0.0, 2.0, -0.0).hashCode())
    }

    @Test
    fun `unaryPlus returns an equal copy`() {
        val v = Vector4(1.0, -2.0, 3.0, -4.0)
        val copy = +v
        checkTrue(copy == v)
        checkTrue(copy !== v)
    }

    @Test
    fun `times projection transforms by the transpose`() {
        val projection = Projection(
            Vector4(1.0, 2.0, 3.0, 4.0),
            Vector4(5.0, 6.0, 7.0, 8.0),
            Vector4(9.0, 10.0, 11.0, 12.0),
            Vector4(13.0, 14.0, 15.0, 16.0)
        )
        checkTrue(Vector4(1.0, 0.0, -1.0, 2.0) * projection == Vector4(6.0, 14.0, 22.0, 30.0))
    }

    @Test
    fun `axis index follows the C++ comparisons`() {
        val equal = Vector4(2.0, 2.0, 2.0, 2.0)
        checkTrue(equal.maxAxis() == Vector4.Axis.X)
        checkTrue(equal.minAxis() == Vector4.Axis.W)
        checkTrue(Vector4(Double.NaN, 1.0, 2.0, 3.0).maxAxis() == Vector4.Axis.X)
        checkTrue(Vector4(Double.NaN, 1.0, 2.0, 3.0).minAxis() == Vector4.Axis.X)
        checkTrue(Vector4(1.0, Double.NaN, 5.0, 5.0).maxAxis() == Vector4.Axis.Z)
        checkTrue(Vector4(1.0, Double.NaN, 5.0, 5.0).minAxis() == Vector4.Axis.X)
        checkTrue(Vector4(5.0, Double.NaN, 5.0, 5.0).minAxis() == Vector4.Axis.W)
    }

    @Test
    fun `normalized falls back to zero for non finite components`() {
        checkTrue(Vector4(Double.NaN, 0.0, 0.0, 0.0).normalized() == Vector4(0.0, 0.0, 0.0, 0.0))
        checkTrue(Vector4(0.0, Double.POSITIVE_INFINITY, 0.0, 1.0).normalized() == Vector4(0.0, 0.0, 0.0, 0.0))
    }

    @Test
    fun `isZeroApprox uses the absolute epsilon`() {
        checkTrue(Vector4(1e-6, -1e-6, 0.0, 1e-6).isZeroApprox())
        checkFalse(Vector4(1e-5, 0.0, 0.0, 0.0).isZeroApprox())
        checkFalse(Vector4(0.0, 0.0, 0.0, 2.0).isZeroApprox())
    }
}
