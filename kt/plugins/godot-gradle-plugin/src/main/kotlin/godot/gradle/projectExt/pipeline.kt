package godot.gradle.projectExt

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.tasks.android.AndroidTools
import godot.gradle.tasks.android.registerAndroidTools
import godot.gradle.tasks.android.registerDebugAndroidTasks
import godot.gradle.tasks.android.registerReleaseAndroidTasks
import godot.gradle.tasks.bootstrap.registerBootstrapTasks
import godot.gradle.tasks.copy.SyncIntoGodotProjectTask
import godot.gradle.tasks.api.GenerateCustomApiSourcesTask
import godot.gradle.tasks.api.registerCustomApiGeneration
import godot.gradle.tasks.api.registerGodotApi
import godot.gradle.tasks.dependencies.registerSplitDependencySync
import godot.gradle.tasks.game.registerGameTasks
import godot.gradle.tasks.graal.GraalTools
import godot.gradle.tasks.graal.registerGraalTasks
import godot.gradle.tasks.graal.registerGraalTools
import godot.gradle.tasks.ios.IosTools
import godot.gradle.tasks.ios.registerIosTasks
import godot.gradle.tasks.ios.registerIosTools
import godot.gradle.tasks.project.ProjectTasks
import godot.gradle.tasks.project.registerProjectTasks
import godot.gradle.tasks.registration.RegistrationTasks
import godot.gradle.tasks.registration.registerRegistrationTasks
import godot.gradle.tasks.usercode.registerUserCodeTasks
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider

class SharedTasks(
    val project: ProjectTasks,
    val customApi: TaskProvider<GenerateCustomApiSourcesTask>?,
    val registration: RegistrationTasks,
    val syncSplitDependencies: TaskProvider<SyncIntoGodotProjectTask>,
    val android: AndroidTools,
    val graal: GraalTools,
    val ios: IosTools,
)

class Pipeline(
    val desktop: List<TaskProvider<out Task>>,
    val copyUserCode: TaskProvider<out Task>?,
    val android: TaskProvider<out Task>,
    val graal: TaskProvider<out Task>,
    val ios: TaskProvider<out Task>,
)

fun Project.registerSharedTasks(fastBuild: Boolean): SharedTasks =
    SharedTasks(
        project = registerProjectTasks(),
        customApi = registerCustomApiGeneration(),
        registration = registerRegistrationTasks(fastBuild),
        syncSplitDependencies = registerSplitDependencySync(),
        android = registerAndroidTools(),
        graal = registerGraalTools(),
        ios = registerIosTools(),
    )

fun Project.registerPipeline(buildType: BuildType, shared: SharedTasks): Pipeline {
    registerGodotApi(buildType, shared.customApi)
    val bootstrap = registerBootstrapTasks(buildType)
    val userCode = registerUserCodeTasks(buildType, shared.registration)
    val game = if (buildType == BuildType.RELEASE) registerGameTasks(bootstrap.bootstrapJar, userCode.userCodeJar) else null
    val gameJars = (game?.let { listOf(it.gameJar) } ?: listOf(bootstrap.bootstrapJar, userCode.userCodeJar))
        .map { jar -> jar.flatMap(ShadowJar::getArchiveFile) }
    return Pipeline(
        desktop = listOfNotNull(bootstrap.copyBootstrapJar, userCode.copyUserCode, game?.copyGameJar),
        copyUserCode = userCode.copyUserCode,
        android = if (game == null) {
            registerDebugAndroidTasks(bootstrap.bootstrapJar, userCode.userCodeJar, shared.android)
        } else {
            registerReleaseAndroidTasks(game.gameJar, shared.android)
        },
        graal = registerGraalTasks(buildType, gameJars, shared.graal),
        ios = registerIosTasks(buildType, gameJars, shared.graal, shared.ios),
    )
}
