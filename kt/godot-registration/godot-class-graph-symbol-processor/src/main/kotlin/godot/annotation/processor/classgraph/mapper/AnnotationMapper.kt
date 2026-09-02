package godot.annotation.processor.classgraph.mapper

import godot.annotation.ColorNoAlpha
import godot.annotation.Dir
import godot.annotation.DoubleRange
import godot.annotation.ExpEasing
import godot.annotation.Category
import godot.annotation.Group
import godot.annotation.Subgroup
import godot.annotation.File
import godot.annotation.FloatRange
import godot.annotation.HintString
import godot.annotation.IntFlag
import godot.annotation.IntRange
import godot.annotation.LongRange
import godot.annotation.MultilineText
import godot.annotation.PlaceHolderText
import godot.common.extensions.convertToSnakeCase
import godot.registration.model.hint.property.ColorNoAlphaHint
import godot.registration.model.hint.property.DirHint
import godot.registration.model.hint.property.ExpEasingHint
import godot.registration.model.hint.property.FileHint
import godot.registration.model.hint.property.HintStringHint
import godot.registration.model.hint.property.IntFlagHint
import godot.registration.model.hint.property.MultilineTextHint
import godot.registration.model.hint.property.PlaceHolderTextHint
import godot.registration.model.hint.property.PropertyHint
import godot.registration.model.hint.property.Range
import godot.registration.model.hint.property.RangeHint
import godot.registration.model.PropertyGroup
import godot.registration.model.PropertyGroupKind
import io.github.classgraph.AnnotationEnumValue
import io.github.classgraph.AnnotationInfo

object AnnotationMapper {
    fun toPropertyGroup(annotationInfo: AnnotationInfo): PropertyGroup? =
        when (annotationInfo.name) {
            Category::class.java.name -> PropertyGroup(
                kind = PropertyGroupKind.CATEGORY,
                name = annotationInfo.parameterValues.getValue("name") as String,
                prefix = "",
            )

            Group::class.java.name -> PropertyGroup(
                kind = PropertyGroupKind.GROUP,
                name = annotationInfo.parameterValues.getValue("name") as String,
                prefix = annotationInfo.groupPrefix(),
            )

            Subgroup::class.java.name -> PropertyGroup(
                kind = PropertyGroupKind.SUBGROUP,
                name = annotationInfo.parameterValues.getValue("name") as String,
                prefix = annotationInfo.groupPrefix(),
            )

            else -> null
        }

    private fun AnnotationInfo.groupPrefix(): String {
        val name = parameterValues.getValue("name") as String
        val prefix = parameterValues.getValue("prefix") as? String
        return (prefix?.takeIf { it.isNotEmpty() } ?: name.replaceFirstChar(Char::lowercaseChar)).convertToSnakeCase()
    }

    @Suppress("UNCHECKED_CAST")
    fun toPropertyHint(annotationInfo: AnnotationInfo): PropertyHint? =
        when (annotationInfo.name) {
            IntFlag::class.java.name -> IntFlagHint(
                annotationInfo.parameterValues.getValue("values") as? List<String> ?: emptyList()
            )

            MultilineText::class.java.name -> MultilineTextHint()
            PlaceHolderText::class.java.name -> PlaceHolderTextHint()
            ColorNoAlpha::class.java.name -> ColorNoAlphaHint()
            HintString::class.java.name -> HintStringHint(annotationInfo.parameterValues.getValue("value") as String)
            IntRange::class.java.name -> annotationInfo.provideRangeHint(-1)
            LongRange::class.java.name -> annotationInfo.provideRangeHint(-1L)
            FloatRange::class.java.name -> annotationInfo.provideRangeHint(-1f)
            DoubleRange::class.java.name -> annotationInfo.provideRangeHint(-1.0)
            ExpEasing::class.java.name -> ExpEasingHint(
                attenuation = annotationInfo.parameterValues.getValue("attenuation") as? Boolean ?: false,
                isPositiveOnly = annotationInfo.parameterValues.getValue("isPositiveOnly") as? Boolean ?: false,
            )

            File::class.java.name -> FileHint(
                extensions = annotationInfo.parameterValues.getValue("extensions") as? List<String> ?: emptyList(),
                global = annotationInfo.parameterValues.getValue("global") as? Boolean ?: false,
            )

            Dir::class.java.name -> DirHint(
                global = annotationInfo.parameterValues.getValue("global") as? Boolean ?: false,
            )

            else -> null
        }

    @Suppress("UNCHECKED_CAST")
    private fun <T : Number> AnnotationInfo.provideRangeHint(stepDefault: T): RangeHint<T> {
        val start = parameterValues.getValue("min") as T
        val end = parameterValues.getValue("max") as T
        val step = parameterValues.getValue("step") as? T ?: stepDefault
        val or = Range.valueOf((parameterValues.getValue("or") as AnnotationEnumValue).valueName)
        val hideSlider = parameterValues.getValue("hideSlider") as? Boolean ?: false
        val isRadians = parameterValues.getValue("isRadians") as? Boolean ?: false
        val isDegrees = parameterValues.getValue("isDegrees") as? Boolean ?: false
        val isExp = parameterValues.getValue("isExp") as? Boolean ?: false
        val suffix = parameterValues.getValue("suffix")?.toString()?.takeIf { it != "<none>" }

        return RangeHint(
            start = start,
            end = end,
            step = step,
            or = or,
            hideSlider = hideSlider,
            isRadians = isRadians,
            isDegrees = isDegrees,
            isExp = isExp,
            suffix = suffix,
        )
    }
}
