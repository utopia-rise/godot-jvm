package godot.gradle

import godot.tools.common.constants.FileExtensions
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.api.provider.SetProperty
import javax.inject.Inject

open class GodotExtension @Inject constructor(objects: ObjectFactory) {
    /** Generates bindings from [apiJsonFile] instead of using the published Godot API bindings. */
    val isCustomApiEnabled: Property<Boolean> = objects.property(Boolean::class.java)

    /** Godot extension API JSON used when [isCustomApiEnabled] is enabled. */
    val apiJsonFile: RegularFileProperty = objects.fileProperty()

    /** Marks this Gradle project as a reusable Godot-JVM library. */
    val isLibrary: Property<Boolean> = objects.property(Boolean::class.java)

    /** Directory of the Godot project that contains `project.godot`. */
    val godotProjectDirectory: DirectoryProperty = objects.directoryProperty()

    /** JVM source languages enabled for the project's initial compilation pass. */
    val languages: SetProperty<GodotLanguage> = objects.setProperty(GodotLanguage::class.java)

    /** Enables coroutine support for Godot lifecycle callbacks and signals. */
    val isGodotCoroutinesEnabled: Property<Boolean> = objects.property(Boolean::class.java)

    val toolchain: GodotToolchainExtension = objects.newInstance(GodotToolchainExtension::class.java)
    val registration: GodotRegistrationExtension = objects.newInstance(GodotRegistrationExtension::class.java)
    val android: GodotAndroidExtension = objects.newInstance(GodotAndroidExtension::class.java)
    val graal: GodotGraalExtension = objects.newInstance(GodotGraalExtension::class.java)

    fun toolchain(action: Action<in GodotToolchainExtension>) = action.execute(toolchain)
    fun registration(action: Action<in GodotRegistrationExtension>) = action.execute(registration)
    fun android(action: Action<in GodotAndroidExtension>) = action.execute(android)
    fun graal(action: Action<in GodotGraalExtension>) = action.execute(graal)

    internal fun configureExtensionDefaults(target: Project) {
        godotProjectDirectory.convention(target.layout.projectDirectory)
        isCustomApiEnabled.convention(false)
        apiJsonFile.convention(target.rootProject.layout.projectDirectory.file("api.json"))
        isLibrary.convention(false)
        languages.convention(GodotLanguage.entries.toSet())
        isGodotCoroutinesEnabled.convention(false)

        toolchain.configureDefaults()
        registration.configureDefaults(godotProjectDirectory.dir(FileExtensions.GodotJvm.registrationFile))
        android.configureDefaults()
        graal.configureDefaults()
    }
}
