package godot.gradle.tasks.android

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.projectExt.variantLibsDirectory
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.Project
import org.gradle.api.tasks.TaskProvider

fun Project.packageUserCodeDexJarTask(
    createMainDexFileTask: TaskProvider<CreateMainDexFileTask>,
    packageUserCodeJarTask: TaskProvider<ShadowJar>,
): TaskProvider<ShadowJar> {
    return tasks.register("packageUserCodeDexJar", ShadowJar::class.java) {
        with(it) {
            group = "godot-jvm"
            description =
                "Packs the android dex file of main, together with the needed registrar service file into a jar. Needed for android builds only"

            archiveBaseName.set(ArtifactNames.Debug.USER_CODE_DEX_JAR.removeSuffix(".jar"))
            destinationDirectory.set(variantLibsDirectory())

            from(createMainDexFileTask.flatMap(CreateMainDexFileTask::dexOutputDirectory))

            from(zipTree(packageUserCodeJarTask.flatMap(ShadowJar::getArchiveFile))) { copySpec ->
                // copy everything from the usercode.jar
                copySpec.include("**/*")

                // except class files as these are contained in converted form in the dex files
                copySpec.exclude("**/*.class")
            }

            dependsOn(createMainDexFileTask, packageUserCodeJarTask)
        }
    }
}
