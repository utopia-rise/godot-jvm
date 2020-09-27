var Benchmark = load("res://scripts/Benchmark.gd")

func create(lang, name):
    var benchmarks = []
    var cls = load(__resolve_script(lang, name))
    for method in cls.get_script_method_list():
        var method_name = method["name"]
        if method_name.begins_with("benchmark_"):
            var benchmark_name = "%s:%s" % [name, method_name.replace("benchmark_", "")]
            var benchmark = Benchmark.new(cls.new(), benchmark_name, method_name, lang)
            benchmarks.append(benchmark)
    return benchmarks


func __resolve_script(lang, name):
    var path
    if lang == "gd":
        path = "gd/%s.gd" % name
    elif lang == "kt":
        path = "src/main/kotlin/godot/benchmark/%s.kt" % name
    else:
        assert(false, "Invalid language: %s" % lang)
    return "res://%s" % path
