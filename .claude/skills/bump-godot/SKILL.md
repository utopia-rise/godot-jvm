---
name: bump-godot
description: Move Godot-JVM to a new Godot version - version declarations, godot-cpp, the API bindings, the GD singleton, CI and the harness. Use when the targeted Godot version changes.
argument-hint: "<new Godot minor, e.g. 4.8>"
---

# Bump the targeted Godot version

Godot-JVM supports a whole Godot minor from its first release, which Godot names `x.y`, so it targets that release and never a later patch.

1. **Declarations,** all to the same version:
   - `godot` in `kt/gradle/libs.versions.toml`, as `x.y`;
   - `GODOT_VERSION` (`x.y-stable`) at the top of `.github/workflows/trigger_ci.yml` and `.github/workflows/trigger_on_tag.yml`.
2. **godot-cpp:** `SConstruct` passes the `godot` major.minor to godot-cpp as `api_version`, so the fork's `godot-jvm` branch must sit on an upstream godot-cpp release whose `supported_api_versions` (`tools/godotcpp.py`) lists it; rebase the branch onto that release when it does not. Follow the `godot-cpp-fork-commit` skill for every fork commit.
3. **API, GD and core types:** follow the `regenerate-api` skill with the new editor's dump, including the `@GlobalScope` and core type comparisons and the baseline updates.
4. **Build and test:** `check-cpp` (all three targets), `./kt/gradlew -p kt build`, then `run-harness-tests` with the new official editor and export templates.
5. **Docs and specs:** search the docs for the old version number (download links, examples) and update them; run `/spec-review` on the change.

Report every place that still names the old version.
