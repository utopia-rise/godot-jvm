package godot.intellij.plugin.action

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.openapi.fileTypes.UnknownFileType

enum class GodotScriptLanguage(val fileExtension: String) {
    KOTLIN("kt"),
    JAVA("java"),
    SCALA("scala");

    val fileType: FileType
        get() = FileTypeManager.getInstance().getFileTypeByExtension(fileExtension)

    override fun toString(): String = name.lowercase().replaceFirstChar(Char::uppercase)

    companion object {
        /** Scala is an optional dependency of this plugin, so it is only offered when its file type is registered. */
        val available: List<GodotScriptLanguage>
            get() = entries.filter { language -> language.fileType !is UnknownFileType }
    }
}
