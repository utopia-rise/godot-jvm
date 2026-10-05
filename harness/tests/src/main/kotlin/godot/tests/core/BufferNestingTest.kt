package godot.tests.core

import godot.annotation.Notification
import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node3D
import godot.core.StringName
import godot.core.VariantArray
import godot.core.Vector3
import godot.core.variantArrayOf

/**
 * Exercises the two shared buffers while calls are nested inside one another.
 *
 * Calling [Node3D.notification] is an unchecked call, so its arguments stay in a value buffer frame for as long as the
 * engine is inside it, and the engine dispatches the notification straight back into JVM code from there. Every call
 * the handler makes therefore runs while an outer frame is still live, which is the situation frames exist for.
 *
 * The chain below alternates the two buffers on purpose. A method is only unchecked when every argument and its return
 * have a native layout the engine can read in place, so `setMeta` (a Variant argument) and `setSceneFilePath` (a String
 * argument) fall back to the variant buffer, while `notification` and `setPosition` stay on the value buffer.
 *
 *   runNestedChain                                  JVM
 *     notification(FIRST)                           value buffer, frame 0
 *       onFirstNotification                         JVM, reached through the variant buffer
 *         setMeta                                   variant buffer, Variant argument
 *         setSceneFilePath                          variant buffer, String argument
 *         notification(SECOND)                      value buffer, frame 1
 *           onSecondNotification                    JVM, reached through the variant buffer
 *             setPosition / getPosition             value buffer, frame 2
 *             getMeta / getSceneFilePath            variant buffer
 */
@Script
class BufferNestingTest : Node3D() {
    private val trace = mutableListOf<String>()

    private var positionAtDepth3 = Vector3.ZERO
    private var metaAtDepth3: Any? = null
    private var sceneFilePathAtDepth3 = ""

    private var remainingDepth = 0
    private var deepestPosition = Vector3.ZERO

    @Register
    fun runNestedChain(): VariantArray<Any?> {
        trace.clear()
        positionAtDepth3 = Vector3.ZERO
        metaAtDepth3 = null
        sceneFilePathAtDepth3 = ""

        trace += "enter"
        notification(FIRST.toInt())
        trace += "exit"

        return variantArrayOf(
            trace.joinToString(","),
            positionAtDepth3,
            metaAtDepth3,
            sceneFilePathAtDepth3,
            getPosition(),
            getMeta(StringName(META_NAME)),
        )
    }

    /** Runs the whole chain repeatedly: a frame that is pushed without being popped would exhaust the stack here. */
    @Register
    fun runNestedChainRepeatedly(times: Int): Boolean {
        for (i in 0 until times) {
            val values = runNestedChain()
            if (values[0] != "enter,first,second,exit") return false
            if (values[1] != DEPTH3_POSITION) return false
        }
        return true
    }

    /**
     * Frames are packed, so the size factor is the room for entirely full frames rather than a nesting limit: these
     * carry two small arguments each and many more than [FIRST] of them fit in the default four frames' worth.
     */
    @Register
    fun runDeepNesting(depth: Int): Boolean {
        remainingDepth = depth
        deepestPosition = Vector3.ZERO
        notification(DEEP.toInt())
        return deepestPosition == DEPTH3_POSITION
    }

    @Notification(DEEP)
    fun onDeepNotification() {
        if (remainingDepth > 0) {
            remainingDepth--
            notification(DEEP.toInt())
            return
        }
        setPosition(DEPTH3_POSITION)
        deepestPosition = getPosition()
    }

    @Notification(FIRST)
    fun onFirstNotification() {
        trace += "first"
        setMeta(StringName(META_NAME), META_VALUE)
        setSceneFilePath(SCENE_FILE_PATH)
        notification(SECOND.toInt())
    }

    @Notification(SECOND)
    fun onSecondNotification() {
        trace += "second"
        setPosition(DEPTH3_POSITION)
        positionAtDepth3 = getPosition()
        metaAtDepth3 = getMeta(StringName(META_NAME))
        sceneFilePathAtDepth3 = getSceneFilePath()
    }

    companion object {
        // Above every notification the engine defines, so only this class answers them.
        const val FIRST = 9001L
        const val SECOND = 9002L
        const val DEEP = 9003L

        const val META_NAME = "buffer_nesting"
        const val META_VALUE = 41L
        const val SCENE_FILE_PATH = "res://buffer_nesting.tscn"

        val DEPTH3_POSITION = Vector3(1.5, -2.25, 3.75)
    }
}
