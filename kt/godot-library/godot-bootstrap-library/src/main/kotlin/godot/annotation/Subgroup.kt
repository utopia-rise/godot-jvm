package godot.annotation

/**
 * Starts an Inspector subgroup at this property.
 *
 * @param name The subgroup label shown in the Inspector.
 * @param prefix Limits the subgroup to following properties whose names start with it. When omitted, it defaults to [name] with its first letter lowercased. It is converted to Godot's `snake_case` convention.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class Subgroup(
    val name: String,
    val prefix: String = "",
)
