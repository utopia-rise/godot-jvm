---
name: regenerate-api
description: Regenerate the Godot API bindings from api.json, and check whether the GD singleton must follow changes to Godot's @GlobalScope. Use after api.json changes, or when the generator itself changed.
---

# Regenerate the Godot API

`kt/godot-library/godot-api-library/` and the `gen` directories of the core, extension and coroutine libraries are generated. Never edit them by hand.

1. **api.json:** for a new Godot version, dump it with that official editor, `godot --headless --dump-extension-api`, and replace `kt/api-generator/src/main/resources/api.json` with the produced `extension_api.json`.
2. **Generate:** `./kt/gradlew -p kt generateAPI`.
3. **Line endings:** generation rewrites every file with LF endings, so unchanged files show as modified with empty diffs. `git checkout` those and keep only files whose content changed.
4. **Compile:** `./kt/gradlew -p kt build`. A Godot rename or removal can break hand-written code in the core or extension libraries; fix it there, never in generated files.
5. **GD singleton:** `kt/godot-library/godot-extension-library/src/main/kotlin/godot/global/` mirrors GDScript's global functions by hand. Compare Godot's `@GlobalScope` between the baseline below and the new version: `doc/classes/@GlobalScope.xml` and `core/variant/variant_utility.cpp` in godotengine/godot. Add, change or remove the matching `GD` functions, then replace the baseline with the new version's commit.

   Baseline, the last version `GD` was synchronized with: Godot `4.7.1-stable`, `a13da4feb8d8aefc283c3763d33a2f170a18d541`.
6. Run the harness tests (`run-harness-tests` skill) and `/spec-review`: B.1's capabilities and notes follow the API.
