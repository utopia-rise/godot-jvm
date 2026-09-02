package godot.annotation

/**
 * Starts an Inspector group at this property.
 *
 * @param name The group label shown in the Inspector.
 * @param prefix Limits the group to following properties whose names start with it. When omitted, it defaults to [name] with its first letter lowercased. It is converted to Godot's `snake_case` convention.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class Group(
    val name: String,
    val prefix: String = "",
)
