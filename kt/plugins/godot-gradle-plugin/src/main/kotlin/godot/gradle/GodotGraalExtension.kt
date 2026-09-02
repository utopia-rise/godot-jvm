package godot.gradle

import godot.gradle.ext.environmentVariable
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import javax.inject.Inject

open class GodotGraalExtension @Inject constructor(objects: ObjectFactory) {
    val homeDirectory: Property<String> = objects.property(String::class.java)
    val windowsDeveloperVcVarsPath: Property<String> = objects.property(String::class.java)
    val additionalJniConfigurationFiles: Property<Array<String>> = objects.property(Array<String>::class.java)
    val additionalReflectionConfigurationFiles: Property<Array<String>> = objects.property(Array<String>::class.java)
    val additionalResourceConfigurationFiles: Property<Array<String>> = objects.property(Array<String>::class.java)
    val verbose: Property<Boolean> = objects.property(Boolean::class.java)

    internal fun configureDefaults() {
        environmentVariable("GRAALVM_HOME")?.let(homeDirectory::convention)
        environmentVariable("VC_VARS_PATH")?.let(windowsDeveloperVcVarsPath::convention)
        additionalJniConfigurationFiles.convention(emptyArray())
        additionalReflectionConfigurationFiles.convention(emptyArray())
        additionalResourceConfigurationFiles.convention(emptyArray())
        verbose.convention(false)
    }
}
