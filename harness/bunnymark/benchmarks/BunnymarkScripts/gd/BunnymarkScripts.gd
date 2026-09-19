extends Node2D

var random_number_generator: RandomNumberGenerator = RandomNumberGenerator.new()
var bunny_texture: Texture2D = load("res://images/godot_bunny.png") as Texture2D
var label: Label = Label.new()
var bunnies: Node2D = Node2D.new()

var screen_size: Vector2

func _ready() -> void:
	random_number_generator.randomize()
	add_child(bunnies)

	label.set_position(Vector2(0, 20))
	add_child(label)

func _process(_delta: float) -> void:
	screen_size = get_viewport_rect().size
	label.text = "Bunnies " + str(bunnies.get_child_count())

func add_bunny() -> void:
	var bunny: Bunny = Bunny.new()
	bunny.texture = bunny_texture
	bunnies.add_child(bunny)
	bunny.position = Vector2(screen_size.x / 2, screen_size.y / 2)
	bunny.speed = Vector2(random_number_generator.randi() % 200 + 50, random_number_generator.randi() % 200 + 50)

func remove_bunny() -> void:
	var child_count: int = bunnies.get_child_count()
	if child_count != 0:
		var bunny: Node = bunnies.get_child(child_count - 1)
		bunnies.remove_child(bunny)
		bunny.queue_free()

func finish() -> void:
	emit_signal("benchmark_finished", bunnies.get_child_count())
