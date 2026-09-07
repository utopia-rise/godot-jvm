---
description: GD global functions, exact numeric overloads, logging, random numbers, resource loading, and binding helper locations.
---

# Global functions and helpers

## `GD` { #gd }

Package: `godot.global`. Methods are exposed as static JVM methods. Numeric operations run through the binding/JVM implementation; engine-backed operations require a running Godot runtime.

/// tab | Kotlin

```kotlin
import godot.global.GD

GD.print("Ready")
```

///

/// tab | Java

```java
import godot.global.GD;

GD.print("Ready");
```

///

/// tab | Scala

```scala
import godot.global.GD

GD.print("Ready")
```

///

## Resource loading { #load }

`load` loads a resource at call time. `path` is required; use an absolute resource path such as `res://player.tscn`. `typeHint` defaults to `""`; `cacheMode` defaults to `ResourceLoader.CacheMode.REUSE`. Returns the resource or null on failure. Java overloads allow omitting the optional arguments.

/// tab | Kotlin

```kotlin
import godot.api.PackedScene
import godot.global.GD

val scene: PackedScene? = GD.load<PackedScene>("res://player.tscn")
```

///

/// tab | Java

```java
import godot.api.PackedScene;
import godot.global.GD;

PackedScene scene = GD.load("res://player.tscn");
```

///

/// tab | Scala

```scala
import godot.api.PackedScene
import godot.global.GD

val scene: PackedScene = GD.load[PackedScene]("res://player.tscn")
```

///

There is no compile-time `preload` equivalent. A generic result type does not turn an incompatible resource into that type.

## Logging

An exception escaping a JVM callback is logged with its stack trace. The Godot-side call returns a default value (nil for a registered function result) and the game keeps running; the remaining statements in the failed callback do not run.

These operations return no value. Except `printStack()`, each accepts zero or more Variant/JVM values to format.

| Method | Output |
|---|---|
| `print(args...)` | Godot output |
| `printRich(args...)` | Rich-text Godot output |
| `printVerbose(args...)` | Verbose output |
| `printErr(args...)` | Error output |
| `printRaw(args...)` | Raw output |
| `prints(args...)` | Values separated by spaces |
| `printt(args...)` | Values separated by tabs |
| `pushError(args...)` | Godot error report |
| `pushWarning(args...)` | Godot warning report |
| `printStack()` | Current JVM thread's stack trace |

## Objects and shutdown

| Method | Result/effect |
|---|---|
| `isInstanceValid(object)` | Boolean; false for null or a deleted native object |
| `syncMemory()` | Requests binding memory synchronization |
| `callWhenClosing(callback)` | Registers a no-argument, Kotlin-Unit-returning shutdown callback |

See [Objects and lifetime](objects.md) for language syntax and lifetime restrictions.

## Strings, colors, and assertions

| Method | Contract |
|---|---|
| `len(value)` | Integer length for supported strings/collections/core containers; unsupported values throw `IllegalArgumentException` |
| `ord(text)` | Integer value of the first UTF-16 character; an empty string fails with an index error |
| `char(code)` | Converts a JVM character code to a one-character string |
| `Color8(r8, g8, b8, a8)` | Builds a `Color` by dividing integer channels by 256; Kotlin alpha default is `255` |
| `ColorN(name, alpha)` | Named color with alpha; Kotlin alpha default is `1f` |
| `assert(condition, message)` | JVM assertion; message defaults to empty and assertions must be enabled to take effect |

Java cannot call methods named `char` or `assert` in source because these are Java keywords. Use Java character conversion or Java assertions. Java/Scala calls to `Color8` and `ColorN` supply all arguments.

/// tab | Kotlin

```kotlin
val text = GD.char(65)
GD.assert(text == "A", "Unexpected character")
```

///

/// tab | Java

```java
String text = Character.toString((char) 65);
assert text.equals("A") : "Unexpected character";
```

///

/// tab | Scala

```scala
val text = GD.char(65)
GD.assert(text == "A", "Unexpected character")
```

///

## Random numbers

| Method | Result/effect |
|---|---|
| `randf()` | Random floating-point value from Godot's generator |
| `randfRange(from, to)` | Floating-point range sample; bounds are single precision |
| `randfn(mean, deviation)` | Gaussian sample; Kotlin defaults are `0f`, `1f`; Java/Scala supply both |
| `randi()` | Random integer from Godot's generator |
| `randiRange(from, to)` | Integer range sample; input bounds are 32-bit integers |
| `randFromSeed(seed)` | `kotlin.Pair<Long, Long>` containing the generated integer and the generator's seed after the draw |
| `randomize()` | Reseeds the shared generator |
| `seed(seed)` | Sets its 64-bit seed |

/// tab | Kotlin

```kotlin
GD.seed(42L)
val roll = GD.randiRange(1, 6)
val seeded: Pair<Long, Long> = GD.randFromSeed(42L)
```

///

/// tab | Java

```java
GD.seed(42L);
long roll = GD.randiRange(1, 6);
kotlin.Pair<Long, Long> seeded = GD.randFromSeed(42L);
```

///

/// tab | Scala

```scala
GD.seed(42L)
val roll = GD.randiRange(1, 6)
val seeded: kotlin.Pair[java.lang.Long, java.lang.Long] = GD.randFromSeed(42L)
```

///

## Numeric functions

The following tables list the available overloads, including return types. Angles are in radians unless a conversion function says otherwise. Overload names preserve the binding's exact spelling. These are call signatures, not declarations to paste into a script.

/// tab | Kotlin

| Function | Overloads |
|---|---|
| `abs` | `abs(s: Int): Int`<br>`abs(s: Long): Long`<br>`abs(s: Float): Float`<br>`abs(s: Double): Double` |
| `acos` | `acos(s: Float): Float`<br>`acos(s: Double): Double` |
| `acosh` | `acosh(x: Float): Float`<br>`acosh(x: Double): Double` |
| `angleDifference` | `angleDifference(from: Float, to: Float): Float`<br>`angleDifference(from: Double, to: Double): Double` |
| `asin` | `asin(s: Float): Float`<br>`asin(s: Double): Double` |
| `asinh` | `asinh(x: Float): Float`<br>`asinh(x: Double): Double` |
| `atan` | `atan(s: Float): Float`<br>`atan(s: Double): Double` |
| `atan2` | `atan2(y: Float, x: Float): Float`<br>`atan2(y: Double, x: Double): Double` |
| `atanh` | `atanh(x: Float): Float`<br>`atanh(x: Double): Double` |
| `bezierDerivative` | `bezierDerivative(start: Float, control1: Float, control2: Float, end: Float, t: Float): Float`<br>`bezierDerivative(start: Double, control1: Double, control2: Double, end: Double, t: Double): Double` |
| `cartesian2polar` | `cartesian2polar(x: Float, y: Float): Vector2`<br>`cartesian2polar(x: Double, y: Double): Vector2` |
| `ceil` | `ceil(s: Float): Float`<br>`ceil(s: Double): Double` |
| `clamp` | `clamp(value: Float, min: Float, max: Float): Float`<br>`clamp(value: Double, min: Double, max: Double): Double`<br>`clamp(value: Float, min: Int, max: Int): Float`<br>`clamp(value: Double, min: Long, max: Long): Double` |
| `cos` | `cos(s: Float): Float`<br>`cos(s: Double): Double` |
| `cosh` | `cosh(s: Float): Float`<br>`cosh(s: Double): Double` |
| `dbToLinear` | `dbToLinear(db: Float): Double`<br>`dbToLinear(db: Double): Double` |
| `degToRad` | `degToRad(s: Float): Double`<br>`degToRad(s: Double): Double` |
| `ease` | `ease(value: Float, curve: Float): Float`<br>`ease(value: Double, curve: Double): Double` |
| `exp` | `exp(s: Float): Float`<br>`exp(s: Double): Double` |
| `floor` | `floor(s: Float): Float`<br>`floor(s: Double): Double` |
| `floori` | `floori(s: Float): Int`<br>`floori(s: Double): Int` |
| `fmod` | `fmod(a: Float, b: Float): Float`<br>`fmod(a: Double, b: Double): Double` |
| `fposmod` | `fposmod(arg0: Float, arg1: Float): Float`<br>`fposmod(arg0: Double, arg1: Double): Double` |
| `inverseLerp` | `inverseLerp(from: Float, to: Float, weight: Float): Float`<br>`inverseLerp(from: Double, to: Double, weight: Double): Double` |
| `isEqualApprox` | `isEqualApprox(a: Float, b: Float): Boolean`<br>`isEqualApprox(a: Double, b: Double): Boolean` |
| `isFinite` | `isFinite(s: Float): Boolean`<br>`isFinite(s: Double): Boolean` |
| `isInf` | `isInf(s: Float): Boolean`<br>`isInf(s: Double): Boolean` |
| `isNan` | `isNan(s: Float): Boolean`<br>`isNan(s: Double): Boolean` |
| `isSame` | `isSame(a: Any, b: Any): Boolean` |
| `isZeroApprox` | `isZeroApprox(s: Float): Boolean`<br>`isZeroApprox(s: Double): Boolean` |
| `lerp` | `lerp(from: Int, to: Int, weight: Float): Float`<br>`lerp(from: Long, to: Long, weight: Double): Double`<br>`lerp(from: Float, to: Float, weight: Float): Float`<br>`lerp(from: Double, to: Double, weight: Double): Double`<br>`lerp(from: Color, to: Color, weight: Float): Color`<br>`lerp(from: Color, to: Color, weight: Double): Color`<br>`lerp(from: Vector2, to: Vector2, weight: Float): Vector2`<br>`lerp(from: Vector2, to: Vector2, weight: Double): Vector2`<br>`lerp(from: Vector3, to: Vector3, weight: Float): Vector3`<br>`lerp(from: Vector3, to: Vector3, weight: Double): Vector3` |
| `lerpAngle` | `lerpAngle(arg0: Float, arg1: Float, arg2: Float): Float`<br>`lerpAngle(arg0: Double, arg1: Double, arg2: Double): Double` |
| `linearToDb` | `linearToDb(nrg: Float): Double`<br>`linearToDb(nrg: Double): Double` |
| `log` | `log(s: Float): Float`<br>`log(s: Double): Double` |
| `max` | `max(a: Int, b: Int): Int`<br>`max(a: Long, b: Long): Long`<br>`max(a: Float, b: Float): Float`<br>`max(a: Double, b: Double): Double` |
| `min` | `min(a: Int, b: Int): Int`<br>`min(a: Long, b: Long): Long`<br>`min(a: Float, b: Float): Float`<br>`min(a: Double, b: Double): Double` |
| `mod` | `mod(a: Int, b: Int): Int`<br>`mod(a: Long, b: Long): Long` |
| `moveToward` | `moveToward(from: Int, to: Int, delta: Int): Int`<br>`moveToward(from: Long, to: Long, delta: Long): Long`<br>`moveToward(from: Float, to: Float, delta: Float): Float`<br>`moveToward(from: Double, to: Double, delta: Double): Double` |
| `nearestPo2` | `nearestPo2(arg0: Int): Int`<br>`nearestPo2(arg0: Long): Long`<br>`nearestPo2(arg0: Float): Float`<br>`nearestPo2(arg0: Double): Double` |
| `polarToCartesian` | `polarToCartesian(r: Float, th: Float): Vector2`<br>`polarToCartesian(r: Double, th: Double): Vector2` |
| `posmod` | `posmod(arg0: Int, arg1: Int): Int`<br>`posmod(arg0: Long, arg1: Long): Long` |
| `pow` | `pow(base: Float, exp: Float): Float`<br>`pow(base: Double, exp: Double): Double` |
| `radToDeg` | `radToDeg(rad: Float): Float`<br>`radToDeg(rad: Double): Double` |
| `remap` | `remap(value: Float, istart: Float, istop: Float, ostart: Float, ostop: Float): Float`<br>`remap(value: Double, istart: Double, istop: Double, ostart: Double, ostop: Double): Double` |
| `rotateToward` | `rotateToward(from: Float, to: Float, delta: Float): Float`<br>`rotateToward(from: Double, to: Double, delta: Double): Double` |
| `round` | `round(s: Float): Float`<br>`round(s: Double): Double` |
| `sign` | `sign(s: Float): Float`<br>`sign(s: Double): Double` |
| `sin` | `sin(s: Float): Float`<br>`sin(s: Double): Double` |
| `sinh` | `sinh(s: Float): Float`<br>`sinh(s: Double): Double` |
| `smoothstep` | `smoothstep(from: Float, to: Float, weight: Float): Float`<br>`smoothstep(from: Double, to: Double, weight: Double): Double` |
| `snapped` | `snapped(x: Int, step: Int): Int`<br>`snapped(x: Long, step: Long): Long`<br>`snapped(x: Float, step: Float): Float`<br>`snapped(x: Double, step: Double): Double` |
| `snappedf` | `snappedf(x: Float, step: Float): Float`<br>`snappedf(x: Double, step: Double): Double` |
| `snappedi` | `snappedi(x: Float, step: Int): Int`<br>`snappedi(x: Double, step: Long): Long` |
| `sqrt` | `sqrt(s: Float): Float`<br>`sqrt(s: Double): Double` |
| `stepDecimals` | `stepDecimals(step: Float): Int`<br>`stepDecimals(step: Double): Int` |
| `stepify` | `stepify(s: Int, step: Int): Int`<br>`stepify(s: Long, step: Long): Long`<br>`stepify(s: Float, step: Float): Float`<br>`stepify(s: Double, step: Double): Double` |
| `tan` | `tan(s: Float): Float`<br>`tan(s: Double): Double` |
| `tanh` | `tanh(s: Float): Float`<br>`tanh(s: Double): Double` |
| `wrapf` | `wrapf(value: Float, min: Float, max: Float): Float`<br>`wrapf(value: Double, min: Double, max: Double): Double` |
| `wrapi` | `wrapi(value: Int, min: Int, max: Int): Int`<br>`wrapi(value: Long, min: Long, max: Long): Long` |

///

/// tab | Java

| Function | Overloads |
|---|---|
| `abs` | `int abs(int s)`<br>`long abs(long s)`<br>`float abs(float s)`<br>`double abs(double s)` |
| `acos` | `float acos(float s)`<br>`double acos(double s)` |
| `acosh` | `float acosh(float x)`<br>`double acosh(double x)` |
| `angleDifference` | `float angleDifference(float from, float to)`<br>`double angleDifference(double from, double to)` |
| `asin` | `float asin(float s)`<br>`double asin(double s)` |
| `asinh` | `float asinh(float x)`<br>`double asinh(double x)` |
| `atan` | `float atan(float s)`<br>`double atan(double s)` |
| `atan2` | `float atan2(float y, float x)`<br>`double atan2(double y, double x)` |
| `atanh` | `float atanh(float x)`<br>`double atanh(double x)` |
| `bezierDerivative` | `float bezierDerivative(float start, float control1, float control2, float end, float t)`<br>`double bezierDerivative(double start, double control1, double control2, double end, double t)` |
| `cartesian2polar` | `Vector2 cartesian2polar(float x, float y)`<br>`Vector2 cartesian2polar(double x, double y)` |
| `ceil` | `float ceil(float s)`<br>`double ceil(double s)` |
| `clamp` | `float clamp(float value, float min, float max)`<br>`double clamp(double value, double min, double max)`<br>`float clamp(float value, int min, int max)`<br>`double clamp(double value, long min, long max)` |
| `cos` | `float cos(float s)`<br>`double cos(double s)` |
| `cosh` | `float cosh(float s)`<br>`double cosh(double s)` |
| `dbToLinear` | `double dbToLinear(float db)`<br>`double dbToLinear(double db)` |
| `degToRad` | `double degToRad(float s)`<br>`double degToRad(double s)` |
| `ease` | `float ease(float value, float curve)`<br>`double ease(double value, double curve)` |
| `exp` | `float exp(float s)`<br>`double exp(double s)` |
| `floor` | `float floor(float s)`<br>`double floor(double s)` |
| `floori` | `int floori(float s)`<br>`int floori(double s)` |
| `fmod` | `float fmod(float a, float b)`<br>`double fmod(double a, double b)` |
| `fposmod` | `float fposmod(float arg0, float arg1)`<br>`double fposmod(double arg0, double arg1)` |
| `inverseLerp` | `float inverseLerp(float from, float to, float weight)`<br>`double inverseLerp(double from, double to, double weight)` |
| `isEqualApprox` | `boolean isEqualApprox(float a, float b)`<br>`boolean isEqualApprox(double a, double b)` |
| `isFinite` | `boolean isFinite(float s)`<br>`boolean isFinite(double s)` |
| `isInf` | `boolean isInf(float s)`<br>`boolean isInf(double s)` |
| `isNan` | `boolean isNan(float s)`<br>`boolean isNan(double s)` |
| `isSame` | `boolean isSame(java.lang.Object a, java.lang.Object b)` |
| `isZeroApprox` | `boolean isZeroApprox(float s)`<br>`boolean isZeroApprox(double s)` |
| `lerp` | `float lerp(int from, int to, float weight)`<br>`double lerp(long from, long to, double weight)`<br>`float lerp(float from, float to, float weight)`<br>`double lerp(double from, double to, double weight)`<br>`Color lerp(Color from, Color to, float weight)`<br>`Color lerp(Color from, Color to, double weight)`<br>`Vector2 lerp(Vector2 from, Vector2 to, float weight)`<br>`Vector2 lerp(Vector2 from, Vector2 to, double weight)`<br>`Vector3 lerp(Vector3 from, Vector3 to, float weight)`<br>`Vector3 lerp(Vector3 from, Vector3 to, double weight)` |
| `lerpAngle` | `float lerpAngle(float arg0, float arg1, float arg2)`<br>`double lerpAngle(double arg0, double arg1, double arg2)` |
| `linearToDb` | `double linearToDb(float nrg)`<br>`double linearToDb(double nrg)` |
| `log` | `float log(float s)`<br>`double log(double s)` |
| `max` | `int max(int a, int b)`<br>`long max(long a, long b)`<br>`float max(float a, float b)`<br>`double max(double a, double b)` |
| `min` | `int min(int a, int b)`<br>`long min(long a, long b)`<br>`float min(float a, float b)`<br>`double min(double a, double b)` |
| `mod` | `int mod(int a, int b)`<br>`long mod(long a, long b)` |
| `moveToward` | `int moveToward(int from, int to, int delta)`<br>`long moveToward(long from, long to, long delta)`<br>`float moveToward(float from, float to, float delta)`<br>`double moveToward(double from, double to, double delta)` |
| `nearestPo2` | `int nearestPo2(int arg0)`<br>`long nearestPo2(long arg0)`<br>`float nearestPo2(float arg0)`<br>`double nearestPo2(double arg0)` |
| `polarToCartesian` | `Vector2 polarToCartesian(float r, float th)`<br>`Vector2 polarToCartesian(double r, double th)` |
| `posmod` | `int posmod(int arg0, int arg1)`<br>`long posmod(long arg0, long arg1)` |
| `pow` | `float pow(float base, float exp)`<br>`double pow(double base, double exp)` |
| `radToDeg` | `float radToDeg(float rad)`<br>`double radToDeg(double rad)` |
| `remap` | `float remap(float value, float istart, float istop, float ostart, float ostop)`<br>`double remap(double value, double istart, double istop, double ostart, double ostop)` |
| `rotateToward` | `float rotateToward(float from, float to, float delta)`<br>`double rotateToward(double from, double to, double delta)` |
| `round` | `float round(float s)`<br>`double round(double s)` |
| `sign` | `float sign(float s)`<br>`double sign(double s)` |
| `sin` | `float sin(float s)`<br>`double sin(double s)` |
| `sinh` | `float sinh(float s)`<br>`double sinh(double s)` |
| `smoothstep` | `float smoothstep(float from, float to, float weight)`<br>`double smoothstep(double from, double to, double weight)` |
| `snapped` | `int snapped(int x, int step)`<br>`long snapped(long x, long step)`<br>`float snapped(float x, float step)`<br>`double snapped(double x, double step)` |
| `snappedf` | `float snappedf(float x, float step)`<br>`double snappedf(double x, double step)` |
| `snappedi` | `int snappedi(float x, int step)`<br>`long snappedi(double x, long step)` |
| `sqrt` | `float sqrt(float s)`<br>`double sqrt(double s)` |
| `stepDecimals` | `int stepDecimals(float step)`<br>`int stepDecimals(double step)` |
| `stepify` | `int stepify(int s, int step)`<br>`long stepify(long s, long step)`<br>`float stepify(float s, float step)`<br>`double stepify(double s, double step)` |
| `tan` | `float tan(float s)`<br>`double tan(double s)` |
| `tanh` | `float tanh(float s)`<br>`double tanh(double s)` |
| `wrapf` | `float wrapf(float value, float min, float max)`<br>`double wrapf(double value, double min, double max)` |
| `wrapi` | `int wrapi(int value, int min, int max)`<br>`long wrapi(long value, long min, long max)` |

///

/// tab | Scala

| Function | Overloads |
|---|---|
| `abs` | `abs(s: Int): Int`<br>`abs(s: Long): Long`<br>`abs(s: Float): Float`<br>`abs(s: Double): Double` |
| `acos` | `acos(s: Float): Float`<br>`acos(s: Double): Double` |
| `acosh` | `acosh(x: Float): Float`<br>`acosh(x: Double): Double` |
| `angleDifference` | `angleDifference(from: Float, to: Float): Float`<br>`angleDifference(from: Double, to: Double): Double` |
| `asin` | `asin(s: Float): Float`<br>`asin(s: Double): Double` |
| `asinh` | `asinh(x: Float): Float`<br>`asinh(x: Double): Double` |
| `atan` | `atan(s: Float): Float`<br>`atan(s: Double): Double` |
| `atan2` | `atan2(y: Float, x: Float): Float`<br>`atan2(y: Double, x: Double): Double` |
| `atanh` | `atanh(x: Float): Float`<br>`atanh(x: Double): Double` |
| `bezierDerivative` | `bezierDerivative(start: Float, control1: Float, control2: Float, end: Float, t: Float): Float`<br>`bezierDerivative(start: Double, control1: Double, control2: Double, end: Double, t: Double): Double` |
| `cartesian2polar` | `cartesian2polar(x: Float, y: Float): Vector2`<br>`cartesian2polar(x: Double, y: Double): Vector2` |
| `ceil` | `ceil(s: Float): Float`<br>`ceil(s: Double): Double` |
| `clamp` | `clamp(value: Float, min: Float, max: Float): Float`<br>`clamp(value: Double, min: Double, max: Double): Double`<br>`clamp(value: Float, min: Int, max: Int): Float`<br>`clamp(value: Double, min: Long, max: Long): Double` |
| `cos` | `cos(s: Float): Float`<br>`cos(s: Double): Double` |
| `cosh` | `cosh(s: Float): Float`<br>`cosh(s: Double): Double` |
| `dbToLinear` | `dbToLinear(db: Float): Double`<br>`dbToLinear(db: Double): Double` |
| `degToRad` | `degToRad(s: Float): Double`<br>`degToRad(s: Double): Double` |
| `ease` | `ease(value: Float, curve: Float): Float`<br>`ease(value: Double, curve: Double): Double` |
| `exp` | `exp(s: Float): Float`<br>`exp(s: Double): Double` |
| `floor` | `floor(s: Float): Float`<br>`floor(s: Double): Double` |
| `floori` | `floori(s: Float): Int`<br>`floori(s: Double): Int` |
| `fmod` | `fmod(a: Float, b: Float): Float`<br>`fmod(a: Double, b: Double): Double` |
| `fposmod` | `fposmod(arg0: Float, arg1: Float): Float`<br>`fposmod(arg0: Double, arg1: Double): Double` |
| `inverseLerp` | `inverseLerp(from: Float, to: Float, weight: Float): Float`<br>`inverseLerp(from: Double, to: Double, weight: Double): Double` |
| `isEqualApprox` | `isEqualApprox(a: Float, b: Float): Boolean`<br>`isEqualApprox(a: Double, b: Double): Boolean` |
| `isFinite` | `isFinite(s: Float): Boolean`<br>`isFinite(s: Double): Boolean` |
| `isInf` | `isInf(s: Float): Boolean`<br>`isInf(s: Double): Boolean` |
| `isNan` | `isNan(s: Float): Boolean`<br>`isNan(s: Double): Boolean` |
| `isSame` | `isSame(a: Any, b: Any): Boolean` |
| `isZeroApprox` | `isZeroApprox(s: Float): Boolean`<br>`isZeroApprox(s: Double): Boolean` |
| `lerp` | `lerp(from: Int, to: Int, weight: Float): Float`<br>`lerp(from: Long, to: Long, weight: Double): Double`<br>`lerp(from: Float, to: Float, weight: Float): Float`<br>`lerp(from: Double, to: Double, weight: Double): Double`<br>`lerp(from: Color, to: Color, weight: Float): Color`<br>`lerp(from: Color, to: Color, weight: Double): Color`<br>`lerp(from: Vector2, to: Vector2, weight: Float): Vector2`<br>`lerp(from: Vector2, to: Vector2, weight: Double): Vector2`<br>`lerp(from: Vector3, to: Vector3, weight: Float): Vector3`<br>`lerp(from: Vector3, to: Vector3, weight: Double): Vector3` |
| `lerpAngle` | `lerpAngle(arg0: Float, arg1: Float, arg2: Float): Float`<br>`lerpAngle(arg0: Double, arg1: Double, arg2: Double): Double` |
| `linearToDb` | `linearToDb(nrg: Float): Double`<br>`linearToDb(nrg: Double): Double` |
| `log` | `log(s: Float): Float`<br>`log(s: Double): Double` |
| `max` | `max(a: Int, b: Int): Int`<br>`max(a: Long, b: Long): Long`<br>`max(a: Float, b: Float): Float`<br>`max(a: Double, b: Double): Double` |
| `min` | `min(a: Int, b: Int): Int`<br>`min(a: Long, b: Long): Long`<br>`min(a: Float, b: Float): Float`<br>`min(a: Double, b: Double): Double` |
| `mod` | `mod(a: Int, b: Int): Int`<br>`mod(a: Long, b: Long): Long` |
| `moveToward` | `moveToward(from: Int, to: Int, delta: Int): Int`<br>`moveToward(from: Long, to: Long, delta: Long): Long`<br>`moveToward(from: Float, to: Float, delta: Float): Float`<br>`moveToward(from: Double, to: Double, delta: Double): Double` |
| `nearestPo2` | `nearestPo2(arg0: Int): Int`<br>`nearestPo2(arg0: Long): Long`<br>`nearestPo2(arg0: Float): Float`<br>`nearestPo2(arg0: Double): Double` |
| `polarToCartesian` | `polarToCartesian(r: Float, th: Float): Vector2`<br>`polarToCartesian(r: Double, th: Double): Vector2` |
| `posmod` | `posmod(arg0: Int, arg1: Int): Int`<br>`posmod(arg0: Long, arg1: Long): Long` |
| `pow` | `pow(base: Float, exp: Float): Float`<br>`pow(base: Double, exp: Double): Double` |
| `radToDeg` | `radToDeg(rad: Float): Float`<br>`radToDeg(rad: Double): Double` |
| `remap` | `remap(value: Float, istart: Float, istop: Float, ostart: Float, ostop: Float): Float`<br>`remap(value: Double, istart: Double, istop: Double, ostart: Double, ostop: Double): Double` |
| `rotateToward` | `rotateToward(from: Float, to: Float, delta: Float): Float`<br>`rotateToward(from: Double, to: Double, delta: Double): Double` |
| `round` | `round(s: Float): Float`<br>`round(s: Double): Double` |
| `sign` | `sign(s: Float): Float`<br>`sign(s: Double): Double` |
| `sin` | `sin(s: Float): Float`<br>`sin(s: Double): Double` |
| `sinh` | `sinh(s: Float): Float`<br>`sinh(s: Double): Double` |
| `smoothstep` | `smoothstep(from: Float, to: Float, weight: Float): Float`<br>`smoothstep(from: Double, to: Double, weight: Double): Double` |
| `snapped` | `snapped(x: Int, step: Int): Int`<br>`snapped(x: Long, step: Long): Long`<br>`snapped(x: Float, step: Float): Float`<br>`snapped(x: Double, step: Double): Double` |
| `snappedf` | `snappedf(x: Float, step: Float): Float`<br>`snappedf(x: Double, step: Double): Double` |
| `snappedi` | `snappedi(x: Float, step: Int): Int`<br>`snappedi(x: Double, step: Long): Long` |
| `sqrt` | `sqrt(s: Float): Float`<br>`sqrt(s: Double): Double` |
| `stepDecimals` | `stepDecimals(step: Float): Int`<br>`stepDecimals(step: Double): Int` |
| `stepify` | `stepify(s: Int, step: Int): Int`<br>`stepify(s: Long, step: Long): Long`<br>`stepify(s: Float, step: Float): Float`<br>`stepify(s: Double, step: Double): Double` |
| `tan` | `tan(s: Float): Float`<br>`tan(s: Double): Double` |
| `tanh` | `tanh(s: Float): Float`<br>`tanh(s: Double): Double` |
| `wrapf` | `wrapf(value: Float, min: Float, max: Float): Float`<br>`wrapf(value: Double, min: Double, max: Double): Double` |
| `wrapi` | `wrapi(value: Int, min: Int, max: Int): Int`<br>`wrapi(value: Long, min: Long, max: Long): Long` |

///

### Numeric behavior

| Family | Behavior |
|---|---|
| `abs`, `min`, `max`, `clamp`, `sign` | Absolute value, extrema, range clamp, sign |
| `acos`, `asin`, `atan`, `atan2`, `sin`, `cos`, `tan` | Trigonometric functions |
| `asinh`, `acosh`, `atanh`, `sinh`, `cosh`, `tanh` | Hyperbolic functions |
| `ceil`, `floor`, `floori`, `round` | Rounding; `floori` returns a 32-bit integer |
| `exp`, `log`, `pow`, `sqrt` | Exponential, natural logarithm, power, square root |
| `degToRad`, `radToDeg` | Degree/radian conversion |
| `angleDifference`, `lerpAngle`, `rotateToward` | Wrapped angular difference/interpolation/movement |
| `lerp`, `inverseLerp`, `remap` | Linear interpolation, inverse weight, interval mapping |
| `moveToward` | Moves toward the target without overshooting |
| `ease`, `smoothstep`, `bezierDerivative` | Easing, smooth interpolation, cubic Bezier derivative |
| `mod`, `fmod` | JVM remainder |
| `posmod`, `fposmod` | Sign-adjusted modulus |
| `snapped`, `snappedf`, `snappedi`, `stepify`, `stepDecimals` | Step snapping and decimal precision helpers |
| `wrapi`, `wrapf` | Binding wrap helpers; implemented as `min + positiveMod(value + min, max - min)` |
| `cartesian2polar`, `polarToCartesian` | Coordinate conversion; the latter returns `(r * sin(angle), r * cos(angle))` |
| `nearestPo2` | Nearest upper power-of-two helper |
| `dbToLinear`, `linearToDb` | Decibel/linear conversion |
| `isEqualApprox`, `isZeroApprox` | Binding approximate comparisons |
| `isFinite`, `isInf`, `isNan` | Floating-point classification |
| `isSame` | JVM equality (`==` in the Kotlin implementation), not a native pointer comparison |

## Other binding helpers

| API | Reference |
|---|---|
| String-name and node-path conversions; collection mutation | [Types and conversions](types.md) |
| `asStatic` / `ObjectUtils.asStatic` | [Objects and lifetime](objects.md#asstatic) |
| `connectMethod`, `connectLambda`, `SignalConnectors` | [Signals](signals.md) |
| `methodCallableN`, `lambdaCallableN`, `asCallable` | [Callables](callables.md) |
| `godotCoroutine`, `await` and dispatchers | [Coroutines](coroutines.md) |
