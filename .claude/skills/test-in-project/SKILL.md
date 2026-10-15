---
name: test-in-project
description: Try the current branch in a separate Godot-JVM game project - publish the JVM side to Maven Local, build the native library into the project's addon, and point the project at the snapshot. Use when a change must be checked outside the harness.
argument-hint: "<absolute path to the game project>"
---

# Test the branch in a game project

Full guide: `docs/src/doc/contribute/test-a-branch.md`. Close the game in Godot before rebuilding its native library.

1. **JVM side**, from the repository root:
   ```bash
   ./kt/gradlew -p kt publishLocal
   ```
   Read the published version under `~/.m2/repository/com/utopia-rise/godot-gradle-plugin/`: `<short commit hash>-SNAPSHOT` for an untagged commit.
2. **Native side**, straight into the project's addon:
   ```bash
   scons platform=<host> target=editor target_path="<project>/addons/jvm/libs/"
   ```
3. **The project**, in its own files:
   - `mavenLocal()` first in `pluginManagement.repositories` of `settings.gradle.kts` and in `repositories` of `build.gradle.kts`; both are needed;
   - the plugin version set to the published version.
4. **Build and run:** `./gradlew --refresh-dependencies build` in the project, then open it with the official editor of the version in `kt/gradle/libs.versions.toml` and run the scene that exercises the change. Check the output for loading and script errors.

After a new commit the snapshot version changes: update the project's plugin version. Uncommitted edits reuse the same version, which is why `--refresh-dependencies` matters. Android needs the AARs copied by hand (see the guide).
