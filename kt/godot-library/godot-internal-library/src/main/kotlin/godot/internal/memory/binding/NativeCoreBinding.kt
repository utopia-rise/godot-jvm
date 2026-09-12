package godot.internal.memory.binding

import godot.common.interop.NativePointer
import godot.common.interop.VariantConverter
import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference

class NativeCoreBinding(
    ref: NativePointer,
    val variantType: VariantConverter<*>
) : WeakReference<NativePointer>(ref, queue) {
    val ptr = ref.ptr

    companion object {
        /** Queue to be notified when the GC runs on NativeCoreTypes.*/
        val queue = ReferenceQueue<NativePointer>()
    }
}
