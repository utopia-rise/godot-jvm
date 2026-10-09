package godot.intellij.plugin.analysis.kotlin

import godot.annotation.ColorNoAlpha
import godot.annotation.Dir
import godot.annotation.DoubleRange
import godot.annotation.ExpEasing
import godot.annotation.File
import godot.annotation.FloatRange
import godot.annotation.IntFlag
import godot.annotation.IntRange
import godot.annotation.LongRange
import godot.annotation.MultilineText
import godot.annotation.PlaceHolderText
import godot.core.Color
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.project.fqName
import godot.intellij.plugin.project.withType
import godot.intellij.plugin.quickfix.PropertyNotExportedQuickFix
import godot.intellij.plugin.quickfix.PropertyNotRegisteredQuickFix
import godot.intellij.plugin.registration.registrationPolicy
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.scripting.resolve.classId
import kotlin.reflect.KClass

object PropertyHintAnalyzer {
    private val propertyNotExportedQuickFix by lazy { PropertyNotExportedQuickFix() }
    private val propertyNotRegisteredQuickFix by lazy { PropertyNotRegisteredQuickFix() }

    fun analyze(property: KtProperty): List<GodotProblem> {
        return when {
            property.findAnnotation(IntRange::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkIntRange(property)
            }

            property.findAnnotation(LongRange::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkLongRange(property)
            }

            property.findAnnotation(FloatRange::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkFloatRange(property)
            }

            property.findAnnotation(DoubleRange::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkDoubleRange(property)
            }

            property.findAnnotation(ExpEasing::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkRealTypeProperty(property, ExpEasing::class)
            }

            property.findAnnotation(IntFlag::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkIntFlag(property)
            }

            property.findAnnotation(File::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkStringPropertyType(property, File::class)
            }

            property.findAnnotation(Dir::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkStringPropertyType(property, Dir::class)
            }

            property.findAnnotation(MultilineText::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkStringPropertyType(property, MultilineText::class)
            }

            property.findAnnotation(PlaceHolderText::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkStringPropertyType(property, PlaceHolderText::class)
            }

            property.findAnnotation(ColorNoAlpha::class.classId) != null -> {
                checkForRegistrationAnnotations(property) + checkColorNoAlpha(property)
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

    private fun checkDoubleRange(property: KtProperty): List<GodotProblem> {
        val isDouble = property.withType { propertyType -> propertyType.isDoubleType }
        if (isDouble) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.property.hint.wrongType", Double::class.qualifiedName!!),
                property.findAnnotation(DoubleRange::class.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }

    private fun checkFloatRange(property: KtProperty): List<GodotProblem> {
        val isFloat = property.withType { propertyType -> propertyType.isFloatType }
        if (isFloat) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.property.hint.wrongType", Float::class.qualifiedName!!),
                property.findAnnotation(FloatRange::class.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }

    private fun checkLongRange(property: KtProperty): List<GodotProblem> {
        val isLong = property.withType { propertyType -> propertyType.isLongType }
        if (isLong) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.property.hint.wrongType", Long::class.qualifiedName!!),
                property.findAnnotation(LongRange::class.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }

    private fun checkIntRange(property: KtProperty): List<GodotProblem> {
        val isInt = property.withType { propertyType -> propertyType.isIntType }
        if (isInt) return emptyList()
        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.property.hint.wrongType", Int::class.qualifiedName!!),
                property.findAnnotation(IntRange::class.classId)?.psiOrParent
                    ?: property.nameIdentifier
                    ?: property.navigationElement
            )
        )
    }

    private fun checkForRegistrationAnnotations(property: KtProperty): List<GodotProblem> {
        val policy = property.registrationPolicy
        return buildList {
            if (!policy.registersProperty(property)) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.property.hint.notRegistered"),
                        property.nameIdentifier ?: property.navigationElement,
                        arrayOf(propertyNotRegisteredQuickFix)
                    )
                )
            } else if (!policy.exportsProperty(property)) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.property.hint.notExported"),
                        property.nameIdentifier ?: property.navigationElement,
                        arrayOf(propertyNotExportedQuickFix)
                    )
                )
            }
        }
    }
}

