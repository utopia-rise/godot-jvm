package godot.registration

import godot.common.extensions.convertToTitleCase
import godot.core.GodotEnum
import godot.core.VariantParser

fun <E : Enum<E>> enumHintString(entries: Array<E>): String =
    entries.joinToString(",") { entry ->
        val label = entry.name.convertToTitleCase()
        if (entry is GodotEnum) "$label:${entry.value}" else label
    }

fun <E : Enum<E>> enumListHintString(entries: Array<E>): String =
    "${VariantParser.LONG.id}/${VariantParser.LONG.id}:${enumHintString(entries)}"
