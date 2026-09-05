---
description: Diagnose JVM startup, JDK selection, macOS editor launch, garbage collection, and GraalVM code reloading problems.
---

# Startup and runtime

Check these symptoms when the JVM fails to start, uses an unexpected JDK, or stops releasing memory.

## The editor uses a different JDK than the one you expect

**Symptom:** `java -version` on the command line reports one JDK, but Godot appears to be running
a different one, or a JDK you thought you removed still seems to be in use.

**Explanation:** The editor looks for a JVM in this order: the embedded JRE under `jvm/`, on macOS the JDK reported by `/usr/libexec/java_home -v 17+`, the first usable `java` on `PATH`, then `JAVA_HOME`. Exported games use only the embedded JRE.

**Fix:** update `PATH` to select the intended JDK, or remove the unwanted JDK from it.

## Memory usage grows without bound after disabling the GC

**Symptom:** `RefCounted` and native-type instances keep accumulating and
are never freed.

**Explanation:** the `--jvm-disable-gc` flag (or `disable_gc` in the JSON
configuration) turns off Godot-JVM's own garbage collector. With it
disabled, `RefCounted` types and native types are no longer garbage
collected at all.

**Fix:** leave the GC enabled unless you have a specific reason to disable
it, and re-enable it if you see unbounded memory growth.

## The JVM does not start when the editor is launched from the Dock or Finder on macOS

**Symptom:** the editor runs fine from a terminal, but fails to find the JDK when launched as a GUI app on macOS.

**Explanation:** apps started from Finder or the Dock do not inherit variables from `.bashrc` or `.zshrc`. A `JAVA_HOME` set only in those files is unavailable to them. This affects the editor only; exported games use the embedded JRE.

**Fix:** set `JAVA_HOME` with `launchctl setenv JAVA_HOME <path-to-your-jdk>`
so GUI-launched processes can see it too.

## GraalVM native image does not reload code changes

**Symptom:** editing a script while running a GraalVM native-image build has
no effect, even after rebuilding.

**Explanation:** a native image is compiled ahead of time and cannot reload classes.

**Fix:** rebuild and restart the native-image application. Use an embedded or system JVM during development if you need editor code reloading.
