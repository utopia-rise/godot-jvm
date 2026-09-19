class_name Bunny
extends Sprite2D

var speed: Vector2 = Vector2()

var gravity: float = 500.0
var screen_size: Vector2
var random_number_generator: RandomNumberGenerator = RandomNumberGenerator.new()

func _ready() -> void:
	random_number_generator.randomize()

func _process(delta: float) -> void:
	screen_size = get_viewport_rect().size
	var pos: Vector2 = position
	var sp: Vector2 = speed

	pos.x += sp.x * delta
	pos.y += sp.y * delta

	sp.y += gravity * delta

	if pos.x > screen_size.x:
		sp.x *= -1.0
		pos.x = screen_size.x

	if pos.x < 0.0:
		sp.x *= -1.0
		pos.x = 0.0

	if pos.y > screen_size.y:
		pos.y = screen_size.y
		if random_number_generator.randf() > 0.5:
			sp.y = -float(random_number_generator.randi() % 1100 + 50)
		else:
			sp.y *= -0.85

	if pos.y < 0.0:
		sp.y = 0.0
		pos.y = 0.0

	position = pos
	speed = sp
