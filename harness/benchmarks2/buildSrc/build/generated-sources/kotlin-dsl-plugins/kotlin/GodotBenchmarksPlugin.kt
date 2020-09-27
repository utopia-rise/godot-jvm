/**
 * Precompiled [godot-benchmarks.gradle.kts][Godot_benchmarks_gradle] script plugin.
 *
 * @see Godot_benchmarks_gradle
 */
class GodotBenchmarksPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Godot_benchmarks_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
