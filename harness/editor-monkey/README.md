# Editor monkey tests

Scripted end-to-end tests of the editor integration: each probe starts the official Godot editor on this project, drives it the way a user would (edits sources, runs the toolbar Gradle tasks, opens and saves scripts, builds scenes) and checks what the editor shows afterwards (global class list, script members on nodes, Inspector values, JVM status light, toasts, saved scenes).

## Running

Build the native GDExtension first (`scons platform=<p> target=editor` drops it into `harness/tests/addons/jvm/libs`), then:

```shell
./run.sh --editor ~/godot/Godot_v4.7.2-stable_linux.x86_64            # Linux, macOS, Git Bash
run.bat --editor C:\godot\Godot_v4.7.2-stable_win64_console.exe        # Windows
./run.sh --editor ~/godot/Godot_v4.7.2-stable_linux.x86_64 rename     # one probe
```

The editor is the `--editor` path, absolute or relative to the current directory. Without `--editor`, `GODOT_EDITOR` must hold the absolute path of the editor executable. Each probe starts from a bare Godot project: the scripts delete every JVM and generated file, copy the GDExtension from `harness/tests` with `copy_addon.sh` (or `copy_addon.bat`), run the editor with `-e --path . -s res://probes/<probe>.gd`, and write `<probe>.log`. The probe accepts the editor's "JVM project generation" dialog, so the Gradle files, the wrapper and `HelloGodot.kt` come from the editor itself, then builds. A run fails when a probe reports a `[MONKEY] FAIL` line, does not reach `[MONKEY] DONE`, or the editor prints a script error or a JVM exception. Godot-JVM error lines are printed for inspection: some scenarios, such as deleting a script a scene still uses, produce one on purpose.

After the generation the probe appends `apply(from = "../godot-jvm-builds.settings.gradle.kts")` to the generated `settings.gradle.kts`, so the build inside the editor uses the repository sources like the other harness projects and there is nothing to publish, turns the configuration cache off in the generated `gradle.properties`, which cannot hold plugins coming from an included build, and, on Windows only, turns the Gradle and Kotlin daemons off: a daemon started from the editor inherits the output of the console editor, which then waits for it and never exits. The first build of a probe compiles the libraries and takes a few minutes; later builds take seconds.

To open this project in the editor by hand, run `copy_addon.sh` (or `copy_addon.bat`) first: it copies the GDExtension from `harness/tests` without the mobile libraries.

## Probes

- `reload`: project generation, then jar reloading. New defaults, added and removed members, new and deleted scripts (one still used by the open scene), a base class change, a failing build, Fast Build, a build without changes, a bootstrap change, and the saved scene.
- `rename`: the global class list when a class is renamed in the script editor while its tab is open, and when its file is moved.
- `build_on_run`: building when the game starts. The Build on Run button cycling between never, when scripts changed and always, Shift+click to build only when a script changed (edited outside the editor or saved in the script editor), Ctrl+click (Cmd+click on macOS) to always build, and a failing build that keeps the game from starting.

## Writing a probe

A probe extends `probes/common.gd` and fills `phases` with `[title, action, task]`: the action edits files or drives the editor, `task` is a toolbar entry such as `"Build"` or `"Fast Build"` (or `""`), and the base waits for the Gradle dialog before calling `report(title)`, where the probe asserts with `expect(condition, description)`. `expect_classes`, `script_members`, `jvm_status`, `toasts`, `save_current_script` and `close_current_script` cover the usual observations. Keep a probe to one scenario; a failure stops nothing, so every expectation of a run is reported.
