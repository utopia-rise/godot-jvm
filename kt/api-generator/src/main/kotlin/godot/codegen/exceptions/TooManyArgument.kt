package godot.codegen.exceptions

import godot.codegen.models.Method
import godot.codegen.models.Signal
import godot.common.constants.Constraints

class TooManyMethodArgument(method: Method) :
    Exception("${method.name} has ${method.arguments!!.size} arguments but the maximum number is ${Constraints.MAX_ARGUMENT_COUNT}")

class TooManySignalArgument(signal: Signal) :
    Exception("${signal.name} has ${signal.arguments!!.size} arguments but the maximum number is ${Constraints.MAX_ARGUMENT_COUNT}")
