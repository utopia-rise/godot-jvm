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

## The composite actions

Every cache goes through one of three small actions, called with a `mode`
(`restore` before the build, `save` after it) and the discriminator that makes
the key unique per writing job:

- [actions/scons-cache](actions/scons-cache/action.yml), `name`: platform,
  architecture and target
- [actions/kotlin-cache](actions/kotlin-cache/action.yml), `name`: platform,
  build task/variant and architecture
- [actions/gradle-build-cache](actions/gradle-build-cache/action.yml),
  `flavor`: `debug` or `release`

Each owns its paths and key prefix and delegates to
[actions/master-cache](actions/master-cache/action.yml), which only knows how
to restore an exact key and, on master, delete the previous entry and save
(this needs the default token's `actions: write` permission; GitHub cache
entries are immutable and `actions/cache/save` silently no-ops when the key
exists). Off master both save steps are skipped.

Within one run, no two jobs write the same key: SCons names carry the matrix
job, Kotlin names carry the platform, build task and variant, and each Gradle
build cache flavor has a single designated writer. Two jobs saving the same key
at once would fail with `ReserveCacheError` and leave whichever one won.

## 1. `scons-cache`: C++ compilation cache

**Used by:** `build_android.yml`, `build_ios.yml`, `build_linux.yml`,
`build_macos.yml`, `build_windows.yml`.

**Contents:** `${{ github.workspace }}/.scons-cache`, SCons' content-addressed
object-file cache, not the final libraries. The workflows also export the same
path as `SCONS_CACHE` for SCons itself.

**Key:** `scons-<platform-architecture-target>` from the matrix `cache-name`.

The save runs even when the build failed, since the objects that did compile
are still worth keeping. SCons validates its own signatures, so a changed
source or build setting is recompiled and never taken from the cache.

## 2. `kotlin-cache`: library and test-project build outputs

**Used by:** every `test_*.yml` workflow. The save step is last in the job, so
it only runs after every step succeeded.

**Contents:** `kt/**/build` (compiled Godot-JVM libraries and their Kotlin
incremental-compilation state), `harness/tests/build` and
`harness/tests/jvm/ios` (packaged jars, GraalVM native image, iOS image),
`harness/third-party-library/build`, and the `.gradle` directory of every
build the harness includes: `harness/tests`, `kt`, `kt/api-generator`,
`kt/common`, `kt/tools-common`, `kt/build-logic` and
`harness/third-party-library`. Gradle records task history per build in
`<build root>/.gradle/<version>/executionHistory`; without it no task in that
build can be marked up to date and non-cacheable tasks rerun.

**Keys:**

| Key | Workflows |
| --- | --- |
| `kotlin-desktop-<build task>-<variant>-<OS>-<arch>` | `test_linux.yml`, `test_macos.yml`, `test_windows.yml` |
| `kotlin-ios-<variant>-<arch>` | `test_ios.yml` |
| `kotlin-android-<variant>-<OS>-<arch>` | `test_android.yml` |

With reproducible outputs, Gradle marks the native image up to date when the
jars did not change, which is the single largest saving (4 to 11 minutes per
job). When a module did change, the incremental state limits recompilation to
the affected files. The keys are flavor- and platform-specific because native
outputs must not cross those boundaries and every matrix job writes its own
entry. None of these include the Godot editor/template artifacts, the Android
SDK, or the iOS GraalVM distribution.

## 3. `gradle-build-cache`: Kotlin compile results

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

| Run | `scons-cache` | `kotlin-cache` | `gradle-build-cache` |
| --- | --- | --- | --- |
| Any PR commit | Restore master's entry; never save. | Restore master's entry, let Gradle skip or rebuild per task; never save. | Restore the entry for the job's flavor; never save. |
| Daily or dispatched master run | Restore, then replace after the build. | Restore, then replace after a successful job. | Restore everywhere; the Linux editor and Android release jobs replace their entry. |
