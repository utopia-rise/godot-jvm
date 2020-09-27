package godot.benchmarks

import org.gradle.api.model.ObjectFactory
import java.io.File

class Language(val name: String) {
    var displayName = name
}

enum class Os {
    LINUX,
    WINDOWS,
    MACOS,
}

open class BenchmarksExtension(objects: ObjectFactory, findExecutable: (String) -> File) {
    val benchmarksDir = objects.directoryProperty()
    val languages = objects.domainObjectContainer(Language::class.java, ::Language)
    internal val executables = languages.map { it.name to findExecutable(it.name) }
        .toMap()
}
