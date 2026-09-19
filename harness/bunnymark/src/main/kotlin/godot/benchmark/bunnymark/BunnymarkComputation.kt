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
import kotlin.math.atan2
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
	private val randomNumberGenerator = RandomNumberGenerator()

	private lateinit var screenSize: Vector2

	@Register
	override fun _ready() {
		randomNumberGenerator.randomize()
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
			val angle = atan2(offsetY, offsetX) + sin(phase * 0.5) * 0.75

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
					randomNumberGenerator.randf().toDouble() * screenSize.x,
					randomNumberGenerator.randf().toDouble() * screenSize.y
				),
				randomNumberGenerator.randf().toDouble() * 6.283185307179586,
				randomNumberGenerator.randf().toDouble() * 2.0 + 0.5,
				Vector2(
					randomNumberGenerator.randf().toDouble() * screenSize.x / 8,
					randomNumberGenerator.randf().toDouble() * screenSize.y / 8
				)
			)
		)
	}

	@Register
	fun removeBunny() {
		if (bunnies.isEmpty()) return
		bunnies.removeAt(bunnies.size - 1)
	}

	@Register
	fun finish() {
		benchmarkFinished.emit(bunnies.size)
	}
}
