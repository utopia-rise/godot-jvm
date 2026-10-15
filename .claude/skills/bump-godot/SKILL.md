---
name: bump-godot
description: Move Godot-JVM to a new Godot version - version declarations, godot-cpp, the API bindings, the GD singleton, CI and the harness. Use when the targeted Godot version changes.
argument-hint: "<new Godot version, e.g. 4.8.0>"
---

# Bump the targeted Godot version

1. **Declarations,** all to the same version:
   - `godot` in `kt/gradle/libs.versions.toml`;
   - `GODOT_VERSION` (`<version>-stable`) at the top of `.github/workflows/trigger_ci.yml` and `.github/workflows/trigger_on_tag.yml`.
2. **godot-cpp:** the fork's `godot-jvm` branch must carry the new version's `gdextension/extension_api.json` and interface header, usually by moving it onto the matching upstream godot-cpp. Follow the `godot-cpp-fork-commit` skill for every fork commit.
3. **API and GD:** follow the `regenerate-api` skill with the new editor's dump, including the `@GlobalScope` comparison and the baseline update.
4. **Build and test:** `check-cpp` (all three targets), `./kt/gradlew -p kt build`, then `run-harness-tests` with the new official editor and export templates.
5. **Docs and specs:** search the docs for the old version number (download links, examples) and update them; run `/spec-review` on the change.

Report every place that still names the old version.
