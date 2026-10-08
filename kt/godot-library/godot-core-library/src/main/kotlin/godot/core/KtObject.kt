package godot.core

import godot.common.interop.NativeWrapper
import godot.common.interop.ObjectID
import godot.common.interop.VoidPtr
import godot.common.interop.nullptr
import godot.internal.memory.MemoryManager
import godot.internal.memory.InitConfiguration
import godot.internal.logging.GodotPrint
import godot.internal.memory.VariantBuffer
import godot.internal.reflection.TypeManager
import kotlincompile.definitions.GodotJvmBuildConfig
import kotlin.contracts.ExperimentalContracts

@OptIn(ExperimentalContracts::class)
@Suppress("LeakingThis", "FunctionName")
abstract class KtObject : GodotObject {

    final override val ptr: VoidPtr
    final override val objectID: ObjectID

    init {
        val config = InitConfiguration.current

        if (config.ptr != nullptr) {
            // Native object already exists, so we know the id and ptr without going back to the other side.
            ptr = config.ptr
            objectID = config.objectID
            config.reset()
            // We don't need to register the instance to the MemoryManager, it is the responsibility of the caller.
        } else {
            // Branch used when created directly from user code. The native object is going to be created here.
            // If the class is a script, the ScriptInstance is going to be created at the same time.
            val scriptPtr = TypeManager.classToScriptPtr[this::class]
            if (GodotJvmBuildConfig.DEBUG) {
                if (scriptPtr == null) {
                    GodotPrint.pushWarning(
                        "${this::class.qualifiedName} is not a registered script, its overrides and registered members are ignored. Annotate it with @Script."
                    )
                }
            }
            new(scriptPtr ?: nullptr)
            VariantBuffer.transfer.unsafeRead { buffer ->
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
        @JvmStatic
        external fun icall(methodPtr: VoidPtr)

        @JvmStatic
        external fun icallPtr(methodPtr: VoidPtr, base: Long, returnType: Int, frameOffset: Int)

        // Three shapes the generator picks instead of icallPtr when it can, each doing only what that shape needs.
        /** No arguments, no return. */
        @JvmStatic
        external fun icallPtrSimple(methodPtr: VoidPtr, base: Long, frameOffset: Int)

        /** One argument of [argumentType], no return. The argument carries no type tag. */
        @JvmStatic
        external fun icallPtrSetter(methodPtr: VoidPtr, base: Long, frameOffset: Int, argumentType: Int)

        /** No arguments, one return of [returnType]. The engine writes it untagged. */
        @JvmStatic
        external fun icallPtrGetter(methodPtr: VoidPtr, base: Long, frameOffset: Int, returnType: Int)

        private fun <T> withConfig(ptr: VoidPtr, id: ObjectID, block: () -> T) =
            InitConfiguration.current.let {
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
        fun getOrCreate(rawPtr: VoidPtr, id: ObjectID): KtObject {
            return MemoryManager.getInstanceOrCreate(id) {
                withConfig(rawPtr, id) {
                    // Only reached when this object has no wrapper yet, so asking the native side for its engine class
                    // happens once in the object's life.
                    TypeManager.engineTypesConstructors[MemoryManager.bindObject(rawPtr)]!!()
                }
            } as KtObject
        }
    }
}
