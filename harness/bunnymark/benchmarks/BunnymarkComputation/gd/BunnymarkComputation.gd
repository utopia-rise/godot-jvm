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
var spawn_random: RandomNumberGenerator = RandomNumberGenerator.new()

var screen_size: Vector2

func _ready() -> void:
	# Fixed seed rather than randomize(): every run then lays out the same orbits, so a difference in the score is a
	# difference in the code. This benchmark never bounces, so it needs no second generator.
	spawn_random.seed = 20260921

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
		var angle: float = _fast_atan2(offset_y, offset_x) + sin(phase * 0.5) * 0.75

		var pos: Vector2 = bunny.position
		pos.x = bunny.center.x + cos(angle) * distance
		pos.y = bunny.center.y + sin(angle) * distance
		bunny.position = pos
	queue_redraw()

# atan2 is the one function here that HotSpot does not intrinsify on the JVM, so the Kotlin benchmark would otherwise
# run a software implementation while this one reaches native libm. The same polynomial runs in all three languages so
# every runtime does the same arithmetic. Max error 1.1e-5 rad, about a hundredth of a pixel at a 1000 px radius.
func _atan_unit(z: float) -> float:
	var z2: float = z * z
	return z * (0.9998660 + z2 * (-0.3302995 + z2 * (0.1801410 + z2 * (-0.0851330 + z2 * 0.0208351))))

func _fast_atan2(y: float, x: float) -> float:
	var ax: float = absf(x)
	var ay: float = absf(y)
	var a: float
	if ax >= ay:
		a = _atan_unit(0.0 if ax == 0.0 else ay / ax)
	else:
		a = PI * 0.5 - _atan_unit(ax / ay)
	if x < 0.0:
		a = PI - a
	return -a if y < 0.0 else a

func add_bunny() -> void:
	bunnies.append(BunnyData.new(
		Vector2(0, 0),
		Vector2(
			spawn_random.randf() * screen_size.x,
			spawn_random.randf() * screen_size.y
		),
		spawn_random.randf() * 6.283185307179586,
		spawn_random.randf() * 2.0 + 0.5,
		Vector2(
			spawn_random.randf() * screen_size.x / 8,
			spawn_random.randf() * screen_size.y / 8
		)
	))

func remove_bunny() -> void:
	if bunnies.size() == 0:
		return
	bunnies.remove_at(bunnies.size() - 1)

func finish() -> void:
	emit_signal("benchmark_finished", bunnies.size())
