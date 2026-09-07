package godot.annotation

/**
 * Starts an Inspector category at this property.
 *
 * @param name The category label shown in the Inspector.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Export
annotation class Category(val name: String)
