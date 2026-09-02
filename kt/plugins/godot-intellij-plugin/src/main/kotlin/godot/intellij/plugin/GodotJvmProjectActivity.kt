package godot.intellij.plugin

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class GodotJvmProjectActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        if (!project.isDisposed) {
            project.getService(GodotJvmProjectService::class.java).start()
        }
    }
}
