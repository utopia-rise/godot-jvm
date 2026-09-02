---
description: Creating an embedded JRE for the harness Godot project and running its GUT-based integration test suite with runGDTests.
---

# Run the tests

The harness is an ordinary Godot project. Its addon is located at `harness/tests/addons/jvm` and its `jvm.gdextension` manifest loads the library built in [Build from source](build-from-source.md).

1. Download the official Godot editor version supported by the branch and place it in `harness/tests/bin`.
2. Create an embedded JRE for the host platform:

    ```bash
    cd harness/tests
    jlink --add-modules java.base,java.logging --output jvm/jre-amd64-linux
    ```

3. Build and run the tests:

    ```bash
    ./gradlew build
    ./gradlew runGDTests
    ```

Use the official Godot editor to open the harness project when testing in the editor.
