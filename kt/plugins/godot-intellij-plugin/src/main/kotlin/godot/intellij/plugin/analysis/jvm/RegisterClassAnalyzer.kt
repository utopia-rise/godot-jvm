package godot.intellij.plugin.analysis.jvm

import com.intellij.psi.PsiClass
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import godot.annotation.Emit
import godot.annotation.Script
import godot.annotation.Tool
import godot.annotation.Visible
import godot.core.KtObject
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.project.getRegisteredClassName
import godot.intellij.plugin.project.isAbstract
import godot.intellij.plugin.project.isOrInheritsType
import godot.intellij.plugin.project.registeredClassNameCache
import godot.intellij.plugin.quickfix.ClassAlreadyRegisteredQuickFix
import godot.intellij.plugin.quickfix.ClassMakePublicQuickFix
import godot.intellij.plugin.quickfix.ClassNotRegisteredQuickFix
import godot.intellij.plugin.project.isPublicOnJvm
import godot.intellij.plugin.registration.registrationPolicy
import org.jetbrains.kotlin.idea.base.util.module
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.psiUtil.isAbstract
import org.jetbrains.kotlin.scripting.resolve.classId

object GodotScriptAnalyzer {
    private val classNotRegisteredQuickFix = ClassNotRegisteredQuickFix()
    private val makePublicQuickFixes = arrayOf(ClassMakePublicQuickFix())

    private fun notPublicProblem(location: PsiElement): GodotProblem = GodotProblem(
        GodotPluginBundle.message("problem.class.notPublic"),
        location,
        makePublicQuickFixes,
        ProblemHighlightType.WARNING
    )

    fun analyze(ktClass: KtClass): List<GodotProblem> {
        val policy = ktClass.registrationPolicy
        return buildList {
            if (!ktClass.isPublicOnJvm() && policy.hasAnnotation(ktClass, Script::class)) {
                add(notPublicProblem(ktClass.nameIdentifier ?: ktClass.navigationElement))
                return@buildList
            }
            val isRegistered = policy.registersClass(ktClass)
            if (policy.reportsMissingRegistration && !isRegistered) {
                val errorLocation = ktClass.nameIdentifier ?: ktClass.navigationElement
                val properties = ktClass.getProperties()
                val isConcrete = !ktClass.isAbstract()
                if (ktClass.findAnnotation(Tool::class.classId) != null) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.notRegistered.butHasToolAnnotation"),
                            errorLocation,
                            arrayOf(classNotRegisteredQuickFix)
                        )
                    )
                }
                if (isConcrete && properties.any(policy::registersProperty)) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.notRegistered.properties"),
                            errorLocation,
                            arrayOf(classNotRegisteredQuickFix)
                        )
                    )
                }
                if (isConcrete && properties.any { policy.hasAnnotation(it, Emit::class) }) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.notRegistered.signals"),
                            errorLocation,
                            arrayOf(classNotRegisteredQuickFix)
                        )
                    )
                }
                if (isConcrete && ktClass.declarations.filterIsInstance<KtNamedFunction>().any(policy::registersFunction)) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.notRegistered.functions"),
                            errorLocation,
                            arrayOf(classNotRegisteredQuickFix)
                        )
                    )
                }
            }

            if (isRegistered) {
                buildRegisteredClassNameProblem(ktClass)?.let(::add)
            }

            if (isRegistered && ktClass.typeParameters.isNotEmpty()) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.general.cannotRegisterGenerics"),
                        ktClass.typeParameterList ?: ktClass.nameIdentifier ?: ktClass.navigationElement
                    )
                )
            }

            if (isRegistered && !ktClass.isOrInheritsType(KtObject::class.classId)) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject"),
                        ktClass.nameIdentifier ?: ktClass.navigationElement
                    )
                )
            }

        }
    }

    fun analyze(psiClass: PsiClass): List<GodotProblem> {
        val policy = psiClass.registrationPolicy
        return buildList {
            if (!psiClass.isPublicOnJvm() && policy.hasAnnotation(psiClass, Script::class)) {
                add(notPublicProblem(psiClass.nameIdentifier ?: psiClass.navigationElement))
                return@buildList
            }
            val isRegistered = policy.registersClass(psiClass)
            if (policy.reportsMissingRegistration && !isRegistered) {
                val errorLocation = psiClass.nameIdentifier ?: psiClass.navigationElement
                val isConcrete = !psiClass.isAbstract
                val fields = psiClass.fields
                val methods = psiClass.methods
                if (psiClass.getAnnotation(Tool::class.qualifiedName!!) != null) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.notRegistered.butHasToolAnnotation"),
                            errorLocation,
                            arrayOf(classNotRegisteredQuickFix)
                        )
                    )
                }
                if (
                    isConcrete &&
                    (
                        fields.any { field -> policy.hasAnnotation(field, Visible::class) } ||
                            methods.any { method -> policy.hasAnnotation(method, Visible::class) }
                        )
                ) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.notRegistered.properties"),
                            errorLocation,
                            arrayOf(classNotRegisteredQuickFix)
                        )
                    )
                }
                if (
                    isConcrete &&
                    (
                        fields.any { field -> policy.hasAnnotation(field, Emit::class) } ||
                            methods.any { method -> policy.hasAnnotation(method, Emit::class) }
                        )
                ) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.notRegistered.signals"),
                            errorLocation,
                            arrayOf(classNotRegisteredQuickFix)
                        )
                    )
                }
                if (isConcrete && methods.any(policy::registersFunction)) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.notRegistered.functions"),
                            errorLocation,
                            arrayOf(classNotRegisteredQuickFix)
                        )
                    )
                }
            } else if (isRegistered) {
                addAll(GenericRegistrationAnalyzer.analyze(psiClass))
                if (!psiClass.isOrInheritsType(KtObject::class.classId)) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject"),
                            psiClass.nameIdentifier ?: psiClass.navigationElement
                        )
                    )
                }
                buildRegisteredClassNameProblem(psiClass)?.let(::add)
            }
        }
    }

    private fun buildRegisteredClassNameProblem(ktClass: KtClass): GodotProblem? {
        val (fqName, registeredName) = ktClass.getRegisteredClassName() ?: return null
        val fqNames = ktClass
            .module
            ?.registeredClassNameCache
            ?.getContainersByName(registeredName)
            ?.map { container -> container.fqName }
            .orEmpty()
            .toSet() + ktClass.registeredFqNamesInContainingFile(registeredName)

        if (fqNames.size <= 1 && (fqNames.isEmpty() || fqNames.contains(fqName))) {
            return null
        }

        val registerClassAnnotation = ktClass.findAnnotation(Script::class.classId)
        val psiElement = registerClassAnnotation?.valueArgumentList?.arguments?.firstOrNull { argument ->
            argument.getArgumentName()?.asName?.asString() == "className" || !argument.isNamed()
        } ?: registerClassAnnotation ?: ktClass.nameIdentifier ?: ktClass.navigationElement

        return psiElement.takeIf { it.isValid }?.let {
            GodotProblem(
                GodotPluginBundle.message("problem.class.nameAlreadyRegistered"),
                it,
                arrayOf(ClassAlreadyRegisteredQuickFix(registeredName))
            )
        }
    }

    private fun buildRegisteredClassNameProblem(psiClass: PsiClass): GodotProblem? {
        val (fqName, registeredName) = psiClass.getRegisteredClassName() ?: return null
        val fqNames = psiClass
            .module
            ?.registeredClassNameCache
            ?.getContainersByName(registeredName)
            ?.map { container -> container.fqName }
            .orEmpty()
            .toSet() + psiClass.registeredFqNamesInContainingFile(registeredName)

        if (fqNames.size <= 1 && (fqNames.isEmpty() || fqNames.contains(fqName))) {
            return null
        }

        val registerClassAnnotation = psiClass.getAnnotation(Script::class.qualifiedName!!)
        val psiElement = if (registerClassAnnotation == null) {
            psiClass.nameIdentifier ?: psiClass.navigationElement
        } else {
            val classNameAttribute = registerClassAnnotation.parameterList.attributes.firstOrNull { attribute ->
                attribute.name == "className" || attribute.name == null
            }
            listOfNotNull(
                classNameAttribute?.value,
                classNameAttribute,
                registerClassAnnotation.nameReferenceElement,
                psiClass.nameIdentifier,
                psiClass.navigationElement
            ).firstOrNull { element -> element.isValid && element.textLength > 0 } ?: psiClass
        }

        return psiElement.takeIf { it.isValid && it.textLength > 0 }?.let {
            GodotProblem(
                GodotPluginBundle.message("problem.class.nameAlreadyRegistered"),
                it,
                arrayOf(ClassAlreadyRegisteredQuickFix(registeredName))
            )
        }
    }

    private fun PsiElement.registeredFqNamesInContainingFile(registeredName: String): Set<String> {
        val file = containingFile ?: return emptySet()
        val policy = registrationPolicy
        val classes = PsiTreeUtil.findChildrenOfType(file, KtClass::class.java) +
            PsiTreeUtil.findChildrenOfType(file, PsiClass::class.java)

        return classes
            .mapNotNull { psiClass ->
                when (psiClass) {
                    is KtClass -> psiClass
                        .takeIf(policy::registersClass)
                        ?.getRegisteredClassName()

                    is PsiClass -> psiClass
                        .takeIf(policy::registersClass)
                        ?.getRegisteredClassName()

                    else -> null
                }
            }
            .filter { (_, name) -> name == registeredName }
            .mapTo(mutableSetOf()) { (fqName, _) -> fqName }
    }

}


