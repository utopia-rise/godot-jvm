package godot.intellij.plugin

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.service
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import java.util.concurrent.atomic.AtomicBoolean

class GodotJvmProjectService(val project: Project) : Disposable {
    private val registeredClassNameCache: MutableMap<Module, RegisteredClassNameCache> = mutableMapOf()
    private val started = AtomicBoolean(false)
    private val registeredClassIndex = RegisteredClassIndex(::provideRegisteredClassNameCache)

    fun start() {
        if (!started.compareAndSet(false, true)) return

        DumbService.getInstance(project).runWhenSmart {
            registeredClassIndex.start(
                parentDisposable = this,
                project = project
            )
        }
    }

    override fun dispose() {
        registeredClassNameCache.clear()
    }

    fun provideRegisteredClassNameCache(module: Module): RegisteredClassNameCache =
        registeredClassNameCache.getOrPut(module, ::RegisteredClassNameCache)

    fun refreshRegistrationIndex() {
        registeredClassNameCache.values.forEach(RegisteredClassNameCache::clear)
        registeredClassIndex.refresh(project)
    }

    companion object {
        fun getInstance(module: Module): GodotJvmProjectService = module.project.service()
    }
}
