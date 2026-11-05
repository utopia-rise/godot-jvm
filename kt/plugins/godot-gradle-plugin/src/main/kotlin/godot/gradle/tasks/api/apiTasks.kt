package godot.gradle.tasks.api

import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.GODOT_API_CONFIGURATION
import godot.gradle.projectExt.GODOT_BUILD_TYPE_ATTRIBUTE
import godot.gradle.projectExt.godotJvmDependency
import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.projectExt.kotlinJvmExtension
import godot.gradle.projectExt.libsDirectory
import godot.gradle.projectExt.resolvedKotlinBuildVersion
import org.gradle.api.Project
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.bundling.Jar

fun Project.registerCustomApiGeneration(): TaskProvider<GenerateCustomApiSourcesTask>? =
    if (godotJvmExtension.isCustomApiEnabled.get()) tasks.register("generateCustomApiSources", GenerateCustomApiSourcesTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Generates custom Godot bindings from the configured API JSON."
        task.sourceJson.set(godotJvmExtension.apiJsonFile)
        task.apiOutputDir.set(layout.buildDirectory.dir("generated/custom-godot-api/api"))
    } else null

fun Project.registerGodotApi(buildType: BuildType, generation: TaskProvider<GenerateCustomApiSourcesTask>?) {
    val godotApi = buildType.named(GODOT_API_CONFIGURATION)
    if (generation == null) {
        dependencies.add(godotApi, godotJvmDependency("api"))
        return
    }
    val compilation = kotlinJvmExtension.target.compilations.create(buildType.named("customApi")) { compilation ->
        compilation.defaultSourceSet {
            kotlin.srcDir(generation.flatMap(GenerateCustomApiSourcesTask::apiOutputDir))
        }
        compilation.compileTaskProvider.configure { task -> task.dependsOn(generation) }
    }
    for (configuration in listOf(compilation.compileDependencyConfigurationName, compilation.runtimeDependencyConfigurationName)) {
        configurations.getByName(configuration).attributes.attribute(GODOT_BUILD_TYPE_ATTRIBUTE, buildType.id)
    }
    val implementation = compilation.defaultSourceSet.implementationConfigurationName
    dependencies.add(implementation, "org.jetbrains.kotlin:kotlin-stdlib:${resolvedKotlinBuildVersion()}")
    dependencies.add(implementation, godotJvmDependency("internal"))
    dependencies.add(implementation, godotJvmDependency("core"))

    val customApiJar = tasks.register(buildType.named("packageCustomApiJar"), Jar::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Compiles the generated custom Godot bindings into a reusable jar."
        task.archiveBaseName.set("godot-custom-api")
        task.archiveVersion.set("")
        task.archiveClassifier.set("")
        task.destinationDirectory.set(libsDirectory(buildType))
        task.dependsOn(compilation.compileTaskProvider)
        task.from(compilation.output.allOutputs) { spec ->
            spec.include("godot/api/**", "godot/RegisterEngineTypes*", "godot/MethodCalls*", "META-INF/**")
        }
    }
    dependencies.add(godotApi, files(customApiJar.flatMap(Jar::getArchiveFile)))
}
