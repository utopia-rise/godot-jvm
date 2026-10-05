package godot.core

import godot.common.interop.NativeWrapper
import godot.common.interop.ObjectID
import godot.common.interop.VoidPtr
import godot.common.interop.nullObjectID
import godot.common.interop.nullptr
import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.internal.reflection.TypeManager
import kotlin.contracts.ExperimentalContracts

@OptIn(ExperimentalContracts::class)
@Suppress("LeakingThis", "FunctionName")
abstract class KtObject : GodotObject {

    /** Used to prevent the new method to be executed when called from instantiateWith
     * Instead we use the values set in that class  */
    internal class InitConfiguration {
        var ptr: VoidPtr = nullptr
        var objectID: ObjectID = nullObjectID

        fun reset() {
            ptr = nullptr
            objectID = nullObjectID
        }
    }

    final override val ptr: VoidPtr
    final override val objectID: ObjectID

    init {
        val config = initConfig.get()

        if (config.ptr != nullptr) {
            // Native object already exists, so we know the id and ptr without going back to the other side.
            ptr = config.ptr
            objectID = config.objectID
            config.reset()
            // We don't need to register the instance to the MemoryManager, it is the responsibility of the caller.
        } else {
            // Branch used when created directly from user code. The native object is going to be created here.
            // If the class is a script, the ScriptInstance is going to be created at the same time.
            new(TypeManager.userClassToScriptPtr[this::class] ?: nullptr)
            TransferContext.unsafeRead { buffer ->
                ptr = buffer.getLong()
                objectID = ObjectID(buffer.getLong())
            }
            MemoryManager.registerNewNativeObject(this)
        }

    }

    protected abstract fun new(scriptPtr: VoidPtr)

    open fun _get(property: StringName): Any = throw NotImplementedError("_get is not implemented for Object")
    open fun _getPropertyList(): VariantArray<Dictionary<Any, Any>> = throw NotImplementedError("_getPropertyList is not implemented for Object")
    open fun _propertyCanRevert(name: StringName): Boolean = throw NotImplementedError("_propertyCanRevert is not implemented for Object")
    open fun _propertyGetRevert(name: StringName): Any = throw NotImplementedError("_propertyGetRevert is not implemented for Object")
    open fun _set(name: StringName, value: Any): Unit = throw NotImplementedError("_set is not implemented for Object")
    open fun _toString(): String = throw NotImplementedError("_toString is not implemented for Object")
    open fun _validateProperty(): Boolean = throw NotImplementedError("_validateProperty is not implemented for Object")

    fun free() = freeObject(ptr)

    /**
     * Called automatically when the Object is destroyed. Note that this method is not available for RefCounted or any of its child class.
     * By the time a RefCounted counter reaches 0, its JVM instance has already being GCed and can't be used anymore.
     */
    open fun _onDestroy() = Unit


    override fun equals(other: Any?) = this === other || (other is KtObject && objectID == other.objectID)
    override fun hashCode() = ptr.toInt()


    private fun removeScript(constructorIndex: Int) {
        createScriptInstance(ptr, objectID, TypeManager.engineTypesConstructors[constructorIndex]!!)
    }

    protected external fun createNativeObject(classIndex: Int, scriptPtr: VoidPtr)
    protected external fun getSingleton(classIndex: Int)
    private external fun freeObject(rawPtr: VoidPtr)

    companion object {
        private val initConfig = ThreadLocal.withInitial { InitConfiguration() }
        private fun <T> withConfig(ptr: VoidPtr, id: ObjectID, block: () -> T) = initConfig.get().let {
            it.ptr = ptr
            it.objectID = id
            block()
        }

        /** When using this constructor, the newly created instances doesn't register itself to the MemoryManager, the caller must do it.*/
        fun <T : NativeWrapper> createScriptInstance(rawPtr: VoidPtr, id: ObjectID, constructor: () -> T) = withConfig(rawPtr, id) {
            val obj = constructor()
            MemoryManager.registerExistingNativeObject(obj)
            obj
        }

        /** When using this constructor, the newly created instances doesn't register itself to the MemoryManager, the caller must do it.*/
        fun getOrCreate(rawPtr: VoidPtr, id: ObjectID, constructorIndex: Int): KtObject {
            return MemoryManager.getInstanceOrCreate(id) {
                withConfig(rawPtr, id) {
                    TypeManager.engineTypesConstructors[constructorIndex]!!()
                }
            } as KtObject
        }
    }
}
