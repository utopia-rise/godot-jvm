package godot.annotation

/**
 * Mark a property as exported and thus visible in the inspector. Carries [Storage], so the property is also
 * registered and stored.
 *
 * Only core types and references can be exported.
 */

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Storage
annotation class Export
