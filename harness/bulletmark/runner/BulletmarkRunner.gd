extends Node

## Runs the arena for a warm-up, then records the wall time of a fixed number of frames. Godot is started with
## --fixed-fps, so every frame advances the game by the same step and every run with the same settings simulates the
## same game: what varies between runs is only how long the frames took to compute.

## The same scene in each language, each a line-for-line port of the others that plays exactly the same game.
const ARENAS := {
	"kt": "res://src/main/kotlin/godot/bulletmark/Arena.kt",
	"cs": "res://cs/Arena.cs",
}
const RESULT_MARKER := "BULLETMARK_RESULT:"
const SCHEMA := 5
## How often the live bullet count is read during the measured frames. Each read is a call into the JVM, so it stays
## rare enough not to show in the frame times.
const LIVE_SAMPLE_INTERVAL := 60
const RENDER_MODES := ["nodes", "draw"]
const COMPARED_STATS := ["p50", "p95", "p99", "mean"]
const COMPARED_RUNTIME_COUNTERS := ["allocated_bytes_per_frame", "script_calls_per_frame", "gc_count", "gc_time_ms"]

var options := {}
var settings := {}
var arena: Node2D
var frame := 0
var last_usec := 0
var frame_usec := PackedInt64Array()
var live_samples := PackedInt32Array()
var screenshot_frames := PackedInt32Array()
var runtime_at_start := {}


func _ready() -> void:
	options = _parse_options(OS.get_cmdline_user_args())
	settings = _resolve_settings()
	if settings.is_empty():
		get_tree().quit(1)
		return

	var arena_script: Script = load(ARENAS[settings.lang])
	if arena_script == null:
		push_error("Cannot load the %s arena: is this the editor for that language, with the scripts built?" % settings.lang)
		get_tree().quit(1)
		return
	arena = arena_script.new()
	add_child(arena)
	arena.configure(
		settings.seed,
		settings.bullets_per_frame,
		settings.lifetime_frames,
		settings.max_live,
		settings.render,
		settings.hits,
		settings.reactions,
		settings.bookkeeping,
	)
	print("Bulletmark (%s): %d warm-up frames, %d measured frames" % [settings.lang, settings.warmup_frames, settings.measured_frames])
	print("settings       %s" % JSON.stringify(settings))
	# Saving frames needs a renderer, so a headless run ignores the option rather than writing blank images.
	if options.has("screenshots") and DisplayServer.get_name() != "headless":
		for value in String(options.screenshots).split(","):
			screenshot_frames.append(int(value))


# This node is the arena's parent, so it processes first in every frame: the time between two of its calls is one
# whole frame, physics, scripts, signals and the binding's memory sync included.
func _process(_delta: float) -> void:
	var now := Time.get_ticks_usec()
	if frame == settings.warmup_frames:
		runtime_at_start = arena.runtime_counters()
	if frame > settings.warmup_frames:
		frame_usec.append(now - last_usec)
		if frame_usec.size() % LIVE_SAMPLE_INTERVAL == 0:
			live_samples.append(arena.live_bullets())
	last_usec = now
	if screenshot_frames.has(frame):
		_save_screenshot(frame)
	frame += 1
	if frame_usec.size() >= settings.measured_frames:
		set_process(false)
		_finish()


## Every setting the game depends on, defaults filled in. Two runs are comparable only when these match exactly, so the
## report records them in full rather than only the options that were passed. Empty when an option is invalid.
func _resolve_settings() -> Dictionary:
	var resolved := {
		"lang": String(options.get("lang", "kt")),
		"seed": int(options.get("seed", 42)),
		"bullets_per_frame": int(options.get("bullets-per-frame", 40)),
		"lifetime_frames": int(options.get("lifetime-frames", 150)),
		"max_live": int(options.get("max-live", 10000)),
		"render": String(options.get("render", "nodes")),
		"hits": _switch("hits"),
		"reactions": _switch("reactions"),
		"bookkeeping": _switch("bookkeeping"),
		"warmup_frames": int(options.get("warmup-frames", 2400)),
		"measured_frames": int(options.get("frames", 1200)),
		# A window renders every frame and shows effects a headless run skips, so the two never compare.
		"headless": DisplayServer.get_name() == "headless",
	}
	var problems: Array[String] = []
	if not ARENAS.has(resolved.lang):
		problems.append("lang must be one of %s, not %s" % [ARENAS.keys(), resolved.lang])
	if not RENDER_MODES.has(resolved.render):
		problems.append("render must be one of %s, not %s" % [RENDER_MODES, resolved.render])
	for name in ["hits", "reactions", "bookkeeping"]:
		if not ["on", "off"].has(String(options.get(name, "on"))):
			problems.append("%s must be on or off, not %s" % [name, options.get(name)])
	for problem in problems:
		push_error("Bulletmark: " + problem)
	return {} if not problems.is_empty() else resolved


func _switch(name: String) -> bool:
	return String(options.get(name, "on")) == "on"


func _finish() -> void:
	var frames := _frame_stats(frame_usec)
	var report := {
		"schema": SCHEMA,
		"run": {"label": options.get("label", "run"), "commit": options.get("commit", "unknown")},
		"settings": settings,
		"environment": _environment(),
		"frames_us": frames,
		"live_bullets": {"min": Array(live_samples).min(), "max": Array(live_samples).max(), "samples": Array(live_samples)},
		"game": arena.stats(),
		"runtime": _runtime_usage(runtime_at_start, arena.runtime_counters(), frame_usec.size()),
	}
	if options.has("raw-samples"):
		report["frame_samples_us"] = Array(frame_usec)
	if options.has("baseline"):
		report["baseline"] = _compare(report, _read_json(String(options.baseline)))

	var directory := ProjectSettings.globalize_path(String(options.get("results-dir", "res://results")))
	DirAccess.make_dir_recursive_absolute(directory)
	var path := directory.path_join("%s.json" % report.run.label)
	var file := FileAccess.open(path, FileAccess.WRITE)
	file.store_string(JSON.stringify(report, "  "))
	file.close()

	print("frame time us  p50 %d  p95 %d  p99 %d  max %d  mean %.1f" % [
		frames.p50, frames.p95, frames.p99, frames.max, frames.mean,
	])
	print("live bullets   %d to %d" % [report.live_bullets.min, report.live_bullets.max])
	print("game           %s" % JSON.stringify(report.game))
	_print_runtime(report.runtime)
	if report.has("baseline"):
		_print_comparison(report.baseline)
	print("Results written to %s" % path)
	print(RESULT_MARKER + "PASS")
	get_tree().quit()


## What the language's runtime, the JVM or .NET, did during the measured frames: allocation and script calls per frame,
## collections and their pauses, and compilation time, which should be close to zero once the warm-up has compiled
## the hot paths.
func _runtime_usage(start: Dictionary, end: Dictionary, frames: int) -> Dictionary:
	var usage := {
		"available": int(end.get("available", 0)) == 1,
		"script_calls_per_frame": float(end.script_calls - start.script_calls) / frames,
	}
	if not usage.available:
		return usage
	usage["garbage_collectors"] = arena.garbage_collectors()
	usage["allocated_bytes_per_frame"] = float(end.allocated_bytes - start.allocated_bytes) / frames
	usage["gc_count"] = end.gc_count - start.gc_count
	usage["gc_time_ms"] = end.gc_time_ms - start.gc_time_ms
	usage["jit_time_ms"] = end.jit_time_ms - start.jit_time_ms
	return usage


func _print_runtime(usage: Dictionary) -> void:
	if not usage.available:
		print("runtime        counters unavailable (no java.management); %.1f script calls per frame" % usage.script_calls_per_frame)
		return
	print("runtime        %.1f KB allocated and %.1f script calls per frame" % [
		usage.allocated_bytes_per_frame / 1024.0, usage.script_calls_per_frame,
	])
	print("               %d collections, %d ms in GC (%s), %d ms compiling" % [
		usage.gc_count, usage.gc_time_ms, usage.garbage_collectors, usage.jit_time_ms,
	])


## A baseline is only worth comparing against when it ran the same settings and played the same game. The second
## check catches a change that altered the game itself, whose frame times would otherwise read as a speed change. The
## language alone may differ: a faithful port plays the same game, so the game check is then what proves the port.
func _compare(report: Dictionary, baseline: Dictionary) -> Dictionary:
	var result := {
		"label": baseline.get("run", {}).get("label", "unknown"),
		"commit": baseline.get("run", {}).get("commit", "unknown"),
		"comparable": true,
		"reasons": [],
	}
	if baseline.is_empty():
		result.comparable = false
		result.reasons.append("the baseline could not be read")
		return result
	var baseline_lang: String = baseline.get("settings", {}).get("lang", "kt")
	if baseline_lang != report.settings.lang:
		result["languages"] = [baseline_lang, report.settings.lang]
	var differing_settings := _differing_keys(report.settings, baseline.get("settings", {}))
	differing_settings.erase("lang")
	if not differing_settings.is_empty():
		result.comparable = false
		result.reasons.append("settings differ: %s" % ", ".join(differing_settings))
	var differing_game := _differing_keys(report.game, baseline.get("game", {}))
	if not differing_game.is_empty():
		result.comparable = false
		result.reasons.append("the game played out differently: %s" % ", ".join(differing_game))

	var before: Dictionary = baseline.get("frames_us", {})
	var deltas := {}
	for stat in COMPARED_STATS:
		if before.has(stat) and float(before[stat]) > 0.0:
			deltas[stat] = {
				"before": before[stat],
				"after": report.frames_us[stat],
				"change_percent": (float(report.frames_us[stat]) / float(before[stat]) - 1.0) * 100.0,
			}
	result["frames_us"] = deltas

	var runtime_before: Dictionary = baseline.get("runtime", {})
	var runtime_deltas := {}
	if report.runtime.available and runtime_before.get("available", false):
		for counter in COMPARED_RUNTIME_COUNTERS:
			runtime_deltas[counter] = {"before": runtime_before.get(counter, 0), "after": report.runtime[counter]}
	result["runtime"] = runtime_deltas
	return result


## Keys whose values differ, compared after a JSON round trip: a baseline read back from its file holds every number
## as a float, so comparing it with freshly built integers would report every number as different.
func _differing_keys(current: Dictionary, previous: Dictionary) -> Array[String]:
	var normalized: Dictionary = JSON.parse_string(JSON.stringify(current))
	var keys: Array[String] = []
	for key in normalized.keys():
		if not previous.has(key) or JSON.stringify(normalized[key]) != JSON.stringify(previous[key]):
			keys.append(String(key))
	for key in previous.keys():
		if not normalized.has(key):
			keys.append(String(key))
	return keys


func _print_comparison(comparison: Dictionary) -> void:
	print("against        %s (%s)" % [comparison.label, comparison.commit])
	if comparison.has("languages"):
		print("               languages %s -> %s" % comparison.languages)
	if not comparison.comparable:
		print("               NOT COMPARABLE: %s" % "; ".join(comparison.reasons))
	for stat in COMPARED_STATS:
		if comparison.frames_us.has(stat):
			var delta: Dictionary = comparison.frames_us[stat]
			print("               %-4s %8.1f -> %8.1f us  %+.1f%%" % [stat, delta.before, delta.after, delta.change_percent])
	for counter in comparison.get("runtime", {}):
		var values: Dictionary = comparison.runtime[counter]
		print("               %s %.1f -> %.1f" % [counter, values.before, values.after])


func _read_json(path: String) -> Dictionary:
	# A relative path is taken from the project, as the Gradle task runs Godot there.
	if not path.is_absolute_path():
		path = "res://" + path
	var file := FileAccess.open(path, FileAccess.READ)
	if file == null:
		push_error("Bulletmark: cannot read the baseline at %s" % path)
		return {}
	var parsed = JSON.parse_string(file.get_as_text())
	return parsed if parsed is Dictionary else {}


# Waits for the frame to finish drawing, then saves only the game's viewport, never the desktop around it.
func _save_screenshot(at_frame: int) -> void:
	await RenderingServer.frame_post_draw
	var directory := ProjectSettings.globalize_path(String(options.get("results-dir", "res://results"))).path_join("screenshots")
	DirAccess.make_dir_recursive_absolute(directory)
	var path := directory.path_join("%s_%d.png" % [options.get("label", "run"), at_frame])
	get_viewport().get_texture().get_image().save_png(path)
	print("Screenshot written to %s" % path)


func _frame_stats(samples: PackedInt64Array) -> Dictionary:
	var sorted := samples.duplicate()
	sorted.sort()
	var total := 0
	for value in sorted:
		total += value
	return {
		"p50": _percentile(sorted, 0.50),
		"p95": _percentile(sorted, 0.95),
		"p99": _percentile(sorted, 0.99),
		"min": sorted[0],
		"max": sorted[sorted.size() - 1],
		"mean": float(total) / sorted.size(),
	}


# Nearest-rank percentile of an already sorted array.
func _percentile(sorted: PackedInt64Array, quantile: float) -> int:
	var rank := int(ceil(quantile * sorted.size()))
	return sorted[clampi(rank - 1, 0, sorted.size() - 1)]


func _environment() -> Dictionary:
	return {
		"godot": Engine.get_version_info().string,
		"os": OS.get_name(),
		"processor": OS.get_processor_name(),
		"processor_count": OS.get_processor_count(),
		"physics_ticks_per_second": Engine.physics_ticks_per_second,
	}


func _parse_options(args: PackedStringArray) -> Dictionary:
	var result := {}
	for arg in args:
		if not arg.begins_with("--"):
			continue
		var pair := arg.substr(2).split("=", true, 1)
		result[pair[0]] = pair[1] if pair.size() > 1 else true
	return result
