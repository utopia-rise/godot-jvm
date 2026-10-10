package godot.internal.logging

object GodotPrint {
    fun getExceptionStackTrace(throwable: Throwable): String {
        return throwable.stackTraceToString()
    }

    // To change for StackWalker once Android min api is at least 34.
    fun getCurrentStacktrace(): String = Thread.currentThread().stackTrace
        .asSequence()
        .dropWhile { it.className != GodotPrint::class.java.name }
        .dropWhile { it.className == GodotPrint::class.java.name }
        .filterNot { it.className.startsWith("org.godotengine.godot.") }
        .joinToString("\n")

    external fun print(str: String)
    external fun printRich(str: String)
    external fun printVerbose(str: String)
    external fun printErr(str: String)
    external fun printRaw(str: String)
    external fun pushError(str: String)
    external fun pushWarning(str: String)
}
