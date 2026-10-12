package godot.annotation.processor.classgraph

import godot.annotation.processor.classgraph.mapper.RegistrationMapper
import godot.registration.model.types.ScriptClass
import io.github.classgraph.ClassGraph
import io.github.classgraph.ScanResult
import java.io.File

object ClassGraphProcessor {
    fun process(runtimeClassPathFiles: Set<File>, settings: ProcessorSettings): List<ScriptClass> {
        return scan(runtimeClassPathFiles).use { scanResult ->
            mapScriptClasses(scanResult, settings)
        }
    }

    private fun scan(runtimeClassPathFiles: Set<File>): ScanResult {
        return ClassGraph()
            .overrideClasspath(runtimeClassPathFiles)
            .enableClassInfo()
            .enableAnnotationInfo()
            .enableFieldInfo()
            .enableMethodInfo()
            .ignoreFieldVisibility()
            .ignoreMethodVisibility()
            .scan()
    }

    private fun mapScriptClasses(
        scanResult: ScanResult,
        settings: ProcessorSettings,
    ): List<ScriptClass> {
        require(settings.userCodeClassPathRoots.isNotEmpty()) {
            "No user code classpath roots were provided for ClassGraph symbol processing. Ensure compilation ran before classGraph tasks and check that the build directory contains compiled user classes."
        }

        return RegistrationMapper(scanResult, settings).map()
    }
}
