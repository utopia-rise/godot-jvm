extends Node2D

var gravity: float = 500.0
var bunny_speeds: Array[Vector2] = []
var label: Label = Label.new()
var bunnies: Node2D = Node2D.new()
var bunny_texture: Texture2D = load("res://images/godot_bunny.png") as Texture2D
var random_number_generator: RandomNumberGenerator = RandomNumberGenerator.new()

var screen_size: Vector2

func _ready() -> void:
	random_number_generator.randomize()
	add_child(bunnies)
	label.set_position(Vector2(0, 20))
	add_child(label)

func _process(delta: float) -> void:
	screen_size = get_viewport_rect().size
	label.text = "Bunnies: " + str(bunnies.get_child_count())

	var bunny_children: Array[Node] = bunnies.get_children()
	for i: int in range(0, bunny_children.size()):
		var bunny: Sprite2D = bunny_children[i] as Sprite2D
		var pos: Vector2 = bunny.position
		var speed: Vector2 = bunny_speeds[i]

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
		bunny_speeds[i] = speed

func add_bunny() -> void:
	var bunny: Sprite2D = Sprite2D.new()
	bunny.texture = bunny_texture
	bunnies.add_child(bunny)
	bunny.position = Vector2(screen_size.x / 2, screen_size.y / 2)
	bunny_speeds.append(
		Vector2(random_number_generator.randi() % 200 + 50, random_number_generator.randi() % 200 + 50)
	)

func remove_bunny() -> void:
	var child_count: int = bunnies.get_child_count()
	if child_count == 0:
		return
	var bunny: Node = bunnies.get_child(child_count - 1)
	bunnies.remove_child(bunny)
	bunny.queue_free()
	bunny_speeds.remove_at(child_count - 1)

func finish() -> void:
	emit_signal("benchmark_finished", bunny_speeds.size())
