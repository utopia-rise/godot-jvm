@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.core

import godot.annotation.CoreTypeHelper
import godot.annotation.CoreTypeLocalCopy
import godot.common.util.RealT
import godot.internal.logging.GodotLogging
import kotlincompile.definitions.GodotJvmBuildConfig

private typealias Point2 = Vector2
private typealias Size2 = Vector2

class Rect2(
    p_position: Point2,
    p_size: Size2
) : CoreType {

    @PublishedApi
    internal var _position = Point2(p_position)

    @PublishedApi
    internal var _size = Size2(p_size)


    //PROPERTIES
    /** Return a copy of the position Vector2
     * Warning: Writing position.x = 2 will only modify a copy, not the actual object.
     * To modify it, use position().
     * */
    @CoreTypeLocalCopy
    var position
        get() = Point2(_position)
        set(value) {
            _position = Point2(value)
        }

    /**
     * Apply modifications on actual [position] [Vector2].
     *
     *
     * [position] var return a copy of actual position of this [Rect2]. This method purpose is to make changes to the
     * actual position.
     * See also: [position]
     */
    @CoreTypeHelper
    inline fun <T> position(block: Point2.() -> T): T {
        return _position.block()
    }

    /** Return a copy of the size Vector2
     * Warning: Writing size.x = 2 will only modify a copy, not the actual object.
     * To modify it, use size().
     * */
    @CoreTypeLocalCopy
    var size
        get() = Size2(_size)
        set(value) {
            _size = Size2(value)
        }

    /**
     * Apply modifications on actual [size] [Vector2].
     *
     *
     * [size] var return a copy of actual size of this [Rect2]. This method purpose is to make changes to the
     * actual size.
     * See also: [size]
     */
    @CoreTypeHelper
    inline fun <T> size(block: Size2.() -> T): T {
        return _size.block()
    }

    /** Return a copy of the end Vector2
     * Warning: Writing end.x = 2 will only modify a copy, not the actual object.
     * To modify it, use end().
     * */
    @CoreTypeLocalCopy
    inline var end: Vector2
        get() = _position + _size
        set(value) {
            _size = value - _position
        }

    @CoreTypeHelper
    inline fun <T> end(block: Vector2.() -> T): T {
        val vec = end
        val ret = vec.block()
        end = vec
        return ret
    }

    //CONSTANTS
    enum class Margin(val value: Int) {
        LEFT(0),
        TOP(1),
        RIGHT(2),
        BOTTOM(3)
    }

    companion object {
        val MARGIN_LEFT = Margin.LEFT.value
        val MARGIN_TOP = Margin.TOP.value
        val MARGIN_RIGHT = Margin.RIGHT.value
        val MARGIN_BOTTOM = Margin.BOTTOM.value
    }

    //CONSTRUCTOR
    constructor() :
        this(Vector2(), Vector2())

    constructor(other: Rect2) :
        this(other._position, other._size)

    constructor(other: Rect2i) : this(other._position.toVector2(), other._size.toVector2())

    constructor(x: RealT, y: RealT, width: RealT, height: RealT) :
        this(Vector2(x, y), Vector2(width, height))

    //API
    /**
     *Returns a Rect2 with equivalent position and area, modified so that
     * the top-left corner is the origin and width and height are positive.
     */
    fun abs() = Rect2(position + size.min(Point2()), size.abs())

    /**
     * Returns true if this Rect2 completely encloses another one.
     */
    fun encloses(b: Rect2): Boolean {
        if (GodotJvmBuildConfig.DEBUG) {
            if (_size.x < 0 || _size.y < 0 || b._size.x < 0 || b._size.y < 0) {
                GodotLogging.error("Rect2 size is negative, this is not supported. Use Rect2.abs() to get a Rect2 with a positive size.")
            }
        }

        return (b._position.x >= _position.x) && (b._position.y >= _position.y) &&
            ((b._position.x + b._size.x) <= (_position.x + _size.x)) &&
            ((b._position.y + b._size.y) <= (_position.y + _size.y))
    }

    /**
     * Returns this Rect2 expanded to include a given point.
     */
    fun expand(vector: Vector2): Rect2 {
        val r = Rect2(this._position, this._size)
        r.expandTo(vector)
        return r
    }


    internal fun expandTo(vector: Vector2) {
        if (GodotJvmBuildConfig.DEBUG) {
            if (_size.x < 0 || _size.y < 0) {
                GodotLogging.error("Rect2 size is negative, this is not supported. Use Rect2.abs() to get a Rect2 with a positive size.")
            }
        }

        val begin = Vector2(_position)
        val end = _position + _size

        if (vector.x < begin.x) {
            begin.x = vector.x
        }
        if (vector.y < begin.y) {
            begin.y = vector.y
        }
        if (vector.x > end.x) {
            end.x = vector.x
        }
        if (vector.y > end.y) {
            end.y = vector.y
        }

        _position = begin
        _size = end - begin
    }

    /**
     * Returns the area of the Rect2.
     */
    fun getArea(): RealT {
        return _size.x * _size.y
    }

    /**
     * Returns the center of the Rect2, which is equal to [position] + ([size] / 2).
     */
    fun getCenter() = position + (size * 0.5f)

    /**
     * Returns the vertex's position of this rect that's the farthest in the given direction. This point is commonly known as the support point in collision detection algorithms.
     */
    fun getSupport(direction: Vector2): Vector2 {
        val support = Vector2(position)
        if (direction.x > 0.0f) {
            support.x += size.x
        }
        if (direction.y > 0.0f) {
            support.y += size.y
        }
        return support;
    }

    /**
     * Returns a copy of the Rect2 grown a given amount of units towards all the sides.
     */
    fun grow(by: RealT): Rect2 {
        val g = Rect2(this._position, this._size)
        g._position.x -= by
        g._position.y -= by
        g._size.x += by * 2
        g._size.y += by * 2
        return g
    }

    /**
     * Returns a copy of the Rect2 grown a given amount of units towards all the sides.
     */
    fun growIndividual(left: RealT, top: RealT, right: RealT, bottom: RealT): Rect2 {
        val g = Rect2(this._position, this._size)
        g._position.x -= left
        g._position.y -= top
        g._size.x += left + right
        g._size.y += top + bottom
        return g
    }

    /**
     * Returns a copy of the Rect2 grown a given [amount] of units towards all the sides.
     */
    fun growSide(side: Side, amount: RealT): Rect2 {
        var g = Rect2(this)
        g = g.growIndividual(
            if (Side.LEFT == side) amount else 0.0,
            if (Side.TOP == side) amount else 0.0,
            if (Side.RIGHT == side) amount else 0.0,
            if (Side.BOTTOM == side) amount else 0.0,
        )
        return g
    }

    /**
     * Returns true if the [Rect2] has area, and false if the Rect2 is linear, empty, or has a negative size. See also
     * [getArea].
     */
    fun hasArea() = size.x > 0.0f && size.y > 0.0f

    /**
     * Returns true if the Rect2 contains a point.
     */
    fun hasPoint(point: Vector2): Boolean {
        if (GodotJvmBuildConfig.DEBUG) {
            if (_size.x < 0 || _size.y < 0) {
                GodotLogging.error("Rect2 size is negative, this is not supported. Use Rect2.abs() to get a Rect2 with a positive size.")
            }
        }

        return when {
            point.x < _position.x -> false
            point.y < _position.y -> false
            point.x >= (_position.x + _size.x) -> false
            point.y >= (_position.y + _size.y) -> false
            else -> true
        }
    }

    /**
     * Returns the intersection of this [Rect2] and [b].
     *
     * If the rectangles do not intersect, an empty [Rect2] is returned.
     */
    fun intersection(rect: Rect2): Rect2 {
        val ret = Rect2(rect)

        if (!intersects(ret)) {
            return Rect2()
        }

        ret._position = rect._position.max(_position)

        val rectEnd: Point2 = rect._position + rect._size
        val end = _position + _size

        ret._size = rectEnd.min(end) - ret._position

        return ret
    }

    /**
     * Returns true if the Rect2 overlaps with b (i.e. they have at least one point in common).
     * If include_borders is true, they will also be considered overlapping if their borders touch, even without intersection.
     */
    @JvmOverloads
    fun intersects(b: Rect2, includeBorders: Boolean = false): Boolean {
        if (GodotJvmBuildConfig.DEBUG) {
            if (_size.x < 0 || _size.y < 0 || b._size.x < 0 || b._size.y < 0) {
                GodotLogging.error("Rect2 size is negative, this is not supported. Use Rect2.abs() to get a Rect2 with a positive size.")
            }
        }

        if (includeBorders) {
            return when {
                _position.x > (b._position.x + b._size.x) -> false
                (_position.x + _size.x) < b._position.x -> false
                _position.y > (b._position.y + b._size.y) -> false
                (_position.y + _size.y) < b._position.y -> false
                else -> true
            }
        } else {
            return when {
                _position.x >= (b._position.x + b._size.x) -> false
                (_position.x + _size.x) <= b._position.x -> false
                _position.y >= (b._position.y + b._size.y) -> false
                (_position.y + _size.y) <= b._position.y -> false
                else -> true
            }
        }
    }

    /**
     * Returns true if this Rect2 and rect are approximately equal, by calling is_equal_approx on each component.
     */
    fun isEqualApprox(b: Rect2): Boolean {
        return _position.isEqualApprox(b._position) && _size.isEqualApprox(b._size)
    }

    /**
     * Returns true if this rectangle's values are finite, by calling Vector2.is_finite on the position and the size.
     */
    fun isFinite(): Boolean {
        return position.isFinite() && size.isFinite();
    }

    /**
     * Returns a larger Rect2 that contains this Rect2 and b.
     */
    fun merge(rect: Rect2): Rect2 {
        if (GodotJvmBuildConfig.DEBUG) {
            if (_size.x < 0 || _size.y < 0 || rect._size.x < 0 || rect._size.y < 0) {
                GodotLogging.error("Rect2 size is negative, this is not supported. Use Rect2.abs() to get a Rect2 with a positive size.")
            }
        }

        val newRect = Rect2()

        newRect._position = rect._position.min(_position)

        newRect._size = (rect._position + rect._size).max(_position + _size)


        newRect._size = newRect._size - newRect._position // Make relative again.

        return newRect
    }

    fun toRect2i() = Rect2i(this)

    override fun equals(other: Any?): Boolean = when (other) {
        is Rect2 -> _position == other._position && _size == other._size
        else -> false
    }

    override fun toString(): String {
        return "[P: $_position, S: $_size]"
    }


    override fun hashCode(): Int {
        var result = _position.hashCode()
        result = 31 * result + _size.hashCode()
        return result
    }
}
