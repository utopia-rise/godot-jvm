---
description: Where Kotlin, Java, and Scala source files live in a Godot-JVM project, and how the Godot and Gradle project roots relate.
---

# Project layout

A Godot-JVM project is normally a single directory that is both the Godot
project root and the Gradle project root — the same `build.gradle.kts` and
`src/` tree sit next to your `project.godot` file:

```text
MyGameProject/
├── addons/
│   └── jvm/                  # the Godot-JVM GDExtension addon
│       └── jvm.gdextension
├── src/
│   └── main/
│       ├── kotlin/            # present if Kotlin is enabled
│       ├── java/              # present if Java is enabled
│       └── scala/             # present if Scala is enabled
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew / gradlew.bat
├── gradle/                     # Gradle wrapper files
└── project.godot
```

`addons/jvm/` comes from [installing the addon](install-the-addon.md); everything else is created
by whichever route you used in [Create a project](create-a-project.md).
