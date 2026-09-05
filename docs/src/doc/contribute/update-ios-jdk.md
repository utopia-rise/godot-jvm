---
description: Steps for moving Godot-JVM to a newer iOS JDK: rebuild the GraalVM static libraries, refresh the CAP cache, and bump the versions the build reads.
---

# Update the iOS JDK

An iOS JDK update requires matching GraalVM static libraries, a refreshed C Annotation Processor (CAP) cache, and updated build versions.

- Create a repository based on [ios-graal-jdk-21](https://github.com/utopia-rise/ios-graal-jdk-21). Include the matching `labs-openjdk` and GraalVM repositories as submodules, with GraalVM pinned to the appropriate release tag. Update the Git patch and Xcode projects as needed, build the static libraries, and attach them to a new release.
- Update [cap-cache-generator](https://github.com/utopia-rise/cap-cache-generator). Point `GRAALVM_HOME` to the new GraalVM installation, regenerate the cache, and publish the CAP files in a tagged release.
- Update the iOS JDK and CAP cache versions in `libs.versions.toml`.
- Update the GraalVM version and download link in `docs/src/doc/build/export/ios.md`.
