package godot.tests.coroutine


import godot.api.Object
import godot.api.PackedScene
import godot.api.ResourceLoader
import godot.api.Engine
import godot.api.SceneTree
import godot.api.Timer
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Visible
import godot.annotation.Emit
import godot.core.Vector2
import godot.core.signal0
import godot.core.signal1
import godot.core.signal4
import godot.coroutines.await
import godot.coroutines.awaitLoadAs
import godot.coroutines.awaitMainThread
import godot.coroutines.awaitPhysicsFrame
import godot.coroutines.awaitProcessFrame
import godot.coroutines.godotCoroutine
import godot.coroutines.GodotDispatchers
import godot.global.GD
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

@Script
class CoroutineTest : Object() {

    @Emit
    val signalWithoutParameter by signal0()

    @Emit("int")
    val signalWithOneParameter by signal1<Int>()

    @Emit("int", "float", "vector2", "string")
    val signalWithManyParameters by signal4<Int, Float, Vector2, String>()

    @Visible
    var step: Int = 0

    @Visible
    var wasChildCancelled = false

    @Visible
    var wasParentCancelled = true

    @Visible
    var manyParameterPayloadSummary = ""

    @Register
    fun startCoroutineWithoutParameter() = godotCoroutine {
        step = 1
        signalWithoutParameter.await()
        step = 2
    }

    @Register
    fun startCoroutineWithOneParameter() = godotCoroutine {
        step = 3
        step = signalWithOneParameter.await()
    }

    @Register
    fun startCoroutineWithManyParameters() = godotCoroutine {
        step = 5
        val (int, floatValue, vector2Value, stringValue) = signalWithManyParameters.await()
        manyParameterPayloadSummary = "$int|$floatValue|${vector2Value.x},${vector2Value.y}|$stringValue"
        step = int
    }

    @Register
    fun startCoroutineUndispatched() = godotCoroutine(start = CoroutineStart.UNDISPATCHED) {
        step = 7
        signalWithoutParameter.await()
        step = 8
    }

    @Register
    fun startCoroutineWithPhysicsFrame() = godotCoroutine(start = CoroutineStart.UNDISPATCHED) {
        step = 9
        awaitPhysicsFrame {
            step = 10
        }
    }

    @Register
    fun startCoroutineWithProcessFrame() = godotCoroutine(start = CoroutineStart.UNDISPATCHED) {
        step = 11
        awaitProcessFrame {
            step = 12
        }
    }

    @Emit("is_test_successful")
    val runOnMainThreadFromBackgroundThreadFinished by signal1<Boolean>()

    @Register
    fun runOnMainThreadFromBackgroundThread() {
        val thread = Thread.currentThread().name

        godotCoroutine {
            val bgThread = Thread.currentThread().name

            var fgThread = ""
            awaitMainThread {
                fgThread = Thread.currentThread().name
            }

            val bg2Thread = Thread.currentThread().name

            GD.print("Thread names: ${listOf(thread, bgThread, fgThread, bg2Thread).joinToString()}")

            awaitMainThread {
                runOnMainThreadFromBackgroundThreadFinished.emit(
                    thread != bgThread
                        && thread != bg2Thread
                        && bgThread != fgThread
                        && thread == fgThread // check that the code is run on the main thread
                )
            }
        }
    }

    @Emit("is_test_successful")
    val asyncLoadResourceFinished by signal1<Boolean>()

    @Register
    fun asyncLoadResource() {
        godotCoroutine {
            val resource = ResourceLoader.awaitLoadAs<PackedScene>("res://Spatial.tscn")

            GD.print("Resource: $resource")

            awaitMainThread {
                asyncLoadResourceFinished.emit(resource != null)
            }
        }
    }

    @Register
    fun cancelCoroutine() = godotCoroutine {
        val timer = Timer()
        awaitMainThread {
            (Engine.getMainLoop() as SceneTree).root.addChild(timer)
            timer.start(3.0)
        }
        val job = async(GodotDispatchers.MainThread) {
            timer.timeout.await()
        }
        delay(1000)
        awaitMainThread {
            timer.queueFree()
        }
        delay(1000)
        wasChildCancelled = job.isCancelled
        wasParentCancelled = false
    }
}



