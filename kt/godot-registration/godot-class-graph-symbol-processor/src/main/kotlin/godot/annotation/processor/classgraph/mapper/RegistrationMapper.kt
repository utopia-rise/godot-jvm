package godot.annotation.processor.classgraph.mapper

import godot.annotation.Emit
import godot.annotation.GodotBaseType
import godot.annotation.Notification
import godot.annotation.Register
import godot.annotation.Rpc
import godot.annotation.RpcMode
import godot.annotation.Script
import godot.annotation.Sync
import godot.annotation.Tool
import godot.annotation.TransferMode
import godot.annotation.Visible
import godot.annotation.processor.classgraph.ProcessorContext
import godot.annotation.processor.classgraph.ProcessorSettings
import godot.annotation.processor.classgraph.extensions.directSuperInterfaces
import godot.annotation.processor.classgraph.extensions.enumEntryCount
import godot.annotation.processor.classgraph.extensions.isGodotCompatibleClass
import godot.annotation.processor.classgraph.extensions.isProcessorBitField
import godot.annotation.processor.classgraph.extensions.isProcessorCollection
import godot.annotation.processor.classgraph.extensions.isProcessorCoreType
import godot.annotation.processor.classgraph.extensions.methodSignature
import godot.annotation.processor.classgraph.extensions.rawDescriptor
import godot.annotation.processor.classgraph.extensions.registrationFqName
import godot.annotation.processor.classgraph.extensions.returnRawDescriptor
import godot.annotation.processor.classgraph.extensions.returnTypeArguments
import godot.annotation.processor.classgraph.extensions.sourceProjectName
import godot.annotation.processor.classgraph.extensions.superMethodSignatures
import godot.annotation.processor.classgraph.extensions.typeArguments
import godot.annotation.processor.classgraph.policy.RegistrationPolicy
import godot.annotation.processor.classgraph.shape.JvmLanguage
import godot.annotation.processor.classgraph.shape.LogicalClassShape
import godot.annotation.processor.classgraph.shape.LogicalMethod
import godot.annotation.processor.classgraph.shape.LogicalProperty
import godot.annotation.processor.classgraph.shape.LogicalSignal
import godot.core.KtObject
import godot.registration.model.RegisteredConstructor
import godot.registration.model.RegisteredFunction
import godot.registration.model.RegisteredProperty
import godot.registration.model.RegisteredPropertyBindingKind
import godot.registration.model.RegisteredSignal
import godot.registration.model.RpcConfig
import godot.registration.model.ValueParameter
import godot.registration.model.hint.property.EnumFlagHintStringHint
import godot.registration.model.hint.property.EnumHintStringHint
import godot.registration.model.hint.property.EnumListHintStringHint
import godot.registration.model.hint.property.PropertyHint
import godot.registration.model.types.GodotBaseClass
import godot.registration.model.types.GodotClass
import godot.registration.model.types.ScriptClass
import godot.registration.model.types.ScriptClassConfiguration
import godot.registration.model.types.ScriptInterface
import godot.registration.model.types.SourceClass
import godot.registration.model.types.Type
import godot.registration.model.types.TypeKind
import io.github.classgraph.AnnotationEnumValue
import io.github.classgraph.AnnotationInfo
import io.github.classgraph.ClassInfo
import io.github.classgraph.ClassRefTypeSignature
import io.github.classgraph.MethodInfo
import io.github.classgraph.MethodParameterInfo
import io.github.classgraph.ScanResult
import io.github.classgraph.TypeArgument
import org.jetbrains.annotations.NotNull

class RegistrationMapper(
    scanResult: ScanResult,
    settings: ProcessorSettings,
) {
    private val context = ProcessorContext(scanResult = scanResult, settings = settings)
    private val policy = RegistrationPolicy(context)

    fun map(): List<ScriptClass> =
        mapClasses(context.scanResult.rootGodotClasses())

    fun mapIncrementally(dirtyClassNames: Set<String>): List<ScriptClass> =
        mapClasses(context.scanResult.dirtyGodotClasses(dirtyClassNames))

    private fun mapClasses(candidateClasses: List<ClassInfo>): List<ScriptClass> {
        val selectedClasses = candidateClasses
            .asSequence()
            .mapNotNull(::shapeOfOrNull)
            .filter(policy::selectClass)
            .map(LogicalClassShape::classInfo)
            .toList()

        val selectedClassNames = selectedClasses.mapTo(mutableSetOf()) { classInfo -> classInfo.name }
        return MappingRun(selectedClassNames).map(selectedClasses)
    }

    private fun shapeOf(classInfo: ClassInfo): LogicalClassShape =
        context.getOrPutClassShape(classInfo) {
            JvmLanguage.forClass(classInfo).shapeOf(classInfo)
        }

    private fun shapeOfOrNull(classInfo: ClassInfo): LogicalClassShape? {
        val language = JvmLanguage.forClassOrNull(classInfo)
        if (language == null) {
            System.err.println(
                "WARNING: Skipping ${classInfo.name} because source language could not be identified " +
                    "(sourceFile=${classInfo.sourceFile ?: "<unknown>"})."
            )
            return null
        }
        return context.getOrPutClassShape(classInfo) {
            language.shapeOf(classInfo)
        }
    }

    private inner class MappingRun(
        private val selectedClassNames: Set<String>,
    ) {
        private val classFamilies = ClassFamilies()
        private val members = Members()
        private val typeMapper = TypeMapper()

        fun map(selectedClasses: List<ClassInfo>): List<ScriptClass> =
            selectedClasses
                .asSequence()
                .map(classFamilies::getOrCreateScriptClass)
                .distinctBy(ScriptClass::fqName)
                .toList()

        private inner class ClassFamilies {
            private val populatedScriptClasses = mutableSetOf<String>()
            private val populatedInterfaces = mutableSetOf<String>()

            fun getOrCreateScriptClass(classInfo: ClassInfo): ScriptClass {
                val scriptClass = context.getOrPutMappedFamily(classInfo.name) {
                    val shape = shapeOf(classInfo)
                    val sourceProjectName = classInfo.sourceProjectName(context.settings)
                    ScriptClass(
                        fqName = classInfo.registrationFqName,
                        customName = policy.findAnnotation(shape, Script::class)
                            ?.parameterValues
                            ?.firstOrNull()
                            ?.value as? String,
                        sourceProjectName = sourceProjectName,
                        sourceFileName = classInfo.sourceFile
                            ?.takeIf { sourceProjectName == context.settings.projectName }
                            .orEmpty(),
                        configuration = ScriptClassConfiguration(
                            isTool = policy.hasAnnotation(shape, Tool::class),
                        ),
                        isRegistered = classInfo.name in selectedClassNames,
                        isAbstract = classInfo.isAbstract,
                    )
                } as ScriptClass

                populateScriptClass(scriptClass, classInfo)
                return scriptClass
            }

            private fun populateScriptClass(scriptClass: ScriptClass, classInfo: ClassInfo) {
                if (!populatedScriptClasses.add(classInfo.name)) {
                    return
                }

                val logicalShape = shapeOf(classInfo)
                val accessorPropertiesByMethod = logicalShape.accessorPropertiesByMethod()
                val selectedProperties = logicalShape.properties
                    .filter(policy::selectProperty)
                    .filter(::isRegistrableProperty)
                    .filter(::shouldRegisterProperty)

                scriptClass.parent = classInfo.superclass?.let(typeMapper::mapClass) as? GodotClass
                scriptClass.interfaces = classInfo.directSuperInterfaces().map(::getOrCreateInterface)
                scriptClass.constructors = classInfo.declaredConstructorInfo.orEmpty()
                    .filter { constructor -> constructor.isPublic && constructor.parameterInfo.isEmpty() }
                    .map { constructor ->
                        RegisteredConstructor(
                            parameterTypes = constructor.parameterInfo.map(typeMapper::mapParameter),
                        )
                    }
                scriptClass.signals = logicalShape.signals
                    .filter(policy::selectSignal)
                    .map { signal -> members.mapSignal(signal, classInfo) }
                scriptClass.properties = selectedProperties
                    .map { property -> members.mapProperty(property, classInfo) }
                scriptClass.functions = logicalShape.methods
                    .filter(::isPublicMethod)
                    .filter { method -> shouldRegisterMethod(method, accessorPropertiesByMethod[method.methodInfo]) }
                    .filter { method -> policy.selectMethod(method, classInfo) }
                    .map(members::mapFunction)
                scriptClass.isRegistered = classInfo.name in selectedClassNames
            }

            private fun isRegistrableProperty(property: LogicalProperty): Boolean =
                when {
                    property.getter != null || property.setter != null ->
                        listOfNotNull(property.getter, property.setter).all(MethodInfo::isPublic)

                    else -> property.fieldInfo?.isPublic == true
                }

            private fun shouldRegisterProperty(property: LogicalProperty): Boolean {
                val hasVisible = policy.hasAnnotation(property, Visible::class)
                val hasRegister = property.accessorMethods().any { methodInfo ->
                    policy.hasAnnotation(LogicalMethod(methodInfo, methodInfo.annotationInfo), Register::class)
                }

                return hasVisible || !hasRegister
            }

            private fun shouldRegisterMethod(
                method: LogicalMethod,
                accessorProperties: List<LogicalProperty>?,
            ): Boolean {
                if (accessorProperties.isNullOrEmpty()) {
                    return true
                }
                return policy.hasAnnotation(method, Register::class)
            }

            fun getOrCreateBaseClass(classInfo: ClassInfo): GodotBaseClass =
                context.getOrPutMappedBaseClass(classInfo.name) {
                    GodotBaseClass(
                        fqName = classInfo.registrationFqName,
                        parent = classInfo.superclass?.let(typeMapper::mapClass) as? GodotClass,
                    )
                }

            fun getOrCreateInterface(classInfo: ClassInfo): ScriptInterface {
                val scriptInterface = context.getOrPutMappedFamily(classInfo.name) {
                    ScriptInterface(
                        fqName = classInfo.registrationFqName,
                    )
                } as ScriptInterface

                populateInterface(scriptInterface, classInfo)
                return scriptInterface
            }

            private fun populateInterface(scriptInterface: ScriptInterface, classInfo: ClassInfo) {
                if (!populatedInterfaces.add(classInfo.name)) {
                    return
                }

                val logicalShape = shapeOf(classInfo)
                scriptInterface.interfaces = classInfo.directSuperInterfaces().map(::getOrCreateInterface)
                scriptInterface.functions = logicalShape.methods
                    .filter(::isPublicMethod)
                    .filter { method -> policy.selectMethod(method, classInfo) }
                    .map(members::mapFunction)
            }

            private fun isPublicMethod(method: LogicalMethod): Boolean =
                method.methodInfo.isPublic
        }

        private inner class TypeMapper {
            fun mapParameter(parameterInfo: MethodParameterInfo): Type = mapRaw(
                rawDescriptor = parameterInfo.rawDescriptor(),
                typeArguments = parameterInfo.typeArguments(),
            )

            fun mapPropertyType(
                rawDescriptor: String,
                typeArguments: List<TypeArgument>,
                isLateinit: Boolean,
                isNotNullAnnotated: Boolean,
            ): Type {
                val base = mapRaw(rawDescriptor, typeArguments)
                if (base.kind == TypeKind.GODOT_CLASS || base.kind == TypeKind.INTERFACE) {
                    return base
                }

                val propertyNullable = Type.findPrimitiveType(rawDescriptor) == null &&
                    base.kind != TypeKind.CORE_TYPE &&
                    !isLateinit &&
                    !isNotNullAnnotated

                return base.with(
                    isNullable = propertyNullable,
                    genericArguments = base.genericArguments,
                )
            }

            fun mapClass(classInfo: ClassInfo): Type =
                when {
                    classInfo.hasAnnotation(GodotBaseType::class.java.name) -> classFamilies.getOrCreateBaseClass(classInfo)
                    classInfo.isGodotCompatibleClass() -> classFamilies.getOrCreateScriptClass(classInfo)
                    else -> SourceClass(fqName = classInfo.registrationFqName)
                }

            fun mapRaw(rawDescriptor: String, typeArguments: List<TypeArgument>): Type {
                val rawType = rawDescriptor.substringBefore("<")
                val mappedTypeArguments = typeArguments.map { typeArgument ->
                    mapRaw(
                        rawDescriptor = typeArgument.rawDescriptor(),
                        typeArguments = typeArgument.typeArguments(),
                    )
                }

                Type.findPrimitiveType(rawType, genericArguments = mappedTypeArguments)?.let { return it }
                Type.findCoreType(rawType, genericArguments = mappedTypeArguments)?.let { return it }

                val classInfo = requireNotNull(context.getClassInfoOrNull(rawType)) {
                    "Could not resolve class info for descriptor: $rawDescriptor"
                }

                return context.getOrPutMappedType(classInfo, typeArguments) {
                    val fqName = classInfo.registrationFqName
                    when {
                        classInfo.isProcessorCoreType -> Type.getCoreType(fqName, genericArguments = mappedTypeArguments)
                        classInfo.isEnum -> Type.getEnum(fqName, genericArguments = mappedTypeArguments)
                        classInfo.isProcessorBitField -> Type.getBitField(fqName, genericArguments = mappedTypeArguments)
                        classInfo.isProcessorCollection ->
                            Type.getCollection(fqName, genericArguments = mappedTypeArguments)

                        classInfo.isStandardClass -> mapClass(classInfo)
                        else -> Type(
                            fqName = fqName,
                            kind = TypeKind.OTHER,
                            isNullable = false,
                            genericArguments = mappedTypeArguments,
                        )
                    }
                }
            }
        }

        private inner class Members {
            fun functionRpcConfig(method: LogicalMethod): RpcConfig? =
                policy.findAnnotation(method, Rpc::class)
                    ?.let { annotation ->
                        RpcConfig(
                            rpcMode = RpcMode.valueOf(
                                (annotation.parameterValues.getValue("rpcMode") as AnnotationEnumValue).valueName
                            ),
                            sync = Sync.valueOf(
                                (annotation.parameterValues.getValue("sync") as AnnotationEnumValue).valueName
                            ),
                            transferMode = TransferMode.valueOf(
                                (annotation.parameterValues.getValue("transferMode") as AnnotationEnumValue).valueName
                            ),
                            transferChannel = annotation.parameterValues.getValue("transferChannel") as Int,
                        )
                    }

            @Suppress("UNCHECKED_CAST")
            fun signalParameterNames(signal: LogicalSignal): List<String> {
                val explicitParameterNames = policy.findAnnotation(signal, Emit::class)
                    ?.parameterValues
                    ?.getValue("parameters") as? Array<String>
                val typeSignature = signal.getter?.typeSignature?.resultType ?: signal.fieldInfo?.typeSignature
                val parameterCount = (typeSignature as? ClassRefTypeSignature)?.typeArguments?.size ?: 0

                return explicitParameterNames?.toList() ?: List(parameterCount) { index ->
                    "param${index + 1}"
                }
            }

            fun mapFunction(method: LogicalMethod): RegisteredFunction {
                val methodInfo = method.methodInfo
                val parameters = methodInfo.parameterInfo.mapIndexed { index, parameter ->
                    ValueParameter(
                        parameter.name ?: "arg$index",
                        typeMapper.mapParameter(parameter),
                    )
                }

                return RegisteredFunction(
                    fqName = methodInfo.registrationFqName,
                    parameters = parameters,
                    returnType = typeMapper.mapRaw(
                        rawDescriptor = methodInfo.returnRawDescriptor(),
                        typeArguments = methodInfo.returnTypeArguments(),
                    ),
                    rpcConfig = functionRpcConfig(method),
                    notification = notification(method),
                )
            }

            fun notification(method: LogicalMethod): Int? =
                (policy.findAnnotation(method, Notification::class)
                    ?.parameterValues
                    ?.getValue("value") as? Long)?.toInt()

            fun mapProperty(
                property: LogicalProperty,
                owner: ClassInfo,
            ): RegisteredProperty =
                JvmLanguage.forClass(owner).let { language ->
                    val bindingKind = language.propertyBindingFor(property)
                    RegisteredProperty(
                        fqName = "${owner.registrationFqName}.${property.name}",
                        type = mapPropertyType(property),
                        bindingKind = bindingKind,
                        getterFqName = property.getter?.registrationFqName
                            ?.takeIf { bindingKind == RegisteredPropertyBindingKind.ACCESSOR_METHODS },
                        setterFqName = property.setter?.registrationFqName
                            ?.takeIf { bindingKind == RegisteredPropertyBindingKind.ACCESSOR_METHODS },
                        getterName = property.getter?.name
                            ?.takeIf { bindingKind == RegisteredPropertyBindingKind.ACCESSOR_METHODS },
                        setterName = property.setter?.name
                            ?.takeIf { bindingKind == RegisteredPropertyBindingKind.ACCESSOR_METHODS },
                        isMutable = property.setter != null || (property.getter == null && property.fieldInfo?.isFinal == false),
                        isLateinit = property.isLateinit,
                        isOverridee = listOfNotNull(property.getter, property.setter)
                            .any { methodInfo -> methodInfo.methodSignature in superMethodSignaturesOf(owner) },
                        isExported = policy.isPropertyExported(property),
                        hints = collectPropertyHints(
                            rawDescriptor = property.rawDescriptor(),
                            typeArguments = property.typeArguments(),
                            annotations = property.annotations,
                        ),
                    )
                }

            fun mapSignal(
                signal: LogicalSignal,
                owner: ClassInfo,
            ): RegisteredSignal {
                val type = typeMapper.mapRaw(
                    rawDescriptor = signal.rawDescriptor(),
                    typeArguments = signal.typeArguments(),
                )

                return RegisteredSignal(
                    name = signal.name,
                    type = type,
                    parameterTypes = type.genericArguments,
                    parameterNames = signalParameterNames(signal),
                    isOverridee = signal.getter?.methodSignature in superMethodSignaturesOf(owner),
                )
            }

            private fun mapPropertyType(property: LogicalProperty): Type =
                typeMapper.mapPropertyType(
                    rawDescriptor = property.rawDescriptor(),
                    typeArguments = property.typeArguments(),
                    isLateinit = property.isLateinit,
                    isNotNullAnnotated = property.annotations.any { annotation -> annotation.name == NotNull::class.java.name },
                )

            private fun collectPropertyHints(
                rawDescriptor: String,
                typeArguments: List<TypeArgument>,
                annotations: Collection<AnnotationInfo>,
            ): List<PropertyHint> {
                val annotationHints = annotations.mapNotNull(AnnotationMapper::toPropertyHint)
                val typeHint = inferEnumHintFromType(rawDescriptor, typeArguments)
                return annotationHints + listOfNotNull(typeHint)
            }

            private fun inferEnumHintFromType(
                rawDescriptor: String,
                typeArguments: List<TypeArgument>,
            ): PropertyHint? {
                val typeClassInfo = context.getClassInfoOrNull(rawDescriptor) ?: return null

                fun containedEnum(): ClassInfo? = typeArguments.firstOrNull()
                    ?.let { typeArgument -> context.getClassInfoOrNull(typeArgument.typeSignature.toString()) }
                    ?.takeIf { contained -> contained.isEnum }

                return when {
                    typeClassInfo.isEnum -> EnumHintStringHint(
                        enumType = typeMapper.mapRaw(rawDescriptor, emptyList()),
                        entryCount = typeClassInfo.enumEntryCount,
                    )

                    typeClassInfo.isProcessorBitField -> containedEnum()?.let { enum ->
                        EnumFlagHintStringHint(
                            enumType = typeMapper.mapRaw(enum.name, emptyList()),
                            entryCount = enum.enumEntryCount,
                        )
                    }

                    rawDescriptor.startsWith("kotlin.collections") || rawDescriptor.startsWith("java.util.") ->
                        containedEnum()?.let { enum ->
                            EnumListHintStringHint(
                                enumType = typeMapper.mapRaw(enum.name, emptyList()),
                                entryCount = enum.enumEntryCount,
                            )
                        }

                    else -> null
                }
            }

            private fun LogicalProperty.rawDescriptor(): String =
                getter?.returnRawDescriptor() ?: requireNotNull(fieldInfo).rawDescriptor()

            private fun LogicalProperty.typeArguments(): List<TypeArgument> =
                getter?.returnTypeArguments() ?: requireNotNull(fieldInfo).typeArguments()

            private fun LogicalSignal.rawDescriptor(): String =
                getter?.returnRawDescriptor() ?: requireNotNull(fieldInfo).rawDescriptor()

            private fun LogicalSignal.typeArguments(): List<TypeArgument> =
                getter?.returnTypeArguments() ?: requireNotNull(fieldInfo).typeArguments()

            private fun superMethodSignaturesOf(classInfo: ClassInfo): Set<String> =
                context.getOrPutHierarchyMethodSignatures(classInfo) {
                    classInfo.superMethodSignatures()
                }
        }
    }
}

private fun LogicalClassShape.accessorPropertiesByMethod(): Map<MethodInfo, List<LogicalProperty>> =
    properties
        .flatMap { property -> property.accessorMethods().map { methodInfo -> methodInfo to property } }
        .groupBy(keySelector = { (methodInfo, _) -> methodInfo }, valueTransform = { (_, property) -> property })

private fun LogicalProperty.accessorMethods(): List<MethodInfo> =
    listOfNotNull(getter, setter)

private fun ScanResult.rootGodotClasses(): List<ClassInfo> =
    getSubclasses(KtObject::class.java)
        .filter(ClassInfo::isCustomGodotClass)

private fun ScanResult.dirtyGodotClasses(dirtyClassNames: Set<String>): List<ClassInfo> =
    dirtyClassNames
        .asSequence()
        .mapNotNull(::getClassInfo)
        .filter(ClassInfo::isCustomGodotClass)
        .toList()

private fun ClassInfo.isCustomGodotClass(): Boolean =
    superclasses.any { superclass -> superclass.name == KtObject::class.java.name } &&
        !hasAnnotation(GodotBaseType::class.java.name)
