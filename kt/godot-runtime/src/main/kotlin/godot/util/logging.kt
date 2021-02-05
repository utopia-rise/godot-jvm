package godot.util

private const val ESCAPE = '\u001B'
private const val RESET = "$ESCAPE[0m"

/**
 * The amount of codes required in order to jump from a foreground code to a background code. Equal to 10. For example,
 * the foreground code for blue is "[33m", its respective background code is "[43m"
 */
private const val BG_JUMP = 10

private enum class Color(baseCode: Int) {
    RED(31),
    GREEN(32),
    YELLOW(33);

    /** ANSI modifier string to apply the color to the text itself */
    val foreground: String = "$ESCAPE[${baseCode}m"

    /** ANSI modifier string to apply the color the text's background */
    val background: String = "$ESCAPE[${baseCode + BG_JUMP}m"
}

internal fun info(message: String) = println("Godot-JVM: $message")
internal fun warning(message: String) = printWithTextColor("Godot-JVM: WARNING: $message", Color.YELLOW)
internal fun err(message: String) = System.err.println("Godot-JVM: ERROR: $message")

private fun printWithTextColor(message: String, color: Color) = println("${color.foreground}$message$RESET")
