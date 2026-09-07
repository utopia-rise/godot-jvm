---
description: Install a JDK 17 or newer and download the Godot-JVM addon.
---

# Install

Install a JDK, then download the addon you will add to your Godot project. See [Compatibility and requirements](compatibility.md) for supported versions and platforms.

## Install a JDK

Install JDK 17 or newer; [Eclipse Temurin](https://adoptium.net/) is recommended. The JDK includes the runtime and tools needed to build your code.

/// tab | macOS
With [Homebrew](https://brew.sh/) installed, run:

```shell
brew install --cask temurin@21
```
///
/// tab | Linux
Install a JDK through your distribution's package manager, or use a [Temurin build](https://adoptium.net/temurin/releases/) for your distribution.
///
/// tab | Windows
Use an installer from [Adoptium](https://adoptium.net/temurin/releases/), or install with [Chocolatey](https://community.chocolatey.org/):

```shell
choco install temurin21
```
///

### Verify the installation

Open a new terminal and run:

```shell
java -version
javac -version
```

Both commands must report version 17 or newer.

![Java version output showing an installed JDK 17](../assets/img/jdk-version-check.png)

If they do, the JDK is on your `PATH`, which is also where the Godot editor looks for it. Nothing more is needed on Windows and Linux.

If a command is not found, or reports an older version, your installer did not update `PATH` or another Java shadows the new one. Either fix `PATH`, or set `JAVA_HOME` to the JDK's installation directory as a fallback the editor uses when nothing usable is on `PATH`.

!!! note "Which JDK the editor uses"
    The editor looks for a JVM in this order: the embedded JRE under `jvm/`, on macOS the JDK reported by `/usr/libexec/java_home -v 17+`, the first usable `java` on `PATH`, then `JAVA_HOME`. Exported games use only the embedded JRE.

### macOS: make the JDK visible to the editor

On macOS, an editor opened from Finder or the Dock does not inherit your shell's environment, so a working terminal does not guarantee the editor finds the JDK. Set `JAVA_HOME` for graphical applications, replacing the path with your JDK's home directory:

```shell
launchctl setenv JAVA_HOME /path/to/jdk/Contents/Home
```

## Download the addon

Download `godot-jvm-addon-<version>.zip` from [GitHub releases](https://github.com/utopia-rise/godot-jvm/releases). Take the latest release unless you have a reason to pin an older one.

The archive contains a single `addons/jvm/` directory: the `jvm.gdextension` manifest that tells Godot how to load the extension, the native library for every supported platform under `libs/`, and the editor icons. Nothing in it needs to be built or configured.

Keep the archive at hand. You will extract it into your Godot project on the next page, once that project exists.
