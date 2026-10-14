using System;
using System.Runtime;
using Godot.Collections;

/// <summary>
/// Counts every call the engine makes into the scene's scripts: physics steps, signal handlers, draws, deferred calls
/// and timer lambdas. The game is deterministic, so two runs with the same settings make exactly the same calls, in
/// either language.
/// </summary>
public static class ScriptCalls
{
    public static long Count;
}

/// <summary>
/// The .NET runtime's counters, read at the start and the end of the measured frames, under the same names as the
/// JVM's so the runner reports both alike.
/// </summary>
public static class RuntimeCounters
{
    public static Dictionary<string, long> Snapshot() => new()
    {
        ["available"] = 1,
        // The main thread only: it runs every script call, and other threads' allocations are not the scene's.
        ["allocated_bytes"] = GC.GetAllocatedBytesForCurrentThread(),
        // Every collection includes generation 0, so its count is the number of collections.
        ["gc_count"] = GC.CollectionCount(0),
        ["gc_time_ms"] = (long)GC.GetTotalPauseDuration().TotalMilliseconds,
        ["jit_time_ms"] = (long)JitInfo.GetCompilationTime().TotalMilliseconds,
        ["script_calls"] = ScriptCalls.Count,
    };

    public static string CollectorNames() =>
        (GCSettings.IsServerGC ? ".NET server GC" : ".NET workstation GC") + $", {GCSettings.LatencyMode}";
}
