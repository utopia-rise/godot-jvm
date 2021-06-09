package godot.codegen

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.squareup.kotlinpoet.*
import godot.codegen.utils.getPackage
import godot.codegen.utils.jvmVariantTypeValue
import godot.docgen.ClassDoc
import godot.docgen.DocGen
import java.io.File

const val GENERATED_COMMENT = "THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!"

lateinit var tree: Graph<Class>
var classDocs: Map<String, ClassDoc> = mapOf()

val jvmMethodToNotGenerate = listOf(
    "ENGINEMETHOD_ENGINECLASS_OBJECT_FREE",
    "ENGINEMETHOD_ENGINECLASS_INTERPOLATEDCAMERA_SET_TARGET"
)

fun File.generateApiFrom(jsonSource: File, docsDir: File? = null) {
    classDocs = docsDir?.let { DocGen.deserializeDoc(it) } ?: mapOf()
    val classes: List<Class> = ObjectMapper().readValue(jsonSource, object : TypeReference<ArrayList<Class>>() {})

    tree = classes.buildTree()

    classes.forEach {
        it.initClass()
        it.methods.forEach { method -> method.initEngineIndex(it.engineClassDBIndexName) }
        it.properties.forEach { property -> property.initEngineIndexNames(it.engineClassDBIndexName) }
    }

    val methodsToRename = mutableMapOf<Method, String>()
    classes.forEach { clazz ->
        clazz.properties.forEach { property ->
            val method = Method(
                "get_${property.oldName}",
                property.type,
                isVirtual = false,
                hasVarargs = false,
                arguments = listOf()
            )
            val parentClassAndMethod = tree.getMethodFromAncestor(clazz, method)
            if (parentClassAndMethod != null && !property.hasValidGetter) {
                val parentMethodName = "get${parentClassAndMethod.first.newName}${property.newName.capitalize()}"
                property.parentMethodToCall = parentMethodName
                val find = parentClassAndMethod.first.methods.find { it.newName == "get${property.newName.capitalize()}" }
                if (find != null) {
                    methodsToRename[find] = parentMethodName
                }
            }
        }
    }
    methodsToRename.forEach {
        it.key.newName = it.value
    }

    generateEngineIndexesFile(classes).writeTo(this)

    classes.forEach { clazz ->
        clazz.generate(this)
    }

    this.parentFile.mkdirs()

    generateEngineTypesRegistration(classes).writeTo(this)
}

private fun generateEngineIndexesFile(classes: List<Class>): FileSpec {
    val fileSpecBuilder = FileSpec.builder("godot", "EngineIndexes")
    var methodIndex = 0
    var singletonIndex = 0
    classes.filter { it.shouldGenerate }.forEachIndexed { classIndex, clazz ->
        fileSpecBuilder.addProperty(
            PropertySpec.builder(clazz.engineClassDBIndexName, INT, KModifier.CONST).initializer("%L", classIndex).addModifiers(KModifier.INTERNAL).build()
        )

        if (clazz.isSingleton) {
            fileSpecBuilder.addProperty(
                PropertySpec.builder(clazz.engineSingletonIndexName!!, INT, KModifier.CONST).initializer("%L", singletonIndex).addModifiers(KModifier.INTERNAL).build()
            )
            singletonIndex++
        }

        clazz.methods.filter { !it.isGetterOrSetter }.forEach { method ->
            if (!jvmMethodToNotGenerate.contains(method.engineIndexName)) {
                fileSpecBuilder.addProperty(
                    PropertySpec.builder(method.engineIndexName, INT, KModifier.CONST)
                        .initializer("%L", methodIndex).addModifiers(KModifier.INTERNAL).build()
                )
                methodIndex++
            }
        }
        clazz.properties.forEach { property ->
            if (property.hasValidGetter) {
                fileSpecBuilder.addProperty(
                    PropertySpec.builder(property.engineGetterIndexName, INT, KModifier.CONST)
                        .initializer("%L", methodIndex).addModifiers(KModifier.INTERNAL).build()
                )
                methodIndex++
            }

            if (property.hasValidSetter) {
                fileSpecBuilder.addProperty(
                    PropertySpec.builder(property.engineSetterIndexName, INT, KModifier.CONST)
                        .initializer("%L", methodIndex).addModifiers(KModifier.INTERNAL).build()
                )
                methodIndex++
            }
        }
    }

    return fileSpecBuilder.addComment(GENERATED_COMMENT).build()
}

private fun generateEngineTypesRegistration(classes: List<Class>): FileSpec {
    val registrationFile = FileSpec.builder("godot", "RegisterEngineTypes")

    val registerTypesFunBuilder = FunSpec.builder("registerEngineTypes")

    val registerMethodsFunBuilder = FunSpec.builder("registerEngineTypeMethods")

    val registerVariantMappingFunBuilder = FunSpec.builder("registerVariantMapping")

    fun addEngineTypeMethod(methodForClass: FunSpec.Builder, classIndexName: String, methodEngineName: String) {
        methodForClass.addStatement(
            "%T.engineTypeMethod.add(%M to \"${methodEngineName}\")",
            ClassName("godot.core", "TypeManager"),
            MemberName("godot", classIndexName)
        )
    }

    fun addVariantMapping(className: String) {
        registerVariantMappingFunBuilder.addStatement(
            "%M[%T::class] = %T",
            MemberName("godot.core", "variantMapper"),
            ClassName("godot", className),
            ClassName("godot.core.VariantType", className.jvmVariantTypeValue)
        )
    }

    classes.filter { it.shouldGenerate }.forEach { clazz ->
        if (clazz.isSingleton) {
            registerTypesFunBuilder.addStatement(
                "%T.registerEngineType(%S) { %T }",
                ClassName("godot.core", "TypeManager"),
                clazz.oldName,
                ClassName(clazz.newName.getPackage(), clazz.newName)
            )
            registerTypesFunBuilder.addStatement(
                "%T.registerSingleton(%S)",
                ClassName("godot.core", "TypeManager"),
                clazz.newName
            )
        } else {
            registerTypesFunBuilder.addStatement(
                "%T.registerEngineType(%S, ::%T)",
                ClassName("godot.core", "TypeManager"),
                clazz.oldName,
                ClassName(clazz.newName.getPackage(), clazz.newName)
            )
        }
        addVariantMapping(clazz.newName)

        val registerMethodForClassFun = FunSpec.builder("registerEngineTypeMethodFor${clazz.newName}")
        registerMethodForClassFun.addModifiers(KModifier.PRIVATE)
        clazz.methods.filter { !it.isGetterOrSetter }.forEach {
            if (!jvmMethodToNotGenerate.contains(it.engineIndexName)) {
                addEngineTypeMethod(registerMethodForClassFun, clazz.engineClassDBIndexName, it.oldName)
            }
        }
        clazz.properties.forEach {
            if (it.hasValidGetter) {
                addEngineTypeMethod(registerMethodForClassFun, clazz.engineClassDBIndexName, it.validGetter.oldName)
            }
            if (it.hasValidSetter) {
                addEngineTypeMethod(registerMethodForClassFun, clazz.engineClassDBIndexName, it.validSetter.oldName)
            }
        }
        registrationFile.addFunction(registerMethodForClassFun.build())
        registerMethodsFunBuilder.addStatement("registerEngineTypeMethodFor${clazz.newName}()")
    }
    registrationFile.addFunction(
            registerTypesFunBuilder.build()
        )
        .addFunction(
            registerVariantMappingFunBuilder.build()
        )

    registrationFile.addFunction(registerMethodsFunBuilder.build())

    return registrationFile.addComment(GENERATED_COMMENT).build()
}
