@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.annotation.CoreTypeLocalCopy
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.math.max
import kotlin.math.min

private typealias Point2i = Vector2i
private typealias Size2i = Vector2i

class Rect2i(
    p_position: Point2i,
    p_size: Size2i
) {
    @Suppress("PropertyName")
    @PublishedApi
    internal var _position = Point2i(p_position)

    @Suppress("PropertyName")
    @PublishedApi
    internal var _size = Size2i(p_size)

    //PROPERTIES
    /**
     * Return a copy of the position Vector2i
     *
     *
     * Beginning corner. Typically has values lower than [end].
     *
     * **Warning**: Writing position.x = 2 will only modify a copy, not the actual object.
     * To modify it, use [position].
     *
     * See: [Documentation](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types)
     * */
    @CoreTypeLocalCopy
    var position
        get() = Point2i(_position)
        set(value) {
            _position = Point2i(value)
        }

    /**
     * Apply modifications on actual [position] [Vector2].
     *
     *
     * [position] var return a copy of actual position of this [Rect2i]. This method purpose is to make changes to the
     * actual position.
     * See also: [position]
     */
    @CoreTypeHelper
    inline fun <T> position(block: Point2i.() -> T): T {
        return _position.block()
    }

    /**
     * Return a copy of the size Vector2i
     *
     *
     * Size from [position] to [end]. Typically, all components are positive.
     * If the size is negative, you can use [abs] to fix it.
     *
     * **Warning**: Writing size.x = 2 will only modify a copy, not the actual object.
     * To modify it, use [size].
     *
     * See: [Documentation](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types)
     * */
    @CoreTypeLocalCopy
    var size
        get() = Size2i(_size)
        set(value) {
            _size = Size2i(value)
        }

    /**
     * Apply modifications on actual [size] [Vector2].
     *
     *
     * [size] var return a copy of actual size of this [Rect2i]. This method purpose is to make changes to the
     * actual size.
     * See also: [size]
     */
    @CoreTypeHelper
    inline fun <T> size(block: Size2i.() -> T): T {
        return _size.block()
    }

    /**
     * Ending corner. This is calculated as `position + size`. Setting this value will change the size.
     */
    @CoreTypeLocalCopy
    var end: Vector2i
        get() = _position + _size
        set(value) {
            _size = value - _position
        }

    /**
     * Constructs a default-initialized [Rect2i] with default (zero) values of [position] and [size].
     */
    constructor() : this(Point2i(), Size2i())

    /**
     * Constructs a [Rect2i] by [x], [y], [width], and [height].
     */
    constructor(x: Int, y: Int, width: Int, height: Int) : this(Point2i(x, y), Size2i(width, height))

    /**
     * Constructs a new [Rect2i] from [Rect2]. The floating point coordinates will be truncated.
     */

    constructor(rect: Rect2) : this(rect._position.toVector2i(), rect._size.toVector2i())

    /**
     * Constructs a [Rect2i] as a copy of the given [Rect2i].
     */
    constructor(rect: Rect2i) : this(rect._position, rect._size)

    // API

    /**
     * Returns a [Rect2i] with equivalent position and area, modified so that the top-left corner is the origin and
     * `width` and `height` are positive.
     */
    fun abs() = Rect2i(position + size.min(Point2i()), size.abs())

    /**
     * Returns `true` if this [Rect2i] completely encloses another one.
     */

    fun encloses(rect: Rect2i) = (rect._position.x >= _position.x) && (rect._position.y >= _position.y) &&
        ((rect._position.x + rect._size.x) <= (_position.x + _size.x)) &&
        ((rect._position.y + rect._size.y) <= (_position.y + _size.y))

    /**
     * Returns a copy of this [Rect2i] expanded so that the borders align with the given point.
     */
    fun expand(vector: Point2i) = Rect2i(this).also {
        it.expandTo(vector)
    }

    private fun expandTo(p_vector: Point2i) {
        val begin = Point2i(_position)
        val end = _position + _size

        if (p_vector.x < begin.x) {
            begin.x = p_vector.x
        }
        if (p_vector.y < begin.y) {
            begin.y = p_vector.y
        }

        if (p_vector.x > end.x) {
            end.x = p_vector.x
        }
        if (p_vector.y > end.y) {
            end.y = p_vector.y
        }

        _position = begin
        _size = end - begin
    }

    /**
     * Returns the area of the [Rect2i]. See also [hasArea].
     */
    fun getArea(): Int = size.width * size.height

    /**
     * Returns the center of the [Rect2i], which is equal to [position] + ([size] / 2).
     *
     * If [size] is an odd number, the returned center value will be rounded towards [position].
     */
    fun getCenter(): Vector2i = position + (size / 2)

    /**
     * Returns a copy of the [Rect2i] grown by the specified `amount` on all sides.
     */
    fun grow(amount: Int) = Rect2i(this).also {
        it._position.x -= amount
        it._position.y -= amount
        it._size.width += amount * 2
        it._size.height += amount * 2
    }

    /**
     * Returns a copy of the [Rect2i] grown by the specified amount on each side individually.
     */
    fun growIndividual(left: Int, top: Int, right: Int, bottom: Int) = Rect2i(this).also {
        it._position.x -= left
        it._position.y -= top
        it._size.width += left + right
        it._size.height += top + bottom
    }

    /**
     * Returns a copy of the [Rect2i] grown by the specified [amount] on the specified [Side].
     */

    fun growSide(side: Side, amount: Int) = growIndividual(
        if (Side.LEFT === side) amount else 0,
        if (Side.TOP === side) amount else 0,
        if (Side.RIGHT === side) amount else 0,
        if (Side.BOTTOM === side) amount else 0
    )

    /**
     * Returns `true` if the [Rect2i] has area, and `false` if the [Rect2i] is linear, empty, or has a negative [size].
     * See also [getArea].
     */

    fun hasArea() = _size.x > 0 && _size.y > 0

    /**
     * Returns `true` if the [Rect2i] contains a point. By convention, the right and bottom edges of the [Rect2i] are
     * considered exclusive, so points on these edges are not included.
     *
     * **Note**: This method is not reliable for [Rect2i] with a negative size. Use [abs] to get a positive sized
     * equivalent rectangle to check for contained points.
     */

    fun hasPoint(point: Point2i): Boolean {
        if (point.x < _position.x) {
            return false
        }
        if (point.y < _position.y) {
            return false
        }

        if (point.x >= (_position.x + _size.x)) {
            return false
        }
        if (point.y >= (_position.y + _size.y)) {
            return false
        }

        return true
    }

    /**
     * Returns the intersection of this [Rect2i] and `b`.
     * If the rectangles do not intersect, an empty [Rect2i] is returned.
     */
    fun intersection(rect: Rect2i): Rect2i {
        val ret = Rect2i(rect)

        if (!intersects(ret)) {
            return Rect2i()
        }

        ret._position.x = max(rect._position.x, _position.x)
        ret._position.y = max(rect._position.y, _position.y)

        val rectEnd: Point2i = rect._position + rect._size
        val end = _position + _size

        ret._size.x = min(rectEnd.x, end.x) - ret._position.x
        ret._size.y = min(rectEnd.y, end.y) - ret._position.y

        return ret
    }

    /**
     * Returns `true` if the [Rect2i] overlaps with `b` (i.e. they have at least one point in common).
     */
    fun intersects(rect: Rect2i): Boolean {
        if (GodotJvmBuildConfig.DEBUG) {
            require(!(size.x < 0 || size.y < 0 || rect.size.x < 0 || rect.size.y < 0)) {
                "Rect2i size is negative, this is not supported. Use Rect2i.abs() to get a Rect2i with a positive size."
            }
        }
        if (_position.x >= (rect._position.x + rect._size.width)) {
            return false
        }
        if ((_position.x + _size.width) <= rect._position.x) {
            return false
        }
        if (_position.y >= (rect._position.y + rect._size.height)) {
            return false
        }
        if ((_position.y + _size.height) <= rect._position.y) {
            return false
        }

        return true
    }

    /**
     * Returns a larger [Rect2i] that contains this [Rect2i] and `b`.
     */

    fun merge(rect: Rect2i): Rect2i {
        val newRect = Rect2i()

        newRect._position.x = min(rect._position.x, _position.x)
        newRect._position.y = min(rect._position.y, _position.y)

        newRect._size.x = max(rect._position.x + rect._size.x, _position.x + _size.x)
        newRect._size.y = max(rect._position.y + rect._size.y, _position.y + _size.y)

        newRect._size = newRect._size - newRect._position // Make relative again.

        return newRect
    }


    fun toRect2() = Rect2(
        _position.toVector2(),
        _size.toVector2()
    )

    override fun toString(): String {
        return "[P: $_position, S: $_size]"
    }

    /**
     * Returns `true` if the rectangles are equal.
     */
    override fun equals(other: Any?): Boolean = when (other) {
        is Rect2i -> _position == other._position && _size == other._size
        else -> false
    }

    override fun hashCode(): Int {
        var result = _position.hashCode()
        result = 31 * result + _size.hashCode()
        return result
    }
}
