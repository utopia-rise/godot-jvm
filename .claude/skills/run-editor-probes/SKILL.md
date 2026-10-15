---
name: run-editor-probes
description: Run the editor-monkey probes that drive the real Godot editor (project generation, jar reloading, renames, Build on Run), or add a probe for a new editor feature. Use to test editor integration instead of clicking through the editor by hand.
argument-hint: "[probe...] or 'new <name>'; default: every probe"
---

# Editor probes

`harness/editor-monkey/` holds GDScript probes that start the official editor with `-e -s`, act like a user and assert on what the editor shows. `harness/editor-monkey/README.md` is the reference.

## Run

1. Build the host `editor` target of the native library (`build-native` skill); the probes copy it from `harness/tests`.
2. From `harness/editor-monkey/`:
   ```bash
   ./run.sh --editor <path-to-godot-editor> [probe...]      # run.bat on Windows
   ```
   Without `--editor`, `GODOT_EDITOR` must be absolute. With no probe named, all run.
3. Each probe writes `<probe>.log`. A run fails on a `[MONKEY] FAIL` line, a missing `[MONKEY] DONE`, a script error or a JVM exception. Godot-JVM error lines some scenarios produce on purpose are printed for inspection, not failures.

The first build inside a probe compiles the libraries and takes minutes; later ones take seconds.

## Add a probe

Write `probes/<name>.gd` extending `probes/common.gd`: fill `phases` with `[title, action, task]` entries, where `task` is a toolbar entry such as `"Build"` or `""`, and assert in `report(title)` with `expect(condition, description)` and the helpers `common.gd` provides. Keep one scenario per probe, add it to the default list in `run.sh` and `run.bat`, and document it in the README's probe list.
