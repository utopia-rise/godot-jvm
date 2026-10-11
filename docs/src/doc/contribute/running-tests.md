---
description: Run Kotlin unit tests and the gdUnit4-based integration harness with the supported Godot editor.
---

# Run the tests

Run Kotlin unit tests from `kt/` with `./gradlew test`. For integration tests, use the gdUnit4-based Godot project in `harness/tests`; its addon manifest loads the native library you built.

1. Download the official Godot editor version supported by the branch. Place it in `harness/tests/bin` or set `GODOT_EDITOR` to its executable path.
2. Create the harness's embedded JRE:

    ```bash
    cd harness/tests
    ./gradlew generateEmbeddedJre
    ```

3. Build the harness and import its resources:

    ```bash
    ./gradlew importResources
    ```

4. Run the integration tests:

    ```bash
    ./gradlew runGDTests
    ```

For interactive testing, open `harness/tests/project.godot` with the matching official Godot editor.

## Editor tests

`harness/editor-monkey` tests the editor integration itself: each probe starts the official editor on that project, edits sources, runs the toolbar Gradle tasks and checks the global class list, the script members on nodes, the status light and the saved scene, the way a user would. Pass the editor with `--editor`, or set `GODOT_EDITOR` to its absolute path:

```bash
harness/editor-monkey/run.sh --editor <path-to-godot-editor>        # Linux, macOS, Git Bash
harness\editor-monkey\run.bat --editor <path-to-godot-editor>       # Windows
```

The probes are plain GDScript under `harness/editor-monkey/probes`; the project's README explains how to add one. CI runs them on Linux alongside the other platform tests.
