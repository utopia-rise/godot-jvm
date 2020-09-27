plugins {
    `godot-benchmarks`
}

godotBenchmarks {
    benchmarksDir.set(file("lang/"))
    languages {
        val gdscript by creating {}
        val kotlin by creating {}
    }
}
