package godot.codegen.models

import java.security.InvalidParameterException

enum class ApiType {
    CORE,
    EDITOR,
    EXTENSION,
    EDITOR_EXTENSION;

    companion object {
        fun from(string: String) = when (string) {
            "core" -> CORE
            "editor" -> EDITOR
            "extension" -> EXTENSION
            "editor_extension" -> EDITOR_EXTENSION
            else -> throw InvalidParameterException("Cannot match $string to ApiType")
        }
    }
}
