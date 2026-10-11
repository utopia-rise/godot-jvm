package godot.global

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.PI

private const val EPSILON = 1.0e-12
private const val FLOAT_EPSILON = 1.0e-5f
private const val TAU = 2.0 * PI

class GDTest {

    @Test
    fun `wrapi wraps an Int into min inclusive and max exclusive`() {
        assertEquals(-2, GD.wrapi(-6, -5, -1))
        assertEquals(5, GD.wrapi(5, 3, 10))
        assertEquals(3, GD.wrapi(3, 3, 10))
        assertEquals(3, GD.wrapi(10, 3, 10))
        assertEquals(1, GD.wrapi(13, 1, 13))
        assertEquals(10, GD.wrapi(-14, 1, 13))
        assertEquals(1, GD.wrapi(7, 0, 3))
        assertEquals(2, GD.wrapi(-1, 0, 3))
        assertEquals(12, GD.wrapi(12, 10, 25))
        assertEquals(1, GD.wrapi(-9, -3, 2))
        assertEquals(7, GD.wrapi(0, 7, 7))
        assertEquals(5, GD.wrapi(5, 10, 3))
    }

    @Test
    fun `wrapi wraps a Long into min inclusive and max exclusive`() {
        assertEquals(-2L, GD.wrapi(-6L, -5L, -1L))
        assertEquals(3L, GD.wrapi(10L, 3L, 10L))
        assertEquals(10L, GD.wrapi(-14L, 1L, 13L))
        assertEquals(1L, GD.wrapi(10_000_000_000L, 0L, 3L))
        assertEquals(7L, GD.wrapi(0L, 7L, 7L))
        assertEquals(5L, GD.wrapi(5L, 10L, 3L))
    }

    @Test
    fun `wrapf wraps a Double into min inclusive and max exclusive`() {
        assertEquals(-2.0, GD.wrapf(-6.0, -5.0, -1.0), EPSILON)
        assertEquals(5.5, GD.wrapf(5.5, 3.0, 10.0), EPSILON)
        assertEquals(3.0, GD.wrapf(3.0, 3.0, 10.0), EPSILON)
        assertEquals(3.0, GD.wrapf(10.0, 3.0, 10.0), EPSILON)
        assertEquals(12.0, GD.wrapf(12.0, 10.0, 25.0), EPSILON)
        assertEquals(26.0, GD.wrapf(26.0, 6.0, 30.0), EPSILON)
        assertEquals(9.5, GD.wrapf(-14.5, 1.0, 13.0), EPSILON)
        assertEquals(0.0, GD.wrapf(-1.0e-9, 0.0, 1.0), EPSILON)
        assertEquals(4.0 - TAU, GD.wrapf(4.0, -PI, PI), EPSILON)
        assertEquals(-2.25, GD.wrapf(-7.25, -3.0, 2.0), EPSILON)
        assertEquals(7.0, GD.wrapf(1.0, 7.0, 7.0), EPSILON)
        assertEquals(5.0, GD.wrapf(5.0, 10.0, 3.0), EPSILON)
    }

    @Test
    fun `wrapf wraps a Float into min inclusive and max exclusive`() {
        assertEquals(-2f, GD.wrapf(-6f, -5f, -1f), FLOAT_EPSILON)
        assertEquals(3f, GD.wrapf(10f, 3f, 10f), FLOAT_EPSILON)
        assertEquals(9.5f, GD.wrapf(-14.5f, 1f, 13f), FLOAT_EPSILON)
        assertEquals(0f, GD.wrapf(-1.0e-9f, 0f, 1f), FLOAT_EPSILON)
        assertEquals((4.0 - TAU).toFloat(), GD.wrapf(4f, -PI.toFloat(), PI.toFloat()), FLOAT_EPSILON)
        assertEquals(7f, GD.wrapf(1f, 7f, 7f), FLOAT_EPSILON)
        assertEquals(5f, GD.wrapf(5f, 10f, 3f), FLOAT_EPSILON)
    }

    @Test
    fun `posmod keeps the sign of the divisor`() {
        assertEquals(2, GD.posmod(-7, 3))
        assertEquals(-2, GD.posmod(7, -3))
        assertEquals(1, GD.posmod(7, 3))
        assertEquals(0, GD.posmod(-6, 3))
        assertEquals(2L, GD.posmod(-7L, 3L))
        assertEquals(-9L, GD.posmod(10_000_000_001L, -10L))
    }

    @Test
    fun `fposmod keeps the sign of the divisor`() {
        assertEquals(0.5, GD.fposmod(-7.5, 2.0), EPSILON)
        assertEquals(-0.5, GD.fposmod(7.5, -2.0), EPSILON)
        assertEquals(1.25, GD.fposmod(5.25, 2.0), EPSILON)
        assertEquals(0.5f, GD.fposmod(-7.5f, 2f), FLOAT_EPSILON)
        assertEquals(-0.5f, GD.fposmod(7.5f, -2f), FLOAT_EPSILON)
    }

    @Test
    fun `snapped rounds to the nearest multiple of step`() {
        assertEquals(5, GD.snapped(7, 5))
        assertEquals(10, GD.snapped(8, 5))
        assertEquals(-5, GD.snapped(-7, 5))
        assertEquals(7, GD.snapped(7, 0))
        assertEquals(12_000_000_010L, GD.snapped(12_000_000_007L, 10L))
        assertEquals(7L, GD.snapped(7L, 0L))
        assertEquals(3.14, GD.snapped(3.14159, 0.01), EPSILON)
        assertEquals(-2.0, GD.snapped(-2.5, 1.0), EPSILON)
        assertEquals(1.5, GD.snapped(1.5, 0.0), EPSILON)
        assertEquals(0.75f, GD.snapped(0.8f, 0.25f), FLOAT_EPSILON)
        assertEquals(8, GD.snappedi(7.6f, 2))
        assertEquals(-8L, GD.snappedi(-7.6, 2L))
        assertEquals(7L, GD.snappedi(7.6, 0L))
    }

    @Test
    fun `stepDecimals returns the position of the first non zero decimal`() {
        assertEquals(0, GD.stepDecimals(1.0))
        assertEquals(1, GD.stepDecimals(0.5))
        assertEquals(1, GD.stepDecimals(1.25))
        assertEquals(2, GD.stepDecimals(0.01))
        assertEquals(2, GD.stepDecimals(-0.05))
        assertEquals(3, GD.stepDecimals(0.001))
        assertEquals(4, GD.stepDecimals(0.00012))
    }

    @Test
    fun `round rounds halfway cases away from zero`() {
        assertEquals(3.0, GD.round(2.5), 0.0)
        assertEquals(-3.0, GD.round(-2.5), 0.0)
        assertEquals(1.0, GD.round(0.5), 0.0)
        assertEquals(2.0, GD.round(2.4), 0.0)
        assertEquals(-2.0, GD.round(-1.6), 0.0)
        assertEquals(1.0e17, GD.round(1.0e17), 0.0)
        assertEquals(Double.POSITIVE_INFINITY, GD.round(Double.POSITIVE_INFINITY), 0.0)
        assertEquals(4f, GD.round(3.5f), 0f)
    }

    @Test
    fun `ease follows the curve exponent`() {
        assertEquals(0.25, GD.ease(0.5, 2.0), EPSILON)
        assertEquals(0.75, GD.ease(0.5, 0.5), EPSILON)
        assertEquals(0.5, GD.ease(0.5, 1.0), EPSILON)
        assertEquals(0.125, GD.ease(0.25, -2.0), EPSILON)
        assertEquals(0.875, GD.ease(0.75, -2.0), EPSILON)
        assertEquals(0.0, GD.ease(0.3, 0.0), EPSILON)
        assertEquals(0.0, GD.ease(-1.0, 2.0), EPSILON)
        assertEquals(1.0, GD.ease(2.0, 2.0), EPSILON)
    }

    @Test
    fun `smoothstep interpolates between from and to`() {
        assertEquals(0.5, GD.smoothstep(0.0, 10.0, 5.0), EPSILON)
        assertEquals(0.15625, GD.smoothstep(0.0, 10.0, 2.5), EPSILON)
        assertEquals(0.15625, GD.smoothstep(10.0, 0.0, 7.5), EPSILON)
        assertEquals(0.0, GD.smoothstep(0.0, 10.0, -1.0), EPSILON)
        assertEquals(1.0, GD.smoothstep(0.0, 10.0, 11.0), EPSILON)
        assertEquals(0.0, GD.smoothstep(3.0, 3.0, 2.0), EPSILON)
        assertEquals(1.0, GD.smoothstep(3.0, 3.0, 4.0), EPSILON)
    }

    @Test
    fun `angleDifference returns the shortest signed angle`() {
        assertEquals(PI / 2, GD.angleDifference(0.0, PI / 2), EPSILON)
        assertEquals(-0.2, GD.angleDifference(0.1, TAU - 0.1), EPSILON)
        assertEquals(-PI, GD.angleDifference(0.0, PI), EPSILON)
        assertEquals(PI, GD.angleDifference(PI, 0.0), EPSILON)
    }

    @Test
    fun `lerpAngle interpolates along the shortest path`() {
        assertEquals(PI / 4, GD.lerpAngle(0.0, PI / 2, 0.5), EPSILON)
        assertEquals(0.0, GD.lerpAngle(0.1, TAU - 0.1, 0.5), EPSILON)
    }

    @Test
    fun `rotateToward never goes past the target nor the opposite angle`() {
        assertEquals(0.5, GD.rotateToward(0.0, PI / 2, 0.5), EPSILON)
        assertEquals(PI / 2, GD.rotateToward(0.0, PI / 2, 2.0), EPSILON)
        assertEquals(-0.1, GD.rotateToward(0.1, TAU - 0.1, 1.0), EPSILON)
        assertEquals(-PI / 2, GD.rotateToward(0.0, PI / 2, -10.0), EPSILON)
    }

    @Test
    fun `moveToward never goes past the target`() {
        assertEquals(3, GD.moveToward(0, 10, 3))
        assertEquals(10, GD.moveToward(0, 10, 30))
        assertEquals(7, GD.moveToward(10, 0, 3))
        assertEquals(-3, GD.moveToward(0, 10, -3))
        assertEquals(5, GD.moveToward(5, 5, 1))
        assertEquals(7L, GD.moveToward(10L, 0L, 3L))
        assertEquals(0.5, GD.moveToward(1.0, -1.0, 0.5), EPSILON)
        assertEquals(-1.0f, GD.moveToward(1f, -1f, 5f), FLOAT_EPSILON)
    }

    @Test
    fun `nearestPo2 returns the smallest power of two not below the value`() {
        assertEquals(0, GD.nearestPo2(0))
        assertEquals(1, GD.nearestPo2(1))
        assertEquals(4, GD.nearestPo2(3))
        assertEquals(8, GD.nearestPo2(5))
        assertEquals(8, GD.nearestPo2(8))
        assertEquals(1024, GD.nearestPo2(1000))
        assertEquals(1 shl 29, GD.nearestPo2(1 shl 29))
        assertEquals(1L shl 40, GD.nearestPo2(1L shl 40))
        assertEquals(1L shl 41, GD.nearestPo2((1L shl 40) + 1))
        assertEquals(0, GD.nearestPo2(-5))
        assertEquals(8.0, GD.nearestPo2(5.0), 0.0)
        assertEquals(0.5, GD.nearestPo2(0.3), 0.0)
        assertEquals((1 shl 29).toDouble(), GD.nearestPo2((1 shl 29).toDouble()), 0.0)
        assertEquals(0.0, GD.nearestPo2(-5.0), 0.0)
    }

    @Test
    fun `bezierDerivative returns the slope of the curve`() {
        assertEquals(3.0, GD.bezierDerivative(0.0, 1.0, 2.0, 3.0, 0.3), EPSILON)
        assertEquals(1.5, GD.bezierDerivative(0.0, 0.0, 1.0, 1.0, 0.5), EPSILON)
        assertEquals(6.0, GD.bezierDerivative(0.0, 2.0, 3.0, 1.0, 0.0), EPSILON)
        assertEquals(-6.0, GD.bezierDerivative(0.0, 2.0, 3.0, 1.0, 1.0), EPSILON)
    }

    @Test
    fun `polar and cartesian conversions are inverse`() {
        val polar = GD.cartesian2polar(0.0, 2.0)
        assertEquals(2.0, polar.x, EPSILON)
        assertEquals(PI / 2, polar.y, EPSILON)

        val cartesian = GD.polarToCartesian(2.0, 0.0)
        assertEquals(2.0, cartesian.x, EPSILON)
        assertEquals(0.0, cartesian.y, EPSILON)

        val roundTrip = GD.cartesian2polar(3.0, 4.0).let { GD.polarToCartesian(it.x, it.y) }
        assertEquals(3.0, roundTrip.x, EPSILON)
        assertEquals(4.0, roundTrip.y, EPSILON)
    }
}
