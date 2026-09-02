package godot.gradle.exception

class AndroidCompileSdkNotFoundException(reason: String? = null) : IllegalArgumentException(
    buildString {
        append("Android compile SDK not set or not usable")
        if (!reason.isNullOrBlank()) {
            append(": ")
            append(reason)
        }
        append(". Set ANDROID_SDK_ROOT to a valid Android SDK, or set godot.androidCompileSdkDirectory to a platform directory that contains android.jar.")
        append(" For more information, visit: https://godot-jvm.dev/en/stable/user-guide/exporting/#android")
    }
)
