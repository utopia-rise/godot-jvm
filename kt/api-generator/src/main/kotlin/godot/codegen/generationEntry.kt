package godot.codegen

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import godot.codegen.models.ApiDescription
import godot.codegen.services.IApiGenerationService
import godot.codegen.services.impl.ApiGenerationService
import godot.codegen.services.impl.AwaitGenerationService
import godot.codegen.services.impl.FlowGenerationService
import godot.codegen.services.impl.CallableGenerationService
import godot.codegen.services.impl.ConnectorGenerationService
import godot.codegen.services.impl.SignalGenerationService
import java.io.File

fun generateApiFrom(jsonSource: File, coreDir: File, apiDir: File, extensionDir: File) {
    val apiDescription = ObjectMapper().readValue(jsonSource, object : TypeReference<ApiDescription>() {})
    val generationService: IApiGenerationService = ApiGenerationService(apiDescription)
    generationService.generateApi(coreDir, apiDir)

    SignalGenerationService.generate(coreDir)
    CallableGenerationService.generate(coreDir)
    ConnectorGenerationService.generate(extensionDir)
}

fun generateCoroutine(outputDir: File) {
    AwaitGenerationService.generate(outputDir)
    FlowGenerationService.generate(outputDir)
}
