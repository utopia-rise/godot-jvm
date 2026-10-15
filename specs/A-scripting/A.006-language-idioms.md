# A.6: Language idioms

Scripts read naturally in each of Kotlin, Java and Scala: Kotlin gets dedicated conveniences, Java and Scala reach the same capabilities through plain factories and types.

A capability shared by the three languages is only useful if it reads well in each of them. Kotlin, the main language, gets conveniences that rely on its features: property delegates for signals, reified generics for typed node and resource lookups, method references for callables, extension functions for connections. Java and Scala have none of these and use explicit factories that state the types and names Kotlin infers. Scala adds its own pitfalls, since some of its types do not map to what the JVM exposes to Godot-JVM.

How the generated Godot API reads in each language is B.1.

## Capabilities
- **A.6.1**: Kotlin scripts use delegates, reified generics, method references and extension functions for scripting tasks, so that they stay concise and type-safe.
- **A.6.2**: Java scripts reach every scripting capability through plain factories and types, so that they read as ordinary Java.
- **A.6.3**: Scala scripts use Scala's own types and declarations, so that they read as ordinary Scala.

## Rules
- **A.6.R1**: A language convenience behaves and registers exactly like the plain form it wraps.
