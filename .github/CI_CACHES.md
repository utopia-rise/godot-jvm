# CI caches

These are GitHub Actions caches, not workspace state: a runner starts empty,
restores cache files before a build, and saves a snapshot after it. Artifacts
downloaded between jobs are deliberately not caches; they are build inputs for
that one workflow run.

## Rules

**Only master writes.** A run on `master` (the daily schedule or a manual
dispatch) is the only one that saves a cache. Pull requests, tags and other
branches restore master's entries and never write. A PR is assumed to be a
small change on top of master, so master's entries are a good starting point,
and the repository stores exactly one entry per cache name instead of one per
branch or commit. Keys therefore contain no branch name and no commit SHA.

**Only cache what is slow to produce and cheap to store.** C++ objects, Kotlin
class files and GraalVM native images are cached. Gradle dependencies and
transforms are not: they download in about a minute and the IntelliJ
distributions alone weighed 6 GB, which evicted every other entry within hours
and left the whole CI running uncached.

**Outputs must be reproducible for a cache to hit.** Gradle decides per task
whether restored files are up to date by hashing the task's inputs. Untagged
builds normally embed the commit hash in the version, so every commit produced
different jars and Gradle rebuilt everything, native image included, even after
restoring master's entry. The test workflows set
`ORG_GRADLE_PROJECT_reproducibleVersion` so `VersionInfoPlugin` drops the hash
(`1.0.0-SNAPSHOT` instead of `1.0.0-<hash>-SNAPSHOT`), and the same plugin makes
every archive task reproducible. Local builds and every publish keep the
per-commit snapshot version. A cache miss must still produce the same build;
caches are accelerators, never a correctness mechanism.

## The composite action

Every explicit cache goes through
[actions/master-cache/action.yml](actions/master-cache/action.yml): a
`restore` step before the build and a `save` step after it. GitHub cache
entries are immutable and `actions/cache/save` silently no-ops when the key
exists, so on master the action deletes the previous entry before saving (this
needs the default token's `actions: write` permission). Off master both save
steps are skipped.

Within one run, no two jobs write the same key: SCons keys carry the matrix
job, the build-output keys carry the build task and variant, and the Gradle
build cache has a single designated writer. Two jobs saving the same key at
once would fail with `ReserveCacheError` and leave whichever one won.

## 1. SCons compilation cache

**Used by:** `build_android.yml`, `build_ios.yml`, `build_linux.yml`,
`build_macos.yml`, `build_windows.yml`.

**Contents:** `${{ github.workspace }}/.scons-cache`, SCons' content-addressed
object-file cache, not the final libraries.

**Key:** `scons-<platform-architecture-target>` from the matrix `cache-name`.

The save runs even when the build failed, since the objects that did compile
are still worth keeping. SCons validates its own signatures, so a changed
source or build setting is recompiled and never taken from the cache.

## 2. Kotlin and test-project build outputs

**Used by:** every `test_*.yml` workflow. The save step is last in the job, so
it only runs after every step succeeded.

| Key | Contents |
| --- | --- |
| `desktop-graal-<build task>-<variant>-<OS>-<arch>` (`test_linux.yml`, `test_macos.yml`, `test_windows.yml`) | `kt/**/build`, the `.gradle` directory of every included build, `harness/third-party-library/build`, `harness/tests/.gradle`, `harness/tests/build` |
| `ios-native-image-<variant>-<arch>` (`test_ios.yml`) | same `kt/**/build` and `.gradle` set, `harness/tests/build/graal`, `harness/tests/build/libs/ios`, `harness/tests/jvm/ios` |
| `android-build-<variant>-<OS>-<arch>` (`test_android.yml`) | `kt/**/build`, the `.gradle` directory of every included build, `harness/third-party-library/build`, `harness/tests/.gradle`, `harness/tests/build` |

`harness/tests` includes `kt`, `kt/api-generator`, `kt/common`,
`kt/build-logic` (through `kt`), `kt/tools-common` and
`harness/third-party-library` as included builds. `kt/**/build` holds the
compiled Godot-JVM libraries and their Kotlin incremental-compilation state,
and `harness/tests/build` holds the packaged jars and the GraalVM native image.
Gradle records task history per build in `<build root>/.gradle/<version>/executionHistory`,
so each included build's `.gradle` directory is cached too; without it no task
in that build can be marked up to date and non-cacheable tasks rerun. With reproducible outputs, Gradle marks the native image up to date when
the jars did not change, which is the single largest saving (4 to 11 minutes
per job). When a module did change, the incremental state limits recompilation
to the affected files.

The keys are OS/architecture-specific because native outputs must not cross
those boundaries, and include the build task and variant so every matrix job
writes its own entry. None of these include
the Godot editor/template artifacts, the Android SDK, or the iOS GraalVM
distribution.

## 3. Gradle build cache

**Contents:** `~/.gradle/caches/build-cache-1`, Gradle's local build cache. It is
content addressed: a `compileKotlin` whose sources and classpath were compiled
before resolves `FROM-CACHE` even when the incremental state above does not
match. Kotlin compile outputs are platform independent, so the entries are
OS-independent.

`kt/godot-library` compiles differently in release mode (the `DEBUG`
preprocessor definition flips), so there are two entries,
`gradle-build-cache-debug` and `gradle-build-cache-release`, and each job
restores only the one for its flavor. `deploy_jvm.yml` publishes both flavors
and restores both. The test matrices carry a `release` boolean; when set, every
Gradle invocation of the job gets `-Prelease`, which the included builds see as
well. This is what makes the release export jobs test release-compiled
libraries rather than a release harness on top of debug libraries.

**Restored by:** `build_jvm.yml`, `deploy_jvm.yml` and every test workflow,
right after `setup-gradle`, whose own caching is turned off with
`cache-disabled: true`.

**Written by:** the Linux "Editor tests" job writes the debug entry and the
Android "Release export tests" job writes the release entry, each at the end
of its job. One writer per key, so no two jobs ever race for it.

## What a new run does

| Run | SCons | Kotlin and test-project outputs | Gradle build cache |
| --- | --- | --- | --- |
| Any PR commit | Restore master's entry; never save. | Restore master's entry, let Gradle skip or rebuild per task; never save. | Restore the entry for the job's flavor; never save. |
| Daily or dispatched master run | Restore, then replace after the build. | Restore, then replace after a successful job. | Restore everywhere; the Linux editor and Android release jobs replace their entry. |
