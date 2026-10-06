class_name Bunny
extends Sprite2D

var speed: Vector2 = Vector2()

var gravity: float = 500.0
var screen_size: Vector2
# One generator per bunny, which is deliberate: this benchmark exists to measure what many small scripts cost, and
# an object of its own per bunny is part of that. Seeded by the spawner rather than here, with a seed of its own per
# bunny, because a shared seed would have every bunny bounce in exactly the same way.
var bounce_random: RandomNumberGenerator = RandomNumberGenerator.new()

func seed_bounce(seed_value: int) -> void:
	bounce_random.seed = seed_value

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
		if bounce_random.randf() > 0.5:
			sp.y = -float(bounce_random.randi() % 1100 + 50)
		else:
			sp.y *= -0.85

	if pos.y < 0.0:
		sp.y = 0.0
		pos.y = 0.0

	position = pos
	speed = sp
