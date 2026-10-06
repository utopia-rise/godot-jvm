package godot.internal.memory

import godot.common.constants.Constraints

internal class Locals(
    @JvmField
    val thread: Thread
) {
    @JvmField
    val valueStack: ValueBuffer.Stack = ValueBuffer.Stack()

    @JvmField
    val transfer: VariantBuffer.Transfer = VariantBuffer.Transfer()

    @JvmField
    val inbox: LongStringQueue.Inbox = LongStringQueue.Inbox()

    @JvmField
    val paramsArray: Array<Any?> = arrayOfNulls(Constraints.MAX_ARGUMENT_COUNT)

    @JvmField
    val initConfiguration: InitConfiguration = InitConfiguration()
}
