## The arena's only enemy. It patrols the middle of the arena across the lanes, scans its surroundings, reacts to every
## hit and, when it dies, splits in two and respawns. Each of those reaches the engine through a different path:
## [br]- patrolling is a per-entity [method _physics_process], like the bullets';
## [br]- scanning walks the bullets inside its sensor ([method Area2D.get_overlapping_areas]) and the drones in its group
## ([method SceneTree.get_nodes_in_group]), then reads the nearby drones' positions: the drone steers away from them, so
## the drones spread out, and moves faster the more bullets its sensor holds;
## [br]- a hit arrives through [signal Area2D.area_entered], as it does for the bullet, and starts a two-step [Tween]
## flash;
## [br]- a death splits through [method Object.call_deferred], since the engine refuses new areas while it dispatches a
## collision signal, and respawns through a [SceneTreeTimer] whose timeout runs a lambda.
## [br]The two drones a split leaves behind have fewer hit points and neither split nor respawn, so the population is
## bounded.
class_name GdDrone
extends Area2D

const Layers := preload("res://gd/Layers.gd")
const ScriptCalls := preload("res://gd/ScriptCalls.gd")

const GROUP := &"drones"
const SENSOR_RADIUS := 64.0
const ORIGINAL_HIT_POINTS := 30
const CHILD_HIT_POINTS := 10
const SCAN_INTERVAL_FRAMES := 15
const SEPARATION_RADIUS := 90.0
## How hard a neighbour pushes, in pixels per second of velocity at zero distance.
const SEPARATION_STEER := 600.0
const CALM_SPEED := 130.0
const PANIC_BULLETS := 80
const FLASH_SECONDS := 0.05
const RESPAWN_SECONDS := 0.5
const HIT_COLOR := Color(1.3, 1.3, 1.3)
const REST_COLOR := Color(1.0, 1.0, 1.0)

var _arena: GdArena
var _fill: Sprite2D
var _sensor: Area2D
var _original := true
var _max_hit_points := 0
var _hit_points := 0
var _velocity_x := 0.0
var _velocity_y := 0.0
var _frames_until_scan := SCAN_INTERVAL_FRAMES
var _dead := false


func place(arena: GdArena, x: float, y: float, velocity_x: float, velocity_y: float, original: bool) -> void:
	_arena = arena
	_original = original
	_velocity_x = velocity_x
	_velocity_y = velocity_y
	_max_hit_points = ORIGINAL_HIT_POINTS if original else CHILD_HIT_POINTS
	_hit_points = _max_hit_points
	position = Vector2(x, y)
	collision_layer = Layers.DRONE
	collision_mask = Layers.TEAM_A | Layers.TEAM_B
	var collision := CollisionShape2D.new()
	collision.shape = arena.drone_shape
	add_child(collision)

	# Three layers: the dark inside, the body's colour filling it as high as the hit points left, the face on top.
	var look: GdArena.DroneLook = arena.drone_look
	var hollow := Sprite2D.new()
	hollow.texture = look.hollow
	add_child(hollow)
	_fill = Sprite2D.new()
	_fill.texture = look.fill
	_fill.centered = false
	_fill.region_enabled = true
	add_child(_fill)
	_show_hit_points()
	var face := Sprite2D.new()
	face.texture = look.face
	add_child(face)

	# The sensor is a wider area that only watches bullets: nothing scans its layer, so bullets fly through it and live
	# long enough to be listed, unlike the ones that touch the drone's body.
	_sensor = Area2D.new()
	_sensor.collision_layer = 0
	_sensor.collision_mask = Layers.TEAM_A | Layers.TEAM_B
	_sensor.monitorable = false
	var sensor_collision := CollisionShape2D.new()
	sensor_collision.shape = arena.sensor_shape
	_sensor.add_child(sensor_collision)
	add_child(_sensor)
	var sensor_ring := Sprite2D.new()
	sensor_ring.texture = look.sensor
	add_child(sensor_ring)

	if arena.bookkeeping:
		add_to_group(GROUP)
	if arena.hits:
		area_entered.connect(_on_area_entered)
	else:
		monitoring = false


func _physics_process(delta: float) -> void:
	ScriptCalls.count += 1
	if _dead:
		return
	_patrol(delta)
	if _arena.bookkeeping:
		_frames_until_scan -= 1
		if _frames_until_scan <= 0:
			_frames_until_scan = SCAN_INTERVAL_FRAMES
			_scan()


## Moves diagonally, bouncing off the edges of the middle of the arena.
func _patrol(delta: float) -> void:
	# In 64-bit floats, bounded before the single rounding when stored, as the Kotlin version does.
	var x := position.x + _velocity_x * delta
	var y := position.y + _velocity_y * delta
	if x < GdArena.MIDDLE_LEFT or x > GdArena.MIDDLE_RIGHT:
		_velocity_x = -_velocity_x
		x = clampf(x, GdArena.MIDDLE_LEFT, GdArena.MIDDLE_RIGHT)
	if y < GdArena.TOP or y > GdArena.BOTTOM:
		_velocity_y = -_velocity_y
		y = clampf(y, GdArena.TOP, GdArena.BOTTOM)
	position = Vector2(x, y)


# Each element read is delivered to the script as an object, as it is when game code walks a query result. What the
# scan finds steers the drone until the next one.
func _scan() -> void:
	var bullets_nearby := 0
	for area in _sensor.get_overlapping_areas():
		if area is GdBullet:
			bullets_nearby += 1

	# Flocking: a push away from every drone closer than SEPARATION_RADIUS, stronger the closer it is.
	var here := position
	var push_x := 0.0
	var push_y := 0.0
	var drones := 0
	for node in get_tree().get_nodes_in_group(GROUP):
		if not node is GdDrone:
			continue
		drones += 1
		if node == self:
			continue
		var there: Vector2 = node.position
		var dx := here.x - there.x
		var dy := here.y - there.y
		var distance := sqrt(dx * dx + dy * dy)
		if distance > 0.0 and distance < SEPARATION_RADIUS:
			var weight := (1.0 - distance / SEPARATION_RADIUS) / distance
			push_x += dx * weight
			push_y += dy * weight
	_velocity_x += push_x * SEPARATION_STEER
	_velocity_y += push_y * SEPARATION_STEER

	# Panic: the more bullets in the sensor, the faster the drone moves, up to twice its calm speed.
	var panic := float(mini(bullets_nearby, PANIC_BULLETS)) / PANIC_BULLETS
	var speed := CALM_SPEED * (1.0 + panic)
	var length := sqrt(_velocity_x * _velocity_x + _velocity_y * _velocity_y)
	if length > 0.0:
		_velocity_x *= speed / length
		_velocity_y *= speed / length
	_arena.record_scan(bullets_nearby, drones)


func _on_area_entered(_other: Area2D) -> void:
	ScriptCalls.count += 1
	if _dead:
		return
	_arena.record_drone_hit()
	if _arena.reactions:
		var flash := create_tween()
		flash.tween_property(self, "modulate", HIT_COLOR, FLASH_SECONDS)
		flash.tween_property(self, "modulate", REST_COLOR, FLASH_SECONDS)
	_hit_points -= 1
	# Only a run with a window shows the drain: a headless run skips the extra engine call per hit.
	if _arena.effects:
		_show_hit_points()
	if _hit_points > 0:
		return

	_dead = true
	_arena.record_kill(_original)
	if _original:
		var at := position
		_arena.call_deferred("split", at.x, at.y)
		# Copied out so the lambda holds the arena, not this drone, which is freed before the timer fires.
		var arena := _arena
		if arena.reactions:
			get_tree().create_timer(RESPAWN_SECONDS).timeout.connect(func() -> void:
				ScriptCalls.count += 1
				arena.respawn()
			)
		else:
			arena.schedule_respawn()
	queue_free()


## Crops the fill from the top, so the body empties as the hit points drop.
func _show_hit_points() -> void:
	var size := 2 * GdArena.DRONE_DRAWN_RADIUS
	var top := size * (1.0 - float(maxi(_hit_points, 0)) / _max_hit_points)
	_fill.region_rect = Rect2(0, top, size, size - top)
	_fill.offset = Vector2(-GdArena.DRONE_DRAWN_RADIUS, top - GdArena.DRONE_DRAWN_RADIUS)
