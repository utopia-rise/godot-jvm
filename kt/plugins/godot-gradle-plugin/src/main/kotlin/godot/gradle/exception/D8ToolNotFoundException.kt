package godot.gradle.exception

class D8ToolNotFoundException(reason: String? = null) : IllegalArgumentException(
    buildString {
        append("d8 tool not set or not usable")
        if (!reason.isNullOrBlank()) {
            append(": ")
            append(reason)
        }
        append(". Set ANDROID_SDK_ROOT to a valid Android SDK, or set godot.android.d8ToolPath to the d8 executable.")
        append(" For more information, visit: https://godot-jvm.dev/en/stable/user-guide/exporting/#android")
    }
)
