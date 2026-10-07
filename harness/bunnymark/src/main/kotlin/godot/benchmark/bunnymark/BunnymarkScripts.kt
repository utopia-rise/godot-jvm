package godot.benchmark.bunnymark

import godot.api.*
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Emit
import godot.benchmark.bunnymark.scripts.Bunny
import godot.core.Vector2
import godot.core.signal1
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Script("BunnymarkScripts")
class BunnymarkScripts : Node2D() {

	@Emit
	val benchmarkFinished by signal1<Int>()

	private val spawnRandom = RandomNumberGenerator()
	private var spawned = 0L
	private val bunnyTexture = ResourceLoader.load("res://images/godot_bunny.png") as Texture2D
	private val label = Label()
	private val bunnies = Node2D()

	private lateinit var screenSize: Vector2

	@Register
	override fun _ready() {
		// Fixed seeds rather than randomize(): every run then spawns the same population and bounces it the same
		// way, so a difference in the score is a difference in the code. Spawning and bouncing draw from separate
		// generators so that the bounce sequence does not shift when the ramp happens to spawn a different number
		// of bunnies, which it does whenever the machine is a little faster or slower.
		spawnRandom.seed = 20260921
		addChild(bunnies)

		label.setPosition(Vector2(0, 20))
		addChild(label)
	}

	@Register
	override fun _process(delta: Double) {
		screenSize = getViewportRect().size
		label.text = "Bunnies ${bunnies.getChildCount()}"
	}

	@Register
	fun addBunny() {
		val bunny = Bunny()
		bunny.texture = bunnyTexture
		bunnies.addChild(bunny)
		bunny.position = Vector2(screenSize.x / 2, screenSize.y / 2)
		// A ninety degree arc centred straight down -- +Y is down in 2D, so PI / 2 points at the floor.
		// Angle and speed are drawn separately, so every direction gets the same range of speeds.
		val angle = spawnRandom.randfRange((PI * 0.25).toFloat(), (PI * 0.75).toFloat()).toDouble()
		val speed = spawnRandom.randfRange(50f, 250f).toDouble()
		bunny.speed = Vector2(cos(angle) * speed, sin(angle) * speed)
		bunny.seedBounce(20260922 + spawned)
		spawned++
	}

	@Register
	fun removeBunny() {
		val childCount = bunnies.getChildCount()
		if (childCount != 0) {
			val bunny = bunnies.getChild(childCount - 1)
			bunnies.removeChild(bunny!!)
			bunny.queueFree()
		}
	}

	@Register
	fun finish() {
        benchmarkFinished.emit(bunnies.getChildCount())
	}
}


