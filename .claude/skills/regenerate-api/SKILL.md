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
5. **Hand-written mirrors of Godot:** two sets of code follow Godot by hand, and each has a baseline, the last Godot version it was compared with. Compare Godot between the baseline and the new version, adapt the code, then replace the baseline with the new version's commit.
   - **`GD` singleton:** `kt/godot-library/godot-extension-library/src/main/kotlin/godot/global/` mirrors GDScript's global functions. Compare `doc/classes/@GlobalScope.xml` and `core/variant/variant_utility.cpp` in godotengine/godot.
   - **Core types:** `kt/godot-library/godot-core-library/src/main/kotlin/godot/core/math/` reimplements the value types below. Compare each type's `core/math/<type>.h` and `.cpp` in godotengine/godot, and its class reference `doc/classes/<Type>.xml` (the public members are the GDScript-exposed ones). Update a type's row only after that type was compared in full.

   Baselines:

   | Mirror | Last compared with |
   |---|---|
   | `GD` | Godot `4.7.1-stable`, `a13da4feb8d8aefc283c3763d33a2f170a18d541` |
   | `AABB` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Basis` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Color` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Plane` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Projection` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Quaternion` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Rect2` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Rect2i` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Transform2D` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Transform3D` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Vector2` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Vector2i` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Vector3` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Vector3i` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Vector4` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |
   | `Vector4i` | Godot `4.7-stable`, `5b4e0cb0fd279832bbdd69fed5354d4e5ad26f88` |

6. Run the harness tests (`run-harness-tests` skill) and `/spec-review`: B.1's capabilities and notes follow the API.
