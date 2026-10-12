package godot.annotation.processor.classgraph

import godot.annotation.processor.classgraph.extensions.isGodotBaseType
import godot.annotation.processor.classgraph.extensions.methodSignature
import godot.annotation.processor.classgraph.shape.LogicalClassShape
import godot.registration.model.types.GodotBaseClass
import godot.registration.model.types.ScriptFamily
import godot.registration.model.types.Type
import io.github.classgraph.AnnotationInfo
import io.github.classgraph.ClassInfo
import io.github.classgraph.MethodInfo
import io.github.classgraph.ScanResult
import io.github.classgraph.TypeArgument

class ProcessorContext(
    val scanResult: ScanResult,
    val settings: ProcessorSettings,
) {
    private val mappedFamilyByFqName = mutableMapOf<String, ScriptFamily>()
    private val mappedBaseClassByFqName = mutableMapOf<String, GodotBaseClass>()
    private val mappedTypeByKey = mutableMapOf<TypeCacheKey, Type>()
    private val godotBaseMethodSignaturesByClass = mutableMapOf<String, Set<String>>()
    private val annotationChainByAnnotationName = mutableMapOf<String, List<AnnotationInfo>>()
    private val classShapeByName = mutableMapOf<String, LogicalClassShape>()


    fun getClassInfoOrNull(fqName: String): ClassInfo? = scanResult.getClassInfo(fqName)

    fun getOrPutMappedFamily(fqName: String, family: () -> ScriptFamily): ScriptFamily =
        mappedFamilyByFqName.getOrPut(fqName, family)

    fun getOrPutMappedBaseClass(fqName: String, baseClass: () -> GodotBaseClass): GodotBaseClass =
        mappedBaseClassByFqName.getOrPut(fqName, baseClass)

    fun getOrPutMappedType(
        classInfo: ClassInfo,
        typeArguments: List<TypeArgument>,
        type: () -> Type,
    ): Type =
        mappedTypeByKey.getOrPut(
            TypeCacheKey(
                fqName = classInfo.name,
                typeArgumentDescriptors = typeArguments.map(TypeArgument::toString),
            ),
            type,
        )

    // Every method a Godot base class declares or inherits from the other Godot base classes, computed once per base class.
    fun godotBaseMethodSignatures(baseClass: ClassInfo): Set<String> =
        godotBaseMethodSignaturesByClass.getOrPut(baseClass.name) {
            val signatures = baseClass.methodInfo.mapTo(mutableSetOf(), MethodInfo::methodSignature)
            baseClass.superclass?.takeIf(ClassInfo::isGodotBaseType)?.let { parent -> signatures += godotBaseMethodSignatures(parent) }
            signatures
        }

    fun getOrPutAnnotationChain(annotationInfo: AnnotationInfo, annotations: () -> List<AnnotationInfo>): List<AnnotationInfo> =
        annotationChainByAnnotationName.getOrPut(annotationInfo.name, annotations)

    fun getOrPutClassShape(classInfo: ClassInfo, shape: () -> LogicalClassShape): LogicalClassShape =
        classShapeByName.getOrPut(classInfo.name, shape)
}

private data class TypeCacheKey(
    val fqName: String,
    val typeArgumentDescriptors: List<String>,
)
