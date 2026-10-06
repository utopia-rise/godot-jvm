package godot.benchmark.bunnymark

import godot.api.Node2D
import godot.api.RandomNumberGenerator
import godot.api.ResourceLoader
import godot.api.Texture2D
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Emit
import godot.core.Vector2
import godot.core.signal1
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Script("BunnymarkComputation")
class BunnymarkComputation : Node2D() {

	@Emit
	val benchmarkFinished by signal1<Int>()

	data class Bunny(
		var position: Vector2,
		var center: Vector2,
		var phase: Double,
		var frequency: Double,
		var radius: Vector2,
	)

	private val bunnies = mutableListOf<Bunny>()
	private val bunnyTexture = ResourceLoader.load("res://images/godot_bunny.png") as Texture2D
	private val spawnRandom = RandomNumberGenerator()

	private lateinit var screenSize: Vector2

	@Register
	override fun _ready() {
		// Fixed seed rather than randomize(): every run then lays out the same orbits, so a difference in the
		// score is a difference in the code. This benchmark never bounces, so it needs no second generator.
		spawnRandom.seed = 20260921
	}

	@Register
	override fun _draw() {
		for (bunny in bunnies) {
			drawTexture(bunnyTexture, bunny.position)
		}
	}

	@Register
	override fun _process(delta: Double) {
		screenSize = getViewportRect().size

		for (bunny in bunnies) {
			bunny.phase += bunny.frequency * delta
			val phase = bunny.phase

			val offsetX = sin(phase) * bunny.radius.x
			val offsetY = cos(phase * 1.7) * bunny.radius.y
			val distance = sqrt(offsetX * offsetX + offsetY * offsetY)
			val angle = fastAtan2(offsetY, offsetX) + sin(phase * 0.5) * 0.75

			val pos = bunny.position
			pos.x = bunny.center.x + cos(angle) * distance
			pos.y = bunny.center.y + sin(angle) * distance
			bunny.position = pos
		}
		queueRedraw()
	}

	@Register
	fun addBunny() {
		bunnies.add(
			Bunny(
				Vector2(0, 0),
				Vector2(
					spawnRandom.randf().toDouble() * screenSize.x,
					spawnRandom.randf().toDouble() * screenSize.y
				),
				spawnRandom.randf().toDouble() * 6.283185307179586,
				spawnRandom.randf().toDouble() * 2.0 + 0.5,
				Vector2(
					spawnRandom.randf().toDouble() * screenSize.x / 8,
					spawnRandom.randf().toDouble() * screenSize.y / 8
				)
			)
		)
	}

	@Register
	fun removeBunny() {
		if (bunnies.isEmpty()) return
		bunnies.removeAt(bunnies.size - 1)
	}


	// atan2 is the one function here that HotSpot does not intrinsify: Math.atan2 falls through to StrictMath and the
	// pure-Java fdlibm port, while GDScript and C# reach their platform's native libm. This polynomial is the same in
	// all three languages so every runtime does the same arithmetic, and it is built only from operations that are
	// hardware-backed everywhere. Max error 1.1e-5 rad, about a hundredth of a pixel at a 1000 px radius.
	private fun atanUnit(z: Double): Double {
		val z2 = z * z
		return z * (0.9998660 + z2 * (-0.3302995 + z2 * (0.1801410 + z2 * (-0.0851330 + z2 * 0.0208351))))
	}

	private fun fastAtan2(y: Double, x: Double): Double {
		val ax = abs(x)
		val ay = abs(y)
		var a = if (ax >= ay) {
			atanUnit(if (ax == 0.0) 0.0 else ay / ax)
		} else {
			PI * 0.5 - atanUnit(ax / ay)
		}
		if (x < 0.0) a = PI - a
		return if (y < 0.0) -a else a
	}

	@Register
	fun finish() {
		benchmarkFinished.emit(bunnies.size)
	}
}
