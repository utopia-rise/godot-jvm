package godot.tests

import godot.Node
import godot.Object
import godot.Spatial
import godot.registration.annotation.RegisterClass
import godot.registration.annotation.RegisterFunction
import godot.registration.annotation.RegisterProperty
import godot.registration.annotation.RegisterSignal
import godot.signals.signal
import org.joda.time.DateTime

@RegisterClass
class OtherScript : Node() {

	@RegisterFunction
	fun hookNoParam() {
		println("Hook was called with no param.")
	}

	@RegisterFunction
	fun hookOneParam(b: Boolean) {
		println("Hook was called with parameter: $b")
	}

	@RegisterFunction
	fun hookTwoParam(str: String, inv: Spatial) {
        println("Hook was called with parameters: $str, $inv")
    }

//		This will fail with:
//		class godot.Spatial cannot be cast to class godot.tests.Invocation.
//		This needs the use of user defined constructors when crossing boundaries
//		see: KtVariant::asObject() and Bootstrap::registerManagedEngineTypes methods.
//
    @RegisterFunction
	fun hookTwoParamInvocation(str: String, inv: Invocation) {
		println("Hook was called with parameters (invocation): $str, $inv")
	}

}

@RegisterClass
class Invocation : Spatial() {
    @RegisterProperty var x = 0
    @RegisterProperty var y = 0.0
    @RegisterProperty var z = 0.0f
    @RegisterProperty var customName = "Idonthaveanyidea"

    var invocation = OtherScript()

    @RegisterSignal
    val signalNoParam by signal()

    @RegisterSignal
    val signalOneParam by signal<Boolean>("refresh")

    @RegisterSignal
    val signalTwoParam by signal<String, Invocation>("str", "inv")

    @RegisterSignal
    val signalTwoParamInvocation by signal<String, Invocation>("str", "inv")

    @RegisterFunction
    fun intValue(value: Int) = value

    @RegisterFunction
    fun longValue(value: Long) = value

    @RegisterFunction
    fun floatValue(value: Float) = value

    @RegisterFunction
    fun doubleValue(value: Double) = value

    @RegisterFunction
    fun booleanValue(value: Boolean) = value

    @RegisterFunction
    fun stringValue(value: String) = value

    @RegisterFunction
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
		val test = DateTime.now() //external dependency to test dependency inclusion in dummyCompilation

		signalNoParam.connect(invocation, invocation::hookNoParam)
		signalOneParam.connect(invocation, invocation::hookOneParam)
		signalTwoParam.connect(invocation, invocation::hookTwoParam)
		signalTwoParamInvocation.connect(invocation, invocation::hookTwoParamInvocation)
		signalNoParam.emit()
		signalOneParam.emit(false)
		signalTwoParam.emit("My Awesome param !", this)
        signalTwoParamInvocation.emit("My Awesome param (invocation)!", this)
	}

	override fun _onInit() {
		println("Hello Invocation!")
	}

	override fun _onDestroy() {
		invocation.free()
	}

	//Type cast checks
	@RegisterFunction
	fun parentIsSpatial() = getParent() is Spatial
	@RegisterFunction
	fun isObjectSpatial(obj: Object) = obj is Spatial
}
