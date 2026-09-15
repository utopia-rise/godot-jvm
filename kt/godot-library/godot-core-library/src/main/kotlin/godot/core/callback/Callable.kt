@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.common.interop.ObjectID
import godot.common.interop.VoidPtr

/**
 * Callable is a built-in Variant type that represents a function.
 *
 * It can either be a method within an Object instance, or a custom callable used for different purposes (see is_custom).
 *
 * Like all Variant types, it can be stored in variables and passed to other functions. It is most commonly used for signal callbacks.
 *
 * This JVM version added an "unsafe" prefix to several methods. It's encouraged to use the typed version of those methods instead.
 */
interface Callable : CoreType {
    /**
     * Returns a copy of this Callable with one or more arguments bound.
     * When called, the bound arguments are passed after the arguments supplied by call. See also unbind.
     *
     * Note: When this method is chained with other similar methods, the order in which the argument list is modified is read from right to left.
     */
    fun bindUnsafe(vararg args: Any?): Callable


    /**
     * Calls the method represented by this Callable. Arguments can be passed and should match the method's signature.
     * */
    fun callUnsafe(vararg args: Any?): Any?

    /**Calls the method represented by this Callable in deferred mode, i.e. at the end of the current frame.
     * Arguments can be passed and should match the method's signature.
     *
     * Note: Deferred calls are processed at idle time.
     * Idle time happens mainly at the end of process and physics frames.
     * In it, deferred calls will be run until there are none left, which means you can defer calls from other deferred calls and they'll still be run in the current idle time cycle.
     * This means you should not call a method deferred from itself (or from a method called by it), as this causes infinite recursion the same way as if you had called the method directly.
     */
    fun callDeferredUnsafe(vararg args: Any?)

    /**
     * Returns the array of arguments bound via successive bind or unbind calls. These arguments will be added after the arguments passed to the call, from which get_unbound_arguments_count arguments on the right have been previously excluded.
     * */
    fun getBoundArguments(): Collection<Any?>

    /**
     * Returns the total amount of arguments bound via successive bind or unbind calls. This is the same as the size of the array returned by get_bound_arguments. See get_bound_arguments for details
     *
     * Note: The get_bound_arguments_count and get_unbound_arguments_count methods can both return positive values.
     * */
    fun getBoundArgumentCount(): Int

    /**
     * Returns the name of the method represented by this Callable.
     * If the callable is a GDScript lambda function, returns the function's name or "<anonymous lambda>".
     */
    fun getMethod(): StringName

    /**Returns the object on which this Callable is called.*/
    fun getObject(): GodotObject?

    /**Returns the ID of this Callable's object (see [Object.getInstanceId]).*/
    fun getObjectId(): ObjectID

    /**
     * Returns true if this Callable is a custom callable. Custom callables are used:
     *
     * -for binding/unbinding arguments (see bind and unbind);
     *
     * -for representing methods of built-in Variant types (see create);
     *
     * -for representing global, lambda, and RPC functions in GDScript;
     *
     * -for other purposes in the core, GDExtension, and C#.
     * */
    fun isCustom(): Boolean

    /**
     * Returns true if this Callable has no target to call the method on. Equivalent to callable == Callable().
     *
     * Note: This is not the same as not is_valid() and using not is_null() will not guarantee that this callable can be called.
     * Use is_valid instead.*/
    fun isNull(): Boolean

    /**
     * Returns true if this Callable is a standard callable.
     * This method is the opposite of is_custom. Returns false if this callable is a lambda function.
     * */
    fun isStandard(): Boolean

    /**
     * Returns true if the callable's object exists and has a valid method name assigned, or is a custom callable.
     */
    fun isValid(): Boolean

    /**
     * Perform an RPC (Remote Procedure Call) on all connected peers.
     * This is used for multiplayer and is normally not available, unless the function being called has been marked as RPC (using @GDScript.@rpc or Node.rpc_config).
     * Calling this method on unsupported functions will result in an error. See Node.rpc.
     * */
    fun rpc(vararg args: Any?)

    /**
     * Perform an RPC (Remote Procedure Call) on a specific peer ID (see multiplayer documentation for reference).
     * This is used for multiplayer and is normally not available unless the function being called has been marked as RPC (using @GDScript.@rpc or Node.rpc_config).
     * Calling this method on unsupported functions will result in an error. See Node.rpc_id.
     * */
    fun rpcId(peerId: Long, vararg args: Any?)

    /**
     * Returns a copy of this Callable with a number of arguments unbound.
     * In other words, when the new callable is called the last few arguments supplied by the user are ignored, according to argcount.
     * The remaining arguments are passed to the callable.
     * This allows to use the original callable in a context that attempts to pass more arguments than this callable can handle, e.g. a signal with a fixed number of arguments.
     * See also [bindUnsafe].
     *
     * Note: When this method is chained with other similar methods, the order in which the argument list is modified is read from right to left.
     * */
    fun unbind(argCount: Int): VariantCallable

    fun toNativeCallable(): VariantCallable

    @Suppress("FunctionName")
    object Bridge {
        external fun engine_call_constructor(): VoidPtr
        external fun engine_call_constructor_object_string_name(
            objectPtr: VoidPtr,
            methodNamePtr: VoidPtr
        ): VoidPtr
        external fun engine_call_constructor_lambda_callable(
            container: LambdaContainer<*>,
            variantTypeOrdinal: Int,
            hashCode: Int,
        ): VoidPtr

        external fun engine_call_constructor_cancellable(
            container: LambdaContainer<*>,
            variantTypeOrdinal: Int,
            hashCode: Int,
        )

        external fun engine_call_copy_constructor(): VoidPtr

        external fun engine_call_bind(handle: VoidPtr)
        external fun engine_call_call(handle: VoidPtr)
        external fun engine_call_call_deferred(handle: VoidPtr)
        external fun engine_call_get_bound_arguments(handle: VoidPtr)
        external fun engine_call_get_bound_arguments_count(handle: VoidPtr)
        external fun engine_call_get_method(handle: VoidPtr)
        external fun engine_call_get_object(handle: VoidPtr)
        external fun engine_call_get_object_id(handle: VoidPtr)
        external fun engine_call_hash(handle: VoidPtr)
        external fun engine_call_is_custom(handle: VoidPtr)
        external fun engine_call_is_null(handle: VoidPtr)
        external fun engine_call_is_standard(handle: VoidPtr)
        external fun engine_call_is_valid(handle: VoidPtr)
        external fun engine_call_rpc(handle: VoidPtr)
        external fun engine_call_rpc_id(handle: VoidPtr)
        external fun engine_call_unbind(handle: VoidPtr)
    }
}

fun unsafeCallable(target: GodotObject, methodName: StringName) = MethodCallable(target, methodName)
