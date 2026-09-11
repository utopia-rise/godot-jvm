package godot.registrar.generator.ext

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.joinToCode
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

/** Everything the registrar needs to know about how a model [Type] maps to Godot. */
private class TypeMetadata(
    /** The `VariantConverter` expression passed to the registrar, complete with enum entries and container arguments. */
    val converter: CodeBlock,
    val variantTypeOrdinal: Int,
    val godotCoreTypeName: String?,
    val godotClassName: String?,
)

/**
 * Single source of truth for the Godot mapping of a type. The processor and the model checks guarantee that every type
 * reaching the generator is Godot compatible, so an unknown type here is a bug upstream, never a fallback case.
 */
private object TypeMetadataRegistry {
    private val parserClass = VariantParser::class.asClassName()
    private val casterClass = VariantCaster::class.asClassName()

    private fun singleton(parser: VariantParser, godotTypeName: String, godotClassName: String? = godotTypeName) = TypeMetadata(
        converter = CodeBlock.of("%M", MemberName(parserClass, parser.name)),
        variantTypeOrdinal = parser.id,
        godotCoreTypeName = godotTypeName,
        godotClassName = godotClassName,
    )

    private fun singleton(caster: VariantCaster, godotTypeName: String, godotClassName: String? = godotTypeName) = TypeMetadata(
        converter = CodeBlock.of("%M", MemberName(casterClass, caster::class.simpleName!!)),
        variantTypeOrdinal = caster.id,
        godotCoreTypeName = godotTypeName,
        godotClassName = godotClassName,
    )

    /** A stateful caster instantiated by the registrar: `VariantCaster.<name>(<arguments>)`. */
    private fun instantiated(
        name: String,
        coreVariant: VariantParser,
        godotTypeName: String,
        godotClassName: String? = godotTypeName,
        vararg arguments: CodeBlock,
    ) = TypeMetadata(
        converter = CodeBlock.of("%M(%L)", MemberName(casterClass, name), arguments.toList().joinToCode()),
        variantTypeOrdinal = coreVariant.id,
        godotCoreTypeName = godotTypeName,
        godotClassName = godotClassName,
    )

    private val knownMetadataByType = linkedMapOf(
        nilType to singleton(VariantParser.NIL, GODOT_NIL, ""),
        booleanType to singleton(VariantParser.BOOL, GODOT_BOOL),
        byteType to singleton(VariantCaster.BYTE, GODOT_INT),
        shortType to singleton(VariantParser.LONG, GODOT_INT),
        intType to singleton(VariantCaster.INT, GODOT_INT),
        naturalType to singleton(VariantParser.LONG, GODOT_INT),
        longType to singleton(VariantParser.LONG, GODOT_INT),
        floatType to singleton(VariantCaster.FLOAT, GODOT_FLOAT),
        realType to singleton(VariantParser.DOUBLE, GODOT_FLOAT),
        doubleType to singleton(VariantParser.DOUBLE, GODOT_FLOAT),
        stringType to singleton(VariantParser.STRING, GODOT_STRING),
        Type.anyType to singleton(VariantCaster.ANY, GODOT_NIL, ""),
        vector2Type to singleton(VariantParser.VECTOR2, GODOT_VECTOR2),
        vector2iType to singleton(VariantParser.VECTOR2I, GODOT_VECTOR2I),
        rect2Type to singleton(VariantParser.RECT2, GODOT_RECT2),
        rect2iType to singleton(VariantParser.RECT2I, GODOT_RECT2I),
        vector3Type to singleton(VariantParser.VECTOR3, GODOT_VECTOR3),
        vector3iType to singleton(VariantParser.VECTOR3I, GODOT_VECTOR3I),
        transform2DType to singleton(VariantParser.TRANSFORM2D, GODOT_TRANSFORM2D),
        vector4Type to singleton(VariantParser.VECTOR4, GODOT_VECTOR4),
        vector4iType to singleton(VariantParser.VECTOR4I, GODOT_VECTOR4I),
        planeType to singleton(VariantParser.PLANE, GODOT_PLANE),
        quaternionType to singleton(VariantParser.QUATERNION, GODOT_QUATERNION),
        aabbType to singleton(VariantParser.AABB, GODOT_AABB),
        basisType to singleton(VariantParser.BASIS, GODOT_BASIS),
        transform3DType to singleton(VariantParser.TRANSFORM3D, GODOT_TRANSFORM3D),
        projectionType to singleton(VariantParser.PROJECTION, GODOT_PROJECTION),
        colorType to singleton(VariantParser.COLOR, GODOT_COLOR),
        stringNameType to singleton(VariantParser.STRING_NAME, GODOT_STRING_NAME),
        nodePathType to singleton(VariantParser.NODE_PATH, GODOT_NODE_PATH),
        ridType to singleton(VariantParser._RID, GODOT_RID),
        callableType to singleton(VariantParser.CALLABLE, GODOT_CALLABLE),
        signalType to singleton(VariantParser.SIGNAL, GODOT_SIGNAL),
        packedByteArrayType to singleton(VariantParser.PACKED_BYTE_ARRAY, GODOT_PACKED_BYTE_ARRAY),
        packedInt32ArrayType to singleton(VariantParser.PACKED_INT_32_ARRAY, GODOT_PACKED_INT32_ARRAY),
        packedInt64ArrayType to singleton(VariantParser.PACKED_INT_64_ARRAY, GODOT_PACKED_INT64_ARRAY),
        packedFloat32ArrayType to singleton(VariantParser.PACKED_FLOAT_32_ARRAY, GODOT_PACKED_FLOAT32_ARRAY),
        packedFloat64ArrayType to singleton(VariantParser.PACKED_FLOAT_64_ARRAY, GODOT_PACKED_FLOAT64_ARRAY),
        packedStringArrayType to singleton(VariantParser.PACKED_STRING_ARRAY, GODOT_PACKED_STRING_ARRAY),
        packedVector2ArrayType to singleton(VariantParser.PACKED_VECTOR2_ARRAY, GODOT_PACKED_VECTOR2_ARRAY),
        packedVector3ArrayType to singleton(VariantParser.PACKED_VECTOR3_ARRAY, GODOT_PACKED_VECTOR3_ARRAY),
        packedColorArrayType to singleton(VariantParser.PACKED_COLOR_ARRAY, GODOT_PACKED_COLOR_ARRAY),
        packedVector4ArrayType to singleton(VariantParser.PACKED_VECTOR4_ARRAY, GODOT_PACKED_VECTOR4_ARRAY),
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

    // A container declared without generic arguments (a Java raw type) converts its elements as Any.
    private fun argumentConverter(type: Type, index: Int): CodeBlock =
        metadata(type.genericArguments.getOrNull(index) ?: Type.anyType).converter

    fun metadata(type: Type): TypeMetadata = when {
        type.isCompatibleList() || type.kind == TypeKind.COLLECTION -> instantiated(
            "TYPED_ARRAY",
            VariantParser.ARRAY,
            GODOT_ARRAY,
            arguments = arrayOf(argumentConverter(type, 0)),
        )

        type.isDictionary() -> instantiated(
            "TYPED_DICTIONARY",
            VariantParser.DICTIONARY,
            GODOT_DICTIONARY,
            arguments = arrayOf(argumentConverter(type, 0), argumentConverter(type, 1)),
        )

        else -> when (type.kind) {
            TypeKind.PRIMITIVE,
            TypeKind.CORE_TYPE,
            TypeKind.OTHER,
                -> knownMetadataByType[canonicalKey(type)]
                ?: error("Unrecognized type ${type.fqName}, it cannot be represented by Godot")

            TypeKind.ENUM -> instantiated(
                "ENUM",
                VariantParser.LONG,
                GODOT_INT,
                type.name,
                CodeBlock.of("%T.entries.toTypedArray()", type.toTypeName()),
            )

            TypeKind.BITFIELD -> singleton(VariantParser.LONG, GODOT_INT)

            TypeKind.GODOT_CLASS,
            TypeKind.INTERFACE,
                -> singleton(
                VariantParser.OBJECT,
                GODOT_OBJECT,
                if (type.fqName == Any::class.qualifiedName) "" else null,
            )

            TypeKind.COLLECTION -> error("unreachable, handled above")
        }
    }
}

/** The `VariantConverter` expression the registrar registers for this type. */
fun Type.toKtVariantConverter(): CodeBlock = TypeMetadataRegistry.metadata(this).converter

/** Maps a model [Type] to the Godot class name used in generated registration code. */
fun Type.toGodotClassName(
    context: GeneratorContext,
): String = TypeMetadataRegistry.metadata(this).godotClassName ?: registeredOrBaseGodotClassName(context)

fun Type.getAsVariantTypeOrdinal(): Int = TypeMetadataRegistry.metadata(this).variantTypeOrdinal

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
