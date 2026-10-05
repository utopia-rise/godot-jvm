package godot.internal.memory.binding

import godot.common.interop.NativeWrapper
import godot.common.interop.ObjectID
import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference

interface Binding {
    val objectID: ObjectID
    val instance: NativeWrapper?

    companion object {
        val queue = ReferenceQueue<NativeWrapper>()

        fun create(instance: NativeWrapper): Binding {
            return if (instance.objectID.isReference) {
                RefCountedBinding(instance, queue)
            } else {
                ObjectBinding(instance)
            }
        }
    }
}

class ObjectBinding(
    override val instance: NativeWrapper,
) : Binding {
    override val objectID: ObjectID = instance.objectID
}

class RefCountedBinding(
    instance: NativeWrapper,
    queue: ReferenceQueue<NativeWrapper>,
) : WeakReference<NativeWrapper>(instance, queue), Binding {

    override val objectID: ObjectID = instance.objectID

    override val instance: NativeWrapper?
        get() = this.get()
}



