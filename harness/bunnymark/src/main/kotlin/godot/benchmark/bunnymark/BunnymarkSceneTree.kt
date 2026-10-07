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

@Script("BunnymarkSceneTree")
class BunnymarkSceneTree : Node2D() {

	@Emit
	val benchmarkFinished by signal1<Int>()

	private val gravity = 500
	private val bunnySpeeds = mutableListOf<Vector2>()
	private val label = Label()
	private val bunnies = Node2D()
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
		addChild(bunnies)
		label.setPosition(Vector2(0, 20))
		addChild(label)
	}

	@Register
	override fun _process(delta: Double) {
		screenSize = getViewportRect().size
		label.text = "Bunnies: " + bunnies.getChildCount().toString()

		val bunnyChildren = bunnies.getChildren()
		for (i in 0 until bunnyChildren.size) {
			val bunny = bunnyChildren[i] as Sprite2D
			val pos = bunny.position
			val speed = bunnySpeeds[i]

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

			bunny.position = pos
			bunnySpeeds[i] = speed
		}
	}

	@Register
	fun addBunny() {
		val bunny = Sprite2D()
		bunny.texture = bunnyTexture
		bunnies.addChild(bunny)
		bunny.position = Vector2(screenSize.x / 2, screenSize.y / 2)
			// A ninety degree arc centred straight down -- +Y is down in 2D, so PI / 2 points at the floor.
			// Angle and speed are drawn separately, so every direction gets the same range of speeds.
			val angle = spawnRandom.randfRange((PI * 0.25).toFloat(), (PI * 0.75).toFloat()).toDouble()
			val speed = spawnRandom.randfRange(50f, 250f).toDouble()
		bunnySpeeds.add(
			Vector2(cos(angle) * speed, sin(angle) * speed)
		)
	}

	@Register
	fun removeBunny() {
		val childCount = bunnies.getChildCount()
		if (childCount == 0) return
		bunnies
			.getChild(childCount - 1)
			?.let { bunny ->
				bunnies.removeChild(bunny)
                bunny.queueFree()
			}
		bunnySpeeds.removeAt(childCount.toInt() - 1)
	}

	@Register
	fun finish() {
        benchmarkFinished.emit(bunnySpeeds.size)
	}

	private companion object {
		// One generator for every bounce in the run, kept apart from the spawn generator so that the bounce
		// sequence does not shift when the ramp happens to spawn a different number of bunnies.
		val bounceRandom = RandomNumberGenerator()
	}
}
