extends Node2D

var spawn_random: RandomNumberGenerator = RandomNumberGenerator.new()
var spawned: int = 0
var bunny_texture: Texture2D = load("res://images/godot_bunny.png") as Texture2D
var label: Label = Label.new()
var bunnies: Node2D = Node2D.new()

var screen_size: Vector2

func _ready() -> void:
	# Fixed seeds rather than randomize(): every run then spawns the same population and bounces it the same way,
	# so a difference in the score is a difference in the code. Spawning and bouncing draw from separate generators
	# so that the bounce sequence does not shift when the ramp happens to spawn a different number of bunnies.
	spawn_random.seed = 20260921
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
	# A ninety degree arc centred straight down -- +Y is down in 2D, so PI / 2 points at the floor.
	# Angle and speed are drawn separately, so every direction gets the same range of speeds.
	var angle: float = spawn_random.randf_range(PI * 0.25, PI * 0.75)
	var speed: float = spawn_random.randf_range(50.0, 250.0)
	bunny.speed = Vector2(cos(angle) * speed, sin(angle) * speed)
	bunny.seed_bounce(20260922 + spawned)
	spawned += 1

func remove_bunny() -> void:
	var child_count: int = bunnies.get_child_count()
	if child_count != 0:
		var bunny: Node = bunnies.get_child(child_count - 1)
		bunnies.remove_child(bunny)
		bunny.queue_free()

func finish() -> void:
	emit_signal("benchmark_finished", bunnies.get_child_count())
