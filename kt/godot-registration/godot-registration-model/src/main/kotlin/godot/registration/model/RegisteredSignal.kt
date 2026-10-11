package godot.registration.model

import godot.registration.model.types.Type

data class RegisteredSignal(
    val name: String,
    val type: Type,
    val parameterTypes: List<Type>,
    val parameterNames: List<String>,
)
