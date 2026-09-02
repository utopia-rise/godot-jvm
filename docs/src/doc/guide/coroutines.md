---
description: Godot-JVM coroutine support is Kotlin-only, adding a Godot coroutine scope and suspending signal awaits through an opt-in Gradle flag.
---

# Coroutines

!!! info
    Coroutine support in Godot-JVM is Kotlin-only. The helpers documented on this page are Kotlin `suspend`/`inline` functions, so there is no Java or Scala equivalent; Java and Scala code can still use them indirectly by calling a Kotlin wrapper that you write yourself.

Coroutines are an opt-in feature that require an additional import in Kotlin. 
We follow the same logic and keep them separated from the main library. 

To use it, you need to add the following to your build.gradle:

```kotlin
godot {
    isGodotCoroutinesEnabled.set(true)
}
```

It will automatically import our coroutine library and `kotlinx.coroutines` as a dependency.
That library adds a Godot specific coroutine scope and extensions to signals. 
To use them, you simply need to write the following:

```kotlin
fun myMethod() = godotCoroutine {
    doSomething()
    mySignal.await() // the current coroutine will suspend until that signal is emitted.
    doSomething2()
}
```
