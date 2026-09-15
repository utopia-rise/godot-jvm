package godot.benchmark.bunnymark

import godot.core.*
import godot.api.*
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Emit
import godot.core.signal1

@Script("BunnymarkV1Sprites")
class BunnymarkV1Sprites : Node2D() {

	@Emit
	val benchmarkFinished by signal1<Int>()

	private data class Bunny(var sprite: Sprite2D, var speed: Vector2)

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
	override fun _process(delta: Double) {
		screenSize = getViewportRect().size

		for (bunny in bunnies) {
			val pos = bunny.sprite.position
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

			bunny.sprite.position = pos
			bunny.speed = speed
		}
	}

	@Register
	fun addBunny() {
		val bunny = Sprite2D()
		bunny.texture = bunnyTexture
		addChild(bunny)
		bunny.position = Vector2(screenSize.x / 2, screenSize.y / 2)
		bunnies.add(
			Bunny(
				bunny,
				Vector2(randomNumberGenerator.randi() % 200 + 50, randomNumberGenerator.randi() % 200 + 50)
			)
		)
	}

	@Register
	fun removeBunny() {
		if (bunnies.size == 0) return
		val bunny = bunnies[bunnies.size - 1]
		removeChild(bunny.sprite)
		bunnies.removeAt(bunnies.size - 1)
        bunny.sprite.queueFree()
	}

	@Register
	fun finish() {
        benchmarkFinished.emit(bunnies.size)
	}
}


