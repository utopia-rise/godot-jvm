package godot.codegen.generation.rule

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import godot.codegen.constants.API
import godot.codegen.constants.Core
import godot.codegen.constants.Kotlin
import godot.codegen.constants.PrimitiveNativeStructures
import godot.codegen.constants.TypeIdentifier
import godot.codegen.constants.Utils
import godot.codegen.generation.GenerationContext
import godot.codegen.generation.task.ApiTask
import godot.codegen.generation.task.EnrichedClassTask
import godot.codegen.generation.task.FileTask
import godot.codegen.models.ApiType
import godot.codegen.models.EnumValue
import godot.codegen.models.NativeStructure
import godot.codegen.models.enriched.EnrichedClass
import godot.codegen.models.enriched.EnrichedMethod
import godot.codegen.models.enriched.EnrichedNativeStructure
import godot.codegen.models.enriched.EnrichedProperty
import godot.codegen.models.enriched.toEnriched
import godot.codegen.models.traits.GenerationType
    import godot.codegen.models.traits.bitfieldPrefix
import godot.codegen.rpc.RpcFunctionMode

class UseConnectFlagRule : GodotApiRule<ApiTask>() {
    override fun apply(task: ApiTask, context: GenerationContext) {
        val objectClassIndex = context.api.classes.indexOfFirst { it.name == API.`object`.simpleName }
        val objectRawClass = context.api.classes[objectClassIndex]

        val connectRawEnum = objectRawClass.enums!!.single { it.name == Core.connectFlags.simpleName }
        val newValues = listOf(
            EnumValue(
                "DEFAULT",
                0,
                "Default connections that are immediately emitted"
            )
        ) + connectRawEnum.values
        context.api.globalEnums.add(connectRawEnum.copy(values = newValues))

        val connectMethodIndex = objectRawClass.methods!!.indexOfFirst { it.name == "connect" }
        val connectMethod = objectRawClass.methods[connectMethodIndex]

        val flagArgumentIndex = connectMethod.arguments!!.indexOfFirst { it.name == "flags" }
        val flagArgument = connectMethod.arguments[flagArgumentIndex]

        val newArgument = flagArgument.copy(type = "$bitfieldPrefix${Core.connectFlags.simpleName}", meta = null)
        val newMethod = connectMethod.copy(arguments = connectMethod.arguments.dropLast(1) + newArgument)
        val newMethodList = objectRawClass.methods.toMutableList()
        newMethodList[connectMethodIndex] = newMethod

        val newClass = objectRawClass.copy(enums = objectRawClass.enums - connectRawEnum, methods = newMethodList)
        context.api.classes[objectClassIndex] = newClass
    }
}

class EnrichedCoreRule : GodotApiRule<ApiTask>() {
    override fun apply(task: ApiTask, context: GenerationContext) {
        val coreTypes = context.api.builtinClasses.associate {
            it.name to (it.enums?.toEnriched(GenerationType(it.name)) ?: listOf())
        }
        val globalEnumList = context.api.globalEnums.toEnriched()
        val globalEnumMap = globalEnumList.associateBy { it.identifier }
        val nativeStructureMap = mutableMapOf<String, EnrichedNativeStructure>()
        context.api.nativeStructures.toEnriched().forEach {
            nativeStructureMap[it.identifier] = it
            nativeStructureMap[it.identifier + "*"] = it
            nativeStructureMap["const " + it.identifier + "*"] = it
        }

        PrimitiveNativeStructures.all.forEach {
            // We don't include the base name here because they are always used as pointer and can overlap with a plain "float".
            nativeStructureMap[it.identifier + "*"] = it
            nativeStructureMap["const " + it.identifier + "*"] = it
        }

        //TODO: clean this
        nativeStructureMap["const GDExtensionInitializationFunction*"] = EnrichedNativeStructure(
            NativeStructure(
                "GDExtensionInitializationFunction",
                ""
            )
        )

        context.coreTypeMap += coreTypes
        context.globalEnumMap += globalEnumMap
        context.globalEnumList += globalEnumList
        context.nativeStructureMap += nativeStructureMap
    }
}

class EnrichedClassRule : GodotApiRule<ApiTask>() {
    override fun apply(task: ApiTask, context: GenerationContext) {
        val classes = context.api.classes
        var classList = classes.toEnriched().filter { it.apiType == ApiType.CORE }
        var classMap = classList.associateBy { it.identifier }

        classes.forEach {
            val enrichedChild = classMap[it.name]
            val enrichedParent = classMap[it.inherits]
            if (enrichedParent != null && enrichedChild != null) {
                enrichedChild.setParent(enrichedParent)
            }
        }

        // Set singletons
        context.api.singletons.forEach {
            classMap[it.type]?.makeSingleton()
        }

        classList = classList
            .filter { clazz ->// Remove class extending singletons
                val parent = clazz.parent
                parent == null || !parent.isSingleton
            }
        classMap = classList.associateBy { it.identifier }

        context.classMap += classMap
        context.classList += classList

        initializeProperties(context)
    }


    private fun validateGetter(property: EnrichedProperty, getter: EnrichedMethod?) {
        if (getter == null) return
        if (getter.type.isVoid() || getter.arguments.size > 1 || getter.isVirtual) return
        if (!property.isIndexed && getter.arguments.size == 1) return
        if (getter.arguments.size == 1 && !getter.arguments[0].type.isEnum() && getter.arguments[0].type.identifier != TypeIdentifier.INT.name) return
        property.setGetter(getter)
    }

    private fun validateSetter(property: EnrichedProperty, setter: EnrichedMethod?) {
        if (setter == null) return
        if (!setter.type.isVoid() || setter.arguments.size > 2 || setter.isVirtual) return
        if (!property.isIndexed && setter.arguments.size == 2) return
        if (setter.arguments.size == 2 && !setter.arguments[0].type.isEnum() && setter.arguments[0].type.identifier != TypeIdentifier.INT.name) return
        property.setSetter(setter)
    }

    private fun searchPropertyForClass(properties: List<EnrichedProperty>, clazz: EnrichedClass): Boolean {
        val methods = clazz.methods.associateBy { it.name }
        var allSet = true
        for (property in properties) {
            if (property.name == "") continue
            val needGetter = property.getterMethod == null
            val needSetter = property.setterName != null && property.setterMethod == null

            if (needGetter) {
                validateGetter(property, methods[property.getterName])
            }

            if (needSetter) {
                validateSetter(property, methods[property.setterName])
            }

            if (property.getterMethod == null || (property.setterName != null && property.setterMethod == null)) {
                allSet = false
            }
        }
        return allSet
    }

    private fun initializeProperties(context: GenerationContext) {
        for (clazz in context.classList) {
            var currentClass: EnrichedClass? = clazz
            do {
                searchPropertyForClass(clazz.properties, currentClass!!)
                currentClass = currentClass.parent
            } while (currentClass != null)
        }
    }
}

class CoreRule : GodotApiRule<ApiTask>() {
    override fun apply(task: ApiTask, context: GenerationContext) {
        for (enum in context.globalEnumList) {
            task.coreFiles += FileTask(enum)
        }
    }
}

class ApiRule : GodotApiRule<ApiTask>() {
    override fun apply(task: ApiTask, context: GenerationContext) {
        val classes = context
            .classList
            .filter {  //Remove class extending singletons
                val parent = it.parent
                parent == null || !parent.isSingleton
            }

        for (clazz in classes) {
            task.apiFiles += FileTask(clazz)
        }
    }
}

class ObjectRule : GodotApiRule<EnrichedClassTask>() {
    override fun apply(task: EnrichedClassTask, context: GenerationContext) = with(task.builder) {
        val type = task.clazz
        if (type.identifier == API.node.simpleName) {
            generateTypesafeRpc()
        }
        if (type.identifier == API.refCounted.simpleName) {
            preventOnDestroyUsage()
        }
    }

    private fun TypeSpec.Builder.preventOnDestroyUsage() {
        addFunction(
            FunSpec.builder("_onDestroy")
                .addModifiers(KModifier.OVERRIDE, KModifier.FINAL)
                .returns(Unit::class)
                .addStatement("")
                .build()
        )
    }

    private fun TypeSpec.Builder.generateTypesafeRpc() {
        for (i in 0..10) {
            val kFunctionTypeParameters = mutableListOf<TypeVariableName>()
            if (i != 0) {
                for (argIndex in 0 until i) {
                    kFunctionTypeParameters.add(TypeVariableName.invoke("ARG$argIndex"))
                }
            }

            val kFunctionClassName = Kotlin
                .kFunction(i)
                .parameterizedBy(
                    *kFunctionTypeParameters.toTypedArray(),
                    TypeVariableName.invoke("*")
                )

            RpcFunctionMode.entries.forEach { rpcFunctionMode ->
                val rpcFunSpec = FunSpec
                    .builder(rpcFunctionMode.functionName)
                    .returns(Core.error)
                    .addModifiers(KModifier.INLINE)

                if (rpcFunctionMode.hasId) {
                    rpcFunSpec.addParameter("id", Long::class)
                }

                rpcFunSpec.addParameter("function", TypeVariableName.invoke("FUNCTION"))

                var templateString = "return ${rpcFunctionMode.functionName}("

                if (rpcFunctionMode.hasId) {
                    templateString += "id, "
                }

                templateString += "function.name.%M()"

                kFunctionTypeParameters.forEachIndexed { index, typeVariableName ->
                    rpcFunSpec.addTypeVariable(typeVariableName)
                    val argParamName = "arg$index"
                    rpcFunSpec.addParameter(argParamName, typeVariableName)
                    templateString += ", $argParamName"
                }
                templateString += ")"
                rpcFunSpec.addStatement(templateString, Utils.toGodotName)

                rpcFunSpec.addTypeVariable(TypeVariableName.invoke("FUNCTION", kFunctionClassName).copy(reified = true))
                addFunction(rpcFunSpec.build())
            }
        }
    }
}

