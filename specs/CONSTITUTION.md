# Constitution

Global rules of Godot-JVM. No spec may contradict an article. An implementation that does not yet satisfy an article breaks it, and the closest capability is `partial` with a tracker note naming the article. Articles have no priority order; when two pull in different directions, the maintainer decides. Adding, changing or deleting an article needs the maintainer's approval. Format: specs/FORMAT.md.

## §1: Godot integration goes through GDExtension only
- Godot-JVM integrates with Godot as a GDExtension and runs on the official, unmodified Godot editor and export templates.
  - Why: Users install an addon instead of building or downloading a custom engine.

## §2: JVM scripts can do what GDScript can do
- Anything a GDScript script can do, a JVM script can do.
  - Why: JVM languages are first-class Godot scripting languages, not a restricted alternative.

## §3: Godot comes first
- Every workflow and concept a Godot user knows from GDScript has an equivalent that gives a close experience, provided in Godot itself or by the JVM's own tools and libraries.
  - Why: Godot-JVM is used to make Godot games, so Godot's documentation, tutorials and habits must keep applying. The goal is the experience, not a one-to-one copy: JVM strings and their API, a JVM IDE with the Godot-JVM plugin, and the JVM debugger are such equivalents.

## §4: Kotlin, Java and Scala are equal in capability
- Every capability offered to scripts in one of Kotlin, Java or Scala is offered to the other two; language-specific conveniences on top of a shared capability are allowed.
  - Except: a capability built on a Kotlin-only language feature, such as coroutines.
  - Why: Godot-JVM is a binding for the JVM, not for one language, so the choice of language must not limit what a game can do. Kotlin is the main language: Java and Scala gaps are tracked as `partial` naming §4 and fixed as a best effort.

## §5: The same game everywhere
- A game has the same features in the editor, in a debug export and in a release export, on every platform and whether it runs on a JVM or as a native image.
  - Except: reloading and debugging aids; a feature built on a capability of one platform, which may be exclusive to that platform.
  - Why: What works while developing must keep working once shipped, wherever it is shipped.

## §6: The JVM ecosystem is available
- Any JVM library can be used in a Godot-JVM project as in any other JVM project.
  - Except: Limits imposed by the target platform's runtime itself, such as Android's ART or native-image restrictions.
  - Why: Access to the JVM ecosystem is a main reason to choose a JVM language for a game.

## §7: Users never touch the native side
- Everything a user needs is expressed in their own JVM language; they never deal with JNI, C++ or native libraries.
  - Why: The bridge between Godot and the JVM is Godot-JVM's job, not the user's.

## §8: Gradle is the build tool
- User projects are built with Gradle, and Gradle is the only supported build tool.
  - Why: One build tool lets every tooling feature be complete instead of spread across several half-supported ones.

## §9: Godot-JVM's own API follows Godot's stability
- Godot-JVM's own public API (core types, script registration, Gradle plugin configuration) changes incompatibly only in a major version or when a Godot change forces it; the generated Godot API follows Godot and is outside this rule.
  - Why: Outside major versions, upgrading Godot-JVM must never cost more than upgrading Godot itself.
