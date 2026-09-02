package godot.gradle.exception

class GraalNativeImageToolNotFountException(reason: String? = null) : IllegalArgumentException(
    buildString {
        append("native-image tool not set or not usable")
        if (!reason.isNullOrBlank()) {
            append(": ")
            append(reason)
        }
        append(". Set GRAALVM_HOME to a GraalVM installation, or set godot.graalVmHomeDirectory.")
        append(" For more information, visit: https://godot-jvm.dev/en/stable/user-guide/advanced/graal-vm-native-image")
    }
)
