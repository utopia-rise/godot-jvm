package godot.gradle

import godot.annotation.processor.classgraph.AnnotationProcessingMode
import godot.registrar.generator.RegisteredNameMode
import godot.registrar.generator.RegistrationFileIndentation
import godot.registrar.generator.RegistrationFileLayoutMode
import org.gradle.api.file.Directory
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import javax.inject.Inject

open class GodotRegistrationExtension @Inject constructor(objects: ObjectFactory) {
    val annotationProcessingMode: Property<AnnotationProcessingMode> = objects.property(AnnotationProcessingMode::class.java)
    val nameMode: Property<RegisteredNameMode> = objects.property(RegisteredNameMode::class.java)
    val incrementalFullBuildThreshold: Property<Int> = objects.property(Int::class.java)
    val disableGdj: Property<Boolean> = objects.property(Boolean::class.java)
    val gdjFilesDirectory: DirectoryProperty = objects.directoryProperty()
    val gdjFilesLayoutMode: Property<RegistrationFileLayoutMode> = objects.property(RegistrationFileLayoutMode::class.java)
    val gdjFilesIndentation: Property<RegistrationFileIndentation> = objects.property(RegistrationFileIndentation::class.java)

    internal fun configureDefaults(defaultGdjFilesDirectory: Provider<Directory>) {
        annotationProcessingMode.convention(AnnotationProcessingMode.Inferred)
        nameMode.convention(RegisteredNameMode.SIMPLE_NAME)
        incrementalFullBuildThreshold.convention(32)
        disableGdj.convention(false)
        gdjFilesDirectory.convention(defaultGdjFilesDirectory)
        gdjFilesLayoutMode.convention(RegistrationFileLayoutMode.FLAT)
        gdjFilesIndentation.convention(RegistrationFileIndentation.SPACE)
    }
}
