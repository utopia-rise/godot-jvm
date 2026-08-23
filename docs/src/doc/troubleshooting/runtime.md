---
description: Startup and runtime symptoms for Godot-JVM, currently covering the JVM garbage collector, PATH vs JAVA_HOME precedence, and macOS JAVA_HOME visibility.
---

# Startup and runtime

This page is intentionally short. It covers the concrete runtime
symptoms we currently have documented; it will grow as more troubleshooting
reports come in from users.

## The editor uses a different JDK than the one you expect

**Symptom:** `java -version` on the command line reports one JDK, but Godot appears to be running
a different one — or a JDK you thought you removed still seems to be in use.

**Explanation:** Godot-JVM checks for a `java` executable on `PATH` before it checks `JAVA_HOME`.
If both are set and point at different JDKs, the one on `PATH` wins — `JAVA_HOME` is only consulted
as a fallback when nothing usable is found on `PATH`.

**Fix:** update `PATH` (not `JAVA_HOME`) to point at the JDK you actually want, or remove the
unwanted one from `PATH` entirely. See [Install a JDK](../start/install-a-jdk.md).

## Memory usage grows without bound after disabling the GC

**Symptom:** `RefCounted` and native-type instances keep accumulating and
are never freed.

**Explanation:** the `--jvm-disable-gc` flag (or `disable_gc` in the JSON
configuration) turns off Godot-JVM's own garbage collector. With it
disabled, `RefCounted` types and native types are no longer garbage
collected at all. See [Memory management](../contribute/how-it-works/memory-management.md)
for how Godot-JVM reconciles object bindings with the JVM garbage collector
in normal operation.

**Fix:** leave the GC enabled unless you have a specific reason to disable
it, and re-enable it if you see unbounded memory growth.

## The JVM won't start when the game is launched from the Dock/Finder on macOS

**Symptom:** the project runs fine from a terminal, but fails to find the
JDK (or the JVM does not start at all) when launched as a GUI app on macOS.

**Explanation:** on macOS, apps started from the GUI do not inherit
environment variables set in `.bashrc`/`.zshrc` — only command-line
processes see them. If `JAVA_HOME` was only ever set that way, the GUI
process never sees it.

**Fix:** set `JAVA_HOME` with `launchctl setenv JAVA_HOME <path-to-your-jdk>`
so GUI-launched processes can see it too. See
[Install a JDK](../start/install-a-jdk.md) for the full setup.
