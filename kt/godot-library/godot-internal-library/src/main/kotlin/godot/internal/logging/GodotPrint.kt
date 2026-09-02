package godot.internal.logging

import java.util.stream.Collectors.joining

object GodotPrint {
    fun getExceptionStackTrace(throwable: Throwable): String {
        return throwable.stackTraceToString()
    }

    fun getCurrentStacktrace(): String = StackWalker.getInstance().walk { frames ->
        frames
            .dropWhile { it.className == GodotPrint::class.java.name }
            .map { it.toString() }
            .collect(joining("\n"))
    }

    external fun print(str: String)
    external fun printRich(str: String)
    external fun printVerbose(str: String)
    external fun printErr(str: String)
    external fun printRaw(str: String)
    external fun pushError(str: String)
    external fun pushWarning(str: String)
}
