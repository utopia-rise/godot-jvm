package godot.codegen.models.enriched

import com.squareup.kotlinpoet.ClassName
import godot.codegen.exceptions.TooManyMethodArgument
import godot.codegen.models.Method
import godot.codegen.models.traits.CallableGeneratorTrait
import godot.codegen.models.traits.DocumentedGenerationTrait
import godot.codegen.models.traits.GenerationType
import godot.codegen.workarounds.sanitizeApiType
import godot.common.constants.Constraints
import godot.common.extensions.convertToCamelCase

class EnrichedMethod(private val model: Method, override: Boolean = false) : CallableGeneratorTrait, DocumentedGenerationTrait {
    enum class Modifier {
        DEFAULT,
        STATIC,
        VIRTUAL,
        ABSTRACT,
        OVERRIDE
    }

    override var type = GenerationType(model.returnValue?.type?.sanitizeApiType() ?: "void")
    override val genericParameters = emptyList<ClassName>()
    override val meta: String? = model.returnValue?.meta

    val name = model.name.convertToCamelCase().let {
        if (model.isVirtual && !it.startsWith("_")) {
            "_$it"
        } else {
            it
        }
    }
    override val arguments = model.arguments?.toEnriched() ?: listOf()
    override val isVararg = model.isVararg
    override var description = model.description

    val hash = model.hash
    private val modifier = run {
        if (override) {
            Modifier.OVERRIDE
        } else if (model.isVirtual) {
            if (model.isRequired) {
                Modifier.ABSTRACT
            } else {
                Modifier.VIRTUAL
            }
        } else if (model.isStatic) {
            Modifier.STATIC
        } else {
            Modifier.DEFAULT
        }
    }
    val isVirtual: Boolean
        get() = modifier == Modifier.VIRTUAL || modifier == Modifier.ABSTRACT
    val isAbstract: Boolean
        get() = modifier == Modifier.ABSTRACT
    val isStatic: Boolean
        get() = modifier == Modifier.STATIC
    val isOverride: Boolean
        get() = modifier == Modifier.OVERRIDE

    val originalName = model.name

    val isJvmCompatible: Boolean
        get() {
            if (type.isNativeType()) {
                return false
            }
            for (argument in arguments) {
                if (argument.type.isNativeType()) {
                    return false
                }
            }
            return true
        }

    init {
        if (arguments.size > Constraints.MAX_FUNCTION_ARG_COUNT) {
            throw TooManyMethodArgument(model)
        }
    }

    fun override(): EnrichedMethod {
        return EnrichedMethod(model, true)
    }
}

fun List<Method>.toEnriched() = map { EnrichedMethod(it) }
