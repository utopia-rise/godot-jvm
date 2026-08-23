# CI caches

This directory uses three different caches. They are GitHub Actions caches, not
workspace state: a runner starts empty, restores cache files before a build, and
saves a snapshot after it. Artifacts downloaded between jobs are deliberately
not caches; they are build inputs for that one workflow run.

## 1. SCons compilation cache

**Source:** [actions/scons-cache/action.yml](actions/scons-cache/action.yml)

**Used by:** `build_android.yml`, `build_ios.yml`, `build_linux.yml`,
`build_macos.yml`, and `build_windows.yml`.

**Contents:** `${{ github.workspace }}/.scons-cache`, SCons' content-addressed
object-file cache. It contains reusable compilation results, not the final
libraries in `bin/`.

**Key:**

```text
scons-<platform-architecture-target>-<PR branch or branch>
```

The matrix supplies the platform/architecture/target part (`cache-name`). A
normal branch run uses its branch name. A pull request uses its source branch
name (`github.head_ref`).

**Reuse:** An exact cache is restored first. If the branch/PR has no cache, the
action falls back to the matching `master` cache. SCons validates its own
signatures, so a changed C++ source or build setting is recompiled and is not
silently taken from the cache.

**Refresh and exclusions:** GitHub cache entries are immutable. The composite
action deletes this branch/PR's previous exact entry before saving the new
`.scons-cache`, so each branch keeps one refreshed SCons cache per matrix
entry. On forked PRs the token cannot delete/save it; those runs can only use
the existing fallback cache. The cache does not include `bin/`, Gradle files,
or downloaded tools.

## 2. Gradle User Home cache

**Source:** `gradle/actions/setup-gradle@v6` in `build_jvm.yml`, both deploy
workflows, and every export/test workflow.

This is the action's built-in, enhanced Gradle cache. Its keying and restore
strategy are managed by the Gradle action rather than written in our YAML. It
uses the runner OS, job/workflow/matrix identity, and commit SHA; normally it
restores the latest compatible state when the SHA changes.

**Contents:** reusable state in the runner's Gradle User Home, principally
downloaded dependencies and Gradle caches (including transforms and the local
Gradle build cache), plus setup-action metadata. It does *not* cache this
repository's `build/` directories; those are covered separately below where
needed.

**Explicit exclusions in every use:**

```text
wrapper/dists
caches/*/generated-gradle-jars
daemon
notifications
```

`cache-cleanup: always` removes unused Gradle User Home files before saving,
even if the Gradle build failed. `cache-read-only: false` permits the action to
write cache entries from these workflows.

**Reuse boundaries:** Gradle cache entries are OS/job/workflow/matrix-specific.
GitHub first restores the newest compatible entry from the current branch (or
the current PR's merge ref), then falls back to the default branch. It does not
restore from arbitrary sibling branches. This cache speeds up dependency
resolution and Gradle work; it does not replace a native image or DEX output
by itself.

## 3. Project build-output caches

These explicit `actions/cache@v4` steps preserve expensive generated output in
the integration-test Godot project. They restore before Gradle runs. Gradle
then decides whether the restored files are up to date from its declared task
inputs and outputs.

| Cache | Workflows | Contents | Exact key | Fallback |
| --- | --- | --- | --- | --- |
| Desktop Graal | `test_linux.yml`, `test_macos.yml`, `test_windows.yml` | `harness/tests/.gradle`, `harness/tests/build` | `desktop-graal-<OS>-<arch>-<github.sha>` | newest `desktop-graal-<OS>-<arch>-*` |
| iOS native image | `test_ios.yml` | `harness/tests/.gradle`, `harness/tests/build/graal`, `harness/tests/build/libs/ios`, `harness/tests/jvm/ios` | `ios-native-image-<arch>-<github.sha>` | newest `ios-native-image-<arch>-*` |
| Android build/DEX | `test_android.yml` | `harness/tests/.gradle`, `harness/tests/build` | `android-build-<OS>-<arch>-<github.sha>` | newest `android-build-<OS>-<arch>-*` |

`github.sha` is the checked-out commit (the PR merge commit for a
`pull_request` run), not the run ID. Its purpose is to preserve an updated
snapshot after each commit; it is not intended as the main reuse mechanism.
On a new commit, GitHub first finds the newest compatible cache in the current
branch/PR scope. If none exists, it falls back to the default branch's newest
matching cache. It then saves this commit's updated snapshot after a successful
job. It never selects a sibling branch's cache. The prefix is intentionally
OS/architecture-specific: native outputs must not cross those boundaries. The
iOS workflow currently only runs on macOS, so its key only needs the
architecture.

The desktop test and export workflows share an exact cache when they run the
same commit on the same OS/architecture. The iOS cache excludes unrelated
`harness/tests/build` output; Android and desktop cache their full test-project
build directory because their respective generated output lives there. None of
these caches include the Godot editor/template artifacts, the Android SDK, or
the downloaded iOS GraalVM distribution.

## What a new run does

| Run | SCons compilation cache | Gradle User Home cache | Project build-output cache |
| --- | --- | --- | --- |
| New PR | No PR cache exists, so restore the matching `master` SCons cache. | No PR merge-ref cache exists, so restore the compatible default-branch Gradle state. | No PR cache exists, so restore the newest matching `master` platform cache. |
| New commit on that PR | Restore the PR's current SCons cache; after the build, replace it with the updated cache. | Restore the newest compatible cache from that PR's merge ref; Gradle updates its state and saves it. | Restore the newest matching cache from that PR, let Gradle rebuild stale tasks, then save a new SHA-keyed snapshot. |

GitHub caches are disposable accelerators, never a correctness mechanism. A
cache miss must produce the same build; a stale restored file must be rejected
by SCons or Gradle's normal input/output checks. A re-run of an unchanged
commit can use its exact cache, but that is incidental to the two cases above.
