package godot.codegen.services

import java.io.File

interface IFlowGenerationService {
    fun generate(output: File)
}
