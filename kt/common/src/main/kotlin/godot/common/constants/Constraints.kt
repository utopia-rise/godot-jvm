package godot.common.constants

// when changed; also update constraints.h!
// Since Godot 4, an unlimited amount of parameters is supported. Limits should be increased when appropriate.
object Constraints {
    /**
     * The ceiling on how many arguments cross in either direction. A call and a signal share it because a signal is
     * delivered through a Callable of the same arity, so the two could never usefully differ.
     */
    const val MAX_ARGUMENT_COUNT = 16

    fun checkArgumentCount(argumentCount: Int) {
        require(argumentCount <= MAX_ARGUMENT_COUNT) {
            "A call cannot take more than $MAX_ARGUMENT_COUNT arguments, but got $argumentCount."
        }
    }
}
