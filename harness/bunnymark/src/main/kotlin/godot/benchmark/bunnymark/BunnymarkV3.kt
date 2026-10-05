package godot.benchmark.bunnymark

import godot.api.*
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Emit
import godot.benchmark.bunnymark.v3.Bunny
import godot.core.Vector2
import godot.core.signal1

@Script("BunnymarkV3")
class BunnymarkV3 : Node2D() {

	@Emit
	val benchmarkFinished by signal1<Int>()

	private val randomNumberGenerator = RandomNumberGenerator()
	private val bunnyTexture = ResourceLoader.load("res://images/godot_bunny.png") as Texture2D
	private val label = Label()
	private val bunnies = Node2D()

	private lateinit var screenSize: Vector2

	@Register
	override fun _ready() {
        randomNumberGenerator.randomize()
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
		bunny.speed = Vector2(randomNumberGenerator.randi() % 200 + 50, randomNumberGenerator.randi() % 200 + 50)
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


