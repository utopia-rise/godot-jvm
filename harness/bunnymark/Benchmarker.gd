extends Control

var fps_update_interval := 1.0
var elapsed_time := 0.0
var fps_label: Label = null
var benchmark_container: Node2D = null
var benchmark_node: Node2D = null
var output_path := "user://benchmark_results.json"
var arg_bench := "--bench="
var arg_lang := "--lang="

# bunnymark
var bunnymark_target := 60.0
var bunnymark_target_error := 0.1
var benchmark_is_bunnymark := false
var bunnymark_update_interval := 2.0
var stable_updates_required := 3
var bunnymark_update_elapsed_time := 0.0
var stable_updates := 0

var bunny_number := 0
var ping_pong_counter := 0
var increasing := true

@export_enum("BunnymarkV2", "BunnymarkV1Sprites", "BunnymarkV1DrawTexture", "BunnymarkV3") var benchmark: String = "BunnymarkV2"
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

    start_benchmark(benchmark, language)

func _process(delta: float):
    elapsed_time += delta
    if elapsed_time >= fps_update_interval:
        fps_label.text = "FPS: " + str(Engine.get_frames_per_second())
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
    bunny_number = 0
    ping_pong_counter = 0
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
    bunnymark_update_elapsed_time += delta
    if bunnymark_update_elapsed_time > bunnymark_update_interval:
        var fps = Engine.get_frames_per_second()
        var difference = fps - bunnymark_target
        var bunny_difference := 0
        var current_stability_target = bunnymark_target_error * ping_pong_counter
        print("Tolerance: " + str(current_stability_target))
        if difference > current_stability_target:
            bunny_difference = clamp(difference * max(100, bunny_number/1000), 10, 2000)
            if !increasing:
                increasing = true
                ping_pong_counter += 1
            print("New Bunnies: " + str(bunny_difference))
        elif difference < -current_stability_target:
            bunny_difference = clamp(difference * max(100, bunny_number/1000), -2000, -10)
            if increasing:
                increasing = false
                ping_pong_counter += 1
            print("Deleted Bunnies: " + str(bunny_difference))
        if abs(difference) < current_stability_target:
            stable_updates += 1
            print("Current Bunnies: " + str(bunny_number))
            if stable_updates == stable_updates_required:
                benchmark_node.call("finish")
        else:
            bunny_number += bunny_difference
            bunny_number = max(bunny_number, 0)
            if bunny_difference > 0:
                for i in range(bunny_difference):
                    benchmark_node.call("add_bunny")
            else:
                for i in range(-bunny_difference):
                    benchmark_node.call("remove_bunny")
            stable_updates = 0

        bunnymark_update_elapsed_time = 0.0
