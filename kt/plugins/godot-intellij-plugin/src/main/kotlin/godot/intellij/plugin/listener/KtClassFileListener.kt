package godot.intellij.plugin.listener

import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiTreeChangeEvent
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.FileBasedIndex
import godot.intellij.plugin.ProjectDisposable
import godot.intellij.plugin.annotator.clazz.RegisteredClassNameCheckerProvider
import godot.intellij.plugin.wrapper.PsiTreeChangeListenerKt
import org.jetbrains.kotlin.idea.KotlinFileType
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtFile

class KtClassFileListener(private val project: Project) : ProjectDisposable {

    init {
        DumbService.getInstance(project).runWhenSmart {
            setupListener()
            initialIndexing()
        }
    }

    private fun setupListener() {
        PsiManager
            .getInstance(project)
            .addPsiTreeChangeListener(
                object : PsiTreeChangeListenerKt {

                    override fun beforeChildRemoval(event: PsiTreeChangeEvent) {
                        val child = event.child
                        when {
                            //whole file removed
                            child is KtFile && event.file == null -> psiFileRemoved(child)
                            //class in file removed (just annotation removed covered in [childrenChanged]
                            child is KtClass -> psiFileChanged(child.containingFile)
                        }
                    }

                    override fun childrenChanged(event: PsiTreeChangeEvent) {
                        event
                            .file
                            ?.let { psiFile ->
                                if (psiFile.language == KotlinLanguage.INSTANCE) {
                                    psiFileChanged(psiFile)
                                }
                            }
                    }
                },
                this
            )
    }

    private fun initialIndexing() {
        FileBasedIndex
            .getInstance()
            .getContainingFiles(
                FileTypeIndex.NAME,
                KotlinFileType.INSTANCE,
                GlobalSearchScope.projectScope(project)
            )
            .forEach { vFile ->
                PsiManager.getInstance(project).findFile(vFile)?.let { psiFile ->
                    psiFileChanged(psiFile)
                }
            }
    }

    private fun psiFileRemoved(psiFile: PsiFile) {
        RegisteredClassNameCheckerProvider.provide(project).psiFileRemoved(psiFile)
    }

    private fun psiFileChanged(psiFile: PsiFile) {
        RegisteredClassNameCheckerProvider.provide(project).psiFileChanged(psiFile)
    }

    override fun dispose(project: Project) {
        RegisteredClassNameCheckerProvider.disposeForProject(project)
    }
}