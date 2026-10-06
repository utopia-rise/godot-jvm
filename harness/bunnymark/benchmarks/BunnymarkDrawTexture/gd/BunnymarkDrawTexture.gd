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
var spawn_random: RandomNumberGenerator = RandomNumberGenerator.new()
# One generator for every bounce in the run, kept apart from the spawn generator so that the bounce sequence does
# not shift when the ramp happens to spawn a different number of bunnies.
static var bounce_random: RandomNumberGenerator = RandomNumberGenerator.new()

var screen_size: Vector2

func _ready() -> void:
	# Fixed seeds rather than randomize(): every run then spawns the same population and bounces it the same way,
	# so a difference in the score is a difference in the code. Spawning and bouncing draw from separate generators
	# so that the bounce sequence does not shift when the ramp happens to spawn a different number of bunnies.
	spawn_random.seed = 20260921
	bounce_random.seed = 20260922

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
			if bounce_random.randf() > 0.5:
				speed.y = -float(bounce_random.randi() % 1100 + 50)
			else:
				speed.y *= -0.85

		if pos.y < 0.0:
			speed.y = 0.0
			pos.y = 0.0

		bunny.position = pos
		bunny.speed = speed
	queue_redraw()

func add_bunny() -> void:
	# A ninety degree arc centred straight down -- +Y is down in 2D, so PI / 2 points at the floor.
	# Angle and speed are drawn separately, so every direction gets the same range of speeds.
	var angle: float = spawn_random.randf_range(PI * 0.25, PI * 0.75)
	var speed: float = spawn_random.randf_range(50.0, 250.0)
	bunnies.append(BunnyData.new(
		Vector2(screen_size.x / 2, screen_size.y / 2),
		Vector2(cos(angle) * speed, sin(angle) * speed)
	))

func remove_bunny() -> void:
	if bunnies.size() == 0:
		return
	bunnies.remove_at(bunnies.size() - 1)

func finish() -> void:
	emit_signal("benchmark_finished", bunnies.size())
