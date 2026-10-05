package godot.stress

/** Per-test settings the runner resolves from the descriptor and applies before each test. */
class TestRun {
    var batch = 1_000
    var threads = 4
    var durationMs = 10_000L
    var seed = 42L
    var frames = 0
}
