package godot.tests.registration

import godot.annotation.FloatRange
import godot.annotation.Emit
import godot.annotation.Export
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Node
import godot.core.signal1
import godot.core.signal2

abstract class AbstractClassInheritanceParent : Node() {
    @FloatRange(1f, 100f)
    @Visible
    @Export
    var speed: Double = 100.0

    @Export
    @Visible
    var registeredExportedPropertyInParent = false

    @Emit("blubb")
    val testNotOverridden by signal1<String>()

    @Emit("blubb", "habbalubb")
    open val testOverridden by signal2<String, Int>()

    @Visible
    var closedFunctionHasBeenCalled = false

    @Visible
    var closedVar = 0

    @Visible
    open var openVar = 0

    @Register
    fun closedFunction() {
        closedFunctionHasBeenCalled = true
    }

    @Register
    abstract fun openFunction()
}

@Script
class AbstractClassInheritanceChild : AbstractClassInheritanceParent() {
    @Emit("blubb", "habbalubbb")
    override val testOverridden by signal2<String, Int>()

    @Visible
    var childOpenFunctionHasBeenCalled = false

    override var openVar: Int = 100

    @Register
    override fun openFunction() {
        childOpenFunctionHasBeenCalled = true
    }
}
