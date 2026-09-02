# Exported-build test runner

This folder contains a small, **custom GdUnit test runner used only when running
the test suite from an _exported_ build** (the `runExportedGDTests` Gradle task).
It lives outside `addons/gdUnit4/` on purpose, so upgrading the gdUnit4 addon
never overwrites or deletes it.

## Why this exists

gdUnit4's normal command-line entry point,
`res://addons/gdUnit4/bin/GdUnitCmdTool.gd` (→ `GdUnitTestCIRunner`), is built for
running tests with the **editor binary**. It pulls in editor-only code
(`GdUnitCommandHandler` → `EditorInterface`, the inspector UI, etc.). Inside an
**exported** game that machinery has no business running — it either fails to
load or hangs.

gdUnit's supported way to run tests in an exported project is to use a minimal
runner that extends the (now editor-decoupled) `GdUnitTestSessionRunner`:

- run-in-exports support / decoupling: gdUnit issues #969 and PR #973
- "exclude the UI related parts" guidance: gdUnit discussion #650

So `ExportTestRunner.gd` extends `GdUnitTestSessionRunner` and uses only the
export-safe discovery + execution core (`GdUnitTestSuiteScanner`,
`GdUnitTestDiscoverer`, `GdUnitTestSuiteExecutor`). `ExportTestMain.gd` is the
`SceneTree` entry point that instantiates it.

The harness project is configured to use `ExportTestMain` as its
`application/run/main_loop_type`, so exported test binaries boot directly into
the custom runner without relying on a `-s ...` command-line override.

## Required export setting (do not remove)

The test export presets (`tests_android`, `tests_linux`, `tests_macos`, `tests_windows` in
`export_presets.cfg`) must **exclude the gdUnit4 editor scenes**:

```
exclude_filter="addons/gdUnit4/*.tscn"
```

Without this, the editor instantiates gdUnit's `@tool` scenes (e.g.
`GdUnitInspector.tscn`) while packing the export and then **crashes on shutdown**
(`SIGSEGV` / `SIGABRT`) — a latent Godot cold-cache + plugin teardown bug
(gdUnit #1151, Godot #99284 / #100260). Excluding only the `.tscn` scenes keeps
every gdUnit `.gd` script in the export (so `preload`s still compile), while
preventing the crash. We exclude scenes rather than the whole addon because the
exported build still needs the gdUnit runtime to execute the tests.

## How it is run

The exported executable is launched normally. On Linux CI we add `--headless`
when no display server is available, but we no longer override the main loop
from the command line because the export already boots into `ExportTestMain`.

Exit code: `0` = all tests passed, `100` = failures/errors (see
`GdUnitTestSessionRunner` return codes).

Android does not expose the game process exit code to the host. The Android CI
job therefore waits for the runner's `GODOT_JVM_TEST_RESULT:PASS` or `FAIL`
log marker instead.

## Output

- **Console**: per-test PASS/FAIL output via `GdUnitConsoleTestReporter`.
- **Reports**: the default session hooks write a JUnit XML report (`results.xml`)
  and an HTML report into `<exported-executable-dir>/reports/report_<n>/`
  (i.e. `harness/tests/export/reports/...`). This is the directory the CI
  workflow uploads as the `gdunit_reports_*` artifact.
