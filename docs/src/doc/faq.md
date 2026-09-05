---
description: Answers to common Godot-JVM questions about builds, registration, runtime, exports, and known limitations.
---

# FAQ

Find the symptom you're seeing, then work through its checks or fix.

- [Build and registration](#build-and-registration)
- [Startup and runtime](#startup-and-runtime)
- [Export](#export)
- [Known limitations](#known-limitations)

## Build and registration

Start with a successful full `build`, then check the missing declaration below. Registration checks run on compiled classes, so `fastBuild` cannot pick up a new or changed registration.

### Building from the editor fails with "Could not create child process: .../gradlew"

On Linux or macOS, the build can fail if `gradlew` is not executable:
```shell
ERROR: Godot-JVM: Could not create child process: /Users/username/projectname/gradlew
```

Run this command from the project root, then build again:
```shell
chmod +x gradlew
```

### Before you build

- Does the script extend a Godot class such as `Node` or `Resource`?
- If it has a constructor, is there a public constructor with no parameters?
  Godot can only instantiate a script through a public parameterless
  constructor; constructors with parameters are never exposed to Godot.
- Does every registered script have a unique Godot name? Use
  `@Script(className = "AUniqueName")` if two classes share the same simple name.
- Do exposed properties and function parameters use Godot-supported types?
- Are the registered classes and functions non-generic?

Build again after adding, removing, renaming, or changing an exported
property, a signal, a function that Godot calls, or a script class. Changing
only the code inside an existing method does not require any additional
registration steps.

### A class is missing

- Does it inherit a Godot API class?
- Was its source language identified? Godot-JVM recognizes `.kt`, `.java`,
  and `.scala` source files; an unrecognized extension is skipped.
- Does the current registration mode select it?
- In Explicit mode, is `@Script` directly present? In Inferred mode, is it present directly or through a meta-annotation?
- Does its registered name collide with another class?

### A property is missing

- Do the field and accessors have consistent names and types? The processor must recognize them as one property.
- Is its field or accessor public?
- Does the current registration mode select it?
- Is its type mappable to Godot?
- Is it a getter/setter-style method that was intentionally registered as a
  function instead (`@Register` without being annotated as a property with `@Visible`)?

### A function is missing

- Is it public and declared directly on the class (not only inherited)?
- Does the current registration mode select it?
- Is it an accessor-shaped method not annotated as a function (`@Register`)? Such
  a method stays a property unless `@Register` marks it as a function too.
- Are all parameter and return types mappable to Godot?
- Does it exceed the 16-parameter limit?

### A signal is missing

- Is the signal declared as a member of the script class?
- Does it use a `SignalN` type?
- In Explicit mode, does it have a direct `@Emit`?
- Is its containing class selected for registration?

### The editor and the build disagree

- Check that the IntelliJ **Settings > Godot-JVM > Annotation processing mode** setting matches `annotationProcessingMode` in `build.gradle.kts`
  before changing your code. Gradle decides what actually
  gets registered; the IDE setting only keeps inspections and highlighting
  consistent with it.

## Startup and runtime

Check these symptoms when the JVM fails to start, uses an unexpected JDK, or stops releasing memory.

### The editor uses a different JDK than the one you expect

**Symptom:** `java -version` on the command line reports one JDK, but Godot appears to be running
a different one, or a JDK you thought you removed still seems to be in use.

**Explanation:** The editor looks for a JVM in this order: the embedded JRE under `jvm/`, on macOS the JDK reported by `/usr/libexec/java_home -v 17+`, the first usable `java` on `PATH`, then `JAVA_HOME`. Exported games use only the embedded JRE.

**Fix:** update `PATH` to select the intended JDK, or remove the unwanted JDK from it.

### Memory usage grows without bound after disabling the GC

**Symptom:** `RefCounted` and native-type instances keep accumulating and
are never freed.

**Explanation:** the `--jvm-disable-gc` flag (or `disable_gc` in the JSON
configuration) turns off Godot-JVM's own garbage collector. With it
disabled, `RefCounted` types and native types are no longer garbage
collected at all.

**Fix:** leave the GC enabled unless you have a specific reason to disable
it, and re-enable it if you see unbounded memory growth.

### The JVM does not start when the editor is launched from the Dock or Finder on macOS

**Symptom:** the editor runs fine from a terminal, but fails to find the JDK when launched as a GUI app on macOS.

**Explanation:** apps started from Finder or the Dock do not inherit variables from `.bashrc` or `.zshrc`. A `JAVA_HOME` set only in those files is unavailable to them. This affects the editor only; exported games use the embedded JRE.

**Fix:** set `JAVA_HOME` with `launchctl setenv JAVA_HOME <path-to-your-jdk>`
so GUI-launched processes can see it too.

### GraalVM native image does not reload code changes

**Symptom:** editing a script while running a GraalVM native-image build has
no effect, even after rebuilding.

**Explanation:** a native image is compiled ahead of time and cannot reload classes.

**Fix:** rebuild and restart the native-image application. Use an embedded or system JVM during development if you need editor code reloading.

## Export

### Missing JRE for the export target

**Symptom:** the export fails with `JRE does not exist at res://jvm/jre-...`.

**Explanation:** Godot selects the JRE directory from the export preset's OS and architecture, not the export host.

**Fix:** create a JRE for that target with a matching JDK in `jvm/jre-<amd64|arm64>-<linux|windows|macos>`. A universal macOS export needs both architectures.

### Android export fails because an AAR file is missing

**Symptom:** exporting to Android fails because
`addons/jvm/libs/android/debug/godot-jvm-debug.aar` or
`addons/jvm/libs/android/release/godot-jvm-release.aar` is missing.

**Explanation:** Godot adds one of these files automatically during export;
Godot-JVM's addon package must already contain it.

**Fix:** reinstall a complete Godot-JVM addon release before exporting.

### Runtime files deleted from user://

**Symptom:** clearing game data deletes runtime JARs and breaks the next launch.

**Fix:** restrict cleanup to your game's own files so runtime files remain available.

## Known limitations

- **No tool mode.** `@Tool` exists and implies `@Script`, but has no effect yet.
- **No addon support.** You cannot use Godot-JVM to write Godot plugins or
  addons yet. You can share Godot-specific code through JVM libraries consumed by Godot-JVM projects.
- **Web export is not supported.** The supported targets are Windows, Linux, macOS, Android, and iOS.
- **GraalVM native image cannot reload code changes.** Rebuild and restart to apply script changes.
- **Functions are limited to 16 parameters.** This is a Godot-JVM limitation, not
  a Godot engine one. Group additional values in a Godot-compatible container such as a `VariantArray` or `Dictionary`.
