package godot.intellij.plugin.analysis.kotlin

import godot.annotation.ColorNoAlpha
import godot.annotation.Dir
import godot.annotation.ExpEasing
import godot.annotation.File
import godot.annotation.FloatRange
import godot.annotation.IntFlag
import godot.annotation.IntRange
import godot.annotation.MultilineText
import godot.annotation.PlaceHolderText
import godot.core.Color
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.project.fqName
import godot.intellij.plugin.project.withType
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.scripting.resolve.classId
import kotlin.reflect.KClass

object PropertyHintAnalyzer {
    fun analyze(property: KtProperty): List<GodotProblem> {
        return when {
            property.findAnnotation(IntRange::class.classId) != null -> {
                checkIntRange(property)
            }

            property.findAnnotation(FloatRange::class.classId) != null -> {
                checkRealTypeProperty(property, FloatRange::class)
            }

            property.findAnnotation(ExpEasing::class.classId) != null -> {
                checkRealTypeProperty(property, ExpEasing::class)
            }

            property.findAnnotation(IntFlag::class.classId) != null -> {
                checkIntFlag(property)
            }

            property.findAnnotation(File::class.classId) != null -> {
                checkStringPropertyType(property, File::class)
            }

            property.findAnnotation(Dir::class.classId) != null -> {
                checkStringPropertyType(property, Dir::class)
            }

            property.findAnnotation(MultilineText::class.classId) != null -> {
                checkStringPropertyType(property, MultilineText::class)
            }

            property.findAnnotation(PlaceHolderText::class.classId) != null -> {
                checkStringPropertyType(property, PlaceHolderText::class)
            }

            property.findAnnotation(ColorNoAlpha::class.classId) != null -> {
                checkColorNoAlpha(property)
            }

            else -> emptyList()
        }
    }

    private fun checkColorNoAlpha(property: KtProperty): List<GodotProblem> {
        if (property.fqName() == Color::class.qualifiedName!!) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.property.hint.wrongType", Color::class.qualifiedName!!),
                property.findAnnotation(ColorNoAlpha::class.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }

    private fun checkStringPropertyType(property: KtProperty, annotation: KClass<*>): List<GodotProblem> {
        if (property.fqName() == String::class.qualifiedName) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.property.hint.wrongType", String::class.qualifiedName!!),
                property.findAnnotation(annotation.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }

    private fun checkIntFlag(property: KtProperty): List<GodotProblem> {
        val isInt = property.withType { propertyType -> propertyType.isIntType }
        if (isInt) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.property.hint.wrongType", Int::class.qualifiedName!!),
                property.findAnnotation(IntFlag::class.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }

    private fun checkRealTypeProperty(property: KtProperty, annotation: KClass<*>): List<GodotProblem> {
        val isRealType = property.withType { propertyType ->
            propertyType.isFloatType || propertyType.isDoubleType
        }
        if (isRealType) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.property.hint.wrongType", "${Float::class.qualifiedName!!} or ${Double::class.qualifiedName!!}"),
                property.findAnnotation(annotation.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }

    private fun checkIntRange(property: KtProperty): List<GodotProblem> {
        val isIntegerType = property.withType { propertyType ->
            propertyType.isByteType || propertyType.isShortType || propertyType.isIntType || propertyType.isLongType
        }
        if (isIntegerType) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message(
                    "problem.property.hint.wrongType",
                    "${Byte::class.qualifiedName!!}, ${Short::class.qualifiedName!!}, ${Int::class.qualifiedName!!} or ${Long::class.qualifiedName!!}"
                ),
                property.findAnnotation(IntRange::class.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }
}
