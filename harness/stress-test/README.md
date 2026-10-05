# Godot-JVM stress test

A Godot project that hammers the binding's memory model. It exists to prove three things about a change before it
lands: no race between the JVM and the engine, every object released eventually, and no performance regression.

Tests are Kotlin scripts under `src/main/kotlin/godot/stress`, one class per category. The runner is
`runner/StressRunner.gd`, a `SceneTree` driven headless.

## Adding a test

Write the method, then add one line to the suite's `stressTests()`. Nothing in the runner changes.

```kotlin
@Register
fun stressTests() = """
    memory_create_drop
    memory_burst batch=100000 settle=3000
    memory_fuzz fuzz frames=120 batch=200
""".trimIndent()

@Register
fun memoryBurst(frame: Int): Boolean {
    repeat(run.batch) { Tracked.track(RefCounted()) }
    return true
}
```

The name prefix decides how the test is driven:

| Prefix | Signature | Contract |
|---|---|---|
| `race_` | `(frame: Int): Boolean` | Stepped once per frame, returns true when its workers stopped |
| `memory_` | `(frame: Int): Boolean` | Stepped once per frame, returns true when done |
| `perf_` | `(): Int` | Returns the number of operations the call performed |

Every suite also declares `configure(batch, threads, durationMs, frames, seed)`, which the runner calls before each
test with that test's resolved values. Tests read them from their `TestRun`.

## The two layers of settings

**Per test, in the descriptor**, because they say what this test needs:

| Token | Applies to | Default | Meaning |
|---|---|---|---|
| `batch=N` | all | 1000 | Objects, or operations, per step |
| `threads=N` | race | 4 | Worker threads |
| `ms=N` | race | 10000 | How long the workers run |
| `frames=N` | memory, race | 120 | Step budget for a test that would otherwise run forever |
| `settle=N` | memory, race | 1200 | Frames allowed for everything the test created to be released |
| `leftover=N` | memory, race | 1 | Objects tolerated above the baseline once settled, see below |
| `unit=<text>` | perf | us/op | What one operation means in the report |
| `fuzz` | all | absent | The test is seeded and random, so the report records the seed |

An unknown token or a non-integer value aborts the run naming the test, because a typo that silently runs the wrong
test is worse than a run that stops.

**Per run, on the command line**, because they say how hard the whole run is:

| Option | Effect |
|---|---|
| `--quick` | Divides every batch, duration and frame budget by ten and shortens the perf loops |
| `--calls=N` | Calls per measured round, grouped into timed samples. Default 1000 |
| `--sample-us=N` | How long one timed sample must last. Default 1000 |
| `--warmup-ms=N` | Warm-up before calibration, a quarter of it again before each round. Default 500 |
| `--rounds=N` | Measured rounds, on top of one discarded warm-up round. Default 3 |
| `--seed=N` | Seed handed to every fuzz test |
| `--filter=<text>`, `--only=race\|memory\|perf` | Which tests run |
| `--label=<name>`, `--baseline=<path>`, `--raw-samples` | Reporting |
| `--trace`, `--max-fps=N` | Diagnostics |

The two layers never overlap, so there is no precedence to remember.

## How a perf number is measured

A single call to the cheaper tests takes tens of microseconds, and `Time.get_ticks_usec()` counts whole
microseconds, so timing one call at a time quantises the reading into steps of a percent or more and the median
lands on a different step every run. Four things keep that from happening.

**Warm, then calibrate.** Each test is run for `--warmup-ms` before anything is timed, because a cold interpreted
call is slow enough to look like a whole sample on its own and would make the next step size every batch at one.
Only then does the runner double a batch of calls until one batch lasts `--sample-us`, which puts the clock's
granularity below a tenth of a percent. The report carries the granularity each test reached.

**A discarded first round.** Warming by wall clock never quite reaches the state a measured round runs in:
allocation paths, the release queue and the processor's own clock all settle during the first round, which comes
out about a tenth slower whatever you do to the warm-up. So the first round is thrown away rather than averaged
in, and its median is still written to the report so nothing is hidden.

**A drain between rounds.** A round that begins with the previous round's objects still moving through the release
throttle measures the throttle. Each round starts from a collection and a few frames, then re-warms.

**A verdict instead of a promise.** The rounds are timed separately and the run reports how far their medians
spread. Under a twentieth apart and the number has settled; wider and it is printed `NOT SETTLED`, which is the
runner saying it cannot stand behind that reading this time. A regression against a baseline needs a change larger
than both ten percent and that spread, so a test whose own rounds disagree cannot report a small delta as news.

In practice the reference-transition tests settle to a few tenths of a percent and repeat within about two percent
across runs. The tests that create objects carry real variance, because allocation and collection are part of what
they measure; they are the ones that flag themselves, and that is the honest answer rather than a steadier-looking
number.

## Running

The native library comes from `harness/tests/addons/jvm`, so build it there first.

```bash
export GODOT_EDITOR=/path/to/godot
./gradlew importResources
./gradlew runStressTests -Pstress.args="--quick"
```

A race or memory test passes when every object it created is released again. The release is throttled over frames, so
settling waits while the object count keeps falling and gives up once it stalls. Collection waits for the JVM to
actually process references rather than trusting `System.gc()`, which is only a hint.

### The one object a test is allowed to leave behind

A test that creates Godot objects from the JVM ends exactly one object above its baseline, whether it created one or a
hundred thousand; a test that creates none, or whose last act frees what it made, ends exactly at its baseline. That
one is the last object the test created, and it stays reachable from the JVM until another call crosses the boundary.
Nothing the runner can do from this side clears it: forcing a collection does not, and creating an object to displace
it just moves the tenancy to the new one.

So `leftover` defaults to 1 rather than 0. What makes that safe is the check underneath it. Before the first test the
runner warms everything the binding builds lazily — `GD` alone creates a `RandomNumberGenerator` on first use that
lives for the rest of the process — settles to a floor, and records how many objects are allocated at that point.
After the last test it settles again and reports the difference, which must be zero. A real leak accumulates and
shows up there; the last-object residue does not, because the next test's first call releases it.

This was measured, not assumed: logging every bind and unbind across a full memory run showed 115,415 objects created
by the JVM and exactly one outliving the test that created it, the `GD` random generator, which the warm-up now
accounts for.

Results land in `results/<label>.json` next to a console summary: full statistics per test (min, max, mean, median,
p90, p95, p99, standard deviation, median absolute deviation, sample count, per-round medians), how each perf number
was measured (batch size, samples per round, timer granularity, round spread, discarded warm-up round), the resolved
settings of every test, the release latency and leftovers of every check, and the machine, Godot, and JVM the run
happened on. With `--baseline=<path>` each perf test also carries its delta against that file.

The Gradle task fails on a non-zero exit code or on any Godot error line during the run, which is how the binding's
debug-build invariant checks surface.

## What each test measures

The binding lets a Godot object and a JVM wrapper keep each other alive, and decides on its own when to let go. Almost
every test below pins down one step of that decision, so that a change to the model either keeps the step or visibly
breaks it. See [memory management](../../docs/src/doc/contribute/how-it-works/memory-management.md) for the model
itself.

### Races

Godot's scene tree is not thread safe, so these stay on `RefCounted` objects and leave scripts to the main thread.
They exist because the decision to release is split across the JNI boundary: the JVM notices that a wrapper died, the
native side acts on it a synchronization later, and any delivery landing in between must not lose the object.

| Test | Measures | To what end |
|---|---|---|
| `race_deliver_across_threads` | Several threads asking for the same already wrapped objects at once | The one native reference per object survives concurrent delivery, and nothing is released while a thread is receiving it |
| `race_first_delivery_contended` | Threads asking for objects the JVM has never seen, simultaneously | An object gets exactly one wrapper and one reference however many threads race to create it |
| `race_refcount_scripts` | Threads driving a script instance between one and two owners while the main thread demotes at frame end | Promotion on one thread and demotion on another cannot leave a natively held instance weak |
| `race_deferred_calls_to_zombies` | Calls the engine queues to script instances that may be collected before the call runs | Such a call is ignored like a call on a freed object, instead of crashing or throwing |
| `race_worker_pool` | Deliveries originating from Godot's own worker threads | The native side attaches objects correctly when it, not Kotlin, starts the crossing |
| `race_fuzz` | Random create, deliver, drop and script changes across threads from a fixed seed | Interleavings nobody thought to write by hand, reproducible from the seed in the report |

### Memory

Each of these creates objects a specific way, drops them, and requires the count to return to where it started. The
interesting part is usually the shape of the ownership, not the number of objects.

| Test | Measures | To what end |
|---|---|---|
| `memory_create_drop` | Plain wrappers and script instances created and dropped by the JVM | The ordinary path releases, and nothing accumulates run after run |
| `memory_release_latency` | How many frames pass between dropping everything and the count returning | Latency is a property of the model, so a variant that trades it for speed shows the trade here |
| `memory_weak_only_bouncer` | Script instances anchored by a Godot array alone, bounced in and out while collections run | A reference wrongly left weak loses the instance, and the state check fails rather than passing by luck |
| `memory_promote_after_collection` | Godot taking a reference again after the JVM instance was already collected | The one case promotion cannot serve is handled without a crash and without resurrecting a dead instance |
| `memory_godot_array_holds` | Objects owned only by a Godot array while the JVM drops its references | The JVM does not release what Godot still holds, and the same instance answers with its state intact |
| `memory_godot_new_hands_to_jvm` | Objects Godot creates through the script and hands to the JVM | Creation from that direction ends with the same single reference as creation from Kotlin |
| `memory_script_attach_detach` | A script attached to a live object and then removed | Attaching swaps in a script instance and removing it takes the instance away, neither leaking the object |
| `memory_script_replacement_link` | The wrapper that predates a script keeping the new script instance reachable | Replacing a script does not silently discard state the older wrapper can still reach |
| `memory_zombie_callable` | Signal connections to instances dropped immediately after connecting | The window where an object is alive natively but collected on the JVM stays harmless |
| `memory_resources` | Resource subclasses and engine resources | Resources follow the same rules as any other reference counted object |
| `memory_native_core_types` | Arrays, dictionaries, node paths, string names and packed arrays | The separate queue for core types drains too; it creates no Godot object at all, which is why it tolerates none |
| `memory_burst` | A hundred thousand wrappers dropped in one frame | The throttle spreads the work over frames instead of stalling one, and still finishes |
| `memory_redeliver_pending` | The same objects fetched again while their release is pending | A delivery landing in the release window hands the reference to the new wrapper rather than losing it |
| `memory_refcount_ledger` | The exact reference count as ownership moves between Godot and the JVM | One owner means one reference, the invariant the whole model rests on |
| `memory_object_freed_while_held` | Plain objects freed explicitly while the JVM still holds wrappers | Those wrappers report themselves invalid rather than pointing at nothing |
| `memory_engine_side_destruction` | Nodes destroyed by the engine rather than by the JVM | The binding follows a destruction it did not initiate |
| `memory_fuzz` | Random sequences of the operations above from a fixed seed | Combinations the targeted tests do not cover, reproducible from the seed |

### Performance

Only a script instance has a JNI reference that is promoted and demoted, so every test about that mechanism uses a
script class. Each one ends on a synchronization, which leaves the instances weak again, so the next call performs
exactly one transition per object by construction and the reported figure is a true per transition cost.

| Test | Measures | To what end |
|---|---|---|
| `perf_noop` | A call that does nothing | The floor every other number sits on, calibrated once per run |
| `perf_icall` | A trivial engine call | A general regression guard, unrelated to memory |
| `perf_deliver_random` | Reading already wrapped objects out of a Godot array in random order | The delivery hot path, which a memory model must leave untouched |
| `perf_create_ref_counted`, `perf_create_item`, `perf_create_node` | Creating each of the three kinds of object | Where a model moves cost into creation, as holding two references from the start does |
| `perf_transition_pair` | One promotion and one demotion per object | The headline cost of the mechanism, and the number a cheaper reference representation moves |
| `perf_promote_only` | The promotion half alone | Promotion and demotion are not symmetric, and a model can improve one without the other |
| `perf_hot_set_cycles` | The same objects touched in every cycle | The case a model that skips or suppresses demotions is built for |
| `perf_mixed_hot_cold` | A tenth of the objects hot, the rest quiet after one cycle | Whether that saving survives a realistic mix, or only appears when everything is hot |
| `perf_sync_empty` | A synchronization with nothing to do | The fixed cost contained in every other synchronization number |

`exportStressTests` exports the project for the host OS, so the same runner can be started against the template
libraries with `-s res://runner/StressRunner.gd`.
