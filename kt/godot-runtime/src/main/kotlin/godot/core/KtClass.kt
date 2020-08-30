package godot.core

import godot.util.VoidPtr

class KtClass<T : KtObject>(
    val name: String,
    val superClass: String,
    private val constructors: Map<Int, KtConstructor<T>>,
    private val _functions: Map<String, KtFunction<T, *>>
) {
	val functions: Array<KtFunction<T, *>>
		get() = _functions.values.toTypedArray()

    fun new(rawPtr: VoidPtr, vararg args: KtVariant): T {
        val constructor = constructors[args.size]
        check(constructor != null) { "Constructor with ${args.size} parameter(s) not found." }
        return KtObject.instantiateWith(rawPtr) {
            constructor(*args)
        }
    }

    fun callFunction(name: String, instance: T, vararg args: KtVariant): KtVariant {
        val function = _functions[name]
        check(function != null) { "Function with $name not found." }
        return function(instance, args.toList())
    }

}