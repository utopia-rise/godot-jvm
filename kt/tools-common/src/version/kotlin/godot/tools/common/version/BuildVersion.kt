package godot.tools.common.version

// Also compiled into build-logic, which computes it from git before tools-common exists: keep this file free of dependencies.
/**
 * The version artifacts are published and referenced under, as opposed to the Godot-JVM version declared in the
 * version catalog: the commit's version tag when it has one, its commit hash otherwise.
 */
data class BuildVersion(
    /** The commit's version tag, `x.y.z`, `x.y.z-devN` or `x.y.z-rcN`. */
    val tag: String?,
    /** Null in reproducible builds, whose output must not depend on the commit. */
    val commitHash: String?,
) {
    /** Only a release tag escapes the `-SNAPSHOT` suffix, which Maven Central's snapshot repository requires. */
    val isSnapshot: Boolean
        get() = tag == null || !tag.matches(RELEASE_TAG)

    val value: String
        get() = when {
            tag == null -> "${commitHash ?: "ci"}-SNAPSHOT"
            isSnapshot -> "$tag-SNAPSHOT"
            else -> tag
        }

    companion object {
        val RELEASE_TAG = Regex("""\d+\.\d+\.\d+""")
        val VERSION_TAG = Regex("""\d+\.\d+\.\d+(-(dev|rc)[1-9]\d*)?""")
    }
}
