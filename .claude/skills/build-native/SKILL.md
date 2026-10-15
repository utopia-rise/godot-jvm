---
name: build-native
description: Build the native GDExtension with SCons for a platform and target, into the harness or into another project. Use whenever C++ under cpp/ or the project templates changed and the extension must be rebuilt.
argument-hint: "[platform] [target] [target_path]; default: host platform, editor"
---

# Build the native GDExtension

Run SCons from the repository root. Platforms are `linux`, `windows`, `macos`, `android`, `ios` (godot-cpp naming). Targets are `editor`, `template_debug`, `template_release`.

```bash
scons platform=<platform> target=<target> -j<cores>
```

- **Output:** desktop libraries land in `harness/tests/addons/jvm/libs/<platform>/`, where the harness picks them up; nothing to copy. To build into another Godot-JVM project, add `target_path="/absolute/path/to/project/addons/jvm/libs/"` (keep the trailing `/`).
- **Templates:** SCons regenerates `cpp/editor/project/templates.h` from the IntelliJ plugin templates on every build, so a template edit only needs this build.
- **`dev_build=yes`** keeps the ordinary file name and overwrites the ordinary library: the two variants cannot coexist, and a dev build runs at roughly half speed with `DEV_ENABLED` assertions on. Rebuild without it before measuring anything.
- **Android:** build both targets for each ABI (`arch=arm64`, `arch=x86_64`); they go to `build/android/`. Then package the AARs with `./kt/gradlew -p kt :android-plugin:assemble`.
- **A locked library** ("Access is denied" on Windows): a Godot process still holds it. Find it; kill only a process the harness started, and ask the user to close their own editor.
- **C1083 on a godot-cpp header:** `build_profile.json` is an allowlist of godot-cpp classes; add the class there.

After changing includes or `#ifdef` code, build all three targets: see the `check-cpp` skill.
