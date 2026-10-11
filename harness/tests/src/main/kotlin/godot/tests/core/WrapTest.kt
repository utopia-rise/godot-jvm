package godot.tests.core

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import godot.global.GD

// GD reimplements wrapi and wrapf instead of calling the engine, so test_wrap.gd compares these
// against the GDScript built-ins.
@Script
class WrapTest : Node() {
    @Register
    fun wrapInt(value: Int, min: Int, max: Int): Int = GD.wrapi(value, min, max)

    @Register
    fun wrapLong(value: Long, min: Long, max: Long): Long = GD.wrapi(value, min, max)

    @Register
    fun wrapFloat(value: Float, min: Float, max: Float): Float = GD.wrapf(value, min, max)

    @Register
    fun wrapDouble(value: Double, min: Double, max: Double): Double = GD.wrapf(value, min, max)
}
