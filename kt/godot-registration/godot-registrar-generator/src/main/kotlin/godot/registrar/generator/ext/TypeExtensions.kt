package godot.registrar.generator.ext

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import godot.api.Resource
import godot.core.Callable
import godot.core.Dictionary
import godot.core.Signal
import godot.core.VariantArray
import godot.core.VariantCaster
import godot.core.VariantParser
import godot.registrar.generator.GeneratorContext
import godot.registration.model.types.GodotBaseClass
import godot.registration.model.types.ScriptClass
import godot.registration.model.types.TYPE_VOID
import godot.registration.model.types.Type
import godot.registration.model.types.Type.Companion.aabbType
import godot.registration.model.types.Type.Companion.basisType
import godot.registration.model.types.Type.Companion.booleanType
import godot.registration.model.types.Type.Companion.byteType
import godot.registration.model.types.Type.Companion.callableType
import godot.registration.model.types.Type.Companion.colorType
import godot.registration.model.types.Type.Companion.dictionaryType
import godot.registration.model.types.Type.Companion.doubleType
import godot.registration.model.types.Type.Companion.floatType
import godot.registration.model.types.Type.Companion.intType
import godot.registration.model.types.Type.Companion.longType
import godot.registration.model.types.Type.Companion.naturalType
import godot.registration.model.types.Type.Companion.nilType
import godot.registration.model.types.Type.Companion.nodePathType
import godot.registration.model.types.Type.Companion.packedByteArrayType
import godot.registration.model.types.Type.Companion.packedColorArrayType
import godot.registration.model.types.Type.Companion.packedFloat32ArrayType
import godot.registration.model.types.Type.Companion.packedFloat64ArrayType
import godot.registration.model.types.Type.Companion.packedInt32ArrayType
import godot.registration.model.types.Type.Companion.packedInt64ArrayType
import godot.registration.model.types.Type.Companion.packedStringArrayType
import godot.registration.model.types.Type.Companion.packedVector2ArrayType
import godot.registration.model.types.Type.Companion.packedVector3ArrayType
import godot.registration.model.types.Type.Companion.packedVector4ArrayType
import godot.registration.model.types.Type.Companion.planeType
import godot.registration.model.types.Type.Companion.projectionType
import godot.registration.model.types.Type.Companion.quaternionType
import godot.registration.model.types.Type.Companion.realType
import godot.registration.model.types.Type.Companion.rect2Type
import godot.registration.model.types.Type.Companion.rect2iType
import godot.registration.model.types.Type.Companion.ridType
import godot.registration.model.types.Type.Companion.shortType
import godot.registration.model.types.Type.Companion.signalType
import godot.registration.model.types.Type.Companion.stringNameType
import godot.registration.model.types.Type.Companion.stringType
import godot.registration.model.types.Type.Companion.transform2DType
import godot.registration.model.types.Type.Companion.transform3DType
import godot.registration.model.types.Type.Companion.variantArrayType
import godot.registration.model.types.Type.Companion.vector2Type
import godot.registration.model.types.Type.Companion.vector2iType
import godot.registration.model.types.Type.Companion.vector3Type
import godot.registration.model.types.Type.Companion.vector3iType
import godot.registration.model.types.Type.Companion.vector4Type
import godot.registration.model.types.Type.Companion.vector4iType
import godot.registration.model.types.TypeKind
import godot.tools.common.constants.GODOT_AABB
import godot.tools.common.constants.GODOT_ARRAY
import godot.tools.common.constants.GODOT_BASIS
import godot.tools.common.constants.GODOT_BOOL
import godot.tools.common.constants.GODOT_CALLABLE
import godot.tools.common.constants.GODOT_COLOR
import godot.tools.common.constants.GODOT_DICTIONARY
import godot.tools.common.constants.GODOT_FLOAT
import godot.tools.common.constants.GODOT_INT
import godot.tools.common.constants.GODOT_NIL
import godot.tools.common.constants.GODOT_NODE_PATH
import godot.tools.common.constants.GODOT_OBJECT
import godot.tools.common.constants.GODOT_PACKED_BYTE_ARRAY
import godot.tools.common.constants.GODOT_PACKED_COLOR_ARRAY
import godot.tools.common.constants.GODOT_PACKED_FLOAT32_ARRAY
import godot.tools.common.constants.GODOT_PACKED_FLOAT64_ARRAY
import godot.tools.common.constants.GODOT_PACKED_INT32_ARRAY
import godot.tools.common.constants.GODOT_PACKED_INT64_ARRAY
import godot.tools.common.constants.GODOT_PACKED_STRING_ARRAY
import godot.tools.common.constants.GODOT_PACKED_VECTOR2_ARRAY
import godot.tools.common.constants.GODOT_PACKED_VECTOR3_ARRAY
import godot.tools.common.constants.GODOT_PACKED_VECTOR4_ARRAY
import godot.tools.common.constants.GODOT_PLANE
import godot.tools.common.constants.GODOT_PROJECTION
import godot.tools.common.constants.GODOT_QUATERNION
import godot.tools.common.constants.GODOT_RECT2
import godot.tools.common.constants.GODOT_RECT2I
import godot.tools.common.constants.GODOT_RID
import godot.tools.common.constants.GODOT_SIGNAL
import godot.tools.common.constants.GODOT_STRING
import godot.tools.common.constants.GODOT_STRING_NAME
import godot.tools.common.constants.GODOT_TRANSFORM2D
import godot.tools.common.constants.GODOT_TRANSFORM3D
import godot.tools.common.constants.GODOT_VECTOR2
import godot.tools.common.constants.GODOT_VECTOR2I
import godot.tools.common.constants.GODOT_VECTOR3
import godot.tools.common.constants.GODOT_VECTOR3I
import godot.tools.common.constants.GODOT_VECTOR4
import godot.tools.common.constants.GODOT_VECTOR4I
import godot.tools.common.constants.godotApiPackage
import godot.tools.common.constants.isFromPackage

private data class TypeMetadata(
    val variantMember: MemberName,
    val variantTypeOrdinal: Int,
    val godotCoreTypeName: String?,
    val godotClassName: String?
)

private object TypeMetadataRegistry {
    private fun parserMetadata(
        memberName: String,
        godotTypeName: String,
        godotClassName: String? = godotTypeName,
    ) = TypeMetadata(
        variantMember = MemberName(VariantParser::class.asClassName(), memberName),
        variantTypeOrdinal = VariantParser.valueOf(memberName).id,
        godotCoreTypeName = godotTypeName,
        godotClassName = godotClassName,
    )

    private fun casterMetadata(
        memberName: String,
        godotTypeName: String,
        godotClassName: String? = godotTypeName,
    ) = TypeMetadata(
        variantMember = MemberName(VariantCaster::class.asClassName(), memberName),
        variantTypeOrdinal = when (memberName) {
            "ANY" -> VariantParser.NIL.id
            "BYTE", "INT", "ENUM" -> VariantParser.LONG.id
            "FLOAT" -> VariantParser.DOUBLE.id
            else -> error("Unsupported caster metadata member $memberName")
        },
        godotCoreTypeName = godotTypeName,
        godotClassName = godotClassName,
    )

    private val knownMetadataByType = linkedMapOf(
        nilType to parserMetadata("NIL", GODOT_NIL, ""),
        booleanType to parserMetadata("BOOL", GODOT_BOOL),
        byteType to casterMetadata("BYTE", GODOT_INT),
        shortType to parserMetadata("LONG", GODOT_INT),
        intType to casterMetadata("INT", GODOT_INT),
        naturalType to parserMetadata("LONG", GODOT_INT),
        longType to parserMetadata("LONG", GODOT_INT),
        floatType to casterMetadata("FLOAT", GODOT_FLOAT),
        realType to parserMetadata("DOUBLE", GODOT_FLOAT),
        doubleType to parserMetadata("DOUBLE", GODOT_FLOAT),
        stringType to parserMetadata("STRING", GODOT_STRING),
        Type.anyType to casterMetadata("ANY", GODOT_NIL, ""),
        vector2Type to parserMetadata("VECTOR2", GODOT_VECTOR2),
        vector2iType to parserMetadata("VECTOR2I", GODOT_VECTOR2I),
        rect2Type to parserMetadata("RECT2", GODOT_RECT2),
        rect2iType to parserMetadata("RECT2I", GODOT_RECT2I),
        vector3Type to parserMetadata("VECTOR3", GODOT_VECTOR3),
        vector3iType to parserMetadata("VECTOR3I", GODOT_VECTOR3I),
        transform2DType to parserMetadata("TRANSFORM2D", GODOT_TRANSFORM2D),
        vector4Type to parserMetadata("VECTOR4", GODOT_VECTOR4),
        vector4iType to parserMetadata("VECTOR4I", GODOT_VECTOR4I),
        planeType to parserMetadata("PLANE", GODOT_PLANE),
        quaternionType to parserMetadata("QUATERNION", GODOT_QUATERNION),
        aabbType to parserMetadata("AABB", GODOT_AABB),
        basisType to parserMetadata("BASIS", GODOT_BASIS),
        transform3DType to parserMetadata("TRANSFORM3D", GODOT_TRANSFORM3D),
        projectionType to parserMetadata("PROJECTION", GODOT_PROJECTION),
        colorType to parserMetadata("COLOR", GODOT_COLOR),
        stringNameType to parserMetadata("STRING_NAME", GODOT_STRING_NAME),
        nodePathType to parserMetadata("NODE_PATH", GODOT_NODE_PATH),
        ridType to parserMetadata("_RID", GODOT_RID),
        callableType to parserMetadata("CALLABLE", GODOT_CALLABLE),
        signalType to parserMetadata("SIGNAL", GODOT_SIGNAL),
        dictionaryType to parserMetadata("DICTIONARY", GODOT_DICTIONARY),
        variantArrayType to parserMetadata("ARRAY", GODOT_ARRAY),
        packedByteArrayType to parserMetadata("PACKED_BYTE_ARRAY", GODOT_PACKED_BYTE_ARRAY),
        packedInt32ArrayType to parserMetadata("PACKED_INT_32_ARRAY", GODOT_PACKED_INT32_ARRAY),
        packedInt64ArrayType to parserMetadata("PACKED_INT_64_ARRAY", GODOT_PACKED_INT64_ARRAY),
        packedFloat32ArrayType to parserMetadata("PACKED_FLOAT_32_ARRAY", GODOT_PACKED_FLOAT32_ARRAY),
        packedFloat64ArrayType to parserMetadata("PACKED_FLOAT_64_ARRAY", GODOT_PACKED_FLOAT64_ARRAY),
        packedStringArrayType to parserMetadata("PACKED_STRING_ARRAY", GODOT_PACKED_STRING_ARRAY),
        packedVector2ArrayType to parserMetadata("PACKED_VECTOR2_ARRAY", GODOT_PACKED_VECTOR2_ARRAY),
        packedVector3ArrayType to parserMetadata("PACKED_VECTOR3_ARRAY", GODOT_PACKED_VECTOR3_ARRAY),
        packedColorArrayType to parserMetadata("PACKED_COLOR_ARRAY", GODOT_PACKED_COLOR_ARRAY),
        packedVector4ArrayType to parserMetadata("PACKED_VECTOR4_ARRAY", GODOT_PACKED_VECTOR4_ARRAY),
    )

    private fun isAssignableTo(type: Type, target: Class<*>): Boolean = runCatching {
        target.isAssignableFrom(Class.forName(type.fqName))
    }.getOrDefault(false)

    private fun canonicalKey(type: Type): Type? = when (type.kind) {
        TypeKind.PRIMITIVE,
        TypeKind.CORE_TYPE,
            -> when {
            type.fqName == callableType.fqName || isAssignableTo(type, Callable::class.java) -> callableType
            type.fqName == signalType.fqName || isAssignableTo(type, Signal::class.java) -> signalType
            type.kind == TypeKind.PRIMITIVE -> Type.findPrimitiveType(type.fqName)
            else -> Type.findCoreType(type.fqName)
        }

        TypeKind.OTHER -> when (type.fqName) {
            TYPE_VOID -> nilType
            Any::class.qualifiedName,
            java.lang.Object::class.qualifiedName,
                -> Type.anyType
            else -> null
        }

        else -> null
    }

    fun metadataOrNull(type: Type): TypeMetadata? = when (type.kind) {
        TypeKind.PRIMITIVE,
        TypeKind.CORE_TYPE,
            -> knownMetadataByType[canonicalKey(type)]

        TypeKind.OTHER -> knownMetadataByType[canonicalKey(type)]
        else -> null
    }

    fun metadata(type: Type): TypeMetadata = metadataOrNull(type) ?: when (type.kind) {
        TypeKind.ENUM -> casterMetadata(
            memberName = "ENUM",
            godotTypeName = GODOT_INT,
            godotClassName = type.name,
        )

        TypeKind.BITFIELD -> parserMetadata(
            memberName = "LONG",
            godotTypeName = GODOT_INT,
        )

        TypeKind.GODOT_CLASS,
        TypeKind.INTERFACE,
            -> parserMetadata(
            memberName = "OBJECT",
            godotTypeName = GODOT_OBJECT,
            godotClassName = if (type.fqName == Any::class.qualifiedName) "" else null,
        )

        TypeKind.COLLECTION -> parserMetadata(
            memberName = "ARRAY",
            godotTypeName = GODOT_ARRAY,
        )

        TypeKind.OTHER -> error("Unrecognized type ${type.fqName}, it cannot be represented by Godot")

        TypeKind.PRIMITIVE,
        TypeKind.CORE_TYPE,
            -> error("Unsupported known type ${type.fqName}")
    }
}

private fun typeVariantTypeOrdinal(type: Type): Int? = when (type.kind) {
    TypeKind.PRIMITIVE,
    TypeKind.CORE_TYPE,
    TypeKind.OTHER,
        -> TypeMetadataRegistry.metadataOrNull(type)?.variantTypeOrdinal

    TypeKind.ENUM,
    TypeKind.BITFIELD,
        -> VariantParser.LONG.id

    TypeKind.GODOT_CLASS,
    TypeKind.INTERFACE,
        -> VariantParser.OBJECT.id

    TypeKind.COLLECTION -> VariantParser.ARRAY.id
}

fun Type.toKtVariantMemberName(): MemberName = TypeMetadataRegistry.metadata(this).variantMember

/** Maps a model [Type] to the Godot class name used in generated registration code. */
fun Type.toGodotClassName(
    context: GeneratorContext,
): String = when {
    TypeMetadataRegistry.metadata(this).godotClassName != null -> TypeMetadataRegistry.metadata(this).godotClassName!!
    else -> registeredOrBaseGodotClassName(context)
}

fun Type.getAsVariantTypeOrdinal(): Int = requireNotNull(typeVariantTypeOrdinal(this)) {
    "Unsupported variant type ordinal for $fqName"
}

fun Type.getGodotCoreTypeName(): String =
    requireNotNull(TypeMetadataRegistry.metadata(this).godotCoreTypeName) { "Unsupported fq type $fqName" }

fun Type.toTypeName(): TypeName = ClassName(
    fqName.substringBeforeLast("."),
    fqName.substringAfterLast(".")
)

fun <T : Enum<T>> T.asEnumName() = MemberName(this::class.asClassName(), this.name)

private fun Type.isSubtypeOf(target: Class<*>): Boolean = runCatching {
    target.isAssignableFrom(Class.forName(fqName))
}.getOrDefault(false)

fun Type.baseGodotType(): Type? {
    if (fqName.isFromPackage(godotApiPackage)) return this

    val loadedClass = runCatching { Class.forName(fqName) }.getOrNull() ?: return null
    var currentClass: Class<*>? = loadedClass.superclass
    while (currentClass != null) {
        if (currentClass.name.isFromPackage(godotApiPackage)) {
            return GodotBaseClass(currentClass.name)
        }
        currentClass = currentClass.superclass
    }

    return null
}

fun Type.isCompatibleList(): Boolean = isSubtypeOf(VariantArray::class.java)

fun Type.isDictionary(): Boolean = isSubtypeOf(Dictionary::class.java)

fun Type.isResource(): Boolean =
    fqName == requireNotNull(Resource::class.qualifiedName) || baseGodotType()?.fqName == Resource::class.qualifiedName

private fun Type.registeredOrBaseGodotClassName(context: GeneratorContext): String {
    val baseGodotType = baseGodotType()
    if (baseGodotType != null) {
        return (this as? ScriptClass)
            ?.takeIf { scriptClass -> scriptClass.isRegistered }
            ?.getRegisteredName(context.settings)
            ?: context.registeredClassesByFqName[fqName]?.getRegisteredName(context.settings)
            ?: baseGodotType.fqName.substringAfterLast(".")
    }

    return fqName.substringAfterLast(".")
        .ifEmpty { GODOT_NIL }
        .let { if (it == "Object") GODOT_OBJECT else it }
}
