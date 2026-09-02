package godot.codegen.generation.task

import java.io.File


class ApiTask(
    coreDir: File?,
    apiDir: File
) : GenerationTask<Unit>() {

    val coreFiles = subTask<FileTask, _> { output ->
        coreDir?.let(output::writeTo)
    }

    val apiFiles = subTask<FileTask, _> { output ->
        output.writeTo(apiDir)
    }

    val registrationFiles = subTask<RegistrationTask, _> { output ->
        output.writeTo(apiDir)
    }

    val files
        get() = coreFiles + apiFiles

    override fun executeSingle() = Unit
}
