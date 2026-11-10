package godot.tools.common.constants

/**
 * File names the native side looks for. They must stay in sync with `cpp/paths.h`.
 */
object ArtifactNames {
    object Debug {
        /** The Godot-JVM libraries, the bootstrap code and the project's `implementation` dependencies. */
        const val BOOTSTRAP_JAR = "godot-bootstrap.jar"

        /** The project's code, its generated registrars and its `godotGameImplementation` and `godotGameRuntimeOnly` dependencies, reloadable in the editor. */
        const val USER_CODE_JAR = "usercode.jar"

        /** Android: [BOOTSTRAP_JAR] and the `godotSplitImplementation` and `godotSplitRuntimeOnly` dependencies dexed. */
        const val BOOTSTRAP_DEX_JAR = "godot-bootstrap-dex.jar"

        /** Android: [USER_CODE_JAR] dexed, compiled against the split dependencies [BOOTSTRAP_DEX_JAR] holds. */
        const val USER_CODE_DEX_JAR = "usercode-dex.jar"
    }

    object Release {
        /** [Debug.BOOTSTRAP_JAR] and [Debug.USER_CODE_JAR] merged into one archive. */
        const val JAR = "game.jar"

        /** Android: [JAR] and the `godotSplitImplementation` and `godotSplitRuntimeOnly` dependencies dexed. */
        const val DEX_JAR = "game-dex.jar"
    }

    /** The GraalVM native image of the variant's jars; the extension is `so`, `dll` or `dylib` per desktop OS. */
    const val NATIVE_IMAGE_BASE_NAME = "game"

    /** iOS: the GraalVM native image of the variant's jars as a static library. */
    const val IOS_STATIC_LIBRARY = "game.a"

    /**
     * Under [Paths.EDITOR_DIR]: the registered name and base of every registered class, by fully qualified name. The editor
     * answers Godot's global class queries from it when its JVM has no class for a script.
     */
    const val SCRIPT_CLASS_INDEX = "script-classes.json"

    /** Under [Paths.DEPENDENCIES_DIR]: the file names of the split dependency jars the build uses, one per line, the only ones an export packs. */
    const val SPLIT_DEPENDENCY_LIST = "split-dependencies.txt"

    /** Under [Paths.EDITOR_DIR], copied with [Debug.USER_CODE_JAR]: its source directories and the MD5 of every source in them, by `res://` path. */
    const val SOURCE_HASHES = "source-hashes.json"
}
