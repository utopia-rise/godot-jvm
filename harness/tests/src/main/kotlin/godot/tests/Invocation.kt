package godot.tests

import godot.Node
import godot.Object
import godot.Spatial
import godot.registration.annotation.RegisterClass
import godot.registration.annotation.RegisterFunction
import org.joda.time.DateTime

class OtherScript : Node() {

}

@RegisterClass
class Invocation : Spatial() {
	var x = 0
	var y = 0.0
	var z = 0.0f
	var customName = "Idonthaveanyidea"

	var invocation = OtherScript()

	fun intValue(value: Int) = value
	fun longValue(value: Long) = value
	fun floatValue(value: Float) = value
	fun doubleValue(value: Double) = value
	fun booleanValue(value: Boolean) = value
	fun stringValue(value: String) = value

	fun intAddition(a: Int, b: Int) = a + b

    @RegisterFunction
	fun _enterTree() {
		println("Enter tree !")
		println("Instance id: ${getInstanceId()}")
	}

    @RegisterFunction
	fun _ready() {
		val formerName = name
		println("Name is: $name")
		name = "TestName"
		println("Name is: $name")
		name = formerName
        val test = DateTime.now()
	}

	override fun _onInit() {
		println("Hello Invocation!")
	}

	override fun _onDestroy() {
		invocation.free()
	}

    //Type cast checks
    fun parentIsSpatial() = getParent() is Spatial
    fun isObjectSpatial(obj: Object) = obj is Spatial
}
