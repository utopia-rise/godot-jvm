package godot.tools.common.constants

/**
 * Directory layout under the Godot project. It must stay in sync with `cpp/paths.h`.
 */
object Paths {
    /** Root of every runtime artifact the Gradle plugin writes into the Godot project. */
    const val GODOT_JVM_DIR = "jvm"

    /** Under [GODOT_JVM_DIR]: the artifacts of debug builds, loaded by the editor and by exports with debug. */
    const val DEBUG_VARIANT_DIR = "debug"

    /** Under [GODOT_JVM_DIR]: the artifacts of release builds, loaded by release exports. */
    const val RELEASE_VARIANT_DIR = "release"

    /** Under a variant directory: the `godotSingle` dependencies as intact jars, listed in the jar manifest class path. */
    const val EXTERNAL_JARS_DIR = "external"

    /** Under [GODOT_JVM_DIR]: the iOS files shared by both variants. */
    const val IOS_DIR = "ios"

    /** Under [IOS_DIR]: the static libraries of the iOS JDK. */
    const val IOS_JDK_DIR = "ios-jdk"
}
