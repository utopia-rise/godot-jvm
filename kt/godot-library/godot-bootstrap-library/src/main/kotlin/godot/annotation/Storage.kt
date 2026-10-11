package godot.annotation

/**
 * Mark a property as stored with its scene or resource, without showing it in the inspector. Carries [Visible],
 * so the property is also registered.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Visible
annotation class Storage
