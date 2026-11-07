@file:Suppress("RemoveRedundantBackticks")

package godot.core

import godot.common.util.isEqualApprox
import org.junit.Test
import kotlin.math.sqrt

class Vector2iTest {

    @Test
    fun `Constructor methods`() {
        val vectorEmpty = Vector2i()
        val vectorZero = Vector2i(0, 0)
        checkTrue(vectorZero == vectorEmpty)
    }

    @Test
    fun `Axis methods`() {
        val vector = Vector2i(2, 3)
        checkTrue(Vector2i.Axis.Y == vector.maxAxis())
        checkTrue(Vector2i.Axis.X == vector.minAxis())
        checkTrue(2 == vector[vector.minAxis()])
        vector[Vector2i.Axis.Y] = 5
        checkTrue(5 == vector[Vector2i.Axis.Y])
    }

    @Test
    fun `Clamp method`() {
        val vector = Vector2i(10, 10)
        checkTrue(Vector2i(0, 10) == Vector2i(-5, 15).clamp(Vector2i(), vector))
        checkTrue(Vector2i(5, 15) == vector.clamp(Vector2i(0, 15), Vector2i(5, 20)))
    }

    @Test
    fun `Length methods`() {
        val vector1 = Vector2i(10, 10)
        val vector2 = Vector2i(20, 30)
        checkTrue(200L == vector1.lengthSquared())
        checkTrue((10 * sqrt(2.0)).isEqualApprox(vector1.length()))
        checkTrue(1300L == vector2.lengthSquared())
        checkTrue(36.05551275463989.isEqualApprox(vector2.length()))
    }

    @Test
    fun `Operators`() {
        val vector1 = Vector2i(5, 9)
        val vector2 = Vector2i(2, 3)
        checkTrue(Vector2i(7, 12) == vector1 + vector2)
        checkTrue(Vector2i(3, 6) == vector1 - vector2)
        checkTrue(Vector2i(10, 27) == vector1 * vector2)
        checkTrue(Vector2i(2, 3) == vector1 / vector2)
        checkTrue(Vector2i(10, 18) == vector1 * 2)
        checkTrue(Vector2i(2, 4) == vector1 / 2)
        checkTrue(Vector2(5, 9) == vector1.toVector2())
        checkTrue(Vector2(2, 3) == vector2.toVector2())
        checkTrue(Vector2i(1, 2) == Vector2i(Vector2(1.1, 2.9)))
    }

    @Test
    fun `Other methods`() {
        val vector = Vector2i(1, 3)
        checkTrue(1.0 / 3 == vector.aspect())
        checkTrue(Vector2i(0, 4) == vector.snapped(Vector2i(4, 2)))
    }

    @Test
    fun `Abs and sign methods`() {
        val vector1 = Vector2i(1, 3)
        val vector2 = Vector2i(1, -3)
        checkTrue(vector1 == vector1.abs())
        checkTrue(vector1 == vector2.abs())
        checkTrue(Vector2i(1, 1) == vector1.sign())
        checkTrue(Vector2i(1, -1) == vector2.sign())
    }

    @Test
    fun `Aspect is a real division`() {
        checkTrue(Vector2i(3, 2).aspect() == 1.5)
        checkTrue(Vector2i(1, 4).aspect() == 0.25)
    }

    @Test
    fun `Operations do not modify their operands`() {
        val a = Vector2i(1, 2)
        val b = Vector2i(4, -5)
        val aCopy = Vector2i(a)
        val bCopy = Vector2i(b)

        val operations = listOf<() -> Any>(
            { a + b },
            { a - b },
            { a * b },
            { a / b },
            { -a },
            { a.abs() },
            { a.min(b) },
            { a.max(b) },
            { a.sign() },
            { a.clamp(Vector2i(0, 0), Vector2i(2, 2)) },
            { a.snapped(Vector2i(2, 2)) },
            { a.aspect() },
        )
        operations.forEach {
            it()
            checkTrue(a == aCopy)
            checkTrue(b == bCopy)
        }
    }

    @Test
    fun `Length squared does not overflow`() {
        checkTrue(3_200_000_000L == Vector2i(40000, 40000).lengthSquared())
        checkTrue((40000 * sqrt(2.0)).isEqualApprox(Vector2i(40000, 40000).length()))
    }

    @Test
    fun `Clamp with min greater than max does not throw`() {
        checkTrue(Vector2i(10, 0) == Vector2i(5, 20).clamp(Vector2i(10, 10), Vector2i(0, 0)))
        checkTrue(Vector2i(10, 0) == Vector2i(5, 20).clampi(10, 0))
    }

    @Test
    fun `Distance methods`() {
        checkTrue(25L == Vector2i(1, 1).distanceSquaredTo(Vector2i(4, 5)))
        checkTrue(5.0.isEqualApprox(Vector2i(1, 1).distanceTo(Vector2i(4, 5))))
    }

    @Test
    fun `Min and max constants`() {
        checkTrue(Vector2i(Int.MIN_VALUE, Int.MIN_VALUE) == Vector2i.MIN)
        checkTrue(Vector2i(Int.MAX_VALUE, Int.MAX_VALUE) == Vector2i.MAX)
    }

    @Test
    fun `Plus scalar overloads convert to int first`() {
        checkTrue(Vector2i(2, 3) == Vector2i(1, 2) + 1.9f)
    }

    @Test
    fun `Float scalar multiplication returns a Vector2`() {
        checkTrue(Vector2(9.0, 13.5) == Vector2i(10, 15) * 0.9)
        checkTrue(Vector2(5.0, 7.5) == Vector2i(10, 15) * 0.5f)
        checkTrue(Vector2(9.0, 13.5) == 0.9 * Vector2i(10, 15))
        checkTrue(Vector2(5.0, 7.5) == 0.5f * Vector2i(10, 15))
    }

    @Test
    fun `Float scalar division returns a Vector2`() {
        checkTrue(Vector2(0.4, 0.8) == Vector2i(1, 2) / 2.5)
        checkTrue(Vector2(2.0, 4.0) == Vector2i(1, 2) / 0.5)
        checkTrue(Vector2(2.0, 4.0) == Vector2i(1, 2) / 0.5f)
    }

    @Test
    fun `Long scalars narrow to int and keep a Vector2i`() {
        checkTrue(Vector2i(2, 4) == Vector2i(1, 2) * 2L)
        checkTrue(Vector2i(5, 10) == Vector2i(10, 20) / 2L)
    }

    @Test
    fun `Integer scalar on the left keeps a Vector2i`() {
        checkTrue(Vector2i(2, 4) == 2 * Vector2i(1, 2))
        checkTrue(Vector2i(3, 6) == 3L * Vector2i(1, 2))
    }

    @Test
    fun `Unary plus returns an equal copy`() {
        val vector = Vector2i(3, -4)
        val result = +vector
        checkTrue(vector == result)
        checkTrue(vector !== result)
    }
}
