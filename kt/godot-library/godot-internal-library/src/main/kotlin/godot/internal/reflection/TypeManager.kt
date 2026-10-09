package godot.internal.reflection

import godot.common.interop.NativeWrapper
import godot.common.interop.VoidPtr
import godot.common.interop.nullptr
import kotlin.reflect.KClass

object TypeManager {
    val engineTypeToId = HashMap<Class<*>, Int>()

    private val scriptClassCache = mutableListOf<Class<*>>()
    val classToScriptPtr = HashMap<Class<*>, VoidPtr>()

    val userTypes = LinkedHashSet<String>()
    val engineTypeNames = LinkedHashSet<String>()
    val engineSingletonsNames = LinkedHashSet<String>()

    val engineTypesConstructors = mutableListOf<(() -> NativeWrapper)?>()
    val singletonsConstructors = mutableListOf<() -> NativeWrapper>()

    fun registerUserType(className: String, kClass: KClass<out NativeWrapper>) {
        userTypes.add(className)
        scriptClassCache.add(kClass.java)
    }

    fun registerEngineType(className: String, clazz: KClass<out NativeWrapper>, invoke: (() -> NativeWrapper)?) {
        engineTypesConstructors.add(invoke)
        engineTypeNames.add(className)
        engineTypeToId[clazz.java] = engineTypeNames.size - 1
        classToScriptPtr[clazz.java] = nullptr
    }

    fun registerSingleton(singletonName: String, invocator: () -> NativeWrapper) {
        engineSingletonsNames.add(singletonName)
        singletonsConstructors.add(invocator)
    }

    fun clearUserTypes() {
        scriptClassCache.clear()
        classToScriptPtr.keys.removeAll { it !in engineTypeToId }
        userTypes.clear()
    }

    fun clearScriptClassCache() {
        scriptClassCache.clear()
    }

    fun assignScriptToClass(index: Int, scriptPtr: VoidPtr) {
        classToScriptPtr[scriptClassCache[index]] = scriptPtr
    }

    external fun getMethodBindPtr(className: String, methodName: String, hash: Long): VoidPtr
}
