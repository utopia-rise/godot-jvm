extends SceneTree

const Descriptor := preload("res://runner/Descriptor.gd")
const Report := preload("res://runner/Report.gd")
const Stats := preload("res://runner/Stats.gd")

const SUITES := [
	"res://src/main/kotlin/godot/stress/RaceStress.kt",
	"res://src/main/kotlin/godot/stress/MemoryStress.kt",
	"res://src/main/kotlin/godot/stress/PerfStress.kt",
]
const TRACKER := "res://src/main/kotlin/godot/stress/Tracker.kt"
const CATEGORIES := ["race", "memory", "perf"]
## The baseline settles like any other check: to a floor, with a shorter patience since it starts near one.
const BASELINE_BUDGET := 240
const BASELINE_STALL_FRAMES := 10
const STALL_FRAMES := 60
## A stepped test gets its declared frame budget plus room for the frames it spends setting up and tearing down.
const FRAME_BUDGET_SLACK := 30
## Enough samples for a median and a p95 to mean something, however large the calibrated batch turns out to be.
const MIN_SAMPLES := 50
const MAX_REPS := 1 << 20
## How far the per-round medians may spread before the reported number counts as not settled.
const STABILITY_THRESHOLD := 0.05
## Frames given to the release throttle between rounds, so nothing a round created is still draining in the next.
const DRAIN_FRAMES := 3

var options := {}
var report: Report
var tracker: Object
var overhead_us := 0.0


func _initialize() -> void:
	options = _parse_options(OS.get_cmdline_user_args())
	Engine.max_fps = int(options.get("max-fps", 0))
	tracker = load(TRACKER).new()
	report = Report.new(options, _environment())
	_run()


func _run() -> void:
	var quick: bool = options.has("quick")
	var sampling := {
		"calls": int(options.get("calls", 100 if quick else 1000)),
		"sample_us": int(options.get("sample-us", 200 if quick else 1000)),
		"warmup_ms": int(options.get("warmup-ms", 50 if quick else 500)),
		"rounds": int(options.get("rounds", 1 if quick else 3)),
	}
	var seed_value := int(options.get("seed", 42))
	var scale := 10 if quick else 1

	# Anything the binding builds lazily on first use is built now, before the first baseline. Otherwise whichever test
	# happens to reach it first is charged one object it never leaked, and that object lives for the whole run.
	tracker.warm_up()
	var run_baseline := await _settled_object_count()

	for path in SUITES:
		var suite: Object = load(path).new()
		var tests := _discover(suite, scale)
		for test in tests:
			if test.name == "perf_noop":
				suite.configure(test.batch, test.threads, test.ms, test.frames, seed_value)
				await _run_perf(suite, test, sampling)
		for test in tests:
			if test.name == "perf_noop":
				continue
			print("\n[%s] %s   %s" % [test.category, test.name, test.descriptor])
			suite.configure(test.batch, test.threads, test.ms, test.frames, seed_value)
			if test.category == "perf":
				await _run_perf(suite, test, sampling)
			else:
				await _run_stepped(suite, test)
		suite.free()

	# Nothing should outlive the tests as a group either, so the run is measured against the same floor it started from.
	var run_leftover := await _settled_object_count() - run_baseline
	report.add_run_drift(run_baseline, run_leftover)

	tracker.free()
	var path := report.write()
	report.print_summary()
	print("\nResults written to %s" % path)
	var failed: bool = report._failures() > 0
	print("STRESS_RESULT:%s" % ("FAIL" if failed else "PASS"))
	await process_frame
	quit(1 if failed else 0)


## A test declares its own settings in its suite's `stress_tests()` dictionary; the name prefix gives the category.
func _discover(suite: Object, scale: int) -> Array:
	var declared := Descriptor.declared(suite)
	var tests := []
	for method in suite.get_script().get_script_method_list():
		var category: String = method.name.get_slice("_", 0)
		if not CATEGORIES.has(category):
			continue
		if options.has("filter") and not method.name.contains(options.filter):
			continue
		if options.has("only") and category != options.only:
			continue
		var test := Descriptor.parse(method.name, category, declared.get(method.name, ""))
		test.batch = maxi(test.batch / scale, 1)
		test.ms = maxi(test.ms / scale, 1000)
		test.frames = maxi(test.frames / scale, 1)
		tests.append(test)
	tests.sort_custom(func(a, b): return [CATEGORIES.find(a.category), a.name] < [CATEGORIES.find(b.category), b.name])
	return tests


## Race and memory tests are stepped once per frame until they return true, then everything they created must be
## released: the release is throttled over frames, so settling waits while the object count keeps falling and only
## gives up once it stalls.
func _run_stepped(suite: Object, test: Dictionary) -> void:
	var baseline := await _settled_object_count()
	var started := Time.get_ticks_msec()
	var frame := 0
	var threw := false
	# A race test is bounded by its duration, a memory test by its frame budget; either way it must not spin forever.
	var budget: int = 100000 if test.category == "race" else test.frames + FRAME_BUDGET_SLACK
	while true:
		# A test that raises returns null through the binding; stepping it again would spin forever.
		var done = suite.call(test.name, frame)
		threw = done == null or frame > budget
		if threw or done:
			break
		frame += 1
		await process_frame
	var run_ms := Time.get_ticks_msec() - started

	var release := await _settle(test, baseline)
	var passed: bool = release.frames >= 0 and not threw
	report.add_check(test, passed, frame + 1, run_ms, release)
	print("  %s: %d frames, %d ms, %s" % [
		"PASS" if passed else "FAIL", frame + 1, run_ms,
		"the test raised, see the error above" if threw
			else "released after %d frames, %d objects over baseline" % [release.frames, release.objects] if passed
			else "%d objects and %d wrappers left" % [release.objects, release.wrappers],
	])


## Settles to a floor rather than to a fixed number of frames: a baseline taken while the previous test's objects are
## still draining is too high, and every later count is measured against it.
func _settled_object_count() -> int:
	tracker.reset()
	var previous := _object_count()
	var stalled := 0
	for i in BASELINE_BUDGET:
		tracker.collect()
		tracker.alive()
		await process_frame
		var count := _object_count()
		stalled = 0 if count < previous else stalled + 1
		previous = count
		if stalled >= BASELINE_STALL_FRAMES:
			break
	return _object_count()


func _settle(test: Dictionary, baseline: int) -> Dictionary:
	var previous := _object_count()
	var stalled := 0
	for i in test.settle:
		tracker.collect()
		# Read unconditionally: this is what drops the runner's own weak references to collected wrappers, and behind an
		# and it would only run on the frame the count already looked settled.
		var wrappers: int = tracker.alive()
		await process_frame
		var count := _object_count()
		if options.has("trace"):
			print("  settle %d: %d objects, %d wrappers" % [i, count, wrappers])
		if count - baseline <= test.leftover and wrappers == 0:
			return {"frames": i + 1, "objects": count - baseline, "wrappers": 0}
		stalled = 0 if count < previous else stalled + 1
		previous = count
		if stalled >= STALL_FRAMES:
			break
	print("  leftovers: %d objects (%d resources, %d nodes, %d orphan nodes) %s" % [
		_object_count() - baseline,
		int(Performance.get_monitor(Performance.OBJECT_RESOURCE_COUNT)),
		int(Performance.get_monitor(Performance.OBJECT_NODE_COUNT)),
		int(Performance.get_monitor(Performance.OBJECT_ORPHAN_NODE_COUNT)),
		tracker.dump(),
	])
	return {"frames": -1, "objects": _object_count() - baseline, "wrappers": tracker.alive()}


func _object_count() -> int:
	return int(Performance.get_monitor(Performance.OBJECT_COUNT))


## A perf test returns how many operations one call performed. Timing a single call would make the microsecond clock
## the dominant error: the cheap tests finish in tens of microseconds, so a reading quantises to whole percent steps
## and the median lands on a different step from one run to the next. Each sample therefore times a calibrated batch
## of calls, long enough that the clock contributes well under a tenth of a percent, and the report carries both the
## granularity that bought and whether the rounds agreed on the answer.
func _run_perf(suite: Object, test: Dictionary, sampling: Dictionary) -> void:
	var calls: int = sampling.calls
	var rounds: int = sampling.rounds
	var warmup_ms: int = sampling.warmup_ms

	# Warming comes first and is measured in wall time, not in calls: the tests differ by two orders of magnitude in
	# cost, so a fixed call count leaves the cheap ones interpreted. Calibrating before this would size the batch from
	# the interpreted cost and hand every cheap test a batch of one.
	_warm(suite, test, warmup_ms, 1)
	var reps := _calibrate(suite, test, int(sampling.sample_us))
	var samples_per_round := maxi(calls / reps, MIN_SAMPLES)

	var stats := Stats.new()
	var per_round := []
	var warmup_round := 0.0
	var ops := 1
	# One round more than asked for. Warming by wall time cannot reach the state a measured round actually runs in --
	# allocation paths, the release queue and the CPU's own clock all settle over the first round and it lands a tenth
	# slower every time -- so the first round is thrown away instead, and its median is reported so nothing is hidden.
	for round_index in rounds + 1:
		await _drain()
		_warm(suite, test, maxi(warmup_ms / 4, 1), reps)
		var round_stats := Stats.new()
		for i in samples_per_round:
			var returned
			var start := Time.get_ticks_usec()
			for j in reps:
				returned = suite.call(test.name)
			var micros := Time.get_ticks_usec() - start
			if not (returned is int) or returned <= 0:
				push_error("%s did not return an operation count" % test.name)
				report.add_failure(test, "the test did not return an operation count")
				return
			ops = returned
			var elapsed := float(micros) / float(reps * ops)
			round_stats.add(elapsed)
			if round_index > 0:
				stats.add(elapsed)
		var round_result := round_stats.to_dict(false)
		if round_index == 0:
			warmup_round = round_result.median
		else:
			per_round.append({"round": round_index - 1, "median": round_result.median, "p95": round_result.p95})

	var result := stats.to_dict(options.has("raw-samples"))
	var measurement := {
		"calls_per_sample": reps,
		"samples_per_round": samples_per_round,
		"resolution_us": 1.0 / float(reps * ops),
		"round_spread": _round_spread(per_round, result.median),
		"discarded_warmup_round": warmup_round,
		"harness_overhead_us": overhead_us,
	}
	measurement["settled"] = measurement.round_spread <= STABILITY_THRESHOLD
	if test.name == "perf_noop":
		overhead_us = result.median
		measurement.harness_overhead_us = overhead_us
	report.add_perf(test, result, per_round, ops, measurement)
	print("  median %.4f  p95 %.4f  stddev %.4f  %s   %s" % [
		result.median, result.p95, result.stddev, test.unit,
		"rounds agree within %.1f%%" % (measurement.round_spread * 100.0) if measurement.settled
			else "NOT SETTLED, rounds spread %.1f%%" % (measurement.round_spread * 100.0),
	])
	await _settled_object_count()


func _warm(suite: Object, test: Dictionary, duration_ms: int, reps: int) -> void:
	var until := Time.get_ticks_msec() + duration_ms
	while Time.get_ticks_msec() < until:
		for i in reps:
			suite.call(test.name)


## Doubles the batch until one sample lasts at least min_sample_us, so the microsecond clock is worth less than a
## tenth of a percent of the reading.
func _calibrate(suite: Object, test: Dictionary, min_sample_us: int) -> int:
	var reps := 1
	while reps < MAX_REPS:
		var start := Time.get_ticks_usec()
		for i in reps:
			suite.call(test.name)
		if Time.get_ticks_usec() - start >= min_sample_us:
			break
		reps *= 2
	return reps


## A round that still has the previous round's garbage draining through the release throttle measures the throttle.
func _drain() -> void:
	tracker.collect()
	for i in DRAIN_FRAMES:
		await process_frame


func _round_spread(per_round: Array, median: float) -> float:
	if per_round.size() < 2 or median <= 0.0:
		return 0.0
	var lowest: float = per_round[0].median
	var highest: float = per_round[0].median
	for entry in per_round:
		lowest = minf(lowest, entry.median)
		highest = maxf(highest, entry.median)
	return (highest - lowest) / median


func _environment() -> Dictionary:
	return {
		"godot": Engine.get_version_info().string,
		"jvm": tracker.jvm_info(),
		"os": "%s %s" % [OS.get_name(), OS.get_version()],
		"cpu": OS.get_processor_name(),
		"cpu_threads": OS.get_processor_count(),
		"debug_build": OS.is_debug_build(),
	}


func _parse_options(args: PackedStringArray) -> Dictionary:
	var parsed := {}
	for arg in args:
		var key_value := arg.trim_prefix("--").split("=", true, 1)
		parsed[key_value[0]] = key_value[1] if key_value.size() > 1 else true
	return parsed
