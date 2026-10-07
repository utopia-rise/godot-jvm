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

## Bunnies this benchmark is expected to hold at [member bunnymark_target] in this language. Set per scene under
## `scenes/`, one of which exists for every benchmark and language pair, because the two differ by up to five times
## on the same benchmark and a figure that suited both would suit neither.
##
## It only sizes the first wave, which is this times [member bunnymark_growth_factor]; the ramp finds the real
## number from there and never reads it again. Being out of date therefore costs steps, not accuracy, which is why
## these are the published figures rounded to two significant figures rather than exact measurements.
@export var bunnymark_expected_score := 30000
## Set while the first spawn has not yet been shown to leave headroom.
var seed_unconfirmed := false
var seed_used := false
## Enough to reach the target from just under it, so a run always terminates.
var bunnymark_minimum_spawn := 200
## How much of the gap to the estimate a single step closes, and equally what fraction of
## [member bunnymark_expected_score] the first wave is. Below one so the count arrives over several steps rather
## than one, which gives the scripting runtime time to compile the hot loops before the frame rate is taken as
## final. Each step costs two update intervals, one to spawn and one for the frame rate to settle, so this is what
## decides how long a run takes.
@export_range(0.05, 1.0, 0.01) var bunnymark_growth_factor := 0.33
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
## How long the frame rate has to hold at or below the target before the run ends. A shorter dip does not count: the
## scripting runtime may still be compiling, and the count usually climbs again afterwards.
##
## Raising this costs more than it looks. Near the ceiling the frame rate oscillates either side of the target on
## noise alone, and a single reading above it both restarts this countdown and spawns again, so a long window keeps
## the run creeping upward for as long as the noise lasts rather than simply confirming a number.
@export var bunnymark_stable_time := 6.0
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

    # Every benchmark and language pair has its own scene under `scenes/`, and that scene is where the pair's
    # expected score lives. A command line run starts at the project's main scene instead, and choosing the pair from
    # the inspector on that scene would leave the same settings in place whatever was chosen, so hand over to the
    # pair's own scene unless this already is it.
    var pair_scene := "res://scenes/%s_%s.tscn" % [benchmark, language]
    if get_tree().current_scene.scene_file_path != pair_scene and ResourceLoader.exists(pair_scene):
        get_tree().change_scene_to_file.call_deferred(pair_scene)
        return

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
            spawn_bunnies(int(bunnymark_expected_score * bunnymark_growth_factor))
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
## Estimates the count that would land exactly on [member bunnymark_target] by scaling the current count by the
## headroom the frame rate still has, then moves [member bunnymark_growth_factor] of the way there.
##
## The estimate treats frame time as proportional to the count. Measured from half the expected score upwards that
## holds closely -- the estimates across one DrawTexture run were 217844, 216524, 218723, 219975 and 222140 against
## a final 216851 -- but it is not exact, and it errs high as often as low. What keeps the ramp underneath is the
## factor, not the model: closing only part of the gap means an estimate that is a little optimistic still lands
## short. Bunnies are never removed, because the frame rate after a removal says nothing about the count before it,
## so a factor near one trades the whole safety margin for a couple of steps.
func next_bunny_number(fps: float) -> int:
    var estimate: float = bunny_number * (fps / bunnymark_target)
    var delta: float = estimate - bunny_number
    return bunny_number + int(delta * bunnymark_growth_factor)

func spawn_bunnies(count: int):
    count = max(count, bunnymark_minimum_spawn)
    bunny_number += count
    for i in range(count):
        benchmark_node.call("add_bunny")
    awaiting_settle = true
    print("New Bunnies: " + str(count) + ", total: " + str(bunny_number) + ", at " + str(Engine.get_frames_per_second()) + " fps")
