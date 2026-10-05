package godot.internal.memory

import java.util.ArrayDeque

/**
 * Strings too large to travel inline in the [VariantBuffer], handed over one at a time.
 *
 * Only the inbound direction is queued here. C++ pushes with [queueString] and the JVM takes with [pollString]; going
 * the other way, [sendStringToCPP] hands the string straight over and C++ queues it on its own side, in the mirror of
 * this class.
 *
 * This object is the side that knows about threads, and the JNI surface C++ binds to. [Inbox] is the side that holds
 * the strings and knows nothing about either.
 */
object LongStringQueue {

    // If changed, remember to change also max_string_size in long_string_queue.cpp and the StringTest.kt
    var stringMaxSize = 128

    private val inbox = ThreadLocal.withInitial { Inbox() }

    fun queueString(str: String) {
        inbox.get().receive(str)
    }

    fun pollString(): String {
        return inbox.get().take()
    }

    external fun sendStringToCPP(str: String)

    /** One thread's worth of strings waiting to be read, in arrival order. */
    private class Inbox {
        private val strings = ArrayDeque<String>(5)

        fun receive(str: String) {
            strings.addLast(str)
        }

        fun take(): String = strings.pollFirst()
    }
}
