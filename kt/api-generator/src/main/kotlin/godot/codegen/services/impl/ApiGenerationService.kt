package godot.codegen.services.impl

import godot.codegen.generation.GenerationContext
import godot.codegen.generation.rule.AbstractClassDummyRule
import godot.codegen.generation.rule.ApiRule
import godot.codegen.generation.rule.BindingRule
import godot.codegen.generation.rule.BitfieldExtensionRule
import godot.codegen.generation.rule.ConstantRule
import godot.codegen.generation.rule.CoreRule
import godot.codegen.generation.rule.DocumentationRule
import godot.codegen.generation.rule.EnrichedClassRule
import godot.codegen.generation.rule.EnrichedCoreRule
import godot.codegen.generation.rule.EnumRule
import godot.codegen.generation.rule.FileRule
import godot.codegen.generation.rule.HeaderCommentRule
import godot.codegen.generation.rule.ImportRule
import godot.codegen.generation.rule.LocalCopyHelperRule
import godot.codegen.generation.rule.MemberRule
import godot.codegen.generation.rule.MethodNameRule
import godot.codegen.generation.rule.MethodRule
import godot.codegen.generation.rule.ObjectRule
import godot.codegen.generation.rule.OverLoadRule
import godot.codegen.generation.rule.PropertyRule
import godot.codegen.generation.rule.RegistrationRule
import godot.codegen.generation.rule.SignalRule
import godot.codegen.generation.rule.StaticRule
import godot.codegen.generation.rule.StringOnlyRule
import godot.codegen.generation.rule.UseConnectFlagRule
import godot.codegen.generation.rule.WarningRule
import godot.codegen.generation.rule.compile
import godot.codegen.generation.task.ApiTask
import godot.codegen.generation.task.EnrichedClassTask
import godot.codegen.generation.task.FileTask
import godot.codegen.models.ApiDescription
import godot.codegen.services.IApiGenerationService
import java.io.File

class ApiGenerationService(
    val api: ApiDescription,
) : IApiGenerationService {


    override fun generateApi(coreDir: File, apiDir: File) {
        generateApi(coreDir, apiDir, includeCore = true)
    }

    fun generateApiOnly(apiDir: File) {
        generateApi(null, apiDir, includeCore = false)
    }

    private fun generateApi(coreDir: File?, apiDir: File, includeCore: Boolean) {
        val context = GenerationContext(api)

        ApiTask(coreDir, apiDir).compile(context) {
            rule(::UseConnectFlagRule)
            rule(::EnrichedCoreRule)
            rule(::EnrichedClassRule)
            if (includeCore) {
                rule(::CoreRule)
            }
            rule(::ApiRule)
            rule(::DocumentationRule)
            subRules(ApiTask::files) {
                rule(::FileRule)
                subRules(FileTask::classes) {
                    rule(::ObjectRule)
                    rule(::MemberRule)
                    subRule(EnrichedClassTask::enums, ::EnumRule)
                    subRule(EnrichedClassTask::enrichedMethods, ::MethodRule)
                    subRule(EnrichedClassTask::enrichedProperties, ::PropertyRule)
                    subRule(EnrichedClassTask::signals, ::SignalRule)
                    subRule(EnrichedClassTask::constants, ::ConstantRule)
                    subRule(EnrichedClassTask::enrichedStaticMethods, ::MethodRule)
                    rule(::StringOnlyRule)
                    subRule(EnrichedClassTask::enrichedMethods, ::OverLoadRule)
                    subRule(EnrichedClassTask::enrichedStaticMethods, ::OverLoadRule)
                    rule(::BindingRule)
                    rule(::MethodNameRule)
                    rule(::LocalCopyHelperRule)
                }
                subRule(FileTask::abstractDummyClasses, ::AbstractClassDummyRule)
                subRule(FileTask::enums, ::EnumRule)
                rule(::StaticRule)
                rule(::BitfieldExtensionRule)
                rule(::HeaderCommentRule)
                rule(::WarningRule)
                rule(::ImportRule)
            }
            rule(::RegistrationRule)
        }
    }
}
