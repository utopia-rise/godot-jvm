extends Control

var fps_update_interval := 1.0
var elapsed_time := 0.0
var fps_label: Label = null
var benchmark_container: Node2D = null
var benchmark_node: Node2D = null
## Some benchmarks put a bunny count on screen themselves, because updating a Label through the engine API every
## frame is part of what they measure. The readout below leaves the count to them rather than showing it twice.
var benchmark_shows_count := false
var output_path := "user://benchmark_results.json"
var arg_bench := "--bench="
var arg_lang := "--lang="
var arg_target := "--target="
var arg_warm_up := "--warmup="

# bunnymark
## The frame rate the ramp fills up to. Overridable per run with `--target=`.
@export var bunnymark_target := 60.0
var benchmark_is_bunnymark := false
var bunnymark_update_interval := 1.0
var bunnymark_update_elapsed_time := 0.0

## Bunnies each benchmark is expected to hold in the SLOWEST language, which is what the first spawn is sized
## from. It has to stay under every language's real capacity: the ramp only ever adds, so a first spawn that
## already sinks the frame rate would report itself as the answer. Everything above it the ramp finds on its own.
var bunnymark_expected := {
    "BunnymarkSceneTree": 37000,
    "BunnymarkSprites": 33000,
    "BunnymarkDrawTexture": 50000,
    "BunnymarkScripts": 34000,
    "BunnymarkComputation": 23000,
}
## Set while the first spawn has not yet been shown to leave headroom.
var seed_unconfirmed := false
var seed_used := false
## Enough to reach the target from just under it, so a run always terminates.
var bunnymark_minimum_spawn := 200
## Ceiling on one step, so a single bad frame-rate reading cannot fling the count past the target.
var bunnymark_max_growth := 3.0
## Fraction of the estimated gap closed per step. Below one so the count arrives over several steps rather than one,
## which gives the scripting runtime time to compile the hot loops before the frame rate is taken as final.
var bunnymark_approach_rate := 0.7
## Whether to run a warm-up at all. Only a language that compiles while it runs needs one, so this is forced off
## for any language outside [member bunnymark_warm_up_languages] whatever it is set to here. Overridable per run
## with `--warmup=true|false`.
@export var bunnymark_warm_up_enabled := true
## GDScript's virtual machine does not compile as it runs and gains nothing from a warm-up. Kotlin gains a lot and
## C# gains about 1%, both measured.
var bunnymark_warm_up_languages := ["kt", "cs"]
var warm_up_override := ""
## A throwaway population run before anything is measured, so the scripting runtime has compiled its hot paths and
## Godot is past its first slow moments. Discarded before the measured ramp starts. Common to every benchmark, as
## is [member bunnymark_stable_time].
var bunnymark_warm_up_bunnies := 20000
var bunnymark_warm_up_time := 20.0
var warm_up_elapsed_time := 0.0
var warm_up_cleared := false
var warmed_up := false
## Idle time after the warm-up population is freed, so the garbage collector reclaims its wrappers and the memory
## manager releases them before anything is measured. The manager syncs at the end of every frame, so this is a
## few hundred syncs rather than one.
var bunnymark_gc_wait_time := 5.0
## How long the frame rate has to hold at or below the target before the run ends. A shorter dip does not count:
## the scripting runtime may still be compiling, and the count usually climbs again afterwards.
@export var bunnymark_stable_time := 5.0
var below_target_time := 0.0
## The frame that spawns a batch also pays for creating it, so its frame rate says nothing about the new count.
var awaiting_settle := false

var bunny_number := 0

@export_enum("BunnymarkSceneTree", "BunnymarkSprites", "BunnymarkDrawTexture", "BunnymarkScripts", "BunnymarkComputation") var benchmark: String = "BunnymarkSceneTree"
@export_enum("gd", "kt", "cs") var language: String = "gd"

func _ready():
    set_process(false)
    fps_label = get_node("Panel/FPS")
    benchmark_container = get_node("BenchmarkContainer")

    var args = OS.get_cmdline_args() + OS.get_cmdline_user_args()
    for arg in args:
        if arg.substr(0, arg_bench.length()) == arg_bench:
            benchmark = arg.split("=")[1]
        elif arg.substr(0, arg_lang.length()) == arg_lang:
            language = arg.split("=")[1]
        elif arg.substr(0, arg_target.length()) == arg_target:
            bunnymark_target = float(arg.split("=")[1])
        elif arg.substr(0, arg_warm_up.length()) == arg_warm_up:
            warm_up_override = arg.split("=")[1]

    start_benchmark(benchmark, language)

func _process(delta: float):
    elapsed_time += delta
    if elapsed_time >= fps_update_interval:
        if benchmark_shows_count:
            fps_label.text = "FPS: %s" % Engine.get_frames_per_second()
        else:
            fps_label.text = "FPS: %s   Bunnies: %s" % [Engine.get_frames_per_second(), bunny_number]
        elapsed_time = 0.0
    if benchmark_is_bunnymark:
        update_bunnymark(delta)

func get_script_path(benchmark_name, language) -> String:
    if language == "kt":
        return "res://src/main/kotlin/godot/benchmark/bunnymark/" + benchmark_name + ".kt"
    else:
        return "res://benchmarks/" + benchmark_name + "/" + language + "/" + benchmark_name + "." + language

func start_benchmark(benchmark_name: String, language: String):
    print(benchmark_name)
    print(language)
    var language_extension = language
    var script_path := get_script_path(benchmark_name, language)
    benchmark_is_bunnymark = benchmark_name.begins_with("Bunnymark")
    bunnymark_update_elapsed_time = bunnymark_update_interval
    var script = load(script_path)
    benchmark_node = Node2D.new()
    benchmark_node.set_script(script)
    benchmark_node.add_user_signal("benchmark_finished", ["output"])
    benchmark_node.connect("benchmark_finished", Callable(self, "benchmark_finished"))
    benchmark_container.add_child(benchmark_node)
    benchmark_shows_count = not benchmark_node.find_children("*", "Label", true, false).is_empty()
    bunny_number = 0
    below_target_time = 0.0
    awaiting_settle = false
    if not language in bunnymark_warm_up_languages:
        bunnymark_warm_up_enabled = false
    if warm_up_override != "":
        bunnymark_warm_up_enabled = warm_up_override == "true"
    warm_up_elapsed_time = 0.0
    warm_up_cleared = false
    seed_unconfirmed = false
    seed_used = false
    warmed_up = not bunnymark_warm_up_enabled
    print("Target: " + str(bunnymark_target) + " fps, warm up: " + str(bunnymark_warm_up_enabled))
    if benchmark_node.has_method("add_bunny"):
        set_process(true)
    else:
        benchmark_finished(0)

func benchmark_finished(output):
    print("benchmark output: ", output)
    benchmark_container.remove_child(benchmark_node)
    benchmark_node.queue_free()
    write_result(output)
    get_tree().quit() 

func write_result(output):
    print("written ", output)
    var file := FileAccess.open(output_path, FileAccess.READ)
    var file_content = ""
    if file != null:
        file_content = file.get_as_text()
        file.close()
        
    var test_json_conv = JSON.new()
    var error := test_json_conv.parse(file_content)
    var benchmark_file: Variant = null
    if error == 0:
        benchmark_file = test_json_conv.get_parsed_text()
    if benchmark_file == null or typeof(benchmark_file) != TYPE_DICTIONARY:
        benchmark_file = {
            "benchmark_results": {}
        }
    benchmark_file["benchmark_results"][benchmark + "_" + language] = output
    var dir := DirAccess.open("res://")
    dir.remove(output_path)
    file = FileAccess.open(output_path, FileAccess.WRITE)
    benchmark_file["run_date"] = Time.get_datetime_dict_from_system()
    file.store_string(JSON.stringify(benchmark_file))

func update_bunnymark(delta):
    if not warmed_up:
        warm_up(delta)
        return

    bunnymark_update_elapsed_time += delta
    if bunnymark_update_elapsed_time < bunnymark_update_interval:
        return
    bunnymark_update_elapsed_time = 0.0

    if bunny_number == 0:
        if seed_used:
            spawn_bunnies(bunnymark_minimum_spawn)
        else:
            spawn_bunnies(int(bunnymark_expected.get(benchmark, 10000)) / 2)
            seed_used = true
            seed_unconfirmed = true
        return

    if awaiting_settle:
        awaiting_settle = false
        return

    var fps: float = Engine.get_frames_per_second()
    if fps <= bunnymark_target and seed_unconfirmed:
        # The first spawn alone already sank the frame rate, so its count says nothing about where the target is.
        # Clear the scene and let the ramp climb from the floor instead of reporting a number that is too high.
        print("Seed of " + str(bunny_number) + " overshot, restarting the ramp from the floor")
        for i in range(bunny_number):
            benchmark_node.call("remove_bunny")
        bunny_number = 0
        seed_unconfirmed = false
        return
    seed_unconfirmed = false
    if fps <= bunnymark_target:
        below_target_time += bunnymark_update_interval
        print("At target: " + str(bunny_number) + " bunnies, " + str(fps) + " fps")
        if below_target_time >= bunnymark_stable_time:
            benchmark_node.call("finish")
        return

    below_target_time = 0.0
    spawn_bunnies(next_bunny_number(fps) - bunny_number)

## Runs a throwaway population for a while, frees it, then idles long enough for that population to be collected.
## The measured ramp therefore starts from an empty scene, against a runtime that has already compiled everything
## the benchmark exercises and is no longer holding the warm-up's garbage.
##
## One clock drives all of it: a benchmark cannot take bunnies until its own first frame has run, so nothing is
## spawned before [member bunnymark_update_interval] has passed.
func warm_up(delta):
    warm_up_elapsed_time += delta
    if warm_up_elapsed_time < bunnymark_update_interval:
        return

    if not warm_up_cleared:
        if bunny_number == 0:
            bunny_number = bunnymark_warm_up_bunnies
            for i in range(bunnymark_warm_up_bunnies):
                benchmark_node.call("add_bunny")
            print("Warm up: " + str(bunnymark_warm_up_bunnies) + " bunnies for " + str(bunnymark_warm_up_time) + "s")
            return
        if warm_up_elapsed_time < bunnymark_update_interval + bunnymark_warm_up_time:
            return
        print("Warm up done at " + str(Engine.get_frames_per_second()) + " fps, freeing")
        for i in range(bunny_number):
            benchmark_node.call("remove_bunny")
        bunny_number = 0
        warm_up_cleared = true
        return

    if warm_up_elapsed_time < bunnymark_update_interval + bunnymark_warm_up_time + bunnymark_gc_wait_time:
        return
    print("Warm up collected, starting at " + str(Engine.get_frames_per_second()) + " fps")
    warmed_up = true
    bunnymark_update_elapsed_time = 0.0

## The count that would land exactly on the target frame rate.
##
## Frame time grows close to linearly with the bunny count, so scaling the current count by the headroom the frame
## rate still has lands on the count that would use all of it. The estimate is exact at the target and always short
## of it while above, because part of every frame does not depend on the bunnies at all. The ramp therefore takes
## large steps while far away, ever smaller ones as it closes in, and never overshoots into a frame rate it would
## have to back out of. Bunnies are never removed.
##
## [member bunnymark_approach_rate] then spreads the move over several steps instead of taking it in one.
func next_bunny_number(fps: float) -> int:
    var estimate: float = bunny_number * min(fps / bunnymark_target, bunnymark_max_growth)
    return int(bunny_number + (estimate - bunny_number) * bunnymark_approach_rate)

func spawn_bunnies(count: int):
    count = max(count, bunnymark_minimum_spawn)
    bunny_number += count
    for i in range(count):
        benchmark_node.call("add_bunny")
    awaiting_settle = true
    print("New Bunnies: " + str(count) + ", total: " + str(bunny_number) + ", at " + str(Engine.get_frames_per_second()) + " fps")
