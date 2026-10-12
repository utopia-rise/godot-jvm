package godot.codegen.models.traits

import godot.codegen.constants.Core
import godot.codegen.constants.GodotMeta
import godot.codegen.constants.TypeIdentifier
import godot.codegen.constants.Utils
import java.util.*

interface WithDefaultValueTrait : MetaGenerationTrait {
    val defaultValue: String?


    fun getDefaultValue(): Pair<String, Array<Any?>>? {
        val defaultValueString = defaultValue ?: return null
        val identifier = type.identifier
        return when {
            type.isNullable() && defaultValue == "null" -> defaultValueString to arrayOf()
            identifier == TypeIdentifier.COLOR.name -> "${TypeIdentifier.COLOR.name}($defaultValueString)" to arrayOf()
            identifier == TypeIdentifier.VARIANT.name -> defaultValueString to arrayOf()
            type.isObjectSubClass() -> null
            identifier == TypeIdentifier.BOOL.name -> defaultValueString.lowercase(Locale.US) to arrayOf()
            identifier == TypeIdentifier.FLOAT.name && meta == GodotMeta.Float.float -> "${intToFloat(defaultValueString)}f" to arrayOf()
            identifier == TypeIdentifier.FLOAT.name -> intToFloat(defaultValueString) to arrayOf()
            identifier == TypeIdentifier.STRING_NAME.name -> "${TypeIdentifier.STRING_NAME.name}(".plus(defaultValueString.replace("&", ""))
                .plus(")") to arrayOf()

            identifier == TypeIdentifier.ARRAY.name || type.isTypedArray() ->
                if (defaultValueString.startsWith("Array")) {
                    val defaultArrayValues = defaultValueString
                        .replace("Array.*\\(\\[".toRegex(), "")
                        .removeSuffix("])")
                    "${Utils.variantArrayOf.canonicalName}(".plus(defaultArrayValues).plus(")")
                } else {
                    "${Utils.variantArrayOf.canonicalName}("
                        .plus(defaultValueString.removePrefix("[").removeSuffix("]"))
                        .plus(")")
                } to arrayOf()

            identifier == Core.rect2.simpleName -> defaultValueString
                .replace(",", ".0,")
                .replace(")", ".0)") to arrayOf()

            identifier == Core.callable.simpleName -> "%T()" to arrayOf(Core.variantCallable)

            identifier == Core.rid.simpleName ||
                identifier == Core.dictionary.simpleName ||
                identifier == Core.transform2D.simpleName ||
                identifier == Core.transform3D.simpleName ||
                identifier == Core.packedByteArray.simpleName ||
                identifier == Core.packedColorArray.simpleName ||
                identifier == Core.packedFloat32Array.simpleName ||
                identifier == Core.packedFloat64Array.simpleName ||
                identifier == Core.packedStringArray.simpleName ||
                identifier == Core.packedInt32Array.simpleName ||
                identifier == Core.packedInt64Array.simpleName ||
                identifier == Core.packedVector2Array.simpleName ||
                identifier == Core.packedVector3Array.simpleName
                -> "$identifier()" to arrayOf()

            else -> defaultValueString to arrayOf()
        }
    }

    private fun intToFloat(defaultValue: String): String {
        if (defaultValue.indexOf('.') != -1) return defaultValue
        return "$defaultValue.0"
    }
}

