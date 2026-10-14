## The scene's look, generated once at startup so the project ships no image files. Every texture here is built once
## and shared by every body that shows it, so only the startup pays for it.

const TEAM_A := Color(0.35, 0.8, 1.0)
const TEAM_B := Color(1.0, 0.6, 0.25)
const TEAM_A_BASE := Color(0.35, 0.8, 1.0, 0.14)
const TEAM_B_BASE := Color(1.0, 0.6, 0.25, 0.14)
const DRONE := Color(0.95, 0.3, 0.35)
const SENSOR := Color(0.95, 0.3, 0.35, 0.3)
const LANE := Color(1.0, 1.0, 1.0, 0.07)
const TEXT := Color(0.9, 0.9, 0.9)
## The dark inside of a drone, which shows where its body has drained.
const HOLLOW := Color(0.08, 0.08, 0.1, 0.92)
const FEATURE := Color(1.0, 0.97, 0.9)
const TEETH := 6


static func disc(radius: int, color: Color) -> Texture2D:
	var image := _blank(radius)
	_fill_disc(image, _centre(radius), _centre(radius), radius, color)
	return ImageTexture.create_from_image(image)


## A circle outline [param thickness] pixels wide.
static func ring(radius: int, thickness: int, color: Color) -> Texture2D:
	var image := _blank(radius)
	_stroke_ring(image, _centre(radius), _centre(radius), radius, thickness, color)
	return ImageTexture.create_from_image(image)


## A drone's outline and evil face, drawn over its fill: transparent inside, so the fill below shows how much of the
## drone is left.
static func drone_face(radius: int, color: Color) -> Texture2D:
	var image := _blank(radius)
	var r := float(radius)
	var c := _centre(radius)
	_stroke_ring(image, c, c, r, 3.0, color)
	# Brows slanting down towards the nose read as anger at any size.
	_line(image, c - 0.62 * r, c - 0.5 * r, c - 0.12 * r, c - 0.22 * r, 2.4, FEATURE)
	_line(image, c + 0.62 * r, c - 0.5 * r, c + 0.12 * r, c - 0.22 * r, 2.4, FEATURE)
	_fill_disc(image, c - 0.34 * r, c - 0.05 * r, 0.13 * r, FEATURE)
	_fill_disc(image, c + 0.34 * r, c - 0.05 * r, 0.13 * r, FEATURE)
	# A jagged grin: a zigzag of teeth across the lower face.
	for tooth in TEETH:
		var x0 := c - 0.5 * r + tooth * r / TEETH
		var up_first := tooth % 2 == 0
		_line(image, x0, c + (0.32 if up_first else 0.5) * r, x0 + r / TEETH, c + (0.5 if up_first else 0.32) * r, 1.8, FEATURE)
	return ImageTexture.create_from_image(image)


static func _centre(radius: int) -> float:
	return radius - 0.5


static func _blank(radius: int) -> Image:
	return Image.create_empty(radius * 2, radius * 2, false, Image.FORMAT_RGBA8)


static func _fill_disc(image: Image, cx: float, cy: float, disc_radius: float, color: Color) -> void:
	var size := image.get_width()
	for y in size:
		for x in size:
			if _distance(x - cx, y - cy) <= disc_radius:
				image.set_pixel(x, y, color)


static func _stroke_ring(image: Image, cx: float, cy: float, ring_radius: float, thickness: float, color: Color) -> void:
	var size := image.get_width()
	for y in size:
		for x in size:
			var d := _distance(x - cx, y - cy)
			if d <= ring_radius and d > ring_radius - thickness:
				image.set_pixel(x, y, color)


## A line of [param thickness] pixels from (x0, y0) to (x1, y1).
static func _line(image: Image, x0: float, y0: float, x1: float, y1: float, thickness: float, color: Color) -> void:
	var dx := x1 - x0
	var dy := y1 - y0
	var length_squared := dx * dx + dy * dy
	var size := image.get_width()
	for y in size:
		for x in size:
			var t := 0.0 if length_squared == 0.0 else clampf(((x - x0) * dx + (y - y0) * dy) / length_squared, 0.0, 1.0)
			if _distance(x - (x0 + t * dx), y - (y0 + t * dy)) <= thickness / 2:
				image.set_pixel(x, y, color)


static func _distance(dx: float, dy: float) -> float:
	return sqrt(dx * dx + dy * dy)
