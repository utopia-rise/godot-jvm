## Two turret lines face each other across the arena and fire into partly shared lanes: in a shared lane a bullet meets
## an oncoming one and both die on the hit, in a lane only one side fires into it crosses the arena and expires. Drones
## patrol the middle of the arena, soak up bullets, react to every hit, split and respawn after dying. Spawning, moving,
## hitting, reacting and freeing therefore all happen every frame at a steady rate once the arena fills, which is the
## workload the runner measures.
##
## This is a line-for-line port of the Kotlin GdArena: the same random draws in the same order and the same arithmetic,
## so both play exactly the same game.
class_name GdArena
extends Node2D

const Art := preload("res://gd/Art.gd")
const ScriptCalls := preload("res://gd/ScriptCalls.gd")

const WIDTH := 960.0
const LANES := 24
## Each team fires into 18 of the 24 lanes, offset from the other's: the middle 12 are shared and their bullets meet
## head-on, the outer 6 on each side carry one team only and their bullets cross the arena and expire.
const LANES_PER_TEAM := 18
const TOP := 20.0
const LANE_SPACING := 24.0
const BOTTOM := TOP + (LANES - 1) * LANE_SPACING
const MIDDLE_LEFT := 300.0
const MIDDLE_RIGHT := 660.0
## Drawn larger than it collides, so the faces read; the game only sees the collision radius.
const DRONE_DRAWN_RADIUS := 18.0
## Width of each turret column outside the play field, and the turrets drawn in it.
const TURRET_MARGIN := 40.0

const BULLETS_NAME := "Bullets"
const DRONES_NAME := "Drones"
const BULLET_SPEED := 400.0
## Two bullets close in at 2 x 400 px/s, about 13 px per frame at 60 fps; radii summing past that keep a head-on pair
## from passing through each other between two physics steps.
const BULLET_RADIUS := 8.0
## Drawn smaller than it collides, so the lanes read as streams of separate shots rather than solid bands.
const BULLET_DRAWN_RADIUS := 4.0
const DRONE_RADIUS := 14.0
const TURRET_INSET := 6.0
const TURRET_BODY := 18.0
const TURRET_HALF_HEIGHT := 7.0
const BARREL_GAP := 2.0
const TURRET_BARREL := 4.0
const HUD_TOP := 588.0
const HUD_LINE_HEIGHT := 19.0
const FPS_LABEL_WIDTH := 120.0
const STATUS_INTERVAL_FRAMES := 15
const DRONE_COUNT := 12
## Drones only split while the arena holds fewer than this, so children cannot pile up.
const MAX_DRONES := 24
const SPLIT_OFFSET := 30.0
const DRONE_SPEED_X := 60.0
const DRONE_SPEED_Y := 120.0
const ORIGINALS := "originals"
const CHILDREN := "children"
## Half a second at 60 physics frames per second, the same delay as the timer a reaction would start.
const RESPAWN_FRAMES := 30


## How a drone looks: its dark inside, the fill that drains with its hit points, its face and its sensor ring.
class DroneLook:
	var hollow: Texture2D
	var fill: Texture2D
	var face: Texture2D
	var sensor: Texture2D

	func _init(hollow_texture: Texture2D, fill_texture: Texture2D, face_texture: Texture2D, sensor_texture: Texture2D) -> void:
		hollow = hollow_texture
		fill = fill_texture
		face = face_texture
		sensor = sensor_texture


## Whether bullets and drones connect [signal Area2D.area_entered]. Off, nothing ever hits: bullets only expire.
var hits := true
## Whether a hit starts a [Tween] and a death a [SceneTreeTimer]. Off, respawns are counted down here instead.
var reactions := true
## Whether the scene is queried and recorded through the engine: groups, [method Node.get_node], scans and the score.
var bookkeeping := true
## Whether the run has a window to show effects in. Headless, measured runs leave them out of the workload.
var effects := false
var drone_shape := CircleShape2D.new()
var sensor_shape := CircleShape2D.new()
var drone_look: DroneLook

var _random := RandomNumberGenerator.new()
# One shape per kind of body, shared as a scene would share its sub-resource.
var _bullet_shape := CircleShape2D.new()
# Filled only when bullets are nodes, one texture per team; otherwise the arena draws them.
var _bullet_textures: Array[Texture2D] = [null, null]
var _bullet_container: Node
var _drone_container: Node
var _status: Label
var _frames_per_second: Label
var _frames_until_status := 0
var _draw_bullets := false
# Only filled when the arena draws the bullets itself.
var _drawn_bullets := {}
# Kills recorded through the engine, by originals and by the children of splits; only kept with bookkeeping on.
var _score := {}
# The physics frames at which respawns fall due when reactions are off, in order.
var _pending_respawns: Array[int] = []

var _bullets_per_frame := 0
var _lifetime_frames := 0
var _max_live := 0
var _physics_frame := 0

var _live := 0
var _live_drones := 0
var _spawned := 0
var _bullet_hits := 0
var _drone_strikes := 0
var _expired := 0
var _skipped := 0
var _drone_hits := 0
var _kills := 0
var _child_kills := 0
var _splits := 0
var _respawns := 0
var _scans := 0
var _scanned_bullets := 0
var _scanned_drones := 0


func configure(seed: int, bullets_per_frame: int, lifetime_frames: int, max_live: int, render: String, hits_on: bool, reactions_on: bool, bookkeeping_on: bool) -> void:
	_random.seed = seed
	_bullet_shape.radius = BULLET_RADIUS
	drone_shape.radius = DRONE_RADIUS
	sensor_shape.radius = GdDrone.SENSOR_RADIUS
	_bullets_per_frame = bullets_per_frame
	_lifetime_frames = lifetime_frames
	_max_live = max_live
	hits = hits_on
	reactions = reactions_on
	bookkeeping = bookkeeping_on
	effects = DisplayServer.get_name() != "headless"
	# Shifted right to leave room for the turrets outside the play field. Every body moves by the same amount, so the
	# physics, and so the game, are unchanged.
	position = Vector2(TURRET_MARGIN, 0)
	_draw_bullets = render == "draw"
	if not _draw_bullets:
		_bullet_textures[0] = Art.disc(int(BULLET_DRAWN_RADIUS), Art.TEAM_A)
		_bullet_textures[1] = Art.disc(int(BULLET_DRAWN_RADIUS), Art.TEAM_B)
	var drone_radius := int(DRONE_DRAWN_RADIUS)
	drone_look = DroneLook.new(
		Art.disc(drone_radius, Art.HOLLOW),
		Art.disc(drone_radius, Art.DRONE),
		Art.drone_face(drone_radius, Art.DRONE),
		Art.ring(int(GdDrone.SENSOR_RADIUS), 2, Art.SENSOR),
	)
	if bookkeeping:
		_score[ORIGINALS] = 0
		_score[CHILDREN] = 0

	_bullet_container = Node2D.new()
	_bullet_container.name = BULLETS_NAME
	_drone_container = Node2D.new()
	_drone_container.name = DRONES_NAME
	add_child(_bullet_container)
	add_child(_drone_container)
	var teams := Label.new()
	teams.text = "Blue turrets fire right, orange turrets fire left. Bullets that meet destroy each other; " + \
		"the rest fly off the far edge."
	var drones := Label.new()
	drones.text = "Drones patrol the middle and drain as they are hit; the ring is the sensor each one scans. " + \
		"A drone splits in two when it dies, then respawns."
	_status = Label.new()
	var hud: Array[Label] = [teams, drones, _status]
	for line in hud.size():
		hud[line].position = Vector2(8 - TURRET_MARGIN, HUD_TOP + line * HUD_LINE_HEIGHT)
	# Bottom right, on the row of the live counts: the one corner nothing else uses.
	_frames_per_second = Label.new()
	_frames_per_second.horizontal_alignment = HORIZONTAL_ALIGNMENT_RIGHT
	_frames_per_second.position = Vector2(WIDTH + TURRET_MARGIN - 8 - FPS_LABEL_WIDTH, HUD_TOP + 2 * HUD_LINE_HEIGHT)
	_frames_per_second.size = Vector2(FPS_LABEL_WIDTH, HUD_LINE_HEIGHT)
	for label: Label in [teams, drones, _status, _frames_per_second]:
		label.add_theme_font_size_override("font_size", 13)
		label.add_theme_color_override("font_color", Art.TEXT)
		add_child(label)
	# The lanes and the turret lines are drawn here once; in draw mode every frame redraws them with the bullets.
	queue_redraw()

	for i in DRONE_COUNT:
		_spawn_drone(_random_middle_x(), _random_y(), true)


func _physics_process(_delta: float) -> void:
	ScriptCalls.count += 1
	_physics_frame += 1
	while not _pending_respawns.is_empty() and _pending_respawns[0] <= _physics_frame:
		_pending_respawns.pop_front()
		respawn()

	# Looked up by name every frame, as game code that does not cache its nodes does.
	var bullets: Node = get_node(BULLETS_NAME) if bookkeeping else _bullet_container
	for i in _bullets_per_frame:
		if _live >= _max_live:
			_skipped += 1
			continue
		var team := i % 2
		var first_lane := 0 if team == 0 else LANES - LANES_PER_TEAM
		var lane := _random.randi_range(first_lane, first_lane + LANES_PER_TEAM - 1)
		var bullet := GdBullet.new()
		bullet.launch(
			self,
			team,
			0.0 if team == 0 else WIDTH,
			TOP + lane * LANE_SPACING,
			BULLET_SPEED if team == 0 else -BULLET_SPEED,
			_lifetime_frames,
			_bullet_shape,
			_bullet_textures[team],
		)
		bullets.add_child(bullet)
		if _draw_bullets:
			_drawn_bullets[bullet] = true
		_live += 1
		_spawned += 1
	if _draw_bullets:
		queue_redraw()
	# The live counts are only for a viewer, so a headless run does not build them. In a measured run the window plays
	# as fast as it can, so the FPS shown is how fast frames are computed.
	if effects:
		_frames_until_status -= 1
		if _frames_until_status <= 0:
			_frames_until_status = STATUS_INTERVAL_FRAMES
			_status.text = "Live bullets %d   bullet hits %d   drone hits %d   kills %d   splits %d   respawns %d   expired %d" % [
				_live, _bullet_hits, _drone_hits, _kills, _splits, _respawns, _expired,
			]
			_frames_per_second.text = "%.0f FPS" % Engine.get_frames_per_second()


func _draw() -> void:
	ScriptCalls.count += 1
	for lane in LANES:
		var y := TOP + lane * LANE_SPACING
		draw_line(Vector2(0, y), Vector2(WIDTH, y), Art.LANE, 1.0)
	# Each team's turrets stand on a base strip outside the play field, one at the start of every lane it fires into,
	# the barrel pointing into the lane where the bullets leave it.
	var base_height := LANES_PER_TEAM * LANE_SPACING
	var first_lane_b := LANES - LANES_PER_TEAM
	draw_rect(Rect2(-TURRET_MARGIN, TOP - LANE_SPACING / 2, TURRET_MARGIN, base_height), Art.TEAM_A_BASE)
	draw_rect(Rect2(WIDTH, TOP + (first_lane_b - 0.5) * LANE_SPACING, TURRET_MARGIN, base_height), Art.TEAM_B_BASE)
	# Each body sits TURRET_INSET from the outer edge, its barrel reaching to just short of the play field.
	var body_a := -TURRET_MARGIN + TURRET_INSET
	var body_b := WIDTH + TURRET_MARGIN - TURRET_INSET - TURRET_BODY
	for lane in LANES_PER_TEAM:
		var y_a := TOP + lane * LANE_SPACING
		var y_b := TOP + (first_lane_b + lane) * LANE_SPACING
		draw_rect(Rect2(body_a, y_a - TURRET_HALF_HEIGHT, TURRET_BODY, 2 * TURRET_HALF_HEIGHT), Art.TEAM_A)
		draw_line(Vector2(body_a + TURRET_BODY, y_a), Vector2(-BARREL_GAP, y_a), Art.TEAM_A, TURRET_BARREL)
		draw_rect(Rect2(body_b, y_b - TURRET_HALF_HEIGHT, TURRET_BODY, 2 * TURRET_HALF_HEIGHT), Art.TEAM_B)
		draw_line(Vector2(body_b, y_b), Vector2(WIDTH + BARREL_GAP, y_b), Art.TEAM_B, TURRET_BARREL)
	for bullet: GdBullet in _drawn_bullets:
		draw_circle(bullet.position, BULLET_DRAWN_RADIUS, Art.TEAM_A if bullet.team == 0 else Art.TEAM_B)


func record_bullet_hit(bullet: GdBullet, hit_drone: bool) -> void:
	if hit_drone:
		_drone_strikes += 1
	else:
		_bullet_hits += 1
	_remove_bullet(bullet)


func record_expired(bullet: GdBullet) -> void:
	_expired += 1
	_remove_bullet(bullet)


func _remove_bullet(bullet: GdBullet) -> void:
	_live -= 1
	if _draw_bullets:
		_drawn_bullets.erase(bullet)


func record_drone_hit() -> void:
	_drone_hits += 1


func record_kill(original: bool) -> void:
	_kills += 1
	_live_drones -= 1
	if not original:
		_child_kills += 1
	if bookkeeping:
		var key := ORIGINALS if original else CHILDREN
		_score[key] += 1


func record_scan(bullets_nearby: int, drones: int) -> void:
	_scans += 1
	_scanned_bullets += bullets_nearby
	_scanned_drones += drones


## The respawn of a dead drone when reactions are off: the same delay, counted in physics frames by the arena.
func schedule_respawn() -> void:
	_pending_respawns.push_back(_physics_frame + RESPAWN_FRAMES)


func respawn() -> void:
	_respawns += 1
	_spawn_drone(_random_middle_x(), _random_y(), true)


## Two children where an original died, deferred to here because the engine refuses new areas in a collision.
func split(x: float, y: float) -> void:
	ScriptCalls.count += 1
	if _live_drones + 2 > MAX_DRONES:
		return
	_splits += 1
	_spawn_drone(clampf(x - SPLIT_OFFSET, MIDDLE_LEFT, MIDDLE_RIGHT), y, false)
	_spawn_drone(clampf(x + SPLIT_OFFSET, MIDDLE_LEFT, MIDDLE_RIGHT), y, false)


func _spawn_drone(x: float, y: float, original: bool) -> void:
	var drone := GdDrone.new()
	drone.place(self, x, y, _random_direction() * DRONE_SPEED_X, _random_direction() * DRONE_SPEED_Y, original)
	var drones: Node = get_node(DRONES_NAME) if bookkeeping else _drone_container
	drones.add_child(drone)
	_live_drones += 1


func _random_direction() -> float:
	return -1.0 if _random.randi_range(0, 1) == 0 else 1.0


func _random_middle_x() -> float:
	return _random.randf_range(MIDDLE_LEFT, MIDDLE_RIGHT)


func _random_y() -> float:
	return _random.randf_range(TOP, BOTTOM)


func live_bullets() -> int:
	return _live


## GDScript has no garbage collector or allocation counter to report: only the script calls are counted.
func runtime_counters() -> Dictionary:
	return {"available": 0, "script_calls": ScriptCalls.count}


func garbage_collectors() -> String:
	return "none: GDScript frees by reference counting"


func stats() -> Dictionary:
	return {
		"spawned": _spawned,
		"bullet_hits": _bullet_hits,
		"drone_strikes": _drone_strikes,
		"expired": _expired,
		"skipped": _skipped,
		"live": _live,
		"drone_hits": _drone_hits,
		"kills": _kills,
		"child_kills": _child_kills,
		"splits": _splits,
		"respawns": _respawns,
		"live_drones": _live_drones,
		"scans": _scans,
		"scanned_bullets": _scanned_bullets,
		"scanned_drones": _scanned_drones,
	}
