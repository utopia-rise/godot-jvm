package godot.internal.memory

import godot.common.constants.Constraints

internal class Locals(
    @JvmField
    val thread: Thread
) {
    @JvmField
    val valueStack: ValueBuffer.Stack = ValueBuffer.Stack()

    @JvmField
    val paramsArray: Array<Any?> = arrayOfNulls(Constraints.MAX_FUNCTION_ARG_COUNT)

    @JvmField
    val initConfiguration: InitConfiguration = InitConfiguration()
}
