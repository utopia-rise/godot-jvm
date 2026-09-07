package godot.gradle

import godot.gradle.ext.environmentVariable
import godot.gradle.ext.executableFileOrNull
import godot.gradle.ext.existingDirectoryOrNull
import godot.gradle.ext.existingFileOrNull
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import java.io.File
import javax.inject.Inject

open class GodotAndroidExtension @Inject constructor(objects: ObjectFactory) {
    val d8ToolPath: Property<String> = objects.property(String::class.java)
    val compileSdkDirectory: Property<String> = objects.property(String::class.java)
    val minApiLevel: Property<Int> = objects.property(Int::class.java)

    internal fun configureDefaults() {
        val androidSdkRoot = environmentVariable("ANDROID_SDK_ROOT")?.let(::File)?.existingDirectoryOrNull()
        val d8Tool = androidSdkRoot
            ?.resolve("build-tools")
            ?.takeIf(File::isDirectory)
            ?.listFiles()
            ?.filter(File::isDirectory)
            ?.maxByOrNull(File::getName)
            ?.resolve("d8")
            ?.executableFileOrNull()
        val compileSdk = androidSdkRoot
            ?.resolve("platforms")
            ?.takeIf(File::isDirectory)
            ?.listFiles()
            ?.filter(File::isDirectory)
            ?.filter { it.resolve("android.jar").existingFileOrNull() != null }
            ?.maxByOrNull(File::getName)

        d8Tool?.absolutePath?.let(d8ToolPath::convention)
        compileSdk?.absolutePath?.let(compileSdkDirectory::convention)
        minApiLevel.convention(21)
    }
}
