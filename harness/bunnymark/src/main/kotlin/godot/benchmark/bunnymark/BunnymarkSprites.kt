package godot.benchmark.bunnymark

import godot.core.*
import godot.api.*
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Emit
import godot.core.signal1
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Script("BunnymarkSprites")
class BunnymarkSprites : Node2D() {

	@Emit
	val benchmarkFinished by signal1<Int>()

	private data class Bunny(var sprite: Sprite2D, var speed: Vector2)

	private val bunnies = mutableListOf<Bunny>()
	private val gravity = 500
	private val bunnyTexture = ResourceLoader.load("res://images/godot_bunny.png") as Texture2D
	private val spawnRandom = RandomNumberGenerator()

	private lateinit var screenSize: Vector2

	@Register
	override fun _ready() {
		// Fixed seeds rather than randomize(): every run then spawns the same population and bounces it the same
		// way, so a difference in the score is a difference in the code. Spawning and bouncing draw from separate
		// generators so that the bounce sequence does not shift when the ramp happens to spawn a different number
		// of bunnies, which it does whenever the machine is a little faster or slower.
		spawnRandom.seed = 20260921
		bounceRandom.seed = 20260922
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
				if (bounceRandom.randf() > 0.5) {
					speed.y = -(bounceRandom.randi() % 1100 + 50).toDouble()
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
			// A ninety degree arc centred straight down -- +Y is down in 2D, so PI / 2 points at the floor.
			// Angle and speed are drawn separately, so every direction gets the same range of speeds.
			val angle = spawnRandom.randfRange((PI * 0.25).toFloat(), (PI * 0.75).toFloat()).toDouble()
			val speed = spawnRandom.randfRange(50f, 250f).toDouble()
		bunnies.add(
			Bunny(
				bunny,
				Vector2(cos(angle) * speed, sin(angle) * speed)
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

	private companion object {
		// One generator for every bounce in the run, kept apart from the spawn generator so that the bounce
		// sequence does not shift when the ramp happens to spawn a different number of bunnies.
		val bounceRandom = RandomNumberGenerator()
	}
}
