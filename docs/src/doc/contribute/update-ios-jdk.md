---
description: Steps for moving Godot-JVM to a newer iOS JDK: publish a new toolchain bundle from ios-graal-native-image, then bump the versions the build reads.
---

# Update the iOS JDK

The iOS static libraries and the CAP (C Annotation Processor) cache both come from
[ios-graal-native-image](https://github.com/utopia-rise/ios-graal-native-image). That repo builds
them in one GitHub Actions run and publishes them as a single ZIP, so the libraries and the CAP
cache can never drift apart. It replaces the two repositories used up to JDK 21,
[ios-graal-jdk-21](https://github.com/utopia-rise/ios-graal-jdk-21) and
[cap-cache-generator](https://github.com/utopia-rise/cap-cache-generator), which were built by hand
on a maintainer's machine.

## Publish a new toolchain bundle

In `ios-graal-native-image`:

- Point the `labs-openjdk` submodule at the tag for the JDK you are moving to, and the `graal`
  submodule at the matching GraalVM release branch. The two must agree: a labs-openjdk 25 source
  tree needs `release/graal-vm/25.0`.
- Update `toolchain.env` (`JDK_VERSION`, `GRAALVM_VERSION`, `JVMCI_VERSION`, `IOS_MIN_VERSION`).
  `GRAALVM_VERSION` must match the labs-openjdk submodule down to the update version, not just the
  feature release. JNI natives change within a JDK update line — 25.0.3 replaced
  `java.io.Console.istty` with `ttyStatus` — and native-image builds the image against its own
  class library, so a mismatch only shows up when a game links the archives.
- Expect to update `labs-openjdk/ios-jdk.patch` and both Xcode projects. Most breakage between JDK
  versions is mechanical: source files added or removed under
  `src/java.base/*/native/lib*`, new platform headers, and new `-D` defines the JDK build passes.
  Diffing the old and new JDK trees for the directories the Xcode projects compile from finds these
  faster than reading build failures one at a time.
- `svm/src/main/native/JvmFuncsFallbacks.c` is a checked-in copy of a file GraalVM normally
  generates from the JVM symbols the JDK's static libraries reference. It goes stale on every JDK
  bump, in both directions: a `JVM_*` entry point added to the new JDK leaves an undefined symbol,
  and one that GraalVM has since implemented itself becomes a duplicate symbol. Neither breaks the
  toolchain build — they only surface when a game links the archives.
- Push a tag. The workflow builds everything, verifies the bundle, and creates the release. The tag
  is the release name and the bundle name, so tag `jdk26` publishes `ios-graal-jdk26.zip`.

## Point Godot-JVM at it

- In `kt/gradle/libs.versions.toml`, set `iosGraalNativeImage` to the tag you just pushed. That is
  the only version the build reads: the libraries land in `jvm/ios/ios-jdk/` with no version in
  the path, so `cpp/paths.h` does not change when the JDK does.
- Update the GraalVM download link and version in the [iOS export guide](../build/export/ios.md),
  and the GraalVM the iOS CI job installs in `.github/workflows/test_ios.yml`. All three must name
  the same GraalVM release the bundle was built against, otherwise `native-image` will reject the
  CAP cache.
