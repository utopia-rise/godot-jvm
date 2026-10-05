package godot.internal.memory

import godot.common.interop.ObjectID
import godot.common.interop.VoidPtr
import godot.common.interop.nullObjectID
import godot.common.interop.nullptr

/**
 * How a wrapper built for an object that already exists natively receives its pointer and id.
 *
 * A JVM object cannot be handed constructor arguments it never declared, and requiring one would force the constructor
 * onto every wrapper class and onto every user script. The values are left here for the constructor to pick up
 * instead, which is only sound because the thread that sets them is the thread that runs the constructor.
 */
class InitConfiguration {
    var ptr: VoidPtr = nullptr
    var objectID: ObjectID = nullObjectID

    fun reset() {
        ptr = nullptr
        objectID = nullObjectID
    }

    companion object {
        /** The one belonging to the calling thread, which is the only one a constructor may read. */
        @JvmStatic
        val current: InitConfiguration
            get() = ThreadContext.initConfiguration
    }
}
