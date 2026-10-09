package godot.annotation

/**
 * Mark a registered property as stored with its scene or resource, without showing it in the inspector.
 *
 * In inferred registration mode, this also registers the property.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Visible
annotation class Storage
