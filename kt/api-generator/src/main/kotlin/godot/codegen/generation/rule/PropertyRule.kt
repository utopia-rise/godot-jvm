package godot.codegen.generation.rule

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.UNIT
import godot.codegen.constants.Annotations
import godot.codegen.constants.TypeIdentifier
import godot.codegen.generation.GenerationContext
import godot.codegen.generation.task.EnrichedClassTask
import godot.codegen.generation.task.EnrichedConstantTask
import godot.codegen.generation.task.EnrichedPropertyTask
import godot.codegen.models.enriched.EnrichedClass
import godot.codegen.models.enriched.EnrichedProperty
import godot.codegen.models.traits.addKdoc

class PropertyRule : GodotApiRule<EnrichedPropertyTask>() {
    override fun apply(task: EnrichedPropertyTask, context: GenerationContext) = configure(task.builder) {
        val property = task.property

        if (!property.hasGetter && !property.hasSetter) return@configure

        if (property.hasGetter) {
            val methodName = property.getterName

            getter(
                FunSpec.getterBuilder()
                    .addStatement(
                        if (property.isIndexed) {
                            val indexArgument = property.getterMethod!!.arguments[0]
                            if (indexArgument.type.isEnum() || indexArgument.type.isBitField()) {
                                val argumentValue = context.generateEnumDefaultValue(
                                    indexArgument.type,
                                    property.index!!.toLong()
                                )
                                "return $methodName($argumentValue)"
                            } else {
                                "return $methodName(${property.index})"
                            }

                        } else {
                            "return $methodName()"
                        }
                    )
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("\"${property.name}Property\"")
                            .build()
                    )
                    .addModifiers(KModifier.INLINE)
                    .build()
            )
        } else {
            getter(
                FunSpec.getterBuilder()
                    .addStatement(
                        "%L %T(%S)",
                        "throw",
                        UninitializedPropertyAccessException::class,
                        "Cannot access property ${property.name}: has no getter"
                    )
                    .build()
            )
        }

        val getterType = property
            .getterMethod
            ?.getCastedType()

        val argumentIndex = if (property.isIndexed) 1 else 0
        val setterType = property
            .setterMethod
            ?.arguments
            ?.get(argumentIndex)
            ?.getCastedType()

        val getterAndSetterAreCompatible = getterType == setterType


        // We don't generate the setter if its type doesn't match the getter.
        if (property.hasSetter && getterAndSetterAreCompatible) {
            val methodName = property.setterName!!

            mutable().setter(
                FunSpec.setterBuilder()
                    .addParameter("value", property.getCastedType())
                    .addStatement(
                        if (property.isIndexed) {
                            val indexArgument = property.setterMethod!!.arguments[0]
                            if (indexArgument.type.isEnum() || indexArgument.type.isBitField()) {
                                val argumentValue = context.generateEnumDefaultValue(
                                    indexArgument.type,
                                    property.index!!.toLong()
                                )
                                "$methodName($argumentValue, value)"
                            } else {
                                "$methodName(${property.index}, value)"
                            }

                        } else {
                            "$methodName(value)"
                        }

                    )
                    .addModifiers(KModifier.INLINE)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("\"${property.name}Property\"")
                            .build()
                    )
                    .build()
            )
        }
        addKdoc(property)
    }
}

class LocalCopyHelperRule : GodotApiRule<EnrichedClassTask>() {
    override fun apply(task: EnrichedClassTask, context: GenerationContext) = with(task.builder) {
        val clazz = task.clazz
        for (propertyTask in task.enrichedProperties) {
            val property = propertyTask.property
            if (!property.hasSetter || !property.type.isLocalCopyCoreTypes()) continue

            propertyTask.builder.addAnnotation(
                AnnotationSpec.builder(Annotations.CORE_TYPE_LOCAL_COPY).build()
            )
            propertyTask.builder.addKdoc(
                """|
                   |
                   |**Warning:**
                   |Be careful when trying to modify a local [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this getter.
                   |Mutating it alone won't have any effect on the actual property, it has to be reassigned again afterward.
                   |""".trimMargin()
            )
            addFunction(getMutateHelper(clazz, property))

            if (!property.type.isLocalIndexedCopyCoreTypes()) continue

            val className = TypeIdentifier.localCopyCoreTypesMap[property.type.identifier]!!
            addFunction(getMutateEachHelper(property, className))
        }
    }

    private fun getMutateHelper(clazz: EnrichedClass, property: EnrichedProperty): FunSpec {
        val parameterTypeName = property.getCastedType()
        val parameterName = property.name

        val propertyFunSpec = FunSpec.builder("${parameterName}Mutate").addModifiers(KModifier.FINAL)

        return propertyFunSpec
            .addParameter(
                ParameterSpec.builder(
                    "block",
                    LambdaTypeName.get(
                        receiver = parameterTypeName,
                        returnType = UNIT
                    )
                ).build()
            )
            .addAnnotation(AnnotationSpec.builder(Annotations.CORE_TYPE_HELPER).build())
            .returns(parameterTypeName)
            .addStatement(
                """return·$parameterName.apply·{
                |   block(this)
                |   $parameterName·=·this
                |}""".trimMargin()
            ).apply {
                val kDoc = buildString {
                    appendLine(
                        """This is a helper function for [$parameterName] to make dealing with local copies easier.
                        |Allow to directly modify the local copy of the property and assign it back to the Object.
                        |
                        |Prefer that over writing:
                        |``````
                        |val myCoreType = ${clazz.identifier.lowercase()}.${property.name}
                        |//Your changes
                        |${clazz.identifier.lowercase()}.${property.name} = myCoreType
                        |``````
                        |""".trimMargin()
                    )


                    val propertyKdoc = property.description
                    if (propertyKdoc != null && propertyKdoc.isNotBlank()) {
                        appendLine(propertyKdoc)
                        appendLine()
                    }
                }
                addKdoc(kDoc)
            }.build()
    }

    private fun getMutateEachHelper(property: EnrichedProperty, elementType: ClassName): FunSpec {
        val parameterTypeName = property.getCastedType()
        val parameterName = property.name

        val propertyFunSpec = FunSpec.builder("${parameterName}MutateEach").addModifiers(KModifier.FINAL)

        val lambdaType = ParameterSpec.builder(
            "block",
            LambdaTypeName.get(
                parameters = listOf(
                    ParameterSpec.builder("index", INT).build(),
                    ParameterSpec.builder("value", elementType).build()
                ),
                returnType = UNIT
            )
        ).build()

        return propertyFunSpec
            .addParameter(lambdaType)
            .addAnnotation(AnnotationSpec.builder(Annotations.CORE_TYPE_HELPER).build())
            .returns(parameterTypeName)
            .addStatement(
                """return·$parameterName.apply·{
                |   this.forEachIndexed {·index,·value·->
                |       block(index,·value)
                |       this[index]·=·value
                |   }
                |   $parameterName·=·this
                |}""".trimMargin()
            ).apply {
                val kDoc = buildString {
                    appendLine(
                        """This is a helper function for [$parameterName] to make dealing with local copies easier.
                        |Allow to directly modify each element of the local copy of the property and assign it back to the Object.
                        |""".trimMargin()
                    )

                    val propertyKdoc = property.description
                    if (!propertyKdoc.isNullOrBlank()) {
                        appendLine(propertyKdoc)
                        appendLine()
                    }
                }
                addKdoc(kDoc)
            }.build()
    }
}

class ConstantRule : GodotApiRule<EnrichedConstantTask>() {
    override fun apply(task: EnrichedConstantTask, context: GenerationContext) = configure(task.builder) {
        val constant = task.constant
        addModifiers(KModifier.CONST, KModifier.FINAL)
        initializer("%L", constant.value)
        addKdoc(constant)
        build()
    }
}

