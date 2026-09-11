package godot.tools.common.constants

/**
 * File names the native side looks for. They must stay in sync with `cpp/paths.h`.
 */
object ArtifactNames {
    object Debug {
        /** The Godot-JVM libraries, the bootstrap code and the project's `implementation` dependencies. */
        const val BOOTSTRAP_JAR = "godot-bootstrap.jar"

        /** The project's code, its generated registrars and its `godotMain` dependencies, reloadable in the editor. */
        const val USER_CODE_JAR = "usercode.jar"

        /** Android: [BOOTSTRAP_JAR] dexed. */
        const val BOOTSTRAP_DEX_JAR = "godot-bootstrap-dex.jar"

        /** Android: [USER_CODE_JAR] and the `godotSingle` dependencies dexed. */
        const val USER_CODE_DEX_JAR = "usercode-dex.jar"
    }

    object Release {
        /** [Debug.BOOTSTRAP_JAR] and [Debug.USER_CODE_JAR] merged into one archive. */
        const val JAR = "game.jar"

        /** Android: [JAR] and the `godotSingle` dependencies dexed. */
        const val DEX_JAR = "game-dex.jar"
    }

    /** The GraalVM native image of the variant's jars; the extension is `so`, `dll` or `dylib` per desktop OS. */
    const val NATIVE_IMAGE_BASE_NAME = "game"

    /** iOS: the GraalVM native image of the variant's jars as a static library. */
    const val IOS_STATIC_LIBRARY = "game.a"
}
