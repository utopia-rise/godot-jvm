package godot.tests.coroutine

import godot.annotation.Emit
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Node
import godot.api.PackedScene
import godot.api.ResourceLoader
import godot.api.Timer
import godot.core.Vector2
import godot.core.signal0
import godot.core.signal1
import godot.core.signal4
import godot.coroutines.GodotDispatchers
import godot.coroutines.asFlow
import godot.coroutines.await
import godot.coroutines.awaitLoadAs
import godot.coroutines.awaitNextPhysicsProcess
import godot.coroutines.awaitNextProcess
import godot.coroutines.launch
import godot.coroutines.threadSafe
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

@Script
class CoroutineTest : Node() {
    @Emit
    val signalWithoutParameter by signal0()

    @Emit("int")
    val signalWithOneParameter by signal1<Int>()

    @Emit("int", "float", "vector2", "string")
    val signalWithManyParameters by signal4<Int, Float, Vector2, String>()

    @Visible var step: Int = 0
    @Visible var wasChildCancelled = false
    @Visible var wasParentCancelled = true
    @Visible var manyParameterPayloadSummary = ""

    @Register
    fun startCoroutineWithoutParameter() {
        launch {
            step = 1
            signalWithoutParameter.await()
            step = 2
        }
    }

    @Register
    fun startCoroutineWithOneParameter() {
        launch {
            step = 3
            step = signalWithOneParameter.await()
        }
    }

    @Register
    fun startCoroutineWithManyParameters() {
        launch {
            step = 5
            val (int, floatValue, vector2Value, stringValue) = signalWithManyParameters.await()
            manyParameterPayloadSummary = "$int|$floatValue|${vector2Value.x},${vector2Value.y}|$stringValue"
            step = int
        }
    }

    @Register
    fun startCoroutineUndispatched() {
        launch(start = CoroutineStart.UNDISPATCHED) {
            step = 7
            signalWithoutParameter.await()
            step = 8
        }
    }

    @Register
    fun startCoroutineWithPhysicsFrame() {
        launch(start = CoroutineStart.UNDISPATCHED) {
            step = 9
            awaitNextPhysicsProcess()
            step = 10
        }
    }

    @Register
    fun startCoroutineWithProcessFrame() {
        launch(start = CoroutineStart.UNDISPATCHED) {
            step = 11
            awaitNextProcess()
            step = 12
        }
    }

    @Register
    fun startCoroutineWithFlow() {
        launch {
            step = 13
            step = signalWithOneParameter.asFlow().first()
        }
    }

    @Emit("is_test_successful")
    val runOnMainThreadFromBackgroundThreadFinished by signal1<Boolean>()

    @Register
    fun runOnMainThreadFromBackgroundThread() {
        val mainThread = Thread.currentThread().name

        launch(GodotDispatchers.ThreadPool) {
            val backgroundThread = Thread.currentThread().name
            var foregroundThread = ""
            threadSafe { foregroundThread = Thread.currentThread().name }
            val resumedThread = Thread.currentThread().name

            threadSafe {
                runOnMainThreadFromBackgroundThreadFinished.emit(
                    mainThread != backgroundThread &&
                        mainThread != resumedThread &&
                        backgroundThread != foregroundThread &&
                        mainThread == foregroundThread,
                )
            }
        }
    }

    @Emit("is_test_successful")
    val asyncLoadResourceFinished by signal1<Boolean>()

    @Register
    fun asyncLoadResource() {
        launch {
            val resource = ResourceLoader.awaitLoadAs<PackedScene>("res://Spatial.tscn")
            asyncLoadResourceFinished.emit(resource != null)
        }
    }

    @Register
    fun cancelCoroutine() {
        launch {
            val timer = Timer()
            addChild(timer)
            timer.start(3.0)

            val job = async { timer.timeout.await() }
            delay(1_000)
            timer.queueFree()
            delay(1_000)

            wasChildCancelled = job.isCancelled
            wasParentCancelled = false
        }
    }
}
