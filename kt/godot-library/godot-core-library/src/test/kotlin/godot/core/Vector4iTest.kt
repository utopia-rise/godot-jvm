@file:Suppress("RemoveRedundantBackticks")

package godot.core

import godot.common.util.isEqualApprox
import org.junit.Test

class TestVector4i {

    @Test
    fun `Constructor methods`() {
        val vectorEmpty = Vector4i()
        val vectorZero = Vector4i(0, 0, 0, 0)
        checkMessage(vectorEmpty == vectorZero) { "Vector4i Constructor with no inputs should return a zero Vector4i." }
    }

    @Test
    fun `Axis methods`() {
        val vector = Vector4i(1, 2, 3, 4)
        checkMessage(vector.maxAxis() == Vector4i.Axis.W) { "Vector4i maxAxisIndex should work as expected." }
        checkMessage(vector.minAxis() == Vector4i.Axis.X) { "Vector4i minAxisIndex should work as expected." }
        checkMessage(vector[vector.maxAxis()] == 4) { "Vector4i array operator should work as expected." }
        checkMessage(vector[vector.minAxis()] == 1) { "Vector4i array operator should work as expected." }

        vector[Vector4i.Axis.Y] = 5
        checkMessage(vector[Vector4i.Axis.Y] == 5) { "Vector4i array operator setter should work as expected." }
    }

    @Test
    fun `Clamp method`() {
        val vector = Vector4i(10, 10, 10, 10)
        checkMessage(Vector4i(-5, 5, 15, Int.MAX_VALUE).clamp(Vector4i(), vector) == Vector4i(0, 5, 10, 10)) { "Vector4i clamp should work as expected." }
        checkMessage(vector.clamp(Vector4i(0, 10, 15, -10), Vector4i(5, 10, 20, -5)) == Vector4i(5, 10, 15, -5)) { "Vector4i clamp should work as expected." }
    }

    @Test
    fun `Length methods`() {
        val vector1 = Vector4i(10, 10, 10, 10)
        val vector2 = Vector4i(20, 30, 40, 50)
        checkMessage(vector1.lengthSquared() == 400L) { "Vector4i lengthSquared should work as expected and return exact result." }
        checkMessage(vector1.length().isEqualApprox(20.0)) { "Vector4i length  should work as expected and return exact result." }
        checkMessage(vector2.lengthSquared() == 5400L) { "Vector4i length_squared  should work as expected and return exact result." }
        checkMessage(vector2.length().isEqualApprox(73.4846922835)) { "Vector4i length  should work as expected and return exact result." }
    }

    @Test
    fun `Operators`() {
        val vector1 = Vector4i(4, 5, 9, 2)
        val vector2 = Vector4i(1, 2, 3, 4)
        checkMessage(-vector1 == Vector4i(-4, -5, -9, -2)) { "Vector4i change of sign should work as expected." }
        checkMessage((vector1 + vector2) == Vector4i(5, 7, 12, 6)) { "Vector4i addition with integers should give exact results." }
        checkMessage((vector1 - vector2) == Vector4i(3, 3, 6, -2)) { "Vector4i subtraction with integers should give exact results." }
        checkMessage((vector1 * vector2) == Vector4i(4, 10, 27, 8)) { "Vector4i multiplication with integers should give exact results." }
        checkMessage((vector1 / vector2) == Vector4i(4, 2, 3, 0)) { "Vector4i division with integers should give exact results." }
        checkMessage((vector1 * 2) == Vector4i(8, 10, 18, 4)) { "Vector4i multiplication with integers should give exact results." }
        checkMessage((vector1 / 2) == Vector4i(2, 2, 4, 1)) { "Vector4i division with integers should give exact results." }
        checkMessage(Vector4(vector1) == Vector4(4, 5, 9, 2)) { "Vector4i cast to Vector4 should work as expected." }
        checkMessage(Vector4(vector2) == Vector4(1, 2, 3, 4)) { "Vector4i cast to Vector4 should work as expected." }
        checkMessage(
            Vector4i(Vector4(1.1, 2.9, 3.9, 100.5)) == Vector4i(1.1, 2.9, 3.9, 100.5)
        ) { "Vector4i constructed from Vector4 should work as expected." }
    }

    @Test
    fun `Other methods`() {
        val vector = Vector4i(1, 3, -7, 13)
        checkMessage(vector.snapped(Vector4i(4, 2, 5, 8)) == Vector4i(0, 4, -5, 16)) { "Vector4i snapped should work as expected." }
    }

    @Test
    fun `Abs and Sign methods`() {
        val vector1 = Vector4i(1, 3, 5, 7)
        val vector2 = Vector4i(1, -3, -5, 7)
        checkMessage(vector1.abs() == vector1) { "Vector4i abs should work as expected." }
        checkMessage(vector2.abs() == vector1) { "Vector4i abs should work as expected." }
        checkMessage(vector1.sign() == Vector4i(1, 1, 1, 1)) { "Vector4i sign should work as expected." }
        checkMessage(vector2.sign() == Vector4i(1, -1, -1, 1)) { "Vector4i sign should work as expected." }
    }

    @Test
    fun `Scalar minimum keeps every component`() {
        checkTrue(Vector4i(1, 5, 3, 7).mini(4) == Vector4i(1, 4, 3, 4))
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Vector4i(1, 2, 3, 4)
        val b = Vector4i(4, -5, 6, 7)
        val aCopy = Vector4i(a)
        val bCopy = Vector4i(b)

        val operations = listOf<() -> Any>(
            { a + b },
            { a - b },
            { a * b },
            { a / b },
            { -a },
            { a.abs() },
            { a.min(b) },
            { a.max(b) },
            { a.mini(2) },
            { a.maxi(2) },
            { a.sign() },
            { a.clamp(Vector4i(0, 0, 0, 0), Vector4i(2, 2, 2, 2)) },
            { a.snapped(Vector4i(2, 2, 2, 2)) },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }

    @Test
    fun `Clamp does not throw when min is greater than max`() {
        checkMessage(Vector4i(5, 5, 20, 5).clamp(Vector4i(10, 10, 10, 10), Vector4i(0, 0, 0, 0)) == Vector4i(10, 10, 0, 10)) { "Vector4i clamp with min > max should follow the C++ CLAMP ternary." }
        checkMessage(Vector4i(-5, 5, 20, 0).clampi(10, 0) == Vector4i(10, 10, 0, 10)) { "Vector4i clampi with min > max should follow the C++ CLAMP ternary." }
    }

    @Test
    fun `Length squared does not overflow`() {
        val vector = Vector4i(50000, 0, 0, 0)
        checkMessage(vector.lengthSquared() == 2500000000L) { "Vector4i lengthSquared should be computed in 64 bits." }
        checkMessage(vector.length().isEqualApprox(50000.0)) { "Vector4i length should use the 64 bit squared length." }
    }

    @Test
    fun `Distance methods`() {
        val a = Vector4i(1, 2, 3, 4)
        val b = Vector4i(4, 6, 3, 4)
        checkMessage(a.distanceSquaredTo(b) == 25L) { "Vector4i distanceSquaredTo should work as expected." }
        checkMessage(a.distanceTo(b).isEqualApprox(5.0)) { "Vector4i distanceTo should work as expected." }
        checkMessage(Vector4i(-50000, 0, 0, 0).distanceSquaredTo(Vector4i(50000, 0, 0, 0)) == 10000000000L) { "Vector4i distanceSquaredTo should be computed in 64 bits." }
    }

    @Test
    fun `Constants and unary plus`() {
        checkMessage(Vector4i.MIN == Vector4i(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)) { "Vector4i MIN should work as expected." }
        checkMessage(Vector4i.MAX == Vector4i(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)) { "Vector4i MAX should work as expected." }
        val a = Vector4i(1, 2, 3, 4)
        val plus = +a
        checkMessage(plus == a && plus !== a) { "Vector4i unary plus should return an equal copy." }
    }

    @Test
    fun `Float and Double scalars give a Vector4`() {
        val a = Vector4i(10, 20, 30, 40)
        checkMessage((a * 0.9).isEqualApprox(Vector4(9.0, 18.0, 27.0, 36.0))) { "Vector4i times Double should return the Vector4 computed in floating point." }
        checkMessage((a * 0.5f).isEqualApprox(Vector4(5.0, 10.0, 15.0, 20.0))) { "Vector4i times Float should return the Vector4 computed in floating point." }
        checkMessage((0.5 * a).isEqualApprox(Vector4(5.0, 10.0, 15.0, 20.0))) { "Double times Vector4i should return the Vector4 computed in floating point." }
        checkMessage((0.5f * a).isEqualApprox(Vector4(5.0, 10.0, 15.0, 20.0))) { "Float times Vector4i should return the Vector4 computed in floating point." }
        checkMessage((Vector4i(1, 2, 3, 4) / 2.5).isEqualApprox(Vector4(0.4, 0.8, 1.2, 1.6))) { "Vector4i div Double should return the Vector4 computed in floating point." }
        checkMessage((Vector4i(1, 2, 3, 4) / 2.5f).isEqualApprox(Vector4(0.4, 0.8, 1.2, 1.6))) { "Vector4i div Float should return the Vector4 computed in floating point." }
        checkMessage((Vector4i(1, 2, 3, 4) / 0.5).isEqualApprox(Vector4(2.0, 4.0, 6.0, 8.0))) { "Vector4i div by a Double below one should not truncate the scalar." }
    }

    @Test
    fun `Long scalars are narrowed to int`() {
        checkMessage(Vector4i(1, 2, 3, 4) * 2L == Vector4i(2, 4, 6, 8)) { "Vector4i times Long should return a Vector4i." }
        checkMessage(Vector4i(4, 6, 8, 10) / 2L == Vector4i(2, 3, 4, 5)) { "Vector4i div Long should return a Vector4i." }
    }

    @Test
    fun `Hash code is consistent with equals`() {
        checkMessage(Vector4i(1, 2, 3, 4).hashCode() == Vector4i(1, 2, 3, 4).hashCode()) { "Equal Vector4i should have equal hash codes." }
        checkMessage(Vector4i(-7, 0, Int.MAX_VALUE, Int.MIN_VALUE).hashCode() == Vector4i(-7, 0, Int.MAX_VALUE, Int.MIN_VALUE).hashCode()) { "Equal Vector4i should have equal hash codes." }
        val distinct = listOf(Vector4i(1, 2, 3, 4), Vector4i(4, 3, 2, 1), Vector4i(1, 2, 4, 3), Vector4i(0, 0, 0, 0), Vector4i(0, 0, 0, 1))
        checkMessage(distinct.map { it.hashCode() }.toSet().size == distinct.size) { "Distinct Vector4i should have distinct hash codes." }
    }

    @Test
    fun `Scalar plus converts the scalar to int first`() {
        checkMessage(Vector4i(3, 3, 3, 3) + 1.9 == Vector4i(4, 4, 4, 4)) { "Vector4i plus Double should truncate the scalar first." }
    }
}
