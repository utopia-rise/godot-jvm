package godot.codegen.generation.task

import com.squareup.kotlinpoet.FileSpec
import godot.tools.common.constants.godotPackage

class TransferTask(fileName: String) : GenerationTask<FileSpec>() {
    val builder = FileSpec.builder(godotPackage, fileName)

    override fun executeSingle(): FileSpec = builder.build()
}
