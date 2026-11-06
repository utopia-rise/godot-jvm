package godot.internal.logging

private const val ESCAPE = '\u001B'
private const val RESET = "$ESCAPE[0m"

/**
 * The amount of codes required in order to jump from a foreground code to a background code. Equal to 10. For example,
 * the foreground code for blue is "[33m", its respective background code is "[43m"
 */
private const val BG_JUMP = 10

private enum class PrintColor(baseCode: Int) {
    RED(31),
    GREEN(32),
    YELLOW(33);

    /** ANSI modifier string to apply the color to the text itself */
    val foreground: String = "$ESCAPE[${baseCode}m"

    /** ANSI modifier string to apply the color the text's background */
    val background: String = "$ESCAPE[${baseCode + BG_JUMP}m"
}

object GodotLogging {
    fun info(message: String) = try {
        GodotPrint.print("Godot-JVM: $message")
    } catch (_: UnsatisfiedLinkError) {
        JVMLogging.info(message)
    }

    fun warning(message: String) = try {
        GodotPrint.pushWarning("Godot-JVM: $message")
    } catch (_: UnsatisfiedLinkError) {
        JVMLogging.warning(message)
    }

    fun error(message: String) = try {
        GodotPrint.printErr("Godot-JVM: $message")
    } catch (_: UnsatisfiedLinkError) {
        JVMLogging.error(message)
    }
}

object JVMLogging {
    fun info(message: String) = println("Godot-JVM: $message")
    fun warning(message: String) = println("${PrintColor.YELLOW.foreground}$message$RESET")
    fun error(message: String) = System.err.println("Godot-JVM:  $message")
}
