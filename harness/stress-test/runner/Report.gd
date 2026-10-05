extends RefCounted

const SCHEMA := 3
const REGRESSION_THRESHOLD := 0.10

var options: Dictionary
var environment: Dictionary
var tests := {}
var baseline := {}
var baseline_label := ""
var baseline_run_key := ""
var regressions: Array[String] = []
var run_drift := {}


func _init(p_options: Dictionary, p_environment: Dictionary) -> void:
	options = p_options
	environment = p_environment
	if options.has("baseline"):
		var loaded := _read_json(options.baseline)
		baseline = loaded.get("tests", {})
		baseline_label = loaded.get("run", {}).get("label", options.baseline)
		baseline_run_key = loaded.get("run", {}).get("run_key", "")


func add_check(test: Dictionary, passed: bool, run_frames: int, run_ms: int, release: Dictionary) -> void:
	tests[test.name] = _common(test).merged({
		"status": "pass" if passed else "fail",
		"run_frames": run_frames,
		"run_ms": run_ms,
		"release": release,
	})


func add_perf(test: Dictionary, stats: Dictionary, per_round: Array, ops_per_call: int, measurement: Dictionary) -> void:
	var entry := _common(test).merged({
		"status": "measured",
		"unit": test.unit,
		"ops_per_call": ops_per_call,
		"measurement": measurement,
		"stats": stats,
		"per_round": per_round,
	})
	if baseline.has(test.name) and baseline[test.name].has("stats"):
		# Comparing runs of different sizes would compare call overhead, not the work.
		if _settings_key(baseline[test.name].settings) == _settings_key(entry.settings) and baseline_run_key == _run_key():
			entry["baseline"] = _compare(test.name, stats, measurement.round_spread)
		else:
			entry["baseline"] = {"label": baseline_label, "verdict": "not comparable"}
	tests[test.name] = entry


## Objects still allocated once every test has settled, against the floor measured before the first ran.
func add_run_drift(p_baseline: int, p_leftover: int) -> void:
	run_drift = {"baseline": p_baseline, "leftover": p_leftover}
	if p_leftover > 0:
		regressions.append("run leftover: %d objects above the pre-test baseline" % p_leftover)


func add_failure(test: Dictionary, reason: String) -> void:
	tests[test.name] = _common(test).merged({"status": "fail", "reason": reason})


func write() -> String:
	var label: String = options.get("label", options.get("commit", "run"))
	# An exported game cannot write to res://, so it keeps its results beside its own user data instead.
	var directory := "res://results" if OS.has_feature("editor") else "user://results"
	var path := "%s/%s.json" % [directory, label]
	DirAccess.make_dir_recursive_absolute(ProjectSettings.globalize_path(directory))
	var file := FileAccess.open(path, FileAccess.WRITE)
	file.store_string(JSON.stringify({
		"schema": SCHEMA,
		"run": {
			"label": label,
			"commit": options.get("commit", "unknown"),
			"date": Time.get_datetime_string_from_system(true),
			"options": options,
			"run_key": _run_key(),
			"drift": run_drift,
			"environment": environment,
		},
		"tests": tests,
		"summary": {
			"status": "fail" if _failures() > 0 else "pass",
			"failures": _failed_names(),
			"regressions": regressions,
			"baseline": baseline_label,
		},
	}, "\t"))
	file.close()
	return path


func print_summary() -> void:
	if not run_drift.is_empty():
		print("
allocated before the first test: %d, still allocated after the last: %+d" % [
			run_drift.baseline, run_drift.leftover,
		])
	print("\n%-42s %-8s %s" % ["test", "status", "result"])
	for name in tests:
		var result: Dictionary = tests[name]
		if result.category == "perf":
			print("%-42s %-8s %s" % [name, "", _perf_line(name, result)])
		else:
			print("%-42s %-8s %s" % [name, result.status.to_upper(), _check_line(result)])


func _common(test: Dictionary) -> Dictionary:
	return {
		"category": test.category,
		"descriptor": test.descriptor,
		"settings": {"batch": test.batch, "threads": test.threads, "ms": test.ms, "frames": test.frames,
			"settle": test.settle, "leftover": test.leftover, "fuzz": test.fuzz},
	}


## JSON gives every number back as a float, so settings have to be compared through a canonical form.
func _run_key() -> String:
	return "calls=%s sample-us=%s warmup-ms=%s rounds=%s quick=%s" % [
		options.get("calls", ""), options.get("sample-us", ""), options.get("warmup-ms", ""),
		options.get("rounds", ""), options.has("quick"),
	]


func _settings_key(settings: Dictionary) -> String:
	var keys := settings.keys()
	keys.sort()
	var parts := []
	for key in keys:
		var value = settings[key]
		parts.append("%s=%s" % [key, int(value) if value is float else value])
	return " ".join(parts)


## A change only counts as a regression once it is larger than the run's own round-to-round spread: an allocation
## bound test that moves a tenth between its own rounds cannot report a tenth of a slowdown as news.
func _compare(name: String, stats: Dictionary, round_spread: float) -> Dictionary:
	var previous: Dictionary = baseline[name].stats
	var threshold := maxf(REGRESSION_THRESHOLD, round_spread)
	var deltas := {}
	for key in ["median", "p95", "p99", "mean"]:
		deltas[key] = stats[key] / previous[key] - 1.0 if previous[key] > 0.0 else 0.0
	var worst := ""
	for key in deltas:
		if deltas[key] > threshold and (worst.is_empty() or deltas[key] > deltas[worst]):
			worst = key
	if not worst.is_empty():
		regressions.append(name)
	return {
		"label": baseline_label, "delta": deltas, "worst": worst, "threshold": threshold,
		"verdict": "regression" if not worst.is_empty() else "ok",
	}


func _check_line(result: Dictionary) -> String:
	var release: Dictionary = result.release
	if release.frames < 0:
		return "not released: %d objects, %d wrappers left" % [release.objects, release.wrappers]
	return "%d frames, %d ms, released after %d frames" % [result.run_frames, result.run_ms, release.frames]


func _perf_line(name: String, result: Dictionary) -> String:
	var stats: Dictionary = result.stats
	var line := "median %9.4f  p95 %9.4f  ±%4.1f%%  %s" % [
		stats.median, stats.p95, result.measurement.round_spread * 100.0, result.unit,
	]
	if not result.measurement.settled:
		line += "  NOT SETTLED"
	if result.has("baseline") and result.baseline.has("delta"):
		line += "  median %+.1f%%" % (result.baseline.delta.median * 100.0)
		if result.baseline.verdict == "regression":
			line += "  REGRESSION on %s %+.1f%%" % [result.baseline.worst, result.baseline.delta[result.baseline.worst] * 100.0]
	elif result.has("baseline"):
		line += "  (baseline ran different settings)"
	return line


func _failures() -> int:
	return _failed_names().size()


func _failed_names() -> Array[String]:
	var failed: Array[String] = []
	for name in tests:
		if tests[name].status == "fail":
			failed.append(name)
	return failed


func _read_json(path: String) -> Dictionary:
	var text := FileAccess.get_file_as_string(path)
	if text.is_empty():
		push_warning("Baseline %s could not be read" % path)
		return {}
	return JSON.parse_string(text)
