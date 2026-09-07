---
description: Expose script properties in the Inspector and register functions Godot can call.
---

# Properties and functions

## Properties

Use `@Export` to edit script properties in the [Inspector](https://docs.godotengine.org/en/stable/tutorials/editor/inspector_dock.html).

The following `Player` fields show common exportable types. They use `Export` from `godot.annotation`, `Node` and `Texture2D` from `godot.api`, and the containers and `Vector2` from `godot.core`.

/// tab | Kotlin

```kotlin
@Export var health: Int = 100
@Export var speed: Double = 200.0
@Export var playerName: String = "Player"
@Export var active: Boolean = true
@Export var direction: Vector2 = Vector2()
@Export var target: Node? = null
@Export var texture: Texture2D? = null
@Export var checkpoints: VariantArray<Vector2> = VariantArray()
@Export var scores: Dictionary<String, Int> = Dictionary()
```

///

/// tab | Java

```java
@Export public int health = 100;
@Export public double speed = 200.0;
@Export public String playerName = "Player";
@Export public boolean active = true;
@Export public Vector2 direction = new Vector2();
@Export public Node target = null;
@Export public Texture2D texture = null;
@Export public VariantArray<Vector2> checkpoints = new VariantArray<>(Vector2.class);
@Export public Dictionary<String, Integer> scores = new Dictionary<>(String.class, Integer.class);
```

///

/// tab | Scala

```scala
@Export var health: Int = 100
@Export var speed: Double = 200.0
@Export var playerName: String = "Player"
@Export var active: Boolean = true
@Export var direction: Vector2 = new Vector2()
@Export var target: Node = null
@Export var texture: Texture2D = null
@Export var checkpoints: VariantArray[Vector2] = new VariantArray[Vector2](classOf[Vector2])
@Export var scores: Dictionary[String, Integer] = new Dictionary[String, Integer](classOf[String], classOf[Integer])
```

///

Initial values become Inspector defaults. Assign the `target` node and `texture` resource in the Inspector; `Texture2D` is a `Resource` subclass. Exported core-type fields need an initial value or the build fails.

!!! warning "Read Inspector values in _ready"
    Saved Inspector values are applied after construction. Read them in `_ready()`.

/// tab | Kotlin

```kotlin
// Bad: this reads the default during construction.
var remainingHealth = health

// Good: read the Inspector value when ready.
override fun _ready() {
    remainingHealth = health
}
```

///

/// tab | Java

```java
// Bad: this reads the default during construction.
private int remainingHealth = health;

// Good: read the Inspector value when ready.
@Override
public void _ready() {
    remainingHealth = health;
}
```

///

/// tab | Scala

```scala
// Bad: this reads the default during construction.
var remainingHealth: Int = health

// Good: read the Inspector value when ready.
override def _ready(): Unit = {
  remainingHealth = health
}
```

///

### Enum dropdown

Declare a property whose type is an enum:

/// tab | Kotlin

```kotlin
enum class Element { FIRE, WATER, EARTH }

@Script
class Player : Node() {
    @Export
    var element = Element.FIRE
}
```

///

/// tab | Java

```java
public enum Element { FIRE, WATER, EARTH }

@Script
public class Player extends Node {
    @Export
    public Element element = Element.FIRE;
}
```

///

/// tab | Scala

!!! warning "Scala enums"
    Plain Scala 3 `enum` types are not recognized.
    For registration and `BitField`, use a Scala enum that extends `java.lang.Enum[YourEnum]`.

```scala
enum Element extends java.lang.Enum[Element] {
  case FIRE, WATER, EARTH
}

@Script
class Player extends Node {
  @Export
  var element: Element = Element.FIRE
}
```

///

For ranges, file pickers, and other controls, choose a [property hint](../reference/annotations.md#property-hints).

## Functions

The example includes an ordinary callable alongside two Godot callbacks.

/// tab | Kotlin

```kotlin
@Register
fun heal(amount: Int) {
    health = (health + amount).coerceAtMost(100)
}

override fun _ready() {
    GD.print("Player is ready")
}

override fun _process(delta: Double) {
    // Update this node each frame.
}
```

///

/// tab | Java

```java
@Register
public void heal(int amount) {
    health = Math.min(health + amount, 100);
}

@Override
public void _ready() {
    GD.print("Player is ready");
}

@Override
public void _process(double delta) {
    // Update this node each frame.
}
```

///

/// tab | Scala

```scala
@Register
def heal(amount: Int): Unit = {
  health = Math.min(health + amount, 100)
}

override def _ready(): Unit = {
  GD.print("Player is ready")
}

override def _process(delta: Double): Unit = {
  // Update this node each frame.
}
```

///

Overrides of Godot callbacks need no extra annotation with the guide's default settings. Godot calls them according to the [node lifecycle](https://docs.godotengine.org/en/stable/classes/class_node.html); use that page for the callback list.
