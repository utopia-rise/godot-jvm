extends Node2D

class BunnyData:
	var position: Vector2
	var center: Vector2
	var phase: float
	var frequency: float
	var radius: Vector2

	func _init(p_position: Vector2, p_center: Vector2, p_phase: float, p_frequency: float, p_radius: Vector2) -> void:
		position = p_position
		center = p_center
		phase = p_phase
		frequency = p_frequency
		radius = p_radius

var bunnies: Array[BunnyData] = []
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
		bunny.phase += bunny.frequency * delta
		var phase: float = bunny.phase

		var offset_x: float = sin(phase) * bunny.radius.x
		var offset_y: float = cos(phase * 1.7) * bunny.radius.y
		var distance: float = sqrt(offset_x * offset_x + offset_y * offset_y)
		var angle: float = atan2(offset_y, offset_x) + sin(phase * 0.5) * 0.75

		var pos: Vector2 = bunny.position
		pos.x = bunny.center.x + cos(angle) * distance
		pos.y = bunny.center.y + sin(angle) * distance
		bunny.position = pos
	queue_redraw()

func add_bunny() -> void:
	bunnies.append(BunnyData.new(
		Vector2(0, 0),
		Vector2(
			random_number_generator.randf() * screen_size.x,
			random_number_generator.randf() * screen_size.y
		),
		random_number_generator.randf() * 6.283185307179586,
		random_number_generator.randf() * 2.0 + 0.5,
		Vector2(
			random_number_generator.randf() * screen_size.x / 8,
			random_number_generator.randf() * screen_size.y / 8
		)
	))

func remove_bunny() -> void:
	if bunnies.size() == 0:
		return
	bunnies.remove_at(bunnies.size() - 1)

func finish() -> void:
	emit_signal("benchmark_finished", bunnies.size())
