package godot.gradle

import godot.tools.common.KOTLIN_VERSION
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import javax.inject.Inject

open class GodotToolchainExtension @Inject constructor(objects: ObjectFactory) {
    val javaVersion: Property<Int> = objects.property(Int::class.java)
    val kotlinVersion: Property<String> = objects.property(String::class.java)
    val scalaVersion: Property<String> = objects.property(String::class.java)

    internal fun configureDefaults() {
        javaVersion.convention(17)
        kotlinVersion.convention(KOTLIN_VERSION)
        scalaVersion.convention("3.6.3")
    }
}
