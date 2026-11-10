package godot.gradle.projectExt

import godot.gradle.GodotLanguage
import org.gradle.api.Project
import org.gradle.api.plugins.scala.ScalaBasePlugin
import org.gradle.api.tasks.ScalaSourceDirectorySet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.compile.JavaCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

const val GODOT_GAME_IMPLEMENTATION_CONFIGURATION = "godotGameImplementation"
const val GODOT_SPLIT_IMPLEMENTATION_CONFIGURATION = "godotSplitImplementation"
const val GODOT_GAME_RUNTIME_ONLY_CONFIGURATION = "godotGameRuntimeOnly"
const val GODOT_SPLIT_RUNTIME_ONLY_CONFIGURATION = "godotSplitRuntimeOnly"
const val GODOT_GAME_RUNTIME_CLASSPATH_CONFIGURATION = "godotGameRuntimeClasspath"
const val GODOT_SPLIT_RUNTIME_CLASSPATH_CONFIGURATION = "godotSplitRuntimeClasspath"
const val GODOT_API_CONFIGURATION = "godotApi"
const val BOOTSTRAP_CONFIGURATION = "bootstrap"

private val BOOTSTRAP_MODULES = listOf("core", "extension", "bootstrap")

fun Project.setupConfigurationsAndCompilations() {
    val godotGameImplementation = configurations.create(GODOT_GAME_IMPLEMENTATION_CONFIGURATION)
    val godotSplitImplementation = configurations.create(GODOT_SPLIT_IMPLEMENTATION_CONFIGURATION)
    val godotGameRuntimeOnly = configurations.create(GODOT_GAME_RUNTIME_ONLY_CONFIGURATION)
    val godotSplitRuntimeOnly = configurations.create(GODOT_SPLIT_RUNTIME_ONLY_CONFIGURATION)

    extensions.getByType(SourceSetContainer::class.java).findByName("test")?.let { test ->
        configurations.getByName(test.compileClasspathConfigurationName).extendsFrom(godotGameImplementation, godotSplitImplementation)
        configurations.getByName(test.runtimeClasspathConfigurationName)
            .extendsFrom(godotGameImplementation, godotSplitImplementation, godotGameRuntimeOnly, godotSplitRuntimeOnly)
    }

    configurations.configureEach { configuration ->
        if (configuration.isCanBeResolved) {
            configuration.attributes.attribute(GODOT_BUILD_TYPE_ATTRIBUTE, BuildType.DEBUG.id)
        }
    }

    configurations.create(GODOT_SPLIT_RUNTIME_CLASSPATH_CONFIGURATION) {
        it.extendsFrom(godotSplitImplementation, godotSplitRuntimeOnly)
    }

    if (BuildType.RELEASE in buildTypes) {
        createReleaseSourceSet()
    }

    val kotlinBuildVersion = resolvedKotlinBuildVersion()
    for (buildType in buildTypes) {
        val sourceSet = sourceSet(buildType)
        val godotApi = configurations.create(buildType.named(GODOT_API_CONFIGURATION))
        val compileClasspath = configurations.getByName(sourceSet.compileClasspathConfigurationName) {
            it.extendsFrom(godotGameImplementation, godotSplitImplementation, godotApi)
        }
        val gameRuntimeClasspath = configurations.create(buildType.named(GODOT_GAME_RUNTIME_CLASSPATH_CONFIGURATION)) {
            it.extendsFrom(godotGameImplementation, godotGameRuntimeOnly)
        }
        val bootstrap = configurations.create(buildType.named(BOOTSTRAP_CONFIGURATION)) {
            it.extendsFrom(godotApi)
            with(it.dependencies) {
                add(dependencies.create("org.jetbrains.kotlin:kotlin-stdlib:$kotlinBuildVersion"))
                for (module in BOOTSTRAP_MODULES) {
                    add(godotJvmDependency(module))
                }
                // add reflection explicitly so it's usable in exported projects as well. See: GH-571
                add(dependencies.create("org.jetbrains.kotlin:kotlin-reflect:$kotlinBuildVersion"))
            }
        }
        val runtimeClasspath = configurations.getByName(sourceSet.runtimeClasspathConfigurationName)
        for (configuration in listOf(compileClasspath, runtimeClasspath, gameRuntimeClasspath, bootstrap)) {
            configuration.attributes.attribute(GODOT_BUILD_TYPE_ATTRIBUTE, buildType.id)
        }
    }

    afterEvaluate {
        for (module in BOOTSTRAP_MODULES) {
            dependencies.add("compileOnly", godotJvmDependency(module))
        }
        if (isLanguageEnabled(GodotLanguage.SCALA)) {
            dependencies.add("implementation", "org.scala-lang:scala3-library_3:${godotJvmExtension.toolchain.scalaVersion.get()}")
        }

        if (godotJvmExtension.isGodotCoroutinesEnabled.get()) {
            dependencies.add("implementation", godotJvmDependency("coroutine"))
        }
    }

    tasks.withType(JavaCompile::class.java).configureEach { javaCompile ->
        javaCompile.options.compilerArgs.add("-parameters")
    }

    tasks.withType(KotlinCompile::class.java).configureEach { kotlinCompile ->
        kotlinCompile.compilerOptions {
            javaParameters.set(true)
        }
    }
}

private fun Project.createReleaseSourceSet() {
    val main = sourceSet(BuildType.DEBUG)
    val release = extensions.getByType(SourceSetContainer::class.java).create(BuildType.RELEASE.sourceSetName) { release ->
        release.java.setSrcDirs(listOf(provider { main.java.srcDirs }))
        release.resources.setSrcDirs(listOf(provider { main.resources.srcDirs }))
    }
    kotlinJvmExtension.sourceSets.getByName(release.name).kotlin.setSrcDirs(
        listOf(provider { kotlinJvmExtension.sourceSets.getByName(main.name).kotlin.srcDirs })
    )
    plugins.withType(ScalaBasePlugin::class.java) {
        release.extensions.getByType(ScalaSourceDirectorySet::class.java).setSrcDirs(
            listOf(provider { main.extensions.getByType(ScalaSourceDirectorySet::class.java).srcDirs })
        )
    }
    for ((releaseConfiguration, mainConfiguration) in listOf(
        release.implementationConfigurationName to main.implementationConfigurationName,
        release.compileOnlyConfigurationName to main.compileOnlyConfigurationName,
        release.runtimeOnlyConfigurationName to main.runtimeOnlyConfigurationName,
        release.annotationProcessorConfigurationName to main.annotationProcessorConfigurationName,
    )) {
        configurations.getByName(releaseConfiguration).extendsFrom(configurations.getByName(mainConfiguration))
    }
}
