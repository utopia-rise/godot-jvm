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
