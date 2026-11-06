@file:Suppress("RemoveRedundantBackticks")

package godot.core

import org.junit.Test

class TestRect2i {

    @Test
    fun `Constructor Methods`() {
        val recti = Rect2i(0, 100, 1280, 720)
        val rectiVector = Rect2i(Vector2i(0, 100), Vector2i(1280, 720))
        val rectiCopyRecti = Rect2i(recti)
        val rectiCopyRect = Rect2i(Rect2(0.0, 100.0, 1280.0, 720.0))

        checkTrue(recti == rectiVector)
        checkTrue(recti == rectiCopyRecti)
        checkTrue(recti == rectiCopyRect)
    }

    @Test
    fun `String Conversion`() {
        val recti = Rect2i(0, 100, 1280, 720)
        checkTrue(recti.toString() == "[P: (0, 100), S: (1280, 720)]")
    }

    @Test
    fun `Basic Getters`() {
        val rect = Rect2i(0, 100, 1280, 720)
        checkTrue(rect.position == Vector2i(0, 100))
        checkTrue(rect.size == Vector2i(1280, 720))
        checkTrue(rect.end == Vector2i(1280, 820))
        checkTrue(rect.getCenter() == Vector2i(640, 460))
        checkTrue(Rect2i(0, 100, 1281, 721).getCenter() == Vector2i(640, 460))
    }

    @Test
    fun `Basic Setters`() {
        var rect = Rect2i(0, 100, 1280, 720)
        rect.end = Vector2i(4000, 4000)
        checkTrue(rect == Rect2i(0, 100, 4000, 3900))

        rect = Rect2i(0, 100, 1280, 720)
        rect.position = Vector2i(4000, 4000)
        checkTrue(rect == Rect2i(4000, 4000, 1280, 720))

        rect = Rect2i(0, 100, 1280, 720)
        rect.size = Vector2i(4000, 4000)
        checkTrue(rect == Rect2i(0, 100, 4000, 4000))
    }

    @Test
    fun `Area Getters`() {
        checkTrue(Rect2i(0, 100, 1280, 720).getArea() == 921600)
        checkTrue(Rect2i(0, 100, -1280, -720).getArea() == 921600)
        checkTrue(Rect2i(0, 100, 1280, -720).getArea() == -921600)
        checkTrue(Rect2i(0, 100, -1280, 720).getArea() == -921600)
        checkTrue(Rect2i(0, 100, 0, 720).getArea() == 0)

        checkTrue(Rect2i(0, 100, 1280, 720).hasArea())
        checkFalse(Rect2i(0, 100, 0, 500).hasArea())
        checkFalse(Rect2i(0, 100, 500, 0).hasArea())
        checkFalse(Rect2i(0, 100, 0, 0).hasArea())
    }

    @Test
    fun `Absolute Coordinates`() {
        checkTrue(Rect2i(0, 100, 1280, 720).abs() == Rect2i(0, 100, 1280, 720))
        checkTrue(Rect2i(0, -100, 1280, 720).abs() == Rect2i(0, -100, 1280, 720))
        checkTrue(Rect2i(0, -100, -1280, -720).abs() == Rect2i(-1280, -820, 1280, 720))
        checkTrue(Rect2i(0, 100, -1280, 720).abs() == Rect2i(-1280, 100, 1280, 720))
    }

    @Test
    fun `Intersection`() {
        checkTrue(Rect2i(0, 100, 1280, 720).intersection(Rect2i(0, 300, 100, 100)) == Rect2i(0, 300, 100, 100))
        checkTrue(Rect2i(0, 100, 1280, 720).intersection(Rect2i(1200, 700, 100, 100)) == Rect2i(1200, 700, 80, 100))
        checkTrue(Rect2i(0, 100, 1280, 720).intersection(Rect2i(-4000, -4000, 100, 100)) == Rect2i())
    }

    @Test
    fun `Enclosing`() {
        checkTrue(Rect2i(0, 100, 1280, 720).encloses(Rect2i(0, 300, 100, 100)))
        checkFalse(Rect2i(0, 100, 1280, 720).encloses(Rect2i(1200, 700, 100, 100)))
        checkFalse(Rect2i(0, 100, 1280, 720).encloses(Rect2i(-4000, -4000, 100, 100)))
        checkTrue(Rect2i(0, 100, 1280, 720).encloses(Rect2i(0, 100, 1280, 720)))
    }

    @Test
    fun `Expanding`() {
        checkTrue(Rect2i(0, 100, 1280, 720).expand(Vector2i(500, 600)) == Rect2i(0, 100, 1280, 720))
        checkTrue(Rect2i(0, 100, 1280, 720).expand(Vector2i(0, 0)) == Rect2i(0, 0, 1280, 820))
    }

    @Test
    fun `Growing`() {
        checkTrue(Rect2i(0, 100, 1280, 720).grow(100) == Rect2i(-100, 0, 1480, 920))
        checkTrue(Rect2i(0, 100, 1280, 720).grow(-100) == Rect2i(100, 200, 1080, 520))
        checkTrue(Rect2i(0, 100, 1280, 720).grow(-4000) == Rect2i(4000, 4100, -6720, -7280))
        checkTrue(Rect2i(0, 100, 1280, 720).growIndividual(100, 200, 300, 400) == Rect2i(-100, -100, 1680, 1320))
        checkTrue(Rect2i(0, 100, 1280, 720).growIndividual(-100, 200, 300, -400) == Rect2i(100, -100, 1480, 520))
        checkTrue(Rect2i(0, 100, 1280, 720).growSide(Side.TOP, 500) == Rect2i(0, -400, 1280, 1220))
        checkTrue(Rect2i(0, 100, 1280, 720).growSide(Side.TOP, -500) == Rect2i(0, 600, 1280, 220))
    }

    @Test
    fun `HasPoint`() {
        val rect = Rect2i(0, 100, 1280, 720)
        checkTrue(rect.hasPoint(Vector2i(500, 600)))
        checkFalse(rect.hasPoint(Vector2i(0, 0)))
        checkTrue(rect.hasPoint(rect.position))
        checkTrue(rect.hasPoint(rect.position + Vector2i(1, 1)))
        checkFalse(rect.hasPoint(rect.position + Vector2i(1, -1)))
        checkFalse(rect.hasPoint(rect.position + rect.size))
        checkFalse(rect.hasPoint(rect.position + rect.size + Vector2i(1, 1)))
        checkTrue(rect.hasPoint(rect.position + rect.size + Vector2i(-1, -1)))
        checkFalse(rect.hasPoint(rect.position + rect.size + Vector2i(-1, 1)))
        checkTrue(rect.hasPoint(rect.position + Vector2i(0, 10)))
        checkFalse(rect.hasPoint(rect.position + Vector2i(rect.size.x, 10)))
        checkTrue(rect.hasPoint(rect.position + Vector2i(10, 0)))
        checkFalse(rect.hasPoint(rect.position + Vector2i(10, rect.size.y)))
        // Additional test cases for negative sizes would go here once GH-37617 is fixed.
    }

    @Test
    fun `Intersects`() {
        checkTrue(
            Rect2i(0, 100, 1280, 720).intersects(Rect2i(0, 300, 100, 100))
        )
        checkTrue(
            Rect2i(0, 100, 1280, 720).intersects(Rect2i(1200, 700, 100, 100))
        )
        checkFalse(
            Rect2i(0, 100, 1280, 720).intersects(Rect2i(-4000, -4000, 100, 100))
        )
        checkFalse(
            Rect2i(0, 0, 2, 2).intersects(Rect2i(2, 2, 2, 2))
        )
    }

    @Test
    fun `Merging`() {
        checkTrue(Rect2i(0, 100, 1280, 720).merge(Rect2i(0, 300, 100, 100)) == Rect2i(0, 100, 1280, 720))
        checkTrue(Rect2i(0, 100, 1280, 720).merge(Rect2i(1200, 700, 100, 100)) == Rect2i(0, 100, 1300, 720))
        checkTrue(Rect2i(0, 100, 1280, 720).merge(Rect2i(-4000, -4000, 100, 100)) == Rect2i(-4000, -4000, 5280, 4820))
    }

    @Test
    fun `Negative Size Still Computes`() {
        val negative = Rect2i(0, 100, -10, 20)
        val positive = Rect2i(0, 100, 1280, 720)

        checkFalse(negative.intersects(positive))
        checkFalse(positive.intersects(negative))
        checkTrue(negative.encloses(Rect2i(negative)))
        checkFalse(positive.encloses(Rect2i(0, 100, -10, 800)))
        checkFalse(negative.hasPoint(Vector2i(0, 100)))
        checkTrue(positive.merge(negative) == positive)
        checkTrue(negative.expand(Vector2i(5, 150)) == Rect2i(0, 100, 5, 50))
    }
}
