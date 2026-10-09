package godot.intellij.plugin

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiRecursiveElementWalkingVisitor
import godot.intellij.plugin.project.getRegisteredClassName
import godot.intellij.plugin.registration.registrationPolicy
import org.jetbrains.kotlin.psi.KtClass

class RegisteredClassNameCache {
    private val fqNameToRegisteredName: MutableMap<String, RegisteredClassDataContainer> = mutableMapOf()

    fun getContainersByName(registeredName: String): Set<RegisteredClassDataContainer> =
        fqNameToRegisteredName
            .values
            .filterTo(mutableSetOf()) { container -> container.registeredName == registeredName }

    fun getContainerByFqName(fqName: String): RegisteredClassDataContainer? = fqNameToRegisteredName[fqName]

    fun clear() {
        fqNameToRegisteredName.clear()
    }

    fun psiFileChanged(psiFile: PsiFile) {
        removeFileEntries(psiFile)
        val policy = psiFile.registrationPolicy
        psiFile.accept(
            object : PsiRecursiveElementWalkingVisitor() {
                override fun visitElement(element: PsiElement) {
                    super.visitElement(element)

                    val registeredClass = when (element) {
                        is KtClass -> element.takeIf(policy::registersClass)?.getRegisteredClassName()
                        is PsiClass -> element.takeIf(policy::registersClass)?.getRegisteredClassName()

                        else -> return
                    }

                    if (registeredClass == null) {
                        when (element) {
                            is KtClass -> element.fqName?.asString()?.let(fqNameToRegisteredName::remove)
                            is PsiClass -> element.qualifiedName?.let(fqNameToRegisteredName::remove)
                        }
                        return
                    }

                    val (fqName, registeredName) = registeredClass
                    fqNameToRegisteredName[fqName] = RegisteredClassDataContainer(fqName, registeredName, psiFile.virtualFile)
                }
            }
        )
    }

    fun psiFileRemoved(psiFile: PsiFile) {
        removeFileEntries(psiFile)
    }

    private fun removeFileEntries(psiFile: PsiFile) {
        fqNameToRegisteredName.entries.removeIf { (_, container) ->
            container.vFile == psiFile.virtualFile
        }
    }
}
