package godot.benchmark.bunnymark.scripts

import godot.api.RandomNumberGenerator
import godot.api.Sprite2D
import godot.annotation.Script
import godot.annotation.Register
import godot.core.Vector2

@Script("BunnyKt")
class Bunny : Sprite2D() {

	var speed = Vector2()

	private var grav = 500
	private lateinit var screenSize: Vector2
	// One generator per bunny, which is deliberate: this benchmark exists to measure what many small scripts cost,
	// and an object of its own per bunny is part of that. Seeded by the spawner rather than here, with a seed of its
	// own per bunny, because a shared seed would have every bunny bounce in exactly the same way.
	private val bounceRandom = RandomNumberGenerator()

	fun seedBounce(seed: Long) {
		bounceRandom.seed = seed
	}

	@Register
	override fun _process(delta: Double) {
		screenSize = getViewportRect().size
		val pos = position
		val sp = speed

		pos.x += sp.x * delta
		pos.y += sp.y * delta

		sp.y += grav * delta

		if (pos.x > screenSize.x) {
			sp.x *= -1
			pos.x = screenSize.x
		}

		if (pos.x < 0) {
			sp.x *= -1
			pos.x = 0.0
		}

		if (pos.y > screenSize.y) {
			pos.y = screenSize.y
			if (bounceRandom.randf() > 0.5) {
				sp.y = -(bounceRandom.randi() % 1100 + 50).toDouble()
			} else {
				sp.y *= -0.85
			}
		}

		if (pos.y < 0) {
			sp.y = 0.0
			pos.y = 0.0
		}

		position = pos
		speed = sp
	}
}


