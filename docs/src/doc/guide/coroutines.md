---
description: Kotlin-only coroutine support for Godot-JVM, including node-owned scopes, frame waits, and signals.
---

# Coroutines

!!! info
    Coroutine support is available to Kotlin scripts only.

Enable it in `build.gradle.kts`:

```kotlin
godot {
    isGodotCoroutinesEnabled.set(true)
}
```

Coroutines suit gameplay that is a sequence of dependent waits: wait for a player, create enemies, wait until they are defeated, then give a reward. A coroutine keeps its local values and resumes at the next line when its wait completes. It does not block Godot's main thread while it waits.

## Starting work

`Node.launch` starts a coroutine owned by that node. It is valid only once the node has entered the scene tree. The node gets one `NodeScope`; Godot-JVM cancels it when the node exits the tree, which also cancels all of its child coroutines and pending waits.

```kotlin
override fun _ready() {
    launch {
        // This coroutine belongs to this node.
    }
}
```

`Node.async` is the equivalent when the caller needs a result as a `Deferred<T>`.

```kotlin
val route = async { findRoute() }
val result = route.await()
```

Both blocks have `NodeScope` as their receiver. Standard coroutine builders remain available inside them: `launch`, `async`, `coroutineScope`, `supervisorScope`, and so on. Their child coroutines inherit the same node lifetime unless a different scope is deliberately supplied.

For work that does not belong to a node, use `godotCoroutine()`. It is an ordinary `CoroutineScope` whose default dispatcher is Godot's main thread. Keep its reference and cancel it yourself when its owner is done.

```kotlin
private val gameScope = godotCoroutine()

gameScope.launch {
    // Main-thread Godot work.
}
```

## Waiting for frames

There are two deliberately distinct sets of frame waits:

```kotlin
// SceneTree-wide: valid in any coroutine running while Godot has a SceneTree.
awaitNextFrame()
awaitNextPhysicsFrame()

// Node-owned: available inside Node.launch / Node.async.
// They resume on a frame where that node can process.
awaitNextProcess()
awaitNextPhysicsProcess()
```

Use the SceneTree-wide waits for global systems. Use the node-owned waits for a gameplay node: if the node is paused, disabled, or leaves the tree, its wait does not continue as if it were still active.

## Signals and flows

For one signal emission, use `await()`:

```kotlin
victoryJingle.finished.await()
```

For a stream of repeated emissions, turn the signal into a Kotlin `Flow` with `asFlow()`. A flow does nothing until it is collected; collection owns the signal connection, and cancelling the collection disconnects it.

```kotlin
launch {
    healthChanged.asFlow<Int>().collect { health ->
        healthBar.value = health
    }
}

val player = bodyEntered.asFlow<Node3D>()
    .first { it is Player }
```

`first`, `filter`, `map`, `debounce`, `take`, and the rest of the Kotlin Flow operators make signal streams useful when the requirement is more than one callback. For a single event, `await()` is normally clearer.

## Threads

`Node.launch` and `godotCoroutine()` begin on Godot's main thread. A signal or frame wait also resumes there, so regular scene-tree work can remain direct and readable.

Use `offload` for pure CPU work only. Do not read or modify nodes, resources, or the scene tree from its block. `threadSafe` switches back to the main-thread dispatcher before touching Godot objects.

```kotlin
val route = offload { calculateRoute(grid, start, goal) }

threadSafe {
    navigationAgent.targetPosition = route.last()
}
```

## Complete example: a one-wave encounter

This `Area3D` waits for the player, stops the stage music, plays battle music, creates a randomly chosen enemy at random points within its box, waits for every enemy to leave the tree, gives fifteen coins, restores the stage music, and removes itself. Assign the exported scenes, audio players, and collision shape in the Inspector. `StageMusic` is a sibling of the encounter.

```kotlin
package Encounter

import Enemies.Enemy
import Player.Coin.Coin
import Player.Player
import godot.annotation.Export
import godot.annotation.Script
import godot.api.Area3D
import godot.api.AudioStreamPlayer
import godot.api.BoxShape3D
import godot.api.CollisionShape3D
import godot.api.Node3D
import godot.api.PackedScene
import godot.core.VariantArray
import godot.core.Vector3
import godot.coroutines.NodeScope
import godot.coroutines.asFlow
import godot.coroutines.await
import godot.coroutines.awaitNextProcess
import godot.coroutines.launch
import godot.coroutines.offload
import godot.extension.api.getNodeAs
import godot.extension.api.instantiateAs
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlin.random.Random

@Script
class Encounter : Area3D() {
    private data class Spawn(val sceneIndex: Int, val x: Double, val z: Double)

    @Export var enemyScenes: VariantArray<PackedScene> = VariantArray()
    @Export var enemyCount = 4
    @Export lateinit var coinScene: PackedScene
    @Export lateinit var battleMusic: AudioStreamPlayer
    @Export lateinit var victoryJingle: AudioStreamPlayer
    @Export lateinit var encounterShape: CollisionShape3D

    private lateinit var stageMusic: AudioStreamPlayer

    override fun _ready() {
        stageMusic = getNodeAs("../StageMusic")!!

        launch {
            battleMusic.finished.asFlow().collect { battleMusic.play() }
        }
        launch { runEncounter() }
    }

    private suspend fun NodeScope.runEncounter() {
        bodyEntered.asFlow<Node3D>().first { it is Player }
        awaitNextProcess()

        val level = checkNotNull(getParent())
        val choices = enemyScenes.toList()
        val halfSize = (encounterShape.shape as BoxShape3D).size * 0.5
        val spawns = offload {
            List(enemyCount) {
                Spawn(
                    sceneIndex = Random.nextInt(choices.size),
                    x = Random.nextDouble(-halfSize.x, halfSize.x),
                    z = Random.nextDouble(-halfSize.z, halfSize.z),
                )
            }
        }

        stageMusic.stop()
        battleMusic.play()

        val defeated = spawns.map { spawn ->
            val enemy = choices[spawn.sceneIndex].instantiateAs<Enemy>()!!
            enemy.coinsCount = 0
            level.addChild(enemy)
            enemy.globalPosition = encounterShape.toGlobal(Vector3(spawn.x, 0.0, spawn.z))
            async { enemy.treeExiting.await() }
        }
        defeated.awaitAll()

        battleMusic.stop()
        victoryJingle.play()
        repeat(15) {
            val coin = coinScene.instantiateAs<Coin>()!!
            level.addChild(coin)
            coin.globalPosition = encounterShape.globalPosition
            coin.spawn()
        }
        victoryJingle.finished.await()

        stageMusic.play()
        queueFree()
    }
}
```

The encounter's two coroutines are both owned by the `Encounter` node. If the encounter leaves the tree at any point, its signal collectors, frame wait, enemy waits, and remaining sequence are all cancelled automatically. The enemies and coins are added to the encounter's parent, so the reward can remain after the encounter node removes itself.
