package godot.intellij.plugin.project


import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName

fun String.classId(): ClassId = ClassId.topLevel(FqName(this))
