extends Node2D

class BunnyData:
	var position: Vector2
	var speed: Vector2

	func _init(p_position: Vector2, p_speed: Vector2) -> void:
		position = p_position
		speed = p_speed

var bunnies: Array[BunnyData] = []
var gravity: float = 500.0
var bunny_texture: Texture2D = load("res://images/godot_bunny.png") as Texture2D
var random_number_generator: RandomNumberGenerator = RandomNumberGenerator.new()

var screen_size: Vector2

func _ready() -> void:
	random_number_generator.randomize()

func _draw() -> void:
	for bunny: BunnyData in bunnies:
		draw_texture(bunny_texture, bunny.position)

func _process(delta: float) -> void:
	screen_size = get_viewport_rect().size

	for bunny: BunnyData in bunnies:
		var pos: Vector2 = bunny.position
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

		bunny.position = pos
		bunny.speed = speed
	queue_redraw()

func add_bunny() -> void:
	bunnies.append(BunnyData.new(
		Vector2(screen_size.x / 2, screen_size.y / 2),
		Vector2(random_number_generator.randi() % 200 + 50, random_number_generator.randi() % 200 + 50)
	))

func remove_bunny() -> void:
	if bunnies.size() == 0:
		return
	bunnies.remove_at(bunnies.size() - 1)

func finish() -> void:
	emit_signal("benchmark_finished", bunnies.size())
