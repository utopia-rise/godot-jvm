@file:JvmName("NodeUtils")

package godot.extension

import godot.api.Node
import godot.core.NodePath
import godot.core.StringName
import godot.core.asNodePath

@Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST")
inline fun <T : Node> Node.getNodeAs(path: String) = getNode(path.asNodePath()) as T?

@Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST")
inline fun <T : Node> Node.getNodeAs(path: StringName) = getNode(path.asNodePath()) as T?

@Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST")
inline fun <T : Node> Node.getNodeAs(nodePath: NodePath) = getNode(nodePath) as T?
