package godot.codegen.generation.rule

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.UNIT
import godot.codegen.constants.API
import godot.codegen.constants.API.getMethodStringName
import godot.codegen.constants.Annotations
import godot.codegen.constants.Internal
import godot.codegen.generation.GenerationContext
import godot.codegen.generation.task.AbstractClassDummyTask
import godot.codegen.generation.task.EnrichedClassTask
import godot.codegen.generation.task.EnrichedConstantTask
import godot.codegen.generation.task.EnrichedEnumTask
import godot.codegen.generation.task.EnrichedMethodTask
import godot.codegen.generation.task.EnrichedPropertyTask
import godot.codegen.generation.task.SignalTask
import godot.codegen.models.enriched.EnrichedClass
import godot.codegen.models.enriched.EnrichedMethod
import godot.codegen.models.traits.addKdoc


class MemberRule : GodotApiRule<EnrichedClassTask>() {
    override fun apply(task: EnrichedClassTask, context: GenerationContext) = configure(task.builder) {
        val clazz = task.clazz

        for (constant in clazz.constants) {
            task.constants.add(EnrichedConstantTask(constant))
        }

        for (signal in clazz.signals) {
            task.signals.add(SignalTask(signal))
        }

        for (method in clazz.methods) {
            if (!canGenerateMethod(method)) continue

            if (method.isStatic) {
                task.enrichedStaticMethods.add(EnrichedMethodTask(method, clazz))
            } else {
                task.enrichedMethods.add(EnrichedMethodTask(method, clazz))
            }
        }

        for (property in clazz.properties) {
            if (property.getterMethod == null && property.setterMethod == null) {
                continue
            }
            if (property.hasGetter && property.hasSetter && !property.hasCompatibleSetter) {
                println(
                    "Warning: property ${clazz.identifier}.${property.name} is generated read-only: its setter " +
                        "${property.setterName} doesn't take the type its getter ${property.getterName} returns."
                )
            }
            task.enrichedProperties.add(EnrichedPropertyTask(property))
        }

        for (enum in clazz.enums) {
            task.enums.add(EnrichedEnumTask(enum))
        }

        val baseClass = task.clazz.parent?.className ?: API.ktObject
        superclass(baseClass)

        if (task.clazz.isSingleton) {
            generateSingletonConstructor(context)
        } else {
            if (clazz.isAbstract) {
                addModifiers(KModifier.ABSTRACT)
            } else if (!clazz.isInstantiable) {
                primaryConstructor(
                    FunSpec.constructorBuilder()
                        .addModifiers(KModifier.INTERNAL)
                        .build()
                ).build()
                addModifiers(KModifier.OPEN)
            } else {
                addModifiers(KModifier.OPEN)
            }

            generateClassConstructor(context)
        }

        addKdoc(clazz)
        addAnnotation(
            AnnotationSpec.builder(Annotations.GODOT_BASE_TYPE).build()
        )

        val parent = task.clazz.parent ?: return@configure
        for (method in parent.methods.filter { it.isAbstract }) {
            if (!canGenerateMethod(method)) continue
            val overrideMethod = method.override()
            task.enrichedMethods.add(EnrichedMethodTask(overrideMethod, clazz))
        }
    }

    private fun canGenerateMethod(method: EnrichedMethod): Boolean {
        return method.isJvmCompatible
    }

    private fun TypeSpec.Builder.generateClassConstructor(
        context: GenerationContext
    ): TypeSpec.Builder {

        addFunction(
            FunSpec.builder("new")
                .addModifiers(KModifier.OVERRIDE)
                .addParameter("scriptPtr", Internal.voidPtr)
                .returns(Unit::class)
                .addStatement(
                    "createNativeObject(${context.getNextEngineClassIndex()}, scriptPtr)"
                )
                .build()
        )
        return this
    }

    private fun TypeSpec.Builder.generateSingletonConstructor(context: GenerationContext): TypeSpec.Builder {
        addFunction(
            FunSpec.builder("new")
                .addModifiers(KModifier.OVERRIDE)
                .addParameter("scriptPtr", Internal.voidPtr)
                .returns(Unit::class)
                .addStatement(
                    "getSingleton(${context.getNextSingletonIndex()})"
                )
                .build()
        )
        return this
    }

}

class AbstractClassDummyRule : GodotApiRule<AbstractClassDummyTask>() {
    override fun apply(task: AbstractClassDummyTask, context: GenerationContext) = configure(task.builder) {
        val clazz = task.clazz
        addModifiers(KModifier.INTERNAL)
        superclass(clazz.className)

        clazz.methods
            .filter { it.isAbstract }
            .filter { canGenerateMethod(it) }
            .forEach { method ->
                addFunction(method.toDummyOverride(clazz))
            }
    }

    private fun canGenerateMethod(method: EnrichedMethod): Boolean {
        return method.isJvmCompatible
    }

    private fun EnrichedMethod.toDummyOverride(clazz: EnrichedClass): FunSpec {
        val builder = FunSpec.builder(name)
            .addModifiers(KModifier.OVERRIDE)

        val returnType = getCastedType()
        if (returnType != UNIT) {
            builder.returns(returnType)
        }

        arguments.forEach { argument ->
            builder.addParameter(argument.name, argument.getCastedType())
        }

        if (isVararg) {
            builder.addParameter("args", ANY.copy(nullable = true), KModifier.VARARG)
        }

        builder.addStatement(
            "%L·%T(%S)",
            "throw",
            NotImplementedError::class,
            "${clazz.identifier}::${name} is only implemented by non-JVM code."
        )

        return builder.build()
    }
}

class BindingRule : GodotApiRule<EnrichedClassTask>() {
    override fun apply(task: EnrichedClassTask, context: GenerationContext) = configure(task.builder) {
        val clazz = task.clazz
        clazz.methods
            .filter { !it.isVirtual }
            .onEach {
                task.bindings.addProperty(
                    PropertySpec
                        .builder("${it.name}Ptr", Internal.voidPtr)
                        .addModifiers(KModifier.INTERNAL)
                        .initializer(
                            "%T.getMethodBindPtr(%S,·%S,·%L)",
                            Internal.typeManager,
                            clazz.identifier,
                            it.originalName,
                            it.hash
                        )
                        .build()
                )
            }
    }
}


class MethodNameRule : GodotApiRule<EnrichedClassTask>() {
    override fun apply(classTask: EnrichedClassTask, context: GenerationContext) = configure(classTask.builder) {
        val clazz = classTask.clazz
        clazz.methods
            .filter { !it.isVirtual }
            .onEach {
                if (it.isVararg || !it.isJvmCompatible) return@onEach

                val argCount = it.arguments.size
                val methodStringClassName = getMethodStringName(argCount).parameterizedBy(
                    listOf(classTask.clazz.className, it.getCastedType()) + it.arguments.map { it.getCastedType() }
                )

                classTask.companion.addProperty(
                    PropertySpec
                        .builder("${it.name}Name", methodStringClassName)
                        .initializer(
                            "%T(\"${it.originalName}\")",
                            methodStringClassName
                        )
                        .addAnnotation(JvmField::class)
                        .build()
                )
            }
    }
}
