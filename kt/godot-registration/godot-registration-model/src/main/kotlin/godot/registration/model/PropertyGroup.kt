package godot.registration.model

enum class PropertyGroupKind {
    CATEGORY,
    GROUP,
    SUBGROUP,
}

data class PropertyGroup(
    val kind: PropertyGroupKind,
    val name: String,
    val prefix: String,
)
