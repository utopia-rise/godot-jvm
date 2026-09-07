package godot.intellij.plugin.project

import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import java.io.File

private const val godotProjectFileName = "project.godot"
private val godotRootCacheKey = Key<GodotRootCacheEntry>("godot.intellij.plugin.godotRootCache")


@JvmInline
value class GodotRoot(val godotRootDir: File)

private data class GodotRootCacheEntry(
    val filePath: String,
    val root: GodotRoot?
)

/** The Godot project a project contains, if any. Godot-JVM projects hold a single Godot project. */
val Project.godotRoot: GodotRoot?
    get() = ModuleManager.getInstance(this).modules.firstNotNullOfOrNull { module -> module.godotRoot }

fun VirtualFile.isInGodotRoot(project: Project): Boolean = getGodotRoot(project) != null

fun VirtualFile.getGodotRoot(project: Project): GodotRoot? {
    return getCachedGodotRoot(path) {
        ModuleUtilCore.findModuleForFile(this, project)?.godotRoot
            ?: findGodotRootFromVirtualFile(this)
            ?: findGodotRootFromPath(path)
    }
}

fun PsiFile.isInGodotRoot(): Boolean = getGodotRoot() != null

fun PsiFile.getGodotRoot(): GodotRoot? {
    val file = virtualFile ?: return null
    return file.getCachedGodotRoot(file.path) {
        ModuleUtilCore.findModuleForFile(file, project)?.godotRoot
            ?: findGodotRootFromVirtualFile(file)
            ?: findGodotRootFromPath(file.path)
    }
}

fun PsiElement.isInGodotRoot(): Boolean = getGodotRoot() != null

fun PsiElement.getGodotRoot(): GodotRoot? {
    val file = containingFile?.virtualFile ?: return null
    return file.getCachedGodotRoot(file.path) {
        ModuleUtilCore.findModuleForPsiElement(this)?.godotRoot
            ?: findGodotRootFromVirtualFile(file)
            ?: findGodotRootFromPath(file.path)
    }
}

private inline fun VirtualFile.getCachedGodotRoot(
    currentPath: String,
    provider: () -> GodotRoot?
): GodotRoot? {
    val cachedEntry = getUserData(godotRootCacheKey)
    if (cachedEntry?.filePath == currentPath) {
        return cachedEntry.root
    }

    return provider().also { root ->
        putUserData(godotRootCacheKey, GodotRootCacheEntry(currentPath, root))
    }
}

private fun findGodotRootFromVirtualFile(file: VirtualFile): GodotRoot? {
    var current = if (file.isDirectory) file else file.parent
    while (current != null) {
        if (current.findChild(godotProjectFileName) != null) {
            return GodotRoot(File(current.path))
        }
        current = current.parent
    }
    return null
}

private fun findGodotRootFromPath(path: String): GodotRoot? {
    var current: File? = File(path).takeIf { it.exists() }?.let { file ->
        if (file.isDirectory) file else file.parentFile
    }

    while (current != null) {
        if (File(current, godotProjectFileName).exists()) {
            return GodotRoot(current)
        }
        current = current.parentFile
    }

    return null
}
