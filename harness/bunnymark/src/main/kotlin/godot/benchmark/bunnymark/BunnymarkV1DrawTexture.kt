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

@Script("BunnymarkV1DrawTexture")
class BunnymarkV1DrawTexture : Node2D() {

	@Emit
	val benchmarkFinished by signal1<Int>()

	data class Bunny(var position: Vector2, var speed: Vector2)

	private val bunnies = mutableListOf<Bunny>()
	private val gravity = 500
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
			val pos = bunny.position
			val speed = bunny.speed

			pos.x += speed.x * delta
			pos.y += speed.y * delta

			speed.y += gravity * delta

			if (pos.x > screenSize.x) {
				speed.x *= -1
				pos.x = screenSize.x
			}

			if (pos.x < 0) {
				speed.x *= -1.0
				pos.x = 0.0
			}

			if (pos.y > screenSize.y) {
				pos.y = screenSize.y
				if (randomNumberGenerator.randf() > 0.5) {
					speed.y = -(randomNumberGenerator.randi() % 1100 + 50).toDouble()
				} else {
					speed.y *= -0.85
				}
			}

			if (pos.y < 0) {
				speed.y = 0.0
				pos.y = 0.0
			}

			bunny.position = pos
			bunny.speed = speed
		}
		queueRedraw()
	}

	@Register
	fun addBunny() {
		bunnies.add(
			Bunny(
				Vector2(screenSize.x / 2, screenSize.y / 2),
				Vector2(randomNumberGenerator.randi() % 200 + 50, randomNumberGenerator.randi() % 200 + 50)
			)
		)
	}

	@Register
	fun removeBunny() {
		if (bunnies.size == 0) return
		bunnies.removeAt(bunnies.size - 1)
	}

	@Register
	fun finish() {
        benchmarkFinished.emit(bunnies.size)
	}
}


