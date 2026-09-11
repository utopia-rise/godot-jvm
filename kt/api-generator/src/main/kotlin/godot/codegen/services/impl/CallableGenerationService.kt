package godot.codegen.services.impl

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.ARRAY
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.buildCodeBlock
import godot.codegen.constants.API
import godot.codegen.constants.Core
import godot.codegen.constants.Generator
import godot.codegen.constants.Utils
import godot.codegen.constants.VariantConverter
import godot.codegen.poet.GenericClassNameInfo
import godot.codegen.services.ICallableGenerationService
import godot.common.constants.Constraints
import godot.tools.common.constants.godotCorePackage
import java.io.File
import kotlin.reflect.KCallable


object CallableGenerationService : ICallableGenerationService {
    private val returnTypeParameter = TypeVariableName("R", ANY.copy(nullable = true))

    private fun kotlinJavaHelperName(baseName: String) = "_${baseName}Java"

    override fun generate(outputDir: File) {
        val callableFileSpec = FileSpec.builder(Core.callable.packageName, Core.callable.simpleName + "s")
        val lambdaFileSpec = FileSpec.builder(Core.callable.packageName, Core.lambdaCallable.simpleName + "s")
        val containerFileSpec = FileSpec.builder(Core.callable.packageName, Core.lambdaContainer.simpleName + "s")
        val methodFileSpec = FileSpec.builder(Core.callable.packageName, Core.methodCallable.simpleName + "s")
        val jvmFunctionFileSpec = FileSpec.builder(godotCorePackage, Core.jvmFunction(0).simpleName.dropLast(1) + "s")

        for (argCount in 0..Constraints.MAX_FUNCTION_ARG_COUNT) {
            callableFileSpec.generateCallables(argCount)
            jvmFunctionFileSpec.generateJvmLambdas(argCount)
            methodFileSpec.generateMethodStringName(argCount)
            methodFileSpec.generateMethodCallables(argCount)
            containerFileSpec.generateLambdaContainer(argCount)
            lambdaFileSpec.generateLambdaCallables(argCount)
        }

        callableFileSpec.buildTo(outputDir)
        jvmFunctionFileSpec.buildTo(outputDir)
        containerFileSpec.buildTo(outputDir)
        lambdaFileSpec.buildTo(outputDir)
        methodFileSpec.buildTo(outputDir)
    }

    fun FileSpec.Builder.generateJvmLambdas(argCount: Int) {
        val jvmFunctionClassName = Core.jvmFunction(argCount)
        val jvmFunctionInfo = GenericClassNameInfo(jvmFunctionClassName, argCount)
        val functionSuperinterface = when (argCount) {
            0 -> ClassName("kotlin", "Function0").parameterizedBy(returnTypeParameter)
            else -> ClassName("kotlin", "Function$argCount").parameterizedBy(jvmFunctionInfo.genericTypes + returnTypeParameter)
        }

        addType(
            TypeSpec
                .interfaceBuilder(jvmFunctionClassName)
                .addSuperinterface(functionSuperinterface)
                .addTypeVariable(returnTypeParameter)
                .addTypeVariables(jvmFunctionInfo.genericTypes)
                .addFunction(
                    FunSpec
                        .builder(Core.invokeMethodName)
                        .addModifiers(KModifier.ABSTRACT)
                        .addModifiers(KModifier.OVERRIDE)
                        .addParameters(jvmFunctionInfo.toParameterSpecList())
                        .returns(returnTypeParameter)
                        .build()
                )
                .build()
        )

        val jvmActionClassName = Core.jvmAction(argCount)
        val jvmActionInfo = GenericClassNameInfo(jvmActionClassName, argCount)
        addType(
            TypeSpec
                .interfaceBuilder(jvmActionClassName)
                .addTypeVariables(jvmActionInfo.genericTypes)
                .addFunction(
                    FunSpec
                        .builder(Core.invokeMethodName)
                        .addModifiers(KModifier.ABSTRACT)
                        .addParameters(jvmActionInfo.toParameterSpecList())
                        .returns(UNIT)
                        .build()
                )
                .build()
        )
    }

    fun FileSpec.Builder.generateCallables(argCount: Int) {
        val callableClassName = Core.callable(argCount)
        val callableInfo = GenericClassNameInfo(callableClassName, argCount)
        val genericParameters = callableInfo.genericTypes

        val callableClassBuilder = TypeSpec
            .interfaceBuilder(callableClassName)
            .addSuperinterface(Core.callable)
            .addTypeVariable(returnTypeParameter)
            .addTypeVariables(genericParameters)
            .addFunction(
                FunSpec
                    .builder(Core.callMethodName)
                    .addParameters(callableInfo.toParameterSpecList())
                    .returns(returnTypeParameter)
                    .addCode(
                        CodeBlock.of(
                            buildString {
                                append("return·callUnsafe(")
                                append(callableInfo.toArgumentsString("pINDEX", "INDEX"))
                                append(") as R")
                            },
                            *genericParameters.toTypedArray()
                        )
                    )
                    .build()
            )
            .addFunction(
                FunSpec.builder(Core.callDeferredMethodName)
                    .addParameters(callableInfo.toParameterSpecList())
                    .addCode(
                        CodeBlock.of(
                            buildString {
                                append("return·callDeferredUnsafe(")
                                append(callableInfo.toArgumentsString("pINDEX", "INDEX"))
                                append(")")
                            }
                        )
                    )
                    .build()
            )
            .addFunction(
                FunSpec.builder(Core.invokeMethodName)
                    .addParameters(callableInfo.toParameterSpecList())
                    .returns(returnTypeParameter)
                    .addCode(
                        CodeBlock.of(
                            buildString {
                                append("return·call(")
                                append(callableInfo.toArgumentsString("pINDEX", "INDEX"))
                                append(')')
                            },
                            *genericParameters.toTypedArray()
                        )
                    )
                    .addModifiers(KModifier.OPERATOR)
                    .build()
            )

        generateBindMethods(argCount) { remaining, parameters ->
            val remainingParameters = remaining.size
            val boundCallableClassName = Core.callable(remainingParameters)
            callableClassBuilder.addFunction(
                FunSpec.builder(Core.bindMethodName)
                    .addModifiers(KModifier.ABSTRACT)
                    .addParameters(
                        parameters.mapIndexed { index: Int, typeVariableName: TypeVariableName ->
                            ParameterSpec.builder("p${index + remainingParameters}", typeVariableName)
                                .build()
                        }
                    )
                    .returns(boundCallableClassName.parameterizedBy(listOf(returnTypeParameter) + remaining))
                    .build()
            )
        }

        addType(callableClassBuilder.build())
    }

    fun FileSpec.Builder.generateMethodCallables(argCount: Int) {
        val callableClassName = Core.callable(argCount)
        val methodCallableClassName = Core.methodCallable(argCount)
        val methodStringClassName = Core.methodStringName(argCount)
        val methodCallableInfo = GenericClassNameInfo(methodCallableClassName, argCount)
        val genericParameters = methodCallableInfo.genericTypes

        val objectType = TypeVariableName("T", API.`object`)

        val methodCallableClassBuilder = TypeSpec
            .classBuilder(methodCallableClassName)
            .superclass(Core.methodCallable)
            .addSuperinterface(callableClassName.parameterizedBy(listOf(returnTypeParameter) + genericParameters))
            .addTypeVariable(returnTypeParameter)
            .addTypeVariables(genericParameters)
            .primaryConstructor(
                FunSpec
                    .constructorBuilder()
                    .addModifiers(KModifier.INTERNAL)
                    .addParameter(
                        ParameterSpec
                            .builder(
                                Generator.targetArgumentName,
                                API.`object`
                            )
                            .build()
                    )
                    .addParameter(
                        ParameterSpec
                            .builder(
                                Generator.methodNameArgumentName,
                                Core.stringName
                            )
                            .build()
                    )
                    .addParameter(
                        ParameterSpec
                            .builder(
                                Generator.boundArgsArgumentName,
                                ARRAY.parameterizedBy(ANY.copy(nullable = true))
                            )
                            .defaultValue("emptyArray()")
                            .build()
                    )
                    .addAnnotation(PublishedApi::class)
                    .build()
            )
            .addSuperclassConstructorParameter(Generator.targetArgumentName)
            .addSuperclassConstructorParameter(Generator.methodNameArgumentName)
            .addSuperclassConstructorParameter(Generator.boundArgsArgumentName)

        generateBindMethods(argCount) { remaining, parameters ->
            val boundMethodCallableClassName = Core.methodCallable(remaining.size)
            methodCallableClassBuilder.addFunction(
                FunSpec.builder(Core.bindMethodName)
                    .addModifiers(KModifier.OVERRIDE)
                    .addParameters(
                        parameters.mapIndexed { index: Int, typeVariableName: TypeVariableName ->
                            ParameterSpec.builder("p${index + remaining.size}", typeVariableName)
                                .build()
                        }
                    )
                    .addCode(
                        buildString {
                            append("return·%T(${Generator.targetArgumentName}, ${Generator.methodNameArgumentName}, arrayOf<Any?>(")

                            for (index in (0..<parameters.size)) {
                                if (index != 0) append(",·")
                                append("p${index + remaining.size}")
                            }

                            append(", *${Generator.boundArgsArgumentName}))")
                        },
                        boundMethodCallableClassName.parameterizedBy(listOf(returnTypeParameter) + remaining),
                    )
                    .build()
            )
        }

        val genericMethodCallable = methodCallableClassName.parameterizedBy(listOf(returnTypeParameter) + genericParameters)
        val companion = TypeSpec
            .companionObjectBuilder()
            .addFunction(
                methodCallableInfo
                    .toFunSpecBuilder(kotlinJavaHelperName(Core.createUnsafeMethodName), prefix = listOf(returnTypeParameter))
                    .addParameter(ParameterSpec.builder("godotObject", API.`object`).build())
                    .addParameter(ParameterSpec.builder("methodName", STRING).build())
                    .returns(genericMethodCallable)
                    .addCode(
                        "return·%T(godotObject,·methodName.%M())",
                        genericMethodCallable,
                        Utils.toGodotName
                    )
                    .addAnnotation(JvmStatic::class)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("%S", Core.createUnsafeMethodName)
                            .build()
                    )
                    .build()
            )
            .addFunction(
                methodCallableInfo
                    .toFunSpecBuilder(kotlinJavaHelperName(Core.createMethodName), prefix = listOf(objectType, returnTypeParameter))
                    .addParameter(ParameterSpec.builder("godotObject", objectType).build())
                    .addParameter(
                        ParameterSpec.builder(
                            "methodName",
                            methodStringClassName.parameterizedBy(listOf(objectType, returnTypeParameter) + genericParameters)
                        ).build()
                    )
                    .returns(genericMethodCallable)
                    .addCode(
                        "return·methodName.toCallable(godotObject)",
                    )
                    .addAnnotation(JvmStatic::class)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("%S", Core.createMethodName)
                            .build()
                    )
                    .build()
            )

        methodCallableClassBuilder.addType(companion.build())
        addType(methodCallableClassBuilder.build())

        val objectGeneric = TypeVariableName("T", API.`object`)
        addFunction(
            FunSpec.builder(Generator.methodCallableFunctionName + argCount)
                .addTypeVariable(objectGeneric)
                .addTypeVariable(returnTypeParameter)
                .addTypeVariables(genericParameters)
                .addParameters(
                    listOf(
                        ParameterSpec
                            .builder(
                                Generator.targetArgumentName,
                                objectGeneric
                            )
                            .build(),
                        ParameterSpec
                            .builder(
                                Generator.callableParameterName,
                                methodCallableInfo.toLambdaTypeName(returnType = returnTypeParameter, receiver = objectGeneric)
                            )
                            .build()
                    )
                )
                .addCode(
                    CodeBlock.of(
                        "return·%T(${Generator.targetArgumentName},·(${Generator.callableParameterName}·as·%T<R>).name.%M())",
                        methodCallableClassName.parameterizedBy(listOf(returnTypeParameter) + genericParameters),
                        KCallable::class.asClassName(),
                        Utils.toGodotName,
                    )
                )
                .addAnnotation(JvmSynthetic::class)
                .build()
        )
    }

    fun FileSpec.Builder.generateMethodStringName(argCount: Int) {
        val methodCallableClassName = Core.methodCallable(argCount)
        val methodStringClassName = Core.methodStringName(argCount)
        val methodCallableInfo = GenericClassNameInfo(methodStringClassName, argCount)
        val genericParameters = methodCallableInfo.genericTypes

        val objectType = TypeVariableName("T", API.`object`)

        val classBuilder = methodCallableInfo.toTypeSpecBuilder(prefix = listOf(objectType, returnTypeParameter))
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .addModifiers(KModifier.PRIVATE)
                    .addParameter("methodName", Core.stringName)
                    .build()
            )
            .addFunction(
                FunSpec.constructorBuilder()
                    .addParameter("methodName", STRING)
                    .callThisConstructor(buildCodeBlock {
                        add("methodName.%M()", Utils.asStringName)
                    })
                    .build()
            )
            .addProperty(
                PropertySpec.builder("methodName", Core.stringName)
                    .initializer("methodName")
                    .addModifiers(KModifier.PUBLIC)
                    .build()
            )
            .addFunction(
                FunSpec.builder(Core.toCallableMethodName)
                    .addModifiers(KModifier.INTERNAL)
                    .addParameter("godotObject", objectType)
                    .addStatement(
                        "return %T(godotObject, methodName)",
                        methodCallableClassName.parameterizedBy(listOf(returnTypeParameter) + genericParameters)
                    )
                    .build()
            )
            .build()
        addType(classBuilder)
    }

    fun FileSpec.Builder.generateLambdaContainer(argCount: Int) {
        val lambdaContainerClassName = Core.lambdaContainer(argCount)
        val containerInfo = GenericClassNameInfo(lambdaContainerClassName, argCount)
        val genericParameters = containerInfo.genericTypes

        val lambdaTypeName = containerInfo.toLambdaTypeName(returnType = returnTypeParameter)

        val lambdaContainerClassBuilder = TypeSpec
            .classBuilder(lambdaContainerClassName)
            .superclass(Core.lambdaContainer.parameterizedBy(returnTypeParameter))
            .addSuperclassConstructorParameter(Generator.returnConverterParameterName)
            .addSuperclassConstructorParameter(Generator.typeConvertersParameterName)
            .addSuperclassConstructorParameter(Generator.functionParameterName)
            .addTypeVariable(returnTypeParameter)
            .addTypeVariables(genericParameters)
            .primaryConstructor(
                FunSpec
                    .constructorBuilder()
                    .addParameter(
                        ParameterSpec
                            .builder(
                                Generator.returnConverterParameterName,
                                VariantConverter.BASE
                            )
                            .build()
                    )
                    .addParameter(
                        ParameterSpec
                            .builder(
                                Generator.typeConvertersParameterName,
                                ARRAY.parameterizedBy(VariantConverter.BASE)
                            )
                            .build()
                    )
                    .addParameter(
                        ParameterSpec
                            .builder(
                                Generator.functionParameterName,
                                lambdaTypeName
                            )
                            .build()
                    )
                    .build()
            )
            .addFunction(
                FunSpec
                    .builder(Core.invokeMethodName + Core.unsafeSuffix)
                    .addModifiers(KModifier.OVERRIDE)
                    .addParameter(
                        ParameterSpec
                            .builder("args", ANY.copy(nullable = true), KModifier.VARARG)
                            .build()
                    )
                    .returns(returnTypeParameter)
                    .addCode(
                        CodeBlock
                            .builder()
                            .addStatement(
                                "val function = %N as? %T ?: throw %T()",
                                Generator.functionParameterName,
                                containerInfo.toErasedLambdaTypeName(returnType = returnTypeParameter),
                                Core.invalidJvmLambdaException
                            )
                            .add(
                                CodeBlock.of(
                                    buildString {
                                        append("return function.invoke(")
                                        append(containerInfo.toArgumentsString("args[INDEX]", "INDEX"))
                                        append(")")
                                    }
                                )
                            )
                            .build()
                    )
                    .build()

            )

        addType(lambdaContainerClassBuilder.build())
    }

    fun FileSpec.Builder.generateLambdaCallables(argCount: Int) {
        val callableClassName = Core.callable(argCount)
        val jvmActionClassName = Core.jvmAction(argCount)
        val jvmFunctionClassName = Core.jvmFunction(argCount)
        val lambdaContainerClassName = Core.lambdaContainer(argCount)
        val lambdaCallableClassName = Core.lambdaCallable(argCount)
        val containerInfo = GenericClassNameInfo(lambdaContainerClassName, argCount)
        val lambdaInfo = GenericClassNameInfo(lambdaCallableClassName, argCount)
        val genericParameters = containerInfo.genericTypes

        val lambdaTypeName = containerInfo.toLambdaTypeName(returnType = returnTypeParameter)
        val variantMapperMember = Utils.getVariantConverter
        val voidClassName = Void::class.asClassName()
        val nullableVoidType = voidClassName.copy(nullable = true)
        val genericJvmAction = if (genericParameters.isEmpty()) {
            jvmActionClassName
        } else {
            jvmActionClassName.parameterizedBy(genericParameters)
        }

        val lambdaCallableClassBuilder = TypeSpec
            .classBuilder(lambdaCallableClassName)
            .superclass(Core.lambdaCallable.parameterizedBy(returnTypeParameter))
            .addSuperinterface(callableClassName.parameterizedBy(listOf(returnTypeParameter) + genericParameters))
            .addTypeVariable(returnTypeParameter)
            .addTypeVariables(genericParameters)
            .primaryConstructor(
                FunSpec
                    .constructorBuilder()
                    .addModifiers(KModifier.INTERNAL)
                    .addParameter(
                        ParameterSpec
                            .builder(
                                Generator.containerArgumentName,
                                Core.lambdaContainer.parameterizedBy(returnTypeParameter)
                            )
                            .build()
                    )
                    .addParameter(
                        ParameterSpec
                            .builder(
                                Generator.boundArgsArgumentName,
                                ARRAY.parameterizedBy(ANY.copy(nullable = true))
                            )
                            .defaultValue("emptyArray()")
                            .build()
                    )
                    .addAnnotation(PublishedApi::class)
                    .build()
            )
            .addSuperclassConstructorParameter(Generator.containerArgumentName)
            .addSuperclassConstructorParameter(Generator.boundArgsArgumentName)

        generateBindMethods(argCount) { remaining, parameters ->
            val boundLambdaCallableClassName = Core.lambdaCallable(remaining.size)

            lambdaCallableClassBuilder.addFunction(
                FunSpec.builder(Core.bindMethodName)
                    .addModifiers(KModifier.OVERRIDE)
                    .addParameters(
                        parameters.mapIndexed { index: Int, typeVariableName: TypeVariableName ->
                            ParameterSpec.builder("p${index + remaining.size}", typeVariableName)
                                .build()
                        }
                    )
                    .addCode(
                        buildString {
                            append("return·%T(${Generator.containerArgumentName}, arrayOf<Any?>(")

                            for (index in (0..<parameters.size)) {
                                if (index != 0) append(",·")
                                append("p${index + remaining.size}")
                            }

                            append(", *${Generator.boundArgsArgumentName}))")
                        },
                        boundLambdaCallableClassName.parameterizedBy(listOf(returnTypeParameter) + remaining),
                    )
                    .build()
            )
        }

        val javaClassClassName = Class::class.asClassName()
        val genericJvmFunction = jvmFunctionClassName.parameterizedBy(listOf(returnTypeParameter) + genericParameters)
        val genericLambdaCallable = lambdaCallableClassName.parameterizedBy(listOf(returnTypeParameter) + genericParameters)
        val companionBuilder = TypeSpec
            .companionObjectBuilder()
            .addFunction(
                lambdaInfo
                    .toFunSpecBuilder(kotlinJavaHelperName(Core.createMethodName), prefix = listOf(returnTypeParameter))
                    .addParameters(
                        buildList {
                            add(ParameterSpec.builder("returnType", javaClassClassName.parameterizedBy(returnTypeParameter)).build())
                            addAll(
                                genericParameters.mapIndexed { index, typeVariableName ->
                                    ParameterSpec.builder("p${index}Type", javaClassClassName.parameterizedBy(typeVariableName)).build()
                                }
                            )
                            add(ParameterSpec.builder(Generator.functionParameterName, genericJvmFunction).build())
                        }
                    )
                    .returns(genericLambdaCallable)
                    .addCode(
                        buildCodeBlock {
                            add(
                                "return %T(%T(",
                                genericLambdaCallable,
                                containerInfo.className.parameterizedBy(listOf(returnTypeParameter) + genericParameters)
                            )
                            add("%M(returnType)!!, arrayOf(", variantMapperMember)
                            genericParameters.forEachIndexed { index, _ ->
                                if (index != 0) add(", ")
                                add("%M(p${index}Type)!!", variantMapperMember)
                            }
                            add("), %L))", Generator.functionParameterName)
                        }
                    )
                    .addAnnotation(JvmStatic::class)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("%S", Core.createMethodName)
                            .build()
                    )
                    .build()
            )
            .addFunction(
                lambdaInfo
                    .toFunSpecBuilder(kotlinJavaHelperName(Core.createMethodName))
                    .addParameters(
                        buildList {
                            addAll(
                                genericParameters.mapIndexed { index, typeVariableName ->
                                    ParameterSpec.builder("p${index}Type", javaClassClassName.parameterizedBy(typeVariableName)).build()
                                }
                            )
                            add(ParameterSpec.builder("action", genericJvmAction).build())
                        }
                    )
                    .returns(lambdaCallableClassName.parameterizedBy(listOf(nullableVoidType) + genericParameters))
                    .addCode(
                        buildCodeBlock {
                            add(
                                "return %T(%T(",
                                lambdaCallableClassName.parameterizedBy(listOf(nullableVoidType) + genericParameters),
                                containerInfo.className.parameterizedBy(listOf(nullableVoidType) + genericParameters)
                            )
                            add("%M(%T::class.java)!!, arrayOf(", variantMapperMember, voidClassName)
                            genericParameters.forEachIndexed { index, _ ->
                                if (index != 0) add(", ")
                                add("%M(p${index}Type)!!", variantMapperMember)
                            }
                            add("), ")
                            add(jvmActionAdapter(argCount, containerInfo, nullableVoidType))
                            add("))")
                        }
                    )
                    .addAnnotation(JvmStatic::class)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("%S", Core.createMethodName)
                            .build()
                    )
                    .build()
            )


        val converterParameters = genericParameters.mapIndexed { index, _ ->
            ParameterSpec.builder("p${index}Converter", VariantConverter.BASE).build()
        }
        val converterArray = buildString {
            append("arrayOf(")
            genericParameters.forEachIndexed { index, _ ->
                if (index != 0) append(", ")
                append("p${index}Converter")
            }
            append(")")
        }
        companionBuilder.addFunction(
            lambdaInfo
                .toFunSpecBuilder(kotlinJavaHelperName(Core.createMethodName), prefix = listOf(returnTypeParameter))
                .addParameter(Generator.returnConverterParameterName, VariantConverter.BASE)
                .addParameters(converterParameters)
                .addParameter(Generator.functionParameterName, genericJvmFunction)
                .returns(genericLambdaCallable)
                .addCode(
                    "return %T(%T(${Generator.returnConverterParameterName}, $converterArray, %L))",
                    genericLambdaCallable,
                    containerInfo.className.parameterizedBy(listOf(returnTypeParameter) + genericParameters),
                    Generator.functionParameterName,
                )
                .addAnnotation(JvmStatic::class)
                .addAnnotation(
                    AnnotationSpec.builder(JvmName::class)
                        .addMember("%S", Core.createMethodName)
                        .build()
                )
                .build()
        )
        if (argCount > 0) {
            companionBuilder.addFunction(
                lambdaInfo
                    .toFunSpecBuilder(kotlinJavaHelperName(Core.createMethodName))
                    .addParameters(converterParameters)
                    .addParameter("action", genericJvmAction)
                    .returns(lambdaCallableClassName.parameterizedBy(listOf(nullableVoidType) + genericParameters))
                    .addCode(
                        buildCodeBlock {
                            add(
                                "return %T(%T(",
                                lambdaCallableClassName.parameterizedBy(listOf(nullableVoidType) + genericParameters),
                                containerInfo.className.parameterizedBy(listOf(nullableVoidType) + genericParameters)
                            )
                            add("%M(%T::class.java)!!, $converterArray, ", variantMapperMember, voidClassName)
                            add(jvmActionAdapter(argCount, containerInfo, nullableVoidType))
                            add("))")
                        }
                    )
                    .addAnnotation(JvmStatic::class)
                    .addAnnotation(
                        AnnotationSpec.builder(JvmName::class)
                            .addMember("%S", Core.createMethodName)
                            .build()
                    )
                    .build()
            )
        }

        lambdaCallableClassBuilder.addType(companionBuilder.build())

        addType(lambdaCallableClassBuilder.build())
        addFunction(
            FunSpec.builder(Generator.lambdaCallableFunctionName + argCount)
                .addTypeVariable(returnTypeParameter.copy(reified = true))
                .addTypeVariables(genericParameters.map { it.copy(reified = true) })
                .addModifiers(KModifier.INLINE)
                .addParameters(
                    listOf(
                        ParameterSpec
                            .builder(
                                Generator.functionParameterName,
                                lambdaTypeName
                            )
                            .addModifiers(KModifier.NOINLINE)
                            .build()
                    )
                )
                .addCode(
                    CodeBlock.of(
                        buildString {
                            append("return·%T(%T(")
                            append("%M<%T>()!!,·arrayOf(")
                            genericParameters.forEachIndexed { index, _ ->
                                if (index != 0) append(",·")
                                append("%M<%T>()!!")
                            }
                            append("),·")
                            append(Generator.functionParameterName)
                            append("))")
                        },
                        lambdaInfo.className.parameterizedBy(listOf(returnTypeParameter) + genericParameters),
                        containerInfo.className.parameterizedBy(listOf(returnTypeParameter) + genericParameters),
                        variantMapperMember,
                        returnTypeParameter,
                        *genericParameters
                            .flatMap {
                                listOf(variantMapperMember, it)
                            }
                            .toTypedArray()
                    )
                )
                .build()
        )

        addFunction(
            FunSpec.builder(Generator.lambdaCallableFunctionName + argCount)
                .addTypeVariable(returnTypeParameter)
                .addTypeVariables(genericParameters)
                .addParameter(Generator.returnConverterParameterName, VariantConverter.BASE)
                .addParameters(converterParameters)
                .addParameter(Generator.functionParameterName, lambdaTypeName)
                .addCode(
                    "return·%T(%T(${Generator.returnConverterParameterName},·$converterArray,·%L))",
                    lambdaInfo.className.parameterizedBy(listOf(returnTypeParameter) + genericParameters),
                    containerInfo.className.parameterizedBy(listOf(returnTypeParameter) + genericParameters),
                    Generator.functionParameterName,
                )
                .build()
        )

        addFunction(
            FunSpec
                .builder(Utils.asCallable.simpleName)
                .addTypeVariable(returnTypeParameter.copy(reified = true))
                .addTypeVariables(genericParameters.map { it.copy(reified = true) })
                .addModifiers(KModifier.INLINE)
                .receiver(lambdaTypeName)
                .addCode("return·${Generator.lambdaCallableFunctionName}$argCount(this)")
                .build()
        )
    }

    /** `object : JvmFunctionN<Void?, P0..> { override fun invoke(p0..): Void? { action.invoke(p0..); return null } }` */
    private fun jvmActionAdapter(argCount: Int, containerInfo: GenericClassNameInfo, nullableVoidType: TypeName) = buildCodeBlock {
        add("object : %T ", Core.jvmFunction(argCount).parameterizedBy(listOf(nullableVoidType) + containerInfo.genericTypes))
        beginControlFlow("{")
        beginControlFlow(
            "override fun invoke(${containerInfo.toParameterSpecList().joinToString(", ") { "${it.name}: ${it.type}" }}): %T",
            nullableVoidType
        )
        addStatement("action.invoke(${containerInfo.toArgumentsString("pINDEX", "INDEX")})")
        addStatement("return null")
        endControlFlow()
        endControlFlow()
    }

    inline fun generateBindMethods(argCount: Int, block: (remaining: MutableList<TypeVariableName>, parameters: MutableList<TypeVariableName>) -> Unit) {
        val remainingGenerics = GenericClassNameInfo(numberOfGenericParameters = argCount).genericTypes.toMutableList()
        val parameterTypes = ArrayList<TypeVariableName>().toMutableList()

        while (remainingGenerics.isNotEmpty()) {
            val type = remainingGenerics.removeLast()
            parameterTypes.add(0, type)
            block(remainingGenerics, parameterTypes)
        }
    }


    fun FileSpec.Builder.buildTo(dir: File) {
        addAnnotation(
            AnnotationSpec
                .builder(Suppress::class)
                .addMember("\"PackageDirectoryMismatch\", \"UNCHECKED_CAST\"")
                .addMember("\"unused\"")
                .addMember("\"RedundantVisibilityModifier\"")
                .build()
        )
            .build()
            .writeTo(dir)
    }
}


