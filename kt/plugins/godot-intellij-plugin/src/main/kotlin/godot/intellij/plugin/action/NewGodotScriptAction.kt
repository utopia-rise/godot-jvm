package godot.intellij.plugin.action

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.psi.JavaDirectoryService
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.project.isInGodotRoot

/**
 * Creates a new Godot script from the project view's `New` menu, in the same spirit as the Godot editor's
 * "attach script" dialog: pick a name, a language, the Godot base class and the lifecycle functions to override.
 */
class NewGodotScriptAction : AnAction() {

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT

    override fun update(e: AnActionEvent) {
        val project = e.project
        val directory = e.getData(LangDataKeys.IDE_VIEW)?.directories?.firstOrNull()
        e.presentation.isEnabledAndVisible = project != null &&
            directory != null &&
            directory.virtualFile.isInGodotRoot(project)
    }

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val view = e.getData(LangDataKeys.IDE_VIEW) ?: return
        val directory = view.orChooseDirectory ?: return
        val packageName = JavaDirectoryService.getInstance().getPackage(directory)?.qualifiedName.orEmpty()

        val dialog = NewGodotScriptDialog(project, directory, packageName)
        if (!dialog.showAndGet()) return

        val request = dialog.buildRequest()
        val fileName = "${request.className}.${request.language.fileExtension}"
        val source = GodotScriptGenerator.generate(request)

        val createdFile = WriteCommandAction
            .writeCommandAction(project)
            .withName(GodotPluginBundle.message("action.newScript.command.name", fileName))
            .compute<PsiFile, RuntimeException> {
                // The generated source is already formatted. Reformatting it here would replace declarations while the
                // registration index listens for PSI changes, which is not allowed to resolve references.
                val file = PsiFileFactory
                    .getInstance(project)
                    .createFileFromText(fileName, request.language.fileType, source)
                directory.add(file) as PsiFile
            }

        view.selectElement(createdFile)
    }
}
