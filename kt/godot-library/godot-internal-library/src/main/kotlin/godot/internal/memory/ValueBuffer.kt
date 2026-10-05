package godot.internal.memory

import godot.common.constants.Constraints
import godot.common.interop.VoidPtr
import kotlincompile.definitions.GodotJvmBuildConfig
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * The per-thread stack of ptrcall frames. The engine reads the arguments of a ptrcall where the JVM wrote them and
 * writes its result right after them, so a frame stays live for the whole engine call, including any JVM code it
 * reenters that calls the engine again. Each live call therefore owns a frame of its own.
 *
 * Frames are packed: one starts where the previous one ended, so a call only consumes what it actually writes. The
 * caller keeps its own frame offset and return offset in its JVM stack frame, which is already one per live call, so
 * the only state kept here is where the next frame begins.
 *
 * [sizeFactor] sizes the stack in frames that are entirely full: 16 arguments and a return, each an 8 byte tag plus
 * at most 64 bytes of payload, aligned on 8. Strings never take this path, so that bound holds. It is a capacity, not
 * a limit on how many calls may nest: real calls are far smaller than that, so many more of them fit.
 */
object ValueBuffer {
    /** Caller pointer and caller ObjectID. Every frame starts with these, and the specialised calls need nothing else. */
    private const val CALLER_SIZE = 16
    private const val HEADER_SIZE = 24
    private const val VALUE_SIZE = 80
    private const val FRAME_SIZE = HEADER_SIZE + (Constraints.MAX_FUNCTION_ARG_COUNT + 1) * VALUE_SIZE
    private const val DEFAULT_SIZE_FACTOR = 4

    var sizeFactor: Int = 0

    class Stack internal constructor() {
        @JvmField
        val buffer: ByteBuffer = ByteBuffer
            .allocateDirect((if (sizeFactor > 0) sizeFactor else DEFAULT_SIZE_FACTOR) * FRAME_SIZE)
            .order(ByteOrder.LITTLE_ENDIAN)

        /**
         * Where [buffer] starts in memory, which only the native side can ask for. Handed to every unchecked call so
         * that side needs no thread-local of its own: it builds its cursor on its own stack from this and the frame
         * offset. Asked for once here because the buffer is allocated once per thread and never moves.
         */
        @JvmField
        val address: Long = bufferAddress(buffer)

        private var top = 0

        /** Opens a frame on the buffer, writes its header, and returns its offset for the native side to read from. */
        fun open(callerPtr: VoidPtr, callerId: Long, argumentCount: Int): Int {
            val base = top
            if (GodotJvmBuildConfig.DEBUG) {
                check(base + FRAME_SIZE <= buffer.capacity()) {
                    "The value buffer is full: too many engine calls are running at once on this thread."
                }
            }
            buffer.position(base)
            buffer.putLong(callerPtr)
            buffer.putLong(callerId)
            buffer.putInt(argumentCount)
            return base
        }

        /**
         * A call with no arguments and no return, so the frame is only the caller record: no argument count to write,
         * nothing for the engine to write back into, and nothing to read afterwards.
         */
        fun openSimple(callerPtr: VoidPtr, callerId: Long): Int {
            val base = top
            if (GodotJvmBuildConfig.DEBUG) {
                check(base + FRAME_SIZE <= buffer.capacity()) {
                    "The value buffer is full: too many engine calls are running at once on this thread."
                }
            }
            buffer.position(base)
            buffer.putLong(callerPtr)
            buffer.putLong(callerId)
            top = base + CALLER_SIZE
            return base
        }

        /**
         * A call with one argument and no return. The caller writes the payload straight after the caller record, with
         * no type tag: the native side is told the type instead, since the generated call already knows it.
         */
        fun openSetter(callerPtr: VoidPtr, callerId: Long): Int {
            val base = top
            if (GodotJvmBuildConfig.DEBUG) {
                check(base + FRAME_SIZE <= buffer.capacity()) {
                    "The value buffer is full: too many engine calls are running at once on this thread."
                }
            }
            buffer.position(base)
            buffer.putLong(callerPtr)
            buffer.putLong(callerId)
            return base
        }

        /** Closes a setter frame over the payload the caller just wrote. */
        fun sealSetter() {
            top = (buffer.position() + 7) and 7.inv()
        }

        /**
         * A call with no arguments and one return. The engine writes its result where the arguments would have gone,
         * untagged, because the generated call knows the type it asked for.
         */
        fun openGetter(callerPtr: VoidPtr, callerId: Long): Int {
            val base = top
            if (GodotJvmBuildConfig.DEBUG) {
                check(base + FRAME_SIZE <= buffer.capacity()) {
                    "The value buffer is full: too many engine calls are running at once on this thread."
                }
            }
            buffer.position(base)
            buffer.putLong(callerPtr)
            buffer.putLong(callerId)
            top = base + CALLER_SIZE + VALUE_SIZE
            return base
        }

        /** Releases a frame the engine wrote nothing into. */
        fun closeVoid(base: Int) {
            top = base
        }

        /** Releases a getter frame and positions the buffer on the value the engine wrote. */
        fun closeGetter(base: Int): ByteBuffer {
            top = base
            return buffer.position(base + CALLER_SIZE)
        }

        /**
         * Closes the frame to further arguments and opens the next one past the return record the engine is about to
         * write. Returns where that record starts, which is where the buffer is left standing.
         */
        fun seal(): Int {
            // The return record carries no type tag, and it was the tag's own read that used to align it, so the
            // boundary is taken here instead. The native side aligns its frame the same way before reserving.
            val returnPosition = (buffer.position() + 7) and 7.inv()
            top = (returnPosition + VALUE_SIZE + 7) and 7.inv()
            return returnPosition
        }

        /** Releases the frame and positions the buffer on the return record the engine wrote. */
        fun close(base: Int, returnPosition: Int): ByteBuffer {
            top = base
            return buffer.position(returnPosition)
        }
    }

    val stack: Stack
        get() = ThreadContext.valueStack

    private external fun bufferAddress(buffer: ByteBuffer): Long
}
