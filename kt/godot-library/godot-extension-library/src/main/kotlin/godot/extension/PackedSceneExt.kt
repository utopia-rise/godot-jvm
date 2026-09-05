@file:JvmName("PackedSceneUtils")

package godot.extension

import godot.api.Node
import godot.api.PackedScene

@Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST")
inline fun <T : Node> PackedScene.instantiateAs(
    editState: PackedScene.GenEditState = PackedScene.GenEditState.DISABLED
): T? {
    return instantiate(editState) as T?
}
