## One bullet: an Area2D with its own script, moved in its own [method _physics_process] and told about hits through the
## engine's [signal Area2D.area_entered] signal, the way a game written one script per entity does it. It frees itself
## on its first hit, on another bullet or a drone, or when its lifetime runs out, whichever comes first.
##
## With a texture it carries its own Sprite2D, as a bullet scene would; without one the arena draws it.
class_name GdBullet
extends Area2D

const Layers := preload("res://gd/Layers.gd")
const ScriptCalls := preload("res://gd/ScriptCalls.gd")

var team := 0
var _arena: GdArena
var _velocity_x := 0.0
var _frames_left := 0
var _finished := false


func launch(arena: GdArena, bullet_team: int, x: float, y: float, velocity_x: float, lifetime_frames: int, shape: Shape2D, texture: Texture2D) -> void:
	_arena = arena
	team = bullet_team
	_velocity_x = velocity_x
	_frames_left = lifetime_frames
	position = Vector2(x, y)
	# Each team sits on its own layer and scans the other team and the drones, never its own bullets.
	collision_layer = Layers.TEAM_A if team == 0 else Layers.TEAM_B
	collision_mask = (Layers.TEAM_B if team == 0 else Layers.TEAM_A) | Layers.DRONE
	var collision := CollisionShape2D.new()
	collision.shape = shape
	add_child(collision)
	if texture != null:
		var sprite := Sprite2D.new()
		sprite.texture = texture
		add_child(sprite)
	# Without hits the bullet neither detects nor is detected, so the engine tracks no overlaps for it either.
	if arena.hits:
		area_entered.connect(_on_area_entered)
	else:
		monitoring = false
	monitorable = arena.hits


func _physics_process(delta: float) -> void:
	ScriptCalls.count += 1
	if _finished:
		return
	_frames_left -= 1
	if _frames_left <= 0:
		_finish()
		_arena.record_expired(self)
		return
	# In 64-bit floats, rounded once when stored, as the Kotlin version does: the same rounding keeps the games equal.
	var moved := position
	moved.x = moved.x + _velocity_x * delta
	position = moved


func _on_area_entered(other: Area2D) -> void:
	ScriptCalls.count += 1
	if _finished:
		return
	_finish()
	_arena.record_bullet_hit(self, other is GdDrone)


func _finish() -> void:
	_finished = true
	queue_free()
