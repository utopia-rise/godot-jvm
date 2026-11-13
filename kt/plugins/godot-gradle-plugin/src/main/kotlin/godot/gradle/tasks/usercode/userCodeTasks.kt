package godot.gradle.tasks.usercode

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.GODOT_GAME_RUNTIME_CLASSPATH_CONFIGURATION
import godot.gradle.projectExt.godotJvmDirectory
import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.projectExt.registerGodotJar
import godot.gradle.projectExt.sourceSet
import godot.gradle.tasks.copy.CopyIntoGodotProjectTask
import godot.gradle.tasks.copy.registerCopyIntoGodotProject
import godot.gradle.tasks.registration.RegistrationTasks
import godot.tools.common.constants.ArtifactNames
import godot.tools.common.constants.Paths
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.file.ArchiveOperations
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.bundling.Jar
import javax.inject.Inject

class UserCodeTasks(
    val userCodeJar: TaskProvider<ShadowJar>,
    val copyUserCode: TaskProvider<CopyIntoGodotProjectTask>?,
)

internal abstract class ArchiveOperationsHolder @Inject constructor(val archiveOperations: ArchiveOperations)

fun Project.registerUserCodeTasks(buildType: BuildType, registration: RegistrationTasks): UserCodeTasks {
    val gameRuntimeClasspath = configurations.getByName(buildType.named(GODOT_GAME_RUNTIME_CLASSPATH_CONFIGURATION))
    val archiveOperations = objects.newInstance(ArchiveOperationsHolder::class.java).archiveOperations
    val registrarJar = registration.registrarJar.flatMap(Jar::getArchiveFile)
    val registrarClasses = registrarJar.map { jar ->
        if (!jar.asFile.isFile) {
            throw GradleException(
                "packageRegistrarJar output is missing. Run a full build first before using fastBuild. " +
                    "Expected file: ${jar.asFile.absolutePath}"
            )
        }
        archiveOperations.zipTree(jar)
    }

    val userCodeJar = registerGodotJar(
        name = buildType.named("packageUserCodeJar"),
        description = "Creates a fat jar containing game code and all dependencies of it",
        fileName = ArtifactNames.Debug.USER_CODE_JAR,
        buildType = buildType,
    ) { task ->
        task.from(sourceSet(buildType).output)
        task.configurations.add(gameRuntimeClasspath)
        task.dependsOn(registration.registrarJar)
        task.from(registrarClasses) { spec -> spec.exclude("META-INF/MANIFEST.MF") }
    }

    if (buildType == BuildType.RELEASE) {
        return UserCodeTasks(userCodeJar, null)
    }

    val hashSources = tasks.register("hashSources", HashSourcesTask::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Hashes the sources of the debug build so the editor can tell which ones changed since."
        task.sourceFiles.from(sourceSet(BuildType.DEBUG).allSource.matching { filter -> filter.include("**/*.kt", "**/*.java", "**/*.scala") })
        task.godotProjectDirPath.set(godotJvmExtension.godotProjectDirectory.map { directory -> directory.asFile.absolutePath })
        task.sourceHashesFile.set(layout.buildDirectory.file("generated/source-hashes/${ArtifactNames.SOURCE_HASHES}"))
    }

    val godotJvmDirectory = godotJvmDirectory()
    val copyUserCode = registerCopyIntoGodotProject(
        name = "copyUserCode",
        description = "Copies the debug user code jar and the source hashes the editor compares against it into the Godot project.",
        hashSources.flatMap(HashSourcesTask::sourceHashesFile) to
            godotJvmDirectory.resolve(Paths.EDITOR_DIR).resolve(ArtifactNames.SOURCE_HASHES),
        userCodeJar.flatMap(ShadowJar::getArchiveFile) to
            godotJvmDirectory.resolve(buildType.id).resolve(ArtifactNames.Debug.USER_CODE_JAR),
    )
    copyUserCode.configure { task ->
        task.mustRunAfter(registration.copyScriptClassIndex)
        registration.syncRegistrationFiles?.let { sync -> task.mustRunAfter(sync) }
    }
    return UserCodeTasks(userCodeJar, copyUserCode)
}
