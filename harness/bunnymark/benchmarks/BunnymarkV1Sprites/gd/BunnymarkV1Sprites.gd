extends Node2D

class BunnyData:
	var sprite: Sprite2D
	var speed: Vector2

	func _init(p_sprite: Sprite2D, p_speed: Vector2) -> void:
		sprite = p_sprite
		speed = p_speed

var bunnies: Array[BunnyData] = []
var gravity: float = 500.0
var bunny_texture: Texture2D = load("res://images/godot_bunny.png") as Texture2D
var random_number_generator: RandomNumberGenerator = RandomNumberGenerator.new()

var screen_size: Vector2

func _ready() -> void:
	random_number_generator.randomize()

func _process(delta: float) -> void:
	screen_size = get_viewport_rect().size

	for bunny: BunnyData in bunnies:
		var pos: Vector2 = bunny.sprite.position
		var speed: Vector2 = bunny.speed

		pos.x += speed.x * delta
		pos.y += speed.y * delta

		speed.y += gravity * delta

		if pos.x > screen_size.x:
			speed.x *= -1.0
			pos.x = screen_size.x

		if pos.x < 0.0:
			speed.x *= -1.0
			pos.x = 0.0

		if pos.y > screen_size.y:
			pos.y = screen_size.y
			if random_number_generator.randf() > 0.5:
				speed.y = -float(random_number_generator.randi() % 1100 + 50)
			else:
				speed.y *= -0.85

		if pos.y < 0.0:
			speed.y = 0.0
			pos.y = 0.0

		bunny.sprite.position = pos
		bunny.speed = speed

func add_bunny() -> void:
	var bunny: Sprite2D = Sprite2D.new()
	bunny.texture = bunny_texture
	add_child(bunny)
	bunny.position = Vector2(screen_size.x / 2, screen_size.y / 2)
	bunnies.append(BunnyData.new(
		bunny,
		Vector2(random_number_generator.randi() % 200 + 50, random_number_generator.randi() % 200 + 50)
	))

func remove_bunny() -> void:
	if bunnies.size() == 0:
		return
	var bunny: BunnyData = bunnies[bunnies.size() - 1]
	remove_child(bunny.sprite)
	bunnies.remove_at(bunnies.size() - 1)
	bunny.sprite.queue_free()

func finish() -> void:
	emit_signal("benchmark_finished", bunnies.size())
