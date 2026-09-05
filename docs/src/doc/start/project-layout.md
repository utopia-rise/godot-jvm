---
description: Where Kotlin, Java, and Scala source files live in a Godot-JVM project, and how the Godot and Gradle project roots relate.
---

# Project layout

The Godot and Gradle projects normally share one root directory. Your build files and `src/` directory sit alongside `project.godot`:

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
├── project.godot
├── jvm/                        # JARs and embedded JRE
├── gdj/                        # dependency registration files
├── godot_jvm_configuration.json # runtime settings, written on first editor launch
└── build/                      # Gradle output, excluded from exports
```

Write your scripts under `src/main/` in the folder for their language. Keep the addon in `addons/jvm/`, and run Gradle commands from the root directory containing `gradlew` and `gradlew.bat`.

The build and first editor launch create the generated files shown here. `gdj/` appears only when dependencies contribute registered classes.
