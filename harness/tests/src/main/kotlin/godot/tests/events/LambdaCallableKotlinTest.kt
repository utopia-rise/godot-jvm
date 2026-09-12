package godot.tests.events

import godot.api.Node
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Visible
import godot.annotation.Emit
import godot.core.Signal3
import godot.core.Callable1
import godot.core.VariantCaster
import godot.core.asCallable
import godot.core.lambdaCallable0
import godot.core.lambdaCallable1
import godot.core.signal0
import godot.core.signal3
import godot.extension.connectLambda

@Script
class LambdaCallableKotlinTest : Node() {

    @Emit
    val signalNoParam by signal0()

    @Visible
    var hasSignalNoParamBeenTriggered = false

    @Emit("str", "long", "node")
    val signalWithParams: Signal3<String, Long, LambdaCallableKotlinTest> by signal3()

    @Visible
    var signalString: String = ""

    @Visible
    var signalLong: Long = Long.MIN_VALUE

    @Visible
    lateinit var signalNode: LambdaCallableKotlinTest

    @Visible
    var ktCallable = { str: String -> ktCallableString = str }.asCallable()

    @Visible
    var ktCallableString: String = ""

    // Built with explicit converters: a reified type only carries the outer class, so a nested typed array needs them.
    @Visible
    var sumNestedInts = lambdaCallable1(
        VariantCaster.INT,
        VariantCaster.TYPED_ARRAY(VariantCaster.TYPED_ARRAY(VariantCaster.INT))
    ) { arrays -> arrays.sumOf { it.sum() } }

    @Visible
    var callableNoParamTriggered = false

    @Visible
    var callableWithParamTriggered = false

    @Visible
    var deferredStoredCallableTriggered = false

    @Visible
    var deferredStoredCallablePayload = ""

    @Visible
    var callableStillWorksAfterTreeExit = false

    private var storedDeferredCallable: Callable1<Unit, String>? = null

    @Register
    override fun _ready() {
        signalNoParam.connectLambda {
            hasSignalNoParamBeenTriggered = true
        }

        signalWithParams.connectLambda { p0, p1, p2 ->
            signalString = p0
            signalLong = p1
            signalNode = p2
        }
    }

    @Register
    fun emitSignalNoParam() {
        signalNoParam.emit()
    }

    @Register
    fun emitSignalWithParam(str: String, long: Long) {
        signalWithParams.emit(str, long, this)
    }

    @Register
    fun markCallableNoParamTriggered() {
        callableNoParamTriggered = true
    }

    @Register
    fun callCallableNoParam() {
        lambdaCallable0(this::markCallableNoParamTriggered).call()
    }

    @Register
    fun callCallableNoParamDeferred() {
        lambdaCallable0(this::markCallableNoParamTriggered).callDeferred()
    }

    @Register
    fun markCallableWithParamTriggered(flag: Boolean) {
        callableWithParamTriggered = flag
    }

    @Register
    fun callCallableWithParam() {
        lambdaCallable1(this::markCallableWithParamTriggered).call(true)
    }

    @Register
    fun callCallableWithParamDeferred() {
        lambdaCallable1(this::markCallableWithParamTriggered).callDeferred(true)
    }

    @Register
    fun queueStoredCallableDeferred(payload: String) {
        deferredStoredCallableTriggered = false
        deferredStoredCallablePayload = ""
        storedDeferredCallable = { value: String ->
            deferredStoredCallableTriggered = true
            deferredStoredCallablePayload = value
        }.asCallable()
        storedDeferredCallable?.callDeferred(payload)
    }

    @Register
    fun verifyCallableAfterTreeExit() {
        callableStillWorksAfterTreeExit = false
        lambdaCallable0 {
            callableStillWorksAfterTreeExit = true
        }.call()
    }
}

