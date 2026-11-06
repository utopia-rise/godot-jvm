@file:Suppress("RemoveRedundantBackticks", "FloatingPointLiteralPrecision")

package godot.core

import godot.common.util.isEqualApprox
import org.junit.Test

private const val SQRT3 = 1.7320508075688772935274463415059

class TestVector3i {

    @Test
    fun `Constructor methods`() {
        val vectorEmpty = Vector3i()
        val vectorZero = Vector3i(0, 0, 0)
        checkMessage(vectorEmpty == vectorZero) { "Vector3i Constructor with no inputs should return a zero Vector3i." }
    }

    @Test
    fun `Axis methods`() {
        val vector = Vector3i(1, 2, 3)
        checkMessage(vector.maxAxis() == Vector3i.Axis.Z) { "Vector3i maxAxisIndex should work as expected." }
        checkMessage(vector.minAxis() == Vector3i.Axis.X) { "Vector3i minAxisIndex should work as expected." }
        checkMessage(vector[vector.maxAxis()] == 3) { "Vector3i array operator should work as expected." }
        checkMessage(vector[vector.minAxis()] == 1) { "Vector3i array operator should work as expected." }

        vector[Vector3i.Axis.Y] = 5
        checkMessage(vector[Vector3i.Axis.Y] == 5) { "Vector3i array operator setter should work as expected." }
    }

    @Test
    fun `Clamp`() {
        val vector = Vector3i(10, 10, 10)
        val result1 = Vector3i(-5, 5, 15).clamp(Vector3i(), vector)
        checkMessage(result1 == Vector3i(0, 5, 10)) { "Vector3i clamp should work as expected." }

        val result2 = vector.clamp(Vector3i(0, 10, 15), Vector3i(5, 10, 20))
        checkMessage(result2 == Vector3i(5, 10, 15)) { "Vector3i clamp should work as expected." }
    }

    @Test
    fun `Length methods`() {
        val vector1 = Vector3i(10, 10, 10)
        val vector2 = Vector3i(20, 30, 40)

        checkMessage(vector1.lengthSquared() == 300L) { "Vector3i lengthSquared should work as expected and return exact result." }
        checkMessage(vector1.length().isEqualApprox(10 * SQRT3)) { "Vector3i length should work as expected." }

        checkMessage(vector2.lengthSquared() == 2900L) { "Vector3i lengthSquared should work as expected and return exact result." }
        checkMessage(vector2.length().isEqualApprox(53.8516480713450403125)) { "Vector3i length should work as expected." }
    }

    @Test
    fun `Operators`() {
        val vector1 = Vector3i(4, 5, 9)
        val vector2 = Vector3i(1, 2, 3)

        checkMessage((vector1 + vector2) == Vector3i(5, 7, 12)) { "Vector3i addition with integers should give exact results." }
        checkMessage((vector1 - vector2) == Vector3i(3, 3, 6)) { "Vector3i subtraction with integers should give exact results." }
        checkMessage((vector1 * vector2) == Vector3i(4, 10, 27)) { "Vector3i multiplication with integers should give exact results." }
        checkMessage((vector1 / vector2) == Vector3i(4, 2, 3)) { "Vector3i division with integers should give exact results." }

        checkMessage((vector1 * 2) == Vector3i(8, 10, 18)) { "Vector3i multiplication with integers should give exact results." }
        checkMessage((vector1 / 2) == Vector3i(2, 2, 4)) { "Vector3i division with integers should give exact results." }

        checkMessage(vector1.toVector3() == Vector3(4.0, 5.0, 9.0)) { "Vector3i cast to Vector3 should work as expected." }
        checkMessage(vector2.toVector3() == Vector3(1.0, 2.0, 3.0)) { "Vector3i cast to Vector3 should work as expected." }
        checkMessage(Vector3i(Vector3(1.1, 2.9, 3.9)) == Vector3i(1, 2, 3)) { "Vector3i constructed from Vector3 should work as expected." }
    }

    @Test
    fun ` Other methods`() {
        val vector = Vector3i(1, 3, -7)
        val gridVector = Vector3i(4, 2, 5)

        checkMessage(vector.snapped(gridVector) == Vector3i(0, 4, -5)) { "Vector3i snapped should work as expected." }
    }

    @Test
    fun `Abs and Sign methods`() {
        val vector1 = Vector3i(1, 3, 5)
        val vector2 = Vector3i(1, -3, -5)

        checkMessage(vector1.abs() == vector1) { "Vector3i abs should work as expected." }
        checkMessage(vector2.abs() == vector1) { "Vector3i abs should work as expected." }

        checkMessage(vector1.sign() == Vector3i(1, 1, 1)) { "Vector3i sign should work as expected." }
        checkMessage(vector2.sign() == Vector3i(1, -1, -1)) { "Vector3i sign should work as expected." }
    }

    @Test
    fun `Length squared does not overflow`() {
        val vector = Vector3i(50000, 0, 0)
        checkMessage(vector.lengthSquared() == 2500000000L) { "Vector3i lengthSquared should use 64-bit arithmetic." }
        checkMessage(vector.length().isEqualApprox(50000.0)) { "Vector3i length should use 64-bit squared length." }
    }

    @Test
    fun `Distance methods`() {
        val from = Vector3i(1, 2, 3)
        val to = Vector3i(4, 6, 3)
        checkMessage(from.distanceSquaredTo(to) == 25L) { "Vector3i distanceSquaredTo should work as expected." }
        checkMessage(from.distanceTo(to).isEqualApprox(5.0)) { "Vector3i distanceTo should work as expected." }
    }

    @Test
    fun `Clamp does not throw when min is greater than max`() {
        val vector = Vector3i(5, 5, 5)
        checkMessage(vector.clamp(Vector3i(10, 0, 8), Vector3i(0, 0, 2)) == Vector3i(10, 0, 8)) { "Vector3i clamp should behave like CLAMP when min is greater than max." }
        checkMessage(vector.clampi(10, 0) == Vector3i(10, 10, 10)) { "Vector3i clampi should behave like CLAMP when min is greater than max." }
    }

    @Test
    fun `Float and double scalars produce a Vector3`() {
        checkMessage((Vector3i(10, 15, 20) * 0.9).isEqualApprox(Vector3(9.0, 13.5, 18.0))) { "Vector3i * double should return the Vector3 (9.0, 13.5, 18.0)." }
        checkMessage(0.5 * Vector3i(10, 15, 20) == Vector3(5.0, 7.5, 10.0)) { "double * Vector3i should return the Vector3 (5.0, 7.5, 10.0)." }
        checkMessage(Vector3i(10, 15, 20) * 0.5f == Vector3(5.0, 7.5, 10.0)) { "Vector3i * float should return the Vector3 (5.0, 7.5, 10.0)." }
        checkMessage(2.5f * Vector3i(2, 4, 6) == Vector3(5.0, 10.0, 15.0)) { "float * Vector3i should return the Vector3 (5.0, 10.0, 15.0)." }
        val divided = Vector3i(1, 2, 3) / 2.5
        checkMessage(divided.isEqualApprox(Vector3(0.4, 0.8, 1.2))) { "Vector3i / double should return the Vector3 (0.4, 0.8, 1.2)." }
        checkMessage(Vector3i(1, 2, 3) / 0.5f == Vector3(2.0, 4.0, 6.0)) { "Vector3i / float below one should not throw and return (2.0, 4.0, 6.0)." }
    }

    @Test
    fun `Int and long scalars keep producing a Vector3i`() {
        checkMessage(Vector3i(1, 2, 3) * 2 == Vector3i(2, 4, 6)) { "Vector3i * int should return a Vector3i." }
        checkMessage(3L * Vector3i(1, 2, 3) == Vector3i(3, 6, 9)) { "long * Vector3i should return a Vector3i." }
        checkMessage(Vector3i(7, -7, 9) / 2L == Vector3i(3, -3, 4)) { "Vector3i / long should return a Vector3i." }
    }

    @Test
    fun `Hash code`() {
        checkMessage(Vector3i(1, -2, 3).hashCode() == Vector3i(1, -2, 3).hashCode()) { "Equal Vector3i should have equal hash codes." }
        val hashes = setOf(Vector3i(1, 2, 3), Vector3i(3, 2, 1), Vector3i(2, 1, 3), Vector3i(1, 2, 4), Vector3i.ZERO).map { it.hashCode() }.toSet()
        checkMessage(hashes.size == 5) { "Distinct Vector3i should have distinct hash codes." }
    }

    @Test
    fun `MIN MAX and unary plus`() {
        checkMessage(Vector3i.MIN == Vector3i(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)) { "Vector3i MIN should hold Int.MIN_VALUE." }
        checkMessage(Vector3i.MAX == Vector3i(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)) { "Vector3i MAX should hold Int.MAX_VALUE." }
        val vector = Vector3i(1, -2, 3)
        checkMessage(+vector == vector && +vector !== vector) { "Vector3i unary plus should return an equal copy." }
    }
}
