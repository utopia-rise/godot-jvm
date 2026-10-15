# E.5: Godot inside an Android application

An Android application can embed Godot-JVM as one of its dependencies, with its Godot scripts built and run as part of the app itself.

Today the Godot project is the main project and Android is one export target. Some teams have it the other way around: an existing Android application that wants a Godot scene in one of its screens. For them, Godot must be a dependency of the app, its scripts ordinary code of the app module, and the whole thing built, run and debugged with the Android tools they already use. The existing export flow stays as it is; this is an additional way to ship to Android.

## Capabilities
- **E.5.1**: App developers add Godot-JVM to an existing Android application as a Gradle dependency, so that Godot is one part of the app instead of the whole project.
- **E.5.2**: App developers write Godot scripts in their app module next to the app code, compiled by the Android build, so that scripts and app classes reference each other directly.
- **E.5.3**: App developers edit their app's Godot scenes in the Godot editor with the same scripts the device runs.
- **E.5.4**: App developers debug their scripts and their app code in one Android Studio session, as they debug any other screen of the app.

## Rules
- **E.5.R1**: Embedding Godot in an Android application is entered only explicitly, and leaves the existing desktop, Android and iOS export flows unchanged.
- **E.5.R2**: Scripts and the application's own code run from the same class loader.

## Non-goals
- **E.5.N1**: Godot-JVM is not embedded in iOS or desktop applications.
  - Why: Embedding is designed for Android only, where the application already runs on ART and its class loader also holds the scripts (E.5.R2).
  - Reopen if: users ask to embed Godot scenes in iOS or desktop applications.
